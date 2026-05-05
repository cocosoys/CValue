/*    */ package JinRyuu.DragonBC.common.Render;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class KintounBaseEntity
/*    */   extends Entity
/*    */ {
/* 10 */   private int cloudColor = 16777216;
/* 11 */   public int getCloudColor() { return this.cloudColor; } public void setCloudColor(int col) {
/* 12 */     this.cloudColor = col;
/*    */   }
/*    */   
/*    */   public KintounBaseEntity(World par1World) {
/* 16 */     super(par1World);
/*    */   }
/*    */   
/*    */   protected void func_70088_a() {}
/*    */   
/*    */   protected void func_70037_a(NBTTagCompound p_70037_1_) {}
/*    */   
/*    */   protected void func_70014_b(NBTTagCompound p_70014_1_) {}
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Render\KintounBaseEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */