/*    */ package net.minecraftforge.event.entity.player;
/*    */ 
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AnvilRepairEvent
/*    */   extends PlayerEvent
/*    */ {
/*    */   public final ItemStack left;
/*    */   public final ItemStack right;
/*    */   public final ItemStack output;
/*    */   public float breakChance;
/*    */   
/*    */   public AnvilRepairEvent(EntityPlayer player, ItemStack output, ItemStack left, ItemStack right) {
/* 23 */     super(player);
/* 24 */     this.output = output;
/* 25 */     this.left = left;
/* 26 */     this.right = right;
/* 27 */     this.breakChance = 0.12F;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\entity\player\AnvilRepairEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */