/*    */ package net.minecraft.item;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.entity.passive.EntityPig;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ public class ItemCarrotOnAStick extends Item {
/*    */   public ItemCarrotOnAStick() {
/*  9 */     func_77637_a(CreativeTabs.field_78029_e);
/* 10 */     func_77625_d(1);
/* 11 */     func_77656_e(25);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000001";
/*    */   @SideOnly(Side.CLIENT)
/*    */   public boolean func_77662_d() {
/* 16 */     return true;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public boolean func_77629_n_() {
/* 21 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
/* 26 */     if (p_77659_3_.func_70115_ae() && p_77659_3_.field_70154_o instanceof EntityPig) {
/* 27 */       EntityPig entityPig = (EntityPig)p_77659_3_.field_70154_o;
/*    */       
/* 29 */       if (entityPig.func_82183_n().func_82633_h() && p_77659_1_.func_77958_k() - p_77659_1_.func_77960_j() >= 7) {
/* 30 */         entityPig.func_82183_n().func_82632_g();
/* 31 */         p_77659_1_.func_77972_a(7, (EntityLivingBase)p_77659_3_);
/*    */         
/* 33 */         if (p_77659_1_.field_77994_a == 0) {
/* 34 */           ItemStack itemStack = new ItemStack(Items.field_151112_aM);
/* 35 */           itemStack.func_77982_d(p_77659_1_.field_77990_d);
/* 36 */           return itemStack;
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 41 */     return p_77659_1_;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemCarrotOnAStick.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */