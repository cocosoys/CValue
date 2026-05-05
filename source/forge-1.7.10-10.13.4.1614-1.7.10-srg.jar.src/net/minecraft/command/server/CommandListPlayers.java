/*    */ package net.minecraft.command.server;
/*    */ import net.minecraft.command.CommandBase;
/*    */ import net.minecraft.command.ICommandSender;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.util.ChatComponentText;
/*    */ import net.minecraft.util.ChatComponentTranslation;
/*    */ import net.minecraft.util.IChatComponent;
/*    */ 
/*    */ public class CommandListPlayers extends CommandBase {
/*    */   public String func_71517_b() {
/* 11 */     return "list";
/*    */   }
/*    */   private static final String __OBFID = "CL_00000615";
/*    */   
/*    */   public int func_82362_a() {
/* 16 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender p_71518_1_) {
/* 21 */     return "commands.players.usage";
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
/* 26 */     p_71515_1_.func_145747_a((IChatComponent)new ChatComponentTranslation("commands.players.list", new Object[] { Integer.valueOf(MinecraftServer.func_71276_C().func_71233_x()), Integer.valueOf(MinecraftServer.func_71276_C().func_71275_y()) }));
/* 27 */     p_71515_1_.func_145747_a((IChatComponent)new ChatComponentText(MinecraftServer.func_71276_C().func_71203_ab().func_152609_b((p_71515_2_.length > 0 && "uuids".equalsIgnoreCase(p_71515_2_[0])))));
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\server\CommandListPlayers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */