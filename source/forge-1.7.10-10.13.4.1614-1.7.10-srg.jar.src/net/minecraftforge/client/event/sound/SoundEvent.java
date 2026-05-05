/*    */ package net.minecraftforge.client.event.sound;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Event;
/*    */ import net.minecraft.client.audio.ISound;
/*    */ import net.minecraft.client.audio.SoundManager;
/*    */ import net.minecraft.client.audio.SoundPoolEntry;
/*    */ import net.minecraftforge.common.MinecraftForge;
/*    */ 
/*    */ public class SoundEvent
/*    */   extends Event {
/*    */   public final SoundManager manager;
/*    */   
/*    */   public SoundEvent(SoundManager manager) {
/* 14 */     this.manager = manager;
/*    */   }
/*    */ 
/*    */   
/*    */   @Deprecated
/*    */   public static SoundPoolEntry getResult(SoundResultEvent event) {
/* 20 */     MinecraftForge.EVENT_BUS.post(event);
/* 21 */     return event.result;
/*    */   }
/*    */   
/*    */   public static class SoundSourceEvent
/*    */     extends SoundEvent
/*    */   {
/*    */     public final ISound sound;
/*    */     public final String uuid;
/*    */     public final String name;
/*    */     
/*    */     public SoundSourceEvent(SoundManager manager, ISound sound, String uuid) {
/* 32 */       super(manager);
/* 33 */       this.name = sound.getPositionedSoundLocation().getResourcePath();
/* 34 */       this.sound = sound;
/* 35 */       this.uuid = uuid;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\client\event\sound\SoundEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */