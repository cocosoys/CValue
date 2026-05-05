/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelDyspo
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer EarL;
/*     */   public ModelRenderer EarR;
/*     */   public ModelRenderer Snout1;
/*     */   public ModelRenderer Snout2;
/*     */   public ModelRenderer SnoutSideR;
/*     */   public ModelRenderer SnoutSideL;
/*     */   public ModelRenderer Neck;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Body3;
/*     */   
/*     */   public ModelDyspo() {
/*  27 */     this.field_78090_t = 64;
/*  28 */     this.field_78089_u = 64;
/*  29 */     this.EarL = new ModelRenderer(this, 31, 0);
/*  30 */     this.EarL.field_78809_i = true;
/*  31 */     this.EarL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  32 */     this.EarL.func_78790_a(0.9F, -15.1F, 1.9F, 4, 10, 1, 0.0F);
/*  33 */     setRotateAngle(this.EarL, 0.10995574F, 0.0F, 0.0F);
/*  34 */     this.Snout2 = new ModelRenderer(this, 42, 11);
/*  35 */     this.Snout2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  36 */     this.Snout2.func_78790_a(-0.5F, 1.1F, -5.4F, 1, 2, 1, 0.0F);
/*  37 */     setRotateAngle(this.Snout2, -1.0927507F, 0.0F, 0.0F);
/*  38 */     this.Snout1 = new ModelRenderer(this, 41, 14);
/*  39 */     this.Snout1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  40 */     this.Snout1.func_78790_a(-1.5F, -3.4F, -5.4F, 3, 3, 2, 0.0F);
/*  41 */     this.Body2 = new ModelRenderer(this, 23, 29);
/*  42 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  43 */     this.Body2.func_78790_a(-3.0F, 5.0F, -1.7F, 6, 3, 3, 0.0F);
/*  44 */     this.ArmL = new ModelRenderer(this, 50, 16);
/*  45 */     this.ArmL.field_78809_i = true;
/*  46 */     this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
/*  47 */     this.ArmL.func_78790_a(-1.0F, -2.0F, -1.8F, 3, 12, 4, 0.0F);
/*  48 */     this.Body1 = new ModelRenderer(this, 20, 18);
/*  49 */     this.Body1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  50 */     this.Body1.func_78790_a(-4.0F, 0.0F, -1.8F, 8, 5, 4, 0.0F);
/*  51 */     this.SnoutSideL = new ModelRenderer(this, 47, 11);
/*  52 */     this.SnoutSideL.field_78809_i = true;
/*  53 */     this.SnoutSideL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  54 */     this.SnoutSideL.func_78790_a(-1.7F, -3.2F, -5.0F, 2, 2, 1, 0.0F);
/*  55 */     setRotateAngle(this.SnoutSideL, 0.0F, -0.5934119F, 0.0F);
/*  56 */     this.LegR = new ModelRenderer(this, 0, 33);
/*  57 */     this.LegR.func_78793_a(-1.8F, 12.0F, 0.0F);
/*  58 */     this.LegR.func_78790_a(-2.1F, 0.0F, -2.0F, 4, 12, 4, 0.2F);
/*  59 */     this.Head = new ModelRenderer(this, 0, 0);
/*  60 */     this.Head.func_78793_a(0.0F, -0.4F, 0.0F);
/*  61 */     this.Head.func_78790_a(-3.5F, -8.0F, -4.0F, 7, 8, 8, -0.1F);
/*  62 */     this.Body3 = new ModelRenderer(this, 20, 37);
/*  63 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  64 */     this.Body3.func_78790_a(-4.0F, 8.0F, -2.0F, 8, 4, 4, 0.0F);
/*  65 */     this.ArmR = new ModelRenderer(this, 50, 16);
/*  66 */     this.ArmR.func_78793_a(-5.0F, 2.0F, 0.0F);
/*  67 */     this.ArmR.func_78790_a(-2.0F, -2.0F, -1.8F, 3, 12, 4, 0.0F);
/*  68 */     this.LegL = new ModelRenderer(this, 0, 33);
/*  69 */     this.LegL.field_78809_i = true;
/*  70 */     this.LegL.func_78793_a(1.8F, 12.0F, 0.0F);
/*  71 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.2F);
/*  72 */     this.SnoutSideR = new ModelRenderer(this, 47, 11);
/*  73 */     this.SnoutSideR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  74 */     this.SnoutSideR.func_78790_a(-0.2F, -3.2F, -5.0F, 2, 2, 1, 0.0F);
/*  75 */     setRotateAngle(this.SnoutSideR, 0.0F, 0.5934119F, 0.0F);
/*  76 */     this.Neck = new ModelRenderer(this, 42, 6);
/*  77 */     this.Neck.func_78793_a(0.0F, 0.0F, 0.0F);
/*  78 */     this.Neck.func_78790_a(-2.0F, -0.9F, -0.8F, 4, 2, 2, 0.0F);
/*  79 */     this.EarR = new ModelRenderer(this, 31, 0);
/*  80 */     this.EarR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  81 */     this.EarR.func_78790_a(-5.0F, -15.1F, 1.9F, 4, 10, 1, 0.0F);
/*  82 */     setRotateAngle(this.EarR, 0.10995574F, 0.0F, 0.0F);
/*  83 */     this.Head.func_78792_a(this.EarL);
/*  84 */     this.Snout1.func_78792_a(this.Snout2);
/*  85 */     this.Head.func_78792_a(this.Snout1);
/*  86 */     this.Body1.func_78792_a(this.Body2);
/*  87 */     this.Snout1.func_78792_a(this.SnoutSideL);
/*  88 */     this.Body2.func_78792_a(this.Body3);
/*  89 */     this.Snout1.func_78792_a(this.SnoutSideR);
/*  90 */     this.Body1.func_78792_a(this.Neck);
/*  91 */     this.Head.func_78792_a(this.EarR);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  96 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/*  99 */     this.LegL.func_78785_a(f5);
/* 100 */     this.Head.func_78785_a(f5);
/* 101 */     this.ArmL.func_78785_a(f5);
/* 102 */     this.ArmR.func_78785_a(f5);
/* 103 */     this.Body1.func_78785_a(f5);
/* 104 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 176 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 177 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 178 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 179 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 181 */     this.LegR.field_78796_g = 0.0F;
/* 182 */     this.LegL.field_78796_g = 0.0F;
/* 183 */     this.ArmR.field_78796_g = 0.0F;
/* 184 */     this.ArmL.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 191 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelDyspo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */