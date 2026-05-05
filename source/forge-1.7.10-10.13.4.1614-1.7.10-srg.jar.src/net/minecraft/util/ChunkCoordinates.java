/*     */ package net.minecraft.util;
/*     */ 
/*     */ public class ChunkCoordinates
/*     */   implements Comparable
/*     */ {
/*     */   public int field_71574_a;
/*     */   public int field_71572_b;
/*     */   public int field_71573_c;
/*     */   private static final String __OBFID = "CL_00001555";
/*     */   
/*     */   public ChunkCoordinates() {}
/*     */   
/*     */   public ChunkCoordinates(int p_i1354_1_, int p_i1354_2_, int p_i1354_3_) {
/*  14 */     this.field_71574_a = p_i1354_1_;
/*  15 */     this.field_71572_b = p_i1354_2_;
/*  16 */     this.field_71573_c = p_i1354_3_;
/*     */   }
/*     */   
/*     */   public ChunkCoordinates(ChunkCoordinates p_i1355_1_) {
/*  20 */     this.field_71574_a = p_i1355_1_.field_71574_a;
/*  21 */     this.field_71572_b = p_i1355_1_.field_71572_b;
/*  22 */     this.field_71573_c = p_i1355_1_.field_71573_c;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object p_equals_1_) {
/*  27 */     if (!(p_equals_1_ instanceof ChunkCoordinates)) {
/*  28 */       return false;
/*     */     }
/*     */     
/*  31 */     ChunkCoordinates chunkCoordinates = (ChunkCoordinates)p_equals_1_;
/*  32 */     return (this.field_71574_a == chunkCoordinates.field_71574_a && this.field_71572_b == chunkCoordinates.field_71572_b && this.field_71573_c == chunkCoordinates.field_71573_c);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  37 */     return this.field_71574_a + this.field_71573_c << 8 + this.field_71572_b << 16;
/*     */   }
/*     */ 
/*     */   
/*     */   public int compareTo(ChunkCoordinates p_compareTo_1_) {
/*  42 */     if (this.field_71572_b == p_compareTo_1_.field_71572_b) {
/*  43 */       if (this.field_71573_c == p_compareTo_1_.field_71573_c) {
/*  44 */         return this.field_71574_a - p_compareTo_1_.field_71574_a;
/*     */       }
/*  46 */       return this.field_71573_c - p_compareTo_1_.field_71573_c;
/*     */     } 
/*  48 */     return this.field_71572_b - p_compareTo_1_.field_71572_b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_71571_b(int p_71571_1_, int p_71571_2_, int p_71571_3_) {
/*  56 */     this.field_71574_a = p_71571_1_;
/*  57 */     this.field_71572_b = p_71571_2_;
/*  58 */     this.field_71573_c = p_71571_3_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float func_71569_e(int p_71569_1_, int p_71569_2_, int p_71569_3_) {
/* 200 */     float f1 = (this.field_71574_a - p_71569_1_);
/* 201 */     float f2 = (this.field_71572_b - p_71569_2_);
/* 202 */     float f3 = (this.field_71573_c - p_71569_3_);
/* 203 */     return f1 * f1 + f2 * f2 + f3 * f3;
/*     */   }
/*     */   
/*     */   public float func_82371_e(ChunkCoordinates p_82371_1_) {
/* 207 */     return func_71569_e(p_82371_1_.field_71574_a, p_82371_1_.field_71572_b, p_82371_1_.field_71573_c);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 212 */     return "Pos{x=" + this.field_71574_a + ", y=" + this.field_71572_b + ", z=" + this.field_71573_c + '}';
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\ChunkCoordinates.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */