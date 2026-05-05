/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelGodHeles
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer Hat;
/*     */   public ModelRenderer HairR;
/*     */   public ModelRenderer HairL;
/*     */   public ModelRenderer HairB;
/*     */   public ModelRenderer Neck;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Boobs;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer Cloth1;
/*     */   public ModelRenderer LegL2;
/*     */   public ModelRenderer LegR2;
/*     */   
/*     */   public ModelGodHeles() {
/*  29 */     this.field_78090_t = 128;
/*  30 */     this.field_78089_u = 64;
/*  31 */     this.Body1 = new ModelRenderer(this, 21, 23);
/*  32 */     this.Body1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  33 */     this.Body1.func_78790_a(-4.0F, 0.0F, -1.8F, 8, 5, 4, 0.0F);
/*  34 */     this.Cloth1 = new ModelRenderer(this, 24, 50);
/*  35 */     this.Cloth1.func_78793_a(0.0F, 11.0F, -1.6F);
/*  36 */     this.Cloth1.func_78790_a(-2.5F, 0.0F, -0.5F, 5, 10, 0, 0.0F);
/*  37 */     setRotateAngle(this.Cloth1, -0.04712389F, 0.0F, 0.0F);
/*  38 */     this.ArmR = new ModelRenderer(this, 46, 26);
/*  39 */     this.ArmR.func_78793_a(-5.0F, 2.0F, 0.0F);
/*  40 */     this.ArmR.func_78790_a(-2.0F, -2.0F, -1.8F, 3, 12, 4, 0.0F);
/*  41 */     this.LegL = new ModelRenderer(this, 0, 49);
/*  42 */     this.LegL.field_78809_i = true;
/*  43 */     this.LegL.func_78793_a(1.9F, 12.0F, 0.0F);
/*  44 */     this.LegL.func_78790_a(-0.9F, 0.2F, -1.8F, 3, 8, 4, 0.3F);
/*  45 */     this.Body3 = new ModelRenderer(this, 20, 40);
/*  46 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  47 */     this.Body3.func_78790_a(-4.0F, 8.0F, -2.0F, 8, 4, 4, 0.0F);
/*  48 */     this.LegL2 = new ModelRenderer(this, 0, 32);
/*  49 */     this.LegL2.field_78809_i = true;
/*  50 */     this.LegL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  51 */     this.LegL2.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  52 */     this.Hat = new ModelRenderer(this, 33, 1);
/*  53 */     this.Hat.func_78793_a(0.0F, 0.0F, 0.0F);
/*  54 */     this.Hat.func_78790_a(-4.0F, -12.6F, -4.5F, 8, 7, 8, 0.0F);
/*  55 */     setRotateAngle(this.Hat, -0.08726646F, 0.0F, 0.0F);
/*  56 */     this.Body2 = new ModelRenderer(this, 23, 33);
/*  57 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  58 */     this.Body2.func_78790_a(-2.9F, 5.0F, -1.6F, 6, 3, 3, 0.0F);
/*  59 */     this.Head = new ModelRenderer(this, 0, 0);
/*  60 */     this.Head.func_78793_a(0.0F, -0.6F, 0.0F);
/*  61 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, -0.4F);
/*  62 */     this.LegR2 = new ModelRenderer(this, 0, 32);
/*  63 */     this.LegR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  64 */     this.LegR2.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  65 */     this.HairB = new ModelRenderer(this, 67, 17);
/*  66 */     this.HairB.func_78793_a(0.0F, 0.0F, 0.0F);
/*  67 */     this.HairB.func_78790_a(-3.0F, -5.9F, 3.0F, 6, 7, 1, 0.0F);
/*  68 */     setRotateAngle(this.HairB, 0.02443461F, 0.0F, 0.0F);
/*  69 */     this.Boobs = new ModelRenderer(this, 1, 24);
/*  70 */     this.Boobs.func_78793_a(0.0F, 0.0F, 0.0F);
/*  71 */     this.Boobs.func_78790_a(-3.5F, 1.6F, -1.2F, 7, 3, 2, 0.0F);
/*  72 */     setRotateAngle(this.Boobs, -0.4537856F, 0.0F, 0.0F);
/*  73 */     this.Neck = new ModelRenderer(this, 6, 17);
/*  74 */     this.Neck.func_78793_a(0.0F, 0.0F, 0.0F);
/*  75 */     this.Neck.func_78790_a(-2.0F, -1.6F, -0.8F, 4, 2, 2, 0.0F);
/*  76 */     this.ArmL = new ModelRenderer(this, 46, 26);
/*  77 */     this.ArmL.field_78809_i = true;
/*  78 */     this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
/*  79 */     this.ArmL.func_78790_a(-1.0F, -2.0F, -1.8F, 3, 12, 4, 0.0F);
/*  80 */     this.HairR = new ModelRenderer(this, 67, 2);
/*  81 */     this.HairR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  82 */     this.HairR.func_78790_a(-4.0F, -6.2F, -3.2F, 1, 7, 7, 0.0F);
/*  83 */     setRotateAngle(this.HairR, 0.0F, 0.0F, 0.02443461F);
/*  84 */     this.HairL = new ModelRenderer(this, 67, 2);
/*  85 */     this.HairL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  86 */     this.HairL.func_78790_a(3.0F, -6.2F, -3.2F, 1, 7, 7, 0.0F);
/*  87 */     setRotateAngle(this.HairL, 0.0F, 0.0F, -0.02443461F);
/*  88 */     this.LegR = new ModelRenderer(this, 0, 49);
/*  89 */     this.LegR.func_78793_a(-1.9F, 12.0F, 0.0F);
/*  90 */     this.LegR.func_78790_a(-2.1F, 0.2F, -1.8F, 3, 8, 4, 0.3F);
/*  91 */     this.Body1.func_78792_a(this.Cloth1);
/*  92 */     this.Body1.func_78792_a(this.Body3);
/*  93 */     this.LegL.func_78792_a(this.LegL2);
/*  94 */     this.Head.func_78792_a(this.Hat);
/*  95 */     this.Body1.func_78792_a(this.Body2);
/*  96 */     this.LegR.func_78792_a(this.LegR2);
/*  97 */     this.Head.func_78792_a(this.HairB);
/*  98 */     this.Body1.func_78792_a(this.Boobs);
/*  99 */     this.Body1.func_78792_a(this.Neck);
/* 100 */     this.Head.func_78792_a(this.HairR);
/* 101 */     this.Head.func_78792_a(this.HairL);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 106 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 109 */     this.LegL.func_78785_a(f5);
/* 110 */     this.Head.func_78785_a(f5);
/* 111 */     this.ArmL.func_78785_a(f5);
/* 112 */     this.ArmR.func_78785_a(f5);
/* 113 */     this.Body1.func_78785_a(f5);
/* 114 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 119 */     modelRenderer.field_78795_f = x;
/* 120 */     modelRenderer.field_78796_g = y;
/* 121 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 125 */     int calc = par7Entity.field_70173_aa;
/* 126 */     if (calc > 100) calc -= 100; 
/* 127 */     float r = 360.0F;
/* 128 */     float r2 = 180.0F;
/* 129 */     float n4 = par4;
/* 130 */     float n5 = par5;
/*     */     
/* 132 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 133 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 134 */     float ex = par7Entity.field_70173_aa;
/* 135 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 136 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 138 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 139 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 180 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 181 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 182 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 183 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 185 */     this.LegR.field_78796_g = 0.0F;
/* 186 */     this.LegL.field_78796_g = 0.0F;
/* 187 */     this.ArmR.field_78796_g = 0.0F;
/* 188 */     this.ArmL.field_78796_g = 0.0F;
/*     */ 
/*     */     
/* 191 */     this.Cloth1.field_78795_f = -0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/*     */ 
/*     */ 
/*     */     
/* 195 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelGodHeles.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */