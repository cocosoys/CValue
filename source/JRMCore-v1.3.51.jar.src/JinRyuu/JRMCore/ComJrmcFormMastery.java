/*     */ package JinRyuu.JRMCore;
/*     */ import JinRyuu.JRMCore.server.JGPlayerMP;
/*     */ import JinRyuu.JRMCore.server.config.dbc.JGConfigDBCFormMastery;
/*     */ import java.util.List;
/*     */ import net.minecraft.command.CommandBase;
/*     */ import net.minecraft.command.ICommand;
/*     */ import net.minecraft.command.ICommandSender;
/*     */ import net.minecraft.command.WrongUsageException;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.ChatStyle;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ 
/*     */ public class ComJrmcFormMastery extends CommandBase {
/*  18 */   public static final ChatStyle styleYellow = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW);
/*  19 */   public static final ChatStyle styleRed = (new ChatStyle()).func_150238_a(EnumChatFormatting.RED);
/*     */   
/*  21 */   private final String name = "jrmcformmastery";
/*  22 */   private final String[] IS_RACIAL = new String[] { "true", "false" };
/*     */ 
/*     */   
/*  25 */   private final String[] FORM_ID = new String[] { "current", "all", "0", "1", "2", "Base", JRMCoreH.transNonRacial[0], JRMCoreH.transNonRacial[1], JRMCoreH.transNonRacial[2], JRMCoreH.transNonRacial[3] };
/*     */ 
/*     */ 
/*     */   
/*  29 */   private final String[] MODE = new String[] { "add", "set" };
/*     */ 
/*     */   
/*  32 */   private final String[] AMOUNT = new String[] { "1.0", "100", "-1.0" };
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_71517_b() {
/*  37 */     return "jrmcformmastery";
/*     */   }
/*     */   
/*     */   public String func_71518_a(ICommandSender icommandsender) {
/*  41 */     return "/jrmcformmastery [playerName] (Add/Set) (formName or nonRacialFormID) (Amount)";
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_82362_a() {
/*  46 */     return 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public List func_71516_a(ICommandSender commandSender, String[] stringArray) {
/*  51 */     int length = stringArray.length;
/*  52 */     switch (length) { case 1:
/*  53 */         return func_71530_a(stringArray, getListOfPlayers());
/*     */       case 2:
/*  55 */         return func_71530_a(stringArray, this.MODE);
/*  56 */       case 3: return func_71530_a(stringArray, this.FORM_ID);
/*  57 */       case 4: return func_71530_a(stringArray, this.AMOUNT); }
/*     */ 
/*     */     
/*  60 */     return null;
/*     */   }
/*     */   
/*     */   public boolean isUsernameIndex(int par1) {
/*  64 */     return (par1 == 0); } protected String[] getListOfPlayers() {
/*  65 */     return MinecraftServer.func_71276_C().func_71213_z();
/*     */   }
/*     */   
/*     */   private void notifyAdmins(ICommandSender commandSender, String string, Object[] objects) {
/*  69 */     func_152373_a(commandSender, (ICommand)this, string, objects);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_71515_b(ICommandSender commandSender, String[] stringArray) {
/*     */     EntityPlayerMP player;
/*  76 */     if (!JGConfigDBCFormMastery.FM_Enabled) {
/*  77 */       commandSender.func_145747_a((new ChatComponentText("Form Masteries are disabled!")).func_150255_a(styleRed));
/*     */       
/*     */       return;
/*     */     } 
/*  81 */     if (stringArray.length <= 0)
/*     */     {
/*  83 */       throw new WrongUsageException(func_71518_a(commandSender), new Object[0]);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  88 */     if (stringArray.length > 0) {
/*     */       
/*  90 */       player = func_82359_c(commandSender, stringArray[0]);
/*     */     }
/*     */     else {
/*     */       
/*  94 */       player = func_71521_c(commandSender);
/*     */     } 
/*     */     
/*  97 */     JGPlayerMP jgPlayer = new JGPlayerMP(player);
/*  98 */     jgPlayer.connectBaseNBT();
/*  99 */     int race = jgPlayer.getRace();
/*     */     
/* 101 */     String mode = stringArray[1].toLowerCase();
/* 102 */     boolean modeAdd = mode.equals("add");
/* 103 */     boolean modeChange = (mode.equals("set") || mode.equals("change"));
/*     */     
/* 105 */     if (player != null && (modeAdd || modeChange) && !JRMCoreH.isFused((Entity)player)) {
/* 106 */       boolean isRacial = true;
/* 107 */       String formName = stringArray[2].toLowerCase();
/*     */       
/* 109 */       if (formName.equals("current")) {
/* 110 */         formName = "-1";
/*     */       }
/* 112 */       else if (formName.equals("all")) {
/* 113 */         formName = "-2";
/*     */       } else {
/*     */         
/* 116 */         int id = 0;
/*     */         
/* 118 */         boolean found = false;
/* 119 */         for (String form : JRMCoreH.transNonRacial) {
/* 120 */           if (form.toLowerCase().equals(formName)) {
/* 121 */             formName = "" + id;
/* 122 */             isRacial = false;
/* 123 */             found = true;
/*     */             break;
/*     */           } 
/* 126 */           id++;
/*     */         } 
/*     */         
/* 129 */         if (!found) {
/* 130 */           id = 0;
/* 131 */           for (String form : JRMCoreH.trans[race]) {
/* 132 */             if (form.toLowerCase().equals(formName)) {
/* 133 */               formName = "" + id;
/* 134 */               isRacial = true;
/*     */               break;
/*     */             } 
/* 137 */             id++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 142 */       int formID = Integer.parseInt(formName);
/* 143 */       if (formID < -2) formID = -2; 
/* 144 */       if (formID >= (isRacial ? (JRMCoreH.trans[race]).length : JRMCoreH.transNonRacial.length)) formID = (isRacial ? (JRMCoreH.trans[race]).length : JRMCoreH.transNonRacial.length) - 1;
/*     */ 
/*     */       
/* 147 */       double amount = Double.parseDouble(stringArray[3]);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 157 */       int powerType = jgPlayer.getPowerType();
/* 158 */       if (!JRMCoreH.isPowerTypeKi(powerType)) {
/* 159 */         commandSender.func_145747_a((new ChatComponentText("Form Masteries are only available for Ki Powertype Players!")).func_150255_a(styleRed));
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 164 */       if (formID == -1) {
/* 165 */         int state = jgPlayer.getState();
/* 166 */         int state2 = jgPlayer.getState2();
/* 167 */         String statusEffects = jgPlayer.getStatusEffects();
/* 168 */         boolean isKaiokenOn = jgPlayer.hasStatusEffect(5, statusEffects);
/* 169 */         boolean isMysticOn = jgPlayer.hasStatusEffect(13, statusEffects);
/* 170 */         boolean isUltraInstinctOn = jgPlayer.hasStatusEffect(19, statusEffects);
/* 171 */         boolean isGoDOn = jgPlayer.hasStatusEffect(20, statusEffects);
/* 172 */         JRMCoreH.changeFormMasteriesValue((EntityPlayer)player, amount, amount, modeAdd, race, state, state2, isKaiokenOn, isMysticOn, isUltraInstinctOn, isGoDOn, -1);
/* 173 */         commandSender.func_145747_a((new ChatComponentText("Form Mastery Points " + (modeAdd ? "Received" : "Set to") + ": " + amount + " Form: " + stringArray[2] + "!")).func_150255_a(styleYellow));
/*     */       
/*     */       }
/* 176 */       else if (formID == -2) {
/* 177 */         String[] NBT = JRMCoreH.getNBTFormMasteryRacialKeys(race);
/* 178 */         String[][] forms = new String[NBT.length][];
/*     */         
/* 180 */         int i = 0;
/* 181 */         for (String nbtKey : NBT) {
/* 182 */           String mastery = jgPlayer.getNBT().func_74779_i(nbtKey);
/*     */           
/* 184 */           boolean hasNBTOther = (jgPlayer.getNBT().func_74764_b(nbtKey) && !jgPlayer.getNBT().func_74779_i(nbtKey).equals("Base,0") && !jgPlayer.getNBT().func_74779_i(nbtKey).equals("Kaioken,0"));
/*     */           
/* 186 */           if (!hasNBTOther) {
/* 187 */             boolean isRacialOther = nbtKey.equals(JRMCoreH.getNBTFormMasteryRacialKey(race));
/* 188 */             mastery = isRacialOther ? JRMCoreH.getDefaultFormMasteryRacialText(race) : JRMCoreH.getDefaultFormMasteryNonRacialText();
/* 189 */             jgPlayer.getNBT().func_74778_a(nbtKey, mastery);
/*     */           } 
/*     */           
/* 192 */           forms[i] = mastery.split(";");
/* 193 */           int j = 0;
/* 194 */           for (String form : forms[i]) {
/* 195 */             String[] formValues = form.split(",");
/* 196 */             double value = amount;
/* 197 */             if (modeAdd) value += Double.parseDouble(formValues[1]);
/*     */             
/* 199 */             double FM_LevelMax = JGConfigDBCFormMastery.getDouble(race, j, JGConfigDBCFormMastery.DATA_ID_MAX_LEVEL);
/* 200 */             if (value > FM_LevelMax) value = FM_LevelMax; 
/* 201 */             forms[i][j] = formValues[0] + "," + ((value == (int)value) ? (int)value : value);
/* 202 */             j++;
/*     */           } 
/* 204 */           String result = "";
/* 205 */           j = 0;
/* 206 */           for (String form : forms[i]) {
/* 207 */             result = result + form + ((j + 1 < (forms[i]).length) ? ";" : "");
/* 208 */             j++;
/*     */           } 
/* 210 */           jgPlayer.getNBT().func_74778_a(nbtKey, result);
/*     */           
/* 212 */           i++;
/*     */         } 
/*     */         
/* 215 */         commandSender.func_145747_a((new ChatComponentText("Form Mastery Points " + (modeAdd ? "Received" : "Set to") + ": " + amount + " All Forms!")).func_150255_a(styleYellow));
/*     */       } else {
/*     */         
/* 218 */         JRMCoreH.changeFormMasteryValue((EntityPlayer)player, amount, modeAdd, race, formID + (!isRacial ? (JRMCoreH.trans[race]).length : 0), isRacial, -1);
/* 219 */         commandSender.func_145747_a((new ChatComponentText("Form Mastery Points " + (modeAdd ? "Received" : "Set to") + ": " + amount + " Form: " + stringArray[2] + "!")).func_150255_a(styleYellow));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\ComJrmcFormMastery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */