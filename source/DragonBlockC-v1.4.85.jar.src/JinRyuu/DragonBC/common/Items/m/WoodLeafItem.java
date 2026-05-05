/*    */ package JinRyuu.DragonBC.common.Items.m;
/*    */ 
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.item.ItemBlock;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class WoodLeafItem
/*    */   extends ItemBlock
/*    */ {
/* 10 */   public static final String[] leaves = new String[] { "Sakura", "Mahagony" };
/*    */   
/*    */   public WoodLeafItem(Block block) {
/* 13 */     super(block);
/* 14 */     func_77627_a(true);
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_77667_c(ItemStack itemstack) {
/* 19 */     int i = itemstack.func_77960_j();
/* 20 */     if (i < 0 || i >= leaves.length)
/*    */     {
/* 22 */       i = 0;
/*    */     }
/* 24 */     return func_77658_a() + "." + leaves[i];
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_77647_b(int meta) {
/* 29 */     return meta;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Items\m\WoodLeafItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */