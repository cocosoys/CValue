/*    */ package net.minecraft.command;
/*    */ 
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.world.storage.WorldInfo;
/*    */ 
/*    */ public class CommandToggleDownfall extends CommandBase {
/*    */   private static final String __OBFID = "CL_00001184";
/*    */   
/*    */   public String func_71517_b() {
/* 10 */     return "toggledownfall";
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_82362_a() {
/* 15 */     return 2;
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender p_71518_1_) {
/* 20 */     return "commands.downfall.usage";
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
/* 25 */     func_71554_c();
/* 26 */     func_152373_a(p_71515_1_, this, "commands.downfall.success", new Object[0]);
/*    */   }
/*    */   
/*    */   protected void func_71554_c() {
/* 30 */     WorldInfo worldInfo = (MinecraftServer.func_71276_C()).field_71305_c[0].func_72912_H();
/*    */     
/* 32 */     worldInfo.func_76084_b(!worldInfo.func_76059_o());
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\CommandToggleDownfall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */