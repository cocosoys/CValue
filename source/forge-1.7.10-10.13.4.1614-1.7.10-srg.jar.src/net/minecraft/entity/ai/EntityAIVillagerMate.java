/*    */ package net.minecraft.entity.ai;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityAgeable;
/*    */ import net.minecraft.entity.passive.EntityVillager;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.village.Village;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class EntityAIVillagerMate
/*    */   extends EntityAIBase
/*    */ {
/*    */   private EntityVillager field_75450_b;
/*    */   private EntityVillager field_75451_c;
/*    */   private World field_75448_d;
/*    */   
/*    */   public EntityAIVillagerMate(EntityVillager p_i1634_1_) {
/* 18 */     this.field_75450_b = p_i1634_1_;
/* 19 */     this.field_75448_d = p_i1634_1_.field_70170_p;
/* 20 */     func_75248_a(3);
/*    */   }
/*    */   private int field_75449_e; Village field_75452_a; private static final String __OBFID = "CL_00001594";
/*    */   
/*    */   public boolean func_75250_a() {
/* 25 */     if (this.field_75450_b.func_70874_b() != 0) return false; 
/* 26 */     if (this.field_75450_b.func_70681_au().nextInt(500) != 0) return false;
/*    */     
/* 28 */     this.field_75452_a = this.field_75448_d.field_72982_D.func_75550_a(MathHelper.func_76128_c(this.field_75450_b.field_70165_t), MathHelper.func_76128_c(this.field_75450_b.field_70163_u), MathHelper.func_76128_c(this.field_75450_b.field_70161_v), 0);
/* 29 */     if (this.field_75452_a == null) return false; 
/* 30 */     if (!func_75446_f()) return false;
/*    */     
/* 32 */     Entity entity = this.field_75448_d.func_72857_a(EntityVillager.class, this.field_75450_b.field_70121_D.func_72314_b(8.0D, 3.0D, 8.0D), (Entity)this.field_75450_b);
/* 33 */     if (entity == null) return false;
/*    */     
/* 35 */     this.field_75451_c = (EntityVillager)entity;
/* 36 */     if (this.field_75451_c.func_70874_b() != 0) return false;
/*    */     
/* 38 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75249_e() {
/* 43 */     this.field_75449_e = 300;
/* 44 */     this.field_75450_b.func_70947_e(true);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75251_c() {
/* 49 */     this.field_75452_a = null;
/* 50 */     this.field_75451_c = null;
/* 51 */     this.field_75450_b.func_70947_e(false);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75253_b() {
/* 56 */     return (this.field_75449_e >= 0 && func_75446_f() && this.field_75450_b.func_70874_b() == 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75246_d() {
/* 61 */     this.field_75449_e--;
/* 62 */     this.field_75450_b.func_70671_ap().func_75651_a((Entity)this.field_75451_c, 10.0F, 30.0F);
/*    */     
/* 64 */     if (this.field_75450_b.func_70068_e((Entity)this.field_75451_c) > 2.25D)
/* 65 */     { this.field_75450_b.func_70661_as().func_75497_a((Entity)this.field_75451_c, 0.25D); }
/*    */     
/* 67 */     else if (this.field_75449_e == 0 && this.field_75451_c.func_70941_o()) { func_75447_i(); }
/*    */ 
/*    */     
/* 70 */     if (this.field_75450_b.func_70681_au().nextInt(35) == 0) this.field_75448_d.func_72960_a((Entity)this.field_75450_b, (byte)12);
/*    */   
/*    */   }
/*    */   
/*    */   private boolean func_75446_f() {
/* 75 */     if (!this.field_75452_a.func_82686_i()) {
/* 76 */       return false;
/*    */     }
/*    */     
/* 79 */     int i = (int)(this.field_75452_a.func_75567_c() * 0.35D);
/* 80 */     return (this.field_75452_a.func_75562_e() < i);
/*    */   }
/*    */   
/*    */   private void func_75447_i() {
/* 84 */     EntityVillager entityVillager = this.field_75450_b.func_90011_a((EntityAgeable)this.field_75451_c);
/* 85 */     this.field_75451_c.func_70873_a(6000);
/* 86 */     this.field_75450_b.func_70873_a(6000);
/* 87 */     entityVillager.func_70873_a(-24000);
/* 88 */     entityVillager.func_70012_b(this.field_75450_b.field_70165_t, this.field_75450_b.field_70163_u, this.field_75450_b.field_70161_v, 0.0F, 0.0F);
/* 89 */     this.field_75448_d.func_72838_d((Entity)entityVillager);
/* 90 */     this.field_75448_d.func_72960_a((Entity)entityVillager, (byte)12);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityAIVillagerMate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */