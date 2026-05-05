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
/*    */ public class CommandEmote extends CommandBase {
/*    */   private static final String __OBFID = "CL_00000351";
/*    */   
/*    */   public String func_71517_b() {
/* 15 */     return "me";
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_82362_a() {
/* 20 */     return 0;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender p_71518_1_) {
/* 26 */     return "commands.me.usage";
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
/* 31 */     if (p_71515_2_.length > 0) {
/* 32 */       IChatComponent iChatComponent = func_147176_a(p_71515_1_, p_71515_2_, 0, p_71515_1_.func_70003_b(1, "me"));
/* 33 */       MinecraftServer.func_71276_C().func_71203_ab().func_148539_a((IChatComponent)new ChatComponentTranslation("chat.type.emote", new Object[] { p_71515_1_.func_145748_c_(), iChatComponent }));
/*    */       
/*    */       return;
/*    */     } 
/* 37 */     throw new WrongUsageException("commands.me.usage", new Object[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
/* 42 */     return func_71530_a(p_71516_2_, MinecraftServer.func_71276_C().func_71213_z());
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\server\CommandEmote.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */