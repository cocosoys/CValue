/*    */ package JinRyuu.DragonBC.common.Render;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class block01dbcEntity extends Entity {
/*    */   public double bx;
/*    */   public double by;
/*    */   public double bz;
/*    */   
/*    */   public block01dbcEntity(World p_i1582_1_) {
/* 11 */     super(p_i1582_1_);
/* 12 */     func_70105_a(0.01F, 0.01F);
/*    */   }
/*    */   public block01dbcEntity(World p_i1582_1_, double bx, double by, double bz) {
/* 15 */     super(p_i1582_1_);
/* 16 */     this.bx = bx;
/* 17 */     this.by = by;
/* 18 */     this.bz = bz;
/* 19 */     func_70107_b(bx + 0.5D, by, bz + 0.5D);
/* 20 */     this.field_70130_N = this.field_70131_O = 0.01F;
/* 21 */     func_70105_a(this.field_70130_N, this.field_70131_O);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getX() {
/* 28 */     return (int)this.bx;
/* 29 */   } public int getY() { return (int)this.by; } public int getZ() {
/* 30 */     return (int)this.bz;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70030_z() {
/* 35 */     if (this.field_70153_n == null || this.field_70170_p.func_147437_c((int)this.bx, (int)this.by, (int)this.bz))
/* 36 */       func_70106_y(); 
/*    */   }
/*    */   
/*    */   protected boolean func_142008_O() {
/* 40 */     return false;
/*    */   } public double func_70042_X() {
/* 42 */     return this.field_70131_O - 0.2D;
/*    */   }
/*    */   
/*    */   protected void func_70088_a() {}
/*    */   
/*    */   protected void func_70037_a(NBTTagCompound p_70037_1_) {}
/*    */   
/*    */   protected void func_70014_b(NBTTagCompound p_70014_1_) {}
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Render\block01dbcEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */