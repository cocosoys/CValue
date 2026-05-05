/*    */ package net.minecraft.world.biome;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.gen.feature.WorldGenAbstractTree;
/*    */ import net.minecraft.world.gen.feature.WorldGenTallGrass;
/*    */ import net.minecraft.world.gen.feature.WorldGenVines;
/*    */ import net.minecraft.world.gen.feature.WorldGenerator;
/*    */ 
/*    */ public class BiomeGenJungle extends BiomeGenBase {
/*    */   private boolean field_150614_aC;
/*    */   
/*    */   public BiomeGenJungle(int p_i45379_1_, boolean p_i45379_2_) {
/* 15 */     super(p_i45379_1_);
/* 16 */     this.field_150614_aC = p_i45379_2_;
/* 17 */     if (p_i45379_2_) {
/* 18 */       this.field_76760_I.field_76832_z = 2;
/*    */     } else {
/* 20 */       this.field_76760_I.field_76832_z = 50;
/*    */     } 
/* 22 */     this.field_76760_I.field_76803_B = 25;
/* 23 */     this.field_76760_I.field_76802_A = 4;
/*    */     
/* 25 */     if (!p_i45379_2_) {
/* 26 */       this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntityOcelot.class, 2, 1, 1));
/*    */     }
/*    */ 
/*    */     
/* 30 */     this.field_76762_K.add(new BiomeGenBase.SpawnListEntry(EntityChicken.class, 10, 4, 4));
/*    */   }
/*    */   private static final String __OBFID = "CL_00000175";
/*    */   
/*    */   public WorldGenAbstractTree func_150567_a(Random p_150567_1_) {
/* 35 */     if (p_150567_1_.nextInt(10) == 0) {
/* 36 */       return (WorldGenAbstractTree)this.field_76758_O;
/*    */     }
/* 38 */     if (p_150567_1_.nextInt(2) == 0) {
/* 39 */       return (WorldGenAbstractTree)new WorldGenShrub(3, 0);
/*    */     }
/* 41 */     if (!this.field_150614_aC && p_150567_1_.nextInt(3) == 0) {
/* 42 */       return (WorldGenAbstractTree)new WorldGenMegaJungle(false, 10, 20, 3, 3);
/*    */     }
/* 44 */     return (WorldGenAbstractTree)new WorldGenTrees(false, 4 + p_150567_1_.nextInt(7), 3, 3, true);
/*    */   }
/*    */ 
/*    */   
/*    */   public WorldGenerator func_76730_b(Random p_76730_1_) {
/* 49 */     if (p_76730_1_.nextInt(4) == 0) {
/* 50 */       return (WorldGenerator)new WorldGenTallGrass((Block)Blocks.field_150329_H, 2);
/*    */     }
/* 52 */     return (WorldGenerator)new WorldGenTallGrass((Block)Blocks.field_150329_H, 1);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_76728_a(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_) {
/* 57 */     super.func_76728_a(p_76728_1_, p_76728_2_, p_76728_3_, p_76728_4_);
/*    */ 
/*    */     
/* 60 */     int i = p_76728_3_ + p_76728_2_.nextInt(16) + 8;
/* 61 */     int j = p_76728_4_ + p_76728_2_.nextInt(16) + 8;
/* 62 */     int k = p_76728_2_.nextInt(p_76728_1_.func_72976_f(i, j) * 2);
/* 63 */     (new WorldGenMelon()).func_76484_a(p_76728_1_, p_76728_2_, i, k, j);
/*    */ 
/*    */     
/* 66 */     WorldGenVines worldGenVines = new WorldGenVines();
/*    */     
/* 68 */     for (j = 0; j < 50; j++) {
/* 69 */       k = p_76728_3_ + p_76728_2_.nextInt(16) + 8;
/* 70 */       char c = '';
/* 71 */       int m = p_76728_4_ + p_76728_2_.nextInt(16) + 8;
/* 72 */       worldGenVines.func_76484_a(p_76728_1_, p_76728_2_, k, c, m);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\biome\BiomeGenJungle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */