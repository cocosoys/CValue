/*     */ package JinRyuu.DragonBC.common.Npcs.db;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelMasterRoshi
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer Beard;
/*     */   public ModelRenderer Beard2;
/*     */   public ModelRenderer ArmR2;
/*     */   public ModelRenderer ArmL2;
/*     */   public ModelRenderer FeetR;
/*     */   public ModelRenderer FeetL;
/*     */   
/*     */   public ModelMasterRoshi() {
/*  25 */     this.field_78090_t = 64;
/*  26 */     this.field_78089_u = 64;
/*  27 */     this.LegL = new ModelRenderer(this, 0, 40);
/*  28 */     this.LegL.field_78809_i = true;
/*  29 */     this.LegL.func_78793_a(1.9F, 14.0F, 0.0F);
/*  30 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 8, 4, 0.0F);
/*  31 */     this.Head = new ModelRenderer(this, 0, 0);
/*  32 */     this.Head.func_78793_a(0.0F, 4.7F, 0.0F);
/*  33 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, -0.7F);
/*  34 */     this.ArmR = new ModelRenderer(this, 27, 24);
/*  35 */     this.ArmR.func_78793_a(-4.6F, 5.5F, 0.1F);
/*  36 */     this.ArmR.func_78790_a(-3.0F, -1.7F, -2.0F, 4, 9, 4, -0.3F);
/*  37 */     this.ArmL2 = new ModelRenderer(this, 27, 38);
/*  38 */     this.ArmL2.field_78809_i = true;
/*  39 */     this.ArmL2.func_78793_a(1.1F, 6.4F, 0.1F);
/*  40 */     this.ArmL2.func_78790_a(-1.6F, 0.0F, -1.5F, 3, 2, 3, 0.0F);
/*  41 */     this.FeetR = new ModelRenderer(this, 1, 54);
/*  42 */     this.FeetR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  43 */     this.FeetR.func_78790_a(-1.5F, 8.0F, -2.5F, 3, 2, 4, 0.0F);
/*  44 */     this.Body = new ModelRenderer(this, 0, 23);
/*  45 */     this.Body.func_78793_a(0.0F, 4.0F, 0.1F);
/*  46 */     this.Body.func_78790_a(-4.0F, 0.0F, -2.5F, 8, 10, 5, 0.0F);
/*  47 */     this.LegR = new ModelRenderer(this, 0, 40);
/*  48 */     this.LegR.func_78793_a(-1.9F, 14.0F, 0.0F);
/*  49 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 8, 4, 0.0F);
/*  50 */     this.Beard = new ModelRenderer(this, 27, 2);
/*  51 */     this.Beard.func_78793_a(0.0F, -2.0F, -3.4F);
/*  52 */     this.Beard.func_78790_a(-3.0F, -1.1F, 0.0F, 6, 4, 0, 0.0F);
/*  53 */     this.ArmR2 = new ModelRenderer(this, 27, 38);
/*  54 */     this.ArmR2.func_78793_a(-1.0F, 6.5F, 0.1F);
/*  55 */     this.ArmR2.func_78790_a(-1.6F, 0.0F, -1.5F, 3, 2, 3, 0.0F);
/*  56 */     this.ArmL = new ModelRenderer(this, 27, 24);
/*  57 */     this.ArmL.field_78809_i = true;
/*  58 */     this.ArmL.func_78793_a(4.6F, 5.5F, 0.1F);
/*  59 */     this.ArmL.func_78790_a(-1.0F, -1.7F, -2.0F, 4, 9, 4, -0.3F);
/*  60 */     this.Beard2 = new ModelRenderer(this, 33, 9);
/*  61 */     this.Beard2.func_78793_a(0.0F, 0.7F, 0.15F);
/*  62 */     this.Beard2.func_78790_a(-2.0F, -0.6F, -0.1F, 4, 4, 0, 0.0F);
/*  63 */     this.FeetL = new ModelRenderer(this, 1, 54);
/*  64 */     this.FeetL.field_78809_i = true;
/*  65 */     this.FeetL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  66 */     this.FeetL.func_78790_a(-1.5F, 8.0F, -2.5F, 3, 2, 4, 0.0F);
/*  67 */     this.ArmL.func_78792_a(this.ArmL2);
/*  68 */     this.LegR.func_78792_a(this.FeetR);
/*  69 */     this.Head.func_78792_a(this.Beard);
/*  70 */     this.ArmR.func_78792_a(this.ArmR2);
/*  71 */     this.Beard.func_78792_a(this.Beard2);
/*  72 */     this.LegL.func_78792_a(this.FeetL);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  77 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/*  79 */     this.Head.func_78785_a(f5);
/*     */     
/*  81 */     this.Body.func_78785_a(f5);
/*  82 */     this.ArmR.func_78785_a(f5);
/*  83 */     this.ArmL.func_78785_a(f5);
/*  84 */     this.LegL.func_78785_a(f5);
/*  85 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/*  95 */     modelRenderer.field_78795_f = x;
/*  96 */     modelRenderer.field_78796_g = y;
/*  97 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 101 */     int calc = par7Entity.field_70173_aa;
/* 102 */     if (calc > 100) calc -= 100; 
/* 103 */     float r = 360.0F;
/* 104 */     float r2 = 180.0F;
/* 105 */     float n4 = par4;
/* 106 */     float n5 = par5;
/*     */     
/* 108 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 109 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 110 */     float ex = par7Entity.field_70173_aa;
/* 111 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 112 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 114 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 115 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 164 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 165 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 166 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 167 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 169 */     this.LegR.field_78796_g = 0.0F;
/* 170 */     this.LegL.field_78796_g = 0.0F;
/* 171 */     this.ArmR.field_78796_g = 0.0F;
/* 172 */     this.ArmL.field_78796_g = 0.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\db\ModelMasterRoshi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */