/*    */ package net.minecraft.command;
/*    */ 
/*    */ public class CommandException extends RuntimeException {
/*    */   private Object[] field_74845_a;
/*    */   
/*    */   public CommandException(String p_i1359_1_, Object... p_i1359_2_) {
/*  7 */     super(p_i1359_1_);
/*    */     
/*  9 */     this.field_74845_a = p_i1359_2_;
/*    */   }
/*    */   private static final String __OBFID = "CL_00001187";
/*    */   public Object[] func_74844_a() {
/* 13 */     return this.field_74845_a;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\CommandException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */