/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ 
/*    */ public class PathfinderGoalNearestAttackableTarget
/*    */   extends PathfinderGoalTarget {
/*    */   private final Class a;
/*    */   private final int b;
/*    */   private final DistanceComparator e;
/*    */   private final IEntitySelector f;
/*    */   private EntityLiving g;
/*    */   
/*    */   public PathfinderGoalNearestAttackableTarget(EntityCreature paramEntityCreature, Class paramClass, int paramInt, boolean paramBoolean) {
/* 15 */     this(paramEntityCreature, paramClass, paramInt, paramBoolean, false);
/*    */   }
/*    */   
/*    */   public PathfinderGoalNearestAttackableTarget(EntityCreature paramEntityCreature, Class paramClass, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
/* 19 */     this(paramEntityCreature, paramClass, paramInt, paramBoolean1, paramBoolean2, (IEntitySelector)null);
/*    */   }
/*    */   
/*    */   public PathfinderGoalNearestAttackableTarget(EntityCreature paramEntityCreature, Class paramClass, int paramInt, boolean paramBoolean1, boolean paramBoolean2, IEntitySelector paramIEntitySelector) {
/* 23 */     super(paramEntityCreature, paramBoolean1, paramBoolean2);
/* 24 */     this.a = paramClass;
/* 25 */     this.b = paramInt;
/* 26 */     this.e = new DistanceComparator(paramEntityCreature);
/* 27 */     a(1);
/*    */     
/* 29 */     this.f = new EntitySelectorNearestAttackableTarget(this, paramIEntitySelector);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean a() {
/* 41 */     if (this.b > 0 && this.c.aI().nextInt(this.b) != 0) return false;
/*    */     
/* 43 */     double d = f();
/* 44 */     List<?> list = this.c.world.a(this.a, this.c.boundingBox.grow(d, 4.0D, d), this.f);
/* 45 */     Collections.sort(list, this.e);
/*    */     
/* 47 */     if (list.isEmpty()) {
/* 48 */       return false;
/*    */     }
/* 50 */     this.g = (EntityLiving)list.get(0);
/* 51 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void c() {
/* 57 */     this.c.setGoalTarget(this.g);
/* 58 */     super.c();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PathfinderGoalNearestAttackableTarget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */