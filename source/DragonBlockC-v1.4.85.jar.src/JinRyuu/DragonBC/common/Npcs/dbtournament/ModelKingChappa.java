/*     */ package JinRyuu.DragonBC.common.Npcs.dbtournament;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelKingChappa
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
/*     */   public ModelRenderer Cloth;
/*     */   
/*     */   public ModelKingChappa() {
/*  22 */     this.field_78090_t = 64;
/*  23 */     this.field_78089_u = 64;
/*  24 */     this.ArmR = new ModelRenderer(this, 40, 16);
/*  25 */     this.ArmR.func_78793_a(-5.0F, 2.0F, 0.0F);
/*  26 */     this.ArmR.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
/*  27 */     this.Hair1 = new ModelRenderer(this, 35, 51);
/*  28 */     this.Hair1.func_78793_a(0.0F, -6.3F, 1.7F);
/*  29 */     this.Hair1.func_78790_a(-4.5F, -2.5F, -1.9F, 9, 7, 5, 0.0F);
/*  30 */     this.LegR = new ModelRenderer(this, 0, 16);
/*  31 */     this.LegR.func_78793_a(-1.9F, 12.0F, 0.0F);
/*  32 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  33 */     this.Hair2 = new ModelRenderer(this, 43, 43);
/*  34 */     this.Hair2.func_78793_a(0.0F, -6.5F, -0.6F);
/*  35 */     this.Hair2.func_78790_a(-2.5F, -2.7F, -3.6F, 5, 3, 5, 0.0F);
/*  36 */     this.LegL = new ModelRenderer(this, 0, 16);
/*  37 */     this.LegL.field_78809_i = true;
/*  38 */     this.LegL.func_78793_a(1.9F, 12.0F, 0.0F);
/*  39 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  40 */     this.Head = new ModelRenderer(this, 0, 0);
/*  41 */     this.Head.func_78793_a(0.0F, 0.0F, 0.0F);
/*  42 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
/*  43 */     this.Body = new ModelRenderer(this, 16, 16);
/*  44 */     this.Body.func_78793_a(0.0F, 0.0F, 0.0F);
/*  45 */     this.Body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
/*  46 */     this.ArmL = new ModelRenderer(this, 40, 16);
/*  47 */     this.ArmL.field_78809_i = true;
/*  48 */     this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
/*  49 */     this.ArmL.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
/*  50 */     this.Cloth = new ModelRenderer(this, 1, 49);
/*  51 */     this.Cloth.func_78793_a(0.0F, 9.0F, 0.4F);
/*  52 */     this.Cloth.func_78790_a(-4.5F, 0.0F, -2.3F, 9, 10, 4, 0.0F);
/*  53 */     this.Head.func_78792_a(this.Hair1);
/*  54 */     this.Head.func_78792_a(this.Hair2);
/*  55 */     this.Body.func_78792_a(this.Cloth);
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
/* 147 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 148 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 149 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 150 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 152 */     this.LegR.field_78796_g = 0.0F;
/* 153 */     this.LegL.field_78796_g = 0.0F;
/* 154 */     this.ArmR.field_78796_g = 0.0F;
/* 155 */     this.ArmL.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */     
/* 159 */     this.Cloth.field_78795_f = 0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 160 */     this.Cloth.field_78795_f = 0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 161 */     this.Cloth.field_78795_f = 0.15F + this.LegL.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 162 */     this.Cloth.field_78795_f = 0.15F + this.LegL.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 163 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbtournament\ModelKingChappa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */