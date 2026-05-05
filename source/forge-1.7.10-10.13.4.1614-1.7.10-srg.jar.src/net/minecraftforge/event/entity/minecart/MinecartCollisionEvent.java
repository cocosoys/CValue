/*    */ package net.minecraftforge.event.entity.minecart;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.item.EntityMinecart;
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
/*    */ public class MinecartCollisionEvent
/*    */   extends MinecartEvent
/*    */ {
/*    */   public final Entity collider;
/*    */   
/*    */   public MinecartCollisionEvent(EntityMinecart minecart, Entity collider) {
/* 25 */     super(minecart);
/* 26 */     this.collider = collider;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\entity\minecart\MinecartCollisionEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */