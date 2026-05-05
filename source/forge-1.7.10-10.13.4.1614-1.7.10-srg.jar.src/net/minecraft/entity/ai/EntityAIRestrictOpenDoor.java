/*    */ package net.minecraft.entity.ai;
/*    */ 
/*    */ import net.minecraft.entity.EntityCreature;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.village.Village;
/*    */ import net.minecraft.village.VillageDoorInfo;
/*    */ 
/*    */ public class EntityAIRestrictOpenDoor extends EntityAIBase {
/*    */   private EntityCreature field_75275_a;
/*    */   
/*    */   public EntityAIRestrictOpenDoor(EntityCreature p_i1651_1_) {
/* 12 */     this.field_75275_a = p_i1651_1_;
/*    */   }
/*    */   private VillageDoorInfo field_75274_b; private static final String __OBFID = "CL_00001610";
/*    */   
/*    */   public boolean func_75250_a() {
/* 17 */     if (this.field_75275_a.field_70170_p.func_72935_r()) return false; 
/* 18 */     Village village = this.field_75275_a.field_70170_p.field_72982_D.func_75550_a(MathHelper.func_76128_c(this.field_75275_a.field_70165_t), MathHelper.func_76128_c(this.field_75275_a.field_70163_u), MathHelper.func_76128_c(this.field_75275_a.field_70161_v), 16);
/* 19 */     if (village == null) return false; 
/* 20 */     this.field_75274_b = village.func_75564_b(MathHelper.func_76128_c(this.field_75275_a.field_70165_t), MathHelper.func_76128_c(this.field_75275_a.field_70163_u), MathHelper.func_76128_c(this.field_75275_a.field_70161_v));
/* 21 */     if (this.field_75274_b == null) return false; 
/* 22 */     return (this.field_75274_b.func_75469_c(MathHelper.func_76128_c(this.field_75275_a.field_70165_t), MathHelper.func_76128_c(this.field_75275_a.field_70163_u), MathHelper.func_76128_c(this.field_75275_a.field_70161_v)) < 2.25D);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75253_b() {
/* 27 */     if (this.field_75275_a.field_70170_p.func_72935_r()) return false; 
/* 28 */     return (!this.field_75274_b.field_75476_g && this.field_75274_b.func_75467_a(MathHelper.func_76128_c(this.field_75275_a.field_70165_t), MathHelper.func_76128_c(this.field_75275_a.field_70161_v)));
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75249_e() {
/* 33 */     this.field_75275_a.func_70661_as().func_75498_b(false);
/* 34 */     this.field_75275_a.func_70661_as().func_75490_c(false);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75251_c() {
/* 39 */     this.field_75275_a.func_70661_as().func_75498_b(true);
/* 40 */     this.field_75275_a.func_70661_as().func_75490_c(true);
/* 41 */     this.field_75274_b = null;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75246_d() {
/* 46 */     this.field_75274_b.func_75470_e();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityAIRestrictOpenDoor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */