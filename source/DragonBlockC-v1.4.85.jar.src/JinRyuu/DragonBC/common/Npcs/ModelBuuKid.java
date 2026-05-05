/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelBuuKid
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer Head2;
/*     */   public ModelRenderer Head3;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Neck;
/*     */   public ModelRenderer Chest;
/*     */   public ModelRenderer Hip;
/*     */   public ModelRenderer FeetR;
/*     */   public ModelRenderer FeetL;
/*     */   
/*     */   public ModelBuuKid() {
/*  26 */     this.field_78090_t = 64;
/*  27 */     this.field_78089_u = 64;
/*  28 */     this.ArmR = new ModelRenderer(this, 30, 26);
/*  29 */     this.ArmR.func_78793_a(-3.8F, 4.8F, 0.4F);
/*  30 */     this.ArmR.func_78790_a(-2.8F, -2.0F, -2.0F, 4, 11, 4, -0.6F);
/*  31 */     this.FeetR = new ModelRenderer(this, 17, 48);
/*  32 */     this.FeetR.field_78809_i = true;
/*  33 */     this.FeetR.func_78793_a(0.4F, 0.0F, 0.0F);
/*  34 */     this.FeetR.func_78790_a(-1.5F, -0.2F, -1.5F, 3, 11, 3, 0.0F);
/*  35 */     this.FeetL = new ModelRenderer(this, 17, 48);
/*  36 */     this.FeetL.field_78809_i = true;
/*  37 */     this.FeetL.func_78793_a(-0.4F, 0.0F, 0.0F);
/*  38 */     this.FeetL.func_78790_a(-1.5F, -0.2F, -1.5F, 3, 11, 3, 0.0F);
/*  39 */     this.Chest = new ModelRenderer(this, 24, 21);
/*  40 */     this.Chest.func_78793_a(0.0F, 0.0F, 0.0F);
/*  41 */     this.Chest.func_78790_a(-3.0F, 0.4F, -1.7F, 6, 2, 1, 0.0F);
/*  42 */     setRotateAngle(this.Chest, -0.057595864F, 0.0F, 0.0F);
/*  43 */     this.Body2 = new ModelRenderer(this, 4, 32);
/*  44 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  45 */     this.Body2.func_78790_a(-2.5F, 1.5F, -1.6F, 5, 6, 3, 0.0F);
/*  46 */     this.LegL = new ModelRenderer(this, 0, 49);
/*  47 */     this.LegL.field_78809_i = true;
/*  48 */     this.LegL.func_78793_a(1.9F, 13.5F, 0.0F);
/*  49 */     this.LegL.func_78790_a(-2.4F, 0.8F, -2.0F, 4, 6, 4, -0.2F);
/*  50 */     this.Head2 = new ModelRenderer(this, 26, 1);
/*  51 */     this.Head2.func_78793_a(0.0F, -5.5F, -1.9F);
/*  52 */     this.Head2.func_78790_a(-1.0F, -4.0F, -1.1F, 2, 4, 2, 0.0F);
/*  53 */     setRotateAngle(this.Head2, -0.5462881F, 0.0F, 0.0F);
/*  54 */     this.Neck = new ModelRenderer(this, 7, 17);
/*  55 */     this.Neck.func_78793_a(0.0F, 0.0F, 0.0F);
/*  56 */     this.Neck.func_78790_a(-2.0F, -0.7F, -1.3F, 4, 2, 3, 0.0F);
/*  57 */     this.Body = new ModelRenderer(this, 3, 23);
/*  58 */     this.Body.func_78793_a(0.0F, 3.3F, 0.0F);
/*  59 */     this.Body.func_78790_a(-3.5F, 0.0F, -1.1F, 7, 5, 3, 0.0F);
/*  60 */     this.ArmL = new ModelRenderer(this, 30, 26);
/*  61 */     this.ArmL.field_78809_i = true;
/*  62 */     this.ArmL.func_78793_a(3.8F, 4.8F, 0.4F);
/*  63 */     this.ArmL.func_78790_a(-1.2F, -2.0F, -2.0F, 4, 11, 4, -0.6F);
/*  64 */     this.LegR = new ModelRenderer(this, 0, 49);
/*  65 */     this.LegR.func_78793_a(-1.9F, 13.5F, 0.0F);
/*  66 */     this.LegR.func_78790_a(-1.8F, 0.8F, -2.0F, 4, 6, 4, -0.2F);
/*  67 */     this.Head3 = new ModelRenderer(this, 36, 0);
/*  68 */     this.Head3.func_78793_a(0.0F, -3.8F, -0.2F);
/*  69 */     this.Head3.func_78790_a(-0.5F, -3.6F, -0.7F, 1, 4, 1, 0.0F);
/*  70 */     setRotateAngle(this.Head3, -0.7285004F, 0.0F, 0.0F);
/*  71 */     this.Head = new ModelRenderer(this, 0, 0);
/*  72 */     this.Head.func_78793_a(0.0F, 2.9F, 0.1F);
/*  73 */     this.Head.func_78790_a(-4.0F, -7.2F, -4.0F, 8, 8, 8, -0.7F);
/*  74 */     this.Hip = new ModelRenderer(this, 3, 42);
/*  75 */     this.Hip.func_78793_a(0.0F, 0.0F, 0.0F);
/*  76 */     this.Hip.func_78790_a(-3.0F, 7.0F, -1.5F, 6, 3, 3, 0.0F);
/*  77 */     this.LegR.func_78792_a(this.FeetR);
/*  78 */     this.LegL.func_78792_a(this.FeetL);
/*  79 */     this.Body.func_78792_a(this.Chest);
/*  80 */     this.Body.func_78792_a(this.Body2);
/*  81 */     this.Head.func_78792_a(this.Head2);
/*  82 */     this.Body.func_78792_a(this.Neck);
/*  83 */     this.Head2.func_78792_a(this.Head3);
/*  84 */     this.Body2.func_78792_a(this.Hip);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  89 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/*  92 */     this.LegL.func_78785_a(f5);
/*  93 */     this.Head.func_78785_a(f5);
/*  94 */     this.ArmL.func_78785_a(f5);
/*  95 */     this.ArmR.func_78785_a(f5);
/*  96 */     this.Body.func_78785_a(f5);
/*  97 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 102 */     modelRenderer.field_78795_f = x;
/* 103 */     modelRenderer.field_78796_g = y;
/* 104 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 108 */     int calc = par7Entity.field_70173_aa;
/* 109 */     if (calc > 100) calc -= 100; 
/* 110 */     float r = 360.0F;
/* 111 */     float r2 = 180.0F;
/* 112 */     float n4 = par4;
/* 113 */     float n5 = par5;
/*     */     
/* 115 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 116 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 117 */     float ex = par7Entity.field_70173_aa;
/* 118 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 119 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 121 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 122 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 152 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 153 */     this.LegL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 154 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 155 */     this.ArmL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 156 */     this.LegR.field_78796_g = 0.0F;
/* 157 */     this.LegL.field_78796_g = 0.0F;
/* 158 */     this.ArmR.field_78796_g = 0.0F;
/* 159 */     this.ArmL.field_78796_g = 0.0F;
/* 160 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelBuuKid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */