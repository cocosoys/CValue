/*     */ package JinRyuu.DragonBC.common.Npcs.dbredribbon;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelRedRibbonSoldierGunner
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer Hat;
/*     */   public ModelRenderer ArmR2;
/*     */   public ModelRenderer ArmR3;
/*     */   public ModelRenderer Gun1;
/*     */   public ModelRenderer Gun2;
/*     */   public ModelRenderer Gun4;
/*     */   public ModelRenderer Gun3;
/*     */   public ModelRenderer Barrel;
/*     */   public ModelRenderer ArmL2;
/*     */   public ModelRenderer ArmL3;
/*     */   public ModelRenderer Ribbon;
/*     */   
/*     */   public ModelRedRibbonSoldierGunner() {
/*  30 */     this.field_78090_t = 64;
/*  31 */     this.field_78089_u = 64;
/*  32 */     this.Head = new ModelRenderer(this, 0, 0);
/*  33 */     this.Head.func_78793_a(0.0F, 0.0F, 0.0F);
/*  34 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
/*  35 */     this.Barrel = new ModelRenderer(this, 58, 59);
/*  36 */     this.Barrel.func_78793_a(0.0F, 3.5F, -0.3F);
/*  37 */     this.Barrel.func_78790_a(-0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
/*  38 */     this.ArmR2 = new ModelRenderer(this, 0, 32);
/*  39 */     this.ArmR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  40 */     this.ArmR2.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 6, 4, 0.0F);
/*  41 */     setRotateAngle(this.ArmR2, 0.5462881F, -0.22759093F, 0.091106184F);
/*  42 */     this.ArmR = new ModelRenderer(this, 0, 0);
/*  43 */     this.ArmR.func_78793_a(-5.0F, 2.0F, 0.0F);
/*  44 */     this.ArmR.func_78790_a(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
/*  45 */     this.LegL = new ModelRenderer(this, 0, 16);
/*  46 */     this.LegL.field_78809_i = true;
/*  47 */     this.LegL.func_78793_a(1.9F, 12.0F, 0.0F);
/*  48 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  49 */     this.ArmL3 = new ModelRenderer(this, 17, 43);
/*  50 */     this.ArmL3.field_78809_i = true;
/*  51 */     this.ArmL3.func_78793_a(1.0F, 4.0F, 0.0F);
/*  52 */     this.ArmL3.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
/*  53 */     setRotateAngle(this.ArmL3, -0.13665928F, 0.0F, 0.0F);
/*  54 */     this.Gun2 = new ModelRenderer(this, 55, 51);
/*  55 */     this.Gun2.func_78793_a(0.0F, 5.0F, 0.0F);
/*  56 */     this.Gun2.func_78790_a(-1.0F, -1.6F, -1.3F, 2, 5, 2, 0.0F);
/*  57 */     this.Gun4 = new ModelRenderer(this, 53, 35);
/*  58 */     this.Gun4.func_78793_a(0.0F, -0.9F, 0.4F);
/*  59 */     this.Gun4.func_78790_a(-0.5F, -1.1F, -1.2F, 1, 2, 4, 0.0F);
/*  60 */     setRotateAngle(this.Gun4, 0.7285004F, 0.0F, 0.0F);
/*  61 */     this.Gun1 = new ModelRenderer(this, 53, 42);
/*  62 */     this.Gun1.func_78793_a(0.5F, 5.8F, -3.2F);
/*  63 */     this.Gun1.func_78790_a(-1.0F, -1.4F, -1.6F, 2, 5, 3, 0.0F);
/*  64 */     setRotateAngle(this.Gun1, -0.10471976F, -0.2268928F, 0.4712389F);
/*  65 */     this.ArmR3 = new ModelRenderer(this, 17, 32);
/*  66 */     this.ArmR3.func_78793_a(-1.0F, 4.4F, -1.7F);
/*  67 */     this.ArmR3.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
/*  68 */     setRotateAngle(this.ArmR3, -2.048842F, -0.31869712F, 0.0F);
/*  69 */     this.ArmL2 = new ModelRenderer(this, 0, 43);
/*  70 */     this.ArmL2.field_78809_i = true;
/*  71 */     this.ArmL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  72 */     this.ArmL2.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 6, 4, 0.0F);
/*  73 */     setRotateAngle(this.ArmL2, -1.1838568F, 0.8196066F, 0.0F);
/*  74 */     this.LegR = new ModelRenderer(this, 0, 16);
/*  75 */     this.LegR.func_78793_a(-1.9F, 12.0F, 0.0F);
/*  76 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  77 */     this.Gun3 = new ModelRenderer(this, 50, 51);
/*  78 */     this.Gun3.func_78793_a(0.0F, 1.7F, -1.5F);
/*  79 */     this.Gun3.func_78790_a(-0.5F, -1.9F, -0.5F, 1, 5, 1, 0.0F);
/*  80 */     this.Ribbon = new ModelRenderer(this, 41, 20);
/*  81 */     this.Ribbon.func_78793_a(2.8F, 0.9F, 0.0F);
/*  82 */     this.Ribbon.func_78790_a(0.0F, -1.9F, 0.0F, 6, 5, 0, 0.0F);
/*  83 */     setRotateAngle(this.Ribbon, 0.0F, -0.95609134F, 0.0F);
/*  84 */     this.Body = new ModelRenderer(this, 16, 16);
/*  85 */     this.Body.func_78793_a(0.0F, 0.0F, 0.0F);
/*  86 */     this.Body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
/*  87 */     this.ArmL = new ModelRenderer(this, 0, 0);
/*  88 */     this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
/*  89 */     this.ArmL.func_78790_a(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
/*  90 */     this.Hat = new ModelRenderer(this, 24, 2);
/*  91 */     this.Hat.func_78793_a(0.0F, -5.0F, -4.4F);
/*  92 */     this.Hat.func_78790_a(-4.0F, 0.0F, -1.6F, 8, 0, 2, 0.0F);
/*  93 */     setRotateAngle(this.Hat, 0.22759093F, 0.0F, 0.0F);
/*  94 */     this.Gun2.func_78792_a(this.Barrel);
/*  95 */     this.ArmR.func_78792_a(this.ArmR2);
/*  96 */     this.ArmL2.func_78792_a(this.ArmL3);
/*  97 */     this.Gun1.func_78792_a(this.Gun2);
/*  98 */     this.Gun1.func_78792_a(this.Gun4);
/*  99 */     this.ArmR3.func_78792_a(this.Gun1);
/* 100 */     this.ArmR2.func_78792_a(this.ArmR3);
/* 101 */     this.ArmL.func_78792_a(this.ArmL2);
/* 102 */     this.Gun1.func_78792_a(this.Gun3);
/* 103 */     this.ArmL2.func_78792_a(this.Ribbon);
/* 104 */     this.Head.func_78792_a(this.Hat);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 109 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 111 */     this.Head.func_78785_a(f5);
/*     */     
/* 113 */     this.Body.func_78785_a(f5);
/* 114 */     this.ArmR.func_78785_a(f5);
/* 115 */     this.ArmL.func_78785_a(f5);
/* 116 */     this.LegL.func_78785_a(f5);
/* 117 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 126 */     modelRenderer.field_78795_f = x;
/* 127 */     modelRenderer.field_78796_g = y;
/* 128 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 132 */     int calc = par7Entity.field_70173_aa;
/* 133 */     if (calc > 100) calc -= 100; 
/* 134 */     float r = 360.0F;
/* 135 */     float r2 = 180.0F;
/* 136 */     float n4 = par4;
/* 137 */     float n5 = par5;
/*     */     
/* 139 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 140 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 141 */     float ex = par7Entity.field_70173_aa;
/* 142 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 143 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 145 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 146 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 195 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 196 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */ 
/*     */ 
/*     */     
/* 200 */     this.LegR.field_78796_g = 0.0F;
/* 201 */     this.LegL.field_78796_g = 0.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbredribbon\ModelRedRibbonSoldierGunner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */