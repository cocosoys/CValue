/*     */ package JinRyuu.DragonBC.common.Render;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class KintounModel
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Base;
/*     */   public ModelRenderer FrontL;
/*     */   public ModelRenderer FrontR;
/*     */   public ModelRenderer SideL1;
/*     */   public ModelRenderer SideR;
/*     */   public ModelRenderer BackR1;
/*     */   public ModelRenderer BackL1;
/*     */   public ModelRenderer Bottom;
/*     */   public ModelRenderer SideL2;
/*     */   public ModelRenderer BackR2;
/*     */   public ModelRenderer Tail1;
/*     */   public ModelRenderer Tail2;
/*     */   
/*     */   public KintounModel() {
/*  29 */     this.field_78090_t = 128;
/*  30 */     this.field_78089_u = 64;
/*  31 */     this.SideL2 = new ModelRenderer(this, 48, 11);
/*  32 */     this.SideL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  33 */     this.SideL2.func_78790_a(4.4F, -2.1F, -10.1F, 5, 4, 6, 0.0F);
/*  34 */     this.Base = new ModelRenderer(this, 0, 0);
/*  35 */     this.Base.func_78793_a(0.0F, -9.7F, 0.0F);
/*  36 */     this.Base.func_78790_a(-5.0F, -5.1F, -5.2F, 10, 10, 11, 0.0F);
/*  37 */     this.Tail1 = new ModelRenderer(this, 20, 48);
/*  38 */     this.Tail1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  39 */     this.Tail1.func_78790_a(-1.5F, -3.4F, 12.7F, 5, 4, 6, 0.0F);
/*  40 */     this.Bottom = new ModelRenderer(this, 43, 0);
/*  41 */     this.Bottom.func_78793_a(0.0F, 0.0F, 0.0F);
/*  42 */     this.Bottom.func_78790_a(-2.8F, 4.0F, -3.8F, 6, 2, 9, 0.0F);
/*  43 */     this.BackR1 = new ModelRenderer(this, 60, 41);
/*  44 */     this.BackR1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  45 */     this.BackR1.func_78790_a(-7.3F, -5.5F, 2.9F, 7, 8, 10, 0.0F);
/*  46 */     this.Tail2 = new ModelRenderer(this, 0, 50);
/*  47 */     this.Tail2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  48 */     this.Tail2.func_78790_a(-3.9F, -2.4F, 12.4F, 5, 4, 9, 0.0F);
/*  49 */     this.BackL1 = new ModelRenderer(this, 94, 41);
/*  50 */     this.BackL1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  51 */     this.BackL1.func_78790_a(-0.5F, -3.7F, 4.8F, 7, 8, 10, 0.0F);
/*  52 */     this.SideL1 = new ModelRenderer(this, 60, 11);
/*  53 */     this.SideL1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  54 */     this.SideL1.func_78790_a(3.1F, -4.2F, -4.9F, 7, 8, 10, 0.0F);
/*  55 */     this.FrontL = new ModelRenderer(this, 0, 22);
/*  56 */     this.FrontL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  57 */     this.FrontL.func_78790_a(-0.4F, -5.5F, -12.7F, 7, 8, 10, 0.0F);
/*  58 */     this.FrontR = new ModelRenderer(this, 35, 22);
/*  59 */     this.FrontR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  60 */     this.FrontR.func_78790_a(-6.4F, -4.1F, -11.3F, 7, 8, 10, 0.0F);
/*  61 */     this.SideR = new ModelRenderer(this, 94, 11);
/*  62 */     this.SideR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  63 */     this.SideR.func_78790_a(-9.5F, -4.8F, -6.4F, 7, 8, 10, 0.0F);
/*  64 */     this.BackR2 = new ModelRenderer(this, 48, 41);
/*  65 */     this.BackR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  66 */     this.BackR2.func_78790_a(-4.6F, 1.2F, 4.1F, 5, 4, 6, 0.0F);
/*  67 */     this.SideL1.func_78792_a(this.SideL2);
/*  68 */     this.BackL1.func_78792_a(this.Tail1);
/*  69 */     this.Base.func_78792_a(this.Bottom);
/*  70 */     this.Base.func_78792_a(this.BackR1);
/*  71 */     this.Tail1.func_78792_a(this.Tail2);
/*  72 */     this.Base.func_78792_a(this.BackL1);
/*  73 */     this.Base.func_78792_a(this.SideL1);
/*  74 */     this.Base.func_78792_a(this.FrontL);
/*  75 */     this.Base.func_78792_a(this.FrontR);
/*  76 */     this.Base.func_78792_a(this.SideR);
/*  77 */     this.BackR1.func_78792_a(this.BackR2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  82 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*  83 */     GL11.glPushMatrix();
/*     */     
/*  85 */     GL11.glRotatef(90.0F, 0.0F, -1.0F, 0.0F);
/*  86 */     GL11.glTranslatef(0.2F, 0.5F, 0.0F);
/*     */     
/*  88 */     float ex = entity.field_70173_aa;
/*  89 */     float cosi = MathHelper.func_76134_b(ex * 0.2F) * 0.02F;
/*  90 */     float cosi2 = MathHelper.func_76134_b(ex * 0.2F) * 0.01F * -1.0F;
/*  91 */     GL11.glTranslatef(cosi, cosi, 0.0F);
/*     */     
/*  93 */     this.Base.func_78785_a(f5);
/*  94 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 101 */     modelRenderer.field_78795_f = x;
/* 102 */     modelRenderer.field_78796_g = y;
/* 103 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   public void renderModel(float f5) {
/* 106 */     func_78088_a((Entity)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, f5);
/*     */   }
/*     */   public void func_78087_a(float f, float f1, float f2, float f3, float f4, float f5, Entity par7Entity) {
/* 109 */     float ex = par7Entity.field_70173_aa;
/* 110 */     float cosi = MathHelper.func_76134_b(ex * 0.5F) * 0.2F;
/* 111 */     float cosi2 = MathHelper.func_76134_b(ex * 0.5F) * 0.1F;
/*     */     
/* 113 */     this.FrontL.field_78795_f = -cosi * f2 * -1.0F;
/* 114 */     this.FrontL.field_78796_g = -cosi * f2 * -1.0F;
/*     */     
/* 116 */     this.FrontR.field_78795_f = -cosi2 * f2;
/* 117 */     this.FrontR.field_78796_g = -cosi2 * f2;
/*     */     
/* 119 */     this.SideL1.field_78795_f = -cosi * f2 * -1.0F;
/* 120 */     this.SideL1.field_78796_g = -cosi * f2 * -1.0F;
/*     */     
/* 122 */     this.SideR.field_78795_f = -cosi2 * f2;
/* 123 */     this.SideR.field_78796_g = -cosi2 * f2;
/*     */     
/* 125 */     this.BackR1.field_78795_f = -cosi * f2 * -1.0F;
/* 126 */     this.BackR1.field_78796_g = -cosi * f2 * -1.0F;
/*     */     
/* 128 */     this.BackL1.field_78795_f = -cosi2 * f2;
/* 129 */     this.BackL1.field_78796_g = -cosi2 * f2;
/*     */     
/* 131 */     this.Bottom.field_78795_f = -cosi * f2 * -1.0F;
/* 132 */     this.Bottom.field_78796_g = -cosi * f2 * -1.0F;
/*     */     
/* 134 */     this.SideL2.field_78795_f = -cosi2 * f2;
/* 135 */     this.SideL2.field_78796_g = -cosi2 * f2;
/*     */     
/* 137 */     this.BackR2.field_78795_f = -cosi * f2 * -1.0F;
/* 138 */     this.BackR2.field_78796_g = -cosi * f2 * -1.0F;
/*     */     
/* 140 */     this.Tail1.field_78795_f = -cosi2 * f2;
/* 141 */     this.Tail1.field_78796_g = -cosi2 * f2;
/*     */     
/* 143 */     this.Tail2.field_78795_f = -cosi * f2 * -1.0F;
/* 144 */     this.Tail2.field_78796_g = -cosi * f2 * -1.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Render\KintounModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */