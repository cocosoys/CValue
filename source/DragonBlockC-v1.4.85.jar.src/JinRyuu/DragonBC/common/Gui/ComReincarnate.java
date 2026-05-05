/*    */ package JinRyuu.DragonBC.common.Gui;
/*    */ import JinRyuu.JRMCore.JRMCoreH;
/*    */ import JinRyuu.JRMCore.JRMCoreHDBC;
/*    */ import java.util.List;
/*    */ import net.minecraft.command.CommandBase;
/*    */ import net.minecraft.command.ICommand;
/*    */ import net.minecraft.command.ICommandSender;
/*    */ import net.minecraft.command.WrongUsageException;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.util.ChatComponentTranslation;
/*    */ import net.minecraft.util.ChatStyle;
/*    */ import net.minecraft.util.EnumChatFormatting;
/*    */ 
/*    */ public class ComReincarnate extends CommandBase {
/*    */   public String func_71517_b() {
/* 19 */     return "dbcreincarnate";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int func_82362_a() {
/* 27 */     return 2;
/*    */   }
/*    */   
/*    */   public void func_71515_b(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
/*    */     EntityPlayerMP p;
/* 32 */     if (par2ArrayOfStr.length < 0)
/*    */     {
/* 34 */       throw new WrongUsageException("/dbcreincarnate [playerName]", new Object[0]);
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 40 */     if (par2ArrayOfStr.length > 0) {
/*    */       
/* 42 */       p = func_82359_c(par1ICommandSender, par2ArrayOfStr[0]);
/*    */     }
/*    */     else {
/*    */       
/* 46 */       p = func_71521_c(par1ICommandSender);
/*    */     } 
/*    */ 
/*    */     
/* 50 */     if (!JRMCoreH.isFused((Entity)p)) {
/* 51 */       JRMCoreHDBC.reincarnate((EntityPlayer)p);
/*    */       
/* 53 */       String t = JRMCoreH.trlai("dbc", "reincarnated");
/* 54 */       ChatStyle color = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW);
/* 55 */       p.func_145747_a((new ChatComponentTranslation(t, new Object[0])).func_150255_a(color));
/* 56 */       notifyAdmins(par1ICommandSender, "%s reincarnated!", new Object[] { p.func_70005_c_() });
/*    */     } else {
/*    */       
/* 59 */       notifyAdmins(par1ICommandSender, "Unable to reincarnate while fused.", new Object[] { p.func_70005_c_() });
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   private void notifyAdmins(ICommandSender par1iCommandSender, String string, Object[] objects) {
/* 65 */     func_152373_a(par1iCommandSender, (ICommand)this, string, objects);
/*    */   }
/*    */   
/*    */   public String func_71518_a(ICommandSender icommandsender) {
/* 69 */     return "/dbcreincarnate (playerName)";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public List func_71516_a(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
/* 79 */     return (par2ArrayOfStr.length == 1) ? func_71530_a(par2ArrayOfStr, getListOfPlayers()) : null;
/*    */   }
/*    */ 
/*    */   
/*    */   protected String[] getListOfPlayers() {
/* 84 */     return MinecraftServer.func_71276_C().func_71213_z();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isUsernameIndex(int par1) {
/* 92 */     return (par1 == 0);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Gui\ComReincarnate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */