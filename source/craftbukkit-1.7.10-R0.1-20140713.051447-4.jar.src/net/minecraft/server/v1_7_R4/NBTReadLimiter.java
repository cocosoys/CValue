/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ public class NBTReadLimiter {
/*  4 */   public static final NBTReadLimiter a = new NBTReadLimiterUnlimited(0L);
/*    */ 
/*    */   
/*    */   private final long b;
/*    */ 
/*    */   
/*    */   private long c;
/*    */ 
/*    */ 
/*    */   
/*    */   public NBTReadLimiter(long paramLong) {
/* 15 */     this.b = paramLong;
/*    */   }
/*    */   
/*    */   public void a(long paramLong) {
/* 19 */     this.c += paramLong / 8L;
/* 20 */     if (this.c > this.b)
/* 21 */       throw new RuntimeException("Tried to read NBT tag that was too big; tried to allocate: " + this.c + "bytes where max allowed: " + this.b); 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\NBTReadLimiter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */