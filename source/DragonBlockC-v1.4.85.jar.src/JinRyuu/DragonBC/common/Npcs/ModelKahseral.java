/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelKahseral
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer Hat;
/*     */   public ModelRenderer EarR;
/*     */   public ModelRenderer EarL;
/*     */   public ModelRenderer Mic;
/*     */   
/*     */   public ModelKahseral() {
/*  22 */     this.field_78090_t = 64;
/*  23 */     this.field_78089_u = 64;
/*  24 */     this.Body = new ModelRenderer(this, 16, 16);
/*  25 */     this.Body.func_78793_a(0.0F, 0.0F, 0.0F);
/*  26 */     this.Body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
/*  27 */     this.Head = new ModelRenderer(this, 0, 0);
/*  28 */     this.Head.func_78793_a(0.0F, 0.0F, 0.0F);
/*  29 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
/*  30 */     this.LegR = new ModelRenderer(this, 0, 16);
/*  31 */     this.LegR.func_78793_a(-1.9F, 12.0F, 0.0F);
/*  32 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  33 */     this.EarL = new ModelRenderer(this, 33, 8);
/*  34 */     this.EarL.field_78809_i = true;
/*  35 */     this.EarL.func_78793_a(4.0F, -4.2F, 0.4F);
/*  36 */     this.EarL.func_78790_a(0.0F, -1.5F, -1.6F, 1, 3, 3, 0.0F);
/*  37 */     this.LegL = new ModelRenderer(this, 0, 16);
/*  38 */     this.LegL.field_78809_i = true;
/*  39 */     this.LegL.func_78793_a(1.9F, 12.0F, 0.0F);
/*  40 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  41 */     this.EarR = new ModelRenderer(this, 33, 8);
/*  42 */     this.EarR.func_78793_a(-4.0F, -4.2F, 0.4F);
/*  43 */     this.EarR.func_78790_a(-1.0F, -1.5F, -1.6F, 1, 3, 3, 0.0F);
/*  44 */     this.ArmR = new ModelRenderer(this, 40, 16);
/*  45 */     this.ArmR.func_78793_a(-5.0F, 2.0F, 0.0F);
/*  46 */     this.ArmR.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
/*  47 */     this.ArmL = new ModelRenderer(this, 40, 16);
/*  48 */     this.ArmL.field_78809_i = true;
/*  49 */     this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
/*  50 */     this.ArmL.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
/*  51 */     this.Hat = new ModelRenderer(this, 0, 33);
/*  52 */     this.Hat.func_78793_a(0.0F, -6.2F, 0.0F);
/*  53 */     this.Hat.func_78790_a(-4.8F, -2.7F, -4.5F, 9, 3, 9, 0.0F);
/*  54 */     setRotateAngle(this.Hat, -0.08726646F, 0.0F, -0.06806784F);
/*  55 */     this.Mic = new ModelRenderer(this, 42, 11);
/*  56 */     this.Mic.func_78793_a(4.0F, -1.7F, -4.0F);
/*  57 */     this.Mic.func_78790_a(-4.0F, -0.4F, -0.1F, 4, 1, 0, 0.0F);
/*  58 */     setRotateAngle(this.Mic, 0.0F, -0.06806784F, -0.10646509F);
/*  59 */     this.Head.func_78792_a(this.EarL);
/*  60 */     this.Head.func_78792_a(this.EarR);
/*  61 */     this.Head.func_78792_a(this.Hat);
/*  62 */     this.Head.func_78792_a(this.Mic);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  67 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/*  69 */     this.Body.func_78785_a(f5);
/*  70 */     this.LegR.func_78785_a(f5);
/*  71 */     this.Head.func_78785_a(f5);
/*  72 */     this.ArmL.func_78785_a(f5);
/*  73 */     this.ArmR.func_78785_a(f5);
/*  74 */     this.LegL.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/*  80 */     modelRenderer.field_78795_f = x;
/*  81 */     modelRenderer.field_78796_g = y;
/*  82 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/*  86 */     int calc = par7Entity.field_70173_aa;
/*  87 */     if (calc > 100) calc -= 100; 
/*  88 */     float r = 360.0F;
/*  89 */     float r2 = 180.0F;
/*  90 */     float n4 = par4;
/*  91 */     float n5 = par5;
/*     */ 
/*     */ 
/*     */     
/*  95 */     float ex = par7Entity.field_70173_aa;
/*  96 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/*  97 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/*  99 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 100 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 149 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 150 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 151 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 152 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 154 */     this.LegR.field_78796_g = 0.0F;
/* 155 */     this.LegL.field_78796_g = 0.0F;
/* 156 */     this.ArmR.field_78796_g = 0.0F;
/* 157 */     this.ArmL.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 164 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelKahseral.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */