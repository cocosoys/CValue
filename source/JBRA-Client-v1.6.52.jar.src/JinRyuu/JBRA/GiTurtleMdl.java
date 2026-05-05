/*     */ package JinRyuu.JBRA;
/*     */ 
/*     */ import JinRyuu.JRMCore.entity.ModelBipedBody;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
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
/*     */ public class GiTurtleMdl
/*     */   extends ModelBipedBody
/*     */ {
/*     */   ModelRenderer leftarmshoulder;
/*     */   ModelRenderer rightarmshoulder;
/*     */   ModelRenderer cape;
/*     */   ModelRenderer c20;
/*     */   ModelRenderer c19;
/*     */   
/*     */   public GiTurtleMdl(float s) {
/*  31 */     super(s, 0.0F, 128, 64);
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
/*  43 */     this.rightarmshoulder = new ModelRenderer((ModelBase)this, 40, 32);
/*  44 */     this.rightarmshoulder.func_78790_a(-3.0F, -5.0F, -3.0F, 7, 4, 6, s);
/*  45 */     this.rightarmshoulder.func_78793_a(-5.0F, 2.0F, 0.0F);
/*  46 */     this.rightarmshoulder.func_78787_b(128, 64);
/*  47 */     setRotation(this.rightarmshoulder, 0.0F, 0.0F, 0.1570796F);
/*  48 */     this.leftarmshoulder = new ModelRenderer((ModelBase)this, 40, 32);
/*  49 */     this.leftarmshoulder.field_78809_i = true;
/*  50 */     this.leftarmshoulder.func_78790_a(-4.0F, -5.0F, -3.0F, 7, 4, 6, s);
/*  51 */     this.leftarmshoulder.func_78793_a(5.0F, 2.0F, 0.0F);
/*  52 */     this.leftarmshoulder.func_78787_b(128, 64);
/*  53 */     setRotation(this.leftarmshoulder, 0.0F, 0.0F, -0.1570796F);
/*     */     
/*  55 */     this.cape = new ModelRenderer((ModelBase)this, 100, 0);
/*  56 */     this.cape.func_78790_a(-7.0F, 1.0F, 3.0F, 14, 20, 0, s);
/*  57 */     this.cape.func_78793_a(0.0F, 0.0F, 0.0F);
/*  58 */     this.cape.func_78787_b(128, 64);
/*  59 */     setRotation(this.cape, 0.1570796F, 0.0F, 0.0F);
/*     */     
/*  61 */     this.c20 = new ModelRenderer((ModelBase)this, 76, 35);
/*  62 */     this.c20.func_78790_a(-4.0F, -12.0F, -4.0F, 8, 4, 8, s);
/*  63 */     this.c20.func_78793_a(0.0F, 0.0F, 0.0F);
/*  64 */     this.c20.func_78787_b(128, 64);
/*  65 */     this.c20.field_78809_i = true;
/*  66 */     setRotation(this.c20, 0.0F, 0.0F, 0.0F);
/*  67 */     this.c19 = new ModelRenderer((ModelBase)this, 106, 29);
/*  68 */     this.c19.func_78790_a(-1.0F, -11.0F, -0.5F, 2, 4, 2, s);
/*  69 */     this.c19.func_78793_a(0.0F, 0.0F, 0.0F);
/*  70 */     this.c19.func_78787_b(128, 64);
/*  71 */     this.c19.field_78809_i = true;
/*  72 */     setRotation(this.c19, 0.0F, 0.0F, 0.0F);
/*     */     
/*  74 */     this.field_78116_c.func_78792_a(this.c20);
/*  75 */     this.field_78116_c.func_78792_a(this.c19);
/*  76 */     this.field_78115_e.func_78792_a(this.cape);
/*  77 */     this.body.func_78792_a(this.cape);
/*  78 */     this.field_78113_g.func_78792_a(this.leftarmshoulder);
/*  79 */     this.field_78112_f.func_78792_a(this.rightarmshoulder);
/*  80 */     this.leftarm.func_78792_a(this.leftarmshoulder);
/*  81 */     this.rightarm.func_78792_a(this.rightarmshoulder);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/*  88 */     model.field_78795_f = x;
/*  89 */     model.field_78796_g = y;
/*  90 */     model.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/*  94 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*  95 */     float s = 0.1070796F;
/*  96 */     if (this.cape != null)
/*  97 */       if (y == 1) {
/*  98 */         float s2 = MathHelper.func_76134_b(par1 * 0.6662F) * 1.0F * par2;
/*  99 */         float s3 = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.0F * par2;
/* 100 */         this.cape.field_78795_f = (s3 + s > s) ? (s3 + s) : ((s2 + s > s) ? (s2 + s) : s);
/*     */       
/*     */       }
/*     */       else {
/*     */ 
/*     */         
/* 106 */         this.cape.field_78795_f = s;
/*     */       }  
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JBRA-Client-v1.6.52.jar!\JinRyuu\JBRA\GiTurtleMdl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */