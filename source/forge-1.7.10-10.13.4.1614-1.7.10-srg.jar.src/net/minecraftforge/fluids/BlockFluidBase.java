/*     */ package net.minecraftforge.fluids;
/*     */ 
/*     */ import com.google.common.collect.Maps;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class BlockFluidBase
/*     */   extends Block
/*     */   implements IFluidBlock
/*     */ {
/*  29 */   protected static final Map<Block, Boolean> defaultDisplacements = Maps.newHashMap();
/*     */ 
/*     */   
/*     */   static {
/*  33 */     defaultDisplacements.put(Blocks.wooden_door, Boolean.valueOf(false));
/*  34 */     defaultDisplacements.put(Blocks.iron_door, Boolean.valueOf(false));
/*  35 */     defaultDisplacements.put(Blocks.standing_sign, Boolean.valueOf(false));
/*  36 */     defaultDisplacements.put(Blocks.wall_sign, Boolean.valueOf(false));
/*  37 */     defaultDisplacements.put(Blocks.reeds, Boolean.valueOf(false));
/*     */   }
/*  39 */   protected Map<Block, Boolean> displacements = Maps.newHashMap();
/*     */   
/*  41 */   protected int quantaPerBlock = 8;
/*  42 */   protected float quantaPerBlockFloat = 8.0F;
/*  43 */   protected int density = 1;
/*  44 */   protected int densityDir = -1;
/*  45 */   protected int temperature = 300;
/*     */   
/*  47 */   protected int tickRate = 20;
/*  48 */   protected int renderPass = 1;
/*  49 */   protected int maxScaledLight = 0;
/*     */ 
/*     */ 
/*     */   
/*     */   protected final String fluidName;
/*     */ 
/*     */ 
/*     */   
/*     */   protected final Fluid definedFluid;
/*     */ 
/*     */ 
/*     */   
/*     */   public BlockFluidBase(Fluid fluid, Material material) {
/*  62 */     super(material);
/*  63 */     setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*  64 */     setTickRandomly(true);
/*  65 */     disableStats();
/*     */     
/*  67 */     this.fluidName = fluid.getName();
/*  68 */     this.density = fluid.density;
/*  69 */     this.temperature = fluid.temperature;
/*  70 */     this.maxScaledLight = fluid.luminosity;
/*  71 */     this.tickRate = fluid.viscosity / 200;
/*  72 */     this.densityDir = (fluid.density > 0) ? -1 : 1;
/*  73 */     fluid.setBlock(this);
/*     */     
/*  75 */     this.definedFluid = fluid;
/*  76 */     this.displacements.putAll(defaultDisplacements);
/*     */   }
/*     */ 
/*     */   
/*     */   public BlockFluidBase setQuantaPerBlock(int quantaPerBlock) {
/*  81 */     if (quantaPerBlock > 16 || quantaPerBlock < 1) quantaPerBlock = 8; 
/*  82 */     this.quantaPerBlock = quantaPerBlock;
/*  83 */     this.quantaPerBlockFloat = quantaPerBlock;
/*  84 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public BlockFluidBase setDensity(int density) {
/*  89 */     if (density == 0) density = 1; 
/*  90 */     this.density = density;
/*  91 */     this.densityDir = (density > 0) ? -1 : 1;
/*  92 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public BlockFluidBase setTemperature(int temperature) {
/*  97 */     this.temperature = temperature;
/*  98 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public BlockFluidBase setTickRate(int tickRate) {
/* 103 */     if (tickRate <= 0) tickRate = 20; 
/* 104 */     this.tickRate = tickRate;
/* 105 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public BlockFluidBase setRenderPass(int renderPass) {
/* 110 */     this.renderPass = renderPass;
/* 111 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public BlockFluidBase setMaxScaledLight(int maxScaledLight) {
/* 116 */     this.maxScaledLight = maxScaledLight;
/* 117 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
/* 125 */     if (world.getBlock(x, y, z).isAir(world, x, y, z)) return true;
/*     */     
/* 127 */     Block block = world.getBlock(x, y, z);
/*     */     
/* 129 */     if (block == this)
/*     */     {
/* 131 */       return false;
/*     */     }
/*     */     
/* 134 */     if (this.displacements.containsKey(block))
/*     */     {
/* 136 */       return ((Boolean)this.displacements.get(block)).booleanValue();
/*     */     }
/*     */     
/* 139 */     Material material = block.getMaterial();
/* 140 */     if (material.blocksMovement() || material == Material.portal)
/*     */     {
/* 142 */       return false;
/*     */     }
/*     */     
/* 145 */     int density = getDensity(world, x, y, z);
/* 146 */     if (density == Integer.MAX_VALUE)
/*     */     {
/* 148 */       return true;
/*     */     }
/*     */     
/* 151 */     if (this.density > density)
/*     */     {
/* 153 */       return true;
/*     */     }
/*     */ 
/*     */     
/* 157 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean displaceIfPossible(World world, int x, int y, int z) {
/* 166 */     if (world.getBlock(x, y, z).isAir((IBlockAccess)world, x, y, z))
/*     */     {
/* 168 */       return true;
/*     */     }
/*     */     
/* 171 */     Block block = world.getBlock(x, y, z);
/* 172 */     if (block == this)
/*     */     {
/* 174 */       return false;
/*     */     }
/*     */     
/* 177 */     if (this.displacements.containsKey(block)) {
/*     */       
/* 179 */       if (((Boolean)this.displacements.get(block)).booleanValue()) {
/*     */         
/* 181 */         block.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
/* 182 */         return true;
/*     */       } 
/* 184 */       return false;
/*     */     } 
/*     */     
/* 187 */     Material material = block.getMaterial();
/* 188 */     if (material.blocksMovement() || material == Material.portal)
/*     */     {
/* 190 */       return false;
/*     */     }
/*     */     
/* 193 */     int density = getDensity((IBlockAccess)world, x, y, z);
/* 194 */     if (density == Integer.MAX_VALUE) {
/*     */       
/* 196 */       block.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
/* 197 */       return true;
/*     */     } 
/*     */     
/* 200 */     if (this.density > density)
/*     */     {
/* 202 */       return true;
/*     */     }
/*     */ 
/*     */     
/* 206 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onBlockAdded(World world, int x, int y, int z) {
/* 229 */     world.scheduleBlockUpdate(x, y, z, this, this.tickRate);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
/* 239 */     world.scheduleBlockUpdate(x, y, z, this, this.tickRate);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149698_L() {
/* 246 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canPlaceBlockAt(World world, int x, int y, int z) {
/* 255 */     return canDisplace((IBlockAccess)world, x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getBlocksMovement(IBlockAccess world, int x, int y, int z) {
/* 261 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
/* 271 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Item getItemDropped(int par1, Random par2Random, int par3) {
/* 277 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int quantityDropped(Random par1Random) {
/* 286 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int tickRate(World world) {
/* 295 */     return this.tickRate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void velocityToAddToEntity(World world, int x, int y, int z, Entity entity, Vec3 vec) {
/* 304 */     if (this.densityDir > 0)
/* 305 */       return;  Vec3 vec_flow = getFlowVector((IBlockAccess)world, x, y, z);
/* 306 */     vec.xCoord += vec_flow.xCoord * (this.quantaPerBlock * 4);
/* 307 */     vec.yCoord += vec_flow.yCoord * (this.quantaPerBlock * 4);
/* 308 */     vec.zCoord += vec_flow.zCoord * (this.quantaPerBlock * 4);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLightValue(IBlockAccess world, int x, int y, int z) {
/* 314 */     if (this.maxScaledLight == 0)
/*     */     {
/* 316 */       return super.getLightValue(world, x, y, z);
/*     */     }
/* 318 */     int data = world.getBlockMetadata(x, y, z);
/* 319 */     return (int)(data / this.quantaPerBlockFloat * this.maxScaledLight);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRenderType() {
/* 328 */     return FluidRegistry.renderIdFluid;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isOpaqueCube() {
/* 338 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean renderAsNormalBlock() {
/* 347 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMixedBrightnessForBlock(IBlockAccess world, int x, int y, int z) {
/* 366 */     int lightThis = world.getLightBrightnessForSkyBlocks(x, y, z, 0);
/* 367 */     int lightUp = world.getLightBrightnessForSkyBlocks(x, y + 1, z, 0);
/* 368 */     int lightThisBase = lightThis & 0xFF;
/* 369 */     int lightUpBase = lightUp & 0xFF;
/* 370 */     int lightThisExt = lightThis >> 16 & 0xFF;
/* 371 */     int lightUpExt = lightUp >> 16 & 0xFF;
/* 372 */     return ((lightThisBase > lightUpBase) ? lightThisBase : lightUpBase) | ((lightThisExt > lightUpExt) ? lightThisExt : lightUpExt) << 16;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRenderBlockPass() {
/* 382 */     return this.renderPass;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side) {
/* 392 */     Block block = world.getBlock(x, y, z);
/* 393 */     if (block != this)
/*     */     {
/* 395 */       return !block.isOpaqueCube();
/*     */     }
/* 397 */     return (block.getMaterial() == getMaterial()) ? false : super.shouldSideBeRendered(world, x, y, z, side);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int getDensity(IBlockAccess world, int x, int y, int z) {
/* 403 */     Block block = world.getBlock(x, y, z);
/* 404 */     if (!(block instanceof BlockFluidBase))
/*     */     {
/* 406 */       return Integer.MAX_VALUE;
/*     */     }
/* 408 */     return ((BlockFluidBase)block).density;
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int getTemperature(IBlockAccess world, int x, int y, int z) {
/* 413 */     Block block = world.getBlock(x, y, z);
/* 414 */     if (!(block instanceof BlockFluidBase))
/*     */     {
/* 416 */       return Integer.MAX_VALUE;
/*     */     }
/* 418 */     return ((BlockFluidBase)block).temperature;
/*     */   }
/*     */ 
/*     */   
/*     */   public static double getFlowDirection(IBlockAccess world, int x, int y, int z) {
/* 423 */     Block block = world.getBlock(x, y, z);
/* 424 */     if (!block.getMaterial().isLiquid())
/*     */     {
/* 426 */       return -1000.0D;
/*     */     }
/* 428 */     Vec3 vec = ((BlockFluidBase)block).getFlowVector(world, x, y, z);
/* 429 */     return (vec.xCoord == 0.0D && vec.zCoord == 0.0D) ? -1000.0D : (Math.atan2(vec.zCoord, vec.xCoord) - 1.5707963267948966D);
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getQuantaValueBelow(IBlockAccess world, int x, int y, int z, int belowThis) {
/* 434 */     int quantaRemaining = getQuantaValue(world, x, y, z);
/* 435 */     if (quantaRemaining >= belowThis)
/*     */     {
/* 437 */       return -1;
/*     */     }
/* 439 */     return quantaRemaining;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getQuantaValueAbove(IBlockAccess world, int x, int y, int z, int aboveThis) {
/* 444 */     int quantaRemaining = getQuantaValue(world, x, y, z);
/* 445 */     if (quantaRemaining <= aboveThis)
/*     */     {
/* 447 */       return -1;
/*     */     }
/* 449 */     return quantaRemaining;
/*     */   }
/*     */ 
/*     */   
/*     */   public final float getQuantaPercentage(IBlockAccess world, int x, int y, int z) {
/* 454 */     int quantaRemaining = getQuantaValue(world, x, y, z);
/* 455 */     return quantaRemaining / this.quantaPerBlockFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public Vec3 getFlowVector(IBlockAccess world, int x, int y, int z) {
/* 460 */     Vec3 vec = Vec3.createVectorHelper(0.0D, 0.0D, 0.0D);
/* 461 */     int decay = this.quantaPerBlock - getQuantaValue(world, x, y, z);
/*     */     
/* 463 */     for (int side = 0; side < 4; side++) {
/*     */       
/* 465 */       int x2 = x;
/* 466 */       int z2 = z;
/*     */       
/* 468 */       switch (side) {
/*     */         case 0:
/* 470 */           x2--; break;
/* 471 */         case 1: z2--; break;
/* 472 */         case 2: x2++; break;
/* 473 */         case 3: z2++;
/*     */           break;
/*     */       } 
/* 476 */       int otherDecay = this.quantaPerBlock - getQuantaValue(world, x2, y, z2);
/* 477 */       if (otherDecay >= this.quantaPerBlock) {
/*     */         
/* 479 */         if (!world.getBlock(x2, y, z2).getMaterial().blocksMovement()) {
/*     */           
/* 481 */           otherDecay = this.quantaPerBlock - getQuantaValue(world, x2, y - 1, z2);
/* 482 */           if (otherDecay >= 0)
/*     */           {
/* 484 */             int power = otherDecay - decay - this.quantaPerBlock;
/* 485 */             vec = vec.addVector(((x2 - x) * power), ((y - y) * power), ((z2 - z) * power));
/*     */           }
/*     */         
/*     */         } 
/* 489 */       } else if (otherDecay >= 0) {
/*     */         
/* 491 */         int power = otherDecay - decay;
/* 492 */         vec = vec.addVector(((x2 - x) * power), ((y - y) * power), ((z2 - z) * power));
/*     */       } 
/*     */     } 
/*     */     
/* 496 */     if (world.getBlock(x, y + 1, z) == this) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 506 */       boolean flag = (isBlockSolid(world, x, y, z - 1, 2) || isBlockSolid(world, x, y, z + 1, 3) || isBlockSolid(world, x - 1, y, z, 4) || isBlockSolid(world, x + 1, y, z, 5) || isBlockSolid(world, x, y + 1, z - 1, 2) || isBlockSolid(world, x, y + 1, z + 1, 3) || isBlockSolid(world, x - 1, y + 1, z, 4) || isBlockSolid(world, x + 1, y + 1, z, 5));
/*     */       
/* 508 */       if (flag)
/*     */       {
/* 510 */         vec = vec.normalize().addVector(0.0D, -6.0D, 0.0D);
/*     */       }
/*     */     } 
/* 513 */     vec = vec.normalize();
/* 514 */     return vec;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Fluid getFluid() {
/* 521 */     return FluidRegistry.getFluid(this.fluidName);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getFilledPercentage(World world, int x, int y, int z) {
/* 527 */     int quantaRemaining = getQuantaValue((IBlockAccess)world, x, y, z) + 1;
/* 528 */     float remaining = quantaRemaining / this.quantaPerBlockFloat;
/* 529 */     if (remaining > 1.0F) remaining = 1.0F; 
/* 530 */     return remaining * ((this.density > 0) ? true : -1);
/*     */   }
/*     */   
/*     */   public abstract int getQuantaValue(IBlockAccess paramIBlockAccess, int paramInt1, int paramInt2, int paramInt3);
/*     */   
/*     */   public abstract boolean canCollideCheck(int paramInt, boolean paramBoolean);
/*     */   
/*     */   public abstract int getMaxRenderHeightMeta();
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\fluids\BlockFluidBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */