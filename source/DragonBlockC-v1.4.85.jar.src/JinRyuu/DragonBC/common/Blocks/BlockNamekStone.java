/*    */ package JinRyuu.DragonBC.common.Blocks;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ 
/*    */ public class BlockNamekStone
/*    */   extends Block
/*    */ {
/*    */   public BlockNamekStone() {
/* 14 */     super(Material.field_151576_e);
/* 15 */     func_149647_a(mod_DragonBC.DragonBlockC);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getTextureFile() {
/* 20 */     return "jinryuudragonbc:";
/*    */   }
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149651_a(IIconRegister par1IconRegister) {
/* 26 */     this.field_149761_L = par1IconRegister.func_94245_a("jinryuudragonbc:" + func_149739_a());
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Blocks\BlockNamekStone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */