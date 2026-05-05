/*     */ package net.minecraft.client.multiplayer;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.util.IProgressUpdate;
/*     */ import net.minecraft.util.LongHashMap;
/*     */ import net.minecraft.world.ChunkCoordIntPair;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.chunk.Chunk;
/*     */ import net.minecraft.world.chunk.IChunkProvider;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class ChunkProviderClient implements IChunkProvider {
/*  16 */   private static final Logger field_147436_a = LogManager.getLogger();
/*     */   
/*     */   private Chunk field_73238_a;
/*  19 */   private LongHashMap field_73236_b = new LongHashMap();
/*  20 */   private List field_73237_c = new ArrayList(); private World field_73235_d;
/*     */   private static final String __OBFID = "CL_00000880";
/*     */   
/*     */   public ChunkProviderClient(World p_i1184_1_) {
/*  24 */     this.field_73238_a = (Chunk)new EmptyChunk(p_i1184_1_, 0, 0);
/*     */     
/*  26 */     this.field_73235_d = p_i1184_1_;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_73149_a(int p_73149_1_, int p_73149_2_) {
/*  31 */     return true;
/*     */   }
/*     */   
/*     */   public void func_73234_b(int p_73234_1_, int p_73234_2_) {
/*  35 */     Chunk chunk = func_73154_d(p_73234_1_, p_73234_2_);
/*  36 */     if (!chunk.func_76621_g()) {
/*  37 */       chunk.func_76623_d();
/*     */     }
/*     */     
/*  40 */     this.field_73236_b.func_76159_d(ChunkCoordIntPair.func_77272_a(p_73234_1_, p_73234_2_));
/*  41 */     this.field_73237_c.remove(chunk);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Chunk func_73158_c(int p_73158_1_, int p_73158_2_) {
/*  47 */     Chunk chunk = new Chunk(this.field_73235_d, p_73158_1_, p_73158_2_);
/*  48 */     this.field_73236_b.func_76163_a(ChunkCoordIntPair.func_77272_a(p_73158_1_, p_73158_2_), chunk);
/*  49 */     this.field_73237_c.add(chunk);
/*  50 */     chunk.field_76636_d = true;
/*     */     
/*  52 */     return chunk;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Chunk func_73154_d(int p_73154_1_, int p_73154_2_) {
/*  58 */     Chunk chunk = (Chunk)this.field_73236_b.func_76164_a(ChunkCoordIntPair.func_77272_a(p_73154_1_, p_73154_2_));
/*  59 */     if (chunk == null) {
/*  60 */       return this.field_73238_a;
/*     */     }
/*     */     
/*  63 */     return chunk;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_73151_a(boolean p_73151_1_, IProgressUpdate p_73151_2_) {
/*  68 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_104112_b() {}
/*     */ 
/*     */   
/*     */   public boolean func_73156_b() {
/*  77 */     long l = System.currentTimeMillis();
/*     */     
/*  79 */     for (Chunk chunk : this.field_73237_c) {
/*  80 */       chunk.func_150804_b((System.currentTimeMillis() - l > 5L));
/*     */     }
/*  82 */     if (System.currentTimeMillis() - l > 100L) {
/*  83 */       field_147436_a.info("Warning: Clientside chunk ticking took {} ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
/*     */     }
/*  85 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_73157_c() {
/*  90 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73153_a(IChunkProvider p_73153_1_, int p_73153_2_, int p_73153_3_) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_73148_d() {
/* 100 */     return "MultiplayerChunkCache: " + this.field_73236_b.func_76162_a() + ", " + this.field_73237_c.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public List func_73155_a(EnumCreatureType p_73155_1_, int p_73155_2_, int p_73155_3_, int p_73155_4_) {
/* 105 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public ChunkPosition func_147416_a(World p_147416_1_, String p_147416_2_, int p_147416_3_, int p_147416_4_, int p_147416_5_) {
/* 110 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_73152_e() {
/* 115 */     return this.field_73237_c.size();
/*     */   }
/*     */   
/*     */   public void func_82695_e(int p_82695_1_, int p_82695_2_) {}
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\multiplayer\ChunkProviderClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */