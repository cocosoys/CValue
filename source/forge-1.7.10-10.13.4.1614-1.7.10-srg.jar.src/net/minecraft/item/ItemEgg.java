/*    */ package net.minecraft.item;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ItemEgg extends Item {
/*    */   public ItemEgg() {
/*  9 */     this.field_77777_bU = 16;
/* 10 */     func_77637_a(CreativeTabs.field_78035_l);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000023";
/*    */   
/*    */   public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
/* 15 */     if (!p_77659_3_.field_71075_bZ.field_75098_d) {
/* 16 */       p_77659_1_.field_77994_a--;
/*    */     }
/* 18 */     p_77659_2_.func_72956_a((Entity)p_77659_3_, "random.bow", 0.5F, 0.4F / (field_77697_d.nextFloat() * 0.4F + 0.8F));
/* 19 */     if (!p_77659_2_.field_72995_K) p_77659_2_.func_72838_d((Entity)new EntityEgg(p_77659_2_, (EntityLivingBase)p_77659_3_)); 
/* 20 */     return p_77659_1_;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemEgg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */