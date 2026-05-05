/*    */ package net.minecraftforge.event.entity.living;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Event.HasResult;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.monster.EntityZombie;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.event.entity.EntityEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ZombieEvent
/*    */   extends EntityEvent
/*    */ {
/*    */   public ZombieEvent(EntityZombie entity) {
/* 20 */     super((Entity)entity);
/*    */   }
/*    */ 
/*    */   
/*    */   public EntityZombie getSummoner() {
/* 25 */     return (EntityZombie)this.entity;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @HasResult
/*    */   public static class SummonAidEvent
/*    */     extends ZombieEvent
/*    */   {
/*    */     public EntityZombie customSummonedAid;
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public final World world;
/*    */ 
/*    */ 
/*    */     
/*    */     public final int x;
/*    */ 
/*    */ 
/*    */     
/*    */     public final int y;
/*    */ 
/*    */ 
/*    */     
/*    */     public final int z;
/*    */ 
/*    */ 
/*    */     
/*    */     public final EntityLivingBase attacker;
/*    */ 
/*    */ 
/*    */     
/*    */     public final double summonChance;
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public SummonAidEvent(EntityZombie entity, World world, int x, int y, int z, EntityLivingBase attacker, double summonChance) {
/* 67 */       super(entity);
/* 68 */       this.world = world;
/* 69 */       this.x = x;
/* 70 */       this.y = y;
/* 71 */       this.z = z;
/* 72 */       this.attacker = attacker;
/* 73 */       this.summonChance = summonChance;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\entity\living\ZombieEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */