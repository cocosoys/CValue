/*     */ package JinRyuu.DragonBC.common.Worlds;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
/*     */ import JinRyuu.DragonBC.common.DBCConfig;
/*     */ import JinRyuu.DragonBC.common.DBCH;
/*     */ import JinRyuu.DragonBC.common.Npcs.EntityMasterEnma;
/*     */ import JinRyuu.DragonBC.common.Npcs.EntityMasterJin;
/*     */ import JinRyuu.DragonBC.common.Npcs.EntityMasterKaio;
/*     */ import JinRyuu.DragonBC.common.Villages.ChkInSt;
/*     */ import JinRyuu.DragonBC.common.Villages.SnkWy;
/*     */ import JinRyuu.DragonBC.common.Villages.TiCha;
/*     */ import JinRyuu.DragonBC.common.Villages.bs;
/*     */ import JinRyuu.DragonBC.common.Villages.builds;
/*     */ import JinRyuu.DragonBC.common.Villages.ca;
/*     */ import JinRyuu.DragonBC.common.Villages.fs;
/*     */ import JinRyuu.DragonBC.common.Villages.gh;
/*     */ import JinRyuu.DragonBC.common.Worlds.structures.StructureGuru;
/*     */ import JinRyuu.DragonBC.common.Worlds.structures.StructureTOP1;
/*     */ import JinRyuu.DragonBC.common.Worlds.structures.StructureTOP2;
/*     */ import JinRyuu.DragonBC.common.Worlds.structures.StructureZenoExpo;
/*     */ import JinRyuu.JRMCore.JRMCoreComTickH;
/*     */ import JinRyuu.JRMCore.JRMCoreConfig;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.JRMCoreHDBC;
/*     */ import JinRyuu.JRMCore.blocks.BlocksJRMC;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import cpw.mods.fml.common.IWorldGenerator;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ import net.minecraft.world.chunk.IChunkProvider;
/*     */ import net.minecraft.world.gen.feature.WorldGenMinable;
/*     */ import net.minecraft.world.gen.feature.WorldGenerator;
/*     */ 
/*     */ public class WorldGeneratorDB
/*     */   implements IWorldGenerator
/*     */ {
/*     */   protected WorldGenerator ChkInSt;
/*     */   protected WorldGenerator KiLt;
/*     */   protected WorldGenerator SnkWy;
/*     */   protected WorldGenerator TiCha;
/*     */   protected WorldGenerator KnTr;
/*     */   protected WorldGenerator WorldGen_TOPArena;
/*     */   protected WorldGenerator WorldGen_TOPZeno;
/*     */   protected WorldGenerator WorldGen_ZenoExpo;
/*     */   
/*     */   public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
/*  56 */     switch (world.field_73011_w.field_76574_g) {
/*     */       
/*     */       case -1:
/*  59 */         generateNether(world, random, chunkX * 16, chunkZ * 16); break;
/*     */       case 0:
/*  61 */         generateSurface(world, random, chunkX * 16, chunkZ * 16); break;
/*     */       case 20:
/*  63 */         generateNamek(world, random, chunkX * 16, chunkZ * 16); break;
/*     */       case 22:
/*  65 */         generateOW(world, random, chunkX * 16, chunkZ * 16); break;
/*     */       case 23:
/*  67 */         generateTC(world, random, chunkX * 16, chunkZ * 16); break;
/*     */       case 24:
/*  69 */         generateNR(world, random, chunkX * 16, chunkZ * 16);
/*     */         break;
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean KiLtSpawn = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean KiLtTCSpawn = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean ChkInStSpawn = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean SnkWySpawn = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean TiChaSpawn = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean TiChaKLSpawn = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean KnTrSpawn = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean WorldGen_TOPArena_Done = true, WorldGen_TOPZeno_Done = true, WorldGen_Zeno_Done = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean FSSpawn = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean KHSpawn = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean CASpawn = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean GHSpawn = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean BSSpawn = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean WorldGen_GuruHouse_Done = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void generateSurface(World world, Random random, int BlockX, int BlockZ) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: getfield field_73011_w : Lnet/minecraft/world/WorldProvider;
/*     */     //   4: getfield field_76574_g : I
/*     */     //   7: ifne -> 1210
/*     */     //   10: iconst_0
/*     */     //   11: istore #5
/*     */     //   13: iload #5
/*     */     //   15: bipush #10
/*     */     //   17: if_icmpge -> 82
/*     */     //   20: iload_3
/*     */     //   21: aload_2
/*     */     //   22: bipush #16
/*     */     //   24: invokevirtual nextInt : (I)I
/*     */     //   27: iadd
/*     */     //   28: istore #6
/*     */     //   30: iload #4
/*     */     //   32: aload_2
/*     */     //   33: bipush #16
/*     */     //   35: invokevirtual nextInt : (I)I
/*     */     //   38: iadd
/*     */     //   39: istore #7
/*     */     //   41: bipush #10
/*     */     //   43: aload_2
/*     */     //   44: bipush #127
/*     */     //   46: invokevirtual nextInt : (I)I
/*     */     //   49: iadd
/*     */     //   50: istore #8
/*     */     //   52: new net/minecraft/world/gen/feature/WorldGenMinable
/*     */     //   55: dup
/*     */     //   56: getstatic JinRyuu/DragonBC/common/Blocks/BlocksDBC.BlockOreWrenai : Lnet/minecraft/block/Block;
/*     */     //   59: bipush #8
/*     */     //   61: invokespecial <init> : (Lnet/minecraft/block/Block;I)V
/*     */     //   64: aload_1
/*     */     //   65: aload_2
/*     */     //   66: iload #6
/*     */     //   68: iload #8
/*     */     //   70: iload #7
/*     */     //   72: invokevirtual func_76484_a : (Lnet/minecraft/world/World;Ljava/util/Random;III)Z
/*     */     //   75: pop
/*     */     //   76: iinc #5, 1
/*     */     //   79: goto -> 13
/*     */     //   82: getstatic JinRyuu/JRMCore/JRMCoreConfig.BuildingSpawnCheck : Z
/*     */     //   85: ifeq -> 899
/*     */     //   88: aload_1
/*     */     //   89: bipush #86
/*     */     //   91: sipush #216
/*     */     //   94: bipush #50
/*     */     //   96: invokevirtual func_147439_a : (III)Lnet/minecraft/block/Block;
/*     */     //   99: getstatic JinRyuu/JRMCore/blocks/BlocksJRMC.BlockColoredStone : Lnet/minecraft/block/Block;
/*     */     //   102: if_acmpeq -> 899
/*     */     //   105: getstatic JinRyuu/DragonBC/common/Worlds/WorldGeneratorDB.KiLtSpawn : Z
/*     */     //   108: ifeq -> 899
/*     */     //   111: iconst_0
/*     */     //   112: putstatic JinRyuu/DragonBC/common/Worlds/WorldGeneratorDB.KiLtSpawn : Z
/*     */     //   115: aload_0
/*     */     //   116: new JinRyuu/DragonBC/common/Villages/KiLt
/*     */     //   119: dup
/*     */     //   120: invokespecial <init> : ()V
/*     */     //   123: putfield KiLt : Lnet/minecraft/world/gen/feature/WorldGenerator;
/*     */     //   126: aload_0
/*     */     //   127: getfield KiLt : Lnet/minecraft/world/gen/feature/WorldGenerator;
/*     */     //   130: aload_1
/*     */     //   131: aload_1
/*     */     //   132: getfield field_73012_v : Ljava/util/Random;
/*     */     //   135: iconst_0
/*     */     //   136: iconst_0
/*     */     //   137: iconst_0
/*     */     //   138: invokevirtual func_76484_a : (Lnet/minecraft/world/World;Ljava/util/Random;III)Z
/*     */     //   141: pop
/*     */     //   142: aload_1
/*     */     //   143: bipush #43
/*     */     //   145: sipush #216
/*     */     //   148: bipush #37
/*     */     //   150: getstatic JinRyuu/JRMCore/blocks/BlocksJRMC.BlockColoredStone : Lnet/minecraft/block/Block;
/*     */     //   153: iconst_0
/*     */     //   154: iconst_3
/*     */     //   155: invokevirtual func_147465_d : (IIILnet/minecraft/block/Block;II)Z
/*     */     //   158: pop
/*     */     //   159: aload_1
/*     */     //   160: bipush #77
/*     */     //   162: sipush #167
/*     */     //   165: bipush #42
/*     */     //   167: getstatic JinRyuu/JRMCore/blocks/BlocksJRMC.BlockColoredStone : Lnet/minecraft/block/Block;
/*     */     //   170: iconst_4
/*     */     //   171: iconst_3
/*     */     //   172: invokevirtual func_147465_d : (IIILnet/minecraft/block/Block;II)Z
/*     */     //   175: pop
/*     */     //   176: aload_1
/*     */     //   177: bipush #78
/*     */     //   179: sipush #217
/*     */     //   182: bipush #32
/*     */     //   184: getstatic JinRyuu/JRMCore/blocks/BlocksJRMC.stoneSingleSlab : LJinRyuu/JRMCore/blocks/BlockJRMCHalfSlab;
/*     */     //   187: invokevirtual func_147449_b : (IIILnet/minecraft/block/Block;)Z
/*     */     //   190: pop
/*     */     //   191: aload_1
/*     */     //   192: bipush #76
/*     */     //   194: sipush #217
/*     */     //   197: bipush #32
/*     */     //   199: getstatic JinRyuu/JRMCore/blocks/BlocksJRMC.stoneSingleSlab : LJinRyuu/JRMCore/blocks/BlockJRMCHalfSlab;
/*     */     //   202: invokevirtual func_147449_b : (IIILnet/minecraft/block/Block;)Z
/*     */     //   205: pop
/*     */     //   206: aload_1
/*     */     //   207: bipush #78
/*     */     //   209: sipush #218
/*     */     //   212: bipush #32
/*     */     //   214: getstatic net/minecraft/init/Blocks.field_150350_a : Lnet/minecraft/block/Block;
/*     */     //   217: iconst_0
/*     */     //   218: iconst_3
/*     */     //   219: invokevirtual func_147465_d : (IIILnet/minecraft/block/Block;II)Z
/*     */     //   222: pop
/*     */     //   223: aload_1
/*     */     //   224: bipush #78
/*     */     //   226: sipush #219
/*     */     //   229: bipush #32
/*     */     //   231: getstatic net/minecraft/init/Blocks.field_150350_a : Lnet/minecraft/block/Block;
/*     */     //   234: iconst_0
/*     */     //   235: iconst_3
/*     */     //   236: invokevirtual func_147465_d : (IIILnet/minecraft/block/Block;II)Z
/*     */     //   239: pop
/*     */     //   240: aload_1
/*     */     //   241: bipush #78
/*     */     //   243: sipush #220
/*     */     //   246: bipush #32
/*     */     //   248: getstatic net/minecraft/init/Blocks.field_150350_a : Lnet/minecraft/block/Block;
/*     */     //   251: iconst_0
/*     */     //   252: iconst_3
/*     */     //   253: invokevirtual func_147465_d : (IIILnet/minecraft/block/Block;II)Z
/*     */     //   256: pop
/*     */     //   257: aload_1
/*     */     //   258: bipush #76
/*     */     //   260: sipush #218
/*     */     //   263: bipush #32
/*     */     //   265: getstatic net/minecraft/init/Blocks.field_150350_a : Lnet/minecraft/block/Block;
/*     */     //   268: iconst_0
/*     */     //   269: iconst_3
/*     */     //   270: invokevirtual func_147465_d : (IIILnet/minecraft/block/Block;II)Z
/*     */     //   273: pop
/*     */     //   274: aload_1
/*     */     //   275: bipush #76
/*     */     //   277: sipush #219
/*     */     //   280: bipush #32
/*     */     //   282: getstatic net/minecraft/init/Blocks.field_150350_a : Lnet/minecraft/block/Block;
/*     */     //   285: iconst_0
/*     */     //   286: iconst_3
/*     */     //   287: invokevirtual func_147465_d : (IIILnet/minecraft/block/Block;II)Z
/*     */     //   290: pop
/*     */     //   291: aload_1
/*     */     //   292: bipush #76
/*     */     //   294: sipush #220
/*     */     //   297: bipush #32
/*     */     //   299: getstatic net/minecraft/init/Blocks.field_150350_a : Lnet/minecraft/block/Block;
/*     */     //   302: iconst_0
/*     */     //   303: iconst_3
/*     */     //   304: invokevirtual func_147465_d : (IIILnet/minecraft/block/Block;II)Z
/*     */     //   307: pop
/*     */     //   308: aload_1
/*     */     //   309: bipush #79
/*     */     //   311: sipush #218
/*     */     //   314: bipush #32
/*     */     //   316: getstatic JinRyuu/JRMCore/blocks/BlocksJRMC.BlockColoredStone : Lnet/minecraft/block/Block;
/*     */     //   319: iconst_4
/*     */     //   320: iconst_3
/*     */     //   321: invokevirtual func_147465_d : (IIILnet/minecraft/block/Block;II)Z
/*     */     //   324: pop
/*     */     //   325: aload_1
/*     */     //   326: bipush #79
/*     */     //   328: sipush #219
/*     */     //   331: bipush #32
/*     */     //   333: getstatic JinRyuu/JRMCore/blocks/BlocksJRMC.BlockColoredStone : Lnet/minecraft/block/Block;
/*     */     //   336: iconst_4
/*     */     //   337: iconst_3
/*     */     //   338: invokevirtual func_147465_d : (IIILnet/minecraft/block/Block;II)Z
/*     */     //   341: pop
/*     */     //   342: aload_1
/*     */     //   343: bipush #79
/*     */     //   345: sipush #220
/*     */     //   348: bipush #32
/*     */     //   350: getstatic JinRyuu/JRMCore/blocks/BlocksJRMC.BlockColoredStone : Lnet/minecraft/block/Block;
/*     */     //   353: iconst_4
/*     */     //   354: iconst_3
/*     */     //   355: invokevirtual func_147465_d : (IIILnet/minecraft/block/Block;II)Z
/*     */     //   358: pop
/*     */     //   359: aload_1
/*     */     //   360: bipush #79
/*     */     //   362: sipush #221
/*     */     //   365: bipush #32
/*     */     //   367: getstatic JinRyuu/JRMCore/blocks/BlocksJRMC.BlockColoredStone : Lnet/minecraft/block/Block;
/*     */     //   370: iconst_4
/*     */     //   371: iconst_3
/*     */     //   372: invokevirtual func_147465_d : (IIILnet/minecraft/block/Block;II)Z
/*     */     //   375: pop
/*     */     //   376: aload_1
/*     */     //   377: bipush #75
/*     */     //   379: sipush #218
/*     */     //   382: bipush #32
/*     */     //   384: getstatic JinRyuu/JRMCore/blocks/BlocksJRMC.BlockColoredStone : Lnet/minecraft/block/Block;
/*     */     //   387: iconst_4
/*     */     //   388: iconst_3
/*     */     //   389: invokevirtual func_147465_d : (IIILnet/minecraft/block/Block;II)Z
/*     */     //   392: pop
/*     */     //   393: aload_1
/*     */     //   394: bipush #75
/*     */     //   396: sipush #219
/*     */     //   399: bipush #32
/*     */     //   401: getstatic JinRyuu/JRMCore/blocks/BlocksJRMC.BlockColoredStone : Lnet/minecraft/block/Block;
/*     */     //   404: iconst_4
/*     */     //   405: iconst_3
/*     */     //   406: invokevirtual func_147465_d : (IIILnet/minecraft/block/Block;II)Z
/*     */     //   409: pop
/*     */     //   410: aload_1
/*     */     //   411: bipush #75
/*     */     //   413: sipush #220
/*     */     //   416: bipush #32
/*     */     //   418: getstatic JinRyuu/JRMCore/blocks/BlocksJRMC.BlockColoredStone : Lnet/minecraft/block/Block;
/*     */     //   421: iconst_4
/*     */     //   422: iconst_3
/*     */     //   423: invokevirtual func_147465_d : (IIILnet/minecraft/block/Block;II)Z
/*     */     //   426: pop
/*     */     //   427: aload_1
/*     */     //   428: bipush #75
/*     */     //   430: sipush #221
/*     */     //   433: bipush #32
/*     */     //   435: getstatic JinRyuu/JRMCore/blocks/BlocksJRMC.BlockColoredStone : Lnet/minecraft/block/Block;
/*     */     //   438: iconst_4
/*     */     //   439: iconst_3
/*     */     //   440: invokevirtual func_147465_d : (IIILnet/minecraft/block/Block;II)Z
/*     */     //   443: pop
/*     */     //   444: aload_1
/*     */     //   445: bipush #80
/*     */     //   447: sipush #134
/*     */     //   450: bipush #34
/*     */     //   452: invokevirtual func_147439_a : (III)Lnet/minecraft/block/Block;
/*     */     //   455: getstatic JinRyuu/JRMCore/blocks/BlocksJRMC.BlockFence : Lnet/minecraft/block/Block;
/*     */     //   458: if_acmpeq -> 532
/*     */     //   461: getstatic JinRyuu/DragonBC/common/Worlds/WorldGeneratorDB.KnTrSpawn : Z
/*     */     //   464: ifeq -> 532
/*     */     //   467: iconst_0
/*     */     //   468: putstatic JinRyuu/DragonBC/common/Worlds/WorldGeneratorDB.KnTrSpawn : Z
/*     */     //   471: aload_0
/*     */     //   472: new JinRyuu/DragonBC/common/Villages/KnTr
/*     */     //   475: dup
/*     */     //   476: invokespecial <init> : ()V
/*     */     //   479: putfield KnTr : Lnet/minecraft/world/gen/feature/WorldGenerator;
/*     */     //   482: aload_0
/*     */     //   483: getfield KnTr : Lnet/minecraft/world/gen/feature/WorldGenerator;
/*     */     //   486: aload_1
/*     */     //   487: aload_1
/*     */     //   488: getfield field_73012_v : Ljava/util/Random;
/*     */     //   491: iconst_0
/*     */     //   492: iconst_0
/*     */     //   493: iconst_0
/*     */     //   494: invokevirtual func_76484_a : (Lnet/minecraft/world/World;Ljava/util/Random;III)Z
/*     */     //   497: pop
/*     */     //   498: aload_1
/*     */     //   499: bipush #77
/*     */     //   501: sipush #133
/*     */     //   504: bipush #45
/*     */     //   506: getstatic JinRyuu/JRMCore/blocks/BlocksJRMC.BlockColoredStone : Lnet/minecraft/block/Block;
/*     */     //   509: iconst_0
/*     */     //   510: iconst_3
/*     */     //   511: invokevirtual func_147465_d : (IIILnet/minecraft/block/Block;II)Z
/*     */     //   514: pop
/*     */     //   515: aload_1
/*     */     //   516: bipush #77
/*     */     //   518: sipush #134
/*     */     //   521: bipush #45
/*     */     //   523: getstatic JinRyuu/JRMCore/blocks/BlocksJRMC.BlockColoredStone : Lnet/minecraft/block/Block;
/*     */     //   526: iconst_0
/*     */     //   527: iconst_3
/*     */     //   528: invokevirtual func_147465_d : (IIILnet/minecraft/block/Block;II)Z
/*     */     //   531: pop
/*     */     //   532: aload_1
/*     */     //   533: bipush #77
/*     */     //   535: sipush #219
/*     */     //   538: bipush #8
/*     */     //   540: invokevirtual func_147439_a : (III)Lnet/minecraft/block/Block;
/*     */     //   543: getstatic JinRyuu/DragonBC/common/Blocks/BlocksDBC.BlockTCPort : Lnet/minecraft/block/Block;
/*     */     //   546: if_acmpeq -> 899
/*     */     //   549: getstatic JinRyuu/DragonBC/common/Worlds/WorldGeneratorDB.KiLtTCSpawn : Z
/*     */     //   552: ifeq -> 899
/*     */     //   555: iconst_0
/*     */     //   556: putstatic JinRyuu/DragonBC/common/Worlds/WorldGeneratorDB.KiLtTCSpawn : Z
/*     */     //   559: aload_1
/*     */     //   560: bipush #77
/*     */     //   562: sipush #217
/*     */     //   565: bipush #8
/*     */     //   567: getstatic JinRyuu/DragonBC/common/Blocks/BlocksDBC.BlockTCPort : Lnet/minecraft/block/Block;
/*     */     //   570: iconst_0
/*     */     //   571: iconst_3
/*     */     //   572: invokevirtual func_147465_d : (IIILnet/minecraft/block/Block;II)Z
/*     */     //   575: pop
/*     */     //   576: aload_1
/*     */     //   577: bipush #77
/*     */     //   579: sipush #218
/*     */     //   582: bipush #8
/*     */     //   584: getstatic JinRyuu/DragonBC/common/Blocks/BlocksDBC.BlockTCPort : Lnet/minecraft/block/Block;
/*     */     //   587: iconst_0
/*     */     //   588: iconst_3
/*     */     //   589: invokevirtual func_147465_d : (IIILnet/minecraft/block/Block;II)Z
/*     */     //   592: pop
/*     */     //   593: aload_1
/*     */     //   594: bipush #77
/*     */     //   596: sipush #219
/*     */     //   599: bipush #8
/*     */     //   601: getstatic JinRyuu/DragonBC/common/Blocks/BlocksDBC.BlockTCPort : Lnet/minecraft/block/Block;
/*     */     //   604: iconst_0
/*     */     //   605: iconst_3
/*     */     //   606: invokevirtual func_147465_d : (IIILnet/minecraft/block/Block;II)Z
/*     */     //   609: pop
/*     */     //   610: aload_1
/*     */     //   611: bipush #76
/*     */     //   613: sipush #217
/*     */     //   616: bipush #8
/*     */     //   618: getstatic JinRyuu/DragonBC/common/Blocks/BlocksDBC.BlockTCPort : Lnet/minecraft/block/Block;
/*     */     //   621: iconst_0
/*     */     //   622: iconst_3
/*     */     //   623: invokevirtual func_147465_d : (IIILnet/minecraft/block/Block;II)Z
/*     */     //   626: pop
/*     */     //   627: aload_1
/*     */     //   628: bipush #76
/*     */     //   630: sipush #218
/*     */     //   633: bipush #8
/*     */     //   635: getstatic JinRyuu/DragonBC/common/Blocks/BlocksDBC.BlockTCPort : Lnet/minecraft/block/Block;
/*     */     //   638: iconst_0
/*     */     //   639: iconst_3
/*     */     //   640: invokevirtual func_147465_d : (IIILnet/minecraft/block/Block;II)Z
/*     */     //   643: pop
/*     */     //   644: aload_1
/*     */     //   645: bipush #78
/*     */     //   647: sipush #217
/*     */     //   650: bipush #8
/*     */     //   652: getstatic JinRyuu/DragonBC/common/Blocks/BlocksDBC.BlockTCPort : Lnet/minecraft/block/Block;
/*     */     //   655: iconst_0
/*     */     //   656: iconst_3
/*     */     //   657: invokevirtual func_147465_d : (IIILnet/minecraft/block/Block;II)Z
/*     */     //   660: pop
/*     */     //   661: aload_1
/*     */     //   662: bipush #78
/*     */     //   664: sipush #218
/*     */     //   667: bipush #8
/*     */     //   669: getstatic JinRyuu/DragonBC/common/Blocks/BlocksDBC.BlockTCPort : Lnet/minecraft/block/Block;
/*     */     //   672: iconst_0
/*     */     //   673: iconst_3
/*     */     //   674: invokevirtual func_147465_d : (IIILnet/minecraft/block/Block;II)Z
/*     */     //   677: pop
/*     */     //   678: aload_1
/*     */     //   679: bipush #78
/*     */     //   681: sipush #219
/*     */     //   684: bipush #8
/*     */     //   686: getstatic JinRyuu/DragonBC/common/Blocks/BlocksDBC.BlockTCPort : Lnet/minecraft/block/Block;
/*     */     //   689: iconst_0
/*     */     //   690: iconst_3
/*     */     //   691: invokevirtual func_147465_d : (IIILnet/minecraft/block/Block;II)Z
/*     */     //   694: pop
/*     */     //   695: aload_1
/*     */     //   696: bipush #76
/*     */     //   698: sipush #219
/*     */     //   701: bipush #8
/*     */     //   703: getstatic JinRyuu/DragonBC/common/Blocks/BlocksDBC.BlockTCPort : Lnet/minecraft/block/Block;
/*     */     //   706: iconst_0
/*     */     //   707: iconst_3
/*     */     //   708: invokevirtual func_147465_d : (IIILnet/minecraft/block/Block;II)Z
/*     */     //   711: pop
/*     */     //   712: aload_1
/*     */     //   713: bipush #76
/*     */     //   715: sipush #220
/*     */     //   718: bipush #8
/*     */     //   720: getstatic JinRyuu/JRMCore/blocks/BlocksJRMC.BlockColoredStone : Lnet/minecraft/block/Block;
/*     */     //   723: iconst_0
/*     */     //   724: iconst_3
/*     */     //   725: invokevirtual func_147465_d : (IIILnet/minecraft/block/Block;II)Z
/*     */     //   728: pop
/*     */     //   729: aload_1
/*     */     //   730: bipush #77
/*     */     //   732: sipush #220
/*     */     //   735: bipush #8
/*     */     //   737: getstatic JinRyuu/JRMCore/blocks/BlocksJRMC.BlockColoredStone : Lnet/minecraft/block/Block;
/*     */     //   740: iconst_0
/*     */     //   741: iconst_3
/*     */     //   742: invokevirtual func_147465_d : (IIILnet/minecraft/block/Block;II)Z
/*     */     //   745: pop
/*     */     //   746: aload_1
/*     */     //   747: bipush #78
/*     */     //   749: sipush #220
/*     */     //   752: bipush #8
/*     */     //   754: getstatic JinRyuu/JRMCore/blocks/BlocksJRMC.BlockColoredStone : Lnet/minecraft/block/Block;
/*     */     //   757: iconst_0
/*     */     //   758: iconst_3
/*     */     //   759: invokevirtual func_147465_d : (IIILnet/minecraft/block/Block;II)Z
/*     */     //   762: pop
/*     */     //   763: aload_1
/*     */     //   764: bipush #75
/*     */     //   766: sipush #220
/*     */     //   769: bipush #8
/*     */     //   771: getstatic JinRyuu/JRMCore/blocks/BlocksJRMC.BlockColoredStone : Lnet/minecraft/block/Block;
/*     */     //   774: iconst_0
/*     */     //   775: iconst_3
/*     */     //   776: invokevirtual func_147465_d : (IIILnet/minecraft/block/Block;II)Z
/*     */     //   779: pop
/*     */     //   780: aload_1
/*     */     //   781: bipush #75
/*     */     //   783: sipush #219
/*     */     //   786: bipush #8
/*     */     //   788: getstatic JinRyuu/JRMCore/blocks/BlocksJRMC.BlockColoredStone : Lnet/minecraft/block/Block;
/*     */     //   791: iconst_0
/*     */     //   792: iconst_3
/*     */     //   793: invokevirtual func_147465_d : (IIILnet/minecraft/block/Block;II)Z
/*     */     //   796: pop
/*     */     //   797: aload_1
/*     */     //   798: bipush #75
/*     */     //   800: sipush #218
/*     */     //   803: bipush #8
/*     */     //   805: getstatic JinRyuu/JRMCore/blocks/BlocksJRMC.BlockColoredStone : Lnet/minecraft/block/Block;
/*     */     //   808: iconst_0
/*     */     //   809: iconst_3
/*     */     //   810: invokevirtual func_147465_d : (IIILnet/minecraft/block/Block;II)Z
/*     */     //   813: pop
/*     */     //   814: aload_1
/*     */     //   815: bipush #75
/*     */     //   817: sipush #217
/*     */     //   820: bipush #8
/*     */     //   822: getstatic JinRyuu/JRMCore/blocks/BlocksJRMC.BlockColoredStone : Lnet/minecraft/block/Block;
/*     */     //   825: iconst_0
/*     */     //   826: iconst_3
/*     */     //   827: invokevirtual func_147465_d : (IIILnet/minecraft/block/Block;II)Z
/*     */     //   830: pop
/*     */     //   831: aload_1
/*     */     //   832: bipush #79
/*     */     //   834: sipush #220
/*     */     //   837: bipush #8
/*     */     //   839: getstatic JinRyuu/JRMCore/blocks/BlocksJRMC.BlockColoredStone : Lnet/minecraft/block/Block;
/*     */     //   842: iconst_0
/*     */     //   843: iconst_3
/*     */     //   844: invokevirtual func_147465_d : (IIILnet/minecraft/block/Block;II)Z
/*     */     //   847: pop
/*     */     //   848: aload_1
/*     */     //   849: bipush #79
/*     */     //   851: sipush #219
/*     */     //   854: bipush #8
/*     */     //   856: getstatic JinRyuu/JRMCore/blocks/BlocksJRMC.BlockColoredStone : Lnet/minecraft/block/Block;
/*     */     //   859: iconst_0
/*     */     //   860: iconst_3
/*     */     //   861: invokevirtual func_147465_d : (IIILnet/minecraft/block/Block;II)Z
/*     */     //   864: pop
/*     */     //   865: aload_1
/*     */     //   866: bipush #79
/*     */     //   868: sipush #218
/*     */     //   871: bipush #8
/*     */     //   873: getstatic JinRyuu/JRMCore/blocks/BlocksJRMC.BlockColoredStone : Lnet/minecraft/block/Block;
/*     */     //   876: iconst_0
/*     */     //   877: iconst_3
/*     */     //   878: invokevirtual func_147465_d : (IIILnet/minecraft/block/Block;II)Z
/*     */     //   881: pop
/*     */     //   882: aload_1
/*     */     //   883: bipush #79
/*     */     //   885: sipush #217
/*     */     //   888: bipush #8
/*     */     //   890: getstatic JinRyuu/JRMCore/blocks/BlocksJRMC.BlockColoredStone : Lnet/minecraft/block/Block;
/*     */     //   893: iconst_0
/*     */     //   894: iconst_3
/*     */     //   895: invokevirtual func_147465_d : (IIILnet/minecraft/block/Block;II)Z
/*     */     //   898: pop
/*     */     //   899: getstatic JinRyuu/JRMCore/JRMCoreConfig.NPCSpawnCheck : Z
/*     */     //   902: ifeq -> 1210
/*     */     //   905: ldc2_w 56.0
/*     */     //   908: ldc2_w 10.0
/*     */     //   911: ldc2_w 20.0
/*     */     //   914: ldc2_w 116.0
/*     */     //   917: ldc2_w 240.0
/*     */     //   920: ldc2_w 80.0
/*     */     //   923: invokestatic func_72330_a : (DDDDDD)Lnet/minecraft/util/AxisAlignedBB;
/*     */     //   926: astore #5
/*     */     //   928: aload_1
/*     */     //   929: ldc JinRyuu/DragonBC/common/Npcs/EntityMasterKami
/*     */     //   931: aload #5
/*     */     //   933: invokevirtual func_72872_a : (Ljava/lang/Class;Lnet/minecraft/util/AxisAlignedBB;)Ljava/util/List;
/*     */     //   936: astore #6
/*     */     //   938: aload #6
/*     */     //   940: invokeinterface isEmpty : ()Z
/*     */     //   945: ifeq -> 981
/*     */     //   948: new JinRyuu/DragonBC/common/Npcs/EntityMasterKami
/*     */     //   951: dup
/*     */     //   952: aload_1
/*     */     //   953: invokespecial <init> : (Lnet/minecraft/world/World;)V
/*     */     //   956: astore #7
/*     */     //   958: aload #7
/*     */     //   960: ldc2_w 86.0
/*     */     //   963: ldc2_w 217.0
/*     */     //   966: ldc2_w 50.0
/*     */     //   969: fconst_0
/*     */     //   970: fconst_0
/*     */     //   971: invokevirtual func_70012_b : (DDDFF)V
/*     */     //   974: aload_1
/*     */     //   975: aload #7
/*     */     //   977: invokevirtual func_72838_d : (Lnet/minecraft/entity/Entity;)Z
/*     */     //   980: pop
/*     */     //   981: ldc2_w 85.0
/*     */     //   984: ldc2_w 10.0
/*     */     //   987: ldc2_w 91.0
/*     */     //   990: ldc2_w 89.0
/*     */     //   993: ldc2_w 240.0
/*     */     //   996: ldc2_w 95.0
/*     */     //   999: invokestatic func_72330_a : (DDDDDD)Lnet/minecraft/util/AxisAlignedBB;
/*     */     //   1002: astore #5
/*     */     //   1004: aload_1
/*     */     //   1005: ldc JinRyuu/DragonBC/common/Npcs/EntityMasterPiccolo
/*     */     //   1007: aload #5
/*     */     //   1009: invokevirtual func_72872_a : (Ljava/lang/Class;Lnet/minecraft/util/AxisAlignedBB;)Ljava/util/List;
/*     */     //   1012: astore #6
/*     */     //   1014: aload #6
/*     */     //   1016: invokeinterface isEmpty : ()Z
/*     */     //   1021: ifeq -> 1057
/*     */     //   1024: new JinRyuu/DragonBC/common/Npcs/EntityMasterPiccolo
/*     */     //   1027: dup
/*     */     //   1028: aload_1
/*     */     //   1029: invokespecial <init> : (Lnet/minecraft/world/World;)V
/*     */     //   1032: astore #7
/*     */     //   1034: aload #7
/*     */     //   1036: ldc2_w 87.0
/*     */     //   1039: ldc2_w 217.0
/*     */     //   1042: ldc2_w 93.0
/*     */     //   1045: fconst_0
/*     */     //   1046: fconst_0
/*     */     //   1047: invokevirtual func_70012_b : (DDDFF)V
/*     */     //   1050: aload_1
/*     */     //   1051: aload #7
/*     */     //   1053: invokevirtual func_72838_d : (Lnet/minecraft/entity/Entity;)Z
/*     */     //   1056: pop
/*     */     //   1057: ldc2_w 71.0
/*     */     //   1060: ldc2_w 10.0
/*     */     //   1063: ldc2_w 8.0
/*     */     //   1066: ldc2_w 75.0
/*     */     //   1069: ldc2_w 240.0
/*     */     //   1072: ldc2_w 12.0
/*     */     //   1075: invokestatic func_72330_a : (DDDDDD)Lnet/minecraft/util/AxisAlignedBB;
/*     */     //   1078: astore #5
/*     */     //   1080: aload_1
/*     */     //   1081: ldc JinRyuu/DragonBC/common/Npcs/EntityMasterVegeta
/*     */     //   1083: aload #5
/*     */     //   1085: invokevirtual func_72872_a : (Ljava/lang/Class;Lnet/minecraft/util/AxisAlignedBB;)Ljava/util/List;
/*     */     //   1088: astore #6
/*     */     //   1090: aload #6
/*     */     //   1092: invokeinterface isEmpty : ()Z
/*     */     //   1097: ifeq -> 1133
/*     */     //   1100: new JinRyuu/DragonBC/common/Npcs/EntityMasterVegeta
/*     */     //   1103: dup
/*     */     //   1104: aload_1
/*     */     //   1105: invokespecial <init> : (Lnet/minecraft/world/World;)V
/*     */     //   1108: astore #7
/*     */     //   1110: aload #7
/*     */     //   1112: ldc2_w 73.0
/*     */     //   1115: ldc2_w 217.0
/*     */     //   1118: ldc2_w 10.0
/*     */     //   1121: fconst_0
/*     */     //   1122: fconst_0
/*     */     //   1123: invokevirtual func_70012_b : (DDDFF)V
/*     */     //   1126: aload_1
/*     */     //   1127: aload #7
/*     */     //   1129: invokevirtual func_72838_d : (Lnet/minecraft/entity/Entity;)Z
/*     */     //   1132: pop
/*     */     //   1133: ldc2_w 70.0
/*     */     //   1136: ldc2_w 120.0
/*     */     //   1139: ldc2_w 30.0
/*     */     //   1142: ldc2_w 90.0
/*     */     //   1145: ldc2_w 140.0
/*     */     //   1148: ldc2_w 50.0
/*     */     //   1151: invokestatic func_72330_a : (DDDDDD)Lnet/minecraft/util/AxisAlignedBB;
/*     */     //   1154: astore #7
/*     */     //   1156: aload_1
/*     */     //   1157: ldc_w JinRyuu/DragonBC/common/Npcs/EntityMasterKarin
/*     */     //   1160: aload #7
/*     */     //   1162: invokevirtual func_72872_a : (Ljava/lang/Class;Lnet/minecraft/util/AxisAlignedBB;)Ljava/util/List;
/*     */     //   1165: astore #8
/*     */     //   1167: aload #8
/*     */     //   1169: invokeinterface isEmpty : ()Z
/*     */     //   1174: ifeq -> 1210
/*     */     //   1177: new JinRyuu/DragonBC/common/Npcs/EntityMasterKarin
/*     */     //   1180: dup
/*     */     //   1181: aload_1
/*     */     //   1182: invokespecial <init> : (Lnet/minecraft/world/World;)V
/*     */     //   1185: astore #9
/*     */     //   1187: aload #9
/*     */     //   1189: ldc2_w 80.0
/*     */     //   1192: ldc2_w 133.0
/*     */     //   1195: ldc2_w 40.0
/*     */     //   1198: fconst_0
/*     */     //   1199: fconst_0
/*     */     //   1200: invokevirtual func_70012_b : (DDDFF)V
/*     */     //   1203: aload_1
/*     */     //   1204: aload #9
/*     */     //   1206: invokevirtual func_72838_d : (Lnet/minecraft/entity/Entity;)Z
/*     */     //   1209: pop
/*     */     //   1210: iload_3
/*     */     //   1211: aload_2
/*     */     //   1212: bipush #16
/*     */     //   1214: invokevirtual nextInt : (I)I
/*     */     //   1217: iadd
/*     */     //   1218: istore #5
/*     */     //   1220: iload #4
/*     */     //   1222: aload_2
/*     */     //   1223: bipush #16
/*     */     //   1225: invokevirtual nextInt : (I)I
/*     */     //   1228: iadd
/*     */     //   1229: istore #6
/*     */     //   1231: bipush #62
/*     */     //   1233: istore #7
/*     */     //   1235: aload_1
/*     */     //   1236: iload #5
/*     */     //   1238: iload #6
/*     */     //   1240: invokevirtual func_72807_a : (II)Lnet/minecraft/world/biome/BiomeGenBase;
/*     */     //   1243: getstatic net/minecraft/world/biome/BiomeGenBase.field_76771_b : Lnet/minecraft/world/biome/BiomeGenBase;
/*     */     //   1246: if_acmpeq -> 1273
/*     */     //   1249: aload_1
/*     */     //   1250: iload #5
/*     */     //   1252: iload #6
/*     */     //   1254: invokevirtual func_72807_a : (II)Lnet/minecraft/world/biome/BiomeGenBase;
/*     */     //   1257: getstatic net/minecraft/world/biome/BiomeGenBase.field_150575_M : Lnet/minecraft/world/biome/BiomeGenBase;
/*     */     //   1260: if_acmpeq -> 1273
/*     */     //   1263: getstatic JinRyuu/DragonBC/common/DBCH.genKH : Ljava/lang/String;
/*     */     //   1266: invokevirtual length : ()I
/*     */     //   1269: iconst_3
/*     */     //   1270: if_icmpge -> 1976
/*     */     //   1273: iconst_1
/*     */     //   1274: istore #8
/*     */     //   1276: getstatic JinRyuu/DragonBC/common/Worlds/WorldGeneratorDB.KHSpawn : Z
/*     */     //   1279: ifeq -> 1976
/*     */     //   1282: aload_1
/*     */     //   1283: iload #5
/*     */     //   1285: iload #7
/*     */     //   1287: iload #6
/*     */     //   1289: invokevirtual func_147439_a : (III)Lnet/minecraft/block/Block;
/*     */     //   1292: getstatic net/minecraft/init/Blocks.field_150355_j : Lnet/minecraft/block/Block;
/*     */     //   1295: if_acmpne -> 1976
/*     */     //   1298: aload_1
/*     */     //   1299: iload #5
/*     */     //   1301: iload #7
/*     */     //   1303: iconst_1
/*     */     //   1304: iadd
/*     */     //   1305: iload #6
/*     */     //   1307: invokevirtual func_147439_a : (III)Lnet/minecraft/block/Block;
/*     */     //   1310: invokevirtual func_149688_o : ()Lnet/minecraft/block/material/Material;
/*     */     //   1313: getstatic net/minecraft/block/material/Material.field_151579_a : Lnet/minecraft/block/material/Material;
/*     */     //   1316: if_acmpne -> 1976
/*     */     //   1319: bipush #62
/*     */     //   1321: istore #9
/*     */     //   1323: iload #7
/*     */     //   1325: istore #10
/*     */     //   1327: iload #10
/*     */     //   1329: bipush #35
/*     */     //   1331: if_icmple -> 1377
/*     */     //   1334: iload #10
/*     */     //   1336: istore #11
/*     */     //   1338: iload #11
/*     */     //   1340: iload #9
/*     */     //   1342: if_icmpge -> 1349
/*     */     //   1345: iload #11
/*     */     //   1347: istore #9
/*     */     //   1349: aload_1
/*     */     //   1350: iload #5
/*     */     //   1352: iload #10
/*     */     //   1354: iload #6
/*     */     //   1356: invokevirtual func_147439_a : (III)Lnet/minecraft/block/Block;
/*     */     //   1359: getstatic net/minecraft/init/Blocks.field_150355_j : Lnet/minecraft/block/Block;
/*     */     //   1362: if_acmpeq -> 1371
/*     */     //   1365: iconst_0
/*     */     //   1366: istore #8
/*     */     //   1368: goto -> 1377
/*     */     //   1371: iinc #10, -1
/*     */     //   1374: goto -> 1327
/*     */     //   1377: iload #8
/*     */     //   1379: ifeq -> 1976
/*     */     //   1382: getstatic JinRyuu/JRMCore/JRMCoreConfig.buildingSpawnAreaSize : I
/*     */     //   1385: istore #10
/*     */     //   1387: bipush #30
/*     */     //   1389: istore #11
/*     */     //   1391: iload #5
/*     */     //   1393: i2d
/*     */     //   1394: iload #10
/*     */     //   1396: i2d
/*     */     //   1397: dsub
/*     */     //   1398: ldc2_w 64.0
/*     */     //   1401: iload #6
/*     */     //   1403: i2d
/*     */     //   1404: iload #10
/*     */     //   1406: i2d
/*     */     //   1407: dsub
/*     */     //   1408: iload #5
/*     */     //   1410: i2d
/*     */     //   1411: iload #10
/*     */     //   1413: i2d
/*     */     //   1414: dadd
/*     */     //   1415: bipush #63
/*     */     //   1417: iload #10
/*     */     //   1419: iadd
/*     */     //   1420: sipush #200
/*     */     //   1423: if_icmple -> 1432
/*     */     //   1426: sipush #200
/*     */     //   1429: goto -> 1437
/*     */     //   1432: bipush #63
/*     */     //   1434: iload #10
/*     */     //   1436: iadd
/*     */     //   1437: i2d
/*     */     //   1438: iload #6
/*     */     //   1440: i2d
/*     */     //   1441: iload #10
/*     */     //   1443: i2d
/*     */     //   1444: dadd
/*     */     //   1445: invokestatic func_72330_a : (DDDDDD)Lnet/minecraft/util/AxisAlignedBB;
/*     */     //   1448: astore #12
/*     */     //   1450: aload_1
/*     */     //   1451: aload #12
/*     */     //   1453: invokevirtual func_147461_a : (Lnet/minecraft/util/AxisAlignedBB;)Ljava/util/List;
/*     */     //   1456: astore #13
/*     */     //   1458: iconst_1
/*     */     //   1459: istore #14
/*     */     //   1461: iconst_0
/*     */     //   1462: istore #15
/*     */     //   1464: iload #15
/*     */     //   1466: bipush #8
/*     */     //   1468: if_icmpge -> 1707
/*     */     //   1471: iload #14
/*     */     //   1473: ifeq -> 1707
/*     */     //   1476: aload_1
/*     */     //   1477: iload #5
/*     */     //   1479: iload #15
/*     */     //   1481: ifeq -> 1497
/*     */     //   1484: iload #15
/*     */     //   1486: iconst_2
/*     */     //   1487: if_icmpeq -> 1497
/*     */     //   1490: iload #15
/*     */     //   1492: bipush #6
/*     */     //   1494: if_icmpne -> 1504
/*     */     //   1497: iload #10
/*     */     //   1499: iconst_2
/*     */     //   1500: imul
/*     */     //   1501: goto -> 1525
/*     */     //   1504: iload #15
/*     */     //   1506: iconst_4
/*     */     //   1507: if_icmpeq -> 1516
/*     */     //   1510: iload #15
/*     */     //   1512: iconst_5
/*     */     //   1513: if_icmpne -> 1520
/*     */     //   1516: iconst_0
/*     */     //   1517: goto -> 1525
/*     */     //   1520: iload #10
/*     */     //   1522: ineg
/*     */     //   1523: iconst_2
/*     */     //   1524: imul
/*     */     //   1525: iadd
/*     */     //   1526: iload #6
/*     */     //   1528: iload #15
/*     */     //   1530: ifeq -> 1545
/*     */     //   1533: iload #15
/*     */     //   1535: iconst_1
/*     */     //   1536: if_icmpeq -> 1545
/*     */     //   1539: iload #15
/*     */     //   1541: iconst_5
/*     */     //   1542: if_icmpne -> 1552
/*     */     //   1545: iload #10
/*     */     //   1547: iconst_2
/*     */     //   1548: imul
/*     */     //   1549: goto -> 1575
/*     */     //   1552: iload #15
/*     */     //   1554: bipush #6
/*     */     //   1556: if_icmpeq -> 1566
/*     */     //   1559: iload #15
/*     */     //   1561: bipush #7
/*     */     //   1563: if_icmpne -> 1570
/*     */     //   1566: iconst_0
/*     */     //   1567: goto -> 1575
/*     */     //   1570: iload #10
/*     */     //   1572: ineg
/*     */     //   1573: iconst_2
/*     */     //   1574: imul
/*     */     //   1575: iadd
/*     */     //   1576: invokevirtual func_72807_a : (II)Lnet/minecraft/world/biome/BiomeGenBase;
/*     */     //   1579: getstatic net/minecraft/world/biome/BiomeGenBase.field_76771_b : Lnet/minecraft/world/biome/BiomeGenBase;
/*     */     //   1582: if_acmpeq -> 1694
/*     */     //   1585: aload_1
/*     */     //   1586: iload #5
/*     */     //   1588: iload #15
/*     */     //   1590: ifeq -> 1606
/*     */     //   1593: iload #15
/*     */     //   1595: iconst_2
/*     */     //   1596: if_icmpeq -> 1606
/*     */     //   1599: iload #15
/*     */     //   1601: bipush #6
/*     */     //   1603: if_icmpne -> 1613
/*     */     //   1606: iload #10
/*     */     //   1608: iconst_2
/*     */     //   1609: imul
/*     */     //   1610: goto -> 1634
/*     */     //   1613: iload #15
/*     */     //   1615: iconst_4
/*     */     //   1616: if_icmpeq -> 1625
/*     */     //   1619: iload #15
/*     */     //   1621: iconst_5
/*     */     //   1622: if_icmpne -> 1629
/*     */     //   1625: iconst_0
/*     */     //   1626: goto -> 1634
/*     */     //   1629: iload #10
/*     */     //   1631: ineg
/*     */     //   1632: iconst_2
/*     */     //   1633: imul
/*     */     //   1634: iadd
/*     */     //   1635: iload #6
/*     */     //   1637: iload #15
/*     */     //   1639: ifeq -> 1654
/*     */     //   1642: iload #15
/*     */     //   1644: iconst_1
/*     */     //   1645: if_icmpeq -> 1654
/*     */     //   1648: iload #15
/*     */     //   1650: iconst_5
/*     */     //   1651: if_icmpne -> 1661
/*     */     //   1654: iload #10
/*     */     //   1656: iconst_2
/*     */     //   1657: imul
/*     */     //   1658: goto -> 1684
/*     */     //   1661: iload #15
/*     */     //   1663: bipush #6
/*     */     //   1665: if_icmpeq -> 1675
/*     */     //   1668: iload #15
/*     */     //   1670: bipush #7
/*     */     //   1672: if_icmpne -> 1679
/*     */     //   1675: iconst_0
/*     */     //   1676: goto -> 1684
/*     */     //   1679: iload #10
/*     */     //   1681: ineg
/*     */     //   1682: iconst_2
/*     */     //   1683: imul
/*     */     //   1684: iadd
/*     */     //   1685: invokevirtual func_72807_a : (II)Lnet/minecraft/world/biome/BiomeGenBase;
/*     */     //   1688: getstatic net/minecraft/world/biome/BiomeGenBase.field_150575_M : Lnet/minecraft/world/biome/BiomeGenBase;
/*     */     //   1691: if_acmpne -> 1698
/*     */     //   1694: iconst_1
/*     */     //   1695: goto -> 1699
/*     */     //   1698: iconst_0
/*     */     //   1699: istore #14
/*     */     //   1701: iinc #15, 1
/*     */     //   1704: goto -> 1464
/*     */     //   1707: aload #13
/*     */     //   1709: invokeinterface size : ()I
/*     */     //   1714: ifne -> 1976
/*     */     //   1717: iload #14
/*     */     //   1719: ifeq -> 1976
/*     */     //   1722: invokestatic instance : ()Lcpw/mods/fml/common/FMLCommonHandler;
/*     */     //   1725: invokevirtual getMinecraftServerInstance : ()Lnet/minecraft/server/MinecraftServer;
/*     */     //   1728: invokestatic khrwi : (Lnet/minecraft/server/MinecraftServer;)Ljava/lang/String;
/*     */     //   1731: invokevirtual length : ()I
/*     */     //   1734: iconst_3
/*     */     //   1735: if_icmpge -> 1976
/*     */     //   1738: iconst_0
/*     */     //   1739: putstatic JinRyuu/DragonBC/common/Worlds/WorldGeneratorDB.KHSpawn : Z
/*     */     //   1742: new java/lang/StringBuilder
/*     */     //   1745: dup
/*     */     //   1746: invokespecial <init> : ()V
/*     */     //   1749: iload #5
/*     */     //   1751: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   1754: ldc_w ';'
/*     */     //   1757: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1760: iload #7
/*     */     //   1762: iconst_1
/*     */     //   1763: iadd
/*     */     //   1764: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   1767: ldc_w ';'
/*     */     //   1770: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1773: iload #6
/*     */     //   1775: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   1778: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1781: astore #15
/*     */     //   1783: invokestatic instance : ()Lcpw/mods/fml/common/FMLCommonHandler;
/*     */     //   1786: invokevirtual getMinecraftServerInstance : ()Lnet/minecraft/server/MinecraftServer;
/*     */     //   1789: astore #16
/*     */     //   1791: aload #16
/*     */     //   1793: aload #15
/*     */     //   1795: iconst_0
/*     */     //   1796: invokestatic khwwi : (Lnet/minecraft/server/MinecraftServer;Ljava/lang/String;Z)V
/*     */     //   1799: aload #15
/*     */     //   1801: putstatic JinRyuu/DragonBC/common/DBCH.genKH : Ljava/lang/String;
/*     */     //   1804: new JinRyuu/DragonBC/common/Villages/kh
/*     */     //   1807: dup
/*     */     //   1808: invokespecial <init> : ()V
/*     */     //   1811: astore #17
/*     */     //   1813: aload #17
/*     */     //   1815: aload_1
/*     */     //   1816: aload_2
/*     */     //   1817: iload #5
/*     */     //   1819: iload #11
/*     */     //   1821: isub
/*     */     //   1822: iload #7
/*     */     //   1824: iconst_3
/*     */     //   1825: isub
/*     */     //   1826: iload #6
/*     */     //   1828: iload #11
/*     */     //   1830: isub
/*     */     //   1831: invokevirtual func_76484_a : (Lnet/minecraft/world/World;Ljava/util/Random;III)Z
/*     */     //   1834: pop
/*     */     //   1835: aload #16
/*     */     //   1837: invokevirtual func_71233_x : ()I
/*     */     //   1840: istore #18
/*     */     //   1842: iconst_0
/*     */     //   1843: istore #19
/*     */     //   1845: iload #19
/*     */     //   1847: iload #18
/*     */     //   1849: if_icmpge -> 1976
/*     */     //   1852: aload #16
/*     */     //   1854: aload #16
/*     */     //   1856: invokevirtual func_71213_z : ()[Ljava/lang/String;
/*     */     //   1859: iload #19
/*     */     //   1861: aaload
/*     */     //   1862: invokestatic getPlayerForUsername : (Lnet/minecraft/server/MinecraftServer;Ljava/lang/String;)Lnet/minecraft/entity/player/EntityPlayerMP;
/*     */     //   1865: astore #20
/*     */     //   1867: new java/lang/StringBuilder
/*     */     //   1870: dup
/*     */     //   1871: invokespecial <init> : ()V
/*     */     //   1874: getstatic JinRyuu/JRMCore/JRMCoreH.cly : Ljava/lang/String;
/*     */     //   1877: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1880: ldc_w 'dbc.worldgen.buildings.beenfound'
/*     */     //   1883: invokestatic trl : (Ljava/lang/String;)Ljava/lang/String;
/*     */     //   1886: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1889: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1892: astore #21
/*     */     //   1894: new java/lang/StringBuilder
/*     */     //   1897: dup
/*     */     //   1898: invokespecial <init> : ()V
/*     */     //   1901: getstatic JinRyuu/JRMCore/JRMCoreH.cly : Ljava/lang/String;
/*     */     //   1904: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1907: ldc_w 'dbc.com.loc.kame'
/*     */     //   1910: invokestatic trl : (Ljava/lang/String;)Ljava/lang/String;
/*     */     //   1913: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1916: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1919: astore #22
/*     */     //   1921: aload #21
/*     */     //   1923: iconst_1
/*     */     //   1924: anewarray java/lang/Object
/*     */     //   1927: dup
/*     */     //   1928: iconst_0
/*     */     //   1929: aload #22
/*     */     //   1931: aastore
/*     */     //   1932: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   1935: astore #23
/*     */     //   1937: aload #20
/*     */     //   1939: new net/minecraft/util/ChatComponentText
/*     */     //   1942: dup
/*     */     //   1943: new java/lang/StringBuilder
/*     */     //   1946: dup
/*     */     //   1947: invokespecial <init> : ()V
/*     */     //   1950: getstatic JinRyuu/JRMCore/JRMCoreH.cly : Ljava/lang/String;
/*     */     //   1953: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1956: aload #23
/*     */     //   1958: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1961: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1964: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   1967: invokevirtual func_145747_a : (Lnet/minecraft/util/IChatComponent;)V
/*     */     //   1970: iinc #19, 1
/*     */     //   1973: goto -> 1845
/*     */     //   1976: aload_2
/*     */     //   1977: bipush #15
/*     */     //   1979: invokevirtual nextInt : (I)I
/*     */     //   1982: istore #11
/*     */     //   1984: iconst_1
/*     */     //   1985: istore #10
/*     */     //   1987: aload_0
/*     */     //   1988: iload #10
/*     */     //   1990: invokevirtual DBbuildsSpawn : (I)Z
/*     */     //   1993: ifeq -> 2040
/*     */     //   1996: iload #11
/*     */     //   1998: ifne -> 2040
/*     */     //   2001: iload_3
/*     */     //   2002: aload_2
/*     */     //   2003: bipush #16
/*     */     //   2005: invokevirtual nextInt : (I)I
/*     */     //   2008: iadd
/*     */     //   2009: istore #8
/*     */     //   2011: iload #4
/*     */     //   2013: aload_2
/*     */     //   2014: bipush #16
/*     */     //   2016: invokevirtual nextInt : (I)I
/*     */     //   2019: iadd
/*     */     //   2020: istore #9
/*     */     //   2022: aload_0
/*     */     //   2023: aload_1
/*     */     //   2024: aload_2
/*     */     //   2025: iload #8
/*     */     //   2027: iload #9
/*     */     //   2029: iload #10
/*     */     //   2031: getstatic net/minecraft/world/biome/BiomeGenBase.field_76772_c : Lnet/minecraft/world/biome/BiomeGenBase;
/*     */     //   2034: getstatic JinRyuu/DragonBC/common/Worlds/WorldGeneratorDB$Type.NORMAL : LJinRyuu/DragonBC/common/Worlds/WorldGeneratorDB$Type;
/*     */     //   2037: invokevirtual buildingSpawn : (Lnet/minecraft/world/World;Ljava/util/Random;IIILnet/minecraft/world/biome/BiomeGenBase;LJinRyuu/DragonBC/common/Worlds/WorldGeneratorDB$Type;)V
/*     */     //   2040: iconst_0
/*     */     //   2041: istore #10
/*     */     //   2043: aload_0
/*     */     //   2044: iload #10
/*     */     //   2046: invokevirtual DBbuildsSpawn : (I)Z
/*     */     //   2049: ifeq -> 2097
/*     */     //   2052: iload #11
/*     */     //   2054: iconst_1
/*     */     //   2055: if_icmpne -> 2097
/*     */     //   2058: iload_3
/*     */     //   2059: aload_2
/*     */     //   2060: bipush #16
/*     */     //   2062: invokevirtual nextInt : (I)I
/*     */     //   2065: iadd
/*     */     //   2066: istore #8
/*     */     //   2068: iload #4
/*     */     //   2070: aload_2
/*     */     //   2071: bipush #16
/*     */     //   2073: invokevirtual nextInt : (I)I
/*     */     //   2076: iadd
/*     */     //   2077: istore #9
/*     */     //   2079: aload_0
/*     */     //   2080: aload_1
/*     */     //   2081: aload_2
/*     */     //   2082: iload #8
/*     */     //   2084: iload #9
/*     */     //   2086: iload #10
/*     */     //   2088: getstatic net/minecraft/world/biome/BiomeGenBase.field_76772_c : Lnet/minecraft/world/biome/BiomeGenBase;
/*     */     //   2091: getstatic JinRyuu/DragonBC/common/Worlds/WorldGeneratorDB$Type.NORMAL : LJinRyuu/DragonBC/common/Worlds/WorldGeneratorDB$Type;
/*     */     //   2094: invokevirtual buildingSpawn : (Lnet/minecraft/world/World;Ljava/util/Random;IIILnet/minecraft/world/biome/BiomeGenBase;LJinRyuu/DragonBC/common/Worlds/WorldGeneratorDB$Type;)V
/*     */     //   2097: iconst_3
/*     */     //   2098: istore #10
/*     */     //   2100: aload_0
/*     */     //   2101: iload #10
/*     */     //   2103: invokevirtual DBbuildsSpawn : (I)Z
/*     */     //   2106: ifeq -> 2154
/*     */     //   2109: iload #11
/*     */     //   2111: iconst_3
/*     */     //   2112: if_icmpne -> 2154
/*     */     //   2115: iload_3
/*     */     //   2116: aload_2
/*     */     //   2117: bipush #16
/*     */     //   2119: invokevirtual nextInt : (I)I
/*     */     //   2122: iadd
/*     */     //   2123: istore #8
/*     */     //   2125: iload #4
/*     */     //   2127: aload_2
/*     */     //   2128: bipush #16
/*     */     //   2130: invokevirtual nextInt : (I)I
/*     */     //   2133: iadd
/*     */     //   2134: istore #9
/*     */     //   2136: aload_0
/*     */     //   2137: aload_1
/*     */     //   2138: aload_2
/*     */     //   2139: iload #8
/*     */     //   2141: iload #9
/*     */     //   2143: iload #10
/*     */     //   2145: getstatic net/minecraft/world/biome/BiomeGenBase.field_76772_c : Lnet/minecraft/world/biome/BiomeGenBase;
/*     */     //   2148: getstatic JinRyuu/DragonBC/common/Worlds/WorldGeneratorDB$Type.UNDER : LJinRyuu/DragonBC/common/Worlds/WorldGeneratorDB$Type;
/*     */     //   2151: invokevirtual buildingSpawn : (Lnet/minecraft/world/World;Ljava/util/Random;IIILnet/minecraft/world/biome/BiomeGenBase;LJinRyuu/DragonBC/common/Worlds/WorldGeneratorDB$Type;)V
/*     */     //   2154: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #106	-> 0
/*     */     //   #107	-> 10
/*     */     //   #108	-> 20
/*     */     //   #109	-> 30
/*     */     //   #110	-> 41
/*     */     //   #111	-> 52
/*     */     //   #107	-> 76
/*     */     //   #113	-> 82
/*     */     //   #114	-> 88
/*     */     //   #115	-> 115
/*     */     //   #116	-> 126
/*     */     //   #117	-> 142
/*     */     //   #118	-> 159
/*     */     //   #119	-> 176
/*     */     //   #120	-> 191
/*     */     //   #121	-> 206
/*     */     //   #122	-> 223
/*     */     //   #123	-> 240
/*     */     //   #124	-> 257
/*     */     //   #125	-> 274
/*     */     //   #126	-> 291
/*     */     //   #127	-> 308
/*     */     //   #128	-> 325
/*     */     //   #129	-> 342
/*     */     //   #130	-> 359
/*     */     //   #131	-> 376
/*     */     //   #132	-> 393
/*     */     //   #133	-> 410
/*     */     //   #134	-> 427
/*     */     //   #135	-> 444
/*     */     //   #136	-> 471
/*     */     //   #137	-> 482
/*     */     //   #138	-> 498
/*     */     //   #139	-> 515
/*     */     //   #141	-> 532
/*     */     //   #142	-> 559
/*     */     //   #143	-> 576
/*     */     //   #144	-> 593
/*     */     //   #145	-> 610
/*     */     //   #146	-> 627
/*     */     //   #147	-> 644
/*     */     //   #148	-> 661
/*     */     //   #149	-> 678
/*     */     //   #150	-> 695
/*     */     //   #151	-> 712
/*     */     //   #152	-> 729
/*     */     //   #153	-> 746
/*     */     //   #154	-> 763
/*     */     //   #155	-> 780
/*     */     //   #156	-> 797
/*     */     //   #157	-> 814
/*     */     //   #158	-> 831
/*     */     //   #159	-> 848
/*     */     //   #160	-> 865
/*     */     //   #161	-> 882
/*     */     //   #165	-> 899
/*     */     //   #166	-> 905
/*     */     //   #167	-> 928
/*     */     //   #168	-> 938
/*     */     //   #169	-> 948
/*     */     //   #171	-> 958
/*     */     //   #172	-> 974
/*     */     //   #174	-> 981
/*     */     //   #175	-> 1004
/*     */     //   #176	-> 1014
/*     */     //   #177	-> 1024
/*     */     //   #179	-> 1034
/*     */     //   #180	-> 1050
/*     */     //   #183	-> 1057
/*     */     //   #184	-> 1080
/*     */     //   #185	-> 1090
/*     */     //   #186	-> 1100
/*     */     //   #188	-> 1110
/*     */     //   #189	-> 1126
/*     */     //   #201	-> 1133
/*     */     //   #202	-> 1156
/*     */     //   #203	-> 1167
/*     */     //   #204	-> 1177
/*     */     //   #206	-> 1187
/*     */     //   #207	-> 1203
/*     */     //   #216	-> 1210
/*     */     //   #217	-> 1220
/*     */     //   #218	-> 1231
/*     */     //   #220	-> 1235
/*     */     //   #221	-> 1273
/*     */     //   #222	-> 1276
/*     */     //   #223	-> 1289
/*     */     //   #224	-> 1307
/*     */     //   #227	-> 1319
/*     */     //   #228	-> 1323
/*     */     //   #230	-> 1334
/*     */     //   #231	-> 1338
/*     */     //   #232	-> 1345
/*     */     //   #235	-> 1349
/*     */     //   #228	-> 1371
/*     */     //   #237	-> 1377
/*     */     //   #238	-> 1382
/*     */     //   #239	-> 1387
/*     */     //   #240	-> 1391
/*     */     //   #241	-> 1450
/*     */     //   #242	-> 1458
/*     */     //   #243	-> 1461
/*     */     //   #244	-> 1471
/*     */     //   #245	-> 1476
/*     */     //   #246	-> 1685
/*     */     //   #243	-> 1701
/*     */     //   #251	-> 1707
/*     */     //   #252	-> 1738
/*     */     //   #253	-> 1742
/*     */     //   #254	-> 1783
/*     */     //   #255	-> 1791
/*     */     //   #256	-> 1799
/*     */     //   #258	-> 1804
/*     */     //   #259	-> 1813
/*     */     //   #260	-> 1835
/*     */     //   #261	-> 1842
/*     */     //   #262	-> 1852
/*     */     //   #263	-> 1867
/*     */     //   #264	-> 1894
/*     */     //   #265	-> 1921
/*     */     //   #266	-> 1937
/*     */     //   #261	-> 1970
/*     */     //   #402	-> 1976
/*     */     //   #403	-> 1984
/*     */     //   #404	-> 1987
/*     */     //   #406	-> 2001
/*     */     //   #407	-> 2011
/*     */     //   #408	-> 2022
/*     */     //   #410	-> 2040
/*     */     //   #411	-> 2043
/*     */     //   #413	-> 2058
/*     */     //   #414	-> 2068
/*     */     //   #415	-> 2079
/*     */     //   #417	-> 2097
/*     */     //   #418	-> 2100
/*     */     //   #420	-> 2115
/*     */     //   #421	-> 2125
/*     */     //   #422	-> 2136
/*     */     //   #432	-> 2154
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   30	46	6	RPX	I
/*     */     //   41	35	7	RPZ	I
/*     */     //   52	24	8	RPY	I
/*     */     //   13	69	5	i	I
/*     */     //   958	23	7	namekian03	LJinRyuu/DragonBC/common/Npcs/EntityMasterKami;
/*     */     //   1034	23	7	namekian03	LJinRyuu/DragonBC/common/Npcs/EntityMasterPiccolo;
/*     */     //   1110	23	7	namekian03	LJinRyuu/DragonBC/common/Npcs/EntityMasterVegeta;
/*     */     //   1187	23	9	k	LJinRyuu/DragonBC/common/Npcs/EntityMasterKarin;
/*     */     //   928	282	5	par2AxisAlignedBB	Lnet/minecraft/util/AxisAlignedBB;
/*     */     //   938	272	6	enma	Ljava/util/List;
/*     */     //   1156	54	7	knaabb	Lnet/minecraft/util/AxisAlignedBB;
/*     */     //   1167	43	8	kn	Ljava/util/List;
/*     */     //   1338	33	11	depth	I
/*     */     //   1327	50	10	i1	I
/*     */     //   1464	243	15	i1	I
/*     */     //   1867	103	20	p	Lnet/minecraft/entity/player/EntityPlayerMP;
/*     */     //   1894	76	21	t1	Ljava/lang/String;
/*     */     //   1921	49	22	t2	Ljava/lang/String;
/*     */     //   1937	33	23	tf	Ljava/lang/String;
/*     */     //   1845	131	19	pl	I
/*     */     //   1783	193	15	d	Ljava/lang/String;
/*     */     //   1791	185	16	server	Lnet/minecraft/server/MinecraftServer;
/*     */     //   1813	163	17	kh	Lnet/minecraft/world/gen/feature/WorldGenerator;
/*     */     //   1842	134	18	cur	I
/*     */     //   1387	589	10	s	I
/*     */     //   1391	585	11	s2	I
/*     */     //   1450	526	12	ab	Lnet/minecraft/util/AxisAlignedBB;
/*     */     //   1458	518	13	list	Ljava/util/List;
/*     */     //   1461	515	14	bo	Z
/*     */     //   1323	653	9	testWaterDepth	I
/*     */     //   1276	700	8	may	Z
/*     */     //   2011	29	8	i	I
/*     */     //   2022	18	9	k	I
/*     */     //   2068	29	8	i	I
/*     */     //   2079	18	9	k	I
/*     */     //   2125	29	8	i	I
/*     */     //   2136	18	9	k	I
/*     */     //   0	2155	0	this	LJinRyuu/DragonBC/common/Worlds/WorldGeneratorDB;
/*     */     //   0	2155	1	world	Lnet/minecraft/world/World;
/*     */     //   0	2155	2	random	Ljava/util/Random;
/*     */     //   0	2155	3	BlockX	I
/*     */     //   0	2155	4	BlockZ	I
/*     */     //   1220	935	5	RPX	I
/*     */     //   1231	924	6	RPZ	I
/*     */     //   1235	920	7	RPY	I
/*     */     //   1987	168	10	buildingID	I
/*     */     //   1984	171	11	num	I
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
/* 435 */   public static builds[] DBbuilds = new builds[] { (builds)new ca(), (builds)new gh(), (builds)new fs(), (builds)new bs(), (builds)new StructureGuru() };
/*     */   
/* 437 */   public static int[] DBbuildsdim = new int[] { 0, 0, DBCConfig.planetNamek, 0, DBCConfig.planetNamek };
/*     */   public static String DBbuildsNams(int i) {
/* 439 */     if (i == 0) return DBCH.ca; 
/* 440 */     if (i == 1) return DBCH.gh; 
/* 441 */     if (i == 2) return DBCH.fs; 
/* 442 */     if (i == 3) return DBCH.bs; 
/* 443 */     if (i == 4) return DBCH.guruh; 
/* 444 */     return "";
/*     */   }
/*     */   public static String DBbuildsNams2(int i) {
/* 447 */     if (i == 0) return "dbc.com.loc.cell"; 
/* 448 */     if (i == 1) return "dbc.com.loc.goku"; 
/* 449 */     if (i == 2) return "dbc.com.loc.freeza"; 
/* 450 */     if (i == 3) return "dbc.com.loc.babidi"; 
/* 451 */     if (i == 4) return "dbc.com.loc.guruhouse"; 
/* 452 */     return "";
/*     */   }
/*     */   public static String DBbuildsGen(int i) {
/* 455 */     if (i == 0) { DBCH.genCA = DBCH.carwi(FMLCommonHandler.instance().getMinecraftServerInstance()); return DBCH.genCA; }
/* 456 */      if (i == 1) { DBCH.genGH = DBCH.ghrwi(FMLCommonHandler.instance().getMinecraftServerInstance()); return DBCH.genGH; }
/* 457 */      if (i == 2) { DBCH.genFS = DBCH.fsrwi(FMLCommonHandler.instance().getMinecraftServerInstance()); return DBCH.genFS; }
/* 458 */      if (i == 3) { DBCH.genBS = DBCH.bsrwi(FMLCommonHandler.instance().getMinecraftServerInstance()); return DBCH.genBS; }
/* 459 */      if (i == 4) { DBCH.genGuru = DBCH.guruhrwi(FMLCommonHandler.instance().getMinecraftServerInstance()); return DBCH.genGuru; }
/* 460 */      return "";
/*     */   }
/*     */   public static void DBbuildsGen(int i, String d) {
/* 463 */     if (i == 0) { DBCH.genCA = d; DBCH.cawwi(FMLCommonHandler.instance().getMinecraftServerInstance(), d, false); }
/* 464 */     else if (i == 1) { DBCH.genGH = d; DBCH.ghwwi(FMLCommonHandler.instance().getMinecraftServerInstance(), d, false); }
/* 465 */     else if (i == 2) { DBCH.genFS = d; DBCH.fswwi(FMLCommonHandler.instance().getMinecraftServerInstance(), d, false); }
/* 466 */     else if (i == 3) { DBCH.genBS = d; DBCH.bswwi(FMLCommonHandler.instance().getMinecraftServerInstance(), d, false); }
/* 467 */     else if (i == 4) { DBCH.genGuru = d; DBCH.guruhwwi(FMLCommonHandler.instance().getMinecraftServerInstance(), d, false); }
/*     */   
/*     */   } public boolean DBbuildsSpawn(int i) {
/* 470 */     if (i == 0) return CASpawn; 
/* 471 */     if (i == 1) return GHSpawn; 
/* 472 */     if (i == 2) return FSSpawn; 
/* 473 */     if (i == 3) return BSSpawn; 
/* 474 */     if (i == 4) return WorldGen_GuruHouse_Done;
/*     */     
/* 476 */     return false;
/*     */   }
/*     */   public static void DBbuildsSpawn(int i, boolean d) {
/* 479 */     if (i == 0) { CASpawn = d; }
/* 480 */     else if (i == 1) { GHSpawn = d; }
/* 481 */     else if (i == 2) { FSSpawn = d; }
/* 482 */     else if (i == 3) { BSSpawn = d; }
/* 483 */     else if (i == 4) { WorldGen_GuruHouse_Done = d; }
/*     */   
/*     */   }
/*     */   
/* 487 */   public enum Type { NORMAL, UNDER, WATER; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void buildingSpawn(World world, Random random, int i, int k, int gen, BiomeGenBase biome, Type type) {
/* 494 */     if (DBbuildsSpawn(gen) && world.field_73011_w.field_76574_g == DBbuildsdim[gen] && world.func_72807_a(i, k) == biome) {
/* 495 */       if (world.func_147439_a(86, 216, 50) == BlocksJRMC.BlockColoredStone);
/*     */ 
/*     */       
/* 498 */       String bg = DBbuildsGen(gen);
/* 499 */       if (bg.length() > 2) {
/* 500 */         DBbuildsSpawn(gen, false);
/* 501 */       } else if (bg.length() == 1) {
/* 502 */         builds v = DBbuilds[gen];
/* 503 */         int s = JRMCoreConfig.buildingSpawnAreaSize;
/* 504 */         boolean bo = JRMCoreHDBC.checkForBuildsAound(world, i, k, s);
/* 505 */         for (int i1 = 0; i1 < 5; i1++) {
/* 506 */           if (world.func_72807_a(i + ((i1 == 0 || i1 == 1) ? 0 : builds.SizeX), k + ((i1 == 0 || i1 == 2) ? 0 : builds.SizeZ)) != biome) { bo = false; break; }
/*     */         
/* 508 */         }  if (bo) {
/* 509 */           int j = world.func_72976_f(i, k);
/* 510 */           if (j > 67) {
/* 511 */             for (int m = 0; m < 5; m++) {
/* 512 */               int j2 = world.func_72976_f(i + ((m == 0 || m == 1) ? 0 : builds.SizeX), k + ((m == 0 || m == 2) ? 0 : builds.SizeZ));
/* 513 */               if (world.func_147439_a(i + ((m == 0 || m == 1) ? 0 : builds.SizeX), j2 - 1, k + ((m == 0 || m == 2) ? 0 : builds.SizeZ)) == Blocks.field_150355_j) { bo = false; break; }
/*     */             
/* 515 */             }  if (bo && type == Type.UNDER) {
/* 516 */               int j2 = world.func_72976_f(i + builds.SizeX / 2, k + builds.SizeZ / 2);
/* 517 */               if (world.func_147439_a(i + builds.SizeX / 2, j2, k + builds.SizeZ / 2) == Blocks.field_150355_j || j2 < 60) bo = false; 
/* 518 */               j = j2 - builds.SizeY;
/*     */             } 
/* 520 */             if (bo) {
/*     */               
/* 522 */               DBbuildsSpawn(gen, true);
/* 523 */               String d = i + ";" + j + ";" + k;
/* 524 */               DBbuildsGen(gen, d);
/*     */               
/* 526 */               MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
/* 527 */               int cur = server.func_71233_x();
/* 528 */               for (int pl = 0; pl < cur; pl++) {
/* 529 */                 EntityPlayerMP p = JRMCoreH.getPlayerForUsername(server, server.func_71213_z()[pl]);
/* 530 */                 String t1 = JRMCoreH.cly + JRMCoreH.trl("dbc.worldgen.buildings.beenfound");
/* 531 */                 String t2 = JRMCoreH.cly + JRMCoreH.trl(DBbuildsNams(gen));
/* 532 */                 String tf = String.format(t1, new Object[] { t2 });
/* 533 */                 p.func_145747_a((IChatComponent)new ChatComponentText(JRMCoreH.cly + tf));
/*     */               } 
/*     */               
/* 536 */               v.setWorld(world);
/*     */               
/* 538 */               JRMCoreComTickH.bldngsChecker = 300;
/* 539 */               JRMCoreComTickH.bldngChkr = true;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void generateNether(World world, Random random, int i, int j) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void generateNamek(World world, Random random, int BlockX, int BlockZ) {
/* 584 */     if (world.field_73011_w.field_76574_g == DBCConfig.planetNamek) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 590 */       int buildingID = 2;
/* 591 */       if (DBbuildsSpawn(buildingID)) {
/* 592 */         int i = BlockX + random.nextInt(16);
/* 593 */         int k = BlockZ + random.nextInt(16);
/* 594 */         buildingSpawn(world, random, i, k, buildingID, BiomeGenBaseDBC.Namek, Type.NORMAL);
/*     */       } 
/*     */ 
/*     */       
/* 598 */       buildingID = 4;
/* 599 */       if (DBbuildsSpawn(buildingID)) {
/* 600 */         int i = BlockX + random.nextInt(16);
/* 601 */         int k = BlockZ + random.nextInt(16);
/* 602 */         buildingSpawn(world, random, i, k, buildingID, BiomeGenBaseDBC.Namek, Type.NORMAL);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 614 */       for (int x = 0; x < 10; x++) {
/* 615 */         int RPX = BlockX + random.nextInt(16);
/* 616 */         int RPZ = BlockZ + random.nextInt(16);
/* 617 */         int RPY = 10 + random.nextInt(127);
/* 618 */         (new WorldGenMinable(BlocksDBC.BlockOreWrenai, 6)).func_76484_a(world, random, RPX, RPY, RPZ);
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
/*     */   private void generateNR(World w, Random randomGenerator, int chunk_X, int chunk_Z) {
/* 641 */     if (w.field_73011_w.field_76574_g == 24)
/*     */     {
/* 643 */       if (JRMCoreConfig.BuildingSpawnCheck) {
/*     */ 
/*     */         
/* 646 */         if (w.func_147439_a(179, 136, 71) != BlocksDBC.BlockKachiKachin[4] && WorldGen_TOPZeno_Done) {
/*     */           
/* 648 */           WorldGen_TOPZeno_Done = false;
/* 649 */           this.WorldGen_TOPZeno = (WorldGenerator)new StructureTOP2();
/* 650 */           this.WorldGen_TOPZeno.func_76484_a(w, w.field_73012_v, 0, 0, 0);
/*     */         } 
/*     */         
/* 653 */         if (w.func_147439_a(6, 135, 70) != BlocksDBC.BlockKachiKachin[1] && WorldGen_TOPArena_Done) {
/*     */           
/* 655 */           WorldGen_TOPArena_Done = false;
/* 656 */           this.WorldGen_TOPArena = (WorldGenerator)new StructureTOP1();
/* 657 */           this.WorldGen_TOPArena.func_76484_a(w, w.field_73012_v, 0, 0, 0);
/*     */         } 
/*     */ 
/*     */         
/* 661 */         if (w.func_147439_a(386, 55, 87) != BlocksDBC.BlockKachiKachin[4] && WorldGen_Zeno_Done) {
/*     */           
/* 663 */           WorldGen_Zeno_Done = false;
/* 664 */           this.WorldGen_ZenoExpo = (WorldGenerator)new StructureZenoExpo();
/* 665 */           this.WorldGen_ZenoExpo.func_76484_a(w, w.field_73012_v, 0, 0, 0);
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void generateTC(World w, Random randomGenerator, int chunk_X, int chunk_Z) {
/* 673 */     if (w.field_73011_w.field_76574_g == 23)
/*     */     {
/* 675 */       if (JRMCoreConfig.BuildingSpawnCheck)
/*     */       {
/* 677 */         if (w.func_147439_a(55, 34, 8) != BlocksJRMC.BlockColoredStone && TiChaSpawn) { TiChaSpawn = false;
/* 678 */           this.TiCha = (WorldGenerator)new TiCha();
/* 679 */           this.TiCha.func_76484_a(w, w.field_73012_v, 0, 0, 0);
/* 680 */           if (w.func_147439_a(53, 37, 8) != BlocksDBC.BlockTCPort && TiChaKLSpawn) { TiChaKLSpawn = false;
/* 681 */             w.func_147465_d(54, 35, 8, BlocksDBC.BlockTCPort, 0, 3);
/* 682 */             w.func_147465_d(55, 35, 8, BlocksDBC.BlockTCPort, 0, 3);
/* 683 */             w.func_147465_d(54, 36, 8, BlocksDBC.BlockTCPort, 0, 3);
/* 684 */             w.func_147465_d(55, 36, 8, BlocksDBC.BlockTCPort, 0, 3);
/* 685 */             w.func_147465_d(53, 36, 8, BlocksDBC.BlockTCPort, 0, 3);
/* 686 */             w.func_147465_d(53, 35, 8, BlocksDBC.BlockTCPort, 0, 3);
/* 687 */             w.func_147465_d(53, 37, 8, BlocksDBC.BlockTCPort, 0, 3);
/* 688 */             w.func_147465_d(54, 37, 8, BlocksDBC.BlockTCPort, 0, 3);
/* 689 */             w.func_147465_d(55, 37, 8, BlocksDBC.BlockTCPort, 0, 3); }
/*     */            }
/*     */       
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void generateOW(World w, Random randomGenerator, int chunk_X, int chunk_Z) {
/* 697 */     if (w.field_73011_w.field_76574_g == 22) {
/*     */       int k;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 714 */       for (k = 0; k < 10; k++) {
/* 715 */         int firstBlockXCoord = chunk_X + randomGenerator.nextInt(16);
/* 716 */         int firstBlockYCoord = randomGenerator.nextInt(40);
/* 717 */         int firstBlockZCoord = chunk_Z + randomGenerator.nextInt(16);
/*     */         
/* 719 */         (new WorldGenMinable(BlocksDBC.BlockOreJJay, 12)).func_76484_a(w, randomGenerator, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
/*     */       } 
/* 721 */       for (k = 0; k < 10; k++) {
/* 722 */         int firstBlockXCoord = chunk_X + randomGenerator.nextInt(16);
/* 723 */         int firstBlockYCoord = randomGenerator.nextInt(40);
/* 724 */         int firstBlockZCoord = chunk_Z + randomGenerator.nextInt(16);
/*     */         
/* 726 */         (new WorldGenMinable(BlocksDBC.BlockOreDlog, 8)).func_76484_a(w, randomGenerator, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
/*     */       } 
/* 728 */       for (k = 0; k < 10; k++) {
/* 729 */         int firstBlockXCoord = chunk_X + randomGenerator.nextInt(16);
/* 730 */         int firstBlockYCoord = randomGenerator.nextInt(40);
/* 731 */         int firstBlockZCoord = chunk_Z + randomGenerator.nextInt(16);
/*     */         
/* 733 */         (new WorldGenMinable(BlocksDBC.BlockOreLehnori, 8)).func_76484_a(w, randomGenerator, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
/*     */       } 
/* 735 */       for (k = 0; k < 10; k++) {
/* 736 */         int firstBlockXCoord = chunk_X + randomGenerator.nextInt(16);
/* 737 */         int firstBlockYCoord = randomGenerator.nextInt(40);
/* 738 */         int firstBlockZCoord = chunk_Z + randomGenerator.nextInt(16);
/*     */         
/* 740 */         (new WorldGenMinable(BlocksDBC.BlockOreDnomaid, 7, Blocks.field_150353_l)).func_76484_a(w, randomGenerator, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
/*     */       } 
/*     */       
/* 743 */       if (JRMCoreConfig.BuildingSpawnCheck) {
/* 744 */         if (w.func_147439_a(75, 90, 127) != BlocksJRMC.BlockColoredStone && ChkInStSpawn) { ChkInStSpawn = false;
/* 745 */           this.ChkInSt = (WorldGenerator)new ChkInSt();
/* 746 */           this.ChkInSt.func_76484_a(w, w.field_73012_v, 0, 0, 0); }
/*     */         
/* 748 */         if (w.func_147439_a(75, 90, -5) != BlocksJRMC.BlockColoredStone && SnkWySpawn) { SnkWySpawn = false;
/* 749 */           this.SnkWy = (WorldGenerator)new SnkWy();
/* 750 */           this.SnkWy.func_76484_a(w, w.field_73012_v, 0, 0, 0); }
/*     */       
/*     */       } 
/* 753 */       if (JRMCoreConfig.NPCSpawnCheck) {
/* 754 */         AxisAlignedBB par2AxisAlignedBB = AxisAlignedBB.func_72330_a(60.0D, 10.0D, 35.0D, 90.0D, 110.0D, 65.0D);
/* 755 */         List enma = w.func_72872_a(EntityMasterEnma.class, par2AxisAlignedBB);
/* 756 */         if (enma.isEmpty()) {
/* 757 */           EntityMasterEnma namekian03 = new EntityMasterEnma(w);
/*     */           
/* 759 */           namekian03.func_70012_b(75.0D, 91.0D, 53.0D, 0.0F, 0.0F);
/* 760 */           w.func_72838_d((Entity)namekian03);
/*     */         } 
/* 762 */         AxisAlignedBB aabbkaio = AxisAlignedBB.func_72330_a(87.0D, 1.0D, -3739.0D, 127.0D, 140.0D, -3699.0D);
/* 763 */         List kaio = w.func_72872_a(EntityMasterKaio.class, aabbkaio);
/* 764 */         if (kaio.isEmpty()) {
/* 765 */           EntityMasterKaio namekian03 = new EntityMasterKaio(w);
/*     */           
/* 767 */           namekian03.func_70012_b(107.0D, 116.0D, -3719.0D, 0.0F, 0.0F);
/* 768 */           w.func_72838_d((Entity)namekian03);
/*     */         } 
/*     */ 
/*     */         
/* 772 */         AxisAlignedBB aabbjin = AxisAlignedBB.func_72330_a(87.0D, 1.0D, -3742.0D, 127.0D, 140.0D, -3702.0D);
/* 773 */         List jin = w.func_72872_a(EntityMasterJin.class, aabbjin);
/* 774 */         if (jin.isEmpty()) {
/* 775 */           EntityMasterJin namekian03 = new EntityMasterJin(w);
/*     */           
/* 777 */           namekian03.func_70012_b(107.0D, 116.0D, -3722.0D, 0.0F, 0.0F);
/* 778 */           w.func_72838_d((Entity)namekian03);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Worlds\WorldGeneratorDB.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */