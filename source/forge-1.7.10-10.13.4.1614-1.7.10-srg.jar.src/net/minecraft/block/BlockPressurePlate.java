/*    */ package net.minecraft.block;
/*    */ import java.util.List;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class BlockPressurePlate extends BlockBasePressurePlate {
/*    */   private Sensitivity field_150069_a;
/*    */   private static final String __OBFID = "CL_00000289";
/*    */   
/*    */   public enum Sensitivity {
/* 13 */     everything, mobs, players;
/*    */     
/*    */     private static final String __OBFID = "CL_00000290";
/*    */   }
/*    */   
/*    */   protected BlockPressurePlate(String p_i45418_1_, Material p_i45418_2_, Sensitivity p_i45418_3_) {
/* 19 */     super(p_i45418_1_, p_i45418_2_);
/* 20 */     this.field_150069_a = p_i45418_3_;
/*    */   }
/*    */ 
/*    */   
/*    */   protected int func_150066_d(int p_150066_1_) {
/* 25 */     return (p_150066_1_ > 0) ? 1 : 0;
/*    */   }
/*    */ 
/*    */   
/*    */   protected int func_150060_c(int p_150060_1_) {
/* 30 */     return (p_150060_1_ == 1) ? 15 : 0;
/*    */   }
/*    */ 
/*    */   
/*    */   protected int func_150065_e(World p_150065_1_, int p_150065_2_, int p_150065_3_, int p_150065_4_) {
/* 35 */     List list = null;
/*    */     
/* 37 */     if (this.field_150069_a == Sensitivity.everything) list = p_150065_1_.func_72839_b(null, func_150061_a(p_150065_2_, p_150065_3_, p_150065_4_)); 
/* 38 */     if (this.field_150069_a == Sensitivity.mobs) list = p_150065_1_.func_72872_a(EntityLivingBase.class, func_150061_a(p_150065_2_, p_150065_3_, p_150065_4_)); 
/* 39 */     if (this.field_150069_a == Sensitivity.players) list = p_150065_1_.func_72872_a(EntityPlayer.class, func_150061_a(p_150065_2_, p_150065_3_, p_150065_4_));
/*    */     
/* 41 */     if (list != null && !list.isEmpty()) {
/* 42 */       for (Entity entity : list) {
/* 43 */         if (!entity.func_145773_az()) {
/* 44 */           return 15;
/*    */         }
/*    */       } 
/*    */     }
/*    */     
/* 49 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockPressurePlate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */