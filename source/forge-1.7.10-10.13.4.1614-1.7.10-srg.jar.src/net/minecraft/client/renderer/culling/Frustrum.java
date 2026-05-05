/*    */ package net.minecraft.client.renderer.culling;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.util.AxisAlignedBB;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class Frustrum
/*    */   implements ICamera {
/* 10 */   private ClippingHelper field_78552_a = ClippingHelperImpl.func_78558_a();
/*    */   private double field_78550_b;
/*    */   private double field_78551_c;
/*    */   private double field_78549_d;
/*    */   private static final String __OBFID = "CL_00000976";
/*    */   
/*    */   public void func_78547_a(double p_78547_1_, double p_78547_3_, double p_78547_5_) {
/* 17 */     this.field_78550_b = p_78547_1_;
/* 18 */     this.field_78551_c = p_78547_3_;
/* 19 */     this.field_78549_d = p_78547_5_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_78548_b(double p_78548_1_, double p_78548_3_, double p_78548_5_, double p_78548_7_, double p_78548_9_, double p_78548_11_) {
/* 29 */     return this.field_78552_a.func_78553_b(p_78548_1_ - this.field_78550_b, p_78548_3_ - this.field_78551_c, p_78548_5_ - this.field_78549_d, p_78548_7_ - this.field_78550_b, p_78548_9_ - this.field_78551_c, p_78548_11_ - this.field_78549_d);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_78546_a(AxisAlignedBB p_78546_1_) {
/* 34 */     return func_78548_b(p_78546_1_.field_72340_a, p_78546_1_.field_72338_b, p_78546_1_.field_72339_c, p_78546_1_.field_72336_d, p_78546_1_.field_72337_e, p_78546_1_.field_72334_f);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\culling\Frustrum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */