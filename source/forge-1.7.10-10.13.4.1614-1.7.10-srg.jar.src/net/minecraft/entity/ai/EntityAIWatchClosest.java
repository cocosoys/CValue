/*    */ package net.minecraft.entity.ai;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ public class EntityAIWatchClosest extends EntityAIBase {
/*    */   private EntityLiving field_75332_b;
/*    */   protected Entity field_75334_a;
/*    */   private float field_75333_c;
/*    */   private int field_75330_d;
/*    */   private float field_75331_e;
/*    */   private Class field_75329_f;
/*    */   private static final String __OBFID = "CL_00001592";
/*    */   
/*    */   public EntityAIWatchClosest(EntityLiving p_i1631_1_, Class p_i1631_2_, float p_i1631_3_) {
/* 17 */     this.field_75332_b = p_i1631_1_;
/* 18 */     this.field_75329_f = p_i1631_2_;
/* 19 */     this.field_75333_c = p_i1631_3_;
/* 20 */     this.field_75331_e = 0.02F;
/* 21 */     func_75248_a(2);
/*    */   }
/*    */   
/*    */   public EntityAIWatchClosest(EntityLiving p_i1632_1_, Class p_i1632_2_, float p_i1632_3_, float p_i1632_4_) {
/* 25 */     this.field_75332_b = p_i1632_1_;
/* 26 */     this.field_75329_f = p_i1632_2_;
/* 27 */     this.field_75333_c = p_i1632_3_;
/* 28 */     this.field_75331_e = p_i1632_4_;
/* 29 */     func_75248_a(2);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75250_a() {
/* 34 */     if (this.field_75332_b.func_70681_au().nextFloat() >= this.field_75331_e) return false;
/*    */     
/* 36 */     if (this.field_75332_b.func_70638_az() != null)
/* 37 */       this.field_75334_a = (Entity)this.field_75332_b.func_70638_az(); 
/* 38 */     if (this.field_75329_f == EntityPlayer.class) {
/* 39 */       this.field_75334_a = (Entity)this.field_75332_b.field_70170_p.func_72890_a((Entity)this.field_75332_b, this.field_75333_c);
/*    */     } else {
/* 41 */       this.field_75334_a = this.field_75332_b.field_70170_p.func_72857_a(this.field_75329_f, this.field_75332_b.field_70121_D.func_72314_b(this.field_75333_c, 3.0D, this.field_75333_c), (Entity)this.field_75332_b);
/*    */     } 
/*    */     
/* 44 */     return (this.field_75334_a != null);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75253_b() {
/* 49 */     if (!this.field_75334_a.func_70089_S()) return false; 
/* 50 */     if (this.field_75332_b.func_70068_e(this.field_75334_a) > (this.field_75333_c * this.field_75333_c)) return false; 
/* 51 */     return (this.field_75330_d > 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75249_e() {
/* 56 */     this.field_75330_d = 40 + this.field_75332_b.func_70681_au().nextInt(40);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75251_c() {
/* 61 */     this.field_75334_a = null;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75246_d() {
/* 66 */     this.field_75332_b.func_70671_ap().func_75650_a(this.field_75334_a.field_70165_t, this.field_75334_a.field_70163_u + this.field_75334_a.func_70047_e(), this.field_75334_a.field_70161_v, 10.0F, this.field_75332_b.func_70646_bf());
/* 67 */     this.field_75330_d--;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityAIWatchClosest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */