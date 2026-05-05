/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelShisami
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Chest;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer rhorn;
/*     */   public ModelRenderer lhorn;
/*     */   public ModelRenderer earL;
/*     */   public ModelRenderer earR;
/*     */   public ModelRenderer rhorn2;
/*     */   public ModelRenderer rhorn3;
/*     */   public ModelRenderer rhorn4;
/*     */   public ModelRenderer lhorn2;
/*     */   public ModelRenderer lhorn3;
/*     */   public ModelRenderer lhorn4;
/*     */   public ModelRenderer Belly;
/*     */   public ModelRenderer Neck;
/*     */   public ModelRenderer ShoulderR;
/*     */   public ModelRenderer ShoulderL;
/*     */   
/*     */   public ModelShisami() {
/*  32 */     this.field_78090_t = 64;
/*  33 */     this.field_78089_u = 64;
/*  34 */     this.earL = new ModelRenderer(this, 33, 8);
/*  35 */     this.earL.field_78809_i = true;
/*  36 */     this.earL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  37 */     this.earL.func_78790_a(2.7F, -5.8F, -3.2F, 4, 3, 0, 0.0F);
/*  38 */     setRotateAngle(this.earL, 0.0F, -0.4098033F, 0.0F);
/*  39 */     this.lhorn4 = new ModelRenderer(this, 58, 1);
/*  40 */     this.lhorn4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  41 */     this.lhorn4.func_78790_a(7.9F, -11.9F, -3.4F, 1, 1, 2, 0.0F);
/*  42 */     this.ShoulderR = new ModelRenderer(this, 42, 15);
/*  43 */     this.ShoulderR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  44 */     this.ShoulderR.func_78790_a(-5.0F, -1.7F, -2.4F, 6, 3, 5, 0.0F);
/*  45 */     this.ShoulderL = new ModelRenderer(this, 42, 15);
/*  46 */     this.ShoulderL.field_78809_i = true;
/*  47 */     this.ShoulderL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  48 */     this.ShoulderL.func_78790_a(-1.1F, -1.7F, -2.4F, 6, 3, 5, 0.0F);
/*  49 */     this.ArmL = new ModelRenderer(this, 46, 24);
/*  50 */     this.ArmL.field_78809_i = true;
/*  51 */     this.ArmL.func_78793_a(6.8F, -3.4F, 0.8F);
/*  52 */     this.ArmL.func_78790_a(-1.0F, -1.6F, -2.0F, 5, 14, 4, 0.0F);
/*  53 */     this.lhorn3 = new ModelRenderer(this, 51, 3);
/*  54 */     this.lhorn3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  55 */     this.lhorn3.func_78790_a(6.7F, -11.4F, -2.8F, 2, 2, 2, 0.0F);
/*  56 */     this.LegR = new ModelRenderer(this, 0, 43);
/*  57 */     this.LegR.func_78793_a(-3.0F, 8.8F, 0.0F);
/*  58 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 5, 15, 5, 0.0F);
/*  59 */     this.lhorn2 = new ModelRenderer(this, 40, 1);
/*  60 */     this.lhorn2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  61 */     this.lhorn2.func_78790_a(6.2F, -9.9F, -2.3F, 2, 3, 3, 0.0F);
/*  62 */     this.Belly = new ModelRenderer(this, 21, 42);
/*  63 */     this.Belly.func_78793_a(0.0F, 0.0F, 0.0F);
/*  64 */     this.Belly.func_78790_a(-5.0F, 4.8F, -2.0F, 10, 9, 5, 0.0F);
/*  65 */     this.Head = new ModelRenderer(this, 0, 0);
/*  66 */     this.Head.func_78793_a(0.0F, -5.2F, 0.0F);
/*  67 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
/*  68 */     this.lhorn = new ModelRenderer(this, 25, 1);
/*  69 */     this.lhorn.func_78793_a(0.0F, 0.0F, 0.0F);
/*  70 */     this.lhorn.func_78790_a(3.5F, -8.7F, -2.0F, 4, 3, 3, 0.0F);
/*  71 */     this.Neck = new ModelRenderer(this, 22, 20);
/*  72 */     this.Neck.func_78793_a(0.0F, 0.0F, 0.0F);
/*  73 */     this.Neck.func_78790_a(-3.0F, -0.5F, -1.2F, 6, 1, 4, 0.0F);
/*  74 */     this.rhorn4 = new ModelRenderer(this, 58, 1);
/*  75 */     this.rhorn4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  76 */     this.rhorn4.func_78790_a(-8.7F, -11.9F, -3.4F, 1, 1, 2, 0.0F);
/*  77 */     this.Chest = new ModelRenderer(this, 9, 29);
/*  78 */     this.Chest.func_78793_a(0.0F, -5.0F, 0.0F);
/*  79 */     this.Chest.func_78790_a(-6.0F, 0.0F, -2.3F, 12, 5, 6, 0.0F);
/*  80 */     this.ArmR = new ModelRenderer(this, 46, 24);
/*  81 */     this.ArmR.func_78793_a(-6.9F, -3.4F, 0.8F);
/*  82 */     this.ArmR.func_78790_a(-4.1F, -1.6F, -2.0F, 5, 14, 4, 0.0F);
/*  83 */     this.rhorn2 = new ModelRenderer(this, 40, 1);
/*  84 */     this.rhorn2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  85 */     this.rhorn2.func_78790_a(-8.2F, -9.9F, -2.3F, 2, 3, 3, 0.0F);
/*  86 */     this.rhorn3 = new ModelRenderer(this, 51, 3);
/*  87 */     this.rhorn3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  88 */     this.rhorn3.func_78790_a(-8.6F, -11.4F, -2.8F, 2, 2, 2, 0.0F);
/*  89 */     this.LegL = new ModelRenderer(this, 0, 43);
/*  90 */     this.LegL.field_78809_i = true;
/*  91 */     this.LegL.func_78793_a(2.0F, 8.8F, 0.0F);
/*  92 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 5, 15, 5, 0.0F);
/*  93 */     this.rhorn = new ModelRenderer(this, 25, 1);
/*  94 */     this.rhorn.func_78793_a(0.0F, 0.0F, 0.0F);
/*  95 */     this.rhorn.func_78790_a(-7.5F, -8.7F, -2.0F, 4, 3, 3, 0.0F);
/*  96 */     this.earR = new ModelRenderer(this, 33, 8);
/*  97 */     this.earR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  98 */     this.earR.func_78790_a(-6.5F, -5.8F, -3.2F, 4, 3, 0, 0.0F);
/*  99 */     setRotateAngle(this.earR, 0.0F, 0.4098033F, 0.0F);
/* 100 */     this.Head.func_78792_a(this.earL);
/* 101 */     this.lhorn3.func_78792_a(this.lhorn4);
/* 102 */     this.ArmR.func_78792_a(this.ShoulderR);
/* 103 */     this.ArmL.func_78792_a(this.ShoulderL);
/* 104 */     this.lhorn2.func_78792_a(this.lhorn3);
/* 105 */     this.lhorn.func_78792_a(this.lhorn2);
/* 106 */     this.Chest.func_78792_a(this.Belly);
/* 107 */     this.Head.func_78792_a(this.lhorn);
/* 108 */     this.Chest.func_78792_a(this.Neck);
/* 109 */     this.rhorn3.func_78792_a(this.rhorn4);
/* 110 */     this.rhorn.func_78792_a(this.rhorn2);
/* 111 */     this.rhorn2.func_78792_a(this.rhorn3);
/* 112 */     this.Head.func_78792_a(this.rhorn);
/* 113 */     this.Head.func_78792_a(this.earR);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 118 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 121 */     this.LegL.func_78785_a(f5);
/* 122 */     this.Head.func_78785_a(f5);
/* 123 */     this.ArmL.func_78785_a(f5);
/* 124 */     this.ArmR.func_78785_a(f5);
/* 125 */     this.Chest.func_78785_a(f5);
/* 126 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 131 */     modelRenderer.field_78795_f = x;
/* 132 */     modelRenderer.field_78796_g = y;
/* 133 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 137 */     int calc = par7Entity.field_70173_aa;
/* 138 */     if (calc > 100) calc -= 100; 
/* 139 */     float r = 360.0F;
/* 140 */     float r2 = 180.0F;
/* 141 */     float n4 = par4;
/* 142 */     float n5 = par5;
/*     */     
/* 144 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 145 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 146 */     float ex = par7Entity.field_70173_aa;
/* 147 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 148 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 157 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 158 */     this.LegL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 159 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 160 */     this.ArmL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 161 */     this.LegR.field_78796_g = 0.0F;
/* 162 */     this.LegL.field_78796_g = 0.0F;
/* 163 */     this.ArmR.field_78796_g = 0.0F;
/* 164 */     this.ArmL.field_78796_g = 0.0F;
/* 165 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelShisami.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */