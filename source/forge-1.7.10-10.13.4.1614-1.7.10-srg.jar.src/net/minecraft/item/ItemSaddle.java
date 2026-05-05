/*    */ package net.minecraft.item;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.passive.EntityPig;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ public class ItemSaddle extends Item {
/*    */   public ItemSaddle() {
/*  9 */     this.field_77777_bU = 1;
/* 10 */     func_77637_a(CreativeTabs.field_78029_e);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000059";
/*    */   
/*    */   public boolean func_111207_a(ItemStack p_111207_1_, EntityPlayer p_111207_2_, EntityLivingBase p_111207_3_) {
/* 15 */     if (p_111207_3_ instanceof EntityPig) {
/* 16 */       EntityPig entityPig = (EntityPig)p_111207_3_;
/* 17 */       if (!entityPig.func_70901_n() && !entityPig.func_70631_g_()) {
/* 18 */         entityPig.func_70900_e(true);
/* 19 */         entityPig.field_70170_p.func_72956_a((Entity)entityPig, "mob.horse.leather", 0.5F, 1.0F);
/* 20 */         p_111207_1_.field_77994_a--;
/*    */       } 
/*    */       
/* 23 */       return true;
/*    */     } 
/* 25 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_77644_a(ItemStack p_77644_1_, EntityLivingBase p_77644_2_, EntityLivingBase p_77644_3_) {
/* 30 */     func_111207_a(p_77644_1_, (EntityPlayer)null, p_77644_2_);
/* 31 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemSaddle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */