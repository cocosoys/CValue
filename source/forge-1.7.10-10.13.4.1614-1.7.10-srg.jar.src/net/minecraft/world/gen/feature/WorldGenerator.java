/*    */ package net.minecraft.world.gen.feature;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public abstract class WorldGenerator {
/*    */   private final boolean field_76488_a;
/*    */   private static final String __OBFID = "CL_00000409";
/*    */   
/*    */   public WorldGenerator() {
/* 12 */     this.field_76488_a = false;
/*    */   }
/*    */   
/*    */   public WorldGenerator(boolean p_i2013_1_) {
/* 16 */     this.field_76488_a = p_i2013_1_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public abstract boolean func_76484_a(World paramWorld, Random paramRandom, int paramInt1, int paramInt2, int paramInt3);
/*    */ 
/*    */   
/*    */   public void func_76487_a(double p_76487_1_, double p_76487_3_, double p_76487_5_) {}
/*    */ 
/*    */   
/*    */   protected void func_150515_a(World p_150515_1_, int p_150515_2_, int p_150515_3_, int p_150515_4_, Block p_150515_5_) {
/* 28 */     func_150516_a(p_150515_1_, p_150515_2_, p_150515_3_, p_150515_4_, p_150515_5_, 0);
/*    */   }
/*    */   
/*    */   protected void func_150516_a(World p_150516_1_, int p_150516_2_, int p_150516_3_, int p_150516_4_, Block p_150516_5_, int p_150516_6_) {
/* 32 */     if (this.field_76488_a) {
/* 33 */       p_150516_1_.func_147465_d(p_150516_2_, p_150516_3_, p_150516_4_, p_150516_5_, p_150516_6_, 3);
/*    */     } else {
/* 35 */       p_150516_1_.func_147465_d(p_150516_2_, p_150516_3_, p_150516_4_, p_150516_5_, p_150516_6_, 2);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\feature\WorldGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */