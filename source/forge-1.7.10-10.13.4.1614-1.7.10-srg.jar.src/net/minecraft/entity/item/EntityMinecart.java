/*     */ package net.minecraft.entity.item;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockRailBase;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.EntityMinecartCommandBlock;
/*     */ import net.minecraft.entity.ai.EntityMinecartMobSpawner;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldServer;
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
/*     */ public abstract class EntityMinecart
/*     */   extends Entity
/*     */ {
/*     */   private boolean field_70499_f;
/*     */   private String field_94102_c;
/*     */   
/*     */   public EntityMinecart(World p_i1712_1_) {
/*  42 */     super(p_i1712_1_);
/*  43 */     this.field_70156_m = true;
/*  44 */     func_70105_a(0.98F, 0.7F);
/*  45 */     this.field_70129_M = this.field_70131_O / 2.0F;
/*     */   }
/*     */   
/*     */   public static EntityMinecart func_94090_a(World p_94090_0_, double p_94090_1_, double p_94090_3_, double p_94090_5_, int p_94090_7_) {
/*  49 */     switch (p_94090_7_) {
/*     */       case 1:
/*  51 */         return new EntityMinecartChest(p_94090_0_, p_94090_1_, p_94090_3_, p_94090_5_);
/*     */       case 2:
/*  53 */         return new EntityMinecartFurnace(p_94090_0_, p_94090_1_, p_94090_3_, p_94090_5_);
/*     */       case 3:
/*  55 */         return new EntityMinecartTNT(p_94090_0_, p_94090_1_, p_94090_3_, p_94090_5_);
/*     */       case 4:
/*  57 */         return (EntityMinecart)new EntityMinecartMobSpawner(p_94090_0_, p_94090_1_, p_94090_3_, p_94090_5_);
/*     */       case 5:
/*  59 */         return new EntityMinecartHopper(p_94090_0_, p_94090_1_, p_94090_3_, p_94090_5_);
/*     */       case 6:
/*  61 */         return (EntityMinecart)new EntityMinecartCommandBlock(p_94090_0_, p_94090_1_, p_94090_3_, p_94090_5_);
/*     */     } 
/*  63 */     return new EntityMinecartEmpty(p_94090_0_, p_94090_1_, p_94090_3_, p_94090_5_);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean func_70041_e_() {
/*  69 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/*  74 */     this.field_70180_af.func_75682_a(17, new Integer(0));
/*  75 */     this.field_70180_af.func_75682_a(18, new Integer(1));
/*  76 */     this.field_70180_af.func_75682_a(19, new Float(0.0F));
/*  77 */     this.field_70180_af.func_75682_a(20, new Integer(0));
/*  78 */     this.field_70180_af.func_75682_a(21, new Integer(6));
/*  79 */     this.field_70180_af.func_75682_a(22, Byte.valueOf((byte)0));
/*     */   }
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_70114_g(Entity p_70114_1_) {
/*  84 */     if (p_70114_1_.func_70104_M()) {
/*  85 */       return p_70114_1_.field_70121_D;
/*     */     }
/*  87 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_70046_E() {
/*  92 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70104_M() {
/*  97 */     return true;
/*     */   }
/*     */   
/*     */   public EntityMinecart(World p_i1713_1_, double p_i1713_2_, double p_i1713_4_, double p_i1713_6_) {
/* 101 */     this(p_i1713_1_);
/* 102 */     func_70107_b(p_i1713_2_, p_i1713_4_, p_i1713_6_);
/*     */     
/* 104 */     this.field_70159_w = 0.0D;
/* 105 */     this.field_70181_x = 0.0D;
/* 106 */     this.field_70179_y = 0.0D;
/*     */     
/* 108 */     this.field_70169_q = p_i1713_2_;
/* 109 */     this.field_70167_r = p_i1713_4_;
/* 110 */     this.field_70166_s = p_i1713_6_;
/*     */   }
/*     */ 
/*     */   
/*     */   public double func_70042_X() {
/* 115 */     return this.field_70131_O * 0.0D - 0.30000001192092896D;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource p_70097_1_, float p_70097_2_) {
/* 120 */     if (this.field_70170_p.field_72995_K || this.field_70128_L) return true; 
/* 121 */     if (func_85032_ar()) return false; 
/* 122 */     func_70494_i(-func_70493_k());
/* 123 */     func_70497_h(10);
/* 124 */     func_70018_K();
/* 125 */     func_70492_c(func_70491_i() + p_70097_2_ * 10.0F);
/* 126 */     boolean bool = (p_70097_1_.func_76346_g() instanceof EntityPlayer && ((EntityPlayer)p_70097_1_.func_76346_g()).field_71075_bZ.field_75098_d) ? true : false;
/*     */     
/* 128 */     if (bool || func_70491_i() > 40.0F) {
/* 129 */       if (this.field_70153_n != null) this.field_70153_n.func_70078_a(this);
/*     */       
/* 131 */       if (!bool || func_145818_k_()) {
/* 132 */         func_94095_a(p_70097_1_);
/*     */       } else {
/* 134 */         func_70106_y();
/*     */       } 
/*     */     } 
/* 137 */     return true;
/*     */   }
/*     */   
/*     */   public void func_94095_a(DamageSource p_94095_1_) {
/* 141 */     func_70106_y();
/* 142 */     ItemStack itemStack = new ItemStack(Items.field_151143_au, 1);
/* 143 */     if (this.field_94102_c != null) itemStack.func_151001_c(this.field_94102_c); 
/* 144 */     func_70099_a(itemStack, 0.0F);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70057_ab() {
/* 149 */     func_70494_i(-func_70493_k());
/* 150 */     func_70497_h(10);
/* 151 */     func_70492_c(func_70491_i() + func_70491_i() * 10.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70067_L() {
/* 156 */     return !this.field_70128_L;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70106_y() {
/* 161 */     super.func_70106_y();
/*     */   }
/*     */ 
/*     */   
/* 165 */   private static final int[][][] field_70500_g = new int[][][] { { { 0, 0, -1 }, { 0, 0, 1 } }, { { -1, 0, 0 }, { 1, 0, 0 } }, { { -1, -1, 0 }, { 1, 0, 0 } }, { { -1, 0, 0 }, { 1, -1, 0 } }, { { 0, 0, -1 }, { 0, -1, 1 } }, { { 0, -1, -1 }, { 0, 0, 1 } }, { { 0, 0, 1 }, { 1, 0, 0 } }, { { 0, 0, 1 }, { -1, 0, 0 } }, { { 0, 0, -1 }, { -1, 0, 0 } }, { { 0, 0, -1 }, { 1, 0, 0 } } };
/*     */   private int field_70510_h;
/*     */   private double field_70511_i;
/*     */   private double field_70509_j;
/*     */   private double field_70514_an;
/*     */   private double field_70512_ao;
/*     */   private double field_70513_ap;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private double field_70508_aq;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private double field_70507_ar;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private double field_70506_as;
/*     */   private static final String __OBFID = "CL_00001670";
/*     */   
/*     */   public void func_70071_h_() {
/* 181 */     if (func_70496_j() > 0) func_70497_h(func_70496_j() - 1); 
/* 182 */     if (func_70491_i() > 0.0F) func_70492_c(func_70491_i() - 1.0F); 
/* 183 */     if (this.field_70163_u < -64.0D) {
/* 184 */       func_70076_C();
/*     */     }
/*     */     
/* 187 */     if (!this.field_70170_p.field_72995_K && this.field_70170_p instanceof WorldServer) {
/* 188 */       this.field_70170_p.field_72984_F.func_76320_a("portal");
/* 189 */       MinecraftServer minecraftServer = ((WorldServer)this.field_70170_p).func_73046_m();
/* 190 */       int m = func_82145_z();
/*     */       
/* 192 */       if (this.field_71087_bX) {
/* 193 */         if (minecraftServer.func_71255_r()) {
/* 194 */           if (this.field_70154_o == null && 
/* 195 */             this.field_82153_h++ >= m) {
/* 196 */             byte b; this.field_82153_h = m;
/* 197 */             this.field_71088_bW = func_82147_ab();
/*     */ 
/*     */ 
/*     */             
/* 201 */             if (this.field_70170_p.field_73011_w.field_76574_g == -1) {
/* 202 */               b = 0;
/*     */             } else {
/* 204 */               b = -1;
/*     */             } 
/*     */             
/* 207 */             func_71027_c(b);
/*     */           } 
/*     */           
/* 210 */           this.field_71087_bX = false;
/*     */         } 
/*     */       } else {
/* 213 */         if (this.field_82153_h > 0) this.field_82153_h -= 4; 
/* 214 */         if (this.field_82153_h < 0) this.field_82153_h = 0; 
/*     */       } 
/* 216 */       if (this.field_71088_bW > 0) this.field_71088_bW--; 
/* 217 */       this.field_70170_p.field_72984_F.func_76319_b();
/*     */     } 
/*     */     
/* 220 */     if (this.field_70170_p.field_72995_K) {
/* 221 */       if (this.field_70510_h > 0) {
/* 222 */         double d6 = this.field_70165_t + (this.field_70511_i - this.field_70165_t) / this.field_70510_h;
/* 223 */         double d7 = this.field_70163_u + (this.field_70509_j - this.field_70163_u) / this.field_70510_h;
/* 224 */         double d8 = this.field_70161_v + (this.field_70514_an - this.field_70161_v) / this.field_70510_h;
/*     */         
/* 226 */         double d9 = MathHelper.func_76138_g(this.field_70512_ao - this.field_70177_z);
/*     */         
/* 228 */         this.field_70177_z = (float)(this.field_70177_z + d9 / this.field_70510_h);
/* 229 */         this.field_70125_A = (float)(this.field_70125_A + (this.field_70513_ap - this.field_70125_A) / this.field_70510_h);
/*     */         
/* 231 */         this.field_70510_h--;
/* 232 */         func_70107_b(d6, d7, d8);
/* 233 */         func_70101_b(this.field_70177_z, this.field_70125_A);
/*     */       } else {
/* 235 */         func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 236 */         func_70101_b(this.field_70177_z, this.field_70125_A);
/*     */       } 
/*     */       
/*     */       return;
/*     */     } 
/* 241 */     this.field_70169_q = this.field_70165_t;
/* 242 */     this.field_70167_r = this.field_70163_u;
/* 243 */     this.field_70166_s = this.field_70161_v;
/*     */     
/* 245 */     this.field_70181_x -= 0.03999999910593033D;
/*     */     
/* 247 */     int i = MathHelper.func_76128_c(this.field_70165_t);
/* 248 */     int j = MathHelper.func_76128_c(this.field_70163_u);
/* 249 */     int k = MathHelper.func_76128_c(this.field_70161_v);
/* 250 */     if (BlockRailBase.func_150049_b_(this.field_70170_p, i, j - 1, k)) {
/* 251 */       j--;
/*     */     }
/*     */     
/* 254 */     double d1 = 0.4D;
/*     */     
/* 256 */     double d2 = 0.0078125D;
/*     */     
/* 258 */     Block block = this.field_70170_p.func_147439_a(i, j, k);
/* 259 */     if (BlockRailBase.func_150051_a(block)) {
/* 260 */       int m = this.field_70170_p.func_72805_g(i, j, k);
/* 261 */       func_145821_a(i, j, k, d1, d2, block, m);
/*     */       
/* 263 */       if (block == Blocks.field_150408_cc) {
/* 264 */         func_96095_a(i, j, k, ((m & 0x8) != 0));
/*     */       }
/*     */     } else {
/* 267 */       func_94088_b(d1);
/*     */     } 
/*     */     
/* 270 */     func_145775_I();
/*     */     
/* 272 */     this.field_70125_A = 0.0F;
/* 273 */     double d3 = this.field_70169_q - this.field_70165_t;
/* 274 */     double d4 = this.field_70166_s - this.field_70161_v;
/* 275 */     if (d3 * d3 + d4 * d4 > 0.001D) {
/* 276 */       this.field_70177_z = (float)(Math.atan2(d4, d3) * 180.0D / Math.PI);
/* 277 */       if (this.field_70499_f) this.field_70177_z += 180.0F;
/*     */     
/*     */     } 
/* 280 */     double d5 = MathHelper.func_76142_g(this.field_70177_z - this.field_70126_B);
/* 281 */     if (d5 < -170.0D || d5 >= 170.0D) {
/* 282 */       this.field_70177_z += 180.0F;
/* 283 */       this.field_70499_f = !this.field_70499_f;
/*     */     } 
/* 285 */     func_70101_b(this.field_70177_z, this.field_70125_A);
/*     */     
/* 287 */     List<Entity> list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b(0.20000000298023224D, 0.0D, 0.20000000298023224D));
/* 288 */     if (list != null && !list.isEmpty()) {
/* 289 */       for (byte b = 0; b < list.size(); b++) {
/* 290 */         Entity entity = list.get(b);
/* 291 */         if (entity != this.field_70153_n && entity.func_70104_M() && entity instanceof EntityMinecart) {
/* 292 */           entity.func_70108_f(this);
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/* 297 */     if (this.field_70153_n != null && 
/* 298 */       this.field_70153_n.field_70128_L) {
/* 299 */       if (this.field_70153_n.field_70154_o == this) {
/* 300 */         this.field_70153_n.field_70154_o = null;
/*     */       }
/* 302 */       this.field_70153_n = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_96095_a(int p_96095_1_, int p_96095_2_, int p_96095_3_, boolean p_96095_4_) {}
/*     */ 
/*     */   
/*     */   protected void func_94088_b(double p_94088_1_) {
/* 311 */     if (this.field_70159_w < -p_94088_1_) this.field_70159_w = -p_94088_1_; 
/* 312 */     if (this.field_70159_w > p_94088_1_) this.field_70159_w = p_94088_1_; 
/* 313 */     if (this.field_70179_y < -p_94088_1_) this.field_70179_y = -p_94088_1_; 
/* 314 */     if (this.field_70179_y > p_94088_1_) this.field_70179_y = p_94088_1_; 
/* 315 */     if (this.field_70122_E) {
/* 316 */       this.field_70159_w *= 0.5D;
/* 317 */       this.field_70181_x *= 0.5D;
/* 318 */       this.field_70179_y *= 0.5D;
/*     */     } 
/* 320 */     func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*     */     
/* 322 */     if (!this.field_70122_E) {
/* 323 */       this.field_70159_w *= 0.949999988079071D;
/* 324 */       this.field_70181_x *= 0.949999988079071D;
/* 325 */       this.field_70179_y *= 0.949999988079071D;
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void func_145821_a(int p_145821_1_, int p_145821_2_, int p_145821_3_, double p_145821_4_, double p_145821_6_, Block p_145821_8_, int p_145821_9_) {
/* 330 */     this.field_70143_R = 0.0F;
/*     */     
/* 332 */     Vec3 vec31 = func_70489_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 333 */     this.field_70163_u = p_145821_2_;
/*     */     
/* 335 */     boolean bool1 = false;
/* 336 */     boolean bool2 = false;
/* 337 */     if (p_145821_8_ == Blocks.field_150318_D) {
/* 338 */       bool1 = ((p_145821_9_ & 0x8) != 0) ? true : false;
/* 339 */       bool2 = !bool1 ? true : false;
/*     */     } 
/* 341 */     if (((BlockRailBase)p_145821_8_).func_150050_e()) {
/* 342 */       p_145821_9_ &= 0x7;
/*     */     }
/*     */     
/* 345 */     if (p_145821_9_ >= 2 && p_145821_9_ <= 5) {
/* 346 */       this.field_70163_u = (p_145821_2_ + 1);
/*     */     }
/*     */     
/* 349 */     if (p_145821_9_ == 2) this.field_70159_w -= p_145821_6_; 
/* 350 */     if (p_145821_9_ == 3) this.field_70159_w += p_145821_6_; 
/* 351 */     if (p_145821_9_ == 4) this.field_70179_y += p_145821_6_; 
/* 352 */     if (p_145821_9_ == 5) this.field_70179_y -= p_145821_6_;
/*     */     
/* 354 */     int[][] arrayOfInt = field_70500_g[p_145821_9_];
/*     */     
/* 356 */     double d1 = (arrayOfInt[1][0] - arrayOfInt[0][0]);
/* 357 */     double d2 = (arrayOfInt[1][2] - arrayOfInt[0][2]);
/* 358 */     double d3 = Math.sqrt(d1 * d1 + d2 * d2);
/*     */     
/* 360 */     double d4 = this.field_70159_w * d1 + this.field_70179_y * d2;
/* 361 */     if (d4 < 0.0D) {
/* 362 */       d1 = -d1;
/* 363 */       d2 = -d2;
/*     */     } 
/*     */     
/* 366 */     double d5 = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 367 */     if (d5 > 2.0D) {
/* 368 */       d5 = 2.0D;
/*     */     }
/*     */     
/* 371 */     this.field_70159_w = d5 * d1 / d3;
/* 372 */     this.field_70179_y = d5 * d2 / d3;
/*     */     
/* 374 */     if (this.field_70153_n != null && this.field_70153_n instanceof EntityLivingBase) {
/* 375 */       double d = ((EntityLivingBase)this.field_70153_n).field_70701_bs;
/*     */       
/* 377 */       if (d > 0.0D) {
/* 378 */         double d13 = -Math.sin((this.field_70153_n.field_70177_z * 3.1415927F / 180.0F));
/* 379 */         double d14 = Math.cos((this.field_70153_n.field_70177_z * 3.1415927F / 180.0F));
/*     */         
/* 381 */         double d15 = this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y;
/*     */         
/* 383 */         if (d15 < 0.01D) {
/* 384 */           this.field_70159_w += d13 * 0.1D;
/* 385 */           this.field_70179_y += d14 * 0.1D;
/*     */           
/* 387 */           bool2 = false;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 393 */     if (bool2) {
/* 394 */       double d = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 395 */       if (d < 0.03D) {
/* 396 */         this.field_70159_w *= 0.0D;
/* 397 */         this.field_70181_x *= 0.0D;
/* 398 */         this.field_70179_y *= 0.0D;
/*     */       } else {
/* 400 */         this.field_70159_w *= 0.5D;
/* 401 */         this.field_70181_x *= 0.0D;
/* 402 */         this.field_70179_y *= 0.5D;
/*     */       } 
/*     */     } 
/*     */     
/* 406 */     double d6 = 0.0D;
/* 407 */     double d7 = p_145821_1_ + 0.5D + arrayOfInt[0][0] * 0.5D;
/* 408 */     double d8 = p_145821_3_ + 0.5D + arrayOfInt[0][2] * 0.5D;
/* 409 */     double d9 = p_145821_1_ + 0.5D + arrayOfInt[1][0] * 0.5D;
/* 410 */     double d10 = p_145821_3_ + 0.5D + arrayOfInt[1][2] * 0.5D;
/*     */     
/* 412 */     d1 = d9 - d7;
/* 413 */     d2 = d10 - d8;
/*     */     
/* 415 */     if (d1 == 0.0D) {
/* 416 */       this.field_70165_t = p_145821_1_ + 0.5D;
/* 417 */       d6 = this.field_70161_v - p_145821_3_;
/* 418 */     } else if (d2 == 0.0D) {
/* 419 */       this.field_70161_v = p_145821_3_ + 0.5D;
/* 420 */       d6 = this.field_70165_t - p_145821_1_;
/*     */     } else {
/*     */       
/* 423 */       double d13 = this.field_70165_t - d7;
/* 424 */       double d14 = this.field_70161_v - d8;
/*     */       
/* 426 */       d6 = (d13 * d1 + d14 * d2) * 2.0D;
/*     */     } 
/*     */     
/* 429 */     this.field_70165_t = d7 + d1 * d6;
/* 430 */     this.field_70161_v = d8 + d2 * d6;
/*     */     
/* 432 */     func_70107_b(this.field_70165_t, this.field_70163_u + this.field_70129_M, this.field_70161_v);
/*     */     
/* 434 */     double d11 = this.field_70159_w;
/* 435 */     double d12 = this.field_70179_y;
/* 436 */     if (this.field_70153_n != null) {
/* 437 */       d11 *= 0.75D;
/* 438 */       d12 *= 0.75D;
/*     */     } 
/* 440 */     if (d11 < -p_145821_4_) d11 = -p_145821_4_; 
/* 441 */     if (d11 > p_145821_4_) d11 = p_145821_4_; 
/* 442 */     if (d12 < -p_145821_4_) d12 = -p_145821_4_; 
/* 443 */     if (d12 > p_145821_4_) d12 = p_145821_4_;
/*     */     
/* 445 */     func_70091_d(d11, 0.0D, d12);
/*     */     
/* 447 */     if (arrayOfInt[0][1] != 0 && MathHelper.func_76128_c(this.field_70165_t) - p_145821_1_ == arrayOfInt[0][0] && MathHelper.func_76128_c(this.field_70161_v) - p_145821_3_ == arrayOfInt[0][2]) {
/* 448 */       func_70107_b(this.field_70165_t, this.field_70163_u + arrayOfInt[0][1], this.field_70161_v);
/* 449 */     } else if (arrayOfInt[1][1] != 0 && MathHelper.func_76128_c(this.field_70165_t) - p_145821_1_ == arrayOfInt[1][0] && MathHelper.func_76128_c(this.field_70161_v) - p_145821_3_ == arrayOfInt[1][2]) {
/* 450 */       func_70107_b(this.field_70165_t, this.field_70163_u + arrayOfInt[1][1], this.field_70161_v);
/*     */     } 
/*     */     
/* 453 */     func_94101_h();
/*     */     
/* 455 */     Vec3 vec32 = func_70489_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 456 */     if (vec32 != null && vec31 != null) {
/* 457 */       double d = (vec31.field_72448_b - vec32.field_72448_b) * 0.05D;
/*     */       
/* 459 */       d5 = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 460 */       if (d5 > 0.0D) {
/* 461 */         this.field_70159_w = this.field_70159_w / d5 * (d5 + d);
/* 462 */         this.field_70179_y = this.field_70179_y / d5 * (d5 + d);
/*     */       } 
/* 464 */       func_70107_b(this.field_70165_t, vec32.field_72448_b, this.field_70161_v);
/*     */     } 
/*     */     
/* 467 */     int i = MathHelper.func_76128_c(this.field_70165_t);
/* 468 */     int j = MathHelper.func_76128_c(this.field_70161_v);
/* 469 */     if (i != p_145821_1_ || j != p_145821_3_) {
/* 470 */       d5 = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/*     */       
/* 472 */       this.field_70159_w = d5 * (i - p_145821_1_);
/* 473 */       this.field_70179_y = d5 * (j - p_145821_3_);
/*     */     } 
/*     */ 
/*     */     
/* 477 */     if (bool1) {
/* 478 */       double d = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 479 */       if (d > 0.01D) {
/* 480 */         double d13 = 0.06D;
/* 481 */         this.field_70159_w += this.field_70159_w / d * d13;
/* 482 */         this.field_70179_y += this.field_70179_y / d * d13;
/*     */ 
/*     */       
/*     */       }
/* 486 */       else if (p_145821_9_ == 1) {
/* 487 */         if (this.field_70170_p.func_147439_a(p_145821_1_ - 1, p_145821_2_, p_145821_3_).func_149721_r()) {
/* 488 */           this.field_70159_w = 0.02D;
/* 489 */         } else if (this.field_70170_p.func_147439_a(p_145821_1_ + 1, p_145821_2_, p_145821_3_).func_149721_r()) {
/* 490 */           this.field_70159_w = -0.02D;
/*     */         } 
/* 492 */       } else if (p_145821_9_ == 0) {
/* 493 */         if (this.field_70170_p.func_147439_a(p_145821_1_, p_145821_2_, p_145821_3_ - 1).func_149721_r()) {
/* 494 */           this.field_70179_y = 0.02D;
/* 495 */         } else if (this.field_70170_p.func_147439_a(p_145821_1_, p_145821_2_, p_145821_3_ + 1).func_149721_r()) {
/* 496 */           this.field_70179_y = -0.02D;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_94101_h() {
/* 504 */     if (this.field_70153_n != null) {
/* 505 */       this.field_70159_w *= 0.996999979019165D;
/* 506 */       this.field_70181_x *= 0.0D;
/* 507 */       this.field_70179_y *= 0.996999979019165D;
/*     */     } else {
/* 509 */       this.field_70159_w *= 0.9599999785423279D;
/* 510 */       this.field_70181_x *= 0.0D;
/* 511 */       this.field_70179_y *= 0.9599999785423279D;
/*     */     } 
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Vec3 func_70495_a(double p_70495_1_, double p_70495_3_, double p_70495_5_, double p_70495_7_) {
/* 516 */     int i = MathHelper.func_76128_c(p_70495_1_);
/* 517 */     int j = MathHelper.func_76128_c(p_70495_3_);
/* 518 */     int k = MathHelper.func_76128_c(p_70495_5_);
/* 519 */     if (BlockRailBase.func_150049_b_(this.field_70170_p, i, j - 1, k)) {
/* 520 */       j--;
/*     */     }
/*     */     
/* 523 */     Block block = this.field_70170_p.func_147439_a(i, j, k);
/* 524 */     if (BlockRailBase.func_150051_a(block)) {
/* 525 */       int m = this.field_70170_p.func_72805_g(i, j, k);
/*     */       
/* 527 */       if (((BlockRailBase)block).func_150050_e()) {
/* 528 */         m &= 0x7;
/*     */       }
/*     */       
/* 531 */       p_70495_3_ = j;
/* 532 */       if (m >= 2 && m <= 5) {
/* 533 */         p_70495_3_ = (j + 1);
/*     */       }
/*     */       
/* 536 */       int[][] arrayOfInt = field_70500_g[m];
/*     */       
/* 538 */       double d1 = (arrayOfInt[1][0] - arrayOfInt[0][0]);
/* 539 */       double d2 = (arrayOfInt[1][2] - arrayOfInt[0][2]);
/* 540 */       double d3 = Math.sqrt(d1 * d1 + d2 * d2);
/* 541 */       d1 /= d3;
/* 542 */       d2 /= d3;
/*     */       
/* 544 */       p_70495_1_ += d1 * p_70495_7_;
/* 545 */       p_70495_5_ += d2 * p_70495_7_;
/*     */       
/* 547 */       if (arrayOfInt[0][1] != 0 && MathHelper.func_76128_c(p_70495_1_) - i == arrayOfInt[0][0] && MathHelper.func_76128_c(p_70495_5_) - k == arrayOfInt[0][2]) {
/* 548 */         p_70495_3_ += arrayOfInt[0][1];
/* 549 */       } else if (arrayOfInt[1][1] != 0 && MathHelper.func_76128_c(p_70495_1_) - i == arrayOfInt[1][0] && MathHelper.func_76128_c(p_70495_5_) - k == arrayOfInt[1][2]) {
/* 550 */         p_70495_3_ += arrayOfInt[1][1];
/*     */       } 
/*     */       
/* 553 */       return func_70489_a(p_70495_1_, p_70495_3_, p_70495_5_);
/*     */     } 
/* 555 */     return null;
/*     */   }
/*     */   
/*     */   public Vec3 func_70489_a(double p_70489_1_, double p_70489_3_, double p_70489_5_) {
/* 559 */     int i = MathHelper.func_76128_c(p_70489_1_);
/* 560 */     int j = MathHelper.func_76128_c(p_70489_3_);
/* 561 */     int k = MathHelper.func_76128_c(p_70489_5_);
/* 562 */     if (BlockRailBase.func_150049_b_(this.field_70170_p, i, j - 1, k)) {
/* 563 */       j--;
/*     */     }
/*     */     
/* 566 */     Block block = this.field_70170_p.func_147439_a(i, j, k);
/* 567 */     if (BlockRailBase.func_150051_a(block)) {
/* 568 */       int m = this.field_70170_p.func_72805_g(i, j, k);
/* 569 */       p_70489_3_ = j;
/*     */       
/* 571 */       if (((BlockRailBase)block).func_150050_e()) {
/* 572 */         m &= 0x7;
/*     */       }
/*     */       
/* 575 */       if (m >= 2 && m <= 5) {
/* 576 */         p_70489_3_ = (j + 1);
/*     */       }
/*     */       
/* 579 */       int[][] arrayOfInt = field_70500_g[m];
/*     */       
/* 581 */       double d1 = 0.0D;
/* 582 */       double d2 = i + 0.5D + arrayOfInt[0][0] * 0.5D;
/* 583 */       double d3 = j + 0.5D + arrayOfInt[0][1] * 0.5D;
/* 584 */       double d4 = k + 0.5D + arrayOfInt[0][2] * 0.5D;
/* 585 */       double d5 = i + 0.5D + arrayOfInt[1][0] * 0.5D;
/* 586 */       double d6 = j + 0.5D + arrayOfInt[1][1] * 0.5D;
/* 587 */       double d7 = k + 0.5D + arrayOfInt[1][2] * 0.5D;
/*     */       
/* 589 */       double d8 = d5 - d2;
/* 590 */       double d9 = (d6 - d3) * 2.0D;
/* 591 */       double d10 = d7 - d4;
/*     */       
/* 593 */       if (d8 == 0.0D) {
/* 594 */         p_70489_1_ = i + 0.5D;
/* 595 */         d1 = p_70489_5_ - k;
/* 596 */       } else if (d10 == 0.0D) {
/* 597 */         p_70489_5_ = k + 0.5D;
/* 598 */         d1 = p_70489_1_ - i;
/*     */       } else {
/*     */         
/* 601 */         double d11 = p_70489_1_ - d2;
/* 602 */         double d12 = p_70489_5_ - d4;
/*     */         
/* 604 */         d1 = (d11 * d8 + d12 * d10) * 2.0D;
/*     */       } 
/*     */       
/* 607 */       p_70489_1_ = d2 + d8 * d1;
/* 608 */       p_70489_3_ = d3 + d9 * d1;
/* 609 */       p_70489_5_ = d4 + d10 * d1;
/* 610 */       if (d9 < 0.0D) p_70489_3_++; 
/* 611 */       if (d9 > 0.0D) p_70489_3_ += 0.5D; 
/* 612 */       return Vec3.func_72443_a(p_70489_1_, p_70489_3_, p_70489_5_);
/*     */     } 
/* 614 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70037_a(NBTTagCompound p_70037_1_) {
/* 619 */     if (p_70037_1_.func_74767_n("CustomDisplayTile")) {
/* 620 */       func_145819_k(p_70037_1_.func_74762_e("DisplayTile"));
/* 621 */       func_94092_k(p_70037_1_.func_74762_e("DisplayData"));
/* 622 */       func_94086_l(p_70037_1_.func_74762_e("DisplayOffset"));
/*     */     } 
/*     */     
/* 625 */     if (p_70037_1_.func_150297_b("CustomName", 8) && p_70037_1_.func_74779_i("CustomName").length() > 0) this.field_94102_c = p_70037_1_.func_74779_i("CustomName");
/*     */   
/*     */   }
/*     */   
/*     */   protected void func_70014_b(NBTTagCompound p_70014_1_) {
/* 630 */     if (func_94100_s()) {
/* 631 */       p_70014_1_.func_74757_a("CustomDisplayTile", true);
/* 632 */       p_70014_1_.func_74768_a("DisplayTile", (func_145820_n().func_149688_o() == Material.field_151579_a) ? 0 : Block.func_149682_b(func_145820_n()));
/* 633 */       p_70014_1_.func_74768_a("DisplayData", func_94098_o());
/* 634 */       p_70014_1_.func_74768_a("DisplayOffset", func_94099_q());
/*     */     } 
/*     */     
/* 637 */     if (this.field_94102_c != null && this.field_94102_c.length() > 0) p_70014_1_.func_74778_a("CustomName", this.field_94102_c); 
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_70053_R() {
/* 642 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70108_f(Entity p_70108_1_) {
/* 647 */     if (this.field_70170_p.field_72995_K)
/*     */       return; 
/* 649 */     if (p_70108_1_ == this.field_70153_n)
/* 650 */       return;  if (p_70108_1_ instanceof EntityLivingBase && !(p_70108_1_ instanceof EntityPlayer) && !(p_70108_1_ instanceof net.minecraft.entity.monster.EntityIronGolem) && func_94087_l() == 0 && this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y > 0.01D && 
/* 651 */       this.field_70153_n == null && p_70108_1_.field_70154_o == null) {
/* 652 */       p_70108_1_.func_70078_a(this);
/*     */     }
/*     */ 
/*     */     
/* 656 */     double d1 = p_70108_1_.field_70165_t - this.field_70165_t;
/* 657 */     double d2 = p_70108_1_.field_70161_v - this.field_70161_v;
/*     */     
/* 659 */     double d3 = d1 * d1 + d2 * d2;
/* 660 */     if (d3 >= 9.999999747378752E-5D) {
/* 661 */       d3 = MathHelper.func_76133_a(d3);
/* 662 */       d1 /= d3;
/* 663 */       d2 /= d3;
/* 664 */       double d = 1.0D / d3;
/* 665 */       if (d > 1.0D) d = 1.0D; 
/* 666 */       d1 *= d;
/* 667 */       d2 *= d;
/* 668 */       d1 *= 0.10000000149011612D;
/* 669 */       d2 *= 0.10000000149011612D;
/*     */       
/* 671 */       d1 *= (1.0F - this.field_70144_Y);
/* 672 */       d2 *= (1.0F - this.field_70144_Y);
/* 673 */       d1 *= 0.5D;
/* 674 */       d2 *= 0.5D;
/*     */       
/* 676 */       if (p_70108_1_ instanceof EntityMinecart) {
/* 677 */         double d4 = p_70108_1_.field_70165_t - this.field_70165_t;
/* 678 */         double d5 = p_70108_1_.field_70161_v - this.field_70161_v;
/*     */         
/* 680 */         Vec3 vec31 = Vec3.func_72443_a(d4, 0.0D, d5).func_72432_b();
/* 681 */         Vec3 vec32 = Vec3.func_72443_a(MathHelper.func_76134_b(this.field_70177_z * 3.1415927F / 180.0F), 0.0D, MathHelper.func_76126_a(this.field_70177_z * 3.1415927F / 180.0F)).func_72432_b();
/*     */         
/* 683 */         double d6 = Math.abs(vec31.func_72430_b(vec32));
/*     */         
/* 685 */         if (d6 < 0.800000011920929D) {
/*     */           return;
/*     */         }
/*     */         
/* 689 */         double d7 = p_70108_1_.field_70159_w + this.field_70159_w;
/* 690 */         double d8 = p_70108_1_.field_70179_y + this.field_70179_y;
/*     */         
/* 692 */         if (((EntityMinecart)p_70108_1_).func_94087_l() == 2 && func_94087_l() != 2) {
/* 693 */           this.field_70159_w *= 0.20000000298023224D;
/* 694 */           this.field_70179_y *= 0.20000000298023224D;
/* 695 */           func_70024_g(p_70108_1_.field_70159_w - d1, 0.0D, p_70108_1_.field_70179_y - d2);
/* 696 */           p_70108_1_.field_70159_w *= 0.949999988079071D;
/* 697 */           p_70108_1_.field_70179_y *= 0.949999988079071D;
/* 698 */         } else if (((EntityMinecart)p_70108_1_).func_94087_l() != 2 && func_94087_l() == 2) {
/* 699 */           p_70108_1_.field_70159_w *= 0.20000000298023224D;
/* 700 */           p_70108_1_.field_70179_y *= 0.20000000298023224D;
/* 701 */           p_70108_1_.func_70024_g(this.field_70159_w + d1, 0.0D, this.field_70179_y + d2);
/* 702 */           this.field_70159_w *= 0.949999988079071D;
/* 703 */           this.field_70179_y *= 0.949999988079071D;
/*     */         } else {
/* 705 */           d7 /= 2.0D;
/* 706 */           d8 /= 2.0D;
/* 707 */           this.field_70159_w *= 0.20000000298023224D;
/* 708 */           this.field_70179_y *= 0.20000000298023224D;
/* 709 */           func_70024_g(d7 - d1, 0.0D, d8 - d2);
/* 710 */           p_70108_1_.field_70159_w *= 0.20000000298023224D;
/* 711 */           p_70108_1_.field_70179_y *= 0.20000000298023224D;
/* 712 */           p_70108_1_.func_70024_g(d7 + d1, 0.0D, d8 + d2);
/*     */         } 
/*     */       } else {
/*     */         
/* 716 */         func_70024_g(-d1, 0.0D, -d2);
/* 717 */         p_70108_1_.func_70024_g(d1 / 4.0D, 0.0D, d2 / 4.0D);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70056_a(double p_70056_1_, double p_70056_3_, double p_70056_5_, float p_70056_7_, float p_70056_8_, int p_70056_9_) {
/* 728 */     this.field_70511_i = p_70056_1_;
/* 729 */     this.field_70509_j = p_70056_3_;
/* 730 */     this.field_70514_an = p_70056_5_;
/* 731 */     this.field_70512_ao = p_70056_7_;
/* 732 */     this.field_70513_ap = p_70056_8_;
/*     */     
/* 734 */     this.field_70510_h = p_70056_9_ + 2;
/*     */     
/* 736 */     this.field_70159_w = this.field_70508_aq;
/* 737 */     this.field_70181_x = this.field_70507_ar;
/* 738 */     this.field_70179_y = this.field_70506_as;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70016_h(double p_70016_1_, double p_70016_3_, double p_70016_5_) {
/* 743 */     this.field_70508_aq = this.field_70159_w = p_70016_1_;
/* 744 */     this.field_70507_ar = this.field_70181_x = p_70016_3_;
/* 745 */     this.field_70506_as = this.field_70179_y = p_70016_5_;
/*     */   }
/*     */   
/*     */   public void func_70492_c(float p_70492_1_) {
/* 749 */     this.field_70180_af.func_75692_b(19, Float.valueOf(p_70492_1_));
/*     */   }
/*     */   
/*     */   public float func_70491_i() {
/* 753 */     return this.field_70180_af.func_111145_d(19);
/*     */   }
/*     */   
/*     */   public void func_70497_h(int p_70497_1_) {
/* 757 */     this.field_70180_af.func_75692_b(17, Integer.valueOf(p_70497_1_));
/*     */   }
/*     */   
/*     */   public int func_70496_j() {
/* 761 */     return this.field_70180_af.func_75679_c(17);
/*     */   }
/*     */   
/*     */   public void func_70494_i(int p_70494_1_) {
/* 765 */     this.field_70180_af.func_75692_b(18, Integer.valueOf(p_70494_1_));
/*     */   }
/*     */   
/*     */   public int func_70493_k() {
/* 769 */     return this.field_70180_af.func_75679_c(18);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Block func_145820_n() {
/* 775 */     if (!func_94100_s()) return func_145817_o(); 
/* 776 */     int i = func_70096_w().func_75679_c(20) & 0xFFFF;
/* 777 */     return Block.func_149729_e(i);
/*     */   }
/*     */   
/*     */   public Block func_145817_o() {
/* 781 */     return Blocks.field_150350_a;
/*     */   }
/*     */   
/*     */   public int func_94098_o() {
/* 785 */     if (!func_94100_s()) return func_94097_p(); 
/* 786 */     return func_70096_w().func_75679_c(20) >> 16;
/*     */   }
/*     */   
/*     */   public int func_94097_p() {
/* 790 */     return 0;
/*     */   }
/*     */   
/*     */   public int func_94099_q() {
/* 794 */     if (!func_94100_s()) return func_94085_r(); 
/* 795 */     return func_70096_w().func_75679_c(21);
/*     */   }
/*     */   
/*     */   public int func_94085_r() {
/* 799 */     return 6;
/*     */   }
/*     */   
/*     */   public void func_145819_k(int p_145819_1_) {
/* 803 */     func_70096_w().func_75692_b(20, Integer.valueOf(p_145819_1_ & 0xFFFF | func_94098_o() << 16));
/* 804 */     func_94096_e(true);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_94092_k(int p_94092_1_) {
/* 809 */     func_70096_w().func_75692_b(20, Integer.valueOf(Block.func_149682_b(func_145820_n()) & 0xFFFF | p_94092_1_ << 16));
/* 810 */     func_94096_e(true);
/*     */   }
/*     */   
/*     */   public void func_94086_l(int p_94086_1_) {
/* 814 */     func_70096_w().func_75692_b(21, Integer.valueOf(p_94086_1_));
/* 815 */     func_94096_e(true);
/*     */   }
/*     */   
/*     */   public boolean func_94100_s() {
/* 819 */     return (func_70096_w().func_75683_a(22) == 1);
/*     */   }
/*     */   
/*     */   public void func_94096_e(boolean p_94096_1_) {
/* 823 */     func_70096_w().func_75692_b(22, Byte.valueOf((byte)(p_94096_1_ ? 1 : 0)));
/*     */   }
/*     */   
/*     */   public void func_96094_a(String p_96094_1_) {
/* 827 */     this.field_94102_c = p_96094_1_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_70005_c_() {
/* 833 */     if (this.field_94102_c != null) return this.field_94102_c; 
/* 834 */     return super.func_70005_c_();
/*     */   }
/*     */   
/*     */   public boolean func_145818_k_() {
/* 838 */     return (this.field_94102_c != null);
/*     */   }
/*     */   
/*     */   public String func_95999_t() {
/* 842 */     return this.field_94102_c;
/*     */   }
/*     */   
/*     */   public abstract int func_94087_l();
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\item\EntityMinecart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */