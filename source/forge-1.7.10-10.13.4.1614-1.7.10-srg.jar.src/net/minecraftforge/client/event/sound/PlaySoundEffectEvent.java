/*    */ package net.minecraftforge.client.event.sound;
/*    */ 
/*    */ import net.minecraft.client.audio.SoundManager;
/*    */ import net.minecraft.client.audio.SoundPoolEntry;
/*    */ 
/*    */ @Deprecated
/*    */ public class PlaySoundEffectEvent
/*    */   extends SoundResultEvent {
/*    */   public PlaySoundEffectEvent(SoundManager manager, SoundPoolEntry source, String name, float volume, float pitch) {
/* 10 */     super(manager, source, name, volume, pitch);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\client\event\sound\PlaySoundEffectEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */