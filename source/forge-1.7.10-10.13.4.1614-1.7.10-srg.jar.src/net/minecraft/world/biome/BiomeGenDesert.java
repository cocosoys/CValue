/*    */ package net.minecraft.world.biome;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.gen.feature.WorldGenDesertWells;
/*    */ 
/*    */ public class BiomeGenDesert
/*    */   extends BiomeGenBase {
/*    */   public BiomeGenDesert(int p_i1977_1_) {
/* 12 */     super(p_i1977_1_);
/*    */ 
/*    */     
/* 15 */     this.field_76762_K.clear();
/* 16 */     this.field_76752_A = (Block)Blocks.field_150354_m;
/* 17 */     this.field_76753_B = (Block)Blocks.field_150354_m;
/*    */     
/* 19 */     this.field_76760_I.field_76832_z = -999;
/* 20 */     this.field_76760_I.field_76804_C = 2;
/* 21 */     this.field_76760_I.field_76799_E = 50;
/* 22 */     this.field_76760_I.field_76800_F = 10;
/*    */     
/* 24 */     this.field_76762_K.clear();
/*    */   }
/*    */   private static final String __OBFID = "CL_00000167";
/*    */   
/*    */   public void func_76728_a(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_) {
/* 29 */     super.func_76728_a(p_76728_1_, p_76728_2_, p_76728_3_, p_76728_4_);
/*    */     
/* 31 */     if (p_76728_2_.nextInt(1000) == 0) {
/* 32 */       int i = p_76728_3_ + p_76728_2_.nextInt(16) + 8;
/* 33 */       int j = p_76728_4_ + p_76728_2_.nextInt(16) + 8;
/* 34 */       WorldGenDesertWells worldGenDesertWells = new WorldGenDesertWells();
/* 35 */       worldGenDesertWells.func_76484_a(p_76728_1_, p_76728_2_, i, p_76728_1_.func_72976_f(i, j) + 1, j);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\biome\BiomeGenDesert.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */