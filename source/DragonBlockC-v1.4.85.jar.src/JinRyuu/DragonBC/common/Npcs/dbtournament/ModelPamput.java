/*     */ package JinRyuu.DragonBC.common.Npcs.dbtournament;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelPamput
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer Hair;
/*     */   public ModelRenderer HairFront;
/*     */   public ModelRenderer HairBack;
/*     */   public ModelRenderer HairTop;
/*     */   public ModelRenderer HairSides;
/*     */   public ModelRenderer HairBack2;
/*     */   public ModelRenderer HairTop2;
/*     */   public ModelRenderer HairSides2;
/*     */   public ModelRenderer HairSides3;
/*     */   
/*     */   public ModelPamput() {
/*  28 */     this.field_78090_t = 128;
/*  29 */     this.field_78089_u = 64;
/*  30 */     this.Head = new ModelRenderer(this, 0, 0);
/*  31 */     this.Head.func_78793_a(0.0F, 0.0F, 0.0F);
/*  32 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
/*  33 */     this.HairSides = new ModelRenderer(this, 90, 25);
/*  34 */     this.HairSides.func_78793_a(0.0F, -0.4F, 1.2F);
/*  35 */     this.HairSides.func_78790_a(-5.0F, -3.0F, -0.9F, 10, 6, 4, 0.0F);
/*  36 */     this.HairTop = new ModelRenderer(this, 94, 2);
/*  37 */     this.HairTop.func_78793_a(0.0F, 0.3F, 0.0F);
/*  38 */     this.HairTop.func_78790_a(-3.5F, -5.0F, -4.0F, 7, 2, 8, 0.0F);
/*  39 */     this.HairBack = new ModelRenderer(this, 68, 16);
/*  40 */     this.HairBack.func_78793_a(0.0F, 0.0F, 4.9F);
/*  41 */     this.HairBack.func_78790_a(-3.5F, -3.0F, -0.2F, 7, 6, 1, 0.0F);
/*  42 */     this.ArmL = new ModelRenderer(this, 26, 19);
/*  43 */     this.ArmL.field_78809_i = true;
/*  44 */     this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
/*  45 */     this.ArmL.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
/*  46 */     this.ArmR = new ModelRenderer(this, 26, 19);
/*  47 */     this.ArmR.func_78793_a(-5.0F, 2.0F, 0.0F);
/*  48 */     this.ArmR.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
/*  49 */     this.Hair = new ModelRenderer(this, 65, 1);
/*  50 */     this.Hair.func_78793_a(0.0F, -4.7F, 0.0F);
/*  51 */     this.Hair.func_78790_a(-4.5F, -4.0F, 0.0F, 9, 8, 5, 0.0F);
/*  52 */     this.HairBack2 = new ModelRenderer(this, 68, 24);
/*  53 */     this.HairBack2.func_78793_a(0.0F, 0.0F, 1.0F);
/*  54 */     this.HairBack2.func_78790_a(-2.5F, -2.0F, -0.7F, 5, 4, 1, 0.0F);
/*  55 */     this.LegL = new ModelRenderer(this, 0, 35);
/*  56 */     this.LegL.field_78809_i = true;
/*  57 */     this.LegL.func_78793_a(2.0F, 12.0F, 0.0F);
/*  58 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  59 */     this.Body = new ModelRenderer(this, 0, 17);
/*  60 */     this.Body.func_78793_a(0.0F, 0.0F, 0.0F);
/*  61 */     this.Body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
/*  62 */     this.HairFront = new ModelRenderer(this, 34, 3);
/*  63 */     this.HairFront.func_78793_a(0.0F, -0.8F, -2.6F);
/*  64 */     this.HairFront.func_78790_a(-4.5F, -3.0F, -2.4F, 9, 4, 5, 0.0F);
/*  65 */     this.HairSides3 = new ModelRenderer(this, 91, 44);
/*  66 */     this.HairSides3.func_78793_a(0.0F, 1.0F, 0.4F);
/*  67 */     this.HairSides3.func_78790_a(-5.5F, -3.0F, -0.9F, 11, 4, 3, 0.0F);
/*  68 */     this.HairSides2 = new ModelRenderer(this, 90, 36);
/*  69 */     this.HairSides2.func_78793_a(0.0F, 0.0F, -1.7F);
/*  70 */     this.HairSides2.func_78790_a(-5.0F, -3.0F, -4.2F, 10, 2, 5, 0.0F);
/*  71 */     this.LegR = new ModelRenderer(this, 0, 35);
/*  72 */     this.LegR.func_78793_a(-2.0F, 12.0F, 0.0F);
/*  73 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  74 */     this.HairTop2 = new ModelRenderer(this, 95, 14);
/*  75 */     this.HairTop2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  76 */     this.HairTop2.func_78790_a(-2.0F, -5.5F, -2.5F, 4, 2, 5, 0.0F);
/*  77 */     this.Hair.func_78792_a(this.HairSides);
/*  78 */     this.Hair.func_78792_a(this.HairTop);
/*  79 */     this.Hair.func_78792_a(this.HairBack);
/*  80 */     this.Head.func_78792_a(this.Hair);
/*  81 */     this.HairBack.func_78792_a(this.HairBack2);
/*  82 */     this.Hair.func_78792_a(this.HairFront);
/*  83 */     this.HairSides.func_78792_a(this.HairSides3);
/*  84 */     this.HairSides.func_78792_a(this.HairSides2);
/*  85 */     this.HairTop.func_78792_a(this.HairTop2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  90 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/*  92 */     this.Head.func_78785_a(f5);
/*     */     
/*  94 */     this.Body.func_78785_a(f5);
/*  95 */     this.ArmR.func_78785_a(f5);
/*  96 */     this.ArmL.func_78785_a(f5);
/*  97 */     this.LegL.func_78785_a(f5);
/*  98 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 108 */     modelRenderer.field_78795_f = x;
/* 109 */     modelRenderer.field_78796_g = y;
/* 110 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 114 */     int calc = par7Entity.field_70173_aa;
/* 115 */     if (calc > 100) calc -= 100; 
/* 116 */     float r = 360.0F;
/* 117 */     float r2 = 180.0F;
/* 118 */     float n4 = par4;
/* 119 */     float n5 = par5;
/*     */     
/* 121 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 122 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 123 */     float ex = par7Entity.field_70173_aa;
/* 124 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 125 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 127 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 128 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbtournament\ModelPamput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */