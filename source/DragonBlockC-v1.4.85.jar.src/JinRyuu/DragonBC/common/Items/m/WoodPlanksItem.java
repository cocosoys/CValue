/*    */ package JinRyuu.DragonBC.common.Items.m;
/*    */ 
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.item.ItemBlock;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class WoodPlanksItem
/*    */   extends ItemBlock {
/*  9 */   public static final String[] logs = new String[] { "Sakura", "Mahagony", "Maple" };
/*    */   
/*    */   public WoodPlanksItem(Block block) {
/* 12 */     super(block);
/* 13 */     func_77627_a(true);
/*    */   }
/*    */   
/*    */   public String func_77667_c(ItemStack itemstack) {
/* 17 */     int i = itemstack.func_77960_j();
/* 18 */     if (i < 0 || i >= logs.length)
/*    */     {
/* 20 */       i = 0;
/*    */     }
/* 22 */     return func_77658_a() + "." + logs[i];
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_77647_b(int meta) {
/* 27 */     return meta;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Items\m\WoodPlanksItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */