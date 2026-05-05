/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.entity.CraftHumanEntity;
/*     */ import org.bukkit.entity.HumanEntity;
/*     */ 
/*     */ public class TileEntityBeacon
/*     */   extends TileEntity
/*     */   implements IInventory
/*     */ {
/*  13 */   public static final MobEffectList[][] a = new MobEffectList[][] { { MobEffectList.FASTER_MOVEMENT, MobEffectList.FASTER_DIG }, { MobEffectList.RESISTANCE, MobEffectList.JUMP }, { MobEffectList.INCREASE_DAMAGE }, { MobEffectList.REGENERATION } };
/*     */   private boolean k;
/*  15 */   private int l = -1;
/*     */   
/*     */   private int m;
/*     */   private int n;
/*     */   private ItemStack inventorySlot;
/*     */   private String p;
/*  21 */   public List<HumanEntity> transaction = new ArrayList<HumanEntity>();
/*  22 */   private int maxStack = 64;
/*     */   
/*     */   public ItemStack[] getContents() {
/*  25 */     return new ItemStack[] { this.inventorySlot };
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
/*     */   public void h() {
/*  48 */     if (this.world.getTime() % 80L == 0L) {
/*  49 */       y();
/*  50 */       x();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void x() {
/*  55 */     if (this.k && this.l > 0 && !this.world.isStatic && this.m > 0) {
/*  56 */       double d0 = (this.l * 10 + 10);
/*  57 */       byte b0 = 0;
/*     */       
/*  59 */       if (this.l >= 4 && this.m == this.n) {
/*  60 */         b0 = 1;
/*     */       }
/*     */       
/*  63 */       AxisAlignedBB axisalignedbb = AxisAlignedBB.a(this.x, this.y, this.z, (this.x + 1), (this.y + 1), (this.z + 1)).grow(d0, d0, d0);
/*     */       
/*  65 */       axisalignedbb.e = this.world.getHeight();
/*  66 */       List<EntityHuman> list = this.world.a(EntityHuman.class, axisalignedbb);
/*  67 */       Iterator<EntityHuman> iterator = list.iterator();
/*     */ 
/*     */ 
/*     */       
/*  71 */       while (iterator.hasNext()) {
/*  72 */         EntityHuman entityhuman = iterator.next();
/*  73 */         entityhuman.addEffect(new MobEffect(this.m, 180, b0, true));
/*     */       } 
/*     */       
/*  76 */       if (this.l >= 4 && this.m != this.n && this.n > 0) {
/*  77 */         iterator = list.iterator();
/*     */         
/*  79 */         while (iterator.hasNext()) {
/*  80 */           EntityHuman entityhuman = iterator.next();
/*  81 */           entityhuman.addEffect(new MobEffect(this.n, 180, 0, true));
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void y() {
/*  88 */     int i = this.l;
/*     */     
/*  90 */     if (!this.world.i(this.x, this.y + 1, this.z)) {
/*  91 */       this.k = false;
/*  92 */       this.l = 0;
/*     */     } else {
/*  94 */       this.k = true;
/*  95 */       this.l = 0;
/*     */       
/*  97 */       for (int j = 1; j <= 4; this.l = j++) {
/*  98 */         int k = this.y - j;
/*     */         
/* 100 */         if (k < 0) {
/*     */           break;
/*     */         }
/*     */         
/* 104 */         boolean flag = true;
/*     */         
/* 106 */         for (int l = this.x - j; l <= this.x + j && flag; l++) {
/* 107 */           for (int i1 = this.z - j; i1 <= this.z + j; i1++) {
/* 108 */             Block block = this.world.getType(l, k, i1);
/*     */             
/* 110 */             if (block != Blocks.EMERALD_BLOCK && block != Blocks.GOLD_BLOCK && block != Blocks.DIAMOND_BLOCK && block != Blocks.IRON_BLOCK) {
/* 111 */               flag = false;
/*     */               
/*     */               break;
/*     */             } 
/*     */           } 
/*     */         } 
/* 117 */         if (!flag) {
/*     */           break;
/*     */         }
/*     */       } 
/*     */       
/* 122 */       if (this.l == 0) {
/* 123 */         this.k = false;
/*     */       }
/*     */     } 
/*     */     
/* 127 */     if (!this.world.isStatic && this.l == 4 && i < this.l) {
/* 128 */       Iterator<EntityHuman> iterator = this.world.a(EntityHuman.class, AxisAlignedBB.a(this.x, this.y, this.z, this.x, (this.y - 4), this.z).grow(10.0D, 5.0D, 10.0D)).iterator();
/*     */       
/* 130 */       while (iterator.hasNext()) {
/* 131 */         EntityHuman entityhuman = iterator.next();
/*     */         
/* 133 */         entityhuman.a(AchievementList.K);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public int j() {
/* 139 */     return this.m;
/*     */   }
/*     */   
/*     */   public int k() {
/* 143 */     return this.n;
/*     */   }
/*     */   
/*     */   public int l() {
/* 147 */     return this.l;
/*     */   }
/*     */   
/*     */   public void d(int i) {
/* 151 */     this.m = 0;
/*     */     
/* 153 */     for (int j = 0; j < this.l && j < 3; j++) {
/* 154 */       MobEffectList[] amobeffectlist = a[j];
/* 155 */       int k = amobeffectlist.length;
/*     */       
/* 157 */       for (int l = 0; l < k; l++) {
/* 158 */         MobEffectList mobeffectlist = amobeffectlist[l];
/*     */         
/* 160 */         if (mobeffectlist.id == i) {
/* 161 */           this.m = i;
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void e(int i) {
/* 169 */     this.n = 0;
/* 170 */     if (this.l >= 4) {
/* 171 */       for (int j = 0; j < 4; j++) {
/* 172 */         MobEffectList[] amobeffectlist = a[j];
/* 173 */         int k = amobeffectlist.length;
/*     */         
/* 175 */         for (int l = 0; l < k; l++) {
/* 176 */           MobEffectList mobeffectlist = amobeffectlist[l];
/*     */           
/* 178 */           if (mobeffectlist.id == i) {
/* 179 */             this.n = i;
/*     */             return;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public Packet getUpdatePacket() {
/* 188 */     NBTTagCompound nbttagcompound = new NBTTagCompound();
/*     */     
/* 190 */     b(nbttagcompound);
/* 191 */     return new PacketPlayOutTileEntityData(this.x, this.y, this.z, 3, nbttagcompound);
/*     */   }
/*     */   
/*     */   public void a(NBTTagCompound nbttagcompound) {
/* 195 */     super.a(nbttagcompound);
/* 196 */     this.m = nbttagcompound.getInt("Primary");
/* 197 */     this.n = nbttagcompound.getInt("Secondary");
/* 198 */     this.l = nbttagcompound.getInt("Levels");
/*     */   }
/*     */   
/*     */   public void b(NBTTagCompound nbttagcompound) {
/* 202 */     super.b(nbttagcompound);
/* 203 */     nbttagcompound.setInt("Primary", this.m);
/* 204 */     nbttagcompound.setInt("Secondary", this.n);
/* 205 */     nbttagcompound.setInt("Levels", this.l);
/*     */   }
/*     */   
/*     */   public int getSize() {
/* 209 */     return 1;
/*     */   }
/*     */   
/*     */   public ItemStack getItem(int i) {
/* 213 */     return (i == 0) ? this.inventorySlot : null;
/*     */   }
/*     */   
/*     */   public ItemStack splitStack(int i, int j) {
/* 217 */     if (i == 0 && this.inventorySlot != null) {
/* 218 */       if (j >= this.inventorySlot.count) {
/* 219 */         ItemStack itemstack = this.inventorySlot;
/*     */         
/* 221 */         this.inventorySlot = null;
/* 222 */         return itemstack;
/*     */       } 
/* 224 */       this.inventorySlot.count -= j;
/* 225 */       return new ItemStack(this.inventorySlot.getItem(), j, this.inventorySlot.getData());
/*     */     } 
/*     */     
/* 228 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack splitWithoutUpdate(int i) {
/* 233 */     if (i == 0 && this.inventorySlot != null) {
/* 234 */       ItemStack itemstack = this.inventorySlot;
/*     */       
/* 236 */       this.inventorySlot = null;
/* 237 */       return itemstack;
/*     */     } 
/* 239 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setItem(int i, ItemStack itemstack) {
/* 244 */     if (i == 0) {
/* 245 */       this.inventorySlot = itemstack;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getInventoryName() {
/* 250 */     return k_() ? this.p : "container.beacon";
/*     */   }
/*     */   
/*     */   public boolean k_() {
/* 254 */     return (this.p != null && this.p.length() > 0);
/*     */   }
/*     */   
/*     */   public void a(String s) {
/* 258 */     this.p = s;
/*     */   }
/*     */   
/*     */   public int getMaxStackSize() {
/* 262 */     return this.maxStack;
/*     */   }
/*     */   
/*     */   public boolean a(EntityHuman entityhuman) {
/* 266 */     return (this.world.getTileEntity(this.x, this.y, this.z) != this) ? false : ((entityhuman.e(this.x + 0.5D, this.y + 0.5D, this.z + 0.5D) <= 64.0D));
/*     */   }
/*     */   
/*     */   public void startOpen() {}
/*     */   
/*     */   public void closeContainer() {}
/*     */   
/*     */   public boolean b(int i, ItemStack itemstack) {
/* 274 */     return (itemstack.getItem() == Items.EMERALD || itemstack.getItem() == Items.DIAMOND || itemstack.getItem() == Items.GOLD_INGOT || itemstack.getItem() == Items.IRON_INGOT);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\TileEntityBeacon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */