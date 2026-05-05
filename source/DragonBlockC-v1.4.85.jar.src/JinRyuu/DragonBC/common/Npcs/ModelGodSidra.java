/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import JinRyuu.JRMCore.client.JGRenderHelper;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class ModelGodSidra
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmR1;
/*     */   public ModelRenderer ArmL1;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer earL;
/*     */   public ModelRenderer earR;
/*     */   public ModelRenderer Hair1;
/*     */   public ModelRenderer Nose;
/*     */   public ModelRenderer Beard1;
/*     */   public ModelRenderer Hair2;
/*     */   public ModelRenderer Beard2;
/*     */   public ModelRenderer Beard3;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Cloth1;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer ArmR2;
/*     */   public ModelRenderer ArmRingR1;
/*     */   public ModelRenderer ArmRingR2;
/*     */   public ModelRenderer ArmL2;
/*     */   public ModelRenderer ArmRingL1;
/*     */   public ModelRenderer ArmRingL2;
/*     */   public ModelRenderer LegL2;
/*     */   public ModelRenderer LegR2;
/*     */   
/*     */   public ModelGodSidra() {
/*  40 */     this.field_78090_t = 128;
/*  41 */     this.field_78089_u = 64;
/*  42 */     this.LegR2 = new ModelRenderer(this, 0, 37);
/*  43 */     this.LegR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  44 */     this.LegR2.func_78790_a(-3.5F, 0.1F, -3.5F, 6, 8, 7, 0.0F);
/*  45 */     this.ArmR2 = new ModelRenderer(this, 90, 38);
/*  46 */     this.ArmR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  47 */     this.ArmR2.func_78790_a(-2.8F, 4.7F, -2.0F, 4, 8, 4, 0.0F);
/*  48 */     this.ArmL2 = new ModelRenderer(this, 90, 38);
/*  49 */     this.ArmL2.field_78809_i = true;
/*  50 */     this.ArmL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  51 */     this.ArmL2.func_78790_a(-1.2F, 4.7F, -2.0F, 4, 8, 4, 0.0F);
/*  52 */     this.ArmRingL1 = new ModelRenderer(this, 88, 51);
/*  53 */     this.ArmRingL1.field_78809_i = true;
/*  54 */     this.ArmRingL1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  55 */     this.ArmRingL1.func_78790_a(-1.4F, 8.3F, -2.5F, 5, 1, 5, 0.0F);
/*  56 */     this.Head = new ModelRenderer(this, 0, 0);
/*  57 */     this.Head.func_78793_a(0.0F, 0.0F, 0.0F);
/*  58 */     this.Head.func_78790_a(-4.0F, -5.9F, -4.6F, 8, 6, 8, -0.1F);
/*  59 */     this.LegL2 = new ModelRenderer(this, 0, 37);
/*  60 */     this.LegL2.field_78809_i = true;
/*  61 */     this.LegL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  62 */     this.LegL2.func_78790_a(-2.5F, 0.1F, -3.5F, 6, 8, 7, 0.0F);
/*  63 */     this.ArmRingL2 = new ModelRenderer(this, 88, 51);
/*  64 */     this.ArmRingL2.field_78809_i = true;
/*  65 */     this.ArmRingL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  66 */     this.ArmRingL2.func_78790_a(0.1F, 9.4F, -2.5F, 5, 1, 5, 0.0F);
/*  67 */     setRotateAngle(this.ArmRingL2, 0.0F, 0.0F, 0.15009831F);
/*  68 */     this.Hair2 = new ModelRenderer(this, 91, 16);
/*  69 */     this.Hair2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  70 */     this.Hair2.func_78790_a(-3.0F, -3.0F, 4.6F, 6, 9, 1, 0.0F);
/*  71 */     this.ArmR1 = new ModelRenderer(this, 91, 28);
/*  72 */     this.ArmR1.func_78793_a(-6.5F, 1.6F, -0.5F);
/*  73 */     this.ArmR1.func_78790_a(-2.1F, -1.4F, -1.5F, 3, 6, 3, 0.2F);
/*  74 */     this.earL = new ModelRenderer(this, 1, 1);
/*  75 */     this.earL.field_78809_i = true;
/*  76 */     this.earL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  77 */     this.earL.func_78790_a(1.0F, -6.1F, -1.5F, 2, 3, 1, 0.0F);
/*  78 */     setRotateAngle(this.earL, -0.12217305F, -0.13613568F, 0.5462881F);
/*  79 */     this.earR = new ModelRenderer(this, 1, 1);
/*  80 */     this.earR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  81 */     this.earR.func_78790_a(-3.0F, -6.1F, -1.5F, 2, 3, 1, 0.0F);
/*  82 */     setRotateAngle(this.earR, -0.12217305F, 0.13613568F, -0.5462881F);
/*  83 */     this.Body2 = new ModelRenderer(this, 37, 29);
/*  84 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  85 */     this.Body2.func_78790_a(-6.0F, 5.0F, -4.7F, 12, 5, 9, 0.0F);
/*  86 */     this.Beard2 = new ModelRenderer(this, 5, 27);
/*  87 */     this.Beard2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  88 */     this.Beard2.func_78790_a(-3.0F, 1.4F, -5.3F, 6, 1, 1, 0.0F);
/*  89 */     this.LegL = new ModelRenderer(this, 0, 53);
/*  90 */     this.LegL.field_78809_i = true;
/*  91 */     this.LegL.func_78793_a(2.4F, 12.0F, 0.0F);
/*  92 */     this.LegL.func_78790_a(-2.1F, 6.0F, -2.6F, 5, 6, 5, 0.0F);
/*  93 */     this.Hair1 = new ModelRenderer(this, 89, 1);
/*  94 */     this.Hair1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  95 */     this.Hair1.func_78790_a(-4.0F, -3.8F, 2.7F, 8, 12, 2, 0.0F);
/*  96 */     this.Body1 = new ModelRenderer(this, 38, 14);
/*  97 */     this.Body1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  98 */     this.Body1.func_78790_a(-5.5F, 0.0F, -4.0F, 11, 5, 8, 0.0F);
/*  99 */     this.Nose = new ModelRenderer(this, 25, 4);
/* 100 */     this.Nose.func_78793_a(0.0F, 0.0F, 0.0F);
/* 101 */     this.Nose.func_78790_a(-1.0F, -3.0F, -5.9F, 2, 1, 2, 0.0F);
/* 102 */     this.ArmL1 = new ModelRenderer(this, 91, 28);
/* 103 */     this.ArmL1.field_78809_i = true;
/* 104 */     this.ArmL1.func_78793_a(6.5F, 1.6F, -0.5F);
/* 105 */     this.ArmL1.func_78790_a(-0.9F, -1.4F, -1.5F, 3, 6, 3, 0.2F);
/* 106 */     this.ArmRingR1 = new ModelRenderer(this, 88, 51);
/* 107 */     this.ArmRingR1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 108 */     this.ArmRingR1.func_78790_a(-3.5F, 8.3F, -2.5F, 5, 1, 5, 0.0F);
/* 109 */     this.Body3 = new ModelRenderer(this, 39, 44);
/* 110 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 111 */     this.Body3.func_78790_a(-5.5F, 9.1F, -4.1F, 11, 3, 8, 0.0F);
/* 112 */     this.Cloth1 = new ModelRenderer(this, 54, 0);
/* 113 */     this.Cloth1.func_78793_a(0.0F, 10.0F, -4.2F);
/* 114 */     this.Cloth1.func_78790_a(-2.5F, 0.0F, -0.2F, 5, 10, 0, 0.0F);
/* 115 */     setRotateAngle(this.Cloth1, -0.04363323F, 0.0F, 0.0F);
/* 116 */     this.ArmRingR2 = new ModelRenderer(this, 88, 51);
/* 117 */     this.ArmRingR2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 118 */     this.ArmRingR2.func_78790_a(-4.9F, 9.4F, -2.5F, 5, 1, 5, 0.0F);
/* 119 */     setRotateAngle(this.ArmRingR2, 0.0F, 0.0F, -0.15009831F);
/* 120 */     this.LegR = new ModelRenderer(this, 0, 53);
/* 121 */     this.LegR.func_78793_a(-2.6F, 12.0F, 0.0F);
/* 122 */     this.LegR.func_78790_a(-2.9F, 6.0F, -2.5F, 5, 6, 5, 0.0F);
/* 123 */     this.Beard1 = new ModelRenderer(this, 4, 20);
/* 124 */     this.Beard1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 125 */     this.Beard1.func_78790_a(-4.0F, -1.5F, -5.3F, 8, 3, 2, 0.0F);
/* 126 */     this.Beard3 = new ModelRenderer(this, 5, 15);
/* 127 */     this.Beard3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 128 */     this.Beard3.func_78790_a(-3.0F, -2.2F, -5.6F, 6, 2, 2, 0.0F);
/* 129 */     this.LegR.func_78792_a(this.LegR2);
/* 130 */     this.ArmR1.func_78792_a(this.ArmR2);
/* 131 */     this.ArmL1.func_78792_a(this.ArmL2);
/* 132 */     this.ArmL2.func_78792_a(this.ArmRingL1);
/* 133 */     this.LegL.func_78792_a(this.LegL2);
/* 134 */     this.ArmRingL1.func_78792_a(this.ArmRingL2);
/* 135 */     this.Hair1.func_78792_a(this.Hair2);
/* 136 */     this.Head.func_78792_a(this.earL);
/* 137 */     this.Head.func_78792_a(this.earR);
/* 138 */     this.Body1.func_78792_a(this.Body2);
/* 139 */     this.Beard1.func_78792_a(this.Beard2);
/* 140 */     this.Head.func_78792_a(this.Hair1);
/* 141 */     this.Head.func_78792_a(this.Nose);
/* 142 */     this.ArmR2.func_78792_a(this.ArmRingR1);
/* 143 */     this.Body2.func_78792_a(this.Body3);
/* 144 */     this.Body1.func_78792_a(this.Cloth1);
/* 145 */     this.ArmRingR1.func_78792_a(this.ArmRingR2);
/* 146 */     this.Head.func_78792_a(this.Beard1);
/* 147 */     this.Beard1.func_78792_a(this.Beard3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 152 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 154 */     GL11.glPushMatrix();
/* 155 */     float F = 0.8F;
/* 156 */     JGRenderHelper.modelScalePositionHelper(0.8F);
/*     */     
/* 158 */     this.LegL.func_78785_a(f5);
/* 159 */     this.Head.func_78785_a(f5);
/* 160 */     this.ArmL1.func_78785_a(f5);
/* 161 */     this.ArmR1.func_78785_a(f5);
/* 162 */     this.Body1.func_78785_a(f5);
/* 163 */     this.LegR.func_78785_a(f5);
/* 164 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 170 */     modelRenderer.field_78795_f = x;
/* 171 */     modelRenderer.field_78796_g = y;
/* 172 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 176 */     int calc = par7Entity.field_70173_aa;
/* 177 */     if (calc > 100) calc -= 100; 
/* 178 */     float r = 360.0F;
/* 179 */     float r2 = 180.0F;
/* 180 */     float n4 = par4;
/* 181 */     float n5 = par5;
/*     */     
/* 183 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 184 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 185 */     float ex = par7Entity.field_70173_aa;
/* 186 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 187 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 189 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 190 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
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
/* 236 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 237 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 238 */     this.ArmR1.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 239 */     this.ArmL1.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 241 */     this.LegR.field_78796_g = 0.0F;
/* 242 */     this.LegL.field_78796_g = 0.0F;
/* 243 */     this.ArmR1.field_78796_g = 0.0F;
/* 244 */     this.ArmL1.field_78796_g = 0.0F;
/*     */ 
/*     */     
/* 247 */     this.Cloth1.field_78795_f = -0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/*     */ 
/*     */ 
/*     */     
/* 251 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelGodSidra.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */