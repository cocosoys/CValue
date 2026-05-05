/*     */ package JinRyuu.DragonBC.common.Npcs.dbkingpiccolo;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelTambourine
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer Head2;
/*     */   public ModelRenderer EarL;
/*     */   public ModelRenderer EarR;
/*     */   public ModelRenderer Cloth;
/*     */   public ModelRenderer WingL;
/*     */   public ModelRenderer WingR;
/*     */   public ModelRenderer Cloth2;
/*     */   
/*     */   public ModelTambourine() {
/*  26 */     this.field_78090_t = 128;
/*  27 */     this.field_78089_u = 64;
/*  28 */     this.Cloth2 = new ModelRenderer(this, 41, 0);
/*  29 */     this.Cloth2.func_78793_a(0.0F, 8.5F, -2.1F);
/*  30 */     this.Cloth2.func_78790_a(-3.5F, 0.0F, 0.0F, 7, 6, 0, 0.0F);
/*  31 */     setRotateAngle(this.Cloth2, -0.05235988F, 0.0F, 0.0F);
/*  32 */     this.Cloth = new ModelRenderer(this, 55, 3);
/*  33 */     this.Cloth.func_78793_a(0.0F, 9.0F, 0.4F);
/*  34 */     this.Cloth.func_78790_a(-4.5F, 0.0F, -2.3F, 9, 6, 4, 0.0F);
/*  35 */     this.ArmL = new ModelRenderer(this, 27, 17);
/*  36 */     this.ArmL.field_78809_i = true;
/*  37 */     this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
/*  38 */     this.ArmL.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
/*  39 */     this.WingR = new ModelRenderer(this, 29, 39);
/*  40 */     this.WingR.func_78793_a(-3.0F, 3.0F, 2.6F);
/*  41 */     this.WingR.func_78790_a(-19.0F, -14.0F, 0.0F, 21, 22, 0, 0.0F);
/*  42 */     setRotateAngle(this.WingR, 0.0F, 0.17453292F, 0.0F);
/*  43 */     this.EarR = new ModelRenderer(this, 32, 1);
/*  44 */     this.EarR.func_78793_a(-3.5F, -4.4F, -1.0F);
/*  45 */     this.EarR.func_78790_a(-3.5F, -2.4F, 0.0F, 3, 5, 0, 0.0F);
/*  46 */     setRotateAngle(this.EarR, 0.0F, 0.87266463F, -0.04363323F);
/*  47 */     this.Head2 = new ModelRenderer(this, 35, -1);
/*  48 */     this.Head2.func_78793_a(0.0F, -4.8F, 0.9F);
/*  49 */     this.Head2.func_78790_a(0.0F, -4.0F, -4.0F, 0, 8, 8, 0.0F);
/*  50 */     this.WingL = new ModelRenderer(this, 29, 39);
/*  51 */     this.WingL.field_78809_i = true;
/*  52 */     this.WingL.func_78793_a(1.0F, 3.0F, 2.6F);
/*  53 */     this.WingL.func_78790_a(0.0F, -14.0F, 0.0F, 21, 22, 0, 0.0F);
/*  54 */     setRotateAngle(this.WingL, 0.0F, -0.17453292F, 0.0F);
/*  55 */     this.ArmR = new ModelRenderer(this, 27, 17);
/*  56 */     this.ArmR.func_78793_a(-5.0F, 2.0F, 0.0F);
/*  57 */     this.ArmR.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
/*  58 */     this.LegR = new ModelRenderer(this, 2, 39);
/*  59 */     this.LegR.func_78793_a(-2.0F, 12.0F, 0.0F);
/*  60 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  61 */     this.LegL = new ModelRenderer(this, 2, 39);
/*  62 */     this.LegL.field_78809_i = true;
/*  63 */     this.LegL.func_78793_a(2.0F, 12.0F, 0.0F);
/*  64 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  65 */     this.EarL = new ModelRenderer(this, 32, 1);
/*  66 */     this.EarL.field_78809_i = true;
/*  67 */     this.EarL.func_78793_a(3.8F, -4.4F, -1.0F);
/*  68 */     this.EarL.func_78790_a(0.0F, -2.4F, 0.0F, 3, 5, 0, 0.0F);
/*  69 */     setRotateAngle(this.EarL, 0.0F, -0.87266463F, 0.04363323F);
/*  70 */     this.Head = new ModelRenderer(this, 0, 0);
/*  71 */     this.Head.func_78793_a(0.0F, 0.0F, 0.0F);
/*  72 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
/*  73 */     this.Body = new ModelRenderer(this, 1, 19);
/*  74 */     this.Body.func_78793_a(0.0F, 0.0F, 0.0F);
/*  75 */     this.Body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
/*  76 */     this.Body.func_78792_a(this.Cloth2);
/*  77 */     this.Body.func_78792_a(this.Cloth);
/*  78 */     this.Body.func_78792_a(this.WingR);
/*  79 */     this.Head.func_78792_a(this.EarR);
/*  80 */     this.Head.func_78792_a(this.Head2);
/*  81 */     this.Body.func_78792_a(this.WingL);
/*  82 */     this.Head.func_78792_a(this.EarL);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  87 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/*  89 */     this.Head.func_78785_a(f5);
/*     */     
/*  91 */     this.Body.func_78785_a(f5);
/*  92 */     this.ArmR.func_78785_a(f5);
/*  93 */     this.ArmL.func_78785_a(f5);
/*  94 */     this.LegL.func_78785_a(f5);
/*  95 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 105 */     modelRenderer.field_78795_f = x;
/* 106 */     modelRenderer.field_78796_g = y;
/* 107 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 111 */     int calc = par7Entity.field_70173_aa;
/* 112 */     if (calc > 100) calc -= 100; 
/* 113 */     float r = 360.0F;
/* 114 */     float r2 = 180.0F;
/* 115 */     float n4 = par4;
/* 116 */     float n5 = par5;
/*     */     
/* 118 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 119 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 120 */     float ex = par7Entity.field_70173_aa;
/* 121 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 122 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 124 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 125 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 174 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 175 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 176 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 177 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 179 */     this.LegR.field_78796_g = 0.0F;
/* 180 */     this.LegL.field_78796_g = 0.0F;
/* 181 */     this.ArmR.field_78796_g = 0.0F;
/* 182 */     this.ArmL.field_78796_g = 0.0F;
/*     */     
/* 184 */     this.Cloth2.field_78795_f = -0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/*     */     
/* 186 */     this.Cloth.field_78795_f = 0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 187 */     this.Cloth.field_78795_f = 0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 188 */     this.Cloth.field_78795_f = 0.15F + this.LegL.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 189 */     this.Cloth.field_78795_f = 0.15F + this.LegL.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 190 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbkingpiccolo\ModelTambourine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */