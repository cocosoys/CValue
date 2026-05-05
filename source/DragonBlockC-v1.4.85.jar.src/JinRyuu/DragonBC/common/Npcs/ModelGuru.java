/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import JinRyuu.JRMCore.client.JGRenderHelper;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModelGuru
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Throne1;
/*     */   public ModelRenderer Throne2;
/*     */   public ModelRenderer GuruBase1;
/*     */   public ModelRenderer ArmrestBaseL;
/*     */   public ModelRenderer ThroneSideL;
/*     */   public ModelRenderer ThroneTop1;
/*     */   public ModelRenderer ArmrestBaseR;
/*     */   public ModelRenderer ThroneSideR;
/*     */   public ModelRenderer ThroneTopR1;
/*     */   public ModelRenderer ArmrestL1;
/*     */   public ModelRenderer ArmrestL2;
/*     */   public ModelRenderer ArmrestL3;
/*     */   public ModelRenderer ArmrestL4;
/*     */   public ModelRenderer ArmrestL5;
/*     */   public ModelRenderer ArmrestL6;
/*     */   public ModelRenderer ArmrestL7;
/*     */   public ModelRenderer ArmrestL8;
/*     */   public ModelRenderer ArmrestSpikeL1;
/*     */   public ModelRenderer ArmrestSpikeL2;
/*     */   public ModelRenderer ArmrestSpikeL3;
/*     */   public ModelRenderer ArmrestL62;
/*     */   public ModelRenderer ArmrestL9;
/*     */   public ModelRenderer ArmrestL10;
/*     */   public ModelRenderer ThroneTopL1;
/*     */   public ModelRenderer ThroneTopL2;
/*     */   public ModelRenderer ThroneTopSpikeL1;
/*     */   public ModelRenderer ThroneTopL3;
/*     */   public ModelRenderer ThroneTopSpikeL2;
/*     */   public ModelRenderer ThroneTopSpikeL3;
/*     */   public ModelRenderer ArmrestR1;
/*     */   public ModelRenderer ArmrestR2;
/*     */   public ModelRenderer ArmrestR3;
/*     */   public ModelRenderer ArmrestR4;
/*     */   public ModelRenderer ArmrestR5;
/*     */   public ModelRenderer ArmrestR6;
/*     */   public ModelRenderer ArmrestR7;
/*     */   public ModelRenderer ArmrestR8;
/*     */   public ModelRenderer ArmrestSpikeR1;
/*     */   public ModelRenderer ArmrestSpikeR2;
/*     */   public ModelRenderer ArmrestSpikeR3;
/*     */   public ModelRenderer ArmrestR62;
/*     */   public ModelRenderer ArmrestR9;
/*     */   public ModelRenderer ArmrestR10;
/*     */   public ModelRenderer ThroneTopR2;
/*     */   public ModelRenderer ThroneTopSpikeR1;
/*     */   public ModelRenderer ThroneTopR3;
/*     */   public ModelRenderer ThroneTopSpikeR2;
/*     */   public ModelRenderer ThroneTopSpikeR3;
/*     */   public ModelRenderer GuruBase2;
/*     */   public ModelRenderer GuruBase3;
/*     */   public ModelRenderer GuruNeckTuftClothing;
/*     */   public ModelRenderer GuruArmR1;
/*     */   public ModelRenderer GuruArmL1;
/*     */   public ModelRenderer GuruLegL1;
/*     */   public ModelRenderer GuruLegM;
/*     */   public ModelRenderer GuruLegR1;
/*     */   public ModelRenderer GuruLegL2;
/*     */   public ModelRenderer GuruLegR2;
/*     */   public ModelRenderer GuruHead;
/*     */   public ModelRenderer GuruHeadAntennaR;
/*     */   public ModelRenderer GuruHeadAntennaL;
/*     */   public ModelRenderer GuruArmR2;
/*     */   public ModelRenderer GuruArmL2;
/*     */   
/*     */   public ModelGuru() {
/*  80 */     this.field_78090_t = 256;
/*  81 */     this.field_78089_u = 128;
/*  82 */     this.GuruHead = new ModelRenderer(this, 103, 0);
/*  83 */     this.GuruHead.func_78793_a(0.0F, 0.0F, 0.0F);
/*  84 */     this.GuruHead.func_78790_a(-4.1F, -30.0F, 2.5F, 7, 6, 6, 0.0F);
/*  85 */     setRotateAngle(this.GuruHead, -0.06981317F, 0.0F, 0.0F);
/*  86 */     this.ArmrestSpikeR3 = new ModelRenderer(this, 39, 66);
/*  87 */     this.ArmrestSpikeR3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  88 */     this.ArmrestSpikeR3.func_78790_a(-16.3F, -18.8F, -1.4F, 1, 3, 1, 0.0F);
/*  89 */     this.Throne2 = new ModelRenderer(this, 195, 61);
/*  90 */     this.Throne2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  91 */     this.Throne2.func_78790_a(-12.5F, -31.3F, 11.0F, 25, 35, 5, 0.0F);
/*  92 */     this.GuruLegR1 = new ModelRenderer(this, 0, 61);
/*  93 */     this.GuruLegR1.field_78809_i = true;
/*  94 */     this.GuruLegR1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  95 */     this.GuruLegR1.func_78790_a(-10.0F, -8.2F, -15.0F, 6, 9, 11, 0.0F);
/*  96 */     this.GuruNeckTuftClothing = new ModelRenderer(this, 56, 0);
/*  97 */     this.GuruNeckTuftClothing.func_78793_a(0.0F, 0.0F, 0.0F);
/*  98 */     this.GuruNeckTuftClothing.func_78790_a(-7.5F, -24.2F, 2.2F, 14, 2, 8, 0.0F);
/*  99 */     this.ArmrestSpikeL3 = new ModelRenderer(this, 39, 66);
/* 100 */     this.ArmrestSpikeL3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 101 */     this.ArmrestSpikeL3.func_78790_a(15.2F, -18.8F, -1.4F, 1, 3, 1, 0.0F);
/* 102 */     this.ArmrestR9 = new ModelRenderer(this, 148, 97);
/* 103 */     this.ArmrestR9.field_78809_i = true;
/* 104 */     this.ArmrestR9.func_78793_a(0.0F, 0.0F, 0.0F);
/* 105 */     this.ArmrestR9.func_78790_a(-18.8F, -22.4F, 7.4F, 6, 7, 7, 0.0F);
/* 106 */     setRotateAngle(this.ArmrestR9, -0.4553564F, 0.0F, 0.0F);
/* 107 */     this.ThroneTopL2 = new ModelRenderer(this, 128, 28);
/* 108 */     this.ThroneTopL2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 109 */     this.ThroneTopL2.func_78790_a(-6.7F, -35.2F, 10.1F, 9, 6, 7, 0.0F);
/* 110 */     this.ArmrestSpikeL1 = new ModelRenderer(this, 31, 77);
/* 111 */     this.ArmrestSpikeL1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 112 */     this.ArmrestSpikeL1.func_78790_a(13.2F, -12.9F, -3.4F, 5, 2, 5, 0.0F);
/* 113 */     setRotateAngle(this.ArmrestSpikeL1, 0.5462881F, 0.0F, 0.0F);
/* 114 */     this.ArmrestL9 = new ModelRenderer(this, 148, 97);
/* 115 */     this.ArmrestL9.func_78793_a(0.0F, 0.0F, 0.0F);
/* 116 */     this.ArmrestL9.func_78790_a(12.6F, -22.4F, 7.4F, 6, 7, 7, 0.0F);
/* 117 */     setRotateAngle(this.ArmrestL9, -0.4553564F, 0.0F, 0.0F);
/* 118 */     this.ArmrestR10 = new ModelRenderer(this, 150, 114);
/* 119 */     this.ArmrestR10.field_78809_i = true;
/* 120 */     this.ArmrestR10.func_78793_a(0.0F, 0.0F, 0.0F);
/* 121 */     this.ArmrestR10.func_78790_a(-18.3F, -25.7F, 6.7F, 5, 6, 6, 0.0F);
/* 122 */     setRotateAngle(this.ArmrestR10, -0.31869712F, 0.0F, 0.0F);
/* 123 */     this.ThroneTopSpikeR1 = new ModelRenderer(this, 104, 30);
/* 124 */     this.ThroneTopSpikeR1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 125 */     this.ThroneTopSpikeR1.func_78790_a(18.2F, -28.4F, 10.5F, 5, 4, 6, 0.0F);
/* 126 */     setRotateAngle(this.ThroneTopSpikeR1, 0.0F, 0.0F, -0.77946407F);
/* 127 */     this.ArmrestL8 = new ModelRenderer(this, 128, 90);
/* 128 */     this.ArmrestL8.func_78793_a(0.0F, 0.0F, 0.0F);
/* 129 */     this.ArmrestL8.func_78790_a(12.2F, -17.0F, 10.5F, 7, 7, 6, 0.0F);
/* 130 */     setRotateAngle(this.ArmrestL8, -0.4553564F, 0.0F, 0.0F);
/* 131 */     this.GuruBase1 = new ModelRenderer(this, 0, 0);
/* 132 */     this.GuruBase1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 133 */     this.GuruBase1.func_78790_a(-10.0F, -18.3F, -4.8F, 19, 13, 15, 0.0F);
/* 134 */     this.GuruLegR2 = new ModelRenderer(this, 0, 82);
/* 135 */     this.GuruLegR2.field_78809_i = true;
/* 136 */     this.GuruLegR2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 137 */     this.GuruLegR2.func_78790_a(-8.8F, 0.9F, -16.5F, 3, 3, 7, 0.0F);
/* 138 */     this.ArmrestBaseL = new ModelRenderer(this, 57, 95);
/* 139 */     this.ArmrestBaseL.func_78793_a(0.0F, 0.0F, 0.0F);
/* 140 */     this.ArmrestBaseL.func_78790_a(12.5F, -8.4F, -4.1F, 6, 12, 20, 0.0F);
/* 141 */     this.GuruArmL1 = new ModelRenderer(this, 72, 28);
/* 142 */     this.GuruArmL1.field_78809_i = true;
/* 143 */     this.GuruArmL1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 144 */     this.GuruArmL1.func_78790_a(13.1F, -17.3F, 5.3F, 4, 7, 4, 0.0F);
/* 145 */     setRotateAngle(this.GuruArmL1, 0.0F, 0.0F, -0.31869712F);
/* 146 */     this.ThroneTop1 = new ModelRenderer(this, 212, 25);
/* 147 */     this.ThroneTop1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 148 */     this.ThroneTop1.func_78790_a(-3.5F, -36.8F, 10.1F, 7, 7, 7, 0.0F);
/* 149 */     this.ArmrestL3 = new ModelRenderer(this, 23, 86);
/* 150 */     this.ArmrestL3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 151 */     this.ArmrestL3.func_78790_a(12.2F, -10.9F, -6.4F, 7, 6, 10, 0.0F);
/* 152 */     setRotateAngle(this.ArmrestL3, 0.5462881F, 0.0F, 0.0F);
/* 153 */     this.GuruLegM = new ModelRenderer(this, 41, 47);
/* 154 */     this.GuruLegM.func_78793_a(0.0F, 0.0F, 0.0F);
/* 155 */     this.GuruLegM.func_78790_a(-4.6F, -6.4F, -13.0F, 9, 7, 6, 0.0F);
/* 156 */     this.ThroneTopSpikeL1 = new ModelRenderer(this, 104, 30);
/* 157 */     this.ThroneTopSpikeL1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 158 */     this.ThroneTopSpikeL1.func_78790_a(-23.0F, -28.4F, 10.5F, 5, 4, 6, 0.0F);
/* 159 */     setRotateAngle(this.ThroneTopSpikeL1, 0.0F, 0.0F, 0.77946407F);
/* 160 */     this.ArmrestBaseR = new ModelRenderer(this, 57, 95);
/* 161 */     this.ArmrestBaseR.field_78809_i = true;
/* 162 */     this.ArmrestBaseR.func_78793_a(0.0F, 0.0F, 0.0F);
/* 163 */     this.ArmrestBaseR.func_78790_a(-18.4F, -8.4F, -4.1F, 6, 12, 20, 0.0F);
/* 164 */     this.ArmrestR7 = new ModelRenderer(this, 109, 83);
/* 165 */     this.ArmrestR7.field_78809_i = true;
/* 166 */     this.ArmrestR7.func_78793_a(0.0F, 0.0F, 0.0F);
/* 167 */     this.ArmrestR7.func_78790_a(-19.3F, -13.7F, 9.7F, 7, 7, 5, 0.0F);
/* 168 */     setRotateAngle(this.ArmrestR7, -0.18203785F, 0.0F, 0.0F);
/* 169 */     this.ArmrestL6 = new ModelRenderer(this, 114, 108);
/* 170 */     this.ArmrestL6.func_78793_a(0.0F, 0.0F, 0.0F);
/* 171 */     this.ArmrestL6.func_78790_a(12.8F, -3.5F, 15.8F, 5, 7, 8, 0.0F);
/* 172 */     this.ArmrestR1 = new ModelRenderer(this, 74, 76);
/* 173 */     this.ArmrestR1.field_78809_i = true;
/* 174 */     this.ArmrestR1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 175 */     this.ArmrestR1.func_78790_a(-19.3F, -11.7F, 2.2F, 7, 7, 10, 0.0F);
/* 176 */     this.Throne1 = new ModelRenderer(this, 174, 102);
/* 177 */     this.Throne1.func_78793_a(0.0F, 20.0F, 0.0F);
/* 178 */     this.Throne1.func_78790_a(-12.9F, -5.4F, -4.2F, 26, 9, 15, 0.0F);
/* 179 */     this.ArmrestL5 = new ModelRenderer(this, 1, 111);
/* 180 */     this.ArmrestL5.func_78793_a(0.0F, 0.0F, 0.0F);
/* 181 */     this.ArmrestL5.func_78790_a(13.2F, -13.1F, -8.4F, 5, 5, 5, 0.0F);
/* 182 */     setRotateAngle(this.ArmrestL5, 1.1838568F, 0.010122909F, 0.0F);
/* 183 */     this.ThroneSideR = new ModelRenderer(this, 100, 59);
/* 184 */     this.ThroneSideR.field_78809_i = true;
/* 185 */     this.ThroneSideR.func_78793_a(0.0F, 0.0F, 0.0F);
/* 186 */     this.ThroneSideR.func_78790_a(-20.5F, -18.7F, 10.1F, 5, 15, 7, 0.0F);
/* 187 */     setRotateAngle(this.ThroneSideR, 0.0F, 0.0F, 0.3351032F);
/* 188 */     this.ArmrestR6 = new ModelRenderer(this, 114, 108);
/* 189 */     this.ArmrestR6.field_78809_i = true;
/* 190 */     this.ArmrestR6.func_78793_a(0.0F, 0.0F, 0.0F);
/* 191 */     this.ArmrestR6.func_78790_a(-17.8F, -3.5F, 15.8F, 5, 7, 8, 0.0F);
/* 192 */     this.ThroneTopSpikeL3 = new ModelRenderer(this, 97, 13);
/* 193 */     this.ThroneTopSpikeL3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 194 */     this.ThroneTopSpikeL3.func_78790_a(-21.4F, -37.0F, 12.5F, 2, 5, 2, 0.0F);
/* 195 */     this.ArmrestSpikeR2 = new ModelRenderer(this, 37, 71);
/* 196 */     this.ArmrestSpikeR2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 197 */     this.ArmrestSpikeR2.func_78790_a(-16.8F, -15.9F, -1.9F, 2, 3, 2, 0.0F);
/* 198 */     this.GuruHeadAntennaL = new ModelRenderer(this, 124, 0);
/* 199 */     this.GuruHeadAntennaL.func_78793_a(0.0F, 0.0F, 0.0F);
/* 200 */     this.GuruHeadAntennaL.func_78790_a(1.3F, -29.1F, 3.8F, 1, 1, 3, 0.0F);
/* 201 */     setRotateAngle(this.GuruHeadAntennaL, 0.13823007F, -0.13264503F, 0.0F);
/* 202 */     this.ThroneTopSpikeL2 = new ModelRenderer(this, 99, 21);
/* 203 */     this.ThroneTopSpikeL2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 204 */     this.ThroneTopSpikeL2.func_78790_a(-21.9F, -32.1F, 11.4F, 3, 4, 4, 0.0F);
/* 205 */     this.ThroneTopSpikeR3 = new ModelRenderer(this, 97, 13);
/* 206 */     this.ThroneTopSpikeR3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 207 */     this.ThroneTopSpikeR3.func_78790_a(19.8F, -37.0F, 12.5F, 2, 5, 2, 0.0F);
/* 208 */     this.GuruBase3 = new ModelRenderer(this, 0, 45);
/* 209 */     this.GuruBase3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 210 */     this.GuruBase3.func_78790_a(-8.5F, -14.9F, -8.8F, 16, 11, 4, 0.0F);
/* 211 */     this.GuruArmR1 = new ModelRenderer(this, 72, 28);
/* 212 */     this.GuruArmR1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 213 */     this.GuruArmR1.func_78790_a(-18.0F, -17.3F, 5.3F, 4, 7, 4, 0.0F);
/* 214 */     setRotateAngle(this.GuruArmR1, 0.0F, 0.0F, 0.31869712F);
/* 215 */     this.ArmrestR2 = new ModelRenderer(this, 48, 83);
/* 216 */     this.ArmrestR2.field_78809_i = true;
/* 217 */     this.ArmrestR2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 218 */     this.ArmrestR2.func_78790_a(-19.3F, -11.4F, -1.6F, 7, 7, 5, 0.0F);
/* 219 */     setRotateAngle(this.ArmrestR2, 0.08726646F, 0.0F, 0.0F);
/* 220 */     this.ThroneTopL1 = new ModelRenderer(this, 117, 43);
/* 221 */     this.ThroneTopL1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 222 */     this.ThroneTopL1.func_78790_a(2.3F, -32.2F, 10.1F, 4, 8, 7, 0.0F);
/* 223 */     setRotateAngle(this.ThroneTopL1, 0.0F, 0.0F, 0.27314404F);
/* 224 */     this.ArmrestR4 = new ModelRenderer(this, 5, 98);
/* 225 */     this.ArmrestR4.field_78809_i = true;
/* 226 */     this.ArmrestR4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 227 */     this.ArmrestR4.func_78790_a(-18.7F, -12.6F, -6.0F, 6, 6, 5, 0.0F);
/* 228 */     setRotateAngle(this.ArmrestR4, 1.0016445F, 0.0F, 0.0F);
/* 229 */     this.ArmrestSpikeL2 = new ModelRenderer(this, 37, 71);
/* 230 */     this.ArmrestSpikeL2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 231 */     this.ArmrestSpikeL2.func_78790_a(14.7F, -15.9F, -1.9F, 2, 3, 2, 0.0F);
/* 232 */     this.ThroneTopR3 = new ModelRenderer(this, 144, 44);
/* 233 */     this.ThroneTopR3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 234 */     this.ThroneTopR3.func_78790_a(15.1F, -23.4F, 10.1F, 8, 5, 7, 0.0F);
/* 235 */     setRotateAngle(this.ThroneTopR3, 0.0F, 0.0F, -0.77946407F);
/* 236 */     this.ArmrestR3 = new ModelRenderer(this, 23, 86);
/* 237 */     this.ArmrestR3.field_78809_i = true;
/* 238 */     this.ArmrestR3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 239 */     this.ArmrestR3.func_78790_a(-19.3F, -10.9F, -6.4F, 7, 6, 10, 0.0F);
/* 240 */     setRotateAngle(this.ArmrestR3, 0.5462881F, 0.0F, 0.0F);
/* 241 */     this.ArmrestSpikeR1 = new ModelRenderer(this, 31, 77);
/* 242 */     this.ArmrestSpikeR1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 243 */     this.ArmrestSpikeR1.func_78790_a(-18.3F, -12.9F, -3.4F, 5, 2, 5, 0.0F);
/* 244 */     setRotateAngle(this.ArmrestSpikeR1, 0.5462881F, 0.0F, 0.0F);
/* 245 */     this.ArmrestL10 = new ModelRenderer(this, 150, 114);
/* 246 */     this.ArmrestL10.func_78793_a(0.0F, 0.0F, 0.0F);
/* 247 */     this.ArmrestL10.func_78790_a(13.0F, -25.7F, 6.7F, 5, 6, 6, 0.0F);
/* 248 */     setRotateAngle(this.ArmrestL10, -0.31869712F, 0.0F, 0.0F);
/* 249 */     this.ArmrestL4 = new ModelRenderer(this, 5, 98);
/* 250 */     this.ArmrestL4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 251 */     this.ArmrestL4.func_78790_a(12.6F, -12.6F, -6.0F, 6, 6, 5, 0.0F);
/* 252 */     setRotateAngle(this.ArmrestL4, 1.0016445F, 0.0F, 0.0F);
/* 253 */     this.ArmrestL2 = new ModelRenderer(this, 48, 83);
/* 254 */     this.ArmrestL2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 255 */     this.ArmrestL2.func_78790_a(12.2F, -11.4F, -1.6F, 7, 7, 5, 0.0F);
/* 256 */     setRotateAngle(this.ArmrestL2, 0.08726646F, 0.0F, 0.0F);
/* 257 */     this.ArmrestR5 = new ModelRenderer(this, 1, 111);
/* 258 */     this.ArmrestR5.field_78809_i = true;
/* 259 */     this.ArmrestR5.func_78793_a(0.0F, 0.0F, 0.0F);
/* 260 */     this.ArmrestR5.func_78790_a(-17.9F, -13.1F, -8.4F, 5, 5, 5, 0.0F);
/* 261 */     setRotateAngle(this.ArmrestR5, 1.1838568F, 0.010122909F, 0.0F);
/* 262 */     this.GuruArmL2 = new ModelRenderer(this, 73, 40);
/* 263 */     this.GuruArmL2.field_78809_i = true;
/* 264 */     this.GuruArmL2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 265 */     this.GuruArmL2.func_78790_a(12.4F, -12.1F, -1.0F, 4, 4, 10, 0.0F);
/* 266 */     setRotateAngle(this.GuruArmL2, 0.0F, 0.0F, 0.091106184F);
/* 267 */     this.GuruLegL1 = new ModelRenderer(this, 0, 61);
/* 268 */     this.GuruLegL1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 269 */     this.GuruLegL1.func_78790_a(3.8F, -8.2F, -15.0F, 6, 9, 11, 0.0F);
/* 270 */     this.ArmrestR8 = new ModelRenderer(this, 128, 90);
/* 271 */     this.ArmrestR8.field_78809_i = true;
/* 272 */     this.ArmrestR8.func_78793_a(0.0F, 0.0F, 0.0F);
/* 273 */     this.ArmrestR8.func_78790_a(-19.3F, -17.0F, 10.5F, 7, 7, 6, 0.0F);
/* 274 */     setRotateAngle(this.ArmrestR8, -0.4553564F, 0.0F, 0.0F);
/* 275 */     this.GuruLegL2 = new ModelRenderer(this, 0, 82);
/* 276 */     this.GuruLegL2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 277 */     this.GuruLegL2.func_78790_a(5.6F, 0.9F, -16.5F, 3, 3, 7, 0.0F);
/* 278 */     this.ThroneTopL3 = new ModelRenderer(this, 144, 44);
/* 279 */     this.ThroneTopL3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 280 */     this.ThroneTopL3.func_78790_a(-22.9F, -23.4F, 10.1F, 8, 5, 7, 0.0F);
/* 281 */     setRotateAngle(this.ThroneTopL3, 0.0F, 0.0F, 0.77946407F);
/* 282 */     this.GuruBase2 = new ModelRenderer(this, 0, 29);
/* 283 */     this.GuruBase2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 284 */     this.GuruBase2.func_78790_a(-8.5F, -22.3F, -1.0F, 16, 4, 11, 0.0F);
/* 285 */     this.ThroneSideL = new ModelRenderer(this, 100, 59);
/* 286 */     this.ThroneSideL.func_78793_a(0.0F, 0.0F, 0.0F);
/* 287 */     this.ThroneSideL.func_78790_a(15.4F, -18.6F, 10.1F, 5, 15, 7, 0.0F);
/* 288 */     setRotateAngle(this.ThroneSideL, 0.0F, 0.0F, -0.3351032F);
/* 289 */     this.ArmrestL7 = new ModelRenderer(this, 109, 83);
/* 290 */     this.ArmrestL7.func_78793_a(0.0F, 0.0F, 0.0F);
/* 291 */     this.ArmrestL7.func_78790_a(12.2F, -13.7F, 9.7F, 7, 7, 5, 0.0F);
/* 292 */     setRotateAngle(this.ArmrestL7, -0.18203785F, 0.0F, 0.0F);
/* 293 */     this.ThroneTopR1 = new ModelRenderer(this, 117, 43);
/* 294 */     this.ThroneTopR1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 295 */     this.ThroneTopR1.func_78790_a(-6.2F, -32.2F, 10.1F, 4, 8, 7, 0.0F);
/* 296 */     setRotateAngle(this.ThroneTopR1, 0.0F, 0.0F, -0.27314404F);
/* 297 */     this.GuruHeadAntennaR = new ModelRenderer(this, 124, 0);
/* 298 */     this.GuruHeadAntennaR.func_78793_a(0.0F, 0.0F, 0.0F);
/* 299 */     this.GuruHeadAntennaR.func_78790_a(-3.4F, -29.1F, 3.8F, 1, 1, 3, 0.0F);
/* 300 */     setRotateAngle(this.GuruHeadAntennaR, 0.13823007F, 0.13264503F, 0.0F);
/* 301 */     this.ArmrestL62 = new ModelRenderer(this, 29, 105);
/* 302 */     this.ArmrestL62.func_78793_a(0.0F, 0.0F, 0.0F);
/* 303 */     this.ArmrestL62.func_78790_a(12.8F, -3.4F, -10.8F, 5, 7, 8, 0.0F);
/* 304 */     this.ThroneTopR2 = new ModelRenderer(this, 128, 28);
/* 305 */     this.ThroneTopR2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 306 */     this.ThroneTopR2.func_78790_a(-2.3F, -35.2F, 10.1F, 9, 6, 7, 0.0F);
/* 307 */     this.ThroneTopSpikeR2 = new ModelRenderer(this, 99, 21);
/* 308 */     this.ThroneTopSpikeR2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 309 */     this.ThroneTopSpikeR2.func_78790_a(19.2F, -32.1F, 11.4F, 3, 4, 4, 0.0F);
/* 310 */     this.GuruArmR2 = new ModelRenderer(this, 73, 40);
/* 311 */     this.GuruArmR2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 312 */     this.GuruArmR2.func_78790_a(-17.2F, -12.1F, -1.0F, 4, 4, 10, 0.0F);
/* 313 */     setRotateAngle(this.GuruArmR2, 0.0F, 0.0F, -0.091106184F);
/* 314 */     this.ArmrestL1 = new ModelRenderer(this, 74, 76);
/* 315 */     this.ArmrestL1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 316 */     this.ArmrestL1.func_78790_a(12.2F, -11.7F, 2.2F, 7, 7, 10, 0.0F);
/* 317 */     this.ArmrestR62 = new ModelRenderer(this, 29, 105);
/* 318 */     this.ArmrestR62.field_78809_i = true;
/* 319 */     this.ArmrestR62.func_78793_a(0.0F, 0.0F, 0.0F);
/* 320 */     this.ArmrestR62.func_78790_a(-17.8F, -3.4F, -10.8F, 5, 7, 8, 0.0F);
/* 321 */     this.GuruNeckTuftClothing.func_78792_a(this.GuruHead);
/* 322 */     this.ArmrestSpikeR2.func_78792_a(this.ArmrestSpikeR3);
/* 323 */     this.Throne1.func_78792_a(this.Throne2);
/* 324 */     this.GuruBase3.func_78792_a(this.GuruLegR1);
/* 325 */     this.GuruBase2.func_78792_a(this.GuruNeckTuftClothing);
/* 326 */     this.ArmrestSpikeL2.func_78792_a(this.ArmrestSpikeL3);
/* 327 */     this.ArmrestR8.func_78792_a(this.ArmrestR9);
/* 328 */     this.ThroneTopL1.func_78792_a(this.ThroneTopL2);
/* 329 */     this.ArmrestL1.func_78792_a(this.ArmrestSpikeL1);
/* 330 */     this.ArmrestL8.func_78792_a(this.ArmrestL9);
/* 331 */     this.ArmrestR9.func_78792_a(this.ArmrestR10);
/* 332 */     this.ThroneTopR1.func_78792_a(this.ThroneTopSpikeR1);
/* 333 */     this.ArmrestBaseL.func_78792_a(this.ArmrestL8);
/* 334 */     this.Throne1.func_78792_a(this.GuruBase1);
/* 335 */     this.GuruLegR1.func_78792_a(this.GuruLegR2);
/* 336 */     this.Throne2.func_78792_a(this.ArmrestBaseL);
/* 337 */     this.GuruBase2.func_78792_a(this.GuruArmL1);
/* 338 */     this.Throne2.func_78792_a(this.ThroneTop1);
/* 339 */     this.ArmrestBaseL.func_78792_a(this.ArmrestL3);
/* 340 */     this.GuruBase3.func_78792_a(this.GuruLegM);
/* 341 */     this.ThroneTopL1.func_78792_a(this.ThroneTopSpikeL1);
/* 342 */     this.Throne2.func_78792_a(this.ArmrestBaseR);
/* 343 */     this.ArmrestBaseR.func_78792_a(this.ArmrestR7);
/* 344 */     this.ArmrestBaseL.func_78792_a(this.ArmrestL6);
/* 345 */     this.ArmrestBaseR.func_78792_a(this.ArmrestR1);
/* 346 */     this.ArmrestBaseL.func_78792_a(this.ArmrestL5);
/* 347 */     this.Throne2.func_78792_a(this.ThroneSideR);
/* 348 */     this.ArmrestBaseR.func_78792_a(this.ArmrestR6);
/* 349 */     this.ThroneTopSpikeL2.func_78792_a(this.ThroneTopSpikeL3);
/* 350 */     this.ArmrestSpikeR1.func_78792_a(this.ArmrestSpikeR2);
/* 351 */     this.GuruHead.func_78792_a(this.GuruHeadAntennaL);
/* 352 */     this.ThroneTopSpikeL1.func_78792_a(this.ThroneTopSpikeL2);
/* 353 */     this.ThroneTopSpikeR2.func_78792_a(this.ThroneTopSpikeR3);
/* 354 */     this.GuruBase2.func_78792_a(this.GuruBase3);
/* 355 */     this.GuruBase2.func_78792_a(this.GuruArmR1);
/* 356 */     this.ArmrestBaseR.func_78792_a(this.ArmrestR2);
/* 357 */     this.ThroneTop1.func_78792_a(this.ThroneTopL1);
/* 358 */     this.ArmrestBaseR.func_78792_a(this.ArmrestR4);
/* 359 */     this.ArmrestSpikeL1.func_78792_a(this.ArmrestSpikeL2);
/* 360 */     this.ThroneTopR2.func_78792_a(this.ThroneTopR3);
/* 361 */     this.ArmrestBaseR.func_78792_a(this.ArmrestR3);
/* 362 */     this.ArmrestR1.func_78792_a(this.ArmrestSpikeR1);
/* 363 */     this.ArmrestL9.func_78792_a(this.ArmrestL10);
/* 364 */     this.ArmrestBaseL.func_78792_a(this.ArmrestL4);
/* 365 */     this.ArmrestBaseL.func_78792_a(this.ArmrestL2);
/* 366 */     this.ArmrestBaseR.func_78792_a(this.ArmrestR5);
/* 367 */     this.GuruArmL1.func_78792_a(this.GuruArmL2);
/* 368 */     this.GuruBase3.func_78792_a(this.GuruLegL1);
/* 369 */     this.ArmrestBaseR.func_78792_a(this.ArmrestR8);
/* 370 */     this.GuruLegL1.func_78792_a(this.GuruLegL2);
/* 371 */     this.ThroneTopL2.func_78792_a(this.ThroneTopL3);
/* 372 */     this.GuruBase1.func_78792_a(this.GuruBase2);
/* 373 */     this.Throne2.func_78792_a(this.ThroneSideL);
/* 374 */     this.ArmrestBaseL.func_78792_a(this.ArmrestL7);
/* 375 */     this.Throne2.func_78792_a(this.ThroneTopR1);
/* 376 */     this.GuruHead.func_78792_a(this.GuruHeadAntennaR);
/* 377 */     this.ArmrestL6.func_78792_a(this.ArmrestL62);
/* 378 */     this.ThroneTopR1.func_78792_a(this.ThroneTopR2);
/* 379 */     this.ThroneTopSpikeR1.func_78792_a(this.ThroneTopSpikeR2);
/* 380 */     this.GuruArmR1.func_78792_a(this.GuruArmR2);
/* 381 */     this.ArmrestBaseL.func_78792_a(this.ArmrestL1);
/* 382 */     this.ArmrestR6.func_78792_a(this.ArmrestR62);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 395 */     GL11.glPushMatrix();
/* 396 */     float F = entity.field_70131_O / 2.1F;
/* 397 */     JGRenderHelper.modelScalePositionHelper(F);
/* 398 */     this.Throne1.func_78785_a(f5);
/* 399 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 417 */     modelRenderer.field_78795_f = x;
/* 418 */     modelRenderer.field_78796_g = y;
/* 419 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelGuru.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */