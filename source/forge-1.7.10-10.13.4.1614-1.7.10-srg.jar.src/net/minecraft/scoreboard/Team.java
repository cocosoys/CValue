/*    */ package net.minecraft.scoreboard;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ 
/*    */ public abstract class Team {
/*    */   public boolean func_142054_a(Team p_142054_1_) {
/*  8 */     if (p_142054_1_ == null) {
/*  9 */       return false;
/*    */     }
/* 11 */     if (this == p_142054_1_) {
/* 12 */       return true;
/*    */     }
/* 14 */     return false;
/*    */   }
/*    */   
/*    */   private static final String __OBFID = "CL_00000621";
/*    */   
/*    */   public abstract String func_96661_b();
/*    */   
/*    */   public abstract String func_142053_d(String paramString);
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public abstract boolean func_98297_h();
/*    */   
/*    */   public abstract boolean func_96665_g();
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\scoreboard\Team.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */