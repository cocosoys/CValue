/*     */ package net.minecraft.item;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.enchantment.Enchantment;
/*     */ import net.minecraft.enchantment.EnchantmentData;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.util.WeightedRandomChestContent;
/*     */ 
/*     */ public class ItemEnchantedBook extends Item {
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_77636_d(ItemStack p_77636_1_) {
/*  15 */     return true;
/*     */   }
/*     */   private static final String __OBFID = "CL_00000025";
/*     */   
/*     */   public boolean func_77616_k(ItemStack p_77616_1_) {
/*  20 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public EnumRarity func_77613_e(ItemStack p_77613_1_) {
/*  25 */     if (func_92110_g(p_77613_1_).func_74745_c() > 0) {
/*  26 */       return EnumRarity.uncommon;
/*     */     }
/*  28 */     return super.func_77613_e(p_77613_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public NBTTagList func_92110_g(ItemStack p_92110_1_) {
/*  33 */     if (p_92110_1_.field_77990_d == null || !p_92110_1_.field_77990_d.func_150297_b("StoredEnchantments", 9)) {
/*  34 */       return new NBTTagList();
/*     */     }
/*     */     
/*  37 */     return (NBTTagList)p_92110_1_.field_77990_d.func_74781_a("StoredEnchantments");
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_77624_a(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List<String> p_77624_3_, boolean p_77624_4_) {
/*  42 */     super.func_77624_a(p_77624_1_, p_77624_2_, p_77624_3_, p_77624_4_);
/*     */     
/*  44 */     NBTTagList nBTTagList = func_92110_g(p_77624_1_);
/*     */     
/*  46 */     if (nBTTagList != null) {
/*  47 */       for (byte b = 0; b < nBTTagList.func_74745_c(); b++) {
/*  48 */         short s1 = nBTTagList.func_150305_b(b).func_74765_d("id");
/*  49 */         short s2 = nBTTagList.func_150305_b(b).func_74765_d("lvl");
/*     */         
/*  51 */         if (Enchantment.field_77331_b[s1] != null) {
/*  52 */           p_77624_3_.add(Enchantment.field_77331_b[s1].func_77316_c(s2));
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_92115_a(ItemStack p_92115_1_, EnchantmentData p_92115_2_) {
/*  59 */     NBTTagList nBTTagList = func_92110_g(p_92115_1_);
/*  60 */     boolean bool = true;
/*     */     
/*  62 */     for (byte b = 0; b < nBTTagList.func_74745_c(); b++) {
/*  63 */       NBTTagCompound nBTTagCompound = nBTTagList.func_150305_b(b);
/*     */       
/*  65 */       if (nBTTagCompound.func_74765_d("id") == p_92115_2_.field_76302_b.field_77352_x) {
/*  66 */         if (nBTTagCompound.func_74765_d("lvl") < p_92115_2_.field_76303_c) {
/*  67 */           nBTTagCompound.func_74777_a("lvl", (short)p_92115_2_.field_76303_c);
/*     */         }
/*     */         
/*  70 */         bool = false;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*  75 */     if (bool) {
/*  76 */       NBTTagCompound nBTTagCompound = new NBTTagCompound();
/*     */       
/*  78 */       nBTTagCompound.func_74777_a("id", (short)p_92115_2_.field_76302_b.field_77352_x);
/*  79 */       nBTTagCompound.func_74777_a("lvl", (short)p_92115_2_.field_76303_c);
/*     */       
/*  81 */       nBTTagList.func_74742_a((NBTBase)nBTTagCompound);
/*     */     } 
/*     */     
/*  84 */     if (!p_92115_1_.func_77942_o()) p_92115_1_.func_77982_d(new NBTTagCompound()); 
/*  85 */     p_92115_1_.func_77978_p().func_74782_a("StoredEnchantments", (NBTBase)nBTTagList);
/*     */   }
/*     */   
/*     */   public ItemStack func_92111_a(EnchantmentData p_92111_1_) {
/*  89 */     ItemStack itemStack = new ItemStack(this);
/*  90 */     func_92115_a(itemStack, p_92111_1_);
/*  91 */     return itemStack;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_92113_a(Enchantment p_92113_1_, List<ItemStack> p_92113_2_) {
/*  95 */     for (int i = p_92113_1_.func_77319_d(); i <= p_92113_1_.func_77325_b(); i++) {
/*  96 */       p_92113_2_.add(func_92111_a(new EnchantmentData(p_92113_1_, i)));
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
/*     */   public WeightedRandomChestContent func_92114_b(Random p_92114_1_) {
/* 111 */     return func_92112_a(p_92114_1_, 1, 1, 1);
/*     */   }
/*     */   
/*     */   public WeightedRandomChestContent func_92112_a(Random p_92112_1_, int p_92112_2_, int p_92112_3_, int p_92112_4_) {
/* 115 */     ItemStack itemStack = new ItemStack(Items.field_151122_aG, 1, 0);
/* 116 */     EnchantmentHelper.func_77504_a(p_92112_1_, itemStack, 30);
/*     */     
/* 118 */     return new WeightedRandomChestContent(itemStack, p_92112_2_, p_92112_3_, p_92112_4_);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemEnchantedBook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */