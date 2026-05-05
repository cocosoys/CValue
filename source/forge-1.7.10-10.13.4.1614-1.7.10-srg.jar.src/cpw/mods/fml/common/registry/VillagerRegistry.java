/*     */ package cpw.mods.fml.common.registry;
/*     */ 
/*     */ import com.google.common.collect.ArrayListMultimap;
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.collect.Maps;
/*     */ import com.google.common.collect.Multimap;
/*     */ import cpw.mods.fml.common.FMLLog;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import net.minecraft.entity.passive.EntityVillager;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.Tuple;
/*     */ import net.minecraft.village.MerchantRecipeList;
/*     */ import net.minecraft.world.gen.structure.StructureVillagePieces;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class VillagerRegistry
/*     */ {
/*  46 */   private static final VillagerRegistry INSTANCE = new VillagerRegistry();
/*     */   
/*  48 */   private Multimap<Integer, IVillageTradeHandler> tradeHandlers = (Multimap<Integer, IVillageTradeHandler>)ArrayListMultimap.create();
/*  49 */   private Map<Class<?>, IVillageCreationHandler> villageCreationHandlers = Maps.newHashMap();
/*  50 */   private List<Integer> newVillagerIds = Lists.newArrayList();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   private Map<Integer, ResourceLocation> newVillagers;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static VillagerRegistry instance() {
/* 113 */     return INSTANCE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerVillagerId(int id) {
/* 122 */     if (this.newVillagerIds.contains(Integer.valueOf(id))) {
/*     */       
/* 124 */       FMLLog.severe("Attempt to register duplicate villager id %d", new Object[] { Integer.valueOf(id) });
/* 125 */       throw new RuntimeException();
/*     */     } 
/* 127 */     this.newVillagerIds.add(Integer.valueOf(id));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerVillagerSkin(int villagerId, ResourceLocation villagerSkin) {
/* 138 */     if (this.newVillagers == null)
/*     */     {
/* 140 */       this.newVillagers = Maps.newHashMap();
/*     */     }
/* 142 */     this.newVillagers.put(Integer.valueOf(villagerId), villagerSkin);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerVillageCreationHandler(IVillageCreationHandler handler) {
/* 152 */     this.villageCreationHandlers.put(handler.getComponentClass(), handler);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerVillageTradeHandler(int villagerId, IVillageTradeHandler handler) {
/* 163 */     this.tradeHandlers.put(Integer.valueOf(villagerId), handler);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static ResourceLocation getVillagerSkin(int villagerType, ResourceLocation defaultSkin) {
/* 175 */     if ((instance()).newVillagers != null && (instance()).newVillagers.containsKey(Integer.valueOf(villagerType)))
/*     */     {
/* 177 */       return (instance()).newVillagers.get(Integer.valueOf(villagerType));
/*     */     }
/* 179 */     return defaultSkin;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Collection<Integer> getRegisteredVillagers() {
/* 189 */     return Collections.unmodifiableCollection((instance()).newVillagerIds);
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
/*     */   public static void manageVillagerTrades(MerchantRecipeList recipeList, EntityVillager villager, int villagerType, Random random) {
/* 201 */     for (IVillageTradeHandler handler : (instance()).tradeHandlers.get(Integer.valueOf(villagerType)))
/*     */     {
/* 203 */       handler.manipulateTradesForVillager(villager, recipeList, random);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void addExtraVillageComponents(ArrayList<StructureVillagePieces.PieceWeight> components, Random random, int i) {
/* 210 */     List<StructureVillagePieces.PieceWeight> parts = components;
/* 211 */     for (IVillageCreationHandler handler : (instance()).villageCreationHandlers.values())
/*     */     {
/* 213 */       parts.add(handler.getVillagePieceWeight(random, i));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object getVillageComponent(StructureVillagePieces.PieceWeight villagePiece, StructureVillagePieces.Start startPiece, List pieces, Random random, int p1, int p2, int p3, int p4, int p5) {
/* 220 */     return ((IVillageCreationHandler)(instance()).villageCreationHandlers.get(villagePiece.villagePieceClass)).buildComponent(villagePiece, startPiece, pieces, random, p1, p2, p3, p4, p5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void addEmeraldBuyRecipe(EntityVillager villager, MerchantRecipeList list, Random random, Item item, float chance, int min, int max) {
/* 227 */     if (min > 0 && max > 0)
/*     */     {
/* 229 */       EntityVillager.villagersSellingList.put(item, new Tuple(Integer.valueOf(min), Integer.valueOf(max)));
/*     */     }
/* 231 */     EntityVillager.func_146091_a(list, item, random, chance);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void addEmeraldSellRecipe(EntityVillager villager, MerchantRecipeList list, Random random, Item item, float chance, int min, int max) {
/* 237 */     if (min > 0 && max > 0)
/*     */     {
/* 239 */       EntityVillager.blacksmithSellingList.put(item, new Tuple(Integer.valueOf(min), Integer.valueOf(max)));
/*     */     }
/* 241 */     EntityVillager.func_146089_b(list, item, random, chance);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void applyRandomTrade(EntityVillager villager, Random rand) {
/* 246 */     int extra = (instance()).newVillagerIds.size();
/* 247 */     int trade = rand.nextInt(5 + extra);
/* 248 */     villager.setProfession((trade < 5) ? trade : ((Integer)(instance()).newVillagerIds.get(trade - 5)).intValue());
/*     */   }
/*     */   
/*     */   public static interface IVillageTradeHandler {
/*     */     void manipulateTradesForVillager(EntityVillager param1EntityVillager, MerchantRecipeList param1MerchantRecipeList, Random param1Random);
/*     */   }
/*     */   
/*     */   public static interface IVillageCreationHandler {
/*     */     StructureVillagePieces.PieceWeight getVillagePieceWeight(Random param1Random, int param1Int);
/*     */     
/*     */     Class<?> getComponentClass();
/*     */     
/*     */     Object buildComponent(StructureVillagePieces.PieceWeight param1PieceWeight, StructureVillagePieces.Start param1Start, List param1List, Random param1Random, int param1Int1, int param1Int2, int param1Int3, int param1Int4, int param1Int5);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\registry\VillagerRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */