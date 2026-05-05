/*    */ package JinRyuu.JRMCore;
/*    */ 
/*    */ import cpw.mods.fml.common.FMLCommonHandler;
/*    */ import net.minecraft.command.CommandBase;
/*    */ import net.minecraft.command.ICommand;
/*    */ import net.minecraft.command.ICommandSender;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ 
/*    */ public class ComJrmcpvpcheck extends CommandBase {
/*    */   public String func_71517_b() {
/* 12 */     return "jrmcpvpcheck";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int func_82362_a() {
/* 20 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender par1ICommandSender) {
/* 25 */     return "Usage: '/jrmcpvpcheck' it will tell if PVP is enabled or disabled in the current dimension";
/*    */   }
/*    */   
/*    */   public boolean func_71519_b(ICommandSender par1ICommandSender) {
/* 29 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
/* 34 */     EntityPlayerMP entityplayermp = func_71521_c(par1ICommandSender);
/*    */ 
/*    */     
/* 37 */     int dim = entityplayermp.field_71093_bK;
/*    */     
/* 39 */     MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
/* 40 */     String s = JRMCoreH.rwip(server, dim + "");
/* 41 */     boolean pvp = !s.equalsIgnoreCase("false");
/*    */     
/* 43 */     if (dim == 0) {
/* 44 */       notifyAdmins(par1ICommandSender, "PVP on Planet Earth is %s.", new Object[] { pvp ? "enabled" : "disabled", entityplayermp.func_70005_c_() });
/*    */     
/*    */     }
/*    */     else {
/*    */ 
/*    */       
/* 50 */       notifyAdmins(par1ICommandSender, "PVP in dimension %s is %s.", new Object[] { Integer.valueOf(dim), pvp ? "enabled" : "disabled", entityplayermp.func_70005_c_() });
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   private void notifyAdmins(ICommandSender par1iCommandSender, String string, Object[] objects) {
/* 56 */     func_152373_a(par1iCommandSender, (ICommand)this, string, objects);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\ComJrmcpvpcheck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */