/*    */ package net.minecraft.server.management;
/*    */ 
/*    */ import java.util.Comparator;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.util.ChunkCoordinates;
/*    */ 
/*    */ public class PlayerPositionComparator implements Comparator {
/*    */   private final ChunkCoordinates field_82548_a;
/*    */   private static final String __OBFID = "CL_00001422";
/*    */   
/*    */   public PlayerPositionComparator(ChunkCoordinates p_i1499_1_) {
/* 12 */     this.field_82548_a = p_i1499_1_;
/*    */   }
/*    */ 
/*    */   
/*    */   public int compare(EntityPlayerMP p_compare_1_, EntityPlayerMP p_compare_2_) {
/* 17 */     double d1 = p_compare_1_.func_70092_e(this.field_82548_a.field_71574_a, this.field_82548_a.field_71572_b, this.field_82548_a.field_71573_c);
/* 18 */     double d2 = p_compare_2_.func_70092_e(this.field_82548_a.field_71574_a, this.field_82548_a.field_71572_b, this.field_82548_a.field_71573_c);
/*    */     
/* 20 */     if (d1 < d2)
/* 21 */       return -1; 
/* 22 */     if (d1 > d2) {
/* 23 */       return 1;
/*    */     }
/* 25 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\server\management\PlayerPositionComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */