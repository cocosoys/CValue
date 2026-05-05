/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelKoitsukai
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head1;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer Arm1R;
/*     */   public ModelRenderer Arm1L;
/*     */   public ModelRenderer Leg1R;
/*     */   public ModelRenderer Leg1L;
/*     */   public ModelRenderer Head2;
/*     */   public ModelRenderer Head5;
/*     */   public ModelRenderer Head3;
/*     */   public ModelRenderer Head4;
/*     */   public ModelRenderer BodyTop1;
/*     */   public ModelRenderer ShoulderR;
/*     */   public ModelRenderer ShoulderL;
/*     */   public ModelRenderer BodyBackR;
/*     */   public ModelRenderer BodyBackL;
/*     */   public ModelRenderer BodyTop2;
/*     */   public ModelRenderer BodyBottom1;
/*     */   public ModelRenderer BodyBottom2;
/*     */   public ModelRenderer BodyBottom3;
/*     */   public ModelRenderer BodyBottom4;
/*     */   public ModelRenderer Arm2R;
/*     */   public ModelRenderer Arm3R;
/*     */   public ModelRenderer Arm4R;
/*     */   public ModelRenderer Arm5R;
/*     */   public ModelRenderer Arm6R;
/*     */   public ModelRenderer Arm7R;
/*     */   public ModelRenderer Arm8R;
/*     */   public ModelRenderer Arm9R;
/*     */   public ModelRenderer Arm10R;
/*     */   public ModelRenderer Arm11R;
/*     */   public ModelRenderer ArmVentR;
/*     */   public ModelRenderer HandR;
/*     */   public ModelRenderer Arm12R;
/*     */   public ModelRenderer Finger11R;
/*     */   public ModelRenderer Finger21R;
/*     */   public ModelRenderer Finger31R;
/*     */   public ModelRenderer Finger12R;
/*     */   public ModelRenderer Finger22R;
/*     */   public ModelRenderer Finger32R;
/*     */   public ModelRenderer Arm2L;
/*     */   public ModelRenderer Arm3L;
/*     */   public ModelRenderer Arm4L;
/*     */   public ModelRenderer Arm5L;
/*     */   public ModelRenderer Arm6L;
/*     */   public ModelRenderer Arm7L;
/*     */   public ModelRenderer Arm8L;
/*     */   public ModelRenderer Arm9L;
/*     */   public ModelRenderer Arm10L;
/*     */   public ModelRenderer Arm11L;
/*     */   public ModelRenderer ArmVentL;
/*     */   public ModelRenderer HandL;
/*     */   public ModelRenderer Arm12L;
/*     */   public ModelRenderer Finger11L;
/*     */   public ModelRenderer Finger21L;
/*     */   public ModelRenderer Finger31L;
/*     */   public ModelRenderer Finger12L;
/*     */   public ModelRenderer Finger22L;
/*     */   public ModelRenderer Finger32L;
/*     */   public ModelRenderer Leg2R;
/*     */   public ModelRenderer Leg3R;
/*     */   public ModelRenderer KneeR;
/*     */   public ModelRenderer FootR;
/*     */   public ModelRenderer Leg2L;
/*     */   public ModelRenderer Leg3L;
/*     */   public ModelRenderer KneeL;
/*     */   public ModelRenderer FootL;
/*     */   
/*     */   public ModelKoitsukai() {
/*  78 */     this.field_78090_t = 256;
/*  79 */     this.field_78089_u = 128;
/*  80 */     this.ArmVentL = new ModelRenderer(this, 209, 108);
/*  81 */     this.ArmVentL.field_78809_i = true;
/*  82 */     this.ArmVentL.func_78793_a(6.7F, 13.6F, 0.0F);
/*  83 */     this.ArmVentL.func_78790_a(-1.6F, -4.4F, -3.0F, 3, 7, 6, 0.0F);
/*  84 */     setRotateAngle(this.ArmVentL, 0.0F, 0.0F, -0.2443461F);
/*  85 */     this.Head5 = new ModelRenderer(this, 44, 6);
/*  86 */     this.Head5.func_78793_a(0.0F, 0.0F, 0.0F);
/*  87 */     this.Head5.func_78790_a(-3.5F, -1.0F, -8.6F, 7, 1, 2, 0.0F);
/*  88 */     this.Arm4R = new ModelRenderer(this, 150, 30);
/*  89 */     this.Arm4R.func_78793_a(0.0F, 1.9F, 0.0F);
/*  90 */     this.Arm4R.func_78790_a(-2.0F, 0.1F, -2.0F, 4, 2, 4, 0.0F);
/*  91 */     setRotateAngle(this.Arm4R, -0.17453292F, 0.0F, 0.0F);
/*  92 */     this.Finger31R = new ModelRenderer(this, 147, 112);
/*  93 */     this.Finger31R.func_78793_a(4.2F, 24.0F, 0.0F);
/*  94 */     this.Finger31R.func_78790_a(-1.5F, -0.9F, -1.0F, 3, 5, 2, 0.0F);
/*  95 */     setRotateAngle(this.Finger31R, 0.0F, 0.0F, -0.34906584F);
/*  96 */     this.Finger12R = new ModelRenderer(this, 150, 121);
/*  97 */     this.Finger12R.func_78793_a(0.0F, 4.1F, 0.0F);
/*  98 */     this.Finger12R.func_78790_a(-1.0F, -0.9F, -0.5F, 2, 5, 1, 0.0F);
/*  99 */     setRotateAngle(this.Finger12R, 0.0F, 0.0F, -0.87266463F);
/* 100 */     this.Head1 = new ModelRenderer(this, 0, 0);
/* 101 */     this.Head1.func_78793_a(0.0F, -12.2F, 0.0F);
/* 102 */     this.Head1.func_78790_a(-3.5F, 0.0F, -8.0F, 7, 7, 16, 0.0F);
/* 103 */     this.Arm8R = new ModelRenderer(this, 150, 38);
/* 104 */     this.Arm8R.func_78793_a(0.0F, 1.5F, 0.0F);
/* 105 */     this.Arm8R.func_78790_a(-3.0F, 0.0F, -4.0F, 6, 2, 8, 0.0F);
/* 106 */     setRotateAngle(this.Arm8R, -0.34906584F, 0.0F, 0.0F);
/* 107 */     this.Arm5R = new ModelRenderer(this, 150, 30);
/* 108 */     this.Arm5R.func_78793_a(0.0F, 1.9F, 0.0F);
/* 109 */     this.Arm5R.func_78790_a(-2.0F, 0.1F, -2.0F, 4, 2, 4, 0.0F);
/* 110 */     setRotateAngle(this.Arm5R, -0.17453292F, 0.0F, 0.0F);
/* 111 */     this.Arm12L = new ModelRenderer(this, 191, 112);
/* 112 */     this.Arm12L.field_78809_i = true;
/* 113 */     this.Arm12L.func_78793_a(0.0F, 0.0F, 0.0F);
/* 114 */     this.Arm12L.func_78790_a(3.5F, 18.0F, -6.0F, 2, 3, 12, 0.0F);
/* 115 */     this.BodyTop1 = new ModelRenderer(this, 58, 45);
/* 116 */     this.BodyTop1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 117 */     this.BodyTop1.func_78790_a(-6.0F, -1.0F, -6.0F, 12, 1, 12, 0.0F);
/* 118 */     this.Arm1R = new ModelRenderer(this, 124, 24);
/* 119 */     this.Arm1R.func_78793_a(-6.8F, -7.1F, 0.5F);
/* 120 */     this.Arm1R.func_78790_a(-3.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
/* 121 */     this.Arm7R = new ModelRenderer(this, 150, 30);
/* 122 */     this.Arm7R.func_78793_a(0.0F, 1.9F, 0.0F);
/* 123 */     this.Arm7R.func_78790_a(-2.0F, 0.1F, -2.0F, 4, 2, 4, 0.0F);
/* 124 */     setRotateAngle(this.Arm7R, -0.17453292F, 0.0F, 0.0F);
/* 125 */     this.Leg3L = new ModelRenderer(this, 1, 98);
/* 126 */     this.Leg3L.func_78793_a(0.0F, 5.3F, -0.1F);
/* 127 */     this.Leg3L.func_78790_a(-2.0F, -0.1F, -2.0F, 4, 9, 4, 0.0F);
/* 128 */     setRotateAngle(this.Leg3L, 0.05235988F, 0.0F, 0.09599311F);
/* 129 */     this.Finger21R = new ModelRenderer(this, 147, 112);
/* 130 */     this.Finger21R.func_78793_a(-3.1F, 24.0F, 4.7F);
/* 131 */     this.Finger21R.func_78790_a(-1.5F, -0.9F, -1.0F, 3, 5, 2, 0.0F);
/* 132 */     setRotateAngle(this.Finger21R, 0.0F, 0.34906584F, 0.34906584F);
/* 133 */     this.Leg3R = new ModelRenderer(this, 1, 98);
/* 134 */     this.Leg3R.func_78793_a(0.0F, 5.3F, -0.1F);
/* 135 */     this.Leg3R.func_78790_a(-2.0F, -0.1F, -2.0F, 4, 9, 4, 0.0F);
/* 136 */     setRotateAngle(this.Leg3R, 0.05235988F, 0.0F, -0.09599311F);
/* 137 */     this.Finger22R = new ModelRenderer(this, 150, 121);
/* 138 */     this.Finger22R.func_78793_a(0.0F, 4.1F, 0.0F);
/* 139 */     this.Finger22R.func_78790_a(-1.0F, -0.9F, -0.5F, 2, 5, 1, 0.0F);
/* 140 */     setRotateAngle(this.Finger22R, 0.0F, 0.0F, -0.87266463F);
/* 141 */     this.Leg2R = new ModelRenderer(this, 20, 88);
/* 142 */     this.Leg2R.func_78793_a(0.0F, 1.6F, 0.0F);
/* 143 */     this.Leg2R.func_78790_a(-1.0F, -0.1F, -1.0F, 2, 6, 2, 0.0F);
/* 144 */     setRotateAngle(this.Leg2R, -0.05235988F, 0.0F, 0.09599311F);
/* 145 */     this.Arm6L = new ModelRenderer(this, 150, 30);
/* 146 */     this.Arm6L.field_78809_i = true;
/* 147 */     this.Arm6L.func_78793_a(0.0F, 1.9F, 0.0F);
/* 148 */     this.Arm6L.func_78790_a(-2.0F, 0.1F, -2.0F, 4, 2, 4, 0.0F);
/* 149 */     setRotateAngle(this.Arm6L, -0.17453292F, 0.0F, 0.0F);
/* 150 */     this.BodyBottom1 = new ModelRenderer(this, 1, 71);
/* 151 */     this.BodyBottom1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 152 */     this.BodyBottom1.func_78790_a(-6.5F, 12.0F, -6.0F, 13, 3, 12, 0.0F);
/* 153 */     this.Arm10R = new ModelRenderer(this, 150, 63);
/* 154 */     this.Arm10R.func_78793_a(0.0F, 0.0F, 0.0F);
/* 155 */     this.Arm10R.func_78790_a(-5.0F, 4.0F, -6.0F, 10, 2, 12, 0.0F);
/* 156 */     this.Arm2R = new ModelRenderer(this, 150, 18);
/* 157 */     this.Arm2R.func_78793_a(-1.0F, -0.8F, -0.7F);
/* 158 */     this.Arm2R.func_78790_a(-2.0F, 0.1F, -2.0F, 4, 6, 4, 0.0F);
/* 159 */     setRotateAngle(this.Arm2R, 0.34906584F, 0.0F, 1.134464F);
/* 160 */     this.Leg2L = new ModelRenderer(this, 20, 88);
/* 161 */     this.Leg2L.func_78793_a(0.0F, 1.6F, 0.0F);
/* 162 */     this.Leg2L.func_78790_a(-1.0F, -0.1F, -1.0F, 2, 6, 2, 0.0F);
/* 163 */     setRotateAngle(this.Leg2L, -0.05235988F, 0.0F, -0.09599311F);
/* 164 */     this.Arm3R = new ModelRenderer(this, 150, 30);
/* 165 */     this.Arm3R.func_78793_a(0.0F, 5.9F, 0.0F);
/* 166 */     this.Arm3R.func_78790_a(-2.0F, 0.1F, -2.0F, 4, 2, 4, 0.0F);
/* 167 */     setRotateAngle(this.Arm3R, -0.17453292F, 0.0F, 0.0F);
/* 168 */     this.Head2 = new ModelRenderer(this, 48, 6);
/* 169 */     this.Head2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 170 */     this.Head2.func_78790_a(-3.5F, -2.0F, -7.5F, 7, 2, 15, 0.0F);
/* 171 */     this.Arm6R = new ModelRenderer(this, 150, 30);
/* 172 */     this.Arm6R.func_78793_a(0.0F, 1.9F, 0.0F);
/* 173 */     this.Arm6R.func_78790_a(-2.0F, 0.1F, -2.0F, 4, 2, 4, 0.0F);
/* 174 */     setRotateAngle(this.Arm6R, -0.17453292F, 0.0F, 0.0F);
/* 175 */     this.Finger11R = new ModelRenderer(this, 147, 112);
/* 176 */     this.Finger11R.func_78793_a(-3.1F, 24.0F, -4.7F);
/* 177 */     this.Finger11R.func_78790_a(-1.5F, -0.9F, -1.0F, 3, 5, 2, 0.0F);
/* 178 */     setRotateAngle(this.Finger11R, 0.0F, -0.34906584F, 0.34906584F);
/* 179 */     this.KneeL = new ModelRenderer(this, 20, 106);
/* 180 */     this.KneeL.func_78793_a(0.1F, 1.6F, 0.0F);
/* 181 */     this.KneeL.func_78790_a(-1.0F, -2.7F, -3.0F, 2, 3, 2, 0.0F);
/* 182 */     this.BodyBottom2 = new ModelRenderer(this, 52, 72);
/* 183 */     this.BodyBottom2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 184 */     this.BodyBottom2.func_78790_a(-6.0F, 14.8F, -5.5F, 12, 3, 11, 0.0F);
/* 185 */     this.Arm5L = new ModelRenderer(this, 150, 30);
/* 186 */     this.Arm5L.field_78809_i = true;
/* 187 */     this.Arm5L.func_78793_a(0.0F, 1.9F, 0.0F);
/* 188 */     this.Arm5L.func_78790_a(-2.0F, 0.1F, -2.0F, 4, 2, 4, 0.0F);
/* 189 */     setRotateAngle(this.Arm5L, -0.17453292F, 0.0F, 0.0F);
/* 190 */     this.Arm3L = new ModelRenderer(this, 150, 30);
/* 191 */     this.Arm3L.field_78809_i = true;
/* 192 */     this.Arm3L.func_78793_a(0.0F, 5.9F, 0.0F);
/* 193 */     this.Arm3L.func_78790_a(-2.0F, 0.1F, -2.0F, 4, 2, 4, 0.0F);
/* 194 */     setRotateAngle(this.Arm3L, -0.17453292F, 0.0F, 0.0F);
/* 195 */     this.Finger22L = new ModelRenderer(this, 150, 121);
/* 196 */     this.Finger22L.func_78793_a(0.0F, 4.1F, 0.0F);
/* 197 */     this.Finger22L.func_78790_a(-1.0F, -0.9F, -0.5F, 2, 5, 1, 0.0F);
/* 198 */     setRotateAngle(this.Finger22L, 0.0F, 0.0F, 0.87266463F);
/* 199 */     this.ShoulderL = new ModelRenderer(this, 170, 18);
/* 200 */     this.ShoulderL.field_78809_i = true;
/* 201 */     this.ShoulderL.func_78793_a(0.0F, 0.0F, 0.0F);
/* 202 */     this.ShoulderL.func_78790_a(6.5F, 1.0F, -3.5F, 4, 5, 8, 0.0F);
/* 203 */     this.Finger32L = new ModelRenderer(this, 150, 121);
/* 204 */     this.Finger32L.func_78793_a(0.0F, 4.1F, 0.0F);
/* 205 */     this.Finger32L.func_78790_a(-1.0F, -0.9F, -0.5F, 2, 5, 1, 0.0F);
/* 206 */     setRotateAngle(this.Finger32L, 0.0F, 0.0F, -0.87266463F);
/* 207 */     this.Head4 = new ModelRenderer(this, 43, 28);
/* 208 */     this.Head4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 209 */     this.Head4.func_78790_a(-3.5F, -4.0F, -4.5F, 7, 1, 9, 0.0F);
/* 210 */     this.Arm8L = new ModelRenderer(this, 150, 38);
/* 211 */     this.Arm8L.field_78809_i = true;
/* 212 */     this.Arm8L.func_78793_a(0.0F, 1.5F, 0.0F);
/* 213 */     this.Arm8L.func_78790_a(-3.0F, 0.0F, -4.0F, 6, 2, 8, 0.0F);
/* 214 */     setRotateAngle(this.Arm8L, -0.34906584F, 0.0F, 0.0F);
/* 215 */     this.Finger11L = new ModelRenderer(this, 147, 112);
/* 216 */     this.Finger11L.func_78793_a(3.3F, 24.0F, -4.7F);
/* 217 */     this.Finger11L.func_78790_a(-1.5F, -0.9F, -1.0F, 3, 5, 2, 0.0F);
/* 218 */     setRotateAngle(this.Finger11L, 0.0F, 0.34906584F, -0.34906584F);
/* 219 */     this.FootL = new ModelRenderer(this, 1, 113);
/* 220 */     this.FootL.func_78793_a(0.0F, 9.0F, 0.0F);
/* 221 */     this.FootL.func_78790_a(-2.0F, -0.1F, -6.0F, 4, 3, 11, 0.0F);
/* 222 */     this.ShoulderR = new ModelRenderer(this, 170, 18);
/* 223 */     this.ShoulderR.func_78793_a(0.0F, 0.0F, 0.0F);
/* 224 */     this.ShoulderR.func_78790_a(-10.5F, 1.0F, -3.5F, 4, 5, 8, 0.0F);
/* 225 */     this.Leg1R = new ModelRenderer(this, 3, 90);
/* 226 */     this.Leg1R.func_78793_a(-3.0F, 5.3F, 0.0F);
/* 227 */     this.Leg1R.func_78790_a(-1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F);
/* 228 */     this.HandR = new ModelRenderer(this, 159, 104);
/* 229 */     this.HandR.func_78793_a(0.0F, 0.0F, 0.0F);
/* 230 */     this.HandR.func_78790_a(-4.5F, 18.0F, -5.5F, 10, 7, 11, 0.0F);
/* 231 */     this.BodyBottom3 = new ModelRenderer(this, 98, 88);
/* 232 */     this.BodyBottom3.func_78793_a(0.0F, 16.7F, 0.0F);
/* 233 */     this.BodyBottom3.func_78790_a(-1.0F, -1.9F, -4.5F, 2, 5, 9, 0.0F);
/* 234 */     this.BodyBackR = new ModelRenderer(this, 93, 64);
/* 235 */     this.BodyBackR.func_78793_a(-5.0F, 9.0F, 6.2F);
/* 236 */     this.BodyBackR.func_78790_a(-1.0F, -2.8F, -0.4F, 2, 8, 2, 0.0F);
/* 237 */     this.Finger31L = new ModelRenderer(this, 147, 112);
/* 238 */     this.Finger31L.func_78793_a(-3.9F, 24.0F, -0.5F);
/* 239 */     this.Finger31L.func_78790_a(-1.5F, -0.9F, -1.0F, 3, 5, 2, 0.0F);
/* 240 */     setRotateAngle(this.Finger31L, 0.0F, 0.0F, 0.34906584F);
/* 241 */     this.BodyTop2 = new ModelRenderer(this, 95, 44);
/* 242 */     this.BodyTop2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 243 */     this.BodyTop2.func_78790_a(-5.0F, -2.0F, -5.0F, 10, 1, 10, 0.0F);
/* 244 */     this.Arm1L = new ModelRenderer(this, 124, 24);
/* 245 */     this.Arm1L.field_78809_i = true;
/* 246 */     this.Arm1L.func_78793_a(6.8F, -7.1F, 0.5F);
/* 247 */     this.Arm1L.func_78790_a(-3.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
/* 248 */     this.Finger12L = new ModelRenderer(this, 150, 121);
/* 249 */     this.Finger12L.func_78793_a(0.0F, 4.1F, 0.0F);
/* 250 */     this.Finger12L.func_78790_a(-1.0F, -0.9F, -0.5F, 2, 5, 1, 0.0F);
/* 251 */     setRotateAngle(this.Finger12L, 0.0F, 0.0F, 0.87266463F);
/* 252 */     this.Arm12R = new ModelRenderer(this, 191, 112);
/* 253 */     this.Arm12R.func_78793_a(0.0F, 0.0F, 0.0F);
/* 254 */     this.Arm12R.func_78790_a(-5.5F, 18.0F, -6.0F, 2, 3, 12, 0.0F);
/* 255 */     this.Arm9R = new ModelRenderer(this, 150, 49);
/* 256 */     this.Arm9R.func_78793_a(0.0F, 0.0F, 0.0F);
/* 257 */     this.Arm9R.func_78790_a(-4.0F, 2.0F, -5.5F, 8, 2, 11, 0.0F);
/* 258 */     this.Arm11L = new ModelRenderer(this, 148, 78);
/* 259 */     this.Arm11L.field_78809_i = true;
/* 260 */     this.Arm11L.func_78793_a(0.0F, 0.0F, 0.0F);
/* 261 */     this.Arm11L.func_78790_a(-6.0F, 6.0F, -6.5F, 12, 12, 13, 0.0F);
/* 262 */     this.Finger21L = new ModelRenderer(this, 147, 112);
/* 263 */     this.Finger21L.func_78793_a(3.3F, 24.0F, 4.7F);
/* 264 */     this.Finger21L.func_78790_a(-1.5F, -0.9F, -1.0F, 3, 5, 2, 0.0F);
/* 265 */     setRotateAngle(this.Finger21L, 0.0F, -0.34906584F, -0.34906584F);
/* 266 */     this.Body1 = new ModelRenderer(this, 1, 44);
/* 267 */     this.Body1.func_78793_a(0.0F, -12.2F, 0.0F);
/* 268 */     this.Body1.func_78790_a(-7.0F, 0.0F, -6.5F, 14, 12, 13, 0.0F);
/* 269 */     this.Arm11R = new ModelRenderer(this, 148, 78);
/* 270 */     this.Arm11R.func_78793_a(0.0F, 0.0F, 0.0F);
/* 271 */     this.Arm11R.func_78790_a(-6.0F, 6.0F, -6.5F, 12, 12, 13, 0.0F);
/* 272 */     this.ArmVentR = new ModelRenderer(this, 209, 108);
/* 273 */     this.ArmVentR.func_78793_a(-6.3F, 13.6F, 0.0F);
/* 274 */     this.ArmVentR.func_78790_a(-1.9F, -4.4F, -3.0F, 3, 7, 6, 0.0F);
/* 275 */     setRotateAngle(this.ArmVentR, 0.0F, 0.0F, 0.2443461F);
/* 276 */     this.FootR = new ModelRenderer(this, 1, 113);
/* 277 */     this.FootR.func_78793_a(0.0F, 9.0F, 0.0F);
/* 278 */     this.FootR.func_78790_a(-2.0F, -0.1F, -6.0F, 4, 3, 11, 0.0F);
/* 279 */     this.HandL = new ModelRenderer(this, 159, 104);
/* 280 */     this.HandL.field_78809_i = true;
/* 281 */     this.HandL.func_78793_a(0.0F, 0.0F, 0.0F);
/* 282 */     this.HandL.func_78790_a(-5.3F, 18.0F, -5.5F, 10, 7, 11, 0.0F);
/* 283 */     this.Arm2L = new ModelRenderer(this, 150, 18);
/* 284 */     this.Arm2L.field_78809_i = true;
/* 285 */     this.Arm2L.func_78793_a(1.2F, -0.8F, -0.7F);
/* 286 */     this.Arm2L.func_78790_a(-2.0F, 0.1F, -2.0F, 4, 6, 4, 0.0F);
/* 287 */     setRotateAngle(this.Arm2L, 0.34906584F, 0.0F, -1.134464F);
/* 288 */     this.BodyBackL = new ModelRenderer(this, 93, 64);
/* 289 */     this.BodyBackL.func_78793_a(5.0F, 9.0F, 6.2F);
/* 290 */     this.BodyBackL.func_78790_a(-1.0F, -2.8F, -0.4F, 2, 8, 2, 0.0F);
/* 291 */     this.Arm10L = new ModelRenderer(this, 150, 63);
/* 292 */     this.Arm10L.field_78809_i = true;
/* 293 */     this.Arm10L.func_78793_a(0.0F, 0.0F, 0.0F);
/* 294 */     this.Arm10L.func_78790_a(-5.0F, 4.0F, -6.0F, 10, 2, 12, 0.0F);
/* 295 */     this.Head3 = new ModelRenderer(this, 1, 24);
/* 296 */     this.Head3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 297 */     this.Head3.func_78790_a(-3.5F, -3.0F, -6.7F, 7, 1, 13, 0.0F);
/* 298 */     this.BodyBottom4 = new ModelRenderer(this, 100, 82);
/* 299 */     this.BodyBottom4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 300 */     this.BodyBottom4.func_78790_a(-4.0F, -1.4F, -1.1F, 8, 3, 2, 0.0F);
/* 301 */     this.Leg1L = new ModelRenderer(this, 3, 90);
/* 302 */     this.Leg1L.func_78793_a(3.0F, 5.3F, 0.0F);
/* 303 */     this.Leg1L.func_78790_a(-1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F);
/* 304 */     this.Arm9L = new ModelRenderer(this, 150, 49);
/* 305 */     this.Arm9L.field_78809_i = true;
/* 306 */     this.Arm9L.func_78793_a(0.0F, 0.0F, 0.0F);
/* 307 */     this.Arm9L.func_78790_a(-4.0F, 2.0F, -5.5F, 8, 2, 11, 0.0F);
/* 308 */     this.Arm7L = new ModelRenderer(this, 150, 30);
/* 309 */     this.Arm7L.field_78809_i = true;
/* 310 */     this.Arm7L.func_78793_a(0.0F, 1.9F, 0.0F);
/* 311 */     this.Arm7L.func_78790_a(-2.0F, 0.1F, -2.0F, 4, 2, 4, 0.0F);
/* 312 */     setRotateAngle(this.Arm7L, -0.17453292F, 0.0F, 0.0F);
/* 313 */     this.Arm4L = new ModelRenderer(this, 150, 30);
/* 314 */     this.Arm4L.field_78809_i = true;
/* 315 */     this.Arm4L.func_78793_a(0.0F, 1.9F, 0.0F);
/* 316 */     this.Arm4L.func_78790_a(-2.0F, 0.1F, -2.0F, 4, 2, 4, 0.0F);
/* 317 */     setRotateAngle(this.Arm4L, -0.17453292F, 0.0F, 0.0F);
/* 318 */     this.Finger32R = new ModelRenderer(this, 150, 121);
/* 319 */     this.Finger32R.func_78793_a(0.0F, 4.1F, 0.0F);
/* 320 */     this.Finger32R.func_78790_a(-1.0F, -0.9F, -0.5F, 2, 5, 1, 0.0F);
/* 321 */     setRotateAngle(this.Finger32R, 0.0F, 0.0F, 0.87266463F);
/* 322 */     this.KneeR = new ModelRenderer(this, 20, 106);
/* 323 */     this.KneeR.func_78793_a(0.1F, 1.6F, 0.0F);
/* 324 */     this.KneeR.func_78790_a(-1.0F, -2.7F, -3.0F, 2, 3, 2, 0.0F);
/* 325 */     this.Arm11L.func_78792_a(this.ArmVentL);
/* 326 */     this.Head1.func_78792_a(this.Head5);
/* 327 */     this.Arm3R.func_78792_a(this.Arm4R);
/* 328 */     this.HandR.func_78792_a(this.Finger31R);
/* 329 */     this.Finger11R.func_78792_a(this.Finger12R);
/* 330 */     this.Arm7R.func_78792_a(this.Arm8R);
/* 331 */     this.Arm4R.func_78792_a(this.Arm5R);
/* 332 */     this.Arm11L.func_78792_a(this.Arm12L);
/* 333 */     this.Body1.func_78792_a(this.BodyTop1);
/* 334 */     this.Arm6R.func_78792_a(this.Arm7R);
/* 335 */     this.Leg2L.func_78792_a(this.Leg3L);
/* 336 */     this.HandR.func_78792_a(this.Finger21R);
/* 337 */     this.Leg2R.func_78792_a(this.Leg3R);
/* 338 */     this.Finger21R.func_78792_a(this.Finger22R);
/* 339 */     this.Leg1R.func_78792_a(this.Leg2R);
/* 340 */     this.Arm5L.func_78792_a(this.Arm6L);
/* 341 */     this.BodyTop1.func_78792_a(this.BodyBottom1);
/* 342 */     this.Arm9R.func_78792_a(this.Arm10R);
/* 343 */     this.Arm1R.func_78792_a(this.Arm2R);
/* 344 */     this.Leg1L.func_78792_a(this.Leg2L);
/* 345 */     this.Arm2R.func_78792_a(this.Arm3R);
/* 346 */     this.Head1.func_78792_a(this.Head2);
/* 347 */     this.Arm5R.func_78792_a(this.Arm6R);
/* 348 */     this.HandR.func_78792_a(this.Finger11R);
/* 349 */     this.Leg3L.func_78792_a(this.KneeL);
/* 350 */     this.BodyBottom1.func_78792_a(this.BodyBottom2);
/* 351 */     this.Arm4L.func_78792_a(this.Arm5L);
/* 352 */     this.Arm2L.func_78792_a(this.Arm3L);
/* 353 */     this.Finger21L.func_78792_a(this.Finger22L);
/* 354 */     this.Body1.func_78792_a(this.ShoulderL);
/* 355 */     this.Finger31L.func_78792_a(this.Finger32L);
/* 356 */     this.Head3.func_78792_a(this.Head4);
/* 357 */     this.Arm7L.func_78792_a(this.Arm8L);
/* 358 */     this.HandL.func_78792_a(this.Finger11L);
/* 359 */     this.Leg3L.func_78792_a(this.FootL);
/* 360 */     this.Body1.func_78792_a(this.ShoulderR);
/* 361 */     this.Arm11R.func_78792_a(this.HandR);
/* 362 */     this.BodyBottom2.func_78792_a(this.BodyBottom3);
/* 363 */     this.Body1.func_78792_a(this.BodyBackR);
/* 364 */     this.HandL.func_78792_a(this.Finger31L);
/* 365 */     this.BodyTop1.func_78792_a(this.BodyTop2);
/* 366 */     this.Finger11L.func_78792_a(this.Finger12L);
/* 367 */     this.Arm11R.func_78792_a(this.Arm12R);
/* 368 */     this.Arm8R.func_78792_a(this.Arm9R);
/* 369 */     this.Arm10L.func_78792_a(this.Arm11L);
/* 370 */     this.HandL.func_78792_a(this.Finger21L);
/* 371 */     this.Arm10R.func_78792_a(this.Arm11R);
/* 372 */     this.Arm11R.func_78792_a(this.ArmVentR);
/* 373 */     this.Leg3R.func_78792_a(this.FootR);
/* 374 */     this.Arm11L.func_78792_a(this.HandL);
/* 375 */     this.Arm1L.func_78792_a(this.Arm2L);
/* 376 */     this.Body1.func_78792_a(this.BodyBackL);
/* 377 */     this.Arm9L.func_78792_a(this.Arm10L);
/* 378 */     this.Head2.func_78792_a(this.Head3);
/* 379 */     this.BodyBottom3.func_78792_a(this.BodyBottom4);
/* 380 */     this.Arm8L.func_78792_a(this.Arm9L);
/* 381 */     this.Arm6L.func_78792_a(this.Arm7L);
/* 382 */     this.Arm3L.func_78792_a(this.Arm4L);
/* 383 */     this.Finger31R.func_78792_a(this.Finger32R);
/* 384 */     this.Leg3R.func_78792_a(this.KneeR);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 389 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 392 */     this.Head1.func_78785_a(f5);
/* 393 */     this.Arm1R.func_78785_a(f5);
/* 394 */     this.Leg1R.func_78785_a(f5);
/* 395 */     this.Arm1L.func_78785_a(f5);
/* 396 */     this.Body1.func_78785_a(f5);
/* 397 */     this.Leg1L.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 403 */     modelRenderer.field_78795_f = x;
/* 404 */     modelRenderer.field_78796_g = y;
/* 405 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 409 */     int calc = par7Entity.field_70173_aa;
/* 410 */     if (calc > 100) calc -= 100; 
/* 411 */     float r = 360.0F;
/* 412 */     float r2 = 180.0F;
/* 413 */     float n4 = par4;
/* 414 */     float n5 = par5;
/*     */ 
/*     */ 
/*     */     
/* 418 */     float ex = par7Entity.field_70173_aa;
/* 419 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 420 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 422 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 423 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 469 */     this.Leg1R.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 470 */     this.Leg1L.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */ 
/*     */ 
/*     */     
/* 474 */     this.Leg1R.field_78796_g = 0.0F;
/* 475 */     this.Leg1L.field_78796_g = 0.0F;
/* 476 */     this.Arm1R.field_78796_g = 0.0F;
/* 477 */     this.Arm1L.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 484 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelKoitsukai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */