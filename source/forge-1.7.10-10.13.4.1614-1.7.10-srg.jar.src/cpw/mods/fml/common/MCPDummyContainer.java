/*    */ package cpw.mods.fml.common;
/*    */ 
/*    */ import com.google.common.eventbus.EventBus;
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
/*    */ public class MCPDummyContainer
/*    */   extends DummyModContainer
/*    */ {
/*    */   public MCPDummyContainer(ModMetadata metadata) {
/* 19 */     super(metadata);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean registerBus(EventBus bus, LoadController controller) {
/* 24 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ModContainer.Disableable canBeDisabled() {
/* 30 */     return ModContainer.Disableable.YES;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\MCPDummyContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */