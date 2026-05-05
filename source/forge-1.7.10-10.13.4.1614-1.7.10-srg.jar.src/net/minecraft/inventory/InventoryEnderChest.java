/*    */ package net.minecraft.inventory;
/*    */ 
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.nbt.NBTBase;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.nbt.NBTTagList;
/*    */ import net.minecraft.tileentity.TileEntityEnderChest;
/*    */ 
/*    */ public class InventoryEnderChest extends InventoryBasic {
/*    */   private TileEntityEnderChest field_70488_a;
/*    */   
/*    */   public InventoryEnderChest() {
/* 14 */     super("container.enderchest", false, 27);
/*    */   }
/*    */   private static final String __OBFID = "CL_00001759";
/*    */   public void func_146031_a(TileEntityEnderChest p_146031_1_) {
/* 18 */     this.field_70488_a = p_146031_1_;
/*    */   }
/*    */   public void func_70486_a(NBTTagList p_70486_1_) {
/*    */     byte b;
/* 22 */     for (b = 0; b < func_70302_i_(); b++) {
/* 23 */       func_70299_a(b, null);
/*    */     }
/* 25 */     for (b = 0; b < p_70486_1_.func_74745_c(); b++) {
/* 26 */       NBTTagCompound nBTTagCompound = p_70486_1_.func_150305_b(b);
/* 27 */       int i = nBTTagCompound.func_74771_c("Slot") & 0xFF;
/* 28 */       if (i >= 0 && i < func_70302_i_()) func_70299_a(i, ItemStack.func_77949_a(nBTTagCompound)); 
/*    */     } 
/*    */   }
/*    */   
/*    */   public NBTTagList func_70487_g() {
/* 33 */     NBTTagList nBTTagList = new NBTTagList();
/* 34 */     for (byte b = 0; b < func_70302_i_(); b++) {
/* 35 */       ItemStack itemStack = func_70301_a(b);
/* 36 */       if (itemStack != null) {
/* 37 */         NBTTagCompound nBTTagCompound = new NBTTagCompound();
/* 38 */         nBTTagCompound.func_74774_a("Slot", (byte)b);
/* 39 */         itemStack.func_77955_b(nBTTagCompound);
/* 40 */         nBTTagList.func_74742_a((NBTBase)nBTTagCompound);
/*    */       } 
/*    */     } 
/* 43 */     return nBTTagList;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_70300_a(EntityPlayer p_70300_1_) {
/* 48 */     if (this.field_70488_a != null && !this.field_70488_a.func_145971_a(p_70300_1_)) {
/* 49 */       return false;
/*    */     }
/* 51 */     return super.func_70300_a(p_70300_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70295_k_() {
/* 56 */     if (this.field_70488_a != null) {
/* 57 */       this.field_70488_a.func_145969_a();
/*    */     }
/* 59 */     super.func_70295_k_();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70305_f() {
/* 64 */     if (this.field_70488_a != null) {
/* 65 */       this.field_70488_a.func_145970_b();
/*    */     }
/* 67 */     super.func_70305_f();
/* 68 */     this.field_70488_a = null;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\inventory\InventoryEnderChest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */