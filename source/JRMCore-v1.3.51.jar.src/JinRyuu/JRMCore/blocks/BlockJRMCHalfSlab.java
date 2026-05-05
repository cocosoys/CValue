/*     */ package JinRyuu.JRMCore.blocks;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public abstract class BlockJRMCHalfSlab
/*     */   extends Block
/*     */ {
/*     */   protected final boolean isDoubleSlab;
/*     */   
/*     */   public BlockJRMCHalfSlab(boolean par2, Material par3Material) {
/*  19 */     super(par3Material);
/*  20 */     this.isDoubleSlab = par2;
/*     */     
/*  22 */     if (!par2)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  28 */       func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
/*  39 */     if (this.isDoubleSlab) {
/*     */       
/*  41 */       func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*     */     }
/*     */     else {
/*     */       
/*  45 */       boolean flag = ((par1IBlockAccess.func_72805_g(par2, par3, par4) & 0x8) != 0);
/*     */       
/*  47 */       if (flag) {
/*     */         
/*  49 */         func_149676_a(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
/*     */       }
/*     */       else {
/*     */         
/*  53 */         func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149683_g() {
/*  63 */     if (this.isDoubleSlab) {
/*     */       
/*  65 */       func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*     */     }
/*     */     else {
/*     */       
/*  69 */       func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149743_a(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity) {
/*  79 */     func_149719_a((IBlockAccess)par1World, par2, par3, par4);
/*  80 */     super.func_149743_a(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  89 */     return this.isDoubleSlab;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149660_a(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9) {
/*  97 */     return this.isDoubleSlab ? par9 : ((par5 != 0 && (par5 == 1 || par7 <= 0.5D)) ? par9 : (par9 | 0x8));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149745_a(Random par1Random) {
/* 105 */     return this.isDoubleSlab ? 2 : 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149692_a(int par1) {
/* 113 */     return par1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/* 121 */     return this.isDoubleSlab;
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
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract String getFullSlabName(int paramInt);
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
/*     */ 
/*     */   
/*     */   public int func_149643_k(World par1World, int par2, int par3, int par4) {
/* 170 */     return super.func_149643_k(par1World, par2, par3, par4) & 0x7;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\blocks\BlockJRMCHalfSlab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */