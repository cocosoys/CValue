/*     */ package net.minecraft.client.entity;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.audio.ISound;
/*     */ import net.minecraft.client.gui.GuiCommandBlock;
/*     */ import net.minecraft.client.gui.GuiEnchantment;
/*     */ import net.minecraft.client.gui.GuiHopper;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.gui.GuiScreenBook;
/*     */ import net.minecraft.client.gui.inventory.GuiFurnace;
/*     */ import net.minecraft.client.particle.EntityCrit2FX;
/*     */ import net.minecraft.client.particle.EntityFX;
/*     */ import net.minecraft.command.server.CommandBlockLogic;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.IMerchant;
/*     */ import net.minecraft.entity.ai.attributes.IAttributeInstance;
/*     */ import net.minecraft.entity.item.EntityMinecartHopper;
/*     */ import net.minecraft.entity.passive.EntityHorse;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.tileentity.TileEntityBeacon;
/*     */ import net.minecraft.tileentity.TileEntityBrewingStand;
/*     */ import net.minecraft.tileentity.TileEntityDispenser;
/*     */ import net.minecraft.tileentity.TileEntityFurnace;
/*     */ import net.minecraft.tileentity.TileEntityHopper;
/*     */ import net.minecraft.util.ChunkCoordinates;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MouseFilter;
/*     */ import net.minecraft.util.Session;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class EntityPlayerSP extends AbstractClientPlayer {
/*     */   public MovementInput field_71158_b;
/*     */   protected Minecraft field_71159_c;
/*     */   
/*     */   public EntityPlayerSP(Minecraft p_i1238_1_, World p_i1238_2_, Session p_i1238_3_, int p_i1238_4_) {
/*  43 */     super(p_i1238_2_, p_i1238_3_.func_148256_e());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  52 */     this.field_71162_ch = new MouseFilter();
/*  53 */     this.field_71160_ci = new MouseFilter();
/*  54 */     this.field_71161_cj = new MouseFilter();
/*     */     this.field_71159_c = p_i1238_1_;
/*     */     this.field_71093_bK = p_i1238_4_;
/*     */   }
/*     */   protected int field_71156_d; public int field_71157_e; public float field_71154_f; public float field_71155_g; public float field_71163_h;
/*     */   public float field_71164_i;
/*     */   private int field_110320_a;
/*     */   private float field_110321_bQ;
/*     */   private MouseFilter field_71162_ch;
/*     */   private MouseFilter field_71160_ci;
/*     */   private MouseFilter field_71161_cj;
/*     */   public float field_71086_bY;
/*     */   public float field_71080_cy;
/*     */   private static final String __OBFID = "CL_00000938";
/*     */   
/*     */   public void func_70626_be() {
/*  70 */     super.func_70626_be();
/*  71 */     this.field_70702_br = this.field_71158_b.field_78902_a;
/*  72 */     this.field_70701_bs = this.field_71158_b.field_78900_b;
/*  73 */     this.field_70703_bu = this.field_71158_b.field_78901_c;
/*     */     
/*  75 */     this.field_71163_h = this.field_71154_f;
/*  76 */     this.field_71164_i = this.field_71155_g;
/*  77 */     this.field_71155_g = (float)(this.field_71155_g + (this.field_70125_A - this.field_71155_g) * 0.5D);
/*  78 */     this.field_71154_f = (float)(this.field_71154_f + (this.field_70177_z - this.field_71154_f) * 0.5D);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/*  83 */     if (this.field_71157_e > 0) {
/*  84 */       this.field_71157_e--;
/*  85 */       if (this.field_71157_e == 0) {
/*  86 */         func_70031_b(false);
/*     */       }
/*     */     } 
/*     */     
/*  90 */     if (this.field_71156_d > 0) this.field_71156_d--; 
/*  91 */     if (this.field_71159_c.field_71442_b.func_78747_a()) {
/*  92 */       this.field_70165_t = this.field_70161_v = 0.5D;
/*  93 */       this.field_70165_t = 0.0D;
/*  94 */       this.field_70161_v = 0.0D;
/*  95 */       this.field_70177_z = this.field_70173_aa / 12.0F;
/*  96 */       this.field_70125_A = 10.0F;
/*  97 */       this.field_70163_u = 68.5D;
/*     */       
/*     */       return;
/*     */     } 
/* 101 */     this.field_71080_cy = this.field_71086_bY;
/*     */     
/* 103 */     if (this.field_71087_bX) {
/* 104 */       if (this.field_71159_c.field_71462_r != null) this.field_71159_c.func_147108_a(null);
/*     */       
/* 106 */       if (this.field_71086_bY == 0.0F) {
/* 107 */         this.field_71159_c.func_147118_V().func_147682_a((ISound)PositionedSoundRecord.func_147674_a(new ResourceLocation("portal.trigger"), this.field_70146_Z.nextFloat() * 0.4F + 0.8F));
/*     */       }
/* 109 */       this.field_71086_bY += 0.0125F;
/* 110 */       if (this.field_71086_bY >= 1.0F) {
/* 111 */         this.field_71086_bY = 1.0F;
/*     */       }
/* 113 */       this.field_71087_bX = false;
/* 114 */     } else if (func_70644_a(Potion.field_76431_k) && func_70660_b(Potion.field_76431_k).func_76459_b() > 60) {
/* 115 */       this.field_71086_bY += 0.006666667F;
/* 116 */       if (this.field_71086_bY > 1.0F) {
/* 117 */         this.field_71086_bY = 1.0F;
/*     */       }
/*     */     } else {
/* 120 */       if (this.field_71086_bY > 0.0F) this.field_71086_bY -= 0.05F; 
/* 121 */       if (this.field_71086_bY < 0.0F) this.field_71086_bY = 0.0F;
/*     */     
/*     */     } 
/* 124 */     if (this.field_71088_bW > 0) this.field_71088_bW--; 
/* 125 */     boolean bool = this.field_71158_b.field_78901_c;
/* 126 */     float f = 0.8F;
/* 127 */     boolean bool1 = (this.field_71158_b.field_78900_b >= f) ? true : false;
/*     */     
/* 129 */     this.field_71158_b.func_78898_a();
/* 130 */     if (func_71039_bw() && !func_70115_ae()) {
/* 131 */       this.field_71158_b.field_78902_a *= 0.2F;
/* 132 */       this.field_71158_b.field_78900_b *= 0.2F;
/* 133 */       this.field_71156_d = 0;
/*     */     } 
/*     */     
/* 136 */     if (this.field_71158_b.field_78899_d && 
/* 137 */       this.field_70139_V < 0.2F) this.field_70139_V = 0.2F;
/*     */ 
/*     */     
/* 140 */     func_145771_j(this.field_70165_t - this.field_70130_N * 0.35D, this.field_70121_D.field_72338_b + 0.5D, this.field_70161_v + this.field_70130_N * 0.35D);
/* 141 */     func_145771_j(this.field_70165_t - this.field_70130_N * 0.35D, this.field_70121_D.field_72338_b + 0.5D, this.field_70161_v - this.field_70130_N * 0.35D);
/* 142 */     func_145771_j(this.field_70165_t + this.field_70130_N * 0.35D, this.field_70121_D.field_72338_b + 0.5D, this.field_70161_v - this.field_70130_N * 0.35D);
/* 143 */     func_145771_j(this.field_70165_t + this.field_70130_N * 0.35D, this.field_70121_D.field_72338_b + 0.5D, this.field_70161_v + this.field_70130_N * 0.35D);
/*     */     
/* 145 */     boolean bool2 = (func_71024_bL().func_75116_a() > 6.0F || this.field_71075_bZ.field_75101_c) ? true : false;
/* 146 */     if (this.field_70122_E && !bool1 && this.field_71158_b.field_78900_b >= f && !func_70051_ag() && bool2 && !func_71039_bw() && !func_70644_a(Potion.field_76440_q)) {
/* 147 */       if (this.field_71156_d > 0 || this.field_71159_c.field_71474_y.field_151444_V.func_151470_d()) {
/* 148 */         func_70031_b(true);
/*     */       } else {
/* 150 */         this.field_71156_d = 7;
/*     */       } 
/*     */     }
/* 153 */     if (!func_70051_ag() && this.field_71158_b.field_78900_b >= f && bool2 && !func_71039_bw() && !func_70644_a(Potion.field_76440_q) && this.field_71159_c.field_71474_y.field_151444_V.func_151470_d()) {
/* 154 */       func_70031_b(true);
/*     */     }
/* 156 */     if (func_70051_ag() && (this.field_71158_b.field_78900_b < f || this.field_70123_F || !bool2)) {
/* 157 */       func_70031_b(false);
/*     */     }
/*     */     
/* 160 */     if (this.field_71075_bZ.field_75101_c && 
/* 161 */       !bool && this.field_71158_b.field_78901_c) {
/* 162 */       if (this.field_71101_bC == 0) { this.field_71101_bC = 7; }
/*     */       else
/* 164 */       { this.field_71075_bZ.field_75100_b = !this.field_71075_bZ.field_75100_b;
/* 165 */         func_71016_p();
/* 166 */         this.field_71101_bC = 0; }
/*     */     
/*     */     }
/*     */ 
/*     */     
/* 171 */     if (this.field_71075_bZ.field_75100_b) {
/* 172 */       if (this.field_71158_b.field_78899_d) this.field_70181_x -= 0.15D; 
/* 173 */       if (this.field_71158_b.field_78901_c) this.field_70181_x += 0.15D;
/*     */     
/*     */     } 
/* 176 */     if (func_110317_t()) {
/* 177 */       if (this.field_110320_a < 0) {
/* 178 */         this.field_110320_a++;
/* 179 */         if (this.field_110320_a == 0)
/*     */         {
/* 181 */           this.field_110321_bQ = 0.0F;
/*     */         }
/*     */       } 
/* 184 */       if (bool && !this.field_71158_b.field_78901_c) {
/*     */         
/* 186 */         this.field_110320_a = -10;
/* 187 */         func_110318_g();
/* 188 */       } else if (!bool && this.field_71158_b.field_78901_c) {
/*     */         
/* 190 */         this.field_110320_a = 0;
/* 191 */         this.field_110321_bQ = 0.0F;
/* 192 */       } else if (bool) {
/*     */         
/* 194 */         this.field_110320_a++;
/* 195 */         if (this.field_110320_a < 10) {
/* 196 */           this.field_110321_bQ = this.field_110320_a * 0.1F;
/*     */         } else {
/* 198 */           this.field_110321_bQ = 0.8F + 2.0F / (this.field_110320_a - 9) * 0.1F;
/*     */         } 
/*     */       } 
/*     */     } else {
/* 202 */       this.field_110321_bQ = 0.0F;
/*     */     } 
/*     */     
/* 205 */     super.func_70636_d();
/* 206 */     if (this.field_70122_E && this.field_71075_bZ.field_75100_b) {
/* 207 */       this.field_71075_bZ.field_75100_b = false;
/* 208 */       func_71016_p();
/*     */     } 
/*     */   }
/*     */   
/*     */   public float func_71151_f() {
/* 213 */     float f = 1.0F;
/*     */ 
/*     */     
/* 216 */     if (this.field_71075_bZ.field_75100_b) f *= 1.1F; 
/* 217 */     IAttributeInstance iAttributeInstance = func_110148_a(SharedMonsterAttributes.field_111263_d);
/* 218 */     f = (float)(f * (iAttributeInstance.func_111126_e() / this.field_71075_bZ.func_75094_b() + 1.0D) / 2.0D);
/*     */     
/* 220 */     if (this.field_71075_bZ.func_75094_b() == 0.0F || Float.isNaN(f) || Float.isInfinite(f)) {
/* 221 */       f = 1.0F;
/*     */     }
/*     */ 
/*     */     
/* 225 */     if (func_71039_bw() && func_71011_bu().func_77973_b() == Items.field_151031_f) {
/* 226 */       int i = func_71057_bx();
/* 227 */       float f1 = i / 20.0F;
/* 228 */       if (f1 > 1.0F) {
/* 229 */         f1 = 1.0F;
/*     */       } else {
/* 231 */         f1 *= f1;
/*     */       } 
/* 233 */       f *= 1.0F - f1 * 0.15F;
/*     */     } 
/*     */     
/* 236 */     return f;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71053_j() {
/* 241 */     super.func_71053_j();
/* 242 */     this.field_71159_c.func_147108_a(null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146100_a(TileEntity p_146100_1_) {
/* 247 */     if (p_146100_1_ instanceof TileEntitySign) {
/* 248 */       this.field_71159_c.func_147108_a((GuiScreen)new GuiEditSign((TileEntitySign)p_146100_1_));
/* 249 */     } else if (p_146100_1_ instanceof TileEntityCommandBlock) {
/* 250 */       this.field_71159_c.func_147108_a((GuiScreen)new GuiCommandBlock(((TileEntityCommandBlock)p_146100_1_).func_145993_a()));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146095_a(CommandBlockLogic p_146095_1_) {
/* 256 */     this.field_71159_c.func_147108_a((GuiScreen)new GuiCommandBlock(p_146095_1_));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71048_c(ItemStack p_71048_1_) {
/* 261 */     Item item = p_71048_1_.func_77973_b();
/*     */     
/* 263 */     if (item == Items.field_151164_bB) {
/* 264 */       this.field_71159_c.func_147108_a((GuiScreen)new GuiScreenBook(this, p_71048_1_, false));
/* 265 */     } else if (item == Items.field_151099_bA) {
/* 266 */       this.field_71159_c.func_147108_a((GuiScreen)new GuiScreenBook(this, p_71048_1_, true));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71007_a(IInventory p_71007_1_) {
/* 272 */     this.field_71159_c.func_147108_a((GuiScreen)new GuiChest((IInventory)this.field_71071_by, p_71007_1_));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146093_a(TileEntityHopper p_146093_1_) {
/* 277 */     this.field_71159_c.func_147108_a((GuiScreen)new GuiHopper(this.field_71071_by, (IInventory)p_146093_1_));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_96125_a(EntityMinecartHopper p_96125_1_) {
/* 282 */     this.field_71159_c.func_147108_a((GuiScreen)new GuiHopper(this.field_71071_by, (IInventory)p_96125_1_));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_110298_a(EntityHorse p_110298_1_, IInventory p_110298_2_) {
/* 287 */     this.field_71159_c.func_147108_a((GuiScreen)new GuiScreenHorseInventory((IInventory)this.field_71071_by, p_110298_2_, p_110298_1_));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71058_b(int p_71058_1_, int p_71058_2_, int p_71058_3_) {
/* 292 */     this.field_71159_c.func_147108_a((GuiScreen)new GuiCrafting(this.field_71071_by, this.field_70170_p, p_71058_1_, p_71058_2_, p_71058_3_));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71002_c(int p_71002_1_, int p_71002_2_, int p_71002_3_, String p_71002_4_) {
/* 297 */     this.field_71159_c.func_147108_a((GuiScreen)new GuiEnchantment(this.field_71071_by, this.field_70170_p, p_71002_1_, p_71002_2_, p_71002_3_, p_71002_4_));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_82244_d(int p_82244_1_, int p_82244_2_, int p_82244_3_) {
/* 302 */     this.field_71159_c.func_147108_a((GuiScreen)new GuiRepair(this.field_71071_by, this.field_70170_p, p_82244_1_, p_82244_2_, p_82244_3_));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146101_a(TileEntityFurnace p_146101_1_) {
/* 307 */     this.field_71159_c.func_147108_a((GuiScreen)new GuiFurnace(this.field_71071_by, p_146101_1_));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146098_a(TileEntityBrewingStand p_146098_1_) {
/* 312 */     this.field_71159_c.func_147108_a((GuiScreen)new GuiBrewingStand(this.field_71071_by, p_146098_1_));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146104_a(TileEntityBeacon p_146104_1_) {
/* 317 */     this.field_71159_c.func_147108_a((GuiScreen)new GuiBeacon(this.field_71071_by, p_146104_1_));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146102_a(TileEntityDispenser p_146102_1_) {
/* 322 */     this.field_71159_c.func_147108_a((GuiScreen)new GuiDispenser(this.field_71071_by, p_146102_1_));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71030_a(IMerchant p_71030_1_, String p_71030_2_) {
/* 327 */     this.field_71159_c.func_147108_a((GuiScreen)new GuiMerchant(this.field_71071_by, p_71030_1_, this.field_70170_p, p_71030_2_));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71009_b(Entity p_71009_1_) {
/* 332 */     this.field_71159_c.field_71452_i.func_78873_a((EntityFX)new EntityCrit2FX((World)this.field_71159_c.field_71441_e, p_71009_1_));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71047_c(Entity p_71047_1_) {
/* 337 */     EntityCrit2FX entityCrit2FX = new EntityCrit2FX((World)this.field_71159_c.field_71441_e, p_71047_1_, "magicCrit");
/* 338 */     this.field_71159_c.field_71452_i.func_78873_a((EntityFX)entityCrit2FX);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71001_a(Entity p_71001_1_, int p_71001_2_) {
/* 343 */     this.field_71159_c.field_71452_i.func_78873_a((EntityFX)new EntityPickupFX((World)this.field_71159_c.field_71441_e, p_71001_1_, (Entity)this, -0.5F));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70093_af() {
/* 348 */     return (this.field_71158_b.field_78899_d && !this.field_71083_bS);
/*     */   }
/*     */   
/*     */   public void func_71150_b(float p_71150_1_) {
/* 352 */     float f = func_110143_aJ() - p_71150_1_;
/* 353 */     if (f <= 0.0F) {
/* 354 */       func_70606_j(p_71150_1_);
/* 355 */       if (f < 0.0F) {
/* 356 */         this.field_70172_ad = this.field_70771_an / 2;
/*     */       }
/*     */     } else {
/* 359 */       this.field_110153_bc = f;
/* 360 */       func_70606_j(func_110143_aJ());
/* 361 */       this.field_70172_ad = this.field_70771_an;
/* 362 */       func_70665_d(DamageSource.field_76377_j, f);
/* 363 */       this.field_70737_aN = this.field_70738_aO = 10;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146105_b(IChatComponent p_146105_1_) {
/* 369 */     this.field_71159_c.field_71456_v.func_146158_b().func_146227_a(p_146105_1_);
/*     */   }
/*     */   
/*     */   private boolean func_71153_f(int p_71153_1_, int p_71153_2_, int p_71153_3_) {
/* 373 */     return this.field_70170_p.func_147439_a(p_71153_1_, p_71153_2_, p_71153_3_).func_149721_r();
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean func_145771_j(double p_145771_1_, double p_145771_3_, double p_145771_5_) {
/* 378 */     int i = MathHelper.func_76128_c(p_145771_1_);
/* 379 */     int j = MathHelper.func_76128_c(p_145771_3_);
/* 380 */     int k = MathHelper.func_76128_c(p_145771_5_);
/*     */     
/* 382 */     double d1 = p_145771_1_ - i;
/* 383 */     double d2 = p_145771_5_ - k;
/*     */     
/* 385 */     if (func_71153_f(i, j, k) || func_71153_f(i, j + 1, k)) {
/* 386 */       boolean bool1 = (!func_71153_f(i - 1, j, k) && !func_71153_f(i - 1, j + 1, k)) ? true : false;
/* 387 */       boolean bool2 = (!func_71153_f(i + 1, j, k) && !func_71153_f(i + 1, j + 1, k)) ? true : false;
/* 388 */       boolean bool3 = (!func_71153_f(i, j, k - 1) && !func_71153_f(i, j + 1, k - 1)) ? true : false;
/* 389 */       boolean bool4 = (!func_71153_f(i, j, k + 1) && !func_71153_f(i, j + 1, k + 1)) ? true : false;
/*     */       
/* 391 */       byte b = -1;
/* 392 */       double d = 9999.0D;
/* 393 */       if (bool1 && d1 < d) {
/* 394 */         d = d1;
/* 395 */         b = 0;
/*     */       } 
/* 397 */       if (bool2 && 1.0D - d1 < d) {
/* 398 */         d = 1.0D - d1;
/* 399 */         b = 1;
/*     */       } 
/* 401 */       if (bool3 && d2 < d) {
/* 402 */         d = d2;
/* 403 */         b = 4;
/*     */       } 
/* 405 */       if (bool4 && 1.0D - d2 < d) {
/* 406 */         d = 1.0D - d2;
/* 407 */         b = 5;
/*     */       } 
/*     */       
/* 410 */       float f = 0.1F;
/* 411 */       if (b == 0) this.field_70159_w = -f; 
/* 412 */       if (b == 1) this.field_70159_w = f; 
/* 413 */       if (b == 4) this.field_70179_y = -f; 
/* 414 */       if (b == 5) this.field_70179_y = f;
/*     */     
/*     */     } 
/* 417 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70031_b(boolean p_70031_1_) {
/* 422 */     super.func_70031_b(p_70031_1_);
/* 423 */     this.field_71157_e = p_70031_1_ ? 600 : 0;
/*     */   }
/*     */   
/*     */   public void func_71152_a(float p_71152_1_, int p_71152_2_, int p_71152_3_) {
/* 427 */     this.field_71106_cc = p_71152_1_;
/* 428 */     this.field_71067_cb = p_71152_2_;
/* 429 */     this.field_71068_ca = p_71152_3_;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_145747_a(IChatComponent p_145747_1_) {
/* 434 */     this.field_71159_c.field_71456_v.func_146158_b().func_146227_a(p_145747_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70003_b(int p_70003_1_, String p_70003_2_) {
/* 439 */     return (p_70003_1_ <= 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public ChunkCoordinates func_82114_b() {
/* 444 */     return new ChunkCoordinates(MathHelper.func_76128_c(this.field_70165_t + 0.5D), MathHelper.func_76128_c(this.field_70163_u + 0.5D), MathHelper.func_76128_c(this.field_70161_v + 0.5D));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_85030_a(String p_85030_1_, float p_85030_2_, float p_85030_3_) {
/* 449 */     this.field_70170_p.func_72980_b(this.field_70165_t, this.field_70163_u - this.field_70129_M, this.field_70161_v, p_85030_1_, p_85030_2_, p_85030_3_, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70613_aW() {
/* 454 */     return true;
/*     */   }
/*     */   
/*     */   public boolean func_110317_t() {
/* 458 */     return (this.field_70154_o != null && this.field_70154_o instanceof EntityHorse);
/*     */   }
/*     */   
/*     */   public float func_110319_bJ() {
/* 462 */     return this.field_110321_bQ;
/*     */   }
/*     */   
/*     */   protected void func_110318_g() {}
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\entity\EntityPlayerSP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */