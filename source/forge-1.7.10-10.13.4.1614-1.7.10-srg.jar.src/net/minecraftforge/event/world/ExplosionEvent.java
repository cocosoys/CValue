/*    */ package net.minecraftforge.event.world;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Cancelable;
/*    */ import cpw.mods.fml.common.eventhandler.Event;
/*    */ import java.util.List;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.world.ChunkPosition;
/*    */ import net.minecraft.world.Explosion;
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
/*    */ public class ExplosionEvent
/*    */   extends Event
/*    */ {
/*    */   public final World world;
/*    */   public final Explosion explosion;
/*    */   
/*    */   public ExplosionEvent(World world, Explosion explosion) {
/* 29 */     this.world = world;
/* 30 */     this.explosion = explosion;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Cancelable
/*    */   public static class Start
/*    */     extends ExplosionEvent
/*    */   {
/*    */     public Start(World world, Explosion explosion) {
/* 44 */       super(world, explosion);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static class Detonate
/*    */     extends ExplosionEvent
/*    */   {
/*    */     private final List<Entity> entityList;
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public Detonate(World world, Explosion explosion, List<Entity> entityList) {
/* 60 */       super(world, explosion);
/* 61 */       this.entityList = entityList;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public List<ChunkPosition> getAffectedBlocks() {
/* 67 */       return this.explosion.affectedBlockPositions;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public List<Entity> getAffectedEntities() {
/* 73 */       return this.entityList;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\world\ExplosionEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */