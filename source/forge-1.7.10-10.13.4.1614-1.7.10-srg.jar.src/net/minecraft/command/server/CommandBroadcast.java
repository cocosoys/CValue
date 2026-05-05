/*    */ package net.minecraft.command.server;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.command.CommandBase;
/*    */ import net.minecraft.command.ICommandSender;
/*    */ import net.minecraft.command.WrongUsageException;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.util.ChatComponentTranslation;
/*    */ import net.minecraft.util.IChatComponent;
/*    */ 
/*    */ public class CommandBroadcast extends CommandBase {
/*    */   private static final String __OBFID = "CL_00000191";
/*    */   
/*    */   public String func_71517_b() {
/* 15 */     return "say";
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_82362_a() {
/* 20 */     return 1;
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender p_71518_1_) {
/* 25 */     return "commands.say.usage";
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
/* 30 */     if (p_71515_2_.length > 0 && p_71515_2_[0].length() > 0) {
/* 31 */       IChatComponent iChatComponent = func_147176_a(p_71515_1_, p_71515_2_, 0, true);
/* 32 */       MinecraftServer.func_71276_C().func_71203_ab().func_148539_a((IChatComponent)new ChatComponentTranslation("chat.type.announcement", new Object[] { p_71515_1_.func_70005_c_(), iChatComponent }));
/*    */       
/*    */       return;
/*    */     } 
/* 36 */     throw new WrongUsageException("commands.say.usage", new Object[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
/* 41 */     if (p_71516_2_.length >= 1) {
/* 42 */       return func_71530_a(p_71516_2_, MinecraftServer.func_71276_C().func_71213_z());
/*    */     }
/*    */     
/* 45 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\server\CommandBroadcast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */