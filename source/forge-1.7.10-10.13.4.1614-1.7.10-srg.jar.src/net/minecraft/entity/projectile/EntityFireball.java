/*     */ package net.minecraft.entity.projectile;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public abstract class EntityFireball extends Entity {
/*  19 */   private int field_145795_e = -1;
/*  20 */   private int field_145793_f = -1;
/*  21 */   private int field_145794_g = -1;
/*     */   
/*     */   private Block field_145796_h;
/*     */   
/*     */   private boolean field_70238_i;
/*     */   public EntityLivingBase field_70235_a;
/*     */   private int field_70236_j;
/*     */   
/*     */   public EntityFireball(World p_i1759_1_) {
/*  30 */     super(p_i1759_1_);
/*  31 */     func_70105_a(1.0F, 1.0F);
/*     */   }
/*     */   private int field_70234_an; public double field_70232_b; public double field_70233_c; public double field_70230_d;
/*     */   private static final String __OBFID = "CL_00001717";
/*     */   
/*     */   protected void func_70088_a() {}
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_70112_a(double p_70112_1_) {
/*  40 */     double d = this.field_70121_D.func_72320_b() * 4.0D;
/*  41 */     d *= 64.0D;
/*  42 */     return (p_70112_1_ < d * d);
/*     */   }
/*     */   
/*     */   public EntityFireball(World p_i1760_1_, double p_i1760_2_, double p_i1760_4_, double p_i1760_6_, double p_i1760_8_, double p_i1760_10_, double p_i1760_12_) {
/*  46 */     super(p_i1760_1_);
/*  47 */     func_70105_a(1.0F, 1.0F);
/*     */     
/*  49 */     func_70012_b(p_i1760_2_, p_i1760_4_, p_i1760_6_, this.field_70177_z, this.field_70125_A);
/*  50 */     func_70107_b(p_i1760_2_, p_i1760_4_, p_i1760_6_);
/*     */     
/*  52 */     double d = MathHelper.func_76133_a(p_i1760_8_ * p_i1760_8_ + p_i1760_10_ * p_i1760_10_ + p_i1760_12_ * p_i1760_12_);
/*  53 */     this.field_70232_b = p_i1760_8_ / d * 0.1D;
/*  54 */     this.field_70233_c = p_i1760_10_ / d * 0.1D;
/*  55 */     this.field_70230_d = p_i1760_12_ / d * 0.1D;
/*     */   }
/*     */   
/*     */   public EntityFireball(World p_i1761_1_, EntityLivingBase p_i1761_2_, double p_i1761_3_, double p_i1761_5_, double p_i1761_7_) {
/*  59 */     super(p_i1761_1_);
/*  60 */     this.field_70235_a = p_i1761_2_;
/*     */     
/*  62 */     func_70105_a(1.0F, 1.0F);
/*     */     
/*  64 */     func_70012_b(p_i1761_2_.field_70165_t, p_i1761_2_.field_70163_u, p_i1761_2_.field_70161_v, p_i1761_2_.field_70177_z, p_i1761_2_.field_70125_A);
/*  65 */     func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*  66 */     this.field_70129_M = 0.0F;
/*     */     
/*  68 */     this.field_70159_w = this.field_70181_x = this.field_70179_y = 0.0D;
/*     */     
/*  70 */     p_i1761_3_ += this.field_70146_Z.nextGaussian() * 0.4D;
/*  71 */     p_i1761_5_ += this.field_70146_Z.nextGaussian() * 0.4D;
/*  72 */     p_i1761_7_ += this.field_70146_Z.nextGaussian() * 0.4D;
/*  73 */     double d = MathHelper.func_76133_a(p_i1761_3_ * p_i1761_3_ + p_i1761_5_ * p_i1761_5_ + p_i1761_7_ * p_i1761_7_);
/*  74 */     this.field_70232_b = p_i1761_3_ / d * 0.1D;
/*  75 */     this.field_70233_c = p_i1761_5_ / d * 0.1D;
/*  76 */     this.field_70230_d = p_i1761_7_ / d * 0.1D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/*  82 */     if (!this.field_70170_p.field_72995_K && ((this.field_70235_a != null && this.field_70235_a.field_70128_L) || !this.field_70170_p.func_72899_e((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v))) {
/*  83 */       func_70106_y();
/*     */       
/*     */       return;
/*     */     } 
/*  87 */     super.func_70071_h_();
/*  88 */     func_70015_d(1);
/*     */     
/*  90 */     if (this.field_70238_i) {
/*  91 */       if (this.field_70170_p.func_147439_a(this.field_145795_e, this.field_145793_f, this.field_145794_g) == this.field_145796_h) {
/*  92 */         this.field_70236_j++;
/*  93 */         if (this.field_70236_j == 600) func_70106_y(); 
/*     */         return;
/*     */       } 
/*  96 */       this.field_70238_i = false;
/*     */       
/*  98 */       this.field_70159_w *= (this.field_70146_Z.nextFloat() * 0.2F);
/*  99 */       this.field_70181_x *= (this.field_70146_Z.nextFloat() * 0.2F);
/* 100 */       this.field_70179_y *= (this.field_70146_Z.nextFloat() * 0.2F);
/* 101 */       this.field_70236_j = 0;
/* 102 */       this.field_70234_an = 0;
/*     */     } else {
/*     */       
/* 105 */       this.field_70234_an++;
/*     */     } 
/*     */     
/* 108 */     Vec3 vec31 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 109 */     Vec3 vec32 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/* 110 */     MovingObjectPosition movingObjectPosition = this.field_70170_p.func_72933_a(vec31, vec32);
/*     */     
/* 112 */     vec31 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 113 */     vec32 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/* 114 */     if (movingObjectPosition != null) {
/* 115 */       vec32 = Vec3.func_72443_a(movingObjectPosition.field_72307_f.field_72450_a, movingObjectPosition.field_72307_f.field_72448_b, movingObjectPosition.field_72307_f.field_72449_c);
/*     */     }
/* 117 */     Entity entity = null;
/* 118 */     List<Entity> list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(1.0D, 1.0D, 1.0D));
/* 119 */     double d = 0.0D;
/* 120 */     for (byte b = 0; b < list.size(); b++) {
/* 121 */       Entity entity1 = list.get(b);
/* 122 */       if (entity1.func_70067_L() && (!entity1.func_70028_i((Entity)this.field_70235_a) || this.field_70234_an >= 25)) {
/*     */         
/* 124 */         float f = 0.3F;
/* 125 */         AxisAlignedBB axisAlignedBB = entity1.field_70121_D.func_72314_b(f, f, f);
/* 126 */         MovingObjectPosition movingObjectPosition1 = axisAlignedBB.func_72327_a(vec31, vec32);
/* 127 */         if (movingObjectPosition1 != null) {
/* 128 */           double d1 = vec31.func_72438_d(movingObjectPosition1.field_72307_f);
/* 129 */           if (d1 < d || d == 0.0D) {
/* 130 */             entity = entity1;
/* 131 */             d = d1;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 136 */     if (entity != null) {
/* 137 */       movingObjectPosition = new MovingObjectPosition(entity);
/*     */     }
/*     */     
/* 140 */     if (movingObjectPosition != null) {
/* 141 */       func_70227_a(movingObjectPosition);
/*     */     }
/*     */     
/* 144 */     this.field_70165_t += this.field_70159_w;
/* 145 */     this.field_70163_u += this.field_70181_x;
/* 146 */     this.field_70161_v += this.field_70179_y;
/*     */     
/* 148 */     float f1 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 149 */     this.field_70177_z = (float)(Math.atan2(this.field_70179_y, this.field_70159_w) * 180.0D / 3.1415927410125732D) + 90.0F;
/* 150 */     this.field_70125_A = (float)(Math.atan2(f1, this.field_70181_x) * 180.0D / 3.1415927410125732D) - 90.0F;
/*     */     
/* 152 */     while (this.field_70125_A - this.field_70127_C < -180.0F)
/* 153 */       this.field_70127_C -= 360.0F; 
/* 154 */     while (this.field_70125_A - this.field_70127_C >= 180.0F) {
/* 155 */       this.field_70127_C += 360.0F;
/*     */     }
/* 157 */     while (this.field_70177_z - this.field_70126_B < -180.0F)
/* 158 */       this.field_70126_B -= 360.0F; 
/* 159 */     while (this.field_70177_z - this.field_70126_B >= 180.0F) {
/* 160 */       this.field_70126_B += 360.0F;
/*     */     }
/* 162 */     this.field_70125_A = this.field_70127_C + (this.field_70125_A - this.field_70127_C) * 0.2F;
/* 163 */     this.field_70177_z = this.field_70126_B + (this.field_70177_z - this.field_70126_B) * 0.2F;
/*     */     
/* 165 */     float f2 = func_82341_c();
/* 166 */     if (func_70090_H()) {
/* 167 */       for (byte b1 = 0; b1 < 4; b1++) {
/* 168 */         float f = 0.25F;
/* 169 */         this.field_70170_p.func_72869_a("bubble", this.field_70165_t - this.field_70159_w * f, this.field_70163_u - this.field_70181_x * f, this.field_70161_v - this.field_70179_y * f, this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*     */       } 
/* 171 */       f2 = 0.8F;
/*     */     } 
/*     */     
/* 174 */     this.field_70159_w += this.field_70232_b;
/* 175 */     this.field_70181_x += this.field_70233_c;
/* 176 */     this.field_70179_y += this.field_70230_d;
/* 177 */     this.field_70159_w *= f2;
/* 178 */     this.field_70181_x *= f2;
/* 179 */     this.field_70179_y *= f2;
/*     */     
/* 181 */     this.field_70170_p.func_72869_a("smoke", this.field_70165_t, this.field_70163_u + 0.5D, this.field_70161_v, 0.0D, 0.0D, 0.0D);
/*     */     
/* 183 */     func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*     */   }
/*     */   
/*     */   protected float func_82341_c() {
/* 187 */     return 0.95F;
/*     */   }
/*     */ 
/*     */   
/*     */   protected abstract void func_70227_a(MovingObjectPosition paramMovingObjectPosition);
/*     */   
/*     */   public void func_70014_b(NBTTagCompound p_70014_1_) {
/* 194 */     p_70014_1_.func_74777_a("xTile", (short)this.field_145795_e);
/* 195 */     p_70014_1_.func_74777_a("yTile", (short)this.field_145793_f);
/* 196 */     p_70014_1_.func_74777_a("zTile", (short)this.field_145794_g);
/* 197 */     p_70014_1_.func_74774_a("inTile", (byte)Block.func_149682_b(this.field_145796_h));
/* 198 */     p_70014_1_.func_74774_a("inGround", (byte)(this.field_70238_i ? 1 : 0));
/* 199 */     p_70014_1_.func_74782_a("direction", (NBTBase)func_70087_a(new double[] { this.field_70159_w, this.field_70181_x, this.field_70179_y }));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound p_70037_1_) {
/* 204 */     this.field_145795_e = p_70037_1_.func_74765_d("xTile");
/* 205 */     this.field_145793_f = p_70037_1_.func_74765_d("yTile");
/* 206 */     this.field_145794_g = p_70037_1_.func_74765_d("zTile");
/* 207 */     this.field_145796_h = Block.func_149729_e(p_70037_1_.func_74771_c("inTile") & 0xFF);
/* 208 */     this.field_70238_i = (p_70037_1_.func_74771_c("inGround") == 1);
/*     */ 
/*     */ 
/*     */     
/* 212 */     if (p_70037_1_.func_150297_b("direction", 9)) {
/* 213 */       NBTTagList nBTTagList = p_70037_1_.func_150295_c("direction", 6);
/* 214 */       this.field_70159_w = nBTTagList.func_150309_d(0);
/* 215 */       this.field_70181_x = nBTTagList.func_150309_d(1);
/* 216 */       this.field_70179_y = nBTTagList.func_150309_d(2);
/*     */     } else {
/* 218 */       func_70106_y();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70067_L() {
/* 224 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public float func_70111_Y() {
/* 229 */     return 1.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource p_70097_1_, float p_70097_2_) {
/* 234 */     if (func_85032_ar()) return false; 
/* 235 */     func_70018_K();
/*     */     
/* 237 */     if (p_70097_1_.func_76346_g() != null) {
/* 238 */       Vec3 vec3 = p_70097_1_.func_76346_g().func_70040_Z();
/* 239 */       if (vec3 != null) {
/* 240 */         this.field_70159_w = vec3.field_72450_a;
/* 241 */         this.field_70181_x = vec3.field_72448_b;
/* 242 */         this.field_70179_y = vec3.field_72449_c;
/* 243 */         this.field_70232_b = this.field_70159_w * 0.1D;
/* 244 */         this.field_70233_c = this.field_70181_x * 0.1D;
/* 245 */         this.field_70230_d = this.field_70179_y * 0.1D;
/*     */       } 
/* 247 */       if (p_70097_1_.func_76346_g() instanceof EntityLivingBase) {
/* 248 */         this.field_70235_a = (EntityLivingBase)p_70097_1_.func_76346_g();
/*     */       }
/* 250 */       return true;
/*     */     } 
/* 252 */     return false;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_70053_R() {
/* 257 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public float func_70013_c(float p_70013_1_) {
/* 262 */     return 1.0F;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_70070_b(float p_70070_1_) {
/* 267 */     return 15728880;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\projectile\EntityFireball.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */