/*   */ package net.minecraft.command;
/*   */ 
/*   */ public class NumberInvalidException extends CommandException {
/*   */   public NumberInvalidException() {
/* 5 */     this("commands.generic.num.invalid", new Object[0]);
/*   */   }
/*   */   private static final String __OBFID = "CL_00001188";
/*   */   public NumberInvalidException(String p_i1360_1_, Object... p_i1360_2_) {
/* 9 */     super(p_i1360_1_, p_i1360_2_);
/*   */   }
/*   */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\NumberInvalidException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */