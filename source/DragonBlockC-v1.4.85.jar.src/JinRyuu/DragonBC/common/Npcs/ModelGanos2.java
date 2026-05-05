/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelGanos2
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer Hair1;
/*     */   public ModelRenderer Beak1;
/*     */   public ModelRenderer Hat2;
/*     */   public ModelRenderer Hair2;
/*     */   public ModelRenderer Beak2;
/*     */   public ModelRenderer Beak3;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer Chest;
/*     */   public ModelRenderer FeathersR;
/*     */   public ModelRenderer FeathersL;
/*     */   public ModelRenderer LegR2;
/*     */   public ModelRenderer LegL2;
/*     */   
/*     */   public ModelGanos2() {
/*  31 */     this.field_78090_t = 128;
/*  32 */     this.field_78089_u = 64;
/*  33 */     this.Hair2 = new ModelRenderer(this, 96, 32);
/*  34 */     this.Hair2.field_78809_i = true;
/*  35 */     this.Hair2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  36 */     this.Hair2.func_78790_a(-6.0F, -3.8F, -0.1F, 12, 10, 0, 0.0F);
/*  37 */     this.Beak1 = new ModelRenderer(this, 33, 8);
/*  38 */     this.Beak1.func_78793_a(0.0F, -3.4F, -3.4F);
/*  39 */     this.Beak1.func_78790_a(-2.5F, 0.9F, -1.9F, 5, 2, 2, 0.0F);
/*  40 */     this.LegL2 = new ModelRenderer(this, 66, 42);
/*  41 */     this.LegL2.field_78809_i = true;
/*  42 */     this.LegL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  43 */     this.LegL2.func_78790_a(-2.5F, 7.0F, -2.0F, 5, 9, 6, 0.0F);
/*  44 */     this.FeathersL = new ModelRenderer(this, 72, 21);
/*  45 */     this.FeathersL.func_78793_a(3.3F, 4.6F, 2.2F);
/*  46 */     this.FeathersL.func_78790_a(0.0F, -4.8F, -0.3F, 0, 7, 5, 0.0F);
/*  47 */     setRotateAngle(this.FeathersL, 0.0F, 0.6981317F, 0.0F);
/*  48 */     this.LegL = new ModelRenderer(this, 41, 42);
/*  49 */     this.LegL.field_78809_i = true;
/*  50 */     this.LegL.func_78793_a(3.0F, 8.0F, 0.0F);
/*  51 */     this.LegL.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 7, 6, 0.0F);
/*  52 */     this.LegR2 = new ModelRenderer(this, 66, 42);
/*  53 */     this.LegR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  54 */     this.LegR2.func_78790_a(-2.5F, 7.0F, -2.0F, 5, 9, 6, 0.0F);
/*  55 */     this.Body1 = new ModelRenderer(this, 0, 17);
/*  56 */     this.Body1.func_78793_a(0.0F, -6.7F, 0.0F);
/*  57 */     this.Body1.func_78790_a(-6.0F, 0.0F, -3.3F, 12, 8, 7, 0.0F);
/*  58 */     this.Beak2 = new ModelRenderer(this, 48, 8);
/*  59 */     this.Beak2.func_78793_a(0.0F, 0.9F, -1.1F);
/*  60 */     this.Beak2.func_78790_a(-2.0F, -1.1F, -2.4F, 4, 3, 4, 0.0F);
/*  61 */     this.Chest = new ModelRenderer(this, 40, 26);
/*  62 */     this.Chest.func_78793_a(0.0F, 0.0F, 0.0F);
/*  63 */     this.Chest.func_78790_a(-5.5F, 0.9F, -4.1F, 11, 5, 1, 0.0F);
/*  64 */     this.FeathersR = new ModelRenderer(this, 72, 21);
/*  65 */     this.FeathersR.func_78793_a(-3.5F, 4.6F, 2.2F);
/*  66 */     this.FeathersR.func_78790_a(0.0F, -4.8F, -0.3F, 0, 7, 5, 0.0F);
/*  67 */     setRotateAngle(this.FeathersR, 0.0F, -0.6981317F, 0.0F);
/*  68 */     this.Body3 = new ModelRenderer(this, 0, 48);
/*  69 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  70 */     this.Body3.func_78790_a(-5.5F, 10.7F, -3.0F, 11, 4, 6, 0.0F);
/*  71 */     this.ArmR = new ModelRenderer(this, 72, 3);
/*  72 */     this.ArmR.func_78793_a(-6.0F, -5.0F, 0.0F);
/*  73 */     this.ArmR.func_78790_a(-5.0F, -2.0F, -3.0F, 5, 16, 5, 0.0F);
/*  74 */     this.LegR = new ModelRenderer(this, 41, 42);
/*  75 */     this.LegR.func_78793_a(-3.0F, 8.0F, 0.0F);
/*  76 */     this.LegR.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 7, 6, 0.0F);
/*  77 */     this.Body2 = new ModelRenderer(this, 0, 34);
/*  78 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  79 */     this.Body2.func_78790_a(-5.0F, 6.8F, -3.1F, 10, 4, 6, 0.0F);
/*  80 */     this.Hat2 = new ModelRenderer(this, 41, 16);
/*  81 */     this.Hat2.func_78793_a(0.0F, -6.3F, -0.5F);
/*  82 */     this.Hat2.func_78790_a(-3.5F, -1.0F, -3.0F, 7, 1, 7, 0.0F);
/*  83 */     setRotateAngle(this.Hat2, 0.14014994F, 0.0F, 0.0F);
/*  84 */     this.Beak3 = new ModelRenderer(this, 48, 1);
/*  85 */     this.Beak3.func_78793_a(0.0F, 0.1F, 0.0F);
/*  86 */     this.Beak3.func_78790_a(-1.0F, -1.6F, -1.7F, 2, 2, 4, 0.0F);
/*  87 */     setRotateAngle(this.Beak3, 0.4098033F, 0.0F, 0.0F);
/*  88 */     this.Hair1 = new ModelRenderer(this, 96, 2);
/*  89 */     this.Hair1.func_78793_a(0.0F, -4.2F, 3.6F);
/*  90 */     this.Hair1.func_78790_a(-7.5F, -7.3F, 0.0F, 15, 26, 0, 0.0F);
/*  91 */     this.Head = new ModelRenderer(this, 0, 0);
/*  92 */     this.Head.func_78793_a(0.0F, -6.5F, 0.3F);
/*  93 */     this.Head.func_78790_a(-4.0F, -7.0F, -3.5F, 8, 7, 7, -0.2F);
/*  94 */     this.ArmL = new ModelRenderer(this, 72, 3);
/*  95 */     this.ArmL.field_78809_i = true;
/*  96 */     this.ArmL.func_78793_a(6.0F, -5.0F, 0.0F);
/*  97 */     this.ArmL.func_78790_a(0.0F, -2.0F, -3.0F, 5, 16, 5, 0.0F);
/*  98 */     this.Hair1.func_78792_a(this.Hair2);
/*  99 */     this.Head.func_78792_a(this.Beak1);
/* 100 */     this.LegL.func_78792_a(this.LegL2);
/* 101 */     this.ArmL.func_78792_a(this.FeathersL);
/* 102 */     this.LegR.func_78792_a(this.LegR2);
/* 103 */     this.Beak1.func_78792_a(this.Beak2);
/* 104 */     this.Body2.func_78792_a(this.Chest);
/* 105 */     this.ArmR.func_78792_a(this.FeathersR);
/* 106 */     this.Body2.func_78792_a(this.Body3);
/* 107 */     this.Body1.func_78792_a(this.Body2);
/* 108 */     this.Head.func_78792_a(this.Hat2);
/* 109 */     this.Beak2.func_78792_a(this.Beak3);
/* 110 */     this.Head.func_78792_a(this.Hair1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 115 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 117 */     this.Body1.func_78785_a(f5);
/* 118 */     this.ArmR.func_78785_a(f5);
/* 119 */     this.ArmL.func_78785_a(f5);
/* 120 */     this.LegL.func_78785_a(f5);
/* 121 */     this.Head.func_78785_a(f5);
/* 122 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 128 */     modelRenderer.field_78795_f = x;
/* 129 */     modelRenderer.field_78796_g = y;
/* 130 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 134 */     int calc = par7Entity.field_70173_aa;
/* 135 */     if (calc > 100) calc -= 100; 
/* 136 */     float r = 360.0F;
/* 137 */     float r2 = 180.0F;
/* 138 */     float n4 = par4;
/* 139 */     float n5 = par5;
/*     */ 
/*     */ 
/*     */     
/* 143 */     float ex = par7Entity.field_70173_aa;
/* 144 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 145 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 147 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 148 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 197 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 198 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 199 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 200 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 202 */     this.LegR.field_78796_g = 0.0F;
/* 203 */     this.LegL.field_78796_g = 0.0F;
/* 204 */     this.ArmR.field_78796_g = 0.0F;
/* 205 */     this.ArmL.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 212 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelGanos2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */