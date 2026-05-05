/*    */ package net.minecraft.entity.ai;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityCreature;
/*    */ import net.minecraft.entity.passive.EntityHorse;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.Vec3;
/*    */ 
/*    */ public class EntityAIRunAroundLikeCrazy
/*    */   extends EntityAIBase {
/*    */   private EntityHorse field_111180_a;
/*    */   private double field_111178_b;
/*    */   private double field_111179_c;
/*    */   
/*    */   public EntityAIRunAroundLikeCrazy(EntityHorse p_i1653_1_, double p_i1653_2_) {
/* 16 */     this.field_111180_a = p_i1653_1_;
/* 17 */     this.field_111178_b = p_i1653_2_;
/* 18 */     func_75248_a(1);
/*    */   }
/*    */   private double field_111176_d; private double field_111177_e; private static final String __OBFID = "CL_00001612";
/*    */   
/*    */   public boolean func_75250_a() {
/* 23 */     if (this.field_111180_a.func_110248_bS() || this.field_111180_a.field_70153_n == null) return false; 
/* 24 */     Vec3 vec3 = RandomPositionGenerator.func_75463_a((EntityCreature)this.field_111180_a, 5, 4);
/* 25 */     if (vec3 == null) return false; 
/* 26 */     this.field_111179_c = vec3.field_72450_a;
/* 27 */     this.field_111176_d = vec3.field_72448_b;
/* 28 */     this.field_111177_e = vec3.field_72449_c;
/* 29 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75249_e() {
/* 34 */     this.field_111180_a.func_70661_as().func_75492_a(this.field_111179_c, this.field_111176_d, this.field_111177_e, this.field_111178_b);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75253_b() {
/* 39 */     return (!this.field_111180_a.func_70661_as().func_75500_f() && this.field_111180_a.field_70153_n != null);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75246_d() {
/* 44 */     if (this.field_111180_a.func_70681_au().nextInt(50) == 0) {
/*    */       
/* 46 */       if (this.field_111180_a.field_70153_n instanceof EntityPlayer) {
/* 47 */         int i = this.field_111180_a.func_110252_cg();
/* 48 */         int j = this.field_111180_a.func_110218_cm();
/* 49 */         if (j > 0 && this.field_111180_a.func_70681_au().nextInt(j) < i) {
/* 50 */           this.field_111180_a.func_110263_g((EntityPlayer)this.field_111180_a.field_70153_n);
/* 51 */           this.field_111180_a.field_70170_p.func_72960_a((Entity)this.field_111180_a, (byte)7);
/*    */           return;
/*    */         } 
/* 54 */         this.field_111180_a.func_110198_t(5);
/*    */       } 
/*    */       
/* 57 */       this.field_111180_a.field_70153_n.func_70078_a(null);
/* 58 */       this.field_111180_a.field_70153_n = null;
/* 59 */       this.field_111180_a.func_110231_cz();
/* 60 */       this.field_111180_a.field_70170_p.func_72960_a((Entity)this.field_111180_a, (byte)6);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityAIRunAroundLikeCrazy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */