/*     */ package net.minecraft.block;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockPane extends Block {
/*     */   private final String field_150100_a;
/*     */   private final boolean field_150099_b;
/*     */   
/*     */   protected BlockPane(String p_i45432_1_, String p_i45432_2_, Material p_i45432_3_, boolean p_i45432_4_) {
/*  20 */     super(p_i45432_3_);
/*  21 */     this.field_150100_a = p_i45432_2_;
/*  22 */     this.field_150099_b = p_i45432_4_;
/*  23 */     this.field_150101_M = p_i45432_1_;
/*  24 */     func_149647_a(CreativeTabs.field_78031_c);
/*     */   }
/*     */   private final String field_150101_M; @SideOnly(Side.CLIENT)
/*     */   private IIcon field_150102_N; private static final String __OBFID = "CL_00000322";
/*     */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/*  29 */     if (!this.field_150099_b) {
/*  30 */       return null;
/*     */     }
/*  32 */     return super.func_149650_a(p_149650_1_, p_149650_2_, p_149650_3_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  37 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/*  42 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/*  47 */     return (this.field_149764_J == Material.field_151592_s) ? 41 : 18;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_149646_a(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
/*  52 */     if (p_149646_1_.func_147439_a(p_149646_2_, p_149646_3_, p_149646_4_) == this) return false; 
/*  53 */     return super.func_149646_a(p_149646_1_, p_149646_2_, p_149646_3_, p_149646_4_, p_149646_5_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149743_a(World p_149743_1_, int p_149743_2_, int p_149743_3_, int p_149743_4_, AxisAlignedBB p_149743_5_, List p_149743_6_, Entity p_149743_7_) {
/*  58 */     boolean bool1 = func_150098_a(p_149743_1_.func_147439_a(p_149743_2_, p_149743_3_, p_149743_4_ - 1));
/*  59 */     boolean bool2 = func_150098_a(p_149743_1_.func_147439_a(p_149743_2_, p_149743_3_, p_149743_4_ + 1));
/*  60 */     boolean bool3 = func_150098_a(p_149743_1_.func_147439_a(p_149743_2_ - 1, p_149743_3_, p_149743_4_));
/*  61 */     boolean bool4 = func_150098_a(p_149743_1_.func_147439_a(p_149743_2_ + 1, p_149743_3_, p_149743_4_));
/*     */     
/*  63 */     if ((bool3 && bool4) || (!bool3 && !bool4 && !bool1 && !bool2)) {
/*  64 */       func_149676_a(0.0F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
/*  65 */       super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
/*  66 */     } else if (bool3 && !bool4) {
/*  67 */       func_149676_a(0.0F, 0.0F, 0.4375F, 0.5F, 1.0F, 0.5625F);
/*  68 */       super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
/*  69 */     } else if (!bool3 && bool4) {
/*  70 */       func_149676_a(0.5F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
/*  71 */       super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
/*     */     } 
/*  73 */     if ((bool1 && bool2) || (!bool3 && !bool4 && !bool1 && !bool2)) {
/*  74 */       func_149676_a(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 1.0F);
/*  75 */       super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
/*  76 */     } else if (bool1 && !bool2) {
/*  77 */       func_149676_a(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 0.5F);
/*  78 */       super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
/*  79 */     } else if (!bool1 && bool2) {
/*  80 */       func_149676_a(0.4375F, 0.0F, 0.5F, 0.5625F, 1.0F, 1.0F);
/*  81 */       super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149683_g() {
/*  87 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
/*  92 */     float f1 = 0.4375F;
/*  93 */     float f2 = 0.5625F;
/*  94 */     float f3 = 0.4375F;
/*  95 */     float f4 = 0.5625F;
/*     */     
/*  97 */     boolean bool1 = func_150098_a(p_149719_1_.func_147439_a(p_149719_2_, p_149719_3_, p_149719_4_ - 1));
/*  98 */     boolean bool2 = func_150098_a(p_149719_1_.func_147439_a(p_149719_2_, p_149719_3_, p_149719_4_ + 1));
/*  99 */     boolean bool3 = func_150098_a(p_149719_1_.func_147439_a(p_149719_2_ - 1, p_149719_3_, p_149719_4_));
/* 100 */     boolean bool4 = func_150098_a(p_149719_1_.func_147439_a(p_149719_2_ + 1, p_149719_3_, p_149719_4_));
/*     */     
/* 102 */     if ((bool3 && bool4) || (!bool3 && !bool4 && !bool1 && !bool2)) {
/* 103 */       f1 = 0.0F;
/* 104 */       f2 = 1.0F;
/* 105 */     } else if (bool3 && !bool4) {
/* 106 */       f1 = 0.0F;
/* 107 */     } else if (!bool3 && bool4) {
/* 108 */       f2 = 1.0F;
/*     */     } 
/* 110 */     if ((bool1 && bool2) || (!bool3 && !bool4 && !bool1 && !bool2)) {
/* 111 */       f3 = 0.0F;
/* 112 */       f4 = 1.0F;
/* 113 */     } else if (bool1 && !bool2) {
/* 114 */       f3 = 0.0F;
/* 115 */     } else if (!bool1 && bool2) {
/* 116 */       f4 = 1.0F;
/*     */     } 
/*     */     
/* 119 */     func_149676_a(f1, 0.0F, f3, f2, 1.0F, f4);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_150097_e() {
/* 123 */     return this.field_150102_N;
/*     */   }
/*     */   
/*     */   public final boolean func_150098_a(Block p_150098_1_) {
/* 127 */     return (p_150098_1_.func_149730_j() || p_150098_1_ == this || p_150098_1_ == Blocks.field_150359_w || p_150098_1_ == Blocks.field_150399_cn || p_150098_1_ == Blocks.field_150397_co || p_150098_1_ instanceof BlockPane);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean func_149700_E() {
/* 132 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected ItemStack func_149644_j(int p_149644_1_) {
/* 137 */     return new ItemStack(Item.func_150898_a(this), 1, p_149644_1_);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 142 */     this.field_149761_L = p_149651_1_.func_94245_a(this.field_150101_M);
/* 143 */     this.field_150102_N = p_149651_1_.func_94245_a(this.field_150100_a);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockPane.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */