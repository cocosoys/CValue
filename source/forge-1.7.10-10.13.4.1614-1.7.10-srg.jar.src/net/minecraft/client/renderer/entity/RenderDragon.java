/*     */ package net.minecraft.client.renderer.entity;
/*     */ import java.util.Random;
/*     */ import net.minecraft.client.model.ModelDragon;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.client.renderer.RenderHelper;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.boss.EntityDragon;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class RenderDragon extends RenderLiving {
/*  17 */   private static final ResourceLocation field_110842_f = new ResourceLocation("textures/entity/enderdragon/dragon_exploding.png");
/*  18 */   private static final ResourceLocation field_110843_g = new ResourceLocation("textures/entity/endercrystal/endercrystal_beam.png");
/*  19 */   private static final ResourceLocation field_110845_h = new ResourceLocation("textures/entity/enderdragon/dragon_eyes.png");
/*  20 */   private static final ResourceLocation field_110844_k = new ResourceLocation("textures/entity/enderdragon/dragon.png");
/*     */   protected ModelDragon field_77084_b;
/*     */   private static final String __OBFID = "CL_00000988";
/*     */   
/*     */   public RenderDragon() {
/*  25 */     super((ModelBase)new ModelDragon(0.0F), 0.5F);
/*     */     
/*  27 */     this.field_77084_b = (ModelDragon)this.field_77045_g;
/*  28 */     func_77042_a(this.field_77045_g);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_77043_a(EntityDragon p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
/*  33 */     float f1 = (float)p_77043_1_.func_70974_a(7, p_77043_4_)[0];
/*  34 */     float f2 = (float)(p_77043_1_.func_70974_a(5, p_77043_4_)[1] - p_77043_1_.func_70974_a(10, p_77043_4_)[1]);
/*  35 */     GL11.glRotatef(-f1, 0.0F, 1.0F, 0.0F);
/*  36 */     GL11.glRotatef(f2 * 10.0F, 1.0F, 0.0F, 0.0F);
/*  37 */     GL11.glTranslatef(0.0F, 0.0F, 1.0F);
/*  38 */     if (p_77043_1_.field_70725_aQ > 0) {
/*  39 */       float f = (p_77043_1_.field_70725_aQ + p_77043_4_ - 1.0F) / 20.0F * 1.6F;
/*  40 */       f = MathHelper.func_76129_c(f);
/*  41 */       if (f > 1.0F) f = 1.0F; 
/*  42 */       GL11.glRotatef(f * func_77037_a((EntityLivingBase)p_77043_1_), 0.0F, 0.0F, 1.0F);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_77036_a(EntityDragon p_77036_1_, float p_77036_2_, float p_77036_3_, float p_77036_4_, float p_77036_5_, float p_77036_6_, float p_77036_7_) {
/*  48 */     if (p_77036_1_.field_70995_bG > 0) {
/*  49 */       float f = p_77036_1_.field_70995_bG / 200.0F;
/*  50 */       GL11.glDepthFunc(515);
/*  51 */       GL11.glEnable(3008);
/*  52 */       GL11.glAlphaFunc(516, f);
/*  53 */       func_110776_a(field_110842_f);
/*  54 */       this.field_77045_g.func_78088_a((Entity)p_77036_1_, p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_);
/*  55 */       GL11.glAlphaFunc(516, 0.1F);
/*     */       
/*  57 */       GL11.glDepthFunc(514);
/*     */     } 
/*     */     
/*  60 */     func_110777_b((Entity)p_77036_1_);
/*  61 */     this.field_77045_g.func_78088_a((Entity)p_77036_1_, p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_);
/*     */     
/*  63 */     if (p_77036_1_.field_70737_aN > 0) {
/*  64 */       GL11.glDepthFunc(514);
/*  65 */       GL11.glDisable(3553);
/*  66 */       GL11.glEnable(3042);
/*  67 */       GL11.glBlendFunc(770, 771);
/*  68 */       GL11.glColor4f(1.0F, 0.0F, 0.0F, 0.5F);
/*  69 */       this.field_77045_g.func_78088_a((Entity)p_77036_1_, p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_);
/*  70 */       GL11.glEnable(3553);
/*  71 */       GL11.glDisable(3042);
/*  72 */       GL11.glDepthFunc(515);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_76986_a(EntityDragon p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
/*  78 */     BossStatus.func_82824_a((IBossDisplayData)p_76986_1_, false);
/*  79 */     super.func_76986_a((EntityLiving)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
/*  80 */     if (p_76986_1_.field_70992_bH != null) {
/*  81 */       float f1 = p_76986_1_.field_70992_bH.field_70261_a + p_76986_9_;
/*  82 */       float f2 = MathHelper.func_76126_a(f1 * 0.2F) / 2.0F + 0.5F;
/*  83 */       f2 = (f2 * f2 + f2) * 0.2F;
/*     */       
/*  85 */       float f3 = (float)(p_76986_1_.field_70992_bH.field_70165_t - p_76986_1_.field_70165_t - (p_76986_1_.field_70169_q - p_76986_1_.field_70165_t) * (1.0F - p_76986_9_));
/*  86 */       float f4 = (float)(f2 + p_76986_1_.field_70992_bH.field_70163_u - 1.0D - p_76986_1_.field_70163_u - (p_76986_1_.field_70167_r - p_76986_1_.field_70163_u) * (1.0F - p_76986_9_));
/*  87 */       float f5 = (float)(p_76986_1_.field_70992_bH.field_70161_v - p_76986_1_.field_70161_v - (p_76986_1_.field_70166_s - p_76986_1_.field_70161_v) * (1.0F - p_76986_9_));
/*     */       
/*  89 */       float f6 = MathHelper.func_76129_c(f3 * f3 + f5 * f5);
/*  90 */       float f7 = MathHelper.func_76129_c(f3 * f3 + f4 * f4 + f5 * f5);
/*     */       
/*  92 */       GL11.glPushMatrix();
/*  93 */       GL11.glTranslatef((float)p_76986_2_, (float)p_76986_4_ + 2.0F, (float)p_76986_6_);
/*  94 */       GL11.glRotatef((float)-Math.atan2(f5, f3) * 180.0F / 3.1415927F - 90.0F, 0.0F, 1.0F, 0.0F);
/*  95 */       GL11.glRotatef((float)-Math.atan2(f6, f4) * 180.0F / 3.1415927F - 90.0F, 1.0F, 0.0F, 0.0F);
/*  96 */       Tessellator tessellator = Tessellator.field_78398_a;
/*  97 */       RenderHelper.func_74518_a();
/*  98 */       GL11.glDisable(2884);
/*     */       
/* 100 */       func_110776_a(field_110843_g);
/*     */       
/* 102 */       GL11.glShadeModel(7425);
/*     */       
/* 104 */       float f8 = 0.0F - (p_76986_1_.field_70173_aa + p_76986_9_) * 0.01F;
/* 105 */       float f9 = MathHelper.func_76129_c(f3 * f3 + f4 * f4 + f5 * f5) / 32.0F - (p_76986_1_.field_70173_aa + p_76986_9_) * 0.01F;
/* 106 */       tessellator.func_78371_b(5);
/*     */       
/* 108 */       byte b1 = 8;
/* 109 */       for (byte b2 = 0; b2 <= b1; b2++) {
/* 110 */         float f10 = MathHelper.func_76126_a((b2 % b1) * 3.1415927F * 2.0F / b1) * 0.75F;
/* 111 */         float f11 = MathHelper.func_76134_b((b2 % b1) * 3.1415927F * 2.0F / b1) * 0.75F;
/* 112 */         float f12 = (b2 % b1) * 1.0F / b1;
/* 113 */         tessellator.func_78378_d(0);
/* 114 */         tessellator.func_78374_a((f10 * 0.2F), (f11 * 0.2F), 0.0D, f12, f9);
/* 115 */         tessellator.func_78378_d(16777215);
/* 116 */         tessellator.func_78374_a(f10, f11, f7, f12, f8);
/*     */       } 
/*     */       
/* 119 */       tessellator.func_78381_a();
/* 120 */       GL11.glEnable(2884);
/* 121 */       GL11.glShadeModel(7424);
/*     */       
/* 123 */       RenderHelper.func_74519_b();
/* 124 */       GL11.glPopMatrix();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected ResourceLocation func_110775_a(EntityDragon p_110775_1_) {
/* 130 */     return field_110844_k;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_77029_c(EntityDragon p_77029_1_, float p_77029_2_) {
/* 135 */     super.func_77029_c((EntityLivingBase)p_77029_1_, p_77029_2_);
/* 136 */     Tessellator tessellator = Tessellator.field_78398_a;
/*     */     
/* 138 */     if (p_77029_1_.field_70995_bG > 0) {
/* 139 */       RenderHelper.func_74518_a();
/* 140 */       float f1 = (p_77029_1_.field_70995_bG + p_77029_2_) / 200.0F;
/* 141 */       float f2 = 0.0F;
/* 142 */       if (f1 > 0.8F) {
/* 143 */         f2 = (f1 - 0.8F) / 0.2F;
/*     */       }
/*     */       
/* 146 */       Random random = new Random(432L);
/* 147 */       GL11.glDisable(3553);
/* 148 */       GL11.glShadeModel(7425);
/* 149 */       GL11.glEnable(3042);
/* 150 */       GL11.glBlendFunc(770, 1);
/* 151 */       GL11.glDisable(3008);
/* 152 */       GL11.glEnable(2884);
/* 153 */       GL11.glDepthMask(false);
/* 154 */       GL11.glPushMatrix();
/* 155 */       GL11.glTranslatef(0.0F, -1.0F, -2.0F);
/* 156 */       for (byte b = 0; b < (f1 + f1 * f1) / 2.0F * 60.0F; b++) {
/* 157 */         GL11.glRotatef(random.nextFloat() * 360.0F, 1.0F, 0.0F, 0.0F);
/* 158 */         GL11.glRotatef(random.nextFloat() * 360.0F, 0.0F, 1.0F, 0.0F);
/* 159 */         GL11.glRotatef(random.nextFloat() * 360.0F, 0.0F, 0.0F, 1.0F);
/* 160 */         GL11.glRotatef(random.nextFloat() * 360.0F, 1.0F, 0.0F, 0.0F);
/* 161 */         GL11.glRotatef(random.nextFloat() * 360.0F, 0.0F, 1.0F, 0.0F);
/* 162 */         GL11.glRotatef(random.nextFloat() * 360.0F + f1 * 90.0F, 0.0F, 0.0F, 1.0F);
/* 163 */         tessellator.func_78371_b(6);
/* 164 */         float f3 = random.nextFloat() * 20.0F + 5.0F + f2 * 10.0F;
/* 165 */         float f4 = random.nextFloat() * 2.0F + 1.0F + f2 * 2.0F;
/* 166 */         tessellator.func_78384_a(16777215, (int)(255.0F * (1.0F - f2)));
/* 167 */         tessellator.func_78377_a(0.0D, 0.0D, 0.0D);
/* 168 */         tessellator.func_78384_a(16711935, 0);
/* 169 */         tessellator.func_78377_a(-0.866D * f4, f3, (-0.5F * f4));
/* 170 */         tessellator.func_78377_a(0.866D * f4, f3, (-0.5F * f4));
/* 171 */         tessellator.func_78377_a(0.0D, f3, (1.0F * f4));
/* 172 */         tessellator.func_78377_a(-0.866D * f4, f3, (-0.5F * f4));
/* 173 */         tessellator.func_78381_a();
/*     */       } 
/* 175 */       GL11.glPopMatrix();
/* 176 */       GL11.glDepthMask(true);
/* 177 */       GL11.glDisable(2884);
/* 178 */       GL11.glDisable(3042);
/* 179 */       GL11.glShadeModel(7424);
/* 180 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 181 */       GL11.glEnable(3553);
/* 182 */       GL11.glEnable(3008);
/* 183 */       RenderHelper.func_74519_b();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected int func_77032_a(EntityDragon p_77032_1_, int p_77032_2_, float p_77032_3_) {
/* 190 */     if (p_77032_2_ == 1) {
/* 191 */       GL11.glDepthFunc(515);
/*     */     }
/* 193 */     if (p_77032_2_ != 0) return -1;
/*     */     
/* 195 */     func_110776_a(field_110845_h);
/* 196 */     GL11.glEnable(3042);
/* 197 */     GL11.glDisable(3008);
/* 198 */     GL11.glBlendFunc(1, 1);
/* 199 */     GL11.glDisable(2896);
/* 200 */     GL11.glDepthFunc(514);
/*     */     
/* 202 */     char c = '';
/* 203 */     int i = c % 65536;
/* 204 */     int j = c / 65536;
/*     */     
/* 206 */     OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, i / 1.0F, j / 1.0F);
/*     */     
/* 208 */     GL11.glEnable(2896);
/* 209 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 210 */     return 1;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RenderDragon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */