/*    */ package cpw.mods.fml.common.event;
/*    */ 
/*    */ import cpw.mods.fml.common.LoaderState;
/*    */ import net.minecraft.server.MinecraftServer;
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
/*    */ public class FMLServerAboutToStartEvent
/*    */   extends FMLStateEvent
/*    */ {
/*    */   private MinecraftServer server;
/*    */   
/*    */   public FMLServerAboutToStartEvent(Object... data) {
/* 24 */     super(data);
/* 25 */     this.server = (MinecraftServer)data[0];
/*    */   }
/*    */ 
/*    */   
/*    */   public LoaderState.ModState getModState() {
/* 30 */     return LoaderState.ModState.AVAILABLE;
/*    */   }
/*    */ 
/*    */   
/*    */   public MinecraftServer getServer() {
/* 35 */     return this.server;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\event\FMLServerAboutToStartEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */