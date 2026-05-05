/*     */ package net.minecraft.world;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EnumCreatureType;
/*     */ import net.minecraft.entity.IEntityLivingData;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.ChunkCoordinates;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.WeightedRandom;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ import net.minecraft.world.chunk.Chunk;
/*     */ 
/*     */ public final class SpawnerAnimals {
/*     */   protected static ChunkPosition func_151350_a(World p_151350_0_, int p_151350_1_, int p_151350_2_) {
/*  21 */     Chunk chunk = p_151350_0_.func_72964_e(p_151350_1_, p_151350_2_);
/*  22 */     int i = p_151350_1_ * 16 + p_151350_0_.field_73012_v.nextInt(16);
/*  23 */     int j = p_151350_2_ * 16 + p_151350_0_.field_73012_v.nextInt(16);
/*  24 */     int k = p_151350_0_.field_73012_v.nextInt((chunk == null) ? p_151350_0_.func_72940_L() : (chunk.func_76625_h() + 16 - 1));
/*     */     
/*  26 */     return new ChunkPosition(i, k, j);
/*     */   }
/*     */   
/*  29 */   private HashMap field_77193_b = new HashMap<Object, Object>(); private static final String __OBFID = "CL_00000152";
/*     */   
/*     */   public int func_77192_a(WorldServer p_77192_1_, boolean p_77192_2_, boolean p_77192_3_, boolean p_77192_4_) {
/*  32 */     if (!p_77192_2_ && !p_77192_3_) {
/*  33 */       return 0;
/*     */     }
/*     */     
/*  36 */     this.field_77193_b.clear();
/*     */     int i;
/*  38 */     for (i = 0; i < p_77192_1_.field_73010_i.size(); i++) {
/*  39 */       EntityPlayer entityPlayer = p_77192_1_.field_73010_i.get(i);
/*  40 */       int j = MathHelper.func_76128_c(entityPlayer.field_70165_t / 16.0D);
/*  41 */       int k = MathHelper.func_76128_c(entityPlayer.field_70161_v / 16.0D);
/*     */       
/*  43 */       byte b1 = 8;
/*  44 */       for (byte b2 = -b1; b2 <= b1; b2++) {
/*  45 */         for (byte b = -b1; b <= b1; b++) {
/*  46 */           boolean bool = (b2 == -b1 || b2 == b1 || b == -b1 || b == b1) ? true : false;
/*  47 */           ChunkCoordIntPair chunkCoordIntPair = new ChunkCoordIntPair(b2 + j, b + k);
/*  48 */           if (!bool) {
/*  49 */             this.field_77193_b.put(chunkCoordIntPair, Boolean.valueOf(false));
/*  50 */           } else if (!this.field_77193_b.containsKey(chunkCoordIntPair)) {
/*     */             
/*  52 */             this.field_77193_b.put(chunkCoordIntPair, Boolean.valueOf(true));
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*  57 */     i = 0;
/*  58 */     ChunkCoordinates chunkCoordinates = p_77192_1_.func_72861_E();
/*     */     
/*  60 */     for (EnumCreatureType enumCreatureType : EnumCreatureType.values()) {
/*     */       
/*  62 */       if ((!enumCreatureType.func_75599_d() || p_77192_3_) && (enumCreatureType.func_75599_d() || p_77192_2_) && (!enumCreatureType.func_82705_e() || p_77192_4_))
/*     */       {
/*     */ 
/*     */         
/*  66 */         if (p_77192_1_.func_72907_a(enumCreatureType.func_75598_a()) <= enumCreatureType.func_75601_b() * this.field_77193_b.size() / 256)
/*     */         {
/*     */ 
/*     */           
/*  70 */           label90: for (ChunkCoordIntPair chunkCoordIntPair : this.field_77193_b.keySet()) {
/*     */             
/*  72 */             if (((Boolean)this.field_77193_b.get(chunkCoordIntPair)).booleanValue()) {
/*     */               continue;
/*     */             }
/*     */ 
/*     */             
/*  77 */             ChunkPosition chunkPosition = func_151350_a(p_77192_1_, chunkCoordIntPair.field_77276_a, chunkCoordIntPair.field_77275_b);
/*  78 */             int j = chunkPosition.field_151329_a;
/*  79 */             int k = chunkPosition.field_151327_b;
/*  80 */             int m = chunkPosition.field_151328_c;
/*     */             
/*  82 */             if (p_77192_1_.func_147439_a(j, k, m).func_149721_r() || 
/*  83 */               p_77192_1_.func_147439_a(j, k, m).func_149688_o() != enumCreatureType.func_75600_c())
/*     */               continue; 
/*  85 */             byte b1 = 0;
/*     */             
/*  87 */             for (byte b2 = 0; b2 < 3; b2++) {
/*  88 */               int n = j;
/*  89 */               int i1 = k;
/*  90 */               int i2 = m;
/*  91 */               byte b3 = 6;
/*     */               
/*  93 */               BiomeGenBase.SpawnListEntry spawnListEntry = null;
/*  94 */               IEntityLivingData iEntityLivingData = null;
/*     */               
/*  96 */               for (byte b4 = 0; b4 < 4; b4++) {
/*  97 */                 n += p_77192_1_.field_73012_v.nextInt(b3) - p_77192_1_.field_73012_v.nextInt(b3);
/*  98 */                 i1 += p_77192_1_.field_73012_v.nextInt(1) - p_77192_1_.field_73012_v.nextInt(1);
/*  99 */                 i2 += p_77192_1_.field_73012_v.nextInt(b3) - p_77192_1_.field_73012_v.nextInt(b3);
/*     */                 
/* 101 */                 if (func_77190_a(enumCreatureType, p_77192_1_, n, i1, i2)) {
/* 102 */                   float f1 = n + 0.5F;
/* 103 */                   float f2 = i1;
/* 104 */                   float f3 = i2 + 0.5F;
/* 105 */                   if (p_77192_1_.func_72977_a(f1, f2, f3, 24.0D) == null) {
/*     */ 
/*     */                     
/* 108 */                     float f4 = f1 - chunkCoordinates.field_71574_a;
/* 109 */                     float f5 = f2 - chunkCoordinates.field_71572_b;
/* 110 */                     float f6 = f3 - chunkCoordinates.field_71573_c;
/* 111 */                     float f7 = f4 * f4 + f5 * f5 + f6 * f6;
/* 112 */                     if (f7 >= 576.0F)
/*     */                     { EntityLiving entityLiving;
/*     */ 
/*     */ 
/*     */                       
/* 117 */                       if (spawnListEntry == null) {
/* 118 */                         spawnListEntry = p_77192_1_.func_73057_a(enumCreatureType, n, i1, i2);
/* 119 */                         if (spawnListEntry == null) {
/*     */                           break;
/*     */                         }
/*     */                       } 
/*     */ 
/*     */                       
/*     */                       try {
/* 126 */                         entityLiving = spawnListEntry.field_76300_b.getConstructor(new Class[] { World.class }).newInstance(new Object[] { p_77192_1_ });
/* 127 */                       } catch (Exception exception) {
/* 128 */                         exception.printStackTrace();
/* 129 */                         return i;
/*     */                       } 
/*     */                       
/* 132 */                       entityLiving.func_70012_b(f1, f2, f3, p_77192_1_.field_73012_v.nextFloat() * 360.0F, 0.0F);
/*     */                       
/* 134 */                       if (entityLiving.func_70601_bi()) {
/* 135 */                         b1++;
/* 136 */                         p_77192_1_.func_72838_d((Entity)entityLiving);
/* 137 */                         iEntityLivingData = entityLiving.func_110161_a(iEntityLivingData);
/* 138 */                         if (b1 >= entityLiving.func_70641_bl())
/*     */                           continue label90; 
/* 140 */                       }  i += b1; } 
/*     */                   } 
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           }  }  } 
/* 146 */     }  return i;
/*     */   }
/*     */   
/*     */   public static boolean func_77190_a(EnumCreatureType p_77190_0_, World p_77190_1_, int p_77190_2_, int p_77190_3_, int p_77190_4_) {
/* 150 */     if (p_77190_0_.func_75600_c() == Material.field_151586_h) {
/* 151 */       return (p_77190_1_.func_147439_a(p_77190_2_, p_77190_3_, p_77190_4_).func_149688_o().func_76224_d() && p_77190_1_.func_147439_a(p_77190_2_, p_77190_3_ - 1, p_77190_4_).func_149688_o().func_76224_d() && !p_77190_1_.func_147439_a(p_77190_2_, p_77190_3_ + 1, p_77190_4_).func_149721_r());
/*     */     }
/* 153 */     if (!World.func_147466_a(p_77190_1_, p_77190_2_, p_77190_3_ - 1, p_77190_4_)) return false; 
/* 154 */     Block block = p_77190_1_.func_147439_a(p_77190_2_, p_77190_3_ - 1, p_77190_4_);
/* 155 */     return (block != Blocks.field_150357_h && !p_77190_1_.func_147439_a(p_77190_2_, p_77190_3_, p_77190_4_).func_149721_r() && !p_77190_1_.func_147439_a(p_77190_2_, p_77190_3_, p_77190_4_).func_149688_o().func_76224_d() && !p_77190_1_.func_147439_a(p_77190_2_, p_77190_3_ + 1, p_77190_4_).func_149721_r());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void func_77191_a(World p_77191_0_, BiomeGenBase p_77191_1_, int p_77191_2_, int p_77191_3_, int p_77191_4_, int p_77191_5_, Random p_77191_6_) {
/* 161 */     List list = p_77191_1_.func_76747_a(EnumCreatureType.creature);
/* 162 */     if (list.isEmpty()) {
/*     */       return;
/*     */     }
/*     */     
/* 166 */     while (p_77191_6_.nextFloat() < p_77191_1_.func_76741_f()) {
/*     */       
/* 168 */       BiomeGenBase.SpawnListEntry spawnListEntry = (BiomeGenBase.SpawnListEntry)WeightedRandom.func_76271_a(p_77191_0_.field_73012_v, list);
/* 169 */       IEntityLivingData iEntityLivingData = null;
/* 170 */       int i = spawnListEntry.field_76301_c + p_77191_6_.nextInt(1 + spawnListEntry.field_76299_d - spawnListEntry.field_76301_c);
/*     */       
/* 172 */       int j = p_77191_2_ + p_77191_6_.nextInt(p_77191_4_);
/* 173 */       int k = p_77191_3_ + p_77191_6_.nextInt(p_77191_5_);
/* 174 */       int m = j, n = k;
/*     */       
/* 176 */       for (byte b = 0; b < i; b++) {
/* 177 */         boolean bool = false;
/* 178 */         for (byte b1 = 0; !bool && b1 < 4; b1++) {
/*     */           
/* 180 */           int i1 = p_77191_0_.func_72825_h(j, k);
/* 181 */           if (func_77190_a(EnumCreatureType.creature, p_77191_0_, j, i1, k)) {
/*     */             EntityLiving entityLiving;
/* 183 */             float f1 = j + 0.5F;
/* 184 */             float f2 = i1;
/* 185 */             float f3 = k + 0.5F;
/*     */ 
/*     */             
/*     */             try {
/* 189 */               entityLiving = spawnListEntry.field_76300_b.getConstructor(new Class[] { World.class }).newInstance(new Object[] { p_77191_0_ });
/* 190 */             } catch (Exception exception) {
/* 191 */               exception.printStackTrace();
/*     */             } 
/*     */ 
/*     */             
/* 195 */             entityLiving.func_70012_b(f1, f2, f3, p_77191_6_.nextFloat() * 360.0F, 0.0F);
/*     */             
/* 197 */             p_77191_0_.func_72838_d((Entity)entityLiving);
/* 198 */             iEntityLivingData = entityLiving.func_110161_a(iEntityLivingData);
/* 199 */             bool = true;
/*     */           } 
/*     */           
/* 202 */           j += p_77191_6_.nextInt(5) - p_77191_6_.nextInt(5);
/* 203 */           k += p_77191_6_.nextInt(5) - p_77191_6_.nextInt(5);
/* 204 */           while (j < p_77191_2_ || j >= p_77191_2_ + p_77191_4_ || k < p_77191_3_ || k >= p_77191_3_ + p_77191_4_) {
/* 205 */             j = m + p_77191_6_.nextInt(5) - p_77191_6_.nextInt(5);
/* 206 */             k = n + p_77191_6_.nextInt(5) - p_77191_6_.nextInt(5);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\SpawnerAnimals.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */