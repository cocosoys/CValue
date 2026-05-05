/*     */ package net.minecraft.block;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.tileentity.TileEntityPiston;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.Facing;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockPistonBase
/*     */   extends Block
/*     */ {
/*     */   private final boolean field_150082_a;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon field_150081_b;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon field_150083_M;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon field_150084_N;
/*     */   private static final String __OBFID = "CL_00000366";
/*     */   
/*     */   public BlockPistonBase(boolean p_i45443_1_) {
/*  38 */     super(Material.field_76233_E);
/*  39 */     this.field_150082_a = p_i45443_1_;
/*  40 */     func_149672_a(field_149780_i);
/*  41 */     func_149711_c(0.5F);
/*  42 */     func_149647_a(CreativeTabs.field_78028_d);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_150073_e() {
/*  46 */     return this.field_150084_N;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_150070_b(float p_150070_1_, float p_150070_2_, float p_150070_3_, float p_150070_4_, float p_150070_5_, float p_150070_6_) {
/*  50 */     func_149676_a(p_150070_1_, p_150070_2_, p_150070_3_, p_150070_4_, p_150070_5_, p_150070_6_);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/*  55 */     int i = func_150076_b(p_149691_2_);
/*     */     
/*  57 */     if (i > 5) {
/*  58 */       return this.field_150084_N;
/*     */     }
/*     */     
/*  61 */     if (p_149691_1_ == i) {
/*     */ 
/*     */       
/*  64 */       if (func_150075_c(p_149691_2_) || this.field_149759_B > 0.0D || this.field_149760_C > 0.0D || this.field_149754_D > 0.0D || this.field_149755_E < 1.0D || this.field_149756_F < 1.0D || this.field_149757_G < 1.0D) {
/*  65 */         return this.field_150081_b;
/*     */       }
/*  67 */       return this.field_150084_N;
/*     */     } 
/*  69 */     if (p_149691_1_ == Facing.field_71588_a[i]) {
/*  70 */       return this.field_150083_M;
/*     */     }
/*     */     
/*  73 */     return this.field_149761_L;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static IIcon func_150074_e(String p_150074_0_) {
/*  77 */     if (p_150074_0_ == "piston_side") return Blocks.field_150331_J.field_149761_L; 
/*  78 */     if (p_150074_0_ == "piston_top_normal") return Blocks.field_150331_J.field_150084_N; 
/*  79 */     if (p_150074_0_ == "piston_top_sticky") return Blocks.field_150320_F.field_150084_N; 
/*  80 */     if (p_150074_0_ == "piston_inner") return Blocks.field_150331_J.field_150081_b;
/*     */     
/*  82 */     return null;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister p_149651_1_) {
/*  87 */     this.field_149761_L = p_149651_1_.func_94245_a("piston_side");
/*  88 */     this.field_150084_N = p_149651_1_.func_94245_a(this.field_150082_a ? "piston_top_sticky" : "piston_top_normal");
/*  89 */     this.field_150081_b = p_149651_1_.func_94245_a("piston_inner");
/*  90 */     this.field_150083_M = p_149651_1_.func_94245_a("piston_bottom");
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/*  95 */     return 16;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/* 100 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
/* 105 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149689_a(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_) {
/* 110 */     int i = func_150071_a(p_149689_1_, p_149689_2_, p_149689_3_, p_149689_4_, p_149689_5_);
/* 111 */     p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_, i, 2);
/* 112 */     if (!p_149689_1_.field_72995_K) {
/* 113 */       func_150078_e(p_149689_1_, p_149689_2_, p_149689_3_, p_149689_4_);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
/* 119 */     if (!p_149695_1_.field_72995_K) {
/* 120 */       func_150078_e(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149726_b(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {
/* 126 */     if (!p_149726_1_.field_72995_K && p_149726_1_.func_147438_o(p_149726_2_, p_149726_3_, p_149726_4_) == null) {
/* 127 */       func_150078_e(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
/*     */     }
/*     */   }
/*     */   
/*     */   private void func_150078_e(World p_150078_1_, int p_150078_2_, int p_150078_3_, int p_150078_4_) {
/* 132 */     int i = p_150078_1_.func_72805_g(p_150078_2_, p_150078_3_, p_150078_4_);
/* 133 */     int j = func_150076_b(i);
/*     */     
/* 135 */     if (j == 7) {
/*     */       return;
/*     */     }
/*     */     
/* 139 */     boolean bool = func_150072_a(p_150078_1_, p_150078_2_, p_150078_3_, p_150078_4_, j);
/*     */     
/* 141 */     if (bool && !func_150075_c(i)) {
/* 142 */       if (func_150077_h(p_150078_1_, p_150078_2_, p_150078_3_, p_150078_4_, j)) {
/* 143 */         p_150078_1_.func_147452_c(p_150078_2_, p_150078_3_, p_150078_4_, this, 0, j);
/*     */       }
/* 145 */     } else if (!bool && func_150075_c(i)) {
/* 146 */       p_150078_1_.func_72921_c(p_150078_2_, p_150078_3_, p_150078_4_, j, 2);
/* 147 */       p_150078_1_.func_147452_c(p_150078_2_, p_150078_3_, p_150078_4_, this, 1, j);
/*     */     } 
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
/*     */   private boolean func_150072_a(World p_150072_1_, int p_150072_2_, int p_150072_3_, int p_150072_4_, int p_150072_5_) {
/* 164 */     if (p_150072_5_ != 0 && p_150072_1_.func_94574_k(p_150072_2_, p_150072_3_ - 1, p_150072_4_, 0)) return true; 
/* 165 */     if (p_150072_5_ != 1 && p_150072_1_.func_94574_k(p_150072_2_, p_150072_3_ + 1, p_150072_4_, 1)) return true; 
/* 166 */     if (p_150072_5_ != 2 && p_150072_1_.func_94574_k(p_150072_2_, p_150072_3_, p_150072_4_ - 1, 2)) return true; 
/* 167 */     if (p_150072_5_ != 3 && p_150072_1_.func_94574_k(p_150072_2_, p_150072_3_, p_150072_4_ + 1, 3)) return true; 
/* 168 */     if (p_150072_5_ != 5 && p_150072_1_.func_94574_k(p_150072_2_ + 1, p_150072_3_, p_150072_4_, 5)) return true; 
/* 169 */     if (p_150072_5_ != 4 && p_150072_1_.func_94574_k(p_150072_2_ - 1, p_150072_3_, p_150072_4_, 4)) return true;
/*     */ 
/*     */     
/* 172 */     if (p_150072_1_.func_94574_k(p_150072_2_, p_150072_3_, p_150072_4_, 0)) return true; 
/* 173 */     if (p_150072_1_.func_94574_k(p_150072_2_, p_150072_3_ + 2, p_150072_4_, 1)) return true; 
/* 174 */     if (p_150072_1_.func_94574_k(p_150072_2_, p_150072_3_ + 1, p_150072_4_ - 1, 2)) return true; 
/* 175 */     if (p_150072_1_.func_94574_k(p_150072_2_, p_150072_3_ + 1, p_150072_4_ + 1, 3)) return true; 
/* 176 */     if (p_150072_1_.func_94574_k(p_150072_2_ - 1, p_150072_3_ + 1, p_150072_4_, 4)) return true; 
/* 177 */     if (p_150072_1_.func_94574_k(p_150072_2_ + 1, p_150072_3_ + 1, p_150072_4_, 5)) return true;
/*     */     
/* 179 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149696_a(World p_149696_1_, int p_149696_2_, int p_149696_3_, int p_149696_4_, int p_149696_5_, int p_149696_6_) {
/* 185 */     if (!p_149696_1_.field_72995_K) {
/* 186 */       boolean bool = func_150072_a(p_149696_1_, p_149696_2_, p_149696_3_, p_149696_4_, p_149696_6_);
/*     */       
/* 188 */       if (bool && p_149696_5_ == 1) {
/* 189 */         p_149696_1_.func_72921_c(p_149696_2_, p_149696_3_, p_149696_4_, p_149696_6_ | 0x8, 2);
/* 190 */         return false;
/* 191 */       }  if (!bool && p_149696_5_ == 0) {
/* 192 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 196 */     if (p_149696_5_ == 0) {
/* 197 */       if (func_150079_i(p_149696_1_, p_149696_2_, p_149696_3_, p_149696_4_, p_149696_6_)) {
/* 198 */         p_149696_1_.func_72921_c(p_149696_2_, p_149696_3_, p_149696_4_, p_149696_6_ | 0x8, 2);
/* 199 */         p_149696_1_.func_72908_a(p_149696_2_ + 0.5D, p_149696_3_ + 0.5D, p_149696_4_ + 0.5D, "tile.piston.out", 0.5F, p_149696_1_.field_73012_v.nextFloat() * 0.25F + 0.6F);
/*     */       } else {
/* 201 */         return false;
/*     */       } 
/* 203 */     } else if (p_149696_5_ == 1) {
/*     */       
/* 205 */       TileEntity tileEntity = p_149696_1_.func_147438_o(p_149696_2_ + Facing.field_71586_b[p_149696_6_], p_149696_3_ + Facing.field_71587_c[p_149696_6_], p_149696_4_ + Facing.field_71585_d[p_149696_6_]);
/* 206 */       if (tileEntity instanceof TileEntityPiston) {
/* 207 */         ((TileEntityPiston)tileEntity).func_145866_f();
/*     */       }
/*     */       
/* 210 */       p_149696_1_.func_147465_d(p_149696_2_, p_149696_3_, p_149696_4_, Blocks.field_150326_M, p_149696_6_, 3);
/* 211 */       p_149696_1_.func_147455_a(p_149696_2_, p_149696_3_, p_149696_4_, BlockPistonMoving.func_149962_a(this, p_149696_6_, p_149696_6_, false, true));
/*     */ 
/*     */       
/* 214 */       if (this.field_150082_a) {
/* 215 */         int i = p_149696_2_ + Facing.field_71586_b[p_149696_6_] * 2;
/* 216 */         int j = p_149696_3_ + Facing.field_71587_c[p_149696_6_] * 2;
/* 217 */         int k = p_149696_4_ + Facing.field_71585_d[p_149696_6_] * 2;
/* 218 */         Block block = p_149696_1_.func_147439_a(i, j, k);
/* 219 */         int m = p_149696_1_.func_72805_g(i, j, k);
/* 220 */         boolean bool = false;
/*     */         
/* 222 */         if (block == Blocks.field_150326_M) {
/*     */ 
/*     */           
/* 225 */           TileEntity tileEntity1 = p_149696_1_.func_147438_o(i, j, k);
/* 226 */           if (tileEntity1 instanceof TileEntityPiston) {
/* 227 */             TileEntityPiston tileEntityPiston = (TileEntityPiston)tileEntity1;
/*     */             
/* 229 */             if (tileEntityPiston.func_145864_c() == p_149696_6_ && tileEntityPiston.func_145868_b()) {
/*     */               
/* 231 */               tileEntityPiston.func_145866_f();
/* 232 */               block = tileEntityPiston.func_145861_a();
/* 233 */               m = tileEntityPiston.func_145832_p();
/* 234 */               bool = true;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/* 239 */         if (!bool && block.func_149688_o() != Material.field_151579_a && func_150080_a(block, p_149696_1_, i, j, k, false) && (block.func_149656_h() == 0 || block == Blocks.field_150331_J || block == Blocks.field_150320_F)) {
/*     */           
/* 241 */           p_149696_2_ += Facing.field_71586_b[p_149696_6_];
/* 242 */           p_149696_3_ += Facing.field_71587_c[p_149696_6_];
/* 243 */           p_149696_4_ += Facing.field_71585_d[p_149696_6_];
/*     */           
/* 245 */           p_149696_1_.func_147465_d(p_149696_2_, p_149696_3_, p_149696_4_, Blocks.field_150326_M, m, 3);
/* 246 */           p_149696_1_.func_147455_a(p_149696_2_, p_149696_3_, p_149696_4_, BlockPistonMoving.func_149962_a(block, m, p_149696_6_, false, false));
/*     */           
/* 248 */           p_149696_1_.func_147468_f(i, j, k);
/* 249 */         } else if (!bool) {
/* 250 */           p_149696_1_.func_147468_f(p_149696_2_ + Facing.field_71586_b[p_149696_6_], p_149696_3_ + Facing.field_71587_c[p_149696_6_], p_149696_4_ + Facing.field_71585_d[p_149696_6_]);
/*     */         } 
/*     */       } else {
/* 253 */         p_149696_1_.func_147468_f(p_149696_2_ + Facing.field_71586_b[p_149696_6_], p_149696_3_ + Facing.field_71587_c[p_149696_6_], p_149696_4_ + Facing.field_71585_d[p_149696_6_]);
/*     */       } 
/*     */       
/* 256 */       p_149696_1_.func_72908_a(p_149696_2_ + 0.5D, p_149696_3_ + 0.5D, p_149696_4_ + 0.5D, "tile.piston.in", 0.5F, p_149696_1_.field_73012_v.nextFloat() * 0.15F + 0.6F);
/*     */     } 
/* 258 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
/* 263 */     int i = p_149719_1_.func_72805_g(p_149719_2_, p_149719_3_, p_149719_4_);
/*     */     
/* 265 */     if (func_150075_c(i)) {
/* 266 */       float f = 0.25F;
/* 267 */       switch (func_150076_b(i)) {
/*     */         case 0:
/* 269 */           func_149676_a(0.0F, 0.25F, 0.0F, 1.0F, 1.0F, 1.0F);
/*     */           break;
/*     */         case 1:
/* 272 */           func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
/*     */           break;
/*     */         case 2:
/* 275 */           func_149676_a(0.0F, 0.0F, 0.25F, 1.0F, 1.0F, 1.0F);
/*     */           break;
/*     */         case 3:
/* 278 */           func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.75F);
/*     */           break;
/*     */         case 4:
/* 281 */           func_149676_a(0.25F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*     */           break;
/*     */         case 5:
/* 284 */           func_149676_a(0.0F, 0.0F, 0.0F, 0.75F, 1.0F, 1.0F);
/*     */           break;
/*     */       } 
/*     */     } else {
/* 288 */       func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149683_g() {
/* 294 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149743_a(World p_149743_1_, int p_149743_2_, int p_149743_3_, int p_149743_4_, AxisAlignedBB p_149743_5_, List p_149743_6_, Entity p_149743_7_) {
/* 299 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/* 300 */     super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
/*     */   }
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
/* 305 */     func_149719_a((IBlockAccess)p_149668_1_, p_149668_2_, p_149668_3_, p_149668_4_);
/* 306 */     return super.func_149668_a(p_149668_1_, p_149668_2_, p_149668_3_, p_149668_4_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/* 311 */     return false;
/*     */   }
/*     */   
/*     */   public static int func_150076_b(int p_150076_0_) {
/* 315 */     return p_150076_0_ & 0x7;
/*     */   }
/*     */   
/*     */   public static boolean func_150075_c(int p_150075_0_) {
/* 319 */     return ((p_150075_0_ & 0x8) != 0);
/*     */   }
/*     */   
/*     */   public static int func_150071_a(World p_150071_0_, int p_150071_1_, int p_150071_2_, int p_150071_3_, EntityLivingBase p_150071_4_) {
/* 323 */     if (MathHelper.func_76135_e((float)p_150071_4_.field_70165_t - p_150071_1_) < 2.0F && MathHelper.func_76135_e((float)p_150071_4_.field_70161_v - p_150071_3_) < 2.0F) {
/*     */       
/* 325 */       double d = p_150071_4_.field_70163_u + 1.82D - p_150071_4_.field_70129_M;
/* 326 */       if (d - p_150071_2_ > 2.0D) {
/* 327 */         return 1;
/*     */       }
/*     */       
/* 330 */       if (p_150071_2_ - d > 0.0D) {
/* 331 */         return 0;
/*     */       }
/*     */     } 
/*     */     
/* 335 */     int i = MathHelper.func_76128_c((p_150071_4_.field_70177_z * 4.0F / 360.0F) + 0.5D) & 0x3;
/* 336 */     if (i == 0) return 2; 
/* 337 */     if (i == 1) return 5; 
/* 338 */     if (i == 2) return 3; 
/* 339 */     if (i == 3) return 4; 
/* 340 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean func_150080_a(Block p_150080_0_, World p_150080_1_, int p_150080_2_, int p_150080_3_, int p_150080_4_, boolean p_150080_5_) {
/* 345 */     if (p_150080_0_ == Blocks.field_150343_Z) {
/* 346 */       return false;
/*     */     }
/*     */     
/* 349 */     if (p_150080_0_ == Blocks.field_150331_J || p_150080_0_ == Blocks.field_150320_F) {
/*     */       
/* 351 */       if (func_150075_c(p_150080_1_.func_72805_g(p_150080_2_, p_150080_3_, p_150080_4_))) {
/* 352 */         return false;
/*     */       }
/*     */     } else {
/* 355 */       if (p_150080_0_.func_149712_f(p_150080_1_, p_150080_2_, p_150080_3_, p_150080_4_) == -1.0F) {
/* 356 */         return false;
/*     */       }
/*     */       
/* 359 */       if (p_150080_0_.func_149656_h() == 2) {
/* 360 */         return false;
/*     */       }
/*     */       
/* 363 */       if (p_150080_0_.func_149656_h() == 1) {
/* 364 */         if (!p_150080_5_) {
/* 365 */           return false;
/*     */         }
/* 367 */         return true;
/*     */       } 
/*     */     } 
/*     */     
/* 371 */     if (p_150080_0_ instanceof ITileEntityProvider)
/*     */     {
/* 373 */       return false;
/*     */     }
/*     */     
/* 376 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean func_150077_h(World p_150077_0_, int p_150077_1_, int p_150077_2_, int p_150077_3_, int p_150077_4_) {
/* 381 */     int i = p_150077_1_ + Facing.field_71586_b[p_150077_4_];
/* 382 */     int j = p_150077_2_ + Facing.field_71587_c[p_150077_4_];
/* 383 */     int k = p_150077_3_ + Facing.field_71585_d[p_150077_4_];
/*     */     
/* 385 */     for (byte b = 0; b < 13; b++) {
/*     */       
/* 387 */       if (j <= 0 || j >= 255)
/*     */       {
/* 389 */         return false;
/*     */       }
/*     */       
/* 392 */       Block block = p_150077_0_.func_147439_a(i, j, k);
/* 393 */       if (block.func_149688_o() == Material.field_151579_a) {
/*     */         break;
/*     */       }
/*     */       
/* 397 */       if (!func_150080_a(block, p_150077_0_, i, j, k, true)) {
/* 398 */         return false;
/*     */       }
/*     */       
/* 401 */       if (block.func_149656_h() == 1) {
/*     */         break;
/*     */       }
/*     */       
/* 405 */       if (b == 12)
/*     */       {
/* 407 */         return false;
/*     */       }
/*     */       
/* 410 */       i += Facing.field_71586_b[p_150077_4_];
/* 411 */       j += Facing.field_71587_c[p_150077_4_];
/* 412 */       k += Facing.field_71585_d[p_150077_4_];
/*     */     } 
/*     */     
/* 415 */     return true;
/*     */   }
/*     */   
/*     */   private boolean func_150079_i(World p_150079_1_, int p_150079_2_, int p_150079_3_, int p_150079_4_, int p_150079_5_) {
/* 419 */     int i = p_150079_2_ + Facing.field_71586_b[p_150079_5_];
/* 420 */     int j = p_150079_3_ + Facing.field_71587_c[p_150079_5_];
/* 421 */     int k = p_150079_4_ + Facing.field_71585_d[p_150079_5_];
/*     */     int m;
/* 423 */     for (m = 0; m < 13; m++) {
/* 424 */       if (j <= 0 || j >= 255)
/*     */       {
/* 426 */         return false;
/*     */       }
/*     */       
/* 429 */       Block block = p_150079_1_.func_147439_a(i, j, k);
/* 430 */       if (block.func_149688_o() == Material.field_151579_a) {
/*     */         break;
/*     */       }
/*     */       
/* 434 */       if (!func_150080_a(block, p_150079_1_, i, j, k, true)) {
/* 435 */         return false;
/*     */       }
/*     */       
/* 438 */       if (block.func_149656_h() == 1) {
/*     */         
/* 440 */         block.func_149697_b(p_150079_1_, i, j, k, p_150079_1_.func_72805_g(i, j, k), 0);
/*     */         
/* 442 */         p_150079_1_.func_147468_f(i, j, k);
/*     */         
/*     */         break;
/*     */       } 
/* 446 */       if (m == 12)
/*     */       {
/* 448 */         return false;
/*     */       }
/*     */       
/* 451 */       i += Facing.field_71586_b[p_150079_5_];
/* 452 */       j += Facing.field_71587_c[p_150079_5_];
/* 453 */       k += Facing.field_71585_d[p_150079_5_];
/*     */     } 
/*     */     
/* 456 */     m = i;
/* 457 */     int n = j;
/* 458 */     int i1 = k;
/* 459 */     byte b = 0;
/* 460 */     Block[] arrayOfBlock = new Block[13];
/*     */     
/* 462 */     while (i != p_150079_2_ || j != p_150079_3_ || k != p_150079_4_) {
/* 463 */       int i2 = i - Facing.field_71586_b[p_150079_5_];
/* 464 */       int i3 = j - Facing.field_71587_c[p_150079_5_];
/* 465 */       int i4 = k - Facing.field_71585_d[p_150079_5_];
/*     */       
/* 467 */       Block block = p_150079_1_.func_147439_a(i2, i3, i4);
/* 468 */       int i5 = p_150079_1_.func_72805_g(i2, i3, i4);
/*     */       
/* 470 */       if (block == this && i2 == p_150079_2_ && i3 == p_150079_3_ && i4 == p_150079_4_) {
/* 471 */         p_150079_1_.func_147465_d(i, j, k, Blocks.field_150326_M, p_150079_5_ | (this.field_150082_a ? 8 : 0), 4);
/* 472 */         p_150079_1_.func_147455_a(i, j, k, BlockPistonMoving.func_149962_a(Blocks.field_150332_K, p_150079_5_ | (this.field_150082_a ? 8 : 0), p_150079_5_, true, false));
/*     */       } else {
/* 474 */         p_150079_1_.func_147465_d(i, j, k, Blocks.field_150326_M, i5, 4);
/* 475 */         p_150079_1_.func_147455_a(i, j, k, BlockPistonMoving.func_149962_a(block, i5, p_150079_5_, true, false));
/*     */       } 
/* 477 */       arrayOfBlock[b++] = block;
/*     */       
/* 479 */       i = i2;
/* 480 */       j = i3;
/* 481 */       k = i4;
/*     */     } 
/*     */     
/* 484 */     i = m;
/* 485 */     j = n;
/* 486 */     k = i1;
/* 487 */     b = 0;
/*     */     
/* 489 */     while (i != p_150079_2_ || j != p_150079_3_ || k != p_150079_4_) {
/* 490 */       int i2 = i - Facing.field_71586_b[p_150079_5_];
/* 491 */       int i3 = j - Facing.field_71587_c[p_150079_5_];
/* 492 */       int i4 = k - Facing.field_71585_d[p_150079_5_];
/*     */       
/* 494 */       p_150079_1_.func_147459_d(i2, i3, i4, arrayOfBlock[b++]);
/*     */       
/* 496 */       i = i2;
/* 497 */       j = i3;
/* 498 */       k = i4;
/*     */     } 
/*     */     
/* 501 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockPistonBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */