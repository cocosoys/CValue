/*     */ package JinRyuu.DragonBC.common.Npcs.db;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelUpa
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer Feather;
/*     */   public ModelRenderer Hair;
/*     */   
/*     */   public ModelUpa() {
/*  20 */     this.field_78090_t = 64;
/*  21 */     this.field_78089_u = 64;
/*  22 */     this.ArmL = new ModelRenderer(this, 17, 33);
/*  23 */     this.ArmL.field_78809_i = true;
/*  24 */     this.ArmL.func_78793_a(5.0F, 9.7F, 0.0F);
/*  25 */     this.ArmL.func_78790_a(-1.0F, -0.6F, -1.5F, 3, 7, 3, 0.2F);
/*  26 */     this.Head = new ModelRenderer(this, 0, 0);
/*  27 */     this.Head.func_78793_a(0.0F, 8.9F, 0.0F);
/*  28 */     this.Head.func_78790_a(-4.0F, -8.0F, -3.8F, 8, 8, 7, 0.0F);
/*  29 */     this.ArmR = new ModelRenderer(this, 17, 33);
/*  30 */     this.ArmR.func_78793_a(-5.0F, 9.7F, 0.0F);
/*  31 */     this.ArmR.func_78790_a(-2.0F, -0.6F, -1.4F, 3, 7, 3, 0.2F);
/*  32 */     this.LegL = new ModelRenderer(this, 0, 33);
/*  33 */     this.LegL.field_78809_i = true;
/*  34 */     this.LegL.func_78793_a(2.0F, 17.3F, -0.1F);
/*  35 */     this.LegL.func_78790_a(-2.0F, -0.4F, -2.0F, 4, 7, 4, 0.0F);
/*  36 */     this.Hair = new ModelRenderer(this, 31, 0);
/*  37 */     this.Hair.func_78793_a(0.0F, -0.5F, 3.0F);
/*  38 */     this.Hair.func_78790_a(-1.0F, 0.0F, 0.0F, 2, 10, 0, 0.0F);
/*  39 */     this.Body = new ModelRenderer(this, 1, 15);
/*  40 */     this.Body.func_78793_a(0.0F, 8.9F, 0.0F);
/*  41 */     this.Body.func_78790_a(-4.0F, 0.0F, -2.1F, 8, 8, 4, 0.0F);
/*  42 */     this.Feather = new ModelRenderer(this, 35, 0);
/*  43 */     this.Feather.func_78793_a(0.0F, -8.3F, 2.8F);
/*  44 */     this.Feather.func_78790_a(-1.0F, -5.6F, 0.0F, 2, 6, 0, 0.0F);
/*  45 */     this.LegR = new ModelRenderer(this, 0, 33);
/*  46 */     this.LegR.func_78793_a(-2.0F, 17.3F, -0.1F);
/*  47 */     this.LegR.func_78790_a(-2.0F, -0.4F, -2.0F, 4, 7, 4, 0.0F);
/*  48 */     this.Head.func_78792_a(this.Hair);
/*  49 */     this.Head.func_78792_a(this.Feather);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  54 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/*  56 */     this.Head.func_78785_a(f5);
/*     */     
/*  58 */     this.Body.func_78785_a(f5);
/*  59 */     this.ArmR.func_78785_a(f5);
/*  60 */     this.ArmL.func_78785_a(f5);
/*  61 */     this.LegL.func_78785_a(f5);
/*  62 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
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
/* 119 */     this.Hair.field_78795_f = -0.15F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 120 */     if (0.0F > this.Hair.field_78795_f) this.Hair.field_78795_f *= -1.0F; 
/* 121 */     this.Hair.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 157 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\db\ModelUpa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */