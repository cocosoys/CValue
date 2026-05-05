/*    */ package net.minecraft.server.management;
/*    */ 
/*    */ import com.google.gson.JsonObject;
/*    */ import com.mojang.authlib.GameProfile;
/*    */ import java.io.File;
/*    */ 
/*    */ public class UserListBans extends UserList {
/*    */   private static final String __OBFID = "CL_00001873";
/*    */   
/*    */   public UserListBans(File p_i1138_1_) {
/* 11 */     super(p_i1138_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   protected UserListEntry func_152682_a(JsonObject p_152682_1_) {
/* 16 */     return new UserListBansEntry(p_152682_1_);
/*    */   }
/*    */   
/*    */   public boolean func_152702_a(GameProfile p_152702_1_) {
/* 20 */     return func_152692_d(p_152702_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public String[] func_152685_a() {
/* 25 */     String[] arrayOfString = new String[func_152688_e().size()];
/* 26 */     byte b = 0;
/* 27 */     for (UserListBansEntry userListBansEntry : func_152688_e().values()) {
/* 28 */       arrayOfString[b++] = ((GameProfile)userListBansEntry.func_152640_f()).getName();
/*    */     }
/* 30 */     return arrayOfString;
/*    */   }
/*    */ 
/*    */   
/*    */   protected String func_152701_b(GameProfile p_152701_1_) {
/* 35 */     return p_152701_1_.getId().toString();
/*    */   }
/*    */   
/*    */   public GameProfile func_152703_a(String p_152703_1_) {
/* 39 */     for (UserListBansEntry userListBansEntry : func_152688_e().values()) {
/* 40 */       if (p_152703_1_.equalsIgnoreCase(((GameProfile)userListBansEntry.func_152640_f()).getName())) {
/* 41 */         return (GameProfile)userListBansEntry.func_152640_f();
/*    */       }
/*    */     } 
/* 44 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\server\management\UserListBans.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */