/*    */ package net.minecraft.util.io.netty.handler.logging;
/*    */ 
/*    */ import net.minecraft.util.io.netty.util.internal.logging.InternalLogLevel;
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
/*    */ public enum LogLevel
/*    */ {
/* 21 */   TRACE(InternalLogLevel.TRACE),
/* 22 */   DEBUG(InternalLogLevel.DEBUG),
/* 23 */   INFO(InternalLogLevel.INFO),
/* 24 */   WARN(InternalLogLevel.WARN),
/* 25 */   ERROR(InternalLogLevel.ERROR);
/*    */   
/*    */   private final InternalLogLevel internalLevel;
/*    */   
/*    */   LogLevel(InternalLogLevel internalLevel) {
/* 30 */     this.internalLevel = internalLevel;
/*    */   }
/*    */   
/*    */   InternalLogLevel toInternalLevel() {
/* 34 */     return this.internalLevel;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\io\netty\handler\logging\LogLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */