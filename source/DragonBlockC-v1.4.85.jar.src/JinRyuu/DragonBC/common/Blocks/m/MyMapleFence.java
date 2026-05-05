/*    */ package JinRyuu.DragonBC.common.Blocks.m;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*    */ import JinRyuu.JRMCore.JRMCoreH;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.List;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.BlockFence;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.IIcon;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.common.util.ForgeDirection;
/*    */ 
/*    */ public class MyMapleFence
/*    */   extends BlockFence {
/*    */   private IIcon[] texture;
/* 23 */   static final String[] subBlocks = new String[] { "Maple" };
/*    */ 
/*    */   
/*    */   public MyMapleFence(String unlocalizedName, Material material) {
/* 27 */     super(unlocalizedName, material);
/* 28 */     func_149663_c(unlocalizedName);
/* 29 */     func_149658_d(JRMCoreH.tjdbcAssts + ":" + unlocalizedName);
/* 30 */     func_149647_a(mod_DragonBC.DragonBlockC);
/* 31 */     func_149672_a(field_149766_f);
/*    */   }
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149666_a(Item item, CreativeTabs tabs, List<ItemStack> list) {
/* 37 */     for (int i = 0; i < subBlocks.length; i++) {
/* 38 */       list.add(new ItemStack(item, 1, i));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149651_a(IIconRegister iconRegister) {
/* 45 */     this.texture = new IIcon[subBlocks.length];
/*    */     
/* 47 */     for (int i = 0; i < this.texture.length; i++)
/*    */     {
/* 49 */       this.texture[i] = iconRegister.func_94245_a(JRMCoreH.tjdbcAssts + ":Planks" + subBlocks[i]);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_149692_a(int p_149692_1_) {
/* 55 */     return p_149692_1_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getFireSpreadSpeed(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
/* 61 */     return 40;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getFlammability(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
/* 66 */     return 5;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/* 71 */     if (p_149691_2_ < 0 || p_149691_2_ >= this.texture.length)
/*    */     {
/* 73 */       p_149691_2_ = 0;
/*    */     }
/*    */     
/* 76 */     return this.texture[p_149691_2_];
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
/* 81 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_149826_e(IBlockAccess p_149826_1_, int p_149826_2_, int p_149826_3_, int p_149826_4_) {
/* 87 */     Block block = p_149826_1_.func_147439_a(p_149826_2_, p_149826_3_, p_149826_4_);
/* 88 */     if (block.func_149688_o().func_76218_k() && block.func_149686_d()) {
/* 89 */       return (block.func_149688_o() != Material.field_151572_C);
/*    */     }
/* 91 */     if (block == this || block instanceof net.minecraft.block.BlockFenceGate)
/*    */     {
/*    */       
/* 94 */       return true;
/*    */     }
/*    */     
/* 97 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Blocks\m\MyMapleFence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */