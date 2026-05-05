/*    */ package net.minecraftforge.client.event.sound;
/*    */ 
/*    */ import net.minecraft.client.audio.ISound;
/*    */ import net.minecraft.client.audio.SoundCategory;
/*    */ import net.minecraft.client.audio.SoundManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PlaySoundEvent17
/*    */   extends SoundEvent
/*    */ {
/*    */   public final String name;
/*    */   public final ISound sound;
/*    */   public final SoundCategory category;
/*    */   public ISound result;
/*    */   
/*    */   public PlaySoundEvent17(SoundManager manager, ISound sound, SoundCategory category) {
/* 24 */     super(manager);
/* 25 */     this.sound = sound;
/* 26 */     this.category = category;
/* 27 */     this.name = sound.getPositionedSoundLocation().getResourcePath();
/* 28 */     this.result = sound;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\client\event\sound\PlaySoundEvent17.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */