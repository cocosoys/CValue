/*    */ package net.minecraft.entity.ai;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.BlockDoor;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.pathfinding.PathEntity;
/*    */ import net.minecraft.pathfinding.PathNavigate;
/*    */ import net.minecraft.pathfinding.PathPoint;
/*    */ import net.minecraft.util.MathHelper;
/*    */ 
/*    */ public abstract class EntityAIDoorInteract extends EntityAIBase {
/*    */   protected EntityLiving field_75356_a;
/*    */   protected int field_75354_b;
/*    */   protected int field_75355_c;
/*    */   protected int field_75352_d;
/*    */   
/*    */   public EntityAIDoorInteract(EntityLiving p_i1621_1_) {
/* 17 */     this.field_75356_a = p_i1621_1_;
/*    */   }
/*    */   protected BlockDoor field_151504_e; boolean field_75350_f; float field_75351_g; float field_75357_h; private static final String __OBFID = "CL_00001581";
/*    */   
/*    */   public boolean func_75250_a() {
/* 22 */     if (!this.field_75356_a.field_70123_F) return false; 
/* 23 */     PathNavigate pathNavigate = this.field_75356_a.func_70661_as();
/* 24 */     PathEntity pathEntity = pathNavigate.func_75505_d();
/* 25 */     if (pathEntity == null || pathEntity.func_75879_b() || !pathNavigate.func_75507_c()) return false;
/*    */     
/* 27 */     for (byte b = 0; b < Math.min(pathEntity.func_75873_e() + 2, pathEntity.func_75874_d()); b++) {
/* 28 */       PathPoint pathPoint = pathEntity.func_75877_a(b);
/* 29 */       this.field_75354_b = pathPoint.field_75839_a;
/* 30 */       this.field_75355_c = pathPoint.field_75837_b + 1;
/* 31 */       this.field_75352_d = pathPoint.field_75838_c;
/* 32 */       if (this.field_75356_a.func_70092_e(this.field_75354_b, this.field_75356_a.field_70163_u, this.field_75352_d) <= 2.25D) {
/* 33 */         this.field_151504_e = func_151503_a(this.field_75354_b, this.field_75355_c, this.field_75352_d);
/* 34 */         if (this.field_151504_e != null)
/* 35 */           return true; 
/*    */       } 
/*    */     } 
/* 38 */     this.field_75354_b = MathHelper.func_76128_c(this.field_75356_a.field_70165_t);
/* 39 */     this.field_75355_c = MathHelper.func_76128_c(this.field_75356_a.field_70163_u + 1.0D);
/* 40 */     this.field_75352_d = MathHelper.func_76128_c(this.field_75356_a.field_70161_v);
/* 41 */     this.field_151504_e = func_151503_a(this.field_75354_b, this.field_75355_c, this.field_75352_d);
/* 42 */     return (this.field_151504_e != null);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75253_b() {
/* 47 */     return !this.field_75350_f;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75249_e() {
/* 52 */     this.field_75350_f = false;
/* 53 */     this.field_75351_g = (float)((this.field_75354_b + 0.5F) - this.field_75356_a.field_70165_t);
/* 54 */     this.field_75357_h = (float)((this.field_75352_d + 0.5F) - this.field_75356_a.field_70161_v);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75246_d() {
/* 59 */     float f1 = (float)((this.field_75354_b + 0.5F) - this.field_75356_a.field_70165_t);
/* 60 */     float f2 = (float)((this.field_75352_d + 0.5F) - this.field_75356_a.field_70161_v);
/* 61 */     float f3 = this.field_75351_g * f1 + this.field_75357_h * f2;
/* 62 */     if (f3 < 0.0F) {
/* 63 */       this.field_75350_f = true;
/*    */     }
/*    */   }
/*    */   
/*    */   private BlockDoor func_151503_a(int p_151503_1_, int p_151503_2_, int p_151503_3_) {
/* 68 */     Block block = this.field_75356_a.field_70170_p.func_147439_a(p_151503_1_, p_151503_2_, p_151503_3_);
/* 69 */     if (block != Blocks.field_150466_ao) return null; 
/* 70 */     return (BlockDoor)block;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityAIDoorInteract.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */