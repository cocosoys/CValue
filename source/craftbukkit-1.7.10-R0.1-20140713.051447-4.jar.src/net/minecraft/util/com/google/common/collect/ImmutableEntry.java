/*    */ package net.minecraft.util.com.google.common.collect;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.util.com.google.common.annotations.GwtCompatible;
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
/*    */ @GwtCompatible(serializable = true)
/*    */ class ImmutableEntry<K, V>
/*    */   extends AbstractMapEntry<K, V>
/*    */   implements Serializable
/*    */ {
/*    */   final K key;
/*    */   final V value;
/*    */   private static final long serialVersionUID = 0L;
/*    */   
/*    */   ImmutableEntry(@Nullable K key, @Nullable V value) {
/* 35 */     this.key = key;
/* 36 */     this.value = value;
/*    */   }
/*    */   @Nullable
/*    */   public final K getKey() {
/* 40 */     return this.key;
/*    */   }
/*    */   @Nullable
/*    */   public final V getValue() {
/* 44 */     return this.value;
/*    */   }
/*    */   
/*    */   public final V setValue(V value) {
/* 48 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\com\google\common\collect\ImmutableEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */