/*    */ package net.minecraftforge.event.entity.minecart;
/*    */ 
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
/*    */ 
/*    */ 
/*    */ public class MinecartUpdateEvent
/*    */   extends MinecartEvent
/*    */ {
/*    */   public final float x;
/*    */   public final float y;
/*    */   public final float z;
/*    */   
/*    */   public MinecartUpdateEvent(EntityMinecart minecart, float x, float y, float z) {
/* 28 */     super(minecart);
/* 29 */     this.x = x;
/* 30 */     this.y = y;
/* 31 */     this.z = z;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\entity\minecart\MinecartUpdateEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */