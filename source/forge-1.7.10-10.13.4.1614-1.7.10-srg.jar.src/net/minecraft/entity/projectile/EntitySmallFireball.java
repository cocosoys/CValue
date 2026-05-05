/*    */ package net.minecraft.entity.projectile;
/*    */ 
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.util.DamageSource;
/*    */ import net.minecraft.util.MovingObjectPosition;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class EntitySmallFireball extends EntityFireball {
/*    */   private static final String __OBFID = "CL_00001721";
/*    */   
/*    */   public EntitySmallFireball(World p_i1770_1_) {
/* 15 */     super(p_i1770_1_);
/* 16 */     func_70105_a(0.3125F, 0.3125F);
/*    */   }
/*    */   
/*    */   public EntitySmallFireball(World p_i1771_1_, EntityLivingBase p_i1771_2_, double p_i1771_3_, double p_i1771_5_, double p_i1771_7_) {
/* 20 */     super(p_i1771_1_, p_i1771_2_, p_i1771_3_, p_i1771_5_, p_i1771_7_);
/*    */     
/* 22 */     func_70105_a(0.3125F, 0.3125F);
/*    */   }
/*    */   
/*    */   public EntitySmallFireball(World p_i1772_1_, double p_i1772_2_, double p_i1772_4_, double p_i1772_6_, double p_i1772_8_, double p_i1772_10_, double p_i1772_12_) {
/* 26 */     super(p_i1772_1_, p_i1772_2_, p_i1772_4_, p_i1772_6_, p_i1772_8_, p_i1772_10_, p_i1772_12_);
/* 27 */     func_70105_a(0.3125F, 0.3125F);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_70227_a(MovingObjectPosition p_70227_1_) {
/* 32 */     if (!this.field_70170_p.field_72995_K) {
/* 33 */       if (p_70227_1_.field_72308_g != null) {
/* 34 */         if (!p_70227_1_.field_72308_g.func_70045_F() && p_70227_1_.field_72308_g.func_70097_a(DamageSource.func_76362_a(this, (Entity)this.field_70235_a), 5.0F)) {
/* 35 */           p_70227_1_.field_72308_g.func_70015_d(5);
/*    */         }
/*    */       } else {
/* 38 */         int i = p_70227_1_.field_72311_b;
/* 39 */         int j = p_70227_1_.field_72312_c;
/* 40 */         int k = p_70227_1_.field_72309_d;
/* 41 */         switch (p_70227_1_.field_72310_e) {
/*    */           case 1:
/* 43 */             j++;
/*    */             break;
/*    */           case 0:
/* 46 */             j--;
/*    */             break;
/*    */           case 2:
/* 49 */             k--;
/*    */             break;
/*    */           case 3:
/* 52 */             k++;
/*    */             break;
/*    */           case 5:
/* 55 */             i++;
/*    */             break;
/*    */           case 4:
/* 58 */             i--;
/*    */             break;
/*    */         } 
/* 61 */         if (this.field_70170_p.func_147437_c(i, j, k)) {
/* 62 */           this.field_70170_p.func_147449_b(i, j, k, (Block)Blocks.field_150480_ab);
/*    */         }
/*    */       } 
/* 65 */       func_70106_y();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_70067_L() {
/* 71 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_70097_a(DamageSource p_70097_1_, float p_70097_2_) {
/* 76 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\projectile\EntitySmallFireball.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */