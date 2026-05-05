/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EnchantmentManager
/*     */ {
/*  15 */   private static final Random random = new Random();
/*     */   
/*     */   public static int getEnchantmentLevel(int paramInt, ItemStack paramItemStack) {
/*  18 */     if (paramItemStack == null) {
/*  19 */       return 0;
/*     */     }
/*  21 */     NBTTagList nBTTagList = paramItemStack.getEnchantments();
/*  22 */     if (nBTTagList == null) {
/*  23 */       return 0;
/*     */     }
/*  25 */     for (byte b = 0; b < nBTTagList.size(); b++) {
/*  26 */       short s1 = nBTTagList.get(b).getShort("id");
/*  27 */       short s2 = nBTTagList.get(b).getShort("lvl");
/*     */       
/*  29 */       if (s1 == paramInt) {
/*  30 */         return s2;
/*     */       }
/*     */     } 
/*  33 */     return 0;
/*     */   }
/*     */   
/*     */   public static Map a(ItemStack paramItemStack) {
/*  37 */     LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
/*  38 */     NBTTagList nBTTagList = (paramItemStack.getItem() == Items.ENCHANTED_BOOK) ? Items.ENCHANTED_BOOK.g(paramItemStack) : paramItemStack.getEnchantments();
/*     */     
/*  40 */     if (nBTTagList != null) {
/*  41 */       for (byte b = 0; b < nBTTagList.size(); b++) {
/*  42 */         short s1 = nBTTagList.get(b).getShort("id");
/*  43 */         short s2 = nBTTagList.get(b).getShort("lvl");
/*     */         
/*  45 */         linkedHashMap.put(Integer.valueOf(s1), Integer.valueOf(s2));
/*     */       } 
/*     */     }
/*     */     
/*  49 */     return linkedHashMap;
/*     */   }
/*     */   
/*     */   public static void a(Map paramMap, ItemStack paramItemStack) {
/*  53 */     NBTTagList nBTTagList = new NBTTagList();
/*     */     
/*  55 */     for (Iterator<Integer> iterator = paramMap.keySet().iterator(); iterator.hasNext(); ) { int i = ((Integer)iterator.next()).intValue();
/*  56 */       NBTTagCompound nBTTagCompound = new NBTTagCompound();
/*     */       
/*  58 */       nBTTagCompound.setShort("id", (short)i);
/*  59 */       nBTTagCompound.setShort("lvl", (short)((Integer)paramMap.get(Integer.valueOf(i))).intValue());
/*     */       
/*  61 */       nBTTagList.add(nBTTagCompound);
/*     */       
/*  63 */       if (paramItemStack.getItem() == Items.ENCHANTED_BOOK) {
/*  64 */         Items.ENCHANTED_BOOK.a(paramItemStack, new EnchantmentInstance(i, ((Integer)paramMap.get(Integer.valueOf(i))).intValue()));
/*     */       } }
/*     */ 
/*     */     
/*  68 */     if (nBTTagList.size() > 0) {
/*  69 */       if (paramItemStack.getItem() != Items.ENCHANTED_BOOK) {
/*  70 */         paramItemStack.a("ench", nBTTagList);
/*     */       }
/*  72 */     } else if (paramItemStack.hasTag()) {
/*  73 */       paramItemStack.getTag().remove("ench");
/*     */     } 
/*     */   }
/*     */   
/*     */   public static int getEnchantmentLevel(int paramInt, ItemStack[] paramArrayOfItemStack) {
/*  78 */     if (paramArrayOfItemStack == null) return 0; 
/*  79 */     int i = 0;
/*  80 */     for (ItemStack itemStack : paramArrayOfItemStack) {
/*  81 */       int j = getEnchantmentLevel(paramInt, itemStack);
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
/*     */   private static void a(EnchantmentModifier paramEnchantmentModifier, ItemStack paramItemStack) {
/*  94 */     if (paramItemStack == null) {
/*     */       return;
/*     */     }
/*  97 */     NBTTagList nBTTagList = paramItemStack.getEnchantments();
/*  98 */     if (nBTTagList == null) {
/*     */       return;
/*     */     }
/* 101 */     for (byte b = 0; b < nBTTagList.size(); b++) {
/* 102 */       short s1 = nBTTagList.get(b).getShort("id");
/* 103 */       short s2 = nBTTagList.get(b).getShort("lvl");
/*     */       
/* 105 */       if (Enchantment.byId[s1] != null) {
/* 106 */         paramEnchantmentModifier.a(Enchantment.byId[s1], s2);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void a(EnchantmentModifier paramEnchantmentModifier, ItemStack[] paramArrayOfItemStack) {
/* 112 */     for (ItemStack itemStack : paramArrayOfItemStack) {
/* 113 */       a(paramEnchantmentModifier, itemStack);
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
/* 127 */   private static final EnchantmentModifierProtection b = new EnchantmentModifierProtection(null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int a(ItemStack[] paramArrayOfItemStack, DamageSource paramDamageSource) {
/* 137 */     b.a = 0;
/* 138 */     b.b = paramDamageSource;
/*     */     
/* 140 */     a(b, paramArrayOfItemStack);
/*     */     
/* 142 */     if (b.a > 25) {
/* 143 */       b.a = 25;
/*     */     }
/*     */ 
/*     */     
/* 147 */     return (b.a + 1 >> 1) + random.nextInt((b.a >> 1) + 1);
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
/* 160 */   private static final EnchantmentModifierDamage c = new EnchantmentModifierDamage(null);
/*     */   
/*     */   public static float a(EntityLiving paramEntityLiving1, EntityLiving paramEntityLiving2) {
/* 163 */     return a(paramEntityLiving1.be(), paramEntityLiving2.getMonsterType());
/*     */   }
/*     */   
/*     */   public static float a(ItemStack paramItemStack, EnumMonsterType paramEnumMonsterType) {
/* 167 */     c.a = 0.0F;
/* 168 */     c.b = paramEnumMonsterType;
/*     */     
/* 170 */     a(c, paramItemStack);
/*     */     
/* 172 */     return c.a;
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
/* 185 */   private static final EnchantmentModifierThorns d = new EnchantmentModifierThorns(null);
/*     */   
/*     */   public static void a(EntityLiving paramEntityLiving, Entity paramEntity) {
/* 188 */     d.b = paramEntity;
/* 189 */     d.a = paramEntityLiving;
/* 190 */     a(d, paramEntityLiving.getEquipment());
/* 191 */     if (paramEntity instanceof EntityHuman) a(d, paramEntityLiving.be());
/*     */   
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
/* 204 */   private static final EnchantmentModifierArthropods e = new EnchantmentModifierArthropods(null);
/*     */   
/*     */   public static void b(EntityLiving paramEntityLiving, Entity paramEntity) {
/* 207 */     e.a = paramEntityLiving;
/* 208 */     e.b = paramEntity;
/* 209 */     a(e, paramEntityLiving.getEquipment());
/* 210 */     if (paramEntityLiving instanceof EntityHuman) a(e, paramEntityLiving.be()); 
/*     */   }
/*     */   
/*     */   public static int getKnockbackEnchantmentLevel(EntityLiving paramEntityLiving1, EntityLiving paramEntityLiving2) {
/* 214 */     return getEnchantmentLevel(Enchantment.KNOCKBACK.id, paramEntityLiving1.be());
/*     */   }
/*     */   
/*     */   public static int getFireAspectEnchantmentLevel(EntityLiving paramEntityLiving) {
/* 218 */     return getEnchantmentLevel(Enchantment.FIRE_ASPECT.id, paramEntityLiving.be());
/*     */   }
/*     */   
/*     */   public static int getOxygenEnchantmentLevel(EntityLiving paramEntityLiving) {
/* 222 */     return getEnchantmentLevel(Enchantment.OXYGEN.id, paramEntityLiving.getEquipment());
/*     */   }
/*     */   
/*     */   public static int getDigSpeedEnchantmentLevel(EntityLiving paramEntityLiving) {
/* 226 */     return getEnchantmentLevel(Enchantment.DIG_SPEED.id, paramEntityLiving.be());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean hasSilkTouchEnchantment(EntityLiving paramEntityLiving) {
/* 234 */     return (getEnchantmentLevel(Enchantment.SILK_TOUCH.id, paramEntityLiving.be()) > 0);
/*     */   }
/*     */   
/*     */   public static int getBonusBlockLootEnchantmentLevel(EntityLiving paramEntityLiving) {
/* 238 */     return getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS.id, paramEntityLiving.be());
/*     */   }
/*     */   
/*     */   public static int getLuckEnchantmentLevel(EntityLiving paramEntityLiving) {
/* 242 */     return getEnchantmentLevel(Enchantment.LUCK.id, paramEntityLiving.be());
/*     */   }
/*     */   
/*     */   public static int getLureEnchantmentLevel(EntityLiving paramEntityLiving) {
/* 246 */     return getEnchantmentLevel(Enchantment.LURE.id, paramEntityLiving.be());
/*     */   }
/*     */   
/*     */   public static int getBonusMonsterLootEnchantmentLevel(EntityLiving paramEntityLiving) {
/* 250 */     return getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS.id, paramEntityLiving.be());
/*     */   }
/*     */   
/*     */   public static boolean hasWaterWorkerEnchantment(EntityLiving paramEntityLiving) {
/* 254 */     return (getEnchantmentLevel(Enchantment.WATER_WORKER.id, paramEntityLiving.getEquipment()) > 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ItemStack a(Enchantment paramEnchantment, EntityLiving paramEntityLiving) {
/* 262 */     for (ItemStack itemStack : paramEntityLiving.getEquipment()) {
/* 263 */       if (itemStack != null && getEnchantmentLevel(paramEnchantment.id, itemStack) > 0) {
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
/*     */   public static int a(Random paramRandom, int paramInt1, int paramInt2, ItemStack paramItemStack) {
/* 283 */     Item item = paramItemStack.getItem();
/* 284 */     int i = item.c();
/*     */     
/* 286 */     if (i <= 0)
/*     */     {
/* 288 */       return 0;
/*     */     }
/*     */     
/* 291 */     if (paramInt2 > 15) {
/* 292 */       paramInt2 = 15;
/*     */     }
/* 294 */     int j = paramRandom.nextInt(8) + 1 + (paramInt2 >> 1) + paramRandom.nextInt(paramInt2 + 1);
/* 295 */     if (paramInt1 == 0) {
/* 296 */       return Math.max(j / 3, 1);
/*     */     }
/* 298 */     if (paramInt1 == 1) {
/* 299 */       return j * 2 / 3 + 1;
/*     */     }
/* 301 */     return Math.max(j, paramInt2 * 2);
/*     */   }
/*     */   
/*     */   public static ItemStack a(Random paramRandom, ItemStack paramItemStack, int paramInt) {
/* 305 */     List list = b(paramRandom, paramItemStack, paramInt);
/* 306 */     boolean bool = (paramItemStack.getItem() == Items.BOOK) ? true : false;
/*     */     
/* 308 */     if (bool) paramItemStack.setItem(Items.ENCHANTED_BOOK);
/*     */     
/* 310 */     if (list != null) {
/* 311 */       for (EnchantmentInstance enchantmentInstance : list) {
/* 312 */         if (bool) {
/* 313 */           Items.ENCHANTED_BOOK.a(paramItemStack, enchantmentInstance); continue;
/*     */         } 
/* 315 */         paramItemStack.addEnchantment(enchantmentInstance.enchantment, enchantmentInstance.level);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 320 */     return paramItemStack;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List b(Random paramRandom, ItemStack paramItemStack, int paramInt) {
/* 331 */     Item item = paramItemStack.getItem();
/* 332 */     int i = item.c();
/*     */     
/* 334 */     if (i <= 0) {
/* 335 */       return null;
/*     */     }
/* 337 */     i /= 2;
/* 338 */     i = 1 + paramRandom.nextInt((i >> 1) + 1) + paramRandom.nextInt((i >> 1) + 1);
/*     */     
/* 340 */     int j = i + paramInt;
/*     */ 
/*     */     
/* 343 */     float f = (paramRandom.nextFloat() + paramRandom.nextFloat() - 1.0F) * 0.15F;
/* 344 */     int k = (int)(j * (1.0F + f) + 0.5F);
/* 345 */     if (k < 1) {
/* 346 */       k = 1;
/*     */     }
/*     */     
/* 349 */     ArrayList<EnchantmentInstance> arrayList = null;
/*     */     
/* 351 */     Map map = b(k, paramItemStack);
/* 352 */     if (map != null && !map.isEmpty()) {
/*     */       
/* 354 */       EnchantmentInstance enchantmentInstance = (EnchantmentInstance)WeightedRandom.a(paramRandom, map.values());
/*     */       
/* 356 */       if (enchantmentInstance != null) {
/* 357 */         arrayList = new ArrayList();
/* 358 */         arrayList.add(enchantmentInstance);
/*     */         
/* 360 */         int m = k;
/* 361 */         while (paramRandom.nextInt(50) <= m) {
/*     */ 
/*     */           
/* 364 */           Iterator<Integer> iterator = map.keySet().iterator();
/* 365 */           while (iterator.hasNext()) {
/* 366 */             Integer integer = iterator.next();
/* 367 */             boolean bool = true;
/* 368 */             for (EnchantmentInstance enchantmentInstance1 : arrayList) {
/* 369 */               if (!enchantmentInstance1.enchantment.a(Enchantment.byId[integer.intValue()])) {
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
/* 380 */             EnchantmentInstance enchantmentInstance1 = (EnchantmentInstance)WeightedRandom.a(paramRandom, map.values());
/* 381 */             arrayList.add(enchantmentInstance1);
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
/*     */   public static Map b(int paramInt, ItemStack paramItemStack) {
/* 393 */     Item item = paramItemStack.getItem();
/* 394 */     HashMap<Object, Object> hashMap = null;
/* 395 */     boolean bool = (paramItemStack.getItem() == Items.BOOK) ? true : false;
/*     */     
/* 397 */     for (Enchantment enchantment : Enchantment.byId) {
/* 398 */       if (enchantment != null)
/*     */       {
/*     */ 
/*     */ 
/*     */         
/* 403 */         if (enchantment.slot.canEnchant(item) || bool)
/*     */         {
/*     */ 
/*     */           
/* 407 */           for (int i = enchantment.getStartLevel(); i <= enchantment.getMaxLevel(); i++) {
/* 408 */             if (paramInt >= enchantment.a(i) && paramInt <= enchantment.b(i)) {
/*     */               
/* 410 */               if (hashMap == null) {
/* 411 */                 hashMap = new HashMap<Object, Object>();
/*     */               }
/*     */               
/* 414 */               hashMap.put(Integer.valueOf(enchantment.id), new EnchantmentInstance(enchantment, i));
/*     */             } 
/*     */           }  } 
/*     */       }
/*     */     } 
/* 419 */     return hashMap;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\EnchantmentManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */