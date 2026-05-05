/*    */ package net.minecraft.client.resources;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class I18n {
/*    */   private static Locale field_135054_a;
/*    */   
/*    */   static void func_135051_a(Locale p_135051_0_) {
/* 11 */     field_135054_a = p_135051_0_;
/*    */   }
/*    */   private static final String __OBFID = "CL_00001094";
/*    */   public static String func_135052_a(String p_135052_0_, Object... p_135052_1_) {
/* 15 */     return field_135054_a.func_135023_a(p_135052_0_, p_135052_1_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\resources\I18n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */