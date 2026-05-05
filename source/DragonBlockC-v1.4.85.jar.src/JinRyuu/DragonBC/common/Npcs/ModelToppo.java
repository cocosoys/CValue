/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import JinRyuu.JRMCore.client.JGRenderHelper;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class ModelToppo
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmR1;
/*     */   public ModelRenderer ArmL1;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer Moustache;
/*     */   public ModelRenderer Nose;
/*     */   public ModelRenderer EarR;
/*     */   public ModelRenderer EarL;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer ArmR2;
/*     */   public ModelRenderer ArmR3;
/*     */   public ModelRenderer ArmL2;
/*     */   public ModelRenderer ArmL3;
/*     */   
/*     */   public ModelToppo() {
/*  31 */     this.field_78090_t = 128;
/*  32 */     this.field_78089_u = 64;
/*  33 */     this.ArmR3 = new ModelRenderer(this, 63, 38);
/*  34 */     this.ArmR3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  35 */     this.ArmR3.func_78790_a(-4.4F, 2.9F, -3.0F, 6, 9, 6, 0.0F);
/*  36 */     this.Head = new ModelRenderer(this, 0, 0);
/*  37 */     this.Head.func_78793_a(0.0F, -4.3F, -0.9F);
/*  38 */     this.Head.func_78790_a(-4.0F, -6.6F, -4.0F, 8, 8, 8, 0.1F);
/*  39 */     this.Body1 = new ModelRenderer(this, 20, 16);
/*  40 */     this.Body1.func_78793_a(0.0F, -4.8F, 0.0F);
/*  41 */     this.Body1.func_78790_a(-6.5F, 0.0F, -3.4F, 13, 6, 7, 0.0F);
/*  42 */     this.Body3 = new ModelRenderer(this, 19, 46);
/*  43 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  44 */     this.Body3.func_78790_a(-6.5F, 13.0F, -3.2F, 13, 4, 7, 0.0F);
/*  45 */     this.ArmL1 = new ModelRenderer(this, 62, 16);
/*  46 */     this.ArmL1.field_78809_i = true;
/*  47 */     this.ArmL1.func_78793_a(7.1F, -2.0F, 0.0F);
/*  48 */     this.ArmL1.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 6, 4, 0.0F);
/*  49 */     setRotateAngle(this.ArmL1, 0.0F, 0.0F, -0.5009095F);
/*  50 */     this.ArmR1 = new ModelRenderer(this, 62, 16);
/*  51 */     this.ArmR1.func_78793_a(-6.9F, -2.0F, 0.0F);
/*  52 */     this.ArmR1.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 6, 4, 0.0F);
/*  53 */     setRotateAngle(this.ArmR1, 0.0F, 0.0F, 0.5009095F);
/*  54 */     this.LegL = new ModelRenderer(this, 0, 16);
/*  55 */     this.LegL.field_78809_i = true;
/*  56 */     this.LegL.func_78793_a(2.5F, 12.0F, 0.0F);
/*  57 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.5F, 5, 12, 5, 0.0F);
/*  58 */     this.ArmR2 = new ModelRenderer(this, 63, 27);
/*  59 */     this.ArmR2.func_78793_a(0.0F, 3.5F, 0.0F);
/*  60 */     this.ArmR2.func_78790_a(-3.7F, -0.7F, -2.5F, 5, 4, 5, 0.0F);
/*  61 */     setRotateAngle(this.ArmR2, 0.0F, 0.0F, -0.4098033F);
/*  62 */     this.EarL = new ModelRenderer(this, 33, 8);
/*  63 */     this.EarL.field_78809_i = true;
/*  64 */     this.EarL.func_78793_a(4.0F, -3.0F, -1.1F);
/*  65 */     this.EarL.func_78790_a(-0.5F, -3.0F, 0.0F, 2, 4, 0, 0.0F);
/*  66 */     setRotateAngle(this.EarL, 0.0F, -0.68294734F, 0.31869712F);
/*  67 */     this.Nose = new ModelRenderer(this, 0, 0);
/*  68 */     this.Nose.func_78793_a(0.0F, 0.0F, 0.0F);
/*  69 */     this.Nose.func_78790_a(-1.0F, -2.4F, -5.2F, 2, 2, 2, 0.0F);
/*  70 */     this.LegR = new ModelRenderer(this, 0, 16);
/*  71 */     this.LegR.func_78793_a(-2.5F, 12.0F, 0.0F);
/*  72 */     this.LegR.func_78790_a(-3.0F, 0.0F, -2.5F, 5, 12, 5, 0.0F);
/*  73 */     this.EarR = new ModelRenderer(this, 33, 8);
/*  74 */     this.EarR.func_78793_a(-4.0F, -3.0F, -1.1F);
/*  75 */     this.EarR.func_78790_a(-1.4F, -3.0F, 0.0F, 2, 4, 0, 0.0F);
/*  76 */     setRotateAngle(this.EarR, 0.0F, 0.68294734F, -0.31869712F);
/*  77 */     this.Body2 = new ModelRenderer(this, 18, 30);
/*  78 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  79 */     this.Body2.func_78790_a(-7.0F, 6.0F, -4.1F, 14, 7, 8, 0.0F);
/*  80 */     this.ArmL2 = new ModelRenderer(this, 63, 27);
/*  81 */     this.ArmL2.field_78809_i = true;
/*  82 */     this.ArmL2.func_78793_a(0.0F, 3.5F, 0.0F);
/*  83 */     this.ArmL2.func_78790_a(-1.5F, -0.7F, -2.5F, 5, 4, 5, 0.0F);
/*  84 */     setRotateAngle(this.ArmL2, 0.0F, 0.0F, 0.4098033F);
/*  85 */     this.ArmL3 = new ModelRenderer(this, 63, 38);
/*  86 */     this.ArmL3.field_78809_i = true;
/*  87 */     this.ArmL3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  88 */     this.ArmL3.func_78790_a(-1.7F, 2.9F, -3.0F, 6, 9, 6, 0.0F);
/*  89 */     this.Moustache = new ModelRenderer(this, 26, 0);
/*  90 */     this.Moustache.func_78793_a(0.0F, -1.1F, -4.2F);
/*  91 */     this.Moustache.func_78790_a(-4.5F, 0.0F, 0.0F, 9, 6, 0, 0.0F);
/*  92 */     this.ArmR2.func_78792_a(this.ArmR3);
/*  93 */     this.Body2.func_78792_a(this.Body3);
/*  94 */     this.ArmR1.func_78792_a(this.ArmR2);
/*  95 */     this.Head.func_78792_a(this.EarL);
/*  96 */     this.Head.func_78792_a(this.Nose);
/*  97 */     this.Head.func_78792_a(this.EarR);
/*  98 */     this.Body1.func_78792_a(this.Body2);
/*  99 */     this.ArmL1.func_78792_a(this.ArmL2);
/* 100 */     this.ArmL2.func_78792_a(this.ArmL3);
/* 101 */     this.Head.func_78792_a(this.Moustache);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 106 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 108 */     GL11.glPushMatrix();
/* 109 */     float F = 1.4F;
/* 110 */     JGRenderHelper.modelScalePositionHelper(1.4F);
/*     */     
/* 112 */     this.LegL.func_78785_a(f5);
/* 113 */     this.Head.func_78785_a(f5);
/* 114 */     this.ArmL1.func_78785_a(f5);
/* 115 */     this.ArmR1.func_78785_a(f5);
/* 116 */     this.Body1.func_78785_a(f5);
/* 117 */     this.LegR.func_78785_a(f5);
/* 118 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 124 */     modelRenderer.field_78795_f = x;
/* 125 */     modelRenderer.field_78796_g = y;
/* 126 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 130 */     int calc = par7Entity.field_70173_aa;
/* 131 */     if (calc > 100) calc -= 100; 
/* 132 */     float r = 360.0F;
/* 133 */     float r2 = 180.0F;
/* 134 */     float n4 = par4;
/* 135 */     float n5 = par5;
/*     */     
/* 137 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 138 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 139 */     float ex = par7Entity.field_70173_aa;
/* 140 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 141 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 143 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 144 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 190 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 191 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 192 */     this.ArmR1.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 193 */     this.ArmL1.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 195 */     this.LegR.field_78796_g = 0.0F;
/* 196 */     this.LegL.field_78796_g = 0.0F;
/* 197 */     this.ArmR1.field_78796_g = 0.0F;
/* 198 */     this.ArmL1.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 205 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelToppo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */