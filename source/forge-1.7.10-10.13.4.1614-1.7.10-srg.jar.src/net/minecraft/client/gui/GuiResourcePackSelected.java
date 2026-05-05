/*    */ package net.minecraft.client.gui;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.List;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.resources.I18n;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class GuiResourcePackSelected extends GuiResourcePackList {
/*    */   public GuiResourcePackSelected(Minecraft p_i45056_1_, int p_i45056_2_, int p_i45056_3_, List p_i45056_4_) {
/* 11 */     super(p_i45056_1_, p_i45056_2_, p_i45056_3_, p_i45056_4_);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000827";
/*    */   
/*    */   protected String func_148202_k() {
/* 16 */     return I18n.func_135052_a("resourcePack.selected.title", new Object[0]);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiResourcePackSelected.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */