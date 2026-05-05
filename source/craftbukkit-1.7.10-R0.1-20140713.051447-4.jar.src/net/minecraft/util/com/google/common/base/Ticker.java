/*    */ package net.minecraft.util.com.google.common.base;
/*    */ 
/*    */ import net.minecraft.util.com.google.common.annotations.Beta;
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
/*    */ @Beta
/*    */ @GwtCompatible
/*    */ public abstract class Ticker
/*    */ {
/*    */   public abstract long read();
/*    */   
/*    */   public static Ticker systemTicker() {
/* 54 */     return SYSTEM_TICKER;
/*    */   }
/*    */   
/* 57 */   private static final Ticker SYSTEM_TICKER = new Ticker()
/*    */     {
/*    */       public long read() {
/* 60 */         return Platform.systemNanoTime();
/*    */       }
/*    */     };
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\com\google\common\base\Ticker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */