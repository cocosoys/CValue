/*     */ package net.minecraft.entity.projectile;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.IProjectile;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.server.S2BPacketChangeGameState;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntityArrow
/*     */   extends Entity
/*     */   implements IProjectile
/*     */ {
/*  34 */   private int field_145791_d = -1;
/*  35 */   private int field_145792_e = -1;
/*  36 */   private int field_145789_f = -1;
/*     */   private Block field_145790_g;
/*     */   private int field_70253_h;
/*     */   private boolean field_70254_i;
/*     */   public int field_70251_a;
/*     */   public int field_70249_b;
/*     */   public Entity field_70250_c;
/*     */   private int field_70252_j;
/*     */   private int field_70257_an;
/*  45 */   private double field_70255_ao = 2.0D;
/*     */   private int field_70256_ap;
/*     */   private static final String __OBFID = "CL_00001715";
/*     */   
/*     */   public EntityArrow(World p_i1753_1_) {
/*  50 */     super(p_i1753_1_);
/*  51 */     this.field_70155_l = 10.0D;
/*  52 */     func_70105_a(0.5F, 0.5F);
/*     */   }
/*     */   
/*     */   public EntityArrow(World p_i1754_1_, double p_i1754_2_, double p_i1754_4_, double p_i1754_6_) {
/*  56 */     super(p_i1754_1_);
/*  57 */     this.field_70155_l = 10.0D;
/*     */     
/*  59 */     func_70105_a(0.5F, 0.5F);
/*     */     
/*  61 */     func_70107_b(p_i1754_2_, p_i1754_4_, p_i1754_6_);
/*  62 */     this.field_70129_M = 0.0F;
/*     */   }
/*     */   
/*     */   public EntityArrow(World p_i1755_1_, EntityLivingBase p_i1755_2_, EntityLivingBase p_i1755_3_, float p_i1755_4_, float p_i1755_5_) {
/*  66 */     super(p_i1755_1_);
/*  67 */     this.field_70155_l = 10.0D;
/*  68 */     this.field_70250_c = (Entity)p_i1755_2_;
/*  69 */     if (p_i1755_2_ instanceof EntityPlayer) this.field_70251_a = 1;
/*     */     
/*  71 */     this.field_70163_u = p_i1755_2_.field_70163_u + p_i1755_2_.func_70047_e() - 0.10000000149011612D;
/*     */     
/*  73 */     double d1 = p_i1755_3_.field_70165_t - p_i1755_2_.field_70165_t;
/*  74 */     double d2 = p_i1755_3_.field_70121_D.field_72338_b + (p_i1755_3_.field_70131_O / 3.0F) - this.field_70163_u;
/*  75 */     double d3 = p_i1755_3_.field_70161_v - p_i1755_2_.field_70161_v;
/*  76 */     double d4 = MathHelper.func_76133_a(d1 * d1 + d3 * d3);
/*  77 */     if (d4 < 1.0E-7D)
/*     */       return; 
/*  79 */     float f1 = (float)(Math.atan2(d3, d1) * 180.0D / 3.1415927410125732D) - 90.0F;
/*  80 */     float f2 = (float)-(Math.atan2(d2, d4) * 180.0D / 3.1415927410125732D);
/*     */     
/*  82 */     double d5 = d1 / d4;
/*  83 */     double d6 = d3 / d4;
/*  84 */     func_70012_b(p_i1755_2_.field_70165_t + d5, this.field_70163_u, p_i1755_2_.field_70161_v + d6, f1, f2);
/*  85 */     this.field_70129_M = 0.0F;
/*     */     
/*  87 */     float f3 = (float)d4 * 0.2F;
/*  88 */     func_70186_c(d1, d2 + f3, d3, p_i1755_4_, p_i1755_5_);
/*     */   }
/*     */   
/*     */   public EntityArrow(World p_i1756_1_, EntityLivingBase p_i1756_2_, float p_i1756_3_) {
/*  92 */     super(p_i1756_1_);
/*  93 */     this.field_70155_l = 10.0D;
/*  94 */     this.field_70250_c = (Entity)p_i1756_2_;
/*  95 */     if (p_i1756_2_ instanceof EntityPlayer) this.field_70251_a = 1;
/*     */     
/*  97 */     func_70105_a(0.5F, 0.5F);
/*     */     
/*  99 */     func_70012_b(p_i1756_2_.field_70165_t, p_i1756_2_.field_70163_u + p_i1756_2_.func_70047_e(), p_i1756_2_.field_70161_v, p_i1756_2_.field_70177_z, p_i1756_2_.field_70125_A);
/*     */     
/* 101 */     this.field_70165_t -= (MathHelper.func_76134_b(this.field_70177_z / 180.0F * 3.1415927F) * 0.16F);
/* 102 */     this.field_70163_u -= 0.10000000149011612D;
/* 103 */     this.field_70161_v -= (MathHelper.func_76126_a(this.field_70177_z / 180.0F * 3.1415927F) * 0.16F);
/* 104 */     func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 105 */     this.field_70129_M = 0.0F;
/*     */     
/* 107 */     this.field_70159_w = (-MathHelper.func_76126_a(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F));
/* 108 */     this.field_70179_y = (MathHelper.func_76134_b(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F));
/* 109 */     this.field_70181_x = -MathHelper.func_76126_a(this.field_70125_A / 180.0F * 3.1415927F);
/*     */     
/* 111 */     func_70186_c(this.field_70159_w, this.field_70181_x, this.field_70179_y, p_i1756_3_ * 1.5F, 1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/* 116 */     this.field_70180_af.func_75682_a(16, Byte.valueOf((byte)0));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70186_c(double p_70186_1_, double p_70186_3_, double p_70186_5_, float p_70186_7_, float p_70186_8_) {
/* 121 */     float f1 = MathHelper.func_76133_a(p_70186_1_ * p_70186_1_ + p_70186_3_ * p_70186_3_ + p_70186_5_ * p_70186_5_);
/*     */     
/* 123 */     p_70186_1_ /= f1;
/* 124 */     p_70186_3_ /= f1;
/* 125 */     p_70186_5_ /= f1;
/*     */     
/* 127 */     p_70186_1_ += this.field_70146_Z.nextGaussian() * (this.field_70146_Z.nextBoolean() ? -1 : true) * 0.007499999832361937D * p_70186_8_;
/* 128 */     p_70186_3_ += this.field_70146_Z.nextGaussian() * (this.field_70146_Z.nextBoolean() ? -1 : true) * 0.007499999832361937D * p_70186_8_;
/* 129 */     p_70186_5_ += this.field_70146_Z.nextGaussian() * (this.field_70146_Z.nextBoolean() ? -1 : true) * 0.007499999832361937D * p_70186_8_;
/*     */     
/* 131 */     p_70186_1_ *= p_70186_7_;
/* 132 */     p_70186_3_ *= p_70186_7_;
/* 133 */     p_70186_5_ *= p_70186_7_;
/*     */     
/* 135 */     this.field_70159_w = p_70186_1_;
/* 136 */     this.field_70181_x = p_70186_3_;
/* 137 */     this.field_70179_y = p_70186_5_;
/*     */     
/* 139 */     float f2 = MathHelper.func_76133_a(p_70186_1_ * p_70186_1_ + p_70186_5_ * p_70186_5_);
/*     */     
/* 141 */     this.field_70126_B = this.field_70177_z = (float)(Math.atan2(p_70186_1_, p_70186_5_) * 180.0D / 3.1415927410125732D);
/* 142 */     this.field_70127_C = this.field_70125_A = (float)(Math.atan2(p_70186_3_, f2) * 180.0D / 3.1415927410125732D);
/* 143 */     this.field_70252_j = 0;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70056_a(double p_70056_1_, double p_70056_3_, double p_70056_5_, float p_70056_7_, float p_70056_8_, int p_70056_9_) {
/* 148 */     func_70107_b(p_70056_1_, p_70056_3_, p_70056_5_);
/* 149 */     func_70101_b(p_70056_7_, p_70056_8_);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70016_h(double p_70016_1_, double p_70016_3_, double p_70016_5_) {
/* 154 */     this.field_70159_w = p_70016_1_;
/* 155 */     this.field_70181_x = p_70016_3_;
/* 156 */     this.field_70179_y = p_70016_5_;
/* 157 */     if (this.field_70127_C == 0.0F && this.field_70126_B == 0.0F) {
/* 158 */       float f = MathHelper.func_76133_a(p_70016_1_ * p_70016_1_ + p_70016_5_ * p_70016_5_);
/* 159 */       this.field_70126_B = this.field_70177_z = (float)(Math.atan2(p_70016_1_, p_70016_5_) * 180.0D / 3.1415927410125732D);
/* 160 */       this.field_70127_C = this.field_70125_A = (float)(Math.atan2(p_70016_3_, f) * 180.0D / 3.1415927410125732D);
/* 161 */       this.field_70127_C = this.field_70125_A;
/* 162 */       this.field_70126_B = this.field_70177_z;
/* 163 */       func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, this.field_70125_A);
/* 164 */       this.field_70252_j = 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/* 170 */     super.func_70071_h_();
/*     */     
/* 172 */     if (this.field_70127_C == 0.0F && this.field_70126_B == 0.0F) {
/* 173 */       float f = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 174 */       this.field_70126_B = this.field_70177_z = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0D / 3.1415927410125732D);
/* 175 */       this.field_70127_C = this.field_70125_A = (float)(Math.atan2(this.field_70181_x, f) * 180.0D / 3.1415927410125732D);
/*     */     } 
/*     */     
/* 178 */     Block block = this.field_70170_p.func_147439_a(this.field_145791_d, this.field_145792_e, this.field_145789_f);
/* 179 */     if (block.func_149688_o() != Material.field_151579_a) {
/* 180 */       block.func_149719_a((IBlockAccess)this.field_70170_p, this.field_145791_d, this.field_145792_e, this.field_145789_f);
/* 181 */       AxisAlignedBB axisAlignedBB = block.func_149668_a(this.field_70170_p, this.field_145791_d, this.field_145792_e, this.field_145789_f);
/* 182 */       if (axisAlignedBB != null && axisAlignedBB.func_72318_a(Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v))) {
/* 183 */         this.field_70254_i = true;
/*     */       }
/*     */     } 
/*     */     
/* 187 */     if (this.field_70249_b > 0) this.field_70249_b--;
/*     */     
/* 189 */     if (this.field_70254_i) {
/* 190 */       int i = this.field_70170_p.func_72805_g(this.field_145791_d, this.field_145792_e, this.field_145789_f);
/* 191 */       if (block != this.field_145790_g || i != this.field_70253_h) {
/* 192 */         this.field_70254_i = false;
/*     */         
/* 194 */         this.field_70159_w *= (this.field_70146_Z.nextFloat() * 0.2F);
/* 195 */         this.field_70181_x *= (this.field_70146_Z.nextFloat() * 0.2F);
/* 196 */         this.field_70179_y *= (this.field_70146_Z.nextFloat() * 0.2F);
/* 197 */         this.field_70252_j = 0;
/* 198 */         this.field_70257_an = 0;
/*     */         return;
/*     */       } 
/* 201 */       this.field_70252_j++;
/* 202 */       if (this.field_70252_j == 1200) {
/* 203 */         func_70106_y();
/*     */       }
/*     */       
/*     */       return;
/*     */     } 
/* 208 */     this.field_70257_an++;
/*     */ 
/*     */     
/* 211 */     Vec3 vec31 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 212 */     Vec3 vec32 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/* 213 */     MovingObjectPosition movingObjectPosition = this.field_70170_p.func_147447_a(vec31, vec32, false, true, false);
/*     */     
/* 215 */     vec31 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 216 */     vec32 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/* 217 */     if (movingObjectPosition != null) {
/* 218 */       vec32 = Vec3.func_72443_a(movingObjectPosition.field_72307_f.field_72450_a, movingObjectPosition.field_72307_f.field_72448_b, movingObjectPosition.field_72307_f.field_72449_c);
/*     */     }
/* 220 */     Entity entity = null;
/* 221 */     List<Entity> list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(1.0D, 1.0D, 1.0D));
/* 222 */     double d = 0.0D; byte b;
/* 223 */     for (b = 0; b < list.size(); b++) {
/* 224 */       Entity entity1 = list.get(b);
/* 225 */       if (entity1.func_70067_L() && (entity1 != this.field_70250_c || this.field_70257_an >= 5)) {
/*     */         
/* 227 */         float f = 0.3F;
/* 228 */         AxisAlignedBB axisAlignedBB = entity1.field_70121_D.func_72314_b(f, f, f);
/* 229 */         MovingObjectPosition movingObjectPosition1 = axisAlignedBB.func_72327_a(vec31, vec32);
/* 230 */         if (movingObjectPosition1 != null) {
/* 231 */           double d1 = vec31.func_72438_d(movingObjectPosition1.field_72307_f);
/* 232 */           if (d1 < d || d == 0.0D) {
/* 233 */             entity = entity1;
/* 234 */             d = d1;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 239 */     if (entity != null) {
/* 240 */       movingObjectPosition = new MovingObjectPosition(entity);
/*     */     }
/*     */     
/* 243 */     if (movingObjectPosition != null && movingObjectPosition.field_72308_g != null && movingObjectPosition.field_72308_g instanceof EntityPlayer) {
/* 244 */       EntityPlayer entityPlayer = (EntityPlayer)movingObjectPosition.field_72308_g;
/* 245 */       if (entityPlayer.field_71075_bZ.field_75102_a || (this.field_70250_c instanceof EntityPlayer && !((EntityPlayer)this.field_70250_c).func_96122_a(entityPlayer))) {
/* 246 */         movingObjectPosition = null;
/*     */       }
/*     */     } 
/*     */     
/* 250 */     if (movingObjectPosition != null) {
/* 251 */       if (movingObjectPosition.field_72308_g != null) {
/*     */         
/* 253 */         float f = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y);
/* 254 */         int i = MathHelper.func_76143_f(f * this.field_70255_ao);
/*     */         
/* 256 */         if (func_70241_g()) i += this.field_70146_Z.nextInt(i / 2 + 2);
/*     */         
/* 258 */         DamageSource damageSource = null;
/* 259 */         if (this.field_70250_c == null) {
/* 260 */           damageSource = DamageSource.func_76353_a(this, this);
/*     */         } else {
/* 262 */           damageSource = DamageSource.func_76353_a(this, this.field_70250_c);
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 267 */         if (func_70027_ad() && !(movingObjectPosition.field_72308_g instanceof net.minecraft.entity.monster.EntityEnderman)) {
/* 268 */           movingObjectPosition.field_72308_g.func_70015_d(5);
/*     */         }
/* 270 */         if (movingObjectPosition.field_72308_g.func_70097_a(damageSource, i)) {
/* 271 */           if (movingObjectPosition.field_72308_g instanceof EntityLivingBase) {
/* 272 */             EntityLivingBase entityLivingBase = (EntityLivingBase)movingObjectPosition.field_72308_g;
/*     */             
/* 274 */             if (!this.field_70170_p.field_72995_K) {
/* 275 */               entityLivingBase.func_85034_r(entityLivingBase.func_85035_bI() + 1);
/*     */             }
/*     */             
/* 278 */             if (this.field_70256_ap > 0) {
/* 279 */               float f4 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 280 */               if (f4 > 0.0F) {
/* 281 */                 movingObjectPosition.field_72308_g.func_70024_g(this.field_70159_w * this.field_70256_ap * 0.6000000238418579D / f4, 0.1D, this.field_70179_y * this.field_70256_ap * 0.6000000238418579D / f4);
/*     */               }
/*     */             } 
/*     */             
/* 285 */             if (this.field_70250_c != null && this.field_70250_c instanceof EntityLivingBase) {
/* 286 */               EnchantmentHelper.func_151384_a(entityLivingBase, this.field_70250_c);
/* 287 */               EnchantmentHelper.func_151385_b((EntityLivingBase)this.field_70250_c, (Entity)entityLivingBase);
/*     */             } 
/*     */             
/* 290 */             if (this.field_70250_c != null && movingObjectPosition.field_72308_g != this.field_70250_c && movingObjectPosition.field_72308_g instanceof EntityPlayer && this.field_70250_c instanceof EntityPlayerMP) {
/* 291 */               ((EntityPlayerMP)this.field_70250_c).field_71135_a.func_147359_a((Packet)new S2BPacketChangeGameState(6, 0.0F));
/*     */             }
/*     */           } 
/* 294 */           func_85030_a("random.bowhit", 1.0F, 1.2F / (this.field_70146_Z.nextFloat() * 0.2F + 0.9F));
/* 295 */           if (!(movingObjectPosition.field_72308_g instanceof net.minecraft.entity.monster.EntityEnderman)) func_70106_y(); 
/*     */         } else {
/* 297 */           this.field_70159_w *= -0.10000000149011612D;
/* 298 */           this.field_70181_x *= -0.10000000149011612D;
/* 299 */           this.field_70179_y *= -0.10000000149011612D;
/* 300 */           this.field_70177_z += 180.0F;
/* 301 */           this.field_70126_B += 180.0F;
/* 302 */           this.field_70257_an = 0;
/*     */         } 
/*     */       } else {
/* 305 */         this.field_145791_d = movingObjectPosition.field_72311_b;
/* 306 */         this.field_145792_e = movingObjectPosition.field_72312_c;
/* 307 */         this.field_145789_f = movingObjectPosition.field_72309_d;
/* 308 */         this.field_145790_g = this.field_70170_p.func_147439_a(this.field_145791_d, this.field_145792_e, this.field_145789_f);
/* 309 */         this.field_70253_h = this.field_70170_p.func_72805_g(this.field_145791_d, this.field_145792_e, this.field_145789_f);
/* 310 */         this.field_70159_w = (float)(movingObjectPosition.field_72307_f.field_72450_a - this.field_70165_t);
/* 311 */         this.field_70181_x = (float)(movingObjectPosition.field_72307_f.field_72448_b - this.field_70163_u);
/* 312 */         this.field_70179_y = (float)(movingObjectPosition.field_72307_f.field_72449_c - this.field_70161_v);
/* 313 */         float f = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y);
/* 314 */         this.field_70165_t -= this.field_70159_w / f * 0.05000000074505806D;
/* 315 */         this.field_70163_u -= this.field_70181_x / f * 0.05000000074505806D;
/* 316 */         this.field_70161_v -= this.field_70179_y / f * 0.05000000074505806D;
/*     */         
/* 318 */         func_85030_a("random.bowhit", 1.0F, 1.2F / (this.field_70146_Z.nextFloat() * 0.2F + 0.9F));
/* 319 */         this.field_70254_i = true;
/* 320 */         this.field_70249_b = 7;
/* 321 */         func_70243_d(false);
/*     */         
/* 323 */         if (this.field_145790_g.func_149688_o() != Material.field_151579_a) {
/* 324 */           this.field_145790_g.func_149670_a(this.field_70170_p, this.field_145791_d, this.field_145792_e, this.field_145789_f, this);
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/* 329 */     if (func_70241_g()) {
/* 330 */       for (b = 0; b < 4; b++) {
/* 331 */         this.field_70170_p.func_72869_a("crit", this.field_70165_t + this.field_70159_w * b / 4.0D, this.field_70163_u + this.field_70181_x * b / 4.0D, this.field_70161_v + this.field_70179_y * b / 4.0D, -this.field_70159_w, -this.field_70181_x + 0.2D, -this.field_70179_y);
/*     */       }
/*     */     }
/*     */     
/* 335 */     this.field_70165_t += this.field_70159_w;
/* 336 */     this.field_70163_u += this.field_70181_x;
/* 337 */     this.field_70161_v += this.field_70179_y;
/*     */     
/* 339 */     float f1 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 340 */     this.field_70177_z = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0D / 3.1415927410125732D);
/* 341 */     this.field_70125_A = (float)(Math.atan2(this.field_70181_x, f1) * 180.0D / 3.1415927410125732D);
/*     */     
/* 343 */     while (this.field_70125_A - this.field_70127_C < -180.0F)
/* 344 */       this.field_70127_C -= 360.0F; 
/* 345 */     while (this.field_70125_A - this.field_70127_C >= 180.0F) {
/* 346 */       this.field_70127_C += 360.0F;
/*     */     }
/* 348 */     while (this.field_70177_z - this.field_70126_B < -180.0F)
/* 349 */       this.field_70126_B -= 360.0F; 
/* 350 */     while (this.field_70177_z - this.field_70126_B >= 180.0F) {
/* 351 */       this.field_70126_B += 360.0F;
/*     */     }
/* 353 */     this.field_70125_A = this.field_70127_C + (this.field_70125_A - this.field_70127_C) * 0.2F;
/* 354 */     this.field_70177_z = this.field_70126_B + (this.field_70177_z - this.field_70126_B) * 0.2F;
/*     */     
/* 356 */     float f2 = 0.99F;
/* 357 */     float f3 = 0.05F;
/*     */     
/* 359 */     if (func_70090_H()) {
/* 360 */       for (byte b1 = 0; b1 < 4; b1++) {
/* 361 */         float f = 0.25F;
/* 362 */         this.field_70170_p.func_72869_a("bubble", this.field_70165_t - this.field_70159_w * f, this.field_70163_u - this.field_70181_x * f, this.field_70161_v - this.field_70179_y * f, this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*     */       } 
/* 364 */       f2 = 0.8F;
/*     */     } 
/*     */     
/* 367 */     if (func_70026_G()) func_70066_B();
/*     */     
/* 369 */     this.field_70159_w *= f2;
/* 370 */     this.field_70181_x *= f2;
/* 371 */     this.field_70179_y *= f2;
/* 372 */     this.field_70181_x -= f3;
/*     */     
/* 374 */     func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*     */     
/* 376 */     func_145775_I();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound p_70014_1_) {
/* 381 */     p_70014_1_.func_74777_a("xTile", (short)this.field_145791_d);
/* 382 */     p_70014_1_.func_74777_a("yTile", (short)this.field_145792_e);
/* 383 */     p_70014_1_.func_74777_a("zTile", (short)this.field_145789_f);
/* 384 */     p_70014_1_.func_74777_a("life", (short)this.field_70252_j);
/* 385 */     p_70014_1_.func_74774_a("inTile", (byte)Block.func_149682_b(this.field_145790_g));
/* 386 */     p_70014_1_.func_74774_a("inData", (byte)this.field_70253_h);
/* 387 */     p_70014_1_.func_74774_a("shake", (byte)this.field_70249_b);
/* 388 */     p_70014_1_.func_74774_a("inGround", (byte)(this.field_70254_i ? 1 : 0));
/* 389 */     p_70014_1_.func_74774_a("pickup", (byte)this.field_70251_a);
/* 390 */     p_70014_1_.func_74780_a("damage", this.field_70255_ao);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound p_70037_1_) {
/* 395 */     this.field_145791_d = p_70037_1_.func_74765_d("xTile");
/* 396 */     this.field_145792_e = p_70037_1_.func_74765_d("yTile");
/* 397 */     this.field_145789_f = p_70037_1_.func_74765_d("zTile");
/* 398 */     this.field_70252_j = p_70037_1_.func_74765_d("life");
/* 399 */     this.field_145790_g = Block.func_149729_e(p_70037_1_.func_74771_c("inTile") & 0xFF);
/* 400 */     this.field_70253_h = p_70037_1_.func_74771_c("inData") & 0xFF;
/* 401 */     this.field_70249_b = p_70037_1_.func_74771_c("shake") & 0xFF;
/* 402 */     this.field_70254_i = (p_70037_1_.func_74771_c("inGround") == 1);
/* 403 */     if (p_70037_1_.func_150297_b("damage", 99)) {
/* 404 */       this.field_70255_ao = p_70037_1_.func_74769_h("damage");
/*     */     }
/*     */     
/* 407 */     if (p_70037_1_.func_150297_b("pickup", 99)) {
/* 408 */       this.field_70251_a = p_70037_1_.func_74771_c("pickup");
/* 409 */     } else if (p_70037_1_.func_150297_b("player", 99)) {
/* 410 */       this.field_70251_a = p_70037_1_.func_74767_n("player") ? 1 : 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70100_b_(EntityPlayer p_70100_1_) {
/* 416 */     if (this.field_70170_p.field_72995_K || !this.field_70254_i || this.field_70249_b > 0)
/*     */       return; 
/* 418 */     boolean bool = (this.field_70251_a == 1 || (this.field_70251_a == 2 && p_70100_1_.field_71075_bZ.field_75098_d)) ? true : false;
/*     */     
/* 420 */     if (this.field_70251_a == 1 && 
/* 421 */       !p_70100_1_.field_71071_by.func_70441_a(new ItemStack(Items.field_151032_g, 1))) {
/* 422 */       bool = false;
/*     */     }
/*     */ 
/*     */     
/* 426 */     if (bool) {
/* 427 */       func_85030_a("random.pop", 0.2F, ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.7F + 1.0F) * 2.0F);
/* 428 */       p_70100_1_.func_71001_a(this, 1);
/* 429 */       func_70106_y();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean func_70041_e_() {
/* 435 */     return false;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_70053_R() {
/* 440 */     return 0.0F;
/*     */   }
/*     */   
/*     */   public void func_70239_b(double p_70239_1_) {
/* 444 */     this.field_70255_ao = p_70239_1_;
/*     */   }
/*     */   
/*     */   public double func_70242_d() {
/* 448 */     return this.field_70255_ao;
/*     */   }
/*     */   
/*     */   public void func_70240_a(int p_70240_1_) {
/* 452 */     this.field_70256_ap = p_70240_1_;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70075_an() {
/* 457 */     return false;
/*     */   }
/*     */   
/*     */   public void func_70243_d(boolean p_70243_1_) {
/* 461 */     byte b = this.field_70180_af.func_75683_a(16);
/* 462 */     if (p_70243_1_) {
/* 463 */       this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)(b | 0x1)));
/*     */     } else {
/* 465 */       this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)(b & 0xFFFFFFFE)));
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean func_70241_g() {
/* 470 */     byte b = this.field_70180_af.func_75683_a(16);
/* 471 */     return ((b & 0x1) != 0);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\projectile\EntityArrow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */