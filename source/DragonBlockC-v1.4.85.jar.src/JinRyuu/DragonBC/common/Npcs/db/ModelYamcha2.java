/*     */ package JinRyuu.DragonBC.common.Npcs.db;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelYamcha2
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer HairBack1;
/*     */   public ModelRenderer Hair;
/*     */   public ModelRenderer HairBack2;
/*     */   public ModelRenderer Hair8;
/*     */   public ModelRenderer Hair9;
/*     */   public ModelRenderer Hair1;
/*     */   public ModelRenderer Hair2;
/*     */   public ModelRenderer Hair3;
/*     */   public ModelRenderer Hair4;
/*     */   public ModelRenderer Hair5;
/*     */   public ModelRenderer Hair6;
/*     */   public ModelRenderer Hair7;
/*     */   public ModelRenderer Hair11;
/*     */   public ModelRenderer Hair12;
/*     */   public ModelRenderer Hair13;
/*     */   public ModelRenderer Hair14;
/*     */   
/*     */   public ModelYamcha2() {
/*  35 */     this.field_78090_t = 64;
/*  36 */     this.field_78089_u = 64;
/*  37 */     this.Head = new ModelRenderer(this, 0, 0);
/*  38 */     this.Head.func_78793_a(0.0F, 0.0F, 0.0F);
/*  39 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
/*  40 */     this.LegL = new ModelRenderer(this, 0, 16);
/*  41 */     this.LegL.field_78809_i = true;
/*  42 */     this.LegL.func_78793_a(1.9F, 12.0F, 0.0F);
/*  43 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  44 */     this.Hair11 = new ModelRenderer(this, 49, 0);
/*  45 */     this.Hair11.func_78793_a(2.4F, -6.6F, -2.3F);
/*  46 */     this.Hair11.func_78790_a(-1.0F, -2.6F, -0.8F, 2, 3, 3, 0.0F);
/*  47 */     setRotateAngle(this.Hair11, -0.7007497F, 0.091106184F, 1.4114478F);
/*  48 */     this.Hair8 = new ModelRenderer(this, 39, 0);
/*  49 */     this.Hair8.func_78793_a(1.5F, -0.4F, 0.0F);
/*  50 */     this.Hair8.func_78790_a(-1.0F, 0.0F, -0.7F, 2, 3, 2, 0.0F);
/*  51 */     setRotateAngle(this.Hair8, 0.17453292F, 0.0F, -0.8651597F);
/*  52 */     this.Hair13 = new ModelRenderer(this, 31, 1);
/*  53 */     this.Hair13.func_78793_a(-0.1F, -7.6F, -3.9F);
/*  54 */     this.Hair13.func_78790_a(-1.0F, -2.6F, -0.8F, 2, 3, 1, 0.0F);
/*  55 */     setRotateAngle(this.Hair13, 2.4130921F, 0.091106184F, 0.18203785F);
/*  56 */     this.Hair9 = new ModelRenderer(this, 39, 0);
/*  57 */     this.Hair9.func_78793_a(-1.4F, -0.4F, 0.0F);
/*  58 */     this.Hair9.func_78790_a(-1.1F, 0.0F, -0.7F, 2, 3, 2, 0.0F);
/*  59 */     setRotateAngle(this.Hair9, 0.27314404F, 0.0F, 0.8196066F);
/*  60 */     this.Hair7 = new ModelRenderer(this, 50, 8);
/*  61 */     this.Hair7.func_78793_a(0.2F, -7.0F, -1.9F);
/*  62 */     this.Hair7.func_78790_a(-0.5F, -2.3F, -0.8F, 1, 2, 2, 0.0F);
/*  63 */     setRotateAngle(this.Hair7, 0.0F, 0.0F, 0.3970624F);
/*  64 */     this.Hair3 = new ModelRenderer(this, 39, 0);
/*  65 */     this.Hair3.func_78793_a(-2.0F, -2.8F, 2.5F);
/*  66 */     this.Hair3.func_78790_a(-1.1F, 0.0F, -0.7F, 2, 3, 2, 0.0F);
/*  67 */     setRotateAngle(this.Hair3, 0.0F, 0.0F, 0.6953392F);
/*  68 */     this.Hair2 = new ModelRenderer(this, 37, 6);
/*  69 */     this.Hair2.func_78793_a(-1.3F, -6.7F, -2.0F);
/*  70 */     this.Hair2.func_78790_a(-4.1F, -1.6F, -0.8F, 3, 3, 2, 0.0F);
/*  71 */     setRotateAngle(this.Hair2, 0.0F, -0.47403142F, 0.043284167F);
/*  72 */     this.Hair6 = new ModelRenderer(this, 49, 0);
/*  73 */     this.Hair6.func_78793_a(0.0F, -6.5F, -1.5F);
/*  74 */     this.Hair6.func_78790_a(-1.1F, -3.4F, -0.9F, 2, 4, 3, 0.0F);
/*  75 */     setRotateAngle(this.Hair6, -0.091106184F, -0.091106184F, -0.7285004F);
/*  76 */     this.Body = new ModelRenderer(this, 16, 16);
/*  77 */     this.Body.func_78793_a(0.0F, 0.0F, 0.0F);
/*  78 */     this.Body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
/*  79 */     this.LegR = new ModelRenderer(this, 0, 16);
/*  80 */     this.LegR.func_78793_a(-1.9F, 12.0F, 0.0F);
/*  81 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  82 */     this.ArmL = new ModelRenderer(this, 40, 16);
/*  83 */     this.ArmL.field_78809_i = true;
/*  84 */     this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
/*  85 */     this.ArmL.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
/*  86 */     this.Hair4 = new ModelRenderer(this, 30, 0);
/*  87 */     this.Hair4.func_78793_a(1.9F, -7.0F, 2.1F);
/*  88 */     this.Hair4.func_78790_a(-1.0F, -2.6F, -0.8F, 2, 3, 2, 0.0F);
/*  89 */     setRotateAngle(this.Hair4, -0.22968534F, -0.2375393F, 0.93462384F);
/*  90 */     this.HairBack1 = new ModelRenderer(this, 1, 33);
/*  91 */     this.HairBack1.func_78793_a(0.0F, 0.0F, 2.7F);
/*  92 */     this.HairBack1.func_78790_a(-2.0F, 0.0F, -0.5F, 4, 3, 2, 0.0F);
/*  93 */     this.Hair1 = new ModelRenderer(this, 30, 0);
/*  94 */     this.Hair1.func_78793_a(-2.0F, -7.1F, -2.8F);
/*  95 */     this.Hair1.func_78790_a(-1.0F, -2.6F, -0.8F, 2, 3, 2, 0.0F);
/*  96 */     setRotateAngle(this.Hair1, 0.22759093F, -0.091106184F, -0.3642502F);
/*  97 */     this.Hair12 = new ModelRenderer(this, 32, 1);
/*  98 */     this.Hair12.func_78793_a(-1.6F, -7.9F, -3.9F);
/*  99 */     this.Hair12.func_78790_a(-1.0F, -2.6F, -0.8F, 1, 3, 1, 0.0F);
/* 100 */     setRotateAngle(this.Hair12, 2.5953045F, 0.13665928F, 0.18203785F);
/* 101 */     this.ArmR = new ModelRenderer(this, 40, 16);
/* 102 */     this.ArmR.func_78793_a(-5.0F, 2.0F, 0.0F);
/* 103 */     this.ArmR.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
/* 104 */     this.Hair = new ModelRenderer(this, 0, 0);
/* 105 */     this.Hair.func_78793_a(0.0F, 0.0F, 0.0F);
/* 106 */     this.Hair.func_78790_a(-0.5F, -3.0F, 0.0F, 1, 1, 1, 0.0F);
/* 107 */     this.HairBack2 = new ModelRenderer(this, 0, 40);
/* 108 */     this.HairBack2.func_78793_a(0.0F, 2.8F, 0.3F);
/* 109 */     this.HairBack2.func_78790_a(-1.5F, 0.0F, -0.5F, 3, 3, 1, 0.0F);
/* 110 */     setRotateAngle(this.HairBack2, 0.091106184F, 0.0F, 0.0F);
/* 111 */     this.Hair14 = new ModelRenderer(this, 31, 1);
/* 112 */     this.Hair14.func_78793_a(2.4F, -7.8F, -3.9F);
/* 113 */     this.Hair14.func_78790_a(-1.0F, -2.6F, -0.8F, 2, 3, 1, 0.0F);
/* 114 */     setRotateAngle(this.Hair14, 2.6862361F, -0.3642502F, -0.13665928F);
/* 115 */     this.Hair5 = new ModelRenderer(this, 39, 0);
/* 116 */     this.Hair5.func_78793_a(2.2F, -2.8F, 2.5F);
/* 117 */     this.Hair5.func_78790_a(-1.0F, -0.2F, -0.8F, 2, 3, 2, 0.0F);
/* 118 */     setRotateAngle(this.Hair5, 0.0F, 0.0F, -0.7876671F);
/* 119 */     this.Hair.func_78792_a(this.Hair11);
/* 120 */     this.HairBack1.func_78792_a(this.Hair8);
/* 121 */     this.Hair.func_78792_a(this.Hair13);
/* 122 */     this.HairBack1.func_78792_a(this.Hair9);
/* 123 */     this.Hair.func_78792_a(this.Hair7);
/* 124 */     this.Hair.func_78792_a(this.Hair3);
/* 125 */     this.Hair.func_78792_a(this.Hair2);
/* 126 */     this.Hair.func_78792_a(this.Hair6);
/* 127 */     this.Hair.func_78792_a(this.Hair4);
/* 128 */     this.Head.func_78792_a(this.HairBack1);
/* 129 */     this.Hair.func_78792_a(this.Hair1);
/* 130 */     this.Hair.func_78792_a(this.Hair12);
/* 131 */     this.Head.func_78792_a(this.Hair);
/* 132 */     this.HairBack1.func_78792_a(this.HairBack2);
/* 133 */     this.Hair.func_78792_a(this.Hair14);
/* 134 */     this.Hair.func_78792_a(this.Hair5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 139 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 141 */     this.Head.func_78785_a(f5);
/*     */     
/* 143 */     this.Body.func_78785_a(f5);
/* 144 */     this.ArmR.func_78785_a(f5);
/* 145 */     this.ArmL.func_78785_a(f5);
/* 146 */     this.LegL.func_78785_a(f5);
/* 147 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 156 */     modelRenderer.field_78795_f = x;
/* 157 */     modelRenderer.field_78796_g = y;
/* 158 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 162 */     int calc = par7Entity.field_70173_aa;
/* 163 */     if (calc > 100) calc -= 100; 
/* 164 */     float r = 360.0F;
/* 165 */     float r2 = 180.0F;
/* 166 */     float n4 = par4;
/* 167 */     float n5 = par5;
/*     */     
/* 169 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 170 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 171 */     float ex = par7Entity.field_70173_aa;
/* 172 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 173 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 175 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 176 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
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
/* 225 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 226 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 227 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 228 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 230 */     this.LegR.field_78796_g = 0.0F;
/* 231 */     this.LegL.field_78796_g = 0.0F;
/* 232 */     this.ArmR.field_78796_g = 0.0F;
/* 233 */     this.ArmL.field_78796_g = 0.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\db\ModelYamcha2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */