/*     */ package JinRyuu.DragonBC.common.Npcs.dbtournament;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelTien
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer Eye;
/*     */   public ModelRenderer Head2;
/*     */   public ModelRenderer Cloth;
/*     */   
/*     */   public ModelTien() {
/*  21 */     this.field_78090_t = 64;
/*  22 */     this.field_78089_u = 32;
/*  23 */     this.Body = new ModelRenderer(this, 16, 16);
/*  24 */     this.Body.func_78793_a(0.0F, 0.0F, 0.0F);
/*  25 */     this.Body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
/*  26 */     this.Head = new ModelRenderer(this, 0, 0);
/*  27 */     this.Head.func_78793_a(0.0F, 0.0F, 0.0F);
/*  28 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
/*  29 */     this.ArmL = new ModelRenderer(this, 40, 16);
/*  30 */     this.ArmL.field_78809_i = true;
/*  31 */     this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
/*  32 */     this.ArmL.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
/*  33 */     this.Cloth = new ModelRenderer(this, 24, 0);
/*  34 */     this.Cloth.func_78793_a(2.5F, 9.8F, -2.0F);
/*  35 */     this.Cloth.func_78790_a(-1.5F, 0.0F, 0.0F, 3, 8, 0, 0.0F);
/*  36 */     setRotateAngle(this.Cloth, -0.045378562F, 0.0F, 0.0F);
/*  37 */     this.Head2 = new ModelRenderer(this, 0, 1);
/*  38 */     this.Head2.func_78793_a(0.0F, -7.8F, 0.4F);
/*  39 */     this.Head2.func_78790_a(-1.0F, -1.8F, -1.1F, 2, 2, 2, 0.0F);
/*  40 */     this.Eye = new ModelRenderer(this, 0, 0);
/*  41 */     this.Eye.func_78793_a(0.0F, -5.5F, -4.1F);
/*  42 */     this.Eye.func_78790_a(-1.5F, -0.5F, 0.0F, 3, 1, 0, 0.0F);
/*  43 */     this.ArmR = new ModelRenderer(this, 40, 16);
/*  44 */     this.ArmR.func_78793_a(-5.0F, 2.0F, 0.0F);
/*  45 */     this.ArmR.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
/*  46 */     this.LegR = new ModelRenderer(this, 0, 16);
/*  47 */     this.LegR.func_78793_a(-2.0F, 12.0F, 0.0F);
/*  48 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  49 */     this.LegL = new ModelRenderer(this, 0, 16);
/*  50 */     this.LegL.field_78809_i = true;
/*  51 */     this.LegL.func_78793_a(2.0F, 12.0F, 0.0F);
/*  52 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  53 */     this.Body.func_78792_a(this.Cloth);
/*  54 */     this.Head.func_78792_a(this.Head2);
/*  55 */     this.Head.func_78792_a(this.Eye);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  60 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/*  62 */     this.Head.func_78785_a(f5);
/*     */     
/*  64 */     this.Body.func_78785_a(f5);
/*  65 */     this.ArmR.func_78785_a(f5);
/*  66 */     this.ArmL.func_78785_a(f5);
/*  67 */     this.LegL.func_78785_a(f5);
/*  68 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/*  78 */     modelRenderer.field_78795_f = x;
/*  79 */     modelRenderer.field_78796_g = y;
/*  80 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/*  84 */     int calc = par7Entity.field_70173_aa;
/*  85 */     if (calc > 100) calc -= 100; 
/*  86 */     float r = 360.0F;
/*  87 */     float r2 = 180.0F;
/*  88 */     float n4 = par4;
/*  89 */     float n5 = par5;
/*     */     
/*  91 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/*  92 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/*  93 */     float ex = par7Entity.field_70173_aa;
/*  94 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/*  95 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/*  97 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/*  98 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 152 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 153 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 154 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 155 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 157 */     this.LegR.field_78796_g = 0.0F;
/* 158 */     this.LegL.field_78796_g = 0.0F;
/* 159 */     this.ArmR.field_78796_g = 0.0F;
/* 160 */     this.ArmL.field_78796_g = 0.0F;
/*     */     
/* 162 */     this.Cloth.field_78795_f = -0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbtournament\ModelTien.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */