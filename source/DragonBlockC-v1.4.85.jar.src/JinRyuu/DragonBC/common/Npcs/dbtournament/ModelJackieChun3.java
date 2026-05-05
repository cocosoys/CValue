/*     */ package JinRyuu.DragonBC.common.Npcs.dbtournament;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelJackieChun3
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer Hair1;
/*     */   public ModelRenderer Hair2;
/*     */   public ModelRenderer Beard;
/*     */   public ModelRenderer Beard2;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer FeetR;
/*     */   public ModelRenderer FeetL;
/*     */   
/*     */   public ModelJackieChun3() {
/*  27 */     this.field_78090_t = 64;
/*  28 */     this.field_78089_u = 64;
/*  29 */     this.LegL = new ModelRenderer(this, 0, 49);
/*  30 */     this.LegL.field_78809_i = true;
/*  31 */     this.LegL.func_78793_a(1.9F, 14.0F, 0.0F);
/*  32 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 8, 4, 0.0F);
/*  33 */     this.Beard2 = new ModelRenderer(this, 33, 9);
/*  34 */     this.Beard2.func_78793_a(0.0F, 0.7F, 0.15F);
/*  35 */     this.Beard2.func_78790_a(-2.0F, -0.6F, -0.1F, 4, 4, 0, 0.0F);
/*  36 */     this.Hair2 = new ModelRenderer(this, 43, 43);
/*  37 */     this.Hair2.func_78793_a(0.0F, -6.0F, 0.0F);
/*  38 */     this.Hair2.func_78790_a(-2.0F, -2.7F, -3.6F, 4, 3, 5, 0.0F);
/*  39 */     this.Body3 = new ModelRenderer(this, 4, 41);
/*  40 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  41 */     this.Body3.func_78790_a(-3.5F, 7.0F, -2.0F, 7, 3, 4, 0.0F);
/*  42 */     this.FeetR = new ModelRenderer(this, 17, 53);
/*  43 */     this.FeetR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  44 */     this.FeetR.func_78790_a(-1.5F, 8.0F, -2.5F, 3, 2, 4, 0.0F);
/*  45 */     this.Body2 = new ModelRenderer(this, 6, 35);
/*  46 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  47 */     this.Body2.func_78790_a(-3.1F, 5.5F, -1.5F, 6, 2, 3, 0.0F);
/*  48 */     this.Hair1 = new ModelRenderer(this, 40, 56);
/*  49 */     this.Hair1.func_78793_a(0.0F, -5.3F, 2.7F);
/*  50 */     this.Hair1.func_78790_a(-3.5F, -2.5F, -2.1F, 7, 4, 3, 0.0F);
/*  51 */     this.Beard = new ModelRenderer(this, 27, 2);
/*  52 */     this.Beard.func_78793_a(0.0F, -2.0F, -3.4F);
/*  53 */     this.Beard.func_78790_a(-3.0F, -1.1F, 0.0F, 6, 4, 0, 0.0F);
/*  54 */     this.Body = new ModelRenderer(this, 3, 23);
/*  55 */     this.Body.func_78793_a(0.0F, 4.0F, 0.1F);
/*  56 */     this.Body.func_78790_a(-3.5F, 0.0F, -2.0F, 7, 6, 4, 0.0F);
/*  57 */     this.ArmR = new ModelRenderer(this, 28, 23);
/*  58 */     this.ArmR.func_78793_a(-3.9F, 5.4F, 0.1F);
/*  59 */     this.ArmR.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 11, 4, -0.6F);
/*  60 */     this.Head = new ModelRenderer(this, 0, 0);
/*  61 */     this.Head.func_78793_a(0.0F, 4.7F, 0.0F);
/*  62 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, -0.7F);
/*  63 */     this.LegR = new ModelRenderer(this, 0, 49);
/*  64 */     this.LegR.func_78793_a(-1.9F, 14.0F, 0.0F);
/*  65 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 8, 4, 0.0F);
/*  66 */     this.FeetL = new ModelRenderer(this, 17, 53);
/*  67 */     this.FeetL.field_78809_i = true;
/*  68 */     this.FeetL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  69 */     this.FeetL.func_78790_a(-1.5F, 8.0F, -2.5F, 3, 2, 4, 0.0F);
/*  70 */     this.ArmL = new ModelRenderer(this, 28, 23);
/*  71 */     this.ArmL.field_78809_i = true;
/*  72 */     this.ArmL.func_78793_a(3.9F, 5.4F, 0.1F);
/*  73 */     this.ArmL.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 11, 4, -0.6F);
/*  74 */     this.Beard.func_78792_a(this.Beard2);
/*  75 */     this.Head.func_78792_a(this.Hair2);
/*  76 */     this.Body.func_78792_a(this.Body3);
/*  77 */     this.LegR.func_78792_a(this.FeetR);
/*  78 */     this.Body.func_78792_a(this.Body2);
/*  79 */     this.Head.func_78792_a(this.Hair1);
/*  80 */     this.Head.func_78792_a(this.Beard);
/*  81 */     this.LegL.func_78792_a(this.FeetL);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  86 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/*  88 */     this.Head.func_78785_a(f5);
/*     */     
/*  90 */     this.Body.func_78785_a(f5);
/*  91 */     this.ArmR.func_78785_a(f5);
/*  92 */     this.ArmL.func_78785_a(f5);
/*  93 */     this.LegL.func_78785_a(f5);
/*  94 */     this.LegR.func_78785_a(f5);
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 172 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 173 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 174 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 175 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 177 */     this.LegR.field_78796_g = 0.0F;
/* 178 */     this.LegL.field_78796_g = 0.0F;
/* 179 */     this.ArmR.field_78796_g = 0.0F;
/* 180 */     this.ArmL.field_78796_g = 0.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbtournament\ModelJackieChun3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */