/*     */ package net.minecraft.world.gen.feature;
/*     */ 
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.world.EnumSkyBlock;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ 
/*     */ public class WorldGenLakes extends WorldGenerator {
/*     */   private Block field_150556_a;
/*     */   
/*     */   public WorldGenLakes(Block p_i45455_1_) {
/*  15 */     this.field_150556_a = p_i45455_1_;
/*     */   }
/*     */   private static final String __OBFID = "CL_00000418";
/*     */   
/*     */   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
/*  20 */     p_76484_3_ -= 8;
/*  21 */     p_76484_5_ -= 8;
/*  22 */     while (p_76484_4_ > 5 && p_76484_1_.func_147437_c(p_76484_3_, p_76484_4_, p_76484_5_))
/*  23 */       p_76484_4_--; 
/*  24 */     if (p_76484_4_ <= 4) {
/*  25 */       return false;
/*     */     }
/*     */     
/*  28 */     p_76484_4_ -= 4;
/*     */     
/*  30 */     boolean[] arrayOfBoolean = new boolean[2048];
/*     */     
/*  32 */     int i = p_76484_2_.nextInt(4) + 4; byte b;
/*  33 */     for (b = 0; b < i; b++) {
/*  34 */       double d1 = p_76484_2_.nextDouble() * 6.0D + 3.0D;
/*  35 */       double d2 = p_76484_2_.nextDouble() * 4.0D + 2.0D;
/*  36 */       double d3 = p_76484_2_.nextDouble() * 6.0D + 3.0D;
/*     */       
/*  38 */       double d4 = p_76484_2_.nextDouble() * (16.0D - d1 - 2.0D) + 1.0D + d1 / 2.0D;
/*  39 */       double d5 = p_76484_2_.nextDouble() * (8.0D - d2 - 4.0D) + 2.0D + d2 / 2.0D;
/*  40 */       double d6 = p_76484_2_.nextDouble() * (16.0D - d3 - 2.0D) + 1.0D + d3 / 2.0D;
/*     */       
/*  42 */       for (byte b1 = 1; b1 < 15; b1++) {
/*  43 */         for (byte b2 = 1; b2 < 15; b2++) {
/*  44 */           for (byte b3 = 1; b3 < 7; b3++) {
/*  45 */             double d7 = (b1 - d4) / d1 / 2.0D;
/*  46 */             double d8 = (b3 - d5) / d2 / 2.0D;
/*  47 */             double d9 = (b2 - d6) / d3 / 2.0D;
/*  48 */             double d10 = d7 * d7 + d8 * d8 + d9 * d9;
/*  49 */             if (d10 < 1.0D) arrayOfBoolean[(b1 * 16 + b2) * 8 + b3] = true;
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*  55 */     for (b = 0; b < 16; b++) {
/*  56 */       for (byte b1 = 0; b1 < 16; b1++) {
/*  57 */         for (byte b2 = 0; b2 < 8; b2++) {
/*  58 */           boolean bool = (!arrayOfBoolean[(b * 16 + b1) * 8 + b2] && ((b < 15 && arrayOfBoolean[((b + 1) * 16 + b1) * 8 + b2]) || (b > 0 && arrayOfBoolean[((b - 1) * 16 + b1) * 8 + b2]) || (b1 < 15 && arrayOfBoolean[(b * 16 + b1 + 1) * 8 + b2]) || (b1 > 0 && arrayOfBoolean[(b * 16 + b1 - 1) * 8 + b2]) || (b2 < 7 && arrayOfBoolean[(b * 16 + b1) * 8 + b2 + 1]) || (b2 > 0 && arrayOfBoolean[(b * 16 + b1) * 8 + b2 - 1]))) ? true : false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  65 */           if (bool) {
/*  66 */             Material material = p_76484_1_.func_147439_a(p_76484_3_ + b, p_76484_4_ + b2, p_76484_5_ + b1).func_149688_o();
/*  67 */             if (b2 >= 4 && material.func_76224_d()) return false; 
/*  68 */             if (b2 < 4 && !material.func_76220_a() && p_76484_1_.func_147439_a(p_76484_3_ + b, p_76484_4_ + b2, p_76484_5_ + b1) != this.field_150556_a) return false;
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  75 */     for (b = 0; b < 16; b++) {
/*  76 */       for (byte b1 = 0; b1 < 16; b1++) {
/*  77 */         for (byte b2 = 0; b2 < 8; b2++) {
/*  78 */           if (arrayOfBoolean[(b * 16 + b1) * 8 + b2]) {
/*  79 */             p_76484_1_.func_147465_d(p_76484_3_ + b, p_76484_4_ + b2, p_76484_5_ + b1, (b2 >= 4) ? Blocks.field_150350_a : this.field_150556_a, 0, 2);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  85 */     for (b = 0; b < 16; b++) {
/*  86 */       for (byte b1 = 0; b1 < 16; b1++) {
/*  87 */         for (byte b2 = 4; b2 < 8; b2++) {
/*  88 */           if (arrayOfBoolean[(b * 16 + b1) * 8 + b2] && 
/*  89 */             p_76484_1_.func_147439_a(p_76484_3_ + b, p_76484_4_ + b2 - 1, p_76484_5_ + b1) == Blocks.field_150346_d && p_76484_1_.func_72972_b(EnumSkyBlock.Sky, p_76484_3_ + b, p_76484_4_ + b2, p_76484_5_ + b1) > 0) {
/*  90 */             BiomeGenBase biomeGenBase = p_76484_1_.func_72807_a(p_76484_3_ + b, p_76484_5_ + b1);
/*  91 */             if (biomeGenBase.field_76752_A == Blocks.field_150391_bh) { p_76484_1_.func_147465_d(p_76484_3_ + b, p_76484_4_ + b2 - 1, p_76484_5_ + b1, (Block)Blocks.field_150391_bh, 0, 2); }
/*  92 */             else { p_76484_1_.func_147465_d(p_76484_3_ + b, p_76484_4_ + b2 - 1, p_76484_5_ + b1, (Block)Blocks.field_150349_c, 0, 2); }
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  99 */     if (this.field_150556_a.func_149688_o() == Material.field_151587_i) {
/* 100 */       for (b = 0; b < 16; b++) {
/* 101 */         for (byte b1 = 0; b1 < 16; b1++) {
/* 102 */           for (byte b2 = 0; b2 < 8; b2++) {
/* 103 */             boolean bool = (!arrayOfBoolean[(b * 16 + b1) * 8 + b2] && ((b < 15 && arrayOfBoolean[((b + 1) * 16 + b1) * 8 + b2]) || (b > 0 && arrayOfBoolean[((b - 1) * 16 + b1) * 8 + b2]) || (b1 < 15 && arrayOfBoolean[(b * 16 + b1 + 1) * 8 + b2]) || (b1 > 0 && arrayOfBoolean[(b * 16 + b1 - 1) * 8 + b2]) || (b2 < 7 && arrayOfBoolean[(b * 16 + b1) * 8 + b2 + 1]) || (b2 > 0 && arrayOfBoolean[(b * 16 + b1) * 8 + b2 - 1]))) ? true : false;
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 108 */             if (bool && (
/* 109 */               b2 < 4 || p_76484_2_.nextInt(2) != 0) && p_76484_1_.func_147439_a(p_76484_3_ + b, p_76484_4_ + b2, p_76484_5_ + b1).func_149688_o().func_76220_a()) {
/* 110 */               p_76484_1_.func_147465_d(p_76484_3_ + b, p_76484_4_ + b2, p_76484_5_ + b1, Blocks.field_150348_b, 0, 2);
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 118 */     if (this.field_150556_a.func_149688_o() == Material.field_151586_h) {
/* 119 */       for (b = 0; b < 16; b++) {
/* 120 */         for (byte b1 = 0; b1 < 16; b1++) {
/* 121 */           byte b2 = 4;
/* 122 */           if (p_76484_1_.func_72884_u(p_76484_3_ + b, p_76484_4_ + b2, p_76484_5_ + b1)) p_76484_1_.func_147465_d(p_76484_3_ + b, p_76484_4_ + b2, p_76484_5_ + b1, Blocks.field_150432_aD, 0, 2);
/*     */         
/*     */         } 
/*     */       } 
/*     */     }
/* 127 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\feature\WorldGenLakes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */