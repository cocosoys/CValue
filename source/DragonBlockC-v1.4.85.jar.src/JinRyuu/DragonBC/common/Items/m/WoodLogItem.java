/*    */ package JinRyuu.DragonBC.common.Items.m;
/*    */ 
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.item.ItemBlock;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ public class WoodLogItem
/*    */   extends ItemBlock
/*    */ {
/* 11 */   public static final String[] logs = new String[] { "Sakura", "Mahagony", "Maple" };
/*    */   
/*    */   public WoodLogItem(Block block) {
/* 14 */     super(block);
/* 15 */     func_77627_a(true);
/*    */   }
/*    */   
/*    */   public String func_77667_c(ItemStack itemstack) {
/* 19 */     int i = itemstack.func_77960_j();
/* 20 */     if (i < 0 || i >= logs.length)
/*    */     {
/* 22 */       i = 0;
/*    */     }
/* 24 */     return func_77658_a() + "." + logs[i];
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_77647_b(int meta) {
/* 29 */     return meta;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Items\m\WoodLogItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */