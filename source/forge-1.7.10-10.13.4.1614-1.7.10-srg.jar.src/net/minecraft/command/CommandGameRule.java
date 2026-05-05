/*    */ package net.minecraft.command;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.util.ChatComponentText;
/*    */ import net.minecraft.util.IChatComponent;
/*    */ import net.minecraft.world.GameRules;
/*    */ 
/*    */ public class CommandGameRule
/*    */   extends CommandBase
/*    */ {
/*    */   private static final String __OBFID = "CL_00000475";
/*    */   
/*    */   public String func_71517_b() {
/* 15 */     return "gamerule";
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_82362_a() {
/* 20 */     return 2;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender p_71518_1_) {
/* 26 */     return "commands.gamerule.usage";
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
/* 31 */     if (p_71515_2_.length == 2) {
/* 32 */       String str1 = p_71515_2_[0];
/* 33 */       String str2 = p_71515_2_[1];
/*    */       
/* 35 */       GameRules gameRules = func_82366_d();
/*    */       
/* 37 */       if (gameRules.func_82765_e(str1)) {
/* 38 */         gameRules.func_82764_b(str1, str2);
/* 39 */         func_152373_a(p_71515_1_, this, "commands.gamerule.success", new Object[0]);
/*    */       } else {
/* 41 */         func_152373_a(p_71515_1_, this, "commands.gamerule.norule", new Object[] { str1 });
/*    */       } 
/*    */       return;
/*    */     } 
/* 45 */     if (p_71515_2_.length == 1) {
/* 46 */       String str = p_71515_2_[0];
/* 47 */       GameRules gameRules = func_82366_d();
/*    */       
/* 49 */       if (gameRules.func_82765_e(str)) {
/* 50 */         String str1 = gameRules.func_82767_a(str);
/* 51 */         p_71515_1_.func_145747_a((new ChatComponentText(str)).func_150258_a(" = ").func_150258_a(str1));
/*    */       } else {
/* 53 */         func_152373_a(p_71515_1_, this, "commands.gamerule.norule", new Object[] { str });
/*    */       } 
/*    */       return;
/*    */     } 
/* 57 */     if (p_71515_2_.length == 0) {
/* 58 */       GameRules gameRules = func_82366_d();
/* 59 */       p_71515_1_.func_145747_a((IChatComponent)new ChatComponentText(func_71527_a((Object[])gameRules.func_82763_b())));
/*    */       
/*    */       return;
/*    */     } 
/* 63 */     throw new WrongUsageException("commands.gamerule.usage", new Object[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
/* 68 */     if (p_71516_2_.length == 1)
/* 69 */       return func_71530_a(p_71516_2_, func_82366_d().func_82763_b()); 
/* 70 */     if (p_71516_2_.length == 2) {
/* 71 */       return func_71530_a(p_71516_2_, new String[] { "true", "false" });
/*    */     }
/*    */     
/* 74 */     return null;
/*    */   }
/*    */   
/*    */   private GameRules func_82366_d() {
/* 78 */     return MinecraftServer.func_71276_C().func_71218_a(0).func_82736_K();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\CommandGameRule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */