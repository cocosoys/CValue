/*     */ package JinRyuu.JRMCore.server.commands;
/*     */ 
/*     */ import JinRyuu.JRMCore.client.notification.JGNotificationHandler;
/*     */ import JinRyuu.JRMCore.p.JRMCorePData3;
/*     */ import JinRyuu.JRMCore.p.PD;
/*     */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*     */ import java.util.List;
/*     */ import net.minecraft.command.CommandBase;
/*     */ import net.minecraft.command.ICommandSender;
/*     */ import net.minecraft.command.WrongUsageException;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ 
/*     */ public class CommandNotification extends CommandBase {
/*  15 */   private final String name = "jrmcnotification";
/*     */   
/*     */   public String func_71517_b() {
/*  18 */     return "jrmcnotification";
/*     */   }
/*     */   
/*     */   public String func_71518_a(ICommandSender commandSender) {
/*  22 */     return "/jrmcnotification ([sendToAll] OR [sendToDimension:dimensionID] OR [sendToAllAround:dimensionID,x,y,z,range] OR [playerName]) {Title;Description;Category;IconID;RenderLocationID;ColorDecimalCode}";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_82362_a() {
/*  29 */     return 2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List func_71516_a(ICommandSender commandSender, String[] stringArray) {
/*  35 */     int length = stringArray.length;
/*  36 */     switch (length) { case 1:
/*  37 */         return func_71530_a(stringArray, getListOfPlayers());
/*  38 */       case 2: return func_71530_a(stringArray, new String[] { "{Title;Description;Info;0;0;16777215}" }); }
/*  39 */      return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String[] getListOfPlayers() {
/*  44 */     String[] players = MinecraftServer.func_71276_C().func_71213_z();
/*  45 */     int length = players.length + 3;
/*  46 */     String[] list = new String[length];
/*  47 */     for (int i = 0; i < length; i++) {
/*     */       
/*  49 */       if (i < players.length) { list[i] = players[i]; }
/*  50 */       else if (i == players.length) { list[i] = "sendtoall"; }
/*  51 */       else if (i == players.length + 1) { list[i] = "sendtodimension:0"; }
/*  52 */       else if (i == players.length + 2) { list[i] = "sendtoallaround:0;50;50;50;5"; }
/*     */     
/*  54 */     }  return list;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_71515_b(ICommandSender commandSender, String[] stringArray) {
/*  60 */     if (stringArray.length <= 1)
/*     */     {
/*  62 */       throw new WrongUsageException(func_71518_a(commandSender), new Object[0]);
/*     */     }
/*     */ 
/*     */     
/*  66 */     String sendTo = stringArray[0];
/*     */     
/*  68 */     String text = "";
/*  69 */     for (int i = 1; i < stringArray.length; i++)
/*     */     {
/*  71 */       text = text + stringArray[i] + ((i == stringArray.length - 1) ? "" : " ");
/*     */     }
/*     */     
/*  74 */     String[] array = text.replace("{", "").replace("}", "").split(";");
/*     */     
/*  76 */     String title = array[0];
/*  77 */     String description = array[1];
/*  78 */     String category = array[2].toLowerCase();
/*  79 */     byte categoryID = (byte)JGNotificationHandler.getCategoryIDAll(category);
/*  80 */     byte iconID = Byte.parseByte(array[3]);
/*  81 */     if (iconID < 0) iconID = 0; 
/*  82 */     byte renderLocationID = Byte.parseByte(array[4]);
/*  83 */     if (renderLocationID < 0) renderLocationID = 0;  if (renderLocationID > 8) renderLocationID = 8; 
/*  84 */     int colorCode = Integer.parseInt(array[5]);
/*     */     
/*  86 */     if (sendTo.toLowerCase().equals("sendtoall")) {
/*     */       
/*  88 */       PD.sendToAll((IMessage)new JRMCorePData3(title, description, categoryID, iconID, renderLocationID, colorCode));
/*     */       
/*     */       return;
/*     */     } 
/*  92 */     if (sendTo.toLowerCase().contains("sendtodimension")) {
/*     */       
/*  94 */       int dimensionID = Integer.parseInt(sendTo.split(":")[1]);
/*  95 */       PD.sendToDimension((IMessage)new JRMCorePData3(title, description, categoryID, iconID, renderLocationID, colorCode), dimensionID);
/*     */       
/*     */       return;
/*     */     } 
/*  99 */     if (sendTo.toLowerCase().contains("sendtoallaround")) {
/*     */       
/* 101 */       String[] values = sendTo.split(":")[1].split(";");
/* 102 */       int[] data = new int[5];
/* 103 */       for (int j = 0; j < 5; ) { data[j] = Integer.parseInt(values[j]); j++; }
/*     */       
/* 105 */       PD.sendToAllAround((IMessage)new JRMCorePData3(title, description, categoryID, iconID, renderLocationID, colorCode), data[0], data[1], data[2], data[3], data[4]);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 110 */     EntityPlayerMP player = null;
/*     */ 
/*     */     
/*     */     try {
/* 114 */       player = func_82359_c(commandSender, sendTo);
/*     */     
/*     */     }
/* 117 */     catch (Exception exception) {}
/*     */     
/* 119 */     if (player != null) PD.sendTo((IMessage)new JRMCorePData3(title, description, categoryID, iconID, renderLocationID, colorCode), player);
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isUsernameIndex(int id) {
/* 125 */     return (id == 0);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\server\commands\CommandNotification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */