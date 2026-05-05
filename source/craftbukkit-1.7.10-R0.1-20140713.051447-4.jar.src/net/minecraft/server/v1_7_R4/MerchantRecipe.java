/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MerchantRecipe
/*     */ {
/*     */   private ItemStack buyingItem1;
/*     */   private ItemStack buyingItem2;
/*     */   private ItemStack sellingItem;
/*     */   private int uses;
/*     */   private int maxUses;
/*     */   
/*     */   public MerchantRecipe(NBTTagCompound paramNBTTagCompound) {
/*  16 */     a(paramNBTTagCompound);
/*     */   }
/*     */   
/*     */   public MerchantRecipe(ItemStack paramItemStack1, ItemStack paramItemStack2, ItemStack paramItemStack3) {
/*  20 */     this.buyingItem1 = paramItemStack1;
/*  21 */     this.buyingItem2 = paramItemStack2;
/*  22 */     this.sellingItem = paramItemStack3;
/*  23 */     this.maxUses = 7;
/*     */   }
/*     */   
/*     */   public MerchantRecipe(ItemStack paramItemStack1, ItemStack paramItemStack2) {
/*  27 */     this(paramItemStack1, null, paramItemStack2);
/*     */   }
/*     */   
/*     */   public MerchantRecipe(ItemStack paramItemStack, Item paramItem) {
/*  31 */     this(paramItemStack, new ItemStack(paramItem));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack getBuyItem1() {
/*  39 */     return this.buyingItem1;
/*     */   }
/*     */   
/*     */   public ItemStack getBuyItem2() {
/*  43 */     return this.buyingItem2;
/*     */   }
/*     */   
/*     */   public boolean hasSecondItem() {
/*  47 */     return (this.buyingItem2 != null);
/*     */   }
/*     */   
/*     */   public ItemStack getBuyItem3() {
/*  51 */     return this.sellingItem;
/*     */   }
/*     */   
/*     */   public boolean a(MerchantRecipe paramMerchantRecipe) {
/*  55 */     if (this.buyingItem1.getItem() != paramMerchantRecipe.buyingItem1.getItem() || this.sellingItem.getItem() != paramMerchantRecipe.sellingItem.getItem()) {
/*  56 */       return false;
/*     */     }
/*  58 */     return ((this.buyingItem2 == null && paramMerchantRecipe.buyingItem2 == null) || (this.buyingItem2 != null && paramMerchantRecipe.buyingItem2 != null && this.buyingItem2.getItem() == paramMerchantRecipe.buyingItem2.getItem()));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean b(MerchantRecipe paramMerchantRecipe) {
/*  63 */     return (a(paramMerchantRecipe) && (this.buyingItem1.count < paramMerchantRecipe.buyingItem1.count || (this.buyingItem2 != null && this.buyingItem2.count < paramMerchantRecipe.buyingItem2.count)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void f() {
/*  71 */     this.uses++;
/*     */   }
/*     */   
/*     */   public void a(int paramInt) {
/*  75 */     this.maxUses += paramInt;
/*     */   }
/*     */   
/*     */   public boolean g() {
/*  79 */     return (this.uses >= this.maxUses);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(NBTTagCompound paramNBTTagCompound) {
/*  87 */     NBTTagCompound nBTTagCompound1 = paramNBTTagCompound.getCompound("buy");
/*  88 */     this.buyingItem1 = ItemStack.createStack(nBTTagCompound1);
/*  89 */     NBTTagCompound nBTTagCompound2 = paramNBTTagCompound.getCompound("sell");
/*  90 */     this.sellingItem = ItemStack.createStack(nBTTagCompound2);
/*  91 */     if (paramNBTTagCompound.hasKeyOfType("buyB", 10)) {
/*  92 */       this.buyingItem2 = ItemStack.createStack(paramNBTTagCompound.getCompound("buyB"));
/*     */     }
/*  94 */     if (paramNBTTagCompound.hasKeyOfType("uses", 99)) {
/*  95 */       this.uses = paramNBTTagCompound.getInt("uses");
/*     */     }
/*  97 */     if (paramNBTTagCompound.hasKeyOfType("maxUses", 99)) {
/*  98 */       this.maxUses = paramNBTTagCompound.getInt("maxUses");
/*     */     } else {
/* 100 */       this.maxUses = 7;
/*     */     } 
/*     */   }
/*     */   
/*     */   public NBTTagCompound i() {
/* 105 */     NBTTagCompound nBTTagCompound = new NBTTagCompound();
/* 106 */     nBTTagCompound.set("buy", this.buyingItem1.save(new NBTTagCompound()));
/* 107 */     nBTTagCompound.set("sell", this.sellingItem.save(new NBTTagCompound()));
/* 108 */     if (this.buyingItem2 != null) {
/* 109 */       nBTTagCompound.set("buyB", this.buyingItem2.save(new NBTTagCompound()));
/*     */     }
/* 111 */     nBTTagCompound.setInt("uses", this.uses);
/* 112 */     nBTTagCompound.setInt("maxUses", this.maxUses);
/* 113 */     return nBTTagCompound;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\MerchantRecipe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */