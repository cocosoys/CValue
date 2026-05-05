/*    */ package net.minecraft.item;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.List;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.potion.Potion;
/*    */ import net.minecraft.potion.PotionEffect;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ItemAppleGold extends ItemFood {
/*    */   public ItemAppleGold(int p_i45341_1_, float p_i45341_2_, boolean p_i45341_3_) {
/* 12 */     super(p_i45341_1_, p_i45341_2_, p_i45341_3_);
/*    */     
/* 14 */     func_77627_a(true);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000037";
/*    */   @SideOnly(Side.CLIENT)
/*    */   public boolean func_77636_d(ItemStack p_77636_1_) {
/* 19 */     return (p_77636_1_.func_77960_j() > 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public EnumRarity func_77613_e(ItemStack p_77613_1_) {
/* 24 */     if (p_77613_1_.func_77960_j() == 0) {
/* 25 */       return EnumRarity.rare;
/*    */     }
/* 27 */     return EnumRarity.epic;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_77849_c(ItemStack p_77849_1_, World p_77849_2_, EntityPlayer p_77849_3_) {
/* 32 */     if (!p_77849_2_.field_72995_K) p_77849_3_.func_70690_d(new PotionEffect(Potion.field_76444_x.field_76415_H, 2400, 0));
/*    */     
/* 34 */     if (p_77849_1_.func_77960_j() > 0) {
/* 35 */       if (!p_77849_2_.field_72995_K) {
/* 36 */         p_77849_3_.func_70690_d(new PotionEffect(Potion.field_76428_l.field_76415_H, 600, 4));
/* 37 */         p_77849_3_.func_70690_d(new PotionEffect(Potion.field_76429_m.field_76415_H, 6000, 0));
/* 38 */         p_77849_3_.func_70690_d(new PotionEffect(Potion.field_76426_n.field_76415_H, 6000, 0));
/*    */       } 
/*    */     } else {
/* 41 */       super.func_77849_c(p_77849_1_, p_77849_2_, p_77849_3_);
/*    */     } 
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_150895_a(Item p_150895_1_, CreativeTabs p_150895_2_, List<ItemStack> p_150895_3_) {
/* 47 */     p_150895_3_.add(new ItemStack(p_150895_1_, 1, 0));
/* 48 */     p_150895_3_.add(new ItemStack(p_150895_1_, 1, 1));
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemAppleGold.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */