/*     */ package net.minecraft.village;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.network.PacketBuffer;
/*     */ 
/*     */ public class MerchantRecipeList
/*     */   extends ArrayList {
/*     */   private static final String __OBFID = "CL_00000127";
/*     */   
/*     */   public MerchantRecipeList() {}
/*     */   
/*     */   public MerchantRecipeList(NBTTagCompound p_i1944_1_) {
/*  20 */     func_77201_a(p_i1944_1_);
/*     */   }
/*     */   
/*     */   public MerchantRecipe func_77203_a(ItemStack p_77203_1_, ItemStack p_77203_2_, int p_77203_3_) {
/*  24 */     if (p_77203_3_ > 0 && p_77203_3_ < size()) {
/*     */       
/*  26 */       MerchantRecipe merchantRecipe = (MerchantRecipe)get(p_77203_3_);
/*  27 */       if (p_77203_1_.func_77973_b() == merchantRecipe.func_77394_a().func_77973_b() && ((p_77203_2_ == null && !merchantRecipe.func_77398_c()) || (merchantRecipe.func_77398_c() && p_77203_2_ != null && merchantRecipe.func_77396_b().func_77973_b() == p_77203_2_.func_77973_b())) && 
/*  28 */         p_77203_1_.field_77994_a >= (merchantRecipe.func_77394_a()).field_77994_a && (!merchantRecipe.func_77398_c() || p_77203_2_.field_77994_a >= (merchantRecipe.func_77396_b()).field_77994_a)) {
/*  29 */         return merchantRecipe;
/*     */       }
/*     */       
/*  32 */       return null;
/*     */     } 
/*  34 */     for (byte b = 0; b < size(); b++) {
/*  35 */       MerchantRecipe merchantRecipe = (MerchantRecipe)get(b);
/*  36 */       if (p_77203_1_.func_77973_b() == merchantRecipe.func_77394_a().func_77973_b() && p_77203_1_.field_77994_a >= (merchantRecipe.func_77394_a()).field_77994_a && ((!merchantRecipe.func_77398_c() && p_77203_2_ == null) || (merchantRecipe.func_77398_c() && p_77203_2_ != null && merchantRecipe.func_77396_b().func_77973_b() == p_77203_2_.func_77973_b() && p_77203_2_.field_77994_a >= (merchantRecipe.func_77396_b()).field_77994_a)))
/*     */       {
/*  38 */         return merchantRecipe;
/*     */       }
/*     */     } 
/*  41 */     return null;
/*     */   }
/*     */   
/*     */   public void func_77205_a(MerchantRecipe p_77205_1_) {
/*  45 */     for (byte b = 0; b < size(); b++) {
/*  46 */       MerchantRecipe merchantRecipe = (MerchantRecipe)get(b);
/*  47 */       if (p_77205_1_.func_77393_a(merchantRecipe)) {
/*  48 */         if (p_77205_1_.func_77391_b(merchantRecipe)) {
/*  49 */           set(b, (E)p_77205_1_);
/*     */         }
/*     */         return;
/*     */       } 
/*     */     } 
/*  54 */     add((E)p_77205_1_);
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
/*     */   public void func_151391_a(PacketBuffer p_151391_1_) throws IOException {
/*  70 */     p_151391_1_.writeByte((byte)(size() & 0xFF));
/*  71 */     for (byte b = 0; b < size(); b++) {
/*  72 */       MerchantRecipe merchantRecipe = (MerchantRecipe)get(b);
/*  73 */       p_151391_1_.func_150788_a(merchantRecipe.func_77394_a());
/*  74 */       p_151391_1_.func_150788_a(merchantRecipe.func_77397_d());
/*     */       
/*  76 */       ItemStack itemStack = merchantRecipe.func_77396_b();
/*  77 */       p_151391_1_.writeBoolean((itemStack != null));
/*  78 */       if (itemStack != null) {
/*  79 */         p_151391_1_.func_150788_a(itemStack);
/*     */       }
/*  81 */       p_151391_1_.writeBoolean(merchantRecipe.func_82784_g());
/*     */     } 
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static MerchantRecipeList func_151390_b(PacketBuffer p_151390_0_) throws IOException {
/*  86 */     MerchantRecipeList merchantRecipeList = new MerchantRecipeList();
/*     */     
/*  88 */     int i = p_151390_0_.readByte() & 0xFF;
/*  89 */     for (byte b = 0; b < i; b++) {
/*  90 */       ItemStack itemStack1 = p_151390_0_.func_150791_c();
/*  91 */       ItemStack itemStack2 = p_151390_0_.func_150791_c();
/*     */       
/*  93 */       ItemStack itemStack3 = null;
/*  94 */       if (p_151390_0_.readBoolean()) {
/*  95 */         itemStack3 = p_151390_0_.func_150791_c();
/*     */       }
/*  97 */       boolean bool = p_151390_0_.readBoolean();
/*     */       
/*  99 */       MerchantRecipe merchantRecipe = new MerchantRecipe(itemStack1, itemStack3, itemStack2);
/* 100 */       if (bool) {
/* 101 */         merchantRecipe.func_82785_h();
/*     */       }
/* 103 */       merchantRecipeList.add((E)merchantRecipe);
/*     */     } 
/* 105 */     return merchantRecipeList;
/*     */   }
/*     */   
/*     */   public void func_77201_a(NBTTagCompound p_77201_1_) {
/* 109 */     NBTTagList nBTTagList = p_77201_1_.func_150295_c("Recipes", 10);
/*     */     
/* 111 */     for (byte b = 0; b < nBTTagList.func_74745_c(); b++) {
/* 112 */       NBTTagCompound nBTTagCompound = nBTTagList.func_150305_b(b);
/* 113 */       add((E)new MerchantRecipe(nBTTagCompound));
/*     */     } 
/*     */   }
/*     */   
/*     */   public NBTTagCompound func_77202_a() {
/* 118 */     NBTTagCompound nBTTagCompound = new NBTTagCompound();
/*     */     
/* 120 */     NBTTagList nBTTagList = new NBTTagList();
/* 121 */     for (byte b = 0; b < size(); b++) {
/* 122 */       MerchantRecipe merchantRecipe = (MerchantRecipe)get(b);
/* 123 */       nBTTagList.func_74742_a((NBTBase)merchantRecipe.func_77395_g());
/*     */     } 
/* 125 */     nBTTagCompound.func_74782_a("Recipes", (NBTBase)nBTTagList);
/* 126 */     return nBTTagCompound;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\village\MerchantRecipeList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */