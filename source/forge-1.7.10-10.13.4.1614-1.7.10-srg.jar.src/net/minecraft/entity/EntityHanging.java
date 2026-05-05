/*     */ package net.minecraft.entity;
/*     */ 
/*     */ import java.util.List;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.Direction;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public abstract class EntityHanging
/*     */   extends Entity
/*     */ {
/*     */   private int field_70520_f;
/*     */   public int field_82332_a;
/*     */   public int field_146063_b;
/*     */   
/*     */   public EntityHanging(World p_i1588_1_) {
/*  20 */     super(p_i1588_1_);
/*  21 */     this.field_70129_M = 0.0F;
/*  22 */     func_70105_a(0.5F, 0.5F);
/*     */   }
/*     */   public int field_146064_c; public int field_146062_d; private static final String __OBFID = "CL_00001546";
/*     */   public EntityHanging(World p_i1589_1_, int p_i1589_2_, int p_i1589_3_, int p_i1589_4_, int p_i1589_5_) {
/*  26 */     this(p_i1589_1_);
/*  27 */     this.field_146063_b = p_i1589_2_;
/*  28 */     this.field_146064_c = p_i1589_3_;
/*  29 */     this.field_146062_d = p_i1589_4_;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {}
/*     */ 
/*     */   
/*     */   public void func_82328_a(int p_82328_1_) {
/*  37 */     this.field_82332_a = p_82328_1_;
/*  38 */     this.field_70126_B = this.field_70177_z = (p_82328_1_ * 90);
/*     */     
/*  40 */     float f1 = func_82329_d();
/*  41 */     float f2 = func_82330_g();
/*  42 */     float f3 = func_82329_d();
/*     */     
/*  44 */     if (p_82328_1_ == 2 || p_82328_1_ == 0) {
/*  45 */       f3 = 0.5F;
/*  46 */       this.field_70177_z = this.field_70126_B = (Direction.field_71580_e[p_82328_1_] * 90);
/*     */     } else {
/*  48 */       f1 = 0.5F;
/*     */     } 
/*     */     
/*  51 */     f1 /= 32.0F;
/*  52 */     f2 /= 32.0F;
/*  53 */     f3 /= 32.0F;
/*     */     
/*  55 */     float f4 = this.field_146063_b + 0.5F;
/*  56 */     float f5 = this.field_146064_c + 0.5F;
/*  57 */     float f6 = this.field_146062_d + 0.5F;
/*     */     
/*  59 */     float f7 = 0.5625F;
/*     */     
/*  61 */     if (p_82328_1_ == 2) f6 -= f7; 
/*  62 */     if (p_82328_1_ == 1) f4 -= f7; 
/*  63 */     if (p_82328_1_ == 0) f6 += f7; 
/*  64 */     if (p_82328_1_ == 3) f4 += f7;
/*     */     
/*  66 */     if (p_82328_1_ == 2) f4 -= func_70517_b(func_82329_d()); 
/*  67 */     if (p_82328_1_ == 1) f6 += func_70517_b(func_82329_d()); 
/*  68 */     if (p_82328_1_ == 0) f4 += func_70517_b(func_82329_d()); 
/*  69 */     if (p_82328_1_ == 3) f6 -= func_70517_b(func_82329_d()); 
/*  70 */     f5 += func_70517_b(func_82330_g());
/*     */     
/*  72 */     func_70107_b(f4, f5, f6);
/*     */     
/*  74 */     float f8 = -0.03125F;
/*  75 */     this.field_70121_D.func_72324_b((f4 - f1 - f8), (f5 - f2 - f8), (f6 - f3 - f8), (f4 + f1 + f8), (f5 + f2 + f8), (f6 + f3 + f8));
/*     */   }
/*     */   
/*     */   private float func_70517_b(int p_70517_1_) {
/*  79 */     if (p_70517_1_ == 32) return 0.5F; 
/*  80 */     if (p_70517_1_ == 64) return 0.5F; 
/*  81 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/*  86 */     this.field_70169_q = this.field_70165_t;
/*  87 */     this.field_70167_r = this.field_70163_u;
/*  88 */     this.field_70166_s = this.field_70161_v;
/*  89 */     if (this.field_70520_f++ == 100 && !this.field_70170_p.field_72995_K) {
/*  90 */       this.field_70520_f = 0;
/*  91 */       if (!this.field_70128_L && !func_70518_d()) {
/*  92 */         func_70106_y();
/*  93 */         func_110128_b((Entity)null);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean func_70518_d() {
/*  99 */     if (!this.field_70170_p.func_72945_a(this, this.field_70121_D).isEmpty()) {
/* 100 */       return false;
/*     */     }
/* 102 */     int i = Math.max(1, func_82329_d() / 16);
/* 103 */     int j = Math.max(1, func_82330_g() / 16);
/*     */     
/* 105 */     int k = this.field_146063_b;
/* 106 */     int m = this.field_146064_c;
/* 107 */     int n = this.field_146062_d;
/* 108 */     if (this.field_82332_a == 2) k = MathHelper.func_76128_c(this.field_70165_t - (func_82329_d() / 32.0F)); 
/* 109 */     if (this.field_82332_a == 1) n = MathHelper.func_76128_c(this.field_70161_v - (func_82329_d() / 32.0F)); 
/* 110 */     if (this.field_82332_a == 0) k = MathHelper.func_76128_c(this.field_70165_t - (func_82329_d() / 32.0F)); 
/* 111 */     if (this.field_82332_a == 3) n = MathHelper.func_76128_c(this.field_70161_v - (func_82329_d() / 32.0F)); 
/* 112 */     m = MathHelper.func_76128_c(this.field_70163_u - (func_82330_g() / 32.0F));
/*     */     
/* 114 */     for (byte b = 0; b < i; b++) {
/* 115 */       for (byte b1 = 0; b1 < j; b1++) {
/*     */         Material material;
/* 117 */         if (this.field_82332_a == 2 || this.field_82332_a == 0) {
/* 118 */           material = this.field_70170_p.func_147439_a(k + b, m + b1, this.field_146062_d).func_149688_o();
/*     */         } else {
/* 120 */           material = this.field_70170_p.func_147439_a(this.field_146063_b, m + b1, n + b).func_149688_o();
/*     */         } 
/* 122 */         if (!material.func_76220_a())
/* 123 */           return false; 
/*     */       } 
/*     */     } 
/* 126 */     List list = this.field_70170_p.func_72839_b(this, this.field_70121_D);
/* 127 */     for (Entity entity : list) {
/* 128 */       if (entity instanceof EntityHanging) {
/* 129 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 133 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70067_L() {
/* 138 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_85031_j(Entity p_85031_1_) {
/* 143 */     if (p_85031_1_ instanceof EntityPlayer) {
/* 144 */       return func_70097_a(DamageSource.func_76365_a((EntityPlayer)p_85031_1_), 0.0F);
/*     */     }
/* 146 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_145781_i(int p_145781_1_) {
/* 151 */     this.field_70170_p.func_147450_X();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource p_70097_1_, float p_70097_2_) {
/* 156 */     if (func_85032_ar()) return false; 
/* 157 */     if (!this.field_70128_L && !this.field_70170_p.field_72995_K) {
/* 158 */       func_70106_y();
/* 159 */       func_70018_K();
/* 160 */       func_110128_b(p_70097_1_.func_76346_g());
/*     */     } 
/* 162 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70091_d(double p_70091_1_, double p_70091_3_, double p_70091_5_) {
/* 167 */     if (!this.field_70170_p.field_72995_K && !this.field_70128_L && p_70091_1_ * p_70091_1_ + p_70091_3_ * p_70091_3_ + p_70091_5_ * p_70091_5_ > 0.0D) {
/* 168 */       func_70106_y();
/* 169 */       func_110128_b((Entity)null);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70024_g(double p_70024_1_, double p_70024_3_, double p_70024_5_) {
/* 175 */     if (!this.field_70170_p.field_72995_K && !this.field_70128_L && p_70024_1_ * p_70024_1_ + p_70024_3_ * p_70024_3_ + p_70024_5_ * p_70024_5_ > 0.0D) {
/* 176 */       func_70106_y();
/* 177 */       func_110128_b((Entity)null);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound p_70014_1_) {
/* 183 */     p_70014_1_.func_74774_a("Direction", (byte)this.field_82332_a);
/* 184 */     p_70014_1_.func_74768_a("TileX", this.field_146063_b);
/* 185 */     p_70014_1_.func_74768_a("TileY", this.field_146064_c);
/* 186 */     p_70014_1_.func_74768_a("TileZ", this.field_146062_d);
/*     */ 
/*     */     
/* 189 */     switch (this.field_82332_a) {
/*     */       case 2:
/* 191 */         p_70014_1_.func_74774_a("Dir", (byte)0);
/*     */         break;
/*     */       case 1:
/* 194 */         p_70014_1_.func_74774_a("Dir", (byte)1);
/*     */         break;
/*     */       case 0:
/* 197 */         p_70014_1_.func_74774_a("Dir", (byte)2);
/*     */         break;
/*     */       case 3:
/* 200 */         p_70014_1_.func_74774_a("Dir", (byte)3);
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound p_70037_1_) {
/* 207 */     if (p_70037_1_.func_150297_b("Direction", 99)) {
/* 208 */       this.field_82332_a = p_70037_1_.func_74771_c("Direction");
/*     */     } else {
/* 210 */       switch (p_70037_1_.func_74771_c("Dir")) {
/*     */         case 0:
/* 212 */           this.field_82332_a = 2;
/*     */           break;
/*     */         case 1:
/* 215 */           this.field_82332_a = 1;
/*     */           break;
/*     */         case 2:
/* 218 */           this.field_82332_a = 0;
/*     */           break;
/*     */         case 3:
/* 221 */           this.field_82332_a = 3;
/*     */           break;
/*     */       } 
/*     */     } 
/* 225 */     this.field_146063_b = p_70037_1_.func_74762_e("TileX");
/* 226 */     this.field_146064_c = p_70037_1_.func_74762_e("TileY");
/* 227 */     this.field_146062_d = p_70037_1_.func_74762_e("TileZ");
/* 228 */     func_82328_a(this.field_82332_a);
/*     */   }
/*     */ 
/*     */   
/*     */   public abstract int func_82329_d();
/*     */   
/*     */   public abstract int func_82330_g();
/*     */   
/*     */   public abstract void func_110128_b(Entity paramEntity);
/*     */   
/*     */   protected boolean func_142008_O() {
/* 239 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\EntityHanging.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */