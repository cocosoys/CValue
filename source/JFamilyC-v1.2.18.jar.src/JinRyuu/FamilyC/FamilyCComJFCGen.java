/*     */ package JinRyuu.FamilyC;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import java.util.List;
/*     */ import net.minecraft.command.CommandBase;
/*     */ import net.minecraft.command.ICommand;
/*     */ import net.minecraft.command.ICommandSender;
/*     */ import net.minecraft.command.WrongUsageException;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ 
/*     */ public class FamilyCComJFCGen extends CommandBase {
/*     */   public String func_71517_b() {
/*  16 */     return "jfcgender";
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
/*     */   public void func_71515_b(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
/*     */     EntityPlayerMP entityplayermp;
/*  29 */     if (par2ArrayOfStr.length <= 0)
/*     */     {
/*  31 */       throw new WrongUsageException("/jfcgender (male or female) [playerName] OR /jfcgender switch [playerName]", new Object[0]);
/*     */     }
/*     */ 
/*     */     
/*  35 */     String s = par2ArrayOfStr[0];
/*  36 */     boolean flag = (s.contentEquals("male") || s.contentEquals("Male") || s.contentEquals("MALE"));
/*  37 */     boolean girl = (s.contains("female") || s.contains("Female") || s.contains("FEMALE"));
/*  38 */     boolean swit = (s.contains("switch") || s.contains("Switch") || s.contains("SWITCH"));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  55 */     if (par2ArrayOfStr.length > 1) {
/*     */       
/*  57 */       entityplayermp = func_82359_c(par1ICommandSender, par2ArrayOfStr[1]);
/*     */     }
/*     */     else {
/*     */       
/*  61 */       entityplayermp = func_71521_c(par1ICommandSender);
/*     */     } 
/*     */ 
/*     */     
/*  65 */     if (!entityplayermp.getEntityData().func_74764_b("PlayerPersisted")) {
/*  66 */       NBTTagCompound nbt = new NBTTagCompound();
/*  67 */       entityplayermp.getEntityData().func_74782_a("PlayerPersisted", (NBTBase)nbt);
/*     */     } else {
/*  69 */       NBTTagCompound nbt = entityplayermp.getEntityData().func_74775_l("PlayerPersisted");
/*     */     } 
/*  71 */     String dns = JRMCoreH.getString((EntityPlayer)entityplayermp, "jrmcDNS");
/*  72 */     if (flag) {
/*     */       
/*  74 */       JRMCoreH.setString(JRMCoreH.dnsGenderSet(dns, "0"), (EntityPlayer)entityplayermp, "jrmcDNS");
/*     */       
/*  76 */       notifyAdmins(par1ICommandSender, "Gender Change to " + ((s.contains("male") || s.contains("Male") || s.contains("MALE")) ? "Male" : "Man") + " success.", new Object[] { (s.contains("male") || s.contains("Male") || s.contains("MALE")) ? "Male" : "Man", entityplayermp.func_70005_c_() });
/*     */     }
/*  78 */     else if (girl) {
/*  79 */       JRMCoreH.setString(JRMCoreH.dnsGenderSet(dns, "1"), (EntityPlayer)entityplayermp, "jrmcDNS");
/*     */       
/*  81 */       notifyAdmins(par1ICommandSender, "Gender Change to " + ((s.contains("female") || s.contains("Female") || s.contains("FEMALE")) ? "Female" : "Girl") + " success.", new Object[] { (s.contains("female") || s.contains("Female") || s.contains("FEMALE")) ? "Female" : "Woman", entityplayermp.func_70005_c_() });
/*     */     
/*     */     }
/*  84 */     else if (swit) {
/*  85 */       String s2 = "";
/*  86 */       if (JRMCoreH.dnsGender(dns) == 0) { s2 = "Female"; JRMCoreH.setString(JRMCoreH.dnsGenderSet(dns, "1"), (EntityPlayer)entityplayermp, "jrmcDNS"); }
/*  87 */       else if (JRMCoreH.dnsGender(dns) == 1) { s2 = "Male"; JRMCoreH.setString(JRMCoreH.dnsGenderSet(dns, "0"), (EntityPlayer)entityplayermp, "jrmcDNS"); }
/*  88 */        notifyAdmins(par1ICommandSender, "Gender Change to " + s2 + " was successful.", new Object[] { s2, entityplayermp.func_70005_c_() });
/*     */     
/*     */     }
/*     */     else {
/*     */       
/*  93 */       throw new WrongUsageException("Gender Change failed.", new Object[0]);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void notifyAdmins(ICommandSender par1iCommandSender, String string, Object[] objects) {
/*  99 */     func_152373_a(par1iCommandSender, (ICommand)this, string, objects);
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_71518_a(ICommandSender icommandsender) {
/* 104 */     return "/jfcgender (male or female) [playerName] OR /jfcgender switch [playerName]";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List func_71516_a(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
/* 114 */     return (par2ArrayOfStr.length == 2) ? func_71530_a(par2ArrayOfStr, getListOfPlayers()) : null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String[] getListOfPlayers() {
/* 119 */     return MinecraftServer.func_71276_C().func_71213_z();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isUsernameIndex(int par1) {
/* 127 */     return (par1 == 0);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JFamilyC-v1.2.18.jar!\JinRyuu\FamilyC\FamilyCComJFCGen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */