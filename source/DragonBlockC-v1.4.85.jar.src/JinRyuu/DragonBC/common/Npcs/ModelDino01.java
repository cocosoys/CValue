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
/*     */ 
/*     */ public class ModelDino01
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Spine1;
/*     */   public ModelRenderer Tail1;
/*     */   public ModelRenderer ArmL1;
/*     */   public ModelRenderer ArmR1;
/*     */   public ModelRenderer LegL1;
/*     */   public ModelRenderer LegR1;
/*     */   public ModelRenderer Spine2;
/*     */   public ModelRenderer Spine3;
/*     */   public ModelRenderer Belly;
/*     */   public ModelRenderer Chest;
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Bottom;
/*     */   public ModelRenderer Back;
/*     */   public ModelRenderer Neck2;
/*     */   public ModelRenderer Neck3;
/*     */   public ModelRenderer Chest2;
/*     */   public ModelRenderer Jaw1;
/*     */   public ModelRenderer UpperMouth1;
/*     */   public ModelRenderer Horn1;
/*     */   public ModelRenderer Jaw2;
/*     */   public ModelRenderer UpperMouth2;
/*     */   public ModelRenderer Horn2;
/*     */   public ModelRenderer Horn3;
/*     */   public ModelRenderer Horn4;
/*     */   public ModelRenderer Horn5;
/*     */   public ModelRenderer Back2;
/*     */   public ModelRenderer Tail2;
/*     */   public ModelRenderer Tail3;
/*     */   public ModelRenderer Tail4;
/*     */   public ModelRenderer Tail5;
/*     */   public ModelRenderer ArmL2;
/*     */   public ModelRenderer ArmL3;
/*     */   public ModelRenderer ArmR2;
/*     */   public ModelRenderer ArmR3;
/*     */   public ModelRenderer LegL2;
/*     */   public ModelRenderer LegL3;
/*     */   public ModelRenderer LegLFoot1;
/*     */   public ModelRenderer LegLFoot2;
/*     */   public ModelRenderer LegLFoot3;
/*     */   public ModelRenderer LegR2;
/*     */   public ModelRenderer LegR3;
/*     */   public ModelRenderer LegLFoot1_1;
/*     */   public ModelRenderer LegLFoot2_1;
/*     */   public ModelRenderer LegLFoot3_1;
/*     */   
/*     */   public ModelDino01() {
/*  62 */     this.field_78090_t = 256;
/*  63 */     this.field_78089_u = 128;
/*  64 */     this.Horn5 = new ModelRenderer(this, 85, 59);
/*  65 */     this.Horn5.func_78793_a(0.0F, 0.0F, 0.0F);
/*  66 */     this.Horn5.func_78790_a(2.2F, -9.0F, -3.4F, 1, 7, 1, 0.0F);
/*  67 */     setRotateAngle(this.Horn5, -0.5066691F, -0.18727383F, 1.7357299F);
/*  68 */     this.ArmL2 = new ModelRenderer(this, 156, 16);
/*  69 */     this.ArmL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  70 */     this.ArmL2.func_78790_a(-0.9F, 3.3F, -8.5F, 2, 3, 7, 0.0F);
/*  71 */     setRotateAngle(this.ArmL2, 0.59184116F, 0.0F, 0.0F);
/*  72 */     this.Tail1 = new ModelRenderer(this, 0, 100);
/*  73 */     this.Tail1.func_78793_a(0.0F, -5.4F, 18.4F);
/*  74 */     this.Tail1.func_78790_a(-3.5F, -3.5F, -0.2F, 7, 11, 8, 0.0F);
/*  75 */     setRotateAngle(this.Tail1, -0.31869712F, 0.0F, 0.0F);
/*  76 */     this.LegLFoot3 = new ModelRenderer(this, 210, 65);
/*  77 */     this.LegLFoot3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  78 */     this.LegLFoot3.func_78790_a(0.8F, -10.8F, -22.7F, 2, 9, 2, 0.0F);
/*  79 */     setRotateAngle(this.LegLFoot3, 0.0F, 0.0F, -0.36651915F);
/*  80 */     this.LegR1 = new ModelRenderer(this, 179, 4);
/*  81 */     this.LegR1.func_78793_a(-5.8F, 0.0F, 10.1F);
/*  82 */     this.LegR1.func_78790_a(-3.2F, -4.6F, -3.3F, 5, 16, 9, 0.0F);
/*  83 */     setRotateAngle(this.LegR1, -0.7819075F, 0.04363323F, 0.0F);
/*  84 */     this.LegLFoot2 = new ModelRenderer(this, 210, 65);
/*  85 */     this.LegLFoot2.field_78809_i = true;
/*  86 */     this.LegLFoot2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  87 */     this.LegLFoot2.func_78790_a(-0.5F, -11.7F, -22.7F, 2, 9, 2, 0.0F);
/*  88 */     setRotateAngle(this.LegLFoot2, 0.0F, 0.0F, 0.36651915F);
/*  89 */     this.Spine3 = new ModelRenderer(this, 0, 46);
/*  90 */     this.Spine3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  91 */     this.Spine3.func_78790_a(-4.5F, -5.7F, 7.0F, 9, 16, 12, 0.0F);
/*  92 */     setRotateAngle(this.Spine3, -0.3642502F, 0.0F, 0.0F);
/*  93 */     this.Tail2 = new ModelRenderer(this, 31, 101);
/*  94 */     this.Tail2.func_78793_a(0.0F, -0.8F, 8.0F);
/*  95 */     this.Tail2.func_78790_a(-3.0F, -2.2F, -0.5F, 6, 9, 9, 0.0F);
/*  96 */     setRotateAngle(this.Tail2, 0.045553092F, 0.0F, 0.0F);
/*  97 */     this.Spine2 = new ModelRenderer(this, 0, 26);
/*  98 */     this.Spine2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  99 */     this.Spine2.func_78790_a(-4.5F, -2.6F, -15.0F, 9, 9, 10, 0.0F);
/* 100 */     setRotateAngle(this.Spine2, 0.045553092F, 0.0F, 0.0F);
/* 101 */     this.LegL3 = new ModelRenderer(this, 218, 45);
/* 102 */     this.LegL3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 103 */     this.LegL3.func_78790_a(-1.0F, 4.2F, -20.9F, 4, 4, 13, 0.0F);
/* 104 */     setRotateAngle(this.LegL3, 0.95609134F, 0.04363323F, 0.0F);
/* 105 */     this.ArmR1 = new ModelRenderer(this, 133, 3);
/* 106 */     this.ArmR1.func_78793_a(-5.6F, 0.8F, -11.7F);
/* 107 */     this.ArmR1.func_78790_a(-1.5F, -1.4F, -1.3F, 3, 7, 4, 0.0F);
/* 108 */     setRotateAngle(this.ArmR1, 0.230558F, 0.0F, 0.10471976F);
/* 109 */     this.Chest = new ModelRenderer(this, 47, 27);
/* 110 */     this.Chest.func_78793_a(0.0F, 0.0F, 0.0F);
/* 111 */     this.Chest.func_78790_a(-5.5F, 6.5F, -12.4F, 11, 8, 9, 0.0F);
/* 112 */     setRotateAngle(this.Chest, -0.13665928F, 0.0F, 0.0F);
/* 113 */     this.LegLFoot1 = new ModelRenderer(this, 223, 65);
/* 114 */     this.LegLFoot1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 115 */     this.LegLFoot1.func_78790_a(-0.5F, -12.7F, -22.5F, 3, 16, 2, 0.0F);
/* 116 */     setRotateAngle(this.LegLFoot1, 0.4553564F, 0.0F, 0.0F);
/* 117 */     this.Back2 = new ModelRenderer(this, 53, 75);
/* 118 */     this.Back2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 119 */     this.Back2.func_78790_a(-3.0F, -6.3F, -12.4F, 6, 4, 10, 0.0F);
/* 120 */     setRotateAngle(this.Back2, 0.5338962F, 0.0F, 0.0F);
/* 121 */     this.Jaw2 = new ModelRenderer(this, 102, 69);
/* 122 */     this.Jaw2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 123 */     this.Jaw2.func_78790_a(-3.5F, -0.8F, -8.9F, 7, 2, 2, 0.0F);
/* 124 */     this.Horn2 = new ModelRenderer(this, 85, 59);
/* 125 */     this.Horn2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 126 */     this.Horn2.func_78790_a(-1.6F, -8.6F, -2.5F, 1, 7, 1, 0.0F);
/* 127 */     setRotateAngle(this.Horn2, -0.40561453F, 0.12566371F, -1.2316788F);
/* 128 */     this.Horn4 = new ModelRenderer(this, 85, 59);
/* 129 */     this.Horn4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 130 */     this.Horn4.func_78790_a(0.9F, -9.6F, -1.3F, 1, 7, 1, 0.0F);
/* 131 */     setRotateAngle(this.Horn4, -0.40561453F, -0.12566371F, 1.2316788F);
/* 132 */     this.Jaw1 = new ModelRenderer(this, 93, 56);
/* 133 */     this.Jaw1.func_78793_a(0.0F, 5.6F, -5.3F);
/* 134 */     this.Jaw1.func_78790_a(-4.0F, -0.7F, -7.4F, 8, 3, 9, 0.0F);
/* 135 */     this.Spine1 = new ModelRenderer(this, 0, 0);
/* 136 */     this.Spine1.func_78793_a(0.0F, -10.1F, 0.0F);
/* 137 */     this.Spine1.func_78790_a(-6.0F, -3.0F, -5.2F, 12, 10, 14, 0.0F);
/* 138 */     setRotateAngle(this.Spine1, 0.0127409035F, 0.0F, 0.0F);
/* 139 */     this.Neck2 = new ModelRenderer(this, 55, 0);
/* 140 */     this.Neck2.func_78793_a(0.0F, 0.0F, -14.9F);
/* 141 */     this.Neck2.func_78790_a(-3.5F, -2.5F, -8.7F, 7, 8, 9, 0.0F);
/* 142 */     setRotateAngle(this.Neck2, 0.0418879F, 0.0F, 0.0F);
/* 143 */     this.ArmR3 = new ModelRenderer(this, 136, 28);
/* 144 */     this.ArmR3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 145 */     this.ArmR3.func_78790_a(-1.5F, 4.0F, -10.2F, 3, 4, 2, 0.0F);
/* 146 */     this.LegL1 = new ModelRenderer(this, 217, 4);
/* 147 */     this.LegL1.func_78793_a(5.4F, 0.0F, 10.1F);
/* 148 */     this.LegL1.func_78790_a(-1.5F, -4.6F, -3.3F, 5, 16, 9, 0.0F);
/* 149 */     setRotateAngle(this.LegL1, -0.7819075F, -0.04363323F, 0.0F);
/* 150 */     this.LegLFoot1_1 = new ModelRenderer(this, 196, 65);
/* 151 */     this.LegLFoot1_1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 152 */     this.LegLFoot1_1.func_78790_a(-2.0F, -12.7F, -22.5F, 3, 16, 2, 0.0F);
/* 153 */     setRotateAngle(this.LegLFoot1_1, 0.4553564F, 0.0F, 0.0F);
/* 154 */     this.Tail5 = new ModelRenderer(this, 124, 100);
/* 155 */     this.Tail5.func_78793_a(0.0F, 0.0F, 10.3F);
/* 156 */     this.Tail5.func_78790_a(-1.5F, -1.3F, -0.8F, 3, 4, 12, 0.0F);
/* 157 */     setRotateAngle(this.Tail5, 0.13665928F, 0.0F, 0.0F);
/* 158 */     this.Neck3 = new ModelRenderer(this, 89, 0);
/* 159 */     this.Neck3.func_78793_a(0.0F, 0.0F, -8.7F);
/* 160 */     this.Neck3.func_78790_a(-3.0F, -2.5F, -5.9F, 6, 7, 6, 0.0F);
/* 161 */     setRotateAngle(this.Neck3, 0.0418879F, 0.0F, 0.0F);
/* 162 */     this.ArmL3 = new ModelRenderer(this, 159, 28);
/* 163 */     this.ArmL3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 164 */     this.ArmL3.func_78790_a(-1.5F, 4.0F, -10.2F, 3, 4, 2, 0.0F);
/* 165 */     this.Belly = new ModelRenderer(this, 0, 75);
/* 166 */     this.Belly.func_78793_a(0.0F, 0.0F, 0.0F);
/* 167 */     this.Belly.func_78790_a(-6.5F, 3.9F, -2.3F, 13, 11, 13, 0.0F);
/* 168 */     setRotateAngle(this.Belly, -0.38519415F, 0.020277832F, 0.0F);
/* 169 */     this.Back = new ModelRenderer(this, 53, 75);
/* 170 */     this.Back.func_78793_a(0.0F, 0.0F, 0.0F);
/* 171 */     this.Back.func_78790_a(-3.0F, -4.3F, -5.4F, 6, 4, 10, 0.0F);
/* 172 */     setRotateAngle(this.Back, -0.21240658F, 0.0F, 0.0F);
/* 173 */     this.Horn1 = new ModelRenderer(this, 81, 45);
/* 174 */     this.Horn1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 175 */     this.Horn1.func_78790_a(-0.5F, -8.5F, -5.0F, 1, 8, 5, 0.0F);
/* 176 */     setRotateAngle(this.Horn1, -0.096342176F, 0.0F, 0.0F);
/* 177 */     this.Horn3 = new ModelRenderer(this, 85, 59);
/* 178 */     this.Horn3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 179 */     this.Horn3.func_78790_a(-3.2F, -9.0F, -3.4F, 1, 7, 1, 0.0F);
/* 180 */     setRotateAngle(this.Horn3, -0.5066691F, 0.18727383F, -1.7357299F);
/* 181 */     this.LegL2 = new ModelRenderer(this, 220, 31);
/* 182 */     this.LegL2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 183 */     this.LegL2.func_78790_a(-1.0F, 7.3F, -6.3F, 4, 4, 8, 0.0F);
/* 184 */     setRotateAngle(this.LegL2, 0.95609134F, 0.0F, 0.0F);
/* 185 */     this.Head = new ModelRenderer(this, 101, 15);
/* 186 */     this.Head.func_78793_a(0.0F, 0.0F, -28.8F);
/* 187 */     this.Head.func_78790_a(-3.5F, -1.2F, -6.0F, 7, 8, 6, 0.0F);
/* 188 */     setRotateAngle(this.Head, 0.12950343F, 0.0F, 0.0F);
/* 189 */     this.ArmL1 = new ModelRenderer(this, 158, 3);
/* 190 */     this.ArmL1.func_78793_a(5.3F, 0.8F, -11.7F);
/* 191 */     this.ArmL1.func_78790_a(-1.5F, -1.4F, -1.3F, 3, 7, 4, 0.0F);
/* 192 */     setRotateAngle(this.ArmL1, 0.230558F, 0.0F, -0.10471976F);
/* 193 */     this.LegR3 = new ModelRenderer(this, 175, 45);
/* 194 */     this.LegR3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 195 */     this.LegR3.func_78790_a(-2.6F, 4.2F, -20.9F, 4, 4, 13, 0.0F);
/* 196 */     setRotateAngle(this.LegR3, 0.95609134F, -0.04363323F, 0.0F);
/* 197 */     this.UpperMouth2 = new ModelRenderer(this, 95, 43);
/* 198 */     this.UpperMouth2.func_78793_a(0.0F, 0.3F, 0.0F);
/* 199 */     this.UpperMouth2.func_78790_a(-3.5F, 1.2F, -14.3F, 7, 3, 9, 0.0F);
/* 200 */     this.LegLFoot3_1 = new ModelRenderer(this, 210, 65);
/* 201 */     this.LegLFoot3_1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 202 */     this.LegLFoot3_1.func_78790_a(-0.5F, -12.0F, -22.7F, 2, 9, 2, 0.0F);
/* 203 */     setRotateAngle(this.LegLFoot3_1, 0.0F, 0.0F, -0.36651915F);
/* 204 */     this.ArmR2 = new ModelRenderer(this, 132, 16);
/* 205 */     this.ArmR2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 206 */     this.ArmR2.func_78790_a(-0.9F, 3.3F, -8.5F, 2, 3, 7, 0.0F);
/* 207 */     setRotateAngle(this.ArmR2, 0.59184116F, 0.0F, 0.0F);
/* 208 */     this.UpperMouth1 = new ModelRenderer(this, 91, 30);
/* 209 */     this.UpperMouth1.func_78793_a(0.0F, 0.3F, 0.0F);
/* 210 */     this.UpperMouth1.func_78790_a(-4.0F, 2.6F, -12.7F, 8, 2, 10, 0.0F);
/* 211 */     this.Bottom = new ModelRenderer(this, 43, 56);
/* 212 */     this.Bottom.func_78793_a(0.0F, 0.0F, 0.0F);
/* 213 */     this.Bottom.func_78790_a(-3.5F, 10.3F, 1.0F, 7, 8, 10, 0.0F);
/* 214 */     setRotateAngle(this.Bottom, 0.18203785F, 0.0F, 0.0F);
/* 215 */     this.Tail4 = new ModelRenderer(this, 93, 101);
/* 216 */     this.Tail4.func_78793_a(0.0F, 0.0F, 9.1F);
/* 217 */     this.Tail4.func_78790_a(-2.0F, -1.9F, -0.5F, 4, 6, 11, 0.0F);
/* 218 */     setRotateAngle(this.Tail4, 0.13665928F, 0.0F, 0.0F);
/* 219 */     this.Chest2 = new ModelRenderer(this, 48, 45);
/* 220 */     this.Chest2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 221 */     this.Chest2.func_78790_a(-4.0F, 14.6F, -4.5F, 8, 3, 6, 0.0F);
/* 222 */     setRotateAngle(this.Chest2, -0.8651597F, 0.0F, 0.0F);
/* 223 */     this.Tail3 = new ModelRenderer(this, 62, 101);
/* 224 */     this.Tail3.func_78793_a(0.0F, 0.0F, 8.6F);
/* 225 */     this.Tail3.func_78790_a(-2.5F, -2.1F, -0.7F, 5, 7, 10, 0.0F);
/* 226 */     setRotateAngle(this.Tail3, 0.13665928F, 0.0F, 0.0F);
/* 227 */     this.LegLFoot2_1 = new ModelRenderer(this, 210, 65);
/* 228 */     this.LegLFoot2_1.field_78809_i = true;
/* 229 */     this.LegLFoot2_1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 230 */     this.LegLFoot2_1.func_78790_a(-2.1F, -11.7F, -22.7F, 2, 9, 2, 0.0F);
/* 231 */     setRotateAngle(this.LegLFoot2_1, 0.0F, 0.0F, 0.36651915F);
/* 232 */     this.LegR2 = new ModelRenderer(this, 180, 31);
/* 233 */     this.LegR2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 234 */     this.LegR2.func_78790_a(-2.6F, 7.3F, -6.3F, 4, 4, 8, 0.0F);
/* 235 */     setRotateAngle(this.LegR2, 0.95609134F, 0.0F, 0.0F);
/* 236 */     this.Horn1.func_78792_a(this.Horn5);
/* 237 */     this.ArmL1.func_78792_a(this.ArmL2);
/* 238 */     this.LegLFoot1.func_78792_a(this.LegLFoot3);
/* 239 */     this.LegLFoot1.func_78792_a(this.LegLFoot2);
/* 240 */     this.Spine1.func_78792_a(this.Spine3);
/* 241 */     this.Tail1.func_78792_a(this.Tail2);
/* 242 */     this.Spine1.func_78792_a(this.Spine2);
/* 243 */     this.LegL2.func_78792_a(this.LegL3);
/* 244 */     this.Spine1.func_78792_a(this.Chest);
/* 245 */     this.LegL3.func_78792_a(this.LegLFoot1);
/* 246 */     this.Back.func_78792_a(this.Back2);
/* 247 */     this.Jaw1.func_78792_a(this.Jaw2);
/* 248 */     this.Horn1.func_78792_a(this.Horn2);
/* 249 */     this.Horn1.func_78792_a(this.Horn4);
/* 250 */     this.Head.func_78792_a(this.Jaw1);
/* 251 */     this.Spine2.func_78792_a(this.Neck2);
/* 252 */     this.ArmR2.func_78792_a(this.ArmR3);
/* 253 */     this.LegR3.func_78792_a(this.LegLFoot1_1);
/* 254 */     this.Tail4.func_78792_a(this.Tail5);
/* 255 */     this.Neck2.func_78792_a(this.Neck3);
/* 256 */     this.ArmL2.func_78792_a(this.ArmL3);
/* 257 */     this.Spine1.func_78792_a(this.Belly);
/* 258 */     this.Spine1.func_78792_a(this.Back);
/* 259 */     this.Head.func_78792_a(this.Horn1);
/* 260 */     this.Horn1.func_78792_a(this.Horn3);
/* 261 */     this.LegL1.func_78792_a(this.LegL2);
/* 262 */     this.Spine1.func_78792_a(this.Head);
/* 263 */     this.LegR2.func_78792_a(this.LegR3);
/* 264 */     this.UpperMouth1.func_78792_a(this.UpperMouth2);
/* 265 */     this.LegLFoot1_1.func_78792_a(this.LegLFoot3_1);
/* 266 */     this.ArmR1.func_78792_a(this.ArmR2);
/* 267 */     this.Head.func_78792_a(this.UpperMouth1);
/* 268 */     this.Spine1.func_78792_a(this.Bottom);
/* 269 */     this.Tail3.func_78792_a(this.Tail4);
/* 270 */     this.Chest.func_78792_a(this.Chest2);
/* 271 */     this.Tail2.func_78792_a(this.Tail3);
/* 272 */     this.LegLFoot1_1.func_78792_a(this.LegLFoot2_1);
/* 273 */     this.LegR1.func_78792_a(this.LegR2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 278 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/* 279 */     GL11.glPushMatrix();
/* 280 */     float[] sizes = { 0.0F, 0.5F, 1.0F };
/* 281 */     float size = 5.0F;
/* 282 */     GL11.glScalef(size, size, size);
/* 283 */     GL11.glTranslatef(0.0F, -1.1F, 0.0F);
/* 284 */     this.Tail1.func_78785_a(f5);
/* 285 */     this.LegR1.func_78785_a(f5);
/* 286 */     this.ArmR1.func_78785_a(f5);
/* 287 */     this.Spine1.func_78785_a(f5);
/* 288 */     this.LegL1.func_78785_a(f5);
/* 289 */     this.ArmL1.func_78785_a(f5);
/* 290 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 294 */     modelRenderer.field_78795_f = x;
/* 295 */     modelRenderer.field_78796_g = y;
/* 296 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 300 */     int calc = par7Entity.field_70173_aa;
/* 301 */     if (calc > 100) calc -= 100; 
/* 302 */     float r = 360.0F;
/* 303 */     float r2 = 180.0F;
/* 304 */     float n4 = par4;
/* 305 */     float n5 = par5;
/*     */     
/* 307 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 308 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 309 */     float ex = par7Entity.field_70173_aa;
/* 310 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 311 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/* 312 */     this.Jaw1.field_78796_g = 0.0F;
/* 313 */     this.Jaw1.field_78795_f = 0.2F;
/* 314 */     this.Jaw1.field_78795_f += r4;
/*     */ 
/*     */     
/* 317 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 318 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/* 319 */     this.Tail1.field_78796_g = 0.2F;
/* 320 */     this.Tail1.field_78796_g += r4;
/*     */     
/* 322 */     this.Tail2.field_78796_g = 0.2F;
/* 323 */     this.Tail2.field_78796_g += r4;
/*     */     
/* 325 */     this.Tail3.field_78796_g = 0.2F;
/* 326 */     this.Tail3.field_78796_g += r4;
/*     */     
/* 328 */     this.Tail4.field_78796_g = 0.2F;
/* 329 */     this.Tail4.field_78796_g += r4;
/*     */     
/* 331 */     this.Tail5.field_78796_g = 0.2F;
/* 332 */     this.Tail5.field_78796_g += r4;
/*     */ 
/*     */     
/* 335 */     this.LegR1.field_78795_f = -0.8F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 336 */     this.LegL1.field_78795_f = -0.8F - MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 337 */     this.ArmR1.field_78795_f = -0.4F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 338 */     this.ArmL1.field_78795_f = -0.4F + MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 339 */     this.LegR1.field_78796_g = 0.0F;
/* 340 */     this.LegL1.field_78796_g = 0.0F;
/* 341 */     this.ArmR1.field_78796_g = 0.0F;
/* 342 */     this.ArmL1.field_78796_g = 0.0F;
/* 343 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelDino01.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */