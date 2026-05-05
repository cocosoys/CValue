/*    */ package net.minecraft.entity.ai;
/*    */ 
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EntityAIEatGrass
/*    */   extends EntityAIBase
/*    */ {
/*    */   private EntityLiving field_151500_b;
/*    */   private World field_151501_c;
/*    */   int field_151502_a;
/*    */   private static final String __OBFID = "CL_00001582";
/*    */   
/*    */   public EntityAIEatGrass(EntityLiving p_i45314_1_) {
/* 21 */     this.field_151500_b = p_i45314_1_;
/* 22 */     this.field_151501_c = p_i45314_1_.field_70170_p;
/* 23 */     func_75248_a(7);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75250_a() {
/* 28 */     if (this.field_151500_b.func_70681_au().nextInt(this.field_151500_b.func_70631_g_() ? 50 : 1000) != 0) return false;
/*    */     
/* 30 */     int i = MathHelper.func_76128_c(this.field_151500_b.field_70165_t);
/* 31 */     int j = MathHelper.func_76128_c(this.field_151500_b.field_70163_u);
/* 32 */     int k = MathHelper.func_76128_c(this.field_151500_b.field_70161_v);
/* 33 */     if (this.field_151501_c.func_147439_a(i, j, k) == Blocks.field_150329_H && this.field_151501_c.func_72805_g(i, j, k) == 1) return true; 
/* 34 */     if (this.field_151501_c.func_147439_a(i, j - 1, k) == Blocks.field_150349_c) return true; 
/* 35 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75249_e() {
/* 40 */     this.field_151502_a = 40;
/* 41 */     this.field_151501_c.func_72960_a((Entity)this.field_151500_b, (byte)10);
/* 42 */     this.field_151500_b.func_70661_as().func_75499_g();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75251_c() {
/* 47 */     this.field_151502_a = 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75253_b() {
/* 52 */     return (this.field_151502_a > 0);
/*    */   }
/*    */   
/*    */   public int func_151499_f() {
/* 56 */     return this.field_151502_a;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75246_d() {
/* 61 */     this.field_151502_a = Math.max(0, this.field_151502_a - 1);
/* 62 */     if (this.field_151502_a != 4)
/*    */       return; 
/* 64 */     int i = MathHelper.func_76128_c(this.field_151500_b.field_70165_t);
/* 65 */     int j = MathHelper.func_76128_c(this.field_151500_b.field_70163_u);
/* 66 */     int k = MathHelper.func_76128_c(this.field_151500_b.field_70161_v);
/*    */     
/* 68 */     if (this.field_151501_c.func_147439_a(i, j, k) == Blocks.field_150329_H) {
/* 69 */       if (this.field_151501_c.func_82736_K().func_82766_b("mobGriefing")) {
/* 70 */         this.field_151501_c.func_147480_a(i, j, k, false);
/*    */       }
/* 72 */       this.field_151500_b.func_70615_aA();
/* 73 */     } else if (this.field_151501_c.func_147439_a(i, j - 1, k) == Blocks.field_150349_c) {
/* 74 */       if (this.field_151501_c.func_82736_K().func_82766_b("mobGriefing")) {
/* 75 */         this.field_151501_c.func_72926_e(2001, i, j - 1, k, Block.func_149682_b((Block)Blocks.field_150349_c));
/* 76 */         this.field_151501_c.func_147465_d(i, j - 1, k, Blocks.field_150346_d, 0, 2);
/*    */       } 
/* 78 */       this.field_151500_b.func_70615_aA();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityAIEatGrass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */