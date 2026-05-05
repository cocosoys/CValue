/*    */ package JinRyuu.JRMCore;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.command.CommandBase;
/*    */ import net.minecraft.command.ICommand;
/*    */ import net.minecraft.command.ICommandSender;
/*    */ import net.minecraft.command.WrongUsageException;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ 
/*    */ 
/*    */ public class ComJrmcDebug
/*    */   extends CommandBase
/*    */ {
/*    */   public String func_71517_b() {
/* 16 */     return "jrmcdebug";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int func_82362_a() {
/* 24 */     return 2;
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender par1ICommandSender) {
/* 29 */     return "This command is for development and testing purposes only, Don't use it.";
/*    */   }
/*    */   
/*    */   public void func_71515_b(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
/*    */     EntityPlayerMP entityplayermp;
/* 34 */     if (par2ArrayOfStr.length <= 0)
/*    */     {
/* 36 */       throw new WrongUsageException(func_71518_a(par1ICommandSender), new Object[0]);
/*    */     }
/*    */ 
/*    */     
/* 40 */     String s = par2ArrayOfStr[0];
/*    */     
/* 42 */     boolean i = Boolean.parseBoolean(s);
/*    */ 
/*    */ 
/*    */     
/* 46 */     if (par2ArrayOfStr.length > 1) {
/*    */       
/* 48 */       entityplayermp = func_82359_c(par1ICommandSender, par2ArrayOfStr[1]);
/*    */     }
/*    */     else {
/*    */       
/* 52 */       entityplayermp = func_71521_c(par1ICommandSender);
/*    */     } 
/*    */     
/* 55 */     JRMCoreH.difp = i ? entityplayermp.func_70005_c_() : "";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void notifyAdmins(ICommandSender par1iCommandSender, String string, Object[] objects) {
/* 62 */     func_152373_a(par1iCommandSender, (ICommand)this, string, objects);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public List func_71516_a(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
/* 71 */     return (par2ArrayOfStr.length == 2) ? func_71530_a(par2ArrayOfStr, getListOfPlayers()) : null;
/*    */   }
/*    */ 
/*    */   
/*    */   protected String[] getListOfPlayers() {
/* 76 */     return MinecraftServer.func_71276_C().func_71213_z();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isUsernameIndex(int par1) {
/* 84 */     return (par1 == 0);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\ComJrmcDebug.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */