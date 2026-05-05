/*     */ package net.minecraft.client.gui;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class Gui {
/*   9 */   public static final ResourceLocation field_110325_k = new ResourceLocation("textures/gui/options_background.png");
/*  10 */   public static final ResourceLocation field_110323_l = new ResourceLocation("textures/gui/container/stats_icons.png");
/*  11 */   public static final ResourceLocation field_110324_m = new ResourceLocation("textures/gui/icons.png"); protected float field_73735_i;
/*     */   private static final String __OBFID = "CL_00000662";
/*     */   
/*     */   protected void func_73730_a(int p_73730_1_, int p_73730_2_, int p_73730_3_, int p_73730_4_) {
/*  15 */     if (p_73730_2_ < p_73730_1_) {
/*  16 */       int i = p_73730_1_;
/*  17 */       p_73730_1_ = p_73730_2_;
/*  18 */       p_73730_2_ = i;
/*     */     } 
/*  20 */     func_73734_a(p_73730_1_, p_73730_3_, p_73730_2_ + 1, p_73730_3_ + 1, p_73730_4_);
/*     */   }
/*     */   
/*     */   protected void func_73728_b(int p_73728_1_, int p_73728_2_, int p_73728_3_, int p_73728_4_) {
/*  24 */     if (p_73728_3_ < p_73728_2_) {
/*  25 */       int i = p_73728_2_;
/*  26 */       p_73728_2_ = p_73728_3_;
/*  27 */       p_73728_3_ = i;
/*     */     } 
/*  29 */     func_73734_a(p_73728_1_, p_73728_2_ + 1, p_73728_1_ + 1, p_73728_3_, p_73728_4_);
/*     */   }
/*     */   
/*     */   public static void func_73734_a(int p_73734_0_, int p_73734_1_, int p_73734_2_, int p_73734_3_, int p_73734_4_) {
/*  33 */     if (p_73734_0_ < p_73734_2_) {
/*  34 */       int i = p_73734_0_;
/*  35 */       p_73734_0_ = p_73734_2_;
/*  36 */       p_73734_2_ = i;
/*     */     } 
/*  38 */     if (p_73734_1_ < p_73734_3_) {
/*  39 */       int i = p_73734_1_;
/*  40 */       p_73734_1_ = p_73734_3_;
/*  41 */       p_73734_3_ = i;
/*     */     } 
/*  43 */     float f1 = (p_73734_4_ >> 24 & 0xFF) / 255.0F;
/*  44 */     float f2 = (p_73734_4_ >> 16 & 0xFF) / 255.0F;
/*  45 */     float f3 = (p_73734_4_ >> 8 & 0xFF) / 255.0F;
/*  46 */     float f4 = (p_73734_4_ & 0xFF) / 255.0F;
/*  47 */     Tessellator tessellator = Tessellator.field_78398_a;
/*  48 */     GL11.glEnable(3042);
/*  49 */     GL11.glDisable(3553);
/*  50 */     OpenGlHelper.func_148821_a(770, 771, 1, 0);
/*  51 */     GL11.glColor4f(f2, f3, f4, f1);
/*  52 */     tessellator.func_78382_b();
/*  53 */     tessellator.func_78377_a(p_73734_0_, p_73734_3_, 0.0D);
/*  54 */     tessellator.func_78377_a(p_73734_2_, p_73734_3_, 0.0D);
/*  55 */     tessellator.func_78377_a(p_73734_2_, p_73734_1_, 0.0D);
/*  56 */     tessellator.func_78377_a(p_73734_0_, p_73734_1_, 0.0D);
/*  57 */     tessellator.func_78381_a();
/*  58 */     GL11.glEnable(3553);
/*  59 */     GL11.glDisable(3042);
/*     */   }
/*     */   
/*     */   protected void func_73733_a(int p_73733_1_, int p_73733_2_, int p_73733_3_, int p_73733_4_, int p_73733_5_, int p_73733_6_) {
/*  63 */     float f1 = (p_73733_5_ >> 24 & 0xFF) / 255.0F;
/*  64 */     float f2 = (p_73733_5_ >> 16 & 0xFF) / 255.0F;
/*  65 */     float f3 = (p_73733_5_ >> 8 & 0xFF) / 255.0F;
/*  66 */     float f4 = (p_73733_5_ & 0xFF) / 255.0F;
/*     */     
/*  68 */     float f5 = (p_73733_6_ >> 24 & 0xFF) / 255.0F;
/*  69 */     float f6 = (p_73733_6_ >> 16 & 0xFF) / 255.0F;
/*  70 */     float f7 = (p_73733_6_ >> 8 & 0xFF) / 255.0F;
/*  71 */     float f8 = (p_73733_6_ & 0xFF) / 255.0F;
/*  72 */     GL11.glDisable(3553);
/*  73 */     GL11.glEnable(3042);
/*  74 */     GL11.glDisable(3008);
/*  75 */     OpenGlHelper.func_148821_a(770, 771, 1, 0);
/*  76 */     GL11.glShadeModel(7425);
/*     */     
/*  78 */     Tessellator tessellator = Tessellator.field_78398_a;
/*  79 */     tessellator.func_78382_b();
/*  80 */     tessellator.func_78369_a(f2, f3, f4, f1);
/*  81 */     tessellator.func_78377_a(p_73733_3_, p_73733_2_, this.field_73735_i);
/*  82 */     tessellator.func_78377_a(p_73733_1_, p_73733_2_, this.field_73735_i);
/*  83 */     tessellator.func_78369_a(f6, f7, f8, f5);
/*  84 */     tessellator.func_78377_a(p_73733_1_, p_73733_4_, this.field_73735_i);
/*  85 */     tessellator.func_78377_a(p_73733_3_, p_73733_4_, this.field_73735_i);
/*  86 */     tessellator.func_78381_a();
/*     */     
/*  88 */     GL11.glShadeModel(7424);
/*  89 */     GL11.glDisable(3042);
/*  90 */     GL11.glEnable(3008);
/*  91 */     GL11.glEnable(3553);
/*     */   }
/*     */   
/*     */   public void func_73732_a(FontRenderer p_73732_1_, String p_73732_2_, int p_73732_3_, int p_73732_4_, int p_73732_5_) {
/*  95 */     p_73732_1_.func_78261_a(p_73732_2_, p_73732_3_ - p_73732_1_.func_78256_a(p_73732_2_) / 2, p_73732_4_, p_73732_5_);
/*     */   }
/*     */   
/*     */   public void func_73731_b(FontRenderer p_73731_1_, String p_73731_2_, int p_73731_3_, int p_73731_4_, int p_73731_5_) {
/*  99 */     p_73731_1_.func_78261_a(p_73731_2_, p_73731_3_, p_73731_4_, p_73731_5_);
/*     */   }
/*     */   
/*     */   public void func_73729_b(int p_73729_1_, int p_73729_2_, int p_73729_3_, int p_73729_4_, int p_73729_5_, int p_73729_6_) {
/* 103 */     float f1 = 0.00390625F;
/* 104 */     float f2 = 0.00390625F;
/* 105 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 106 */     tessellator.func_78382_b();
/* 107 */     tessellator.func_78374_a((p_73729_1_ + 0), (p_73729_2_ + p_73729_6_), this.field_73735_i, ((p_73729_3_ + 0) * f1), ((p_73729_4_ + p_73729_6_) * f2));
/* 108 */     tessellator.func_78374_a((p_73729_1_ + p_73729_5_), (p_73729_2_ + p_73729_6_), this.field_73735_i, ((p_73729_3_ + p_73729_5_) * f1), ((p_73729_4_ + p_73729_6_) * f2));
/* 109 */     tessellator.func_78374_a((p_73729_1_ + p_73729_5_), (p_73729_2_ + 0), this.field_73735_i, ((p_73729_3_ + p_73729_5_) * f1), ((p_73729_4_ + 0) * f2));
/* 110 */     tessellator.func_78374_a((p_73729_1_ + 0), (p_73729_2_ + 0), this.field_73735_i, ((p_73729_3_ + 0) * f1), ((p_73729_4_ + 0) * f2));
/* 111 */     tessellator.func_78381_a();
/*     */   }
/*     */   
/*     */   public void func_94065_a(int p_94065_1_, int p_94065_2_, IIcon p_94065_3_, int p_94065_4_, int p_94065_5_) {
/* 115 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 116 */     tessellator.func_78382_b();
/* 117 */     tessellator.func_78374_a((p_94065_1_ + 0), (p_94065_2_ + p_94065_5_), this.field_73735_i, p_94065_3_.func_94209_e(), p_94065_3_.func_94210_h());
/* 118 */     tessellator.func_78374_a((p_94065_1_ + p_94065_4_), (p_94065_2_ + p_94065_5_), this.field_73735_i, p_94065_3_.func_94212_f(), p_94065_3_.func_94210_h());
/* 119 */     tessellator.func_78374_a((p_94065_1_ + p_94065_4_), (p_94065_2_ + 0), this.field_73735_i, p_94065_3_.func_94212_f(), p_94065_3_.func_94206_g());
/* 120 */     tessellator.func_78374_a((p_94065_1_ + 0), (p_94065_2_ + 0), this.field_73735_i, p_94065_3_.func_94209_e(), p_94065_3_.func_94206_g());
/* 121 */     tessellator.func_78381_a();
/*     */   }
/*     */   
/*     */   public static void func_146110_a(int p_146110_0_, int p_146110_1_, float p_146110_2_, float p_146110_3_, int p_146110_4_, int p_146110_5_, float p_146110_6_, float p_146110_7_) {
/* 125 */     float f1 = 1.0F / p_146110_6_;
/* 126 */     float f2 = 1.0F / p_146110_7_;
/* 127 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 128 */     tessellator.func_78382_b();
/* 129 */     tessellator.func_78374_a(p_146110_0_, (p_146110_1_ + p_146110_5_), 0.0D, (p_146110_2_ * f1), ((p_146110_3_ + p_146110_5_) * f2));
/* 130 */     tessellator.func_78374_a((p_146110_0_ + p_146110_4_), (p_146110_1_ + p_146110_5_), 0.0D, ((p_146110_2_ + p_146110_4_) * f1), ((p_146110_3_ + p_146110_5_) * f2));
/* 131 */     tessellator.func_78374_a((p_146110_0_ + p_146110_4_), p_146110_1_, 0.0D, ((p_146110_2_ + p_146110_4_) * f1), (p_146110_3_ * f2));
/* 132 */     tessellator.func_78374_a(p_146110_0_, p_146110_1_, 0.0D, (p_146110_2_ * f1), (p_146110_3_ * f2));
/* 133 */     tessellator.func_78381_a();
/*     */   }
/*     */   
/*     */   public static void func_152125_a(int p_152125_0_, int p_152125_1_, float p_152125_2_, float p_152125_3_, int p_152125_4_, int p_152125_5_, int p_152125_6_, int p_152125_7_, float p_152125_8_, float p_152125_9_) {
/* 137 */     float f1 = 1.0F / p_152125_8_;
/* 138 */     float f2 = 1.0F / p_152125_9_;
/* 139 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 140 */     tessellator.func_78382_b();
/* 141 */     tessellator.func_78374_a(p_152125_0_, (p_152125_1_ + p_152125_7_), 0.0D, (p_152125_2_ * f1), ((p_152125_3_ + p_152125_5_) * f2));
/* 142 */     tessellator.func_78374_a((p_152125_0_ + p_152125_6_), (p_152125_1_ + p_152125_7_), 0.0D, ((p_152125_2_ + p_152125_4_) * f1), ((p_152125_3_ + p_152125_5_) * f2));
/* 143 */     tessellator.func_78374_a((p_152125_0_ + p_152125_6_), p_152125_1_, 0.0D, ((p_152125_2_ + p_152125_4_) * f1), (p_152125_3_ * f2));
/* 144 */     tessellator.func_78374_a(p_152125_0_, p_152125_1_, 0.0D, (p_152125_2_ * f1), (p_152125_3_ * f2));
/* 145 */     tessellator.func_78381_a();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\Gui.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */