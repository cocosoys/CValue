/*     */ package JinRyuu.DragonBC.common.Npcs.dbredribbon;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelOfficerBlack
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer RedRibbon;
/*     */   public ModelRenderer Cloth1;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Tie;
/*     */   public ModelRenderer ArmL2;
/*     */   public ModelRenderer ArmR2;
/*     */   
/*     */   public ModelOfficerBlack() {
/*  24 */     this.field_78090_t = 64;
/*  25 */     this.field_78089_u = 64;
/*  26 */     this.LegR = new ModelRenderer(this, 0, 35);
/*  27 */     this.LegR.func_78793_a(-2.0F, 12.0F, 0.0F);
/*  28 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  29 */     this.RedRibbon = new ModelRenderer(this, 24, 0);
/*  30 */     this.RedRibbon.func_78793_a(2.4F, 3.9F, -2.2F);
/*  31 */     this.RedRibbon.func_78790_a(-1.5F, 0.0F, 0.0F, 3, 3, 0, 0.0F);
/*  32 */     setRotateAngle(this.RedRibbon, -0.061086524F, 0.0F, 0.0F);
/*  33 */     this.Body2 = new ModelRenderer(this, 25, 17);
/*  34 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  35 */     this.Body2.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
/*  36 */     this.LegL = new ModelRenderer(this, 0, 35);
/*  37 */     this.LegL.field_78809_i = true;
/*  38 */     this.LegL.func_78793_a(2.0F, 12.0F, 0.0F);
/*  39 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  40 */     this.ArmR2 = new ModelRenderer(this, 17, 35);
/*  41 */     this.ArmR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  42 */     this.ArmR2.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
/*  43 */     this.Tie = new ModelRenderer(this, 1, 0);
/*  44 */     this.Tie.func_78793_a(0.0F, 0.0F, -2.2F);
/*  45 */     this.Tie.func_78790_a(-1.0F, 0.0F, 0.0F, 2, 7, 0, 0.0F);
/*  46 */     setRotateAngle(this.Tie, -0.012217305F, 0.0F, 0.0F);
/*  47 */     this.ArmL = new ModelRenderer(this, 34, 35);
/*  48 */     this.ArmL.field_78809_i = true;
/*  49 */     this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
/*  50 */     this.ArmL.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 9, 4, 0.1F);
/*  51 */     this.Head = new ModelRenderer(this, 0, 0);
/*  52 */     this.Head.func_78793_a(0.0F, 0.0F, 0.0F);
/*  53 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
/*  54 */     this.ArmL2 = new ModelRenderer(this, 17, 35);
/*  55 */     this.ArmL2.field_78809_i = true;
/*  56 */     this.ArmL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  57 */     this.ArmL2.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
/*  58 */     this.ArmR = new ModelRenderer(this, 34, 35);
/*  59 */     this.ArmR.func_78793_a(-5.0F, 2.0F, 0.0F);
/*  60 */     this.ArmR.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 9, 4, 0.1F);
/*  61 */     this.Cloth1 = new ModelRenderer(this, 1, 52);
/*  62 */     this.Cloth1.func_78793_a(0.0F, 10.3F, 0.6F);
/*  63 */     this.Cloth1.func_78790_a(-4.5F, 0.0F, -2.2F, 9, 7, 4, 0.0F);
/*  64 */     setRotateAngle(this.Cloth1, 0.045553092F, 0.0F, 0.0F);
/*  65 */     this.Body = new ModelRenderer(this, 0, 17);
/*  66 */     this.Body.func_78793_a(0.0F, 0.0F, 0.0F);
/*  67 */     this.Body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.1F);
/*  68 */     this.Body.func_78792_a(this.RedRibbon);
/*  69 */     this.Body.func_78792_a(this.Body2);
/*  70 */     this.ArmR.func_78792_a(this.ArmR2);
/*  71 */     this.Body2.func_78792_a(this.Tie);
/*  72 */     this.ArmL.func_78792_a(this.ArmL2);
/*  73 */     this.Body.func_78792_a(this.Cloth1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  78 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/*  80 */     this.Head.func_78785_a(f5);
/*     */     
/*  82 */     this.Body.func_78785_a(f5);
/*  83 */     this.ArmR.func_78785_a(f5);
/*  84 */     this.ArmL.func_78785_a(f5);
/*  85 */     this.LegL.func_78785_a(f5);
/*  86 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/*  96 */     modelRenderer.field_78795_f = x;
/*  97 */     modelRenderer.field_78796_g = y;
/*  98 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 102 */     int calc = par7Entity.field_70173_aa;
/* 103 */     if (calc > 100) calc -= 100; 
/* 104 */     float r = 360.0F;
/* 105 */     float r2 = 180.0F;
/* 106 */     float n4 = par4;
/* 107 */     float n5 = par5;
/*     */     
/* 109 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 110 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 111 */     float ex = par7Entity.field_70173_aa;
/* 112 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 113 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 115 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 116 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 165 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 166 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 167 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 168 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 170 */     this.LegR.field_78796_g = 0.0F;
/* 171 */     this.LegL.field_78796_g = 0.0F;
/* 172 */     this.ArmR.field_78796_g = 0.0F;
/* 173 */     this.ArmL.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */     
/* 177 */     this.Cloth1.field_78795_f = 0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 178 */     this.Cloth1.field_78795_f = 0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 179 */     this.Cloth1.field_78795_f = 0.15F + this.LegL.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 180 */     this.Cloth1.field_78795_f = 0.15F + this.LegL.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 181 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbredribbon\ModelOfficerBlack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */