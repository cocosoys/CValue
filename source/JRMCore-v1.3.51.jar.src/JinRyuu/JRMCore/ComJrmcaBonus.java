/*     */ package JinRyuu.JRMCore;
/*     */ 
/*     */ import JinRyuu.JRMCore.server.JGMathHelper;
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
/*     */ public class ComJrmcaBonus extends CommandBase {
/*     */   public static final String NBT1 = "nbt_";
/*  20 */   private final String name = "jrmcabonus";
/*     */   public static final String NBT2 = "NBT_";
/*  22 */   private final byte MODE_ADD = 0, MODE_ADD_TO = 1, MODE_SET = 2, MODE_GET = 3, MODE_REMOVE = 4, MODE_CLEAR = 5, MODE_BAD_MODE = -1;
/*  23 */   private final byte MODE_STR = 0; private final byte MODE_DEX = 1; private final byte MODE_CON = 2; private final byte MODE_WILL = 3; private final byte MODE_MIND = 4; private final byte MODE_SPI = 5;
/*     */   
/*  25 */   private final String[] ATTRIBUTES_LONG = new String[] { "strength", "dexterity", "constitution", "willpower", "mind", "spirit" };
/*     */ 
/*     */   
/*  28 */   public static final String[] ATTRIBUTES_SHORT = new String[] { "str", "dex", "con", "wil", "mnd", "spi" };
/*     */ 
/*     */   
/*  31 */   private final String[] MODES = new String[] { "add", "addto", "set", "get", "remove", "clear" };
/*     */ 
/*     */   
/*  34 */   private final String[] OPERATIONS = new String[] { "+1", "-1", "*1", "/1", "%1", "nbt_nbtValueName" };
/*     */ 
/*     */   
/*  37 */   private final String[] END = new String[] { "true", "false" };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_71517_b() {
/*  43 */     return "jrmcabonus";
/*     */   }
/*     */   
/*     */   public String func_71518_a(ICommandSender icommandsender) {
/*  47 */     return "/jrmcabonus (Add/AddTo/Set/Get/Remove/clear) (Attribute) (BonusName or ID) (Math Operation - Amount (USE IF: mode is ADD or SET!)) (Add To Top/Start(false) or Bottom/End(true) of the List (USE IF: mode is ADD)) [playerName]. Attribute can be Strength, Dexterity, Constitution, Willpower, Mind, Spirit. Example: '/jrmcabonus add Strength saiyanRage *2.0 false @p' OR '/jrmcabonus get Strength'";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_82362_a() {
/*  55 */     return 2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List func_71516_a(ICommandSender commandSender, String[] stringArray) {
/*  62 */     String modeSting = stringArray[0].toLowerCase();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  68 */     byte mode = modeSting.equals("add") ? 0 : (modeSting.equals("addto") ? 1 : (modeSting.equals("set") ? 2 : (modeSting.equals("get") ? 3 : (modeSting.equals("clear") ? 5 : ((modeSting.equals("remove") || modeSting.equals("delete")) ? 4 : -1)))));
/*     */ 
/*     */     
/*  71 */     int length = stringArray.length;
/*  72 */     switch (length) { case 1:
/*  73 */         return func_71530_a(stringArray, this.MODES);
/*  74 */       case 2: return func_71530_a(stringArray, this.ATTRIBUTES_LONG);
/*  75 */       case 3: (new String[1])[0] = "nameid"; return func_71530_a(stringArray, (mode == 3 || mode == 5) ? getListOfPlayers() : new String[1]);
/*  76 */       case 4: return (mode == 3 || mode == 5) ? null : func_71530_a(stringArray, this.OPERATIONS);
/*  77 */       case 5: return (mode == 3 || mode == 5) ? null : func_71530_a(stringArray, (mode == 0) ? this.END : getListOfPlayers());
/*  78 */       case 6: return (mode == 0) ? func_71530_a(stringArray, getListOfPlayers()) : null; }
/*  79 */      return null;
/*     */   }
/*     */   
/*     */   protected String[] getListOfPlayers() {
/*  83 */     return MinecraftServer.func_71276_C().func_71213_z();
/*     */   }
/*     */   
/*     */   private NBTTagCompound nbt(EntityPlayer p, String s) {
/*  87 */     return JRMCoreH.nbt((Entity)p, s);
/*     */   }
/*     */   
/*     */   private void notifyAdmins(ICommandSender commandSender, String string, Object[] objects) {
/*  91 */     func_152373_a(commandSender, (ICommand)this, string, objects);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71515_b(ICommandSender commandSender, String[] stringArray) {
/*     */     EntityPlayerMP entityplayermp;
/*  97 */     if (stringArray.length <= 0)
/*     */     {
/*  99 */       throw new WrongUsageException(func_71518_a(commandSender), new Object[0]);
/*     */     }
/*     */ 
/*     */     
/* 103 */     String modeSting = stringArray[0].toLowerCase();
/* 104 */     String attributeString = stringArray[1].toLowerCase();
/* 105 */     String bonusNameIDString = "";
/* 106 */     String bonusAmountString = "";
/* 107 */     String endOfTheList = "";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 114 */     byte mode = modeSting.equals("add") ? 0 : (modeSting.equals("addto") ? 1 : (modeSting.equals("set") ? 2 : (modeSting.equals("get") ? 3 : (modeSting.equals("clear") ? 5 : ((modeSting.equals("remove") || modeSting.equals("delete")) ? 4 : -1)))));
/* 115 */     byte attribute = 0;
/*     */     byte i;
/* 117 */     for (i = 0; i < this.ATTRIBUTES_LONG.length; i = (byte)(i + 1)) {
/*     */       
/* 119 */       if (attributeString.equals(this.ATTRIBUTES_LONG[i]) || attributeString.equals(ATTRIBUTES_SHORT[i]))
/*     */       {
/* 121 */         attribute = i;
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 127 */     if (mode == 0 || mode == 2 || mode == 4 || mode == 1) {
/*     */       
/* 129 */       bonusNameIDString = stringArray[2];
/*     */       
/* 131 */       if (mode == 0 || mode == 2 || mode == 1) {
/*     */         
/* 133 */         bonusAmountString = stringArray[3];
/* 134 */         if (mode == 0)
/*     */         {
/* 136 */           endOfTheList = stringArray[4].toLowerCase();
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 142 */     int playerNameID = (mode == 3 || mode == 5) ? 2 : ((mode == 4) ? 3 : ((mode == 0) ? 5 : 4));
/*     */     
/* 144 */     if (stringArray.length > playerNameID) {
/*     */       
/* 146 */       entityplayermp = func_82359_c(commandSender, stringArray[playerNameID]);
/*     */     }
/*     */     else {
/*     */       
/* 150 */       entityplayermp = func_71521_c(commandSender);
/*     */     } 
/*     */ 
/*     */     
/* 154 */     String entitycommansender = "Console";
/* 155 */     EntityPlayerMP commansender = null;
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 160 */       commansender = func_71521_c(commandSender);
/* 161 */       entitycommansender = commansender.func_70005_c_();
/* 162 */     } catch (Exception exception) {}
/*     */ 
/*     */     
/* 165 */     boolean notify = entitycommansender.equals("Console") ? JRMCoreConfig.CommandNotifyAdminJRMCABonusConsole : (entitycommansender.equals(entityplayermp.func_70005_c_()) ? JRMCoreConfig.CommandNotifyAdminJRMCABonusSelf : JRMCoreConfig.CommandNotifyAdminJRMCABonusOthers);
/*     */     
/* 167 */     boolean run = false;
/*     */ 
/*     */ 
/*     */     
/* 171 */     NBTTagCompound nbt = nbt((EntityPlayer)entityplayermp, "pres");
/* 172 */     String startString = nbt.func_74779_i("jrmcAttrBonus" + ATTRIBUTES_SHORT[attribute]);
/*     */ 
/*     */ 
/*     */     
/* 176 */     String[] bonus = startString.split("\\|");
/* 177 */     String[][] bonusValues = new String[bonus.length][2];
/*     */     
/* 179 */     if (bonus.length > 0 && bonus[0].length() > 0)
/*     */     {
/* 181 */       for (int j = 0; j < bonus.length; j++) {
/*     */         
/* 183 */         String[] bonusValue = bonus[j].split("\\;");
/* 184 */         bonusValues[j][0] = bonusValue[0];
/* 185 */         bonusValues[j][1] = bonusValue[1];
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 191 */     if (mode == 0) {
/*     */       
/* 193 */       boolean doesItContainElement = false;
/*     */       
/* 195 */       for (int j = 0; j < bonus.length; j++) {
/*     */         
/* 197 */         String[] bonusValue = bonus[j].split("\\;");
/* 198 */         bonusValues[j][0] = bonusValue[0];
/*     */         
/* 200 */         if (bonusValues[j][0].equals(bonusNameIDString)) {
/*     */           
/* 202 */           doesItContainElement = true;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/* 207 */       if (!doesItContainElement)
/*     */       {
/* 209 */         boolean addToEnd = Boolean.parseBoolean(endOfTheList);
/*     */         
/* 211 */         if (addToEnd) {
/*     */           
/* 213 */           String data = bonusNameIDString + ";" + bonusAmountString;
/* 214 */           if (startString.length() == 0) { startString = data; }
/* 215 */           else { startString = startString + "|" + data; }
/*     */         
/*     */         } else {
/*     */           
/* 219 */           String data = bonusNameIDString + ";" + bonusAmountString;
/* 220 */           if (startString.length() == 0) { startString = data; }
/* 221 */           else { startString = data + "|" + startString; }
/*     */         
/*     */         } 
/* 224 */         bonus = startString.split("\\|");
/* 225 */         bonusValues = new String[bonus.length][2];
/*     */ 
/*     */         
/* 228 */         for (int k = 0; k < bonus.length; k++) {
/*     */           
/* 230 */           String[] bonusValue = bonus[k].split("\\;");
/* 231 */           bonusValues[k][0] = bonusValue[0];
/* 232 */           bonusValues[k][1] = bonusValue[1];
/*     */         } 
/*     */         
/* 235 */         run = true;
/*     */       }
/* 237 */       else if (notify)
/*     */       {
/* 239 */         notifyAdmins(commandSender, "Bonus Attribute Failed to be added for " + entityplayermp
/* 240 */             .func_70005_c_() + ", Reason: Bonus list already contains a value with this ID: " + bonusNameIDString, new Object[0]);
/*     */       
/*     */       }
/*     */     
/*     */     }
/* 245 */     else if (mode == 1) {
/*     */       
/* 247 */       boolean number, nbtFail = false;
/* 248 */       int id = -1;
/*     */ 
/*     */       
/* 251 */       try { id = Integer.parseInt(bonusNameIDString);
/* 252 */         number = true; }
/* 253 */       catch (Exception e) { number = false; }
/*     */       
/* 255 */       for (int j = 0; j < bonus.length; j++) {
/*     */         
/* 257 */         String[] bonusValue = bonus[j].split("\\;");
/* 258 */         bonusValues[j][0] = bonusValue[0];
/*     */         
/* 260 */         if ((number && j == id) || (!number && bonusValues[j][0].equals(bonusNameIDString))) {
/*     */           
/* 262 */           if (bonusValues[j][1].contains("nbt_") || bonusValues[j][1].contains("NBT_") || bonusAmountString.contains("nbt_") || bonusAmountString.contains("NBT_")) {
/*     */             
/* 264 */             nbtFail = true;
/*     */             
/*     */             break;
/*     */           } 
/* 268 */           double value = Double.parseDouble(bonusValues[j][1].substring(1));
/* 269 */           double value2 = Double.parseDouble(bonusAmountString.substring(1));
/*     */           
/* 271 */           double resultValue = JGMathHelper.StringMethod(bonusAmountString.substring(0, 1), value, value2);
/*     */           
/* 273 */           String result = bonusValues[j][1].substring(0, 1) + resultValue;
/*     */           
/* 275 */           String data = bonusValues[j][0] + ";" + result;
/*     */           
/* 277 */           bonus[j] = data;
/* 278 */           bonusValue = bonus[j].split("\\;");
/* 279 */           bonusValues[j][0] = bonusValue[0];
/* 280 */           bonusValues[j][1] = bonusValue[1];
/*     */           
/* 282 */           run = true;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */       
/* 288 */       if (!run && notify)
/*     */       {
/* 290 */         if (nbtFail)
/*     */         {
/* 292 */           notifyAdmins(commandSender, "Bonus Attribute Failed to be added to for " + entityplayermp
/* 293 */               .func_70005_c_() + ", Reason: One of the Bonus values is an NBT value name.", new Object[0]);
/*     */         
/*     */         }
/*     */         else
/*     */         {
/* 298 */           notifyAdmins(commandSender, "Bonus Attribute Failed to be added to for " + entityplayermp
/* 299 */               .func_70005_c_() + ", Reason: Bonus list didn't contain a value with this ID: " + bonusNameIDString, new Object[0]);
/*     */         }
/*     */       
/*     */       }
/*     */     }
/* 304 */     else if (mode == 2) {
/*     */       boolean number;
/* 306 */       int id = -1;
/*     */ 
/*     */       
/* 309 */       try { id = Integer.parseInt(bonusNameIDString);
/* 310 */         number = true; }
/* 311 */       catch (Exception e) { number = false; }
/*     */       
/* 313 */       for (int j = 0; j < bonus.length; j++) {
/*     */         
/* 315 */         String[] bonusValue = bonus[j].split("\\;");
/* 316 */         bonusValues[j][0] = bonusValue[0];
/*     */         
/* 318 */         if ((number && j == id) || (!number && bonusValues[j][0].equals(bonusNameIDString))) {
/*     */           
/* 320 */           String data = bonusValues[j][0] + ";" + bonusAmountString;
/* 321 */           bonus[j] = "";
/* 322 */           run = true;
/*     */           
/* 324 */           bonus[j] = data;
/* 325 */           bonusValue = bonus[j].split("\\;");
/* 326 */           bonusValues[j][0] = bonusValue[0];
/* 327 */           bonusValues[j][1] = bonusValue[1];
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/* 332 */       if (!run && notify)
/*     */       {
/* 334 */         notifyAdmins(commandSender, "Bonus Attribute Failed to be added to for " + entityplayermp
/* 335 */             .func_70005_c_() + ", Reason: Bonus list didn't contain a value with this " + (number ? "ID" : "Name") + ": " + bonusNameIDString, new Object[0]);
/*     */       
/*     */       }
/*     */     
/*     */     }
/* 340 */     else if (mode == 3) {
/*     */ 
/*     */       
/* 343 */       ChatStyle colorG = (new ChatStyle()).func_150238_a(EnumChatFormatting.GOLD);
/* 344 */       ChatStyle color = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW);
/*     */       
/* 346 */       if (commansender != null) {
/*     */         
/* 348 */         commansender.func_145747_a((new ChatComponentText(entityplayermp
/* 349 */               .getDisplayName() + " " + this.ATTRIBUTES_LONG[attribute] + " Bonus Attributes:")).func_150255_a(colorG));
/*     */       }
/* 351 */       else if (entitycommansender.equals("Console")) {
/* 352 */         JRMCoreH.log(entityplayermp.getDisplayName() + " " + this.ATTRIBUTES_LONG[attribute] + " Bonus Attributes:");
/*     */       } 
/*     */       
/* 355 */       if (bonus.length > 0 && bonus[0].length() > 0) {
/*     */         
/* 357 */         for (int j = 0; j < bonus.length; j++)
/*     */         {
/* 359 */           String[] bonusValue = bonus[j].split("\\;");
/* 360 */           bonusValues[j][0] = bonusValue[0];
/* 361 */           bonusValues[j][1] = bonusValue[1];
/* 362 */           if (bonusValues[j][1].contains("nbt_") || bonusValues[j][1].contains("NBT_")) {
/*     */             
/* 364 */             String noNBTText = bonusValues[j][1].replace("nbt_", "").replace("NBT_", "");
/* 365 */             double value = nbt.func_74769_h(noNBTText.substring(1));
/*     */             
/* 367 */             bonusValues[j][1] = noNBTText.substring(0, 1) + "(" + value + ")";
/*     */           } 
/*     */           
/* 370 */           if (commansender != null) {
/*     */             
/* 372 */             commansender.func_145747_a((new ChatComponentText("ID " + bonusValues[j][0] + " | VALUE: " + bonusValues[j][1]))
/* 373 */                 .func_150255_a(color));
/*     */           }
/* 375 */           else if (entitycommansender.equals("Console")) {
/* 376 */             JRMCoreH.log("ID " + bonusValues[j][0] + " | VALUE: " + bonusValues[j][1]);
/*     */           }
/*     */         
/*     */         }
/*     */       
/* 381 */       } else if (commansender != null) {
/*     */         
/* 383 */         commansender.func_145747_a((new ChatComponentText("EMPTY")).func_150255_a(color));
/*     */       }
/* 385 */       else if (entitycommansender.equals("Console")) {
/* 386 */         JRMCoreH.log("EMPTY");
/*     */       
/*     */       }
/*     */ 
/*     */     
/*     */     }
/* 392 */     else if (mode == 4) {
/*     */       boolean number;
/* 394 */       int id = -1;
/*     */ 
/*     */       
/* 397 */       try { id = Integer.parseInt(bonusNameIDString);
/* 398 */         number = true; }
/* 399 */       catch (Exception e) { number = false; }
/*     */       
/* 401 */       for (int j = 0; j < bonus.length; j++) {
/*     */         
/* 403 */         String[] bonusValue = bonus[j].split("\\;");
/* 404 */         bonusValues[j][0] = bonusValue[0];
/*     */         
/* 406 */         if ((number && j == id) || (!number && bonusValues[j][0].equals(bonusNameIDString))) {
/*     */ 
/*     */ 
/*     */           
/* 410 */           bonus[j] = "";
/* 411 */           run = true;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/* 416 */       if (!run && notify)
/*     */       {
/* 418 */         notifyAdmins(commandSender, "Bonus Attribute Failed to be added to for " + entityplayermp
/* 419 */             .func_70005_c_() + ", Reason: Bonus list didn't contain a value with this " + (number ? "ID" : "Name") + ": " + bonusNameIDString, new Object[0]);
/*     */       
/*     */       }
/*     */     }
/* 423 */     else if (mode == 5) {
/*     */       
/* 425 */       for (int j = 0; j < bonus.length; j++)
/*     */       {
/* 427 */         bonus[j] = "";
/*     */       }
/* 429 */       run = true;
/*     */     } 
/*     */ 
/*     */     
/* 433 */     if (run) {
/*     */       
/* 435 */       startString = "";
/* 436 */       for (int j = 0; j < bonus.length; j++) {
/*     */         
/* 438 */         if (bonus[j] != null && bonus[j].length() > 0)
/*     */         {
/* 440 */           startString = startString + bonus[j] + ((bonus.length - 1 == j) ? "" : "|");
/*     */         }
/*     */       } 
/*     */       
/* 444 */       nbt.func_74778_a("jrmcAttrBonus" + ATTRIBUTES_SHORT[attribute], startString);
/*     */     } 
/*     */ 
/*     */     
/* 448 */     if (notify && run)
/*     */     {
/* 450 */       notifyAdmins(commandSender, "Bonus Attribute " + this.MODES[mode].toUpperCase() + " finished for " + entityplayermp.func_70005_c_(), new Object[0]);
/*     */     }
/*     */ 
/*     */     
/* 454 */     if (!JRMCoreConfig.JRMCABonusOn)
/*     */     {
/* 456 */       if (commansender != null) {
/*     */         
/* 458 */         ChatStyle color = (new ChatStyle()).func_150238_a(EnumChatFormatting.RED);
/* 459 */         commansender.func_145747_a((new ChatComponentText("JRMCABonus Attributes are DISABLED in the configs!")).func_150255_a(color));
/*     */       }
/* 461 */       else if (entitycommansender.equals("Console")) {
/*     */         
/* 463 */         JRMCoreH.log("JRMCABonus Attributes are DISABLED in the configs!");
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\ComJrmcaBonus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */