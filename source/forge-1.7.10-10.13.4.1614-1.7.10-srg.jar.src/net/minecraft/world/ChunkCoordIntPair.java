/*    */ package net.minecraft.world;
/*    */ 
/*    */ public class ChunkCoordIntPair {
/*    */   public final int field_77276_a;
/*    */   public final int field_77275_b;
/*    */   private static final String __OBFID = "CL_00000133";
/*    */   
/*    */   public ChunkCoordIntPair(int p_i1947_1_, int p_i1947_2_) {
/*  9 */     this.field_77276_a = p_i1947_1_;
/* 10 */     this.field_77275_b = p_i1947_2_;
/*    */   }
/*    */   
/*    */   public static long func_77272_a(int p_77272_0_, int p_77272_1_) {
/* 14 */     return p_77272_0_ & 0xFFFFFFFFL | (p_77272_1_ & 0xFFFFFFFFL) << 32L;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 23 */     int i = 1664525 * this.field_77276_a + 1013904223;
/* 24 */     int j = 1664525 * (this.field_77275_b ^ 0xDEADBEEF) + 1013904223;
/* 25 */     return i ^ j;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object p_equals_1_) {
/* 30 */     if (this == p_equals_1_) {
/* 31 */       return true;
/*    */     }
/*    */     
/* 34 */     if (p_equals_1_ instanceof ChunkCoordIntPair) {
/* 35 */       ChunkCoordIntPair chunkCoordIntPair = (ChunkCoordIntPair)p_equals_1_;
/*    */       
/* 37 */       return (this.field_77276_a == chunkCoordIntPair.field_77276_a && this.field_77275_b == chunkCoordIntPair.field_77275_b);
/*    */     } 
/*    */     
/* 40 */     return false;
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
/*    */ 
/*    */   
/*    */   public int func_77273_a() {
/* 54 */     return (this.field_77276_a << 4) + 8;
/*    */   }
/*    */   
/*    */   public int func_77274_b() {
/* 58 */     return (this.field_77275_b << 4) + 8;
/*    */   }
/*    */   
/*    */   public ChunkPosition func_151349_a(int p_151349_1_) {
/* 62 */     return new ChunkPosition(func_77273_a(), p_151349_1_, func_77274_b());
/*    */   }
/*    */   
/*    */   public String toString() {
/* 66 */     return "[" + this.field_77276_a + ", " + this.field_77275_b + "]";
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\ChunkCoordIntPair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */