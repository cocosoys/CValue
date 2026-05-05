/*     */ package JinRyuu.JBRA;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreH;
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
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class ModelBipedJBRA
/*     */   extends ModelBiped
/*     */ {
/*     */   public ModelRenderer field_78116_c;
/*     */   public ModelRenderer field_78115_e;
/*     */   public ModelRenderer field_78112_f;
/*     */   public ModelRenderer field_78113_g;
/*     */   public ModelRenderer field_78123_h;
/*     */   public ModelRenderer field_78124_i;
/*     */   public ModelRenderer field_78121_j;
/*     */   public ModelRenderer field_78122_k;
/*     */   public ModelRenderer leftarmshoulder;
/*     */   public ModelRenderer rightarmshoulder;
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
/*     */   
/*     */   public ModelBipedJBRA() {
/*  68 */     this(0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public ModelBipedJBRA(float par1) {
/*  73 */     this(par1, 0.0F, 128, 64);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
/*     */     func_78087_a(par2, par3, par4, par5, par6, par7, par1Entity);
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
/*     */         this.leftarmshoulder.func_78785_a(f5);
/*     */         this.rightarmshoulder.func_78785_a(f5);
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
/*     */         this.leftarmshoulder.func_78785_a(f5);
/*     */         this.rightarmshoulder.func_78785_a(f5);
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
/*     */       this.leftarmshoulder.func_78785_a(f5);
/*     */       this.rightarmshoulder.func_78785_a(f5);
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
/*     */       float scale = this.b * 0.03F;
/*     */       float br = 0.4235988F + scale;
/*     */       float bs = 0.8F + scale;
/*     */       float bsY = 0.85F + scale * 0.5F;
/*     */       float bt = 0.1F * scale;
/*     */       boolean bounce = (par1Entity.field_70122_E || par1Entity.func_70090_H());
/*     */       float bspeed = par1Entity.func_70051_ag() ? 1.5F : (par1Entity.func_70093_af() ? 0.5F : 1.0F);
/*     */       float bbY = (bounce ? (MathHelper.func_76126_a(par2 * 0.6662F * bspeed * 1.5F + 3.1415927F) * par3 * 0.03F) : 0.0F) * this.b * 0.1119F;
/*     */       GL11.glTranslatef(0.0F, (f6 - 1.0F) * 1.5F + bbY, 0.015F + bt);
/*     */       GL11.glScalef(1.0F, bsY, bs);
/*     */       setRotation(this.breast, -br, 0.0F, 0.0F);
/*     */       setRotation(this.breast2, br, 3.141593F, 0.0F);
/*     */       if (bounce) {
/*     */         this.breast.field_78795_f += -MathHelper.func_76134_b(par2 * 0.6662F * bspeed + 3.1415927F) * par3 * 0.05F * this.b * 0.1119F;
/*     */         this.breast.field_78796_g += MathHelper.func_76134_b(par2 * 0.6662F * bspeed + 3.1415927F) * par3 * 0.02F * this.b * 0.1119F;
/*     */         this.breast2.field_78795_f += MathHelper.func_76134_b(par2 * 0.6662F * bspeed + 3.1415927F) * par3 * 0.05F * this.b * 0.1119F;
/*     */         this.breast2.field_78796_g += MathHelper.func_76134_b(par2 * 0.6662F * bspeed + 3.1415927F) * par3 * 0.02F * this.b * 0.1119F;
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
/*     */       if (p >= 30);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ModelRenderer RA;
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
/*     */   ModelRenderer LA;
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
/*     */   ModelRenderer RL;
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
/*     */   ModelRenderer LL;
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
/*     */   ModelRenderer B;
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
/*     */   public ModelBipedJBRA(float par1, float par2, int par3, int par4) {
/* 423 */     this.blk = false;
/* 424 */     this.KiAttack = 0; this.field_78119_l = 0; this.field_78120_m = 0; this.field_78117_n = false; this.field_78118_o = false; this.field_78090_t = par3; this.field_78089_u = par4; this.field_78122_k = new ModelRenderer((ModelBase)this, 0, 0); this.field_78122_k.func_78790_a(-5.0F, 0.0F, -1.0F, 10, 16, 1, par1); this.field_78121_j = new ModelRenderer((ModelBase)this, 24, 0); this.field_78121_j.func_78790_a(-3.0F, -6.0F, -1.0F, 6, 6, 1, par1); this.field_78116_c = new ModelRenderer((ModelBase)this, 0, 0); this.field_78116_c.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, par1); this.field_78116_c.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.field_78115_e = new ModelRenderer((ModelBase)this, 16, 16); this.field_78115_e.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, par1); this.field_78115_e.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.field_78112_f = new ModelRenderer((ModelBase)this, 40, 16); this.field_78112_f.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, par1); this.field_78112_f.func_78793_a(-5.0F, 2.0F + par2, 0.0F); this.field_78113_g = new ModelRenderer((ModelBase)this, 40, 16); this.field_78113_g.field_78809_i = true; this.field_78113_g.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, par1); this.field_78113_g.func_78793_a(5.0F, 2.0F + par2, 0.0F); this.field_78123_h = new ModelRenderer((ModelBase)this, 0, 16); this.field_78123_h.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, par1); this.field_78123_h.func_78793_a(-1.9F, 12.0F + par2, 0.0F); this.field_78124_i = new ModelRenderer((ModelBase)this, 0, 16); this.field_78124_i.field_78809_i = true; this.field_78124_i.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, par1); this.field_78124_i.func_78793_a(1.9F, 12.0F + par2, 0.0F); this.rightarmshoulder = new ModelRenderer((ModelBase)this, 40, 32); this.rightarmshoulder.func_78789_a(-6.0F, -4.0F, -3.0F, 7, 4, 6); this.rightarmshoulder.func_78793_a(-5.0F, 3.0F, 0.0F); this.rightarmshoulder.func_78787_b(128, 64); this.leftarmshoulder = new ModelRenderer((ModelBase)this, 40, 32); this.leftarmshoulder.field_78809_i = true; this.leftarmshoulder.func_78789_a(-1.0F, -4.0F, -3.0F, 7, 4, 6); this.leftarmshoulder.func_78793_a(5.0F, 3.0F, 0.0F); this.leftarmshoulder.func_78787_b(128, 64); this.rightarm = new ModelRenderer((ModelBase)this, 40, 16); this.rightarm.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, par1 * 0.5F); this.rightarm.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.rightarm, 0.0F, 0.0F, 0.122173F); this.leftarm = new ModelRenderer((ModelBase)this, 40, 16); this.leftarm.field_78809_i = true; this.leftarm.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, par1 * 0.5F); this.leftarm.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.leftarm, 0.0F, 0.0F, -0.122173F); this.Brightarm = new ModelRenderer((ModelBase)this, 0, 0); this.Brightarm.func_78790_a(-3.0F, -2.0F, -2.0F, 0, 0, 0, par1 * 0.5F); this.Brightarm.func_78793_a(-5.0F, 2.0F, 0.0F); this.Bleftarm = new ModelRenderer((ModelBase)this, 0, 0); this.Bleftarm.field_78809_i = true; this.Bleftarm.func_78790_a(-1.0F, -2.0F, -2.0F, 0, 0, 0, par1 * 0.5F); this.Bleftarm.func_78793_a(5.0F, 2.0F, 0.0F); this.rightleg = new ModelRenderer((ModelBase)this, 0, 16); this.rightleg.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, par1 * 0.5F); this.rightleg.func_78793_a(-2.0F, 12.0F, 0.0F); setRotation(this.rightleg, 0.0F, 0.0F, 0.0F); this.leftleg = new ModelRenderer((ModelBase)this, 0, 16); this.leftleg.field_78809_i = true; this.leftleg.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, par1 * 0.5F); this.leftleg.func_78793_a(2.0F, 12.0F, 0.0F); setRotation(this.leftleg, 0.0F, 0.0F, 0.0F); this.skirt1 = new ModelRenderer((ModelBase)this, 16, 18); this.skirt1.func_78790_a(-4.0F, 9.0F, -2.0F, 8, 2, 4, par1 * 0.5F); this.skirt1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.skirt1, 0.0F, 0.0F, 0.0F); this.skirt2 = new ModelRenderer((ModelBase)this, 16, 20); this.skirt2.func_78790_a(-4.0F, 11.0F, -2.0F, 8, 1, 4, par1 * 0.5F); this.skirt2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.skirt2, 0.0F, 0.0F, 0.0F); this.body = new ModelRenderer((ModelBase)this, 16, 16); this.body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 4, 4, par1 * 0.5F); this.body.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.body, 0.0F, 0.0F, 0.0F); this.hip2 = new ModelRenderer((ModelBase)this, 16, 16); this.hip2.func_78789_a(-4.0F, 7.0F, -2.0F, 8, 2, 4); this.hip2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.hip2, 0.0F, 0.0F, 0.0F); this.hip = new ModelRenderer((ModelBase)this, 16, 23); this.hip.func_78790_a(-4.0F, 7.0F, -2.0F, 8, 2, 4, par1 * 0.5F); this.hip.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.hip, 0.0F, 0.0F, 0.0F); this.waist = new ModelRenderer((ModelBase)this, 16, 20); this.waist.func_78790_a(-4.0F, 4.0F, -2.0F, 8, 3, 4, par1 * 0.5F); this.waist.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.waist, 0.0F, 0.0F, 0.0F); this.Bbreast = new ModelRenderer((ModelBase)this, 0, 0); this.Bbreast.func_78790_a(-4.0F, 2.266667F, -1.0F, 0, 0, 0, par1 * 0.5F); this.Bbreast.func_78793_a(0.0F, 0.0F, 0.0F); this.breast = new ModelRenderer((ModelBase)this, 17, 18); this.breast.func_78790_a(-4.0F, 2.266667F, -1.0F, 8, 3, 3, par1 * 0.5F); this.breast.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.breast, -0.5235988F, 0.0F, 0.0F); this.Bbreast2 = new ModelRenderer((ModelBase)this, 0, 0); this.Bbreast2.func_78790_a(-4.0F, 2.266667F, -1.0F, 0, 0, 0, par1 * 0.5F); this.Bbreast2.func_78793_a(0.0F, 0.0F, 0.0F); this.breast2 = new ModelRenderer((ModelBase)this, 9, 23); this.breast2.field_78809_i = true; this.breast2.func_78790_a(-4.0F, 2.266667F, -2.0F, 8, 3, 3, par1 * 0.5F); this.breast2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.breast2, 0.5235988F, 3.141593F, 0.0F); this.bottom2 = new ModelRenderer((ModelBase)this, 16, 16); this.bottom2.func_78790_a(-4.0F, 9.0F, -2.0F, 8, 3, 4, par1 * 0.5F); this.bottom2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.bottom2, 0.0F, 0.0F, 0.0F); this.bottom = new ModelRenderer((ModelBase)this, 16, 25); this.bottom.func_78790_a(-4.0F, 9.0F, -2.0F, 8, 3, 4, par1 * 0.5F); this.bottom.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.bottom, 0.0F, 0.0F, 0.0F); this.Bbreast.func_78792_a(this.breast);
/*     */     this.Bbreast2.func_78792_a(this.breast2);
/*     */     this.Bleftarm.func_78792_a(this.leftarm);
/* 427 */     this.Brightarm.func_78792_a(this.rightarm); } public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) { EntityPlayer p = null;
/* 428 */     if (par7Entity instanceof EntityPlayer) {
/* 429 */       p = (EntityPlayer)par7Entity;
/*     */     }
/* 431 */     int pwr = 0;
/* 432 */     if (JRMCoreH.plyrs != null && JRMCoreH.plyrs.length > 0 && !p.func_82150_aj() && JRMCoreH.dnn(1))
/* 433 */       for (int pl = 0; pl < JRMCoreH.plyrs.length; pl++) {
/* 434 */         if (JRMCoreH.plyrs[pl].equals(p.func_70005_c_()) && JRMCoreH.data1.length >= JRMCoreH.plyrs.length) {
/* 435 */           String[] s = JRMCoreH.data1[pl].split(";");
/* 436 */           pwr = Integer.parseInt(s[2]);
/*     */           break;
/*     */         } 
/*     */       }  
/* 440 */     if (g >= 2) {
/* 441 */       this.RA = this.Brightarm;
/* 442 */       this.LA = this.Bleftarm;
/* 443 */       this.RL = this.rightleg;
/* 444 */       this.LL = this.leftleg;
/* 445 */       this.B = this.Bbreast;
/* 446 */       this.B1 = this.body;
/* 447 */       this.B2 = this.hip;
/* 448 */       this.B3 = this.waist;
/* 449 */       this.B4 = this.bottom;
/* 450 */       this.B5 = this.Bbreast2;
/* 451 */       this.B7 = this.hip2;
/* 452 */       this.B9 = this.bottom2;
/*     */     }
/*     */     else {
/*     */       
/* 456 */       this.RA = this.field_78112_f;
/* 457 */       this.LA = this.field_78113_g;
/* 458 */       this.RL = this.field_78123_h;
/* 459 */       this.LL = this.field_78124_i;
/* 460 */       this.B = this.B1 = this.B2 = this.B3 = this.B4 = this.B5 = this.B7 = this.B9 = this.field_78115_e;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 465 */     this.field_78116_c.field_78796_g = par4 / 57.295776F;
/* 466 */     this.field_78116_c.field_78795_f = par5 / 57.295776F;
/*     */     
/* 468 */     this.field_78114_d.field_78796_g = this.field_78116_c.field_78796_g;
/* 469 */     this.field_78114_d.field_78795_f = this.field_78116_c.field_78795_f;
/*     */     
/* 471 */     if (y == 1) {
/* 472 */       this.field_78116_c.field_78795_f = par5 / 57.295776F;
/* 473 */       if (pwr == 2 && par2 > 0.9F) {
/* 474 */         this.RA.field_78795_f = 0.7F;
/* 475 */         this.LA.field_78795_f = 0.7F;
/*     */       } else {
/* 477 */         this.RA.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 2.0F * par2 * 0.5F;
/* 478 */         this.LA.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
/*     */       } 
/*     */     } else {
/* 481 */       this.field_78116_c.field_78795_f = par5 / 57.295776F;
/* 482 */       this.RA.field_78795_f = 0.0F;
/* 483 */       this.LA.field_78795_f = 0.0F;
/* 484 */       this.RA.field_78808_h = 0.2F;
/* 485 */       this.LA.field_78808_h = -0.2F;
/*     */     } 
/* 487 */     this.RA.field_78808_h = 0.0F;
/* 488 */     this.LA.field_78808_h = 0.0F;
/*     */     
/* 490 */     if (y == 1) {
/* 491 */       this.RL.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F) * 1.4F * par2;
/* 492 */       this.LL.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.4F * par2;
/* 493 */       this.RL.field_78808_h = 0.0F;
/* 494 */       this.LL.field_78808_h = 0.0F;
/*     */     } else {
/* 496 */       this.RL.field_78795_f = 0.0F;
/* 497 */       this.LL.field_78795_f = 0.0F;
/* 498 */       this.RL.field_78808_h += MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 499 */       this.LL.field_78808_h -= MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 500 */       this.RL.field_78795_f += MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/* 501 */       this.LL.field_78795_f -= MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/* 502 */       this.RL.field_78808_h = 0.2F;
/* 503 */       this.LL.field_78808_h = -0.2F;
/*     */     } 
/* 505 */     this.RL.field_78796_g = 0.0F;
/* 506 */     this.LL.field_78796_g = 0.0F;
/*     */     
/* 508 */     this.rightarmshoulder.field_78795_f = this.RA.field_78795_f;
/* 509 */     this.leftarmshoulder.field_78795_f = this.LA.field_78795_f;
/* 510 */     this.rightarmshoulder.field_78808_h = this.RA.field_78808_h;
/* 511 */     this.leftarmshoulder.field_78808_h = this.LA.field_78808_h;
/*     */     
/* 513 */     if (this.field_78093_q) {
/*     */       
/* 515 */       this.RA.field_78795_f += -0.62831855F;
/* 516 */       this.LA.field_78795_f += -0.62831855F;
/* 517 */       this.RL.field_78795_f = -1.2566371F;
/* 518 */       this.LL.field_78795_f = -1.2566371F;
/* 519 */       this.RL.field_78796_g = 0.31415927F;
/* 520 */       this.LL.field_78796_g = -0.31415927F;
/*     */       
/* 522 */       this.rightarmshoulder.field_78795_f = this.RA.field_78795_f;
/* 523 */       this.leftarmshoulder.field_78795_f = this.LA.field_78795_f;
/*     */     } 
/*     */     
/* 526 */     if (this.field_78119_l != 0)
/*     */     {
/* 528 */       this.LA.field_78795_f = this.LA.field_78795_f * 0.5F - 0.31415927F * this.field_78119_l;
/*     */     }
/*     */     
/* 531 */     if (this.field_78120_m != 0 && (pwr != 2 || par2 <= 0.9F))
/*     */     {
/* 533 */       this.RA.field_78795_f = this.RA.field_78795_f * 0.5F - 0.31415927F * this.field_78120_m;
/*     */     }
/*     */     
/* 536 */     this.RA.field_78796_g = 0.0F;
/* 537 */     this.LA.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */     
/* 541 */     this.rightarmshoulder.field_78796_g = this.RA.field_78796_g;
/* 542 */     this.leftarmshoulder.field_78796_g = this.LA.field_78796_g;
/*     */     
/* 544 */     if (this.field_78095_p > -9990.0F) {
/*     */       
/* 546 */       float var8 = this.field_78095_p;
/* 547 */       this.B.field_78796_g = MathHelper.func_76126_a(MathHelper.func_76129_c(var8) * 3.1415927F * 2.0F) * 0.2F;
/* 548 */       this.B9.field_78796_g = this.B.field_78796_g;
/* 549 */       this.RA.field_78798_e = MathHelper.func_76126_a(this.B.field_78796_g) * 5.0F;
/* 550 */       this.RA.field_78800_c = -MathHelper.func_76134_b(this.B.field_78796_g) * 5.0F;
/* 551 */       this.LA.field_78798_e = -MathHelper.func_76126_a(this.B.field_78796_g) * 5.0F;
/* 552 */       this.LA.field_78800_c = MathHelper.func_76134_b(this.B.field_78796_g) * 5.0F;
/* 553 */       this.RA.field_78796_g += this.B.field_78796_g;
/* 554 */       this.LA.field_78796_g += this.B.field_78796_g;
/*     */ 
/*     */ 
/*     */       
/* 558 */       this.rightarmshoulder.field_78798_e = MathHelper.func_76126_a(this.B.field_78796_g) * 5.0F;
/* 559 */       this.rightarmshoulder.field_78800_c = -MathHelper.func_76134_b(this.B.field_78796_g) * 5.0F;
/* 560 */       this.leftarmshoulder.field_78798_e = -MathHelper.func_76126_a(this.B.field_78796_g) * 5.0F;
/* 561 */       this.leftarmshoulder.field_78800_c = MathHelper.func_76134_b(this.B.field_78796_g) * 5.0F;
/* 562 */       this.rightarmshoulder.field_78796_g += this.B.field_78796_g;
/* 563 */       this.leftarmshoulder.field_78796_g += this.B.field_78796_g;
/* 564 */       this.leftarmshoulder.field_78795_f += this.B.field_78796_g;
/*     */       
/* 566 */       var8 = 1.0F - this.field_78095_p;
/* 567 */       var8 *= var8;
/* 568 */       var8 *= var8;
/* 569 */       var8 = 1.0F - var8;
/* 570 */       float var9 = MathHelper.func_76126_a(var8 * 3.1415927F);
/* 571 */       float var10 = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -(this.field_78116_c.field_78795_f - 0.7F) * 0.75F;
/* 572 */       if (pwr == 2 && par2 > 0.9F && var9 != 0.0F) {
/* 573 */         this.RA.field_78795_f = 0.0F;
/* 574 */         this.RA.field_78795_f = (float)(this.RA.field_78795_f - var9 * 1.2D + var10);
/* 575 */         this.RA.field_78796_g += this.B.field_78796_g * 2.0F;
/* 576 */         this.RA.field_78808_h = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -0.4F;
/*     */       } else {
/* 578 */         this.RA.field_78795_f = (float)(this.RA.field_78795_f - var9 * 1.2D + var10);
/* 579 */         this.RA.field_78796_g += this.B.field_78796_g * 2.0F;
/*     */         
/* 581 */         if (y == 1) {
/* 582 */           this.RA.field_78808_h = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -0.4F;
/*     */         } else {
/* 584 */           this.RA.field_78808_h = 0.2F;
/* 585 */           this.LA.field_78808_h = -0.2F;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 593 */     if (this.field_78117_n) {
/*     */       
/* 595 */       this.B.field_78795_f = 0.5F;
/* 596 */       this.B9.field_78795_f = this.B.field_78795_f;
/* 597 */       this.RA.field_78795_f += 0.4F;
/* 598 */       this.LA.field_78795_f += 0.4F;
/* 599 */       this.RL.field_78798_e = 4.0F;
/* 600 */       this.LL.field_78798_e = 4.0F;
/* 601 */       this.RL.field_78797_d = 9.0F;
/* 602 */       this.LL.field_78797_d = 9.0F;
/* 603 */       this.field_78116_c.field_78797_d = 1.0F;
/* 604 */       this.field_78114_d.field_78797_d = this.field_78116_c.field_78797_d;
/*     */ 
/*     */       
/* 607 */       this.rightarmshoulder.field_78795_f = this.RA.field_78795_f;
/* 608 */       this.leftarmshoulder.field_78795_f = this.LA.field_78795_f;
/*     */ 
/*     */     
/*     */     }
/* 612 */     else if (pwr == 2 && par2 > 0.9F) {
/* 613 */       this.B.field_78795_f = 0.5F;
/* 614 */       this.B9.field_78795_f = this.B.field_78795_f;
/* 615 */       this.RA.field_78795_f += 0.4F;
/* 616 */       this.LA.field_78795_f += 0.4F;
/* 617 */       this.RL.field_78798_e = 4.0F;
/* 618 */       this.LL.field_78798_e = 4.0F;
/* 619 */       this.RL.field_78797_d = 9.0F;
/* 620 */       this.LL.field_78797_d = 9.0F;
/* 621 */       this.field_78116_c.field_78797_d = 1.0F;
/* 622 */       this.field_78114_d.field_78797_d = this.field_78116_c.field_78797_d;
/*     */     } else {
/* 624 */       this.B.field_78795_f = 0.0F;
/* 625 */       this.B9.field_78795_f = this.B.field_78795_f;
/* 626 */       this.RL.field_78798_e = 0.1F;
/* 627 */       this.LL.field_78798_e = 0.1F;
/* 628 */       this.RL.field_78797_d = 12.0F;
/* 629 */       this.LL.field_78797_d = 12.0F;
/* 630 */       this.field_78116_c.field_78797_d = 0.0F;
/* 631 */       this.field_78114_d.field_78797_d = this.field_78116_c.field_78797_d;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 637 */     this.field_78117_n = false;
/*     */     
/* 639 */     this.RA.field_78808_h += MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 640 */     this.LA.field_78808_h -= MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 641 */     this.RA.field_78795_f += MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/* 642 */     this.LA.field_78795_f -= MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/*     */     
/* 644 */     this.rightarmshoulder.field_78808_h = this.RA.field_78808_h;
/* 645 */     this.leftarmshoulder.field_78808_h = this.LA.field_78808_h;
/* 646 */     this.rightarmshoulder.field_78795_f = this.RA.field_78795_f;
/* 647 */     this.leftarmshoulder.field_78795_f = this.LA.field_78795_f;
/*     */     
/* 649 */     if (this.field_78118_o) {
/*     */       
/* 651 */       float var8 = 0.0F;
/* 652 */       float var9 = 0.0F;
/* 653 */       this.RA.field_78808_h = 0.0F;
/* 654 */       this.LA.field_78808_h = 0.0F;
/*     */       
/* 656 */       this.rightarmshoulder.field_78808_h = this.RA.field_78808_h;
/* 657 */       this.leftarmshoulder.field_78808_h = this.LA.field_78808_h;
/*     */       
/* 659 */       this.RA.field_78796_g = -(0.1F - var8 * 0.6F) + this.field_78116_c.field_78796_g;
/* 660 */       this.LA.field_78796_g = 0.1F - var8 * 0.6F + this.field_78116_c.field_78796_g + 0.4F;
/* 661 */       this.RA.field_78795_f = -1.5707964F + this.field_78116_c.field_78795_f;
/* 662 */       this.LA.field_78795_f = -1.5707964F + this.field_78116_c.field_78795_f;
/* 663 */       this.RA.field_78795_f -= var8 * 1.2F - var9 * 0.4F;
/* 664 */       this.LA.field_78795_f -= var8 * 1.2F - var9 * 0.4F;
/*     */       
/* 666 */       this.rightarmshoulder.field_78795_f = this.RA.field_78795_f;
/* 667 */       this.leftarmshoulder.field_78795_f = this.LA.field_78795_f;
/*     */       
/* 669 */       this.RA.field_78808_h += MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 670 */       this.LA.field_78808_h -= MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 671 */       this.RA.field_78795_f += MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/* 672 */       this.LA.field_78795_f -= MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/*     */       
/* 674 */       this.rightarmshoulder.field_78796_g = this.RA.field_78796_g;
/* 675 */       this.leftarmshoulder.field_78796_g = this.LA.field_78796_g;
/* 676 */       this.rightarmshoulder.field_78808_h = this.RA.field_78808_h;
/* 677 */       this.leftarmshoulder.field_78808_h = this.LA.field_78808_h;
/* 678 */       this.rightarmshoulder.field_78795_f = this.RA.field_78795_f;
/* 679 */       this.leftarmshoulder.field_78795_f = this.LA.field_78795_f;
/*     */     } 
/* 681 */     this.field_78118_o = false;
/* 682 */     float f6 = 0.0F;
/* 683 */     float f7 = 0.0F;
/* 684 */     if (this.blk && this.field_78120_m == 0) {
/*     */ 
/*     */ 
/*     */       
/* 688 */       this.rightarmshoulder.field_78808_h = this.RA.field_78808_h;
/* 689 */       this.leftarmshoulder.field_78808_h = this.LA.field_78808_h;
/*     */       
/* 691 */       this.RA.field_78808_h = 0.0F;
/* 692 */       this.LA.field_78808_h = 0.0F;
/* 693 */       this.RA.field_78796_g = -(0.1F - f6 * 0.6F) + ((this.field_78116_c.field_78796_g < -0.2F) ? -0.2F : this.field_78116_c.field_78796_g) - 0.8F;
/* 694 */       this.LA.field_78796_g = 0.1F - f6 * 0.6F + ((this.field_78116_c.field_78796_g > 0.2F) ? 0.2F : this.field_78116_c.field_78796_g) + 0.8F;
/* 695 */       this.RA.field_78795_f = -1.5707964F + ((this.field_78116_c.field_78795_f < -0.5F) ? -0.5F : ((this.field_78116_c.field_78795_f > 0.5F) ? 0.5F : this.field_78116_c.field_78795_f));
/* 696 */       this.LA.field_78795_f = -1.5707964F + ((this.field_78116_c.field_78795_f < -0.5F) ? -0.5F : ((this.field_78116_c.field_78795_f > 0.5F) ? 0.5F : this.field_78116_c.field_78795_f));
/* 697 */       this.RA.field_78795_f -= f6 * 1.2F - f7 * 0.4F;
/* 698 */       this.LA.field_78795_f -= f6 * 1.2F - f7 * 0.4F;
/*     */       
/* 700 */       this.rightarmshoulder.field_78795_f = this.RA.field_78795_f;
/* 701 */       this.leftarmshoulder.field_78795_f = this.LA.field_78795_f;
/*     */       
/* 703 */       this.RA.field_78808_h += MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.45F;
/* 704 */       this.LA.field_78808_h -= MathHelper.func_76134_b(par3 * 0.09F) * 0.05F - 0.55F;
/* 705 */       this.RA.field_78795_f += MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/* 706 */       this.LA.field_78795_f -= MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/*     */       
/* 708 */       this.rightarmshoulder.field_78796_g = this.RA.field_78796_g;
/* 709 */       this.leftarmshoulder.field_78796_g = this.LA.field_78796_g;
/* 710 */       this.rightarmshoulder.field_78808_h = this.RA.field_78808_h;
/* 711 */       this.leftarmshoulder.field_78808_h = this.LA.field_78808_h;
/* 712 */       this.rightarmshoulder.field_78795_f = this.RA.field_78795_f;
/* 713 */       this.leftarmshoulder.field_78795_f = this.LA.field_78795_f;
/*     */     } 
/*     */ 
/*     */     
/* 717 */     if ((this.KiAttack == 1 || this.KiAttack == 6 || this.KiAttack == 7 || this.KiAttack == 8) && this.field_78120_m == 0) {
/*     */ 
/*     */       
/* 720 */       f6 = 0.0F;
/* 721 */       f7 = 0.0F;
/*     */       
/* 723 */       this.rightarmshoulder.field_78808_h = this.RA.field_78808_h;
/* 724 */       this.leftarmshoulder.field_78808_h = this.LA.field_78808_h;
/*     */       
/* 726 */       this.RA.field_78808_h = 0.0F;
/* 727 */       this.LA.field_78808_h = 0.0F;
/* 728 */       this.RA.field_78796_g = -(0.1F - f6 * 0.6F) + ((this.field_78116_c.field_78796_g < -0.2F) ? -0.2F : this.field_78116_c.field_78796_g) - 0.5F;
/* 729 */       this.LA.field_78796_g = 0.1F - f6 * 0.6F + ((this.field_78116_c.field_78796_g > 0.2F) ? 0.2F : this.field_78116_c.field_78796_g) + 0.5F;
/* 730 */       this.RA.field_78795_f = -1.5707964F + ((this.field_78116_c.field_78795_f < -0.5F) ? -0.5F : ((this.field_78116_c.field_78795_f > 0.5F) ? 0.5F : this.field_78116_c.field_78795_f));
/* 731 */       this.LA.field_78795_f = -1.5707964F + ((this.field_78116_c.field_78795_f < -0.5F) ? -0.5F : ((this.field_78116_c.field_78795_f > 0.5F) ? 0.5F : this.field_78116_c.field_78795_f));
/* 732 */       this.RA.field_78795_f -= f6 * 1.2F - f7 * 0.4F;
/* 733 */       this.LA.field_78795_f -= f6 * 1.2F - f7 * 0.4F;
/*     */       
/* 735 */       this.rightarmshoulder.field_78795_f = this.RA.field_78795_f;
/* 736 */       this.leftarmshoulder.field_78795_f = this.LA.field_78795_f;
/*     */       
/* 738 */       this.RA.field_78808_h += MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 739 */       this.LA.field_78808_h -= MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 740 */       this.RA.field_78795_f += MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/* 741 */       this.LA.field_78795_f -= MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/*     */       
/* 743 */       this.rightarmshoulder.field_78796_g = this.RA.field_78796_g;
/* 744 */       this.leftarmshoulder.field_78796_g = this.LA.field_78796_g;
/* 745 */       this.rightarmshoulder.field_78808_h = this.RA.field_78808_h;
/* 746 */       this.leftarmshoulder.field_78808_h = this.LA.field_78808_h;
/* 747 */       this.rightarmshoulder.field_78795_f = this.RA.field_78795_f;
/* 748 */       this.leftarmshoulder.field_78795_f = this.LA.field_78795_f;
/*     */     } 
/* 750 */     if ((this.KiAttack == 2 || this.KiAttack == 4 || this.KiAttack == 3) && this.field_78120_m == 0) {
/*     */ 
/*     */       
/* 753 */       f6 = 0.0F;
/* 754 */       f7 = 0.0F;
/*     */       
/* 756 */       this.rightarmshoulder.field_78808_h = this.RA.field_78808_h;
/*     */       
/* 758 */       this.RA.field_78808_h = 0.0F;
/* 759 */       this.RA.field_78796_g = -(0.1F - f6 * 0.6F) + ((this.field_78116_c.field_78796_g < -0.2F) ? -0.2F : this.field_78116_c.field_78796_g) - 0.1F;
/* 760 */       this.RA.field_78795_f = -1.5707964F + this.field_78116_c.field_78795_f;
/* 761 */       this.RA.field_78795_f -= f6 * 1.2F - f7 * 0.4F;
/*     */       
/* 763 */       this.rightarmshoulder.field_78795_f = this.RA.field_78795_f;
/*     */       
/* 765 */       this.RA.field_78808_h += MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 766 */       this.RA.field_78795_f += MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/*     */       
/* 768 */       this.rightarmshoulder.field_78796_g = this.RA.field_78796_g;
/* 769 */       this.rightarmshoulder.field_78808_h = this.RA.field_78808_h;
/* 770 */       this.rightarmshoulder.field_78795_f = this.RA.field_78795_f;
/*     */     } 
/*     */     
/* 773 */     if ((this.KiAttack == 3 || this.KiAttack == 3) && this.field_78120_m == 0) {
/*     */ 
/*     */       
/* 776 */       f6 = 0.0F;
/* 777 */       f7 = 0.0F;
/*     */       
/* 779 */       this.rightarmshoulder.field_78808_h = this.RA.field_78808_h;
/*     */       
/* 781 */       this.RA.field_78808_h = -0.3F;
/* 782 */       this.RA.field_78795_f = -3.0F;
/* 783 */       this.RA.field_78795_f -= f6 * 1.2F - f7 * 0.4F;
/*     */       
/* 785 */       this.rightarmshoulder.field_78795_f = this.RA.field_78795_f;
/*     */       
/* 787 */       this.RA.field_78808_h += MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 788 */       this.RA.field_78795_f += MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/*     */       
/* 790 */       this.rightarmshoulder.field_78796_g = this.RA.field_78796_g;
/* 791 */       this.rightarmshoulder.field_78808_h = this.RA.field_78808_h;
/* 792 */       this.rightarmshoulder.field_78795_f = this.RA.field_78795_f;
/*     */     }  }
/*     */    ModelRenderer B1; ModelRenderer B2; ModelRenderer B3; ModelRenderer B4; ModelRenderer B5; ModelRenderer B7; ModelRenderer B9; public int b; public boolean blk; public int KiAttack;
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/*     */     model.field_78795_f = x;
/*     */     model.field_78796_g = y;
/*     */     model.field_78808_h = z;
/*     */   }
/*     */   public void func_78110_b(float par1) {
/* 801 */     this.field_78121_j.field_78796_g = this.field_78116_c.field_78796_g;
/* 802 */     this.field_78121_j.field_78795_f = this.field_78116_c.field_78795_f;
/* 803 */     this.field_78121_j.field_78800_c = 0.0F;
/* 804 */     this.field_78121_j.field_78797_d = 0.0F;
/* 805 */     this.field_78121_j.func_78785_a(par1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78111_c(float par1) {
/* 813 */     this.field_78122_k.func_78785_a(par1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderHairs(float par1, String hair) {
/* 818 */     float f6 = f;
/* 819 */     GL11.glPushMatrix();
/* 820 */     GL11.glScalef((0.5F + 0.5F / f6) * ((g <= 1) ? 1.0F : 0.85F), 0.5F + 0.5F / f6, (0.5F + 0.5F / f6) * ((g <= 1) ? 1.0F : 0.85F));
/* 821 */     GL11.glTranslatef(0.0F, (f6 - 1.0F) / f6 * (2.0F - ((f6 >= 1.5F && f6 <= 2.0F) ? ((2.0F - f6) / 2.5F) : ((f6 < 1.5F && f6 >= 1.0F) ? ((f6 * 2.0F - 2.0F) * 0.2F) : 0.0F))), 0.0F);
/* 822 */     if (hair.contains("SC")) {
/* 823 */       this.field_78116_c.field_78796_g = this.field_78116_c.field_78796_g;
/* 824 */       this.field_78116_c.field_78795_f = this.field_78116_c.field_78795_f;
/* 825 */       this.field_78116_c.field_78800_c = this.field_78116_c.field_78800_c;
/* 826 */       this.field_78116_c.field_78797_d = this.field_78116_c.field_78797_d;
/* 827 */       this.field_78116_c.func_78785_a(par1);
/*     */     } 
/* 829 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */   
/*     */   public ModelRendererJBRA getRandomModelBox2(Random p_85181_1_) {
/* 834 */     return this.field_78092_r.get(p_85181_1_.nextInt(this.field_78092_r.size()));
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JBRA-Client-v1.6.52.jar!\JinRyuu\JBRA\ModelBipedJBRA.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */