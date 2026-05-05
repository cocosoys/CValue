/*    */ package net.minecraft.command;
/*    */ 
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.util.ChatComponentTranslation;
/*    */ import net.minecraft.util.DamageSource;
/*    */ import net.minecraft.util.IChatComponent;
/*    */ 
/*    */ public class CommandKill extends CommandBase {
/*    */   private static final String __OBFID = "CL_00000570";
/*    */   
/*    */   public String func_71517_b() {
/* 12 */     return "kill";
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_82362_a() {
/* 17 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender p_71518_1_) {
/* 22 */     return "commands.kill.usage";
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
/* 27 */     EntityPlayerMP entityPlayerMP = func_71521_c(p_71515_1_);
/*    */     
/* 29 */     entityPlayerMP.func_70097_a(DamageSource.field_76380_i, Float.MAX_VALUE);
/*    */     
/* 31 */     p_71515_1_.func_145747_a((IChatComponent)new ChatComponentTranslation("commands.kill.success", new Object[0]));
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\CommandKill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */