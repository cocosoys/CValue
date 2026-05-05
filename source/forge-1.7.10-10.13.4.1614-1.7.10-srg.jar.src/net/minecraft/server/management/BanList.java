/*    */ package net.minecraft.server.management;
/*    */ 
/*    */ import com.google.gson.JsonObject;
/*    */ import java.io.File;
/*    */ import java.net.SocketAddress;
/*    */ 
/*    */ public class BanList extends UserList {
/*    */   private static final String __OBFID = "CL_00001396";
/*    */   
/*    */   public BanList(File p_i1490_1_) {
/* 11 */     super(p_i1490_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   protected UserListEntry func_152682_a(JsonObject p_152682_1_) {
/* 16 */     return new IPBanEntry(p_152682_1_);
/*    */   }
/*    */   
/*    */   public boolean func_152708_a(SocketAddress p_152708_1_) {
/* 20 */     String str = func_152707_c(p_152708_1_);
/* 21 */     return func_152692_d(str);
/*    */   }
/*    */   
/*    */   public IPBanEntry func_152709_b(SocketAddress p_152709_1_) {
/* 25 */     String str = func_152707_c(p_152709_1_);
/* 26 */     return (IPBanEntry)func_152683_b(str);
/*    */   }
/*    */   
/*    */   private String func_152707_c(SocketAddress p_152707_1_) {
/* 30 */     String str = p_152707_1_.toString();
/* 31 */     if (str.contains("/")) {
/* 32 */       str = str.substring(str.indexOf('/') + 1);
/*    */     }
/* 34 */     if (str.contains(":")) {
/* 35 */       str = str.substring(0, str.indexOf(':'));
/*    */     }
/* 37 */     return str;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\server\management\BanList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */