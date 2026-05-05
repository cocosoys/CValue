/*    */ package com.avaje.ebeaninternal.server.core;
/*    */ 
/*    */ import com.avaje.ebean.config.ServerConfig;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ConfigBuilder
/*    */ {
/*    */   public ServerConfig build(String serverName) {
/* 16 */     ServerConfig config = new ServerConfig();
/* 17 */     config.setName(serverName);
/*    */     
/* 19 */     config.loadFromProperties();
/*    */     
/* 21 */     return config;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\core\ConfigBuilder.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */