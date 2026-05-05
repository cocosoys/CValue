/*    */ package JinRyuu.DragonBC.common.Blocks.m;
/*    */ 
/*    */ import JinRyuu.JRMCore.JRMCoreH;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.List;
/*    */ import net.minecraft.block.BlockLog;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ import net.minecraftforge.common.util.ForgeDirection;
/*    */ 
/*    */ public class LogBlock
/*    */   extends BlockLog
/*    */ {
/* 18 */   public static final String[] logs = new String[] { "Sakura", "Mahagony", "Maple" };
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149666_a(Item item, CreativeTabs tabs, List<ItemStack> list) {
/* 22 */     for (int i = 0; i < logs.length; i++) {
/* 23 */       list.add(new ItemStack(item, 1, i));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149651_a(IIconRegister iconRegister) {
/* 30 */     this.field_150167_a = new net.minecraft.util.IIcon[logs.length];
/* 31 */     this.field_150166_b = new net.minecraft.util.IIcon[logs.length];
/*    */ 
/*    */     
/* 34 */     for (int i = 0; i < this.field_150167_a.length; i++) {
/* 35 */       this.field_150167_a[i] = iconRegister.func_94245_a(JRMCoreH.tjdbcAssts + ":" + func_149739_a().substring(5) + logs[i]);
/* 36 */       this.field_150166_b[i] = iconRegister.func_94245_a(JRMCoreH.tjdbcAssts + ":" + func_149739_a().substring(5) + logs[i] + "Top");
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getFireSpreadSpeed(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
/* 43 */     return 40;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getFlammability(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
/* 48 */     return 5;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Blocks\m\LogBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */