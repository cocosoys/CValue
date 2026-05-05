/*    */ package net.minecraft.block;
/*    */ 
/*    */ import net.minecraft.block.material.Material;
/*    */ 
/*    */ public abstract class BlockDirectional
/*    */   extends Block
/*    */ {
/*    */   private static final String __OBFID = "CL_00000227";
/*    */   
/*    */   protected BlockDirectional(Material p_i45401_1_) {
/* 11 */     super(p_i45401_1_);
/*    */   }
/*    */   
/*    */   public static int func_149895_l(int p_149895_0_) {
/* 15 */     return p_149895_0_ & 0x3;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockDirectional.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */