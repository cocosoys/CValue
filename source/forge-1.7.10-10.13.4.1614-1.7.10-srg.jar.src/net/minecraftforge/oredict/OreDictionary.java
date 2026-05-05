/*     */ package net.minecraftforge.oredict;
/*     */ 
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.collect.Maps;
/*     */ import cpw.mods.fml.common.FMLLog;
/*     */ import cpw.mods.fml.common.Loader;
/*     */ import cpw.mods.fml.common.eventhandler.Event;
/*     */ import cpw.mods.fml.common.registry.GameData;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.crafting.CraftingManager;
/*     */ import net.minecraft.item.crafting.IRecipe;
/*     */ import net.minecraft.item.crafting.ShapedRecipes;
/*     */ import net.minecraft.item.crafting.ShapelessRecipes;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import org.apache.logging.log4j.Level;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class OreDictionary
/*     */ {
/*     */   private static boolean hasInit = false;
/*  41 */   private static List<String> idToName = new ArrayList<String>();
/*  42 */   private static Map<String, Integer> nameToId = new HashMap<String, Integer>(128);
/*  43 */   private static List<ArrayList<ItemStack>> idToStack = Lists.newArrayList();
/*  44 */   private static List<ArrayList<ItemStack>> idToStackUn = Lists.newArrayList();
/*  45 */   private static Map<Integer, List<Integer>> stackToId = Maps.newHashMapWithExpectedSize(96);
/*  46 */   public static final ArrayList<ItemStack> EMPTY_LIST = new UnmodifiableArrayList<ItemStack>(Lists.newArrayList());
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int WILDCARD_VALUE = 32767;
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/*  55 */     initVanillaEntries();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void initVanillaEntries() {
/*  61 */     if (!hasInit) {
/*     */       
/*  63 */       registerOre("logWood", new ItemStack(Blocks.log, 1, 32767));
/*  64 */       registerOre("logWood", new ItemStack(Blocks.log2, 1, 32767));
/*  65 */       registerOre("plankWood", new ItemStack(Blocks.planks, 1, 32767));
/*  66 */       registerOre("slabWood", new ItemStack((Block)Blocks.wooden_slab, 1, 32767));
/*  67 */       registerOre("stairWood", Blocks.oak_stairs);
/*  68 */       registerOre("stairWood", Blocks.spruce_stairs);
/*  69 */       registerOre("stairWood", Blocks.birch_stairs);
/*  70 */       registerOre("stairWood", Blocks.jungle_stairs);
/*  71 */       registerOre("stairWood", Blocks.acacia_stairs);
/*  72 */       registerOre("stairWood", Blocks.dark_oak_stairs);
/*  73 */       registerOre("stickWood", Items.stick);
/*  74 */       registerOre("treeSapling", new ItemStack(Blocks.sapling, 1, 32767));
/*  75 */       registerOre("treeLeaves", new ItemStack((Block)Blocks.leaves, 1, 32767));
/*  76 */       registerOre("treeLeaves", new ItemStack((Block)Blocks.leaves2, 1, 32767));
/*  77 */       registerOre("oreGold", Blocks.gold_ore);
/*  78 */       registerOre("oreIron", Blocks.iron_ore);
/*  79 */       registerOre("oreLapis", Blocks.lapis_ore);
/*  80 */       registerOre("oreDiamond", Blocks.diamond_ore);
/*  81 */       registerOre("oreRedstone", Blocks.redstone_ore);
/*  82 */       registerOre("oreEmerald", Blocks.emerald_ore);
/*  83 */       registerOre("oreQuartz", Blocks.quartz_ore);
/*  84 */       registerOre("oreCoal", Blocks.coal_ore);
/*  85 */       registerOre("blockGold", Blocks.gold_block);
/*  86 */       registerOre("blockIron", Blocks.iron_block);
/*  87 */       registerOre("blockLapis", Blocks.lapis_block);
/*  88 */       registerOre("blockDiamond", Blocks.diamond_block);
/*  89 */       registerOre("blockRedstone", Blocks.redstone_block);
/*  90 */       registerOre("blockEmerald", Blocks.emerald_block);
/*  91 */       registerOre("blockQuartz", Blocks.quartz_block);
/*  92 */       registerOre("blockCoal", Blocks.coal_block);
/*  93 */       registerOre("blockGlassColorless", Blocks.glass);
/*  94 */       registerOre("blockGlass", Blocks.glass);
/*  95 */       registerOre("blockGlass", new ItemStack((Block)Blocks.stained_glass, 1, 32767));
/*     */       
/*  97 */       registerOre("paneGlassColorless", Blocks.glass_pane);
/*  98 */       registerOre("paneGlass", Blocks.glass_pane);
/*  99 */       registerOre("paneGlass", new ItemStack((Block)Blocks.stained_glass_pane, 1, 32767));
/*     */       
/* 101 */       registerOre("ingotIron", Items.iron_ingot);
/* 102 */       registerOre("ingotGold", Items.gold_ingot);
/* 103 */       registerOre("ingotBrick", Items.brick);
/* 104 */       registerOre("ingotBrickNether", Items.netherbrick);
/* 105 */       registerOre("nuggetGold", Items.gold_nugget);
/* 106 */       registerOre("gemDiamond", Items.diamond);
/* 107 */       registerOre("gemEmerald", Items.emerald);
/* 108 */       registerOre("gemQuartz", Items.quartz);
/* 109 */       registerOre("dustRedstone", Items.redstone);
/* 110 */       registerOre("dustGlowstone", Items.glowstone_dust);
/* 111 */       registerOre("gemLapis", new ItemStack(Items.dye, 1, 4));
/* 112 */       registerOre("slimeball", Items.slime_ball);
/* 113 */       registerOre("glowstone", Blocks.glowstone);
/* 114 */       registerOre("cropWheat", Items.wheat);
/* 115 */       registerOre("cropPotato", Items.potato);
/* 116 */       registerOre("cropCarrot", Items.carrot);
/* 117 */       registerOre("stone", Blocks.stone);
/* 118 */       registerOre("cobblestone", Blocks.cobblestone);
/* 119 */       registerOre("sandstone", new ItemStack(Blocks.sandstone, 1, 32767));
/* 120 */       registerOre("sand", new ItemStack((Block)Blocks.sand, 1, 32767));
/* 121 */       registerOre("dye", new ItemStack(Items.dye, 1, 32767));
/* 122 */       registerOre("record", Items.record_13);
/* 123 */       registerOre("record", Items.record_cat);
/* 124 */       registerOre("record", Items.record_blocks);
/* 125 */       registerOre("record", Items.record_chirp);
/* 126 */       registerOre("record", Items.record_far);
/* 127 */       registerOre("record", Items.record_mall);
/* 128 */       registerOre("record", Items.record_mellohi);
/* 129 */       registerOre("record", Items.record_stal);
/* 130 */       registerOre("record", Items.record_strad);
/* 131 */       registerOre("record", Items.record_ward);
/* 132 */       registerOre("record", Items.record_11);
/* 133 */       registerOre("record", Items.record_wait);
/*     */     } 
/*     */ 
/*     */     
/* 137 */     Map<ItemStack, String> replacements = new HashMap<ItemStack, String>();
/* 138 */     replacements.put(new ItemStack(Items.stick), "stickWood");
/* 139 */     replacements.put(new ItemStack(Blocks.planks), "plankWood");
/* 140 */     replacements.put(new ItemStack(Blocks.planks, 1, 32767), "plankWood");
/* 141 */     replacements.put(new ItemStack(Blocks.stone), "stone");
/* 142 */     replacements.put(new ItemStack(Blocks.stone, 1, 32767), "stone");
/* 143 */     replacements.put(new ItemStack(Blocks.cobblestone), "cobblestone");
/* 144 */     replacements.put(new ItemStack(Blocks.cobblestone, 1, 32767), "cobblestone");
/* 145 */     replacements.put(new ItemStack(Items.gold_ingot), "ingotGold");
/* 146 */     replacements.put(new ItemStack(Items.iron_ingot), "ingotIron");
/* 147 */     replacements.put(new ItemStack(Items.diamond), "gemDiamond");
/* 148 */     replacements.put(new ItemStack(Items.emerald), "gemEmerald");
/* 149 */     replacements.put(new ItemStack(Items.redstone), "dustRedstone");
/* 150 */     replacements.put(new ItemStack(Items.glowstone_dust), "dustGlowstone");
/* 151 */     replacements.put(new ItemStack(Blocks.glowstone), "glowstone");
/* 152 */     replacements.put(new ItemStack(Items.slime_ball), "slimeball");
/* 153 */     replacements.put(new ItemStack(Blocks.glass), "blockGlassColorless");
/*     */ 
/*     */     
/* 156 */     String[] dyes = { "Black", "Red", "Green", "Brown", "Blue", "Purple", "Cyan", "LightGray", "Gray", "Pink", "Lime", "Yellow", "LightBlue", "Magenta", "Orange", "White" };
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
/* 176 */     for (int i = 0; i < 16; i++) {
/*     */       
/* 178 */       ItemStack dye = new ItemStack(Items.dye, 1, i);
/* 179 */       ItemStack block = new ItemStack((Block)Blocks.stained_glass, 1, 15 - i);
/* 180 */       ItemStack pane = new ItemStack((Block)Blocks.stained_glass_pane, 1, 15 - i);
/* 181 */       if (!hasInit) {
/*     */         
/* 183 */         registerOre("dye" + dyes[i], dye);
/* 184 */         registerOre("blockGlass" + dyes[i], block);
/* 185 */         registerOre("paneGlass" + dyes[i], pane);
/*     */       } 
/* 187 */       replacements.put(dye, "dye" + dyes[i]);
/* 188 */       replacements.put(block, "blockGlass" + dyes[i]);
/* 189 */       replacements.put(pane, "paneGlass" + dyes[i]);
/*     */     } 
/* 191 */     hasInit = true;
/*     */     
/* 193 */     ItemStack[] replaceStacks = (ItemStack[])replacements.keySet().toArray((Object[])new ItemStack[replacements.keySet().size()]);
/*     */ 
/*     */     
/* 196 */     ItemStack[] exclusions = { new ItemStack(Blocks.lapis_block), new ItemStack(Items.cookie), new ItemStack(Blocks.stonebrick), new ItemStack((Block)Blocks.stone_slab, 1, 32767), new ItemStack(Blocks.stone_stairs), new ItemStack(Blocks.cobblestone_wall), new ItemStack(Blocks.oak_stairs), new ItemStack(Blocks.spruce_stairs), new ItemStack(Blocks.birch_stairs), new ItemStack(Blocks.jungle_stairs), new ItemStack(Blocks.acacia_stairs), new ItemStack(Blocks.dark_oak_stairs), new ItemStack(Blocks.glass_pane) };
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
/* 213 */     List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
/* 214 */     List<IRecipe> recipesToRemove = new ArrayList<IRecipe>();
/* 215 */     List<IRecipe> recipesToAdd = new ArrayList<IRecipe>();
/*     */ 
/*     */     
/* 218 */     for (IRecipe obj : recipes) {
/*     */       
/* 220 */       if (obj instanceof ShapedRecipes) {
/*     */         
/* 222 */         ShapedRecipes recipe = (ShapedRecipes)obj;
/* 223 */         ItemStack output = recipe.getRecipeOutput();
/* 224 */         if (output != null && containsMatch(false, exclusions, new ItemStack[] { output })) {
/*     */           continue;
/*     */         }
/*     */ 
/*     */         
/* 229 */         if (containsMatch(true, recipe.recipeItems, replaceStacks)) {
/*     */           
/* 231 */           recipesToRemove.add(recipe);
/* 232 */           recipesToAdd.add(new ShapedOreRecipe(recipe, replacements));
/*     */         }  continue;
/*     */       } 
/* 235 */       if (obj instanceof ShapelessRecipes) {
/*     */         
/* 237 */         ShapelessRecipes recipe = (ShapelessRecipes)obj;
/* 238 */         ItemStack output = recipe.getRecipeOutput();
/* 239 */         if (output != null && containsMatch(false, exclusions, new ItemStack[] { output })) {
/*     */           continue;
/*     */         }
/*     */ 
/*     */         
/* 244 */         if (containsMatch(true, (ItemStack[])recipe.recipeItems.toArray((Object[])new ItemStack[recipe.recipeItems.size()]), replaceStacks)) {
/*     */           
/* 246 */           recipesToRemove.add(obj);
/* 247 */           IRecipe newRecipe = new ShapelessOreRecipe(recipe, replacements);
/* 248 */           recipesToAdd.add(newRecipe);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 253 */     recipes.removeAll(recipesToRemove);
/* 254 */     recipes.addAll(recipesToAdd);
/* 255 */     if (recipesToRemove.size() > 0)
/*     */     {
/* 257 */       FMLLog.info("Replaced %d ore recipies", new Object[] { Integer.valueOf(recipesToRemove.size()) });
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
/*     */   public static int getOreID(String name) {
/* 270 */     Integer val = nameToId.get(name);
/* 271 */     if (val == null) {
/*     */       
/* 273 */       idToName.add(name);
/* 274 */       val = Integer.valueOf(idToName.size() - 1);
/* 275 */       nameToId.put(name, val);
/* 276 */       idToStack.add(new ArrayList<ItemStack>());
/* 277 */       idToStackUn.add(new UnmodifiableArrayList<ItemStack>(idToStack.get(val.intValue())));
/*     */     } 
/* 279 */     return val.intValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getOreName(int id) {
/* 290 */     return (id >= 0 && id < idToName.size()) ? idToName.get(id) : "Unknown";
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
/*     */   @Deprecated
/*     */   public static int getOreID(ItemStack stack) {
/* 303 */     if (stack == null || stack.getItem() == null) return -1;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 308 */     String registryName = (stack.getItem()).delegate.name();
/*     */     
/* 310 */     if (registryName == null) {
/*     */       
/* 312 */       FMLLog.log(Level.DEBUG, "Attempted to find the oreIDs for an unregistered object (%s). This won't work very well.", new Object[] { stack });
/* 313 */       return -1;
/*     */     } 
/*     */ 
/*     */     
/* 317 */     int id = GameData.getItemRegistry().getId(registryName);
/*     */     
/* 319 */     List<Integer> ids = stackToId.get(Integer.valueOf(id));
/* 320 */     if (ids == null || ids.size() == 0)
/*     */     {
/* 322 */       ids = stackToId.get(Integer.valueOf(id | stack.getItemDamage() + 1 << 16));
/*     */     }
/* 324 */     return (ids != null && ids.size() > 0) ? ((Integer)ids.get(0)).intValue() : -1;
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
/*     */   public static int[] getOreIDs(ItemStack stack) {
/* 336 */     if (stack == null || stack.getItem() == null) return new int[0];
/*     */     
/* 338 */     Set<Integer> set = new HashSet<Integer>();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 343 */     String registryName = (stack.getItem()).delegate.name();
/*     */     
/* 345 */     if (registryName == null) {
/*     */       
/* 347 */       FMLLog.log(Level.DEBUG, "Attempted to find the oreIDs for an unregistered object (%s). This won't work very well.", new Object[] { stack });
/* 348 */       return new int[0];
/*     */     } 
/*     */ 
/*     */     
/* 352 */     int id = GameData.getItemRegistry().getId(registryName);
/*     */     
/* 354 */     List<Integer> ids = stackToId.get(Integer.valueOf(id));
/* 355 */     if (ids != null) set.addAll(ids); 
/* 356 */     ids = stackToId.get(Integer.valueOf(id | stack.getItemDamage() + 1 << 16));
/* 357 */     if (ids != null) set.addAll(ids);
/*     */     
/* 359 */     Integer[] tmp = set.<Integer>toArray(new Integer[set.size()]);
/* 360 */     int[] ret = new int[tmp.length];
/* 361 */     for (int x = 0; x < tmp.length; x++)
/* 362 */       ret[x] = tmp[x].intValue(); 
/* 363 */     return ret;
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
/*     */   public static ArrayList<ItemStack> getOres(String name) {
/* 378 */     return getOres(getOreID(name));
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
/*     */   public static List<ItemStack> getOres(String name, boolean alwaysCreateEntry) {
/* 398 */     if (alwaysCreateEntry) {
/* 399 */       return getOres(getOreID(name));
/*     */     }
/* 401 */     return (nameToId.get(name) != null) ? getOres(getOreID(name)) : EMPTY_LIST;
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
/*     */   public static boolean doesOreNameExist(String name) {
/* 416 */     return (nameToId.get(name) != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String[] getOreNames() {
/* 426 */     return idToName.<String>toArray(new String[idToName.size()]);
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
/*     */   @Deprecated
/*     */   public static ArrayList<ItemStack> getOres(Integer id) {
/* 444 */     return getOres(id.intValue());
/*     */   }
/*     */   
/*     */   private static ArrayList<ItemStack> getOres(int id) {
/* 448 */     while (idToName.size() < id + 1) {
/*     */       
/* 450 */       String name = "Filler: " + idToName.size();
/* 451 */       idToName.add(name);
/* 452 */       nameToId.put(name, Integer.valueOf(idToName.size() - 1));
/* 453 */       idToStack.add(null);
/* 454 */       idToStackUn.add(EMPTY_LIST);
/*     */     } 
/* 456 */     return (idToStackUn.size() > id) ? idToStackUn.get(id) : EMPTY_LIST;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean containsMatch(boolean strict, ItemStack[] inputs, ItemStack... targets) {
/* 461 */     for (ItemStack input : inputs) {
/*     */       
/* 463 */       for (ItemStack target : targets) {
/*     */         
/* 465 */         if (itemMatches(target, input, strict))
/*     */         {
/* 467 */           return true;
/*     */         }
/*     */       } 
/*     */     } 
/* 471 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean containsMatch(boolean strict, List<ItemStack> inputs, ItemStack... targets) {
/* 476 */     for (ItemStack input : inputs) {
/*     */       
/* 478 */       for (ItemStack target : targets) {
/*     */         
/* 480 */         if (itemMatches(target, input, strict))
/*     */         {
/* 482 */           return true;
/*     */         }
/*     */       } 
/*     */     } 
/* 486 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean itemMatches(ItemStack target, ItemStack input, boolean strict) {
/* 491 */     if ((input == null && target != null) || (input != null && target == null))
/*     */     {
/* 493 */       return false;
/*     */     }
/* 495 */     return (target.getItem() == input.getItem() && ((target.getItemDamage() == 32767 && !strict) || target.getItemDamage() == input.getItemDamage()));
/*     */   }
/*     */   
/*     */   public static void registerOre(String name, Item ore) {
/* 499 */     registerOre(name, new ItemStack(ore));
/* 500 */   } public static void registerOre(String name, Block ore) { registerOre(name, new ItemStack(ore)); }
/* 501 */   public static void registerOre(String name, ItemStack ore) { registerOreImpl(name, ore); }
/*     */   @Deprecated
/* 503 */   public static void registerOre(int id, Item ore) { registerOre(id, new ItemStack(ore)); }
/*     */   @Deprecated
/* 505 */   public static void registerOre(int id, Block ore) { registerOre(id, new ItemStack(ore)); } @Deprecated
/*     */   public static void registerOre(int id, ItemStack ore) {
/* 507 */     registerOreImpl(getOreName(id), ore);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void registerOreImpl(String name, ItemStack ore) {
/*     */     int hash;
/* 519 */     if (name == null || name.isEmpty() || "Unknown".equals(name))
/* 520 */       return;  if (ore == null || ore.getItem() == null) {
/*     */       
/* 522 */       FMLLog.bigWarning("Invalid registration attempt for an Ore Dictionary item with name %s has occurred. The registration has been denied to prevent crashes. The mod responsible for the registration needs to correct this.", new Object[] { name });
/*     */       
/*     */       return;
/*     */     } 
/* 526 */     int oreID = getOreID(name);
/*     */ 
/*     */ 
/*     */     
/* 530 */     String registryName = (ore.getItem()).delegate.name();
/*     */     
/* 532 */     if (registryName == null) {
/*     */       
/* 534 */       FMLLog.bigWarning("A broken ore dictionary registration with name %s has occurred. It adds an item (type: %s) which is currently unknown to the game registry. This dictionary item can only support a single value when registered with ores like this, and NO I am not going to turn this spam off. Just register your ore dictionary entries after the GameRegistry.\nTO USERS: YES this is a BUG in the mod " + 
/*     */           
/* 536 */           Loader.instance().activeModContainer().getName() + " report it to them!", new Object[] { name, ore.getItem().getClass() });
/* 537 */       hash = -1;
/*     */     }
/*     */     else {
/*     */       
/* 541 */       hash = GameData.getItemRegistry().getId(registryName);
/*     */     } 
/* 543 */     if (ore.getItemDamage() != 32767)
/*     */     {
/* 545 */       hash |= ore.getItemDamage() + 1 << 16;
/*     */     }
/*     */ 
/*     */     
/* 549 */     List<Integer> ids = stackToId.get(Integer.valueOf(hash));
/* 550 */     if (ids != null && ids.contains(Integer.valueOf(oreID)))
/* 551 */       return;  if (ids == null) {
/*     */       
/* 553 */       ids = Lists.newArrayList();
/* 554 */       stackToId.put(Integer.valueOf(hash), ids);
/*     */     } 
/* 556 */     ids.add(Integer.valueOf(oreID));
/*     */ 
/*     */     
/* 559 */     ore = ore.copy();
/* 560 */     ((ArrayList<ItemStack>)idToStack.get(oreID)).add(ore);
/* 561 */     MinecraftForge.EVENT_BUS.post(new OreRegisterEvent(name, ore));
/*     */   }
/*     */   
/*     */   public static class OreRegisterEvent
/*     */     extends Event
/*     */   {
/*     */     public final String Name;
/*     */     public final ItemStack Ore;
/*     */     
/*     */     public OreRegisterEvent(String name, ItemStack ore) {
/* 571 */       this.Name = name;
/* 572 */       this.Ore = ore;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void rebakeMap() {
/* 579 */     stackToId.clear();
/* 580 */     for (int id = 0; id < idToStack.size(); id++) {
/*     */       
/* 582 */       List<ItemStack> ores = idToStack.get(id);
/* 583 */       if (ores != null) {
/* 584 */         for (ItemStack ore : ores) {
/*     */           int hash;
/*     */           
/* 587 */           String name = (ore.getItem()).delegate.name();
/*     */           
/* 589 */           if (name == null) {
/*     */             
/* 591 */             FMLLog.log(Level.DEBUG, "Defaulting unregistered ore dictionary entry for ore dictionary %s: type %s to -1", new Object[] { getOreName(id), ore.getItem().getClass() });
/* 592 */             hash = -1;
/*     */           }
/*     */           else {
/*     */             
/* 596 */             hash = GameData.getItemRegistry().getId(name);
/*     */           } 
/* 598 */           if (ore.getItemDamage() != 32767)
/*     */           {
/* 600 */             hash |= ore.getItemDamage() + 1 << 16;
/*     */           }
/* 602 */           List<Integer> ids = stackToId.get(Integer.valueOf(hash));
/* 603 */           if (ids == null) {
/*     */             
/* 605 */             ids = Lists.newArrayList();
/* 606 */             stackToId.put(Integer.valueOf(hash), ids);
/*     */           } 
/* 608 */           ids.add(Integer.valueOf(id));
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static class UnmodifiableArrayList<E>
/*     */     extends ArrayList<E>
/*     */   {
/*     */     final ArrayList<? extends E> list;
/*     */ 
/*     */     
/*     */     UnmodifiableArrayList(ArrayList<? extends E> list) {
/* 623 */       super(0);
/* 624 */       this.list = list;
/*     */     }
/*     */     
/* 627 */     public ListIterator<E> listIterator() { return listIterator(0); }
/* 628 */     public boolean equals(Object o) { return (o == this || this.list.equals(o)); }
/* 629 */     public int hashCode() { return this.list.hashCode(); }
/* 630 */     public E get(int index) { return this.list.get(index); }
/* 631 */     public int indexOf(Object o) { return this.list.indexOf(o); }
/* 632 */     public int lastIndexOf(Object o) { return this.list.lastIndexOf(o); }
/* 633 */     public int size() { return this.list.size(); }
/* 634 */     public boolean isEmpty() { return this.list.isEmpty(); }
/* 635 */     public boolean contains(Object o) { return this.list.contains(o); }
/* 636 */     public Object[] toArray() { return this.list.toArray(); }
/* 637 */     public <T> T[] toArray(T[] a) { return this.list.toArray(a); }
/* 638 */     public String toString() { return this.list.toString(); } public boolean containsAll(Collection<?> coll) {
/* 639 */       return this.list.containsAll(coll);
/*     */     }
/* 641 */     public E set(int index, E element) { throw new UnsupportedOperationException(); }
/* 642 */     public void add(int index, E element) { throw new UnsupportedOperationException(); }
/* 643 */     public E remove(int index) { throw new UnsupportedOperationException(); }
/* 644 */     public boolean add(E e) { throw new UnsupportedOperationException(); }
/* 645 */     public boolean remove(Object o) { throw new UnsupportedOperationException(); }
/* 646 */     public void clear() { throw new UnsupportedOperationException(); }
/* 647 */     public boolean removeAll(Collection<?> coll) { throw new UnsupportedOperationException(); }
/* 648 */     public boolean retainAll(Collection<?> coll) { throw new UnsupportedOperationException(); }
/* 649 */     public boolean addAll(Collection<? extends E> coll) { throw new UnsupportedOperationException(); } public boolean addAll(int index, Collection<? extends E> c) {
/* 650 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public ListIterator<E> listIterator(final int index) {
/* 654 */       return new ListIterator<E>()
/*     */         {
/* 656 */           private final ListIterator<? extends E> i = OreDictionary.UnmodifiableArrayList.this.list.listIterator(index);
/* 657 */           public boolean hasNext() { return this.i.hasNext(); }
/* 658 */           public E next() { return this.i.next(); }
/* 659 */           public boolean hasPrevious() { return this.i.hasPrevious(); }
/* 660 */           public E previous() { return this.i.previous(); }
/* 661 */           public int nextIndex() { return this.i.nextIndex(); } public int previousIndex() {
/* 662 */             return this.i.previousIndex();
/*     */           }
/* 664 */           public void remove() { throw new UnsupportedOperationException(); }
/* 665 */           public void set(E e) { throw new UnsupportedOperationException(); } public void add(E e) {
/* 666 */             throw new UnsupportedOperationException();
/*     */           }
/*     */         };
/*     */     }
/*     */     
/*     */     public List<E> subList(int fromIndex, int toIndex) {
/* 672 */       return Collections.unmodifiableList(this.list.subList(fromIndex, toIndex));
/*     */     }
/*     */ 
/*     */     
/*     */     public Iterator<E> iterator() {
/* 677 */       return new Iterator<E>()
/*     */         {
/* 679 */           private final Iterator<? extends E> i = OreDictionary.UnmodifiableArrayList.this.list.iterator();
/*     */           
/* 681 */           public boolean hasNext() { return this.i.hasNext(); }
/* 682 */           public E next() { return this.i.next(); } public void remove() {
/* 683 */             throw new UnsupportedOperationException();
/*     */           }
/*     */         };
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\oredict\OreDictionary.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */