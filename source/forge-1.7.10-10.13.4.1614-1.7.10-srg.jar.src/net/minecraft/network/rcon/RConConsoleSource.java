/*    */ package net.minecraft.network.rcon;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.command.ICommandSender;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.util.ChatComponentText;
/*    */ import net.minecraft.util.ChunkCoordinates;
/*    */ import net.minecraft.util.IChatComponent;
/*    */ 
/*    */ public class RConConsoleSource implements ICommandSender {
/* 11 */   public static final RConConsoleSource field_70010_a = new RConConsoleSource();
/*    */   
/* 13 */   private StringBuffer field_70009_b = new StringBuffer(); private static final String __OBFID = "CL_00001800";
/*    */   @SideOnly(Side.SERVER)
/*    */   public void func_70007_b() {
/* 16 */     this.field_70009_b.setLength(0);
/*    */   }
/*    */   @SideOnly(Side.SERVER)
/*    */   public String func_70008_c() {
/* 20 */     return this.field_70009_b.toString();
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_70005_c_() {
/* 25 */     return "Rcon";
/*    */   }
/*    */ 
/*    */   
/*    */   public IChatComponent func_145748_c_() {
/* 30 */     return (IChatComponent)new ChatComponentText(func_70005_c_());
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_145747_a(IChatComponent p_145747_1_) {
/* 35 */     this.field_70009_b.append(p_145747_1_.func_150260_c());
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_70003_b(int p_70003_1_, String p_70003_2_) {
/* 40 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public ChunkCoordinates func_82114_b() {
/* 45 */     return new ChunkCoordinates(0, 0, 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public World func_130014_f_() {
/* 50 */     return MinecraftServer.func_71276_C().func_130014_f_();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\rcon\RConConsoleSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */