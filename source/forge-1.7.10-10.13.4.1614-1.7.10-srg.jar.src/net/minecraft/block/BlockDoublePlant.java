/*     */ package net.minecraft.block;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.stats.StatList;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockDoublePlant
/*     */   extends BlockBush
/*     */   implements IGrowable
/*     */ {
/*  29 */   public static final String[] field_149892_a = new String[] { "sunflower", "syringa", "grass", "fern", "rose", "paeonia" };
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon[] field_149893_M;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon[] field_149894_N;
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon[] field_149891_b;
/*     */   private static final String __OBFID = "CL_00000231";
/*     */   
/*     */   public BlockDoublePlant() {
/*  39 */     super(Material.field_151585_k);
/*     */     
/*  41 */     func_149711_c(0.0F);
/*  42 */     func_149672_a(field_149779_h);
/*  43 */     func_149663_c("doublePlant");
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/*  48 */     return 40;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
/*  53 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*     */   }
/*     */   
/*     */   public int func_149885_e(IBlockAccess p_149885_1_, int p_149885_2_, int p_149885_3_, int p_149885_4_) {
/*  57 */     int i = p_149885_1_.func_72805_g(p_149885_2_, p_149885_3_, p_149885_4_);
/*  58 */     if (!func_149887_c(i)) {
/*  59 */       return i & 0x7;
/*     */     }
/*  61 */     return p_149885_1_.func_72805_g(p_149885_2_, p_149885_3_ - 1, p_149885_4_) & 0x7;
/*     */   }
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
/*     */   public boolean func_149742_c(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_) {
/*  80 */     return (super.func_149742_c(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_) && p_149742_1_.func_147437_c(p_149742_2_, p_149742_3_ + 1, p_149742_4_));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_149855_e(World p_149855_1_, int p_149855_2_, int p_149855_3_, int p_149855_4_) {
/*  85 */     if (!func_149718_j(p_149855_1_, p_149855_2_, p_149855_3_, p_149855_4_)) {
/*  86 */       int i = p_149855_1_.func_72805_g(p_149855_2_, p_149855_3_, p_149855_4_);
/*  87 */       if (!func_149887_c(i)) {
/*  88 */         func_149697_b(p_149855_1_, p_149855_2_, p_149855_3_, p_149855_4_, i, 0);
/*  89 */         if (p_149855_1_.func_147439_a(p_149855_2_, p_149855_3_ + 1, p_149855_4_) == this) {
/*  90 */           p_149855_1_.func_147465_d(p_149855_2_, p_149855_3_ + 1, p_149855_4_, Blocks.field_150350_a, 0, 2);
/*     */         }
/*     */       } 
/*  93 */       p_149855_1_.func_147465_d(p_149855_2_, p_149855_3_, p_149855_4_, Blocks.field_150350_a, 0, 2);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149718_j(World p_149718_1_, int p_149718_2_, int p_149718_3_, int p_149718_4_) {
/*  99 */     int i = p_149718_1_.func_72805_g(p_149718_2_, p_149718_3_, p_149718_4_);
/* 100 */     if (func_149887_c(i)) {
/* 101 */       return (p_149718_1_.func_147439_a(p_149718_2_, p_149718_3_ - 1, p_149718_4_) == this);
/*     */     }
/* 103 */     return (p_149718_1_.func_147439_a(p_149718_2_, p_149718_3_ + 1, p_149718_4_) == this && super.func_149718_j(p_149718_1_, p_149718_2_, p_149718_3_, p_149718_4_));
/*     */   }
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/* 108 */     if (func_149887_c(p_149650_1_)) {
/* 109 */       return null;
/*     */     }
/* 111 */     int i = func_149890_d(p_149650_1_);
/* 112 */     if (i == 3 || i == 2)
/*     */     {
/* 114 */       return null;
/*     */     }
/* 116 */     return Item.func_150898_a(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149692_a(int p_149692_1_) {
/* 121 */     if (func_149887_c(p_149692_1_)) {
/* 122 */       return 0;
/*     */     }
/* 124 */     return p_149692_1_ & 0x7;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean func_149887_c(int p_149887_0_) {
/* 132 */     return ((p_149887_0_ & 0x8) != 0);
/*     */   }
/*     */   
/*     */   public static int func_149890_d(int p_149890_0_) {
/* 136 */     return p_149890_0_ & 0x7;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/* 141 */     if (func_149887_c(p_149691_2_)) {
/* 142 */       return this.field_149893_M[0];
/*     */     }
/* 144 */     return this.field_149893_M[p_149691_2_ & 0x7];
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149888_a(boolean p_149888_1_, int p_149888_2_) {
/* 148 */     if (p_149888_1_) {
/* 149 */       return this.field_149894_N[p_149888_2_];
/*     */     }
/* 151 */     return this.field_149893_M[p_149888_2_];
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149720_d(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_) {
/* 156 */     int i = func_149885_e(p_149720_1_, p_149720_2_, p_149720_3_, p_149720_4_);
/* 157 */     if (i == 2 || i == 3) {
/* 158 */       return p_149720_1_.func_72807_a(p_149720_2_, p_149720_4_).func_150558_b(p_149720_2_, p_149720_3_, p_149720_4_);
/*     */     }
/* 160 */     return 16777215;
/*     */   }
/*     */   
/*     */   public void func_149889_c(World p_149889_1_, int p_149889_2_, int p_149889_3_, int p_149889_4_, int p_149889_5_, int p_149889_6_) {
/* 164 */     p_149889_1_.func_147465_d(p_149889_2_, p_149889_3_, p_149889_4_, this, p_149889_5_, p_149889_6_);
/* 165 */     p_149889_1_.func_147465_d(p_149889_2_, p_149889_3_ + 1, p_149889_4_, this, 8, p_149889_6_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149689_a(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_) {
/* 170 */     int i = ((MathHelper.func_76128_c((p_149689_5_.field_70177_z * 4.0F / 360.0F) + 0.5D) & 0x3) + 2) % 4;
/* 171 */     p_149689_1_.func_147465_d(p_149689_2_, p_149689_3_ + 1, p_149689_4_, this, 0x8 | i, 2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149636_a(World p_149636_1_, EntityPlayer p_149636_2_, int p_149636_3_, int p_149636_4_, int p_149636_5_, int p_149636_6_) {
/* 176 */     if (!p_149636_1_.field_72995_K && p_149636_2_.func_71045_bC() != null && p_149636_2_.func_71045_bC().func_77973_b() == Items.field_151097_aZ)
/*     */     {
/*     */ 
/*     */       
/* 180 */       if (!func_149887_c(p_149636_6_) && 
/* 181 */         func_149886_b(p_149636_1_, p_149636_3_, p_149636_4_, p_149636_5_, p_149636_6_, p_149636_2_)) {
/*     */         return;
/*     */       }
/*     */     }
/*     */     
/* 186 */     super.func_149636_a(p_149636_1_, p_149636_2_, p_149636_3_, p_149636_4_, p_149636_5_, p_149636_6_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149681_a(World p_149681_1_, int p_149681_2_, int p_149681_3_, int p_149681_4_, int p_149681_5_, EntityPlayer p_149681_6_) {
/* 191 */     if (func_149887_c(p_149681_5_)) {
/* 192 */       if (p_149681_1_.func_147439_a(p_149681_2_, p_149681_3_ - 1, p_149681_4_) == this) {
/* 193 */         if (!p_149681_6_.field_71075_bZ.field_75098_d) {
/*     */           
/* 195 */           int i = p_149681_1_.func_72805_g(p_149681_2_, p_149681_3_ - 1, p_149681_4_);
/* 196 */           int j = func_149890_d(i);
/* 197 */           if (j == 3 || j == 2) {
/* 198 */             if (!p_149681_1_.field_72995_K && p_149681_6_.func_71045_bC() != null && p_149681_6_.func_71045_bC().func_77973_b() == Items.field_151097_aZ) {
/* 199 */               func_149886_b(p_149681_1_, p_149681_2_, p_149681_3_, p_149681_4_, i, p_149681_6_);
/*     */             }
/* 201 */             p_149681_1_.func_147468_f(p_149681_2_, p_149681_3_ - 1, p_149681_4_);
/*     */           } else {
/* 203 */             p_149681_1_.func_147480_a(p_149681_2_, p_149681_3_ - 1, p_149681_4_, true);
/*     */           } 
/*     */         } else {
/* 206 */           p_149681_1_.func_147468_f(p_149681_2_, p_149681_3_ - 1, p_149681_4_);
/*     */         }
/*     */       
/*     */       }
/* 210 */     } else if (p_149681_6_.field_71075_bZ.field_75098_d && p_149681_1_.func_147439_a(p_149681_2_, p_149681_3_ + 1, p_149681_4_) == this) {
/*     */       
/* 212 */       p_149681_1_.func_147465_d(p_149681_2_, p_149681_3_ + 1, p_149681_4_, Blocks.field_150350_a, 0, 2);
/*     */     } 
/*     */     
/* 215 */     super.func_149681_a(p_149681_1_, p_149681_2_, p_149681_3_, p_149681_4_, p_149681_5_, p_149681_6_);
/*     */   }
/*     */   
/*     */   private boolean func_149886_b(World p_149886_1_, int p_149886_2_, int p_149886_3_, int p_149886_4_, int p_149886_5_, EntityPlayer p_149886_6_) {
/* 219 */     int i = func_149890_d(p_149886_5_);
/* 220 */     if (i == 3 || i == 2) {
/* 221 */       p_149886_6_.func_71064_a(StatList.field_75934_C[Block.func_149682_b(this)], 1);
/* 222 */       byte b = 1;
/* 223 */       if (i == 3) {
/* 224 */         b = 2;
/*     */       }
/*     */       
/* 227 */       func_149642_a(p_149886_1_, p_149886_2_, p_149886_3_, p_149886_4_, new ItemStack(Blocks.field_150329_H, 2, b));
/* 228 */       return true;
/*     */     } 
/* 230 */     return false;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 235 */     this.field_149893_M = new IIcon[field_149892_a.length];
/* 236 */     this.field_149894_N = new IIcon[field_149892_a.length];
/*     */     
/* 238 */     for (byte b = 0; b < this.field_149893_M.length; b++) {
/* 239 */       this.field_149893_M[b] = p_149651_1_.func_94245_a("double_plant_" + field_149892_a[b] + "_bottom");
/* 240 */       this.field_149894_N[b] = p_149651_1_.func_94245_a("double_plant_" + field_149892_a[b] + "_top");
/*     */     } 
/*     */     
/* 243 */     this.field_149891_b = new IIcon[2];
/* 244 */     this.field_149891_b[0] = p_149651_1_.func_94245_a("double_plant_sunflower_front");
/* 245 */     this.field_149891_b[1] = p_149651_1_.func_94245_a("double_plant_sunflower_back");
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149666_a(Item p_149666_1_, CreativeTabs p_149666_2_, List<ItemStack> p_149666_3_) {
/* 250 */     for (byte b = 0; b < this.field_149893_M.length; b++) {
/* 251 */       p_149666_3_.add(new ItemStack(p_149666_1_, 1, b));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149643_k(World p_149643_1_, int p_149643_2_, int p_149643_3_, int p_149643_4_) {
/* 257 */     int i = p_149643_1_.func_72805_g(p_149643_2_, p_149643_3_, p_149643_4_);
/* 258 */     if (func_149887_c(i)) {
/* 259 */       return func_149890_d(p_149643_1_.func_72805_g(p_149643_2_, p_149643_3_ - 1, p_149643_4_));
/*     */     }
/* 261 */     return func_149890_d(i);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149851_a(World p_149851_1_, int p_149851_2_, int p_149851_3_, int p_149851_4_, boolean p_149851_5_) {
/* 266 */     int i = func_149885_e((IBlockAccess)p_149851_1_, p_149851_2_, p_149851_3_, p_149851_4_);
/* 267 */     if (i == 2 || i == 3) {
/* 268 */       return false;
/*     */     }
/* 270 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149852_a(World p_149852_1_, Random p_149852_2_, int p_149852_3_, int p_149852_4_, int p_149852_5_) {
/* 275 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149853_b(World p_149853_1_, Random p_149853_2_, int p_149853_3_, int p_149853_4_, int p_149853_5_) {
/* 280 */     int i = func_149885_e((IBlockAccess)p_149853_1_, p_149853_3_, p_149853_4_, p_149853_5_);
/* 281 */     func_149642_a(p_149853_1_, p_149853_3_, p_149853_4_, p_149853_5_, new ItemStack(this, 1, i));
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockDoublePlant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */