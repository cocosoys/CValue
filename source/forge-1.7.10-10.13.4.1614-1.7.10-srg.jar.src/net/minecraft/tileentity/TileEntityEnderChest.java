/*    */ package net.minecraft.tileentity;
/*    */ 
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.init.Blocks;
/*    */ 
/*    */ 
/*    */ public class TileEntityEnderChest
/*    */   extends TileEntity
/*    */ {
/*    */   public float field_145972_a;
/*    */   public float field_145975_i;
/*    */   public int field_145973_j;
/*    */   private int field_145974_k;
/*    */   private static final String __OBFID = "CL_00000355";
/*    */   
/*    */   public void func_145845_h() {
/* 17 */     super.func_145845_h();
/*    */     
/* 19 */     if (++this.field_145974_k % 20 * 4 == 0) {
/* 20 */       this.field_145850_b.func_147452_c(this.field_145851_c, this.field_145848_d, this.field_145849_e, Blocks.field_150477_bB, 1, this.field_145973_j);
/*    */     }
/*    */     
/* 23 */     this.field_145975_i = this.field_145972_a;
/*    */     
/* 25 */     float f = 0.1F;
/* 26 */     if (this.field_145973_j > 0 && this.field_145972_a == 0.0F) {
/* 27 */       double d1 = this.field_145851_c + 0.5D;
/* 28 */       double d2 = this.field_145849_e + 0.5D;
/*    */       
/* 30 */       this.field_145850_b.func_72908_a(d1, this.field_145848_d + 0.5D, d2, "random.chestopen", 0.5F, this.field_145850_b.field_73012_v.nextFloat() * 0.1F + 0.9F);
/*    */     } 
/* 32 */     if ((this.field_145973_j == 0 && this.field_145972_a > 0.0F) || (this.field_145973_j > 0 && this.field_145972_a < 1.0F)) {
/* 33 */       float f1 = this.field_145972_a;
/* 34 */       if (this.field_145973_j > 0) { this.field_145972_a += f; }
/* 35 */       else { this.field_145972_a -= f; }
/* 36 */        if (this.field_145972_a > 1.0F) {
/* 37 */         this.field_145972_a = 1.0F;
/*    */       }
/* 39 */       float f2 = 0.5F;
/* 40 */       if (this.field_145972_a < f2 && f1 >= f2) {
/* 41 */         double d1 = this.field_145851_c + 0.5D;
/* 42 */         double d2 = this.field_145849_e + 0.5D;
/*    */         
/* 44 */         this.field_145850_b.func_72908_a(d1, this.field_145848_d + 0.5D, d2, "random.chestclosed", 0.5F, this.field_145850_b.field_73012_v.nextFloat() * 0.1F + 0.9F);
/*    */       } 
/* 46 */       if (this.field_145972_a < 0.0F) {
/* 47 */         this.field_145972_a = 0.0F;
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_145842_c(int p_145842_1_, int p_145842_2_) {
/* 54 */     if (p_145842_1_ == 1) {
/* 55 */       this.field_145973_j = p_145842_2_;
/* 56 */       return true;
/*    */     } 
/* 58 */     return super.func_145842_c(p_145842_1_, p_145842_2_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_145843_s() {
/* 63 */     func_145836_u();
/* 64 */     super.func_145843_s();
/*    */   }
/*    */   
/*    */   public void func_145969_a() {
/* 68 */     this.field_145973_j++;
/* 69 */     this.field_145850_b.func_147452_c(this.field_145851_c, this.field_145848_d, this.field_145849_e, Blocks.field_150477_bB, 1, this.field_145973_j);
/*    */   }
/*    */   
/*    */   public void func_145970_b() {
/* 73 */     this.field_145973_j--;
/* 74 */     this.field_145850_b.func_147452_c(this.field_145851_c, this.field_145848_d, this.field_145849_e, Blocks.field_150477_bB, 1, this.field_145973_j);
/*    */   }
/*    */   
/*    */   public boolean func_145971_a(EntityPlayer p_145971_1_) {
/* 78 */     if (this.field_145850_b.func_147438_o(this.field_145851_c, this.field_145848_d, this.field_145849_e) != this) return false; 
/* 79 */     if (p_145971_1_.func_70092_e(this.field_145851_c + 0.5D, this.field_145848_d + 0.5D, this.field_145849_e + 0.5D) > 64.0D) return false;
/*    */     
/* 81 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\tileentity\TileEntityEnderChest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */