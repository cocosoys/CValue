/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModelRRMecha
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Base1;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer Spine1;
/*     */   public ModelRenderer Belly1;
/*     */   public ModelRenderer Head1;
/*     */   public ModelRenderer BottomBase;
/*     */   public ModelRenderer Extra10;
/*     */   public ModelRenderer Extra20;
/*     */   public ModelRenderer Extra30;
/*     */   public ModelRenderer Extra40;
/*     */   public ModelRenderer ShoulderL;
/*     */   public ModelRenderer ShoulderR;
/*     */   public ModelRenderer Back1;
/*     */   public ModelRenderer Back2;
/*     */   public ModelRenderer BackTop1;
/*     */   public ModelRenderer BackTop2;
/*     */   public ModelRenderer Belly2;
/*     */   public ModelRenderer Belly3;
/*     */   public ModelRenderer HeadTop;
/*     */   public ModelRenderer HeadFront;
/*     */   public ModelRenderer HeadBack;
/*     */   public ModelRenderer BottomBack;
/*     */   public ModelRenderer BottomFront;
/*     */   public ModelRenderer BottomBack2;
/*     */   public ModelRenderer Extra11;
/*     */   public ModelRenderer Extra12;
/*     */   public ModelRenderer Extra21;
/*     */   public ModelRenderer Extra22;
/*     */   public ModelRenderer ArmL2;
/*     */   public ModelRenderer ArmL3;
/*     */   public ModelRenderer ArmL4;
/*     */   public ModelRenderer ArmR2;
/*     */   public ModelRenderer ArmR3;
/*     */   public ModelRenderer ArmR4;
/*     */   public ModelRenderer LegL2;
/*     */   public ModelRenderer LegL3;
/*     */   public ModelRenderer LegR2;
/*     */   public ModelRenderer LegR3;
/*     */   
/*     */   public ModelRRMecha() {
/*  58 */     this.field_78090_t = 128;
/*  59 */     this.field_78089_u = 128;
/*  60 */     this.BottomFront = new ModelRenderer(this, 47, 79);
/*  61 */     this.BottomFront.func_78793_a(0.0F, 0.0F, 0.0F);
/*  62 */     this.BottomFront.func_78790_a(-3.5F, 7.2F, 5.0F, 7, 4, 6, 0.0F);
/*  63 */     setRotateAngle(this.BottomFront, -0.7285004F, 0.0F, 0.0F);
/*  64 */     this.Extra12 = new ModelRenderer(this, 112, 0);
/*  65 */     this.Extra12.func_78793_a(0.0F, 0.0F, 0.0F);
/*  66 */     this.Extra12.func_78790_a(-1.5F, 2.7F, -2.4F, 3, 1, 1, 0.0F);
/*  67 */     this.Extra30 = new ModelRenderer(this, 104, 0);
/*  68 */     this.Extra30.func_78793_a(0.0F, 0.0F, 0.0F);
/*  69 */     this.Extra30.func_78790_a(-4.9F, 1.3F, -1.9F, 2, 2, 1, 0.0F);
/*  70 */     setRotateAngle(this.Extra30, 0.0F, 0.3630285F, 0.21642083F);
/*  71 */     this.ArmL = new ModelRenderer(this, 3, 86);
/*  72 */     this.ArmL.func_78793_a(8.5F, 0.1F, 4.9F);
/*  73 */     this.ArmL.func_78790_a(-0.6F, -0.4F, -1.2F, 2, 7, 2, 0.0F);
/*  74 */     setRotateAngle(this.ArmL, 0.11082841F, 0.0F, -0.27576202F);
/*  75 */     this.Spine1 = new ModelRenderer(this, 0, 21);
/*  76 */     this.Spine1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  77 */     this.Spine1.func_78790_a(-7.5F, -1.2F, 1.7F, 15, 10, 6, 0.0F);
/*  78 */     setRotateAngle(this.Spine1, 0.7749262F, 0.0F, 0.0F);
/*  79 */     this.Belly3 = new ModelRenderer(this, 0, 67);
/*  80 */     this.Belly3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  81 */     this.Belly3.func_78790_a(-5.0F, 5.0F, -4.8F, 10, 6, 1, 0.0F);
/*  82 */     this.ArmL2 = new ModelRenderer(this, 1, 96);
/*  83 */     this.ArmL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  84 */     this.ArmL2.func_78790_a(-0.6F, 5.8F, 1.5F, 3, 7, 3, 0.0F);
/*  85 */     setRotateAngle(this.ArmL2, -0.4553564F, 0.0F, 0.0F);
/*  86 */     this.ArmR = new ModelRenderer(this, 18, 86);
/*  87 */     this.ArmR.func_78793_a(-8.5F, 0.1F, 4.9F);
/*  88 */     this.ArmR.func_78790_a(-1.3F, -0.4F, -1.1F, 2, 7, 2, 0.0F);
/*  89 */     setRotateAngle(this.ArmR, 0.11082841F, 0.0F, 0.27576202F);
/*  90 */     this.ArmL4 = new ModelRenderer(this, 1, 114);
/*  91 */     this.ArmL4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  92 */     this.ArmL4.func_78790_a(-0.6F, 12.6F, 1.0F, 3, 4, 4, 0.0F);
/*  93 */     setRotateAngle(this.ArmL4, -0.4553564F, 0.16475908F, 0.0F);
/*  94 */     this.ArmR4 = new ModelRenderer(this, 17, 114);
/*  95 */     this.ArmR4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  96 */     this.ArmR4.func_78790_a(-2.4F, 12.6F, 1.0F, 3, 4, 4, 0.0F);
/*  97 */     setRotateAngle(this.ArmR4, -0.4553564F, -0.1829105F, 0.0F);
/*  98 */     this.ShoulderR = new ModelRenderer(this, 16, 76);
/*  99 */     this.ShoulderR.func_78793_a(0.0F, 0.0F, 0.0F);
/* 100 */     this.ShoulderR.func_78790_a(-8.3F, -4.2F, 3.1F, 3, 5, 4, 0.0F);
/* 101 */     setRotateAngle(this.ShoulderR, 0.7749262F, 0.1308997F, -0.20943952F);
/* 102 */     this.LegR = new ModelRenderer(this, 96, 85);
/* 103 */     this.LegR.func_78793_a(-4.5F, 11.2F, 4.8F);
/* 104 */     this.LegR.func_78790_a(-2.3F, -1.2F, -0.9F, 2, 7, 2, 0.0F);
/* 105 */     setRotateAngle(this.LegR, -0.11047934F, 0.0F, 0.10471976F);
/* 106 */     this.Belly1 = new ModelRenderer(this, 0, 39);
/* 107 */     this.Belly1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 108 */     this.Belly1.func_78790_a(-7.0F, 2.5F, -2.3F, 14, 10, 5, 0.0F);
/* 109 */     setRotateAngle(this.Belly1, 0.7749262F, 0.0F, 0.0F);
/* 110 */     this.LegL2 = new ModelRenderer(this, 73, 97);
/* 111 */     this.LegL2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 112 */     this.LegL2.func_78790_a(0.1F, 5.6F, -2.7F, 4, 6, 4, 0.0F);
/* 113 */     setRotateAngle(this.LegL2, 0.11047934F, 0.0F, 0.10471976F);
/* 114 */     this.Extra20 = new ModelRenderer(this, 113, 3);
/* 115 */     this.Extra20.func_78793_a(0.0F, 0.0F, 0.0F);
/* 116 */     this.Extra20.func_78790_a(-2.5F, 2.7F, -14.1F, 1, 1, 2, 0.0F);
/* 117 */     setRotateAngle(this.Extra20, 1.8430676F, 0.0F, 0.0F);
/* 118 */     this.HeadBack = new ModelRenderer(this, 80, 48);
/* 119 */     this.HeadBack.func_78793_a(0.0F, 0.0F, 0.0F);
/* 120 */     this.HeadBack.func_78790_a(-2.0F, -7.7F, -2.9F, 4, 1, 5, 0.0F);
/* 121 */     this.ArmR3 = new ModelRenderer(this, 19, 107);
/* 122 */     this.ArmR3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 123 */     this.ArmR3.func_78790_a(-3.3F, 7.3F, 1.8F, 2, 4, 2, 0.0F);
/* 124 */     setRotateAngle(this.ArmR3, -0.4553564F, 0.0F, 0.0F);
/* 125 */     this.Head1 = new ModelRenderer(this, 80, 31);
/* 126 */     this.Head1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 127 */     this.Head1.func_78790_a(-3.0F, -6.7F, -4.0F, 6, 6, 4, 0.0F);
/* 128 */     this.BottomBase = new ModelRenderer(this, 46, 51);
/* 129 */     this.BottomBase.func_78793_a(0.0F, 0.0F, 0.0F);
/* 130 */     this.BottomBase.func_78790_a(-3.0F, 8.3F, 0.8F, 6, 7, 7, 0.0F);
/* 131 */     setRotateAngle(this.BottomBase, 0.7749262F, 0.0F, 0.0F);
/* 132 */     this.BottomBack2 = new ModelRenderer(this, 48, 43);
/* 133 */     this.BottomBack2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 134 */     this.BottomBack2.func_78790_a(-2.5F, 16.8F, -3.8F, 5, 2, 5, 0.0F);
/* 135 */     this.LegR2 = new ModelRenderer(this, 94, 97);
/* 136 */     this.LegR2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 137 */     this.LegR2.func_78790_a(-4.1F, 5.6F, -2.7F, 4, 6, 4, 0.0F);
/* 138 */     setRotateAngle(this.LegR2, 0.11047934F, 0.0F, -0.10471976F);
/* 139 */     this.Belly2 = new ModelRenderer(this, 0, 56);
/* 140 */     this.Belly2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 141 */     this.Belly2.func_78790_a(-6.51F, 3.7F, -3.8F, 13, 8, 2, 0.0F);
/* 142 */     this.Extra22 = new ModelRenderer(this, 112, 0);
/* 143 */     this.Extra22.func_78793_a(0.0F, 0.0F, 0.0F);
/* 144 */     this.Extra22.func_78790_a(-1.5F, 2.7F, -14.6F, 3, 1, 1, 0.0F);
/* 145 */     this.ArmL3 = new ModelRenderer(this, 3, 107);
/* 146 */     this.ArmL3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 147 */     this.ArmL3.func_78790_a(1.0F, 7.3F, 1.8F, 2, 4, 2, 0.0F);
/* 148 */     setRotateAngle(this.ArmL3, -0.4553564F, 0.0F, 0.0F);
/* 149 */     this.Extra10 = new ModelRenderer(this, 113, 3);
/* 150 */     this.Extra10.func_78793_a(0.0F, 0.0F, 0.0F);
/* 151 */     this.Extra10.func_78790_a(-2.5F, 2.7F, -2.0F, 1, 1, 2, 0.0F);
/* 152 */     this.ShoulderL = new ModelRenderer(this, 1, 76);
/* 153 */     this.ShoulderL.func_78793_a(0.0F, 0.0F, 0.0F);
/* 154 */     this.ShoulderL.func_78790_a(5.3F, -4.2F, 3.2F, 3, 5, 4, 0.0F);
/* 155 */     setRotateAngle(this.ShoulderL, 0.7749262F, -0.1308997F, 0.20943952F);
/* 156 */     this.Extra21 = new ModelRenderer(this, 113, 3);
/* 157 */     this.Extra21.func_78793_a(0.0F, 0.0F, 0.0F);
/* 158 */     this.Extra21.func_78790_a(1.5F, 2.7F, -14.1F, 1, 1, 2, 0.0F);
/* 159 */     this.Back1 = new ModelRenderer(this, 45, 0);
/* 160 */     this.Back1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 161 */     this.Back1.func_78790_a(-7.0F, 0.0F, 6.8F, 14, 12, 3, 0.0F);
/* 162 */     this.BackTop1 = new ModelRenderer(this, 81, 0);
/* 163 */     this.BackTop1.func_78793_a(0.0F, 0.0F, 0.1F);
/* 164 */     this.BackTop1.func_78790_a(-3.5F, -5.4F, 7.5F, 7, 3, 5, 0.0F);
/* 165 */     setRotateAngle(this.BackTop1, -0.19896753F, 0.0F, 0.0F);
/* 166 */     this.HeadTop = new ModelRenderer(this, 83, 23);
/* 167 */     this.HeadTop.func_78793_a(0.0F, 0.0F, 0.0F);
/* 168 */     this.HeadTop.func_78790_a(-2.0F, -6.2F, -5.0F, 4, 5, 1, 0.0F);
/* 169 */     this.Base1 = new ModelRenderer(this, 0, 0);
/* 170 */     this.Base1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 171 */     this.Base1.func_78790_a(-6.5F, -6.8F, 0.0F, 13, 12, 7, 0.0F);
/* 172 */     setRotateAngle(this.Base1, -0.7749262F, 0.0017453292F, 0.0F);
/* 173 */     this.Extra11 = new ModelRenderer(this, 113, 3);
/* 174 */     this.Extra11.func_78793_a(0.0F, 0.0F, 0.0F);
/* 175 */     this.Extra11.func_78790_a(1.5F, 2.7F, -2.0F, 1, 1, 2, 0.0F);
/* 176 */     this.LegL3 = new ModelRenderer(this, 66, 108);
/* 177 */     this.LegL3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 178 */     this.LegL3.func_78790_a(-0.4F, 10.9F, -4.9F, 5, 2, 7, 0.0F);
/* 179 */     setRotateAngle(this.LegL3, 0.11047934F, 0.0F, 0.10471976F);
/* 180 */     this.Extra40 = new ModelRenderer(this, 104, 0);
/* 181 */     this.Extra40.func_78793_a(0.0F, 0.0F, 0.0F);
/* 182 */     this.Extra40.func_78790_a(2.9F, 1.3F, -1.9F, 2, 2, 1, 0.0F);
/* 183 */     setRotateAngle(this.Extra40, 0.0F, -0.3630285F, -0.23387411F);
/* 184 */     this.BottomBack = new ModelRenderer(this, 46, 66);
/* 185 */     this.BottomBack.func_78793_a(0.0F, 0.0F, 0.0F);
/* 186 */     this.BottomBack.func_78790_a(-3.5F, 12.9F, -5.4F, 7, 4, 8, 0.0F);
/* 187 */     setRotateAngle(this.BottomBack, 0.7749262F, 0.0F, 0.0F);
/* 188 */     this.BackTop2 = new ModelRenderer(this, 81, 10);
/* 189 */     this.BackTop2.func_78793_a(0.0F, 0.0F, 0.1F);
/* 190 */     this.BackTop2.func_78790_a(-3.0F, -6.2F, 7.9F, 6, 1, 4, 0.0F);
/* 191 */     this.ArmR2 = new ModelRenderer(this, 17, 96);
/* 192 */     this.ArmR2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 193 */     this.ArmR2.func_78790_a(-2.3F, 5.8F, 1.5F, 3, 7, 3, 0.0F);
/* 194 */     setRotateAngle(this.ArmR2, -0.4553564F, 0.0F, 0.0F);
/* 195 */     this.LegL = new ModelRenderer(this, 76, 85);
/* 196 */     this.LegL.func_78793_a(4.6F, 11.2F, 4.8F);
/* 197 */     this.LegL.func_78790_a(0.1F, -1.2F, -0.9F, 2, 7, 2, 0.0F);
/* 198 */     setRotateAngle(this.LegL, -0.11052218F, 0.0F, -0.10471976F);
/* 199 */     this.Back2 = new ModelRenderer(this, 47, 17);
/* 200 */     this.Back2.func_78793_a(0.0F, 0.0F, 0.1F);
/* 201 */     this.Back2.func_78790_a(-4.0F, -2.8F, 6.6F, 8, 13, 7, 0.0F);
/* 202 */     this.LegR3 = new ModelRenderer(this, 93, 108);
/* 203 */     this.LegR3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 204 */     this.LegR3.func_78790_a(-4.6F, 10.9F, -4.9F, 5, 2, 7, 0.0F);
/* 205 */     setRotateAngle(this.LegR3, 0.11047934F, 0.0F, -0.10471976F);
/* 206 */     this.HeadFront = new ModelRenderer(this, 80, 42);
/* 207 */     this.HeadFront.func_78793_a(0.0F, 0.0F, 0.0F);
/* 208 */     this.HeadFront.func_78790_a(-2.0F, -0.9F, -3.1F, 4, 1, 4, 0.0F);
/* 209 */     this.BottomBase.func_78792_a(this.BottomFront);
/* 210 */     this.Extra10.func_78792_a(this.Extra12);
/* 211 */     this.Base1.func_78792_a(this.Extra30);
/* 212 */     this.Base1.func_78792_a(this.Spine1);
/* 213 */     this.Belly2.func_78792_a(this.Belly3);
/* 214 */     this.ArmL.func_78792_a(this.ArmL2);
/* 215 */     this.ArmL.func_78792_a(this.ArmL4);
/* 216 */     this.ArmR.func_78792_a(this.ArmR4);
/* 217 */     this.Base1.func_78792_a(this.ShoulderR);
/* 218 */     this.Base1.func_78792_a(this.Belly1);
/* 219 */     this.LegL.func_78792_a(this.LegL2);
/* 220 */     this.Base1.func_78792_a(this.Extra20);
/* 221 */     this.Head1.func_78792_a(this.HeadBack);
/* 222 */     this.ArmR.func_78792_a(this.ArmR3);
/* 223 */     this.Base1.func_78792_a(this.Head1);
/* 224 */     this.Base1.func_78792_a(this.BottomBase);
/* 225 */     this.BottomBack.func_78792_a(this.BottomBack2);
/* 226 */     this.LegR.func_78792_a(this.LegR2);
/* 227 */     this.Belly1.func_78792_a(this.Belly2);
/* 228 */     this.Extra20.func_78792_a(this.Extra22);
/* 229 */     this.ArmL.func_78792_a(this.ArmL3);
/* 230 */     this.Base1.func_78792_a(this.Extra10);
/* 231 */     this.Base1.func_78792_a(this.ShoulderL);
/* 232 */     this.Extra20.func_78792_a(this.Extra21);
/* 233 */     this.Spine1.func_78792_a(this.Back1);
/* 234 */     this.Back2.func_78792_a(this.BackTop1);
/* 235 */     this.Head1.func_78792_a(this.HeadTop);
/* 236 */     this.Extra10.func_78792_a(this.Extra11);
/* 237 */     this.LegL.func_78792_a(this.LegL3);
/* 238 */     this.Base1.func_78792_a(this.Extra40);
/* 239 */     this.BottomBase.func_78792_a(this.BottomBack);
/* 240 */     this.BackTop1.func_78792_a(this.BackTop2);
/* 241 */     this.ArmR.func_78792_a(this.ArmR2);
/* 242 */     this.Back1.func_78792_a(this.Back2);
/* 243 */     this.LegR.func_78792_a(this.LegR3);
/* 244 */     this.Head1.func_78792_a(this.HeadFront);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 249 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/* 250 */     GL11.glPushMatrix();
/* 251 */     float[] sizes = { 0.0F, 0.5F, 1.0F };
/* 252 */     float size = 2.0F + sizes[((EntityRRMecha)entity).getType()];
/* 253 */     GL11.glScalef(size, size, size);
/* 254 */     GL11.glTranslatef(0.0F, -0.9F, 0.0F);
/* 255 */     this.ArmL.func_78785_a(f5);
/* 256 */     this.ArmR.func_78785_a(f5);
/* 257 */     this.LegR.func_78785_a(f5);
/* 258 */     this.Base1.func_78785_a(f5);
/* 259 */     this.LegL.func_78785_a(f5);
/* 260 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 264 */     modelRenderer.field_78795_f = x;
/* 265 */     modelRenderer.field_78796_g = y;
/* 266 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 270 */     float r = 360.0F;
/* 271 */     float r2 = 180.0F;
/* 272 */     float n4 = par4;
/* 273 */     float n5 = par5;
/*     */ 
/*     */     
/* 276 */     this.LegR.field_78795_f = -0.1F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 277 */     this.LegL.field_78795_f = -0.1F - MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 278 */     this.ArmR.field_78795_f = -0.1F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 279 */     this.ArmL.field_78795_f = -0.1F + MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 280 */     this.LegR.field_78796_g = 0.0F;
/* 281 */     this.LegL.field_78796_g = 0.0F;
/* 282 */     this.ArmR.field_78796_g = 0.0F;
/* 283 */     this.ArmL.field_78796_g = 0.0F;
/* 284 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelRRMecha.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */