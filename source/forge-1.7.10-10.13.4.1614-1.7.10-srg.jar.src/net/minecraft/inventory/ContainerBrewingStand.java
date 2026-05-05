/*     */ package net.minecraft.inventory;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.stats.AchievementList;
/*     */ import net.minecraft.stats.StatBase;
/*     */ import net.minecraft.tileentity.TileEntityBrewingStand;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ContainerBrewingStand
/*     */   extends Container
/*     */ {
/*     */   private TileEntityBrewingStand field_75188_e;
/*     */   private final Slot field_75186_f;
/*     */   private int field_75187_g;
/*     */   private static final String __OBFID = "CL_00001737";
/*     */   
/*     */   public ContainerBrewingStand(InventoryPlayer p_i1805_1_, TileEntityBrewingStand p_i1805_2_) {
/*  24 */     this.field_75188_e = p_i1805_2_;
/*     */     
/*  26 */     func_75146_a(new Potion(p_i1805_1_.field_70458_d, (IInventory)p_i1805_2_, 0, 56, 46));
/*  27 */     func_75146_a(new Potion(p_i1805_1_.field_70458_d, (IInventory)p_i1805_2_, 1, 79, 53));
/*  28 */     func_75146_a(new Potion(p_i1805_1_.field_70458_d, (IInventory)p_i1805_2_, 2, 102, 46));
/*  29 */     this.field_75186_f = func_75146_a(new Ingredient(this, (IInventory)p_i1805_2_, 3, 79, 17));
/*     */     byte b;
/*  31 */     for (b = 0; b < 3; b++) {
/*  32 */       for (byte b1 = 0; b1 < 9; b1++) {
/*  33 */         func_75146_a(new Slot((IInventory)p_i1805_1_, b1 + b * 9 + 9, 8 + b1 * 18, 84 + b * 18));
/*     */       }
/*     */     } 
/*  36 */     for (b = 0; b < 9; b++) {
/*  37 */       func_75146_a(new Slot((IInventory)p_i1805_1_, b, 8 + b * 18, 142));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75132_a(ICrafting p_75132_1_) {
/*  45 */     super.func_75132_a(p_75132_1_);
/*  46 */     p_75132_1_.func_71112_a(this, 0, this.field_75188_e.func_145935_i());
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_75142_b() {
/*  51 */     super.func_75142_b();
/*     */     
/*  53 */     for (byte b = 0; b < this.field_75149_d.size(); b++) {
/*  54 */       ICrafting iCrafting = this.field_75149_d.get(b);
/*  55 */       if (this.field_75187_g != this.field_75188_e.func_145935_i()) {
/*  56 */         iCrafting.func_71112_a(this, 0, this.field_75188_e.func_145935_i());
/*     */       }
/*     */     } 
/*  59 */     this.field_75187_g = this.field_75188_e.func_145935_i();
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_75137_b(int p_75137_1_, int p_75137_2_) {
/*  64 */     if (p_75137_1_ == 0) this.field_75188_e.func_145938_d(p_75137_2_);
/*     */   
/*     */   }
/*     */   
/*     */   public boolean func_75145_c(EntityPlayer p_75145_1_) {
/*  69 */     return this.field_75188_e.func_70300_a(p_75145_1_);
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
/*  80 */       if ((p_82846_2_ >= 0 && p_82846_2_ <= 2) || p_82846_2_ == 3) {
/*  81 */         if (!func_75135_a(itemStack1, 4, 40, true)) {
/*  82 */           return null;
/*     */         }
/*  84 */         slot.func_75220_a(itemStack1, itemStack);
/*  85 */       } else if (!this.field_75186_f.func_75216_d() && this.field_75186_f.func_75214_a(itemStack1)) {
/*  86 */         if (!func_75135_a(itemStack1, 3, 4, false)) {
/*  87 */           return null;
/*     */         }
/*  89 */       } else if (Potion.func_75243_a_(itemStack)) {
/*  90 */         if (!func_75135_a(itemStack1, 0, 3, false)) {
/*  91 */           return null;
/*     */         }
/*  93 */       } else if (p_82846_2_ >= 4 && p_82846_2_ < 31) {
/*  94 */         if (!func_75135_a(itemStack1, 31, 40, false)) {
/*  95 */           return null;
/*     */         }
/*  97 */       } else if (p_82846_2_ >= 31 && p_82846_2_ < 40) {
/*  98 */         if (!func_75135_a(itemStack1, 4, 31, false)) {
/*  99 */           return null;
/*     */         }
/*     */       }
/* 102 */       else if (!func_75135_a(itemStack1, 4, 40, false)) {
/* 103 */         return null;
/*     */       } 
/*     */       
/* 106 */       if (itemStack1.field_77994_a == 0) {
/* 107 */         slot.func_75215_d(null);
/*     */       } else {
/* 109 */         slot.func_75218_e();
/*     */       } 
/* 111 */       if (itemStack1.field_77994_a == itemStack.field_77994_a) {
/* 112 */         return null;
/*     */       }
/* 114 */       slot.func_82870_a(p_82846_1_, itemStack1);
/*     */     } 
/*     */     
/* 117 */     return itemStack;
/*     */   }
/*     */   
/*     */   static class Potion
/*     */     extends Slot {
/*     */     private EntityPlayer field_75244_a;
/*     */     
/*     */     public Potion(EntityPlayer p_i1804_1_, IInventory p_i1804_2_, int p_i1804_3_, int p_i1804_4_, int p_i1804_5_) {
/* 125 */       super(p_i1804_2_, p_i1804_3_, p_i1804_4_, p_i1804_5_);
/* 126 */       this.field_75244_a = p_i1804_1_;
/*     */     }
/*     */     private static final String __OBFID = "CL_00001740";
/*     */     
/*     */     public boolean func_75214_a(ItemStack p_75214_1_) {
/* 131 */       return func_75243_a_(p_75214_1_);
/*     */     }
/*     */ 
/*     */     
/*     */     public int func_75219_a() {
/* 136 */       return 1;
/*     */     }
/*     */ 
/*     */     
/*     */     public void func_82870_a(EntityPlayer p_82870_1_, ItemStack p_82870_2_) {
/* 141 */       if (p_82870_2_.func_77973_b() == Items.field_151068_bn && p_82870_2_.func_77960_j() > 0) this.field_75244_a.func_71064_a((StatBase)AchievementList.field_76001_A, 1); 
/* 142 */       super.func_82870_a(p_82870_1_, p_82870_2_);
/*     */     }
/*     */     
/*     */     public static boolean func_75243_a_(ItemStack p_75243_0_) {
/* 146 */       return (p_75243_0_ != null && (p_75243_0_.func_77973_b() == Items.field_151068_bn || p_75243_0_.func_77973_b() == Items.field_151069_bo));
/*     */     }
/*     */   }
/*     */   
/*     */   class Ingredient extends Slot {
/*     */     public Ingredient(ContainerBrewingStand p_i1803_1_, IInventory p_i1803_2_, int p_i1803_3_, int p_i1803_4_, int p_i1803_5_) {
/* 152 */       super(p_i1803_2_, p_i1803_3_, p_i1803_4_, p_i1803_5_);
/*     */     }
/*     */     private static final String __OBFID = "CL_00001738";
/*     */     
/*     */     public boolean func_75214_a(ItemStack p_75214_1_) {
/* 157 */       if (p_75214_1_ != null)
/*     */       {
/* 159 */         return p_75214_1_.func_77973_b().func_150892_m(p_75214_1_);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 164 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public int func_75219_a() {
/* 169 */       return 64;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\inventory\ContainerBrewingStand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */