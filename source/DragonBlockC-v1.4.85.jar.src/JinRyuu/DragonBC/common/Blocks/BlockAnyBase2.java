/*    */ package JinRyuu.DragonBC.common.Blocks;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockAnyBase2
/*    */   extends Block
/*    */ {
/*    */   public BlockAnyBase2() {
/* 21 */     this(0);
/*    */   }
/*    */   
/*    */   public BlockAnyBase2(int harvestlevel) {
/* 25 */     super(Material.field_151576_e);
/*    */ 
/*    */     
/* 28 */     func_149672_a(field_149780_i);
/* 29 */     func_149647_a(mod_DragonBC.DragonBlockC);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149651_a(IIconRegister par1IconRegister) {
/* 36 */     this.field_149761_L = par1IconRegister.func_94245_a("jinryuudragonbc:" + func_149739_a().replaceAll("tile.", ""));
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Blocks\BlockAnyBase2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */