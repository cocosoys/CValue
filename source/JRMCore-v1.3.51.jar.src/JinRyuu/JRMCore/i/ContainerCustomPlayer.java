/*     */ package JinRyuu.JRMCore.i;
/*     */ 
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.item.ItemArmor;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ContainerCustomPlayer
/*     */   extends Container
/*     */ {
/*     */   private static final int ARMOR_START = 11;
/*     */   private static final int ARMOR_END = 14;
/*     */   private static final int INV_START = 15;
/*     */   private static final int INV_END = 41;
/*     */   private static final int HOTBAR_START = 42;
/*     */   private static final int HOTBAR_END = 50;
/*     */   
/*     */   public ContainerCustomPlayer(EntityPlayer player, InventoryPlayer inventoryPlayer, InventoryCustomPlayer inventoryCustom) {
/*  26 */     func_75146_a(new SlotCustom(inventoryCustom, 0, 80, 62));
/*  27 */     func_75146_a(new SlotCustom(inventoryCustom, 1, 80, 44));
/*  28 */     func_75146_a(new SlotCustom(inventoryCustom, 2, 80, 26)); int i2;
/*  29 */     for (i2 = 0; i2 < 4; i2++)
/*  30 */       func_75146_a(new SlotCustom(inventoryCustom, i2 + 3, 136, 62 - i2 * 18)); 
/*  31 */     for (i2 = 4; i2 < 8; i2++) {
/*  32 */       func_75146_a(new SlotCustom(inventoryCustom, i2 + 3, 154, 62 - (i2 - 4) * 18));
/*     */     }
/*     */ 
/*     */     
/*     */     int i;
/*     */ 
/*     */     
/*  39 */     for (i = 0; i < 4; i++) {
/*  40 */       func_75146_a(new SlotArmor(player, (IInventory)inventoryPlayer, inventoryPlayer.func_70302_i_() - 1 - i, 8, 8 + i * 18, i));
/*     */     }
/*     */     
/*  43 */     for (i = 0; i < 3; i++) {
/*  44 */       for (int j = 0; j < 9; j++) {
/*  45 */         func_75146_a(new Slot((IInventory)inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
/*     */       }
/*     */     } 
/*  48 */     for (i = 0; i < 9; i++) {
/*  49 */       func_75146_a(new Slot((IInventory)inventoryPlayer, i, 8 + i * 18, 142));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_75145_c(EntityPlayer player) {
/*  57 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_82846_b(EntityPlayer player, int par2) {
/*  65 */     ItemStack itemstack = null;
/*  66 */     Slot slot = this.field_75151_b.get(par2);
/*     */     
/*  68 */     if (slot != null && slot.func_75216_d()) {
/*  69 */       ItemStack itemstack1 = slot.func_75211_c();
/*  70 */       itemstack = itemstack1.func_77946_l();
/*     */ 
/*     */       
/*  73 */       if (par2 < 15)
/*     */       
/*     */       { 
/*  76 */         if (!func_75135_a(itemstack1, 15, 51, true)) return null;
/*     */ 
/*     */         
/*  79 */         slot.func_75220_a(itemstack1, itemstack);
/*     */ 
/*     */         
/*     */          }
/*     */       
/*  84 */       else if (itemstack1.func_77973_b() instanceof JinRyuu.JRMCore.items.ItemWeight)
/*  85 */       { if (!func_75135_a(itemstack1, 0, 11, false)) return null;
/*     */          }
/*  87 */       else if (itemstack1.func_77973_b() instanceof JinRyuu.JRMCore.items.ItemBodysuit)
/*  88 */       { if (!func_75135_a(itemstack1, 1, 11, false)) return null;
/*     */          }
/*  90 */       else if (itemstack1.func_77973_b() instanceof JinRyuu.JRMCore.items.ItemHeadwear)
/*  91 */       { if (!func_75135_a(itemstack1, 2, 11, false)) return null;
/*     */          }
/*  93 */       else if (itemstack1.func_77973_b() instanceof JinRyuu.JRMCore.items.ItemVanity)
/*  94 */       { if (!func_75135_a(itemstack1, 3, 11, false)) return null;
/*     */          }
/*     */       
/*  97 */       else if (itemstack1.func_77973_b() instanceof ItemArmor)
/*  98 */       { int type = ((ItemArmor)itemstack1.func_77973_b()).field_77881_a;
/*  99 */         if (!func_75135_a(itemstack1, 11 + type, 11 + type + 1, false)) return null;
/*     */          }
/*     */       
/* 102 */       else if (par2 >= 15 && par2 < 42)
/*     */       
/* 104 */       { if (!func_75135_a(itemstack1, 42, 43, false)) return null;
/*     */          }
/*     */       
/* 107 */       else if (par2 >= 42 && par2 < 51 && 
/* 108 */         !func_75135_a(itemstack1, 15, 42, false)) { return null; }
/*     */ 
/*     */ 
/*     */       
/* 112 */       if (itemstack1.field_77994_a == 0)
/* 113 */       { slot.func_75215_d((ItemStack)null); }
/* 114 */       else { slot.func_75218_e(); }
/*     */       
/* 116 */       if (itemstack1.field_77994_a == itemstack.field_77994_a) return null; 
/* 117 */       slot.func_82870_a(player, itemstack1);
/*     */     } 
/*     */     
/* 120 */     return itemstack;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\i\ContainerCustomPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */