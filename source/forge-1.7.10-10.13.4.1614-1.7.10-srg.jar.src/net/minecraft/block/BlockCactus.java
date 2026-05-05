/*     */ package net.minecraft.block;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockCactus extends Block {
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon field_150041_a;
/*     */   
/*     */   protected BlockCactus() {
/*  20 */     super(Material.field_151570_A);
/*  21 */     func_149675_a(true);
/*  22 */     func_149647_a(CreativeTabs.field_78031_c);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon field_150040_b; private static final String __OBFID = "CL_00000210";
/*     */   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
/*  27 */     if (p_149674_1_.func_147437_c(p_149674_2_, p_149674_3_ + 1, p_149674_4_)) {
/*  28 */       byte b = 1;
/*  29 */       while (p_149674_1_.func_147439_a(p_149674_2_, p_149674_3_ - b, p_149674_4_) == this) {
/*  30 */         b++;
/*     */       }
/*  32 */       if (b < 3) {
/*  33 */         int i = p_149674_1_.func_72805_g(p_149674_2_, p_149674_3_, p_149674_4_);
/*  34 */         if (i == 15) {
/*  35 */           p_149674_1_.func_147449_b(p_149674_2_, p_149674_3_ + 1, p_149674_4_, this);
/*  36 */           p_149674_1_.func_72921_c(p_149674_2_, p_149674_3_, p_149674_4_, 0, 4);
/*  37 */           func_149695_a(p_149674_1_, p_149674_2_, p_149674_3_ + 1, p_149674_4_, this);
/*     */         } else {
/*  39 */           p_149674_1_.func_72921_c(p_149674_2_, p_149674_3_, p_149674_4_, i + 1, 4);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
/*  47 */     float f = 0.0625F;
/*  48 */     return AxisAlignedBB.func_72330_a((p_149668_2_ + f), p_149668_3_, (p_149668_4_ + f), ((p_149668_2_ + 1) - f), ((p_149668_3_ + 1) - f), ((p_149668_4_ + 1) - f));
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public AxisAlignedBB func_149633_g(World p_149633_1_, int p_149633_2_, int p_149633_3_, int p_149633_4_) {
/*  53 */     float f = 0.0625F;
/*  54 */     return AxisAlignedBB.func_72330_a((p_149633_2_ + f), p_149633_3_, (p_149633_4_ + f), ((p_149633_2_ + 1) - f), (p_149633_3_ + 1), ((p_149633_4_ + 1) - f));
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/*  59 */     if (p_149691_1_ == 1) return this.field_150041_a; 
/*  60 */     if (p_149691_1_ == 0) return this.field_150040_b; 
/*  61 */     return this.field_149761_L;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/*  66 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  71 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/*  76 */     return 13;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149742_c(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_) {
/*  81 */     if (!super.func_149742_c(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_)) return false;
/*     */     
/*  83 */     return func_149718_j(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
/*  88 */     if (!func_149718_j(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_)) {
/*  89 */       p_149695_1_.func_147480_a(p_149695_2_, p_149695_3_, p_149695_4_, true);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149718_j(World p_149718_1_, int p_149718_2_, int p_149718_3_, int p_149718_4_) {
/*  95 */     if (p_149718_1_.func_147439_a(p_149718_2_ - 1, p_149718_3_, p_149718_4_).func_149688_o().func_76220_a()) return false; 
/*  96 */     if (p_149718_1_.func_147439_a(p_149718_2_ + 1, p_149718_3_, p_149718_4_).func_149688_o().func_76220_a()) return false; 
/*  97 */     if (p_149718_1_.func_147439_a(p_149718_2_, p_149718_3_, p_149718_4_ - 1).func_149688_o().func_76220_a()) return false; 
/*  98 */     if (p_149718_1_.func_147439_a(p_149718_2_, p_149718_3_, p_149718_4_ + 1).func_149688_o().func_76220_a()) return false; 
/*  99 */     Block block = p_149718_1_.func_147439_a(p_149718_2_, p_149718_3_ - 1, p_149718_4_);
/* 100 */     return (block == Blocks.field_150434_aF || block == Blocks.field_150354_m);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149670_a(World p_149670_1_, int p_149670_2_, int p_149670_3_, int p_149670_4_, Entity p_149670_5_) {
/* 105 */     p_149670_5_.func_70097_a(DamageSource.field_76367_g, 1.0F);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 110 */     this.field_149761_L = p_149651_1_.func_94245_a(func_149641_N() + "_side");
/* 111 */     this.field_150041_a = p_149651_1_.func_94245_a(func_149641_N() + "_top");
/* 112 */     this.field_150040_b = p_149651_1_.func_94245_a(func_149641_N() + "_bottom");
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockCactus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */