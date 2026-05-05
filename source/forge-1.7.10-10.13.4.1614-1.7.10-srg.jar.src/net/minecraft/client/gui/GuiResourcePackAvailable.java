/*    */ package net.minecraft.client.gui;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.List;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.resources.I18n;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class GuiResourcePackAvailable extends GuiResourcePackList {
/*    */   public GuiResourcePackAvailable(Minecraft p_i45054_1_, int p_i45054_2_, int p_i45054_3_, List p_i45054_4_) {
/* 11 */     super(p_i45054_1_, p_i45054_2_, p_i45054_3_, p_i45054_4_);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000824";
/*    */   
/*    */   protected String func_148202_k() {
/* 16 */     return I18n.func_135052_a("resourcePack.available.title", new Object[0]);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiResourcePackAvailable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */