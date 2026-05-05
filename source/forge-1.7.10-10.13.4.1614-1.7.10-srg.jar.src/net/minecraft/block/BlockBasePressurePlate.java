/*     */ package net.minecraft.block;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public abstract class BlockBasePressurePlate extends Block {
/*     */   private String field_150067_a;
/*     */   
/*     */   protected BlockBasePressurePlate(String p_i45387_1_, Material p_i45387_2_) {
/*  18 */     super(p_i45387_2_);
/*  19 */     this.field_150067_a = p_i45387_1_;
/*  20 */     func_149647_a(CreativeTabs.field_78028_d);
/*  21 */     func_149675_a(true);
/*  22 */     func_150063_b(func_150066_d(15));
/*     */   }
/*     */   private static final String __OBFID = "CL_00000194";
/*     */   
/*     */   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
/*  27 */     func_150063_b(p_149719_1_.func_72805_g(p_149719_2_, p_149719_3_, p_149719_4_));
/*     */   }
/*     */   
/*     */   protected void func_150063_b(int p_150063_1_) {
/*  31 */     boolean bool = (func_150060_c(p_150063_1_) > 0) ? true : false;
/*  32 */     float f = 0.0625F;
/*     */     
/*  34 */     if (bool) {
/*  35 */       func_149676_a(f, 0.0F, f, 1.0F - f, 0.03125F, 1.0F - f);
/*     */     } else {
/*  37 */       func_149676_a(f, 0.0F, f, 1.0F - f, 0.0625F, 1.0F - f);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149738_a(World p_149738_1_) {
/*  43 */     return 20;
/*     */   }
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
/*  48 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  53 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/*  62 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149655_b(IBlockAccess p_149655_1_, int p_149655_2_, int p_149655_3_, int p_149655_4_) {
/*  67 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149742_c(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_) {
/*  72 */     return (World.func_147466_a((IBlockAccess)p_149742_1_, p_149742_2_, p_149742_3_ - 1, p_149742_4_) || BlockFence.func_149825_a(p_149742_1_.func_147439_a(p_149742_2_, p_149742_3_ - 1, p_149742_4_)));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
/*  77 */     boolean bool = false;
/*     */     
/*  79 */     if (!World.func_147466_a((IBlockAccess)p_149695_1_, p_149695_2_, p_149695_3_ - 1, p_149695_4_) && !BlockFence.func_149825_a(p_149695_1_.func_147439_a(p_149695_2_, p_149695_3_ - 1, p_149695_4_))) bool = true;
/*     */     
/*  81 */     if (bool) {
/*  82 */       func_149697_b(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, p_149695_1_.func_72805_g(p_149695_2_, p_149695_3_, p_149695_4_), 0);
/*  83 */       p_149695_1_.func_147468_f(p_149695_2_, p_149695_3_, p_149695_4_);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
/*  89 */     if (p_149674_1_.field_72995_K)
/*  90 */       return;  int i = func_150060_c(p_149674_1_.func_72805_g(p_149674_2_, p_149674_3_, p_149674_4_));
/*  91 */     if (i > 0) func_150062_a(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, i);
/*     */   
/*     */   }
/*     */   
/*     */   public void func_149670_a(World p_149670_1_, int p_149670_2_, int p_149670_3_, int p_149670_4_, Entity p_149670_5_) {
/*  96 */     if (p_149670_1_.field_72995_K)
/*  97 */       return;  int i = func_150060_c(p_149670_1_.func_72805_g(p_149670_2_, p_149670_3_, p_149670_4_));
/*  98 */     if (i == 0) func_150062_a(p_149670_1_, p_149670_2_, p_149670_3_, p_149670_4_, i); 
/*     */   }
/*     */   
/*     */   protected void func_150062_a(World p_150062_1_, int p_150062_2_, int p_150062_3_, int p_150062_4_, int p_150062_5_) {
/* 102 */     int i = func_150065_e(p_150062_1_, p_150062_2_, p_150062_3_, p_150062_4_);
/* 103 */     boolean bool1 = (p_150062_5_ > 0) ? true : false;
/* 104 */     boolean bool2 = (i > 0) ? true : false;
/*     */     
/* 106 */     if (p_150062_5_ != i) {
/* 107 */       p_150062_1_.func_72921_c(p_150062_2_, p_150062_3_, p_150062_4_, func_150066_d(i), 2);
/* 108 */       func_150064_a_(p_150062_1_, p_150062_2_, p_150062_3_, p_150062_4_);
/* 109 */       p_150062_1_.func_147458_c(p_150062_2_, p_150062_3_, p_150062_4_, p_150062_2_, p_150062_3_, p_150062_4_);
/*     */     } 
/*     */     
/* 112 */     if (!bool2 && bool1) {
/* 113 */       p_150062_1_.func_72908_a(p_150062_2_ + 0.5D, p_150062_3_ + 0.1D, p_150062_4_ + 0.5D, "random.click", 0.3F, 0.5F);
/* 114 */     } else if (bool2 && !bool1) {
/* 115 */       p_150062_1_.func_72908_a(p_150062_2_ + 0.5D, p_150062_3_ + 0.1D, p_150062_4_ + 0.5D, "random.click", 0.3F, 0.6F);
/*     */     } 
/*     */     
/* 118 */     if (bool2) {
/* 119 */       p_150062_1_.func_147464_a(p_150062_2_, p_150062_3_, p_150062_4_, this, func_149738_a(p_150062_1_));
/*     */     }
/*     */   }
/*     */   
/*     */   protected AxisAlignedBB func_150061_a(int p_150061_1_, int p_150061_2_, int p_150061_3_) {
/* 124 */     float f = 0.125F;
/* 125 */     return AxisAlignedBB.func_72330_a((p_150061_1_ + f), p_150061_2_, (p_150061_3_ + f), ((p_150061_1_ + 1) - f), p_150061_2_ + 0.25D, ((p_150061_3_ + 1) - f));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149749_a(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_) {
/* 130 */     if (func_150060_c(p_149749_6_) > 0) {
/* 131 */       func_150064_a_(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_);
/*     */     }
/*     */     
/* 134 */     super.func_149749_a(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_, p_149749_6_);
/*     */   }
/*     */   
/*     */   protected void func_150064_a_(World p_150064_1_, int p_150064_2_, int p_150064_3_, int p_150064_4_) {
/* 138 */     p_150064_1_.func_147459_d(p_150064_2_, p_150064_3_, p_150064_4_, this);
/* 139 */     p_150064_1_.func_147459_d(p_150064_2_, p_150064_3_ - 1, p_150064_4_, this);
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149709_b(IBlockAccess p_149709_1_, int p_149709_2_, int p_149709_3_, int p_149709_4_, int p_149709_5_) {
/* 144 */     return func_150060_c(p_149709_1_.func_72805_g(p_149709_2_, p_149709_3_, p_149709_4_));
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149748_c(IBlockAccess p_149748_1_, int p_149748_2_, int p_149748_3_, int p_149748_4_, int p_149748_5_) {
/* 149 */     if (p_149748_5_ == 1) {
/* 150 */       return func_150060_c(p_149748_1_.func_72805_g(p_149748_2_, p_149748_3_, p_149748_4_));
/*     */     }
/* 152 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149744_f() {
/* 158 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149683_g() {
/* 163 */     float f1 = 0.5F;
/* 164 */     float f2 = 0.125F;
/* 165 */     float f3 = 0.5F;
/* 166 */     func_149676_a(0.5F - f1, 0.5F - f2, 0.5F - f3, 0.5F + f1, 0.5F + f2, 0.5F + f3);
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149656_h() {
/* 171 */     return 1;
/*     */   }
/*     */   
/*     */   protected abstract int func_150065_e(World paramWorld, int paramInt1, int paramInt2, int paramInt3);
/*     */   
/*     */   protected abstract int func_150060_c(int paramInt);
/*     */   
/*     */   protected abstract int func_150066_d(int paramInt);
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 182 */     this.field_149761_L = p_149651_1_.func_94245_a(this.field_150067_a);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockBasePressurePlate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */