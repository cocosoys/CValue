/*    */ package org.bukkit.craftbukkit.libs.jline.console.completer;
/*    */ 
/*    */ import java.util.List;
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
/*    */ public final class NullCompleter
/*    */   implements Completer
/*    */ {
/* 34 */   public static final NullCompleter INSTANCE = new NullCompleter();
/*    */   
/*    */   public int complete(String buffer, int cursor, List<CharSequence> candidates) {
/* 37 */     return -1;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\craftbukkit\libs\jline\console\completer\NullCompleter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */