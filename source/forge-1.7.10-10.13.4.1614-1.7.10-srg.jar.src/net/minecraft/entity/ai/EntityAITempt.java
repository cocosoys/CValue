/*    */ package net.minecraft.entity.ai;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityCreature;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class EntityAITempt
/*    */   extends EntityAIBase
/*    */ {
/*    */   private EntityCreature field_75284_a;
/*    */   private double field_75282_b;
/*    */   private double field_75283_c;
/*    */   private double field_75280_d;
/*    */   private double field_75281_e;
/*    */   private double field_75278_f;
/*    */   private double field_75279_g;
/*    */   
/*    */   public EntityAITempt(EntityCreature p_i45316_1_, double p_i45316_2_, Item p_i45316_4_, boolean p_i45316_5_) {
/* 21 */     this.field_75284_a = p_i45316_1_;
/* 22 */     this.field_75282_b = p_i45316_2_;
/* 23 */     this.field_151484_k = p_i45316_4_;
/* 24 */     this.field_75285_l = p_i45316_5_;
/* 25 */     func_75248_a(3);
/*    */   }
/*    */   private EntityPlayer field_75289_h; private int field_75290_i; private boolean field_75287_j; private Item field_151484_k; private boolean field_75285_l; private boolean field_75286_m; private static final String __OBFID = "CL_00001616";
/*    */   
/*    */   public boolean func_75250_a() {
/* 30 */     if (this.field_75290_i > 0) {
/* 31 */       this.field_75290_i--;
/* 32 */       return false;
/*    */     } 
/* 34 */     this.field_75289_h = this.field_75284_a.field_70170_p.func_72890_a((Entity)this.field_75284_a, 10.0D);
/* 35 */     if (this.field_75289_h == null) return false; 
/* 36 */     ItemStack itemStack = this.field_75289_h.func_71045_bC();
/* 37 */     if (itemStack == null) return false; 
/* 38 */     if (itemStack.func_77973_b() != this.field_151484_k) return false; 
/* 39 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75253_b() {
/* 44 */     if (this.field_75285_l) {
/* 45 */       if (this.field_75284_a.func_70068_e((Entity)this.field_75289_h) < 36.0D) {
/* 46 */         if (this.field_75289_h.func_70092_e(this.field_75283_c, this.field_75280_d, this.field_75281_e) > 0.010000000000000002D) return false; 
/* 47 */         if (Math.abs(this.field_75289_h.field_70125_A - this.field_75278_f) > 5.0D || Math.abs(this.field_75289_h.field_70177_z - this.field_75279_g) > 5.0D) return false; 
/*    */       } else {
/* 49 */         this.field_75283_c = this.field_75289_h.field_70165_t;
/* 50 */         this.field_75280_d = this.field_75289_h.field_70163_u;
/* 51 */         this.field_75281_e = this.field_75289_h.field_70161_v;
/*    */       } 
/* 53 */       this.field_75278_f = this.field_75289_h.field_70125_A;
/* 54 */       this.field_75279_g = this.field_75289_h.field_70177_z;
/*    */     } 
/* 56 */     return func_75250_a();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75249_e() {
/* 61 */     this.field_75283_c = this.field_75289_h.field_70165_t;
/* 62 */     this.field_75280_d = this.field_75289_h.field_70163_u;
/* 63 */     this.field_75281_e = this.field_75289_h.field_70161_v;
/* 64 */     this.field_75287_j = true;
/* 65 */     this.field_75286_m = this.field_75284_a.func_70661_as().func_75486_a();
/* 66 */     this.field_75284_a.func_70661_as().func_75491_a(false);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75251_c() {
/* 71 */     this.field_75289_h = null;
/* 72 */     this.field_75284_a.func_70661_as().func_75499_g();
/* 73 */     this.field_75290_i = 100;
/* 74 */     this.field_75287_j = false;
/* 75 */     this.field_75284_a.func_70661_as().func_75491_a(this.field_75286_m);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75246_d() {
/* 80 */     this.field_75284_a.func_70671_ap().func_75651_a((Entity)this.field_75289_h, 30.0F, this.field_75284_a.func_70646_bf());
/* 81 */     if (this.field_75284_a.func_70068_e((Entity)this.field_75289_h) < 6.25D) { this.field_75284_a.func_70661_as().func_75499_g(); }
/* 82 */     else { this.field_75284_a.func_70661_as().func_75497_a((Entity)this.field_75289_h, this.field_75282_b); }
/*    */   
/*    */   }
/*    */   public boolean func_75277_f() {
/* 86 */     return this.field_75287_j;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityAITempt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */