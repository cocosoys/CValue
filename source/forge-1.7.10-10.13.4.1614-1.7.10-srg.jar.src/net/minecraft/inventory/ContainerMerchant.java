/*     */ package net.minecraft.inventory;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.entity.IMerchant;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
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
/*     */ public class ContainerMerchant
/*     */   extends Container
/*     */ {
/*     */   private IMerchant field_75178_e;
/*     */   private InventoryMerchant field_75176_f;
/*     */   private final World field_75177_g;
/*     */   private static final String __OBFID = "CL_00001757";
/*     */   
/*     */   public ContainerMerchant(InventoryPlayer p_i1821_1_, IMerchant p_i1821_2_, World p_i1821_3_) {
/*  32 */     this.field_75178_e = p_i1821_2_;
/*  33 */     this.field_75177_g = p_i1821_3_;
/*     */     
/*  35 */     this.field_75176_f = new InventoryMerchant(p_i1821_1_.field_70458_d, p_i1821_2_);
/*  36 */     func_75146_a(new Slot(this.field_75176_f, 0, 36, 53));
/*  37 */     func_75146_a(new Slot(this.field_75176_f, 1, 62, 53));
/*  38 */     func_75146_a(new SlotMerchantResult(p_i1821_1_.field_70458_d, p_i1821_2_, this.field_75176_f, 2, 120, 53));
/*     */     byte b;
/*  40 */     for (b = 0; b < 3; b++) {
/*  41 */       for (byte b1 = 0; b1 < 9; b1++) {
/*  42 */         func_75146_a(new Slot((IInventory)p_i1821_1_, b1 + b * 9 + 9, 8 + b1 * 18, 84 + b * 18));
/*     */       }
/*     */     } 
/*  45 */     for (b = 0; b < 9; b++) {
/*  46 */       func_75146_a(new Slot((IInventory)p_i1821_1_, b, 8 + b * 18, 142));
/*     */     }
/*     */   }
/*     */   
/*     */   public InventoryMerchant func_75174_d() {
/*  51 */     return this.field_75176_f;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_75132_a(ICrafting p_75132_1_) {
/*  56 */     super.func_75132_a(p_75132_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_75142_b() {
/*  61 */     super.func_75142_b();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_75130_a(IInventory p_75130_1_) {
/*  66 */     this.field_75176_f.func_70470_g();
/*  67 */     super.func_75130_a(p_75130_1_);
/*     */   }
/*     */   
/*     */   public void func_75175_c(int p_75175_1_) {
/*  71 */     this.field_75176_f.func_70471_c(p_75175_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_75137_b(int p_75137_1_, int p_75137_2_) {}
/*     */ 
/*     */   
/*     */   public boolean func_75145_c(EntityPlayer p_75145_1_) {
/*  80 */     return (this.field_75178_e.func_70931_l_() == p_75145_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_82846_b(EntityPlayer p_82846_1_, int p_82846_2_) {
/*  85 */     ItemStack itemStack = null;
/*  86 */     Slot slot = this.field_75151_b.get(p_82846_2_);
/*  87 */     if (slot != null && slot.func_75216_d()) {
/*  88 */       ItemStack itemStack1 = slot.func_75211_c();
/*  89 */       itemStack = itemStack1.func_77946_l();
/*     */       
/*  91 */       if (p_82846_2_ == 2) {
/*  92 */         if (!func_75135_a(itemStack1, 3, 39, true)) {
/*  93 */           return null;
/*     */         }
/*  95 */         slot.func_75220_a(itemStack1, itemStack);
/*  96 */       } else if (p_82846_2_ == 0 || p_82846_2_ == 1) {
/*  97 */         if (!func_75135_a(itemStack1, 3, 39, false)) {
/*  98 */           return null;
/*     */         }
/* 100 */       } else if (p_82846_2_ >= 3 && p_82846_2_ < 30) {
/* 101 */         if (!func_75135_a(itemStack1, 30, 39, false)) {
/* 102 */           return null;
/*     */         }
/* 104 */       } else if (p_82846_2_ >= 30 && p_82846_2_ < 39 && 
/* 105 */         !func_75135_a(itemStack1, 3, 30, false)) {
/* 106 */         return null;
/*     */       } 
/*     */       
/* 109 */       if (itemStack1.field_77994_a == 0) {
/* 110 */         slot.func_75215_d(null);
/*     */       } else {
/* 112 */         slot.func_75218_e();
/*     */       } 
/* 114 */       if (itemStack1.field_77994_a == itemStack.field_77994_a) {
/* 115 */         return null;
/*     */       }
/* 117 */       slot.func_82870_a(p_82846_1_, itemStack1);
/*     */     } 
/*     */     
/* 120 */     return itemStack;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_75134_a(EntityPlayer p_75134_1_) {
/* 125 */     super.func_75134_a(p_75134_1_);
/* 126 */     this.field_75178_e.func_70932_a_(null);
/*     */     
/* 128 */     super.func_75134_a(p_75134_1_);
/* 129 */     if (this.field_75177_g.field_72995_K)
/*     */       return; 
/* 131 */     ItemStack itemStack = this.field_75176_f.func_70304_b(0);
/* 132 */     if (itemStack != null) {
/* 133 */       p_75134_1_.func_71019_a(itemStack, false);
/*     */     }
/* 135 */     itemStack = this.field_75176_f.func_70304_b(1);
/* 136 */     if (itemStack != null)
/* 137 */       p_75134_1_.func_71019_a(itemStack, false); 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\inventory\ContainerMerchant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */