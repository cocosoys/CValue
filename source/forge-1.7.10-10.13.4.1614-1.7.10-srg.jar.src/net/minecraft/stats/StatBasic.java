/*    */ package net.minecraft.stats;
/*    */ 
/*    */ import net.minecraft.util.IChatComponent;
/*    */ 
/*    */ public class StatBasic
/*    */   extends StatBase {
/*    */   public StatBasic(String p_i45303_1_, IChatComponent p_i45303_2_, IStatType p_i45303_3_) {
/*  8 */     super(p_i45303_1_, p_i45303_2_, p_i45303_3_);
/*    */   }
/*    */   private static final String __OBFID = "CL_00001469";
/*    */   public StatBasic(String p_i45304_1_, IChatComponent p_i45304_2_) {
/* 12 */     super(p_i45304_1_, p_i45304_2_);
/*    */   }
/*    */ 
/*    */   
/*    */   public StatBase func_75971_g() {
/* 17 */     super.func_75971_g();
/*    */     
/* 19 */     StatList.field_75941_c.add(this);
/*    */     
/* 21 */     return this;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\stats\StatBasic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */