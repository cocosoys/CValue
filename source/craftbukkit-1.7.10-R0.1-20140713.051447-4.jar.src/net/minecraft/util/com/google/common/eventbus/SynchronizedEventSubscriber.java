/*    */ package net.minecraft.util.com.google.common.eventbus;
/*    */ 
/*    */ import java.lang.reflect.InvocationTargetException;
/*    */ import java.lang.reflect.Method;
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
/*    */ final class SynchronizedEventSubscriber
/*    */   extends EventSubscriber
/*    */ {
/*    */   public SynchronizedEventSubscriber(Object target, Method method) {
/* 40 */     super(target, method);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void handleEvent(Object event) throws InvocationTargetException {
/* 46 */     synchronized (this) {
/* 47 */       super.handleEvent(event);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\com\google\common\eventbus\SynchronizedEventSubscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */