/*     */ package JinRyuu.DragonBC.common.Npcs.dbkingpiccolo;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelDrum
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmR1;
/*     */   public ModelRenderer ArmL1;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer EarR;
/*     */   public ModelRenderer EarL;
/*     */   public ModelRenderer Head_1;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Chest;
/*     */   public ModelRenderer Cloth2;
/*     */   public ModelRenderer Cloth;
/*     */   public ModelRenderer ArmR2;
/*     */   public ModelRenderer ArmL2;
/*     */   
/*     */   public ModelDrum() {
/*  28 */     this.field_78090_t = 128;
/*  29 */     this.field_78089_u = 64;
/*  30 */     this.LegL = new ModelRenderer(this, 96, 33);
/*  31 */     this.LegL.field_78809_i = true;
/*  32 */     this.LegL.func_78793_a(3.6F, 10.0F, 1.0F);
/*  33 */     this.LegL.func_78790_a(-3.5F, 0.0F, -3.5F, 7, 14, 8, 0.1F);
/*  34 */     this.Cloth2 = new ModelRenderer(this, 50, 42);
/*  35 */     this.Cloth2.func_78793_a(0.0F, 12.0F, -3.1F);
/*  36 */     this.Cloth2.func_78790_a(-3.5F, 0.0F, 0.0F, 7, 6, 0, 0.0F);
/*  37 */     setRotateAngle(this.Cloth2, -0.05235988F, 0.0F, 0.0F);
/*  38 */     this.EarR = new ModelRenderer(this, 32, 1);
/*  39 */     this.EarR.func_78793_a(-3.5F, -4.4F, -1.0F);
/*  40 */     this.EarR.func_78790_a(-3.5F, -2.4F, 0.0F, 3, 5, 0, 0.0F);
/*  41 */     setRotateAngle(this.EarR, 0.0F, 0.87266463F, -0.04363323F);
/*  42 */     this.Chest = new ModelRenderer(this, 47, 31);
/*  43 */     this.Chest.func_78793_a(0.0F, 4.2F, -1.5F);
/*  44 */     this.Chest.func_78790_a(-7.0F, -2.1F, -1.4F, 14, 5, 2, 0.0F);
/*  45 */     setRotateAngle(this.Chest, -0.05235988F, 0.0F, 0.0F);
/*  46 */     this.ArmL1 = new ModelRenderer(this, 92, 1);
/*  47 */     this.ArmL1.field_78809_i = true;
/*  48 */     this.ArmL1.func_78793_a(8.8F, -2.5F, 1.7F);
/*  49 */     this.ArmL1.func_78790_a(-1.5F, -2.0F, -2.5F, 5, 8, 5, 0.0F);
/*  50 */     setRotateAngle(this.ArmL1, 0.0F, 0.0F, -0.20943952F);
/*  51 */     this.Head = new ModelRenderer(this, 0, 0);
/*  52 */     this.Head.func_78793_a(0.0F, -4.4F, 0.3F);
/*  53 */     this.Head.func_78790_a(-4.0F, -6.0F, -4.0F, 8, 6, 8, 0.0F);
/*  54 */     this.LegR = new ModelRenderer(this, 96, 33);
/*  55 */     this.LegR.func_78793_a(-3.6F, 10.0F, 1.0F);
/*  56 */     this.LegR.func_78790_a(-3.5F, 0.0F, -3.5F, 7, 14, 8, 0.1F);
/*  57 */     this.Head_1 = new ModelRenderer(this, 35, 0);
/*  58 */     this.Head_1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  59 */     this.Head_1.func_78790_a(0.0F, -7.5F, -3.1F, 0, 6, 8, 0.0F);
/*  60 */     this.Cloth = new ModelRenderer(this, 2, 51);
/*  61 */     this.Cloth.func_78793_a(0.0F, 12.9F, 3.0F);
/*  62 */     this.Cloth.func_78790_a(-8.0F, -0.9F, -2.9F, 16, 7, 6, 0.0F);
/*  63 */     this.ArmL2 = new ModelRenderer(this, 90, 15);
/*  64 */     this.ArmL2.field_78809_i = true;
/*  65 */     this.ArmL2.func_78793_a(0.6F, 5.3F, -0.3F);
/*  66 */     this.ArmL2.func_78790_a(-2.5F, -0.5F, -2.5F, 6, 9, 6, 0.0F);
/*  67 */     setRotateAngle(this.ArmL2, -0.4098033F, 0.0F, 0.08726646F);
/*  68 */     this.ArmR2 = new ModelRenderer(this, 90, 15);
/*  69 */     this.ArmR2.func_78793_a(-0.6F, 5.3F, -0.3F);
/*  70 */     this.ArmR2.func_78790_a(-3.5F, -0.5F, -2.5F, 6, 9, 6, 0.0F);
/*  71 */     setRotateAngle(this.ArmR2, -0.4098033F, 0.0F, -0.08726646F);
/*  72 */     this.EarL = new ModelRenderer(this, 32, 1);
/*  73 */     this.EarL.field_78809_i = true;
/*  74 */     this.EarL.func_78793_a(3.8F, -4.4F, -1.0F);
/*  75 */     this.EarL.func_78790_a(0.0F, -2.4F, 0.0F, 3, 5, 0, 0.0F);
/*  76 */     setRotateAngle(this.EarL, 0.0F, -0.87266463F, 0.04363323F);
/*  77 */     this.Body2 = new ModelRenderer(this, 0, 34);
/*  78 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  79 */     this.Body2.func_78790_a(-7.5F, 8.0F, -3.1F, 15, 7, 9, 0.0F);
/*  80 */     this.Body1 = new ModelRenderer(this, 0, 16);
/*  81 */     this.Body1.func_78793_a(0.0F, -5.0F, 0.0F);
/*  82 */     this.Body1.func_78790_a(-7.5F, 0.0F, -2.4F, 15, 8, 8, 0.0F);
/*  83 */     this.ArmR1 = new ModelRenderer(this, 92, 1);
/*  84 */     this.ArmR1.func_78793_a(-8.8F, -2.5F, 1.7F);
/*  85 */     this.ArmR1.func_78790_a(-3.5F, -2.0F, -2.5F, 5, 8, 5, 0.0F);
/*  86 */     setRotateAngle(this.ArmR1, 0.0F, 0.0F, 0.20943952F);
/*  87 */     this.Body2.func_78792_a(this.Cloth2);
/*  88 */     this.Head.func_78792_a(this.EarR);
/*  89 */     this.Body1.func_78792_a(this.Chest);
/*  90 */     this.Head.func_78792_a(this.Head_1);
/*  91 */     this.Body2.func_78792_a(this.Cloth);
/*  92 */     this.ArmL1.func_78792_a(this.ArmL2);
/*  93 */     this.ArmR1.func_78792_a(this.ArmR2);
/*  94 */     this.Head.func_78792_a(this.EarL);
/*  95 */     this.Body1.func_78792_a(this.Body2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 100 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 102 */     this.Head.func_78785_a(f5);
/*     */     
/* 104 */     this.Body1.func_78785_a(f5);
/* 105 */     this.ArmR1.func_78785_a(f5);
/* 106 */     this.ArmL1.func_78785_a(f5);
/* 107 */     this.LegL.func_78785_a(f5);
/* 108 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 118 */     modelRenderer.field_78795_f = x;
/* 119 */     modelRenderer.field_78796_g = y;
/* 120 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 124 */     int calc = par7Entity.field_70173_aa;
/* 125 */     if (calc > 100) calc -= 100; 
/* 126 */     float r = 360.0F;
/* 127 */     float r2 = 180.0F;
/* 128 */     float n4 = par4;
/* 129 */     float n5 = par5;
/*     */     
/* 131 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 132 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 133 */     float ex = par7Entity.field_70173_aa;
/* 134 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 135 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 137 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 138 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 187 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 188 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 189 */     this.ArmR1.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 190 */     this.ArmL1.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 192 */     this.LegR.field_78796_g = 0.0F;
/* 193 */     this.LegL.field_78796_g = 0.0F;
/* 194 */     this.ArmR1.field_78796_g = 0.0F;
/* 195 */     this.ArmL1.field_78796_g = 0.0F;
/*     */     
/* 197 */     this.Cloth2.field_78795_f = -0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/*     */     
/* 199 */     this.Cloth.field_78795_f = 0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 200 */     this.Cloth.field_78795_f = 0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 201 */     this.Cloth.field_78795_f = 0.15F + this.LegL.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 202 */     this.Cloth.field_78795_f = 0.15F + this.LegL.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 203 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbkingpiccolo\ModelDrum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */