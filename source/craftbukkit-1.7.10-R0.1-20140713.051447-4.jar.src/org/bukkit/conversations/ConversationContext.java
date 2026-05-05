/*    */ package org.bukkit.conversations;
/*    */ 
/*    */ import java.util.Map;
/*    */ import org.bukkit.plugin.Plugin;
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
/*    */ public class ConversationContext
/*    */ {
/*    */   private Conversable forWhom;
/*    */   private Map<Object, Object> sessionData;
/*    */   private Plugin plugin;
/*    */   
/*    */   public ConversationContext(Plugin plugin, Conversable forWhom, Map<Object, Object> initialSessionData) {
/* 25 */     this.plugin = plugin;
/* 26 */     this.forWhom = forWhom;
/* 27 */     this.sessionData = initialSessionData;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Plugin getPlugin() {
/* 36 */     return this.plugin;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Conversable getForWhom() {
/* 45 */     return this.forWhom;
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
/*    */   public Object getSessionData(Object key) {
/* 57 */     return this.sessionData.get(key);
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
/*    */   public void setSessionData(Object key, Object value) {
/* 69 */     this.sessionData.put(key, value);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\conversations\ConversationContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */