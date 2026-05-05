/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import JinRyuu.JRMCore.client.JGRenderHelper;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class ModelGodIwan
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer Hat;
/*     */   public ModelRenderer earL;
/*     */   public ModelRenderer earR;
/*     */   public ModelRenderer BeardNeck;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Cloth1;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer LegL2;
/*     */   public ModelRenderer LegR2;
/*     */   
/*     */   public ModelGodIwan() {
/*  30 */     this.field_78090_t = 128;
/*  31 */     this.field_78089_u = 64;
/*  32 */     this.Body2 = new ModelRenderer(this, 37, 29);
/*  33 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  34 */     this.Body2.func_78790_a(-6.0F, 5.0F, -4.7F, 12, 5, 9, 0.0F);
/*  35 */     this.Body1 = new ModelRenderer(this, 38, 14);
/*  36 */     this.Body1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  37 */     this.Body1.func_78790_a(-5.5F, 0.0F, -4.0F, 11, 5, 8, 0.0F);
/*  38 */     this.earL = new ModelRenderer(this, 1, 1);
/*  39 */     this.earL.field_78809_i = true;
/*  40 */     this.earL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  41 */     this.earL.func_78790_a(1.1F, -7.5F, -0.5F, 2, 3, 1, 0.0F);
/*  42 */     setRotateAngle(this.earL, 0.0F, -0.13613568F, 0.5462881F);
/*  43 */     this.Head = new ModelRenderer(this, 0, 0);
/*  44 */     this.Head.func_78793_a(0.0F, 0.0F, 0.0F);
/*  45 */     this.Head.func_78790_a(-4.5F, -5.1F, -4.6F, 9, 5, 8, 0.0F);
/*  46 */     this.Hat = new ModelRenderer(this, 37, 4);
/*  47 */     this.Hat.func_78793_a(0.0F, 0.0F, 0.0F);
/*  48 */     this.Hat.func_78790_a(-2.5F, -7.9F, -2.4F, 5, 3, 5, 0.0F);
/*  49 */     this.Cloth1 = new ModelRenderer(this, 83, 24);
/*  50 */     this.Cloth1.func_78793_a(0.0F, 9.9F, -4.5F);
/*  51 */     this.Cloth1.func_78790_a(-3.5F, 0.0F, -0.1F, 7, 11, 0, 0.0F);
/*  52 */     setRotateAngle(this.Cloth1, -0.057595864F, 0.0F, 0.0F);
/*  53 */     this.Body3 = new ModelRenderer(this, 39, 44);
/*  54 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  55 */     this.Body3.func_78790_a(-5.5F, 9.1F, -4.1F, 11, 3, 8, 0.0F);
/*  56 */     this.LegR2 = new ModelRenderer(this, 0, 37);
/*  57 */     this.LegR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  58 */     this.LegR2.func_78790_a(-3.5F, 0.1F, -3.5F, 6, 8, 7, 0.0F);
/*  59 */     this.earR = new ModelRenderer(this, 1, 1);
/*  60 */     this.earR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  61 */     this.earR.func_78790_a(-3.1F, -7.5F, -0.5F, 2, 3, 1, 0.0F);
/*  62 */     setRotateAngle(this.earR, 0.0F, 0.13613568F, -0.5462881F);
/*  63 */     this.ArmL = new ModelRenderer(this, 70, 5);
/*  64 */     this.ArmL.field_78809_i = true;
/*  65 */     this.ArmL.func_78793_a(6.4F, 1.7F, -0.2F);
/*  66 */     this.ArmL.func_78790_a(-0.9F, -1.7F, -1.8F, 4, 11, 4, 0.0F);
/*  67 */     this.ArmR = new ModelRenderer(this, 70, 5);
/*  68 */     this.ArmR.func_78793_a(-6.4F, 1.7F, -0.2F);
/*  69 */     this.ArmR.func_78790_a(-3.1F, -1.7F, -1.8F, 4, 11, 4, 0.0F);
/*  70 */     this.LegL = new ModelRenderer(this, 0, 53);
/*  71 */     this.LegL.field_78809_i = true;
/*  72 */     this.LegL.func_78793_a(2.4F, 12.0F, 0.0F);
/*  73 */     this.LegL.func_78790_a(-2.1F, 6.0F, -2.6F, 5, 6, 5, 0.0F);
/*  74 */     this.LegR = new ModelRenderer(this, 0, 53);
/*  75 */     this.LegR.func_78793_a(-2.6F, 12.0F, 0.0F);
/*  76 */     this.LegR.func_78790_a(-2.9F, 6.0F, -2.5F, 5, 6, 5, 0.0F);
/*  77 */     this.LegL2 = new ModelRenderer(this, 0, 37);
/*  78 */     this.LegL2.field_78809_i = true;
/*  79 */     this.LegL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  80 */     this.LegL2.func_78790_a(-2.5F, 0.1F, -3.5F, 6, 8, 7, 0.0F);
/*  81 */     this.BeardNeck = new ModelRenderer(this, 6, 20);
/*  82 */     this.BeardNeck.func_78793_a(0.0F, 0.0F, 0.0F);
/*  83 */     this.BeardNeck.func_78790_a(-4.5F, -0.1F, -5.3F, 9, 5, 3, 0.0F);
/*  84 */     this.Body1.func_78792_a(this.Body2);
/*  85 */     this.Head.func_78792_a(this.earL);
/*  86 */     this.Head.func_78792_a(this.Hat);
/*  87 */     this.Body1.func_78792_a(this.Cloth1);
/*  88 */     this.Body2.func_78792_a(this.Body3);
/*  89 */     this.LegR.func_78792_a(this.LegR2);
/*  90 */     this.Head.func_78792_a(this.earR);
/*  91 */     this.LegL.func_78792_a(this.LegL2);
/*  92 */     this.Head.func_78792_a(this.BeardNeck);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  97 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/*  99 */     GL11.glPushMatrix();
/* 100 */     float F = 0.65F;
/* 101 */     JGRenderHelper.modelScalePositionHelper(0.65F);
/*     */     
/* 103 */     this.LegL.func_78785_a(f5);
/* 104 */     this.Head.func_78785_a(f5);
/* 105 */     this.ArmL.func_78785_a(f5);
/* 106 */     this.ArmR.func_78785_a(f5);
/* 107 */     this.Body1.func_78785_a(f5);
/* 108 */     this.LegR.func_78785_a(f5);
/* 109 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 114 */     modelRenderer.field_78795_f = x;
/* 115 */     modelRenderer.field_78796_g = y;
/* 116 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 120 */     int calc = par7Entity.field_70173_aa;
/* 121 */     if (calc > 100) calc -= 100; 
/* 122 */     float r = 360.0F;
/* 123 */     float r2 = 180.0F;
/* 124 */     float n4 = par4;
/* 125 */     float n5 = par5;
/*     */     
/* 127 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 128 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 129 */     float ex = par7Entity.field_70173_aa;
/* 130 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 131 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 133 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 134 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
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
/* 175 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 176 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 177 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 178 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 180 */     this.LegR.field_78796_g = 0.0F;
/* 181 */     this.LegL.field_78796_g = 0.0F;
/* 182 */     this.ArmR.field_78796_g = 0.0F;
/* 183 */     this.ArmL.field_78796_g = 0.0F;
/*     */ 
/*     */     
/* 186 */     this.Cloth1.field_78795_f = -0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/*     */ 
/*     */ 
/*     */     
/* 190 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelGodIwan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */