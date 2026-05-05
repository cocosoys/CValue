/*     */ package net.minecraft.inventory;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.crafting.FurnaceRecipes;
/*     */ import net.minecraft.tileentity.TileEntityFurnace;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ContainerFurnace
/*     */   extends Container
/*     */ {
/*     */   private TileEntityFurnace field_75158_e;
/*     */   private int field_75156_f;
/*     */   private int field_75157_g;
/*     */   private int field_75159_h;
/*     */   private static final String __OBFID = "CL_00001748";
/*     */   
/*     */   public ContainerFurnace(InventoryPlayer p_i1812_1_, TileEntityFurnace p_i1812_2_) {
/*  23 */     this.field_75158_e = p_i1812_2_;
/*     */     
/*  25 */     func_75146_a(new Slot((IInventory)p_i1812_2_, 0, 56, 17));
/*  26 */     func_75146_a(new Slot((IInventory)p_i1812_2_, 1, 56, 53));
/*  27 */     func_75146_a(new SlotFurnace(p_i1812_1_.field_70458_d, (IInventory)p_i1812_2_, 2, 116, 35));
/*     */     byte b;
/*  29 */     for (b = 0; b < 3; b++) {
/*  30 */       for (byte b1 = 0; b1 < 9; b1++) {
/*  31 */         func_75146_a(new Slot((IInventory)p_i1812_1_, b1 + b * 9 + 9, 8 + b1 * 18, 84 + b * 18));
/*     */       }
/*     */     } 
/*  34 */     for (b = 0; b < 9; b++) {
/*  35 */       func_75146_a(new Slot((IInventory)p_i1812_1_, b, 8 + b * 18, 142));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75132_a(ICrafting p_75132_1_) {
/*  45 */     super.func_75132_a(p_75132_1_);
/*  46 */     p_75132_1_.func_71112_a(this, 0, this.field_75158_e.field_145961_j);
/*  47 */     p_75132_1_.func_71112_a(this, 1, this.field_75158_e.field_145956_a);
/*  48 */     p_75132_1_.func_71112_a(this, 2, this.field_75158_e.field_145963_i);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_75142_b() {
/*  53 */     super.func_75142_b();
/*     */     
/*  55 */     for (byte b = 0; b < this.field_75149_d.size(); b++) {
/*  56 */       ICrafting iCrafting = this.field_75149_d.get(b);
/*  57 */       if (this.field_75156_f != this.field_75158_e.field_145961_j) {
/*  58 */         iCrafting.func_71112_a(this, 0, this.field_75158_e.field_145961_j);
/*     */       }
/*  60 */       if (this.field_75157_g != this.field_75158_e.field_145956_a) {
/*  61 */         iCrafting.func_71112_a(this, 1, this.field_75158_e.field_145956_a);
/*     */       }
/*  63 */       if (this.field_75159_h != this.field_75158_e.field_145963_i) {
/*  64 */         iCrafting.func_71112_a(this, 2, this.field_75158_e.field_145963_i);
/*     */       }
/*     */     } 
/*     */     
/*  68 */     this.field_75156_f = this.field_75158_e.field_145961_j;
/*  69 */     this.field_75157_g = this.field_75158_e.field_145956_a;
/*  70 */     this.field_75159_h = this.field_75158_e.field_145963_i;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_75137_b(int p_75137_1_, int p_75137_2_) {
/*  75 */     if (p_75137_1_ == 0) this.field_75158_e.field_145961_j = p_75137_2_; 
/*  76 */     if (p_75137_1_ == 1) this.field_75158_e.field_145956_a = p_75137_2_; 
/*  77 */     if (p_75137_1_ == 2) this.field_75158_e.field_145963_i = p_75137_2_;
/*     */   
/*     */   }
/*     */   
/*     */   public boolean func_75145_c(EntityPlayer p_75145_1_) {
/*  82 */     return this.field_75158_e.func_70300_a(p_75145_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_82846_b(EntityPlayer p_82846_1_, int p_82846_2_) {
/*  87 */     ItemStack itemStack = null;
/*  88 */     Slot slot = this.field_75151_b.get(p_82846_2_);
/*  89 */     if (slot != null && slot.func_75216_d()) {
/*  90 */       ItemStack itemStack1 = slot.func_75211_c();
/*  91 */       itemStack = itemStack1.func_77946_l();
/*     */       
/*  93 */       if (p_82846_2_ == 2) {
/*  94 */         if (!func_75135_a(itemStack1, 3, 39, true)) {
/*  95 */           return null;
/*     */         }
/*  97 */         slot.func_75220_a(itemStack1, itemStack);
/*  98 */       } else if (p_82846_2_ == 1 || p_82846_2_ == 0) {
/*  99 */         if (!func_75135_a(itemStack1, 3, 39, false)) {
/* 100 */           return null;
/*     */         }
/* 102 */       } else if (FurnaceRecipes.func_77602_a().func_151395_a(itemStack1) != null) {
/* 103 */         if (!func_75135_a(itemStack1, 0, 1, false)) {
/* 104 */           return null;
/*     */         }
/* 106 */       } else if (TileEntityFurnace.func_145954_b(itemStack1)) {
/* 107 */         if (!func_75135_a(itemStack1, 1, 2, false)) {
/* 108 */           return null;
/*     */         }
/* 110 */       } else if (p_82846_2_ >= 3 && p_82846_2_ < 30) {
/* 111 */         if (!func_75135_a(itemStack1, 30, 39, false)) {
/* 112 */           return null;
/*     */         }
/* 114 */       } else if (p_82846_2_ >= 30 && p_82846_2_ < 39 && 
/* 115 */         !func_75135_a(itemStack1, 3, 30, false)) {
/* 116 */         return null;
/*     */       } 
/*     */       
/* 119 */       if (itemStack1.field_77994_a == 0) {
/* 120 */         slot.func_75215_d(null);
/*     */       } else {
/* 122 */         slot.func_75218_e();
/*     */       } 
/* 124 */       if (itemStack1.field_77994_a == itemStack.field_77994_a) {
/* 125 */         return null;
/*     */       }
/* 127 */       slot.func_82870_a(p_82846_1_, itemStack1);
/*     */     } 
/*     */     
/* 130 */     return itemStack;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\inventory\ContainerFurnace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */