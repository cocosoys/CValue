/*     */ package net.minecraft.world.biome;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.gen.feature.WorldGenAbstractTree;
/*     */ import net.minecraft.world.gen.feature.WorldGenBlockBlob;
/*     */ import net.minecraft.world.gen.feature.WorldGenMegaPineTree;
/*     */ import net.minecraft.world.gen.feature.WorldGenerator;
/*     */ 
/*     */ public class BiomeGenTaiga extends BiomeGenBase {
/*  12 */   private static final WorldGenTaiga1 field_150639_aC = new WorldGenTaiga1();
/*  13 */   private static final WorldGenTaiga2 field_150640_aD = new WorldGenTaiga2(false);
/*  14 */   private static final WorldGenMegaPineTree field_150641_aE = new WorldGenMegaPineTree(false, false);
/*  15 */   private static final WorldGenMegaPineTree field_150642_aF = new WorldGenMegaPineTree(false, true);
/*  16 */   private static final WorldGenBlockBlob field_150643_aG = new WorldGenBlockBlob(Blocks.field_150341_Y, 0);
/*     */ 
/*     */   
/*     */   private int field_150644_aH;
/*     */   
/*     */   private static final String __OBFID = "CL_00000186";
/*     */ 
/*     */   
/*     */   public BiomeGenTaiga(int p_i45385_1_, int p_i45385_2_) {
/*  25 */     super(p_i45385_1_);
/*  26 */     this.field_150644_aH = p_i45385_2_;
/*     */     
/*  28 */     this.field_76762_K.add(new BiomeGenBase.SpawnListEntry(EntityWolf.class, 8, 4, 4));
/*     */     
/*  30 */     this.field_76760_I.field_76832_z = 10;
/*  31 */     if (p_i45385_2_ == 1 || p_i45385_2_ == 2) {
/*  32 */       this.field_76760_I.field_76803_B = 7;
/*  33 */       this.field_76760_I.field_76804_C = 1;
/*  34 */       this.field_76760_I.field_76798_D = 3;
/*     */     } else {
/*  36 */       this.field_76760_I.field_76803_B = 1;
/*  37 */       this.field_76760_I.field_76798_D = 1;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public WorldGenAbstractTree func_150567_a(Random p_150567_1_) {
/*  44 */     if ((this.field_150644_aH == 1 || this.field_150644_aH == 2) && p_150567_1_.nextInt(3) == 0) {
/*  45 */       if (this.field_150644_aH == 2 || p_150567_1_.nextInt(13) == 0) {
/*  46 */         return (WorldGenAbstractTree)field_150642_aF;
/*     */       }
/*  48 */       return (WorldGenAbstractTree)field_150641_aE;
/*     */     } 
/*  50 */     if (p_150567_1_.nextInt(3) == 0) {
/*  51 */       return (WorldGenAbstractTree)field_150639_aC;
/*     */     }
/*  53 */     return (WorldGenAbstractTree)field_150640_aD;
/*     */   }
/*     */ 
/*     */   
/*     */   public WorldGenerator func_76730_b(Random p_76730_1_) {
/*  58 */     if (p_76730_1_.nextInt(5) > 0) {
/*  59 */       return (WorldGenerator)new WorldGenTallGrass((Block)Blocks.field_150329_H, 2);
/*     */     }
/*  61 */     return (WorldGenerator)new WorldGenTallGrass((Block)Blocks.field_150329_H, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_76728_a(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_) {
/*  66 */     if (this.field_150644_aH == 1 || this.field_150644_aH == 2) {
/*  67 */       int i = p_76728_2_.nextInt(3);
/*  68 */       for (byte b1 = 0; b1 < i; b1++) {
/*  69 */         int j = p_76728_3_ + p_76728_2_.nextInt(16) + 8;
/*  70 */         int k = p_76728_4_ + p_76728_2_.nextInt(16) + 8;
/*  71 */         int m = p_76728_1_.func_72976_f(j, k);
/*  72 */         field_150643_aG.func_76484_a(p_76728_1_, p_76728_2_, j, m, k);
/*     */       } 
/*     */     } 
/*     */     
/*  76 */     field_150610_ae.func_150548_a(3);
/*  77 */     for (byte b = 0; b < 7; b++) {
/*  78 */       int i = p_76728_3_ + p_76728_2_.nextInt(16) + 8;
/*  79 */       int j = p_76728_4_ + p_76728_2_.nextInt(16) + 8;
/*  80 */       int k = p_76728_2_.nextInt(p_76728_1_.func_72976_f(i, j) + 32);
/*  81 */       field_150610_ae.func_76484_a(p_76728_1_, p_76728_2_, i, k, j);
/*     */     } 
/*     */     
/*  84 */     super.func_76728_a(p_76728_1_, p_76728_2_, p_76728_3_, p_76728_4_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_150573_a(World p_150573_1_, Random p_150573_2_, Block[] p_150573_3_, byte[] p_150573_4_, int p_150573_5_, int p_150573_6_, double p_150573_7_) {
/*  89 */     if (this.field_150644_aH == 1 || this.field_150644_aH == 2) {
/*  90 */       this.field_76752_A = (Block)Blocks.field_150349_c;
/*  91 */       this.field_150604_aj = 0;
/*  92 */       this.field_76753_B = Blocks.field_150346_d;
/*  93 */       if (p_150573_7_ > 1.75D) {
/*  94 */         this.field_76752_A = Blocks.field_150346_d;
/*  95 */         this.field_150604_aj = 1;
/*  96 */       } else if (p_150573_7_ > -0.95D) {
/*  97 */         this.field_76752_A = Blocks.field_150346_d;
/*  98 */         this.field_150604_aj = 2;
/*     */       } 
/*     */     } 
/* 101 */     func_150560_b(p_150573_1_, p_150573_2_, p_150573_3_, p_150573_4_, p_150573_5_, p_150573_6_, p_150573_7_);
/*     */   }
/*     */ 
/*     */   
/*     */   public BiomeGenBase func_150566_k() {
/* 106 */     if (this.field_76756_M == BiomeGenBase.field_150578_U.field_76756_M) {
/* 107 */       return (new BiomeGenTaiga(this.field_76756_M + 128, 2)).func_150557_a(5858897, true).func_76735_a("Mega Spruce Taiga").func_76733_a(5159473).func_76732_a(0.25F, 0.8F).func_150570_a(new BiomeGenBase.Height(this.field_76748_D, this.field_76749_E));
/*     */     }
/* 109 */     return super.func_150566_k();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\biome\BiomeGenTaiga.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */