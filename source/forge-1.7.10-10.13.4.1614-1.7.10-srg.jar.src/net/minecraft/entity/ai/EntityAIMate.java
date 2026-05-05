/*     */ package net.minecraft.entity.ai;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityAgeable;
/*     */ import net.minecraft.entity.item.EntityXPOrb;
/*     */ import net.minecraft.entity.passive.EntityAnimal;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.stats.AchievementList;
/*     */ import net.minecraft.stats.StatBase;
/*     */ import net.minecraft.stats.StatList;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityAIMate
/*     */   extends EntityAIBase
/*     */ {
/*     */   private EntityAnimal field_75390_d;
/*     */   World field_75394_a;
/*     */   private EntityAnimal field_75391_e;
/*     */   
/*     */   public EntityAIMate(EntityAnimal p_i1619_1_, double p_i1619_2_) {
/*  23 */     this.field_75390_d = p_i1619_1_;
/*  24 */     this.field_75394_a = p_i1619_1_.field_70170_p;
/*  25 */     this.field_75393_c = p_i1619_2_;
/*  26 */     func_75248_a(3);
/*     */   }
/*     */   int field_75392_b; double field_75393_c; private static final String __OBFID = "CL_00001578";
/*     */   
/*     */   public boolean func_75250_a() {
/*  31 */     if (!this.field_75390_d.func_70880_s()) return false; 
/*  32 */     this.field_75391_e = func_75389_f();
/*  33 */     return (this.field_75391_e != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_75253_b() {
/*  38 */     return (this.field_75391_e.func_70089_S() && this.field_75391_e.func_70880_s() && this.field_75392_b < 60);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_75251_c() {
/*  43 */     this.field_75391_e = null;
/*  44 */     this.field_75392_b = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_75246_d() {
/*  49 */     this.field_75390_d.func_70671_ap().func_75651_a((Entity)this.field_75391_e, 10.0F, this.field_75390_d.func_70646_bf());
/*  50 */     this.field_75390_d.func_70661_as().func_75497_a((Entity)this.field_75391_e, this.field_75393_c);
/*  51 */     this.field_75392_b++;
/*  52 */     if (this.field_75392_b >= 60 && this.field_75390_d.func_70068_e((Entity)this.field_75391_e) < 9.0D) func_75388_i(); 
/*     */   }
/*     */   
/*     */   private EntityAnimal func_75389_f() {
/*  56 */     float f = 8.0F;
/*  57 */     List list = this.field_75394_a.func_72872_a(this.field_75390_d.getClass(), this.field_75390_d.field_70121_D.func_72314_b(f, f, f));
/*  58 */     double d = Double.MAX_VALUE;
/*  59 */     EntityAnimal entityAnimal = null;
/*  60 */     for (EntityAnimal entityAnimal1 : list) {
/*  61 */       if (this.field_75390_d.func_70878_b(entityAnimal1) && this.field_75390_d.func_70068_e((Entity)entityAnimal1) < d) {
/*  62 */         entityAnimal = entityAnimal1;
/*  63 */         d = this.field_75390_d.func_70068_e((Entity)entityAnimal1);
/*     */       } 
/*     */     } 
/*  66 */     return entityAnimal;
/*     */   }
/*     */   
/*     */   private void func_75388_i() {
/*  70 */     EntityAgeable entityAgeable = this.field_75390_d.func_90011_a((EntityAgeable)this.field_75391_e);
/*  71 */     if (entityAgeable == null)
/*     */       return; 
/*  73 */     EntityPlayer entityPlayer = this.field_75390_d.func_146083_cb();
/*  74 */     if (entityPlayer == null && this.field_75391_e.func_146083_cb() != null) {
/*  75 */       entityPlayer = this.field_75391_e.func_146083_cb();
/*     */     }
/*     */     
/*  78 */     if (entityPlayer != null) {
/*  79 */       entityPlayer.func_71029_a(StatList.field_151186_x);
/*     */       
/*  81 */       if (this.field_75390_d instanceof net.minecraft.entity.passive.EntityCow) {
/*  82 */         entityPlayer.func_71029_a((StatBase)AchievementList.field_150962_H);
/*     */       }
/*     */     } 
/*     */     
/*  86 */     this.field_75390_d.func_70873_a(6000);
/*  87 */     this.field_75391_e.func_70873_a(6000);
/*  88 */     this.field_75390_d.func_70875_t();
/*  89 */     this.field_75391_e.func_70875_t();
/*  90 */     entityAgeable.func_70873_a(-24000);
/*  91 */     entityAgeable.func_70012_b(this.field_75390_d.field_70165_t, this.field_75390_d.field_70163_u, this.field_75390_d.field_70161_v, 0.0F, 0.0F);
/*  92 */     this.field_75394_a.func_72838_d((Entity)entityAgeable);
/*     */     
/*  94 */     Random random = this.field_75390_d.func_70681_au();
/*  95 */     for (byte b = 0; b < 7; b++) {
/*  96 */       double d1 = random.nextGaussian() * 0.02D;
/*  97 */       double d2 = random.nextGaussian() * 0.02D;
/*  98 */       double d3 = random.nextGaussian() * 0.02D;
/*  99 */       this.field_75394_a.func_72869_a("heart", this.field_75390_d.field_70165_t + (random.nextFloat() * this.field_75390_d.field_70130_N * 2.0F) - this.field_75390_d.field_70130_N, this.field_75390_d.field_70163_u + 0.5D + (random.nextFloat() * this.field_75390_d.field_70131_O), this.field_75390_d.field_70161_v + (random.nextFloat() * this.field_75390_d.field_70130_N * 2.0F) - this.field_75390_d.field_70130_N, d1, d2, d3);
/*     */     } 
/*     */ 
/*     */     
/* 103 */     if (this.field_75394_a.func_82736_K().func_82766_b("doMobLoot")) this.field_75394_a.func_72838_d((Entity)new EntityXPOrb(this.field_75394_a, this.field_75390_d.field_70165_t, this.field_75390_d.field_70163_u, this.field_75390_d.field_70161_v, random.nextInt(7) + 1)); 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityAIMate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */