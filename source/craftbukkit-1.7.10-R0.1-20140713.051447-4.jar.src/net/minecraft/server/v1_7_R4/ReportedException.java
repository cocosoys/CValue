/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ public class ReportedException
/*    */   extends RuntimeException
/*    */ {
/*    */   private final CrashReport a;
/*    */   
/*    */   public ReportedException(CrashReport paramCrashReport) {
/*  9 */     this.a = paramCrashReport;
/*    */   }
/*    */   
/*    */   public CrashReport a() {
/* 13 */     return this.a;
/*    */   }
/*    */ 
/*    */   
/*    */   public Throwable getCause() {
/* 18 */     return this.a.b();
/*    */   }
/*    */ 
/*    */   
/*    */   public String getMessage() {
/* 23 */     return this.a.a();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\ReportedException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */