/*    */ package cpw.mods.fml.common.gameevent;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ public class TickEvent extends Event {
/*    */   public final Type type;
/*    */   public final Side side;
/*    */   public final Phase phase;
/*    */   
/*    */   public enum Type {
/* 11 */     WORLD, PLAYER, CLIENT, SERVER, RENDER;
/*    */   }
/*    */   
/*    */   public enum Phase {
/* 15 */     START, END;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public TickEvent(Type type, Side side, Phase phase) {
/* 22 */     this.type = type;
/* 23 */     this.side = side;
/* 24 */     this.phase = phase;
/*    */   }
/*    */   
/*    */   public static class ServerTickEvent
/*    */     extends TickEvent {
/*    */     public ServerTickEvent(TickEvent.Phase phase) {
/* 30 */       super(TickEvent.Type.SERVER, Side.SERVER, phase);
/*    */     }
/*    */   }
/*    */   
/*    */   public static class ClientTickEvent
/*    */     extends TickEvent {
/*    */     public ClientTickEvent(TickEvent.Phase phase) {
/* 37 */       super(TickEvent.Type.CLIENT, Side.CLIENT, phase);
/*    */     }
/*    */   }
/*    */   
/*    */   public static class WorldTickEvent extends TickEvent {
/*    */     public final World world;
/*    */     
/*    */     public WorldTickEvent(Side side, TickEvent.Phase phase, World world) {
/* 45 */       super(TickEvent.Type.WORLD, side, phase);
/* 46 */       this.world = world;
/*    */     }
/*    */   }
/*    */   
/*    */   public static class PlayerTickEvent extends TickEvent {
/*    */     public final EntityPlayer player;
/*    */     
/*    */     public PlayerTickEvent(TickEvent.Phase phase, EntityPlayer player) {
/* 54 */       super(TickEvent.Type.PLAYER, (player instanceof net.minecraft.entity.player.EntityPlayerMP) ? Side.SERVER : Side.CLIENT, phase);
/* 55 */       this.player = player;
/*    */     }
/*    */   }
/*    */   
/*    */   public static class RenderTickEvent extends TickEvent {
/*    */     public final float renderTickTime;
/*    */     
/*    */     public RenderTickEvent(TickEvent.Phase phase, float renderTickTime) {
/* 63 */       super(TickEvent.Type.RENDER, Side.CLIENT, phase);
/* 64 */       this.renderTickTime = renderTickTime;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\gameevent\TickEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */