/*    */ package cpw.mods.fml.common.network;
/*    */ 
/*    */ import cpw.mods.fml.common.network.handshake.NetworkDispatcher;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import net.minecraft.network.INetHandler;
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
/*    */ public class NetworkHandshakeEstablished
/*    */ {
/*    */   public final NetworkDispatcher dispatcher;
/*    */   public final Side side;
/*    */   public final INetHandler netHandler;
/*    */   
/*    */   public NetworkHandshakeEstablished(NetworkDispatcher dispatcher, INetHandler netHandler, Side origin) {
/* 24 */     this.netHandler = netHandler;
/* 25 */     this.dispatcher = dispatcher;
/* 26 */     this.side = origin;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\network\NetworkHandshakeEstablished.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */