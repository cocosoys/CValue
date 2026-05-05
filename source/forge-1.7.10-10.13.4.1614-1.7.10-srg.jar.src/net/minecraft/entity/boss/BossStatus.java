/*    */ package net.minecraft.entity.boss;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public final class BossStatus
/*    */ {
/*    */   public static float field_82828_a;
/*    */   public static int field_82826_b;
/*    */   
/*    */   public static void func_82824_a(IBossDisplayData p_82824_0_, boolean p_82824_1_) {
/* 14 */     field_82828_a = p_82824_0_.func_110143_aJ() / p_82824_0_.func_110138_aP();
/* 15 */     field_82826_b = 100;
/* 16 */     field_82827_c = p_82824_0_.func_145748_c_().func_150254_d();
/* 17 */     field_82825_d = p_82824_1_;
/*    */   }
/*    */   
/*    */   public static String field_82827_c;
/*    */   public static boolean field_82825_d;
/*    */   private static final String __OBFID = "CL_00000941";
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\boss\BossStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */