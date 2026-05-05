/*    */ package net.minecraft.entity.monster;
/*    */ import net.minecraft.entity.SharedMonsterAttributes;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class EntityGiantZombie extends EntityMob {
/*    */   public EntityGiantZombie(World p_i1736_1_) {
/*  7 */     super(p_i1736_1_);
/*  8 */     this.field_70129_M *= 6.0F;
/*  9 */     func_70105_a(this.field_70130_N * 6.0F, this.field_70131_O * 6.0F);
/*    */   }
/*    */   private static final String __OBFID = "CL_00001690";
/*    */   
/*    */   protected void func_110147_ax() {
/* 14 */     super.func_110147_ax();
/*    */     
/* 16 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(100.0D);
/* 17 */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.5D);
/* 18 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(50.0D);
/*    */   }
/*    */ 
/*    */   
/*    */   public float func_70783_a(int p_70783_1_, int p_70783_2_, int p_70783_3_) {
/* 23 */     return this.field_70170_p.func_72801_o(p_70783_1_, p_70783_2_, p_70783_3_) - 0.5F;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\monster\EntityGiantZombie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */