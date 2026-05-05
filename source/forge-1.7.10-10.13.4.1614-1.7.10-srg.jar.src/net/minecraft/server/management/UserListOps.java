/*    */ package net.minecraft.server.management;
/*    */ 
/*    */ import com.google.gson.JsonObject;
/*    */ import com.mojang.authlib.GameProfile;
/*    */ import java.io.File;
/*    */ 
/*    */ public class UserListOps extends UserList {
/*    */   private static final String __OBFID = "CL_00001879";
/*    */   
/*    */   public UserListOps(File p_i1152_1_) {
/* 11 */     super(p_i1152_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   protected UserListEntry func_152682_a(JsonObject p_152682_1_) {
/* 16 */     return new UserListOpsEntry(p_152682_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public String[] func_152685_a() {
/* 21 */     String[] arrayOfString = new String[func_152688_e().size()];
/* 22 */     byte b = 0;
/* 23 */     for (UserListOpsEntry userListOpsEntry : func_152688_e().values()) {
/* 24 */       arrayOfString[b++] = ((GameProfile)userListOpsEntry.func_152640_f()).getName();
/*    */     }
/* 26 */     return arrayOfString;
/*    */   }
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
/*    */   protected String func_152699_b(GameProfile p_152699_1_) {
/* 39 */     return p_152699_1_.getId().toString();
/*    */   }
/*    */   
/*    */   public GameProfile func_152700_a(String p_152700_1_) {
/* 43 */     for (UserListOpsEntry userListOpsEntry : func_152688_e().values()) {
/* 44 */       if (p_152700_1_.equalsIgnoreCase(((GameProfile)userListOpsEntry.func_152640_f()).getName())) {
/* 45 */         return (GameProfile)userListOpsEntry.func_152640_f();
/*    */       }
/*    */     } 
/* 48 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\server\management\UserListOps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */