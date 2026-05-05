/*     */ package JinRyuu.DragonBC.common.Npcs.dbtournament;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelTien2
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer Chest;
/*     */   public ModelRenderer Eye;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer CapeBase;
/*     */   public ModelRenderer Cape;
/*     */   public ModelRenderer ArmR2;
/*     */   public ModelRenderer ArmL2;
/*     */   
/*     */   public ModelTien2() {
/*  26 */     this.field_78090_t = 64;
/*  27 */     this.field_78089_u = 64;
/*  28 */     this.Chest = new ModelRenderer(this, 26, 17);
/*  29 */     this.Chest.func_78793_a(0.0F, 0.0F, 0.0F);
/*  30 */     this.Chest.func_78790_a(-3.5F, 0.0F, -2.0F, 7, 5, 4, 0.0F);
/*  31 */     this.ArmR2 = new ModelRenderer(this, 47, 36);
/*  32 */     this.ArmR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  33 */     this.ArmR2.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
/*  34 */     this.LegL = new ModelRenderer(this, 29, 36);
/*  35 */     this.LegL.field_78809_i = true;
/*  36 */     this.LegL.func_78793_a(2.0F, 12.0F, 0.0F);
/*  37 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  38 */     this.Cape = new ModelRenderer(this, 1, 46);
/*  39 */     this.Cape.func_78793_a(0.0F, 1.3F, 2.3F);
/*  40 */     this.Cape.func_78790_a(-4.0F, 0.0F, 0.0F, 8, 16, 0, 0.0F);
/*  41 */     this.ArmL = new ModelRenderer(this, 47, 24);
/*  42 */     this.ArmL.field_78809_i = true;
/*  43 */     this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
/*  44 */     this.ArmL.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 5, 4, 0.1F);
/*  45 */     this.Body2 = new ModelRenderer(this, 1, 29);
/*  46 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  47 */     this.Body2.func_78790_a(-3.5F, 7.0F, -1.5F, 7, 1, 3, 0.0F);
/*  48 */     this.Head = new ModelRenderer(this, 0, 0);
/*  49 */     this.Head.func_78793_a(0.0F, 0.0F, 0.0F);
/*  50 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
/*  51 */     this.ArmR = new ModelRenderer(this, 47, 24);
/*  52 */     this.ArmR.func_78793_a(-5.0F, 2.0F, 0.0F);
/*  53 */     this.ArmR.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 5, 4, 0.1F);
/*  54 */     this.Eye = new ModelRenderer(this, 0, 0);
/*  55 */     this.Eye.func_78793_a(0.0F, -5.9F, -4.1F);
/*  56 */     this.Eye.func_78790_a(-1.5F, -0.5F, 0.0F, 3, 1, 0, 0.0F);
/*  57 */     this.LegR = new ModelRenderer(this, 29, 36);
/*  58 */     this.LegR.func_78793_a(-2.0F, 12.0F, 0.0F);
/*  59 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  60 */     this.Body3 = new ModelRenderer(this, 1, 35);
/*  61 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  62 */     this.Body3.func_78790_a(-4.0F, 8.0F, -2.0F, 8, 4, 4, 0.0F);
/*  63 */     this.Body = new ModelRenderer(this, 1, 17);
/*  64 */     this.Body.func_78793_a(0.0F, 0.0F, 0.0F);
/*  65 */     this.Body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 7, 4, 0.2F);
/*  66 */     this.CapeBase = new ModelRenderer(this, 19, 55);
/*  67 */     this.CapeBase.func_78793_a(0.0F, 0.0F, 0.0F);
/*  68 */     this.CapeBase.func_78790_a(-3.5F, -0.6F, -2.5F, 7, 2, 5, 0.0F);
/*  69 */     this.ArmL2 = new ModelRenderer(this, 47, 36);
/*  70 */     this.ArmL2.field_78809_i = true;
/*  71 */     this.ArmL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  72 */     this.ArmL2.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
/*  73 */     this.Body.func_78792_a(this.Chest);
/*  74 */     this.ArmR.func_78792_a(this.ArmR2);
/*  75 */     this.CapeBase.func_78792_a(this.Cape);
/*  76 */     this.Body.func_78792_a(this.Body2);
/*  77 */     this.Head.func_78792_a(this.Eye);
/*  78 */     this.Body.func_78792_a(this.Body3);
/*  79 */     this.Body.func_78792_a(this.CapeBase);
/*  80 */     this.ArmL.func_78792_a(this.ArmL2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  85 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/*  87 */     this.Head.func_78785_a(f5);
/*     */     
/*  89 */     this.Body.func_78785_a(f5);
/*  90 */     this.ArmR.func_78785_a(f5);
/*  91 */     this.ArmL.func_78785_a(f5);
/*  92 */     this.LegL.func_78785_a(f5);
/*  93 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 103 */     modelRenderer.field_78795_f = x;
/* 104 */     modelRenderer.field_78796_g = y;
/* 105 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 109 */     int calc = par7Entity.field_70173_aa;
/* 110 */     if (calc > 100) calc -= 100; 
/* 111 */     float r = 360.0F;
/* 112 */     float r2 = 180.0F;
/* 113 */     float n4 = par4;
/* 114 */     float n5 = par5;
/*     */     
/* 116 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 117 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 118 */     float ex = par7Entity.field_70173_aa;
/* 119 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 120 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 122 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 123 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 164 */     this.Cape.field_78795_f = -0.15F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 165 */     if (0.0F > this.Cape.field_78795_f) this.Cape.field_78795_f *= -1.0F; 
/* 166 */     this.Cape.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 177 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 178 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 179 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 180 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 182 */     this.LegR.field_78796_g = 0.0F;
/* 183 */     this.LegL.field_78796_g = 0.0F;
/* 184 */     this.ArmR.field_78796_g = 0.0F;
/* 185 */     this.ArmL.field_78796_g = 0.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbtournament\ModelTien2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */