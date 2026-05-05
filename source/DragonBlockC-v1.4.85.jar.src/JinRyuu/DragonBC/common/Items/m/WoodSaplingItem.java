/*    */ package JinRyuu.DragonBC.common.Items.m;
/*    */ 
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.item.ItemBlockWithMetadata;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class WoodSaplingItem
/*    */   extends ItemBlockWithMetadata
/*    */ {
/* 10 */   public static final String[] saplings = new String[] { "Sakura", "Mahagony", "Maple" };
/*    */   
/*    */   public WoodSaplingItem(Block block) {
/* 13 */     super(block, block);
/* 14 */     func_77627_a(true);
/*    */   }
/*    */   
/*    */   public String func_77667_c(ItemStack itemstack) {
/* 18 */     int i = itemstack.func_77960_j();
/* 19 */     if (i < 0 || i >= saplings.length)
/*    */     {
/* 21 */       i = 0;
/*    */     }
/* 23 */     return func_77658_a() + "." + saplings[i];
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_77647_b(int meta) {
/* 28 */     return meta;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Items\m\WoodSaplingItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */