/*     */ package net.minecraft.world.gen.feature;
/*     */ 
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class WorldGenBigMushroom
/*     */   extends WorldGenerator {
/*  11 */   private int field_76523_a = -1;
/*     */   
/*     */   public WorldGenBigMushroom(int p_i2017_1_) {
/*  14 */     super(true);
/*  15 */     this.field_76523_a = p_i2017_1_;
/*     */   }
/*     */   private static final String __OBFID = "CL_00000415";
/*     */   public WorldGenBigMushroom() {
/*  19 */     super(false);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
/*  24 */     int i = p_76484_2_.nextInt(2);
/*  25 */     if (this.field_76523_a >= 0) i = this.field_76523_a;
/*     */     
/*  27 */     int j = p_76484_2_.nextInt(3) + 4;
/*     */     
/*  29 */     boolean bool = true;
/*  30 */     if (p_76484_4_ < 1 || p_76484_4_ + j + 1 >= 256) return false;
/*     */     
/*  32 */     for (int k = p_76484_4_; k <= p_76484_4_ + 1 + j; k++) {
/*  33 */       byte b = 3;
/*  34 */       if (k <= p_76484_4_ + 3) b = 0; 
/*  35 */       for (int i1 = p_76484_3_ - b; i1 <= p_76484_3_ + b && bool; i1++) {
/*  36 */         for (int i2 = p_76484_5_ - b; i2 <= p_76484_5_ + b && bool; i2++) {
/*  37 */           if (k >= 0 && k < 256) {
/*  38 */             Block block1 = p_76484_1_.func_147439_a(i1, k, i2);
/*  39 */             if (block1.func_149688_o() != Material.field_151579_a && block1.func_149688_o() != Material.field_151584_j) {
/*  40 */               bool = false;
/*     */             }
/*     */           } else {
/*  43 */             bool = false;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  49 */     if (!bool) return false;
/*     */     
/*  51 */     Block block = p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_ - 1, p_76484_5_);
/*  52 */     if (block != Blocks.field_150346_d && block != Blocks.field_150349_c && block != Blocks.field_150391_bh) {
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     int m = p_76484_4_ + j;
/*  57 */     if (i == 1)
/*  58 */       m = p_76484_4_ + j - 3; 
/*     */     int n;
/*  60 */     for (n = m; n <= p_76484_4_ + j; n++) {
/*  61 */       byte b = 1;
/*  62 */       if (n < p_76484_4_ + j) b++; 
/*  63 */       if (i == 0) b = 3; 
/*  64 */       for (int i1 = p_76484_3_ - b; i1 <= p_76484_3_ + b; i1++) {
/*  65 */         for (int i2 = p_76484_5_ - b; i2 <= p_76484_5_ + b; i2++) {
/*  66 */           byte b1 = 5;
/*  67 */           if (i1 == p_76484_3_ - b) b1--; 
/*  68 */           if (i1 == p_76484_3_ + b) b1++; 
/*  69 */           if (i2 == p_76484_5_ - b) b1 -= 3; 
/*  70 */           if (i2 == p_76484_5_ + b) b1 += 3;
/*     */           
/*  72 */           if (i == 0 || n < p_76484_4_ + j) {
/*  73 */             if ((i1 == p_76484_3_ - b || i1 == p_76484_3_ + b) && (i2 == p_76484_5_ - b || i2 == p_76484_5_ + b))
/*  74 */               continue;  if (i1 == p_76484_3_ - b - 1 && i2 == p_76484_5_ - b) b1 = 1; 
/*  75 */             if (i1 == p_76484_3_ - b && i2 == p_76484_5_ - b - 1) b1 = 1;
/*     */             
/*  77 */             if (i1 == p_76484_3_ + b - 1 && i2 == p_76484_5_ - b) b1 = 3; 
/*  78 */             if (i1 == p_76484_3_ + b && i2 == p_76484_5_ - b - 1) b1 = 3;
/*     */             
/*  80 */             if (i1 == p_76484_3_ - b - 1 && i2 == p_76484_5_ + b) b1 = 7; 
/*  81 */             if (i1 == p_76484_3_ - b && i2 == p_76484_5_ + b - 1) b1 = 7;
/*     */             
/*  83 */             if (i1 == p_76484_3_ + b - 1 && i2 == p_76484_5_ + b) b1 = 9; 
/*  84 */             if (i1 == p_76484_3_ + b && i2 == p_76484_5_ + b - 1) b1 = 9;
/*     */           
/*     */           } 
/*  87 */           if (b1 == 5 && n < p_76484_4_ + j) b1 = 0; 
/*  88 */           if (b1 != 0 || p_76484_4_ >= p_76484_4_ + j - 1)
/*     */           {
/*  90 */             if (!p_76484_1_.func_147439_a(i1, n, i2).func_149730_j()) func_150516_a(p_76484_1_, i1, n, i2, Block.func_149729_e(Block.func_149682_b(Blocks.field_150420_aW) + i), b1);  } 
/*     */           continue;
/*     */         } 
/*     */       } 
/*     */     } 
/*  95 */     for (n = 0; n < j; n++) {
/*  96 */       Block block1 = p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_ + n, p_76484_5_);
/*     */       
/*  98 */       if (!block1.func_149730_j()) func_150516_a(p_76484_1_, p_76484_3_, p_76484_4_ + n, p_76484_5_, Block.func_149729_e(Block.func_149682_b(Blocks.field_150420_aW) + i), 10); 
/*     */     } 
/* 100 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\feature\WorldGenBigMushroom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */