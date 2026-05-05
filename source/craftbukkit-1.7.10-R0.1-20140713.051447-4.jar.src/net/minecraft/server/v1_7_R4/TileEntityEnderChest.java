/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TileEntityEnderChest
/*    */   extends TileEntity
/*    */ {
/*    */   public float a;
/*    */   public float i;
/*    */   public int j;
/*    */   private int k;
/*    */   
/*    */   public void h() {
/* 17 */     super.h();
/*    */     
/* 19 */     if (++this.k % 20 * 4 == 0) {
/* 20 */       this.world.playBlockAction(this.x, this.y, this.z, Blocks.ENDER_CHEST, 1, this.j);
/*    */     }
/*    */     
/* 23 */     this.i = this.a;
/*    */     
/* 25 */     float f = 0.1F;
/* 26 */     if (this.j > 0 && this.a == 0.0F) {
/* 27 */       double d1 = this.x + 0.5D;
/* 28 */       double d2 = this.z + 0.5D;
/*    */       
/* 30 */       this.world.makeSound(d1, this.y + 0.5D, d2, "random.chestopen", 0.5F, this.world.random.nextFloat() * 0.1F + 0.9F);
/*    */     } 
/* 32 */     if ((this.j == 0 && this.a > 0.0F) || (this.j > 0 && this.a < 1.0F)) {
/* 33 */       float f1 = this.a;
/* 34 */       if (this.j > 0) { this.a += f; }
/* 35 */       else { this.a -= f; }
/* 36 */        if (this.a > 1.0F) {
/* 37 */         this.a = 1.0F;
/*    */       }
/* 39 */       float f2 = 0.5F;
/* 40 */       if (this.a < f2 && f1 >= f2) {
/* 41 */         double d1 = this.x + 0.5D;
/* 42 */         double d2 = this.z + 0.5D;
/*    */         
/* 44 */         this.world.makeSound(d1, this.y + 0.5D, d2, "random.chestclosed", 0.5F, this.world.random.nextFloat() * 0.1F + 0.9F);
/*    */       } 
/* 46 */       if (this.a < 0.0F) {
/* 47 */         this.a = 0.0F;
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean c(int paramInt1, int paramInt2) {
/* 54 */     if (paramInt1 == 1) {
/* 55 */       this.j = paramInt2;
/* 56 */       return true;
/*    */     } 
/* 58 */     return super.c(paramInt1, paramInt2);
/*    */   }
/*    */ 
/*    */   
/*    */   public void s() {
/* 63 */     u();
/* 64 */     super.s();
/*    */   }
/*    */   
/*    */   public void a() {
/* 68 */     this.j++;
/* 69 */     this.world.playBlockAction(this.x, this.y, this.z, Blocks.ENDER_CHEST, 1, this.j);
/*    */   }
/*    */   
/*    */   public void b() {
/* 73 */     this.j--;
/* 74 */     this.world.playBlockAction(this.x, this.y, this.z, Blocks.ENDER_CHEST, 1, this.j);
/*    */   }
/*    */   
/*    */   public boolean a(EntityHuman paramEntityHuman) {
/* 78 */     if (this.world.getTileEntity(this.x, this.y, this.z) != this) return false; 
/* 79 */     if (paramEntityHuman.e(this.x + 0.5D, this.y + 0.5D, this.z + 0.5D) > 64.0D) return false;
/*    */     
/* 81 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\TileEntityEnderChest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */