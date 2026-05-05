/*     */ package net.minecraft.world.gen.feature;
/*     */ 
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.tileentity.TileEntityChest;
/*     */ import net.minecraft.tileentity.TileEntityMobSpawner;
/*     */ import net.minecraft.util.WeightedRandomChestContent;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class WorldGenDungeons
/*     */   extends WorldGenerator {
/*  16 */   public static final WeightedRandomChestContent[] field_111189_a = new WeightedRandomChestContent[] { new WeightedRandomChestContent(Items.field_151141_av, 0, 1, 1, 10), new WeightedRandomChestContent(Items.field_151042_j, 0, 1, 4, 10), new WeightedRandomChestContent(Items.field_151025_P, 0, 1, 1, 10), new WeightedRandomChestContent(Items.field_151015_O, 0, 1, 4, 10), new WeightedRandomChestContent(Items.field_151016_H, 0, 1, 4, 10), new WeightedRandomChestContent(Items.field_151007_F, 0, 1, 4, 10), new WeightedRandomChestContent(Items.field_151133_ar, 0, 1, 1, 10), new WeightedRandomChestContent(Items.field_151153_ao, 0, 1, 1, 1), new WeightedRandomChestContent(Items.field_151137_ax, 0, 1, 4, 10), new WeightedRandomChestContent(Items.field_151096_cd, 0, 1, 1, 10), new WeightedRandomChestContent(Items.field_151093_ce, 0, 1, 1, 10), new WeightedRandomChestContent(Items.field_151057_cb, 0, 1, 1, 10), new WeightedRandomChestContent(Items.field_151136_bY, 0, 1, 1, 2), new WeightedRandomChestContent(Items.field_151138_bX, 0, 1, 1, 5), new WeightedRandomChestContent(Items.field_151125_bZ, 0, 1, 1, 1) };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String __OBFID = "CL_00000425";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
/*  37 */     byte b1 = 3;
/*  38 */     int i = p_76484_2_.nextInt(2) + 2;
/*  39 */     int j = p_76484_2_.nextInt(2) + 2;
/*     */     
/*  41 */     byte b2 = 0; int k;
/*  42 */     for (k = p_76484_3_ - i - 1; k <= p_76484_3_ + i + 1; k++) {
/*  43 */       for (int m = p_76484_4_ - 1; m <= p_76484_4_ + b1 + 1; m++) {
/*  44 */         for (int n = p_76484_5_ - j - 1; n <= p_76484_5_ + j + 1; n++) {
/*  45 */           Material material = p_76484_1_.func_147439_a(k, m, n).func_149688_o();
/*  46 */           if (m == p_76484_4_ - 1 && !material.func_76220_a()) return false; 
/*  47 */           if (m == p_76484_4_ + b1 + 1 && !material.func_76220_a()) return false;
/*     */           
/*  49 */           if ((k == p_76484_3_ - i - 1 || k == p_76484_3_ + i + 1 || n == p_76484_5_ - j - 1 || n == p_76484_5_ + j + 1) && 
/*  50 */             m == p_76484_4_ && p_76484_1_.func_147437_c(k, m, n) && p_76484_1_.func_147437_c(k, m + 1, n)) {
/*  51 */             b2++;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  59 */     if (b2 < 1 || b2 > 5) return false;
/*     */     
/*  61 */     for (k = p_76484_3_ - i - 1; k <= p_76484_3_ + i + 1; k++) {
/*  62 */       for (int m = p_76484_4_ + b1; m >= p_76484_4_ - 1; m--) {
/*  63 */         for (int n = p_76484_5_ - j - 1; n <= p_76484_5_ + j + 1; n++) {
/*     */           
/*  65 */           if (k == p_76484_3_ - i - 1 || m == p_76484_4_ - 1 || n == p_76484_5_ - j - 1 || k == p_76484_3_ + i + 1 || m == p_76484_4_ + b1 + 1 || n == p_76484_5_ + j + 1) {
/*  66 */             if (m >= 0 && !p_76484_1_.func_147439_a(k, m - 1, n).func_149688_o().func_76220_a()) {
/*  67 */               p_76484_1_.func_147468_f(k, m, n);
/*  68 */             } else if (p_76484_1_.func_147439_a(k, m, n).func_149688_o().func_76220_a()) {
/*  69 */               if (m == p_76484_4_ - 1 && p_76484_2_.nextInt(4) != 0) {
/*  70 */                 p_76484_1_.func_147465_d(k, m, n, Blocks.field_150341_Y, 0, 2);
/*     */               } else {
/*  72 */                 p_76484_1_.func_147465_d(k, m, n, Blocks.field_150347_e, 0, 2);
/*     */               } 
/*     */             } 
/*     */           } else {
/*  76 */             p_76484_1_.func_147468_f(k, m, n);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  82 */     for (k = 0; k < 2; k++) {
/*  83 */       for (byte b = 0; b < 3; b++) {
/*  84 */         int m = p_76484_3_ + p_76484_2_.nextInt(i * 2 + 1) - i;
/*  85 */         int n = p_76484_4_;
/*  86 */         int i1 = p_76484_5_ + p_76484_2_.nextInt(j * 2 + 1) - j;
/*  87 */         if (p_76484_1_.func_147437_c(m, n, i1)) {
/*     */           
/*  89 */           byte b3 = 0;
/*  90 */           if (p_76484_1_.func_147439_a(m - 1, n, i1).func_149688_o().func_76220_a()) b3++; 
/*  91 */           if (p_76484_1_.func_147439_a(m + 1, n, i1).func_149688_o().func_76220_a()) b3++; 
/*  92 */           if (p_76484_1_.func_147439_a(m, n, i1 - 1).func_149688_o().func_76220_a()) b3++; 
/*  93 */           if (p_76484_1_.func_147439_a(m, n, i1 + 1).func_149688_o().func_76220_a()) b3++;
/*     */           
/*  95 */           if (b3 == 1) {
/*     */             
/*  97 */             p_76484_1_.func_147465_d(m, n, i1, (Block)Blocks.field_150486_ae, 0, 2);
/*     */             
/*  99 */             WeightedRandomChestContent[] arrayOfWeightedRandomChestContent = WeightedRandomChestContent.func_92080_a(field_111189_a, new WeightedRandomChestContent[] { Items.field_151134_bR.func_92114_b(p_76484_2_) });
/*     */             
/* 101 */             TileEntityChest tileEntityChest = (TileEntityChest)p_76484_1_.func_147438_o(m, n, i1);
/* 102 */             if (tileEntityChest != null) {
/* 103 */               WeightedRandomChestContent.func_76293_a(p_76484_2_, arrayOfWeightedRandomChestContent, (IInventory)tileEntityChest, 8);
/*     */             }
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 110 */     p_76484_1_.func_147465_d(p_76484_3_, p_76484_4_, p_76484_5_, Blocks.field_150474_ac, 0, 2);
/* 111 */     TileEntityMobSpawner tileEntityMobSpawner = (TileEntityMobSpawner)p_76484_1_.func_147438_o(p_76484_3_, p_76484_4_, p_76484_5_);
/* 112 */     if (tileEntityMobSpawner != null) {
/* 113 */       tileEntityMobSpawner.func_145881_a().func_98272_a(func_76543_b(p_76484_2_));
/*     */     } else {
/* 115 */       System.err.println("Failed to fetch mob spawner entity at (" + p_76484_3_ + ", " + p_76484_4_ + ", " + p_76484_5_ + ")");
/*     */     } 
/*     */     
/* 118 */     return true;
/*     */   }
/*     */   
/*     */   private String func_76543_b(Random p_76543_1_) {
/* 122 */     int i = p_76543_1_.nextInt(4);
/* 123 */     if (i == 0) return "Skeleton"; 
/* 124 */     if (i == 1) return "Zombie"; 
/* 125 */     if (i == 2) return "Zombie"; 
/* 126 */     if (i == 3) return "Spider"; 
/* 127 */     return "";
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\feature\WorldGenDungeons.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */