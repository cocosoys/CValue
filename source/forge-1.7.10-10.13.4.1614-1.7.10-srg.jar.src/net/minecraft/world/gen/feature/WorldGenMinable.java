/*    */ package net.minecraft.world.gen.feature;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class WorldGenMinable extends WorldGenerator {
/*    */   private Block field_150519_a;
/*    */   private int field_76541_b;
/*    */   private Block field_150518_c;
/*    */   private static final String __OBFID = "CL_00000426";
/*    */   
/*    */   public WorldGenMinable(Block p_i45459_1_, int p_i45459_2_) {
/* 16 */     this(p_i45459_1_, p_i45459_2_, Blocks.field_150348_b);
/*    */   }
/*    */   
/*    */   public WorldGenMinable(Block p_i45460_1_, int p_i45460_2_, Block p_i45460_3_) {
/* 20 */     this.field_150519_a = p_i45460_1_;
/* 21 */     this.field_76541_b = p_i45460_2_;
/* 22 */     this.field_150518_c = p_i45460_3_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
/* 28 */     float f = p_76484_2_.nextFloat() * 3.1415927F;
/*    */     
/* 30 */     double d1 = ((p_76484_3_ + 8) + MathHelper.func_76126_a(f) * this.field_76541_b / 8.0F);
/* 31 */     double d2 = ((p_76484_3_ + 8) - MathHelper.func_76126_a(f) * this.field_76541_b / 8.0F);
/* 32 */     double d3 = ((p_76484_5_ + 8) + MathHelper.func_76134_b(f) * this.field_76541_b / 8.0F);
/* 33 */     double d4 = ((p_76484_5_ + 8) - MathHelper.func_76134_b(f) * this.field_76541_b / 8.0F);
/*    */     
/* 35 */     double d5 = (p_76484_4_ + p_76484_2_.nextInt(3) - 2);
/* 36 */     double d6 = (p_76484_4_ + p_76484_2_.nextInt(3) - 2);
/*    */     
/* 38 */     for (byte b = 0; b <= this.field_76541_b; b++) {
/* 39 */       double d7 = d1 + (d2 - d1) * b / this.field_76541_b;
/* 40 */       double d8 = d5 + (d6 - d5) * b / this.field_76541_b;
/* 41 */       double d9 = d3 + (d4 - d3) * b / this.field_76541_b;
/*    */       
/* 43 */       double d10 = p_76484_2_.nextDouble() * this.field_76541_b / 16.0D;
/* 44 */       double d11 = (MathHelper.func_76126_a(b * 3.1415927F / this.field_76541_b) + 1.0F) * d10 + 1.0D;
/* 45 */       double d12 = (MathHelper.func_76126_a(b * 3.1415927F / this.field_76541_b) + 1.0F) * d10 + 1.0D;
/*    */       
/* 47 */       int i = MathHelper.func_76128_c(d7 - d11 / 2.0D);
/* 48 */       int j = MathHelper.func_76128_c(d8 - d12 / 2.0D);
/* 49 */       int k = MathHelper.func_76128_c(d9 - d11 / 2.0D);
/*    */       
/* 51 */       int m = MathHelper.func_76128_c(d7 + d11 / 2.0D);
/* 52 */       int n = MathHelper.func_76128_c(d8 + d12 / 2.0D);
/* 53 */       int i1 = MathHelper.func_76128_c(d9 + d11 / 2.0D);
/*    */       
/* 55 */       for (int i2 = i; i2 <= m; i2++) {
/* 56 */         double d = (i2 + 0.5D - d7) / d11 / 2.0D;
/* 57 */         if (d * d < 1.0D) {
/* 58 */           for (int i3 = j; i3 <= n; i3++) {
/* 59 */             double d13 = (i3 + 0.5D - d8) / d12 / 2.0D;
/* 60 */             if (d * d + d13 * d13 < 1.0D) {
/* 61 */               for (int i4 = k; i4 <= i1; i4++) {
/* 62 */                 double d14 = (i4 + 0.5D - d9) / d11 / 2.0D;
/* 63 */                 if (d * d + d13 * d13 + d14 * d14 < 1.0D && 
/* 64 */                   p_76484_1_.func_147439_a(i2, i3, i4) == this.field_150518_c) p_76484_1_.func_147465_d(i2, i3, i4, this.field_150519_a, 0, 2);
/*    */               
/*    */               } 
/*    */             }
/*    */           } 
/*    */         }
/*    */       } 
/*    */     } 
/*    */     
/* 73 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\feature\WorldGenMinable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */