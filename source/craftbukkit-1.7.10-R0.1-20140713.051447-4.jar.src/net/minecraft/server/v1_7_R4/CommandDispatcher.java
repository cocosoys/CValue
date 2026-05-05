/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CommandDispatcher
/*     */   extends CommandHandler
/*     */   implements ICommandDispatcher
/*     */ {
/*     */   public CommandDispatcher() {
/*  15 */     a(new CommandTime());
/*  16 */     a(new CommandGamemode());
/*  17 */     a(new CommandDifficulty());
/*  18 */     a(new CommandGamemodeDefault());
/*  19 */     a(new CommandKill());
/*  20 */     a(new CommandToggleDownfall());
/*  21 */     a(new CommandWeather());
/*  22 */     a(new CommandXp());
/*  23 */     a(new CommandTp());
/*  24 */     a(new CommandGive());
/*  25 */     a(new CommandEffect());
/*  26 */     a(new CommandEnchant());
/*  27 */     a(new CommandMe());
/*  28 */     a(new CommandSeed());
/*  29 */     a(new CommandHelp());
/*  30 */     a(new CommandDebug());
/*  31 */     a(new CommandTell());
/*  32 */     a(new CommandSay());
/*  33 */     a(new CommandSpawnpoint());
/*  34 */     a(new CommandSetWorldSpawn());
/*  35 */     a(new CommandGamerule());
/*  36 */     a(new CommandClear());
/*  37 */     a(new CommandTestFor());
/*  38 */     a(new CommandSpreadPlayers());
/*  39 */     a(new CommandPlaySound());
/*  40 */     a(new CommandScoreboard());
/*  41 */     a(new CommandAchievement());
/*  42 */     a(new CommandSummon());
/*  43 */     a(new CommandSetBlock());
/*  44 */     a(new CommandTestForBlock());
/*  45 */     a(new CommandTellRaw());
/*     */     
/*  47 */     if (MinecraftServer.getServer().X()) {
/*  48 */       a(new CommandOp());
/*  49 */       a(new CommandDeop());
/*  50 */       a(new CommandStop());
/*  51 */       a(new CommandSaveAll());
/*  52 */       a(new CommandSaveOff());
/*  53 */       a(new CommandSaveOn());
/*  54 */       a(new CommandBanIp());
/*  55 */       a(new CommandPardonIP());
/*  56 */       a(new CommandBan());
/*  57 */       a(new CommandBanList());
/*  58 */       a(new CommandPardon());
/*  59 */       a(new CommandKick());
/*  60 */       a(new CommandList());
/*  61 */       a(new CommandWhitelist());
/*  62 */       a(new CommandIdleTimeout());
/*  63 */       a(new CommandNetstat());
/*     */     } else {
/*  65 */       a(new CommandPublish());
/*     */     } 
/*     */ 
/*     */     
/*  69 */     CommandAbstract.a(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(ICommandListener paramICommandListener, ICommand paramICommand, int paramInt, String paramString, Object... paramVarArgs) {
/*  74 */     boolean bool = true;
/*     */     
/*  76 */     if (paramICommandListener instanceof CommandBlockListenerAbstract && 
/*  77 */       !(MinecraftServer.getServer()).worldServer[0].getGameRules().getBoolean("commandBlockOutput")) {
/*  78 */       bool = false;
/*     */     }
/*     */ 
/*     */     
/*  82 */     ChatMessage chatMessage = new ChatMessage("chat.type.admin", new Object[] { paramICommandListener.getName(), new ChatMessage(paramString, paramVarArgs) });
/*  83 */     chatMessage.getChatModifier().setColor(EnumChatFormat.GRAY);
/*  84 */     chatMessage.getChatModifier().setItalic(Boolean.valueOf(true));
/*     */     
/*  86 */     if (bool) {
/*  87 */       for (EntityHuman entityHuman : (MinecraftServer.getServer().getPlayerList()).players) {
/*  88 */         if (entityHuman != paramICommandListener && MinecraftServer.getServer().getPlayerList().isOp(entityHuman.getProfile()) && paramICommand.canUse(entityHuman) && (
/*  89 */           !(paramICommandListener instanceof RemoteControlCommandListener) || MinecraftServer.getServer().m())) {
/*  90 */           entityHuman.sendMessage(chatMessage);
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*  96 */     if (paramICommandListener != MinecraftServer.getServer()) {
/*  97 */       MinecraftServer.getServer().sendMessage(chatMessage);
/*     */     }
/*     */     
/* 100 */     if ((paramInt & 0x1) != 1)
/* 101 */       paramICommandListener.sendMessage(new ChatMessage(paramString, paramVarArgs)); 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\CommandDispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */