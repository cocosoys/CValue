/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelAngelKorn
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer Neck;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer NeckRing;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer ClothF;
/*     */   public ModelRenderer ClothB;
/*     */   public ModelRenderer ClothF2;
/*     */   public ModelRenderer ClothB2;
/*     */   public ModelRenderer NeckRing_1;
/*     */   public ModelRenderer NeckRing_2;
/*     */   public ModelRenderer NeckRing_3;
/*     */   public ModelRenderer NeckRing_4;
/*     */   public ModelRenderer NeckRing_5;
/*     */   public ModelRenderer NeckRing_6;
/*     */   public ModelRenderer NeckRing_7;
/*     */   public ModelRenderer LegR2;
/*     */   public ModelRenderer LegL2;
/*     */   public ModelRenderer ShoulderR;
/*     */   public ModelRenderer ShoulderL;
/*     */   
/*     */   public ModelAngelKorn() {
/*  37 */     this.field_78090_t = 64;
/*  38 */     this.field_78089_u = 64;
/*  39 */     this.Body2 = new ModelRenderer(this, 23, 31);
/*  40 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  41 */     this.Body2.func_78790_a(-3.5F, 7.0F, -1.5F, 7, 2, 3, 0.0F);
/*  42 */     this.Neck = new ModelRenderer(this, 7, 17);
/*  43 */     this.Neck.func_78793_a(0.0F, 0.0F, 0.0F);
/*  44 */     this.Neck.func_78790_a(-2.0F, -1.1F, -0.8F, 4, 2, 2, 0.0F);
/*  45 */     this.ShoulderR = new ModelRenderer(this, 33, 9);
/*  46 */     this.ShoulderR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  47 */     this.ShoulderR.func_78790_a(-2.8F, -2.4F, -1.7F, 4, 4, 4, 0.0F);
/*  48 */     this.LegR = new ModelRenderer(this, 0, 33);
/*  49 */     this.LegR.func_78793_a(-1.9F, 9.0F, 0.0F);
/*  50 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 15, 4, 0.0F);
/*  51 */     this.NeckRing_3 = new ModelRenderer(this, 0, 56);
/*  52 */     this.NeckRing_3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  53 */     this.NeckRing_3.func_78790_a(-8.7F, -1.5F, -3.2F, 2, 1, 7, 0.0F);
/*  54 */     setRotateAngle(this.NeckRing_3, 0.0F, -0.8290314F, 0.0F);
/*  55 */     this.ClothF2 = new ModelRenderer(this, 33, 46);
/*  56 */     this.ClothF2.func_78793_a(0.0F, 5.0F, 0.0F);
/*  57 */     this.ClothF2.func_78790_a(-2.5F, 0.0F, 0.0F, 5, 11, 0, 0.0F);
/*  58 */     setRotateAngle(this.ClothF2, 0.04712389F, 0.0F, 0.0F);
/*  59 */     this.LegR2 = new ModelRenderer(this, 17, 47);
/*  60 */     this.LegR2.field_78809_i = true;
/*  61 */     this.LegR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  62 */     this.LegR2.func_78790_a(-2.0F, 13.1F, -4.0F, 4, 2, 2, 0.0F);
/*  63 */     this.Body1 = new ModelRenderer(this, 20, 18);
/*  64 */     this.Body1.func_78793_a(0.0F, -3.0F, 0.0F);
/*  65 */     this.Body1.func_78790_a(-4.0F, 0.0F, -1.8F, 8, 7, 4, 0.0F);
/*  66 */     this.ClothB = new ModelRenderer(this, 44, 46);
/*  67 */     this.ClothB.func_78793_a(0.0F, 7.0F, 2.2F);
/*  68 */     this.ClothB.func_78790_a(-2.5F, 0.0F, 0.0F, 5, 5, 0, 0.0F);
/*  69 */     setRotateAngle(this.ClothB, 0.054105207F, 0.0F, 0.0F);
/*  70 */     this.NeckRing_1 = new ModelRenderer(this, 0, 56);
/*  71 */     this.NeckRing_1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  72 */     this.NeckRing_1.func_78790_a(-9.7F, -1.5F, -2.9F, 2, 1, 7, 0.0F);
/*  73 */     setRotateAngle(this.NeckRing_1, 0.0F, 0.8342674F, 0.0F);
/*  74 */     this.NeckRing_6 = new ModelRenderer(this, 19, 54);
/*  75 */     this.NeckRing_6.func_78793_a(0.0F, 0.0F, 0.0F);
/*  76 */     this.NeckRing_6.func_78790_a(-8.3F, -1.5F, -5.5F, 2, 1, 9, 0.0F);
/*  77 */     setRotateAngle(this.NeckRing_6, 0.0F, -0.7696902F, 0.0F);
/*  78 */     this.NeckRing_4 = new ModelRenderer(this, 0, 56);
/*  79 */     this.NeckRing_4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  80 */     this.NeckRing_4.func_78790_a(-8.5F, -1.5F, -3.3F, 2, 1, 7, 0.0F);
/*  81 */     setRotateAngle(this.NeckRing_4, 0.0F, -0.7382743F, 0.0F);
/*  82 */     this.NeckRing_2 = new ModelRenderer(this, 19, 54);
/*  83 */     this.NeckRing_2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  84 */     this.NeckRing_2.func_78790_a(-8.7F, -1.5F, -3.9F, 2, 1, 9, 0.0F);
/*  85 */     setRotateAngle(this.NeckRing_2, 0.0F, -0.82833326F, 0.0F);
/*  86 */     this.NeckRing_5 = new ModelRenderer(this, 0, 56);
/*  87 */     this.NeckRing_5.func_78793_a(0.0F, 0.0F, 0.0F);
/*  88 */     this.NeckRing_5.func_78790_a(-8.3F, -1.5F, -3.3F, 2, 1, 7, 0.0F);
/*  89 */     setRotateAngle(this.NeckRing_5, 0.0F, -0.7841764F, 0.0F);
/*  90 */     this.ArmR = new ModelRenderer(this, 50, 16);
/*  91 */     this.ArmR.func_78793_a(-5.0F, -1.2F, 0.0F);
/*  92 */     this.ArmR.func_78790_a(-2.0F, -1.5F, -1.8F, 3, 13, 4, 0.0F);
/*  93 */     this.NeckRing = new ModelRenderer(this, 0, 53);
/*  94 */     this.NeckRing.func_78793_a(0.0F, -1.0F, 0.0F);
/*  95 */     this.NeckRing.func_78790_a(-3.5F, -1.5F, 7.9F, 7, 1, 2, 0.0F);
/*  96 */     setRotateAngle(this.NeckRing, 0.53249997F, 0.0F, 0.0F);
/*  97 */     this.ArmL = new ModelRenderer(this, 50, 16);
/*  98 */     this.ArmL.field_78809_i = true;
/*  99 */     this.ArmL.func_78793_a(5.0F, -1.2F, 0.0F);
/* 100 */     this.ArmL.func_78790_a(-1.0F, -1.5F, -1.8F, 3, 13, 4, 0.0F);
/* 101 */     this.LegL2 = new ModelRenderer(this, 17, 47);
/* 102 */     this.LegL2.field_78809_i = true;
/* 103 */     this.LegL2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 104 */     this.LegL2.func_78790_a(-2.0F, 13.1F, -4.0F, 4, 2, 2, 0.0F);
/* 105 */     this.Body3 = new ModelRenderer(this, 20, 37);
/* 106 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 107 */     this.Body3.func_78790_a(-4.0F, 9.0F, -2.0F, 8, 3, 4, 0.0F);
/* 108 */     this.ClothB2 = new ModelRenderer(this, 33, 46);
/* 109 */     this.ClothB2.func_78793_a(0.0F, 5.0F, 0.0F);
/* 110 */     this.ClothB2.func_78790_a(-2.5F, 0.0F, 0.0F, 5, 11, 0, 0.0F);
/* 111 */     setRotateAngle(this.ClothB2, -0.006981317F, 0.0F, 0.0F);
/* 112 */     this.NeckRing_7 = new ModelRenderer(this, 0, 56);
/* 113 */     this.NeckRing_7.func_78793_a(0.0F, 0.0F, 0.0F);
/* 114 */     this.NeckRing_7.func_78790_a(-9.6F, -1.5F, -4.2F, 2, 1, 7, 0.0F);
/* 115 */     setRotateAngle(this.NeckRing_7, 0.0F, -0.8609709F, 0.0F);
/* 116 */     this.ClothF = new ModelRenderer(this, 44, 46);
/* 117 */     this.ClothF.func_78793_a(0.0F, 6.9F, -1.8F);
/* 118 */     this.ClothF.func_78790_a(-2.5F, 0.0F, 0.0F, 5, 5, 0, 0.0F);
/* 119 */     setRotateAngle(this.ClothF, -0.09424778F, 0.0F, 0.0F);
/* 120 */     this.ShoulderL = new ModelRenderer(this, 33, 9);
/* 121 */     this.ShoulderL.field_78809_i = true;
/* 122 */     this.ShoulderL.func_78793_a(0.0F, 0.0F, 0.0F);
/* 123 */     this.ShoulderL.func_78790_a(-1.0F, -2.4F, -1.7F, 4, 4, 4, 0.0F);
/* 124 */     this.LegL = new ModelRenderer(this, 0, 33);
/* 125 */     this.LegL.field_78809_i = true;
/* 126 */     this.LegL.func_78793_a(1.9F, 9.0F, 0.0F);
/* 127 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 15, 4, 0.0F);
/* 128 */     this.Head = new ModelRenderer(this, 0, 0);
/* 129 */     this.Head.func_78793_a(0.0F, -4.0F, 0.0F);
/* 130 */     this.Head.func_78790_a(-3.5F, -7.5F, -4.0F, 7, 8, 8, -0.4F);
/* 131 */     this.Body1.func_78792_a(this.Body2);
/* 132 */     this.Body1.func_78792_a(this.Neck);
/* 133 */     this.ArmR.func_78792_a(this.ShoulderR);
/* 134 */     this.NeckRing_2.func_78792_a(this.NeckRing_3);
/* 135 */     this.ClothF.func_78792_a(this.ClothF2);
/* 136 */     this.LegR.func_78792_a(this.LegR2);
/* 137 */     this.Body3.func_78792_a(this.ClothB);
/* 138 */     this.NeckRing.func_78792_a(this.NeckRing_1);
/* 139 */     this.NeckRing_5.func_78792_a(this.NeckRing_6);
/* 140 */     this.NeckRing_3.func_78792_a(this.NeckRing_4);
/* 141 */     this.NeckRing_1.func_78792_a(this.NeckRing_2);
/* 142 */     this.NeckRing_4.func_78792_a(this.NeckRing_5);
/* 143 */     this.Body1.func_78792_a(this.NeckRing);
/* 144 */     this.LegL.func_78792_a(this.LegL2);
/* 145 */     this.Body2.func_78792_a(this.Body3);
/* 146 */     this.ClothB.func_78792_a(this.ClothB2);
/* 147 */     this.NeckRing_6.func_78792_a(this.NeckRing_7);
/* 148 */     this.Body3.func_78792_a(this.ClothF);
/* 149 */     this.ArmL.func_78792_a(this.ShoulderL);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 154 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 157 */     this.LegL.func_78785_a(f5);
/* 158 */     this.Head.func_78785_a(f5);
/* 159 */     this.ArmL.func_78785_a(f5);
/* 160 */     this.ArmR.func_78785_a(f5);
/* 161 */     this.Body1.func_78785_a(f5);
/* 162 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 167 */     modelRenderer.field_78795_f = x;
/* 168 */     modelRenderer.field_78796_g = y;
/* 169 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 173 */     int calc = par7Entity.field_70173_aa;
/* 174 */     if (calc > 100) calc -= 100; 
/* 175 */     float r = 360.0F;
/* 176 */     float r2 = 180.0F;
/* 177 */     float n4 = par4;
/* 178 */     float n5 = par5;
/*     */     
/* 180 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 181 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 182 */     float ex = par7Entity.field_70173_aa;
/* 183 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 184 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 186 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 187 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 229 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 230 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 231 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 232 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 234 */     this.LegR.field_78796_g = 0.0F;
/* 235 */     this.LegL.field_78796_g = 0.0F;
/* 236 */     this.ArmR.field_78796_g = 0.0F;
/* 237 */     this.ArmL.field_78796_g = 0.0F;
/*     */ 
/*     */     
/* 240 */     this.ClothF.field_78795_f = -0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 241 */     this.ClothF2.field_78795_f = -0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 242 */     this.ClothB.field_78795_f = 0.15F + this.LegL.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 243 */     this.ClothB2.field_78795_f = 0.15F + this.LegL.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 244 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelAngelKorn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */