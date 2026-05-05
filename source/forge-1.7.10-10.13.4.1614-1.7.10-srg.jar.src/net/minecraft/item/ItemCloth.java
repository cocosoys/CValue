/*    */ package net.minecraft.item;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.BlockColored;
/*    */ import net.minecraft.util.IIcon;
/*    */ 
/*    */ public class ItemCloth extends ItemBlock {
/*    */   public ItemCloth(Block p_i45358_1_) {
/*  8 */     super(p_i45358_1_);
/*    */     
/* 10 */     func_77656_e(0);
/* 11 */     func_77627_a(true);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000075";
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon func_77617_a(int p_77617_1_) {
/* 16 */     return this.field_150939_a.func_149735_b(2, BlockColored.func_150032_b(p_77617_1_));
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_77647_b(int p_77647_1_) {
/* 21 */     return p_77647_1_;
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_77667_c(ItemStack p_77667_1_) {
/* 26 */     return func_77658_a() + "." + ItemDye.field_150923_a[BlockColored.func_150032_b(p_77667_1_.func_77960_j())];
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemCloth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */