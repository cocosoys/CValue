/*     */ package cpw.mods.fml.common.registry;
/*     */ 
/*     */ import com.google.common.base.Objects;
/*     */ import com.google.common.base.Strings;
/*     */ import com.google.common.base.Throwables;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.collect.Maps;
/*     */ import com.google.common.collect.ObjectArrays;
/*     */ import com.google.common.collect.Sets;
/*     */ import com.google.common.primitives.Ints;
/*     */ import cpw.mods.fml.common.FMLLog;
/*     */ import cpw.mods.fml.common.IFuelHandler;
/*     */ import cpw.mods.fml.common.IWorldGenerator;
/*     */ import cpw.mods.fml.common.Loader;
/*     */ import cpw.mods.fml.common.LoaderException;
/*     */ import cpw.mods.fml.common.LoaderState;
/*     */ import cpw.mods.fml.common.ObfuscationReflectionHelper;
/*     */ import java.lang.annotation.ElementType;
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ import java.lang.annotation.Target;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemBlock;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.crafting.CraftingManager;
/*     */ import net.minecraft.item.crafting.FurnaceRecipes;
/*     */ import net.minecraft.item.crafting.IRecipe;
/*     */ import net.minecraft.nbt.JsonToNBT;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTException;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.chunk.IChunkProvider;
/*     */ import org.apache.logging.log4j.Level;
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
/*     */ public class GameRegistry
/*     */ {
/*  65 */   private static Set<IWorldGenerator> worldGenerators = Sets.newHashSet();
/*  66 */   private static Map<IWorldGenerator, Integer> worldGeneratorIndex = Maps.newHashMap();
/*  67 */   private static List<IFuelHandler> fuelHandlers = Lists.newArrayList();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static List<IWorldGenerator> sortedGeneratorList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void registerWorldGenerator(IWorldGenerator generator, int modGenerationWeight) {
/*  79 */     worldGenerators.add(generator);
/*  80 */     worldGeneratorIndex.put(generator, Integer.valueOf(modGenerationWeight));
/*  81 */     if (sortedGeneratorList != null)
/*     */     {
/*  83 */       sortedGeneratorList = null;
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
/*     */   public static void generateWorld(int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
/*  99 */     if (sortedGeneratorList == null)
/*     */     {
/* 101 */       computeSortedGeneratorList();
/*     */     }
/* 103 */     long worldSeed = world.getSeed();
/* 104 */     Random fmlRandom = new Random(worldSeed);
/* 105 */     long xSeed = fmlRandom.nextLong() >> 3L;
/* 106 */     long zSeed = fmlRandom.nextLong() >> 3L;
/* 107 */     long chunkSeed = xSeed * chunkX + zSeed * chunkZ ^ worldSeed;
/*     */     
/* 109 */     for (IWorldGenerator generator : sortedGeneratorList) {
/*     */       
/* 111 */       fmlRandom.setSeed(chunkSeed);
/* 112 */       generator.generate(fmlRandom, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void computeSortedGeneratorList() {
/* 118 */     ArrayList<IWorldGenerator> list = Lists.newArrayList(worldGenerators);
/* 119 */     Collections.sort(list, new Comparator<IWorldGenerator>()
/*     */         {
/*     */           public int compare(IWorldGenerator o1, IWorldGenerator o2)
/*     */           {
/* 123 */             return Ints.compare(((Integer)GameRegistry.worldGeneratorIndex.get(o1)).intValue(), ((Integer)GameRegistry.worldGeneratorIndex.get(o2)).intValue());
/*     */           }
/*     */         });
/* 126 */     sortedGeneratorList = (List<IWorldGenerator>)ImmutableList.copyOf(list);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void registerItem(Item item, String name) {
/* 137 */     registerItem(item, name, null);
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
/*     */   public static Item registerItem(Item item, String name, String modId) {
/* 149 */     GameData.getMain().registerItem(item, name);
/* 150 */     return item;
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
/*     */   public static void addSubstitutionAlias(String nameToSubstitute, Type type, Object object) throws ExistingSubstitutionException {
/* 167 */     GameData.getMain().registerSubstitutionAlias(nameToSubstitute, type, object);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Block registerBlock(Block block, String name) {
/* 177 */     return registerBlock(block, ItemBlock.class, name);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Block registerBlock(Block block, Class<? extends ItemBlock> itemclass, String name) {
/* 188 */     return registerBlock(block, itemclass, name, new Object[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static Block registerBlock(Block block, Class<? extends ItemBlock> itemclass, String name, String modId, Object... itemCtorArgs) {
/* 197 */     return registerBlock(block, itemclass, name, itemCtorArgs);
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
/*     */   public static Block registerBlock(Block block, Class<? extends ItemBlock> itemclass, String name, Object... itemCtorArgs) {
/* 209 */     if (Loader.instance().isInState(LoaderState.CONSTRUCTING))
/*     */     {
/* 211 */       FMLLog.warning("The mod %s is attempting to register a block whilst it it being constructed. This is bad modding practice - please use a proper mod lifecycle event.", new Object[] { Loader.instance().activeModContainer() });
/*     */     }
/*     */     
/*     */     try {
/* 215 */       assert block != null : "registerBlock: block cannot be null";
/* 216 */       ItemBlock i = null;
/* 217 */       if (itemclass != null) {
/*     */         
/* 219 */         Class<?>[] ctorArgClasses = new Class[itemCtorArgs.length + 1];
/* 220 */         ctorArgClasses[0] = Block.class;
/* 221 */         for (int idx = 1; idx < ctorArgClasses.length; idx++)
/*     */         {
/* 223 */           ctorArgClasses[idx] = itemCtorArgs[idx - 1].getClass();
/*     */         }
/* 225 */         Constructor<? extends ItemBlock> itemCtor = itemclass.getConstructor(ctorArgClasses);
/* 226 */         i = itemCtor.newInstance(ObjectArrays.concat(block, itemCtorArgs));
/*     */       } 
/*     */       
/* 229 */       GameData.getMain().registerBlock(block, name);
/* 230 */       if (i != null)
/*     */       {
/* 232 */         GameData.getMain().registerItem((Item)i, name);
/*     */       }
/* 234 */       return block;
/*     */     }
/* 236 */     catch (Exception e) {
/*     */       
/* 238 */       FMLLog.log(Level.ERROR, e, "Caught an exception during block registration", new Object[0]);
/* 239 */       throw new LoaderException(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void addRecipe(ItemStack output, Object... params) {
/* 245 */     addShapedRecipe(output, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IRecipe addShapedRecipe(ItemStack output, Object... params) {
/* 250 */     return (IRecipe)CraftingManager.getInstance().addRecipe(output, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void addShapelessRecipe(ItemStack output, Object... params) {
/* 255 */     CraftingManager.getInstance().addShapelessRecipe(output, params);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void addRecipe(IRecipe recipe) {
/* 261 */     CraftingManager.getInstance().getRecipeList().add(recipe);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void addSmelting(Block input, ItemStack output, float xp) {
/* 266 */     FurnaceRecipes.smelting().func_151393_a(input, output, xp);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void addSmelting(Item input, ItemStack output, float xp) {
/* 271 */     FurnaceRecipes.smelting().func_151396_a(input, output, xp);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void addSmelting(ItemStack input, ItemStack output, float xp) {
/* 276 */     FurnaceRecipes.smelting().func_151394_a(input, output, xp);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void registerTileEntity(Class<? extends TileEntity> tileEntityClass, String id) {
/* 281 */     TileEntity.addMapping(tileEntityClass, id);
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
/*     */   public static void registerTileEntityWithAlternatives(Class<? extends TileEntity> tileEntityClass, String id, String... alternatives) {
/* 294 */     TileEntity.addMapping(tileEntityClass, id);
/* 295 */     Map<String, Class<?>> teMappings = (Map<String, Class<?>>)ObfuscationReflectionHelper.getPrivateValue(TileEntity.class, null, new String[] { "field_145855_i", "nameToClassMap" });
/* 296 */     for (String s : alternatives) {
/*     */       
/* 298 */       if (!teMappings.containsKey(s))
/*     */       {
/* 300 */         teMappings.put(s, tileEntityClass);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void registerFuelHandler(IFuelHandler handler) {
/* 307 */     fuelHandlers.add(handler);
/*     */   }
/*     */   
/*     */   public static int getFuelValue(ItemStack itemStack) {
/* 311 */     int fuelValue = 0;
/* 312 */     for (IFuelHandler handler : fuelHandlers)
/*     */     {
/* 314 */       fuelValue = Math.max(fuelValue, handler.getBurnTime(itemStack));
/*     */     }
/* 316 */     return fuelValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Block findBlock(String modId, String name) {
/* 327 */     return GameData.findBlock(modId, name);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Item findItem(String modId, String name) {
/* 338 */     return GameData.findItem(modId, name);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void registerCustomItemStack(String name, ItemStack itemStack) {
/* 349 */     GameData.registerCustomItemStack(name, itemStack);
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
/*     */   public static ItemStack findItemStack(String modId, String name, int stackSize) {
/* 367 */     ItemStack foundStack = GameData.findItemStack(modId, name);
/* 368 */     if (foundStack != null) {
/*     */       
/* 370 */       ItemStack is = foundStack.copy();
/* 371 */       is.stackSize = Math.min(stackSize, is.getMaxStackSize());
/* 372 */       return is;
/*     */     } 
/* 374 */     return null;
/*     */   }
/*     */   
/*     */   public static final class UniqueIdentifier
/*     */   {
/*     */     public final String modId;
/*     */     public final String name;
/*     */     
/*     */     UniqueIdentifier(String modId, String name) {
/* 383 */       this.modId = modId;
/* 384 */       this.name = name;
/*     */     }
/*     */ 
/*     */     
/*     */     public UniqueIdentifier(String string) {
/* 389 */       String[] parts = string.split(":");
/* 390 */       this.modId = parts[0];
/* 391 */       this.name = parts[1];
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(Object obj) {
/* 397 */       if (obj == null) return false; 
/* 398 */       if (obj.getClass() != getClass()) return false; 
/* 399 */       UniqueIdentifier other = (UniqueIdentifier)obj;
/* 400 */       return (Objects.equal(this.modId, other.modId) && Objects.equal(this.name, other.name));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 406 */       return Objects.hashCode(new Object[] { this.modId, this.name });
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 412 */       return String.format("%s:%s", new Object[] { this.modId, this.name });
/*     */     }
/*     */   }
/*     */   
/*     */   public enum Type {
/* 417 */     BLOCK
/*     */     {
/*     */       public FMLControlledNamespacedRegistry<?> getRegistry()
/*     */       {
/* 421 */         return GameData.getBlockRegistry();
/*     */       }
/*     */     },
/* 424 */     ITEM
/*     */     {
/*     */       public FMLControlledNamespacedRegistry<?> getRegistry()
/*     */       {
/* 428 */         return GameData.getItemRegistry();
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public abstract FMLControlledNamespacedRegistry<?> getRegistry();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static UniqueIdentifier findUniqueIdentifierFor(Block block) {
/* 447 */     return GameData.getUniqueName(block);
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
/*     */   public static UniqueIdentifier findUniqueIdentifierFor(Item item) {
/* 462 */     return GameData.getUniqueName(item);
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
/*     */   public static ItemStack makeItemStack(String itemName, int meta, int stackSize, String nbtString) {
/* 524 */     if (itemName == null) throw new IllegalArgumentException("The itemName cannot be null"); 
/* 525 */     Item item = GameData.getItemRegistry().getObject(itemName);
/* 526 */     if (item == null) {
/* 527 */       FMLLog.getLogger().log(Level.TRACE, "Unable to find item with name {}", new Object[] { itemName });
/* 528 */       return null;
/*     */     } 
/* 530 */     ItemStack is = new ItemStack(item, 1, meta);
/* 531 */     if (!Strings.isNullOrEmpty(nbtString)) {
/* 532 */       NBTBase nbttag = null;
/*     */       
/*     */       try {
/* 535 */         nbttag = JsonToNBT.func_150315_a(nbtString);
/* 536 */       } catch (NBTException e) {
/*     */         
/* 538 */         FMLLog.getLogger().log(Level.WARN, "Encountered an exception parsing ItemStack NBT string {}", new Object[] { nbtString, e });
/* 539 */         throw Throwables.propagate(e);
/*     */       } 
/* 541 */       if (!(nbttag instanceof NBTTagCompound)) {
/* 542 */         FMLLog.getLogger().log(Level.WARN, "Unexpected NBT string - multiple values {}", new Object[] { nbtString });
/* 543 */         throw new RuntimeException("Invalid NBT JSON");
/*     */       } 
/* 545 */       is.setTagCompound((NBTTagCompound)nbttag);
/*     */     } 
/*     */     
/* 548 */     return is;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.RUNTIME)
/*     */   @Target({ElementType.TYPE, ElementType.FIELD})
/*     */   public static @interface ObjectHolder {
/*     */     String value();
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.RUNTIME)
/*     */   @Target({ElementType.FIELD})
/*     */   public static @interface ItemStackHolder {
/*     */     String value();
/*     */     
/*     */     int meta() default 0;
/*     */     
/*     */     String nbt() default "";
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\registry\GameRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */