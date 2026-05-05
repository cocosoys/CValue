/*    */ package net.minecraft.entity.ai;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.monster.EntityIronGolem;
/*    */ import net.minecraft.entity.passive.EntityVillager;
/*    */ 
/*    */ public class EntityAILookAtVillager
/*    */   extends EntityAIBase {
/*    */   private EntityIronGolem field_75397_a;
/*    */   private EntityVillager field_75395_b;
/*    */   private int field_75396_c;
/*    */   private static final String __OBFID = "CL_00001602";
/*    */   
/*    */   public EntityAILookAtVillager(EntityIronGolem p_i1643_1_) {
/* 15 */     this.field_75397_a = p_i1643_1_;
/* 16 */     func_75248_a(3);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75250_a() {
/* 21 */     if (!this.field_75397_a.field_70170_p.func_72935_r()) return false; 
/* 22 */     if (this.field_75397_a.func_70681_au().nextInt(8000) != 0) return false; 
/* 23 */     this.field_75395_b = (EntityVillager)this.field_75397_a.field_70170_p.func_72857_a(EntityVillager.class, this.field_75397_a.field_70121_D.func_72314_b(6.0D, 2.0D, 6.0D), (Entity)this.field_75397_a);
/* 24 */     return (this.field_75395_b != null);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75253_b() {
/* 29 */     return (this.field_75396_c > 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75249_e() {
/* 34 */     this.field_75396_c = 400;
/* 35 */     this.field_75397_a.func_70851_e(true);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75251_c() {
/* 40 */     this.field_75397_a.func_70851_e(false);
/* 41 */     this.field_75395_b = null;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75246_d() {
/* 46 */     this.field_75397_a.func_70671_ap().func_75651_a((Entity)this.field_75395_b, 30.0F, 30.0F);
/* 47 */     this.field_75396_c--;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityAILookAtVillager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */