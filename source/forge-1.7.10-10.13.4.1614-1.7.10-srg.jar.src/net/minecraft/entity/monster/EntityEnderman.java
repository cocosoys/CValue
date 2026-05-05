/*     */ package net.minecraft.entity.monster;
/*     */ 
/*     */ import java.util.UUID;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.attributes.AttributeModifier;
/*     */ import net.minecraft.entity.ai.attributes.IAttributeInstance;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntityEnderman
/*     */   extends EntityMob
/*     */ {
/*  26 */   private static final UUID field_110192_bp = UUID.fromString("020E0DFB-87AE-4653-9556-831010E291A0");
/*  27 */   private static final AttributeModifier field_110193_bq = (new AttributeModifier(field_110192_bp, "Attacking speed boost", 6.199999809265137D, 0)).func_111168_a(false);
/*     */   
/*  29 */   private static boolean[] field_70827_d = new boolean[256];
/*     */   
/*     */   static {
/*  32 */     field_70827_d[Block.func_149682_b((Block)Blocks.field_150349_c)] = true;
/*  33 */     field_70827_d[Block.func_149682_b(Blocks.field_150346_d)] = true;
/*  34 */     field_70827_d[Block.func_149682_b((Block)Blocks.field_150354_m)] = true;
/*  35 */     field_70827_d[Block.func_149682_b(Blocks.field_150351_n)] = true;
/*  36 */     field_70827_d[Block.func_149682_b((Block)Blocks.field_150327_N)] = true;
/*  37 */     field_70827_d[Block.func_149682_b((Block)Blocks.field_150328_O)] = true;
/*  38 */     field_70827_d[Block.func_149682_b((Block)Blocks.field_150338_P)] = true;
/*  39 */     field_70827_d[Block.func_149682_b((Block)Blocks.field_150337_Q)] = true;
/*  40 */     field_70827_d[Block.func_149682_b(Blocks.field_150335_W)] = true;
/*  41 */     field_70827_d[Block.func_149682_b(Blocks.field_150434_aF)] = true;
/*  42 */     field_70827_d[Block.func_149682_b(Blocks.field_150435_aG)] = true;
/*  43 */     field_70827_d[Block.func_149682_b(Blocks.field_150423_aK)] = true;
/*  44 */     field_70827_d[Block.func_149682_b(Blocks.field_150440_ba)] = true;
/*  45 */     field_70827_d[Block.func_149682_b((Block)Blocks.field_150391_bh)] = true;
/*     */   }
/*     */ 
/*     */   
/*     */   private int field_70828_e;
/*     */   
/*     */   private int field_70826_g;
/*     */   
/*     */   private Entity field_110194_bu;
/*     */   private boolean field_104003_g;
/*     */   private static final String __OBFID = "CL_00001685";
/*     */   
/*     */   public EntityEnderman(World p_i1734_1_) {
/*  58 */     super(p_i1734_1_);
/*  59 */     func_70105_a(0.6F, 2.9F);
/*  60 */     this.field_70138_W = 1.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  65 */     super.func_110147_ax();
/*     */     
/*  67 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(40.0D);
/*  68 */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.30000001192092896D);
/*  69 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(7.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/*  74 */     super.func_70088_a();
/*     */     
/*  76 */     this.field_70180_af.func_75682_a(16, new Byte((byte)0));
/*  77 */     this.field_70180_af.func_75682_a(17, new Byte((byte)0));
/*  78 */     this.field_70180_af.func_75682_a(18, new Byte((byte)0));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound p_70014_1_) {
/*  83 */     super.func_70014_b(p_70014_1_);
/*  84 */     p_70014_1_.func_74777_a("carried", (short)Block.func_149682_b(func_146080_bZ()));
/*  85 */     p_70014_1_.func_74777_a("carriedData", (short)func_70824_q());
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound p_70037_1_) {
/*  90 */     super.func_70037_a(p_70037_1_);
/*  91 */     func_146081_a(Block.func_149729_e(p_70037_1_.func_74765_d("carried")));
/*  92 */     func_70817_b(p_70037_1_.func_74765_d("carriedData"));
/*     */   }
/*     */ 
/*     */   
/*     */   protected Entity func_70782_k() {
/*  97 */     EntityPlayer entityPlayer = this.field_70170_p.func_72856_b((Entity)this, 64.0D);
/*  98 */     if (entityPlayer != null) {
/*  99 */       if (func_70821_d(entityPlayer)) {
/* 100 */         this.field_104003_g = true;
/* 101 */         if (this.field_70826_g == 0) this.field_70170_p.func_72908_a(entityPlayer.field_70165_t, entityPlayer.field_70163_u, entityPlayer.field_70161_v, "mob.endermen.stare", 1.0F, 1.0F); 
/* 102 */         if (this.field_70826_g++ == 5) {
/* 103 */           this.field_70826_g = 0;
/* 104 */           func_70819_e(true);
/* 105 */           return (Entity)entityPlayer;
/*     */         } 
/*     */       } else {
/* 108 */         this.field_70826_g = 0;
/*     */       } 
/*     */     }
/* 111 */     return null;
/*     */   }
/*     */   
/*     */   private boolean func_70821_d(EntityPlayer p_70821_1_) {
/* 115 */     ItemStack itemStack = p_70821_1_.field_71071_by.field_70460_b[3];
/* 116 */     if (itemStack != null && itemStack.func_77973_b() == Item.func_150898_a(Blocks.field_150423_aK)) return false;
/*     */     
/* 118 */     Vec3 vec31 = p_70821_1_.func_70676_i(1.0F).func_72432_b();
/* 119 */     Vec3 vec32 = Vec3.func_72443_a(this.field_70165_t - p_70821_1_.field_70165_t, this.field_70121_D.field_72338_b + (this.field_70131_O / 2.0F) - p_70821_1_.field_70163_u + p_70821_1_.func_70047_e(), this.field_70161_v - p_70821_1_.field_70161_v);
/* 120 */     double d1 = vec32.func_72433_c();
/* 121 */     vec32 = vec32.func_72432_b();
/* 122 */     double d2 = vec31.func_72430_b(vec32);
/* 123 */     return (d2 > 1.0D - 0.025D / d1 && p_70821_1_.func_70685_l((Entity)this));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/* 128 */     if (func_70026_G()) func_70097_a(DamageSource.field_76369_e, 1.0F);
/*     */     
/* 130 */     if (this.field_110194_bu != this.field_70789_a) {
/* 131 */       IAttributeInstance iAttributeInstance = func_110148_a(SharedMonsterAttributes.field_111263_d);
/* 132 */       iAttributeInstance.func_111124_b(field_110193_bq);
/*     */       
/* 134 */       if (this.field_70789_a != null) {
/* 135 */         iAttributeInstance.func_111121_a(field_110193_bq);
/*     */       }
/*     */     } 
/*     */     
/* 139 */     this.field_110194_bu = this.field_70789_a;
/*     */     
/* 141 */     if (!this.field_70170_p.field_72995_K && 
/* 142 */       this.field_70170_p.func_82736_K().func_82766_b("mobGriefing")) {
/* 143 */       if (func_146080_bZ().func_149688_o() == Material.field_151579_a) {
/* 144 */         if (this.field_70146_Z.nextInt(20) == 0) {
/* 145 */           int i = MathHelper.func_76128_c(this.field_70165_t - 2.0D + this.field_70146_Z.nextDouble() * 4.0D);
/* 146 */           int j = MathHelper.func_76128_c(this.field_70163_u + this.field_70146_Z.nextDouble() * 3.0D);
/* 147 */           int k = MathHelper.func_76128_c(this.field_70161_v - 2.0D + this.field_70146_Z.nextDouble() * 4.0D);
/* 148 */           Block block = this.field_70170_p.func_147439_a(i, j, k);
/* 149 */           if (field_70827_d[Block.func_149682_b(block)]) {
/* 150 */             func_146081_a(block);
/* 151 */             func_70817_b(this.field_70170_p.func_72805_g(i, j, k));
/* 152 */             this.field_70170_p.func_147449_b(i, j, k, Blocks.field_150350_a);
/*     */           }
/*     */         
/*     */         } 
/* 156 */       } else if (this.field_70146_Z.nextInt(2000) == 0) {
/* 157 */         int i = MathHelper.func_76128_c(this.field_70165_t - 1.0D + this.field_70146_Z.nextDouble() * 2.0D);
/* 158 */         int j = MathHelper.func_76128_c(this.field_70163_u + this.field_70146_Z.nextDouble() * 2.0D);
/* 159 */         int k = MathHelper.func_76128_c(this.field_70161_v - 1.0D + this.field_70146_Z.nextDouble() * 2.0D);
/* 160 */         Block block1 = this.field_70170_p.func_147439_a(i, j, k);
/* 161 */         Block block2 = this.field_70170_p.func_147439_a(i, j - 1, k);
/* 162 */         if (block1.func_149688_o() == Material.field_151579_a && block2.func_149688_o() != Material.field_151579_a && block2.func_149686_d()) {
/* 163 */           this.field_70170_p.func_147465_d(i, j, k, func_146080_bZ(), func_70824_q(), 3);
/* 164 */           func_146081_a(Blocks.field_150350_a);
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 172 */     for (byte b = 0; b < 2; b++) {
/* 173 */       this.field_70170_p.func_72869_a("portal", this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5D) * this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * this.field_70131_O - 0.25D, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5D) * this.field_70130_N, (this.field_70146_Z.nextDouble() - 0.5D) * 2.0D, -this.field_70146_Z.nextDouble(), (this.field_70146_Z.nextDouble() - 0.5D) * 2.0D);
/*     */     }
/*     */ 
/*     */     
/* 177 */     if (this.field_70170_p.func_72935_r() && !this.field_70170_p.field_72995_K) {
/* 178 */       float f = func_70013_c(1.0F);
/* 179 */       if (f > 0.5F && 
/* 180 */         this.field_70170_p.func_72937_j(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v)) && this.field_70146_Z.nextFloat() * 30.0F < (f - 0.4F) * 2.0F) {
/* 181 */         this.field_70789_a = null;
/* 182 */         func_70819_e(false);
/* 183 */         this.field_104003_g = false;
/* 184 */         func_70820_n();
/*     */       } 
/*     */     } 
/*     */     
/* 188 */     if (func_70026_G() || func_70027_ad()) {
/* 189 */       this.field_70789_a = null;
/* 190 */       func_70819_e(false);
/* 191 */       this.field_104003_g = false;
/* 192 */       func_70820_n();
/*     */     } 
/*     */     
/* 195 */     if (func_70823_r() && !this.field_104003_g && this.field_70146_Z.nextInt(100) == 0) {
/* 196 */       func_70819_e(false);
/*     */     }
/*     */     
/* 199 */     this.field_70703_bu = false;
/* 200 */     if (this.field_70789_a != null) {
/* 201 */       func_70625_a(this.field_70789_a, 100.0F, 100.0F);
/*     */     }
/*     */     
/* 204 */     if (!this.field_70170_p.field_72995_K && func_70089_S()) {
/* 205 */       if (this.field_70789_a != null) {
/* 206 */         if (this.field_70789_a instanceof EntityPlayer && func_70821_d((EntityPlayer)this.field_70789_a)) {
/* 207 */           if (this.field_70789_a.func_70068_e((Entity)this) < 16.0D) {
/* 208 */             func_70820_n();
/*     */           }
/* 210 */           this.field_70828_e = 0;
/* 211 */         } else if (this.field_70789_a.func_70068_e((Entity)this) > 256.0D && 
/* 212 */           this.field_70828_e++ >= 30 && 
/* 213 */           func_70816_c(this.field_70789_a)) {
/* 214 */           this.field_70828_e = 0;
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 219 */         func_70819_e(false);
/* 220 */         this.field_70828_e = 0;
/*     */       } 
/*     */     }
/*     */     
/* 224 */     super.func_70636_d();
/*     */   }
/*     */   
/*     */   protected boolean func_70820_n() {
/* 228 */     double d1 = this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5D) * 64.0D;
/* 229 */     double d2 = this.field_70163_u + (this.field_70146_Z.nextInt(64) - 32);
/* 230 */     double d3 = this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5D) * 64.0D;
/* 231 */     return func_70825_j(d1, d2, d3);
/*     */   }
/*     */   
/*     */   protected boolean func_70816_c(Entity p_70816_1_) {
/* 235 */     Vec3 vec3 = Vec3.func_72443_a(this.field_70165_t - p_70816_1_.field_70165_t, this.field_70121_D.field_72338_b + (this.field_70131_O / 2.0F) - p_70816_1_.field_70163_u + p_70816_1_.func_70047_e(), this.field_70161_v - p_70816_1_.field_70161_v);
/* 236 */     vec3 = vec3.func_72432_b();
/* 237 */     double d1 = 16.0D;
/* 238 */     double d2 = this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5D) * 8.0D - vec3.field_72450_a * d1;
/* 239 */     double d3 = this.field_70163_u + (this.field_70146_Z.nextInt(16) - 8) - vec3.field_72448_b * d1;
/* 240 */     double d4 = this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5D) * 8.0D - vec3.field_72449_c * d1;
/* 241 */     return func_70825_j(d2, d3, d4);
/*     */   }
/*     */   
/*     */   protected boolean func_70825_j(double p_70825_1_, double p_70825_3_, double p_70825_5_) {
/* 245 */     double d1 = this.field_70165_t;
/* 246 */     double d2 = this.field_70163_u;
/* 247 */     double d3 = this.field_70161_v;
/*     */     
/* 249 */     this.field_70165_t = p_70825_1_;
/* 250 */     this.field_70163_u = p_70825_3_;
/* 251 */     this.field_70161_v = p_70825_5_;
/* 252 */     boolean bool = false;
/* 253 */     int i = MathHelper.func_76128_c(this.field_70165_t);
/* 254 */     int j = MathHelper.func_76128_c(this.field_70163_u);
/* 255 */     int k = MathHelper.func_76128_c(this.field_70161_v);
/*     */     
/* 257 */     if (this.field_70170_p.func_72899_e(i, j, k)) {
/* 258 */       boolean bool1 = false;
/* 259 */       while (!bool1 && j > 0) {
/* 260 */         Block block = this.field_70170_p.func_147439_a(i, j - 1, k);
/* 261 */         if (block.func_149688_o().func_76230_c()) {
/* 262 */           bool1 = true; continue;
/*     */         } 
/* 264 */         this.field_70163_u--;
/* 265 */         j--;
/*     */       } 
/*     */       
/* 268 */       if (bool1) {
/* 269 */         func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 270 */         if (this.field_70170_p.func_72945_a((Entity)this, this.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(this.field_70121_D)) {
/* 271 */           bool = true;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 276 */     if (bool) {
/* 277 */       char c = '';
/* 278 */       for (byte b = 0; b < c; b++) {
/* 279 */         double d4 = b / (c - 1.0D);
/* 280 */         float f1 = (this.field_70146_Z.nextFloat() - 0.5F) * 0.2F;
/* 281 */         float f2 = (this.field_70146_Z.nextFloat() - 0.5F) * 0.2F;
/* 282 */         float f3 = (this.field_70146_Z.nextFloat() - 0.5F) * 0.2F;
/*     */         
/* 284 */         double d5 = d1 + (this.field_70165_t - d1) * d4 + (this.field_70146_Z.nextDouble() - 0.5D) * this.field_70130_N * 2.0D;
/* 285 */         double d6 = d2 + (this.field_70163_u - d2) * d4 + this.field_70146_Z.nextDouble() * this.field_70131_O;
/* 286 */         double d7 = d3 + (this.field_70161_v - d3) * d4 + (this.field_70146_Z.nextDouble() - 0.5D) * this.field_70130_N * 2.0D;
/* 287 */         this.field_70170_p.func_72869_a("portal", d5, d6, d7, f1, f2, f3);
/*     */       } 
/*     */       
/* 290 */       this.field_70170_p.func_72908_a(d1, d2, d3, "mob.endermen.portal", 1.0F, 1.0F);
/* 291 */       func_85030_a("mob.endermen.portal", 1.0F, 1.0F);
/* 292 */       return true;
/*     */     } 
/* 294 */     func_70107_b(d1, d2, d3);
/* 295 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected String func_70639_aQ() {
/* 301 */     return func_70823_r() ? "mob.endermen.scream" : "mob.endermen.idle";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70621_aR() {
/* 306 */     return "mob.endermen.hit";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70673_aS() {
/* 311 */     return "mob.endermen.death";
/*     */   }
/*     */ 
/*     */   
/*     */   protected Item func_146068_u() {
/* 316 */     return Items.field_151079_bi;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
/* 321 */     Item item = func_146068_u();
/* 322 */     if (item != null) {
/* 323 */       int i = this.field_70146_Z.nextInt(2 + p_70628_2_);
/* 324 */       for (byte b = 0; b < i; b++)
/* 325 */         func_145779_a(item, 1); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_146081_a(Block p_146081_1_) {
/* 330 */     this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)(Block.func_149682_b(p_146081_1_) & 0xFF)));
/*     */   }
/*     */   
/*     */   public Block func_146080_bZ() {
/* 334 */     return Block.func_149729_e(this.field_70180_af.func_75683_a(16));
/*     */   }
/*     */   
/*     */   public void func_70817_b(int p_70817_1_) {
/* 338 */     this.field_70180_af.func_75692_b(17, Byte.valueOf((byte)(p_70817_1_ & 0xFF)));
/*     */   }
/*     */   
/*     */   public int func_70824_q() {
/* 342 */     return this.field_70180_af.func_75683_a(17);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource p_70097_1_, float p_70097_2_) {
/* 347 */     if (func_85032_ar()) return false; 
/* 348 */     func_70819_e(true);
/*     */     
/* 350 */     if (p_70097_1_ instanceof net.minecraft.util.EntityDamageSource && p_70097_1_.func_76346_g() instanceof EntityPlayer) {
/* 351 */       this.field_104003_g = true;
/*     */     }
/*     */     
/* 354 */     if (p_70097_1_ instanceof net.minecraft.util.EntityDamageSourceIndirect) {
/* 355 */       this.field_104003_g = false;
/* 356 */       for (byte b = 0; b < 64; b++) {
/* 357 */         if (func_70820_n()) {
/* 358 */           return true;
/*     */         }
/*     */       } 
/* 361 */       return false;
/*     */     } 
/*     */     
/* 364 */     return super.func_70097_a(p_70097_1_, p_70097_2_);
/*     */   }
/*     */   
/*     */   public boolean func_70823_r() {
/* 368 */     return (this.field_70180_af.func_75683_a(18) > 0);
/*     */   }
/*     */   
/*     */   public void func_70819_e(boolean p_70819_1_) {
/* 372 */     this.field_70180_af.func_75692_b(18, Byte.valueOf((byte)(p_70819_1_ ? 1 : 0)));
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\monster\EntityEnderman.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */