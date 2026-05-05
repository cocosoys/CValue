/*     */ package net.minecraft.world;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import java.util.TreeSet;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockEventData;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.crash.CrashReport;
/*     */ import net.minecraft.crash.CrashReportCategory;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityTracker;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.server.S2APacketParticles;
/*     */ import net.minecraft.network.play.server.S2BPacketChangeGameState;
/*     */ import net.minecraft.scoreboard.ScoreboardSaveData;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.server.management.PlayerManager;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.ChunkCoordinates;
/*     */ import net.minecraft.util.IProgressUpdate;
/*     */ import net.minecraft.util.IntHashMap;
/*     */ import net.minecraft.util.WeightedRandomChestContent;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ import net.minecraft.world.biome.WorldChunkManager;
/*     */ import net.minecraft.world.chunk.Chunk;
/*     */ import net.minecraft.world.chunk.storage.ExtendedBlockStorage;
/*     */ 
/*     */ public class WorldServer extends World {
/*  36 */   private static final Logger field_147491_a = LogManager.getLogger();
/*     */   
/*     */   private final MinecraftServer field_73061_a;
/*     */   
/*     */   private final EntityTracker field_73062_L;
/*     */   private final PlayerManager field_73063_M;
/*     */   private Set field_73064_N;
/*     */   private TreeSet field_73065_O;
/*     */   public ChunkProviderServer field_73059_b;
/*     */   public boolean field_73058_d;
/*     */   private boolean field_73068_P;
/*     */   private int field_80004_Q;
/*     */   private final Teleporter field_85177_Q;
/*  49 */   private final SpawnerAnimals field_135059_Q = new SpawnerAnimals();
/*     */   
/*     */   static class ServerBlockEventList extends ArrayList {
/*     */     private static final String __OBFID = "CL_00001439";
/*     */     
/*     */     private ServerBlockEventList() {} }
/*  55 */   private ServerBlockEventList[] field_147490_S = new ServerBlockEventList[] { new ServerBlockEventList(), new ServerBlockEventList() };
/*     */ 
/*     */   
/*     */   private int field_147489_T;
/*     */ 
/*     */   
/*  61 */   public static final WeightedRandomChestContent[] field_73069_S = new WeightedRandomChestContent[] { new WeightedRandomChestContent(Items.field_151055_y, 0, 1, 3, 10), new WeightedRandomChestContent(Item.func_150898_a(Blocks.field_150344_f), 0, 1, 3, 10), new WeightedRandomChestContent(Item.func_150898_a(Blocks.field_150364_r), 0, 1, 3, 10), new WeightedRandomChestContent(Items.field_151049_t, 0, 1, 1, 3), new WeightedRandomChestContent(Items.field_151053_p, 0, 1, 1, 5), new WeightedRandomChestContent(Items.field_151050_s, 0, 1, 1, 3), new WeightedRandomChestContent(Items.field_151039_o, 0, 1, 1, 5), new WeightedRandomChestContent(Items.field_151034_e, 0, 2, 3, 5), new WeightedRandomChestContent(Items.field_151025_P, 0, 2, 3, 3), new WeightedRandomChestContent(Item.func_150898_a(Blocks.field_150363_s), 0, 1, 3, 10) }; private List field_94579_S; private IntHashMap field_73066_T; private static final String __OBFID = "CL_00001437"; public void func_72835_b() { super.func_72835_b(); if (func_72912_H().func_76093_s() && this.field_73013_u != EnumDifficulty.HARD) this.field_73013_u = EnumDifficulty.HARD;  this.field_73011_w.field_76578_c.func_76938_b(); if (func_73056_e()) { if (func_82736_K().func_82766_b("doDaylightCycle")) { long l = this.field_72986_A.func_76073_f() + 24000L; this.field_72986_A.func_76068_b(l - l % 24000L); }  func_73053_d(); }  this.field_72984_F.func_76320_a("mobSpawner"); if (func_82736_K().func_82766_b("doMobSpawning")) this.field_135059_Q.func_77192_a(this, this.field_72985_G, this.field_72992_H, (this.field_72986_A.func_82573_f() % 400L == 0L));  this.field_72984_F.func_76318_c("chunkSource"); this.field_73020_y.func_73156_b(); int i = func_72967_a(1.0F); if (i != this.field_73008_k)
/*     */       this.field_73008_k = i;  this.field_72986_A.func_82572_b(this.field_72986_A.func_82573_f() + 1L); if (func_82736_K().func_82766_b("doDaylightCycle"))
/*     */       this.field_72986_A.func_76068_b(this.field_72986_A.func_76073_f() + 1L);  this.field_72984_F.func_76318_c("tickPending"); func_72955_a(false); this.field_72984_F.func_76318_c("tickBlocks"); func_147456_g(); this.field_72984_F.func_76318_c("chunkMap"); this.field_73063_M.func_72693_b(); this.field_72984_F.func_76318_c("village"); this.field_72982_D.func_75544_a(); this.field_72983_E.func_75528_a(); this.field_72984_F.func_76318_c("portalForcer"); this.field_85177_Q.func_85189_a(func_82737_E()); this.field_72984_F.func_76319_b(); func_147488_Z(); }
/*     */   public BiomeGenBase.SpawnListEntry func_73057_a(EnumCreatureType p_73057_1_, int p_73057_2_, int p_73057_3_, int p_73057_4_) { List list = func_72863_F().func_73155_a(p_73057_1_, p_73057_2_, p_73057_3_, p_73057_4_); if (list == null || list.isEmpty())
/*     */       return null;  return (BiomeGenBase.SpawnListEntry)WeightedRandom.func_76271_a(this.field_73012_v, list); }
/*     */   public void func_72854_c() { this.field_73068_P = !this.field_73010_i.isEmpty(); for (EntityPlayer entityPlayer : this.field_73010_i) { if (!entityPlayer.func_70608_bn()) { this.field_73068_P = false; break; }  }  }
/*     */   protected void func_73053_d() { this.field_73068_P = false; for (EntityPlayer entityPlayer : this.field_73010_i) { if (entityPlayer.func_70608_bn())
/*     */         entityPlayer.func_70999_a(false, false, true);  }  func_73051_P(); }
/*  69 */   public WorldServer(MinecraftServer p_i45284_1_, ISaveHandler p_i45284_2_, String p_i45284_3_, int p_i45284_4_, WorldSettings p_i45284_5_, Profiler p_i45284_6_) { super(p_i45284_2_, p_i45284_3_, p_i45284_5_, WorldProvider.func_76570_a(p_i45284_4_), p_i45284_6_);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 372 */     this.field_94579_S = new ArrayList(); this.field_73061_a = p_i45284_1_; this.field_73062_L = new EntityTracker(this); this.field_73063_M = new PlayerManager(this); if (this.field_73066_T == null) this.field_73066_T = new IntHashMap();  if (this.field_73064_N == null) this.field_73064_N = new HashSet();  if (this.field_73065_O == null) this.field_73065_O = new TreeSet();  this.field_85177_Q = new Teleporter(this); this.field_96442_D = (Scoreboard)new ServerScoreboard(p_i45284_1_); ScoreboardSaveData scoreboardSaveData = (ScoreboardSaveData)this.field_72988_C.func_75742_a(ScoreboardSaveData.class, "scoreboard"); if (scoreboardSaveData == null) { scoreboardSaveData = new ScoreboardSaveData(); this.field_72988_C.func_75745_a("scoreboard", (WorldSavedData)scoreboardSaveData); }  scoreboardSaveData.func_96499_a(this.field_96442_D); ((ServerScoreboard)this.field_96442_D).func_96547_a(scoreboardSaveData); } private void func_73051_P() { this.field_72986_A.func_76080_g(0); this.field_72986_A.func_76084_b(false); this.field_72986_A.func_76090_f(0); this.field_72986_A.func_76069_a(false); }
/*     */   public boolean func_73056_e() { if (this.field_73068_P && !this.field_72995_K) { for (EntityPlayer entityPlayer : this.field_73010_i) { if (!entityPlayer.func_71026_bH()) return false;  }  return true; }  return false; }
/*     */   @SideOnly(Side.CLIENT) public void func_72974_f() { if (this.field_72986_A.func_76075_d() <= 0) this.field_72986_A.func_76056_b(64);  int i = this.field_72986_A.func_76079_c(); int j = this.field_72986_A.func_76074_e(); byte b = 0; while (func_147474_b(i, j).func_149688_o() == Material.field_151579_a) { i += this.field_73012_v.nextInt(8) - this.field_73012_v.nextInt(8); j += this.field_73012_v.nextInt(8) - this.field_73012_v.nextInt(8); if (++b == '✐')
/*     */         break;  }  this.field_72986_A.func_76058_a(i); this.field_72986_A.func_76087_c(j); }
/* 376 */   public boolean func_72955_a(boolean p_72955_1_) { int i = this.field_73065_O.size();
/* 377 */     if (i != this.field_73064_N.size()) {
/* 378 */       throw new IllegalStateException("TickNextTick list out of synch");
/*     */     }
/* 380 */     if (i > 1000) i = 1000;
/*     */     
/* 382 */     this.field_72984_F.func_76320_a("cleaning");
/* 383 */     for (byte b = 0; b < i; b++) {
/* 384 */       NextTickListEntry nextTickListEntry = this.field_73065_O.first();
/* 385 */       if (!p_72955_1_ && nextTickListEntry.field_77180_e > this.field_72986_A.func_82573_f())
/*     */         break; 
/* 387 */       this.field_73065_O.remove(nextTickListEntry);
/* 388 */       this.field_73064_N.remove(nextTickListEntry);
/* 389 */       this.field_94579_S.add(nextTickListEntry);
/*     */     } 
/* 391 */     this.field_72984_F.func_76319_b();
/*     */     
/* 393 */     this.field_72984_F.func_76320_a("ticking");
/* 394 */     Iterator<NextTickListEntry> iterator = this.field_94579_S.iterator();
/* 395 */     while (iterator.hasNext()) {
/* 396 */       NextTickListEntry nextTickListEntry = iterator.next();
/* 397 */       iterator.remove();
/*     */       
/* 399 */       byte b1 = 0;
/*     */       
/* 401 */       if (func_72904_c(nextTickListEntry.field_77183_a - b1, nextTickListEntry.field_77181_b - b1, nextTickListEntry.field_77182_c - b1, nextTickListEntry.field_77183_a + b1, nextTickListEntry.field_77181_b + b1, nextTickListEntry.field_77182_c + b1)) {
/* 402 */         Block block = func_147439_a(nextTickListEntry.field_77183_a, nextTickListEntry.field_77181_b, nextTickListEntry.field_77182_c);
/* 403 */         if (block.func_149688_o() != Material.field_151579_a && Block.func_149680_a(block, nextTickListEntry.func_151351_a()))
/*     */           try {
/* 405 */             block.func_149674_a(this, nextTickListEntry.field_77183_a, nextTickListEntry.field_77181_b, nextTickListEntry.field_77182_c, this.field_73012_v);
/* 406 */           } catch (Throwable throwable) {
/* 407 */             byte b2; CrashReport crashReport = CrashReport.func_85055_a(throwable, "Exception while ticking a block");
/* 408 */             CrashReportCategory crashReportCategory = crashReport.func_85058_a("Block being ticked");
/*     */ 
/*     */             
/*     */             try {
/* 412 */               b2 = func_72805_g(nextTickListEntry.field_77183_a, nextTickListEntry.field_77181_b, nextTickListEntry.field_77182_c);
/* 413 */             } catch (Throwable throwable1) {
/* 414 */               b2 = -1;
/*     */             } 
/*     */             
/* 417 */             CrashReportCategory.func_147153_a(crashReportCategory, nextTickListEntry.field_77183_a, nextTickListEntry.field_77181_b, nextTickListEntry.field_77182_c, block, b2);
/*     */             
/* 419 */             throw new ReportedException(crashReport);
/*     */           }  
/*     */         continue;
/*     */       } 
/* 423 */       func_147464_a(nextTickListEntry.field_77183_a, nextTickListEntry.field_77181_b, nextTickListEntry.field_77182_c, nextTickListEntry.func_151351_a(), 0);
/*     */     } 
/*     */     
/* 426 */     this.field_72984_F.func_76319_b();
/*     */     
/* 428 */     this.field_94579_S.clear();
/*     */     
/* 430 */     return !this.field_73065_O.isEmpty(); }
/*     */   protected void func_147456_g() { super.func_147456_g(); byte b1 = 0; byte b2 = 0; for (ChunkCoordIntPair chunkCoordIntPair : this.field_72993_I) { int i = chunkCoordIntPair.field_77276_a * 16; int j = chunkCoordIntPair.field_77275_b * 16; this.field_72984_F.func_76320_a("getChunk"); Chunk chunk = func_72964_e(chunkCoordIntPair.field_77276_a, chunkCoordIntPair.field_77275_b); func_147467_a(i, j, chunk); this.field_72984_F.func_76318_c("tickChunk"); chunk.func_150804_b(false); this.field_72984_F.func_76318_c("thunder"); if (this.field_73012_v.nextInt(100000) == 0 && func_72896_J() && func_72911_I()) { this.field_73005_l = this.field_73005_l * 3 + 1013904223; int k = this.field_73005_l >> 2; int m = i + (k & 0xF); int n = j + (k >> 8 & 0xF); int i1 = func_72874_g(m, n); if (func_72951_B(m, i1, n)) func_72942_c((Entity)new EntityLightningBolt(this, m, i1, n));  }  this.field_72984_F.func_76318_c("iceandsnow"); if (this.field_73012_v.nextInt(16) == 0) { this.field_73005_l = this.field_73005_l * 3 + 1013904223; int k = this.field_73005_l >> 2; int m = k & 0xF; int n = k >> 8 & 0xF; int i1 = func_72874_g(m + i, n + j); if (func_72850_v(m + i, i1 - 1, n + j))
/*     */           func_147449_b(m + i, i1 - 1, n + j, Blocks.field_150432_aD);  if (func_72896_J() && func_147478_e(m + i, i1, n + j, true))
/*     */           func_147449_b(m + i, i1, n + j, Blocks.field_150431_aC);  if (func_72896_J()) { BiomeGenBase biomeGenBase = func_72807_a(m + i, n + j); if (biomeGenBase.func_76738_d())
/*     */             func_147439_a(m + i, i1 - 1, n + j).func_149639_l(this, m + i, i1 - 1, n + j);  }  }  this.field_72984_F.func_76318_c("tickBlocks"); for (ExtendedBlockStorage extendedBlockStorage : chunk.func_76587_i()) { if (extendedBlockStorage != null && extendedBlockStorage.func_76675_b())
/* 435 */           for (byte b = 0; b < 3; b++) { this.field_73005_l = this.field_73005_l * 3 + 1013904223; int k = this.field_73005_l >> 2; int m = k & 0xF; int n = k >> 8 & 0xF; int i1 = k >> 16 & 0xF; b2++; Block block = extendedBlockStorage.func_150819_a(m, i1, n); if (block.func_149653_t()) { b1++; block.func_149674_a(this, m + i, i1 + extendedBlockStorage.func_76662_d(), n + j, this.field_73012_v); }  }   }  this.field_72984_F.func_76319_b(); }  } public List func_72920_a(Chunk p_72920_1_, boolean p_72920_2_) { ArrayList<NextTickListEntry> arrayList = null;
/*     */     
/* 437 */     ChunkCoordIntPair chunkCoordIntPair = p_72920_1_.func_76632_l();
/* 438 */     int i = (chunkCoordIntPair.field_77276_a << 4) - 2;
/* 439 */     int j = i + 16 + 2;
/* 440 */     int k = (chunkCoordIntPair.field_77275_b << 4) - 2;
/* 441 */     int m = k + 16 + 2;
/*     */     
/* 443 */     for (byte b = 0; b < 2; b++) {
/*     */       Iterator<NextTickListEntry> iterator;
/* 445 */       if (b == 0) {
/* 446 */         iterator = this.field_73065_O.iterator();
/*     */       } else {
/* 448 */         iterator = this.field_94579_S.iterator();
/* 449 */         if (!this.field_94579_S.isEmpty()) {
/* 450 */           field_147491_a.debug("toBeTicked = " + this.field_94579_S.size());
/*     */         }
/*     */       } 
/*     */       
/* 454 */       while (iterator.hasNext()) {
/* 455 */         NextTickListEntry nextTickListEntry = iterator.next();
/* 456 */         if (nextTickListEntry.field_77183_a >= i && nextTickListEntry.field_77183_a < j && nextTickListEntry.field_77182_c >= k && nextTickListEntry.field_77182_c < m) {
/* 457 */           if (p_72920_2_) {
/* 458 */             this.field_73064_N.remove(nextTickListEntry);
/* 459 */             iterator.remove();
/*     */           } 
/* 461 */           if (arrayList == null) {
/* 462 */             arrayList = new ArrayList();
/*     */           }
/* 464 */           arrayList.add(nextTickListEntry);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 469 */     return arrayList; }
/*     */   public boolean func_147477_a(int p_147477_1_, int p_147477_2_, int p_147477_3_, Block p_147477_4_) { NextTickListEntry nextTickListEntry = new NextTickListEntry(p_147477_1_, p_147477_2_, p_147477_3_, p_147477_4_); return this.field_94579_S.contains(nextTickListEntry); }
/*     */   public void func_147464_a(int p_147464_1_, int p_147464_2_, int p_147464_3_, Block p_147464_4_, int p_147464_5_) { func_147454_a(p_147464_1_, p_147464_2_, p_147464_3_, p_147464_4_, p_147464_5_, 0); }
/*     */   public void func_147454_a(int p_147454_1_, int p_147454_2_, int p_147454_3_, Block p_147454_4_, int p_147454_5_, int p_147454_6_) { NextTickListEntry nextTickListEntry = new NextTickListEntry(p_147454_1_, p_147454_2_, p_147454_3_, p_147454_4_); byte b = 0; if (this.field_72999_e && p_147454_4_.func_149688_o() != Material.field_151579_a) { if (p_147454_4_.func_149698_L()) { b = 8; if (func_72904_c(nextTickListEntry.field_77183_a - b, nextTickListEntry.field_77181_b - b, nextTickListEntry.field_77182_c - b, nextTickListEntry.field_77183_a + b, nextTickListEntry.field_77181_b + b, nextTickListEntry.field_77182_c + b)) { Block block = func_147439_a(nextTickListEntry.field_77183_a, nextTickListEntry.field_77181_b, nextTickListEntry.field_77182_c); if (block.func_149688_o() != Material.field_151579_a && block == nextTickListEntry.func_151351_a()) block.func_149674_a(this, nextTickListEntry.field_77183_a, nextTickListEntry.field_77181_b, nextTickListEntry.field_77182_c, this.field_73012_v);  }  return; }  p_147454_5_ = 1; }  if (func_72904_c(p_147454_1_ - b, p_147454_2_ - b, p_147454_3_ - b, p_147454_1_ + b, p_147454_2_ + b, p_147454_3_ + b)) { if (p_147454_4_.func_149688_o() != Material.field_151579_a) { nextTickListEntry.func_77176_a(p_147454_5_ + this.field_72986_A.func_82573_f()); nextTickListEntry.func_82753_a(p_147454_6_); }  if (!this.field_73064_N.contains(nextTickListEntry)) { this.field_73064_N.add(nextTickListEntry); this.field_73065_O.add(nextTickListEntry); }  }  }
/*     */   public void func_147446_b(int p_147446_1_, int p_147446_2_, int p_147446_3_, Block p_147446_4_, int p_147446_5_, int p_147446_6_) { NextTickListEntry nextTickListEntry = new NextTickListEntry(p_147446_1_, p_147446_2_, p_147446_3_, p_147446_4_); nextTickListEntry.func_82753_a(p_147446_6_); if (p_147446_4_.func_149688_o() != Material.field_151579_a) nextTickListEntry.func_77176_a(p_147446_5_ + this.field_72986_A.func_82573_f());  if (!this.field_73064_N.contains(nextTickListEntry)) { this.field_73064_N.add(nextTickListEntry); this.field_73065_O.add(nextTickListEntry); }  }
/* 474 */   public void func_72939_s() { if (this.field_73010_i.isEmpty()) { if (this.field_80004_Q++ >= 1200) return;  } else { func_82742_i(); }  super.func_72939_s(); } public void func_82742_i() { this.field_80004_Q = 0; } public void func_72866_a(Entity p_72866_1_, boolean p_72866_2_) { if (!this.field_73061_a.func_71268_U() && (p_72866_1_ instanceof net.minecraft.entity.passive.EntityAnimal || p_72866_1_ instanceof net.minecraft.entity.passive.EntityWaterMob)) {
/* 475 */       p_72866_1_.func_70106_y();
/*     */     }
/* 477 */     if (!this.field_73061_a.func_71220_V() && p_72866_1_ instanceof net.minecraft.entity.INpc) {
/* 478 */       p_72866_1_.func_70106_y();
/*     */     }
/* 480 */     super.func_72866_a(p_72866_1_, p_72866_2_); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IChunkProvider func_72970_h() {
/* 499 */     IChunkLoader iChunkLoader = this.field_73019_z.func_75763_a(this.field_73011_w);
/* 500 */     this.field_73059_b = new ChunkProviderServer(this, iChunkLoader, this.field_73011_w.func_76555_c());
/* 501 */     return (IChunkProvider)this.field_73059_b;
/*     */   }
/*     */   
/*     */   public List func_147486_a(int p_147486_1_, int p_147486_2_, int p_147486_3_, int p_147486_4_, int p_147486_5_, int p_147486_6_) {
/* 505 */     ArrayList<TileEntity> arrayList = new ArrayList();
/* 506 */     for (byte b = 0; b < this.field_147482_g.size(); b++) {
/* 507 */       TileEntity tileEntity = this.field_147482_g.get(b);
/* 508 */       if (tileEntity.field_145851_c >= p_147486_1_ && tileEntity.field_145848_d >= p_147486_2_ && tileEntity.field_145849_e >= p_147486_3_ && tileEntity.field_145851_c < p_147486_4_ && tileEntity.field_145848_d < p_147486_5_ && tileEntity.field_145849_e < p_147486_6_) {
/* 509 */         arrayList.add(tileEntity);
/*     */       }
/*     */     } 
/* 512 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_72962_a(EntityPlayer p_72962_1_, int p_72962_2_, int p_72962_3_, int p_72962_4_) {
/* 517 */     return !this.field_73061_a.func_96290_a(this, p_72962_2_, p_72962_3_, p_72962_4_, p_72962_1_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_72963_a(WorldSettings p_72963_1_) {
/* 524 */     if (this.field_73066_T == null) {
/* 525 */       this.field_73066_T = new IntHashMap();
/*     */     }
/* 527 */     if (this.field_73064_N == null) {
/* 528 */       this.field_73064_N = new HashSet();
/*     */     }
/* 530 */     if (this.field_73065_O == null) {
/* 531 */       this.field_73065_O = new TreeSet();
/*     */     }
/*     */     
/* 534 */     func_73052_b(p_72963_1_);
/*     */     
/* 536 */     super.func_72963_a(p_72963_1_);
/*     */   }
/*     */   
/*     */   protected void func_73052_b(WorldSettings p_73052_1_) {
/* 540 */     if (!this.field_73011_w.func_76567_e()) {
/* 541 */       this.field_72986_A.func_76081_a(0, this.field_73011_w.func_76557_i(), 0);
/*     */       
/*     */       return;
/*     */     } 
/* 545 */     this.field_72987_B = true;
/*     */     
/* 547 */     WorldChunkManager worldChunkManager = this.field_73011_w.field_76578_c;
/* 548 */     List list = worldChunkManager.func_76932_a();
/* 549 */     Random random = new Random(func_72905_C());
/*     */     
/* 551 */     ChunkPosition chunkPosition = worldChunkManager.func_150795_a(0, 0, 256, list, random);
/*     */     
/* 553 */     int i = 0;
/* 554 */     int j = this.field_73011_w.func_76557_i();
/* 555 */     int k = 0;
/*     */     
/* 557 */     if (chunkPosition != null) {
/* 558 */       i = chunkPosition.field_151329_a;
/* 559 */       k = chunkPosition.field_151328_c;
/*     */     } else {
/* 561 */       field_147491_a.warn("Unable to find spawn biome");
/*     */     } 
/*     */     
/* 564 */     byte b = 0;
/* 565 */     while (!this.field_73011_w.func_76566_a(i, k)) {
/* 566 */       i += random.nextInt(64) - random.nextInt(64);
/* 567 */       k += random.nextInt(64) - random.nextInt(64);
/* 568 */       if (++b == 'Ϩ')
/*     */         break; 
/* 570 */     }  this.field_72986_A.func_76081_a(i, j, k);
/* 571 */     this.field_72987_B = false;
/*     */     
/* 573 */     if (p_73052_1_.func_77167_c()) {
/* 574 */       func_73047_i();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_73047_i() {
/* 581 */     WorldGeneratorBonusChest worldGeneratorBonusChest = new WorldGeneratorBonusChest(field_73069_S, 10);
/* 582 */     for (byte b = 0; b < 10; b++) {
/* 583 */       int i = this.field_72986_A.func_76079_c() + this.field_73012_v.nextInt(6) - this.field_73012_v.nextInt(6);
/* 584 */       int j = this.field_72986_A.func_76074_e() + this.field_73012_v.nextInt(6) - this.field_73012_v.nextInt(6);
/* 585 */       int k = func_72825_h(i, j) + 1;
/*     */       
/* 587 */       if (worldGeneratorBonusChest.func_76484_a(this, this.field_73012_v, i, k, j)) {
/*     */         break;
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public ChunkCoordinates func_73054_j() {
/* 594 */     return this.field_73011_w.func_76554_h();
/*     */   }
/*     */   
/*     */   public void func_73044_a(boolean p_73044_1_, IProgressUpdate p_73044_2_) throws MinecraftException {
/* 598 */     if (!this.field_73020_y.func_73157_c())
/*     */       return; 
/* 600 */     if (p_73044_2_ != null) p_73044_2_.func_73720_a("Saving level"); 
/* 601 */     func_73042_a();
/*     */     
/* 603 */     if (p_73044_2_ != null) p_73044_2_.func_73719_c("Saving chunks"); 
/* 604 */     this.field_73020_y.func_73151_a(p_73044_1_, p_73044_2_);
/*     */ 
/*     */ 
/*     */     
/* 608 */     ArrayList arrayList = Lists.newArrayList(this.field_73059_b.func_152380_a());
/* 609 */     for (Chunk chunk : arrayList) {
/* 610 */       if (chunk == null) {
/*     */         continue;
/*     */       }
/* 613 */       if (!this.field_73063_M.func_152621_a(chunk.field_76635_g, chunk.field_76647_h)) {
/* 614 */         this.field_73059_b.func_73241_b(chunk.field_76635_g, chunk.field_76647_h);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_104140_m() {
/* 620 */     if (!this.field_73020_y.func_73157_c())
/* 621 */       return;  this.field_73020_y.func_104112_b();
/*     */   }
/*     */   
/*     */   protected void func_73042_a() throws MinecraftException {
/* 625 */     func_72906_B();
/*     */     
/* 627 */     this.field_73019_z.func_75755_a(this.field_72986_A, this.field_73061_a.func_71203_ab().func_72378_q());
/* 628 */     this.field_72988_C.func_75744_a();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_72923_a(Entity p_72923_1_) {
/* 633 */     super.func_72923_a(p_72923_1_);
/* 634 */     this.field_73066_T.func_76038_a(p_72923_1_.func_145782_y(), p_72923_1_);
/* 635 */     Entity[] arrayOfEntity = p_72923_1_.func_70021_al();
/* 636 */     if (arrayOfEntity != null) {
/* 637 */       for (byte b = 0; b < arrayOfEntity.length; b++) {
/* 638 */         this.field_73066_T.func_76038_a(arrayOfEntity[b].func_145782_y(), arrayOfEntity[b]);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_72847_b(Entity p_72847_1_) {
/* 645 */     super.func_72847_b(p_72847_1_);
/* 646 */     this.field_73066_T.func_76049_d(p_72847_1_.func_145782_y());
/* 647 */     Entity[] arrayOfEntity = p_72847_1_.func_70021_al();
/* 648 */     if (arrayOfEntity != null) {
/* 649 */       for (byte b = 0; b < arrayOfEntity.length; b++) {
/* 650 */         this.field_73066_T.func_76049_d(arrayOfEntity[b].func_145782_y());
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Entity func_73045_a(int p_73045_1_) {
/* 657 */     return (Entity)this.field_73066_T.func_76041_a(p_73045_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_72942_c(Entity p_72942_1_) {
/* 662 */     if (super.func_72942_c(p_72942_1_)) {
/* 663 */       this.field_73061_a.func_71203_ab().func_148541_a(p_72942_1_.field_70165_t, p_72942_1_.field_70163_u, p_72942_1_.field_70161_v, 512.0D, this.field_73011_w.field_76574_g, (Packet)new S2CPacketSpawnGlobalEntity(p_72942_1_));
/* 664 */       return true;
/*     */     } 
/* 666 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_72960_a(Entity p_72960_1_, byte p_72960_2_) {
/* 671 */     func_73039_n().func_151248_b(p_72960_1_, (Packet)new S19PacketEntityStatus(p_72960_1_, p_72960_2_));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Explosion func_72885_a(Entity p_72885_1_, double p_72885_2_, double p_72885_4_, double p_72885_6_, float p_72885_8_, boolean p_72885_9_, boolean p_72885_10_) {
/* 678 */     Explosion explosion = new Explosion(this, p_72885_1_, p_72885_2_, p_72885_4_, p_72885_6_, p_72885_8_);
/* 679 */     explosion.field_77286_a = p_72885_9_;
/* 680 */     explosion.field_82755_b = p_72885_10_;
/* 681 */     explosion.func_77278_a();
/* 682 */     explosion.func_77279_a(false);
/*     */     
/* 684 */     if (!p_72885_10_) {
/* 685 */       explosion.field_77281_g.clear();
/*     */     }
/*     */     
/* 688 */     for (EntityPlayer entityPlayer : this.field_73010_i) {
/* 689 */       if (entityPlayer.func_70092_e(p_72885_2_, p_72885_4_, p_72885_6_) < 4096.0D) {
/* 690 */         ((EntityPlayerMP)entityPlayer).field_71135_a.func_147359_a((Packet)new S27PacketExplosion(p_72885_2_, p_72885_4_, p_72885_6_, p_72885_8_, explosion.field_77281_g, (Vec3)explosion.func_77277_b().get(entityPlayer)));
/*     */       }
/*     */     } 
/*     */     
/* 694 */     return explosion;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_147452_c(int p_147452_1_, int p_147452_2_, int p_147452_3_, Block p_147452_4_, int p_147452_5_, int p_147452_6_) {
/* 699 */     BlockEventData blockEventData = new BlockEventData(p_147452_1_, p_147452_2_, p_147452_3_, p_147452_4_, p_147452_5_, p_147452_6_);
/* 700 */     for (BlockEventData blockEventData1 : this.field_147490_S[this.field_147489_T]) {
/* 701 */       if (blockEventData1.equals(blockEventData)) {
/*     */         return;
/*     */       }
/*     */     } 
/* 705 */     this.field_147490_S[this.field_147489_T].add((E)blockEventData);
/*     */   }
/*     */ 
/*     */   
/*     */   private void func_147488_Z() {
/* 710 */     while (!this.field_147490_S[this.field_147489_T].isEmpty()) {
/* 711 */       int i = this.field_147489_T;
/* 712 */       this.field_147489_T ^= 0x1;
/*     */       
/* 714 */       for (BlockEventData blockEventData : this.field_147490_S[i]) {
/* 715 */         if (func_147485_a(blockEventData)) {
/* 716 */           this.field_73061_a.func_71203_ab().func_148541_a(blockEventData.func_151340_a(), blockEventData.func_151342_b(), blockEventData.func_151341_c(), 64.0D, this.field_73011_w.field_76574_g, (Packet)new S24PacketBlockAction(blockEventData.func_151340_a(), blockEventData.func_151342_b(), blockEventData.func_151341_c(), blockEventData.func_151337_f(), blockEventData.func_151339_d(), blockEventData.func_151338_e()));
/*     */         }
/*     */       } 
/*     */       
/* 720 */       this.field_147490_S[i].clear();
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean func_147485_a(BlockEventData p_147485_1_) {
/* 725 */     Block block = func_147439_a(p_147485_1_.func_151340_a(), p_147485_1_.func_151342_b(), p_147485_1_.func_151341_c());
/* 726 */     if (block == p_147485_1_.func_151337_f()) {
/* 727 */       return block.func_149696_a(this, p_147485_1_.func_151340_a(), p_147485_1_.func_151342_b(), p_147485_1_.func_151341_c(), p_147485_1_.func_151339_d(), p_147485_1_.func_151338_e());
/*     */     }
/* 729 */     return false;
/*     */   }
/*     */   
/*     */   public void func_73041_k() {
/* 733 */     this.field_73019_z.func_75759_a();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_72979_l() {
/* 738 */     boolean bool = func_72896_J();
/* 739 */     super.func_72979_l();
/*     */     
/* 741 */     if (this.field_73003_n != this.field_73004_o) {
/* 742 */       this.field_73061_a.func_71203_ab().func_148537_a((Packet)new S2BPacketChangeGameState(7, this.field_73004_o), this.field_73011_w.field_76574_g);
/*     */     }
/* 744 */     if (this.field_73018_p != this.field_73017_q) {
/* 745 */       this.field_73061_a.func_71203_ab().func_148537_a((Packet)new S2BPacketChangeGameState(8, this.field_73017_q), this.field_73011_w.field_76574_g);
/*     */     }
/*     */     
/* 748 */     if (bool != func_72896_J()) {
/* 749 */       if (bool) {
/* 750 */         this.field_73061_a.func_71203_ab().func_148540_a((Packet)new S2BPacketChangeGameState(2, 0.0F));
/*     */       } else {
/* 752 */         this.field_73061_a.func_71203_ab().func_148540_a((Packet)new S2BPacketChangeGameState(1, 0.0F));
/*     */       } 
/* 754 */       this.field_73061_a.func_71203_ab().func_148540_a((Packet)new S2BPacketChangeGameState(7, this.field_73004_o));
/* 755 */       this.field_73061_a.func_71203_ab().func_148540_a((Packet)new S2BPacketChangeGameState(8, this.field_73017_q));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected int func_152379_p() {
/* 761 */     return this.field_73061_a.func_71203_ab().func_72395_o();
/*     */   }
/*     */   
/*     */   public MinecraftServer func_73046_m() {
/* 765 */     return this.field_73061_a;
/*     */   }
/*     */   
/*     */   public EntityTracker func_73039_n() {
/* 769 */     return this.field_73062_L;
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
/*     */   public PlayerManager func_73040_p() {
/* 781 */     return this.field_73063_M;
/*     */   }
/*     */   
/*     */   public Teleporter func_85176_s() {
/* 785 */     return this.field_85177_Q;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_147487_a(String p_147487_1_, double p_147487_2_, double p_147487_4_, double p_147487_6_, int p_147487_8_, double p_147487_9_, double p_147487_11_, double p_147487_13_, double p_147487_15_) {
/* 793 */     S2APacketParticles s2APacketParticles = new S2APacketParticles(p_147487_1_, (float)p_147487_2_, (float)p_147487_4_, (float)p_147487_6_, (float)p_147487_9_, (float)p_147487_11_, (float)p_147487_13_, (float)p_147487_15_, p_147487_8_);
/*     */     
/* 795 */     for (byte b = 0; b < this.field_73010_i.size(); b++) {
/* 796 */       EntityPlayerMP entityPlayerMP = this.field_73010_i.get(b);
/* 797 */       ChunkCoordinates chunkCoordinates = entityPlayerMP.func_82114_b();
/* 798 */       double d1 = p_147487_2_ - chunkCoordinates.field_71574_a;
/* 799 */       double d2 = p_147487_4_ - chunkCoordinates.field_71572_b;
/* 800 */       double d3 = p_147487_6_ - chunkCoordinates.field_71573_c;
/* 801 */       double d4 = d1 * d1 + d2 * d2 + d3 * d3;
/*     */       
/* 803 */       if (d4 <= 256.0D)
/* 804 */         entityPlayerMP.field_71135_a.func_147359_a((Packet)s2APacketParticles); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\WorldServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */