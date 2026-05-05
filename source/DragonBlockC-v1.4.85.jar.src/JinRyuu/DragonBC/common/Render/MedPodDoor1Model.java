/*     */ package JinRyuu.DragonBC.common.Render;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import org.lwjgl.opengl.GL11;
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
/*     */ public class MedPodDoor1Model
/*     */   extends ModelBase
/*     */ {
/*     */   ModelRenderer Shape1;
/*     */   ModelRenderer Shape2;
/*     */   
/*     */   public MedPodDoor1Model() {
/*  28 */     this.field_78090_t = 64;
/*  29 */     this.field_78089_u = 32;
/*     */ 
/*     */     
/*  32 */     this.Shape1 = new ModelRenderer(this, 0, 0);
/*  33 */     this.Shape1.func_78789_a(0.0F, 0.0F, 0.0F, 8, 16, 4);
/*  34 */     this.Shape1.func_78793_a(-8.0F, 0.0F, 0.0F);
/*  35 */     this.Shape1.func_78787_b(64, 32);
/*  36 */     setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
/*  37 */     this.Shape2 = new ModelRenderer(this, 24, 0);
/*  38 */     this.Shape2.func_78789_a(0.0F, 0.0F, 0.0F, 8, 16, 4);
/*  39 */     this.Shape2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  40 */     this.Shape2.func_78787_b(64, 32);
/*  41 */     this.Shape2.field_78809_i = true;
/*  42 */     setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  47 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*  48 */     render2(entity, f, f1, f2, f3, f4, f5);
/*     */   }
/*     */ 
/*     */   
/*     */   private void render2(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  53 */     int meta = (int)f4;
/*  54 */     int moving = (int)f3;
/*     */     
/*  56 */     if (meta == 3 || meta == 7) {
/*  57 */       GL11.glPushMatrix();
/*  58 */       GL11.glTranslatef(0.0F - moving * 0.02F, 0.0F, 0.0F);
/*  59 */       this.Shape1.func_78785_a(f5);
/*  60 */       GL11.glPopMatrix();
/*     */       
/*  62 */       GL11.glPushMatrix();
/*  63 */       GL11.glTranslatef(0.0F + moving * 0.02F, 0.0F, 0.0F);
/*  64 */       this.Shape2.func_78785_a(f5);
/*  65 */       GL11.glPopMatrix();
/*     */     }
/*  67 */     else if (meta == 1 || meta == 5) {
/*  68 */       GL11.glPushMatrix();
/*  69 */       GL11.glTranslatef(0.0F - moving * 0.02F, 0.0F, 0.0F);
/*  70 */       this.Shape1.func_78785_a(f5);
/*  71 */       GL11.glPopMatrix();
/*     */       
/*  73 */       GL11.glPushMatrix();
/*  74 */       GL11.glTranslatef(0.0F + moving * 0.02F, 0.0F, 0.0F);
/*  75 */       this.Shape2.func_78785_a(f5);
/*  76 */       GL11.glPopMatrix();
/*     */     }
/*  78 */     else if (meta == 0 || meta == 4) {
/*  79 */       GL11.glPushMatrix();
/*  80 */       GL11.glTranslatef(0.0F - moving * 0.02F, 0.0F, 0.0F);
/*  81 */       this.Shape1.func_78785_a(f5);
/*  82 */       GL11.glPopMatrix();
/*     */       
/*  84 */       GL11.glPushMatrix();
/*  85 */       GL11.glTranslatef(0.0F + moving * 0.02F, 0.0F, 0.0F);
/*  86 */       this.Shape2.func_78785_a(f5);
/*  87 */       GL11.glPopMatrix();
/*     */     }
/*  89 */     else if (meta == 2 || meta == 6) {
/*  90 */       GL11.glPushMatrix();
/*  91 */       GL11.glTranslatef(0.0F - moving * 0.02F, 0.0F, 0.0F);
/*  92 */       this.Shape1.func_78785_a(f5);
/*  93 */       GL11.glPopMatrix();
/*     */       
/*  95 */       GL11.glPushMatrix();
/*  96 */       GL11.glTranslatef(0.0F + moving * 0.02F, 0.0F, 0.0F);
/*  97 */       this.Shape2.func_78785_a(f5);
/*  98 */       GL11.glPopMatrix();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 104 */     model.field_78795_f = x;
/* 105 */     model.field_78796_g = y;
/* 106 */     model.field_78808_h = z;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78087_a(float f, float f1, float f2, float f3, float f4, float f5, Entity par7Entity) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderModel(int v, int m, float f) {
/* 117 */     func_78088_a((Entity)null, 0.0F, 0.0F, 0.0F, v, m, f);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Render\MedPodDoor1Model.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */