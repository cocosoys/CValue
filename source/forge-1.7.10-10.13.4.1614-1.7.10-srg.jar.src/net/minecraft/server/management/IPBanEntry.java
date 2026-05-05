/*    */ package net.minecraft.server.management;
/*    */ 
/*    */ import com.google.gson.JsonObject;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class IPBanEntry
/*    */   extends BanEntry {
/*    */   public IPBanEntry(String p_i1158_1_) {
/*  9 */     this(p_i1158_1_, null, null, null, null);
/*    */   }
/*    */   private static final String __OBFID = "CL_00001883";
/*    */   public IPBanEntry(String p_i1159_1_, Date p_i1159_2_, String p_i1159_3_, Date p_i1159_4_, String p_i1159_5_) {
/* 13 */     super(p_i1159_1_, p_i1159_2_, p_i1159_3_, p_i1159_4_, p_i1159_5_);
/*    */   }
/*    */   
/*    */   public IPBanEntry(JsonObject p_i1160_1_) {
/* 17 */     super(func_152647_b(p_i1160_1_), p_i1160_1_);
/*    */   }
/*    */   
/*    */   private static String func_152647_b(JsonObject p_152647_0_) {
/* 21 */     return p_152647_0_.has("ip") ? p_152647_0_.get("ip").getAsString() : null;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_152641_a(JsonObject p_152641_1_) {
/* 26 */     if (func_152640_f() == null) {
/*    */       return;
/*    */     }
/* 29 */     p_152641_1_.addProperty("ip", (String)func_152640_f());
/* 30 */     super.func_152641_a(p_152641_1_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\server\management\IPBanEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */