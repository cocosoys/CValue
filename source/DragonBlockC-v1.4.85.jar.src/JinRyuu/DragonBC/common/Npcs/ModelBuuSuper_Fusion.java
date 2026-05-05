/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelBuuSuper_Fusion
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer Head2;
/*     */   public ModelRenderer Head3;
/*     */   public ModelRenderer Head4;
/*     */   public ModelRenderer Head5;
/*     */   public ModelRenderer Head6;
/*     */   public ModelRenderer Hips;
/*     */   public ModelRenderer Torso;
/*     */   public ModelRenderer JacketNeck;
/*     */   public ModelRenderer Neck;
/*     */   public ModelRenderer Chest;
/*     */   public ModelRenderer JacketR;
/*     */   public ModelRenderer JacketL;
/*     */   public ModelRenderer JacketR_1;
/*     */   public ModelRenderer JacketL_1;
/*     */   public ModelRenderer FootR;
/*     */   public ModelRenderer FootL;
/*     */   
/*     */   public ModelBuuSuper_Fusion() {
/*  34 */     this.field_78090_t = 64;
/*  35 */     this.field_78089_u = 64;
/*  36 */     this.ArmR = new ModelRenderer(this, 46, 30);
/*  37 */     this.ArmR.func_78793_a(-5.2F, -1.4F, 0.5F);
/*  38 */     this.ArmR.func_78790_a(-2.9F, -1.3F, -1.8F, 4, 12, 4, -0.2F);
/*  39 */     this.JacketL = new ModelRenderer(this, 35, 54);
/*  40 */     this.JacketL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  41 */     this.JacketL.func_78790_a(3.9F, -0.1F, -1.5F, 2, 4, 5, 0.0F);
/*  42 */     this.LegR = new ModelRenderer(this, 0, 28);
/*  43 */     this.LegR.func_78793_a(-2.0F, 9.0F, 0.0F);
/*  44 */     this.LegR.func_78790_a(-2.0F, 2.0F, -2.3F, 4, 7, 5, 0.3F);
/*  45 */     this.JacketL_1 = new ModelRenderer(this, 48, 48);
/*  46 */     this.JacketL_1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  47 */     this.JacketL_1.func_78790_a(2.6F, 0.6F, -2.4F, 2, 5, 5, 0.0F);
/*  48 */     this.JacketNeck = new ModelRenderer(this, 18, 50);
/*  49 */     this.JacketNeck.func_78793_a(0.0F, 0.0F, 0.0F);
/*  50 */     this.JacketNeck.func_78790_a(-3.5F, -0.2F, 0.3F, 7, 2, 4, 0.0F);
/*  51 */     this.FootL = new ModelRenderer(this, 0, 43);
/*  52 */     this.FootL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  53 */     this.FootL.func_78790_a(-2.0F, 0.0F, -2.3F, 4, 15, 5, 0.0F);
/*  54 */     this.Torso = new ModelRenderer(this, 21, 19);
/*  55 */     this.Torso.func_78793_a(0.0F, 0.0F, 0.0F);
/*  56 */     this.Torso.func_78790_a(-4.5F, 0.6F, -1.4F, 9, 5, 4, 0.0F);
/*  57 */     this.FootR = new ModelRenderer(this, 0, 43);
/*  58 */     this.FootR.field_78809_i = true;
/*  59 */     this.FootR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  60 */     this.FootR.func_78790_a(-2.0F, 0.0F, -2.3F, 4, 15, 5, 0.0F);
/*  61 */     this.Body = new ModelRenderer(this, 22, 29);
/*  62 */     this.Body.func_78793_a(0.0F, -3.2F, 0.0F);
/*  63 */     this.Body.func_78790_a(-3.5F, 3.1F, -2.2F, 7, 7, 4, 0.0F);
/*  64 */     this.ArmL = new ModelRenderer(this, 46, 30);
/*  65 */     this.ArmL.field_78809_i = true;
/*  66 */     this.ArmL.func_78793_a(5.3F, -1.4F, 0.5F);
/*  67 */     this.ArmL.func_78790_a(-1.2F, -1.3F, -1.8F, 4, 12, 4, -0.2F);
/*  68 */     this.JacketR_1 = new ModelRenderer(this, 48, 48);
/*  69 */     this.JacketR_1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  70 */     this.JacketR_1.func_78790_a(-4.6F, 0.6F, -2.4F, 2, 5, 5, 0.0F);
/*  71 */     this.Head2 = new ModelRenderer(this, 25, 0);
/*  72 */     this.Head2.func_78793_a(0.0F, -6.1F, -1.5F);
/*  73 */     this.Head2.func_78790_a(-1.5F, -4.2F, -1.0F, 3, 4, 3, 0.0F);
/*  74 */     setRotateAngle(this.Head2, -0.49392816F, 0.0F, 0.0F);
/*  75 */     this.Head4 = new ModelRenderer(this, 49, 1);
/*  76 */     this.Head4.func_78793_a(0.0F, -5.5F, 0.1F);
/*  77 */     this.Head4.func_78790_a(-1.0F, -5.1F, -0.8F, 2, 5, 2, 0.0F);
/*  78 */     setRotateAngle(this.Head4, -0.7285004F, 0.0F, 0.0F);
/*  79 */     this.Head6 = new ModelRenderer(this, 44, 11);
/*  80 */     this.Head6.func_78793_a(0.0F, -5.6F, 0.3F);
/*  81 */     this.Head6.func_78790_a(-0.5F, -6.0F, -0.6F, 1, 6, 1, 0.0F);
/*  82 */     setRotateAngle(this.Head6, -0.46251225F, 0.0F, 0.0F);
/*  83 */     this.Neck = new ModelRenderer(this, 4, 16);
/*  84 */     this.Neck.func_78793_a(0.0F, 0.0F, 0.0F);
/*  85 */     this.Neck.func_78790_a(-2.5F, -0.3F, -0.5F, 5, 2, 3, 0.0F);
/*  86 */     this.JacketR = new ModelRenderer(this, 35, 54);
/*  87 */     this.JacketR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  88 */     this.JacketR.func_78790_a(-5.9F, -0.1F, -1.5F, 2, 4, 5, 0.0F);
/*  89 */     this.Chest = new ModelRenderer(this, 0, 22);
/*  90 */     this.Chest.func_78793_a(0.0F, 0.0F, 0.0F);
/*  91 */     this.Chest.func_78790_a(-4.1F, 1.7F, -2.0F, 8, 3, 2, 0.0F);
/*  92 */     setRotateAngle(this.Chest, -0.06632251F, 0.0F, 0.0F);
/*  93 */     this.LegL = new ModelRenderer(this, 0, 28);
/*  94 */     this.LegL.field_78809_i = true;
/*  95 */     this.LegL.func_78793_a(2.0F, 9.0F, 0.0F);
/*  96 */     this.LegL.func_78790_a(-2.0F, 2.0F, -2.3F, 4, 7, 5, 0.3F);
/*  97 */     this.Head5 = new ModelRenderer(this, 37, 10);
/*  98 */     this.Head5.func_78793_a(0.0F, -4.7F, -0.3F);
/*  99 */     this.Head5.func_78790_a(-0.5F, -6.0F, -0.6F, 1, 6, 2, 0.0F);
/* 100 */     setRotateAngle(this.Head5, -0.63739425F, 0.0F, 0.0F);
/* 101 */     this.Head = new ModelRenderer(this, 0, 0);
/* 102 */     this.Head.func_78793_a(0.0F, -2.8F, 0.0F);
/* 103 */     this.Head.func_78790_a(-4.0F, -7.5F, -3.3F, 8, 8, 8, -0.7F);
/* 104 */     this.Head3 = new ModelRenderer(this, 38, 1);
/* 105 */     this.Head3.func_78793_a(0.0F, -3.8F, -0.6F);
/* 106 */     this.Head3.func_78790_a(-1.5F, -6.1F, -0.5F, 3, 6, 2, 0.0F);
/* 107 */     setRotateAngle(this.Head3, -0.68294734F, 0.0F, 0.0F);
/* 108 */     this.Hips = new ModelRenderer(this, 19, 41);
/* 109 */     this.Hips.func_78793_a(0.0F, 0.0F, 0.0F);
/* 110 */     this.Hips.func_78790_a(-4.0F, 9.2F, -2.3F, 8, 3, 5, 0.0F);
/* 111 */     this.JacketNeck.func_78792_a(this.JacketL);
/* 112 */     this.JacketL.func_78792_a(this.JacketL_1);
/* 113 */     this.Body.func_78792_a(this.JacketNeck);
/* 114 */     this.LegL.func_78792_a(this.FootL);
/* 115 */     this.Body.func_78792_a(this.Torso);
/* 116 */     this.LegR.func_78792_a(this.FootR);
/* 117 */     this.JacketR.func_78792_a(this.JacketR_1);
/* 118 */     this.Head.func_78792_a(this.Head2);
/* 119 */     this.Head3.func_78792_a(this.Head4);
/* 120 */     this.Head5.func_78792_a(this.Head6);
/* 121 */     this.Body.func_78792_a(this.Neck);
/* 122 */     this.JacketNeck.func_78792_a(this.JacketR);
/* 123 */     this.Torso.func_78792_a(this.Chest);
/* 124 */     this.Head4.func_78792_a(this.Head5);
/* 125 */     this.Head2.func_78792_a(this.Head3);
/* 126 */     this.Body.func_78792_a(this.Hips);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 131 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 134 */     this.LegL.func_78785_a(f5);
/* 135 */     this.Head.func_78785_a(f5);
/* 136 */     this.ArmL.func_78785_a(f5);
/* 137 */     this.ArmR.func_78785_a(f5);
/* 138 */     this.Body.func_78785_a(f5);
/* 139 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 144 */     modelRenderer.field_78795_f = x;
/* 145 */     modelRenderer.field_78796_g = y;
/* 146 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 150 */     int calc = par7Entity.field_70173_aa;
/* 151 */     if (calc > 100) calc -= 100; 
/* 152 */     float r = 360.0F;
/* 153 */     float r2 = 180.0F;
/* 154 */     float n4 = par4;
/* 155 */     float n5 = par5;
/*     */     
/* 157 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 158 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 159 */     float ex = par7Entity.field_70173_aa;
/* 160 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 161 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 163 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 164 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 194 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 195 */     this.LegL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 196 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 197 */     this.ArmL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 198 */     this.LegR.field_78796_g = 0.0F;
/* 199 */     this.LegL.field_78796_g = 0.0F;
/* 200 */     this.ArmR.field_78796_g = 0.0F;
/* 201 */     this.ArmL.field_78796_g = 0.0F;
/* 202 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelBuuSuper_Fusion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */