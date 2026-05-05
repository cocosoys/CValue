/*    */ package JinRyuu.DragonBC.common.Blocks;
/*    */ 
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.item.ItemBlock;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class ItemDBCSaplingsTex extends ItemBlock {
/*  8 */   protected final String[] field_150942_c = BlockDBCSaplings.field_149882_a;
/*    */ 
/*    */   
/*    */   public ItemDBCSaplingsTex(Block p_i45346_1_) {
/* 12 */     super(p_i45346_1_);
/* 13 */     func_77627_a(true);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int func_77647_b(int p_77647_1_) {
/* 21 */     return p_77647_1_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String func_77667_c(ItemStack p_77667_1_) {
/* 30 */     int i = p_77667_1_.func_77960_j();
/*    */     
/* 32 */     if (i < 0 || i >= this.field_150942_c.length)
/*    */     {
/* 34 */       i = 0;
/*    */     }
/*    */ 
/*    */     
/* 38 */     return "tile.Block" + this.field_150942_c[i] + "Sapling";
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Blocks\ItemDBCSaplingsTex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */