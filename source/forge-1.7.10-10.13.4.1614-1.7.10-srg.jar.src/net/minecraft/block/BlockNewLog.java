/*    */ package net.minecraft.block;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.List;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ public class BlockNewLog
/*    */   extends BlockLog
/*    */ {
/* 15 */   public static final String[] field_150169_M = new String[] { "acacia", "big_oak" };
/*    */   
/*    */   private static final String __OBFID = "CL_00000277";
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149666_a(Item p_149666_1_, CreativeTabs p_149666_2_, List<ItemStack> p_149666_3_) {
/* 21 */     p_149666_3_.add(new ItemStack(p_149666_1_, 1, 0));
/* 22 */     p_149666_3_.add(new ItemStack(p_149666_1_, 1, 1));
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 27 */     this.field_150167_a = new net.minecraft.util.IIcon[field_150169_M.length];
/* 28 */     this.field_150166_b = new net.minecraft.util.IIcon[field_150169_M.length];
/*    */     
/* 30 */     for (byte b = 0; b < this.field_150167_a.length; b++) {
/* 31 */       this.field_150167_a[b] = p_149651_1_.func_94245_a(func_149641_N() + "_" + field_150169_M[b]);
/* 32 */       this.field_150166_b[b] = p_149651_1_.func_94245_a(func_149641_N() + "_" + field_150169_M[b] + "_top");
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockNewLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */