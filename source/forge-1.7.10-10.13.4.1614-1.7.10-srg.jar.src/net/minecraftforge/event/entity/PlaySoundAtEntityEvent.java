/*    */ package net.minecraftforge.event.entity;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Cancelable;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Cancelable
/*    */ public class PlaySoundAtEntityEvent
/*    */   extends EntityEvent
/*    */ {
/*    */   public String name;
/*    */   public final float volume;
/*    */   public final float pitch;
/*    */   
/*    */   public PlaySoundAtEntityEvent(Entity entity, String name, float volume, float pitch) {
/* 33 */     super(entity);
/* 34 */     this.name = name;
/* 35 */     this.volume = volume;
/* 36 */     this.pitch = pitch;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\entity\PlaySoundAtEntityEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */