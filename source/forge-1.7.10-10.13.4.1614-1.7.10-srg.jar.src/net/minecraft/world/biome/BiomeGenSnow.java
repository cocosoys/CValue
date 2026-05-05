/*    */ package net.minecraft.world.biome;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.gen.feature.WorldGenAbstractTree;
/*    */ import net.minecraft.world.gen.feature.WorldGenIcePath;
/*    */ import net.minecraft.world.gen.feature.WorldGenIceSpike;
/*    */ import net.minecraft.world.gen.feature.WorldGenTaiga2;
/*    */ 
/*    */ public class BiomeGenSnow extends BiomeGenBase {
/* 12 */   private WorldGenIceSpike field_150616_aD = new WorldGenIceSpike(); private boolean field_150615_aC;
/* 13 */   private WorldGenIcePath field_150617_aE = new WorldGenIcePath(4); private static final String __OBFID = "CL_00000174";
/*    */   
/*    */   public BiomeGenSnow(int p_i45378_1_, boolean p_i45378_2_) {
/* 16 */     super(p_i45378_1_);
/* 17 */     this.field_150615_aC = p_i45378_2_;
/*    */     
/* 19 */     if (p_i45378_2_) {
/* 20 */       this.field_76752_A = Blocks.field_150433_aE;
/*    */     }
/* 22 */     this.field_76762_K.clear();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_76728_a(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_) {
/* 28 */     if (this.field_150615_aC) {
/*    */       byte b;
/* 30 */       for (b = 0; b < 3; b++) {
/* 31 */         int i = p_76728_3_ + p_76728_2_.nextInt(16) + 8;
/* 32 */         int j = p_76728_4_ + p_76728_2_.nextInt(16) + 8;
/* 33 */         this.field_150616_aD.func_76484_a(p_76728_1_, p_76728_2_, i, p_76728_1_.func_72976_f(i, j), j);
/*    */       } 
/* 35 */       for (b = 0; b < 2; b++) {
/* 36 */         int i = p_76728_3_ + p_76728_2_.nextInt(16) + 8;
/* 37 */         int j = p_76728_4_ + p_76728_2_.nextInt(16) + 8;
/* 38 */         this.field_150617_aE.func_76484_a(p_76728_1_, p_76728_2_, i, p_76728_1_.func_72976_f(i, j), j);
/*    */       } 
/*    */     } 
/*    */     
/* 42 */     super.func_76728_a(p_76728_1_, p_76728_2_, p_76728_3_, p_76728_4_);
/*    */   }
/*    */ 
/*    */   
/*    */   public WorldGenAbstractTree func_150567_a(Random p_150567_1_) {
/* 47 */     return (WorldGenAbstractTree)new WorldGenTaiga2(false);
/*    */   }
/*    */ 
/*    */   
/*    */   public BiomeGenBase func_150566_k() {
/* 52 */     BiomeGenBase biomeGenBase = (new BiomeGenSnow(this.field_76756_M + 128, true)).func_150557_a(13828095, true).func_76735_a(this.field_76791_y + " Spikes").func_76742_b().func_76732_a(0.0F, 0.5F).func_150570_a(new BiomeGenBase.Height(this.field_76748_D + 0.1F, this.field_76749_E + 0.1F));
/*    */ 
/*    */     
/* 55 */     biomeGenBase.field_76748_D = this.field_76748_D + 0.3F;
/* 56 */     biomeGenBase.field_76749_E = this.field_76749_E + 0.4F;
/*    */     
/* 58 */     return biomeGenBase;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\biome\BiomeGenSnow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */