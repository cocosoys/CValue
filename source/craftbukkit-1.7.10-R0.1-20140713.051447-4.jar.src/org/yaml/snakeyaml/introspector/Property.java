/*    */ package org.yaml.snakeyaml.introspector;
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
/*    */ public abstract class Property
/*    */   implements Comparable<Property>
/*    */ {
/*    */   private final String name;
/*    */   private final Class<?> type;
/*    */   
/*    */   public Property(String name, Class<?> type) {
/* 25 */     this.name = name;
/* 26 */     this.type = type;
/*    */   }
/*    */   
/*    */   public Class<?> getType() {
/* 30 */     return this.type;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getName() {
/* 36 */     return this.name;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 41 */     return getName() + " of " + getType();
/*    */   }
/*    */   
/*    */   public int compareTo(Property o) {
/* 45 */     return this.name.compareTo(o.name);
/*    */   }
/*    */   
/*    */   public boolean isWritable() {
/* 49 */     return true;
/*    */   }
/*    */   
/*    */   public boolean isReadable() {
/* 53 */     return true;
/*    */   }
/*    */   
/*    */   public abstract Class<?>[] getActualTypeArguments();
/*    */   
/*    */   public abstract void set(Object paramObject1, Object paramObject2) throws Exception;
/*    */   
/*    */   public abstract Object get(Object paramObject);
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\introspector\Property.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */