/*    */ package net.minecraft.world.biome;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.BlockFlower;
/*    */ import net.minecraft.entity.passive.EntityHorse;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class BiomeGenPlains
/*    */   extends BiomeGenBase {
/*    */   protected boolean field_150628_aC;
/*    */   private static final String __OBFID = "CL_00000180";
/*    */   
/*    */   public BiomeGenPlains(int p_i1986_1_) {
/* 14 */     super(p_i1986_1_);
/*    */     
/* 16 */     func_76732_a(0.8F, 0.4F);
/* 17 */     func_150570_a(field_150593_e);
/*    */     
/* 19 */     this.field_76762_K.add(new BiomeGenBase.SpawnListEntry(EntityHorse.class, 5, 2, 6));
/*    */     
/* 21 */     this.field_76760_I.field_76832_z = -999;
/* 22 */     this.field_76760_I.field_76802_A = 4;
/* 23 */     this.field_76760_I.field_76803_B = 10;
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_150572_a(Random p_150572_1_, int p_150572_2_, int p_150572_3_, int p_150572_4_) {
/* 28 */     double d = field_150606_ad.func_151601_a(p_150572_2_ / 200.0D, p_150572_4_ / 200.0D);
/* 29 */     if (d < -0.8D) {
/* 30 */       int i = p_150572_1_.nextInt(4);
/* 31 */       return BlockFlower.field_149859_a[4 + i];
/*    */     } 
/* 33 */     if (p_150572_1_.nextInt(3) > 0) {
/* 34 */       int i = p_150572_1_.nextInt(3);
/* 35 */       if (i == 0)
/* 36 */         return BlockFlower.field_149859_a[0]; 
/* 37 */       if (i == 1) {
/* 38 */         return BlockFlower.field_149859_a[3];
/*    */       }
/* 40 */       return BlockFlower.field_149859_a[8];
/*    */     } 
/*    */     
/* 43 */     return BlockFlower.field_149858_b[0];
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_76728_a(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_) {
/* 49 */     double d = field_150606_ad.func_151601_a((p_76728_3_ + 8) / 200.0D, (p_76728_4_ + 8) / 200.0D);
/* 50 */     if (d < -0.8D) {
/* 51 */       this.field_76760_I.field_76802_A = 15;
/* 52 */       this.field_76760_I.field_76803_B = 5;
/*    */     } else {
/* 54 */       this.field_76760_I.field_76802_A = 4;
/* 55 */       this.field_76760_I.field_76803_B = 10;
/*    */       
/* 57 */       field_150610_ae.func_150548_a(2);
/* 58 */       for (byte b = 0; b < 7; b++) {
/* 59 */         int i = p_76728_3_ + p_76728_2_.nextInt(16) + 8;
/* 60 */         int j = p_76728_4_ + p_76728_2_.nextInt(16) + 8;
/* 61 */         int k = p_76728_2_.nextInt(p_76728_1_.func_72976_f(i, j) + 32);
/* 62 */         field_150610_ae.func_76484_a(p_76728_1_, p_76728_2_, i, k, j);
/*    */       } 
/*    */     } 
/* 65 */     if (this.field_150628_aC) {
/* 66 */       field_150610_ae.func_150548_a(0);
/* 67 */       for (byte b = 0; b < 10; b++) {
/* 68 */         int i = p_76728_3_ + p_76728_2_.nextInt(16) + 8;
/* 69 */         int j = p_76728_4_ + p_76728_2_.nextInt(16) + 8;
/* 70 */         int k = p_76728_2_.nextInt(p_76728_1_.func_72976_f(i, j) + 32);
/* 71 */         field_150610_ae.func_76484_a(p_76728_1_, p_76728_2_, i, k, j);
/*    */       } 
/*    */     } 
/* 74 */     super.func_76728_a(p_76728_1_, p_76728_2_, p_76728_3_, p_76728_4_);
/*    */   }
/*    */ 
/*    */   
/*    */   public BiomeGenBase func_150566_k() {
/* 79 */     BiomeGenPlains biomeGenPlains = new BiomeGenPlains(this.field_76756_M + 128);
/* 80 */     biomeGenPlains.func_76735_a("Sunflower Plains");
/* 81 */     biomeGenPlains.field_150628_aC = true;
/* 82 */     biomeGenPlains.func_76739_b(9286496);
/* 83 */     biomeGenPlains.field_150609_ah = 14273354;
/* 84 */     return biomeGenPlains;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\biome\BiomeGenPlains.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */