/*     */ package net.minecraft.client.renderer.entity;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityPainting;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class RenderPainting extends Render {
/*  15 */   private static final ResourceLocation field_110807_a = new ResourceLocation("textures/painting/paintings_kristoffer_zetterstrand.png");
/*     */   private static final String __OBFID = "CL_00001018";
/*     */   
/*     */   public void func_76986_a(EntityPainting p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
/*  19 */     GL11.glPushMatrix();
/*  20 */     GL11.glTranslated(p_76986_2_, p_76986_4_, p_76986_6_);
/*  21 */     GL11.glRotatef(p_76986_8_, 0.0F, 1.0F, 0.0F);
/*  22 */     GL11.glEnable(32826);
/*     */     
/*  24 */     func_110777_b((Entity)p_76986_1_);
/*  25 */     EntityPainting.EnumArt enumArt = p_76986_1_.field_70522_e;
/*     */     
/*  27 */     float f = 0.0625F;
/*  28 */     GL11.glScalef(f, f, f);
/*  29 */     func_77010_a(p_76986_1_, enumArt.field_75703_B, enumArt.field_75704_C, enumArt.field_75699_D, enumArt.field_75700_E);
/*  30 */     GL11.glDisable(32826);
/*  31 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */   
/*     */   protected ResourceLocation func_110775_a(EntityPainting p_110775_1_) {
/*  36 */     return field_110807_a;
/*     */   }
/*     */   
/*     */   private void func_77010_a(EntityPainting p_77010_1_, int p_77010_2_, int p_77010_3_, int p_77010_4_, int p_77010_5_) {
/*  40 */     float f1 = -p_77010_2_ / 2.0F;
/*  41 */     float f2 = -p_77010_3_ / 2.0F;
/*     */     
/*  43 */     float f3 = 0.5F;
/*     */ 
/*     */     
/*  46 */     float f4 = 0.75F;
/*  47 */     float f5 = 0.8125F;
/*  48 */     float f6 = 0.0F;
/*  49 */     float f7 = 0.0625F;
/*     */ 
/*     */     
/*  52 */     float f8 = 0.75F;
/*  53 */     float f9 = 0.8125F;
/*  54 */     float f10 = 0.001953125F;
/*  55 */     float f11 = 0.001953125F;
/*     */ 
/*     */     
/*  58 */     float f12 = 0.7519531F;
/*  59 */     float f13 = 0.7519531F;
/*  60 */     float f14 = 0.0F;
/*  61 */     float f15 = 0.0625F;
/*     */     
/*  63 */     for (byte b = 0; b < p_77010_2_ / 16; b++) {
/*  64 */       for (byte b1 = 0; b1 < p_77010_3_ / 16; b1++) {
/*  65 */         float f16 = f1 + ((b + 1) * 16);
/*  66 */         float f17 = f1 + (b * 16);
/*  67 */         float f18 = f2 + ((b1 + 1) * 16);
/*  68 */         float f19 = f2 + (b1 * 16);
/*     */         
/*  70 */         func_77008_a(p_77010_1_, (f16 + f17) / 2.0F, (f18 + f19) / 2.0F);
/*     */ 
/*     */         
/*  73 */         float f20 = (p_77010_4_ + p_77010_2_ - b * 16) / 256.0F;
/*  74 */         float f21 = (p_77010_4_ + p_77010_2_ - (b + 1) * 16) / 256.0F;
/*  75 */         float f22 = (p_77010_5_ + p_77010_3_ - b1 * 16) / 256.0F;
/*  76 */         float f23 = (p_77010_5_ + p_77010_3_ - (b1 + 1) * 16) / 256.0F;
/*     */         
/*  78 */         Tessellator tessellator = Tessellator.field_78398_a;
/*  79 */         tessellator.func_78382_b();
/*  80 */         tessellator.func_78375_b(0.0F, 0.0F, -1.0F);
/*  81 */         tessellator.func_78374_a(f16, f19, -f3, f21, f22);
/*  82 */         tessellator.func_78374_a(f17, f19, -f3, f20, f22);
/*  83 */         tessellator.func_78374_a(f17, f18, -f3, f20, f23);
/*  84 */         tessellator.func_78374_a(f16, f18, -f3, f21, f23);
/*     */         
/*  86 */         tessellator.func_78375_b(0.0F, 0.0F, 1.0F);
/*  87 */         tessellator.func_78374_a(f16, f18, f3, f4, f6);
/*  88 */         tessellator.func_78374_a(f17, f18, f3, f5, f6);
/*  89 */         tessellator.func_78374_a(f17, f19, f3, f5, f7);
/*  90 */         tessellator.func_78374_a(f16, f19, f3, f4, f7);
/*     */         
/*  92 */         tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
/*  93 */         tessellator.func_78374_a(f16, f18, -f3, f8, f10);
/*  94 */         tessellator.func_78374_a(f17, f18, -f3, f9, f10);
/*  95 */         tessellator.func_78374_a(f17, f18, f3, f9, f11);
/*  96 */         tessellator.func_78374_a(f16, f18, f3, f8, f11);
/*     */         
/*  98 */         tessellator.func_78375_b(0.0F, -1.0F, 0.0F);
/*  99 */         tessellator.func_78374_a(f16, f19, f3, f8, f10);
/* 100 */         tessellator.func_78374_a(f17, f19, f3, f9, f10);
/* 101 */         tessellator.func_78374_a(f17, f19, -f3, f9, f11);
/* 102 */         tessellator.func_78374_a(f16, f19, -f3, f8, f11);
/*     */         
/* 104 */         tessellator.func_78375_b(-1.0F, 0.0F, 0.0F);
/* 105 */         tessellator.func_78374_a(f16, f18, f3, f13, f14);
/* 106 */         tessellator.func_78374_a(f16, f19, f3, f13, f15);
/* 107 */         tessellator.func_78374_a(f16, f19, -f3, f12, f15);
/* 108 */         tessellator.func_78374_a(f16, f18, -f3, f12, f14);
/*     */         
/* 110 */         tessellator.func_78375_b(1.0F, 0.0F, 0.0F);
/* 111 */         tessellator.func_78374_a(f17, f18, -f3, f13, f14);
/* 112 */         tessellator.func_78374_a(f17, f19, -f3, f13, f15);
/* 113 */         tessellator.func_78374_a(f17, f19, f3, f12, f15);
/* 114 */         tessellator.func_78374_a(f17, f18, f3, f12, f14);
/* 115 */         tessellator.func_78381_a();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   private void func_77008_a(EntityPainting p_77008_1_, float p_77008_2_, float p_77008_3_) {
/* 120 */     int i = MathHelper.func_76128_c(p_77008_1_.field_70165_t);
/* 121 */     int j = MathHelper.func_76128_c(p_77008_1_.field_70163_u + (p_77008_3_ / 16.0F));
/* 122 */     int k = MathHelper.func_76128_c(p_77008_1_.field_70161_v);
/* 123 */     if (p_77008_1_.field_82332_a == 2) i = MathHelper.func_76128_c(p_77008_1_.field_70165_t + (p_77008_2_ / 16.0F)); 
/* 124 */     if (p_77008_1_.field_82332_a == 1) k = MathHelper.func_76128_c(p_77008_1_.field_70161_v - (p_77008_2_ / 16.0F)); 
/* 125 */     if (p_77008_1_.field_82332_a == 0) i = MathHelper.func_76128_c(p_77008_1_.field_70165_t - (p_77008_2_ / 16.0F)); 
/* 126 */     if (p_77008_1_.field_82332_a == 3) k = MathHelper.func_76128_c(p_77008_1_.field_70161_v + (p_77008_2_ / 16.0F)); 
/* 127 */     int m = this.field_76990_c.field_78722_g.func_72802_i(i, j, k, 0);
/* 128 */     int n = m % 65536;
/* 129 */     int i1 = m / 65536;
/* 130 */     OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, n, i1);
/* 131 */     GL11.glColor3f(1.0F, 1.0F, 1.0F);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RenderPainting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */