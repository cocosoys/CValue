/*     */ package net.minecraftforge.client;
/*     */ 
/*     */ import cpw.mods.fml.client.FMLClientHandler;
/*     */ import cpw.mods.fml.common.eventhandler.Event;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.command.CommandException;
/*     */ import net.minecraft.command.CommandHandler;
/*     */ import net.minecraft.command.ICommand;
/*     */ import net.minecraft.command.ICommandSender;
/*     */ import net.minecraft.command.WrongUsageException;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import net.minecraftforge.event.CommandEvent;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ClientCommandHandler
/*     */   extends CommandHandler
/*     */ {
/*  29 */   public static final ClientCommandHandler instance = new ClientCommandHandler();
/*     */   
/*  31 */   public String[] latestAutoComplete = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int executeCommand(ICommandSender sender, String message) {
/*  40 */     message = message.trim();
/*     */     
/*  42 */     if (message.startsWith("/"))
/*     */     {
/*  44 */       message = message.substring(1);
/*     */     }
/*     */     
/*  47 */     String[] temp = message.split(" ");
/*  48 */     String[] args = new String[temp.length - 1];
/*  49 */     String commandName = temp[0];
/*  50 */     System.arraycopy(temp, 1, args, 0, args.length);
/*  51 */     ICommand icommand = (ICommand)getCommands().get(commandName);
/*     */ 
/*     */     
/*     */     try {
/*  55 */       if (icommand == null)
/*     */       {
/*  57 */         return 0;
/*     */       }
/*     */       
/*  60 */       if (icommand.canCommandSenderUseCommand(sender)) {
/*     */         
/*  62 */         CommandEvent event = new CommandEvent(icommand, sender, args);
/*  63 */         if (MinecraftForge.EVENT_BUS.post((Event)event)) {
/*     */           
/*  65 */           if (event.exception != null)
/*     */           {
/*  67 */             throw event.exception;
/*     */           }
/*  69 */           return 0;
/*     */         } 
/*     */         
/*  72 */         icommand.processCommand(sender, args);
/*  73 */         return 1;
/*     */       } 
/*     */ 
/*     */       
/*  77 */       sender.addChatMessage((IChatComponent)format(EnumChatFormatting.RED, "commands.generic.permission", new Object[0]));
/*     */     
/*     */     }
/*  80 */     catch (WrongUsageException wue) {
/*     */       
/*  82 */       sender.addChatMessage((IChatComponent)format(EnumChatFormatting.RED, "commands.generic.usage", new Object[] { format(EnumChatFormatting.RED, wue.getMessage(), wue.getErrorOjbects()) }));
/*     */     }
/*  84 */     catch (CommandException ce) {
/*     */       
/*  86 */       sender.addChatMessage((IChatComponent)format(EnumChatFormatting.RED, ce.getMessage(), ce.getErrorOjbects()));
/*     */     }
/*  88 */     catch (Throwable t) {
/*     */       
/*  90 */       sender.addChatMessage((IChatComponent)format(EnumChatFormatting.RED, "commands.generic.exception", new Object[0]));
/*  91 */       t.printStackTrace();
/*     */     } 
/*     */     
/*  94 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private ChatComponentTranslation format(EnumChatFormatting color, String str, Object... args) {
/* 100 */     ChatComponentTranslation ret = new ChatComponentTranslation(str, args);
/* 101 */     ret.getChatStyle().setColor(color);
/* 102 */     return ret;
/*     */   }
/*     */ 
/*     */   
/*     */   public void autoComplete(String leftOfCursor, String full) {
/* 107 */     this.latestAutoComplete = null;
/*     */     
/* 109 */     if (leftOfCursor.charAt(0) == '/') {
/*     */       
/* 111 */       leftOfCursor = leftOfCursor.substring(1);
/*     */       
/* 113 */       Minecraft mc = FMLClientHandler.instance().getClient();
/* 114 */       if (mc.currentScreen instanceof net.minecraft.client.gui.GuiChat) {
/*     */ 
/*     */         
/* 117 */         List<String> commands = getPossibleCommands((ICommandSender)mc.thePlayer, leftOfCursor);
/* 118 */         if (commands != null && !commands.isEmpty()) {
/*     */           
/* 120 */           if (leftOfCursor.indexOf(' ') == -1) {
/*     */             
/* 122 */             for (int i = 0; i < commands.size(); i++)
/*     */             {
/* 124 */               commands.set(i, EnumChatFormatting.GRAY + "/" + (String)commands.get(i) + EnumChatFormatting.RESET);
/*     */             }
/*     */           }
/*     */           else {
/*     */             
/* 129 */             for (int i = 0; i < commands.size(); i++)
/*     */             {
/* 131 */               commands.set(i, EnumChatFormatting.GRAY + (String)commands.get(i) + EnumChatFormatting.RESET);
/*     */             }
/*     */           } 
/*     */           
/* 135 */           this.latestAutoComplete = commands.<String>toArray(new String[commands.size()]);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\client\ClientCommandHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */