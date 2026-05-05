/*    */ package JinRyuu.DragonBC.common.Blocks.m;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*    */ import JinRyuu.JRMCore.JRMCoreH;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.List;
/*    */ import net.minecraft.block.BlockWood;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.IIcon;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ import net.minecraftforge.common.util.ForgeDirection;
/*    */ 
/*    */ public class MyWoodPlanks
/*    */   extends BlockWood {
/* 19 */   public static final String[] planks = new String[] { "PlanksSakura", "PlanksMahagony", "PlanksMaple" };
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   private IIcon[] field_150095_b;
/*    */   
/*    */   public MyWoodPlanks() {
/* 25 */     func_149647_a(mod_DragonBC.DragonBlockC);
/* 26 */     func_149711_c(2.0F);
/* 27 */     func_149752_b(2.0F);
/* 28 */     func_149672_a(field_149766_f);
/* 29 */     setHarvestLevel("axe", 0);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/* 38 */     if (p_149691_2_ < 0 || p_149691_2_ >= this.field_150095_b.length)
/*    */     {
/* 40 */       p_149691_2_ = 0;
/*    */     }
/*    */     
/* 43 */     return this.field_150095_b[p_149691_2_];
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int func_149692_a(int p_149692_1_) {
/* 51 */     return p_149692_1_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149666_a(Item item, CreativeTabs tabs, List<ItemStack> list) {
/* 60 */     for (int i = 0; i < planks.length; i++) {
/* 61 */       list.add(new ItemStack(item, 1, i));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149651_a(IIconRegister iconRegister) {
/* 68 */     this.field_150095_b = new IIcon[planks.length];
/*    */     
/* 70 */     for (int i = 0; i < this.field_150095_b.length; i++)
/*    */     {
/* 72 */       this.field_150095_b[i] = iconRegister.func_94245_a(JRMCoreH.tjdbcAssts + ":" + planks[i]);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getFireSpreadSpeed(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
/* 80 */     return 40;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getFlammability(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
/* 85 */     return 5;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Blocks\m\MyWoodPlanks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */