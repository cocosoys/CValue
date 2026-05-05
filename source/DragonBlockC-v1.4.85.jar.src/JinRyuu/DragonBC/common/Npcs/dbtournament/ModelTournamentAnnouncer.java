/*     */ package JinRyuu.DragonBC.common.Npcs.dbtournament;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelTournamentAnnouncer
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer Arm;
/*     */   public ModelRenderer Hair1;
/*     */   public ModelRenderer Hair2;
/*     */   public ModelRenderer Glasses;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer ArmR2;
/*     */   public ModelRenderer ArmR3;
/*     */   public ModelRenderer Mic1;
/*     */   public ModelRenderer Mic2;
/*     */   
/*     */   public ModelTournamentAnnouncer() {
/*  27 */     this.field_78090_t = 64;
/*  28 */     this.field_78089_u = 64;
/*  29 */     this.Head = new ModelRenderer(this, 0, 0);
/*  30 */     this.Head.func_78793_a(0.0F, 0.4F, 0.0F);
/*  31 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, -0.3F);
/*  32 */     this.Body = new ModelRenderer(this, 0, 17);
/*  33 */     this.Body.func_78793_a(0.0F, 0.0F, 0.0F);
/*  34 */     this.Body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
/*  35 */     this.LegR = new ModelRenderer(this, 0, 34);
/*  36 */     this.LegR.func_78793_a(-1.9F, 12.0F, 0.0F);
/*  37 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  38 */     this.Hair2 = new ModelRenderer(this, 43, 43);
/*  39 */     this.Hair2.func_78793_a(0.0F, -6.0F, 0.0F);
/*  40 */     this.Hair2.func_78790_a(-2.0F, -2.5F, -4.2F, 4, 3, 6, 0.0F);
/*  41 */     this.Glasses = new ModelRenderer(this, 32, 0);
/*  42 */     this.Glasses.func_78793_a(0.0F, 0.3F, 0.0F);
/*  43 */     this.Glasses.func_78790_a(-4.0F, -6.2F, -3.9F, 8, 3, 8, 0.0F);
/*  44 */     this.Arm = new ModelRenderer(this, 0, 0);
/*  45 */     this.Arm.func_78793_a(-5.0F, 2.0F, 0.0F);
/*  46 */     this.Arm.func_78790_a(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
/*  47 */     this.LegL = new ModelRenderer(this, 0, 34);
/*  48 */     this.LegL.field_78809_i = true;
/*  49 */     this.LegL.func_78793_a(1.9F, 12.0F, 0.0F);
/*  50 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  51 */     this.ArmR2 = new ModelRenderer(this, 18, 53);
/*  52 */     this.ArmR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  53 */     this.ArmR2.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 6, 4, 0.0F);
/*  54 */     setRotateAngle(this.ArmR2, -0.5462881F, -0.5009095F, 0.0F);
/*  55 */     this.Mic1 = new ModelRenderer(this, 49, 14);
/*  56 */     this.Mic1.func_78793_a(0.7F, 5.1F, -0.2F);
/*  57 */     this.Mic1.func_78790_a(-0.5F, -2.2F, -0.5F, 1, 5, 1, 0.0F);
/*  58 */     setRotateAngle(this.Mic1, 1.5025539F, 0.0F, 0.0F);
/*  59 */     this.Body2 = new ModelRenderer(this, 27, 18);
/*  60 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  61 */     this.Body2.func_78790_a(-3.5F, 0.1F, -1.8F, 7, 7, 3, 0.0F);
/*  62 */     this.Hair1 = new ModelRenderer(this, 40, 56);
/*  63 */     this.Hair1.func_78793_a(0.0F, -5.3F, 3.1F);
/*  64 */     this.Hair1.func_78790_a(-4.0F, -2.7F, -3.0F, 8, 4, 4, 0.0F);
/*  65 */     this.ArmR3 = new ModelRenderer(this, 0, 53);
/*  66 */     this.ArmR3.func_78793_a(-1.0F, 4.0F, 0.0F);
/*  67 */     this.ArmR3.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
/*  68 */     setRotateAngle(this.ArmR3, -1.0927507F, -0.22759093F, 0.0F);
/*  69 */     this.Mic2 = new ModelRenderer(this, 54, 13);
/*  70 */     this.Mic2.func_78793_a(0.0F, -2.6F, 0.0F);
/*  71 */     this.Mic2.func_78790_a(-1.0F, -1.5F, -1.0F, 2, 2, 2, 0.0F);
/*  72 */     this.ArmL = new ModelRenderer(this, 18, 34);
/*  73 */     this.ArmL.field_78809_i = true;
/*  74 */     this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
/*  75 */     this.ArmL.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
/*  76 */     this.Head.func_78792_a(this.Hair2);
/*  77 */     this.Head.func_78792_a(this.Glasses);
/*  78 */     this.Arm.func_78792_a(this.ArmR2);
/*  79 */     this.ArmR3.func_78792_a(this.Mic1);
/*  80 */     this.Body.func_78792_a(this.Body2);
/*  81 */     this.Head.func_78792_a(this.Hair1);
/*  82 */     this.ArmR2.func_78792_a(this.ArmR3);
/*  83 */     this.Mic1.func_78792_a(this.Mic2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  88 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/*  90 */     this.Head.func_78785_a(f5);
/*     */     
/*  92 */     this.Body.func_78785_a(f5);
/*  93 */     this.Arm.func_78785_a(f5);
/*  94 */     this.ArmL.func_78785_a(f5);
/*  95 */     this.LegL.func_78785_a(f5);
/*  96 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 105 */     modelRenderer.field_78795_f = x;
/* 106 */     modelRenderer.field_78796_g = y;
/* 107 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 111 */     int calc = par7Entity.field_70173_aa;
/* 112 */     if (calc > 100) calc -= 100; 
/* 113 */     float r = 360.0F;
/* 114 */     float r2 = 180.0F;
/* 115 */     float n4 = par4;
/* 116 */     float n5 = par5;
/*     */     
/* 118 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 119 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 120 */     float ex = par7Entity.field_70173_aa;
/* 121 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 122 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 124 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 125 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 174 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 175 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 177 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 179 */     this.LegR.field_78796_g = 0.0F;
/* 180 */     this.LegL.field_78796_g = 0.0F;
/*     */     
/* 182 */     this.ArmL.field_78796_g = 0.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbtournament\ModelTournamentAnnouncer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */