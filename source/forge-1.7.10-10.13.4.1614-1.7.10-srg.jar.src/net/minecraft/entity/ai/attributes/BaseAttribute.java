/*    */ package net.minecraft.entity.ai.attributes;
/*    */ 
/*    */ public abstract class BaseAttribute
/*    */   implements IAttribute {
/*    */   private final String field_111115_a;
/*    */   private final double field_111113_b;
/*    */   
/*    */   protected BaseAttribute(String p_i1607_1_, double p_i1607_2_) {
/*  9 */     this.field_111115_a = p_i1607_1_;
/* 10 */     this.field_111113_b = p_i1607_2_;
/*    */     
/* 12 */     if (p_i1607_1_ == null) throw new IllegalArgumentException("Name cannot be null!"); 
/*    */   }
/*    */   private boolean field_111114_c; private static final String __OBFID = "CL_00001565";
/*    */   
/*    */   public String func_111108_a() {
/* 17 */     return this.field_111115_a;
/*    */   }
/*    */ 
/*    */   
/*    */   public double func_111110_b() {
/* 22 */     return this.field_111113_b;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_111111_c() {
/* 27 */     return this.field_111114_c;
/*    */   }
/*    */   
/*    */   public BaseAttribute func_111112_a(boolean p_111112_1_) {
/* 31 */     this.field_111114_c = p_111112_1_;
/* 32 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 37 */     return this.field_111115_a.hashCode();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\attributes\BaseAttribute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */