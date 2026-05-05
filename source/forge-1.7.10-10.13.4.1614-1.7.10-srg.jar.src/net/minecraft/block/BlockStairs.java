/*     */ package net.minecraft.block;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.Explosion;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockStairs extends Block {
/*  19 */   private static final int[][] field_150150_a = new int[][] { { 2, 6 }, { 3, 7 }, { 2, 3 }, { 6, 7 }, { 0, 4 }, { 1, 5 }, { 0, 1 }, { 4, 5 } };
/*     */ 
/*     */   
/*     */   private final Block field_150149_b;
/*     */ 
/*     */   
/*     */   private final int field_150151_M;
/*     */ 
/*     */   
/*     */   private boolean field_150152_N;
/*     */ 
/*     */   
/*     */   private int field_150153_O;
/*     */ 
/*     */   
/*     */   private static final String __OBFID = "CL_00000314";
/*     */ 
/*     */   
/*     */   protected BlockStairs(Block p_i45428_1_, int p_i45428_2_) {
/*  38 */     super(p_i45428_1_.field_149764_J);
/*  39 */     this.field_150149_b = p_i45428_1_;
/*  40 */     this.field_150151_M = p_i45428_2_;
/*  41 */     func_149711_c(p_i45428_1_.field_149782_v);
/*  42 */     func_149752_b(p_i45428_1_.field_149781_w / 3.0F);
/*  43 */     func_149672_a(p_i45428_1_.field_149762_H);
/*  44 */     func_149713_g(255);
/*  45 */     func_149647_a(CreativeTabs.field_78030_b);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
/*  50 */     if (this.field_150152_N) {
/*  51 */       func_149676_a(0.5F * (this.field_150153_O % 2), 0.5F * (this.field_150153_O / 2 % 2), 0.5F * (this.field_150153_O / 4 % 2), 0.5F + 0.5F * (this.field_150153_O % 2), 0.5F + 0.5F * (this.field_150153_O / 2 % 2), 0.5F + 0.5F * (this.field_150153_O / 4 % 2));
/*     */     } else {
/*  53 */       func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  59 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/*  64 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/*  69 */     return 10;
/*     */   }
/*     */   
/*     */   public void func_150147_e(IBlockAccess p_150147_1_, int p_150147_2_, int p_150147_3_, int p_150147_4_) {
/*  73 */     int i = p_150147_1_.func_72805_g(p_150147_2_, p_150147_3_, p_150147_4_);
/*     */     
/*  75 */     if ((i & 0x4) != 0) {
/*  76 */       func_149676_a(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
/*     */     } else {
/*  78 */       func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static boolean func_150148_a(Block p_150148_0_) {
/*  83 */     return p_150148_0_ instanceof BlockStairs;
/*     */   }
/*     */   
/*     */   private boolean func_150146_f(IBlockAccess p_150146_1_, int p_150146_2_, int p_150146_3_, int p_150146_4_, int p_150146_5_) {
/*  87 */     Block block = p_150146_1_.func_147439_a(p_150146_2_, p_150146_3_, p_150146_4_);
/*  88 */     if (func_150148_a(block) && p_150146_1_.func_72805_g(p_150146_2_, p_150146_3_, p_150146_4_) == p_150146_5_) {
/*  89 */       return true;
/*     */     }
/*     */     
/*  92 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_150145_f(IBlockAccess p_150145_1_, int p_150145_2_, int p_150145_3_, int p_150145_4_) {
/*  96 */     int i = p_150145_1_.func_72805_g(p_150145_2_, p_150145_3_, p_150145_4_);
/*  97 */     int j = i & 0x3;
/*     */     
/*  99 */     float f1 = 0.5F;
/* 100 */     float f2 = 1.0F;
/*     */     
/* 102 */     if ((i & 0x4) != 0) {
/* 103 */       f1 = 0.0F;
/* 104 */       f2 = 0.5F;
/*     */     } 
/*     */     
/* 107 */     float f3 = 0.0F;
/* 108 */     float f4 = 1.0F;
/* 109 */     float f5 = 0.0F;
/* 110 */     float f6 = 0.5F;
/*     */     
/* 112 */     boolean bool = true;
/*     */     
/* 114 */     if (j == 0) {
/* 115 */       f3 = 0.5F;
/* 116 */       f6 = 1.0F;
/*     */       
/* 118 */       Block block = p_150145_1_.func_147439_a(p_150145_2_ + 1, p_150145_3_, p_150145_4_);
/* 119 */       int k = p_150145_1_.func_72805_g(p_150145_2_ + 1, p_150145_3_, p_150145_4_);
/* 120 */       if (func_150148_a(block) && (i & 0x4) == (k & 0x4)) {
/* 121 */         int m = k & 0x3;
/* 122 */         if (m == 3 && !func_150146_f(p_150145_1_, p_150145_2_, p_150145_3_, p_150145_4_ + 1, i)) {
/* 123 */           f6 = 0.5F;
/* 124 */           bool = false;
/* 125 */         } else if (m == 2 && !func_150146_f(p_150145_1_, p_150145_2_, p_150145_3_, p_150145_4_ - 1, i)) {
/* 126 */           f5 = 0.5F;
/* 127 */           bool = false;
/*     */         } 
/*     */       } 
/* 130 */     } else if (j == 1) {
/* 131 */       f4 = 0.5F;
/* 132 */       f6 = 1.0F;
/*     */       
/* 134 */       Block block = p_150145_1_.func_147439_a(p_150145_2_ - 1, p_150145_3_, p_150145_4_);
/* 135 */       int k = p_150145_1_.func_72805_g(p_150145_2_ - 1, p_150145_3_, p_150145_4_);
/* 136 */       if (func_150148_a(block) && (i & 0x4) == (k & 0x4)) {
/* 137 */         int m = k & 0x3;
/* 138 */         if (m == 3 && !func_150146_f(p_150145_1_, p_150145_2_, p_150145_3_, p_150145_4_ + 1, i)) {
/* 139 */           f6 = 0.5F;
/* 140 */           bool = false;
/* 141 */         } else if (m == 2 && !func_150146_f(p_150145_1_, p_150145_2_, p_150145_3_, p_150145_4_ - 1, i)) {
/* 142 */           f5 = 0.5F;
/* 143 */           bool = false;
/*     */         } 
/*     */       } 
/* 146 */     } else if (j == 2) {
/* 147 */       f5 = 0.5F;
/* 148 */       f6 = 1.0F;
/*     */       
/* 150 */       Block block = p_150145_1_.func_147439_a(p_150145_2_, p_150145_3_, p_150145_4_ + 1);
/* 151 */       int k = p_150145_1_.func_72805_g(p_150145_2_, p_150145_3_, p_150145_4_ + 1);
/* 152 */       if (func_150148_a(block) && (i & 0x4) == (k & 0x4)) {
/* 153 */         int m = k & 0x3;
/* 154 */         if (m == 1 && !func_150146_f(p_150145_1_, p_150145_2_ + 1, p_150145_3_, p_150145_4_, i)) {
/* 155 */           f4 = 0.5F;
/* 156 */           bool = false;
/* 157 */         } else if (m == 0 && !func_150146_f(p_150145_1_, p_150145_2_ - 1, p_150145_3_, p_150145_4_, i)) {
/* 158 */           f3 = 0.5F;
/* 159 */           bool = false;
/*     */         } 
/*     */       } 
/* 162 */     } else if (j == 3) {
/* 163 */       Block block = p_150145_1_.func_147439_a(p_150145_2_, p_150145_3_, p_150145_4_ - 1);
/* 164 */       int k = p_150145_1_.func_72805_g(p_150145_2_, p_150145_3_, p_150145_4_ - 1);
/* 165 */       if (func_150148_a(block) && (i & 0x4) == (k & 0x4)) {
/* 166 */         int m = k & 0x3;
/* 167 */         if (m == 1 && !func_150146_f(p_150145_1_, p_150145_2_ + 1, p_150145_3_, p_150145_4_, i)) {
/* 168 */           f4 = 0.5F;
/* 169 */           bool = false;
/* 170 */         } else if (m == 0 && !func_150146_f(p_150145_1_, p_150145_2_ - 1, p_150145_3_, p_150145_4_, i)) {
/* 171 */           f3 = 0.5F;
/* 172 */           bool = false;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 177 */     func_149676_a(f3, f1, f5, f4, f2, f6);
/* 178 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_150144_g(IBlockAccess p_150144_1_, int p_150144_2_, int p_150144_3_, int p_150144_4_) {
/* 186 */     int i = p_150144_1_.func_72805_g(p_150144_2_, p_150144_3_, p_150144_4_);
/* 187 */     int j = i & 0x3;
/*     */     
/* 189 */     float f1 = 0.5F;
/* 190 */     float f2 = 1.0F;
/*     */     
/* 192 */     if ((i & 0x4) != 0) {
/* 193 */       f1 = 0.0F;
/* 194 */       f2 = 0.5F;
/*     */     } 
/*     */     
/* 197 */     float f3 = 0.0F;
/* 198 */     float f4 = 0.5F;
/* 199 */     float f5 = 0.5F;
/* 200 */     float f6 = 1.0F;
/*     */     
/* 202 */     boolean bool = false;
/*     */     
/* 204 */     if (j == 0) {
/* 205 */       Block block = p_150144_1_.func_147439_a(p_150144_2_ - 1, p_150144_3_, p_150144_4_);
/* 206 */       int k = p_150144_1_.func_72805_g(p_150144_2_ - 1, p_150144_3_, p_150144_4_);
/* 207 */       if (func_150148_a(block) && (i & 0x4) == (k & 0x4)) {
/* 208 */         int m = k & 0x3;
/* 209 */         if (m == 3 && !func_150146_f(p_150144_1_, p_150144_2_, p_150144_3_, p_150144_4_ - 1, i)) {
/* 210 */           f5 = 0.0F;
/* 211 */           f6 = 0.5F;
/* 212 */           bool = true;
/* 213 */         } else if (m == 2 && !func_150146_f(p_150144_1_, p_150144_2_, p_150144_3_, p_150144_4_ + 1, i)) {
/* 214 */           f5 = 0.5F;
/* 215 */           f6 = 1.0F;
/* 216 */           bool = true;
/*     */         } 
/*     */       } 
/* 219 */     } else if (j == 1) {
/* 220 */       Block block = p_150144_1_.func_147439_a(p_150144_2_ + 1, p_150144_3_, p_150144_4_);
/* 221 */       int k = p_150144_1_.func_72805_g(p_150144_2_ + 1, p_150144_3_, p_150144_4_);
/* 222 */       if (func_150148_a(block) && (i & 0x4) == (k & 0x4)) {
/* 223 */         f3 = 0.5F;
/* 224 */         f4 = 1.0F;
/* 225 */         int m = k & 0x3;
/* 226 */         if (m == 3 && !func_150146_f(p_150144_1_, p_150144_2_, p_150144_3_, p_150144_4_ - 1, i)) {
/* 227 */           f5 = 0.0F;
/* 228 */           f6 = 0.5F;
/* 229 */           bool = true;
/* 230 */         } else if (m == 2 && !func_150146_f(p_150144_1_, p_150144_2_, p_150144_3_, p_150144_4_ + 1, i)) {
/* 231 */           f5 = 0.5F;
/* 232 */           f6 = 1.0F;
/* 233 */           bool = true;
/*     */         } 
/*     */       } 
/* 236 */     } else if (j == 2) {
/* 237 */       Block block = p_150144_1_.func_147439_a(p_150144_2_, p_150144_3_, p_150144_4_ - 1);
/* 238 */       int k = p_150144_1_.func_72805_g(p_150144_2_, p_150144_3_, p_150144_4_ - 1);
/* 239 */       if (func_150148_a(block) && (i & 0x4) == (k & 0x4)) {
/* 240 */         f5 = 0.0F;
/* 241 */         f6 = 0.5F;
/*     */         
/* 243 */         int m = k & 0x3;
/* 244 */         if (m == 1 && !func_150146_f(p_150144_1_, p_150144_2_ - 1, p_150144_3_, p_150144_4_, i)) {
/* 245 */           bool = true;
/* 246 */         } else if (m == 0 && !func_150146_f(p_150144_1_, p_150144_2_ + 1, p_150144_3_, p_150144_4_, i)) {
/* 247 */           f3 = 0.5F;
/* 248 */           f4 = 1.0F;
/* 249 */           bool = true;
/*     */         } 
/*     */       } 
/* 252 */     } else if (j == 3) {
/* 253 */       Block block = p_150144_1_.func_147439_a(p_150144_2_, p_150144_3_, p_150144_4_ + 1);
/* 254 */       int k = p_150144_1_.func_72805_g(p_150144_2_, p_150144_3_, p_150144_4_ + 1);
/* 255 */       if (func_150148_a(block) && (i & 0x4) == (k & 0x4)) {
/* 256 */         int m = k & 0x3;
/* 257 */         if (m == 1 && !func_150146_f(p_150144_1_, p_150144_2_ - 1, p_150144_3_, p_150144_4_, i)) {
/* 258 */           bool = true;
/* 259 */         } else if (m == 0 && !func_150146_f(p_150144_1_, p_150144_2_ + 1, p_150144_3_, p_150144_4_, i)) {
/* 260 */           f3 = 0.5F;
/* 261 */           f4 = 1.0F;
/* 262 */           bool = true;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 267 */     if (bool) {
/* 268 */       func_149676_a(f3, f1, f5, f4, f2, f6);
/*     */     }
/* 270 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149743_a(World p_149743_1_, int p_149743_2_, int p_149743_3_, int p_149743_4_, AxisAlignedBB p_149743_5_, List p_149743_6_, Entity p_149743_7_) {
/* 276 */     func_150147_e((IBlockAccess)p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_);
/* 277 */     super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
/*     */     
/* 279 */     boolean bool = func_150145_f((IBlockAccess)p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_);
/* 280 */     super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
/*     */     
/* 282 */     if (bool && 
/* 283 */       func_150144_g((IBlockAccess)p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_)) {
/* 284 */       super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
/*     */     }
/*     */ 
/*     */     
/* 288 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
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
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149734_b(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_) {
/* 301 */     this.field_150149_b.func_149734_b(p_149734_1_, p_149734_2_, p_149734_3_, p_149734_4_, p_149734_5_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149699_a(World p_149699_1_, int p_149699_2_, int p_149699_3_, int p_149699_4_, EntityPlayer p_149699_5_) {
/* 306 */     this.field_150149_b.func_149699_a(p_149699_1_, p_149699_2_, p_149699_3_, p_149699_4_, p_149699_5_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149664_b(World p_149664_1_, int p_149664_2_, int p_149664_3_, int p_149664_4_, int p_149664_5_) {
/* 311 */     this.field_150149_b.func_149664_b(p_149664_1_, p_149664_2_, p_149664_3_, p_149664_4_, p_149664_5_);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149677_c(IBlockAccess p_149677_1_, int p_149677_2_, int p_149677_3_, int p_149677_4_) {
/* 316 */     return this.field_150149_b.func_149677_c(p_149677_1_, p_149677_2_, p_149677_3_, p_149677_4_);
/*     */   }
/*     */ 
/*     */   
/*     */   public float func_149638_a(Entity p_149638_1_) {
/* 321 */     return this.field_150149_b.func_149638_a(p_149638_1_);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149701_w() {
/* 326 */     return this.field_150149_b.func_149701_w();
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/* 331 */     return this.field_150149_b.func_149691_a(p_149691_1_, this.field_150151_M);
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149738_a(World p_149738_1_) {
/* 336 */     return this.field_150149_b.func_149738_a(p_149738_1_);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public AxisAlignedBB func_149633_g(World p_149633_1_, int p_149633_2_, int p_149633_3_, int p_149633_4_) {
/* 341 */     return this.field_150149_b.func_149633_g(p_149633_1_, p_149633_2_, p_149633_3_, p_149633_4_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149640_a(World p_149640_1_, int p_149640_2_, int p_149640_3_, int p_149640_4_, Entity p_149640_5_, Vec3 p_149640_6_) {
/* 346 */     this.field_150149_b.func_149640_a(p_149640_1_, p_149640_2_, p_149640_3_, p_149640_4_, p_149640_5_, p_149640_6_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149703_v() {
/* 351 */     return this.field_150149_b.func_149703_v();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149678_a(int p_149678_1_, boolean p_149678_2_) {
/* 356 */     return this.field_150149_b.func_149678_a(p_149678_1_, p_149678_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149742_c(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_) {
/* 361 */     return this.field_150149_b.func_149742_c(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149726_b(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {
/* 366 */     func_149695_a(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_, Blocks.field_150350_a);
/* 367 */     this.field_150149_b.func_149726_b(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149749_a(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_) {
/* 372 */     this.field_150149_b.func_149749_a(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_, p_149749_6_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149724_b(World p_149724_1_, int p_149724_2_, int p_149724_3_, int p_149724_4_, Entity p_149724_5_) {
/* 382 */     this.field_150149_b.func_149724_b(p_149724_1_, p_149724_2_, p_149724_3_, p_149724_4_, p_149724_5_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
/* 387 */     this.field_150149_b.func_149674_a(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_5_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
/* 392 */     return this.field_150149_b.func_149727_a(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_, p_149727_5_, 0, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149723_a(World p_149723_1_, int p_149723_2_, int p_149723_3_, int p_149723_4_, Explosion p_149723_5_) {
/* 397 */     this.field_150149_b.func_149723_a(p_149723_1_, p_149723_2_, p_149723_3_, p_149723_4_, p_149723_5_);
/*     */   }
/*     */ 
/*     */   
/*     */   public MapColor func_149728_f(int p_149728_1_) {
/* 402 */     return this.field_150149_b.func_149728_f(this.field_150151_M);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149689_a(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_) {
/* 407 */     int i = MathHelper.func_76128_c((p_149689_5_.field_70177_z * 4.0F / 360.0F) + 0.5D) & 0x3;
/* 408 */     int j = p_149689_1_.func_72805_g(p_149689_2_, p_149689_3_, p_149689_4_) & 0x4;
/*     */     
/* 410 */     if (i == 0) p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_, 0x2 | j, 2); 
/* 411 */     if (i == 1) p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_, 0x1 | j, 2); 
/* 412 */     if (i == 2) p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_, 0x3 | j, 2); 
/* 413 */     if (i == 3) p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_, 0x0 | j, 2);
/*     */   
/*     */   }
/*     */   
/*     */   public int func_149660_a(World p_149660_1_, int p_149660_2_, int p_149660_3_, int p_149660_4_, int p_149660_5_, float p_149660_6_, float p_149660_7_, float p_149660_8_, int p_149660_9_) {
/* 418 */     if (p_149660_5_ == 0 || (p_149660_5_ != 1 && p_149660_7_ > 0.5D)) {
/* 419 */       return p_149660_9_ | 0x4;
/*     */     }
/* 421 */     return p_149660_9_;
/*     */   }
/*     */ 
/*     */   
/*     */   public MovingObjectPosition func_149731_a(World p_149731_1_, int p_149731_2_, int p_149731_3_, int p_149731_4_, Vec3 p_149731_5_, Vec3 p_149731_6_) {
/* 426 */     MovingObjectPosition[] arrayOfMovingObjectPosition = new MovingObjectPosition[8];
/* 427 */     int i = p_149731_1_.func_72805_g(p_149731_2_, p_149731_3_, p_149731_4_);
/* 428 */     int j = i & 0x3;
/* 429 */     boolean bool = ((i & 0x4) == 4) ? true : false;
/* 430 */     int[] arrayOfInt = field_150150_a[j + (bool ? 4 : 0)];
/*     */     
/* 432 */     this.field_150152_N = true;
/* 433 */     for (byte b = 0; b < 8; b++) {
/* 434 */       this.field_150153_O = b;
/*     */       
/* 436 */       for (int k : arrayOfInt) {
/* 437 */         if (k == b);
/*     */       } 
/*     */       
/* 440 */       arrayOfMovingObjectPosition[b] = super.func_149731_a(p_149731_1_, p_149731_2_, p_149731_3_, p_149731_4_, p_149731_5_, p_149731_6_);
/*     */     } 
/*     */     
/* 443 */     for (int k : arrayOfInt) {
/* 444 */       arrayOfMovingObjectPosition[k] = null;
/*     */     }
/*     */     
/* 447 */     MovingObjectPosition movingObjectPosition = null;
/* 448 */     double d = 0.0D;
/*     */     
/* 450 */     for (MovingObjectPosition movingObjectPosition1 : arrayOfMovingObjectPosition) {
/* 451 */       if (movingObjectPosition1 != null) {
/* 452 */         double d1 = movingObjectPosition1.field_72307_f.func_72436_e(p_149731_6_);
/*     */         
/* 454 */         if (d1 > d) {
/* 455 */           movingObjectPosition = movingObjectPosition1;
/* 456 */           d = d1;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 461 */     return movingObjectPosition;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister p_149651_1_) {}
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockStairs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */