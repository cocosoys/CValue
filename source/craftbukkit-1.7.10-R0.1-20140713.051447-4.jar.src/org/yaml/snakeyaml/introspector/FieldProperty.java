/*    */ package org.yaml.snakeyaml.introspector;
/*    */ 
/*    */ import java.lang.reflect.Field;
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
/*    */ public class FieldProperty
/*    */   extends GenericProperty
/*    */ {
/*    */   private final Field field;
/*    */   
/*    */   public FieldProperty(Field field) {
/* 27 */     super(field.getName(), field.getType(), field.getGenericType());
/* 28 */     this.field = field;
/* 29 */     field.setAccessible(true);
/*    */   }
/*    */ 
/*    */   
/*    */   public void set(Object object, Object value) throws Exception {
/* 34 */     this.field.set(object, value);
/*    */   }
/*    */ 
/*    */   
/*    */   public Object get(Object object) {
/*    */     try {
/* 40 */       return this.field.get(object);
/* 41 */     } catch (Exception e) {
/* 42 */       throw new YAMLException("Unable to access field " + this.field.getName() + " on object " + object + " : " + e);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\introspector\FieldProperty.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */