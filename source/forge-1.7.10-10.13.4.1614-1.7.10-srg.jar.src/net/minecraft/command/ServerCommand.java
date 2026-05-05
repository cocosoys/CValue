/*    */ package net.minecraft.command;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(Side.SERVER)
/*    */ public class ServerCommand
/*    */ {
/*    */   public ServerCommand(String p_i1491_1_, ICommandSender p_i1491_2_) {
/* 10 */     this.field_73702_a = p_i1491_1_;
/* 11 */     this.field_73701_b = p_i1491_2_;
/*    */   }
/*    */   
/*    */   public final String field_73702_a;
/*    */   public final ICommandSender field_73701_b;
/*    */   private static final String __OBFID = "CL_00001779";
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\ServerCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */