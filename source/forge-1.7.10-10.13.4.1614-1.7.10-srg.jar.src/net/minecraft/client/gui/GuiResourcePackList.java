/*    */ package net.minecraft.client.gui;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.List;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.client.resources.ResourcePackListEntry;
/*    */ import net.minecraft.util.EnumChatFormatting;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public abstract class GuiResourcePackList extends GuiListExtended {
/*    */   protected final Minecraft field_148205_k;
/*    */   
/*    */   public GuiResourcePackList(Minecraft p_i45055_1_, int p_i45055_2_, int p_i45055_3_, List p_i45055_4_) {
/* 16 */     super(p_i45055_1_, p_i45055_2_, p_i45055_3_, 32, p_i45055_3_ - 55 + 4, 36);
/* 17 */     this.field_148205_k = p_i45055_1_;
/* 18 */     this.field_148204_l = p_i45055_4_;
/* 19 */     this.field_148163_i = false;
/*    */     
/* 21 */     func_148133_a(true, (int)(p_i45055_1_.field_71466_p.field_78288_b * 1.5F));
/*    */   }
/*    */   protected final List field_148204_l; private static final String __OBFID = "CL_00000825";
/*    */   
/*    */   protected void func_148129_a(int p_148129_1_, int p_148129_2_, Tessellator p_148129_3_) {
/* 26 */     String str = EnumChatFormatting.UNDERLINE + "" + EnumChatFormatting.BOLD + func_148202_k();
/* 27 */     this.field_148205_k.field_71466_p.func_78276_b(str, p_148129_1_ + this.field_148155_a / 2 - this.field_148205_k.field_71466_p.func_78256_a(str) / 2, Math.min(this.field_148153_b + 3, p_148129_2_), 16777215);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public List func_148201_l() {
/* 33 */     return this.field_148204_l;
/*    */   }
/*    */ 
/*    */   
/*    */   protected int func_148127_b() {
/* 38 */     return func_148201_l().size();
/*    */   }
/*    */ 
/*    */   
/*    */   public ResourcePackListEntry func_148180_b(int p_148180_1_) {
/* 43 */     return func_148201_l().get(p_148180_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_148139_c() {
/* 48 */     return this.field_148155_a;
/*    */   }
/*    */ 
/*    */   
/*    */   protected int func_148137_d() {
/* 53 */     return this.field_148151_d - 6;
/*    */   }
/*    */   
/*    */   protected abstract String func_148202_k();
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiResourcePackList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */