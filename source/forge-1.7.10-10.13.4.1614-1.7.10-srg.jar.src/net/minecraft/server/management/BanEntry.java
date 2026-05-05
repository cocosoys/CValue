/*    */ package net.minecraft.server.management;
/*    */ 
/*    */ import com.google.gson.JsonObject;
/*    */ import java.text.ParseException;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ 
/*    */ public abstract class BanEntry
/*    */   extends UserListEntry {
/* 10 */   public static final SimpleDateFormat field_73698_a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
/*    */   
/*    */   protected final Date field_73694_d;
/*    */   protected final String field_73695_e;
/*    */   protected final Date field_73692_f;
/*    */   protected final String field_73693_g;
/*    */   private static final String __OBFID = "CL_00001395";
/*    */   
/*    */   public BanEntry(Object p_i1173_1_, Date p_i1173_2_, String p_i1173_3_, Date p_i1173_4_, String p_i1173_5_) {
/* 19 */     super(p_i1173_1_);
/* 20 */     this.field_73694_d = (p_i1173_2_ == null) ? new Date() : p_i1173_2_;
/* 21 */     this.field_73695_e = (p_i1173_3_ == null) ? "(Unknown)" : p_i1173_3_;
/* 22 */     this.field_73692_f = p_i1173_4_;
/* 23 */     this.field_73693_g = (p_i1173_5_ == null) ? "Banned by an operator." : p_i1173_5_;
/*    */   }
/*    */   
/*    */   protected BanEntry(Object p_i1174_1_, JsonObject p_i1174_2_) {
/* 27 */     super(p_i1174_1_, p_i1174_2_);
/*    */     Date date1, date2;
/*    */     try {
/* 30 */       date1 = p_i1174_2_.has("created") ? field_73698_a.parse(p_i1174_2_.get("created").getAsString()) : new Date();
/* 31 */     } catch (ParseException null) {
/* 32 */       date1 = new Date();
/*    */     } 
/* 34 */     this.field_73694_d = date1;
/* 35 */     this.field_73695_e = p_i1174_2_.has("source") ? p_i1174_2_.get("source").getAsString() : "(Unknown)";
/*    */     
/*    */     try {
/* 38 */       date2 = p_i1174_2_.has("expires") ? field_73698_a.parse(p_i1174_2_.get("expires").getAsString()) : null;
/* 39 */     } catch (ParseException parseException) {
/* 40 */       date2 = null;
/*    */     } 
/* 42 */     this.field_73692_f = date2;
/* 43 */     this.field_73693_g = p_i1174_2_.has("reason") ? p_i1174_2_.get("reason").getAsString() : "Banned by an operator.";
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
/*    */   public Date func_73680_d() {
/* 55 */     return this.field_73692_f;
/*    */   }
/*    */   
/*    */   public String func_73686_f() {
/* 59 */     return this.field_73693_g;
/*    */   }
/*    */ 
/*    */   
/*    */   boolean func_73682_e() {
/* 64 */     if (this.field_73692_f == null) {
/* 65 */       return false;
/*    */     }
/* 67 */     return this.field_73692_f.before(new Date());
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_152641_a(JsonObject p_152641_1_) {
/* 72 */     p_152641_1_.addProperty("created", field_73698_a.format(this.field_73694_d));
/* 73 */     p_152641_1_.addProperty("source", this.field_73695_e);
/* 74 */     p_152641_1_.addProperty("expires", (this.field_73692_f == null) ? "forever" : field_73698_a.format(this.field_73692_f));
/* 75 */     p_152641_1_.addProperty("reason", this.field_73693_g);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\server\management\BanEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */