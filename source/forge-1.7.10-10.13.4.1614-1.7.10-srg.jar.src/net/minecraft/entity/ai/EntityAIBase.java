/*    */ package net.minecraft.entity.ai;
/*    */ 
/*    */ public abstract class EntityAIBase {
/*    */   private int field_75254_a;
/*    */   private static final String __OBFID = "CL_00001587";
/*    */   
/*    */   public abstract boolean func_75250_a();
/*    */   
/*    */   public boolean func_75253_b() {
/* 10 */     return func_75250_a();
/*    */   }
/*    */   
/*    */   public boolean func_75252_g() {
/* 14 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75249_e() {}
/*    */ 
/*    */   
/*    */   public void func_75251_c() {}
/*    */ 
/*    */   
/*    */   public void func_75246_d() {}
/*    */   
/*    */   public void func_75248_a(int p_75248_1_) {
/* 27 */     this.field_75254_a = p_75248_1_;
/*    */   }
/*    */   
/*    */   public int func_75247_h() {
/* 31 */     return this.field_75254_a;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityAIBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */