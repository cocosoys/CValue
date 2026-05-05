/*    */ package net.minecraft.world.biome;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.util.LongHashMap;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BiomeCache
/*    */ {
/*    */   private final WorldChunkManager field_76844_a;
/*    */   private long field_76842_b;
/*    */   
/*    */   public class Block
/*    */   {
/* 18 */     public float[] field_76890_b = new float[256];
/* 19 */     public BiomeGenBase[] field_76891_c = new BiomeGenBase[256];
/*    */     public int field_76888_d;
/*    */     public int field_76889_e;
/*    */     
/*    */     public Block(BiomeCache p_i1972_1_, int p_i1972_2_, int p_i1972_3_) {
/* 24 */       this.field_76888_d = p_i1972_2_;
/* 25 */       this.field_76889_e = p_i1972_3_;
/* 26 */       p_i1972_1_.field_76844_a.func_76936_a(this.field_76890_b, p_i1972_2_ << 4, p_i1972_3_ << 4, 16, 16);
/* 27 */       p_i1972_1_.field_76844_a.func_76931_a(this.field_76891_c, p_i1972_2_ << 4, p_i1972_3_ << 4, 16, 16, false);
/*    */     }
/*    */     public long field_76886_f; private static final String __OBFID = "CL_00000163";
/*    */     public BiomeGenBase func_76885_a(int p_76885_1_, int p_76885_2_) {
/* 31 */       return this.field_76891_c[p_76885_1_ & 0xF | (p_76885_2_ & 0xF) << 4];
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 39 */   private LongHashMap field_76843_c = new LongHashMap();
/* 40 */   private List field_76841_d = new ArrayList(); private static final String __OBFID = "CL_00000162";
/*    */   
/*    */   public BiomeCache(WorldChunkManager p_i1973_1_) {
/* 43 */     this.field_76844_a = p_i1973_1_;
/*    */   }
/*    */   
/*    */   public Block func_76840_a(int p_76840_1_, int p_76840_2_) {
/* 47 */     p_76840_1_ >>= 4;
/* 48 */     p_76840_2_ >>= 4;
/* 49 */     long l = p_76840_1_ & 0xFFFFFFFFL | (p_76840_2_ & 0xFFFFFFFFL) << 32L;
/* 50 */     Block block = (Block)this.field_76843_c.func_76164_a(l);
/* 51 */     if (block == null) {
/* 52 */       block = new Block(this, p_76840_1_, p_76840_2_);
/* 53 */       this.field_76843_c.func_76163_a(l, block);
/* 54 */       this.field_76841_d.add(block);
/*    */     } 
/* 56 */     block.field_76886_f = MinecraftServer.func_130071_aq();
/* 57 */     return block;
/*    */   }
/*    */   
/*    */   public BiomeGenBase func_76837_b(int p_76837_1_, int p_76837_2_) {
/* 61 */     return func_76840_a(p_76837_1_, p_76837_2_).func_76885_a(p_76837_1_, p_76837_2_);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_76838_a() {
/* 69 */     long l1 = MinecraftServer.func_130071_aq();
/* 70 */     long l2 = l1 - this.field_76842_b;
/* 71 */     if (l2 > 7500L || l2 < 0L) {
/* 72 */       this.field_76842_b = l1;
/*    */       
/* 74 */       for (byte b = 0; b < this.field_76841_d.size(); b++) {
/* 75 */         Block block = this.field_76841_d.get(b);
/* 76 */         long l = l1 - block.field_76886_f;
/* 77 */         if (l > 30000L || l < 0L) {
/* 78 */           this.field_76841_d.remove(b--);
/* 79 */           long l3 = block.field_76888_d & 0xFFFFFFFFL | (block.field_76889_e & 0xFFFFFFFFL) << 32L;
/* 80 */           this.field_76843_c.func_76159_d(l3);
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public BiomeGenBase[] func_76839_e(int p_76839_1_, int p_76839_2_) {
/* 87 */     return (func_76840_a(p_76839_1_, p_76839_2_)).field_76891_c;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\biome\BiomeCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */