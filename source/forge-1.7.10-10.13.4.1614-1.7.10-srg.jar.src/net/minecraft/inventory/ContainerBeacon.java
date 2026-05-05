/*     */ package net.minecraft.inventory;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntityBeacon;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ContainerBeacon
/*     */   extends Container
/*     */ {
/*     */   private TileEntityBeacon field_82866_e;
/*     */   private final BeaconSlot field_82864_f;
/*     */   private int field_82865_g;
/*     */   private int field_82867_h;
/*     */   private int field_82868_i;
/*     */   private static final String __OBFID = "CL_00001735";
/*     */   
/*     */   public ContainerBeacon(InventoryPlayer p_i1802_1_, TileEntityBeacon p_i1802_2_) {
/*  25 */     this.field_82866_e = p_i1802_2_;
/*     */     
/*  27 */     func_75146_a(this.field_82864_f = new BeaconSlot(this, (IInventory)p_i1802_2_, 0, 136, 110));
/*     */     
/*  29 */     byte b1 = 36;
/*  30 */     char c = '';
/*     */     byte b2;
/*  32 */     for (b2 = 0; b2 < 3; b2++) {
/*  33 */       for (byte b = 0; b < 9; b++) {
/*  34 */         func_75146_a(new Slot((IInventory)p_i1802_1_, b + b2 * 9 + 9, b1 + b * 18, c + b2 * 18));
/*     */       }
/*     */     } 
/*  37 */     for (b2 = 0; b2 < 9; b2++) {
/*  38 */       func_75146_a(new Slot((IInventory)p_i1802_1_, b2, b1 + b2 * 18, 58 + c));
/*     */     }
/*     */     
/*  41 */     this.field_82865_g = p_i1802_2_.func_145998_l();
/*  42 */     this.field_82867_h = p_i1802_2_.func_146007_j();
/*  43 */     this.field_82868_i = p_i1802_2_.func_146006_k();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75132_a(ICrafting p_75132_1_) {
/*  49 */     super.func_75132_a(p_75132_1_);
/*     */     
/*  51 */     p_75132_1_.func_71112_a(this, 0, this.field_82865_g);
/*  52 */     p_75132_1_.func_71112_a(this, 1, this.field_82867_h);
/*  53 */     p_75132_1_.func_71112_a(this, 2, this.field_82868_i);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_75137_b(int p_75137_1_, int p_75137_2_) {
/*  58 */     if (p_75137_1_ == 0) this.field_82866_e.func_146005_c(p_75137_2_); 
/*  59 */     if (p_75137_1_ == 1) this.field_82866_e.func_146001_d(p_75137_2_); 
/*  60 */     if (p_75137_1_ == 2) this.field_82866_e.func_146004_e(p_75137_2_); 
/*     */   }
/*     */   
/*     */   public TileEntityBeacon func_148327_e() {
/*  64 */     return this.field_82866_e;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_75145_c(EntityPlayer p_75145_1_) {
/*  69 */     return this.field_82866_e.func_70300_a(p_75145_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_82846_b(EntityPlayer p_82846_1_, int p_82846_2_) {
/*  74 */     ItemStack itemStack = null;
/*  75 */     Slot slot = this.field_75151_b.get(p_82846_2_);
/*  76 */     if (slot != null && slot.func_75216_d()) {
/*  77 */       ItemStack itemStack1 = slot.func_75211_c();
/*  78 */       itemStack = itemStack1.func_77946_l();
/*     */       
/*  80 */       if (p_82846_2_ == 0) {
/*  81 */         if (!func_75135_a(itemStack1, 1, 37, true)) {
/*  82 */           return null;
/*     */         }
/*  84 */         slot.func_75220_a(itemStack1, itemStack);
/*  85 */       } else if (!this.field_82864_f.func_75216_d() && this.field_82864_f.func_75214_a(itemStack1) && itemStack1.field_77994_a == 1) {
/*  86 */         if (!func_75135_a(itemStack1, 0, 1, false)) {
/*  87 */           return null;
/*     */         }
/*  89 */       } else if (p_82846_2_ >= 1 && p_82846_2_ < 28) {
/*  90 */         if (!func_75135_a(itemStack1, 28, 37, false)) {
/*  91 */           return null;
/*     */         }
/*  93 */       } else if (p_82846_2_ >= 28 && p_82846_2_ < 37) {
/*  94 */         if (!func_75135_a(itemStack1, 1, 28, false)) {
/*  95 */           return null;
/*     */         }
/*     */       }
/*  98 */       else if (!func_75135_a(itemStack1, 1, 37, false)) {
/*  99 */         return null;
/*     */       } 
/*     */       
/* 102 */       if (itemStack1.field_77994_a == 0) {
/* 103 */         slot.func_75215_d(null);
/*     */       } else {
/* 105 */         slot.func_75218_e();
/*     */       } 
/* 107 */       if (itemStack1.field_77994_a == itemStack.field_77994_a) {
/* 108 */         return null;
/*     */       }
/* 110 */       slot.func_82870_a(p_82846_1_, itemStack1);
/*     */     } 
/*     */     
/* 113 */     return itemStack;
/*     */   }
/*     */   
/*     */   class BeaconSlot extends Slot {
/*     */     public BeaconSlot(ContainerBeacon p_i1801_1_, IInventory p_i1801_2_, int p_i1801_3_, int p_i1801_4_, int p_i1801_5_) {
/* 118 */       super(p_i1801_2_, p_i1801_3_, p_i1801_4_, p_i1801_5_);
/*     */     }
/*     */     private static final String __OBFID = "CL_00001736";
/*     */     
/*     */     public boolean func_75214_a(ItemStack p_75214_1_) {
/* 123 */       if (p_75214_1_ != null) {
/* 124 */         return (p_75214_1_.func_77973_b() == Items.field_151166_bC || p_75214_1_.func_77973_b() == Items.field_151045_i || p_75214_1_.func_77973_b() == Items.field_151043_k || p_75214_1_.func_77973_b() == Items.field_151042_j);
/*     */       }
/* 126 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public int func_75219_a() {
/* 131 */       return 1;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\inventory\ContainerBeacon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */