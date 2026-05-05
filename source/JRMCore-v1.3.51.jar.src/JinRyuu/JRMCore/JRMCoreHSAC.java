/*     */ package JinRyuu.JRMCore;
/*     */ 
/*     */ import com.jin_ryuu.SwordArtC.Main;
/*     */ import com.jin_ryuu.SwordArtC.items.ModItems;
/*     */ import java.util.Random;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemArmor;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.ItemSword;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraftforge.common.util.EnumHelper;
/*     */ import net.minecraftforge.event.entity.item.ItemEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingDropsEvent;
/*     */ import net.minecraftforge.event.entity.player.ItemTooltipEvent;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JRMCoreHSAC
/*     */ {
/*  29 */   public static ItemArmor.ArmorMaterial GI = EnumHelper.addArmorMaterial("GI", 15, new int[] { 3, 5, 5, 5 }, 20);
/*  30 */   public static ItemArmor.ArmorMaterial GI2 = EnumHelper.addArmorMaterial("GI", 25, new int[] { 3, 5, 5, 5 }, 20);
/*     */   
/*  32 */   public static Item.ToolMaterial SWORDSHORT = EnumHelper.addToolMaterial("SWORDSHORT", 1, 600, 6.0F, 1.0F, 20);
/*  33 */   public static Item.ToolMaterial SWORDLONG = EnumHelper.addToolMaterial("SWORDLONG", 1, 750, 6.0F, 2.0F, 20);
/*  34 */   public static Item.ToolMaterial CURVED = EnumHelper.addToolMaterial("CURVED", 1, 700, 6.0F, 1.0F, 20);
/*  35 */   public static Item.ToolMaterial DAGGER = EnumHelper.addToolMaterial("DAGGER", 1, 500, 6.0F, 1.0F, 20);
/*  36 */   public static Item.ToolMaterial RAPIER = EnumHelper.addToolMaterial("RAPIER", 1, 850, 6.0F, 1.0F, 20);
/*  37 */   public static Item.ToolMaterial AXE = EnumHelper.addToolMaterial("AXE", 1, 500, 6.0F, 1.0F, 20);
/*  38 */   public static Item.ToolMaterial SPEAR = EnumHelper.addToolMaterial("SPEAR", 1, 800, 6.0F, 2.0F, 20);
/*  39 */   public static Item.ToolMaterial BATTLEAXE = EnumHelper.addToolMaterial("BATTLEAXE", 1, 950, 6.0F, 3.0F, 20);
/*  40 */   public static Item.ToolMaterial WARHAMMER = EnumHelper.addToolMaterial("WARHAMMER", 1, 850, 6.0F, 3.0F, 20);
/*  41 */   public static Item.ToolMaterial SWORD2 = EnumHelper.addToolMaterial("SWORD2", 1, 900, 6.0F, 2.0F, 20);
/*  42 */   public static Item.ToolMaterial KATANA = EnumHelper.addToolMaterial("KATANA", 1, 1000, 6.0F, 2.0F, 20);
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int ah_sword = 10;
/*     */ 
/*     */   
/*     */   public static final int ah_spear = 11;
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ah(Item i, int d) {
/*  54 */     if (i instanceof ItemSword) {
/*  55 */       if (((ItemSword)i).func_150932_j().equals(SWORDSHORT.name())) {
/*  56 */         return 10;
/*     */       }
/*  58 */       if (((ItemSword)i).func_150932_j().equals(SPEAR.name())) {
/*  59 */         return 11;
/*     */       }
/*  61 */       return d;
/*     */     } 
/*  63 */     return d;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void openGui(int id, EntityPlayer pl) {
/*  69 */     pl.openGui(Main.instance, id, pl.field_70170_p, (int)pl.field_70165_t, (int)pl.field_70163_u, (int)pl.field_70161_v);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void initGui() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void actionPerformed(GuiButton button) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void drawScreen(int x, int y, float f) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class skill {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void initSkls() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int SAO_() {
/* 110 */     return 0;
/*     */   }
/*     */   public static int SAO_getDropLevelBasedOnCoord(Entity e) {
/* 113 */     double x = e.field_70165_t;
/* 114 */     double z = e.field_70161_v;
/* 115 */     return (int)MathHelper.func_76133_a(x * x + z * z);
/*     */   }
/*     */   public static int SAO_getLvlBasedOnDrop(Entity e) {
/* 118 */     int i = 1 + SAO_getDropLevelBasedOnCoord(e) / 200;
/* 119 */     return (i > 300) ? 300 : i;
/*     */   }
/*     */   
/* 122 */   public static final String[] bonusesCanBe = new String[] { "atr", "skill" }; public static final int atr_STR = 0;
/*     */   public static final int atr_AGI = 1;
/*     */   
/*     */   public static String[] SAO_getRandomBonus(int requ) {
/* 126 */     String[] s = new String[3]; s[0] = "0"; s[1] = "0"; s[2] = "";
/* 127 */     int ri = 1 + (new Random()).nextInt(3);
/* 128 */     ri = (ri > 2) ? 2 : ri;
/* 129 */     int rmv = (new Random()).nextInt(requ * 2);
/*     */     
/* 131 */     for (int i = 0; i < ri; i++) {
/* 132 */       int grmv = (new Random()).nextInt(rmv + 1);
/* 133 */       rmv -= grmv;
/* 134 */       s[i] = "" + grmv;
/*     */     } 
/*     */     
/* 137 */     return s;
/*     */   }
/*     */   public static final int atr_Skill = 2;
/*     */   public static final String lvlItem = "lvlItem";
/*     */   public static final String lvlUpgrade = "lvlUpgrade";
/*     */   public static final String attackMin = "attackMin";
/*     */   public static final String attackMax = "attackMax";
/*     */   public static final String requires = "requires";
/*     */   
/*     */   public static void addSAOWeaponStats(ItemStack p_92115_1_, Object... args) {
/* 147 */     NBTTagList nbttaglist = SAO_WeaponStatsNBTTag(p_92115_1_);
/*     */     
/* 149 */     boolean flag = true;
/*     */     
/* 151 */     for (int i = 0; i < nbttaglist.func_74745_c(); i++) {
/*     */       
/* 153 */       NBTTagCompound nbttagcompound = nbttaglist.func_150305_b(i);
/*     */       
/* 155 */       if (nbttagcompound.func_74779_i("category").length() > 3) {
/*     */         return;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 161 */     if (flag) {
/*     */       
/* 163 */       NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/* 164 */       nbttagcompound1.func_74778_a("name", "" + args[0]);
/* 165 */       nbttagcompound1.func_74778_a("category", "" + weaponCategory(p_92115_1_.func_77977_a()));
/* 166 */       nbttagcompound1.func_74768_a("lvlItem", Integer.parseInt("" + args[1]));
/* 167 */       nbttagcompound1.func_74768_a("lvlUpgrade", Integer.parseInt("" + args[2]));
/* 168 */       nbttagcompound1.func_74768_a("attackMin", Integer.parseInt("" + args[3]));
/* 169 */       nbttagcompound1.func_74768_a("attackMax", Integer.parseInt("" + args[4]));
/* 170 */       nbttagcompound1.func_74768_a("requires", Integer.parseInt("" + args[5]));
/* 171 */       nbttagcompound1.func_74778_a("bonuses", "" + args[6]);
/* 172 */       nbttaglist.func_74742_a((NBTBase)nbttagcompound1);
/*     */     } 
/*     */     
/* 175 */     if (!p_92115_1_.func_77942_o())
/*     */     {
/* 177 */       p_92115_1_.func_77982_d(new NBTTagCompound());
/*     */     }
/*     */     
/* 180 */     p_92115_1_.func_77978_p().func_74782_a("SAOWeaponStats", (NBTBase)nbttaglist);
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
/*     */   public static NBTTagList SAO_WeaponStatsNBTTag(ItemStack p_92110_1_) {
/* 266 */     return (p_92110_1_.field_77990_d != null && p_92110_1_.field_77990_d.func_74764_b("SAOWeaponStats")) ? (NBTTagList)p_92110_1_.field_77990_d.func_74781_a("SAOWeaponStats") : new NBTTagList();
/*     */   }
/*     */   
/*     */   public static void onItemTooltipEvent(ItemTooltipEvent event) {
/* 270 */     if (event.itemStack.func_77973_b() instanceof ItemSword) {
/*     */       
/* 272 */       NBTTagList nbttaglist = SAO_WeaponStatsNBTTag(event.itemStack);
/*     */       
/* 274 */       if (nbttaglist != null)
/*     */       {
/* 276 */         for (int i = 0; i < nbttaglist.func_74745_c(); i++) {
/*     */           
/* 278 */           String name = nbttaglist.func_150305_b(i).func_74779_i("name");
/* 279 */           String category = nbttaglist.func_150305_b(i).func_74779_i("category");
/* 280 */           int lvlItem = nbttaglist.func_150305_b(i).func_74762_e("lvlItem");
/* 281 */           int lvlUpgrade = nbttaglist.func_150305_b(i).func_74762_e("lvlUpgrade");
/* 282 */           int attackMin = nbttaglist.func_150305_b(i).func_74762_e("attackMin");
/* 283 */           int attackMax = nbttaglist.func_150305_b(i).func_74762_e("attackMax");
/* 284 */           int requires = nbttaglist.func_150305_b(i).func_74762_e("requires");
/* 285 */           String[] bonuses = nbttaglist.func_150305_b(i).func_74779_i("bonuses").split(";");
/* 286 */           name = "";
/* 287 */           event.toolTip.add(name + ((lvlUpgrade > 0) ? (" +" + lvlUpgrade) : ""));
/* 288 */           event.toolTip.add(weaponCatName(category));
/* 289 */           event.toolTip.add("Attack: " + attackMin + "-" + attackMax);
/* 290 */           event.toolTip.add("Type: " + weaponTypes(category));
/* 291 */           event.toolTip.add("Durability: " + (event.itemStack.func_77958_k() - event.itemStack.func_77952_i()));
/* 292 */           event.toolTip.add("Requires: " + requires);
/*     */           
/* 294 */           String[] bonusNams = { "Strength", "Agility" };
/* 295 */           for (int j = 0; j < bonusNams.length; j++) {
/* 296 */             if (Integer.parseInt(bonuses[j]) > 0) event.toolTip.add(bonusNams[j] + ": " + bonuses[j]);
/*     */           
/*     */           } 
/*     */         } 
/*     */       }
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
/*     */   public static float getDamage(int dmg, int str, int dex) {
/* 324 */     return JRMCoreH.round((dmg + str) + 0.3F * dex, 0, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getWeaponDamage(ItemStack p_77624_1_, int STR) {
/* 329 */     if (p_77624_1_ != null) {
/* 330 */       NBTTagList nbttaglist = SAO_WeaponStatsNBTTag(p_77624_1_);
/* 331 */       if (nbttaglist != null) {
/* 332 */         int i = 0; if (i < nbttaglist.func_74745_c()) {
/* 333 */           int max = nbttaglist.func_150305_b(i).func_74762_e("attackMax");
/* 334 */           int min = nbttaglist.func_150305_b(i).func_74762_e("attackMin");
/* 335 */           int requ = nbttaglist.func_150305_b(i).func_74762_e("requires");
/* 336 */           boolean b = (requ <= STR);
/* 337 */           Random r = new Random();
/* 338 */           int dmg = min + ((max - min <= 1) ? 1 : r.nextInt(max - min));
/* 339 */           return b ? dmg : 1;
/*     */         } 
/*     */       } 
/*     */     } 
/* 343 */     return 1;
/*     */   }
/*     */   
/*     */   public static int getWeaponBonus(ItemStack p_77624_1_, int bonus) {
/* 347 */     if (p_77624_1_ != null) {
/* 348 */       NBTTagList nbttaglist = SAO_WeaponStatsNBTTag(p_77624_1_);
/* 349 */       if (nbttaglist != null) {
/* 350 */         int i = 0; if (i < nbttaglist.func_74745_c())
/* 351 */         { String[] bonuses = nbttaglist.func_150305_b(i).func_74779_i("bonuses").split(";");
/* 352 */           return Integer.parseInt(bonuses[bonus]); } 
/*     */       } 
/* 354 */     }  return 0;
/*     */   }
/*     */   
/*     */   public static int getWeaponStatName(ItemStack p_77624_1_, String statname) {
/* 358 */     if (p_77624_1_ != null) {
/* 359 */       NBTTagList nbttaglist = SAO_WeaponStatsNBTTag(p_77624_1_);
/* 360 */       if (nbttaglist != null) {
/* 361 */         int i = 0; if (i < nbttaglist.func_74745_c())
/* 362 */           return nbttaglist.func_150305_b(i).func_74762_e(statname); 
/*     */       } 
/* 364 */     }  return 0;
/*     */   }
/*     */   
/*     */   public static int getWeaponEquip(ItemStack p_77624_1_) {
/* 368 */     if (p_77624_1_ != null) {
/* 369 */       NBTTagList nbttaglist = SAO_WeaponStatsNBTTag(p_77624_1_);
/* 370 */       if (nbttaglist != null) {
/* 371 */         int i = 0; if (i < nbttaglist.func_74745_c())
/* 372 */         { int attackMax = nbttaglist.func_150305_b(i).func_74762_e("attackMax");
/* 373 */           return getWeaponEquip(p_77624_1_, attackMax); } 
/*     */       } 
/* 375 */     }  return 0;
/*     */   }
/*     */   
/*     */   public static String weaponTypes(String category) {
/* 379 */     String cat = JRMCoreH.SAO_SkillMap_WeaponTypes[0];
/* 380 */     for (int i = 0; i < JRMCoreH.SAO_SkillMap_Weapons.length; i++) {
/* 381 */       if (JRMCoreH.SAO_SkillMap_Weapons[i].equalsIgnoreCase(category)) {
/* 382 */         cat = JRMCoreH.SAO_SkillMap_WeaponTypes[i];
/*     */       }
/*     */     } 
/* 385 */     return cat;
/*     */   }
/*     */   public static String weaponCategory(String unLocName) {
/* 388 */     String cat = JRMCoreH.SAO_SkillMap_Weapons[0]; int i;
/* 389 */     for (i = 0; i < JRMCoreH.SAO_Weapon_Cat_Sword.length; i++) {
/* 390 */       if (unLocName.contains(JRMCoreH.SAO_Weapon_Cat_Sword[i])) return JRMCoreH.SAO_SkillMap_Weapons[0]; 
/*     */     } 
/* 392 */     for (i = 0; i < JRMCoreH.SAO_Weapon_Cat_Curved.length; i++) {
/* 393 */       if (unLocName.contains(JRMCoreH.SAO_Weapon_Cat_Curved[i])) return JRMCoreH.SAO_SkillMap_Weapons[1]; 
/*     */     } 
/* 395 */     for (i = 0; i < JRMCoreH.SAO_Weapon_Cat_Dagger.length; i++) {
/* 396 */       if (unLocName.contains(JRMCoreH.SAO_Weapon_Cat_Dagger[i])) return JRMCoreH.SAO_SkillMap_Weapons[2]; 
/*     */     } 
/* 398 */     for (i = 0; i < JRMCoreH.SAO_Weapon_Cat_Rapier.length; i++) {
/* 399 */       if (unLocName.contains(JRMCoreH.SAO_Weapon_Cat_Rapier[i])) return JRMCoreH.SAO_SkillMap_Weapons[3]; 
/*     */     } 
/* 401 */     for (i = 0; i < JRMCoreH.SAO_Weapon_Cat_Axe.length; i++) {
/* 402 */       if (unLocName.contains(JRMCoreH.SAO_Weapon_Cat_Axe[i])) return JRMCoreH.SAO_SkillMap_Weapons[4]; 
/*     */     } 
/* 404 */     for (i = 0; i < JRMCoreH.SAO_Weapon_Cat_Spear.length; i++) {
/* 405 */       if (unLocName.contains(JRMCoreH.SAO_Weapon_Cat_Spear[i])) return JRMCoreH.SAO_SkillMap_Weapons[7]; 
/*     */     } 
/* 407 */     for (i = 0; i < JRMCoreH.SAO_Weapon_Cat_BattleAxe.length; i++) {
/* 408 */       if (unLocName.contains(JRMCoreH.SAO_Weapon_Cat_BattleAxe[i])) return JRMCoreH.SAO_SkillMap_Weapons[8]; 
/*     */     } 
/* 410 */     for (i = 0; i < JRMCoreH.SAO_Weapon_Cat_WarHammer.length; i++) {
/* 411 */       if (unLocName.contains(JRMCoreH.SAO_Weapon_Cat_WarHammer[i])) return JRMCoreH.SAO_SkillMap_Weapons[9]; 
/*     */     } 
/* 413 */     for (i = 0; i < JRMCoreH.SAO_Weapon_Cat_Sword2.length; i++) {
/* 414 */       if (unLocName.contains(JRMCoreH.SAO_Weapon_Cat_Sword2[i])) return JRMCoreH.SAO_SkillMap_Weapons[6]; 
/*     */     } 
/* 416 */     for (i = 0; i < JRMCoreH.SAO_Weapon_Cat_Katana.length; i++) {
/* 417 */       if (unLocName.contains(JRMCoreH.SAO_Weapon_Cat_Katana[i])) return JRMCoreH.SAO_SkillMap_Weapons[10]; 
/*     */     } 
/* 419 */     return cat;
/*     */   }
/*     */   public static String weaponCatName(String category) {
/* 422 */     return JRMCoreH.trl("saoc", "category." + category);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getWeaponEquip(ItemStack is, int atkmax) {
/* 457 */     return (is.func_77958_k() + atkmax) / 100;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWeaponName(String name) {
/* 464 */     return JRMCoreH.trl("saoc", "weapon." + name);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void onEntityDrop(LivingDropsEvent event) {
/* 469 */     if (event.source.func_76355_l().equals("player"))
/*     */     {
/* 471 */       if (event.entity instanceof net.minecraft.entity.monster.EntityMob) {
/* 472 */         int rand = (int)(Math.random() * 100.0D);
/*     */         
/* 474 */         if (rand < 95) {
/* 475 */           int r = (int)(Math.random() * 100.0D);
/*     */           
/* 477 */           Item wep = ModItems.ItemsOW[(new Random()).nextInt(ModItems.ItemsOW.length)];
/*     */           
/* 479 */           ItemStack stack = new ItemStack(wep, 1, 1);
/* 480 */           if (stack != null) {
/* 481 */             Item item = stack.func_77973_b();
/* 482 */             if (item != null && item instanceof ItemSword) {
/* 483 */               String category = weaponCategory(((ItemSword)wep).func_150932_j());
/* 484 */               int lvlItem = SAO_getLvlBasedOnDrop((Entity)event.entityLiving);
/* 485 */               int attackMin = 1 + (new Random()).nextInt((int)(lvlItem * 8.0F));
/* 486 */               int attackMax = 3 + (new Random()).nextInt((int)(lvlItem * 10.0F));
/* 487 */               if (attackMin > attackMax) {
/* 488 */                 attackMax = attackMin;
/* 489 */                 attackMin /= 2;
/*     */               } 
/* 491 */               int requires = lvlItem;
/* 492 */               String[] b = SAO_getRandomBonus(requires);
/* 493 */               String bonuses = "";
/* 494 */               for (int i = 0; i < b.length; i++) {
/* 495 */                 bonuses = bonuses + b[i] + ";";
/*     */               }
/* 497 */               addSAOWeaponStats(stack, new Object[] { "RandomName", "" + lvlItem, "0", "" + attackMin, "" + attackMax, "" + requires, bonuses });
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 502 */               event.drops.add(new EntityItem(event.entity.field_70170_p, event.entity.field_70165_t, event.entity.field_70163_u, event.entity.field_70161_v, stack));
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void onItemEvent(ItemEvent event) {
/* 514 */     Entity p = event.entity;
/* 515 */     if (p != null) {
/* 516 */       ItemStack stack = event.entityItem.func_92059_d();
/* 517 */       if (stack != null) {
/* 518 */         Item item = stack.func_77973_b();
/* 519 */         if (item != null && item instanceof ItemSword) {
/* 520 */           String category = weaponCategory(stack.func_77977_a());
/* 521 */           int lvlItem = SAO_getLvlBasedOnDrop(p);
/* 522 */           int attackMin = 1 + (new Random()).nextInt((int)(lvlItem * 8.0F));
/* 523 */           int attackMax = 3 + (new Random()).nextInt((int)(lvlItem * 10.0F));
/* 524 */           if (attackMin > attackMax) {
/* 525 */             attackMax = attackMin;
/* 526 */             attackMin /= 2;
/*     */           } 
/* 528 */           int requires = lvlItem;
/* 529 */           String[] b = SAO_getRandomBonus(requires);
/* 530 */           String bonuses = "";
/* 531 */           for (int i = 0; i < b.length; i++) {
/* 532 */             bonuses = bonuses + b[i] + ";";
/*     */           }
/* 534 */           addSAOWeaponStats(stack, new Object[] { "RandomName", "" + lvlItem, "0", "" + attackMin, "" + attackMax, "" + requires, bonuses });
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCoreHSAC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */