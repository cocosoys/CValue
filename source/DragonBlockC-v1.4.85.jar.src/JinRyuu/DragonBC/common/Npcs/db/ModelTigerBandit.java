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
/*     */ public class ModelTigerBandit
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
/*     */   public ModelRenderer MuttonchopsR;
/*     */   public ModelRenderer MuttonchopsL;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Armor;
/*     */   public ModelRenderer Sheat;
/*     */   public ModelRenderer ArmR2;
/*     */   public ModelRenderer ShoulderSpikeR;
/*     */   public ModelRenderer Sword1;
/*     */   public ModelRenderer Hilt1;
/*     */   public ModelRenderer ArmL2;
/*     */   public ModelRenderer ShoulderSpikeL;
/*     */   
/*     */   public ModelTigerBandit() {
/*  36 */     this.field_78090_t = 128;
/*  37 */     this.field_78089_u = 64;
/*  38 */     this.MuttonchopsL = new ModelRenderer(this, 55, 8);
/*  39 */     this.MuttonchopsL.field_78809_i = true;
/*  40 */     this.MuttonchopsL.func_78793_a(3.5F, -3.5F, -0.8F);
/*  41 */     this.MuttonchopsL.func_78790_a(0.0F, -0.2F, 0.0F, 2, 4, 0, 0.0F);
/*  42 */     setRotateAngle(this.MuttonchopsL, 0.0F, -0.6981317F, -0.08726646F);
/*  43 */     this.Sheat = new ModelRenderer(this, 48, 18);
/*  44 */     this.Sheat.func_78793_a(7.3F, 13.0F, 1.0F);
/*  45 */     this.Sheat.func_78790_a(0.0F, -2.6F, -5.2F, 1, 5, 15, 0.0F);
/*  46 */     setRotateAngle(this.Sheat, -0.3642502F, -0.03508112F, 0.0F);
/*  47 */     this.ArmL1 = new ModelRenderer(this, 92, 1);
/*  48 */     this.ArmL1.field_78809_i = true;
/*  49 */     this.ArmL1.func_78793_a(8.8F, -3.2F, 1.7F);
/*  50 */     this.ArmL1.func_78790_a(-1.5F, -2.0F, -2.5F, 5, 8, 5, 0.0F);
/*  51 */     setRotateAngle(this.ArmL1, 0.0F, 0.0F, -0.20943952F);
/*  52 */     this.ShoulderSpikeR = new ModelRenderer(this, 89, 1);
/*  53 */     this.ShoulderSpikeR.func_78793_a(-1.0F, -1.6F, 0.0F);
/*  54 */     this.ShoulderSpikeR.func_78790_a(-1.5F, -3.3F, 0.0F, 3, 3, 0, 0.0F);
/*  55 */     this.ShoulderSpikeL = new ModelRenderer(this, 89, 1);
/*  56 */     this.ShoulderSpikeL.field_78809_i = true;
/*  57 */     this.ShoulderSpikeL.func_78793_a(1.0F, -1.6F, 0.0F);
/*  58 */     this.ShoulderSpikeL.func_78790_a(-1.5F, -3.3F, 0.0F, 3, 3, 0, 0.0F);
/*  59 */     this.Body1 = new ModelRenderer(this, 0, 18);
/*  60 */     this.Body1.func_78793_a(0.0F, -5.0F, 0.0F);
/*  61 */     this.Body1.func_78790_a(-7.5F, 0.0F, -2.4F, 15, 8, 8, 0.0F);
/*  62 */     this.Body2 = new ModelRenderer(this, 0, 38);
/*  63 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  64 */     this.Body2.func_78790_a(-7.5F, 8.0F, -3.1F, 15, 7, 9, 0.0F);
/*  65 */     this.ArmR2 = new ModelRenderer(this, 90, 15);
/*  66 */     this.ArmR2.func_78793_a(-0.6F, 5.3F, -0.3F);
/*  67 */     this.ArmR2.func_78790_a(-3.5F, -0.5F, -2.5F, 6, 9, 6, 0.0F);
/*  68 */     setRotateAngle(this.ArmR2, -0.4098033F, 0.0F, -0.08726646F);
/*  69 */     this.Head = new ModelRenderer(this, 0, 0);
/*  70 */     this.Head.func_78793_a(0.0F, -4.5F, 0.6F);
/*  71 */     this.Head.func_78790_a(-4.0F, -6.0F, -4.0F, 8, 6, 8, 0.0F);
/*  72 */     this.MuttonchopsR = new ModelRenderer(this, 55, 8);
/*  73 */     this.MuttonchopsR.func_78793_a(-3.5F, -3.5F, -0.8F);
/*  74 */     this.MuttonchopsR.func_78790_a(-2.0F, -0.4F, 0.0F, 2, 4, 0, 0.0F);
/*  75 */     setRotateAngle(this.MuttonchopsR, 0.0F, 0.6981317F, 0.08726646F);
/*  76 */     this.ArmR1 = new ModelRenderer(this, 92, 1);
/*  77 */     this.ArmR1.func_78793_a(-8.8F, -3.2F, 1.7F);
/*  78 */     this.ArmR1.func_78790_a(-3.5F, -2.0F, -2.5F, 5, 8, 5, 0.0F);
/*  79 */     setRotateAngle(this.ArmR1, 0.0F, 0.0F, 0.20943952F);
/*  80 */     this.Sword1 = new ModelRenderer(this, 46, -6);
/*  81 */     this.Sword1.func_78793_a(0.0F, 6.9F, -0.6F);
/*  82 */     this.Sword1.func_78790_a(0.0F, -2.6F, -13.8F, 0, 5, 19, 0.0F);
/*  83 */     this.ArmL2 = new ModelRenderer(this, 90, 15);
/*  84 */     this.ArmL2.field_78809_i = true;
/*  85 */     this.ArmL2.func_78793_a(0.6F, 5.3F, -0.3F);
/*  86 */     this.ArmL2.func_78790_a(-2.5F, -0.5F, -2.5F, 6, 9, 6, 0.0F);
/*  87 */     setRotateAngle(this.ArmL2, -0.4098033F, 0.0F, 0.08726646F);
/*  88 */     this.LegL = new ModelRenderer(this, 91, 36);
/*  89 */     this.LegL.field_78809_i = true;
/*  90 */     this.LegL.func_78793_a(3.6F, 10.0F, 1.0F);
/*  91 */     this.LegL.func_78790_a(-3.5F, 0.0F, -3.5F, 7, 14, 8, 0.1F);
/*  92 */     this.Nose = new ModelRenderer(this, 46, 0);
/*  93 */     this.Nose.func_78793_a(0.0F, -2.0F, -2.1F);
/*  94 */     this.Nose.func_78790_a(-2.0F, -1.0F, -4.6F, 4, 3, 4, 0.0F);
/*  95 */     this.EarR = new ModelRenderer(this, 47, 8);
/*  96 */     this.EarR.func_78793_a(-3.8F, -5.4F, -1.0F);
/*  97 */     this.EarR.func_78790_a(-2.5F, -1.5F, 0.0F, 3, 2, 0, 0.0F);
/*  98 */     setRotateAngle(this.EarR, 0.0F, 0.34906584F, 0.34906584F);
/*  99 */     this.Armor = new ModelRenderer(this, 49, 42);
/* 100 */     this.Armor.func_78793_a(0.0F, 15.0F, -3.1F);
/* 101 */     this.Armor.func_78790_a(-3.5F, 0.0F, 0.0F, 7, 6, 0, 0.0F);
/* 102 */     this.EarL = new ModelRenderer(this, 47, 8);
/* 103 */     this.EarL.field_78809_i = true;
/* 104 */     this.EarL.func_78793_a(3.2F, -5.4F, -1.0F);
/* 105 */     this.EarL.func_78790_a(0.0F, -1.5F, 0.0F, 3, 2, 0, 0.0F);
/* 106 */     setRotateAngle(this.EarL, 0.0F, -0.34906584F, -0.34906584F);
/* 107 */     this.Hilt1 = new ModelRenderer(this, 48, 25);
/* 108 */     this.Hilt1.func_78793_a(0.0F, 0.2F, -2.2F);
/* 109 */     this.Hilt1.func_78790_a(-2.5F, -2.8F, 0.0F, 5, 5, 0, 0.0F);
/* 110 */     this.LegR = new ModelRenderer(this, 91, 36);
/* 111 */     this.LegR.func_78793_a(-3.6F, 10.0F, 1.0F);
/* 112 */     this.LegR.func_78790_a(-3.5F, 0.0F, -3.5F, 7, 14, 8, 0.1F);
/* 113 */     this.Head.func_78792_a(this.MuttonchopsL);
/* 114 */     this.Body2.func_78792_a(this.Sheat);
/* 115 */     this.ArmR1.func_78792_a(this.ShoulderSpikeR);
/* 116 */     this.ArmL1.func_78792_a(this.ShoulderSpikeL);
/* 117 */     this.Body1.func_78792_a(this.Body2);
/* 118 */     this.ArmR1.func_78792_a(this.ArmR2);
/* 119 */     this.Head.func_78792_a(this.MuttonchopsR);
/* 120 */     this.ArmR2.func_78792_a(this.Sword1);
/* 121 */     this.ArmL1.func_78792_a(this.ArmL2);
/* 122 */     this.Head.func_78792_a(this.Nose);
/* 123 */     this.Head.func_78792_a(this.EarR);
/* 124 */     this.Body2.func_78792_a(this.Armor);
/* 125 */     this.Head.func_78792_a(this.EarL);
/* 126 */     this.Sword1.func_78792_a(this.Hilt1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 131 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 133 */     GL11.glPushMatrix();
/* 134 */     float F = 1.5F;
/* 135 */     JGRenderHelper.modelScalePositionHelper(1.5F);
/*     */     
/* 137 */     this.Head.func_78785_a(f5);
/* 138 */     this.Body1.func_78785_a(f5);
/* 139 */     this.ArmR1.func_78785_a(f5);
/* 140 */     this.ArmL1.func_78785_a(f5);
/* 141 */     this.LegL.func_78785_a(f5);
/* 142 */     this.LegR.func_78785_a(f5);
/*     */     
/* 144 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 148 */     modelRenderer.field_78795_f = x;
/* 149 */     modelRenderer.field_78796_g = y;
/* 150 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 154 */     int calc = par7Entity.field_70173_aa;
/* 155 */     if (calc > 100) calc -= 100; 
/* 156 */     float r = 360.0F;
/* 157 */     float r2 = 180.0F;
/* 158 */     float n4 = par4;
/* 159 */     float n5 = par5;
/*     */     
/* 161 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 162 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 163 */     float ex = par7Entity.field_70173_aa;
/* 164 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 165 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 167 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 168 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
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
/* 217 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 218 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 219 */     this.ArmR1.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 220 */     this.ArmL1.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 222 */     this.LegR.field_78796_g = 0.0F;
/* 223 */     this.LegL.field_78796_g = 0.0F;
/* 224 */     this.ArmR1.field_78796_g = 0.0F;
/* 225 */     this.ArmL1.field_78796_g = 0.0F;
/*     */     
/* 227 */     this.Armor.field_78795_f = -0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\db\ModelTigerBandit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */