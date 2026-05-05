/*     */ package JinRyuu.JBRA;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreCliTicH;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.EntityRenderer;
/*     */ 
/*     */ public class JBRAEnRen
/*     */   extends EntityRenderer {
/*     */   private final Minecraft mc;
/*     */   private static double lastpos;
/*     */   
/*     */   public JBRAEnRen(Minecraft mc) {
/*  14 */     super(mc, mc.func_110442_L());
/*  15 */     this.mc = mc;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78471_a(float par1, long par2) {
/*  22 */     super.func_78471_a(par1, par2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78480_b(float partialTick) {
/*  29 */     if (this.mc.field_71439_g == null || this.mc.field_71439_g.func_70608_bn()) {
/*  30 */       super.func_78480_b(partialTick);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*  35 */     if (this.mc.field_71439_g.func_70094_T())
/*     */     {
/*  37 */       this.mc.field_71439_g.eyeHeight = this.mc.field_71439_g.getDefaultEyeHeight() + JRMCoreCliTicH.clientHght * 0.9F - 1.7F;
/*     */     }
/*  39 */     this.mc.field_71439_g.field_70129_M -= JRMCoreCliTicH.offsetY;
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
/*  61 */     super.func_78480_b(partialTick);
/*     */ 
/*     */ 
/*     */     
/*  65 */     if (this.mc.field_71439_g != null) {
/*  66 */       this.mc.field_71439_g.eyeHeight = this.mc.field_71439_g.getDefaultEyeHeight();
/*  67 */       this.mc.field_71439_g.field_70129_M = 1.62F;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78463_b(double par1) {
/*  73 */     this.mc.field_71439_g.field_70129_M = 1.62F;
/*     */ 
/*     */ 
/*     */     
/*  77 */     if (JRMCoreH.NC() && this.mc.field_71415_G && JRMCoreH.State == 1 && JRMCoreH.Pwrtyp == 2 && JRMCoreH.Class == 1) {
/*     */       
/*  79 */       super.func_78463_b(par1);
/*  80 */       super.func_78483_a(par1);
/*     */     } else {
/*  82 */       super.func_78463_b(par1);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78483_a(double par1) {
/*  89 */     super.func_78483_a(par1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78473_a(float partialTick) {
/*  96 */     if (this.mc.field_71439_g == null || this.mc.field_71439_g.func_70608_bn()) {
/*  97 */       super.func_78473_a(partialTick);
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */     
/* 104 */     this.mc.field_71439_g.field_70163_u += JRMCoreCliTicH.offsetY;
/* 105 */     this.mc.field_71439_g.field_70167_r += JRMCoreCliTicH.offsetY;
/* 106 */     this.mc.field_71439_g.field_70137_T += JRMCoreCliTicH.offsetY;
/* 107 */     super.func_78473_a(partialTick);
/* 108 */     this.mc.field_71439_g.field_70163_u -= JRMCoreCliTicH.offsetY;
/* 109 */     this.mc.field_71439_g.field_70167_r -= JRMCoreCliTicH.offsetY;
/* 110 */     this.mc.field_71439_g.field_70137_T -= JRMCoreCliTicH.offsetY;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JBRA-Client-v1.6.52.jar!\JinRyuu\JBRA\JBRAEnRen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */