/*     */ package JinRyuu.DragonBC.common.Npcs.dbsbroly;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelDBSBrolyBuff extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmR1;
/*     */   public ModelRenderer ArmL1;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
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
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer Chest;
/*     */   public ModelRenderer Cloth;
/*     */   public ModelRenderer ArmR2;
/*     */   public ModelRenderer ShoulderR;
/*     */   public ModelRenderer ArmR3;
/*     */   public ModelRenderer ArmL2;
/*     */   public ModelRenderer ShoulderL;
/*     */   public ModelRenderer ArmL3;
/*     */   
/*     */   public ModelDBSBrolyBuff() {
/*  45 */     this.field_78090_t = 128;
/*  46 */     this.field_78089_u = 64;
/*  47 */     this.Body2 = new ModelRenderer(this, 0, 34);
/*  48 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  49 */     this.Body2.func_78790_a(-5.5F, 6.2F, -2.9F, 11, 6, 6, 0.0F);
/*  50 */     this.Hair = new ModelRenderer(this, 0, 0);
/*  51 */     this.Hair.func_78793_a(0.0F, 0.0F, 0.0F);
/*  52 */     this.Hair.func_78790_a(-0.5F, -3.0F, 0.0F, 1, 1, 1, 0.0F);
/*  53 */     this.Hair9 = new ModelRenderer(this, 39, 0);
/*  54 */     this.Hair9.func_78793_a(-3.6F, -3.0F, 1.5F);
/*  55 */     this.Hair9.func_78790_a(-1.1F, 0.0F, -0.7F, 2, 3, 3, 0.0F);
/*  56 */     setRotateAngle(this.Hair9, 0.27314404F, 0.0F, 0.8196066F);
/*  57 */     this.ArmL3 = new ModelRenderer(this, 67, 50);
/*  58 */     this.ArmL3.field_78809_i = true;
/*  59 */     this.ArmL3.func_78793_a(0.0F, 4.2F, -0.5F);
/*  60 */     this.ArmL3.func_78790_a(-2.1F, 0.0F, -1.8F, 5, 8, 5, 0.0F);
/*  61 */     this.Head = new ModelRenderer(this, 0, 0);
/*  62 */     this.Head.func_78793_a(0.0F, -8.0F, -0.5F);
/*  63 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
/*  64 */     this.Cloth = new ModelRenderer(this, 90, 46);
/*  65 */     this.Cloth.func_78793_a(0.0F, 15.5F, 0.8F);
/*  66 */     this.Cloth.func_78790_a(-6.6F, 0.0F, -0.8F, 13, 10, 4, 0.0F);
/*  67 */     this.Hair6 = new ModelRenderer(this, 80, 0);
/*  68 */     this.Hair6.func_78793_a(-1.3F, -7.4F, -1.4F);
/*  69 */     this.Hair6.func_78790_a(-1.1F, -6.6F, -1.9F, 3, 7, 5, 0.0F);
/*  70 */     setRotateAngle(this.Hair6, -0.31869712F, 0.07382743F, -0.22130775F);
/*  71 */     this.Body3 = new ModelRenderer(this, 0, 48);
/*  72 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  73 */     this.Body3.func_78790_a(-6.5F, 12.0F, -3.1F, 13, 5, 7, 0.0F);
/*  74 */     this.ArmR1 = new ModelRenderer(this, 66, 27);
/*  75 */     this.ArmR1.func_78793_a(-8.0F, -5.2F, 0.2F);
/*  76 */     this.ArmR1.func_78790_a(-5.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
/*  77 */     this.LegR = new ModelRenderer(this, 41, 42);
/*  78 */     this.LegR.func_78793_a(-3.0F, 9.0F, 0.0F);
/*  79 */     this.LegR.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 15, 6, 0.0F);
/*  80 */     this.Hair12 = new ModelRenderer(this, 33, 1);
/*  81 */     this.Hair12.func_78793_a(1.9F, -6.6F, -3.6F);
/*  82 */     this.Hair12.func_78790_a(-0.7F, -2.8F, -0.3F, 1, 3, 1, 0.0F);
/*  83 */     setRotateAngle(this.Hair12, 2.7317894F, -0.31869712F, -0.31869712F);
/*  84 */     this.Hair14 = new ModelRenderer(this, 52, 14);
/*  85 */     this.Hair14.func_78793_a(3.6F, -6.6F, -3.9F);
/*  86 */     this.Hair14.func_78790_a(-1.0F, -2.6F, -0.8F, 2, 3, 1, 0.0F);
/*  87 */     setRotateAngle(this.Hair14, 2.5057693F, -0.6588618F, -0.17575465F);
/*  88 */     this.ArmR3 = new ModelRenderer(this, 67, 50);
/*  89 */     this.ArmR3.func_78793_a(0.0F, 4.2F, -0.5F);
/*  90 */     this.ArmR3.func_78790_a(-2.9F, 0.0F, -1.9F, 5, 8, 5, 0.0F);
/*  91 */     this.ShoulderL = new ModelRenderer(this, 91, 26);
/*  92 */     this.ShoulderL.field_78809_i = true;
/*  93 */     this.ShoulderL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  94 */     this.ShoulderL.func_78790_a(-1.1F, -3.1F, -3.6F, 7, 6, 7, 0.0F);
/*  95 */     this.Hair15 = new ModelRenderer(this, 82, 13);
/*  96 */     this.Hair15.func_78793_a(-1.1F, -6.0F, 2.0F);
/*  97 */     this.Hair15.func_78790_a(-4.7F, -3.0F, -1.6F, 4, 5, 3, 0.0F);
/*  98 */     setRotateAngle(this.Hair15, 0.0F, 0.43022367F, 0.5009095F);
/*  99 */     this.Hair1 = new ModelRenderer(this, 52, 1);
/* 100 */     this.Hair1.func_78793_a(-3.3F, -7.1F, -3.4F);
/* 101 */     this.Hair1.func_78790_a(-1.0F, -0.4F, -3.6F, 2, 1, 4, 0.0F);
/* 102 */     setRotateAngle(this.Hair1, 0.84788096F, 0.6984808F, 0.17139134F);
/* 103 */     this.Hair7 = new ModelRenderer(this, 64, 8);
/* 104 */     this.Hair7.func_78793_a(1.1F, -7.8F, 1.0F);
/* 105 */     this.Hair7.func_78790_a(-1.3F, -3.7F, -2.4F, 4, 5, 5, 0.0F);
/* 106 */     setRotateAngle(this.Hair7, -0.3195698F, 0.0F, 0.8972738F);
/* 107 */     this.LegL = new ModelRenderer(this, 41, 42);
/* 108 */     this.LegL.field_78809_i = true;
/* 109 */     this.LegL.func_78793_a(3.0F, 9.0F, 0.0F);
/* 110 */     this.LegL.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 15, 6, 0.0F);
/* 111 */     this.Hair13 = new ModelRenderer(this, 52, 14);
/* 112 */     this.Hair13.func_78793_a(-0.9F, -7.3F, -3.9F);
/* 113 */     this.Hair13.func_78790_a(-1.0F, -3.4F, -0.8F, 2, 4, 1, 0.0F);
/* 114 */     setRotateAngle(this.Hair13, 2.438225F, 0.27314404F, -0.045553092F);
/* 115 */     this.HairBack1 = new ModelRenderer(this, 101, 2);
/* 116 */     this.HairBack1.func_78793_a(0.0F, -2.4F, 2.9F);
/* 117 */     this.HairBack1.func_78790_a(-4.0F, 0.0F, -0.5F, 8, 3, 2, 0.0F);
/* 118 */     setRotateAngle(this.HairBack1, 0.31642818F, 0.0F, 0.0F);
/* 119 */     this.Hair16 = new ModelRenderer(this, 35, 7);
/* 120 */     this.Hair16.func_78793_a(0.9F, -7.2F, -1.4F);
/* 121 */     this.Hair16.func_78790_a(-1.0F, -5.1F, -1.8F, 3, 5, 5, 0.0F);
/* 122 */     setRotateAngle(this.Hair16, -0.27314404F, 0.0F, 0.045553092F);
/* 123 */     this.ArmR2 = new ModelRenderer(this, 67, 40);
/* 124 */     this.ArmR2.func_78793_a(-1.7F, 2.0F, 0.0F);
/* 125 */     this.ArmR2.func_78790_a(-2.7F, 0.4F, -2.5F, 5, 4, 5, 0.0F);
/* 126 */     this.HairBack2 = new ModelRenderer(this, 103, 9);
/* 127 */     this.HairBack2.func_78793_a(0.0F, 2.9F, 0.6F);
/* 128 */     this.HairBack2.func_78790_a(-2.9F, 0.0F, -0.5F, 6, 2, 1, 0.0F);
/* 129 */     setRotateAngle(this.HairBack2, 0.2952383F, 0.0F, 0.0F);
/* 130 */     this.Hair8 = new ModelRenderer(this, 39, 0);
/* 131 */     this.Hair8.func_78793_a(3.6F, -3.0F, 1.5F);
/* 132 */     this.Hair8.func_78790_a(-1.0F, 0.0F, -0.8F, 2, 3, 3, 0.0F);
/* 133 */     setRotateAngle(this.Hair8, 0.17453292F, 0.0F, -0.8651597F);
/* 134 */     this.Hair5 = new ModelRenderer(this, 39, 0);
/* 135 */     this.Hair5.func_78793_a(4.2F, -4.1F, 0.2F);
/* 136 */     this.Hair5.func_78790_a(-1.0F, -2.8F, -0.8F, 2, 4, 3, 0.0F);
/* 137 */     setRotateAngle(this.Hair5, 0.0F, 0.0F, 0.70040065F);
/* 138 */     this.Hair11 = new ModelRenderer(this, 52, 8);
/* 139 */     this.Hair11.func_78793_a(2.8F, -7.3F, -2.3F);
/* 140 */     this.Hair11.func_78790_a(-1.0F, -0.7F, -0.8F, 3, 2, 3, 0.0F);
/* 141 */     setRotateAngle(this.Hair11, 0.0F, 0.0F, 0.0991347F);
/* 142 */     this.Hair4 = new ModelRenderer(this, 82, 2);
/* 143 */     this.Hair4.func_78793_a(2.5F, -6.2F, 2.3F);
/* 144 */     this.Hair4.func_78790_a(-1.5F, -2.6F, -1.4F, 3, 3, 3, 0.0F);
/* 145 */     setRotateAngle(this.Hair4, -0.36878806F, -0.13526301F, 1.0815805F);
/* 146 */     this.Chest = new ModelRenderer(this, 35, 33);
/* 147 */     this.Chest.func_78793_a(0.0F, 0.0F, 0.0F);
/* 148 */     this.Chest.func_78790_a(-6.0F, 1.8F, -3.4F, 12, 5, 1, 0.0F);
/* 149 */     this.ShoulderR = new ModelRenderer(this, 91, 26);
/* 150 */     this.ShoulderR.func_78793_a(0.0F, 0.0F, 0.0F);
/* 151 */     this.ShoulderR.func_78790_a(-5.9F, -3.1F, -3.6F, 7, 6, 7, 0.0F);
/* 152 */     this.ArmL1 = new ModelRenderer(this, 66, 27);
/* 153 */     this.ArmL1.field_78809_i = true;
/* 154 */     this.ArmL1.func_78793_a(8.0F, -5.2F, 0.2F);
/* 155 */     this.ArmL1.func_78790_a(-1.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
/* 156 */     this.ArmL2 = new ModelRenderer(this, 67, 40);
/* 157 */     this.ArmL2.field_78809_i = true;
/* 158 */     this.ArmL2.func_78793_a(1.7F, 2.0F, 0.0F);
/* 159 */     this.ArmL2.func_78790_a(-2.3F, 0.4F, -2.5F, 5, 4, 5, 0.0F);
/* 160 */     this.Body1 = new ModelRenderer(this, 0, 17);
/* 161 */     this.Body1.func_78793_a(0.0F, -8.0F, 0.0F);
/* 162 */     this.Body1.func_78790_a(-7.0F, 0.0F, -2.5F, 14, 8, 6, 0.0F);
/* 163 */     this.Hair2 = new ModelRenderer(this, 64, 0);
/* 164 */     this.Hair2.func_78793_a(-3.3F, -7.4F, 0.3F);
/* 165 */     this.Hair2.func_78790_a(-2.0F, -3.5F, -2.2F, 4, 4, 4, 0.0F);
/* 166 */     setRotateAngle(this.Hair2, 0.0F, 0.0F, -0.675966F);
/* 167 */     this.Hair3 = new ModelRenderer(this, 39, 0);
/* 168 */     this.Hair3.func_78793_a(-4.2F, -4.1F, -0.2F);
/* 169 */     this.Hair3.func_78790_a(-0.9F, -2.8F, -0.7F, 2, 4, 3, 0.0F);
/* 170 */     setRotateAngle(this.Hair3, 0.0F, 0.0F, -0.7005752F);
/* 171 */     this.Body1.func_78792_a(this.Body2);
/* 172 */     this.Head.func_78792_a(this.Hair);
/* 173 */     this.Hair.func_78792_a(this.Hair9);
/* 174 */     this.ArmL2.func_78792_a(this.ArmL3);
/* 175 */     this.Body3.func_78792_a(this.Cloth);
/* 176 */     this.Hair.func_78792_a(this.Hair6);
/* 177 */     this.Body2.func_78792_a(this.Body3);
/* 178 */     this.Hair.func_78792_a(this.Hair12);
/* 179 */     this.Hair.func_78792_a(this.Hair14);
/* 180 */     this.ArmR2.func_78792_a(this.ArmR3);
/* 181 */     this.ArmL1.func_78792_a(this.ShoulderL);
/* 182 */     this.Hair.func_78792_a(this.Hair15);
/* 183 */     this.Hair.func_78792_a(this.Hair1);
/* 184 */     this.Hair.func_78792_a(this.Hair7);
/* 185 */     this.Hair.func_78792_a(this.Hair13);
/* 186 */     this.Head.func_78792_a(this.HairBack1);
/* 187 */     this.Hair.func_78792_a(this.Hair16);
/* 188 */     this.ArmR1.func_78792_a(this.ArmR2);
/* 189 */     this.HairBack1.func_78792_a(this.HairBack2);
/* 190 */     this.Hair.func_78792_a(this.Hair8);
/* 191 */     this.Hair.func_78792_a(this.Hair5);
/* 192 */     this.Hair.func_78792_a(this.Hair11);
/* 193 */     this.Hair.func_78792_a(this.Hair4);
/* 194 */     this.Body2.func_78792_a(this.Chest);
/* 195 */     this.ArmR1.func_78792_a(this.ShoulderR);
/* 196 */     this.ArmL1.func_78792_a(this.ArmL2);
/* 197 */     this.Hair.func_78792_a(this.Hair2);
/* 198 */     this.Hair.func_78792_a(this.Hair3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 203 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 205 */     this.Body1.func_78785_a(f5);
/* 206 */     this.ArmR1.func_78785_a(f5);
/* 207 */     this.ArmL1.func_78785_a(f5);
/* 208 */     this.LegL.func_78785_a(f5);
/* 209 */     this.Head.func_78785_a(f5);
/* 210 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 216 */     modelRenderer.field_78795_f = x;
/* 217 */     modelRenderer.field_78796_g = y;
/* 218 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 222 */     int calc = par7Entity.field_70173_aa;
/* 223 */     if (calc > 100) calc -= 100; 
/* 224 */     float r = 360.0F;
/* 225 */     float r2 = 180.0F;
/* 226 */     float n4 = par4;
/* 227 */     float n5 = par5;
/*     */     
/* 229 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 230 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 231 */     float ex = par7Entity.field_70173_aa;
/* 232 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 233 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 235 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 236 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 285 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 286 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 287 */     this.ArmR1.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 288 */     this.ArmL1.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 290 */     this.LegR.field_78796_g = 0.0F;
/* 291 */     this.LegL.field_78796_g = 0.0F;
/* 292 */     this.ArmR1.field_78796_g = 0.0F;
/* 293 */     this.ArmL1.field_78796_g = 0.0F;
/*     */ 
/*     */     
/* 296 */     this.Cloth.field_78795_f = 0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 297 */     this.Cloth.field_78795_f = 0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 298 */     this.Cloth.field_78795_f = 0.15F + this.LegL.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 299 */     this.Cloth.field_78795_f = 0.15F + this.LegL.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 300 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbsbroly\ModelDBSBrolyBuff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */