/*     */ package net.minecraftforge.common;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Random;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.WeightedRandom;
/*     */ import net.minecraft.util.WeightedRandomChestContent;
/*     */ import net.minecraft.world.WorldServer;
/*     */ import net.minecraft.world.gen.feature.WorldGenDungeons;
/*     */ import net.minecraft.world.gen.structure.ComponentScatteredFeaturePieces;
/*     */ import net.minecraft.world.gen.structure.StructureMineshaftPieces;
/*     */ import net.minecraft.world.gen.structure.StructureStrongholdPieces;
/*     */ import net.minecraft.world.gen.structure.StructureVillagePieces;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ChestGenHooks
/*     */ {
/*     */   public static final String MINESHAFT_CORRIDOR = "mineshaftCorridor";
/*     */   public static final String PYRAMID_DESERT_CHEST = "pyramidDesertyChest";
/*     */   public static final String PYRAMID_JUNGLE_CHEST = "pyramidJungleChest";
/*     */   public static final String PYRAMID_JUNGLE_DISPENSER = "pyramidJungleDispenser";
/*     */   public static final String STRONGHOLD_CORRIDOR = "strongholdCorridor";
/*     */   public static final String STRONGHOLD_LIBRARY = "strongholdLibrary";
/*     */   public static final String STRONGHOLD_CROSSING = "strongholdCrossing";
/*     */   public static final String VILLAGE_BLACKSMITH = "villageBlacksmith";
/*     */   public static final String BONUS_CHEST = "bonusChest";
/*     */   public static final String DUNGEON_CHEST = "dungeonChest";
/*  35 */   private static final HashMap<String, ChestGenHooks> chestInfo = new HashMap<String, ChestGenHooks>(); private static boolean hasInit = false;
/*     */   private String category;
/*     */   
/*     */   static {
/*  39 */     init();
/*     */   }
/*     */ 
/*     */   
/*     */   private static void init() {
/*  44 */     if (hasInit) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/*  49 */     hasInit = true;
/*     */     
/*  51 */     addInfo("mineshaftCorridor", StructureMineshaftPieces.mineshaftChestContents, 3, 7);
/*  52 */     addInfo("pyramidDesertyChest", ComponentScatteredFeaturePieces.DesertPyramid.itemsToGenerateInTemple, 2, 7);
/*  53 */     addInfo("pyramidJungleChest", ComponentScatteredFeaturePieces.JunglePyramid.junglePyramidsChestContents, 2, 7);
/*  54 */     addInfo("pyramidJungleDispenser", ComponentScatteredFeaturePieces.JunglePyramid.junglePyramidsDispenserContents, 2, 2);
/*  55 */     addInfo("strongholdCorridor", StructureStrongholdPieces.ChestCorridor.strongholdChestContents, 2, 4);
/*  56 */     addInfo("strongholdLibrary", StructureStrongholdPieces.Library.strongholdLibraryChestContents, 1, 5);
/*  57 */     addInfo("strongholdCrossing", StructureStrongholdPieces.RoomCrossing.strongholdRoomCrossingChestContents, 1, 5);
/*  58 */     addInfo("villageBlacksmith", StructureVillagePieces.House2.villageBlacksmithChestContents, 3, 9);
/*  59 */     addInfo("bonusChest", WorldServer.bonusChestContent, 10, 10);
/*  60 */     addInfo("dungeonChest", WorldGenDungeons.field_111189_a, 8, 8);
/*     */     
/*  62 */     ItemStack book = new ItemStack((Item)Items.enchanted_book, 1, 0);
/*  63 */     WeightedRandomChestContent tmp = new WeightedRandomChestContent(book, 1, 1, 1);
/*  64 */     getInfo("mineshaftCorridor").addItem(tmp);
/*  65 */     getInfo("pyramidDesertyChest").addItem(tmp);
/*  66 */     getInfo("pyramidJungleChest").addItem(tmp);
/*  67 */     getInfo("strongholdCorridor").addItem(tmp);
/*  68 */     getInfo("strongholdLibrary").addItem(new WeightedRandomChestContent(book, 1, 5, 2));
/*  69 */     getInfo("strongholdCrossing").addItem(tmp);
/*  70 */     getInfo("dungeonChest").addItem(tmp);
/*     */   }
/*     */ 
/*     */   
/*     */   static void addDungeonLoot(ChestGenHooks dungeon, ItemStack item, int weight, int min, int max) {
/*  75 */     dungeon.addItem(new WeightedRandomChestContent(item, min, max, weight));
/*     */   }
/*     */ 
/*     */   
/*     */   private static void addInfo(String category, WeightedRandomChestContent[] items, int min, int max) {
/*  80 */     chestInfo.put(category, new ChestGenHooks(category, items, min, max));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ChestGenHooks getInfo(String category) {
/*  91 */     if (!chestInfo.containsKey(category))
/*     */     {
/*  93 */       chestInfo.put(category, new ChestGenHooks(category));
/*     */     }
/*  95 */     return chestInfo.get(category);
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
/*     */   public static ItemStack[] generateStacks(Random rand, ItemStack source, int min, int max) {
/*     */     ItemStack[] ret;
/* 111 */     int count = min + rand.nextInt(max - min + 1);
/*     */ 
/*     */     
/* 114 */     if (source.getItem() == null) {
/*     */       
/* 116 */       ret = new ItemStack[0];
/*     */     }
/* 118 */     else if (count > source.getMaxStackSize()) {
/*     */       
/* 120 */       ret = new ItemStack[count];
/* 121 */       for (int x = 0; x < count; x++)
/*     */       {
/* 123 */         ret[x] = source.copy();
/* 124 */         (ret[x]).stackSize = 1;
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 129 */       ret = new ItemStack[1];
/* 130 */       ret[0] = source.copy();
/* 131 */       (ret[0]).stackSize = count;
/*     */     } 
/* 133 */     return ret;
/*     */   }
/*     */   
/*     */   public static WeightedRandomChestContent[] getItems(String category, Random rnd) {
/* 137 */     return getInfo(category).getItems(rnd);
/* 138 */   } public static int getCount(String category, Random rand) { return getInfo(category).getCount(rand); }
/* 139 */   public static void addItem(String category, WeightedRandomChestContent item) { getInfo(category).addItem(item); }
/* 140 */   public static void removeItem(String category, ItemStack item) { getInfo(category).removeItem(item); } public static ItemStack getOneItem(String category, Random rand) {
/* 141 */     return getInfo(category).getOneItem(rand);
/*     */   }
/*     */   
/* 144 */   private int countMin = 0;
/* 145 */   private int countMax = 0;
/* 146 */   private ArrayList<WeightedRandomChestContent> contents = new ArrayList<WeightedRandomChestContent>();
/*     */ 
/*     */   
/*     */   public ChestGenHooks(String category) {
/* 150 */     this.category = category;
/*     */   }
/*     */ 
/*     */   
/*     */   public ChestGenHooks(String category, WeightedRandomChestContent[] items, int min, int max) {
/* 155 */     this(category);
/* 156 */     for (WeightedRandomChestContent item : items)
/*     */     {
/* 158 */       this.contents.add(item);
/*     */     }
/* 160 */     this.countMin = min;
/* 161 */     this.countMax = max;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addItem(WeightedRandomChestContent item) {
/* 171 */     this.contents.add(item);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeItem(ItemStack item) {
/* 182 */     Iterator<WeightedRandomChestContent> itr = this.contents.iterator();
/* 183 */     while (itr.hasNext()) {
/*     */       
/* 185 */       WeightedRandomChestContent cont = itr.next();
/* 186 */       if (item.isItemEqual(cont.theItemId) || (item.getItemDamage() == 32767 && item.getItem() == cont.theItemId.getItem()))
/*     */       {
/* 188 */         itr.remove();
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
/*     */   public WeightedRandomChestContent[] getItems(Random rnd) {
/* 200 */     ArrayList<WeightedRandomChestContent> ret = new ArrayList<WeightedRandomChestContent>();
/*     */     
/* 202 */     for (WeightedRandomChestContent orig : this.contents) {
/*     */       
/* 204 */       Item item = orig.theItemId.getItem();
/*     */       
/* 206 */       if (item != null) {
/*     */         
/* 208 */         WeightedRandomChestContent n = item.getChestGenBase(this, rnd, orig);
/* 209 */         if (n != null)
/*     */         {
/* 211 */           ret.add(n);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 216 */     return ret.<WeightedRandomChestContent>toArray(new WeightedRandomChestContent[ret.size()]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCount(Random rand) {
/* 227 */     return (this.countMin < this.countMax) ? (this.countMin + rand.nextInt(this.countMax - this.countMin)) : this.countMin;
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
/*     */   public ItemStack getOneItem(Random rand) {
/* 239 */     WeightedRandomChestContent[] items = getItems(rand);
/* 240 */     WeightedRandomChestContent item = (WeightedRandomChestContent)WeightedRandom.getRandomItem(rand, (WeightedRandom.Item[])items);
/* 241 */     ItemStack[] stacks = generateStacks(rand, item.theItemId, item.theMinimumChanceToGenerateItem, item.theMaximumChanceToGenerateItem);
/* 242 */     return (stacks.length > 0) ? stacks[0] : null;
/*     */   }
/*     */   
/*     */   public int getMin() {
/* 246 */     return this.countMin;
/* 247 */   } public int getMax() { return this.countMax; }
/* 248 */   public void setMin(int value) { this.countMin = value; } public void setMax(int value) {
/* 249 */     this.countMax = value;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\common\ChestGenHooks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */