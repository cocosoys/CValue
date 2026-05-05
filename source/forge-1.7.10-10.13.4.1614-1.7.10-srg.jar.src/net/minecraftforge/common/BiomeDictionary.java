/*     */ package net.minecraftforge.common;
/*     */ 
/*     */ import cpw.mods.fml.common.FMLLog;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.EnumSet;
/*     */ import java.util.List;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ import net.minecraftforge.common.util.EnumHelper;
/*     */ import net.minecraftforge.event.terraingen.DeferredBiomeDecorator;
/*     */ 
/*     */ 
/*     */ public class BiomeDictionary
/*     */ {
/*     */   public enum Type
/*     */   {
/*  18 */     HOT((String)new Type[0]),
/*  19 */     COLD((String)new Type[0]),
/*     */     
/*  21 */     SPARSE((String)new Type[0]),
/*  22 */     DENSE((String)new Type[0]),
/*     */     
/*  24 */     WET((String)new Type[0]),
/*  25 */     DRY((String)new Type[0]),
/*     */ 
/*     */     
/*  28 */     SAVANNA((String)new Type[0]),
/*  29 */     CONIFEROUS((String)new Type[0]),
/*  30 */     JUNGLE((String)new Type[0]),
/*     */ 
/*     */     
/*  33 */     SPOOKY((String)new Type[0]),
/*  34 */     DEAD((String)new Type[0]),
/*  35 */     LUSH((String)new Type[0]),
/*  36 */     NETHER((String)new Type[0]),
/*  37 */     END((String)new Type[0]),
/*  38 */     MUSHROOM((String)new Type[0]),
/*  39 */     MAGICAL((String)new Type[0]),
/*     */     
/*  41 */     OCEAN((String)new Type[0]),
/*  42 */     RIVER((String)new Type[0]),
/*     */     
/*  44 */     WATER((String)new Type[] { OCEAN, RIVER
/*     */       
/*     */       }),
/*  47 */     MESA((String)new Type[0]),
/*  48 */     FOREST((String)new Type[0]),
/*  49 */     PLAINS((String)new Type[0]),
/*  50 */     MOUNTAIN((String)new Type[0]),
/*  51 */     HILLS((String)new Type[0]),
/*  52 */     SWAMP((String)new Type[0]),
/*  53 */     SANDY((String)new Type[0]),
/*  54 */     SNOWY((String)new Type[0]),
/*  55 */     WASTELAND((String)new Type[0]),
/*  56 */     BEACH((String)new Type[0]),
/*     */ 
/*     */     
/*  59 */     DESERT((String)new Type[] { SANDY
/*     */       
/*     */       }),
/*  62 */     FROZEN((String)new Type[] { SNOWY });
/*     */ 
/*     */     
/*     */     private List<Type> subTags;
/*     */ 
/*     */ 
/*     */     
/*     */     Type(Type... subTags) {
/*  70 */       this.subTags = Arrays.asList(subTags);
/*     */     }
/*     */ 
/*     */     
/*     */     private boolean hasSubTags() {
/*  75 */       return (this.subTags != null && !this.subTags.isEmpty());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static Type getType(String name, Type... subTypes) {
/*  98 */       name = name.toUpperCase();
/*  99 */       for (Type t : values()) {
/*     */         
/* 101 */         if (t.name().equals(name))
/* 102 */           return t; 
/*     */       } 
/* 104 */       Type ret = (Type)EnumHelper.addEnum(Type.class, name, new Class[] { Type[].class }, new Object[] { subTypes });
/* 105 */       if (ret.ordinal() >= BiomeDictionary.typeInfoList.length)
/*     */       {
/* 107 */         BiomeDictionary.typeInfoList = (ArrayList<BiomeGenBase>[])Arrays.<ArrayList>copyOf((ArrayList[])BiomeDictionary.typeInfoList, ret.ordinal());
/*     */       }
/* 109 */       return ret;
/*     */     }
/*     */   }
/*     */   
/* 113 */   private static final int BIOME_LIST_SIZE = (BiomeGenBase.getBiomeGenArray()).length;
/* 114 */   private static BiomeInfo[] biomeList = new BiomeInfo[BIOME_LIST_SIZE];
/*     */   
/* 116 */   private static ArrayList<BiomeGenBase>[] typeInfoList = (ArrayList<BiomeGenBase>[])new ArrayList[(Type.values()).length];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class BiomeInfo
/*     */   {
/* 124 */     public EnumSet<BiomeDictionary.Type> typeList = EnumSet.noneOf(BiomeDictionary.Type.class); public BiomeInfo(BiomeDictionary.Type[] types) {
/* 125 */       for (BiomeDictionary.Type t : types)
/*     */       {
/* 127 */         this.typeList.add(t);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static {
/* 134 */     registerVanillaBiomes();
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
/*     */   public static boolean registerBiomeType(BiomeGenBase biome, Type... types) {
/* 146 */     types = listSubTags(types);
/*     */     
/* 148 */     if (BiomeGenBase.getBiomeGenArray()[biome.biomeID] != null) {
/*     */       
/* 150 */       for (Type type : types) {
/*     */         
/* 152 */         if (typeInfoList[type.ordinal()] == null)
/*     */         {
/* 154 */           typeInfoList[type.ordinal()] = new ArrayList<BiomeGenBase>();
/*     */         }
/*     */         
/* 157 */         typeInfoList[type.ordinal()].add(biome);
/*     */       } 
/*     */       
/* 160 */       if (biomeList[biome.biomeID] == null) {
/*     */         
/* 162 */         biomeList[biome.biomeID] = new BiomeInfo(types);
/*     */       }
/*     */       else {
/*     */         
/* 166 */         for (Type type : types)
/*     */         {
/* 168 */           (biomeList[biome.biomeID]).typeList.add(type);
/*     */         }
/*     */       } 
/*     */       
/* 172 */       return true;
/*     */     } 
/*     */     
/* 175 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static BiomeGenBase[] getBiomesForType(Type type) {
/* 186 */     if (typeInfoList[type.ordinal()] != null)
/*     */     {
/* 188 */       return typeInfoList[type.ordinal()].<BiomeGenBase>toArray(new BiomeGenBase[0]);
/*     */     }
/*     */     
/* 191 */     return new BiomeGenBase[0];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Type[] getTypesForBiome(BiomeGenBase biome) {
/* 202 */     checkRegistration(biome);
/*     */     
/* 204 */     if (biomeList[biome.biomeID] != null)
/*     */     {
/* 206 */       return (Type[])(biomeList[biome.biomeID]).typeList.toArray((Object[])new Type[0]);
/*     */     }
/*     */     
/* 209 */     return new Type[0];
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
/*     */   public static boolean areBiomesEquivalent(BiomeGenBase biomeA, BiomeGenBase biomeB) {
/* 221 */     int a = biomeA.biomeID;
/* 222 */     int b = biomeB.biomeID;
/*     */     
/* 224 */     checkRegistration(biomeA);
/* 225 */     checkRegistration(biomeB);
/*     */     
/* 227 */     if (biomeList[a] != null && biomeList[b] != null)
/*     */     {
/* 229 */       for (Type type : (biomeList[a]).typeList) {
/*     */         
/* 231 */         if (containsType(biomeList[b], type))
/*     */         {
/* 233 */           return true;
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/* 238 */     return false;
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
/*     */   public static boolean isBiomeOfType(BiomeGenBase biome, Type type) {
/* 250 */     checkRegistration(biome);
/*     */     
/* 252 */     if (biomeList[biome.biomeID] != null)
/*     */     {
/* 254 */       return containsType(biomeList[biome.biomeID], type);
/*     */     }
/*     */     
/* 257 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isBiomeRegistered(BiomeGenBase biome) {
/* 267 */     return (biomeList[biome.biomeID] != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isBiomeRegistered(int biomeID) {
/* 272 */     return (biomeList[biomeID] != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void registerAllBiomes() {
/* 277 */     FMLLog.warning("Redundant call to BiomeDictionary.registerAllBiomes ignored", new Object[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void registerAllBiomesAndGenerateEvents() {
/* 288 */     for (int i = 0; i < (BiomeGenBase.getBiomeGenArray()).length; i++) {
/*     */       
/* 290 */       BiomeGenBase biome = BiomeGenBase.getBiomeGenArray()[i];
/*     */       
/* 292 */       if (biome != null) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 297 */         if (biome.theBiomeDecorator instanceof DeferredBiomeDecorator) {
/*     */           
/* 299 */           DeferredBiomeDecorator decorator = (DeferredBiomeDecorator)biome.theBiomeDecorator;
/* 300 */           decorator.fireCreateEventAndReplace(biome);
/*     */         } 
/*     */         
/* 303 */         checkRegistration(biome);
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
/*     */   public static void makeBestGuess(BiomeGenBase biome) {
/* 316 */     if (biome.theBiomeDecorator.treesPerChunk >= 3) {
/*     */       
/* 318 */       if (biome.isHighHumidity() && biome.temperature >= 0.9F)
/*     */       {
/* 320 */         registerBiomeType(biome, new Type[] { Type.JUNGLE });
/*     */       }
/* 322 */       else if (!biome.isHighHumidity())
/*     */       {
/* 324 */         registerBiomeType(biome, new Type[] { Type.FOREST });
/*     */         
/* 326 */         if (biome.temperature <= 0.2F)
/*     */         {
/* 328 */           registerBiomeType(biome, new Type[] { Type.CONIFEROUS });
/*     */         }
/*     */       }
/*     */     
/* 332 */     } else if (biome.heightVariation <= 0.3F && biome.heightVariation >= 0.0F) {
/*     */       
/* 334 */       if (!biome.isHighHumidity() || biome.rootHeight >= 0.0F)
/*     */       {
/* 336 */         registerBiomeType(biome, new Type[] { Type.PLAINS });
/*     */       }
/*     */     } 
/*     */     
/* 340 */     if (biome.rainfall > 0.85F)
/*     */     {
/* 342 */       registerBiomeType(biome, new Type[] { Type.WET });
/*     */     }
/*     */     
/* 345 */     if (biome.rainfall < 0.15F)
/*     */     {
/* 347 */       registerBiomeType(biome, new Type[] { Type.DRY });
/*     */     }
/*     */     
/* 350 */     if (biome.temperature > 0.85F)
/*     */     {
/* 352 */       registerBiomeType(biome, new Type[] { Type.HOT });
/*     */     }
/*     */     
/* 355 */     if (biome.temperature < 0.15F)
/*     */     {
/* 357 */       registerBiomeType(biome, new Type[] { Type.COLD });
/*     */     }
/*     */     
/* 360 */     if (biome.theBiomeDecorator.treesPerChunk > 0 && biome.theBiomeDecorator.treesPerChunk < 3) {
/*     */       
/* 362 */       registerBiomeType(biome, new Type[] { Type.SPARSE });
/*     */     }
/* 364 */     else if (biome.theBiomeDecorator.treesPerChunk >= 10) {
/*     */       
/* 366 */       registerBiomeType(biome, new Type[] { Type.DENSE });
/*     */     } 
/*     */     
/* 369 */     if (biome.isHighHumidity() && biome.rootHeight < 0.0F && biome.heightVariation <= 0.3F && biome.heightVariation >= 0.0F)
/*     */     {
/* 371 */       registerBiomeType(biome, new Type[] { Type.SWAMP });
/*     */     }
/*     */     
/* 374 */     if (biome.rootHeight <= -0.5F)
/*     */     {
/* 376 */       if (biome.heightVariation == 0.0F) {
/*     */         
/* 378 */         registerBiomeType(biome, new Type[] { Type.RIVER });
/*     */       }
/*     */       else {
/*     */         
/* 382 */         registerBiomeType(biome, new Type[] { Type.OCEAN });
/*     */       } 
/*     */     }
/*     */     
/* 386 */     if (biome.heightVariation >= 0.4F && biome.heightVariation < 1.5F)
/*     */     {
/* 388 */       registerBiomeType(biome, new Type[] { Type.HILLS });
/*     */     }
/*     */     
/* 391 */     if (biome.heightVariation >= 1.5F)
/*     */     {
/* 393 */       registerBiomeType(biome, new Type[] { Type.MOUNTAIN });
/*     */     }
/*     */     
/* 396 */     if (biome.getEnableSnow())
/*     */     {
/* 398 */       registerBiomeType(biome, new Type[] { Type.SNOWY });
/*     */     }
/*     */     
/* 401 */     if (biome.topBlock != Blocks.sand && biome.temperature >= 1.0F && biome.rainfall < 0.2F)
/*     */     {
/* 403 */       registerBiomeType(biome, new Type[] { Type.SAVANNA });
/*     */     }
/*     */     
/* 406 */     if (biome.topBlock == Blocks.sand) {
/*     */       
/* 408 */       registerBiomeType(biome, new Type[] { Type.SANDY });
/*     */     }
/* 410 */     else if (biome.topBlock == Blocks.hardened_clay) {
/*     */       
/* 412 */       registerBiomeType(biome, new Type[] { Type.MESA });
/*     */     }
/* 414 */     else if (biome.topBlock == Blocks.mycelium) {
/*     */       
/* 416 */       registerBiomeType(biome, new Type[] { Type.MUSHROOM });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void checkRegistration(BiomeGenBase biome) {
/* 423 */     if (!isBiomeRegistered(biome))
/*     */     {
/* 425 */       makeBestGuess(biome);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean containsType(BiomeInfo info, Type type) {
/* 431 */     if (type.hasSubTags()) {
/*     */       
/* 433 */       for (Type remappedType : listSubTags(new Type[] { type })) {
/*     */         
/* 435 */         if (info.typeList.contains(remappedType)) return true;
/*     */       
/*     */       } 
/* 438 */       return false;
/*     */     } 
/*     */     
/* 441 */     return info.typeList.contains(type);
/*     */   }
/*     */ 
/*     */   
/*     */   private static Type[] listSubTags(Type... types) {
/* 446 */     List<Type> subTags = new ArrayList<Type>();
/*     */     
/* 448 */     for (Type type : types) {
/*     */       
/* 450 */       if (type.hasSubTags()) { subTags.addAll(type.subTags); }
/* 451 */       else { subTags.add(type); }
/*     */     
/*     */     } 
/* 454 */     return subTags.<Type>toArray(new Type[subTags.size()]);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void registerVanillaBiomes() {
/* 459 */     registerBiomeType(BiomeGenBase.ocean, new Type[] { Type.OCEAN });
/* 460 */     registerBiomeType(BiomeGenBase.plains, new Type[] { Type.PLAINS });
/* 461 */     registerBiomeType(BiomeGenBase.desert, new Type[] { Type.HOT, Type.DRY, Type.SANDY });
/* 462 */     registerBiomeType(BiomeGenBase.extremeHills, new Type[] { Type.MOUNTAIN, Type.HILLS });
/* 463 */     registerBiomeType(BiomeGenBase.forest, new Type[] { Type.FOREST });
/* 464 */     registerBiomeType(BiomeGenBase.taiga, new Type[] { Type.COLD, Type.CONIFEROUS, Type.FOREST });
/* 465 */     registerBiomeType(BiomeGenBase.taigaHills, new Type[] { Type.COLD, Type.CONIFEROUS, Type.FOREST, Type.HILLS });
/* 466 */     registerBiomeType(BiomeGenBase.swampland, new Type[] { Type.WET, Type.SWAMP });
/* 467 */     registerBiomeType(BiomeGenBase.river, new Type[] { Type.RIVER });
/* 468 */     registerBiomeType(BiomeGenBase.frozenOcean, new Type[] { Type.COLD, Type.OCEAN, Type.SNOWY });
/* 469 */     registerBiomeType(BiomeGenBase.frozenRiver, new Type[] { Type.COLD, Type.RIVER, Type.SNOWY });
/* 470 */     registerBiomeType(BiomeGenBase.icePlains, new Type[] { Type.COLD, Type.SNOWY, Type.WASTELAND });
/* 471 */     registerBiomeType(BiomeGenBase.iceMountains, new Type[] { Type.COLD, Type.SNOWY, Type.MOUNTAIN });
/* 472 */     registerBiomeType(BiomeGenBase.beach, new Type[] { Type.BEACH });
/* 473 */     registerBiomeType(BiomeGenBase.desertHills, new Type[] { Type.HOT, Type.DRY, Type.SANDY, Type.HILLS });
/* 474 */     registerBiomeType(BiomeGenBase.jungle, new Type[] { Type.HOT, Type.WET, Type.DENSE, Type.JUNGLE });
/* 475 */     registerBiomeType(BiomeGenBase.jungleHills, new Type[] { Type.HOT, Type.WET, Type.DENSE, Type.JUNGLE, Type.HILLS });
/* 476 */     registerBiomeType(BiomeGenBase.forestHills, new Type[] { Type.FOREST, Type.HILLS });
/* 477 */     registerBiomeType(BiomeGenBase.sky, new Type[] { Type.COLD, Type.DRY, Type.END });
/* 478 */     registerBiomeType(BiomeGenBase.hell, new Type[] { Type.HOT, Type.DRY, Type.NETHER });
/* 479 */     registerBiomeType(BiomeGenBase.mushroomIsland, new Type[] { Type.MUSHROOM });
/* 480 */     registerBiomeType(BiomeGenBase.extremeHillsEdge, new Type[] { Type.MOUNTAIN });
/* 481 */     registerBiomeType(BiomeGenBase.mushroomIslandShore, new Type[] { Type.MUSHROOM, Type.BEACH });
/* 482 */     registerBiomeType(BiomeGenBase.jungleEdge, new Type[] { Type.HOT, Type.WET, Type.JUNGLE, Type.FOREST });
/* 483 */     registerBiomeType(BiomeGenBase.deepOcean, new Type[] { Type.OCEAN });
/* 484 */     registerBiomeType(BiomeGenBase.stoneBeach, new Type[] { Type.BEACH });
/* 485 */     registerBiomeType(BiomeGenBase.coldBeach, new Type[] { Type.COLD, Type.BEACH, Type.SNOWY });
/* 486 */     registerBiomeType(BiomeGenBase.birchForest, new Type[] { Type.FOREST });
/* 487 */     registerBiomeType(BiomeGenBase.birchForestHills, new Type[] { Type.FOREST, Type.HILLS });
/* 488 */     registerBiomeType(BiomeGenBase.roofedForest, new Type[] { Type.SPOOKY, Type.DENSE, Type.FOREST });
/* 489 */     registerBiomeType(BiomeGenBase.coldTaiga, new Type[] { Type.COLD, Type.CONIFEROUS, Type.FOREST, Type.SNOWY });
/* 490 */     registerBiomeType(BiomeGenBase.coldTaigaHills, new Type[] { Type.COLD, Type.CONIFEROUS, Type.FOREST, Type.SNOWY, Type.HILLS });
/* 491 */     registerBiomeType(BiomeGenBase.megaTaiga, new Type[] { Type.COLD, Type.CONIFEROUS, Type.FOREST });
/* 492 */     registerBiomeType(BiomeGenBase.megaTaigaHills, new Type[] { Type.COLD, Type.CONIFEROUS, Type.FOREST, Type.HILLS });
/* 493 */     registerBiomeType(BiomeGenBase.extremeHillsPlus, new Type[] { Type.MOUNTAIN, Type.FOREST, Type.SPARSE });
/* 494 */     registerBiomeType(BiomeGenBase.savanna, new Type[] { Type.HOT, Type.SAVANNA, Type.PLAINS, Type.SPARSE });
/* 495 */     registerBiomeType(BiomeGenBase.savannaPlateau, new Type[] { Type.HOT, Type.SAVANNA, Type.PLAINS, Type.SPARSE });
/* 496 */     registerBiomeType(BiomeGenBase.mesa, new Type[] { Type.MESA, Type.SANDY });
/* 497 */     registerBiomeType(BiomeGenBase.mesaPlateau_F, new Type[] { Type.MESA, Type.SPARSE, Type.SANDY });
/* 498 */     registerBiomeType(BiomeGenBase.mesaPlateau, new Type[] { Type.MESA, Type.SANDY });
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\common\BiomeDictionary.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */