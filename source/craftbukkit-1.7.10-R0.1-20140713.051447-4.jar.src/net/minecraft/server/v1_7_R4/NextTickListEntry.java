/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ public class NextTickListEntry
/*    */   implements Comparable
/*    */ {
/*    */   private static long f;
/*    */   private final Block g;
/*    */   public int a;
/*    */   public int b;
/*    */   public int c;
/*    */   public long d;
/*    */   public int e;
/* 13 */   private long h = f++;
/*    */   
/*    */   public NextTickListEntry(int paramInt1, int paramInt2, int paramInt3, Block paramBlock) {
/* 16 */     this.a = paramInt1;
/* 17 */     this.b = paramInt2;
/* 18 */     this.c = paramInt3;
/* 19 */     this.g = paramBlock;
/*    */   }
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 23 */     if (paramObject instanceof NextTickListEntry) {
/* 24 */       NextTickListEntry nextTickListEntry = (NextTickListEntry)paramObject;
/* 25 */       return (this.a == nextTickListEntry.a && this.b == nextTickListEntry.b && this.c == nextTickListEntry.c && Block.a(this.g, nextTickListEntry.g));
/*    */     } 
/* 27 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 31 */     return (this.a * 1024 * 1024 + this.c * 1024 + this.b) * 256;
/*    */   }
/*    */   
/*    */   public NextTickListEntry a(long paramLong) {
/* 35 */     this.d = paramLong;
/* 36 */     return this;
/*    */   }
/*    */   
/*    */   public void a(int paramInt) {
/* 40 */     this.e = paramInt;
/*    */   }
/*    */ 
/*    */   
/*    */   public int compareTo(NextTickListEntry paramNextTickListEntry) {
/* 45 */     if (this.d < paramNextTickListEntry.d) return -1; 
/* 46 */     if (this.d > paramNextTickListEntry.d) return 1; 
/* 47 */     if (this.e != paramNextTickListEntry.e) return this.e - paramNextTickListEntry.e; 
/* 48 */     if (this.h < paramNextTickListEntry.h) return -1; 
/* 49 */     if (this.h > paramNextTickListEntry.h) return 1; 
/* 50 */     return 0;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 54 */     return Block.getId(this.g) + ": (" + this.a + ", " + this.b + ", " + this.c + "), " + this.d + ", " + this.e + ", " + this.h;
/*    */   }
/*    */   
/*    */   public Block a() {
/* 58 */     return this.g;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\NextTickListEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */