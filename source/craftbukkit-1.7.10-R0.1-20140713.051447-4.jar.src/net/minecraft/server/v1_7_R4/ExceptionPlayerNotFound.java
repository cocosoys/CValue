/*   */ package net.minecraft.server.v1_7_R4;
/*   */ 
/*   */ public class ExceptionPlayerNotFound extends CommandException {
/*   */   public ExceptionPlayerNotFound() {
/* 5 */     this("commands.generic.player.notFound", new Object[0]);
/*   */   }
/*   */   
/*   */   public ExceptionPlayerNotFound(String paramString, Object... paramVarArgs) {
/* 9 */     super(paramString, paramVarArgs);
/*   */   }
/*   */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\ExceptionPlayerNotFound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */