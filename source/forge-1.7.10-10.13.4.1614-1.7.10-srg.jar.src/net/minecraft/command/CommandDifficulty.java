/*    */ package net.minecraft.command;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.util.ChatComponentTranslation;
/*    */ import net.minecraft.world.EnumDifficulty;
/*    */ 
/*    */ 
/*    */ public class CommandDifficulty
/*    */   extends CommandBase
/*    */ {
/*    */   private static final String __OBFID = "CL_00000422";
/*    */   
/*    */   public String func_71517_b() {
/* 15 */     return "difficulty";
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
/* 26 */     return "commands.difficulty.usage";
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
/* 31 */     if (p_71515_2_.length > 0) {
/* 32 */       EnumDifficulty enumDifficulty = func_147201_h(p_71515_1_, p_71515_2_[0]);
/*    */       
/* 34 */       MinecraftServer.func_71276_C().func_147139_a(enumDifficulty);
/*    */       
/* 36 */       func_152373_a(p_71515_1_, this, "commands.difficulty.success", new Object[] { new ChatComponentTranslation(enumDifficulty.func_151526_b(), new Object[0]) });
/*    */       
/*    */       return;
/*    */     } 
/*    */     
/* 41 */     throw new WrongUsageException("commands.difficulty.usage", new Object[0]);
/*    */   }
/*    */   
/*    */   protected EnumDifficulty func_147201_h(ICommandSender p_147201_1_, String p_147201_2_) {
/* 45 */     if (p_147201_2_.equalsIgnoreCase("peaceful") || p_147201_2_.equalsIgnoreCase("p"))
/* 46 */       return EnumDifficulty.PEACEFUL; 
/* 47 */     if (p_147201_2_.equalsIgnoreCase("easy") || p_147201_2_.equalsIgnoreCase("e"))
/* 48 */       return EnumDifficulty.EASY; 
/* 49 */     if (p_147201_2_.equalsIgnoreCase("normal") || p_147201_2_.equalsIgnoreCase("n"))
/* 50 */       return EnumDifficulty.NORMAL; 
/* 51 */     if (p_147201_2_.equalsIgnoreCase("hard") || p_147201_2_.equalsIgnoreCase("h")) {
/* 52 */       return EnumDifficulty.HARD;
/*    */     }
/* 54 */     return EnumDifficulty.func_151523_a(func_71532_a(p_147201_1_, p_147201_2_, 0, 3));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
/* 60 */     if (p_71516_2_.length == 1) {
/* 61 */       return func_71530_a(p_71516_2_, new String[] { "peaceful", "easy", "normal", "hard" });
/*    */     }
/*    */     
/* 64 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\CommandDifficulty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */