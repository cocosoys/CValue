/*    */ package net.minecraftforge.event.entity.minecart;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Cancelable;
/*    */ import net.minecraft.entity.item.EntityMinecart;
/*    */ import net.minecraft.entity.player.EntityPlayer;
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
/*    */ public class MinecartInteractEvent
/*    */   extends MinecartEvent
/*    */ {
/*    */   public final EntityPlayer player;
/*    */   
/*    */   public MinecartInteractEvent(EntityMinecart minecart, EntityPlayer player) {
/* 31 */     super(minecart);
/* 32 */     this.player = player;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\entity\minecart\MinecartInteractEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */