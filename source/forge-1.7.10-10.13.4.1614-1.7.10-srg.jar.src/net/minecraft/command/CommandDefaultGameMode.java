/*    */ package net.minecraft.command;
/*    */ 
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.util.ChatComponentTranslation;
/*    */ import net.minecraft.world.WorldSettings;
/*    */ 
/*    */ public class CommandDefaultGameMode
/*    */   extends CommandGameMode {
/*    */   private static final String __OBFID = "CL_00000296";
/*    */   
/*    */   public String func_71517_b() {
/* 13 */     return "defaultgamemode";
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender p_71518_1_) {
/* 18 */     return "commands.defaultgamemode.usage";
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
/* 23 */     if (p_71515_2_.length > 0) {
/* 24 */       WorldSettings.GameType gameType = func_71539_b(p_71515_1_, p_71515_2_[0]);
/* 25 */       func_71541_a(gameType);
/*    */       
/* 27 */       func_152373_a(p_71515_1_, this, "commands.defaultgamemode.success", new Object[] { new ChatComponentTranslation("gameMode." + gameType.func_77149_b(), new Object[0]) });
/*    */       
/*    */       return;
/*    */     } 
/*    */     
/* 32 */     throw new WrongUsageException("commands.defaultgamemode.usage", new Object[0]);
/*    */   }
/*    */   
/*    */   protected void func_71541_a(WorldSettings.GameType p_71541_1_) {
/* 36 */     MinecraftServer minecraftServer = MinecraftServer.func_71276_C();
/* 37 */     minecraftServer.func_71235_a(p_71541_1_);
/*    */     
/* 39 */     if (minecraftServer.func_104056_am())
/* 40 */       for (EntityPlayerMP entityPlayerMP : (MinecraftServer.func_71276_C().func_71203_ab()).field_72404_b) {
/* 41 */         entityPlayerMP.func_71033_a(p_71541_1_);
/* 42 */         entityPlayerMP.field_70143_R = 0.0F;
/*    */       }  
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\CommandDefaultGameMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */