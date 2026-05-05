/*    */ package net.minecraft.util;
/*    */ 
/*    */ public enum EnumFacing {
/*  4 */   DOWN(0, 1, 0, -1, 0),
/*  5 */   UP(1, 0, 0, 1, 0),
/*  6 */   NORTH(2, 3, 0, 0, -1),
/*  7 */   SOUTH(3, 2, 0, 0, 1),
/*  8 */   EAST(4, 5, -1, 0, 0),
/*  9 */   WEST(5, 4, 1, 0, 0);
/*    */   
/*    */   private final int field_82603_g;
/*    */   
/*    */   private final int field_82613_h;
/*    */   private final int field_82614_i;
/*    */   
/*    */   static {
/* 17 */     field_82609_l = new EnumFacing[6];
/*    */     
/* 19 */     for (EnumFacing enumFacing : values())
/* 20 */       field_82609_l[enumFacing.field_82603_g] = enumFacing; 
/*    */   }
/*    */   private final int field_82611_j; private final int field_82612_k; private static final EnumFacing[] field_82609_l; private static final String __OBFID = "CL_00001201";
/*    */   
/*    */   EnumFacing(int p_i1367_3_, int p_i1367_4_, int p_i1367_5_, int p_i1367_6_, int p_i1367_7_) {
/* 25 */     this.field_82603_g = p_i1367_3_;
/* 26 */     this.field_82613_h = p_i1367_4_;
/* 27 */     this.field_82614_i = p_i1367_5_;
/* 28 */     this.field_82611_j = p_i1367_6_;
/* 29 */     this.field_82612_k = p_i1367_7_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int func_82601_c() {
/* 41 */     return this.field_82614_i;
/*    */   }
/*    */   
/*    */   public int func_96559_d() {
/* 45 */     return this.field_82611_j;
/*    */   }
/*    */   
/*    */   public int func_82599_e() {
/* 49 */     return this.field_82612_k;
/*    */   }
/*    */   
/*    */   public static EnumFacing func_82600_a(int p_82600_0_) {
/* 53 */     return field_82609_l[p_82600_0_ % field_82609_l.length];
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\EnumFacing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */