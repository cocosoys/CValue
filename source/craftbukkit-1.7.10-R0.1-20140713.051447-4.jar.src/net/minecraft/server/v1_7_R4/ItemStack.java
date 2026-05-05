/*     */ package net.minecraft.server.v1_7_R4;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.util.com.google.common.collect.HashMultimap;
/*     */ import net.minecraft.util.com.google.common.collect.Multimap;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.TreeType;
/*     */ import org.bukkit.World;
/*     */ import org.bukkit.block.BlockState;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.block.CraftBlockState;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.event.CraftEventFactory;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.util.CraftMagicNumbers;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.Event;
/*     */ import org.bukkit.event.block.BlockMultiPlaceEvent;
/*     */ import org.bukkit.event.block.BlockPlaceEvent;
/*     */ import org.bukkit.event.world.StructureGrowEvent;
/*     */ 
/*     */ public final class ItemStack {
/*  23 */   public static final DecimalFormat a = new DecimalFormat("#.###");
/*     */   public int count;
/*     */   public int c;
/*     */   private Item item;
/*     */   public NBTTagCompound tag;
/*     */   private int damage;
/*     */   private EntityItemFrame g;
/*     */   
/*     */   public ItemStack(Block block) {
/*  32 */     this(block, 1);
/*     */   }
/*     */   
/*     */   public ItemStack(Block block, int i) {
/*  36 */     this(block, i, 0);
/*     */   }
/*     */   
/*     */   public ItemStack(Block block, int i, int j) {
/*  40 */     this(Item.getItemOf(block), i, j);
/*     */   }
/*     */   
/*     */   public ItemStack(Item item) {
/*  44 */     this(item, 1);
/*     */   }
/*     */   
/*     */   public ItemStack(Item item, int i) {
/*  48 */     this(item, i, 0);
/*     */   }
/*     */   
/*     */   public ItemStack(Item item, int i, int j) {
/*  52 */     this.item = item;
/*  53 */     this.count = i;
/*     */     
/*  55 */     setData(j);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ItemStack createStack(NBTTagCompound nbttagcompound) {
/*  64 */     ItemStack itemstack = new ItemStack();
/*     */     
/*  66 */     itemstack.c(nbttagcompound);
/*  67 */     return (itemstack.getItem() != null) ? itemstack : null;
/*     */   }
/*     */   
/*     */   private ItemStack() {}
/*     */   
/*     */   public ItemStack a(int i) {
/*  73 */     ItemStack itemstack = new ItemStack(this.item, i, this.damage);
/*     */     
/*  75 */     if (this.tag != null) {
/*  76 */       itemstack.tag = (NBTTagCompound)this.tag.clone();
/*     */     }
/*     */     
/*  79 */     this.count -= i;
/*  80 */     return itemstack;
/*     */   }
/*     */   
/*     */   public Item getItem() {
/*  84 */     return this.item;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean placeItem(EntityHuman entityhuman, World world, int i, int j, int k, int l, float f, float f1, float f2) {
/*  89 */     int data = getData();
/*  90 */     int count = this.count;
/*     */     
/*  92 */     if (!(getItem() instanceof ItemBucket)) {
/*  93 */       world.captureBlockStates = true;
/*     */       
/*  95 */       if (getItem() instanceof ItemDye && getData() == 15) {
/*  96 */         Block block = world.getType(i, j, k);
/*  97 */         if (block == Blocks.SAPLING || block instanceof BlockMushroom) {
/*  98 */           world.captureTreeGeneration = true;
/*     */         }
/*     */       } 
/*     */     } 
/* 102 */     boolean flag = getItem().interactWith(this, entityhuman, world, i, j, k, l, f, f1, f2);
/* 103 */     int newData = getData();
/* 104 */     int newCount = this.count;
/* 105 */     this.count = count;
/* 106 */     setData(data);
/* 107 */     world.captureBlockStates = false;
/* 108 */     if (flag && world.captureTreeGeneration && world.capturedBlockStates.size() > 0) {
/* 109 */       world.captureTreeGeneration = false;
/* 110 */       Location location = new Location((World)world.getWorld(), i, j, k);
/* 111 */       TreeType treeType = BlockSapling.treeType;
/* 112 */       BlockSapling.treeType = null;
/* 113 */       List<BlockState> blocks = (List<BlockState>)world.capturedBlockStates.clone();
/* 114 */       world.capturedBlockStates.clear();
/* 115 */       StructureGrowEvent event = null;
/* 116 */       if (treeType != null) {
/* 117 */         event = new StructureGrowEvent(location, treeType, false, (Player)entityhuman.getBukkitEntity(), blocks);
/* 118 */         Bukkit.getPluginManager().callEvent((Event)event);
/*     */       } 
/* 120 */       if (event == null || !event.isCancelled()) {
/*     */         
/* 122 */         if (this.count == count && getData() == data) {
/* 123 */           setData(newData);
/* 124 */           this.count = newCount;
/*     */         } 
/* 126 */         for (BlockState blockstate : blocks) {
/* 127 */           blockstate.update(true);
/*     */         }
/*     */       } 
/*     */       
/* 131 */       return flag;
/*     */     } 
/* 133 */     world.captureTreeGeneration = false;
/*     */     
/* 135 */     if (flag) {
/* 136 */       BlockPlaceEvent placeEvent = null;
/* 137 */       List<BlockState> blocks = (List<BlockState>)world.capturedBlockStates.clone();
/* 138 */       world.capturedBlockStates.clear();
/* 139 */       if (blocks.size() > 1) {
/* 140 */         BlockMultiPlaceEvent blockMultiPlaceEvent = CraftEventFactory.callBlockMultiPlaceEvent(world, entityhuman, blocks, i, j, k);
/* 141 */       } else if (blocks.size() == 1) {
/* 142 */         placeEvent = CraftEventFactory.callBlockPlaceEvent(world, entityhuman, blocks.get(0), i, j, k);
/*     */       } 
/*     */       
/* 145 */       if (placeEvent != null && (placeEvent.isCancelled() || !placeEvent.canBuild())) {
/* 146 */         flag = false;
/*     */         
/* 148 */         for (BlockState blockstate : blocks) {
/* 149 */           blockstate.update(true, false);
/*     */         }
/*     */       } else {
/*     */         
/* 153 */         if (this.count == count && getData() == data) {
/* 154 */           setData(newData);
/* 155 */           this.count = newCount;
/*     */         } 
/* 157 */         for (BlockState blockstate : blocks) {
/* 158 */           int x = blockstate.getX();
/* 159 */           int y = blockstate.getY();
/* 160 */           int z = blockstate.getZ();
/* 161 */           int updateFlag = ((CraftBlockState)blockstate).getFlag();
/* 162 */           Material mat = blockstate.getType();
/* 163 */           Block oldBlock = CraftMagicNumbers.getBlock(mat);
/* 164 */           Block block = world.getType(x, y, z);
/*     */           
/* 166 */           if (block != null && !(block instanceof BlockContainer)) {
/* 167 */             block.onPlace(world, x, y, z);
/*     */           }
/*     */           
/* 170 */           world.notifyAndUpdatePhysics(x, y, z, null, oldBlock, block, updateFlag);
/*     */         } 
/* 172 */         entityhuman.a(StatisticList.USE_ITEM_COUNT[Item.getId(this.item)], 1);
/*     */       } 
/*     */     } 
/* 175 */     world.capturedBlockStates.clear();
/*     */ 
/*     */     
/* 178 */     return flag;
/*     */   }
/*     */   
/*     */   public float a(Block block) {
/* 182 */     return getItem().getDestroySpeed(this, block);
/*     */   }
/*     */   
/*     */   public ItemStack a(World world, EntityHuman entityhuman) {
/* 186 */     return getItem().a(this, world, entityhuman);
/*     */   }
/*     */   
/*     */   public ItemStack b(World world, EntityHuman entityhuman) {
/* 190 */     return getItem().b(this, world, entityhuman);
/*     */   }
/*     */   
/*     */   public NBTTagCompound save(NBTTagCompound nbttagcompound) {
/* 194 */     nbttagcompound.setShort("id", (short)Item.getId(this.item));
/* 195 */     nbttagcompound.setByte("Count", (byte)this.count);
/* 196 */     nbttagcompound.setShort("Damage", (short)this.damage);
/* 197 */     if (this.tag != null) {
/* 198 */       nbttagcompound.set("tag", this.tag.clone());
/*     */     }
/*     */     
/* 201 */     return nbttagcompound;
/*     */   }
/*     */   
/*     */   public void c(NBTTagCompound nbttagcompound) {
/* 205 */     this.item = Item.getById(nbttagcompound.getShort("id"));
/* 206 */     this.count = nbttagcompound.getByte("Count");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 213 */     setData(nbttagcompound.getShort("Damage"));
/*     */ 
/*     */     
/* 216 */     if (nbttagcompound.hasKeyOfType("tag", 10))
/*     */     {
/* 218 */       this.tag = (NBTTagCompound)nbttagcompound.getCompound("tag").clone();
/*     */     }
/*     */   }
/*     */   
/*     */   public int getMaxStackSize() {
/* 223 */     return getItem().getMaxStackSize();
/*     */   }
/*     */   
/*     */   public boolean isStackable() {
/* 227 */     return (getMaxStackSize() > 1 && (!g() || !i()));
/*     */   }
/*     */   
/*     */   public boolean g() {
/* 231 */     return (this.item.getMaxDurability() <= 0) ? false : ((!hasTag() || !getTag().getBoolean("Unbreakable")));
/*     */   }
/*     */   
/*     */   public boolean usesData() {
/* 235 */     return this.item.n();
/*     */   }
/*     */   
/*     */   public boolean i() {
/* 239 */     return (g() && this.damage > 0);
/*     */   }
/*     */   
/*     */   public int j() {
/* 243 */     return this.damage;
/*     */   }
/*     */   
/*     */   public int getData() {
/* 247 */     return this.damage;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setData(int i) {
/* 253 */     if (i == 32767) {
/* 254 */       this.damage = i;
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 259 */     if (CraftMagicNumbers.getBlock(CraftMagicNumbers.getId(getItem())) != Blocks.AIR)
/*     */     {
/* 261 */       if (!usesData() && !getItem().usesDurability()) {
/* 262 */         i = 0;
/*     */       }
/*     */     }
/*     */ 
/*     */     
/* 267 */     if (CraftMagicNumbers.getBlock(CraftMagicNumbers.getId(getItem())) == Blocks.DOUBLE_PLANT && (i > 5 || i < 0)) {
/* 268 */       i = 0;
/*     */     }
/*     */ 
/*     */     
/* 272 */     this.damage = i;
/* 273 */     if (this.damage < -1) {
/* 274 */       this.damage = 0;
/*     */     }
/*     */   }
/*     */   
/*     */   public int l() {
/* 279 */     return this.item.getMaxDurability();
/*     */   }
/*     */   
/*     */   public boolean isDamaged(int i, Random random) {
/* 283 */     if (!g()) {
/* 284 */       return false;
/*     */     }
/* 286 */     if (i > 0) {
/* 287 */       int j = EnchantmentManager.getEnchantmentLevel(Enchantment.DURABILITY.id, this);
/* 288 */       int k = 0;
/*     */       
/* 290 */       for (int l = 0; j > 0 && l < i; l++) {
/* 291 */         if (EnchantmentDurability.a(this, j, random)) {
/* 292 */           k++;
/*     */         }
/*     */       } 
/*     */       
/* 296 */       i -= k;
/* 297 */       if (i <= 0) {
/* 298 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 302 */     this.damage += i;
/* 303 */     return (this.damage > l());
/*     */   }
/*     */ 
/*     */   
/*     */   public void damage(int i, EntityLiving entityliving) {
/* 308 */     if ((!(entityliving instanceof EntityHuman) || !((EntityHuman)entityliving).abilities.canInstantlyBuild) && 
/* 309 */       g() && 
/* 310 */       isDamaged(i, entityliving.aI())) {
/* 311 */       entityliving.a(this);
/* 312 */       this.count--;
/* 313 */       if (entityliving instanceof EntityHuman) {
/* 314 */         EntityHuman entityhuman = (EntityHuman)entityliving;
/*     */         
/* 316 */         entityhuman.a(StatisticList.BREAK_ITEM_COUNT[Item.getId(this.item)], 1);
/* 317 */         if (this.count == 0 && getItem() instanceof ItemBow) {
/* 318 */           entityhuman.bG();
/*     */         }
/*     */       } 
/*     */       
/* 322 */       if (this.count < 0) {
/* 323 */         this.count = 0;
/*     */       }
/*     */ 
/*     */       
/* 327 */       if (this.count == 0 && entityliving instanceof EntityHuman) {
/* 328 */         CraftEventFactory.callPlayerItemBreakEvent((EntityHuman)entityliving, this);
/*     */       }
/*     */ 
/*     */       
/* 332 */       this.damage = 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(EntityLiving entityliving, EntityHuman entityhuman) {
/* 339 */     boolean flag = this.item.a(this, entityliving, entityhuman);
/*     */     
/* 341 */     if (flag) {
/* 342 */       entityhuman.a(StatisticList.USE_ITEM_COUNT[Item.getId(this.item)], 1);
/*     */     }
/*     */   }
/*     */   
/*     */   public void a(World world, Block block, int i, int j, int k, EntityHuman entityhuman) {
/* 347 */     boolean flag = this.item.a(this, world, block, i, j, k, entityhuman);
/*     */     
/* 349 */     if (flag) {
/* 350 */       entityhuman.a(StatisticList.USE_ITEM_COUNT[Item.getId(this.item)], 1);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean b(Block block) {
/* 355 */     return this.item.canDestroySpecialBlock(block);
/*     */   }
/*     */   
/*     */   public boolean a(EntityHuman entityhuman, EntityLiving entityliving) {
/* 359 */     return this.item.a(this, entityhuman, entityliving);
/*     */   }
/*     */   
/*     */   public ItemStack cloneItemStack() {
/* 363 */     ItemStack itemstack = new ItemStack(this.item, this.count, this.damage);
/*     */     
/* 365 */     if (this.tag != null) {
/* 366 */       itemstack.tag = (NBTTagCompound)this.tag.clone();
/*     */     }
/*     */     
/* 369 */     return itemstack;
/*     */   }
/*     */   
/*     */   public static boolean equals(ItemStack itemstack, ItemStack itemstack1) {
/* 373 */     return (itemstack == null && itemstack1 == null) ? true : ((itemstack != null && itemstack1 != null) ? ((itemstack.tag == null && itemstack1.tag != null) ? false : ((itemstack.tag == null || itemstack.tag.equals(itemstack1.tag)))) : false);
/*     */   }
/*     */   
/*     */   public static boolean matches(ItemStack itemstack, ItemStack itemstack1) {
/* 377 */     return (itemstack == null && itemstack1 == null) ? true : ((itemstack != null && itemstack1 != null) ? itemstack.d(itemstack1) : false);
/*     */   }
/*     */   
/*     */   private boolean d(ItemStack itemstack) {
/* 381 */     return (this.count != itemstack.count) ? false : ((this.item != itemstack.item) ? false : ((this.damage != itemstack.damage) ? false : ((this.tag == null && itemstack.tag != null) ? false : ((this.tag == null || this.tag.equals(itemstack.tag))))));
/*     */   }
/*     */   
/*     */   public boolean doMaterialsMatch(ItemStack itemstack) {
/* 385 */     return (this.item == itemstack.item && this.damage == itemstack.damage);
/*     */   }
/*     */   
/*     */   public String a() {
/* 389 */     return this.item.a(this);
/*     */   }
/*     */   
/*     */   public static ItemStack b(ItemStack itemstack) {
/* 393 */     return (itemstack == null) ? null : itemstack.cloneItemStack();
/*     */   }
/*     */   
/*     */   public String toString() {
/* 397 */     return this.count + "x" + this.item.getName() + "@" + this.damage;
/*     */   }
/*     */   
/*     */   public void a(World world, Entity entity, int i, boolean flag) {
/* 401 */     if (this.c > 0) {
/* 402 */       this.c--;
/*     */     }
/*     */     
/* 405 */     this.item.a(this, world, entity, i, flag);
/*     */   }
/*     */   
/*     */   public void a(World world, EntityHuman entityhuman, int i) {
/* 409 */     entityhuman.a(StatisticList.CRAFT_BLOCK_COUNT[Item.getId(this.item)], i);
/* 410 */     this.item.d(this, world, entityhuman);
/*     */   }
/*     */   
/*     */   public int n() {
/* 414 */     return getItem().d_(this);
/*     */   }
/*     */   
/*     */   public EnumAnimation o() {
/* 418 */     return getItem().d(this);
/*     */   }
/*     */   
/*     */   public void b(World world, EntityHuman entityhuman, int i) {
/* 422 */     getItem().a(this, world, entityhuman, i);
/*     */   }
/*     */   
/*     */   public boolean hasTag() {
/* 426 */     return (this.tag != null);
/*     */   }
/*     */   
/*     */   public NBTTagCompound getTag() {
/* 430 */     return this.tag;
/*     */   }
/*     */   
/*     */   public NBTTagList getEnchantments() {
/* 434 */     return (this.tag == null) ? null : this.tag.getList("ench", 10);
/*     */   }
/*     */   
/*     */   public void setTag(NBTTagCompound nbttagcompound) {
/* 438 */     this.tag = nbttagcompound;
/*     */   }
/*     */   
/*     */   public String getName() {
/* 442 */     String s = getItem().n(this);
/*     */     
/* 444 */     if (this.tag != null && this.tag.hasKeyOfType("display", 10)) {
/* 445 */       NBTTagCompound nbttagcompound = this.tag.getCompound("display");
/*     */       
/* 447 */       if (nbttagcompound.hasKeyOfType("Name", 8)) {
/* 448 */         s = nbttagcompound.getString("Name");
/*     */       }
/*     */     } 
/*     */     
/* 452 */     return s;
/*     */   }
/*     */   
/*     */   public ItemStack c(String s) {
/* 456 */     if (this.tag == null) {
/* 457 */       this.tag = new NBTTagCompound();
/*     */     }
/*     */     
/* 460 */     if (!this.tag.hasKeyOfType("display", 10)) {
/* 461 */       this.tag.set("display", new NBTTagCompound());
/*     */     }
/*     */     
/* 464 */     this.tag.getCompound("display").setString("Name", s);
/* 465 */     return this;
/*     */   }
/*     */   
/*     */   public void t() {
/* 469 */     if (this.tag != null && 
/* 470 */       this.tag.hasKeyOfType("display", 10)) {
/* 471 */       NBTTagCompound nbttagcompound = this.tag.getCompound("display");
/*     */       
/* 473 */       nbttagcompound.remove("Name");
/* 474 */       if (nbttagcompound.isEmpty()) {
/* 475 */         this.tag.remove("display");
/* 476 */         if (this.tag.isEmpty()) {
/* 477 */           setTag((NBTTagCompound)null);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasName() {
/* 485 */     return (this.tag == null) ? false : (!this.tag.hasKeyOfType("display", 10) ? false : this.tag.getCompound("display").hasKeyOfType("Name", 8));
/*     */   }
/*     */   
/*     */   public EnumItemRarity w() {
/* 489 */     return getItem().f(this);
/*     */   }
/*     */   
/*     */   public boolean x() {
/* 493 */     return !getItem().e_(this) ? false : (!hasEnchantments());
/*     */   }
/*     */   
/*     */   public void addEnchantment(Enchantment enchantment, int i) {
/* 497 */     if (this.tag == null) {
/* 498 */       setTag(new NBTTagCompound());
/*     */     }
/*     */     
/* 501 */     if (!this.tag.hasKeyOfType("ench", 9)) {
/* 502 */       this.tag.set("ench", new NBTTagList());
/*     */     }
/*     */     
/* 505 */     NBTTagList nbttaglist = this.tag.getList("ench", 10);
/* 506 */     NBTTagCompound nbttagcompound = new NBTTagCompound();
/*     */     
/* 508 */     nbttagcompound.setShort("id", (short)enchantment.id);
/* 509 */     nbttagcompound.setShort("lvl", (short)(byte)i);
/* 510 */     nbttaglist.add(nbttagcompound);
/*     */   }
/*     */   
/*     */   public boolean hasEnchantments() {
/* 514 */     return (this.tag != null && this.tag.hasKeyOfType("ench", 9));
/*     */   }
/*     */   
/*     */   public void a(String s, NBTBase nbtbase) {
/* 518 */     if (this.tag == null) {
/* 519 */       setTag(new NBTTagCompound());
/*     */     }
/*     */     
/* 522 */     this.tag.set(s, nbtbase);
/*     */   }
/*     */   
/*     */   public boolean z() {
/* 526 */     return getItem().v();
/*     */   }
/*     */   
/*     */   public boolean A() {
/* 530 */     return (this.g != null);
/*     */   }
/*     */   
/*     */   public void a(EntityItemFrame entityitemframe) {
/* 534 */     this.g = entityitemframe;
/*     */   }
/*     */   
/*     */   public EntityItemFrame B() {
/* 538 */     return this.g;
/*     */   }
/*     */   
/*     */   public int getRepairCost() {
/* 542 */     return (hasTag() && this.tag.hasKeyOfType("RepairCost", 3)) ? this.tag.getInt("RepairCost") : 0;
/*     */   }
/*     */   
/*     */   public void setRepairCost(int i) {
/* 546 */     if (!hasTag()) {
/* 547 */       this.tag = new NBTTagCompound();
/*     */     }
/*     */     
/* 550 */     this.tag.setInt("RepairCost", i);
/*     */   }
/*     */ 
/*     */   
/*     */   public Multimap D() {
/*     */     Object object;
/* 556 */     if (hasTag() && this.tag.hasKeyOfType("AttributeModifiers", 9)) {
/* 557 */       object = HashMultimap.create();
/* 558 */       NBTTagList nbttaglist = this.tag.getList("AttributeModifiers", 10);
/*     */       
/* 560 */       for (int i = 0; i < nbttaglist.size(); i++) {
/* 561 */         NBTTagCompound nbttagcompound = nbttaglist.get(i);
/* 562 */         AttributeModifier attributemodifier = GenericAttributes.a(nbttagcompound);
/*     */         
/* 564 */         if (attributemodifier.a().getLeastSignificantBits() != 0L && attributemodifier.a().getMostSignificantBits() != 0L) {
/* 565 */           ((Multimap)object).put(nbttagcompound.getString("AttributeName"), attributemodifier);
/*     */         }
/*     */       } 
/*     */     } else {
/* 569 */       object = getItem().k();
/*     */     } 
/*     */     
/* 572 */     return (Multimap)object;
/*     */   }
/*     */   
/*     */   public void setItem(Item item) {
/* 576 */     this.item = item;
/* 577 */     setData(getData());
/*     */   }
/*     */   
/*     */   public IChatBaseComponent E() {
/* 581 */     IChatBaseComponent ichatbasecomponent = (new ChatComponentText("[")).a(getName()).a("]");
/*     */     
/* 583 */     if (this.item != null) {
/* 584 */       NBTTagCompound nbttagcompound = new NBTTagCompound();
/*     */       
/* 586 */       save(nbttagcompound);
/* 587 */       ichatbasecomponent.getChatModifier().a(new ChatHoverable(EnumHoverAction.SHOW_ITEM, new ChatComponentText(nbttagcompound.toString())));
/* 588 */       ichatbasecomponent.getChatModifier().setColor((w()).e);
/*     */     } 
/*     */     
/* 591 */     return ichatbasecomponent;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\ItemStack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */