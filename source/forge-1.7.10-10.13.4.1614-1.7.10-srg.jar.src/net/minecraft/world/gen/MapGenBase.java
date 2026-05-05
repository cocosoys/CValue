/*    */ package net.minecraft.world.gen;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.chunk.IChunkProvider;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MapGenBase
/*    */ {
/* 13 */   protected int field_75040_a = 8;
/* 14 */   protected Random field_75038_b = new Random();
/*    */   protected World field_75039_c;
/*    */   
/*    */   public void func_151539_a(IChunkProvider p_151539_1_, World p_151539_2_, int p_151539_3_, int p_151539_4_, Block[] p_151539_5_) {
/* 18 */     int i = this.field_75040_a;
/* 19 */     this.field_75039_c = p_151539_2_;
/*    */     
/* 21 */     this.field_75038_b.setSeed(p_151539_2_.func_72905_C());
/* 22 */     long l1 = this.field_75038_b.nextLong();
/* 23 */     long l2 = this.field_75038_b.nextLong();
/*    */     
/* 25 */     for (int j = p_151539_3_ - i; j <= p_151539_3_ + i; j++) {
/* 26 */       for (int k = p_151539_4_ - i; k <= p_151539_4_ + i; k++) {
/* 27 */         long l3 = j * l1;
/* 28 */         long l4 = k * l2;
/* 29 */         this.field_75038_b.setSeed(l3 ^ l4 ^ p_151539_2_.func_72905_C());
/* 30 */         func_151538_a(p_151539_2_, j, k, p_151539_3_, p_151539_4_, p_151539_5_);
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   private static final String __OBFID = "CL_00000394";
/*    */   
/*    */   protected void func_151538_a(World p_151538_1_, int p_151538_2_, int p_151538_3_, int p_151538_4_, int p_151538_5_, Block[] p_151538_6_) {}
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\MapGenBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */