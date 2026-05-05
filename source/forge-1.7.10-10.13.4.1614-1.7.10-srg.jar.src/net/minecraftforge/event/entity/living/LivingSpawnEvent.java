/*    */ package net.minecraftforge.event.entity.living;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Cancelable;
/*    */ import cpw.mods.fml.common.eventhandler.Event.HasResult;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.EntityLivingBase;
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
/*    */ public class LivingSpawnEvent
/*    */   extends LivingEvent
/*    */ {
/*    */   public final World world;
/*    */   public final float x;
/*    */   public final float y;
/*    */   public final float z;
/*    */   
/*    */   public LivingSpawnEvent(EntityLiving entity, World world, float x, float y, float z) {
/* 29 */     super((EntityLivingBase)entity);
/* 30 */     this.world = world;
/* 31 */     this.x = x;
/* 32 */     this.y = y;
/* 33 */     this.z = z;
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
/*    */   @HasResult
/*    */   public static class CheckSpawn
/*    */     extends LivingSpawnEvent
/*    */   {
/*    */     public CheckSpawn(EntityLiving entity, World world, float x, float y, float z) {
/* 50 */       super(entity, world, x, y, z);
/*    */     }
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
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Cancelable
/*    */   public static class SpecialSpawn
/*    */     extends LivingSpawnEvent
/*    */   {
/*    */     public SpecialSpawn(EntityLiving entity, World world, float x, float y, float z) {
/* 73 */       super(entity, world, x, y, z);
/*    */     }
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
/*    */ 
/*    */ 
/*    */   
/*    */   @HasResult
/*    */   public static class AllowDespawn
/*    */     extends LivingSpawnEvent
/*    */   {
/*    */     public AllowDespawn(EntityLiving entity) {
/* 95 */       super(entity, entity.worldObj, (float)entity.posX, (float)entity.posY, (float)entity.posZ);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\entity\living\LivingSpawnEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */