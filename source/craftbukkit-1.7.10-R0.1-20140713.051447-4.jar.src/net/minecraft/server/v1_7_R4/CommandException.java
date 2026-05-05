/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ public class CommandException extends RuntimeException {
/*    */   private Object[] a;
/*    */   
/*    */   public CommandException(String paramString, Object... paramVarArgs) {
/*  7 */     super(paramString);
/*    */     
/*  9 */     this.a = paramVarArgs;
/*    */   }
/*    */   
/*    */   public Object[] getArgs() {
/* 13 */     return this.a;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\CommandException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */