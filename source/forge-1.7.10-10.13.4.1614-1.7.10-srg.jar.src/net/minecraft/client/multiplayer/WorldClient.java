/*     */ package net.minecraft.client.multiplayer;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.HashSet;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.Callable;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.audio.ISound;
/*     */ import net.minecraft.client.audio.PositionedSoundRecord;
/*     */ import net.minecraft.client.network.NetHandlerPlayClient;
/*     */ import net.minecraft.client.particle.EntityFireworkStarterFX;
/*     */ import net.minecraft.client.renderer.entity.RenderManager;
/*     */ import net.minecraft.crash.CrashReport;
/*     */ import net.minecraft.crash.CrashReportCategory;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.profiler.Profiler;
/*     */ import net.minecraft.scoreboard.Scoreboard;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.util.IntHashMap;
/*     */ import net.minecraft.world.ChunkCoordIntPair;
/*     */ import net.minecraft.world.EnumDifficulty;
/*     */ import net.minecraft.world.WorldSettings;
/*     */ import net.minecraft.world.chunk.Chunk;
/*     */ import net.minecraft.world.chunk.IChunkProvider;
/*     */ import net.minecraft.world.storage.ISaveHandler;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class WorldClient extends World {
/*     */   private NetHandlerPlayClient field_73035_a;
/*  34 */   private IntHashMap field_73034_c = new IntHashMap(); private ChunkProviderClient field_73033_b;
/*  35 */   private Set field_73032_d = new HashSet();
/*  36 */   private Set field_73036_L = new HashSet();
/*  37 */   private final Minecraft field_73037_M = Minecraft.func_71410_x();
/*  38 */   private final Set field_73038_N = new HashSet();
/*     */   private static final String __OBFID = "CL_00000882";
/*     */   
/*     */   public WorldClient(NetHandlerPlayClient p_i45063_1_, WorldSettings p_i45063_2_, int p_i45063_3_, EnumDifficulty p_i45063_4_, Profiler p_i45063_5_) {
/*  42 */     super((ISaveHandler)new SaveHandlerMP(), "MpServer", WorldProvider.func_76570_a(p_i45063_3_), p_i45063_2_, p_i45063_5_);
/*     */     
/*  44 */     this.field_73035_a = p_i45063_1_;
/*  45 */     this.field_73013_u = p_i45063_4_;
/*  46 */     func_72950_A(8, 64, 8);
/*  47 */     this.field_72988_C = p_i45063_1_.field_147305_a;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_72835_b() {
/*  52 */     super.func_72835_b();
/*  53 */     func_82738_a(func_82737_E() + 1L);
/*  54 */     if (func_82736_K().func_82766_b("doDaylightCycle")) {
/*  55 */       func_72877_b(func_72820_D() + 1L);
/*     */     }
/*     */     
/*  58 */     this.field_72984_F.func_76320_a("reEntryProcessing");
/*  59 */     for (byte b = 0; b < 10 && !this.field_73036_L.isEmpty(); b++) {
/*  60 */       Entity entity = this.field_73036_L.iterator().next();
/*  61 */       this.field_73036_L.remove(entity);
/*  62 */       if (!this.field_72996_f.contains(entity)) func_72838_d(entity);
/*     */     
/*     */     } 
/*  65 */     this.field_72984_F.func_76318_c("connection");
/*  66 */     this.field_73035_a.func_147233_a();
/*  67 */     this.field_72984_F.func_76318_c("chunkCache");
/*  68 */     this.field_73033_b.func_73156_b();
/*     */     
/*  70 */     this.field_72984_F.func_76318_c("blocks");
/*  71 */     func_147456_g();
/*     */     
/*  73 */     this.field_72984_F.func_76319_b();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73031_a(int p_73031_1_, int p_73031_2_, int p_73031_3_, int p_73031_4_, int p_73031_5_, int p_73031_6_) {}
/*     */ 
/*     */   
/*     */   protected IChunkProvider func_72970_h() {
/*  82 */     this.field_73033_b = new ChunkProviderClient(this);
/*  83 */     return this.field_73033_b;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_147456_g() {
/*  88 */     super.func_147456_g();
/*     */     
/*  90 */     this.field_73038_N.retainAll(this.field_72993_I);
/*  91 */     if (this.field_73038_N.size() == this.field_72993_I.size()) {
/*  92 */       this.field_73038_N.clear();
/*     */     }
/*     */     
/*  95 */     byte b = 0;
/*     */     
/*  97 */     for (ChunkCoordIntPair chunkCoordIntPair : this.field_72993_I) {
/*  98 */       if (this.field_73038_N.contains(chunkCoordIntPair))
/*  99 */         continue;  int i = chunkCoordIntPair.field_77276_a * 16;
/* 100 */       int j = chunkCoordIntPair.field_77275_b * 16;
/*     */       
/* 102 */       this.field_72984_F.func_76320_a("getChunk");
/* 103 */       Chunk chunk = func_72964_e(chunkCoordIntPair.field_77276_a, chunkCoordIntPair.field_77275_b);
/*     */       
/* 105 */       func_147467_a(i, j, chunk);
/*     */       
/* 107 */       this.field_72984_F.func_76319_b();
/*     */       
/* 109 */       this.field_73038_N.add(chunkCoordIntPair);
/* 110 */       if (++b >= 10) {
/*     */         return;
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_73025_a(int p_73025_1_, int p_73025_2_, boolean p_73025_3_) {
/* 117 */     if (p_73025_3_) { this.field_73033_b.func_73158_c(p_73025_1_, p_73025_2_); }
/* 118 */     else { this.field_73033_b.func_73234_b(p_73025_1_, p_73025_2_); }
/* 119 */      if (!p_73025_3_) {
/* 120 */       func_147458_c(p_73025_1_ * 16, 0, p_73025_2_ * 16, p_73025_1_ * 16 + 15, 256, p_73025_2_ * 16 + 15);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_72838_d(Entity p_72838_1_) {
/* 126 */     boolean bool = super.func_72838_d(p_72838_1_);
/* 127 */     this.field_73032_d.add(p_72838_1_);
/*     */     
/* 129 */     if (!bool) {
/* 130 */       this.field_73036_L.add(p_72838_1_);
/*     */     }
/* 132 */     else if (p_72838_1_ instanceof EntityMinecart) {
/* 133 */       this.field_73037_M.func_147118_V().func_147682_a((ISound)new MovingSoundMinecart((EntityMinecart)p_72838_1_));
/*     */     } 
/*     */ 
/*     */     
/* 137 */     return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_72900_e(Entity p_72900_1_) {
/* 142 */     super.func_72900_e(p_72900_1_);
/* 143 */     this.field_73032_d.remove(p_72900_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_72923_a(Entity p_72923_1_) {
/* 148 */     super.func_72923_a(p_72923_1_);
/* 149 */     if (this.field_73036_L.contains(p_72923_1_)) {
/* 150 */       this.field_73036_L.remove(p_72923_1_);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_72847_b(Entity p_72847_1_) {
/* 156 */     super.func_72847_b(p_72847_1_);
/* 157 */     boolean bool = false;
/* 158 */     if (this.field_73032_d.contains(p_72847_1_)) {
/* 159 */       if (p_72847_1_.func_70089_S()) {
/* 160 */         this.field_73036_L.add(p_72847_1_);
/* 161 */         bool = true;
/*     */       } else {
/* 163 */         this.field_73032_d.remove(p_72847_1_);
/*     */       } 
/*     */     }
/* 166 */     if (RenderManager.field_78727_a.func_78713_a(p_72847_1_).func_147905_a() && !bool) {
/* 167 */       this.field_73037_M.field_71438_f.func_147584_b();
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_73027_a(int p_73027_1_, Entity p_73027_2_) {
/* 172 */     Entity entity = func_73045_a(p_73027_1_);
/* 173 */     if (entity != null) {
/* 174 */       func_72900_e(entity);
/*     */     }
/*     */     
/* 177 */     this.field_73032_d.add(p_73027_2_);
/* 178 */     p_73027_2_.func_145769_d(p_73027_1_);
/* 179 */     if (!func_72838_d(p_73027_2_)) {
/* 180 */       this.field_73036_L.add(p_73027_2_);
/*     */     }
/* 182 */     this.field_73034_c.func_76038_a(p_73027_1_, p_73027_2_);
/* 183 */     if (RenderManager.field_78727_a.func_78713_a(p_73027_2_).func_147905_a()) {
/* 184 */       this.field_73037_M.field_71438_f.func_147584_b();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Entity func_73045_a(int p_73045_1_) {
/* 190 */     if (p_73045_1_ == this.field_73037_M.field_71439_g.func_145782_y()) {
/* 191 */       return (Entity)this.field_73037_M.field_71439_g;
/*     */     }
/* 193 */     return (Entity)this.field_73034_c.func_76041_a(p_73045_1_);
/*     */   }
/*     */   
/*     */   public Entity func_73028_b(int p_73028_1_) {
/* 197 */     Entity entity = (Entity)this.field_73034_c.func_76049_d(p_73028_1_);
/* 198 */     if (entity != null) {
/* 199 */       this.field_73032_d.remove(entity);
/* 200 */       func_72900_e(entity);
/*     */     } 
/* 202 */     return entity;
/*     */   }
/*     */   
/*     */   public boolean func_147492_c(int p_147492_1_, int p_147492_2_, int p_147492_3_, Block p_147492_4_, int p_147492_5_) {
/* 206 */     func_73031_a(p_147492_1_, p_147492_2_, p_147492_3_, p_147492_1_, p_147492_2_, p_147492_3_);
/* 207 */     if (func_147465_d(p_147492_1_, p_147492_2_, p_147492_3_, p_147492_4_, p_147492_5_, 3)) {
/* 208 */       return true;
/*     */     }
/* 210 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_72882_A() {
/* 215 */     this.field_73035_a.func_147298_b().func_150718_a((IChatComponent)new ChatComponentText("Quitting"));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_72979_l() {
/* 220 */     if (this.field_73011_w.field_76576_e)
/*     */       return; 
/*     */   }
/*     */   
/*     */   protected int func_152379_p() {
/* 225 */     return this.field_73037_M.field_71474_y.field_151451_c;
/*     */   }
/*     */   
/*     */   public void func_73029_E(int p_73029_1_, int p_73029_2_, int p_73029_3_) {
/* 229 */     byte b1 = 16;
/* 230 */     Random random = new Random();
/*     */     
/* 232 */     for (byte b2 = 0; b2 < 'Ϩ'; b2++) {
/* 233 */       int i = p_73029_1_ + this.field_73012_v.nextInt(b1) - this.field_73012_v.nextInt(b1);
/* 234 */       int j = p_73029_2_ + this.field_73012_v.nextInt(b1) - this.field_73012_v.nextInt(b1);
/* 235 */       int k = p_73029_3_ + this.field_73012_v.nextInt(b1) - this.field_73012_v.nextInt(b1);
/*     */       
/* 237 */       Block block = func_147439_a(i, j, k);
/* 238 */       if (block.func_149688_o() == Material.field_151579_a) {
/* 239 */         if (this.field_73012_v.nextInt(8) > j && this.field_73011_w.func_76564_j()) {
/* 240 */           func_72869_a("depthsuspend", (i + this.field_73012_v.nextFloat()), (j + this.field_73012_v.nextFloat()), (k + this.field_73012_v.nextFloat()), 0.0D, 0.0D, 0.0D);
/*     */         }
/*     */       } else {
/* 243 */         block.func_149734_b(this, i, j, k, random);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_73022_a() {
/* 249 */     this.field_72996_f.removeAll(this.field_72997_g); byte b;
/* 250 */     for (b = 0; b < this.field_72997_g.size(); b++) {
/* 251 */       Entity entity = this.field_72997_g.get(b);
/* 252 */       int i = entity.field_70176_ah;
/* 253 */       int j = entity.field_70164_aj;
/* 254 */       if (entity.field_70175_ag && func_72916_c(i, j)) {
/* 255 */         func_72964_e(i, j).func_76622_b(entity);
/*     */       }
/*     */     } 
/*     */     
/* 259 */     for (b = 0; b < this.field_72997_g.size(); b++) {
/* 260 */       func_72847_b(this.field_72997_g.get(b));
/*     */     }
/* 262 */     this.field_72997_g.clear();
/*     */     
/* 264 */     for (b = 0; b < this.field_72996_f.size(); b++) {
/* 265 */       Entity entity = this.field_72996_f.get(b);
/*     */       
/* 267 */       if (entity.field_70154_o != null)
/* 268 */         if (entity.field_70154_o.field_70128_L || entity.field_70154_o.field_70153_n != entity) {
/* 269 */           entity.field_70154_o.field_70153_n = null;
/* 270 */           entity.field_70154_o = null;
/*     */         } else {
/*     */           continue;
/*     */         }  
/* 274 */       if (entity.field_70128_L) {
/* 275 */         int i = entity.field_70176_ah;
/* 276 */         int j = entity.field_70164_aj;
/* 277 */         if (entity.field_70175_ag && func_72916_c(i, j)) {
/* 278 */           func_72964_e(i, j).func_76622_b(entity);
/*     */         }
/* 280 */         this.field_72996_f.remove(b--);
/* 281 */         func_72847_b(entity);
/*     */       } 
/*     */       continue;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public CrashReportCategory func_72914_a(CrashReport p_72914_1_) {
/* 289 */     CrashReportCategory crashReportCategory = super.func_72914_a(p_72914_1_);
/*     */     
/* 291 */     crashReportCategory.func_71500_a("Forced entities", new Callable(this) { private static final String __OBFID = "CL_00000883";
/*     */           
/*     */           public String call() {
/* 294 */             return this.field_78833_a.field_73032_d.size() + " total; " + this.field_78833_a.field_73032_d.toString();
/*     */           } }
/*     */       );
/*     */     
/* 298 */     crashReportCategory.func_71500_a("Retry entities", new Callable(this) { private static final String __OBFID = "CL_00000884";
/*     */           
/*     */           public String call() {
/* 301 */             return this.field_78835_a.field_73036_L.size() + " total; " + this.field_78835_a.field_73036_L.toString();
/*     */           } }
/*     */       );
/*     */     
/* 305 */     crashReportCategory.func_71500_a("Server brand", new Callable(this) { private static final String __OBFID = "CL_00000885";
/*     */           
/*     */           public String call() {
/* 308 */             return this.field_142027_a.field_73037_M.field_71439_g.func_142021_k();
/*     */           } }
/*     */       );
/*     */     
/* 312 */     crashReportCategory.func_71500_a("Server type", new Callable(this) { private static final String __OBFID = "CL_00000886";
/*     */           
/*     */           public String call() {
/* 315 */             return (this.field_142029_a.field_73037_M.func_71401_C() == null) ? "Non-integrated multiplayer server" : "Integrated singleplayer server";
/*     */           } }
/*     */       );
/*     */     
/* 319 */     return crashReportCategory;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_72980_b(double p_72980_1_, double p_72980_3_, double p_72980_5_, String p_72980_7_, float p_72980_8_, float p_72980_9_, boolean p_72980_10_) {
/* 324 */     double d = this.field_73037_M.field_71451_h.func_70092_e(p_72980_1_, p_72980_3_, p_72980_5_);
/* 325 */     PositionedSoundRecord positionedSoundRecord = new PositionedSoundRecord(new ResourceLocation(p_72980_7_), p_72980_8_, p_72980_9_, (float)p_72980_1_, (float)p_72980_3_, (float)p_72980_5_);
/*     */     
/* 327 */     if (p_72980_10_ && d > 100.0D) {
/*     */       
/* 329 */       double d1 = Math.sqrt(d) / 40.0D;
/* 330 */       this.field_73037_M.func_147118_V().func_147681_a((ISound)positionedSoundRecord, (int)(d1 * 20.0D));
/*     */     } else {
/* 332 */       this.field_73037_M.func_147118_V().func_147682_a((ISound)positionedSoundRecord);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_92088_a(double p_92088_1_, double p_92088_3_, double p_92088_5_, double p_92088_7_, double p_92088_9_, double p_92088_11_, NBTTagCompound p_92088_13_) {
/* 338 */     this.field_73037_M.field_71452_i.func_78873_a((EntityFX)new EntityFireworkStarterFX(this, p_92088_1_, p_92088_3_, p_92088_5_, p_92088_7_, p_92088_9_, p_92088_11_, this.field_73037_M.field_71452_i, p_92088_13_));
/*     */   }
/*     */   
/*     */   public void func_96443_a(Scoreboard p_96443_1_) {
/* 342 */     this.field_96442_D = p_96443_1_;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_72877_b(long p_72877_1_) {
/* 347 */     if (p_72877_1_ < 0L) {
/* 348 */       p_72877_1_ = -p_72877_1_;
/* 349 */       func_82736_K().func_82764_b("doDaylightCycle", "false");
/*     */     } else {
/* 351 */       func_82736_K().func_82764_b("doDaylightCycle", "true");
/*     */     } 
/* 353 */     super.func_72877_b(p_72877_1_);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\multiplayer\WorldClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */