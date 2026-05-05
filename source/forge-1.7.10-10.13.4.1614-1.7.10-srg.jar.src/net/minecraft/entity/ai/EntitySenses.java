/*    */ package net.minecraft.entity.ai;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ 
/*    */ public class EntitySenses
/*    */ {
/*    */   EntityLiving field_75526_a;
/* 11 */   List field_75524_b = new ArrayList();
/* 12 */   List field_75525_c = new ArrayList();
/*    */   
/*    */   public EntitySenses(EntityLiving p_i1672_1_) {
/* 15 */     this.field_75526_a = p_i1672_1_;
/*    */   }
/*    */   private static final String __OBFID = "CL_00001628";
/*    */   public void func_75523_a() {
/* 19 */     this.field_75524_b.clear();
/* 20 */     this.field_75525_c.clear();
/*    */   }
/*    */   
/*    */   public boolean func_75522_a(Entity p_75522_1_) {
/* 24 */     if (this.field_75524_b.contains(p_75522_1_)) return true; 
/* 25 */     if (this.field_75525_c.contains(p_75522_1_)) return false;
/*    */     
/* 27 */     this.field_75526_a.field_70170_p.field_72984_F.func_76320_a("canSee");
/* 28 */     boolean bool = this.field_75526_a.func_70685_l(p_75522_1_);
/* 29 */     this.field_75526_a.field_70170_p.field_72984_F.func_76319_b();
/* 30 */     if (bool) { this.field_75524_b.add(p_75522_1_); }
/* 31 */     else { this.field_75525_c.add(p_75522_1_); }
/* 32 */      return bool;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntitySenses.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */