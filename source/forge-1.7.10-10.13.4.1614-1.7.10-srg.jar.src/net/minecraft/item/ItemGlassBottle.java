/*    */ package net.minecraft.item;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.util.MovingObjectPosition;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ItemGlassBottle extends Item {
/*    */   public ItemGlassBottle() {
/* 12 */     func_77637_a(CreativeTabs.field_78038_k);
/*    */   }
/*    */   private static final String __OBFID = "CL_00001776";
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon func_77617_a(int p_77617_1_) {
/* 17 */     return Items.field_151068_bn.func_77617_a(0);
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
/* 22 */     MovingObjectPosition movingObjectPosition = func_77621_a(p_77659_2_, p_77659_3_, true);
/* 23 */     if (movingObjectPosition == null) return p_77659_1_;
/*    */     
/* 25 */     if (movingObjectPosition.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK) {
/* 26 */       int i = movingObjectPosition.field_72311_b;
/* 27 */       int j = movingObjectPosition.field_72312_c;
/* 28 */       int k = movingObjectPosition.field_72309_d;
/*    */       
/* 30 */       if (!p_77659_2_.func_72962_a(p_77659_3_, i, j, k)) {
/* 31 */         return p_77659_1_;
/*    */       }
/* 33 */       if (!p_77659_3_.func_82247_a(i, j, k, movingObjectPosition.field_72310_e, p_77659_1_)) {
/* 34 */         return p_77659_1_;
/*    */       }
/* 36 */       if (p_77659_2_.func_147439_a(i, j, k).func_149688_o() == Material.field_151586_h) {
/*    */         
/* 38 */         p_77659_1_.field_77994_a--;
/* 39 */         if (p_77659_1_.field_77994_a <= 0) {
/* 40 */           return new ItemStack(Items.field_151068_bn);
/*    */         }
/* 42 */         if (!p_77659_3_.field_71071_by.func_70441_a(new ItemStack(Items.field_151068_bn))) {
/* 43 */           p_77659_3_.func_71019_a(new ItemStack(Items.field_151068_bn, 1, 0), false);
/*    */         }
/*    */       } 
/*    */     } 
/*    */ 
/*    */     
/* 49 */     return p_77659_1_;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_94581_a(IIconRegister p_94581_1_) {}
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemGlassBottle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */