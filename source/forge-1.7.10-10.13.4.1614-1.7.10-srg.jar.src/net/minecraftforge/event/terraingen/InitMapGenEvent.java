/*    */ package net.minecraftforge.event.terraingen;
/*    */ import net.minecraft.world.gen.MapGenBase;
/*    */ 
/*    */ public class InitMapGenEvent extends Event {
/*    */   public final EventType type;
/*    */   public final MapGenBase originalGen;
/*    */   public MapGenBase newGen;
/*    */   
/*    */   public enum EventType {
/* 10 */     CAVE, MINESHAFT, NETHER_BRIDGE, NETHER_CAVE, RAVINE, SCATTERED_FEATURE, STRONGHOLD, VILLAGE, CUSTOM;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   InitMapGenEvent(EventType type, MapGenBase original) {
/* 18 */     this.type = type;
/* 19 */     this.originalGen = original;
/* 20 */     this.newGen = original;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\terraingen\InitMapGenEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */