/*     */ package net.minecraft.world.biome;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.world.ChunkPosition;
/*     */ 
/*     */ public class WorldChunkManagerHell extends WorldChunkManager {
/*     */   private BiomeGenBase field_76947_d;
/*     */   
/*     */   public WorldChunkManagerHell(BiomeGenBase p_i45374_1_, float p_i45374_2_) {
/*  12 */     this.field_76947_d = p_i45374_1_;
/*  13 */     this.field_76946_f = p_i45374_2_;
/*     */   }
/*     */ 
/*     */   
/*     */   private float field_76946_f;
/*     */   
/*     */   private static final String __OBFID = "CL_00000169";
/*     */ 
/*     */   
/*     */   public BiomeGenBase func_76935_a(int p_76935_1_, int p_76935_2_) {
/*  23 */     return this.field_76947_d;
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
/*     */   public BiomeGenBase[] func_76937_a(BiomeGenBase[] p_76937_1_, int p_76937_2_, int p_76937_3_, int p_76937_4_, int p_76937_5_) {
/*  40 */     if (p_76937_1_ == null || p_76937_1_.length < p_76937_4_ * p_76937_5_) {
/*  41 */       p_76937_1_ = new BiomeGenBase[p_76937_4_ * p_76937_5_];
/*     */     }
/*     */     
/*  44 */     Arrays.fill((Object[])p_76937_1_, 0, p_76937_4_ * p_76937_5_, this.field_76947_d);
/*     */     
/*  46 */     return p_76937_1_;
/*     */   }
/*     */ 
/*     */   
/*     */   public float[] func_76936_a(float[] p_76936_1_, int p_76936_2_, int p_76936_3_, int p_76936_4_, int p_76936_5_) {
/*  51 */     if (p_76936_1_ == null || p_76936_1_.length < p_76936_4_ * p_76936_5_) {
/*  52 */       p_76936_1_ = new float[p_76936_4_ * p_76936_5_];
/*     */     }
/*  54 */     Arrays.fill(p_76936_1_, 0, p_76936_4_ * p_76936_5_, this.field_76946_f);
/*     */     
/*  56 */     return p_76936_1_;
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
/*     */   public BiomeGenBase[] func_76933_b(BiomeGenBase[] p_76933_1_, int p_76933_2_, int p_76933_3_, int p_76933_4_, int p_76933_5_) {
/*  80 */     if (p_76933_1_ == null || p_76933_1_.length < p_76933_4_ * p_76933_5_) {
/*  81 */       p_76933_1_ = new BiomeGenBase[p_76933_4_ * p_76933_5_];
/*     */     }
/*     */     
/*  84 */     Arrays.fill((Object[])p_76933_1_, 0, p_76933_4_ * p_76933_5_, this.field_76947_d);
/*     */     
/*  86 */     return p_76933_1_;
/*     */   }
/*     */ 
/*     */   
/*     */   public BiomeGenBase[] func_76931_a(BiomeGenBase[] p_76931_1_, int p_76931_2_, int p_76931_3_, int p_76931_4_, int p_76931_5_, boolean p_76931_6_) {
/*  91 */     return func_76933_b(p_76931_1_, p_76931_2_, p_76931_3_, p_76931_4_, p_76931_5_);
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
/*     */   public ChunkPosition func_150795_a(int p_150795_1_, int p_150795_2_, int p_150795_3_, List p_150795_4_, Random p_150795_5_) {
/* 106 */     if (p_150795_4_.contains(this.field_76947_d)) {
/* 107 */       return new ChunkPosition(p_150795_1_ - p_150795_3_ + p_150795_5_.nextInt(p_150795_3_ * 2 + 1), 0, p_150795_2_ - p_150795_3_ + p_150795_5_.nextInt(p_150795_3_ * 2 + 1));
/*     */     }
/*     */     
/* 110 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_76940_a(int p_76940_1_, int p_76940_2_, int p_76940_3_, List p_76940_4_) {
/* 120 */     return p_76940_4_.contains(this.field_76947_d);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\biome\WorldChunkManagerHell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */