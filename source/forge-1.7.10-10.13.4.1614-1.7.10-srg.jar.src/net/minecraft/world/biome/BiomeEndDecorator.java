/*    */ package net.minecraft.world.biome;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.boss.EntityDragon;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.world.gen.feature.WorldGenSpikes;
/*    */ import net.minecraft.world.gen.feature.WorldGenerator;
/*    */ 
/*    */ 
/*    */ public class BiomeEndDecorator
/*    */   extends BiomeDecorator
/*    */ {
/* 13 */   protected WorldGenerator field_76835_L = (WorldGenerator)new WorldGenSpikes(Blocks.field_150377_bs);
/*    */   private static final String __OBFID = "CL_00000188";
/*    */   
/*    */   protected void func_150513_a(BiomeGenBase p_150513_1_) {
/* 17 */     func_76797_b();
/*    */     
/* 19 */     if (this.field_76813_b.nextInt(5) == 0) {
/* 20 */       int i = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
/* 21 */       int j = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
/* 22 */       int k = this.field_76815_a.func_72825_h(i, j);
/* 23 */       this.field_76835_L.func_76484_a(this.field_76815_a, this.field_76813_b, i, k, j);
/*    */     } 
/*    */     
/* 26 */     if (this.field_76814_c == 0 && this.field_76811_d == 0) {
/* 27 */       EntityDragon entityDragon = new EntityDragon(this.field_76815_a);
/* 28 */       entityDragon.func_70012_b(0.0D, 128.0D, 0.0D, this.field_76813_b.nextFloat() * 360.0F, 0.0F);
/* 29 */       this.field_76815_a.func_72838_d((Entity)entityDragon);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\biome\BiomeEndDecorator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */