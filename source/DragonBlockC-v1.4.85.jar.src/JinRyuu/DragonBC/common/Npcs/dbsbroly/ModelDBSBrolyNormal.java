/*     */ package JinRyuu.DragonBC.common.Npcs.dbsbroly;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelDBSBrolyNormal extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
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
/*     */   public ModelRenderer Hair15;
/*     */   public ModelRenderer Hair16;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Chest;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer Cloth;
/*     */   public ModelRenderer ArmR2;
/*     */   public ModelRenderer ShoulderR;
/*     */   public ModelRenderer ArmL2;
/*     */   public ModelRenderer ShoulderL;
/*     */   
/*     */   public ModelDBSBrolyNormal() {
/*  43 */     this.field_78090_t = 128;
/*  44 */     this.field_78089_u = 64;
/*  45 */     this.Hair9 = new ModelRenderer(this, 39, 0);
/*  46 */     this.Hair9.func_78793_a(-2.7F, -3.0F, 1.5F);
/*  47 */     this.Hair9.func_78790_a(-1.1F, 0.0F, -0.7F, 2, 3, 2, 0.0F);
/*  48 */     setRotateAngle(this.Hair9, 0.27314404F, 0.0F, 0.8196066F);
/*  49 */     this.Hair15 = new ModelRenderer(this, 37, 6);
/*  50 */     this.Hair15.func_78793_a(0.8F, -6.6F, 0.7F);
/*  51 */     this.Hair15.func_78790_a(-4.7F, -1.6F, -0.8F, 4, 3, 2, 0.0F);
/*  52 */     setRotateAngle(this.Hair15, -0.2565634F, 0.5522222F, 0.043284167F);
/*  53 */     this.Hair13 = new ModelRenderer(this, 64, 7);
/*  54 */     this.Hair13.func_78793_a(-0.9F, -6.2F, -3.9F);
/*  55 */     this.Hair13.func_78790_a(-1.0F, -3.4F, -0.8F, 2, 4, 1, 0.0F);
/*  56 */     setRotateAngle(this.Hair13, 2.438225F, 0.27314404F, -0.045553092F);
/*  57 */     this.Chest = new ModelRenderer(this, 52, 19);
/*  58 */     this.Chest.func_78793_a(0.0F, 0.0F, 0.0F);
/*  59 */     this.Chest.func_78790_a(-4.0F, 1.0F, -2.5F, 8, 4, 1, 0.0F);
/*  60 */     this.Hair6 = new ModelRenderer(this, 75, 0);
/*  61 */     this.Hair6.func_78793_a(-1.3F, -6.6F, -1.4F);
/*  62 */     this.Hair6.func_78790_a(-1.1F, -3.4F, -1.9F, 3, 4, 4, 0.0F);
/*  63 */     setRotateAngle(this.Hair6, -0.091106184F, 0.31939524F, -0.7285004F);
/*  64 */     this.LegR = new ModelRenderer(this, 0, 43);
/*  65 */     this.LegR.func_78793_a(-2.4F, 10.6F, 0.0F);
/*  66 */     this.LegR.func_78790_a(-2.5F, 0.0F, -2.5F, 5, 14, 5, -0.1F);
/*  67 */     this.ArmL = new ModelRenderer(this, 0, 17);
/*  68 */     this.ArmL.field_78809_i = true;
/*  69 */     this.ArmL.func_78793_a(5.8F, -1.0F, 0.5F);
/*  70 */     this.ArmL.func_78790_a(-1.0F, -2.0F, -2.5F, 5, 4, 5, -0.1F);
/*  71 */     this.Hair11 = new ModelRenderer(this, 50, 8);
/*  72 */     this.Hair11.func_78793_a(2.8F, -7.3F, -2.3F);
/*  73 */     this.Hair11.func_78790_a(-1.0F, -0.7F, -0.8F, 3, 2, 3, 0.0F);
/*  74 */     setRotateAngle(this.Hair11, 0.0F, 0.0F, 0.0991347F);
/*  75 */     this.ShoulderL = new ModelRenderer(this, 74, 25);
/*  76 */     this.ShoulderL.field_78809_i = true;
/*  77 */     this.ShoulderL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  78 */     this.ShoulderL.func_78790_a(-1.0F, -2.0F, -2.5F, 6, 4, 5, 0.0F);
/*  79 */     this.LegL = new ModelRenderer(this, 0, 43);
/*  80 */     this.LegL.field_78809_i = true;
/*  81 */     this.LegL.func_78793_a(2.4F, 10.6F, 0.0F);
/*  82 */     this.LegL.func_78790_a(-2.5F, 0.0F, -2.5F, 5, 14, 5, -0.1F);
/*  83 */     this.Hair5 = new ModelRenderer(this, 39, 0);
/*  84 */     this.Hair5.func_78793_a(3.4F, -5.6F, 0.2F);
/*  85 */     this.Hair5.func_78790_a(-1.0F, -0.2F, -0.8F, 2, 3, 2, 0.0F);
/*  86 */     setRotateAngle(this.Hair5, 0.0F, 0.0F, -0.7876671F);
/*  87 */     this.Hair8 = new ModelRenderer(this, 39, 0);
/*  88 */     this.Hair8.func_78793_a(3.2F, -3.0F, 1.5F);
/*  89 */     this.Hair8.func_78790_a(-1.0F, 0.0F, -0.8F, 2, 3, 2, 0.0F);
/*  90 */     setRotateAngle(this.Hair8, 0.17453292F, 0.0F, -0.8651597F);
/*  91 */     this.Hair2 = new ModelRenderer(this, 37, 6);
/*  92 */     this.Hair2.func_78793_a(-1.7F, -6.5F, -0.5F);
/*  93 */     this.Hair2.func_78790_a(-4.7F, -1.6F, -0.8F, 4, 3, 2, 0.0F);
/*  94 */     setRotateAngle(this.Hair2, 0.0F, -0.47403142F, 0.043284167F);
/*  95 */     this.ArmR = new ModelRenderer(this, 0, 17);
/*  96 */     this.ArmR.func_78793_a(-5.8F, -1.0F, 0.5F);
/*  97 */     this.ArmR.func_78790_a(-4.0F, -2.0F, -2.5F, 5, 4, 5, -0.1F);
/*  98 */     this.HairBack2 = new ModelRenderer(this, 55, 36);
/*  99 */     this.HairBack2.func_78793_a(0.0F, 2.9F, 0.6F);
/* 100 */     this.HairBack2.func_78790_a(-2.9F, 0.0F, -0.5F, 6, 2, 1, 0.0F);
/* 101 */     setRotateAngle(this.HairBack2, -0.15236725F, 0.0F, 0.0F);
/* 102 */     this.Hair7 = new ModelRenderer(this, 32, 0);
/* 103 */     this.Hair7.func_78793_a(1.3F, -7.3F, 1.5F);
/* 104 */     this.Hair7.func_78790_a(-0.5F, -3.3F, -0.8F, 1, 3, 2, 0.0F);
/* 105 */     setRotateAngle(this.Hair7, 0.0F, -0.25254914F, 0.6920887F);
/* 106 */     this.Hair12 = new ModelRenderer(this, 27, 1);
/* 107 */     this.Hair12.func_78793_a(1.9F, -5.7F, -3.6F);
/* 108 */     this.Hair12.func_78790_a(-0.7F, -2.8F, -0.3F, 1, 3, 1, 0.0F);
/* 109 */     setRotateAngle(this.Hair12, 2.7317894F, -0.31869712F, -0.31869712F);
/* 110 */     this.Hair1 = new ModelRenderer(this, 62, 1);
/* 111 */     this.Hair1.func_78793_a(-3.3F, -5.9F, -3.4F);
/* 112 */     this.Hair1.func_78790_a(-1.0F, -0.4F, -3.6F, 2, 1, 4, 0.0F);
/* 113 */     setRotateAngle(this.Hair1, 0.84788096F, 0.378911F, 0.17139134F);
/* 114 */     this.Body2 = new ModelRenderer(this, 23, 31);
/* 115 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 116 */     this.Body2.func_78790_a(-4.0F, 4.7F, -2.0F, 8, 5, 4, 0.0F);
/* 117 */     this.Hair4 = new ModelRenderer(this, 39, 0);
/* 118 */     this.Hair4.func_78793_a(2.3F, -6.9F, 1.9F);
/* 119 */     this.Hair4.func_78790_a(-1.0F, -2.6F, -0.8F, 2, 3, 2, 0.0F);
/* 120 */     setRotateAngle(this.Hair4, -0.22965898F, -0.23751295F, 0.93466526F);
/* 121 */     this.Hair = new ModelRenderer(this, 0, 0);
/* 122 */     this.Hair.func_78793_a(0.0F, -1.2F, 0.0F);
/* 123 */     this.Hair.func_78790_a(-0.5F, -3.0F, 0.0F, 1, 1, 1, 0.0F);
/* 124 */     this.Body3 = new ModelRenderer(this, 22, 44);
/* 125 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 126 */     this.Body3.func_78790_a(-5.0F, 9.7F, -2.4F, 10, 4, 5, 0.0F);
/* 127 */     this.ArmL2 = new ModelRenderer(this, 0, 27);
/* 128 */     this.ArmL2.field_78809_i = true;
/* 129 */     this.ArmL2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 130 */     this.ArmL2.func_78790_a(-0.6F, 1.8F, -2.0F, 4, 10, 4, 0.0F);
/* 131 */     this.ShoulderR = new ModelRenderer(this, 74, 25);
/* 132 */     this.ShoulderR.func_78793_a(0.0F, 0.0F, 0.0F);
/* 133 */     this.ShoulderR.func_78790_a(-5.0F, -2.0F, -2.5F, 6, 4, 5, 0.0F);
/* 134 */     this.ArmR2 = new ModelRenderer(this, 0, 27);
/* 135 */     this.ArmR2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 136 */     this.ArmR2.func_78790_a(-3.4F, 1.8F, -2.0F, 4, 10, 4, 0.0F);
/* 137 */     this.HairBack1 = new ModelRenderer(this, 51, 29);
/* 138 */     this.HairBack1.func_78793_a(0.0F, -1.8F, 2.8F);
/* 139 */     this.HairBack1.func_78790_a(-4.5F, 0.0F, -0.5F, 9, 3, 2, 0.0F);
/* 140 */     setRotateAngle(this.HairBack1, 0.16318828F, -0.013788101F, 0.0F);
/* 141 */     this.Hair14 = new ModelRenderer(this, 64, 7);
/* 142 */     this.Hair14.func_78793_a(3.6F, -5.8F, -3.9F);
/* 143 */     this.Hair14.func_78790_a(-1.0F, -2.6F, -0.8F, 2, 3, 1, 0.0F);
/* 144 */     setRotateAngle(this.Hair14, 2.5057693F, -0.6588618F, 0.045553092F);
/* 145 */     this.Cloth = new ModelRenderer(this, 54, 46);
/* 146 */     this.Cloth.func_78793_a(0.0F, 12.7F, -0.4F);
/* 147 */     this.Cloth.func_78790_a(-5.0F, 0.0F, -1.0F, 10, 10, 4, 0.0F);
/* 148 */     this.Hair16 = new ModelRenderer(this, 75, 0);
/* 149 */     this.Hair16.func_78793_a(0.0F, -6.7F, -0.9F);
/* 150 */     this.Hair16.func_78790_a(-1.0F, -3.4F, -1.8F, 3, 4, 4, 0.0F);
/* 151 */     setRotateAngle(this.Hair16, -0.091106184F, -0.4886922F, 0.7285004F);
/* 152 */     this.Head = new ModelRenderer(this, 0, 0);
/* 153 */     this.Head.func_78793_a(0.0F, -2.8F, 0.0F);
/* 154 */     this.Head.func_78790_a(-4.0F, -8.2F, -4.0F, 8, 8, 8, 0.0F);
/* 155 */     this.Body1 = new ModelRenderer(this, 22, 17);
/* 156 */     this.Body1.func_78793_a(0.0F, -3.0F, 0.0F);
/* 157 */     this.Body1.func_78790_a(-5.0F, 0.0F, -1.4F, 10, 7, 4, 0.0F);
/* 158 */     this.Hair3 = new ModelRenderer(this, 39, 0);
/* 159 */     this.Hair3.func_78793_a(-3.2F, -5.6F, -0.2F);
/* 160 */     this.Hair3.func_78790_a(-1.1F, 0.0F, -0.7F, 2, 3, 2, 0.0F);
/* 161 */     setRotateAngle(this.Hair3, 0.0F, 0.0F, 0.6953392F);
/* 162 */     this.Hair.func_78792_a(this.Hair9);
/* 163 */     this.Hair.func_78792_a(this.Hair15);
/* 164 */     this.Hair.func_78792_a(this.Hair13);
/* 165 */     this.Body1.func_78792_a(this.Chest);
/* 166 */     this.Hair.func_78792_a(this.Hair6);
/* 167 */     this.Hair.func_78792_a(this.Hair11);
/* 168 */     this.ArmL.func_78792_a(this.ShoulderL);
/* 169 */     this.Hair.func_78792_a(this.Hair5);
/* 170 */     this.Hair.func_78792_a(this.Hair8);
/* 171 */     this.Hair.func_78792_a(this.Hair2);
/* 172 */     this.HairBack1.func_78792_a(this.HairBack2);
/* 173 */     this.Hair.func_78792_a(this.Hair7);
/* 174 */     this.Hair.func_78792_a(this.Hair12);
/* 175 */     this.Hair.func_78792_a(this.Hair1);
/* 176 */     this.Body1.func_78792_a(this.Body2);
/* 177 */     this.Hair.func_78792_a(this.Hair4);
/* 178 */     this.Head.func_78792_a(this.Hair);
/* 179 */     this.Body2.func_78792_a(this.Body3);
/* 180 */     this.ArmL.func_78792_a(this.ArmL2);
/* 181 */     this.ArmR.func_78792_a(this.ShoulderR);
/* 182 */     this.ArmR.func_78792_a(this.ArmR2);
/* 183 */     this.Head.func_78792_a(this.HairBack1);
/* 184 */     this.Hair.func_78792_a(this.Hair14);
/* 185 */     this.Body3.func_78792_a(this.Cloth);
/* 186 */     this.Hair.func_78792_a(this.Hair16);
/* 187 */     this.Hair.func_78792_a(this.Hair3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 192 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 194 */     this.Body1.func_78785_a(f5);
/* 195 */     this.ArmR.func_78785_a(f5);
/* 196 */     this.ArmL.func_78785_a(f5);
/* 197 */     this.LegL.func_78785_a(f5);
/* 198 */     this.Head.func_78785_a(f5);
/* 199 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 205 */     modelRenderer.field_78795_f = x;
/* 206 */     modelRenderer.field_78796_g = y;
/* 207 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 211 */     int calc = par7Entity.field_70173_aa;
/* 212 */     if (calc > 100) calc -= 100; 
/* 213 */     float r = 360.0F;
/* 214 */     float r2 = 180.0F;
/* 215 */     float n4 = par4;
/* 216 */     float n5 = par5;
/*     */     
/* 218 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 219 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 220 */     float ex = par7Entity.field_70173_aa;
/* 221 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 222 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 224 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 225 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 274 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 275 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 276 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 277 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 279 */     this.LegR.field_78796_g = 0.0F;
/* 280 */     this.LegL.field_78796_g = 0.0F;
/* 281 */     this.ArmR.field_78796_g = 0.0F;
/* 282 */     this.ArmL.field_78796_g = 0.0F;
/*     */ 
/*     */     
/* 285 */     this.Cloth.field_78795_f = 0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 286 */     this.Cloth.field_78795_f = 0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 287 */     this.Cloth.field_78795_f = 0.15F + this.LegL.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 288 */     this.Cloth.field_78795_f = 0.15F + this.LegL.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 289 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbsbroly\ModelDBSBrolyNormal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */