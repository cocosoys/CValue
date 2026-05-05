/*    */ package net.minecraft.command.server;
/*    */ 
/*    */ import com.google.gson.JsonParseException;
/*    */ import java.util.List;
/*    */ import net.minecraft.command.CommandBase;
/*    */ import net.minecraft.command.ICommandSender;
/*    */ import net.minecraft.command.SyntaxErrorException;
/*    */ import net.minecraft.command.WrongUsageException;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.util.IChatComponent;
/*    */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*    */ 
/*    */ public class CommandMessageRaw extends CommandBase {
/*    */   private static final String __OBFID = "CL_00000667";
/*    */   
/*    */   public String func_71517_b() {
/* 18 */     return "tellraw";
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_82362_a() {
/* 23 */     return 2;
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender p_71518_1_) {
/* 28 */     return "commands.tellraw.usage";
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
/* 33 */     if (p_71515_2_.length < 2) throw new WrongUsageException("commands.tellraw.usage", new Object[0]);
/*    */     
/* 35 */     EntityPlayerMP entityPlayerMP = func_82359_c(p_71515_1_, p_71515_2_[0]);
/* 36 */     String str = func_82360_a(p_71515_1_, p_71515_2_, 1);
/*    */     
/*    */     try {
/* 39 */       IChatComponent iChatComponent = IChatComponent.Serializer.func_150699_a(str);
/* 40 */       entityPlayerMP.func_145747_a(iChatComponent);
/* 41 */     } catch (JsonParseException jsonParseException) {
/* 42 */       Throwable throwable = ExceptionUtils.getRootCause((Throwable)jsonParseException);
/* 43 */       throw new SyntaxErrorException("commands.tellraw.jsonException", new Object[] { (throwable == null) ? "" : throwable.getMessage() });
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
/* 49 */     if (p_71516_2_.length == 1) {
/* 50 */       return func_71530_a(p_71516_2_, MinecraftServer.func_71276_C().func_71213_z());
/*    */     }
/*    */     
/* 53 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_82358_a(String[] p_82358_1_, int p_82358_2_) {
/* 58 */     return (p_82358_2_ == 0);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\server\CommandMessageRaw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */