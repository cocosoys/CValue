/*     */ package JinRyuu.JYearsC;
/*     */ 
/*     */ import java.util.List;
/*     */ import net.minecraft.command.CommandBase;
/*     */ import net.minecraft.command.ICommand;
/*     */ import net.minecraft.command.ICommandSender;
/*     */ import net.minecraft.command.WrongUsageException;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ 
/*     */ public class ComJycage
/*     */   extends CommandBase {
/*     */   public String func_71517_b() {
/*  16 */     return "jycage";
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_71518_a(ICommandSender icommandsender) {
/*  21 */     return "/jycage (daysLived) [playerName] OR /jycage (addYears)Y [playerName]";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_82362_a() {
/*  29 */     return 2;
/*     */   }
/*     */   public void func_71515_b(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
/*     */     EntityPlayerMP entityplayermp;
/*     */     NBTTagCompound nbt;
/*  34 */     if (par2ArrayOfStr.length <= 0)
/*     */     {
/*  36 */       throw new WrongUsageException("/jycage (daysLived) [playerName] OR /jycage (addYears)Y [playerName]", new Object[0]);
/*     */     }
/*     */ 
/*     */     
/*  40 */     String s = par2ArrayOfStr[0];
/*  41 */     boolean flag = (s.endsWith("y") || s.endsWith("Y"));
/*     */     
/*  43 */     if (flag && s.length() > 1)
/*     */     {
/*  45 */       s = s.substring(0, s.length() - 1);
/*     */     }
/*     */     
/*  48 */     int i = func_71526_a(par1ICommandSender, s);
/*  49 */     boolean flag1 = (i < 0);
/*     */     
/*  51 */     if (flag1)
/*     */     {
/*  53 */       i *= -1;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  58 */     if (par2ArrayOfStr.length > 1) {
/*     */       
/*  60 */       entityplayermp = func_82359_c(par1ICommandSender, par2ArrayOfStr[1]);
/*     */     }
/*     */     else {
/*     */       
/*  64 */       entityplayermp = func_71521_c(par1ICommandSender);
/*     */     } 
/*     */ 
/*     */     
/*  68 */     if (!entityplayermp.getEntityData().func_74764_b("PlayerPersisted")) {
/*  69 */       nbt = new NBTTagCompound();
/*  70 */       entityplayermp.getEntityData().func_74782_a("PlayerPersisted", (NBTBase)nbt);
/*     */     } else {
/*  72 */       nbt = entityplayermp.getEntityData().func_74775_l("PlayerPersisted");
/*     */     } 
/*     */     
/*  75 */     if (flag) {
/*     */       
/*  77 */       if (flag1)
/*     */       {
/*     */         
/*  80 */         nbt.func_74776_a("JRYCAge", nbt.func_74760_g("JRYCAge") - (i * 46));
/*  81 */         notifyAdmins(par1ICommandSender, "Age (Year) Subtracted success", new Object[] { Integer.valueOf(i), entityplayermp.getDisplayName() });
/*     */       }
/*     */       else
/*     */       {
/*  85 */         nbt.func_74776_a("JRYCAge", nbt.func_74760_g("JRYCAge") + (i * 46));
/*  86 */         notifyAdmins(par1ICommandSender, "Age (Year) Added success", new Object[] { Integer.valueOf(i), entityplayermp.getDisplayName() });
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/*  91 */       if (flag1)
/*     */       {
/*  93 */         throw new WrongUsageException("Age Setting failure", new Object[0]);
/*     */       }
/*     */       
/*  96 */       nbt.func_74776_a("JRYCAge", i);
/*  97 */       notifyAdmins(par1ICommandSender, "Age (Days) Set success", new Object[] { Integer.valueOf(i), entityplayermp.getDisplayName() });
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void notifyAdmins(ICommandSender par1iCommandSender, String string, Object[] objects) {
/* 103 */     func_152373_a(par1iCommandSender, (ICommand)this, string, objects);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List func_71516_a(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
/* 112 */     return (par2ArrayOfStr.length == 2) ? func_71530_a(par2ArrayOfStr, getListOfPlayers()) : null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String[] getListOfPlayers() {
/* 117 */     return MinecraftServer.func_71276_C().func_71213_z();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isUsernameIndex(int par1) {
/* 125 */     return (par1 == 0);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JYearsC-v1.2.5.jar!\JinRyuu\JYearsC\ComJycage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */