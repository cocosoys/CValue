/*    */ package org.bukkit.craftbukkit.libs.jline.console.completer;
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
/*    */ public class EnumCompleter
/*    */   extends StringsCompleter
/*    */ {
/*    */   public EnumCompleter(Class<? extends Enum> source) {
/* 29 */     assert source != null;
/*    */     
/* 31 */     for (Enum<?> n : (Enum[])source.getEnumConstants())
/* 32 */       getStrings().add(n.name().toLowerCase()); 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\craftbukkit\libs\jline\console\completer\EnumCompleter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */