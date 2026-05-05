/*    */ package net.minecraft.client.gui;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.network.NetHandlerPlayClient;
/*    */ import net.minecraft.client.resources.I18n;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.play.client.C0BPacketEntityAction;
/*    */ 
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class GuiSleepMP
/*    */   extends GuiChat
/*    */ {
/*    */   private static final String __OBFID = "CL_00000697";
/*    */   
/*    */   public void func_73866_w_() {
/* 20 */     super.func_73866_w_();
/*    */     
/* 22 */     this.field_146292_n.add(new GuiButton(1, this.field_146294_l / 2 - 100, this.field_146295_m - 40, I18n.func_135052_a("multiplayer.stopSleeping", new Object[0])));
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {
/* 27 */     if (p_73869_2_ == 1) {
/* 28 */       func_146418_g();
/* 29 */     } else if (p_73869_2_ == 28 || p_73869_2_ == 156) {
/* 30 */       String str = this.field_146415_a.func_146179_b().trim();
/*    */       
/* 32 */       if (!str.isEmpty()) {
/* 33 */         this.field_146297_k.field_71439_g.func_71165_d(str);
/*    */       }
/*    */       
/* 36 */       this.field_146415_a.func_146180_a("");
/* 37 */       this.field_146297_k.field_71456_v.func_146158_b().func_146240_d();
/*    */     } else {
/* 39 */       super.func_73869_a(p_73869_1_, p_73869_2_);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_146284_a(GuiButton p_146284_1_) {
/* 45 */     if (p_146284_1_.field_146127_k == 1) {
/* 46 */       func_146418_g();
/*    */     } else {
/* 48 */       super.func_146284_a(p_146284_1_);
/*    */     } 
/*    */   }
/*    */   
/*    */   private void func_146418_g() {
/* 53 */     NetHandlerPlayClient netHandlerPlayClient = this.field_146297_k.field_71439_g.field_71174_a;
/* 54 */     netHandlerPlayClient.func_147297_a((Packet)new C0BPacketEntityAction((Entity)this.field_146297_k.field_71439_g, 3));
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiSleepMP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */