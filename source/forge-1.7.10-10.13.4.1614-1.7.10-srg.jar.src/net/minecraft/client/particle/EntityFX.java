/*     */ package net.minecraft.client.particle;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class EntityFX
/*     */   extends Entity {
/*     */   protected int field_94054_b;
/*     */   protected int field_94055_c;
/*     */   protected float field_70548_b;
/*     */   protected float field_70549_c;
/*     */   protected int field_70546_d;
/*  20 */   protected float field_82339_as = 1.0F; protected int field_70547_e; protected float field_70544_f; protected float field_70545_g; protected float field_70552_h; protected float field_70553_i; protected float field_70551_j; protected IIcon field_70550_a; public static double field_70556_an;
/*     */   public static double field_70554_ao;
/*     */   public static double field_70555_ap;
/*     */   private static final String __OBFID = "CL_00000914";
/*     */   
/*     */   protected EntityFX(World p_i1218_1_, double p_i1218_2_, double p_i1218_4_, double p_i1218_6_) {
/*  26 */     super(p_i1218_1_);
/*     */     
/*  28 */     func_70105_a(0.2F, 0.2F);
/*  29 */     this.field_70129_M = this.field_70131_O / 2.0F;
/*  30 */     func_70107_b(p_i1218_2_, p_i1218_4_, p_i1218_6_);
/*  31 */     this.field_70142_S = p_i1218_2_;
/*  32 */     this.field_70137_T = p_i1218_4_;
/*  33 */     this.field_70136_U = p_i1218_6_;
/*  34 */     this.field_70552_h = this.field_70553_i = this.field_70551_j = 1.0F;
/*     */     
/*  36 */     this.field_70548_b = this.field_70146_Z.nextFloat() * 3.0F;
/*  37 */     this.field_70549_c = this.field_70146_Z.nextFloat() * 3.0F;
/*     */     
/*  39 */     this.field_70544_f = (this.field_70146_Z.nextFloat() * 0.5F + 0.5F) * 2.0F;
/*     */     
/*  41 */     this.field_70547_e = (int)(4.0F / (this.field_70146_Z.nextFloat() * 0.9F + 0.1F));
/*  42 */     this.field_70546_d = 0;
/*     */   }
/*     */   
/*     */   public EntityFX(World p_i1219_1_, double p_i1219_2_, double p_i1219_4_, double p_i1219_6_, double p_i1219_8_, double p_i1219_10_, double p_i1219_12_) {
/*  46 */     this(p_i1219_1_, p_i1219_2_, p_i1219_4_, p_i1219_6_);
/*     */     
/*  48 */     this.field_70159_w = p_i1219_8_ + ((float)(Math.random() * 2.0D - 1.0D) * 0.4F);
/*  49 */     this.field_70181_x = p_i1219_10_ + ((float)(Math.random() * 2.0D - 1.0D) * 0.4F);
/*  50 */     this.field_70179_y = p_i1219_12_ + ((float)(Math.random() * 2.0D - 1.0D) * 0.4F);
/*  51 */     float f1 = (float)(Math.random() + Math.random() + 1.0D) * 0.15F;
/*     */     
/*  53 */     float f2 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y);
/*  54 */     this.field_70159_w = this.field_70159_w / f2 * f1 * 0.4000000059604645D;
/*  55 */     this.field_70181_x = this.field_70181_x / f2 * f1 * 0.4000000059604645D + 0.10000000149011612D;
/*  56 */     this.field_70179_y = this.field_70179_y / f2 * f1 * 0.4000000059604645D;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityFX func_70543_e(float p_70543_1_) {
/*  61 */     this.field_70159_w *= p_70543_1_;
/*  62 */     this.field_70181_x = (this.field_70181_x - 0.10000000149011612D) * p_70543_1_ + 0.10000000149011612D;
/*  63 */     this.field_70179_y *= p_70543_1_;
/*  64 */     return this;
/*     */   }
/*     */   
/*     */   public EntityFX func_70541_f(float p_70541_1_) {
/*  68 */     func_70105_a(0.2F * p_70541_1_, 0.2F * p_70541_1_);
/*  69 */     this.field_70544_f *= p_70541_1_;
/*  70 */     return this;
/*     */   }
/*     */   
/*     */   public void func_70538_b(float p_70538_1_, float p_70538_2_, float p_70538_3_) {
/*  74 */     this.field_70552_h = p_70538_1_;
/*  75 */     this.field_70553_i = p_70538_2_;
/*  76 */     this.field_70551_j = p_70538_3_;
/*     */   }
/*     */   
/*     */   public void func_82338_g(float p_82338_1_) {
/*  80 */     this.field_82339_as = p_82338_1_;
/*     */   }
/*     */   
/*     */   public float func_70534_d() {
/*  84 */     return this.field_70552_h;
/*     */   }
/*     */   
/*     */   public float func_70542_f() {
/*  88 */     return this.field_70553_i;
/*     */   }
/*     */   
/*     */   public float func_70535_g() {
/*  92 */     return this.field_70551_j;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean func_70041_e_() {
/* 101 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {}
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/* 110 */     this.field_70169_q = this.field_70165_t;
/* 111 */     this.field_70167_r = this.field_70163_u;
/* 112 */     this.field_70166_s = this.field_70161_v;
/*     */     
/* 114 */     if (this.field_70546_d++ >= this.field_70547_e) func_70106_y();
/*     */     
/* 116 */     this.field_70181_x -= 0.04D * this.field_70545_g;
/* 117 */     func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/* 118 */     this.field_70159_w *= 0.9800000190734863D;
/* 119 */     this.field_70181_x *= 0.9800000190734863D;
/* 120 */     this.field_70179_y *= 0.9800000190734863D;
/*     */     
/* 122 */     if (this.field_70122_E) {
/* 123 */       this.field_70159_w *= 0.699999988079071D;
/* 124 */       this.field_70179_y *= 0.699999988079071D;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_70539_a(Tessellator p_70539_1_, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_) {
/* 129 */     float f1 = this.field_94054_b / 16.0F;
/* 130 */     float f2 = f1 + 0.0624375F;
/* 131 */     float f3 = this.field_94055_c / 16.0F;
/* 132 */     float f4 = f3 + 0.0624375F;
/* 133 */     float f5 = 0.1F * this.field_70544_f;
/*     */     
/* 135 */     if (this.field_70550_a != null) {
/* 136 */       f1 = this.field_70550_a.func_94209_e();
/* 137 */       f2 = this.field_70550_a.func_94212_f();
/* 138 */       f3 = this.field_70550_a.func_94206_g();
/* 139 */       f4 = this.field_70550_a.func_94210_h();
/*     */     } 
/*     */     
/* 142 */     float f6 = (float)(this.field_70169_q + (this.field_70165_t - this.field_70169_q) * p_70539_2_ - field_70556_an);
/* 143 */     float f7 = (float)(this.field_70167_r + (this.field_70163_u - this.field_70167_r) * p_70539_2_ - field_70554_ao);
/* 144 */     float f8 = (float)(this.field_70166_s + (this.field_70161_v - this.field_70166_s) * p_70539_2_ - field_70555_ap);
/*     */     
/* 146 */     p_70539_1_.func_78369_a(this.field_70552_h, this.field_70553_i, this.field_70551_j, this.field_82339_as);
/*     */     
/* 148 */     p_70539_1_.func_78374_a((f6 - p_70539_3_ * f5 - p_70539_6_ * f5), (f7 - p_70539_4_ * f5), (f8 - p_70539_5_ * f5 - p_70539_7_ * f5), f2, f4);
/* 149 */     p_70539_1_.func_78374_a((f6 - p_70539_3_ * f5 + p_70539_6_ * f5), (f7 + p_70539_4_ * f5), (f8 - p_70539_5_ * f5 + p_70539_7_ * f5), f2, f3);
/* 150 */     p_70539_1_.func_78374_a((f6 + p_70539_3_ * f5 + p_70539_6_ * f5), (f7 + p_70539_4_ * f5), (f8 + p_70539_5_ * f5 + p_70539_7_ * f5), f1, f3);
/* 151 */     p_70539_1_.func_78374_a((f6 + p_70539_3_ * f5 - p_70539_6_ * f5), (f7 - p_70539_4_ * f5), (f8 + p_70539_5_ * f5 - p_70539_7_ * f5), f1, f4);
/*     */   }
/*     */   
/*     */   public int func_70537_b() {
/* 155 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound p_70014_1_) {}
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound p_70037_1_) {}
/*     */ 
/*     */   
/*     */   public void func_110125_a(IIcon p_110125_1_) {
/* 167 */     if (func_70537_b() == 1) {
/* 168 */       this.field_70550_a = p_110125_1_;
/* 169 */     } else if (func_70537_b() == 2) {
/* 170 */       this.field_70550_a = p_110125_1_;
/*     */     } else {
/* 172 */       throw new RuntimeException("Invalid call to Particle.setTex, use coordinate methods");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_70536_a(int p_70536_1_) {
/* 177 */     if (func_70537_b() != 0) {
/* 178 */       throw new RuntimeException("Invalid call to Particle.setMiscTex");
/*     */     }
/* 180 */     this.field_94054_b = p_70536_1_ % 16;
/* 181 */     this.field_94055_c = p_70536_1_ / 16;
/*     */   }
/*     */   
/*     */   public void func_94053_h() {
/* 185 */     this.field_94054_b++;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70075_an() {
/* 190 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 195 */     return getClass().getSimpleName() + ", Pos (" + this.field_70165_t + "," + this.field_70163_u + "," + this.field_70161_v + "), RGBA (" + this.field_70552_h + "," + this.field_70553_i + "," + this.field_70551_j + "," + this.field_82339_as + "), Age " + this.field_70546_d;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\particle\EntityFX.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */