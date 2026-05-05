/*     */ package net.minecraftforge.fluids;
/*     */ 
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.MathHelper;
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
/*     */ 
/*     */ public class BlockFluidFinite
/*     */   extends BlockFluidBase
/*     */ {
/*     */   public BlockFluidFinite(Fluid fluid, Material material) {
/*  24 */     super(fluid, material);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getQuantaValue(IBlockAccess world, int x, int y, int z) {
/*  30 */     if (world.getBlock(x, y, z).isAir(world, x, y, z))
/*     */     {
/*  32 */       return 0;
/*     */     }
/*     */     
/*  35 */     if (world.getBlock(x, y, z) != this)
/*     */     {
/*  37 */       return -1;
/*     */     }
/*     */     
/*  40 */     int quantaRemaining = world.getBlockMetadata(x, y, z) + 1;
/*  41 */     return quantaRemaining;
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
/*  52 */     return (fullHit && meta == this.quantaPerBlock - 1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxRenderHeightMeta() {
/*  58 */     return this.quantaPerBlock - 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateTick(World world, int x, int y, int z, Random rand) {
/*  67 */     boolean changed = false;
/*  68 */     int quantaRemaining = world.getBlockMetadata(x, y, z) + 1;
/*     */ 
/*     */     
/*  71 */     int prevRemaining = quantaRemaining;
/*  72 */     quantaRemaining = tryToFlowVerticallyInto(world, x, y, z, quantaRemaining);
/*     */     
/*  74 */     if (quantaRemaining < 1) {
/*     */       return;
/*     */     }
/*     */     
/*  78 */     if (quantaRemaining != prevRemaining) {
/*     */       
/*  80 */       changed = true;
/*  81 */       if (quantaRemaining == 1) {
/*     */         
/*  83 */         world.setBlockMetadataWithNotify(x, y, z, quantaRemaining - 1, 2);
/*     */         
/*     */         return;
/*     */       } 
/*  87 */     } else if (quantaRemaining == 1) {
/*     */       return;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  93 */     int lowerthan = quantaRemaining - 1;
/*  94 */     if (displaceIfPossible(world, x, y, z - 1)) world.setBlock(x, y, z - 1, Blocks.air); 
/*  95 */     if (displaceIfPossible(world, x, y, z + 1)) world.setBlock(x, y, z + 1, Blocks.air); 
/*  96 */     if (displaceIfPossible(world, x - 1, y, z)) world.setBlock(x - 1, y, z, Blocks.air); 
/*  97 */     if (displaceIfPossible(world, x + 1, y, z)) world.setBlock(x + 1, y, z, Blocks.air); 
/*  98 */     int north = getQuantaValueBelow((IBlockAccess)world, x, y, z - 1, lowerthan);
/*  99 */     int south = getQuantaValueBelow((IBlockAccess)world, x, y, z + 1, lowerthan);
/* 100 */     int west = getQuantaValueBelow((IBlockAccess)world, x - 1, y, z, lowerthan);
/* 101 */     int east = getQuantaValueBelow((IBlockAccess)world, x + 1, y, z, lowerthan);
/* 102 */     int total = quantaRemaining;
/* 103 */     int count = 1;
/*     */     
/* 105 */     if (north >= 0) {
/*     */       
/* 107 */       count++;
/* 108 */       total += north;
/*     */     } 
/*     */     
/* 111 */     if (south >= 0) {
/*     */       
/* 113 */       count++;
/* 114 */       total += south;
/*     */     } 
/*     */     
/* 117 */     if (west >= 0) {
/*     */       
/* 119 */       count++;
/* 120 */       total += west;
/*     */     } 
/*     */     
/* 123 */     if (east >= 0) {
/*     */       
/* 125 */       count++;
/* 126 */       total += east;
/*     */     } 
/*     */     
/* 129 */     if (count == 1) {
/*     */       
/* 131 */       if (changed)
/*     */       {
/* 133 */         world.setBlockMetadataWithNotify(x, y, z, quantaRemaining - 1, 2);
/*     */       }
/*     */       
/*     */       return;
/*     */     } 
/* 138 */     int each = total / count;
/* 139 */     int rem = total % count;
/* 140 */     if (north >= 0) {
/*     */       
/* 142 */       int newnorth = each;
/* 143 */       if (rem == count || (rem > 1 && rand.nextInt(count - rem) != 0)) {
/*     */         
/* 145 */         newnorth++;
/* 146 */         rem--;
/*     */       } 
/*     */       
/* 149 */       if (newnorth != north) {
/*     */         
/* 151 */         if (newnorth == 0) {
/*     */           
/* 153 */           world.setBlock(x, y, z - 1, Blocks.air);
/*     */         }
/*     */         else {
/*     */           
/* 157 */           world.setBlock(x, y, z - 1, this, newnorth - 1, 2);
/*     */         } 
/* 159 */         world.scheduleBlockUpdate(x, y, z - 1, this, this.tickRate);
/*     */       } 
/* 161 */       count--;
/*     */     } 
/*     */     
/* 164 */     if (south >= 0) {
/*     */       
/* 166 */       int newsouth = each;
/* 167 */       if (rem == count || (rem > 1 && rand.nextInt(count - rem) != 0)) {
/*     */         
/* 169 */         newsouth++;
/* 170 */         rem--;
/*     */       } 
/*     */       
/* 173 */       if (newsouth != south) {
/*     */         
/* 175 */         if (newsouth == 0) {
/*     */           
/* 177 */           world.setBlock(x, y, z + 1, Blocks.air);
/*     */         }
/*     */         else {
/*     */           
/* 181 */           world.setBlock(x, y, z + 1, this, newsouth - 1, 2);
/*     */         } 
/* 183 */         world.scheduleBlockUpdate(x, y, z + 1, this, this.tickRate);
/*     */       } 
/* 185 */       count--;
/*     */     } 
/*     */     
/* 188 */     if (west >= 0) {
/*     */       
/* 190 */       int newwest = each;
/* 191 */       if (rem == count || (rem > 1 && rand.nextInt(count - rem) != 0)) {
/*     */         
/* 193 */         newwest++;
/* 194 */         rem--;
/*     */       } 
/* 196 */       if (newwest != west) {
/*     */         
/* 198 */         if (newwest == 0) {
/*     */           
/* 200 */           world.setBlock(x - 1, y, z, Blocks.air);
/*     */         }
/*     */         else {
/*     */           
/* 204 */           world.setBlock(x - 1, y, z, this, newwest - 1, 2);
/*     */         } 
/* 206 */         world.scheduleBlockUpdate(x - 1, y, z, this, this.tickRate);
/*     */       } 
/* 208 */       count--;
/*     */     } 
/*     */     
/* 211 */     if (east >= 0) {
/*     */       
/* 213 */       int neweast = each;
/* 214 */       if (rem == count || (rem > 1 && rand.nextInt(count - rem) != 0)) {
/*     */         
/* 216 */         neweast++;
/* 217 */         rem--;
/*     */       } 
/*     */       
/* 220 */       if (neweast != east) {
/*     */         
/* 222 */         if (neweast == 0) {
/*     */           
/* 224 */           world.setBlock(x + 1, y, z, Blocks.air);
/*     */         }
/*     */         else {
/*     */           
/* 228 */           world.setBlock(x + 1, y, z, this, neweast - 1, 2);
/*     */         } 
/* 230 */         world.scheduleBlockUpdate(x + 1, y, z, this, this.tickRate);
/*     */       } 
/* 232 */       count--;
/*     */     } 
/*     */     
/* 235 */     if (rem > 0)
/*     */     {
/* 237 */       each++;
/*     */     }
/* 239 */     world.setBlockMetadataWithNotify(x, y, z, each - 1, 2);
/*     */   }
/*     */ 
/*     */   
/*     */   public int tryToFlowVerticallyInto(World world, int x, int y, int z, int amtToInput) {
/* 244 */     int otherY = y + this.densityDir;
/* 245 */     if (otherY < 0 || otherY >= world.getHeight()) {
/*     */       
/* 247 */       world.setBlock(x, y, z, Blocks.air);
/* 248 */       return 0;
/*     */     } 
/*     */     
/* 251 */     int amt = getQuantaValueBelow((IBlockAccess)world, x, otherY, z, this.quantaPerBlock);
/* 252 */     if (amt >= 0) {
/*     */       
/* 254 */       amt += amtToInput;
/* 255 */       if (amt > this.quantaPerBlock) {
/*     */         
/* 257 */         world.setBlock(x, otherY, z, this, this.quantaPerBlock - 1, 3);
/* 258 */         world.scheduleBlockUpdate(x, otherY, z, this, this.tickRate);
/* 259 */         return amt - this.quantaPerBlock;
/*     */       } 
/* 261 */       if (amt > 0) {
/*     */         
/* 263 */         world.setBlock(x, otherY, z, this, amt - 1, 3);
/* 264 */         world.scheduleBlockUpdate(x, otherY, z, this, this.tickRate);
/* 265 */         world.setBlock(x, y, z, Blocks.air);
/* 266 */         return 0;
/*     */       } 
/* 268 */       return amtToInput;
/*     */     } 
/*     */ 
/*     */     
/* 272 */     int density_other = getDensity((IBlockAccess)world, x, otherY, z);
/* 273 */     if (density_other == Integer.MAX_VALUE) {
/*     */       
/* 275 */       if (displaceIfPossible(world, x, otherY, z)) {
/*     */         
/* 277 */         world.setBlock(x, otherY, z, this, amtToInput - 1, 3);
/* 278 */         world.scheduleBlockUpdate(x, otherY, z, this, this.tickRate);
/* 279 */         world.setBlock(x, y, z, Blocks.air);
/* 280 */         return 0;
/*     */       } 
/*     */ 
/*     */       
/* 284 */       return amtToInput;
/*     */     } 
/*     */ 
/*     */     
/* 288 */     if (this.densityDir < 0) {
/*     */       
/* 290 */       if (density_other < this.density)
/*     */       {
/* 292 */         BlockFluidBase block = (BlockFluidBase)world.getBlock(x, otherY, z);
/* 293 */         int otherData = world.getBlockMetadata(x, otherY, z);
/* 294 */         world.setBlock(x, otherY, z, this, amtToInput - 1, 3);
/* 295 */         world.setBlock(x, y, z, block, otherData, 3);
/* 296 */         world.scheduleBlockUpdate(x, otherY, z, this, this.tickRate);
/* 297 */         world.scheduleBlockUpdate(x, y, z, block, block.tickRate(world));
/* 298 */         return 0;
/*     */       
/*     */       }
/*     */     
/*     */     }
/* 303 */     else if (density_other > this.density) {
/*     */       
/* 305 */       BlockFluidBase block = (BlockFluidBase)world.getBlock(x, otherY, z);
/* 306 */       int otherData = world.getBlockMetadata(x, otherY, z);
/* 307 */       world.setBlock(x, otherY, z, this, amtToInput - 1, 3);
/* 308 */       world.setBlock(x, y, z, block, otherData, 3);
/* 309 */       world.scheduleBlockUpdate(x, otherY, z, this, this.tickRate);
/* 310 */       world.scheduleBlockUpdate(x, y, z, block, block.tickRate(world));
/* 311 */       return 0;
/*     */     } 
/*     */     
/* 314 */     return amtToInput;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FluidStack drain(World world, int x, int y, int z, boolean doDrain) {
/* 322 */     if (doDrain)
/*     */     {
/* 324 */       world.setBlock(x, y, z, Blocks.air);
/*     */     }
/*     */     
/* 327 */     return new FluidStack(getFluid(), 
/* 328 */         MathHelper.floor_float(getQuantaPercentage((IBlockAccess)world, x, y, z) * 1000.0F));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canDrain(World world, int x, int y, int z) {
/* 334 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\fluids\BlockFluidFinite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */