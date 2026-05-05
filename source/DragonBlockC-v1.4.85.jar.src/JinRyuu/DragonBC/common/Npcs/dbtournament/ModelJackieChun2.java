/*     */ package JinRyuu.DragonBC.common.Npcs.dbtournament;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelJackieChun2
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer Hair1;
/*     */   public ModelRenderer Hair2;
/*     */   public ModelRenderer Beard;
/*     */   public ModelRenderer Beard2;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Chest;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer ArmR2;
/*     */   public ModelRenderer ArmR3;
/*     */   public ModelRenderer ArmL2;
/*     */   public ModelRenderer ArmL3;
/*     */   public ModelRenderer FeetL;
/*     */   public ModelRenderer FeetR;
/*     */   
/*     */   public ModelJackieChun2() {
/*  32 */     this.field_78090_t = 128;
/*  33 */     this.field_78089_u = 64;
/*  34 */     this.Head = new ModelRenderer(this, 0, 0);
/*  35 */     this.Head.func_78793_a(0.0F, -2.7F, 0.0F);
/*  36 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, -0.7F);
/*  37 */     this.ArmL = new ModelRenderer(this, 62, 17);
/*  38 */     this.ArmL.field_78809_i = true;
/*  39 */     this.ArmL.func_78793_a(6.7F, -2.2F, 0.5F);
/*  40 */     this.ArmL.func_78790_a(-1.5F, -2.0F, -2.5F, 6, 4, 5, 0.0F);
/*  41 */     this.ArmL3 = new ModelRenderer(this, 61, 39);
/*  42 */     this.ArmL3.field_78809_i = true;
/*  43 */     this.ArmL3.func_78793_a(1.4F, 6.4F, -0.8F);
/*  44 */     this.ArmL3.func_78790_a(-2.5F, 0.0F, -1.9F, 5, 6, 5, 0.0F);
/*  45 */     setRotateAngle(this.ArmL3, -0.18203785F, 0.0F, 0.0F);
/*  46 */     this.ArmR = new ModelRenderer(this, 62, 17);
/*  47 */     this.ArmR.func_78793_a(-6.7F, -2.2F, 0.5F);
/*  48 */     this.ArmR.func_78790_a(-4.5F, -2.0F, -2.5F, 6, 4, 5, 0.0F);
/*  49 */     this.ArmR2 = new ModelRenderer(this, 62, 27);
/*  50 */     this.ArmR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  51 */     this.ArmR2.func_78790_a(-4.1F, 1.5F, -2.7F, 5, 5, 5, 0.0F);
/*  52 */     this.Hair1 = new ModelRenderer(this, 45, 1);
/*  53 */     this.Hair1.func_78793_a(0.0F, -5.3F, 2.7F);
/*  54 */     this.Hair1.func_78790_a(-3.5F, -2.5F, -2.1F, 7, 4, 3, 0.0F);
/*  55 */     this.FeetL = new ModelRenderer(this, 34, 50);
/*  56 */     this.FeetL.field_78809_i = true;
/*  57 */     this.FeetL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  58 */     this.FeetL.func_78790_a(-2.0F, 12.0F, -3.3F, 4, 2, 5, 0.0F);
/*  59 */     this.LegL = new ModelRenderer(this, 33, 32);
/*  60 */     this.LegL.field_78809_i = true;
/*  61 */     this.LegL.func_78793_a(2.5F, 10.0F, 0.0F);
/*  62 */     this.LegL.func_78790_a(-2.5F, 0.0F, -2.5F, 5, 12, 5, 0.0F);
/*  63 */     this.ArmL2 = new ModelRenderer(this, 62, 27);
/*  64 */     this.ArmL2.field_78809_i = true;
/*  65 */     this.ArmL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  66 */     this.ArmL2.func_78790_a(-0.9F, 1.5F, -2.7F, 5, 5, 5, 0.0F);
/*  67 */     this.Chest = new ModelRenderer(this, 34, 16);
/*  68 */     this.Chest.func_78793_a(0.0F, 0.0F, 0.0F);
/*  69 */     this.Chest.func_78790_a(-5.0F, 1.0F, -2.5F, 10, 4, 1, 0.0F);
/*  70 */     this.Body = new ModelRenderer(this, 0, 17);
/*  71 */     this.Body.func_78793_a(0.0F, -3.5F, 0.0F);
/*  72 */     this.Body.func_78790_a(-6.0F, 0.0F, -1.9F, 12, 7, 5, 0.0F);
/*  73 */     this.Body3 = new ModelRenderer(this, 0, 42);
/*  74 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  75 */     this.Body3.func_78790_a(-5.0F, 9.5F, -2.4F, 10, 4, 5, 0.0F);
/*  76 */     this.LegR = new ModelRenderer(this, 33, 32);
/*  77 */     this.LegR.func_78793_a(-2.5F, 10.0F, 0.0F);
/*  78 */     this.LegR.func_78790_a(-2.5F, 0.0F, -2.5F, 5, 12, 5, 0.0F);
/*  79 */     this.Beard = new ModelRenderer(this, 27, 2);
/*  80 */     this.Beard.func_78793_a(0.0F, -2.0F, -3.4F);
/*  81 */     this.Beard.func_78790_a(-3.0F, -1.1F, 0.0F, 6, 4, 0, 0.0F);
/*  82 */     this.Beard2 = new ModelRenderer(this, 33, 9);
/*  83 */     this.Beard2.func_78793_a(0.0F, 0.7F, 0.15F);
/*  84 */     this.Beard2.func_78790_a(-2.0F, -0.6F, -0.1F, 4, 4, 0, 0.0F);
/*  85 */     this.Hair2 = new ModelRenderer(this, 66, 1);
/*  86 */     this.Hair2.func_78793_a(0.0F, -6.0F, 0.0F);
/*  87 */     this.Hair2.func_78790_a(-2.0F, -2.7F, -3.6F, 4, 3, 5, 0.0F);
/*  88 */     this.Body2 = new ModelRenderer(this, 0, 31);
/*  89 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  90 */     this.Body2.func_78790_a(-4.5F, 5.0F, -2.0F, 9, 5, 4, 0.0F);
/*  91 */     this.ArmR3 = new ModelRenderer(this, 61, 39);
/*  92 */     this.ArmR3.func_78793_a(-1.4F, 6.4F, -0.8F);
/*  93 */     this.ArmR3.func_78790_a(-2.5F, 0.0F, -1.9F, 5, 6, 5, 0.0F);
/*  94 */     setRotateAngle(this.ArmR3, -0.22759093F, 0.0F, 0.0F);
/*  95 */     this.FeetR = new ModelRenderer(this, 34, 50);
/*  96 */     this.FeetR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  97 */     this.FeetR.func_78790_a(-2.0F, 12.0F, -3.3F, 4, 2, 5, 0.0F);
/*  98 */     this.ArmL2.func_78792_a(this.ArmL3);
/*  99 */     this.ArmR.func_78792_a(this.ArmR2);
/* 100 */     this.Head.func_78792_a(this.Hair1);
/* 101 */     this.LegL.func_78792_a(this.FeetL);
/* 102 */     this.ArmL.func_78792_a(this.ArmL2);
/* 103 */     this.Body.func_78792_a(this.Chest);
/* 104 */     this.Body2.func_78792_a(this.Body3);
/* 105 */     this.Head.func_78792_a(this.Beard);
/* 106 */     this.Beard.func_78792_a(this.Beard2);
/* 107 */     this.Head.func_78792_a(this.Hair2);
/* 108 */     this.Body.func_78792_a(this.Body2);
/* 109 */     this.ArmR2.func_78792_a(this.ArmR3);
/* 110 */     this.LegR.func_78792_a(this.FeetR);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 115 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 117 */     this.Head.func_78785_a(f5);
/*     */     
/* 119 */     this.Body.func_78785_a(f5);
/* 120 */     this.ArmR.func_78785_a(f5);
/* 121 */     this.ArmL.func_78785_a(f5);
/* 122 */     this.LegL.func_78785_a(f5);
/* 123 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 132 */     modelRenderer.field_78795_f = x;
/* 133 */     modelRenderer.field_78796_g = y;
/* 134 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 138 */     int calc = par7Entity.field_70173_aa;
/* 139 */     if (calc > 100) calc -= 100; 
/* 140 */     float r = 360.0F;
/* 141 */     float r2 = 180.0F;
/* 142 */     float n4 = par4;
/* 143 */     float n5 = par5;
/*     */     
/* 145 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 146 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 147 */     float ex = par7Entity.field_70173_aa;
/* 148 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 149 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 151 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 152 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 201 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 202 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 203 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 204 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 206 */     this.LegR.field_78796_g = 0.0F;
/* 207 */     this.LegL.field_78796_g = 0.0F;
/* 208 */     this.ArmR.field_78796_g = 0.0F;
/* 209 */     this.ArmL.field_78796_g = 0.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbtournament\ModelJackieChun2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */