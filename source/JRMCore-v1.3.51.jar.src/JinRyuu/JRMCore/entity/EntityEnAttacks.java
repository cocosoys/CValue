/*    */ package JinRyuu.JRMCore.entity;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class EntityEnAttacks extends Entity {
/*    */   public EntityEnAttacks(World par1World) {
/*  9 */     super(par1World);
/*    */   }
/*    */ 
/*    */   
/*    */   public Entity shootingEntity;
/*    */ 
/*    */   
/*    */   protected void func_70088_a() {}
/*    */   
/*    */   protected void func_70037_a(NBTTagCompound var1) {}
/*    */   
/*    */   protected void func_70014_b(NBTTagCompound var1) {}
/*    */   
/*    */   public long getPower(Entity entity) {
/* 23 */     return 1L;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\entity\EntityEnAttacks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */