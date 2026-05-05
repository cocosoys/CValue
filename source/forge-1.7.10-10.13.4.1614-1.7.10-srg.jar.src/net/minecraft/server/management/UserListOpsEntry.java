/*    */ package net.minecraft.server.management;
/*    */ 
/*    */ import com.google.gson.JsonObject;
/*    */ import com.mojang.authlib.GameProfile;
/*    */ import java.util.UUID;
/*    */ 
/*    */ public class UserListOpsEntry
/*    */   extends UserListEntry {
/*    */   private final int field_152645_a;
/*    */   private static final String __OBFID = "CL_00001878";
/*    */   
/*    */   public UserListOpsEntry(GameProfile p_i1149_1_, int p_i1149_2_) {
/* 13 */     super(p_i1149_1_);
/* 14 */     this.field_152645_a = p_i1149_2_;
/*    */   }
/*    */   
/*    */   public UserListOpsEntry(JsonObject p_i1150_1_) {
/* 18 */     super(func_152643_b(p_i1150_1_), p_i1150_1_);
/* 19 */     this.field_152645_a = p_i1150_1_.has("level") ? p_i1150_1_.get("level").getAsInt() : 0;
/*    */   }
/*    */   
/*    */   public int func_152644_a() {
/* 23 */     return this.field_152645_a;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_152641_a(JsonObject p_152641_1_) {
/* 28 */     if (func_152640_f() == null) {
/*    */       return;
/*    */     }
/* 31 */     p_152641_1_.addProperty("uuid", (((GameProfile)func_152640_f()).getId() == null) ? "" : ((GameProfile)func_152640_f()).getId().toString());
/* 32 */     p_152641_1_.addProperty("name", ((GameProfile)func_152640_f()).getName());
/* 33 */     super.func_152641_a(p_152641_1_);
/* 34 */     p_152641_1_.addProperty("level", Integer.valueOf(this.field_152645_a));
/*    */   }
/*    */   private static GameProfile func_152643_b(JsonObject p_152643_0_) {
/*    */     UUID uUID;
/* 38 */     if (!p_152643_0_.has("uuid") || !p_152643_0_.has("name")) {
/* 39 */       return null;
/*    */     }
/* 41 */     String str = p_152643_0_.get("uuid").getAsString();
/*    */     
/*    */     try {
/* 44 */       uUID = UUID.fromString(str);
/* 45 */     } catch (Throwable throwable) {
/* 46 */       return null;
/*    */     } 
/* 48 */     return new GameProfile(uUID, p_152643_0_.get("name").getAsString());
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\server\management\UserListOpsEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */