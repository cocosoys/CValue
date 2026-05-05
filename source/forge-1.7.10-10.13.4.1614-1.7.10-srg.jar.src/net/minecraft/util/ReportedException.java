/*    */ package net.minecraft.util;
/*    */ 
/*    */ import net.minecraft.crash.CrashReport;
/*    */ 
/*    */ public class ReportedException extends RuntimeException {
/*    */   private final CrashReport field_71576_a;
/*    */   
/*    */   public ReportedException(CrashReport p_i1356_1_) {
/*  9 */     this.field_71576_a = p_i1356_1_;
/*    */   }
/*    */   private static final String __OBFID = "CL_00001579";
/*    */   public CrashReport func_71575_a() {
/* 13 */     return this.field_71576_a;
/*    */   }
/*    */ 
/*    */   
/*    */   public Throwable getCause() {
/* 18 */     return this.field_71576_a.func_71505_b();
/*    */   }
/*    */ 
/*    */   
/*    */   public String getMessage() {
/* 23 */     return this.field_71576_a.func_71501_a();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\ReportedException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */