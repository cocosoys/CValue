/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelBiped;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ 
/*     */ public class ModelKiAuraRing
/*     */   extends ModelBiped
/*     */ {
/*     */   ModelRenderer low;
/*     */   ModelRenderer lowm1;
/*     */   ModelRenderer lowm2;
/*     */   ModelRenderer lowm3;
/*     */   ModelRenderer lowm4;
/*     */   ModelRenderer lowm5;
/*     */   ModelRenderer lowm6;
/*     */   ModelRenderer lowm7;
/*     */   ModelRenderer lowm8;
/*     */   
/*     */   public ModelKiAuraRing() {
/*  22 */     this.field_78090_t = 64;
/*  23 */     this.field_78089_u = 32;
/*     */     
/*  25 */     this.low = new ModelRenderer((ModelBase)this, 32, 0);
/*  26 */     this.low.func_78789_a(0.0F, 0.0F, 0.0F, 1, 1, 1);
/*  27 */     this.low.func_78793_a(0.0F, 20.0F, 0.0F);
/*  28 */     setRotation(this.low, 0.0F, 0.0F, 0.0F);
/*     */     
/*  30 */     this.lowm1 = new ModelRenderer((ModelBase)this, 0, 0);
/*  31 */     this.lowm1.func_78789_a(-5.0F, -12.0F, -8.0F, 10, 10, 0);
/*  32 */     this.lowm1.func_78793_a(0.0F, 20.0F, 0.0F);
/*  33 */     this.lowm1.func_78787_b(64, 32);
/*  34 */     setRotation(this.lowm1, 0.8726646F, 1.570796F, 0.0F);
/*  35 */     this.lowm2 = new ModelRenderer((ModelBase)this, 0, 0);
/*  36 */     this.lowm2.func_78789_a(-5.0F, -12.0F, -8.0F, 10, 10, 0);
/*  37 */     this.lowm2.func_78793_a(0.0F, 20.0F, 0.0F);
/*  38 */     this.lowm2.func_78787_b(64, 32);
/*  39 */     setRotation(this.lowm2, 0.8726646F, 0.0F, 0.0F);
/*  40 */     this.lowm3 = new ModelRenderer((ModelBase)this, 0, 0);
/*  41 */     this.lowm3.func_78789_a(-5.0F, -12.0F, -8.0F, 10, 10, 0);
/*  42 */     this.lowm3.func_78793_a(0.0F, 20.0F, 0.0F);
/*  43 */     this.lowm3.func_78787_b(64, 32);
/*  44 */     setRotation(this.lowm3, 0.8726646F, -0.7853982F, 0.0F);
/*  45 */     this.lowm4 = new ModelRenderer((ModelBase)this, 0, 0);
/*  46 */     this.lowm4.func_78789_a(-5.0F, -12.0F, -8.0F, 10, 10, 0);
/*  47 */     this.lowm4.func_78793_a(0.0F, 20.0F, 0.0F);
/*  48 */     this.lowm4.func_78787_b(64, 32);
/*  49 */     setRotation(this.lowm4, 0.8726646F, 3.141593F, 0.0F);
/*  50 */     this.lowm5 = new ModelRenderer((ModelBase)this, 0, 0);
/*  51 */     this.lowm5.func_78789_a(-5.0F, -12.0F, -8.0F, 10, 10, 0);
/*  52 */     this.lowm5.func_78793_a(0.0F, 20.0F, 0.0F);
/*  53 */     this.lowm5.func_78787_b(64, 32);
/*  54 */     setRotation(this.lowm5, 0.8726646F, -1.570796F, 0.0F);
/*  55 */     this.lowm6 = new ModelRenderer((ModelBase)this, 0, 0);
/*  56 */     this.lowm6.func_78789_a(-5.0F, -12.0F, -8.0F, 10, 10, 0);
/*  57 */     this.lowm6.func_78793_a(0.0F, 20.0F, 0.0F);
/*  58 */     this.lowm6.func_78787_b(64, 32);
/*  59 */     setRotation(this.lowm6, 0.8726646F, -2.373648F, 0.0F);
/*  60 */     this.lowm7 = new ModelRenderer((ModelBase)this, 0, 0);
/*  61 */     this.lowm7.func_78789_a(-5.0F, -12.0F, -8.0F, 10, 10, 0);
/*  62 */     this.lowm7.func_78793_a(0.0F, 20.0F, 0.0F);
/*  63 */     this.lowm7.func_78787_b(64, 32);
/*  64 */     setRotation(this.lowm7, 0.8726646F, 2.373648F, 0.0F);
/*  65 */     this.lowm8 = new ModelRenderer((ModelBase)this, 0, 0);
/*  66 */     this.lowm8.func_78789_a(-5.0F, -12.0F, -8.0F, 10, 10, 0);
/*  67 */     this.lowm8.func_78793_a(0.0F, 20.0F, 0.0F);
/*  68 */     this.lowm8.func_78787_b(64, 32);
/*  69 */     setRotation(this.lowm8, 0.8726646F, 0.7853982F, 0.0F);
/*     */     
/*  71 */     this.low.func_78792_a(this.lowm1);
/*  72 */     this.low.func_78792_a(this.lowm2);
/*  73 */     this.low.func_78792_a(this.lowm3);
/*  74 */     this.low.func_78792_a(this.lowm4);
/*  75 */     this.low.func_78792_a(this.lowm5);
/*  76 */     this.low.func_78792_a(this.lowm6);
/*  77 */     this.low.func_78792_a(this.lowm7);
/*  78 */     this.low.func_78792_a(this.lowm8);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  83 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*  84 */     this.low.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/*  89 */     model.field_78795_f = x;
/*  90 */     model.field_78796_g = y;
/*  91 */     model.field_78808_h = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78087_a(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
/*  96 */     float par3 = f2;
/*  97 */     float par31 = 1.0F;
/*     */     
/*  99 */     this.low.field_78797_d = 28.0F;
/* 100 */     this.low.field_78796_g = -par3 / 5.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderModel(Entity entity, float par8, float par9, float f, float r) {
/* 105 */     func_78088_a(entity, 0.0F, 0.0F, r, par8, par9, f);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelKiAuraRing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */