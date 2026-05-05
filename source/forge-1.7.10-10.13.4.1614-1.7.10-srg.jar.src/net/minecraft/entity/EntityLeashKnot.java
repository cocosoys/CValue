/*     */ package net.minecraft.entity;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntityLeashKnot
/*     */   extends EntityHanging
/*     */ {
/*     */   private static final String __OBFID = "CL_00001548";
/*     */   
/*     */   public EntityLeashKnot(World p_i1592_1_) {
/*  22 */     super(p_i1592_1_);
/*     */   }
/*     */   
/*     */   public EntityLeashKnot(World p_i1593_1_, int p_i1593_2_, int p_i1593_3_, int p_i1593_4_) {
/*  26 */     super(p_i1593_1_, p_i1593_2_, p_i1593_3_, p_i1593_4_, 0);
/*  27 */     func_70107_b(p_i1593_2_ + 0.5D, p_i1593_3_ + 0.5D, p_i1593_4_ + 0.5D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/*  32 */     super.func_70088_a();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_82328_a(int p_82328_1_) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_82329_d() {
/*  42 */     return 9;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_82330_g() {
/*  47 */     return 9;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_70112_a(double p_70112_1_) {
/*  52 */     return (p_70112_1_ < 1024.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_110128_b(Entity p_110128_1_) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70039_c(NBTTagCompound p_70039_1_) {
/*  63 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound p_70014_1_) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound p_70037_1_) {}
/*     */ 
/*     */   
/*     */   public boolean func_130002_c(EntityPlayer p_130002_1_) {
/*  76 */     ItemStack itemStack = p_130002_1_.func_70694_bm();
/*     */     
/*  78 */     boolean bool = false;
/*  79 */     if (itemStack != null && itemStack.func_77973_b() == Items.field_151058_ca && 
/*  80 */       !this.field_70170_p.field_72995_K) {
/*     */       
/*  82 */       double d = 7.0D;
/*  83 */       List list = this.field_70170_p.func_72872_a(EntityLiving.class, AxisAlignedBB.func_72330_a(this.field_70165_t - d, this.field_70163_u - d, this.field_70161_v - d, this.field_70165_t + d, this.field_70163_u + d, this.field_70161_v + d));
/*  84 */       if (list != null) {
/*  85 */         for (EntityLiving entityLiving : list) {
/*  86 */           if (entityLiving.func_110167_bD() && entityLiving.func_110166_bE() == p_130002_1_) {
/*  87 */             entityLiving.func_110162_b(this, true);
/*  88 */             bool = true;
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/*  94 */     if (!this.field_70170_p.field_72995_K && !bool) {
/*  95 */       func_70106_y();
/*     */       
/*  97 */       if (p_130002_1_.field_71075_bZ.field_75098_d) {
/*     */         
/*  99 */         double d = 7.0D;
/* 100 */         List list = this.field_70170_p.func_72872_a(EntityLiving.class, AxisAlignedBB.func_72330_a(this.field_70165_t - d, this.field_70163_u - d, this.field_70161_v - d, this.field_70165_t + d, this.field_70163_u + d, this.field_70161_v + d));
/* 101 */         if (list != null) {
/* 102 */           for (EntityLiving entityLiving : list) {
/* 103 */             if (entityLiving.func_110167_bD() && entityLiving.func_110166_bE() == this) {
/* 104 */               entityLiving.func_110160_i(true, false);
/*     */             }
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/* 110 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70518_d() {
/* 116 */     return (this.field_70170_p.func_147439_a(this.field_146063_b, this.field_146064_c, this.field_146062_d).func_149645_b() == 11);
/*     */   }
/*     */   
/*     */   public static EntityLeashKnot func_110129_a(World p_110129_0_, int p_110129_1_, int p_110129_2_, int p_110129_3_) {
/* 120 */     EntityLeashKnot entityLeashKnot = new EntityLeashKnot(p_110129_0_, p_110129_1_, p_110129_2_, p_110129_3_);
/* 121 */     entityLeashKnot.field_98038_p = true;
/* 122 */     p_110129_0_.func_72838_d(entityLeashKnot);
/* 123 */     return entityLeashKnot;
/*     */   }
/*     */   
/*     */   public static EntityLeashKnot func_110130_b(World p_110130_0_, int p_110130_1_, int p_110130_2_, int p_110130_3_) {
/* 127 */     List list = p_110130_0_.func_72872_a(EntityLeashKnot.class, AxisAlignedBB.func_72330_a(p_110130_1_ - 1.0D, p_110130_2_ - 1.0D, p_110130_3_ - 1.0D, p_110130_1_ + 1.0D, p_110130_2_ + 1.0D, p_110130_3_ + 1.0D));
/* 128 */     if (list != null) {
/* 129 */       for (EntityLeashKnot entityLeashKnot : list) {
/* 130 */         if (entityLeashKnot.field_146063_b == p_110130_1_ && entityLeashKnot.field_146064_c == p_110130_2_ && entityLeashKnot.field_146062_d == p_110130_3_) {
/* 131 */           return entityLeashKnot;
/*     */         }
/*     */       } 
/*     */     }
/* 135 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\EntityLeashKnot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */