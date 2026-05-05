/*    */ package net.minecraft.item;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.util.IIcon;
/*    */ 
/*    */ public class ItemBlockWithMetadata extends ItemBlock {
/*    */   private Block field_150950_b;
/*    */   
/*    */   public ItemBlockWithMetadata(Block p_i45326_1_, Block p_i45326_2_) {
/* 10 */     super(p_i45326_1_);
/*    */     
/* 12 */     this.field_150950_b = p_i45326_2_;
/*    */     
/* 14 */     func_77656_e(0);
/* 15 */     func_77627_a(true);
/*    */   }
/*    */   private static final String __OBFID = "CL_00001769";
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon func_77617_a(int p_77617_1_) {
/* 20 */     return this.field_150950_b.func_149691_a(2, p_77617_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_77647_b(int p_77647_1_) {
/* 25 */     return p_77647_1_;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemBlockWithMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */