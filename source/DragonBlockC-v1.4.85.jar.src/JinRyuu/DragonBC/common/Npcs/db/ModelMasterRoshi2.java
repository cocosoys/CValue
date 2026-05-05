/*     */ package JinRyuu.DragonBC.common.Npcs.db;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelMasterRoshi2
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
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
/*     */   public ModelMasterRoshi2() {
/*  30 */     this.field_78090_t = 128;
/*  31 */     this.field_78089_u = 64;
/*  32 */     this.Body2 = new ModelRenderer(this, 0, 31);
/*  33 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  34 */     this.Body2.func_78790_a(-4.5F, 5.0F, -2.0F, 9, 5, 4, 0.0F);
/*  35 */     this.ArmR2 = new ModelRenderer(this, 62, 27);
/*  36 */     this.ArmR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  37 */     this.ArmR2.func_78790_a(-4.1F, 1.5F, -2.7F, 5, 5, 5, 0.0F);
/*  38 */     this.LegR = new ModelRenderer(this, 33, 32);
/*  39 */     this.LegR.func_78793_a(-2.5F, 10.0F, 0.0F);
/*  40 */     this.LegR.func_78790_a(-2.5F, 0.0F, -2.5F, 5, 12, 5, 0.0F);
/*  41 */     this.Chest = new ModelRenderer(this, 34, 16);
/*  42 */     this.Chest.func_78793_a(0.0F, 0.0F, 0.0F);
/*  43 */     this.Chest.func_78790_a(-5.0F, 1.0F, -2.5F, 10, 4, 1, 0.0F);
/*  44 */     this.Body3 = new ModelRenderer(this, 0, 42);
/*  45 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  46 */     this.Body3.func_78790_a(-5.0F, 9.5F, -2.4F, 10, 4, 5, 0.0F);
/*  47 */     this.FeetL = new ModelRenderer(this, 34, 50);
/*  48 */     this.FeetL.field_78809_i = true;
/*  49 */     this.FeetL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  50 */     this.FeetL.func_78790_a(-2.0F, 12.0F, -3.3F, 4, 2, 5, 0.0F);
/*  51 */     this.ArmL = new ModelRenderer(this, 62, 17);
/*  52 */     this.ArmL.field_78809_i = true;
/*  53 */     this.ArmL.func_78793_a(6.7F, -2.2F, 0.5F);
/*  54 */     this.ArmL.func_78790_a(-1.5F, -2.0F, -2.5F, 6, 4, 5, 0.0F);
/*  55 */     this.ArmL2 = new ModelRenderer(this, 62, 27);
/*  56 */     this.ArmL2.field_78809_i = true;
/*  57 */     this.ArmL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  58 */     this.ArmL2.func_78790_a(-0.9F, 1.5F, -2.7F, 5, 5, 5, 0.0F);
/*  59 */     this.ArmR = new ModelRenderer(this, 62, 17);
/*  60 */     this.ArmR.func_78793_a(-6.7F, -2.2F, 0.5F);
/*  61 */     this.ArmR.func_78790_a(-4.5F, -2.0F, -2.5F, 6, 4, 5, 0.0F);
/*  62 */     this.Body = new ModelRenderer(this, 0, 17);
/*  63 */     this.Body.func_78793_a(0.0F, -3.5F, 0.0F);
/*  64 */     this.Body.func_78790_a(-6.0F, 0.0F, -1.9F, 12, 7, 5, 0.0F);
/*  65 */     this.FeetR = new ModelRenderer(this, 34, 50);
/*  66 */     this.FeetR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  67 */     this.FeetR.func_78790_a(-2.0F, 12.0F, -3.3F, 4, 2, 5, 0.0F);
/*  68 */     this.Head = new ModelRenderer(this, 0, 0);
/*  69 */     this.Head.func_78793_a(0.0F, -2.7F, 0.0F);
/*  70 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, -0.7F);
/*  71 */     this.ArmR3 = new ModelRenderer(this, 61, 39);
/*  72 */     this.ArmR3.func_78793_a(-1.4F, 6.4F, -0.8F);
/*  73 */     this.ArmR3.func_78790_a(-2.5F, 0.0F, -1.9F, 5, 6, 5, 0.0F);
/*  74 */     setRotateAngle(this.ArmR3, -0.22759093F, 0.0F, 0.0F);
/*  75 */     this.LegL = new ModelRenderer(this, 33, 32);
/*  76 */     this.LegL.field_78809_i = true;
/*  77 */     this.LegL.func_78793_a(2.5F, 10.0F, 0.0F);
/*  78 */     this.LegL.func_78790_a(-2.5F, 0.0F, -2.5F, 5, 12, 5, 0.0F);
/*  79 */     this.Beard = new ModelRenderer(this, 27, 2);
/*  80 */     this.Beard.func_78793_a(0.0F, -2.0F, -3.4F);
/*  81 */     this.Beard.func_78790_a(-3.0F, -1.1F, 0.0F, 6, 4, 0, 0.0F);
/*  82 */     this.ArmL3 = new ModelRenderer(this, 61, 39);
/*  83 */     this.ArmL3.field_78809_i = true;
/*  84 */     this.ArmL3.func_78793_a(1.4F, 6.4F, -0.8F);
/*  85 */     this.ArmL3.func_78790_a(-2.5F, 0.0F, -1.9F, 5, 6, 5, 0.0F);
/*  86 */     setRotateAngle(this.ArmL3, -0.18203785F, 0.0F, 0.0F);
/*  87 */     this.Beard2 = new ModelRenderer(this, 33, 9);
/*  88 */     this.Beard2.func_78793_a(0.0F, 0.7F, 0.15F);
/*  89 */     this.Beard2.func_78790_a(-2.0F, -0.6F, -0.1F, 4, 4, 0, 0.0F);
/*  90 */     this.Body.func_78792_a(this.Body2);
/*  91 */     this.ArmR.func_78792_a(this.ArmR2);
/*  92 */     this.Body.func_78792_a(this.Chest);
/*  93 */     this.Body2.func_78792_a(this.Body3);
/*  94 */     this.LegL.func_78792_a(this.FeetL);
/*  95 */     this.ArmL.func_78792_a(this.ArmL2);
/*  96 */     this.LegR.func_78792_a(this.FeetR);
/*  97 */     this.ArmR2.func_78792_a(this.ArmR3);
/*  98 */     this.Head.func_78792_a(this.Beard);
/*  99 */     this.ArmL2.func_78792_a(this.ArmL3);
/* 100 */     this.Beard.func_78792_a(this.Beard2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 105 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 107 */     this.Head.func_78785_a(f5);
/*     */     
/* 109 */     this.Body.func_78785_a(f5);
/* 110 */     this.ArmR.func_78785_a(f5);
/* 111 */     this.ArmL.func_78785_a(f5);
/* 112 */     this.LegL.func_78785_a(f5);
/* 113 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 123 */     modelRenderer.field_78795_f = x;
/* 124 */     modelRenderer.field_78796_g = y;
/* 125 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 129 */     int calc = par7Entity.field_70173_aa;
/* 130 */     if (calc > 100) calc -= 100; 
/* 131 */     float r = 360.0F;
/* 132 */     float r2 = 180.0F;
/* 133 */     float n4 = par4;
/* 134 */     float n5 = par5;
/*     */     
/* 136 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 137 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 138 */     float ex = par7Entity.field_70173_aa;
/* 139 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 140 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 142 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 143 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 192 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 193 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 194 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 195 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 197 */     this.LegR.field_78796_g = 0.0F;
/* 198 */     this.LegL.field_78796_g = 0.0F;
/* 199 */     this.ArmR.field_78796_g = 0.0F;
/* 200 */     this.ArmL.field_78796_g = 0.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\db\ModelMasterRoshi2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */