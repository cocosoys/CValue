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
/*    */ public class ComStrain extends CommandBase {
/*    */   public String func_71517_b() {
/* 18 */     return "dbcstrain";
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
/* 31 */     if (par2ArrayOfStr.length < 1)
/*    */     {
/* 33 */       throw new WrongUsageException("/dbcstrain remove (playerName)", new Object[0]);
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 40 */     if (par2ArrayOfStr.length > 1) {
/*    */       
/* 42 */       entityplayermp = func_82359_c(par1ICommandSender, par2ArrayOfStr[1]);
/*    */     }
/*    */     else {
/*    */       
/* 46 */       entityplayermp = func_71521_c(par1ICommandSender);
/*    */     } 
/*    */     
/* 49 */     JRMCoreH.setInt(0, (EntityPlayer)entityplayermp, "jrmcStrain");
/* 50 */     String t = JRMCoreH.trlai("dbc", "StrainRemoved");
/* 51 */     ChatStyle color = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW);
/* 52 */     entityplayermp.func_145747_a((new ChatComponentTranslation(t, new Object[0])).func_150255_a(color));
/* 53 */     notifyAdmins(par1ICommandSender, "%s's strain has been removed.", new Object[] { entityplayermp.func_70005_c_() });
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private void notifyAdmins(ICommandSender par1iCommandSender, String string, Object[] objects) {
/* 59 */     func_152373_a(par1iCommandSender, (ICommand)this, string, objects);
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender icommandsender) {
/* 64 */     return "/dbcstrain remove (playerName)";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public List func_71516_a(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
/* 74 */     return (par2ArrayOfStr.length == 2) ? func_71530_a(par2ArrayOfStr, getListOfPlayers()) : null;
/*    */   }
/*    */ 
/*    */   
/*    */   protected String[] getListOfPlayers() {
/* 79 */     return MinecraftServer.func_71276_C().func_71213_z();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isUsernameIndex(int par1) {
/* 87 */     return (par1 == 0);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Gui\ComStrain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */