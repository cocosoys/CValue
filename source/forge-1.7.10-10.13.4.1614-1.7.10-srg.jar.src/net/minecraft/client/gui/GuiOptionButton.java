/*    */ package net.minecraft.client.gui;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import net.minecraft.client.settings.GameSettings;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class GuiOptionButton extends GuiButton {
/*    */   private final GameSettings.Options field_146137_o;
/*    */   
/*    */   public GuiOptionButton(int p_i45011_1_, int p_i45011_2_, int p_i45011_3_, String p_i45011_4_) {
/* 10 */     this(p_i45011_1_, p_i45011_2_, p_i45011_3_, null, p_i45011_4_);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000676";
/*    */   public GuiOptionButton(int p_i45012_1_, int p_i45012_2_, int p_i45012_3_, int p_i45012_4_, int p_i45012_5_, String p_i45012_6_) {
/* 14 */     super(p_i45012_1_, p_i45012_2_, p_i45012_3_, p_i45012_4_, p_i45012_5_, p_i45012_6_);
/* 15 */     this.field_146137_o = null;
/*    */   }
/*    */   
/*    */   public GuiOptionButton(int p_i45013_1_, int p_i45013_2_, int p_i45013_3_, GameSettings.Options p_i45013_4_, String p_i45013_5_) {
/* 19 */     super(p_i45013_1_, p_i45013_2_, p_i45013_3_, 150, 20, p_i45013_5_);
/* 20 */     this.field_146137_o = p_i45013_4_;
/*    */   }
/*    */   
/*    */   public GameSettings.Options func_146136_c() {
/* 24 */     return this.field_146137_o;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiOptionButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */