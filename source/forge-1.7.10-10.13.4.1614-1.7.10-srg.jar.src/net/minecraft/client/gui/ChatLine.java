/*    */ package net.minecraft.client.gui;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import net.minecraft.util.IChatComponent;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ChatLine {
/*    */   private final int field_74543_a;
/*    */   private final IChatComponent field_74541_b;
/*    */   
/*    */   public ChatLine(int p_i45000_1_, IChatComponent p_i45000_2_, int p_i45000_3_) {
/* 11 */     this.field_74541_b = p_i45000_2_;
/* 12 */     this.field_74543_a = p_i45000_1_;
/* 13 */     this.field_74542_c = p_i45000_3_;
/*    */   }
/*    */   private final int field_74542_c; private static final String __OBFID = "CL_00000627";
/*    */   public IChatComponent func_151461_a() {
/* 17 */     return this.field_74541_b;
/*    */   }
/*    */   
/*    */   public int func_74540_b() {
/* 21 */     return this.field_74543_a;
/*    */   }
/*    */   
/*    */   public int func_74539_c() {
/* 25 */     return this.field_74542_c;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\ChatLine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */