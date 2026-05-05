/*    */ package net.minecraft.client.gui;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public abstract class GuiListExtended extends GuiSlot {
/*    */   public GuiListExtended(Minecraft p_i45010_1_, int p_i45010_2_, int p_i45010_3_, int p_i45010_4_, int p_i45010_5_, int p_i45010_6_) {
/*  8 */     super(p_i45010_1_, p_i45010_2_, p_i45010_3_, p_i45010_4_, p_i45010_5_, p_i45010_6_);
/*    */   }
/*    */ 
/*    */   
/*    */   private static final String __OBFID = "CL_00000674";
/*    */   
/*    */   protected void func_148144_a(int p_148144_1_, boolean p_148144_2_, int p_148144_3_, int p_148144_4_) {}
/*    */   
/*    */   protected boolean func_148131_a(int p_148131_1_) {
/* 17 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_148123_a() {}
/*    */ 
/*    */   
/*    */   protected void func_148126_a(int p_148126_1_, int p_148126_2_, int p_148126_3_, int p_148126_4_, Tessellator p_148126_5_, int p_148126_6_, int p_148126_7_) {
/* 26 */     func_148180_b(p_148126_1_).func_148279_a(p_148126_1_, p_148126_2_, p_148126_3_, func_148139_c(), p_148126_4_, p_148126_5_, p_148126_6_, p_148126_7_, (func_148124_c(p_148126_6_, p_148126_7_) == p_148126_1_));
/*    */   }
/*    */   
/*    */   public boolean func_148179_a(int p_148179_1_, int p_148179_2_, int p_148179_3_) {
/* 30 */     if (func_148141_e(p_148179_2_)) {
/* 31 */       int i = func_148124_c(p_148179_1_, p_148179_2_);
/* 32 */       if (i >= 0) {
/* 33 */         int j = this.field_148152_e + this.field_148155_a / 2 - func_148139_c() / 2 + 2;
/* 34 */         int k = this.field_148153_b + 4 - func_148148_g() + i * this.field_148149_f + this.field_148160_j;
/* 35 */         int m = p_148179_1_ - j;
/* 36 */         int n = p_148179_2_ - k;
/* 37 */         if (func_148180_b(i).func_148278_a(i, p_148179_1_, p_148179_2_, p_148179_3_, m, n)) {
/* 38 */           func_148143_b(false);
/* 39 */           return true;
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 44 */     return false;
/*    */   }
/*    */   
/*    */   public boolean func_148181_b(int p_148181_1_, int p_148181_2_, int p_148181_3_) {
/* 48 */     for (byte b = 0; b < func_148127_b(); b++) {
/* 49 */       int i = this.field_148152_e + this.field_148155_a / 2 - func_148139_c() / 2 + 2;
/* 50 */       int j = this.field_148153_b + 4 - func_148148_g() + b * this.field_148149_f + this.field_148160_j;
/* 51 */       int k = p_148181_1_ - i;
/* 52 */       int m = p_148181_2_ - j;
/* 53 */       func_148180_b(b).func_148277_b(b, p_148181_1_, p_148181_2_, p_148181_3_, k, m);
/*    */     } 
/*    */     
/* 56 */     func_148143_b(true);
/* 57 */     return false;
/*    */   }
/*    */   
/*    */   public abstract IGuiListEntry func_148180_b(int paramInt);
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public static interface IGuiListEntry {
/*    */     void func_148279_a(int param1Int1, int param1Int2, int param1Int3, int param1Int4, int param1Int5, Tessellator param1Tessellator, int param1Int6, int param1Int7, boolean param1Boolean);
/*    */     
/*    */     boolean func_148278_a(int param1Int1, int param1Int2, int param1Int3, int param1Int4, int param1Int5, int param1Int6);
/*    */     
/*    */     void func_148277_b(int param1Int1, int param1Int2, int param1Int3, int param1Int4, int param1Int5, int param1Int6);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiListExtended.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */