/*    */ package JinRyuu.DragonBC.common.Blocks;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ 
/*    */ 
/*    */ public class BlockTCFloor
/*    */   extends Block
/*    */ {
/*    */   public BlockTCFloor() {
/* 16 */     super(Material.field_151576_e);
/* 17 */     func_149647_a(mod_DragonBC.DragonBlockC);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getTextureFile() {
/* 22 */     return "jinryuudragonbc:";
/*    */   }
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149651_a(IIconRegister par1IconRegister) {
/* 28 */     this.field_149761_L = par1IconRegister.func_94245_a("jinryuudragonbc:" + func_149739_a());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int func_149745_a(Random par1Random) {
/* 34 */     return 1;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Blocks\BlockTCFloor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */