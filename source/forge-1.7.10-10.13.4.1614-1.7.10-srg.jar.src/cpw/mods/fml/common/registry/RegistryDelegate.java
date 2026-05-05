/*    */ package cpw.mods.fml.common.registry;
/*    */ 
/*    */ import com.google.common.base.Objects;
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
/*    */ public interface RegistryDelegate<T>
/*    */ {
/*    */   T get();
/*    */   
/*    */   String name();
/*    */   
/*    */   Class<T> type();
/*    */   
/*    */   public static final class Delegate<T>
/*    */     implements RegistryDelegate<T>
/*    */   {
/*    */     private T referant;
/*    */     private String name;
/*    */     private final Class<T> type;
/*    */     
/*    */     public Delegate(T referant, Class<T> type) {
/* 47 */       this.referant = referant;
/* 48 */       this.type = type;
/*    */     }
/*    */ 
/*    */     
/*    */     public T get() {
/* 53 */       return this.referant;
/*    */     }
/*    */ 
/*    */     
/*    */     public String name() {
/* 58 */       return this.name;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public Class<T> type() {
/* 64 */       return this.type;
/*    */     }
/*    */ 
/*    */     
/*    */     void changeReference(T newTarget) {
/* 69 */       this.referant = newTarget;
/*    */     }
/*    */ 
/*    */     
/*    */     void setName(String name) {
/* 74 */       this.name = name;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public boolean equals(Object obj) {
/* 80 */       if (obj instanceof Delegate) {
/*    */         
/* 82 */         Delegate<?> other = (Delegate)obj;
/* 83 */         return Objects.equal(other.name, this.name);
/*    */       } 
/* 85 */       return false;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public int hashCode() {
/* 91 */       return Objects.hashCode(new Object[] { this.name });
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\registry\RegistryDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */