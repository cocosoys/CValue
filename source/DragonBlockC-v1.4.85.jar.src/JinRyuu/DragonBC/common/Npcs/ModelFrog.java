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
/*     */ public class ModelFrog
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer LegL1;
/*     */   public ModelRenderer LegR1;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Head1;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer Tail1;
/*     */   public ModelRenderer Tail2;
/*     */   public ModelRenderer Head2;
/*     */   public ModelRenderer AntennaR;
/*     */   public ModelRenderer AntennaL;
/*     */   public ModelRenderer Head3;
/*     */   public ModelRenderer AntennaR_1;
/*     */   public ModelRenderer AntennaR_2;
/*     */   public ModelRenderer AntennaL_1;
/*     */   public ModelRenderer AntennaR_3;
/*     */   public ModelRenderer LegL2;
/*     */   public ModelRenderer LegR2;
/*     */   
/*     */   public ModelFrog() {
/*  37 */     this.field_78090_t = 64;
/*  38 */     this.field_78089_u = 64;
/*  39 */     this.ArmR = new ModelRenderer(this, 30, 8);
/*  40 */     this.ArmR.field_78809_i = true;
/*  41 */     this.ArmR.func_78793_a(-3.1F, 17.8F, -3.4F);
/*  42 */     this.ArmR.func_78790_a(-2.3F, -1.0F, -0.9F, 2, 8, 3, 0.0F);
/*  43 */     setRotateAngle(this.ArmR, -0.3630285F, 0.0F, 0.23387411F);
/*  44 */     this.Tail1 = new ModelRenderer(this, 0, 37);
/*  45 */     this.Tail1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  46 */     this.Tail1.func_78790_a(-2.5F, 2.2F, 11.4F, 5, 3, 2, 0.0F);
/*  47 */     setRotateAngle(this.Tail1, 0.071733035F, 0.0F, 0.0F);
/*  48 */     this.Head1 = new ModelRenderer(this, 42, 2);
/*  49 */     this.Head1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  50 */     this.Head1.func_78790_a(-3.0F, 0.2F, -10.0F, 6, 5, 4, 0.0F);
/*  51 */     setRotateAngle(this.Head1, 0.13665928F, 0.0F, 0.0F);
/*  52 */     this.Tail2 = new ModelRenderer(this, 0, 43);
/*  53 */     this.Tail2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  54 */     this.Tail2.func_78790_a(-1.5F, 3.4F, 13.2F, 3, 2, 4, 0.0F);
/*  55 */     setRotateAngle(this.Tail2, 0.045553092F, 0.0F, 0.0F);
/*  56 */     this.AntennaR = new ModelRenderer(this, 31, 0);
/*  57 */     this.AntennaR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  58 */     this.AntennaR.func_78790_a(-3.1F, -5.4F, -5.0F, 1, 1, 4, 0.0F);
/*  59 */     setRotateAngle(this.AntennaR, 0.8552113F, -0.090757124F, 0.0F);
/*  60 */     this.Body2 = new ModelRenderer(this, 0, 0);
/*  61 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  62 */     this.Body2.func_78790_a(-3.5F, -0.3F, -6.2F, 7, 6, 6, 0.0F);
/*  63 */     setRotateAngle(this.Body2, 0.13665928F, 0.0F, 0.0F);
/*  64 */     this.AntennaL = new ModelRenderer(this, 31, 0);
/*  65 */     this.AntennaL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  66 */     this.AntennaL.func_78790_a(2.2F, -5.4F, -5.0F, 1, 1, 4, 0.0F);
/*  67 */     setRotateAngle(this.AntennaL, 0.8552113F, 0.090757124F, 0.0F);
/*  68 */     this.Body1 = new ModelRenderer(this, 0, 13);
/*  69 */     this.Body1.func_78793_a(0.0F, 14.7F, 0.0F);
/*  70 */     this.Body1.func_78790_a(-4.5F, -0.4F, -0.2F, 9, 6, 9, 0.0F);
/*  71 */     setRotateAngle(this.Body1, -0.091106184F, 0.0F, 0.0F);
/*  72 */     this.Body3 = new ModelRenderer(this, 0, 29);
/*  73 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  74 */     this.Body3.func_78790_a(-3.0F, 0.8F, 8.7F, 6, 4, 3, 0.0F);
/*  75 */     setRotateAngle(this.Body3, -0.15009831F, 0.0F, 0.0F);
/*  76 */     this.AntennaR_2 = new ModelRenderer(this, 31, 0);
/*  77 */     this.AntennaR_2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  78 */     this.AntennaR_2.func_78790_a(-3.1F, -4.7F, -0.2F, 1, 1, 4, 0.0F);
/*  79 */     setRotateAngle(this.AntennaR_2, -0.22759093F, 0.0F, 0.0F);
/*  80 */     this.AntennaL_1 = new ModelRenderer(this, 31, 0);
/*  81 */     this.AntennaL_1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  82 */     this.AntennaL_1.func_78790_a(2.2F, -4.6F, -3.1F, 1, 1, 4, 0.0F);
/*  83 */     setRotateAngle(this.AntennaL_1, -0.4098033F, 0.0F, 0.0F);
/*  84 */     this.LegR1 = new ModelRenderer(this, 20, 31);
/*  85 */     this.LegR1.field_78809_i = true;
/*  86 */     this.LegR1.func_78793_a(-3.9F, 18.6F, 7.4F);
/*  87 */     this.LegR1.func_78790_a(-3.8F, -2.3F, -7.2F, 3, 4, 8, 0.0F);
/*  88 */     setRotateAngle(this.LegR1, -0.13665928F, 0.18203785F, 0.0F);
/*  89 */     this.LegL2 = new ModelRenderer(this, 22, 47);
/*  90 */     this.LegL2.func_78793_a(1.4F, 1.3F, -6.0F);
/*  91 */     this.LegL2.func_78790_a(-0.9F, -0.8F, -0.3F, 2, 2, 7, 0.0F);
/*  92 */     setRotateAngle(this.LegL2, -0.59166664F, 0.0F, 0.0F);
/*  93 */     this.Head2 = new ModelRenderer(this, 43, 12);
/*  94 */     this.Head2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  95 */     this.Head2.func_78790_a(-2.5F, 2.1F, -12.7F, 5, 3, 4, 0.0F);
/*  96 */     this.ArmL = new ModelRenderer(this, 30, 8);
/*  97 */     this.ArmL.func_78793_a(3.6F, 17.8F, -3.4F);
/*  98 */     this.ArmL.func_78790_a(-0.3F, -1.0F, -0.9F, 2, 8, 3, 0.0F);
/*  99 */     setRotateAngle(this.ArmL, -0.3642502F, 0.0F, -0.22759093F);
/* 100 */     this.AntennaR_1 = new ModelRenderer(this, 31, 0);
/* 101 */     this.AntennaR_1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 102 */     this.AntennaR_1.func_78790_a(-3.1F, -4.6F, -3.1F, 1, 1, 4, 0.0F);
/* 103 */     setRotateAngle(this.AntennaR_1, -0.4098033F, 0.0F, 0.0F);
/* 104 */     this.Head3 = new ModelRenderer(this, 45, 20);
/* 105 */     this.Head3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 106 */     this.Head3.func_78790_a(-2.0F, -5.4F, -12.4F, 4, 2, 4, 0.0F);
/* 107 */     setRotateAngle(this.Head3, 0.59184116F, 0.0F, 0.0F);
/* 108 */     this.AntennaR_3 = new ModelRenderer(this, 31, 0);
/* 109 */     this.AntennaR_3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 110 */     this.AntennaR_3.func_78790_a(2.2F, -4.7F, -0.2F, 1, 1, 4, 0.0F);
/* 111 */     setRotateAngle(this.AntennaR_3, -0.22759093F, 0.0F, 0.0F);
/* 112 */     this.LegL1 = new ModelRenderer(this, 20, 31);
/* 113 */     this.LegL1.func_78793_a(4.7F, 18.6F, 7.4F);
/* 114 */     this.LegL1.func_78790_a(0.0F, -2.3F, -7.2F, 3, 4, 8, 0.0F);
/* 115 */     setRotateAngle(this.LegL1, -0.13665928F, -0.18203785F, 0.0F);
/* 116 */     this.LegR2 = new ModelRenderer(this, 22, 47);
/* 117 */     this.LegR2.field_78809_i = true;
/* 118 */     this.LegR2.func_78793_a(-2.3F, 1.3F, -6.0F);
/* 119 */     this.LegR2.func_78790_a(-1.0F, -0.8F, -0.3F, 2, 2, 7, 0.0F);
/* 120 */     setRotateAngle(this.LegR2, -0.59166664F, 0.0F, 0.0F);
/* 121 */     this.Body3.func_78792_a(this.Tail1);
/* 122 */     this.Body1.func_78792_a(this.Head1);
/* 123 */     this.Tail1.func_78792_a(this.Tail2);
/* 124 */     this.Head1.func_78792_a(this.AntennaR);
/* 125 */     this.Body1.func_78792_a(this.Body2);
/* 126 */     this.Head1.func_78792_a(this.AntennaL);
/* 127 */     this.Body2.func_78792_a(this.Body3);
/* 128 */     this.AntennaR_1.func_78792_a(this.AntennaR_2);
/* 129 */     this.AntennaL.func_78792_a(this.AntennaL_1);
/* 130 */     this.LegL1.func_78792_a(this.LegL2);
/* 131 */     this.Head1.func_78792_a(this.Head2);
/* 132 */     this.AntennaR.func_78792_a(this.AntennaR_1);
/* 133 */     this.Head2.func_78792_a(this.Head3);
/* 134 */     this.AntennaL_1.func_78792_a(this.AntennaR_3);
/* 135 */     this.LegR1.func_78792_a(this.LegR2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 144 */     if (entity.field_70122_E && entity.field_70181_x < 0.2D) {
/* 145 */       this.LegL1.field_78795_f = MathHelper.func_76134_b(f * 0.6662F) * 1.2F * f1;
/* 146 */       this.LegR1.field_78795_f = MathHelper.func_76134_b(f * 0.6662F) * 1.2F * f1;
/* 147 */       setRotateAngle(this.LegL2, -0.59166664F, 0.0F, 0.0F);
/* 148 */       setRotateAngle(this.LegR2, -0.59166664F, 0.0F, 0.0F);
/*     */     } else {
/*     */       
/* 151 */       this.LegL1.field_78795_f = 2.3F;
/* 152 */       this.LegR1.field_78795_f = 2.3F;
/* 153 */       this.LegL2.field_78795_f = -3.0F;
/* 154 */       this.LegR2.field_78795_f = -3.0F;
/*     */     } 
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
/* 168 */     GL11.glPushMatrix();
/* 169 */     GL11.glScalef(0.5F, 0.5F, 0.5F);
/* 170 */     GL11.glTranslatef(0.0F, 1.4F, 0.0F);
/* 171 */     this.ArmR.func_78785_a(f5);
/* 172 */     this.Body1.func_78785_a(f5);
/* 173 */     this.LegR1.func_78785_a(f5);
/* 174 */     this.ArmL.func_78785_a(f5);
/* 175 */     this.LegL1.func_78785_a(f5);
/* 176 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 183 */     modelRenderer.field_78795_f = x;
/* 184 */     modelRenderer.field_78796_g = y;
/* 185 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelFrog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */