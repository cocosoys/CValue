/*    */ package net.minecraft.command.server;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.command.CommandBase;
/*    */ import net.minecraft.command.ICommandSender;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.util.ChatComponentText;
/*    */ import net.minecraft.util.ChatComponentTranslation;
/*    */ import net.minecraft.util.IChatComponent;
/*    */ 
/*    */ public class CommandListBans extends CommandBase {
/*    */   public String func_71517_b() {
/* 13 */     return "banlist";
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_82362_a() {
/* 18 */     return 3;
/*    */   }
/*    */   
/*    */   private static final String __OBFID = "CL_00000596";
/*    */   
/*    */   public boolean func_71519_b(ICommandSender p_71519_1_) {
/* 24 */     return ((MinecraftServer.func_71276_C().func_71203_ab().func_72363_f().func_152689_b() || MinecraftServer.func_71276_C().func_71203_ab().func_152608_h().func_152689_b()) && super.func_71519_b(p_71519_1_));
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender p_71518_1_) {
/* 29 */     return "commands.banlist.usage";
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
/* 34 */     if (p_71515_2_.length >= 1 && p_71515_2_[0].equalsIgnoreCase("ips")) {
/* 35 */       p_71515_1_.func_145747_a((IChatComponent)new ChatComponentTranslation("commands.banlist.ips", new Object[] { Integer.valueOf((MinecraftServer.func_71276_C().func_71203_ab().func_72363_f().func_152685_a()).length) }));
/* 36 */       p_71515_1_.func_145747_a((IChatComponent)new ChatComponentText(func_71527_a((Object[])MinecraftServer.func_71276_C().func_71203_ab().func_72363_f().func_152685_a())));
/*    */     } else {
/* 38 */       p_71515_1_.func_145747_a((IChatComponent)new ChatComponentTranslation("commands.banlist.players", new Object[] { Integer.valueOf((MinecraftServer.func_71276_C().func_71203_ab().func_152608_h().func_152685_a()).length) }));
/* 39 */       p_71515_1_.func_145747_a((IChatComponent)new ChatComponentText(func_71527_a((Object[])MinecraftServer.func_71276_C().func_71203_ab().func_152608_h().func_152685_a())));
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
/* 45 */     if (p_71516_2_.length == 1) {
/* 46 */       return func_71530_a(p_71516_2_, new String[] { "players", "ips" });
/*    */     }
/*    */     
/* 49 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\server\CommandListBans.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */