/*     */ package JinRyuu.DragonBC.common.Npcs.dbbaba;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelMummy
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmR1;
/*     */   public ModelRenderer ArmL1;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer Body2;
/*     */   
/*     */   public ModelMummy() {
/*  20 */     this.field_78090_t = 128;
/*  21 */     this.field_78089_u = 64;
/*  22 */     this.Head = new ModelRenderer(this, 0, 0);
/*  23 */     this.Head.func_78793_a(0.0F, -4.5F, 0.6F);
/*  24 */     this.Head.func_78790_a(-4.0F, -8.1F, -4.0F, 8, 8, 8, 0.0F);
/*  25 */     this.Body1 = new ModelRenderer(this, 0, 17);
/*  26 */     this.Body1.func_78793_a(0.0F, -5.0F, 0.0F);
/*  27 */     this.Body1.func_78790_a(-7.5F, 0.0F, -2.4F, 15, 8, 8, 0.0F);
/*  28 */     this.ArmR1 = new ModelRenderer(this, 47, 1);
/*  29 */     this.ArmR1.func_78793_a(-8.8F, -3.0F, 1.7F);
/*  30 */     this.ArmR1.func_78790_a(-3.5F, -2.0F, -3.0F, 5, 15, 6, 0.0F);
/*  31 */     this.LegL = new ModelRenderer(this, 49, 23);
/*  32 */     this.LegL.field_78809_i = true;
/*  33 */     this.LegL.func_78793_a(3.6F, 10.0F, 1.5F);
/*  34 */     this.LegL.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 14, 6, 0.1F);
/*  35 */     this.Body2 = new ModelRenderer(this, 0, 34);
/*  36 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  37 */     this.Body2.func_78790_a(-6.5F, 8.0F, -2.2F, 13, 7, 7, 0.0F);
/*  38 */     this.ArmL1 = new ModelRenderer(this, 47, 1);
/*  39 */     this.ArmL1.field_78809_i = true;
/*  40 */     this.ArmL1.func_78793_a(8.8F, -3.0F, 1.7F);
/*  41 */     this.ArmL1.func_78790_a(-1.5F, -2.0F, -3.0F, 5, 15, 6, 0.0F);
/*  42 */     this.LegR = new ModelRenderer(this, 49, 23);
/*  43 */     this.LegR.func_78793_a(-3.6F, 10.0F, 1.5F);
/*  44 */     this.LegR.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 14, 6, 0.1F);
/*  45 */     this.Body1.func_78792_a(this.Body2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  50 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/*  52 */     this.Head.func_78785_a(f5);
/*     */     
/*  54 */     this.Body1.func_78785_a(f5);
/*  55 */     this.ArmR1.func_78785_a(f5);
/*  56 */     this.ArmL1.func_78785_a(f5);
/*  57 */     this.LegL.func_78785_a(f5);
/*  58 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/*  68 */     modelRenderer.field_78795_f = x;
/*  69 */     modelRenderer.field_78796_g = y;
/*  70 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/*  74 */     int calc = par7Entity.field_70173_aa;
/*  75 */     if (calc > 100) calc -= 100; 
/*  76 */     float r = 360.0F;
/*  77 */     float r2 = 180.0F;
/*  78 */     float n4 = par4;
/*  79 */     float n5 = par5;
/*     */     
/*  81 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/*  82 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/*  83 */     float ex = par7Entity.field_70173_aa;
/*  84 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/*  85 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/*  87 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/*  88 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 137 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 138 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 139 */     this.ArmR1.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 140 */     this.ArmL1.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 142 */     this.LegR.field_78796_g = 0.0F;
/* 143 */     this.LegL.field_78796_g = 0.0F;
/* 144 */     this.ArmR1.field_78796_g = 0.0F;
/* 145 */     this.ArmL1.field_78796_g = 0.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbbaba\ModelMummy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */