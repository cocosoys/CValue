/*    */ package net.minecraft.world.biome;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.entity.passive.EntityHorse;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.gen.feature.WorldGenAbstractTree;
/*    */ import net.minecraft.world.gen.feature.WorldGenSavannaTree;
/*    */ 
/*    */ public class BiomeGenSavanna extends BiomeGenBase {
/* 12 */   private static final WorldGenSavannaTree field_150627_aC = new WorldGenSavannaTree(false);
/*    */   
/*    */   public BiomeGenSavanna(int p_i45383_1_) {
/* 15 */     super(p_i45383_1_);
/*    */     
/* 17 */     this.field_76762_K.add(new BiomeGenBase.SpawnListEntry(EntityHorse.class, 1, 2, 6));
/*    */     
/* 19 */     this.field_76760_I.field_76832_z = 1;
/* 20 */     this.field_76760_I.field_76802_A = 4;
/* 21 */     this.field_76760_I.field_76803_B = 20;
/*    */   }
/*    */   private static final String __OBFID = "CL_00000182";
/*    */   
/*    */   public WorldGenAbstractTree func_150567_a(Random p_150567_1_) {
/* 26 */     if (p_150567_1_.nextInt(5) > 0) {
/* 27 */       return (WorldGenAbstractTree)field_150627_aC;
/*    */     }
/* 29 */     return (WorldGenAbstractTree)this.field_76757_N;
/*    */   }
/*    */ 
/*    */   
/*    */   public BiomeGenBase func_150566_k() {
/* 34 */     Mutated mutated = new Mutated(this.field_76756_M + 128, this);
/*    */     
/* 36 */     mutated.field_76750_F = (this.field_76750_F + 1.0F) * 0.5F;
/* 37 */     mutated.field_76748_D = this.field_76748_D * 0.5F + 0.3F;
/* 38 */     mutated.field_76749_E = this.field_76749_E * 0.5F + 1.2F;
/*    */     
/* 40 */     return mutated;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_76728_a(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_) {
/* 46 */     field_150610_ae.func_150548_a(2);
/* 47 */     for (byte b = 0; b < 7; b++) {
/* 48 */       int i = p_76728_3_ + p_76728_2_.nextInt(16) + 8;
/* 49 */       int j = p_76728_4_ + p_76728_2_.nextInt(16) + 8;
/* 50 */       int k = p_76728_2_.nextInt(p_76728_1_.func_72976_f(i, j) + 32);
/* 51 */       field_150610_ae.func_76484_a(p_76728_1_, p_76728_2_, i, k, j);
/*    */     } 
/*    */     
/* 54 */     super.func_76728_a(p_76728_1_, p_76728_2_, p_76728_3_, p_76728_4_);
/*    */   }
/*    */   
/*    */   public static class Mutated extends BiomeGenMutated { private static final String __OBFID = "CL_00000183";
/*    */     
/*    */     public Mutated(int p_i45382_1_, BiomeGenBase p_i45382_2_) {
/* 60 */       super(p_i45382_1_, p_i45382_2_);
/*    */       
/* 62 */       this.field_76760_I.field_76832_z = 2;
/* 63 */       this.field_76760_I.field_76802_A = 2;
/* 64 */       this.field_76760_I.field_76803_B = 5;
/*    */     }
/*    */ 
/*    */     
/*    */     public void func_150573_a(World p_150573_1_, Random p_150573_2_, Block[] p_150573_3_, byte[] p_150573_4_, int p_150573_5_, int p_150573_6_, double p_150573_7_) {
/* 69 */       this.field_76752_A = (Block)Blocks.field_150349_c;
/* 70 */       this.field_150604_aj = 0;
/* 71 */       this.field_76753_B = Blocks.field_150346_d;
/* 72 */       if (p_150573_7_ > 1.75D) {
/* 73 */         this.field_76752_A = Blocks.field_150348_b;
/* 74 */         this.field_76753_B = Blocks.field_150348_b;
/* 75 */       } else if (p_150573_7_ > -0.5D) {
/* 76 */         this.field_76752_A = Blocks.field_150346_d;
/* 77 */         this.field_150604_aj = 1;
/*    */       } 
/* 79 */       func_150560_b(p_150573_1_, p_150573_2_, p_150573_3_, p_150573_4_, p_150573_5_, p_150573_6_, p_150573_7_);
/*    */     }
/*    */ 
/*    */     
/*    */     public void func_76728_a(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_) {
/* 84 */       this.field_76760_I.func_150512_a(p_76728_1_, p_76728_2_, this, p_76728_3_, p_76728_4_);
/*    */     } }
/*    */ 
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\biome\BiomeGenSavanna.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */