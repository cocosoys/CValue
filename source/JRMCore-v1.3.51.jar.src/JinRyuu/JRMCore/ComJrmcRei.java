/*     */ package JinRyuu.JRMCore;
/*     */ 
/*     */ import java.util.List;
/*     */ import net.minecraft.command.CommandBase;
/*     */ import net.minecraft.command.ICommand;
/*     */ import net.minecraft.command.ICommandSender;
/*     */ import net.minecraft.command.WrongUsageException;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ 
/*     */ public class ComJrmcRei extends CommandBase {
/*  14 */   private final String[] VALUES = new String[] { "1" };
/*     */ 
/*     */   
/*  17 */   private final String[] BOOLEANS = new String[] { "true", "false" };
/*     */ 
/*     */   
/*     */   public String func_71517_b() {
/*  21 */     return "jrmcrei";
/*     */   } public int func_82362_a() {
/*  23 */     return 2;
/*     */   }
/*     */   public void func_71515_b(ICommandSender commandSender, String[] stringArray) {
/*     */     EntityPlayerMP entityplayermp;
/*  27 */     if (stringArray.length < 3)
/*     */     {
/*  29 */       throw new WrongUsageException(func_71518_a(commandSender), new Object[0]);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  36 */     if (stringArray.length > 0) {
/*     */       
/*  38 */       entityplayermp = func_82359_c(commandSender, stringArray[0]);
/*     */     }
/*     */     else {
/*     */       
/*  42 */       entityplayermp = func_71521_c(commandSender);
/*     */     } 
/*     */     
/*  45 */     String entitycommansender = "Console";
/*     */     try {
/*  47 */       EntityPlayerMP commansender = func_71521_c(commandSender);
/*  48 */       entitycommansender = commansender.func_70005_c_();
/*  49 */     } catch (Exception exception) {}
/*     */ 
/*     */ 
/*     */     
/*  53 */     boolean n = entitycommansender.equals("Console") ? JRMCoreConfig.ComSENAC : (entitycommansender.equals(entityplayermp.func_70005_c_()) ? JRMCoreConfig.ComSENAS : JRMCoreConfig.ComSENAO);
/*     */     
/*  55 */     boolean keepSkills = false;
/*  56 */     if (stringArray.length > 2)
/*     */     {
/*  58 */       keepSkills = stringArray[2].toLowerCase().contentEquals("true");
/*     */     }
/*     */     
/*  61 */     boolean keepTechs = false;
/*  62 */     if (stringArray.length > 3)
/*     */     {
/*  64 */       keepTechs = stringArray[3].toLowerCase().contentEquals("true");
/*     */     }
/*     */     
/*  67 */     boolean keepMasteries = false;
/*  68 */     if (stringArray.length > 4)
/*     */     {
/*  70 */       keepMasteries = stringArray[4].toLowerCase().contentEquals("true");
/*     */     }
/*     */     
/*  73 */     float per = 0.1F;
/*  74 */     if (stringArray.length > 1) {
/*     */       
/*  76 */       per = Integer.parseInt(stringArray[1]) * 0.01001F;
/*  77 */       per = (per > 1.0F) ? 1.0F : ((per < 0.0F) ? 0.0F : per);
/*     */     } 
/*     */     
/*  80 */     if (entityplayermp != null) {
/*  81 */       JRMCoreH.setInt(1, (EntityPlayer)entityplayermp, "jrmcRencrnt");
/*  82 */       for (int j = 0; j < 6; j++) {
/*  83 */         int i = (int)(JRMCoreH.getInt((EntityPlayer)entityplayermp, JRMCoreH.AttrbtNbtI[j]) * per);
/*  84 */         JRMCoreH.setInt(i, (EntityPlayer)entityplayermp, JRMCoreH.AttrbtNbtR[j]);
/*     */       } 
/*  86 */       JRMCoreH.resetChar((EntityPlayer)entityplayermp, keepSkills, keepTechs, keepMasteries, per);
/*  87 */       String t = "You have been reincarnated, you kept " + (int)(per * 100.0F) + "%% of attributes and learnable skills " + (keepSkills ? "have been kept" : "has been removed") + ".";
/*  88 */       entityplayermp.func_145747_a((new ChatComponentTranslation(t, new Object[0])).func_150255_a(JRMCoreH2.styl_ylw));
/*  89 */       if (n) notifyAdmins(commandSender, "%s has been reincarnated with %s%% of attributes and learnable skills " + (keepSkills ? "have been kept" : "has been removed") + ".", new Object[] { entityplayermp.func_70005_c_(), Integer.valueOf((int)(per * 100.0F)) }); 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void notifyAdmins(ICommandSender par1iCommandSender, String string, Object[] objects) {
/*  94 */     func_152373_a(par1iCommandSender, (ICommand)this, string, objects);
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_71518_a(ICommandSender icommandsender) {
/*  99 */     return "/jrmcrei (playerName) [keepAttributePercentage] [keepSkillsBoolean] [keepTechsBoolean] [KeepFormMasteriesBoolean]";
/*     */   }
/*     */ 
/*     */   
/*     */   public List func_71516_a(ICommandSender commandSender, String[] stringArray) {
/* 104 */     int length = stringArray.length;
/* 105 */     switch (length) { case 1:
/* 106 */         return func_71530_a(stringArray, getListOfPlayers());
/* 107 */       case 2: return func_71530_a(stringArray, this.VALUES);
/* 108 */       case 3: return func_71530_a(stringArray, this.BOOLEANS);
/* 109 */       case 4: return func_71530_a(stringArray, this.BOOLEANS);
/* 110 */       case 5: return func_71530_a(stringArray, this.BOOLEANS); }
/* 111 */      return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected String[] getListOfPlayers() {
/* 117 */     return MinecraftServer.func_71276_C().func_71213_z();
/*     */   } public boolean isUsernameIndex(int par1) {
/* 119 */     return (par1 == 0);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\ComJrmcRei.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */