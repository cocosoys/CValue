/*     */ package JinRyuu.DragonBC.common.Npcs.dbtournament;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelJackieChun
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
/*     */   public ModelRenderer ArmR2;
/*     */   public ModelRenderer ArmL2;
/*     */   public ModelRenderer FeetR;
/*     */   public ModelRenderer FeetL;
/*     */   
/*     */   public ModelJackieChun() {
/*  27 */     this.field_78090_t = 64;
/*  28 */     this.field_78089_u = 64;
/*  29 */     this.LegR = new ModelRenderer(this, 0, 40);
/*  30 */     this.LegR.func_78793_a(-1.9F, 14.0F, 0.0F);
/*  31 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 8, 4, 0.0F);
/*  32 */     this.ArmR2 = new ModelRenderer(this, 27, 38);
/*  33 */     this.ArmR2.func_78793_a(-1.0F, 6.5F, 0.1F);
/*  34 */     this.ArmR2.func_78790_a(-1.6F, 0.0F, -1.5F, 3, 2, 3, 0.0F);
/*  35 */     this.Body = new ModelRenderer(this, 0, 23);
/*  36 */     this.Body.func_78793_a(0.0F, 4.0F, 0.1F);
/*  37 */     this.Body.func_78790_a(-4.0F, 0.0F, -2.5F, 8, 10, 5, 0.0F);
/*  38 */     this.Hair1 = new ModelRenderer(this, 40, 56);
/*  39 */     this.Hair1.func_78793_a(0.0F, -5.3F, 2.7F);
/*  40 */     this.Hair1.func_78790_a(-3.5F, -2.5F, -2.1F, 7, 4, 3, 0.0F);
/*  41 */     this.FeetL = new ModelRenderer(this, 1, 54);
/*  42 */     this.FeetL.field_78809_i = true;
/*  43 */     this.FeetL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  44 */     this.FeetL.func_78790_a(-1.5F, 8.0F, -2.5F, 3, 2, 4, 0.0F);
/*  45 */     this.Head = new ModelRenderer(this, 0, 0);
/*  46 */     this.Head.func_78793_a(0.0F, 4.7F, 0.0F);
/*  47 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, -0.7F);
/*  48 */     this.Beard2 = new ModelRenderer(this, 33, 9);
/*  49 */     this.Beard2.func_78793_a(0.0F, 0.7F, 0.15F);
/*  50 */     this.Beard2.func_78790_a(-2.0F, -0.6F, -0.1F, 4, 4, 0, 0.0F);
/*  51 */     this.ArmL = new ModelRenderer(this, 27, 24);
/*  52 */     this.ArmL.field_78809_i = true;
/*  53 */     this.ArmL.func_78793_a(4.6F, 5.5F, 0.1F);
/*  54 */     this.ArmL.func_78790_a(-1.0F, -1.7F, -2.0F, 4, 9, 4, -0.3F);
/*  55 */     this.ArmR = new ModelRenderer(this, 27, 24);
/*  56 */     this.ArmR.func_78793_a(-4.6F, 5.5F, 0.1F);
/*  57 */     this.ArmR.func_78790_a(-3.0F, -1.7F, -2.0F, 4, 9, 4, -0.3F);
/*  58 */     this.Hair2 = new ModelRenderer(this, 43, 43);
/*  59 */     this.Hair2.func_78793_a(0.0F, -6.0F, 0.0F);
/*  60 */     this.Hair2.func_78790_a(-2.0F, -2.7F, -3.6F, 4, 3, 5, 0.0F);
/*  61 */     this.ArmL2 = new ModelRenderer(this, 27, 38);
/*  62 */     this.ArmL2.field_78809_i = true;
/*  63 */     this.ArmL2.func_78793_a(1.1F, 6.4F, 0.1F);
/*  64 */     this.ArmL2.func_78790_a(-1.6F, 0.0F, -1.5F, 3, 2, 3, 0.0F);
/*  65 */     this.LegL = new ModelRenderer(this, 0, 40);
/*  66 */     this.LegL.field_78809_i = true;
/*  67 */     this.LegL.func_78793_a(1.9F, 14.0F, 0.0F);
/*  68 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 8, 4, 0.0F);
/*  69 */     this.Beard = new ModelRenderer(this, 27, 2);
/*  70 */     this.Beard.func_78793_a(0.0F, -2.0F, -3.4F);
/*  71 */     this.Beard.func_78790_a(-3.0F, -1.1F, 0.0F, 6, 4, 0, 0.0F);
/*  72 */     this.FeetR = new ModelRenderer(this, 1, 54);
/*  73 */     this.FeetR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  74 */     this.FeetR.func_78790_a(-1.5F, 8.0F, -2.5F, 3, 2, 4, 0.0F);
/*  75 */     this.ArmR.func_78792_a(this.ArmR2);
/*  76 */     this.Head.func_78792_a(this.Hair1);
/*  77 */     this.LegL.func_78792_a(this.FeetL);
/*  78 */     this.Beard.func_78792_a(this.Beard2);
/*  79 */     this.Head.func_78792_a(this.Hair2);
/*  80 */     this.ArmL.func_78792_a(this.ArmL2);
/*  81 */     this.Head.func_78792_a(this.Beard);
/*  82 */     this.LegR.func_78792_a(this.FeetR);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  87 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/*  89 */     this.Head.func_78785_a(f5);
/*     */     
/*  91 */     this.Body.func_78785_a(f5);
/*  92 */     this.ArmR.func_78785_a(f5);
/*  93 */     this.ArmL.func_78785_a(f5);
/*  94 */     this.LegL.func_78785_a(f5);
/*  95 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 104 */     modelRenderer.field_78795_f = x;
/* 105 */     modelRenderer.field_78796_g = y;
/* 106 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 110 */     int calc = par7Entity.field_70173_aa;
/* 111 */     if (calc > 100) calc -= 100; 
/* 112 */     float r = 360.0F;
/* 113 */     float r2 = 180.0F;
/* 114 */     float n4 = par4;
/* 115 */     float n5 = par5;
/*     */     
/* 117 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 118 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 119 */     float ex = par7Entity.field_70173_aa;
/* 120 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 121 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 123 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 124 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 173 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 174 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 175 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 176 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 178 */     this.LegR.field_78796_g = 0.0F;
/* 179 */     this.LegL.field_78796_g = 0.0F;
/* 180 */     this.ArmR.field_78796_g = 0.0F;
/* 181 */     this.ArmL.field_78796_g = 0.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbtournament\ModelJackieChun.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */