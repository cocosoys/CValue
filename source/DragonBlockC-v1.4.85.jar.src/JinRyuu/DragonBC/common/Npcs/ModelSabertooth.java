/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModelSabertooth
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Head1;
/*     */   public ModelRenderer Base1;
/*     */   public ModelRenderer RFrontLeg1;
/*     */   public ModelRenderer LFrontLeg1;
/*     */   public ModelRenderer RBackLeg1;
/*     */   public ModelRenderer LBackLeg1;
/*     */   public ModelRenderer Tail1;
/*     */   public ModelRenderer MouthBottom1;
/*     */   public ModelRenderer MouthTop1;
/*     */   public ModelRenderer HeadSideL;
/*     */   public ModelRenderer HeadSideR;
/*     */   public ModelRenderer Rear;
/*     */   public ModelRenderer Lear;
/*     */   public ModelRenderer Nose;
/*     */   public ModelRenderer MouthBottom2;
/*     */   public ModelRenderer MouthTop2;
/*     */   public ModelRenderer FrontTeeth;
/*     */   public ModelRenderer ThoothL;
/*     */   public ModelRenderer ThoothR;
/*     */   public ModelRenderer ThoothL2;
/*     */   public ModelRenderer ThoothR2;
/*     */   public ModelRenderer HeadSideL2;
/*     */   public ModelRenderer HeadSideR2;
/*     */   public ModelRenderer Base2;
/*     */   public ModelRenderer Chest1;
/*     */   public ModelRenderer Back1;
/*     */   public ModelRenderer Base3;
/*     */   public ModelRenderer Neck;
/*     */   public ModelRenderer Base4;
/*     */   public ModelRenderer Base5;
/*     */   public ModelRenderer Chest2;
/*     */   public ModelRenderer Chest3;
/*     */   public ModelRenderer Back2;
/*     */   public ModelRenderer RFrontLeg2;
/*     */   public ModelRenderer RFrontLeg3;
/*     */   public ModelRenderer LFrontLeg2;
/*     */   public ModelRenderer LFrontLeg3;
/*     */   public ModelRenderer RBackLeg2;
/*     */   public ModelRenderer RBackLeg3;
/*     */   public ModelRenderer RBackLeg4;
/*     */   public ModelRenderer LBackLeg2;
/*     */   public ModelRenderer LBackLeg3;
/*     */   public ModelRenderer LBackLeg4;
/*     */   public ModelRenderer Tail2;
/*     */   public ModelRenderer Tail3;
/*     */   public ModelRenderer Tail4;
/*     */   public ModelRenderer Tail5;
/*     */   public ModelRenderer TailTuft;
/*     */   
/*     */   public ModelSabertooth() {
/*  65 */     this.field_78090_t = 128;
/*  66 */     this.field_78089_u = 128;
/*  67 */     this.LFrontLeg2 = new ModelRenderer(this, 63, 98);
/*  68 */     this.LFrontLeg2.field_78809_i = true;
/*  69 */     this.LFrontLeg2.func_78793_a(2.2F, 11.2F, -0.4F);
/*  70 */     this.LFrontLeg2.func_78790_a(-1.5F, -0.5F, -1.9F, 3, 14, 4, 0.0F);
/*  71 */     setRotateAngle(this.LFrontLeg2, -0.5009095F, 0.0F, 0.0F);
/*  72 */     this.RBackLeg4 = new ModelRenderer(this, 107, 119);
/*  73 */     this.RBackLeg4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  74 */     this.RBackLeg4.func_78790_a(-2.8F, 11.8F, 1.9F, 5, 3, 5, 0.0F);
/*  75 */     setRotateAngle(this.RBackLeg4, 0.143117F, 0.0F, 0.0F);
/*  76 */     this.RFrontLeg1 = new ModelRenderer(this, 42, 100);
/*  77 */     this.RFrontLeg1.func_78793_a(-4.7F, -1.6F, -0.5F);
/*  78 */     this.RFrontLeg1.func_78790_a(-4.0F, -1.9F, -3.0F, 4, 14, 6, 0.0F);
/*  79 */     setRotateAngle(this.RFrontLeg1, 0.18203785F, 0.0F, 0.0F);
/*  80 */     this.HeadSideL = new ModelRenderer(this, 81, 18);
/*  81 */     this.HeadSideL.field_78809_i = true;
/*  82 */     this.HeadSideL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  83 */     this.HeadSideL.func_78790_a(2.4F, 0.2F, -6.7F, 3, 5, 7, 0.0F);
/*  84 */     this.ThoothL = new ModelRenderer(this, 104, 48);
/*  85 */     this.ThoothL.field_78809_i = true;
/*  86 */     this.ThoothL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  87 */     this.ThoothL.func_78790_a(1.8F, 2.7F, -14.4F, 1, 4, 2, 0.0F);
/*  88 */     this.Back1 = new ModelRenderer(this, 40, 63);
/*  89 */     this.Back1.field_78809_i = true;
/*  90 */     this.Back1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  91 */     this.Back1.func_78790_a(1.6F, -1.4F, -2.3F, 2, 2, 7, 0.0F);
/*  92 */     this.Back2 = new ModelRenderer(this, 40, 63);
/*  93 */     this.Back2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  94 */     this.Back2.func_78790_a(-3.6F, -1.4F, -2.3F, 2, 2, 7, 0.0F);
/*  95 */     this.RFrontLeg3 = new ModelRenderer(this, 61, 118);
/*  96 */     this.RFrontLeg3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  97 */     this.RFrontLeg3.func_78790_a(-2.5F, 11.4F, -7.4F, 5, 3, 5, 0.0F);
/*  98 */     setRotateAngle(this.RFrontLeg3, 0.32637656F, 0.0F, 0.0F);
/*  99 */     this.FrontTeeth = new ModelRenderer(this, 109, 48);
/* 100 */     this.FrontTeeth.func_78793_a(0.0F, 0.0F, 0.0F);
/* 101 */     this.FrontTeeth.func_78790_a(-1.9F, 2.5F, -14.3F, 4, 1, 0, 0.0F);
/* 102 */     this.ThoothR = new ModelRenderer(this, 104, 48);
/* 103 */     this.ThoothR.func_78793_a(0.0F, 0.0F, 0.0F);
/* 104 */     this.ThoothR.func_78790_a(-2.7F, 2.7F, -14.4F, 1, 4, 2, 0.0F);
/* 105 */     this.Neck = new ModelRenderer(this, 62, 2);
/* 106 */     this.Neck.func_78793_a(0.0F, -0.2F, 0.0F);
/* 107 */     this.Neck.func_78790_a(-3.0F, 1.1F, -14.5F, 6, 7, 6, 0.0F);
/* 108 */     setRotateAngle(this.Neck, 0.027925268F, 0.0F, 0.0F);
/* 109 */     this.Tail3 = new ModelRenderer(this, 85, 75);
/* 110 */     this.Tail3.func_78793_a(0.0F, 0.0F, 5.7F);
/* 111 */     this.Tail3.func_78790_a(-1.0F, -1.0F, 0.0F, 2, 2, 6, 0.0F);
/* 112 */     setRotateAngle(this.Tail3, -0.045553092F, 0.0F, 0.0F);
/* 113 */     this.Chest2 = new ModelRenderer(this, 41, 20);
/* 114 */     this.Chest2.func_78793_a(0.0F, -0.2F, 0.0F);
/* 115 */     this.Chest2.func_78790_a(-2.5F, 9.0F, 3.0F, 5, 3, 4, 0.0F);
/* 116 */     setRotateAngle(this.Chest2, -0.7740535F, 0.0F, 0.0F);
/* 117 */     this.RBackLeg3 = new ModelRenderer(this, 113, 106);
/* 118 */     this.RBackLeg3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 119 */     this.RBackLeg3.func_78790_a(-1.7F, 2.9F, 6.4F, 3, 9, 3, 0.0F);
/* 120 */     setRotateAngle(this.RBackLeg3, -1.0016445F, 0.0F, -0.013962634F);
/* 121 */     this.Tail2 = new ModelRenderer(this, 85, 75);
/* 122 */     this.Tail2.func_78793_a(0.0F, 0.0F, 5.7F);
/* 123 */     this.Tail2.func_78790_a(-1.0F, -1.0F, 0.0F, 2, 2, 6, 0.0F);
/* 124 */     setRotateAngle(this.Tail2, -0.22759093F, 0.0F, 0.0F);
/* 125 */     this.LFrontLeg1 = new ModelRenderer(this, 42, 100);
/* 126 */     this.LFrontLeg1.field_78809_i = true;
/* 127 */     this.LFrontLeg1.func_78793_a(4.7F, -1.6F, -0.5F);
/* 128 */     this.LFrontLeg1.func_78790_a(0.3F, -1.9F, -3.0F, 4, 14, 6, 0.0F);
/* 129 */     setRotateAngle(this.LFrontLeg1, 0.18203785F, 0.0F, 0.0F);
/* 130 */     this.MouthTop1 = new ModelRenderer(this, 97, 35);
/* 131 */     this.MouthTop1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 132 */     this.MouthTop1.func_78790_a(-2.9F, -0.1F, -14.7F, 6, 3, 9, 0.0F);
/* 133 */     this.Tail4 = new ModelRenderer(this, 85, 75);
/* 134 */     this.Tail4.func_78793_a(0.0F, 0.0F, 5.7F);
/* 135 */     this.Tail4.func_78790_a(-1.0F, -1.0F, 0.0F, 2, 2, 6, 0.0F);
/* 136 */     setRotateAngle(this.Tail4, 0.13665928F, 0.0F, 0.0F);
/* 137 */     this.RBackLeg1 = new ModelRenderer(this, 79, 91);
/* 138 */     this.RBackLeg1.func_78793_a(-2.8F, -1.5F, 28.3F);
/* 139 */     this.RBackLeg1.func_78790_a(-6.1F, -2.5F, -2.7F, 6, 16, 9, 0.0F);
/* 140 */     setRotateAngle(this.RBackLeg1, -0.7278023F, 0.0F, 0.0F);
/* 141 */     this.LBackLeg1 = new ModelRenderer(this, 79, 91);
/* 142 */     this.LBackLeg1.field_78809_i = true;
/* 143 */     this.LBackLeg1.func_78793_a(2.7F, -1.5F, 28.3F);
/* 144 */     this.LBackLeg1.func_78790_a(-0.1F, -2.5F, -2.7F, 6, 16, 9, 0.0F);
/* 145 */     setRotateAngle(this.LBackLeg1, -0.7278023F, 0.0F, 0.0F);
/* 146 */     this.RFrontLeg2 = new ModelRenderer(this, 63, 98);
/* 147 */     this.RFrontLeg2.func_78793_a(-1.8F, 11.2F, -0.4F);
/* 148 */     this.RFrontLeg2.func_78790_a(-1.5F, -0.5F, -1.9F, 3, 14, 4, 0.0F);
/* 149 */     setRotateAngle(this.RFrontLeg2, -0.5009095F, 0.0F, 0.0F);
/* 150 */     this.MouthTop2 = new ModelRenderer(this, 101, 24);
/* 151 */     this.MouthTop2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 152 */     this.MouthTop2.func_78790_a(-2.0F, -1.2F, -14.5F, 4, 1, 9, 0.0F);
/* 153 */     setRotateAngle(this.MouthTop2, 0.036651913F, 0.0F, 0.0F);
/* 154 */     this.Chest3 = new ModelRenderer(this, 36, 45);
/* 155 */     this.Chest3.func_78793_a(0.0F, -0.2F, 0.0F);
/* 156 */     this.Chest3.func_78790_a(-2.5F, 9.9F, 2.9F, 5, 5, 10, 0.0F);
/* 157 */     setRotateAngle(this.Chest3, 0.3080506F, 0.0F, 0.0F);
/* 158 */     this.Tail1 = new ModelRenderer(this, 85, 75);
/* 159 */     this.Tail1.func_78793_a(0.0F, -1.6F, 32.9F);
/* 160 */     this.Tail1.func_78790_a(-1.0F, -0.9F, 0.0F, 2, 2, 6, 0.0F);
/* 161 */     setRotateAngle(this.Tail1, -0.5009095F, 0.0F, 0.0F);
/* 162 */     this.Lear = new ModelRenderer(this, 95, 3);
/* 163 */     this.Lear.func_78793_a(0.0F, 0.0F, 0.0F);
/* 164 */     this.Lear.func_78790_a(2.7F, -3.7F, -3.2F, 4, 1, 2, 0.0F);
/* 165 */     setRotateAngle(this.Lear, -0.3630285F, 0.0F, 0.0F);
/* 166 */     this.HeadSideL2 = new ModelRenderer(this, 85, 32);
/* 167 */     this.HeadSideL2.field_78809_i = true;
/* 168 */     this.HeadSideL2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 169 */     this.HeadSideL2.func_78790_a(4.8F, 0.9F, -4.8F, 2, 3, 6, 0.0F);
/* 170 */     this.Chest1 = new ModelRenderer(this, 33, 29);
/* 171 */     this.Chest1.func_78793_a(0.0F, -0.2F, 0.0F);
/* 172 */     this.Chest1.func_78790_a(-3.0F, 9.6F, -3.5F, 6, 4, 11, 0.0F);
/* 173 */     this.Base4 = new ModelRenderer(this, 0, 60);
/* 174 */     this.Base4.func_78793_a(0.0F, -0.2F, 0.0F);
/* 175 */     this.Base4.func_78790_a(-3.0F, 0.6F, 13.9F, 6, 9, 12, 0.0F);
/* 176 */     setRotateAngle(this.Base4, -0.04363323F, 0.0F, 0.0F);
/* 177 */     this.Rear = new ModelRenderer(this, 95, 3);
/* 178 */     this.Rear.func_78793_a(0.0F, 0.0F, 0.0F);
/* 179 */     this.Rear.func_78790_a(-6.7F, -3.7F, -3.2F, 4, 1, 2, 0.0F);
/* 180 */     setRotateAngle(this.Rear, -0.3630285F, 0.0F, 0.0F);
/* 181 */     this.Nose = new ModelRenderer(this, 120, 38);
/* 182 */     this.Nose.func_78793_a(0.0F, 0.0F, 0.0F);
/* 183 */     this.Nose.func_78790_a(-0.8F, -1.1F, -15.0F, 2, 1, 1, 0.0F);
/* 184 */     this.HeadSideR = new ModelRenderer(this, 81, 18);
/* 185 */     this.HeadSideR.func_78793_a(0.0F, 0.0F, 0.0F);
/* 186 */     this.HeadSideR.func_78790_a(-5.4F, -0.2F, -6.7F, 3, 5, 7, 0.0F);
/* 187 */     this.TailTuft = new ModelRenderer(this, 96, 78);
/* 188 */     this.TailTuft.func_78793_a(0.0F, 0.0F, 5.6F);
/* 189 */     this.TailTuft.func_78790_a(-1.5F, -1.7F, 0.0F, 3, 4, 6, 0.0F);
/* 190 */     setRotateAngle(this.TailTuft, 0.22759093F, 0.0F, 0.0F);
/* 191 */     this.HeadSideR2 = new ModelRenderer(this, 85, 32);
/* 192 */     this.HeadSideR2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 193 */     this.HeadSideR2.func_78790_a(-6.5F, 0.9F, -4.8F, 2, 3, 6, 0.0F);
/* 194 */     this.LBackLeg4 = new ModelRenderer(this, 107, 119);
/* 195 */     this.LBackLeg4.field_78809_i = true;
/* 196 */     this.LBackLeg4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 197 */     this.LBackLeg4.func_78790_a(-2.1F, 11.8F, 1.9F, 5, 3, 5, 0.0F);
/* 198 */     setRotateAngle(this.LBackLeg4, 0.143117F, 0.0F, 0.0F);
/* 199 */     this.MouthBottom2 = new ModelRenderer(this, 105, 67);
/* 200 */     this.MouthBottom2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 201 */     this.MouthBottom2.func_78790_a(-2.0F, -0.4F, -9.1F, 4, 3, 3, 0.0F);
/* 202 */     this.Head1 = new ModelRenderer(this, 95, 8);
/* 203 */     this.Head1.func_78793_a(0.0F, -1.2F, -13.9F);
/* 204 */     this.Head1.func_78790_a(-4.5F, -3.7F, -6.1F, 9, 8, 7, 0.0F);
/* 205 */     this.MouthBottom1 = new ModelRenderer(this, 99, 55);
/* 206 */     this.MouthBottom1.func_78793_a(0.0F, 3.3F, -4.9F);
/* 207 */     this.MouthBottom1.func_78790_a(-2.5F, -0.8F, -8.6F, 5, 2, 9, 0.0F);
/* 208 */     this.Base2 = new ModelRenderer(this, 0, 24);
/* 209 */     this.Base2.func_78793_a(0.0F, -0.2F, 0.0F);
/* 210 */     this.Base2.func_78790_a(-4.0F, 0.5F, -8.7F, 8, 10, 4, 0.0F);
/* 211 */     setRotateAngle(this.Base2, 0.02617994F, 0.0F, 0.0F);
/* 212 */     this.LBackLeg2 = new ModelRenderer(this, 111, 93);
/* 213 */     this.LBackLeg2.field_78809_i = true;
/* 214 */     this.LBackLeg2.func_78793_a(2.8F, 11.9F, 3.6F);
/* 215 */     this.LBackLeg2.func_78790_a(-1.8F, 0.9F, -2.3F, 4, 8, 4, 0.0F);
/* 216 */     setRotateAngle(this.LBackLeg2, 1.5934856F, 0.0F, 0.0F);
/* 217 */     this.Tail5 = new ModelRenderer(this, 85, 75);
/* 218 */     this.Tail5.func_78793_a(0.0F, 0.0F, 5.7F);
/* 219 */     this.Tail5.func_78790_a(-1.0F, -1.0F, 0.0F, 2, 2, 6, 0.0F);
/* 220 */     setRotateAngle(this.Tail5, 0.091106184F, 0.0F, 0.0F);
/* 221 */     this.LFrontLeg3 = new ModelRenderer(this, 61, 118);
/* 222 */     this.LFrontLeg3.field_78809_i = true;
/* 223 */     this.LFrontLeg3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 224 */     this.LFrontLeg3.func_78790_a(-2.3F, 11.4F, -7.4F, 5, 3, 5, 0.0F);
/* 225 */     setRotateAngle(this.LFrontLeg3, 0.32637656F, 0.0F, 0.0F);
/* 226 */     this.ThoothR2 = new ModelRenderer(this, 117, 49);
/* 227 */     this.ThoothR2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 228 */     this.ThoothR2.func_78790_a(-2.7F, 6.7F, -14.1F, 1, 1, 2, 0.0F);
/* 229 */     this.RBackLeg2 = new ModelRenderer(this, 111, 93);
/* 230 */     this.RBackLeg2.func_78793_a(-3.2F, 11.9F, 3.6F);
/* 231 */     this.RBackLeg2.func_78790_a(-2.1F, 0.9F, -2.3F, 4, 8, 4, 0.0F);
/* 232 */     setRotateAngle(this.RBackLeg2, 1.5934856F, 0.0F, 0.0F);
/* 233 */     this.Base3 = new ModelRenderer(this, 0, 40);
/* 234 */     this.Base3.func_78793_a(0.0F, -0.2F, 0.0F);
/* 235 */     this.Base3.func_78790_a(-3.5F, 0.5F, 6.0F, 7, 10, 8, 0.0F);
/* 236 */     setRotateAngle(this.Base3, -0.04363323F, 0.0F, 0.0F);
/* 237 */     this.LBackLeg3 = new ModelRenderer(this, 113, 106);
/* 238 */     this.LBackLeg3.field_78809_i = true;
/* 239 */     this.LBackLeg3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 240 */     this.LBackLeg3.func_78790_a(-1.2F, 2.9F, 6.4F, 3, 9, 3, 0.0F);
/* 241 */     setRotateAngle(this.LBackLeg3, -1.0016445F, 0.0F, -0.013962634F);
/* 242 */     this.Base1 = new ModelRenderer(this, 0, 0);
/* 243 */     this.Base1.func_78793_a(0.0F, -5.6F, 0.0F);
/* 244 */     this.Base1.func_78790_a(-4.5F, -0.1F, -5.0F, 9, 11, 11, 0.0F);
/* 245 */     this.ThoothL2 = new ModelRenderer(this, 117, 49);
/* 246 */     this.ThoothL2.field_78809_i = true;
/* 247 */     this.ThoothL2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 248 */     this.ThoothL2.func_78790_a(1.8F, 6.7F, -14.1F, 1, 1, 2, 0.0F);
/* 249 */     this.Base5 = new ModelRenderer(this, 0, 83);
/* 250 */     this.Base5.func_78793_a(0.0F, -0.2F, 0.0F);
/* 251 */     this.Base5.func_78790_a(-2.5F, -0.1F, 25.1F, 5, 8, 9, 0.0F);
/* 252 */     setRotateAngle(this.Base5, -0.04363323F, 0.0F, 0.0F);
/* 253 */     this.LFrontLeg1.func_78792_a(this.LFrontLeg2);
/* 254 */     this.RBackLeg3.func_78792_a(this.RBackLeg4);
/* 255 */     this.Head1.func_78792_a(this.HeadSideL);
/* 256 */     this.MouthTop1.func_78792_a(this.ThoothL);
/* 257 */     this.Base1.func_78792_a(this.Back1);
/* 258 */     this.Back1.func_78792_a(this.Back2);
/* 259 */     this.RFrontLeg2.func_78792_a(this.RFrontLeg3);
/* 260 */     this.MouthTop1.func_78792_a(this.FrontTeeth);
/* 261 */     this.MouthTop1.func_78792_a(this.ThoothR);
/* 262 */     this.Base2.func_78792_a(this.Neck);
/* 263 */     this.Tail2.func_78792_a(this.Tail3);
/* 264 */     this.Chest1.func_78792_a(this.Chest2);
/* 265 */     this.RBackLeg2.func_78792_a(this.RBackLeg3);
/* 266 */     this.Tail1.func_78792_a(this.Tail2);
/* 267 */     this.Head1.func_78792_a(this.MouthTop1);
/* 268 */     this.Tail3.func_78792_a(this.Tail4);
/* 269 */     this.RFrontLeg1.func_78792_a(this.RFrontLeg2);
/* 270 */     this.MouthTop1.func_78792_a(this.MouthTop2);
/* 271 */     this.Chest1.func_78792_a(this.Chest3);
/* 272 */     this.Head1.func_78792_a(this.Lear);
/* 273 */     this.HeadSideL.func_78792_a(this.HeadSideL2);
/* 274 */     this.Base1.func_78792_a(this.Chest1);
/* 275 */     this.Base3.func_78792_a(this.Base4);
/* 276 */     this.Head1.func_78792_a(this.Rear);
/* 277 */     this.Head1.func_78792_a(this.Nose);
/* 278 */     this.Head1.func_78792_a(this.HeadSideR);
/* 279 */     this.Tail5.func_78792_a(this.TailTuft);
/* 280 */     this.HeadSideR.func_78792_a(this.HeadSideR2);
/* 281 */     this.LBackLeg3.func_78792_a(this.LBackLeg4);
/* 282 */     this.MouthBottom1.func_78792_a(this.MouthBottom2);
/* 283 */     this.Head1.func_78792_a(this.MouthBottom1);
/* 284 */     this.Base1.func_78792_a(this.Base2);
/* 285 */     this.LBackLeg1.func_78792_a(this.LBackLeg2);
/* 286 */     this.Tail4.func_78792_a(this.Tail5);
/* 287 */     this.LFrontLeg2.func_78792_a(this.LFrontLeg3);
/* 288 */     this.ThoothR.func_78792_a(this.ThoothR2);
/* 289 */     this.RBackLeg1.func_78792_a(this.RBackLeg2);
/* 290 */     this.Base2.func_78792_a(this.Base3);
/* 291 */     this.LBackLeg2.func_78792_a(this.LBackLeg3);
/* 292 */     this.ThoothL.func_78792_a(this.ThoothL2);
/* 293 */     this.Base4.func_78792_a(this.Base5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 298 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/* 299 */     this.RFrontLeg1.func_78785_a(f5);
/* 300 */     this.LFrontLeg1.func_78785_a(f5);
/* 301 */     this.RBackLeg1.func_78785_a(f5);
/* 302 */     this.LBackLeg1.func_78785_a(f5);
/* 303 */     this.Tail1.func_78785_a(f5);
/* 304 */     this.Head1.func_78785_a(f5);
/* 305 */     this.Base1.func_78785_a(f5);
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
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 321 */     modelRenderer.field_78795_f = x;
/* 322 */     modelRenderer.field_78796_g = y;
/* 323 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 327 */     float r = 360.0F;
/* 328 */     float r2 = 180.0F;
/* 329 */     float n4 = par4;
/* 330 */     float n5 = par5;
/* 331 */     this.Head1.field_78796_g = n4 / r2 / 3.1415927F;
/* 332 */     this.Head1.field_78795_f = n5 / r2 / 3.1415927F;
/*     */     
/* 334 */     this.RFrontLeg1.field_78795_f = 0.1F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 335 */     this.LFrontLeg1.field_78795_f = 0.1F - MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/*     */     
/* 337 */     this.LBackLeg1.field_78795_f = -0.6F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 338 */     this.RBackLeg1.field_78795_f = -0.6F - MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/*     */     
/* 340 */     float ex = par7Entity.field_70173_aa;
/* 341 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 342 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/* 343 */     this.Tail1.field_78796_g = 0.2F;
/* 344 */     this.Tail1.field_78796_g += r4;
/*     */     
/* 346 */     this.Tail2.field_78796_g = 0.2F;
/* 347 */     this.Tail2.field_78796_g += r4;
/*     */     
/* 349 */     this.Tail3.field_78796_g = 0.2F;
/* 350 */     this.Tail3.field_78796_g += r4;
/*     */     
/* 352 */     this.Tail4.field_78796_g = 0.2F;
/* 353 */     this.Tail4.field_78796_g += r4;
/*     */     
/* 355 */     this.Tail5.field_78796_g = 0.2F;
/* 356 */     this.Tail5.field_78796_g += r4;
/*     */     
/* 358 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelSabertooth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */