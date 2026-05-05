/*   */ package net.minecraft.server.v1_7_R4;
/*   */ 
/*   */ public class ExceptionInvalidNumber extends CommandException {
/*   */   public ExceptionInvalidNumber() {
/* 5 */     this("commands.generic.num.invalid", new Object[0]);
/*   */   }
/*   */   
/*   */   public ExceptionInvalidNumber(String paramString, Object... paramVarArgs) {
/* 9 */     super(paramString, paramVarArgs);
/*   */   }
/*   */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\ExceptionInvalidNumber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */