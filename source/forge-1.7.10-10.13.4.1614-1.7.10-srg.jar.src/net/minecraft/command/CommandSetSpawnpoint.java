/*    */ package net.minecraft.command;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.util.ChunkCoordinates;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CommandSetSpawnpoint
/*    */   extends CommandBase
/*    */ {
/*    */   private static final String __OBFID = "CL_00001026";
/*    */   
/*    */   public String func_71517_b() {
/* 16 */     return "spawnpoint";
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_82362_a() {
/* 21 */     return 2;
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender p_71518_1_) {
/* 26 */     return "commands.spawnpoint.usage";
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
/* 31 */     EntityPlayerMP entityPlayerMP = (p_71515_2_.length == 0) ? func_71521_c(p_71515_1_) : func_82359_c(p_71515_1_, p_71515_2_[0]);
/*    */     
/* 33 */     if (p_71515_2_.length == 4) {
/* 34 */       if (entityPlayerMP.field_70170_p != null) {
/* 35 */         byte b = 1;
/* 36 */         int i = 30000000;
/* 37 */         int j = func_71532_a(p_71515_1_, p_71515_2_[b++], -i, i);
/* 38 */         int k = func_71532_a(p_71515_1_, p_71515_2_[b++], 0, 256);
/* 39 */         int m = func_71532_a(p_71515_1_, p_71515_2_[b++], -i, i);
/*    */         
/* 41 */         entityPlayerMP.func_71063_a(new ChunkCoordinates(j, k, m), true);
/* 42 */         func_152373_a(p_71515_1_, this, "commands.spawnpoint.success", new Object[] { entityPlayerMP.func_70005_c_(), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
/*    */       } 
/* 44 */     } else if (p_71515_2_.length <= 1) {
/* 45 */       ChunkCoordinates chunkCoordinates = entityPlayerMP.func_82114_b();
/* 46 */       entityPlayerMP.func_71063_a(chunkCoordinates, true);
/* 47 */       func_152373_a(p_71515_1_, this, "commands.spawnpoint.success", new Object[] { entityPlayerMP.func_70005_c_(), Integer.valueOf(chunkCoordinates.field_71574_a), Integer.valueOf(chunkCoordinates.field_71572_b), Integer.valueOf(chunkCoordinates.field_71573_c) });
/*    */     } else {
/* 49 */       throw new WrongUsageException("commands.spawnpoint.usage", new Object[0]);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
/* 55 */     if (p_71516_2_.length == 1 || p_71516_2_.length == 2) {
/* 56 */       return func_71530_a(p_71516_2_, MinecraftServer.func_71276_C().func_71213_z());
/*    */     }
/*    */     
/* 59 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_82358_a(String[] p_82358_1_, int p_82358_2_) {
/* 64 */     return (p_82358_2_ == 0);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\CommandSetSpawnpoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */