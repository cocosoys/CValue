/*     */ package JinRyuu.DragonBC.common.Gui;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreConfig;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
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
/*     */ 
/*     */ 
/*     */ public class ComSkill
/*     */   extends CommandBase
/*     */ {
/*     */   public String func_71517_b() {
/*  25 */     return "dbcskill";
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_82362_a() {
/*  30 */     return 2;
/*     */   }
/*     */   
/*     */   public void func_71515_b(ICommandSender par1ICommandSender, String[] stringArray) {
/*     */     EntityPlayerMP entityplayermp;
/*  35 */     if (stringArray.length < 2)
/*     */     {
/*  37 */       throw new WrongUsageException(func_71518_a(par1ICommandSender), new Object[0]);
/*     */     }
/*     */     
/*  40 */     String s = stringArray[0];
/*  41 */     boolean give = s.toLowerCase().contentEquals("give");
/*  42 */     boolean givelvl = s.toLowerCase().contentEquals("givelvl");
/*  43 */     boolean take = s.toLowerCase().contentEquals("take");
/*     */     
/*  45 */     boolean all = stringArray[1].toLowerCase().contentEquals("all");
/*  46 */     int id = -1;
/*  47 */     if (!all)
/*     */     {
/*  49 */       for (int i = 0; i < JRMCoreH.DBCSkillNames.length; i++) {
/*  50 */         if (stringArray[1].toLowerCase().equals(JRMCoreH.DBCSkillNames[i].toLowerCase())) {
/*     */           
/*  52 */           id = i;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/*  59 */     if (stringArray.length > (givelvl ? 3 : 2)) {
/*     */       
/*  61 */       entityplayermp = func_82359_c(par1ICommandSender, stringArray[givelvl ? 3 : 2]);
/*     */     }
/*     */     else {
/*     */       
/*  65 */       entityplayermp = func_71521_c(par1ICommandSender);
/*     */     } 
/*     */     
/*  68 */     String entitycommansender = "Console";
/*     */     try {
/*  70 */       EntityPlayerMP commansender = func_71521_c(par1ICommandSender);
/*  71 */       entitycommansender = commansender.func_70005_c_();
/*  72 */     } catch (Exception exception) {}
/*     */ 
/*     */     
/*  75 */     boolean n = entitycommansender.equals("Console") ? JRMCoreConfig.ComANAC : (entitycommansender.equals(entityplayermp.func_70005_c_()) ? JRMCoreConfig.ComANAS : JRMCoreConfig.ComANAO);
/*     */     
/*  77 */     NBTTagCompound nbt = JRMCoreH.nbt((Entity)entityplayermp, "pres");
/*     */     
/*  79 */     EntityPlayerMP entityPlayerMP1 = entityplayermp;
/*  80 */     int pwrtyp = JRMCoreH.getByte((EntityPlayer)entityPlayerMP1, "jrmcPwrtyp");
/*  81 */     int rc = JRMCoreH.getByte((EntityPlayer)entityPlayerMP1, "jrmcRace");
/*     */     
/*  83 */     int[] PlyrAttrbts = JRMCoreH.PlyrAttrbts((EntityPlayer)entityplayermp);
/*     */     
/*  85 */     String[] PlyrSkills = nbt.func_74779_i("jrmcSSlts").split(",");
/*  86 */     int PlyrSkills_Amount = PlyrSkills.length;
/*     */     
/*  88 */     String[] skls = JRMCoreH.DBCSkillsIDs;
/*  89 */     String[] sklsNms = JRMCoreH.DBCSkillNames;
/*     */     
/*  91 */     if (id >= 0 || all) {
/*     */       
/*  93 */       if (give || givelvl) {
/*     */         
/*  95 */         boolean stop = false;
/*  96 */         if (all && givelvl) {
/*  97 */           byte i; for (i = 0; i < JRMCoreH.DBCSkillNames.length; i = (byte)(i + 1)) {
/*  98 */             for (int j = 0; j < PlyrSkills_Amount; j++) {
/*  99 */               if (PlyrSkills[j].contains(skls[i])) {
/* 100 */                 boolean po = stringArray[2].contains("+");
/* 101 */                 boolean ne = stringArray[2].contains("-");
/* 102 */                 int lv = Integer.parseInt(stringArray[2]);
/* 103 */                 int slv = JRMCoreH.SklLvl(j, 1, PlyrSkills) - 1;
/* 104 */                 int re = (po || ne) ? (slv + lv) : (lv - 1); re = (re > 9) ? 9 : ((re < 0) ? 0 : re);
/* 105 */                 String sn2 = JRMCoreH.cleanUpCommas(nbt.func_74779_i("jrmcSSlts").replaceAll(PlyrSkills[j], skls[i] + re));
/* 106 */                 nbt.func_74778_a("jrmcSSlts", sn2);
/* 107 */                 String t = JRMCoreH.trlai("jrmc", "skillupped");
/* 108 */                 ChatStyle color = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW);
/* 109 */                 entityplayermp.func_145747_a((new ChatComponentTranslation(t, new Object[] { sklsNms[i], Integer.valueOf(re + 1) })).func_150255_a(color));
/* 110 */                 if (n) notifyAdmins(par1ICommandSender, "%s has upgraded skill %s to lvl %s", new Object[] { entityplayermp.func_70005_c_(), sklsNms[i], Integer.valueOf(re + 1) });
/*     */               
/*     */               } 
/*     */             } 
/*     */           } 
/* 115 */         } else if (id >= 0) {
/* 116 */           int i; for (i = 0; i < PlyrSkills_Amount; i = (byte)(i + 1)) {
/* 117 */             if (PlyrSkills[i].contains(skls[id])) {
/* 118 */               stop = true;
/* 119 */               if (stop && givelvl) {
/* 120 */                 boolean po = stringArray[2].contains("+");
/* 121 */                 boolean ne = stringArray[2].contains("-");
/* 122 */                 int lv = Integer.parseInt(stringArray[2]);
/* 123 */                 int slv = JRMCoreH.SklLvl(id, 1, PlyrSkills) - 1;
/* 124 */                 int re = (po || ne) ? (slv + lv) : (lv - 1); re = (re > 9) ? 9 : ((re < 0) ? 0 : re);
/* 125 */                 String sn2 = JRMCoreH.cleanUpCommas(nbt.func_74779_i("jrmcSSlts").replaceAll(PlyrSkills[i], skls[id] + re));
/* 126 */                 nbt.func_74778_a("jrmcSSlts", sn2);
/* 127 */                 String t = JRMCoreH.trlai("jrmc", "skillupped");
/* 128 */                 ChatStyle color = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW);
/* 129 */                 entityplayermp.func_145747_a((new ChatComponentTranslation(t, new Object[] { sklsNms[id], Integer.valueOf(re + 1) })).func_150255_a(color));
/* 130 */                 if (n) notifyAdmins(par1ICommandSender, "%s has upgraded skill %s to lvl %s", new Object[] { entityplayermp.func_70005_c_(), sklsNms[id], Integer.valueOf(re + 1) });  return;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/* 135 */         if (stop) {
/* 136 */           String t = JRMCoreH.trlai("jrmc", "alreadyhaveskill");
/* 137 */           ChatStyle color = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW);
/* 138 */           entityplayermp.func_145747_a((new ChatComponentTranslation(t, new Object[0])).func_150255_a(color));
/* 139 */           if (n) notifyAdmins(par1ICommandSender, "%s already has skill %s", new Object[] { entityplayermp.func_70005_c_(), sklsNms[id] });
/*     */         
/*     */         } else {
/*     */           
/* 143 */           PlyrSkills = nbt.func_74779_i("jrmcSSlts").split(",");
/* 144 */           PlyrSkills_Amount = PlyrSkills.length;
/* 145 */           if (all) {
/* 146 */             byte i; for (i = 0; i < JRMCoreH.DBCSkillNames.length; i = (byte)(i + 1)) {
/* 147 */               boolean have = false;
/* 148 */               for (int j = 0; j < PlyrSkills_Amount; j++) {
/* 149 */                 if (PlyrSkills[j].contains(skls[i])) {
/* 150 */                   have = true;
/*     */                 }
/*     */               } 
/* 153 */               if (!have) {
/* 154 */                 int re = 0;
/* 155 */                 if (givelvl) {
/* 156 */                   boolean po = stringArray[2].contains("+");
/* 157 */                   boolean ne = stringArray[2].contains("-");
/* 158 */                   int lv = Integer.parseInt(stringArray[2]);
/* 159 */                   int slv = 0;
/* 160 */                   re = (po || ne) ? (slv + lv) : (lv - 1); re = (re > 9) ? 9 : ((re < 0) ? 0 : re);
/*     */                 } 
/* 162 */                 nbt.func_74778_a("jrmcSSlts", JRMCoreH.cleanUpCommas(nbt.func_74779_i("jrmcSSlts") + "," + skls[i] + re));
/* 163 */                 String t = JRMCoreH.trlai("jrmc", "skilladded");
/* 164 */                 ChatStyle color = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW);
/* 165 */                 entityplayermp.func_145747_a((new ChatComponentTranslation(t, new Object[] { sklsNms[i] })).func_150255_a(color));
/* 166 */                 if (n) notifyAdmins(par1ICommandSender, "%s has received skill %s to lvl %s", new Object[] { entityplayermp.func_70005_c_(), sklsNms[i], Integer.valueOf(re + 1) }); 
/*     */               } 
/*     */             } 
/*     */           } else {
/* 170 */             int re = 0;
/* 171 */             if (givelvl) {
/* 172 */               boolean po = stringArray[2].contains("+");
/* 173 */               boolean ne = stringArray[2].contains("-");
/* 174 */               int lv = Integer.parseInt(stringArray[2]);
/* 175 */               int slv = 0;
/* 176 */               re = (po || ne) ? (slv + lv) : (lv - 1); re = (re > 9) ? 9 : ((re < 0) ? 0 : re);
/*     */             } 
/* 178 */             nbt.func_74778_a("jrmcSSlts", JRMCoreH.cleanUpCommas(nbt.func_74779_i("jrmcSSlts") + "," + skls[id] + re));
/* 179 */             String t = JRMCoreH.trlai("jrmc", "skilladded");
/* 180 */             ChatStyle color = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW);
/* 181 */             entityplayermp.func_145747_a((new ChatComponentTranslation(t, new Object[] { sklsNms[id] })).func_150255_a(color));
/* 182 */             if (n) notifyAdmins(par1ICommandSender, "%s has received skill %s to lvl %s", new Object[] { entityplayermp.func_70005_c_(), sklsNms[id], Integer.valueOf(re + 1) });
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/* 187 */       if (take) {
/* 188 */         if (id >= 0) {
/* 189 */           byte i; for (i = 0; i < PlyrSkills_Amount; i = (byte)(i + 1)) {
/* 190 */             if (PlyrSkills[i].contains(skls[id])) {
/* 191 */               if (id == 8) {
/* 192 */                 JRMCoreH.PlyrSettingsRem(nbt, 0);
/*     */               }
/* 194 */               if (id == 16) {
/* 195 */                 JRMCoreH.PlyrSettingsRem(nbt, 11);
/*     */               }
/* 197 */               if (id == 18) {
/* 198 */                 JRMCoreH.PlyrSettingsRem(nbt, 16);
/*     */               }
/* 200 */               String sn2 = JRMCoreH.cleanUpCommas(nbt.func_74779_i("jrmcSSlts").replaceAll(PlyrSkills[i], ""));
/* 201 */               nbt.func_74778_a("jrmcSSlts", (sn2.length() < 3) ? "," : sn2);
/*     */               
/* 203 */               String skl = sklsNms[id];
/* 204 */               String t = "Skill " + skl + " removed";
/* 205 */               ChatStyle color = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW);
/* 206 */               entityplayermp.func_145747_a((new ChatComponentText(t)).func_150255_a(color));
/* 207 */               if (n) notifyAdmins(par1ICommandSender, "%s's skill %s has been removed!", new Object[] { entityplayermp.func_70005_c_(), skl });
/*     */             
/*     */             } 
/*     */           } 
/*     */         } else {
/* 212 */           nbt.func_74778_a("jrmcSSlts", ",");
/* 213 */           String t = JRMCoreH.trlai("jrmc", "skillallremoved");
/* 214 */           ChatStyle color = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW);
/* 215 */           entityplayermp.func_145747_a((new ChatComponentTranslation(t, new Object[0])).func_150255_a(color));
/* 216 */           if (n) notifyAdmins(par1ICommandSender, "%s's all skill has been removed!", new Object[] { entityplayermp.func_70005_c_() });
/*     */         
/*     */         } 
/*     */       }
/*     */     } else {
/* 221 */       String t = JRMCoreH.trlai("jrmc", "skillnameinvalid");
/* 222 */       ChatStyle color = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW);
/* 223 */       entityplayermp.func_145747_a((new ChatComponentTranslation(t, new Object[0])).func_150255_a(color));
/*     */     } 
/*     */   }
/*     */   
/*     */   private void notifyAdmins(ICommandSender par1iCommandSender, String string, Object[] objects) {
/* 228 */     func_152373_a(par1iCommandSender, (ICommand)this, string, objects);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSkillList() {
/* 233 */     String list = "";
/* 234 */     for (int i = 0; i < JRMCoreH.DBCSkillNames.length; i++) {
/* 235 */       list = list + ", " + JRMCoreH.DBCSkillNames[i];
/*     */     }
/* 237 */     return list;
/*     */   }
/*     */   
/*     */   public String func_71518_a(ICommandSender icommandsender) {
/* 241 */     String list = getSkillList();
/* 242 */     return "/dbcskill (give or take) (skillName) [playerName] OR /dbcskill take all [playerName] OR /dbcskill givelvl (skillName) (lvl 1-10) [playerName] --> skillNames can be: " + list;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List func_71516_a(ICommandSender par1ICommandSender, String[] arrayString) {
/* 254 */     int length = arrayString.length;
/* 255 */     switch (length) { case 1:
/* 256 */         return func_71530_a(arrayString, new String[] { "give", "take", "givelvl" });
/* 257 */       case 2: return func_71530_a(arrayString, getSkillList().split(", "));
/* 258 */       case 3: (new String[1])[0] = "1"; return func_71530_a(arrayString, arrayString[0].equals("givelvl") ? new String[1] : getListOfPlayers());
/* 259 */       case 4: return arrayString[0].equals("givelvl") ? func_71530_a(arrayString, getListOfPlayers()) : null; }
/* 260 */      return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected String[] getListOfPlayers() {
/* 266 */     return MinecraftServer.func_71276_C().func_71213_z();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isUsernameIndex(int id) {
/* 271 */     return (id == 0);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Gui\ComSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */