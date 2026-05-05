/*    */ package net.minecraftforge.event.entity.minecart;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.item.EntityMinecart;
/*    */ import net.minecraftforge.event.entity.EntityEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MinecartEvent
/*    */   extends EntityEvent
/*    */ {
/*    */   public final EntityMinecart minecart;
/*    */   
/*    */   public MinecartEvent(EntityMinecart minecart) {
/* 21 */     super((Entity)minecart);
/* 22 */     this.minecart = minecart;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\entity\minecart\MinecartEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */