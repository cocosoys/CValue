/*    */ package net.minecraft.server.management;
/*    */ 
/*    */ import com.google.gson.JsonObject;
/*    */ import com.mojang.authlib.GameProfile;
/*    */ import java.util.Date;
/*    */ import java.util.UUID;
/*    */ 
/*    */ public class UserListBansEntry
/*    */   extends BanEntry {
/*    */   public UserListBansEntry(GameProfile p_i1134_1_) {
/* 11 */     this(p_i1134_1_, null, null, null, null);
/*    */   }
/*    */   private static final String __OBFID = "CL_00001872";
/*    */   public UserListBansEntry(GameProfile p_i1135_1_, Date p_i1135_2_, String p_i1135_3_, Date p_i1135_4_, String p_i1135_5_) {
/* 15 */     super(p_i1135_1_, p_i1135_4_, p_i1135_3_, p_i1135_4_, p_i1135_5_);
/*    */   }
/*    */   
/*    */   public UserListBansEntry(JsonObject p_i1136_1_) {
/* 19 */     super(func_152648_b(p_i1136_1_), p_i1136_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_152641_a(JsonObject p_152641_1_) {
/* 24 */     if (func_152640_f() == null) {
/*    */       return;
/*    */     }
/* 27 */     p_152641_1_.addProperty("uuid", (((GameProfile)func_152640_f()).getId() == null) ? "" : ((GameProfile)func_152640_f()).getId().toString());
/* 28 */     p_152641_1_.addProperty("name", ((GameProfile)func_152640_f()).getName());
/* 29 */     super.func_152641_a(p_152641_1_);
/*    */   }
/*    */   private static GameProfile func_152648_b(JsonObject p_152648_0_) {
/*    */     UUID uUID;
/* 33 */     if (!p_152648_0_.has("uuid") || !p_152648_0_.has("name")) {
/* 34 */       return null;
/*    */     }
/* 36 */     String str = p_152648_0_.get("uuid").getAsString();
/*    */     
/*    */     try {
/* 39 */       uUID = UUID.fromString(str);
/* 40 */     } catch (Throwable throwable) {
/* 41 */       return null;
/*    */     } 
/* 43 */     return new GameProfile(uUID, p_152648_0_.get("name").getAsString());
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\server\management\UserListBansEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */