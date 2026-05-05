/*    */ package net.minecraft.client.gui;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.network.LanServerDetector;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.client.resources.I18n;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ServerListEntryLanDetected
/*    */   implements GuiListExtended.IGuiListEntry {
/*    */   private final GuiMultiplayer field_148292_c;
/*    */   protected final Minecraft field_148293_a;
/*    */   protected final LanServerDetector.LanServer field_148291_b;
/* 16 */   private long field_148290_d = 0L;
/*    */   
/*    */   protected ServerListEntryLanDetected(GuiMultiplayer p_i45046_1_, LanServerDetector.LanServer p_i45046_2_) {
/* 19 */     this.field_148292_c = p_i45046_1_;
/* 20 */     this.field_148291_b = p_i45046_2_;
/* 21 */     this.field_148293_a = Minecraft.func_71410_x();
/*    */   }
/*    */   private static final String __OBFID = "CL_00000816";
/*    */   
/*    */   public void func_148279_a(int p_148279_1_, int p_148279_2_, int p_148279_3_, int p_148279_4_, int p_148279_5_, Tessellator p_148279_6_, int p_148279_7_, int p_148279_8_, boolean p_148279_9_) {
/* 26 */     this.field_148293_a.field_71466_p.func_78276_b(I18n.func_135052_a("lanServer.title", new Object[0]), p_148279_2_ + 32 + 3, p_148279_3_ + 1, 16777215);
/* 27 */     this.field_148293_a.field_71466_p.func_78276_b(this.field_148291_b.func_77487_a(), p_148279_2_ + 32 + 3, p_148279_3_ + 12, 8421504);
/*    */     
/* 29 */     if (this.field_148293_a.field_71474_y.field_80005_w) {
/* 30 */       this.field_148293_a.field_71466_p.func_78276_b(I18n.func_135052_a("selectServer.hiddenAddress", new Object[0]), p_148279_2_ + 32 + 3, p_148279_3_ + 12 + 11, 3158064);
/*    */     } else {
/* 32 */       this.field_148293_a.field_71466_p.func_78276_b(this.field_148291_b.func_77488_b(), p_148279_2_ + 32 + 3, p_148279_3_ + 12 + 11, 3158064);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_148278_a(int p_148278_1_, int p_148278_2_, int p_148278_3_, int p_148278_4_, int p_148278_5_, int p_148278_6_) {
/* 38 */     this.field_148292_c.func_146790_a(p_148278_1_);
/* 39 */     if (Minecraft.func_71386_F() - this.field_148290_d < 250L) {
/* 40 */       this.field_148292_c.func_146796_h();
/*    */     }
/* 42 */     this.field_148290_d = Minecraft.func_71386_F();
/* 43 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148277_b(int p_148277_1_, int p_148277_2_, int p_148277_3_, int p_148277_4_, int p_148277_5_, int p_148277_6_) {}
/*    */ 
/*    */   
/*    */   public LanServerDetector.LanServer func_148289_a() {
/* 51 */     return this.field_148291_b;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\ServerListEntryLanDetected.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */