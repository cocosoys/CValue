/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ import java.util.Date;
/*    */ import java.util.UUID;
/*    */ import net.minecraft.util.com.google.gson.JsonObject;
/*    */ import net.minecraft.util.com.mojang.authlib.GameProfile;
/*    */ 
/*    */ public class GameProfileBanEntry
/*    */   extends ExpirableListEntry {
/*    */   public GameProfileBanEntry(GameProfile paramGameProfile) {
/* 11 */     this(paramGameProfile, null, null, null, null);
/*    */   }
/*    */   
/*    */   public GameProfileBanEntry(GameProfile paramGameProfile, Date paramDate1, String paramString1, Date paramDate2, String paramString2) {
/* 15 */     super(paramGameProfile, paramDate2, paramString1, paramDate2, paramString2);
/*    */   }
/*    */   
/*    */   public GameProfileBanEntry(JsonObject paramJsonObject) {
/* 19 */     super(b(paramJsonObject), paramJsonObject);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void a(JsonObject paramJsonObject) {
/* 24 */     if (getKey() == null) {
/*    */       return;
/*    */     }
/* 27 */     paramJsonObject.addProperty("uuid", (((GameProfile)getKey()).getId() == null) ? "" : ((GameProfile)getKey()).getId().toString());
/* 28 */     paramJsonObject.addProperty("name", ((GameProfile)getKey()).getName());
/* 29 */     super.a(paramJsonObject);
/*    */   }
/*    */   private static GameProfile b(JsonObject paramJsonObject) {
/*    */     UUID uUID;
/* 33 */     if (!paramJsonObject.has("uuid") || !paramJsonObject.has("name")) {
/* 34 */       return null;
/*    */     }
/* 36 */     String str = paramJsonObject.get("uuid").getAsString();
/*    */     
/*    */     try {
/* 39 */       uUID = UUID.fromString(str);
/* 40 */     } catch (Throwable throwable) {
/* 41 */       return null;
/*    */     } 
/* 43 */     return new GameProfile(uUID, paramJsonObject.get("name").getAsString());
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\GameProfileBanEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */