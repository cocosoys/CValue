/*    */ package net.minecraft.command.server;
/*    */ import com.mojang.authlib.GameProfile;
/*    */ import java.util.List;
/*    */ import net.minecraft.command.CommandBase;
/*    */ import net.minecraft.command.CommandException;
/*    */ import net.minecraft.command.ICommand;
/*    */ import net.minecraft.command.ICommandSender;
/*    */ import net.minecraft.command.WrongUsageException;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.util.ChatComponentText;
/*    */ import net.minecraft.util.ChatComponentTranslation;
/*    */ import net.minecraft.util.IChatComponent;
/*    */ 
/*    */ public class CommandWhitelist extends CommandBase {
/*    */   public String func_71517_b() {
/* 16 */     return "whitelist";
/*    */   }
/*    */   private static final String __OBFID = "CL_00001186";
/*    */   
/*    */   public int func_82362_a() {
/* 21 */     return 3;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender p_71518_1_) {
/* 27 */     return "commands.whitelist.usage";
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
/* 32 */     if (p_71515_2_.length >= 1) {
/* 33 */       MinecraftServer minecraftServer = MinecraftServer.func_71276_C();
/* 34 */       if (p_71515_2_[0].equals("on")) {
/* 35 */         minecraftServer.func_71203_ab().func_72371_a(true);
/* 36 */         func_152373_a(p_71515_1_, (ICommand)this, "commands.whitelist.enabled", new Object[0]); return;
/*    */       } 
/* 38 */       if (p_71515_2_[0].equals("off")) {
/* 39 */         minecraftServer.func_71203_ab().func_72371_a(false);
/* 40 */         func_152373_a(p_71515_1_, (ICommand)this, "commands.whitelist.disabled", new Object[0]); return;
/*    */       } 
/* 42 */       if (p_71515_2_[0].equals("list")) {
/* 43 */         p_71515_1_.func_145747_a((IChatComponent)new ChatComponentTranslation("commands.whitelist.list", new Object[] { Integer.valueOf((minecraftServer.func_71203_ab().func_152598_l()).length), Integer.valueOf((minecraftServer.func_71203_ab().func_72373_m()).length) }));
/*    */         
/* 45 */         String[] arrayOfString = minecraftServer.func_71203_ab().func_152598_l();
/* 46 */         p_71515_1_.func_145747_a((IChatComponent)new ChatComponentText(func_71527_a((Object[])arrayOfString))); return;
/*    */       } 
/* 48 */       if (p_71515_2_[0].equals("add")) {
/* 49 */         if (p_71515_2_.length < 2) {
/* 50 */           throw new WrongUsageException("commands.whitelist.add.usage", new Object[0]);
/*    */         }
/*    */         
/* 53 */         GameProfile gameProfile = minecraftServer.func_152358_ax().func_152655_a(p_71515_2_[1]);
/* 54 */         if (gameProfile == null) {
/* 55 */           throw new CommandException("commands.whitelist.add.failed", new Object[] { p_71515_2_[1] });
/*    */         }
/* 57 */         minecraftServer.func_71203_ab().func_152601_d(gameProfile);
/* 58 */         func_152373_a(p_71515_1_, (ICommand)this, "commands.whitelist.add.success", new Object[] { p_71515_2_[1] }); return;
/*    */       } 
/* 60 */       if (p_71515_2_[0].equals("remove")) {
/* 61 */         if (p_71515_2_.length < 2) {
/* 62 */           throw new WrongUsageException("commands.whitelist.remove.usage", new Object[0]);
/*    */         }
/*    */         
/* 65 */         GameProfile gameProfile = minecraftServer.func_71203_ab().func_152599_k().func_152706_a(p_71515_2_[1]);
/* 66 */         if (gameProfile == null) {
/* 67 */           throw new CommandException("commands.whitelist.remove.failed", new Object[] { p_71515_2_[1] });
/*    */         }
/* 69 */         minecraftServer.func_71203_ab().func_152597_c(gameProfile);
/* 70 */         func_152373_a(p_71515_1_, (ICommand)this, "commands.whitelist.remove.success", new Object[] { p_71515_2_[1] }); return;
/*    */       } 
/* 72 */       if (p_71515_2_[0].equals("reload")) {
/* 73 */         minecraftServer.func_71203_ab().func_72362_j();
/* 74 */         func_152373_a(p_71515_1_, (ICommand)this, "commands.whitelist.reloaded", new Object[0]);
/*    */         
/*    */         return;
/*    */       } 
/*    */     } 
/* 79 */     throw new WrongUsageException("commands.whitelist.usage", new Object[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
/* 84 */     if (p_71516_2_.length == 1) {
/* 85 */       return func_71530_a(p_71516_2_, new String[] { "on", "off", "list", "add", "remove", "reload" });
/*    */     }
/*    */     
/* 88 */     if (p_71516_2_.length == 2) {
/* 89 */       if (p_71516_2_[0].equals("remove"))
/* 90 */         return func_71530_a(p_71516_2_, MinecraftServer.func_71276_C().func_71203_ab().func_152598_l()); 
/* 91 */       if (p_71516_2_[0].equals("add")) {
/* 92 */         return func_71530_a(p_71516_2_, MinecraftServer.func_71276_C().func_152358_ax().func_152654_a());
/*    */       }
/*    */     } 
/*    */     
/* 96 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\server\CommandWhitelist.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */