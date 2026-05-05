/*     */ package net.minecraft.entity.item;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public class EntityXPOrb
/*     */   extends Entity
/*     */ {
/*     */   public int field_70533_a;
/*     */   public int field_70531_b;
/*     */   public int field_70532_c;
/*  20 */   private int field_70529_d = 5;
/*     */   
/*     */   public int field_70530_e;
/*     */   private EntityPlayer field_80001_f;
/*     */   
/*     */   public EntityXPOrb(World p_i1585_1_, double p_i1585_2_, double p_i1585_4_, double p_i1585_6_, int p_i1585_8_) {
/*  26 */     super(p_i1585_1_);
/*  27 */     func_70105_a(0.5F, 0.5F);
/*  28 */     this.field_70129_M = this.field_70131_O / 2.0F;
/*  29 */     func_70107_b(p_i1585_2_, p_i1585_4_, p_i1585_6_);
/*     */     
/*  31 */     this.field_70177_z = (float)(Math.random() * 360.0D);
/*     */     
/*  33 */     this.field_70159_w = ((float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D) * 2.0F);
/*  34 */     this.field_70181_x = ((float)(Math.random() * 0.2D) * 2.0F);
/*  35 */     this.field_70179_y = ((float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D) * 2.0F);
/*     */     
/*  37 */     this.field_70530_e = p_i1585_8_;
/*     */   }
/*     */   private int field_80002_g; private static final String __OBFID = "CL_00001544";
/*     */   
/*     */   protected boolean func_70041_e_() {
/*  42 */     return false;
/*     */   }
/*     */   
/*     */   public EntityXPOrb(World p_i1586_1_) {
/*  46 */     super(p_i1586_1_);
/*  47 */     func_70105_a(0.25F, 0.25F);
/*  48 */     this.field_70129_M = this.field_70131_O / 2.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {}
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_70070_b(float p_70070_1_) {
/*  57 */     float f = 0.5F;
/*  58 */     if (f < 0.0F) f = 0.0F; 
/*  59 */     if (f > 1.0F) f = 1.0F; 
/*  60 */     int i = super.func_70070_b(p_70070_1_);
/*     */     
/*  62 */     int j = i & 0xFF;
/*  63 */     int k = i >> 16 & 0xFF;
/*  64 */     j += (int)(f * 15.0F * 16.0F);
/*  65 */     if (j > 240) j = 240; 
/*  66 */     return j | k << 16;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/*  71 */     super.func_70071_h_();
/*  72 */     if (this.field_70532_c > 0) this.field_70532_c--; 
/*  73 */     this.field_70169_q = this.field_70165_t;
/*  74 */     this.field_70167_r = this.field_70163_u;
/*  75 */     this.field_70166_s = this.field_70161_v;
/*     */     
/*  77 */     this.field_70181_x -= 0.029999999329447746D;
/*  78 */     if (this.field_70170_p.func_147439_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v)).func_149688_o() == Material.field_151587_i) {
/*  79 */       this.field_70181_x = 0.20000000298023224D;
/*  80 */       this.field_70159_w = ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F);
/*  81 */       this.field_70179_y = ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F);
/*  82 */       func_85030_a("random.fizz", 0.4F, 2.0F + this.field_70146_Z.nextFloat() * 0.4F);
/*     */     } 
/*  84 */     func_145771_j(this.field_70165_t, (this.field_70121_D.field_72338_b + this.field_70121_D.field_72337_e) / 2.0D, this.field_70161_v);
/*     */     
/*  86 */     double d = 8.0D;
/*     */ 
/*     */     
/*  89 */     if (this.field_80002_g < this.field_70533_a - 20 + func_145782_y() % 100) {
/*  90 */       if (this.field_80001_f == null || this.field_80001_f.func_70068_e(this) > d * d) {
/*  91 */         this.field_80001_f = this.field_70170_p.func_72890_a(this, d);
/*     */       }
/*  93 */       this.field_80002_g = this.field_70533_a;
/*     */     } 
/*     */     
/*  96 */     if (this.field_80001_f != null) {
/*  97 */       double d1 = (this.field_80001_f.field_70165_t - this.field_70165_t) / d;
/*  98 */       double d2 = (this.field_80001_f.field_70163_u + this.field_80001_f.func_70047_e() - this.field_70163_u) / d;
/*  99 */       double d3 = (this.field_80001_f.field_70161_v - this.field_70161_v) / d;
/* 100 */       double d4 = Math.sqrt(d1 * d1 + d2 * d2 + d3 * d3);
/* 101 */       double d5 = 1.0D - d4;
/* 102 */       if (d5 > 0.0D) {
/* 103 */         d5 *= d5;
/* 104 */         this.field_70159_w += d1 / d4 * d5 * 0.1D;
/* 105 */         this.field_70181_x += d2 / d4 * d5 * 0.1D;
/* 106 */         this.field_70179_y += d3 / d4 * d5 * 0.1D;
/*     */       } 
/*     */     } 
/*     */     
/* 110 */     func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*     */     
/* 112 */     float f = 0.98F;
/* 113 */     if (this.field_70122_E) {
/* 114 */       f = (this.field_70170_p.func_147439_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70121_D.field_72338_b) - 1, MathHelper.func_76128_c(this.field_70161_v))).field_149765_K * 0.98F;
/*     */     }
/*     */     
/* 117 */     this.field_70159_w *= f;
/* 118 */     this.field_70181_x *= 0.9800000190734863D;
/* 119 */     this.field_70179_y *= f;
/*     */     
/* 121 */     if (this.field_70122_E) {
/* 122 */       this.field_70181_x *= -0.8999999761581421D;
/*     */     }
/*     */     
/* 125 */     this.field_70533_a++;
/*     */     
/* 127 */     this.field_70531_b++;
/* 128 */     if (this.field_70531_b >= 6000) {
/* 129 */       func_70106_y();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70072_I() {
/* 135 */     return this.field_70170_p.func_72918_a(this.field_70121_D, Material.field_151586_h, this);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70081_e(int p_70081_1_) {
/* 140 */     func_70097_a(DamageSource.field_76372_a, p_70081_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource p_70097_1_, float p_70097_2_) {
/* 145 */     if (func_85032_ar()) return false; 
/* 146 */     func_70018_K();
/* 147 */     this.field_70529_d = (int)(this.field_70529_d - p_70097_2_);
/* 148 */     if (this.field_70529_d <= 0) {
/* 149 */       func_70106_y();
/*     */     }
/* 151 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound p_70014_1_) {
/* 156 */     p_70014_1_.func_74777_a("Health", (short)(byte)this.field_70529_d);
/* 157 */     p_70014_1_.func_74777_a("Age", (short)this.field_70531_b);
/* 158 */     p_70014_1_.func_74777_a("Value", (short)this.field_70530_e);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound p_70037_1_) {
/* 163 */     this.field_70529_d = p_70037_1_.func_74765_d("Health") & 0xFF;
/* 164 */     this.field_70531_b = p_70037_1_.func_74765_d("Age");
/* 165 */     this.field_70530_e = p_70037_1_.func_74765_d("Value");
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70100_b_(EntityPlayer p_70100_1_) {
/* 170 */     if (this.field_70170_p.field_72995_K)
/*     */       return; 
/* 172 */     if (this.field_70532_c == 0 && p_70100_1_.field_71090_bL == 0) {
/* 173 */       p_70100_1_.field_71090_bL = 2;
/* 174 */       this.field_70170_p.func_72956_a((Entity)p_70100_1_, "random.orb", 0.1F, 0.5F * ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.7F + 1.8F));
/* 175 */       p_70100_1_.func_71001_a(this, 1);
/* 176 */       p_70100_1_.func_71023_q(this.field_70530_e);
/* 177 */       func_70106_y();
/*     */     } 
/*     */   }
/*     */   
/*     */   public int func_70526_d() {
/* 182 */     return this.field_70530_e;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_70528_g() {
/* 187 */     if (this.field_70530_e >= 2477)
/* 188 */       return 10; 
/* 189 */     if (this.field_70530_e >= 1237)
/* 190 */       return 9; 
/* 191 */     if (this.field_70530_e >= 617)
/* 192 */       return 8; 
/* 193 */     if (this.field_70530_e >= 307)
/* 194 */       return 7; 
/* 195 */     if (this.field_70530_e >= 149)
/* 196 */       return 6; 
/* 197 */     if (this.field_70530_e >= 73)
/* 198 */       return 5; 
/* 199 */     if (this.field_70530_e >= 37)
/* 200 */       return 4; 
/* 201 */     if (this.field_70530_e >= 17)
/* 202 */       return 3; 
/* 203 */     if (this.field_70530_e >= 7)
/* 204 */       return 2; 
/* 205 */     if (this.field_70530_e >= 3) {
/* 206 */       return 1;
/*     */     }
/*     */     
/* 209 */     return 0;
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
/*     */   public static int func_70527_a(int p_70527_0_) {
/* 222 */     if (p_70527_0_ >= 2477)
/* 223 */       return 2477; 
/* 224 */     if (p_70527_0_ >= 1237)
/* 225 */       return 1237; 
/* 226 */     if (p_70527_0_ >= 617)
/* 227 */       return 617; 
/* 228 */     if (p_70527_0_ >= 307)
/* 229 */       return 307; 
/* 230 */     if (p_70527_0_ >= 149)
/* 231 */       return 149; 
/* 232 */     if (p_70527_0_ >= 73)
/* 233 */       return 73; 
/* 234 */     if (p_70527_0_ >= 37)
/* 235 */       return 37; 
/* 236 */     if (p_70527_0_ >= 17)
/* 237 */       return 17; 
/* 238 */     if (p_70527_0_ >= 7)
/* 239 */       return 7; 
/* 240 */     if (p_70527_0_ >= 3) {
/* 241 */       return 3;
/*     */     }
/*     */     
/* 244 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70075_an() {
/* 249 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\item\EntityXPOrb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */