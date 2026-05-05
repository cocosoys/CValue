/*    */ package net.minecraft.entity.ai;
/*    */ 
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ 
/*    */ public class EntityAISwimming
/*    */   extends EntityAIBase {
/*    */   private EntityLiving field_75373_a;
/*    */   private static final String __OBFID = "CL_00001584";
/*    */   
/*    */   public EntityAISwimming(EntityLiving p_i1624_1_) {
/* 11 */     this.field_75373_a = p_i1624_1_;
/* 12 */     func_75248_a(4);
/* 13 */     p_i1624_1_.func_70661_as().func_75495_e(true);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75250_a() {
/* 18 */     return (this.field_75373_a.func_70090_H() || this.field_75373_a.func_70058_J());
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75246_d() {
/* 23 */     if (this.field_75373_a.func_70681_au().nextFloat() < 0.8F) this.field_75373_a.func_70683_ar().func_75660_a(); 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityAISwimming.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */