/*    */ package net.minecraft.entity.monster;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.IEntityLivingData;
/*    */ import net.minecraft.entity.SharedMonsterAttributes;
/*    */ import net.minecraft.potion.PotionEffect;
/*    */ import net.minecraft.world.EnumDifficulty;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class EntityCaveSpider extends EntitySpider {
/*    */   public EntityCaveSpider(World p_i1732_1_) {
/* 11 */     super(p_i1732_1_);
/* 12 */     func_70105_a(0.7F, 0.5F);
/*    */   }
/*    */   private static final String __OBFID = "CL_00001683";
/*    */   
/*    */   protected void func_110147_ax() {
/* 17 */     super.func_110147_ax();
/*    */     
/* 19 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(12.0D);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_70652_k(Entity p_70652_1_) {
/* 24 */     if (super.func_70652_k(p_70652_1_)) {
/*    */       
/* 26 */       if (p_70652_1_ instanceof EntityLivingBase) {
/* 27 */         byte b = 0;
/* 28 */         if (this.field_70170_p.field_73013_u == EnumDifficulty.NORMAL) {
/* 29 */           b = 7;
/* 30 */         } else if (this.field_70170_p.field_73013_u == EnumDifficulty.HARD) {
/* 31 */           b = 15;
/*    */         } 
/*    */         
/* 34 */         if (b > 0) {
/* 35 */           ((EntityLivingBase)p_70652_1_).func_70690_d(new PotionEffect(Potion.field_76436_u.field_76415_H, b * 20, 0));
/*    */         }
/*    */       } 
/*    */       
/* 39 */       return true;
/*    */     } 
/* 41 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IEntityLivingData func_110161_a(IEntityLivingData p_110161_1_) {
/* 47 */     return p_110161_1_;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\monster\EntityCaveSpider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */