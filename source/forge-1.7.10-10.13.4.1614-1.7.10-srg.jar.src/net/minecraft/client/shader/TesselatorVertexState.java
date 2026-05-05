/*    */ package net.minecraft.client.shader;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class TesselatorVertexState
/*    */ {
/*    */   private int[] field_147583_a;
/*    */   private int field_147581_b;
/*    */   private int field_147582_c;
/*    */   private boolean field_147579_d;
/*    */   
/*    */   public TesselatorVertexState(int[] p_i45079_1_, int p_i45079_2_, int p_i45079_3_, boolean p_i45079_4_, boolean p_i45079_5_, boolean p_i45079_6_, boolean p_i45079_7_) {
/* 15 */     this.field_147583_a = p_i45079_1_;
/* 16 */     this.field_147581_b = p_i45079_2_;
/* 17 */     this.field_147582_c = p_i45079_3_;
/* 18 */     this.field_147579_d = p_i45079_4_;
/* 19 */     this.field_147580_e = p_i45079_5_;
/* 20 */     this.field_147577_f = p_i45079_6_;
/* 21 */     this.field_147578_g = p_i45079_7_;
/*    */   }
/*    */   private boolean field_147580_e; private boolean field_147577_f; private boolean field_147578_g; private static final String __OBFID = "CL_00000961";
/*    */   public int[] func_147572_a() {
/* 25 */     return this.field_147583_a;
/*    */   }
/*    */   
/*    */   public int func_147576_b() {
/* 29 */     return this.field_147581_b;
/*    */   }
/*    */   
/*    */   public int func_147575_c() {
/* 33 */     return this.field_147582_c;
/*    */   }
/*    */   
/*    */   public boolean func_147573_d() {
/* 37 */     return this.field_147579_d;
/*    */   }
/*    */   
/*    */   public boolean func_147571_e() {
/* 41 */     return this.field_147580_e;
/*    */   }
/*    */   
/*    */   public boolean func_147570_f() {
/* 45 */     return this.field_147577_f;
/*    */   }
/*    */   
/*    */   public boolean func_147574_g() {
/* 49 */     return this.field_147578_g;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\shader\TesselatorVertexState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */