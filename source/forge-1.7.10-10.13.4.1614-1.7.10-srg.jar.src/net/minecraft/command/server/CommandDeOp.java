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
/*    */ public class CommandDeOp
/*    */   extends CommandBase {
/*    */   public String func_71517_b() {
/* 15 */     return "deop";
/*    */   }
/*    */   private static final String __OBFID = "CL_00000244";
/*    */   
/*    */   public int func_82362_a() {
/* 20 */     return 3;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender p_71518_1_) {
/* 26 */     return "commands.deop.usage";
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
/* 31 */     if (p_71515_2_.length == 1 && p_71515_2_[0].length() > 0) {
/* 32 */       MinecraftServer minecraftServer = MinecraftServer.func_71276_C();
/* 33 */       GameProfile gameProfile = minecraftServer.func_71203_ab().func_152603_m().func_152700_a(p_71515_2_[0]);
/* 34 */       if (gameProfile == null) {
/* 35 */         throw new CommandException("commands.deop.failed", new Object[] { p_71515_2_[0] });
/*    */       }
/*    */       
/* 38 */       minecraftServer.func_71203_ab().func_152610_b(gameProfile);
/* 39 */       func_152373_a(p_71515_1_, (ICommand)this, "commands.deop.success", new Object[] { p_71515_2_[0] });
/*    */       
/*    */       return;
/*    */     } 
/* 43 */     throw new WrongUsageException("commands.deop.usage", new Object[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
/* 48 */     if (p_71516_2_.length == 1) {
/* 49 */       return func_71530_a(p_71516_2_, MinecraftServer.func_71276_C().func_71203_ab().func_152606_n());
/*    */     }
/*    */     
/* 52 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\server\CommandDeOp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */