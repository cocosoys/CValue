/*     */ package net.minecraft.entity.passive;
/*     */ 
/*     */ import java.util.Calendar;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.ChunkCoordinates;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntityBat
/*     */   extends EntityAmbientCreature
/*     */ {
/*     */   private ChunkCoordinates field_82237_a;
/*     */   private static final String __OBFID = "CL_00001637";
/*     */   
/*     */   public EntityBat(World p_i1680_1_) {
/*  24 */     super(p_i1680_1_);
/*     */     
/*  26 */     func_70105_a(0.5F, 0.9F);
/*  27 */     func_82236_f(true);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/*  32 */     super.func_70088_a();
/*     */     
/*  34 */     this.field_70180_af.func_75682_a(16, new Byte((byte)0));
/*     */   }
/*     */ 
/*     */   
/*     */   protected float func_70599_aP() {
/*  39 */     return 0.1F;
/*     */   }
/*     */ 
/*     */   
/*     */   protected float func_70647_i() {
/*  44 */     return super.func_70647_i() * 0.95F;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70639_aQ() {
/*  49 */     if (func_82235_h() && this.field_70146_Z.nextInt(4) != 0) {
/*  50 */       return null;
/*     */     }
/*  52 */     return "mob.bat.idle";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70621_aR() {
/*  57 */     return "mob.bat.hurt";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70673_aS() {
/*  62 */     return "mob.bat.death";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70104_M() {
/*  68 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_82167_n(Entity p_82167_1_) {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_85033_bc() {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  83 */     super.func_110147_ax();
/*     */     
/*  85 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(6.0D);
/*     */   }
/*     */   
/*     */   public boolean func_82235_h() {
/*  89 */     return ((this.field_70180_af.func_75683_a(16) & 0x1) != 0);
/*     */   }
/*     */   
/*     */   public void func_82236_f(boolean p_82236_1_) {
/*  93 */     byte b = this.field_70180_af.func_75683_a(16);
/*  94 */     if (p_82236_1_) {
/*  95 */       this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)(b | 0x1)));
/*     */     } else {
/*  97 */       this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)(b & 0xFFFFFFFE)));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean func_70650_aV() {
/* 103 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/* 109 */     super.func_70071_h_();
/*     */ 
/*     */     
/* 112 */     this.field_70159_w = this.field_70181_x = this.field_70179_y = 0.0D;
/* 113 */     this.field_70163_u = MathHelper.func_76128_c(this.field_70163_u) + 1.0D - this.field_70131_O;
/*     */     
/* 115 */     this.field_70181_x *= 0.6000000238418579D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70619_bc() {
/* 122 */     super.func_70619_bc();
/*     */     
/* 124 */     if (func_82235_h()) {
/* 125 */       if (!this.field_70170_p.func_147439_a(MathHelper.func_76128_c(this.field_70165_t), (int)this.field_70163_u + 1, MathHelper.func_76128_c(this.field_70161_v)).func_149721_r()) {
/* 126 */         func_82236_f(false);
/* 127 */         this.field_70170_p.func_72889_a(null, 1015, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
/*     */       } else {
/*     */         
/* 130 */         if (this.field_70146_Z.nextInt(200) == 0) {
/* 131 */           this.field_70759_as = this.field_70146_Z.nextInt(360);
/*     */         }
/*     */         
/* 134 */         if (this.field_70170_p.func_72890_a((Entity)this, 4.0D) != null) {
/* 135 */           func_82236_f(false);
/* 136 */           this.field_70170_p.func_72889_a(null, 1015, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
/*     */         }
/*     */       
/*     */       } 
/*     */     } else {
/*     */       
/* 142 */       if (this.field_82237_a != null && (!this.field_70170_p.func_147437_c(this.field_82237_a.field_71574_a, this.field_82237_a.field_71572_b, this.field_82237_a.field_71573_c) || this.field_82237_a.field_71572_b < 1)) {
/* 143 */         this.field_82237_a = null;
/*     */       }
/* 145 */       if (this.field_82237_a == null || this.field_70146_Z.nextInt(30) == 0 || this.field_82237_a.func_71569_e((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v) < 4.0F) {
/* 146 */         this.field_82237_a = new ChunkCoordinates((int)this.field_70165_t + this.field_70146_Z.nextInt(7) - this.field_70146_Z.nextInt(7), (int)this.field_70163_u + this.field_70146_Z.nextInt(6) - 2, (int)this.field_70161_v + this.field_70146_Z.nextInt(7) - this.field_70146_Z.nextInt(7));
/*     */       }
/*     */       
/* 149 */       double d1 = this.field_82237_a.field_71574_a + 0.5D - this.field_70165_t;
/* 150 */       double d2 = this.field_82237_a.field_71572_b + 0.1D - this.field_70163_u;
/* 151 */       double d3 = this.field_82237_a.field_71573_c + 0.5D - this.field_70161_v;
/*     */       
/* 153 */       this.field_70159_w += (Math.signum(d1) * 0.5D - this.field_70159_w) * 0.10000000149011612D;
/* 154 */       this.field_70181_x += (Math.signum(d2) * 0.699999988079071D - this.field_70181_x) * 0.10000000149011612D;
/* 155 */       this.field_70179_y += (Math.signum(d3) * 0.5D - this.field_70179_y) * 0.10000000149011612D;
/*     */       
/* 157 */       float f1 = (float)(Math.atan2(this.field_70179_y, this.field_70159_w) * 180.0D / 3.1415927410125732D) - 90.0F;
/* 158 */       float f2 = MathHelper.func_76142_g(f1 - this.field_70177_z);
/* 159 */       this.field_70701_bs = 0.5F;
/* 160 */       this.field_70177_z += f2;
/*     */       
/* 162 */       if (this.field_70146_Z.nextInt(100) == 0 && this.field_70170_p.func_147439_a(MathHelper.func_76128_c(this.field_70165_t), (int)this.field_70163_u + 1, MathHelper.func_76128_c(this.field_70161_v)).func_149721_r()) {
/* 163 */         func_82236_f(true);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean func_70041_e_() {
/* 171 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70069_a(float p_70069_1_) {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70064_a(double p_70064_1_, boolean p_70064_3_) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_145773_az() {
/* 186 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource p_70097_1_, float p_70097_2_) {
/* 192 */     if (func_85032_ar()) return false; 
/* 193 */     if (!this.field_70170_p.field_72995_K && 
/* 194 */       func_82235_h()) {
/* 195 */       func_82236_f(false);
/*     */     }
/*     */ 
/*     */     
/* 199 */     return super.func_70097_a(p_70097_1_, p_70097_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound p_70037_1_) {
/* 204 */     super.func_70037_a(p_70037_1_);
/*     */     
/* 206 */     this.field_70180_af.func_75692_b(16, Byte.valueOf(p_70037_1_.func_74771_c("BatFlags")));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound p_70014_1_) {
/* 211 */     super.func_70014_b(p_70014_1_);
/*     */     
/* 213 */     p_70014_1_.func_74774_a("BatFlags", this.field_70180_af.func_75683_a(16));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70601_bi() {
/* 219 */     int i = MathHelper.func_76128_c(this.field_70121_D.field_72338_b);
/* 220 */     if (i >= 63) return false;
/*     */     
/* 222 */     int j = MathHelper.func_76128_c(this.field_70165_t);
/* 223 */     int k = MathHelper.func_76128_c(this.field_70161_v);
/*     */     
/* 225 */     int m = this.field_70170_p.func_72957_l(j, i, k);
/* 226 */     byte b = 4;
/* 227 */     Calendar calendar = this.field_70170_p.func_83015_S();
/*     */     
/* 229 */     if ((calendar.get(2) + 1 == 10 && calendar.get(5) >= 20) || (calendar.get(2) + 1 == 11 && calendar.get(5) <= 3)) {
/* 230 */       b = 7;
/* 231 */     } else if (this.field_70146_Z.nextBoolean()) {
/* 232 */       return false;
/*     */     } 
/*     */     
/* 235 */     if (m > this.field_70146_Z.nextInt(b)) return false;
/*     */     
/* 237 */     return super.func_70601_bi();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\passive\EntityBat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */