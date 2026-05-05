/*    */ package JinRyuu.DragonBC.common.Blocks;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.util.AxisAlignedBB;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ public class BlockYellowCloud
/*    */   extends Block
/*    */ {
/*    */   public BlockYellowCloud() {
/* 18 */     super(Material.field_151596_z);
/*    */     
/* 20 */     func_149711_c(0.1F);
/*    */     
/* 22 */     func_149752_b(10.0F);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getTextureFile() {
/* 28 */     return "jinryuudragonbc:";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149701_w() {
/* 37 */     return 0;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_149662_c() {
/* 46 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_149686_d() {
/* 54 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_149678_a(int par1, boolean par2) {
/* 61 */     return false;
/*    */   }
/*    */   
/*    */   public AxisAlignedBB func_149668_a(World par1World, int par2, int par3, int par4) {
/* 65 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_149747_d(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
/* 73 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149651_a(IIconRegister par1IconRegister) {
/* 79 */     this.field_149761_L = par1IconRegister.func_94245_a("jinryuudragonbc:" + func_149739_a());
/*    */   }
/*    */ 
/*    */   
/*    */   public int idDropped(int par1, Random par2Random, int par3) {
/* 84 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Blocks\BlockYellowCloud.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */