/*     */ package net.minecraft.command;
/*     */ import net.minecraft.command.server.CommandAchievement;
/*     */ import net.minecraft.command.server.CommandBroadcast;
/*     */ import net.minecraft.command.server.CommandPardonIp;
/*     */ import net.minecraft.command.server.CommandSummon;
/*     */ import net.minecraft.command.server.CommandTestForBlock;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ 
/*     */ public class ServerCommandManager extends CommandHandler implements IAdminCommand {
/*     */   public ServerCommandManager() {
/*  15 */     func_71560_a(new CommandTime());
/*  16 */     func_71560_a(new CommandGameMode());
/*  17 */     func_71560_a(new CommandDifficulty());
/*  18 */     func_71560_a(new CommandDefaultGameMode());
/*  19 */     func_71560_a(new CommandKill());
/*  20 */     func_71560_a(new CommandToggleDownfall());
/*  21 */     func_71560_a(new CommandWeather());
/*  22 */     func_71560_a(new CommandXP());
/*  23 */     func_71560_a((ICommand)new CommandTeleport());
/*  24 */     func_71560_a(new CommandGive());
/*  25 */     func_71560_a(new CommandEffect());
/*  26 */     func_71560_a(new CommandEnchant());
/*  27 */     func_71560_a((ICommand)new CommandEmote());
/*  28 */     func_71560_a(new CommandShowSeed());
/*  29 */     func_71560_a(new CommandHelp());
/*  30 */     func_71560_a(new CommandDebug());
/*  31 */     func_71560_a((ICommand)new CommandMessage());
/*  32 */     func_71560_a((ICommand)new CommandBroadcast());
/*  33 */     func_71560_a(new CommandSetSpawnpoint());
/*  34 */     func_71560_a((ICommand)new CommandSetDefaultSpawnpoint());
/*  35 */     func_71560_a(new CommandGameRule());
/*  36 */     func_71560_a(new CommandClearInventory());
/*  37 */     func_71560_a((ICommand)new CommandTestFor());
/*  38 */     func_71560_a(new CommandSpreadPlayers());
/*  39 */     func_71560_a(new CommandPlaySound());
/*  40 */     func_71560_a((ICommand)new CommandScoreboard());
/*  41 */     func_71560_a((ICommand)new CommandAchievement());
/*  42 */     func_71560_a((ICommand)new CommandSummon());
/*  43 */     func_71560_a((ICommand)new CommandSetBlock());
/*  44 */     func_71560_a((ICommand)new CommandTestForBlock());
/*  45 */     func_71560_a((ICommand)new CommandMessageRaw());
/*     */     
/*  47 */     if (MinecraftServer.func_71276_C().func_71262_S()) {
/*  48 */       func_71560_a((ICommand)new CommandOp());
/*  49 */       func_71560_a((ICommand)new CommandDeOp());
/*  50 */       func_71560_a((ICommand)new CommandStop());
/*  51 */       func_71560_a((ICommand)new CommandSaveAll());
/*  52 */       func_71560_a((ICommand)new CommandSaveOff());
/*  53 */       func_71560_a((ICommand)new CommandSaveOn());
/*  54 */       func_71560_a((ICommand)new CommandBanIp());
/*  55 */       func_71560_a((ICommand)new CommandPardonIp());
/*  56 */       func_71560_a((ICommand)new CommandBanPlayer());
/*  57 */       func_71560_a((ICommand)new CommandListBans());
/*  58 */       func_71560_a((ICommand)new CommandPardonPlayer());
/*  59 */       func_71560_a(new CommandServerKick());
/*  60 */       func_71560_a((ICommand)new CommandListPlayers());
/*  61 */       func_71560_a((ICommand)new CommandWhitelist());
/*  62 */       func_71560_a(new CommandSetPlayerTimeout());
/*  63 */       func_71560_a((ICommand)new CommandNetstat());
/*     */     } else {
/*  65 */       func_71560_a((ICommand)new CommandPublishLocalServer());
/*     */     } 
/*     */ 
/*     */     
/*  69 */     CommandBase.func_71529_a(this);
/*     */   }
/*     */   private static final String __OBFID = "CL_00000922";
/*     */   
/*     */   public void func_152372_a(ICommandSender p_152372_1_, ICommand p_152372_2_, int p_152372_3_, String p_152372_4_, Object... p_152372_5_) {
/*  74 */     boolean bool = true;
/*     */     
/*  76 */     if (p_152372_1_ instanceof net.minecraft.command.server.CommandBlockLogic && 
/*  77 */       !(MinecraftServer.func_71276_C()).field_71305_c[0].func_82736_K().func_82766_b("commandBlockOutput")) {
/*  78 */       bool = false;
/*     */     }
/*     */ 
/*     */     
/*  82 */     ChatComponentTranslation chatComponentTranslation = new ChatComponentTranslation("chat.type.admin", new Object[] { p_152372_1_.func_70005_c_(), new ChatComponentTranslation(p_152372_4_, p_152372_5_) });
/*  83 */     chatComponentTranslation.func_150256_b().func_150238_a(EnumChatFormatting.GRAY);
/*  84 */     chatComponentTranslation.func_150256_b().func_150217_b(Boolean.valueOf(true));
/*     */     
/*  86 */     if (bool) {
/*  87 */       for (EntityPlayer entityPlayer : (MinecraftServer.func_71276_C().func_71203_ab()).field_72404_b) {
/*  88 */         if (entityPlayer != p_152372_1_ && MinecraftServer.func_71276_C().func_71203_ab().func_152596_g(entityPlayer.func_146103_bH()) && p_152372_2_.func_71519_b((ICommandSender)entityPlayer) && (
/*  89 */           !(p_152372_1_ instanceof net.minecraft.network.rcon.RConConsoleSource) || MinecraftServer.func_71276_C().func_152363_m())) {
/*  90 */           entityPlayer.func_145747_a((IChatComponent)chatComponentTranslation);
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*  96 */     if (p_152372_1_ != MinecraftServer.func_71276_C()) {
/*  97 */       MinecraftServer.func_71276_C().func_145747_a((IChatComponent)chatComponentTranslation);
/*     */     }
/*     */     
/* 100 */     if ((p_152372_3_ & 0x1) != 1)
/* 101 */       p_152372_1_.func_145747_a((IChatComponent)new ChatComponentTranslation(p_152372_4_, p_152372_5_)); 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\ServerCommandManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */