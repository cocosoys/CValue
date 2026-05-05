/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelAngelMartinu
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer NeckRing;
/*     */   public ModelRenderer Hair1;
/*     */   public ModelRenderer Hair2;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Boobs;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer ClothF;
/*     */   public ModelRenderer ClothB;
/*     */   public ModelRenderer ShoulderR;
/*     */   public ModelRenderer ShoulderL;
/*     */   public ModelRenderer LegR2;
/*     */   public ModelRenderer LegR3;
/*     */   public ModelRenderer LegL2;
/*     */   public ModelRenderer LegL3;
/*     */   public ModelRenderer NeckRing_1;
/*     */   public ModelRenderer NeckRing_2;
/*     */   public ModelRenderer NeckRing_3;
/*     */   public ModelRenderer NeckRing_4;
/*     */   public ModelRenderer NeckRing_5;
/*     */   public ModelRenderer NeckRing_6;
/*     */   public ModelRenderer NeckRing_7;
/*     */   
/*     */   public ModelAngelMartinu() {
/*  39 */     this.field_78090_t = 128;
/*  40 */     this.field_78089_u = 64;
/*  41 */     this.NeckRing_3 = new ModelRenderer(this, 0, 56);
/*  42 */     this.NeckRing_3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  43 */     this.NeckRing_3.func_78790_a(-8.7F, -2.5F, -3.2F, 2, 1, 7, 0.0F);
/*  44 */     setRotateAngle(this.NeckRing_3, 0.0F, -0.8290314F, 0.0F);
/*  45 */     this.Head = new ModelRenderer(this, 0, 0);
/*  46 */     this.Head.func_78793_a(0.0F, -0.8F, 0.0F);
/*  47 */     this.Head.func_78790_a(-4.0F, -6.7F, -4.0F, 8, 7, 8, -0.4F);
/*  48 */     this.Hair1 = new ModelRenderer(this, 30, 0);
/*  49 */     this.Hair1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  50 */     this.Hair1.func_78790_a(-4.0F, -3.3F, 2.5F, 8, 2, 2, 0.0F);
/*  51 */     this.LegL2 = new ModelRenderer(this, 0, 23);
/*  52 */     this.LegL2.field_78809_i = true;
/*  53 */     this.LegL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  54 */     this.LegL2.func_78790_a(-2.4F, 0.1F, -4.2F, 6, 8, 8, 0.0F);
/*  55 */     this.Body1 = new ModelRenderer(this, 32, 9);
/*  56 */     this.Body1.func_78793_a(0.0F, -1.0F, 0.0F);
/*  57 */     this.Body1.func_78790_a(-5.0F, 0.1F, -3.7F, 10, 5, 7, 0.0F);
/*  58 */     this.NeckRing_4 = new ModelRenderer(this, 0, 56);
/*  59 */     this.NeckRing_4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  60 */     this.NeckRing_4.func_78790_a(-8.5F, -2.5F, -3.3F, 2, 1, 7, 0.0F);
/*  61 */     setRotateAngle(this.NeckRing_4, 0.0F, -0.7382743F, 0.0F);
/*  62 */     this.LegR2 = new ModelRenderer(this, 0, 23);
/*  63 */     this.LegR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  64 */     this.LegR2.func_78790_a(-3.3F, 0.1F, -4.2F, 6, 8, 8, 0.0F);
/*  65 */     this.ArmL = new ModelRenderer(this, 82, 21);
/*  66 */     this.ArmL.field_78809_i = true;
/*  67 */     this.ArmL.func_78793_a(6.2F, 1.3F, -0.2F);
/*  68 */     this.ArmL.func_78790_a(-0.9F, -1.7F, -1.8F, 3, 11, 4, 0.0F);
/*  69 */     this.Hair2 = new ModelRenderer(this, 52, 0);
/*  70 */     this.Hair2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  71 */     this.Hair2.func_78790_a(-3.5F, -5.2F, 1.8F, 7, 2, 3, 0.0F);
/*  72 */     this.LegR = new ModelRenderer(this, 0, 42);
/*  73 */     this.LegR.func_78793_a(-2.6F, 12.0F, 0.0F);
/*  74 */     this.LegR.func_78790_a(-1.5F, 6.0F, -2.0F, 3, 6, 4, 0.0F);
/*  75 */     this.Body3 = new ModelRenderer(this, 29, 36);
/*  76 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  77 */     this.Body3.func_78790_a(-5.9F, 10.1F, -4.2F, 12, 3, 8, 0.0F);
/*  78 */     this.NeckRing_1 = new ModelRenderer(this, 0, 56);
/*  79 */     this.NeckRing_1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  80 */     this.NeckRing_1.func_78790_a(-9.7F, -2.5F, -2.9F, 2, 1, 7, 0.0F);
/*  81 */     setRotateAngle(this.NeckRing_1, 0.0F, 0.8342674F, 0.0F);
/*  82 */     this.LegL = new ModelRenderer(this, 0, 42);
/*  83 */     this.LegL.field_78809_i = true;
/*  84 */     this.LegL.func_78793_a(2.4F, 12.0F, 0.0F);
/*  85 */     this.LegL.func_78790_a(-1.3F, 6.0F, -2.0F, 3, 6, 4, 0.0F);
/*  86 */     this.ShoulderR = new ModelRenderer(this, 81, 12);
/*  87 */     this.ShoulderR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  88 */     this.ShoulderR.func_78790_a(-2.8F, -2.5F, -1.7F, 4, 4, 4, 0.0F);
/*  89 */     this.NeckRing_7 = new ModelRenderer(this, 0, 56);
/*  90 */     this.NeckRing_7.func_78793_a(0.0F, 0.0F, 0.0F);
/*  91 */     this.NeckRing_7.func_78790_a(-9.6F, -2.5F, -4.2F, 2, 1, 7, 0.0F);
/*  92 */     setRotateAngle(this.NeckRing_7, 0.0F, -0.8609709F, 0.0F);
/*  93 */     this.ClothB = new ModelRenderer(this, 52, 51);
/*  94 */     this.ClothB.func_78793_a(0.0F, 10.5F, 3.2F);
/*  95 */     this.ClothB.func_78790_a(-3.5F, -0.3F, 0.7F, 7, 11, 0, 0.0F);
/*  96 */     setRotateAngle(this.ClothB, 0.11868239F, 0.0F, 0.0F);
/*  97 */     this.NeckRing_6 = new ModelRenderer(this, 19, 54);
/*  98 */     this.NeckRing_6.func_78793_a(0.0F, 0.0F, 0.0F);
/*  99 */     this.NeckRing_6.func_78790_a(-8.3F, -2.5F, -5.5F, 2, 1, 9, 0.0F);
/* 100 */     setRotateAngle(this.NeckRing_6, 0.0F, -0.7696902F, 0.0F);
/* 101 */     this.NeckRing_2 = new ModelRenderer(this, 19, 54);
/* 102 */     this.NeckRing_2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 103 */     this.NeckRing_2.func_78790_a(-8.7F, -2.5F, -3.9F, 2, 1, 9, 0.0F);
/* 104 */     setRotateAngle(this.NeckRing_2, 0.0F, -0.82833326F, 0.0F);
/* 105 */     this.ClothF = new ModelRenderer(this, 36, 51);
/* 106 */     this.ClothF.func_78793_a(0.0F, 10.3F, -3.8F);
/* 107 */     this.ClothF.func_78790_a(-3.5F, -0.1F, -0.5F, 7, 11, 0, 0.0F);
/* 108 */     setRotateAngle(this.ClothF, -0.11868239F, 0.0F, 0.0F);
/* 109 */     this.NeckRing = new ModelRenderer(this, 0, 53);
/* 110 */     this.NeckRing.func_78793_a(0.0F, 0.0F, 0.0F);
/* 111 */     this.NeckRing.func_78790_a(-3.5F, -2.5F, 7.9F, 7, 1, 2, 0.0F);
/* 112 */     setRotateAngle(this.NeckRing, 0.44348815F, 0.0F, 0.0F);
/* 113 */     this.LegR3 = new ModelRenderer(this, 17, 41);
/* 114 */     this.LegR3.field_78809_i = true;
/* 115 */     this.LegR3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 116 */     this.LegR3.func_78790_a(-1.5F, 10.0F, -4.0F, 3, 2, 2, 0.0F);
/* 117 */     this.Body2 = new ModelRenderer(this, 30, 22);
/* 118 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 119 */     this.Body2.func_78790_a(-5.5F, 5.1F, -3.9F, 11, 5, 7, 0.0F);
/* 120 */     this.ArmR = new ModelRenderer(this, 82, 21);
/* 121 */     this.ArmR.func_78793_a(-6.2F, 1.3F, -0.2F);
/* 122 */     this.ArmR.func_78790_a(-2.1F, -1.7F, -1.8F, 3, 11, 4, 0.0F);
/* 123 */     this.ShoulderL = new ModelRenderer(this, 81, 12);
/* 124 */     this.ShoulderL.field_78809_i = true;
/* 125 */     this.ShoulderL.func_78793_a(0.0F, 0.0F, 0.0F);
/* 126 */     this.ShoulderL.func_78790_a(-1.2F, -2.5F, -1.9F, 4, 4, 4, 0.0F);
/* 127 */     this.LegL3 = new ModelRenderer(this, 17, 41);
/* 128 */     this.LegL3.field_78809_i = true;
/* 129 */     this.LegL3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 130 */     this.LegL3.func_78790_a(-1.3F, 10.0F, -4.0F, 3, 2, 2, 0.0F);
/* 131 */     this.NeckRing_5 = new ModelRenderer(this, 0, 56);
/* 132 */     this.NeckRing_5.func_78793_a(0.0F, 0.0F, 0.0F);
/* 133 */     this.NeckRing_5.func_78790_a(-8.3F, -2.5F, -3.3F, 2, 1, 7, 0.0F);
/* 134 */     setRotateAngle(this.NeckRing_5, 0.0F, -0.7841764F, 0.0F);
/* 135 */     this.Boobs = new ModelRenderer(this, 4, 16);
/* 136 */     this.Boobs.func_78793_a(0.0F, 0.0F, 0.0F);
/* 137 */     this.Boobs.func_78790_a(-4.5F, 3.7F, -1.1F, 9, 3, 3, 0.0F);
/* 138 */     setRotateAngle(this.Boobs, -0.8651597F, 0.0F, 0.0F);
/* 139 */     this.NeckRing_2.func_78792_a(this.NeckRing_3);
/* 140 */     this.Head.func_78792_a(this.Hair1);
/* 141 */     this.LegL.func_78792_a(this.LegL2);
/* 142 */     this.NeckRing_3.func_78792_a(this.NeckRing_4);
/* 143 */     this.LegR.func_78792_a(this.LegR2);
/* 144 */     this.Hair1.func_78792_a(this.Hair2);
/* 145 */     this.Body2.func_78792_a(this.Body3);
/* 146 */     this.NeckRing.func_78792_a(this.NeckRing_1);
/* 147 */     this.ArmR.func_78792_a(this.ShoulderR);
/* 148 */     this.NeckRing_6.func_78792_a(this.NeckRing_7);
/* 149 */     this.Body3.func_78792_a(this.ClothB);
/* 150 */     this.NeckRing_5.func_78792_a(this.NeckRing_6);
/* 151 */     this.NeckRing_1.func_78792_a(this.NeckRing_2);
/* 152 */     this.Body3.func_78792_a(this.ClothF);
/* 153 */     this.LegR.func_78792_a(this.LegR3);
/* 154 */     this.Body1.func_78792_a(this.Body2);
/* 155 */     this.ArmL.func_78792_a(this.ShoulderL);
/* 156 */     this.LegL.func_78792_a(this.LegL3);
/* 157 */     this.NeckRing_4.func_78792_a(this.NeckRing_5);
/* 158 */     this.Body1.func_78792_a(this.Boobs);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 163 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 166 */     this.LegL.func_78785_a(f5);
/* 167 */     this.Head.func_78785_a(f5);
/* 168 */     this.ArmL.func_78785_a(f5);
/* 169 */     this.ArmR.func_78785_a(f5);
/* 170 */     this.Body1.func_78785_a(f5);
/* 171 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 176 */     modelRenderer.field_78795_f = x;
/* 177 */     modelRenderer.field_78796_g = y;
/* 178 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 182 */     int calc = par7Entity.field_70173_aa;
/* 183 */     if (calc > 100) calc -= 100; 
/* 184 */     float r = 360.0F;
/* 185 */     float r2 = 180.0F;
/* 186 */     float n4 = par4;
/* 187 */     float n5 = par5;
/*     */     
/* 189 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 190 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 191 */     float ex = par7Entity.field_70173_aa;
/* 192 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 193 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 195 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 196 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 238 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 239 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 240 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 241 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 243 */     this.LegR.field_78796_g = 0.0F;
/* 244 */     this.LegL.field_78796_g = 0.0F;
/* 245 */     this.ArmR.field_78796_g = 0.0F;
/* 246 */     this.ArmL.field_78796_g = 0.0F;
/*     */ 
/*     */     
/* 249 */     this.ClothF.field_78795_f = -0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/*     */     
/* 251 */     this.ClothB.field_78795_f = 0.15F + this.LegL.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/*     */     
/* 253 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelAngelMartinu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */