/*     */ package JinRyuu.JRMCore;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import net.minecraft.command.CommandBase;
/*     */ import net.minecraft.command.ICommand;
/*     */ import net.minecraft.command.ICommandSender;
/*     */ import net.minecraft.command.WrongUsageException;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ 
/*     */ public class ComJrmcHeal extends CommandBase {
/*     */   public String func_71517_b() {
/*  17 */     return "jrmcheal";
/*     */   }
/*  19 */   public static HashMap<String, Object[]> SList = (HashMap)new HashMap<String, Object>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_82362_a() {
/*  26 */     return 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_71518_a(ICommandSender par1ICommandSender) {
/*  31 */     return "Usage: '/jrmcheal (energy, body, stamina, food, all) [amount] [playerName]'";
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71515_b(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
/*     */     EntityPlayerMP entityplayermp;
/*  37 */     if (par2ArrayOfStr.length <= 0)
/*     */     {
/*  39 */       throw new WrongUsageException(
/*  40 */           func_71518_a(par1ICommandSender), new Object[0]);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  45 */     String entitycommansender = "Console";
/*     */     try {
/*  47 */       EntityPlayerMP commansender = func_71521_c(par1ICommandSender);
/*  48 */       entitycommansender = commansender.func_70005_c_();
/*  49 */     } catch (Exception exception) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  55 */     boolean energy = (par2ArrayOfStr.length > 0 && par2ArrayOfStr[0].equalsIgnoreCase("energy"));
/*  56 */     boolean body = (par2ArrayOfStr.length > 0 && par2ArrayOfStr[0].equalsIgnoreCase("body"));
/*  57 */     boolean stamina = (par2ArrayOfStr.length > 0 && par2ArrayOfStr[0].equalsIgnoreCase("stamina"));
/*  58 */     boolean food = (par2ArrayOfStr.length > 0 && par2ArrayOfStr[0].equalsIgnoreCase("food"));
/*  59 */     boolean all = (par2ArrayOfStr.length > 0 && par2ArrayOfStr[0].equalsIgnoreCase("all"));
/*  60 */     int amount = 0;
/*  61 */     if (par2ArrayOfStr.length > 2) {
/*  62 */       entityplayermp = func_82359_c(par1ICommandSender, par2ArrayOfStr[2]);
/*     */     } else {
/*  64 */       entityplayermp = func_71521_c(par1ICommandSender);
/*     */     } 
/*  66 */     if (par2ArrayOfStr.length > 1) {
/*  67 */       amount = Integer.parseInt(par2ArrayOfStr[1]);
/*     */     }
/*     */     
/*  70 */     NBTTagCompound nbt = JRMCoreH.nbt((Entity)entityplayermp, "pres");
/*     */ 
/*     */ 
/*     */     
/*  74 */     if (body || all || stamina || food || energy) {
/*  75 */       int[] PlyrAttrbts = JRMCoreH.PlyrAttrbts((EntityPlayer)entityplayermp);
/*  76 */       byte pwr = JRMCoreH.getByte((EntityPlayer)entityplayermp, "jrmcPwrtyp");
/*  77 */       byte rce = JRMCoreH.getByte((EntityPlayer)entityplayermp, "jrmcRace");
/*  78 */       byte cls = JRMCoreH.getByte((EntityPlayer)entityplayermp, "jrmcClass");
/*  79 */       int maxBody = JRMCoreH.stat((Entity)entityplayermp, 2, pwr, 2, PlyrAttrbts[2], rce, cls, 0.0F);
/*  80 */       int curBody = JRMCoreH.getInt((EntityPlayer)entityplayermp, "jrmcBdy");
/*  81 */       int maxEnergy = JRMCoreH.stat((Entity)entityplayermp, 5, pwr, 5, PlyrAttrbts[5], rce, cls, JRMCoreH.SklLvl_KiBs((EntityPlayer)entityplayermp, pwr));
/*  82 */       int curEnergy = JRMCoreH.getInt((EntityPlayer)entityplayermp, "jrmcEnrgy");
/*  83 */       int maxStam = JRMCoreH.stat((Entity)entityplayermp, 2, pwr, 3, PlyrAttrbts[2], rce, cls, 0.0F);
/*  84 */       int curStam = JRMCoreH.getInt((EntityPlayer)entityplayermp, "jrmcStamina");
/*     */       
/*  86 */       if (body || all) JRMCoreH.setInt((amount == 0) ? maxBody : ((curBody + amount > maxBody) ? maxBody : (curBody + amount)), (EntityPlayer)entityplayermp, "jrmcBdy"); 
/*  87 */       if (energy || all) JRMCoreH.setInt((amount == 0) ? maxEnergy : ((curEnergy + amount > maxEnergy) ? maxEnergy : (curEnergy + amount)), (EntityPlayer)entityplayermp, "jrmcEnrgy"); 
/*  88 */       if (stamina || all) JRMCoreH.setInt((amount == 0) ? maxStam : ((curStam + amount > maxStam) ? maxStam : (curStam + amount)), (EntityPlayer)entityplayermp, "jrmcStamina");
/*     */       
/*  90 */       if (body || all) entityplayermp.func_70606_j(entityplayermp.func_110138_aP());
/*     */       
/*  92 */       if (food || all) entityplayermp.func_71024_bL().func_75122_a(20, 0.9F);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  97 */       boolean n = entitycommansender.equals("Console") ? JRMCoreConfig.ComHealNAC : (entitycommansender.equals(entityplayermp.func_70005_c_()) ? JRMCoreConfig.ComHealNAS : JRMCoreConfig.ComHealNAO);
/*  98 */       if (n)
/*  99 */         notifyAdmins(par1ICommandSender, "%s was healed %s %s by %s", new Object[] { entityplayermp.func_70005_c_(), (amount == 0) ? "max" : Integer.valueOf(amount), par2ArrayOfStr[0], entitycommansender }); 
/*     */     } else {
/* 101 */       throw new WrongUsageException("%s failed to use jrmcheal stat!", new Object[] { entitycommansender, par2ArrayOfStr[0] });
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void notifyAdmins(ICommandSender par1iCommandSender, String string, Object[] objects) {
/* 107 */     func_152373_a(par1iCommandSender, (ICommand)this, string, objects);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List func_71516_a(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
/* 116 */     return (par2ArrayOfStr.length == 2) ? func_71530_a(par2ArrayOfStr, getListOfPlayers()) : null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String[] getListOfPlayers() {
/* 121 */     return MinecraftServer.func_71276_C().func_71213_z();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isUsernameIndex(int par1) {
/* 129 */     return (par1 == 0);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\ComJrmcHeal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */