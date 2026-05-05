/*     */ package JinRyuu.DragonBC.common.Render;
/*     */ 
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ 
/*     */ 
/*     */ public class SpacePod01TileEntity
/*     */   extends TileEntity
/*     */   implements IInventory
/*     */ {
/*  13 */   private ItemStack[] inventory = new ItemStack[27];
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70302_i_() {
/*  18 */     return this.inventory.length;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_70301_a(int slotIndex) {
/*  23 */     return this.inventory[slotIndex];
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70299_a(int slot, ItemStack stack) {
/*  28 */     this.inventory[slot] = stack;
/*     */     
/*  30 */     if (stack != null && stack.field_77994_a > func_70297_j_()) {
/*  31 */       stack.field_77994_a = func_70297_j_();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70298_a(int slotIndex, int amount) {
/*  39 */     ItemStack stack = func_70301_a(slotIndex);
/*     */ 
/*     */     
/*  42 */     if (stack != null)
/*     */     {
/*  44 */       if (stack.field_77994_a <= amount) {
/*  45 */         func_70299_a(slotIndex, (ItemStack)null);
/*     */       } else {
/*     */         
/*  48 */         stack = stack.func_77979_a(amount);
/*  49 */         if (stack.field_77994_a == 0) {
/*  50 */           func_70299_a(slotIndex, (ItemStack)null);
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*  56 */     return stack;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70304_b(int slotIndex) {
/*  63 */     ItemStack stack = func_70301_a(slotIndex);
/*     */ 
/*     */     
/*  66 */     if (stack != null) {
/*  67 */       func_70299_a(slotIndex, (ItemStack)null);
/*     */     }
/*     */ 
/*     */     
/*  71 */     return stack;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70297_j_() {
/*  77 */     return 64;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70300_a(EntityPlayer player) {
/*  83 */     return (this.field_145850_b.func_147438_o(this.field_145851_c, this.field_145848_d, this.field_145849_e) == this && player.func_70092_e(this.field_145851_c + 0.5D, this.field_145848_d + 0.5D, this.field_145849_e + 0.5D) < 64.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isStackValidForSlot(int i, ItemStack itemstack) {
/* 146 */     return false;
/*     */   }
/*     */   public boolean func_94041_b(int i, ItemStack itemstack) {
/* 149 */     return false;
/*     */   } public boolean canUpdate() {
/* 151 */     return false;
/*     */   }
/*     */   public String func_145825_b() {
/* 154 */     return null;
/*     */   }
/*     */   public boolean func_145818_k_() {
/* 157 */     return false;
/*     */   }
/*     */   
/*     */   public void func_70295_k_() {}
/*     */   
/*     */   public void func_70305_f() {}
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Render\SpacePod01TileEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */