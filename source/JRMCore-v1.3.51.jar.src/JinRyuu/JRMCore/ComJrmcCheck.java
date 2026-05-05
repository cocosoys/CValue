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
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.ChatStyle;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ 
/*     */ public class ComJrmcCheck
/*     */   extends CommandBase {
/*     */   public String func_71517_b() {
/*  21 */     return "jrmccheck";
/*     */   }
/*     */   
/*  24 */   public static HashMap<String, Object[]> SList = (HashMap)new HashMap<String, Object>();
/*     */ 
/*     */   
/*     */   public int func_82362_a() {
/*  28 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_71518_a(ICommandSender par1ICommandSender) {
/*  33 */     return "Usage: '/jrmccheck sheet [playerName]' to view players character sheet.";
/*     */   }
/*     */   
/*     */   public boolean func_71519_b(ICommandSender par1ICommandSender) {
/*  37 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_71515_b(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
/*  43 */     if (par2ArrayOfStr.length <= 0) {
/*  44 */       throw new WrongUsageException(func_71518_a(par1ICommandSender), new Object[0]);
/*     */     }
/*     */ 
/*     */     
/*  48 */     String entitycommansenderName = "Console";
/*     */     
/*     */     try {
/*  51 */       EntityPlayerMP commansender = func_71521_c(par1ICommandSender);
/*  52 */       entitycommansenderName = commansender.func_70005_c_();
/*  53 */     } catch (Exception exception) {}
/*     */     
/*  55 */     if (entitycommansenderName.equals("Console")) {
/*  56 */       mod_JRMCore.logger.info("This command can't be run from Console");
/*     */       
/*     */       return;
/*     */     } 
/*  60 */     EntityPlayerMP entitycommansender = func_71521_c(par1ICommandSender);
/*  61 */     EntityPlayerMP entityplayermp = entitycommansender;
/*     */     
/*  63 */     boolean sheet = false;
/*  64 */     if (par2ArrayOfStr.length > 0 && par2ArrayOfStr[0].equalsIgnoreCase("sheet")) {
/*  65 */       sheet = true;
/*     */     }
/*  67 */     if (par2ArrayOfStr.length > 1) {
/*     */       
/*  69 */       if (!JRMCoreConfig.JRMCCheckOnOthersWithoutOP && entityplayermp != null && !entitycommansenderName.equals("Console"))
/*     */       {
/*  71 */         if (!par2ArrayOfStr[1].equals(entitycommansenderName)) {
/*     */           
/*  73 */           sheet = false;
/*  74 */           ChatStyle chatStyle = (new ChatStyle()).func_150238_a(EnumChatFormatting.RED);
/*  75 */           entityplayermp.func_145747_a((new ChatComponentText("JRMCCheck - Non OP Players can check other Player's Sheet is DISABLED!")).func_150255_a(chatStyle));
/*     */         } 
/*     */       }
/*     */       
/*  79 */       entityplayermp = func_82359_c(par1ICommandSender, par2ArrayOfStr[1]);
/*     */     } 
/*     */     
/*  82 */     NBTTagCompound nbt = JRMCoreH.nbt((Entity)entityplayermp, "pres");
/*  83 */     ChatStyle color = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW);
/*  84 */     ChatStyle colorG = (new ChatStyle()).func_150238_a(EnumChatFormatting.GOLD);
/*     */ 
/*     */ 
/*     */     
/*  88 */     if (sheet) {
/*     */       
/*  90 */       int[] PlyrAttrbts = JRMCoreH.PlyrAttrbts((EntityPlayer)entityplayermp);
/*  91 */       byte rc = nbt.func_74771_c("jrmcRace");
/*  92 */       byte pwr = nbt.func_74771_c("jrmcPwrtyp");
/*  93 */       byte Cls = nbt.func_74771_c("jrmcClass");
/*  94 */       byte rls = JRMCoreH.getByte((EntityPlayer)entityplayermp, "jrmcRelease");
/*  95 */       int ac = nbt.func_74762_e("jrmcAlCntr");
/*  96 */       byte alive = nbt.func_74771_c("jrmcAlv");
/*  97 */       int Diff = JRMCoreH.getByte((EntityPlayer)entityplayermp, "jrmcDiff");
/*  98 */       int Align = JRMCoreH.getByte((EntityPlayer)entityplayermp, "jrmcAlign");
/*  99 */       int TPint = JRMCoreH.getInt((EntityPlayer)entityplayermp, "jrmcTpint");
/*     */       
/* 101 */       String[] pw = { "NotSelected", "DBC", "NC", "SAO" };
/*     */       
/* 103 */       entitycommansender.func_145747_a((new ChatComponentText(entityplayermp.getDisplayName() + "'s Character Sheet")).func_150255_a(colorG));
/* 104 */       entitycommansender.func_145747_a((new ChatComponentText("Level: " + JRMCoreH.getPlayerLevel(PlyrAttrbts))).func_150255_a(color));
/* 105 */       entitycommansender.func_145747_a((new ChatComponentText("Power User: " + pw[pwr])).func_150255_a(color));
/* 106 */       entitycommansender.func_145747_a((new ChatComponentText("Race: " + JRMCoreH.Races[rc])).func_150255_a(color));
/* 107 */       entitycommansender.func_145747_a((new ChatComponentText("Class: " + JRMCoreH.cl(pwr)[Cls])).func_150255_a(color));
/* 108 */       entitycommansender.func_145747_a((new ChatComponentText("Training Points: " + TPint)).func_150255_a(color));
/* 109 */       entitycommansender.func_145747_a((new ChatComponentText("Power Release: " + rls + "%")).func_150255_a(color));
/* 110 */       entitycommansender.func_145747_a((new ChatComponentText("STR: " + PlyrAttrbts[0])).func_150255_a(color));
/* 111 */       entitycommansender.func_145747_a((new ChatComponentText("DEX: " + PlyrAttrbts[1])).func_150255_a(color));
/* 112 */       entitycommansender.func_145747_a((new ChatComponentText("CON: " + PlyrAttrbts[2])).func_150255_a(color));
/* 113 */       entitycommansender.func_145747_a((new ChatComponentText("WIL: " + PlyrAttrbts[3])).func_150255_a(color));
/* 114 */       entitycommansender.func_145747_a((new ChatComponentText("MND: " + PlyrAttrbts[4])).func_150255_a(color));
/* 115 */       entitycommansender.func_145747_a((new ChatComponentText("SPI: " + PlyrAttrbts[5])).func_150255_a(color));
/* 116 */       entitycommansender.func_145747_a((new ChatComponentText("Status: " + ((alive == 0) ? "Alive" : "Dead"))).func_150255_a(color));
/* 117 */       entitycommansender.func_145747_a((new ChatComponentText("Difficulty: " + JRMCoreH.DifficultyNames[Diff])).func_150255_a(color));
/* 118 */       entitycommansender.func_145747_a((new ChatComponentText("Alignment: " + JRMCoreH.AlgnmntNms[JRMCoreH.Algnmnt(Align)])).func_150255_a(color));
/* 119 */       String[] PlyrSkills = nbt.func_74779_i("jrmcSSlts").split(","); byte j;
/* 120 */       for (j = 0; j < PlyrSkills.length; j = (byte)(j + 1)) {
/* 121 */         String skl = PlyrSkills[j];
/* 122 */         if (skl.length() > 2) {
/* 123 */           entitycommansender.func_145747_a((new ChatComponentText("Skill: lvl " + (Integer.parseInt(skl.substring(2)) + 1) + " " + JRMCoreH.SklName(skl, JRMCoreH.DBCSkillsIDs, JRMCoreH.DBCSkillNames))).func_150255_a(colorG));
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 128 */       this; notifyAdmins(par1ICommandSender, "%s checked char sheet of %s ", new Object[] { func_71521_c(par1ICommandSender).getDisplayName(), entityplayermp.func_70005_c_() });
/*     */     } 
/*     */   }
/*     */   
/*     */   private void setter(String s, int v, String n) {
/* 133 */     Object[] o = SList.get(s);
/* 134 */     if (o != null) {
/* 135 */       int prevV = Integer.parseInt(o[0] + "");
/* 136 */       if (prevV > v) {
/* 137 */         Object[] sTemp = new Object[2];
/* 138 */         sTemp[0] = Integer.valueOf(v);
/* 139 */         sTemp[1] = n;
/* 140 */         SList.put(s, sTemp);
/*     */       } 
/*     */     } else {
/* 143 */       Object[] sTemp = new Object[2];
/* 144 */       sTemp[0] = Integer.valueOf(v);
/* 145 */       sTemp[1] = n;
/* 146 */       SList.put(s, sTemp);
/*     */     } 
/*     */   }
/*     */   private Object[] getter(String s) {
/* 150 */     Object[] o = SList.get(s);
/* 151 */     if (o.length == 2) {
/* 152 */       return o;
/*     */     }
/* 154 */     return null;
/*     */   }
/*     */   
/*     */   private void notifyAdmins(ICommandSender par1iCommandSender, String string, Object[] objects) {
/* 158 */     func_152373_a(par1iCommandSender, (ICommand)this, string, objects);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List func_71516_a(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
/* 167 */     return (par2ArrayOfStr.length == 2) ? func_71530_a(par2ArrayOfStr, getListOfPlayers()) : null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String[] getListOfPlayers() {
/* 172 */     return MinecraftServer.func_71276_C().func_71213_z();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isUsernameIndex(int par1) {
/* 180 */     return (par1 == 0);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\ComJrmcCheck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */