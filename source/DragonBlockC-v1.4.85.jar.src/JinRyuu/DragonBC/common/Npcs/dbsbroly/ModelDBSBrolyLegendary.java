/*     */ package JinRyuu.DragonBC.common.Npcs.dbsbroly;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelDBSBrolyLegendary
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmR1;
/*     */   public ModelRenderer ArmL1;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer Hair;
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
/*     */   public ModelRenderer Hair15;
/*     */   public ModelRenderer Hair16;
/*     */   public ModelRenderer HairBack1;
/*     */   public ModelRenderer HairBack2;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer Chest;
/*     */   public ModelRenderer Cloth;
/*     */   public ModelRenderer ArmR2;
/*     */   public ModelRenderer ArmR3;
/*     */   public ModelRenderer ArmL2;
/*     */   public ModelRenderer ArmL3;
/*     */   
/*     */   public ModelDBSBrolyLegendary() {
/*  44 */     this.field_78090_t = 128;
/*  45 */     this.field_78089_u = 64;
/*  46 */     this.Body1 = new ModelRenderer(this, 0, 18);
/*  47 */     this.Body1.func_78793_a(0.0F, -8.0F, 0.0F);
/*  48 */     this.Body1.func_78790_a(-7.0F, 0.0F, -2.7F, 14, 8, 7, 0.0F);
/*  49 */     this.Hair12 = new ModelRenderer(this, 39, 1);
/*  50 */     this.Hair12.func_78793_a(1.7F, -6.6F, -3.8F);
/*  51 */     this.Hair12.func_78790_a(-0.7F, -2.8F, -0.3F, 1, 3, 1, 0.0F);
/*  52 */     setRotateAngle(this.Hair12, 2.7317894F, -0.31869712F, -0.31869712F);
/*  53 */     this.Hair4 = new ModelRenderer(this, 91, 2);
/*  54 */     this.Hair4.func_78793_a(2.5F, -6.2F, 2.3F);
/*  55 */     this.Hair4.func_78790_a(-1.5F, -2.6F, -1.4F, 3, 3, 3, 0.0F);
/*  56 */     setRotateAngle(this.Hair4, -0.36878806F, -0.13526301F, 1.0815805F);
/*  57 */     this.Hair9 = new ModelRenderer(this, 45, 0);
/*  58 */     this.Hair9.func_78793_a(-3.6F, -3.0F, 1.5F);
/*  59 */     this.Hair9.func_78790_a(-1.1F, 0.0F, -0.7F, 2, 3, 3, 0.0F);
/*  60 */     setRotateAngle(this.Hair9, 0.27314404F, 0.0F, 0.8196066F);
/*  61 */     this.Body2 = new ModelRenderer(this, 0, 34);
/*  62 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  63 */     this.Body2.func_78790_a(-5.5F, 6.2F, -2.9F, 11, 6, 6, 0.0F);
/*  64 */     this.Hair3 = new ModelRenderer(this, 45, 8);
/*  65 */     this.Hair3.func_78793_a(-4.2F, -4.1F, -0.2F);
/*  66 */     this.Hair3.func_78790_a(-1.5F, -2.8F, -0.7F, 3, 4, 4, 0.0F);
/*  67 */     setRotateAngle(this.Hair3, 0.0F, 0.0F, -0.7005752F);
/*  68 */     this.Hair15 = new ModelRenderer(this, 90, 14);
/*  69 */     this.Hair15.func_78793_a(-1.1F, -6.0F, 2.0F);
/*  70 */     this.Hair15.func_78790_a(-4.7F, -4.7F, -1.6F, 4, 6, 3, 0.0F);
/*  71 */     setRotateAngle(this.Hair15, 0.0F, 0.43022367F, 0.5009095F);
/*  72 */     this.LegL = new ModelRenderer(this, 41, 42);
/*  73 */     this.LegL.field_78809_i = true;
/*  74 */     this.LegL.func_78793_a(3.0F, 9.0F, 0.0F);
/*  75 */     this.LegL.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 15, 6, 0.0F);
/*  76 */     this.Hair11 = new ModelRenderer(this, 60, 8);
/*  77 */     this.Hair11.func_78793_a(2.8F, -7.3F, -2.3F);
/*  78 */     this.Hair11.func_78790_a(-1.0F, -0.7F, -0.8F, 3, 2, 3, 0.0F);
/*  79 */     setRotateAngle(this.Hair11, 0.0F, 0.0F, 0.0991347F);
/*  80 */     this.Head = new ModelRenderer(this, 0, 0);
/*  81 */     this.Head.func_78793_a(0.0F, -8.0F, 0.5F);
/*  82 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
/*  83 */     this.ArmR3 = new ModelRenderer(this, 67, 50);
/*  84 */     this.ArmR3.func_78793_a(-0.1F, 4.2F, -0.8F);
/*  85 */     this.ArmR3.func_78790_a(-3.5F, 0.0F, -1.9F, 6, 8, 5, 0.0F);
/*  86 */     setRotateAngle(this.ArmR3, -0.22759093F, 0.0F, 0.0F);
/*  87 */     this.Chest = new ModelRenderer(this, 35, 34);
/*  88 */     this.Chest.func_78793_a(0.0F, 0.0F, 0.0F);
/*  89 */     this.Chest.func_78790_a(-6.5F, 1.2F, -3.8F, 13, 5, 2, 0.0F);
/*  90 */     this.Hair5 = new ModelRenderer(this, 45, 0);
/*  91 */     this.Hair5.func_78793_a(4.2F, -4.1F, 0.2F);
/*  92 */     this.Hair5.func_78790_a(-1.5F, -2.8F, -0.8F, 3, 4, 3, 0.0F);
/*  93 */     setRotateAngle(this.Hair5, 0.0F, 0.0F, 0.70040065F);
/*  94 */     this.Hair13 = new ModelRenderer(this, 61, 16);
/*  95 */     this.Hair13.func_78793_a(-0.9F, -7.3F, -4.6F);
/*  96 */     this.Hair13.func_78790_a(-1.0F, -3.4F, -0.8F, 2, 4, 1, 0.0F);
/*  97 */     setRotateAngle(this.Hair13, 2.438225F, 0.27314404F, -0.045553092F);
/*  98 */     this.Cloth = new ModelRenderer(this, 90, 46);
/*  99 */     this.Cloth.func_78793_a(0.0F, 15.5F, 0.8F);
/* 100 */     this.Cloth.func_78790_a(-6.6F, 0.0F, -0.8F, 13, 10, 4, 0.0F);
/* 101 */     this.Hair8 = new ModelRenderer(this, 45, 0);
/* 102 */     this.Hair8.func_78793_a(3.6F, -3.0F, 1.5F);
/* 103 */     this.Hair8.func_78790_a(-1.0F, 0.0F, -0.8F, 2, 3, 3, 0.0F);
/* 104 */     setRotateAngle(this.Hair8, 0.17453292F, 0.0F, -0.8651597F);
/* 105 */     this.Hair14 = new ModelRenderer(this, 61, 16);
/* 106 */     this.Hair14.func_78793_a(3.6F, -6.6F, -4.5F);
/* 107 */     this.Hair14.func_78790_a(-1.0F, -2.6F, -0.8F, 2, 3, 1, 0.0F);
/* 108 */     setRotateAngle(this.Hair14, 2.5057693F, -0.6588618F, -0.17575465F);
/* 109 */     this.Hair16 = new ModelRenderer(this, 89, 0);
/* 110 */     this.Hair16.func_78793_a(0.9F, -7.2F, -1.4F);
/* 111 */     this.Hair16.func_78790_a(-1.0F, -5.8F, -1.8F, 3, 6, 5, 0.0F);
/* 112 */     setRotateAngle(this.Hair16, -0.27314404F, 0.0F, 0.045553092F);
/* 113 */     this.HairBack2 = new ModelRenderer(this, 112, 9);
/* 114 */     this.HairBack2.func_78793_a(0.0F, 2.9F, 0.6F);
/* 115 */     this.HairBack2.func_78790_a(-2.9F, 0.0F, -0.5F, 6, 2, 1, 0.0F);
/* 116 */     setRotateAngle(this.HairBack2, 0.29530972F, 0.0F, 0.0F);
/* 117 */     this.Body3 = new ModelRenderer(this, 0, 48);
/* 118 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 119 */     this.Body3.func_78790_a(-6.5F, 12.0F, -3.1F, 13, 5, 7, 0.0F);
/* 120 */     this.Hair7 = new ModelRenderer(this, 69, 11);
/* 121 */     this.Hair7.func_78793_a(1.1F, -7.8F, 1.0F);
/* 122 */     this.Hair7.func_78790_a(-1.3F, -4.3F, -3.1F, 4, 6, 5, 0.0F);
/* 123 */     setRotateAngle(this.Hair7, -0.3195698F, 0.0F, 0.8972738F);
/* 124 */     this.ArmR1 = new ModelRenderer(this, 66, 25);
/* 125 */     this.ArmR1.func_78793_a(-7.4F, -5.5F, 0.3F);
/* 126 */     this.ArmR1.func_78790_a(-6.0F, -3.0F, -3.5F, 7, 5, 7, -0.1F);
/* 127 */     this.ArmL3 = new ModelRenderer(this, 67, 50);
/* 128 */     this.ArmL3.field_78809_i = true;
/* 129 */     this.ArmL3.func_78793_a(0.4F, 4.2F, -0.8F);
/* 130 */     this.ArmL3.func_78790_a(-2.8F, 0.0F, -1.9F, 6, 8, 5, 0.0F);
/* 131 */     setRotateAngle(this.ArmL3, -0.18203785F, 0.0F, 0.0F);
/* 132 */     this.ArmL2 = new ModelRenderer(this, 67, 38);
/* 133 */     this.ArmL2.field_78809_i = true;
/* 134 */     this.ArmL2.func_78793_a(1.7F, 2.0F, 0.0F);
/* 135 */     this.ArmL2.func_78790_a(-2.1F, -0.2F, -2.8F, 6, 5, 6, 0.0F);
/* 136 */     this.ArmL1 = new ModelRenderer(this, 66, 25);
/* 137 */     this.ArmL1.field_78809_i = true;
/* 138 */     this.ArmL1.func_78793_a(7.4F, -5.5F, 0.3F);
/* 139 */     this.ArmL1.func_78790_a(-1.0F, -3.0F, -3.5F, 7, 5, 7, -0.1F);
/* 140 */     this.Hair2 = new ModelRenderer(this, 72, 0);
/* 141 */     this.Hair2.func_78793_a(-3.3F, -7.4F, 0.3F);
/* 142 */     this.Hair2.func_78790_a(-2.0F, -4.2F, -2.2F, 4, 5, 4, 0.0F);
/* 143 */     setRotateAngle(this.Hair2, 0.0F, 0.0F, -0.675966F);
/* 144 */     this.Hair1 = new ModelRenderer(this, 58, 1);
/* 145 */     this.Hair1.func_78793_a(-3.8F, -7.1F, -4.2F);
/* 146 */     this.Hair1.func_78790_a(-1.0F, -0.4F, -3.6F, 2, 1, 4, 0.0F);
/* 147 */     setRotateAngle(this.Hair1, 1.0471976F, 0.5462881F, 0.091106184F);
/* 148 */     this.Hair = new ModelRenderer(this, 0, 0);
/* 149 */     this.Hair.func_78793_a(0.0F, 0.0F, 0.0F);
/* 150 */     this.Hair.func_78790_a(-0.5F, -3.0F, 0.0F, 1, 1, 1, 0.0F);
/* 151 */     this.LegR = new ModelRenderer(this, 41, 42);
/* 152 */     this.LegR.func_78793_a(-3.0F, 9.0F, 0.0F);
/* 153 */     this.LegR.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 15, 6, 0.0F);
/* 154 */     this.HairBack1 = new ModelRenderer(this, 106, 2);
/* 155 */     this.HairBack1.func_78793_a(0.0F, -2.4F, 2.9F);
/* 156 */     this.HairBack1.func_78790_a(-4.5F, 0.0F, -0.5F, 9, 3, 2, 0.0F);
/* 157 */     setRotateAngle(this.HairBack1, 0.31642818F, 0.0F, 0.0F);
/* 158 */     this.Hair6 = new ModelRenderer(this, 89, 0);
/* 159 */     this.Hair6.func_78793_a(-1.3F, -7.4F, -1.4F);
/* 160 */     this.Hair6.func_78790_a(-1.1F, -7.2F, -1.9F, 3, 8, 5, 0.0F);
/* 161 */     setRotateAngle(this.Hair6, -0.31869712F, 0.07382743F, -0.22130775F);
/* 162 */     this.ArmR2 = new ModelRenderer(this, 67, 38);
/* 163 */     this.ArmR2.func_78793_a(-1.7F, 2.0F, 0.0F);
/* 164 */     this.ArmR2.func_78790_a(-3.9F, -0.2F, -2.8F, 6, 5, 6, 0.0F);
/* 165 */     this.Hair.func_78792_a(this.Hair12);
/* 166 */     this.Hair.func_78792_a(this.Hair4);
/* 167 */     this.Hair.func_78792_a(this.Hair9);
/* 168 */     this.Body1.func_78792_a(this.Body2);
/* 169 */     this.Hair.func_78792_a(this.Hair3);
/* 170 */     this.Hair.func_78792_a(this.Hair15);
/* 171 */     this.Hair.func_78792_a(this.Hair11);
/* 172 */     this.ArmR2.func_78792_a(this.ArmR3);
/* 173 */     this.Body2.func_78792_a(this.Chest);
/* 174 */     this.Hair.func_78792_a(this.Hair5);
/* 175 */     this.Hair.func_78792_a(this.Hair13);
/* 176 */     this.Body3.func_78792_a(this.Cloth);
/* 177 */     this.Hair.func_78792_a(this.Hair8);
/* 178 */     this.Hair.func_78792_a(this.Hair14);
/* 179 */     this.Hair.func_78792_a(this.Hair16);
/* 180 */     this.HairBack1.func_78792_a(this.HairBack2);
/* 181 */     this.Body2.func_78792_a(this.Body3);
/* 182 */     this.Hair.func_78792_a(this.Hair7);
/* 183 */     this.ArmL2.func_78792_a(this.ArmL3);
/* 184 */     this.ArmL1.func_78792_a(this.ArmL2);
/* 185 */     this.Hair.func_78792_a(this.Hair2);
/* 186 */     this.Hair.func_78792_a(this.Hair1);
/* 187 */     this.Head.func_78792_a(this.Hair);
/* 188 */     this.Hair.func_78792_a(this.HairBack1);
/* 189 */     this.Hair.func_78792_a(this.Hair6);
/* 190 */     this.ArmR1.func_78792_a(this.ArmR2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 195 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 197 */     this.Head.func_78785_a(f5);
/*     */     
/* 199 */     this.Body1.func_78785_a(f5);
/* 200 */     this.ArmR1.func_78785_a(f5);
/* 201 */     this.ArmL1.func_78785_a(f5);
/* 202 */     this.LegL.func_78785_a(f5);
/* 203 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 212 */     modelRenderer.field_78795_f = x;
/* 213 */     modelRenderer.field_78796_g = y;
/* 214 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 218 */     int calc = par7Entity.field_70173_aa;
/* 219 */     if (calc > 100) calc -= 100; 
/* 220 */     float r = 360.0F;
/* 221 */     float r2 = 180.0F;
/* 222 */     float n4 = par4;
/* 223 */     float n5 = par5;
/*     */     
/* 225 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 226 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 227 */     float ex = par7Entity.field_70173_aa;
/* 228 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 229 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 231 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 232 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 281 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 282 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 283 */     this.ArmR1.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 284 */     this.ArmL1.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 286 */     this.LegR.field_78796_g = 0.0F;
/* 287 */     this.LegL.field_78796_g = 0.0F;
/* 288 */     this.ArmR1.field_78796_g = 0.0F;
/* 289 */     this.ArmL1.field_78796_g = 0.0F;
/*     */     
/* 291 */     this.Cloth.field_78795_f = 0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 292 */     this.Cloth.field_78795_f = 0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 293 */     this.Cloth.field_78795_f = 0.15F + this.LegL.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 294 */     this.Cloth.field_78795_f = 0.15F + this.LegL.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 295 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbsbroly\ModelDBSBrolyLegendary.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */