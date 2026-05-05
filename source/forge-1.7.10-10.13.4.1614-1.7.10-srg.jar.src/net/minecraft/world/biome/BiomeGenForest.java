/*     */ package net.minecraft.world.biome;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.BlockFlower;
/*     */ import net.minecraft.entity.passive.EntityWolf;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.gen.feature.WorldGenAbstractTree;
/*     */ import net.minecraft.world.gen.feature.WorldGenBigMushroom;
/*     */ import net.minecraft.world.gen.feature.WorldGenCanopyTree;
/*     */ import net.minecraft.world.gen.feature.WorldGenForest;
/*     */ 
/*     */ 
/*     */ public class BiomeGenForest
/*     */   extends BiomeGenBase
/*     */ {
/*     */   private int field_150632_aF;
/*  20 */   protected static final WorldGenForest field_150629_aC = new WorldGenForest(false, true);
/*  21 */   protected static final WorldGenForest field_150630_aD = new WorldGenForest(false, false);
/*  22 */   protected static final WorldGenCanopyTree field_150631_aE = new WorldGenCanopyTree(false);
/*     */   
/*     */   public BiomeGenForest(int p_i45377_1_, int p_i45377_2_) {
/*  25 */     super(p_i45377_1_);
/*  26 */     this.field_150632_aF = p_i45377_2_;
/*  27 */     this.field_76760_I.field_76832_z = 10;
/*  28 */     this.field_76760_I.field_76803_B = 2;
/*     */     
/*  30 */     if (this.field_150632_aF == 1) {
/*  31 */       this.field_76760_I.field_76832_z = 6;
/*  32 */       this.field_76760_I.field_76802_A = 100;
/*  33 */       this.field_76760_I.field_76803_B = 1;
/*     */     } 
/*  35 */     func_76733_a(5159473);
/*  36 */     func_76732_a(0.7F, 0.8F);
/*     */     
/*  38 */     if (this.field_150632_aF == 2) {
/*  39 */       this.field_150609_ah = 353825;
/*  40 */       this.field_76790_z = 3175492;
/*  41 */       func_76732_a(0.6F, 0.6F);
/*     */     } 
/*     */     
/*  44 */     if (this.field_150632_aF == 0) {
/*  45 */       this.field_76762_K.add(new BiomeGenBase.SpawnListEntry(EntityWolf.class, 5, 4, 4));
/*     */     }
/*     */     
/*  48 */     if (this.field_150632_aF == 3)
/*  49 */       this.field_76760_I.field_76832_z = -999; 
/*     */   }
/*     */   
/*     */   private static final String __OBFID = "CL_00000170";
/*     */   
/*     */   public BiomeGenBase func_150557_a(int p_150557_1_, boolean p_150557_2_) {
/*  55 */     if (this.field_150632_aF == 2) {
/*  56 */       this.field_150609_ah = 353825;
/*  57 */       this.field_76790_z = p_150557_1_;
/*     */       
/*  59 */       if (p_150557_2_) {
/*  60 */         this.field_150609_ah = (this.field_150609_ah & 0xFEFEFE) >> 1;
/*     */       }
/*  62 */       return this;
/*     */     } 
/*  64 */     return super.func_150557_a(p_150557_1_, p_150557_2_);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public WorldGenAbstractTree func_150567_a(Random p_150567_1_) {
/*  70 */     if (this.field_150632_aF == 3 && p_150567_1_.nextInt(3) > 0) {
/*  71 */       return (WorldGenAbstractTree)field_150631_aE;
/*     */     }
/*  73 */     if (this.field_150632_aF == 2 || p_150567_1_.nextInt(5) == 0) {
/*  74 */       return (WorldGenAbstractTree)field_150630_aD;
/*     */     }
/*  76 */     return (WorldGenAbstractTree)this.field_76757_N;
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_150572_a(Random p_150572_1_, int p_150572_2_, int p_150572_3_, int p_150572_4_) {
/*  81 */     if (this.field_150632_aF == 1) {
/*  82 */       double d = MathHelper.func_151237_a((1.0D + field_150606_ad.func_151601_a(p_150572_2_ / 48.0D, p_150572_4_ / 48.0D)) / 2.0D, 0.0D, 0.9999D);
/*  83 */       int i = (int)(d * BlockFlower.field_149859_a.length);
/*  84 */       if (i == 1) {
/*  85 */         i = 0;
/*     */       }
/*  87 */       return BlockFlower.field_149859_a[i];
/*     */     } 
/*  89 */     return super.func_150572_a(p_150572_1_, p_150572_2_, p_150572_3_, p_150572_4_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_76728_a(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_) {
/*  94 */     if (this.field_150632_aF == 3) {
/*  95 */       for (byte b1 = 0; b1 < 4; b1++) {
/*  96 */         for (byte b2 = 0; b2 < 4; b2++) {
/*  97 */           int j = p_76728_3_ + b1 * 4 + 1 + 8 + p_76728_2_.nextInt(3);
/*  98 */           int k = p_76728_4_ + b2 * 4 + 1 + 8 + p_76728_2_.nextInt(3);
/*  99 */           int m = p_76728_1_.func_72976_f(j, k);
/*     */           
/* 101 */           if (p_76728_2_.nextInt(20) == 0) {
/* 102 */             WorldGenBigMushroom worldGenBigMushroom = new WorldGenBigMushroom();
/* 103 */             worldGenBigMushroom.func_76484_a(p_76728_1_, p_76728_2_, j, m, k);
/*     */           } else {
/* 105 */             WorldGenAbstractTree worldGenAbstractTree = func_150567_a(p_76728_2_);
/* 106 */             worldGenAbstractTree.func_76487_a(1.0D, 1.0D, 1.0D);
/* 107 */             if (worldGenAbstractTree.func_76484_a(p_76728_1_, p_76728_2_, j, m, k)) {
/* 108 */               worldGenAbstractTree.func_150524_b(p_76728_1_, p_76728_2_, j, m, k);
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/* 114 */     int i = p_76728_2_.nextInt(5) - 3;
/* 115 */     if (this.field_150632_aF == 1) {
/* 116 */       i += 2;
/*     */     }
/* 118 */     for (byte b = 0; b < i; b++) {
/* 119 */       int j = p_76728_2_.nextInt(3);
/* 120 */       if (j == 0) {
/* 121 */         field_150610_ae.func_150548_a(1);
/* 122 */       } else if (j == 1) {
/* 123 */         field_150610_ae.func_150548_a(4);
/* 124 */       } else if (j == 2) {
/* 125 */         field_150610_ae.func_150548_a(5);
/*     */       } 
/*     */       
/* 128 */       for (byte b1 = 0; b1 < 5; b1++) {
/* 129 */         int k = p_76728_3_ + p_76728_2_.nextInt(16) + 8;
/* 130 */         int m = p_76728_4_ + p_76728_2_.nextInt(16) + 8;
/* 131 */         int n = p_76728_2_.nextInt(p_76728_1_.func_72976_f(k, m) + 32);
/* 132 */         if (field_150610_ae.func_76484_a(p_76728_1_, p_76728_2_, k, n, m)) {
/*     */           break;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 138 */     super.func_76728_a(p_76728_1_, p_76728_2_, p_76728_3_, p_76728_4_);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_150558_b(int p_150558_1_, int p_150558_2_, int p_150558_3_) {
/* 143 */     int i = super.func_150558_b(p_150558_1_, p_150558_2_, p_150558_3_);
/*     */     
/* 145 */     if (this.field_150632_aF == 3) {
/* 146 */       return (i & 0xFEFEFE) + 2634762 >> 1;
/*     */     }
/*     */     
/* 149 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public BiomeGenBase func_150566_k() {
/* 154 */     if (this.field_76756_M == BiomeGenBase.field_76767_f.field_76756_M) {
/* 155 */       BiomeGenForest biomeGenForest = new BiomeGenForest(this.field_76756_M + 128, 1);
/* 156 */       biomeGenForest.func_150570_a(new BiomeGenBase.Height(this.field_76748_D, this.field_76749_E + 0.2F));
/* 157 */       biomeGenForest.func_76735_a("Flower Forest");
/* 158 */       biomeGenForest.func_150557_a(6976549, true);
/* 159 */       biomeGenForest.func_76733_a(8233509);
/* 160 */       return biomeGenForest;
/*     */     } 
/* 162 */     if (this.field_76756_M == BiomeGenBase.field_150583_P.field_76756_M || this.field_76756_M == BiomeGenBase.field_150582_Q.field_76756_M)
/* 163 */       return new BiomeGenMutated(this, this.field_76756_M + 128, this)
/*     */         {
/*     */           public WorldGenAbstractTree func_150567_a(Random p_150567_1_) {
/* 166 */             if (p_150567_1_.nextBoolean()) {
/* 167 */               return (WorldGenAbstractTree)BiomeGenForest.field_150629_aC;
/*     */             }
/* 169 */             return (WorldGenAbstractTree)BiomeGenForest.field_150630_aD;
/*     */           }
/*     */           private static final String __OBFID = "CL_00001861";
/*     */         }; 
/* 173 */     return new BiomeGenMutated(this, this.field_76756_M + 128, this)
/*     */       {
/*     */         public void func_76728_a(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_) {
/* 176 */           this.field_150611_aD.func_76728_a(p_76728_1_, p_76728_2_, p_76728_3_, p_76728_4_);
/*     */         }
/*     */         
/*     */         private static final String __OBFID = "CL_00000172";
/*     */       };
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\biome\BiomeGenForest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */