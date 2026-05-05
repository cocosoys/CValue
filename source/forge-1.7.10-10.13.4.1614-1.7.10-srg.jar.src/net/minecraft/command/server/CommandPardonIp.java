/*    */ package net.minecraft.command.server;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.regex.Matcher;
/*    */ import net.minecraft.command.CommandBase;
/*    */ import net.minecraft.command.ICommand;
/*    */ import net.minecraft.command.ICommandSender;
/*    */ import net.minecraft.command.SyntaxErrorException;
/*    */ import net.minecraft.command.WrongUsageException;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ 
/*    */ public class CommandPardonIp extends CommandBase {
/*    */   public String func_71517_b() {
/* 14 */     return "pardon-ip";
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_82362_a() {
/* 19 */     return 3;
/*    */   }
/*    */   
/*    */   private static final String __OBFID = "CL_00000720";
/*    */   
/*    */   public boolean func_71519_b(ICommandSender p_71519_1_) {
/* 25 */     return (MinecraftServer.func_71276_C().func_71203_ab().func_72363_f().func_152689_b() && super.func_71519_b(p_71519_1_));
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender p_71518_1_) {
/* 30 */     return "commands.unbanip.usage";
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
/* 35 */     if (p_71515_2_.length == 1 && p_71515_2_[0].length() > 1) {
/* 36 */       Matcher matcher = CommandBanIp.field_147211_a.matcher(p_71515_2_[0]);
/*    */       
/* 38 */       if (matcher.matches()) {
/* 39 */         MinecraftServer.func_71276_C().func_71203_ab().func_72363_f().func_152684_c(p_71515_2_[0]);
/* 40 */         func_152373_a(p_71515_1_, (ICommand)this, "commands.unbanip.success", new Object[] { p_71515_2_[0] });
/*    */         return;
/*    */       } 
/* 43 */       throw new SyntaxErrorException("commands.unbanip.invalid", new Object[0]);
/*    */     } 
/*    */ 
/*    */     
/* 47 */     throw new WrongUsageException("commands.unbanip.usage", new Object[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
/* 52 */     if (p_71516_2_.length == 1) {
/* 53 */       return func_71530_a(p_71516_2_, MinecraftServer.func_71276_C().func_71203_ab().func_72363_f().func_152685_a());
/*    */     }
/*    */     
/* 56 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\server\CommandPardonIp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */