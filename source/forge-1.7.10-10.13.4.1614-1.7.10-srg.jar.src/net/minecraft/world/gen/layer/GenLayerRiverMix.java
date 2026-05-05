/*    */ package net.minecraft.world.gen.layer;
/*    */ 
/*    */ import net.minecraft.world.biome.BiomeGenBase;
/*    */ 
/*    */ public class GenLayerRiverMix
/*    */   extends GenLayer {
/*    */   private GenLayer field_75910_b;
/*    */   
/*    */   public GenLayerRiverMix(long p_i2129_1_, GenLayer p_i2129_3_, GenLayer p_i2129_4_) {
/* 10 */     super(p_i2129_1_);
/* 11 */     this.field_75910_b = p_i2129_3_;
/* 12 */     this.field_75911_c = p_i2129_4_;
/*    */   }
/*    */   private GenLayer field_75911_c; private static final String __OBFID = "CL_00000567";
/*    */   
/*    */   public void func_75905_a(long p_75905_1_) {
/* 17 */     this.field_75910_b.func_75905_a(p_75905_1_);
/* 18 */     this.field_75911_c.func_75905_a(p_75905_1_);
/* 19 */     super.func_75905_a(p_75905_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public int[] func_75904_a(int p_75904_1_, int p_75904_2_, int p_75904_3_, int p_75904_4_) {
/* 24 */     int[] arrayOfInt1 = this.field_75910_b.func_75904_a(p_75904_1_, p_75904_2_, p_75904_3_, p_75904_4_);
/* 25 */     int[] arrayOfInt2 = this.field_75911_c.func_75904_a(p_75904_1_, p_75904_2_, p_75904_3_, p_75904_4_);
/*    */     
/* 27 */     int[] arrayOfInt3 = IntCache.func_76445_a(p_75904_3_ * p_75904_4_);
/* 28 */     for (byte b = 0; b < p_75904_3_ * p_75904_4_; b++) {
/* 29 */       if (arrayOfInt1[b] == BiomeGenBase.field_76771_b.field_76756_M || arrayOfInt1[b] == BiomeGenBase.field_150575_M.field_76756_M)
/* 30 */       { arrayOfInt3[b] = arrayOfInt1[b]; }
/*    */       
/* 32 */       else if (arrayOfInt2[b] == BiomeGenBase.field_76781_i.field_76756_M)
/* 33 */       { if (arrayOfInt1[b] == BiomeGenBase.field_76774_n.field_76756_M) { arrayOfInt3[b] = BiomeGenBase.field_76777_m.field_76756_M; }
/* 34 */         else if (arrayOfInt1[b] == BiomeGenBase.field_76789_p.field_76756_M || arrayOfInt1[b] == BiomeGenBase.field_76788_q.field_76756_M) { arrayOfInt3[b] = BiomeGenBase.field_76788_q.field_76756_M; }
/* 35 */         else { arrayOfInt3[b] = arrayOfInt2[b] & 0xFF; }
/*    */          }
/* 37 */       else { arrayOfInt3[b] = arrayOfInt1[b]; }
/*    */     
/*    */     } 
/*    */ 
/*    */     
/* 42 */     return arrayOfInt3;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\layer\GenLayerRiverMix.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */