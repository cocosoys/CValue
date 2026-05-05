/*    */ package net.minecraft.entity.ai;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityCreature;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.passive.EntityVillager;
/*    */ import net.minecraft.util.Vec3;
/*    */ 
/*    */ public class EntityAIPlay
/*    */   extends EntityAIBase {
/*    */   private EntityVillager field_75262_a;
/*    */   private EntityLivingBase field_75260_b;
/*    */   private double field_75261_c;
/*    */   private int field_75259_d;
/*    */   private static final String __OBFID = "CL_00001605";
/*    */   
/*    */   public EntityAIPlay(EntityVillager p_i1646_1_, double p_i1646_2_) {
/* 19 */     this.field_75262_a = p_i1646_1_;
/* 20 */     this.field_75261_c = p_i1646_2_;
/* 21 */     func_75248_a(1);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75250_a() {
/* 26 */     if (this.field_75262_a.func_70874_b() >= 0) return false; 
/* 27 */     if (this.field_75262_a.func_70681_au().nextInt(400) != 0) return false;
/*    */     
/* 29 */     List list = this.field_75262_a.field_70170_p.func_72872_a(EntityVillager.class, this.field_75262_a.field_70121_D.func_72314_b(6.0D, 3.0D, 6.0D));
/* 30 */     double d = Double.MAX_VALUE;
/* 31 */     for (EntityVillager entityVillager : list) {
/* 32 */       if (entityVillager == this.field_75262_a || 
/* 33 */         entityVillager.func_70945_p() || 
/* 34 */         entityVillager.func_70874_b() >= 0)
/* 35 */         continue;  double d1 = entityVillager.func_70068_e((Entity)this.field_75262_a);
/* 36 */       if (d1 > d)
/* 37 */         continue;  d = d1;
/* 38 */       this.field_75260_b = (EntityLivingBase)entityVillager;
/*    */     } 
/*    */     
/* 41 */     if (this.field_75260_b == null) {
/* 42 */       Vec3 vec3 = RandomPositionGenerator.func_75463_a((EntityCreature)this.field_75262_a, 16, 3);
/* 43 */       if (vec3 == null) return false; 
/*    */     } 
/* 45 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75253_b() {
/* 50 */     return (this.field_75259_d > 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75249_e() {
/* 55 */     if (this.field_75260_b != null) this.field_75262_a.func_70939_f(true); 
/* 56 */     this.field_75259_d = 1000;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75251_c() {
/* 61 */     this.field_75262_a.func_70939_f(false);
/* 62 */     this.field_75260_b = null;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75246_d() {
/* 67 */     this.field_75259_d--;
/* 68 */     if (this.field_75260_b != null) {
/* 69 */       if (this.field_75262_a.func_70068_e((Entity)this.field_75260_b) > 4.0D) this.field_75262_a.func_70661_as().func_75497_a((Entity)this.field_75260_b, this.field_75261_c);
/*    */     
/* 71 */     } else if (this.field_75262_a.func_70661_as().func_75500_f()) {
/* 72 */       Vec3 vec3 = RandomPositionGenerator.func_75463_a((EntityCreature)this.field_75262_a, 16, 3);
/* 73 */       if (vec3 == null)
/* 74 */         return;  this.field_75262_a.func_70661_as().func_75492_a(vec3.field_72450_a, vec3.field_72448_b, vec3.field_72449_c, this.field_75261_c);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityAIPlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */