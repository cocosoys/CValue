/*    */ package net.minecraft.entity.passive;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityAgeable;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.item.EntityItem;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class EntityMooshroom extends EntityCow {
/*    */   public EntityMooshroom(World p_i1687_1_) {
/* 13 */     super(p_i1687_1_);
/* 14 */     func_70105_a(0.9F, 1.3F);
/*    */   }
/*    */   private static final String __OBFID = "CL_00001645";
/*    */   
/*    */   public boolean func_70085_c(EntityPlayer p_70085_1_) {
/* 19 */     ItemStack itemStack = p_70085_1_.field_71071_by.func_70448_g();
/* 20 */     if (itemStack != null && itemStack.func_77973_b() == Items.field_151054_z && func_70874_b() >= 0) {
/* 21 */       if (itemStack.field_77994_a == 1) {
/* 22 */         p_70085_1_.field_71071_by.func_70299_a(p_70085_1_.field_71071_by.field_70461_c, new ItemStack(Items.field_151009_A));
/* 23 */         return true;
/*    */       } 
/*    */       
/* 26 */       if (p_70085_1_.field_71071_by.func_70441_a(new ItemStack(Items.field_151009_A)) && !p_70085_1_.field_71075_bZ.field_75098_d) {
/* 27 */         p_70085_1_.field_71071_by.func_70298_a(p_70085_1_.field_71071_by.field_70461_c, 1);
/* 28 */         return true;
/*    */       } 
/*    */     } 
/* 31 */     if (itemStack != null && itemStack.func_77973_b() == Items.field_151097_aZ && func_70874_b() >= 0) {
/* 32 */       func_70106_y();
/* 33 */       this.field_70170_p.func_72869_a("largeexplode", this.field_70165_t, this.field_70163_u + (this.field_70131_O / 2.0F), this.field_70161_v, 0.0D, 0.0D, 0.0D);
/* 34 */       if (!this.field_70170_p.field_72995_K) {
/* 35 */         EntityCow entityCow = new EntityCow(this.field_70170_p);
/* 36 */         entityCow.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, this.field_70125_A);
/* 37 */         entityCow.func_70606_j(func_110143_aJ());
/* 38 */         entityCow.field_70761_aq = this.field_70761_aq;
/* 39 */         this.field_70170_p.func_72838_d((Entity)entityCow);
/* 40 */         for (byte b = 0; b < 5; b++) {
/* 41 */           this.field_70170_p.func_72838_d((Entity)new EntityItem(this.field_70170_p, this.field_70165_t, this.field_70163_u + this.field_70131_O, this.field_70161_v, new ItemStack((Block)Blocks.field_150337_Q)));
/*    */         }
/* 43 */         itemStack.func_77972_a(1, (EntityLivingBase)p_70085_1_);
/* 44 */         func_85030_a("mob.sheep.shear", 1.0F, 1.0F);
/*    */       } 
/* 46 */       return true;
/*    */     } 
/* 48 */     return super.func_70085_c(p_70085_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public EntityMooshroom func_90011_a(EntityAgeable p_90011_1_) {
/* 53 */     return new EntityMooshroom(this.field_70170_p);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\passive\EntityMooshroom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */