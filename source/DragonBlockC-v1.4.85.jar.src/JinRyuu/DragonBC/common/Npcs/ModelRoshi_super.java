/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelRoshi_super
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer UpperBody;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer Beard1;
/*     */   public ModelRenderer Beard2;
/*     */   public ModelRenderer Belt;
/*     */   public ModelRenderer Lowerbody;
/*     */   public ModelRenderer Neck;
/*     */   public ModelRenderer Belt2;
/*     */   public ModelRenderer Belt3;
/*     */   public ModelRenderer Belt4;
/*     */   public ModelRenderer FeetR;
/*     */   public ModelRenderer FeetL;
/*     */   
/*     */   public ModelRoshi_super() {
/*  28 */     this.field_78090_t = 64;
/*  29 */     this.field_78089_u = 64;
/*  30 */     this.ArmR = new ModelRenderer(this, 30, 26);
/*  31 */     this.ArmR.func_78793_a(-3.9F, 5.6F, 0.1F);
/*  32 */     this.ArmR.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 11, 4, -0.6F);
/*  33 */     this.FeetL = new ModelRenderer(this, 17, 53);
/*  34 */     this.FeetL.field_78809_i = true;
/*  35 */     this.FeetL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  36 */     this.FeetL.func_78790_a(-1.5F, 8.0F, -2.5F, 3, 2, 4, 0.0F);
/*  37 */     this.UpperBody = new ModelRenderer(this, 3, 23);
/*  38 */     this.UpperBody.func_78793_a(0.0F, 4.0F, 0.1F);
/*  39 */     this.UpperBody.func_78790_a(-3.5F, 0.0F, -2.0F, 7, 6, 4, 0.0F);
/*  40 */     this.LegL = new ModelRenderer(this, 0, 49);
/*  41 */     this.LegL.field_78809_i = true;
/*  42 */     this.LegL.func_78793_a(1.9F, 14.0F, 0.0F);
/*  43 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 8, 4, 0.0F);
/*  44 */     this.Belt4 = new ModelRenderer(this, 2, 36);
/*  45 */     this.Belt4.func_78793_a(0.6F, 0.5F, 0.0F);
/*  46 */     this.Belt4.func_78790_a(-0.5F, 0.0F, -0.1F, 1, 5, 0, 0.0F);
/*  47 */     setRotateAngle(this.Belt4, -0.045553092F, -1.1838568F, -0.091106184F);
/*  48 */     this.Belt = new ModelRenderer(this, 6, 35);
/*  49 */     this.Belt.func_78793_a(0.0F, 0.0F, 0.0F);
/*  50 */     this.Belt.func_78790_a(-3.1F, 5.2F, -1.5F, 6, 2, 3, 0.0F);
/*  51 */     this.Belt3 = new ModelRenderer(this, 2, 36);
/*  52 */     this.Belt3.func_78793_a(0.0F, 0.6F, 0.0F);
/*  53 */     this.Belt3.func_78790_a(-0.4F, 0.0F, -0.5F, 1, 5, 0, 0.0F);
/*  54 */     setRotateAngle(this.Belt3, -0.14660765F, -0.31869712F, -0.0418879F);
/*  55 */     this.FeetR = new ModelRenderer(this, 17, 53);
/*  56 */     this.FeetR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  57 */     this.FeetR.func_78790_a(-1.5F, 8.0F, -2.5F, 3, 2, 4, 0.0F);
/*  58 */     this.Lowerbody = new ModelRenderer(this, 4, 41);
/*  59 */     this.Lowerbody.func_78793_a(0.0F, 0.0F, 0.0F);
/*  60 */     this.Lowerbody.func_78790_a(-3.5F, 7.0F, -2.0F, 7, 3, 4, 0.0F);
/*  61 */     this.LegR = new ModelRenderer(this, 0, 49);
/*  62 */     this.LegR.func_78793_a(-1.9F, 14.0F, 0.0F);
/*  63 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 8, 4, 0.0F);
/*  64 */     this.Beard2 = new ModelRenderer(this, 35, 10);
/*  65 */     this.Beard2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  66 */     this.Beard2.func_78790_a(-1.5F, -1.8F, -3.7F, 3, 4, 1, 0.0F);
/*  67 */     this.Belt2 = new ModelRenderer(this, 0, 33);
/*  68 */     this.Belt2.func_78793_a(3.0F, 6.8F, -1.7F);
/*  69 */     this.Belt2.func_78790_a(-1.4F, 0.0F, -0.4F, 2, 1, 2, 0.0F);
/*  70 */     this.Neck = new ModelRenderer(this, 7, 17);
/*  71 */     this.Neck.func_78793_a(0.0F, 0.0F, 0.0F);
/*  72 */     this.Neck.func_78790_a(-2.0F, -1.2F, -1.2F, 4, 2, 3, 0.0F);
/*  73 */     this.ArmL = new ModelRenderer(this, 30, 26);
/*  74 */     this.ArmL.field_78809_i = true;
/*  75 */     this.ArmL.func_78793_a(3.9F, 5.6F, 0.1F);
/*  76 */     this.ArmL.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 11, 4, -0.6F);
/*  77 */     this.Beard1 = new ModelRenderer(this, 35, 6);
/*  78 */     this.Beard1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  79 */     this.Beard1.func_78790_a(-1.9F, -2.4F, -4.0F, 4, 2, 1, 0.0F);
/*  80 */     this.Head = new ModelRenderer(this, 0, 0);
/*  81 */     this.Head.func_78793_a(0.0F, 4.0F, 0.0F);
/*  82 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, -0.7F);
/*  83 */     this.LegL.func_78792_a(this.FeetL);
/*  84 */     this.Belt2.func_78792_a(this.Belt4);
/*  85 */     this.UpperBody.func_78792_a(this.Belt);
/*  86 */     this.Belt2.func_78792_a(this.Belt3);
/*  87 */     this.LegR.func_78792_a(this.FeetR);
/*  88 */     this.UpperBody.func_78792_a(this.Lowerbody);
/*  89 */     this.Beard1.func_78792_a(this.Beard2);
/*  90 */     this.Belt.func_78792_a(this.Belt2);
/*  91 */     this.UpperBody.func_78792_a(this.Neck);
/*  92 */     this.Head.func_78792_a(this.Beard1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  97 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 100 */     this.LegL.func_78785_a(f5);
/* 101 */     this.Head.func_78785_a(f5);
/* 102 */     this.ArmL.func_78785_a(f5);
/* 103 */     this.ArmR.func_78785_a(f5);
/* 104 */     this.UpperBody.func_78785_a(f5);
/* 105 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 110 */     modelRenderer.field_78795_f = x;
/* 111 */     modelRenderer.field_78796_g = y;
/* 112 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 116 */     int calc = par7Entity.field_70173_aa;
/* 117 */     if (calc > 100) calc -= 100; 
/* 118 */     float r = 360.0F;
/* 119 */     float r2 = 180.0F;
/* 120 */     float n4 = par4;
/* 121 */     float n5 = par5;
/*     */     
/* 123 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 124 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 125 */     float ex = par7Entity.field_70173_aa;
/* 126 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 127 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 129 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 130 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 160 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 161 */     this.LegL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 162 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 163 */     this.ArmL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 164 */     this.LegR.field_78796_g = 0.0F;
/* 165 */     this.LegL.field_78796_g = 0.0F;
/* 166 */     this.ArmR.field_78796_g = 0.0F;
/* 167 */     this.ArmL.field_78796_g = 0.0F;
/* 168 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelRoshi_super.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */