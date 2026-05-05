/*    */ package net.minecraft.command.server;
/*    */ 
/*    */ import com.mojang.authlib.GameProfile;
/*    */ import java.util.List;
/*    */ import net.minecraft.command.CommandBase;
/*    */ import net.minecraft.command.CommandException;
/*    */ import net.minecraft.command.ICommand;
/*    */ import net.minecraft.command.ICommandSender;
/*    */ import net.minecraft.command.WrongUsageException;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.server.management.UserListBansEntry;
/*    */ import net.minecraft.server.management.UserListEntry;
/*    */ 
/*    */ public class CommandBanPlayer extends CommandBase {
/*    */   private static final String __OBFID = "CL_00000165";
/*    */   
/*    */   public String func_71517_b() {
/* 19 */     return "ban";
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_82362_a() {
/* 24 */     return 3;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender p_71518_1_) {
/* 30 */     return "commands.ban.usage";
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_71519_b(ICommandSender p_71519_1_) {
/* 35 */     return (MinecraftServer.func_71276_C().func_71203_ab().func_152608_h().func_152689_b() && super.func_71519_b(p_71519_1_));
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
/* 40 */     if (p_71515_2_.length >= 1 && p_71515_2_[0].length() > 0) {
/* 41 */       MinecraftServer minecraftServer = MinecraftServer.func_71276_C();
/* 42 */       GameProfile gameProfile = minecraftServer.func_152358_ax().func_152655_a(p_71515_2_[0]);
/* 43 */       if (gameProfile == null) {
/* 44 */         throw new CommandException("commands.ban.failed", new Object[] { p_71515_2_[0] });
/*    */       }
/*    */       
/* 47 */       String str = null;
/* 48 */       if (p_71515_2_.length >= 2) {
/* 49 */         str = func_147178_a(p_71515_1_, p_71515_2_, 1).func_150260_c();
/*    */       }
/*    */       
/* 52 */       UserListBansEntry userListBansEntry = new UserListBansEntry(gameProfile, null, p_71515_1_.func_70005_c_(), null, str);
/* 53 */       minecraftServer.func_71203_ab().func_152608_h().func_152687_a((UserListEntry)userListBansEntry);
/*    */       
/* 55 */       EntityPlayerMP entityPlayerMP = minecraftServer.func_71203_ab().func_152612_a(p_71515_2_[0]);
/* 56 */       if (entityPlayerMP != null) {
/* 57 */         entityPlayerMP.field_71135_a.func_147360_c("You are banned from this server.");
/*    */       }
/*    */       
/* 60 */       func_152373_a(p_71515_1_, (ICommand)this, "commands.ban.success", new Object[] { p_71515_2_[0] });
/*    */       
/*    */       return;
/*    */     } 
/* 64 */     throw new WrongUsageException("commands.ban.usage", new Object[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
/* 69 */     if (p_71516_2_.length >= 1) {
/* 70 */       return func_71530_a(p_71516_2_, MinecraftServer.func_71276_C().func_71213_z());
/*    */     }
/*    */     
/* 73 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\server\CommandBanPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */