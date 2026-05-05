/*     */ package JinRyuu.DragonBC.common.Npcs.dbredribbon;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelLaunch
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer HairBack1;
/*     */   public ModelRenderer Hair;
/*     */   public ModelRenderer Ribbon;
/*     */   public ModelRenderer HairBack2;
/*     */   public ModelRenderer Hair1;
/*     */   public ModelRenderer Hair2;
/*     */   public ModelRenderer Hair3;
/*     */   public ModelRenderer Hair4;
/*     */   public ModelRenderer Hair5;
/*     */   public ModelRenderer Hair6;
/*     */   public ModelRenderer Hair7;
/*     */   public ModelRenderer HairFront;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Boobs;
/*     */   public ModelRenderer Body3;
/*     */   
/*     */   public ModelLaunch() {
/*  34 */     this.field_78090_t = 64;
/*  35 */     this.field_78089_u = 64;
/*  36 */     this.Body2 = new ModelRenderer(this, 0, 30);
/*  37 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  38 */     this.Body2.func_78790_a(-3.0F, 5.8F, -1.6F, 6, 3, 3, 0.0F);
/*  39 */     this.LegL = new ModelRenderer(this, 0, 46);
/*  40 */     this.LegL.field_78809_i = true;
/*  41 */     this.LegL.func_78793_a(1.9F, 12.0F, 0.0F);
/*  42 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, -0.1F);
/*  43 */     this.Hair6 = new ModelRenderer(this, 49, 7);
/*  44 */     this.Hair6.func_78793_a(0.0F, -6.6F, -0.2F);
/*  45 */     this.Hair6.func_78790_a(-1.1F, -3.4F, -0.9F, 2, 4, 3, 0.0F);
/*  46 */     setRotateAngle(this.Hair6, -0.091106184F, -0.091106184F, -0.7285004F);
/*  47 */     this.HairBack2 = new ModelRenderer(this, 47, 33);
/*  48 */     this.HairBack2.func_78793_a(0.0F, 3.9F, 0.3F);
/*  49 */     this.HairBack2.func_78790_a(-2.9F, 0.0F, -0.5F, 6, 3, 1, 0.0F);
/*  50 */     setRotateAngle(this.HairBack2, 0.091106184F, 0.0F, 0.0F);
/*  51 */     this.HairFront = new ModelRenderer(this, 41, 15);
/*  52 */     this.HairFront.func_78793_a(0.2F, -6.7F, -3.6F);
/*  53 */     this.HairFront.func_78790_a(-6.1F, -1.0F, 0.0F, 11, 7, 0, 0.0F);
/*  54 */     this.Hair3 = new ModelRenderer(this, 39, 0);
/*  55 */     this.Hair3.func_78793_a(-2.5F, -2.0F, 2.0F);
/*  56 */     this.Hair3.func_78790_a(-1.1F, 0.0F, -0.7F, 2, 3, 2, 0.0F);
/*  57 */     setRotateAngle(this.Hair3, 0.0F, 0.0F, 0.6953392F);
/*  58 */     this.Hair = new ModelRenderer(this, 0, 0);
/*  59 */     this.Hair.func_78793_a(0.0F, 0.0F, 0.0F);
/*  60 */     this.Hair.func_78790_a(-0.5F, -3.0F, 0.0F, 1, 1, 1, 0.0F);
/*  61 */     this.Hair2 = new ModelRenderer(this, 37, 6);
/*  62 */     this.Hair2.func_78793_a(-1.1F, -6.2F, 1.7F);
/*  63 */     this.Hair2.func_78790_a(-3.8F, -1.6F, -0.8F, 3, 3, 2, 0.0F);
/*  64 */     setRotateAngle(this.Hair2, 0.0F, -0.47403142F, 0.043284167F);
/*  65 */     this.Boobs = new ModelRenderer(this, 19, 31);
/*  66 */     this.Boobs.func_78793_a(0.0F, -0.5F, 0.0F);
/*  67 */     this.Boobs.func_78790_a(-3.0F, 1.8F, -0.4F, 6, 3, 2, 0.0F);
/*  68 */     setRotateAngle(this.Boobs, -0.59864795F, 0.0F, 0.0F);
/*  69 */     this.ArmR = new ModelRenderer(this, 18, 47);
/*  70 */     this.ArmR.func_78793_a(-4.3F, 3.0F, 0.0F);
/*  71 */     this.ArmR.func_78790_a(-1.9F, -1.5F, -1.8F, 3, 11, 4, -0.1F);
/*  72 */     this.Body3 = new ModelRenderer(this, 0, 38);
/*  73 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  74 */     this.Body3.func_78790_a(-3.5F, 8.8F, -2.0F, 7, 2, 4, 0.0F);
/*  75 */     this.Ribbon = new ModelRenderer(this, 24, 18);
/*  76 */     this.Ribbon.func_78793_a(3.5F, -6.0F, -2.1F);
/*  77 */     this.Ribbon.func_78790_a(0.0F, -2.8F, 0.0F, 6, 7, 0, 0.0F);
/*  78 */     setRotateAngle(this.Ribbon, 0.0F, -0.4098033F, 0.0F);
/*  79 */     this.Hair4 = new ModelRenderer(this, 39, 0);
/*  80 */     this.Hair4.func_78793_a(0.3F, -5.6F, 1.1F);
/*  81 */     this.Hair4.func_78790_a(-1.0F, -2.6F, -0.8F, 2, 2, 2, 0.0F);
/*  82 */     setRotateAngle(this.Hair4, -0.22968534F, -0.2375393F, -0.091106184F);
/*  83 */     this.Hair7 = new ModelRenderer(this, 49, 0);
/*  84 */     this.Hair7.func_78793_a(1.3F, -6.0F, -0.2F);
/*  85 */     this.Hair7.func_78790_a(-1.0F, -2.6F, -0.8F, 3, 3, 3, 0.0F);
/*  86 */     setRotateAngle(this.Hair7, 0.0F, 0.0F, 1.1383038F);
/*  87 */     this.HairBack1 = new ModelRenderer(this, 39, 26);
/*  88 */     this.HairBack1.func_78793_a(0.0F, -0.4F, 2.3F);
/*  89 */     this.HairBack1.func_78790_a(-4.5F, 0.0F, -0.5F, 9, 4, 2, 0.0F);
/*  90 */     this.LegR = new ModelRenderer(this, 0, 46);
/*  91 */     this.LegR.func_78793_a(-1.9F, 12.0F, 0.0F);
/*  92 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, -0.1F);
/*  93 */     this.Body = new ModelRenderer(this, 0, 18);
/*  94 */     this.Body.func_78793_a(0.0F, 1.3F, 0.0F);
/*  95 */     this.Body.func_78790_a(-3.5F, 0.0F, -2.0F, 7, 6, 4, -0.2F);
/*  96 */     this.Hair1 = new ModelRenderer(this, 39, 0);
/*  97 */     this.Hair1.func_78793_a(-2.0F, -6.8F, -1.5F);
/*  98 */     this.Hair1.func_78790_a(-1.0F, -2.6F, -0.8F, 2, 3, 2, 0.0F);
/*  99 */     setRotateAngle(this.Hair1, -0.22759093F, -0.091106184F, -1.2292354F);
/* 100 */     this.Head = new ModelRenderer(this, 0, 0);
/* 101 */     this.Head.func_78793_a(0.0F, 1.5F, 0.0F);
/* 102 */     this.Head.func_78790_a(-4.0F, -7.5F, -4.0F, 8, 8, 8, -0.5F);
/* 103 */     this.ArmL = new ModelRenderer(this, 18, 47);
/* 104 */     this.ArmL.field_78809_i = true;
/* 105 */     this.ArmL.func_78793_a(4.3F, 3.0F, 0.0F);
/* 106 */     this.ArmL.func_78790_a(-1.1F, -1.5F, -1.8F, 3, 11, 4, -0.1F);
/* 107 */     this.Hair5 = new ModelRenderer(this, 39, 0);
/* 108 */     this.Hair5.func_78793_a(2.4F, -2.1F, 2.0F);
/* 109 */     this.Hair5.func_78790_a(-1.0F, -0.2F, -0.8F, 2, 3, 2, 0.0F);
/* 110 */     setRotateAngle(this.Hair5, 0.0F, 0.011913514F, -0.7876671F);
/* 111 */     this.Body.func_78792_a(this.Body2);
/* 112 */     this.Hair.func_78792_a(this.Hair6);
/* 113 */     this.HairBack1.func_78792_a(this.HairBack2);
/* 114 */     this.Hair.func_78792_a(this.HairFront);
/* 115 */     this.Hair.func_78792_a(this.Hair3);
/* 116 */     this.Head.func_78792_a(this.Hair);
/* 117 */     this.Hair.func_78792_a(this.Hair2);
/* 118 */     this.Body.func_78792_a(this.Boobs);
/* 119 */     this.Body2.func_78792_a(this.Body3);
/* 120 */     this.Head.func_78792_a(this.Ribbon);
/* 121 */     this.Hair.func_78792_a(this.Hair4);
/* 122 */     this.Hair.func_78792_a(this.Hair7);
/* 123 */     this.Head.func_78792_a(this.HairBack1);
/* 124 */     this.Hair.func_78792_a(this.Hair1);
/* 125 */     this.Hair.func_78792_a(this.Hair5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 130 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 132 */     this.Head.func_78785_a(f5);
/*     */     
/* 134 */     this.Body.func_78785_a(f5);
/* 135 */     this.ArmR.func_78785_a(f5);
/* 136 */     this.ArmL.func_78785_a(f5);
/* 137 */     this.LegL.func_78785_a(f5);
/* 138 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 147 */     modelRenderer.field_78795_f = x;
/* 148 */     modelRenderer.field_78796_g = y;
/* 149 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 153 */     int calc = par7Entity.field_70173_aa;
/* 154 */     if (calc > 100) calc -= 100; 
/* 155 */     float r = 360.0F;
/* 156 */     float r2 = 180.0F;
/* 157 */     float n4 = par4;
/* 158 */     float n5 = par5;
/*     */     
/* 160 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 161 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 162 */     float ex = par7Entity.field_70173_aa;
/* 163 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 164 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 166 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 167 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
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
/* 216 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 217 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 218 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 219 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 221 */     this.LegR.field_78796_g = 0.0F;
/* 222 */     this.LegL.field_78796_g = 0.0F;
/* 223 */     this.ArmR.field_78796_g = 0.0F;
/* 224 */     this.ArmL.field_78796_g = 0.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbredribbon\ModelLaunch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */