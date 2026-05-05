/*    */ package net.minecraft.server.management;
/*    */ 
/*    */ import com.google.gson.JsonObject;
/*    */ import com.mojang.authlib.GameProfile;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.io.File;
/*    */ 
/*    */ public class UserListWhitelist
/*    */   extends UserList {
/*    */   public UserListWhitelist(File p_i1132_1_) {
/* 12 */     super(p_i1132_1_);
/*    */   }
/*    */   private static final String __OBFID = "CL_00001871";
/*    */   
/*    */   protected UserListEntry func_152682_a(JsonObject p_152682_1_) {
/* 17 */     return new UserListWhitelistEntry(p_152682_1_);
/*    */   }
/*    */   @SideOnly(Side.SERVER)
/*    */   public boolean func_152705_a(GameProfile p_152705_1_) {
/* 21 */     return func_152692_d(p_152705_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public String[] func_152685_a() {
/* 26 */     String[] arrayOfString = new String[func_152688_e().size()];
/* 27 */     byte b = 0;
/* 28 */     for (UserListWhitelistEntry userListWhitelistEntry : func_152688_e().values()) {
/* 29 */       arrayOfString[b++] = ((GameProfile)userListWhitelistEntry.func_152640_f()).getName();
/*    */     }
/* 31 */     return arrayOfString;
/*    */   }
/*    */ 
/*    */   
/*    */   protected String func_152704_b(GameProfile p_152704_1_) {
/* 36 */     return p_152704_1_.getId().toString();
/*    */   }
/*    */   
/*    */   public GameProfile func_152706_a(String p_152706_1_) {
/* 40 */     for (UserListWhitelistEntry userListWhitelistEntry : func_152688_e().values()) {
/* 41 */       if (p_152706_1_.equalsIgnoreCase(((GameProfile)userListWhitelistEntry.func_152640_f()).getName())) {
/* 42 */         return (GameProfile)userListWhitelistEntry.func_152640_f();
/*    */       }
/*    */     } 
/* 45 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\server\management\UserListWhitelist.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */