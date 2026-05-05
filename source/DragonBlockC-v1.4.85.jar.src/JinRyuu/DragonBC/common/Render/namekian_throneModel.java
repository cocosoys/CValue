/*     */ package JinRyuu.DragonBC.common.Render;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class namekian_throneModel
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Throne1;
/*     */   public ModelRenderer Throne2;
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
/*     */   
/*     */   public namekian_throneModel() {
/*  61 */     this.field_78090_t = 256;
/*  62 */     this.field_78089_u = 128;
/*  63 */     this.ArmrestSpikeR2 = new ModelRenderer(this, 37, 71);
/*  64 */     this.ArmrestSpikeR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  65 */     this.ArmrestSpikeR2.func_78790_a(-16.8F, -15.9F, -1.9F, 2, 3, 2, 0.0F);
/*  66 */     this.ArmrestL3 = new ModelRenderer(this, 23, 86);
/*  67 */     this.ArmrestL3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  68 */     this.ArmrestL3.func_78790_a(12.2F, -10.9F, -6.4F, 7, 6, 10, 0.0F);
/*  69 */     setRotateAngle(this.ArmrestL3, 0.5462881F, 0.0F, 0.0F);
/*  70 */     this.ThroneTopR3 = new ModelRenderer(this, 144, 44);
/*  71 */     this.ThroneTopR3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  72 */     this.ThroneTopR3.func_78790_a(15.1F, -23.4F, 10.1F, 8, 5, 7, 0.0F);
/*  73 */     setRotateAngle(this.ThroneTopR3, 0.0F, 0.0F, -0.77946407F);
/*  74 */     this.ThroneTopL1 = new ModelRenderer(this, 117, 43);
/*  75 */     this.ThroneTopL1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  76 */     this.ThroneTopL1.func_78790_a(2.3F, -32.2F, 10.1F, 4, 8, 7, 0.0F);
/*  77 */     setRotateAngle(this.ThroneTopL1, 0.0F, 0.0F, 0.27314404F);
/*  78 */     this.ThroneTopL3 = new ModelRenderer(this, 144, 44);
/*  79 */     this.ThroneTopL3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  80 */     this.ThroneTopL3.func_78790_a(-22.9F, -23.4F, 10.1F, 8, 5, 7, 0.0F);
/*  81 */     setRotateAngle(this.ThroneTopL3, 0.0F, 0.0F, 0.77946407F);
/*  82 */     this.ThroneSideR = new ModelRenderer(this, 100, 59);
/*  83 */     this.ThroneSideR.field_78809_i = true;
/*  84 */     this.ThroneSideR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  85 */     this.ThroneSideR.func_78790_a(-20.5F, -18.7F, 10.1F, 5, 15, 7, 0.0F);
/*  86 */     setRotateAngle(this.ThroneSideR, 0.0F, 0.0F, 0.3351032F);
/*  87 */     this.ThroneTopL2 = new ModelRenderer(this, 128, 28);
/*  88 */     this.ThroneTopL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  89 */     this.ThroneTopL2.func_78790_a(-6.7F, -35.2F, 10.1F, 9, 6, 7, 0.0F);
/*  90 */     this.ArmrestSpikeL1 = new ModelRenderer(this, 31, 77);
/*  91 */     this.ArmrestSpikeL1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  92 */     this.ArmrestSpikeL1.func_78790_a(13.2F, -12.9F, -3.4F, 5, 2, 5, 0.0F);
/*  93 */     setRotateAngle(this.ArmrestSpikeL1, 0.5462881F, 0.0F, 0.0F);
/*  94 */     this.ThroneTopSpikeL2 = new ModelRenderer(this, 99, 21);
/*  95 */     this.ThroneTopSpikeL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  96 */     this.ThroneTopSpikeL2.func_78790_a(-21.9F, -32.1F, 11.4F, 3, 4, 4, 0.0F);
/*  97 */     this.ArmrestR1 = new ModelRenderer(this, 74, 76);
/*  98 */     this.ArmrestR1.field_78809_i = true;
/*  99 */     this.ArmrestR1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 100 */     this.ArmrestR1.func_78790_a(-19.3F, -11.7F, 2.2F, 7, 7, 10, 0.0F);
/* 101 */     this.ThroneTopR1 = new ModelRenderer(this, 117, 43);
/* 102 */     this.ThroneTopR1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 103 */     this.ThroneTopR1.func_78790_a(-6.2F, -32.2F, 10.1F, 4, 8, 7, 0.0F);
/* 104 */     setRotateAngle(this.ThroneTopR1, 0.0F, 0.0F, -0.27314404F);
/* 105 */     this.ThroneTopR2 = new ModelRenderer(this, 128, 28);
/* 106 */     this.ThroneTopR2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 107 */     this.ThroneTopR2.func_78790_a(-2.3F, -35.2F, 10.1F, 9, 6, 7, 0.0F);
/* 108 */     this.ArmrestR62 = new ModelRenderer(this, 29, 105);
/* 109 */     this.ArmrestR62.field_78809_i = true;
/* 110 */     this.ArmrestR62.func_78793_a(0.0F, 0.0F, 0.0F);
/* 111 */     this.ArmrestR62.func_78790_a(-17.8F, -3.4F, -10.8F, 5, 7, 8, 0.0F);
/* 112 */     this.ArmrestL1 = new ModelRenderer(this, 74, 76);
/* 113 */     this.ArmrestL1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 114 */     this.ArmrestL1.func_78790_a(12.2F, -11.7F, 2.2F, 7, 7, 10, 0.0F);
/* 115 */     this.ArmrestL10 = new ModelRenderer(this, 150, 114);
/* 116 */     this.ArmrestL10.func_78793_a(0.0F, 0.0F, 0.0F);
/* 117 */     this.ArmrestL10.func_78790_a(13.0F, -25.7F, 6.7F, 5, 6, 6, 0.0F);
/* 118 */     setRotateAngle(this.ArmrestL10, -0.31869712F, 0.0F, 0.0F);
/* 119 */     this.ArmrestR8 = new ModelRenderer(this, 128, 90);
/* 120 */     this.ArmrestR8.field_78809_i = true;
/* 121 */     this.ArmrestR8.func_78793_a(0.0F, 0.0F, 0.0F);
/* 122 */     this.ArmrestR8.func_78790_a(-19.3F, -17.0F, 10.5F, 7, 7, 6, 0.0F);
/* 123 */     setRotateAngle(this.ArmrestR8, -0.4553564F, 0.0F, 0.0F);
/* 124 */     this.ThroneTopSpikeL1 = new ModelRenderer(this, 104, 30);
/* 125 */     this.ThroneTopSpikeL1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 126 */     this.ThroneTopSpikeL1.func_78790_a(-23.0F, -28.4F, 10.5F, 5, 4, 6, 0.0F);
/* 127 */     setRotateAngle(this.ThroneTopSpikeL1, 0.0F, 0.0F, 0.77946407F);
/* 128 */     this.ArmrestSpikeL3 = new ModelRenderer(this, 39, 66);
/* 129 */     this.ArmrestSpikeL3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 130 */     this.ArmrestSpikeL3.func_78790_a(15.2F, -18.8F, -1.4F, 1, 3, 1, 0.0F);
/* 131 */     this.ArmrestR9 = new ModelRenderer(this, 148, 97);
/* 132 */     this.ArmrestR9.field_78809_i = true;
/* 133 */     this.ArmrestR9.func_78793_a(0.0F, 0.0F, 0.0F);
/* 134 */     this.ArmrestR9.func_78790_a(-18.8F, -22.4F, 7.4F, 6, 7, 7, 0.0F);
/* 135 */     setRotateAngle(this.ArmrestR9, -0.4553564F, 0.0F, 0.0F);
/* 136 */     this.Throne1 = new ModelRenderer(this, 174, 102);
/* 137 */     this.Throne1.func_78793_a(0.0F, 20.0F, 0.0F);
/* 138 */     this.Throne1.func_78790_a(-12.9F, -5.4F, -4.2F, 26, 9, 15, 0.0F);
/* 139 */     this.ArmrestSpikeL2 = new ModelRenderer(this, 37, 71);
/* 140 */     this.ArmrestSpikeL2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 141 */     this.ArmrestSpikeL2.func_78790_a(14.7F, -15.9F, -1.9F, 2, 3, 2, 0.0F);
/* 142 */     this.ThroneTopSpikeR3 = new ModelRenderer(this, 97, 13);
/* 143 */     this.ThroneTopSpikeR3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 144 */     this.ThroneTopSpikeR3.func_78790_a(19.8F, -37.0F, 12.5F, 2, 5, 2, 0.0F);
/* 145 */     this.ThroneTopSpikeR2 = new ModelRenderer(this, 99, 21);
/* 146 */     this.ThroneTopSpikeR2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 147 */     this.ThroneTopSpikeR2.func_78790_a(19.2F, -32.1F, 11.4F, 3, 4, 4, 0.0F);
/* 148 */     this.ArmrestBaseR = new ModelRenderer(this, 57, 95);
/* 149 */     this.ArmrestBaseR.field_78809_i = true;
/* 150 */     this.ArmrestBaseR.func_78793_a(0.0F, 0.0F, 0.0F);
/* 151 */     this.ArmrestBaseR.func_78790_a(-18.4F, -8.4F, -4.1F, 6, 12, 20, 0.0F);
/* 152 */     this.ArmrestSpikeR1 = new ModelRenderer(this, 31, 77);
/* 153 */     this.ArmrestSpikeR1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 154 */     this.ArmrestSpikeR1.func_78790_a(-18.3F, -12.9F, -3.4F, 5, 2, 5, 0.0F);
/* 155 */     setRotateAngle(this.ArmrestSpikeR1, 0.5462881F, 0.0F, 0.0F);
/* 156 */     this.ArmrestR6 = new ModelRenderer(this, 114, 108);
/* 157 */     this.ArmrestR6.field_78809_i = true;
/* 158 */     this.ArmrestR6.func_78793_a(0.0F, 0.0F, 0.0F);
/* 159 */     this.ArmrestR6.func_78790_a(-17.8F, -3.5F, 15.8F, 5, 7, 8, 0.0F);
/* 160 */     this.ArmrestL8 = new ModelRenderer(this, 128, 90);
/* 161 */     this.ArmrestL8.func_78793_a(0.0F, 0.0F, 0.0F);
/* 162 */     this.ArmrestL8.func_78790_a(12.2F, -17.0F, 10.5F, 7, 7, 6, 0.0F);
/* 163 */     setRotateAngle(this.ArmrestL8, -0.4553564F, 0.0F, 0.0F);
/* 164 */     this.ArmrestR5 = new ModelRenderer(this, 1, 111);
/* 165 */     this.ArmrestR5.field_78809_i = true;
/* 166 */     this.ArmrestR5.func_78793_a(0.0F, 0.0F, 0.0F);
/* 167 */     this.ArmrestR5.func_78790_a(-17.9F, -13.1F, -8.4F, 5, 5, 5, 0.0F);
/* 168 */     setRotateAngle(this.ArmrestR5, 1.1838568F, 0.010122909F, 0.0F);
/* 169 */     this.ArmrestR10 = new ModelRenderer(this, 150, 114);
/* 170 */     this.ArmrestR10.field_78809_i = true;
/* 171 */     this.ArmrestR10.func_78793_a(0.0F, 0.0F, 0.0F);
/* 172 */     this.ArmrestR10.func_78790_a(-18.3F, -25.7F, 6.7F, 5, 6, 6, 0.0F);
/* 173 */     setRotateAngle(this.ArmrestR10, -0.31869712F, 0.0F, 0.0F);
/* 174 */     this.ArmrestL7 = new ModelRenderer(this, 109, 83);
/* 175 */     this.ArmrestL7.func_78793_a(0.0F, 0.0F, 0.0F);
/* 176 */     this.ArmrestL7.func_78790_a(12.2F, -13.7F, 9.7F, 7, 7, 5, 0.0F);
/* 177 */     setRotateAngle(this.ArmrestL7, -0.18203785F, 0.0F, 0.0F);
/* 178 */     this.ArmrestL4 = new ModelRenderer(this, 5, 98);
/* 179 */     this.ArmrestL4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 180 */     this.ArmrestL4.func_78790_a(12.6F, -12.6F, -6.0F, 6, 6, 5, 0.0F);
/* 181 */     setRotateAngle(this.ArmrestL4, 1.0016445F, 0.0F, 0.0F);
/* 182 */     this.ArmrestSpikeR3 = new ModelRenderer(this, 39, 66);
/* 183 */     this.ArmrestSpikeR3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 184 */     this.ArmrestSpikeR3.func_78790_a(-16.3F, -18.8F, -1.4F, 1, 3, 1, 0.0F);
/* 185 */     this.ArmrestL2 = new ModelRenderer(this, 48, 83);
/* 186 */     this.ArmrestL2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 187 */     this.ArmrestL2.func_78790_a(12.2F, -11.4F, -1.6F, 7, 7, 5, 0.0F);
/* 188 */     setRotateAngle(this.ArmrestL2, 0.08726646F, 0.0F, 0.0F);
/* 189 */     this.ThroneSideL = new ModelRenderer(this, 100, 59);
/* 190 */     this.ThroneSideL.func_78793_a(0.0F, 0.0F, 0.0F);
/* 191 */     this.ThroneSideL.func_78790_a(15.4F, -18.6F, 10.1F, 5, 15, 7, 0.0F);
/* 192 */     setRotateAngle(this.ThroneSideL, 0.0F, 0.0F, -0.3351032F);
/* 193 */     this.ArmrestR2 = new ModelRenderer(this, 48, 83);
/* 194 */     this.ArmrestR2.field_78809_i = true;
/* 195 */     this.ArmrestR2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 196 */     this.ArmrestR2.func_78790_a(-19.3F, -11.4F, -1.6F, 7, 7, 5, 0.0F);
/* 197 */     setRotateAngle(this.ArmrestR2, 0.08726646F, 0.0F, 0.0F);
/* 198 */     this.ArmrestL6 = new ModelRenderer(this, 114, 108);
/* 199 */     this.ArmrestL6.func_78793_a(0.0F, 0.0F, 0.0F);
/* 200 */     this.ArmrestL6.func_78790_a(12.8F, -3.5F, 15.8F, 5, 7, 8, 0.0F);
/* 201 */     this.ArmrestR4 = new ModelRenderer(this, 5, 98);
/* 202 */     this.ArmrestR4.field_78809_i = true;
/* 203 */     this.ArmrestR4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 204 */     this.ArmrestR4.func_78790_a(-18.7F, -12.6F, -6.0F, 6, 6, 5, 0.0F);
/* 205 */     setRotateAngle(this.ArmrestR4, 1.0016445F, 0.0F, 0.0F);
/* 206 */     this.Throne2 = new ModelRenderer(this, 195, 61);
/* 207 */     this.Throne2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 208 */     this.Throne2.func_78790_a(-12.5F, -31.3F, 11.0F, 25, 35, 5, 0.0F);
/* 209 */     this.ArmrestR3 = new ModelRenderer(this, 23, 86);
/* 210 */     this.ArmrestR3.field_78809_i = true;
/* 211 */     this.ArmrestR3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 212 */     this.ArmrestR3.func_78790_a(-19.3F, -10.9F, -6.4F, 7, 6, 10, 0.0F);
/* 213 */     setRotateAngle(this.ArmrestR3, 0.5462881F, 0.0F, 0.0F);
/* 214 */     this.ThroneTop1 = new ModelRenderer(this, 212, 25);
/* 215 */     this.ThroneTop1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 216 */     this.ThroneTop1.func_78790_a(-3.5F, -36.8F, 10.1F, 7, 7, 7, 0.0F);
/* 217 */     this.ArmrestL5 = new ModelRenderer(this, 1, 111);
/* 218 */     this.ArmrestL5.func_78793_a(0.0F, 0.0F, 0.0F);
/* 219 */     this.ArmrestL5.func_78790_a(13.2F, -13.1F, -8.4F, 5, 5, 5, 0.0F);
/* 220 */     setRotateAngle(this.ArmrestL5, 1.1838568F, 0.010122909F, 0.0F);
/* 221 */     this.ArmrestBaseL = new ModelRenderer(this, 57, 95);
/* 222 */     this.ArmrestBaseL.func_78793_a(0.0F, 0.0F, 0.0F);
/* 223 */     this.ArmrestBaseL.func_78790_a(12.5F, -8.4F, -4.1F, 6, 12, 20, 0.0F);
/* 224 */     this.ThroneTopSpikeR1 = new ModelRenderer(this, 104, 30);
/* 225 */     this.ThroneTopSpikeR1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 226 */     this.ThroneTopSpikeR1.func_78790_a(18.2F, -28.4F, 10.5F, 5, 4, 6, 0.0F);
/* 227 */     setRotateAngle(this.ThroneTopSpikeR1, 0.0F, 0.0F, -0.77946407F);
/* 228 */     this.ArmrestL62 = new ModelRenderer(this, 29, 105);
/* 229 */     this.ArmrestL62.func_78793_a(0.0F, 0.0F, 0.0F);
/* 230 */     this.ArmrestL62.func_78790_a(12.8F, -3.4F, -10.8F, 5, 7, 8, 0.0F);
/* 231 */     this.ThroneTopSpikeL3 = new ModelRenderer(this, 97, 13);
/* 232 */     this.ThroneTopSpikeL3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 233 */     this.ThroneTopSpikeL3.func_78790_a(-21.4F, -37.0F, 12.5F, 2, 5, 2, 0.0F);
/* 234 */     this.ArmrestR7 = new ModelRenderer(this, 109, 83);
/* 235 */     this.ArmrestR7.field_78809_i = true;
/* 236 */     this.ArmrestR7.func_78793_a(0.0F, 0.0F, 0.0F);
/* 237 */     this.ArmrestR7.func_78790_a(-19.3F, -13.7F, 9.7F, 7, 7, 5, 0.0F);
/* 238 */     setRotateAngle(this.ArmrestR7, -0.18203785F, 0.0F, 0.0F);
/* 239 */     this.ArmrestL9 = new ModelRenderer(this, 148, 97);
/* 240 */     this.ArmrestL9.func_78793_a(0.0F, 0.0F, 0.0F);
/* 241 */     this.ArmrestL9.func_78790_a(12.6F, -22.4F, 7.4F, 6, 7, 7, 0.0F);
/* 242 */     setRotateAngle(this.ArmrestL9, -0.4553564F, 0.0F, 0.0F);
/* 243 */     this.ArmrestSpikeR1.func_78792_a(this.ArmrestSpikeR2);
/* 244 */     this.ArmrestBaseL.func_78792_a(this.ArmrestL3);
/* 245 */     this.ThroneTopR2.func_78792_a(this.ThroneTopR3);
/* 246 */     this.ThroneTop1.func_78792_a(this.ThroneTopL1);
/* 247 */     this.ThroneTopL2.func_78792_a(this.ThroneTopL3);
/* 248 */     this.Throne2.func_78792_a(this.ThroneSideR);
/* 249 */     this.ThroneTopL1.func_78792_a(this.ThroneTopL2);
/* 250 */     this.ArmrestL1.func_78792_a(this.ArmrestSpikeL1);
/* 251 */     this.ThroneTopSpikeL1.func_78792_a(this.ThroneTopSpikeL2);
/* 252 */     this.ArmrestBaseR.func_78792_a(this.ArmrestR1);
/* 253 */     this.Throne2.func_78792_a(this.ThroneTopR1);
/* 254 */     this.ThroneTopR1.func_78792_a(this.ThroneTopR2);
/* 255 */     this.ArmrestR6.func_78792_a(this.ArmrestR62);
/* 256 */     this.ArmrestBaseL.func_78792_a(this.ArmrestL1);
/* 257 */     this.ArmrestL9.func_78792_a(this.ArmrestL10);
/* 258 */     this.ArmrestBaseR.func_78792_a(this.ArmrestR8);
/* 259 */     this.ThroneTopL1.func_78792_a(this.ThroneTopSpikeL1);
/* 260 */     this.ArmrestSpikeL2.func_78792_a(this.ArmrestSpikeL3);
/* 261 */     this.ArmrestR8.func_78792_a(this.ArmrestR9);
/* 262 */     this.ArmrestSpikeL1.func_78792_a(this.ArmrestSpikeL2);
/* 263 */     this.ThroneTopSpikeR2.func_78792_a(this.ThroneTopSpikeR3);
/* 264 */     this.ThroneTopSpikeR1.func_78792_a(this.ThroneTopSpikeR2);
/* 265 */     this.Throne2.func_78792_a(this.ArmrestBaseR);
/* 266 */     this.ArmrestR1.func_78792_a(this.ArmrestSpikeR1);
/* 267 */     this.ArmrestBaseR.func_78792_a(this.ArmrestR6);
/* 268 */     this.ArmrestBaseL.func_78792_a(this.ArmrestL8);
/* 269 */     this.ArmrestBaseR.func_78792_a(this.ArmrestR5);
/* 270 */     this.ArmrestR9.func_78792_a(this.ArmrestR10);
/* 271 */     this.ArmrestBaseL.func_78792_a(this.ArmrestL7);
/* 272 */     this.ArmrestBaseL.func_78792_a(this.ArmrestL4);
/* 273 */     this.ArmrestSpikeR2.func_78792_a(this.ArmrestSpikeR3);
/* 274 */     this.ArmrestBaseL.func_78792_a(this.ArmrestL2);
/* 275 */     this.Throne2.func_78792_a(this.ThroneSideL);
/* 276 */     this.ArmrestBaseR.func_78792_a(this.ArmrestR2);
/* 277 */     this.ArmrestBaseL.func_78792_a(this.ArmrestL6);
/* 278 */     this.ArmrestBaseR.func_78792_a(this.ArmrestR4);
/* 279 */     this.Throne1.func_78792_a(this.Throne2);
/* 280 */     this.ArmrestBaseR.func_78792_a(this.ArmrestR3);
/* 281 */     this.Throne2.func_78792_a(this.ThroneTop1);
/* 282 */     this.ArmrestBaseL.func_78792_a(this.ArmrestL5);
/* 283 */     this.Throne2.func_78792_a(this.ArmrestBaseL);
/* 284 */     this.ThroneTopR1.func_78792_a(this.ThroneTopSpikeR1);
/* 285 */     this.ArmrestL6.func_78792_a(this.ArmrestL62);
/* 286 */     this.ThroneTopSpikeL2.func_78792_a(this.ThroneTopSpikeL3);
/* 287 */     this.ArmrestBaseR.func_78792_a(this.ArmrestR7);
/* 288 */     this.ArmrestL8.func_78792_a(this.ArmrestL9);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 293 */     this.Throne1.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderModel(float f5) {
/* 298 */     this.Throne1.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 305 */     modelRenderer.field_78795_f = x;
/* 306 */     modelRenderer.field_78796_g = y;
/* 307 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Render\namekian_throneModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */