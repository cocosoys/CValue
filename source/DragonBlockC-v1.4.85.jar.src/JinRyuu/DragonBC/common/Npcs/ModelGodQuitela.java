/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import JinRyuu.JRMCore.client.JGRenderHelper;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class ModelGodQuitela
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer tail;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer EarL;
/*     */   public ModelRenderer EarR;
/*     */   public ModelRenderer Snout1;
/*     */   public ModelRenderer Snout2;
/*     */   public ModelRenderer Neck;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer Cloth1;
/*     */   public ModelRenderer tail_1;
/*     */   public ModelRenderer tail_2;
/*     */   public ModelRenderer tail_3;
/*     */   public ModelRenderer tail_4;
/*     */   public ModelRenderer LegR2;
/*     */   public ModelRenderer LegL2;
/*     */   
/*     */   public ModelGodQuitela() {
/*  35 */     this.field_78090_t = 64;
/*  36 */     this.field_78089_u = 64;
/*  37 */     this.tail = new ModelRenderer(this, 42, 1);
/*  38 */     this.tail.func_78793_a(0.0F, 10.3F, 1.5F);
/*  39 */     this.tail.func_78790_a(-0.5F, -0.3F, -0.5F, 1, 3, 1, 0.0F);
/*  40 */     setRotateAngle(this.tail, 1.0011208F, 0.0F, 0.0F);
/*  41 */     this.EarR = new ModelRenderer(this, 27, 0);
/*  42 */     this.EarR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  43 */     this.EarR.func_78790_a(-8.5F, -10.9F, 1.9F, 6, 6, 1, 0.0F);
/*  44 */     setRotateAngle(this.EarR, 0.10995574F, 0.0F, 0.0F);
/*  45 */     this.ArmR = new ModelRenderer(this, 50, 16);
/*  46 */     this.ArmR.func_78793_a(-5.0F, 2.0F, 0.0F);
/*  47 */     this.ArmR.func_78790_a(-2.0F, -2.0F, -1.8F, 3, 12, 4, 0.0F);
/*  48 */     this.EarL = new ModelRenderer(this, 27, 0);
/*  49 */     this.EarL.field_78809_i = true;
/*  50 */     this.EarL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  51 */     this.EarL.func_78790_a(2.5F, -10.9F, 1.9F, 6, 6, 1, 0.0F);
/*  52 */     setRotateAngle(this.EarL, 0.10995574F, 0.0F, 0.0F);
/*  53 */     this.ArmL = new ModelRenderer(this, 50, 16);
/*  54 */     this.ArmL.field_78809_i = true;
/*  55 */     this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
/*  56 */     this.ArmL.func_78790_a(-1.0F, -2.0F, -1.8F, 3, 12, 4, 0.0F);
/*  57 */     this.LegR = new ModelRenderer(this, 0, 33);
/*  58 */     this.LegR.func_78793_a(-1.9F, 12.0F, 0.0F);
/*  59 */     this.LegR.func_78790_a(-2.3F, 1.4F, -2.0F, 4, 6, 4, 0.3F);
/*  60 */     this.tail_2 = new ModelRenderer(this, 42, 1);
/*  61 */     this.tail_2.func_78793_a(0.0F, 2.6F, 0.0F);
/*  62 */     this.tail_2.func_78790_a(-0.5F, -0.1F, -0.5F, 1, 3, 1, 0.0F);
/*  63 */     setRotateAngle(this.tail_2, -0.18203785F, 0.0F, 0.0F);
/*  64 */     this.Neck = new ModelRenderer(this, 40, 6);
/*  65 */     this.Neck.func_78793_a(0.0F, 0.0F, 0.0F);
/*  66 */     this.Neck.func_78790_a(-2.0F, -1.3F, -1.5F, 4, 2, 3, 0.0F);
/*  67 */     this.Head = new ModelRenderer(this, 0, 0);
/*  68 */     this.Head.func_78793_a(0.0F, -0.6F, 0.0F);
/*  69 */     this.Head.func_78790_a(-4.5F, -8.0F, -4.0F, 9, 8, 8, 0.0F);
/*  70 */     this.tail_3 = new ModelRenderer(this, 42, 1);
/*  71 */     this.tail_3.func_78793_a(0.0F, 2.6F, 0.0F);
/*  72 */     this.tail_3.func_78790_a(-0.5F, -0.1F, -0.5F, 1, 3, 1, 0.0F);
/*  73 */     setRotateAngle(this.tail_3, 0.27314404F, 0.0F, 0.0F);
/*  74 */     this.LegL2 = new ModelRenderer(this, 0, 16);
/*  75 */     this.LegL2.field_78809_i = true;
/*  76 */     this.LegL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  77 */     this.LegL2.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  78 */     this.Cloth1 = new ModelRenderer(this, 54, 0);
/*  79 */     this.Cloth1.func_78793_a(0.0F, 10.0F, -1.6F);
/*  80 */     this.Cloth1.func_78790_a(-2.5F, 0.0F, -0.5F, 5, 10, 0, 0.0F);
/*  81 */     setRotateAngle(this.Cloth1, -0.090757124F, 0.0F, 0.0F);
/*  82 */     this.tail_4 = new ModelRenderer(this, 42, 1);
/*  83 */     this.tail_4.func_78793_a(0.0F, 2.6F, 0.0F);
/*  84 */     this.tail_4.func_78790_a(-0.5F, -0.1F, -0.5F, 1, 3, 1, 0.0F);
/*  85 */     setRotateAngle(this.tail_4, 0.27314404F, 0.0F, 0.0F);
/*  86 */     this.Snout1 = new ModelRenderer(this, 41, 14);
/*  87 */     this.Snout1.func_78793_a(0.0F, 0.0F, 0.3F);
/*  88 */     this.Snout1.func_78790_a(-1.5F, -3.4F, -5.4F, 3, 3, 2, 0.0F);
/*  89 */     this.Body1 = new ModelRenderer(this, 20, 18);
/*  90 */     this.Body1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  91 */     this.Body1.func_78790_a(-4.0F, 0.0F, -2.1F, 8, 8, 4, 0.0F);
/*  92 */     this.LegL = new ModelRenderer(this, 0, 33);
/*  93 */     this.LegL.field_78809_i = true;
/*  94 */     this.LegL.func_78793_a(1.9F, 12.0F, 0.0F);
/*  95 */     this.LegL.func_78790_a(-1.8F, 1.4F, -2.0F, 4, 6, 4, 0.3F);
/*  96 */     this.Snout2 = new ModelRenderer(this, 42, 11);
/*  97 */     this.Snout2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  98 */     this.Snout2.func_78790_a(-0.5F, 1.1F, -5.4F, 1, 2, 1, 0.0F);
/*  99 */     setRotateAngle(this.Snout2, -1.0927507F, 0.0F, 0.0F);
/* 100 */     this.Body3 = new ModelRenderer(this, 20, 37);
/* 101 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 102 */     this.Body3.func_78790_a(-4.0F, 8.0F, -2.0F, 8, 4, 4, 0.0F);
/* 103 */     this.tail_1 = new ModelRenderer(this, 42, 1);
/* 104 */     this.tail_1.func_78793_a(0.0F, 2.6F, 0.0F);
/* 105 */     this.tail_1.func_78790_a(-0.5F, -0.1F, -0.5F, 1, 3, 1, 0.0F);
/* 106 */     setRotateAngle(this.tail_1, -0.18203785F, 0.0F, 0.0F);
/* 107 */     this.LegR2 = new ModelRenderer(this, 0, 16);
/* 108 */     this.LegR2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 109 */     this.LegR2.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/* 110 */     this.Head.func_78792_a(this.EarR);
/* 111 */     this.Head.func_78792_a(this.EarL);
/* 112 */     this.tail_1.func_78792_a(this.tail_2);
/* 113 */     this.Body1.func_78792_a(this.Neck);
/* 114 */     this.tail_2.func_78792_a(this.tail_3);
/* 115 */     this.LegL.func_78792_a(this.LegL2);
/* 116 */     this.Body1.func_78792_a(this.Cloth1);
/* 117 */     this.tail_3.func_78792_a(this.tail_4);
/* 118 */     this.Head.func_78792_a(this.Snout1);
/* 119 */     this.Snout1.func_78792_a(this.Snout2);
/* 120 */     this.Body1.func_78792_a(this.Body3);
/* 121 */     this.tail.func_78792_a(this.tail_1);
/* 122 */     this.LegR.func_78792_a(this.LegR2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 127 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 129 */     GL11.glPushMatrix();
/* 130 */     float F = 0.65F;
/* 131 */     JGRenderHelper.modelScalePositionHelper(0.65F);
/*     */     
/* 133 */     this.LegL.func_78785_a(f5);
/* 134 */     this.Head.func_78785_a(f5);
/* 135 */     this.ArmL.func_78785_a(f5);
/* 136 */     this.ArmR.func_78785_a(f5);
/* 137 */     this.Body1.func_78785_a(f5);
/* 138 */     this.LegR.func_78785_a(f5);
/* 139 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 145 */     modelRenderer.field_78795_f = x;
/* 146 */     modelRenderer.field_78796_g = y;
/* 147 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 151 */     int calc = par7Entity.field_70173_aa;
/* 152 */     if (calc > 100) calc -= 100; 
/* 153 */     float r = 360.0F;
/* 154 */     float r2 = 180.0F;
/* 155 */     float n4 = par4;
/* 156 */     float n5 = par5;
/*     */     
/* 158 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 159 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 160 */     float ex = par7Entity.field_70173_aa;
/* 161 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 162 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 164 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 165 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 211 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 212 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 213 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 214 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 216 */     this.LegR.field_78796_g = 0.0F;
/* 217 */     this.LegL.field_78796_g = 0.0F;
/* 218 */     this.ArmR.field_78796_g = 0.0F;
/* 219 */     this.ArmL.field_78796_g = 0.0F;
/*     */ 
/*     */     
/* 222 */     this.Cloth1.field_78795_f = -0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/*     */ 
/*     */ 
/*     */     
/* 226 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelGodQuitela.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */