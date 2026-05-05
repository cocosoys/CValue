/*    */ package org.bukkit.craftbukkit.libs.jline;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NoInterruptUnixTerminal
/*    */   extends UnixTerminal
/*    */ {
/*    */   public void init() throws Exception {
/* 35 */     super.init();
/* 36 */     getSettings().set("intr undef");
/*    */   }
/*    */ 
/*    */   
/*    */   public void restore() throws Exception {
/* 41 */     getSettings().set("intr ^C");
/* 42 */     super.restore();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\craftbukkit\libs\jline\NoInterruptUnixTerminal.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */