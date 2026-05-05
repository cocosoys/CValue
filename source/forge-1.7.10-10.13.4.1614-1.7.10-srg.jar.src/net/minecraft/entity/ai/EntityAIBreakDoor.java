/*    */ package net.minecraft.entity.ai;
/*    */ 
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.world.EnumDifficulty;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EntityAIBreakDoor
/*    */   extends EntityAIDoorInteract
/*    */ {
/*    */   private int field_75359_i;
/* 14 */   private int field_75358_j = -1;
/*    */   
/*    */   public EntityAIBreakDoor(EntityLiving p_i1618_1_) {
/* 17 */     super(p_i1618_1_);
/*    */   }
/*    */   private static final String __OBFID = "CL_00001577";
/*    */   
/*    */   public boolean func_75250_a() {
/* 22 */     if (!super.func_75250_a()) return false; 
/* 23 */     if (!this.field_75356_a.field_70170_p.func_82736_K().func_82766_b("mobGriefing")) return false; 
/* 24 */     return !this.field_151504_e.func_150015_f((IBlockAccess)this.field_75356_a.field_70170_p, this.field_75354_b, this.field_75355_c, this.field_75352_d);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75249_e() {
/* 29 */     super.func_75249_e();
/* 30 */     this.field_75359_i = 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75253_b() {
/* 35 */     double d = this.field_75356_a.func_70092_e(this.field_75354_b, this.field_75355_c, this.field_75352_d);
/* 36 */     return (this.field_75359_i <= 240 && !this.field_151504_e.func_150015_f((IBlockAccess)this.field_75356_a.field_70170_p, this.field_75354_b, this.field_75355_c, this.field_75352_d) && d < 4.0D);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75251_c() {
/* 41 */     super.func_75251_c();
/* 42 */     this.field_75356_a.field_70170_p.func_147443_d(this.field_75356_a.func_145782_y(), this.field_75354_b, this.field_75355_c, this.field_75352_d, -1);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75246_d() {
/* 47 */     super.func_75246_d();
/* 48 */     if (this.field_75356_a.func_70681_au().nextInt(20) == 0) {
/* 49 */       this.field_75356_a.field_70170_p.func_72926_e(1010, this.field_75354_b, this.field_75355_c, this.field_75352_d, 0);
/*    */     }
/*    */     
/* 52 */     this.field_75359_i++;
/*    */     
/* 54 */     int i = (int)(this.field_75359_i / 240.0F * 10.0F);
/* 55 */     if (i != this.field_75358_j) {
/* 56 */       this.field_75356_a.field_70170_p.func_147443_d(this.field_75356_a.func_145782_y(), this.field_75354_b, this.field_75355_c, this.field_75352_d, i);
/* 57 */       this.field_75358_j = i;
/*    */     } 
/*    */     
/* 60 */     if (this.field_75359_i == 240 && 
/* 61 */       this.field_75356_a.field_70170_p.field_73013_u == EnumDifficulty.HARD) {
/* 62 */       this.field_75356_a.field_70170_p.func_147468_f(this.field_75354_b, this.field_75355_c, this.field_75352_d);
/* 63 */       this.field_75356_a.field_70170_p.func_72926_e(1012, this.field_75354_b, this.field_75355_c, this.field_75352_d, 0);
/* 64 */       this.field_75356_a.field_70170_p.func_72926_e(2001, this.field_75354_b, this.field_75355_c, this.field_75352_d, Block.func_149682_b((Block)this.field_151504_e));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityAIBreakDoor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */