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
/*     */ public class ModelKaio
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ShoulderR;
/*     */   public ModelRenderer ShoulderL;
/*     */   public ModelRenderer AntennaR;
/*     */   public ModelRenderer AntennaL;
/*     */   public ModelRenderer EarR;
/*     */   public ModelRenderer EarL;
/*     */   public ModelRenderer WhiskerR;
/*     */   public ModelRenderer WhiskerL;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer Body4;
/*     */   public ModelRenderer FeetR;
/*     */   public ModelRenderer FeetL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer HandR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer HandL;
/*     */   
/*     */   public ModelKaio() {
/*  36 */     this.field_78090_t = 128;
/*  37 */     this.field_78089_u = 128;
/*  38 */     this.HandR = new ModelRenderer(this, 72, 66);
/*  39 */     this.HandR.func_78793_a(0.1F, 8.8F, 0.0F);
/*  40 */     this.HandR.func_78790_a(-1.5F, -0.5F, -2.5F, 3, 2, 5, 0.0F);
/*  41 */     this.FeetL = new ModelRenderer(this, 16, 106);
/*  42 */     this.FeetL.field_78809_i = true;
/*  43 */     this.FeetL.func_78793_a(5.0F, 5.0F, 0.0F);
/*  44 */     this.FeetL.func_78790_a(-2.0F, 0.0F, -4.4F, 4, 3, 6, 0.0F);
/*  45 */     setRotateAngle(this.FeetL, 0.0F, -0.090757124F, 0.0F);
/*  46 */     this.Body3 = new ModelRenderer(this, 1, 66);
/*  47 */     this.Body3.func_78793_a(0.0F, 5.0F, 0.0F);
/*  48 */     this.Body3.func_78790_a(-9.5F, 0.0F, -6.0F, 19, 5, 12, 0.0F);
/*  49 */     this.FeetR = new ModelRenderer(this, 16, 106);
/*  50 */     this.FeetR.func_78793_a(-5.0F, 5.0F, 0.0F);
/*  51 */     this.FeetR.func_78790_a(-2.0F, 0.0F, -4.4F, 4, 3, 6, 0.0F);
/*  52 */     setRotateAngle(this.FeetR, 0.0F, 0.090757124F, 0.0F);
/*  53 */     this.Body1 = new ModelRenderer(this, 1, 34);
/*  54 */     this.Body1.func_78793_a(0.0F, 1.0F, 0.0F);
/*  55 */     this.Body1.func_78790_a(-7.0F, 0.0F, -4.0F, 14, 5, 8, 0.0F);
/*  56 */     this.AntennaR = new ModelRenderer(this, 53, 1);
/*  57 */     this.AntennaR.func_78793_a(-1.9F, -6.5F, -5.2F);
/*  58 */     this.AntennaR.func_78790_a(0.0F, -3.9F, -12.9F, 0, 5, 13, 0.0F);
/*  59 */     setRotateAngle(this.AntennaR, 0.0F, 0.35604715F, 0.0F);
/*  60 */     this.EarR = new ModelRenderer(this, 38, 14);
/*  61 */     this.EarR.func_78793_a(-4.9F, -2.0F, -1.3F);
/*  62 */     this.EarR.func_78790_a(-3.1F, -4.2F, 0.0F, 3, 5, 0, 0.0F);
/*  63 */     setRotateAngle(this.EarR, 0.0F, 0.9546951F, 0.0F);
/*  64 */     this.ShoulderL = new ModelRenderer(this, 69, 31);
/*  65 */     this.ShoulderL.field_78809_i = true;
/*  66 */     this.ShoulderL.func_78793_a(7.0F, 3.1F, 0.0F);
/*  67 */     this.ShoulderL.func_78790_a(0.0F, -2.5F, -4.0F, 8, 6, 7, 0.0F);
/*  68 */     this.Head = new ModelRenderer(this, 8, 12);
/*  69 */     this.Head.func_78793_a(0.0F, 1.3F, 0.0F);
/*  70 */     this.Head.func_78790_a(-5.0F, -7.4F, -5.3F, 10, 8, 8, 0.0F);
/*  71 */     this.Body4 = new ModelRenderer(this, 1, 85);
/*  72 */     this.Body4.func_78793_a(0.0F, 5.0F, 0.0F);
/*  73 */     this.Body4.func_78790_a(-10.0F, 0.0F, -6.5F, 20, 5, 13, 0.0F);
/*  74 */     this.ArmL = new ModelRenderer(this, 72, 46);
/*  75 */     this.ArmL.field_78809_i = true;
/*  76 */     this.ArmL.func_78793_a(4.5F, 0.6F, -0.5F);
/*  77 */     this.ArmL.func_78790_a(-2.5F, -2.6F, -3.0F, 5, 11, 6, 0.0F);
/*  78 */     this.EarL = new ModelRenderer(this, 38, 14);
/*  79 */     this.EarL.field_78809_i = true;
/*  80 */     this.EarL.func_78793_a(5.0F, -2.0F, -1.3F);
/*  81 */     this.EarL.func_78790_a(0.0F, -4.2F, 0.0F, 3, 5, 0, 0.0F);
/*  82 */     setRotateAngle(this.EarL, 0.0F, -0.9546951F, 0.0F);
/*  83 */     this.WhiskerL = new ModelRenderer(this, 46, 23);
/*  84 */     this.WhiskerL.field_78809_i = true;
/*  85 */     this.WhiskerL.func_78793_a(4.0F, -1.7F, -5.2F);
/*  86 */     this.WhiskerL.func_78790_a(0.0F, -0.5F, -0.6F, 4, 1, 0, 0.0F);
/*  87 */     setRotateAngle(this.WhiskerL, 0.0F, 0.19547687F, 0.2268928F);
/*  88 */     this.AntennaL = new ModelRenderer(this, 53, 1);
/*  89 */     this.AntennaL.field_78809_i = true;
/*  90 */     this.AntennaL.func_78793_a(1.3F, -6.5F, -4.0F);
/*  91 */     this.AntennaL.func_78790_a(0.0F, -3.9F, -14.8F, 0, 5, 13, 0.0F);
/*  92 */     setRotateAngle(this.AntennaL, 0.0F, -0.35604715F, 0.0F);
/*  93 */     this.WhiskerR = new ModelRenderer(this, 46, 23);
/*  94 */     this.WhiskerR.func_78793_a(-4.0F, -1.7F, -5.2F);
/*  95 */     this.WhiskerR.func_78790_a(-4.0F, -0.5F, -0.1F, 4, 1, 0, 0.0F);
/*  96 */     setRotateAngle(this.WhiskerR, 0.0F, -0.19547687F, -0.2268928F);
/*  97 */     this.ArmR = new ModelRenderer(this, 72, 46);
/*  98 */     this.ArmR.func_78793_a(-4.5F, 0.6F, -0.5F);
/*  99 */     this.ArmR.func_78790_a(-2.5F, -2.6F, -3.0F, 5, 11, 6, 0.0F);
/* 100 */     this.HandL = new ModelRenderer(this, 72, 66);
/* 101 */     this.HandL.field_78809_i = true;
/* 102 */     this.HandL.func_78793_a(0.0F, 8.8F, 0.0F);
/* 103 */     this.HandL.func_78790_a(-1.5F, -0.5F, -2.5F, 3, 2, 5, 0.0F);
/* 104 */     this.ShoulderR = new ModelRenderer(this, 69, 31);
/* 105 */     this.ShoulderR.func_78793_a(-7.0F, 3.1F, 0.0F);
/* 106 */     this.ShoulderR.func_78790_a(-8.0F, -2.5F, -4.0F, 8, 6, 7, 0.0F);
/* 107 */     this.Body2 = new ModelRenderer(this, 0, 49);
/* 108 */     this.Body2.func_78793_a(0.0F, 5.0F, 0.0F);
/* 109 */     this.Body2.func_78790_a(-9.0F, 0.0F, -5.0F, 18, 5, 10, 0.0F);
/* 110 */     this.ArmR.func_78792_a(this.HandR);
/* 111 */     this.Body4.func_78792_a(this.FeetL);
/* 112 */     this.Body2.func_78792_a(this.Body3);
/* 113 */     this.Body4.func_78792_a(this.FeetR);
/* 114 */     this.Head.func_78792_a(this.AntennaR);
/* 115 */     this.Head.func_78792_a(this.EarR);
/* 116 */     this.Body3.func_78792_a(this.Body4);
/* 117 */     this.ShoulderL.func_78792_a(this.ArmL);
/* 118 */     this.Head.func_78792_a(this.EarL);
/* 119 */     this.Head.func_78792_a(this.WhiskerL);
/* 120 */     this.Head.func_78792_a(this.AntennaL);
/* 121 */     this.Head.func_78792_a(this.WhiskerR);
/* 122 */     this.ShoulderR.func_78792_a(this.ArmR);
/* 123 */     this.ArmL.func_78792_a(this.HandL);
/* 124 */     this.Body1.func_78792_a(this.Body2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 129 */     GL11.glPushMatrix();
/*     */     
/* 131 */     float F = 0.6F;
/* 132 */     JGRenderHelper.modelScalePositionHelper(0.6F);
/*     */     
/* 134 */     float n4 = f3;
/* 135 */     float n5 = f4;
/* 136 */     float r2 = 180.0F;
/* 137 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 138 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F - 0.2F;
/*     */     
/* 140 */     this.Body1.func_78785_a(f5);
/* 141 */     this.ShoulderL.func_78785_a(f5);
/* 142 */     this.Head.func_78785_a(f5);
/* 143 */     this.ShoulderR.func_78785_a(f5);
/*     */     
/* 145 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 152 */     modelRenderer.field_78795_f = x;
/* 153 */     modelRenderer.field_78796_g = y;
/* 154 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelKaio.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */