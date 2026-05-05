/*     */ package net.minecraft.entity.projectile;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.IProjectile;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public abstract class EntityThrowable extends Entity implements IProjectile {
/*  19 */   private int field_145788_c = -1;
/*  20 */   private int field_145786_d = -1;
/*  21 */   private int field_145787_e = -1;
/*     */   
/*     */   private Block field_145785_f;
/*     */   
/*     */   protected boolean field_70193_a;
/*     */   
/*     */   public int field_70191_b;
/*     */   private EntityLivingBase field_70192_c;
/*     */   
/*     */   public EntityThrowable(World p_i1776_1_) {
/*  31 */     super(p_i1776_1_);
/*  32 */     func_70105_a(0.25F, 0.25F);
/*     */   }
/*     */   private String field_85053_h; private int field_70194_h; private int field_70195_i;
/*     */   private static final String __OBFID = "CL_00001723";
/*     */   
/*     */   protected void func_70088_a() {}
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_70112_a(double p_70112_1_) {
/*  41 */     double d = this.field_70121_D.func_72320_b() * 4.0D;
/*  42 */     d *= 64.0D;
/*  43 */     return (p_70112_1_ < d * d);
/*     */   }
/*     */   
/*     */   public EntityThrowable(World p_i1777_1_, EntityLivingBase p_i1777_2_) {
/*  47 */     super(p_i1777_1_);
/*  48 */     this.field_70192_c = p_i1777_2_;
/*     */     
/*  50 */     func_70105_a(0.25F, 0.25F);
/*     */     
/*  52 */     func_70012_b(p_i1777_2_.field_70165_t, p_i1777_2_.field_70163_u + p_i1777_2_.func_70047_e(), p_i1777_2_.field_70161_v, p_i1777_2_.field_70177_z, p_i1777_2_.field_70125_A);
/*     */     
/*  54 */     this.field_70165_t -= (MathHelper.func_76134_b(this.field_70177_z / 180.0F * 3.1415927F) * 0.16F);
/*  55 */     this.field_70163_u -= 0.10000000149011612D;
/*  56 */     this.field_70161_v -= (MathHelper.func_76126_a(this.field_70177_z / 180.0F * 3.1415927F) * 0.16F);
/*  57 */     func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*  58 */     this.field_70129_M = 0.0F;
/*     */     
/*  60 */     float f = 0.4F;
/*  61 */     this.field_70159_w = (-MathHelper.func_76126_a(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F) * f);
/*  62 */     this.field_70179_y = (MathHelper.func_76134_b(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F) * f);
/*  63 */     this.field_70181_x = (-MathHelper.func_76126_a((this.field_70125_A + func_70183_g()) / 180.0F * 3.1415927F) * f);
/*     */     
/*  65 */     func_70186_c(this.field_70159_w, this.field_70181_x, this.field_70179_y, func_70182_d(), 1.0F);
/*     */   }
/*     */   
/*     */   public EntityThrowable(World p_i1778_1_, double p_i1778_2_, double p_i1778_4_, double p_i1778_6_) {
/*  69 */     super(p_i1778_1_);
/*  70 */     this.field_70194_h = 0;
/*     */     
/*  72 */     func_70105_a(0.25F, 0.25F);
/*     */     
/*  74 */     func_70107_b(p_i1778_2_, p_i1778_4_, p_i1778_6_);
/*  75 */     this.field_70129_M = 0.0F;
/*     */   }
/*     */   
/*     */   protected float func_70182_d() {
/*  79 */     return 1.5F;
/*     */   }
/*     */   
/*     */   protected float func_70183_g() {
/*  83 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70186_c(double p_70186_1_, double p_70186_3_, double p_70186_5_, float p_70186_7_, float p_70186_8_) {
/*  88 */     float f1 = MathHelper.func_76133_a(p_70186_1_ * p_70186_1_ + p_70186_3_ * p_70186_3_ + p_70186_5_ * p_70186_5_);
/*     */     
/*  90 */     p_70186_1_ /= f1;
/*  91 */     p_70186_3_ /= f1;
/*  92 */     p_70186_5_ /= f1;
/*     */     
/*  94 */     p_70186_1_ += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * p_70186_8_;
/*  95 */     p_70186_3_ += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * p_70186_8_;
/*  96 */     p_70186_5_ += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * p_70186_8_;
/*     */     
/*  98 */     p_70186_1_ *= p_70186_7_;
/*  99 */     p_70186_3_ *= p_70186_7_;
/* 100 */     p_70186_5_ *= p_70186_7_;
/*     */     
/* 102 */     this.field_70159_w = p_70186_1_;
/* 103 */     this.field_70181_x = p_70186_3_;
/* 104 */     this.field_70179_y = p_70186_5_;
/*     */     
/* 106 */     float f2 = MathHelper.func_76133_a(p_70186_1_ * p_70186_1_ + p_70186_5_ * p_70186_5_);
/*     */     
/* 108 */     this.field_70126_B = this.field_70177_z = (float)(Math.atan2(p_70186_1_, p_70186_5_) * 180.0D / 3.1415927410125732D);
/* 109 */     this.field_70127_C = this.field_70125_A = (float)(Math.atan2(p_70186_3_, f2) * 180.0D / 3.1415927410125732D);
/* 110 */     this.field_70194_h = 0;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70016_h(double p_70016_1_, double p_70016_3_, double p_70016_5_) {
/* 115 */     this.field_70159_w = p_70016_1_;
/* 116 */     this.field_70181_x = p_70016_3_;
/* 117 */     this.field_70179_y = p_70016_5_;
/* 118 */     if (this.field_70127_C == 0.0F && this.field_70126_B == 0.0F) {
/* 119 */       float f = MathHelper.func_76133_a(p_70016_1_ * p_70016_1_ + p_70016_5_ * p_70016_5_);
/* 120 */       this.field_70126_B = this.field_70177_z = (float)(Math.atan2(p_70016_1_, p_70016_5_) * 180.0D / 3.1415927410125732D);
/* 121 */       this.field_70127_C = this.field_70125_A = (float)(Math.atan2(p_70016_3_, f) * 180.0D / 3.1415927410125732D);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/* 127 */     this.field_70142_S = this.field_70165_t;
/* 128 */     this.field_70137_T = this.field_70163_u;
/* 129 */     this.field_70136_U = this.field_70161_v;
/* 130 */     super.func_70071_h_();
/*     */     
/* 132 */     if (this.field_70191_b > 0) this.field_70191_b--;
/*     */     
/* 134 */     if (this.field_70193_a) {
/* 135 */       if (this.field_70170_p.func_147439_a(this.field_145788_c, this.field_145786_d, this.field_145787_e) == this.field_145785_f) {
/* 136 */         this.field_70194_h++;
/* 137 */         if (this.field_70194_h == 1200) func_70106_y(); 
/*     */         return;
/*     */       } 
/* 140 */       this.field_70193_a = false;
/*     */       
/* 142 */       this.field_70159_w *= (this.field_70146_Z.nextFloat() * 0.2F);
/* 143 */       this.field_70181_x *= (this.field_70146_Z.nextFloat() * 0.2F);
/* 144 */       this.field_70179_y *= (this.field_70146_Z.nextFloat() * 0.2F);
/* 145 */       this.field_70194_h = 0;
/* 146 */       this.field_70195_i = 0;
/*     */     } else {
/*     */       
/* 149 */       this.field_70195_i++;
/*     */     } 
/*     */     
/* 152 */     Vec3 vec31 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 153 */     Vec3 vec32 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/* 154 */     MovingObjectPosition movingObjectPosition = this.field_70170_p.func_72933_a(vec31, vec32);
/*     */     
/* 156 */     vec31 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 157 */     vec32 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/* 158 */     if (movingObjectPosition != null) {
/* 159 */       vec32 = Vec3.func_72443_a(movingObjectPosition.field_72307_f.field_72450_a, movingObjectPosition.field_72307_f.field_72448_b, movingObjectPosition.field_72307_f.field_72449_c);
/*     */     }
/*     */     
/* 162 */     if (!this.field_70170_p.field_72995_K) {
/* 163 */       Entity entity = null;
/* 164 */       List<Entity> list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(1.0D, 1.0D, 1.0D));
/* 165 */       double d = 0.0D;
/* 166 */       EntityLivingBase entityLivingBase = func_85052_h();
/* 167 */       for (byte b = 0; b < list.size(); b++) {
/* 168 */         Entity entity1 = list.get(b);
/* 169 */         if (entity1.func_70067_L() && (entity1 != entityLivingBase || this.field_70195_i >= 5)) {
/*     */           
/* 171 */           float f = 0.3F;
/* 172 */           AxisAlignedBB axisAlignedBB = entity1.field_70121_D.func_72314_b(f, f, f);
/* 173 */           MovingObjectPosition movingObjectPosition1 = axisAlignedBB.func_72327_a(vec31, vec32);
/* 174 */           if (movingObjectPosition1 != null) {
/* 175 */             double d1 = vec31.func_72438_d(movingObjectPosition1.field_72307_f);
/* 176 */             if (d1 < d || d == 0.0D) {
/* 177 */               entity = entity1;
/* 178 */               d = d1;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/* 183 */       if (entity != null) {
/* 184 */         movingObjectPosition = new MovingObjectPosition(entity);
/*     */       }
/*     */     } 
/*     */     
/* 188 */     if (movingObjectPosition != null) {
/* 189 */       if (movingObjectPosition.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK && this.field_70170_p.func_147439_a(movingObjectPosition.field_72311_b, movingObjectPosition.field_72312_c, movingObjectPosition.field_72309_d) == Blocks.field_150427_aO) {
/* 190 */         func_70063_aa();
/*     */       } else {
/* 192 */         func_70184_a(movingObjectPosition);
/*     */       } 
/*     */     }
/* 195 */     this.field_70165_t += this.field_70159_w;
/* 196 */     this.field_70163_u += this.field_70181_x;
/* 197 */     this.field_70161_v += this.field_70179_y;
/*     */     
/* 199 */     float f1 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 200 */     this.field_70177_z = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0D / 3.1415927410125732D);
/* 201 */     this.field_70125_A = (float)(Math.atan2(this.field_70181_x, f1) * 180.0D / 3.1415927410125732D);
/*     */     
/* 203 */     while (this.field_70125_A - this.field_70127_C < -180.0F)
/* 204 */       this.field_70127_C -= 360.0F; 
/* 205 */     while (this.field_70125_A - this.field_70127_C >= 180.0F) {
/* 206 */       this.field_70127_C += 360.0F;
/*     */     }
/* 208 */     while (this.field_70177_z - this.field_70126_B < -180.0F)
/* 209 */       this.field_70126_B -= 360.0F; 
/* 210 */     while (this.field_70177_z - this.field_70126_B >= 180.0F) {
/* 211 */       this.field_70126_B += 360.0F;
/*     */     }
/* 213 */     this.field_70125_A = this.field_70127_C + (this.field_70125_A - this.field_70127_C) * 0.2F;
/* 214 */     this.field_70177_z = this.field_70126_B + (this.field_70177_z - this.field_70126_B) * 0.2F;
/*     */     
/* 216 */     float f2 = 0.99F;
/* 217 */     float f3 = func_70185_h();
/*     */     
/* 219 */     if (func_70090_H()) {
/* 220 */       for (byte b = 0; b < 4; b++) {
/* 221 */         float f = 0.25F;
/* 222 */         this.field_70170_p.func_72869_a("bubble", this.field_70165_t - this.field_70159_w * f, this.field_70163_u - this.field_70181_x * f, this.field_70161_v - this.field_70179_y * f, this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*     */       } 
/* 224 */       f2 = 0.8F;
/*     */     } 
/*     */     
/* 227 */     this.field_70159_w *= f2;
/* 228 */     this.field_70181_x *= f2;
/* 229 */     this.field_70179_y *= f2;
/* 230 */     this.field_70181_x -= f3;
/*     */     
/* 232 */     func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*     */   }
/*     */   
/*     */   protected float func_70185_h() {
/* 236 */     return 0.03F;
/*     */   }
/*     */ 
/*     */   
/*     */   protected abstract void func_70184_a(MovingObjectPosition paramMovingObjectPosition);
/*     */   
/*     */   public void func_70014_b(NBTTagCompound p_70014_1_) {
/* 243 */     p_70014_1_.func_74777_a("xTile", (short)this.field_145788_c);
/* 244 */     p_70014_1_.func_74777_a("yTile", (short)this.field_145786_d);
/* 245 */     p_70014_1_.func_74777_a("zTile", (short)this.field_145787_e);
/* 246 */     p_70014_1_.func_74774_a("inTile", (byte)Block.func_149682_b(this.field_145785_f));
/* 247 */     p_70014_1_.func_74774_a("shake", (byte)this.field_70191_b);
/* 248 */     p_70014_1_.func_74774_a("inGround", (byte)(this.field_70193_a ? 1 : 0));
/*     */     
/* 250 */     if ((this.field_85053_h == null || this.field_85053_h.length() == 0) && this.field_70192_c != null && this.field_70192_c instanceof net.minecraft.entity.player.EntityPlayer) {
/* 251 */       this.field_85053_h = this.field_70192_c.func_70005_c_();
/*     */     }
/* 253 */     p_70014_1_.func_74778_a("ownerName", (this.field_85053_h == null) ? "" : this.field_85053_h);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound p_70037_1_) {
/* 258 */     this.field_145788_c = p_70037_1_.func_74765_d("xTile");
/* 259 */     this.field_145786_d = p_70037_1_.func_74765_d("yTile");
/* 260 */     this.field_145787_e = p_70037_1_.func_74765_d("zTile");
/* 261 */     this.field_145785_f = Block.func_149729_e(p_70037_1_.func_74771_c("inTile") & 0xFF);
/* 262 */     this.field_70191_b = p_70037_1_.func_74771_c("shake") & 0xFF;
/* 263 */     this.field_70193_a = (p_70037_1_.func_74771_c("inGround") == 1);
/* 264 */     this.field_85053_h = p_70037_1_.func_74779_i("ownerName");
/* 265 */     if (this.field_85053_h != null && this.field_85053_h.length() == 0) this.field_85053_h = null; 
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_70053_R() {
/* 270 */     return 0.0F;
/*     */   }
/*     */   
/*     */   public EntityLivingBase func_85052_h() {
/* 274 */     if (this.field_70192_c == null && this.field_85053_h != null && this.field_85053_h.length() > 0) {
/* 275 */       this.field_70192_c = (EntityLivingBase)this.field_70170_p.func_72924_a(this.field_85053_h);
/*     */     }
/* 277 */     return this.field_70192_c;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\projectile\EntityThrowable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */