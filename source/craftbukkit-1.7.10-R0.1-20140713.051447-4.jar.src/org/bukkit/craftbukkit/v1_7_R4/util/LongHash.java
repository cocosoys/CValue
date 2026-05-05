/*    */ package org.bukkit.craftbukkit.v1_7_R4.util;
/*    */ 
/*    */ public class LongHash {
/*    */   public static long toLong(int msw, int lsw) {
/*  5 */     return (msw << 32L) + lsw - -2147483648L;
/*    */   }
/*    */   
/*    */   public static int msw(long l) {
/*  9 */     return (int)(l >> 32L);
/*    */   }
/*    */   
/*    */   public static int lsw(long l) {
/* 13 */     return (int)(l & 0xFFFFFFFFFFFFFFFFL) + Integer.MIN_VALUE;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\craftbukkit\v1_7_R\\util\LongHash.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */