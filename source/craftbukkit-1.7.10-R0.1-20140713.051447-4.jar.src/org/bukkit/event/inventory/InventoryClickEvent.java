/*     */ package org.bukkit.event.inventory;
/*     */ 
/*     */ import org.bukkit.event.HandlerList;
/*     */ import org.bukkit.inventory.InventoryView;
/*     */ import org.bukkit.inventory.ItemStack;
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
/*     */ public class InventoryClickEvent
/*     */   extends InventoryInteractEvent
/*     */ {
/*  47 */   private static final HandlerList handlers = new HandlerList();
/*     */   private final ClickType click;
/*     */   private final InventoryAction action;
/*     */   private InventoryType.SlotType slot_type;
/*     */   private int whichSlot;
/*     */   private int rawSlot;
/*  53 */   private ItemStack current = null;
/*  54 */   private int hotbarKey = -1;
/*     */   
/*     */   @Deprecated
/*     */   public InventoryClickEvent(InventoryView view, InventoryType.SlotType type, int slot, boolean right, boolean shift) {
/*  58 */     this(view, type, slot, right ? (shift ? ClickType.SHIFT_RIGHT : ClickType.RIGHT) : (shift ? ClickType.SHIFT_LEFT : ClickType.LEFT), InventoryAction.SWAP_WITH_CURSOR);
/*     */   }
/*     */   
/*     */   public InventoryClickEvent(InventoryView view, InventoryType.SlotType type, int slot, ClickType click, InventoryAction action) {
/*  62 */     super(view);
/*  63 */     this.slot_type = type;
/*  64 */     this.rawSlot = slot;
/*  65 */     this.whichSlot = view.convertSlot(slot);
/*  66 */     this.click = click;
/*  67 */     this.action = action;
/*     */   }
/*     */   
/*     */   public InventoryClickEvent(InventoryView view, InventoryType.SlotType type, int slot, ClickType click, InventoryAction action, int key) {
/*  71 */     this(view, type, slot, click, action);
/*  72 */     this.hotbarKey = key;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InventoryType.SlotType getSlotType() {
/*  81 */     return this.slot_type;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack getCursor() {
/*  90 */     return getView().getCursor();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack getCurrentItem() {
/*  99 */     if (this.slot_type == InventoryType.SlotType.OUTSIDE) {
/* 100 */       return this.current;
/*     */     }
/* 102 */     return getView().getItem(this.rawSlot);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isRightClick() {
/* 113 */     return this.click.isRightClick();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isLeftClick() {
/* 124 */     return this.click.isLeftClick();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isShiftClick() {
/* 135 */     return this.click.isShiftClick();
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
/*     */   @Deprecated
/*     */   public void setCursor(ItemStack stack) {
/* 149 */     getView().setCursor(stack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCurrentItem(ItemStack stack) {
/* 158 */     if (this.slot_type == InventoryType.SlotType.OUTSIDE) {
/* 159 */       this.current = stack;
/*     */     } else {
/* 161 */       getView().setItem(this.rawSlot, stack);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSlot() {
/* 173 */     return this.whichSlot;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRawSlot() {
/* 183 */     return this.rawSlot;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getHotbarButton() {
/* 194 */     return this.hotbarKey;
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
/*     */   public InventoryAction getAction() {
/* 207 */     return this.action;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ClickType getClick() {
/* 218 */     return this.click;
/*     */   }
/*     */ 
/*     */   
/*     */   public HandlerList getHandlers() {
/* 223 */     return handlers;
/*     */   }
/*     */   
/*     */   public static HandlerList getHandlerList() {
/* 227 */     return handlers;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\event\inventory\InventoryClickEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */