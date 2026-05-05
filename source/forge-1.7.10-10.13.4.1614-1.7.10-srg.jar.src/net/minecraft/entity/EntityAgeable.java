/*     */ package net.minecraft.entity;
/*     */ 
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public abstract class EntityAgeable
/*     */   extends EntityCreature
/*     */ {
/*     */   private float field_98056_d;
/*     */   private float field_98057_e;
/*     */   private static final String __OBFID = "CL_00001530";
/*     */   
/*     */   public EntityAgeable(World p_i1578_1_) {
/*  17 */     super(p_i1578_1_);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 120 */     this.field_98056_d = -1.0F;
/*     */   }
/*     */   public abstract EntityAgeable func_90011_a(EntityAgeable paramEntityAgeable);
/*     */   public boolean func_70085_c(EntityPlayer p_70085_1_) { ItemStack itemStack = p_70085_1_.field_71071_by.func_70448_g(); if (itemStack != null && itemStack.func_77973_b() == Items.field_151063_bx) { if (!this.field_70170_p.field_72995_K) { Class clazz = EntityList.func_90035_a(itemStack.func_77960_j()); if (clazz != null && clazz.isAssignableFrom(getClass())) { EntityAgeable entityAgeable = func_90011_a(this); if (entityAgeable != null) { entityAgeable.func_70873_a(-24000); entityAgeable.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0F, 0.0F); this.field_70170_p.func_72838_d(entityAgeable); if (itemStack.func_82837_s()) entityAgeable.func_94058_c(itemStack.func_82833_r());  if (!p_70085_1_.field_71075_bZ.field_75098_d) { itemStack.field_77994_a--; if (itemStack.field_77994_a <= 0) p_70085_1_.field_71071_by.func_70299_a(p_70085_1_.field_71071_by.field_70461_c, null);  }  }  }  }  return true; }  return false; }
/*     */   protected void func_70088_a() { super.func_70088_a(); this.field_70180_af.func_75682_a(12, new Integer(0)); } public int func_70874_b() { return this.field_70180_af.func_75679_c(12); } public void func_110195_a(int p_110195_1_) { int i = func_70874_b(); i += p_110195_1_ * 20; if (i > 0)
/* 125 */       i = 0;  func_70873_a(i); } protected final void func_70105_a(float p_70105_1_, float p_70105_2_) { boolean bool = (this.field_98056_d > 0.0F) ? true : false;
/*     */     
/* 127 */     this.field_98056_d = p_70105_1_;
/* 128 */     this.field_98057_e = p_70105_2_;
/*     */     
/* 130 */     if (!bool)
/* 131 */       func_98055_j(1.0F);  } public void func_70873_a(int p_70873_1_) { this.field_70180_af.func_75692_b(12, Integer.valueOf(p_70873_1_)); func_98054_a(func_70631_g_()); }
/*     */   public void func_70014_b(NBTTagCompound p_70014_1_) { super.func_70014_b(p_70014_1_);
/*     */     p_70014_1_.func_74768_a("Age", func_70874_b()); }
/*     */   public void func_70037_a(NBTTagCompound p_70037_1_) { super.func_70037_a(p_70037_1_);
/*     */     func_70873_a(p_70037_1_.func_74762_e("Age")); }
/* 136 */   protected final void func_98055_j(float p_98055_1_) { super.func_70105_a(this.field_98056_d * p_98055_1_, this.field_98057_e * p_98055_1_); }
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/*     */     super.func_70636_d();
/*     */     if (this.field_70170_p.field_72995_K) {
/*     */       func_98054_a(func_70631_g_());
/*     */     } else {
/*     */       int i = func_70874_b();
/*     */       if (i < 0) {
/*     */         i++;
/*     */         func_70873_a(i);
/*     */       } else if (i > 0) {
/*     */         i--;
/*     */         func_70873_a(i);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean func_70631_g_() {
/*     */     return (func_70874_b() < 0);
/*     */   }
/*     */   
/*     */   public void func_98054_a(boolean p_98054_1_) {
/*     */     func_98055_j(p_98054_1_ ? 0.5F : 1.0F);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\EntityAgeable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */