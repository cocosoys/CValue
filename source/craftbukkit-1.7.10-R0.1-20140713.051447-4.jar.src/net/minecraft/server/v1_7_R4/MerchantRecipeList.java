/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.util.ArrayList;
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
/*     */ public class MerchantRecipeList
/*     */   extends ArrayList
/*     */ {
/*     */   public MerchantRecipeList() {}
/*     */   
/*     */   public MerchantRecipeList(NBTTagCompound paramNBTTagCompound) {
/*  20 */     a(paramNBTTagCompound);
/*     */   }
/*     */   
/*     */   public MerchantRecipe a(ItemStack paramItemStack1, ItemStack paramItemStack2, int paramInt) {
/*  24 */     if (paramInt > 0 && paramInt < size()) {
/*     */       
/*  26 */       MerchantRecipe merchantRecipe = (MerchantRecipe)get(paramInt);
/*  27 */       if (paramItemStack1.getItem() == merchantRecipe.getBuyItem1().getItem() && ((paramItemStack2 == null && !merchantRecipe.hasSecondItem()) || (merchantRecipe.hasSecondItem() && paramItemStack2 != null && merchantRecipe.getBuyItem2().getItem() == paramItemStack2.getItem())) && 
/*  28 */         paramItemStack1.count >= (merchantRecipe.getBuyItem1()).count && (!merchantRecipe.hasSecondItem() || paramItemStack2.count >= (merchantRecipe.getBuyItem2()).count)) {
/*  29 */         return merchantRecipe;
/*     */       }
/*     */       
/*  32 */       return null;
/*     */     } 
/*  34 */     for (byte b = 0; b < size(); b++) {
/*  35 */       MerchantRecipe merchantRecipe = (MerchantRecipe)get(b);
/*  36 */       if (paramItemStack1.getItem() == merchantRecipe.getBuyItem1().getItem() && paramItemStack1.count >= (merchantRecipe.getBuyItem1()).count && ((!merchantRecipe.hasSecondItem() && paramItemStack2 == null) || (merchantRecipe.hasSecondItem() && paramItemStack2 != null && merchantRecipe.getBuyItem2().getItem() == paramItemStack2.getItem() && paramItemStack2.count >= (merchantRecipe.getBuyItem2()).count)))
/*     */       {
/*  38 */         return merchantRecipe;
/*     */       }
/*     */     } 
/*  41 */     return null;
/*     */   }
/*     */   
/*     */   public void a(MerchantRecipe paramMerchantRecipe) {
/*  45 */     for (byte b = 0; b < size(); b++) {
/*  46 */       MerchantRecipe merchantRecipe = (MerchantRecipe)get(b);
/*  47 */       if (paramMerchantRecipe.a(merchantRecipe)) {
/*  48 */         if (paramMerchantRecipe.b(merchantRecipe)) {
/*  49 */           set(b, (E)paramMerchantRecipe);
/*     */         }
/*     */         return;
/*     */       } 
/*     */     } 
/*  54 */     add((E)paramMerchantRecipe);
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
/*     */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/*  70 */     paramPacketDataSerializer.writeByte((byte)(size() & 0xFF));
/*  71 */     for (byte b = 0; b < size(); b++) {
/*  72 */       MerchantRecipe merchantRecipe = (MerchantRecipe)get(b);
/*  73 */       paramPacketDataSerializer.a(merchantRecipe.getBuyItem1());
/*  74 */       paramPacketDataSerializer.a(merchantRecipe.getBuyItem3());
/*     */       
/*  76 */       ItemStack itemStack = merchantRecipe.getBuyItem2();
/*  77 */       paramPacketDataSerializer.writeBoolean((itemStack != null));
/*  78 */       if (itemStack != null) {
/*  79 */         paramPacketDataSerializer.a(itemStack);
/*     */       }
/*  81 */       paramPacketDataSerializer.writeBoolean(merchantRecipe.g());
/*     */     } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(NBTTagCompound paramNBTTagCompound) {
/* 109 */     NBTTagList nBTTagList = paramNBTTagCompound.getList("Recipes", 10);
/*     */     
/* 111 */     for (byte b = 0; b < nBTTagList.size(); b++) {
/* 112 */       NBTTagCompound nBTTagCompound = nBTTagList.get(b);
/* 113 */       add((E)new MerchantRecipe(nBTTagCompound));
/*     */     } 
/*     */   }
/*     */   
/*     */   public NBTTagCompound a() {
/* 118 */     NBTTagCompound nBTTagCompound = new NBTTagCompound();
/*     */     
/* 120 */     NBTTagList nBTTagList = new NBTTagList();
/* 121 */     for (byte b = 0; b < size(); b++) {
/* 122 */       MerchantRecipe merchantRecipe = (MerchantRecipe)get(b);
/* 123 */       nBTTagList.add(merchantRecipe.i());
/*     */     } 
/* 125 */     nBTTagCompound.set("Recipes", nBTTagList);
/* 126 */     return nBTTagCompound;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\MerchantRecipeList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */