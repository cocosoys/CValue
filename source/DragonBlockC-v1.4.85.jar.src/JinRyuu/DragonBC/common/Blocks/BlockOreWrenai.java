/*    */ package JinRyuu.DragonBC.common.Blocks;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.Items.ItemsDBC;
/*    */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.util.MathHelper;
/*    */ 
/*    */ 
/*    */ public class BlockOreWrenai
/*    */   extends Block
/*    */ {
/*    */   public BlockOreWrenai() {
/* 19 */     super(Material.field_151576_e);
/*    */     
/* 21 */     func_149675_a(true);
/* 22 */     func_149711_c(3.0F);
/* 23 */     func_149752_b(5.0F);
/* 24 */     func_149672_a(field_149769_e);
/* 25 */     func_149647_a(mod_DragonBC.DragonBlockC);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149651_a(IIconRegister par1IconRegister) {
/* 32 */     this.field_149761_L = par1IconRegister.func_94245_a("jinryuudragonbc:" + func_149739_a());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int func_149679_a(int par1, Random par2Random) {
/* 39 */     return MathHelper.func_76125_a(func_149745_a(par2Random) + par2Random.nextInt(par1 + 1), 1, 1);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int func_149745_a(Random par1Random) {
/* 47 */     return 2 + par1Random.nextInt(3);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/* 53 */     return ItemsDBC.ItemWarenai;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getTextureFile() {
/* 72 */     return "jinryuudragonbc:";
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Blocks\BlockOreWrenai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */