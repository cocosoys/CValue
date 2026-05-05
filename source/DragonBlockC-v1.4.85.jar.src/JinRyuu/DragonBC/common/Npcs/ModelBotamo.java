/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelBotamo
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer BodyBelly;
/*     */   public ModelRenderer LegR1;
/*     */   public ModelRenderer LegL1;
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer EarR;
/*     */   public ModelRenderer EarL;
/*     */   public ModelRenderer ArmR1;
/*     */   public ModelRenderer ArmL1;
/*     */   public ModelRenderer BodyBottom;
/*     */   public ModelRenderer BodyTorso;
/*     */   public ModelRenderer BodyTop;
/*     */   public ModelRenderer LegR2;
/*     */   public ModelRenderer LegR3;
/*     */   public ModelRenderer LegL2;
/*     */   public ModelRenderer LegL3;
/*     */   public ModelRenderer ArmR2;
/*     */   public ModelRenderer ArmR3;
/*     */   public ModelRenderer ArmL2;
/*     */   public ModelRenderer ArmL3;
/*     */   
/*     */   public ModelBotamo() {
/*  32 */     this.field_78090_t = 128;
/*  33 */     this.field_78089_u = 64;
/*  34 */     this.LegR1 = new ModelRenderer(this, 77, 35);
/*  35 */     this.LegR1.func_78793_a(-3.1F, 14.1F, 0.0F);
/*  36 */     this.LegR1.func_78790_a(-1.4F, -0.6F, -1.5F, 3, 4, 3, 0.0F);
/*  37 */     this.Head = new ModelRenderer(this, 71, 0);
/*  38 */     this.Head.func_78793_a(0.0F, -5.6F, 0.0F);
/*  39 */     this.Head.func_78790_a(-3.5F, -4.3F, -4.1F, 7, 5, 6, 0.0F);
/*  40 */     this.ArmL2 = new ModelRenderer(this, 95, 18);
/*  41 */     this.ArmL2.field_78809_i = true;
/*  42 */     this.ArmL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  43 */     this.ArmL2.func_78790_a(-1.7F, 0.7F, -2.6F, 3, 6, 4, 0.0F);
/*  44 */     setRotateAngle(this.ArmL2, 0.0F, 0.0F, -0.18203785F);
/*  45 */     this.BodyBelly = new ModelRenderer(this, 10, 27);
/*  46 */     this.BodyBelly.func_78793_a(0.0F, -5.6F, 0.0F);
/*  47 */     this.BodyBelly.func_78790_a(-8.5F, 7.5F, -8.0F, 17, 10, 14, 0.0F);
/*  48 */     this.LegL2 = new ModelRenderer(this, 75, 43);
/*  49 */     this.LegL2.field_78809_i = true;
/*  50 */     this.LegL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  51 */     this.LegL2.func_78790_a(-2.0F, 3.2F, -2.0F, 4, 5, 4, 0.0F);
/*  52 */     this.EarR = new ModelRenderer(this, 68, 0);
/*  53 */     this.EarR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  54 */     this.EarR.func_78790_a(-4.3F, -4.3F, -1.3F, 1, 2, 2, 0.0F);
/*  55 */     this.ArmR1 = new ModelRenderer(this, 94, 10);
/*  56 */     this.ArmR1.func_78793_a(-8.2F, -3.7F, 1.8F);
/*  57 */     this.ArmR1.func_78790_a(-1.7F, -1.6F, -2.6F, 4, 3, 4, 0.0F);
/*  58 */     this.ArmR3 = new ModelRenderer(this, 94, 29);
/*  59 */     this.ArmR3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  60 */     this.ArmR3.func_78790_a(-2.9F, 6.4F, -2.6F, 4, 8, 4, 0.0F);
/*  61 */     setRotateAngle(this.ArmR3, 0.0F, 0.0F, -0.091106184F);
/*  62 */     this.EarL = new ModelRenderer(this, 68, 0);
/*  63 */     this.EarL.field_78809_i = true;
/*  64 */     this.EarL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  65 */     this.EarL.func_78790_a(3.3F, -4.3F, -1.3F, 1, 2, 2, 0.0F);
/*  66 */     this.LegR2 = new ModelRenderer(this, 75, 43);
/*  67 */     this.LegR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  68 */     this.LegR2.func_78790_a(-2.0F, 3.2F, -2.0F, 4, 5, 4, 0.0F);
/*  69 */     this.LegL1 = new ModelRenderer(this, 77, 35);
/*  70 */     this.LegL1.field_78809_i = true;
/*  71 */     this.LegL1.func_78793_a(3.3F, 14.2F, 0.0F);
/*  72 */     this.LegL1.func_78790_a(-1.5F, -0.6F, -1.5F, 3, 4, 3, 0.0F);
/*  73 */     this.BodyBottom = new ModelRenderer(this, 19, 52);
/*  74 */     this.BodyBottom.func_78793_a(0.0F, 0.0F, 0.0F);
/*  75 */     this.BodyBottom.func_78790_a(-6.0F, 17.4F, -5.7F, 12, 2, 10, 0.0F);
/*  76 */     this.ArmR2 = new ModelRenderer(this, 95, 18);
/*  77 */     this.ArmR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  78 */     this.ArmR2.func_78790_a(-1.7F, 0.7F, -2.6F, 3, 6, 4, 0.0F);
/*  79 */     setRotateAngle(this.ArmR2, 0.0F, 0.0F, 0.18203785F);
/*  80 */     this.BodyTorso = new ModelRenderer(this, 17, 11);
/*  81 */     this.BodyTorso.func_78793_a(0.0F, 0.0F, 0.0F);
/*  82 */     this.BodyTorso.func_78790_a(-7.0F, 2.9F, -4.9F, 14, 5, 10, 0.0F);
/*  83 */     this.BodyTop = new ModelRenderer(this, 22, 0);
/*  84 */     this.BodyTop.func_78793_a(0.0F, 0.0F, 0.0F);
/*  85 */     this.BodyTop.func_78790_a(-6.0F, 0.2F, -2.6F, 12, 3, 7, 0.0F);
/*  86 */     this.LegL3 = new ModelRenderer(this, 72, 53);
/*  87 */     this.LegL3.field_78809_i = true;
/*  88 */     this.LegL3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  89 */     this.LegL3.func_78790_a(-2.5F, 8.0F, -3.9F, 5, 2, 6, 0.0F);
/*  90 */     this.ArmL3 = new ModelRenderer(this, 94, 29);
/*  91 */     this.ArmL3.field_78809_i = true;
/*  92 */     this.ArmL3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  93 */     this.ArmL3.func_78790_a(-1.4F, 6.4F, -2.6F, 4, 8, 4, 0.0F);
/*  94 */     setRotateAngle(this.ArmL3, 0.0F, 0.0F, 0.091106184F);
/*  95 */     this.LegR3 = new ModelRenderer(this, 72, 53);
/*  96 */     this.LegR3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  97 */     this.LegR3.func_78790_a(-2.5F, 8.0F, -3.9F, 5, 2, 6, 0.0F);
/*  98 */     this.ArmL1 = new ModelRenderer(this, 94, 10);
/*  99 */     this.ArmL1.field_78809_i = true;
/* 100 */     this.ArmL1.func_78793_a(8.5F, -3.7F, 1.8F);
/* 101 */     this.ArmL1.func_78790_a(-2.7F, -1.6F, -2.6F, 4, 3, 4, 0.0F);
/* 102 */     this.ArmL1.func_78792_a(this.ArmL2);
/* 103 */     this.LegL1.func_78792_a(this.LegL2);
/* 104 */     this.Head.func_78792_a(this.EarR);
/* 105 */     this.ArmR2.func_78792_a(this.ArmR3);
/* 106 */     this.Head.func_78792_a(this.EarL);
/* 107 */     this.LegR1.func_78792_a(this.LegR2);
/* 108 */     this.BodyBelly.func_78792_a(this.BodyBottom);
/* 109 */     this.ArmR1.func_78792_a(this.ArmR2);
/* 110 */     this.BodyBottom.func_78792_a(this.BodyTorso);
/* 111 */     this.BodyTorso.func_78792_a(this.BodyTop);
/* 112 */     this.LegL2.func_78792_a(this.LegL3);
/* 113 */     this.ArmL2.func_78792_a(this.ArmL3);
/* 114 */     this.LegR2.func_78792_a(this.LegR3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 119 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 122 */     this.LegL1.func_78785_a(f5);
/* 123 */     this.Head.func_78785_a(f5);
/* 124 */     this.ArmL1.func_78785_a(f5);
/* 125 */     this.ArmR1.func_78785_a(f5);
/* 126 */     this.BodyBelly.func_78785_a(f5);
/* 127 */     this.LegR1.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 132 */     modelRenderer.field_78795_f = x;
/* 133 */     modelRenderer.field_78796_g = y;
/* 134 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 138 */     int calc = par7Entity.field_70173_aa;
/* 139 */     if (calc > 100) calc -= 100; 
/* 140 */     float r = 360.0F;
/* 141 */     float r2 = 180.0F;
/* 142 */     float n4 = par4;
/* 143 */     float n5 = par5;
/*     */     
/* 145 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 146 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 147 */     float ex = par7Entity.field_70173_aa;
/* 148 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 149 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 160 */     this.LegR1.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 161 */     this.LegL1.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 162 */     this.ArmR1.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 163 */     this.ArmL1.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 164 */     this.LegR1.field_78796_g = 0.0F;
/* 165 */     this.LegL1.field_78796_g = 0.0F;
/* 166 */     this.ArmR1.field_78796_g = 0.0F;
/* 167 */     this.ArmL1.field_78796_g = 0.0F;
/* 168 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelBotamo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */