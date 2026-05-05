/*    */ package JinRyuu.JRMCore.i;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.inventory.IInventory;
/*    */ import net.minecraft.inventory.Slot;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ 
/*    */ public class SlotArmor
/*    */   extends Slot
/*    */ {
/*    */   final int armorType;
/*    */   final EntityPlayer player;
/*    */   
/*    */   public SlotArmor(EntityPlayer player, IInventory inventory, int slot, int x, int y, int armorType) {
/* 21 */     super(inventory, slot, x, y);
/* 22 */     this.player = player;
/* 23 */     this.armorType = armorType;
/*    */   }
/*    */   
/*    */   public int func_75219_a() {
/* 27 */     return 1;
/*    */   }
/*    */   
/*    */   public boolean func_75214_a(ItemStack stack) {
/* 31 */     Item item = (stack == null) ? null : stack.func_77973_b();
/* 32 */     return (item != null && item.isValidArmor(stack, this.armorType, (Entity)this.player));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void setBackgroundIconTexture(ResourceLocation texture) {
/* 41 */     this.texture = texture;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\i\SlotArmor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */