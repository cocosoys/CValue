/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PathfinderGoalLookAtTradingPlayer
/*    */   extends PathfinderGoalLookAtPlayer
/*    */ {
/*    */   private final EntityVillager b;
/*    */   
/*    */   public PathfinderGoalLookAtTradingPlayer(EntityVillager paramEntityVillager) {
/* 11 */     super(paramEntityVillager, EntityHuman.class, 8.0F);
/* 12 */     this.b = paramEntityVillager;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean a() {
/* 17 */     if (this.b.cc()) {
/* 18 */       this.a = this.b.b();
/* 19 */       return true;
/*    */     } 
/* 21 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PathfinderGoalLookAtTradingPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */