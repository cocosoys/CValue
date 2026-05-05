/*     */ package net.minecraft.enchantment;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ 
/*     */ public class EnchantmentHelper {
/*  15 */   private static final Random field_77522_a = new Random();
/*     */   
/*     */   public static int func_77506_a(int p_77506_0_, ItemStack p_77506_1_) {
/*  18 */     if (p_77506_1_ == null) {
/*  19 */       return 0;
/*     */     }
/*  21 */     NBTTagList nBTTagList = p_77506_1_.func_77986_q();
/*  22 */     if (nBTTagList == null) {
/*  23 */       return 0;
/*     */     }
/*  25 */     for (byte b = 0; b < nBTTagList.func_74745_c(); b++) {
/*  26 */       short s1 = nBTTagList.func_150305_b(b).func_74765_d("id");
/*  27 */       short s2 = nBTTagList.func_150305_b(b).func_74765_d("lvl");
/*     */       
/*  29 */       if (s1 == p_77506_0_) {
/*  30 */         return s2;
/*     */       }
/*     */     } 
/*  33 */     return 0;
/*     */   }
/*     */   
/*     */   public static Map func_82781_a(ItemStack p_82781_0_) {
/*  37 */     LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
/*  38 */     NBTTagList nBTTagList = (p_82781_0_.func_77973_b() == Items.field_151134_bR) ? Items.field_151134_bR.func_92110_g(p_82781_0_) : p_82781_0_.func_77986_q();
/*     */     
/*  40 */     if (nBTTagList != null) {
/*  41 */       for (byte b = 0; b < nBTTagList.func_74745_c(); b++) {
/*  42 */         short s1 = nBTTagList.func_150305_b(b).func_74765_d("id");
/*  43 */         short s2 = nBTTagList.func_150305_b(b).func_74765_d("lvl");
/*     */         
/*  45 */         linkedHashMap.put(Integer.valueOf(s1), Integer.valueOf(s2));
/*     */       } 
/*     */     }
/*     */     
/*  49 */     return linkedHashMap;
/*     */   }
/*     */   
/*     */   public static void func_82782_a(Map p_82782_0_, ItemStack p_82782_1_) {
/*  53 */     NBTTagList nBTTagList = new NBTTagList();
/*     */     
/*  55 */     for (Iterator<Integer> iterator = p_82782_0_.keySet().iterator(); iterator.hasNext(); ) { int i = ((Integer)iterator.next()).intValue();
/*  56 */       NBTTagCompound nBTTagCompound = new NBTTagCompound();
/*     */       
/*  58 */       nBTTagCompound.func_74777_a("id", (short)i);
/*  59 */       nBTTagCompound.func_74777_a("lvl", (short)((Integer)p_82782_0_.get(Integer.valueOf(i))).intValue());
/*     */       
/*  61 */       nBTTagList.func_74742_a((NBTBase)nBTTagCompound);
/*     */       
/*  63 */       if (p_82782_1_.func_77973_b() == Items.field_151134_bR) {
/*  64 */         Items.field_151134_bR.func_92115_a(p_82782_1_, new EnchantmentData(i, ((Integer)p_82782_0_.get(Integer.valueOf(i))).intValue()));
/*     */       } }
/*     */ 
/*     */     
/*  68 */     if (nBTTagList.func_74745_c() > 0) {
/*  69 */       if (p_82782_1_.func_77973_b() != Items.field_151134_bR) {
/*  70 */         p_82782_1_.func_77983_a("ench", (NBTBase)nBTTagList);
/*     */       }
/*  72 */     } else if (p_82782_1_.func_77942_o()) {
/*  73 */       p_82782_1_.func_77978_p().func_82580_o("ench");
/*     */     } 
/*     */   }
/*     */   
/*     */   public static int func_77511_a(int p_77511_0_, ItemStack[] p_77511_1_) {
/*  78 */     if (p_77511_1_ == null) return 0; 
/*  79 */     int i = 0;
/*  80 */     for (ItemStack itemStack : p_77511_1_) {
/*  81 */       int j = func_77506_a(p_77511_0_, itemStack);
/*  82 */       if (j > i) {
/*  83 */         i = j;
/*     */       }
/*     */     } 
/*  86 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void func_77518_a(IModifier p_77518_0_, ItemStack p_77518_1_) {
/*  94 */     if (p_77518_1_ == null) {
/*     */       return;
/*     */     }
/*  97 */     NBTTagList nBTTagList = p_77518_1_.func_77986_q();
/*  98 */     if (nBTTagList == null) {
/*     */       return;
/*     */     }
/* 101 */     for (byte b = 0; b < nBTTagList.func_74745_c(); b++) {
/* 102 */       short s1 = nBTTagList.func_150305_b(b).func_74765_d("id");
/* 103 */       short s2 = nBTTagList.func_150305_b(b).func_74765_d("lvl");
/*     */       
/* 105 */       if (Enchantment.field_77331_b[s1] != null) {
/* 106 */         p_77518_0_.func_77493_a(Enchantment.field_77331_b[s1], s2);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void func_77516_a(IModifier p_77516_0_, ItemStack[] p_77516_1_) {
/* 112 */     for (ItemStack itemStack : p_77516_1_)
/* 113 */       func_77518_a(p_77516_0_, itemStack); 
/*     */   }
/*     */   
/*     */   static final class ModifierDamage implements IModifier { public int field_77497_a;
/*     */     public DamageSource field_77496_b;
/*     */     private static final String __OBFID = "CL_00000114";
/*     */     
/*     */     private ModifierDamage() {}
/*     */     
/*     */     public void func_77493_a(Enchantment p_77493_1_, int p_77493_2_) {
/* 123 */       this.field_77497_a += p_77493_1_.func_77318_a(p_77493_2_, this.field_77496_b);
/*     */     } }
/*     */ 
/*     */   
/* 127 */   private static final ModifierDamage field_77520_b = new ModifierDamage();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int func_77508_a(ItemStack[] p_77508_0_, DamageSource p_77508_1_) {
/* 137 */     field_77520_b.field_77497_a = 0;
/* 138 */     field_77520_b.field_77496_b = p_77508_1_;
/*     */     
/* 140 */     func_77516_a(field_77520_b, p_77508_0_);
/*     */     
/* 142 */     if (field_77520_b.field_77497_a > 25) {
/* 143 */       field_77520_b.field_77497_a = 25;
/*     */     }
/*     */ 
/*     */     
/* 147 */     return (field_77520_b.field_77497_a + 1 >> 1) + field_77522_a.nextInt((field_77520_b.field_77497_a >> 1) + 1);
/*     */   }
/*     */   static final class ModifierLiving implements IModifier { public float field_77495_a;
/*     */     public EnumCreatureAttribute field_77494_b;
/*     */     private static final String __OBFID = "CL_00000112";
/*     */     
/*     */     private ModifierLiving() {}
/*     */     
/*     */     public void func_77493_a(Enchantment p_77493_1_, int p_77493_2_) {
/* 156 */       this.field_77495_a += p_77493_1_.func_152376_a(p_77493_2_, this.field_77494_b);
/*     */     } }
/*     */ 
/*     */   
/* 160 */   private static final ModifierLiving field_77521_c = new ModifierLiving();
/*     */   
/*     */   public static float func_77512_a(EntityLivingBase p_77512_0_, EntityLivingBase p_77512_1_) {
/* 163 */     return func_152377_a(p_77512_0_.func_70694_bm(), p_77512_1_.func_70668_bt());
/*     */   }
/*     */   
/*     */   public static float func_152377_a(ItemStack p_152377_0_, EnumCreatureAttribute p_152377_1_) {
/* 167 */     field_77521_c.field_77495_a = 0.0F;
/* 168 */     field_77521_c.field_77494_b = p_152377_1_;
/*     */     
/* 170 */     func_77518_a(field_77521_c, p_152377_0_);
/*     */     
/* 172 */     return field_77521_c.field_77495_a;
/*     */   }
/*     */   static final class HurtIterator implements IModifier { public EntityLivingBase field_151364_a;
/*     */     public Entity field_151363_b;
/*     */     private static final String __OBFID = "CL_00000110";
/*     */     
/*     */     private HurtIterator() {}
/*     */     
/*     */     public void func_77493_a(Enchantment p_77493_1_, int p_77493_2_) {
/* 181 */       p_77493_1_.func_151367_b(this.field_151364_a, this.field_151363_b, p_77493_2_);
/*     */     } }
/*     */ 
/*     */   
/* 185 */   private static final HurtIterator field_151388_d = new HurtIterator();
/*     */   
/*     */   public static void func_151384_a(EntityLivingBase p_151384_0_, Entity p_151384_1_) {
/* 188 */     field_151388_d.field_151363_b = p_151384_1_;
/* 189 */     field_151388_d.field_151364_a = p_151384_0_;
/* 190 */     func_77516_a(field_151388_d, p_151384_0_.func_70035_c());
/* 191 */     if (p_151384_1_ instanceof net.minecraft.entity.player.EntityPlayer) func_77518_a(field_151388_d, p_151384_0_.func_70694_bm()); 
/*     */   }
/*     */   static final class DamageIterator implements IModifier { public EntityLivingBase field_151366_a;
/*     */     public Entity field_151365_b;
/*     */     private static final String __OBFID = "CL_00000109";
/*     */     
/*     */     private DamageIterator() {}
/*     */     
/*     */     public void func_77493_a(Enchantment p_77493_1_, int p_77493_2_) {
/* 200 */       p_77493_1_.func_151368_a(this.field_151366_a, this.field_151365_b, p_77493_2_);
/*     */     } }
/*     */ 
/*     */   
/* 204 */   private static final DamageIterator field_151389_e = new DamageIterator(); private static final String __OBFID = "CL_00000107";
/*     */   
/*     */   public static void func_151385_b(EntityLivingBase p_151385_0_, Entity p_151385_1_) {
/* 207 */     field_151389_e.field_151366_a = p_151385_0_;
/* 208 */     field_151389_e.field_151365_b = p_151385_1_;
/* 209 */     func_77516_a(field_151389_e, p_151385_0_.func_70035_c());
/* 210 */     if (p_151385_0_ instanceof net.minecraft.entity.player.EntityPlayer) func_77518_a(field_151389_e, p_151385_0_.func_70694_bm()); 
/*     */   }
/*     */   
/*     */   public static int func_77507_b(EntityLivingBase p_77507_0_, EntityLivingBase p_77507_1_) {
/* 214 */     return func_77506_a(Enchantment.field_77337_m.field_77352_x, p_77507_0_.func_70694_bm());
/*     */   }
/*     */   
/*     */   public static int func_90036_a(EntityLivingBase p_90036_0_) {
/* 218 */     return func_77506_a(Enchantment.field_77334_n.field_77352_x, p_90036_0_.func_70694_bm());
/*     */   }
/*     */   
/*     */   public static int func_77501_a(EntityLivingBase p_77501_0_) {
/* 222 */     return func_77511_a(Enchantment.field_77340_h.field_77352_x, p_77501_0_.func_70035_c());
/*     */   }
/*     */   
/*     */   public static int func_77509_b(EntityLivingBase p_77509_0_) {
/* 226 */     return func_77506_a(Enchantment.field_77349_p.field_77352_x, p_77509_0_.func_70694_bm());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean func_77502_d(EntityLivingBase p_77502_0_) {
/* 234 */     return (func_77506_a(Enchantment.field_77348_q.field_77352_x, p_77502_0_.func_70694_bm()) > 0);
/*     */   }
/*     */   
/*     */   public static int func_77517_e(EntityLivingBase p_77517_0_) {
/* 238 */     return func_77506_a(Enchantment.field_77346_s.field_77352_x, p_77517_0_.func_70694_bm());
/*     */   }
/*     */   
/*     */   public static int func_151386_g(EntityLivingBase p_151386_0_) {
/* 242 */     return func_77506_a(Enchantment.field_151370_z.field_77352_x, p_151386_0_.func_70694_bm());
/*     */   }
/*     */   
/*     */   public static int func_151387_h(EntityLivingBase p_151387_0_) {
/* 246 */     return func_77506_a(Enchantment.field_151369_A.field_77352_x, p_151387_0_.func_70694_bm());
/*     */   }
/*     */   
/*     */   public static int func_77519_f(EntityLivingBase p_77519_0_) {
/* 250 */     return func_77506_a(Enchantment.field_77335_o.field_77352_x, p_77519_0_.func_70694_bm());
/*     */   }
/*     */   
/*     */   public static boolean func_77510_g(EntityLivingBase p_77510_0_) {
/* 254 */     return (func_77511_a(Enchantment.field_77341_i.field_77352_x, p_77510_0_.func_70035_c()) > 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ItemStack func_92099_a(Enchantment p_92099_0_, EntityLivingBase p_92099_1_) {
/* 262 */     for (ItemStack itemStack : p_92099_1_.func_70035_c()) {
/* 263 */       if (itemStack != null && func_77506_a(p_92099_0_.field_77352_x, itemStack) > 0) {
/* 264 */         return itemStack;
/*     */       }
/*     */     } 
/*     */     
/* 268 */     return null;
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
/*     */   public static int func_77514_a(Random p_77514_0_, int p_77514_1_, int p_77514_2_, ItemStack p_77514_3_) {
/* 283 */     Item item = p_77514_3_.func_77973_b();
/* 284 */     int i = item.func_77619_b();
/*     */     
/* 286 */     if (i <= 0)
/*     */     {
/* 288 */       return 0;
/*     */     }
/*     */     
/* 291 */     if (p_77514_2_ > 15) {
/* 292 */       p_77514_2_ = 15;
/*     */     }
/* 294 */     int j = p_77514_0_.nextInt(8) + 1 + (p_77514_2_ >> 1) + p_77514_0_.nextInt(p_77514_2_ + 1);
/* 295 */     if (p_77514_1_ == 0) {
/* 296 */       return Math.max(j / 3, 1);
/*     */     }
/* 298 */     if (p_77514_1_ == 1) {
/* 299 */       return j * 2 / 3 + 1;
/*     */     }
/* 301 */     return Math.max(j, p_77514_2_ * 2);
/*     */   }
/*     */   
/*     */   public static ItemStack func_77504_a(Random p_77504_0_, ItemStack p_77504_1_, int p_77504_2_) {
/* 305 */     List list = func_77513_b(p_77504_0_, p_77504_1_, p_77504_2_);
/* 306 */     boolean bool = (p_77504_1_.func_77973_b() == Items.field_151122_aG) ? true : false;
/*     */     
/* 308 */     if (bool) p_77504_1_.func_150996_a((Item)Items.field_151134_bR);
/*     */     
/* 310 */     if (list != null) {
/* 311 */       for (EnchantmentData enchantmentData : list) {
/* 312 */         if (bool) {
/* 313 */           Items.field_151134_bR.func_92115_a(p_77504_1_, enchantmentData); continue;
/*     */         } 
/* 315 */         p_77504_1_.func_77966_a(enchantmentData.field_76302_b, enchantmentData.field_76303_c);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 320 */     return p_77504_1_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List func_77513_b(Random p_77513_0_, ItemStack p_77513_1_, int p_77513_2_) {
/* 331 */     Item item = p_77513_1_.func_77973_b();
/* 332 */     int i = item.func_77619_b();
/*     */     
/* 334 */     if (i <= 0) {
/* 335 */       return null;
/*     */     }
/* 337 */     i /= 2;
/* 338 */     i = 1 + p_77513_0_.nextInt((i >> 1) + 1) + p_77513_0_.nextInt((i >> 1) + 1);
/*     */     
/* 340 */     int j = i + p_77513_2_;
/*     */ 
/*     */     
/* 343 */     float f = (p_77513_0_.nextFloat() + p_77513_0_.nextFloat() - 1.0F) * 0.15F;
/* 344 */     int k = (int)(j * (1.0F + f) + 0.5F);
/* 345 */     if (k < 1) {
/* 346 */       k = 1;
/*     */     }
/*     */     
/* 349 */     ArrayList<EnchantmentData> arrayList = null;
/*     */     
/* 351 */     Map map = func_77505_b(k, p_77513_1_);
/* 352 */     if (map != null && !map.isEmpty()) {
/*     */       
/* 354 */       EnchantmentData enchantmentData = (EnchantmentData)WeightedRandom.func_76271_a(p_77513_0_, map.values());
/*     */       
/* 356 */       if (enchantmentData != null) {
/* 357 */         arrayList = new ArrayList();
/* 358 */         arrayList.add(enchantmentData);
/*     */         
/* 360 */         int m = k;
/* 361 */         while (p_77513_0_.nextInt(50) <= m) {
/*     */ 
/*     */           
/* 364 */           Iterator<Integer> iterator = map.keySet().iterator();
/* 365 */           while (iterator.hasNext()) {
/* 366 */             Integer integer = iterator.next();
/* 367 */             boolean bool = true;
/* 368 */             for (EnchantmentData enchantmentData1 : arrayList) {
/* 369 */               if (!enchantmentData1.field_76302_b.func_77326_a(Enchantment.field_77331_b[integer.intValue()])) {
/* 370 */                 bool = false;
/*     */                 break;
/*     */               } 
/*     */             } 
/* 374 */             if (!bool) {
/* 375 */               iterator.remove();
/*     */             }
/*     */           } 
/*     */           
/* 379 */           if (!map.isEmpty()) {
/* 380 */             EnchantmentData enchantmentData1 = (EnchantmentData)WeightedRandom.func_76271_a(p_77513_0_, map.values());
/* 381 */             arrayList.add(enchantmentData1);
/*     */           } 
/*     */           
/* 384 */           m >>= 1;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 389 */     return arrayList;
/*     */   }
/*     */   
/*     */   public static Map func_77505_b(int p_77505_0_, ItemStack p_77505_1_) {
/* 393 */     Item item = p_77505_1_.func_77973_b();
/* 394 */     HashMap<Object, Object> hashMap = null;
/* 395 */     boolean bool = (p_77505_1_.func_77973_b() == Items.field_151122_aG) ? true : false;
/*     */     
/* 397 */     for (Enchantment enchantment : Enchantment.field_77331_b) {
/* 398 */       if (enchantment != null)
/*     */       {
/*     */ 
/*     */ 
/*     */         
/* 403 */         if (enchantment.field_77351_y.func_77557_a(item) || bool)
/*     */         {
/*     */ 
/*     */           
/* 407 */           for (int i = enchantment.func_77319_d(); i <= enchantment.func_77325_b(); i++) {
/* 408 */             if (p_77505_0_ >= enchantment.func_77321_a(i) && p_77505_0_ <= enchantment.func_77317_b(i)) {
/*     */               
/* 410 */               if (hashMap == null) {
/* 411 */                 hashMap = new HashMap<Object, Object>();
/*     */               }
/*     */               
/* 414 */               hashMap.put(Integer.valueOf(enchantment.field_77352_x), new EnchantmentData(enchantment, i));
/*     */             } 
/*     */           }  } 
/*     */       }
/*     */     } 
/* 419 */     return hashMap;
/*     */   }
/*     */   
/*     */   static interface IModifier {
/*     */     void func_77493_a(Enchantment param1Enchantment, int param1Int);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\enchantment\EnchantmentHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */