/*     */ package JinRyuu.DragonBC.common.Npcs.dbtournament;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelMasterShen
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer Hair;
/*     */   public ModelRenderer Beard;
/*     */   public ModelRenderer Hat;
/*     */   public ModelRenderer HairR;
/*     */   public ModelRenderer HairL;
/*     */   public ModelRenderer HairR2;
/*     */   public ModelRenderer HairL2;
/*     */   public ModelRenderer Hat2;
/*     */   public ModelRenderer Hat3;
/*     */   public ModelRenderer ArmR2;
/*     */   public ModelRenderer ArmL2;
/*     */   public ModelRenderer FeetR;
/*     */   public ModelRenderer FeetL;
/*     */   
/*     */   public ModelMasterShen() {
/*  32 */     this.field_78090_t = 64;
/*  33 */     this.field_78089_u = 64;
/*  34 */     this.ArmR = new ModelRenderer(this, 27, 24);
/*  35 */     this.ArmR.func_78793_a(-4.6F, 5.5F, 0.1F);
/*  36 */     this.ArmR.func_78790_a(-3.0F, -1.7F, -2.0F, 4, 9, 4, -0.3F);
/*  37 */     this.Head = new ModelRenderer(this, 0, 0);
/*  38 */     this.Head.func_78793_a(0.0F, 4.7F, 0.0F);
/*  39 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, -0.7F);
/*  40 */     this.ArmL = new ModelRenderer(this, 27, 24);
/*  41 */     this.ArmL.field_78809_i = true;
/*  42 */     this.ArmL.func_78793_a(4.6F, 5.5F, 0.1F);
/*  43 */     this.ArmL.func_78790_a(-1.0F, -1.7F, -2.0F, 4, 9, 4, -0.3F);
/*  44 */     this.Hair = new ModelRenderer(this, 39, 55);
/*  45 */     this.Hair.func_78793_a(0.0F, -3.3F, 3.4F);
/*  46 */     this.Hair.func_78790_a(-4.0F, -2.5F, -2.9F, 8, 4, 4, 0.0F);
/*  47 */     this.HairR = new ModelRenderer(this, 53, 47);
/*  48 */     this.HairR.func_78793_a(-4.4F, -1.1F, -0.9F);
/*  49 */     this.HairR.func_78790_a(-1.0F, -1.5F, -1.5F, 2, 3, 3, 0.0F);
/*  50 */     this.ArmL2 = new ModelRenderer(this, 27, 38);
/*  51 */     this.ArmL2.field_78809_i = true;
/*  52 */     this.ArmL2.func_78793_a(1.1F, 6.4F, 0.1F);
/*  53 */     this.ArmL2.func_78790_a(-1.6F, 0.0F, -1.5F, 3, 2, 3, 0.0F);
/*  54 */     this.LegL = new ModelRenderer(this, 0, 40);
/*  55 */     this.LegL.field_78809_i = true;
/*  56 */     this.LegL.func_78793_a(1.9F, 14.0F, 0.0F);
/*  57 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 8, 4, 0.0F);
/*  58 */     this.HairR2 = new ModelRenderer(this, 56, 41);
/*  59 */     this.HairR2.func_78793_a(-1.0F, -1.0F, 0.5F);
/*  60 */     this.HairR2.func_78790_a(-0.5F, -1.5F, -1.5F, 1, 3, 2, 0.0F);
/*  61 */     this.FeetL = new ModelRenderer(this, 1, 54);
/*  62 */     this.FeetL.field_78809_i = true;
/*  63 */     this.FeetL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  64 */     this.FeetL.func_78790_a(-1.5F, 8.0F, -2.5F, 3, 2, 4, 0.0F);
/*  65 */     this.Body = new ModelRenderer(this, 0, 23);
/*  66 */     this.Body.func_78793_a(0.0F, 4.0F, 0.1F);
/*  67 */     this.Body.func_78790_a(-4.0F, 0.0F, -2.5F, 8, 10, 5, 0.0F);
/*  68 */     this.HairL = new ModelRenderer(this, 53, 47);
/*  69 */     this.HairL.func_78793_a(4.4F, -1.3F, -0.9F);
/*  70 */     this.HairL.func_78790_a(-1.0F, -1.5F, -1.5F, 2, 3, 3, 0.0F);
/*  71 */     this.Hat = new ModelRenderer(this, 40, 2);
/*  72 */     this.Hat.func_78793_a(0.0F, -6.7F, 0.1F);
/*  73 */     this.Hat.func_78790_a(-0.5F, -2.0F, -1.0F, 1, 2, 2, 0.0F);
/*  74 */     this.HairL2 = new ModelRenderer(this, 56, 41);
/*  75 */     this.HairL2.func_78793_a(0.9F, -1.0F, 0.5F);
/*  76 */     this.HairL2.func_78790_a(-0.5F, -1.5F, -1.5F, 1, 3, 2, 0.0F);
/*  77 */     this.FeetR = new ModelRenderer(this, 1, 54);
/*  78 */     this.FeetR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  79 */     this.FeetR.func_78790_a(-1.5F, 8.0F, -2.5F, 3, 2, 4, 0.0F);
/*  80 */     this.Beard = new ModelRenderer(this, 27, 2);
/*  81 */     this.Beard.func_78793_a(0.0F, -1.6F, -3.4F);
/*  82 */     this.Beard.func_78790_a(-3.0F, -1.1F, 0.0F, 6, 4, 0, 0.0F);
/*  83 */     this.LegR = new ModelRenderer(this, 0, 40);
/*  84 */     this.LegR.func_78793_a(-1.9F, 14.0F, 0.0F);
/*  85 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 8, 4, 0.0F);
/*  86 */     this.Hat2 = new ModelRenderer(this, 47, 1);
/*  87 */     this.Hat2.func_78793_a(0.0F, -3.0F, -1.0F);
/*  88 */     this.Hat2.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 2, 3, 0.0F);
/*  89 */     this.Hat3 = new ModelRenderer(this, 54, -1);
/*  90 */     this.Hat3.func_78793_a(0.0F, 0.0F, -2.0F);
/*  91 */     this.Hat3.func_78790_a(0.0F, -1.0F, -1.0F, 0, 2, 2, 0.0F);
/*  92 */     this.ArmR2 = new ModelRenderer(this, 27, 38);
/*  93 */     this.ArmR2.func_78793_a(-1.0F, 6.5F, 0.1F);
/*  94 */     this.ArmR2.func_78790_a(-1.6F, 0.0F, -1.5F, 3, 2, 3, 0.0F);
/*  95 */     this.Head.func_78792_a(this.Hair);
/*  96 */     this.Hair.func_78792_a(this.HairR);
/*  97 */     this.ArmL.func_78792_a(this.ArmL2);
/*  98 */     this.HairR.func_78792_a(this.HairR2);
/*  99 */     this.LegL.func_78792_a(this.FeetL);
/* 100 */     this.Hair.func_78792_a(this.HairL);
/* 101 */     this.Head.func_78792_a(this.Hat);
/* 102 */     this.HairL.func_78792_a(this.HairL2);
/* 103 */     this.LegR.func_78792_a(this.FeetR);
/* 104 */     this.Head.func_78792_a(this.Beard);
/* 105 */     this.Hat.func_78792_a(this.Hat2);
/* 106 */     this.Hat2.func_78792_a(this.Hat3);
/* 107 */     this.ArmR.func_78792_a(this.ArmR2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 112 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 114 */     this.Head.func_78785_a(f5);
/*     */     
/* 116 */     this.Body.func_78785_a(f5);
/* 117 */     this.ArmR.func_78785_a(f5);
/* 118 */     this.ArmL.func_78785_a(f5);
/* 119 */     this.LegL.func_78785_a(f5);
/* 120 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 130 */     modelRenderer.field_78795_f = x;
/* 131 */     modelRenderer.field_78796_g = y;
/* 132 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 136 */     int calc = par7Entity.field_70173_aa;
/* 137 */     if (calc > 100) calc -= 100; 
/* 138 */     float r = 360.0F;
/* 139 */     float r2 = 180.0F;
/* 140 */     float n4 = par4;
/* 141 */     float n5 = par5;
/*     */     
/* 143 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 144 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 145 */     float ex = par7Entity.field_70173_aa;
/* 146 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 147 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 149 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 150 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 199 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 200 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 201 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 202 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 204 */     this.LegR.field_78796_g = 0.0F;
/* 205 */     this.LegL.field_78796_g = 0.0F;
/* 206 */     this.ArmR.field_78796_g = 0.0F;
/* 207 */     this.ArmL.field_78796_g = 0.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbtournament\ModelMasterShen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */