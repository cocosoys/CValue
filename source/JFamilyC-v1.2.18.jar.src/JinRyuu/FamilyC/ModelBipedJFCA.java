/*     */ package JinRyuu.FamilyC;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreH;
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
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class ModelBipedJFCA
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
/*     */   private String name;
/*     */   private String dns;
/*     */   private float age;
/*     */   
/*     */   public ModelBipedJFCA() {
/*  65 */     this(0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public ModelBipedJFCA(float par1) {
/*  70 */     this(par1, 0.0F, 128, 64);
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
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
/*     */     if (par1Entity instanceof EntityNPC) {
/*     */       EntityNPC e = (EntityNPC)par1Entity;
/*     */       this.dns = e.getDNS();
/*     */       g = JRMCoreH.dnsGender(this.dns) + 1;
/*     */       this.age = e.getNPCgrw();
/*     */       this.b = JRMCoreH.dnsBreast(this.dns);
/*     */       f = this.age;
/*     */     } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ModelBipedJFCA(float par1, float par2, int par3, int par4) {
/* 441 */     this.b = 0; this.field_78119_l = 0; this.field_78120_m = 0; this.field_78117_n = false; this.field_78118_o = false; this.field_78090_t = par3; this.field_78089_u = par4; this.field_78122_k = new ModelRenderer((ModelBase)this, 0, 0); this.field_78122_k.func_78790_a(-5.0F, 0.0F, -1.0F, 10, 16, 1, par1); this.field_78121_j = new ModelRenderer((ModelBase)this, 24, 0); this.field_78121_j.func_78790_a(-3.0F, -6.0F, -1.0F, 6, 6, 1, par1); this.field_78116_c = new ModelRenderer((ModelBase)this, 0, 0); this.field_78116_c.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, par1); this.field_78116_c.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.field_78115_e = new ModelRenderer((ModelBase)this, 16, 16); this.field_78115_e.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, par1); this.field_78115_e.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.field_78112_f = new ModelRenderer((ModelBase)this, 40, 16); this.field_78112_f.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, par1); this.field_78112_f.func_78793_a(-5.0F, 2.0F + par2, 0.0F); this.field_78113_g = new ModelRenderer((ModelBase)this, 40, 16); this.field_78113_g.field_78809_i = true; this.field_78113_g.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, par1); this.field_78113_g.func_78793_a(5.0F, 2.0F + par2, 0.0F); this.field_78123_h = new ModelRenderer((ModelBase)this, 0, 16); this.field_78123_h.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, par1); this.field_78123_h.func_78793_a(-1.9F, 12.0F + par2, 0.0F); this.field_78124_i = new ModelRenderer((ModelBase)this, 0, 16); this.field_78124_i.field_78809_i = true; this.field_78124_i.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, par1); this.field_78124_i.func_78793_a(1.9F, 12.0F + par2, 0.0F); this.rightarmshoulder = new ModelRenderer((ModelBase)this, 40, 32); this.rightarmshoulder.func_78789_a(-6.0F, -4.0F, -3.0F, 7, 4, 6); this.rightarmshoulder.func_78793_a(-5.0F, 3.0F, 0.0F); this.rightarmshoulder.func_78787_b(128, 64); this.leftarmshoulder = new ModelRenderer((ModelBase)this, 40, 32); this.leftarmshoulder.field_78809_i = true; this.leftarmshoulder.func_78789_a(-1.0F, -4.0F, -3.0F, 7, 4, 6); this.leftarmshoulder.func_78793_a(5.0F, 3.0F, 0.0F); this.leftarmshoulder.func_78787_b(128, 64); this.rightarm = new ModelRenderer((ModelBase)this, 40, 16); this.rightarm.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, par1 * 0.5F); this.rightarm.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.rightarm, 0.0F, 0.0F, 0.122173F); this.leftarm = new ModelRenderer((ModelBase)this, 40, 16); this.leftarm.field_78809_i = true; this.leftarm.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, par1 * 0.5F); this.leftarm.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.leftarm, 0.0F, 0.0F, -0.122173F); this.Brightarm = new ModelRenderer((ModelBase)this, 0, 0); this.Brightarm.func_78790_a(-3.0F, -2.0F, -2.0F, 0, 0, 0, par1 * 0.5F); this.Brightarm.func_78793_a(-5.0F, 2.0F, 0.0F); this.Bleftarm = new ModelRenderer((ModelBase)this, 0, 0); this.Bleftarm.field_78809_i = true; this.Bleftarm.func_78790_a(-1.0F, -2.0F, -2.0F, 0, 0, 0, par1 * 0.5F); this.Bleftarm.func_78793_a(5.0F, 2.0F, 0.0F); this.rightleg = new ModelRenderer((ModelBase)this, 0, 16); this.rightleg.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, par1 * 0.5F); this.rightleg.func_78793_a(-2.0F, 12.0F, 0.0F); setRotation(this.rightleg, 0.0F, 0.0F, 0.0F); this.leftleg = new ModelRenderer((ModelBase)this, 0, 16); this.leftleg.field_78809_i = true; this.leftleg.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, par1 * 0.5F); this.leftleg.func_78793_a(2.0F, 12.0F, 0.0F); setRotation(this.leftleg, 0.0F, 0.0F, 0.0F); this.skirt1 = new ModelRenderer((ModelBase)this, 16, 18); this.skirt1.func_78790_a(-4.0F, 9.0F, -2.0F, 8, 2, 4, par1 * 0.5F); this.skirt1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.skirt1, 0.0F, 0.0F, 0.0F); this.skirt2 = new ModelRenderer((ModelBase)this, 16, 20); this.skirt2.func_78790_a(-4.0F, 11.0F, -2.0F, 8, 1, 4, par1 * 0.5F); this.skirt2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.skirt2, 0.0F, 0.0F, 0.0F); this.body = new ModelRenderer((ModelBase)this, 16, 16); this.body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 4, 4, par1 * 0.5F); this.body.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.body, 0.0F, 0.0F, 0.0F); this.hip2 = new ModelRenderer((ModelBase)this, 16, 16); this.hip2.func_78789_a(-4.0F, 7.0F, -2.0F, 8, 2, 4); this.hip2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.hip2, 0.0F, 0.0F, 0.0F); this.hip = new ModelRenderer((ModelBase)this, 16, 23); this.hip.func_78790_a(-4.0F, 7.0F, -2.0F, 8, 2, 4, par1 * 0.5F); this.hip.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.hip, 0.0F, 0.0F, 0.0F); this.waist = new ModelRenderer((ModelBase)this, 16, 20); this.waist.func_78790_a(-4.0F, 4.0F, -2.0F, 8, 3, 4, par1 * 0.5F); this.waist.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.waist, 0.0F, 0.0F, 0.0F); this.Bbreast = new ModelRenderer((ModelBase)this, 0, 0); this.Bbreast.func_78790_a(-4.0F, 2.266667F, -1.0F, 0, 0, 0, par1 * 0.5F); this.Bbreast.func_78793_a(0.0F, 0.0F, 0.0F); this.breast = new ModelRenderer((ModelBase)this, 17, 18); this.breast.func_78790_a(-4.0F, 2.266667F, -1.0F, 8, 3, 3, par1 * 0.5F); this.breast.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.breast, -0.5235988F, 0.0F, 0.0F); this.Bbreast2 = new ModelRenderer((ModelBase)this, 0, 0); this.Bbreast2.func_78790_a(-4.0F, 2.266667F, -1.0F, 0, 0, 0, par1 * 0.5F); this.Bbreast2.func_78793_a(0.0F, 0.0F, 0.0F); this.breast2 = new ModelRenderer((ModelBase)this, 9, 23); this.breast2.field_78809_i = true; this.breast2.func_78790_a(-4.0F, 2.266667F, -2.0F, 8, 3, 3, par1 * 0.5F); this.breast2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.breast2, 0.5235988F, 3.141593F, 0.0F); this.bottom2 = new ModelRenderer((ModelBase)this, 16, 16); this.bottom2.func_78790_a(-4.0F, 9.0F, -2.0F, 8, 3, 4, par1 * 0.5F); this.bottom2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.bottom2, 0.0F, 0.0F, 0.0F); this.bottom = new ModelRenderer((ModelBase)this, 16, 25); this.bottom.func_78790_a(-4.0F, 9.0F, -2.0F, 8, 3, 4, par1 * 0.5F); this.bottom.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.bottom, 0.0F, 0.0F, 0.0F);
/*     */     this.Bbreast.func_78792_a(this.breast);
/*     */     this.Bbreast2.func_78792_a(this.breast2);
/*     */     this.Bleftarm.func_78792_a(this.leftarm);
/* 445 */     this.Brightarm.func_78792_a(this.rightarm); } public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) { if (g >= 2) {
/* 446 */       this.RA = this.Brightarm;
/* 447 */       this.LA = this.Bleftarm;
/* 448 */       this.RL = this.rightleg;
/* 449 */       this.LL = this.leftleg;
/* 450 */       this.B = this.Bbreast;
/* 451 */       this.B1 = this.body;
/* 452 */       this.B2 = this.hip;
/* 453 */       this.B3 = this.waist;
/* 454 */       this.B4 = this.bottom;
/* 455 */       this.B5 = this.Bbreast2;
/* 456 */       this.B7 = this.hip2;
/* 457 */       this.B9 = this.bottom2;
/*     */     }
/*     */     else {
/*     */       
/* 461 */       this.RA = this.field_78112_f;
/* 462 */       this.LA = this.field_78113_g;
/* 463 */       this.RL = this.field_78123_h;
/* 464 */       this.LL = this.field_78124_i;
/* 465 */       this.B = this.B1 = this.B2 = this.B3 = this.B4 = this.B5 = this.B7 = this.B9 = this.field_78115_e;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 470 */     this.field_78116_c.field_78796_g = par4 / 57.295776F;
/* 471 */     this.field_78116_c.field_78795_f = par5 / 57.295776F;
/*     */ 
/*     */ 
/*     */     
/* 475 */     if (y == 1) {
/* 476 */       this.RA.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 2.0F * par2 * 0.5F;
/* 477 */       this.LA.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
/*     */     } else {
/* 479 */       this.RA.field_78795_f = 0.0F;
/* 480 */       this.LA.field_78795_f = 0.0F;
/*     */     } 
/* 482 */     this.RA.field_78808_h = 0.0F;
/* 483 */     this.LA.field_78808_h = 0.0F;
/* 484 */     if (y == 1) {
/* 485 */       this.RL.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F) * 1.4F * par2;
/* 486 */       this.LL.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.4F * par2;
/*     */     } else {
/* 488 */       this.RL.field_78795_f = 0.0F;
/* 489 */       this.LL.field_78795_f = 0.0F;
/*     */     } 
/* 491 */     this.RL.field_78796_g = 0.0F;
/* 492 */     this.LL.field_78796_g = 0.0F;
/*     */     
/* 494 */     this.rightarmshoulder.field_78795_f = this.RA.field_78795_f;
/* 495 */     this.leftarmshoulder.field_78795_f = this.LA.field_78795_f;
/* 496 */     this.rightarmshoulder.field_78808_h = this.RA.field_78808_h;
/* 497 */     this.leftarmshoulder.field_78808_h = this.LA.field_78808_h;
/*     */     
/* 499 */     if (this.field_78093_q) {
/*     */       
/* 501 */       this.RA.field_78795_f += -0.62831855F;
/* 502 */       this.LA.field_78795_f += -0.62831855F;
/* 503 */       this.RL.field_78795_f = -1.2566371F;
/* 504 */       this.LL.field_78795_f = -1.2566371F;
/* 505 */       this.RL.field_78796_g = 0.31415927F;
/* 506 */       this.LL.field_78796_g = -0.31415927F;
/*     */       
/* 508 */       this.rightarmshoulder.field_78795_f = this.RA.field_78795_f;
/* 509 */       this.leftarmshoulder.field_78795_f = this.LA.field_78795_f;
/*     */     } 
/*     */     
/* 512 */     if (this.field_78119_l != 0)
/*     */     {
/* 514 */       this.LA.field_78795_f = this.LA.field_78795_f * 0.5F - 0.31415927F * this.field_78119_l;
/*     */     }
/*     */     
/* 517 */     if (this.field_78120_m != 0)
/*     */     {
/* 519 */       this.RA.field_78795_f = this.RA.field_78795_f * 0.5F - 0.31415927F * this.field_78120_m;
/*     */     }
/*     */     
/* 522 */     this.RA.field_78796_g = 0.0F;
/* 523 */     this.LA.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */     
/* 527 */     this.rightarmshoulder.field_78796_g = this.RA.field_78796_g;
/* 528 */     this.leftarmshoulder.field_78796_g = this.LA.field_78796_g;
/*     */     
/* 530 */     if (this.field_78095_p > -9990.0F) {
/*     */       
/* 532 */       float var8 = this.field_78095_p;
/* 533 */       this.B.field_78796_g = MathHelper.func_76126_a(MathHelper.func_76129_c(var8) * 3.1415927F * 2.0F) * 0.2F;
/* 534 */       this.B9.field_78796_g = this.B.field_78796_g;
/* 535 */       this.RA.field_78798_e = MathHelper.func_76126_a(this.B.field_78796_g) * 5.0F;
/* 536 */       this.RA.field_78800_c = -MathHelper.func_76134_b(this.B.field_78796_g) * 5.0F;
/* 537 */       this.LA.field_78798_e = -MathHelper.func_76126_a(this.B.field_78796_g) * 5.0F;
/* 538 */       this.LA.field_78800_c = MathHelper.func_76134_b(this.B.field_78796_g) * 5.0F;
/* 539 */       this.RA.field_78796_g += this.B.field_78796_g;
/* 540 */       this.LA.field_78796_g += this.B.field_78796_g;
/* 541 */       this.LA.field_78795_f += this.B.field_78796_g;
/*     */       
/* 543 */       this.rightarmshoulder.field_78798_e = MathHelper.func_76126_a(this.B.field_78796_g) * 5.0F;
/* 544 */       this.rightarmshoulder.field_78800_c = -MathHelper.func_76134_b(this.B.field_78796_g) * 5.0F;
/* 545 */       this.leftarmshoulder.field_78798_e = -MathHelper.func_76126_a(this.B.field_78796_g) * 5.0F;
/* 546 */       this.leftarmshoulder.field_78800_c = MathHelper.func_76134_b(this.B.field_78796_g) * 5.0F;
/* 547 */       this.rightarmshoulder.field_78796_g += this.B.field_78796_g;
/* 548 */       this.leftarmshoulder.field_78796_g += this.B.field_78796_g;
/* 549 */       this.leftarmshoulder.field_78795_f += this.B.field_78796_g;
/*     */       
/* 551 */       var8 = 1.0F - this.field_78095_p;
/* 552 */       var8 *= var8;
/* 553 */       var8 *= var8;
/* 554 */       var8 = 1.0F - var8;
/* 555 */       float var9 = MathHelper.func_76126_a(var8 * 3.1415927F);
/* 556 */       float var10 = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -(this.field_78116_c.field_78795_f - 0.7F) * 0.75F;
/* 557 */       this.RA.field_78795_f = (float)(this.RA.field_78795_f - var9 * 1.2D + var10);
/* 558 */       this.RA.field_78796_g += this.B.field_78796_g * 2.0F;
/* 559 */       this.RA.field_78808_h = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -0.4F;
/*     */       
/* 561 */       this.rightarmshoulder.field_78795_f = (float)(this.RA.field_78795_f - var9 * 1.2D + var10);
/* 562 */       this.rightarmshoulder.field_78796_g += this.B.field_78796_g * 2.0F;
/* 563 */       this.rightarmshoulder.field_78808_h = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -0.4F;
/*     */     } 
/*     */     
/* 566 */     if (this.field_78117_n) {
/*     */       
/* 568 */       this.B.field_78795_f = 0.5F;
/* 569 */       this.B9.field_78795_f = this.B.field_78795_f;
/* 570 */       this.RA.field_78795_f += 0.4F;
/* 571 */       this.LA.field_78795_f += 0.4F;
/* 572 */       this.RL.field_78798_e = 4.0F;
/* 573 */       this.LL.field_78798_e = 4.0F;
/* 574 */       this.RL.field_78797_d = 9.0F;
/* 575 */       this.LL.field_78797_d = 9.0F;
/* 576 */       this.field_78116_c.field_78797_d = 1.0F;
/*     */ 
/*     */       
/* 579 */       this.rightarmshoulder.field_78795_f = this.RA.field_78795_f;
/* 580 */       this.leftarmshoulder.field_78795_f = this.LA.field_78795_f;
/*     */     }
/*     */     else {
/*     */       
/* 584 */       this.B.field_78795_f = 0.0F;
/* 585 */       this.B9.field_78795_f = this.B.field_78795_f;
/* 586 */       this.RL.field_78798_e = 0.1F;
/* 587 */       this.LL.field_78798_e = 0.1F;
/* 588 */       this.RL.field_78797_d = 12.0F;
/* 589 */       this.LL.field_78797_d = 12.0F;
/* 590 */       this.field_78116_c.field_78797_d = 0.0F;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 595 */     this.RA.field_78808_h += MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 596 */     this.LA.field_78808_h -= MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 597 */     this.RA.field_78795_f += MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/* 598 */     this.LA.field_78795_f -= MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/*     */     
/* 600 */     this.rightarmshoulder.field_78808_h = this.RA.field_78808_h;
/* 601 */     this.leftarmshoulder.field_78808_h = this.LA.field_78808_h;
/* 602 */     this.rightarmshoulder.field_78795_f = this.RA.field_78795_f;
/* 603 */     this.leftarmshoulder.field_78795_f = this.LA.field_78795_f;
/*     */     
/* 605 */     if (this.field_78118_o) {
/*     */       
/* 607 */       float var8 = 0.0F;
/* 608 */       float var9 = 0.0F;
/* 609 */       this.RA.field_78808_h = 0.0F;
/* 610 */       this.LA.field_78808_h = 0.0F;
/*     */       
/* 612 */       this.rightarmshoulder.field_78808_h = this.RA.field_78808_h;
/* 613 */       this.leftarmshoulder.field_78808_h = this.LA.field_78808_h;
/*     */       
/* 615 */       this.RA.field_78796_g = -(0.1F - var8 * 0.6F) + this.field_78116_c.field_78796_g;
/* 616 */       this.LA.field_78796_g = 0.1F - var8 * 0.6F + this.field_78116_c.field_78796_g + 0.4F;
/* 617 */       this.RA.field_78795_f = -1.5707964F + this.field_78116_c.field_78795_f;
/* 618 */       this.LA.field_78795_f = -1.5707964F + this.field_78116_c.field_78795_f;
/* 619 */       this.RA.field_78795_f -= var8 * 1.2F - var9 * 0.4F;
/* 620 */       this.LA.field_78795_f -= var8 * 1.2F - var9 * 0.4F;
/*     */       
/* 622 */       this.rightarmshoulder.field_78795_f = this.RA.field_78795_f;
/* 623 */       this.leftarmshoulder.field_78795_f = this.LA.field_78795_f;
/*     */       
/* 625 */       this.RA.field_78808_h += MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 626 */       this.LA.field_78808_h -= MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 627 */       this.RA.field_78795_f += MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/* 628 */       this.LA.field_78795_f -= MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/*     */       
/* 630 */       this.rightarmshoulder.field_78796_g = this.RA.field_78796_g;
/* 631 */       this.leftarmshoulder.field_78796_g = this.LA.field_78796_g;
/* 632 */       this.rightarmshoulder.field_78808_h = this.RA.field_78808_h;
/* 633 */       this.leftarmshoulder.field_78808_h = this.LA.field_78808_h;
/* 634 */       this.rightarmshoulder.field_78795_f = this.RA.field_78795_f;
/* 635 */       this.leftarmshoulder.field_78795_f = this.LA.field_78795_f;
/*     */     } 
/* 637 */     this.field_78118_o = false; }
/*     */    ModelRenderer B; ModelRenderer B1; ModelRenderer B2; ModelRenderer B3; ModelRenderer B4; ModelRenderer B5; ModelRenderer B7; ModelRenderer B9; public int b;
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/*     */     model.field_78795_f = x;
/*     */     model.field_78796_g = y;
/*     */     model.field_78808_h = z;
/*     */   }
/*     */   public void func_78110_b(float par1) {
/* 645 */     this.field_78121_j.field_78796_g = this.field_78116_c.field_78796_g;
/* 646 */     this.field_78121_j.field_78795_f = this.field_78116_c.field_78795_f;
/* 647 */     this.field_78121_j.field_78800_c = 0.0F;
/* 648 */     this.field_78121_j.field_78797_d = 0.0F;
/* 649 */     this.field_78121_j.func_78785_a(par1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78111_c(float par1) {
/* 657 */     this.field_78122_k.func_78785_a(par1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderHairs(float par1, String hair) {
/* 662 */     float f6 = f;
/* 663 */     GL11.glPushMatrix();
/* 664 */     GL11.glScalef((0.5F + 0.5F / f6) * ((g <= 1) ? 1.0F : 0.85F), 0.5F + 0.5F / f6, (0.5F + 0.5F / f6) * ((g <= 1) ? 1.0F : 0.85F));
/* 665 */     GL11.glTranslatef(0.0F, (f6 - 1.0F) / f6 * (2.0F - ((f6 >= 1.5F && f6 <= 2.0F) ? ((2.0F - f6) / 2.5F) : ((f6 < 1.5F && f6 >= 1.0F) ? ((f6 * 2.0F - 2.0F) * 0.2F) : 0.0F))), 0.0F);
/* 666 */     if (hair.contains("SC")) {
/* 667 */       this.field_78116_c.field_78796_g = this.field_78116_c.field_78796_g;
/* 668 */       this.field_78116_c.field_78795_f = this.field_78116_c.field_78795_f;
/* 669 */       this.field_78116_c.field_78800_c = this.field_78116_c.field_78800_c;
/* 670 */       this.field_78116_c.field_78797_d = this.field_78116_c.field_78797_d;
/* 671 */       this.field_78116_c.func_78785_a(par1);
/*     */     } 
/* 673 */     GL11.glPopMatrix();
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JFamilyC-v1.2.18.jar!\JinRyuu\FamilyC\ModelBipedJFCA.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */