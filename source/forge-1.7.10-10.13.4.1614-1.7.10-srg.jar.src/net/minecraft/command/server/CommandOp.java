/*    */ package net.minecraft.command.server;
/*    */ 
/*    */ import com.mojang.authlib.GameProfile;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.minecraft.command.CommandBase;
/*    */ import net.minecraft.command.CommandException;
/*    */ import net.minecraft.command.ICommand;
/*    */ import net.minecraft.command.ICommandSender;
/*    */ import net.minecraft.command.WrongUsageException;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ 
/*    */ public class CommandOp extends CommandBase {
/*    */   public String func_71517_b() {
/* 15 */     return "op";
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_82362_a() {
/* 20 */     return 3;
/*    */   }
/*    */   
/*    */   private static final String __OBFID = "CL_00000694";
/*    */   
/*    */   public String func_71518_a(ICommandSender p_71518_1_) {
/* 26 */     return "commands.op.usage";
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
/* 31 */     if (p_71515_2_.length == 1 && p_71515_2_[0].length() > 0) {
/* 32 */       MinecraftServer minecraftServer = MinecraftServer.func_71276_C();
/* 33 */       GameProfile gameProfile = minecraftServer.func_152358_ax().func_152655_a(p_71515_2_[0]);
/* 34 */       if (gameProfile == null) {
/* 35 */         throw new CommandException("commands.op.failed", new Object[] { p_71515_2_[0] });
/*    */       }
/*    */       
/* 38 */       minecraftServer.func_71203_ab().func_152605_a(gameProfile);
/* 39 */       func_152373_a(p_71515_1_, (ICommand)this, "commands.op.success", new Object[] { p_71515_2_[0] });
/*    */       
/*    */       return;
/*    */     } 
/* 43 */     throw new WrongUsageException("commands.op.usage", new Object[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
/* 48 */     if (p_71516_2_.length == 1) {
/* 49 */       String str = p_71516_2_[p_71516_2_.length - 1];
/* 50 */       ArrayList<String> arrayList = new ArrayList();
/*    */       
/* 52 */       for (GameProfile gameProfile : MinecraftServer.func_71276_C().func_152357_F()) {
/* 53 */         if (!MinecraftServer.func_71276_C().func_71203_ab().func_152596_g(gameProfile) && func_71523_a(str, gameProfile.getName())) {
/* 54 */           arrayList.add(gameProfile.getName());
/*    */         }
/*    */       } 
/*    */       
/* 58 */       return arrayList;
/*    */     } 
/*    */     
/* 61 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\server\CommandOp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */