/*    */ package net.minecraft.entity.ai;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.monster.EntityIronGolem;
/*    */ import net.minecraft.entity.passive.EntityVillager;
/*    */ 
/*    */ public class EntityAIFollowGolem
/*    */   extends EntityAIBase {
/*    */   private EntityVillager field_75294_a;
/*    */   private EntityIronGolem field_75292_b;
/*    */   private int field_75293_c;
/*    */   private boolean field_75291_d;
/*    */   private static final String __OBFID = "CL_00001615";
/*    */   
/*    */   public EntityAIFollowGolem(EntityVillager p_i1656_1_) {
/* 17 */     this.field_75294_a = p_i1656_1_;
/* 18 */     func_75248_a(3);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75250_a() {
/* 23 */     if (this.field_75294_a.func_70874_b() >= 0) return false; 
/* 24 */     if (!this.field_75294_a.field_70170_p.func_72935_r()) return false;
/*    */     
/* 26 */     List list = this.field_75294_a.field_70170_p.func_72872_a(EntityIronGolem.class, this.field_75294_a.field_70121_D.func_72314_b(6.0D, 2.0D, 6.0D));
/* 27 */     if (list.isEmpty()) return false;
/*    */     
/* 29 */     for (EntityIronGolem entityIronGolem : list) {
/* 30 */       if (entityIronGolem.func_70853_p() > 0) {
/* 31 */         this.field_75292_b = entityIronGolem;
/*    */         break;
/*    */       } 
/*    */     } 
/* 35 */     return (this.field_75292_b != null);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75253_b() {
/* 40 */     return (this.field_75292_b.func_70853_p() > 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75249_e() {
/* 45 */     this.field_75293_c = this.field_75294_a.func_70681_au().nextInt(320);
/* 46 */     this.field_75291_d = false;
/* 47 */     this.field_75292_b.func_70661_as().func_75499_g();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75251_c() {
/* 52 */     this.field_75292_b = null;
/* 53 */     this.field_75294_a.func_70661_as().func_75499_g();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75246_d() {
/* 58 */     this.field_75294_a.func_70671_ap().func_75651_a((Entity)this.field_75292_b, 30.0F, 30.0F);
/* 59 */     if (this.field_75292_b.func_70853_p() == this.field_75293_c) {
/* 60 */       this.field_75294_a.func_70661_as().func_75497_a((Entity)this.field_75292_b, 0.5D);
/* 61 */       this.field_75291_d = true;
/*    */     } 
/*    */     
/* 64 */     if (this.field_75291_d && 
/* 65 */       this.field_75294_a.func_70068_e((Entity)this.field_75292_b) < 4.0D) {
/* 66 */       this.field_75292_b.func_70851_e(false);
/* 67 */       this.field_75294_a.func_70661_as().func_75499_g();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityAIFollowGolem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */