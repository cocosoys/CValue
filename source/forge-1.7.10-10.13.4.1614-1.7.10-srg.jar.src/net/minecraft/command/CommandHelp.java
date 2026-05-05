/*    */ package net.minecraft.command;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import net.minecraft.event.ClickEvent;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.util.ChatComponentTranslation;
/*    */ import net.minecraft.util.EnumChatFormatting;
/*    */ import net.minecraft.util.IChatComponent;
/*    */ import net.minecraft.util.MathHelper;
/*    */ 
/*    */ public class CommandHelp
/*    */   extends CommandBase {
/*    */   public String func_71517_b() {
/* 17 */     return "help";
/*    */   }
/*    */   private static final String __OBFID = "CL_00000529";
/*    */   
/*    */   public int func_82362_a() {
/* 22 */     return 0;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender p_71518_1_) {
/* 28 */     return "commands.help.usage";
/*    */   }
/*    */ 
/*    */   
/*    */   public List func_71514_a() {
/* 33 */     return Arrays.asList(new String[] { "?" });
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
/* 38 */     List<ICommand> list = func_71534_d(p_71515_1_);
/* 39 */     byte b1 = 7;
/* 40 */     int i = (list.size() - 1) / b1;
/* 41 */     byte b2 = 0;
/*    */     
/*    */     try {
/* 44 */       b2 = (p_71515_2_.length == 0) ? 0 : (func_71532_a(p_71515_1_, p_71515_2_[0], 1, i + 1) - 1);
/* 45 */     } catch (NumberInvalidException numberInvalidException) {
/*    */       
/* 47 */       Map map = func_71535_c();
/* 48 */       ICommand iCommand = (ICommand)map.get(p_71515_2_[0]);
/*    */       
/* 50 */       if (iCommand != null)
/*    */       {
/* 52 */         throw new WrongUsageException(iCommand.func_71518_a(p_71515_1_), new Object[0]); } 
/* 53 */       if (MathHelper.func_82715_a(p_71515_2_[0], -1) != -1) {
/* 54 */         throw numberInvalidException;
/*    */       }
/* 56 */       throw new CommandNotFoundException();
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 61 */     int j = Math.min((b2 + 1) * b1, list.size());
/*    */     
/* 63 */     ChatComponentTranslation chatComponentTranslation = new ChatComponentTranslation("commands.help.header", new Object[] { Integer.valueOf(b2 + 1), Integer.valueOf(i + 1) });
/* 64 */     chatComponentTranslation.func_150256_b().func_150238_a(EnumChatFormatting.DARK_GREEN);
/* 65 */     p_71515_1_.func_145747_a((IChatComponent)chatComponentTranslation);
/*    */     
/* 67 */     for (int k = b2 * b1; k < j; k++) {
/* 68 */       ICommand iCommand = list.get(k);
/*    */       
/* 70 */       ChatComponentTranslation chatComponentTranslation1 = new ChatComponentTranslation(iCommand.func_71518_a(p_71515_1_), new Object[0]);
/* 71 */       chatComponentTranslation1.func_150256_b().func_150241_a(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/" + iCommand.func_71517_b() + " "));
/* 72 */       p_71515_1_.func_145747_a((IChatComponent)chatComponentTranslation1);
/*    */     } 
/*    */     
/* 75 */     if (b2 == 0 && p_71515_1_ instanceof net.minecraft.entity.player.EntityPlayer) {
/* 76 */       ChatComponentTranslation chatComponentTranslation1 = new ChatComponentTranslation("commands.help.footer", new Object[0]);
/* 77 */       chatComponentTranslation1.func_150256_b().func_150238_a(EnumChatFormatting.GREEN);
/* 78 */       p_71515_1_.func_145747_a((IChatComponent)chatComponentTranslation1);
/*    */     } 
/*    */   }
/*    */   
/*    */   protected List func_71534_d(ICommandSender p_71534_1_) {
/* 83 */     List<Comparable> list = MinecraftServer.func_71276_C().func_71187_D().func_71557_a(p_71534_1_);
/* 84 */     Collections.sort(list);
/* 85 */     return list;
/*    */   }
/*    */   
/*    */   protected Map func_71535_c() {
/* 89 */     return MinecraftServer.func_71276_C().func_71187_D().func_71555_a();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\CommandHelp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */