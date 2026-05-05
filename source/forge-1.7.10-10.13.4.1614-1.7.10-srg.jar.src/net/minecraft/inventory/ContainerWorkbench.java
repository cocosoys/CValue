/*     */ package net.minecraft.inventory;
/*     */ 
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.crafting.CraftingManager;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ContainerWorkbench
/*     */   extends Container
/*     */ {
/*  20 */   public InventoryCrafting field_75162_e = new InventoryCrafting(this, 3, 3);
/*  21 */   public IInventory field_75160_f = new InventoryCraftResult();
/*     */   
/*     */   private World field_75161_g;
/*     */   private int field_75164_h;
/*     */   
/*     */   public ContainerWorkbench(InventoryPlayer p_i1808_1_, World p_i1808_2_, int p_i1808_3_, int p_i1808_4_, int p_i1808_5_) {
/*  27 */     this.field_75161_g = p_i1808_2_;
/*  28 */     this.field_75164_h = p_i1808_3_;
/*  29 */     this.field_75165_i = p_i1808_4_;
/*  30 */     this.field_75163_j = p_i1808_5_;
/*  31 */     func_75146_a(new SlotCrafting(p_i1808_1_.field_70458_d, this.field_75162_e, this.field_75160_f, 0, 124, 35));
/*     */     byte b;
/*  33 */     for (b = 0; b < 3; b++) {
/*  34 */       for (byte b1 = 0; b1 < 3; b1++) {
/*  35 */         func_75146_a(new Slot(this.field_75162_e, b1 + b * 3, 30 + b1 * 18, 17 + b * 18));
/*     */       }
/*     */     } 
/*     */     
/*  39 */     for (b = 0; b < 3; b++) {
/*  40 */       for (byte b1 = 0; b1 < 9; b1++) {
/*  41 */         func_75146_a(new Slot((IInventory)p_i1808_1_, b1 + b * 9 + 9, 8 + b1 * 18, 84 + b * 18));
/*     */       }
/*     */     } 
/*  44 */     for (b = 0; b < 9; b++) {
/*  45 */       func_75146_a(new Slot((IInventory)p_i1808_1_, b, 8 + b * 18, 142));
/*     */     }
/*     */     
/*  48 */     func_75130_a(this.field_75162_e);
/*     */   }
/*     */   private int field_75165_i; private int field_75163_j; private static final String __OBFID = "CL_00001744";
/*     */   
/*     */   public void func_75130_a(IInventory p_75130_1_) {
/*  53 */     this.field_75160_f.func_70299_a(0, CraftingManager.func_77594_a().func_82787_a(this.field_75162_e, this.field_75161_g));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_75134_a(EntityPlayer p_75134_1_) {
/*  58 */     super.func_75134_a(p_75134_1_);
/*  59 */     if (this.field_75161_g.field_72995_K)
/*     */       return; 
/*  61 */     for (byte b = 0; b < 9; b++) {
/*  62 */       ItemStack itemStack = this.field_75162_e.func_70304_b(b);
/*  63 */       if (itemStack != null) {
/*  64 */         p_75134_1_.func_71019_a(itemStack, false);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_75145_c(EntityPlayer p_75145_1_) {
/*  71 */     if (this.field_75161_g.func_147439_a(this.field_75164_h, this.field_75165_i, this.field_75163_j) != Blocks.field_150462_ai) return false; 
/*  72 */     if (p_75145_1_.func_70092_e(this.field_75164_h + 0.5D, this.field_75165_i + 0.5D, this.field_75163_j + 0.5D) > 64.0D) return false; 
/*  73 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_82846_b(EntityPlayer p_82846_1_, int p_82846_2_) {
/*  78 */     ItemStack itemStack = null;
/*  79 */     Slot slot = this.field_75151_b.get(p_82846_2_);
/*  80 */     if (slot != null && slot.func_75216_d()) {
/*  81 */       ItemStack itemStack1 = slot.func_75211_c();
/*  82 */       itemStack = itemStack1.func_77946_l();
/*     */       
/*  84 */       if (p_82846_2_ == 0) {
/*  85 */         if (!func_75135_a(itemStack1, 10, 46, true)) {
/*  86 */           return null;
/*     */         }
/*  88 */         slot.func_75220_a(itemStack1, itemStack);
/*  89 */       } else if (p_82846_2_ >= 10 && p_82846_2_ < 37) {
/*  90 */         if (!func_75135_a(itemStack1, 37, 46, false)) {
/*  91 */           return null;
/*     */         }
/*  93 */       } else if (p_82846_2_ >= 37 && p_82846_2_ < 46) {
/*  94 */         if (!func_75135_a(itemStack1, 10, 37, false)) {
/*  95 */           return null;
/*     */         }
/*     */       }
/*  98 */       else if (!func_75135_a(itemStack1, 10, 46, false)) {
/*  99 */         return null;
/*     */       } 
/*     */       
/* 102 */       if (itemStack1.field_77994_a == 0) {
/* 103 */         slot.func_75215_d(null);
/*     */       } else {
/* 105 */         slot.func_75218_e();
/*     */       } 
/* 107 */       if (itemStack1.field_77994_a == itemStack.field_77994_a)
/*     */       {
/* 109 */         return null;
/*     */       }
/* 111 */       slot.func_82870_a(p_82846_1_, itemStack1);
/*     */     } 
/*     */     
/* 114 */     return itemStack;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_94530_a(ItemStack p_94530_1_, Slot p_94530_2_) {
/* 119 */     return (p_94530_2_.field_75224_c != this.field_75160_f && super.func_94530_a(p_94530_1_, p_94530_2_));
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\inventory\ContainerWorkbench.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */