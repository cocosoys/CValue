/*    */ package net.minecraft.command.server;
/*    */ 
/*    */ import com.mojang.authlib.GameProfile;
/*    */ import java.util.List;
/*    */ import net.minecraft.command.CommandBase;
/*    */ import net.minecraft.command.CommandException;
/*    */ import net.minecraft.command.ICommand;
/*    */ import net.minecraft.command.ICommandSender;
/*    */ import net.minecraft.command.WrongUsageException;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ 
/*    */ public class CommandPardonPlayer
/*    */   extends CommandBase {
/*    */   public String func_71517_b() {
/* 15 */     return "pardon";
/*    */   }
/*    */   private static final String __OBFID = "CL_00000747";
/*    */   
/*    */   public int func_82362_a() {
/* 20 */     return 3;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender p_71518_1_) {
/* 26 */     return "commands.unban.usage";
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_71519_b(ICommandSender p_71519_1_) {
/* 31 */     return (MinecraftServer.func_71276_C().func_71203_ab().func_152608_h().func_152689_b() && super.func_71519_b(p_71519_1_));
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
/* 36 */     if (p_71515_2_.length == 1 && p_71515_2_[0].length() > 0) {
/* 37 */       MinecraftServer minecraftServer = MinecraftServer.func_71276_C();
/* 38 */       GameProfile gameProfile = minecraftServer.func_71203_ab().func_152608_h().func_152703_a(p_71515_2_[0]);
/* 39 */       if (gameProfile == null) {
/* 40 */         throw new CommandException("commands.unban.failed", new Object[] { p_71515_2_[0] });
/*    */       }
/*    */       
/* 43 */       minecraftServer.func_71203_ab().func_152608_h().func_152684_c(gameProfile);
/* 44 */       func_152373_a(p_71515_1_, (ICommand)this, "commands.unban.success", new Object[] { p_71515_2_[0] });
/*    */       
/*    */       return;
/*    */     } 
/* 48 */     throw new WrongUsageException("commands.unban.usage", new Object[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
/* 53 */     if (p_71516_2_.length == 1) {
/* 54 */       return func_71530_a(p_71516_2_, MinecraftServer.func_71276_C().func_71203_ab().func_152608_h().func_152685_a());
/*    */     }
/*    */     
/* 57 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\server\CommandPardonPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */