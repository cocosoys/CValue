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
/*    */ public class UnsupportedTerminal
/*    */   extends TerminalSupport
/*    */ {
/*    */   public UnsupportedTerminal() {
/* 21 */     super(false);
/* 22 */     setAnsiSupported(false);
/* 23 */     setEchoEnabled(true);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\craftbukkit\libs\jline\UnsupportedTerminal.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */