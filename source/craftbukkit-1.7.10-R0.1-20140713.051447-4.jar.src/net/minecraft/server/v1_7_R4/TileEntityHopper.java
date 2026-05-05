/*     */ package net.minecraft.server.v1_7_R4;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.entity.CraftHumanEntity;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.inventory.CraftInventoryDoubleChest;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.inventory.CraftItemStack;
/*     */ import org.bukkit.entity.HumanEntity;
/*     */ import org.bukkit.entity.Item;
/*     */ import org.bukkit.event.Event;
/*     */ import org.bukkit.event.inventory.InventoryMoveItemEvent;
/*     */ import org.bukkit.event.inventory.InventoryPickupItemEvent;
/*     */ import org.bukkit.inventory.Inventory;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ 
/*     */ public class TileEntityHopper extends TileEntity implements IHopper {
/*  16 */   private ItemStack[] a = new ItemStack[5];
/*     */   private String i;
/*  18 */   private int j = -1;
/*     */ 
/*     */   
/*  21 */   public List<HumanEntity> transaction = new ArrayList<HumanEntity>();
/*  22 */   private int maxStack = 64;
/*     */   
/*     */   public ItemStack[] getContents() {
/*  25 */     return this.a;
/*     */   }
/*     */   
/*     */   public void onOpen(CraftHumanEntity who) {
/*  29 */     this.transaction.add(who);
/*     */   }
/*     */   
/*     */   public void onClose(CraftHumanEntity who) {
/*  33 */     this.transaction.remove(who);
/*     */   }
/*     */   
/*     */   public List<HumanEntity> getViewers() {
/*  37 */     return this.transaction;
/*     */   }
/*     */   
/*     */   public void setMaxStackSize(int size) {
/*  41 */     this.maxStack = size;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(NBTTagCompound nbttagcompound) {
/*  48 */     super.a(nbttagcompound);
/*  49 */     NBTTagList nbttaglist = nbttagcompound.getList("Items", 10);
/*     */     
/*  51 */     this.a = new ItemStack[getSize()];
/*  52 */     if (nbttagcompound.hasKeyOfType("CustomName", 8)) {
/*  53 */       this.i = nbttagcompound.getString("CustomName");
/*     */     }
/*     */     
/*  56 */     this.j = nbttagcompound.getInt("TransferCooldown");
/*     */     
/*  58 */     for (int i = 0; i < nbttaglist.size(); i++) {
/*  59 */       NBTTagCompound nbttagcompound1 = nbttaglist.get(i);
/*  60 */       byte b0 = nbttagcompound1.getByte("Slot");
/*     */       
/*  62 */       if (b0 >= 0 && b0 < this.a.length) {
/*  63 */         this.a[b0] = ItemStack.createStack(nbttagcompound1);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void b(NBTTagCompound nbttagcompound) {
/*  69 */     super.b(nbttagcompound);
/*  70 */     NBTTagList nbttaglist = new NBTTagList();
/*     */     
/*  72 */     for (int i = 0; i < this.a.length; i++) {
/*  73 */       if (this.a[i] != null) {
/*  74 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/*     */         
/*  76 */         nbttagcompound1.setByte("Slot", (byte)i);
/*  77 */         this.a[i].save(nbttagcompound1);
/*  78 */         nbttaglist.add(nbttagcompound1);
/*     */       } 
/*     */     } 
/*     */     
/*  82 */     nbttagcompound.set("Items", nbttaglist);
/*  83 */     nbttagcompound.setInt("TransferCooldown", this.j);
/*  84 */     if (k_()) {
/*  85 */       nbttagcompound.setString("CustomName", this.i);
/*     */     }
/*     */   }
/*     */   
/*     */   public void update() {
/*  90 */     super.update();
/*     */   }
/*     */   
/*     */   public int getSize() {
/*  94 */     return this.a.length;
/*     */   }
/*     */   
/*     */   public ItemStack getItem(int i) {
/*  98 */     return this.a[i];
/*     */   }
/*     */   
/*     */   public ItemStack splitStack(int i, int j) {
/* 102 */     if (this.a[i] != null) {
/*     */ 
/*     */       
/* 105 */       if ((this.a[i]).count <= j) {
/* 106 */         ItemStack itemStack = this.a[i];
/* 107 */         this.a[i] = null;
/* 108 */         return itemStack;
/*     */       } 
/* 110 */       ItemStack itemstack = this.a[i].a(j);
/* 111 */       if ((this.a[i]).count == 0) {
/* 112 */         this.a[i] = null;
/*     */       }
/*     */       
/* 115 */       return itemstack;
/*     */     } 
/*     */     
/* 118 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack splitWithoutUpdate(int i) {
/* 123 */     if (this.a[i] != null) {
/* 124 */       ItemStack itemstack = this.a[i];
/*     */       
/* 126 */       this.a[i] = null;
/* 127 */       return itemstack;
/*     */     } 
/* 129 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setItem(int i, ItemStack itemstack) {
/* 134 */     this.a[i] = itemstack;
/* 135 */     if (itemstack != null && itemstack.count > getMaxStackSize()) {
/* 136 */       itemstack.count = getMaxStackSize();
/*     */     }
/*     */   }
/*     */   
/*     */   public String getInventoryName() {
/* 141 */     return k_() ? this.i : "container.hopper";
/*     */   }
/*     */   
/*     */   public boolean k_() {
/* 145 */     return (this.i != null && this.i.length() > 0);
/*     */   }
/*     */   
/*     */   public void a(String s) {
/* 149 */     this.i = s;
/*     */   }
/*     */   
/*     */   public int getMaxStackSize() {
/* 153 */     return this.maxStack;
/*     */   }
/*     */   
/*     */   public boolean a(EntityHuman entityhuman) {
/* 157 */     return (this.world.getTileEntity(this.x, this.y, this.z) != this) ? false : ((entityhuman.e(this.x + 0.5D, this.y + 0.5D, this.z + 0.5D) <= 64.0D));
/*     */   }
/*     */   
/*     */   public void startOpen() {}
/*     */   
/*     */   public void closeContainer() {}
/*     */   
/*     */   public boolean b(int i, ItemStack itemstack) {
/* 165 */     return true;
/*     */   }
/*     */   
/*     */   public void h() {
/* 169 */     if (this.world != null && !this.world.isStatic) {
/* 170 */       this.j--;
/* 171 */       if (!j()) {
/* 172 */         c(0);
/* 173 */         i();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean i() {
/* 179 */     if (this.world != null && !this.world.isStatic) {
/* 180 */       if (!j() && BlockHopper.c(p())) {
/* 181 */         boolean flag = false;
/*     */         
/* 183 */         if (!k()) {
/* 184 */           flag = y();
/*     */         }
/*     */         
/* 187 */         if (!l()) {
/* 188 */           flag = (suckInItems(this) || flag);
/*     */         }
/*     */         
/* 191 */         if (flag) {
/* 192 */           c(8);
/* 193 */           update();
/* 194 */           return true;
/*     */         } 
/*     */       } 
/*     */       
/* 198 */       return false;
/*     */     } 
/* 200 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean k() {
/* 205 */     ItemStack[] aitemstack = this.a;
/* 206 */     int i = aitemstack.length;
/*     */     
/* 208 */     for (int j = 0; j < i; j++) {
/* 209 */       ItemStack itemstack = aitemstack[j];
/*     */       
/* 211 */       if (itemstack != null) {
/* 212 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 216 */     return true;
/*     */   }
/*     */   
/*     */   private boolean l() {
/* 220 */     ItemStack[] aitemstack = this.a;
/* 221 */     int i = aitemstack.length;
/*     */     
/* 223 */     for (int j = 0; j < i; j++) {
/* 224 */       ItemStack itemstack = aitemstack[j];
/*     */       
/* 226 */       if (itemstack == null || itemstack.count != itemstack.getMaxStackSize()) {
/* 227 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 231 */     return true;
/*     */   }
/*     */   
/*     */   private boolean y() {
/* 235 */     IInventory iinventory = z();
/*     */     
/* 237 */     if (iinventory == null) {
/* 238 */       return false;
/*     */     }
/* 240 */     int i = Facing.OPPOSITE_FACING[BlockHopper.b(p())];
/*     */     
/* 242 */     if (a(iinventory, i)) {
/* 243 */       return false;
/*     */     }
/* 245 */     for (int j = 0; j < getSize(); j++) {
/* 246 */       if (getItem(j) != null) {
/* 247 */         Inventory destinationInventory; ItemStack itemstack = getItem(j).cloneItemStack();
/*     */         
/* 249 */         CraftItemStack oitemstack = CraftItemStack.asCraftMirror(splitStack(j, 1));
/*     */ 
/*     */ 
/*     */         
/* 253 */         if (iinventory instanceof InventoryLargeChest) {
/* 254 */           CraftInventoryDoubleChest craftInventoryDoubleChest = new CraftInventoryDoubleChest((InventoryLargeChest)iinventory);
/*     */         } else {
/* 256 */           destinationInventory = iinventory.getOwner().getInventory();
/*     */         } 
/*     */         
/* 259 */         InventoryMoveItemEvent event = new InventoryMoveItemEvent(getOwner().getInventory(), (ItemStack)oitemstack.clone(), destinationInventory, true);
/* 260 */         getWorld().getServer().getPluginManager().callEvent((Event)event);
/* 261 */         if (event.isCancelled()) {
/* 262 */           setItem(j, itemstack);
/* 263 */           c(8);
/* 264 */           return false;
/*     */         } 
/* 266 */         ItemStack itemstack1 = addItem(iinventory, CraftItemStack.asNMSCopy(event.getItem()), i);
/*     */         
/* 268 */         if (itemstack1 == null || itemstack1.count == 0) {
/* 269 */           if (event.getItem().equals(oitemstack)) {
/* 270 */             iinventory.update();
/*     */           } else {
/* 272 */             setItem(j, itemstack);
/*     */           } 
/*     */           
/* 275 */           return true;
/*     */         } 
/*     */         
/* 278 */         setItem(j, itemstack);
/*     */       } 
/*     */     } 
/*     */     
/* 282 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean a(IInventory iinventory, int i) {
/* 288 */     if (iinventory instanceof IWorldInventory && i > -1) {
/* 289 */       IWorldInventory iworldinventory = (IWorldInventory)iinventory;
/* 290 */       int[] aint = iworldinventory.getSlotsForFace(i);
/*     */       
/* 292 */       for (int j = 0; j < aint.length; j++) {
/* 293 */         ItemStack itemstack = iworldinventory.getItem(aint[j]);
/*     */         
/* 295 */         if (itemstack == null || itemstack.count != itemstack.getMaxStackSize()) {
/* 296 */           return false;
/*     */         }
/*     */       } 
/*     */     } else {
/* 300 */       int k = iinventory.getSize();
/*     */       
/* 302 */       for (int l = 0; l < k; l++) {
/* 303 */         ItemStack itemstack1 = iinventory.getItem(l);
/*     */         
/* 305 */         if (itemstack1 == null || itemstack1.count != itemstack1.getMaxStackSize()) {
/* 306 */           return false;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 311 */     return true;
/*     */   }
/*     */   
/*     */   private static boolean b(IInventory iinventory, int i) {
/* 315 */     if (iinventory instanceof IWorldInventory && i > -1) {
/* 316 */       IWorldInventory iworldinventory = (IWorldInventory)iinventory;
/* 317 */       int[] aint = iworldinventory.getSlotsForFace(i);
/*     */       
/* 319 */       for (int j = 0; j < aint.length; j++) {
/* 320 */         if (iworldinventory.getItem(aint[j]) != null) {
/* 321 */           return false;
/*     */         }
/*     */       } 
/*     */     } else {
/* 325 */       int k = iinventory.getSize();
/*     */       
/* 327 */       for (int l = 0; l < k; l++) {
/* 328 */         if (iinventory.getItem(l) != null) {
/* 329 */           return false;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 334 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean suckInItems(IHopper ihopper) {
/* 338 */     IInventory iinventory = getSourceInventory(ihopper);
/*     */     
/* 340 */     if (iinventory != null) {
/* 341 */       byte b0 = 0;
/*     */       
/* 343 */       if (b(iinventory, b0)) {
/* 344 */         return false;
/*     */       }
/*     */       
/* 347 */       if (iinventory instanceof IWorldInventory && b0 > -1) {
/* 348 */         IWorldInventory iworldinventory = (IWorldInventory)iinventory;
/* 349 */         int[] aint = iworldinventory.getSlotsForFace(b0);
/*     */         
/* 351 */         for (int i = 0; i < aint.length; i++) {
/* 352 */           if (tryTakeInItemFromSlot(ihopper, iinventory, aint[i], b0)) {
/* 353 */             return true;
/*     */           }
/*     */         } 
/*     */       } else {
/* 357 */         int j = iinventory.getSize();
/*     */         
/* 359 */         for (int k = 0; k < j; k++) {
/* 360 */           if (tryTakeInItemFromSlot(ihopper, iinventory, k, b0)) {
/* 361 */             return true;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } else {
/* 366 */       EntityItem entityitem = getEntityItemAt(ihopper.getWorld(), ihopper.x(), ihopper.aD() + 1.0D, ihopper.aE());
/*     */       
/* 368 */       if (entityitem != null) {
/* 369 */         return addEntityItem(ihopper, entityitem);
/*     */       }
/*     */     } 
/*     */     
/* 373 */     return false;
/*     */   }
/*     */   
/*     */   private static boolean tryTakeInItemFromSlot(IHopper ihopper, IInventory iinventory, int i, int j) {
/* 377 */     ItemStack itemstack = iinventory.getItem(i);
/*     */     
/* 379 */     if (itemstack != null && canTakeItemFromInventory(iinventory, itemstack, i, j)) {
/* 380 */       Inventory sourceInventory; ItemStack itemstack1 = itemstack.cloneItemStack();
/*     */       
/* 382 */       CraftItemStack oitemstack = CraftItemStack.asCraftMirror(iinventory.splitStack(i, 1));
/*     */ 
/*     */ 
/*     */       
/* 386 */       if (iinventory instanceof InventoryLargeChest) {
/* 387 */         CraftInventoryDoubleChest craftInventoryDoubleChest = new CraftInventoryDoubleChest((InventoryLargeChest)iinventory);
/*     */       } else {
/* 389 */         sourceInventory = iinventory.getOwner().getInventory();
/*     */       } 
/*     */       
/* 392 */       InventoryMoveItemEvent event = new InventoryMoveItemEvent(sourceInventory, (ItemStack)oitemstack.clone(), ihopper.getOwner().getInventory(), false);
/*     */       
/* 394 */       ihopper.getWorld().getServer().getPluginManager().callEvent((Event)event);
/* 395 */       if (event.isCancelled()) {
/* 396 */         iinventory.setItem(i, itemstack1);
/*     */         
/* 398 */         if (ihopper instanceof TileEntityHopper) {
/* 399 */           ((TileEntityHopper)ihopper).c(8);
/* 400 */         } else if (ihopper instanceof EntityMinecartHopper) {
/* 401 */           ((EntityMinecartHopper)ihopper).l(4);
/*     */         } 
/*     */         
/* 404 */         return false;
/*     */       } 
/* 406 */       ItemStack itemstack2 = addItem(ihopper, CraftItemStack.asNMSCopy(event.getItem()), -1);
/*     */       
/* 408 */       if (itemstack2 == null || itemstack2.count == 0) {
/* 409 */         if (event.getItem().equals(oitemstack)) {
/* 410 */           iinventory.update();
/*     */         } else {
/* 412 */           iinventory.setItem(i, itemstack1);
/*     */         } 
/*     */ 
/*     */         
/* 416 */         return true;
/*     */       } 
/*     */       
/* 419 */       iinventory.setItem(i, itemstack1);
/*     */     } 
/*     */     
/* 422 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean addEntityItem(IInventory iinventory, EntityItem entityitem) {
/* 426 */     boolean flag = false;
/*     */     
/* 428 */     if (entityitem == null) {
/* 429 */       return false;
/*     */     }
/*     */     
/* 432 */     InventoryPickupItemEvent event = new InventoryPickupItemEvent(iinventory.getOwner().getInventory(), (Item)entityitem.getBukkitEntity());
/* 433 */     entityitem.world.getServer().getPluginManager().callEvent((Event)event);
/* 434 */     if (event.isCancelled()) {
/* 435 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 439 */     ItemStack itemstack = entityitem.getItemStack().cloneItemStack();
/* 440 */     ItemStack itemstack1 = addItem(iinventory, itemstack, -1);
/*     */     
/* 442 */     if (itemstack1 != null && itemstack1.count != 0) {
/* 443 */       entityitem.setItemStack(itemstack1);
/*     */     } else {
/* 445 */       flag = true;
/* 446 */       entityitem.die();
/*     */     } 
/*     */     
/* 449 */     return flag;
/*     */   }
/*     */ 
/*     */   
/*     */   public static ItemStack addItem(IInventory iinventory, ItemStack itemstack, int i) {
/* 454 */     if (iinventory instanceof IWorldInventory && i > -1) {
/* 455 */       IWorldInventory iworldinventory = (IWorldInventory)iinventory;
/* 456 */       int[] aint = iworldinventory.getSlotsForFace(i);
/*     */       
/* 458 */       for (int j = 0; j < aint.length && itemstack != null && itemstack.count > 0; j++) {
/* 459 */         itemstack = tryMoveInItem(iinventory, itemstack, aint[j], i);
/*     */       }
/*     */     } else {
/* 462 */       int k = iinventory.getSize();
/*     */       
/* 464 */       for (int l = 0; l < k && itemstack != null && itemstack.count > 0; l++) {
/* 465 */         itemstack = tryMoveInItem(iinventory, itemstack, l, i);
/*     */       }
/*     */     } 
/*     */     
/* 469 */     if (itemstack != null && itemstack.count == 0) {
/* 470 */       itemstack = null;
/*     */     }
/*     */     
/* 473 */     return itemstack;
/*     */   }
/*     */   
/*     */   private static boolean canPlaceItemInInventory(IInventory iinventory, ItemStack itemstack, int i, int j) {
/* 477 */     return !iinventory.b(i, itemstack) ? false : ((!(iinventory instanceof IWorldInventory) || ((IWorldInventory)iinventory).canPlaceItemThroughFace(i, itemstack, j)));
/*     */   }
/*     */   
/*     */   private static boolean canTakeItemFromInventory(IInventory iinventory, ItemStack itemstack, int i, int j) {
/* 481 */     return (!(iinventory instanceof IWorldInventory) || ((IWorldInventory)iinventory).canTakeItemThroughFace(i, itemstack, j));
/*     */   }
/*     */   
/*     */   private static ItemStack tryMoveInItem(IInventory iinventory, ItemStack itemstack, int i, int j) {
/* 485 */     ItemStack itemstack1 = iinventory.getItem(i);
/*     */     
/* 487 */     if (canPlaceItemInInventory(iinventory, itemstack, i, j)) {
/* 488 */       boolean flag = false;
/*     */       
/* 490 */       if (itemstack1 == null) {
/* 491 */         iinventory.setItem(i, itemstack);
/* 492 */         itemstack = null;
/* 493 */         flag = true;
/* 494 */       } else if (canMergeItems(itemstack1, itemstack)) {
/* 495 */         int k = itemstack.getMaxStackSize() - itemstack1.count;
/* 496 */         int l = Math.min(itemstack.count, k);
/*     */         
/* 498 */         itemstack.count -= l;
/* 499 */         itemstack1.count += l;
/* 500 */         flag = (l > 0);
/*     */       } 
/*     */       
/* 503 */       if (flag) {
/* 504 */         if (iinventory instanceof TileEntityHopper) {
/* 505 */           ((TileEntityHopper)iinventory).c(8);
/* 506 */           iinventory.update();
/*     */         } 
/*     */         
/* 509 */         iinventory.update();
/*     */       } 
/*     */     } 
/*     */     
/* 513 */     return itemstack;
/*     */   }
/*     */   
/*     */   private IInventory z() {
/* 517 */     int i = BlockHopper.b(p());
/*     */     
/* 519 */     return getInventoryAt(getWorld(), (this.x + Facing.b[i]), (this.y + Facing.c[i]), (this.z + Facing.d[i]));
/*     */   }
/*     */   
/*     */   public static IInventory getSourceInventory(IHopper ihopper) {
/* 523 */     return getInventoryAt(ihopper.getWorld(), ihopper.x(), ihopper.aD() + 1.0D, ihopper.aE());
/*     */   }
/*     */   
/*     */   public static EntityItem getEntityItemAt(World world, double d0, double d1, double d2) {
/* 527 */     List<EntityItem> list = world.a(EntityItem.class, AxisAlignedBB.a(d0, d1, d2, d0 + 1.0D, d1 + 1.0D, d2 + 1.0D), IEntitySelector.a);
/*     */     
/* 529 */     return (list.size() > 0) ? list.get(0) : null;
/*     */   }
/*     */   
/*     */   public static IInventory getInventoryAt(World world, double d0, double d1, double d2) {
/* 533 */     IInventory iinventory = null;
/* 534 */     int i = MathHelper.floor(d0);
/* 535 */     int j = MathHelper.floor(d1);
/* 536 */     int k = MathHelper.floor(d2);
/* 537 */     TileEntity tileentity = world.getTileEntity(i, j, k);
/*     */     
/* 539 */     if (tileentity != null && tileentity instanceof IInventory) {
/* 540 */       iinventory = (IInventory)tileentity;
/* 541 */       if (iinventory instanceof TileEntityChest) {
/* 542 */         Block block = world.getType(i, j, k);
/*     */         
/* 544 */         if (block instanceof BlockChest) {
/* 545 */           iinventory = ((BlockChest)block).m(world, i, j, k);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 550 */     if (iinventory == null) {
/* 551 */       List<IInventory> list = world.getEntities((Entity)null, AxisAlignedBB.a(d0, d1, d2, d0 + 1.0D, d1 + 1.0D, d2 + 1.0D), IEntitySelector.c);
/*     */       
/* 553 */       if (list != null && list.size() > 0) {
/* 554 */         iinventory = list.get(world.random.nextInt(list.size()));
/*     */       }
/*     */     } 
/*     */     
/* 558 */     return iinventory;
/*     */   }
/*     */   
/*     */   private static boolean canMergeItems(ItemStack itemstack, ItemStack itemstack1) {
/* 562 */     return (itemstack.getItem() != itemstack1.getItem()) ? false : ((itemstack.getData() != itemstack1.getData()) ? false : ((itemstack.count > itemstack.getMaxStackSize()) ? false : ItemStack.equals(itemstack, itemstack1)));
/*     */   }
/*     */   
/*     */   public double x() {
/* 566 */     return this.x;
/*     */   }
/*     */   
/*     */   public double aD() {
/* 570 */     return this.y;
/*     */   }
/*     */   
/*     */   public double aE() {
/* 574 */     return this.z;
/*     */   }
/*     */   
/*     */   public void c(int i) {
/* 578 */     this.j = i;
/*     */   }
/*     */   
/*     */   public boolean j() {
/* 582 */     return (this.j > 0);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\TileEntityHopper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */