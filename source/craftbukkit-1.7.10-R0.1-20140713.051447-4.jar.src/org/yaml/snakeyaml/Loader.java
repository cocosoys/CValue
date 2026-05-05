/*    */ package org.yaml.snakeyaml;
/*    */ 
/*    */ import org.yaml.snakeyaml.constructor.BaseConstructor;
/*    */ import org.yaml.snakeyaml.constructor.Constructor;
/*    */ import org.yaml.snakeyaml.resolver.Resolver;
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
/*    */ public final class Loader
/*    */ {
/*    */   protected final BaseConstructor constructor;
/*    */   protected Resolver resolver;
/*    */   
/*    */   public Loader(BaseConstructor constructor) {
/* 32 */     this.constructor = constructor;
/*    */   }
/*    */   
/*    */   public Loader() {
/* 36 */     this((BaseConstructor)new Constructor());
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\Loader.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */