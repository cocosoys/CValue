/*     */ package net.minecraft.world.gen;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import net.minecraft.crash.CrashReport;
/*     */ import net.minecraft.crash.CrashReportCategory;
/*     */ import net.minecraft.entity.EnumCreatureType;
/*     */ import net.minecraft.util.ChunkCoordinates;
/*     */ import net.minecraft.util.LongHashMap;
/*     */ import net.minecraft.world.ChunkCoordIntPair;
/*     */ import net.minecraft.world.MinecraftException;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldServer;
/*     */ import net.minecraft.world.chunk.Chunk;
/*     */ import net.minecraft.world.chunk.IChunkProvider;
/*     */ import net.minecraft.world.chunk.storage.IChunkLoader;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ 
/*     */ public class ChunkProviderServer implements IChunkProvider {
/*  21 */   private static final Logger field_147417_b = LogManager.getLogger();
/*     */   
/*  23 */   private Set field_73248_b = Collections.newSetFromMap(new ConcurrentHashMap<Object, Boolean>());
/*     */   
/*     */   private Chunk field_73249_c;
/*     */   public IChunkProvider field_73246_d;
/*     */   public IChunkLoader field_73247_e;
/*     */   public boolean field_73250_a = true;
/*  29 */   public LongHashMap field_73244_f = new LongHashMap();
/*  30 */   public List field_73245_g = new ArrayList(); public WorldServer field_73251_h;
/*     */   private static final String __OBFID = "CL_00001436";
/*     */   
/*     */   public ChunkProviderServer(WorldServer p_i1520_1_, IChunkLoader p_i1520_2_, IChunkProvider p_i1520_3_) {
/*  34 */     this.field_73249_c = (Chunk)new EmptyChunk((World)p_i1520_1_, 0, 0);
/*     */     
/*  36 */     this.field_73251_h = p_i1520_1_;
/*  37 */     this.field_73247_e = p_i1520_2_;
/*  38 */     this.field_73246_d = p_i1520_3_;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_73149_a(int p_73149_1_, int p_73149_2_) {
/*  43 */     return this.field_73244_f.func_76161_b(ChunkCoordIntPair.func_77272_a(p_73149_1_, p_73149_2_));
/*     */   }
/*     */   
/*     */   public List func_152380_a() {
/*  47 */     return this.field_73245_g;
/*     */   }
/*     */   
/*     */   public void func_73241_b(int p_73241_1_, int p_73241_2_) {
/*  51 */     if (this.field_73251_h.field_73011_w.func_76567_e()) {
/*  52 */       ChunkCoordinates chunkCoordinates = this.field_73251_h.func_72861_E();
/*  53 */       int i = p_73241_1_ * 16 + 8 - chunkCoordinates.field_71574_a;
/*  54 */       int j = p_73241_2_ * 16 + 8 - chunkCoordinates.field_71573_c;
/*  55 */       char c = '';
/*  56 */       if (i < -c || i > c || j < -c || j > c) {
/*  57 */         this.field_73248_b.add(Long.valueOf(ChunkCoordIntPair.func_77272_a(p_73241_1_, p_73241_2_)));
/*     */       }
/*     */     } else {
/*  60 */       this.field_73248_b.add(Long.valueOf(ChunkCoordIntPair.func_77272_a(p_73241_1_, p_73241_2_)));
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_73240_a() {
/*  65 */     for (Chunk chunk : this.field_73245_g) {
/*  66 */       func_73241_b(chunk.field_76635_g, chunk.field_76647_h);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Chunk func_73158_c(int p_73158_1_, int p_73158_2_) {
/*  73 */     long l = ChunkCoordIntPair.func_77272_a(p_73158_1_, p_73158_2_);
/*  74 */     this.field_73248_b.remove(Long.valueOf(l));
/*     */     
/*  76 */     Chunk chunk = (Chunk)this.field_73244_f.func_76164_a(l);
/*  77 */     if (chunk == null) {
/*  78 */       chunk = func_73239_e(p_73158_1_, p_73158_2_);
/*  79 */       if (chunk == null) {
/*  80 */         if (this.field_73246_d == null) {
/*  81 */           chunk = this.field_73249_c;
/*     */         } else {
/*     */           try {
/*  84 */             chunk = this.field_73246_d.func_73154_d(p_73158_1_, p_73158_2_);
/*  85 */           } catch (Throwable throwable) {
/*  86 */             CrashReport crashReport = CrashReport.func_85055_a(throwable, "Exception generating new chunk");
/*  87 */             CrashReportCategory crashReportCategory = crashReport.func_85058_a("Chunk to be generated");
/*     */             
/*  89 */             crashReportCategory.func_71507_a("Location", String.format("%d,%d", new Object[] { Integer.valueOf(p_73158_1_), Integer.valueOf(p_73158_2_) }));
/*  90 */             crashReportCategory.func_71507_a("Position hash", Long.valueOf(l));
/*  91 */             crashReportCategory.func_71507_a("Generator", this.field_73246_d.func_73148_d());
/*     */             
/*  93 */             throw new ReportedException(crashReport);
/*     */           } 
/*     */         } 
/*     */       }
/*     */       
/*  98 */       this.field_73244_f.func_76163_a(l, chunk);
/*  99 */       this.field_73245_g.add(chunk);
/* 100 */       chunk.func_76631_c();
/* 101 */       chunk.func_76624_a(this, this, p_73158_1_, p_73158_2_);
/*     */     } 
/*     */     
/* 104 */     return chunk;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Chunk func_73154_d(int p_73154_1_, int p_73154_2_) {
/* 110 */     Chunk chunk = (Chunk)this.field_73244_f.func_76164_a(ChunkCoordIntPair.func_77272_a(p_73154_1_, p_73154_2_));
/*     */     
/* 112 */     if (chunk == null) {
/* 113 */       if (this.field_73251_h.field_72987_B || this.field_73250_a) {
/* 114 */         return func_73158_c(p_73154_1_, p_73154_2_);
/*     */       }
/* 116 */       return this.field_73249_c;
/*     */     } 
/*     */     
/* 119 */     return chunk;
/*     */   }
/*     */   
/*     */   private Chunk func_73239_e(int p_73239_1_, int p_73239_2_) {
/* 123 */     if (this.field_73247_e == null) return null; 
/*     */     try {
/* 125 */       Chunk chunk = this.field_73247_e.func_75815_a((World)this.field_73251_h, p_73239_1_, p_73239_2_);
/* 126 */       if (chunk != null) {
/* 127 */         chunk.field_76641_n = this.field_73251_h.func_82737_E();
/* 128 */         if (this.field_73246_d != null) {
/* 129 */           this.field_73246_d.func_82695_e(p_73239_1_, p_73239_2_);
/*     */         }
/*     */       } 
/* 132 */       return chunk;
/* 133 */     } catch (Exception exception) {
/* 134 */       field_147417_b.error("Couldn't load chunk", exception);
/* 135 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_73243_a(Chunk p_73243_1_) {
/* 140 */     if (this.field_73247_e == null)
/*     */       return;  try {
/* 142 */       this.field_73247_e.func_75819_b((World)this.field_73251_h, p_73243_1_);
/* 143 */     } catch (Exception exception) {
/* 144 */       field_147417_b.error("Couldn't save entities", exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_73242_b(Chunk p_73242_1_) {
/* 149 */     if (this.field_73247_e == null)
/*     */       return;  try {
/* 151 */       p_73242_1_.field_76641_n = this.field_73251_h.func_82737_E();
/* 152 */       this.field_73247_e.func_75816_a((World)this.field_73251_h, p_73242_1_);
/* 153 */     } catch (IOException iOException) {
/* 154 */       field_147417_b.error("Couldn't save chunk", iOException);
/* 155 */     } catch (MinecraftException minecraftException) {
/* 156 */       field_147417_b.error("Couldn't save chunk; already in use by another instance of Minecraft?", (Throwable)minecraftException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73153_a(IChunkProvider p_73153_1_, int p_73153_2_, int p_73153_3_) {
/* 162 */     Chunk chunk = func_73154_d(p_73153_2_, p_73153_3_);
/* 163 */     if (!chunk.field_76646_k) {
/* 164 */       chunk.func_150809_p();
/* 165 */       if (this.field_73246_d != null) {
/* 166 */         this.field_73246_d.func_73153_a(p_73153_1_, p_73153_2_, p_73153_3_);
/* 167 */         chunk.func_76630_e();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_73151_a(boolean p_73151_1_, IProgressUpdate p_73151_2_) {
/* 176 */     byte b1 = 0;
/*     */     
/* 178 */     ArrayList<Chunk> arrayList = Lists.newArrayList(this.field_73245_g);
/* 179 */     for (byte b2 = 0; b2 < arrayList.size(); b2++) {
/* 180 */       Chunk chunk = arrayList.get(b2);
/* 181 */       if (p_73151_1_) func_73243_a(chunk); 
/* 182 */       if (chunk.func_76601_a(p_73151_1_)) {
/* 183 */         func_73242_b(chunk);
/* 184 */         chunk.field_76643_l = false;
/* 185 */         if (++b1 == 24 && !p_73151_1_) return false;
/*     */       
/*     */       } 
/*     */     } 
/* 189 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_104112_b() {
/* 194 */     if (this.field_73247_e != null) {
/* 195 */       this.field_73247_e.func_75818_b();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_73156_b() {
/* 201 */     if (!this.field_73251_h.field_73058_d) {
/* 202 */       for (byte b = 0; b < 100; b++) {
/* 203 */         if (!this.field_73248_b.isEmpty()) {
/* 204 */           Long long_ = this.field_73248_b.iterator().next();
/*     */           
/* 206 */           Chunk chunk = (Chunk)this.field_73244_f.func_76164_a(long_.longValue());
/* 207 */           if (chunk != null) {
/* 208 */             chunk.func_76623_d();
/* 209 */             func_73242_b(chunk);
/* 210 */             func_73243_a(chunk);
/* 211 */             this.field_73245_g.remove(chunk);
/*     */           } 
/*     */           
/* 214 */           this.field_73248_b.remove(long_);
/* 215 */           this.field_73244_f.func_76159_d(long_.longValue());
/*     */         } 
/*     */       } 
/*     */       
/* 219 */       if (this.field_73247_e != null) this.field_73247_e.func_75817_a();
/*     */     
/*     */     } 
/* 222 */     return this.field_73246_d.func_73156_b();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_73157_c() {
/* 227 */     return !this.field_73251_h.field_73058_d;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_73148_d() {
/* 233 */     return "ServerChunkCache: " + this.field_73244_f.func_76162_a() + " Drop: " + this.field_73248_b.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public List func_73155_a(EnumCreatureType p_73155_1_, int p_73155_2_, int p_73155_3_, int p_73155_4_) {
/* 238 */     return this.field_73246_d.func_73155_a(p_73155_1_, p_73155_2_, p_73155_3_, p_73155_4_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ChunkPosition func_147416_a(World p_147416_1_, String p_147416_2_, int p_147416_3_, int p_147416_4_, int p_147416_5_) {
/* 243 */     return this.field_73246_d.func_147416_a(p_147416_1_, p_147416_2_, p_147416_3_, p_147416_4_, p_147416_5_);
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_73152_e() {
/* 248 */     return this.field_73244_f.func_76162_a();
/*     */   }
/*     */   
/*     */   public void func_82695_e(int p_82695_1_, int p_82695_2_) {}
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\ChunkProviderServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */