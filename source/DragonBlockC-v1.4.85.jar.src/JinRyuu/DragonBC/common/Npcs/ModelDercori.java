/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelDercori
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmL1;
/*     */   public ModelRenderer ArmR1;
/*     */   public ModelRenderer Hair;
/*     */   public ModelRenderer EarR;
/*     */   public ModelRenderer EarL;
/*     */   public ModelRenderer Hair2;
/*     */   public ModelRenderer HairFrontL1;
/*     */   public ModelRenderer HairFrontR1;
/*     */   public ModelRenderer Hair3;
/*     */   public ModelRenderer Hair4;
/*     */   public ModelRenderer HairFrontL2;
/*     */   public ModelRenderer HairFrontR2;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer Body4;
/*     */   public ModelRenderer Body5;
/*     */   public ModelRenderer ArmL2;
/*     */   public ModelRenderer ArmR2;
/*     */   
/*     */   public ModelDercori() {
/*  32 */     this.field_78090_t = 128;
/*  33 */     this.field_78089_u = 64;
/*  34 */     this.Hair3 = new ModelRenderer(this, 37, 9);
/*  35 */     this.Hair3.func_78793_a(1.2F, 0.6F, -0.2F);
/*  36 */     this.Hair3.func_78790_a(-1.2F, -6.9F, -1.7F, 2, 6, 3, 0.0F);
/*  37 */     setRotateAngle(this.Hair3, -0.5009095F, 0.13665928F, 0.18203785F);
/*  38 */     this.ArmR2 = new ModelRenderer(this, 64, 19);
/*  39 */     this.ArmR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  40 */     this.ArmR2.func_78790_a(-3.0F, 6.7F, -2.0F, 4, 7, 4, 0.0F);
/*  41 */     this.ArmL1 = new ModelRenderer(this, 64, 6);
/*  42 */     this.ArmL1.field_78809_i = true;
/*  43 */     this.ArmL1.func_78793_a(4.7F, -2.0F, 0.0F);
/*  44 */     this.ArmL1.func_78790_a(-1.1F, -1.0F, -2.0F, 4, 8, 4, -0.3F);
/*  45 */     setRotateAngle(this.ArmL1, 0.0F, 0.0F, -0.0418879F);
/*  46 */     this.Hair2 = new ModelRenderer(this, 37, 0);
/*  47 */     this.Hair2.func_78793_a(-0.4F, -3.0F, 1.6F);
/*  48 */     this.Hair2.func_78790_a(-1.2F, -6.5F, -1.5F, 2, 6, 3, 0.0F);
/*  49 */     setRotateAngle(this.Hair2, -0.045553092F, -0.13665928F, -0.091106184F);
/*  50 */     this.ArmR1 = new ModelRenderer(this, 64, 6);
/*  51 */     this.ArmR1.func_78793_a(-4.7F, -2.0F, 0.0F);
/*  52 */     this.ArmR1.func_78790_a(-2.9F, -1.0F, -2.0F, 4, 8, 4, -0.3F);
/*  53 */     setRotateAngle(this.ArmR1, 0.0F, 0.0F, 0.0418879F);
/*  54 */     this.Hair4 = new ModelRenderer(this, 48, 11);
/*  55 */     this.Hair4.func_78793_a(-0.7F, -2.0F, 0.0F);
/*  56 */     this.Hair4.func_78790_a(-1.2F, -6.0F, -0.9F, 2, 6, 2, 0.0F);
/*  57 */     setRotateAngle(this.Hair4, -1.0016445F, 0.0F, 0.0F);
/*  58 */     this.Body5 = new ModelRenderer(this, 32, 47);
/*  59 */     this.Body5.func_78793_a(0.0F, 0.0F, 0.0F);
/*  60 */     this.Body5.func_78790_a(-5.0F, 19.0F, -2.6F, 10, 8, 6, 0.0F);
/*  61 */     this.HairFrontR2 = new ModelRenderer(this, 54, 5);
/*  62 */     this.HairFrontR2.func_78793_a(0.1F, 0.1F, -0.8F);
/*  63 */     this.HairFrontR2.func_78790_a(-3.3F, -0.6F, -0.1F, 4, 8, 0, 0.0F);
/*  64 */     setRotateAngle(this.HairFrontR2, 0.0F, 0.0F, 0.17627825F);
/*  65 */     this.Body1 = new ModelRenderer(this, 0, 18);
/*  66 */     this.Body1.func_78793_a(0.0F, -3.0F, 0.0F);
/*  67 */     this.Body1.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 6, 4, 0.0F);
/*  68 */     this.Body4 = new ModelRenderer(this, 0, 50);
/*  69 */     this.Body4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  70 */     this.Body4.func_78790_a(-4.5F, 13.0F, -2.3F, 9, 6, 5, 0.0F);
/*  71 */     this.ArmL2 = new ModelRenderer(this, 64, 19);
/*  72 */     this.ArmL2.field_78809_i = true;
/*  73 */     this.ArmL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  74 */     this.ArmL2.func_78790_a(-1.0F, 6.7F, -2.0F, 4, 7, 4, 0.0F);
/*  75 */     this.Head = new ModelRenderer(this, 0, 0);
/*  76 */     this.Head.func_78793_a(0.0F, -2.8F, 0.0F);
/*  77 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, -0.2F);
/*  78 */     this.Hair = new ModelRenderer(this, 26, 0);
/*  79 */     this.Hair.func_78793_a(0.0F, -6.2F, -0.4F);
/*  80 */     this.Hair.func_78790_a(-1.5F, -4.1F, 1.0F, 3, 2, 2, 0.0F);
/*  81 */     setRotateAngle(this.Hair, -0.7285004F, 0.045553092F, 0.0F);
/*  82 */     this.HairFrontL1 = new ModelRenderer(this, 54, 1);
/*  83 */     this.HairFrontL1.func_78793_a(1.5F, 1.5F, -3.0F);
/*  84 */     this.HairFrontL1.func_78790_a(-1.0F, -0.3F, -0.8F, 2, 1, 1, 0.0F);
/*  85 */     setRotateAngle(this.HairFrontL1, 0.6981317F, -0.2617994F, -0.08726646F);
/*  86 */     this.HairFrontL2 = new ModelRenderer(this, 54, 5);
/*  87 */     this.HairFrontL2.field_78809_i = true;
/*  88 */     this.HairFrontL2.func_78793_a(0.1F, 0.1F, -0.8F);
/*  89 */     this.HairFrontL2.func_78790_a(-0.8F, -0.6F, -0.1F, 4, 8, 0, 0.0F);
/*  90 */     setRotateAngle(this.HairFrontL2, 0.0F, 0.0F, -0.25307274F);
/*  91 */     this.HairFrontR1 = new ModelRenderer(this, 54, 1);
/*  92 */     this.HairFrontR1.func_78793_a(-1.5F, 1.5F, -3.0F);
/*  93 */     this.HairFrontR1.func_78790_a(-1.0F, -0.3F, -0.8F, 2, 1, 1, 0.0F);
/*  94 */     setRotateAngle(this.HairFrontR1, 0.6981317F, 0.18325958F, 0.08726646F);
/*  95 */     this.Body2 = new ModelRenderer(this, 0, 31);
/*  96 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  97 */     this.Body2.func_78790_a(-3.5F, 6.0F, -1.6F, 7, 3, 3, 0.0F);
/*  98 */     this.Body3 = new ModelRenderer(this, 0, 40);
/*  99 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 100 */     this.Body3.func_78790_a(-4.0F, 9.0F, -2.0F, 8, 4, 4, 0.0F);
/* 101 */     this.EarL = new ModelRenderer(this, 0, 0);
/* 102 */     this.EarL.field_78809_i = true;
/* 103 */     this.EarL.func_78793_a(3.5F, -3.0F, -1.5F);
/* 104 */     this.EarL.func_78790_a(0.0F, -3.0F, 0.0F, 4, 5, 0, 0.0F);
/* 105 */     setRotateAngle(this.EarL, 0.0F, -0.7853982F, 0.0F);
/* 106 */     this.EarR = new ModelRenderer(this, 0, 0);
/* 107 */     this.EarR.func_78793_a(-3.5F, -3.0F, -1.5F);
/* 108 */     this.EarR.func_78790_a(-4.0F, -3.0F, 0.0F, 4, 5, 0, 0.0F);
/* 109 */     setRotateAngle(this.EarR, 0.0F, 0.7853982F, 0.0F);
/* 110 */     this.Hair2.func_78792_a(this.Hair3);
/* 111 */     this.ArmR1.func_78792_a(this.ArmR2);
/* 112 */     this.Hair.func_78792_a(this.Hair2);
/* 113 */     this.Hair3.func_78792_a(this.Hair4);
/* 114 */     this.Body4.func_78792_a(this.Body5);
/* 115 */     this.HairFrontR1.func_78792_a(this.HairFrontR2);
/* 116 */     this.Body3.func_78792_a(this.Body4);
/* 117 */     this.ArmL1.func_78792_a(this.ArmL2);
/* 118 */     this.Head.func_78792_a(this.Hair);
/* 119 */     this.Hair.func_78792_a(this.HairFrontL1);
/* 120 */     this.HairFrontL1.func_78792_a(this.HairFrontL2);
/* 121 */     this.Hair.func_78792_a(this.HairFrontR1);
/* 122 */     this.Body1.func_78792_a(this.Body2);
/* 123 */     this.Body2.func_78792_a(this.Body3);
/* 124 */     this.Head.func_78792_a(this.EarL);
/* 125 */     this.Head.func_78792_a(this.EarR);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 130 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 133 */     this.ArmL1.func_78785_a(f5);
/* 134 */     this.ArmR1.func_78785_a(f5);
/* 135 */     this.Body1.func_78785_a(f5);
/* 136 */     this.Head.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 142 */     modelRenderer.field_78795_f = x;
/* 143 */     modelRenderer.field_78796_g = y;
/* 144 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 148 */     int calc = par7Entity.field_70173_aa;
/* 149 */     if (calc > 100) calc -= 100; 
/* 150 */     float r = 360.0F;
/* 151 */     float r2 = 180.0F;
/* 152 */     float n4 = par4;
/* 153 */     float n5 = par5;
/*     */ 
/*     */ 
/*     */     
/* 157 */     float ex = par7Entity.field_70173_aa;
/* 158 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 159 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 161 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 162 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 210 */     this.ArmR1.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 211 */     this.ArmL1.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */ 
/*     */ 
/*     */     
/* 215 */     this.ArmR1.field_78796_g = 0.0F;
/* 216 */     this.ArmL1.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 223 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelDercori.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */