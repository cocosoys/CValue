/*    */ package JinRyuu.DragonBC.common.Items.m;
/*    */ 
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.item.ItemBlock;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class MapleLeafItem extends ItemBlock {
/*  8 */   public static final String[] leaves = new String[] { "Maple" };
/*    */   
/*    */   public MapleLeafItem(Block block) {
/* 11 */     super(block);
/* 12 */     func_77627_a(true);
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_77667_c(ItemStack itemstack) {
/* 17 */     int i = itemstack.func_77960_j();
/* 18 */     if (i < 0 || i >= leaves.length)
/*    */     {
/* 20 */       i = 0;
/*    */     }
/* 22 */     return func_77658_a() + "." + leaves[i];
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_77647_b(int meta) {
/* 27 */     return meta;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Items\m\MapleLeafItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */