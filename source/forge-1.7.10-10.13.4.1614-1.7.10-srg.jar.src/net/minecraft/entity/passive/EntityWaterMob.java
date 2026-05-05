/*    */ package net.minecraft.entity.passive;
/*    */ 
/*    */ import net.minecraft.entity.EntityCreature;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.DamageSource;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class EntityWaterMob
/*    */   extends EntityCreature
/*    */   implements IAnimals
/*    */ {
/*    */   private static final String __OBFID = "CL_00001653";
/*    */   
/*    */   public EntityWaterMob(World p_i1695_1_) {
/* 19 */     super(p_i1695_1_);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_70648_aU() {
/* 25 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_70601_bi() {
/* 30 */     return this.field_70170_p.func_72855_b(this.field_70121_D);
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_70627_aG() {
/* 35 */     return 120;
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean func_70692_ba() {
/* 40 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   protected int func_70693_a(EntityPlayer p_70693_1_) {
/* 45 */     return 1 + this.field_70170_p.field_73012_v.nextInt(3);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70030_z() {
/* 50 */     int i = func_70086_ai();
/*    */     
/* 52 */     super.func_70030_z();
/*    */     
/* 54 */     if (func_70089_S() && !func_70090_H()) {
/* 55 */       func_70050_g(--i);
/* 56 */       if (func_70086_ai() == -20) {
/* 57 */         func_70050_g(0);
/* 58 */         func_70097_a(DamageSource.field_76369_e, 2.0F);
/*    */       } 
/*    */     } else {
/* 61 */       func_70050_g(300);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\passive\EntityWaterMob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */