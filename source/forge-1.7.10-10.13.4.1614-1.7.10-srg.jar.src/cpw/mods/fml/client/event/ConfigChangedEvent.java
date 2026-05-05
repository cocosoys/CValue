/*    */ package cpw.mods.fml.client.event;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Event;
/*    */ import cpw.mods.fml.common.eventhandler.Event.HasResult;
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
/*    */ @HasResult
/*    */ public class ConfigChangedEvent
/*    */   extends Event
/*    */ {
/*    */   public final String modID;
/*    */   public final boolean isWorldRunning;
/*    */   public final boolean requiresMcRestart;
/*    */   public final String configID;
/*    */   
/*    */   public ConfigChangedEvent(String modID, String configID, boolean isWorldRunning, boolean requiresMcRestart) {
/* 51 */     this.modID = modID;
/* 52 */     this.configID = configID;
/* 53 */     this.isWorldRunning = isWorldRunning;
/* 54 */     this.requiresMcRestart = requiresMcRestart;
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
/*    */   
/*    */   public static class OnConfigChangedEvent
/*    */     extends ConfigChangedEvent
/*    */   {
/*    */     public OnConfigChangedEvent(String modID, String configID, boolean isWorldRunning, boolean requiresMcRestart) {
/* 70 */       super(modID, configID, isWorldRunning, requiresMcRestart);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static class PostConfigChangedEvent
/*    */     extends ConfigChangedEvent
/*    */   {
/*    */     public PostConfigChangedEvent(String modID, String configID, boolean isWorldRunning, boolean requiresMcRestart) {
/* 82 */       super(modID, configID, isWorldRunning, requiresMcRestart);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\client\event\ConfigChangedEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */