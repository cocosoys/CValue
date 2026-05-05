/*     */ package JinRyuu.DragonBC.common.Npcs.db;
/*     */ 
/*     */ import JinRyuu.JRMCore.client.JGRenderHelper;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ public class ModelBearThief
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmR1;
/*     */   public ModelRenderer ArmL1;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer Nose;
/*     */   public ModelRenderer EarR;
/*     */   public ModelRenderer EarL;
/*     */   public ModelRenderer Hair;
/*     */   public ModelRenderer MuttonchopsR;
/*     */   public ModelRenderer MuttonchopsL;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Armor;
/*     */   public ModelRenderer Sheat;
/*     */   public ModelRenderer ArmR2;
/*     */   public ModelRenderer Sword1;
/*     */   public ModelRenderer Hilt1;
/*     */   public ModelRenderer ArmL2;
/*     */   
/*     */   public ModelBearThief() {
/*  35 */     this.field_78090_t = 128;
/*  36 */     this.field_78089_u = 64;
/*  37 */     this.ArmL2 = new ModelRenderer(this, 90, 15);
/*  38 */     this.ArmL2.field_78809_i = true;
/*  39 */     this.ArmL2.func_78793_a(0.6F, 5.3F, -0.3F);
/*  40 */     this.ArmL2.func_78790_a(-2.5F, -0.5F, -2.5F, 6, 9, 6, 0.0F);
/*  41 */     setRotateAngle(this.ArmL2, -0.4098033F, 0.0F, 0.08726646F);
/*  42 */     this.Hair = new ModelRenderer(this, 34, 4);
/*  43 */     this.Hair.func_78793_a(0.0F, -5.0F, -0.5F);
/*  44 */     this.Hair.func_78790_a(-0.5F, -3.0F, -4.0F, 1, 3, 7, 0.0F);
/*  45 */     setRotateAngle(this.Hair, -0.13665928F, 0.0F, 0.0F);
/*  46 */     this.LegR = new ModelRenderer(this, 91, 36);
/*  47 */     this.LegR.func_78793_a(-3.6F, 10.0F, 1.0F);
/*  48 */     this.LegR.func_78790_a(-3.5F, 0.0F, -3.5F, 7, 14, 8, 0.1F);
/*  49 */     this.LegL = new ModelRenderer(this, 91, 36);
/*  50 */     this.LegL.field_78809_i = true;
/*  51 */     this.LegL.func_78793_a(3.6F, 10.0F, 1.0F);
/*  52 */     this.LegL.func_78790_a(-3.5F, 0.0F, -3.5F, 7, 14, 8, 0.1F);
/*  53 */     this.EarR = new ModelRenderer(this, 47, 8);
/*  54 */     this.EarR.func_78793_a(-3.8F, -4.4F, -1.0F);
/*  55 */     this.EarR.func_78790_a(-2.5F, -1.5F, 0.0F, 3, 2, 0, 0.0F);
/*  56 */     setRotateAngle(this.EarR, 0.0F, 0.34906584F, -0.04363323F);
/*  57 */     this.Nose = new ModelRenderer(this, 46, 0);
/*  58 */     this.Nose.func_78793_a(0.0F, -2.0F, -2.8F);
/*  59 */     this.Nose.func_78790_a(-2.0F, -1.0F, -4.6F, 4, 3, 4, 0.0F);
/*  60 */     this.Body2 = new ModelRenderer(this, 0, 38);
/*  61 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  62 */     this.Body2.func_78790_a(-7.5F, 8.0F, -3.1F, 15, 7, 9, 0.0F);
/*  63 */     this.MuttonchopsR = new ModelRenderer(this, 55, 8);
/*  64 */     this.MuttonchopsR.func_78793_a(-3.5F, -3.5F, -2.1F);
/*  65 */     this.MuttonchopsR.func_78790_a(-2.0F, -0.4F, 0.0F, 2, 4, 0, 0.0F);
/*  66 */     setRotateAngle(this.MuttonchopsR, 0.0F, 0.6981317F, 0.08726646F);
/*  67 */     this.MuttonchopsL = new ModelRenderer(this, 55, 8);
/*  68 */     this.MuttonchopsL.field_78809_i = true;
/*  69 */     this.MuttonchopsL.func_78793_a(3.5F, -3.5F, -2.1F);
/*  70 */     this.MuttonchopsL.func_78790_a(0.0F, -0.2F, 0.0F, 2, 4, 0, 0.0F);
/*  71 */     setRotateAngle(this.MuttonchopsL, 0.0F, -0.6981317F, -0.08726646F);
/*  72 */     this.Armor = new ModelRenderer(this, 49, 42);
/*  73 */     this.Armor.func_78793_a(0.0F, 15.0F, -3.1F);
/*  74 */     this.Armor.func_78790_a(-3.5F, 0.0F, 0.0F, 7, 6, 0, 0.0F);
/*  75 */     this.ArmR2 = new ModelRenderer(this, 90, 15);
/*  76 */     this.ArmR2.func_78793_a(-0.6F, 5.3F, -0.3F);
/*  77 */     this.ArmR2.func_78790_a(-3.5F, -0.5F, -2.5F, 6, 9, 6, 0.0F);
/*  78 */     setRotateAngle(this.ArmR2, -0.4098033F, 0.0F, -0.08726646F);
/*  79 */     this.Hilt1 = new ModelRenderer(this, 48, 27);
/*  80 */     this.Hilt1.func_78793_a(0.0F, 0.2F, -2.2F);
/*  81 */     this.Hilt1.func_78790_a(-2.5F, -2.8F, 0.0F, 5, 5, 0, 0.0F);
/*  82 */     this.EarL = new ModelRenderer(this, 47, 8);
/*  83 */     this.EarL.field_78809_i = true;
/*  84 */     this.EarL.func_78793_a(3.2F, -4.4F, -1.0F);
/*  85 */     this.EarL.func_78790_a(0.0F, -1.5F, 0.0F, 3, 2, 0, 0.0F);
/*  86 */     setRotateAngle(this.EarL, 0.0F, -0.34906584F, 0.04363323F);
/*  87 */     this.Head = new ModelRenderer(this, 0, 0);
/*  88 */     this.Head.func_78793_a(0.0F, -4.5F, 0.6F);
/*  89 */     this.Head.func_78790_a(-4.0F, -6.0F, -4.0F, 8, 6, 8, 0.0F);
/*  90 */     this.ArmR1 = new ModelRenderer(this, 92, 1);
/*  91 */     this.ArmR1.func_78793_a(-8.8F, -3.2F, 1.7F);
/*  92 */     this.ArmR1.func_78790_a(-3.5F, -2.0F, -2.5F, 5, 8, 5, 0.0F);
/*  93 */     setRotateAngle(this.ArmR1, 0.0F, 0.0F, 0.20943952F);
/*  94 */     this.Body1 = new ModelRenderer(this, 0, 18);
/*  95 */     this.Body1.func_78793_a(0.0F, -5.0F, 0.0F);
/*  96 */     this.Body1.func_78790_a(-7.5F, 0.0F, -2.4F, 15, 8, 8, 0.0F);
/*  97 */     this.ArmL1 = new ModelRenderer(this, 92, 1);
/*  98 */     this.ArmL1.field_78809_i = true;
/*  99 */     this.ArmL1.func_78793_a(8.8F, -3.2F, 1.7F);
/* 100 */     this.ArmL1.func_78790_a(-1.5F, -2.0F, -2.5F, 5, 8, 5, 0.0F);
/* 101 */     setRotateAngle(this.ArmL1, 0.0F, 0.0F, -0.20943952F);
/* 102 */     this.Sheat = new ModelRenderer(this, 48, 21);
/* 103 */     this.Sheat.func_78793_a(7.3F, 13.0F, 1.0F);
/* 104 */     this.Sheat.func_78790_a(0.0F, -2.6F, -5.2F, 1, 5, 15, 0.0F);
/* 105 */     setRotateAngle(this.Sheat, -0.3642502F, -0.03508112F, 0.0F);
/* 106 */     this.Sword1 = new ModelRenderer(this, 47, -4);
/* 107 */     this.Sword1.func_78793_a(0.0F, 6.9F, -0.6F);
/* 108 */     this.Sword1.func_78790_a(0.0F, -2.6F, -13.8F, 0, 5, 19, 0.0F);
/* 109 */     this.ArmL1.func_78792_a(this.ArmL2);
/* 110 */     this.Head.func_78792_a(this.Hair);
/* 111 */     this.Head.func_78792_a(this.EarR);
/* 112 */     this.Head.func_78792_a(this.Nose);
/* 113 */     this.Body1.func_78792_a(this.Body2);
/* 114 */     this.Head.func_78792_a(this.MuttonchopsR);
/* 115 */     this.Head.func_78792_a(this.MuttonchopsL);
/* 116 */     this.Body2.func_78792_a(this.Armor);
/* 117 */     this.ArmR1.func_78792_a(this.ArmR2);
/* 118 */     this.Sword1.func_78792_a(this.Hilt1);
/* 119 */     this.Head.func_78792_a(this.EarL);
/* 120 */     this.Body2.func_78792_a(this.Sheat);
/* 121 */     this.ArmR2.func_78792_a(this.Sword1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 126 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 128 */     GL11.glPushMatrix();
/* 129 */     float F = 1.5F;
/* 130 */     JGRenderHelper.modelScalePositionHelper(1.5F);
/*     */     
/* 132 */     this.Head.func_78785_a(f5);
/* 133 */     this.Body1.func_78785_a(f5);
/* 134 */     this.ArmR1.func_78785_a(f5);
/* 135 */     this.ArmL1.func_78785_a(f5);
/* 136 */     this.LegL.func_78785_a(f5);
/* 137 */     this.LegR.func_78785_a(f5);
/*     */     
/* 139 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 143 */     modelRenderer.field_78795_f = x;
/* 144 */     modelRenderer.field_78796_g = y;
/* 145 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 149 */     int calc = par7Entity.field_70173_aa;
/* 150 */     if (calc > 100) calc -= 100; 
/* 151 */     float r = 360.0F;
/* 152 */     float r2 = 180.0F;
/* 153 */     float n4 = par4;
/* 154 */     float n5 = par5;
/*     */     
/* 156 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 157 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 158 */     float ex = par7Entity.field_70173_aa;
/* 159 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 160 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 162 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 163 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
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
/*     */ 
/*     */ 
/*     */     
/* 212 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 213 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 214 */     this.ArmR1.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 215 */     this.ArmL1.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 217 */     this.LegR.field_78796_g = 0.0F;
/* 218 */     this.LegL.field_78796_g = 0.0F;
/* 219 */     this.ArmR1.field_78796_g = 0.0F;
/* 220 */     this.ArmL1.field_78796_g = 0.0F;
/*     */     
/* 222 */     this.Armor.field_78795_f = -0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\db\ModelBearThief.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */