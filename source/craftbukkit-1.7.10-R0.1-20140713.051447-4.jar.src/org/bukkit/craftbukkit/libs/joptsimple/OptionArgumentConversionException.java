/*    */ package org.bukkit.craftbukkit.libs.joptsimple;
/*    */ 
/*    */ import java.util.Collection;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class OptionArgumentConversionException
/*    */   extends OptionException
/*    */ {
/*    */   private static final long serialVersionUID = -1L;
/*    */   private final String argument;
/*    */   private final Class<?> valueType;
/*    */   
/*    */   OptionArgumentConversionException(Collection<String> options, String argument, Class<?> valueType, Throwable cause) {
/* 46 */     super(options, cause);
/*    */     
/* 48 */     this.argument = argument;
/* 49 */     this.valueType = valueType;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getMessage() {
/* 54 */     return "Cannot convert argument '" + this.argument + "' of option " + multipleOptionMessage() + " to " + this.valueType;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\craftbukkit\libs\joptsimple\OptionArgumentConversionException.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */