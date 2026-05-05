/*      */ package net.minecraft.entity;
/*      */ import cpw.mods.fml.relauncher.Side;
/*      */ import cpw.mods.fml.relauncher.SideOnly;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import net.minecraft.block.Block;
/*      */ import net.minecraft.block.material.Material;
/*      */ import net.minecraft.enchantment.EnchantmentHelper;
/*      */ import net.minecraft.entity.ai.attributes.AttributeModifier;
/*      */ import net.minecraft.entity.ai.attributes.BaseAttributeMap;
/*      */ import net.minecraft.entity.ai.attributes.IAttribute;
/*      */ import net.minecraft.entity.ai.attributes.IAttributeInstance;
/*      */ import net.minecraft.entity.passive.EntityWolf;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.nbt.NBTBase;
/*      */ import net.minecraft.nbt.NBTTagCompound;
/*      */ import net.minecraft.nbt.NBTTagList;
/*      */ import net.minecraft.network.Packet;
/*      */ import net.minecraft.network.play.server.S0DPacketCollectItem;
/*      */ import net.minecraft.potion.Potion;
/*      */ import net.minecraft.potion.PotionEffect;
/*      */ import net.minecraft.scoreboard.Team;
/*      */ import net.minecraft.util.AxisAlignedBB;
/*      */ import net.minecraft.util.CombatTracker;
/*      */ import net.minecraft.util.DamageSource;
/*      */ import net.minecraft.util.MathHelper;
/*      */ import net.minecraft.util.Vec3;
/*      */ import net.minecraft.world.World;
/*      */ import net.minecraft.world.WorldServer;
/*      */ 
/*      */ public abstract class EntityLivingBase extends Entity {
/*   34 */   private static final UUID field_110156_b = UUID.fromString("662A6B8D-DA3E-4C1C-8813-96EA6097278D");
/*   35 */   private static final AttributeModifier field_110157_c = (new AttributeModifier(field_110156_b, "Sprinting speed boost", 0.30000001192092896D, 2)).func_111168_a(false);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private BaseAttributeMap field_110155_d;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   54 */   private final CombatTracker field_94063_bt = new CombatTracker(this);
/*   55 */   private final HashMap field_70713_bf = new HashMap<Object, Object>();
/*   56 */   private final ItemStack[] field_82180_bT = new ItemStack[5]; public boolean field_82175_bq;
/*      */   public int field_110158_av;
/*      */   public int field_70720_be;
/*      */   public float field_70735_aL;
/*      */   public int field_70737_aN;
/*      */   public int field_70738_aO;
/*      */   public float field_70739_aP;
/*      */   public int field_70725_aQ;
/*      */   public int field_70724_aR;
/*      */   public float field_70732_aI;
/*      */   public float field_70733_aJ;
/*      */   public float field_70722_aY;
/*      */   public float field_70721_aZ;
/*      */   public float field_70754_ba;
/*   70 */   public int field_70771_an = 20; public float field_70727_aS; public float field_70726_aT; public float field_70769_ao;
/*      */   public float field_70770_ap;
/*      */   public float field_70761_aq;
/*      */   public float field_70760_ar;
/*      */   public float field_70759_as;
/*      */   public float field_70758_at;
/*   76 */   public float field_70747_aH = 0.02F; protected EntityPlayer field_70717_bb; protected int field_70718_bc; protected boolean field_70729_aU; protected int field_70708_bq; protected float field_70768_au; protected float field_110154_aX; protected float field_70764_aw;
/*      */   protected float field_70763_ax;
/*      */   protected float field_70741_aB;
/*      */   protected int field_70744_aE;
/*      */   protected float field_110153_bc;
/*      */   protected boolean field_70703_bu;
/*      */   public float field_70702_br;
/*      */   public float field_70701_bs;
/*      */   protected float field_70704_bt;
/*      */   protected int field_70716_bi;
/*      */   protected double field_70709_bj;
/*      */   protected double field_70710_bk;
/*      */   protected double field_110152_bk;
/*      */   protected double field_70712_bm;
/*      */   protected double field_70705_bn;
/*      */   private boolean field_70752_e = true;
/*      */   private EntityLivingBase field_70755_b;
/*      */   private int field_70756_c;
/*      */   private EntityLivingBase field_110150_bn;
/*      */   private int field_142016_bo;
/*      */   private float field_70746_aG;
/*      */   private int field_70773_bE;
/*      */   private float field_110151_bq;
/*      */   private static final String __OBFID = "CL_00001549";
/*      */   
/*      */   public EntityLivingBase(World p_i1594_1_) {
/*  102 */     super(p_i1594_1_);
/*      */     
/*  104 */     func_110147_ax();
/*  105 */     func_70606_j(func_110138_aP());
/*      */     
/*  107 */     this.field_70156_m = true;
/*  108 */     this.field_70770_ap = (float)(Math.random() + 1.0D) * 0.01F;
/*  109 */     func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*  110 */     this.field_70769_ao = (float)Math.random() * 12398.0F;
/*  111 */     this.field_70177_z = (float)(Math.random() * 3.1415927410125732D * 2.0D);
/*  112 */     this.field_70759_as = this.field_70177_z;
/*  113 */     this.field_70138_W = 0.5F;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void func_70088_a() {
/*  118 */     this.field_70180_af.func_75682_a(7, Integer.valueOf(0));
/*  119 */     this.field_70180_af.func_75682_a(8, Byte.valueOf((byte)0));
/*  120 */     this.field_70180_af.func_75682_a(9, Byte.valueOf((byte)0));
/*  121 */     this.field_70180_af.func_75682_a(6, Float.valueOf(1.0F));
/*      */   }
/*      */   
/*      */   protected void func_110147_ax() {
/*  125 */     func_110140_aT().func_111150_b(SharedMonsterAttributes.field_111267_a);
/*  126 */     func_110140_aT().func_111150_b(SharedMonsterAttributes.field_111266_c);
/*  127 */     func_110140_aT().func_111150_b(SharedMonsterAttributes.field_111263_d);
/*      */     
/*  129 */     if (!func_70650_aV()) {
/*  130 */       func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.10000000149011612D);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   protected void func_70064_a(double p_70064_1_, boolean p_70064_3_) {
/*  136 */     if (!func_70090_H())
/*      */     {
/*  138 */       func_70072_I();
/*      */     }
/*      */     
/*  141 */     if (p_70064_3_ && this.field_70143_R > 0.0F) {
/*  142 */       int i = MathHelper.func_76128_c(this.field_70165_t);
/*  143 */       int j = MathHelper.func_76128_c(this.field_70163_u - 0.20000000298023224D - this.field_70129_M);
/*  144 */       int k = MathHelper.func_76128_c(this.field_70161_v);
/*  145 */       Block block = this.field_70170_p.func_147439_a(i, j, k);
/*  146 */       if (block.func_149688_o() == Material.field_151579_a) {
/*  147 */         int m = this.field_70170_p.func_147439_a(i, j - 1, k).func_149645_b();
/*  148 */         if (m == 11 || m == 32 || m == 21) {
/*  149 */           block = this.field_70170_p.func_147439_a(i, j - 1, k);
/*      */         }
/*  151 */       } else if (!this.field_70170_p.field_72995_K && this.field_70143_R > 3.0F) {
/*  152 */         this.field_70170_p.func_72926_e(2006, i, j, k, MathHelper.func_76123_f(this.field_70143_R - 3.0F));
/*      */       } 
/*      */       
/*  155 */       block.func_149746_a(this.field_70170_p, i, j, k, this, this.field_70143_R);
/*      */     } 
/*      */     
/*  158 */     super.func_70064_a(p_70064_1_, p_70064_3_);
/*      */   }
/*      */   
/*      */   public boolean func_70648_aU() {
/*  162 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_70030_z() {
/*  167 */     this.field_70732_aI = this.field_70733_aJ;
/*  168 */     super.func_70030_z();
/*      */     
/*  170 */     this.field_70170_p.field_72984_F.func_76320_a("livingEntityBaseTick");
/*      */     
/*  172 */     if (func_70089_S() && func_70094_T()) {
/*  173 */       func_70097_a(DamageSource.field_76368_d, 1.0F);
/*      */     }
/*      */     
/*  176 */     if (func_70045_F() || this.field_70170_p.field_72995_K) func_70066_B(); 
/*  177 */     boolean bool = (this instanceof EntityPlayer && ((EntityPlayer)this).field_71075_bZ.field_75102_a) ? true : false;
/*      */     
/*  179 */     if (func_70089_S() && func_70055_a(Material.field_151586_h)) {
/*  180 */       if (!func_70648_aU() && !func_82165_m(Potion.field_76427_o.field_76415_H) && !bool) {
/*  181 */         func_70050_g(func_70682_h(func_70086_ai()));
/*  182 */         if (func_70086_ai() == -20) {
/*  183 */           func_70050_g(0);
/*  184 */           for (byte b = 0; b < 8; b++) {
/*  185 */             float f1 = this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat();
/*  186 */             float f2 = this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat();
/*  187 */             float f3 = this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat();
/*  188 */             this.field_70170_p.func_72869_a("bubble", this.field_70165_t + f1, this.field_70163_u + f2, this.field_70161_v + f3, this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*      */           } 
/*  190 */           func_70097_a(DamageSource.field_76369_e, 2.0F);
/*      */         } 
/*      */       } 
/*      */       
/*  194 */       if (!this.field_70170_p.field_72995_K && func_70115_ae() && this.field_70154_o instanceof EntityLivingBase) {
/*  195 */         func_70078_a(null);
/*      */       }
/*      */     } else {
/*  198 */       func_70050_g(300);
/*      */     } 
/*      */     
/*  201 */     if (func_70089_S() && func_70026_G()) func_70066_B();
/*      */     
/*  203 */     this.field_70727_aS = this.field_70726_aT;
/*      */     
/*  205 */     if (this.field_70724_aR > 0) this.field_70724_aR--; 
/*  206 */     if (this.field_70737_aN > 0) this.field_70737_aN--; 
/*  207 */     if (this.field_70172_ad > 0 && !(this instanceof net.minecraft.entity.player.EntityPlayerMP)) this.field_70172_ad--; 
/*  208 */     if (func_110143_aJ() <= 0.0F) {
/*  209 */       func_70609_aI();
/*      */     }
/*  211 */     if (this.field_70718_bc > 0) { this.field_70718_bc--; }
/*  212 */     else { this.field_70717_bb = null; }
/*  213 */      if (this.field_110150_bn != null && !this.field_110150_bn.func_70089_S()) this.field_110150_bn = null;
/*      */     
/*  215 */     if (this.field_70755_b != null) {
/*  216 */       if (!this.field_70755_b.func_70089_S()) {
/*  217 */         func_70604_c((EntityLivingBase)null);
/*  218 */       } else if (this.field_70173_aa - this.field_70756_c > 100) {
/*  219 */         func_70604_c((EntityLivingBase)null);
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*  224 */     func_70679_bo();
/*      */     
/*  226 */     this.field_70763_ax = this.field_70764_aw;
/*      */     
/*  228 */     this.field_70760_ar = this.field_70761_aq;
/*  229 */     this.field_70758_at = this.field_70759_as;
/*  230 */     this.field_70126_B = this.field_70177_z;
/*  231 */     this.field_70127_C = this.field_70125_A;
/*      */     
/*  233 */     this.field_70170_p.field_72984_F.func_76319_b();
/*      */   }
/*      */   
/*      */   public boolean func_70631_g_() {
/*  237 */     return false;
/*      */   }
/*      */   
/*      */   protected void func_70609_aI() {
/*  241 */     this.field_70725_aQ++;
/*  242 */     if (this.field_70725_aQ == 20) {
/*  243 */       if (!this.field_70170_p.field_72995_K && (this.field_70718_bc > 0 || func_70684_aJ()) && 
/*  244 */         func_146066_aG() && this.field_70170_p.func_82736_K().func_82766_b("doMobLoot")) {
/*  245 */         int i = func_70693_a(this.field_70717_bb);
/*  246 */         while (i > 0) {
/*  247 */           int j = EntityXPOrb.func_70527_a(i);
/*  248 */           i -= j;
/*  249 */           this.field_70170_p.func_72838_d((Entity)new EntityXPOrb(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, j));
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/*  254 */       func_70106_y();
/*  255 */       for (byte b = 0; b < 20; b++) {
/*  256 */         double d1 = this.field_70146_Z.nextGaussian() * 0.02D;
/*  257 */         double d2 = this.field_70146_Z.nextGaussian() * 0.02D;
/*  258 */         double d3 = this.field_70146_Z.nextGaussian() * 0.02D;
/*  259 */         this.field_70170_p.func_72869_a("explode", this.field_70165_t + (this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0F) - this.field_70130_N, this.field_70163_u + (this.field_70146_Z.nextFloat() * this.field_70131_O), this.field_70161_v + (this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0F) - this.field_70130_N, d1, d2, d3);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   protected boolean func_146066_aG() {
/*  265 */     return !func_70631_g_();
/*      */   }
/*      */   
/*      */   protected int func_70682_h(int p_70682_1_) {
/*  269 */     int i = EnchantmentHelper.func_77501_a(this);
/*  270 */     if (i > 0 && 
/*  271 */       this.field_70146_Z.nextInt(i + 1) > 0)
/*      */     {
/*  273 */       return p_70682_1_;
/*      */     }
/*      */     
/*  276 */     return p_70682_1_ - 1;
/*      */   }
/*      */   
/*      */   protected int func_70693_a(EntityPlayer p_70693_1_) {
/*  280 */     return 0;
/*      */   }
/*      */   
/*      */   protected boolean func_70684_aJ() {
/*  284 */     return false;
/*      */   }
/*      */   
/*      */   public Random func_70681_au() {
/*  288 */     return this.field_70146_Z;
/*      */   }
/*      */   
/*      */   public EntityLivingBase func_70643_av() {
/*  292 */     return this.field_70755_b;
/*      */   }
/*      */   
/*      */   public int func_142015_aE() {
/*  296 */     return this.field_70756_c;
/*      */   }
/*      */   
/*      */   public void func_70604_c(EntityLivingBase p_70604_1_) {
/*  300 */     this.field_70755_b = p_70604_1_;
/*  301 */     this.field_70756_c = this.field_70173_aa;
/*      */   }
/*      */   
/*      */   public EntityLivingBase func_110144_aD() {
/*  305 */     return this.field_110150_bn;
/*      */   }
/*      */   
/*      */   public int func_142013_aG() {
/*  309 */     return this.field_142016_bo;
/*      */   }
/*      */   
/*      */   public void func_130011_c(Entity p_130011_1_) {
/*  313 */     if (p_130011_1_ instanceof EntityLivingBase) {
/*  314 */       this.field_110150_bn = (EntityLivingBase)p_130011_1_;
/*      */     } else {
/*  316 */       this.field_110150_bn = null;
/*      */     } 
/*  318 */     this.field_142016_bo = this.field_70173_aa;
/*      */   }
/*      */   
/*      */   public int func_70654_ax() {
/*  322 */     return this.field_70708_bq;
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_70014_b(NBTTagCompound p_70014_1_) {
/*  327 */     p_70014_1_.func_74776_a("HealF", func_110143_aJ());
/*  328 */     p_70014_1_.func_74777_a("Health", (short)(int)Math.ceil(func_110143_aJ()));
/*  329 */     p_70014_1_.func_74777_a("HurtTime", (short)this.field_70737_aN);
/*  330 */     p_70014_1_.func_74777_a("DeathTime", (short)this.field_70725_aQ);
/*  331 */     p_70014_1_.func_74777_a("AttackTime", (short)this.field_70724_aR);
/*  332 */     p_70014_1_.func_74776_a("AbsorptionAmount", func_110139_bj());
/*      */     
/*  334 */     for (ItemStack itemStack : func_70035_c()) {
/*  335 */       if (itemStack != null) this.field_110155_d.func_111148_a(itemStack.func_111283_C());
/*      */     
/*      */     } 
/*  338 */     p_70014_1_.func_74782_a("Attributes", (NBTBase)SharedMonsterAttributes.func_111257_a(func_110140_aT()));
/*      */     
/*  340 */     for (ItemStack itemStack : func_70035_c()) {
/*  341 */       if (itemStack != null) this.field_110155_d.func_111147_b(itemStack.func_111283_C());
/*      */     
/*      */     } 
/*  344 */     if (!this.field_70713_bf.isEmpty()) {
/*  345 */       NBTTagList nBTTagList = new NBTTagList();
/*      */       
/*  347 */       for (PotionEffect potionEffect : this.field_70713_bf.values()) {
/*  348 */         nBTTagList.func_74742_a((NBTBase)potionEffect.func_82719_a(new NBTTagCompound()));
/*      */       }
/*  350 */       p_70014_1_.func_74782_a("ActiveEffects", (NBTBase)nBTTagList);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_70037_a(NBTTagCompound p_70037_1_) {
/*  357 */     func_110149_m(p_70037_1_.func_74760_g("AbsorptionAmount"));
/*      */     
/*  359 */     if (p_70037_1_.func_150297_b("Attributes", 9) && this.field_70170_p != null && !this.field_70170_p.field_72995_K) {
/*  360 */       SharedMonsterAttributes.func_151475_a(func_110140_aT(), p_70037_1_.func_150295_c("Attributes", 10));
/*      */     }
/*      */     
/*  363 */     if (p_70037_1_.func_150297_b("ActiveEffects", 9)) {
/*  364 */       NBTTagList nBTTagList = p_70037_1_.func_150295_c("ActiveEffects", 10);
/*  365 */       for (byte b = 0; b < nBTTagList.func_74745_c(); b++) {
/*  366 */         NBTTagCompound nBTTagCompound = nBTTagList.func_150305_b(b);
/*  367 */         PotionEffect potionEffect = PotionEffect.func_82722_b(nBTTagCompound);
/*  368 */         if (potionEffect != null) {
/*  369 */           this.field_70713_bf.put(Integer.valueOf(potionEffect.func_76456_a()), potionEffect);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  374 */     if (p_70037_1_.func_150297_b("HealF", 99)) {
/*  375 */       func_70606_j(p_70037_1_.func_74760_g("HealF"));
/*      */     } else {
/*  377 */       NBTBase nBTBase = p_70037_1_.func_74781_a("Health");
/*  378 */       if (nBTBase == null) {
/*  379 */         func_70606_j(func_110138_aP());
/*  380 */       } else if (nBTBase.func_74732_a() == 5) {
/*  381 */         func_70606_j(((NBTTagFloat)nBTBase).func_150288_h());
/*  382 */       } else if (nBTBase.func_74732_a() == 2) {
/*      */         
/*  384 */         func_70606_j(((NBTTagShort)nBTBase).func_150289_e());
/*      */       } 
/*      */     } 
/*      */     
/*  388 */     this.field_70737_aN = p_70037_1_.func_74765_d("HurtTime");
/*  389 */     this.field_70725_aQ = p_70037_1_.func_74765_d("DeathTime");
/*  390 */     this.field_70724_aR = p_70037_1_.func_74765_d("AttackTime");
/*      */   }
/*      */   
/*      */   protected void func_70679_bo() {
/*  394 */     Iterator<Integer> iterator = this.field_70713_bf.keySet().iterator();
/*  395 */     while (iterator.hasNext()) {
/*  396 */       Integer integer = iterator.next();
/*  397 */       PotionEffect potionEffect = (PotionEffect)this.field_70713_bf.get(integer);
/*      */       
/*  399 */       if (!potionEffect.func_76455_a(this)) {
/*  400 */         if (!this.field_70170_p.field_72995_K) {
/*  401 */           iterator.remove();
/*  402 */           func_70688_c(potionEffect);
/*      */         }  continue;
/*  404 */       }  if (potionEffect.func_76459_b() % 600 == 0)
/*      */       {
/*      */         
/*  407 */         func_70695_b(potionEffect, false);
/*      */       }
/*      */     } 
/*      */     
/*  411 */     if (this.field_70752_e) {
/*  412 */       if (!this.field_70170_p.field_72995_K) {
/*  413 */         if (this.field_70713_bf.isEmpty()) {
/*  414 */           this.field_70180_af.func_75692_b(8, Byte.valueOf((byte)0));
/*  415 */           this.field_70180_af.func_75692_b(7, Integer.valueOf(0));
/*  416 */           func_82142_c(false);
/*      */         } else {
/*  418 */           int j = PotionHelper.func_77911_a(this.field_70713_bf.values());
/*  419 */           this.field_70180_af.func_75692_b(8, Byte.valueOf(PotionHelper.func_82817_b(this.field_70713_bf.values()) ? 1 : 0));
/*  420 */           this.field_70180_af.func_75692_b(7, Integer.valueOf(j));
/*  421 */           func_82142_c(func_82165_m(Potion.field_76441_p.field_76415_H));
/*      */         } 
/*      */       }
/*  424 */       this.field_70752_e = false;
/*      */     } 
/*  426 */     int i = this.field_70180_af.func_75679_c(7);
/*  427 */     boolean bool = (this.field_70180_af.func_75683_a(8) > 0) ? true : false;
/*      */     
/*  429 */     if (i > 0) {
/*  430 */       int j; boolean bool1 = false;
/*      */       
/*  432 */       if (!func_82150_aj()) {
/*  433 */         bool1 = this.field_70146_Z.nextBoolean();
/*      */       } else {
/*      */         
/*  436 */         bool1 = (this.field_70146_Z.nextInt(15) == 0);
/*      */       } 
/*      */       
/*  439 */       if (bool) j = bool1 & ((this.field_70146_Z.nextInt(5) == 0) ? 1 : 0);
/*      */       
/*  441 */       if (j != 0 && 
/*  442 */         i > 0) {
/*  443 */         double d1 = (i >> 16 & 0xFF) / 255.0D;
/*  444 */         double d2 = (i >> 8 & 0xFF) / 255.0D;
/*  445 */         double d3 = (i >> 0 & 0xFF) / 255.0D;
/*      */         
/*  447 */         this.field_70170_p.func_72869_a(bool ? "mobSpellAmbient" : "mobSpell", this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5D) * this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * this.field_70131_O - this.field_70129_M, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5D) * this.field_70130_N, d1, d2, d3);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_70674_bp() {
/*  455 */     Iterator<Integer> iterator = this.field_70713_bf.keySet().iterator();
/*  456 */     while (iterator.hasNext()) {
/*  457 */       Integer integer = iterator.next();
/*  458 */       PotionEffect potionEffect = (PotionEffect)this.field_70713_bf.get(integer);
/*      */       
/*  460 */       if (!this.field_70170_p.field_72995_K) {
/*  461 */         iterator.remove();
/*  462 */         func_70688_c(potionEffect);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public Collection func_70651_bq() {
/*  468 */     return this.field_70713_bf.values();
/*      */   }
/*      */   
/*      */   public boolean func_82165_m(int p_82165_1_) {
/*  472 */     return this.field_70713_bf.containsKey(Integer.valueOf(p_82165_1_));
/*      */   }
/*      */   
/*      */   public boolean func_70644_a(Potion p_70644_1_) {
/*  476 */     return this.field_70713_bf.containsKey(Integer.valueOf(p_70644_1_.field_76415_H));
/*      */   }
/*      */   
/*      */   public PotionEffect func_70660_b(Potion p_70660_1_) {
/*  480 */     return (PotionEffect)this.field_70713_bf.get(Integer.valueOf(p_70660_1_.field_76415_H));
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_70690_d(PotionEffect p_70690_1_) {
/*  485 */     if (!func_70687_e(p_70690_1_)) {
/*      */       return;
/*      */     }
/*      */     
/*  489 */     if (this.field_70713_bf.containsKey(Integer.valueOf(p_70690_1_.func_76456_a()))) {
/*      */       
/*  491 */       ((PotionEffect)this.field_70713_bf.get(Integer.valueOf(p_70690_1_.func_76456_a()))).func_76452_a(p_70690_1_);
/*  492 */       func_70695_b((PotionEffect)this.field_70713_bf.get(Integer.valueOf(p_70690_1_.func_76456_a())), true);
/*      */     } else {
/*  494 */       this.field_70713_bf.put(Integer.valueOf(p_70690_1_.func_76456_a()), p_70690_1_);
/*  495 */       func_70670_a(p_70690_1_);
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean func_70687_e(PotionEffect p_70687_1_) {
/*  500 */     if (func_70668_bt() == EnumCreatureAttribute.UNDEAD) {
/*  501 */       int i = p_70687_1_.func_76456_a();
/*  502 */       if (i == Potion.field_76428_l.field_76415_H || i == Potion.field_76436_u.field_76415_H) {
/*  503 */         return false;
/*      */       }
/*      */     } 
/*      */     
/*  507 */     return true;
/*      */   }
/*      */   
/*      */   public boolean func_70662_br() {
/*  511 */     return (func_70668_bt() == EnumCreatureAttribute.UNDEAD);
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public void func_70618_n(int p_70618_1_) {
/*  515 */     this.field_70713_bf.remove(Integer.valueOf(p_70618_1_));
/*      */   }
/*      */   
/*      */   public void func_82170_o(int p_82170_1_) {
/*  519 */     PotionEffect potionEffect = (PotionEffect)this.field_70713_bf.remove(Integer.valueOf(p_82170_1_));
/*  520 */     if (potionEffect != null) func_70688_c(potionEffect); 
/*      */   }
/*      */   
/*      */   protected void func_70670_a(PotionEffect p_70670_1_) {
/*  524 */     this.field_70752_e = true;
/*  525 */     if (!this.field_70170_p.field_72995_K) Potion.field_76425_a[p_70670_1_.func_76456_a()].func_111185_a(this, func_110140_aT(), p_70670_1_.func_76458_c()); 
/*      */   }
/*      */   
/*      */   protected void func_70695_b(PotionEffect p_70695_1_, boolean p_70695_2_) {
/*  529 */     this.field_70752_e = true;
/*  530 */     if (p_70695_2_ && !this.field_70170_p.field_72995_K) {
/*  531 */       Potion.field_76425_a[p_70695_1_.func_76456_a()].func_111187_a(this, func_110140_aT(), p_70695_1_.func_76458_c());
/*  532 */       Potion.field_76425_a[p_70695_1_.func_76456_a()].func_111185_a(this, func_110140_aT(), p_70695_1_.func_76458_c());
/*      */     } 
/*      */   }
/*      */   
/*      */   protected void func_70688_c(PotionEffect p_70688_1_) {
/*  537 */     this.field_70752_e = true;
/*  538 */     if (!this.field_70170_p.field_72995_K) Potion.field_76425_a[p_70688_1_.func_76456_a()].func_111187_a(this, func_110140_aT(), p_70688_1_.func_76458_c()); 
/*      */   }
/*      */   
/*      */   public void func_70691_i(float p_70691_1_) {
/*  542 */     float f = func_110143_aJ();
/*  543 */     if (f > 0.0F) {
/*  544 */       func_70606_j(f + p_70691_1_);
/*      */     }
/*      */   }
/*      */   
/*      */   public final float func_110143_aJ() {
/*  549 */     return this.field_70180_af.func_111145_d(6);
/*      */   }
/*      */   
/*      */   public void func_70606_j(float p_70606_1_) {
/*  553 */     this.field_70180_af.func_75692_b(6, Float.valueOf(MathHelper.func_76131_a(p_70606_1_, 0.0F, func_110138_aP())));
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean func_70097_a(DamageSource p_70097_1_, float p_70097_2_) {
/*  558 */     if (func_85032_ar()) return false; 
/*  559 */     if (this.field_70170_p.field_72995_K) return false; 
/*  560 */     this.field_70708_bq = 0;
/*  561 */     if (func_110143_aJ() <= 0.0F) return false;
/*      */     
/*  563 */     if (p_70097_1_.func_76347_k() && func_70644_a(Potion.field_76426_n)) {
/*  564 */       return false;
/*      */     }
/*      */     
/*  567 */     if ((p_70097_1_ == DamageSource.field_82728_o || p_70097_1_ == DamageSource.field_82729_p) && func_71124_b(4) != null) {
/*  568 */       func_71124_b(4).func_77972_a((int)(p_70097_2_ * 4.0F + this.field_70146_Z.nextFloat() * p_70097_2_ * 2.0F), this);
/*  569 */       p_70097_2_ *= 0.75F;
/*      */     } 
/*      */     
/*  572 */     this.field_70721_aZ = 1.5F;
/*      */     
/*  574 */     boolean bool = true;
/*  575 */     if (this.field_70172_ad > this.field_70771_an / 2.0F) {
/*  576 */       if (p_70097_2_ <= this.field_110153_bc) return false; 
/*  577 */       func_70665_d(p_70097_1_, p_70097_2_ - this.field_110153_bc);
/*  578 */       this.field_110153_bc = p_70097_2_;
/*  579 */       bool = false;
/*      */     } else {
/*  581 */       this.field_110153_bc = p_70097_2_;
/*  582 */       this.field_70735_aL = func_110143_aJ();
/*  583 */       this.field_70172_ad = this.field_70771_an;
/*  584 */       func_70665_d(p_70097_1_, p_70097_2_);
/*  585 */       this.field_70737_aN = this.field_70738_aO = 10;
/*      */     } 
/*      */     
/*  588 */     this.field_70739_aP = 0.0F;
/*      */     
/*  590 */     Entity entity = p_70097_1_.func_76346_g();
/*  591 */     if (entity != null) {
/*  592 */       if (entity instanceof EntityLivingBase) {
/*  593 */         func_70604_c((EntityLivingBase)entity);
/*      */       }
/*      */       
/*  596 */       if (entity instanceof EntityPlayer) {
/*  597 */         this.field_70718_bc = 100;
/*  598 */         this.field_70717_bb = (EntityPlayer)entity;
/*  599 */       } else if (entity instanceof EntityWolf) {
/*  600 */         EntityWolf entityWolf = (EntityWolf)entity;
/*  601 */         if (entityWolf.func_70909_n()) {
/*  602 */           this.field_70718_bc = 100;
/*  603 */           this.field_70717_bb = null;
/*      */         } 
/*      */       } 
/*      */     } 
/*  607 */     if (bool) {
/*  608 */       this.field_70170_p.func_72960_a(this, (byte)2);
/*  609 */       if (p_70097_1_ != DamageSource.field_76369_e) func_70018_K(); 
/*  610 */       if (entity != null) {
/*  611 */         double d1 = entity.field_70165_t - this.field_70165_t;
/*  612 */         double d2 = entity.field_70161_v - this.field_70161_v;
/*  613 */         while (d1 * d1 + d2 * d2 < 1.0E-4D) {
/*  614 */           d1 = (Math.random() - Math.random()) * 0.01D;
/*  615 */           d2 = (Math.random() - Math.random()) * 0.01D;
/*      */         } 
/*  617 */         this.field_70739_aP = (float)(Math.atan2(d2, d1) * 180.0D / 3.1415927410125732D) - this.field_70177_z;
/*  618 */         func_70653_a(entity, p_70097_2_, d1, d2);
/*      */       } else {
/*  620 */         this.field_70739_aP = ((int)(Math.random() * 2.0D) * 180);
/*      */       } 
/*      */     } 
/*      */     
/*  624 */     if (func_110143_aJ() <= 0.0F) {
/*  625 */       String str = func_70673_aS();
/*  626 */       if (bool && str != null) {
/*  627 */         func_85030_a(str, func_70599_aP(), func_70647_i());
/*      */       }
/*  629 */       func_70645_a(p_70097_1_);
/*      */     } else {
/*  631 */       String str = func_70621_aR();
/*  632 */       if (bool && str != null) {
/*  633 */         func_85030_a(str, func_70599_aP(), func_70647_i());
/*      */       }
/*      */     } 
/*      */     
/*  637 */     return true;
/*      */   }
/*      */   
/*      */   public void func_70669_a(ItemStack p_70669_1_) {
/*  641 */     func_85030_a("random.break", 0.8F, 0.8F + this.field_70170_p.field_73012_v.nextFloat() * 0.4F);
/*      */     
/*  643 */     for (byte b = 0; b < 5; b++) {
/*  644 */       Vec3 vec31 = Vec3.func_72443_a((this.field_70146_Z.nextFloat() - 0.5D) * 0.1D, Math.random() * 0.1D + 0.1D, 0.0D);
/*  645 */       vec31.func_72440_a(-this.field_70125_A * 3.1415927F / 180.0F);
/*  646 */       vec31.func_72442_b(-this.field_70177_z * 3.1415927F / 180.0F);
/*      */       
/*  648 */       Vec3 vec32 = Vec3.func_72443_a((this.field_70146_Z.nextFloat() - 0.5D) * 0.3D, -this.field_70146_Z.nextFloat() * 0.6D - 0.3D, 0.6D);
/*  649 */       vec32.func_72440_a(-this.field_70125_A * 3.1415927F / 180.0F);
/*  650 */       vec32.func_72442_b(-this.field_70177_z * 3.1415927F / 180.0F);
/*  651 */       vec32 = vec32.func_72441_c(this.field_70165_t, this.field_70163_u + func_70047_e(), this.field_70161_v);
/*  652 */       this.field_70170_p.func_72869_a("iconcrack_" + Item.func_150891_b(p_70669_1_.func_77973_b()), vec32.field_72450_a, vec32.field_72448_b, vec32.field_72449_c, vec31.field_72450_a, vec31.field_72448_b + 0.05D, vec31.field_72449_c);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void func_70645_a(DamageSource p_70645_1_) {
/*  657 */     Entity entity = p_70645_1_.func_76346_g();
/*  658 */     EntityLivingBase entityLivingBase = func_94060_bK();
/*  659 */     if (this.field_70744_aE >= 0 && entityLivingBase != null) entityLivingBase.func_70084_c(this, this.field_70744_aE);
/*      */     
/*  661 */     if (entity != null) entity.func_70074_a(this);
/*      */     
/*  663 */     this.field_70729_aU = true;
/*  664 */     func_110142_aN().func_94549_h();
/*      */     
/*  666 */     if (!this.field_70170_p.field_72995_K) {
/*  667 */       int i = 0;
/*  668 */       if (entity instanceof EntityPlayer) {
/*  669 */         i = EnchantmentHelper.func_77519_f((EntityLivingBase)entity);
/*      */       }
/*  671 */       if (func_146066_aG() && this.field_70170_p.func_82736_K().func_82766_b("doMobLoot")) {
/*  672 */         func_70628_a((this.field_70718_bc > 0), i);
/*  673 */         func_82160_b((this.field_70718_bc > 0), i);
/*  674 */         if (this.field_70718_bc > 0) {
/*  675 */           int j = this.field_70146_Z.nextInt(200) - i;
/*  676 */           if (j < 5) {
/*  677 */             func_70600_l((j <= 0) ? 1 : 0);
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  683 */     this.field_70170_p.func_72960_a(this, (byte)3);
/*      */   }
/*      */ 
/*      */   
/*      */   protected void func_82160_b(boolean p_82160_1_, int p_82160_2_) {}
/*      */   
/*      */   public void func_70653_a(Entity p_70653_1_, float p_70653_2_, double p_70653_3_, double p_70653_5_) {
/*  690 */     if (this.field_70146_Z.nextDouble() < func_110148_a(SharedMonsterAttributes.field_111266_c).func_111126_e()) {
/*      */       return;
/*      */     }
/*      */     
/*  694 */     this.field_70160_al = true;
/*  695 */     float f1 = MathHelper.func_76133_a(p_70653_3_ * p_70653_3_ + p_70653_5_ * p_70653_5_);
/*  696 */     float f2 = 0.4F;
/*      */     
/*  698 */     this.field_70159_w /= 2.0D;
/*  699 */     this.field_70181_x /= 2.0D;
/*  700 */     this.field_70179_y /= 2.0D;
/*      */     
/*  702 */     this.field_70159_w -= p_70653_3_ / f1 * f2;
/*  703 */     this.field_70181_x += f2;
/*  704 */     this.field_70179_y -= p_70653_5_ / f1 * f2;
/*      */     
/*  706 */     if (this.field_70181_x > 0.4000000059604645D) this.field_70181_x = 0.4000000059604645D; 
/*      */   }
/*      */   
/*      */   protected String func_70621_aR() {
/*  710 */     return "game.neutral.hurt";
/*      */   }
/*      */   
/*      */   protected String func_70673_aS() {
/*  714 */     return "game.neutral.die";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void func_70600_l(int p_70600_1_) {}
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {}
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean func_70617_f_() {
/*  731 */     int i = MathHelper.func_76128_c(this.field_70165_t);
/*  732 */     int j = MathHelper.func_76128_c(this.field_70121_D.field_72338_b);
/*  733 */     int k = MathHelper.func_76128_c(this.field_70161_v);
/*  734 */     Block block = this.field_70170_p.func_147439_a(i, j, k);
/*  735 */     return (block == Blocks.field_150468_ap || block == Blocks.field_150395_bd);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean func_70089_S() {
/*  745 */     return (!this.field_70128_L && func_110143_aJ() > 0.0F);
/*      */   }
/*      */ 
/*      */   
/*      */   protected void func_70069_a(float p_70069_1_) {
/*  750 */     super.func_70069_a(p_70069_1_);
/*  751 */     PotionEffect potionEffect = func_70660_b(Potion.field_76430_j);
/*  752 */     float f = (potionEffect != null) ? (potionEffect.func_76458_c() + 1) : 0.0F;
/*      */     
/*  754 */     int i = MathHelper.func_76123_f(p_70069_1_ - 3.0F - f);
/*      */     
/*  756 */     if (i > 0) {
/*  757 */       func_85030_a(func_146067_o(i), 1.0F, 1.0F);
/*  758 */       func_70097_a(DamageSource.field_76379_h, i);
/*      */       
/*  760 */       int j = MathHelper.func_76128_c(this.field_70165_t);
/*  761 */       int k = MathHelper.func_76128_c(this.field_70163_u - 0.20000000298023224D - this.field_70129_M);
/*  762 */       int m = MathHelper.func_76128_c(this.field_70161_v);
/*      */       
/*  764 */       Block block = this.field_70170_p.func_147439_a(j, k, m);
/*  765 */       if (block.func_149688_o() != Material.field_151579_a) {
/*  766 */         Block.SoundType soundType = block.field_149762_H;
/*  767 */         func_85030_a(soundType.func_150498_e(), soundType.func_150497_c() * 0.5F, soundType.func_150494_d() * 0.75F);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   protected String func_146067_o(int p_146067_1_) {
/*  773 */     if (p_146067_1_ > 4) {
/*  774 */       return "game.neutral.hurt.fall.big";
/*      */     }
/*  776 */     return "game.neutral.hurt.fall.small";
/*      */   }
/*      */ 
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public void func_70057_ab() {
/*  782 */     this.field_70737_aN = this.field_70738_aO = 10;
/*  783 */     this.field_70739_aP = 0.0F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int func_70658_aO() {
/*  792 */     int i = 0;
/*  793 */     for (ItemStack itemStack : func_70035_c()) {
/*  794 */       if (itemStack != null && itemStack.func_77973_b() instanceof ItemArmor) {
/*  795 */         int j = ((ItemArmor)itemStack.func_77973_b()).field_77879_b;
/*  796 */         i += j;
/*      */       } 
/*      */     } 
/*  799 */     return i;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void func_70675_k(float p_70675_1_) {}
/*      */   
/*      */   protected float func_70655_b(DamageSource p_70655_1_, float p_70655_2_) {
/*  806 */     if (!p_70655_1_.func_76363_c()) {
/*  807 */       int i = 25 - func_70658_aO();
/*  808 */       float f = p_70655_2_ * i;
/*  809 */       func_70675_k(p_70655_2_);
/*  810 */       p_70655_2_ = f / 25.0F;
/*      */     } 
/*  812 */     return p_70655_2_;
/*      */   }
/*      */   
/*      */   protected float func_70672_c(DamageSource p_70672_1_, float p_70672_2_) {
/*  816 */     if (p_70672_1_.func_151517_h()) return p_70672_2_;
/*      */ 
/*      */     
/*  819 */     if (this instanceof net.minecraft.entity.monster.EntityZombie) {
/*  820 */       p_70672_2_ = p_70672_2_;
/*      */     }
/*  822 */     if (func_70644_a(Potion.field_76429_m) && p_70672_1_ != DamageSource.field_76380_i) {
/*  823 */       int j = (func_70660_b(Potion.field_76429_m).func_76458_c() + 1) * 5;
/*  824 */       int k = 25 - j;
/*  825 */       float f = p_70672_2_ * k;
/*  826 */       p_70672_2_ = f / 25.0F;
/*      */     } 
/*      */     
/*  829 */     if (p_70672_2_ <= 0.0F) return 0.0F;
/*      */     
/*  831 */     int i = EnchantmentHelper.func_77508_a(func_70035_c(), p_70672_1_);
/*  832 */     if (i > 20) {
/*  833 */       i = 20;
/*      */     }
/*  835 */     if (i > 0 && i <= 20) {
/*  836 */       int j = 25 - i;
/*  837 */       float f = p_70672_2_ * j;
/*  838 */       p_70672_2_ = f / 25.0F;
/*      */     } 
/*      */     
/*  841 */     return p_70672_2_;
/*      */   }
/*      */   
/*      */   protected void func_70665_d(DamageSource p_70665_1_, float p_70665_2_) {
/*  845 */     if (func_85032_ar())
/*  846 */       return;  p_70665_2_ = func_70655_b(p_70665_1_, p_70665_2_);
/*  847 */     p_70665_2_ = func_70672_c(p_70665_1_, p_70665_2_);
/*      */     
/*  849 */     float f1 = p_70665_2_;
/*  850 */     p_70665_2_ = Math.max(p_70665_2_ - func_110139_bj(), 0.0F);
/*  851 */     func_110149_m(func_110139_bj() - f1 - p_70665_2_);
/*  852 */     if (p_70665_2_ == 0.0F)
/*      */       return; 
/*  854 */     float f2 = func_110143_aJ();
/*  855 */     func_70606_j(f2 - p_70665_2_);
/*  856 */     func_110142_aN().func_94547_a(p_70665_1_, f2, p_70665_2_);
/*  857 */     func_110149_m(func_110139_bj() - p_70665_2_);
/*      */   }
/*      */   
/*      */   public CombatTracker func_110142_aN() {
/*  861 */     return this.field_94063_bt;
/*      */   }
/*      */   
/*      */   public EntityLivingBase func_94060_bK() {
/*  865 */     if (this.field_94063_bt.func_94550_c() != null) return this.field_94063_bt.func_94550_c(); 
/*  866 */     if (this.field_70717_bb != null) return (EntityLivingBase)this.field_70717_bb; 
/*  867 */     if (this.field_70755_b != null) return this.field_70755_b; 
/*  868 */     return null;
/*      */   }
/*      */   
/*      */   public final float func_110138_aP() {
/*  872 */     return (float)func_110148_a(SharedMonsterAttributes.field_111267_a).func_111126_e();
/*      */   }
/*      */   
/*      */   public final int func_85035_bI() {
/*  876 */     return this.field_70180_af.func_75683_a(9);
/*      */   }
/*      */   
/*      */   public final void func_85034_r(int p_85034_1_) {
/*  880 */     this.field_70180_af.func_75692_b(9, Byte.valueOf((byte)p_85034_1_));
/*      */   }
/*      */   
/*      */   private int func_82166_i() {
/*  884 */     if (func_70644_a(Potion.field_76422_e)) {
/*  885 */       return 6 - (1 + func_70660_b(Potion.field_76422_e).func_76458_c()) * 1;
/*      */     }
/*  887 */     if (func_70644_a(Potion.field_76419_f)) {
/*  888 */       return 6 + (1 + func_70660_b(Potion.field_76419_f).func_76458_c()) * 2;
/*      */     }
/*  890 */     return 6;
/*      */   }
/*      */   
/*      */   public void func_71038_i() {
/*  894 */     if (!this.field_82175_bq || this.field_110158_av >= func_82166_i() / 2 || this.field_110158_av < 0) {
/*  895 */       this.field_110158_av = -1;
/*  896 */       this.field_82175_bq = true;
/*      */       
/*  898 */       if (this.field_70170_p instanceof WorldServer) {
/*  899 */         ((WorldServer)this.field_70170_p).func_73039_n().func_151247_a(this, (Packet)new S0BPacketAnimation(this, 0));
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public void func_70103_a(byte p_70103_1_) {
/*  906 */     if (p_70103_1_ == 2) {
/*  907 */       this.field_70721_aZ = 1.5F;
/*      */       
/*  909 */       this.field_70172_ad = this.field_70771_an;
/*  910 */       this.field_70737_aN = this.field_70738_aO = 10;
/*  911 */       this.field_70739_aP = 0.0F;
/*      */       
/*  913 */       func_85030_a(func_70621_aR(), func_70599_aP(), (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F + 1.0F);
/*  914 */       func_70097_a(DamageSource.field_76377_j, 0.0F);
/*      */     }
/*  916 */     else if (p_70103_1_ == 3) {
/*  917 */       func_85030_a(func_70673_aS(), func_70599_aP(), (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F + 1.0F);
/*  918 */       func_70606_j(0.0F);
/*  919 */       func_70645_a(DamageSource.field_76377_j);
/*      */     } else {
/*  921 */       super.func_70103_a(p_70103_1_);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void func_70076_C() {
/*  927 */     func_70097_a(DamageSource.field_76380_i, 4.0F);
/*      */   }
/*      */   
/*      */   protected void func_82168_bl() {
/*  931 */     int i = func_82166_i();
/*  932 */     if (this.field_82175_bq) {
/*  933 */       this.field_110158_av++;
/*  934 */       if (this.field_110158_av >= i) {
/*  935 */         this.field_110158_av = 0;
/*  936 */         this.field_82175_bq = false;
/*      */       } 
/*      */     } else {
/*  939 */       this.field_110158_av = 0;
/*      */     } 
/*      */     
/*  942 */     this.field_70733_aJ = this.field_110158_av / i;
/*      */   }
/*      */   
/*      */   public IAttributeInstance func_110148_a(IAttribute p_110148_1_) {
/*  946 */     return func_110140_aT().func_111151_a(p_110148_1_);
/*      */   }
/*      */   
/*      */   public BaseAttributeMap func_110140_aT() {
/*  950 */     if (this.field_110155_d == null) {
/*  951 */       this.field_110155_d = (BaseAttributeMap)new ServersideAttributeMap();
/*      */     }
/*      */     
/*  954 */     return this.field_110155_d;
/*      */   }
/*      */   
/*      */   public EnumCreatureAttribute func_70668_bt() {
/*  958 */     return EnumCreatureAttribute.UNDEFINED;
/*      */   }
/*      */ 
/*      */   
/*      */   public abstract ItemStack func_70694_bm();
/*      */ 
/*      */   
/*      */   public abstract ItemStack func_71124_b(int paramInt);
/*      */ 
/*      */   
/*      */   public abstract void func_70062_b(int paramInt, ItemStack paramItemStack);
/*      */ 
/*      */   
/*      */   public void func_70031_b(boolean p_70031_1_) {
/*  972 */     super.func_70031_b(p_70031_1_);
/*      */     
/*  974 */     IAttributeInstance iAttributeInstance = func_110148_a(SharedMonsterAttributes.field_111263_d);
/*  975 */     if (iAttributeInstance.func_111127_a(field_110156_b) != null) {
/*  976 */       iAttributeInstance.func_111124_b(field_110157_c);
/*      */     }
/*  978 */     if (p_70031_1_) {
/*  979 */       iAttributeInstance.func_111121_a(field_110157_c);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public abstract ItemStack[] func_70035_c();
/*      */   
/*      */   protected float func_70599_aP() {
/*  987 */     return 1.0F;
/*      */   }
/*      */   
/*      */   protected float func_70647_i() {
/*  991 */     if (func_70631_g_()) {
/*  992 */       return (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F + 1.5F;
/*      */     }
/*      */     
/*  995 */     return (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F + 1.0F;
/*      */   }
/*      */   
/*      */   protected boolean func_70610_aX() {
/*  999 */     return (func_110143_aJ() <= 0.0F);
/*      */   }
/*      */   
/*      */   public void func_70634_a(double p_70634_1_, double p_70634_3_, double p_70634_5_) {
/* 1003 */     func_70012_b(p_70634_1_, p_70634_3_, p_70634_5_, this.field_70177_z, this.field_70125_A);
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_110145_l(Entity p_110145_1_) {
/* 1008 */     double d1 = p_110145_1_.field_70165_t;
/* 1009 */     double d2 = p_110145_1_.field_70121_D.field_72338_b + p_110145_1_.field_70131_O;
/* 1010 */     double d3 = p_110145_1_.field_70161_v;
/* 1011 */     byte b1 = 1;
/*      */     
/* 1013 */     for (byte b2 = -b1; b2 <= b1; b2++) {
/* 1014 */       for (byte b = -b1; b < b1; b++) {
/* 1015 */         if (b2 != 0 || b != 0) {
/*      */ 
/*      */ 
/*      */           
/* 1019 */           int i = (int)(this.field_70165_t + b2);
/* 1020 */           int j = (int)(this.field_70161_v + b);
/* 1021 */           AxisAlignedBB axisAlignedBB = this.field_70121_D.func_72325_c(b2, 1.0D, b);
/*      */           
/* 1023 */           if (this.field_70170_p.func_147461_a(axisAlignedBB).isEmpty()) {
/* 1024 */             if (World.func_147466_a((IBlockAccess)this.field_70170_p, i, (int)this.field_70163_u, j)) {
/* 1025 */               func_70634_a(this.field_70165_t + b2, this.field_70163_u + 1.0D, this.field_70161_v + b); return;
/*      */             } 
/* 1027 */             if (World.func_147466_a((IBlockAccess)this.field_70170_p, i, (int)this.field_70163_u - 1, j) || this.field_70170_p.func_147439_a(i, (int)this.field_70163_u - 1, j).func_149688_o() == Material.field_151586_h) {
/* 1028 */               d1 = this.field_70165_t + b2;
/* 1029 */               d2 = this.field_70163_u + 1.0D;
/* 1030 */               d3 = this.field_70161_v + b;
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/* 1036 */     func_70634_a(d1, d2, d3);
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public boolean func_94059_bO() {
/* 1040 */     return false;
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public IIcon func_70620_b(ItemStack p_70620_1_, int p_70620_2_) {
/* 1044 */     if (p_70620_1_.func_77973_b().func_77623_v()) {
/* 1045 */       return p_70620_1_.func_77973_b().func_77618_c(p_70620_1_.func_77960_j(), p_70620_2_);
/*      */     }
/* 1047 */     return p_70620_1_.func_77954_c();
/*      */   }
/*      */ 
/*      */   
/*      */   protected void func_70664_aZ() {
/* 1052 */     this.field_70181_x = 0.41999998688697815D;
/* 1053 */     if (func_70644_a(Potion.field_76430_j)) {
/* 1054 */       this.field_70181_x += ((func_70660_b(Potion.field_76430_j).func_76458_c() + 1) * 0.1F);
/*      */     }
/* 1056 */     if (func_70051_ag()) {
/* 1057 */       float f = this.field_70177_z * 0.017453292F;
/*      */       
/* 1059 */       this.field_70159_w -= (MathHelper.func_76126_a(f) * 0.2F);
/* 1060 */       this.field_70179_y += (MathHelper.func_76134_b(f) * 0.2F);
/*      */     } 
/* 1062 */     this.field_70160_al = true;
/*      */   }
/*      */   
/*      */   public void func_70612_e(float p_70612_1_, float p_70612_2_) {
/* 1066 */     if (func_70090_H() && (!(this instanceof EntityPlayer) || !((EntityPlayer)this).field_71075_bZ.field_75100_b)) {
/* 1067 */       double d = this.field_70163_u;
/*      */       
/* 1069 */       func_70060_a(p_70612_1_, p_70612_2_, func_70650_aV() ? 0.04F : 0.02F);
/* 1070 */       func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*      */       
/* 1072 */       this.field_70159_w *= 0.800000011920929D;
/* 1073 */       this.field_70181_x *= 0.800000011920929D;
/* 1074 */       this.field_70179_y *= 0.800000011920929D;
/* 1075 */       this.field_70181_x -= 0.02D;
/*      */       
/* 1077 */       if (this.field_70123_F && func_70038_c(this.field_70159_w, this.field_70181_x + 0.6000000238418579D - this.field_70163_u + d, this.field_70179_y)) {
/* 1078 */         this.field_70181_x = 0.30000001192092896D;
/*      */       }
/* 1080 */     } else if (func_70058_J() && (!(this instanceof EntityPlayer) || !((EntityPlayer)this).field_71075_bZ.field_75100_b)) {
/* 1081 */       double d = this.field_70163_u;
/* 1082 */       func_70060_a(p_70612_1_, p_70612_2_, 0.02F);
/* 1083 */       func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/* 1084 */       this.field_70159_w *= 0.5D;
/* 1085 */       this.field_70181_x *= 0.5D;
/* 1086 */       this.field_70179_y *= 0.5D;
/* 1087 */       this.field_70181_x -= 0.02D;
/*      */       
/* 1089 */       if (this.field_70123_F && func_70038_c(this.field_70159_w, this.field_70181_x + 0.6000000238418579D - this.field_70163_u + d, this.field_70179_y)) {
/* 1090 */         this.field_70181_x = 0.30000001192092896D;
/*      */       }
/*      */     } else {
/* 1093 */       float f3, f1 = 0.91F;
/* 1094 */       if (this.field_70122_E) {
/* 1095 */         f1 = (this.field_70170_p.func_147439_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70121_D.field_72338_b) - 1, MathHelper.func_76128_c(this.field_70161_v))).field_149765_K * 0.91F;
/*      */       }
/*      */       
/* 1098 */       float f2 = 0.16277136F / f1 * f1 * f1;
/*      */ 
/*      */       
/* 1101 */       if (this.field_70122_E) {
/* 1102 */         f3 = func_70689_ay() * f2;
/*      */       } else {
/* 1104 */         f3 = this.field_70747_aH;
/*      */       } 
/*      */ 
/*      */       
/* 1108 */       func_70060_a(p_70612_1_, p_70612_2_, f3);
/*      */       
/* 1110 */       f1 = 0.91F;
/* 1111 */       if (this.field_70122_E) {
/* 1112 */         f1 = (this.field_70170_p.func_147439_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70121_D.field_72338_b) - 1, MathHelper.func_76128_c(this.field_70161_v))).field_149765_K * 0.91F;
/*      */       }
/* 1114 */       if (func_70617_f_()) {
/* 1115 */         float f4 = 0.15F;
/* 1116 */         if (this.field_70159_w < -f4) this.field_70159_w = -f4; 
/* 1117 */         if (this.field_70159_w > f4) this.field_70159_w = f4; 
/* 1118 */         if (this.field_70179_y < -f4) this.field_70179_y = -f4; 
/* 1119 */         if (this.field_70179_y > f4) this.field_70179_y = f4; 
/* 1120 */         this.field_70143_R = 0.0F;
/* 1121 */         if (this.field_70181_x < -0.15D) this.field_70181_x = -0.15D; 
/* 1122 */         boolean bool = (func_70093_af() && this instanceof EntityPlayer) ? true : false;
/* 1123 */         if (bool && this.field_70181_x < 0.0D) this.field_70181_x = 0.0D;
/*      */       
/*      */       } 
/* 1126 */       func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*      */       
/* 1128 */       if (this.field_70123_F && func_70617_f_()) {
/* 1129 */         this.field_70181_x = 0.2D;
/*      */       }
/*      */       
/* 1132 */       if (!this.field_70170_p.field_72995_K || (this.field_70170_p.func_72899_e((int)this.field_70165_t, 0, (int)this.field_70161_v) && (this.field_70170_p.func_72938_d((int)this.field_70165_t, (int)this.field_70161_v)).field_76636_d)) {
/* 1133 */         this.field_70181_x -= 0.08D;
/* 1134 */       } else if (this.field_70163_u > 0.0D) {
/* 1135 */         this.field_70181_x = -0.1D;
/*      */       } else {
/* 1137 */         this.field_70181_x = 0.0D;
/*      */       } 
/* 1139 */       this.field_70181_x *= 0.9800000190734863D;
/* 1140 */       this.field_70159_w *= f1;
/* 1141 */       this.field_70179_y *= f1;
/*      */     } 
/* 1143 */     this.field_70722_aY = this.field_70721_aZ;
/* 1144 */     double d1 = this.field_70165_t - this.field_70169_q;
/* 1145 */     double d2 = this.field_70161_v - this.field_70166_s;
/* 1146 */     float f = MathHelper.func_76133_a(d1 * d1 + d2 * d2) * 4.0F;
/* 1147 */     if (f > 1.0F) f = 1.0F; 
/* 1148 */     this.field_70721_aZ += (f - this.field_70721_aZ) * 0.4F;
/* 1149 */     this.field_70754_ba += this.field_70721_aZ;
/*      */   }
/*      */   
/*      */   protected boolean func_70650_aV() {
/* 1153 */     return false;
/*      */   }
/*      */   
/*      */   public float func_70689_ay() {
/* 1157 */     if (func_70650_aV()) {
/* 1158 */       return this.field_70746_aG;
/*      */     }
/* 1160 */     return 0.1F;
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_70659_e(float p_70659_1_) {
/* 1165 */     this.field_70746_aG = p_70659_1_;
/*      */   }
/*      */   
/*      */   public boolean func_70652_k(Entity p_70652_1_) {
/* 1169 */     func_130011_c(p_70652_1_);
/* 1170 */     return false;
/*      */   }
/*      */   
/*      */   public boolean func_70608_bn() {
/* 1174 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_70071_h_() {
/* 1179 */     super.func_70071_h_();
/*      */     
/* 1181 */     if (!this.field_70170_p.field_72995_K) {
/* 1182 */       int i = func_85035_bI();
/* 1183 */       if (i > 0) {
/* 1184 */         if (this.field_70720_be <= 0) {
/* 1185 */           this.field_70720_be = 20 * (30 - i);
/*      */         }
/* 1187 */         this.field_70720_be--;
/* 1188 */         if (this.field_70720_be <= 0) {
/* 1189 */           func_85034_r(i - 1);
/*      */         }
/*      */       } 
/*      */       
/* 1193 */       for (byte b = 0; b < 5; b++) {
/* 1194 */         ItemStack itemStack1 = this.field_82180_bT[b];
/* 1195 */         ItemStack itemStack2 = func_71124_b(b);
/*      */         
/* 1197 */         if (!ItemStack.func_77989_b(itemStack2, itemStack1)) {
/* 1198 */           ((WorldServer)this.field_70170_p).func_73039_n().func_151247_a(this, (Packet)new S04PacketEntityEquipment(func_145782_y(), b, itemStack2));
/* 1199 */           if (itemStack1 != null) this.field_110155_d.func_111148_a(itemStack1.func_111283_C()); 
/* 1200 */           if (itemStack2 != null) this.field_110155_d.func_111147_b(itemStack2.func_111283_C()); 
/* 1201 */           this.field_82180_bT[b] = (itemStack2 == null) ? null : itemStack2.func_77946_l();
/*      */         } 
/*      */       } 
/*      */       
/* 1205 */       if (this.field_70173_aa % 20 == 0) func_110142_aN().func_94549_h();
/*      */     
/*      */     } 
/* 1208 */     func_70636_d();
/*      */     
/* 1210 */     double d1 = this.field_70165_t - this.field_70169_q;
/* 1211 */     double d2 = this.field_70161_v - this.field_70166_s;
/*      */     
/* 1213 */     float f1 = (float)(d1 * d1 + d2 * d2);
/*      */     
/* 1215 */     float f2 = this.field_70761_aq;
/*      */     
/* 1217 */     float f3 = 0.0F;
/* 1218 */     this.field_70768_au = this.field_110154_aX;
/* 1219 */     float f4 = 0.0F;
/* 1220 */     if (f1 > 0.0025000002F) {
/* 1221 */       f4 = 1.0F;
/* 1222 */       f3 = (float)Math.sqrt(f1) * 3.0F;
/* 1223 */       f2 = (float)Math.atan2(d2, d1) * 180.0F / 3.1415927F - 90.0F;
/*      */     } 
/* 1225 */     if (this.field_70733_aJ > 0.0F) {
/* 1226 */       f2 = this.field_70177_z;
/*      */     }
/* 1228 */     if (!this.field_70122_E) {
/* 1229 */       f4 = 0.0F;
/*      */     }
/* 1231 */     this.field_110154_aX += (f4 - this.field_110154_aX) * 0.3F;
/*      */     
/* 1233 */     this.field_70170_p.field_72984_F.func_76320_a("headTurn");
/*      */     
/* 1235 */     f3 = func_110146_f(f2, f3);
/*      */     
/* 1237 */     this.field_70170_p.field_72984_F.func_76319_b();
/*      */     
/* 1239 */     this.field_70170_p.field_72984_F.func_76320_a("rangeChecks");
/* 1240 */     while (this.field_70177_z - this.field_70126_B < -180.0F)
/* 1241 */       this.field_70126_B -= 360.0F; 
/* 1242 */     while (this.field_70177_z - this.field_70126_B >= 180.0F) {
/* 1243 */       this.field_70126_B += 360.0F;
/*      */     }
/* 1245 */     while (this.field_70761_aq - this.field_70760_ar < -180.0F)
/* 1246 */       this.field_70760_ar -= 360.0F; 
/* 1247 */     while (this.field_70761_aq - this.field_70760_ar >= 180.0F) {
/* 1248 */       this.field_70760_ar += 360.0F;
/*      */     }
/* 1250 */     while (this.field_70125_A - this.field_70127_C < -180.0F)
/* 1251 */       this.field_70127_C -= 360.0F; 
/* 1252 */     while (this.field_70125_A - this.field_70127_C >= 180.0F) {
/* 1253 */       this.field_70127_C += 360.0F;
/*      */     }
/* 1255 */     while (this.field_70759_as - this.field_70758_at < -180.0F)
/* 1256 */       this.field_70758_at -= 360.0F; 
/* 1257 */     while (this.field_70759_as - this.field_70758_at >= 180.0F)
/* 1258 */       this.field_70758_at += 360.0F; 
/* 1259 */     this.field_70170_p.field_72984_F.func_76319_b();
/*      */     
/* 1261 */     this.field_70764_aw += f3;
/*      */   }
/*      */   
/*      */   protected float func_110146_f(float p_110146_1_, float p_110146_2_) {
/* 1265 */     float f1 = MathHelper.func_76142_g(p_110146_1_ - this.field_70761_aq);
/* 1266 */     this.field_70761_aq += f1 * 0.3F;
/*      */     
/* 1268 */     float f2 = MathHelper.func_76142_g(this.field_70177_z - this.field_70761_aq);
/* 1269 */     boolean bool = (f2 < -90.0F || f2 >= 90.0F) ? true : false;
/* 1270 */     if (f2 < -75.0F) f2 = -75.0F; 
/* 1271 */     if (f2 >= 75.0F) f2 = 75.0F; 
/* 1272 */     this.field_70761_aq = this.field_70177_z - f2;
/* 1273 */     if (f2 * f2 > 2500.0F) {
/* 1274 */       this.field_70761_aq += f2 * 0.2F;
/*      */     }
/*      */     
/* 1277 */     if (bool) {
/* 1278 */       p_110146_2_ *= -1.0F;
/*      */     }
/*      */     
/* 1281 */     return p_110146_2_;
/*      */   }
/*      */   
/*      */   public void func_70636_d() {
/* 1285 */     if (this.field_70773_bE > 0) this.field_70773_bE--; 
/* 1286 */     if (this.field_70716_bi > 0) {
/* 1287 */       double d1 = this.field_70165_t + (this.field_70709_bj - this.field_70165_t) / this.field_70716_bi;
/* 1288 */       double d2 = this.field_70163_u + (this.field_70710_bk - this.field_70163_u) / this.field_70716_bi;
/* 1289 */       double d3 = this.field_70161_v + (this.field_110152_bk - this.field_70161_v) / this.field_70716_bi;
/*      */       
/* 1291 */       double d4 = MathHelper.func_76138_g(this.field_70712_bm - this.field_70177_z);
/*      */       
/* 1293 */       this.field_70177_z = (float)(this.field_70177_z + d4 / this.field_70716_bi);
/* 1294 */       this.field_70125_A = (float)(this.field_70125_A + (this.field_70705_bn - this.field_70125_A) / this.field_70716_bi);
/*      */       
/* 1296 */       this.field_70716_bi--;
/* 1297 */       func_70107_b(d1, d2, d3);
/* 1298 */       func_70101_b(this.field_70177_z, this.field_70125_A);
/* 1299 */     } else if (!func_70613_aW()) {
/*      */ 
/*      */       
/* 1302 */       this.field_70159_w *= 0.98D;
/* 1303 */       this.field_70181_x *= 0.98D;
/* 1304 */       this.field_70179_y *= 0.98D;
/*      */     } 
/*      */     
/* 1307 */     if (Math.abs(this.field_70159_w) < 0.005D) this.field_70159_w = 0.0D; 
/* 1308 */     if (Math.abs(this.field_70181_x) < 0.005D) this.field_70181_x = 0.0D; 
/* 1309 */     if (Math.abs(this.field_70179_y) < 0.005D) this.field_70179_y = 0.0D;
/*      */     
/* 1311 */     this.field_70170_p.field_72984_F.func_76320_a("ai");
/* 1312 */     if (func_70610_aX()) {
/* 1313 */       this.field_70703_bu = false;
/* 1314 */       this.field_70702_br = 0.0F;
/* 1315 */       this.field_70701_bs = 0.0F;
/* 1316 */       this.field_70704_bt = 0.0F;
/*      */     }
/* 1318 */     else if (func_70613_aW()) {
/* 1319 */       if (func_70650_aV()) {
/* 1320 */         this.field_70170_p.field_72984_F.func_76320_a("newAi");
/* 1321 */         func_70619_bc();
/* 1322 */         this.field_70170_p.field_72984_F.func_76319_b();
/*      */       } else {
/* 1324 */         this.field_70170_p.field_72984_F.func_76320_a("oldAi");
/* 1325 */         func_70626_be();
/* 1326 */         this.field_70170_p.field_72984_F.func_76319_b();
/* 1327 */         this.field_70759_as = this.field_70177_z;
/*      */       } 
/*      */     } 
/*      */     
/* 1331 */     this.field_70170_p.field_72984_F.func_76319_b();
/*      */     
/* 1333 */     this.field_70170_p.field_72984_F.func_76320_a("jump");
/* 1334 */     if (this.field_70703_bu) {
/* 1335 */       if (func_70090_H() || func_70058_J()) {
/* 1336 */         this.field_70181_x += 0.03999999910593033D;
/* 1337 */       } else if (this.field_70122_E && 
/* 1338 */         this.field_70773_bE == 0) {
/* 1339 */         func_70664_aZ();
/* 1340 */         this.field_70773_bE = 10;
/*      */       } 
/*      */     } else {
/*      */       
/* 1344 */       this.field_70773_bE = 0;
/*      */     } 
/* 1346 */     this.field_70170_p.field_72984_F.func_76319_b();
/*      */     
/* 1348 */     this.field_70170_p.field_72984_F.func_76320_a("travel");
/* 1349 */     this.field_70702_br *= 0.98F;
/* 1350 */     this.field_70701_bs *= 0.98F;
/* 1351 */     this.field_70704_bt *= 0.9F;
/*      */     
/* 1353 */     func_70612_e(this.field_70702_br, this.field_70701_bs);
/* 1354 */     this.field_70170_p.field_72984_F.func_76319_b();
/*      */     
/* 1356 */     this.field_70170_p.field_72984_F.func_76320_a("push");
/* 1357 */     if (!this.field_70170_p.field_72995_K) {
/* 1358 */       func_85033_bc();
/*      */     }
/* 1360 */     this.field_70170_p.field_72984_F.func_76319_b();
/*      */   }
/*      */ 
/*      */   
/*      */   protected void func_70619_bc() {}
/*      */   
/*      */   protected void func_85033_bc() {
/* 1367 */     List<Entity> list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b(0.20000000298023224D, 0.0D, 0.20000000298023224D));
/* 1368 */     if (list != null && !list.isEmpty())
/* 1369 */       for (byte b = 0; b < list.size(); b++) {
/* 1370 */         Entity entity = list.get(b);
/* 1371 */         if (entity.func_70104_M()) func_82167_n(entity);
/*      */       
/*      */       }  
/*      */   }
/*      */   
/*      */   protected void func_82167_n(Entity p_82167_1_) {
/* 1377 */     p_82167_1_.func_70108_f(this);
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_70098_U() {
/* 1382 */     super.func_70098_U();
/* 1383 */     this.field_70768_au = this.field_110154_aX;
/* 1384 */     this.field_110154_aX = 0.0F;
/* 1385 */     this.field_70143_R = 0.0F;
/*      */   }
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public void func_70056_a(double p_70056_1_, double p_70056_3_, double p_70056_5_, float p_70056_7_, float p_70056_8_, int p_70056_9_) {
/* 1390 */     this.field_70129_M = 0.0F;
/* 1391 */     this.field_70709_bj = p_70056_1_;
/* 1392 */     this.field_70710_bk = p_70056_3_;
/* 1393 */     this.field_110152_bk = p_70056_5_;
/* 1394 */     this.field_70712_bm = p_70056_7_;
/* 1395 */     this.field_70705_bn = p_70056_8_;
/*      */     
/* 1397 */     this.field_70716_bi = p_70056_9_;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void func_70629_bd() {}
/*      */   
/*      */   protected void func_70626_be() {
/* 1404 */     this.field_70708_bq++;
/*      */   }
/*      */   
/*      */   public void func_70637_d(boolean p_70637_1_) {
/* 1408 */     this.field_70703_bu = p_70637_1_;
/*      */   }
/*      */   
/*      */   public void func_71001_a(Entity p_71001_1_, int p_71001_2_) {
/* 1412 */     if (!p_71001_1_.field_70128_L && !this.field_70170_p.field_72995_K) {
/* 1413 */       EntityTracker entityTracker = ((WorldServer)this.field_70170_p).func_73039_n();
/* 1414 */       if (p_71001_1_ instanceof net.minecraft.entity.item.EntityItem) {
/* 1415 */         entityTracker.func_151247_a(p_71001_1_, (Packet)new S0DPacketCollectItem(p_71001_1_.func_145782_y(), func_145782_y()));
/*      */       }
/* 1417 */       if (p_71001_1_ instanceof net.minecraft.entity.projectile.EntityArrow) {
/* 1418 */         entityTracker.func_151247_a(p_71001_1_, (Packet)new S0DPacketCollectItem(p_71001_1_.func_145782_y(), func_145782_y()));
/*      */       }
/* 1420 */       if (p_71001_1_ instanceof EntityXPOrb) {
/* 1421 */         entityTracker.func_151247_a(p_71001_1_, (Packet)new S0DPacketCollectItem(p_71001_1_.func_145782_y(), func_145782_y()));
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean func_70685_l(Entity p_70685_1_) {
/* 1427 */     return (this.field_70170_p.func_72933_a(Vec3.func_72443_a(this.field_70165_t, this.field_70163_u + func_70047_e(), this.field_70161_v), Vec3.func_72443_a(p_70685_1_.field_70165_t, p_70685_1_.field_70163_u + p_70685_1_.func_70047_e(), p_70685_1_.field_70161_v)) == null);
/*      */   }
/*      */ 
/*      */   
/*      */   public Vec3 func_70040_Z() {
/* 1432 */     return func_70676_i(1.0F);
/*      */   }
/*      */   
/*      */   public Vec3 func_70676_i(float p_70676_1_) {
/* 1436 */     if (p_70676_1_ == 1.0F) {
/* 1437 */       float f7 = MathHelper.func_76134_b(-this.field_70177_z * 0.017453292F - 3.1415927F);
/* 1438 */       float f8 = MathHelper.func_76126_a(-this.field_70177_z * 0.017453292F - 3.1415927F);
/* 1439 */       float f9 = -MathHelper.func_76134_b(-this.field_70125_A * 0.017453292F);
/* 1440 */       float f10 = MathHelper.func_76126_a(-this.field_70125_A * 0.017453292F);
/*      */       
/* 1442 */       return Vec3.func_72443_a((f8 * f9), f10, (f7 * f9));
/*      */     } 
/* 1444 */     float f1 = this.field_70127_C + (this.field_70125_A - this.field_70127_C) * p_70676_1_;
/* 1445 */     float f2 = this.field_70126_B + (this.field_70177_z - this.field_70126_B) * p_70676_1_;
/*      */     
/* 1447 */     float f3 = MathHelper.func_76134_b(-f2 * 0.017453292F - 3.1415927F);
/* 1448 */     float f4 = MathHelper.func_76126_a(-f2 * 0.017453292F - 3.1415927F);
/* 1449 */     float f5 = -MathHelper.func_76134_b(-f1 * 0.017453292F);
/* 1450 */     float f6 = MathHelper.func_76126_a(-f1 * 0.017453292F);
/*      */     
/* 1452 */     return Vec3.func_72443_a((f4 * f5), f6, (f3 * f5));
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public float func_70678_g(float p_70678_1_) {
/* 1456 */     float f = this.field_70733_aJ - this.field_70732_aI;
/* 1457 */     if (f < 0.0F) f++; 
/* 1458 */     return this.field_70732_aI + f * p_70678_1_;
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public Vec3 func_70666_h(float p_70666_1_) {
/* 1462 */     if (p_70666_1_ == 1.0F) {
/* 1463 */       return Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*      */     }
/* 1465 */     double d1 = this.field_70169_q + (this.field_70165_t - this.field_70169_q) * p_70666_1_;
/* 1466 */     double d2 = this.field_70167_r + (this.field_70163_u - this.field_70167_r) * p_70666_1_;
/* 1467 */     double d3 = this.field_70166_s + (this.field_70161_v - this.field_70166_s) * p_70666_1_;
/*      */     
/* 1469 */     return Vec3.func_72443_a(d1, d2, d3);
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public MovingObjectPosition func_70614_a(double p_70614_1_, float p_70614_3_) {
/* 1473 */     Vec3 vec31 = func_70666_h(p_70614_3_);
/* 1474 */     Vec3 vec32 = func_70676_i(p_70614_3_);
/* 1475 */     Vec3 vec33 = vec31.func_72441_c(vec32.field_72450_a * p_70614_1_, vec32.field_72448_b * p_70614_1_, vec32.field_72449_c * p_70614_1_);
/* 1476 */     return this.field_70170_p.func_147447_a(vec31, vec33, false, false, true);
/*      */   }
/*      */   
/*      */   public boolean func_70613_aW() {
/* 1480 */     return !this.field_70170_p.field_72995_K;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean func_70067_L() {
/* 1485 */     return !this.field_70128_L;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean func_70104_M() {
/* 1490 */     return !this.field_70128_L;
/*      */   }
/*      */ 
/*      */   
/*      */   public float func_70047_e() {
/* 1495 */     return this.field_70131_O * 0.85F;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void func_70018_K() {
/* 1500 */     this.field_70133_I = (this.field_70146_Z.nextDouble() >= func_110148_a(SharedMonsterAttributes.field_111266_c).func_111126_e());
/*      */   }
/*      */ 
/*      */   
/*      */   public float func_70079_am() {
/* 1505 */     return this.field_70759_as;
/*      */   }
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public void func_70034_d(float p_70034_1_) {
/* 1510 */     this.field_70759_as = p_70034_1_;
/*      */   }
/*      */   
/*      */   public float func_110139_bj() {
/* 1514 */     return this.field_110151_bq;
/*      */   }
/*      */   
/*      */   public void func_110149_m(float p_110149_1_) {
/* 1518 */     if (p_110149_1_ < 0.0F) p_110149_1_ = 0.0F; 
/* 1519 */     this.field_110151_bq = p_110149_1_;
/*      */   }
/*      */   
/*      */   public Team func_96124_cp() {
/* 1523 */     return null;
/*      */   }
/*      */   
/*      */   public boolean func_142014_c(EntityLivingBase p_142014_1_) {
/* 1527 */     return func_142012_a(p_142014_1_.func_96124_cp());
/*      */   }
/*      */   
/*      */   public boolean func_142012_a(Team p_142012_1_) {
/* 1531 */     if (func_96124_cp() != null) {
/* 1532 */       return func_96124_cp().func_142054_a(p_142012_1_);
/*      */     }
/* 1534 */     return false;
/*      */   }
/*      */   
/*      */   public void func_152111_bt() {}
/*      */   
/*      */   public void func_152112_bu() {}
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\EntityLivingBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */