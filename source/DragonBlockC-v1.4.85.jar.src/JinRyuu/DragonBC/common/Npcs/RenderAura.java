/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.DBCClient;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class RenderAura
/*     */   extends RenderDBC
/*     */ {
/*     */   private ModelAura aModel;
/*  20 */   private String mdid = "jinryuudragonbc";
/*     */ 
/*     */   
/*     */   public RenderAura() {
/*  24 */     super((ModelBase)new ModelAura(), 0.5F);
/*  25 */     this.aModel = new ModelAura();
/*     */   }
/*     */   
/*     */   public RenderAura(String mdid) {
/*  29 */     this();
/*  30 */     this.mdid = mdid;
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderAura(EntityAura par1Entity, double parX, double parY, double parZ, float par8, float par9) {
/*  35 */     this.field_76989_e = 0.0F;
/*  36 */     GL11.glPushMatrix();
/*  37 */     GL11.glTranslatef((float)parX + 0.0F, (float)parY + 3.0F, (float)parZ + 0.0F);
/*     */     
/*  39 */     boolean rot = par1Entity.getRot();
/*  40 */     if (rot) {
/*     */ 
/*     */       
/*  43 */       GL11.glTranslatef(0.0F, -1.5F, 0.0F);
/*     */ 
/*     */ 
/*     */       
/*  47 */       GL11.glRotatef(-par1Entity.field_70177_z, 0.0F, 1.0F, 0.0F);
/*  48 */       GL11.glRotatef(par1Entity.field_70125_A - 90.0F, 1.0F, 0.0F, 0.0F);
/*  49 */       GL11.glTranslatef(0.0F, 1.5F, 0.0F);
/*     */     } 
/*  51 */     GL11.glPushMatrix();
/*     */     
/*  53 */     float spd = par1Entity.getSpd();
/*  54 */     boolean iner = par1Entity.getInner();
/*  55 */     float spd2 = 18.0F / spd * 0.05F;
/*  56 */     float var13 = par1Entity.getAge();
/*  57 */     float cr = par1Entity.getCRel();
/*  58 */     float s1 = par1Entity.getState();
/*  59 */     float s = s1 + cr * 0.03F;
/*  60 */     float s2 = par1Entity.getState2() * 0.5F;
/*  61 */     int c = par1Entity.getCol();
/*  62 */     String tex = par1Entity.getTex();
/*  63 */     int cl2 = par1Entity.getColL2();
/*  64 */     String texl2 = par1Entity.getTexL2();
/*  65 */     boolean hasl2 = (texl2.length() > 2);
/*  66 */     s += s2;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  73 */     GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  78 */     ResourceLocation txx2 = new ResourceLocation(this.mdid + ":" + texl2 + ".png");
/*  79 */     ResourceLocation txx = new ResourceLocation(this.mdid + ":" + tex + ".png");
/*  80 */     this.field_76990_c.field_78724_e.func_110577_a(txx);
/*     */ 
/*     */     
/*  83 */     boolean plyrSP = (DBCClient.mc.field_71439_g.func_70005_c_().equals(par1Entity.getmot()) && DBCClient.mc.field_71474_y.field_74320_O == 0);
/*  84 */     float p = !plyrSP ? par1Entity.getAlp() : (par1Entity.getInner() ? 0.025F : 0.05F);
/*     */     
/*  86 */     glColor4f(c, p);
/*     */ 
/*     */     
/*  89 */     GL11.glDepthMask(false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  95 */     GL11.glEnable(3042);
/*  96 */     GL11.glDisable(2896);
/*  97 */     GL11.glBlendFunc(770, 771);
/*  98 */     GL11.glAlphaFunc(516, 0.003921569F);
/*     */     
/* 100 */     GL11.glScalef(1.0F + 0.1F * s, 1.0F + 0.07F * s, 1.0F + 0.1F * s);
/* 101 */     GL11.glTranslatef(0.0F, -0.3F - 0.07F * s, 0.0F);
/* 102 */     GL11.glRotatef(var13 * spd2, 0.0F, 1.0F, 0.0F);
/*     */ 
/*     */     
/* 105 */     float w = 0.75F;
/* 106 */     for (int i2 = 0; i2 < (iner ? 2 : 1) && (
/* 107 */       i2 != 1 || var13 <= 10.0F); i2++) {
/* 108 */       for (int i = 0; i < 4; i++) {
/* 109 */         GL11.glPushMatrix();
/*     */         
/* 111 */         GL11.glRotatef((i * 90), 0.0F, 1.0F, 0.0F);
/* 112 */         if (var13 < 15.0F) {
/* 113 */           this.aModel.renderModel(par1Entity, 0.0625F, var13, i2 * w, spd);
/* 114 */           if (hasl2) {
/* 115 */             this.field_76990_c.field_78724_e.func_110577_a(txx2);
/* 116 */             glColor4f(cl2, p);
/*     */             
/* 118 */             this.aModel.renderModel(par1Entity, 0.0625F, var13, i2 * w, spd);
/*     */           } 
/*     */         } 
/*     */         
/* 122 */         GL11.glPopMatrix();
/* 123 */         GL11.glPushMatrix();
/*     */         
/* 125 */         GL11.glRotatef((i * 90 + 45), 0.0F, 1.0F, 0.0F);
/*     */ 
/*     */ 
/*     */         
/* 129 */         this.field_76990_c.field_78724_e.func_110577_a(txx);
/* 130 */         glColor4f(c, p);
/*     */         
/* 132 */         this.aModel.renderModel(par1Entity, 0.0625F, var13 + 4.0F, i2 * w, spd);
/* 133 */         if (hasl2) {
/* 134 */           this.field_76990_c.field_78724_e.func_110577_a(txx2);
/* 135 */           glColor4f(cl2, p);
/*     */           
/* 137 */           this.aModel.renderModel(par1Entity, 0.0625F, var13 + 4.0F, i2 * w, spd);
/*     */         } 
/*     */         
/* 140 */         GL11.glPopMatrix();
/*     */       } 
/*     */     } 
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
/* 164 */     GL11.glDisable(3042);
/* 165 */     GL11.glAlphaFunc(516, 0.1F);
/* 166 */     GL11.glPopMatrix();
/* 167 */     GL11.glDepthMask(true);
/*     */ 
/*     */ 
/*     */     
/* 171 */     GL11.glPopMatrix();
/*     */ 
/*     */     
/* 174 */     if (var13 < par1Entity.getLightLivingTime() && par1Entity.getState() > 4.0F && par1Entity.getState() < 7.0F && !rot) {
/* 175 */       GL11.glPushMatrix();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 181 */       Tessellator tessellator = Tessellator.field_78398_a;
/*     */       
/* 183 */       GL11.glDisable(3553);
/* 184 */       GL11.glDisable(2896);
/* 185 */       GL11.glEnable(3042);
/* 186 */       GL11.glBlendFunc(770, 1);
/* 187 */       double[] adouble = new double[8];
/* 188 */       double[] adouble1 = new double[8];
/* 189 */       double d3 = 0.0D;
/* 190 */       double d4 = 0.0D;
/* 191 */       Random random = new Random(par1Entity.lightVert);
/*     */ 
/*     */ 
/*     */       
/* 195 */       for (int i = 7; i >= 0; i--);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 202 */       int k1 = 0;
/* 203 */       float sc = 0.2F;
/*     */ 
/*     */       
/* 206 */       Random random1 = new Random(par1Entity.lightVert);
/*     */       
/* 208 */       for (int j = 0; j < 3; j++) {
/*     */         
/* 210 */         int k = 7;
/* 211 */         int l = 0;
/*     */         
/* 213 */         if (j > 0)
/*     */         {
/* 215 */           k = 7 - j;
/*     */         }
/*     */         
/* 218 */         if (j > 0)
/*     */         {
/* 220 */           l = k - 2;
/*     */         }
/*     */         
/* 223 */         double d5 = adouble[k] - d3;
/* 224 */         double d6 = adouble1[k] - d4;
/*     */         
/* 226 */         for (int i1 = k; i1 >= l; i1--) {
/*     */           
/* 228 */           double d7 = d5;
/* 229 */           double d8 = d6;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 238 */           d5 += (random1.nextInt(31) - 15) * 0.07000000029802322D;
/* 239 */           d6 += (random1.nextInt(31) - 15) * 0.07000000029802322D;
/*     */ 
/*     */           
/* 242 */           tessellator.func_78371_b(5);
/* 243 */           float f2 = 0.5F;
/* 244 */           tessellator.func_78369_a(0.9F * f2, 0.9F * f2, 1.0F * f2, 0.3F);
/* 245 */           double d9 = 0.1D + k1 * 0.2D;
/*     */           
/* 247 */           if (j == 0);
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 252 */           double d10 = 0.1D + k1 * 0.2D;
/*     */           
/* 254 */           if (j == 0);
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 259 */           for (int j1 = 0; j1 < 5; j1++) {
/*     */             
/* 261 */             double d11 = parX + 0.0D - d9;
/* 262 */             double d12 = parZ + 0.0D - d9;
/*     */             
/* 264 */             if (j1 == 1 || j1 == 2)
/*     */             {
/* 266 */               d11 += d9 * 2.0D * sc;
/*     */             }
/*     */             
/* 269 */             if (j1 == 2 || j1 == 3)
/*     */             {
/* 271 */               d12 += d9 * 2.0D * sc;
/*     */             }
/*     */             
/* 274 */             double d13 = parX + 0.0D - d10;
/* 275 */             double d14 = parZ + 0.0D - d10;
/*     */             
/* 277 */             if (j1 == 1 || j1 == 2)
/*     */             {
/* 279 */               d13 += d10 * 2.0D * sc;
/*     */             }
/*     */             
/* 282 */             if (j1 == 2 || j1 == 3)
/*     */             {
/* 284 */               d14 += d10 * 2.0D * sc;
/*     */             }
/* 286 */             if (i1 < 8) {
/* 287 */               tessellator.func_78377_a(d13 + d5 * sc, parY - (i1 * 1 - 7) * sc, d14 + d6 * sc);
/* 288 */               tessellator.func_78377_a(d11 + d7 * sc, parY - ((i1 + 1) * 1 - 7) * sc, d12 + d8 * sc);
/*     */             } 
/*     */           } 
/*     */           
/* 292 */           tessellator.func_78381_a();
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 297 */       GL11.glDisable(3042);
/* 298 */       GL11.glEnable(2896);
/* 299 */       GL11.glEnable(3553);
/*     */       
/* 301 */       GL11.glPopMatrix();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void glColor4f(int c, float a) {
/* 306 */     float h2 = (c >> 16 & 0xFF) / 255.0F;
/* 307 */     float h3 = (c >> 8 & 0xFF) / 255.0F;
/* 308 */     float h4 = (c & 0xFF) / 255.0F;
/* 309 */     float h1 = 1.0F;
/* 310 */     GL11.glColor4f(h1 * h2, h1 * h3, h1 * h4, a);
/*     */   }
/*     */ 
/*     */   
/*     */   protected float handleRotationFloat(Entity par1Entity, float par2) {
/* 315 */     return par1Entity.field_70173_aa + par2;
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
/*     */   public void func_76986_a(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
/* 340 */     renderAura((EntityAura)par1Entity, par2, par4, par6, par8, par9);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\RenderAura.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */