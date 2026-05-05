/*    */ package net.minecraft.entity.ai;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.passive.EntityTameable;
/*    */ import net.minecraft.pathfinding.PathNavigate;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EntityAIFollowOwner
/*    */   extends EntityAIBase
/*    */ {
/*    */   private EntityTameable field_75338_d;
/*    */   private EntityLivingBase field_75339_e;
/*    */   World field_75342_a;
/*    */   private double field_75336_f;
/*    */   private PathNavigate field_75337_g;
/*    */   
/*    */   public EntityAIFollowOwner(EntityTameable p_i1625_1_, double p_i1625_2_, float p_i1625_4_, float p_i1625_5_) {
/* 23 */     this.field_75338_d = p_i1625_1_;
/* 24 */     this.field_75342_a = p_i1625_1_.field_70170_p;
/* 25 */     this.field_75336_f = p_i1625_2_;
/* 26 */     this.field_75337_g = p_i1625_1_.func_70661_as();
/* 27 */     this.field_75341_c = p_i1625_4_;
/* 28 */     this.field_75340_b = p_i1625_5_;
/* 29 */     func_75248_a(3);
/*    */   }
/*    */   private int field_75343_h; float field_75340_b; float field_75341_c; private boolean field_75344_i; private static final String __OBFID = "CL_00001585";
/*    */   
/*    */   public boolean func_75250_a() {
/* 34 */     EntityLivingBase entityLivingBase = this.field_75338_d.func_70902_q();
/* 35 */     if (entityLivingBase == null) return false; 
/* 36 */     if (this.field_75338_d.func_70906_o()) return false; 
/* 37 */     if (this.field_75338_d.func_70068_e((Entity)entityLivingBase) < (this.field_75341_c * this.field_75341_c)) return false; 
/* 38 */     this.field_75339_e = entityLivingBase;
/* 39 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75253_b() {
/* 44 */     return (!this.field_75337_g.func_75500_f() && this.field_75338_d.func_70068_e((Entity)this.field_75339_e) > (this.field_75340_b * this.field_75340_b) && !this.field_75338_d.func_70906_o());
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75249_e() {
/* 49 */     this.field_75343_h = 0;
/* 50 */     this.field_75344_i = this.field_75338_d.func_70661_as().func_75486_a();
/* 51 */     this.field_75338_d.func_70661_as().func_75491_a(false);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75251_c() {
/* 56 */     this.field_75339_e = null;
/* 57 */     this.field_75337_g.func_75499_g();
/* 58 */     this.field_75338_d.func_70661_as().func_75491_a(this.field_75344_i);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75246_d() {
/* 63 */     this.field_75338_d.func_70671_ap().func_75651_a((Entity)this.field_75339_e, 10.0F, this.field_75338_d.func_70646_bf());
/* 64 */     if (this.field_75338_d.func_70906_o())
/*    */       return; 
/* 66 */     if (--this.field_75343_h > 0)
/* 67 */       return;  this.field_75343_h = 10;
/*    */     
/* 69 */     if (this.field_75337_g.func_75497_a((Entity)this.field_75339_e, this.field_75336_f))
/* 70 */       return;  if (this.field_75338_d.func_110167_bD())
/* 71 */       return;  if (this.field_75338_d.func_70068_e((Entity)this.field_75339_e) < 144.0D) {
/*    */       return;
/*    */     }
/* 74 */     int i = MathHelper.func_76128_c(this.field_75339_e.field_70165_t) - 2;
/* 75 */     int j = MathHelper.func_76128_c(this.field_75339_e.field_70161_v) - 2;
/* 76 */     int k = MathHelper.func_76128_c(this.field_75339_e.field_70121_D.field_72338_b);
/* 77 */     for (byte b = 0; b <= 4; b++) {
/* 78 */       for (byte b1 = 0; b1 <= 4; b1++) {
/* 79 */         if (b < 1 || b1 < 1 || b > 3 || b1 > 3)
/*    */         {
/*    */           
/* 82 */           if (World.func_147466_a((IBlockAccess)this.field_75342_a, i + b, k - 1, j + b1) && !this.field_75342_a.func_147439_a(i + b, k, j + b1).func_149721_r() && !this.field_75342_a.func_147439_a(i + b, k + 1, j + b1).func_149721_r()) {
/* 83 */             this.field_75338_d.func_70012_b(((i + b) + 0.5F), k, ((j + b1) + 0.5F), this.field_75338_d.field_70177_z, this.field_75338_d.field_70125_A);
/* 84 */             this.field_75337_g.func_75499_g();
/*    */             return;
/*    */           } 
/*    */         }
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityAIFollowOwner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */