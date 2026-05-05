/*    */ package net.minecraftforge.client.event.sound;
/*    */ 
/*    */ import net.minecraft.client.audio.ISound;
/*    */ import net.minecraft.client.audio.SoundManager;
/*    */ 
/*    */ 
/*    */ public class PlaySoundSourceEvent
/*    */   extends SoundEvent.SoundSourceEvent
/*    */ {
/*    */   @Deprecated
/*    */   public final SoundManager manager;
/*    */   @Deprecated
/*    */   public final String name;
/*    */   @Deprecated
/*    */   public final float x;
/*    */   @Deprecated
/*    */   public final float y;
/*    */   @Deprecated
/*    */   public final float z;
/*    */   
/*    */   @Deprecated
/*    */   public PlaySoundSourceEvent(SoundManager manager, String name, float x, float y, float z) {
/* 23 */     super(manager, null, null);
/* 24 */     this.manager = manager;
/* 25 */     this.name = name;
/* 26 */     this.x = x;
/* 27 */     this.y = y;
/* 28 */     this.z = z;
/*    */   }
/*    */ 
/*    */   
/*    */   public PlaySoundSourceEvent(SoundManager manager, ISound sound, String uuid) {
/* 33 */     super(manager, sound, uuid);
/* 34 */     this.name = sound.getPositionedSoundLocation().getResourcePath();
/* 35 */     this.manager = manager;
/* 36 */     this.x = this.y = this.z = 0.0F;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\client\event\sound\PlaySoundSourceEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */