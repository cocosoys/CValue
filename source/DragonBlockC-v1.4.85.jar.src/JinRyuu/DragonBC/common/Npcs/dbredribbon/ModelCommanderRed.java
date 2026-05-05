/*     */ package JinRyuu.DragonBC.common.Npcs.dbredribbon;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelCommanderRed
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer Hair1;
/*     */   public ModelRenderer Hair2;
/*     */   
/*     */   public ModelCommanderRed() {
/*  21 */     this.field_78090_t = 64;
/*  22 */     this.field_78089_u = 64;
/*  23 */     this.Head = new ModelRenderer(this, 0, 0);
/*  24 */     this.Head.func_78793_a(0.0F, 6.0F, 0.0F);
/*  25 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
/*  26 */     this.Hair1 = new ModelRenderer(this, 0, 34);
/*  27 */     this.Hair1.func_78793_a(0.0F, -5.1F, 3.1F);
/*  28 */     this.Hair1.func_78790_a(-4.5F, -3.0F, -3.0F, 9, 4, 4, 0.0F);
/*  29 */     this.ArmL = new ModelRenderer(this, 44, 17);
/*  30 */     this.ArmL.field_78809_i = true;
/*  31 */     this.ArmL.func_78793_a(5.0F, 8.0F, 0.0F);
/*  32 */     this.ArmL.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 9, 4, 0.0F);
/*  33 */     this.LegR = new ModelRenderer(this, 0, 18);
/*  34 */     this.LegR.func_78793_a(-2.0F, 15.0F, 0.0F);
/*  35 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 9, 4, 0.0F);
/*  36 */     this.LegL = new ModelRenderer(this, 0, 18);
/*  37 */     this.LegL.field_78809_i = true;
/*  38 */     this.LegL.func_78793_a(2.0F, 15.0F, 0.0F);
/*  39 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 9, 4, 0.0F);
/*  40 */     this.Hair2 = new ModelRenderer(this, 0, 43);
/*  41 */     this.Hair2.func_78793_a(0.0F, -5.7F, 0.0F);
/*  42 */     this.Hair2.func_78790_a(-2.5F, -2.8F, -4.4F, 5, 3, 6, 0.0F);
/*  43 */     this.Body = new ModelRenderer(this, 17, 17);
/*  44 */     this.Body.func_78793_a(0.0F, 6.0F, 0.0F);
/*  45 */     this.Body.func_78790_a(-4.0F, 0.0F, -2.5F, 8, 9, 5, 0.0F);
/*  46 */     this.ArmR = new ModelRenderer(this, 44, 3);
/*  47 */     this.ArmR.func_78793_a(-5.0F, 8.0F, 0.0F);
/*  48 */     this.ArmR.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 9, 4, 0.0F);
/*  49 */     this.Head.func_78792_a(this.Hair1);
/*  50 */     this.Head.func_78792_a(this.Hair2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  55 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/*  57 */     this.Head.func_78785_a(f5);
/*     */     
/*  59 */     this.Body.func_78785_a(f5);
/*  60 */     this.ArmR.func_78785_a(f5);
/*  61 */     this.ArmL.func_78785_a(f5);
/*  62 */     this.LegL.func_78785_a(f5);
/*  63 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/*  72 */     modelRenderer.field_78795_f = x;
/*  73 */     modelRenderer.field_78796_g = y;
/*  74 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/*  78 */     int calc = par7Entity.field_70173_aa;
/*  79 */     if (calc > 100) calc -= 100; 
/*  80 */     float r = 360.0F;
/*  81 */     float r2 = 180.0F;
/*  82 */     float n4 = par4;
/*  83 */     float n5 = par5;
/*     */     
/*  85 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/*  86 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/*  87 */     float ex = par7Entity.field_70173_aa;
/*  88 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/*  89 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/*  91 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/*  92 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 141 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 142 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 143 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 144 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 146 */     this.LegR.field_78796_g = 0.0F;
/* 147 */     this.LegL.field_78796_g = 0.0F;
/* 148 */     this.ArmR.field_78796_g = 0.0F;
/* 149 */     this.ArmL.field_78796_g = 0.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbredribbon\ModelCommanderRed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */