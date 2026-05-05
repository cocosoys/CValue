/*    */ package net.minecraft.entity.ai;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.passive.EntityTameable;
/*    */ 
/*    */ public class EntityAISit
/*    */   extends EntityAIBase {
/*    */   private EntityTameable field_75272_a;
/*    */   
/*    */   public EntityAISit(EntityTameable p_i1654_1_) {
/* 12 */     this.field_75272_a = p_i1654_1_;
/* 13 */     func_75248_a(5);
/*    */   }
/*    */   private boolean field_75271_b; private static final String __OBFID = "CL_00001613";
/*    */   
/*    */   public boolean func_75250_a() {
/* 18 */     if (!this.field_75272_a.func_70909_n()) return false; 
/* 19 */     if (this.field_75272_a.func_70090_H()) return false; 
/* 20 */     if (!this.field_75272_a.field_70122_E) return false;
/*    */     
/* 22 */     EntityLivingBase entityLivingBase = this.field_75272_a.func_70902_q();
/* 23 */     if (entityLivingBase == null) return true;
/*    */     
/* 25 */     if (this.field_75272_a.func_70068_e((Entity)entityLivingBase) < 144.0D && entityLivingBase.func_70643_av() != null) {
/* 26 */       return false;
/*    */     }
/* 28 */     return this.field_75271_b;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75249_e() {
/* 33 */     this.field_75272_a.func_70661_as().func_75499_g();
/* 34 */     this.field_75272_a.func_70904_g(true);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75251_c() {
/* 39 */     this.field_75272_a.func_70904_g(false);
/*    */   }
/*    */   
/*    */   public void func_75270_a(boolean p_75270_1_) {
/* 43 */     this.field_75271_b = p_75270_1_;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityAISit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */