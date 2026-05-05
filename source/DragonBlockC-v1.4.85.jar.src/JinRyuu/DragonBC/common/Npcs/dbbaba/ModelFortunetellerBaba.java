/*     */ package JinRyuu.DragonBC.common.Npcs.dbbaba;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelFortunetellerBaba
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer Base1;
/*     */   public ModelRenderer Hat1;
/*     */   public ModelRenderer Hair;
/*     */   public ModelRenderer Hat2;
/*     */   public ModelRenderer Hat3;
/*     */   public ModelRenderer Hat4;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer BodyR;
/*     */   public ModelRenderer BodyL;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer ArmL1;
/*     */   public ModelRenderer ArmL2;
/*     */   public ModelRenderer ArmL3;
/*     */   public ModelRenderer ArmR1;
/*     */   public ModelRenderer ArmR2;
/*     */   public ModelRenderer ArmR3;
/*     */   public ModelRenderer Base1Front;
/*     */   public ModelRenderer Base1Back;
/*     */   public ModelRenderer Base1Side_Ball;
/*     */   public ModelRenderer Base1Side_Jobb;
/*     */   public ModelRenderer Base1Top;
/*     */   public ModelRenderer Base1Bottom;
/*     */   public ModelRenderer Base1Front2;
/*     */   public ModelRenderer Base1Back2;
/*     */   public ModelRenderer Base1Side_Ball2;
/*     */   public ModelRenderer Base1Side_Jobb2;
/*     */   public ModelRenderer Base1Bottom2;
/*     */   
/*     */   public ModelFortunetellerBaba() {
/*  44 */     this.field_78090_t = 128;
/*  45 */     this.field_78089_u = 64;
/*  46 */     this.Hat3 = new ModelRenderer(this, 26, 57);
/*  47 */     this.Hat3.func_78793_a(0.0F, -2.5F, 0.4F);
/*  48 */     this.Hat3.func_78790_a(-1.5F, -1.5F, -1.6F, 3, 3, 3, 0.0F);
/*  49 */     setRotateAngle(this.Hat3, -0.13665928F, 0.0F, 0.0F);
/*  50 */     this.ArmL1 = new ModelRenderer(this, 46, 30);
/*  51 */     this.ArmL1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  52 */     this.ArmL1.func_78790_a(-0.5F, 0.0F, -1.6F, 2, 4, 3, 0.0F);
/*  53 */     setRotateAngle(this.ArmL1, -0.59184116F, 0.091106184F, 0.0F);
/*  54 */     this.Base1Back = new ModelRenderer(this, 111, 17);
/*  55 */     this.Base1Back.func_78793_a(0.0F, 0.0F, 0.0F);
/*  56 */     this.Base1Back.func_78790_a(3.0F, -3.0F, -3.0F, 2, 6, 6, 0.0F);
/*  57 */     this.Hat1 = new ModelRenderer(this, 49, 50);
/*  58 */     this.Hat1.func_78793_a(0.0F, -4.0F, 0.0F);
/*  59 */     this.Hat1.func_78790_a(-9.0F, 0.0F, -7.0F, 18, 0, 14, 0.0F);
/*  60 */     this.Base1Side_Jobb = new ModelRenderer(this, 81, 20);
/*  61 */     this.Base1Side_Jobb.func_78793_a(0.0F, 0.0F, 0.0F);
/*  62 */     this.Base1Side_Jobb.func_78790_a(-3.0F, -3.0F, 3.0F, 6, 6, 2, 0.0F);
/*  63 */     this.Base1Top = new ModelRenderer(this, 103, 30);
/*  64 */     this.Base1Top.func_78793_a(0.0F, 0.0F, 0.0F);
/*  65 */     this.Base1Top.func_78790_a(-3.0F, -5.0F, -3.0F, 6, 2, 6, 0.0F);
/*  66 */     this.Base1Front = new ModelRenderer(this, 111, 17);
/*  67 */     this.Base1Front.func_78793_a(0.0F, 0.0F, 0.0F);
/*  68 */     this.Base1Front.func_78790_a(-5.0F, -3.0F, -3.0F, 2, 6, 6, 0.0F);
/*  69 */     this.Base1 = new ModelRenderer(this, 96, 0);
/*  70 */     this.Base1.func_78793_a(0.0F, 9.4F, 0.0F);
/*  71 */     this.Base1.func_78790_a(-4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F);
/*  72 */     this.BodyR = new ModelRenderer(this, 0, 41);
/*  73 */     this.BodyR.func_78793_a(-2.6F, 4.7F, -0.4F);
/*  74 */     this.BodyR.func_78790_a(-2.5F, -1.5F, -1.5F, 5, 3, 4, 0.0F);
/*  75 */     setRotateAngle(this.BodyR, 0.27314404F, 0.0F, -0.18325958F);
/*  76 */     this.Body3 = new ModelRenderer(this, 31, 19);
/*  77 */     this.Body3.func_78793_a(0.0F, 2.7F, 3.2F);
/*  78 */     this.Body3.func_78790_a(-3.5F, -1.9F, -1.6F, 7, 3, 4, 0.0F);
/*  79 */     setRotateAngle(this.Body3, -0.95609134F, 0.0F, 0.0F);
/*  80 */     this.Base1Side_Ball2 = new ModelRenderer(this, 81, 29);
/*  81 */     this.Base1Side_Ball2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  82 */     this.Base1Side_Ball2.func_78790_a(-2.0F, -2.0F, -5.5F, 4, 4, 2, 0.0F);
/*  83 */     this.ArmR = new ModelRenderer(this, 0, 0);
/*  84 */     this.ArmR.func_78793_a(-3.5F, -0.5F, 0.0F);
/*  85 */     this.ArmR.func_78790_a(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
/*  86 */     this.Base1Side_Jobb2 = new ModelRenderer(this, 81, 29);
/*  87 */     this.Base1Side_Jobb2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  88 */     this.Base1Side_Jobb2.func_78790_a(-2.0F, -2.0F, 3.5F, 4, 4, 2, 0.0F);
/*  89 */     this.Hair = new ModelRenderer(this, 33, 1);
/*  90 */     this.Hair.func_78793_a(0.0F, 0.0F, 0.0F);
/*  91 */     this.Hair.func_78790_a(-3.5F, -3.99F, -3.5F, 7, 4, 7, 0.0F);
/*  92 */     this.Base1Bottom = new ModelRenderer(this, 103, 30);
/*  93 */     this.Base1Bottom.func_78793_a(0.0F, 0.0F, 0.0F);
/*  94 */     this.Base1Bottom.func_78790_a(-3.0F, 3.0F, -3.0F, 6, 2, 6, 0.0F);
/*  95 */     this.Body = new ModelRenderer(this, 1, 18);
/*  96 */     this.Body.func_78793_a(0.0F, -1.6F, 0.0F);
/*  97 */     this.Body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 3, 5, 0.0F);
/*  98 */     this.Hat4 = new ModelRenderer(this, 16, 58);
/*  99 */     this.Hat4.func_78793_a(0.0F, -2.5F, 0.0F);
/* 100 */     this.Hat4.func_78790_a(-1.0F, -1.5F, -1.0F, 2, 3, 2, 0.0F);
/* 101 */     setRotateAngle(this.Hat4, -0.13665928F, 0.0F, 0.0F);
/* 102 */     this.ArmR3 = new ModelRenderer(this, 47, 47);
/* 103 */     this.ArmR3.func_78793_a(0.0F, 2.9F, 0.0F);
/* 104 */     this.ArmR3.func_78790_a(-0.5F, 0.0F, -1.0F, 1, 1, 2, 0.0F);
/* 105 */     this.Base1Back2 = new ModelRenderer(this, 98, 19);
/* 106 */     this.Base1Back2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 107 */     this.Base1Back2.func_78790_a(3.5F, -2.0F, -2.0F, 2, 4, 4, 0.0F);
/* 108 */     this.Hat2 = new ModelRenderer(this, 40, 55);
/* 109 */     this.Hat2.func_78793_a(0.0F, -2.8F, 0.0F);
/* 110 */     this.Hat2.func_78790_a(-2.2F, -1.5F, -2.1F, 4, 3, 5, 0.0F);
/* 111 */     setRotateAngle(this.Hat2, -0.13665928F, 0.0F, 0.0F);
/* 112 */     this.ArmL2 = new ModelRenderer(this, 46, 39);
/* 113 */     this.ArmL2.func_78793_a(0.3F, 3.1F, -0.6F);
/* 114 */     this.ArmL2.func_78790_a(-1.0F, -0.1F, -1.5F, 2, 3, 3, 0.0F);
/* 115 */     setRotateAngle(this.ArmL2, -0.9599311F, 1.5707964F, 0.34906584F);
/* 116 */     this.ArmR2 = new ModelRenderer(this, 46, 39);
/* 117 */     this.ArmR2.func_78793_a(-0.4F, 3.1F, -0.6F);
/* 118 */     this.ArmR2.func_78790_a(-1.0F, -0.1F, -1.5F, 2, 3, 3, 0.0F);
/* 119 */     setRotateAngle(this.ArmR2, -0.9599311F, -1.5707964F, -0.34906584F);
/* 120 */     this.Base1Front2 = new ModelRenderer(this, 98, 19);
/* 121 */     this.Base1Front2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 122 */     this.Base1Front2.func_78790_a(-5.5F, -2.0F, -2.0F, 2, 4, 4, 0.0F);
/* 123 */     setRotateAngle(this.Base1Front2, 0.0F, -0.008901179F, 0.0F);
/* 124 */     this.Base1Bottom2 = new ModelRenderer(this, 107, 39);
/* 125 */     this.Base1Bottom2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 126 */     this.Base1Bottom2.func_78790_a(-2.0F, 3.5F, -2.0F, 4, 2, 4, 0.0F);
/* 127 */     this.Base1Side_Ball = new ModelRenderer(this, 81, 20);
/* 128 */     this.Base1Side_Ball.func_78793_a(0.0F, 0.0F, 0.0F);
/* 129 */     this.Base1Side_Ball.func_78790_a(-3.0F, -3.0F, -5.0F, 6, 6, 2, 0.0F);
/* 130 */     this.ArmL3 = new ModelRenderer(this, 47, 47);
/* 131 */     this.ArmL3.func_78793_a(0.0F, 2.9F, 0.0F);
/* 132 */     this.ArmL3.func_78790_a(-0.5F, 0.0F, -1.0F, 1, 1, 2, 0.0F);
/* 133 */     this.Body2 = new ModelRenderer(this, 1, 29);
/* 134 */     this.Body2.func_78793_a(0.0F, 2.2F, 0.0F);
/* 135 */     this.Body2.func_78790_a(-4.5F, 0.0F, -2.0F, 9, 4, 6, 0.0F);
/* 136 */     setRotateAngle(this.Body2, -0.22759093F, 0.0F, 0.0F);
/* 137 */     this.BodyL = new ModelRenderer(this, 20, 41);
/* 138 */     this.BodyL.func_78793_a(2.6F, 4.7F, -0.4F);
/* 139 */     this.BodyL.func_78790_a(-2.5F, -1.5F, -1.5F, 5, 3, 4, 0.0F);
/* 140 */     setRotateAngle(this.BodyL, 0.27314404F, 0.0F, 0.18325958F);
/* 141 */     this.ArmL = new ModelRenderer(this, 0, 0);
/* 142 */     this.ArmL.func_78793_a(3.5F, -0.5F, 0.0F);
/* 143 */     this.ArmL.func_78790_a(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
/* 144 */     this.Head = new ModelRenderer(this, 0, 0);
/* 145 */     this.Head.func_78793_a(0.0F, -0.7F, 0.0F);
/* 146 */     this.Head.func_78790_a(-4.0F, -7.2F, -4.0F, 8, 8, 8, -0.8F);
/* 147 */     this.ArmR1 = new ModelRenderer(this, 46, 30);
/* 148 */     this.ArmR1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 149 */     this.ArmR1.func_78790_a(-1.5F, 0.0F, -1.6F, 2, 4, 3, 0.0F);
/* 150 */     setRotateAngle(this.ArmR1, -0.59184116F, -0.091106184F, 0.0F);
/* 151 */     this.Hat2.func_78792_a(this.Hat3);
/* 152 */     this.ArmL.func_78792_a(this.ArmL1);
/* 153 */     this.Base1.func_78792_a(this.Base1Back);
/* 154 */     this.Head.func_78792_a(this.Hat1);
/* 155 */     this.Base1.func_78792_a(this.Base1Side_Jobb);
/* 156 */     this.Base1.func_78792_a(this.Base1Top);
/* 157 */     this.Base1.func_78792_a(this.Base1Front);
/* 158 */     this.Body2.func_78792_a(this.BodyR);
/* 159 */     this.Body2.func_78792_a(this.Body3);
/* 160 */     this.Base1Side_Ball.func_78792_a(this.Base1Side_Ball2);
/* 161 */     this.Base1Side_Jobb.func_78792_a(this.Base1Side_Jobb2);
/* 162 */     this.Head.func_78792_a(this.Hair);
/* 163 */     this.Base1.func_78792_a(this.Base1Bottom);
/* 164 */     this.Hat3.func_78792_a(this.Hat4);
/* 165 */     this.ArmR2.func_78792_a(this.ArmR3);
/* 166 */     this.Base1Back.func_78792_a(this.Base1Back2);
/* 167 */     this.Hat1.func_78792_a(this.Hat2);
/* 168 */     this.ArmL1.func_78792_a(this.ArmL2);
/* 169 */     this.ArmR1.func_78792_a(this.ArmR2);
/* 170 */     this.Base1Front.func_78792_a(this.Base1Front2);
/* 171 */     this.Base1Bottom.func_78792_a(this.Base1Bottom2);
/* 172 */     this.Base1.func_78792_a(this.Base1Side_Ball);
/* 173 */     this.ArmL2.func_78792_a(this.ArmL3);
/* 174 */     this.Body.func_78792_a(this.Body2);
/* 175 */     this.Body2.func_78792_a(this.BodyL);
/* 176 */     this.ArmR.func_78792_a(this.ArmR1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 181 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 183 */     this.Head.func_78785_a(f5);
/*     */     
/* 185 */     this.Body.func_78785_a(f5);
/* 186 */     this.ArmR.func_78785_a(f5);
/* 187 */     this.ArmL.func_78785_a(f5);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 194 */     this.Base1.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 199 */     modelRenderer.field_78795_f = x;
/* 200 */     modelRenderer.field_78796_g = y;
/* 201 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 205 */     int calc = par7Entity.field_70173_aa;
/* 206 */     if (calc > 100) calc -= 100; 
/* 207 */     float r = 360.0F;
/* 208 */     float r2 = 180.0F;
/* 209 */     float n4 = par4;
/* 210 */     float n5 = par5;
/*     */     
/* 212 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 213 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 214 */     float ex = par7Entity.field_70173_aa;
/* 215 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 216 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 218 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 219 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbbaba\ModelFortunetellerBaba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */