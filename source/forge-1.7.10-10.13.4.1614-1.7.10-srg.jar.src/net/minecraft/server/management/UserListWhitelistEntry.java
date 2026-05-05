/*    */ package net.minecraft.server.management;
/*    */ 
/*    */ import com.google.gson.JsonObject;
/*    */ import com.mojang.authlib.GameProfile;
/*    */ import java.util.UUID;
/*    */ 
/*    */ public class UserListWhitelistEntry extends UserListEntry {
/*    */   private static final String __OBFID = "CL_00001870";
/*    */   
/*    */   public UserListWhitelistEntry(GameProfile p_i1129_1_) {
/* 11 */     super(p_i1129_1_);
/*    */   }
/*    */   
/*    */   public UserListWhitelistEntry(JsonObject p_i1130_1_) {
/* 15 */     super(func_152646_b(p_i1130_1_), p_i1130_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_152641_a(JsonObject p_152641_1_) {
/* 20 */     if (func_152640_f() == null) {
/*    */       return;
/*    */     }
/* 23 */     p_152641_1_.addProperty("uuid", (((GameProfile)func_152640_f()).getId() == null) ? "" : ((GameProfile)func_152640_f()).getId().toString());
/* 24 */     p_152641_1_.addProperty("name", ((GameProfile)func_152640_f()).getName());
/* 25 */     super.func_152641_a(p_152641_1_);
/*    */   }
/*    */   private static GameProfile func_152646_b(JsonObject p_152646_0_) {
/*    */     UUID uUID;
/* 29 */     if (!p_152646_0_.has("uuid") || !p_152646_0_.has("name")) {
/* 30 */       return null;
/*    */     }
/* 32 */     String str = p_152646_0_.get("uuid").getAsString();
/*    */     
/*    */     try {
/* 35 */       uUID = UUID.fromString(str);
/* 36 */     } catch (Throwable throwable) {
/* 37 */       return null;
/*    */     } 
/* 39 */     return new GameProfile(uUID, p_152646_0_.get("name").getAsString());
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\server\management\UserListWhitelistEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */