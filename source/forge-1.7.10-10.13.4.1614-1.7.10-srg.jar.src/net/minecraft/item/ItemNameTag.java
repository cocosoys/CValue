/*    */ package net.minecraft.item;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ public class ItemNameTag extends Item {
/*    */   public ItemNameTag() {
/*  9 */     func_77637_a(CreativeTabs.field_78040_i);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000052";
/*    */   
/*    */   public boolean func_111207_a(ItemStack p_111207_1_, EntityPlayer p_111207_2_, EntityLivingBase p_111207_3_) {
/* 14 */     if (!p_111207_1_.func_82837_s()) return false;
/*    */     
/* 16 */     if (p_111207_3_ instanceof EntityLiving) {
/* 17 */       EntityLiving entityLiving = (EntityLiving)p_111207_3_;
/* 18 */       entityLiving.func_94058_c(p_111207_1_.func_82833_r());
/* 19 */       entityLiving.func_110163_bv();
/* 20 */       p_111207_1_.field_77994_a--;
/* 21 */       return true;
/*    */     } 
/*    */     
/* 24 */     return super.func_111207_a(p_111207_1_, p_111207_2_, p_111207_3_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemNameTag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */