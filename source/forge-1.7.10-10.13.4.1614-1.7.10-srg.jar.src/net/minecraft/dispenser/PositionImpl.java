/*    */ package net.minecraft.dispenser;
/*    */ 
/*    */ public class PositionImpl
/*    */   implements IPosition {
/*    */   protected final double field_82630_a;
/*    */   protected final double field_82628_b;
/*    */   
/*    */   public PositionImpl(double p_i1368_1_, double p_i1368_3_, double p_i1368_5_) {
/*  9 */     this.field_82630_a = p_i1368_1_;
/* 10 */     this.field_82628_b = p_i1368_3_;
/* 11 */     this.field_82629_c = p_i1368_5_;
/*    */   }
/*    */   protected final double field_82629_c; private static final String __OBFID = "CL_00001208";
/*    */   
/*    */   public double func_82615_a() {
/* 16 */     return this.field_82630_a;
/*    */   }
/*    */ 
/*    */   
/*    */   public double func_82617_b() {
/* 21 */     return this.field_82628_b;
/*    */   }
/*    */ 
/*    */   
/*    */   public double func_82616_c() {
/* 26 */     return this.field_82629_c;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\dispenser\PositionImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */