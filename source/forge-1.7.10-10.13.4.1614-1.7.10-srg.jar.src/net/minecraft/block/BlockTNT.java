/*     */ package net.minecraft.block;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityTNTPrimed;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.projectile.EntityArrow;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.Explosion;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockTNT extends Block {
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon field_150116_a;
/*     */   
/*     */   public BlockTNT() {
/*  24 */     super(Material.field_151590_u);
/*  25 */     func_149647_a(CreativeTabs.field_78028_d);
/*     */   } @SideOnly(Side.CLIENT)
/*     */   private IIcon field_150115_b; private static final String __OBFID = "CL_00000324";
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/*  30 */     if (p_149691_1_ == 0) return this.field_150115_b; 
/*  31 */     if (p_149691_1_ == 1) return this.field_150116_a; 
/*  32 */     return this.field_149761_L;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149726_b(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {
/*  37 */     super.func_149726_b(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
/*  38 */     if (p_149726_1_.func_72864_z(p_149726_2_, p_149726_3_, p_149726_4_)) {
/*  39 */       func_149664_b(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_, 1);
/*  40 */       p_149726_1_.func_147468_f(p_149726_2_, p_149726_3_, p_149726_4_);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
/*  47 */     if (p_149695_1_.func_72864_z(p_149695_2_, p_149695_3_, p_149695_4_)) {
/*  48 */       func_149664_b(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, 1);
/*  49 */       p_149695_1_.func_147468_f(p_149695_2_, p_149695_3_, p_149695_4_);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149745_a(Random p_149745_1_) {
/*  56 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149723_a(World p_149723_1_, int p_149723_2_, int p_149723_3_, int p_149723_4_, Explosion p_149723_5_) {
/*  61 */     if (p_149723_1_.field_72995_K)
/*     */       return; 
/*  63 */     EntityTNTPrimed entityTNTPrimed = new EntityTNTPrimed(p_149723_1_, (p_149723_2_ + 0.5F), (p_149723_3_ + 0.5F), (p_149723_4_ + 0.5F), p_149723_5_.func_94613_c());
/*  64 */     entityTNTPrimed.field_70516_a = p_149723_1_.field_73012_v.nextInt(entityTNTPrimed.field_70516_a / 4) + entityTNTPrimed.field_70516_a / 8;
/*  65 */     p_149723_1_.func_72838_d((Entity)entityTNTPrimed);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149664_b(World p_149664_1_, int p_149664_2_, int p_149664_3_, int p_149664_4_, int p_149664_5_) {
/*  70 */     func_150114_a(p_149664_1_, p_149664_2_, p_149664_3_, p_149664_4_, p_149664_5_, (EntityLivingBase)null);
/*     */   }
/*     */   
/*     */   public void func_150114_a(World p_150114_1_, int p_150114_2_, int p_150114_3_, int p_150114_4_, int p_150114_5_, EntityLivingBase p_150114_6_) {
/*  74 */     if (p_150114_1_.field_72995_K)
/*     */       return; 
/*  76 */     if ((p_150114_5_ & 0x1) == 1) {
/*  77 */       EntityTNTPrimed entityTNTPrimed = new EntityTNTPrimed(p_150114_1_, (p_150114_2_ + 0.5F), (p_150114_3_ + 0.5F), (p_150114_4_ + 0.5F), p_150114_6_);
/*  78 */       p_150114_1_.func_72838_d((Entity)entityTNTPrimed);
/*  79 */       p_150114_1_.func_72956_a((Entity)entityTNTPrimed, "game.tnt.primed", 1.0F, 1.0F);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
/*  85 */     if (p_149727_5_.func_71045_bC() != null && p_149727_5_.func_71045_bC().func_77973_b() == Items.field_151033_d) {
/*  86 */       func_150114_a(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_, 1, (EntityLivingBase)p_149727_5_);
/*  87 */       p_149727_1_.func_147468_f(p_149727_2_, p_149727_3_, p_149727_4_);
/*  88 */       p_149727_5_.func_71045_bC().func_77972_a(1, (EntityLivingBase)p_149727_5_);
/*  89 */       return true;
/*     */     } 
/*  91 */     return super.func_149727_a(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_, p_149727_5_, p_149727_6_, p_149727_7_, p_149727_8_, p_149727_9_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149670_a(World p_149670_1_, int p_149670_2_, int p_149670_3_, int p_149670_4_, Entity p_149670_5_) {
/*  96 */     if (p_149670_5_ instanceof EntityArrow && !p_149670_1_.field_72995_K) {
/*  97 */       EntityArrow entityArrow = (EntityArrow)p_149670_5_;
/*  98 */       if (entityArrow.func_70027_ad()) {
/*  99 */         func_150114_a(p_149670_1_, p_149670_2_, p_149670_3_, p_149670_4_, 1, (entityArrow.field_70250_c instanceof EntityLivingBase) ? (EntityLivingBase)entityArrow.field_70250_c : null);
/* 100 */         p_149670_1_.func_147468_f(p_149670_2_, p_149670_3_, p_149670_4_);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149659_a(Explosion p_149659_1_) {
/* 107 */     return false;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 112 */     this.field_149761_L = p_149651_1_.func_94245_a(func_149641_N() + "_side");
/* 113 */     this.field_150116_a = p_149651_1_.func_94245_a(func_149641_N() + "_top");
/* 114 */     this.field_150115_b = p_149651_1_.func_94245_a(func_149641_N() + "_bottom");
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockTNT.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */