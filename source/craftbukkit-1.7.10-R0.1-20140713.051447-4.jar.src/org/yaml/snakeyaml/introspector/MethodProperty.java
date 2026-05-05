/*    */ package org.yaml.snakeyaml.introspector;
/*    */ 
/*    */ import java.beans.PropertyDescriptor;
/*    */ import org.yaml.snakeyaml.error.YAMLException;
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
/*    */ public class MethodProperty
/*    */   extends GenericProperty
/*    */ {
/*    */   private final PropertyDescriptor property;
/*    */   private final boolean readable;
/*    */   private final boolean writable;
/*    */   
/*    */   public MethodProperty(PropertyDescriptor property) {
/* 30 */     super(property.getName(), property.getPropertyType(), (property.getReadMethod() == null) ? null : property.getReadMethod().getGenericReturnType());
/*    */ 
/*    */     
/* 33 */     this.property = property;
/* 34 */     this.readable = (property.getReadMethod() != null);
/* 35 */     this.writable = (property.getWriteMethod() != null);
/*    */   }
/*    */ 
/*    */   
/*    */   public void set(Object object, Object value) throws Exception {
/* 40 */     this.property.getWriteMethod().invoke(object, new Object[] { value });
/*    */   }
/*    */ 
/*    */   
/*    */   public Object get(Object object) {
/*    */     try {
/* 46 */       this.property.getReadMethod().setAccessible(true);
/* 47 */       return this.property.getReadMethod().invoke(object, new Object[0]);
/* 48 */     } catch (Exception e) {
/* 49 */       throw new YAMLException("Unable to find getter for property '" + this.property.getName() + "' on object " + object + ":" + e);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isWritable() {
/* 56 */     return this.writable;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isReadable() {
/* 61 */     return this.readable;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\introspector\MethodProperty.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */