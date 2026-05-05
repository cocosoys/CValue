/*    */ package net.minecraft.entity.ai;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.monster.EntityCreeper;
/*    */ 
/*    */ public class EntityAICreeperSwell
/*    */   extends EntityAIBase {
/*    */   EntityCreeper field_75269_a;
/*    */   
/*    */   public EntityAICreeperSwell(EntityCreeper p_i1655_1_) {
/* 12 */     this.field_75269_a = p_i1655_1_;
/* 13 */     func_75248_a(1);
/*    */   }
/*    */   EntityLivingBase field_75268_b; private static final String __OBFID = "CL_00001614";
/*    */   
/*    */   public boolean func_75250_a() {
/* 18 */     EntityLivingBase entityLivingBase = this.field_75269_a.func_70638_az();
/* 19 */     return (this.field_75269_a.func_70832_p() > 0 || (entityLivingBase != null && this.field_75269_a.func_70068_e((Entity)entityLivingBase) < 9.0D));
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75249_e() {
/* 24 */     this.field_75269_a.func_70661_as().func_75499_g();
/* 25 */     this.field_75268_b = this.field_75269_a.func_70638_az();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75251_c() {
/* 30 */     this.field_75268_b = null;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75246_d() {
/* 35 */     if (this.field_75268_b == null) {
/* 36 */       this.field_75269_a.func_70829_a(-1);
/*    */       
/*    */       return;
/*    */     } 
/* 40 */     if (this.field_75269_a.func_70068_e((Entity)this.field_75268_b) > 49.0D) {
/* 41 */       this.field_75269_a.func_70829_a(-1);
/*    */       
/*    */       return;
/*    */     } 
/* 45 */     if (!this.field_75269_a.func_70635_at().func_75522_a((Entity)this.field_75268_b)) {
/* 46 */       this.field_75269_a.func_70829_a(-1);
/*    */       
/*    */       return;
/*    */     } 
/* 50 */     this.field_75269_a.func_70829_a(1);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityAICreeperSwell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */