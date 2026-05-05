/*    */ package net.minecraft.item;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.List;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.util.IIcon;
/*    */ 
/*    */ public class ItemCoal
/*    */   extends Item {
/*    */   @SideOnly(Side.CLIENT)
/*    */   private IIcon field_111220_a;
/*    */   private static final String __OBFID = "CL_00000002";
/*    */   
/*    */   public ItemCoal() {
/* 17 */     func_77627_a(true);
/* 18 */     func_77656_e(0);
/* 19 */     func_77637_a(CreativeTabs.field_78035_l);
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_77667_c(ItemStack p_77667_1_) {
/* 24 */     if (p_77667_1_.func_77960_j() == 1) {
/* 25 */       return "item.charcoal";
/*    */     }
/* 27 */     return "item.coal";
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_150895_a(Item p_150895_1_, CreativeTabs p_150895_2_, List<ItemStack> p_150895_3_) {
/* 32 */     p_150895_3_.add(new ItemStack(p_150895_1_, 1, 0));
/* 33 */     p_150895_3_.add(new ItemStack(p_150895_1_, 1, 1));
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon func_77617_a(int p_77617_1_) {
/* 38 */     if (p_77617_1_ == 1) {
/* 39 */       return this.field_111220_a;
/*    */     }
/* 41 */     return super.func_77617_a(p_77617_1_);
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_94581_a(IIconRegister p_94581_1_) {
/* 46 */     super.func_94581_a(p_94581_1_);
/*    */     
/* 48 */     this.field_111220_a = p_94581_1_.func_94245_a("charcoal");
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemCoal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */