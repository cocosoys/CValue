/*     */ package net.minecraft.entity.projectile;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityPotion extends EntityThrowable {
/*     */   private ItemStack field_70197_d;
/*     */   private static final String __OBFID = "CL_00001727";
/*     */   
/*     */   public EntityPotion(World p_i1788_1_) {
/*  24 */     super(p_i1788_1_);
/*     */   }
/*     */   
/*     */   public EntityPotion(World p_i1789_1_, EntityLivingBase p_i1789_2_, int p_i1789_3_) {
/*  28 */     this(p_i1789_1_, p_i1789_2_, new ItemStack((Item)Items.field_151068_bn, 1, p_i1789_3_));
/*     */   }
/*     */   
/*     */   public EntityPotion(World p_i1790_1_, EntityLivingBase p_i1790_2_, ItemStack p_i1790_3_) {
/*  32 */     super(p_i1790_1_, p_i1790_2_);
/*     */     
/*  34 */     this.field_70197_d = p_i1790_3_;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public EntityPotion(World p_i1791_1_, double p_i1791_2_, double p_i1791_4_, double p_i1791_6_, int p_i1791_8_) {
/*  38 */     this(p_i1791_1_, p_i1791_2_, p_i1791_4_, p_i1791_6_, new ItemStack((Item)Items.field_151068_bn, 1, p_i1791_8_));
/*     */   }
/*     */   
/*     */   public EntityPotion(World p_i1792_1_, double p_i1792_2_, double p_i1792_4_, double p_i1792_6_, ItemStack p_i1792_8_) {
/*  42 */     super(p_i1792_1_, p_i1792_2_, p_i1792_4_, p_i1792_6_);
/*  43 */     this.field_70197_d = p_i1792_8_;
/*     */   }
/*     */ 
/*     */   
/*     */   protected float func_70185_h() {
/*  48 */     return 0.05F;
/*     */   }
/*     */ 
/*     */   
/*     */   protected float func_70182_d() {
/*  53 */     return 0.5F;
/*     */   }
/*     */ 
/*     */   
/*     */   protected float func_70183_g() {
/*  58 */     return -20.0F;
/*     */   }
/*     */   
/*     */   public void func_82340_a(int p_82340_1_) {
/*  62 */     if (this.field_70197_d == null) this.field_70197_d = new ItemStack((Item)Items.field_151068_bn, 1, 0); 
/*  63 */     this.field_70197_d.func_77964_b(p_82340_1_);
/*     */   }
/*     */   
/*     */   public int func_70196_i() {
/*  67 */     if (this.field_70197_d == null) this.field_70197_d = new ItemStack((Item)Items.field_151068_bn, 1, 0); 
/*  68 */     return this.field_70197_d.func_77960_j();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70184_a(MovingObjectPosition p_70184_1_) {
/*  73 */     if (!this.field_70170_p.field_72995_K) {
/*  74 */       List list = Items.field_151068_bn.func_77832_l(this.field_70197_d);
/*     */       
/*  76 */       if (list != null && !list.isEmpty()) {
/*  77 */         AxisAlignedBB axisAlignedBB = this.field_70121_D.func_72314_b(4.0D, 2.0D, 4.0D);
/*  78 */         List list1 = this.field_70170_p.func_72872_a(EntityLivingBase.class, axisAlignedBB);
/*     */         
/*  80 */         if (list1 != null && !list1.isEmpty()) {
/*  81 */           for (EntityLivingBase entityLivingBase : list1) {
/*  82 */             double d = func_70068_e((Entity)entityLivingBase);
/*  83 */             if (d < 16.0D) {
/*  84 */               double d1 = 1.0D - Math.sqrt(d) / 4.0D;
/*  85 */               if (entityLivingBase == p_70184_1_.field_72308_g) {
/*  86 */                 d1 = 1.0D;
/*     */               }
/*     */               
/*  89 */               for (PotionEffect potionEffect : list) {
/*  90 */                 int i = potionEffect.func_76456_a();
/*  91 */                 if (Potion.field_76425_a[i].func_76403_b()) {
/*  92 */                   Potion.field_76425_a[i].func_76402_a(func_85052_h(), entityLivingBase, potionEffect.func_76458_c(), d1); continue;
/*     */                 } 
/*  94 */                 int j = (int)(d1 * potionEffect.func_76459_b() + 0.5D);
/*  95 */                 if (j > 20) {
/*  96 */                   entityLivingBase.func_70690_d(new PotionEffect(i, j, potionEffect.func_76458_c()));
/*     */                 }
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         }
/*     */       } 
/*     */       
/* 104 */       this.field_70170_p.func_72926_e(2002, (int)Math.round(this.field_70165_t), (int)Math.round(this.field_70163_u), (int)Math.round(this.field_70161_v), func_70196_i());
/*     */       
/* 106 */       func_70106_y();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound p_70037_1_) {
/* 112 */     super.func_70037_a(p_70037_1_);
/*     */     
/* 114 */     if (p_70037_1_.func_150297_b("Potion", 10)) {
/* 115 */       this.field_70197_d = ItemStack.func_77949_a(p_70037_1_.func_74775_l("Potion"));
/*     */     } else {
/* 117 */       func_82340_a(p_70037_1_.func_74762_e("potionValue"));
/*     */     } 
/*     */     
/* 120 */     if (this.field_70197_d == null) func_70106_y();
/*     */   
/*     */   }
/*     */   
/*     */   public void func_70014_b(NBTTagCompound p_70014_1_) {
/* 125 */     super.func_70014_b(p_70014_1_);
/* 126 */     if (this.field_70197_d != null) p_70014_1_.func_74782_a("Potion", (NBTBase)this.field_70197_d.func_77955_b(new NBTTagCompound())); 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\projectile\EntityPotion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */