/*    */ package JinRyuu.DragonBC.common.Blocks.m;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*    */ import JinRyuu.JRMCore.JRMCoreH;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.List;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.IIcon;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ import net.minecraftforge.common.util.ForgeDirection;
/*    */ 
/*    */ public class MyPaperWallSakura
/*    */   extends Block
/*    */ {
/* 21 */   public static final String[] walls = new String[] { "White", "Orange", "Magenta", "Light_Blue", "Yellow", "Lime", "Pink", "Gray", "Light_Gray", "Cyan", "Purple", "Blue", "Brown", "Green", "Red", "Black" };
/*    */   @SideOnly(Side.CLIENT)
/*    */   private IIcon[] icon;
/*    */   
/*    */   protected MyPaperWallSakura(String unlocalizedName, Material material) {
/* 26 */     super(material);
/* 27 */     func_149647_a(mod_DragonBC.DragonBlockC);
/* 28 */     func_149711_c(0.35F);
/* 29 */     func_149752_b(1.0F);
/* 30 */     setHarvestLevel("axe", 2);
/* 31 */     func_149672_a(field_149775_l);
/* 32 */     func_149713_g(3);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/* 39 */     if (p_149691_2_ < 0 || p_149691_2_ >= this.icon.length)
/*    */     {
/* 41 */       p_149691_2_ = 0;
/*    */     }
/*    */     
/* 44 */     return this.icon[p_149691_2_];
/*    */   }
/*    */   
/*    */   public int func_149692_a(int p_149692_1_) {
/* 48 */     return p_149692_1_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149666_a(Item item, CreativeTabs tabs, List<ItemStack> list) {
/* 55 */     for (int i = 0; i < walls.length; i++) {
/* 56 */       list.add(new ItemStack(item, 1, i));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149651_a(IIconRegister iconRegister) {
/* 63 */     this.icon = new IIcon[walls.length];
/*    */     
/* 65 */     for (int i = 0; i < this.icon.length; i++)
/*    */     {
/* 67 */       this.icon[i] = iconRegister.func_94245_a(JRMCoreH.tjdbcAssts + ":Sakura_" + walls[i]);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getFireSpreadSpeed(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
/* 75 */     return 40;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getFlammability(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
/* 80 */     return 5;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Blocks\m\MyPaperWallSakura.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */