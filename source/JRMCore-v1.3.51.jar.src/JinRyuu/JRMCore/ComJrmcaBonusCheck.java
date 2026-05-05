/*     */ package JinRyuu.JRMCore;
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
/*     */ public class ComJrmcaBonusCheck extends CommandBase {
/*  17 */   private final String name = "jrmcabonuscheck";
/*     */   
/*  19 */   private final byte MODE_GET = 0, MODE_BAD_MODE = -1;
/*  20 */   private final byte MODE_STR = 0; private final byte MODE_DEX = 1; private final byte MODE_CON = 2; private final byte MODE_WILL = 3; private final byte MODE_MIND = 4; private final byte MODE_SPI = 5;
/*     */   
/*  22 */   private final String[] ATTRIBUTES_LONG = new String[] { "strength", "dexterity", "constitution", "willpower", "mind", "spirit" };
/*     */ 
/*     */   
/*  25 */   public static final String[] ATTRIBUTES_SHORT = new String[] { "str", "dex", "con", "wil", "mnd", "spi" };
/*     */ 
/*     */   
/*  28 */   private final String[] MODES = new String[] { "sheet" };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_71517_b() {
/*  34 */     return "jrmcabonuscheck";
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_71518_a(ICommandSender icommandsender) {
/*  39 */     return "/jrmcabonuscheck (sheet) (Attribute) (BonusName or ID) [playerName]. Attribute can be Strength, Dexterity, Constitution, Willpower, Mind, Spirit.";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_82362_a() {
/*  45 */     return 0; } public boolean func_71519_b(ICommandSender par1ICommandSender) {
/*  46 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List func_71516_a(ICommandSender commandSender, String[] stringArray) {
/*  56 */     int length = stringArray.length;
/*  57 */     switch (length) { case 1:
/*  58 */         return func_71530_a(stringArray, this.MODES);
/*  59 */       case 2: return func_71530_a(stringArray, this.ATTRIBUTES_LONG);
/*  60 */       case 3: return func_71530_a(stringArray, getListOfPlayers()); }
/*  61 */      return null;
/*     */   }
/*     */   
/*     */   protected String[] getListOfPlayers() {
/*  65 */     return MinecraftServer.func_71276_C().func_71213_z();
/*     */   }
/*     */   private NBTTagCompound nbt(EntityPlayer p, String s) {
/*  68 */     return JRMCoreH.nbt((Entity)p, s);
/*     */   }
/*     */   
/*     */   private void notifyAdmins(ICommandSender commandSender, String string, Object[] objects) {
/*  72 */     func_152373_a(commandSender, (ICommand)this, string, objects);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71515_b(ICommandSender commandSender, String[] stringArray) {
/*     */     EntityPlayerMP entityplayermp;
/*  78 */     if (stringArray.length <= 0)
/*     */     {
/*  80 */       throw new WrongUsageException(func_71518_a(commandSender), new Object[0]);
/*     */     }
/*     */ 
/*     */     
/*  84 */     String modeSting = stringArray[0].toLowerCase();
/*  85 */     String attributeString = stringArray[1].toLowerCase();
/*     */     
/*  87 */     byte mode = modeSting.equals("sheet") ? 0 : -1;
/*     */     
/*  89 */     byte attribute = 0; byte i;
/*  90 */     for (i = 0; i < this.ATTRIBUTES_LONG.length; i = (byte)(i + 1)) {
/*     */       
/*  92 */       if (attributeString.equals(this.ATTRIBUTES_LONG[i]) || attributeString.equals(ATTRIBUTES_SHORT[i]))
/*     */       {
/*  94 */         attribute = i;
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 101 */     int playerNameID = 2;
/*     */     
/* 103 */     if (stringArray.length > 2) {
/*     */       
/* 105 */       entityplayermp = func_82359_c(commandSender, stringArray[2]);
/*     */     }
/*     */     else {
/*     */       
/* 109 */       entityplayermp = func_71521_c(commandSender);
/*     */     } 
/*     */     
/* 112 */     String entitycommansender = "Console";
/* 113 */     EntityPlayerMP commansender = null;
/*     */     
/*     */     try {
/* 116 */       commansender = func_71521_c(commandSender);
/* 117 */       entitycommansender = commansender.func_70005_c_();
/* 118 */     } catch (Exception exception) {}
/*     */     
/* 120 */     boolean canRun = true;
/*     */     
/* 122 */     if (!JRMCoreConfig.JRMCABonusCheckOnOthersWithoutOP && commansender != null && !entitycommansender.equals("Console"))
/*     */     {
/* 124 */       if (!entityplayermp.func_70005_c_().equals(entitycommansender)) {
/*     */         
/* 126 */         canRun = false;
/* 127 */         ChatStyle color = (new ChatStyle()).func_150238_a(EnumChatFormatting.RED);
/* 128 */         commansender.func_145747_a((new ChatComponentText("JRMCABonusCheck - Non OP Players can check other Player's Sheet is DISABLED!")).func_150255_a(color));
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 133 */     if (canRun) {
/*     */       
/* 135 */       boolean run = false;
/*     */ 
/*     */       
/* 138 */       NBTTagCompound nbt = nbt((EntityPlayer)entityplayermp, "pres");
/* 139 */       String startString = nbt.func_74779_i("jrmcAttrBonus" + ATTRIBUTES_SHORT[attribute]);
/*     */ 
/*     */       
/* 142 */       String[] bonus = startString.split("\\|");
/* 143 */       String[][] bonusValues = new String[bonus.length][2];
/*     */       
/* 145 */       if (bonus.length > 0 && bonus[0].length() > 0)
/*     */       {
/* 147 */         for (int j = 0; j < bonus.length; j++) {
/*     */           
/* 149 */           String[] bonusValue = bonus[j].split("\\;");
/* 150 */           bonusValues[j][0] = bonusValue[0];
/* 151 */           bonusValues[j][1] = bonusValue[1];
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 157 */       if (mode == 0) {
/*     */ 
/*     */         
/* 160 */         ChatStyle colorG = (new ChatStyle()).func_150238_a(EnumChatFormatting.GOLD);
/* 161 */         ChatStyle color = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW);
/*     */         
/* 163 */         if (commansender != null) {
/*     */           
/* 165 */           commansender.func_145747_a((new ChatComponentText(entityplayermp
/* 166 */                 .getDisplayName() + " " + this.ATTRIBUTES_LONG[attribute] + " Bonus Attributes:")).func_150255_a(colorG));
/*     */         }
/* 168 */         else if (entitycommansender.equals("Console")) {
/* 169 */           JRMCoreH.log(entityplayermp.getDisplayName() + " " + this.ATTRIBUTES_LONG[attribute] + " Bonus Attributes:");
/*     */         } 
/*     */         
/* 172 */         if (bonus.length > 0 && bonus[0].length() > 0) {
/*     */           
/* 174 */           for (int j = 0; j < bonus.length; j++)
/*     */           {
/* 176 */             String[] bonusValue = bonus[j].split("\\;");
/* 177 */             bonusValues[j][0] = bonusValue[0];
/* 178 */             bonusValues[j][1] = bonusValue[1];
/* 179 */             if (bonusValues[j][1].contains("nbt_") || bonusValues[j][1].contains("NBT_")) {
/*     */               
/* 181 */               String noNBTText = bonusValues[j][1].replace("nbt_", "").replace("NBT_", "");
/* 182 */               double value = nbt.func_74769_h(noNBTText.substring(1));
/* 183 */               bonusValues[j][1] = noNBTText.substring(0, 1) + "(" + value + ")";
/*     */             } 
/*     */             
/* 186 */             if (commansender != null) {
/*     */               
/* 188 */               commansender.func_145747_a((new ChatComponentText("ID " + bonusValues[j][0] + " | VALUE: " + bonusValues[j][1]))
/* 189 */                   .func_150255_a(color));
/*     */             }
/* 191 */             else if (entitycommansender.equals("Console")) {
/* 192 */               JRMCoreH.log("ID " + bonusValues[j][0] + " | VALUE: " + bonusValues[j][1]);
/*     */             }
/*     */           
/*     */           }
/*     */         
/* 197 */         } else if (commansender != null) {
/*     */           
/* 199 */           commansender.func_145747_a((new ChatComponentText("EMPTY")).func_150255_a(color));
/*     */         }
/* 201 */         else if (entitycommansender.equals("Console")) {
/* 202 */           JRMCoreH.log("EMPTY");
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 208 */       if (!JRMCoreConfig.JRMCABonusOn)
/*     */       {
/* 210 */         if (commansender != null) {
/*     */           
/* 212 */           ChatStyle color = (new ChatStyle()).func_150238_a(EnumChatFormatting.RED);
/* 213 */           commansender.func_145747_a((new ChatComponentText("JRMCABonus Attributes are DISABLED in the configs!")).func_150255_a(color));
/*     */         }
/* 215 */         else if (entitycommansender.equals("Console")) {
/*     */           
/* 217 */           JRMCoreH.log("JRMCABonus Attributes are DISABLED in the configs!");
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\ComJrmcaBonusCheck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */