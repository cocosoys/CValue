/*    */ package net.minecraft.entity.ai;
/*    */ import net.minecraft.entity.EntityCreature;
/*    */ import net.minecraft.entity.passive.EntityTameable;
/*    */ 
/*    */ public class EntityAITargetNonTamed extends EntityAINearestAttackableTarget {
/*    */   private EntityTameable field_75310_g;
/*    */   
/*    */   public EntityAITargetNonTamed(EntityTameable p_i1666_1_, Class p_i1666_2_, int p_i1666_3_, boolean p_i1666_4_) {
/*  9 */     super((EntityCreature)p_i1666_1_, p_i1666_2_, p_i1666_3_, p_i1666_4_);
/* 10 */     this.field_75310_g = p_i1666_1_;
/*    */   }
/*    */   private static final String __OBFID = "CL_00001623";
/*    */   
/*    */   public boolean func_75250_a() {
/* 15 */     return (!this.field_75310_g.func_70909_n() && super.func_75250_a());
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityAITargetNonTamed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */