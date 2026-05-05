/*     */ package JinRyuu.JRMCore.entity;
/*     */ 
/*     */ import JinRyuu.JBRA.ModelRendererJBRA;
/*     */ import JinRyuu.JRMCore.JRMCoreClient;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.i.ExtendedPlayer;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelBiped;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
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
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class ModelBipedBody
/*     */   extends ModelBiped
/*     */ {
/*     */   public ModelRenderer field_78116_c;
/*     */   public ModelRenderer field_78115_e;
/*     */   public ModelRenderer field_78112_f;
/*     */   public ModelRenderer field_78113_g;
/*     */   public ModelRenderer field_78123_h;
/*     */   public ModelRenderer field_78124_i;
/*     */   public ModelRenderer body;
/*     */   public ModelRenderer rightarm;
/*     */   public ModelRenderer leftarm;
/*     */   public ModelRenderer Brightarm;
/*     */   public ModelRenderer Bleftarm;
/*     */   public ModelRenderer rightleg;
/*     */   public ModelRenderer leftleg;
/*     */   public ModelRenderer skirt1;
/*     */   public ModelRenderer skirt2;
/*     */   public ModelRenderer hip;
/*     */   public ModelRenderer waist;
/*     */   public ModelRenderer Bbreast;
/*     */   public ModelRenderer breast;
/*     */   public ModelRenderer bottom;
/*     */   public ModelRenderer hip2;
/*     */   public ModelRenderer breast2;
/*     */   public ModelRenderer bottom2;
/*     */   public ModelRenderer Bbreast2;
/*     */   public int field_78119_l;
/*     */   public int field_78120_m;
/*     */   public boolean field_78117_n;
/*     */   public boolean field_78118_o;
/*     */   public float rot1;
/*     */   public float rot4;
/*     */   public float rot3;
/*     */   public float rot2;
/*     */   public float rot5;
/*     */   public float rot6;
/*     */   public Entity Entity;
/*     */   
/*     */   public ModelBipedBody() {
/*  78 */     this(0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public ModelBipedBody(float par1) {
/*  83 */     this(par1, 0.0F, 64, 32);
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
/*     */   public void rot(ModelRenderer var7, ModelRenderer var1) {
/*     */     var7.field_78795_f = var1.field_78795_f;
/*     */     var7.field_78796_g = var1.field_78796_g;
/*     */     var7.field_78808_h = var1.field_78808_h;
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
/*     */   public void func_78088_a(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
/*     */     this.rot1 = par2;
/*     */     this.rot2 = par3;
/*     */     this.rot3 = par4;
/*     */     this.rot4 = par5;
/*     */     this.rot5 = par6;
/*     */     this.rot6 = par7;
/*     */     this.Entity = par1Entity;
/*     */     func_78087_a(par2, par3, par4, par5, par6, par7, par1Entity);
/*     */     renderBody(par7);
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
/*     */   public void renderBody(float par7) {
/*     */     float f5 = par7;
/*     */     if (g <= 1) {
/*     */       if (this.field_78091_s) {
/*     */         float var8 = 2.0F;
/*     */         GL11.glPushMatrix();
/*     */         GL11.glScalef(1.5F / var8, 1.5F / var8, 1.5F / var8);
/*     */         GL11.glTranslatef(0.0F, 16.0F * par7, 0.0F);
/*     */         this.field_78116_c.func_78785_a(par7);
/*     */         GL11.glPopMatrix();
/*     */         GL11.glPushMatrix();
/*     */         GL11.glScalef(1.0F / var8, 1.0F / var8, 1.0F / var8);
/*     */         GL11.glTranslatef(0.0F, 24.0F * par7, 0.0F);
/*     */         this.field_78115_e.func_78785_a(par7);
/*     */         this.field_78112_f.func_78785_a(par7);
/*     */         this.field_78113_g.func_78785_a(par7);
/*     */         this.field_78123_h.func_78785_a(par7);
/*     */         this.field_78124_i.func_78785_a(par7);
/*     */         GL11.glPopMatrix();
/*     */       } else {
/*     */         float f6 = f;
/*     */         GL11.glPushMatrix();
/*     */         GL11.glScalef(0.5F + 0.5F / f6, 0.5F + 0.5F / f6, 0.5F + 0.5F / f6);
/*     */         GL11.glTranslatef(0.0F, (f6 - 1.0F) / f6 * (2.0F - ((f6 >= 1.5F && f6 <= 2.0F) ? ((2.0F - f6) / 2.5F) : ((f6 < 1.5F && f6 >= 1.0F) ? ((f6 * 2.0F - 2.0F) * 0.2F) : 0.0F))), 0.0F);
/*     */         this.field_78116_c.func_78785_a(par7);
/*     */         GL11.glPopMatrix();
/*     */         GL11.glPushMatrix();
/*     */         GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
/*     */         GL11.glTranslatef(0.0F, (f6 - 1.0F) * 1.5F, 0.0F);
/*     */         this.field_78115_e.func_78785_a(par7);
/*     */         this.field_78112_f.func_78785_a(par7);
/*     */         this.field_78113_g.func_78785_a(par7);
/*     */         this.field_78123_h.func_78785_a(par7);
/*     */         this.field_78124_i.func_78785_a(par7);
/*     */         GL11.glPopMatrix();
/*     */       } 
/*     */     } else {
/*     */       float f6 = f;
/*     */       GL11.glPushMatrix();
/*     */       GL11.glScalef((0.5F + 0.5F / f6) * ((g <= 1) ? 1.0F : 0.85F), 0.5F + 0.5F / f6, (0.5F + 0.5F / f6) * ((g <= 1) ? 1.0F : 0.85F));
/*     */       GL11.glTranslatef(0.0F, (f6 - 1.0F) / f6 * (2.0F - ((f6 >= 1.5F && f6 <= 2.0F) ? ((2.0F - f6) / 2.5F) : ((f6 < 1.5F && f6 >= 1.0F) ? ((f6 * 2.0F - 2.0F) * 0.2F) : 0.0F))), 0.0F);
/*     */       this.field_78116_c.func_78785_a(f5);
/*     */       GL11.glPopMatrix();
/*     */       GL11.glPushMatrix();
/*     */       GL11.glScalef(1.0F / f6 * ((g <= 1) ? 1.0F : 0.7F), 1.0F / f6, 1.0F / f6 * ((g <= 1) ? 1.0F : 0.7F));
/*     */       GL11.glTranslatef(0.0F, (f6 - 1.0F) * 1.5F, 0.0F);
/*     */       this.Brightarm.func_78785_a(f5);
/*     */       this.Bleftarm.func_78785_a(f5);
/*     */       GL11.glPopMatrix();
/*     */       GL11.glPushMatrix();
/*     */       GL11.glScalef(1.0F / f6 * ((g <= 1) ? 1.0F : 0.85F), 1.0F / f6, 1.0F / f6 * ((g <= 1) ? 1.0F : 0.775F));
/*     */       if (this.field_78117_n) {
/*     */         GL11.glTranslatef(-0.015F, (f6 - 1.0F) * 1.5F, -0.0F);
/*     */       } else {
/*     */         GL11.glTranslatef(-0.015F, (f6 - 1.0F) * 1.5F, -0.015F);
/*     */       } 
/*     */       this.rightleg.func_78785_a(f5);
/*     */       GL11.glPopMatrix();
/*     */       GL11.glPushMatrix();
/*     */       GL11.glScalef(1.0F / f6 * ((g <= 1) ? 1.0F : 0.85F), 1.0F / f6, 1.0F / f6 * ((g <= 1) ? 1.0F : 0.775F));
/*     */       if (this.field_78117_n) {
/*     */         GL11.glTranslatef(0.015F, (f6 - 1.0F) * 1.5F, -0.0F);
/*     */       } else {
/*     */         GL11.glTranslatef(0.015F, (f6 - 1.0F) * 1.5F, -0.015F);
/*     */       } 
/*     */       this.leftleg.func_78785_a(f5);
/*     */       GL11.glPopMatrix();
/*     */       GL11.glPushMatrix();
/*     */       GL11.glScalef(1.0F / f6 * ((g <= 1) ? 1.0F : 0.675F), 1.0F / f6, 1.0F / f6 * ((g <= 1) ? 1.0F : 0.8F));
/*     */       int b = 6;
/*     */       String[] s = JRMCoreH.data(this.Entity.func_70005_c_(), 1, "0;0;0;0;0;0;0;0;0").split(";");
/*     */       String dns = s[1];
/*     */       b = JRMCoreH.dnsBreast(dns);
/*     */       float scale = b * 0.03F;
/*     */       float br = 0.4235988F + scale;
/*     */       float bs = 0.8F + scale;
/*     */       float bsY = 0.85F + scale * 0.5F;
/*     */       float bt = 0.1F * scale;
/*     */       boolean bounce = (this.Entity.field_70122_E || this.Entity.func_70090_H());
/*     */       float bspeed = this.Entity.func_70051_ag() ? 1.5F : (this.Entity.func_70093_af() ? 0.5F : 1.0F);
/*     */       float bbY = (bounce ? (MathHelper.func_76126_a(this.rot1 * 0.6662F * bspeed * 1.5F + 3.1415927F) * this.rot2 * 0.03F) : 0.0F) * b * 0.1119F;
/*     */       GL11.glTranslatef(0.0F, (f6 - 1.0F) * 1.5F + bbY, 0.015F + bt);
/*     */       GL11.glScalef(1.0F, bsY, bs);
/*     */       setRotation(this.breast, -br, 0.0F, 0.0F);
/*     */       setRotation(this.breast2, br, 3.141593F, 0.0F);
/*     */       if (bounce) {
/*     */         this.breast.field_78795_f += -MathHelper.func_76134_b(this.rot1 * 0.6662F * bspeed + 3.1415927F) * this.rot2 * 0.05F * b * 0.1119F;
/*     */         this.breast.field_78796_g += MathHelper.func_76134_b(this.rot1 * 0.6662F * bspeed + 3.1415927F) * this.rot2 * 0.02F * b * 0.1119F;
/*     */         this.breast2.field_78795_f += MathHelper.func_76134_b(this.rot1 * 0.6662F * bspeed + 3.1415927F) * this.rot2 * 0.05F * b * 0.1119F;
/*     */         this.breast2.field_78796_g += MathHelper.func_76134_b(this.rot1 * 0.6662F * bspeed + 3.1415927F) * this.rot2 * 0.02F * b * 0.1119F;
/*     */       } 
/*     */       this.Bbreast.func_78785_a(f5);
/*     */       GL11.glPopMatrix();
/*     */       GL11.glPushMatrix();
/*     */       GL11.glScalef(1.0F / f6 * ((g <= 1) ? 1.0F : 0.7F), 1.0F / f6, 1.0F / f6 * ((g <= 1) ? 1.0F : 0.7F));
/*     */       GL11.glTranslatef(0.0F, (f6 - 1.0F) * 1.5F, 0.0F);
/*     */       this.body.func_78785_a(f5);
/*     */       GL11.glPopMatrix();
/*     */       GL11.glPushMatrix();
/*     */       GL11.glScalef(1.0F / f6 * ((g <= 1) ? 1.0F : 0.75F), 1.0F / f6, 1.0F / f6 * ((g <= 1) ? 1.0F : 0.75F) * (1.0F + 0.005F * p));
/*     */       if (this.field_78117_n) {
/*     */         GL11.glTranslatef(0.0F, (f6 - 1.0F) * 1.5F, 0.0F);
/*     */       } else {
/*     */         GL11.glTranslatef(0.0F, (f6 - 1.0F) * 1.5F, -0.02F - 5.0E-4F * p);
/*     */       } 
/*     */       this.hip.func_78785_a(f5);
/*     */       GL11.glPopMatrix();
/*     */       GL11.glPushMatrix();
/*     */       GL11.glScalef(1.0F / f6 * ((g <= 1) ? 1.0F : 0.65F), 1.0F / f6, 1.0F / f6 * ((g <= 1) ? 1.0F : 0.65F) * (1.0F + 0.001F * p));
/*     */       if (this.field_78117_n) {
/*     */         GL11.glTranslatef(0.0F, (f6 - 1.0F) * 1.5F, 0.0F);
/*     */       } else {
/*     */         GL11.glTranslatef(0.0F, (f6 - 1.0F) * 1.5F, -0.04F - 1.0E-4F * p);
/*     */       } 
/*     */       this.waist.func_78785_a(f5);
/*     */       GL11.glPopMatrix();
/*     */       GL11.glPushMatrix();
/*     */       GL11.glScalef(1.0F / f6 * ((g <= 1) ? 1.0F : 0.85F), 1.0F / f6, 1.0F / f6 * ((g <= 1) ? 1.0F : 0.85F) * (1.0F + 0.005F * p));
/*     */       GL11.glTranslatef(0.0F, (f6 - 1.0F) * 1.5F, 0.0F - 5.0E-4F * p);
/*     */       this.bottom.func_78785_a(f5);
/*     */       GL11.glPopMatrix();
/*     */       GL11.glPushMatrix();
/*     */       GL11.glScalef(1.0F / f6 * ((g <= 1) ? 1.0F : 0.675F) - 0.001F, 1.0F / f6, 1.0F / f6 * ((g <= 1) ? 1.0F : 0.8F) - 0.001F);
/*     */       GL11.glTranslatef(0.0F, (f6 - 1.0F) * 1.5F + 0.001F + bbY, 0.015F + bt);
/*     */       GL11.glScalef(1.0F, bsY, bs);
/*     */       this.Bbreast2.func_78785_a(f5);
/*     */       GL11.glPopMatrix();
/*     */     } 
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
/*     */   public static float f = 1.0F;
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
/*     */   public static int g = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int y = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int animation = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int p = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ModelRenderer RA;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ModelRenderer LA;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ModelRenderer RL;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ModelRenderer LL;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ModelRenderer B;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ModelRenderer B1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ModelRenderer B2;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ModelRenderer B3;
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
/*     */   public ModelBipedBody(float par1, float par2, int par3, int par4) {
/* 407 */     this.blk = false;
/* 408 */     this.instantTransmission = false;
/* 409 */     this.KiAttack = 0; this.field_78119_l = 0; this.field_78120_m = 0; this.field_78117_n = false; this.field_78118_o = false; this.field_78090_t = par3; this.field_78089_u = par4; this.field_78116_c = new ModelRenderer((ModelBase)this, 0, 0); this.field_78116_c.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, par1); this.field_78116_c.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.field_78115_e = new ModelRenderer((ModelBase)this, 16, 16); this.field_78115_e.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, par1); this.field_78115_e.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.field_78112_f = new ModelRenderer((ModelBase)this, 40, 16); this.field_78112_f.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, par1); this.field_78112_f.func_78793_a(-5.0F, 2.0F + par2, 0.0F); this.field_78113_g = new ModelRenderer((ModelBase)this, 40, 16); this.field_78113_g.field_78809_i = true; this.field_78113_g.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, par1); this.field_78113_g.func_78793_a(5.0F, 2.0F + par2, 0.0F); this.field_78123_h = new ModelRenderer((ModelBase)this, 0, 16); this.field_78123_h.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, par1); this.field_78123_h.func_78793_a(-1.9F, 12.0F + par2, 0.0F); this.field_78124_i = new ModelRenderer((ModelBase)this, 0, 16); this.field_78124_i.field_78809_i = true; this.field_78124_i.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, par1); this.field_78124_i.func_78793_a(1.9F, 12.0F + par2, 0.0F); this.rightarm = new ModelRenderer((ModelBase)this, 40, 16); this.rightarm.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, par1 * 0.5F); this.rightarm.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.rightarm, 0.0F, 0.0F, 0.122173F); this.leftarm = new ModelRenderer((ModelBase)this, 40, 16); this.leftarm.field_78809_i = true; this.leftarm.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, par1 * 0.5F); this.leftarm.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.leftarm, 0.0F, 0.0F, -0.122173F); this.Brightarm = new ModelRenderer((ModelBase)this, 0, 0); this.Brightarm.func_78790_a(-3.0F, -2.0F, -2.0F, 0, 0, 0, par1 * 0.5F); this.Brightarm.func_78793_a(-5.0F, 2.0F, 0.0F); this.Bleftarm = new ModelRenderer((ModelBase)this, 0, 0); this.Bleftarm.field_78809_i = true; this.Bleftarm.func_78790_a(-1.0F, -2.0F, -2.0F, 0, 0, 0, par1 * 0.5F); this.Bleftarm.func_78793_a(5.0F, 2.0F, 0.0F); this.rightleg = new ModelRenderer((ModelBase)this, 0, 16); this.rightleg.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, par1 * 0.5F); this.rightleg.func_78793_a(-2.0F, 12.0F, 0.0F); setRotation(this.rightleg, 0.0F, 0.0F, 0.0F); this.leftleg = new ModelRenderer((ModelBase)this, 0, 16); this.leftleg.field_78809_i = true; this.leftleg.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, par1 * 0.5F); this.leftleg.func_78793_a(2.0F, 12.0F, 0.0F); setRotation(this.leftleg, 0.0F, 0.0F, 0.0F); this.skirt1 = new ModelRenderer((ModelBase)this, 16, 18); this.skirt1.func_78790_a(-4.0F, 9.0F, -2.0F, 8, 2, 4, par1 * 0.5F); this.skirt1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.skirt1, 0.0F, 0.0F, 0.0F); this.skirt2 = new ModelRenderer((ModelBase)this, 16, 20); this.skirt2.func_78790_a(-4.0F, 11.0F, -2.0F, 8, 1, 4, par1 * 0.5F); this.skirt2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.skirt2, 0.0F, 0.0F, 0.0F); this.body = new ModelRenderer((ModelBase)this, 16, 16); this.body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 4, 4, par1 * 0.5F); this.body.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.body, 0.0F, 0.0F, 0.0F); this.hip2 = new ModelRenderer((ModelBase)this, 16, 16); this.hip2.func_78789_a(-4.0F, 7.0F, -2.0F, 8, 2, 4); this.hip2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.hip2, 0.0F, 0.0F, 0.0F); this.hip = new ModelRenderer((ModelBase)this, 16, 23); this.hip.func_78790_a(-4.0F, 7.0F, -2.0F, 8, 2, 4, par1 * 0.5F); this.hip.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.hip, 0.0F, 0.0F, 0.0F); this.waist = new ModelRenderer((ModelBase)this, 16, 20); this.waist.func_78790_a(-4.0F, 4.0F, -2.0F, 8, 3, 4, par1 * 0.5F); this.waist.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.waist, 0.0F, 0.0F, 0.0F); this.Bbreast = new ModelRenderer((ModelBase)this, 0, 0); this.Bbreast.func_78790_a(-4.0F, 2.266667F, -1.0F, 0, 0, 0, par1 * 0.5F); this.Bbreast.func_78793_a(0.0F, 0.0F, 0.0F); this.breast = new ModelRenderer((ModelBase)this, 17, 18); this.breast.func_78790_a(-4.0F, 2.266667F, -1.0F, 8, 3, 3, par1 * 0.5F); this.breast.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.breast, -0.5235988F, 0.0F, 0.0F); this.Bbreast2 = new ModelRenderer((ModelBase)this, 0, 0); this.Bbreast2.func_78790_a(-4.0F, 2.266667F, -1.0F, 0, 0, 0, par1 * 0.5F); this.Bbreast2.func_78793_a(0.0F, 0.0F, 0.0F); this.breast2 = new ModelRenderer((ModelBase)this, 9, 23); this.breast2.field_78809_i = true; this.breast2.func_78790_a(-4.0F, 2.266667F, -2.0F, 8, 3, 3, par1 * 0.5F); this.breast2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.breast2, 0.5235988F, 3.141593F, 0.0F); this.bottom2 = new ModelRenderer((ModelBase)this, 16, 16);
/*     */     this.bottom2.func_78790_a(-4.0F, 9.0F, -2.0F, 8, 3, 4, par1 * 0.5F);
/*     */     this.bottom2.func_78793_a(0.0F, 0.0F, 0.0F);
/*     */     setRotation(this.bottom2, 0.0F, 0.0F, 0.0F);
/*     */     this.bottom = new ModelRenderer((ModelBase)this, 16, 25);
/*     */     this.bottom.func_78790_a(-4.0F, 9.0F, -2.0F, 8, 3, 4, par1 * 0.5F);
/*     */     this.bottom.func_78793_a(0.0F, 0.0F, 0.0F);
/*     */     setRotation(this.bottom, 0.0F, 0.0F, 0.0F);
/*     */     this.Bbreast.func_78792_a(this.breast);
/*     */     this.Bbreast2.func_78792_a(this.breast2);
/*     */     this.Bleftarm.func_78792_a(this.leftarm);
/* 420 */     this.Brightarm.func_78792_a(this.rightarm); } public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) { EntityPlayer p = null;
/* 421 */     if (par7Entity instanceof EntityPlayer) {
/*     */       
/* 423 */       p = (EntityPlayer)par7Entity;
/*     */ 
/*     */       
/* 426 */       if (par7Entity != JRMCoreClient.mc.field_71439_g || (par7Entity == JRMCoreClient.mc.field_71439_g && JRMCoreClient.mc.field_71474_y.field_74320_O != 0)) {
/*     */         
/* 428 */         ExtendedPlayer props = ExtendedPlayer.get(p);
/* 429 */         boolean block = (props.getBlocking() == 1);
/* 430 */         boolean instantTransmissionOn = (props.getBlocking() == 2);
/* 431 */         int kishoot = props.getAnimKiShoot();
/* 432 */         this.blk = block;
/* 433 */         this.instantTransmission = instantTransmissionOn;
/* 434 */         this.KiAttack = kishoot;
/*     */       }
/*     */       else {
/*     */         
/* 438 */         this.blk = false;
/* 439 */         this.instantTransmission = false;
/* 440 */         this.KiAttack = 0;
/*     */       } 
/*     */     } 
/* 443 */     int pwr = 0;
/* 444 */     if (p != null && JRMCoreH.plyrs != null && JRMCoreH.plyrs.length > 0 && !p.func_82150_aj() && JRMCoreH.dnn(1))
/*     */     {
/* 446 */       for (int pl = 0; pl < JRMCoreH.plyrs.length; pl++) {
/*     */         
/* 448 */         if (JRMCoreH.plyrs[pl].equals(p.func_70005_c_()) && JRMCoreH.data1.length >= JRMCoreH.plyrs.length) {
/* 449 */           String[] s = JRMCoreH.data1[pl].split(";");
/* 450 */           pwr = Integer.parseInt(s[2]);
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     }
/* 456 */     if (g >= 2) {
/*     */       
/* 458 */       this.RA = this.Brightarm;
/* 459 */       this.LA = this.Bleftarm;
/* 460 */       this.RL = this.rightleg;
/* 461 */       this.LL = this.leftleg;
/* 462 */       this.B = this.Bbreast;
/* 463 */       this.B1 = this.body;
/* 464 */       this.B2 = this.hip;
/* 465 */       this.B3 = this.waist;
/* 466 */       this.B4 = this.bottom;
/* 467 */       this.B5 = this.Bbreast2;
/* 468 */       this.B7 = this.hip2;
/* 469 */       this.B9 = this.bottom2;
/*     */     }
/*     */     else {
/*     */       
/* 473 */       this.RA = this.field_78112_f;
/* 474 */       this.LA = this.field_78113_g;
/* 475 */       this.RL = this.field_78123_h;
/* 476 */       this.LL = this.field_78124_i;
/* 477 */       this.B = this.B1 = this.B2 = this.B3 = this.B4 = this.B5 = this.B7 = this.B9 = this.field_78115_e;
/*     */     } 
/*     */     
/* 480 */     this.field_78116_c.field_78796_g = par4 / 57.295776F;
/* 481 */     this.field_78116_c.field_78795_f = par5 / 57.295776F;
/*     */     
/* 483 */     if (y == 3) {
/*     */       
/* 485 */       p.field_70761_aq = 0.0F;
/* 486 */       this.field_78116_c.field_78795_f = -0.17453294F;
/* 487 */       this.field_78116_c.field_78796_g = -0.17453294F;
/*     */     } 
/*     */     
/* 490 */     this.field_78114_d.field_78796_g = this.field_78116_c.field_78796_g;
/* 491 */     this.field_78114_d.field_78795_f = this.field_78116_c.field_78795_f;
/* 492 */     if (y == 4 || y == 5) {
/* 493 */       this.field_78116_c.field_78796_g += (y == 4) ? 0.8F : -0.8F;
/* 494 */       this.RA.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 2.0F * par2 * 0.5F;
/* 495 */       this.LA.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
/*     */     }
/* 497 */     else if (y == 6 || y == 7) {
/*     */       
/* 499 */       this.field_78116_c.field_78796_g += (y == 6) ? 0.7F : -0.7F;
/*     */       
/* 501 */       float animation_helper = -0.7F + (50.0F - animation) * 0.025F;
/* 502 */       float animation_extra = 0.4F - animation_helper;
/*     */       
/* 504 */       this.RA.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 2.0F * par2 * 0.5F;
/* 505 */       this.LA.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F) * 2.0F * par2 * 0.5F - ((y == 6) ? animation_extra : (animation_extra + 0.3F));
/*     */     }
/* 507 */     else if (y == 3) {
/*     */ 
/*     */       
/* 510 */       this.RA.field_78795_f = 0.0F;
/* 511 */       this.LA.field_78795_f = 0.0F;
/* 512 */       this.RA.field_78808_h = 0.2F;
/* 513 */       this.LA.field_78808_h = -0.2F;
/* 514 */     } else if (y == 1) {
/*     */       
/* 516 */       this.field_78116_c.field_78795_f = par5 / 57.295776F;
/* 517 */       if (pwr == 2 && par2 > 0.9F) {
/* 518 */         this.RA.field_78795_f = 0.7F;
/* 519 */         this.LA.field_78795_f = 0.7F;
/*     */       } else {
/*     */         
/* 522 */         this.RA.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 2.0F * par2 * 0.5F;
/* 523 */         this.LA.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
/*     */       } 
/*     */     } else {
/*     */       
/* 527 */       this.field_78116_c.field_78795_f = -1.0471976F;
/* 528 */       this.RA.field_78795_f = 0.0F;
/* 529 */       this.LA.field_78795_f = 0.0F;
/* 530 */       this.RA.field_78808_h = 0.2F;
/* 531 */       this.LA.field_78808_h = -0.2F;
/*     */     } 
/* 533 */     this.RA.field_78808_h = 0.0F;
/* 534 */     this.LA.field_78808_h = 0.0F;
/*     */ 
/*     */ 
/*     */     
/* 538 */     if (y == 4 || y == 5) {
/*     */       
/* 540 */       this.RL.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F) * 1.4F * par2;
/* 541 */       this.LL.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.4F * par2;
/* 542 */       this.RL.field_78808_h = 0.0F;
/* 543 */       this.LL.field_78808_h = 0.0F;
/*     */     }
/* 545 */     else if (y == 6 || y == 7) {
/*     */       
/* 547 */       this.RL.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F) * 1.4F * par2;
/* 548 */       this.LL.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.4F * par2;
/* 549 */       this.RL.field_78808_h = 0.2F;
/* 550 */       this.LL.field_78808_h = -0.2F;
/*     */     }
/* 552 */     else if (y == 3) {
/*     */       
/* 554 */       this.RL.field_78795_f = MathHelper.func_76134_b(0.0F) * 1.4F * par2;
/* 555 */       this.LL.field_78795_f = MathHelper.func_76134_b(3.8077927F) * 1.4F * par2;
/* 556 */       this.RL.field_78808_h = 0.1F;
/* 557 */       this.LL.field_78808_h = -0.2F;
/*     */     }
/* 559 */     else if (y == 1) {
/*     */       
/* 561 */       this.RL.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F) * 1.4F * par2;
/* 562 */       this.LL.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.4F * par2;
/* 563 */       this.RL.field_78808_h = 0.0F;
/* 564 */       this.LL.field_78808_h = 0.0F;
/*     */     }
/*     */     else {
/*     */       
/* 568 */       this.RL.field_78795_f = 0.0F;
/* 569 */       this.LL.field_78795_f = 0.0F;
/* 570 */       this.RL.field_78808_h += MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 571 */       this.LL.field_78808_h -= MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 572 */       this.RL.field_78795_f += MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/* 573 */       this.LL.field_78795_f -= MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/* 574 */       this.RL.field_78808_h = 0.2F;
/* 575 */       this.LL.field_78808_h = -0.2F;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 581 */     this.RL.field_78796_g = 0.0F;
/* 582 */     this.LL.field_78796_g = 0.0F;
/*     */     
/* 584 */     boolean isClientPlayerInFPSView = (par7Entity.func_70005_c_().equals(JRMCoreClient.mc.field_71439_g.func_70005_c_()) && JRMCoreClient.mc.field_71474_y.field_74320_O == 0);
/*     */     
/* 586 */     if (this.field_78093_q) {
/*     */       
/* 588 */       if (!isClientPlayerInFPSView) {
/*     */         
/* 590 */         this.RA.field_78795_f += -0.62831855F;
/* 591 */         this.LA.field_78795_f += -0.62831855F;
/*     */       } 
/* 593 */       this.RL.field_78795_f = -1.2566371F;
/* 594 */       this.LL.field_78795_f = -1.2566371F;
/* 595 */       this.RL.field_78796_g = 0.31415927F;
/* 596 */       this.LL.field_78796_g = -0.31415927F;
/*     */     } 
/*     */     
/* 599 */     if (this.field_78119_l != 0)
/*     */     {
/* 601 */       this.LA.field_78795_f = this.LA.field_78795_f * 0.5F - 0.31415927F * this.field_78119_l;
/*     */     }
/*     */     
/* 604 */     if (this.field_78120_m != 0 && (pwr != 2 || par2 <= 0.9F))
/*     */     {
/* 606 */       this.RA.field_78795_f = this.RA.field_78795_f * 0.5F - 0.31415927F * this.field_78120_m;
/*     */     }
/*     */     
/* 609 */     this.RA.field_78796_g = 0.0F;
/* 610 */     this.LA.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 615 */     if (this.field_78095_p > -9990.0F) {
/*     */       
/* 617 */       float var8 = this.field_78095_p;
/* 618 */       if (pwr != 3 || this.field_78120_m <= 9) {
/*     */         
/* 620 */         this.B.field_78796_g = MathHelper.func_76126_a(MathHelper.func_76129_c(var8) * 3.1415927F * 2.0F) * 0.2F;
/* 621 */         this.B9.field_78796_g = this.B.field_78796_g;
/*     */       } 
/* 623 */       this.RA.field_78798_e = MathHelper.func_76126_a(this.B.field_78796_g) * 5.0F;
/* 624 */       this.RA.field_78800_c = -MathHelper.func_76134_b(this.B.field_78796_g) * 5.0F;
/* 625 */       this.LA.field_78798_e = -MathHelper.func_76126_a(this.B.field_78796_g) * 5.0F;
/* 626 */       this.LA.field_78800_c = MathHelper.func_76134_b(this.B.field_78796_g) * 5.0F;
/* 627 */       this.RA.field_78796_g += this.B.field_78796_g;
/* 628 */       this.LA.field_78796_g += this.B.field_78796_g;
/*     */       
/* 630 */       var8 = 1.0F - this.field_78095_p;
/* 631 */       var8 *= var8;
/* 632 */       var8 *= var8;
/* 633 */       var8 = 1.0F - var8;
/* 634 */       float var9 = MathHelper.func_76126_a(var8 * 3.1415927F);
/* 635 */       float var10 = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -(this.field_78116_c.field_78795_f - 0.7F) * 0.75F;
/*     */ 
/*     */       
/* 638 */       if (pwr == 2 && par2 > 0.9F && var9 != 0.0F) {
/*     */         
/* 640 */         this.RA.field_78795_f = 0.0F;
/* 641 */         this.RA.field_78795_f = (float)(this.RA.field_78795_f - var9 * 1.2D + var10);
/* 642 */         this.RA.field_78796_g += this.B.field_78796_g * 2.0F;
/* 643 */         this.RA.field_78808_h = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -0.4F;
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 648 */         this.RA.field_78795_f = (float)(this.RA.field_78795_f - var9 * 1.2D + var10);
/* 649 */         this.RA.field_78796_g += this.B.field_78796_g * 2.0F;
/*     */ 
/*     */         
/* 652 */         if (y == 3) {
/*     */           
/* 654 */           this.RA.field_78795_f = 0.0F;
/* 655 */           this.LA.field_78795_f = 0.0F;
/* 656 */           this.RA.field_78808_h = 0.5F;
/* 657 */           this.LA.field_78808_h = -0.9F;
/*     */         }
/* 659 */         else if (y == 1) {
/*     */           
/* 661 */           this.RA.field_78808_h = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -0.4F;
/*     */         }
/* 663 */         else if (!isClientPlayerInFPSView) {
/*     */           
/* 665 */           this.RA.field_78808_h = 0.2F;
/* 666 */           this.LA.field_78808_h = -0.2F;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 671 */     if (this.field_78117_n) {
/*     */       
/* 673 */       this.B.field_78795_f = 0.5F;
/* 674 */       this.B9.field_78795_f = this.B.field_78795_f;
/* 675 */       this.RA.field_78795_f += 0.4F;
/* 676 */       this.LA.field_78795_f += 0.4F;
/* 677 */       this.RL.field_78798_e = 4.0F;
/* 678 */       this.LL.field_78798_e = 4.0F;
/* 679 */       this.RL.field_78797_d = 9.0F;
/* 680 */       this.LL.field_78797_d = 9.0F;
/* 681 */       this.field_78116_c.field_78797_d = 1.0F;
/* 682 */       this.field_78114_d.field_78797_d = this.field_78116_c.field_78797_d;
/*     */ 
/*     */     
/*     */     }
/* 686 */     else if (pwr == 2 && par2 > 0.9F) {
/* 687 */       this.B.field_78795_f = 0.5F;
/* 688 */       this.B9.field_78795_f = this.B.field_78795_f;
/* 689 */       this.RA.field_78795_f += 0.4F;
/* 690 */       this.LA.field_78795_f += 0.4F;
/* 691 */       this.RL.field_78798_e = 4.0F;
/* 692 */       this.LL.field_78798_e = 4.0F;
/* 693 */       this.RL.field_78797_d = 9.0F;
/* 694 */       this.LL.field_78797_d = 9.0F;
/* 695 */       this.field_78116_c.field_78797_d = 1.0F;
/* 696 */       this.field_78114_d.field_78797_d = this.field_78116_c.field_78797_d;
/*     */     } else {
/* 698 */       this.B.field_78795_f = 0.0F;
/* 699 */       this.B9.field_78795_f = this.B.field_78795_f;
/* 700 */       this.RL.field_78798_e = 0.1F;
/* 701 */       this.LL.field_78798_e = 0.1F;
/* 702 */       this.RL.field_78797_d = 12.0F;
/* 703 */       this.LL.field_78797_d = 12.0F;
/* 704 */       this.field_78116_c.field_78797_d = 0.0F;
/* 705 */       this.field_78114_d.field_78797_d = this.field_78116_c.field_78797_d;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 712 */     this.field_78117_n = false;
/*     */     
/* 714 */     if (y != 3) {
/*     */       
/* 716 */       this.RA.field_78808_h += MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 717 */       this.LA.field_78808_h -= MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 718 */       this.RA.field_78795_f += MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/* 719 */       this.LA.field_78795_f -= MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/*     */     } 
/*     */     
/* 722 */     if (this.field_78118_o) {
/*     */       
/* 724 */       float var8 = 0.0F;
/* 725 */       float var9 = 0.0F;
/* 726 */       this.RA.field_78808_h = 0.0F;
/* 727 */       this.LA.field_78808_h = 0.0F;
/*     */ 
/*     */       
/* 730 */       this.RA.field_78796_g = -(0.1F - var8 * 0.6F) + this.field_78116_c.field_78796_g;
/* 731 */       this.LA.field_78796_g = 0.1F - var8 * 0.6F + this.field_78116_c.field_78796_g + 0.4F;
/* 732 */       this.RA.field_78795_f = -1.5707964F + this.field_78116_c.field_78795_f;
/* 733 */       this.LA.field_78795_f = -1.5707964F + this.field_78116_c.field_78795_f;
/* 734 */       this.RA.field_78795_f -= var8 * 1.2F - var9 * 0.4F;
/* 735 */       this.LA.field_78795_f -= var8 * 1.2F - var9 * 0.4F;
/*     */       
/* 737 */       this.RA.field_78808_h += MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 738 */       this.LA.field_78808_h -= MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 739 */       this.RA.field_78795_f += MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/* 740 */       this.LA.field_78795_f -= MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/*     */     } 
/*     */     
/* 743 */     this.field_78118_o = false;
/* 744 */     float f6 = 0.0F;
/* 745 */     float f7 = 0.0F;
/*     */     
/* 747 */     if (pwr == 3 && this.field_78120_m > 9) {
/*     */       
/* 749 */       float var8 = this.field_78095_p;
/* 750 */       float var10 = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * 0.7F * 0.75F;
/*     */       
/* 752 */       var8 = MathHelper.func_76126_a(MathHelper.func_76129_c(var8) * 3.1415927F * 2.0F);
/*     */       
/* 754 */       if (this.field_78120_m == 10) {
/* 755 */         this.RA.field_78808_h = 0.0F;
/* 756 */         this.LA.field_78808_h = 0.0F;
/*     */ 
/*     */         
/* 759 */         this.RA.field_78796_g = -0.2F;
/* 760 */         this.LA.field_78796_g = 0.0F;
/* 761 */         this.RA.field_78795_f = -0.5F + ((var10 != 0.0F) ? (-0.5F - var8) : 0.0F);
/*     */         
/* 763 */         this.RA.field_78795_f -= f6 * 1.2F - f7 * 0.4F;
/* 764 */         this.LA.field_78795_f -= f6 * 1.2F - f7 * 0.4F;
/*     */         
/* 766 */         this.RA.field_78808_h -= 0.15F;
/* 767 */         this.LA.field_78808_h -= 0.25F;
/* 768 */       } else if (this.field_78120_m == 11) {
/* 769 */         this.B.field_78796_g = -0.2F;
/* 770 */         this.B9.field_78796_g = this.B.field_78796_g;
/*     */         
/* 772 */         this.RA.field_78808_h = 0.0F;
/* 773 */         this.LA.field_78808_h = -0.3F;
/*     */ 
/*     */         
/* 776 */         this.RA.field_78796_g = 0.2F;
/* 777 */         this.LA.field_78796_g = 0.5F;
/* 778 */         this.RA.field_78795_f = -0.9F + ((var10 != 0.0F) ? var8 : 0.0F);
/* 779 */         this.LA.field_78795_f = -0.5F + ((var10 != 0.0F) ? var8 : 0.0F);
/* 780 */         this.RA.field_78795_f -= f6 * 1.2F - f7 * 0.4F;
/* 781 */         this.LA.field_78795_f -= f6 * 1.2F - f7 * 0.4F;
/*     */         
/* 783 */         this.RA.field_78808_h -= 0.85F;
/* 784 */         this.LA.field_78808_h -= -0.15F;
/*     */       } 
/*     */       
/* 787 */       if (this.field_78095_p > -9990.0F)
/*     */       {
/*     */ 
/*     */         
/* 791 */         this.RA.field_78796_g += this.B.field_78796_g * 2.0F;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 796 */     if (this.field_78120_m == 0)
/*     */     {
/* 798 */       if (this.blk) {
/* 799 */         this.RA.field_78808_h = 0.0F;
/* 800 */         this.LA.field_78808_h = 0.0F;
/* 801 */         this.RA.field_78796_g = -(0.1F - f6 * 0.6F) + ((this.field_78116_c.field_78796_g < -0.2F) ? -0.2F : this.field_78116_c.field_78796_g) - 0.8F;
/* 802 */         this.LA.field_78796_g = 0.1F - f6 * 0.6F + ((this.field_78116_c.field_78796_g > 0.2F) ? 0.2F : this.field_78116_c.field_78796_g) + 0.8F;
/* 803 */         this.RA.field_78795_f = -1.5707964F + ((this.field_78116_c.field_78795_f < -0.5F) ? -0.5F : ((this.field_78116_c.field_78795_f > 0.5F) ? 0.5F : this.field_78116_c.field_78795_f));
/* 804 */         this.LA.field_78795_f = -1.5707964F + ((this.field_78116_c.field_78795_f < -0.5F) ? -0.5F : ((this.field_78116_c.field_78795_f > 0.5F) ? 0.5F : this.field_78116_c.field_78795_f));
/* 805 */         this.RA.field_78795_f -= f6 * 1.2F - f7 * 0.4F;
/* 806 */         this.LA.field_78795_f -= f6 * 1.2F - f7 * 0.4F;
/*     */ 
/*     */         
/* 809 */         this.RA.field_78808_h += MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.45F;
/* 810 */         this.LA.field_78808_h -= MathHelper.func_76134_b(par3 * 0.09F) * 0.05F - 0.55F;
/* 811 */         this.RA.field_78795_f += MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/* 812 */         this.LA.field_78795_f -= MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/*     */       }
/* 814 */       else if (this.instantTransmission) {
/* 815 */         this.RA.field_78808_h = 0.45F;
/* 816 */         this.RA.field_78796_g = -0.2F + ((this.field_78116_c.field_78795_f > 0.0F) ? (-this.field_78116_c.field_78795_f * 0.3F) : 0.0F);
/* 817 */         this.RA.field_78795_f = -2.5F + ((this.field_78116_c.field_78795_f < -0.5F) ? -0.5F : ((this.field_78116_c.field_78795_f > 0.9F) ? 0.9F : this.field_78116_c.field_78795_f));
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
/* 834 */     if ((this.KiAttack == 1 || this.KiAttack == 8 || this.KiAttack == 9) && this.field_78120_m == 0) {
/*     */ 
/*     */       
/* 837 */       f6 = 0.0F;
/* 838 */       f7 = 0.0F;
/*     */       
/* 840 */       this.RA.field_78808_h = 0.0F;
/* 841 */       this.LA.field_78808_h = 0.0F;
/* 842 */       this.RA.field_78796_g = -(0.1F - f6 * 0.6F) + ((this.field_78116_c.field_78796_g < -0.2F) ? -0.2F : this.field_78116_c.field_78796_g) - 0.5F;
/* 843 */       this.LA.field_78796_g = 0.1F - f6 * 0.6F + ((this.field_78116_c.field_78796_g > 0.2F) ? 0.2F : this.field_78116_c.field_78796_g) + 0.5F;
/* 844 */       this.RA.field_78795_f = -1.5707964F + ((this.field_78116_c.field_78795_f < -0.5F) ? -0.5F : ((this.field_78116_c.field_78795_f > 0.5F) ? 0.5F : this.field_78116_c.field_78795_f));
/* 845 */       this.LA.field_78795_f = -1.5707964F + ((this.field_78116_c.field_78795_f < -0.5F) ? -0.5F : ((this.field_78116_c.field_78795_f > 0.5F) ? 0.5F : this.field_78116_c.field_78795_f));
/* 846 */       this.RA.field_78795_f -= f6 * 1.2F - f7 * 0.4F;
/* 847 */       this.LA.field_78795_f -= f6 * 1.2F - f7 * 0.4F;
/*     */       
/* 849 */       this.RA.field_78808_h += MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 850 */       this.LA.field_78808_h -= MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 851 */       this.RA.field_78795_f += MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/* 852 */       this.LA.field_78795_f -= MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/*     */     } 
/*     */     
/* 855 */     if ((this.KiAttack == 2 || this.KiAttack == 5 || this.KiAttack == 4 || this.KiAttack == 7) && this.field_78120_m == 0) {
/*     */       
/* 857 */       f6 = 0.0F;
/* 858 */       f7 = 0.0F;
/*     */       
/* 860 */       this.RA.field_78808_h = 0.0F;
/* 861 */       this.RA.field_78796_g = -(0.1F - f6 * 0.6F) + ((this.field_78116_c.field_78796_g < -0.2F) ? -0.2F : this.field_78116_c.field_78796_g) - 0.1F;
/* 862 */       this.RA.field_78795_f = -1.5707964F + this.field_78116_c.field_78795_f;
/* 863 */       this.RA.field_78795_f -= f6 * 1.2F - f7 * 0.4F;
/*     */ 
/*     */       
/* 866 */       this.RA.field_78808_h += MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 867 */       this.RA.field_78795_f += MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/*     */     } 
/*     */     
/* 870 */     if (this.KiAttack == 3 && this.field_78120_m == 0) {
/*     */       
/* 872 */       f6 = 0.0F;
/* 873 */       f7 = 0.0F;
/*     */ 
/*     */       
/* 876 */       this.RA.field_78808_h = -0.3F;
/* 877 */       this.RA.field_78795_f = -3.0F;
/* 878 */       this.RA.field_78795_f -= f6 * 1.2F - f7 * 0.4F;
/*     */ 
/*     */       
/* 881 */       this.RA.field_78808_h += MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 882 */       this.RA.field_78795_f += MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/*     */     } 
/*     */ 
/*     */     
/* 886 */     if (this.KiAttack == 6 && this.field_78120_m == 0) {
/*     */       
/* 888 */       f6 = 0.0F;
/* 889 */       f7 = 0.0F;
/*     */ 
/*     */       
/* 892 */       this.RA.field_78808_h = -0.3F;
/* 893 */       this.RA.field_78795_f = -3.0F;
/* 894 */       this.RA.field_78795_f -= f6 * 1.2F - f7 * 0.4F;
/* 895 */       this.LA.field_78808_h = 0.3F;
/* 896 */       this.LA.field_78795_f = -3.0F;
/* 897 */       this.LA.field_78795_f -= f6 * 1.2F - f7 * 0.4F;
/*     */ 
/*     */       
/* 900 */       this.RA.field_78808_h += MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 901 */       this.RA.field_78795_f += MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/* 902 */       this.LA.field_78808_h -= MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 903 */       this.LA.field_78795_f -= MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/*     */     }  }
/*     */   
/*     */   public ModelRenderer B4; public ModelRenderer B5; public ModelRenderer B7; public ModelRenderer B9; public int b; public boolean blk; public boolean instantTransmission; public int KiAttack; public static final int y_isFlying = 2; public static final int y_notFlying = 1; public static final int y_isKO = 3; public static final int y_isDodging1 = 4; public static final int y_isDodging2 = 5; public static final int y_isAttacking1 = 6; public static final int y_isAttacking2 = 7;
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/*     */     model.field_78795_f = x;
/*     */     model.field_78796_g = y;
/*     */     model.field_78808_h = z;
/*     */   }
/*     */   public void func_78110_b(float par1) {
/* 913 */     this.field_78121_j.field_78796_g = this.field_78116_c.field_78796_g;
/* 914 */     this.field_78121_j.field_78795_f = this.field_78116_c.field_78795_f;
/* 915 */     this.field_78121_j.field_78800_c = 0.0F;
/* 916 */     this.field_78121_j.field_78797_d = 0.0F;
/* 917 */     this.field_78121_j.func_78785_a(par1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78111_c(float par1) {
/* 925 */     this.field_78122_k.func_78785_a(par1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderHairs(float par1, String hair) {
/* 930 */     float f6 = f;
/* 931 */     GL11.glPushMatrix();
/* 932 */     GL11.glScalef((0.5F + 0.5F / f6) * ((g <= 1) ? 1.0F : 0.85F), 0.5F + 0.5F / f6, (0.5F + 0.5F / f6) * ((g <= 1) ? 1.0F : 0.85F));
/* 933 */     GL11.glTranslatef(0.0F, (f6 - 1.0F) / f6 * (2.0F - ((f6 >= 1.5F && f6 <= 2.0F) ? ((2.0F - f6) / 2.5F) : ((f6 < 1.5F && f6 >= 1.0F) ? ((f6 * 2.0F - 2.0F) * 0.2F) : 0.0F))), 0.0F);
/* 934 */     if (hair.contains("SC")) {
/* 935 */       this.field_78116_c.field_78796_g = this.field_78116_c.field_78796_g;
/* 936 */       this.field_78116_c.field_78795_f = this.field_78116_c.field_78795_f;
/* 937 */       this.field_78116_c.field_78800_c = this.field_78116_c.field_78800_c;
/* 938 */       this.field_78116_c.field_78797_d = this.field_78116_c.field_78797_d;
/* 939 */       this.field_78116_c.func_78785_a(par1);
/*     */     } 
/* 941 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */   
/*     */   public ModelRendererJBRA getRandomModelBox2(Random p_85181_1_) {
/* 946 */     return this.field_78092_r.get(p_85181_1_.nextInt(this.field_78092_r.size()));
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\entity\ModelBipedBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */