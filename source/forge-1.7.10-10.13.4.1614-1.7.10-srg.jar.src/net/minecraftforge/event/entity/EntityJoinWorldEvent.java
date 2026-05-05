/*    */ package net.minecraftforge.event.entity;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Cancelable;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.world.World;
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
/*    */ public class EntityJoinWorldEvent
/*    */   extends EntityEvent
/*    */ {
/*    */   public final World world;
/*    */   
/*    */   public EntityJoinWorldEvent(Entity entity, World world) {
/* 29 */     super(entity);
/* 30 */     this.world = world;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\entity\EntityJoinWorldEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */