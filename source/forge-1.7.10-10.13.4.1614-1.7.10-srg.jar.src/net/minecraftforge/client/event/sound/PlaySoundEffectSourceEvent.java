/*    */ package net.minecraftforge.client.event.sound;
/*    */ 
/*    */ import net.minecraft.client.audio.SoundManager;
/*    */ 
/*    */ @Deprecated
/*    */ public class PlaySoundEffectSourceEvent
/*    */   extends SoundEvent {
/*    */   public final SoundManager manager;
/*    */   public final String name;
/*    */   
/*    */   public PlaySoundEffectSourceEvent(SoundManager manager, String name) {
/* 12 */     super(manager);
/* 13 */     this.manager = manager;
/* 14 */     this.name = name;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\client\event\sound\PlaySoundEffectSourceEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */