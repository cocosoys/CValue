/*     */ package JinRyuu.JRMCore.entity;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreClient;
/*     */ import JinRyuu.JRMCore.m.mEnergy5;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class RenderEnergyAttJ4
/*     */   extends RenderJRMC {
/*     */   private mEnergy5 ener;
/*  18 */   public final int lvnm = 10;
/*  19 */   public float[][] lightVertRotation = new float[10][3];
/*     */   
/*     */   public RenderEnergyAttJ4() {
/*  22 */     super((ModelBase)new mEnergy5(), 0.5F);
/*  23 */     this.ener = new mEnergy5();
/*  24 */     for (int i = 0; i < 10; ) { for (int j = 0; j < 3; ) { this.lightVertRotation[i][j] = 0.0F; j++; }  i++; }
/*     */   
/*     */   }
/*     */   
/*     */   public void renderEnergy(EntityEnergyAttJ4 e, double par2, double par4, double par6, float par8, float par9) {
/*  29 */     byte type = e.getType();
/*     */     
/*  31 */     double x = e.field_70165_t;
/*  32 */     double y = e.field_70163_u;
/*  33 */     double z = e.field_70161_v;
/*     */     
/*  35 */     GL11.glPushMatrix();
/*  36 */     GL11.glEnable(2977);
/*  37 */     GL11.glEnable(3042);
/*  38 */     GL11.glBlendFunc(770, 771);
/*     */     
/*  40 */     GL11.glDepthMask(false);
/*  41 */     GL11.glTranslatef((float)par2, (float)par4, (float)par6);
/*  42 */     GL11.glRotatef(e.field_70126_B + (e.field_70177_z - e.field_70126_B) * par9 - 180.0F, 0.0F, 1.0F, 0.0F);
/*  43 */     GL11.glRotatef(e.field_70127_C + (e.field_70125_A - e.field_70127_C) * par9, 1.0F, 0.0F, 0.0F);
/*  44 */     GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
/*  45 */     tex(5220343);
/*     */     
/*  47 */     float seb_szaz = 5.0F;
/*  48 */     float seb_one = seb_szaz / 100.0F;
/*  49 */     float max = 1.0F;
/*  50 */     float ti = e.field_70173_aa;
/*  51 */     float curr = ti * seb_one;
/*  52 */     curr = (curr >= max) ? max : curr;
/*     */     
/*  54 */     GL11.glScalef(curr, curr, curr);
/*     */ 
/*     */     
/*  57 */     GL11.glDisable(3042);
/*  58 */     GL11.glDisable(2977);
/*     */     
/*  60 */     GL11.glPopMatrix();
/*  61 */     if (type == 0) { fieldPass3(e, par2, par4, par6, par9, curr, 5220343); }
/*  62 */     else { lightning(e, par2, par4, par6, par9, curr, 5220343); }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   private void lightning(EntityEnergyAttJ4 e, double par2, double par4, double par6, float par9, float var20, int col) {
/*  68 */     GL11.glPushMatrix();
/*  69 */     Tessellator tessellator2 = Tessellator.field_78398_a;
/*  70 */     GL11.glDisable(3553);
/*  71 */     GL11.glDisable(2896);
/*  72 */     GL11.glEnable(3042);
/*  73 */     GL11.glBlendFunc(770, 1);
/*     */     
/*  75 */     double[] adouble = new double[8];
/*  76 */     double[] adouble1 = new double[8];
/*  77 */     double d3 = 0.0D;
/*  78 */     double d4 = 0.0D;
/*     */     
/*  80 */     GL11.glTranslatef((float)par2, (float)par4, (float)par6);
/*     */     
/*  82 */     float t = e.field_70173_aa;
/*  83 */     float scale = 0.03F * t;
/*  84 */     GL11.glScalef(scale, scale, scale);
/*  85 */     GL11.glRotatef(e.field_70173_aa * 45.0F, 1.0F, 1.0F, 1.0F);
/*  86 */     int k1 = 0;
/*  87 */     float sc = e.getSize() / 2.0F;
/*     */ 
/*     */     
/*  90 */     int i = 0; e.getClass(); for (; i < 10; i++) {
/*     */       
/*  92 */       if (!JRMCoreClient.mc.func_147113_T()) {
/*  93 */         this.lightVertRotation[i][0] = ((int)(Math.random() * 11.0D) * 36);
/*  94 */         this.lightVertRotation[i][1] = (float)(Math.random() * 2.0D) - 1.0F;
/*  95 */         this.lightVertRotation[i][2] = (float)(Math.random() * 2.0D) - 1.0F;
/*     */       } 
/*     */       
/*  98 */       e.getClass(); GL11.glRotated((i * 360 / 10), 0.0D, 0.0D, 1.0D);
/*  99 */       GL11.glRotatef(this.lightVertRotation[i][0], this.lightVertRotation[i][1], this.lightVertRotation[i][2], 0.0F);
/*     */       
/* 101 */       Random random = new Random(e.lightVert[i]);
/* 102 */       Random random1 = new Random(e.lightVert[i]);
/* 103 */       for (int j = 0; j < 3; j++) {
/*     */         
/* 105 */         int k = 7;
/* 106 */         int l = 0;
/*     */         
/* 108 */         if (j > 0)
/*     */         {
/* 110 */           k = 7 - j;
/*     */         }
/*     */         
/* 113 */         if (j > 0)
/*     */         {
/* 115 */           l = k - 2;
/*     */         }
/*     */         
/* 118 */         double d5 = adouble[k] - d3;
/* 119 */         double d6 = adouble1[k] - d4;
/*     */         
/* 121 */         for (int i1 = k; i1 >= l; i1--) {
/*     */           
/* 123 */           double d7 = d5;
/* 124 */           double d8 = d6;
/*     */           
/* 126 */           d5 += (random1.nextInt(31) - 15) * 0.07000000029802322D;
/* 127 */           d6 += (random1.nextInt(31) - 15) * 0.07000000029802322D;
/*     */ 
/*     */           
/* 130 */           tessellator2.func_78371_b(5);
/* 131 */           float f2 = 0.5F;
/* 132 */           tessellator2.func_78369_a(0.9F * f2, 0.9F * f2, 1.0F * f2, 0.3F - e.field_70173_aa * 0.013F);
/*     */           
/* 134 */           double d9 = 0.1D + k1 * 0.2D;
/*     */           
/* 136 */           double d10 = 0.1D + k1 * 0.2D;
/*     */           
/* 138 */           for (int j1 = 0; j1 < 5; j1++) {
/*     */             
/* 140 */             double d11 = 0.0D - d9;
/* 141 */             double d12 = 0.0D - d9;
/*     */             
/* 143 */             if (j1 == 1 || j1 == 2)
/*     */             {
/* 145 */               d11 += d9 * 2.0D * sc;
/*     */             }
/*     */             
/* 148 */             if (j1 == 2 || j1 == 3)
/*     */             {
/* 150 */               d12 += d9 * 2.0D * sc;
/*     */             }
/*     */             
/* 153 */             double d13 = 0.0D - d10;
/* 154 */             double d14 = 0.0D - d10;
/*     */             
/* 156 */             if (j1 == 1 || j1 == 2) {
/* 157 */               d13 += d10 * 2.0D * sc;
/*     */             }
/*     */             
/* 160 */             if (j1 == 2 || j1 == 3) {
/* 161 */               d14 += d10 * 2.0D * sc;
/*     */             }
/* 163 */             if (i1 < 8) {
/* 164 */               tessellator2.func_78377_a(d13 + d5 * sc, -((i1 * 1 - 7)) * sc, d14 + d6 * sc);
/* 165 */               tessellator2.func_78377_a(d11 + d7 * sc, -(((i1 + 1) * 1 - 7)) * sc, d12 + d8 * sc);
/*     */             } 
/*     */           } 
/*     */           
/* 169 */           tessellator2.func_78381_a();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 174 */     GL11.glDisable(3042);
/* 175 */     GL11.glEnable(2896);
/* 176 */     GL11.glEnable(3553);
/* 177 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void fieldPass3(EntityEnergyAttJ4 e, double par2, double par4, double par6, float par9, float var20, int col) {
/* 183 */     GL11.glPushMatrix();
/* 184 */     GL11.glDepthMask(true);
/* 185 */     GL11.glEnable(2977);
/* 186 */     GL11.glEnable(3042);
/* 187 */     GL11.glBlendFunc(770, 771);
/* 188 */     GL11.glDisable(2896);
/* 189 */     GL11.glTranslatef((float)par2, (float)par4, (float)par6);
/* 190 */     tex(col);
/* 191 */     GL11.glScalef(var20 / 2.0F, var20 / 2.0F, var20 / 2.0F);
/* 192 */     float t = e.field_70173_aa;
/* 193 */     float scale = 0.3F * t;
/* 194 */     GL11.glScalef(scale, scale, scale);
/* 195 */     GL11.glRotatef(e.field_70173_aa * 45.0F, 1.0F, 1.0F, 1.0F);
/*     */ 
/*     */     
/* 198 */     float sc2 = 2.6F;
/*     */ 
/*     */ 
/*     */     
/* 202 */     GL11.glColor4f(0.7F, 0.9F, 1.0F, 0.6F - e.field_70173_aa * 0.03F);
/* 203 */     this.ener.render();
/*     */     
/* 205 */     sc2 = 2.6F;
/* 206 */     GL11.glScalef(sc2, sc2, sc2);
/*     */     
/* 208 */     GL11.glColor4f(0.7F, 0.9F, 1.0F, 0.3F - e.field_70173_aa * 0.015F);
/* 209 */     this.ener.render();
/*     */ 
/*     */     
/* 212 */     GL11.glDisable(3042);
/* 213 */     GL11.glDisable(2977);
/* 214 */     GL11.glDisable(2896);
/* 215 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */   
/*     */   public void tex(int col) {
/* 220 */     float h2 = (col >> 16 & 0xFF) / 255.0F;
/* 221 */     float h3 = (col >> 8 & 0xFF) / 255.0F;
/* 222 */     float h4 = (col & 0xFF) / 255.0F;
/* 223 */     GL11.glColor4f(h2, h3, h4, 0.5F);
/* 224 */     ResourceLocation txx = new ResourceLocation("jinryuumodscore:allw.png");
/* 225 */     this.field_76990_c.field_78724_e.func_110577_a(txx);
/*     */   }
/*     */   protected float handleRotationFloat(Entity par1Entity, float par2) {
/* 228 */     return par1Entity.field_70173_aa + par2;
/*     */   } public void func_76986_a(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
/* 230 */     renderEnergy((EntityEnergyAttJ4)par1Entity, par2, par4, par6, par8, par9);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\entity\RenderEnergyAttJ4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */