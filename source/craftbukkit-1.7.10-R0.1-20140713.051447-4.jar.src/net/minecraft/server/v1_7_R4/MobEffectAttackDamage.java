/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ public class MobEffectAttackDamage
/*    */   extends MobEffectList
/*    */ {
/*    */   protected MobEffectAttackDamage(int paramInt1, boolean paramBoolean, int paramInt2) {
/*  7 */     super(paramInt1, paramBoolean, paramInt2);
/*    */   }
/*    */ 
/*    */   
/*    */   public double a(int paramInt, AttributeModifier paramAttributeModifier) {
/* 12 */     if (this.id == MobEffectList.WEAKNESS.id) {
/* 13 */       return (-0.5F * (paramInt + 1));
/*    */     }
/* 15 */     return 1.3D * (paramInt + 1);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\MobEffectAttackDamage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */