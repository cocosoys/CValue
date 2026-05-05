/*    */ package net.minecraft.item;
/*    */ 
/*    */ import com.google.common.collect.Sets;
/*    */ import java.util.Set;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.init.Blocks;
/*    */ 
/*    */ public class ItemSpade
/*    */   extends ItemTool {
/* 10 */   private static final Set field_150916_c = Sets.newHashSet((Object[])new Block[] { (Block)Blocks.field_150349_c, Blocks.field_150346_d, (Block)Blocks.field_150354_m, Blocks.field_150351_n, Blocks.field_150431_aC, Blocks.field_150433_aE, Blocks.field_150435_aG, Blocks.field_150458_ak, Blocks.field_150425_aM, (Block)Blocks.field_150391_bh });
/*    */   
/*    */   private static final String __OBFID = "CL_00000063";
/*    */   
/*    */   public ItemSpade(Item.ToolMaterial p_i45353_1_) {
/* 15 */     super(1.0F, p_i45353_1_, field_150916_c);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_150897_b(Block p_150897_1_) {
/* 20 */     if (p_150897_1_ == Blocks.field_150431_aC) return true; 
/* 21 */     if (p_150897_1_ == Blocks.field_150433_aE) return true; 
/* 22 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemSpade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */