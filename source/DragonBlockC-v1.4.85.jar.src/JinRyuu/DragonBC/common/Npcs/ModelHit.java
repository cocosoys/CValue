/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelHit
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer NeckGuard1;
/*     */   public ModelRenderer Chest;
/*     */   public ModelRenderer LowerCoatSideL;
/*     */   public ModelRenderer LowerCoatBackL;
/*     */   public ModelRenderer LowerCoatSideR;
/*     */   public ModelRenderer LowerCoatBackR;
/*     */   
/*     */   public ModelHit() {
/*  24 */     this.field_78090_t = 64;
/*  25 */     this.field_78089_u = 64;
/*  26 */     this.NeckGuard1 = new ModelRenderer(this, 34, 6);
/*  27 */     this.NeckGuard1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  28 */     this.NeckGuard1.func_78790_a(-3.5F, -0.8F, -2.6F, 7, 2, 6, 0.0F);
/*  29 */     setRotateAngle(this.NeckGuard1, 0.27314404F, 0.0F, 0.0F);
/*  30 */     this.LowerCoatBackR = new ModelRenderer(this, 23, 38);
/*  31 */     this.LowerCoatBackR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  32 */     this.LowerCoatBackR.func_78790_a(0.6F, -0.2F, 1.5F, 1, 7, 1, 0.0F);
/*  33 */     this.Head = new ModelRenderer(this, 0, 0);
/*  34 */     this.Head.func_78793_a(0.0F, -0.5F, 0.0F);
/*  35 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
/*  36 */     this.LowerCoatSideR = new ModelRenderer(this, 3, 33);
/*  37 */     this.LowerCoatSideR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  38 */     this.LowerCoatSideR.func_78790_a(-2.4F, -0.2F, -2.4F, 3, 9, 5, 0.0F);
/*  39 */     this.LegR = new ModelRenderer(this, 0, 16);
/*  40 */     this.LegR.func_78793_a(-1.9F, 12.0F, 0.0F);
/*  41 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  42 */     this.Body = new ModelRenderer(this, 16, 16);
/*  43 */     this.Body.func_78793_a(0.0F, 0.0F, 0.0F);
/*  44 */     this.Body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
/*  45 */     this.LowerCoatBackL = new ModelRenderer(this, 23, 38);
/*  46 */     this.LowerCoatBackL.field_78809_i = true;
/*  47 */     this.LowerCoatBackL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  48 */     this.LowerCoatBackL.func_78790_a(-1.4F, -0.2F, 1.5F, 1, 7, 1, 0.0F);
/*  49 */     this.ArmR = new ModelRenderer(this, 40, 16);
/*  50 */     this.ArmR.func_78793_a(-5.0F, 2.0F, 0.0F);
/*  51 */     this.ArmR.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
/*  52 */     this.LegL = new ModelRenderer(this, 0, 16);
/*  53 */     this.LegL.field_78809_i = true;
/*  54 */     this.LegL.func_78793_a(1.9F, 12.0F, 0.0F);
/*  55 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  56 */     this.ArmL = new ModelRenderer(this, 40, 16);
/*  57 */     this.ArmL.field_78809_i = true;
/*  58 */     this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
/*  59 */     this.ArmL.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
/*  60 */     this.LowerCoatSideL = new ModelRenderer(this, 3, 33);
/*  61 */     this.LowerCoatSideL.field_78809_i = true;
/*  62 */     this.LowerCoatSideL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  63 */     this.LowerCoatSideL.func_78790_a(-0.5F, -0.2F, -2.4F, 3, 9, 5, 0.0F);
/*  64 */     this.Chest = new ModelRenderer(this, 19, 33);
/*  65 */     this.Chest.func_78793_a(0.0F, 0.0F, 0.0F);
/*  66 */     this.Chest.func_78790_a(-3.5F, 1.1F, -2.5F, 7, 3, 1, 0.0F);
/*  67 */     this.Body.func_78792_a(this.NeckGuard1);
/*  68 */     this.LegR.func_78792_a(this.LowerCoatBackR);
/*  69 */     this.LegR.func_78792_a(this.LowerCoatSideR);
/*  70 */     this.LegL.func_78792_a(this.LowerCoatBackL);
/*  71 */     this.LegL.func_78792_a(this.LowerCoatSideL);
/*  72 */     this.Body.func_78792_a(this.Chest);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  77 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/*  80 */     this.LegL.func_78785_a(f5);
/*  81 */     this.Head.func_78785_a(f5);
/*  82 */     this.ArmL.func_78785_a(f5);
/*  83 */     this.ArmR.func_78785_a(f5);
/*  84 */     this.Body.func_78785_a(f5);
/*  85 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/*  90 */     modelRenderer.field_78795_f = x;
/*  91 */     modelRenderer.field_78796_g = y;
/*  92 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/*  96 */     int calc = par7Entity.field_70173_aa;
/*  97 */     if (calc > 100) calc -= 100; 
/*  98 */     float r = 360.0F;
/*  99 */     float r2 = 180.0F;
/* 100 */     float n4 = par4;
/* 101 */     float n5 = par5;
/*     */     
/* 103 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 104 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 105 */     float ex = par7Entity.field_70173_aa;
/* 106 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 107 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 135 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 136 */     this.LegL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 137 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 138 */     this.ArmL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 139 */     this.LegR.field_78796_g = 0.0F;
/* 140 */     this.LegL.field_78796_g = 0.0F;
/* 141 */     this.ArmR.field_78796_g = 0.0F;
/* 142 */     this.ArmL.field_78796_g = 0.0F;
/* 143 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelHit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */