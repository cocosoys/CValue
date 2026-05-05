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
/*     */ public class ModelZamasu_Fused2
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer ArmR1;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer HairBase;
/*     */   public ModelRenderer earR;
/*     */   public ModelRenderer earL;
/*     */   public ModelRenderer HairR;
/*     */   public ModelRenderer HairL;
/*     */   public ModelRenderer HairB1;
/*     */   public ModelRenderer HairF1;
/*     */   public ModelRenderer HairM1;
/*     */   public ModelRenderer HairB2;
/*     */   public ModelRenderer HairB3;
/*     */   public ModelRenderer HairB4;
/*     */   public ModelRenderer HairF2;
/*     */   public ModelRenderer HairF3;
/*     */   public ModelRenderer HairF4;
/*     */   public ModelRenderer HairF6;
/*     */   public ModelRenderer HairF5;
/*     */   public ModelRenderer HairM2;
/*     */   public ModelRenderer earR2;
/*     */   public ModelRenderer earL2;
/*     */   public ModelRenderer ArmR2;
/*     */   public ModelRenderer ShoulderR;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer ShoulderL;
/*     */   private float F;
/*     */   
/*     */   public ModelZamasu_Fused2() {
/* 183 */     this.F = 1.0F; this.field_78090_t = 64; this.field_78089_u = 64; this.ArmR1 = new ModelRenderer(this, 35, 53); this.ArmR1.func_78793_a(-5.0F, -0.1F, 0.0F); this.ArmR1.func_78790_a(-2.0F, -0.9F, -1.8F, 3, 7, 4, -0.1F); this.HairB3 = new ModelRenderer(this, 47, 26); this.HairB3.func_78793_a(0.0F, 0.0F, 0.0F); this.HairB3.func_78790_a(-2.8F, -7.0F, -0.1F, 5, 3, 3, 0.0F); setRotateAngle(this.HairB3, 0.0F, 0.0F, 0.59184116F); this.LegL = new ModelRenderer(this, 0, 45); this.LegL.field_78809_i = true; this.LegL.func_78793_a(2.1F, 11.0F, 0.0F); this.LegL.func_78790_a(-2.1F, 0.0F, -2.0F, 4, 13, 4, 0.0F); this.Head = new ModelRenderer(this, 0, 0); this.Head.func_78793_a(0.0F, -1.2F, 0.0F); this.Head.func_78790_a(-4.0F, -7.3F, -4.0F, 8, 8, 8, -0.5F); this.ArmL = new ModelRenderer(this, 0, 27); this.ArmL.field_78809_i = true; this.ArmL.func_78793_a(5.0F, -0.1F, 0.0F); this.ArmL.func_78790_a(-1.2F, -0.8F, -1.8F, 3, 12, 4, -0.1F); this.HairB4 = new ModelRenderer(this, 47, 26); this.HairB4.func_78793_a(0.0F, 0.0F, 0.0F); this.HairB4.func_78790_a(-1.9F, -7.3F, -0.1F, 5, 3, 3, 0.0F); setRotateAngle(this.HairB4, 0.0F, 0.0F, -0.3577925F); this.earR = new ModelRenderer(this, 0, 1); this.earR.func_78793_a(-3.2F, -1.9F, -1.5F); this.earR.func_78790_a(-4.2F, -2.1F, 0.0F, 4, 3, 0, 0.0F); setRotateAngle(this.earR, 0.1134464F, 0.5235988F, 0.34906584F); this.Body1 = new ModelRenderer(this, 20, 23); this.Body1.func_78793_a(0.0F, -1.0F, 0.0F); this.Body1.func_78790_a(-4.0F, 0.0F, -1.8F, 8, 7, 4, 0.0F); this.ArmR2 = new ModelRenderer(this, 17, 51); this.ArmR2.func_78793_a(0.0F, 0.0F, 0.0F); this.ArmR2.func_78790_a(-2.7F, 5.9F, -2.4F, 4, 8, 5, 0.0F); this.HairM2 = new ModelRenderer(this, 38, 12); this.HairM2.func_78793_a(0.0F, 0.0F, 0.0F); this.HairM2.func_78790_a(-3.3F, -12.8F, -3.3F, 2, 7, 3, 0.0F); setRotateAngle(this.HairM2, 0.0F, 0.0F, 0.040142573F); this.HairL = new ModelRenderer(this, 49, 13); this.HairL.func_78793_a(0.0F, 0.0F, 0.0F); this.HairL.func_78790_a(1.8F, -11.5F, -3.9F, 2, 7, 5, 0.0F); setRotateAngle(this.HairL, 0.0F, 0.045378562F, 0.07853982F); this.ShoulderL = new ModelRenderer(this, 3, 18); this.ShoulderL.field_78809_i = true; this.ShoulderL.func_78793_a(0.0F, 0.0F, 0.0F); this.ShoulderL.func_78790_a(-1.0F, -0.9F, -1.8F, 6, 4, 4, 0.0F); this.HairF1 = new ModelRenderer(this, 53, 33); this.HairF1.func_78793_a(0.0F, 0.0F, 0.0F); this.HairF1.func_78790_a(-3.3F, -9.8F, -5.4F, 2, 4, 3, 0.0F); setRotateAngle(this.HairF1, 0.0F, 0.0F, -0.13665928F); this.HairBase = new ModelRenderer(this, 33, 0); this.HairBase.func_78793_a(0.0F, 0.0F, 0.0F); this.HairBase.func_78790_a(-2.9F, -11.1F, -4.0F, 6, 5, 7, 0.0F); setRotateAngle(this.HairBase, -0.18203785F, 0.0F, 0.0F); this.HairM1 = new ModelRenderer(this, 49, 53); this.HairM1.func_78793_a(0.0F, 0.0F, 0.0F); this.HairM1.func_78790_a(-0.6F, -14.1F, -2.4F, 3, 3, 4, 0.0F); this.HairF2 = new ModelRenderer(this, 53, 33); this.HairF2.func_78793_a(0.0F, 0.0F, 0.0F); this.HairF2.func_78790_a(1.0F, -8.7F, -5.5F, 2, 3, 3, 0.0F); setRotateAngle(this.HairF2, 0.0F, 0.0F, 0.22759093F); this.LegR = new ModelRenderer(this, 0, 45); this.LegR.func_78793_a(-2.1F, 11.0F, 0.0F); this.LegR.func_78790_a(-1.9F, 0.0F, -2.0F, 4, 13, 4, 0.0F); this.ShoulderR = new ModelRenderer(this, 3, 18); this.ShoulderR.func_78793_a(0.0F, 0.0F, 0.0F); this.ShoulderR.func_78790_a(-5.0F, -0.9F, -1.8F, 6, 4, 4, 0.0F); this.Body3 = new ModelRenderer(this, 20, 43); this.Body3.func_78793_a(0.0F, 0.0F, 0.0F); this.Body3.func_78790_a(-4.0F, 9.0F, -2.0F, 8, 3, 4, 0.0F); this.HairF5 = new ModelRenderer(this, 56, 46); this.HairF5.func_78793_a(0.0F, 0.0F, 0.0F); this.HairF5.func_78790_a(-4.0F, -7.1F, -6.1F, 2, 5, 1, 0.0F); setRotateAngle(this.HairF5, 0.27314404F, 0.0F, 0.0F); this.earL2 = new ModelRenderer(this, 30, 1); this.earL2.field_78809_i = true; this.earL2.func_78793_a(0.3F, 1.2F, 0.0F); this.earL2.func_78790_a(-0.5F, -0.4F, -0.5F, 1, 1, 1, 0.0F); setRotateAngle(this.earL2, 0.0F, 0.34906584F, 0.34906584F); this.HairF6 = new ModelRenderer(this, 56, 46); this.HairF6.func_78793_a(0.0F, 0.0F, 0.0F); this.HairF6.func_78790_a(1.5F, -7.3F, -6.1F, 2, 3, 1, 0.0F); setRotateAngle(this.HairF6, 0.14137167F, 0.0F, 0.0F); this.Body2 = new ModelRenderer(this, 23, 36); this.Body2.func_78793_a(0.0F, 0.0F, 0.0F); this.Body2.func_78790_a(-3.5F, 7.0F, -1.7F, 7, 2, 3, 0.0F); this.HairB2 = new ModelRenderer(this, 38, 12); this.HairB2.func_78793_a(0.0F, 0.0F, 0.0F); this.HairB2.func_78790_a(1.5F, -12.2F, -0.4F, 2, 7, 3, 0.0F); setRotateAngle(this.HairB2, 0.0F, 0.0F, 0.2268928F); this.HairR = new ModelRenderer(this, 49, 13); this.HairR.func_78793_a(0.0F, 0.0F, 0.0F); this.HairR.func_78790_a(-3.7F, -11.4F, -3.3F, 2, 7, 5, 0.0F); setRotateAngle(this.HairR, 0.0F, -0.045378562F, -0.08028515F); this.earR2 = new ModelRenderer(this, 30, 1); this.earR2.func_78793_a(-0.5F, 1.2F, 0.0F); this.earR2.func_78790_a(-0.4F, -0.4F, -0.5F, 1, 1, 1, 0.0F); setRotateAngle(this.earR2, 0.0F, -0.34906584F, -0.34906584F); this.earL = new ModelRenderer(this, 0, 4); this.earL.func_78793_a(3.2F, -1.9F, -1.5F); this.earL.func_78790_a(0.2F, -2.1F, 0.0F, 4, 3, 0, 0.0F); setRotateAngle(this.earL, 0.1134464F, -0.5235988F, -0.34906584F); this.HairF4 = new ModelRenderer(this, 55, 41); this.HairF4.func_78793_a(0.0F, 0.0F, 0.0F); this.HairF4.func_78790_a(-3.3F, -6.2F, -6.9F, 2, 2, 2, 0.0F); setRotateAngle(this.HairF4, -0.17453292F, 0.0F, 0.31869712F); this.HairB1 = new ModelRenderer(this, 38, 12); this.HairB1.func_78793_a(0.0F, 0.0F, 0.0F); this.HairB1.func_78790_a(-2.8F, -12.3F, -0.3F, 2, 7, 3, 0.0F); setRotateAngle(this.HairB1, 0.0F, 0.0F, -0.13665928F); this.HairF3 = new ModelRenderer(this, 55, 41); this.HairF3.func_78793_a(0.0F, 0.0F, 0.0F); this.HairF3.func_78790_a(0.8F, -7.3F, -6.2F, 2, 2, 2, 0.0F); this.HairB1.func_78792_a(this.HairB3); this.HairB1.func_78792_a(this.HairB4); this.Head.func_78792_a(this.earR); this.ArmR1.func_78792_a(this.ArmR2); this.HairM1.func_78792_a(this.HairM2); this.HairBase.func_78792_a(this.HairL); this.ArmL.func_78792_a(this.ShoulderL); this.HairBase.func_78792_a(this.HairF1); this.Head.func_78792_a(this.HairBase); this.HairBase.func_78792_a(this.HairM1); this.HairF1.func_78792_a(this.HairF2); this.ArmR1.func_78792_a(this.ShoulderR); this.Body2.func_78792_a(this.Body3); this.HairF4.func_78792_a(this.HairF5); this.earL.func_78792_a(this.earL2); this.HairF3.func_78792_a(this.HairF6); this.Body1.func_78792_a(this.Body2); this.HairB1.func_78792_a(this.HairB2); this.HairBase.func_78792_a(this.HairR); this.earR.func_78792_a(this.earR2); this.Head.func_78792_a(this.earL); this.HairF1.func_78792_a(this.HairF4); this.HairBase.func_78792_a(this.HairB1); this.HairF1.func_78792_a(this.HairF3); } public ModelZamasu_Fused2(float f) { this.F = 1.0F;
/*     */ 
/*     */     
/* 186 */     this.field_78090_t = 64;
/* 187 */     this.field_78089_u = 64;
/* 188 */     this.ArmR1 = new ModelRenderer(this, 35, 53);
/* 189 */     this.ArmR1.func_78793_a(-5.0F, -0.1F, 0.0F);
/* 190 */     this.ArmR1.func_78790_a(-2.0F, -0.9F, -1.8F, 3, 7, 4, -0.1F);
/* 191 */     this.HairB3 = new ModelRenderer(this, 47, 26);
/* 192 */     this.HairB3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 193 */     this.HairB3.func_78790_a(-2.8F, -7.0F, -0.1F, 5, 3, 3, 0.0F);
/* 194 */     setRotateAngle(this.HairB3, 0.0F, 0.0F, 0.59184116F);
/* 195 */     this.LegL = new ModelRenderer(this, 0, 45);
/* 196 */     this.LegL.field_78809_i = true;
/* 197 */     this.LegL.func_78793_a(2.1F, 11.0F, 0.0F);
/* 198 */     this.LegL.func_78790_a(-2.1F, 0.0F, -2.0F, 4, 13, 4, 0.0F);
/* 199 */     this.Head = new ModelRenderer(this, 0, 0);
/* 200 */     this.Head.func_78793_a(0.0F, -1.2F, 0.0F);
/* 201 */     this.Head.func_78790_a(-4.0F, -7.3F, -4.0F, 8, 8, 8, -0.5F);
/* 202 */     this.ArmL = new ModelRenderer(this, 0, 27);
/* 203 */     this.ArmL.field_78809_i = true;
/* 204 */     this.ArmL.func_78793_a(5.0F, -0.1F, 0.0F);
/* 205 */     this.ArmL.func_78790_a(-1.2F, -0.8F, -1.8F, 3, 12, 4, -0.1F);
/* 206 */     this.HairB4 = new ModelRenderer(this, 47, 26);
/* 207 */     this.HairB4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 208 */     this.HairB4.func_78790_a(-1.9F, -7.3F, -0.1F, 5, 3, 3, 0.0F);
/* 209 */     setRotateAngle(this.HairB4, 0.0F, 0.0F, -0.3577925F);
/* 210 */     this.earR = new ModelRenderer(this, 0, 1);
/* 211 */     this.earR.func_78793_a(-3.2F, -1.9F, -1.5F);
/* 212 */     this.earR.func_78790_a(-4.2F, -2.1F, 0.0F, 4, 3, 0, 0.0F);
/* 213 */     setRotateAngle(this.earR, 0.1134464F, 0.5235988F, 0.34906584F);
/* 214 */     this.Body1 = new ModelRenderer(this, 20, 23);
/* 215 */     this.Body1.func_78793_a(0.0F, -1.0F, 0.0F);
/* 216 */     this.Body1.func_78790_a(-4.0F, 0.0F, -1.8F, 8, 7, 4, 0.0F);
/* 217 */     this.ArmR2 = new ModelRenderer(this, 17, 51);
/* 218 */     this.ArmR2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 219 */     this.ArmR2.func_78790_a(-2.7F, 5.9F, -2.4F, 4, 8, 5, 0.0F);
/* 220 */     this.HairM2 = new ModelRenderer(this, 38, 12);
/* 221 */     this.HairM2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 222 */     this.HairM2.func_78790_a(-3.3F, -12.8F, -3.3F, 2, 7, 3, 0.0F);
/* 223 */     setRotateAngle(this.HairM2, 0.0F, 0.0F, 0.040142573F);
/* 224 */     this.HairL = new ModelRenderer(this, 49, 13);
/* 225 */     this.HairL.func_78793_a(0.0F, 0.0F, 0.0F);
/* 226 */     this.HairL.func_78790_a(1.8F, -11.5F, -3.9F, 2, 7, 5, 0.0F);
/* 227 */     setRotateAngle(this.HairL, 0.0F, 0.045378562F, 0.07853982F);
/* 228 */     this.ShoulderL = new ModelRenderer(this, 3, 18);
/* 229 */     this.ShoulderL.field_78809_i = true;
/* 230 */     this.ShoulderL.func_78793_a(0.0F, 0.0F, 0.0F);
/* 231 */     this.ShoulderL.func_78790_a(-1.0F, -0.9F, -1.8F, 6, 4, 4, 0.0F);
/* 232 */     this.HairF1 = new ModelRenderer(this, 53, 33);
/* 233 */     this.HairF1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 234 */     this.HairF1.func_78790_a(-3.3F, -9.8F, -5.4F, 2, 4, 3, 0.0F);
/* 235 */     setRotateAngle(this.HairF1, 0.0F, 0.0F, -0.13665928F);
/* 236 */     this.HairBase = new ModelRenderer(this, 33, 0);
/* 237 */     this.HairBase.func_78793_a(0.0F, 0.0F, 0.0F);
/* 238 */     this.HairBase.func_78790_a(-2.9F, -11.1F, -4.0F, 6, 5, 7, 0.0F);
/* 239 */     setRotateAngle(this.HairBase, -0.18203785F, 0.0F, 0.0F);
/* 240 */     this.HairM1 = new ModelRenderer(this, 49, 53);
/* 241 */     this.HairM1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 242 */     this.HairM1.func_78790_a(-0.6F, -14.1F, -2.4F, 3, 3, 4, 0.0F);
/* 243 */     this.HairF2 = new ModelRenderer(this, 53, 33);
/* 244 */     this.HairF2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 245 */     this.HairF2.func_78790_a(1.0F, -8.7F, -5.5F, 2, 3, 3, 0.0F);
/* 246 */     setRotateAngle(this.HairF2, 0.0F, 0.0F, 0.22759093F);
/* 247 */     this.LegR = new ModelRenderer(this, 0, 45);
/* 248 */     this.LegR.func_78793_a(-2.1F, 11.0F, 0.0F);
/* 249 */     this.LegR.func_78790_a(-1.9F, 0.0F, -2.0F, 4, 13, 4, 0.0F);
/* 250 */     this.ShoulderR = new ModelRenderer(this, 3, 18);
/* 251 */     this.ShoulderR.func_78793_a(0.0F, 0.0F, 0.0F);
/* 252 */     this.ShoulderR.func_78790_a(-5.0F, -0.9F, -1.8F, 6, 4, 4, 0.0F);
/* 253 */     this.Body3 = new ModelRenderer(this, 20, 43);
/* 254 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 255 */     this.Body3.func_78790_a(-4.0F, 9.0F, -2.0F, 8, 3, 4, 0.0F);
/* 256 */     this.HairF5 = new ModelRenderer(this, 56, 46);
/* 257 */     this.HairF5.func_78793_a(0.0F, 0.0F, 0.0F);
/* 258 */     this.HairF5.func_78790_a(-4.0F, -7.1F, -6.1F, 2, 5, 1, 0.0F);
/* 259 */     setRotateAngle(this.HairF5, 0.27314404F, 0.0F, 0.0F);
/* 260 */     this.earL2 = new ModelRenderer(this, 30, 1);
/* 261 */     this.earL2.field_78809_i = true;
/* 262 */     this.earL2.func_78793_a(0.3F, 1.2F, 0.0F);
/* 263 */     this.earL2.func_78790_a(-0.5F, -0.4F, -0.5F, 1, 1, 1, 0.0F);
/* 264 */     setRotateAngle(this.earL2, 0.0F, 0.34906584F, 0.34906584F);
/* 265 */     this.HairF6 = new ModelRenderer(this, 56, 46);
/* 266 */     this.HairF6.func_78793_a(0.0F, 0.0F, 0.0F);
/* 267 */     this.HairF6.func_78790_a(1.5F, -7.3F, -6.1F, 2, 3, 1, 0.0F);
/* 268 */     setRotateAngle(this.HairF6, 0.14137167F, 0.0F, 0.0F);
/* 269 */     this.Body2 = new ModelRenderer(this, 23, 36);
/* 270 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 271 */     this.Body2.func_78790_a(-3.5F, 7.0F, -1.7F, 7, 2, 3, 0.0F);
/* 272 */     this.HairB2 = new ModelRenderer(this, 38, 12);
/* 273 */     this.HairB2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 274 */     this.HairB2.func_78790_a(1.5F, -12.2F, -0.4F, 2, 7, 3, 0.0F);
/* 275 */     setRotateAngle(this.HairB2, 0.0F, 0.0F, 0.2268928F);
/* 276 */     this.HairR = new ModelRenderer(this, 49, 13);
/* 277 */     this.HairR.func_78793_a(0.0F, 0.0F, 0.0F);
/* 278 */     this.HairR.func_78790_a(-3.7F, -11.4F, -3.3F, 2, 7, 5, 0.0F);
/* 279 */     setRotateAngle(this.HairR, 0.0F, -0.045378562F, -0.08028515F);
/* 280 */     this.earR2 = new ModelRenderer(this, 30, 1);
/* 281 */     this.earR2.func_78793_a(-0.5F, 1.2F, 0.0F);
/* 282 */     this.earR2.func_78790_a(-0.4F, -0.4F, -0.5F, 1, 1, 1, 0.0F);
/* 283 */     setRotateAngle(this.earR2, 0.0F, -0.34906584F, -0.34906584F);
/* 284 */     this.earL = new ModelRenderer(this, 0, 4);
/* 285 */     this.earL.func_78793_a(3.2F, -1.9F, -1.5F);
/* 286 */     this.earL.func_78790_a(0.2F, -2.1F, 0.0F, 4, 3, 0, 0.0F);
/* 287 */     setRotateAngle(this.earL, 0.1134464F, -0.5235988F, -0.34906584F);
/* 288 */     this.HairF4 = new ModelRenderer(this, 55, 41);
/* 289 */     this.HairF4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 290 */     this.HairF4.func_78790_a(-3.3F, -6.2F, -6.9F, 2, 2, 2, 0.0F);
/* 291 */     setRotateAngle(this.HairF4, -0.17453292F, 0.0F, 0.31869712F);
/* 292 */     this.HairB1 = new ModelRenderer(this, 38, 12);
/* 293 */     this.HairB1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 294 */     this.HairB1.func_78790_a(-2.8F, -12.3F, -0.3F, 2, 7, 3, 0.0F);
/* 295 */     setRotateAngle(this.HairB1, 0.0F, 0.0F, -0.13665928F);
/* 296 */     this.HairF3 = new ModelRenderer(this, 55, 41);
/* 297 */     this.HairF3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 298 */     this.HairF3.func_78790_a(0.8F, -7.3F, -6.2F, 2, 2, 2, 0.0F);
/* 299 */     this.HairB1.func_78792_a(this.HairB3);
/* 300 */     this.HairB1.func_78792_a(this.HairB4);
/* 301 */     this.Head.func_78792_a(this.earR);
/* 302 */     this.ArmR1.func_78792_a(this.ArmR2);
/* 303 */     this.HairM1.func_78792_a(this.HairM2);
/* 304 */     this.HairBase.func_78792_a(this.HairL);
/* 305 */     this.ArmL.func_78792_a(this.ShoulderL);
/* 306 */     this.HairBase.func_78792_a(this.HairF1);
/* 307 */     this.Head.func_78792_a(this.HairBase);
/* 308 */     this.HairBase.func_78792_a(this.HairM1);
/* 309 */     this.HairF1.func_78792_a(this.HairF2);
/* 310 */     this.ArmR1.func_78792_a(this.ShoulderR);
/* 311 */     this.Body2.func_78792_a(this.Body3);
/* 312 */     this.HairF4.func_78792_a(this.HairF5);
/* 313 */     this.earL.func_78792_a(this.earL2);
/* 314 */     this.HairF3.func_78792_a(this.HairF6);
/* 315 */     this.Body1.func_78792_a(this.Body2);
/* 316 */     this.HairB1.func_78792_a(this.HairB2);
/* 317 */     this.HairBase.func_78792_a(this.HairR);
/* 318 */     this.earR.func_78792_a(this.earR2);
/* 319 */     this.Head.func_78792_a(this.earL);
/* 320 */     this.HairF1.func_78792_a(this.HairF4);
/* 321 */     this.HairBase.func_78792_a(this.HairB1);
/* 322 */     this.HairF1.func_78792_a(this.HairF3); }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 327 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/* 328 */     if (this.F != 1.0F) {
/* 329 */       GL11.glPushMatrix();
/* 330 */       this.F -= 0.1F;
/* 331 */       GL11.glScalef(this.F, this.F, this.F);
/* 332 */       GL11.glTranslatef(0.0F, (this.F - 1.0F) * -0.74F - 0.1F, 0.0F);
/*     */     } 
/*     */     
/* 335 */     this.Head.func_78785_a(f5);
/*     */     
/* 337 */     if (this.F != 1.0F) GL11.glPopMatrix();
/*     */     
/* 339 */     if (this.F != 1.0F) {
/* 340 */       GL11.glPushMatrix();
/* 341 */       this.F += 0.1F;
/* 342 */       GL11.glScalef(this.F * 1.2F, this.F, this.F * 1.2F);
/* 343 */       GL11.glTranslatef(0.0F, (this.F - 1.0F) * -0.74F, 0.0F);
/*     */     } 
/*     */ 
/*     */     
/* 347 */     this.LegL.func_78785_a(f5);
/* 348 */     this.ArmL.func_78785_a(f5);
/* 349 */     this.ArmR1.func_78785_a(f5);
/* 350 */     this.Body1.func_78785_a(f5);
/* 351 */     this.LegR.func_78785_a(f5);
/*     */     
/* 353 */     if (this.F != 1.0F) GL11.glPopMatrix();
/*     */   
/*     */   }
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 358 */     modelRenderer.field_78795_f = x;
/* 359 */     modelRenderer.field_78796_g = y;
/* 360 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 364 */     int calc = par7Entity.field_70173_aa;
/* 365 */     if (calc > 100) calc -= 100; 
/* 366 */     float r = 360.0F;
/* 367 */     float r2 = 180.0F;
/* 368 */     float n4 = par4;
/* 369 */     float n5 = par5;
/*     */     
/* 371 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 372 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 373 */     float ex = par7Entity.field_70173_aa;
/* 374 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 375 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
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
/* 386 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 387 */     this.LegL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 388 */     this.ArmR1.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 389 */     this.ArmL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 390 */     this.LegR.field_78796_g = 0.0F;
/* 391 */     this.LegL.field_78796_g = 0.0F;
/* 392 */     this.ArmR1.field_78796_g = 0.0F;
/* 393 */     this.ArmL.field_78796_g = 0.0F;
/* 394 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelZamasu_Fused2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */