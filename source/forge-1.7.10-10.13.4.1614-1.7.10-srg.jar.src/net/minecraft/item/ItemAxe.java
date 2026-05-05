/*    */ package net.minecraft.item;
/*    */ 
/*    */ import com.google.common.collect.Sets;
/*    */ import java.util.Set;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.init.Blocks;
/*    */ 
/*    */ public class ItemAxe
/*    */   extends ItemTool {
/* 11 */   private static final Set field_150917_c = Sets.newHashSet((Object[])new Block[] { Blocks.field_150344_f, Blocks.field_150342_X, Blocks.field_150364_r, Blocks.field_150363_s, (Block)Blocks.field_150486_ae, Blocks.field_150423_aK, Blocks.field_150428_aP });
/*    */   
/*    */   private static final String __OBFID = "CL_00001770";
/*    */   
/*    */   protected ItemAxe(Item.ToolMaterial p_i45327_1_) {
/* 16 */     super(3.0F, p_i45327_1_, field_150917_c);
/*    */   }
/*    */ 
/*    */   
/*    */   public float func_150893_a(ItemStack p_150893_1_, Block p_150893_2_) {
/* 21 */     if (p_150893_2_.func_149688_o() == Material.field_151575_d || p_150893_2_.func_149688_o() == Material.field_151585_k || p_150893_2_.func_149688_o() == Material.field_151582_l) {
/* 22 */       return this.field_77864_a;
/*    */     }
/* 24 */     return super.func_150893_a(p_150893_1_, p_150893_2_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemAxe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */