/*    */ package net.minecraft.command.server;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import net.minecraft.command.CommandBase;
/*    */ import net.minecraft.command.ICommandSender;
/*    */ import net.minecraft.command.PlayerNotFoundException;
/*    */ import net.minecraft.command.WrongUsageException;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.util.ChatComponentTranslation;
/*    */ import net.minecraft.util.EnumChatFormatting;
/*    */ import net.minecraft.util.IChatComponent;
/*    */ 
/*    */ public class CommandMessage extends CommandBase {
/*    */   private static final String __OBFID = "CL_00000641";
/*    */   
/*    */   public List func_71514_a() {
/* 19 */     return Arrays.asList(new String[] { "w", "msg" });
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_71517_b() {
/* 24 */     return "tell";
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_82362_a() {
/* 29 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender p_71518_1_) {
/* 34 */     return "commands.message.usage";
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
/* 39 */     if (p_71515_2_.length < 2) throw new WrongUsageException("commands.message.usage", new Object[0]);
/*    */     
/* 41 */     EntityPlayerMP entityPlayerMP = func_82359_c(p_71515_1_, p_71515_2_[0]);
/*    */     
/* 43 */     if (entityPlayerMP == null) throw new PlayerNotFoundException(); 
/* 44 */     if (entityPlayerMP == p_71515_1_) throw new PlayerNotFoundException("commands.message.sameTarget", new Object[0]);
/*    */     
/* 46 */     IChatComponent iChatComponent = func_147176_a(p_71515_1_, p_71515_2_, 1, !(p_71515_1_ instanceof net.minecraft.entity.player.EntityPlayer));
/* 47 */     ChatComponentTranslation chatComponentTranslation1 = new ChatComponentTranslation("commands.message.display.incoming", new Object[] { p_71515_1_.func_145748_c_(), iChatComponent.func_150259_f() });
/* 48 */     ChatComponentTranslation chatComponentTranslation2 = new ChatComponentTranslation("commands.message.display.outgoing", new Object[] { entityPlayerMP.func_145748_c_(), iChatComponent.func_150259_f() });
/* 49 */     chatComponentTranslation1.func_150256_b().func_150238_a(EnumChatFormatting.GRAY).func_150217_b(Boolean.valueOf(true));
/* 50 */     chatComponentTranslation2.func_150256_b().func_150238_a(EnumChatFormatting.GRAY).func_150217_b(Boolean.valueOf(true));
/* 51 */     entityPlayerMP.func_145747_a((IChatComponent)chatComponentTranslation1);
/* 52 */     p_71515_1_.func_145747_a((IChatComponent)chatComponentTranslation2);
/*    */   }
/*    */ 
/*    */   
/*    */   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
/* 57 */     return func_71530_a(p_71516_2_, MinecraftServer.func_71276_C().func_71213_z());
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_82358_a(String[] p_82358_1_, int p_82358_2_) {
/* 62 */     return (p_82358_2_ == 0);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\server\CommandMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */