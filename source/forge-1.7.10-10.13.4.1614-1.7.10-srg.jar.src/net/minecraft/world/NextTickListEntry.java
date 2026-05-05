/*    */ package net.minecraft.world;
/*    */ 
/*    */ import net.minecraft.block.Block;
/*    */ 
/*    */ public class NextTickListEntry implements Comparable {
/*    */   private static long field_77177_f;
/*    */   private final Block field_151352_g;
/*    */   public int field_77183_a;
/*    */   public int field_77181_b;
/*    */   public int field_77182_c;
/*    */   public long field_77180_e;
/*    */   public int field_82754_f;
/* 13 */   private long field_77178_g = field_77177_f++;
/*    */   
/*    */   public NextTickListEntry(int p_i45370_1_, int p_i45370_2_, int p_i45370_3_, Block p_i45370_4_) {
/* 16 */     this.field_77183_a = p_i45370_1_;
/* 17 */     this.field_77181_b = p_i45370_2_;
/* 18 */     this.field_77182_c = p_i45370_3_;
/* 19 */     this.field_151352_g = p_i45370_4_;
/*    */   }
/*    */   private static final String __OBFID = "CL_00000156";
/*    */   public boolean equals(Object p_equals_1_) {
/* 23 */     if (p_equals_1_ instanceof NextTickListEntry) {
/* 24 */       NextTickListEntry nextTickListEntry = (NextTickListEntry)p_equals_1_;
/* 25 */       return (this.field_77183_a == nextTickListEntry.field_77183_a && this.field_77181_b == nextTickListEntry.field_77181_b && this.field_77182_c == nextTickListEntry.field_77182_c && Block.func_149680_a(this.field_151352_g, nextTickListEntry.field_151352_g));
/*    */     } 
/* 27 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 31 */     return (this.field_77183_a * 1024 * 1024 + this.field_77182_c * 1024 + this.field_77181_b) * 256;
/*    */   }
/*    */   
/*    */   public NextTickListEntry func_77176_a(long p_77176_1_) {
/* 35 */     this.field_77180_e = p_77176_1_;
/* 36 */     return this;
/*    */   }
/*    */   
/*    */   public void func_82753_a(int p_82753_1_) {
/* 40 */     this.field_82754_f = p_82753_1_;
/*    */   }
/*    */ 
/*    */   
/*    */   public int compareTo(NextTickListEntry p_compareTo_1_) {
/* 45 */     if (this.field_77180_e < p_compareTo_1_.field_77180_e) return -1; 
/* 46 */     if (this.field_77180_e > p_compareTo_1_.field_77180_e) return 1; 
/* 47 */     if (this.field_82754_f != p_compareTo_1_.field_82754_f) return this.field_82754_f - p_compareTo_1_.field_82754_f; 
/* 48 */     if (this.field_77178_g < p_compareTo_1_.field_77178_g) return -1; 
/* 49 */     if (this.field_77178_g > p_compareTo_1_.field_77178_g) return 1; 
/* 50 */     return 0;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 54 */     return Block.func_149682_b(this.field_151352_g) + ": (" + this.field_77183_a + ", " + this.field_77181_b + ", " + this.field_77182_c + "), " + this.field_77180_e + ", " + this.field_82754_f + ", " + this.field_77178_g;
/*    */   }
/*    */   
/*    */   public Block func_151351_a() {
/* 58 */     return this.field_151352_g;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\NextTickListEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */