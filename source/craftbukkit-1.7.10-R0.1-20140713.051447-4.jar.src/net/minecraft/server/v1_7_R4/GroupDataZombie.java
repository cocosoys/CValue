/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ class GroupDataZombie
/*    */   implements GroupDataEntity
/*    */ {
/*    */   public boolean a;
/*    */   public boolean b;
/*    */   final EntityZombie c;
/*    */   
/*    */   private GroupDataZombie(EntityZombie entityzombie, boolean flag, boolean flag1) {
/* 11 */     this.c = entityzombie;
/* 12 */     this.a = false;
/* 13 */     this.b = false;
/* 14 */     this.a = flag;
/* 15 */     this.b = flag1;
/*    */   }
/*    */   
/*    */   GroupDataZombie(EntityZombie entityzombie, boolean flag, boolean flag1, EmptyClassZombie emptyclasszombie) {
/* 19 */     this(entityzombie, flag, flag1);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\GroupDataZombie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */