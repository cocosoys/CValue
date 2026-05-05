/*      */ package net.minecraft.world;
/*      */ 
/*      */ import cpw.mods.fml.relauncher.Side;
/*      */ import cpw.mods.fml.relauncher.SideOnly;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Calendar;
/*      */ import java.util.Collection;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Random;
/*      */ import java.util.Set;
/*      */ import java.util.UUID;
/*      */ import java.util.concurrent.Callable;
/*      */ import net.minecraft.block.Block;
/*      */ import net.minecraft.block.BlockLiquid;
/*      */ import net.minecraft.block.material.Material;
/*      */ import net.minecraft.command.IEntitySelector;
/*      */ import net.minecraft.crash.CrashReport;
/*      */ import net.minecraft.crash.CrashReportCategory;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.EntityLiving;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.init.Blocks;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.nbt.NBTTagCompound;
/*      */ import net.minecraft.pathfinding.PathEntity;
/*      */ import net.minecraft.pathfinding.PathFinder;
/*      */ import net.minecraft.profiler.Profiler;
/*      */ import net.minecraft.scoreboard.Scoreboard;
/*      */ import net.minecraft.server.MinecraftServer;
/*      */ import net.minecraft.tileentity.TileEntity;
/*      */ import net.minecraft.util.AxisAlignedBB;
/*      */ import net.minecraft.util.ChunkCoordinates;
/*      */ import net.minecraft.util.Direction;
/*      */ import net.minecraft.util.Facing;
/*      */ import net.minecraft.util.MathHelper;
/*      */ import net.minecraft.util.MovingObjectPosition;
/*      */ import net.minecraft.util.ReportedException;
/*      */ import net.minecraft.util.Vec3;
/*      */ import net.minecraft.village.VillageCollection;
/*      */ import net.minecraft.village.VillageSiege;
/*      */ import net.minecraft.world.biome.BiomeGenBase;
/*      */ import net.minecraft.world.biome.WorldChunkManager;
/*      */ import net.minecraft.world.chunk.Chunk;
/*      */ import net.minecraft.world.chunk.IChunkProvider;
/*      */ import net.minecraft.world.storage.ISaveHandler;
/*      */ import net.minecraft.world.storage.MapStorage;
/*      */ import net.minecraft.world.storage.WorldInfo;
/*      */ 
/*      */ 
/*      */ 
/*      */ public abstract class World
/*      */   implements IBlockAccess
/*      */ {
/*      */   public boolean field_72999_e;
/*   57 */   public List field_72996_f = new ArrayList();
/*   58 */   protected List field_72997_g = new ArrayList();
/*   59 */   public List field_147482_g = new ArrayList();
/*   60 */   private List field_147484_a = new ArrayList();
/*   61 */   private List field_147483_b = new ArrayList();
/*   62 */   public List field_73010_i = new ArrayList();
/*   63 */   public List field_73007_j = new ArrayList();
/*      */   
/*   65 */   private long field_73001_c = 16777215L;
/*      */   
/*      */   public int field_73008_k;
/*      */   
/*   69 */   protected int field_73005_l = (new Random()).nextInt();
/*   70 */   protected final int field_73006_m = 1013904223; public float field_73003_n;
/*      */   public float field_73004_o;
/*      */   public float field_73018_p;
/*      */   public float field_73017_q;
/*      */   public int field_73016_r;
/*      */   public EnumDifficulty field_73013_u;
/*   76 */   public Random field_73012_v = new Random();
/*      */   
/*      */   public final WorldProvider field_73011_w;
/*   79 */   protected List field_73021_x = new ArrayList();
/*      */   
/*      */   protected IChunkProvider field_73020_y;
/*      */   
/*      */   protected final ISaveHandler field_73019_z;
/*      */   
/*      */   protected WorldInfo field_72986_A;
/*      */   
/*      */   public boolean field_72987_B;
/*      */   
/*      */   public MapStorage field_72988_C;
/*      */   public VillageCollection field_72982_D;
/*   91 */   protected final VillageSiege field_72983_E = new VillageSiege(this);
/*      */   public final Profiler field_72984_F;
/*   93 */   private final Calendar field_83016_L = Calendar.getInstance();
/*   94 */   protected Scoreboard field_96442_D = new Scoreboard();
/*      */   
/*      */   public boolean field_72995_K;
/*   97 */   protected Set field_72993_I = new HashSet();
/*   98 */   private int field_72990_M = this.field_73012_v.nextInt(12000);
/*      */ 
/*      */   
/*      */   protected boolean field_72985_G = true;
/*      */ 
/*      */   
/*      */   protected boolean field_72992_H = true;
/*      */   
/*  106 */   private ArrayList field_72998_d = new ArrayList();
/*      */   private boolean field_147481_N;
/*      */   int[] field_72994_J;
/*      */   private static final String __OBFID = "CL_00000140";
/*      */   
/*      */   public BiomeGenBase func_72807_a(int p_72807_1_, int p_72807_2_) {
/*  112 */     if (func_72899_e(p_72807_1_, 0, p_72807_2_)) {
/*  113 */       Chunk chunk = func_72938_d(p_72807_1_, p_72807_2_);
/*      */       try {
/*  115 */         return chunk.func_76591_a(p_72807_1_ & 0xF, p_72807_2_ & 0xF, this.field_73011_w.field_76578_c);
/*  116 */       } catch (Throwable throwable) {
/*  117 */         CrashReport crashReport = CrashReport.func_85055_a(throwable, "Getting biome");
/*  118 */         CrashReportCategory crashReportCategory = crashReport.func_85058_a("Coordinates of biome request");
/*      */         
/*  120 */         crashReportCategory.func_71500_a("Location", new Callable(this, p_72807_1_, p_72807_2_) { private static final String __OBFID = "CL_00000141";
/*      */               
/*      */               public String call() {
/*  123 */                 return CrashReportCategory.func_85071_a(this.field_151302_a, 0, this.field_151301_b);
/*      */               } }
/*      */           );
/*      */         
/*  127 */         throw new ReportedException(crashReport);
/*      */       } 
/*      */     } 
/*  130 */     return this.field_73011_w.field_76578_c.func_76935_a(p_72807_1_, p_72807_2_);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public WorldChunkManager func_72959_q() {
/*  136 */     return this.field_73011_w.field_76578_c;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void func_72963_a(WorldSettings p_72963_1_) {
/*  223 */     this.field_72986_A.func_76091_d(true);
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public void func_72974_f() {
/*  227 */     func_72950_A(8, 64, 8);
/*      */   }
/*      */ 
/*      */   
/*      */   public Block func_147474_b(int p_147474_1_, int p_147474_2_) {
/*  232 */     byte b = 63;
/*  233 */     while (!func_147437_c(p_147474_1_, b + 1, p_147474_2_)) {
/*  234 */       b++;
/*      */     }
/*  236 */     return func_147439_a(p_147474_1_, b, p_147474_2_);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Block func_147439_a(int p_147439_1_, int p_147439_2_, int p_147439_3_) {
/*  242 */     if (p_147439_1_ < -30000000 || p_147439_3_ < -30000000 || p_147439_1_ >= 30000000 || p_147439_3_ >= 30000000 || p_147439_2_ < 0 || p_147439_2_ >= 256) {
/*  243 */       return Blocks.field_150350_a;
/*      */     }
/*  245 */     Chunk chunk = null;
/*      */     
/*      */     try {
/*  248 */       chunk = func_72964_e(p_147439_1_ >> 4, p_147439_3_ >> 4);
/*  249 */       return chunk.func_150810_a(p_147439_1_ & 0xF, p_147439_2_, p_147439_3_ & 0xF);
/*  250 */     } catch (Throwable throwable) {
/*  251 */       CrashReport crashReport = CrashReport.func_85055_a(throwable, "Exception getting block type in world");
/*  252 */       CrashReportCategory crashReportCategory = crashReport.func_85058_a("Requested block coordinates");
/*      */       
/*  254 */       crashReportCategory.func_71507_a("Found chunk", Boolean.valueOf((chunk == null)));
/*  255 */       crashReportCategory.func_71507_a("Location", CrashReportCategory.func_85071_a(p_147439_1_, p_147439_2_, p_147439_3_));
/*      */       
/*  257 */       throw new ReportedException(crashReport);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean func_147437_c(int p_147437_1_, int p_147437_2_, int p_147437_3_) {
/*  272 */     return (func_147439_a(p_147437_1_, p_147437_2_, p_147437_3_).func_149688_o() == Material.field_151579_a);
/*      */   }
/*      */   
/*      */   public boolean func_72899_e(int p_72899_1_, int p_72899_2_, int p_72899_3_) {
/*  276 */     if (p_72899_2_ < 0 || p_72899_2_ >= 256) return false; 
/*  277 */     return func_72916_c(p_72899_1_ >> 4, p_72899_3_ >> 4);
/*      */   }
/*      */   
/*      */   public boolean func_72873_a(int p_72873_1_, int p_72873_2_, int p_72873_3_, int p_72873_4_) {
/*  281 */     return func_72904_c(p_72873_1_ - p_72873_4_, p_72873_2_ - p_72873_4_, p_72873_3_ - p_72873_4_, p_72873_1_ + p_72873_4_, p_72873_2_ + p_72873_4_, p_72873_3_ + p_72873_4_);
/*      */   }
/*      */   
/*      */   public boolean func_72904_c(int p_72904_1_, int p_72904_2_, int p_72904_3_, int p_72904_4_, int p_72904_5_, int p_72904_6_) {
/*  285 */     if (p_72904_5_ < 0 || p_72904_2_ >= 256) return false;
/*      */     
/*  287 */     p_72904_1_ >>= 4;
/*  288 */     p_72904_3_ >>= 4;
/*  289 */     p_72904_4_ >>= 4;
/*  290 */     p_72904_6_ >>= 4;
/*      */     
/*  292 */     for (int i = p_72904_1_; i <= p_72904_4_; i++) {
/*  293 */       for (int j = p_72904_3_; j <= p_72904_6_; j++) {
/*  294 */         if (!func_72916_c(i, j)) return false; 
/*      */       } 
/*  296 */     }  return true;
/*      */   }
/*      */   
/*      */   protected boolean func_72916_c(int p_72916_1_, int p_72916_2_) {
/*  300 */     return this.field_73020_y.func_73149_a(p_72916_1_, p_72916_2_);
/*      */   }
/*      */ 
/*      */   
/*      */   public Chunk func_72938_d(int p_72938_1_, int p_72938_2_) {
/*  305 */     return func_72964_e(p_72938_1_ >> 4, p_72938_2_ >> 4);
/*      */   }
/*      */ 
/*      */   
/*      */   public Chunk func_72964_e(int p_72964_1_, int p_72964_2_) {
/*  310 */     return this.field_73020_y.func_73154_d(p_72964_1_, p_72964_2_);
/*      */   }
/*      */   
/*      */   public boolean func_147465_d(int p_147465_1_, int p_147465_2_, int p_147465_3_, Block p_147465_4_, int p_147465_5_, int p_147465_6_) {
/*  314 */     if (p_147465_1_ < -30000000 || p_147465_3_ < -30000000 || p_147465_1_ >= 30000000 || p_147465_3_ >= 30000000) {
/*  315 */       return false;
/*      */     }
/*  317 */     if (p_147465_2_ < 0) return false; 
/*  318 */     if (p_147465_2_ >= 256) return false;
/*      */     
/*  320 */     Chunk chunk = func_72964_e(p_147465_1_ >> 4, p_147465_3_ >> 4);
/*  321 */     Block block = null;
/*  322 */     if ((p_147465_6_ & 0x1) != 0) {
/*  323 */       block = chunk.func_150810_a(p_147465_1_ & 0xF, p_147465_2_, p_147465_3_ & 0xF);
/*      */     }
/*      */     
/*  326 */     boolean bool = chunk.func_150807_a(p_147465_1_ & 0xF, p_147465_2_, p_147465_3_ & 0xF, p_147465_4_, p_147465_5_);
/*  327 */     this.field_72984_F.func_76320_a("checkLight");
/*  328 */     func_147451_t(p_147465_1_, p_147465_2_, p_147465_3_);
/*  329 */     this.field_72984_F.func_76319_b();
/*      */     
/*  331 */     if (bool) {
/*  332 */       if ((p_147465_6_ & 0x2) != 0 && (!this.field_72995_K || (p_147465_6_ & 0x4) == 0) && chunk.func_150802_k()) {
/*  333 */         func_147471_g(p_147465_1_, p_147465_2_, p_147465_3_);
/*      */       }
/*  335 */       if (!this.field_72995_K && (p_147465_6_ & 0x1) != 0) {
/*  336 */         func_147444_c(p_147465_1_, p_147465_2_, p_147465_3_, block);
/*  337 */         if (p_147465_4_.func_149740_M()) func_147453_f(p_147465_1_, p_147465_2_, p_147465_3_, p_147465_4_); 
/*      */       } 
/*      */     } 
/*  340 */     return bool;
/*      */   }
/*      */ 
/*      */   
/*      */   public int func_72805_g(int p_72805_1_, int p_72805_2_, int p_72805_3_) {
/*  345 */     if (p_72805_1_ < -30000000 || p_72805_3_ < -30000000 || p_72805_1_ >= 30000000 || p_72805_3_ >= 30000000) {
/*  346 */       return 0;
/*      */     }
/*  348 */     if (p_72805_2_ < 0) return 0; 
/*  349 */     if (p_72805_2_ >= 256) return 0; 
/*  350 */     Chunk chunk = func_72964_e(p_72805_1_ >> 4, p_72805_3_ >> 4);
/*  351 */     p_72805_1_ &= 0xF;
/*  352 */     p_72805_3_ &= 0xF;
/*  353 */     return chunk.func_76628_c(p_72805_1_, p_72805_2_, p_72805_3_);
/*      */   }
/*      */   
/*      */   public boolean func_72921_c(int p_72921_1_, int p_72921_2_, int p_72921_3_, int p_72921_4_, int p_72921_5_) {
/*  357 */     if (p_72921_1_ < -30000000 || p_72921_3_ < -30000000 || p_72921_1_ >= 30000000 || p_72921_3_ >= 30000000) {
/*  358 */       return false;
/*      */     }
/*  360 */     if (p_72921_2_ < 0) return false; 
/*  361 */     if (p_72921_2_ >= 256) return false; 
/*  362 */     Chunk chunk = func_72964_e(p_72921_1_ >> 4, p_72921_3_ >> 4);
/*  363 */     int i = p_72921_1_ & 0xF;
/*  364 */     int j = p_72921_3_ & 0xF;
/*  365 */     boolean bool = chunk.func_76589_b(i, p_72921_2_, j, p_72921_4_);
/*      */     
/*  367 */     if (bool) {
/*  368 */       Block block = chunk.func_150810_a(i, p_72921_2_, j);
/*  369 */       if ((p_72921_5_ & 0x2) != 0 && (!this.field_72995_K || (p_72921_5_ & 0x4) == 0) && chunk.func_150802_k()) {
/*  370 */         func_147471_g(p_72921_1_, p_72921_2_, p_72921_3_);
/*      */       }
/*  372 */       if (!this.field_72995_K && (p_72921_5_ & 0x1) != 0) {
/*  373 */         func_147444_c(p_72921_1_, p_72921_2_, p_72921_3_, block);
/*  374 */         if (block.func_149740_M()) func_147453_f(p_72921_1_, p_72921_2_, p_72921_3_, block); 
/*      */       } 
/*      */     } 
/*  377 */     return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean func_147468_f(int p_147468_1_, int p_147468_2_, int p_147468_3_) {
/*  389 */     return func_147465_d(p_147468_1_, p_147468_2_, p_147468_3_, Blocks.field_150350_a, 0, 3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean func_147480_a(int p_147480_1_, int p_147480_2_, int p_147480_3_, boolean p_147480_4_) {
/*  403 */     Block block = func_147439_a(p_147480_1_, p_147480_2_, p_147480_3_);
/*  404 */     if (block.func_149688_o() == Material.field_151579_a) {
/*  405 */       return false;
/*      */     }
/*      */     
/*  408 */     int i = func_72805_g(p_147480_1_, p_147480_2_, p_147480_3_);
/*  409 */     func_72926_e(2001, p_147480_1_, p_147480_2_, p_147480_3_, Block.func_149682_b(block) + (i << 12));
/*  410 */     if (p_147480_4_) {
/*  411 */       block.func_149697_b(this, p_147480_1_, p_147480_2_, p_147480_3_, i, 0);
/*      */     }
/*  413 */     return func_147465_d(p_147480_1_, p_147480_2_, p_147480_3_, Blocks.field_150350_a, 0, 3);
/*      */   }
/*      */   
/*      */   public boolean func_147449_b(int p_147449_1_, int p_147449_2_, int p_147449_3_, Block p_147449_4_) {
/*  417 */     return func_147465_d(p_147449_1_, p_147449_2_, p_147449_3_, p_147449_4_, 0, 3);
/*      */   }
/*      */   
/*      */   public void func_147471_g(int p_147471_1_, int p_147471_2_, int p_147471_3_) {
/*  421 */     for (byte b = 0; b < this.field_73021_x.size(); b++) {
/*  422 */       ((IWorldAccess)this.field_73021_x.get(b)).func_147586_a(p_147471_1_, p_147471_2_, p_147471_3_);
/*      */     }
/*      */   }
/*      */   
/*      */   public void func_147444_c(int p_147444_1_, int p_147444_2_, int p_147444_3_, Block p_147444_4_) {
/*  427 */     func_147459_d(p_147444_1_, p_147444_2_, p_147444_3_, p_147444_4_);
/*      */   }
/*      */   
/*      */   public void func_72975_g(int p_72975_1_, int p_72975_2_, int p_72975_3_, int p_72975_4_) {
/*  431 */     if (p_72975_3_ > p_72975_4_) {
/*  432 */       int i = p_72975_4_;
/*  433 */       p_72975_4_ = p_72975_3_;
/*  434 */       p_72975_3_ = i;
/*      */     } 
/*  436 */     if (!this.field_73011_w.field_76576_e) {
/*  437 */       for (int i = p_72975_3_; i <= p_72975_4_; i++) {
/*  438 */         func_147463_c(EnumSkyBlock.Sky, p_72975_1_, i, p_72975_2_);
/*      */       }
/*      */     }
/*  441 */     func_147458_c(p_72975_1_, p_72975_3_, p_72975_2_, p_72975_1_, p_72975_4_, p_72975_2_);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_147458_c(int p_147458_1_, int p_147458_2_, int p_147458_3_, int p_147458_4_, int p_147458_5_, int p_147458_6_) {
/*  451 */     for (byte b = 0; b < this.field_73021_x.size(); b++) {
/*  452 */       ((IWorldAccess)this.field_73021_x.get(b)).func_147585_a(p_147458_1_, p_147458_2_, p_147458_3_, p_147458_4_, p_147458_5_, p_147458_6_);
/*      */     }
/*      */   }
/*      */   
/*      */   public void func_147459_d(int p_147459_1_, int p_147459_2_, int p_147459_3_, Block p_147459_4_) {
/*  457 */     func_147460_e(p_147459_1_ - 1, p_147459_2_, p_147459_3_, p_147459_4_);
/*  458 */     func_147460_e(p_147459_1_ + 1, p_147459_2_, p_147459_3_, p_147459_4_);
/*  459 */     func_147460_e(p_147459_1_, p_147459_2_ - 1, p_147459_3_, p_147459_4_);
/*  460 */     func_147460_e(p_147459_1_, p_147459_2_ + 1, p_147459_3_, p_147459_4_);
/*  461 */     func_147460_e(p_147459_1_, p_147459_2_, p_147459_3_ - 1, p_147459_4_);
/*  462 */     func_147460_e(p_147459_1_, p_147459_2_, p_147459_3_ + 1, p_147459_4_);
/*      */   }
/*      */   
/*      */   public void func_147441_b(int p_147441_1_, int p_147441_2_, int p_147441_3_, Block p_147441_4_, int p_147441_5_) {
/*  466 */     if (p_147441_5_ != 4) func_147460_e(p_147441_1_ - 1, p_147441_2_, p_147441_3_, p_147441_4_); 
/*  467 */     if (p_147441_5_ != 5) func_147460_e(p_147441_1_ + 1, p_147441_2_, p_147441_3_, p_147441_4_); 
/*  468 */     if (p_147441_5_ != 0) func_147460_e(p_147441_1_, p_147441_2_ - 1, p_147441_3_, p_147441_4_); 
/*  469 */     if (p_147441_5_ != 1) func_147460_e(p_147441_1_, p_147441_2_ + 1, p_147441_3_, p_147441_4_); 
/*  470 */     if (p_147441_5_ != 2) func_147460_e(p_147441_1_, p_147441_2_, p_147441_3_ - 1, p_147441_4_); 
/*  471 */     if (p_147441_5_ != 3) func_147460_e(p_147441_1_, p_147441_2_, p_147441_3_ + 1, p_147441_4_); 
/*      */   }
/*      */   
/*      */   public void func_147460_e(int p_147460_1_, int p_147460_2_, int p_147460_3_, Block p_147460_4_) {
/*  475 */     if (this.field_72995_K)
/*  476 */       return;  Block block = func_147439_a(p_147460_1_, p_147460_2_, p_147460_3_);
/*      */     
/*      */     try {
/*  479 */       block.func_149695_a(this, p_147460_1_, p_147460_2_, p_147460_3_, p_147460_4_);
/*  480 */     } catch (Throwable throwable) {
/*  481 */       byte b; CrashReport crashReport = CrashReport.func_85055_a(throwable, "Exception while updating neighbours");
/*  482 */       CrashReportCategory crashReportCategory = crashReport.func_85058_a("Block being updated");
/*      */ 
/*      */       
/*      */       try {
/*  486 */         b = func_72805_g(p_147460_1_, p_147460_2_, p_147460_3_);
/*  487 */       } catch (Throwable throwable1) {
/*  488 */         b = -1;
/*      */       } 
/*      */       
/*  491 */       crashReportCategory.func_71500_a("Source block type", new Callable(this, p_147460_4_) { private static final String __OBFID = "CL_00000142";
/*      */             
/*      */             public String call() {
/*      */               try {
/*  495 */                 return String.format("ID #%d (%s // %s)", new Object[] { Integer.valueOf(Block.func_149682_b(this.field_151300_a)), this.field_151300_a.func_149739_a(), this.field_151300_a.getClass().getCanonicalName() });
/*  496 */               } catch (Throwable throwable) {
/*  497 */                 return "ID #" + Block.func_149682_b(this.field_151300_a);
/*      */               } 
/*      */             } }
/*      */         );
/*      */       
/*  502 */       CrashReportCategory.func_147153_a(crashReportCategory, p_147460_1_, p_147460_2_, p_147460_3_, block, b);
/*      */       
/*  504 */       throw new ReportedException(crashReport);
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean func_147477_a(int p_147477_1_, int p_147477_2_, int p_147477_3_, Block p_147477_4_) {
/*  509 */     return false;
/*      */   }
/*      */   
/*      */   public boolean func_72937_j(int p_72937_1_, int p_72937_2_, int p_72937_3_) {
/*  513 */     return func_72964_e(p_72937_1_ >> 4, p_72937_3_ >> 4).func_76619_d(p_72937_1_ & 0xF, p_72937_2_, p_72937_3_ & 0xF);
/*      */   }
/*      */   
/*      */   public int func_72883_k(int p_72883_1_, int p_72883_2_, int p_72883_3_) {
/*  517 */     if (p_72883_2_ < 0) return 0; 
/*  518 */     if (p_72883_2_ >= 256) p_72883_2_ = 255; 
/*  519 */     return func_72964_e(p_72883_1_ >> 4, p_72883_3_ >> 4).func_76629_c(p_72883_1_ & 0xF, p_72883_2_, p_72883_3_ & 0xF, 0);
/*      */   }
/*      */   
/*      */   public int func_72957_l(int p_72957_1_, int p_72957_2_, int p_72957_3_) {
/*  523 */     return func_72849_a(p_72957_1_, p_72957_2_, p_72957_3_, true);
/*      */   }
/*      */   
/*      */   public int func_72849_a(int p_72849_1_, int p_72849_2_, int p_72849_3_, boolean p_72849_4_) {
/*  527 */     if (p_72849_1_ < -30000000 || p_72849_3_ < -30000000 || p_72849_1_ >= 30000000 || p_72849_3_ >= 30000000) {
/*  528 */       return 15;
/*      */     }
/*      */     
/*  531 */     if (p_72849_4_ && 
/*  532 */       func_147439_a(p_72849_1_, p_72849_2_, p_72849_3_).func_149710_n()) {
/*  533 */       int i = func_72849_a(p_72849_1_, p_72849_2_ + 1, p_72849_3_, false);
/*  534 */       int j = func_72849_a(p_72849_1_ + 1, p_72849_2_, p_72849_3_, false);
/*  535 */       int k = func_72849_a(p_72849_1_ - 1, p_72849_2_, p_72849_3_, false);
/*  536 */       int m = func_72849_a(p_72849_1_, p_72849_2_, p_72849_3_ + 1, false);
/*  537 */       int n = func_72849_a(p_72849_1_, p_72849_2_, p_72849_3_ - 1, false);
/*  538 */       if (j > i) i = j; 
/*  539 */       if (k > i) i = k; 
/*  540 */       if (m > i) i = m; 
/*  541 */       if (n > i) i = n; 
/*  542 */       return i;
/*      */     } 
/*      */ 
/*      */     
/*  546 */     if (p_72849_2_ < 0) return 0; 
/*  547 */     if (p_72849_2_ >= 256) p_72849_2_ = 255;
/*      */     
/*  549 */     Chunk chunk = func_72964_e(p_72849_1_ >> 4, p_72849_3_ >> 4);
/*  550 */     p_72849_1_ &= 0xF;
/*  551 */     p_72849_3_ &= 0xF;
/*  552 */     return chunk.func_76629_c(p_72849_1_, p_72849_2_, p_72849_3_, this.field_73008_k);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int func_72976_f(int p_72976_1_, int p_72976_2_) {
/*  571 */     if (p_72976_1_ < -30000000 || p_72976_2_ < -30000000 || p_72976_1_ >= 30000000 || p_72976_2_ >= 30000000) {
/*  572 */       return 64;
/*      */     }
/*  574 */     if (!func_72916_c(p_72976_1_ >> 4, p_72976_2_ >> 4)) return 0;
/*      */     
/*  576 */     Chunk chunk = func_72964_e(p_72976_1_ >> 4, p_72976_2_ >> 4);
/*  577 */     return chunk.func_76611_b(p_72976_1_ & 0xF, p_72976_2_ & 0xF);
/*      */   }
/*      */   
/*      */   public int func_82734_g(int p_82734_1_, int p_82734_2_) {
/*  581 */     if (p_82734_1_ < -30000000 || p_82734_2_ < -30000000 || p_82734_1_ >= 30000000 || p_82734_2_ >= 30000000) {
/*  582 */       return 64;
/*      */     }
/*  584 */     if (!func_72916_c(p_82734_1_ >> 4, p_82734_2_ >> 4)) return 0;
/*      */     
/*  586 */     Chunk chunk = func_72964_e(p_82734_1_ >> 4, p_82734_2_ >> 4);
/*  587 */     return chunk.field_82912_p;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public int func_72925_a(EnumSkyBlock p_72925_1_, int p_72925_2_, int p_72925_3_, int p_72925_4_) {
/*  608 */     if (this.field_73011_w.field_76576_e && p_72925_1_ == EnumSkyBlock.Sky) return 0;
/*      */     
/*  610 */     if (p_72925_3_ < 0) p_72925_3_ = 0; 
/*  611 */     if (p_72925_3_ >= 256) {
/*  612 */       return p_72925_1_.field_77198_c;
/*      */     }
/*  614 */     if (p_72925_2_ < -30000000 || p_72925_4_ < -30000000 || p_72925_2_ >= 30000000 || p_72925_4_ >= 30000000) {
/*  615 */       return p_72925_1_.field_77198_c;
/*      */     }
/*  617 */     int i = p_72925_2_ >> 4;
/*  618 */     int j = p_72925_4_ >> 4;
/*  619 */     if (!func_72916_c(i, j)) return p_72925_1_.field_77198_c;
/*      */     
/*  621 */     if (func_147439_a(p_72925_2_, p_72925_3_, p_72925_4_).func_149710_n()) {
/*  622 */       int k = func_72972_b(p_72925_1_, p_72925_2_, p_72925_3_ + 1, p_72925_4_);
/*  623 */       int m = func_72972_b(p_72925_1_, p_72925_2_ + 1, p_72925_3_, p_72925_4_);
/*  624 */       int n = func_72972_b(p_72925_1_, p_72925_2_ - 1, p_72925_3_, p_72925_4_);
/*  625 */       int i1 = func_72972_b(p_72925_1_, p_72925_2_, p_72925_3_, p_72925_4_ + 1);
/*  626 */       int i2 = func_72972_b(p_72925_1_, p_72925_2_, p_72925_3_, p_72925_4_ - 1);
/*  627 */       if (m > k) k = m; 
/*  628 */       if (n > k) k = n; 
/*  629 */       if (i1 > k) k = i1; 
/*  630 */       if (i2 > k) k = i2; 
/*  631 */       return k;
/*      */     } 
/*      */     
/*  634 */     Chunk chunk = func_72964_e(i, j);
/*  635 */     return chunk.func_76614_a(p_72925_1_, p_72925_2_ & 0xF, p_72925_3_, p_72925_4_ & 0xF);
/*      */   }
/*      */ 
/*      */   
/*      */   public int func_72972_b(EnumSkyBlock p_72972_1_, int p_72972_2_, int p_72972_3_, int p_72972_4_) {
/*  640 */     if (p_72972_3_ < 0) p_72972_3_ = 0; 
/*  641 */     if (p_72972_3_ >= 256) p_72972_3_ = 255; 
/*  642 */     if (p_72972_2_ < -30000000 || p_72972_4_ < -30000000 || p_72972_2_ >= 30000000 || p_72972_4_ >= 30000000) {
/*  643 */       return p_72972_1_.field_77198_c;
/*      */     }
/*  645 */     int i = p_72972_2_ >> 4;
/*  646 */     int j = p_72972_4_ >> 4;
/*  647 */     if (!func_72916_c(i, j)) return p_72972_1_.field_77198_c; 
/*  648 */     Chunk chunk = func_72964_e(i, j);
/*  649 */     return chunk.func_76614_a(p_72972_1_, p_72972_2_ & 0xF, p_72972_3_, p_72972_4_ & 0xF);
/*      */   }
/*      */   
/*      */   public void func_72915_b(EnumSkyBlock p_72915_1_, int p_72915_2_, int p_72915_3_, int p_72915_4_, int p_72915_5_) {
/*  653 */     if (p_72915_2_ < -30000000 || p_72915_4_ < -30000000 || p_72915_2_ >= 30000000 || p_72915_4_ >= 30000000) {
/*      */       return;
/*      */     }
/*  656 */     if (p_72915_3_ < 0)
/*  657 */       return;  if (p_72915_3_ >= 256)
/*  658 */       return;  if (!func_72916_c(p_72915_2_ >> 4, p_72915_4_ >> 4))
/*  659 */       return;  Chunk chunk = func_72964_e(p_72915_2_ >> 4, p_72915_4_ >> 4);
/*  660 */     chunk.func_76633_a(p_72915_1_, p_72915_2_ & 0xF, p_72915_3_, p_72915_4_ & 0xF, p_72915_5_);
/*  661 */     for (byte b = 0; b < this.field_73021_x.size(); b++) {
/*  662 */       ((IWorldAccess)this.field_73021_x.get(b)).func_147588_b(p_72915_2_, p_72915_3_, p_72915_4_);
/*      */     }
/*      */   }
/*      */   
/*      */   public void func_147479_m(int p_147479_1_, int p_147479_2_, int p_147479_3_) {
/*  667 */     for (byte b = 0; b < this.field_73021_x.size(); b++) {
/*  668 */       ((IWorldAccess)this.field_73021_x.get(b)).func_147588_b(p_147479_1_, p_147479_2_, p_147479_3_);
/*      */     }
/*      */   }
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public int func_72802_i(int p_72802_1_, int p_72802_2_, int p_72802_3_, int p_72802_4_) {
/*  674 */     int i = func_72925_a(EnumSkyBlock.Sky, p_72802_1_, p_72802_2_, p_72802_3_);
/*  675 */     int j = func_72925_a(EnumSkyBlock.Block, p_72802_1_, p_72802_2_, p_72802_3_);
/*  676 */     if (j < p_72802_4_) j = p_72802_4_; 
/*  677 */     return i << 20 | j << 4;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public float func_72801_o(int p_72801_1_, int p_72801_2_, int p_72801_3_) {
/*  689 */     return this.field_73011_w.field_76573_f[func_72957_l(p_72801_1_, p_72801_2_, p_72801_3_)];
/*      */   }
/*      */   
/*      */   public boolean func_72935_r() {
/*  693 */     return (this.field_73008_k < 4);
/*      */   }
/*      */   
/*      */   public MovingObjectPosition func_72933_a(Vec3 p_72933_1_, Vec3 p_72933_2_) {
/*  697 */     return func_147447_a(p_72933_1_, p_72933_2_, false, false, false);
/*      */   }
/*      */   
/*      */   public MovingObjectPosition func_72901_a(Vec3 p_72901_1_, Vec3 p_72901_2_, boolean p_72901_3_) {
/*  701 */     return func_147447_a(p_72901_1_, p_72901_2_, p_72901_3_, false, false);
/*      */   }
/*      */   public MovingObjectPosition func_147447_a(Vec3 p_147447_1_, Vec3 p_147447_2_, boolean p_147447_3_, boolean p_147447_4_, boolean p_147447_5_) {
/*      */     MovingObjectPosition movingObjectPosition;
/*  705 */     if (Double.isNaN(p_147447_1_.field_72450_a) || Double.isNaN(p_147447_1_.field_72448_b) || Double.isNaN(p_147447_1_.field_72449_c)) return null; 
/*  706 */     if (Double.isNaN(p_147447_2_.field_72450_a) || Double.isNaN(p_147447_2_.field_72448_b) || Double.isNaN(p_147447_2_.field_72449_c)) return null;
/*      */     
/*  708 */     int i = MathHelper.func_76128_c(p_147447_2_.field_72450_a);
/*  709 */     int j = MathHelper.func_76128_c(p_147447_2_.field_72448_b);
/*  710 */     int k = MathHelper.func_76128_c(p_147447_2_.field_72449_c);
/*      */     
/*  712 */     int m = MathHelper.func_76128_c(p_147447_1_.field_72450_a);
/*  713 */     int n = MathHelper.func_76128_c(p_147447_1_.field_72448_b);
/*  714 */     int i1 = MathHelper.func_76128_c(p_147447_1_.field_72449_c);
/*      */ 
/*      */     
/*  717 */     Block block = func_147439_a(m, n, i1);
/*  718 */     int i2 = func_72805_g(m, n, i1);
/*  719 */     if (!p_147447_4_ || block.func_149668_a(this, m, n, i1) != null)
/*      */     {
/*  721 */       if (block.func_149678_a(i2, p_147447_3_)) {
/*  722 */         MovingObjectPosition movingObjectPosition1 = block.func_149731_a(this, m, n, i1, p_147447_1_, p_147447_2_);
/*  723 */         if (movingObjectPosition1 != null) return movingObjectPosition1;
/*      */       
/*      */       } 
/*      */     }
/*  727 */     block = null;
/*      */     
/*  729 */     i2 = 200;
/*  730 */     while (i2-- >= 0) {
/*  731 */       if (Double.isNaN(p_147447_1_.field_72450_a) || Double.isNaN(p_147447_1_.field_72448_b) || Double.isNaN(p_147447_1_.field_72449_c)) return null; 
/*  732 */       if (m == i && n == j && i1 == k) {
/*  733 */         return p_147447_5_ ? (MovingObjectPosition)block : null;
/*      */       }
/*      */       
/*  736 */       boolean bool1 = true;
/*  737 */       boolean bool2 = true;
/*  738 */       boolean bool3 = true;
/*      */       
/*  740 */       double d1 = 999.0D;
/*  741 */       double d2 = 999.0D;
/*  742 */       double d3 = 999.0D;
/*      */       
/*  744 */       if (i > m) { d1 = m + 1.0D; }
/*  745 */       else if (i < m) { d1 = m + 0.0D; }
/*  746 */       else { bool1 = false; }
/*      */       
/*  748 */       if (j > n) { d2 = n + 1.0D; }
/*  749 */       else if (j < n) { d2 = n + 0.0D; }
/*  750 */       else { bool2 = false; }
/*      */       
/*  752 */       if (k > i1) { d3 = i1 + 1.0D; }
/*  753 */       else if (k < i1) { d3 = i1 + 0.0D; }
/*  754 */       else { bool3 = false; }
/*      */       
/*  756 */       double d4 = 999.0D;
/*  757 */       double d5 = 999.0D;
/*  758 */       double d6 = 999.0D;
/*      */       
/*  760 */       double d7 = p_147447_2_.field_72450_a - p_147447_1_.field_72450_a;
/*  761 */       double d8 = p_147447_2_.field_72448_b - p_147447_1_.field_72448_b;
/*  762 */       double d9 = p_147447_2_.field_72449_c - p_147447_1_.field_72449_c;
/*      */       
/*  764 */       if (bool1) d4 = (d1 - p_147447_1_.field_72450_a) / d7; 
/*  765 */       if (bool2) d5 = (d2 - p_147447_1_.field_72448_b) / d8; 
/*  766 */       if (bool3) d6 = (d3 - p_147447_1_.field_72449_c) / d9;
/*      */       
/*  768 */       byte b = 0;
/*  769 */       if (d4 < d5 && d4 < d6) {
/*  770 */         if (i > m) { b = 4; }
/*  771 */         else { b = 5; }
/*      */         
/*  773 */         p_147447_1_.field_72450_a = d1;
/*  774 */         p_147447_1_.field_72448_b += d8 * d4;
/*  775 */         p_147447_1_.field_72449_c += d9 * d4;
/*  776 */       } else if (d5 < d6) {
/*  777 */         if (j > n) { b = 0; }
/*  778 */         else { b = 1; }
/*      */         
/*  780 */         p_147447_1_.field_72450_a += d7 * d5;
/*  781 */         p_147447_1_.field_72448_b = d2;
/*  782 */         p_147447_1_.field_72449_c += d9 * d5;
/*      */       } else {
/*  784 */         if (k > i1) { b = 2; }
/*  785 */         else { b = 3; }
/*      */         
/*  787 */         p_147447_1_.field_72450_a += d7 * d6;
/*  788 */         p_147447_1_.field_72448_b += d8 * d6;
/*  789 */         p_147447_1_.field_72449_c = d3;
/*      */       } 
/*      */       
/*  792 */       Vec3 vec3 = Vec3.func_72443_a(p_147447_1_.field_72450_a, p_147447_1_.field_72448_b, p_147447_1_.field_72449_c);
/*  793 */       m = (int)(vec3.field_72450_a = MathHelper.func_76128_c(p_147447_1_.field_72450_a));
/*  794 */       if (b == 5) {
/*  795 */         m--;
/*  796 */         vec3.field_72450_a++;
/*      */       } 
/*  798 */       n = (int)(vec3.field_72448_b = MathHelper.func_76128_c(p_147447_1_.field_72448_b));
/*  799 */       if (b == 1) {
/*  800 */         n--;
/*  801 */         vec3.field_72448_b++;
/*      */       } 
/*  803 */       i1 = (int)(vec3.field_72449_c = MathHelper.func_76128_c(p_147447_1_.field_72449_c));
/*  804 */       if (b == 3) {
/*  805 */         i1--;
/*  806 */         vec3.field_72449_c++;
/*      */       } 
/*      */       
/*  809 */       Block block1 = func_147439_a(m, n, i1);
/*  810 */       int i3 = func_72805_g(m, n, i1);
/*  811 */       if (p_147447_4_ && block1.func_149668_a(this, m, n, i1) == null)
/*      */         continue; 
/*  813 */       if (block1.func_149678_a(i3, p_147447_3_)) {
/*  814 */         MovingObjectPosition movingObjectPosition1 = block1.func_149731_a(this, m, n, i1, p_147447_1_, p_147447_2_);
/*  815 */         if (movingObjectPosition1 != null) return movingObjectPosition1;  continue;
/*      */       } 
/*  817 */       movingObjectPosition = new MovingObjectPosition(m, n, i1, b, p_147447_1_, false);
/*      */     } 
/*      */     
/*  820 */     return p_147447_5_ ? movingObjectPosition : null;
/*      */   }
/*      */   
/*      */   public void func_72956_a(Entity p_72956_1_, String p_72956_2_, float p_72956_3_, float p_72956_4_) {
/*  824 */     for (byte b = 0; b < this.field_73021_x.size(); b++) {
/*  825 */       ((IWorldAccess)this.field_73021_x.get(b)).func_72704_a(p_72956_2_, p_72956_1_.field_70165_t, p_72956_1_.field_70163_u - p_72956_1_.field_70129_M, p_72956_1_.field_70161_v, p_72956_3_, p_72956_4_);
/*      */     }
/*      */   }
/*      */   
/*      */   public void func_85173_a(EntityPlayer p_85173_1_, String p_85173_2_, float p_85173_3_, float p_85173_4_) {
/*  830 */     for (byte b = 0; b < this.field_73021_x.size(); b++) {
/*  831 */       ((IWorldAccess)this.field_73021_x.get(b)).func_85102_a(p_85173_1_, p_85173_2_, p_85173_1_.field_70165_t, p_85173_1_.field_70163_u - p_85173_1_.field_70129_M, p_85173_1_.field_70161_v, p_85173_3_, p_85173_4_);
/*      */     }
/*      */   }
/*      */   
/*      */   public void func_72908_a(double p_72908_1_, double p_72908_3_, double p_72908_5_, String p_72908_7_, float p_72908_8_, float p_72908_9_) {
/*  836 */     for (byte b = 0; b < this.field_73021_x.size(); b++) {
/*  837 */       ((IWorldAccess)this.field_73021_x.get(b)).func_72704_a(p_72908_7_, p_72908_1_, p_72908_3_, p_72908_5_, p_72908_8_, p_72908_9_);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_72980_b(double p_72980_1_, double p_72980_3_, double p_72980_5_, String p_72980_7_, float p_72980_8_, float p_72980_9_, boolean p_72980_10_) {}
/*      */   
/*      */   public void func_72934_a(String p_72934_1_, int p_72934_2_, int p_72934_3_, int p_72934_4_) {
/*  845 */     for (byte b = 0; b < this.field_73021_x.size(); b++) {
/*  846 */       ((IWorldAccess)this.field_73021_x.get(b)).func_72702_a(p_72934_1_, p_72934_2_, p_72934_3_, p_72934_4_);
/*      */     }
/*      */   }
/*      */   
/*      */   public void func_72869_a(String p_72869_1_, double p_72869_2_, double p_72869_4_, double p_72869_6_, double p_72869_8_, double p_72869_10_, double p_72869_12_) {
/*  851 */     for (byte b = 0; b < this.field_73021_x.size(); b++)
/*  852 */       ((IWorldAccess)this.field_73021_x.get(b)).func_72708_a(p_72869_1_, p_72869_2_, p_72869_4_, p_72869_6_, p_72869_8_, p_72869_10_, p_72869_12_); 
/*      */   }
/*      */   
/*      */   public boolean func_72942_c(Entity p_72942_1_) {
/*  856 */     this.field_73007_j.add(p_72942_1_);
/*  857 */     return true;
/*      */   }
/*      */   
/*      */   public boolean func_72838_d(Entity p_72838_1_) {
/*  861 */     int i = MathHelper.func_76128_c(p_72838_1_.field_70165_t / 16.0D);
/*  862 */     int j = MathHelper.func_76128_c(p_72838_1_.field_70161_v / 16.0D);
/*      */     
/*  864 */     boolean bool = p_72838_1_.field_98038_p;
/*  865 */     if (p_72838_1_ instanceof EntityPlayer) {
/*  866 */       bool = true;
/*      */     }
/*      */     
/*  869 */     if (bool || func_72916_c(i, j)) {
/*  870 */       if (p_72838_1_ instanceof EntityPlayer) {
/*  871 */         EntityPlayer entityPlayer = (EntityPlayer)p_72838_1_;
/*  872 */         this.field_73010_i.add(entityPlayer);
/*  873 */         func_72854_c();
/*      */       } 
/*  875 */       func_72964_e(i, j).func_76612_a(p_72838_1_);
/*  876 */       this.field_72996_f.add(p_72838_1_);
/*  877 */       func_72923_a(p_72838_1_);
/*  878 */       return true;
/*      */     } 
/*  880 */     return false;
/*      */   }
/*      */   
/*      */   public void func_72923_a(Entity p_72923_1_) {
/*  884 */     for (byte b = 0; b < this.field_73021_x.size(); b++) {
/*  885 */       ((IWorldAccess)this.field_73021_x.get(b)).func_72703_a(p_72923_1_);
/*      */     }
/*      */   }
/*      */   
/*      */   public void func_72847_b(Entity p_72847_1_) {
/*  890 */     for (byte b = 0; b < this.field_73021_x.size(); b++) {
/*  891 */       ((IWorldAccess)this.field_73021_x.get(b)).func_72709_b(p_72847_1_);
/*      */     }
/*      */   }
/*      */   
/*      */   public void func_72900_e(Entity p_72900_1_) {
/*  896 */     if (p_72900_1_.field_70153_n != null) {
/*  897 */       p_72900_1_.field_70153_n.func_70078_a(null);
/*      */     }
/*  899 */     if (p_72900_1_.field_70154_o != null) {
/*  900 */       p_72900_1_.func_70078_a(null);
/*      */     }
/*  902 */     p_72900_1_.func_70106_y();
/*  903 */     if (p_72900_1_ instanceof EntityPlayer) {
/*  904 */       this.field_73010_i.remove(p_72900_1_);
/*  905 */       func_72854_c();
/*  906 */       func_72847_b(p_72900_1_);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void func_72973_f(Entity p_72973_1_) {
/*  911 */     p_72973_1_.func_70106_y();
/*      */     
/*  913 */     if (p_72973_1_ instanceof EntityPlayer) {
/*  914 */       this.field_73010_i.remove(p_72973_1_);
/*  915 */       func_72854_c();
/*      */     } 
/*      */     
/*  918 */     int i = p_72973_1_.field_70176_ah;
/*  919 */     int j = p_72973_1_.field_70164_aj;
/*  920 */     if (p_72973_1_.field_70175_ag && func_72916_c(i, j)) {
/*  921 */       func_72964_e(i, j).func_76622_b(p_72973_1_);
/*      */     }
/*      */     
/*  924 */     this.field_72996_f.remove(p_72973_1_);
/*  925 */     func_72847_b(p_72973_1_);
/*      */   }
/*      */   
/*      */   public void func_72954_a(IWorldAccess p_72954_1_) {
/*  929 */     this.field_73021_x.add(p_72954_1_);
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public void func_72848_b(IWorldAccess p_72848_1_) {
/*  933 */     this.field_73021_x.remove(p_72848_1_);
/*      */   }
/*      */ 
/*      */   
/*      */   public List func_72945_a(Entity p_72945_1_, AxisAlignedBB p_72945_2_) {
/*  938 */     this.field_72998_d.clear();
/*  939 */     int i = MathHelper.func_76128_c(p_72945_2_.field_72340_a);
/*  940 */     int j = MathHelper.func_76128_c(p_72945_2_.field_72336_d + 1.0D);
/*  941 */     int k = MathHelper.func_76128_c(p_72945_2_.field_72338_b);
/*  942 */     int m = MathHelper.func_76128_c(p_72945_2_.field_72337_e + 1.0D);
/*  943 */     int n = MathHelper.func_76128_c(p_72945_2_.field_72339_c);
/*  944 */     int i1 = MathHelper.func_76128_c(p_72945_2_.field_72334_f + 1.0D);
/*      */     
/*  946 */     for (int i2 = i; i2 < j; i2++) {
/*  947 */       for (int i3 = n; i3 < i1; i3++) {
/*  948 */         if (func_72899_e(i2, 64, i3)) {
/*  949 */           for (int i4 = k - 1; i4 < m; i4++) {
/*      */             Block block;
/*      */ 
/*      */             
/*  953 */             if (i2 < -30000000 || i2 >= 30000000 || i3 < -30000000 || i3 >= 30000000) {
/*  954 */               block = Blocks.field_150348_b;
/*      */             } else {
/*  956 */               block = func_147439_a(i2, i4, i3);
/*      */             } 
/*  958 */             block.func_149743_a(this, i2, i4, i3, p_72945_2_, this.field_72998_d, p_72945_1_);
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } 
/*  963 */     double d = 0.25D;
/*  964 */     List<Entity> list = func_72839_b(p_72945_1_, p_72945_2_.func_72314_b(d, d, d));
/*  965 */     for (byte b = 0; b < list.size(); b++) {
/*  966 */       AxisAlignedBB axisAlignedBB = ((Entity)list.get(b)).func_70046_E();
/*  967 */       if (axisAlignedBB != null && axisAlignedBB.func_72326_a(p_72945_2_)) {
/*  968 */         this.field_72998_d.add(axisAlignedBB);
/*      */       }
/*      */       
/*  971 */       axisAlignedBB = p_72945_1_.func_70114_g(list.get(b));
/*  972 */       if (axisAlignedBB != null && axisAlignedBB.func_72326_a(p_72945_2_)) {
/*  973 */         this.field_72998_d.add(axisAlignedBB);
/*      */       }
/*      */     } 
/*      */     
/*  977 */     return this.field_72998_d;
/*      */   }
/*      */ 
/*      */   
/*      */   public List func_147461_a(AxisAlignedBB p_147461_1_) {
/*  982 */     this.field_72998_d.clear();
/*  983 */     int i = MathHelper.func_76128_c(p_147461_1_.field_72340_a);
/*  984 */     int j = MathHelper.func_76128_c(p_147461_1_.field_72336_d + 1.0D);
/*  985 */     int k = MathHelper.func_76128_c(p_147461_1_.field_72338_b);
/*  986 */     int m = MathHelper.func_76128_c(p_147461_1_.field_72337_e + 1.0D);
/*  987 */     int n = MathHelper.func_76128_c(p_147461_1_.field_72339_c);
/*  988 */     int i1 = MathHelper.func_76128_c(p_147461_1_.field_72334_f + 1.0D);
/*      */     
/*  990 */     for (int i2 = i; i2 < j; i2++) {
/*  991 */       for (int i3 = n; i3 < i1; i3++) {
/*  992 */         if (func_72899_e(i2, 64, i3)) {
/*  993 */           for (int i4 = k - 1; i4 < m; i4++) {
/*      */             Block block;
/*  995 */             if (i2 < -30000000 || i2 >= 30000000 || i3 < -30000000 || i3 >= 30000000) {
/*  996 */               block = Blocks.field_150357_h;
/*      */             } else {
/*  998 */               block = func_147439_a(i2, i4, i3);
/*      */             } 
/* 1000 */             block.func_149743_a(this, i2, i4, i3, p_147461_1_, this.field_72998_d, null);
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 1006 */     return this.field_72998_d;
/*      */   }
/*      */   
/*      */   public int func_72967_a(float p_72967_1_) {
/* 1010 */     float f1 = func_72826_c(p_72967_1_);
/* 1011 */     float f2 = 1.0F - MathHelper.func_76134_b(f1 * 3.1415927F * 2.0F) * 2.0F + 0.5F;
/* 1012 */     if (f2 < 0.0F) f2 = 0.0F; 
/* 1013 */     if (f2 > 1.0F) f2 = 1.0F; 
/* 1014 */     f2 = 1.0F - f2;
/* 1015 */     f2 = (float)(f2 * (1.0D - (func_72867_j(p_72967_1_) * 5.0F) / 16.0D));
/* 1016 */     f2 = (float)(f2 * (1.0D - (func_72819_i(p_72967_1_) * 5.0F) / 16.0D));
/* 1017 */     f2 = 1.0F - f2;
/* 1018 */     return (int)(f2 * 11.0F);
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public float func_72971_b(float p_72971_1_) {
/* 1022 */     float f1 = func_72826_c(p_72971_1_);
/*      */     
/* 1024 */     float f2 = 1.0F - MathHelper.func_76134_b(f1 * 3.1415927F * 2.0F) * 2.0F + 0.2F;
/* 1025 */     if (f2 < 0.0F) f2 = 0.0F; 
/* 1026 */     if (f2 > 1.0F) f2 = 1.0F;
/*      */     
/* 1028 */     f2 = 1.0F - f2;
/*      */     
/* 1030 */     f2 = (float)(f2 * (1.0D - (func_72867_j(p_72971_1_) * 5.0F) / 16.0D));
/* 1031 */     f2 = (float)(f2 * (1.0D - (func_72819_i(p_72971_1_) * 5.0F) / 16.0D));
/*      */     
/* 1033 */     return f2 * 0.8F + 0.2F;
/*      */   }
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public Vec3 func_72833_a(Entity p_72833_1_, float p_72833_2_) {
/* 1038 */     float f1 = func_72826_c(p_72833_2_);
/*      */     
/* 1040 */     float f2 = MathHelper.func_76134_b(f1 * 3.1415927F * 2.0F) * 2.0F + 0.5F;
/* 1041 */     if (f2 < 0.0F) f2 = 0.0F; 
/* 1042 */     if (f2 > 1.0F) f2 = 1.0F;
/*      */     
/* 1044 */     int i = MathHelper.func_76128_c(p_72833_1_.field_70165_t);
/* 1045 */     int j = MathHelper.func_76128_c(p_72833_1_.field_70163_u);
/* 1046 */     int k = MathHelper.func_76128_c(p_72833_1_.field_70161_v);
/* 1047 */     BiomeGenBase biomeGenBase = func_72807_a(i, k);
/* 1048 */     float f3 = biomeGenBase.func_150564_a(i, j, k);
/* 1049 */     int m = biomeGenBase.func_76731_a(f3);
/*      */     
/* 1051 */     float f4 = (m >> 16 & 0xFF) / 255.0F;
/* 1052 */     float f5 = (m >> 8 & 0xFF) / 255.0F;
/* 1053 */     float f6 = (m & 0xFF) / 255.0F;
/* 1054 */     f4 *= f2;
/* 1055 */     f5 *= f2;
/* 1056 */     f6 *= f2;
/*      */     
/* 1058 */     float f7 = func_72867_j(p_72833_2_);
/* 1059 */     if (f7 > 0.0F) {
/* 1060 */       float f9 = (f4 * 0.3F + f5 * 0.59F + f6 * 0.11F) * 0.6F;
/*      */       
/* 1062 */       float f10 = 1.0F - f7 * 0.75F;
/* 1063 */       f4 = f4 * f10 + f9 * (1.0F - f10);
/* 1064 */       f5 = f5 * f10 + f9 * (1.0F - f10);
/* 1065 */       f6 = f6 * f10 + f9 * (1.0F - f10);
/*      */     } 
/* 1067 */     float f8 = func_72819_i(p_72833_2_);
/* 1068 */     if (f8 > 0.0F) {
/* 1069 */       float f9 = (f4 * 0.3F + f5 * 0.59F + f6 * 0.11F) * 0.2F;
/*      */       
/* 1071 */       float f10 = 1.0F - f8 * 0.75F;
/* 1072 */       f4 = f4 * f10 + f9 * (1.0F - f10);
/* 1073 */       f5 = f5 * f10 + f9 * (1.0F - f10);
/* 1074 */       f6 = f6 * f10 + f9 * (1.0F - f10);
/*      */     } 
/*      */     
/* 1077 */     if (this.field_73016_r > 0) {
/* 1078 */       float f = this.field_73016_r - p_72833_2_;
/* 1079 */       if (f > 1.0F) f = 1.0F; 
/* 1080 */       f *= 0.45F;
/* 1081 */       f4 = f4 * (1.0F - f) + 0.8F * f;
/* 1082 */       f5 = f5 * (1.0F - f) + 0.8F * f;
/* 1083 */       f6 = f6 * (1.0F - f) + 1.0F * f;
/*      */     } 
/*      */     
/* 1086 */     return Vec3.func_72443_a(f4, f5, f6);
/*      */   }
/*      */   
/*      */   public float func_72826_c(float p_72826_1_) {
/* 1090 */     return this.field_73011_w.func_76563_a(this.field_72986_A.func_76073_f(), p_72826_1_);
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public int func_72853_d() {
/* 1094 */     return this.field_73011_w.func_76559_b(this.field_72986_A.func_76073_f());
/*      */   }
/*      */   
/*      */   public float func_130001_d() {
/* 1098 */     return WorldProvider.field_111203_a[this.field_73011_w.func_76559_b(this.field_72986_A.func_76073_f())];
/*      */   }
/*      */   
/*      */   public float func_72929_e(float p_72929_1_) {
/* 1102 */     float f = func_72826_c(p_72929_1_);
/* 1103 */     return f * 3.1415927F * 2.0F;
/*      */   }
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public Vec3 func_72824_f(float p_72824_1_) {
/* 1108 */     float f1 = func_72826_c(p_72824_1_);
/*      */     
/* 1110 */     float f2 = MathHelper.func_76134_b(f1 * 3.1415927F * 2.0F) * 2.0F + 0.5F;
/* 1111 */     if (f2 < 0.0F) f2 = 0.0F; 
/* 1112 */     if (f2 > 1.0F) f2 = 1.0F;
/*      */     
/* 1114 */     float f3 = (float)(this.field_73001_c >> 16L & 0xFFL) / 255.0F;
/* 1115 */     float f4 = (float)(this.field_73001_c >> 8L & 0xFFL) / 255.0F;
/* 1116 */     float f5 = (float)(this.field_73001_c & 0xFFL) / 255.0F;
/*      */     
/* 1118 */     float f6 = func_72867_j(p_72824_1_);
/* 1119 */     if (f6 > 0.0F) {
/* 1120 */       float f8 = (f3 * 0.3F + f4 * 0.59F + f5 * 0.11F) * 0.6F;
/*      */       
/* 1122 */       float f9 = 1.0F - f6 * 0.95F;
/* 1123 */       f3 = f3 * f9 + f8 * (1.0F - f9);
/* 1124 */       f4 = f4 * f9 + f8 * (1.0F - f9);
/* 1125 */       f5 = f5 * f9 + f8 * (1.0F - f9);
/*      */     } 
/*      */     
/* 1128 */     f3 *= f2 * 0.9F + 0.1F;
/* 1129 */     f4 *= f2 * 0.9F + 0.1F;
/* 1130 */     f5 *= f2 * 0.85F + 0.15F;
/*      */     
/* 1132 */     float f7 = func_72819_i(p_72824_1_);
/* 1133 */     if (f7 > 0.0F) {
/* 1134 */       float f8 = (f3 * 0.3F + f4 * 0.59F + f5 * 0.11F) * 0.2F;
/*      */       
/* 1136 */       float f9 = 1.0F - f7 * 0.95F;
/* 1137 */       f3 = f3 * f9 + f8 * (1.0F - f9);
/* 1138 */       f4 = f4 * f9 + f8 * (1.0F - f9);
/* 1139 */       f5 = f5 * f9 + f8 * (1.0F - f9);
/*      */     } 
/*      */     
/* 1142 */     return Vec3.func_72443_a(f3, f4, f5);
/*      */   }
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public Vec3 func_72948_g(float p_72948_1_) {
/* 1147 */     float f = func_72826_c(p_72948_1_);
/* 1148 */     return this.field_73011_w.func_76562_b(f, p_72948_1_);
/*      */   }
/*      */   
/*      */   public int func_72874_g(int p_72874_1_, int p_72874_2_) {
/* 1152 */     return func_72938_d(p_72874_1_, p_72874_2_).func_76626_d(p_72874_1_ & 0xF, p_72874_2_ & 0xF);
/*      */   }
/*      */   
/*      */   public int func_72825_h(int p_72825_1_, int p_72825_2_) {
/* 1156 */     Chunk chunk = func_72938_d(p_72825_1_, p_72825_2_);
/*      */     
/* 1158 */     int i = chunk.func_76625_h() + 15;
/*      */     
/* 1160 */     p_72825_1_ &= 0xF;
/* 1161 */     p_72825_2_ &= 0xF;
/*      */     
/* 1163 */     while (i > 0) {
/* 1164 */       Block block = chunk.func_150810_a(p_72825_1_, i, p_72825_2_);
/* 1165 */       if (!block.func_149688_o().func_76230_c() || block.func_149688_o() == Material.field_151584_j) {
/* 1166 */         i--; continue;
/*      */       } 
/* 1168 */       return i + 1;
/*      */     } 
/*      */     
/* 1171 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public float func_72880_h(float p_72880_1_) {
/* 1179 */     float f1 = func_72826_c(p_72880_1_);
/*      */     
/* 1181 */     float f2 = 1.0F - MathHelper.func_76134_b(f1 * 3.1415927F * 2.0F) * 2.0F + 0.25F;
/* 1182 */     if (f2 < 0.0F) f2 = 0.0F; 
/* 1183 */     if (f2 > 1.0F) f2 = 1.0F;
/*      */     
/* 1185 */     return f2 * f2 * 0.5F;
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147464_a(int p_147464_1_, int p_147464_2_, int p_147464_3_, Block p_147464_4_, int p_147464_5_) {}
/*      */ 
/*      */   
/*      */   public void func_147454_a(int p_147454_1_, int p_147454_2_, int p_147454_3_, Block p_147454_4_, int p_147454_5_, int p_147454_6_) {}
/*      */ 
/*      */   
/*      */   public void func_147446_b(int p_147446_1_, int p_147446_2_, int p_147446_3_, Block p_147446_4_, int p_147446_5_, int p_147446_6_) {}
/*      */   
/*      */   public void func_72939_s() {
/* 1198 */     this.field_72984_F.func_76320_a("entities");
/* 1199 */     this.field_72984_F.func_76320_a("global");
/*      */     byte b;
/* 1201 */     for (b = 0; b < this.field_73007_j.size(); b++) {
/* 1202 */       Entity entity = this.field_73007_j.get(b);
/*      */       try {
/* 1204 */         entity.field_70173_aa++;
/* 1205 */         entity.func_70071_h_();
/* 1206 */       } catch (Throwable throwable) {
/* 1207 */         CrashReport crashReport = CrashReport.func_85055_a(throwable, "Ticking entity");
/* 1208 */         CrashReportCategory crashReportCategory = crashReport.func_85058_a("Entity being ticked");
/*      */         
/* 1210 */         if (entity == null) {
/* 1211 */           crashReportCategory.func_71507_a("Entity", "~~NULL~~");
/*      */         } else {
/* 1213 */           entity.func_85029_a(crashReportCategory);
/*      */         } 
/*      */         
/* 1216 */         throw new ReportedException(crashReport);
/*      */       } 
/*      */       
/* 1219 */       if (entity.field_70128_L) {
/* 1220 */         this.field_73007_j.remove(b--);
/*      */       }
/*      */     } 
/*      */     
/* 1224 */     this.field_72984_F.func_76318_c("remove");
/* 1225 */     this.field_72996_f.removeAll(this.field_72997_g);
/* 1226 */     for (b = 0; b < this.field_72997_g.size(); b++) {
/* 1227 */       Entity entity = this.field_72997_g.get(b);
/* 1228 */       int i = entity.field_70176_ah;
/* 1229 */       int j = entity.field_70164_aj;
/* 1230 */       if (entity.field_70175_ag && func_72916_c(i, j)) {
/* 1231 */         func_72964_e(i, j).func_76622_b(entity);
/*      */       }
/*      */     } 
/* 1234 */     for (b = 0; b < this.field_72997_g.size(); b++) {
/* 1235 */       func_72847_b(this.field_72997_g.get(b));
/*      */     }
/* 1237 */     this.field_72997_g.clear();
/*      */     
/* 1239 */     this.field_72984_F.func_76318_c("regular");
/* 1240 */     for (b = 0; b < this.field_72996_f.size(); b++) {
/* 1241 */       Entity entity = this.field_72996_f.get(b);
/*      */       
/* 1243 */       if (entity.field_70154_o != null)
/* 1244 */         if (entity.field_70154_o.field_70128_L || entity.field_70154_o.field_70153_n != entity) {
/* 1245 */           entity.field_70154_o.field_70153_n = null;
/* 1246 */           entity.field_70154_o = null;
/*      */         } else {
/*      */           continue;
/*      */         }  
/* 1250 */       this.field_72984_F.func_76320_a("tick");
/* 1251 */       if (!entity.field_70128_L) {
/*      */         try {
/* 1253 */           func_72870_g(entity);
/* 1254 */         } catch (Throwable throwable) {
/* 1255 */           CrashReport crashReport = CrashReport.func_85055_a(throwable, "Ticking entity");
/* 1256 */           CrashReportCategory crashReportCategory = crashReport.func_85058_a("Entity being ticked");
/*      */           
/* 1258 */           entity.func_85029_a(crashReportCategory);
/*      */           
/* 1260 */           throw new ReportedException(crashReport);
/*      */         } 
/*      */       }
/* 1263 */       this.field_72984_F.func_76319_b();
/*      */       
/* 1265 */       this.field_72984_F.func_76320_a("remove");
/* 1266 */       if (entity.field_70128_L) {
/* 1267 */         int i = entity.field_70176_ah;
/* 1268 */         int j = entity.field_70164_aj;
/* 1269 */         if (entity.field_70175_ag && func_72916_c(i, j)) {
/* 1270 */           func_72964_e(i, j).func_76622_b(entity);
/*      */         }
/* 1272 */         this.field_72996_f.remove(b--);
/* 1273 */         func_72847_b(entity);
/*      */       } 
/* 1275 */       this.field_72984_F.func_76319_b();
/*      */       continue;
/*      */     } 
/* 1278 */     this.field_72984_F.func_76318_c("blockEntities");
/* 1279 */     this.field_147481_N = true;
/* 1280 */     Iterator<TileEntity> iterator = this.field_147482_g.iterator();
/* 1281 */     while (iterator.hasNext()) {
/* 1282 */       TileEntity tileEntity = iterator.next();
/* 1283 */       if (!tileEntity.func_145837_r() && tileEntity.func_145830_o() && 
/* 1284 */         func_72899_e(tileEntity.field_145851_c, tileEntity.field_145848_d, tileEntity.field_145849_e)) {
/*      */         try {
/* 1286 */           tileEntity.func_145845_h();
/* 1287 */         } catch (Throwable throwable) {
/* 1288 */           CrashReport crashReport = CrashReport.func_85055_a(throwable, "Ticking block entity");
/* 1289 */           CrashReportCategory crashReportCategory = crashReport.func_85058_a("Block entity being ticked");
/*      */           
/* 1291 */           tileEntity.func_145828_a(crashReportCategory);
/*      */           
/* 1293 */           throw new ReportedException(crashReport);
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/* 1298 */       if (tileEntity.func_145837_r()) {
/* 1299 */         iterator.remove();
/*      */         
/* 1301 */         if (func_72916_c(tileEntity.field_145851_c >> 4, tileEntity.field_145849_e >> 4)) {
/* 1302 */           Chunk chunk = func_72964_e(tileEntity.field_145851_c >> 4, tileEntity.field_145849_e >> 4);
/* 1303 */           if (chunk != null) chunk.func_150805_f(tileEntity.field_145851_c & 0xF, tileEntity.field_145848_d, tileEntity.field_145849_e & 0xF); 
/*      */         } 
/*      */       } 
/*      */     } 
/* 1307 */     this.field_147481_N = false;
/*      */     
/* 1309 */     if (!this.field_147483_b.isEmpty()) {
/* 1310 */       this.field_147482_g.removeAll(this.field_147483_b);
/* 1311 */       this.field_147483_b.clear();
/*      */     } 
/*      */     
/* 1314 */     this.field_72984_F.func_76318_c("pendingBlockEntities");
/* 1315 */     if (!this.field_147484_a.isEmpty()) {
/* 1316 */       for (byte b1 = 0; b1 < this.field_147484_a.size(); b1++) {
/* 1317 */         TileEntity tileEntity = this.field_147484_a.get(b1);
/* 1318 */         if (!tileEntity.func_145837_r()) {
/* 1319 */           if (!this.field_147482_g.contains(tileEntity)) {
/* 1320 */             this.field_147482_g.add(tileEntity);
/*      */           }
/*      */           
/* 1323 */           if (func_72916_c(tileEntity.field_145851_c >> 4, tileEntity.field_145849_e >> 4)) {
/* 1324 */             Chunk chunk = func_72964_e(tileEntity.field_145851_c >> 4, tileEntity.field_145849_e >> 4);
/* 1325 */             if (chunk != null) chunk.func_150812_a(tileEntity.field_145851_c & 0xF, tileEntity.field_145848_d, tileEntity.field_145849_e & 0xF, tileEntity);
/*      */           
/*      */           } 
/* 1328 */           func_147471_g(tileEntity.field_145851_c, tileEntity.field_145848_d, tileEntity.field_145849_e);
/*      */         } 
/*      */       } 
/* 1331 */       this.field_147484_a.clear();
/*      */     } 
/* 1333 */     this.field_72984_F.func_76319_b();
/* 1334 */     this.field_72984_F.func_76319_b();
/*      */   }
/*      */   
/*      */   public void func_147448_a(Collection p_147448_1_) {
/* 1338 */     if (this.field_147481_N) {
/* 1339 */       this.field_147484_a.addAll(p_147448_1_);
/*      */     } else {
/* 1341 */       this.field_147482_g.addAll(p_147448_1_);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void func_72870_g(Entity p_72870_1_) {
/* 1346 */     func_72866_a(p_72870_1_, true);
/*      */   }
/*      */   
/*      */   public void func_72866_a(Entity p_72866_1_, boolean p_72866_2_) {
/* 1350 */     int i = MathHelper.func_76128_c(p_72866_1_.field_70165_t);
/* 1351 */     int j = MathHelper.func_76128_c(p_72866_1_.field_70161_v);
/* 1352 */     byte b = 32;
/* 1353 */     if (p_72866_2_ && !func_72904_c(i - b, 0, j - b, i + b, 0, j + b)) {
/*      */       return;
/*      */     }
/*      */     
/* 1357 */     p_72866_1_.field_70142_S = p_72866_1_.field_70165_t;
/* 1358 */     p_72866_1_.field_70137_T = p_72866_1_.field_70163_u;
/* 1359 */     p_72866_1_.field_70136_U = p_72866_1_.field_70161_v;
/* 1360 */     p_72866_1_.field_70126_B = p_72866_1_.field_70177_z;
/* 1361 */     p_72866_1_.field_70127_C = p_72866_1_.field_70125_A;
/*      */     
/* 1363 */     if (p_72866_2_ && p_72866_1_.field_70175_ag) {
/* 1364 */       p_72866_1_.field_70173_aa++;
/* 1365 */       if (p_72866_1_.field_70154_o != null) {
/* 1366 */         p_72866_1_.func_70098_U();
/*      */       } else {
/* 1368 */         p_72866_1_.func_70071_h_();
/*      */       } 
/*      */     } 
/*      */     
/* 1372 */     this.field_72984_F.func_76320_a("chunkCheck");
/*      */     
/* 1374 */     if (Double.isNaN(p_72866_1_.field_70165_t) || Double.isInfinite(p_72866_1_.field_70165_t)) p_72866_1_.field_70165_t = p_72866_1_.field_70142_S; 
/* 1375 */     if (Double.isNaN(p_72866_1_.field_70163_u) || Double.isInfinite(p_72866_1_.field_70163_u)) p_72866_1_.field_70163_u = p_72866_1_.field_70137_T; 
/* 1376 */     if (Double.isNaN(p_72866_1_.field_70161_v) || Double.isInfinite(p_72866_1_.field_70161_v)) p_72866_1_.field_70161_v = p_72866_1_.field_70136_U; 
/* 1377 */     if (Double.isNaN(p_72866_1_.field_70125_A) || Double.isInfinite(p_72866_1_.field_70125_A)) p_72866_1_.field_70125_A = p_72866_1_.field_70127_C; 
/* 1378 */     if (Double.isNaN(p_72866_1_.field_70177_z) || Double.isInfinite(p_72866_1_.field_70177_z)) p_72866_1_.field_70177_z = p_72866_1_.field_70126_B;
/*      */     
/* 1380 */     int k = MathHelper.func_76128_c(p_72866_1_.field_70165_t / 16.0D);
/* 1381 */     int m = MathHelper.func_76128_c(p_72866_1_.field_70163_u / 16.0D);
/* 1382 */     int n = MathHelper.func_76128_c(p_72866_1_.field_70161_v / 16.0D);
/*      */     
/* 1384 */     if (!p_72866_1_.field_70175_ag || p_72866_1_.field_70176_ah != k || p_72866_1_.field_70162_ai != m || p_72866_1_.field_70164_aj != n) {
/* 1385 */       if (p_72866_1_.field_70175_ag && func_72916_c(p_72866_1_.field_70176_ah, p_72866_1_.field_70164_aj)) {
/* 1386 */         func_72964_e(p_72866_1_.field_70176_ah, p_72866_1_.field_70164_aj).func_76608_a(p_72866_1_, p_72866_1_.field_70162_ai);
/*      */       }
/*      */       
/* 1389 */       if (func_72916_c(k, n)) {
/*      */         
/* 1391 */         p_72866_1_.field_70175_ag = true;
/* 1392 */         func_72964_e(k, n).func_76612_a(p_72866_1_);
/*      */       } else {
/* 1394 */         p_72866_1_.field_70175_ag = false;
/*      */       } 
/*      */     } 
/* 1397 */     this.field_72984_F.func_76319_b();
/*      */     
/* 1399 */     if (p_72866_2_ && p_72866_1_.field_70175_ag && 
/* 1400 */       p_72866_1_.field_70153_n != null) {
/* 1401 */       if (p_72866_1_.field_70153_n.field_70128_L || p_72866_1_.field_70153_n.field_70154_o != p_72866_1_) {
/* 1402 */         p_72866_1_.field_70153_n.field_70154_o = null;
/* 1403 */         p_72866_1_.field_70153_n = null;
/*      */       } else {
/* 1405 */         func_72870_g(p_72866_1_.field_70153_n);
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean func_72855_b(AxisAlignedBB p_72855_1_) {
/* 1412 */     return func_72917_a(p_72855_1_, null);
/*      */   }
/*      */   
/*      */   public boolean func_72917_a(AxisAlignedBB p_72917_1_, Entity p_72917_2_) {
/* 1416 */     List<Entity> list = func_72839_b(null, p_72917_1_);
/* 1417 */     for (byte b = 0; b < list.size(); b++) {
/* 1418 */       Entity entity = list.get(b);
/* 1419 */       if (!entity.field_70128_L && entity.field_70156_m && entity != p_72917_2_) return false; 
/*      */     } 
/* 1421 */     return true;
/*      */   }
/*      */   
/*      */   public boolean func_72829_c(AxisAlignedBB p_72829_1_) {
/* 1425 */     int i = MathHelper.func_76128_c(p_72829_1_.field_72340_a);
/* 1426 */     int j = MathHelper.func_76128_c(p_72829_1_.field_72336_d + 1.0D);
/* 1427 */     int k = MathHelper.func_76128_c(p_72829_1_.field_72338_b);
/* 1428 */     int m = MathHelper.func_76128_c(p_72829_1_.field_72337_e + 1.0D);
/* 1429 */     int n = MathHelper.func_76128_c(p_72829_1_.field_72339_c);
/* 1430 */     int i1 = MathHelper.func_76128_c(p_72829_1_.field_72334_f + 1.0D);
/*      */     
/* 1432 */     if (p_72829_1_.field_72340_a < 0.0D) i--; 
/* 1433 */     if (p_72829_1_.field_72338_b < 0.0D) k--; 
/* 1434 */     if (p_72829_1_.field_72339_c < 0.0D) n--;
/*      */     
/* 1436 */     for (int i2 = i; i2 < j; i2++) {
/* 1437 */       for (int i3 = k; i3 < m; i3++) {
/* 1438 */         for (int i4 = n; i4 < i1; i4++) {
/* 1439 */           Block block = func_147439_a(i2, i3, i4);
/* 1440 */           if (block.func_149688_o() != Material.field_151579_a)
/* 1441 */             return true; 
/*      */         } 
/*      */       } 
/* 1444 */     }  return false;
/*      */   }
/*      */   
/*      */   public boolean func_72953_d(AxisAlignedBB p_72953_1_) {
/* 1448 */     int i = MathHelper.func_76128_c(p_72953_1_.field_72340_a);
/* 1449 */     int j = MathHelper.func_76128_c(p_72953_1_.field_72336_d + 1.0D);
/* 1450 */     int k = MathHelper.func_76128_c(p_72953_1_.field_72338_b);
/* 1451 */     int m = MathHelper.func_76128_c(p_72953_1_.field_72337_e + 1.0D);
/* 1452 */     int n = MathHelper.func_76128_c(p_72953_1_.field_72339_c);
/* 1453 */     int i1 = MathHelper.func_76128_c(p_72953_1_.field_72334_f + 1.0D);
/*      */     
/* 1455 */     if (p_72953_1_.field_72340_a < 0.0D) i--; 
/* 1456 */     if (p_72953_1_.field_72338_b < 0.0D) k--; 
/* 1457 */     if (p_72953_1_.field_72339_c < 0.0D) n--;
/*      */     
/* 1459 */     for (int i2 = i; i2 < j; i2++) {
/* 1460 */       for (int i3 = k; i3 < m; i3++) {
/* 1461 */         for (int i4 = n; i4 < i1; i4++) {
/* 1462 */           Block block = func_147439_a(i2, i3, i4);
/* 1463 */           if (block.func_149688_o().func_76224_d())
/* 1464 */             return true; 
/*      */         } 
/*      */       } 
/* 1467 */     }  return false;
/*      */   }
/*      */   
/*      */   public boolean func_147470_e(AxisAlignedBB p_147470_1_) {
/* 1471 */     int i = MathHelper.func_76128_c(p_147470_1_.field_72340_a);
/* 1472 */     int j = MathHelper.func_76128_c(p_147470_1_.field_72336_d + 1.0D);
/* 1473 */     int k = MathHelper.func_76128_c(p_147470_1_.field_72338_b);
/* 1474 */     int m = MathHelper.func_76128_c(p_147470_1_.field_72337_e + 1.0D);
/* 1475 */     int n = MathHelper.func_76128_c(p_147470_1_.field_72339_c);
/* 1476 */     int i1 = MathHelper.func_76128_c(p_147470_1_.field_72334_f + 1.0D);
/*      */     
/* 1478 */     if (func_72904_c(i, k, n, j, m, i1))
/* 1479 */       for (int i2 = i; i2 < j; i2++) {
/* 1480 */         for (int i3 = k; i3 < m; i3++) {
/* 1481 */           for (int i4 = n; i4 < i1; i4++) {
/* 1482 */             Block block = func_147439_a(i2, i3, i4);
/* 1483 */             if (block == Blocks.field_150480_ab || block == Blocks.field_150356_k || block == Blocks.field_150353_l) return true; 
/*      */           } 
/*      */         } 
/* 1486 */       }   return false;
/*      */   }
/*      */   
/*      */   public boolean func_72918_a(AxisAlignedBB p_72918_1_, Material p_72918_2_, Entity p_72918_3_) {
/* 1490 */     int i = MathHelper.func_76128_c(p_72918_1_.field_72340_a);
/* 1491 */     int j = MathHelper.func_76128_c(p_72918_1_.field_72336_d + 1.0D);
/*      */     
/* 1493 */     int k = MathHelper.func_76128_c(p_72918_1_.field_72338_b);
/* 1494 */     int m = MathHelper.func_76128_c(p_72918_1_.field_72337_e + 1.0D);
/*      */     
/* 1496 */     int n = MathHelper.func_76128_c(p_72918_1_.field_72339_c);
/* 1497 */     int i1 = MathHelper.func_76128_c(p_72918_1_.field_72334_f + 1.0D);
/*      */     
/* 1499 */     if (!func_72904_c(i, k, n, j, m, i1)) {
/* 1500 */       return false;
/*      */     }
/*      */     
/* 1503 */     boolean bool = false;
/* 1504 */     Vec3 vec3 = Vec3.func_72443_a(0.0D, 0.0D, 0.0D);
/* 1505 */     for (int i2 = i; i2 < j; i2++) {
/* 1506 */       for (int i3 = k; i3 < m; i3++) {
/* 1507 */         for (int i4 = n; i4 < i1; i4++) {
/* 1508 */           Block block = func_147439_a(i2, i3, i4);
/* 1509 */           if (block.func_149688_o() == p_72918_2_) {
/* 1510 */             double d = ((i3 + 1) - BlockLiquid.func_149801_b(func_72805_g(i2, i3, i4)));
/* 1511 */             if (m >= d)
/* 1512 */             { bool = true;
/* 1513 */               block.func_149640_a(this, i2, i3, i4, p_72918_3_, vec3); } 
/*      */           } 
/*      */         } 
/*      */       } 
/* 1517 */     }  if (vec3.func_72433_c() > 0.0D && p_72918_3_.func_96092_aw()) {
/* 1518 */       vec3 = vec3.func_72432_b();
/* 1519 */       double d = 0.014D;
/* 1520 */       p_72918_3_.field_70159_w += vec3.field_72450_a * d;
/* 1521 */       p_72918_3_.field_70181_x += vec3.field_72448_b * d;
/* 1522 */       p_72918_3_.field_70179_y += vec3.field_72449_c * d;
/*      */     } 
/* 1524 */     return bool;
/*      */   }
/*      */   
/*      */   public boolean func_72875_a(AxisAlignedBB p_72875_1_, Material p_72875_2_) {
/* 1528 */     int i = MathHelper.func_76128_c(p_72875_1_.field_72340_a);
/* 1529 */     int j = MathHelper.func_76128_c(p_72875_1_.field_72336_d + 1.0D);
/* 1530 */     int k = MathHelper.func_76128_c(p_72875_1_.field_72338_b);
/* 1531 */     int m = MathHelper.func_76128_c(p_72875_1_.field_72337_e + 1.0D);
/* 1532 */     int n = MathHelper.func_76128_c(p_72875_1_.field_72339_c);
/* 1533 */     int i1 = MathHelper.func_76128_c(p_72875_1_.field_72334_f + 1.0D);
/*      */     
/* 1535 */     for (int i2 = i; i2 < j; i2++) {
/* 1536 */       for (int i3 = k; i3 < m; i3++) {
/* 1537 */         for (int i4 = n; i4 < i1; i4++) {
/* 1538 */           if (func_147439_a(i2, i3, i4).func_149688_o() == p_72875_2_)
/* 1539 */             return true; 
/*      */         } 
/*      */       } 
/* 1542 */     }  return false;
/*      */   }
/*      */   
/*      */   public boolean func_72830_b(AxisAlignedBB p_72830_1_, Material p_72830_2_) {
/* 1546 */     int i = MathHelper.func_76128_c(p_72830_1_.field_72340_a);
/* 1547 */     int j = MathHelper.func_76128_c(p_72830_1_.field_72336_d + 1.0D);
/* 1548 */     int k = MathHelper.func_76128_c(p_72830_1_.field_72338_b);
/* 1549 */     int m = MathHelper.func_76128_c(p_72830_1_.field_72337_e + 1.0D);
/* 1550 */     int n = MathHelper.func_76128_c(p_72830_1_.field_72339_c);
/* 1551 */     int i1 = MathHelper.func_76128_c(p_72830_1_.field_72334_f + 1.0D);
/*      */     
/* 1553 */     for (int i2 = i; i2 < j; i2++) {
/* 1554 */       for (int i3 = k; i3 < m; i3++) {
/* 1555 */         for (int i4 = n; i4 < i1; i4++) {
/* 1556 */           Block block = func_147439_a(i2, i3, i4);
/* 1557 */           if (block.func_149688_o() == p_72830_2_) {
/* 1558 */             int i5 = func_72805_g(i2, i3, i4);
/* 1559 */             double d = (i3 + 1);
/* 1560 */             if (i5 < 8) {
/* 1561 */               d = (i3 + 1) - i5 / 8.0D;
/*      */             }
/* 1563 */             if (d >= p_72830_1_.field_72338_b)
/* 1564 */               return true; 
/*      */           } 
/*      */         } 
/*      */       } 
/* 1568 */     }  return false;
/*      */   }
/*      */   
/*      */   public Explosion func_72876_a(Entity p_72876_1_, double p_72876_2_, double p_72876_4_, double p_72876_6_, float p_72876_8_, boolean p_72876_9_) {
/* 1572 */     return func_72885_a(p_72876_1_, p_72876_2_, p_72876_4_, p_72876_6_, p_72876_8_, false, p_72876_9_);
/*      */   }
/*      */   
/*      */   public Explosion func_72885_a(Entity p_72885_1_, double p_72885_2_, double p_72885_4_, double p_72885_6_, float p_72885_8_, boolean p_72885_9_, boolean p_72885_10_) {
/* 1576 */     Explosion explosion = new Explosion(this, p_72885_1_, p_72885_2_, p_72885_4_, p_72885_6_, p_72885_8_);
/* 1577 */     explosion.field_77286_a = p_72885_9_;
/* 1578 */     explosion.field_82755_b = p_72885_10_;
/* 1579 */     explosion.func_77278_a();
/* 1580 */     explosion.func_77279_a(true);
/* 1581 */     return explosion;
/*      */   }
/*      */   
/*      */   public float func_72842_a(Vec3 p_72842_1_, AxisAlignedBB p_72842_2_) {
/* 1585 */     double d1 = 1.0D / ((p_72842_2_.field_72336_d - p_72842_2_.field_72340_a) * 2.0D + 1.0D);
/* 1586 */     double d2 = 1.0D / ((p_72842_2_.field_72337_e - p_72842_2_.field_72338_b) * 2.0D + 1.0D);
/* 1587 */     double d3 = 1.0D / ((p_72842_2_.field_72334_f - p_72842_2_.field_72339_c) * 2.0D + 1.0D);
/* 1588 */     if (d1 < 0.0D || d2 < 0.0D || d3 < 0.0D) {
/* 1589 */       return 0.0F;
/*      */     }
/* 1591 */     byte b1 = 0;
/* 1592 */     byte b2 = 0; float f;
/* 1593 */     for (f = 0.0F; f <= 1.0F; f = (float)(f + d1)) {
/* 1594 */       float f1; for (f1 = 0.0F; f1 <= 1.0F; f1 = (float)(f1 + d2)) {
/* 1595 */         float f2; for (f2 = 0.0F; f2 <= 1.0F; f2 = (float)(f2 + d3)) {
/* 1596 */           double d4 = p_72842_2_.field_72340_a + (p_72842_2_.field_72336_d - p_72842_2_.field_72340_a) * f;
/* 1597 */           double d5 = p_72842_2_.field_72338_b + (p_72842_2_.field_72337_e - p_72842_2_.field_72338_b) * f1;
/* 1598 */           double d6 = p_72842_2_.field_72339_c + (p_72842_2_.field_72334_f - p_72842_2_.field_72339_c) * f2;
/* 1599 */           if (func_72933_a(Vec3.func_72443_a(d4, d5, d6), p_72842_1_) == null) b1++; 
/* 1600 */           b2++;
/*      */         } 
/*      */       } 
/* 1603 */     }  return b1 / b2;
/*      */   }
/*      */   
/*      */   public boolean func_72886_a(EntityPlayer p_72886_1_, int p_72886_2_, int p_72886_3_, int p_72886_4_, int p_72886_5_) {
/* 1607 */     if (p_72886_5_ == 0) p_72886_3_--; 
/* 1608 */     if (p_72886_5_ == 1) p_72886_3_++; 
/* 1609 */     if (p_72886_5_ == 2) p_72886_4_--; 
/* 1610 */     if (p_72886_5_ == 3) p_72886_4_++; 
/* 1611 */     if (p_72886_5_ == 4) p_72886_2_--; 
/* 1612 */     if (p_72886_5_ == 5) p_72886_2_++;
/*      */     
/* 1614 */     if (func_147439_a(p_72886_2_, p_72886_3_, p_72886_4_) == Blocks.field_150480_ab) {
/* 1615 */       func_72889_a(p_72886_1_, 1004, p_72886_2_, p_72886_3_, p_72886_4_, 0);
/* 1616 */       func_147468_f(p_72886_2_, p_72886_3_, p_72886_4_);
/* 1617 */       return true;
/*      */     } 
/* 1619 */     return false;
/*      */   }
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public String func_72981_t() {
/* 1624 */     return "All: " + this.field_72996_f.size();
/*      */   }
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public String func_72827_u() {
/* 1629 */     return this.field_73020_y.func_73148_d();
/*      */   }
/*      */ 
/*      */   
/*      */   public TileEntity func_147438_o(int p_147438_1_, int p_147438_2_, int p_147438_3_) {
/* 1634 */     if (p_147438_2_ < 0 || p_147438_2_ >= 256) {
/* 1635 */       return null;
/*      */     }
/* 1637 */     TileEntity tileEntity = null;
/*      */     
/* 1639 */     if (this.field_147481_N) {
/* 1640 */       for (byte b = 0; b < this.field_147484_a.size(); b++) {
/* 1641 */         TileEntity tileEntity1 = this.field_147484_a.get(b);
/* 1642 */         if (!tileEntity1.func_145837_r() && tileEntity1.field_145851_c == p_147438_1_ && tileEntity1.field_145848_d == p_147438_2_ && tileEntity1.field_145849_e == p_147438_3_) {
/* 1643 */           tileEntity = tileEntity1;
/*      */           
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     }
/* 1649 */     if (tileEntity == null) {
/* 1650 */       Chunk chunk = func_72964_e(p_147438_1_ >> 4, p_147438_3_ >> 4);
/* 1651 */       if (chunk != null) {
/* 1652 */         tileEntity = chunk.func_150806_e(p_147438_1_ & 0xF, p_147438_2_, p_147438_3_ & 0xF);
/*      */       }
/*      */     } 
/*      */     
/* 1656 */     if (tileEntity == null) {
/* 1657 */       for (byte b = 0; b < this.field_147484_a.size(); b++) {
/* 1658 */         TileEntity tileEntity1 = this.field_147484_a.get(b);
/* 1659 */         if (!tileEntity1.func_145837_r() && tileEntity1.field_145851_c == p_147438_1_ && tileEntity1.field_145848_d == p_147438_2_ && tileEntity1.field_145849_e == p_147438_3_) {
/* 1660 */           tileEntity = tileEntity1;
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     }
/* 1665 */     return tileEntity;
/*      */   }
/*      */   
/*      */   public void func_147455_a(int p_147455_1_, int p_147455_2_, int p_147455_3_, TileEntity p_147455_4_) {
/* 1669 */     if (p_147455_4_ != null && !p_147455_4_.func_145837_r()) {
/* 1670 */       if (this.field_147481_N) {
/* 1671 */         p_147455_4_.field_145851_c = p_147455_1_;
/* 1672 */         p_147455_4_.field_145848_d = p_147455_2_;
/* 1673 */         p_147455_4_.field_145849_e = p_147455_3_;
/*      */ 
/*      */         
/* 1676 */         Iterator<TileEntity> iterator = this.field_147484_a.iterator();
/* 1677 */         while (iterator.hasNext()) {
/* 1678 */           TileEntity tileEntity = iterator.next();
/* 1679 */           if (tileEntity.field_145851_c == p_147455_1_ && tileEntity.field_145848_d == p_147455_2_ && tileEntity.field_145849_e == p_147455_3_) {
/* 1680 */             tileEntity.func_145843_s();
/* 1681 */             iterator.remove();
/*      */           } 
/*      */         } 
/*      */         
/* 1685 */         this.field_147484_a.add(p_147455_4_);
/*      */       } else {
/* 1687 */         this.field_147482_g.add(p_147455_4_);
/*      */         
/* 1689 */         Chunk chunk = func_72964_e(p_147455_1_ >> 4, p_147455_3_ >> 4);
/* 1690 */         if (chunk != null) chunk.func_150812_a(p_147455_1_ & 0xF, p_147455_2_, p_147455_3_ & 0xF, p_147455_4_);
/*      */       
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   public void func_147475_p(int p_147475_1_, int p_147475_2_, int p_147475_3_) {
/* 1697 */     TileEntity tileEntity = func_147438_o(p_147475_1_, p_147475_2_, p_147475_3_);
/* 1698 */     if (tileEntity != null && this.field_147481_N) {
/* 1699 */       tileEntity.func_145843_s();
/* 1700 */       this.field_147484_a.remove(tileEntity);
/*      */     } else {
/* 1702 */       if (tileEntity != null) {
/* 1703 */         this.field_147484_a.remove(tileEntity);
/* 1704 */         this.field_147482_g.remove(tileEntity);
/*      */       } 
/*      */       
/* 1707 */       Chunk chunk = func_72964_e(p_147475_1_ >> 4, p_147475_3_ >> 4);
/* 1708 */       if (chunk != null) chunk.func_150805_f(p_147475_1_ & 0xF, p_147475_2_, p_147475_3_ & 0xF); 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void func_147457_a(TileEntity p_147457_1_) {
/* 1713 */     this.field_147483_b.add(p_147457_1_);
/*      */   }
/*      */   
/*      */   public boolean func_147469_q(int p_147469_1_, int p_147469_2_, int p_147469_3_) {
/* 1717 */     AxisAlignedBB axisAlignedBB = func_147439_a(p_147469_1_, p_147469_2_, p_147469_3_).func_149668_a(this, p_147469_1_, p_147469_2_, p_147469_3_);
/* 1718 */     return (axisAlignedBB != null && axisAlignedBB.func_72320_b() >= 1.0D);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean func_147466_a(IBlockAccess p_147466_0_, int p_147466_1_, int p_147466_2_, int p_147466_3_) {
/* 1723 */     Block block = p_147466_0_.func_147439_a(p_147466_1_, p_147466_2_, p_147466_3_);
/* 1724 */     int i = p_147466_0_.func_72805_g(p_147466_1_, p_147466_2_, p_147466_3_);
/* 1725 */     if (block.func_149688_o().func_76218_k() && block.func_149686_d()) return true; 
/* 1726 */     if (block instanceof net.minecraft.block.BlockStairs) return ((i & 0x4) == 4); 
/* 1727 */     if (block instanceof net.minecraft.block.BlockSlab) return ((i & 0x8) == 8); 
/* 1728 */     if (block instanceof net.minecraft.block.BlockHopper) return true; 
/* 1729 */     if (block instanceof net.minecraft.block.BlockSnow) return ((i & 0x7) == 7); 
/* 1730 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean func_147445_c(int p_147445_1_, int p_147445_2_, int p_147445_3_, boolean p_147445_4_) {
/* 1748 */     if (p_147445_1_ < -30000000 || p_147445_3_ < -30000000 || p_147445_1_ >= 30000000 || p_147445_3_ >= 30000000) {
/* 1749 */       return p_147445_4_;
/*      */     }
/* 1751 */     Chunk chunk = this.field_73020_y.func_73154_d(p_147445_1_ >> 4, p_147445_3_ >> 4);
/* 1752 */     if (chunk == null || chunk.func_76621_g()) {
/* 1753 */       return p_147445_4_;
/*      */     }
/*      */     
/* 1756 */     Block block = func_147439_a(p_147445_1_, p_147445_2_, p_147445_3_);
/* 1757 */     return (block.func_149688_o().func_76218_k() && block.func_149686_d());
/*      */   }
/*      */   
/*      */   public void func_72966_v() {
/* 1761 */     int i = func_72967_a(1.0F);
/* 1762 */     if (i != this.field_73008_k) {
/* 1763 */       this.field_73008_k = i;
/*      */     }
/*      */   }
/*      */   
/*      */   public void func_72891_a(boolean p_72891_1_, boolean p_72891_2_) {
/* 1768 */     this.field_72985_G = p_72891_1_;
/* 1769 */     this.field_72992_H = p_72891_2_;
/*      */   }
/*      */   
/*      */   public void func_72835_b() {
/* 1773 */     func_72979_l();
/*      */   }
/*      */   
/*      */   private void func_72947_a() {
/* 1777 */     if (this.field_72986_A.func_76059_o()) {
/* 1778 */       this.field_73004_o = 1.0F;
/* 1779 */       if (this.field_72986_A.func_76061_m()) {
/* 1780 */         this.field_73017_q = 1.0F;
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   protected void func_72979_l() {
/* 1786 */     if (this.field_73011_w.field_76576_e)
/* 1787 */       return;  if (this.field_72995_K) {
/*      */       return;
/*      */     }
/* 1790 */     int i = this.field_72986_A.func_76071_n();
/* 1791 */     if (i <= 0) {
/* 1792 */       if (this.field_72986_A.func_76061_m()) {
/* 1793 */         this.field_72986_A.func_76090_f(this.field_73012_v.nextInt(12000) + 3600);
/*      */       } else {
/* 1795 */         this.field_72986_A.func_76090_f(this.field_73012_v.nextInt(168000) + 12000);
/*      */       } 
/*      */     } else {
/* 1798 */       i--;
/* 1799 */       this.field_72986_A.func_76090_f(i);
/* 1800 */       if (i <= 0) {
/* 1801 */         this.field_72986_A.func_76069_a(!this.field_72986_A.func_76061_m());
/*      */       }
/*      */     } 
/*      */     
/* 1805 */     this.field_73018_p = this.field_73017_q;
/* 1806 */     if (this.field_72986_A.func_76061_m()) {
/* 1807 */       this.field_73017_q = (float)(this.field_73017_q + 0.01D);
/*      */     } else {
/* 1809 */       this.field_73017_q = (float)(this.field_73017_q - 0.01D);
/*      */     } 
/* 1811 */     this.field_73017_q = MathHelper.func_76131_a(this.field_73017_q, 0.0F, 1.0F);
/*      */ 
/*      */     
/* 1814 */     int j = this.field_72986_A.func_76083_p();
/* 1815 */     if (j <= 0) {
/* 1816 */       if (this.field_72986_A.func_76059_o()) {
/* 1817 */         this.field_72986_A.func_76080_g(this.field_73012_v.nextInt(12000) + 12000);
/*      */       } else {
/* 1819 */         this.field_72986_A.func_76080_g(this.field_73012_v.nextInt(168000) + 12000);
/*      */       } 
/*      */     } else {
/* 1822 */       j--;
/* 1823 */       this.field_72986_A.func_76080_g(j);
/* 1824 */       if (j <= 0) {
/* 1825 */         this.field_72986_A.func_76084_b(!this.field_72986_A.func_76059_o());
/*      */       }
/*      */     } 
/*      */     
/* 1829 */     this.field_73003_n = this.field_73004_o;
/* 1830 */     if (this.field_72986_A.func_76059_o()) {
/* 1831 */       this.field_73004_o = (float)(this.field_73004_o + 0.01D);
/*      */     } else {
/* 1833 */       this.field_73004_o = (float)(this.field_73004_o - 0.01D);
/*      */     } 
/* 1835 */     this.field_73004_o = MathHelper.func_76131_a(this.field_73004_o, 0.0F, 1.0F);
/*      */   }
/*      */   
/*      */   protected void func_72903_x() {
/* 1839 */     this.field_72993_I.clear();
/*      */     
/* 1841 */     this.field_72984_F.func_76320_a("buildList"); int i;
/* 1842 */     for (i = 0; i < this.field_73010_i.size(); i++) {
/* 1843 */       EntityPlayer entityPlayer = this.field_73010_i.get(i);
/* 1844 */       int j = MathHelper.func_76128_c(entityPlayer.field_70165_t / 16.0D);
/* 1845 */       int k = MathHelper.func_76128_c(entityPlayer.field_70161_v / 16.0D);
/*      */       
/* 1847 */       int m = func_152379_p();
/* 1848 */       for (int n = -m; n <= m; n++) {
/* 1849 */         for (int i1 = -m; i1 <= m; i1++) {
/* 1850 */           this.field_72993_I.add(new ChunkCoordIntPair(n + j, i1 + k));
/*      */         }
/*      */       } 
/*      */     } 
/* 1854 */     this.field_72984_F.func_76319_b();
/*      */     
/* 1856 */     if (this.field_72990_M > 0) this.field_72990_M--;
/*      */     
/* 1858 */     this.field_72984_F.func_76320_a("playerCheckLight");
/*      */     
/* 1860 */     if (!this.field_73010_i.isEmpty()) {
/* 1861 */       i = this.field_73012_v.nextInt(this.field_73010_i.size());
/* 1862 */       EntityPlayer entityPlayer = this.field_73010_i.get(i);
/* 1863 */       int j = MathHelper.func_76128_c(entityPlayer.field_70165_t) + this.field_73012_v.nextInt(11) - 5;
/* 1864 */       int k = MathHelper.func_76128_c(entityPlayer.field_70163_u) + this.field_73012_v.nextInt(11) - 5;
/* 1865 */       int m = MathHelper.func_76128_c(entityPlayer.field_70161_v) + this.field_73012_v.nextInt(11) - 5;
/* 1866 */       func_147451_t(j, k, m);
/*      */     } 
/* 1868 */     this.field_72984_F.func_76319_b();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void func_147467_a(int p_147467_1_, int p_147467_2_, Chunk p_147467_3_) {
/* 1875 */     this.field_72984_F.func_76318_c("moodSound");
/* 1876 */     if (this.field_72990_M == 0 && !this.field_72995_K) {
/* 1877 */       this.field_73005_l = this.field_73005_l * 3 + 1013904223;
/* 1878 */       int i = this.field_73005_l >> 2;
/* 1879 */       int j = i & 0xF;
/* 1880 */       int k = i >> 8 & 0xF;
/* 1881 */       int m = i >> 16 & 0xFF;
/*      */       
/* 1883 */       Block block = p_147467_3_.func_150810_a(j, m, k);
/* 1884 */       j += p_147467_1_;
/* 1885 */       k += p_147467_2_;
/* 1886 */       if (block.func_149688_o() == Material.field_151579_a && func_72883_k(j, m, k) <= this.field_73012_v.nextInt(8) && func_72972_b(EnumSkyBlock.Sky, j, m, k) <= 0) {
/* 1887 */         EntityPlayer entityPlayer = func_72977_a(j + 0.5D, m + 0.5D, k + 0.5D, 8.0D);
/* 1888 */         if (entityPlayer != null && entityPlayer.func_70092_e(j + 0.5D, m + 0.5D, k + 0.5D) > 4.0D) {
/* 1889 */           func_72908_a(j + 0.5D, m + 0.5D, k + 0.5D, "ambient.cave.cave", 0.7F, 0.8F + this.field_73012_v.nextFloat() * 0.2F);
/* 1890 */           this.field_72990_M = this.field_73012_v.nextInt(12000) + 6000;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 1895 */     this.field_72984_F.func_76318_c("checkLight");
/* 1896 */     p_147467_3_.func_76594_o();
/*      */   }
/*      */   
/*      */   protected void func_147456_g() {
/* 1900 */     func_72903_x();
/*      */   }
/*      */   
/*      */   public boolean func_72884_u(int p_72884_1_, int p_72884_2_, int p_72884_3_) {
/* 1904 */     return func_72834_c(p_72884_1_, p_72884_2_, p_72884_3_, false);
/*      */   }
/*      */   
/*      */   public boolean func_72850_v(int p_72850_1_, int p_72850_2_, int p_72850_3_) {
/* 1908 */     return func_72834_c(p_72850_1_, p_72850_2_, p_72850_3_, true);
/*      */   }
/*      */   
/*      */   public boolean func_72834_c(int p_72834_1_, int p_72834_2_, int p_72834_3_, boolean p_72834_4_) {
/* 1912 */     BiomeGenBase biomeGenBase = func_72807_a(p_72834_1_, p_72834_3_);
/* 1913 */     float f = biomeGenBase.func_150564_a(p_72834_1_, p_72834_2_, p_72834_3_);
/* 1914 */     if (f > 0.15F) return false;
/*      */     
/* 1916 */     if (p_72834_2_ >= 0 && p_72834_2_ < 256 && func_72972_b(EnumSkyBlock.Block, p_72834_1_, p_72834_2_, p_72834_3_) < 10) {
/* 1917 */       Block block = func_147439_a(p_72834_1_, p_72834_2_, p_72834_3_);
/* 1918 */       if ((block == Blocks.field_150355_j || block == Blocks.field_150358_i) && func_72805_g(p_72834_1_, p_72834_2_, p_72834_3_) == 0) {
/* 1919 */         if (!p_72834_4_) return true;
/*      */         
/* 1921 */         boolean bool = true;
/* 1922 */         if (bool && func_147439_a(p_72834_1_ - 1, p_72834_2_, p_72834_3_).func_149688_o() != Material.field_151586_h) bool = false; 
/* 1923 */         if (bool && func_147439_a(p_72834_1_ + 1, p_72834_2_, p_72834_3_).func_149688_o() != Material.field_151586_h) bool = false; 
/* 1924 */         if (bool && func_147439_a(p_72834_1_, p_72834_2_, p_72834_3_ - 1).func_149688_o() != Material.field_151586_h) bool = false; 
/* 1925 */         if (bool && func_147439_a(p_72834_1_, p_72834_2_, p_72834_3_ + 1).func_149688_o() != Material.field_151586_h) bool = false; 
/* 1926 */         if (!bool) return true; 
/*      */       } 
/*      */     } 
/* 1929 */     return false;
/*      */   }
/*      */   
/*      */   public boolean func_147478_e(int p_147478_1_, int p_147478_2_, int p_147478_3_, boolean p_147478_4_) {
/* 1933 */     BiomeGenBase biomeGenBase = func_72807_a(p_147478_1_, p_147478_3_);
/* 1934 */     float f = biomeGenBase.func_150564_a(p_147478_1_, p_147478_2_, p_147478_3_);
/* 1935 */     if (f > 0.15F) return false; 
/* 1936 */     if (!p_147478_4_) return true;
/*      */     
/* 1938 */     if (p_147478_2_ >= 0 && p_147478_2_ < 256 && func_72972_b(EnumSkyBlock.Block, p_147478_1_, p_147478_2_, p_147478_3_) < 10) {
/* 1939 */       Block block = func_147439_a(p_147478_1_, p_147478_2_, p_147478_3_);
/*      */ 
/*      */       
/* 1942 */       if (block.func_149688_o() == Material.field_151579_a && Blocks.field_150431_aC.func_149742_c(this, p_147478_1_, p_147478_2_, p_147478_3_)) {
/* 1943 */         return true;
/*      */       }
/*      */     } 
/*      */     
/* 1947 */     return false;
/*      */   }
/*      */   
/*      */   public boolean func_147451_t(int p_147451_1_, int p_147451_2_, int p_147451_3_) {
/* 1951 */     boolean bool = false;
/* 1952 */     if (!this.field_73011_w.field_76576_e) bool |= func_147463_c(EnumSkyBlock.Sky, p_147451_1_, p_147451_2_, p_147451_3_); 
/* 1953 */     bool |= func_147463_c(EnumSkyBlock.Block, p_147451_1_, p_147451_2_, p_147451_3_);
/* 1954 */     return bool;
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/* 1957 */   public World(ISaveHandler p_i45368_1_, String p_i45368_2_, WorldProvider p_i45368_3_, WorldSettings p_i45368_4_, Profiler p_i45368_5_) { this.field_72994_J = new int[32768]; this.field_73019_z = p_i45368_1_; this.field_72984_F = p_i45368_5_; this.field_72986_A = new WorldInfo(p_i45368_4_, p_i45368_2_); this.field_73011_w = p_i45368_3_; this.field_72988_C = new MapStorage(p_i45368_1_); VillageCollection villageCollection = (VillageCollection)this.field_72988_C.func_75742_a(VillageCollection.class, "villages"); if (villageCollection == null) { this.field_72982_D = new VillageCollection(this); this.field_72988_C.func_75745_a("villages", (WorldSavedData)this.field_72982_D); } else { this.field_72982_D = villageCollection; this.field_72982_D.func_82566_a(this); }  p_i45368_3_.func_76558_a(this); this.field_73020_y = func_72970_h(); func_72966_v(); func_72947_a(); } public World(ISaveHandler p_i45369_1_, String p_i45369_2_, WorldSettings p_i45369_3_, WorldProvider p_i45369_4_, Profiler p_i45369_5_) { this.field_72994_J = new int[32768]; this.field_73019_z = p_i45369_1_; this.field_72984_F = p_i45369_5_; this.field_72988_C = new MapStorage(p_i45369_1_); this.field_72986_A = p_i45369_1_.func_75757_d(); if (p_i45369_4_ != null) { this.field_73011_w = p_i45369_4_; } else if (this.field_72986_A != null && this.field_72986_A.func_76076_i() != 0) { this.field_73011_w = WorldProvider.func_76570_a(this.field_72986_A.func_76076_i()); } else { this.field_73011_w = WorldProvider.func_76570_a(0); }  if (this.field_72986_A == null) { this.field_72986_A = new WorldInfo(p_i45369_3_, p_i45369_2_); } else { this.field_72986_A.func_76062_a(p_i45369_2_); }  this.field_73011_w.func_76558_a(this); this.field_73020_y = func_72970_h(); if (!this.field_72986_A.func_76070_v()) { try { func_72963_a(p_i45369_3_); } catch (Throwable throwable) { CrashReport crashReport = CrashReport.func_85055_a(throwable, "Exception initializing level"); try { func_72914_a(crashReport); } catch (Throwable throwable1) {} throw new ReportedException(crashReport); }  this.field_72986_A.func_76091_d(true); }
/*      */      VillageCollection villageCollection = (VillageCollection)this.field_72988_C.func_75742_a(VillageCollection.class, "villages"); if (villageCollection == null) { this.field_72982_D = new VillageCollection(this); this.field_72988_C.func_75745_a("villages", (WorldSavedData)this.field_72982_D); }
/*      */     else { this.field_72982_D = villageCollection; this.field_72982_D.func_82566_a(this); }
/* 1960 */      func_72966_v(); func_72947_a(); } private int func_98179_a(int p_98179_1_, int p_98179_2_, int p_98179_3_, EnumSkyBlock p_98179_4_) { if (p_98179_4_ == EnumSkyBlock.Sky && func_72937_j(p_98179_1_, p_98179_2_, p_98179_3_)) return 15; 
/* 1961 */     Block block = func_147439_a(p_98179_1_, p_98179_2_, p_98179_3_);
/* 1962 */     int i = (p_98179_4_ == EnumSkyBlock.Sky) ? 0 : block.func_149750_m();
/* 1963 */     int j = block.func_149717_k();
/* 1964 */     if (j >= 15 && block.func_149750_m() > 0) j = 1; 
/* 1965 */     if (j < 1) j = 1; 
/* 1966 */     if (j >= 15) return 0;
/*      */     
/* 1968 */     if (i >= 14) return i;
/*      */     
/* 1970 */     for (byte b = 0; b < 6; b++) {
/* 1971 */       int k = p_98179_1_ + Facing.field_71586_b[b];
/* 1972 */       int m = p_98179_2_ + Facing.field_71587_c[b];
/* 1973 */       int n = p_98179_3_ + Facing.field_71585_d[b];
/* 1974 */       int i1 = func_72972_b(p_98179_4_, k, m, n) - j;
/*      */       
/* 1976 */       if (i1 > i) i = i1; 
/* 1977 */       if (i >= 14) return i;
/*      */     
/*      */     } 
/* 1980 */     return i; }
/*      */ 
/*      */   
/*      */   public boolean func_147463_c(EnumSkyBlock p_147463_1_, int p_147463_2_, int p_147463_3_, int p_147463_4_) {
/* 1984 */     if (!func_72873_a(p_147463_2_, p_147463_3_, p_147463_4_, 17)) return false;
/*      */     
/* 1986 */     byte b1 = 0;
/* 1987 */     byte b2 = 0;
/*      */     
/* 1989 */     this.field_72984_F.func_76320_a("getBrightness");
/* 1990 */     int i = func_72972_b(p_147463_1_, p_147463_2_, p_147463_3_, p_147463_4_);
/* 1991 */     int j = func_98179_a(p_147463_2_, p_147463_3_, p_147463_4_, p_147463_1_);
/*      */     
/* 1993 */     if (j > i) {
/* 1994 */       this.field_72994_J[b2++] = 133152;
/* 1995 */     } else if (j < i) {
/* 1996 */       this.field_72994_J[b2++] = 0x20820 | i << 18;
/*      */ 
/*      */       
/* 1999 */       while (b1 < b2) {
/* 2000 */         int k = this.field_72994_J[b1++];
/* 2001 */         int m = (k & 0x3F) - 32 + p_147463_2_;
/* 2002 */         int n = (k >> 6 & 0x3F) - 32 + p_147463_3_;
/* 2003 */         int i1 = (k >> 12 & 0x3F) - 32 + p_147463_4_;
/* 2004 */         int i2 = k >> 18 & 0xF;
/* 2005 */         int i3 = func_72972_b(p_147463_1_, m, n, i1);
/*      */         
/* 2007 */         if (i3 == i2) {
/* 2008 */           func_72915_b(p_147463_1_, m, n, i1, 0);
/*      */           
/* 2010 */           if (i2 > 0) {
/* 2011 */             int i4 = MathHelper.func_76130_a(m - p_147463_2_);
/* 2012 */             int i5 = MathHelper.func_76130_a(n - p_147463_3_);
/* 2013 */             int i6 = MathHelper.func_76130_a(i1 - p_147463_4_);
/*      */             
/* 2015 */             if (i4 + i5 + i6 < 17) {
/* 2016 */               for (byte b = 0; b < 6; b++) {
/* 2017 */                 int i7 = m + Facing.field_71586_b[b];
/* 2018 */                 int i8 = n + Facing.field_71587_c[b];
/* 2019 */                 int i9 = i1 + Facing.field_71585_d[b];
/* 2020 */                 int i10 = Math.max(1, func_147439_a(i7, i8, i9).func_149717_k());
/*      */                 
/* 2022 */                 i3 = func_72972_b(p_147463_1_, i7, i8, i9);
/*      */                 
/* 2024 */                 if (i3 == i2 - i10 && b2 < this.field_72994_J.length) {
/* 2025 */                   this.field_72994_J[b2++] = i7 - p_147463_2_ + 32 | i8 - p_147463_3_ + 32 << 6 | i9 - p_147463_4_ + 32 << 12 | i2 - i10 << 18;
/*      */                 }
/*      */               } 
/*      */             }
/*      */           } 
/*      */         } 
/*      */       } 
/* 2032 */       b1 = 0;
/*      */     } 
/* 2034 */     this.field_72984_F.func_76319_b();
/*      */     
/* 2036 */     this.field_72984_F.func_76320_a("checkedPosition < toCheckCount");
/* 2037 */     while (b1 < b2) {
/* 2038 */       int k = this.field_72994_J[b1++];
/* 2039 */       int m = (k & 0x3F) - 32 + p_147463_2_;
/* 2040 */       int n = (k >> 6 & 0x3F) - 32 + p_147463_3_;
/* 2041 */       int i1 = (k >> 12 & 0x3F) - 32 + p_147463_4_;
/*      */       
/* 2043 */       int i2 = func_72972_b(p_147463_1_, m, n, i1);
/* 2044 */       int i3 = func_98179_a(m, n, i1, p_147463_1_);
/*      */       
/* 2046 */       if (i3 != i2) {
/* 2047 */         func_72915_b(p_147463_1_, m, n, i1, i3);
/*      */         
/* 2049 */         if (i3 > i2) {
/* 2050 */           int i4 = Math.abs(m - p_147463_2_);
/* 2051 */           int i5 = Math.abs(n - p_147463_3_);
/* 2052 */           int i6 = Math.abs(i1 - p_147463_4_);
/* 2053 */           boolean bool = (b2 < this.field_72994_J.length - 6) ? true : false;
/*      */           
/* 2055 */           if (i4 + i5 + i6 < 17 && bool) {
/* 2056 */             if (func_72972_b(p_147463_1_, m - 1, n, i1) < i3) this.field_72994_J[b2++] = m - 1 - p_147463_2_ + 32 + (n - p_147463_3_ + 32 << 6) + (i1 - p_147463_4_ + 32 << 12); 
/* 2057 */             if (func_72972_b(p_147463_1_, m + 1, n, i1) < i3) this.field_72994_J[b2++] = m + 1 - p_147463_2_ + 32 + (n - p_147463_3_ + 32 << 6) + (i1 - p_147463_4_ + 32 << 12); 
/* 2058 */             if (func_72972_b(p_147463_1_, m, n - 1, i1) < i3) this.field_72994_J[b2++] = m - p_147463_2_ + 32 + (n - 1 - p_147463_3_ + 32 << 6) + (i1 - p_147463_4_ + 32 << 12); 
/* 2059 */             if (func_72972_b(p_147463_1_, m, n + 1, i1) < i3) this.field_72994_J[b2++] = m - p_147463_2_ + 32 + (n + 1 - p_147463_3_ + 32 << 6) + (i1 - p_147463_4_ + 32 << 12); 
/* 2060 */             if (func_72972_b(p_147463_1_, m, n, i1 - 1) < i3) this.field_72994_J[b2++] = m - p_147463_2_ + 32 + (n - p_147463_3_ + 32 << 6) + (i1 - 1 - p_147463_4_ + 32 << 12); 
/* 2061 */             if (func_72972_b(p_147463_1_, m, n, i1 + 1) < i3) this.field_72994_J[b2++] = m - p_147463_2_ + 32 + (n - p_147463_3_ + 32 << 6) + (i1 + 1 - p_147463_4_ + 32 << 12); 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/* 2066 */     this.field_72984_F.func_76319_b();
/*      */     
/* 2068 */     return true;
/*      */   }
/*      */   
/*      */   public boolean func_72955_a(boolean p_72955_1_) {
/* 2072 */     return false;
/*      */   }
/*      */   
/*      */   public List func_72920_a(Chunk p_72920_1_, boolean p_72920_2_) {
/* 2076 */     return null;
/*      */   }
/*      */   
/*      */   public List func_72839_b(Entity p_72839_1_, AxisAlignedBB p_72839_2_) {
/* 2080 */     return func_94576_a(p_72839_1_, p_72839_2_, null);
/*      */   }
/*      */   
/*      */   public List func_94576_a(Entity p_94576_1_, AxisAlignedBB p_94576_2_, IEntitySelector p_94576_3_) {
/* 2084 */     ArrayList arrayList = new ArrayList();
/* 2085 */     int i = MathHelper.func_76128_c((p_94576_2_.field_72340_a - 2.0D) / 16.0D);
/* 2086 */     int j = MathHelper.func_76128_c((p_94576_2_.field_72336_d + 2.0D) / 16.0D);
/* 2087 */     int k = MathHelper.func_76128_c((p_94576_2_.field_72339_c - 2.0D) / 16.0D);
/* 2088 */     int m = MathHelper.func_76128_c((p_94576_2_.field_72334_f + 2.0D) / 16.0D);
/* 2089 */     for (int n = i; n <= j; n++) {
/* 2090 */       for (int i1 = k; i1 <= m; i1++) {
/* 2091 */         if (func_72916_c(n, i1))
/* 2092 */           func_72964_e(n, i1).func_76588_a(p_94576_1_, p_94576_2_, arrayList, p_94576_3_); 
/*      */       } 
/*      */     } 
/* 2095 */     return arrayList;
/*      */   }
/*      */   
/*      */   public List func_72872_a(Class p_72872_1_, AxisAlignedBB p_72872_2_) {
/* 2099 */     return func_82733_a(p_72872_1_, p_72872_2_, null);
/*      */   }
/*      */   
/*      */   public List func_82733_a(Class p_82733_1_, AxisAlignedBB p_82733_2_, IEntitySelector p_82733_3_) {
/* 2103 */     int i = MathHelper.func_76128_c((p_82733_2_.field_72340_a - 2.0D) / 16.0D);
/* 2104 */     int j = MathHelper.func_76128_c((p_82733_2_.field_72336_d + 2.0D) / 16.0D);
/* 2105 */     int k = MathHelper.func_76128_c((p_82733_2_.field_72339_c - 2.0D) / 16.0D);
/* 2106 */     int m = MathHelper.func_76128_c((p_82733_2_.field_72334_f + 2.0D) / 16.0D);
/* 2107 */     ArrayList arrayList = new ArrayList();
/*      */     
/* 2109 */     for (int n = i; n <= j; n++) {
/* 2110 */       for (int i1 = k; i1 <= m; i1++) {
/* 2111 */         if (func_72916_c(n, i1)) {
/* 2112 */           func_72964_e(n, i1).func_76618_a(p_82733_1_, p_82733_2_, arrayList, p_82733_3_);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 2117 */     return arrayList;
/*      */   }
/*      */   
/*      */   public Entity func_72857_a(Class p_72857_1_, AxisAlignedBB p_72857_2_, Entity p_72857_3_) {
/* 2121 */     List<Entity> list = func_72872_a(p_72857_1_, p_72857_2_);
/* 2122 */     Entity entity = null;
/* 2123 */     double d = Double.MAX_VALUE;
/* 2124 */     for (byte b = 0; b < list.size(); b++) {
/* 2125 */       Entity entity1 = list.get(b);
/* 2126 */       if (entity1 != p_72857_3_) {
/* 2127 */         double d1 = p_72857_3_.func_70068_e(entity1);
/* 2128 */         if (d1 <= d)
/* 2129 */         { entity = entity1;
/* 2130 */           d = d1; } 
/*      */       } 
/* 2132 */     }  return entity;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public List func_72910_y() {
/* 2139 */     return this.field_72996_f;
/*      */   }
/*      */   
/*      */   public void func_147476_b(int p_147476_1_, int p_147476_2_, int p_147476_3_, TileEntity p_147476_4_) {
/* 2143 */     if (func_72899_e(p_147476_1_, p_147476_2_, p_147476_3_)) {
/* 2144 */       func_72938_d(p_147476_1_, p_147476_3_).func_76630_e();
/*      */     }
/*      */   }
/*      */   
/*      */   public int func_72907_a(Class p_72907_1_) {
/* 2149 */     byte b1 = 0;
/* 2150 */     for (byte b2 = 0; b2 < this.field_72996_f.size(); b2++) {
/* 2151 */       Entity entity = this.field_72996_f.get(b2);
/* 2152 */       if ((!(entity instanceof EntityLiving) || !((EntityLiving)entity).func_104002_bU()) && 
/* 2153 */         p_72907_1_.isAssignableFrom(entity.getClass())) b1++; 
/*      */     } 
/* 2155 */     return b1;
/*      */   }
/*      */   
/*      */   public void func_72868_a(List<Entity> p_72868_1_) {
/* 2159 */     this.field_72996_f.addAll(p_72868_1_);
/* 2160 */     for (byte b = 0; b < p_72868_1_.size(); b++) {
/* 2161 */       func_72923_a(p_72868_1_.get(b));
/*      */     }
/*      */   }
/*      */   
/*      */   public void func_72828_b(List p_72828_1_) {
/* 2166 */     this.field_72997_g.addAll(p_72828_1_);
/*      */   }
/*      */   
/*      */   public boolean func_147472_a(Block p_147472_1_, int p_147472_2_, int p_147472_3_, int p_147472_4_, boolean p_147472_5_, int p_147472_6_, Entity p_147472_7_, ItemStack p_147472_8_) {
/* 2170 */     Block block = func_147439_a(p_147472_2_, p_147472_3_, p_147472_4_);
/*      */     
/* 2172 */     AxisAlignedBB axisAlignedBB = p_147472_5_ ? null : p_147472_1_.func_149668_a(this, p_147472_2_, p_147472_3_, p_147472_4_);
/* 2173 */     if (axisAlignedBB != null && !func_72917_a(axisAlignedBB, p_147472_7_)) return false;
/*      */ 
/*      */     
/* 2176 */     if (block.func_149688_o() == Material.field_151594_q && p_147472_1_ == Blocks.field_150467_bQ) return true;
/*      */     
/* 2178 */     return (block.func_149688_o().func_76222_j() && p_147472_1_.func_149705_a(this, p_147472_2_, p_147472_3_, p_147472_4_, p_147472_6_, p_147472_8_));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PathEntity func_72865_a(Entity p_72865_1_, Entity p_72865_2_, float p_72865_3_, boolean p_72865_4_, boolean p_72865_5_, boolean p_72865_6_, boolean p_72865_7_) {
/* 2187 */     this.field_72984_F.func_76320_a("pathfind");
/* 2188 */     int i = MathHelper.func_76128_c(p_72865_1_.field_70165_t);
/* 2189 */     int j = MathHelper.func_76128_c(p_72865_1_.field_70163_u + 1.0D);
/* 2190 */     int k = MathHelper.func_76128_c(p_72865_1_.field_70161_v);
/*      */     
/* 2192 */     int m = (int)(p_72865_3_ + 16.0F);
/* 2193 */     int n = i - m;
/* 2194 */     int i1 = j - m;
/* 2195 */     int i2 = k - m;
/* 2196 */     int i3 = i + m;
/* 2197 */     int i4 = j + m;
/* 2198 */     int i5 = k + m;
/* 2199 */     ChunkCache chunkCache = new ChunkCache(this, n, i1, i2, i3, i4, i5, 0);
/* 2200 */     PathEntity pathEntity = (new PathFinder(chunkCache, p_72865_4_, p_72865_5_, p_72865_6_, p_72865_7_)).func_75856_a(p_72865_1_, p_72865_2_, p_72865_3_);
/* 2201 */     this.field_72984_F.func_76319_b();
/* 2202 */     return pathEntity;
/*      */   }
/*      */   
/*      */   public PathEntity func_72844_a(Entity p_72844_1_, int p_72844_2_, int p_72844_3_, int p_72844_4_, float p_72844_5_, boolean p_72844_6_, boolean p_72844_7_, boolean p_72844_8_, boolean p_72844_9_) {
/* 2206 */     this.field_72984_F.func_76320_a("pathfind");
/* 2207 */     int i = MathHelper.func_76128_c(p_72844_1_.field_70165_t);
/* 2208 */     int j = MathHelper.func_76128_c(p_72844_1_.field_70163_u);
/* 2209 */     int k = MathHelper.func_76128_c(p_72844_1_.field_70161_v);
/*      */     
/* 2211 */     int m = (int)(p_72844_5_ + 8.0F);
/* 2212 */     int n = i - m;
/* 2213 */     int i1 = j - m;
/* 2214 */     int i2 = k - m;
/* 2215 */     int i3 = i + m;
/* 2216 */     int i4 = j + m;
/* 2217 */     int i5 = k + m;
/* 2218 */     ChunkCache chunkCache = new ChunkCache(this, n, i1, i2, i3, i4, i5, 0);
/* 2219 */     PathEntity pathEntity = (new PathFinder(chunkCache, p_72844_6_, p_72844_7_, p_72844_8_, p_72844_9_)).func_75859_a(p_72844_1_, p_72844_2_, p_72844_3_, p_72844_4_, p_72844_5_);
/* 2220 */     this.field_72984_F.func_76319_b();
/* 2221 */     return pathEntity;
/*      */   }
/*      */ 
/*      */   
/*      */   public int func_72879_k(int p_72879_1_, int p_72879_2_, int p_72879_3_, int p_72879_4_) {
/* 2226 */     return func_147439_a(p_72879_1_, p_72879_2_, p_72879_3_).func_149748_c(this, p_72879_1_, p_72879_2_, p_72879_3_, p_72879_4_);
/*      */   }
/*      */   
/*      */   public int func_94577_B(int p_94577_1_, int p_94577_2_, int p_94577_3_) {
/* 2230 */     int i = 0;
/* 2231 */     i = Math.max(i, func_72879_k(p_94577_1_, p_94577_2_ - 1, p_94577_3_, 0));
/* 2232 */     if (i >= 15) return i; 
/* 2233 */     i = Math.max(i, func_72879_k(p_94577_1_, p_94577_2_ + 1, p_94577_3_, 1));
/* 2234 */     if (i >= 15) return i; 
/* 2235 */     i = Math.max(i, func_72879_k(p_94577_1_, p_94577_2_, p_94577_3_ - 1, 2));
/* 2236 */     if (i >= 15) return i; 
/* 2237 */     i = Math.max(i, func_72879_k(p_94577_1_, p_94577_2_, p_94577_3_ + 1, 3));
/* 2238 */     if (i >= 15) return i; 
/* 2239 */     i = Math.max(i, func_72879_k(p_94577_1_ - 1, p_94577_2_, p_94577_3_, 4));
/* 2240 */     if (i >= 15) return i; 
/* 2241 */     i = Math.max(i, func_72879_k(p_94577_1_ + 1, p_94577_2_, p_94577_3_, 5));
/* 2242 */     if (i >= 15) return i; 
/* 2243 */     return i;
/*      */   }
/*      */   
/*      */   public boolean func_94574_k(int p_94574_1_, int p_94574_2_, int p_94574_3_, int p_94574_4_) {
/* 2247 */     return (func_72878_l(p_94574_1_, p_94574_2_, p_94574_3_, p_94574_4_) > 0);
/*      */   }
/*      */   
/*      */   public int func_72878_l(int p_72878_1_, int p_72878_2_, int p_72878_3_, int p_72878_4_) {
/* 2251 */     if (func_147439_a(p_72878_1_, p_72878_2_, p_72878_3_).func_149721_r()) {
/* 2252 */       return func_94577_B(p_72878_1_, p_72878_2_, p_72878_3_);
/*      */     }
/* 2254 */     return func_147439_a(p_72878_1_, p_72878_2_, p_72878_3_).func_149709_b(this, p_72878_1_, p_72878_2_, p_72878_3_, p_72878_4_);
/*      */   }
/*      */   
/*      */   public boolean func_72864_z(int p_72864_1_, int p_72864_2_, int p_72864_3_) {
/* 2258 */     if (func_72878_l(p_72864_1_, p_72864_2_ - 1, p_72864_3_, 0) > 0) return true; 
/* 2259 */     if (func_72878_l(p_72864_1_, p_72864_2_ + 1, p_72864_3_, 1) > 0) return true; 
/* 2260 */     if (func_72878_l(p_72864_1_, p_72864_2_, p_72864_3_ - 1, 2) > 0) return true; 
/* 2261 */     if (func_72878_l(p_72864_1_, p_72864_2_, p_72864_3_ + 1, 3) > 0) return true; 
/* 2262 */     if (func_72878_l(p_72864_1_ - 1, p_72864_2_, p_72864_3_, 4) > 0) return true; 
/* 2263 */     if (func_72878_l(p_72864_1_ + 1, p_72864_2_, p_72864_3_, 5) > 0) return true; 
/* 2264 */     return false;
/*      */   }
/*      */   
/*      */   public int func_94572_D(int p_94572_1_, int p_94572_2_, int p_94572_3_) {
/* 2268 */     int i = 0;
/*      */     
/* 2270 */     for (byte b = 0; b < 6; b++) {
/* 2271 */       int j = func_72878_l(p_94572_1_ + Facing.field_71586_b[b], p_94572_2_ + Facing.field_71587_c[b], p_94572_3_ + Facing.field_71585_d[b], b);
/*      */       
/* 2273 */       if (j >= 15) return 15; 
/* 2274 */       if (j > i) i = j;
/*      */     
/*      */     } 
/* 2277 */     return i;
/*      */   }
/*      */   
/*      */   public EntityPlayer func_72890_a(Entity p_72890_1_, double p_72890_2_) {
/* 2281 */     return func_72977_a(p_72890_1_.field_70165_t, p_72890_1_.field_70163_u, p_72890_1_.field_70161_v, p_72890_2_);
/*      */   }
/*      */   
/*      */   public EntityPlayer func_72977_a(double p_72977_1_, double p_72977_3_, double p_72977_5_, double p_72977_7_) {
/* 2285 */     double d = -1.0D;
/* 2286 */     EntityPlayer entityPlayer = null;
/* 2287 */     for (byte b = 0; b < this.field_73010_i.size(); b++) {
/* 2288 */       EntityPlayer entityPlayer1 = this.field_73010_i.get(b);
/* 2289 */       double d1 = entityPlayer1.func_70092_e(p_72977_1_, p_72977_3_, p_72977_5_);
/* 2290 */       if ((p_72977_7_ < 0.0D || d1 < p_72977_7_ * p_72977_7_) && (d == -1.0D || d1 < d)) {
/* 2291 */         d = d1;
/* 2292 */         entityPlayer = entityPlayer1;
/*      */       } 
/*      */     } 
/* 2295 */     return entityPlayer;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public EntityPlayer func_72856_b(Entity p_72856_1_, double p_72856_2_) {
/* 2313 */     return func_72846_b(p_72856_1_.field_70165_t, p_72856_1_.field_70163_u, p_72856_1_.field_70161_v, p_72856_2_);
/*      */   }
/*      */   
/*      */   public EntityPlayer func_72846_b(double p_72846_1_, double p_72846_3_, double p_72846_5_, double p_72846_7_) {
/* 2317 */     double d = -1.0D;
/* 2318 */     EntityPlayer entityPlayer = null;
/* 2319 */     for (byte b = 0; b < this.field_73010_i.size(); b++) {
/* 2320 */       EntityPlayer entityPlayer1 = this.field_73010_i.get(b);
/* 2321 */       if (!entityPlayer1.field_71075_bZ.field_75102_a && entityPlayer1.func_70089_S()) {
/*      */ 
/*      */         
/* 2324 */         double d1 = entityPlayer1.func_70092_e(p_72846_1_, p_72846_3_, p_72846_5_);
/* 2325 */         double d2 = p_72846_7_;
/*      */         
/* 2327 */         if (entityPlayer1.func_70093_af()) {
/* 2328 */           d2 *= 0.800000011920929D;
/*      */         }
/* 2330 */         if (entityPlayer1.func_82150_aj()) {
/* 2331 */           float f = entityPlayer1.func_82243_bO();
/* 2332 */           if (f < 0.1F) {
/* 2333 */             f = 0.1F;
/*      */           }
/* 2335 */           d2 *= (0.7F * f);
/*      */         } 
/* 2337 */         if ((p_72846_7_ < 0.0D || d1 < d2 * d2) && (d == -1.0D || d1 < d)) {
/* 2338 */           d = d1;
/* 2339 */           entityPlayer = entityPlayer1;
/*      */         } 
/*      */       } 
/* 2342 */     }  return entityPlayer;
/*      */   }
/*      */   
/*      */   public EntityPlayer func_72924_a(String p_72924_1_) {
/* 2346 */     for (byte b = 0; b < this.field_73010_i.size(); b++) {
/* 2347 */       EntityPlayer entityPlayer = this.field_73010_i.get(b);
/* 2348 */       if (p_72924_1_.equals(entityPlayer.func_70005_c_())) {
/* 2349 */         return entityPlayer;
/*      */       }
/*      */     } 
/* 2352 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public EntityPlayer func_152378_a(UUID p_152378_1_) {
/* 2357 */     for (byte b = 0; b < this.field_73010_i.size(); b++) {
/* 2358 */       EntityPlayer entityPlayer = this.field_73010_i.get(b);
/* 2359 */       if (p_152378_1_.equals(entityPlayer.func_110124_au())) {
/* 2360 */         return entityPlayer;
/*      */       }
/*      */     } 
/* 2363 */     return null;
/*      */   }
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public void func_72882_A() {}
/*      */   
/*      */   public void func_72906_B() throws MinecraftException {
/* 2370 */     this.field_73019_z.func_75762_c();
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public void func_82738_a(long p_82738_1_) {
/* 2374 */     this.field_72986_A.func_82572_b(p_82738_1_);
/*      */   }
/*      */   
/*      */   public long func_72905_C() {
/* 2378 */     return this.field_72986_A.func_76063_b();
/*      */   }
/*      */   
/*      */   public long func_82737_E() {
/* 2382 */     return this.field_72986_A.func_82573_f();
/*      */   }
/*      */   
/*      */   public long func_72820_D() {
/* 2386 */     return this.field_72986_A.func_76073_f();
/*      */   }
/*      */   
/*      */   public void func_72877_b(long p_72877_1_) {
/* 2390 */     this.field_72986_A.func_76068_b(p_72877_1_);
/*      */   }
/*      */ 
/*      */   
/*      */   public ChunkCoordinates func_72861_E() {
/* 2395 */     return new ChunkCoordinates(this.field_72986_A.func_76079_c(), this.field_72986_A.func_76075_d(), this.field_72986_A.func_76074_e());
/*      */   }
/*      */   
/*      */   public void func_72950_A(int p_72950_1_, int p_72950_2_, int p_72950_3_) {
/* 2399 */     this.field_72986_A.func_76081_a(p_72950_1_, p_72950_2_, p_72950_3_);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public void func_72897_h(Entity p_72897_1_) {
/* 2407 */     int i = MathHelper.func_76128_c(p_72897_1_.field_70165_t / 16.0D);
/* 2408 */     int j = MathHelper.func_76128_c(p_72897_1_.field_70161_v / 16.0D);
/* 2409 */     byte b = 2;
/* 2410 */     for (int k = i - b; k <= i + b; k++) {
/* 2411 */       for (int m = j - b; m <= j + b; m++) {
/* 2412 */         func_72964_e(k, m);
/*      */       }
/*      */     } 
/*      */     
/* 2416 */     if (!this.field_72996_f.contains(p_72897_1_)) {
/* 2417 */       this.field_72996_f.add(p_72897_1_);
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean func_72962_a(EntityPlayer p_72962_1_, int p_72962_2_, int p_72962_3_, int p_72962_4_) {
/* 2422 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_72960_a(Entity p_72960_1_, byte p_72960_2_) {}
/*      */ 
/*      */   
/*      */   public IChunkProvider func_72863_F() {
/* 2430 */     return this.field_73020_y;
/*      */   }
/*      */   
/*      */   public void func_147452_c(int p_147452_1_, int p_147452_2_, int p_147452_3_, Block p_147452_4_, int p_147452_5_, int p_147452_6_) {
/* 2434 */     p_147452_4_.func_149696_a(this, p_147452_1_, p_147452_2_, p_147452_3_, p_147452_5_, p_147452_6_);
/*      */   }
/*      */ 
/*      */   
/*      */   public ISaveHandler func_72860_G() {
/* 2439 */     return this.field_73019_z;
/*      */   }
/*      */ 
/*      */   
/*      */   public WorldInfo func_72912_H() {
/* 2444 */     return this.field_72986_A;
/*      */   }
/*      */ 
/*      */   
/*      */   public GameRules func_82736_K() {
/* 2449 */     return this.field_72986_A.func_82574_x();
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_72854_c() {}
/*      */   
/*      */   public float func_72819_i(float p_72819_1_) {
/* 2456 */     return (this.field_73018_p + (this.field_73017_q - this.field_73018_p) * p_72819_1_) * func_72867_j(p_72819_1_);
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public void func_147442_i(float p_147442_1_) {
/* 2460 */     this.field_73018_p = p_147442_1_;
/* 2461 */     this.field_73017_q = p_147442_1_;
/*      */   }
/*      */   
/*      */   public float func_72867_j(float p_72867_1_) {
/* 2465 */     return this.field_73003_n + (this.field_73004_o - this.field_73003_n) * p_72867_1_;
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public void func_72894_k(float p_72894_1_) {
/* 2469 */     this.field_73003_n = p_72894_1_;
/* 2470 */     this.field_73004_o = p_72894_1_;
/*      */   }
/*      */   
/*      */   public boolean func_72911_I() {
/* 2474 */     return (func_72819_i(1.0F) > 0.9D);
/*      */   }
/*      */   
/*      */   public boolean func_72896_J() {
/* 2478 */     return (func_72867_j(1.0F) > 0.2D);
/*      */   }
/*      */   
/*      */   public boolean func_72951_B(int p_72951_1_, int p_72951_2_, int p_72951_3_) {
/* 2482 */     if (!func_72896_J()) return false; 
/* 2483 */     if (!func_72937_j(p_72951_1_, p_72951_2_, p_72951_3_)) return false; 
/* 2484 */     if (func_72874_g(p_72951_1_, p_72951_3_) > p_72951_2_) return false;
/*      */     
/* 2486 */     BiomeGenBase biomeGenBase = func_72807_a(p_72951_1_, p_72951_3_);
/* 2487 */     if (biomeGenBase.func_76746_c()) return false; 
/* 2488 */     if (func_147478_e(p_72951_1_, p_72951_2_, p_72951_3_, false)) return false; 
/* 2489 */     return biomeGenBase.func_76738_d();
/*      */   }
/*      */   
/*      */   public boolean func_72958_C(int p_72958_1_, int p_72958_2_, int p_72958_3_) {
/* 2493 */     BiomeGenBase biomeGenBase = func_72807_a(p_72958_1_, p_72958_3_);
/* 2494 */     return biomeGenBase.func_76736_e();
/*      */   }
/*      */   
/*      */   public void func_72823_a(String p_72823_1_, WorldSavedData p_72823_2_) {
/* 2498 */     this.field_72988_C.func_75745_a(p_72823_1_, p_72823_2_);
/*      */   }
/*      */   
/*      */   public WorldSavedData func_72943_a(Class p_72943_1_, String p_72943_2_) {
/* 2502 */     return this.field_72988_C.func_75742_a(p_72943_1_, p_72943_2_);
/*      */   }
/*      */   
/*      */   public int func_72841_b(String p_72841_1_) {
/* 2506 */     return this.field_72988_C.func_75743_a(p_72841_1_);
/*      */   }
/*      */   
/*      */   public void func_82739_e(int p_82739_1_, int p_82739_2_, int p_82739_3_, int p_82739_4_, int p_82739_5_) {
/* 2510 */     for (byte b = 0; b < this.field_73021_x.size(); b++) {
/* 2511 */       ((IWorldAccess)this.field_73021_x.get(b)).func_82746_a(p_82739_1_, p_82739_2_, p_82739_3_, p_82739_4_, p_82739_5_);
/*      */     }
/*      */   }
/*      */   
/*      */   public void func_72926_e(int p_72926_1_, int p_72926_2_, int p_72926_3_, int p_72926_4_, int p_72926_5_) {
/* 2516 */     func_72889_a(null, p_72926_1_, p_72926_2_, p_72926_3_, p_72926_4_, p_72926_5_);
/*      */   }
/*      */   
/*      */   public void func_72889_a(EntityPlayer p_72889_1_, int p_72889_2_, int p_72889_3_, int p_72889_4_, int p_72889_5_, int p_72889_6_) {
/*      */     try {
/* 2521 */       for (byte b = 0; b < this.field_73021_x.size(); b++) {
/* 2522 */         ((IWorldAccess)this.field_73021_x.get(b)).func_72706_a(p_72889_1_, p_72889_2_, p_72889_3_, p_72889_4_, p_72889_5_, p_72889_6_);
/*      */       }
/* 2524 */     } catch (Throwable throwable) {
/* 2525 */       CrashReport crashReport = CrashReport.func_85055_a(throwable, "Playing level event");
/* 2526 */       CrashReportCategory crashReportCategory = crashReport.func_85058_a("Level event being played");
/*      */       
/* 2528 */       crashReportCategory.func_71507_a("Block coordinates", CrashReportCategory.func_85071_a(p_72889_3_, p_72889_4_, p_72889_5_));
/* 2529 */       crashReportCategory.func_71507_a("Event source", p_72889_1_);
/* 2530 */       crashReportCategory.func_71507_a("Event type", Integer.valueOf(p_72889_2_));
/* 2531 */       crashReportCategory.func_71507_a("Event data", Integer.valueOf(p_72889_6_));
/*      */       
/* 2533 */       throw new ReportedException(crashReport);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public int func_72800_K() {
/* 2539 */     return 256;
/*      */   }
/*      */   
/*      */   public int func_72940_L() {
/* 2543 */     return this.field_73011_w.field_76576_e ? 128 : 256;
/*      */   }
/*      */ 
/*      */   
/*      */   public Random func_72843_D(int p_72843_1_, int p_72843_2_, int p_72843_3_) {
/* 2548 */     long l = p_72843_1_ * 341873128712L + p_72843_2_ * 132897987541L + func_72912_H().func_76063_b() + p_72843_3_;
/* 2549 */     this.field_73012_v.setSeed(l);
/* 2550 */     return this.field_73012_v;
/*      */   }
/*      */   
/*      */   public ChunkPosition func_147440_b(String p_147440_1_, int p_147440_2_, int p_147440_3_, int p_147440_4_) {
/* 2554 */     return func_72863_F().func_147416_a(this, p_147440_1_, p_147440_2_, p_147440_3_, p_147440_4_);
/*      */   }
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public boolean func_72806_N() {
/* 2559 */     return false;
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public double func_72919_O() {
/* 2563 */     if (this.field_72986_A.func_76067_t() == WorldType.field_77138_c) {
/* 2564 */       return 0.0D;
/*      */     }
/* 2566 */     return 63.0D;
/*      */   }
/*      */ 
/*      */   
/*      */   public CrashReportCategory func_72914_a(CrashReport p_72914_1_) {
/* 2571 */     CrashReportCategory crashReportCategory = p_72914_1_.func_85057_a("Affected level", 1);
/*      */     
/* 2573 */     crashReportCategory.func_71507_a("Level name", (this.field_72986_A == null) ? "????" : this.field_72986_A.func_76065_j());
/*      */     
/* 2575 */     crashReportCategory.func_71500_a("All players", new Callable(this) { private static final String __OBFID = "CL_00000143";
/*      */           
/*      */           public String call() {
/* 2578 */             return this.field_77440_a.field_73010_i.size() + " total; " + this.field_77440_a.field_73010_i.toString();
/*      */           } }
/*      */       );
/*      */     
/* 2582 */     crashReportCategory.func_71500_a("Chunk stats", new Callable(this) { private static final String __OBFID = "CL_00000144";
/*      */           
/*      */           public String call() {
/* 2585 */             return this.field_151308_a.field_73020_y.func_73148_d();
/*      */           } }
/*      */       );
/*      */     
/*      */     try {
/* 2590 */       this.field_72986_A.func_85118_a(crashReportCategory);
/* 2591 */     } catch (Throwable throwable) {
/* 2592 */       crashReportCategory.func_71499_a("Level Data Unobtainable", throwable);
/*      */     } 
/*      */     
/* 2595 */     return crashReportCategory;
/*      */   }
/*      */   
/*      */   public void func_147443_d(int p_147443_1_, int p_147443_2_, int p_147443_3_, int p_147443_4_, int p_147443_5_) {
/* 2599 */     for (byte b = 0; b < this.field_73021_x.size(); b++) {
/* 2600 */       IWorldAccess iWorldAccess = this.field_73021_x.get(b);
/* 2601 */       iWorldAccess.func_147587_b(p_147443_1_, p_147443_2_, p_147443_3_, p_147443_4_, p_147443_5_);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public Calendar func_83015_S() {
/* 2607 */     if (func_82737_E() % 600L == 0L) {
/* 2608 */       this.field_83016_L.setTimeInMillis(MinecraftServer.func_130071_aq());
/*      */     }
/* 2610 */     return this.field_83016_L;
/*      */   }
/*      */ 
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public void func_92088_a(double p_92088_1_, double p_92088_3_, double p_92088_5_, double p_92088_7_, double p_92088_9_, double p_92088_11_, NBTTagCompound p_92088_13_) {}
/*      */ 
/*      */   
/*      */   public Scoreboard func_96441_U() {
/* 2619 */     return this.field_96442_D;
/*      */   }
/*      */   
/*      */   public void func_147453_f(int p_147453_1_, int p_147453_2_, int p_147453_3_, Block p_147453_4_) {
/* 2623 */     for (byte b = 0; b < 4; b++) {
/* 2624 */       int i = p_147453_1_ + Direction.field_71583_a[b];
/* 2625 */       int j = p_147453_3_ + Direction.field_71581_b[b];
/*      */       
/* 2627 */       Block block = func_147439_a(i, p_147453_2_, j);
/*      */       
/* 2629 */       if (Blocks.field_150441_bU.func_149907_e(block)) {
/* 2630 */         block.func_149695_a(this, i, p_147453_2_, j, p_147453_4_);
/* 2631 */       } else if (block.func_149721_r()) {
/* 2632 */         i += Direction.field_71583_a[b];
/* 2633 */         j += Direction.field_71581_b[b];
/*      */         
/* 2635 */         Block block1 = func_147439_a(i, p_147453_2_, j);
/* 2636 */         if (Blocks.field_150441_bU.func_149907_e(block1)) {
/* 2637 */           block1.func_149695_a(this, i, p_147453_2_, j, p_147453_4_);
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public float func_147462_b(double p_147462_1_, double p_147462_3_, double p_147462_5_) {
/* 2644 */     return func_147473_B(MathHelper.func_76128_c(p_147462_1_), MathHelper.func_76128_c(p_147462_3_), MathHelper.func_76128_c(p_147462_5_));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public float func_147473_B(int p_147473_1_, int p_147473_2_, int p_147473_3_) {
/* 2652 */     float f = 0.0F;
/* 2653 */     boolean bool = (this.field_73013_u == EnumDifficulty.HARD) ? true : false;
/*      */     
/* 2655 */     if (func_72899_e(p_147473_1_, p_147473_2_, p_147473_3_)) {
/* 2656 */       float f1 = func_130001_d();
/*      */       
/* 2658 */       f += MathHelper.func_76131_a((float)(func_72938_d(p_147473_1_, p_147473_3_)).field_111204_q / 3600000.0F, 0.0F, 1.0F) * (bool ? 1.0F : 0.75F);
/* 2659 */       f += f1 * 0.25F;
/*      */     } 
/*      */     
/* 2662 */     if (this.field_73013_u == EnumDifficulty.EASY || this.field_73013_u == EnumDifficulty.PEACEFUL) {
/* 2663 */       f *= this.field_73013_u.func_151525_a() / 2.0F;
/*      */     }
/*      */     
/* 2666 */     return MathHelper.func_76131_a(f, 0.0F, bool ? 1.5F : 1.0F);
/*      */   }
/*      */   
/*      */   public void func_147450_X() {
/* 2670 */     for (IWorldAccess iWorldAccess : this.field_73021_x)
/* 2671 */       iWorldAccess.func_147584_b(); 
/*      */   }
/*      */   
/*      */   protected abstract IChunkProvider func_72970_h();
/*      */   
/*      */   protected abstract int func_152379_p();
/*      */   
/*      */   public abstract Entity func_73045_a(int paramInt);
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\World.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */