/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelBiped;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ 
/*     */ public class ModelKiMakanko
/*     */   extends ModelBiped
/*     */ {
/*     */   ModelRenderer Shape1;
/*     */   ModelRenderer Shape2;
/*     */   ModelRenderer Shape3;
/*     */   ModelRenderer Shape4;
/*     */   ModelRenderer Shape5;
/*     */   ModelRenderer Shape6;
/*     */   ModelRenderer Shape7;
/*     */   ModelRenderer Shape8;
/*     */   ModelRenderer Shape9;
/*     */   
/*     */   public ModelKiMakanko() {
/*  22 */     this.field_78090_t = 128;
/*  23 */     this.field_78089_u = 128;
/*     */     
/*  25 */     this.Shape1 = new ModelRenderer((ModelBase)this, 0, 8);
/*  26 */     this.Shape1.func_78789_a(-3.0F, -3.0F, -7.0F, 6, 6, 14);
/*  27 */     this.Shape1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  28 */     this.Shape1.func_78787_b(128, 128);
/*  29 */     setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
/*  30 */     this.Shape2 = new ModelRenderer((ModelBase)this, 0, 8);
/*  31 */     this.Shape2.func_78789_a(-2.0F, -2.0F, -8.0F, 4, 4, 16);
/*  32 */     this.Shape2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  33 */     this.Shape2.func_78787_b(128, 128);
/*  34 */     setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
/*  35 */     this.Shape3 = new ModelRenderer((ModelBase)this, 0, 8);
/*  36 */     this.Shape3.func_78789_a(-2.0F, -4.0F, -6.0F, 4, 8, 12);
/*  37 */     this.Shape3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  38 */     this.Shape3.func_78787_b(128, 128);
/*  39 */     setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
/*  40 */     this.Shape4 = new ModelRenderer((ModelBase)this, 0, 8);
/*  41 */     this.Shape4.func_78789_a(-4.0F, -2.0F, -6.0F, 8, 4, 12);
/*  42 */     this.Shape4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  43 */     this.Shape4.func_78787_b(128, 128);
/*  44 */     setRotation(this.Shape4, 0.0F, 0.0F, 0.0F);
/*  45 */     this.Shape5 = new ModelRenderer((ModelBase)this, 0, 0);
/*  46 */     this.Shape5.func_78789_a(6.0F, -3.0F, -5.0F, 1, 6, 1);
/*  47 */     this.Shape5.func_78793_a(0.0F, 0.0F, 0.0F);
/*  48 */     this.Shape5.func_78787_b(128, 128);
/*  49 */     setRotation(this.Shape5, -0.3490659F, 0.0F, 0.0F);
/*  50 */     this.Shape6 = new ModelRenderer((ModelBase)this, 0, 0);
/*  51 */     this.Shape6.func_78789_a(7.0F, -3.0F, -3.0F, 1, 6, 1);
/*  52 */     this.Shape6.func_78793_a(0.0F, 0.0F, 0.0F);
/*  53 */     this.Shape6.func_78787_b(128, 128);
/*  54 */     setRotation(this.Shape6, -0.3490659F, 0.0F, -0.7853982F);
/*  55 */     this.Shape7 = new ModelRenderer((ModelBase)this, 0, 0);
/*  56 */     this.Shape7.func_78789_a(-3.533333F, -8.2F, -0.5333334F, 7, 1, 1);
/*  57 */     this.Shape7.func_78793_a(0.0F, 0.0F, 0.0F);
/*  58 */     this.Shape7.func_78787_b(128, 128);
/*  59 */     setRotation(this.Shape7, 0.0F, 0.4537856F, 0.0F);
/*  60 */     this.Shape8 = new ModelRenderer((ModelBase)this, 0, 0);
/*  61 */     this.Shape8.func_78789_a(-3.0F, -8.0F, -0.4666667F, 6, 1, 1);
/*  62 */     this.Shape8.func_78793_a(0.0F, 0.0F, 0.0F);
/*  63 */     this.Shape8.func_78787_b(128, 128);
/*  64 */     setRotation(this.Shape8, 0.0F, 0.4014257F, -0.7853982F);
/*  65 */     this.Shape9 = new ModelRenderer((ModelBase)this, 0, 0);
/*  66 */     this.Shape9.func_78789_a(-7.0F, -3.0F, 3.0F, 1, 6, 1);
/*  67 */     this.Shape9.func_78793_a(0.0F, 0.0F, 0.0F);
/*  68 */     this.Shape9.func_78787_b(128, 128);
/*  69 */     setRotation(this.Shape9, 0.3490659F, 0.0F, 0.0F);
/*     */ 
/*     */     
/*  72 */     this.Shape1.func_78792_a(this.Shape2);
/*  73 */     this.Shape1.func_78792_a(this.Shape3);
/*  74 */     this.Shape1.func_78792_a(this.Shape4);
/*  75 */     this.Shape7.func_78792_a(this.Shape5);
/*  76 */     this.Shape7.func_78792_a(this.Shape6);
/*  77 */     this.Shape7.func_78792_a(this.Shape8);
/*  78 */     this.Shape7.func_78792_a(this.Shape9);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  84 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*  85 */     this.Shape1.func_78785_a(f5);
/*  86 */     this.Shape7.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/*  91 */     model.field_78795_f = x;
/*  92 */     model.field_78796_g = y;
/*  93 */     model.field_78808_h = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78087_a(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
/*  98 */     float par3 = f2;
/*  99 */     float par31 = 1.0F;
/*     */ 
/*     */     
/* 102 */     this.Shape1.field_78808_h = par3;
/*     */     
/* 104 */     this.Shape7.field_78808_h = -par3;
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderModel(Entity entity, float par8, float par9, float f, float r) {
/* 109 */     func_78088_a(entity, 0.0F, 0.0F, r, par8, par9, f);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelKiMakanko.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */