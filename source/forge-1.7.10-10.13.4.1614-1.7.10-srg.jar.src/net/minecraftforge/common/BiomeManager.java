/*     */ package net.minecraftforge.common;
/*     */ 
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import net.minecraft.util.WeightedRandom;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ import net.minecraft.world.biome.WorldChunkManager;
/*     */ import net.minecraft.world.gen.structure.MapGenVillage;
/*     */ import net.minecraftforge.common.util.EnumHelper;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BiomeManager
/*     */ {
/*  21 */   private static TrackedList<BiomeEntry>[] biomes = setupBiomes();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*  27 */   public static List<BiomeEntry> desertBiomes = biomes[BiomeType.DESERT.ordinal()];
/*     */   @Deprecated
/*  29 */   public static List<BiomeEntry> warmBiomes = biomes[BiomeType.WARM.ordinal()];
/*     */   @Deprecated
/*  31 */   public static List<BiomeEntry> coolBiomes = biomes[BiomeType.COOL.ordinal()];
/*     */   @Deprecated
/*  33 */   public static List<BiomeEntry> icyBiomes = biomes[BiomeType.ICY.ordinal()];
/*     */   
/*     */   private static boolean isModded = false;
/*     */   
/*  37 */   public static List<BiomeGenBase> oceanBiomes = new ArrayList<BiomeGenBase>();
/*     */   
/*  39 */   public static ArrayList<BiomeGenBase> strongHoldBiomes = new ArrayList<BiomeGenBase>();
/*  40 */   public static ArrayList<BiomeGenBase> strongHoldBiomesBlackList = new ArrayList<BiomeGenBase>();
/*     */ 
/*     */   
/*     */   static {
/*  44 */     oceanBiomes.add(BiomeGenBase.ocean);
/*  45 */     oceanBiomes.add(BiomeGenBase.deepOcean);
/*  46 */     oceanBiomes.add(BiomeGenBase.frozenOcean);
/*     */   }
/*     */ 
/*     */   
/*     */   private static TrackedList<BiomeEntry>[] setupBiomes() {
/*  51 */     TrackedList[] arrayOfTrackedList = new TrackedList[(BiomeType.values()).length];
/*  52 */     List<BiomeEntry> list = new ArrayList();
/*     */     
/*  54 */     list.add(new BiomeEntry(BiomeGenBase.forest, 10));
/*  55 */     list.add(new BiomeEntry(BiomeGenBase.roofedForest, 10));
/*  56 */     list.add(new BiomeEntry(BiomeGenBase.extremeHills, 10));
/*  57 */     list.add(new BiomeEntry(BiomeGenBase.plains, 10));
/*  58 */     list.add(new BiomeEntry(BiomeGenBase.birchForest, 10));
/*  59 */     list.add(new BiomeEntry(BiomeGenBase.swampland, 10));
/*     */     
/*  61 */     arrayOfTrackedList[BiomeType.WARM.ordinal()] = new TrackedList<BiomeEntry>(list);
/*  62 */     list.clear();
/*     */     
/*  64 */     list.add(new BiomeEntry(BiomeGenBase.forest, 10));
/*  65 */     list.add(new BiomeEntry(BiomeGenBase.extremeHills, 10));
/*  66 */     list.add(new BiomeEntry(BiomeGenBase.taiga, 10));
/*  67 */     list.add(new BiomeEntry(BiomeGenBase.plains, 10));
/*     */     
/*  69 */     arrayOfTrackedList[BiomeType.COOL.ordinal()] = new TrackedList<BiomeEntry>(list);
/*  70 */     list.clear();
/*     */     
/*  72 */     list.add(new BiomeEntry(BiomeGenBase.icePlains, 30));
/*  73 */     list.add(new BiomeEntry(BiomeGenBase.coldTaiga, 10));
/*     */     
/*  75 */     arrayOfTrackedList[BiomeType.ICY.ordinal()] = new TrackedList<BiomeEntry>(list);
/*  76 */     list.clear();
/*     */     
/*  78 */     arrayOfTrackedList[BiomeType.DESERT.ordinal()] = new TrackedList<BiomeEntry>(list);
/*     */     
/*  80 */     return (TrackedList<BiomeEntry>[])arrayOfTrackedList;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void addVillageBiome(BiomeGenBase biome, boolean canSpawn) {
/*  86 */     if (!MapGenVillage.villageSpawnBiomes.contains(biome)) {
/*     */       
/*  88 */       ArrayList<BiomeGenBase> biomes = new ArrayList<BiomeGenBase>(MapGenVillage.villageSpawnBiomes);
/*  89 */       biomes.add(biome);
/*  90 */       MapGenVillage.villageSpawnBiomes = biomes;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void removeVillageBiome(BiomeGenBase biome) {
/*  97 */     if (MapGenVillage.villageSpawnBiomes.contains(biome)) {
/*     */       
/*  99 */       ArrayList<BiomeGenBase> biomes = new ArrayList<BiomeGenBase>(MapGenVillage.villageSpawnBiomes);
/* 100 */       biomes.remove(biome);
/* 101 */       MapGenVillage.villageSpawnBiomes = biomes;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void addStrongholdBiome(BiomeGenBase biome) {
/* 107 */     if (!strongHoldBiomes.contains(biome))
/*     */     {
/* 109 */       strongHoldBiomes.add(biome);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static void removeStrongholdBiome(BiomeGenBase biome) {
/* 115 */     if (!strongHoldBiomesBlackList.contains(biome))
/*     */     {
/* 117 */       strongHoldBiomesBlackList.add(biome);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static void addSpawnBiome(BiomeGenBase biome) {
/* 123 */     if (!WorldChunkManager.allowedBiomes.contains(biome))
/*     */     {
/* 125 */       WorldChunkManager.allowedBiomes.add(biome);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static void removeSpawnBiome(BiomeGenBase biome) {
/* 131 */     if (WorldChunkManager.allowedBiomes.contains(biome))
/*     */     {
/* 133 */       WorldChunkManager.allowedBiomes.remove(biome);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static void addBiome(BiomeType type, BiomeEntry entry) {
/* 139 */     isModded = true;
/*     */     
/* 141 */     int idx = type.ordinal();
/* 142 */     List<BiomeEntry> list = (idx > biomes.length) ? null : biomes[idx];
/* 143 */     if (list != null) list.add(entry);
/*     */   
/*     */   }
/*     */   
/*     */   public static void removeBiome(BiomeType type, BiomeEntry entry) {
/* 148 */     isModded = true;
/*     */     
/* 150 */     int idx = type.ordinal();
/* 151 */     List<BiomeEntry> list = (idx > biomes.length) ? null : biomes[idx];
/*     */     
/* 153 */     if (list != null && list.contains(entry))
/*     */     {
/* 155 */       list.remove(entry);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static ImmutableList<BiomeEntry> getBiomes(BiomeType type) {
/* 161 */     int idx = type.ordinal();
/* 162 */     List<BiomeEntry> list = (idx > biomes.length) ? null : biomes[idx];
/*     */     
/* 164 */     return (list != null) ? ImmutableList.copyOf(list) : null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isTypeListModded(BiomeType type) {
/* 169 */     int idx = type.ordinal();
/* 170 */     TrackedList<BiomeEntry> list = (idx > biomes.length) ? null : biomes[idx];
/*     */     
/* 172 */     if (list != null) return list.isModded();
/*     */     
/* 174 */     return false;
/*     */   }
/*     */   
/*     */   public enum BiomeType
/*     */   {
/* 179 */     DESERT, WARM, COOL, ICY;
/*     */ 
/*     */     
/*     */     public static BiomeType getType(String name) {
/* 183 */       name = name.toUpperCase();
/*     */       
/* 185 */       for (BiomeType t : values()) {
/*     */         
/* 187 */         if (t.name().equals(name)) return t;
/*     */       
/*     */       } 
/* 190 */       BiomeType ret = (BiomeType)EnumHelper.addEnum(BiomeType.class, name, new Object[] { BiomeType.class });
/*     */       
/* 192 */       if (ret.ordinal() >= BiomeManager.biomes.length)
/*     */       {
/* 194 */         BiomeManager.biomes = (BiomeManager.TrackedList<BiomeManager.BiomeEntry>[])Arrays.<BiomeManager.TrackedList>copyOf((BiomeManager.TrackedList[])BiomeManager.biomes, ret.ordinal());
/*     */       }
/*     */       
/* 197 */       return ret;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class BiomeEntry
/*     */     extends WeightedRandom.Item
/*     */   {
/*     */     public final BiomeGenBase biome;
/*     */     
/*     */     public BiomeEntry(BiomeGenBase biome, int weight) {
/* 207 */       super(weight);
/*     */       
/* 209 */       this.biome = biome;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class TrackedList<E>
/*     */     extends ArrayList<E>
/*     */   {
/*     */     private boolean isModded = false;
/*     */     
/*     */     public TrackedList(Collection<? extends E> c) {
/* 219 */       super(c);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public E set(int index, E element) {
/* 225 */       this.isModded = true;
/* 226 */       return super.set(index, element);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean add(E e) {
/* 232 */       this.isModded = true;
/* 233 */       return super.add(e);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void add(int index, E element) {
/* 239 */       this.isModded = true;
/* 240 */       super.add(index, element);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public E remove(int index) {
/* 246 */       this.isModded = true;
/* 247 */       return super.remove(index);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean remove(Object o) {
/* 253 */       this.isModded = true;
/* 254 */       return super.remove(o);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void clear() {
/* 260 */       this.isModded = true;
/* 261 */       super.clear();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean addAll(Collection<? extends E> c) {
/* 267 */       this.isModded = true;
/* 268 */       return super.addAll(c);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean addAll(int index, Collection<? extends E> c) {
/* 274 */       this.isModded = true;
/* 275 */       return super.addAll(index, c);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean removeAll(Collection<?> c) {
/* 281 */       this.isModded = true;
/* 282 */       return super.removeAll(c);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean retainAll(Collection<?> c) {
/* 288 */       this.isModded = true;
/* 289 */       return super.retainAll(c);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isModded() {
/* 294 */       return this.isModded;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\common\BiomeManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */