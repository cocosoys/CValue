/*    */ package net.minecraft.util;
/*    */ 
/*    */ import com.google.common.base.Predicates;
/*    */ import com.google.common.collect.Iterators;
/*    */ import com.google.common.collect.Lists;
/*    */ import java.util.IdentityHashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ public class ObjectIntIdentityMap
/*    */   implements IObjectIntIterable
/*    */ {
/* 14 */   protected IdentityHashMap field_148749_a = new IdentityHashMap<Object, Object>(512);
/* 15 */   protected List field_148748_b = Lists.newArrayList();
/*    */   
/*    */   public void func_148746_a(Object p_148746_1_, int p_148746_2_) {
/* 18 */     this.field_148749_a.put(p_148746_1_, Integer.valueOf(p_148746_2_));
/*    */ 
/*    */     
/* 21 */     while (this.field_148748_b.size() <= p_148746_2_) {
/* 22 */       this.field_148748_b.add(null);
/*    */     }
/*    */     
/* 25 */     this.field_148748_b.set(p_148746_2_, p_148746_1_);
/*    */   }
/*    */   private static final String __OBFID = "CL_00001203";
/*    */   
/*    */   public int func_148747_b(Object p_148747_1_) {
/* 30 */     Integer integer = (Integer)this.field_148749_a.get(p_148747_1_);
/* 31 */     return (integer == null) ? -1 : integer.intValue();
/*    */   }
/*    */ 
/*    */   
/*    */   public Object func_148745_a(int p_148745_1_) {
/* 36 */     if (p_148745_1_ >= 0 && p_148745_1_ < this.field_148748_b.size()) {
/* 37 */       return this.field_148748_b.get(p_148745_1_);
/*    */     }
/*    */     
/* 40 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public Iterator iterator() {
/* 45 */     return (Iterator)Iterators.filter(this.field_148748_b.iterator(), Predicates.notNull());
/*    */   }
/*    */   
/*    */   public boolean func_148744_b(int p_148744_1_) {
/* 49 */     return (func_148745_a(p_148744_1_) != null);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\ObjectIntIdentityMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */