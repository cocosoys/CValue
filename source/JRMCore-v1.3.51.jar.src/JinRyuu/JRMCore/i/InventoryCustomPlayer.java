/*     */ package JinRyuu.JRMCore.i;
/*     */ 
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ 
/*     */ 
/*     */ public class InventoryCustomPlayer
/*     */   implements IInventory
/*     */ {
/*  14 */   private final String name = "ExtraSlots";
/*     */ 
/*     */   
/*  17 */   private final String tagName = "dbcExtraInvTag";
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int INV_SIZE = 11;
/*     */ 
/*     */ 
/*     */   
/*  25 */   private ItemStack[] inventory = new ItemStack[11];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void copy(InventoryCustomPlayer inv) {
/*  33 */     for (int i = 0; i < inv.func_70302_i_(); i++) {
/*  34 */       ItemStack stack = inv.func_70301_a(i);
/*  35 */       this.inventory[i] = (stack == null) ? null : stack.func_77946_l();
/*     */     } 
/*  37 */     func_70296_d();
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_70302_i_() {
/*  42 */     return this.inventory.length;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_70301_a(int slot) {
/*  47 */     return this.inventory[slot];
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_70298_a(int slot, int amount) {
/*  52 */     ItemStack stack = func_70301_a(slot);
/*  53 */     if (stack != null) {
/*  54 */       if (stack.field_77994_a > amount) {
/*     */         
/*  56 */         stack = stack.func_77979_a(amount);
/*  57 */         func_70296_d();
/*     */       } else {
/*  59 */         func_70299_a(slot, null);
/*     */       } 
/*     */     }
/*     */     
/*  63 */     return stack;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_70304_b(int slot) {
/*  68 */     ItemStack stack = func_70301_a(slot);
/*  69 */     func_70299_a(slot, null);
/*  70 */     return stack;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70299_a(int slot, ItemStack stack) {
/*  75 */     this.inventory[slot] = stack;
/*  76 */     if (stack != null && stack.field_77994_a > func_70297_j_()) {
/*  77 */       stack.field_77994_a = func_70297_j_();
/*     */     }
/*  79 */     func_70296_d();
/*     */   }
/*     */   
/*     */   public String func_145825_b() {
/*  83 */     return "ExtraSlots";
/*     */   }
/*     */   public boolean func_145818_k_() {
/*  86 */     return ("ExtraSlots".length() > 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70297_j_() {
/*  97 */     return 1;
/*     */   }
/*     */   
/*     */   public void func_70296_d() {
/* 101 */     for (int i = 0; i < func_70302_i_(); i++) {
/* 102 */       if (func_70301_a(i) != null && (func_70301_a(i)).field_77994_a == 0)
/* 103 */         this.inventory[i] = null; 
/*     */     } 
/*     */   }
/*     */   public boolean func_70300_a(EntityPlayer player) {
/* 107 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70295_k_() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70305_f() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_94041_b(int slot, ItemStack stack) {
/* 126 */     return stack.func_77973_b() instanceof net.minecraft.item.ItemSign;
/*     */   }
/*     */   
/*     */   public void writeToNBT(NBTTagCompound compound) {
/* 130 */     NBTTagList items = new NBTTagList();
/* 131 */     for (int i = 0; i < func_70302_i_(); i++) {
/* 132 */       if (func_70301_a(i) != null) {
/* 133 */         NBTTagCompound item = new NBTTagCompound();
/* 134 */         item.func_74774_a("Slot", (byte)i);
/* 135 */         func_70301_a(i).func_77955_b(item);
/* 136 */         items.func_74742_a((NBTBase)item);
/*     */       } 
/*     */     } 
/*     */     
/* 140 */     compound.func_74782_a("dbcExtraInvTag", (NBTBase)items);
/*     */   }
/*     */   
/*     */   public void readFromNBT(NBTTagCompound compound) {
/* 144 */     NBTTagList items = compound.func_150295_c("dbcExtraInvTag", compound.func_74732_a());
/* 145 */     for (int i = 0; i < items.func_74745_c(); i++) {
/* 146 */       NBTTagCompound item = items.func_150305_b(i);
/* 147 */       byte slot = item.func_74771_c("Slot");
/* 148 */       if (slot >= 0 && slot < func_70302_i_())
/* 149 */         this.inventory[slot] = ItemStack.func_77949_a(item); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\i\InventoryCustomPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */