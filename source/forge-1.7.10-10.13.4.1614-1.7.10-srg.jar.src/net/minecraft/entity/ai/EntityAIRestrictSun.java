/*    */ package net.minecraft.entity.ai;
/*    */ 
/*    */ import net.minecraft.entity.EntityCreature;
/*    */ 
/*    */ public class EntityAIRestrictSun extends EntityAIBase {
/*    */   private EntityCreature field_75273_a;
/*    */   
/*    */   public EntityAIRestrictSun(EntityCreature p_i1652_1_) {
/*  9 */     this.field_75273_a = p_i1652_1_;
/*    */   }
/*    */   private static final String __OBFID = "CL_00001611";
/*    */   
/*    */   public boolean func_75250_a() {
/* 14 */     return this.field_75273_a.field_70170_p.func_72935_r();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75249_e() {
/* 19 */     this.field_75273_a.func_70661_as().func_75504_d(true);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75251_c() {
/* 24 */     this.field_75273_a.func_70661_as().func_75504_d(false);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityAIRestrictSun.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */