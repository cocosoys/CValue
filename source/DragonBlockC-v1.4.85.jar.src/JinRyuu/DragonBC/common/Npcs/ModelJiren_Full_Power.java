/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import JinRyuu.JRMCore.client.JGRenderHelper;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class ModelJiren_Full_Power
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmR1;
/*     */   public ModelRenderer ArmL1;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer EarL;
/*     */   public ModelRenderer EarR;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer Chest;
/*     */   public ModelRenderer TornCloth;
/*     */   public ModelRenderer ArmR2;
/*     */   public ModelRenderer ArmR3;
/*     */   public ModelRenderer ArmL2;
/*     */   public ModelRenderer ArmL3;
/*     */   
/*     */   public ModelJiren_Full_Power() {
/*  31 */     this.field_78090_t = 128;
/*  32 */     this.field_78089_u = 64;
/*  33 */     this.Body1 = new ModelRenderer(this, 0, 17);
/*  34 */     this.Body1.func_78793_a(0.0F, -8.5F, 0.0F);
/*  35 */     this.Body1.func_78790_a(-7.5F, 0.0F, -3.3F, 15, 8, 7, 0.0F);
/*  36 */     this.ArmR1 = new ModelRenderer(this, 63, 5);
/*  37 */     this.ArmR1.func_78793_a(-8.0F, -5.2F, 0.0F);
/*  38 */     this.ArmR1.func_78790_a(-5.3F, -3.3F, -3.0F, 6, 6, 7, 0.0F);
/*  39 */     this.LegL = new ModelRenderer(this, 41, 41);
/*  40 */     this.LegL.field_78809_i = true;
/*  41 */     this.LegL.func_78793_a(3.0F, 8.5F, 0.0F);
/*  42 */     this.LegL.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 16, 6, 0.0F);
/*  43 */     this.Body2 = new ModelRenderer(this, 0, 34);
/*  44 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  45 */     this.Body2.func_78790_a(-6.0F, 6.0F, -3.5F, 12, 6, 6, 0.0F);
/*  46 */     this.Body3 = new ModelRenderer(this, 0, 48);
/*  47 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  48 */     this.Body3.func_78790_a(-6.0F, 12.0F, -3.0F, 12, 5, 6, 0.0F);
/*  49 */     this.EarL = new ModelRenderer(this, 33, 8);
/*  50 */     this.EarL.field_78809_i = true;
/*  51 */     this.EarL.func_78793_a(4.0F, -4.2F, 0.4F);
/*  52 */     this.EarL.func_78790_a(0.0F, -1.5F, -1.6F, 1, 3, 3, 0.0F);
/*  53 */     this.LegR = new ModelRenderer(this, 41, 41);
/*  54 */     this.LegR.func_78793_a(-3.0F, 8.5F, 0.0F);
/*  55 */     this.LegR.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 16, 6, 0.0F);
/*  56 */     this.ArmL3 = new ModelRenderer(this, 67, 31);
/*  57 */     this.ArmL3.field_78809_i = true;
/*  58 */     this.ArmL3.func_78793_a(0.0F, 4.3F, -0.2F);
/*  59 */     this.ArmL3.func_78790_a(-2.5F, 0.0F, -1.8F, 5, 9, 5, 0.0F);
/*  60 */     this.TornCloth = new ModelRenderer(this, 68, 48);
/*  61 */     this.TornCloth.func_78793_a(0.0F, 0.0F, 0.0F);
/*  62 */     this.TornCloth.func_78790_a(-6.5F, 12.4F, -3.5F, 13, 1, 7, 0.0F);
/*  63 */     this.ArmR3 = new ModelRenderer(this, 67, 31);
/*  64 */     this.ArmR3.func_78793_a(0.0F, 4.3F, -0.2F);
/*  65 */     this.ArmR3.func_78790_a(-2.5F, 0.0F, -1.9F, 5, 9, 5, 0.0F);
/*  66 */     this.Chest = new ModelRenderer(this, 38, 33);
/*  67 */     this.Chest.func_78793_a(0.0F, 0.0F, 0.0F);
/*  68 */     this.Chest.func_78790_a(-6.0F, 1.2F, -4.1F, 12, 6, 1, 0.0F);
/*  69 */     this.EarR = new ModelRenderer(this, 33, 8);
/*  70 */     this.EarR.func_78793_a(-4.0F, -4.2F, 0.4F);
/*  71 */     this.EarR.func_78790_a(-1.0F, -1.5F, -1.6F, 1, 3, 3, 0.0F);
/*  72 */     this.ArmR2 = new ModelRenderer(this, 65, 19);
/*  73 */     this.ArmR2.func_78793_a(-2.0F, 2.0F, 0.0F);
/*  74 */     this.ArmR2.func_78790_a(-2.7F, -0.2F, -2.5F, 5, 5, 6, 0.0F);
/*  75 */     this.ArmL2 = new ModelRenderer(this, 65, 19);
/*  76 */     this.ArmL2.field_78809_i = true;
/*  77 */     this.ArmL2.func_78793_a(2.0F, 2.0F, 0.0F);
/*  78 */     this.ArmL2.func_78790_a(-2.3F, -0.2F, -2.5F, 5, 5, 6, 0.0F);
/*  79 */     this.Head = new ModelRenderer(this, 0, 0);
/*  80 */     this.Head.func_78793_a(0.0F, -8.5F, -0.5F);
/*  81 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
/*  82 */     this.ArmL1 = new ModelRenderer(this, 63, 5);
/*  83 */     this.ArmL1.field_78809_i = true;
/*  84 */     this.ArmL1.func_78793_a(8.0F, -5.2F, 0.0F);
/*  85 */     this.ArmL1.func_78790_a(-0.7F, -3.3F, -3.0F, 6, 6, 7, 0.0F);
/*  86 */     this.Body1.func_78792_a(this.Body2);
/*  87 */     this.Body2.func_78792_a(this.Body3);
/*  88 */     this.Head.func_78792_a(this.EarL);
/*  89 */     this.ArmL2.func_78792_a(this.ArmL3);
/*  90 */     this.Body3.func_78792_a(this.TornCloth);
/*  91 */     this.ArmR2.func_78792_a(this.ArmR3);
/*  92 */     this.Body2.func_78792_a(this.Chest);
/*  93 */     this.Head.func_78792_a(this.EarR);
/*  94 */     this.ArmR1.func_78792_a(this.ArmR2);
/*  95 */     this.ArmL1.func_78792_a(this.ArmL2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 100 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 102 */     GL11.glPushMatrix();
/* 103 */     float F = 1.1F;
/* 104 */     JGRenderHelper.modelScalePositionHelper(1.1F);
/*     */     
/* 106 */     this.LegL.func_78785_a(f5);
/* 107 */     this.Head.func_78785_a(f5);
/* 108 */     this.ArmL1.func_78785_a(f5);
/* 109 */     this.ArmR1.func_78785_a(f5);
/* 110 */     this.Body1.func_78785_a(f5);
/* 111 */     this.LegR.func_78785_a(f5);
/* 112 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 118 */     modelRenderer.field_78795_f = x;
/* 119 */     modelRenderer.field_78796_g = y;
/* 120 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 124 */     int calc = par7Entity.field_70173_aa;
/* 125 */     if (calc > 100) calc -= 100; 
/* 126 */     float r = 360.0F;
/* 127 */     float r2 = 180.0F;
/* 128 */     float n4 = par4;
/* 129 */     float n5 = par5;
/*     */     
/* 131 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 132 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 133 */     float ex = par7Entity.field_70173_aa;
/* 134 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 135 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 137 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 138 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
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
/* 184 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 185 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 186 */     this.ArmR1.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 187 */     this.ArmL1.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 189 */     this.LegR.field_78796_g = 0.0F;
/* 190 */     this.LegL.field_78796_g = 0.0F;
/* 191 */     this.ArmR1.field_78796_g = 0.0F;
/* 192 */     this.ArmL1.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 199 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelJiren_Full_Power.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */