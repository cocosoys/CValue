/*    */ package net.minecraft.client.audio;@SideOnly(Side.CLIENT)
/*    */ public interface ISound { ResourceLocation func_147650_b(); boolean func_147657_c(); int func_147652_d(); float func_147653_e(); float func_147655_f();
/*    */   float func_147649_g();
/*    */   float func_147654_h();
/*    */   float func_147651_i();
/*    */   AttenuationType func_147656_j();
/*    */   @SideOnly(Side.CLIENT)
/*  8 */   public enum AttenuationType { NONE(0),
/*  9 */     LINEAR(2);
/*    */     private final int field_148589_c;
/*    */     private static final String __OBFID = "CL_00001126";
/*    */     
/*    */     AttenuationType(int p_i45110_3_) {
/* 14 */       this.field_148589_c = p_i45110_3_;
/*    */     }
/*    */     
/*    */     public int func_148586_a() {
/* 18 */       return this.field_148589_c;
/*    */     } }
/*    */    }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\audio\ISound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */