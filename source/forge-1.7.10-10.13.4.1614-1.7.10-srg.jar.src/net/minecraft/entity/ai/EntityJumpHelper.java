/*    */ package net.minecraft.entity.ai;
/*    */ 
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ 
/*    */ public class EntityJumpHelper
/*    */ {
/*    */   private EntityLiving field_75663_a;
/*    */   
/*    */   public EntityJumpHelper(EntityLiving p_i1612_1_) {
/* 10 */     this.field_75663_a = p_i1612_1_;
/*    */   }
/*    */   private boolean field_75662_b; private static final String __OBFID = "CL_00001571";
/*    */   public void func_75660_a() {
/* 14 */     this.field_75662_b = true;
/*    */   }
/*    */   
/*    */   public void func_75661_b() {
/* 18 */     this.field_75663_a.func_70637_d(this.field_75662_b);
/* 19 */     this.field_75662_b = false;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityJumpHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */