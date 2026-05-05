/*    */ package JinRyuu.DragonBC.common.Render;
/*    */ 
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ 
/*    */ public class MedPodDoor1TileEntity
/*    */   extends TileEntity {
/*    */   public boolean canUpdate() {
/*  9 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_145841_b(NBTTagCompound par1) {
/* 15 */     super.func_145841_b(par1);
/* 16 */     par1.func_74768_a("cb", this.cb);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_145839_a(NBTTagCompound par1) {
/* 22 */     super.func_145839_a(par1);
/* 23 */     this.cb = par1.func_74762_e("cb");
/*    */   }
/*    */   
/*    */   public int getCb() {
/* 27 */     return this.cb;
/*    */   }
/*    */   
/*    */   public void setCb(int cb) {
/* 31 */     this.cb = cb;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean shouldRenderInPass(int pass) {
/* 37 */     return (pass == 1);
/*    */   }
/* 39 */   private int cb = 0;
/*    */   
/*    */   public void func_145845_h() {
/* 42 */     updateSound();
/* 43 */     super.func_145845_h();
/*    */   }
/*    */   private void updateSound() {
/* 46 */     int meta = func_145832_p();
/* 47 */     if (meta > 3 && this.cb <= 20) {
/* 48 */       this.cb++;
/*    */     }
/* 50 */     if (meta < 4 && this.cb > 0)
/* 51 */       this.cb--; 
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Render\MedPodDoor1TileEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */