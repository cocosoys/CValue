/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelSorrel
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer Hat1;
/*     */   public ModelRenderer EarR;
/*     */   public ModelRenderer EarL;
/*     */   public ModelRenderer Hat2;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Scarf;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer tail;
/*     */   public ModelRenderer Scarf2;
/*     */   public ModelRenderer Scarf3;
/*     */   public ModelRenderer LegR2;
/*     */   public ModelRenderer LegL2;
/*     */   
/*     */   public ModelSorrel() {
/*  30 */     this.field_78090_t = 64;
/*  31 */     this.field_78089_u = 64;
/*  32 */     this.Scarf = new ModelRenderer(this, 43, 8);
/*  33 */     this.Scarf.func_78793_a(0.0F, 0.0F, 0.0F);
/*  34 */     this.Scarf.func_78790_a(-2.5F, -0.5F, -2.5F, 5, 1, 5, 0.0F);
/*  35 */     this.Hat2 = new ModelRenderer(this, 37, 48);
/*  36 */     this.Hat2.func_78793_a(0.0F, 0.6F, -4.0F);
/*  37 */     this.Hat2.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 0, 2, 0.0F);
/*  38 */     setRotateAngle(this.Hat2, 0.33056536F, 0.0F, 0.0F);
/*  39 */     this.tail = new ModelRenderer(this, 23, 39);
/*  40 */     this.tail.func_78793_a(0.0F, 8.4F, 1.8F);
/*  41 */     this.tail.func_78790_a(-1.0F, -1.0F, -0.2F, 2, 2, 2, 0.0F);
/*  42 */     setRotateAngle(this.tail, -0.045553092F, 0.0F, 0.0F);
/*  43 */     this.Body1 = new ModelRenderer(this, 0, 17);
/*  44 */     this.Body1.func_78793_a(0.0F, 2.6F, 0.0F);
/*  45 */     this.Body1.func_78790_a(-3.0F, 0.0F, -1.9F, 6, 5, 4, -0.2F);
/*  46 */     this.Scarf2 = new ModelRenderer(this, 55, 16);
/*  47 */     this.Scarf2.func_78793_a(1.0F, 0.2F, 2.4F);
/*  48 */     this.Scarf2.func_78790_a(-1.4F, 0.0F, 0.0F, 3, 7, 0, 0.0F);
/*  49 */     setRotateAngle(this.Scarf2, 0.1675516F, 0.0F, 0.0F);
/*  50 */     this.Body2 = new ModelRenderer(this, 0, 27);
/*  51 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  52 */     this.Body2.func_78790_a(-2.5F, 4.8F, -1.6F, 5, 3, 3, 0.0F);
/*  53 */     this.LegR2 = new ModelRenderer(this, 0, 41);
/*  54 */     this.LegR2.func_78793_a(0.0F, 0.5F, 0.0F);
/*  55 */     this.LegR2.func_78790_a(-2.0F, -0.3F, -2.5F, 4, 4, 5, 0.0F);
/*  56 */     setRotateAngle(this.LegR2, 0.0F, 0.0F, 0.04363323F);
/*  57 */     this.Hat1 = new ModelRenderer(this, 31, 51);
/*  58 */     this.Hat1.func_78793_a(0.0F, -3.9F, 0.0F);
/*  59 */     this.Hat1.func_78790_a(-4.0F, -3.4F, -4.0F, 8, 4, 8, 0.0F);
/*  60 */     setRotateAngle(this.Hat1, -0.09128072F, 0.089186326F, 0.0F);
/*  61 */     this.EarL = new ModelRenderer(this, 35, 1);
/*  62 */     this.EarL.field_78809_i = true;
/*  63 */     this.EarL.func_78793_a(3.1F, -5.7F, 0.0F);
/*  64 */     this.EarL.func_78790_a(-2.0F, -8.5F, 0.0F, 4, 9, 0, 0.0F);
/*  65 */     setRotateAngle(this.EarL, -0.17453292F, 0.0F, 0.08726646F);
/*  66 */     this.LegR = new ModelRenderer(this, 0, 51);
/*  67 */     this.LegR.func_78793_a(-1.6F, 12.0F, 0.0F);
/*  68 */     this.LegR.func_78790_a(-1.4F, 3.2F, -2.0F, 3, 9, 4, -0.2F);
/*  69 */     this.Body3 = new ModelRenderer(this, 0, 34);
/*  70 */     this.Body3.func_78793_a(0.0F, 0.5F, 0.0F);
/*  71 */     this.Body3.func_78790_a(-3.0F, 7.3F, -2.0F, 6, 2, 4, 0.0F);
/*  72 */     this.Head = new ModelRenderer(this, 0, 0);
/*  73 */     this.Head.func_78793_a(0.0F, 2.5F, 0.0F);
/*  74 */     this.Head.func_78790_a(-4.0F, -7.5F, -4.0F, 8, 8, 8, -0.7F);
/*  75 */     this.LegL2 = new ModelRenderer(this, 0, 41);
/*  76 */     this.LegL2.field_78809_i = true;
/*  77 */     this.LegL2.func_78793_a(0.0F, 0.5F, 0.0F);
/*  78 */     this.LegL2.func_78790_a(-2.0F, -0.3F, -2.5F, 4, 4, 5, 0.0F);
/*  79 */     setRotateAngle(this.LegL2, 0.0F, 0.0F, -0.04363323F);
/*  80 */     this.LegL = new ModelRenderer(this, 0, 51);
/*  81 */     this.LegL.field_78809_i = true;
/*  82 */     this.LegL.func_78793_a(1.8F, 12.0F, 0.0F);
/*  83 */     this.LegL.func_78790_a(-1.6F, 3.2F, -2.0F, 3, 9, 4, -0.2F);
/*  84 */     this.Scarf3 = new ModelRenderer(this, 55, 23);
/*  85 */     this.Scarf3.func_78793_a(0.0F, 6.8F, 0.0F);
/*  86 */     this.Scarf3.func_78790_a(-1.4F, 0.0F, 0.0F, 3, 10, 0, 0.0F);
/*  87 */     setRotateAngle(this.Scarf3, 0.0837758F, 0.0F, 0.0F);
/*  88 */     this.ArmR = new ModelRenderer(this, 23, 20);
/*  89 */     this.ArmR.func_78793_a(-3.8F, 3.8F, 0.0F);
/*  90 */     this.ArmR.func_78790_a(-1.7F, -1.3F, -1.8F, 3, 11, 4, -0.3F);
/*  91 */     setRotateAngle(this.ArmR, 0.0F, 0.0F, 0.06981317F);
/*  92 */     this.EarR = new ModelRenderer(this, 35, 1);
/*  93 */     this.EarR.func_78793_a(-3.4F, -5.7F, 0.0F);
/*  94 */     this.EarR.func_78790_a(-2.0F, -8.5F, 0.0F, 4, 9, 0, 0.0F);
/*  95 */     setRotateAngle(this.EarR, -0.17453292F, 0.0F, -0.08726646F);
/*  96 */     this.ArmL = new ModelRenderer(this, 38, 20);
/*  97 */     this.ArmL.func_78793_a(3.8F, 3.8F, 0.0F);
/*  98 */     this.ArmL.func_78790_a(-1.3F, -1.3F, -1.8F, 3, 11, 4, -0.3F);
/*  99 */     setRotateAngle(this.ArmL, 0.0F, 0.0F, -0.06981317F);
/* 100 */     this.Body1.func_78792_a(this.Scarf);
/* 101 */     this.Hat1.func_78792_a(this.Hat2);
/* 102 */     this.Body3.func_78792_a(this.tail);
/* 103 */     this.Scarf.func_78792_a(this.Scarf2);
/* 104 */     this.Body1.func_78792_a(this.Body2);
/* 105 */     this.LegR.func_78792_a(this.LegR2);
/* 106 */     this.Head.func_78792_a(this.Hat1);
/* 107 */     this.Head.func_78792_a(this.EarL);
/* 108 */     this.Body2.func_78792_a(this.Body3);
/* 109 */     this.LegL.func_78792_a(this.LegL2);
/* 110 */     this.Scarf2.func_78792_a(this.Scarf3);
/* 111 */     this.Head.func_78792_a(this.EarR);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 116 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 118 */     this.ArmR.func_78785_a(f5);
/* 119 */     this.Head.func_78785_a(f5);
/* 120 */     this.ArmL.func_78785_a(f5);
/* 121 */     this.Body1.func_78785_a(f5);
/* 122 */     this.LegL.func_78785_a(f5);
/* 123 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 129 */     modelRenderer.field_78795_f = x;
/* 130 */     modelRenderer.field_78796_g = y;
/* 131 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 135 */     int calc = par7Entity.field_70173_aa;
/* 136 */     if (calc > 100) calc -= 100; 
/* 137 */     float r = 360.0F;
/* 138 */     float r2 = 180.0F;
/* 139 */     float n4 = par4;
/* 140 */     float n5 = par5;
/*     */ 
/*     */ 
/*     */     
/* 144 */     float ex = par7Entity.field_70173_aa;
/* 145 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 146 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 148 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 149 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 189 */     this.Scarf2.field_78795_f = -0.15F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 190 */     if (0.0F > this.Scarf2.field_78795_f) this.Scarf2.field_78795_f *= -1.0F; 
/* 191 */     this.Scarf2.field_78796_g = 0.0F;
/*     */     
/* 193 */     this.Scarf3.field_78795_f = -0.15F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 194 */     if (0.0F > this.Scarf3.field_78795_f) this.Scarf3.field_78795_f *= -1.0F; 
/* 195 */     this.Scarf3.field_78796_g = 0.0F;
/*     */ 
/*     */     
/* 198 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 199 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 200 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 201 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 203 */     this.LegR.field_78796_g = 0.0F;
/* 204 */     this.LegL.field_78796_g = 0.0F;
/* 205 */     this.ArmR.field_78796_g = 0.0F;
/* 206 */     this.ArmL.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 213 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelSorrel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */