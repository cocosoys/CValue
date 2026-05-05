/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class ScoreboardTeamBase
/*    */ {
/*    */   public boolean isAlly(ScoreboardTeamBase paramScoreboardTeamBase) {
/*  8 */     if (paramScoreboardTeamBase == null) {
/*  9 */       return false;
/*    */     }
/* 11 */     if (this == paramScoreboardTeamBase) {
/* 12 */       return true;
/*    */     }
/* 14 */     return false;
/*    */   }
/*    */   
/*    */   public abstract String getName();
/*    */   
/*    */   public abstract String getFormattedName(String paramString);
/*    */   
/*    */   public abstract boolean allowFriendlyFire();
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\ScoreboardTeamBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */