/*     */ package JinRyuu.DragonBC.common.Npcs.dbtournament;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelChiaotzu2
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer Head_1;
/*     */   public ModelRenderer CapeBase;
/*     */   public ModelRenderer Cape;
/*     */   
/*     */   public ModelChiaotzu2() {
/*  21 */     this.field_78090_t = 64;
/*  22 */     this.field_78089_u = 64;
/*  23 */     this.ArmL = new ModelRenderer(this, 17, 33);
/*  24 */     this.ArmL.field_78809_i = true;
/*  25 */     this.ArmL.func_78793_a(5.0F, 8.0F, 0.0F);
/*  26 */     this.ArmL.func_78790_a(-1.0F, -0.8F, -1.5F, 3, 8, 3, 0.2F);
/*  27 */     this.Cape = new ModelRenderer(this, 1, 46);
/*  28 */     this.Cape.func_78793_a(0.0F, 1.3F, 2.3F);
/*  29 */     this.Cape.func_78790_a(-4.0F, 0.0F, 0.0F, 8, 10, 0, 0.0F);
/*  30 */     this.ArmR = new ModelRenderer(this, 17, 33);
/*  31 */     this.ArmR.func_78793_a(-5.0F, 8.0F, 0.0F);
/*  32 */     this.ArmR.func_78790_a(-2.0F, -0.8F, -1.4F, 3, 8, 3, 0.2F);
/*  33 */     this.Body = new ModelRenderer(this, 1, 15);
/*  34 */     this.Body.func_78793_a(0.0F, 7.1F, 0.0F);
/*  35 */     this.Body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 9, 4, 0.0F);
/*  36 */     this.LegR = new ModelRenderer(this, 0, 33);
/*  37 */     this.LegR.func_78793_a(-2.0F, 16.5F, 0.0F);
/*  38 */     this.LegR.func_78790_a(-1.9F, -0.4F, -2.0F, 4, 8, 4, 0.0F);
/*  39 */     this.Head = new ModelRenderer(this, 0, 0);
/*  40 */     this.Head.func_78793_a(0.0F, 7.2F, 0.0F);
/*  41 */     this.Head.func_78790_a(-4.0F, -8.1F, -3.6F, 8, 8, 7, 0.0F);
/*  42 */     this.Head_1 = new ModelRenderer(this, 35, 0);
/*  43 */     this.Head_1.func_78793_a(0.0F, -7.8F, 0.4F);
/*  44 */     this.Head_1.func_78790_a(-1.0F, -1.8F, -1.1F, 2, 2, 2, 0.0F);
/*  45 */     this.LegL = new ModelRenderer(this, 0, 33);
/*  46 */     this.LegL.field_78809_i = true;
/*  47 */     this.LegL.func_78793_a(2.0F, 16.5F, 0.0F);
/*  48 */     this.LegL.func_78790_a(-2.1F, -0.4F, -2.0F, 4, 8, 4, 0.0F);
/*  49 */     this.CapeBase = new ModelRenderer(this, 19, 55);
/*  50 */     this.CapeBase.func_78793_a(0.0F, 0.0F, 0.0F);
/*  51 */     this.CapeBase.func_78790_a(-3.5F, -0.6F, -2.5F, 7, 2, 5, 0.0F);
/*  52 */     this.CapeBase.func_78792_a(this.Cape);
/*  53 */     this.Head.func_78792_a(this.Head_1);
/*  54 */     this.Body.func_78792_a(this.CapeBase);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  59 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/*  61 */     this.Head.func_78785_a(f5);
/*     */     
/*  63 */     this.Body.func_78785_a(f5);
/*  64 */     this.ArmR.func_78785_a(f5);
/*  65 */     this.ArmL.func_78785_a(f5);
/*  66 */     this.LegL.func_78785_a(f5);
/*  67 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/*  77 */     modelRenderer.field_78795_f = x;
/*  78 */     modelRenderer.field_78796_g = y;
/*  79 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/*  83 */     int calc = par7Entity.field_70173_aa;
/*  84 */     if (calc > 100) calc -= 100; 
/*  85 */     float r = 360.0F;
/*  86 */     float r2 = 180.0F;
/*  87 */     float n4 = par4;
/*  88 */     float n5 = par5;
/*     */     
/*  90 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/*  91 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/*  92 */     float ex = par7Entity.field_70173_aa;
/*  93 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/*  94 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/*  96 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/*  97 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 138 */     this.Cape.field_78795_f = -0.15F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 139 */     if (0.0F > this.Cape.field_78795_f) this.Cape.field_78795_f *= -1.0F; 
/* 140 */     this.Cape.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 151 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 152 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 153 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 154 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 156 */     this.LegR.field_78796_g = 0.0F;
/* 157 */     this.LegL.field_78796_g = 0.0F;
/* 158 */     this.ArmR.field_78796_g = 0.0F;
/* 159 */     this.ArmL.field_78796_g = 0.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbtournament\ModelChiaotzu2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */