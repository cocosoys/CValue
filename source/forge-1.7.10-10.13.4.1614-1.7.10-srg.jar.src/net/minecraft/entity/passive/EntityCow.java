/*     */ package net.minecraft.entity.passive;
/*     */ import net.minecraft.entity.EntityAgeable;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityCow extends EntityAnimal {
/*     */   public EntityCow(World p_i1683_1_) {
/*  14 */     super(p_i1683_1_);
/*  15 */     func_70105_a(0.9F, 1.3F);
/*     */     
/*  17 */     func_70661_as().func_75491_a(true);
/*  18 */     this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  19 */     this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 2.0D));
/*  20 */     this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIMate(this, 1.0D));
/*  21 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.25D, Items.field_151015_O, false));
/*  22 */     this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIFollowParent(this, 1.25D));
/*  23 */     this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0D));
/*  24 */     this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 6.0F));
/*  25 */     this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*     */   }
/*     */   private static final String __OBFID = "CL_00001640";
/*     */   
/*     */   public boolean func_70650_aV() {
/*  30 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  35 */     super.func_110147_ax();
/*     */     
/*  37 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(10.0D);
/*  38 */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.20000000298023224D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70639_aQ() {
/*  43 */     return "mob.cow.say";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70621_aR() {
/*  48 */     return "mob.cow.hurt";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70673_aS() {
/*  53 */     return "mob.cow.hurt";
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
/*  58 */     func_85030_a("mob.cow.step", 0.15F, 1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   protected float func_70599_aP() {
/*  63 */     return 0.4F;
/*     */   }
/*     */ 
/*     */   
/*     */   protected Item func_146068_u() {
/*  68 */     return Items.field_151116_aA;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
/*  74 */     int i = this.field_70146_Z.nextInt(3) + this.field_70146_Z.nextInt(1 + p_70628_2_); byte b;
/*  75 */     for (b = 0; b < i; b++) {
/*  76 */       func_145779_a(Items.field_151116_aA, 1);
/*     */     }
/*     */     
/*  79 */     i = this.field_70146_Z.nextInt(3) + 1 + this.field_70146_Z.nextInt(1 + p_70628_2_);
/*  80 */     for (b = 0; b < i; b++) {
/*  81 */       if (func_70027_ad()) {
/*  82 */         func_145779_a(Items.field_151083_be, 1);
/*     */       } else {
/*  84 */         func_145779_a(Items.field_151082_bd, 1);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70085_c(EntityPlayer p_70085_1_) {
/*  91 */     ItemStack itemStack = p_70085_1_.field_71071_by.func_70448_g();
/*  92 */     if (itemStack != null && itemStack.func_77973_b() == Items.field_151133_ar && !p_70085_1_.field_71075_bZ.field_75098_d) {
/*  93 */       if (itemStack.field_77994_a-- == 1) {
/*  94 */         p_70085_1_.field_71071_by.func_70299_a(p_70085_1_.field_71071_by.field_70461_c, new ItemStack(Items.field_151117_aB));
/*  95 */       } else if (!p_70085_1_.field_71071_by.func_70441_a(new ItemStack(Items.field_151117_aB))) {
/*  96 */         p_70085_1_.func_71019_a(new ItemStack(Items.field_151117_aB, 1, 0), false);
/*     */       } 
/*     */       
/*  99 */       return true;
/*     */     } 
/* 101 */     return super.func_70085_c(p_70085_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityCow func_90011_a(EntityAgeable p_90011_1_) {
/* 106 */     return new EntityCow(this.field_70170_p);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\passive\EntityCow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */