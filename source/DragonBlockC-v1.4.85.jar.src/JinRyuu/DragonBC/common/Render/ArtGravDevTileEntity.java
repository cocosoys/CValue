/*     */ package JinRyuu.DragonBC.common.Render;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import cpw.mods.fml.common.registry.GameRegistry;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.inventory.ISidedInventory;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemHoe;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.ItemSword;
/*     */ import net.minecraft.item.ItemTool;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.network.NetworkManager;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ 
/*     */ public class ArtGravDevTileEntity
/*     */   extends TileEntity
/*     */   implements ISidedInventory {
/*  32 */   private static final int[] slotsBottom = new int[] { 0 };
/*     */ 
/*     */   
/*  35 */   private ItemStack[] furnaceItemStacks = new ItemStack[1];
/*     */ 
/*     */   
/*     */   public int furnaceBurnTime;
/*     */ 
/*     */   
/*     */   public int currentItemBurnTime;
/*     */ 
/*     */   
/*     */   private String tileEntityName;
/*     */   
/*     */   public static final int itemFuel = 0;
/*     */ 
/*     */   
/*     */   public boolean canUpdate() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   private void writeSyncableDataToNBT(NBTTagCompound syncData) {
/*  54 */     syncData.func_74776_a("gravity", this.gravity);
/*     */   }
/*     */   private void readSyncableDataFromNBT(NBTTagCompound par1) {
/*  57 */     this.gravity = par1.func_74760_g("gravity");
/*     */   }
/*     */   
/*     */   public float getGravity() {
/*  61 */     return this.gravity;
/*     */   }
/*     */   
/*     */   public void setGravity(float gravity) {
/*  65 */     this.gravity = gravity;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  70 */   private float gravity = 1.0F;
/*     */   
/*     */   public int gravityDevCB;
/*     */ 
/*     */   
/*     */   public Packet func_145844_m() {
/*  76 */     NBTTagCompound syncData = new NBTTagCompound();
/*  77 */     writeSyncableDataToNBT(syncData);
/*  78 */     return (Packet)new S35PacketUpdateTileEntity(this.field_145851_c, this.field_145848_d, this.field_145849_e, 1, syncData);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
/*  83 */     readSyncableDataFromNBT(pkt.func_148857_g());
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
/*     */   public int func_70302_i_() {
/* 104 */     return this.furnaceItemStacks.length;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70301_a(int p_70301_1_) {
/* 112 */     return this.furnaceItemStacks[p_70301_1_];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70298_a(int p_70298_1_, int p_70298_2_) {
/* 121 */     if (this.furnaceItemStacks[p_70298_1_] != null) {
/*     */ 
/*     */ 
/*     */       
/* 125 */       if ((this.furnaceItemStacks[p_70298_1_]).field_77994_a <= p_70298_2_) {
/*     */         
/* 127 */         ItemStack itemStack = this.furnaceItemStacks[p_70298_1_];
/* 128 */         this.furnaceItemStacks[p_70298_1_] = null;
/* 129 */         return itemStack;
/*     */       } 
/*     */ 
/*     */       
/* 133 */       ItemStack itemstack = this.furnaceItemStacks[p_70298_1_].func_77979_a(p_70298_2_);
/*     */       
/* 135 */       if ((this.furnaceItemStacks[p_70298_1_]).field_77994_a == 0)
/*     */       {
/* 137 */         this.furnaceItemStacks[p_70298_1_] = null;
/*     */       }
/*     */       
/* 140 */       return itemstack;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 145 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70304_b(int p_70304_1_) {
/* 155 */     if (this.furnaceItemStacks[p_70304_1_] != null) {
/*     */       
/* 157 */       ItemStack itemstack = this.furnaceItemStacks[p_70304_1_];
/* 158 */       this.furnaceItemStacks[p_70304_1_] = null;
/* 159 */       return itemstack;
/*     */     } 
/*     */ 
/*     */     
/* 163 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70299_a(int p_70299_1_, ItemStack p_70299_2_) {
/* 172 */     this.furnaceItemStacks[p_70299_1_] = p_70299_2_;
/*     */     
/* 174 */     if (p_70299_2_ != null && p_70299_2_.field_77994_a > func_70297_j_())
/*     */     {
/* 176 */       p_70299_2_.field_77994_a = func_70297_j_();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_145825_b() {
/* 185 */     return func_145818_k_() ? this.tileEntityName : (BlocksDBC.ArtGravDevBlock.func_149739_a() + ".name");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_145818_k_() {
/* 193 */     return (this.tileEntityName != null && this.tileEntityName.length() > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_145951_a(String p_145951_1_) {
/* 198 */     this.tileEntityName = p_145951_1_;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_145839_a(NBTTagCompound p_145839_1_) {
/* 203 */     super.func_145839_a(p_145839_1_);
/* 204 */     readSyncableDataFromNBT(p_145839_1_);
/* 205 */     NBTTagList nbttaglist = p_145839_1_.func_150295_c("Items", 10);
/* 206 */     this.furnaceItemStacks = new ItemStack[func_70302_i_()];
/*     */     
/* 208 */     for (int i = 0; i < nbttaglist.func_74745_c(); i++) {
/*     */       
/* 210 */       NBTTagCompound nbttagcompound1 = nbttaglist.func_150305_b(i);
/* 211 */       byte b0 = nbttagcompound1.func_74771_c("Slot");
/*     */       
/* 213 */       if (b0 >= 0 && b0 < this.furnaceItemStacks.length)
/*     */       {
/* 215 */         this.furnaceItemStacks[b0] = ItemStack.func_77949_a(nbttagcompound1);
/*     */       }
/*     */     } 
/*     */     
/* 219 */     this.furnaceBurnTime = p_145839_1_.func_74765_d("BurnTime");
/*     */     
/* 221 */     this.currentItemBurnTime = getItemBurnTime(this.furnaceItemStacks[0]);
/*     */     
/* 223 */     if (p_145839_1_.func_150297_b("CustomName", 8))
/*     */     {
/* 225 */       this.tileEntityName = p_145839_1_.func_74779_i("CustomName");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_145841_b(NBTTagCompound p_145841_1_) {
/* 231 */     super.func_145841_b(p_145841_1_);
/* 232 */     writeSyncableDataToNBT(p_145841_1_);
/* 233 */     p_145841_1_.func_74777_a("BurnTime", (short)this.furnaceBurnTime);
/*     */     
/* 235 */     NBTTagList nbttaglist = new NBTTagList();
/*     */     
/* 237 */     for (int i = 0; i < this.furnaceItemStacks.length; i++) {
/*     */       
/* 239 */       if (this.furnaceItemStacks[i] != null) {
/*     */         
/* 241 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/* 242 */         nbttagcompound1.func_74774_a("Slot", (byte)i);
/* 243 */         this.furnaceItemStacks[i].func_77955_b(nbttagcompound1);
/* 244 */         nbttaglist.func_74742_a((NBTBase)nbttagcompound1);
/*     */       } 
/*     */     } 
/*     */     
/* 248 */     p_145841_1_.func_74782_a("Items", (NBTBase)nbttaglist);
/*     */     
/* 250 */     if (func_145818_k_())
/*     */     {
/* 252 */       p_145841_1_.func_74778_a("CustomName", this.tileEntityName);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70297_j_() {
/* 261 */     return 64;
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
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int getBurnTimeRemainingScaled(int p_145955_1_) {
/* 281 */     if (this.currentItemBurnTime == 0)
/*     */     {
/* 283 */       this.currentItemBurnTime = 200;
/*     */     }
/*     */     
/* 286 */     return this.furnaceBurnTime * p_145955_1_ / this.currentItemBurnTime;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBurning() {
/* 294 */     return (this.furnaceBurnTime > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_145845_h() {
/* 299 */     boolean flag = (this.furnaceBurnTime > 0);
/* 300 */     boolean flag1 = false;
/*     */     
/* 302 */     if (this.furnaceBurnTime > 0)
/*     */     {
/* 304 */       this.furnaceBurnTime--;
/*     */     }
/*     */     
/* 307 */     if (!this.field_145850_b.field_72995_K) {
/*     */       
/* 309 */       if (this.gravity > 1.0F && isBurning()) {
/* 310 */         this.gravityDevCB--;
/* 311 */         if (this.gravityDevCB <= 0) {
/* 312 */           this.gravityDevCB = 20;
/*     */           
/* 314 */           int n = 10;
/* 315 */           AxisAlignedBB aabb = AxisAlignedBB.func_72330_a(this.field_145851_c - n, this.field_145848_d - n, this.field_145849_e - n, this.field_145851_c + n, this.field_145848_d + n, this.field_145849_e + n);
/* 316 */           List<EntityPlayer> list = this.field_145850_b.func_72872_a(EntityPlayer.class, aabb);
/* 317 */           if (!list.isEmpty())
/*     */           {
/* 319 */             for (int i = 0; i < list.size(); i++) {
/*     */               
/* 321 */               EntityPlayer player = list.get(i);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 327 */               int epoch = (int)(System.currentTimeMillis() / 1000L) + 1;
/* 328 */               JRMCoreH.setInt(epoch, player, "jrmcGravZoneLast");
/* 329 */               float G = JRMCoreH.getFloat(player, "jrmcGravForce");
/* 330 */               if (this.gravity > G) JRMCoreH.setFloat(this.gravity, player, "jrmcGravForce"); 
/*     */             } 
/*     */           }
/*     */         } 
/*     */       } 
/* 335 */       if (this.furnaceBurnTime != 0 || this.furnaceItemStacks[0] != null)
/*     */       {
/* 337 */         if (this.furnaceBurnTime == 0 && canSmelt()) {
/*     */           
/* 339 */           this.currentItemBurnTime = this.furnaceBurnTime = getItemBurnTime(this.furnaceItemStacks[0]);
/*     */           
/* 341 */           if (this.furnaceBurnTime > 0) {
/*     */             
/* 343 */             flag1 = true;
/*     */             
/* 345 */             if (this.furnaceItemStacks[0] != null) {
/*     */               
/* 347 */               (this.furnaceItemStacks[0]).field_77994_a--;
/*     */               
/* 349 */               if ((this.furnaceItemStacks[0]).field_77994_a == 0)
/*     */               {
/* 351 */                 this.furnaceItemStacks[0] = this.furnaceItemStacks[0].func_77973_b().getContainerItem(this.furnaceItemStacks[0]);
/*     */               }
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       }
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
/* 375 */       if (flag != ((this.furnaceBurnTime > 0))) {
/*     */         
/* 377 */         flag1 = true;
/* 378 */         ArtGravDevBlock.updateFurnaceBlockState((this.furnaceBurnTime > 0), this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 383 */     if (flag1)
/*     */     {
/* 385 */       func_70296_d();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean canSmelt() {
/* 394 */     if (this.furnaceItemStacks[0] == null)
/*     */     {
/* 396 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 400 */     if (this.gravity > 1.0F)
/* 401 */       return true; 
/* 402 */     return false;
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
/*     */   public void smeltItem() {
/* 417 */     if (canSmelt())
/*     */     {
/* 419 */       if (this.gravity > 1.0F) {
/* 420 */         this.gravityDevCB--;
/* 421 */         if (this.gravityDevCB <= 0) {
/* 422 */           this.gravityDevCB = 20;
/* 423 */           int n = 10;
/* 424 */           AxisAlignedBB aabb = AxisAlignedBB.func_72330_a(this.field_145851_c - n, this.field_145848_d - n, this.field_145849_e - n, this.field_145851_c + n, this.field_145848_d + n, this.field_145849_e + n);
/* 425 */           List<EntityPlayer> list = this.field_145850_b.func_72872_a(EntityPlayer.class, aabb);
/* 426 */           if (!list.isEmpty())
/*     */           {
/* 428 */             for (int i = 0; i < list.size(); i++) {
/*     */               
/* 430 */               EntityPlayer player = list.get(i);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 436 */               int epoch = (int)(System.currentTimeMillis() / 1000L) + 1;
/* 437 */               JRMCoreH.setInt(epoch, player, "jrmcGravZoneLast");
/* 438 */               float G = JRMCoreH.getFloat(player, "jrmcGravForce");
/* 439 */               if (this.gravity > G) JRMCoreH.setFloat(this.gravity, player, "jrmcGravForce");
/*     */             
/*     */             } 
/*     */           }
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getItemBurnTime(ItemStack p_145952_0_) {
/* 453 */     if (p_145952_0_ == null)
/*     */     {
/* 455 */       return 0;
/*     */     }
/*     */ 
/*     */     
/* 459 */     Item item = p_145952_0_.func_77973_b();
/*     */     
/* 461 */     if (item instanceof net.minecraft.item.ItemBlock && Block.func_149634_a(item) != Blocks.field_150350_a) {
/*     */       
/* 463 */       Block block = Block.func_149634_a(item);
/*     */       
/* 465 */       if (block == Blocks.field_150376_bx)
/*     */       {
/* 467 */         return 150;
/*     */       }
/*     */       
/* 470 */       if (block.func_149688_o() == Material.field_151575_d)
/*     */       {
/* 472 */         return 300;
/*     */       }
/*     */       
/* 475 */       if (block == Blocks.field_150402_ci)
/*     */       {
/* 477 */         return 16000;
/*     */       }
/*     */     } 
/*     */     
/* 481 */     if (item instanceof ItemTool && ((ItemTool)item).func_77861_e().equals("WOOD")) return 200; 
/* 482 */     if (item instanceof ItemSword && ((ItemSword)item).func_150932_j().equals("WOOD")) return 200; 
/* 483 */     if (item instanceof ItemHoe && ((ItemHoe)item).func_77842_f().equals("WOOD")) return 200; 
/* 484 */     if (item == Items.field_151055_y) return 100; 
/* 485 */     if (item == Items.field_151044_h) return 1600; 
/* 486 */     if (item == Items.field_151129_at) return 20000; 
/* 487 */     if (item == Item.func_150898_a(Blocks.field_150345_g)) return 100; 
/* 488 */     if (item == Items.field_151072_bj) return 2400; 
/* 489 */     return GameRegistry.getFuelValue(p_145952_0_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isItemFuel(ItemStack p_145954_0_) {
/* 499 */     return (getItemBurnTime(p_145954_0_) > 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70300_a(EntityPlayer p_70300_1_) {
/* 507 */     return (this.field_145850_b.func_147438_o(this.field_145851_c, this.field_145848_d, this.field_145849_e) != this) ? false : ((p_70300_1_.func_70092_e(this.field_145851_c + 0.5D, this.field_145848_d + 0.5D, this.field_145849_e + 0.5D) <= 64.0D));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70295_k_() {}
/*     */ 
/*     */   
/*     */   public void func_70305_f() {}
/*     */ 
/*     */   
/*     */   public boolean func_94041_b(int p_94041_1_, ItemStack p_94041_2_) {
/* 519 */     return (p_94041_1_ == 2) ? false : ((p_94041_1_ == 1) ? isItemFuel(p_94041_2_) : true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] func_94128_d(int p_94128_1_) {
/* 528 */     return slotsBottom;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_102007_a(int p_102007_1_, ItemStack p_102007_2_, int p_102007_3_) {
/* 537 */     return func_94041_b(p_102007_1_, p_102007_2_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_102008_b(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
/* 546 */     return (p_102008_3_ != 0 || p_102008_1_ != 1 || p_102008_2_.func_77973_b() == Items.field_151133_ar);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Render\ArtGravDevTileEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */