/*    */ package JinRyuu.JRMCore;
/*    */ 
/*    */ import cpw.mods.fml.common.FMLCommonHandler;
/*    */ import net.minecraft.command.CommandBase;
/*    */ import net.minecraft.command.ICommand;
/*    */ import net.minecraft.command.ICommandSender;
/*    */ import net.minecraft.command.WrongUsageException;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ 
/*    */ public class ComJrmcpvp extends CommandBase {
/*    */   public String func_71517_b() {
/* 13 */     return "jrmcpvp";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int func_82362_a() {
/* 21 */     return 2;
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender par1ICommandSender) {
/* 26 */     return "Usage: '/jrmcpvp (true or false)' true will enable pvp, false will disable pvp";
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
/* 31 */     if (par2ArrayOfStr.length <= 0)
/*    */     {
/* 33 */       throw new WrongUsageException("Usage: '/jrmcpvp (true or false)' true will enable pvp, false will disable pvp", new Object[0]);
/*    */     }
/*    */ 
/*    */     
/* 37 */     String s = par2ArrayOfStr[0];
/*    */     
/* 39 */     boolean pvp = Boolean.parseBoolean(s);
/*    */     
/* 41 */     EntityPlayerMP entityplayermp = func_71521_c(par1ICommandSender);
/*    */ 
/*    */     
/* 44 */     int dim = entityplayermp.field_71093_bK;
/*    */     
/* 46 */     MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
/* 47 */     JRMCoreH.wwip(server, s, dim + "", false);
/*    */     
/* 49 */     notifyAdmins(par1ICommandSender, "PVP in dimension %s is %s by %s", new Object[] { Integer.valueOf(dim), pvp ? "enabled" : "disabled", entityplayermp.func_70005_c_() });
/*    */   }
/*    */ 
/*    */   
/*    */   private void notifyAdmins(ICommandSender par1iCommandSender, String string, Object[] objects) {
/* 54 */     func_152373_a(par1iCommandSender, (ICommand)this, string, objects);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\ComJrmcpvp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */