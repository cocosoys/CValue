/*     */ package JinRyuu.JRMCore;
/*     */ 
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
/*     */ public class ComJrmctexp extends CommandBase {
/*     */   public String func_71517_b() {
/*  16 */     return "jrmctexp";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_82362_a() {
/*  24 */     return 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_71518_a(ICommandSender par1ICommandSender) {
/*  29 */     return "Usage: '/jrmctexp (slot) (amount) [playerName]'. 'slot' can go from 1-4, 'amount' is max 100 000";
/*     */   }
/*     */   
/*     */   public void func_71515_b(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
/*     */     EntityPlayerMP entityplayermp;
/*  34 */     if (par2ArrayOfStr.length <= 0)
/*     */     {
/*  36 */       throw new WrongUsageException(func_71518_a(par1ICommandSender), new Object[0]);
/*     */     }
/*     */ 
/*     */     
/*  40 */     String s0 = par2ArrayOfStr[0];
/*  41 */     String s1 = par2ArrayOfStr[1];
/*     */     
/*  43 */     int sl = Integer.parseInt(s0);
/*  44 */     int sa = Integer.parseInt(s1);
/*  45 */     if (sl > 4) sl = 4; 
/*  46 */     if (sl < 1) sl = 1; 
/*  47 */     sl--;
/*  48 */     if (sa > 100000) sa = 100000; 
/*  49 */     if (sa < 0) sa = 0;
/*     */ 
/*     */ 
/*     */     
/*  53 */     if (par2ArrayOfStr.length > 2) {
/*     */       
/*  55 */       entityplayermp = func_82359_c(par1ICommandSender, par2ArrayOfStr[2]);
/*     */     }
/*     */     else {
/*     */       
/*  59 */       entityplayermp = func_71521_c(par1ICommandSender);
/*     */     } 
/*     */     
/*  62 */     String entitycommansender = "Console";
/*     */     try {
/*  64 */       EntityPlayerMP commansender = func_71521_c(par1ICommandSender);
/*  65 */       entitycommansender = commansender.func_70005_c_();
/*  66 */     } catch (Exception exception) {}
/*     */ 
/*     */ 
/*     */     
/*  70 */     boolean n = entitycommansender.equals("Console") ? JRMCoreConfig.ComTPNAC : (entitycommansender.equals(entityplayermp.func_70005_c_()) ? JRMCoreConfig.ComTPNAS : JRMCoreConfig.ComTPNAO);
/*     */ 
/*     */     
/*  73 */     NBTTagCompound nbt = JRMCoreH.nbt((Entity)entityplayermp, "pres");
/*  74 */     boolean fl = false;
/*  75 */     if (nbt.func_74771_c("jrmcPwrtyp") == 1) {
/*  76 */       String s2 = JRMCoreH.getString((EntityPlayer)entityplayermp, JRMCoreH.techNbt[sl]);
/*  77 */       if (s2 != null && s2.length() > 3) {
/*  78 */         JRMCoreH.setString(JRMCoreH.tech_expgiv(s2, sa), (EntityPlayer)entityplayermp, JRMCoreH.techNbt[sl]);
/*  79 */         if (n)
/*  80 */           notifyAdmins(par1ICommandSender, "Tech Exp Giving %s success for %s", new Object[] { Integer.valueOf(sa), entityplayermp.func_70005_c_() }); 
/*     */       } else {
/*  82 */         fl = true;
/*     */       } 
/*     */     } else {
/*  85 */       fl = true;
/*     */     } 
/*     */     
/*  88 */     if (fl && n) {
/*  89 */       notifyAdmins(par1ICommandSender, "Tech Exp Giving failed for %s", new Object[] { entityplayermp.func_70005_c_() });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void notifyAdmins(ICommandSender par1iCommandSender, String string, Object[] objects) {
/*  95 */     func_152373_a(par1iCommandSender, (ICommand)this, string, objects);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List func_71516_a(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
/* 104 */     return (par2ArrayOfStr.length == 2) ? func_71530_a(par2ArrayOfStr, getListOfPlayers()) : null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String[] getListOfPlayers() {
/* 109 */     return MinecraftServer.func_71276_C().func_71213_z();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isUsernameIndex(int par1) {
/* 117 */     return (par1 == 0);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\ComJrmctexp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */