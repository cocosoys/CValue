/*    */ package net.minecraft.tileentity;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ 
/*    */ public class TileEntityEnchantmentTable
/*    */   extends TileEntity {
/*    */   public int field_145926_a;
/*    */   public float field_145933_i;
/*    */   public float field_145931_j;
/*    */   public float field_145932_k;
/*    */   public float field_145929_l;
/* 14 */   private static Random field_145923_r = new Random(); public float field_145930_m; public float field_145927_n; public float field_145928_o; public float field_145925_p; public float field_145924_q;
/*    */   private String field_145922_s;
/*    */   private static final String __OBFID = "CL_00000354";
/*    */   
/*    */   public void func_145841_b(NBTTagCompound p_145841_1_) {
/* 19 */     super.func_145841_b(p_145841_1_);
/* 20 */     if (func_145921_b()) p_145841_1_.func_74778_a("CustomName", this.field_145922_s);
/*    */   
/*    */   }
/*    */   
/*    */   public void func_145839_a(NBTTagCompound p_145839_1_) {
/* 25 */     super.func_145839_a(p_145839_1_);
/* 26 */     if (p_145839_1_.func_150297_b("CustomName", 8)) this.field_145922_s = p_145839_1_.func_74779_i("CustomName");
/*    */   
/*    */   }
/*    */   
/*    */   public void func_145845_h() {
/* 31 */     super.func_145845_h();
/* 32 */     this.field_145927_n = this.field_145930_m;
/* 33 */     this.field_145925_p = this.field_145928_o;
/*    */     
/* 35 */     EntityPlayer entityPlayer = this.field_145850_b.func_72977_a((this.field_145851_c + 0.5F), (this.field_145848_d + 0.5F), (this.field_145849_e + 0.5F), 3.0D);
/* 36 */     if (entityPlayer != null) {
/* 37 */       double d1 = entityPlayer.field_70165_t - (this.field_145851_c + 0.5F);
/* 38 */       double d2 = entityPlayer.field_70161_v - (this.field_145849_e + 0.5F);
/*    */       
/* 40 */       this.field_145924_q = (float)Math.atan2(d2, d1);
/*    */       
/* 42 */       this.field_145930_m += 0.1F;
/*    */       
/* 44 */       if (this.field_145930_m < 0.5F || field_145923_r.nextInt(40) == 0) {
/* 45 */         float f = this.field_145932_k;
/*    */         do {
/* 47 */           this.field_145932_k += (field_145923_r.nextInt(4) - field_145923_r.nextInt(4));
/* 48 */         } while (f == this.field_145932_k);
/*    */       } 
/*    */     } else {
/*    */       
/* 52 */       this.field_145924_q += 0.02F;
/* 53 */       this.field_145930_m -= 0.1F;
/*    */     } 
/*    */     
/* 56 */     while (this.field_145928_o >= 3.1415927F)
/* 57 */       this.field_145928_o -= 6.2831855F; 
/* 58 */     while (this.field_145928_o < -3.1415927F)
/* 59 */       this.field_145928_o += 6.2831855F; 
/* 60 */     while (this.field_145924_q >= 3.1415927F)
/* 61 */       this.field_145924_q -= 6.2831855F; 
/* 62 */     while (this.field_145924_q < -3.1415927F)
/* 63 */       this.field_145924_q += 6.2831855F; 
/* 64 */     float f1 = this.field_145924_q - this.field_145928_o;
/* 65 */     while (f1 >= 3.1415927F)
/* 66 */       f1 -= 6.2831855F; 
/* 67 */     while (f1 < -3.1415927F) {
/* 68 */       f1 += 6.2831855F;
/*    */     }
/* 70 */     this.field_145928_o += f1 * 0.4F;
/*    */     
/* 72 */     if (this.field_145930_m < 0.0F) this.field_145930_m = 0.0F; 
/* 73 */     if (this.field_145930_m > 1.0F) this.field_145930_m = 1.0F;
/*    */     
/* 75 */     this.field_145926_a++;
/* 76 */     this.field_145931_j = this.field_145933_i;
/*    */     
/* 78 */     float f2 = (this.field_145932_k - this.field_145933_i) * 0.4F;
/* 79 */     float f3 = 0.2F;
/* 80 */     if (f2 < -f3) f2 = -f3; 
/* 81 */     if (f2 > f3) f2 = f3; 
/* 82 */     this.field_145929_l += (f2 - this.field_145929_l) * 0.9F;
/*    */     
/* 84 */     this.field_145933_i += this.field_145929_l;
/*    */   }
/*    */   
/*    */   public String func_145919_a() {
/* 88 */     return func_145921_b() ? this.field_145922_s : "container.enchant";
/*    */   }
/*    */   
/*    */   public boolean func_145921_b() {
/* 92 */     return (this.field_145922_s != null && this.field_145922_s.length() > 0);
/*    */   }
/*    */   
/*    */   public void func_145920_a(String p_145920_1_) {
/* 96 */     this.field_145922_s = p_145920_1_;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\tileentity\TileEntityEnchantmentTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */