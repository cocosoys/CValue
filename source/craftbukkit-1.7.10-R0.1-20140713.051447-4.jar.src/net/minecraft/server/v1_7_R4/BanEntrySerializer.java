/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.lang.reflect.Type;
/*     */ import java.text.ParseException;
/*     */ import java.util.Date;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.util.com.google.gson.JsonDeserializationContext;
/*     */ import net.minecraft.util.com.google.gson.JsonDeserializer;
/*     */ import net.minecraft.util.com.google.gson.JsonElement;
/*     */ import net.minecraft.util.com.google.gson.JsonObject;
/*     */ import net.minecraft.util.com.google.gson.JsonSerializationContext;
/*     */ import net.minecraft.util.com.google.gson.JsonSerializer;
/*     */ import net.minecraft.util.com.mojang.authlib.GameProfile;
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
/*     */ class BanEntrySerializer
/*     */   implements JsonDeserializer, JsonSerializer
/*     */ {
/*     */   private BanEntrySerializer(UserCache paramUserCache) {}
/*     */   
/*     */   public JsonElement a(UserCacheEntry paramUserCacheEntry, Type paramType, JsonSerializationContext paramJsonSerializationContext) {
/* 213 */     JsonObject jsonObject = new JsonObject();
/* 214 */     jsonObject.addProperty("name", paramUserCacheEntry.a().getName());
/* 215 */     UUID uUID = paramUserCacheEntry.a().getId();
/* 216 */     jsonObject.addProperty("uuid", (uUID == null) ? "" : uUID.toString());
/* 217 */     jsonObject.addProperty("expiresOn", UserCache.a.format(paramUserCacheEntry.b()));
/* 218 */     return (JsonElement)jsonObject;
/*     */   }
/*     */ 
/*     */   
/*     */   public UserCacheEntry a(JsonElement paramJsonElement, Type paramType, JsonDeserializationContext paramJsonDeserializationContext) {
/* 223 */     if (paramJsonElement.isJsonObject()) {
/* 224 */       UUID uUID; JsonObject jsonObject = paramJsonElement.getAsJsonObject();
/* 225 */       JsonElement jsonElement1 = jsonObject.get("name");
/* 226 */       JsonElement jsonElement2 = jsonObject.get("uuid");
/* 227 */       JsonElement jsonElement3 = jsonObject.get("expiresOn");
/* 228 */       if (jsonElement1 == null || jsonElement2 == null) {
/* 229 */         return null;
/*     */       }
/* 231 */       String str1 = jsonElement2.getAsString();
/* 232 */       String str2 = jsonElement1.getAsString();
/* 233 */       Date date = null;
/* 234 */       if (jsonElement3 != null) {
/*     */         try {
/* 236 */           date = UserCache.a.parse(jsonElement3.getAsString());
/* 237 */         } catch (ParseException parseException) {
/* 238 */           date = null;
/*     */         } 
/*     */       }
/* 241 */       if (str2 == null || str1 == null) {
/* 242 */         return null;
/*     */       }
/*     */       
/*     */       try {
/* 246 */         uUID = UUID.fromString(str1);
/* 247 */       } catch (Throwable throwable) {
/* 248 */         return null;
/*     */       } 
/* 250 */       return new UserCacheEntry(this.a, new GameProfile(uUID, str2), date, null);
/*     */     } 
/*     */     
/* 253 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\BanEntrySerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */