/*     */ package JinRyuu.JRMCore;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
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
/*     */ public class ComJrmcKills extends CommandBase {
/*     */   public String func_71517_b() {
/*  20 */     return "jrmckills";
/*     */   }
/*  22 */   public static HashMap<String, Object[]> SList = (HashMap)new HashMap<String, Object>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_82362_a() {
/*  29 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_71518_a(ICommandSender par1ICommandSender) {
/*  34 */     return "Usage: '/jrmckills top' to view top kills OR '/jrmckills [playerName]' to view players kill statistics.";
/*     */   }
/*     */   
/*     */   public boolean func_71519_b(ICommandSender par1ICommandSender) {
/*  38 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_71515_b(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
/*  44 */     if (par2ArrayOfStr.length <= 0)
/*     */     {
/*  46 */       throw new WrongUsageException(
/*  47 */           func_71518_a(par1ICommandSender), new Object[0]);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  52 */     EntityPlayerMP entitycommansender = func_71521_c(par1ICommandSender);
/*  53 */     EntityPlayerMP entityplayermp = entitycommansender;
/*     */     
/*  55 */     boolean flagTop = false;
/*  56 */     boolean flagPlayer = false;
/*  57 */     if (par2ArrayOfStr.length > 0 && par2ArrayOfStr[0].equalsIgnoreCase("top")) {
/*  58 */       entityplayermp = func_71521_c(par1ICommandSender);
/*  59 */       flagTop = true;
/*     */     }
/*  61 */     else if (par2ArrayOfStr.length > 0) {
/*  62 */       entityplayermp = func_82359_c(par1ICommandSender, par2ArrayOfStr[0]);
/*  63 */       flagPlayer = true;
/*     */     } 
/*     */     
/*  66 */     NBTTagCompound nbt = JRMCoreH.nbt((Entity)entityplayermp, "pres");
/*  67 */     ChatStyle color = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW);
/*  68 */     ChatStyle colorG = (new ChatStyle()).func_150238_a(EnumChatFormatting.GOLD);
/*     */     
/*  70 */     MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
/*  71 */     int cur = server.func_71233_x();
/*  72 */     boolean alone = (cur <= 1 && flagTop);
/*     */     
/*  74 */     if (cur <= 1 || flagPlayer) {
/*  75 */       int Align = JRMCoreH.getByte((EntityPlayer)entityplayermp, "jrmcAlign");
/*  76 */       int Karma = JRMCoreH.getInt((EntityPlayer)entityplayermp, "jrmcKarma");
/*  77 */       int KllCG = JRMCoreH.getInt((EntityPlayer)entityplayermp, "jrmcKillCountGood");
/*  78 */       int KllCN = JRMCoreH.getInt((EntityPlayer)entityplayermp, "jrmcKillCountNeut");
/*  79 */       int KllCE = JRMCoreH.getInt((EntityPlayer)entityplayermp, "jrmcKillCountEvil");
/*  80 */       int total = KllCG + KllCN + KllCE;
/*  81 */       if (alone) entitycommansender.func_145747_a((new ChatComponentText("You are alone on the server!")).func_150255_a(color)); 
/*  82 */       entitycommansender.func_145747_a((new ChatComponentText(entityplayermp.getDisplayName() + "'s Player Kill counts")).func_150255_a(colorG));
/*  83 */       entitycommansender.func_145747_a((new ChatComponentText("Total Kills: " + total)).func_150255_a(color));
/*  84 */       entitycommansender.func_145747_a((new ChatComponentText("Good Kills: " + KllCG)).func_150255_a(color));
/*  85 */       entitycommansender.func_145747_a((new ChatComponentText("Neutral Kills: " + KllCN)).func_150255_a(color));
/*  86 */       entitycommansender.func_145747_a((new ChatComponentText("Evil Kills: " + KllCE)).func_150255_a(color));
/*  87 */       entitycommansender.func_145747_a((new ChatComponentText("Bad Karma: " + Karma)).func_150255_a(color));
/*  88 */       entitycommansender.func_145747_a((new ChatComponentText("Alignment: " + JRMCoreH.AlgnmntNms[JRMCoreH.Algnmnt(Align)])).func_150255_a(color));
/*     */       
/*  90 */       this; notifyAdmins(par1ICommandSender, "%s checked kill counts of %s  ", new Object[] { func_71521_c(par1ICommandSender).getDisplayName(), entityplayermp.func_70005_c_() });
/*     */     }
/*  92 */     else if (flagTop) {
/*     */       
/*  94 */       for (int pl = 0; pl < cur; pl++) {
/*  95 */         EntityPlayerMP player = JRMCoreH.getPlayerForUsername(server, server.func_71213_z()[pl]);
/*  96 */         int Align = JRMCoreH.getByte((EntityPlayer)entityplayermp, "jrmcAlign");
/*  97 */         int i = JRMCoreH.getInt((EntityPlayer)entityplayermp, "jrmcKarma");
/*  98 */         int KllCG = JRMCoreH.getInt((EntityPlayer)entityplayermp, "jrmcKillCountGood");
/*  99 */         int KllCN = JRMCoreH.getInt((EntityPlayer)entityplayermp, "jrmcKillCountNeut");
/* 100 */         int KllCE = JRMCoreH.getInt((EntityPlayer)entityplayermp, "jrmcKillCountEvil");
/* 101 */         int total = KllCG + KllCN + KllCE;
/*     */         
/* 103 */         setter("topBadKarma", i, player.func_70005_c_());
/* 104 */         setter("topTotalKills", total, player.func_70005_c_());
/* 105 */         setter("topGoodKills", KllCG, player.func_70005_c_());
/* 106 */         setter("topNeutralKills", KllCN, player.func_70005_c_());
/* 107 */         setter("topEvilKills", KllCE, player.func_70005_c_());
/*     */       } 
/* 109 */       Object[] topBadKarma = getter("topBadKarma");
/* 110 */       Object[] topTotalKills = getter("topTotalKills");
/* 111 */       Object[] topGoodKills = getter("topGoodKills");
/* 112 */       Object[] topNeutralKills = getter("topNeutralKills");
/* 113 */       Object[] topEvilKills = getter("topEvilKills");
/*     */       
/* 115 */       int Karma = Integer.parseInt(topBadKarma[0] + "");
/* 116 */       int Total = Integer.parseInt(topTotalKills[0] + "");
/* 117 */       int Good = Integer.parseInt(topGoodKills[0] + "");
/* 118 */       int Neutral = Integer.parseInt(topNeutralKills[0] + "");
/* 119 */       int Evil = Integer.parseInt(topEvilKills[0] + "");
/*     */       
/* 121 */       boolean b = (Karma == 0 && Total == 0 && Good == 0 && Neutral == 0 && Evil == 0);
/*     */       
/* 123 */       entitycommansender.func_145747_a((new ChatComponentText("Current Top Players")).func_150255_a(colorG));
/* 124 */       if (Karma > 0) entitycommansender.func_145747_a((new ChatComponentText("Most Wanted: " + topBadKarma[1] + " with " + topBadKarma[0] + " bad karma")).func_150255_a(color)); 
/* 125 */       if (Total > 0) entitycommansender.func_145747_a((new ChatComponentText("Top Total Kills: " + topTotalKills[1] + " with " + topTotalKills[0] + " kill count")).func_150255_a(color)); 
/* 126 */       if (Good > 0) entitycommansender.func_145747_a((new ChatComponentText("Top Good Kills: " + topGoodKills[1] + " with " + topGoodKills[0] + " kill count")).func_150255_a(color)); 
/* 127 */       if (Neutral > 0) entitycommansender.func_145747_a((new ChatComponentText("Top Neutral Kills: " + topNeutralKills[1] + " with " + topNeutralKills[0] + " kill count")).func_150255_a(color)); 
/* 128 */       if (Evil > 0) entitycommansender.func_145747_a((new ChatComponentText("Top Evil Kills: " + topEvilKills[1] + " with " + topEvilKills[0] + " kill count")).func_150255_a(color)); 
/* 129 */       if (b) entitycommansender.func_145747_a((new ChatComponentText("There are no Top Players!")).func_150255_a(color)); 
/* 130 */       SList.clear();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void setter(String s, int v, String n) {
/* 135 */     Object[] o = SList.get(s);
/* 136 */     if (o != null) {
/* 137 */       int prevV = Integer.parseInt(o[0] + "");
/* 138 */       if (prevV > v) {
/* 139 */         Object[] sTemp = new Object[2];
/* 140 */         sTemp[0] = Integer.valueOf(v);
/* 141 */         sTemp[1] = n;
/* 142 */         SList.put(s, sTemp);
/*     */       } 
/*     */     } else {
/* 145 */       Object[] sTemp = new Object[2];
/* 146 */       sTemp[0] = Integer.valueOf(v);
/* 147 */       sTemp[1] = n;
/* 148 */       SList.put(s, sTemp);
/*     */     } 
/*     */   }
/*     */   private Object[] getter(String s) {
/* 152 */     Object[] o = SList.get(s);
/* 153 */     if (o.length == 2) {
/* 154 */       return o;
/*     */     }
/* 156 */     return null;
/*     */   }
/*     */   
/*     */   private void notifyAdmins(ICommandSender par1iCommandSender, String string, Object[] objects) {
/* 160 */     func_152373_a(par1iCommandSender, (ICommand)this, string, objects);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List func_71516_a(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
/* 169 */     return (par2ArrayOfStr.length == 1) ? func_71530_a(par2ArrayOfStr, getListOfPlayers()) : null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String[] getListOfPlayers() {
/* 174 */     return MinecraftServer.func_71276_C().func_71213_z();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isUsernameIndex(int par1) {
/* 182 */     return (par1 == 0);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\ComJrmcKills.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */