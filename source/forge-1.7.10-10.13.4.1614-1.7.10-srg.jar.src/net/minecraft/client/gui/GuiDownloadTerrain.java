/*    */ package net.minecraft.client.gui;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.network.NetHandlerPlayClient;
/*    */ import net.minecraft.client.resources.I18n;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.play.client.C00PacketKeepAlive;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class GuiDownloadTerrain extends GuiScreen {
/*    */   public GuiDownloadTerrain(NetHandlerPlayClient p_i45023_1_) {
/* 12 */     this.field_146594_a = p_i45023_1_;
/*    */   }
/*    */   private NetHandlerPlayClient field_146594_a;
/*    */   private int field_146593_f;
/*    */   private static final String __OBFID = "CL_00000708";
/*    */   
/*    */   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {}
/*    */   
/*    */   public void func_73866_w_() {
/* 21 */     this.field_146292_n.clear();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_73876_c() {
/* 26 */     this.field_146593_f++;
/* 27 */     if (this.field_146593_f % 20 == 0) {
/* 28 */       this.field_146594_a.func_147297_a((Packet)new C00PacketKeepAlive());
/*    */     }
/* 30 */     if (this.field_146594_a != null) {
/* 31 */       this.field_146594_a.func_147233_a();
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/* 37 */     func_146278_c(0);
/*    */     
/* 39 */     func_73732_a(this.field_146289_q, I18n.func_135052_a("multiplayer.downloadingTerrain", new Object[0]), this.field_146294_l / 2, this.field_146295_m / 2 - 50, 16777215);
/*    */     
/* 41 */     super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_73868_f() {
/* 46 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiDownloadTerrain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */