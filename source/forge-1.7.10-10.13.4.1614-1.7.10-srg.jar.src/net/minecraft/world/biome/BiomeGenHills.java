/*    */ package net.minecraft.world.biome;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.gen.feature.WorldGenAbstractTree;
/*    */ import net.minecraft.world.gen.feature.WorldGenMinable;
/*    */ import net.minecraft.world.gen.feature.WorldGenTaiga2;
/*    */ import net.minecraft.world.gen.feature.WorldGenerator;
/*    */ 
/*    */ public class BiomeGenHills
/*    */   extends BiomeGenBase {
/* 14 */   private WorldGenerator field_82915_S = (WorldGenerator)new WorldGenMinable(Blocks.field_150418_aU, 8);
/* 15 */   private WorldGenTaiga2 field_150634_aD = new WorldGenTaiga2(false);
/*    */   
/* 17 */   private int field_150635_aE = 0;
/* 18 */   private int field_150636_aF = 1;
/* 19 */   private int field_150637_aG = 2;
/*    */   private int field_150638_aH;
/*    */   private static final String __OBFID = "CL_00000168";
/*    */   
/*    */   public BiomeGenHills(int p_i45373_1_, boolean p_i45373_2_) {
/* 24 */     super(p_i45373_1_);
/* 25 */     this.field_150638_aH = this.field_150635_aE;
/* 26 */     if (p_i45373_2_) {
/* 27 */       this.field_76760_I.field_76832_z = 3;
/* 28 */       this.field_150638_aH = this.field_150636_aF;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public WorldGenAbstractTree func_150567_a(Random p_150567_1_) {
/* 34 */     if (p_150567_1_.nextInt(3) > 0) {
/* 35 */       return (WorldGenAbstractTree)this.field_150634_aD;
/*    */     }
/* 37 */     return super.func_150567_a(p_150567_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_76728_a(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_) {
/* 42 */     super.func_76728_a(p_76728_1_, p_76728_2_, p_76728_3_, p_76728_4_);
/*    */ 
/*    */     
/* 45 */     int i = 3 + p_76728_2_.nextInt(6); int j;
/* 46 */     for (j = 0; j < i; j++) {
/* 47 */       int k = p_76728_3_ + p_76728_2_.nextInt(16);
/* 48 */       int m = p_76728_2_.nextInt(28) + 4;
/* 49 */       int n = p_76728_4_ + p_76728_2_.nextInt(16);
/* 50 */       if (p_76728_1_.func_147439_a(k, m, n) == Blocks.field_150348_b) {
/* 51 */         p_76728_1_.func_147465_d(k, m, n, Blocks.field_150412_bA, 0, 2);
/*    */       }
/*    */     } 
/*    */ 
/*    */     
/* 56 */     for (i = 0; i < 7; i++) {
/* 57 */       j = p_76728_3_ + p_76728_2_.nextInt(16);
/* 58 */       int k = p_76728_2_.nextInt(64);
/* 59 */       int m = p_76728_4_ + p_76728_2_.nextInt(16);
/* 60 */       this.field_82915_S.func_76484_a(p_76728_1_, p_76728_2_, j, k, m);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_150573_a(World p_150573_1_, Random p_150573_2_, Block[] p_150573_3_, byte[] p_150573_4_, int p_150573_5_, int p_150573_6_, double p_150573_7_) {
/* 66 */     this.field_76752_A = (Block)Blocks.field_150349_c;
/* 67 */     this.field_150604_aj = 0;
/* 68 */     this.field_76753_B = Blocks.field_150346_d;
/* 69 */     if ((p_150573_7_ < -1.0D || p_150573_7_ > 2.0D) && this.field_150638_aH == this.field_150637_aG) {
/* 70 */       this.field_76752_A = Blocks.field_150351_n;
/* 71 */       this.field_76753_B = Blocks.field_150351_n;
/* 72 */     } else if (p_150573_7_ > 1.0D && this.field_150638_aH != this.field_150636_aF) {
/* 73 */       this.field_76752_A = Blocks.field_150348_b;
/* 74 */       this.field_76753_B = Blocks.field_150348_b;
/*    */     } 
/* 76 */     func_150560_b(p_150573_1_, p_150573_2_, p_150573_3_, p_150573_4_, p_150573_5_, p_150573_6_, p_150573_7_);
/*    */   }
/*    */   
/*    */   public BiomeGenHills func_150633_b(BiomeGenBase p_150633_1_) {
/* 80 */     this.field_150638_aH = this.field_150637_aG;
/*    */     
/* 82 */     func_150557_a(p_150633_1_.field_76790_z, true);
/* 83 */     func_76735_a(p_150633_1_.field_76791_y + " M");
/* 84 */     func_150570_a(new BiomeGenBase.Height(p_150633_1_.field_76748_D, p_150633_1_.field_76749_E));
/* 85 */     func_76732_a(p_150633_1_.field_76750_F, p_150633_1_.field_76751_G);
/* 86 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public BiomeGenBase func_150566_k() {
/* 91 */     return (new BiomeGenHills(this.field_76756_M + 128, false)).func_150633_b(this);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\biome\BiomeGenHills.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */