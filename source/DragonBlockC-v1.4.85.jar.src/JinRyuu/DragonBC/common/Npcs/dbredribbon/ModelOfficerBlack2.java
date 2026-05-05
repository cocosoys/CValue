/*     */ package JinRyuu.DragonBC.common.Npcs.dbredribbon;
/*     */ 
/*     */ import JinRyuu.JRMCore.client.JGRenderHelper;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class ModelOfficerBlack2
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Base1;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer OfficerBlackHead;
/*     */   public ModelRenderer OfficerBlackBody;
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
/*     */   public ModelRenderer InternalArea;
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
/*     */   public ModelRenderer ArmL1;
/*     */   public ModelRenderer ArmR1;
/*     */   public ModelRenderer Controlpanel;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer ArmL11;
/*     */   public ModelRenderer ArmR11;
/*     */   
/*     */   public ModelOfficerBlack2() {
/*  65 */     this.field_78090_t = 128;
/*  66 */     this.field_78089_u = 128;
/*  67 */     this.Body2 = new ModelRenderer(this, 110, 28);
/*  68 */     this.Body2.func_78793_a(0.0F, 1.1F, -0.1F);
/*  69 */     this.Body2.func_78790_a(-2.5F, 0.0F, -1.0F, 5, 5, 2, 0.0F);
/*  70 */     setRotateAngle(this.Body2, -0.31869712F, 0.0F, 0.0F);
/*  71 */     this.ShoulderR = new ModelRenderer(this, 16, 76);
/*  72 */     this.ShoulderR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  73 */     this.ShoulderR.func_78790_a(-8.3F, -4.2F, 3.1F, 3, 5, 4, 0.0F);
/*  74 */     setRotateAngle(this.ShoulderR, 0.7749262F, 0.1308997F, -0.20943952F);
/*  75 */     this.BackTop1 = new ModelRenderer(this, 81, 0);
/*  76 */     this.BackTop1.func_78793_a(0.0F, 0.0F, 0.1F);
/*  77 */     this.BackTop1.func_78790_a(-3.5F, -5.4F, 7.5F, 7, 3, 5, 0.0F);
/*  78 */     setRotateAngle(this.BackTop1, -0.19896753F, 0.0F, 0.0F);
/*  79 */     this.ArmL3 = new ModelRenderer(this, 3, 107);
/*  80 */     this.ArmL3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  81 */     this.ArmL3.func_78790_a(1.0F, 7.3F, 1.8F, 2, 4, 2, 0.0F);
/*  82 */     setRotateAngle(this.ArmL3, -0.4553564F, 0.0F, 0.0F);
/*  83 */     this.ArmR1 = new ModelRenderer(this, 100, 28);
/*  84 */     this.ArmR1.func_78793_a(-3.1F, 2.5F, -2.0F);
/*  85 */     this.ArmR1.func_78790_a(-1.0F, -3.0F, -1.0F, 2, 3, 2, 0.0F);
/*  86 */     setRotateAngle(this.ArmR1, 0.3642502F, -0.27314404F, 1.0927507F);
/*  87 */     this.LegR3 = new ModelRenderer(this, 93, 108);
/*  88 */     this.LegR3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  89 */     this.LegR3.func_78790_a(-4.6F, 10.9F, -4.9F, 5, 2, 7, 0.0F);
/*  90 */     setRotateAngle(this.LegR3, 0.11047934F, 0.0F, -0.10471976F);
/*  91 */     this.ArmR3 = new ModelRenderer(this, 19, 107);
/*  92 */     this.ArmR3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  93 */     this.ArmR3.func_78790_a(-3.3F, 7.3F, 1.8F, 2, 4, 2, 0.0F);
/*  94 */     setRotateAngle(this.ArmR3, -0.4553564F, 0.0F, 0.0F);
/*  95 */     this.Extra10 = new ModelRenderer(this, 113, 3);
/*  96 */     this.Extra10.func_78793_a(0.0F, 0.0F, 0.0F);
/*  97 */     this.Extra10.func_78790_a(-2.5F, 2.7F, -2.0F, 1, 1, 2, 0.0F);
/*  98 */     this.ArmL11 = new ModelRenderer(this, 95, 33);
/*  99 */     this.ArmL11.field_78809_i = true;
/* 100 */     this.ArmL11.func_78793_a(0.0F, 0.0F, 0.0F);
/* 101 */     this.ArmL11.func_78790_a(-1.0F, -3.0F, -1.0F, 2, 3, 2, 0.0F);
/* 102 */     setRotateAngle(this.ArmL11, -1.7301449F, 0.0F, 0.0F);
/* 103 */     this.InternalArea = new ModelRenderer(this, 98, 36);
/* 104 */     this.InternalArea.func_78793_a(0.0F, -3.5F, 0.1F);
/* 105 */     this.InternalArea.func_78790_a(-3.5F, 0.0F, -3.7F, 7, 5, 7, 0.0F);
/* 106 */     setRotateAngle(this.InternalArea, 1.5498524F, 0.0F, 0.0F);
/* 107 */     this.ArmL1 = new ModelRenderer(this, 100, 28);
/* 108 */     this.ArmL1.field_78809_i = true;
/* 109 */     this.ArmL1.func_78793_a(3.1F, 2.5F, -2.0F);
/* 110 */     this.ArmL1.func_78790_a(-1.0F, -3.0F, -1.0F, 2, 3, 2, 0.0F);
/* 111 */     setRotateAngle(this.ArmL1, 0.3642502F, 0.27314404F, -1.0927507F);
/* 112 */     this.Back2 = new ModelRenderer(this, 47, 17);
/* 113 */     this.Back2.func_78793_a(0.0F, 0.0F, 0.1F);
/* 114 */     this.Back2.func_78790_a(-4.0F, -2.8F, 6.6F, 8, 13, 7, 0.0F);
/* 115 */     this.BottomBack2 = new ModelRenderer(this, 48, 43);
/* 116 */     this.BottomBack2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 117 */     this.BottomBack2.func_78790_a(-2.5F, 16.8F, -3.8F, 5, 2, 5, 0.0F);
/* 118 */     this.Extra21 = new ModelRenderer(this, 113, 3);
/* 119 */     this.Extra21.func_78793_a(0.0F, 0.0F, 0.0F);
/* 120 */     this.Extra21.func_78790_a(1.5F, 2.7F, -14.1F, 1, 1, 2, 0.0F);
/* 121 */     this.Extra22 = new ModelRenderer(this, 112, 0);
/* 122 */     this.Extra22.func_78793_a(0.0F, 0.0F, 0.0F);
/* 123 */     this.Extra22.func_78790_a(-1.5F, 2.7F, -14.6F, 3, 1, 1, 0.0F);
/* 124 */     this.ShoulderL = new ModelRenderer(this, 1, 76);
/* 125 */     this.ShoulderL.func_78793_a(0.0F, 0.0F, 0.0F);
/* 126 */     this.ShoulderL.func_78790_a(5.3F, -4.2F, 3.2F, 3, 5, 4, 0.0F);
/* 127 */     setRotateAngle(this.ShoulderL, 0.7749262F, -0.1308997F, 0.20943952F);
/* 128 */     this.Controlpanel = new ModelRenderer(this, 91, 28);
/* 129 */     this.Controlpanel.func_78793_a(0.0F, 1.4F, -3.3F);
/* 130 */     this.Controlpanel.func_78790_a(-1.1F, 0.0F, -1.0F, 2, 2, 2, 0.0F);
/* 131 */     setRotateAngle(this.Controlpanel, 0.22759093F, 0.0F, 0.0F);
/* 132 */     this.OfficerBlackHead = new ModelRenderer(this, 95, 11);
/* 133 */     this.OfficerBlackHead.func_78793_a(0.0F, -3.2F, 3.3F);
/* 134 */     this.OfficerBlackHead.func_78790_a(-4.0F, -4.8F, -4.0F, 8, 8, 8, -2.0F);
/* 135 */     setRotateAngle(this.OfficerBlackHead, 0.31869712F, 0.0F, 0.0F);
/* 136 */     this.BackTop2 = new ModelRenderer(this, 81, 10);
/* 137 */     this.BackTop2.func_78793_a(0.0F, 0.0F, 0.1F);
/* 138 */     this.BackTop2.func_78790_a(-3.0F, -6.2F, 7.9F, 6, 1, 4, 0.0F);
/* 139 */     this.ArmR = new ModelRenderer(this, 18, 86);
/* 140 */     this.ArmR.func_78793_a(-8.5F, 0.1F, 4.9F);
/* 141 */     this.ArmR.func_78790_a(-1.3F, -0.4F, -1.1F, 2, 7, 2, 0.0F);
/* 142 */     setRotateAngle(this.ArmR, 0.11082841F, 0.0F, 0.27576202F);
/* 143 */     this.LegL3 = new ModelRenderer(this, 66, 108);
/* 144 */     this.LegL3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 145 */     this.LegL3.func_78790_a(-0.4F, 10.9F, -4.9F, 5, 2, 7, 0.0F);
/* 146 */     setRotateAngle(this.LegL3, 0.11047934F, 0.0F, 0.10471976F);
/* 147 */     this.BottomBase = new ModelRenderer(this, 46, 51);
/* 148 */     this.BottomBase.func_78793_a(0.0F, 0.0F, 0.0F);
/* 149 */     this.BottomBase.func_78790_a(-3.0F, 8.3F, 0.8F, 6, 7, 7, 0.0F);
/* 150 */     setRotateAngle(this.BottomBase, 0.7749262F, 0.0F, 0.0F);
/* 151 */     this.BottomBack = new ModelRenderer(this, 46, 66);
/* 152 */     this.BottomBack.func_78793_a(0.0F, 0.0F, 0.0F);
/* 153 */     this.BottomBack.func_78790_a(-3.5F, 12.9F, -5.4F, 7, 4, 8, 0.0F);
/* 154 */     setRotateAngle(this.BottomBack, 0.7749262F, 0.0F, 0.0F);
/* 155 */     this.OfficerBlackBody = new ModelRenderer(this, 82, 17);
/* 156 */     this.OfficerBlackBody.func_78793_a(0.0F, -3.2F, 3.2F);
/* 157 */     this.OfficerBlackBody.func_78790_a(-1.0F, -1.0F, -1.0F, 1, 1, 1, 0.0F);
/* 158 */     setRotateAngle(this.OfficerBlackBody, 0.31869712F, 0.0F, 0.0F);
/* 159 */     this.LegR = new ModelRenderer(this, 96, 85);
/* 160 */     this.LegR.func_78793_a(-4.5F, 11.2F, 4.8F);
/* 161 */     this.LegR.func_78790_a(-2.3F, -1.2F, -0.9F, 2, 7, 2, 0.0F);
/* 162 */     setRotateAngle(this.LegR, -0.11047934F, 0.0F, 0.10471976F);
/* 163 */     this.ArmL2 = new ModelRenderer(this, 1, 96);
/* 164 */     this.ArmL2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 165 */     this.ArmL2.func_78790_a(-0.6F, 5.8F, 1.5F, 3, 7, 3, 0.0F);
/* 166 */     setRotateAngle(this.ArmL2, -0.4553564F, 0.0F, 0.0F);
/* 167 */     this.Belly1 = new ModelRenderer(this, 0, 39);
/* 168 */     this.Belly1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 169 */     this.Belly1.func_78790_a(-7.0F, 2.5F, -2.3F, 14, 10, 5, 0.0F);
/* 170 */     setRotateAngle(this.Belly1, 0.7749262F, 0.0F, 0.0F);
/* 171 */     this.LegR2 = new ModelRenderer(this, 94, 97);
/* 172 */     this.LegR2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 173 */     this.LegR2.func_78790_a(-4.1F, 5.6F, -2.7F, 4, 6, 4, 0.0F);
/* 174 */     setRotateAngle(this.LegR2, 0.11047934F, 0.0F, -0.10471976F);
/* 175 */     this.Head1 = new ModelRenderer(this, 76, 54);
/* 176 */     this.Head1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 177 */     this.Head1.func_78790_a(-4.0F, -6.8F, -4.0F, 8, 6, 4, 0.0F);
/* 178 */     this.Belly2 = new ModelRenderer(this, 0, 56);
/* 179 */     this.Belly2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 180 */     this.Belly2.func_78790_a(-6.51F, 3.7F, -3.8F, 13, 8, 2, 0.0F);
/* 181 */     this.HeadBack = new ModelRenderer(this, 79, 74);
/* 182 */     this.HeadBack.func_78793_a(0.0F, 0.0F, 0.0F);
/* 183 */     this.HeadBack.func_78790_a(-3.0F, -8.8F, -3.9F, 6, 2, 6, 0.0F);
/* 184 */     this.ArmR2 = new ModelRenderer(this, 17, 96);
/* 185 */     this.ArmR2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 186 */     this.ArmR2.func_78790_a(-2.3F, 5.8F, 1.5F, 3, 7, 3, 0.0F);
/* 187 */     setRotateAngle(this.ArmR2, -0.4553564F, 0.0F, 0.0F);
/* 188 */     this.Spine1 = new ModelRenderer(this, 0, 21);
/* 189 */     this.Spine1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 190 */     this.Spine1.func_78790_a(-7.5F, -1.2F, 1.7F, 15, 10, 6, 0.0F);
/* 191 */     setRotateAngle(this.Spine1, 0.7749262F, 0.0F, 0.0F);
/* 192 */     this.LegL = new ModelRenderer(this, 76, 85);
/* 193 */     this.LegL.func_78793_a(4.6F, 11.2F, 4.8F);
/* 194 */     this.LegL.func_78790_a(0.1F, -1.2F, -0.9F, 2, 7, 2, 0.0F);
/* 195 */     setRotateAngle(this.LegL, -0.11052218F, 0.0F, -0.10471976F);
/* 196 */     this.ArmR11 = new ModelRenderer(this, 95, 33);
/* 197 */     this.ArmR11.func_78793_a(0.0F, 0.0F, 0.0F);
/* 198 */     this.ArmR11.func_78790_a(-1.0F, -3.0F, -1.0F, 2, 3, 2, 0.0F);
/* 199 */     setRotateAngle(this.ArmR11, -1.548107F, 0.0F, 0.0F);
/* 200 */     this.Extra30 = new ModelRenderer(this, 104, 0);
/* 201 */     this.Extra30.func_78793_a(0.0F, 0.0F, 0.0F);
/* 202 */     this.Extra30.func_78790_a(-4.9F, 1.3F, -1.9F, 2, 2, 1, 0.0F);
/* 203 */     setRotateAngle(this.Extra30, 0.0F, 0.3630285F, 0.21642083F);
/* 204 */     this.ArmL4 = new ModelRenderer(this, 1, 114);
/* 205 */     this.ArmL4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 206 */     this.ArmL4.func_78790_a(-0.6F, 12.6F, 1.0F, 3, 4, 4, 0.0F);
/* 207 */     setRotateAngle(this.ArmL4, -0.4553564F, 0.16475908F, 0.0F);
/* 208 */     this.HeadTop = new ModelRenderer(this, 78, 45);
/* 209 */     this.HeadTop.func_78793_a(0.0F, 0.0F, 0.0F);
/* 210 */     this.HeadTop.func_78790_a(-3.0F, -6.8F, -5.0F, 6, 5, 1, 0.0F);
/* 211 */     this.Extra12 = new ModelRenderer(this, 112, 0);
/* 212 */     this.Extra12.func_78793_a(0.0F, 0.0F, 0.0F);
/* 213 */     this.Extra12.func_78790_a(-1.5F, 2.7F, -2.4F, 3, 1, 1, 0.0F);
/* 214 */     this.Extra40 = new ModelRenderer(this, 104, 0);
/* 215 */     this.Extra40.func_78793_a(0.0F, 0.0F, 0.0F);
/* 216 */     this.Extra40.func_78790_a(2.9F, 1.3F, -1.9F, 2, 2, 1, 0.0F);
/* 217 */     setRotateAngle(this.Extra40, 0.0F, -0.3630285F, -0.23387411F);
/* 218 */     this.Belly3 = new ModelRenderer(this, 0, 67);
/* 219 */     this.Belly3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 220 */     this.Belly3.func_78790_a(-5.0F, 5.0F, -4.8F, 10, 6, 1, 0.0F);
/* 221 */     this.ArmR4 = new ModelRenderer(this, 17, 114);
/* 222 */     this.ArmR4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 223 */     this.ArmR4.func_78790_a(-2.4F, 12.6F, 1.0F, 3, 4, 4, 0.0F);
/* 224 */     setRotateAngle(this.ArmR4, -0.4553564F, -0.1829105F, 0.0F);
/* 225 */     this.Back1 = new ModelRenderer(this, 45, 0);
/* 226 */     this.Back1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 227 */     this.Back1.func_78790_a(-7.0F, 0.0F, 6.8F, 14, 12, 3, 0.0F);
/* 228 */     this.HeadFront = new ModelRenderer(this, 80, 67);
/* 229 */     this.HeadFront.func_78793_a(0.0F, 0.0F, 0.0F);
/* 230 */     this.HeadFront.func_78790_a(-3.0F, -0.9F, -3.1F, 6, 1, 4, 0.0F);
/* 231 */     this.Base1 = new ModelRenderer(this, 0, 0);
/* 232 */     this.Base1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 233 */     this.Base1.func_78790_a(-6.5F, -6.8F, 0.0F, 13, 12, 7, 0.0F);
/* 234 */     setRotateAngle(this.Base1, -0.7749262F, 0.0017453292F, 0.0F);
/* 235 */     this.Extra20 = new ModelRenderer(this, 113, 3);
/* 236 */     this.Extra20.func_78793_a(0.0F, 0.0F, 0.0F);
/* 237 */     this.Extra20.func_78790_a(-2.5F, 2.7F, -14.1F, 1, 1, 2, 0.0F);
/* 238 */     setRotateAngle(this.Extra20, 1.8430676F, 0.0F, 0.0F);
/* 239 */     this.ArmL = new ModelRenderer(this, 3, 86);
/* 240 */     this.ArmL.func_78793_a(8.5F, 0.1F, 4.9F);
/* 241 */     this.ArmL.func_78790_a(-0.6F, -0.4F, -1.2F, 2, 7, 2, 0.0F);
/* 242 */     setRotateAngle(this.ArmL, 0.11082841F, 0.0F, -0.27576202F);
/* 243 */     this.LegL2 = new ModelRenderer(this, 73, 97);
/* 244 */     this.LegL2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 245 */     this.LegL2.func_78790_a(0.1F, 5.6F, -2.7F, 4, 6, 4, 0.0F);
/* 246 */     setRotateAngle(this.LegL2, 0.11047934F, 0.0F, 0.10471976F);
/* 247 */     this.Extra11 = new ModelRenderer(this, 113, 3);
/* 248 */     this.Extra11.func_78793_a(0.0F, 0.0F, 0.0F);
/* 249 */     this.Extra11.func_78790_a(1.5F, 2.7F, -2.0F, 1, 1, 2, 0.0F);
/* 250 */     this.BottomFront = new ModelRenderer(this, 47, 79);
/* 251 */     this.BottomFront.func_78793_a(0.0F, 0.0F, 0.0F);
/* 252 */     this.BottomFront.func_78790_a(-3.5F, 7.2F, 5.0F, 7, 4, 6, 0.0F);
/* 253 */     setRotateAngle(this.BottomFront, -0.7285004F, 0.0F, 0.0F);
/* 254 */     this.OfficerBlackBody.func_78792_a(this.Body2);
/* 255 */     this.Base1.func_78792_a(this.ShoulderR);
/* 256 */     this.Back2.func_78792_a(this.BackTop1);
/* 257 */     this.ArmL.func_78792_a(this.ArmL3);
/* 258 */     this.OfficerBlackBody.func_78792_a(this.ArmR1);
/* 259 */     this.LegR.func_78792_a(this.LegR3);
/* 260 */     this.ArmR.func_78792_a(this.ArmR3);
/* 261 */     this.Base1.func_78792_a(this.Extra10);
/* 262 */     this.ArmL1.func_78792_a(this.ArmL11);
/* 263 */     this.Base1.func_78792_a(this.InternalArea);
/* 264 */     this.OfficerBlackBody.func_78792_a(this.ArmL1);
/* 265 */     this.Back1.func_78792_a(this.Back2);
/* 266 */     this.BottomBack.func_78792_a(this.BottomBack2);
/* 267 */     this.Extra20.func_78792_a(this.Extra21);
/* 268 */     this.Extra20.func_78792_a(this.Extra22);
/* 269 */     this.Base1.func_78792_a(this.ShoulderL);
/* 270 */     this.OfficerBlackBody.func_78792_a(this.Controlpanel);
/* 271 */     this.BackTop1.func_78792_a(this.BackTop2);
/* 272 */     this.LegL.func_78792_a(this.LegL3);
/* 273 */     this.Base1.func_78792_a(this.BottomBase);
/* 274 */     this.BottomBase.func_78792_a(this.BottomBack);
/* 275 */     this.ArmL.func_78792_a(this.ArmL2);
/* 276 */     this.Base1.func_78792_a(this.Belly1);
/* 277 */     this.LegR.func_78792_a(this.LegR2);
/* 278 */     this.Base1.func_78792_a(this.Head1);
/* 279 */     this.Belly1.func_78792_a(this.Belly2);
/* 280 */     this.Head1.func_78792_a(this.HeadBack);
/* 281 */     this.ArmR.func_78792_a(this.ArmR2);
/* 282 */     this.Base1.func_78792_a(this.Spine1);
/* 283 */     this.ArmR1.func_78792_a(this.ArmR11);
/* 284 */     this.Base1.func_78792_a(this.Extra30);
/* 285 */     this.ArmL.func_78792_a(this.ArmL4);
/* 286 */     this.Head1.func_78792_a(this.HeadTop);
/* 287 */     this.Extra10.func_78792_a(this.Extra12);
/* 288 */     this.Base1.func_78792_a(this.Extra40);
/* 289 */     this.Belly2.func_78792_a(this.Belly3);
/* 290 */     this.ArmR.func_78792_a(this.ArmR4);
/* 291 */     this.Spine1.func_78792_a(this.Back1);
/* 292 */     this.Head1.func_78792_a(this.HeadFront);
/* 293 */     this.Base1.func_78792_a(this.Extra20);
/* 294 */     this.LegL.func_78792_a(this.LegL2);
/* 295 */     this.Extra10.func_78792_a(this.Extra11);
/* 296 */     this.BottomBase.func_78792_a(this.BottomFront);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 301 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 303 */     GL11.glPushMatrix();
/* 304 */     float F = 1.5F;
/* 305 */     JGRenderHelper.modelScalePositionHelper(1.5F);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 310 */     this.ArmR.func_78785_a(f5);
/* 311 */     this.ArmL.func_78785_a(f5);
/* 312 */     this.LegL.func_78785_a(f5);
/* 313 */     this.LegR.func_78785_a(f5);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 318 */     this.Base1.func_78785_a(f5);
/* 319 */     this.OfficerBlackHead.func_78785_a(f5);
/* 320 */     this.OfficerBlackBody.func_78785_a(f5);
/*     */     
/* 322 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 326 */     modelRenderer.field_78795_f = x;
/* 327 */     modelRenderer.field_78796_g = y;
/* 328 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 332 */     int calc = par7Entity.field_70173_aa;
/* 333 */     if (calc > 100) calc -= 100; 
/* 334 */     float r = 360.0F;
/* 335 */     float r2 = 180.0F;
/* 336 */     float n4 = par4;
/* 337 */     float n5 = par5;
/*     */     
/* 339 */     this.OfficerBlackHead.field_78796_g = n4 / r2 / 3.1415927F;
/* 340 */     this.OfficerBlackHead.field_78795_f = n5 / r2 / 3.1415927F;
/* 341 */     float ex = par7Entity.field_70173_aa;
/* 342 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 343 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 345 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 346 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 400 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 401 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 402 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 403 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 405 */     this.LegR.field_78796_g = 0.0F;
/* 406 */     this.LegL.field_78796_g = 0.0F;
/* 407 */     this.ArmR.field_78796_g = 0.0F;
/* 408 */     this.ArmL.field_78796_g = 0.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbredribbon\ModelOfficerBlack2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */