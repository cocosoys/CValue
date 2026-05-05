/*    */ package net.minecraft.client.gui;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.resources.I18n;
/*    */ import net.minecraft.util.ChatComponentText;
/*    */ import net.minecraft.util.ChatComponentTranslation;
/*    */ import net.minecraft.util.IChatComponent;
/*    */ import net.minecraft.world.WorldSettings;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class GuiShareToLan
/*    */   extends GuiScreen
/*    */ {
/*    */   private final GuiScreen field_146598_a;
/*    */   private GuiButton field_146596_f;
/*    */   private GuiButton field_146597_g;
/* 21 */   private String field_146599_h = "survival";
/*    */   private boolean field_146600_i;
/*    */   
/*    */   public GuiShareToLan(GuiScreen p_i1055_1_) {
/* 25 */     this.field_146598_a = p_i1055_1_;
/*    */   }
/*    */   
/*    */   private static final String __OBFID = "CL_00000713";
/*    */   
/*    */   public void func_73866_w_() {
/* 31 */     this.field_146292_n.clear();
/* 32 */     this.field_146292_n.add(new GuiButton(101, this.field_146294_l / 2 - 155, this.field_146295_m - 28, 150, 20, I18n.func_135052_a("lanServer.start", new Object[0])));
/* 33 */     this.field_146292_n.add(new GuiButton(102, this.field_146294_l / 2 + 5, this.field_146295_m - 28, 150, 20, I18n.func_135052_a("gui.cancel", new Object[0])));
/*    */     
/* 35 */     this.field_146292_n.add(this.field_146597_g = new GuiButton(104, this.field_146294_l / 2 - 155, 100, 150, 20, I18n.func_135052_a("selectWorld.gameMode", new Object[0])));
/* 36 */     this.field_146292_n.add(this.field_146596_f = new GuiButton(103, this.field_146294_l / 2 + 5, 100, 150, 20, I18n.func_135052_a("selectWorld.allowCommands", new Object[0])));
/*    */     
/* 38 */     func_146595_g();
/*    */   }
/*    */   
/*    */   private void func_146595_g() {
/* 42 */     this.field_146597_g.field_146126_j = I18n.func_135052_a("selectWorld.gameMode", new Object[0]) + " " + I18n.func_135052_a("selectWorld.gameMode." + this.field_146599_h, new Object[0]);
/*    */     
/* 44 */     this.field_146596_f.field_146126_j = I18n.func_135052_a("selectWorld.allowCommands", new Object[0]) + " ";
/* 45 */     if (this.field_146600_i) {
/* 46 */       this.field_146596_f.field_146126_j += I18n.func_135052_a("options.on", new Object[0]);
/*    */     } else {
/* 48 */       this.field_146596_f.field_146126_j += I18n.func_135052_a("options.off", new Object[0]);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_146284_a(GuiButton p_146284_1_) {
/* 55 */     if (p_146284_1_.field_146127_k == 102) {
/* 56 */       this.field_146297_k.func_147108_a(this.field_146598_a);
/* 57 */     } else if (p_146284_1_.field_146127_k == 104) {
/* 58 */       if (this.field_146599_h.equals("survival")) {
/* 59 */         this.field_146599_h = "creative";
/* 60 */       } else if (this.field_146599_h.equals("creative")) {
/* 61 */         this.field_146599_h = "adventure";
/*    */       } else {
/* 63 */         this.field_146599_h = "survival";
/*    */       } 
/* 65 */       func_146595_g();
/* 66 */     } else if (p_146284_1_.field_146127_k == 103) {
/* 67 */       this.field_146600_i = !this.field_146600_i;
/* 68 */       func_146595_g();
/* 69 */     } else if (p_146284_1_.field_146127_k == 101) {
/* 70 */       ChatComponentText chatComponentText; this.field_146297_k.func_147108_a(null);
/* 71 */       String str = this.field_146297_k.func_71401_C().func_71206_a(WorldSettings.GameType.func_77142_a(this.field_146599_h), this.field_146600_i);
/*    */ 
/*    */       
/* 74 */       if (str != null) {
/* 75 */         ChatComponentTranslation chatComponentTranslation = new ChatComponentTranslation("commands.publish.started", new Object[] { str });
/*    */       } else {
/* 77 */         chatComponentText = new ChatComponentText("commands.publish.failed");
/*    */       } 
/*    */       
/* 80 */       this.field_146297_k.field_71456_v.func_146158_b().func_146227_a((IChatComponent)chatComponentText);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/* 86 */     func_146276_q_();
/*    */     
/* 88 */     func_73732_a(this.field_146289_q, I18n.func_135052_a("lanServer.title", new Object[0]), this.field_146294_l / 2, 50, 16777215);
/* 89 */     func_73732_a(this.field_146289_q, I18n.func_135052_a("lanServer.otherPlayers", new Object[0]), this.field_146294_l / 2, 82, 16777215);
/*    */     
/* 91 */     super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiShareToLan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */