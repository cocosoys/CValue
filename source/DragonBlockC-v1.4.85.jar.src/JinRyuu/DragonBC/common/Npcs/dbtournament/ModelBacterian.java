/*     */ package JinRyuu.DragonBC.common.Npcs.dbtournament;
/*     */ 
/*     */ import JinRyuu.JRMCore.client.JGRenderHelper;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ public class ModelBacterian
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmR1;
/*     */   public ModelRenderer ArmL1;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer HairSideR;
/*     */   public ModelRenderer HairSideL;
/*     */   public ModelRenderer hair;
/*     */   public ModelRenderer HairBack1;
/*     */   public ModelRenderer Hair1;
/*     */   public ModelRenderer Hair2;
/*     */   public ModelRenderer Hair3;
/*     */   public ModelRenderer HairBack2;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Chest;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer ArmR2;
/*     */   public ModelRenderer ArmL2;
/*     */   
/*     */   public ModelBacterian() {
/*  35 */     this.field_78090_t = 128;
/*  36 */     this.field_78089_u = 64;
/*  37 */     this.Body1 = new ModelRenderer(this, 0, 16);
/*  38 */     this.Body1.func_78793_a(0.0F, -6.5F, 0.0F);
/*  39 */     this.Body1.func_78790_a(-8.0F, 0.0F, -2.4F, 16, 7, 9, 0.0F);
/*  40 */     this.hair = new ModelRenderer(this, 0, 0);
/*  41 */     this.hair.func_78793_a(0.0F, 0.0F, 0.0F);
/*  42 */     this.hair.func_78790_a(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
/*  43 */     this.ArmR2 = new ModelRenderer(this, 90, 19);
/*  44 */     this.ArmR2.func_78793_a(-0.6F, 7.9F, -0.3F);
/*  45 */     this.ArmR2.func_78790_a(-3.5F, -0.5F, -2.5F, 6, 10, 6, 0.0F);
/*  46 */     setRotateAngle(this.ArmR2, -0.4098033F, 0.0F, -0.08726646F);
/*  47 */     this.ArmR1 = new ModelRenderer(this, 92, 3);
/*  48 */     this.ArmR1.func_78793_a(-8.2F, -4.3F, 2.0F);
/*  49 */     this.ArmR1.func_78790_a(-3.5F, -2.0F, -2.5F, 5, 10, 5, 0.0F);
/*  50 */     setRotateAngle(this.ArmR1, 0.0F, 0.0F, 0.38397244F);
/*  51 */     this.ArmL2 = new ModelRenderer(this, 90, 19);
/*  52 */     this.ArmL2.field_78809_i = true;
/*  53 */     this.ArmL2.func_78793_a(0.8F, 7.9F, -0.3F);
/*  54 */     this.ArmL2.func_78790_a(-2.8F, -0.5F, -2.5F, 6, 10, 6, 0.0F);
/*  55 */     setRotateAngle(this.ArmL2, -0.4098033F, 0.0F, 0.08726646F);
/*  56 */     this.Body3 = new ModelRenderer(this, 0, 52);
/*  57 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  58 */     this.Body3.func_78790_a(-8.0F, 16.0F, -3.2F, 16, 3, 9, 0.0F);
/*  59 */     this.HairBack1 = new ModelRenderer(this, 44, 0);
/*  60 */     this.HairBack1.func_78793_a(0.0F, -2.7F, 2.7F);
/*  61 */     this.HairBack1.func_78790_a(-5.0F, 0.0F, -0.5F, 10, 4, 2, 0.0F);
/*  62 */     setRotateAngle(this.HairBack1, 0.62587506F, 0.0F, 0.0F);
/*  63 */     this.Hair1 = new ModelRenderer(this, 37, 1);
/*  64 */     this.Hair1.func_78793_a(0.6F, -6.5F, -3.4F);
/*  65 */     this.Hair1.func_78790_a(-0.5F, -2.6F, -0.4F, 1, 3, 1, 0.0F);
/*  66 */     setRotateAngle(this.Hair1, 2.4130921F, 0.307527F, 0.18203785F);
/*  67 */     this.HairSideR = new ModelRenderer(this, 37, 0);
/*  68 */     this.HairSideR.func_78793_a(-3.4F, -1.7F, -2.1F);
/*  69 */     this.HairSideR.func_78790_a(-1.2F, -0.4F, 0.0F, 2, 4, 1, 0.0F);
/*  70 */     setRotateAngle(this.HairSideR, -0.6981317F, 0.17453292F, 0.31869712F);
/*  71 */     this.Hair2 = new ModelRenderer(this, 37, 1);
/*  72 */     this.Hair2.func_78793_a(-3.5F, -6.6F, -3.9F);
/*  73 */     this.Hair2.func_78790_a(-1.0F, -2.6F, -0.8F, 2, 3, 1, 0.0F);
/*  74 */     setRotateAngle(this.Hair2, 2.5953045F, 0.091106184F, 0.18203785F);
/*  75 */     this.Body2 = new ModelRenderer(this, 0, 32);
/*  76 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  77 */     this.Body2.func_78790_a(-9.0F, 7.0F, -4.1F, 18, 9, 11, 0.0F);
/*  78 */     this.Chest = new ModelRenderer(this, 52, 23);
/*  79 */     this.Chest.func_78793_a(0.0F, 3.7F, -1.7F);
/*  80 */     this.Chest.func_78790_a(-7.0F, -2.1F, -1.4F, 14, 5, 2, 0.0F);
/*  81 */     setRotateAngle(this.Chest, -0.091106184F, 0.0F, 0.0F);
/*  82 */     this.LegR = new ModelRenderer(this, 91, 43);
/*  83 */     this.LegR.func_78793_a(-4.8F, 11.0F, 1.0F);
/*  84 */     this.LegR.func_78790_a(-3.5F, 0.0F, -3.5F, 7, 13, 7, 0.0F);
/*  85 */     this.HairBack2 = new ModelRenderer(this, 43, 7);
/*  86 */     this.HairBack2.func_78793_a(0.0F, 3.7F, 0.9F);
/*  87 */     this.HairBack2.func_78790_a(-4.0F, 0.0F, -0.5F, 8, 4, 1, 0.0F);
/*  88 */     setRotateAngle(this.HairBack2, -0.48223448F, 0.0F, 0.0F);
/*  89 */     this.HairSideL = new ModelRenderer(this, 37, 0);
/*  90 */     this.HairSideL.field_78809_i = true;
/*  91 */     this.HairSideL.func_78793_a(3.6F, -1.8F, -2.1F);
/*  92 */     this.HairSideL.func_78790_a(-1.1F, -0.2F, 0.0F, 2, 4, 1, 0.0F);
/*  93 */     setRotateAngle(this.HairSideL, -0.6981317F, -0.17453292F, -0.31869712F);
/*  94 */     this.Head = new ModelRenderer(this, 0, 0);
/*  95 */     this.Head.func_78793_a(0.0F, -6.2F, 0.9F);
/*  96 */     this.Head.func_78790_a(-4.5F, -7.2F, -4.0F, 9, 7, 8, 0.0F);
/*  97 */     this.LegL = new ModelRenderer(this, 91, 43);
/*  98 */     this.LegL.field_78809_i = true;
/*  99 */     this.LegL.func_78793_a(4.8F, 11.0F, 1.0F);
/* 100 */     this.LegL.func_78790_a(-3.5F, 0.0F, -3.5F, 7, 13, 7, 0.0F);
/* 101 */     this.ArmL1 = new ModelRenderer(this, 92, 3);
/* 102 */     this.ArmL1.field_78809_i = true;
/* 103 */     this.ArmL1.func_78793_a(8.2F, -4.3F, 2.0F);
/* 104 */     this.ArmL1.func_78790_a(-1.5F, -2.0F, -2.5F, 5, 10, 5, 0.0F);
/* 105 */     setRotateAngle(this.ArmL1, 0.0F, 0.0F, -0.38397244F);
/* 106 */     this.Hair3 = new ModelRenderer(this, 37, 1);
/* 107 */     this.Hair3.func_78793_a(3.7F, -6.6F, -3.9F);
/* 108 */     this.Hair3.func_78790_a(-0.5F, -2.6F, -0.4F, 1, 3, 1, 0.0F);
/* 109 */     setRotateAngle(this.Hair3, 2.7317894F, -0.091106184F, -0.18203785F);
/* 110 */     this.Head.func_78792_a(this.hair);
/* 111 */     this.ArmR1.func_78792_a(this.ArmR2);
/* 112 */     this.ArmL1.func_78792_a(this.ArmL2);
/* 113 */     this.Body2.func_78792_a(this.Body3);
/* 114 */     this.hair.func_78792_a(this.HairBack1);
/* 115 */     this.hair.func_78792_a(this.Hair1);
/* 116 */     this.Head.func_78792_a(this.HairSideR);
/* 117 */     this.hair.func_78792_a(this.Hair2);
/* 118 */     this.Body1.func_78792_a(this.Body2);
/* 119 */     this.Body1.func_78792_a(this.Chest);
/* 120 */     this.HairBack1.func_78792_a(this.HairBack2);
/* 121 */     this.Head.func_78792_a(this.HairSideL);
/* 122 */     this.hair.func_78792_a(this.Hair3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 127 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 129 */     GL11.glPushMatrix();
/* 130 */     float F = 1.5F;
/* 131 */     JGRenderHelper.modelScalePositionHelper(1.5F);
/*     */     
/* 133 */     this.Head.func_78785_a(f5);
/* 134 */     this.Body1.func_78785_a(f5);
/* 135 */     this.ArmR1.func_78785_a(f5);
/* 136 */     this.ArmL1.func_78785_a(f5);
/* 137 */     this.LegL.func_78785_a(f5);
/* 138 */     this.LegR.func_78785_a(f5);
/*     */     
/* 140 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 144 */     modelRenderer.field_78795_f = x;
/* 145 */     modelRenderer.field_78796_g = y;
/* 146 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 150 */     int calc = par7Entity.field_70173_aa;
/* 151 */     if (calc > 100) calc -= 100; 
/* 152 */     float r = 360.0F;
/* 153 */     float r2 = 180.0F;
/* 154 */     float n4 = par4;
/* 155 */     float n5 = par5;
/*     */     
/* 157 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 158 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 159 */     float ex = par7Entity.field_70173_aa;
/* 160 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 161 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 163 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 164 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 213 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 214 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 215 */     this.ArmR1.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 216 */     this.ArmL1.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 218 */     this.LegR.field_78796_g = 0.0F;
/* 219 */     this.LegL.field_78796_g = 0.0F;
/* 220 */     this.ArmR1.field_78796_g = 0.0F;
/* 221 */     this.ArmL1.field_78796_g = 0.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbtournament\ModelBacterian.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */