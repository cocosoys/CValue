/*    */ package net.minecraft.realms;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.List;
/*    */ import net.minecraft.util.IChatComponent;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class DisconnectedOnlineScreen
/*    */   extends RealmsScreen {
/*    */   private String title;
/*    */   private IChatComponent reason;
/*    */   
/*    */   public DisconnectedOnlineScreen(RealmsScreen p_i1000_1_, String p_i1000_2_, IChatComponent p_i1000_3_) {
/* 15 */     this.parent = p_i1000_1_;
/* 16 */     this.title = getLocalizedString(p_i1000_2_);
/* 17 */     this.reason = p_i1000_3_;
/*    */   }
/*    */   private List lines; private final RealmsScreen parent; private static final String __OBFID = "CL_00001912";
/*    */   
/*    */   public void init() {
/* 22 */     buttonsClear();
/* 23 */     buttonsAdd(newButton(0, width() / 2 - 100, height() / 4 + 120 + 12, getLocalizedString("gui.back")));
/*    */     
/* 25 */     this.lines = fontSplit(this.reason.func_150254_d(), width() - 50);
/*    */   }
/*    */ 
/*    */   
/*    */   public void keyPressed(char p_keyPressed_1_, int p_keyPressed_2_) {
/* 30 */     if (p_keyPressed_2_ == 1) {
/* 31 */       Realms.setScreen(this.parent);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void buttonClicked(RealmsButton p_buttonClicked_1_) {
/* 37 */     if (p_buttonClicked_1_.id() == 0) {
/* 38 */       Realms.setScreen(this.parent);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(int p_render_1_, int p_render_2_, float p_render_3_) {
/* 44 */     renderBackground();
/*    */     
/* 46 */     drawCenteredString(this.title, width() / 2, height() / 2 - 50, 11184810);
/*    */     
/* 48 */     int i = height() / 2 - 30;
/*    */     
/* 50 */     if (this.lines != null) {
/* 51 */       for (String str : this.lines) {
/* 52 */         drawCenteredString(str, width() / 2, i, 16777215);
/* 53 */         i += fontLineHeight();
/*    */       } 
/*    */     }
/*    */     
/* 57 */     super.render(p_render_1_, p_render_2_, p_render_3_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\realms\DisconnectedOnlineScreen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */