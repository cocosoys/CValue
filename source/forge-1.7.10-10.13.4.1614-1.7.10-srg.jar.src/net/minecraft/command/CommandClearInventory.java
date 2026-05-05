/*    */ package net.minecraft.command;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ 
/*    */ 
/*    */ public class CommandClearInventory
/*    */   extends CommandBase
/*    */ {
/*    */   private static final String __OBFID = "CL_00000218";
/*    */   
/*    */   public String func_71517_b() {
/* 15 */     return "clear";
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender p_71518_1_) {
/* 20 */     return "commands.clear.usage";
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_82362_a() {
/* 25 */     return 2;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
/* 30 */     EntityPlayerMP entityPlayerMP = (p_71515_2_.length == 0) ? func_71521_c(p_71515_1_) : func_82359_c(p_71515_1_, p_71515_2_[0]);
/*    */     
/* 32 */     Item item = (p_71515_2_.length >= 2) ? func_147179_f(p_71515_1_, p_71515_2_[1]) : null;
/* 33 */     boolean bool = (p_71515_2_.length >= 3) ? func_71528_a(p_71515_1_, p_71515_2_[2], 0) : true;
/*    */     
/* 35 */     if (p_71515_2_.length >= 2 && item == null) {
/* 36 */       throw new CommandException("commands.clear.failure", new Object[] { entityPlayerMP.func_70005_c_() });
/*    */     }
/*    */     
/* 39 */     int i = entityPlayerMP.field_71071_by.func_146027_a(item, bool);
/* 40 */     entityPlayerMP.field_71069_bz.func_75142_b();
/* 41 */     if (!entityPlayerMP.field_71075_bZ.field_75098_d) entityPlayerMP.func_71113_k();
/*    */     
/* 43 */     if (i == 0) {
/* 44 */       throw new CommandException("commands.clear.failure", new Object[] { entityPlayerMP.func_70005_c_() });
/*    */     }
/*    */     
/* 47 */     func_152373_a(p_71515_1_, this, "commands.clear.success", new Object[] { entityPlayerMP.func_70005_c_(), Integer.valueOf(i) });
/*    */   }
/*    */ 
/*    */   
/*    */   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
/* 52 */     if (p_71516_2_.length == 1) {
/* 53 */       return func_71530_a(p_71516_2_, func_147209_d());
/*    */     }
/* 55 */     if (p_71516_2_.length == 2) {
/* 56 */       return func_71531_a(p_71516_2_, Item.field_150901_e.func_148742_b());
/*    */     }
/*    */     
/* 59 */     return null;
/*    */   }
/*    */   
/*    */   protected String[] func_147209_d() {
/* 63 */     return MinecraftServer.func_71276_C().func_71213_z();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_82358_a(String[] p_82358_1_, int p_82358_2_) {
/* 68 */     return (p_82358_2_ == 0);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\CommandClearInventory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */