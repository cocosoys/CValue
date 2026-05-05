/*     */ package JinRyuu.DragonBC.common.Npcs.dbkingpiccolo;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelKingPiccolo
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer Head2;
/*     */   public ModelRenderer TentacleL;
/*     */   public ModelRenderer TentacleR;
/*     */   public ModelRenderer EarR;
/*     */   public ModelRenderer EarL;
/*     */   public ModelRenderer Head3;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer FeetL;
/*     */   public ModelRenderer FeetR;
/*     */   
/*     */   public ModelKingPiccolo() {
/*  28 */     this.field_78090_t = 128;
/*  29 */     this.field_78089_u = 64;
/*  30 */     this.FeetR = new ModelRenderer(this, 64, 41);
/*  31 */     this.FeetR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  32 */     this.FeetR.func_78790_a(-2.0F, 14.0F, -3.3F, 4, 2, 5, 0.0F);
/*  33 */     this.EarL = new ModelRenderer(this, 34, 1);
/*  34 */     this.EarL.field_78809_i = true;
/*  35 */     this.EarL.func_78793_a(3.8F, -4.5F, -1.0F);
/*  36 */     this.EarL.func_78790_a(0.0F, -3.5F, 0.0F, 3, 6, 0, 0.0F);
/*  37 */     setRotateAngle(this.EarL, 0.0F, -0.87266463F, 0.04363323F);
/*  38 */     this.Body = new ModelRenderer(this, 1, 24);
/*  39 */     this.Body.func_78793_a(0.0F, -7.0F, 0.0F);
/*  40 */     this.Body.func_78790_a(-5.0F, 0.0F, -3.0F, 10, 9, 6, 0.0F);
/*  41 */     this.ArmR = new ModelRenderer(this, 41, 19);
/*  42 */     this.ArmR.func_78793_a(-6.0F, -4.9F, 0.0F);
/*  43 */     this.ArmR.func_78790_a(-3.0F, -2.0F, -2.5F, 4, 15, 5, 0.0F);
/*  44 */     this.ArmL = new ModelRenderer(this, 41, 19);
/*  45 */     this.ArmL.field_78809_i = true;
/*  46 */     this.ArmL.func_78793_a(6.0F, -4.9F, 0.0F);
/*  47 */     this.ArmL.func_78790_a(-1.0F, -2.0F, -2.5F, 4, 15, 5, 0.0F);
/*  48 */     this.Body3 = new ModelRenderer(this, 1, 50);
/*  49 */     this.Body3.func_78793_a(0.0F, 11.0F, 0.0F);
/*  50 */     this.Body3.func_78790_a(-5.0F, 0.0F, -3.0F, 10, 4, 6, 0.0F);
/*  51 */     this.EarR = new ModelRenderer(this, 34, 1);
/*  52 */     this.EarR.func_78793_a(-3.5F, -4.5F, -1.0F);
/*  53 */     this.EarR.func_78790_a(-3.5F, -3.5F, 0.0F, 3, 6, 0, 0.0F);
/*  54 */     setRotateAngle(this.EarR, 0.0F, 0.87266463F, -0.04363323F);
/*  55 */     this.TentacleR = new ModelRenderer(this, 25, -1);
/*  56 */     this.TentacleR.func_78793_a(-1.5F, -6.0F, -4.0F);
/*  57 */     this.TentacleR.func_78790_a(0.0F, -2.0F, -4.0F, 0, 4, 4, 0.0F);
/*  58 */     setRotateAngle(this.TentacleR, 0.0F, 0.6981317F, 0.0F);
/*  59 */     this.FeetL = new ModelRenderer(this, 64, 41);
/*  60 */     this.FeetL.field_78809_i = true;
/*  61 */     this.FeetL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  62 */     this.FeetL.func_78790_a(-2.0F, 14.0F, -3.3F, 4, 2, 5, 0.0F);
/*  63 */     this.TentacleL = new ModelRenderer(this, 25, -1);
/*  64 */     this.TentacleL.field_78809_i = true;
/*  65 */     this.TentacleL.func_78793_a(1.5F, -6.0F, -4.0F);
/*  66 */     this.TentacleL.func_78790_a(0.0F, -2.0F, -4.0F, 0, 4, 4, 0.0F);
/*  67 */     setRotateAngle(this.TentacleL, 0.0F, -0.6981317F, 0.0F);
/*  68 */     this.LegL = new ModelRenderer(this, 40, 40);
/*  69 */     this.LegL.field_78809_i = true;
/*  70 */     this.LegL.func_78793_a(2.5F, 8.0F, 0.0F);
/*  71 */     this.LegL.func_78790_a(-2.5F, 0.0F, -3.0F, 5, 14, 6, 0.0F);
/*  72 */     this.Body2 = new ModelRenderer(this, 1, 41);
/*  73 */     this.Body2.func_78793_a(0.0F, 9.5F, 0.0F);
/*  74 */     this.Body2.func_78790_a(-4.5F, -0.5F, -2.5F, 9, 2, 5, 0.0F);
/*  75 */     this.LegR = new ModelRenderer(this, 40, 40);
/*  76 */     this.LegR.func_78793_a(-2.5F, 8.0F, 0.0F);
/*  77 */     this.LegR.func_78790_a(-2.5F, 0.0F, -3.0F, 5, 14, 6, 0.0F);
/*  78 */     this.Head = new ModelRenderer(this, 0, 0);
/*  79 */     this.Head.func_78793_a(0.0F, -7.0F, 0.0F);
/*  80 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
/*  81 */     this.Head3 = new ModelRenderer(this, 66, 1);
/*  82 */     this.Head3.func_78793_a(0.0F, -0.6F, 0.5F);
/*  83 */     this.Head3.func_78790_a(-3.0F, -3.0F, -3.0F, 6, 6, 7, 0.0F);
/*  84 */     this.Head2 = new ModelRenderer(this, 33, 1);
/*  85 */     this.Head2.func_78793_a(0.0F, -5.8F, 1.7F);
/*  86 */     this.Head2.func_78790_a(-3.5F, -3.0F, -5.0F, 7, 8, 9, 0.0F);
/*  87 */     this.LegR.func_78792_a(this.FeetR);
/*  88 */     this.Head.func_78792_a(this.EarL);
/*  89 */     this.Body.func_78792_a(this.Body3);
/*  90 */     this.Head.func_78792_a(this.EarR);
/*  91 */     this.Head.func_78792_a(this.TentacleR);
/*  92 */     this.LegL.func_78792_a(this.FeetL);
/*  93 */     this.Head.func_78792_a(this.TentacleL);
/*  94 */     this.Body.func_78792_a(this.Body2);
/*  95 */     this.Head2.func_78792_a(this.Head3);
/*  96 */     this.Head.func_78792_a(this.Head2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 101 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 103 */     this.Head.func_78785_a(f5);
/*     */     
/* 105 */     this.Body.func_78785_a(f5);
/* 106 */     this.ArmR.func_78785_a(f5);
/* 107 */     this.ArmL.func_78785_a(f5);
/* 108 */     this.LegL.func_78785_a(f5);
/* 109 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 119 */     modelRenderer.field_78795_f = x;
/* 120 */     modelRenderer.field_78796_g = y;
/* 121 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 125 */     int calc = par7Entity.field_70173_aa;
/* 126 */     if (calc > 100) calc -= 100; 
/* 127 */     float r = 360.0F;
/* 128 */     float r2 = 180.0F;
/* 129 */     float n4 = par4;
/* 130 */     float n5 = par5;
/*     */     
/* 132 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 133 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 134 */     float ex = par7Entity.field_70173_aa;
/* 135 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 136 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 138 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 139 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 188 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 189 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 190 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 191 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 193 */     this.LegR.field_78796_g = 0.0F;
/* 194 */     this.LegL.field_78796_g = 0.0F;
/* 195 */     this.ArmR.field_78796_g = 0.0F;
/* 196 */     this.ArmL.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 204 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbkingpiccolo\ModelKingPiccolo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */