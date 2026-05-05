/*    */ package JinRyuu.DragonBC.common.Gui;
/*    */ 
/*    */ import JinRyuu.JRMCore.JRMCoreH;
/*    */ import java.util.List;
/*    */ import net.minecraft.command.CommandBase;
/*    */ import net.minecraft.command.ICommand;
/*    */ import net.minecraft.command.ICommandSender;
/*    */ import net.minecraft.command.WrongUsageException;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.util.ChatComponentTranslation;
/*    */ import net.minecraft.util.ChatStyle;
/*    */ import net.minecraft.util.EnumChatFormatting;
/*    */ 
/*    */ public class ComRevive extends CommandBase {
/*    */   public String func_71517_b() {
/* 18 */     return "dbcrevive";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int func_82362_a() {
/* 26 */     return 2;
/*    */   }
/*    */   
/*    */   public void func_71515_b(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
/*    */     EntityPlayerMP entityplayermp;
/* 31 */     if (par2ArrayOfStr.length < 0)
/*    */     {
/* 33 */       throw new WrongUsageException("/dbcrevive (playerName)", new Object[0]);
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 40 */     if (par2ArrayOfStr.length > 0) {
/*    */       
/* 42 */       entityplayermp = func_82359_c(par1ICommandSender, par2ArrayOfStr[0]);
/*    */     }
/*    */     else {
/*    */       
/* 46 */       entityplayermp = func_71521_c(par1ICommandSender);
/*    */     } 
/* 48 */     JRMCoreH.setInt(0, (EntityPlayer)entityplayermp, "jrmcReviveTmer");
/* 49 */     String t = JRMCoreH.trlai("dbc", "canrevivenow");
/* 50 */     ChatStyle color = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW);
/* 51 */     entityplayermp.func_145747_a((new ChatComponentTranslation(t, new Object[0])).func_150255_a(color));
/* 52 */     notifyAdmins(par1ICommandSender, "%s can revive now.", new Object[] { entityplayermp.func_70005_c_() });
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private void notifyAdmins(ICommandSender par1iCommandSender, String string, Object[] objects) {
/* 58 */     func_152373_a(par1iCommandSender, (ICommand)this, string, objects);
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender icommandsender) {
/* 63 */     return "/dbcrevive (playerName)";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public List func_71516_a(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
/* 73 */     return (par2ArrayOfStr.length == 1) ? func_71530_a(par2ArrayOfStr, getListOfPlayers()) : null;
/*    */   }
/*    */ 
/*    */   
/*    */   protected String[] getListOfPlayers() {
/* 78 */     return MinecraftServer.func_71276_C().func_71213_z();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isUsernameIndex(int par1) {
/* 86 */     return (par1 == 0);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Gui\ComRevive.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */