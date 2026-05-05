/*    */ package net.minecraft.util.com.google.common.base;
/*    */ 
/*    */ import net.minecraft.util.com.google.common.annotations.GwtCompatible;
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
/*    */ 
/*    */ 
/*    */ @GwtCompatible(emulated = true)
/*    */ final class Platform
/*    */ {
/*    */   static char[] charBufferFromThreadLocal() {
/* 32 */     return DEST_TL.get();
/*    */   }
/*    */ 
/*    */   
/*    */   static long systemNanoTime() {
/* 37 */     return System.nanoTime();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 45 */   private static final ThreadLocal<char[]> DEST_TL = new ThreadLocal<char[]>()
/*    */     {
/*    */       protected char[] initialValue() {
/* 48 */         return new char[1024];
/*    */       }
/*    */     };
/*    */   
/*    */   static CharMatcher precomputeCharMatcher(CharMatcher matcher) {
/* 53 */     return matcher.precomputedInternal();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\com\google\common\base\Platform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */