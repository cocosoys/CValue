/*    */ package net.minecraft.client.resources.data;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class AnimationFrame {
/*    */   private final int field_110499_a;
/*    */   
/*    */   public AnimationFrame(int p_i1307_1_) {
/* 10 */     this(p_i1307_1_, -1);
/*    */   }
/*    */   private final int field_110498_b; private static final String __OBFID = "CL_00001104";
/*    */   public AnimationFrame(int p_i1308_1_, int p_i1308_2_) {
/* 14 */     this.field_110499_a = p_i1308_1_;
/* 15 */     this.field_110498_b = p_i1308_2_;
/*    */   }
/*    */   
/*    */   public boolean func_110495_a() {
/* 19 */     return (this.field_110498_b == -1);
/*    */   }
/*    */   
/*    */   public int func_110497_b() {
/* 23 */     return this.field_110498_b;
/*    */   }
/*    */   
/*    */   public int func_110496_c() {
/* 27 */     return this.field_110499_a;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\resources\data\AnimationFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */