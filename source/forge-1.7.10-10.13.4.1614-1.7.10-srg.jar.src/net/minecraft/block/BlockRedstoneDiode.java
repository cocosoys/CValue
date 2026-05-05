/*     */ package net.minecraft.block;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.Direction;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public abstract class BlockRedstoneDiode extends BlockDirectional {
/*     */   protected final boolean field_149914_a;
/*     */   
/*     */   protected BlockRedstoneDiode(boolean p_i45400_1_) {
/*  19 */     super(Material.field_151594_q);
/*  20 */     this.field_149914_a = p_i45400_1_;
/*  21 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
/*     */   }
/*     */   private static final String __OBFID = "CL_00000226";
/*     */   
/*     */   public boolean func_149686_d() {
/*  26 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149742_c(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_) {
/*  31 */     if (!World.func_147466_a((IBlockAccess)p_149742_1_, p_149742_2_, p_149742_3_ - 1, p_149742_4_)) {
/*  32 */       return false;
/*     */     }
/*  34 */     return super.func_149742_c(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149718_j(World p_149718_1_, int p_149718_2_, int p_149718_3_, int p_149718_4_) {
/*  39 */     if (!World.func_147466_a((IBlockAccess)p_149718_1_, p_149718_2_, p_149718_3_ - 1, p_149718_4_)) {
/*  40 */       return false;
/*     */     }
/*  42 */     return super.func_149718_j(p_149718_1_, p_149718_2_, p_149718_3_, p_149718_4_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
/*  47 */     int i = p_149674_1_.func_72805_g(p_149674_2_, p_149674_3_, p_149674_4_);
/*     */     
/*  49 */     if (!func_149910_g((IBlockAccess)p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, i)) {
/*  50 */       boolean bool = func_149900_a(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, i);
/*  51 */       if (this.field_149914_a && !bool) {
/*  52 */         p_149674_1_.func_147465_d(p_149674_2_, p_149674_3_, p_149674_4_, func_149898_i(), i, 2);
/*  53 */       } else if (!this.field_149914_a) {
/*     */ 
/*     */ 
/*     */         
/*  57 */         p_149674_1_.func_147465_d(p_149674_2_, p_149674_3_, p_149674_4_, func_149906_e(), i, 2);
/*  58 */         if (!bool) {
/*  59 */           p_149674_1_.func_147454_a(p_149674_2_, p_149674_3_, p_149674_4_, func_149906_e(), func_149899_k(i), -1);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/*  68 */     if (p_149691_1_ == 0) {
/*  69 */       if (this.field_149914_a) {
/*  70 */         return Blocks.field_150429_aA.func_149733_h(p_149691_1_);
/*     */       }
/*  72 */       return Blocks.field_150437_az.func_149733_h(p_149691_1_);
/*     */     } 
/*  74 */     if (p_149691_1_ == 1) {
/*  75 */       return this.field_149761_L;
/*     */     }
/*     */     
/*  78 */     return Blocks.field_150334_T.func_149733_h(1);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_149646_a(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
/*  83 */     if (p_149646_5_ == 0 || p_149646_5_ == 1)
/*     */     {
/*  85 */       return false;
/*     */     }
/*  87 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/*  92 */     return 36;
/*     */   }
/*     */   
/*     */   protected boolean func_149905_c(int p_149905_1_) {
/*  96 */     return this.field_149914_a;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149748_c(IBlockAccess p_149748_1_, int p_149748_2_, int p_149748_3_, int p_149748_4_, int p_149748_5_) {
/* 101 */     return func_149709_b(p_149748_1_, p_149748_2_, p_149748_3_, p_149748_4_, p_149748_5_);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149709_b(IBlockAccess p_149709_1_, int p_149709_2_, int p_149709_3_, int p_149709_4_, int p_149709_5_) {
/* 107 */     int i = p_149709_1_.func_72805_g(p_149709_2_, p_149709_3_, p_149709_4_);
/* 108 */     if (!func_149905_c(i)) {
/* 109 */       return 0;
/*     */     }
/*     */     
/* 112 */     int j = func_149895_l(i);
/*     */     
/* 114 */     if (j == 0 && p_149709_5_ == 3) return func_149904_f(p_149709_1_, p_149709_2_, p_149709_3_, p_149709_4_, i); 
/* 115 */     if (j == 1 && p_149709_5_ == 4) return func_149904_f(p_149709_1_, p_149709_2_, p_149709_3_, p_149709_4_, i); 
/* 116 */     if (j == 2 && p_149709_5_ == 2) return func_149904_f(p_149709_1_, p_149709_2_, p_149709_3_, p_149709_4_, i); 
/* 117 */     if (j == 3 && p_149709_5_ == 5) return func_149904_f(p_149709_1_, p_149709_2_, p_149709_3_, p_149709_4_, i);
/*     */     
/* 119 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
/* 124 */     if (!func_149718_j(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_)) {
/* 125 */       func_149697_b(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, p_149695_1_.func_72805_g(p_149695_2_, p_149695_3_, p_149695_4_), 0);
/* 126 */       p_149695_1_.func_147468_f(p_149695_2_, p_149695_3_, p_149695_4_);
/* 127 */       p_149695_1_.func_147459_d(p_149695_2_ + 1, p_149695_3_, p_149695_4_, this);
/* 128 */       p_149695_1_.func_147459_d(p_149695_2_ - 1, p_149695_3_, p_149695_4_, this);
/* 129 */       p_149695_1_.func_147459_d(p_149695_2_, p_149695_3_, p_149695_4_ + 1, this);
/* 130 */       p_149695_1_.func_147459_d(p_149695_2_, p_149695_3_, p_149695_4_ - 1, this);
/* 131 */       p_149695_1_.func_147459_d(p_149695_2_, p_149695_3_ - 1, p_149695_4_, this);
/* 132 */       p_149695_1_.func_147459_d(p_149695_2_, p_149695_3_ + 1, p_149695_4_, this);
/*     */       
/*     */       return;
/*     */     } 
/* 136 */     func_149897_b(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, p_149695_5_);
/*     */   }
/*     */   
/*     */   protected void func_149897_b(World p_149897_1_, int p_149897_2_, int p_149897_3_, int p_149897_4_, Block p_149897_5_) {
/* 140 */     int i = p_149897_1_.func_72805_g(p_149897_2_, p_149897_3_, p_149897_4_);
/*     */     
/* 142 */     if (!func_149910_g((IBlockAccess)p_149897_1_, p_149897_2_, p_149897_3_, p_149897_4_, i)) {
/* 143 */       boolean bool = func_149900_a(p_149897_1_, p_149897_2_, p_149897_3_, p_149897_4_, i);
/* 144 */       if (((this.field_149914_a && !bool) || (!this.field_149914_a && bool)) && !p_149897_1_.func_147477_a(p_149897_2_, p_149897_3_, p_149897_4_, this)) {
/* 145 */         byte b = -1;
/*     */ 
/*     */         
/* 148 */         if (func_149912_i(p_149897_1_, p_149897_2_, p_149897_3_, p_149897_4_, i)) {
/* 149 */           b = -3;
/* 150 */         } else if (this.field_149914_a) {
/* 151 */           b = -2;
/*     */         } 
/*     */         
/* 154 */         p_149897_1_.func_147454_a(p_149897_2_, p_149897_3_, p_149897_4_, this, func_149901_b(i), b);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean func_149910_g(IBlockAccess p_149910_1_, int p_149910_2_, int p_149910_3_, int p_149910_4_, int p_149910_5_) {
/* 160 */     return false;
/*     */   }
/*     */   
/*     */   protected boolean func_149900_a(World p_149900_1_, int p_149900_2_, int p_149900_3_, int p_149900_4_, int p_149900_5_) {
/* 164 */     return (func_149903_h(p_149900_1_, p_149900_2_, p_149900_3_, p_149900_4_, p_149900_5_) > 0);
/*     */   }
/*     */   
/*     */   protected int func_149903_h(World p_149903_1_, int p_149903_2_, int p_149903_3_, int p_149903_4_, int p_149903_5_) {
/* 168 */     int i = func_149895_l(p_149903_5_);
/*     */     
/* 170 */     int j = p_149903_2_ + Direction.field_71583_a[i];
/* 171 */     int k = p_149903_4_ + Direction.field_71581_b[i];
/* 172 */     int m = p_149903_1_.func_72878_l(j, p_149903_3_, k, Direction.field_71582_c[i]);
/*     */     
/* 174 */     if (m >= 15) return m; 
/* 175 */     return Math.max(m, (p_149903_1_.func_147439_a(j, p_149903_3_, k) == Blocks.field_150488_af) ? p_149903_1_.func_72805_g(j, p_149903_3_, k) : 0);
/*     */   }
/*     */   
/*     */   protected int func_149902_h(IBlockAccess p_149902_1_, int p_149902_2_, int p_149902_3_, int p_149902_4_, int p_149902_5_) {
/* 179 */     int i = func_149895_l(p_149902_5_);
/*     */     
/* 181 */     switch (i) {
/*     */       case 0:
/*     */       case 2:
/* 184 */         return Math.max(func_149913_i(p_149902_1_, p_149902_2_ - 1, p_149902_3_, p_149902_4_, 4), func_149913_i(p_149902_1_, p_149902_2_ + 1, p_149902_3_, p_149902_4_, 5));
/*     */       case 1:
/*     */       case 3:
/* 187 */         return Math.max(func_149913_i(p_149902_1_, p_149902_2_, p_149902_3_, p_149902_4_ + 1, 3), func_149913_i(p_149902_1_, p_149902_2_, p_149902_3_, p_149902_4_ - 1, 2));
/*     */     } 
/*     */     
/* 190 */     return 0;
/*     */   }
/*     */   
/*     */   protected int func_149913_i(IBlockAccess p_149913_1_, int p_149913_2_, int p_149913_3_, int p_149913_4_, int p_149913_5_) {
/* 194 */     Block block = p_149913_1_.func_147439_a(p_149913_2_, p_149913_3_, p_149913_4_);
/* 195 */     if (func_149908_a(block)) {
/* 196 */       if (block == Blocks.field_150488_af) {
/* 197 */         return p_149913_1_.func_72805_g(p_149913_2_, p_149913_3_, p_149913_4_);
/*     */       }
/* 199 */       return p_149913_1_.func_72879_k(p_149913_2_, p_149913_3_, p_149913_4_, p_149913_5_);
/*     */     } 
/*     */ 
/*     */     
/* 203 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149744_f() {
/* 208 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149689_a(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_) {
/* 213 */     int i = ((MathHelper.func_76128_c((p_149689_5_.field_70177_z * 4.0F / 360.0F) + 0.5D) & 0x3) + 2) % 4;
/* 214 */     p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_, i, 3);
/*     */     
/* 216 */     boolean bool = func_149900_a(p_149689_1_, p_149689_2_, p_149689_3_, p_149689_4_, i);
/* 217 */     if (bool) {
/* 218 */       p_149689_1_.func_147464_a(p_149689_2_, p_149689_3_, p_149689_4_, this, 1);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149726_b(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {
/* 224 */     func_149911_e(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
/*     */   }
/*     */   
/*     */   protected void func_149911_e(World p_149911_1_, int p_149911_2_, int p_149911_3_, int p_149911_4_) {
/* 228 */     int i = func_149895_l(p_149911_1_.func_72805_g(p_149911_2_, p_149911_3_, p_149911_4_));
/* 229 */     if (i == 1) {
/* 230 */       p_149911_1_.func_147460_e(p_149911_2_ + 1, p_149911_3_, p_149911_4_, this);
/* 231 */       p_149911_1_.func_147441_b(p_149911_2_ + 1, p_149911_3_, p_149911_4_, this, 4);
/*     */     } 
/* 233 */     if (i == 3) {
/* 234 */       p_149911_1_.func_147460_e(p_149911_2_ - 1, p_149911_3_, p_149911_4_, this);
/* 235 */       p_149911_1_.func_147441_b(p_149911_2_ - 1, p_149911_3_, p_149911_4_, this, 5);
/*     */     } 
/* 237 */     if (i == 2) {
/* 238 */       p_149911_1_.func_147460_e(p_149911_2_, p_149911_3_, p_149911_4_ + 1, this);
/* 239 */       p_149911_1_.func_147441_b(p_149911_2_, p_149911_3_, p_149911_4_ + 1, this, 2);
/*     */     } 
/* 241 */     if (i == 0) {
/* 242 */       p_149911_1_.func_147460_e(p_149911_2_, p_149911_3_, p_149911_4_ - 1, this);
/* 243 */       p_149911_1_.func_147441_b(p_149911_2_, p_149911_3_, p_149911_4_ - 1, this, 3);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149664_b(World p_149664_1_, int p_149664_2_, int p_149664_3_, int p_149664_4_, int p_149664_5_) {
/* 249 */     if (this.field_149914_a) {
/* 250 */       p_149664_1_.func_147459_d(p_149664_2_ + 1, p_149664_3_, p_149664_4_, this);
/* 251 */       p_149664_1_.func_147459_d(p_149664_2_ - 1, p_149664_3_, p_149664_4_, this);
/* 252 */       p_149664_1_.func_147459_d(p_149664_2_, p_149664_3_, p_149664_4_ + 1, this);
/* 253 */       p_149664_1_.func_147459_d(p_149664_2_, p_149664_3_, p_149664_4_ - 1, this);
/* 254 */       p_149664_1_.func_147459_d(p_149664_2_, p_149664_3_ - 1, p_149664_4_, this);
/* 255 */       p_149664_1_.func_147459_d(p_149664_2_, p_149664_3_ + 1, p_149664_4_, this);
/*     */     } 
/* 257 */     super.func_149664_b(p_149664_1_, p_149664_2_, p_149664_3_, p_149664_4_, p_149664_5_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/* 262 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean func_149908_a(Block p_149908_1_) {
/* 272 */     return p_149908_1_.func_149744_f();
/*     */   }
/*     */   
/*     */   protected int func_149904_f(IBlockAccess p_149904_1_, int p_149904_2_, int p_149904_3_, int p_149904_4_, int p_149904_5_) {
/* 276 */     return 15;
/*     */   }
/*     */   
/*     */   public static boolean func_149909_d(Block p_149909_0_) {
/* 280 */     return (Blocks.field_150413_aR.func_149907_e(p_149909_0_) || Blocks.field_150441_bU.func_149907_e(p_149909_0_));
/*     */   }
/*     */   
/*     */   public boolean func_149907_e(Block p_149907_1_) {
/* 284 */     return (p_149907_1_ == func_149906_e() || p_149907_1_ == func_149898_i());
/*     */   }
/*     */   
/*     */   public boolean func_149912_i(World p_149912_1_, int p_149912_2_, int p_149912_3_, int p_149912_4_, int p_149912_5_) {
/* 288 */     int i = func_149895_l(p_149912_5_);
/* 289 */     if (func_149909_d(p_149912_1_.func_147439_a(p_149912_2_ - Direction.field_71583_a[i], p_149912_3_, p_149912_4_ - Direction.field_71581_b[i]))) {
/* 290 */       int j = p_149912_1_.func_72805_g(p_149912_2_ - Direction.field_71583_a[i], p_149912_3_, p_149912_4_ - Direction.field_71581_b[i]);
/* 291 */       int k = func_149895_l(j);
/* 292 */       return (k != i);
/*     */     } 
/* 294 */     return false;
/*     */   }
/*     */   
/*     */   protected int func_149899_k(int p_149899_1_) {
/* 298 */     return func_149901_b(p_149899_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   protected abstract int func_149901_b(int paramInt);
/*     */   
/*     */   protected abstract BlockRedstoneDiode func_149906_e();
/*     */   
/*     */   protected abstract BlockRedstoneDiode func_149898_i();
/*     */   
/*     */   public boolean func_149667_c(Block p_149667_1_) {
/* 309 */     return func_149907_e(p_149667_1_);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockRedstoneDiode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */