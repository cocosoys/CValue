/*     */ package net.minecraft.inventory;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemArmor;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.crafting.CraftingManager;
/*     */ import net.minecraft.util.IIcon;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ContainerPlayer
/*     */   extends Container
/*     */ {
/*  22 */   public InventoryCrafting field_75181_e = new InventoryCrafting(this, 2, 2);
/*  23 */   public IInventory field_75179_f = new InventoryCraftResult();
/*     */   
/*     */   public boolean field_75180_g;
/*     */   
/*     */   public ContainerPlayer(InventoryPlayer p_i1819_1_, boolean p_i1819_2_, EntityPlayer p_i1819_3_) {
/*  28 */     this.field_75180_g = p_i1819_2_;
/*  29 */     this.field_82862_h = p_i1819_3_;
/*  30 */     func_75146_a(new SlotCrafting(p_i1819_1_.field_70458_d, this.field_75181_e, this.field_75179_f, 0, 144, 36));
/*     */     byte b;
/*  32 */     for (b = 0; b < 2; b++) {
/*  33 */       for (byte b1 = 0; b1 < 2; b1++) {
/*  34 */         func_75146_a(new Slot(this.field_75181_e, b1 + b * 2, 88 + b1 * 18, 26 + b * 18));
/*     */       }
/*     */     } 
/*     */     
/*  38 */     for (b = 0; b < 4; b++) {
/*  39 */       byte b1 = b;
/*  40 */       func_75146_a(new Slot(this, (IInventory)p_i1819_1_, p_i1819_1_.func_70302_i_() - 1 - b, 8, 8 + b * 18, b1) { private static final String __OBFID = "CL_00001755";
/*     */             
/*     */             public int func_75219_a() {
/*  43 */               return 1;
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean func_75214_a(ItemStack p_75214_1_) {
/*  48 */               if (p_75214_1_ == null) {
/*  49 */                 return false;
/*     */               }
/*  51 */               if (p_75214_1_.func_77973_b() instanceof ItemArmor) {
/*  52 */                 return (((ItemArmor)p_75214_1_.func_77973_b()).field_77881_a == this.field_75236_a);
/*     */               }
/*  54 */               if (p_75214_1_.func_77973_b() == Item.func_150898_a(Blocks.field_150423_aK) || p_75214_1_.func_77973_b() == Items.field_151144_bL) {
/*  55 */                 return (this.field_75236_a == 0);
/*     */               }
/*  57 */               return false;
/*     */             }
/*     */             
/*     */             @SideOnly(Side.CLIENT)
/*     */             public IIcon func_75212_b() {
/*  62 */               return ItemArmor.func_94602_b(this.field_75236_a);
/*     */             } }
/*     */         );
/*     */     } 
/*  66 */     for (b = 0; b < 3; b++) {
/*  67 */       for (byte b1 = 0; b1 < 9; b1++) {
/*  68 */         func_75146_a(new Slot((IInventory)p_i1819_1_, b1 + (b + 1) * 9, 8 + b1 * 18, 84 + b * 18));
/*     */       }
/*     */     } 
/*  71 */     for (b = 0; b < 9; b++) {
/*  72 */       func_75146_a(new Slot((IInventory)p_i1819_1_, b, 8 + b * 18, 142));
/*     */     }
/*     */     
/*  75 */     func_75130_a(this.field_75181_e);
/*     */   } private final EntityPlayer field_82862_h;
/*     */   private static final String __OBFID = "CL_00001754";
/*     */   
/*     */   public void func_75130_a(IInventory p_75130_1_) {
/*  80 */     this.field_75179_f.func_70299_a(0, CraftingManager.func_77594_a().func_82787_a(this.field_75181_e, this.field_82862_h.field_70170_p));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_75134_a(EntityPlayer p_75134_1_) {
/*  85 */     super.func_75134_a(p_75134_1_);
/*  86 */     for (byte b = 0; b < 4; b++) {
/*  87 */       ItemStack itemStack = this.field_75181_e.func_70304_b(b);
/*  88 */       if (itemStack != null) {
/*  89 */         p_75134_1_.func_71019_a(itemStack, false);
/*     */       }
/*     */     } 
/*  92 */     this.field_75179_f.func_70299_a(0, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_75145_c(EntityPlayer p_75145_1_) {
/*  97 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_82846_b(EntityPlayer p_82846_1_, int p_82846_2_) {
/* 102 */     ItemStack itemStack = null;
/* 103 */     Slot slot = this.field_75151_b.get(p_82846_2_);
/* 104 */     if (slot != null && slot.func_75216_d()) {
/* 105 */       ItemStack itemStack1 = slot.func_75211_c();
/* 106 */       itemStack = itemStack1.func_77946_l();
/*     */       
/* 108 */       if (p_82846_2_ == 0) {
/* 109 */         if (!func_75135_a(itemStack1, 9, 45, true)) {
/* 110 */           return null;
/*     */         }
/* 112 */         slot.func_75220_a(itemStack1, itemStack);
/* 113 */       } else if (p_82846_2_ >= 1 && p_82846_2_ < 5) {
/* 114 */         if (!func_75135_a(itemStack1, 9, 45, false)) {
/* 115 */           return null;
/*     */         }
/* 117 */       } else if (p_82846_2_ >= 5 && p_82846_2_ < 9) {
/* 118 */         if (!func_75135_a(itemStack1, 9, 45, false)) {
/* 119 */           return null;
/*     */         }
/* 121 */       } else if (itemStack.func_77973_b() instanceof ItemArmor && !((Slot)this.field_75151_b.get(5 + ((ItemArmor)itemStack.func_77973_b()).field_77881_a)).func_75216_d()) {
/* 122 */         int i = 5 + ((ItemArmor)itemStack.func_77973_b()).field_77881_a;
/* 123 */         if (!func_75135_a(itemStack1, i, i + 1, false)) {
/* 124 */           return null;
/*     */         }
/* 126 */       } else if (p_82846_2_ >= 9 && p_82846_2_ < 36) {
/* 127 */         if (!func_75135_a(itemStack1, 36, 45, false)) {
/* 128 */           return null;
/*     */         }
/* 130 */       } else if (p_82846_2_ >= 36 && p_82846_2_ < 45) {
/* 131 */         if (!func_75135_a(itemStack1, 9, 36, false)) {
/* 132 */           return null;
/*     */         }
/*     */       }
/* 135 */       else if (!func_75135_a(itemStack1, 9, 45, false)) {
/* 136 */         return null;
/*     */       } 
/*     */       
/* 139 */       if (itemStack1.field_77994_a == 0) {
/* 140 */         slot.func_75215_d(null);
/*     */       } else {
/* 142 */         slot.func_75218_e();
/*     */       } 
/* 144 */       if (itemStack1.field_77994_a == itemStack.field_77994_a)
/*     */       {
/* 146 */         return null;
/*     */       }
/* 148 */       slot.func_82870_a(p_82846_1_, itemStack1);
/*     */     } 
/*     */     
/* 151 */     return itemStack;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_94530_a(ItemStack p_94530_1_, Slot p_94530_2_) {
/* 156 */     return (p_94530_2_.field_75224_c != this.field_75179_f && super.func_94530_a(p_94530_1_, p_94530_2_));
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\inventory\ContainerPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */