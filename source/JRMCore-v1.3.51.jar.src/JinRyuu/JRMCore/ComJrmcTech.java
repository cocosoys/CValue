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
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.util.ChatStyle;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import org.apache.commons.lang3.math.NumberUtils;
/*     */ 
/*     */ public class ComJrmcTech
/*     */   extends CommandBase {
/*  21 */   public static final String[] MODES = new String[] { "give", "take" };
/*  22 */   private final String NAME = "jrmctech";
/*     */   
/*  24 */   public String func_71517_b() { return "jrmctech"; } public int func_82362_a() {
/*  25 */     return 2;
/*     */   }
/*     */   public void func_71515_b(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
/*     */     EntityPlayerMP entityplayermp;
/*  29 */     if (par2ArrayOfStr.length < 2) {
/*     */       
/*  31 */       String listdbc = "";
/*  32 */       for (int k = 0; k < JRMCoreH.pmdbc.length; k++) {
/*  33 */         listdbc = listdbc + ", " + JRMCoreH.pmdbc[k][0];
/*     */       }
/*  35 */       String listnc = "";
/*  36 */       for (int m = 0; m < JRMCoreH.pmj.length; m++) {
/*  37 */         listnc = listnc + ", " + JRMCoreH.pmj[m][0];
/*     */       }
/*  39 */       throw new WrongUsageException("jrmctech (give or take) (techName) [playerName]" + (
/*  40 */           JRMCoreH.DBC() ? (" --> techNames for DBC can be: " + listdbc) : "") + (
/*  41 */           JRMCoreH.NC() ? (" --> techNames for NC can be: " + listnc) : ""), new Object[0]);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  47 */     String s = par2ArrayOfStr[0];
/*  48 */     boolean give = s.toLowerCase().contentEquals("give");
/*  49 */     boolean take = s.toLowerCase().contentEquals("take");
/*     */ 
/*     */ 
/*     */     
/*  53 */     int id = -1;
/*  54 */     for (int i = 0; i < JRMCoreH.DBCSkillNames.length; i++) {
/*  55 */       if (par2ArrayOfStr[1].toLowerCase().equals(JRMCoreH.DBCSkillNames[i].toLowerCase())) {
/*     */         
/*  57 */         id = i;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*  62 */     if (par2ArrayOfStr.length > 2) {
/*     */       
/*  64 */       entityplayermp = func_82359_c(par1ICommandSender, par2ArrayOfStr[2]);
/*     */     }
/*     */     else {
/*     */       
/*  68 */       entityplayermp = func_71521_c(par1ICommandSender);
/*     */     } 
/*     */     
/*  71 */     NBTTagCompound nbt = JRMCoreH.nbt((Entity)entityplayermp, "pres");
/*     */     
/*  73 */     EntityPlayerMP entityPlayerMP1 = entityplayermp;
/*  74 */     int pwrtyp = JRMCoreH.getByte((EntityPlayer)entityPlayerMP1, "jrmcPwrtyp");
/*     */     
/*  76 */     String[][] PMA = (String[][])null;
/*  77 */     int b = 0;
/*  78 */     PMA = (pwrtyp == 2) ? JRMCoreH.pmj : JRMCoreH.pmdbc;
/*  79 */     int id1 = -1; int j;
/*  80 */     for (j = 0; j < PMA.length; j++) {
/*  81 */       if (par2ArrayOfStr[1].toLowerCase().equals(PMA[j][0].toLowerCase())) {
/*     */         
/*  83 */         id1 = j;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*  88 */     if (id1 >= 0) {
/*     */       
/*  90 */       if (take) {
/*  91 */         for (j = 4; j < 8; j++) {
/*  92 */           String t = JRMCoreH.getString((EntityPlayer)entityPlayerMP1, JRMCoreH.techNbt[j]);
/*  93 */           if (NumberUtils.isNumber(t) && 
/*  94 */             Integer.parseInt(t) == id1) {
/*  95 */             JRMCoreH.setString(" ", (EntityPlayer)entityPlayerMP1, JRMCoreH.techNbt[j]);
/*     */             
/*  97 */             String skl = PMA[id1][0];
/*  98 */             String t1 = "Skill " + skl + " removed";
/*  99 */             ChatStyle color = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW);
/* 100 */             entityplayermp.func_145747_a((new ChatComponentText(t1)).func_150255_a(color));
/* 101 */             notifyAdmins(par1ICommandSender, "%s's tech %s has been removed!", new Object[] { entityplayermp.func_70005_c_(), skl });
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       }
/* 106 */       if (give) {
/* 107 */         int s2 = id1;
/* 108 */         boolean may = false;
/* 109 */         for (int k = 0; k < 4; k++) {
/* 110 */           String s1 = JRMCoreH.getString((EntityPlayer)entityPlayerMP1, JRMCoreH.techNbt[4 + k]);
/* 111 */           if (NumberUtils.isNumber(s1) || s1.contains(",")) {
/* 112 */             may = false;
/*     */           } else {
/* 114 */             b = (byte)(4 + k); may = true; break;
/*     */           } 
/*     */         } 
/* 117 */         if (may) {
/* 118 */           JRMCoreH.setString("" + s2, (EntityPlayer)entityPlayerMP1, JRMCoreH.techNbt[b]);
/*     */           
/* 120 */           String t = JRMCoreH.trlai("jrmc", "techadded");
/* 121 */           ChatStyle color = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW);
/* 122 */           entityplayermp.func_145747_a((new ChatComponentTranslation(t, new Object[] { PMA[id1][0] })).func_150255_a(color));
/* 123 */           notifyAdmins(par1ICommandSender, "%s has received tech %s", new Object[] { entityplayermp.func_70005_c_(), PMA[id1][0] });
/*     */         } else {
/* 125 */           String t = JRMCoreH.trlai("jrmc", "noslotleft");
/* 126 */           ChatStyle color = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW);
/* 127 */           entityplayermp.func_145747_a((new ChatComponentTranslation(t, new Object[] { PMA[id1][0] })).func_150255_a(color));
/* 128 */           notifyAdmins(par1ICommandSender, "%s has received skill %s", new Object[] { entityplayermp.func_70005_c_(), PMA[id1][0] });
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void notifyAdmins(ICommandSender par1iCommandSender, String string, Object[] objects) {
/* 137 */     func_152373_a(par1iCommandSender, (ICommand)this, string, objects);
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_71518_a(ICommandSender icommandsender) {
/* 142 */     return "/dbcsaga reset (playerName)";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List func_71516_a(ICommandSender commandSender, String[] stringArray) {
/*     */     String[] listOfTechs;
/* 150 */     int id, i, length = stringArray.length;
/* 151 */     switch (length) { case 1:
/* 152 */         return func_71530_a(stringArray, MODES);
/*     */       
/*     */       case 2:
/* 155 */         listOfTechs = new String[JRMCoreH.pmdbc.length + JRMCoreH.pmj.length];
/* 156 */         id = 0;
/*     */ 
/*     */ 
/*     */         
/* 160 */         for (i = 0; i < JRMCoreH.pmdbc.length; i++) {
/*     */           
/* 162 */           listOfTechs[id] = JRMCoreH.pmdbc[i][0];
/* 163 */           id++;
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 169 */         for (i = 0; i < JRMCoreH.pmj.length; i++) {
/*     */           
/* 171 */           listOfTechs[id] = JRMCoreH.pmj[i][0];
/* 172 */           id++;
/*     */         } 
/*     */ 
/*     */         
/* 176 */         return func_71530_a(stringArray, listOfTechs);
/* 177 */       case 3: return func_71530_a(stringArray, getListOfPlayers()); }
/* 178 */      return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected String[] getListOfPlayers() {
/* 184 */     return MinecraftServer.func_71276_C().func_71213_z();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isUsernameIndex(int par1) {
/* 192 */     return (par1 == 2);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\ComJrmcTech.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */