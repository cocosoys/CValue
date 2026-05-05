/*    */ package net.minecraft.entity.ai.attributes;
/*    */ 
/*    */ public class RangedAttribute
/*    */   extends BaseAttribute {
/*    */   private final double field_111120_a;
/*    */   private final double field_111118_b;
/*    */   
/*    */   public RangedAttribute(String p_i1609_1_, double p_i1609_2_, double p_i1609_4_, double p_i1609_6_) {
/*  9 */     super(p_i1609_1_, p_i1609_2_);
/* 10 */     this.field_111120_a = p_i1609_4_;
/* 11 */     this.field_111118_b = p_i1609_6_;
/*    */     
/* 13 */     if (p_i1609_4_ > p_i1609_6_) throw new IllegalArgumentException("Minimum value cannot be bigger than maximum value!"); 
/* 14 */     if (p_i1609_2_ < p_i1609_4_) throw new IllegalArgumentException("Default value cannot be lower than minimum value!"); 
/* 15 */     if (p_i1609_2_ > p_i1609_6_) throw new IllegalArgumentException("Default value cannot be bigger than maximum value!");
/*    */   
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private String field_111119_c;
/*    */   
/*    */   private static final String __OBFID = "CL_00001568";
/*    */ 
/*    */   
/*    */   public RangedAttribute func_111117_a(String p_111117_1_) {
/* 27 */     this.field_111119_c = p_111117_1_;
/* 28 */     return this;
/*    */   }
/*    */   
/*    */   public String func_111116_f() {
/* 32 */     return this.field_111119_c;
/*    */   }
/*    */ 
/*    */   
/*    */   public double func_111109_a(double p_111109_1_) {
/* 37 */     if (p_111109_1_ < this.field_111120_a) p_111109_1_ = this.field_111120_a; 
/* 38 */     if (p_111109_1_ > this.field_111118_b) p_111109_1_ = this.field_111118_b;
/*    */     
/* 40 */     return p_111109_1_;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\attributes\RangedAttribute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */