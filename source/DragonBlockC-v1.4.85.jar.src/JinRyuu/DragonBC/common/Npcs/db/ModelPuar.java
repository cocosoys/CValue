/*     */ package JinRyuu.DragonBC.common.Npcs.db;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelPuar
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer EarR;
/*     */   public ModelRenderer EarL;
/*     */   public ModelRenderer EarR2;
/*     */   public ModelRenderer EarL2;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer tail1;
/*     */   public ModelRenderer tail2;
/*     */   public ModelRenderer tail3;
/*     */   public ModelRenderer tail4;
/*     */   public ModelRenderer tail5;
/*     */   
/*     */   public ModelPuar() {
/*  28 */     this.field_78090_t = 64;
/*  29 */     this.field_78089_u = 64;
/*  30 */     this.EarL2 = new ModelRenderer(this, 31, 7);
/*  31 */     this.EarL2.field_78809_i = true;
/*  32 */     this.EarL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  33 */     this.EarL2.func_78790_a(0.4F, -9.3F, 0.0F, 3, 4, 0, 0.0F);
/*  34 */     setRotateAngle(this.EarL2, -0.006981317F, 0.0F, 0.0F);
/*  35 */     this.tail4 = new ModelRenderer(this, 42, 1);
/*  36 */     this.tail4.func_78793_a(0.0F, 0.2F, 2.6F);
/*  37 */     this.tail4.func_78790_a(-1.0F, -1.1F, 0.0F, 2, 2, 3, 0.0F);
/*  38 */     this.EarL = new ModelRenderer(this, 31, 1);
/*  39 */     this.EarL.field_78809_i = true;
/*  40 */     this.EarL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  41 */     this.EarL.func_78790_a(0.4F, -10.5F, 0.1F, 3, 5, 0, 0.0F);
/*  42 */     setRotateAngle(this.EarL, 0.10995574F, 0.0F, 0.0F);
/*  43 */     this.tail3 = new ModelRenderer(this, 42, 1);
/*  44 */     this.tail3.func_78793_a(0.0F, 0.0F, 2.6F);
/*  45 */     this.tail3.func_78790_a(-1.0F, -0.9F, -0.1F, 2, 2, 3, 0.0F);
/*  46 */     this.LegL = new ModelRenderer(this, 4, 37);
/*  47 */     this.LegL.field_78809_i = true;
/*  48 */     this.LegL.func_78793_a(2.4F, 22.0F, 0.3F);
/*  49 */     this.LegL.func_78790_a(-1.5F, 0.0F, -4.3F, 3, 2, 6, 0.0F);
/*  50 */     this.tail1 = new ModelRenderer(this, 42, 1);
/*  51 */     this.tail1.func_78793_a(0.0F, 5.0F, 3.3F);
/*  52 */     this.tail1.func_78790_a(-1.0F, -0.8F, -0.8F, 2, 2, 3, 0.0F);
/*  53 */     this.tail2 = new ModelRenderer(this, 42, 1);
/*  54 */     this.tail2.func_78793_a(0.0F, 0.1F, 2.2F);
/*  55 */     this.tail2.func_78790_a(-1.0F, -0.9F, -0.2F, 2, 2, 3, 0.0F);
/*  56 */     this.EarR = new ModelRenderer(this, 31, 1);
/*  57 */     this.EarR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  58 */     this.EarR.func_78790_a(-3.4F, -10.5F, -0.1F, 3, 5, 0, 0.0F);
/*  59 */     setRotateAngle(this.EarR, 0.10995574F, 0.0F, 0.0F);
/*  60 */     this.LegR = new ModelRenderer(this, 4, 37);
/*  61 */     this.LegR.func_78793_a(-2.4F, 22.0F, 0.3F);
/*  62 */     this.LegR.func_78790_a(-1.5F, 0.0F, -4.3F, 3, 2, 6, 0.0F);
/*  63 */     this.tail5 = new ModelRenderer(this, 52, 0);
/*  64 */     this.tail5.func_78793_a(0.0F, -0.1F, 2.9F);
/*  65 */     this.tail5.func_78790_a(-1.0F, -1.0F, -0.1F, 2, 2, 4, 0.0F);
/*  66 */     this.Head = new ModelRenderer(this, 0, 0);
/*  67 */     this.Head.func_78793_a(0.0F, 15.0F, 0.0F);
/*  68 */     this.Head.func_78790_a(-4.0F, -5.7F, -4.1F, 8, 6, 7, -0.2F);
/*  69 */     this.Body1 = new ModelRenderer(this, 3, 15);
/*  70 */     this.Body1.func_78793_a(0.0F, 14.7F, 0.0F);
/*  71 */     this.Body1.func_78790_a(-3.5F, 0.3F, -2.5F, 7, 3, 5, 0.0F);
/*  72 */     this.EarR2 = new ModelRenderer(this, 31, 7);
/*  73 */     this.EarR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  74 */     this.EarR2.func_78790_a(-3.4F, -9.3F, -0.2F, 3, 4, 0, 0.0F);
/*  75 */     setRotateAngle(this.EarR2, -0.006981317F, 0.0F, 0.0F);
/*  76 */     this.Body2 = new ModelRenderer(this, 1, 24);
/*  77 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  78 */     this.Body2.func_78790_a(-4.0F, 3.3F, -3.0F, 8, 4, 6, 0.0F);
/*  79 */     this.ArmL = new ModelRenderer(this, 33, 17);
/*  80 */     this.ArmL.field_78809_i = true;
/*  81 */     this.ArmL.func_78793_a(3.8F, 15.9F, 0.0F);
/*  82 */     this.ArmL.func_78790_a(-0.6F, -0.6F, -1.5F, 2, 4, 3, 0.0F);
/*  83 */     setRotateAngle(this.ArmL, 0.0F, 0.0F, -0.21327923F);
/*  84 */     this.ArmR = new ModelRenderer(this, 33, 17);
/*  85 */     this.ArmR.func_78793_a(-3.8F, 15.9F, 0.0F);
/*  86 */     this.ArmR.func_78790_a(-1.5F, -0.6F, -1.4F, 2, 4, 3, 0.0F);
/*  87 */     setRotateAngle(this.ArmR, 0.0F, 0.0F, 0.1972222F);
/*  88 */     this.EarL.func_78792_a(this.EarL2);
/*  89 */     this.tail3.func_78792_a(this.tail4);
/*  90 */     this.Head.func_78792_a(this.EarL);
/*  91 */     this.tail2.func_78792_a(this.tail3);
/*  92 */     this.Body1.func_78792_a(this.tail1);
/*  93 */     this.tail1.func_78792_a(this.tail2);
/*  94 */     this.Head.func_78792_a(this.EarR);
/*  95 */     this.tail4.func_78792_a(this.tail5);
/*  96 */     this.EarR.func_78792_a(this.EarR2);
/*  97 */     this.Body1.func_78792_a(this.Body2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 102 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 104 */     this.Head.func_78785_a(f5);
/* 105 */     this.Body1.func_78785_a(f5);
/* 106 */     this.ArmR.func_78785_a(f5);
/* 107 */     this.ArmL.func_78785_a(f5);
/* 108 */     this.LegL.func_78785_a(f5);
/* 109 */     this.LegR.func_78785_a(f5);
/*     */   }
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
/* 140 */     this.tail1.field_78795_f = 0.2F;
/* 141 */     this.tail1.field_78795_f += r4 / 2.0F;
/*     */     
/* 143 */     this.tail2.field_78795_f = 0.2F;
/* 144 */     this.tail2.field_78795_f += r4 / 2.0F;
/*     */     
/* 146 */     this.tail3.field_78795_f = 0.2F;
/* 147 */     this.tail3.field_78795_f += r4 / 2.0F;
/*     */     
/* 149 */     this.tail4.field_78795_f = 0.2F;
/* 150 */     this.tail4.field_78795_f += r4 / 2.0F;
/*     */     
/* 152 */     this.tail5.field_78796_g = 0.2F;
/* 153 */     this.tail5.field_78796_g += r4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 189 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 190 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 192 */     this.LegR.field_78796_g = 0.0F;
/* 193 */     this.LegL.field_78796_g = 0.0F;
/* 194 */     this.ArmR.field_78796_g = 0.0F;
/* 195 */     this.ArmL.field_78796_g = 0.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\db\ModelPuar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */