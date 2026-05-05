/*    */ package JinRyuu.JRMCore.blocks;
/*    */ 
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.item.ItemBlock;
/*    */ import net.minecraft.item.ItemDye;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class ItemBlockColoredStone
/*    */   extends ItemBlock
/*    */ {
/*    */   public ItemBlockColoredStone(Block par1) {
/* 12 */     super(par1);
/* 13 */     func_77656_e(0);
/* 14 */     func_77627_a(true);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int func_77647_b(int par1) {
/* 22 */     return par1;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String func_77667_c(ItemStack par1ItemStack) {
/* 33 */     int i = BlockColoredStone.getBlockFromDye(par1ItemStack.func_77960_j());
/* 34 */     return func_77658_a() + "." + ItemDye.field_150923_a[i];
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\blocks\ItemBlockColoredStone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */