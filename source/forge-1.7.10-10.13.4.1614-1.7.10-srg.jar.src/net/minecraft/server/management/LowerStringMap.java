/*    */ package net.minecraft.server.management;
/*    */ import java.util.Collection;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class LowerStringMap implements Map {
/*  7 */   private final Map field_76117_a = new LinkedHashMap<Object, Object>();
/*    */   private static final String __OBFID = "CL_00001488";
/*    */   
/*    */   public int size() {
/* 11 */     return this.field_76117_a.size();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isEmpty() {
/* 16 */     return this.field_76117_a.isEmpty();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean containsKey(Object p_containsKey_1_) {
/* 21 */     return this.field_76117_a.containsKey(p_containsKey_1_.toString().toLowerCase());
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean containsValue(Object p_containsValue_1_) {
/* 26 */     return this.field_76117_a.containsKey(p_containsValue_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public Object get(Object p_get_1_) {
/* 31 */     return this.field_76117_a.get(p_get_1_.toString().toLowerCase());
/*    */   }
/*    */ 
/*    */   
/*    */   public Object put(String p_put_1_, Object p_put_2_) {
/* 36 */     return this.field_76117_a.put(p_put_1_.toLowerCase(), p_put_2_);
/*    */   }
/*    */ 
/*    */   
/*    */   public Object remove(Object p_remove_1_) {
/* 41 */     return this.field_76117_a.remove(p_remove_1_.toString().toLowerCase());
/*    */   }
/*    */ 
/*    */   
/*    */   public void putAll(Map p_putAll_1_) {
/* 46 */     for (Map.Entry entry : p_putAll_1_.entrySet()) {
/* 47 */       put((String)entry.getKey(), entry.getValue());
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void clear() {
/* 53 */     this.field_76117_a.clear();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Set keySet() {
/* 59 */     return this.field_76117_a.keySet();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Collection values() {
/* 65 */     return this.field_76117_a.values();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Set entrySet() {
/* 71 */     return this.field_76117_a.entrySet();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\server\management\LowerStringMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */