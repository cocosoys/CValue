/*    */ package net.minecraft.block;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockEventData
/*    */ {
/*    */   private int field_151348_a;
/*    */   private int field_151346_b;
/*    */   private int field_151347_c;
/*    */   
/*    */   public BlockEventData(int p_i45362_1_, int p_i45362_2_, int p_i45362_3_, Block p_i45362_4_, int p_i45362_5_, int p_i45362_6_) {
/* 12 */     this.field_151348_a = p_i45362_1_;
/* 13 */     this.field_151346_b = p_i45362_2_;
/* 14 */     this.field_151347_c = p_i45362_3_;
/* 15 */     this.field_151345_e = p_i45362_5_;
/* 16 */     this.field_151343_f = p_i45362_6_;
/* 17 */     this.field_151344_d = p_i45362_4_;
/*    */   }
/*    */   private Block field_151344_d; private int field_151345_e; private int field_151343_f; private static final String __OBFID = "CL_00000131";
/*    */   public int func_151340_a() {
/* 21 */     return this.field_151348_a;
/*    */   }
/*    */   
/*    */   public int func_151342_b() {
/* 25 */     return this.field_151346_b;
/*    */   }
/*    */   
/*    */   public int func_151341_c() {
/* 29 */     return this.field_151347_c;
/*    */   }
/*    */   
/*    */   public int func_151339_d() {
/* 33 */     return this.field_151345_e;
/*    */   }
/*    */   
/*    */   public int func_151338_e() {
/* 37 */     return this.field_151343_f;
/*    */   }
/*    */   
/*    */   public Block func_151337_f() {
/* 41 */     return this.field_151344_d;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object p_equals_1_) {
/* 46 */     if (p_equals_1_ instanceof BlockEventData) {
/* 47 */       BlockEventData blockEventData = (BlockEventData)p_equals_1_;
/* 48 */       return (this.field_151348_a == blockEventData.field_151348_a && this.field_151346_b == blockEventData.field_151346_b && this.field_151347_c == blockEventData.field_151347_c && this.field_151345_e == blockEventData.field_151345_e && this.field_151343_f == blockEventData.field_151343_f && this.field_151344_d == blockEventData.field_151344_d);
/*    */     } 
/* 50 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 55 */     return "TE(" + this.field_151348_a + "," + this.field_151346_b + "," + this.field_151347_c + ")," + this.field_151345_e + "," + this.field_151343_f + "," + this.field_151344_d;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockEventData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */