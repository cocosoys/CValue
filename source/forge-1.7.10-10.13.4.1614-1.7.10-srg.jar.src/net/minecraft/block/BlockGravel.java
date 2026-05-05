/*    */ package net.minecraft.block;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.item.Item;
/*    */ 
/*    */ public class BlockGravel extends BlockFalling {
/*    */   private static final String __OBFID = "CL_00000252";
/*    */   
/*    */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/* 11 */     if (p_149650_3_ > 3) p_149650_3_ = 3; 
/* 12 */     if (p_149650_2_.nextInt(10 - p_149650_3_ * 3) == 0) return Items.field_151145_ak; 
/* 13 */     return Item.func_150898_a(this);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockGravel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */