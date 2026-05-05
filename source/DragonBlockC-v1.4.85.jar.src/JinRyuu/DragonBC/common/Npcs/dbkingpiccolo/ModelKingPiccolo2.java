/*     */ package JinRyuu.DragonBC.common.Npcs.dbkingpiccolo;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelKingPiccolo2
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
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer FeetL;
/*     */   public ModelRenderer FeetR;
/*     */   
/*     */   public ModelKingPiccolo2() {
/*  27 */     this.field_78090_t = 128;
/*  28 */     this.field_78089_u = 64;
/*  29 */     this.TentacleL = new ModelRenderer(this, 25, -1);
/*  30 */     this.TentacleL.field_78809_i = true;
/*  31 */     this.TentacleL.func_78793_a(1.5F, -5.5F, -4.0F);
/*  32 */     this.TentacleL.func_78790_a(0.0F, -2.0F, -4.0F, 0, 4, 4, 0.0F);
/*  33 */     setRotateAngle(this.TentacleL, 0.0F, -0.6981317F, 0.0F);
/*  34 */     this.Head = new ModelRenderer(this, 0, 0);
/*  35 */     this.Head.func_78793_a(0.0F, -7.0F, 0.0F);
/*  36 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
/*  37 */     this.TentacleR = new ModelRenderer(this, 25, -1);
/*  38 */     this.TentacleR.func_78793_a(-1.5F, -5.5F, -4.0F);
/*  39 */     this.TentacleR.func_78790_a(0.0F, -2.0F, -4.0F, 0, 4, 4, 0.0F);
/*  40 */     setRotateAngle(this.TentacleR, 0.0F, 0.6981317F, 0.0F);
/*  41 */     this.Body2 = new ModelRenderer(this, 1, 41);
/*  42 */     this.Body2.func_78793_a(0.0F, 9.5F, 0.0F);
/*  43 */     this.Body2.func_78790_a(-4.5F, -0.5F, -2.5F, 9, 2, 5, 0.0F);
/*  44 */     this.LegL = new ModelRenderer(this, 40, 40);
/*  45 */     this.LegL.field_78809_i = true;
/*  46 */     this.LegL.func_78793_a(2.5F, 8.0F, 0.0F);
/*  47 */     this.LegL.func_78790_a(-2.5F, 0.0F, -3.0F, 5, 14, 6, 0.0F);
/*  48 */     this.LegR = new ModelRenderer(this, 40, 40);
/*  49 */     this.LegR.func_78793_a(-2.5F, 8.0F, 0.0F);
/*  50 */     this.LegR.func_78790_a(-2.5F, 0.0F, -3.0F, 5, 14, 6, 0.0F);
/*  51 */     this.FeetR = new ModelRenderer(this, 64, 41);
/*  52 */     this.FeetR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  53 */     this.FeetR.func_78790_a(-2.0F, 14.0F, -3.3F, 4, 2, 5, 0.0F);
/*  54 */     this.EarL = new ModelRenderer(this, 34, 1);
/*  55 */     this.EarL.field_78809_i = true;
/*  56 */     this.EarL.func_78793_a(3.8F, -4.5F, -1.0F);
/*  57 */     this.EarL.func_78790_a(0.0F, -3.5F, 0.0F, 3, 6, 0, 0.0F);
/*  58 */     setRotateAngle(this.EarL, 0.0F, -0.87266463F, 0.04363323F);
/*  59 */     this.Body3 = new ModelRenderer(this, 1, 50);
/*  60 */     this.Body3.func_78793_a(0.0F, 11.0F, 0.0F);
/*  61 */     this.Body3.func_78790_a(-5.0F, 0.0F, -3.0F, 10, 4, 6, 0.0F);
/*  62 */     this.ArmL = new ModelRenderer(this, 41, 19);
/*  63 */     this.ArmL.field_78809_i = true;
/*  64 */     this.ArmL.func_78793_a(5.8F, -5.1F, 0.0F);
/*  65 */     this.ArmL.func_78790_a(-1.0F, -2.0F, -2.5F, 5, 15, 5, -0.1F);
/*  66 */     this.Head2 = new ModelRenderer(this, 33, 1);
/*  67 */     this.Head2.func_78793_a(0.0F, -5.6F, 1.7F);
/*  68 */     this.Head2.func_78790_a(-3.5F, -3.0F, -5.0F, 7, 8, 8, 0.0F);
/*  69 */     this.EarR = new ModelRenderer(this, 34, 1);
/*  70 */     this.EarR.func_78793_a(-3.5F, -4.5F, -1.0F);
/*  71 */     this.EarR.func_78790_a(-3.5F, -3.5F, 0.0F, 3, 6, 0, 0.0F);
/*  72 */     setRotateAngle(this.EarR, 0.0F, 0.87266463F, -0.04363323F);
/*  73 */     this.ArmR = new ModelRenderer(this, 41, 19);
/*  74 */     this.ArmR.func_78793_a(-5.8F, -5.1F, 0.0F);
/*  75 */     this.ArmR.func_78790_a(-4.0F, -2.0F, -2.5F, 5, 15, 5, -0.1F);
/*  76 */     this.FeetL = new ModelRenderer(this, 64, 41);
/*  77 */     this.FeetL.field_78809_i = true;
/*  78 */     this.FeetL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  79 */     this.FeetL.func_78790_a(-2.0F, 14.0F, -3.3F, 4, 2, 5, 0.0F);
/*  80 */     this.Body = new ModelRenderer(this, 1, 24);
/*  81 */     this.Body.func_78793_a(0.0F, -7.0F, 0.0F);
/*  82 */     this.Body.func_78790_a(-5.0F, 0.0F, -3.0F, 10, 9, 6, 0.0F);
/*  83 */     this.Head.func_78792_a(this.TentacleL);
/*  84 */     this.Head.func_78792_a(this.TentacleR);
/*  85 */     this.Body.func_78792_a(this.Body2);
/*  86 */     this.LegR.func_78792_a(this.FeetR);
/*  87 */     this.Head.func_78792_a(this.EarL);
/*  88 */     this.Body.func_78792_a(this.Body3);
/*  89 */     this.Head.func_78792_a(this.Head2);
/*  90 */     this.Head.func_78792_a(this.EarR);
/*  91 */     this.LegL.func_78792_a(this.FeetL);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  96 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/*  98 */     this.Head.func_78785_a(f5);
/*     */     
/* 100 */     this.Body.func_78785_a(f5);
/* 101 */     this.ArmR.func_78785_a(f5);
/* 102 */     this.ArmL.func_78785_a(f5);
/* 103 */     this.LegL.func_78785_a(f5);
/* 104 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 114 */     modelRenderer.field_78795_f = x;
/* 115 */     modelRenderer.field_78796_g = y;
/* 116 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 120 */     int calc = par7Entity.field_70173_aa;
/* 121 */     if (calc > 100) calc -= 100; 
/* 122 */     float r = 360.0F;
/* 123 */     float r2 = 180.0F;
/* 124 */     float n4 = par4;
/* 125 */     float n5 = par5;
/*     */     
/* 127 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 128 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 129 */     float ex = par7Entity.field_70173_aa;
/* 130 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 131 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 133 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 134 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 183 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 184 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 185 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 186 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 188 */     this.LegR.field_78796_g = 0.0F;
/* 189 */     this.LegL.field_78796_g = 0.0F;
/* 190 */     this.ArmR.field_78796_g = 0.0F;
/* 191 */     this.ArmL.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 199 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbkingpiccolo\ModelKingPiccolo2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */