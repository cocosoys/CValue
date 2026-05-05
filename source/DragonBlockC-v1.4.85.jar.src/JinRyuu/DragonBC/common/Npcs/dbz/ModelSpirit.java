/*     */ package JinRyuu.DragonBC.common.Npcs.dbz;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModelSpirit
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer Body4;
/*     */   public ModelRenderer Body5;
/*     */   public ModelRenderer Body6;
/*     */   public ModelRenderer Body7;
/*     */   public ModelRenderer Body8;
/*     */   public ModelRenderer BodyR;
/*     */   public ModelRenderer BodyL;
/*     */   public ModelRenderer BodyTop;
/*     */   public ModelRenderer BodyBot;
/*     */   public ModelRenderer BodyFront;
/*     */   public ModelRenderer Bodytail1;
/*     */   public ModelRenderer Bodytail2;
/*     */   public ModelRenderer Bodytail3;
/*     */   public ModelRenderer Bodytail4;
/*     */   
/*     */   public ModelSpirit() {
/*  33 */     this.field_78090_t = 64;
/*  34 */     this.field_78089_u = 64;
/*  35 */     this.Body8 = new ModelRenderer(this, 1, 23);
/*  36 */     this.Body8.func_78793_a(-1.5F, 3.1F, 2.5F);
/*  37 */     this.Body8.func_78790_a(-2.5F, -2.0F, -2.7F, 4, 4, 5, 0.0F);
/*  38 */     this.Body1 = new ModelRenderer(this, 0, 10);
/*  39 */     this.Body1.func_78793_a(-1.8F, -1.6F, -2.2F);
/*  40 */     this.Body1.func_78790_a(-3.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
/*  41 */     this.BodyR = new ModelRenderer(this, 1, 23);
/*  42 */     this.BodyR.func_78793_a(-3.2F, 1.8F, 0.4F);
/*  43 */     this.BodyR.func_78790_a(-2.5F, -2.0F, -2.7F, 4, 4, 5, 0.0F);
/*  44 */     this.BodyBot = new ModelRenderer(this, 1, 47);
/*  45 */     this.BodyBot.func_78793_a(-1.1F, 5.7F, 0.4F);
/*  46 */     this.BodyBot.func_78790_a(-2.5F, -1.5F, -2.7F, 5, 3, 5, 0.0F);
/*  47 */     this.Body5 = new ModelRenderer(this, 21, 33);
/*  48 */     this.Body5.func_78793_a(1.2F, 3.1F, -1.6F);
/*  49 */     this.Body5.func_78790_a(-3.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
/*  50 */     this.Body6 = new ModelRenderer(this, 0, 33);
/*  51 */     this.Body6.func_78793_a(-2.0F, 2.8F, -2.3F);
/*  52 */     this.Body6.func_78790_a(-2.5F, -2.5F, -2.5F, 5, 5, 5, 0.0F);
/*  53 */     this.Bodytail2 = new ModelRenderer(this, 45, 54);
/*  54 */     this.Bodytail2.func_78793_a(-1.0F, -0.1F, 0.7F);
/*  55 */     this.Bodytail2.func_78790_a(-2.5F, -2.0F, -2.7F, 4, 4, 5, 0.0F);
/*  56 */     this.BodyTop = new ModelRenderer(this, 1, 1);
/*  57 */     this.BodyTop.func_78793_a(0.9F, -4.2F, 0.1F);
/*  58 */     this.BodyTop.func_78790_a(-2.5F, -1.5F, -2.7F, 5, 3, 5, 0.0F);
/*  59 */     setRotateAngle(this.BodyTop, 0.0F, 0.0F, -0.011152261F);
/*  60 */     this.BodyFront = new ModelRenderer(this, 21, 24);
/*  61 */     this.BodyFront.func_78793_a(1.4F, 0.4F, -4.9F);
/*  62 */     this.BodyFront.func_78790_a(-2.5F, -2.5F, -1.5F, 4, 5, 3, 0.0F);
/*  63 */     this.Bodytail3 = new ModelRenderer(this, 49, 46);
/*  64 */     this.Bodytail3.func_78793_a(0.0F, 0.9F, 2.7F);
/*  65 */     this.Bodytail3.func_78790_a(-1.5F, -1.5F, -1.9F, 3, 3, 4, 0.0F);
/*  66 */     this.Bodytail4 = new ModelRenderer(this, 53, 39);
/*  67 */     this.Bodytail4.func_78793_a(0.0F, 1.1F, 1.9F);
/*  68 */     this.Bodytail4.func_78790_a(-0.6F, -1.5F, -1.9F, 1, 2, 4, 0.0F);
/*  69 */     this.Body3 = new ModelRenderer(this, 1, 11);
/*  70 */     this.Body3.func_78793_a(1.0F, -1.5F, 2.1F);
/*  71 */     this.Body3.func_78790_a(-3.0F, -3.0F, -2.5F, 6, 6, 5, 0.0F);
/*  72 */     this.Body7 = new ModelRenderer(this, 1, 33);
/*  73 */     this.Body7.func_78793_a(1.5F, 2.9F, 2.7F);
/*  74 */     this.Body7.func_78790_a(-2.0F, -2.5F, -2.7F, 4, 5, 5, 0.0F);
/*  75 */     this.BodyL = new ModelRenderer(this, 36, 22);
/*  76 */     this.BodyL.func_78793_a(3.6F, 0.7F, 0.1F);
/*  77 */     this.BodyL.func_78790_a(-2.0F, -2.5F, -2.7F, 4, 5, 5, 0.0F);
/*  78 */     this.Body4 = new ModelRenderer(this, 26, 12);
/*  79 */     this.Body4.func_78793_a(-1.9F, -0.8F, 2.2F);
/*  80 */     this.Body4.func_78790_a(-2.5F, -3.0F, -2.0F, 5, 6, 4, 0.0F);
/*  81 */     this.Bodytail1 = new ModelRenderer(this, 26, 53);
/*  82 */     this.Bodytail1.func_78793_a(0.6F, 1.8F, 4.9F);
/*  83 */     this.Bodytail1.func_78790_a(-2.0F, -2.5F, -2.7F, 4, 5, 5, 0.0F);
/*  84 */     this.Body = new ModelRenderer(this, 65, 1);
/*  85 */     this.Body.func_78793_a(0.0F, 3.8F, 0.0F);
/*  86 */     this.Body.func_78790_a(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
/*  87 */     this.Body2 = new ModelRenderer(this, 25, 11);
/*  88 */     this.Body2.func_78793_a(2.1F, -1.9F, -2.3F);
/*  89 */     this.Body2.func_78790_a(-2.5F, -2.5F, -2.5F, 5, 5, 5, 0.0F);
/*  90 */     this.Body.func_78792_a(this.Body8);
/*  91 */     this.Body.func_78792_a(this.Body1);
/*  92 */     this.Body.func_78792_a(this.BodyR);
/*  93 */     this.Body.func_78792_a(this.BodyBot);
/*  94 */     this.Body.func_78792_a(this.Body5);
/*  95 */     this.Body.func_78792_a(this.Body6);
/*  96 */     this.Bodytail1.func_78792_a(this.Bodytail2);
/*  97 */     this.Body.func_78792_a(this.BodyTop);
/*  98 */     this.Body.func_78792_a(this.BodyFront);
/*  99 */     this.Bodytail2.func_78792_a(this.Bodytail3);
/* 100 */     this.Bodytail3.func_78792_a(this.Bodytail4);
/* 101 */     this.Body.func_78792_a(this.Body3);
/* 102 */     this.Body.func_78792_a(this.Body7);
/* 103 */     this.Body.func_78792_a(this.BodyL);
/* 104 */     this.Body.func_78792_a(this.Body4);
/* 105 */     this.Body.func_78792_a(this.Bodytail1);
/* 106 */     this.Body.func_78792_a(this.Body2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 111 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/* 112 */     this.Body.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 119 */     modelRenderer.field_78795_f = x;
/* 120 */     modelRenderer.field_78796_g = y;
/* 121 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float f, float f1, float f2, float f3, float f4, float f5, Entity par7Entity) {
/* 125 */     float ex = par7Entity.field_70173_aa;
/* 126 */     float sin = MathHelper.func_76126_a(ex * 0.5F) * 0.01F;
/* 127 */     float sin2 = MathHelper.func_76126_a(ex * 1.0F) * -0.01F;
/* 128 */     float sin3 = MathHelper.func_76126_a(ex * 1.0F) * 0.01F;
/*     */     
/* 130 */     ModelRenderer[] segments = { this.Body, this.Body1, this.Body2, this.Body3, this.Body4, this.Body5, this.Body6, this.Body7, this.Body8, this.BodyL, this.BodyTop, this.BodyBot, this.BodyFront, this.Bodytail1 };
/*     */ 
/*     */     
/* 133 */     for (int i = 0; i < segments.length; i++) {
/*     */       
/* 135 */       (segments[i]).field_78795_f = sin * ((i / 2 == 0) ? true : -1);
/* 136 */       (segments[i]).field_78796_g = sin2 * ((i / 2 == 0) ? true : -1);
/* 137 */       (segments[i]).field_78808_h = sin3 * ((i / 2 == 0) ? true : -1);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbz\ModelSpirit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */