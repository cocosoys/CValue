/*    */ package org.bukkit.metadata;
/*    */ 
/*    */ import org.bukkit.plugin.Plugin;
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
/*    */ public class FixedMetadataValue
/*    */   extends LazyMetadataValue
/*    */ {
/*    */   private final Object internalValue;
/*    */   
/*    */   public FixedMetadataValue(Plugin owningPlugin, Object value) {
/* 30 */     super(owningPlugin);
/* 31 */     this.internalValue = value;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void invalidate() {}
/*    */ 
/*    */ 
/*    */   
/*    */   public Object value() {
/* 41 */     return this.internalValue;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\metadata\FixedMetadataValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */