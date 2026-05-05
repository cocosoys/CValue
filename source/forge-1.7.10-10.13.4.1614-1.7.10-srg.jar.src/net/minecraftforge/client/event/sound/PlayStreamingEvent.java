/*    */ package net.minecraftforge.client.event.sound;
/*    */ 
/*    */ import net.minecraft.client.audio.SoundManager;
/*    */ import net.minecraft.client.audio.SoundPoolEntry;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Deprecated
/*    */ public class PlayStreamingEvent
/*    */   extends SoundResultEvent
/*    */ {
/*    */   public final float x;
/*    */   public final float y;
/*    */   public final float z;
/*    */   
/*    */   public PlayStreamingEvent(SoundManager manager, SoundPoolEntry source, String name, float x, float y, float z) {
/* 22 */     super(manager, source, name, 0.0F, 0.0F);
/* 23 */     this.x = x;
/* 24 */     this.y = y;
/* 25 */     this.z = z;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\client\event\sound\PlayStreamingEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */