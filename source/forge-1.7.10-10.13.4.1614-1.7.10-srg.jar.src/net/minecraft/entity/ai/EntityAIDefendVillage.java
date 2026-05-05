/*    */ package net.minecraft.entity.ai;
/*    */ 
/*    */ import net.minecraft.entity.EntityCreature;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.monster.EntityIronGolem;
/*    */ import net.minecraft.village.Village;
/*    */ 
/*    */ public class EntityAIDefendVillage extends EntityAITarget {
/*    */   EntityIronGolem field_75305_a;
/*    */   
/*    */   public EntityAIDefendVillage(EntityIronGolem p_i1659_1_) {
/* 12 */     super((EntityCreature)p_i1659_1_, false, true);
/* 13 */     this.field_75305_a = p_i1659_1_;
/* 14 */     func_75248_a(1);
/*    */   }
/*    */   EntityLivingBase field_75304_b; private static final String __OBFID = "CL_00001618";
/*    */   
/*    */   public boolean func_75250_a() {
/* 19 */     Village village = this.field_75305_a.func_70852_n();
/* 20 */     if (village == null) return false; 
/* 21 */     this.field_75304_b = village.func_75571_b((EntityLivingBase)this.field_75305_a);
/* 22 */     if (!func_75296_a(this.field_75304_b, false)) {
/*    */       
/* 24 */       if (this.field_75299_d.func_70681_au().nextInt(20) == 0) {
/* 25 */         this.field_75304_b = (EntityLivingBase)village.func_82685_c((EntityLivingBase)this.field_75305_a);
/* 26 */         return func_75296_a(this.field_75304_b, false);
/*    */       } 
/* 28 */       return false;
/*    */     } 
/* 30 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_75249_e() {
/* 36 */     this.field_75305_a.func_70624_b(this.field_75304_b);
/* 37 */     super.func_75249_e();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityAIDefendVillage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */