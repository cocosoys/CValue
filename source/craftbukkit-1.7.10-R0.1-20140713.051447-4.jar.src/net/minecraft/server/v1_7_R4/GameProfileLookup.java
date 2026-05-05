/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ import net.minecraft.util.com.mojang.authlib.GameProfile;
/*    */ import net.minecraft.util.com.mojang.authlib.ProfileLookupCallback;
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
/*    */ final class GameProfileLookup
/*    */   implements ProfileLookupCallback
/*    */ {
/*    */   GameProfileLookup(GameProfile[] paramArrayOfGameProfile) {}
/*    */   
/*    */   public void onProfileLookupSucceeded(GameProfile paramGameProfile) {
/* 50 */     this.a[0] = paramGameProfile;
/*    */   }
/*    */ 
/*    */   
/*    */   public void onProfileLookupFailed(GameProfile paramGameProfile, Exception paramException) {
/* 55 */     this.a[0] = null;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\GameProfileLookup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */