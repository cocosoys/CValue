/*    */ package net.minecraft.command.server;
/*    */ 
/*    */ import net.minecraft.command.CommandBase;
/*    */ import net.minecraft.command.ICommand;
/*    */ import net.minecraft.command.ICommandSender;
/*    */ import net.minecraft.command.WrongUsageException;
/*    */ import net.minecraft.util.ChunkCoordinates;
/*    */ 
/*    */ 
/*    */ public class CommandSetDefaultSpawnpoint
/*    */   extends CommandBase
/*    */ {
/*    */   private static final String __OBFID = "CL_00000973";
/*    */   
/*    */   public String func_71517_b() {
/* 16 */     return "setworldspawn";
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_82362_a() {
/* 21 */     return 2;
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender p_71518_1_) {
/* 26 */     return "commands.setworldspawn.usage";
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
/* 31 */     if (p_71515_2_.length == 3) {
/* 32 */       if (p_71515_1_.func_130014_f_() != null) {
/* 33 */         byte b = 0;
/* 34 */         int i = func_71532_a(p_71515_1_, p_71515_2_[b++], -30000000, 30000000);
/* 35 */         int j = func_71532_a(p_71515_1_, p_71515_2_[b++], 0, 256);
/* 36 */         int k = func_71532_a(p_71515_1_, p_71515_2_[b++], -30000000, 30000000);
/*    */         
/* 38 */         p_71515_1_.func_130014_f_().func_72950_A(i, j, k);
/* 39 */         func_152373_a(p_71515_1_, (ICommand)this, "commands.setworldspawn.success", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
/*    */       } else {
/* 41 */         throw new WrongUsageException("commands.setworldspawn.usage", new Object[0]);
/*    */       } 
/* 43 */     } else if (p_71515_2_.length == 0) {
/* 44 */       ChunkCoordinates chunkCoordinates = func_71521_c(p_71515_1_).func_82114_b();
/* 45 */       p_71515_1_.func_130014_f_().func_72950_A(chunkCoordinates.field_71574_a, chunkCoordinates.field_71572_b, chunkCoordinates.field_71573_c);
/* 46 */       func_152373_a(p_71515_1_, (ICommand)this, "commands.setworldspawn.success", new Object[] { Integer.valueOf(chunkCoordinates.field_71574_a), Integer.valueOf(chunkCoordinates.field_71572_b), Integer.valueOf(chunkCoordinates.field_71573_c) });
/*    */     } else {
/* 48 */       throw new WrongUsageException("commands.setworldspawn.usage", new Object[0]);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\server\CommandSetDefaultSpawnpoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */