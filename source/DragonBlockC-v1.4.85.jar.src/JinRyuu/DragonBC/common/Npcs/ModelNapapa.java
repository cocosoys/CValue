/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelNapapa
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmR1;
/*     */   public ModelRenderer ArmL1;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer Beard;
/*     */   public ModelRenderer Nose;
/*     */   public ModelRenderer EarR;
/*     */   public ModelRenderer EarL;
/*     */   public ModelRenderer Hair;
/*     */   public ModelRenderer MuttonchopsR;
/*     */   public ModelRenderer MuttonchopsL;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Chest;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer BeltKnot;
/*     */   public ModelRenderer ArmR2;
/*     */   public ModelRenderer ArmL2;
/*     */   
/*     */   public ModelNapapa() {
/*  31 */     this.field_78090_t = 128;
/*  32 */     this.field_78089_u = 64;
/*  33 */     this.Body1 = new ModelRenderer(this, 0, 17);
/*  34 */     this.Body1.func_78793_a(0.0F, -7.8F, 0.0F);
/*  35 */     this.Body1.func_78790_a(-7.5F, 0.0F, -2.4F, 15, 7, 9, 0.0F);
/*  36 */     this.LegL = new ModelRenderer(this, 91, 43);
/*  37 */     this.LegL.field_78809_i = true;
/*  38 */     this.LegL.func_78793_a(4.3F, 10.0F, 1.0F);
/*  39 */     this.LegL.func_78790_a(-3.0F, 0.0F, -3.5F, 6, 14, 7, 0.0F);
/*  40 */     this.Hair = new ModelRenderer(this, 51, 3);
/*  41 */     this.Hair.func_78793_a(0.0F, -6.1F, 0.0F);
/*  42 */     this.Hair.func_78790_a(-1.5F, -3.6F, -5.2F, 3, 4, 11, 0.0F);
/*  43 */     setRotateAngle(this.Hair, -0.13665928F, 0.0F, 0.0F);
/*  44 */     this.MuttonchopsR = new ModelRenderer(this, 55, 8);
/*  45 */     this.MuttonchopsR.func_78793_a(-3.5F, -3.5F, -2.1F);
/*  46 */     this.MuttonchopsR.func_78790_a(-1.2F, -0.4F, 0.0F, 2, 4, 0, 0.0F);
/*  47 */     setRotateAngle(this.MuttonchopsR, 0.0F, 0.68294734F, 0.31869712F);
/*  48 */     this.EarR = new ModelRenderer(this, 55, 3);
/*  49 */     this.EarR.func_78793_a(-4.0F, -3.5F, -1.1F);
/*  50 */     this.EarR.func_78790_a(-1.4F, -3.0F, 0.0F, 2, 4, 0, 0.0F);
/*  51 */     setRotateAngle(this.EarR, 0.0F, 0.68294734F, -0.31869712F);
/*  52 */     this.Head = new ModelRenderer(this, 0, 0);
/*  53 */     this.Head.func_78793_a(0.0F, -7.9F, 0.6F);
/*  54 */     this.Head.func_78790_a(-4.0F, -7.2F, -4.0F, 8, 8, 8, 0.0F);
/*  55 */     this.Body2 = new ModelRenderer(this, 0, 33);
/*  56 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  57 */     this.Body2.func_78790_a(-8.0F, 7.0F, -4.1F, 16, 8, 11, 0.0F);
/*  58 */     this.LegR = new ModelRenderer(this, 91, 43);
/*  59 */     this.LegR.func_78793_a(-4.2F, 10.0F, 1.0F);
/*  60 */     this.LegR.func_78790_a(-3.0F, 0.0F, -3.5F, 6, 14, 7, 0.0F);
/*  61 */     this.ArmR2 = new ModelRenderer(this, 90, 19);
/*  62 */     this.ArmR2.func_78793_a(-0.6F, 7.9F, -0.3F);
/*  63 */     this.ArmR2.func_78790_a(-3.5F, -0.5F, -2.5F, 6, 11, 6, 0.0F);
/*  64 */     setRotateAngle(this.ArmR2, -0.4098033F, 0.0F, -0.08726646F);
/*  65 */     this.Beard = new ModelRenderer(this, 44, 5);
/*  66 */     this.Beard.func_78793_a(0.0F, -0.7F, -4.1F);
/*  67 */     this.Beard.func_78790_a(-2.5F, 0.0F, 0.0F, 5, 4, 0, 0.0F);
/*  68 */     setRotateAngle(this.Beard, -0.0052359877F, 0.0F, 0.0F);
/*  69 */     this.ArmL1 = new ModelRenderer(this, 92, 3);
/*  70 */     this.ArmL1.field_78809_i = true;
/*  71 */     this.ArmL1.func_78793_a(8.5F, -5.3F, 2.0F);
/*  72 */     this.ArmL1.func_78790_a(-1.2F, -2.0F, -2.5F, 4, 10, 5, 0.0F);
/*  73 */     setRotateAngle(this.ArmL1, 0.0F, 0.0F, -0.38397244F);
/*  74 */     this.BeltKnot = new ModelRenderer(this, 56, 48);
/*  75 */     this.BeltKnot.func_78793_a(0.0F, 0.0F, 0.0F);
/*  76 */     this.BeltKnot.func_78790_a(-3.0F, 11.9F, 6.9F, 6, 3, 2, 0.0F);
/*  77 */     this.MuttonchopsL = new ModelRenderer(this, 55, 8);
/*  78 */     this.MuttonchopsL.field_78809_i = true;
/*  79 */     this.MuttonchopsL.func_78793_a(3.6F, -3.5F, -2.1F);
/*  80 */     this.MuttonchopsL.func_78790_a(-1.1F, -0.2F, 0.0F, 2, 4, 0, 0.0F);
/*  81 */     setRotateAngle(this.MuttonchopsL, 0.0F, -0.68294734F, -0.31869712F);
/*  82 */     this.EarL = new ModelRenderer(this, 55, 3);
/*  83 */     this.EarL.field_78809_i = true;
/*  84 */     this.EarL.func_78793_a(4.0F, -3.5F, -1.1F);
/*  85 */     this.EarL.func_78790_a(-0.5F, -3.0F, 0.0F, 2, 4, 0, 0.0F);
/*  86 */     setRotateAngle(this.EarL, 0.0F, -0.68294734F, 0.31869712F);
/*  87 */     this.Body3 = new ModelRenderer(this, 0, 52);
/*  88 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  89 */     this.Body3.func_78790_a(-7.5F, 14.8F, -3.2F, 15, 3, 9, 0.0F);
/*  90 */     this.ArmR1 = new ModelRenderer(this, 92, 3);
/*  91 */     this.ArmR1.func_78793_a(-8.2F, -5.3F, 2.0F);
/*  92 */     this.ArmR1.func_78790_a(-3.0F, -2.0F, -2.5F, 4, 10, 5, 0.0F);
/*  93 */     setRotateAngle(this.ArmR1, 0.0F, 0.0F, 0.38397244F);
/*  94 */     this.Nose = new ModelRenderer(this, 46, 0);
/*  95 */     this.Nose.func_78793_a(0.0F, 0.0F, 0.0F);
/*  96 */     this.Nose.func_78790_a(-1.0F, -4.1F, -4.6F, 2, 2, 2, 0.0F);
/*  97 */     this.ArmL2 = new ModelRenderer(this, 90, 19);
/*  98 */     this.ArmL2.field_78809_i = true;
/*  99 */     this.ArmL2.func_78793_a(0.7F, 7.9F, -0.3F);
/* 100 */     this.ArmL2.func_78790_a(-2.8F, -0.5F, -2.5F, 6, 11, 6, 0.0F);
/* 101 */     setRotateAngle(this.ArmL2, -0.4098033F, 0.0F, 0.08726646F);
/* 102 */     this.Chest = new ModelRenderer(this, 50, 28);
/* 103 */     this.Chest.func_78793_a(0.0F, 3.7F, -1.7F);
/* 104 */     this.Chest.func_78790_a(-7.0F, -2.1F, -1.4F, 14, 5, 2, 0.0F);
/* 105 */     setRotateAngle(this.Chest, -0.091106184F, 0.0F, 0.0F);
/* 106 */     this.Head.func_78792_a(this.Hair);
/* 107 */     this.Head.func_78792_a(this.MuttonchopsR);
/* 108 */     this.Head.func_78792_a(this.EarR);
/* 109 */     this.Body1.func_78792_a(this.Body2);
/* 110 */     this.ArmR1.func_78792_a(this.ArmR2);
/* 111 */     this.Head.func_78792_a(this.Beard);
/* 112 */     this.Body2.func_78792_a(this.BeltKnot);
/* 113 */     this.Head.func_78792_a(this.MuttonchopsL);
/* 114 */     this.Head.func_78792_a(this.EarL);
/* 115 */     this.Body2.func_78792_a(this.Body3);
/* 116 */     this.Head.func_78792_a(this.Nose);
/* 117 */     this.ArmL1.func_78792_a(this.ArmL2);
/* 118 */     this.Body1.func_78792_a(this.Chest);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 123 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 125 */     this.Head.func_78785_a(f5);
/* 126 */     this.LegR.func_78785_a(f5);
/* 127 */     this.Body1.func_78785_a(f5);
/* 128 */     this.LegL.func_78785_a(f5);
/* 129 */     this.ArmL1.func_78785_a(f5);
/* 130 */     this.ArmR1.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 136 */     modelRenderer.field_78795_f = x;
/* 137 */     modelRenderer.field_78796_g = y;
/* 138 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 142 */     int calc = par7Entity.field_70173_aa;
/* 143 */     if (calc > 100) calc -= 100; 
/* 144 */     float r = 360.0F;
/* 145 */     float r2 = 180.0F;
/* 146 */     float n4 = par4;
/* 147 */     float n5 = par5;
/*     */ 
/*     */ 
/*     */     
/* 151 */     float ex = par7Entity.field_70173_aa;
/* 152 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 153 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 155 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 156 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 205 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 206 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 207 */     this.ArmR1.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 208 */     this.ArmL1.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 210 */     this.LegR.field_78796_g = 0.0F;
/* 211 */     this.LegL.field_78796_g = 0.0F;
/* 212 */     this.ArmR1.field_78796_g = 0.0F;
/* 213 */     this.ArmL1.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 220 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelNapapa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */