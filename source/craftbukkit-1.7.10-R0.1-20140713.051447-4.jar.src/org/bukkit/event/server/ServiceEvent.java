/*    */ package org.bukkit.event.server;
/*    */ 
/*    */ import org.bukkit.plugin.RegisteredServiceProvider;
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class ServiceEvent
/*    */   extends ServerEvent
/*    */ {
/*    */   private final RegisteredServiceProvider<?> provider;
/*    */   
/*    */   public ServiceEvent(RegisteredServiceProvider<?> provider) {
/* 13 */     this.provider = provider;
/*    */   }
/*    */   
/*    */   public RegisteredServiceProvider<?> getProvider() {
/* 17 */     return this.provider;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\event\server\ServiceEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */