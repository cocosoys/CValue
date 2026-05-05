/*     */ package net.minecraft.client.gui;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class GuiGameOver
/*     */   extends GuiScreen
/*     */   implements GuiYesNoCallback
/*     */ {
/*     */   private int field_146347_a;
/*     */   private boolean field_146346_f = false;
/*     */   private static final String __OBFID = "CL_00000690";
/*     */   
/*     */   public void func_73866_w_() {
/*  21 */     this.field_146292_n.clear();
/*  22 */     if (this.field_146297_k.field_71441_e.func_72912_H().func_76093_s()) {
/*  23 */       if (this.field_146297_k.func_71387_A()) {
/*  24 */         this.field_146292_n.add(new GuiButton(1, this.field_146294_l / 2 - 100, this.field_146295_m / 4 + 96, I18n.func_135052_a("deathScreen.deleteWorld", new Object[0])));
/*     */       } else {
/*  26 */         this.field_146292_n.add(new GuiButton(1, this.field_146294_l / 2 - 100, this.field_146295_m / 4 + 96, I18n.func_135052_a("deathScreen.leaveServer", new Object[0])));
/*     */       } 
/*     */     } else {
/*  29 */       this.field_146292_n.add(new GuiButton(0, this.field_146294_l / 2 - 100, this.field_146295_m / 4 + 72, I18n.func_135052_a("deathScreen.respawn", new Object[0])));
/*  30 */       this.field_146292_n.add(new GuiButton(1, this.field_146294_l / 2 - 100, this.field_146295_m / 4 + 96, I18n.func_135052_a("deathScreen.titleScreen", new Object[0])));
/*     */       
/*  32 */       if (this.field_146297_k.func_110432_I() == null) {
/*  33 */         ((GuiButton)this.field_146292_n.get(1)).field_146124_l = false;
/*     */       }
/*     */     } 
/*  36 */     for (GuiButton guiButton : this.field_146292_n) {
/*  37 */       guiButton.field_146124_l = false;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {}
/*     */ 
/*     */   
/*     */   protected void func_146284_a(GuiButton p_146284_1_) {
/*     */     GuiYesNo guiYesNo;
/*  47 */     switch (p_146284_1_.field_146127_k) {
/*     */       case 0:
/*  49 */         this.field_146297_k.field_71439_g.func_71004_bE();
/*  50 */         this.field_146297_k.func_147108_a(null);
/*     */         break;
/*     */       case 1:
/*  53 */         guiYesNo = new GuiYesNo(this, I18n.func_135052_a("deathScreen.quit.confirm", new Object[0]), "", I18n.func_135052_a("deathScreen.titleScreen", new Object[0]), I18n.func_135052_a("deathScreen.respawn", new Object[0]), 0);
/*  54 */         this.field_146297_k.func_147108_a(guiYesNo);
/*  55 */         guiYesNo.func_146350_a(20);
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73878_a(boolean p_73878_1_, int p_73878_2_) {
/*  62 */     if (p_73878_1_) {
/*  63 */       this.field_146297_k.field_71441_e.func_72882_A();
/*  64 */       this.field_146297_k.func_71403_a(null);
/*  65 */       this.field_146297_k.func_147108_a(new GuiMainMenu());
/*     */     } else {
/*  67 */       this.field_146297_k.field_71439_g.func_71004_bE();
/*  68 */       this.field_146297_k.func_147108_a(null);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/*  74 */     func_73733_a(0, 0, this.field_146294_l, this.field_146295_m, 1615855616, -1602211792);
/*     */     
/*  76 */     GL11.glPushMatrix();
/*  77 */     GL11.glScalef(2.0F, 2.0F, 2.0F);
/*     */     
/*  79 */     boolean bool = this.field_146297_k.field_71441_e.func_72912_H().func_76093_s();
/*     */     
/*  81 */     String str = bool ? I18n.func_135052_a("deathScreen.title.hardcore", new Object[0]) : I18n.func_135052_a("deathScreen.title", new Object[0]);
/*  82 */     func_73732_a(this.field_146289_q, str, this.field_146294_l / 2 / 2, 30, 16777215);
/*     */     
/*  84 */     GL11.glPopMatrix();
/*  85 */     if (bool) {
/*  86 */       func_73732_a(this.field_146289_q, I18n.func_135052_a("deathScreen.hardcoreInfo", new Object[0]), this.field_146294_l / 2, 144, 16777215);
/*     */     }
/*  88 */     func_73732_a(this.field_146289_q, I18n.func_135052_a("deathScreen.score", new Object[0]) + ": " + EnumChatFormatting.YELLOW + this.field_146297_k.field_71439_g.func_71037_bA(), this.field_146294_l / 2, 100, 16777215);
/*     */     
/*  90 */     super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_73868_f() {
/*  95 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73876_c() {
/* 100 */     super.func_73876_c();
/*     */     
/* 102 */     this.field_146347_a++;
/* 103 */     if (this.field_146347_a == 20)
/* 104 */       for (GuiButton guiButton : this.field_146292_n)
/* 105 */         guiButton.field_146124_l = true;  
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiGameOver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */