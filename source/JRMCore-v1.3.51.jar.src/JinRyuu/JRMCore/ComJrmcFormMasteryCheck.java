/*     */ package JinRyuu.JRMCore;
/*     */ 
/*     */ import JinRyuu.JRMCore.server.JGPlayerMP;
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
/*     */ public class ComJrmcFormMasteryCheck extends CommandBase {
/*  19 */   private final String name = "jrmcformmasterycheck";
/*     */   
/*     */   public String func_71517_b() {
/*  22 */     return "jrmcformmasterycheck";
/*     */   }
/*     */   
/*     */   public String func_71518_a(ICommandSender icommandsender) {
/*  26 */     return "/jrmcformmasterycheck [playerName]. ";
/*     */   }
/*     */   
/*     */   public int func_82362_a() {
/*  30 */     return 0; } public boolean func_71519_b(ICommandSender par1ICommandSender) {
/*  31 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List func_71516_a(ICommandSender commandSender, String[] stringArray) {
/*  38 */     int length = stringArray.length;
/*  39 */     switch (length) { case 1:
/*  40 */         return func_71530_a(stringArray, getListOfPlayers()); }
/*  41 */      return null;
/*     */   }
/*     */   
/*     */   protected String[] getListOfPlayers() {
/*  45 */     return MinecraftServer.func_71276_C().func_71213_z();
/*     */   }
/*     */   private NBTTagCompound nbt(EntityPlayer p, String s) {
/*  48 */     return JRMCoreH.nbt((Entity)p, s);
/*     */   }
/*     */   
/*     */   private void notifyAdmins(ICommandSender commandSender, String string, Object[] objects) {
/*  52 */     func_152373_a(commandSender, (ICommand)this, string, objects);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71515_b(ICommandSender commandSender, String[] stringArray) {
/*     */     EntityPlayerMP player;
/*  58 */     if (stringArray.length <= 0)
/*     */     {
/*  60 */       throw new WrongUsageException(func_71518_a(commandSender), new Object[0]);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  66 */     int playerNameID = 0;
/*     */     
/*  68 */     if (stringArray.length > 0) {
/*     */       
/*  70 */       player = func_82359_c(commandSender, stringArray[0]);
/*     */     }
/*     */     else {
/*     */       
/*  74 */       player = func_71521_c(commandSender);
/*     */     } 
/*     */     
/*  77 */     String entitycommansender = "Console";
/*  78 */     EntityPlayerMP commansender = null;
/*     */     
/*     */     try {
/*  81 */       commansender = func_71521_c(commandSender);
/*  82 */       entitycommansender = commansender.func_70005_c_();
/*  83 */     } catch (Exception exception) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  98 */     if (player != null) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 103 */       JGPlayerMP playerMP = new JGPlayerMP(player);
/* 104 */       NBTTagCompound nbt = nbt((EntityPlayer)player, "pres");
/* 105 */       playerMP.setNBT(nbt);
/* 106 */       int race = playerMP.getRace();
/*     */ 
/*     */       
/* 109 */       String[] masteries = JRMCoreH.getFormMasteryData((EntityPlayer)player).split(";");
/*     */       
/* 111 */       String masteryValues = "[Form Mastery Points]:";
/* 112 */       int length = masteries.length;
/* 113 */       int i = 0;
/* 114 */       for (String s : masteries) {
/* 115 */         String[] values = s.split(",");
/* 116 */         if (JRMCoreH.isRaceSaiyan(race) && (values[0].equals(JRMCoreH.trans[race][12]) || values[0].equals(JRMCoreH.trans[race][13]))) {
/* 117 */           i++;
/*     */         } else {
/*     */           
/* 120 */           masteryValues = masteryValues + " (" + values[0] + " Lvl: " + values[1] + ")" + ((i + 1 < length) ? "," : "");
/* 121 */           i++;
/*     */         } 
/*     */       } 
/*     */       
/* 125 */       if (commansender != null) {
/* 126 */         ChatStyle color = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW);
/* 127 */         commansender.func_145747_a((new ChatComponentText(masteryValues)).func_150255_a(color));
/*     */       } else {
/*     */         
/* 130 */         JRMCoreH.log(masteryValues);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\ComJrmcFormMasteryCheck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */