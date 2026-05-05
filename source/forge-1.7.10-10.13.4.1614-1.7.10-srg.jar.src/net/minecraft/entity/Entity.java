/*      */ package net.minecraft.entity;
/*      */ import cpw.mods.fml.relauncher.Side;
/*      */ import cpw.mods.fml.relauncher.SideOnly;
/*      */ import java.util.List;
/*      */ import java.util.Random;
/*      */ import java.util.UUID;
/*      */ import java.util.concurrent.Callable;
/*      */ import net.minecraft.block.Block;
/*      */ import net.minecraft.block.material.Material;
/*      */ import net.minecraft.crash.CrashReport;
/*      */ import net.minecraft.crash.CrashReportCategory;
/*      */ import net.minecraft.entity.item.EntityItem;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.init.Blocks;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.nbt.NBTBase;
/*      */ import net.minecraft.nbt.NBTTagCompound;
/*      */ import net.minecraft.nbt.NBTTagList;
/*      */ import net.minecraft.server.MinecraftServer;
/*      */ import net.minecraft.util.AxisAlignedBB;
/*      */ import net.minecraft.util.ChunkCoordinates;
/*      */ import net.minecraft.util.DamageSource;
/*      */ import net.minecraft.util.IChatComponent;
/*      */ import net.minecraft.util.MathHelper;
/*      */ import net.minecraft.util.ReportedException;
/*      */ import net.minecraft.world.Explosion;
/*      */ import net.minecraft.world.World;
/*      */ import net.minecraft.world.WorldServer;
/*      */ 
/*      */ public abstract class Entity {
/*   32 */   private int field_145783_c = field_70152_a++;
/*      */   private static int field_70152_a;
/*   34 */   public double field_70155_l = 1.0D; public boolean field_70156_m; public Entity field_70153_n; public Entity field_70154_o; public boolean field_98038_p; public World field_70170_p; public double field_70169_q;
/*      */   public double field_70167_r;
/*      */   public double field_70166_s;
/*      */   public double field_70165_t;
/*      */   public double field_70163_u;
/*      */   public double field_70161_v;
/*      */   public double field_70159_w;
/*      */   public double field_70181_x;
/*      */   public double field_70179_y;
/*      */   public float field_70177_z;
/*      */   public float field_70125_A;
/*      */   public float field_70126_B;
/*      */   public float field_70127_C;
/*   47 */   public final AxisAlignedBB field_70121_D = AxisAlignedBB.func_72330_a(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
/*      */   
/*      */   public boolean field_70122_E;
/*      */   public boolean field_70123_F;
/*      */   public boolean field_70124_G;
/*      */   public boolean field_70132_H;
/*      */   public boolean field_70133_I;
/*      */   protected boolean field_70134_J;
/*      */   public boolean field_70135_K = true;
/*      */   public boolean field_70128_L;
/*      */   public float field_70129_M;
/*   58 */   public float field_70130_N = 0.6F;
/*   59 */   public float field_70131_O = 1.8F;
/*      */   
/*      */   public float field_70141_P;
/*      */   public float field_70140_Q;
/*      */   public float field_82151_R;
/*      */   public float field_70143_R;
/*   65 */   private int field_70150_b = 1; public double field_70142_S;
/*      */   public double field_70137_T;
/*      */   public double field_70136_U;
/*      */   public float field_70139_V;
/*      */   public float field_70138_W;
/*      */   public boolean field_70145_X;
/*      */   public float field_70144_Y;
/*   72 */   protected Random field_70146_Z = new Random();
/*      */   public int field_70173_aa;
/*   74 */   public int field_70174_ab = 1;
/*      */   
/*      */   private int field_70151_c;
/*      */   
/*      */   protected boolean field_70171_ac;
/*      */   
/*      */   public int field_70172_ad;
/*      */   
/*      */   private boolean field_70148_d = true;
/*      */   
/*      */   protected boolean field_70178_ae;
/*      */   
/*      */   protected DataWatcher field_70180_af;
/*      */   
/*      */   private double field_70149_e;
/*      */   
/*      */   private double field_70147_f;
/*      */   
/*      */   public boolean field_70175_ag;
/*      */   public int field_70176_ah;
/*      */   public int field_70162_ai;
/*      */   public int field_70164_aj;
/*      */   @SideOnly(Side.CLIENT)
/*      */   public int field_70118_ct;
/*      */   @SideOnly(Side.CLIENT)
/*      */   public int field_70117_cu;
/*      */   @SideOnly(Side.CLIENT)
/*      */   public int field_70116_cv;
/*      */   public boolean field_70158_ak;
/*      */   public boolean field_70160_al;
/*      */   public int field_71088_bW;
/*      */   protected boolean field_71087_bX;
/*      */   protected int field_82153_h;
/*      */   public int field_71093_bK;
/*      */   protected int field_82152_aq;
/*      */   private boolean field_83001_bt;
/*  110 */   protected UUID field_96093_i = UUID.randomUUID();
/*      */   
/*      */   public int func_145782_y() {
/*  113 */     return this.field_145783_c;
/*      */   }
/*      */   
/*      */   public void func_145769_d(int p_145769_1_) {
/*  117 */     this.field_145783_c = p_145769_1_;
/*      */   }
/*      */   
/*      */   public enum EnumEntitySize {
/*  121 */     SIZE_1,
/*  122 */     SIZE_2,
/*  123 */     SIZE_3,
/*  124 */     SIZE_4,
/*  125 */     SIZE_5,
/*  126 */     SIZE_6; private static final String __OBFID = "CL_00001537";
/*      */     
/*      */     public int func_75630_a(double p_75630_1_) {
/*  129 */       double d = p_75630_1_ - MathHelper.func_76128_c(p_75630_1_) + 0.5D;
/*      */       
/*  131 */       switch (Entity.SwitchEnumEntitySize.field_96565_a[ordinal()]) {
/*      */         case 1:
/*  133 */           if ((d < 0.0D) ? (d < -0.3125D) : (d < 0.3125D)) {
/*  134 */             return MathHelper.func_76143_f(p_75630_1_ * 32.0D);
/*      */           }
/*      */           
/*  137 */           return MathHelper.func_76128_c(p_75630_1_ * 32.0D);
/*      */         case 2:
/*  139 */           if ((d < 0.0D) ? (d < -0.3125D) : (d < 0.3125D)) {
/*  140 */             return MathHelper.func_76128_c(p_75630_1_ * 32.0D);
/*      */           }
/*      */           
/*  143 */           return MathHelper.func_76143_f(p_75630_1_ * 32.0D);
/*      */         case 3:
/*  145 */           if (d > 0.0D) {
/*  146 */             return MathHelper.func_76128_c(p_75630_1_ * 32.0D);
/*      */           }
/*      */           
/*  149 */           return MathHelper.func_76143_f(p_75630_1_ * 32.0D);
/*      */         case 4:
/*  151 */           if ((d < 0.0D) ? (d < -0.1875D) : (d < 0.1875D)) {
/*  152 */             return MathHelper.func_76143_f(p_75630_1_ * 32.0D);
/*      */           }
/*      */           
/*  155 */           return MathHelper.func_76128_c(p_75630_1_ * 32.0D);
/*      */         case 5:
/*  157 */           if ((d < 0.0D) ? (d < -0.1875D) : (d < 0.1875D)) {
/*  158 */             return MathHelper.func_76128_c(p_75630_1_ * 32.0D);
/*      */           }
/*      */           
/*  161 */           return MathHelper.func_76143_f(p_75630_1_ * 32.0D);
/*      */       } 
/*      */       
/*  164 */       if (d > 0.0D) {
/*  165 */         return MathHelper.func_76143_f(p_75630_1_ * 32.0D);
/*      */       }
/*      */       
/*  168 */       return MathHelper.func_76128_c(p_75630_1_ * 32.0D);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*  173 */   public EnumEntitySize field_70168_am = EnumEntitySize.SIZE_2; private static final String __OBFID = "CL_00001533";
/*      */   
/*      */   public Entity(World p_i1582_1_) {
/*  176 */     this.field_70170_p = p_i1582_1_;
/*  177 */     func_70107_b(0.0D, 0.0D, 0.0D);
/*      */     
/*  179 */     if (p_i1582_1_ != null) {
/*  180 */       this.field_71093_bK = p_i1582_1_.field_73011_w.field_76574_g;
/*      */     }
/*      */     
/*  183 */     this.field_70180_af = new DataWatcher(this);
/*  184 */     this.field_70180_af.func_75682_a(0, Byte.valueOf((byte)0));
/*  185 */     this.field_70180_af.func_75682_a(1, Short.valueOf((short)300));
/*  186 */     func_70088_a();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DataWatcher func_70096_w() {
/*  193 */     return this.field_70180_af;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean equals(Object p_equals_1_) {
/*  198 */     if (p_equals_1_ instanceof Entity) {
/*  199 */       return (((Entity)p_equals_1_).field_145783_c == this.field_145783_c);
/*      */     }
/*  201 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public int hashCode() {
/*  206 */     return this.field_145783_c;
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   protected void func_70065_x() {
/*  210 */     if (this.field_70170_p == null)
/*  211 */       return;  while (this.field_70163_u > 0.0D) {
/*  212 */       func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*  213 */       if (this.field_70170_p.func_72945_a(this, this.field_70121_D).isEmpty())
/*  214 */         break;  this.field_70163_u++;
/*      */     } 
/*      */     
/*  217 */     this.field_70159_w = this.field_70181_x = this.field_70179_y = 0.0D;
/*  218 */     this.field_70125_A = 0.0F;
/*      */   }
/*      */   
/*      */   public void func_70106_y() {
/*  222 */     this.field_70128_L = true;
/*      */   }
/*      */   
/*      */   protected void func_70105_a(float p_70105_1_, float p_70105_2_) {
/*  226 */     if (p_70105_1_ != this.field_70130_N || p_70105_2_ != this.field_70131_O) {
/*  227 */       float f1 = this.field_70130_N;
/*      */       
/*  229 */       this.field_70130_N = p_70105_1_;
/*  230 */       this.field_70131_O = p_70105_2_;
/*  231 */       this.field_70121_D.field_72336_d = this.field_70121_D.field_72340_a + this.field_70130_N;
/*  232 */       this.field_70121_D.field_72334_f = this.field_70121_D.field_72339_c + this.field_70130_N;
/*  233 */       this.field_70121_D.field_72337_e = this.field_70121_D.field_72338_b + this.field_70131_O;
/*      */       
/*  235 */       if (this.field_70130_N > f1 && !this.field_70148_d && !this.field_70170_p.field_72995_K) {
/*  236 */         func_70091_d((f1 - this.field_70130_N), 0.0D, (f1 - this.field_70130_N));
/*      */       }
/*      */     } 
/*  239 */     float f = p_70105_1_ % 2.0F;
/*  240 */     if (f < 0.375D) {
/*  241 */       this.field_70168_am = EnumEntitySize.SIZE_1;
/*  242 */     } else if (f < 0.75D) {
/*  243 */       this.field_70168_am = EnumEntitySize.SIZE_2;
/*  244 */     } else if (f < 1.0D) {
/*  245 */       this.field_70168_am = EnumEntitySize.SIZE_3;
/*  246 */     } else if (f < 1.375D) {
/*  247 */       this.field_70168_am = EnumEntitySize.SIZE_4;
/*  248 */     } else if (f < 1.75D) {
/*  249 */       this.field_70168_am = EnumEntitySize.SIZE_5;
/*      */     } else {
/*  251 */       this.field_70168_am = EnumEntitySize.SIZE_6;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void func_70101_b(float p_70101_1_, float p_70101_2_) {
/*  264 */     this.field_70177_z = p_70101_1_ % 360.0F;
/*  265 */     this.field_70125_A = p_70101_2_ % 360.0F;
/*      */   }
/*      */   
/*      */   public void func_70107_b(double p_70107_1_, double p_70107_3_, double p_70107_5_) {
/*  269 */     this.field_70165_t = p_70107_1_;
/*  270 */     this.field_70163_u = p_70107_3_;
/*  271 */     this.field_70161_v = p_70107_5_;
/*  272 */     float f1 = this.field_70130_N / 2.0F;
/*  273 */     float f2 = this.field_70131_O;
/*  274 */     this.field_70121_D.func_72324_b(p_70107_1_ - f1, p_70107_3_ - this.field_70129_M + this.field_70139_V, p_70107_5_ - f1, p_70107_1_ + f1, p_70107_3_ - this.field_70129_M + this.field_70139_V + f2, p_70107_5_ + f1);
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public void func_70082_c(float p_70082_1_, float p_70082_2_) {
/*  278 */     float f1 = this.field_70125_A;
/*  279 */     float f2 = this.field_70177_z;
/*      */     
/*  281 */     this.field_70177_z = (float)(this.field_70177_z + p_70082_1_ * 0.15D);
/*  282 */     this.field_70125_A = (float)(this.field_70125_A - p_70082_2_ * 0.15D);
/*  283 */     if (this.field_70125_A < -90.0F) this.field_70125_A = -90.0F; 
/*  284 */     if (this.field_70125_A > 90.0F) this.field_70125_A = 90.0F;
/*      */     
/*  286 */     this.field_70127_C += this.field_70125_A - f1;
/*  287 */     this.field_70126_B += this.field_70177_z - f2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_70071_h_() {
/*  298 */     func_70030_z();
/*      */   }
/*      */   
/*      */   public void func_70030_z() {
/*  302 */     this.field_70170_p.field_72984_F.func_76320_a("entityBaseTick");
/*      */     
/*  304 */     if (this.field_70154_o != null && this.field_70154_o.field_70128_L) {
/*  305 */       this.field_70154_o = null;
/*      */     }
/*      */     
/*  308 */     this.field_70141_P = this.field_70140_Q;
/*  309 */     this.field_70169_q = this.field_70165_t;
/*  310 */     this.field_70167_r = this.field_70163_u;
/*  311 */     this.field_70166_s = this.field_70161_v;
/*  312 */     this.field_70127_C = this.field_70125_A;
/*  313 */     this.field_70126_B = this.field_70177_z;
/*      */     
/*  315 */     if (!this.field_70170_p.field_72995_K && this.field_70170_p instanceof WorldServer) {
/*  316 */       this.field_70170_p.field_72984_F.func_76320_a("portal");
/*  317 */       MinecraftServer minecraftServer = ((WorldServer)this.field_70170_p).func_73046_m();
/*  318 */       int i = func_82145_z();
/*      */       
/*  320 */       if (this.field_71087_bX) {
/*  321 */         if (minecraftServer.func_71255_r()) {
/*  322 */           if (this.field_70154_o == null && 
/*  323 */             this.field_82153_h++ >= i) {
/*  324 */             byte b; this.field_82153_h = i;
/*  325 */             this.field_71088_bW = func_82147_ab();
/*      */ 
/*      */ 
/*      */             
/*  329 */             if (this.field_70170_p.field_73011_w.field_76574_g == -1) {
/*  330 */               b = 0;
/*      */             } else {
/*  332 */               b = -1;
/*      */             } 
/*      */             
/*  335 */             func_71027_c(b);
/*      */           } 
/*      */           
/*  338 */           this.field_71087_bX = false;
/*      */         } 
/*      */       } else {
/*  341 */         if (this.field_82153_h > 0) this.field_82153_h -= 4; 
/*  342 */         if (this.field_82153_h < 0) this.field_82153_h = 0; 
/*      */       } 
/*  344 */       if (this.field_71088_bW > 0) this.field_71088_bW--; 
/*  345 */       this.field_70170_p.field_72984_F.func_76319_b();
/*      */     } 
/*      */     
/*  348 */     if (func_70051_ag() && !func_70090_H()) {
/*  349 */       int i = MathHelper.func_76128_c(this.field_70165_t);
/*  350 */       int j = MathHelper.func_76128_c(this.field_70163_u - 0.20000000298023224D - this.field_70129_M);
/*  351 */       int k = MathHelper.func_76128_c(this.field_70161_v);
/*  352 */       Block block = this.field_70170_p.func_147439_a(i, j, k);
/*      */       
/*  354 */       if (block.func_149688_o() != Material.field_151579_a) {
/*  355 */         this.field_70170_p.func_72869_a("blockcrack_" + Block.func_149682_b(block) + "_" + this.field_70170_p.func_72805_g(i, j, k), this.field_70165_t + (this.field_70146_Z.nextFloat() - 0.5D) * this.field_70130_N, this.field_70121_D.field_72338_b + 0.1D, this.field_70161_v + (this.field_70146_Z.nextFloat() - 0.5D) * this.field_70130_N, -this.field_70159_w * 4.0D, 1.5D, -this.field_70179_y * 4.0D);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  360 */     func_70072_I();
/*      */     
/*  362 */     if (this.field_70170_p.field_72995_K) {
/*  363 */       this.field_70151_c = 0;
/*      */     }
/*  365 */     else if (this.field_70151_c > 0) {
/*  366 */       if (this.field_70178_ae) {
/*  367 */         this.field_70151_c -= 4;
/*  368 */         if (this.field_70151_c < 0) this.field_70151_c = 0; 
/*      */       } else {
/*  370 */         if (this.field_70151_c % 20 == 0) {
/*  371 */           func_70097_a(DamageSource.field_76370_b, 1.0F);
/*      */         }
/*  373 */         this.field_70151_c--;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  378 */     if (func_70058_J()) {
/*  379 */       func_70044_A();
/*  380 */       this.field_70143_R *= 0.5F;
/*      */     } 
/*      */     
/*  383 */     if (this.field_70163_u < -64.0D) {
/*  384 */       func_70076_C();
/*      */     }
/*      */     
/*  387 */     if (!this.field_70170_p.field_72995_K) {
/*  388 */       func_70052_a(0, (this.field_70151_c > 0));
/*      */     }
/*      */     
/*  391 */     this.field_70148_d = false;
/*      */     
/*  393 */     this.field_70170_p.field_72984_F.func_76319_b();
/*      */   }
/*      */   
/*      */   public int func_82145_z() {
/*  397 */     return 0;
/*      */   }
/*      */   
/*      */   protected void func_70044_A() {
/*  401 */     if (!this.field_70178_ae) {
/*      */       
/*  403 */       func_70097_a(DamageSource.field_76371_c, 4.0F);
/*  404 */       func_70015_d(15);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void func_70015_d(int p_70015_1_) {
/*  409 */     int i = p_70015_1_ * 20;
/*  410 */     i = EnchantmentProtection.func_92093_a(this, i);
/*  411 */     if (this.field_70151_c < i) {
/*  412 */       this.field_70151_c = i;
/*      */     }
/*      */   }
/*      */   
/*      */   public void func_70066_B() {
/*  417 */     this.field_70151_c = 0;
/*      */   }
/*      */   
/*      */   protected void func_70076_C() {
/*  421 */     func_70106_y();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean func_70038_c(double p_70038_1_, double p_70038_3_, double p_70038_5_) {
/*  433 */     AxisAlignedBB axisAlignedBB = this.field_70121_D.func_72325_c(p_70038_1_, p_70038_3_, p_70038_5_);
/*  434 */     List list = this.field_70170_p.func_72945_a(this, axisAlignedBB);
/*  435 */     if (!list.isEmpty()) return false; 
/*  436 */     if (this.field_70170_p.func_72953_d(axisAlignedBB)) return false; 
/*  437 */     return true;
/*      */   }
/*      */   
/*      */   public void func_70091_d(double p_70091_1_, double p_70091_3_, double p_70091_5_) {
/*  441 */     if (this.field_70145_X) {
/*  442 */       this.field_70121_D.func_72317_d(p_70091_1_, p_70091_3_, p_70091_5_);
/*  443 */       this.field_70165_t = (this.field_70121_D.field_72340_a + this.field_70121_D.field_72336_d) / 2.0D;
/*  444 */       this.field_70163_u = this.field_70121_D.field_72338_b + this.field_70129_M - this.field_70139_V;
/*  445 */       this.field_70161_v = (this.field_70121_D.field_72339_c + this.field_70121_D.field_72334_f) / 2.0D;
/*      */       
/*      */       return;
/*      */     } 
/*  449 */     this.field_70170_p.field_72984_F.func_76320_a("move");
/*      */     
/*  451 */     this.field_70139_V *= 0.4F;
/*      */     
/*  453 */     double d1 = this.field_70165_t;
/*  454 */     double d2 = this.field_70163_u;
/*  455 */     double d3 = this.field_70161_v;
/*      */     
/*  457 */     if (this.field_70134_J) {
/*  458 */       this.field_70134_J = false;
/*      */       
/*  460 */       p_70091_1_ *= 0.25D;
/*  461 */       p_70091_3_ *= 0.05000000074505806D;
/*  462 */       p_70091_5_ *= 0.25D;
/*  463 */       this.field_70159_w = 0.0D;
/*  464 */       this.field_70181_x = 0.0D;
/*  465 */       this.field_70179_y = 0.0D;
/*      */     } 
/*      */     
/*  468 */     double d4 = p_70091_1_;
/*  469 */     double d5 = p_70091_3_;
/*  470 */     double d6 = p_70091_5_;
/*      */     
/*  472 */     AxisAlignedBB axisAlignedBB = this.field_70121_D.func_72329_c();
/*      */     
/*  474 */     boolean bool = (this.field_70122_E && func_70093_af() && this instanceof EntityPlayer) ? true : false;
/*      */     
/*  476 */     if (bool) {
/*  477 */       double d = 0.05D;
/*  478 */       while (p_70091_1_ != 0.0D && this.field_70170_p.func_72945_a(this, this.field_70121_D.func_72325_c(p_70091_1_, -1.0D, 0.0D)).isEmpty()) {
/*  479 */         if (p_70091_1_ < d && p_70091_1_ >= -d) { p_70091_1_ = 0.0D; }
/*  480 */         else if (p_70091_1_ > 0.0D) { p_70091_1_ -= d; }
/*  481 */         else { p_70091_1_ += d; }
/*  482 */          d4 = p_70091_1_;
/*      */       } 
/*  484 */       while (p_70091_5_ != 0.0D && this.field_70170_p.func_72945_a(this, this.field_70121_D.func_72325_c(0.0D, -1.0D, p_70091_5_)).isEmpty()) {
/*  485 */         if (p_70091_5_ < d && p_70091_5_ >= -d) { p_70091_5_ = 0.0D; }
/*  486 */         else if (p_70091_5_ > 0.0D) { p_70091_5_ -= d; }
/*  487 */         else { p_70091_5_ += d; }
/*  488 */          d6 = p_70091_5_;
/*      */       } 
/*  490 */       while (p_70091_1_ != 0.0D && p_70091_5_ != 0.0D && this.field_70170_p.func_72945_a(this, this.field_70121_D.func_72325_c(p_70091_1_, -1.0D, p_70091_5_)).isEmpty()) {
/*  491 */         if (p_70091_1_ < d && p_70091_1_ >= -d) { p_70091_1_ = 0.0D; }
/*  492 */         else if (p_70091_1_ > 0.0D) { p_70091_1_ -= d; }
/*  493 */         else { p_70091_1_ += d; }
/*  494 */          if (p_70091_5_ < d && p_70091_5_ >= -d) { p_70091_5_ = 0.0D; }
/*  495 */         else if (p_70091_5_ > 0.0D) { p_70091_5_ -= d; }
/*  496 */         else { p_70091_5_ += d; }
/*  497 */          d4 = p_70091_1_;
/*  498 */         d6 = p_70091_5_;
/*      */       } 
/*      */     } 
/*      */     
/*  502 */     List<AxisAlignedBB> list = this.field_70170_p.func_72945_a(this, this.field_70121_D.func_72321_a(p_70091_1_, p_70091_3_, p_70091_5_));
/*      */     
/*      */     byte b1;
/*  505 */     for (b1 = 0; b1 < list.size(); b1++)
/*  506 */       p_70091_3_ = ((AxisAlignedBB)list.get(b1)).func_72323_b(this.field_70121_D, p_70091_3_); 
/*  507 */     this.field_70121_D.func_72317_d(0.0D, p_70091_3_, 0.0D);
/*      */     
/*  509 */     if (!this.field_70135_K && d5 != p_70091_3_) {
/*  510 */       p_70091_1_ = p_70091_3_ = p_70091_5_ = 0.0D;
/*      */     }
/*      */     
/*  513 */     b1 = (this.field_70122_E || (d5 != p_70091_3_ && d5 < 0.0D)) ? 1 : 0;
/*      */     byte b2;
/*  515 */     for (b2 = 0; b2 < list.size(); b2++) {
/*  516 */       p_70091_1_ = ((AxisAlignedBB)list.get(b2)).func_72316_a(this.field_70121_D, p_70091_1_);
/*      */     }
/*  518 */     this.field_70121_D.func_72317_d(p_70091_1_, 0.0D, 0.0D);
/*      */     
/*  520 */     if (!this.field_70135_K && d4 != p_70091_1_) {
/*  521 */       p_70091_1_ = p_70091_3_ = p_70091_5_ = 0.0D;
/*      */     }
/*      */     
/*  524 */     for (b2 = 0; b2 < list.size(); b2++)
/*  525 */       p_70091_5_ = ((AxisAlignedBB)list.get(b2)).func_72322_c(this.field_70121_D, p_70091_5_); 
/*  526 */     this.field_70121_D.func_72317_d(0.0D, 0.0D, p_70091_5_);
/*      */     
/*  528 */     if (!this.field_70135_K && d6 != p_70091_5_) {
/*  529 */       p_70091_1_ = p_70091_3_ = p_70091_5_ = 0.0D;
/*      */     }
/*      */     
/*  532 */     if (this.field_70138_W > 0.0F && b1 != 0 && (bool || this.field_70139_V < 0.05F) && (d4 != p_70091_1_ || d6 != p_70091_5_)) {
/*  533 */       double d10 = p_70091_1_;
/*  534 */       double d11 = p_70091_3_;
/*  535 */       double d12 = p_70091_5_;
/*      */       
/*  537 */       p_70091_1_ = d4;
/*  538 */       p_70091_3_ = this.field_70138_W;
/*  539 */       p_70091_5_ = d6;
/*      */       
/*  541 */       AxisAlignedBB axisAlignedBB1 = this.field_70121_D.func_72329_c();
/*  542 */       this.field_70121_D.func_72328_c(axisAlignedBB);
/*  543 */       list = this.field_70170_p.func_72945_a(this, this.field_70121_D.func_72321_a(p_70091_1_, p_70091_3_, p_70091_5_));
/*      */       
/*      */       byte b;
/*  546 */       for (b = 0; b < list.size(); b++)
/*  547 */         p_70091_3_ = ((AxisAlignedBB)list.get(b)).func_72323_b(this.field_70121_D, p_70091_3_); 
/*  548 */       this.field_70121_D.func_72317_d(0.0D, p_70091_3_, 0.0D);
/*      */       
/*  550 */       if (!this.field_70135_K && d5 != p_70091_3_) {
/*  551 */         p_70091_1_ = p_70091_3_ = p_70091_5_ = 0.0D;
/*      */       }
/*      */       
/*  554 */       for (b = 0; b < list.size(); b++)
/*  555 */         p_70091_1_ = ((AxisAlignedBB)list.get(b)).func_72316_a(this.field_70121_D, p_70091_1_); 
/*  556 */       this.field_70121_D.func_72317_d(p_70091_1_, 0.0D, 0.0D);
/*      */       
/*  558 */       if (!this.field_70135_K && d4 != p_70091_1_) {
/*  559 */         p_70091_1_ = p_70091_3_ = p_70091_5_ = 0.0D;
/*      */       }
/*      */       
/*  562 */       for (b = 0; b < list.size(); b++)
/*  563 */         p_70091_5_ = ((AxisAlignedBB)list.get(b)).func_72322_c(this.field_70121_D, p_70091_5_); 
/*  564 */       this.field_70121_D.func_72317_d(0.0D, 0.0D, p_70091_5_);
/*      */       
/*  566 */       if (!this.field_70135_K && d6 != p_70091_5_) {
/*  567 */         p_70091_1_ = p_70091_3_ = p_70091_5_ = 0.0D;
/*      */       }
/*      */ 
/*      */       
/*  571 */       p_70091_1_ = p_70091_3_ = p_70091_5_ = 0.0D;
/*      */       
/*  573 */       p_70091_3_ = -this.field_70138_W;
/*      */       
/*  575 */       for (b = 0; b < list.size(); b++)
/*  576 */         p_70091_3_ = ((AxisAlignedBB)list.get(b)).func_72323_b(this.field_70121_D, p_70091_3_); 
/*  577 */       this.field_70121_D.func_72317_d(0.0D, p_70091_3_, 0.0D);
/*      */ 
/*      */       
/*  580 */       if (d10 * d10 + d12 * d12 >= p_70091_1_ * p_70091_1_ + p_70091_5_ * p_70091_5_) {
/*  581 */         p_70091_1_ = d10;
/*  582 */         p_70091_3_ = d11;
/*  583 */         p_70091_5_ = d12;
/*  584 */         this.field_70121_D.func_72328_c(axisAlignedBB1);
/*      */       } 
/*      */     } 
/*  587 */     this.field_70170_p.field_72984_F.func_76319_b();
/*  588 */     this.field_70170_p.field_72984_F.func_76320_a("rest");
/*      */     
/*  590 */     this.field_70165_t = (this.field_70121_D.field_72340_a + this.field_70121_D.field_72336_d) / 2.0D;
/*  591 */     this.field_70163_u = this.field_70121_D.field_72338_b + this.field_70129_M - this.field_70139_V;
/*  592 */     this.field_70161_v = (this.field_70121_D.field_72339_c + this.field_70121_D.field_72334_f) / 2.0D;
/*      */     
/*  594 */     this.field_70123_F = (d4 != p_70091_1_ || d6 != p_70091_5_);
/*  595 */     this.field_70124_G = (d5 != p_70091_3_);
/*  596 */     this.field_70122_E = (d5 != p_70091_3_ && d5 < 0.0D);
/*  597 */     this.field_70132_H = (this.field_70123_F || this.field_70124_G);
/*  598 */     func_70064_a(p_70091_3_, this.field_70122_E);
/*      */     
/*  600 */     if (d4 != p_70091_1_) this.field_70159_w = 0.0D; 
/*  601 */     if (d5 != p_70091_3_) this.field_70181_x = 0.0D; 
/*  602 */     if (d6 != p_70091_5_) this.field_70179_y = 0.0D;
/*      */     
/*  604 */     double d7 = this.field_70165_t - d1;
/*  605 */     double d8 = this.field_70163_u - d2;
/*  606 */     double d9 = this.field_70161_v - d3;
/*      */     
/*  608 */     if (func_70041_e_() && !bool && this.field_70154_o == null) {
/*  609 */       int i = MathHelper.func_76128_c(this.field_70165_t);
/*  610 */       int j = MathHelper.func_76128_c(this.field_70163_u - 0.20000000298023224D - this.field_70129_M);
/*  611 */       int k = MathHelper.func_76128_c(this.field_70161_v);
/*      */       
/*  613 */       Block block = this.field_70170_p.func_147439_a(i, j, k);
/*  614 */       int m = this.field_70170_p.func_147439_a(i, j - 1, k).func_149645_b();
/*  615 */       if (m == 11 || m == 32 || m == 21) {
/*  616 */         block = this.field_70170_p.func_147439_a(i, j - 1, k);
/*      */       }
/*  618 */       if (block != Blocks.field_150468_ap) {
/*  619 */         d8 = 0.0D;
/*      */       }
/*      */       
/*  622 */       this.field_70140_Q = (float)(this.field_70140_Q + MathHelper.func_76133_a(d7 * d7 + d9 * d9) * 0.6D);
/*  623 */       this.field_82151_R = (float)(this.field_82151_R + MathHelper.func_76133_a(d7 * d7 + d8 * d8 + d9 * d9) * 0.6D);
/*      */       
/*  625 */       if (this.field_82151_R > this.field_70150_b && block.func_149688_o() != Material.field_151579_a) {
/*  626 */         this.field_70150_b = (int)this.field_82151_R + 1;
/*  627 */         if (func_70090_H()) {
/*  628 */           float f = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w * 0.20000000298023224D + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y * 0.20000000298023224D) * 0.35F;
/*  629 */           if (f > 1.0F) f = 1.0F; 
/*  630 */           func_85030_a(func_145776_H(), f, 1.0F + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.4F);
/*      */         } 
/*  632 */         func_145780_a(i, j, k, block);
/*  633 */         block.func_149724_b(this.field_70170_p, i, j, k, this);
/*      */       } 
/*      */     } 
/*      */     
/*      */     try {
/*  638 */       func_145775_I();
/*  639 */     } catch (Throwable throwable) {
/*  640 */       CrashReport crashReport = CrashReport.func_85055_a(throwable, "Checking entity block collision");
/*  641 */       CrashReportCategory crashReportCategory = crashReport.func_85058_a("Entity being checked for collision");
/*      */       
/*  643 */       func_85029_a(crashReportCategory);
/*      */       
/*  645 */       throw new ReportedException(crashReport);
/*      */     } 
/*      */     
/*  648 */     boolean bool1 = func_70026_G();
/*  649 */     if (this.field_70170_p.func_147470_e(this.field_70121_D.func_72331_e(0.001D, 0.001D, 0.001D))) {
/*  650 */       func_70081_e(1);
/*  651 */       if (!bool1) {
/*  652 */         this.field_70151_c++;
/*  653 */         if (this.field_70151_c == 0) func_70015_d(8);
/*      */       
/*      */       } 
/*  656 */     } else if (this.field_70151_c <= 0) {
/*  657 */       this.field_70151_c = -this.field_70174_ab;
/*      */     } 
/*      */ 
/*      */     
/*  661 */     if (bool1 && this.field_70151_c > 0) {
/*  662 */       func_85030_a("random.fizz", 0.7F, 1.6F + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.4F);
/*  663 */       this.field_70151_c = -this.field_70174_ab;
/*      */     } 
/*      */     
/*  666 */     this.field_70170_p.field_72984_F.func_76319_b();
/*      */   }
/*      */   
/*      */   protected String func_145776_H() {
/*  670 */     return "game.neutral.swim";
/*      */   }
/*      */   
/*      */   protected void func_145775_I() {
/*  674 */     int i = MathHelper.func_76128_c(this.field_70121_D.field_72340_a + 0.001D);
/*  675 */     int j = MathHelper.func_76128_c(this.field_70121_D.field_72338_b + 0.001D);
/*  676 */     int k = MathHelper.func_76128_c(this.field_70121_D.field_72339_c + 0.001D);
/*  677 */     int m = MathHelper.func_76128_c(this.field_70121_D.field_72336_d - 0.001D);
/*  678 */     int n = MathHelper.func_76128_c(this.field_70121_D.field_72337_e - 0.001D);
/*  679 */     int i1 = MathHelper.func_76128_c(this.field_70121_D.field_72334_f - 0.001D);
/*      */     
/*  681 */     if (this.field_70170_p.func_72904_c(i, j, k, m, n, i1))
/*  682 */       for (int i2 = i; i2 <= m; i2++) {
/*  683 */         for (int i3 = j; i3 <= n; i3++) {
/*  684 */           for (int i4 = k; i4 <= i1; i4++) {
/*  685 */             Block block = this.field_70170_p.func_147439_a(i2, i3, i4);
/*      */             
/*      */             try {
/*  688 */               block.func_149670_a(this.field_70170_p, i2, i3, i4, this);
/*  689 */             } catch (Throwable throwable) {
/*  690 */               CrashReport crashReport = CrashReport.func_85055_a(throwable, "Colliding entity with block");
/*  691 */               CrashReportCategory crashReportCategory = crashReport.func_85058_a("Block being collided with");
/*      */               
/*  693 */               CrashReportCategory.func_147153_a(crashReportCategory, i2, i3, i4, block, this.field_70170_p.func_72805_g(i2, i3, i4));
/*      */               
/*  695 */               throw new ReportedException(crashReport);
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       }  
/*      */   }
/*      */   protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
/*  702 */     Block.SoundType soundType = p_145780_4_.field_149762_H;
/*  703 */     if (this.field_70170_p.func_147439_a(p_145780_1_, p_145780_2_ + 1, p_145780_3_) == Blocks.field_150431_aC) {
/*  704 */       soundType = Blocks.field_150431_aC.field_149762_H;
/*  705 */       func_85030_a(soundType.func_150498_e(), soundType.func_150497_c() * 0.15F, soundType.func_150494_d());
/*  706 */     } else if (!p_145780_4_.func_149688_o().func_76224_d()) {
/*  707 */       func_85030_a(soundType.func_150498_e(), soundType.func_150497_c() * 0.15F, soundType.func_150494_d());
/*      */     } 
/*      */   }
/*      */   
/*      */   public void func_85030_a(String p_85030_1_, float p_85030_2_, float p_85030_3_) {
/*  712 */     this.field_70170_p.func_72956_a(this, p_85030_1_, p_85030_2_, p_85030_3_);
/*      */   }
/*      */   
/*      */   protected boolean func_70041_e_() {
/*  716 */     return true;
/*      */   }
/*      */   
/*      */   protected void func_70064_a(double p_70064_1_, boolean p_70064_3_) {
/*  720 */     if (p_70064_3_)
/*  721 */     { if (this.field_70143_R > 0.0F) {
/*  722 */         func_70069_a(this.field_70143_R);
/*  723 */         this.field_70143_R = 0.0F;
/*      */       }
/*      */        }
/*  726 */     else if (p_70064_1_ < 0.0D) { this.field_70143_R = (float)(this.field_70143_R - p_70064_1_); }
/*      */   
/*      */   }
/*      */   
/*      */   public AxisAlignedBB func_70046_E() {
/*  731 */     return null;
/*      */   }
/*      */   
/*      */   protected void func_70081_e(int p_70081_1_) {
/*  735 */     if (!this.field_70178_ae) {
/*  736 */       func_70097_a(DamageSource.field_76372_a, p_70081_1_);
/*      */     }
/*      */   }
/*      */   
/*      */   public final boolean func_70045_F() {
/*  741 */     return this.field_70178_ae;
/*      */   }
/*      */   
/*      */   protected void func_70069_a(float p_70069_1_) {
/*  745 */     if (this.field_70153_n != null) this.field_70153_n.func_70069_a(p_70069_1_); 
/*      */   }
/*      */   
/*      */   public boolean func_70026_G() {
/*  749 */     return (this.field_70171_ac || this.field_70170_p.func_72951_B(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v)) || this.field_70170_p.func_72951_B(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u + this.field_70131_O), MathHelper.func_76128_c(this.field_70161_v)));
/*      */   }
/*      */   
/*      */   public boolean func_70090_H() {
/*  753 */     return this.field_70171_ac;
/*      */   }
/*      */   
/*      */   public boolean func_70072_I() {
/*  757 */     if (this.field_70170_p.func_72918_a(this.field_70121_D.func_72314_b(0.0D, -0.4000000059604645D, 0.0D).func_72331_e(0.001D, 0.001D, 0.001D), Material.field_151586_h, this)) {
/*  758 */       if (!this.field_70171_ac && !this.field_70148_d) {
/*  759 */         float f1 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w * 0.20000000298023224D + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y * 0.20000000298023224D) * 0.2F;
/*  760 */         if (f1 > 1.0F) f1 = 1.0F; 
/*  761 */         func_85030_a(func_145777_O(), f1, 1.0F + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.4F);
/*  762 */         float f2 = MathHelper.func_76128_c(this.field_70121_D.field_72338_b); byte b;
/*  763 */         for (b = 0; b < 1.0F + this.field_70130_N * 20.0F; b++) {
/*  764 */           float f3 = (this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * this.field_70130_N;
/*  765 */           float f4 = (this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * this.field_70130_N;
/*  766 */           this.field_70170_p.func_72869_a("bubble", this.field_70165_t + f3, (f2 + 1.0F), this.field_70161_v + f4, this.field_70159_w, this.field_70181_x - (this.field_70146_Z.nextFloat() * 0.2F), this.field_70179_y);
/*      */         } 
/*  768 */         for (b = 0; b < 1.0F + this.field_70130_N * 20.0F; b++) {
/*  769 */           float f3 = (this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * this.field_70130_N;
/*  770 */           float f4 = (this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * this.field_70130_N;
/*  771 */           this.field_70170_p.func_72869_a("splash", this.field_70165_t + f3, (f2 + 1.0F), this.field_70161_v + f4, this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*      */         } 
/*      */       } 
/*  774 */       this.field_70143_R = 0.0F;
/*  775 */       this.field_70171_ac = true;
/*  776 */       this.field_70151_c = 0;
/*      */     } else {
/*  778 */       this.field_70171_ac = false;
/*      */     } 
/*  780 */     return this.field_70171_ac;
/*      */   }
/*      */   
/*      */   protected String func_145777_O() {
/*  784 */     return "game.neutral.swim.splash";
/*      */   }
/*      */   
/*      */   public boolean func_70055_a(Material p_70055_1_) {
/*  788 */     double d = this.field_70163_u + func_70047_e();
/*  789 */     int i = MathHelper.func_76128_c(this.field_70165_t);
/*  790 */     int j = MathHelper.func_76141_d(MathHelper.func_76128_c(d));
/*  791 */     int k = MathHelper.func_76128_c(this.field_70161_v);
/*  792 */     Block block = this.field_70170_p.func_147439_a(i, j, k);
/*  793 */     if (block.func_149688_o() == p_70055_1_) {
/*  794 */       float f1 = BlockLiquid.func_149801_b(this.field_70170_p.func_72805_g(i, j, k)) - 0.11111111F;
/*  795 */       float f2 = (j + 1) - f1;
/*  796 */       return (d < f2);
/*      */     } 
/*  798 */     return false;
/*      */   }
/*      */   
/*      */   public float func_70047_e() {
/*  802 */     return 0.0F;
/*      */   }
/*      */   
/*      */   public boolean func_70058_J() {
/*  806 */     return this.field_70170_p.func_72875_a(this.field_70121_D.func_72314_b(-0.10000000149011612D, -0.4000000059604645D, -0.10000000149011612D), Material.field_151587_i);
/*      */   }
/*      */   
/*      */   public void func_70060_a(float p_70060_1_, float p_70060_2_, float p_70060_3_) {
/*  810 */     float f1 = p_70060_1_ * p_70060_1_ + p_70060_2_ * p_70060_2_;
/*  811 */     if (f1 < 1.0E-4F)
/*      */       return; 
/*  813 */     f1 = MathHelper.func_76129_c(f1);
/*  814 */     if (f1 < 1.0F) f1 = 1.0F; 
/*  815 */     f1 = p_70060_3_ / f1;
/*  816 */     p_70060_1_ *= f1;
/*  817 */     p_70060_2_ *= f1;
/*      */     
/*  819 */     float f2 = MathHelper.func_76126_a(this.field_70177_z * 3.1415927F / 180.0F);
/*  820 */     float f3 = MathHelper.func_76134_b(this.field_70177_z * 3.1415927F / 180.0F);
/*      */     
/*  822 */     this.field_70159_w += (p_70060_1_ * f3 - p_70060_2_ * f2);
/*  823 */     this.field_70179_y += (p_70060_2_ * f3 + p_70060_1_ * f2);
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public int func_70070_b(float p_70070_1_) {
/*  827 */     int i = MathHelper.func_76128_c(this.field_70165_t);
/*  828 */     int j = MathHelper.func_76128_c(this.field_70161_v);
/*      */     
/*  830 */     if (this.field_70170_p.func_72899_e(i, 0, j)) {
/*  831 */       double d = (this.field_70121_D.field_72337_e - this.field_70121_D.field_72338_b) * 0.66D;
/*  832 */       int k = MathHelper.func_76128_c(this.field_70163_u - this.field_70129_M + d);
/*  833 */       return this.field_70170_p.func_72802_i(i, k, j, 0);
/*      */     } 
/*  835 */     return 0;
/*      */   }
/*      */   
/*      */   public float func_70013_c(float p_70013_1_) {
/*  839 */     int i = MathHelper.func_76128_c(this.field_70165_t);
/*  840 */     int j = MathHelper.func_76128_c(this.field_70161_v);
/*  841 */     if (this.field_70170_p.func_72899_e(i, 0, j)) {
/*  842 */       double d = (this.field_70121_D.field_72337_e - this.field_70121_D.field_72338_b) * 0.66D;
/*  843 */       int k = MathHelper.func_76128_c(this.field_70163_u - this.field_70129_M + d);
/*  844 */       return this.field_70170_p.func_72801_o(i, k, j);
/*      */     } 
/*  846 */     return 0.0F;
/*      */   }
/*      */   
/*      */   public void func_70029_a(World p_70029_1_) {
/*  850 */     this.field_70170_p = p_70029_1_;
/*      */   }
/*      */   
/*      */   public void func_70080_a(double p_70080_1_, double p_70080_3_, double p_70080_5_, float p_70080_7_, float p_70080_8_) {
/*  854 */     this.field_70169_q = this.field_70165_t = p_70080_1_;
/*  855 */     this.field_70167_r = this.field_70163_u = p_70080_3_;
/*  856 */     this.field_70166_s = this.field_70161_v = p_70080_5_;
/*  857 */     this.field_70126_B = this.field_70177_z = p_70080_7_;
/*  858 */     this.field_70127_C = this.field_70125_A = p_70080_8_;
/*  859 */     this.field_70139_V = 0.0F;
/*      */     
/*  861 */     double d = (this.field_70126_B - p_70080_7_);
/*  862 */     if (d < -180.0D) this.field_70126_B += 360.0F; 
/*  863 */     if (d >= 180.0D) this.field_70126_B -= 360.0F; 
/*  864 */     func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*  865 */     func_70101_b(p_70080_7_, p_70080_8_);
/*      */   }
/*      */   
/*      */   public void func_70012_b(double p_70012_1_, double p_70012_3_, double p_70012_5_, float p_70012_7_, float p_70012_8_) {
/*  869 */     this.field_70142_S = this.field_70169_q = this.field_70165_t = p_70012_1_;
/*  870 */     this.field_70137_T = this.field_70167_r = this.field_70163_u = p_70012_3_ + this.field_70129_M;
/*  871 */     this.field_70136_U = this.field_70166_s = this.field_70161_v = p_70012_5_;
/*  872 */     this.field_70177_z = p_70012_7_;
/*  873 */     this.field_70125_A = p_70012_8_;
/*  874 */     func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*      */   }
/*      */   
/*      */   public float func_70032_d(Entity p_70032_1_) {
/*  878 */     float f1 = (float)(this.field_70165_t - p_70032_1_.field_70165_t);
/*  879 */     float f2 = (float)(this.field_70163_u - p_70032_1_.field_70163_u);
/*  880 */     float f3 = (float)(this.field_70161_v - p_70032_1_.field_70161_v);
/*  881 */     return MathHelper.func_76129_c(f1 * f1 + f2 * f2 + f3 * f3);
/*      */   }
/*      */   
/*      */   public double func_70092_e(double p_70092_1_, double p_70092_3_, double p_70092_5_) {
/*  885 */     double d1 = this.field_70165_t - p_70092_1_;
/*  886 */     double d2 = this.field_70163_u - p_70092_3_;
/*  887 */     double d3 = this.field_70161_v - p_70092_5_;
/*  888 */     return d1 * d1 + d2 * d2 + d3 * d3;
/*      */   }
/*      */   
/*      */   public double func_70011_f(double p_70011_1_, double p_70011_3_, double p_70011_5_) {
/*  892 */     double d1 = this.field_70165_t - p_70011_1_;
/*  893 */     double d2 = this.field_70163_u - p_70011_3_;
/*  894 */     double d3 = this.field_70161_v - p_70011_5_;
/*  895 */     return MathHelper.func_76133_a(d1 * d1 + d2 * d2 + d3 * d3);
/*      */   }
/*      */   
/*      */   public double func_70068_e(Entity p_70068_1_) {
/*  899 */     double d1 = this.field_70165_t - p_70068_1_.field_70165_t;
/*  900 */     double d2 = this.field_70163_u - p_70068_1_.field_70163_u;
/*  901 */     double d3 = this.field_70161_v - p_70068_1_.field_70161_v;
/*  902 */     return d1 * d1 + d2 * d2 + d3 * d3;
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_70100_b_(EntityPlayer p_70100_1_) {}
/*      */   
/*      */   public void func_70108_f(Entity p_70108_1_) {
/*  909 */     if (p_70108_1_.field_70153_n == this || p_70108_1_.field_70154_o == this)
/*      */       return; 
/*  911 */     double d1 = p_70108_1_.field_70165_t - this.field_70165_t;
/*  912 */     double d2 = p_70108_1_.field_70161_v - this.field_70161_v;
/*      */     
/*  914 */     double d3 = MathHelper.func_76132_a(d1, d2);
/*      */     
/*  916 */     if (d3 >= 0.009999999776482582D) {
/*  917 */       d3 = MathHelper.func_76133_a(d3);
/*  918 */       d1 /= d3;
/*  919 */       d2 /= d3;
/*      */       
/*  921 */       double d = 1.0D / d3;
/*  922 */       if (d > 1.0D) d = 1.0D; 
/*  923 */       d1 *= d;
/*  924 */       d2 *= d;
/*      */       
/*  926 */       d1 *= 0.05000000074505806D;
/*  927 */       d2 *= 0.05000000074505806D;
/*      */       
/*  929 */       d1 *= (1.0F - this.field_70144_Y);
/*  930 */       d2 *= (1.0F - this.field_70144_Y);
/*      */       
/*  932 */       func_70024_g(-d1, 0.0D, -d2);
/*  933 */       p_70108_1_.func_70024_g(d1, 0.0D, d2);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void func_70024_g(double p_70024_1_, double p_70024_3_, double p_70024_5_) {
/*  938 */     this.field_70159_w += p_70024_1_;
/*  939 */     this.field_70181_x += p_70024_3_;
/*  940 */     this.field_70179_y += p_70024_5_;
/*  941 */     this.field_70160_al = true;
/*      */   }
/*      */   
/*      */   protected void func_70018_K() {
/*  945 */     this.field_70133_I = true;
/*      */   }
/*      */   
/*      */   public boolean func_70097_a(DamageSource p_70097_1_, float p_70097_2_) {
/*  949 */     if (func_85032_ar()) return false; 
/*  950 */     func_70018_K();
/*  951 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean func_70067_L() {
/*  959 */     return false;
/*      */   }
/*      */   
/*      */   public boolean func_70104_M() {
/*  963 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_70084_c(Entity p_70084_1_, int p_70084_2_) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public boolean func_145770_h(double p_145770_1_, double p_145770_3_, double p_145770_5_) {
/*  982 */     double d1 = this.field_70165_t - p_145770_1_;
/*  983 */     double d2 = this.field_70163_u - p_145770_3_;
/*  984 */     double d3 = this.field_70161_v - p_145770_5_;
/*  985 */     double d4 = d1 * d1 + d2 * d2 + d3 * d3;
/*  986 */     return func_70112_a(d4);
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public boolean func_70112_a(double p_70112_1_) {
/*  990 */     double d = this.field_70121_D.func_72320_b();
/*  991 */     d *= 64.0D * this.field_70155_l;
/*  992 */     return (p_70112_1_ < d * d);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean func_98035_c(NBTTagCompound p_98035_1_) {
/* 1000 */     String str = func_70022_Q();
/* 1001 */     if (this.field_70128_L || str == null) {
/* 1002 */       return false;
/*      */     }
/* 1004 */     p_98035_1_.func_74778_a("id", str);
/* 1005 */     func_70109_d(p_98035_1_);
/* 1006 */     return true;
/*      */   }
/*      */   
/*      */   public boolean func_70039_c(NBTTagCompound p_70039_1_) {
/* 1010 */     String str = func_70022_Q();
/* 1011 */     if (this.field_70128_L || str == null || this.field_70153_n != null) {
/* 1012 */       return false;
/*      */     }
/* 1014 */     p_70039_1_.func_74778_a("id", str);
/* 1015 */     func_70109_d(p_70039_1_);
/* 1016 */     return true;
/*      */   }
/*      */   
/*      */   public void func_70109_d(NBTTagCompound p_70109_1_) {
/*      */     try {
/* 1021 */       p_70109_1_.func_74782_a("Pos", (NBTBase)func_70087_a(new double[] { this.field_70165_t, this.field_70163_u + this.field_70139_V, this.field_70161_v }));
/* 1022 */       p_70109_1_.func_74782_a("Motion", (NBTBase)func_70087_a(new double[] { this.field_70159_w, this.field_70181_x, this.field_70179_y }));
/* 1023 */       p_70109_1_.func_74782_a("Rotation", (NBTBase)func_70049_a(new float[] { this.field_70177_z, this.field_70125_A }));
/*      */       
/* 1025 */       p_70109_1_.func_74776_a("FallDistance", this.field_70143_R);
/* 1026 */       p_70109_1_.func_74777_a("Fire", (short)this.field_70151_c);
/* 1027 */       p_70109_1_.func_74777_a("Air", (short)func_70086_ai());
/* 1028 */       p_70109_1_.func_74757_a("OnGround", this.field_70122_E);
/* 1029 */       p_70109_1_.func_74768_a("Dimension", this.field_71093_bK);
/* 1030 */       p_70109_1_.func_74757_a("Invulnerable", this.field_83001_bt);
/* 1031 */       p_70109_1_.func_74768_a("PortalCooldown", this.field_71088_bW);
/*      */       
/* 1033 */       p_70109_1_.func_74772_a("UUIDMost", func_110124_au().getMostSignificantBits());
/* 1034 */       p_70109_1_.func_74772_a("UUIDLeast", func_110124_au().getLeastSignificantBits());
/*      */       
/* 1036 */       func_70014_b(p_70109_1_);
/*      */       
/* 1038 */       if (this.field_70154_o != null) {
/* 1039 */         NBTTagCompound nBTTagCompound = new NBTTagCompound();
/* 1040 */         if (this.field_70154_o.func_98035_c(nBTTagCompound)) {
/* 1041 */           p_70109_1_.func_74782_a("Riding", (NBTBase)nBTTagCompound);
/*      */         }
/*      */       } 
/* 1044 */     } catch (Throwable throwable) {
/* 1045 */       CrashReport crashReport = CrashReport.func_85055_a(throwable, "Saving entity NBT");
/* 1046 */       CrashReportCategory crashReportCategory = crashReport.func_85058_a("Entity being saved");
/* 1047 */       func_85029_a(crashReportCategory);
/* 1048 */       throw new ReportedException(crashReport);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void func_70020_e(NBTTagCompound p_70020_1_) {
/*      */     try {
/* 1054 */       NBTTagList nBTTagList1 = p_70020_1_.func_150295_c("Pos", 6);
/* 1055 */       NBTTagList nBTTagList2 = p_70020_1_.func_150295_c("Motion", 6);
/* 1056 */       NBTTagList nBTTagList3 = p_70020_1_.func_150295_c("Rotation", 5);
/*      */       
/* 1058 */       this.field_70159_w = nBTTagList2.func_150309_d(0);
/* 1059 */       this.field_70181_x = nBTTagList2.func_150309_d(1);
/* 1060 */       this.field_70179_y = nBTTagList2.func_150309_d(2);
/*      */       
/* 1062 */       if (Math.abs(this.field_70159_w) > 10.0D) {
/* 1063 */         this.field_70159_w = 0.0D;
/*      */       }
/* 1065 */       if (Math.abs(this.field_70181_x) > 10.0D) {
/* 1066 */         this.field_70181_x = 0.0D;
/*      */       }
/* 1068 */       if (Math.abs(this.field_70179_y) > 10.0D) {
/* 1069 */         this.field_70179_y = 0.0D;
/*      */       }
/*      */       
/* 1072 */       this.field_70169_q = this.field_70142_S = this.field_70165_t = nBTTagList1.func_150309_d(0);
/* 1073 */       this.field_70167_r = this.field_70137_T = this.field_70163_u = nBTTagList1.func_150309_d(1);
/* 1074 */       this.field_70166_s = this.field_70136_U = this.field_70161_v = nBTTagList1.func_150309_d(2);
/*      */       
/* 1076 */       this.field_70126_B = this.field_70177_z = nBTTagList3.func_150308_e(0);
/* 1077 */       this.field_70127_C = this.field_70125_A = nBTTagList3.func_150308_e(1);
/*      */       
/* 1079 */       this.field_70143_R = p_70020_1_.func_74760_g("FallDistance");
/* 1080 */       this.field_70151_c = p_70020_1_.func_74765_d("Fire");
/* 1081 */       func_70050_g(p_70020_1_.func_74765_d("Air"));
/* 1082 */       this.field_70122_E = p_70020_1_.func_74767_n("OnGround");
/* 1083 */       this.field_71093_bK = p_70020_1_.func_74762_e("Dimension");
/* 1084 */       this.field_83001_bt = p_70020_1_.func_74767_n("Invulnerable");
/* 1085 */       this.field_71088_bW = p_70020_1_.func_74762_e("PortalCooldown");
/*      */       
/* 1087 */       if (p_70020_1_.func_150297_b("UUIDMost", 4) && p_70020_1_.func_150297_b("UUIDLeast", 4)) {
/* 1088 */         this.field_96093_i = new UUID(p_70020_1_.func_74763_f("UUIDMost"), p_70020_1_.func_74763_f("UUIDLeast"));
/*      */       }
/*      */       
/* 1091 */       func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 1092 */       func_70101_b(this.field_70177_z, this.field_70125_A);
/*      */       
/* 1094 */       func_70037_a(p_70020_1_);
/*      */       
/* 1096 */       if (func_142008_O()) func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v); 
/* 1097 */     } catch (Throwable throwable) {
/* 1098 */       CrashReport crashReport = CrashReport.func_85055_a(throwable, "Loading entity NBT");
/* 1099 */       CrashReportCategory crashReportCategory = crashReport.func_85058_a("Entity being loaded");
/* 1100 */       func_85029_a(crashReportCategory);
/* 1101 */       throw new ReportedException(crashReport);
/*      */     } 
/*      */   }
/*      */   
/*      */   protected boolean func_142008_O() {
/* 1106 */     return true;
/*      */   }
/*      */   
/*      */   protected final String func_70022_Q() {
/* 1110 */     return EntityList.func_75621_b(this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_110123_P() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected NBTTagList func_70087_a(double... p_70087_1_) {
/* 1126 */     NBTTagList nBTTagList = new NBTTagList();
/* 1127 */     for (double d : p_70087_1_)
/* 1128 */       nBTTagList.func_74742_a((NBTBase)new NBTTagDouble(d)); 
/* 1129 */     return nBTTagList;
/*      */   }
/*      */ 
/*      */   
/*      */   protected NBTTagList func_70049_a(float... p_70049_1_) {
/* 1134 */     NBTTagList nBTTagList = new NBTTagList();
/* 1135 */     for (float f : p_70049_1_)
/* 1136 */       nBTTagList.func_74742_a((NBTBase)new NBTTagFloat(f)); 
/* 1137 */     return nBTTagList;
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public float func_70053_R() {
/* 1141 */     return this.field_70131_O / 2.0F;
/*      */   }
/*      */   
/*      */   public EntityItem func_145779_a(Item p_145779_1_, int p_145779_2_) {
/* 1145 */     return func_145778_a(p_145779_1_, p_145779_2_, 0.0F);
/*      */   }
/*      */   
/*      */   public EntityItem func_145778_a(Item p_145778_1_, int p_145778_2_, float p_145778_3_) {
/* 1149 */     return func_70099_a(new ItemStack(p_145778_1_, p_145778_2_, 0), p_145778_3_);
/*      */   }
/*      */   
/*      */   public EntityItem func_70099_a(ItemStack p_70099_1_, float p_70099_2_) {
/* 1153 */     if (p_70099_1_.field_77994_a == 0 || p_70099_1_.func_77973_b() == null) {
/* 1154 */       return null;
/*      */     }
/*      */     
/* 1157 */     EntityItem entityItem = new EntityItem(this.field_70170_p, this.field_70165_t, this.field_70163_u + p_70099_2_, this.field_70161_v, p_70099_1_);
/* 1158 */     entityItem.field_145804_b = 10;
/* 1159 */     this.field_70170_p.func_72838_d((Entity)entityItem);
/* 1160 */     return entityItem;
/*      */   }
/*      */   
/*      */   public boolean func_70089_S() {
/* 1164 */     return !this.field_70128_L;
/*      */   }
/*      */   
/*      */   public boolean func_70094_T() {
/* 1168 */     for (byte b = 0; b < 8; b++) {
/* 1169 */       float f1 = (((b >> 0) % 2) - 0.5F) * this.field_70130_N * 0.8F;
/* 1170 */       float f2 = (((b >> 1) % 2) - 0.5F) * 0.1F;
/* 1171 */       float f3 = (((b >> 2) % 2) - 0.5F) * this.field_70130_N * 0.8F;
/* 1172 */       int i = MathHelper.func_76128_c(this.field_70165_t + f1);
/* 1173 */       int j = MathHelper.func_76128_c(this.field_70163_u + func_70047_e() + f2);
/* 1174 */       int k = MathHelper.func_76128_c(this.field_70161_v + f3);
/* 1175 */       if (this.field_70170_p.func_147439_a(i, j, k).func_149721_r()) {
/* 1176 */         return true;
/*      */       }
/*      */     } 
/* 1179 */     return false;
/*      */   }
/*      */   
/*      */   public boolean func_130002_c(EntityPlayer p_130002_1_) {
/* 1183 */     return false;
/*      */   }
/*      */   
/*      */   public AxisAlignedBB func_70114_g(Entity p_70114_1_) {
/* 1187 */     return null;
/*      */   }
/*      */   
/*      */   public void func_70098_U() {
/* 1191 */     if (this.field_70154_o.field_70128_L) {
/* 1192 */       this.field_70154_o = null;
/*      */       return;
/*      */     } 
/* 1195 */     this.field_70159_w = 0.0D;
/* 1196 */     this.field_70181_x = 0.0D;
/* 1197 */     this.field_70179_y = 0.0D;
/* 1198 */     func_70071_h_();
/* 1199 */     if (this.field_70154_o == null)
/*      */       return; 
/* 1201 */     this.field_70154_o.func_70043_V();
/*      */     
/* 1203 */     this.field_70147_f += (this.field_70154_o.field_70177_z - this.field_70154_o.field_70126_B);
/* 1204 */     this.field_70149_e += (this.field_70154_o.field_70125_A - this.field_70154_o.field_70127_C);
/*      */     
/* 1206 */     while (this.field_70147_f >= 180.0D)
/* 1207 */       this.field_70147_f -= 360.0D; 
/* 1208 */     while (this.field_70147_f < -180.0D) {
/* 1209 */       this.field_70147_f += 360.0D;
/*      */     }
/* 1211 */     while (this.field_70149_e >= 180.0D)
/* 1212 */       this.field_70149_e -= 360.0D; 
/* 1213 */     while (this.field_70149_e < -180.0D) {
/* 1214 */       this.field_70149_e += 360.0D;
/*      */     }
/* 1216 */     double d1 = this.field_70147_f * 0.5D;
/* 1217 */     double d2 = this.field_70149_e * 0.5D;
/*      */     
/* 1219 */     float f = 10.0F;
/* 1220 */     if (d1 > f) d1 = f; 
/* 1221 */     if (d1 < -f) d1 = -f; 
/* 1222 */     if (d2 > f) d2 = f; 
/* 1223 */     if (d2 < -f) d2 = -f;
/*      */     
/* 1225 */     this.field_70147_f -= d1;
/* 1226 */     this.field_70149_e -= d2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_70043_V() {
/* 1235 */     if (this.field_70153_n == null) {
/*      */       return;
/*      */     }
/* 1238 */     this.field_70153_n.func_70107_b(this.field_70165_t, this.field_70163_u + func_70042_X() + this.field_70153_n.func_70033_W(), this.field_70161_v);
/*      */   }
/*      */   
/*      */   public double func_70033_W() {
/* 1242 */     return this.field_70129_M;
/*      */   }
/*      */   
/*      */   public double func_70042_X() {
/* 1246 */     return this.field_70131_O * 0.75D;
/*      */   }
/*      */   
/*      */   public void func_70078_a(Entity p_70078_1_) {
/* 1250 */     this.field_70149_e = 0.0D;
/* 1251 */     this.field_70147_f = 0.0D;
/*      */     
/* 1253 */     if (p_70078_1_ == null) {
/* 1254 */       if (this.field_70154_o != null) {
/* 1255 */         func_70012_b(this.field_70154_o.field_70165_t, this.field_70154_o.field_70121_D.field_72338_b + this.field_70154_o.field_70131_O, this.field_70154_o.field_70161_v, this.field_70177_z, this.field_70125_A);
/* 1256 */         this.field_70154_o.field_70153_n = null;
/*      */       } 
/* 1258 */       this.field_70154_o = null;
/*      */       return;
/*      */     } 
/* 1261 */     if (this.field_70154_o != null) {
/* 1262 */       this.field_70154_o.field_70153_n = null;
/*      */     }
/*      */ 
/*      */     
/* 1266 */     if (p_70078_1_ != null) {
/* 1267 */       Entity entity = p_70078_1_.field_70154_o;
/* 1268 */       while (entity != null) {
/* 1269 */         if (entity == this) {
/*      */           return;
/*      */         }
/*      */         
/* 1273 */         entity = entity.field_70154_o;
/*      */       } 
/*      */     } 
/* 1276 */     this.field_70154_o = p_70078_1_;
/* 1277 */     p_70078_1_.field_70153_n = this;
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public void func_70056_a(double p_70056_1_, double p_70056_3_, double p_70056_5_, float p_70056_7_, float p_70056_8_, int p_70056_9_) {
/* 1281 */     func_70107_b(p_70056_1_, p_70056_3_, p_70056_5_);
/* 1282 */     func_70101_b(p_70056_7_, p_70056_8_);
/*      */     
/* 1284 */     List<AxisAlignedBB> list = this.field_70170_p.func_72945_a(this, this.field_70121_D.func_72331_e(0.03125D, 0.0D, 0.03125D));
/* 1285 */     if (!list.isEmpty()) {
/* 1286 */       double d = 0.0D;
/* 1287 */       for (byte b = 0; b < list.size(); b++) {
/* 1288 */         AxisAlignedBB axisAlignedBB = list.get(b);
/* 1289 */         if (axisAlignedBB.field_72337_e > d) d = axisAlignedBB.field_72337_e;
/*      */       
/*      */       } 
/* 1292 */       p_70056_3_ += d - this.field_70121_D.field_72338_b;
/* 1293 */       func_70107_b(p_70056_1_, p_70056_3_, p_70056_5_);
/*      */     } 
/*      */   }
/*      */   
/*      */   public float func_70111_Y() {
/* 1298 */     return 0.1F;
/*      */   }
/*      */   
/*      */   public Vec3 func_70040_Z() {
/* 1302 */     return null;
/*      */   }
/*      */   
/*      */   public void func_70063_aa() {
/* 1306 */     if (this.field_71088_bW > 0) {
/* 1307 */       this.field_71088_bW = func_82147_ab();
/*      */       
/*      */       return;
/*      */     } 
/* 1311 */     double d1 = this.field_70169_q - this.field_70165_t;
/* 1312 */     double d2 = this.field_70166_s - this.field_70161_v;
/*      */     
/* 1314 */     if (!this.field_70170_p.field_72995_K && !this.field_71087_bX) {
/* 1315 */       this.field_82152_aq = Direction.func_82372_a(d1, d2);
/*      */     }
/*      */     
/* 1318 */     this.field_71087_bX = true;
/*      */   }
/*      */   
/*      */   public int func_82147_ab() {
/* 1322 */     return 300;
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public void func_70016_h(double p_70016_1_, double p_70016_3_, double p_70016_5_) {
/* 1326 */     this.field_70159_w = p_70016_1_;
/* 1327 */     this.field_70181_x = p_70016_3_;
/* 1328 */     this.field_70179_y = p_70016_5_;
/*      */   }
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public void func_70103_a(byte p_70103_1_) {}
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public void func_70057_ab() {}
/*      */   
/*      */   public ItemStack[] func_70035_c() {
/* 1338 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_70062_b(int p_70062_1_, ItemStack p_70062_2_) {}
/*      */ 
/*      */   
/*      */   public boolean func_70027_ad() {
/* 1346 */     boolean bool = (this.field_70170_p != null && this.field_70170_p.field_72995_K) ? true : false;
/*      */     
/* 1348 */     return (!this.field_70178_ae && (this.field_70151_c > 0 || (bool && func_70083_f(0))));
/*      */   }
/*      */   
/*      */   public boolean func_70115_ae() {
/* 1352 */     return (this.field_70154_o != null);
/*      */   }
/*      */   
/*      */   public boolean func_70093_af() {
/* 1356 */     return func_70083_f(1);
/*      */   }
/*      */   
/*      */   public void func_70095_a(boolean p_70095_1_) {
/* 1360 */     func_70052_a(1, p_70095_1_);
/*      */   }
/*      */   
/*      */   public boolean func_70051_ag() {
/* 1364 */     return func_70083_f(3);
/*      */   }
/*      */   
/*      */   public void func_70031_b(boolean p_70031_1_) {
/* 1368 */     func_70052_a(3, p_70031_1_);
/*      */   }
/*      */   
/*      */   public boolean func_82150_aj() {
/* 1372 */     return func_70083_f(5);
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public boolean func_98034_c(EntityPlayer p_98034_1_) {
/* 1376 */     return func_82150_aj();
/*      */   }
/*      */   
/*      */   public void func_82142_c(boolean p_82142_1_) {
/* 1380 */     func_70052_a(5, p_82142_1_);
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public boolean func_70113_ah() {
/* 1384 */     return func_70083_f(4);
/*      */   }
/*      */   
/*      */   public void func_70019_c(boolean p_70019_1_) {
/* 1388 */     func_70052_a(4, p_70019_1_);
/*      */   }
/*      */   
/*      */   protected boolean func_70083_f(int p_70083_1_) {
/* 1392 */     return ((this.field_70180_af.func_75683_a(0) & 1 << p_70083_1_) != 0);
/*      */   }
/*      */   
/*      */   protected void func_70052_a(int p_70052_1_, boolean p_70052_2_) {
/* 1396 */     byte b = this.field_70180_af.func_75683_a(0);
/* 1397 */     if (p_70052_2_) {
/* 1398 */       this.field_70180_af.func_75692_b(0, Byte.valueOf((byte)(b | 1 << p_70052_1_)));
/*      */     } else {
/* 1400 */       this.field_70180_af.func_75692_b(0, Byte.valueOf((byte)(b & (1 << p_70052_1_ ^ 0xFFFFFFFF))));
/*      */     } 
/*      */   }
/*      */   
/*      */   public int func_70086_ai() {
/* 1405 */     return this.field_70180_af.func_75693_b(1);
/*      */   }
/*      */   
/*      */   public void func_70050_g(int p_70050_1_) {
/* 1409 */     this.field_70180_af.func_75692_b(1, Short.valueOf((short)p_70050_1_));
/*      */   }
/*      */   
/*      */   public void func_70077_a(EntityLightningBolt p_70077_1_) {
/* 1413 */     func_70081_e(5);
/* 1414 */     this.field_70151_c++;
/* 1415 */     if (this.field_70151_c == 0) func_70015_d(8);
/*      */   
/*      */   }
/*      */   
/*      */   public void func_70074_a(EntityLivingBase p_70074_1_) {}
/*      */   
/*      */   protected boolean func_145771_j(double p_145771_1_, double p_145771_3_, double p_145771_5_) {
/* 1422 */     int i = MathHelper.func_76128_c(p_145771_1_);
/* 1423 */     int j = MathHelper.func_76128_c(p_145771_3_);
/* 1424 */     int k = MathHelper.func_76128_c(p_145771_5_);
/*      */     
/* 1426 */     double d1 = p_145771_1_ - i;
/* 1427 */     double d2 = p_145771_3_ - j;
/* 1428 */     double d3 = p_145771_5_ - k;
/*      */     
/* 1430 */     List list = this.field_70170_p.func_147461_a(this.field_70121_D);
/*      */     
/* 1432 */     if (!list.isEmpty() || this.field_70170_p.func_147469_q(i, j, k)) {
/* 1433 */       boolean bool1 = !this.field_70170_p.func_147469_q(i - 1, j, k) ? true : false;
/* 1434 */       boolean bool2 = !this.field_70170_p.func_147469_q(i + 1, j, k) ? true : false;
/* 1435 */       boolean bool3 = !this.field_70170_p.func_147469_q(i, j - 1, k) ? true : false;
/* 1436 */       boolean bool4 = !this.field_70170_p.func_147469_q(i, j + 1, k) ? true : false;
/* 1437 */       boolean bool5 = !this.field_70170_p.func_147469_q(i, j, k - 1) ? true : false;
/* 1438 */       boolean bool6 = !this.field_70170_p.func_147469_q(i, j, k + 1) ? true : false;
/*      */       
/* 1440 */       byte b = 3;
/* 1441 */       double d = 9999.0D;
/* 1442 */       if (bool1 && d1 < d) {
/* 1443 */         d = d1;
/* 1444 */         b = 0;
/*      */       } 
/* 1446 */       if (bool2 && 1.0D - d1 < d) {
/* 1447 */         d = 1.0D - d1;
/* 1448 */         b = 1;
/*      */       } 
/* 1450 */       if (bool4 && 1.0D - d2 < d) {
/* 1451 */         d = 1.0D - d2;
/* 1452 */         b = 3;
/*      */       } 
/* 1454 */       if (bool5 && d3 < d) {
/* 1455 */         d = d3;
/* 1456 */         b = 4;
/*      */       } 
/* 1458 */       if (bool6 && 1.0D - d3 < d) {
/* 1459 */         d = 1.0D - d3;
/* 1460 */         b = 5;
/*      */       } 
/*      */       
/* 1463 */       float f = this.field_70146_Z.nextFloat() * 0.2F + 0.1F;
/* 1464 */       if (b == 0) this.field_70159_w = -f; 
/* 1465 */       if (b == 1) this.field_70159_w = f;
/*      */       
/* 1467 */       if (b == 2) {
/* 1468 */         this.field_70181_x = -f;
/*      */       }
/* 1470 */       if (b == 3) this.field_70181_x = f;
/*      */       
/* 1472 */       if (b == 4) this.field_70179_y = -f; 
/* 1473 */       if (b == 5) this.field_70179_y = f; 
/* 1474 */       return true;
/*      */     } 
/*      */     
/* 1477 */     return false;
/*      */   }
/*      */   
/*      */   public void func_70110_aj() {
/* 1481 */     this.field_70134_J = true;
/* 1482 */     this.field_70143_R = 0.0F;
/*      */   }
/*      */ 
/*      */   
/*      */   public String func_70005_c_() {
/* 1487 */     String str = EntityList.func_75621_b(this);
/* 1488 */     if (str == null) str = "generic";
/*      */     
/* 1490 */     return StatCollector.func_74838_a("entity." + str + ".name");
/*      */   }
/*      */   
/*      */   public Entity[] func_70021_al() {
/* 1494 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean func_70028_i(Entity p_70028_1_) {
/* 1499 */     return (this == p_70028_1_);
/*      */   }
/*      */   
/*      */   public float func_70079_am() {
/* 1503 */     return 0.0F;
/*      */   }
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public void func_70034_d(float p_70034_1_) {}
/*      */   
/*      */   public boolean func_70075_an() {
/* 1510 */     return true;
/*      */   }
/*      */   
/*      */   public boolean func_85031_j(Entity p_85031_1_) {
/* 1514 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public String toString() {
/* 1519 */     return String.format("%s['%s'/%d, l='%s', x=%.2f, y=%.2f, z=%.2f]", new Object[] { getClass().getSimpleName(), func_70005_c_(), Integer.valueOf(this.field_145783_c), (this.field_70170_p == null) ? "~NULL~" : this.field_70170_p.func_72912_H().func_76065_j(), Double.valueOf(this.field_70165_t), Double.valueOf(this.field_70163_u), Double.valueOf(this.field_70161_v) });
/*      */   }
/*      */   
/*      */   public boolean func_85032_ar() {
/* 1523 */     return this.field_83001_bt;
/*      */   }
/*      */   
/*      */   public void func_82149_j(Entity p_82149_1_) {
/* 1527 */     func_70012_b(p_82149_1_.field_70165_t, p_82149_1_.field_70163_u, p_82149_1_.field_70161_v, p_82149_1_.field_70177_z, p_82149_1_.field_70125_A);
/*      */   }
/*      */   
/*      */   public void func_82141_a(Entity p_82141_1_, boolean p_82141_2_) {
/* 1531 */     NBTTagCompound nBTTagCompound = new NBTTagCompound();
/* 1532 */     p_82141_1_.func_70109_d(nBTTagCompound);
/* 1533 */     func_70020_e(nBTTagCompound);
/* 1534 */     this.field_71088_bW = p_82141_1_.field_71088_bW;
/* 1535 */     this.field_82152_aq = p_82141_1_.field_82152_aq;
/*      */   }
/*      */   
/*      */   public void func_71027_c(int p_71027_1_) {
/* 1539 */     if (this.field_70170_p.field_72995_K || this.field_70128_L)
/* 1540 */       return;  this.field_70170_p.field_72984_F.func_76320_a("changeDimension");
/*      */     
/* 1542 */     MinecraftServer minecraftServer = MinecraftServer.func_71276_C();
/* 1543 */     int i = this.field_71093_bK;
/* 1544 */     WorldServer worldServer1 = minecraftServer.func_71218_a(i);
/* 1545 */     WorldServer worldServer2 = minecraftServer.func_71218_a(p_71027_1_);
/* 1546 */     this.field_71093_bK = p_71027_1_;
/*      */     
/* 1548 */     if (i == 1 && p_71027_1_ == 1) {
/* 1549 */       worldServer2 = minecraftServer.func_71218_a(0);
/* 1550 */       this.field_71093_bK = 0;
/*      */     } 
/*      */     
/* 1553 */     this.field_70170_p.func_72900_e(this);
/* 1554 */     this.field_70128_L = false;
/* 1555 */     this.field_70170_p.field_72984_F.func_76320_a("reposition");
/* 1556 */     minecraftServer.func_71203_ab().func_82448_a(this, i, worldServer1, worldServer2);
/* 1557 */     this.field_70170_p.field_72984_F.func_76318_c("reloading");
/* 1558 */     Entity entity = EntityList.func_75620_a(EntityList.func_75621_b(this), (World)worldServer2);
/*      */     
/* 1560 */     if (entity != null) {
/* 1561 */       entity.func_82141_a(this, true);
/*      */       
/* 1563 */       if (i == 1 && p_71027_1_ == 1) {
/* 1564 */         ChunkCoordinates chunkCoordinates = worldServer2.func_72861_E();
/* 1565 */         chunkCoordinates.field_71572_b = this.field_70170_p.func_72825_h(chunkCoordinates.field_71574_a, chunkCoordinates.field_71573_c);
/* 1566 */         entity.func_70012_b(chunkCoordinates.field_71574_a, chunkCoordinates.field_71572_b, chunkCoordinates.field_71573_c, entity.field_70177_z, entity.field_70125_A);
/*      */       } 
/*      */       
/* 1569 */       worldServer2.func_72838_d(entity);
/*      */     } 
/*      */     
/* 1572 */     this.field_70128_L = true;
/* 1573 */     this.field_70170_p.field_72984_F.func_76319_b();
/*      */     
/* 1575 */     worldServer1.func_82742_i();
/* 1576 */     worldServer2.func_82742_i();
/* 1577 */     this.field_70170_p.field_72984_F.func_76319_b();
/*      */   }
/*      */   
/*      */   public float func_145772_a(Explosion p_145772_1_, World p_145772_2_, int p_145772_3_, int p_145772_4_, int p_145772_5_, Block p_145772_6_) {
/* 1581 */     return p_145772_6_.func_149638_a(this);
/*      */   }
/*      */   
/*      */   public boolean func_145774_a(Explosion p_145774_1_, World p_145774_2_, int p_145774_3_, int p_145774_4_, int p_145774_5_, Block p_145774_6_, float p_145774_7_) {
/* 1585 */     return true;
/*      */   }
/*      */   
/*      */   public int func_82143_as() {
/* 1589 */     return 3;
/*      */   }
/*      */   
/*      */   public int func_82148_at() {
/* 1593 */     return this.field_82152_aq;
/*      */   }
/*      */   
/*      */   public boolean func_145773_az() {
/* 1597 */     return false;
/*      */   }
/*      */   
/*      */   public void func_85029_a(CrashReportCategory p_85029_1_) {
/* 1601 */     p_85029_1_.func_71500_a("Entity Type", new Callable(this) { private static final String __OBFID = "CL_00001534";
/*      */           
/*      */           public String call() {
/* 1604 */             return EntityList.func_75621_b(this.field_85155_a) + " (" + this.field_85155_a.getClass().getCanonicalName() + ")";
/*      */           } }
/*      */       );
/* 1607 */     p_85029_1_.func_71507_a("Entity ID", Integer.valueOf(this.field_145783_c));
/* 1608 */     p_85029_1_.func_71500_a("Entity Name", new Callable(this) { private static final String __OBFID = "CL_00001535";
/*      */           
/*      */           public String call() {
/* 1611 */             return this.field_96564_a.func_70005_c_();
/*      */           } }
/*      */       );
/* 1614 */     p_85029_1_.func_71507_a("Entity's Exact location", String.format("%.2f, %.2f, %.2f", new Object[] { Double.valueOf(this.field_70165_t), Double.valueOf(this.field_70163_u), Double.valueOf(this.field_70161_v) }));
/* 1615 */     p_85029_1_.func_71507_a("Entity's Block location", CrashReportCategory.func_85071_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v)));
/* 1616 */     p_85029_1_.func_71507_a("Entity's Momentum", String.format("%.2f, %.2f, %.2f", new Object[] { Double.valueOf(this.field_70159_w), Double.valueOf(this.field_70181_x), Double.valueOf(this.field_70179_y) }));
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public boolean func_90999_ad() {
/* 1620 */     return func_70027_ad();
/*      */   }
/*      */ 
/*      */   
/*      */   public UUID func_110124_au() {
/* 1625 */     return this.field_96093_i;
/*      */   }
/*      */   
/*      */   public boolean func_96092_aw() {
/* 1629 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public IChatComponent func_145748_c_() {
/* 1634 */     return (IChatComponent)new ChatComponentText(func_70005_c_());
/*      */   }
/*      */   
/*      */   public void func_145781_i(int p_145781_1_) {}
/*      */   
/*      */   protected abstract void func_70088_a();
/*      */   
/*      */   protected abstract void func_70037_a(NBTTagCompound paramNBTTagCompound);
/*      */   
/*      */   protected abstract void func_70014_b(NBTTagCompound paramNBTTagCompound);
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\Entity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */