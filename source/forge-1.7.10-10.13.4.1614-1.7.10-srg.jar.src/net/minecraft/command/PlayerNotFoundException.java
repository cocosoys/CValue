/*   */ package net.minecraft.command;
/*   */ 
/*   */ public class PlayerNotFoundException extends CommandException {
/*   */   public PlayerNotFoundException() {
/* 5 */     this("commands.generic.player.notFound", new Object[0]);
/*   */   }
/*   */   private static final String __OBFID = "CL_00001190";
/*   */   public PlayerNotFoundException(String p_i1362_1_, Object... p_i1362_2_) {
/* 9 */     super(p_i1362_1_, p_i1362_2_);
/*   */   }
/*   */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\PlayerNotFoundException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */