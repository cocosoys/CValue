/*     */ package net.minecraft.entity.projectile;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.item.EntityXPOrb;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemFishFood;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.stats.StatList;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.util.WeightedRandom;
/*     */ import net.minecraft.util.WeightedRandomFishable;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldServer;
/*     */ 
/*     */ public class EntityFishHook extends Entity {
/*  32 */   public static final List field_146039_d = Arrays.asList(new WeightedRandomFishable[] { (new WeightedRandomFishable(new ItemStack((Item)Items.field_151021_T), 10)).func_150709_a(0.9F), new WeightedRandomFishable(new ItemStack(Items.field_151116_aA), 10), new WeightedRandomFishable(new ItemStack(Items.field_151103_aS), 10), new WeightedRandomFishable(new ItemStack((Item)Items.field_151068_bn), 10), new WeightedRandomFishable(new ItemStack(Items.field_151007_F), 5), (new WeightedRandomFishable(new ItemStack((Item)Items.field_151112_aM), 2)).func_150709_a(0.9F), new WeightedRandomFishable(new ItemStack(Items.field_151054_z), 10), new WeightedRandomFishable(new ItemStack(Items.field_151055_y), 5), new WeightedRandomFishable(new ItemStack(Items.field_151100_aR, 10, 0), 1), new WeightedRandomFishable(new ItemStack((Block)Blocks.field_150479_bC), 10), new WeightedRandomFishable(new ItemStack(Items.field_151078_bh), 10) });
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
/*  45 */   public static final List field_146041_e = Arrays.asList(new WeightedRandomFishable[] { new WeightedRandomFishable(new ItemStack(Blocks.field_150392_bi), 1), new WeightedRandomFishable(new ItemStack(Items.field_151057_cb), 1), new WeightedRandomFishable(new ItemStack(Items.field_151141_av), 1), (new WeightedRandomFishable(new ItemStack((Item)Items.field_151031_f), 1)).func_150709_a(0.25F).func_150707_a(), (new WeightedRandomFishable(new ItemStack((Item)Items.field_151112_aM), 1)).func_150709_a(0.25F).func_150707_a(), (new WeightedRandomFishable(new ItemStack(Items.field_151122_aG), 1)).func_150707_a() });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  53 */   public static final List field_146036_f = Arrays.asList(new WeightedRandomFishable[] { new WeightedRandomFishable(new ItemStack(Items.field_151115_aP, 1, ItemFishFood.FishType.COD.func_150976_a()), 60), new WeightedRandomFishable(new ItemStack(Items.field_151115_aP, 1, ItemFishFood.FishType.SALMON.func_150976_a()), 25), new WeightedRandomFishable(new ItemStack(Items.field_151115_aP, 1, ItemFishFood.FishType.CLOWNFISH.func_150976_a()), 2), new WeightedRandomFishable(new ItemStack(Items.field_151115_aP, 1, ItemFishFood.FishType.PUFFERFISH.func_150976_a()), 13) });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  60 */   private int field_146037_g = -1;
/*  61 */   private int field_146048_h = -1; private Block field_146046_j; private boolean field_146051_au; public int field_146044_a; public EntityPlayer field_146042_b; private int field_146049_av; private int field_146047_aw; private int field_146045_ax; private int field_146040_ay; private int field_146038_az; private float field_146054_aA; public Entity field_146043_c;
/*  62 */   private int field_146050_i = -1; private int field_146055_aB; private double field_146056_aC;
/*     */   private double field_146057_aD;
/*     */   private double field_146058_aE;
/*     */   private double field_146059_aF;
/*     */   private double field_146060_aG;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private double field_146061_aH;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private double field_146052_aI;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private double field_146053_aJ;
/*     */   private static final String __OBFID = "CL_00001663";
/*     */   
/*     */   public EntityFishHook(World p_i1764_1_) {
/*  76 */     super(p_i1764_1_);
/*  77 */     func_70105_a(0.25F, 0.25F);
/*  78 */     this.field_70158_ak = true;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public EntityFishHook(World p_i1765_1_, double p_i1765_2_, double p_i1765_4_, double p_i1765_6_, EntityPlayer p_i1765_8_) {
/*  82 */     this(p_i1765_1_);
/*  83 */     func_70107_b(p_i1765_2_, p_i1765_4_, p_i1765_6_);
/*  84 */     this.field_70158_ak = true;
/*  85 */     this.field_146042_b = p_i1765_8_;
/*  86 */     p_i1765_8_.field_71104_cf = this;
/*     */   }
/*     */   
/*     */   public EntityFishHook(World p_i1766_1_, EntityPlayer p_i1766_2_) {
/*  90 */     super(p_i1766_1_);
/*  91 */     this.field_70158_ak = true;
/*  92 */     this.field_146042_b = p_i1766_2_;
/*  93 */     this.field_146042_b.field_71104_cf = this;
/*     */     
/*  95 */     func_70105_a(0.25F, 0.25F);
/*     */     
/*  97 */     func_70012_b(p_i1766_2_.field_70165_t, p_i1766_2_.field_70163_u + 1.62D - p_i1766_2_.field_70129_M, p_i1766_2_.field_70161_v, p_i1766_2_.field_70177_z, p_i1766_2_.field_70125_A);
/*     */     
/*  99 */     this.field_70165_t -= (MathHelper.func_76134_b(this.field_70177_z / 180.0F * 3.1415927F) * 0.16F);
/* 100 */     this.field_70163_u -= 0.10000000149011612D;
/* 101 */     this.field_70161_v -= (MathHelper.func_76126_a(this.field_70177_z / 180.0F * 3.1415927F) * 0.16F);
/* 102 */     func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 103 */     this.field_70129_M = 0.0F;
/*     */     
/* 105 */     float f = 0.4F;
/* 106 */     this.field_70159_w = (-MathHelper.func_76126_a(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F) * f);
/* 107 */     this.field_70179_y = (MathHelper.func_76134_b(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F) * f);
/* 108 */     this.field_70181_x = (-MathHelper.func_76126_a(this.field_70125_A / 180.0F * 3.1415927F) * f);
/*     */     
/* 110 */     func_146035_c(this.field_70159_w, this.field_70181_x, this.field_70179_y, 1.5F, 1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {}
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_70112_a(double p_70112_1_) {
/* 119 */     double d = this.field_70121_D.func_72320_b() * 4.0D;
/* 120 */     d *= 64.0D;
/* 121 */     return (p_70112_1_ < d * d);
/*     */   }
/*     */   
/*     */   public void func_146035_c(double p_146035_1_, double p_146035_3_, double p_146035_5_, float p_146035_7_, float p_146035_8_) {
/* 125 */     float f1 = MathHelper.func_76133_a(p_146035_1_ * p_146035_1_ + p_146035_3_ * p_146035_3_ + p_146035_5_ * p_146035_5_);
/*     */     
/* 127 */     p_146035_1_ /= f1;
/* 128 */     p_146035_3_ /= f1;
/* 129 */     p_146035_5_ /= f1;
/*     */     
/* 131 */     p_146035_1_ += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * p_146035_8_;
/* 132 */     p_146035_3_ += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * p_146035_8_;
/* 133 */     p_146035_5_ += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * p_146035_8_;
/*     */     
/* 135 */     p_146035_1_ *= p_146035_7_;
/* 136 */     p_146035_3_ *= p_146035_7_;
/* 137 */     p_146035_5_ *= p_146035_7_;
/*     */     
/* 139 */     this.field_70159_w = p_146035_1_;
/* 140 */     this.field_70181_x = p_146035_3_;
/* 141 */     this.field_70179_y = p_146035_5_;
/*     */     
/* 143 */     float f2 = MathHelper.func_76133_a(p_146035_1_ * p_146035_1_ + p_146035_5_ * p_146035_5_);
/*     */     
/* 145 */     this.field_70126_B = this.field_70177_z = (float)(Math.atan2(p_146035_1_, p_146035_5_) * 180.0D / 3.1415927410125732D);
/* 146 */     this.field_70127_C = this.field_70125_A = (float)(Math.atan2(p_146035_3_, f2) * 180.0D / 3.1415927410125732D);
/* 147 */     this.field_146049_av = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70056_a(double p_70056_1_, double p_70056_3_, double p_70056_5_, float p_70056_7_, float p_70056_8_, int p_70056_9_) {
/* 156 */     this.field_146056_aC = p_70056_1_;
/* 157 */     this.field_146057_aD = p_70056_3_;
/* 158 */     this.field_146058_aE = p_70056_5_;
/* 159 */     this.field_146059_aF = p_70056_7_;
/* 160 */     this.field_146060_aG = p_70056_8_;
/*     */     
/* 162 */     this.field_146055_aB = p_70056_9_;
/*     */     
/* 164 */     this.field_70159_w = this.field_146061_aH;
/* 165 */     this.field_70181_x = this.field_146052_aI;
/* 166 */     this.field_70179_y = this.field_146053_aJ;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70016_h(double p_70016_1_, double p_70016_3_, double p_70016_5_) {
/* 171 */     this.field_146061_aH = this.field_70159_w = p_70016_1_;
/* 172 */     this.field_146052_aI = this.field_70181_x = p_70016_3_;
/* 173 */     this.field_146053_aJ = this.field_70179_y = p_70016_5_;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/* 178 */     super.func_70071_h_();
/*     */     
/* 180 */     if (this.field_146055_aB > 0) {
/* 181 */       double d4 = this.field_70165_t + (this.field_146056_aC - this.field_70165_t) / this.field_146055_aB;
/* 182 */       double d5 = this.field_70163_u + (this.field_146057_aD - this.field_70163_u) / this.field_146055_aB;
/* 183 */       double d6 = this.field_70161_v + (this.field_146058_aE - this.field_70161_v) / this.field_146055_aB;
/*     */       
/* 185 */       double d7 = MathHelper.func_76138_g(this.field_146059_aF - this.field_70177_z);
/*     */       
/* 187 */       this.field_70177_z = (float)(this.field_70177_z + d7 / this.field_146055_aB);
/* 188 */       this.field_70125_A = (float)(this.field_70125_A + (this.field_146060_aG - this.field_70125_A) / this.field_146055_aB);
/*     */       
/* 190 */       this.field_146055_aB--;
/* 191 */       func_70107_b(d4, d5, d6);
/* 192 */       func_70101_b(this.field_70177_z, this.field_70125_A);
/*     */       
/*     */       return;
/*     */     } 
/* 196 */     if (!this.field_70170_p.field_72995_K) {
/* 197 */       ItemStack itemStack = this.field_146042_b.func_71045_bC();
/* 198 */       if (this.field_146042_b.field_70128_L || !this.field_146042_b.func_70089_S() || itemStack == null || itemStack.func_77973_b() != Items.field_151112_aM || func_70068_e((Entity)this.field_146042_b) > 1024.0D) {
/* 199 */         func_70106_y();
/* 200 */         this.field_146042_b.field_71104_cf = null;
/*     */         
/*     */         return;
/*     */       } 
/* 204 */       if (this.field_146043_c != null) {
/* 205 */         if (this.field_146043_c.field_70128_L) { this.field_146043_c = null; }
/*     */         else
/* 207 */         { this.field_70165_t = this.field_146043_c.field_70165_t;
/* 208 */           this.field_70163_u = this.field_146043_c.field_70121_D.field_72338_b + this.field_146043_c.field_70131_O * 0.8D;
/* 209 */           this.field_70161_v = this.field_146043_c.field_70161_v;
/*     */           
/*     */           return; }
/*     */       
/*     */       }
/*     */     } 
/* 215 */     if (this.field_146044_a > 0) this.field_146044_a--;
/*     */     
/* 217 */     if (this.field_146051_au) {
/* 218 */       if (this.field_70170_p.func_147439_a(this.field_146037_g, this.field_146048_h, this.field_146050_i) == this.field_146046_j) {
/* 219 */         this.field_146049_av++;
/* 220 */         if (this.field_146049_av == 1200) func_70106_y(); 
/*     */         return;
/*     */       } 
/* 223 */       this.field_146051_au = false;
/*     */       
/* 225 */       this.field_70159_w *= (this.field_70146_Z.nextFloat() * 0.2F);
/* 226 */       this.field_70181_x *= (this.field_70146_Z.nextFloat() * 0.2F);
/* 227 */       this.field_70179_y *= (this.field_70146_Z.nextFloat() * 0.2F);
/* 228 */       this.field_146049_av = 0;
/* 229 */       this.field_146047_aw = 0;
/*     */     } else {
/*     */       
/* 232 */       this.field_146047_aw++;
/*     */     } 
/*     */     
/* 235 */     Vec3 vec31 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 236 */     Vec3 vec32 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/* 237 */     MovingObjectPosition movingObjectPosition = this.field_70170_p.func_72933_a(vec31, vec32);
/*     */     
/* 239 */     vec31 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 240 */     vec32 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/* 241 */     if (movingObjectPosition != null) {
/* 242 */       vec32 = Vec3.func_72443_a(movingObjectPosition.field_72307_f.field_72450_a, movingObjectPosition.field_72307_f.field_72448_b, movingObjectPosition.field_72307_f.field_72449_c);
/*     */     }
/* 244 */     Entity entity = null;
/* 245 */     List<Entity> list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(1.0D, 1.0D, 1.0D));
/* 246 */     double d1 = 0.0D;
/* 247 */     for (byte b1 = 0; b1 < list.size(); b1++) {
/* 248 */       Entity entity1 = list.get(b1);
/* 249 */       if (entity1.func_70067_L() && (entity1 != this.field_146042_b || this.field_146047_aw >= 5)) {
/*     */         
/* 251 */         float f = 0.3F;
/* 252 */         AxisAlignedBB axisAlignedBB = entity1.field_70121_D.func_72314_b(f, f, f);
/* 253 */         MovingObjectPosition movingObjectPosition1 = axisAlignedBB.func_72327_a(vec31, vec32);
/* 254 */         if (movingObjectPosition1 != null) {
/* 255 */           double d = vec31.func_72438_d(movingObjectPosition1.field_72307_f);
/* 256 */           if (d < d1 || d1 == 0.0D) {
/* 257 */             entity = entity1;
/* 258 */             d1 = d;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 263 */     if (entity != null) {
/* 264 */       movingObjectPosition = new MovingObjectPosition(entity);
/*     */     }
/*     */     
/* 267 */     if (movingObjectPosition != null) {
/* 268 */       if (movingObjectPosition.field_72308_g != null) {
/* 269 */         if (movingObjectPosition.field_72308_g.func_70097_a(DamageSource.func_76356_a(this, (Entity)this.field_146042_b), 0.0F)) {
/* 270 */           this.field_146043_c = movingObjectPosition.field_72308_g;
/*     */         }
/*     */       } else {
/* 273 */         this.field_146051_au = true;
/*     */       } 
/*     */     }
/*     */     
/* 277 */     if (this.field_146051_au)
/*     */       return; 
/* 279 */     func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*     */     
/* 281 */     float f1 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 282 */     this.field_70177_z = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0D / 3.1415927410125732D);
/* 283 */     this.field_70125_A = (float)(Math.atan2(this.field_70181_x, f1) * 180.0D / 3.1415927410125732D);
/*     */     
/* 285 */     while (this.field_70125_A - this.field_70127_C < -180.0F)
/* 286 */       this.field_70127_C -= 360.0F; 
/* 287 */     while (this.field_70125_A - this.field_70127_C >= 180.0F) {
/* 288 */       this.field_70127_C += 360.0F;
/*     */     }
/* 290 */     while (this.field_70177_z - this.field_70126_B < -180.0F)
/* 291 */       this.field_70126_B -= 360.0F; 
/* 292 */     while (this.field_70177_z - this.field_70126_B >= 180.0F) {
/* 293 */       this.field_70126_B += 360.0F;
/*     */     }
/* 295 */     this.field_70125_A = this.field_70127_C + (this.field_70125_A - this.field_70127_C) * 0.2F;
/* 296 */     this.field_70177_z = this.field_70126_B + (this.field_70177_z - this.field_70126_B) * 0.2F;
/*     */     
/* 298 */     float f2 = 0.92F;
/*     */     
/* 300 */     if (this.field_70122_E || this.field_70123_F) {
/* 301 */       f2 = 0.5F;
/*     */     }
/*     */     
/* 304 */     byte b2 = 5;
/* 305 */     double d2 = 0.0D;
/* 306 */     for (byte b3 = 0; b3 < b2; b3++) {
/* 307 */       double d4 = this.field_70121_D.field_72338_b + (this.field_70121_D.field_72337_e - this.field_70121_D.field_72338_b) * (b3 + 0) / b2 - 0.125D + 0.125D;
/* 308 */       double d5 = this.field_70121_D.field_72338_b + (this.field_70121_D.field_72337_e - this.field_70121_D.field_72338_b) * (b3 + 1) / b2 - 0.125D + 0.125D;
/* 309 */       AxisAlignedBB axisAlignedBB = AxisAlignedBB.func_72330_a(this.field_70121_D.field_72340_a, d4, this.field_70121_D.field_72339_c, this.field_70121_D.field_72336_d, d5, this.field_70121_D.field_72334_f);
/* 310 */       if (this.field_70170_p.func_72830_b(axisAlignedBB, Material.field_151586_h)) {
/* 311 */         d2 += 1.0D / b2;
/*     */       }
/*     */     } 
/*     */     
/* 315 */     if (!this.field_70170_p.field_72995_K && d2 > 0.0D) {
/* 316 */       WorldServer worldServer = (WorldServer)this.field_70170_p;
/*     */       
/* 318 */       byte b = 1;
/* 319 */       if (this.field_70146_Z.nextFloat() < 0.25F && this.field_70170_p.func_72951_B(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u) + 1, MathHelper.func_76128_c(this.field_70161_v))) b = 2; 
/* 320 */       if (this.field_70146_Z.nextFloat() < 0.5F && !this.field_70170_p.func_72937_j(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u) + 1, MathHelper.func_76128_c(this.field_70161_v))) b--;
/*     */       
/* 322 */       if (this.field_146045_ax > 0) {
/* 323 */         this.field_146045_ax--;
/*     */         
/* 325 */         if (this.field_146045_ax <= 0) {
/* 326 */           this.field_146040_ay = 0;
/* 327 */           this.field_146038_az = 0;
/*     */         } 
/* 329 */       } else if (this.field_146038_az > 0) {
/* 330 */         this.field_146038_az -= b;
/*     */         
/* 332 */         if (this.field_146038_az <= 0) {
/* 333 */           this.field_70181_x -= 0.20000000298023224D;
/* 334 */           func_85030_a("random.splash", 0.25F, 1.0F + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.4F);
/* 335 */           float f = MathHelper.func_76128_c(this.field_70121_D.field_72338_b);
/* 336 */           worldServer.func_147487_a("bubble", this.field_70165_t, (f + 1.0F), this.field_70161_v, (int)(1.0F + this.field_70130_N * 20.0F), this.field_70130_N, 0.0D, this.field_70130_N, 0.20000000298023224D);
/* 337 */           worldServer.func_147487_a("wake", this.field_70165_t, (f + 1.0F), this.field_70161_v, (int)(1.0F + this.field_70130_N * 20.0F), this.field_70130_N, 0.0D, this.field_70130_N, 0.20000000298023224D);
/*     */           
/* 339 */           this.field_146045_ax = MathHelper.func_76136_a(this.field_70146_Z, 10, 30);
/*     */         } else {
/* 341 */           this.field_146054_aA = (float)(this.field_146054_aA + this.field_70146_Z.nextGaussian() * 4.0D);
/*     */           
/* 343 */           float f3 = this.field_146054_aA * 0.017453292F;
/* 344 */           float f4 = MathHelper.func_76126_a(f3);
/* 345 */           float f5 = MathHelper.func_76134_b(f3);
/* 346 */           double d4 = this.field_70165_t + (f4 * this.field_146038_az * 0.1F);
/* 347 */           double d5 = (MathHelper.func_76128_c(this.field_70121_D.field_72338_b) + 1.0F);
/* 348 */           double d6 = this.field_70161_v + (f5 * this.field_146038_az * 0.1F);
/*     */           
/* 350 */           if (this.field_70146_Z.nextFloat() < 0.15F) {
/* 351 */             worldServer.func_147487_a("bubble", d4, d5 - 0.10000000149011612D, d6, 1, f4, 0.1D, f5, 0.0D);
/*     */           }
/*     */           
/* 354 */           float f6 = f4 * 0.04F;
/* 355 */           float f7 = f5 * 0.04F;
/*     */           
/* 357 */           worldServer.func_147487_a("wake", d4, d5, d6, 0, f7, 0.01D, -f6, 1.0D);
/* 358 */           worldServer.func_147487_a("wake", d4, d5, d6, 0, -f7, 0.01D, f6, 1.0D);
/*     */         } 
/* 360 */       } else if (this.field_146040_ay > 0) {
/* 361 */         this.field_146040_ay -= b;
/*     */         
/* 363 */         float f = 0.15F;
/*     */         
/* 365 */         if (this.field_146040_ay < 20) {
/* 366 */           f = (float)(f + (20 - this.field_146040_ay) * 0.05D);
/* 367 */         } else if (this.field_146040_ay < 40) {
/* 368 */           f = (float)(f + (40 - this.field_146040_ay) * 0.02D);
/* 369 */         } else if (this.field_146040_ay < 60) {
/* 370 */           f = (float)(f + (60 - this.field_146040_ay) * 0.01D);
/*     */         } 
/*     */         
/* 373 */         if (this.field_70146_Z.nextFloat() < f) {
/* 374 */           float f3 = MathHelper.func_151240_a(this.field_70146_Z, 0.0F, 360.0F) * 0.017453292F;
/* 375 */           float f4 = MathHelper.func_151240_a(this.field_70146_Z, 25.0F, 60.0F);
/* 376 */           double d4 = this.field_70165_t + (MathHelper.func_76126_a(f3) * f4 * 0.1F);
/* 377 */           double d5 = (MathHelper.func_76128_c(this.field_70121_D.field_72338_b) + 1.0F);
/* 378 */           double d6 = this.field_70161_v + (MathHelper.func_76134_b(f3) * f4 * 0.1F);
/*     */           
/* 380 */           worldServer.func_147487_a("splash", d4, d5, d6, 2 + this.field_70146_Z.nextInt(2), 0.10000000149011612D, 0.0D, 0.10000000149011612D, 0.0D);
/*     */         } 
/*     */         
/* 383 */         if (this.field_146040_ay <= 0) {
/* 384 */           this.field_146054_aA = MathHelper.func_151240_a(this.field_70146_Z, 0.0F, 360.0F);
/* 385 */           this.field_146038_az = MathHelper.func_76136_a(this.field_70146_Z, 20, 80);
/*     */         } 
/*     */       } else {
/* 388 */         this.field_146040_ay = MathHelper.func_76136_a(this.field_70146_Z, 100, 900);
/* 389 */         this.field_146040_ay -= EnchantmentHelper.func_151387_h((EntityLivingBase)this.field_146042_b) * 20 * 5;
/*     */       } 
/*     */       
/* 392 */       if (this.field_146045_ax > 0) {
/* 393 */         this.field_70181_x -= (this.field_70146_Z.nextFloat() * this.field_70146_Z.nextFloat() * this.field_70146_Z.nextFloat()) * 0.2D;
/*     */       }
/*     */     } 
/*     */     
/* 397 */     double d3 = d2 * 2.0D - 1.0D;
/* 398 */     this.field_70181_x += 0.03999999910593033D * d3;
/* 399 */     if (d2 > 0.0D) {
/* 400 */       f2 = (float)(f2 * 0.9D);
/* 401 */       this.field_70181_x *= 0.8D;
/*     */     } 
/*     */     
/* 404 */     this.field_70159_w *= f2;
/* 405 */     this.field_70181_x *= f2;
/* 406 */     this.field_70179_y *= f2;
/*     */     
/* 408 */     func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound p_70014_1_) {
/* 413 */     p_70014_1_.func_74777_a("xTile", (short)this.field_146037_g);
/* 414 */     p_70014_1_.func_74777_a("yTile", (short)this.field_146048_h);
/* 415 */     p_70014_1_.func_74777_a("zTile", (short)this.field_146050_i);
/* 416 */     p_70014_1_.func_74774_a("inTile", (byte)Block.func_149682_b(this.field_146046_j));
/* 417 */     p_70014_1_.func_74774_a("shake", (byte)this.field_146044_a);
/* 418 */     p_70014_1_.func_74774_a("inGround", (byte)(this.field_146051_au ? 1 : 0));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound p_70037_1_) {
/* 423 */     this.field_146037_g = p_70037_1_.func_74765_d("xTile");
/* 424 */     this.field_146048_h = p_70037_1_.func_74765_d("yTile");
/* 425 */     this.field_146050_i = p_70037_1_.func_74765_d("zTile");
/* 426 */     this.field_146046_j = Block.func_149729_e(p_70037_1_.func_74771_c("inTile") & 0xFF);
/* 427 */     this.field_146044_a = p_70037_1_.func_74771_c("shake") & 0xFF;
/* 428 */     this.field_146051_au = (p_70037_1_.func_74771_c("inGround") == 1);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_70053_R() {
/* 433 */     return 0.0F;
/*     */   }
/*     */   
/*     */   public int func_146034_e() {
/* 437 */     if (this.field_70170_p.field_72995_K) return 0;
/*     */     
/* 439 */     byte b = 0;
/* 440 */     if (this.field_146043_c != null) {
/* 441 */       double d1 = this.field_146042_b.field_70165_t - this.field_70165_t;
/* 442 */       double d2 = this.field_146042_b.field_70163_u - this.field_70163_u;
/* 443 */       double d3 = this.field_146042_b.field_70161_v - this.field_70161_v;
/*     */       
/* 445 */       double d4 = MathHelper.func_76133_a(d1 * d1 + d2 * d2 + d3 * d3);
/* 446 */       double d5 = 0.1D;
/* 447 */       this.field_146043_c.field_70159_w += d1 * d5;
/* 448 */       this.field_146043_c.field_70181_x += d2 * d5 + MathHelper.func_76133_a(d4) * 0.08D;
/* 449 */       this.field_146043_c.field_70179_y += d3 * d5;
/* 450 */       b = 3;
/* 451 */     } else if (this.field_146045_ax > 0) {
/* 452 */       EntityItem entityItem = new EntityItem(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, func_146033_f());
/* 453 */       double d1 = this.field_146042_b.field_70165_t - this.field_70165_t;
/* 454 */       double d2 = this.field_146042_b.field_70163_u - this.field_70163_u;
/* 455 */       double d3 = this.field_146042_b.field_70161_v - this.field_70161_v;
/*     */       
/* 457 */       double d4 = MathHelper.func_76133_a(d1 * d1 + d2 * d2 + d3 * d3);
/* 458 */       double d5 = 0.1D;
/* 459 */       entityItem.field_70159_w = d1 * d5;
/* 460 */       entityItem.field_70181_x = d2 * d5 + MathHelper.func_76133_a(d4) * 0.08D;
/* 461 */       entityItem.field_70179_y = d3 * d5;
/* 462 */       this.field_70170_p.func_72838_d((Entity)entityItem);
/* 463 */       this.field_146042_b.field_70170_p.func_72838_d((Entity)new EntityXPOrb(this.field_146042_b.field_70170_p, this.field_146042_b.field_70165_t, this.field_146042_b.field_70163_u + 0.5D, this.field_146042_b.field_70161_v + 0.5D, this.field_70146_Z.nextInt(6) + 1));
/* 464 */       b = 1;
/*     */     } 
/* 466 */     if (this.field_146051_au) b = 2;
/*     */     
/* 468 */     func_70106_y();
/* 469 */     this.field_146042_b.field_71104_cf = null;
/* 470 */     return b;
/*     */   }
/*     */   
/*     */   private ItemStack func_146033_f() {
/* 474 */     float f1 = this.field_70170_p.field_73012_v.nextFloat();
/* 475 */     int i = EnchantmentHelper.func_151386_g((EntityLivingBase)this.field_146042_b);
/* 476 */     int j = EnchantmentHelper.func_151387_h((EntityLivingBase)this.field_146042_b);
/* 477 */     float f2 = 0.1F - i * 0.025F - j * 0.01F;
/* 478 */     float f3 = 0.05F + i * 0.01F - j * 0.01F;
/*     */     
/* 480 */     f2 = MathHelper.func_76131_a(f2, 0.0F, 1.0F);
/* 481 */     f3 = MathHelper.func_76131_a(f3, 0.0F, 1.0F);
/*     */     
/* 483 */     if (f1 < f2) {
/* 484 */       this.field_146042_b.func_71064_a(StatList.field_151183_A, 1);
/* 485 */       return ((WeightedRandomFishable)WeightedRandom.func_76271_a(this.field_70146_Z, field_146039_d)).func_150708_a(this.field_70146_Z);
/*     */     } 
/* 487 */     f1 -= f2;
/*     */     
/* 489 */     if (f1 < f3) {
/* 490 */       this.field_146042_b.func_71064_a(StatList.field_151184_B, 1);
/* 491 */       return ((WeightedRandomFishable)WeightedRandom.func_76271_a(this.field_70146_Z, field_146041_e)).func_150708_a(this.field_70146_Z);
/*     */     } 
/* 493 */     f1 -= f3;
/*     */     
/* 495 */     this.field_146042_b.func_71064_a(StatList.field_75933_B, 1);
/* 496 */     return ((WeightedRandomFishable)WeightedRandom.func_76271_a(this.field_70146_Z, field_146036_f)).func_150708_a(this.field_70146_Z);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70106_y() {
/* 501 */     super.func_70106_y();
/* 502 */     if (this.field_146042_b != null) this.field_146042_b.field_71104_cf = null; 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\projectile\EntityFishHook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */