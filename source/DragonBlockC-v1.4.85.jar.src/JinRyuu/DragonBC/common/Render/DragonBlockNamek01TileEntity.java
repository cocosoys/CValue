/*    */ package JinRyuu.DragonBC.common.Render;
/*    */ 
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.tileentity.TileEntityChest;
/*    */ 
/*    */ public class DragonBlockNamek01TileEntity extends TileEntityChest {
/*    */   public boolean canUpdate() {
/*  9 */     return true;
/*    */   } public void func_145841_b(NBTTagCompound par1) {
/* 11 */     super.func_145841_b(par1);
/*    */   } public void func_145839_a(NBTTagCompound par1) {
/* 13 */     super.func_145839_a(par1);
/*    */   } public boolean shouldRenderInPass(int pass) {
/* 15 */     return (pass == 0);
/* 16 */   } private int cb = 100;
/* 17 */   private int cb2 = 100; public int getcb2() {
/* 18 */     return this.cb2;
/*    */   }
/*    */   
/*    */   public void func_145845_h() {
/* 22 */     updateSound();
/* 23 */     super.func_145845_h();
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void updateSound() {
/* 57 */     this.cb--;
/* 58 */     if (this.cb <= 0) {
/* 59 */       this.cb = 100;
/* 60 */       int par2 = this.field_145851_c;
/* 61 */       int par3 = this.field_145848_d;
/* 62 */       int par4 = this.field_145849_e;
/* 63 */       Block bi = this.field_145850_b.func_147439_a(par2, par3, par4);
/* 64 */       if (!this.field_145850_b.field_72995_K)
/*    */       {
/* 66 */         if (this.field_145850_b.func_147439_a(par2 + 1, par3, par4) == bi) {
/* 67 */           if (this.field_145850_b.func_147439_a(par2 + 1, par3, par4 + 1) == bi && 
/* 68 */             this.field_145850_b.func_147439_a(par2 + 1, par3, par4 - 1) == bi && 
/* 69 */             this.field_145850_b.func_147439_a(par2 - 1, par3, par4) == bi && 
/* 70 */             this.field_145850_b.func_147439_a(par2 - 1, par3, par4 - 1) == bi && 
/* 71 */             this.field_145850_b.func_147439_a(par2 - 1, par3, par4 + 1) == bi)
/*    */           {
/*    */             
/* 74 */             this.field_145850_b.func_72908_a(par2, par3, par4, "jinryuudragonbc:dragon.glow", 1.0F, 1.0F);
/*    */ 
/*    */ 
/*    */ 
/*    */           
/*    */           }
/*    */ 
/*    */ 
/*    */         
/*    */         }
/* 84 */         else if (this.field_145850_b.func_147439_a(par2, par3, par4 + 1) == bi && 
/* 85 */           this.field_145850_b.func_147439_a(par2 + 1, par3, par4 + 1) == bi && 
/* 86 */           this.field_145850_b.func_147439_a(par2 + 1, par3, par4 - 1) == bi && 
/* 87 */           this.field_145850_b.func_147439_a(par2, par3, par4 - 1) == bi && 
/* 88 */           this.field_145850_b.func_147439_a(par2 - 1, par3, par4 - 1) == bi && 
/* 89 */           this.field_145850_b.func_147439_a(par2 - 1, par3, par4 + 1) == bi) {
/*    */ 
/*    */           
/* 92 */           this.field_145850_b.func_72908_a(par2, par3, par4, "jinryuudragonbc:dragon.glow", 1.0F, 1.0F);
/*    */         } 
/*    */       }
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Render\DragonBlockNamek01TileEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */