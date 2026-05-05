/*    */ package net.minecraft.item;
/*    */ 
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.nbt.NBTTagList;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ItemWritableBook extends Item {
/*    */   public ItemWritableBook() {
/* 10 */     func_77625_d(1);
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
/* 15 */     p_77659_3_.func_71048_c(p_77659_1_);
/* 16 */     return p_77659_1_;
/*    */   }
/*    */   private static final String __OBFID = "CL_00000076";
/*    */   
/*    */   public boolean func_77651_p() {
/* 21 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public static boolean func_150930_a(NBTTagCompound p_150930_0_) {
/* 26 */     if (p_150930_0_ == null) {
/* 27 */       return false;
/*    */     }
/* 29 */     if (!p_150930_0_.func_150297_b("pages", 9)) {
/* 30 */       return false;
/*    */     }
/*    */     
/* 33 */     NBTTagList nBTTagList = p_150930_0_.func_150295_c("pages", 8);
/* 34 */     for (byte b = 0; b < nBTTagList.func_74745_c(); b++) {
/* 35 */       String str = nBTTagList.func_150307_f(b);
/*    */       
/* 37 */       if (str == null) {
/* 38 */         return false;
/*    */       }
/* 40 */       if (str.length() > 256) {
/* 41 */         return false;
/*    */       }
/*    */     } 
/*    */     
/* 45 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemWritableBook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */