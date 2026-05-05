/*    */ package net.minecraftforge.client.event.sound;
/*    */ 
/*    */ import net.minecraft.client.audio.SoundManager;
/*    */ import net.minecraft.client.audio.SoundPoolEntry;
/*    */ 
/*    */ @Deprecated
/*    */ public abstract class SoundResultEvent
/*    */   extends SoundEvent
/*    */ {
/*    */   public final SoundManager manager;
/*    */   public final SoundPoolEntry source;
/*    */   public final String name;
/*    */   public final float volume;
/*    */   public final float pitch;
/*    */   public SoundPoolEntry result;
/*    */   
/*    */   public SoundResultEvent(SoundManager manager, SoundPoolEntry source, String name, float volume, float pitch) {
/* 18 */     super(manager);
/* 19 */     this.manager = manager;
/* 20 */     this.source = source;
/* 21 */     this.name = name;
/* 22 */     this.volume = volume;
/* 23 */     this.pitch = pitch;
/* 24 */     this.result = source;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\client\event\sound\SoundResultEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */