/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ public class RegistryDefault extends RegistrySimple {
/*    */   private final Object a;
/*    */   
/*    */   public RegistryDefault(Object paramObject) {
/*  7 */     this.a = paramObject;
/*    */   }
/*    */ 
/*    */   
/*    */   public Object get(Object paramObject) {
/* 12 */     Object object = super.get(paramObject);
/* 13 */     return (object == null) ? this.a : object;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\RegistryDefault.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */