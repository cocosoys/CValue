/*    */ package net.minecraft.command;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.util.ChatComponentTranslation;
/*    */ import net.minecraft.world.WorldSettings;
/*    */ 
/*    */ 
/*    */ public class CommandGameMode
/*    */   extends CommandBase
/*    */ {
/*    */   private static final String __OBFID = "CL_00000448";
/*    */   
/*    */   public String func_71517_b() {
/* 17 */     return "gamemode";
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_82362_a() {
/* 22 */     return 2;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender p_71518_1_) {
/* 28 */     return "commands.gamemode.usage";
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
/* 33 */     if (p_71515_2_.length > 0) {
/* 34 */       WorldSettings.GameType gameType = func_71539_b(p_71515_1_, p_71515_2_[0]);
/* 35 */       EntityPlayerMP entityPlayerMP = (p_71515_2_.length >= 2) ? func_82359_c(p_71515_1_, p_71515_2_[1]) : func_71521_c(p_71515_1_);
/*    */       
/* 37 */       entityPlayerMP.func_71033_a(gameType);
/* 38 */       ((EntityPlayer)entityPlayerMP).field_70143_R = 0.0F;
/*    */       
/* 40 */       ChatComponentTranslation chatComponentTranslation = new ChatComponentTranslation("gameMode." + gameType.func_77149_b(), new Object[0]);
/*    */       
/* 42 */       if (entityPlayerMP != p_71515_1_) {
/* 43 */         func_152374_a(p_71515_1_, this, 1, "commands.gamemode.success.other", new Object[] { entityPlayerMP.func_70005_c_(), chatComponentTranslation });
/*    */       } else {
/* 45 */         func_152374_a(p_71515_1_, this, 1, "commands.gamemode.success.self", new Object[] { chatComponentTranslation });
/*    */       } 
/*    */       
/*    */       return;
/*    */     } 
/*    */     
/* 51 */     throw new WrongUsageException("commands.gamemode.usage", new Object[0]);
/*    */   }
/*    */   
/*    */   protected WorldSettings.GameType func_71539_b(ICommandSender p_71539_1_, String p_71539_2_) {
/* 55 */     if (p_71539_2_.equalsIgnoreCase(WorldSettings.GameType.SURVIVAL.func_77149_b()) || p_71539_2_.equalsIgnoreCase("s"))
/* 56 */       return WorldSettings.GameType.SURVIVAL; 
/* 57 */     if (p_71539_2_.equalsIgnoreCase(WorldSettings.GameType.CREATIVE.func_77149_b()) || p_71539_2_.equalsIgnoreCase("c"))
/* 58 */       return WorldSettings.GameType.CREATIVE; 
/* 59 */     if (p_71539_2_.equalsIgnoreCase(WorldSettings.GameType.ADVENTURE.func_77149_b()) || p_71539_2_.equalsIgnoreCase("a")) {
/* 60 */       return WorldSettings.GameType.ADVENTURE;
/*    */     }
/* 62 */     return WorldSettings.func_77161_a(func_71532_a(p_71539_1_, p_71539_2_, 0, (WorldSettings.GameType.values()).length - 2));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
/* 68 */     if (p_71516_2_.length == 1)
/* 69 */       return func_71530_a(p_71516_2_, new String[] { "survival", "creative", "adventure" }); 
/* 70 */     if (p_71516_2_.length == 2) {
/* 71 */       return func_71530_a(p_71516_2_, func_71538_c());
/*    */     }
/*    */     
/* 74 */     return null;
/*    */   }
/*    */   
/*    */   protected String[] func_71538_c() {
/* 78 */     return MinecraftServer.func_71276_C().func_71213_z();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_82358_a(String[] p_82358_1_, int p_82358_2_) {
/* 83 */     return (p_82358_2_ == 1);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\CommandGameMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */