/*    */ package JinRyuu.DragonBC.common.Items.m;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.Blocks.m.ModdedBlocks;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.item.ItemSlab;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class WoodSlabItem
/*    */   extends ItemSlab {
/* 10 */   public static final String[] slabs = new String[] { "Sakura", "Mahagony", "Maple" };
/*    */ 
/*    */   
/*    */   public WoodSlabItem(Block block) {
/* 14 */     super(block, ModdedBlocks.SakuraSlabsSingle, ModdedBlocks.SakuraSlabsDouble, (block == ModdedBlocks.SakuraSlabsDouble));
/* 15 */     func_77656_e(0);
/* 16 */     func_77627_a(true);
/*    */   }
/*    */   
/*    */   public String func_77667_c(ItemStack itemstack) {
/* 20 */     int i = itemstack.func_77960_j();
/* 21 */     if (i < 0 || i >= slabs.length)
/*    */     {
/* 23 */       i = 0;
/*    */     }
/* 25 */     return func_77658_a() + "." + slabs[i];
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_77647_b(int meta) {
/* 30 */     return meta;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Items\m\WoodSlabItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */