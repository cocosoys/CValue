/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelBuuSuper_Piccolo
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer Head2;
/*     */   public ModelRenderer Head3;
/*     */   public ModelRenderer Head4;
/*     */   public ModelRenderer Head5;
/*     */   public ModelRenderer Head6;
/*     */   public ModelRenderer Hips;
/*     */   public ModelRenderer Torso;
/*     */   public ModelRenderer Cape;
/*     */   public ModelRenderer CapeNeck;
/*     */   public ModelRenderer CapeBack;
/*     */   public ModelRenderer CapeR;
/*     */   public ModelRenderer CapeL;
/*     */   public ModelRenderer FootL;
/*     */   public ModelRenderer FootR;
/*     */   
/*     */   public ModelBuuSuper_Piccolo() {
/*  32 */     this.field_78090_t = 128;
/*  33 */     this.field_78089_u = 64;
/*  34 */     this.Head5 = new ModelRenderer(this, 37, 10);
/*  35 */     this.Head5.func_78793_a(0.0F, -4.7F, -0.3F);
/*  36 */     this.Head5.func_78790_a(-0.5F, -6.0F, -0.6F, 1, 6, 2, 0.0F);
/*  37 */     setRotateAngle(this.Head5, -0.63739425F, 0.0F, 0.0F);
/*  38 */     this.Head6 = new ModelRenderer(this, 44, 11);
/*  39 */     this.Head6.func_78793_a(0.0F, -5.6F, 0.3F);
/*  40 */     this.Head6.func_78790_a(-0.5F, -6.0F, -0.6F, 1, 6, 1, 0.0F);
/*  41 */     setRotateAngle(this.Head6, -0.46251225F, 0.0F, 0.0F);
/*  42 */     this.ArmL = new ModelRenderer(this, 46, 30);
/*  43 */     this.ArmL.field_78809_i = true;
/*  44 */     this.ArmL.func_78793_a(5.3F, -2.0F, 0.3F);
/*  45 */     this.ArmL.func_78790_a(-1.2F, -1.3F, -1.8F, 4, 12, 4, -0.2F);
/*  46 */     this.Body = new ModelRenderer(this, 22, 29);
/*  47 */     this.Body.func_78793_a(0.0F, -3.2F, 0.0F);
/*  48 */     this.Body.func_78790_a(-3.5F, 3.0F, -1.9F, 7, 7, 4, 0.0F);
/*  49 */     this.Head4 = new ModelRenderer(this, 49, 1);
/*  50 */     this.Head4.func_78793_a(0.0F, -5.5F, 0.1F);
/*  51 */     this.Head4.func_78790_a(-1.0F, -5.1F, -0.8F, 2, 5, 2, 0.0F);
/*  52 */     setRotateAngle(this.Head4, -0.7285004F, 0.0F, 0.0F);
/*  53 */     this.Cape = new ModelRenderer(this, 75, 14);
/*  54 */     this.Cape.func_78793_a(0.0F, 0.0F, 0.0F);
/*  55 */     this.Cape.func_78790_a(-4.0F, 0.0F, -2.4F, 8, 4, 2, 0.0F);
/*  56 */     this.CapeL = new ModelRenderer(this, 50, 18);
/*  57 */     this.CapeL.field_78809_i = true;
/*  58 */     this.CapeL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  59 */     this.CapeL.func_78790_a(-1.9F, -1.4F, -2.3F, 7, 3, 5, 0.0F);
/*  60 */     this.CapeBack = new ModelRenderer(this, 75, 22);
/*  61 */     this.CapeBack.func_78793_a(0.0F, 1.1F, 2.8F);
/*  62 */     this.CapeBack.func_78790_a(-5.5F, -0.3F, 0.2F, 11, 19, 0, 0.0F);
/*  63 */     setRotateAngle(this.CapeBack, 0.0418879F, 0.0F, 0.0F);
/*  64 */     this.LegL = new ModelRenderer(this, 0, 28);
/*  65 */     this.LegL.field_78809_i = true;
/*  66 */     this.LegL.func_78793_a(2.0F, 9.0F, 0.0F);
/*  67 */     this.LegL.func_78790_a(-2.0F, 2.0F, -2.3F, 4, 7, 5, 0.3F);
/*  68 */     this.FootR = new ModelRenderer(this, 0, 43);
/*  69 */     this.FootR.field_78809_i = true;
/*  70 */     this.FootR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  71 */     this.FootR.func_78790_a(-2.0F, 0.0F, -2.3F, 4, 15, 5, 0.0F);
/*  72 */     this.FootL = new ModelRenderer(this, 0, 43);
/*  73 */     this.FootL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  74 */     this.FootL.func_78790_a(-2.0F, 0.0F, -2.3F, 4, 15, 5, 0.0F);
/*  75 */     this.Torso = new ModelRenderer(this, 21, 19);
/*  76 */     this.Torso.func_78793_a(0.0F, 0.0F, 0.0F);
/*  77 */     this.Torso.func_78790_a(-4.5F, 0.6F, -1.2F, 9, 5, 4, 0.0F);
/*  78 */     this.CapeNeck = new ModelRenderer(this, 71, 4);
/*  79 */     this.CapeNeck.func_78793_a(0.0F, 0.0F, 0.0F);
/*  80 */     this.CapeNeck.func_78790_a(-3.5F, -0.7F, -3.1F, 7, 2, 7, 0.0F);
/*  81 */     this.Head2 = new ModelRenderer(this, 25, 0);
/*  82 */     this.Head2.func_78793_a(0.0F, -6.5F, -2.3F);
/*  83 */     this.Head2.func_78790_a(-1.5F, -4.2F, -1.0F, 3, 4, 3, 0.0F);
/*  84 */     setRotateAngle(this.Head2, -0.49392816F, 0.0F, 0.0F);
/*  85 */     this.Head3 = new ModelRenderer(this, 38, 1);
/*  86 */     this.Head3.func_78793_a(0.0F, -3.8F, -0.6F);
/*  87 */     this.Head3.func_78790_a(-1.5F, -6.1F, -0.5F, 3, 6, 2, 0.0F);
/*  88 */     setRotateAngle(this.Head3, -0.68294734F, 0.0F, 0.0F);
/*  89 */     this.Hips = new ModelRenderer(this, 19, 41);
/*  90 */     this.Hips.func_78793_a(0.0F, 0.0F, 0.0F);
/*  91 */     this.Hips.func_78790_a(-4.0F, 9.2F, -2.3F, 8, 3, 5, 0.0F);
/*  92 */     this.Head = new ModelRenderer(this, 0, 0);
/*  93 */     this.Head.func_78793_a(0.0F, -3.2F, 0.4F);
/*  94 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, -0.7F);
/*  95 */     this.ArmR = new ModelRenderer(this, 46, 30);
/*  96 */     this.ArmR.func_78793_a(-5.3F, -2.0F, 0.3F);
/*  97 */     this.ArmR.func_78790_a(-3.0F, -1.3F, -1.8F, 4, 12, 4, -0.1F);
/*  98 */     this.CapeR = new ModelRenderer(this, 50, 18);
/*  99 */     this.CapeR.func_78793_a(0.0F, 0.0F, 0.0F);
/* 100 */     this.CapeR.func_78790_a(-5.1F, -1.4F, -2.3F, 7, 3, 5, 0.0F);
/* 101 */     this.LegR = new ModelRenderer(this, 0, 28);
/* 102 */     this.LegR.func_78793_a(-2.0F, 9.0F, 0.0F);
/* 103 */     this.LegR.func_78790_a(-2.0F, 2.0F, -2.3F, 4, 7, 5, 0.3F);
/* 104 */     this.Head4.func_78792_a(this.Head5);
/* 105 */     this.Head5.func_78792_a(this.Head6);
/* 106 */     this.Head3.func_78792_a(this.Head4);
/* 107 */     this.Body.func_78792_a(this.Cape);
/* 108 */     this.ArmL.func_78792_a(this.CapeL);
/* 109 */     this.Cape.func_78792_a(this.CapeBack);
/* 110 */     this.LegR.func_78792_a(this.FootR);
/* 111 */     this.LegL.func_78792_a(this.FootL);
/* 112 */     this.Body.func_78792_a(this.Torso);
/* 113 */     this.Body.func_78792_a(this.CapeNeck);
/* 114 */     this.Head.func_78792_a(this.Head2);
/* 115 */     this.Head2.func_78792_a(this.Head3);
/* 116 */     this.Body.func_78792_a(this.Hips);
/* 117 */     this.ArmR.func_78792_a(this.CapeR);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 122 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 125 */     this.LegL.func_78785_a(f5);
/* 126 */     this.Head.func_78785_a(f5);
/* 127 */     this.ArmL.func_78785_a(f5);
/* 128 */     this.ArmR.func_78785_a(f5);
/* 129 */     this.Body.func_78785_a(f5);
/* 130 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 135 */     modelRenderer.field_78795_f = x;
/* 136 */     modelRenderer.field_78796_g = y;
/* 137 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 141 */     int calc = par7Entity.field_70173_aa;
/* 142 */     if (calc > 100) calc -= 100; 
/* 143 */     float r = 360.0F;
/* 144 */     float r2 = 180.0F;
/* 145 */     float n4 = par4;
/* 146 */     float n5 = par5;
/*     */     
/* 148 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 149 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 150 */     float ex = par7Entity.field_70173_aa;
/* 151 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 152 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 158 */     this.CapeBack.field_78795_f = -0.15F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 159 */     if (0.0F > this.CapeBack.field_78795_f) this.CapeBack.field_78795_f *= -1.0F; 
/* 160 */     this.CapeBack.field_78796_g = 0.0F;
/*     */ 
/*     */     
/* 163 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 164 */     this.LegL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 165 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 166 */     this.ArmL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 167 */     this.LegR.field_78796_g = 0.0F;
/* 168 */     this.LegL.field_78796_g = 0.0F;
/* 169 */     this.ArmR.field_78796_g = 0.0F;
/* 170 */     this.ArmL.field_78796_g = 0.0F;
/* 171 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelBuuSuper_Piccolo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */