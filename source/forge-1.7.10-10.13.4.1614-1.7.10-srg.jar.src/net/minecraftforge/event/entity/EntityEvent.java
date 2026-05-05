/*    */ package net.minecraftforge.event.entity;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Event;
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
/*    */ public class EntityEvent
/*    */   extends Event
/*    */ {
/*    */   public final Entity entity;
/*    */   
/*    */   public EntityEvent(Entity entity) {
/* 21 */     this.entity = entity;
/*    */   }
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
/*    */   public static class EntityConstructing
/*    */     extends EntityEvent
/*    */   {
/*    */     public EntityConstructing(Entity entity) {
/* 38 */       super(entity);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static class CanUpdate
/*    */     extends EntityEvent
/*    */   {
/*    */     public boolean canUpdate = false;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public CanUpdate(Entity entity) {
/* 60 */       super(entity);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static class EnteringChunk
/*    */     extends EntityEvent
/*    */   {
/*    */     public int newChunkX;
/*    */ 
/*    */     
/*    */     public int newChunkZ;
/*    */ 
/*    */     
/*    */     public int oldChunkX;
/*    */ 
/*    */     
/*    */     public int oldChunkZ;
/*    */ 
/*    */ 
/*    */     
/*    */     public EnteringChunk(Entity entity, int newChunkX, int newChunkZ, int oldChunkX, int oldChunkZ) {
/* 84 */       super(entity);
/* 85 */       this.newChunkX = newChunkX;
/* 86 */       this.newChunkZ = newChunkZ;
/* 87 */       this.oldChunkX = oldChunkX;
/* 88 */       this.oldChunkZ = oldChunkZ;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\entity\EntityEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */