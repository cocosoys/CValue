/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelKakunsa
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer tail1;
/*     */   public ModelRenderer EarR;
/*     */   public ModelRenderer EarL;
/*     */   public ModelRenderer Hair;
/*     */   public ModelRenderer Head2;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Boobs;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer tail2;
/*     */   public ModelRenderer tail3;
/*     */   public ModelRenderer tail4;
/*     */   public ModelRenderer tail5;
/*     */   
/*     */   public ModelKakunsa() {
/*  30 */     this.field_78090_t = 64;
/*  31 */     this.field_78089_u = 64;
/*  32 */     this.ArmL = new ModelRenderer(this, 32, 35);
/*  33 */     this.ArmL.field_78809_i = true;
/*  34 */     this.ArmL.func_78793_a(4.3F, 3.0F, 0.0F);
/*  35 */     this.ArmL.func_78790_a(-1.3F, -1.5F, -1.8F, 3, 11, 4, -0.1F);
/*  36 */     setRotateAngle(this.ArmL, 0.0F, 0.0F, -0.06981317F);
/*  37 */     this.Head = new ModelRenderer(this, 0, 0);
/*  38 */     this.Head.func_78793_a(0.0F, 1.5F, 0.0F);
/*  39 */     this.Head.func_78790_a(-4.0F, -7.5F, -4.0F, 8, 8, 8, -0.5F);
/*  40 */     this.tail1 = new ModelRenderer(this, 42, 19);
/*  41 */     this.tail1.func_78793_a(0.0F, 11.4F, 1.6F);
/*  42 */     this.tail1.func_78790_a(-0.5F, -0.3F, -0.5F, 1, 3, 1, 0.0F);
/*  43 */     setRotateAngle(this.tail1, 1.0011208F, 0.0F, 0.0F);
/*  44 */     this.Head2 = new ModelRenderer(this, 32, 0);
/*  45 */     this.Head2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  46 */     this.Head2.func_78790_a(-4.0F, -7.5F, -4.0F, 8, 8, 8, 0.0F);
/*  47 */     this.ArmR = new ModelRenderer(this, 32, 35);
/*  48 */     this.ArmR.func_78793_a(-4.3F, 3.0F, 0.0F);
/*  49 */     this.ArmR.func_78790_a(-1.7F, -1.5F, -1.8F, 3, 11, 4, -0.1F);
/*  50 */     setRotateAngle(this.ArmR, 0.0F, 0.0F, 0.06981317F);
/*  51 */     this.tail4 = new ModelRenderer(this, 42, 19);
/*  52 */     this.tail4.func_78793_a(0.0F, 2.6F, 0.0F);
/*  53 */     this.tail4.func_78790_a(-0.5F, 0.2F, -0.5F, 1, 3, 1, 0.0F);
/*  54 */     setRotateAngle(this.tail4, 0.20507619F, 0.0F, 0.0F);
/*  55 */     this.tail3 = new ModelRenderer(this, 42, 19);
/*  56 */     this.tail3.func_78793_a(0.0F, 2.6F, 0.0F);
/*  57 */     this.tail3.func_78790_a(-0.5F, -0.1F, -0.5F, 1, 3, 1, 0.0F);
/*  58 */     setRotateAngle(this.tail3, -0.18203785F, 0.0F, 0.0F);
/*  59 */     this.Body3 = new ModelRenderer(this, 0, 38);
/*  60 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  61 */     this.Body3.func_78790_a(-3.5F, 8.8F, -2.0F, 7, 2, 4, 0.0F);
/*  62 */     this.Boobs = new ModelRenderer(this, 19, 31);
/*  63 */     this.Boobs.func_78793_a(0.0F, -0.3F, 0.0F);
/*  64 */     this.Boobs.func_78790_a(-3.0F, 2.0F, -0.7F, 6, 3, 2, 0.0F);
/*  65 */     setRotateAngle(this.Boobs, -0.59864795F, 0.0F, 0.0F);
/*  66 */     this.EarR = new ModelRenderer(this, 28, 1);
/*  67 */     this.EarR.func_78793_a(-3.0F, -3.4F, -0.5F);
/*  68 */     this.EarR.func_78790_a(-5.0F, -2.0F, -0.3F, 5, 5, 0, 0.0F);
/*  69 */     setRotateAngle(this.EarR, 0.0F, 0.6981317F, 0.0F);
/*  70 */     this.LegL = new ModelRenderer(this, 0, 46);
/*  71 */     this.LegL.field_78809_i = true;
/*  72 */     this.LegL.func_78793_a(1.9F, 12.0F, 0.0F);
/*  73 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, -0.1F);
/*  74 */     this.EarL = new ModelRenderer(this, 28, 1);
/*  75 */     this.EarL.field_78809_i = true;
/*  76 */     this.EarL.func_78793_a(3.0F, -3.4F, -0.5F);
/*  77 */     this.EarL.func_78790_a(0.0F, -2.0F, -0.3F, 5, 5, 0, 0.0F);
/*  78 */     setRotateAngle(this.EarL, 0.0F, -0.6981317F, 0.0F);
/*  79 */     this.tail2 = new ModelRenderer(this, 42, 19);
/*  80 */     this.tail2.func_78793_a(0.0F, 2.6F, 0.0F);
/*  81 */     this.tail2.func_78790_a(-0.5F, -0.1F, -0.5F, 1, 3, 1, 0.0F);
/*  82 */     setRotateAngle(this.tail2, -0.18203785F, 0.0F, 0.0F);
/*  83 */     this.Hair = new ModelRenderer(this, 25, 17);
/*  84 */     this.Hair.func_78793_a(0.0F, -0.1F, 3.95F);
/*  85 */     this.Hair.func_78790_a(-3.5F, -0.3F, 0.0F, 7, 7, 0, 0.0F);
/*  86 */     this.Body2 = new ModelRenderer(this, 0, 30);
/*  87 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  88 */     this.Body2.func_78790_a(-3.0F, 5.8F, -1.6F, 6, 3, 3, 0.0F);
/*  89 */     this.Body1 = new ModelRenderer(this, 0, 18);
/*  90 */     this.Body1.func_78793_a(0.0F, 1.3F, 0.0F);
/*  91 */     this.Body1.func_78790_a(-3.5F, 0.0F, -2.0F, 7, 6, 4, -0.2F);
/*  92 */     this.tail5 = new ModelRenderer(this, 42, 19);
/*  93 */     this.tail5.func_78793_a(0.0F, 3.1F, 0.0F);
/*  94 */     this.tail5.func_78790_a(-0.5F, -0.1F, -0.5F, 1, 3, 1, 0.0F);
/*  95 */     setRotateAngle(this.tail5, 0.27314404F, 0.0F, 0.0F);
/*  96 */     this.LegR = new ModelRenderer(this, 0, 46);
/*  97 */     this.LegR.func_78793_a(-1.9F, 12.0F, 0.0F);
/*  98 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, -0.1F);
/*  99 */     this.Head.func_78792_a(this.Head2);
/* 100 */     this.tail3.func_78792_a(this.tail4);
/* 101 */     this.tail2.func_78792_a(this.tail3);
/* 102 */     this.Body2.func_78792_a(this.Body3);
/* 103 */     this.Body1.func_78792_a(this.Boobs);
/* 104 */     this.Head.func_78792_a(this.EarR);
/* 105 */     this.Head.func_78792_a(this.EarL);
/* 106 */     this.tail1.func_78792_a(this.tail2);
/* 107 */     this.Head.func_78792_a(this.Hair);
/* 108 */     this.Body1.func_78792_a(this.Body2);
/* 109 */     this.tail4.func_78792_a(this.tail5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 114 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 116 */     this.Body1.func_78785_a(f5);
/* 117 */     this.ArmR.func_78785_a(f5);
/* 118 */     this.ArmL.func_78785_a(f5);
/* 119 */     this.LegL.func_78785_a(f5);
/* 120 */     this.Head.func_78785_a(f5);
/* 121 */     this.LegR.func_78785_a(f5);
/* 122 */     this.tail1.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 127 */     modelRenderer.field_78795_f = x;
/* 128 */     modelRenderer.field_78796_g = y;
/* 129 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 133 */     int calc = par7Entity.field_70173_aa;
/* 134 */     if (calc > 100) calc -= 100; 
/* 135 */     float r = 360.0F;
/* 136 */     float r2 = 180.0F;
/* 137 */     float n4 = par4;
/* 138 */     float n5 = par5;
/*     */ 
/*     */ 
/*     */     
/* 142 */     float ex = par7Entity.field_70173_aa;
/* 143 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 144 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 146 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 147 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 152 */     this.tail2.field_78795_f = 0.2F;
/* 153 */     this.tail2.field_78795_f += r4 / 2.0F;
/*     */     
/* 155 */     this.tail3.field_78795_f = 0.2F;
/* 156 */     this.tail3.field_78795_f += r4 / 2.0F;
/*     */     
/* 158 */     this.tail4.field_78795_f = 0.2F;
/* 159 */     this.tail4.field_78795_f += r4 / 2.0F;
/*     */     
/* 161 */     this.tail5.field_78796_g = 0.2F;
/* 162 */     this.tail5.field_78796_g += r4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 196 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 197 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 198 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 199 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 201 */     this.LegR.field_78796_g = 0.0F;
/* 202 */     this.LegL.field_78796_g = 0.0F;
/* 203 */     this.ArmR.field_78796_g = 0.0F;
/* 204 */     this.ArmL.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 211 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelKakunsa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */