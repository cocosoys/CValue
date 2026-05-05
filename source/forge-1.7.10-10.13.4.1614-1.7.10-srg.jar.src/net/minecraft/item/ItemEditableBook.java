/*    */ package net.minecraft.item;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.List;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.util.EnumChatFormatting;
/*    */ import net.minecraft.util.StatCollector;
/*    */ import net.minecraft.util.StringUtils;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemEditableBook
/*    */   extends Item
/*    */ {
/*    */   private static final String __OBFID = "CL_00000077";
/*    */   
/*    */   public ItemEditableBook() {
/* 22 */     func_77625_d(1);
/*    */   }
/*    */ 
/*    */   
/*    */   public static boolean func_77828_a(NBTTagCompound p_77828_0_) {
/* 27 */     if (!ItemWritableBook.func_150930_a(p_77828_0_)) {
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     if (!p_77828_0_.func_150297_b("title", 8)) {
/* 32 */       return false;
/*    */     }
/* 34 */     String str = p_77828_0_.func_74779_i("title");
/* 35 */     if (str == null || str.length() > 16) {
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     if (!p_77828_0_.func_150297_b("author", 8)) {
/* 40 */       return false;
/*    */     }
/*    */     
/* 43 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_77653_i(ItemStack p_77653_1_) {
/* 48 */     if (p_77653_1_.func_77942_o()) {
/* 49 */       NBTTagCompound nBTTagCompound = p_77653_1_.func_77978_p();
/*    */       
/* 51 */       String str = nBTTagCompound.func_74779_i("title");
/* 52 */       if (!StringUtils.func_151246_b(str)) {
/* 53 */         return str;
/*    */       }
/*    */     } 
/* 56 */     return super.func_77653_i(p_77653_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_77624_a(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List<String> p_77624_3_, boolean p_77624_4_) {
/* 62 */     if (p_77624_1_.func_77942_o()) {
/* 63 */       NBTTagCompound nBTTagCompound = p_77624_1_.func_77978_p();
/*    */       
/* 65 */       String str = nBTTagCompound.func_74779_i("author");
/* 66 */       if (!StringUtils.func_151246_b(str)) {
/* 67 */         p_77624_3_.add(EnumChatFormatting.GRAY + StatCollector.func_74837_a("book.byAuthor", new Object[] { str }));
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
/* 74 */     p_77659_3_.func_71048_c(p_77659_1_);
/* 75 */     return p_77659_1_;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_77651_p() {
/* 80 */     return true;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public boolean func_77636_d(ItemStack p_77636_1_) {
/* 85 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemEditableBook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */