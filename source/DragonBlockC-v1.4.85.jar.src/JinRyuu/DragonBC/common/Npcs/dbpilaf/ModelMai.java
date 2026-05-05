/*     */ package JinRyuu.DragonBC.common.Npcs.dbpilaf;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelMai
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer Hair;
/*     */   
/*     */   public ModelMai() {
/*  19 */     this.field_78090_t = 64;
/*  20 */     this.field_78089_u = 64;
/*  21 */     this.ArmR = new ModelRenderer(this, 17, 34);
/*  22 */     this.ArmR.func_78793_a(-5.0F, 2.0F, 0.0F);
/*  23 */     this.ArmR.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
/*  24 */     this.LegL = new ModelRenderer(this, 0, 34);
/*  25 */     this.LegL.field_78809_i = true;
/*  26 */     this.LegL.func_78793_a(1.9F, 12.0F, 0.0F);
/*  27 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  28 */     this.Head = new ModelRenderer(this, 0, 0);
/*  29 */     this.Head.func_78793_a(0.0F, 0.0F, 0.0F);
/*  30 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
/*  31 */     this.LegR = new ModelRenderer(this, 0, 34);
/*  32 */     this.LegR.func_78793_a(-1.9F, 12.0F, 0.0F);
/*  33 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  34 */     this.Body = new ModelRenderer(this, 0, 17);
/*  35 */     this.Body.func_78793_a(0.0F, 0.0F, 0.0F);
/*  36 */     this.Body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
/*  37 */     this.ArmL = new ModelRenderer(this, 17, 34);
/*  38 */     this.ArmL.field_78809_i = true;
/*  39 */     this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
/*  40 */     this.ArmL.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
/*  41 */     this.Hair = new ModelRenderer(this, 32, 0);
/*  42 */     this.Hair.func_78793_a(0.0F, 0.0F, 4.0F);
/*  43 */     this.Hair.func_78790_a(-4.0F, 0.0F, 0.0F, 8, 6, 0, 0.0F);
/*  44 */     this.Head.func_78792_a(this.Hair);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  49 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/*  51 */     this.Body.func_78785_a(f5);
/*  52 */     this.ArmR.func_78785_a(f5);
/*  53 */     this.ArmL.func_78785_a(f5);
/*  54 */     this.LegL.func_78785_a(f5);
/*  55 */     this.Head.func_78785_a(f5);
/*  56 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/*  62 */     modelRenderer.field_78795_f = x;
/*  63 */     modelRenderer.field_78796_g = y;
/*  64 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/*  68 */     int calc = par7Entity.field_70173_aa;
/*  69 */     if (calc > 100) calc -= 100; 
/*  70 */     float r = 360.0F;
/*  71 */     float r2 = 180.0F;
/*  72 */     float n4 = par4;
/*  73 */     float n5 = par5;
/*     */     
/*  75 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/*  76 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/*  77 */     float ex = par7Entity.field_70173_aa;
/*  78 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/*  79 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/*  81 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/*  82 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 131 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 132 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 133 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 134 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 136 */     this.LegR.field_78796_g = 0.0F;
/* 137 */     this.LegL.field_78796_g = 0.0F;
/* 138 */     this.ArmR.field_78796_g = 0.0F;
/* 139 */     this.ArmL.field_78796_g = 0.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbpilaf\ModelMai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */