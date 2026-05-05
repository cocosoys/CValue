/*    */ package net.minecraft.entity.boss;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.IEntityMultiPart;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.util.DamageSource;
/*    */ 
/*    */ public class EntityDragonPart
/*    */   extends Entity {
/*    */   public final IEntityMultiPart field_70259_a;
/*    */   
/*    */   public EntityDragonPart(IEntityMultiPart p_i1697_1_, String p_i1697_2_, float p_i1697_3_, float p_i1697_4_) {
/* 13 */     super(p_i1697_1_.func_82194_d());
/* 14 */     func_70105_a(p_i1697_3_, p_i1697_4_);
/* 15 */     this.field_70259_a = p_i1697_1_;
/* 16 */     this.field_146032_b = p_i1697_2_;
/*    */   }
/*    */ 
/*    */   
/*    */   public final String field_146032_b;
/*    */   
/*    */   private static final String __OBFID = "CL_00001657";
/*    */ 
/*    */   
/*    */   protected void func_70088_a() {}
/*    */ 
/*    */   
/*    */   protected void func_70037_a(NBTTagCompound p_70037_1_) {}
/*    */   
/*    */   protected void func_70014_b(NBTTagCompound p_70014_1_) {}
/*    */   
/*    */   public boolean func_70067_L() {
/* 33 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_70097_a(DamageSource p_70097_1_, float p_70097_2_) {
/* 38 */     if (func_85032_ar()) return false; 
/* 39 */     return this.field_70259_a.func_70965_a(this, p_70097_1_, p_70097_2_);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_70028_i(Entity p_70028_1_) {
/* 44 */     return (this == p_70028_1_ || this.field_70259_a == p_70028_1_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\boss\EntityDragonPart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */