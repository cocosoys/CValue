/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import JinRyuu.JRMCore.client.JGRenderHelper;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class ModelToppo_GoD
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
/*     */   public ModelRenderer Chest;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer ArmR2;
/*     */   public ModelRenderer ArmR3;
/*     */   public ModelRenderer ArmL2;
/*     */   public ModelRenderer ArmL3;
/*     */   
/*     */   public ModelToppo_GoD() {
/*  32 */     this.field_78090_t = 128;
/*  33 */     this.field_78089_u = 64;
/*  34 */     this.LegR = new ModelRenderer(this, 44, 45);
/*  35 */     this.LegR.func_78793_a(-2.5F, 12.0F, 0.0F);
/*  36 */     this.LegR.func_78790_a(-3.0F, 0.0F, -3.0F, 5, 12, 6, 0.0F);
/*  37 */     this.EarR = new ModelRenderer(this, 33, 8);
/*  38 */     this.EarR.func_78793_a(-4.0F, -3.0F, -1.1F);
/*  39 */     this.EarR.func_78790_a(-1.4F, -3.0F, 0.0F, 2, 4, 0, 0.0F);
/*  40 */     setRotateAngle(this.EarR, 0.0F, 0.68294734F, -0.31869712F);
/*  41 */     this.Body1 = new ModelRenderer(this, 0, 17);
/*  42 */     this.Body1.func_78793_a(0.0F, -5.2F, 0.0F);
/*  43 */     this.Body1.func_78790_a(-7.0F, 0.0F, -3.6F, 14, 8, 8, 0.0F);
/*  44 */     this.EarL = new ModelRenderer(this, 33, 8);
/*  45 */     this.EarL.field_78809_i = true;
/*  46 */     this.EarL.func_78793_a(4.0F, -3.0F, -1.1F);
/*  47 */     this.EarL.func_78790_a(-0.5F, -3.0F, 0.0F, 2, 4, 0, 0.0F);
/*  48 */     setRotateAngle(this.EarL, 0.0F, -0.68294734F, 0.31869712F);
/*  49 */     this.ArmR1 = new ModelRenderer(this, 63, 5);
/*  50 */     this.ArmR1.func_78793_a(-8.0F, -2.0F, 0.5F);
/*  51 */     this.ArmR1.func_78790_a(-5.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
/*  52 */     this.Body3 = new ModelRenderer(this, 1, 53);
/*  53 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  54 */     this.Body3.func_78790_a(-6.0F, 13.0F, -4.3F, 12, 1, 8, 0.0F);
/*  55 */     this.ArmR2 = new ModelRenderer(this, 64, 18);
/*  56 */     this.ArmR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  57 */     this.ArmR2.func_78790_a(-4.5F, 2.8F, -2.5F, 5, 4, 5, 0.0F);
/*  58 */     this.Head = new ModelRenderer(this, 0, 0);
/*  59 */     this.Head.func_78793_a(0.0F, -4.9F, -0.9F);
/*  60 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
/*  61 */     this.Nose = new ModelRenderer(this, 0, 0);
/*  62 */     this.Nose.func_78793_a(0.0F, 0.0F, 0.0F);
/*  63 */     this.Nose.func_78790_a(-1.0F, -3.8F, -5.2F, 2, 2, 2, 0.0F);
/*  64 */     this.ArmR3 = new ModelRenderer(this, 63, 28);
/*  65 */     this.ArmR3.func_78793_a(-2.0F, 6.4F, 0.0F);
/*  66 */     this.ArmR3.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 9, 6, 0.0F);
/*  67 */     this.ArmL1 = new ModelRenderer(this, 63, 5);
/*  68 */     this.ArmL1.field_78809_i = true;
/*  69 */     this.ArmL1.func_78793_a(8.0F, -2.0F, 0.5F);
/*  70 */     this.ArmL1.func_78790_a(-1.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
/*  71 */     this.ArmL2 = new ModelRenderer(this, 64, 18);
/*  72 */     this.ArmL2.field_78809_i = true;
/*  73 */     this.ArmL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  74 */     this.ArmL2.func_78790_a(-0.5F, 2.8F, -2.5F, 5, 4, 5, 0.0F);
/*  75 */     this.Moustache = new ModelRenderer(this, 26, 0);
/*  76 */     this.Moustache.func_78793_a(0.0F, -2.5F, -4.2F);
/*  77 */     this.Moustache.func_78790_a(-4.5F, 0.0F, 0.0F, 9, 6, 0, 0.0F);
/*  78 */     this.Chest = new ModelRenderer(this, 32, 34);
/*  79 */     this.Chest.func_78793_a(0.0F, 0.0F, 0.0F);
/*  80 */     this.Chest.func_78790_a(-6.0F, 1.8F, -4.6F, 12, 5, 1, 0.0F);
/*  81 */     this.Body2 = new ModelRenderer(this, 0, 34);
/*  82 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  83 */     this.Body2.func_78790_a(-5.5F, 6.2F, -3.8F, 11, 11, 7, 0.0F);
/*  84 */     this.LegL = new ModelRenderer(this, 44, 45);
/*  85 */     this.LegL.field_78809_i = true;
/*  86 */     this.LegL.func_78793_a(2.5F, 12.0F, 0.0F);
/*  87 */     this.LegL.func_78790_a(-2.0F, 0.0F, -3.0F, 5, 12, 6, 0.0F);
/*  88 */     this.ArmL3 = new ModelRenderer(this, 63, 28);
/*  89 */     this.ArmL3.field_78809_i = true;
/*  90 */     this.ArmL3.func_78793_a(2.0F, 6.4F, 0.0F);
/*  91 */     this.ArmL3.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 9, 6, 0.0F);
/*  92 */     this.Head.func_78792_a(this.EarR);
/*  93 */     this.Head.func_78792_a(this.EarL);
/*  94 */     this.Body2.func_78792_a(this.Body3);
/*  95 */     this.ArmR1.func_78792_a(this.ArmR2);
/*  96 */     this.Head.func_78792_a(this.Nose);
/*  97 */     this.ArmR2.func_78792_a(this.ArmR3);
/*  98 */     this.ArmL1.func_78792_a(this.ArmL2);
/*  99 */     this.Head.func_78792_a(this.Moustache);
/* 100 */     this.Body2.func_78792_a(this.Chest);
/* 101 */     this.Body1.func_78792_a(this.Body2);
/* 102 */     this.ArmL2.func_78792_a(this.ArmL3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 107 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 109 */     GL11.glPushMatrix();
/* 110 */     float F = 1.6F;
/* 111 */     JGRenderHelper.modelScalePositionHelper(1.6F);
/*     */     
/* 113 */     this.LegL.func_78785_a(f5);
/* 114 */     this.Head.func_78785_a(f5);
/* 115 */     this.ArmL1.func_78785_a(f5);
/* 116 */     this.ArmR1.func_78785_a(f5);
/* 117 */     this.Body1.func_78785_a(f5);
/* 118 */     this.LegR.func_78785_a(f5);
/* 119 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 125 */     modelRenderer.field_78795_f = x;
/* 126 */     modelRenderer.field_78796_g = y;
/* 127 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 131 */     int calc = par7Entity.field_70173_aa;
/* 132 */     if (calc > 100) calc -= 100; 
/* 133 */     float r = 360.0F;
/* 134 */     float r2 = 180.0F;
/* 135 */     float n4 = par4;
/* 136 */     float n5 = par5;
/*     */     
/* 138 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 139 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 140 */     float ex = par7Entity.field_70173_aa;
/* 141 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 142 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 144 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 145 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 191 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 192 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 193 */     this.ArmR1.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 194 */     this.ArmL1.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 196 */     this.LegR.field_78796_g = 0.0F;
/* 197 */     this.LegL.field_78796_g = 0.0F;
/* 198 */     this.ArmR1.field_78796_g = 0.0F;
/* 199 */     this.ArmL1.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 206 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelToppo_GoD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */