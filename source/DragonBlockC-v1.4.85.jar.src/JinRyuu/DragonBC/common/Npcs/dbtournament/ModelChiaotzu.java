/*     */ package JinRyuu.DragonBC.common.Npcs.dbtournament;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelChiaotzu
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer Head_1;
/*     */   
/*     */   public ModelChiaotzu() {
/*  19 */     this.field_78090_t = 64;
/*  20 */     this.field_78089_u = 64;
/*  21 */     this.Head = new ModelRenderer(this, 0, 0);
/*  22 */     this.Head.func_78793_a(0.0F, 7.2F, 0.0F);
/*  23 */     this.Head.func_78790_a(-4.0F, -8.1F, -3.6F, 8, 8, 7, 0.0F);
/*  24 */     this.Body = new ModelRenderer(this, 1, 15);
/*  25 */     this.Body.func_78793_a(0.0F, 7.1F, 0.0F);
/*  26 */     this.Body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 9, 4, 0.0F);
/*  27 */     this.ArmR = new ModelRenderer(this, 17, 33);
/*  28 */     this.ArmR.func_78793_a(-5.0F, 8.0F, 0.0F);
/*  29 */     this.ArmR.func_78790_a(-2.0F, -0.6F, -1.4F, 3, 8, 3, 0.2F);
/*  30 */     this.LegL = new ModelRenderer(this, 0, 33);
/*  31 */     this.LegL.field_78809_i = true;
/*  32 */     this.LegL.func_78793_a(2.0F, 16.5F, 0.0F);
/*  33 */     this.LegL.func_78790_a(-2.1F, -0.4F, -2.0F, 4, 8, 4, 0.0F);
/*  34 */     this.LegR = new ModelRenderer(this, 0, 33);
/*  35 */     this.LegR.func_78793_a(-2.0F, 16.5F, 0.0F);
/*  36 */     this.LegR.func_78790_a(-1.9F, -0.4F, -2.0F, 4, 8, 4, 0.0F);
/*  37 */     this.Head_1 = new ModelRenderer(this, 35, 0);
/*  38 */     this.Head_1.func_78793_a(0.0F, -7.8F, 0.4F);
/*  39 */     this.Head_1.func_78790_a(-1.0F, -1.8F, -1.1F, 2, 2, 2, 0.0F);
/*  40 */     this.ArmL = new ModelRenderer(this, 17, 33);
/*  41 */     this.ArmL.field_78809_i = true;
/*  42 */     this.ArmL.func_78793_a(5.0F, 8.0F, 0.0F);
/*  43 */     this.ArmL.func_78790_a(-1.0F, -0.6F, -1.5F, 3, 8, 3, 0.2F);
/*  44 */     this.Head.func_78792_a(this.Head_1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  49 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/*  51 */     this.Head.func_78785_a(f5);
/*     */     
/*  53 */     this.Body.func_78785_a(f5);
/*  54 */     this.ArmR.func_78785_a(f5);
/*  55 */     this.ArmL.func_78785_a(f5);
/*  56 */     this.LegL.func_78785_a(f5);
/*  57 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/*  67 */     modelRenderer.field_78795_f = x;
/*  68 */     modelRenderer.field_78796_g = y;
/*  69 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/*  73 */     int calc = par7Entity.field_70173_aa;
/*  74 */     if (calc > 100) calc -= 100; 
/*  75 */     float r = 360.0F;
/*  76 */     float r2 = 180.0F;
/*  77 */     float n4 = par4;
/*  78 */     float n5 = par5;
/*     */     
/*  80 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/*  81 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/*  82 */     float ex = par7Entity.field_70173_aa;
/*  83 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/*  84 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/*  86 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/*  87 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 136 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 137 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 138 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 139 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 141 */     this.LegR.field_78796_g = 0.0F;
/* 142 */     this.LegL.field_78796_g = 0.0F;
/* 143 */     this.ArmR.field_78796_g = 0.0F;
/* 144 */     this.ArmL.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 152 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbtournament\ModelChiaotzu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */