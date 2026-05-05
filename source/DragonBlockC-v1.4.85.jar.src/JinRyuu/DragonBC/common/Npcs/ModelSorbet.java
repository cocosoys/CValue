/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelSorbet
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer Head_1;
/*     */   public ModelRenderer Skirt;
/*     */   public ModelRenderer Cape;
/*     */   public ModelRenderer Chest;
/*     */   public ModelRenderer ShoulderL;
/*     */   public ModelRenderer ShoulderR;
/*     */   
/*     */   public ModelSorbet() {
/*  24 */     this.field_78090_t = 64;
/*  25 */     this.field_78089_u = 64;
/*  26 */     this.LegL = new ModelRenderer(this, 4, 50);
/*  27 */     this.LegL.field_78809_i = true;
/*  28 */     this.LegL.func_78793_a(1.9F, 15.0F, 0.0F);
/*  29 */     this.LegL.func_78790_a(-1.5F, 0.0F, -1.5F, 3, 9, 3, 0.0F);
/*  30 */     this.LegR = new ModelRenderer(this, 4, 50);
/*  31 */     this.LegR.func_78793_a(-1.9F, 15.0F, 0.0F);
/*  32 */     this.LegR.func_78790_a(-1.5F, 0.0F, -1.5F, 3, 9, 3, 0.0F);
/*  33 */     this.Head = new ModelRenderer(this, 0, 0);
/*  34 */     this.Head.func_78793_a(0.0F, 8.1F, 0.0F);
/*  35 */     this.Head.func_78790_a(-4.0F, -5.3F, -4.1F, 8, 6, 7, -0.2F);
/*  36 */     this.Skirt = new ModelRenderer(this, 1, 30);
/*  37 */     this.Skirt.func_78793_a(0.0F, 0.0F, 0.0F);
/*  38 */     this.Skirt.func_78790_a(-4.5F, 3.9F, -3.6F, 9, 9, 7, 0.0F);
/*  39 */     this.ShoulderR = new ModelRenderer(this, 26, 9);
/*  40 */     this.ShoulderR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  41 */     this.ShoulderR.func_78790_a(-3.0F, -1.2F, -2.6F, 4, 2, 5, 0.0F);
/*  42 */     setRotateAngle(this.ShoulderR, 0.0F, 0.0F, -0.04363323F);
/*  43 */     this.Body = new ModelRenderer(this, 1, 15);
/*  44 */     this.Body.func_78793_a(0.0F, 8.0F, 0.0F);
/*  45 */     this.Body.func_78790_a(-4.0F, 0.3F, -3.0F, 8, 4, 6, 0.0F);
/*  46 */     this.Head_1 = new ModelRenderer(this, 0, 0);
/*  47 */     this.Head_1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  48 */     this.Head_1.func_78790_a(-1.0F, -2.3F, -4.8F, 2, 2, 1, 0.0F);
/*  49 */     this.ShoulderL = new ModelRenderer(this, 26, 9);
/*  50 */     this.ShoulderL.field_78809_i = true;
/*  51 */     this.ShoulderL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  52 */     this.ShoulderL.func_78790_a(-1.1F, -1.2F, -2.5F, 4, 2, 5, 0.0F);
/*  53 */     setRotateAngle(this.ShoulderL, 0.0F, 0.0F, 0.04363323F);
/*  54 */     this.ArmR = new ModelRenderer(this, 42, 30);
/*  55 */     this.ArmR.func_78793_a(-5.0F, 9.5F, 0.5F);
/*  56 */     this.ArmR.func_78790_a(-1.5F, -0.6F, -1.4F, 2, 7, 3, 0.0F);
/*  57 */     setRotateAngle(this.ArmR, 0.0F, 0.0F, 0.04363323F);
/*  58 */     this.Chest = new ModelRenderer(this, 6, 26);
/*  59 */     this.Chest.func_78793_a(0.0F, 0.0F, 0.0F);
/*  60 */     this.Chest.func_78790_a(-3.5F, 1.3F, -3.1F, 7, 2, 1, 0.0F);
/*  61 */     this.Cape = new ModelRenderer(this, 32, 19);
/*  62 */     this.Cape.func_78793_a(0.0F, 2.2F, 3.0F);
/*  63 */     this.Cape.func_78790_a(-4.5F, 0.0F, 0.0F, 9, 9, 0, 0.0F);
/*  64 */     setRotateAngle(this.Cape, 0.2635447F, 0.0F, 0.0F);
/*  65 */     this.ArmL = new ModelRenderer(this, 42, 30);
/*  66 */     this.ArmL.field_78809_i = true;
/*  67 */     this.ArmL.func_78793_a(5.1F, 9.5F, 0.5F);
/*  68 */     this.ArmL.func_78790_a(-0.6F, -0.6F, -1.5F, 2, 7, 3, 0.0F);
/*  69 */     setRotateAngle(this.ArmL, 0.0F, 0.0F, -0.04363323F);
/*  70 */     this.Body.func_78792_a(this.Skirt);
/*  71 */     this.ArmR.func_78792_a(this.ShoulderR);
/*  72 */     this.Head.func_78792_a(this.Head_1);
/*  73 */     this.ArmL.func_78792_a(this.ShoulderL);
/*  74 */     this.Body.func_78792_a(this.Chest);
/*  75 */     this.Body.func_78792_a(this.Cape);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  80 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/*  83 */     this.LegL.func_78785_a(f5);
/*  84 */     this.Head.func_78785_a(f5);
/*  85 */     this.ArmL.func_78785_a(f5);
/*  86 */     this.ArmR.func_78785_a(f5);
/*  87 */     this.Body.func_78785_a(f5);
/*  88 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/*  93 */     modelRenderer.field_78795_f = x;
/*  94 */     modelRenderer.field_78796_g = y;
/*  95 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/*  99 */     int calc = par7Entity.field_70173_aa;
/* 100 */     if (calc > 100) calc -= 100; 
/* 101 */     float r = 360.0F;
/* 102 */     float r2 = 180.0F;
/* 103 */     float n4 = par4;
/* 104 */     float n5 = par5;
/*     */     
/* 106 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 107 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 108 */     float ex = par7Entity.field_70173_aa;
/* 109 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 110 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 115 */     float rota = -MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 116 */     if (rota > 0.0F) rota *= -1.0F; 
/* 117 */     this.Cape.field_78795_f = -0.23F + rota;
/* 118 */     if (0.0F > this.Cape.field_78795_f) this.Cape.field_78795_f *= -1.0F; 
/* 119 */     this.Cape.field_78796_g = 0.0F;
/*     */     
/* 121 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 122 */     this.LegL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 123 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 124 */     this.ArmL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 125 */     this.LegR.field_78796_g = 0.0F;
/* 126 */     this.LegL.field_78796_g = 0.0F;
/* 127 */     this.ArmR.field_78796_g = 0.0F;
/* 128 */     this.ArmL.field_78796_g = 0.0F;
/* 129 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelSorbet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */