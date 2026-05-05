/*    */ package net.minecraftforge.client.event.sound;
/*    */ 
/*    */ import net.minecraft.client.audio.SoundManager;
/*    */ import net.minecraft.client.audio.SoundPoolEntry;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Deprecated
/*    */ public class PlayBackgroundMusicEvent
/*    */   extends SoundResultEvent
/*    */ {
/*    */   public PlayBackgroundMusicEvent(SoundManager manager, SoundPoolEntry entry) {
/* 15 */     super(manager, entry, null, 0.0F, 0.0F);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\client\event\sound\PlayBackgroundMusicEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */