/*    */ package net.minecraft.util;
/*    */ 
/*    */ public class RegistryDefaulted extends RegistrySimple {
/*    */   private final Object field_82597_b;
/*    */   
/*    */   public RegistryDefaulted(Object p_i1366_1_) {
/*  7 */     this.field_82597_b = p_i1366_1_;
/*    */   }
/*    */   private static final String __OBFID = "CL_00001198";
/*    */   
/*    */   public Object func_82594_a(Object p_82594_1_) {
/* 12 */     Object object = super.func_82594_a(p_82594_1_);
/* 13 */     return (object == null) ? this.field_82597_b : object;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\RegistryDefaulted.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */