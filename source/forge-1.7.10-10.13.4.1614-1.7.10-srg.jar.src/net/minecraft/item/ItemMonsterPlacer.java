/*     */ package net.minecraft.item;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityList;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.Facing;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.StatCollector;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class ItemMonsterPlacer extends Item {
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon field_94593_a;
/*     */   
/*     */   public ItemMonsterPlacer() {
/*  25 */     func_77627_a(true);
/*  26 */     func_77637_a(CreativeTabs.field_78026_f);
/*     */   }
/*     */   
/*     */   private static final String __OBFID = "CL_00000070";
/*     */   
/*     */   public String func_77653_i(ItemStack p_77653_1_) {
/*  32 */     String str1 = ("" + StatCollector.func_74838_a(func_77658_a() + ".name")).trim();
/*     */     
/*  34 */     String str2 = EntityList.func_75617_a(p_77653_1_.func_77960_j());
/*  35 */     if (str2 != null) {
/*  36 */       str1 = str1 + " " + StatCollector.func_74838_a("entity." + str2 + ".name");
/*     */     }
/*     */     
/*  39 */     return str1;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_82790_a(ItemStack p_82790_1_, int p_82790_2_) {
/*  44 */     EntityList.EntityEggInfo entityEggInfo = (EntityList.EntityEggInfo)EntityList.field_75627_a.get(Integer.valueOf(p_82790_1_.func_77960_j()));
/*  45 */     if (entityEggInfo != null) {
/*  46 */       if (p_82790_2_ == 0) {
/*  47 */         return entityEggInfo.field_75611_b;
/*     */       }
/*  49 */       return entityEggInfo.field_75612_c;
/*     */     } 
/*  51 */     return 16777215;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_77623_v() {
/*  56 */     return true;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_77618_c(int p_77618_1_, int p_77618_2_) {
/*  61 */     if (p_77618_2_ > 0) {
/*  62 */       return this.field_94593_a;
/*     */     }
/*  64 */     return super.func_77618_c(p_77618_1_, p_77618_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
/*  69 */     if (p_77648_3_.field_72995_K) {
/*  70 */       return true;
/*     */     }
/*     */     
/*  73 */     Block block = p_77648_3_.func_147439_a(p_77648_4_, p_77648_5_, p_77648_6_);
/*     */     
/*  75 */     p_77648_4_ += Facing.field_71586_b[p_77648_7_];
/*  76 */     p_77648_5_ += Facing.field_71587_c[p_77648_7_];
/*  77 */     p_77648_6_ += Facing.field_71585_d[p_77648_7_];
/*     */     
/*  79 */     double d = 0.0D;
/*  80 */     if (p_77648_7_ == 1 && block.func_149645_b() == 11)
/*     */     {
/*  82 */       d = 0.5D;
/*     */     }
/*     */     
/*  85 */     Entity entity = func_77840_a(p_77648_3_, p_77648_1_.func_77960_j(), p_77648_4_ + 0.5D, p_77648_5_ + d, p_77648_6_ + 0.5D);
/*  86 */     if (entity != null) {
/*  87 */       if (entity instanceof net.minecraft.entity.EntityLivingBase && p_77648_1_.func_82837_s()) {
/*  88 */         ((EntityLiving)entity).func_94058_c(p_77648_1_.func_82833_r());
/*     */       }
/*  90 */       if (!p_77648_2_.field_71075_bZ.field_75098_d) {
/*  91 */         p_77648_1_.field_77994_a--;
/*     */       }
/*     */     } 
/*     */     
/*  95 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
/* 100 */     if (p_77659_2_.field_72995_K) return p_77659_1_;
/*     */     
/* 102 */     MovingObjectPosition movingObjectPosition = func_77621_a(p_77659_2_, p_77659_3_, true);
/* 103 */     if (movingObjectPosition == null) return p_77659_1_;
/*     */     
/* 105 */     if (movingObjectPosition.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK) {
/* 106 */       int i = movingObjectPosition.field_72311_b;
/* 107 */       int j = movingObjectPosition.field_72312_c;
/* 108 */       int k = movingObjectPosition.field_72309_d;
/*     */       
/* 110 */       if (!p_77659_2_.func_72962_a(p_77659_3_, i, j, k)) {
/* 111 */         return p_77659_1_;
/*     */       }
/* 113 */       if (!p_77659_3_.func_82247_a(i, j, k, movingObjectPosition.field_72310_e, p_77659_1_)) return p_77659_1_;
/*     */       
/* 115 */       if (p_77659_2_.func_147439_a(i, j, k) instanceof net.minecraft.block.BlockLiquid) {
/* 116 */         Entity entity = func_77840_a(p_77659_2_, p_77659_1_.func_77960_j(), i, j, k);
/* 117 */         if (entity != null) {
/* 118 */           if (entity instanceof net.minecraft.entity.EntityLivingBase && p_77659_1_.func_82837_s()) {
/* 119 */             ((EntityLiving)entity).func_94058_c(p_77659_1_.func_82833_r());
/*     */           }
/* 121 */           if (!p_77659_3_.field_71075_bZ.field_75098_d) {
/* 122 */             p_77659_1_.field_77994_a--;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 127 */     return p_77659_1_;
/*     */   }
/*     */   
/*     */   public static Entity func_77840_a(World p_77840_0_, int p_77840_1_, double p_77840_2_, double p_77840_4_, double p_77840_6_) {
/* 131 */     if (!EntityList.field_75627_a.containsKey(Integer.valueOf(p_77840_1_))) {
/* 132 */       return null;
/*     */     }
/*     */     
/* 135 */     Entity entity = null;
/*     */     
/* 137 */     for (byte b = 0; b < 1; b++) {
/* 138 */       entity = EntityList.func_75616_a(p_77840_1_, p_77840_0_);
/*     */       
/* 140 */       if (entity != null && entity instanceof net.minecraft.entity.EntityLivingBase) {
/* 141 */         EntityLiving entityLiving = (EntityLiving)entity;
/* 142 */         entity.func_70012_b(p_77840_2_, p_77840_4_, p_77840_6_, MathHelper.func_76142_g(p_77840_0_.field_73012_v.nextFloat() * 360.0F), 0.0F);
/* 143 */         entityLiving.field_70759_as = entityLiving.field_70177_z;
/* 144 */         entityLiving.field_70761_aq = entityLiving.field_70177_z;
/*     */         
/* 146 */         entityLiving.func_110161_a(null);
/* 147 */         p_77840_0_.func_72838_d(entity);
/* 148 */         entityLiving.func_70642_aH();
/*     */       } 
/*     */     } 
/*     */     
/* 152 */     return entity;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_150895_a(Item p_150895_1_, CreativeTabs p_150895_2_, List<ItemStack> p_150895_3_) {
/* 157 */     for (EntityList.EntityEggInfo entityEggInfo : EntityList.field_75627_a.values()) {
/* 158 */       p_150895_3_.add(new ItemStack(p_150895_1_, 1, entityEggInfo.field_75613_a));
/*     */     }
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94581_a(IIconRegister p_94581_1_) {
/* 164 */     super.func_94581_a(p_94581_1_);
/* 165 */     this.field_94593_a = p_94581_1_.func_94245_a(func_111208_A() + "_overlay");
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemMonsterPlacer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */