/*     */ package net.minecraft.block;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.Direction;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockCocoa extends BlockDirectional implements IGrowable {
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon[] field_149989_a;
/*     */   
/*     */   public BlockCocoa() {
/*  18 */     super(Material.field_151585_k);
/*  19 */     func_149675_a(true);
/*     */   }
/*     */   private static final String __OBFID = "CL_00000216";
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/*  24 */     return this.field_149989_a[2];
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149988_b(int p_149988_1_) {
/*  28 */     if (p_149988_1_ < 0 || p_149988_1_ >= this.field_149989_a.length) {
/*  29 */       p_149988_1_ = this.field_149989_a.length - 1;
/*     */     }
/*  31 */     return this.field_149989_a[p_149988_1_];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
/*  37 */     if (!func_149718_j(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_)) {
/*  38 */       func_149697_b(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_1_.func_72805_g(p_149674_2_, p_149674_3_, p_149674_4_), 0);
/*  39 */       p_149674_1_.func_147465_d(p_149674_2_, p_149674_3_, p_149674_4_, func_149729_e(0), 0, 2);
/*  40 */     } else if (p_149674_1_.field_73012_v.nextInt(5) == 0) {
/*  41 */       int i = p_149674_1_.func_72805_g(p_149674_2_, p_149674_3_, p_149674_4_);
/*  42 */       int j = func_149987_c(i);
/*  43 */       if (j < 2) {
/*  44 */         j++;
/*  45 */         p_149674_1_.func_72921_c(p_149674_2_, p_149674_3_, p_149674_4_, j << 2 | func_149895_l(i), 2);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149718_j(World p_149718_1_, int p_149718_2_, int p_149718_3_, int p_149718_4_) {
/*  52 */     int i = func_149895_l(p_149718_1_.func_72805_g(p_149718_2_, p_149718_3_, p_149718_4_));
/*     */     
/*  54 */     p_149718_2_ += Direction.field_71583_a[i];
/*  55 */     p_149718_4_ += Direction.field_71581_b[i];
/*  56 */     Block block = p_149718_1_.func_147439_a(p_149718_2_, p_149718_3_, p_149718_4_);
/*     */     
/*  58 */     return (block == Blocks.field_150364_r && BlockLog.func_150165_c(p_149718_1_.func_72805_g(p_149718_2_, p_149718_3_, p_149718_4_)) == 3);
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/*  63 */     return 28;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/*  68 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  73 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
/*  78 */     func_149719_a((IBlockAccess)p_149668_1_, p_149668_2_, p_149668_3_, p_149668_4_);
/*  79 */     return super.func_149668_a(p_149668_1_, p_149668_2_, p_149668_3_, p_149668_4_);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public AxisAlignedBB func_149633_g(World p_149633_1_, int p_149633_2_, int p_149633_3_, int p_149633_4_) {
/*  84 */     func_149719_a((IBlockAccess)p_149633_1_, p_149633_2_, p_149633_3_, p_149633_4_);
/*  85 */     return super.func_149633_g(p_149633_1_, p_149633_2_, p_149633_3_, p_149633_4_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
/*  90 */     int i = p_149719_1_.func_72805_g(p_149719_2_, p_149719_3_, p_149719_4_);
/*  91 */     int j = func_149895_l(i);
/*  92 */     int k = func_149987_c(i);
/*     */     
/*  94 */     int m = 4 + k * 2;
/*  95 */     int n = 5 + k * 2;
/*     */     
/*  97 */     float f = m / 2.0F;
/*     */     
/*  99 */     switch (j) {
/*     */       case 0:
/* 101 */         func_149676_a((8.0F - f) / 16.0F, (12.0F - n) / 16.0F, (15.0F - m) / 16.0F, (8.0F + f) / 16.0F, 0.75F, 0.9375F);
/*     */         break;
/*     */       case 2:
/* 104 */         func_149676_a((8.0F - f) / 16.0F, (12.0F - n) / 16.0F, 0.0625F, (8.0F + f) / 16.0F, 0.75F, (1.0F + m) / 16.0F);
/*     */         break;
/*     */       case 1:
/* 107 */         func_149676_a(0.0625F, (12.0F - n) / 16.0F, (8.0F - f) / 16.0F, (1.0F + m) / 16.0F, 0.75F, (8.0F + f) / 16.0F);
/*     */         break;
/*     */       case 3:
/* 110 */         func_149676_a((15.0F - m) / 16.0F, (12.0F - n) / 16.0F, (8.0F - f) / 16.0F, 0.9375F, 0.75F, (8.0F + f) / 16.0F);
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149689_a(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_) {
/* 117 */     int i = ((MathHelper.func_76128_c((p_149689_5_.field_70177_z * 4.0F / 360.0F) + 0.5D) & 0x3) + 0) % 4;
/* 118 */     p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_, i, 2);
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149660_a(World p_149660_1_, int p_149660_2_, int p_149660_3_, int p_149660_4_, int p_149660_5_, float p_149660_6_, float p_149660_7_, float p_149660_8_, int p_149660_9_) {
/* 123 */     if (p_149660_5_ == 1 || p_149660_5_ == 0) {
/* 124 */       p_149660_5_ = 2;
/*     */     }
/* 126 */     return Direction.field_71580_e[Direction.field_71579_d[p_149660_5_]];
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
/* 131 */     if (!func_149718_j(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_)) {
/* 132 */       func_149697_b(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, p_149695_1_.func_72805_g(p_149695_2_, p_149695_3_, p_149695_4_), 0);
/* 133 */       p_149695_1_.func_147465_d(p_149695_2_, p_149695_3_, p_149695_4_, func_149729_e(0), 0, 2);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static int func_149987_c(int p_149987_0_) {
/* 138 */     return (p_149987_0_ & 0xC) >> 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149690_a(World p_149690_1_, int p_149690_2_, int p_149690_3_, int p_149690_4_, int p_149690_5_, float p_149690_6_, int p_149690_7_) {
/* 143 */     int i = func_149987_c(p_149690_5_);
/* 144 */     byte b1 = 1;
/* 145 */     if (i >= 2) {
/* 146 */       b1 = 3;
/*     */     }
/* 148 */     for (byte b2 = 0; b2 < b1; b2++) {
/* 149 */       func_149642_a(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, new ItemStack(Items.field_151100_aR, 1, 3));
/*     */     }
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
/* 155 */     return Items.field_151100_aR;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149643_k(World p_149643_1_, int p_149643_2_, int p_149643_3_, int p_149643_4_) {
/* 160 */     return 3;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 165 */     this.field_149989_a = new IIcon[3];
/*     */     
/* 167 */     for (byte b = 0; b < this.field_149989_a.length; b++) {
/* 168 */       this.field_149989_a[b] = p_149651_1_.func_94245_a(func_149641_N() + "_stage_" + b);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149851_a(World p_149851_1_, int p_149851_2_, int p_149851_3_, int p_149851_4_, boolean p_149851_5_) {
/* 174 */     int i = p_149851_1_.func_72805_g(p_149851_2_, p_149851_3_, p_149851_4_);
/* 175 */     int j = func_149987_c(i);
/* 176 */     if (j >= 2) return false; 
/* 177 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149852_a(World p_149852_1_, Random p_149852_2_, int p_149852_3_, int p_149852_4_, int p_149852_5_) {
/* 182 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149853_b(World p_149853_1_, Random p_149853_2_, int p_149853_3_, int p_149853_4_, int p_149853_5_) {
/* 187 */     int i = p_149853_1_.func_72805_g(p_149853_3_, p_149853_4_, p_149853_5_);
/* 188 */     int j = BlockDirectional.func_149895_l(i);
/* 189 */     int k = func_149987_c(i);
/* 190 */     k++;
/* 191 */     p_149853_1_.func_72921_c(p_149853_3_, p_149853_4_, p_149853_5_, k << 2 | j, 2);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockCocoa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */