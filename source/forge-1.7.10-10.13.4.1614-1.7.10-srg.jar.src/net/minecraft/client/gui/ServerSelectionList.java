/*    */ package net.minecraft.client.gui;
/*    */ 
/*    */ import com.google.common.collect.Lists;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.List;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.multiplayer.ServerList;
/*    */ import net.minecraft.client.network.LanServerDetector;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ServerSelectionList extends GuiListExtended {
/* 13 */   private final List field_148198_l = Lists.newArrayList(); private final GuiMultiplayer field_148200_k;
/* 14 */   private final List field_148199_m = Lists.newArrayList();
/* 15 */   private final GuiListExtended.IGuiListEntry field_148196_n = new ServerListEntryLanScan();
/* 16 */   private int field_148197_o = -1; private static final String __OBFID = "CL_00000819";
/*    */   
/*    */   public ServerSelectionList(GuiMultiplayer p_i45049_1_, Minecraft p_i45049_2_, int p_i45049_3_, int p_i45049_4_, int p_i45049_5_, int p_i45049_6_, int p_i45049_7_) {
/* 19 */     super(p_i45049_2_, p_i45049_3_, p_i45049_4_, p_i45049_5_, p_i45049_6_, p_i45049_7_);
/* 20 */     this.field_148200_k = p_i45049_1_;
/*    */   }
/*    */ 
/*    */   
/*    */   public GuiListExtended.IGuiListEntry func_148180_b(int p_148180_1_) {
/* 25 */     if (p_148180_1_ < this.field_148198_l.size()) {
/* 26 */       return this.field_148198_l.get(p_148180_1_);
/*    */     }
/* 28 */     p_148180_1_ -= this.field_148198_l.size();
/*    */     
/* 30 */     if (p_148180_1_ == 0) {
/* 31 */       return this.field_148196_n;
/*    */     }
/* 33 */     p_148180_1_--;
/*    */     
/* 35 */     return this.field_148199_m.get(p_148180_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   protected int func_148127_b() {
/* 40 */     return this.field_148198_l.size() + 1 + this.field_148199_m.size();
/*    */   }
/*    */   
/*    */   public void func_148192_c(int p_148192_1_) {
/* 44 */     this.field_148197_o = p_148192_1_;
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean func_148131_a(int p_148131_1_) {
/* 49 */     return (p_148131_1_ == this.field_148197_o);
/*    */   }
/*    */   
/*    */   public int func_148193_k() {
/* 53 */     return this.field_148197_o;
/*    */   }
/*    */   
/*    */   public void func_148195_a(ServerList p_148195_1_) {
/* 57 */     this.field_148198_l.clear();
/*    */     
/* 59 */     for (byte b = 0; b < p_148195_1_.func_78856_c(); b++) {
/* 60 */       this.field_148198_l.add(new ServerListEntryNormal(this.field_148200_k, p_148195_1_.func_78850_a(b)));
/*    */     }
/*    */   }
/*    */   
/*    */   public void func_148194_a(List p_148194_1_) {
/* 65 */     this.field_148199_m.clear();
/*    */     
/* 67 */     for (LanServerDetector.LanServer lanServer : p_148194_1_) {
/* 68 */       this.field_148199_m.add(new ServerListEntryLanDetected(this.field_148200_k, lanServer));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   protected int func_148137_d() {
/* 74 */     return super.func_148137_d() + 30;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_148139_c() {
/* 79 */     return super.func_148139_c() + 85;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\ServerSelectionList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */