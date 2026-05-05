/*     */ package JinRyuu.DragonBC.common.Npcs.db;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelYamcha
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
/*     */   public ModelRenderer Hair1;
/*     */   public ModelRenderer Hair2;
/*     */   public ModelRenderer Hair3;
/*     */   public ModelRenderer Hair4;
/*     */   public ModelRenderer Hair5;
/*     */   public ModelRenderer Hair6;
/*     */   public ModelRenderer Hair7;
/*     */   public ModelRenderer Hair8;
/*     */   public ModelRenderer Hair9;
/*     */   public ModelRenderer Hair11;
/*     */   public ModelRenderer Hair12;
/*     */   public ModelRenderer Hair13;
/*     */   public ModelRenderer Hair14;
/*     */   public ModelRenderer HairR1;
/*     */   public ModelRenderer HairL1;
/*     */   public ModelRenderer HairR2;
/*     */   public ModelRenderer HairR3;
/*     */   public ModelRenderer HairL2;
/*     */   public ModelRenderer HairL3;
/*     */   
/*     */   public ModelYamcha() {
/*  41 */     this.field_78090_t = 64;
/*  42 */     this.field_78089_u = 64;
/*  43 */     this.Hair4 = new ModelRenderer(this, 39, 0);
/*  44 */     this.Hair4.func_78793_a(2.3F, -6.9F, 1.9F);
/*  45 */     this.Hair4.func_78790_a(-1.0F, -2.6F, -0.8F, 2, 3, 2, 0.0F);
/*  46 */     setRotateAngle(this.Hair4, -0.22965898F, -0.23751295F, 0.93466526F);
/*  47 */     this.Head = new ModelRenderer(this, 0, 0);
/*  48 */     this.Head.func_78793_a(0.0F, 0.0F, 0.0F);
/*  49 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
/*  50 */     this.HairR1 = new ModelRenderer(this, 57, 8);
/*  51 */     this.HairR1.func_78793_a(-4.0F, -5.0F, -2.3F);
/*  52 */     this.HairR1.func_78790_a(-0.6F, -0.3F, -0.5F, 1, 3, 1, 0.0F);
/*  53 */     setRotateAngle(this.HairR1, -0.13665928F, 0.0F, 0.045553092F);
/*  54 */     this.Hair1 = new ModelRenderer(this, 39, 0);
/*  55 */     this.Hair1.func_78793_a(-2.0F, -7.6F, -3.3F);
/*  56 */     this.Hair1.func_78790_a(-1.0F, -2.6F, -0.8F, 2, 3, 2, 0.0F);
/*  57 */     setRotateAngle(this.Hair1, 0.22759093F, -0.091106184F, -0.3642502F);
/*  58 */     this.Hair = new ModelRenderer(this, 0, 0);
/*  59 */     this.Hair.func_78793_a(0.0F, 0.0F, 0.0F);
/*  60 */     this.Hair.func_78790_a(-0.5F, -3.0F, 0.0F, 1, 1, 1, 0.0F);
/*  61 */     this.Hair12 = new ModelRenderer(this, 40, 1);
/*  62 */     this.Hair12.func_78793_a(-1.3F, -6.9F, -3.9F);
/*  63 */     this.Hair12.func_78790_a(-1.0F, -2.6F, -0.8F, 1, 3, 1, 0.0F);
/*  64 */     setRotateAngle(this.Hair12, 2.5953045F, 0.13665928F, 0.18203785F);
/*  65 */     this.Hair11 = new ModelRenderer(this, 49, 0);
/*  66 */     this.Hair11.func_78793_a(3.0F, -6.2F, -2.3F);
/*  67 */     this.Hair11.func_78790_a(-1.0F, -2.6F, -0.8F, 2, 3, 3, 0.0F);
/*  68 */     setRotateAngle(this.Hair11, -0.7007497F, 0.091106184F, 1.4114478F);
/*  69 */     this.ArmR = new ModelRenderer(this, 40, 16);
/*  70 */     this.ArmR.func_78793_a(-5.0F, 2.0F, 0.0F);
/*  71 */     this.ArmR.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
/*  72 */     this.HairBack2 = new ModelRenderer(this, 0, 40);
/*  73 */     this.HairBack2.func_78793_a(0.0F, 3.9F, 0.3F);
/*  74 */     this.HairBack2.func_78790_a(-2.9F, 0.0F, -0.5F, 6, 4, 1, 0.0F);
/*  75 */     setRotateAngle(this.HairBack2, 0.091106184F, 0.0F, 0.0F);
/*  76 */     this.Body = new ModelRenderer(this, 16, 16);
/*  77 */     this.Body.func_78793_a(0.0F, 0.0F, 0.0F);
/*  78 */     this.Body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
/*  79 */     this.HairBack1 = new ModelRenderer(this, 1, 33);
/*  80 */     this.HairBack1.func_78793_a(0.0F, 0.0F, 2.7F);
/*  81 */     this.HairBack1.func_78790_a(-4.0F, 0.0F, -0.5F, 8, 4, 2, 0.0F);
/*  82 */     this.HairR3 = new ModelRenderer(this, 57, 18);
/*  83 */     this.HairR3.func_78793_a(0.0F, 1.9F, 0.0F);
/*  84 */     this.HairR3.func_78790_a(-0.6F, -0.3F, -0.5F, 1, 3, 1, 0.0F);
/*  85 */     setRotateAngle(this.HairR3, 0.0F, 0.0F, 0.045553092F);
/*  86 */     this.HairL3 = new ModelRenderer(this, 57, 18);
/*  87 */     this.HairL3.func_78793_a(0.0F, 1.9F, 0.0F);
/*  88 */     this.HairL3.func_78790_a(-0.6F, -0.3F, -0.5F, 1, 3, 1, 0.0F);
/*  89 */     setRotateAngle(this.HairL3, 0.045553092F, 0.0F, -0.045553092F);
/*  90 */     this.Hair9 = new ModelRenderer(this, 39, 0);
/*  91 */     this.Hair9.func_78793_a(-2.7F, -1.9F, 3.0F);
/*  92 */     this.Hair9.func_78790_a(-1.1F, 0.0F, -0.7F, 2, 3, 2, 0.0F);
/*  93 */     setRotateAngle(this.Hair9, 0.27314404F, 0.0F, 0.8196066F);
/*  94 */     this.LegR = new ModelRenderer(this, 0, 16);
/*  95 */     this.LegR.func_78793_a(-1.9F, 12.0F, 0.0F);
/*  96 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  97 */     this.Hair13 = new ModelRenderer(this, 40, 1);
/*  98 */     this.Hair13.func_78793_a(0.2F, -6.6F, -3.9F);
/*  99 */     this.Hair13.func_78790_a(-1.0F, -2.6F, -0.8F, 2, 3, 1, 0.0F);
/* 100 */     setRotateAngle(this.Hair13, 2.4130921F, 0.091106184F, 0.18203785F);
/* 101 */     this.Hair2 = new ModelRenderer(this, 37, 6);
/* 102 */     this.Hair2.func_78793_a(-1.7F, -6.5F, -2.2F);
/* 103 */     this.Hair2.func_78790_a(-4.7F, -1.6F, -0.8F, 4, 3, 2, 0.0F);
/* 104 */     setRotateAngle(this.Hair2, 0.0F, -0.47403142F, 0.043284167F);
/* 105 */     this.Hair7 = new ModelRenderer(this, 50, 8);
/* 106 */     this.Hair7.func_78793_a(0.2F, -7.0F, -1.9F);
/* 107 */     this.Hair7.func_78790_a(-0.5F, -2.3F, -0.8F, 1, 2, 2, 0.0F);
/* 108 */     setRotateAngle(this.Hair7, 0.0F, 0.0F, 0.3970624F);
/* 109 */     this.HairL1 = new ModelRenderer(this, 57, 8);
/* 110 */     this.HairL1.func_78793_a(4.0F, -5.0F, -2.3F);
/* 111 */     this.HairL1.func_78790_a(-0.6F, -0.3F, -0.5F, 1, 3, 1, 0.0F);
/* 112 */     setRotateAngle(this.HairL1, -0.13665928F, 0.0F, -0.06859144F);
/* 113 */     this.ArmL = new ModelRenderer(this, 40, 16);
/* 114 */     this.ArmL.field_78809_i = true;
/* 115 */     this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
/* 116 */     this.ArmL.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
/* 117 */     this.Hair14 = new ModelRenderer(this, 40, 1);
/* 118 */     this.Hair14.func_78793_a(2.8F, -6.9F, -3.9F);
/* 119 */     this.Hair14.func_78790_a(-1.0F, -2.6F, -0.8F, 2, 3, 1, 0.0F);
/* 120 */     setRotateAngle(this.Hair14, 2.6862361F, -0.045553092F, 0.045553092F);
/* 121 */     this.Hair5 = new ModelRenderer(this, 39, 0);
/* 122 */     this.Hair5.func_78793_a(2.4F, -3.7F, 2.7F);
/* 123 */     this.Hair5.func_78790_a(-1.0F, -0.2F, -0.8F, 2, 3, 2, 0.0F);
/* 124 */     setRotateAngle(this.Hair5, 0.0F, 0.0F, -0.7876671F);
/* 125 */     this.HairR2 = new ModelRenderer(this, 56, 13);
/* 126 */     this.HairR2.func_78793_a(0.0F, 2.8F, 0.0F);
/* 127 */     this.HairR2.func_78790_a(-0.7F, -0.3F, -0.8F, 1, 2, 2, 0.0F);
/* 128 */     setRotateAngle(this.HairR2, 0.091106184F, -0.045553092F, 0.091106184F);
/* 129 */     this.LegL = new ModelRenderer(this, 0, 16);
/* 130 */     this.LegL.field_78809_i = true;
/* 131 */     this.LegL.func_78793_a(1.9F, 12.0F, 0.0F);
/* 132 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/* 133 */     this.HairL2 = new ModelRenderer(this, 56, 13);
/* 134 */     this.HairL2.func_78793_a(0.0F, 2.8F, 0.0F);
/* 135 */     this.HairL2.func_78790_a(-0.5F, -0.3F, -0.8F, 1, 2, 2, 0.0F);
/* 136 */     setRotateAngle(this.HairL2, 0.091106184F, 0.0F, -0.045553092F);
/* 137 */     this.Hair8 = new ModelRenderer(this, 39, 0);
/* 138 */     this.Hair8.func_78793_a(3.2F, -1.9F, 3.0F);
/* 139 */     this.Hair8.func_78790_a(-1.0F, -0.2F, -0.8F, 2, 3, 2, 0.0F);
/* 140 */     setRotateAngle(this.Hair8, 0.17453292F, 0.0F, -0.8651597F);
/* 141 */     this.Hair3 = new ModelRenderer(this, 39, 0);
/* 142 */     this.Hair3.func_78793_a(-2.5F, -3.8F, 2.7F);
/* 143 */     this.Hair3.func_78790_a(-1.1F, 0.0F, -0.7F, 2, 3, 2, 0.0F);
/* 144 */     setRotateAngle(this.Hair3, 0.0F, 0.0F, 0.6953392F);
/* 145 */     this.Hair6 = new ModelRenderer(this, 49, 0);
/* 146 */     this.Hair6.func_78793_a(0.0F, -6.6F, -2.6F);
/* 147 */     this.Hair6.func_78790_a(-1.1F, -3.4F, -0.9F, 2, 4, 3, 0.0F);
/* 148 */     setRotateAngle(this.Hair6, -0.091106184F, -0.091106184F, -0.7285004F);
/* 149 */     this.Hair.func_78792_a(this.Hair4);
/* 150 */     this.Hair.func_78792_a(this.HairR1);
/* 151 */     this.Hair.func_78792_a(this.Hair1);
/* 152 */     this.Head.func_78792_a(this.Hair);
/* 153 */     this.Hair.func_78792_a(this.Hair12);
/* 154 */     this.Hair.func_78792_a(this.Hair11);
/* 155 */     this.HairBack1.func_78792_a(this.HairBack2);
/* 156 */     this.Head.func_78792_a(this.HairBack1);
/* 157 */     this.HairR2.func_78792_a(this.HairR3);
/* 158 */     this.HairL2.func_78792_a(this.HairL3);
/* 159 */     this.Hair.func_78792_a(this.Hair9);
/* 160 */     this.Hair.func_78792_a(this.Hair13);
/* 161 */     this.Hair.func_78792_a(this.Hair2);
/* 162 */     this.Hair.func_78792_a(this.Hair7);
/* 163 */     this.Hair.func_78792_a(this.HairL1);
/* 164 */     this.Hair.func_78792_a(this.Hair14);
/* 165 */     this.Hair.func_78792_a(this.Hair5);
/* 166 */     this.HairR1.func_78792_a(this.HairR2);
/* 167 */     this.HairL1.func_78792_a(this.HairL2);
/* 168 */     this.Hair.func_78792_a(this.Hair8);
/* 169 */     this.Hair.func_78792_a(this.Hair3);
/* 170 */     this.Hair.func_78792_a(this.Hair6);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 175 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 177 */     this.Head.func_78785_a(f5);
/* 178 */     this.Body.func_78785_a(f5);
/* 179 */     this.ArmR.func_78785_a(f5);
/* 180 */     this.ArmL.func_78785_a(f5);
/* 181 */     this.LegL.func_78785_a(f5);
/* 182 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 191 */     modelRenderer.field_78795_f = x;
/* 192 */     modelRenderer.field_78796_g = y;
/* 193 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 197 */     int calc = par7Entity.field_70173_aa;
/* 198 */     if (calc > 100) calc -= 100; 
/* 199 */     float r = 360.0F;
/* 200 */     float r2 = 180.0F;
/* 201 */     float n4 = par4;
/* 202 */     float n5 = par5;
/*     */     
/* 204 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 205 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 206 */     float ex = par7Entity.field_70173_aa;
/* 207 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 208 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 210 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 211 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 260 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 261 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 262 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 263 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 265 */     this.LegR.field_78796_g = 0.0F;
/* 266 */     this.LegL.field_78796_g = 0.0F;
/* 267 */     this.ArmR.field_78796_g = 0.0F;
/* 268 */     this.ArmL.field_78796_g = 0.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\db\ModelYamcha.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */