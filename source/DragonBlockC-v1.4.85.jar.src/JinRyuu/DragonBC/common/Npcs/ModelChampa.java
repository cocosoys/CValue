/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelChampa
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer EarL;
/*     */   public ModelRenderer EarR;
/*     */   public ModelRenderer Snout1;
/*     */   public ModelRenderer EarL_1;
/*     */   public ModelRenderer Snout2;
/*     */   public ModelRenderer SnoutSideR;
/*     */   public ModelRenderer SnoutSideL;
/*     */   public ModelRenderer Cloth1;
/*     */   public ModelRenderer tail1;
/*     */   public ModelRenderer tail2;
/*     */   
/*     */   public ModelChampa() {
/*  28 */     this.field_78090_t = 64;
/*  29 */     this.field_78089_u = 32;
/*  30 */     this.LegR = new ModelRenderer(this, 0, 16);
/*  31 */     this.LegR.func_78793_a(-1.9F, 12.0F, 0.0F);
/*  32 */     this.LegR.func_78790_a(-2.3F, 0.0F, -2.0F, 4, 12, 4, 0.2F);
/*  33 */     this.ArmL = new ModelRenderer(this, 40, 16);
/*  34 */     this.ArmL.field_78809_i = true;
/*  35 */     this.ArmL.func_78793_a(5.0F, 1.7F, 0.1F);
/*  36 */     this.ArmL.func_78790_a(-1.0F, -2.0F, -2.0F, 3, 12, 4, 0.0F);
/*  37 */     this.tail2 = new ModelRenderer(this, 42, 1);
/*  38 */     this.tail2.func_78793_a(0.0F, 2.6F, 0.0F);
/*  39 */     this.tail2.func_78790_a(-0.5F, -0.1F, -0.5F, 1, 3, 1, 0.0F);
/*  40 */     setRotateAngle(this.tail2, 0.4553564F, 0.0F, 0.0F);
/*  41 */     this.SnoutSideL = new ModelRenderer(this, 47, 7);
/*  42 */     this.SnoutSideL.field_78809_i = true;
/*  43 */     this.SnoutSideL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  44 */     this.SnoutSideL.func_78790_a(-1.7F, -2.8F, -5.0F, 2, 2, 1, 0.0F);
/*  45 */     setRotateAngle(this.SnoutSideL, 0.0F, -0.5934119F, 0.0F);
/*  46 */     this.LegL = new ModelRenderer(this, 0, 16);
/*  47 */     this.LegL.field_78809_i = true;
/*  48 */     this.LegL.func_78793_a(1.9F, 12.0F, 0.0F);
/*  49 */     this.LegL.func_78790_a(-1.7F, 0.0F, -2.0F, 4, 12, 4, 0.2F);
/*  50 */     this.SnoutSideR = new ModelRenderer(this, 47, 7);
/*  51 */     this.SnoutSideR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  52 */     this.SnoutSideR.func_78790_a(-0.2F, -2.8F, -5.0F, 2, 2, 1, 0.0F);
/*  53 */     setRotateAngle(this.SnoutSideR, 0.0F, 0.5934119F, 0.0F);
/*  54 */     this.Cloth1 = new ModelRenderer(this, 54, 1);
/*  55 */     this.Cloth1.func_78793_a(0.0F, 11.2F, -2.4F);
/*  56 */     this.Cloth1.func_78790_a(-2.5F, 0.1F, 0.0F, 5, 8, 0, 0.0F);
/*  57 */     setRotateAngle(this.Cloth1, -0.057595864F, 0.0F, 0.0F);
/*  58 */     this.Snout2 = new ModelRenderer(this, 43, 7);
/*  59 */     this.Snout2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  60 */     this.Snout2.func_78790_a(-0.5F, 1.7F, -5.2F, 1, 2, 1, 0.0F);
/*  61 */     setRotateAngle(this.Snout2, -1.0927507F, 0.0F, 0.0F);
/*  62 */     this.EarL = new ModelRenderer(this, 32, 0);
/*  63 */     this.EarL.field_78809_i = true;
/*  64 */     this.EarL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  65 */     this.EarL.func_78790_a(0.8F, -14.9F, 1.9F, 4, 10, 1, 0.0F);
/*  66 */     setRotateAngle(this.EarL, 0.10995574F, 0.0F, 0.0F);
/*  67 */     this.Snout1 = new ModelRenderer(this, 41, 10);
/*  68 */     this.Snout1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  69 */     this.Snout1.func_78790_a(-1.5F, -3.0F, -5.9F, 3, 3, 2, 0.0F);
/*  70 */     this.tail1 = new ModelRenderer(this, 42, 1);
/*  71 */     this.tail1.func_78793_a(0.0F, 11.9F, 2.3F);
/*  72 */     this.tail1.func_78790_a(-0.5F, -0.3F, -0.5F, 1, 3, 1, 0.0F);
/*  73 */     setRotateAngle(this.tail1, 1.0011208F, 0.0F, 0.0F);
/*  74 */     this.EarR = new ModelRenderer(this, 32, 0);
/*  75 */     this.EarR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  76 */     this.EarR.func_78790_a(-4.8F, -14.9F, 1.9F, 4, 10, 1, 0.0F);
/*  77 */     setRotateAngle(this.EarR, 0.10995574F, 0.0F, 0.0F);
/*  78 */     this.EarL_1 = new ModelRenderer(this, 0, 1);
/*  79 */     this.EarL_1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  80 */     this.EarL_1.func_78790_a(-5.1F, -11.8F, 1.4F, 1, 1, 2, 0.0F);
/*  81 */     this.Body = new ModelRenderer(this, 16, 16);
/*  82 */     this.Body.func_78793_a(0.0F, 0.0F, 0.0F);
/*  83 */     this.Body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.4F);
/*  84 */     this.Head = new ModelRenderer(this, 0, 0);
/*  85 */     this.Head.func_78793_a(0.0F, -0.6F, 0.0F);
/*  86 */     this.Head.func_78790_a(-4.0F, -7.6F, -4.0F, 8, 8, 8, -0.2F);
/*  87 */     this.ArmR = new ModelRenderer(this, 40, 16);
/*  88 */     this.ArmR.func_78793_a(-5.0F, 1.7F, 0.1F);
/*  89 */     this.ArmR.func_78790_a(-2.0F, -2.0F, -2.0F, 3, 12, 4, 0.0F);
/*  90 */     this.tail1.func_78792_a(this.tail2);
/*  91 */     this.Snout1.func_78792_a(this.SnoutSideL);
/*  92 */     this.Snout1.func_78792_a(this.SnoutSideR);
/*  93 */     this.Body.func_78792_a(this.Cloth1);
/*  94 */     this.Snout1.func_78792_a(this.Snout2);
/*  95 */     this.Head.func_78792_a(this.EarL);
/*  96 */     this.Head.func_78792_a(this.Snout1);
/*  97 */     this.Body.func_78792_a(this.tail1);
/*  98 */     this.Head.func_78792_a(this.EarR);
/*  99 */     this.EarL.func_78792_a(this.EarL_1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 104 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 107 */     this.LegL.func_78785_a(f5);
/* 108 */     this.Head.func_78785_a(f5);
/* 109 */     this.ArmL.func_78785_a(f5);
/* 110 */     this.ArmR.func_78785_a(f5);
/* 111 */     this.Body.func_78785_a(f5);
/* 112 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 117 */     modelRenderer.field_78795_f = x;
/* 118 */     modelRenderer.field_78796_g = y;
/* 119 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 123 */     int calc = par7Entity.field_70173_aa;
/* 124 */     if (calc > 100) calc -= 100; 
/* 125 */     float r = 360.0F;
/* 126 */     float r2 = 180.0F;
/* 127 */     float n4 = par4;
/* 128 */     float n5 = par5;
/*     */     
/* 130 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 131 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 132 */     float ex = par7Entity.field_70173_aa;
/* 133 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 134 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 163 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 164 */     this.LegL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 165 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 166 */     this.ArmL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 167 */     this.LegR.field_78796_g = 0.0F;
/* 168 */     this.LegL.field_78796_g = 0.0F;
/* 169 */     this.ArmR.field_78796_g = 0.0F;
/* 170 */     this.ArmL.field_78796_g = 0.0F;
/*     */     
/* 172 */     this.Cloth1.field_78795_f = -0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 173 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelChampa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */