/*    */ package cpw.mods.fml.common.event;
/*    */ 
/*    */ import cpw.mods.fml.common.LoaderState;
/*    */ import net.minecraft.command.CommandHandler;
/*    */ import net.minecraft.command.ICommand;
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
/*    */ 
/*    */ public class FMLServerStartingEvent
/*    */   extends FMLStateEvent
/*    */ {
/*    */   private MinecraftServer server;
/*    */   
/*    */   public FMLServerStartingEvent(Object... data) {
/* 27 */     super(data);
/* 28 */     this.server = (MinecraftServer)data[0];
/*    */   }
/*    */ 
/*    */   
/*    */   public LoaderState.ModState getModState() {
/* 33 */     return LoaderState.ModState.AVAILABLE;
/*    */   }
/*    */ 
/*    */   
/*    */   public MinecraftServer getServer() {
/* 38 */     return this.server;
/*    */   }
/*    */ 
/*    */   
/*    */   public void registerServerCommand(ICommand command) {
/* 43 */     CommandHandler ch = (CommandHandler)getServer().getCommandManager();
/* 44 */     ch.registerCommand(command);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\event\FMLServerStartingEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */