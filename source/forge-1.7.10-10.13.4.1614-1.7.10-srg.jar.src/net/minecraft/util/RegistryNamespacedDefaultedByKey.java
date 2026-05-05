/*    */ package net.minecraft.util;
/*    */ 
/*    */ public class RegistryNamespacedDefaultedByKey
/*    */   extends RegistryNamespaced {
/*    */   private final String field_148760_d;
/*    */   private Object field_148761_e;
/*    */   private static final String __OBFID = "CL_00001196";
/*    */   
/*    */   public RegistryNamespacedDefaultedByKey(String p_i45127_1_) {
/* 10 */     this.field_148760_d = p_i45127_1_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148756_a(int p_148756_1_, String p_148756_2_, Object p_148756_3_) {
/* 15 */     if (this.field_148760_d.equals(p_148756_2_)) {
/* 16 */       this.field_148761_e = p_148756_3_;
/*    */     }
/*    */     
/* 19 */     super.func_148756_a(p_148756_1_, p_148756_2_, p_148756_3_);
/*    */   }
/*    */ 
/*    */   
/*    */   public Object func_82594_a(String p_82594_1_) {
/* 24 */     Object object = super.func_82594_a(p_82594_1_);
/* 25 */     return (object == null) ? this.field_148761_e : object;
/*    */   }
/*    */ 
/*    */   
/*    */   public Object func_148754_a(int p_148754_1_) {
/* 30 */     Object object = super.func_148754_a(p_148754_1_);
/* 31 */     return (object == null) ? this.field_148761_e : object;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\RegistryNamespacedDefaultedByKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */