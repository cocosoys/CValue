/*     */ package JinRyuu.JRMCore.entity;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreClient;
/*     */ import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.entity.RenderManager;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class RenderCusPar extends RenderJRMC {
/*     */   private ModelPG model1;
/*     */   private ModelPS model2;
/*     */   
/*     */   public RenderCusPar() {
/*  20 */     super((ModelBase)new ModelAura(), 0.5F);
/*     */   }
/*     */   public void renderAura(EntityCusPar entity, double parX, double parY, double parZ, float par8, float par9) {
/*  23 */     this.field_76989_e = 0.0F;
/*  24 */     GL11.glPushMatrix();
/*  25 */     GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/*  26 */     GL11.glTranslatef((float)-parX, (float)-parY - entity.field_70131_O / 2.0F, (float)parZ);
/*     */     
/*  28 */     GL11.glPushMatrix();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  34 */     boolean harom = false;
/*  35 */     if (JGConfigClientSettings.CLIENT_GR11 && entity.getdata34() == 0) {
/*  36 */       int id = entity.getId();
/*  37 */       for (; id > 4; id -= 5);
/*  38 */       this.model1 = new ModelPG(id);
/*  39 */       harom = true;
/*     */     } 
/*     */     
/*  42 */     if (JGConfigClientSettings.CLIENT_GR10 && entity.getdata34() == 1) {
/*  43 */       int id = entity.getId();
/*  44 */       for (; id > 4; id -= 5);
/*  45 */       this.model2 = new ModelPS(id);
/*  46 */       harom = true;
/*     */     } 
/*     */     
/*  49 */     if (!harom) {
/*  50 */       boolean view2 = (JRMCoreClient.mc.field_71474_y.field_74320_O == 2);
/*  51 */       GL11.glPushMatrix();
/*     */       
/*  53 */       GL11.glScalef(1.0F, 1.0F, 1.0F);
/*     */ 
/*     */       
/*  56 */       ResourceLocation tx = new ResourceLocation(entity.getdata3());
/*  57 */       this.field_76990_c.field_78724_e.func_110577_a(tx);
/*  58 */       if (entity.getdata42() == 0) {
/*  59 */         GL11.glRotatef(RenderManager.field_78727_a.field_78735_i, 0.0F, 1.0F, 0.0F);
/*  60 */         GL11.glRotatef(RenderManager.field_78727_a.field_78732_j * (view2 ? true : -1), 1.0F, 0.0F, 0.0F);
/*     */       }
/*  62 */       else if (entity.getdata42() == 1 && entity.hasEnt()) {
/*     */         
/*  64 */         GL11.glRotatef((entity.getEnt()).field_70177_z, 0.0F, 1.0F, 0.0F);
/*     */       }
/*  66 */       else if (entity.getdata42() == 2 && entity.hasEnt()) {
/*     */         
/*  68 */         GL11.glRotatef((entity.getEnt()).field_70125_A * (view2 ? true : -1), 1.0F, 0.0F, 0.0F);
/*     */       
/*     */       }
/*  71 */       else if (entity.getdata42() == 3 && entity.hasEnt()) {
/*     */ 
/*     */         
/*  74 */         GL11.glRotatef((entity.getEnt()).field_70177_z, 0.0F, 1.0F, 0.0F);
/*  75 */         if (!view2) { GL11.glRotatef((entity.getEnt()).field_70125_A, -1.0F, 0.0F, 0.0F); }
/*  76 */         else { GL11.glRotatef((entity.getEnt()).field_70125_A, -1.0F, 0.0F, 0.0F); }
/*     */       
/*  78 */       }  GL11.glTranslatef(entity.getdata43(), entity.getdata44(), entity.getdata45());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  87 */       fieldPass2(entity);
/*  88 */       GL11.glPopMatrix();
/*     */     } else {
/*     */       
/*  91 */       ResourceLocation tx = new ResourceLocation("jinryuumodscore:allw.png");
/*  92 */       this.field_76990_c.field_78724_e.func_110577_a(tx);
/*  93 */       GL11.glTranslatef(entity.getdata43(), entity.getdata44(), entity.getdata45());
/*  94 */       fieldPass3(0, 0, entity);
/*     */     } 
/*     */     
/*  97 */     GL11.glPopMatrix();
/*  98 */     GL11.glDepthMask(true);
/*  99 */     GL11.glPopMatrix();
/*     */   }
/*     */   public void func_76986_a(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
/* 102 */     renderAura((EntityCusPar)par1Entity, par2, par4, par6, par8, par9);
/*     */   }
/*     */   
/*     */   public void drawTexturedModalRect(float x, float y, int u, int v, float width, float height, float z) {
/* 106 */     float f = 0.00390625F;
/* 107 */     float f1 = 0.00390625F;
/* 108 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 109 */     tessellator.func_78382_b();
/* 110 */     tessellator.func_78374_a(x, (y + 0.0F), z, ((u + 0) * f), ((v + 0) * f1));
/* 111 */     tessellator.func_78374_a(x, (y + height), z, ((u + 0) * f), ((v + height) * f1));
/* 112 */     tessellator.func_78374_a((x + width), (y + height), z, ((u + width) * f), ((v + height) * f1));
/* 113 */     tessellator.func_78374_a((x + width), (y + 0.0F), z, ((u + width) * f), ((v + 0) * f1));
/* 114 */     tessellator.func_78381_a();
/*     */   }
/*     */   
/*     */   private void fieldPass2(EntityCusPar e) {
/* 118 */     GL11.glPushMatrix();
/* 119 */     float scale = func_cs(e);
/* 120 */     GL11.glScalef(scale, scale, scale);
/* 121 */     GL11.glEnable(3042);
/* 122 */     GL11.glDisable(2896);
/* 123 */     GL11.glBlendFunc(770, 771);
/* 124 */     GL11.glAlphaFunc(516, 0.003921569F);
/* 125 */     GL11.glDepthMask(false);
/*     */ 
/*     */     
/* 128 */     int id = e.getId();
/*     */ 
/*     */ 
/*     */     
/* 132 */     float rot = (e.field_70173_aa * 5) * e.getRotation_Sp();
/* 133 */     GL11.glRotatef((e.getRotation() ? rot : (0.0F - rot)) + e.getdata39(), 0.0F, 0.0F, 1.0F);
/* 134 */     float rot2 = (e.field_70173_aa * 5) * e.getRotation_Sp2() * 2.0F;
/* 135 */     GL11.glRotatef((e.getRotation2() ? rot2 : (0.0F - rot2)) + e.getdata40(), 1.0F, 0.0F, 0.0F);
/* 136 */     GL11.glRotatef(e.getdata40(), 0.0F, 1.0F, 0.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 141 */     int id_y = id / 256 / e.getdata32();
/*     */     
/* 143 */     id -= id_y * 256 / e.getdata32();
/*     */     
/* 145 */     float f = e.getdata28();
/* 146 */     if (e.getdata35() && e.hasEnt() && JRMCoreClient.mc.field_71439_g != null && e.getEnt().equals(JRMCoreClient.mc.field_71439_g) && JRMCoreClient.mc.field_71474_y.field_74320_O == 0) f *= JGConfigClientSettings.CLIENT_DA3 / 10.0F;
/*     */     
/* 148 */     float clr1 = func_rch(e, e.getdata8(), e.getdata11(), e.getdata14(), e.field_70173_aa);
/* 149 */     float clr2 = func_rch(e, e.getdata9(), e.getdata12(), e.getdata15(), e.field_70173_aa);
/* 150 */     float clr3 = func_rch(e, e.getdata10(), e.getdata13(), e.getdata16(), e.field_70173_aa);
/*     */     
/* 152 */     GL11.glColor4f(clr1, clr2, clr3, f);
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
/* 163 */     drawTexturedModalRect(-(e.getdata32() / 2), -(e.getdata32() / 2), id * e.getdata32(), id_y * e.getdata32(), e.getdata32(), e.getdata32(), 0.0F);
/*     */ 
/*     */     
/* 166 */     GL11.glEnable(2896);
/* 167 */     GL11.glDisable(3042);
/*     */     
/* 169 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */   
/*     */   private void fieldPass3(int guiLeftO, int guiTopO, EntityCusPar e) {
/*     */     float scale;
/* 175 */     GL11.glPushMatrix();
/* 176 */     int type = e.getdata34();
/*     */     
/* 178 */     if (type == 0) { scale = 0.8F; }
/* 179 */     else { scale = 0.5F; }
/* 180 */      GL11.glScalef(scale, scale, scale);
/* 181 */     GL11.glEnable(3042);
/* 182 */     GL11.glDisable(2896);
/* 183 */     GL11.glBlendFunc(770, 771);
/* 184 */     GL11.glAlphaFunc(516, 0.003921569F);
/* 185 */     GL11.glDepthMask(false);
/*     */     
/* 187 */     float rot = (e.field_70173_aa * 5) * e.getRotation_Sp();
/* 188 */     GL11.glRotatef((e.getRotation() ? rot : (0.0F - rot)) + e.getdata39(), 0.0F, 0.0F, 1.0F);
/* 189 */     float rot2 = (e.field_70173_aa * 5) * e.getRotation_Sp2() * 2.0F;
/* 190 */     GL11.glRotatef((e.getRotation2() ? rot2 : (0.0F - rot2)) + e.getdata40(), 1.0F, 0.0F, 0.0F);
/* 191 */     GL11.glRotatef(e.getdata40(), 0.0F, 1.0F, 0.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 196 */     float f = e.getdata28();
/*     */     
/* 198 */     if (e.getdata35() && e.hasEnt() && JRMCoreClient.mc.field_71439_g != null && e.getEnt().equals(JRMCoreClient.mc.field_71439_g) && JRMCoreClient.mc.field_71474_y.field_74320_O == 0) f *= JGConfigClientSettings.CLIENT_DA3 / 10.0F; 
/* 199 */     if (e.getdata34() == 0) { GL11.glColor4f(0.3F, 0.55F, 0.25F, f); }
/* 200 */     else { GL11.glColor4f(0.56078434F, 0.48235294F, 0.43137255F, f); }
/*     */ 
/*     */     
/* 203 */     if (type == 0) { this.model1.func_78088_a(e, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F); }
/* 204 */     else { this.model2.func_78088_a(e, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F); }
/*     */ 
/*     */     
/* 207 */     GL11.glEnable(2896);
/* 208 */     GL11.glDisable(3042);
/* 209 */     GL11.glPopMatrix();
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
/*     */   private float func_rch(EntityCusPar entity, float f1, float f2, float f3, float f4) {
/* 222 */     float fl1 = f1;
/*     */     
/* 224 */     if (entity.getdata31() == 1) {
/* 225 */       fl1 = f1 + f2 * f4;
/*     */       
/* 227 */       if (f2 > 0.0F && fl1 > f3) {
/* 228 */         fl1 = f3;
/* 229 */       } else if (f2 < 0.0F && fl1 < f3) {
/* 230 */         fl1 = f3;
/*     */       } 
/* 232 */     } else if (entity.getdata31() == 2) {
/* 233 */       if (f1 < f3) {
/* 234 */         float szaz = entity.getdata2();
/* 235 */         float egy = szaz / 100.0F;
/* 236 */         float calc = entity.field_70173_aa / egy;
/*     */         
/* 238 */         fl1 = (f3 - f1) / 100.0F * calc + f1;
/*     */       }
/* 240 */       else if (f1 > f3) {
/* 241 */         float szaz = entity.getdata2();
/* 242 */         float egy = szaz / 100.0F;
/* 243 */         float calc = entity.field_70173_aa / egy;
/*     */         
/* 245 */         fl1 = f1 - (f1 - f3) / 100.0F * calc;
/*     */       } 
/*     */     } 
/*     */     
/* 249 */     return fl1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private float func_cs(EntityCusPar entity) {
/* 258 */     float f1 = 0.0F, f2 = 0.0F, f3 = 0.0F;
/* 259 */     if (entity.getdata4() == 0) {
/* 260 */       f1 = entity.getdata5();
/* 261 */     } else if (entity.getdata4() == 1) {
/*     */       
/* 263 */       f2 = entity.getdata7();
/* 264 */       f3 = entity.getdata6();
/* 265 */       f1 = entity.getdata5() + entity.field_70173_aa * f2;
/*     */       
/* 267 */       if (f2 > 0.0F && f1 > f3) {
/* 268 */         f1 = f3;
/* 269 */       } else if (f2 < 0.0F && f1 < f3) {
/* 270 */         f1 = f3;
/*     */       } 
/* 272 */     } else if (entity.getdata4() == 2) {
/*     */       
/* 274 */       f2 = entity.getdata7();
/* 275 */       f3 = entity.getdata6();
/*     */       
/* 277 */       float szaz = entity.getdata2();
/* 278 */       float egy = szaz / 100.0F;
/* 279 */       float calc = entity.field_70173_aa / egy;
/*     */       
/* 281 */       if (f2 > 0.0F) {
/* 282 */         f1 = entity.getdata5() / 100.0F * calc;
/*     */       }
/* 284 */       else if (f2 < 0.0F) {
/* 285 */         f1 = entity.getdata5() - entity.getdata5() / 100.0F * calc;
/*     */       } 
/*     */     } 
/*     */     
/* 289 */     return f1;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\entity\RenderCusPar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */