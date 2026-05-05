/*    */ package net.minecraft.client.gui;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.client.resources.I18n;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ServerListEntryLanScan
/*    */   implements GuiListExtended.IGuiListEntry {
/* 12 */   private final Minecraft field_148288_a = Minecraft.func_71410_x();
/*    */   private static final String __OBFID = "CL_00000815";
/*    */   
/*    */   public void func_148279_a(int p_148279_1_, int p_148279_2_, int p_148279_3_, int p_148279_4_, int p_148279_5_, Tessellator p_148279_6_, int p_148279_7_, int p_148279_8_, boolean p_148279_9_) {
/*    */     String str;
/* 17 */     int i = p_148279_3_ + p_148279_5_ / 2 - this.field_148288_a.field_71466_p.field_78288_b / 2;
/* 18 */     this.field_148288_a.field_71466_p.func_78276_b(I18n.func_135052_a("lanServer.scanning", new Object[0]), this.field_148288_a.field_71462_r.field_146294_l / 2 - this.field_148288_a.field_71466_p.func_78256_a(I18n.func_135052_a("lanServer.scanning", new Object[0])) / 2, i, 16777215);
/*    */     
/* 20 */     switch ((int)(Minecraft.func_71386_F() / 300L % 4L)) {
/*    */       
/*    */       default:
/* 23 */         str = "O o o";
/*    */         break;
/*    */       case 1:
/*    */       case 3:
/* 27 */         str = "o O o";
/*    */         break;
/*    */       case 2:
/* 30 */         str = "o o O";
/*    */         break;
/*    */     } 
/* 33 */     this.field_148288_a.field_71466_p.func_78276_b(str, this.field_148288_a.field_71462_r.field_146294_l / 2 - this.field_148288_a.field_71466_p.func_78256_a(str) / 2, i + this.field_148288_a.field_71466_p.field_78288_b, 8421504);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_148278_a(int p_148278_1_, int p_148278_2_, int p_148278_3_, int p_148278_4_, int p_148278_5_, int p_148278_6_) {
/* 38 */     return false;
/*    */   }
/*    */   
/*    */   public void func_148277_b(int p_148277_1_, int p_148277_2_, int p_148277_3_, int p_148277_4_, int p_148277_5_, int p_148277_6_) {}
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\ServerListEntryLanScan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */