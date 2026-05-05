/*    */ package JinRyuu.DragonBC.common.Items;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.item.ItemBucket;
/*    */ 
/*    */ public class ItemDBCBucket
/*    */   extends ItemBucket {
/*    */   public ItemDBCBucket(Block fluidblock) {
/* 12 */     super(fluidblock);
/* 13 */     func_77637_a(mod_DragonBC.DragonBlockC);
/* 14 */     func_77642_a(Items.field_151133_ar);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_94581_a(IIconRegister iconRegister) {
/* 19 */     this.field_77791_bV = iconRegister.func_94245_a("jinryuudragonbc:" + func_77658_a().replaceAll("item.", ""));
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Items\ItemDBCBucket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */