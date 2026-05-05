/*     */ package JinRyuu.DragonBC.common.Npcs.dbredribbon;
/*     */ 
/*     */ import JinRyuu.JRMCore.client.JGRenderHelper;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ public class ModelBuyon
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer tail1;
/*     */   public ModelRenderer Head2;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Chest;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer Body4;
/*     */   public ModelRenderer ArmR2;
/*     */   public ModelRenderer ArmL2;
/*     */   public ModelRenderer tail2;
/*     */   public ModelRenderer tail3;
/*     */   public ModelRenderer tail4;
/*     */   public ModelRenderer tail5;
/*     */   
/*     */   public ModelBuyon() {
/*  34 */     this.field_78090_t = 128;
/*  35 */     this.field_78089_u = 128;
/*  36 */     this.tail3 = new ModelRenderer(this, 88, 116);
/*  37 */     this.tail3.func_78793_a(0.0F, 0.0F, 4.9F);
/*  38 */     this.tail3.func_78790_a(-2.0F, -2.0F, 0.0F, 4, 4, 6, 0.0F);
/*  39 */     this.ArmR = new ModelRenderer(this, 92, 3);
/*  40 */     this.ArmR.func_78793_a(-8.8F, 2.5F, 2.0F);
/*  41 */     this.ArmR.func_78790_a(-3.5F, -2.0F, -2.5F, 5, 9, 5, 0.0F);
/*  42 */     setRotateAngle(this.ArmR, 0.0F, 0.0F, 0.38397244F);
/*  43 */     this.tail2 = new ModelRenderer(this, 67, 116);
/*  44 */     this.tail2.func_78793_a(0.0F, -0.2F, 5.9F);
/*  45 */     this.tail2.func_78790_a(-2.5F, -2.5F, 0.0F, 5, 5, 5, 0.0F);
/*  46 */     this.Body4 = new ModelRenderer(this, 0, 88);
/*  47 */     this.Body4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  48 */     this.Body4.func_78790_a(-7.0F, 20.0F, -3.2F, 14, 2, 9, 0.0F);
/*  49 */     this.Body1 = new ModelRenderer(this, 0, 26);
/*  50 */     this.Body1.func_78793_a(0.0F, -0.1F, 0.0F);
/*  51 */     this.Body1.func_78790_a(-8.0F, 0.0F, -2.4F, 16, 7, 9, 0.0F);
/*  52 */     this.ArmL = new ModelRenderer(this, 92, 3);
/*  53 */     this.ArmL.field_78809_i = true;
/*  54 */     this.ArmL.func_78793_a(8.8F, 2.5F, 2.0F);
/*  55 */     this.ArmL.func_78790_a(-1.5F, -2.0F, -2.5F, 5, 9, 5, 0.0F);
/*  56 */     setRotateAngle(this.ArmL, 0.0F, 0.0F, -0.38397244F);
/*  57 */     this.Body2 = new ModelRenderer(this, 0, 46);
/*  58 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  59 */     this.Body2.func_78790_a(-9.0F, 7.0F, -4.1F, 18, 4, 11, 0.0F);
/*  60 */     this.tail5 = new ModelRenderer(this, 111, 109);
/*  61 */     this.tail5.func_78793_a(0.0F, 0.0F, 5.9F);
/*  62 */     this.tail5.func_78790_a(-1.0F, -1.0F, 0.0F, 2, 2, 5, 0.0F);
/*  63 */     this.ArmL2 = new ModelRenderer(this, 90, 19);
/*  64 */     this.ArmL2.field_78809_i = true;
/*  65 */     this.ArmL2.func_78793_a(0.8F, 7.1F, -0.3F);
/*  66 */     this.ArmL2.func_78790_a(-2.8F, -0.5F, -2.5F, 6, 9, 6, 0.0F);
/*  67 */     setRotateAngle(this.ArmL2, -0.4098033F, 0.0F, 0.08726646F);
/*  68 */     this.ArmR2 = new ModelRenderer(this, 90, 19);
/*  69 */     this.ArmR2.func_78793_a(-0.6F, 7.1F, -0.3F);
/*  70 */     this.ArmR2.func_78790_a(-3.5F, -0.5F, -2.5F, 6, 9, 6, 0.0F);
/*  71 */     setRotateAngle(this.ArmR2, -0.4098033F, 0.0F, -0.08726646F);
/*  72 */     this.tail4 = new ModelRenderer(this, 109, 117);
/*  73 */     this.tail4.func_78793_a(0.0F, 0.0F, 5.9F);
/*  74 */     this.tail4.func_78790_a(-1.5F, -1.5F, 0.0F, 3, 3, 6, 0.0F);
/*  75 */     this.Chest = new ModelRenderer(this, 53, 43);
/*  76 */     this.Chest.func_78793_a(0.0F, 4.2F, -1.7F);
/*  77 */     this.Chest.func_78790_a(-7.0F, -1.9F, -1.4F, 14, 5, 2, 0.0F);
/*  78 */     setRotateAngle(this.Chest, -0.091106184F, 0.0F, 0.0F);
/*  79 */     this.LegR = new ModelRenderer(this, 91, 43);
/*  80 */     this.LegR.func_78793_a(-7.2F, 20.0F, 1.0F);
/*  81 */     this.LegR.func_78790_a(-3.5F, 0.0F, -3.5F, 7, 4, 8, 0.0F);
/*  82 */     this.tail1 = new ModelRenderer(this, 42, 114);
/*  83 */     this.tail1.func_78793_a(0.0F, 14.4F, 6.5F);
/*  84 */     this.tail1.func_78790_a(-3.0F, -3.0F, 0.0F, 6, 6, 6, 0.0F);
/*  85 */     this.Head2 = new ModelRenderer(this, 36, 2);
/*  86 */     this.Head2.func_78793_a(0.0F, -7.2F, -1.0F);
/*  87 */     this.Head2.func_78790_a(-5.8F, -7.0F, 0.0F, 12, 7, 0, 0.0F);
/*  88 */     setRotateAngle(this.Head2, 0.27314404F, 0.0F, 0.0F);
/*  89 */     this.Body3 = new ModelRenderer(this, 0, 64);
/*  90 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  91 */     this.Body3.func_78790_a(-10.0F, 10.6F, -4.5F, 20, 10, 12, 0.0F);
/*  92 */     this.Head = new ModelRenderer(this, 0, 0);
/*  93 */     this.Head.func_78793_a(0.0F, 0.6F, -0.5F);
/*  94 */     this.Head.func_78790_a(-4.0F, -7.2F, -4.0F, 8, 7, 8, 0.0F);
/*  95 */     this.LegL = new ModelRenderer(this, 91, 43);
/*  96 */     this.LegL.field_78809_i = true;
/*  97 */     this.LegL.func_78793_a(7.2F, 20.0F, 1.0F);
/*  98 */     this.LegL.func_78790_a(-3.5F, 0.0F, -3.5F, 7, 4, 8, 0.0F);
/*  99 */     this.tail2.func_78792_a(this.tail3);
/* 100 */     this.tail1.func_78792_a(this.tail2);
/* 101 */     this.Body3.func_78792_a(this.Body4);
/* 102 */     this.Body1.func_78792_a(this.Body2);
/* 103 */     this.tail4.func_78792_a(this.tail5);
/* 104 */     this.ArmL.func_78792_a(this.ArmL2);
/* 105 */     this.ArmR.func_78792_a(this.ArmR2);
/* 106 */     this.tail3.func_78792_a(this.tail4);
/* 107 */     this.Body1.func_78792_a(this.Chest);
/* 108 */     this.Head.func_78792_a(this.Head2);
/* 109 */     this.Body2.func_78792_a(this.Body3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 114 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 116 */     GL11.glPushMatrix();
/* 117 */     float F = 2.3F;
/* 118 */     JGRenderHelper.modelScalePositionHelper(2.3F);
/*     */     
/* 120 */     this.Head.func_78785_a(f5);
/* 121 */     this.Body1.func_78785_a(f5);
/* 122 */     this.ArmR.func_78785_a(f5);
/* 123 */     this.ArmL.func_78785_a(f5);
/* 124 */     this.LegL.func_78785_a(f5);
/* 125 */     this.LegR.func_78785_a(f5);
/* 126 */     this.tail1.func_78785_a(f5);
/*     */     
/* 128 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 132 */     modelRenderer.field_78795_f = x;
/* 133 */     modelRenderer.field_78796_g = y;
/* 134 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 138 */     int calc = par7Entity.field_70173_aa;
/* 139 */     if (calc > 100) calc -= 100; 
/* 140 */     float r = 360.0F;
/* 141 */     float r2 = 180.0F;
/* 142 */     float n4 = par4;
/* 143 */     float n5 = par5;
/*     */     
/* 145 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 146 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 147 */     float ex = par7Entity.field_70173_aa;
/* 148 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 149 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 151 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 152 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */     
/* 154 */     this.tail1.field_78795_f = 0.2F;
/* 155 */     this.tail1.field_78795_f += r4 / 2.0F;
/*     */     
/* 157 */     this.tail2.field_78795_f = 0.2F;
/* 158 */     this.tail2.field_78795_f += r4 / 2.0F;
/*     */     
/* 160 */     this.tail3.field_78795_f = 0.2F;
/* 161 */     this.tail3.field_78795_f += r4 / 2.0F;
/*     */     
/* 163 */     this.tail4.field_78795_f = 0.2F;
/* 164 */     this.tail4.field_78795_f += r4 / 2.0F;
/*     */     
/* 166 */     this.tail5.field_78796_g = 0.2F;
/* 167 */     this.tail5.field_78796_g += r4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 201 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 202 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 203 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 204 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 206 */     this.LegR.field_78796_g = 0.0F;
/* 207 */     this.LegL.field_78796_g = 0.0F;
/* 208 */     this.ArmR.field_78796_g = 0.0F;
/* 209 */     this.ArmL.field_78796_g = 0.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbredribbon\ModelBuyon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */