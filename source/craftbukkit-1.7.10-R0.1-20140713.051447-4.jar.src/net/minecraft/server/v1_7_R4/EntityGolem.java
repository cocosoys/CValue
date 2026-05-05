/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ public abstract class EntityGolem
/*    */   extends EntityCreature
/*    */   implements IAnimal
/*    */ {
/*    */   public EntityGolem(World paramWorld) {
/*  8 */     super(paramWorld);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void b(float paramFloat) {}
/*    */ 
/*    */   
/*    */   protected String t() {
/* 17 */     return "none";
/*    */   }
/*    */ 
/*    */   
/*    */   protected String aT() {
/* 22 */     return "none";
/*    */   }
/*    */ 
/*    */   
/*    */   protected String aU() {
/* 27 */     return "none";
/*    */   }
/*    */ 
/*    */   
/*    */   public int q() {
/* 32 */     return 120;
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean isTypeNotPersistent() {
/* 37 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\EntityGolem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */