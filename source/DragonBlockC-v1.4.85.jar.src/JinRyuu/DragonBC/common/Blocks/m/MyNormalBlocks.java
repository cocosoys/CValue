/*    */ package JinRyuu.DragonBC.common.Blocks.m;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*    */ import JinRyuu.JRMCore.JRMCoreH;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ 
/*    */ public class MyNormalBlocks
/*    */   extends Block {
/*    */   protected MyNormalBlocks(String unlocalizedName, Material material) {
/* 11 */     super(material);
/* 12 */     func_149663_c(unlocalizedName);
/* 13 */     func_149658_d(JRMCoreH.tjdbcAssts + ":" + unlocalizedName);
/* 14 */     func_149647_a(mod_DragonBC.DragonBlockC);
/* 15 */     func_149711_c(2.0F);
/* 16 */     func_149752_b(10.0F);
/* 17 */     setHarvestLevel("pickaxe", 1);
/* 18 */     func_149672_a(field_149769_e);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Blocks\m\MyNormalBlocks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */