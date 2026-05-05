/*    */ package cpw.mods.fml.common.network.simpleimpl;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import net.minecraft.client.network.NetHandlerPlayClient;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import net.minecraft.network.NetHandlerPlayServer;
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
/*    */ public class MessageContext
/*    */ {
/*    */   public final INetHandler netHandler;
/*    */   public final Side side;
/*    */   
/*    */   MessageContext(INetHandler netHandler, Side side) {
/* 30 */     this.netHandler = netHandler;
/* 31 */     this.side = side;
/*    */   }
/*    */ 
/*    */   
/*    */   public NetHandlerPlayServer getServerHandler() {
/* 36 */     return (NetHandlerPlayServer)this.netHandler;
/*    */   }
/*    */ 
/*    */   
/*    */   public NetHandlerPlayClient getClientHandler() {
/* 41 */     return (NetHandlerPlayClient)this.netHandler;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\network\simpleimpl\MessageContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */