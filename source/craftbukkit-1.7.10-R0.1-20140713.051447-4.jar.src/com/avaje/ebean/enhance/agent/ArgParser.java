/*    */ package com.avaje.ebean.enhance.agent;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ArgParser
/*    */ {
/*    */   public static HashMap<String, String> parse(String args) {
/* 15 */     HashMap<String, String> map = new HashMap<String, String>();
/*    */     
/* 17 */     if (args != null) {
/* 18 */       String[] split = args.split(";");
/* 19 */       for (String nameValuePair : split) {
/* 20 */         String[] nameValue = nameValuePair.split("=");
/* 21 */         if (nameValue.length == 2) {
/* 22 */           map.put(nameValue[0].toLowerCase(), nameValue[1]);
/*    */         }
/*    */       } 
/*    */     } 
/*    */     
/* 27 */     return map;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\enhance\agent\ArgParser.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */