/*    */ package JinRyuu.DragonBC.common.Blocks;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.item.Item;
/*    */ 
/*    */ 
/*    */ public class BlockAlienStone
/*    */   extends Block
/*    */ {
/*    */   public BlockAlienStone() {
/* 14 */     super(Material.field_151576_e);
/* 15 */     func_149647_a(mod_DragonBC.DragonBlockC);
/* 16 */     func_149711_c(1.5F);
/* 17 */     func_149752_b(10.0F);
/* 18 */     func_149672_a(field_149769_e);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getTextureFile() {
/* 23 */     return "jinryuudragonbc:";
/*    */   }
/*    */ 
/*    */   
/*    */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/* 28 */     return Item.func_150898_a(BlocksDBC.BlockAlienCobbleStone);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Blocks\BlockAlienStone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */