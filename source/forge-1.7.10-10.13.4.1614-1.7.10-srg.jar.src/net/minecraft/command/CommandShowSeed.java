/*    */ package net.minecraft.command;
/*    */ 
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.util.ChatComponentTranslation;
/*    */ import net.minecraft.util.IChatComponent;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class CommandShowSeed
/*    */   extends CommandBase {
/*    */   public boolean func_71519_b(ICommandSender p_71519_1_) {
/* 12 */     return (MinecraftServer.func_71276_C().func_71264_H() || super.func_71519_b(p_71519_1_));
/*    */   }
/*    */   private static final String __OBFID = "CL_00001053";
/*    */   
/*    */   public String func_71517_b() {
/* 17 */     return "seed";
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_82362_a() {
/* 22 */     return 2;
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender p_71518_1_) {
/* 27 */     return "commands.seed.usage";
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
/* 32 */     World world = (World)((p_71515_1_ instanceof EntityPlayer) ? ((EntityPlayer)p_71515_1_).field_70170_p : MinecraftServer.func_71276_C().func_71218_a(0));
/* 33 */     p_71515_1_.func_145747_a((IChatComponent)new ChatComponentTranslation("commands.seed.success", new Object[] { Long.valueOf(world.func_72905_C()) }));
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\CommandShowSeed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */