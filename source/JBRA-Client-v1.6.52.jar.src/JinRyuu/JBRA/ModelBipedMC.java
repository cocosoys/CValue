/*     */ package JinRyuu.JBRA;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelBiped;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
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
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class ModelBipedMC
/*     */   extends ModelBiped
/*     */ {
/*     */   public ModelRenderer field_78116_c;
/*     */   public ModelRenderer field_78114_d;
/*     */   public ModelRenderer field_78115_e;
/*     */   public ModelRenderer field_78112_f;
/*     */   public ModelRenderer field_78113_g;
/*     */   public ModelRenderer field_78123_h;
/*     */   public ModelRenderer field_78124_i;
/*     */   public ModelRenderer field_78121_j;
/*     */   public ModelRenderer field_78122_k;
/*     */   ModelRenderer body;
/*     */   ModelRenderer rightarm;
/*     */   ModelRenderer leftarm;
/*     */   ModelRenderer Brightarm;
/*     */   ModelRenderer Bleftarm;
/*     */   ModelRenderer rightleg;
/*     */   ModelRenderer leftleg;
/*     */   ModelRenderer skirt1;
/*     */   ModelRenderer skirt2;
/*     */   ModelRenderer hip;
/*     */   ModelRenderer waist;
/*     */   ModelRenderer Bbreast;
/*     */   ModelRenderer breast;
/*     */   ModelRenderer bottom;
/*     */   ModelRenderer hip2;
/*     */   ModelRenderer breast2;
/*     */   ModelRenderer bottom2;
/*     */   ModelRenderer Bbreast2;
/*     */   public int field_78119_l;
/*     */   public int field_78120_m;
/*     */   public boolean field_78117_n;
/*     */   public boolean field_78118_o;
/*     */   
/*     */   public ModelBipedMC() {
/*  65 */     this(0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public ModelBipedMC(float par1) {
/*  70 */     this(par1, 0.0F, 64, 32);
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
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/*     */     model.field_78795_f = x;
/*     */     model.field_78796_g = y;
/*     */     model.field_78808_h = z;
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
/*     */   public void func_78088_a(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
/*     */     func_78087_a(par2, par3, par4, par5, par6, par7, par1Entity);
/*     */     if (g <= 1) {
/*     */       if (this.field_78091_s) {
/*     */         float f6 = 2.0F;
/*     */         GL11.glPushMatrix();
/*     */         GL11.glScalef(1.5F / f6, 1.5F / f6, 1.5F / f6);
/*     */         GL11.glTranslatef(0.0F, 16.0F * par7, 0.0F);
/*     */         this.field_78116_c.func_78785_a(par7);
/*     */         GL11.glPopMatrix();
/*     */         GL11.glPushMatrix();
/*     */         GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
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
/*     */       float f5 = par7;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ModelBipedMC(float par1, float par2, int par3, int par4) {
/* 410 */     this.b = 0; this.field_78119_l = 0; this.field_78120_m = 0; this.field_78117_n = false; this.field_78118_o = false; this.field_78090_t = par3; this.field_78089_u = par4; this.field_78122_k = new ModelRenderer((ModelBase)this, 0, 0); this.field_78122_k.func_78790_a(-5.0F, 0.0F, -1.0F, 10, 16, 1, par1); this.field_78121_j = new ModelRenderer((ModelBase)this, 24, 0); this.field_78121_j.func_78790_a(-3.0F, -6.0F, -1.0F, 6, 6, 1, par1); this.field_78116_c = new ModelRenderer((ModelBase)this, 0, 0); this.field_78116_c.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, par1); this.field_78116_c.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.field_78114_d = new ModelRenderer((ModelBase)this, 32, 0); this.field_78114_d.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, par1 + 0.5F); this.field_78114_d.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.field_78115_e = new ModelRenderer((ModelBase)this, 16, 16); this.field_78115_e.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, par1); this.field_78115_e.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.field_78112_f = new ModelRenderer((ModelBase)this, 40, 16); this.field_78112_f.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, par1); this.field_78112_f.func_78793_a(-5.0F, 2.0F + par2, 0.0F); this.field_78113_g = new ModelRenderer((ModelBase)this, 40, 16); this.field_78113_g.field_78809_i = true; this.field_78113_g.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, par1); this.field_78113_g.func_78793_a(5.0F, 2.0F + par2, 0.0F); this.field_78123_h = new ModelRenderer((ModelBase)this, 0, 16); this.field_78123_h.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, par1); this.field_78123_h.func_78793_a(-1.9F, 12.0F + par2, 0.0F); this.field_78124_i = new ModelRenderer((ModelBase)this, 0, 16); this.field_78124_i.field_78809_i = true; this.field_78124_i.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, par1); this.field_78124_i.func_78793_a(1.9F, 12.0F + par2, 0.0F); this.rightarm = new ModelRenderer((ModelBase)this, 40, 16); this.rightarm.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, par1 * 0.1F); this.rightarm.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.rightarm, 0.0F, 0.0F, 0.122173F); this.leftarm = new ModelRenderer((ModelBase)this, 40, 16); this.leftarm.field_78809_i = true; this.leftarm.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, par1 * 0.1F); this.leftarm.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.leftarm, 0.0F, 0.0F, -0.122173F); this.Brightarm = new ModelRenderer((ModelBase)this, 0, 0); this.Brightarm.func_78790_a(-3.0F, -2.0F, -2.0F, 0, 0, 0, par1 * 0.1F); this.Brightarm.func_78793_a(-5.0F, 2.0F, 0.0F); this.Bleftarm = new ModelRenderer((ModelBase)this, 0, 0); this.Bleftarm.field_78809_i = true; this.Bleftarm.func_78790_a(-1.0F, -2.0F, -2.0F, 0, 0, 0, par1 * 0.1F); this.Bleftarm.func_78793_a(5.0F, 2.0F, 0.0F); this.rightleg = new ModelRenderer((ModelBase)this, 0, 16); this.rightleg.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, par1 * 0.1F); this.rightleg.func_78793_a(-2.0F, 12.0F, 0.0F); setRotation(this.rightleg, 0.0F, 0.0F, 0.0F); this.leftleg = new ModelRenderer((ModelBase)this, 0, 16); this.leftleg.field_78809_i = true; this.leftleg.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, par1 * 0.1F); this.leftleg.func_78793_a(2.0F, 12.0F, 0.0F); setRotation(this.leftleg, 0.0F, 0.0F, 0.0F); this.skirt1 = new ModelRenderer((ModelBase)this, 16, 18); this.skirt1.func_78790_a(-4.0F, 9.0F, -2.0F, 8, 2, 4, par1 * 0.1F); this.skirt1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.skirt1, 0.0F, 0.0F, 0.0F); this.skirt2 = new ModelRenderer((ModelBase)this, 16, 20); this.skirt2.func_78790_a(-4.0F, 11.0F, -2.0F, 8, 1, 4, par1 * 0.1F); this.skirt2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.skirt2, 0.0F, 0.0F, 0.0F); this.body = new ModelRenderer((ModelBase)this, 16, 16); this.body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 4, 4, par1 * 0.1F); this.body.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.body, 0.0F, 0.0F, 0.0F); this.hip2 = new ModelRenderer((ModelBase)this, 16, 16); this.hip2.func_78789_a(-4.0F, 7.0F, -2.0F, 8, 2, 4); this.hip2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.hip2, 0.0F, 0.0F, 0.0F); this.hip = new ModelRenderer((ModelBase)this, 16, 23); this.hip.func_78790_a(-4.0F, 7.0F, -2.0F, 8, 2, 4, par1 * 0.1F); this.hip.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.hip, 0.0F, 0.0F, 0.0F); this.waist = new ModelRenderer((ModelBase)this, 16, 20); this.waist.func_78790_a(-4.0F, 4.0F, -2.0F, 8, 3, 4, par1 * 0.1F); this.waist.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.waist, 0.0F, 0.0F, 0.0F); this.Bbreast = new ModelRenderer((ModelBase)this, 0, 0); this.Bbreast.func_78789_a(-4.0F, 2.266667F, -1.0F, 0, 0, 0); this.Bbreast.func_78793_a(0.0F, 0.0F, 0.0F); this.breast = new ModelRenderer((ModelBase)this, 17, 18); this.breast.func_78789_a(-4.0F, 2.266667F, -1.0F, 8, 3, 3); this.breast.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.breast, -0.5235988F, 0.0F, 0.0F); this.Bbreast2 = new ModelRenderer((ModelBase)this, 0, 0); this.Bbreast2.func_78789_a(-4.0F, 2.266667F, -1.0F, 0, 0, 0); this.Bbreast2.func_78793_a(0.0F, 0.0F, 0.0F); this.breast2 = new ModelRenderer((ModelBase)this, 9, 23); this.breast2.field_78809_i = true; this.breast2.func_78789_a(-4.0F, 2.266667F, -2.0F, 8, 3, 3); this.breast2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.breast2, 0.5235988F, 3.141593F, 0.0F); this.bottom2 = new ModelRenderer((ModelBase)this, 16, 16); this.bottom2.func_78789_a(-4.0F, 9.0F, -2.0F, 8, 3, 4); this.bottom2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.bottom2, 0.0F, 0.0F, 0.0F); this.bottom = new ModelRenderer((ModelBase)this, 16, 25); this.bottom.func_78790_a(-4.0F, 9.0F, -2.0F, 8, 3, 4, par1 * 0.1F); this.bottom.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.bottom, 0.0F, 0.0F, 0.0F); this.Bbreast.func_78792_a(this.breast);
/*     */     this.Bbreast2.func_78792_a(this.breast2);
/*     */     this.Bleftarm.func_78792_a(this.leftarm);
/* 413 */     this.Brightarm.func_78792_a(this.rightarm); } public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) { if (g >= 2) {
/* 414 */       this.RA = this.Brightarm;
/* 415 */       this.LA = this.Bleftarm;
/* 416 */       this.RL = this.rightleg;
/* 417 */       this.LL = this.leftleg;
/* 418 */       this.B = this.Bbreast;
/* 419 */       this.B1 = this.body;
/* 420 */       this.B2 = this.hip;
/* 421 */       this.B3 = this.waist;
/* 422 */       this.B4 = this.bottom;
/* 423 */       this.B5 = this.Bbreast2;
/* 424 */       this.B7 = this.hip2;
/* 425 */       this.B9 = this.bottom2;
/*     */     }
/*     */     else {
/*     */       
/* 429 */       this.RA = this.field_78112_f;
/* 430 */       this.LA = this.field_78113_g;
/* 431 */       this.RL = this.field_78123_h;
/* 432 */       this.LL = this.field_78124_i;
/* 433 */       this.B = this.B1 = this.B2 = this.B3 = this.B4 = this.B5 = this.B7 = this.B9 = this.field_78115_e;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 439 */     this.field_78116_c.field_78796_g = par4 / 57.295776F;
/* 440 */     this.field_78116_c.field_78795_f = par5 / 57.295776F;
/* 441 */     this.field_78114_d.field_78796_g = this.field_78116_c.field_78796_g;
/* 442 */     this.field_78114_d.field_78795_f = this.field_78116_c.field_78795_f;
/* 443 */     if (y == 1) {
/* 444 */       this.RA.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 2.0F * par2 * 0.5F;
/* 445 */       this.LA.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
/*     */     } else {
/* 447 */       this.RA.field_78795_f = 0.0F;
/* 448 */       this.LA.field_78795_f = 0.0F;
/*     */     } 
/* 450 */     this.RA.field_78808_h = 0.0F;
/* 451 */     this.LA.field_78808_h = 0.0F;
/* 452 */     if (y == 1) {
/* 453 */       this.RL.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F) * 1.4F * par2;
/* 454 */       this.LL.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.4F * par2;
/*     */     } else {
/* 456 */       this.RL.field_78795_f = 0.0F;
/* 457 */       this.LL.field_78795_f = 0.0F;
/*     */     } 
/* 459 */     this.RL.field_78796_g = 0.0F;
/* 460 */     this.LL.field_78796_g = 0.0F;
/*     */     
/* 462 */     if (this.field_78093_q) {
/*     */       
/* 464 */       this.RA.field_78795_f += -0.62831855F;
/* 465 */       this.LA.field_78795_f += -0.62831855F;
/* 466 */       this.RL.field_78795_f = -1.2566371F;
/* 467 */       this.LL.field_78795_f = -1.2566371F;
/* 468 */       this.RL.field_78796_g = 0.31415927F;
/* 469 */       this.LL.field_78796_g = -0.31415927F;
/*     */     } 
/*     */     
/* 472 */     if (this.field_78119_l != 0)
/*     */     {
/* 474 */       this.LA.field_78795_f = this.LA.field_78795_f * 0.5F - 0.31415927F * this.field_78119_l;
/*     */     }
/*     */     
/* 477 */     if (this.field_78120_m != 0)
/*     */     {
/* 479 */       this.RA.field_78795_f = this.RA.field_78795_f * 0.5F - 0.31415927F * this.field_78120_m;
/*     */     }
/*     */     
/* 482 */     this.RA.field_78796_g = 0.0F;
/* 483 */     this.LA.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */     
/* 487 */     if (this.field_78095_p > -9990.0F) {
/*     */       
/* 489 */       float f6 = this.field_78095_p;
/* 490 */       this.B.field_78796_g = MathHelper.func_76126_a(MathHelper.func_76129_c(f6) * 3.1415927F * 2.0F) * 0.2F;
/* 491 */       this.B9.field_78796_g = this.B.field_78796_g;
/* 492 */       this.RA.field_78798_e = MathHelper.func_76126_a(this.B.field_78796_g) * 5.0F;
/* 493 */       this.RA.field_78800_c = -MathHelper.func_76134_b(this.B.field_78796_g) * 5.0F;
/* 494 */       this.LA.field_78798_e = -MathHelper.func_76126_a(this.B.field_78796_g) * 5.0F;
/* 495 */       this.LA.field_78800_c = MathHelper.func_76134_b(this.B.field_78796_g) * 5.0F;
/* 496 */       this.RA.field_78796_g += this.B.field_78796_g;
/* 497 */       this.LA.field_78796_g += this.B.field_78796_g;
/* 498 */       this.LA.field_78795_f += this.B.field_78796_g;
/* 499 */       f6 = 1.0F - this.field_78095_p;
/* 500 */       f6 *= f6;
/* 501 */       f6 *= f6;
/* 502 */       f6 = 1.0F - f6;
/* 503 */       float f7 = MathHelper.func_76126_a(f6 * 3.1415927F);
/* 504 */       float f8 = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -(this.field_78116_c.field_78795_f - 0.7F) * 0.75F;
/* 505 */       this.RA.field_78795_f = (float)(this.RA.field_78795_f - f7 * 1.2D + f8);
/* 506 */       this.RA.field_78796_g += this.B.field_78796_g * 2.0F;
/* 507 */       this.RA.field_78808_h = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -0.4F;
/*     */     } 
/*     */     
/* 510 */     if (this.field_78117_n) {
/*     */       
/* 512 */       this.B.field_78795_f = 0.5F;
/* 513 */       this.B9.field_78795_f = this.B.field_78795_f;
/* 514 */       this.RA.field_78795_f += 0.4F;
/* 515 */       this.LA.field_78795_f += 0.4F;
/* 516 */       this.RL.field_78798_e = 4.0F;
/* 517 */       this.LL.field_78798_e = 4.0F;
/* 518 */       this.RL.field_78797_d = 9.0F;
/* 519 */       this.LL.field_78797_d = 9.0F;
/* 520 */       this.field_78116_c.field_78797_d = 1.0F;
/* 521 */       this.field_78114_d.field_78797_d = 1.0F;
/*     */     }
/*     */     else {
/*     */       
/* 525 */       this.B.field_78795_f = 0.0F;
/* 526 */       this.B9.field_78795_f = this.B.field_78795_f;
/* 527 */       this.RL.field_78798_e = 0.1F;
/* 528 */       this.LL.field_78798_e = 0.1F;
/* 529 */       this.RL.field_78797_d = 12.0F;
/* 530 */       this.LL.field_78797_d = 12.0F;
/* 531 */       this.field_78116_c.field_78797_d = 0.0F;
/* 532 */       this.field_78114_d.field_78797_d = 0.0F;
/*     */     } 
/*     */     
/* 535 */     this.RA.field_78808_h += MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 536 */     this.LA.field_78808_h -= MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 537 */     this.RA.field_78795_f += MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/* 538 */     this.LA.field_78795_f -= MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/*     */     
/* 540 */     if (this.field_78118_o) {
/*     */       
/* 542 */       float f6 = 0.0F;
/* 543 */       float f7 = 0.0F;
/* 544 */       this.RA.field_78808_h = 0.0F;
/* 545 */       this.LA.field_78808_h = 0.0F;
/* 546 */       this.RA.field_78796_g = -(0.1F - f6 * 0.6F) + this.field_78116_c.field_78796_g;
/* 547 */       this.LA.field_78796_g = 0.1F - f6 * 0.6F + this.field_78116_c.field_78796_g + 0.4F;
/* 548 */       this.RA.field_78795_f = -1.5707964F + this.field_78116_c.field_78795_f;
/* 549 */       this.LA.field_78795_f = -1.5707964F + this.field_78116_c.field_78795_f;
/* 550 */       this.RA.field_78795_f -= f6 * 1.2F - f7 * 0.4F;
/* 551 */       this.LA.field_78795_f -= f6 * 1.2F - f7 * 0.4F;
/* 552 */       this.RA.field_78808_h += MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 553 */       this.LA.field_78808_h -= MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 554 */       this.RA.field_78795_f += MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/* 555 */       this.LA.field_78795_f -= MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/*     */     } 
/* 557 */     this.field_78118_o = false; }
/*     */   
/*     */   ModelRenderer LL; ModelRenderer B; ModelRenderer B1; ModelRenderer B2; ModelRenderer B3; ModelRenderer B4; ModelRenderer B5;
/*     */   ModelRenderer B7;
/*     */   ModelRenderer B9;
/*     */   public int b;
/*     */   
/*     */   public void func_78110_b(float par1) {
/* 565 */     this.field_78121_j.field_78796_g = this.field_78116_c.field_78796_g;
/* 566 */     this.field_78121_j.field_78795_f = this.field_78116_c.field_78795_f;
/* 567 */     this.field_78121_j.field_78800_c = 0.0F;
/* 568 */     this.field_78121_j.field_78797_d = 0.0F;
/* 569 */     this.field_78121_j.func_78785_a(par1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78111_c(float par1) {
/* 577 */     this.field_78122_k.func_78785_a(par1);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JBRA-Client-v1.6.52.jar!\JinRyuu\JBRA\ModelBipedMC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */