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
/*     */ public class ModelMajorMetallitron
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmR1;
/*     */   public ModelRenderer ArmL1;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer Hair;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer RoboticsNeck;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer Chest;
/*     */   public ModelRenderer Body4;
/*     */   public ModelRenderer ArmR2;
/*     */   public ModelRenderer ArmR3;
/*     */   public ModelRenderer RoboticsArmR;
/*     */   public ModelRenderer ArmL2;
/*     */   public ModelRenderer ArmL3;
/*     */   public ModelRenderer RoboticsArmL;
/*     */   public ModelRenderer LegR2;
/*     */   public ModelRenderer LegL2;
/*     */   
/*     */   public ModelMajorMetallitron() {
/*  36 */     this.field_78090_t = 128;
/*  37 */     this.field_78089_u = 64;
/*  38 */     this.Body3 = new ModelRenderer(this, 0, 48);
/*  39 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  40 */     this.Body3.func_78790_a(-6.0F, 12.0F, -3.0F, 12, 5, 6, 0.0F);
/*  41 */     this.Body2 = new ModelRenderer(this, 0, 34);
/*  42 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  43 */     this.Body2.func_78790_a(-5.5F, 6.2F, -2.9F, 11, 6, 6, 0.0F);
/*  44 */     this.Body4 = new ModelRenderer(this, 72, 12);
/*  45 */     this.Body4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  46 */     this.Body4.func_78790_a(-6.0F, 7.0F, -3.4F, 12, 5, 7, 0.0F);
/*  47 */     this.ArmL1 = new ModelRenderer(this, 92, 27);
/*  48 */     this.ArmL1.field_78809_i = true;
/*  49 */     this.ArmL1.func_78793_a(7.5F, -5.2F, 0.2F);
/*  50 */     this.ArmL1.func_78790_a(-1.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
/*  51 */     this.Chest = new ModelRenderer(this, 35, 33);
/*  52 */     this.Chest.func_78793_a(0.0F, 0.0F, 0.0F);
/*  53 */     this.Chest.func_78790_a(-6.0F, 2.0F, -3.4F, 12, 5, 1, 0.0F);
/*  54 */     this.LegL2 = new ModelRenderer(this, 66, 0);
/*  55 */     this.LegL2.func_78793_a(3.1F, 2.1F, 0.0F);
/*  56 */     this.LegL2.func_78790_a(-1.0F, -2.0F, -2.5F, 2, 5, 5, 0.0F);
/*  57 */     this.ArmL2 = new ModelRenderer(this, 92, 40);
/*  58 */     this.ArmL2.field_78809_i = true;
/*  59 */     this.ArmL2.func_78793_a(1.7F, 2.0F, 0.0F);
/*  60 */     this.ArmL2.func_78790_a(-2.3F, 0.4F, -2.5F, 5, 4, 5, 0.0F);
/*  61 */     this.LegR2 = new ModelRenderer(this, 66, 0);
/*  62 */     this.LegR2.func_78793_a(-3.2F, 2.1F, 0.0F);
/*  63 */     this.LegR2.func_78790_a(-1.0F, -2.0F, -2.5F, 2, 5, 5, 0.0F);
/*  64 */     this.Head = new ModelRenderer(this, 0, 0);
/*  65 */     this.Head.func_78793_a(0.0F, -7.8F, -0.5F);
/*  66 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, -0.2F);
/*  67 */     this.LegR = new ModelRenderer(this, 41, 42);
/*  68 */     this.LegR.func_78793_a(-3.0F, 9.0F, 0.0F);
/*  69 */     this.LegR.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 15, 6, 0.0F);
/*  70 */     this.LegL = new ModelRenderer(this, 41, 42);
/*  71 */     this.LegL.field_78809_i = true;
/*  72 */     this.LegL.func_78793_a(3.0F, 9.0F, 0.0F);
/*  73 */     this.LegL.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 15, 6, 0.0F);
/*  74 */     this.RoboticsArmR = new ModelRenderer(this, 81, 1);
/*  75 */     this.RoboticsArmR.func_78793_a(-0.5F, 0.5F, 0.5F);
/*  76 */     this.RoboticsArmR.func_78790_a(-2.0F, 0.2F, -2.0F, 4, 3, 4, 0.0F);
/*  77 */     this.ArmL3 = new ModelRenderer(this, 93, 50);
/*  78 */     this.ArmL3.field_78809_i = true;
/*  79 */     this.ArmL3.func_78793_a(0.0F, 4.2F, -0.5F);
/*  80 */     this.ArmL3.func_78790_a(-2.1F, 0.0F, -1.8F, 5, 8, 5, 0.0F);
/*  81 */     this.ArmR2 = new ModelRenderer(this, 67, 40);
/*  82 */     this.ArmR2.func_78793_a(-1.7F, 2.0F, 0.0F);
/*  83 */     this.ArmR2.func_78790_a(-2.7F, 0.4F, -2.5F, 5, 4, 5, 0.0F);
/*  84 */     this.Hair = new ModelRenderer(this, 32, 0);
/*  85 */     this.Hair.func_78793_a(0.0F, 0.0F, 0.0F);
/*  86 */     this.Hair.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
/*  87 */     this.RoboticsNeck = new ModelRenderer(this, 81, 1);
/*  88 */     this.RoboticsNeck.func_78793_a(0.0F, 0.5F, 0.5F);
/*  89 */     this.RoboticsNeck.func_78790_a(-2.0F, -1.1F, -2.0F, 4, 3, 4, 0.0F);
/*  90 */     this.ArmR3 = new ModelRenderer(this, 67, 50);
/*  91 */     this.ArmR3.func_78793_a(0.0F, 4.2F, -0.5F);
/*  92 */     this.ArmR3.func_78790_a(-2.9F, 0.0F, -1.9F, 5, 8, 5, 0.0F);
/*  93 */     this.RoboticsArmL = new ModelRenderer(this, 97, 1);
/*  94 */     this.RoboticsArmL.func_78793_a(0.4F, 0.5F, 0.5F);
/*  95 */     this.RoboticsArmL.func_78790_a(-2.0F, 0.2F, -2.0F, 4, 3, 4, 0.0F);
/*  96 */     this.Body1 = new ModelRenderer(this, 0, 17);
/*  97 */     this.Body1.func_78793_a(0.0F, -8.0F, 0.0F);
/*  98 */     this.Body1.func_78790_a(-6.5F, 0.0F, -2.5F, 13, 8, 6, 0.0F);
/*  99 */     this.ArmR1 = new ModelRenderer(this, 66, 27);
/* 100 */     this.ArmR1.func_78793_a(-7.5F, -5.2F, 0.2F);
/* 101 */     this.ArmR1.func_78790_a(-5.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
/* 102 */     this.Body2.func_78792_a(this.Body3);
/* 103 */     this.Body1.func_78792_a(this.Body2);
/* 104 */     this.Body2.func_78792_a(this.Body4);
/* 105 */     this.Body2.func_78792_a(this.Chest);
/* 106 */     this.LegL.func_78792_a(this.LegL2);
/* 107 */     this.ArmL1.func_78792_a(this.ArmL2);
/* 108 */     this.LegR.func_78792_a(this.LegR2);
/* 109 */     this.ArmR3.func_78792_a(this.RoboticsArmR);
/* 110 */     this.ArmL2.func_78792_a(this.ArmL3);
/* 111 */     this.ArmR1.func_78792_a(this.ArmR2);
/* 112 */     this.Head.func_78792_a(this.Hair);
/* 113 */     this.Body1.func_78792_a(this.RoboticsNeck);
/* 114 */     this.ArmR2.func_78792_a(this.ArmR3);
/* 115 */     this.ArmL3.func_78792_a(this.RoboticsArmL);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 120 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 122 */     GL11.glPushMatrix();
/* 123 */     float F = 2.0F;
/* 124 */     JGRenderHelper.modelScalePositionHelper(2.0F);
/*     */     
/* 126 */     this.Head.func_78785_a(f5);
/* 127 */     this.Body1.func_78785_a(f5);
/* 128 */     this.ArmR1.func_78785_a(f5);
/* 129 */     this.ArmL1.func_78785_a(f5);
/* 130 */     this.LegL.func_78785_a(f5);
/* 131 */     this.LegR.func_78785_a(f5);
/*     */     
/* 133 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 137 */     modelRenderer.field_78795_f = x;
/* 138 */     modelRenderer.field_78796_g = y;
/* 139 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 143 */     int calc = par7Entity.field_70173_aa;
/* 144 */     if (calc > 100) calc -= 100; 
/* 145 */     float r = 360.0F;
/* 146 */     float r2 = 180.0F;
/* 147 */     float n4 = par4;
/* 148 */     float n5 = par5;
/*     */     
/* 150 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 151 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 152 */     float ex = par7Entity.field_70173_aa;
/* 153 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 154 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 156 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 157 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 206 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 207 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 208 */     this.ArmR1.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 209 */     this.ArmL1.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 211 */     this.LegR.field_78796_g = 0.0F;
/* 212 */     this.LegL.field_78796_g = 0.0F;
/* 213 */     this.ArmR1.field_78796_g = 0.0F;
/* 214 */     this.ArmL1.field_78796_g = 0.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbredribbon\ModelMajorMetallitron.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */