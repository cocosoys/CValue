/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import net.minecraft.client.model.ModelBase;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModelDragon
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer bodyM;
/*     */   public ModelRenderer HeadM;
/*     */   public ModelRenderer[] body1;
/*     */   public ModelRenderer[] body2;
/*     */   public ModelRenderer[] body3;
/*     */   public ModelRenderer Head1;
/*     */   public ModelRenderer HeadSnout;
/*     */   public ModelRenderer HeadM2;
/*     */   public ModelRenderer body4;
/*     */   public ModelRenderer body5;
/*     */   public ModelRenderer hornLB;
/*     */   public ModelRenderer hornRB;
/*     */   public ModelRenderer hornL;
/*     */   public ModelRenderer hornL1;
/*     */   public ModelRenderer hornL2;
/*     */   public ModelRenderer hornR;
/*     */   public ModelRenderer hornR1;
/*     */   public ModelRenderer hornR2;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer ArmR1;
/*     */   public ModelRenderer FingerR1;
/*     */   public ModelRenderer FingerR2;
/*     */   public ModelRenderer FingerR3;
/*     */   public ModelRenderer FingerR0;
/*     */   public ModelRenderer ArmL1;
/*     */   public ModelRenderer FingerL1;
/*     */   public ModelRenderer FingerL2;
/*     */   public ModelRenderer FingerL3;
/*     */   public ModelRenderer FingerL0;
/*     */   public ModelRenderer[] whiskR;
/*     */   public ModelRenderer[] whiskL;
/*     */   ArrayList<ModelRenderer> models;
/*     */   ArrayList<ModelRenderer> wiskerr;
/*     */   ArrayList<ModelRenderer> wiskerl;
/*     */   
/*     */   public ModelDragon() {
/* 305 */     this.models = new ArrayList<ModelRenderer>();
/* 306 */     this.wiskerr = new ArrayList<ModelRenderer>();
/* 307 */     this.wiskerl = new ArrayList<ModelRenderer>(); this.field_78090_t = 128; this.field_78089_u = 128; this.HeadM = new ModelRenderer(this, 40, 0); this.HeadM.func_78793_a(0.0F, 0.0F, 0.0F); this.HeadM.func_78790_a(-5.0F, -5.0F, -10.0F, 10, 7, 10, 0.0F); setRotate(this.HeadM, -1.54F, 0.0F, 0.0F); this.HeadSnout = new ModelRenderer(this, 80, 0); this.HeadSnout.func_78793_a(0.0F, 0.0F, -10.0F); this.HeadSnout.func_78790_a(-4.0F, -1.0F, -12.0F, 8, 3, 12, 0.0F); this.Head1 = new ModelRenderer(this, 40, 17); this.Head1.func_78793_a(0.0F, 4.0F, -8.0F); this.Head1.func_78790_a(-4.0F, -2.0F, -14.0F, 8, 3, 16, 0.0F); this.HeadM2 = new ModelRenderer(this, 74, 15); this.HeadM2.func_78793_a(0.0F, 0.0F, 0.0F); this.HeadM2.func_78790_a(-5.0F, 2.0F, -6.0F, 10, 3, 6, 0.0F); this.bodyM = new ModelRenderer(this, 0, 0); this.bodyM.func_78793_a(0.0F, -80.0F, 0.0F); this.bodyM.func_78790_a(0.0F, 0.0F, 5.0F, 0, 0, 0, 0.0F); this.whiskL = new ModelRenderer[8]; this.whiskR = new ModelRenderer[8]; int i; for (i = 0; i < this.whiskL.length; i++) { this.whiskL[i] = new ModelRenderer(this, 40, 17); this.whiskL[i].func_78793_a(3.8F, (i == 0) ? 0.5F : 0.0F, (i == 0) ? -10.0F : 0.0F); this.whiskL[i].func_78790_a(0.0F, -0.5F, -0.5F, 4, 1, 1, 0.0F); if (i > 0 && i < this.whiskL.length) this.whiskL[i - 1].func_78792_a(this.whiskL[i]);  this.wiskerl.add(this.whiskL[i]); }  for (i = 0; i < this.whiskR.length; i++) { this.whiskR[i] = new ModelRenderer(this, 40, 17); this.whiskR[i].func_78793_a(-3.8F, (i == 0) ? -0.5F : 0.0F, (i == 0) ? -10.0F : 0.0F); this.whiskR[i].func_78790_a(-4.0F, -0.5F, -0.5F, 4, 1, 1, 0.0F); if (i > 0 && i < this.whiskR.length)
/*     */         this.whiskR[i - 1].func_78792_a(this.whiskR[i]);  this.wiskerr.add(this.whiskR[i]); }  this.hornL2 = new ModelRenderer(this, 0, 0); this.hornL2.func_78793_a(0.0F, -3.0F, 0.0F); this.hornL2.func_78790_a(-1.0F, -8.0F, -1.0F, 2, 8, 2, 0.0F); setRotate(this.hornL2, 0.68294734F, 0.0F, 0.0F); this.FingerR1 = new ModelRenderer(this, 0, 84); this.FingerR1.func_78793_a(-15.0F, -1.6F, -0.5F); this.FingerR1.func_78790_a(-6.0F, -1.0F, -1.0F, 6, 2, 2, 0.0F); setRotate(this.FingerR1, 0.0F, -0.59184116F, 0.5009095F); this.hornLB = new ModelRenderer(this, 40, 23); this.hornLB.func_78793_a(2.5F, -3.5F, -4.0F); this.hornLB.func_78790_a(-2.0F, -6.0F, -2.0F, 4, 6, 4, 0.0F); setRotate(this.hornLB, -0.8196066F, 0.27314404F, 0.0F); this.FingerR3 = new ModelRenderer(this, 0, 84); this.FingerR3.func_78793_a(-14.0F, 1.5F, -0.5F); this.FingerR3.func_78790_a(-6.0F, -1.0F, -1.0F, 6, 2, 2, 0.0F); setRotate(this.FingerR3, 0.0F, -0.59184116F, -0.8196066F); this.FingerL1 = new ModelRenderer(this, 0, 84); this.FingerL1.field_78809_i = true; this.FingerL1.func_78793_a(15.0F, -1.6F, -0.5F); this.FingerL1.func_78790_a(0.0F, -1.0F, -1.0F, 6, 2, 2, 0.0F); setRotate(this.FingerL1, 0.0F, 0.57595867F, -0.5009095F); this.ArmR1 = new ModelRenderer(this, 0, 76); this.ArmR1.func_78793_a(-14.0F, 0.0F, 0.0F); this.ArmR1.func_78790_a(-16.0F, -2.0F, -2.0F, 16, 4, 4, 0.0F); setRotate(this.ArmR1, 0.0F, -1.0471976F, 0.0F); this.hornR = new ModelRenderer(this, 106, 15); this.hornR.func_78793_a(0.0F, -6.0F, 0.0F); this.hornR.func_78790_a(-1.0F, -16.0F, -1.0F, 2, 16, 2, 0.0F); this.FingerL2 = new ModelRenderer(this, 0, 84); this.FingerL2.field_78809_i = true; this.FingerL2.func_78793_a(15.0F, 0.5F, -0.5F); this.FingerL2.func_78790_a(0.0F, -1.0F, -1.0F, 6, 2, 2, 0.0F); setRotate(this.FingerL2, 0.0F, 0.59184116F, 0.0F); this.ArmL1 = new ModelRenderer(this, 0, 76); this.ArmL1.field_78809_i = true; this.ArmL1.func_78793_a(14.0F, 0.0F, 0.0F); this.ArmL1.func_78790_a(0.0F, -2.0F, -2.0F, 16, 4, 4, 0.0F); setRotate(this.ArmL1, 0.0F, 1.0016445F, 0.0F); this.hornRB = new ModelRenderer(this, 40, 23); this.hornRB.func_78793_a(-2.5F, -3.5F, -4.0F); this.hornRB.func_78790_a(-2.0F, -6.0F, -2.0F, 4, 6, 4, 0.0F); setRotate(this.hornRB, -0.8196066F, -0.27314404F, 0.0F); this.hornL1 = new ModelRenderer(this, 0, 0); this.hornL1.func_78793_a(0.0F, -4.0F, 0.0F); this.hornL1.func_78790_a(-1.0F, -8.0F, -1.0F, 2, 8, 2, 0.0F); setRotate(this.hornL1, -0.63739425F, 0.0F, 0.0F); this.ArmL = new ModelRenderer(this, 0, 68); this.ArmL.field_78809_i = true; this.ArmL.func_78793_a(4.0F, 12.0F, 0.0F); this.ArmL.func_78790_a(-0.0F, -2.0F, -2.0F, 16, 4, 4, 0.0F); this.FingerL3 = new ModelRenderer(this, 0, 84); this.FingerL3.field_78809_i = true; this.FingerL3.func_78793_a(14.0F, 1.6F, -0.5F); this.FingerL3.func_78790_a(0.0F, -1.0F, -1.0F, 6, 2, 2, 0.0F); setRotate(this.FingerL3, 0.0F, 0.59184116F, 0.5009095F); this.FingerR2 = new ModelRenderer(this, 0, 84); this.FingerR2.func_78793_a(-15.0F, 0.5F, -0.5F); this.FingerR2.func_78790_a(-6.0F, -1.0F, -1.0F, 6, 2, 2, 0.0F); setRotate(this.FingerR2, 0.0F, -0.59184116F, 0.0F); this.hornL = new ModelRenderer(this, 106, 15); this.hornL.func_78793_a(0.0F, -6.0F, 0.0F); this.hornL.func_78790_a(-1.0F, -16.0F, -1.0F, 2, 16, 2, 0.0F); this.hornR2 = new ModelRenderer(this, 0, 0); this.hornR2.func_78793_a(0.0F, -3.0F, 0.0F); this.hornR2.func_78790_a(-1.0F, -8.0F, -1.0F, 2, 8, 2, 0.0F); setRotate(this.hornR2, 0.68294734F, 0.0F, 0.0F); this.ArmR = new ModelRenderer(this, 0, 68); this.ArmR.func_78793_a(-4.0F, 12.0F, 0.0F); this.ArmR.func_78790_a(-16.0F, -2.0F, -2.0F, 16, 4, 4, 0.0F); this.FingerL0 = new ModelRenderer(this, 0, 84); this.FingerL0.field_78809_i = true; this.FingerL0.func_78793_a(13.0F, -1.0F, -0.5F); this.FingerL0.func_78790_a(0.0F, -1.0F, -1.0F, 6, 2, 2, 0.0F); setRotate(this.FingerL0, 0.0F, 0.59184116F, -1.548107F); this.hornR1 = new ModelRenderer(this, 0, 0); this.hornR1.func_78793_a(0.0F, -4.0F, 0.0F); this.hornR1.func_78790_a(-1.0F, -8.0F, -1.0F, 2, 8, 2, 0.0F); setRotate(this.hornR1, -0.63739425F, 0.0F, 0.0F); this.FingerR0 = new ModelRenderer(this, 0, 84); this.FingerR0.func_78793_a(-13.0F, -1.0F, -0.5F); this.FingerR0.func_78790_a(-6.0F, -1.0F, -1.0F, 6, 2, 2, 0.0F); setRotate(this.FingerR0, 0.0F, -0.59184116F, 1.548107F); this.HeadM.func_78792_a(this.hornLB); this.HeadM.func_78792_a(this.hornRB); this.hornL.func_78792_a(this.hornL2); this.hornRB.func_78792_a(this.hornR); this.hornL.func_78792_a(this.hornL1); this.hornLB.func_78792_a(this.hornL); this.hornR.func_78792_a(this.hornR2); this.hornR.func_78792_a(this.hornR1); this.ArmR1.func_78792_a(this.FingerR0); this.ArmL1.func_78792_a(this.FingerL0); this.ArmL1.func_78792_a(this.FingerL3); this.ArmR1.func_78792_a(this.FingerR2); this.ArmL1.func_78792_a(this.FingerL2); this.ArmR1.func_78792_a(this.FingerR1); this.ArmR1.func_78792_a(this.FingerR3); this.ArmL1.func_78792_a(this.FingerL1); this.ArmL.func_78792_a(this.ArmL1); this.ArmR.func_78792_a(this.ArmR1); this.body1 = new ModelRenderer[12]; this.body2 = new ModelRenderer[8]; this.body3 = new ModelRenderer[4]; for (i = 0; i < this.body1.length; i++) { this.body1[i] = new ModelRenderer(this, 0, 34); this.body1[i].func_78793_a(0.0F, (i == 0) ? 0.0F : 23.0F, 0.0F); this.body1[i].func_78790_a(-5.0F, 0.0F, -5.0F, 10, 24, 10, 0.0F); if (i > 0 && i < this.body1.length)
/*     */         this.body1[i - 1].func_78792_a(this.body1[i]);  this.models.add(this.body1[i]); }  for (i = 0; i < this.body2.length; i++) { this.body2[i] = new ModelRenderer(this, 40, 36); this.body2[i].func_78793_a(0.0F, (i == 0) ? 23.0F : 17.0F, 0.0F); this.body2[i].func_78790_a(-4.0F, 0.0F, -4.0F, 8, 18, 8, 0.0F); if (i > 0 && i < this.body2.length)
/*     */         this.body2[i - 1].func_78792_a(this.body2[i]);  this.models.add(this.body2[i]); }  for (i = 0; i < this.body3.length; i++) { this.body3[i] = new ModelRenderer(this, 72, 36); this.body3[i].func_78793_a(0.0F, (i == 0) ? 16.0F : 15.0F, 0.0F); this.body3[i].func_78790_a(-3.0F, 0.0F, -3.0F, 6, 16, 6, 0.0F); if (i > 0 && i < this.body3.length)
/* 311 */         this.body3[i - 1].func_78792_a(this.body3[i]);  this.models.add(this.body3[i]); }  this.body4 = new ModelRenderer(this, 96, 36); this.body4.func_78793_a(0.0F, 15.0F, 0.0F); this.body4.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 14, 4, 0.0F); this.body5 = new ModelRenderer(this, 112, 36); this.body5.func_78793_a(0.0F, 13.0F, 0.0F); this.body5.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 14, 2, 0.0F); this.models.add(this.body4); this.models.add(this.body5); this.bodyM.func_78792_a(this.body1[0]); this.body1[this.body1.length - 1].func_78792_a(this.body2[0]); this.body2[this.body2.length - 1].func_78792_a(this.body3[0]); this.body3[this.body3.length - 1].func_78792_a(this.body4); this.body4.func_78792_a(this.body5); this.HeadSnout.func_78792_a(this.whiskL[0]); this.HeadSnout.func_78792_a(this.whiskR[0]); this.bodyM.func_78792_a(this.HeadM); this.HeadM.func_78792_a(this.Head1); this.HeadM.func_78792_a(this.HeadSnout); this.HeadM.func_78792_a(this.HeadM2); this.body1[1].func_78792_a(this.ArmL); this.body1[1].func_78792_a(this.ArmR); this.body1[11].func_78792_a(this.ArmL); this.body1[11].func_78792_a(this.ArmR); } public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { GL11.glScaled(2.0D, 2.0D, 2.0D);
/* 312 */     this.bodyM.func_78785_a(f5);
/* 313 */     func_78087_a(f, f1, f2, f3, f4, f5, entity); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotate(ModelRenderer modelRenderer, float x, float y, float z) {
/* 320 */     modelRenderer.field_78795_f = x;
/* 321 */     modelRenderer.field_78796_g = y;
/* 322 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 328 */     this.HeadM.field_78796_g = par4 / 57.295776F;
/* 329 */     this.HeadM.field_78795_f = par5 / 57.295776F * 1.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 337 */     float r = MathHelper.func_76126_a(par3 * 0.02F) * 0.1F;
/* 338 */     float r2 = MathHelper.func_76134_b(par3 * 0.02F) * 0.1F;
/* 339 */     float r3 = MathHelper.func_76134_b(par3 * 0.14F) * 0.1F;
/*     */ 
/*     */     
/* 342 */     this.ArmL.field_78796_g = 0.3F + r2 * 2.0F;
/* 343 */     this.ArmR.field_78796_g = -0.3F - r2 * 2.0F;
/*     */ 
/*     */     
/* 346 */     this.ArmL1.field_78796_g = 0.6F + r2 * 2.0F;
/* 347 */     this.ArmR1.field_78796_g = -0.6F - r2 * 2.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 358 */     this.body4.field_78796_g = 0.0F;
/* 359 */     this.body4.field_78795_f = 0.0F;
/* 360 */     this.body5.field_78796_g = 0.0F;
/* 361 */     this.body5.field_78795_f = 0.0F;
/*     */ 
/*     */     
/*     */     int i;
/*     */     
/* 366 */     for (i = 0; i < this.wiskerr.size(); i++) {
/* 367 */       ModelRenderer o = this.wiskerr.get(i);
/* 368 */       if (o != null) {
/* 369 */         if (i == 0 || i == 1) {
/* 370 */           o.field_78808_h = 0.2F - r2 * 1.05F;
/* 371 */           o.field_78795_f = -0.0F + r * 0.75F;
/*     */         }
/* 373 */         else if (i == 2 || i == 3) {
/* 374 */           o.field_78808_h = -0.45F + r2 * 1.05F;
/* 375 */           o.field_78795_f = -0.3F + r * 0.5F;
/*     */         }
/* 377 */         else if (i == 4 || i == 5 || i == 6) {
/* 378 */           o.field_78808_h = 0.2F + 0.1F * i - r * 1.05F;
/* 379 */           o.field_78795_f = -0.3F + 0.1F * i - r * 0.5F;
/*     */         }
/* 381 */         else if (i == 7 || i == 8) {
/* 382 */           o.field_78808_h = -0.75F - r * 1.05F;
/* 383 */           o.field_78795_f = -0.2F - r2 * 0.5F;
/*     */         } else {
/*     */           
/* 386 */           o.field_78808_h = -0.0F;
/* 387 */           o.field_78795_f = -0.0F;
/* 388 */           o.field_78796_g = -0.0F;
/*     */         } 
/*     */       }
/*     */     } 
/* 392 */     for (i = 0; i < this.wiskerl.size(); i++) {
/* 393 */       ModelRenderer o = this.wiskerl.get(i);
/* 394 */       if (o != null) {
/* 395 */         if (i == 0 || i == 1) {
/* 396 */           o.field_78808_h = -0.2F - r2 * 1.05F;
/* 397 */           o.field_78795_f = -0.0F + r * 0.75F;
/*     */         }
/* 399 */         else if (i == 2 || i == 3) {
/* 400 */           o.field_78808_h = 0.45F - r * 1.05F;
/* 401 */           o.field_78795_f = -0.3F + r2 * 0.75F;
/*     */         }
/* 403 */         else if (i == 4 || i == 5 || i == 6) {
/* 404 */           o.field_78808_h = -0.2F - 0.1F * i + r * 1.05F;
/* 405 */           o.field_78795_f = -0.3F + 0.1F * i - r2 * 0.75F;
/*     */         }
/* 407 */         else if (i == 7 || i == 8) {
/* 408 */           o.field_78808_h = 0.75F + r2 * 1.05F;
/* 409 */           o.field_78795_f = -0.2F - r * 0.75F;
/*     */         } else {
/*     */           
/* 412 */           o.field_78808_h = -0.0F;
/* 413 */           o.field_78795_f = -0.0F;
/* 414 */           o.field_78796_g = -0.0F;
/*     */         } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 454 */     this.Head1.field_78808_h = -0.0F;
/* 455 */     this.Head1.field_78795_f = 0.15F + r2 * 0.5F;
/*     */     
/* 457 */     this.bodyM.field_78797_d = -200.0F + r * 40.0F;
/* 458 */     for (i = 0; i < this.models.size(); i++) {
/* 459 */       if (i == 0) {
/* 460 */         ModelRenderer o = this.models.get(i);
/* 461 */         o.field_78808_h = 0.0F;
/* 462 */         o.field_78795_f = 2.0F;
/*     */       
/*     */       }
/* 465 */       else if (i == 1 || i == 2 || i == 3) {
/* 466 */         ModelRenderer o = this.models.get(i);
/* 467 */         o.field_78808_h = -0.9F + r * 0.75F;
/* 468 */         o.field_78795_f = -0.5F;
/*     */ 
/*     */       
/*     */       }
/* 472 */       else if (i == 4 || i == 5 || i == 6) {
/* 473 */         ModelRenderer o = this.models.get(i);
/* 474 */         o.field_78808_h = 0.9F - r * 0.75F;
/* 475 */         o.field_78795_f = -0.7F;
/*     */ 
/*     */       
/*     */       }
/* 479 */       else if (i == 7 || i == 8 || i == 9) {
/* 480 */         ModelRenderer o = this.models.get(i);
/* 481 */         o.field_78808_h = -0.75F + r * 0.75F;
/* 482 */         o.field_78795_f = -0.3F;
/*     */ 
/*     */       
/*     */       }
/* 486 */       else if (i == 10 || i == 11 || i == 12) {
/* 487 */         ModelRenderer o = this.models.get(i);
/* 488 */         o.field_78808_h = -0.5F - r * 0.75F;
/* 489 */         o.field_78795_f = -0.25F;
/*     */ 
/*     */       
/*     */       }
/* 493 */       else if (i == 13 || i == 14 || i == 15) {
/* 494 */         ModelRenderer o = this.models.get(i);
/* 495 */         o.field_78808_h = 0.5F + r * 0.75F;
/* 496 */         o.field_78795_f = 0.75F;
/*     */ 
/*     */       
/*     */       }
/* 500 */       else if (i == 16 || i == 17 || i == 18) {
/* 501 */         ModelRenderer o = this.models.get(i);
/* 502 */         o.field_78808_h = 0.75F - r * 0.75F;
/* 503 */         o.field_78795_f = -0.5F;
/*     */ 
/*     */       
/*     */       }
/* 507 */       else if (i == 19 || i == 20 || i == 21) {
/* 508 */         ModelRenderer o = this.models.get(i);
/* 509 */         o.field_78808_h = -0.5F + r * 0.75F;
/* 510 */         o.field_78795_f = -0.75F;
/*     */ 
/*     */       
/*     */       }
/* 514 */       else if (i == 22 || i == 23) {
/* 515 */         ModelRenderer o = this.models.get(i);
/* 516 */         o.field_78808_h = 1.0F - r * 0.75F;
/* 517 */         o.field_78795_f = 0.5F;
/*     */ 
/*     */       
/*     */       }
/* 521 */       else if (i == 24 || i == 25) {
/* 522 */         ModelRenderer o = this.models.get(i);
/* 523 */         o.field_78808_h = -0.2F + r * 0.75F;
/* 524 */         o.field_78795_f = 0.1F;
/*     */ 
/*     */ 
/*     */       
/*     */       }
/*     */       else {
/*     */ 
/*     */ 
/*     */         
/* 533 */         ModelRenderer o = this.models.get(i);
/* 534 */         o.field_78808_h = -0.0F;
/* 535 */         o.field_78795_f = -0.0F;
/* 536 */         o.field_78796_g = -0.0F;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelDragon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */