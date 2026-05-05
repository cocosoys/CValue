/*    */ package net.minecraft.util.com.google.common.cache;
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
/*    */ @Beta
/*    */ @GwtCompatible
/*    */ public enum RemovalCause
/*    */ {
/* 40 */   EXPLICIT
/*    */   {
/*    */     boolean wasEvicted() {
/* 43 */       return false;
/*    */     }
/*    */   },
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 53 */   REPLACED
/*    */   {
/*    */     boolean wasEvicted() {
/* 56 */       return false;
/*    */     }
/*    */   },
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 65 */   COLLECTED
/*    */   {
/*    */     boolean wasEvicted() {
/* 68 */       return true;
/*    */     }
/*    */   },
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 76 */   EXPIRED
/*    */   {
/*    */     boolean wasEvicted() {
/* 79 */       return true;
/*    */     }
/*    */   },
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 87 */   SIZE
/*    */   {
/*    */     boolean wasEvicted() {
/* 90 */       return true;
/*    */     }
/*    */   };
/*    */   
/*    */   abstract boolean wasEvicted();
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\com\google\common\cache\RemovalCause.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */