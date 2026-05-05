/*    */ package net.minecraft.command;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Random;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.world.WorldServer;
/*    */ import net.minecraft.world.storage.WorldInfo;
/*    */ 
/*    */ public class CommandWeather
/*    */   extends CommandBase
/*    */ {
/*    */   private static final String __OBFID = "CL_00001185";
/*    */   
/*    */   public String func_71517_b() {
/* 15 */     return "weather";
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_82362_a() {
/* 20 */     return 2;
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender p_71518_1_) {
/* 25 */     return "commands.weather.usage";
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
/* 30 */     if (p_71515_2_.length < 1 || p_71515_2_.length > 2) {
/* 31 */       throw new WrongUsageException("commands.weather.usage", new Object[0]);
/*    */     }
/*    */     
/* 34 */     int i = (300 + (new Random()).nextInt(600)) * 20;
/* 35 */     if (p_71515_2_.length >= 2) {
/* 36 */       i = func_71532_a(p_71515_1_, p_71515_2_[1], 1, 1000000) * 20;
/*    */     }
/*    */     
/* 39 */     WorldServer worldServer = (MinecraftServer.func_71276_C()).field_71305_c[0];
/* 40 */     WorldInfo worldInfo = worldServer.func_72912_H();
/*    */     
/* 42 */     if ("clear".equalsIgnoreCase(p_71515_2_[0])) {
/* 43 */       worldInfo.func_76080_g(0);
/* 44 */       worldInfo.func_76090_f(0);
/* 45 */       worldInfo.func_76084_b(false);
/* 46 */       worldInfo.func_76069_a(false);
/* 47 */       func_152373_a(p_71515_1_, this, "commands.weather.clear", new Object[0]);
/* 48 */     } else if ("rain".equalsIgnoreCase(p_71515_2_[0])) {
/* 49 */       worldInfo.func_76080_g(i);
/* 50 */       worldInfo.func_76084_b(true);
/* 51 */       worldInfo.func_76069_a(false);
/* 52 */       func_152373_a(p_71515_1_, this, "commands.weather.rain", new Object[0]);
/* 53 */     } else if ("thunder".equalsIgnoreCase(p_71515_2_[0])) {
/* 54 */       worldInfo.func_76080_g(i);
/* 55 */       worldInfo.func_76090_f(i);
/* 56 */       worldInfo.func_76084_b(true);
/* 57 */       worldInfo.func_76069_a(true);
/* 58 */       func_152373_a(p_71515_1_, this, "commands.weather.thunder", new Object[0]);
/*    */     } else {
/* 60 */       throw new WrongUsageException("commands.weather.usage", new Object[0]);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
/* 66 */     if (p_71516_2_.length == 1) {
/* 67 */       return func_71530_a(p_71516_2_, new String[] { "clear", "rain", "thunder" });
/*    */     }
/*    */     
/* 70 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\CommandWeather.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */