/*    */ package net.minecraftforge.client.event.sound;
/*    */ 
/*    */ import net.minecraft.client.audio.SoundManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SoundSetupEvent
/*    */   extends SoundEvent
/*    */ {
/*    */   @Deprecated
/*    */   public final SoundManager manager;
/*    */   
/*    */   public SoundSetupEvent(SoundManager manager) {
/* 15 */     super(manager);
/* 16 */     this.manager = manager;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\client\event\sound\SoundSetupEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */