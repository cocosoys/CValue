/*    */ package com.avaje.ebeaninternal.server.reflect;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class EnhanceBeanReflectFactory
/*    */   implements BeanReflectFactory
/*    */ {
/*    */   public BeanReflect create(Class<?> vanillaType, Class<?> entityBeanType) {
/* 10 */     return new EnhanceBeanReflect(vanillaType, entityBeanType);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\reflect\EnhanceBeanReflectFactory.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */