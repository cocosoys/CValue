/*    */ package cpw.mods.fml.common.event;
/*    */ 
/*    */ import cpw.mods.fml.common.LoaderState;
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
/*    */ public class FMLServerStartedEvent
/*    */   extends FMLStateEvent
/*    */ {
/*    */   public FMLServerStartedEvent(Object... data) {
/* 22 */     super(data);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public LoaderState.ModState getModState() {
/* 28 */     return LoaderState.ModState.AVAILABLE;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\event\FMLServerStartedEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */