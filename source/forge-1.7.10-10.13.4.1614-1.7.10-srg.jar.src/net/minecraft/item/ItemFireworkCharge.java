/*     */ package net.minecraft.item;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.StatCollector;
/*     */ 
/*     */ public class ItemFireworkCharge extends Item {
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon field_150904_a;
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_77618_c(int p_77618_1_, int p_77618_2_) {
/*  16 */     if (p_77618_2_ > 0) {
/*  17 */       return this.field_150904_a;
/*     */     }
/*  19 */     return super.func_77618_c(p_77618_1_, p_77618_2_);
/*     */   }
/*     */   private static final String __OBFID = "CL_00000030";
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_82790_a(ItemStack p_82790_1_, int p_82790_2_) {
/*  24 */     if (p_82790_2_ == 1) {
/*  25 */       NBTBase nBTBase = func_150903_a(p_82790_1_, "Colors");
/*  26 */       if (nBTBase != null && nBTBase instanceof NBTTagIntArray) {
/*  27 */         NBTTagIntArray nBTTagIntArray = (NBTTagIntArray)nBTBase;
/*  28 */         int[] arrayOfInt = nBTTagIntArray.func_150302_c();
/*  29 */         if (arrayOfInt.length == 1) {
/*  30 */           return arrayOfInt[0];
/*     */         }
/*  32 */         int i = 0;
/*  33 */         int j = 0;
/*  34 */         int k = 0;
/*  35 */         for (int m : arrayOfInt) {
/*  36 */           i += (m & 0xFF0000) >> 16;
/*  37 */           j += (m & 0xFF00) >> 8;
/*  38 */           k += (m & 0xFF) >> 0;
/*     */         } 
/*  40 */         i /= arrayOfInt.length;
/*  41 */         j /= arrayOfInt.length;
/*  42 */         k /= arrayOfInt.length;
/*  43 */         return i << 16 | j << 8 | k;
/*     */       } 
/*  45 */       return 9079434;
/*     */     } 
/*  47 */     return super.func_82790_a(p_82790_1_, p_82790_2_);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_77623_v() {
/*  52 */     return true;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static NBTBase func_150903_a(ItemStack p_150903_0_, String p_150903_1_) {
/*  56 */     if (p_150903_0_.func_77942_o()) {
/*  57 */       NBTTagCompound nBTTagCompound = p_150903_0_.func_77978_p().func_74775_l("Explosion");
/*  58 */       if (nBTTagCompound != null) {
/*  59 */         return nBTTagCompound.func_74781_a(p_150903_1_);
/*     */       }
/*     */     } 
/*  62 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_77624_a(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {
/*  68 */     if (p_77624_1_.func_77942_o()) {
/*  69 */       NBTTagCompound nBTTagCompound = p_77624_1_.func_77978_p().func_74775_l("Explosion");
/*  70 */       if (nBTTagCompound != null) {
/*  71 */         func_150902_a(nBTTagCompound, p_77624_3_);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static void func_150902_a(NBTTagCompound p_150902_0_, List<String> p_150902_1_) {
/*  78 */     byte b = p_150902_0_.func_74771_c("Type");
/*  79 */     if (b >= 0 && b <= 4) {
/*  80 */       p_150902_1_.add(StatCollector.func_74838_a("item.fireworksCharge.type." + b).trim());
/*     */     } else {
/*  82 */       p_150902_1_.add(StatCollector.func_74838_a("item.fireworksCharge.type").trim());
/*     */     } 
/*     */ 
/*     */     
/*  86 */     int[] arrayOfInt1 = p_150902_0_.func_74759_k("Colors");
/*  87 */     if (arrayOfInt1.length > 0) {
/*     */       
/*  89 */       boolean bool = true;
/*  90 */       String str = "";
/*  91 */       for (int i : arrayOfInt1) {
/*  92 */         if (!bool) {
/*  93 */           str = str + ", ";
/*     */         }
/*  95 */         bool = false;
/*     */ 
/*     */         
/*  98 */         boolean bool3 = false;
/*  99 */         for (byte b1 = 0; b1 < 16; b1++) {
/* 100 */           if (i == ItemDye.field_150922_c[b1]) {
/* 101 */             bool3 = true;
/* 102 */             str = str + StatCollector.func_74838_a("item.fireworksCharge." + ItemDye.field_150923_a[b1]);
/*     */             break;
/*     */           } 
/*     */         } 
/* 106 */         if (!bool3) {
/* 107 */           str = str + StatCollector.func_74838_a("item.fireworksCharge.customColor");
/*     */         }
/*     */       } 
/* 110 */       p_150902_1_.add(str);
/*     */     } 
/*     */ 
/*     */     
/* 114 */     int[] arrayOfInt2 = p_150902_0_.func_74759_k("FadeColors");
/* 115 */     if (arrayOfInt2.length > 0) {
/*     */       
/* 117 */       boolean bool = true;
/* 118 */       String str = StatCollector.func_74838_a("item.fireworksCharge.fadeTo") + " ";
/* 119 */       for (int i : arrayOfInt2) {
/* 120 */         if (!bool) {
/* 121 */           str = str + ", ";
/*     */         }
/* 123 */         bool = false;
/*     */ 
/*     */         
/* 126 */         boolean bool3 = false;
/* 127 */         for (byte b1 = 0; b1 < 16; b1++) {
/* 128 */           if (i == ItemDye.field_150922_c[b1]) {
/* 129 */             bool3 = true;
/* 130 */             str = str + StatCollector.func_74838_a("item.fireworksCharge." + ItemDye.field_150923_a[b1]);
/*     */             break;
/*     */           } 
/*     */         } 
/* 134 */         if (!bool3) {
/* 135 */           str = str + StatCollector.func_74838_a("item.fireworksCharge.customColor");
/*     */         }
/*     */       } 
/* 138 */       p_150902_1_.add(str);
/*     */     } 
/*     */ 
/*     */     
/* 142 */     boolean bool1 = p_150902_0_.func_74767_n("Trail");
/* 143 */     if (bool1) {
/* 144 */       p_150902_1_.add(StatCollector.func_74838_a("item.fireworksCharge.trail"));
/*     */     }
/*     */ 
/*     */     
/* 148 */     boolean bool2 = p_150902_0_.func_74767_n("Flicker");
/* 149 */     if (bool2) {
/* 150 */       p_150902_1_.add(StatCollector.func_74838_a("item.fireworksCharge.flicker"));
/*     */     }
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94581_a(IIconRegister p_94581_1_) {
/* 156 */     super.func_94581_a(p_94581_1_);
/* 157 */     this.field_150904_a = p_94581_1_.func_94245_a(func_111208_A() + "_overlay");
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemFireworkCharge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */