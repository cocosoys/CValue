/*    */ package net.minecraft.util;
/*    */ 
/*    */ import com.google.common.collect.BiMap;
/*    */ import com.google.common.collect.HashBiMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RegistryNamespaced
/*    */   extends RegistrySimple
/*    */   implements IObjectIntIterable
/*    */ {
/* 14 */   protected ObjectIntIdentityMap field_148759_a = new ObjectIntIdentityMap();
/*    */   protected final Map field_148758_b;
/*    */   private static final String __OBFID = "CL_00001206";
/*    */   
/*    */   public RegistryNamespaced() {
/* 19 */     this.field_148758_b = (Map)((BiMap)this.field_82596_a).inverse();
/*    */   }
/*    */   
/*    */   public void func_148756_a(int p_148756_1_, String p_148756_2_, Object p_148756_3_) {
/* 23 */     this.field_148759_a.func_148746_a(p_148756_3_, p_148756_1_);
/* 24 */     func_82595_a(func_148755_c(p_148756_2_), p_148756_3_);
/*    */   }
/*    */ 
/*    */   
/*    */   protected Map func_148740_a() {
/* 29 */     return (Map)HashBiMap.create();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Object func_82594_a(String p_82594_1_) {
/* 35 */     return super.func_82594_a(func_148755_c(p_82594_1_));
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_148750_c(Object p_148750_1_) {
/* 40 */     return (String)this.field_148758_b.get(p_148750_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_148741_d(String p_148741_1_) {
/* 45 */     return super.func_148741_d(func_148755_c(p_148741_1_));
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_148757_b(Object p_148757_1_) {
/* 50 */     return this.field_148759_a.func_148747_b(p_148757_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public Object func_148754_a(int p_148754_1_) {
/* 55 */     return this.field_148759_a.func_148745_a(p_148754_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public Iterator iterator() {
/* 60 */     return this.field_148759_a.iterator();
/*    */   }
/*    */   
/*    */   public boolean func_148753_b(int p_148753_1_) {
/* 64 */     return this.field_148759_a.func_148744_b(p_148753_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   protected static String func_148755_c(String p_148755_0_) {
/* 69 */     return (p_148755_0_.indexOf(':') == -1) ? ("minecraft:" + p_148755_0_) : p_148755_0_;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\RegistryNamespaced.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */