/*    */ package com.avaje.ebeaninternal.server.text.json;
/*    */ 
/*    */ import com.avaje.ebean.text.json.JsonValueAdapter;
/*    */ import java.sql.Date;
/*    */ import java.sql.Timestamp;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DefaultJsonValueAdapter
/*    */   implements JsonValueAdapter
/*    */ {
/*    */   private final SimpleDateFormat dateTimeProto;
/*    */   
/*    */   public DefaultJsonValueAdapter(String dateTimeFormat) {
/* 33 */     this.dateTimeProto = new SimpleDateFormat(dateTimeFormat);
/*    */   }
/*    */   
/*    */   public DefaultJsonValueAdapter() {
/* 37 */     this("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
/*    */   }
/*    */   
/*    */   private SimpleDateFormat dtFormat() {
/* 41 */     return (SimpleDateFormat)this.dateTimeProto.clone();
/*    */   }
/*    */   
/*    */   public String jsonFromDate(Date date) {
/* 45 */     return date.toString();
/*    */   }
/*    */   
/*    */   public String jsonFromTimestamp(Timestamp date) {
/* 49 */     return dtFormat().format(date);
/*    */   }
/*    */   
/*    */   public Date jsonToDate(String jsonDate) {
/* 53 */     return Date.valueOf(jsonDate);
/*    */   }
/*    */   
/*    */   public Timestamp jsonToTimestamp(String jsonDateTime) {
/*    */     try {
/* 58 */       Date d = dtFormat().parse(jsonDateTime);
/* 59 */       return new Timestamp(d.getTime());
/* 60 */     } catch (Exception e) {
/* 61 */       String m = "Error parsing Datetime[" + jsonDateTime + "]";
/* 62 */       throw new RuntimeException(m, e);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\text\json\DefaultJsonValueAdapter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */