/*     */ package net.minecraftforge.fluids;
/*     */ 
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.init.Blocks;
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
/*     */ public class BlockFluidClassic
/*     */   extends BlockFluidBase
/*     */ {
/*  21 */   protected boolean[] isOptimalFlowDirection = new boolean[4];
/*  22 */   protected int[] flowCost = new int[4];
/*     */   
/*     */   protected FluidStack stack;
/*     */   
/*     */   public BlockFluidClassic(Fluid fluid, Material material) {
/*  27 */     super(fluid, material);
/*  28 */     this.stack = new FluidStack(fluid, 1000);
/*     */   }
/*     */ 
/*     */   
/*     */   public BlockFluidClassic setFluidStack(FluidStack stack) {
/*  33 */     this.stack = stack;
/*  34 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public BlockFluidClassic setFluidStackAmount(int amount) {
/*  39 */     this.stack.amount = amount;
/*  40 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getQuantaValue(IBlockAccess world, int x, int y, int z) {
/*  46 */     if (world.getBlock(x, y, z) == Blocks.air)
/*     */     {
/*  48 */       return 0;
/*     */     }
/*     */     
/*  51 */     if (world.getBlock(x, y, z) != this)
/*     */     {
/*  53 */       return -1;
/*     */     }
/*     */     
/*  56 */     int quantaRemaining = this.quantaPerBlock - world.getBlockMetadata(x, y, z);
/*  57 */     return quantaRemaining;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canCollideCheck(int meta, boolean fullHit) {
/*  68 */     return (fullHit && meta == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxRenderHeightMeta() {
/*  74 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLightValue(IBlockAccess world, int x, int y, int z) {
/*  80 */     if (this.maxScaledLight == 0)
/*     */     {
/*  82 */       return super.getLightValue(world, x, y, z);
/*     */     }
/*  84 */     int data = this.quantaPerBlock - world.getBlockMetadata(x, y, z) - 1;
/*  85 */     return (int)(data / this.quantaPerBlockFloat * this.maxScaledLight);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateTick(World world, int x, int y, int z, Random rand) {
/*  94 */     int quantaRemaining = this.quantaPerBlock - world.getBlockMetadata(x, y, z);
/*  95 */     int expQuanta = -101;
/*     */ 
/*     */     
/*  98 */     if (quantaRemaining < this.quantaPerBlock) {
/*     */       
/* 100 */       int y2 = y - this.densityDir;
/*     */       
/* 102 */       if (world.getBlock(x, y2, z) == this || world
/* 103 */         .getBlock(x - 1, y2, z) == this || world
/* 104 */         .getBlock(x + 1, y2, z) == this || world
/* 105 */         .getBlock(x, y2, z - 1) == this || world
/* 106 */         .getBlock(x, y2, z + 1) == this) {
/*     */         
/* 108 */         expQuanta = this.quantaPerBlock - 1;
/*     */       }
/*     */       else {
/*     */         
/* 112 */         int maxQuanta = -100;
/* 113 */         maxQuanta = getLargerQuanta((IBlockAccess)world, x - 1, y, z, maxQuanta);
/* 114 */         maxQuanta = getLargerQuanta((IBlockAccess)world, x + 1, y, z, maxQuanta);
/* 115 */         maxQuanta = getLargerQuanta((IBlockAccess)world, x, y, z - 1, maxQuanta);
/* 116 */         maxQuanta = getLargerQuanta((IBlockAccess)world, x, y, z + 1, maxQuanta);
/*     */         
/* 118 */         expQuanta = maxQuanta - 1;
/*     */       } 
/*     */ 
/*     */       
/* 122 */       if (expQuanta != quantaRemaining)
/*     */       {
/* 124 */         quantaRemaining = expQuanta;
/*     */         
/* 126 */         if (expQuanta <= 0)
/*     */         {
/* 128 */           world.setBlock(x, y, z, Blocks.air);
/*     */         }
/*     */         else
/*     */         {
/* 132 */           world.setBlockMetadataWithNotify(x, y, z, this.quantaPerBlock - expQuanta, 3);
/* 133 */           world.scheduleBlockUpdate(x, y, z, this, this.tickRate);
/* 134 */           world.notifyBlocksOfNeighborChange(x, y, z, this);
/*     */         }
/*     */       
/*     */       }
/*     */     
/* 139 */     } else if (quantaRemaining >= this.quantaPerBlock) {
/*     */       
/* 141 */       world.setBlockMetadataWithNotify(x, y, z, 0, 2);
/*     */     } 
/*     */ 
/*     */     
/* 145 */     if (canDisplace((IBlockAccess)world, x, y + this.densityDir, z)) {
/*     */       
/* 147 */       flowIntoBlock(world, x, y + this.densityDir, z, 1);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 152 */     int flowMeta = this.quantaPerBlock - quantaRemaining + 1;
/* 153 */     if (flowMeta >= this.quantaPerBlock) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 158 */     if (isSourceBlock((IBlockAccess)world, x, y, z) || !isFlowingVertically((IBlockAccess)world, x, y, z)) {
/*     */       
/* 160 */       if (world.getBlock(x, y - this.densityDir, z) == this)
/*     */       {
/* 162 */         flowMeta = 1;
/*     */       }
/* 164 */       boolean[] flowTo = getOptimalFlowDirections(world, x, y, z);
/*     */       
/* 166 */       if (flowTo[0]) flowIntoBlock(world, x - 1, y, z, flowMeta); 
/* 167 */       if (flowTo[1]) flowIntoBlock(world, x + 1, y, z, flowMeta); 
/* 168 */       if (flowTo[2]) flowIntoBlock(world, x, y, z - 1, flowMeta); 
/* 169 */       if (flowTo[3]) flowIntoBlock(world, x, y, z + 1, flowMeta);
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isFlowingVertically(IBlockAccess world, int x, int y, int z) {
/* 175 */     return (world.getBlock(x, y + this.densityDir, z) == this || (world
/* 176 */       .getBlock(x, y, z) == this && canFlowInto(world, x, y + this.densityDir, z)));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isSourceBlock(IBlockAccess world, int x, int y, int z) {
/* 181 */     return (world.getBlock(x, y, z) == this && world.getBlockMetadata(x, y, z) == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean[] getOptimalFlowDirections(World world, int x, int y, int z) {
/* 186 */     for (int side = 0; side < 4; side++) {
/*     */       
/* 188 */       this.flowCost[side] = 1000;
/*     */       
/* 190 */       int x2 = x;
/* 191 */       int y2 = y;
/* 192 */       int z2 = z;
/*     */       
/* 194 */       switch (side) {
/*     */         case 0:
/* 196 */           x2--; break;
/* 197 */         case 1: x2++; break;
/* 198 */         case 2: z2--; break;
/* 199 */         case 3: z2++;
/*     */           break;
/*     */       } 
/* 202 */       if (canFlowInto((IBlockAccess)world, x2, y2, z2) && !isSourceBlock((IBlockAccess)world, x2, y2, z2))
/*     */       {
/*     */ 
/*     */ 
/*     */         
/* 207 */         if (canFlowInto((IBlockAccess)world, x2, y2 + this.densityDir, z2)) {
/*     */           
/* 209 */           this.flowCost[side] = 0;
/*     */         }
/*     */         else {
/*     */           
/* 213 */           this.flowCost[side] = calculateFlowCost(world, x2, y2, z2, 1, side);
/*     */         } 
/*     */       }
/*     */     } 
/* 217 */     int min = this.flowCost[0]; int i;
/* 218 */     for (i = 1; i < 4; i++) {
/*     */       
/* 220 */       if (this.flowCost[i] < min)
/*     */       {
/* 222 */         min = this.flowCost[i];
/*     */       }
/*     */     } 
/* 225 */     for (i = 0; i < 4; i++)
/*     */     {
/* 227 */       this.isOptimalFlowDirection[i] = (this.flowCost[i] == min);
/*     */     }
/* 229 */     return this.isOptimalFlowDirection;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int calculateFlowCost(World world, int x, int y, int z, int recurseDepth, int side) {
/* 234 */     int cost = 1000;
/* 235 */     for (int adjSide = 0; adjSide < 4; adjSide++) {
/*     */       
/* 237 */       if ((adjSide != 0 || side != 1) && (adjSide != 1 || side != 0) && (adjSide != 2 || side != 3) && (adjSide != 3 || side != 2)) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 245 */         int x2 = x;
/* 246 */         int y2 = y;
/* 247 */         int z2 = z;
/*     */         
/* 249 */         switch (adjSide) {
/*     */           case 0:
/* 251 */             x2--; break;
/* 252 */           case 1: x2++; break;
/* 253 */           case 2: z2--; break;
/* 254 */           case 3: z2++;
/*     */             break;
/*     */         } 
/* 257 */         if (canFlowInto((IBlockAccess)world, x2, y2, z2) && !isSourceBlock((IBlockAccess)world, x2, y2, z2)) {
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 262 */           if (canFlowInto((IBlockAccess)world, x2, y2 + this.densityDir, z2))
/*     */           {
/* 264 */             return recurseDepth;
/*     */           }
/*     */           
/* 267 */           if (recurseDepth < 4)
/*     */           
/*     */           { 
/*     */ 
/*     */             
/* 272 */             int min = calculateFlowCost(world, x2, y2, z2, recurseDepth + 1, adjSide);
/* 273 */             if (min < cost)
/*     */             {
/* 275 */               cost = min; }  } 
/*     */         } 
/*     */       } 
/* 278 */     }  return cost;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void flowIntoBlock(World world, int x, int y, int z, int meta) {
/* 283 */     if (meta < 0)
/* 284 */       return;  if (displaceIfPossible(world, x, y, z))
/*     */     {
/* 286 */       world.setBlock(x, y, z, this, meta, 3);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean canFlowInto(IBlockAccess world, int x, int y, int z) {
/* 292 */     if (world.getBlock(x, y, z).isAir(world, x, y, z)) return true;
/*     */     
/* 294 */     Block block = world.getBlock(x, y, z);
/* 295 */     if (block == this)
/*     */     {
/* 297 */       return true;
/*     */     }
/*     */     
/* 300 */     if (this.displacements.containsKey(block))
/*     */     {
/* 302 */       return ((Boolean)this.displacements.get(block)).booleanValue();
/*     */     }
/*     */     
/* 305 */     Material material = block.getMaterial();
/* 306 */     if (material.blocksMovement() || material == Material.water || material == Material.lava || material == Material.portal)
/*     */     {
/*     */ 
/*     */ 
/*     */       
/* 311 */       return false;
/*     */     }
/*     */     
/* 314 */     int density = getDensity(world, x, y, z);
/* 315 */     if (density == Integer.MAX_VALUE)
/*     */     {
/* 317 */       return true;
/*     */     }
/*     */     
/* 320 */     if (this.density > density)
/*     */     {
/* 322 */       return true;
/*     */     }
/*     */ 
/*     */     
/* 326 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected int getLargerQuanta(IBlockAccess world, int x, int y, int z, int compare) {
/* 332 */     int quantaRemaining = getQuantaValue(world, x, y, z);
/* 333 */     if (quantaRemaining <= 0)
/*     */     {
/* 335 */       return compare;
/*     */     }
/* 337 */     return (quantaRemaining >= compare) ? quantaRemaining : compare;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FluidStack drain(World world, int x, int y, int z, boolean doDrain) {
/* 344 */     if (!isSourceBlock((IBlockAccess)world, x, y, z))
/*     */     {
/* 346 */       return null;
/*     */     }
/*     */     
/* 349 */     if (doDrain)
/*     */     {
/* 351 */       world.setBlock(x, y, z, Blocks.air);
/*     */     }
/*     */     
/* 354 */     return this.stack.copy();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canDrain(World world, int x, int y, int z) {
/* 360 */     return isSourceBlock((IBlockAccess)world, x, y, z);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\fluids\BlockFluidClassic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */