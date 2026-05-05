/*    */ package JinRyuu.JRMCore.entity;
/*    */ 
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class EntityEnergyAttJ4
/*    */   extends EntityEnAttacks
/*    */ {
/*    */   private float size;
/*    */   private byte type;
/*    */   
/*    */   public float getSize() {
/* 12 */     return this.size;
/*    */   } public byte getType() {
/* 14 */     return this.type;
/*    */   }
/*    */ 
/*    */   
/* 18 */   public final int number_of_lightVerts = 10;
/* 19 */   public long[] lightVert = new long[10]; private int lightLivingTime;
/*    */   public int getLightLivingTime() {
/* 21 */     return this.lightLivingTime;
/*    */   }
/*    */   
/*    */   public EntityEnergyAttJ4(World w, byte type, double x, double y, double z) {
/* 25 */     super(w);
/* 26 */     this.type = type;
/* 27 */     this.size = 1.0F;
/* 28 */     func_70105_a(this.size, this.size);
/* 29 */     this.field_70165_t = x;
/* 30 */     this.field_70163_u = y;
/* 31 */     this.field_70161_v = z;
/*    */   }
/*    */   
/*    */   public void func_70071_h_() {
/* 35 */     if (this.field_70170_p.field_72995_K) {
/* 36 */       if (this.field_70173_aa == 1) {
/* 37 */         func_70105_a(this.size, this.size);
/*    */       }
/*    */       
/* 40 */       if (this.field_70173_aa > 20) {
/* 41 */         func_70106_y();
/*    */       }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 49 */       func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\entity\EntityEnergyAttJ4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */