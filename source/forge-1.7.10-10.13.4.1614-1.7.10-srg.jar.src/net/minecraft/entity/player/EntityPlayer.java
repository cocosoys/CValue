/*      */ package net.minecraft.entity.player;
/*      */ import com.mojang.authlib.GameProfile;
/*      */ import cpw.mods.fml.relauncher.Side;
/*      */ import cpw.mods.fml.relauncher.SideOnly;
/*      */ import java.util.Collection;
/*      */ import java.util.List;
/*      */ import java.util.UUID;
/*      */ import net.minecraft.block.Block;
/*      */ import net.minecraft.block.BlockBed;
/*      */ import net.minecraft.block.material.Material;
/*      */ import net.minecraft.enchantment.EnchantmentHelper;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.EntityList;
/*      */ import net.minecraft.entity.EntityLivingBase;
/*      */ import net.minecraft.entity.IEntityMultiPart;
/*      */ import net.minecraft.entity.SharedMonsterAttributes;
/*      */ import net.minecraft.entity.ai.attributes.IAttributeInstance;
/*      */ import net.minecraft.entity.item.EntityItem;
/*      */ import net.minecraft.entity.projectile.EntityArrow;
/*      */ import net.minecraft.event.ClickEvent;
/*      */ import net.minecraft.init.Blocks;
/*      */ import net.minecraft.init.Items;
/*      */ import net.minecraft.inventory.Container;
/*      */ import net.minecraft.inventory.IInventory;
/*      */ import net.minecraft.inventory.InventoryEnderChest;
/*      */ import net.minecraft.item.EnumAction;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.nbt.NBTTagCompound;
/*      */ import net.minecraft.nbt.NBTTagList;
/*      */ import net.minecraft.potion.Potion;
/*      */ import net.minecraft.scoreboard.IScoreObjectiveCriteria;
/*      */ import net.minecraft.scoreboard.Score;
/*      */ import net.minecraft.scoreboard.Team;
/*      */ import net.minecraft.stats.AchievementList;
/*      */ import net.minecraft.stats.StatBase;
/*      */ import net.minecraft.stats.StatList;
/*      */ import net.minecraft.util.AxisAlignedBB;
/*      */ import net.minecraft.util.ChatComponentText;
/*      */ import net.minecraft.util.ChunkCoordinates;
/*      */ import net.minecraft.util.DamageSource;
/*      */ import net.minecraft.util.FoodStats;
/*      */ import net.minecraft.util.IChatComponent;
/*      */ import net.minecraft.util.IIcon;
/*      */ import net.minecraft.util.MathHelper;
/*      */ import net.minecraft.util.Vec3;
/*      */ import net.minecraft.world.EnumDifficulty;
/*      */ import net.minecraft.world.World;
/*      */ import net.minecraft.world.chunk.IChunkProvider;
/*      */ 
/*      */ public abstract class EntityPlayer extends EntityLivingBase implements ICommandSender {
/*      */   public enum EnumChatVisibility {
/*   52 */     FULL(0, "options.chat.visibility.full"),
/*   53 */     SYSTEM(1, "options.chat.visibility.system"),
/*   54 */     HIDDEN(2, "options.chat.visibility.hidden");
/*      */     
/*   56 */     private static final EnumChatVisibility[] field_151432_d = new EnumChatVisibility[(values()).length];
/*      */ 
/*      */ 
/*      */     
/*      */     private final int field_151433_e;
/*      */ 
/*      */ 
/*      */     
/*      */     private final String field_151430_f;
/*      */ 
/*      */ 
/*      */     
/*      */     private static final String __OBFID = "CL_00001714";
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     static {
/*   74 */       for (EnumChatVisibility enumChatVisibility : values())
/*   75 */         field_151432_d[enumChatVisibility.field_151433_e] = enumChatVisibility; 
/*      */     }
/*      */     EnumChatVisibility(int p_i45323_3_, String p_i45323_4_) { this.field_151433_e = p_i45323_3_;
/*      */       this.field_151430_f = p_i45323_4_; }
/*      */     public int func_151428_a() { return this.field_151433_e; } public static EnumChatVisibility func_151426_a(int p_151426_0_) { return field_151432_d[p_151426_0_ % field_151432_d.length]; } @SideOnly(Side.CLIENT)
/*   80 */     public String func_151429_b() { return this.field_151430_f; }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   92 */   public InventoryPlayer field_71071_by = new InventoryPlayer(this);
/*   93 */   private InventoryEnderChest field_71078_a = new InventoryEnderChest();
/*      */   
/*      */   public Container field_71069_bz;
/*      */   public Container field_71070_bA;
/*   97 */   protected FoodStats field_71100_bB = new FoodStats();
/*      */   
/*      */   protected int field_71101_bC;
/*      */   public float field_71107_bF;
/*      */   public float field_71109_bG;
/*      */   public int field_71090_bL;
/*      */   public double field_71091_bM;
/*      */   public double field_71096_bN;
/*      */   public double field_71097_bO;
/*      */   public double field_71094_bP;
/*      */   public double field_71095_bQ;
/*      */   public double field_71085_bR;
/*      */   protected boolean field_71083_bS;
/*      */   public ChunkCoordinates field_71081_bT;
/*      */   private int field_71076_b;
/*      */   public float field_71079_bU;
/*      */   @SideOnly(Side.CLIENT)
/*      */   public float field_71082_cx;
/*      */   public float field_71089_bV;
/*      */   private ChunkCoordinates field_71077_c;
/*      */   private boolean field_82248_d;
/*      */   private ChunkCoordinates field_71073_d;
/*  119 */   public PlayerCapabilities field_71075_bZ = new PlayerCapabilities();
/*      */   public int field_71068_ca;
/*      */   public int field_71067_cb;
/*      */   public float field_71106_cc;
/*      */   private ItemStack field_71074_e;
/*      */   private int field_71072_f;
/*  125 */   protected float field_71108_cd = 0.1F;
/*  126 */   protected float field_71102_ce = 0.02F; private int field_82249_h; private final GameProfile field_146106_i;
/*      */   public EntityFishHook field_71104_cf;
/*      */   private static final String __OBFID = "CL_00001711";
/*      */   
/*      */   public EntityPlayer(World p_i45324_1_, GameProfile p_i45324_2_) {
/*  131 */     super(p_i45324_1_);
/*  132 */     this.field_96093_i = func_146094_a(p_i45324_2_);
/*      */     
/*  134 */     this.field_146106_i = p_i45324_2_;
/*      */     
/*  136 */     this.field_71069_bz = (Container)new ContainerPlayer(this.field_71071_by, !p_i45324_1_.field_72995_K, this);
/*  137 */     this.field_71070_bA = this.field_71069_bz;
/*      */     
/*  139 */     this.field_70129_M = 1.62F;
/*  140 */     ChunkCoordinates chunkCoordinates = p_i45324_1_.func_72861_E();
/*  141 */     func_70012_b(chunkCoordinates.field_71574_a + 0.5D, (chunkCoordinates.field_71572_b + 1), chunkCoordinates.field_71573_c + 0.5D, 0.0F, 0.0F);
/*      */     
/*  143 */     this.field_70741_aB = 180.0F;
/*  144 */     this.field_70174_ab = 20;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void func_110147_ax() {
/*  149 */     super.func_110147_ax();
/*      */     
/*  151 */     func_110140_aT().func_111150_b(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0D);
/*      */   }
/*      */ 
/*      */   
/*      */   protected void func_70088_a() {
/*  156 */     super.func_70088_a();
/*      */     
/*  158 */     this.field_70180_af.func_75682_a(16, Byte.valueOf((byte)0));
/*  159 */     this.field_70180_af.func_75682_a(17, Float.valueOf(0.0F));
/*  160 */     this.field_70180_af.func_75682_a(18, Integer.valueOf(0));
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public ItemStack func_71011_bu() {
/*  164 */     return this.field_71074_e;
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public int func_71052_bv() {
/*  168 */     return this.field_71072_f;
/*      */   }
/*      */   
/*      */   public boolean func_71039_bw() {
/*  172 */     return (this.field_71074_e != null);
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public int func_71057_bx() {
/*  176 */     if (func_71039_bw()) {
/*  177 */       return this.field_71074_e.func_77988_m() - this.field_71072_f;
/*      */     }
/*  179 */     return 0;
/*      */   }
/*      */   
/*      */   public void func_71034_by() {
/*  183 */     if (this.field_71074_e != null) {
/*  184 */       this.field_71074_e.func_77974_b(this.field_70170_p, this, this.field_71072_f);
/*      */     }
/*  186 */     func_71041_bz();
/*      */   }
/*      */   
/*      */   public void func_71041_bz() {
/*  190 */     this.field_71074_e = null;
/*  191 */     this.field_71072_f = 0;
/*  192 */     if (!this.field_70170_p.field_72995_K) {
/*  193 */       func_70019_c(false);
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean func_70632_aY() {
/*  198 */     return (func_71039_bw() && this.field_71074_e.func_77973_b().func_77661_b(this.field_71074_e) == EnumAction.block);
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_70071_h_() {
/*  203 */     if (this.field_71074_e != null) {
/*  204 */       ItemStack itemStack = this.field_71071_by.func_70448_g();
/*  205 */       if (itemStack == this.field_71074_e) {
/*  206 */         if (this.field_71072_f <= 25 && this.field_71072_f % 4 == 0) {
/*  207 */           func_71010_c(itemStack, 5);
/*      */         }
/*  209 */         if (--this.field_71072_f == 0 && 
/*  210 */           !this.field_70170_p.field_72995_K) {
/*  211 */           func_71036_o();
/*      */         }
/*      */       } else {
/*      */         
/*  215 */         func_71041_bz();
/*      */       } 
/*      */     } 
/*      */     
/*  219 */     if (this.field_71090_bL > 0) this.field_71090_bL--; 
/*  220 */     if (func_70608_bn()) {
/*  221 */       this.field_71076_b++;
/*  222 */       if (this.field_71076_b > 100) {
/*  223 */         this.field_71076_b = 100;
/*      */       }
/*      */       
/*  226 */       if (!this.field_70170_p.field_72995_K) {
/*  227 */         if (!func_71065_l()) {
/*  228 */           func_70999_a(true, true, false);
/*  229 */         } else if (this.field_70170_p.func_72935_r()) {
/*  230 */           func_70999_a(false, true, true);
/*      */         } 
/*      */       }
/*  233 */     } else if (this.field_71076_b > 0) {
/*  234 */       this.field_71076_b++;
/*  235 */       if (this.field_71076_b >= 110) {
/*  236 */         this.field_71076_b = 0;
/*      */       }
/*      */     } 
/*      */     
/*  240 */     super.func_70071_h_();
/*      */     
/*  242 */     if (!this.field_70170_p.field_72995_K && 
/*  243 */       this.field_71070_bA != null && !this.field_71070_bA.func_75145_c(this)) {
/*  244 */       func_71053_j();
/*  245 */       this.field_71070_bA = this.field_71069_bz;
/*      */     } 
/*      */ 
/*      */     
/*  249 */     if (func_70027_ad() && this.field_71075_bZ.field_75102_a) {
/*  250 */       func_70066_B();
/*      */     }
/*      */     
/*  253 */     this.field_71091_bM = this.field_71094_bP;
/*  254 */     this.field_71096_bN = this.field_71095_bQ;
/*  255 */     this.field_71097_bO = this.field_71085_bR;
/*      */     
/*  257 */     double d1 = this.field_70165_t - this.field_71094_bP;
/*  258 */     double d2 = this.field_70163_u - this.field_71095_bQ;
/*  259 */     double d3 = this.field_70161_v - this.field_71085_bR;
/*      */     
/*  261 */     double d4 = 10.0D;
/*  262 */     if (d1 > d4) this.field_71091_bM = this.field_71094_bP = this.field_70165_t; 
/*  263 */     if (d3 > d4) this.field_71097_bO = this.field_71085_bR = this.field_70161_v; 
/*  264 */     if (d2 > d4) this.field_71096_bN = this.field_71095_bQ = this.field_70163_u; 
/*  265 */     if (d1 < -d4) this.field_71091_bM = this.field_71094_bP = this.field_70165_t; 
/*  266 */     if (d3 < -d4) this.field_71097_bO = this.field_71085_bR = this.field_70161_v; 
/*  267 */     if (d2 < -d4) this.field_71096_bN = this.field_71095_bQ = this.field_70163_u;
/*      */     
/*  269 */     this.field_71094_bP += d1 * 0.25D;
/*  270 */     this.field_71085_bR += d3 * 0.25D;
/*  271 */     this.field_71095_bQ += d2 * 0.25D;
/*      */ 
/*      */     
/*  274 */     if (this.field_70154_o == null) {
/*  275 */       this.field_71073_d = null;
/*      */     }
/*      */     
/*  278 */     if (!this.field_70170_p.field_72995_K) {
/*  279 */       this.field_71100_bB.func_75118_a(this);
/*  280 */       func_71064_a(StatList.field_75948_k, 1);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public int func_82145_z() {
/*  286 */     return this.field_71075_bZ.field_75102_a ? 0 : 80;
/*      */   }
/*      */ 
/*      */   
/*      */   protected String func_145776_H() {
/*  291 */     return "game.player.swim";
/*      */   }
/*      */ 
/*      */   
/*      */   protected String func_145777_O() {
/*  296 */     return "game.player.swim.splash";
/*      */   }
/*      */ 
/*      */   
/*      */   public int func_82147_ab() {
/*  301 */     return 10;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_85030_a(String p_85030_1_, float p_85030_2_, float p_85030_3_) {
/*  308 */     this.field_70170_p.func_85173_a(this, p_85030_1_, p_85030_2_, p_85030_3_);
/*      */   }
/*      */   
/*      */   protected void func_71010_c(ItemStack p_71010_1_, int p_71010_2_) {
/*  312 */     if (p_71010_1_.func_77975_n() == EnumAction.drink) {
/*  313 */       func_85030_a("random.drink", 0.5F, this.field_70170_p.field_73012_v.nextFloat() * 0.1F + 0.9F);
/*      */     }
/*  315 */     if (p_71010_1_.func_77975_n() == EnumAction.eat) {
/*  316 */       for (byte b = 0; b < p_71010_2_; b++) {
/*  317 */         Vec3 vec31 = Vec3.func_72443_a((this.field_70146_Z.nextFloat() - 0.5D) * 0.1D, Math.random() * 0.1D + 0.1D, 0.0D);
/*  318 */         vec31.func_72440_a(-this.field_70125_A * 3.1415927F / 180.0F);
/*  319 */         vec31.func_72442_b(-this.field_70177_z * 3.1415927F / 180.0F);
/*      */         
/*  321 */         Vec3 vec32 = Vec3.func_72443_a((this.field_70146_Z.nextFloat() - 0.5D) * 0.3D, -this.field_70146_Z.nextFloat() * 0.6D - 0.3D, 0.6D);
/*  322 */         vec32.func_72440_a(-this.field_70125_A * 3.1415927F / 180.0F);
/*  323 */         vec32.func_72442_b(-this.field_70177_z * 3.1415927F / 180.0F);
/*  324 */         vec32 = vec32.func_72441_c(this.field_70165_t, this.field_70163_u + func_70047_e(), this.field_70161_v);
/*  325 */         String str = "iconcrack_" + Item.func_150891_b(p_71010_1_.func_77973_b());
/*  326 */         if (p_71010_1_.func_77981_g()) {
/*  327 */           str = str + "_" + p_71010_1_.func_77960_j();
/*      */         }
/*  329 */         this.field_70170_p.func_72869_a(str, vec32.field_72450_a, vec32.field_72448_b, vec32.field_72449_c, vec31.field_72450_a, vec31.field_72448_b + 0.05D, vec31.field_72449_c);
/*      */       } 
/*  331 */       func_85030_a("random.eat", 0.5F + 0.5F * this.field_70146_Z.nextInt(2), (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F + 1.0F);
/*      */     } 
/*      */   }
/*      */   
/*      */   protected void func_71036_o() {
/*  336 */     if (this.field_71074_e != null) {
/*  337 */       func_71010_c(this.field_71074_e, 16);
/*      */       
/*  339 */       int i = this.field_71074_e.field_77994_a;
/*  340 */       ItemStack itemStack = this.field_71074_e.func_77950_b(this.field_70170_p, this);
/*  341 */       if (itemStack != this.field_71074_e || (itemStack != null && itemStack.field_77994_a != i)) {
/*  342 */         this.field_71071_by.field_70462_a[this.field_71071_by.field_70461_c] = itemStack;
/*  343 */         if (itemStack.field_77994_a == 0) {
/*  344 */           this.field_71071_by.field_70462_a[this.field_71071_by.field_70461_c] = null;
/*      */         }
/*      */       } 
/*  347 */       func_71041_bz();
/*      */     } 
/*      */   }
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public void func_70103_a(byte p_70103_1_) {
/*  353 */     if (p_70103_1_ == 9) {
/*  354 */       func_71036_o();
/*      */     } else {
/*  356 */       super.func_70103_a(p_70103_1_);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected boolean func_70610_aX() {
/*  362 */     return (func_110143_aJ() <= 0.0F || func_70608_bn());
/*      */   }
/*      */   
/*      */   public void func_71053_j() {
/*  366 */     this.field_71070_bA = this.field_71069_bz;
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_70078_a(Entity p_70078_1_) {
/*  371 */     if (this.field_70154_o != null && p_70078_1_ == null) {
/*  372 */       if (!this.field_70170_p.field_72995_K) func_110145_l(this.field_70154_o);
/*      */       
/*  374 */       if (this.field_70154_o != null) {
/*  375 */         this.field_70154_o.field_70153_n = null;
/*      */       }
/*  377 */       this.field_70154_o = null;
/*      */       
/*      */       return;
/*      */     } 
/*  381 */     super.func_70078_a(p_70078_1_);
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_70098_U() {
/*  386 */     if (!this.field_70170_p.field_72995_K && func_70093_af()) {
/*  387 */       func_70078_a((Entity)null);
/*  388 */       func_70095_a(false);
/*      */       
/*      */       return;
/*      */     } 
/*  392 */     double d1 = this.field_70165_t, d2 = this.field_70163_u, d3 = this.field_70161_v;
/*  393 */     float f1 = this.field_70177_z, f2 = this.field_70125_A;
/*      */     
/*  395 */     super.func_70098_U();
/*  396 */     this.field_71107_bF = this.field_71109_bG;
/*  397 */     this.field_71109_bG = 0.0F;
/*      */     
/*  399 */     func_71015_k(this.field_70165_t - d1, this.field_70163_u - d2, this.field_70161_v - d3);
/*      */     
/*  401 */     if (this.field_70154_o instanceof EntityPig) {
/*  402 */       this.field_70125_A = f2;
/*  403 */       this.field_70177_z = f1;
/*  404 */       this.field_70761_aq = ((EntityPig)this.field_70154_o).field_70761_aq;
/*      */     } 
/*      */   }
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public void func_70065_x() {
/*  410 */     this.field_70129_M = 1.62F;
/*  411 */     func_70105_a(0.6F, 1.8F);
/*  412 */     super.func_70065_x();
/*  413 */     func_70606_j(func_110138_aP());
/*  414 */     this.field_70725_aQ = 0;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void func_70626_be() {
/*  419 */     super.func_70626_be();
/*  420 */     func_82168_bl();
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_70636_d() {
/*  425 */     if (this.field_71101_bC > 0) this.field_71101_bC--;
/*      */     
/*  427 */     if (this.field_70170_p.field_73013_u == EnumDifficulty.PEACEFUL && func_110143_aJ() < func_110138_aP() && this.field_70170_p.func_82736_K().func_82766_b("naturalRegeneration") && 
/*  428 */       this.field_70173_aa % 20 * 12 == 0) func_70691_i(1.0F);
/*      */     
/*  430 */     this.field_71071_by.func_70429_k();
/*  431 */     this.field_71107_bF = this.field_71109_bG;
/*      */     
/*  433 */     super.func_70636_d();
/*      */     
/*  435 */     IAttributeInstance iAttributeInstance = func_110148_a(SharedMonsterAttributes.field_111263_d);
/*  436 */     if (!this.field_70170_p.field_72995_K) iAttributeInstance.func_111128_a(this.field_71075_bZ.func_75094_b()); 
/*  437 */     this.field_70747_aH = this.field_71102_ce;
/*  438 */     if (func_70051_ag()) {
/*  439 */       this.field_70747_aH = (float)(this.field_70747_aH + this.field_71102_ce * 0.3D);
/*      */     }
/*      */     
/*  442 */     func_70659_e((float)iAttributeInstance.func_111126_e());
/*      */     
/*  444 */     float f1 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/*  445 */     float f2 = (float)Math.atan(-this.field_70181_x * 0.20000000298023224D) * 15.0F;
/*  446 */     if (f1 > 0.1F) f1 = 0.1F; 
/*  447 */     if (!this.field_70122_E || func_110143_aJ() <= 0.0F) f1 = 0.0F; 
/*  448 */     if (this.field_70122_E || func_110143_aJ() <= 0.0F) f2 = 0.0F; 
/*  449 */     this.field_71109_bG += (f1 - this.field_71109_bG) * 0.4F;
/*  450 */     this.field_70726_aT += (f2 - this.field_70726_aT) * 0.8F;
/*      */     
/*  452 */     if (func_110143_aJ() > 0.0F) {
/*  453 */       AxisAlignedBB axisAlignedBB = null;
/*  454 */       if (this.field_70154_o != null && !this.field_70154_o.field_70128_L) {
/*      */ 
/*      */         
/*  457 */         axisAlignedBB = this.field_70121_D.func_111270_a(this.field_70154_o.field_70121_D).func_72314_b(1.0D, 0.0D, 1.0D);
/*      */       } else {
/*  459 */         axisAlignedBB = this.field_70121_D.func_72314_b(1.0D, 0.5D, 1.0D);
/*      */       } 
/*      */       
/*  462 */       List<Entity> list = this.field_70170_p.func_72839_b((Entity)this, axisAlignedBB);
/*  463 */       if (list != null) {
/*  464 */         for (byte b = 0; b < list.size(); b++) {
/*  465 */           Entity entity = list.get(b);
/*  466 */           if (!entity.field_70128_L) {
/*  467 */             func_71044_o(entity);
/*      */           }
/*      */         } 
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   private void func_71044_o(Entity p_71044_1_) {
/*  475 */     p_71044_1_.func_70100_b_(this);
/*      */   }
/*      */   
/*      */   public int func_71037_bA() {
/*  479 */     return this.field_70180_af.func_75679_c(18);
/*      */   }
/*      */   
/*      */   public void func_85040_s(int p_85040_1_) {
/*  483 */     this.field_70180_af.func_75692_b(18, Integer.valueOf(p_85040_1_));
/*      */   }
/*      */   
/*      */   public void func_85039_t(int p_85039_1_) {
/*  487 */     int i = func_71037_bA();
/*  488 */     this.field_70180_af.func_75692_b(18, Integer.valueOf(i + p_85039_1_));
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_70645_a(DamageSource p_70645_1_) {
/*  493 */     super.func_70645_a(p_70645_1_);
/*  494 */     func_70105_a(0.2F, 0.2F);
/*  495 */     func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*  496 */     this.field_70181_x = 0.10000000149011612D;
/*      */     
/*  498 */     if (func_70005_c_().equals("Notch")) {
/*  499 */       func_146097_a(new ItemStack(Items.field_151034_e, 1), true, false);
/*      */     }
/*  501 */     if (!this.field_70170_p.func_82736_K().func_82766_b("keepInventory")) {
/*  502 */       this.field_71071_by.func_70436_m();
/*      */     }
/*      */     
/*  505 */     if (p_70645_1_ != null) {
/*  506 */       this.field_70159_w = (-MathHelper.func_76134_b((this.field_70739_aP + this.field_70177_z) * 3.1415927F / 180.0F) * 0.1F);
/*  507 */       this.field_70179_y = (-MathHelper.func_76126_a((this.field_70739_aP + this.field_70177_z) * 3.1415927F / 180.0F) * 0.1F);
/*      */     } else {
/*  509 */       this.field_70159_w = this.field_70179_y = 0.0D;
/*      */     } 
/*  511 */     this.field_70129_M = 0.1F;
/*      */     
/*  513 */     func_71064_a(StatList.field_75960_y, 1);
/*      */   }
/*      */ 
/*      */   
/*      */   protected String func_70621_aR() {
/*  518 */     return "game.player.hurt";
/*      */   }
/*      */ 
/*      */   
/*      */   protected String func_70673_aS() {
/*  523 */     return "game.player.die";
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_70084_c(Entity p_70084_1_, int p_70084_2_) {
/*  528 */     func_85039_t(p_70084_2_);
/*  529 */     Collection collection = func_96123_co().func_96520_a(IScoreObjectiveCriteria.field_96640_e);
/*      */     
/*  531 */     if (p_70084_1_ instanceof EntityPlayer) {
/*  532 */       func_71064_a(StatList.field_75932_A, 1);
/*  533 */       collection.addAll(func_96123_co().func_96520_a(IScoreObjectiveCriteria.field_96639_d));
/*      */     } else {
/*  535 */       func_71064_a(StatList.field_75959_z, 1);
/*      */     } 
/*      */     
/*  538 */     for (ScoreObjective scoreObjective : collection) {
/*  539 */       Score score = func_96123_co().func_96529_a(func_70005_c_(), scoreObjective);
/*  540 */       score.func_96648_a();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public EntityItem func_71040_bB(boolean p_71040_1_) {
/*  554 */     return func_146097_a(this.field_71071_by.func_70298_a(this.field_71071_by.field_70461_c, (p_71040_1_ && this.field_71071_by.func_70448_g() != null) ? (this.field_71071_by.func_70448_g()).field_77994_a : 1), false, true);
/*      */   }
/*      */   
/*      */   public EntityItem func_71019_a(ItemStack p_71019_1_, boolean p_71019_2_) {
/*  558 */     return func_146097_a(p_71019_1_, false, false);
/*      */   }
/*      */   
/*      */   public EntityItem func_146097_a(ItemStack p_146097_1_, boolean p_146097_2_, boolean p_146097_3_) {
/*  562 */     if (p_146097_1_ == null) return null; 
/*  563 */     if (p_146097_1_.field_77994_a == 0) return null;
/*      */     
/*  565 */     EntityItem entityItem = new EntityItem(this.field_70170_p, this.field_70165_t, this.field_70163_u - 0.30000001192092896D + func_70047_e(), this.field_70161_v, p_146097_1_);
/*  566 */     entityItem.field_145804_b = 40;
/*      */     
/*  568 */     if (p_146097_3_) {
/*  569 */       entityItem.func_145799_b(func_70005_c_());
/*      */     }
/*      */     
/*  572 */     float f = 0.1F;
/*  573 */     if (p_146097_2_) {
/*  574 */       float f1 = this.field_70146_Z.nextFloat() * 0.5F;
/*  575 */       float f2 = this.field_70146_Z.nextFloat() * 3.1415927F * 2.0F;
/*  576 */       entityItem.field_70159_w = (-MathHelper.func_76126_a(f2) * f1);
/*  577 */       entityItem.field_70179_y = (MathHelper.func_76134_b(f2) * f1);
/*  578 */       entityItem.field_70181_x = 0.20000000298023224D;
/*      */     } else {
/*      */       
/*  581 */       f = 0.3F;
/*  582 */       entityItem.field_70159_w = (-MathHelper.func_76126_a(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F) * f);
/*  583 */       entityItem.field_70179_y = (MathHelper.func_76134_b(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F) * f);
/*  584 */       entityItem.field_70181_x = (-MathHelper.func_76126_a(this.field_70125_A / 180.0F * 3.1415927F) * f + 0.1F);
/*  585 */       f = 0.02F;
/*      */       
/*  587 */       float f1 = this.field_70146_Z.nextFloat() * 3.1415927F * 2.0F;
/*  588 */       f *= this.field_70146_Z.nextFloat();
/*  589 */       entityItem.field_70159_w += Math.cos(f1) * f;
/*  590 */       entityItem.field_70181_x += ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.1F);
/*  591 */       entityItem.field_70179_y += Math.sin(f1) * f;
/*      */     } 
/*      */     
/*  594 */     func_71012_a(entityItem);
/*  595 */     func_71064_a(StatList.field_75952_v, 1);
/*      */     
/*  597 */     return entityItem;
/*      */   }
/*      */   
/*      */   public void func_71012_a(EntityItem p_71012_1_) {
/*  601 */     this.field_70170_p.func_72838_d((Entity)p_71012_1_);
/*      */   }
/*      */   
/*      */   public float func_146096_a(Block p_146096_1_, boolean p_146096_2_) {
/*  605 */     float f = this.field_71071_by.func_146023_a(p_146096_1_);
/*  606 */     if (f > 1.0F) {
/*  607 */       int i = EnchantmentHelper.func_77509_b(this);
/*  608 */       ItemStack itemStack = this.field_71071_by.func_70448_g();
/*      */       
/*  610 */       if (i > 0 && itemStack != null) {
/*  611 */         float f1 = (i * i + 1);
/*      */         
/*  613 */         if (itemStack.func_150998_b(p_146096_1_) || f > 1.0F) {
/*  614 */           f += f1;
/*      */         } else {
/*  616 */           f += f1 * 0.08F;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  621 */     if (func_70644_a(Potion.field_76422_e)) {
/*  622 */       f *= 1.0F + (func_70660_b(Potion.field_76422_e).func_76458_c() + 1) * 0.2F;
/*      */     }
/*  624 */     if (func_70644_a(Potion.field_76419_f)) {
/*  625 */       f *= 1.0F - (func_70660_b(Potion.field_76419_f).func_76458_c() + 1) * 0.2F;
/*      */     }
/*      */     
/*  628 */     if (func_70055_a(Material.field_151586_h) && !EnchantmentHelper.func_77510_g(this)) f /= 5.0F; 
/*  629 */     if (!this.field_70122_E) f /= 5.0F;
/*      */     
/*  631 */     return f;
/*      */   }
/*      */   
/*      */   public boolean func_146099_a(Block p_146099_1_) {
/*  635 */     return this.field_71071_by.func_146025_b(p_146099_1_);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_70037_a(NBTTagCompound p_70037_1_) {
/*  641 */     super.func_70037_a(p_70037_1_);
/*  642 */     this.field_96093_i = func_146094_a(this.field_146106_i);
/*  643 */     NBTTagList nBTTagList = p_70037_1_.func_150295_c("Inventory", 10);
/*  644 */     this.field_71071_by.func_70443_b(nBTTagList);
/*  645 */     this.field_71071_by.field_70461_c = p_70037_1_.func_74762_e("SelectedItemSlot");
/*  646 */     this.field_71083_bS = p_70037_1_.func_74767_n("Sleeping");
/*  647 */     this.field_71076_b = p_70037_1_.func_74765_d("SleepTimer");
/*      */     
/*  649 */     this.field_71106_cc = p_70037_1_.func_74760_g("XpP");
/*  650 */     this.field_71068_ca = p_70037_1_.func_74762_e("XpLevel");
/*  651 */     this.field_71067_cb = p_70037_1_.func_74762_e("XpTotal");
/*  652 */     func_85040_s(p_70037_1_.func_74762_e("Score"));
/*      */     
/*  654 */     if (this.field_71083_bS) {
/*  655 */       this.field_71081_bT = new ChunkCoordinates(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v));
/*  656 */       func_70999_a(true, true, false);
/*      */     } 
/*      */     
/*  659 */     if (p_70037_1_.func_150297_b("SpawnX", 99) && p_70037_1_.func_150297_b("SpawnY", 99) && p_70037_1_.func_150297_b("SpawnZ", 99)) {
/*  660 */       this.field_71077_c = new ChunkCoordinates(p_70037_1_.func_74762_e("SpawnX"), p_70037_1_.func_74762_e("SpawnY"), p_70037_1_.func_74762_e("SpawnZ"));
/*  661 */       this.field_82248_d = p_70037_1_.func_74767_n("SpawnForced");
/*      */     } 
/*      */     
/*  664 */     this.field_71100_bB.func_75112_a(p_70037_1_);
/*  665 */     this.field_71075_bZ.func_75095_b(p_70037_1_);
/*      */     
/*  667 */     if (p_70037_1_.func_150297_b("EnderItems", 9)) {
/*  668 */       NBTTagList nBTTagList1 = p_70037_1_.func_150295_c("EnderItems", 10);
/*  669 */       this.field_71078_a.func_70486_a(nBTTagList1);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_70014_b(NBTTagCompound p_70014_1_) {
/*  675 */     super.func_70014_b(p_70014_1_);
/*  676 */     p_70014_1_.func_74782_a("Inventory", (NBTBase)this.field_71071_by.func_70442_a(new NBTTagList()));
/*  677 */     p_70014_1_.func_74768_a("SelectedItemSlot", this.field_71071_by.field_70461_c);
/*  678 */     p_70014_1_.func_74757_a("Sleeping", this.field_71083_bS);
/*  679 */     p_70014_1_.func_74777_a("SleepTimer", (short)this.field_71076_b);
/*  680 */     p_70014_1_.func_74776_a("XpP", this.field_71106_cc);
/*  681 */     p_70014_1_.func_74768_a("XpLevel", this.field_71068_ca);
/*  682 */     p_70014_1_.func_74768_a("XpTotal", this.field_71067_cb);
/*  683 */     p_70014_1_.func_74768_a("Score", func_71037_bA());
/*      */     
/*  685 */     if (this.field_71077_c != null) {
/*  686 */       p_70014_1_.func_74768_a("SpawnX", this.field_71077_c.field_71574_a);
/*  687 */       p_70014_1_.func_74768_a("SpawnY", this.field_71077_c.field_71572_b);
/*  688 */       p_70014_1_.func_74768_a("SpawnZ", this.field_71077_c.field_71573_c);
/*  689 */       p_70014_1_.func_74757_a("SpawnForced", this.field_82248_d);
/*      */     } 
/*      */     
/*  692 */     this.field_71100_bB.func_75117_b(p_70014_1_);
/*  693 */     this.field_71075_bZ.func_75091_a(p_70014_1_);
/*  694 */     p_70014_1_.func_74782_a("EnderItems", (NBTBase)this.field_71078_a.func_70487_g());
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_71007_a(IInventory p_71007_1_) {}
/*      */ 
/*      */   
/*      */   public void func_146093_a(TileEntityHopper p_146093_1_) {}
/*      */ 
/*      */   
/*      */   public void func_96125_a(EntityMinecartHopper p_96125_1_) {}
/*      */ 
/*      */   
/*      */   public void func_110298_a(EntityHorse p_110298_1_, IInventory p_110298_2_) {}
/*      */ 
/*      */   
/*      */   public void func_71002_c(int p_71002_1_, int p_71002_2_, int p_71002_3_, String p_71002_4_) {}
/*      */ 
/*      */   
/*      */   public void func_82244_d(int p_82244_1_, int p_82244_2_, int p_82244_3_) {}
/*      */ 
/*      */   
/*      */   public void func_71058_b(int p_71058_1_, int p_71058_2_, int p_71058_3_) {}
/*      */ 
/*      */   
/*      */   public float func_70047_e() {
/*  720 */     return 0.12F;
/*      */   }
/*      */   
/*      */   protected void func_71061_d_() {
/*  724 */     this.field_70129_M = 1.62F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean func_70097_a(DamageSource p_70097_1_, float p_70097_2_) {
/*  731 */     if (func_85032_ar()) return false; 
/*  732 */     if (this.field_71075_bZ.field_75102_a && !p_70097_1_.func_76357_e()) return false;
/*      */     
/*  734 */     this.field_70708_bq = 0;
/*  735 */     if (func_110143_aJ() <= 0.0F) return false;
/*      */     
/*  737 */     if (func_70608_bn() && !this.field_70170_p.field_72995_K) {
/*  738 */       func_70999_a(true, true, false);
/*      */     }
/*      */     
/*  741 */     if (p_70097_1_.func_76350_n()) {
/*  742 */       if (this.field_70170_p.field_73013_u == EnumDifficulty.PEACEFUL) p_70097_2_ = 0.0F; 
/*  743 */       if (this.field_70170_p.field_73013_u == EnumDifficulty.EASY) p_70097_2_ = p_70097_2_ / 2.0F + 1.0F; 
/*  744 */       if (this.field_70170_p.field_73013_u == EnumDifficulty.HARD) p_70097_2_ = p_70097_2_ * 3.0F / 2.0F;
/*      */     
/*      */     } 
/*  747 */     if (p_70097_2_ == 0.0F) return false;
/*      */     
/*  749 */     Entity entity = p_70097_1_.func_76346_g();
/*  750 */     if (entity instanceof EntityArrow && 
/*  751 */       ((EntityArrow)entity).field_70250_c != null) {
/*  752 */       entity = ((EntityArrow)entity).field_70250_c;
/*      */     }
/*      */ 
/*      */     
/*  756 */     func_71064_a(StatList.field_75961_x, Math.round(p_70097_2_ * 10.0F));
/*      */     
/*  758 */     return super.func_70097_a(p_70097_1_, p_70097_2_);
/*      */   }
/*      */   
/*      */   public boolean func_96122_a(EntityPlayer p_96122_1_) {
/*  762 */     Team team1 = func_96124_cp();
/*  763 */     Team team2 = p_96122_1_.func_96124_cp();
/*      */     
/*  765 */     if (team1 == null) {
/*  766 */       return true;
/*      */     }
/*  768 */     if (!team1.func_142054_a(team2)) {
/*  769 */       return true;
/*      */     }
/*  771 */     return team1.func_96665_g();
/*      */   }
/*      */ 
/*      */   
/*      */   protected void func_70675_k(float p_70675_1_) {
/*  776 */     this.field_71071_by.func_70449_g(p_70675_1_);
/*      */   }
/*      */ 
/*      */   
/*      */   public int func_70658_aO() {
/*  781 */     return this.field_71071_by.func_70430_l();
/*      */   }
/*      */   
/*      */   public float func_82243_bO() {
/*  785 */     byte b = 0;
/*  786 */     for (ItemStack itemStack : this.field_71071_by.field_70460_b) {
/*  787 */       if (itemStack != null) {
/*  788 */         b++;
/*      */       }
/*      */     } 
/*  791 */     return b / this.field_71071_by.field_70460_b.length;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void func_70665_d(DamageSource p_70665_1_, float p_70665_2_) {
/*  796 */     if (func_85032_ar())
/*  797 */       return;  if (!p_70665_1_.func_76363_c() && func_70632_aY() && p_70665_2_ > 0.0F) {
/*  798 */       p_70665_2_ = (1.0F + p_70665_2_) * 0.5F;
/*      */     }
/*  800 */     p_70665_2_ = func_70655_b(p_70665_1_, p_70665_2_);
/*  801 */     p_70665_2_ = func_70672_c(p_70665_1_, p_70665_2_);
/*      */     
/*  803 */     float f1 = p_70665_2_;
/*  804 */     p_70665_2_ = Math.max(p_70665_2_ - func_110139_bj(), 0.0F);
/*  805 */     func_110149_m(func_110139_bj() - f1 - p_70665_2_);
/*  806 */     if (p_70665_2_ == 0.0F)
/*      */       return; 
/*  808 */     func_71020_j(p_70665_1_.func_76345_d());
/*  809 */     float f2 = func_110143_aJ();
/*  810 */     func_70606_j(func_110143_aJ() - p_70665_2_);
/*  811 */     func_110142_aN().func_94547_a(p_70665_1_, f2, p_70665_2_);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_146101_a(TileEntityFurnace p_146101_1_) {}
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_146102_a(TileEntityDispenser p_146102_1_) {}
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_146100_a(TileEntity p_146100_1_) {}
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_146095_a(CommandBlockLogic p_146095_1_) {}
/*      */ 
/*      */   
/*      */   public void func_146098_a(TileEntityBrewingStand p_146098_1_) {}
/*      */ 
/*      */   
/*      */   public void func_146104_a(TileEntityBeacon p_146104_1_) {}
/*      */ 
/*      */   
/*      */   public void func_71030_a(IMerchant p_71030_1_, String p_71030_2_) {}
/*      */ 
/*      */   
/*      */   public void func_71048_c(ItemStack p_71048_1_) {}
/*      */ 
/*      */   
/*      */   public boolean func_70998_m(Entity p_70998_1_) {
/*  844 */     ItemStack itemStack1 = func_71045_bC();
/*  845 */     ItemStack itemStack2 = (itemStack1 != null) ? itemStack1.func_77946_l() : null;
/*  846 */     if (p_70998_1_.func_130002_c(this)) {
/*      */ 
/*      */ 
/*      */       
/*  850 */       if (itemStack1 != null && itemStack1 == func_71045_bC()) {
/*  851 */         if (itemStack1.field_77994_a <= 0 && !this.field_71075_bZ.field_75098_d) {
/*  852 */           func_71028_bD();
/*  853 */         } else if (itemStack1.field_77994_a < itemStack2.field_77994_a && this.field_71075_bZ.field_75098_d) {
/*  854 */           itemStack1.field_77994_a = itemStack2.field_77994_a;
/*      */         } 
/*      */       }
/*  857 */       return true;
/*      */     } 
/*      */     
/*  860 */     if (itemStack1 != null && p_70998_1_ instanceof EntityLivingBase) {
/*      */ 
/*      */       
/*  863 */       if (this.field_71075_bZ.field_75098_d) itemStack1 = itemStack2; 
/*  864 */       if (itemStack1.func_111282_a(this, (EntityLivingBase)p_70998_1_)) {
/*      */ 
/*      */         
/*  867 */         if (itemStack1.field_77994_a <= 0 && !this.field_71075_bZ.field_75098_d) {
/*  868 */           func_71028_bD();
/*      */         }
/*  870 */         return true;
/*      */       } 
/*      */     } 
/*  873 */     return false;
/*      */   }
/*      */   
/*      */   public ItemStack func_71045_bC() {
/*  877 */     return this.field_71071_by.func_70448_g();
/*      */   }
/*      */   
/*      */   public void func_71028_bD() {
/*  881 */     this.field_71071_by.func_70299_a(this.field_71071_by.field_70461_c, null);
/*      */   }
/*      */ 
/*      */   
/*      */   public double func_70033_W() {
/*  886 */     return (this.field_70129_M - 0.5F);
/*      */   }
/*      */   
/*      */   public void func_71059_n(Entity p_71059_1_) {
/*  890 */     if (!p_71059_1_.func_70075_an()) {
/*      */       return;
/*      */     }
/*  893 */     if (p_71059_1_.func_85031_j((Entity)this)) {
/*      */       return;
/*      */     }
/*      */     
/*  897 */     float f1 = (float)func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e();
/*      */     
/*  899 */     int i = 0;
/*  900 */     float f2 = 0.0F;
/*  901 */     if (p_71059_1_ instanceof EntityLivingBase) {
/*  902 */       f2 = EnchantmentHelper.func_77512_a(this, (EntityLivingBase)p_71059_1_);
/*  903 */       i += EnchantmentHelper.func_77507_b(this, (EntityLivingBase)p_71059_1_);
/*      */     } 
/*  905 */     if (func_70051_ag()) {
/*  906 */       i++;
/*      */     }
/*      */     
/*  909 */     if (f1 > 0.0F || f2 > 0.0F) {
/*      */       
/*  911 */       boolean bool1 = (this.field_70143_R > 0.0F && !this.field_70122_E && !func_70617_f_() && !func_70090_H() && !func_70644_a(Potion.field_76440_q) && this.field_70154_o == null && p_71059_1_ instanceof EntityLivingBase) ? true : false;
/*  912 */       if (bool1 && f1 > 0.0F) {
/*  913 */         f1 *= 1.5F;
/*      */       }
/*  915 */       f1 += f2;
/*      */ 
/*      */ 
/*      */       
/*  919 */       boolean bool2 = false;
/*  920 */       int j = EnchantmentHelper.func_90036_a(this);
/*  921 */       if (p_71059_1_ instanceof EntityLivingBase && j > 0 && !p_71059_1_.func_70027_ad()) {
/*  922 */         bool2 = true;
/*  923 */         p_71059_1_.func_70015_d(1);
/*      */       } 
/*      */       
/*  926 */       boolean bool = p_71059_1_.func_70097_a(DamageSource.func_76365_a(this), f1);
/*  927 */       if (bool) {
/*  928 */         EntityLivingBase entityLivingBase; if (i > 0) {
/*  929 */           p_71059_1_.func_70024_g((-MathHelper.func_76126_a(this.field_70177_z * 3.1415927F / 180.0F) * i * 0.5F), 0.1D, (MathHelper.func_76134_b(this.field_70177_z * 3.1415927F / 180.0F) * i * 0.5F));
/*  930 */           this.field_70159_w *= 0.6D;
/*  931 */           this.field_70179_y *= 0.6D;
/*  932 */           func_70031_b(false);
/*      */         } 
/*      */         
/*  935 */         if (bool1) {
/*  936 */           func_71009_b(p_71059_1_);
/*      */         }
/*  938 */         if (f2 > 0.0F) {
/*  939 */           func_71047_c(p_71059_1_);
/*      */         }
/*      */         
/*  942 */         if (f1 >= 18.0F) {
/*  943 */           func_71029_a((StatBase)AchievementList.field_75999_E);
/*      */         }
/*  945 */         func_130011_c(p_71059_1_);
/*      */         
/*  947 */         if (p_71059_1_ instanceof EntityLivingBase) EnchantmentHelper.func_151384_a((EntityLivingBase)p_71059_1_, (Entity)this); 
/*  948 */         EnchantmentHelper.func_151385_b(this, p_71059_1_);
/*      */         
/*  950 */         ItemStack itemStack = func_71045_bC();
/*  951 */         Entity entity = p_71059_1_;
/*  952 */         if (p_71059_1_ instanceof EntityDragonPart) {
/*  953 */           IEntityMultiPart iEntityMultiPart = ((EntityDragonPart)p_71059_1_).field_70259_a;
/*  954 */           if (iEntityMultiPart != null && iEntityMultiPart instanceof EntityLivingBase) {
/*  955 */             entityLivingBase = (EntityLivingBase)iEntityMultiPart;
/*      */           }
/*      */         } 
/*  958 */         if (itemStack != null && entityLivingBase instanceof EntityLivingBase) {
/*  959 */           itemStack.func_77961_a(entityLivingBase, this);
/*  960 */           if (itemStack.field_77994_a <= 0) {
/*  961 */             func_71028_bD();
/*      */           }
/*      */         } 
/*  964 */         if (p_71059_1_ instanceof EntityLivingBase) {
/*  965 */           func_71064_a(StatList.field_75951_w, Math.round(f1 * 10.0F));
/*      */           
/*  967 */           if (j > 0) {
/*  968 */             p_71059_1_.func_70015_d(j * 4);
/*      */           }
/*      */         } 
/*      */         
/*  972 */         func_71020_j(0.3F);
/*      */ 
/*      */ 
/*      */       
/*      */       }
/*  977 */       else if (bool2) {
/*  978 */         p_71059_1_.func_70066_B();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_71009_b(Entity p_71009_1_) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_71047_c(Entity p_71047_1_) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public void func_71004_bE() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_70106_y() {
/* 1010 */     super.func_70106_y();
/* 1011 */     this.field_71069_bz.func_75134_a(this);
/* 1012 */     if (this.field_71070_bA != null) {
/* 1013 */       this.field_71070_bA.func_75134_a(this);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean func_70094_T() {
/* 1019 */     return (!this.field_71083_bS && super.func_70094_T());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public GameProfile func_146103_bH() {
/* 1027 */     return this.field_146106_i;
/*      */   }
/*      */   
/*      */   public enum EnumStatus {
/* 1031 */     OK, NOT_POSSIBLE_HERE, NOT_POSSIBLE_NOW, TOO_FAR_AWAY, OTHER_PROBLEM, NOT_SAFE;
/*      */     private static final String __OBFID = "CL_00001712"; }
/*      */   
/*      */   public EnumStatus func_71018_a(int p_71018_1_, int p_71018_2_, int p_71018_3_) {
/* 1035 */     if (!this.field_70170_p.field_72995_K) {
/* 1036 */       if (func_70608_bn() || !func_70089_S()) {
/* 1037 */         return EnumStatus.OTHER_PROBLEM;
/*      */       }
/*      */       
/* 1040 */       if (!this.field_70170_p.field_73011_w.func_76569_d())
/*      */       {
/* 1042 */         return EnumStatus.NOT_POSSIBLE_HERE;
/*      */       }
/* 1044 */       if (this.field_70170_p.func_72935_r())
/*      */       {
/* 1046 */         return EnumStatus.NOT_POSSIBLE_NOW;
/*      */       }
/* 1048 */       if (Math.abs(this.field_70165_t - p_71018_1_) > 3.0D || Math.abs(this.field_70163_u - p_71018_2_) > 2.0D || Math.abs(this.field_70161_v - p_71018_3_) > 3.0D)
/*      */       {
/* 1050 */         return EnumStatus.TOO_FAR_AWAY;
/*      */       }
/*      */       
/* 1053 */       double d1 = 8.0D;
/* 1054 */       double d2 = 5.0D;
/* 1055 */       List list = this.field_70170_p.func_72872_a(EntityMob.class, AxisAlignedBB.func_72330_a(p_71018_1_ - d1, p_71018_2_ - d2, p_71018_3_ - d1, p_71018_1_ + d1, p_71018_2_ + d2, p_71018_3_ + d1));
/* 1056 */       if (!list.isEmpty()) {
/* 1057 */         return EnumStatus.NOT_SAFE;
/*      */       }
/*      */     } 
/*      */     
/* 1061 */     if (func_70115_ae()) {
/* 1062 */       func_70078_a((Entity)null);
/*      */     }
/*      */     
/* 1065 */     func_70105_a(0.2F, 0.2F);
/* 1066 */     this.field_70129_M = 0.2F;
/* 1067 */     if (this.field_70170_p.func_72899_e(p_71018_1_, p_71018_2_, p_71018_3_)) {
/*      */       
/* 1069 */       int i = this.field_70170_p.func_72805_g(p_71018_1_, p_71018_2_, p_71018_3_);
/* 1070 */       int j = BlockBed.func_149895_l(i);
/* 1071 */       float f1 = 0.5F, f2 = 0.5F;
/*      */       
/* 1073 */       switch (j) {
/*      */         case 0:
/* 1075 */           f2 = 0.9F;
/*      */           break;
/*      */         case 2:
/* 1078 */           f2 = 0.1F;
/*      */           break;
/*      */         case 1:
/* 1081 */           f1 = 0.1F;
/*      */           break;
/*      */         case 3:
/* 1084 */           f1 = 0.9F;
/*      */           break;
/*      */       } 
/* 1087 */       func_71013_b(j);
/* 1088 */       func_70107_b((p_71018_1_ + f1), (p_71018_2_ + 0.9375F), (p_71018_3_ + f2));
/*      */     } else {
/* 1090 */       func_70107_b((p_71018_1_ + 0.5F), (p_71018_2_ + 0.9375F), (p_71018_3_ + 0.5F));
/*      */     } 
/* 1092 */     this.field_71083_bS = true;
/* 1093 */     this.field_71076_b = 0;
/* 1094 */     this.field_71081_bT = new ChunkCoordinates(p_71018_1_, p_71018_2_, p_71018_3_);
/* 1095 */     this.field_70159_w = this.field_70179_y = this.field_70181_x = 0.0D;
/*      */     
/* 1097 */     if (!this.field_70170_p.field_72995_K) {
/* 1098 */       this.field_70170_p.func_72854_c();
/*      */     }
/*      */     
/* 1101 */     return EnumStatus.OK;
/*      */   }
/*      */ 
/*      */   
/*      */   private void func_71013_b(int p_71013_1_) {
/* 1106 */     this.field_71079_bU = 0.0F;
/* 1107 */     this.field_71089_bV = 0.0F;
/*      */     
/* 1109 */     switch (p_71013_1_) {
/*      */       case 0:
/* 1111 */         this.field_71089_bV = -1.8F;
/*      */         break;
/*      */       case 2:
/* 1114 */         this.field_71089_bV = 1.8F;
/*      */         break;
/*      */       case 1:
/* 1117 */         this.field_71079_bU = 1.8F;
/*      */         break;
/*      */       case 3:
/* 1120 */         this.field_71079_bU = -1.8F;
/*      */         break;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_70999_a(boolean p_70999_1_, boolean p_70999_2_, boolean p_70999_3_) {
/* 1138 */     func_70105_a(0.6F, 1.8F);
/* 1139 */     func_71061_d_();
/*      */     
/* 1141 */     ChunkCoordinates chunkCoordinates1 = this.field_71081_bT;
/* 1142 */     ChunkCoordinates chunkCoordinates2 = this.field_71081_bT;
/* 1143 */     if (chunkCoordinates1 != null && this.field_70170_p.func_147439_a(chunkCoordinates1.field_71574_a, chunkCoordinates1.field_71572_b, chunkCoordinates1.field_71573_c) == Blocks.field_150324_C) {
/* 1144 */       BlockBed.func_149979_a(this.field_70170_p, chunkCoordinates1.field_71574_a, chunkCoordinates1.field_71572_b, chunkCoordinates1.field_71573_c, false);
/*      */       
/* 1146 */       chunkCoordinates2 = BlockBed.func_149977_a(this.field_70170_p, chunkCoordinates1.field_71574_a, chunkCoordinates1.field_71572_b, chunkCoordinates1.field_71573_c, 0);
/* 1147 */       if (chunkCoordinates2 == null) {
/* 1148 */         chunkCoordinates2 = new ChunkCoordinates(chunkCoordinates1.field_71574_a, chunkCoordinates1.field_71572_b + 1, chunkCoordinates1.field_71573_c);
/*      */       }
/* 1150 */       func_70107_b((chunkCoordinates2.field_71574_a + 0.5F), (chunkCoordinates2.field_71572_b + this.field_70129_M + 0.1F), (chunkCoordinates2.field_71573_c + 0.5F));
/*      */     } 
/*      */     
/* 1153 */     this.field_71083_bS = false;
/* 1154 */     if (!this.field_70170_p.field_72995_K && p_70999_2_) {
/* 1155 */       this.field_70170_p.func_72854_c();
/*      */     }
/* 1157 */     if (p_70999_1_) {
/* 1158 */       this.field_71076_b = 0;
/*      */     } else {
/* 1160 */       this.field_71076_b = 100;
/*      */     } 
/* 1162 */     if (p_70999_3_) {
/* 1163 */       func_71063_a(this.field_71081_bT, false);
/*      */     }
/*      */   }
/*      */   
/*      */   private boolean func_71065_l() {
/* 1168 */     return (this.field_70170_p.func_147439_a(this.field_71081_bT.field_71574_a, this.field_71081_bT.field_71572_b, this.field_71081_bT.field_71573_c) == Blocks.field_150324_C);
/*      */   }
/*      */ 
/*      */   
/*      */   public static ChunkCoordinates func_71056_a(World p_71056_0_, ChunkCoordinates p_71056_1_, boolean p_71056_2_) {
/* 1173 */     IChunkProvider iChunkProvider = p_71056_0_.func_72863_F();
/* 1174 */     iChunkProvider.func_73158_c(p_71056_1_.field_71574_a - 3 >> 4, p_71056_1_.field_71573_c - 3 >> 4);
/* 1175 */     iChunkProvider.func_73158_c(p_71056_1_.field_71574_a + 3 >> 4, p_71056_1_.field_71573_c - 3 >> 4);
/* 1176 */     iChunkProvider.func_73158_c(p_71056_1_.field_71574_a - 3 >> 4, p_71056_1_.field_71573_c + 3 >> 4);
/* 1177 */     iChunkProvider.func_73158_c(p_71056_1_.field_71574_a + 3 >> 4, p_71056_1_.field_71573_c + 3 >> 4);
/*      */ 
/*      */     
/* 1180 */     if (p_71056_0_.func_147439_a(p_71056_1_.field_71574_a, p_71056_1_.field_71572_b, p_71056_1_.field_71573_c) != Blocks.field_150324_C) {
/* 1181 */       Material material1 = p_71056_0_.func_147439_a(p_71056_1_.field_71574_a, p_71056_1_.field_71572_b, p_71056_1_.field_71573_c).func_149688_o();
/* 1182 */       Material material2 = p_71056_0_.func_147439_a(p_71056_1_.field_71574_a, p_71056_1_.field_71572_b + 1, p_71056_1_.field_71573_c).func_149688_o();
/* 1183 */       boolean bool1 = (!material1.func_76220_a() && !material1.func_76224_d()) ? true : false;
/* 1184 */       boolean bool2 = (!material2.func_76220_a() && !material2.func_76224_d()) ? true : false;
/*      */       
/* 1186 */       if (p_71056_2_ && bool1 && bool2) {
/* 1187 */         return p_71056_1_;
/*      */       }
/*      */       
/* 1190 */       return null;
/*      */     } 
/*      */ 
/*      */     
/* 1194 */     return BlockBed.func_149977_a(p_71056_0_, p_71056_1_.field_71574_a, p_71056_1_.field_71572_b, p_71056_1_.field_71573_c, 0);
/*      */   }
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public float func_71051_bG() {
/* 1199 */     if (this.field_71081_bT != null) {
/* 1200 */       int i = this.field_70170_p.func_72805_g(this.field_71081_bT.field_71574_a, this.field_71081_bT.field_71572_b, this.field_71081_bT.field_71573_c);
/* 1201 */       int j = BlockBed.func_149895_l(i);
/*      */       
/* 1203 */       switch (j) {
/*      */         case 0:
/* 1205 */           return 90.0F;
/*      */         case 1:
/* 1207 */           return 0.0F;
/*      */         case 2:
/* 1209 */           return 270.0F;
/*      */         case 3:
/* 1211 */           return 180.0F;
/*      */       } 
/*      */     } 
/* 1214 */     return 0.0F;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean func_70608_bn() {
/* 1219 */     return this.field_71083_bS;
/*      */   }
/*      */   
/*      */   public boolean func_71026_bH() {
/* 1223 */     return (this.field_71083_bS && this.field_71076_b >= 100);
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public int func_71060_bI() {
/* 1227 */     return this.field_71076_b;
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   protected boolean func_82241_s(int p_82241_1_) {
/* 1231 */     return ((this.field_70180_af.func_75683_a(16) & 1 << p_82241_1_) != 0);
/*      */   }
/*      */   
/*      */   protected void func_82239_b(int p_82239_1_, boolean p_82239_2_) {
/* 1235 */     byte b = this.field_70180_af.func_75683_a(16);
/* 1236 */     if (p_82239_2_) {
/* 1237 */       this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)(b | 1 << p_82239_1_)));
/*      */     } else {
/* 1239 */       this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)(b & (1 << p_82239_1_ ^ 0xFFFFFFFF))));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_146105_b(IChatComponent p_146105_1_) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ChunkCoordinates func_70997_bJ() {
/* 1254 */     return this.field_71077_c;
/*      */   }
/*      */   
/*      */   public boolean func_82245_bX() {
/* 1258 */     return this.field_82248_d;
/*      */   }
/*      */   
/*      */   public void func_71063_a(ChunkCoordinates p_71063_1_, boolean p_71063_2_) {
/* 1262 */     if (p_71063_1_ != null) {
/* 1263 */       this.field_71077_c = new ChunkCoordinates(p_71063_1_);
/* 1264 */       this.field_82248_d = p_71063_2_;
/*      */     } else {
/* 1266 */       this.field_71077_c = null;
/* 1267 */       this.field_82248_d = false;
/*      */     } 
/*      */   }
/*      */   
/*      */   public void func_71029_a(StatBase p_71029_1_) {
/* 1272 */     func_71064_a(p_71029_1_, 1);
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_71064_a(StatBase p_71064_1_, int p_71064_2_) {}
/*      */ 
/*      */   
/*      */   public void func_70664_aZ() {
/* 1280 */     super.func_70664_aZ();
/*      */     
/* 1282 */     func_71064_a(StatList.field_75953_u, 1);
/* 1283 */     if (func_70051_ag()) {
/* 1284 */       func_71020_j(0.8F);
/*      */     } else {
/* 1286 */       func_71020_j(0.2F);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_70612_e(float p_70612_1_, float p_70612_2_) {
/* 1292 */     double d1 = this.field_70165_t, d2 = this.field_70163_u, d3 = this.field_70161_v;
/*      */     
/* 1294 */     if (this.field_71075_bZ.field_75100_b && this.field_70154_o == null) {
/* 1295 */       double d = this.field_70181_x;
/* 1296 */       float f = this.field_70747_aH;
/* 1297 */       this.field_70747_aH = this.field_71075_bZ.func_75093_a();
/* 1298 */       super.func_70612_e(p_70612_1_, p_70612_2_);
/* 1299 */       this.field_70181_x = d * 0.6D;
/* 1300 */       this.field_70747_aH = f;
/*      */     } else {
/* 1302 */       super.func_70612_e(p_70612_1_, p_70612_2_);
/*      */     } 
/*      */     
/* 1305 */     func_71000_j(this.field_70165_t - d1, this.field_70163_u - d2, this.field_70161_v - d3);
/*      */   }
/*      */ 
/*      */   
/*      */   public float func_70689_ay() {
/* 1310 */     return (float)func_110148_a(SharedMonsterAttributes.field_111263_d).func_111126_e();
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_71000_j(double p_71000_1_, double p_71000_3_, double p_71000_5_) {
/* 1315 */     if (this.field_70154_o != null) {
/*      */       return;
/*      */     }
/* 1318 */     if (func_70055_a(Material.field_151586_h)) {
/* 1319 */       int i = Math.round(MathHelper.func_76133_a(p_71000_1_ * p_71000_1_ + p_71000_3_ * p_71000_3_ + p_71000_5_ * p_71000_5_) * 100.0F);
/* 1320 */       if (i > 0) {
/* 1321 */         func_71064_a(StatList.field_75957_q, i);
/* 1322 */         func_71020_j(0.015F * i * 0.01F);
/*      */       } 
/* 1324 */     } else if (func_70090_H()) {
/* 1325 */       int i = Math.round(MathHelper.func_76133_a(p_71000_1_ * p_71000_1_ + p_71000_5_ * p_71000_5_) * 100.0F);
/* 1326 */       if (i > 0) {
/* 1327 */         func_71064_a(StatList.field_75946_m, i);
/* 1328 */         func_71020_j(0.015F * i * 0.01F);
/*      */       } 
/* 1330 */     } else if (func_70617_f_()) {
/* 1331 */       if (p_71000_3_ > 0.0D) {
/* 1332 */         func_71064_a(StatList.field_75944_o, (int)Math.round(p_71000_3_ * 100.0D));
/*      */       }
/* 1334 */     } else if (this.field_70122_E) {
/* 1335 */       int i = Math.round(MathHelper.func_76133_a(p_71000_1_ * p_71000_1_ + p_71000_5_ * p_71000_5_) * 100.0F);
/* 1336 */       if (i > 0) {
/* 1337 */         func_71064_a(StatList.field_75945_l, i);
/* 1338 */         if (func_70051_ag()) {
/* 1339 */           func_71020_j(0.099999994F * i * 0.01F);
/*      */         } else {
/* 1341 */           func_71020_j(0.01F * i * 0.01F);
/*      */         } 
/*      */       } 
/*      */     } else {
/* 1345 */       int i = Math.round(MathHelper.func_76133_a(p_71000_1_ * p_71000_1_ + p_71000_5_ * p_71000_5_) * 100.0F);
/* 1346 */       if (i > 25) {
/* 1347 */         func_71064_a(StatList.field_75958_p, i);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   private void func_71015_k(double p_71015_1_, double p_71015_3_, double p_71015_5_) {
/* 1353 */     if (this.field_70154_o != null) {
/* 1354 */       int i = Math.round(MathHelper.func_76133_a(p_71015_1_ * p_71015_1_ + p_71015_3_ * p_71015_3_ + p_71015_5_ * p_71015_5_) * 100.0F);
/* 1355 */       if (i > 0) {
/* 1356 */         if (this.field_70154_o instanceof net.minecraft.entity.item.EntityMinecart) {
/* 1357 */           func_71064_a(StatList.field_75956_r, i);
/*      */           
/* 1359 */           if (this.field_71073_d == null) {
/* 1360 */             this.field_71073_d = new ChunkCoordinates(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v));
/* 1361 */           } else if (this.field_71073_d.func_71569_e(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v)) >= 1000000.0D) {
/* 1362 */             func_71064_a((StatBase)AchievementList.field_76025_q, 1);
/*      */           }
/*      */         
/* 1365 */         } else if (this.field_70154_o instanceof net.minecraft.entity.item.EntityBoat) {
/* 1366 */           func_71064_a(StatList.field_75955_s, i);
/* 1367 */         } else if (this.field_70154_o instanceof EntityPig) {
/* 1368 */           func_71064_a(StatList.field_75954_t, i);
/* 1369 */         } else if (this.field_70154_o instanceof EntityHorse) {
/* 1370 */           func_71064_a(StatList.field_151185_q, i);
/*      */         } 
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void func_70069_a(float p_70069_1_) {
/* 1378 */     if (this.field_71075_bZ.field_75101_c)
/*      */       return; 
/* 1380 */     if (p_70069_1_ >= 2.0F) {
/* 1381 */       func_71064_a(StatList.field_75943_n, (int)Math.round(p_70069_1_ * 100.0D));
/*      */     }
/* 1383 */     super.func_70069_a(p_70069_1_);
/*      */   }
/*      */ 
/*      */   
/*      */   protected String func_146067_o(int p_146067_1_) {
/* 1388 */     if (p_146067_1_ > 4) {
/* 1389 */       return "game.player.hurt.fall.big";
/*      */     }
/* 1391 */     return "game.player.hurt.fall.small";
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_70074_a(EntityLivingBase p_70074_1_) {
/* 1397 */     if (p_70074_1_ instanceof net.minecraft.entity.monster.IMob) {
/* 1398 */       func_71029_a((StatBase)AchievementList.field_76023_s);
/*      */     }
/*      */     
/* 1401 */     int i = EntityList.func_75619_a((Entity)p_70074_1_);
/* 1402 */     EntityList.EntityEggInfo entityEggInfo = (EntityList.EntityEggInfo)EntityList.field_75627_a.get(Integer.valueOf(i));
/* 1403 */     if (entityEggInfo != null) {
/* 1404 */       func_71064_a(entityEggInfo.field_151512_d, 1);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_70110_aj() {
/* 1410 */     if (!this.field_71075_bZ.field_75100_b) super.func_70110_aj(); 
/*      */   }
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public IIcon func_70620_b(ItemStack p_70620_1_, int p_70620_2_) {
/* 1415 */     IIcon iIcon = super.func_70620_b(p_70620_1_, p_70620_2_);
/* 1416 */     if (p_70620_1_.func_77973_b() == Items.field_151112_aM && this.field_71104_cf != null)
/* 1417 */     { iIcon = Items.field_151112_aM.func_94597_g(); }
/* 1418 */     else { if (p_70620_1_.func_77973_b().func_77623_v())
/* 1419 */         return p_70620_1_.func_77973_b().func_77618_c(p_70620_1_.func_77960_j(), p_70620_2_); 
/* 1420 */       if (this.field_71074_e != null && p_70620_1_.func_77973_b() == Items.field_151031_f) {
/* 1421 */         int i = p_70620_1_.func_77988_m() - this.field_71072_f;
/* 1422 */         if (i >= 18) {
/* 1423 */           return Items.field_151031_f.func_94599_c(2);
/*      */         }
/* 1425 */         if (i > 13) {
/* 1426 */           return Items.field_151031_f.func_94599_c(1);
/*      */         }
/* 1428 */         if (i > 0)
/* 1429 */           return Items.field_151031_f.func_94599_c(0); 
/*      */       }  }
/*      */     
/* 1432 */     return iIcon;
/*      */   }
/*      */ 
/*      */   
/*      */   public ItemStack func_82169_q(int p_82169_1_) {
/* 1437 */     return this.field_71071_by.func_70440_f(p_82169_1_);
/*      */   }
/*      */   
/*      */   public void func_71023_q(int p_71023_1_) {
/* 1441 */     func_85039_t(p_71023_1_);
/* 1442 */     int i = Integer.MAX_VALUE - this.field_71067_cb;
/* 1443 */     if (p_71023_1_ > i) {
/* 1444 */       p_71023_1_ = i;
/*      */     }
/*      */     
/* 1447 */     this.field_71106_cc += p_71023_1_ / func_71050_bK();
/* 1448 */     this.field_71067_cb += p_71023_1_;
/* 1449 */     while (this.field_71106_cc >= 1.0F) {
/* 1450 */       this.field_71106_cc = (this.field_71106_cc - 1.0F) * func_71050_bK();
/* 1451 */       func_82242_a(1);
/* 1452 */       this.field_71106_cc /= func_71050_bK();
/*      */     } 
/*      */   }
/*      */   
/*      */   public void func_82242_a(int p_82242_1_) {
/* 1457 */     this.field_71068_ca += p_82242_1_;
/* 1458 */     if (this.field_71068_ca < 0) {
/* 1459 */       this.field_71068_ca = 0;
/* 1460 */       this.field_71106_cc = 0.0F;
/* 1461 */       this.field_71067_cb = 0;
/*      */     } 
/*      */     
/* 1464 */     if (p_82242_1_ > 0 && this.field_71068_ca % 5 == 0 && this.field_82249_h < this.field_70173_aa - 100.0F) {
/* 1465 */       float f = (this.field_71068_ca > 30) ? 1.0F : (this.field_71068_ca / 30.0F);
/* 1466 */       this.field_70170_p.func_72956_a((Entity)this, "random.levelup", f * 0.75F, 1.0F);
/* 1467 */       this.field_82249_h = this.field_70173_aa;
/*      */     } 
/*      */   }
/*      */   
/*      */   public int func_71050_bK() {
/* 1472 */     if (this.field_71068_ca >= 30) {
/* 1473 */       return 62 + (this.field_71068_ca - 30) * 7;
/*      */     }
/* 1475 */     if (this.field_71068_ca >= 15) {
/* 1476 */       return 17 + (this.field_71068_ca - 15) * 3;
/*      */     }
/* 1478 */     return 17;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_71020_j(float p_71020_1_) {
/* 1491 */     if (this.field_71075_bZ.field_75102_a)
/*      */       return; 
/* 1493 */     if (!this.field_70170_p.field_72995_K) {
/* 1494 */       this.field_71100_bB.func_75113_a(p_71020_1_);
/*      */     }
/*      */   }
/*      */   
/*      */   public FoodStats func_71024_bL() {
/* 1499 */     return this.field_71100_bB;
/*      */   }
/*      */   
/*      */   public boolean func_71043_e(boolean p_71043_1_) {
/* 1503 */     return ((p_71043_1_ || this.field_71100_bB.func_75121_c()) && !this.field_71075_bZ.field_75102_a);
/*      */   }
/*      */   
/*      */   public boolean func_70996_bM() {
/* 1507 */     return (func_110143_aJ() > 0.0F && func_110143_aJ() < func_110138_aP());
/*      */   }
/*      */   
/*      */   public void func_71008_a(ItemStack p_71008_1_, int p_71008_2_) {
/* 1511 */     if (p_71008_1_ == this.field_71074_e)
/* 1512 */       return;  this.field_71074_e = p_71008_1_;
/* 1513 */     this.field_71072_f = p_71008_2_;
/* 1514 */     if (!this.field_70170_p.field_72995_K) {
/* 1515 */       func_70019_c(true);
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean func_82246_f(int p_82246_1_, int p_82246_2_, int p_82246_3_) {
/* 1520 */     if (this.field_71075_bZ.field_75099_e) {
/* 1521 */       return true;
/*      */     }
/* 1523 */     Block block = this.field_70170_p.func_147439_a(p_82246_1_, p_82246_2_, p_82246_3_);
/* 1524 */     if (block.func_149688_o() != Material.field_151579_a) {
/* 1525 */       if (block.func_149688_o().func_85157_q())
/* 1526 */         return true; 
/* 1527 */       if (func_71045_bC() != null) {
/* 1528 */         ItemStack itemStack = func_71045_bC();
/*      */         
/* 1530 */         if (itemStack.func_150998_b(block) || itemStack.func_150997_a(block) > 1.0F) {
/* 1531 */           return true;
/*      */         }
/*      */       } 
/*      */     } 
/* 1535 */     return false;
/*      */   }
/*      */   
/*      */   public boolean func_82247_a(int p_82247_1_, int p_82247_2_, int p_82247_3_, int p_82247_4_, ItemStack p_82247_5_) {
/* 1539 */     if (this.field_71075_bZ.field_75099_e) {
/* 1540 */       return true;
/*      */     }
/* 1542 */     if (p_82247_5_ != null) {
/* 1543 */       return p_82247_5_.func_82835_x();
/*      */     }
/* 1545 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   protected int func_70693_a(EntityPlayer p_70693_1_) {
/* 1550 */     if (this.field_70170_p.func_82736_K().func_82766_b("keepInventory")) return 0;
/*      */     
/* 1552 */     int i = this.field_71068_ca * 7;
/* 1553 */     if (i > 100) {
/* 1554 */       return 100;
/*      */     }
/* 1556 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean func_70684_aJ() {
/* 1562 */     return true;
/*      */   }
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public boolean func_94059_bO() {
/* 1567 */     return true;
/*      */   }
/*      */   
/*      */   public void func_71049_a(EntityPlayer p_71049_1_, boolean p_71049_2_) {
/* 1571 */     if (p_71049_2_) {
/* 1572 */       this.field_71071_by.func_70455_b(p_71049_1_.field_71071_by);
/*      */       
/* 1574 */       func_70606_j(p_71049_1_.func_110143_aJ());
/* 1575 */       this.field_71100_bB = p_71049_1_.field_71100_bB;
/*      */       
/* 1577 */       this.field_71068_ca = p_71049_1_.field_71068_ca;
/* 1578 */       this.field_71067_cb = p_71049_1_.field_71067_cb;
/* 1579 */       this.field_71106_cc = p_71049_1_.field_71106_cc;
/*      */       
/* 1581 */       func_85040_s(p_71049_1_.func_71037_bA());
/* 1582 */       this.field_82152_aq = p_71049_1_.field_82152_aq;
/* 1583 */     } else if (this.field_70170_p.func_82736_K().func_82766_b("keepInventory")) {
/* 1584 */       this.field_71071_by.func_70455_b(p_71049_1_.field_71071_by);
/*      */       
/* 1586 */       this.field_71068_ca = p_71049_1_.field_71068_ca;
/* 1587 */       this.field_71067_cb = p_71049_1_.field_71067_cb;
/* 1588 */       this.field_71106_cc = p_71049_1_.field_71106_cc;
/* 1589 */       func_85040_s(p_71049_1_.func_71037_bA());
/*      */     } 
/* 1591 */     this.field_71078_a = p_71049_1_.field_71078_a;
/*      */   }
/*      */ 
/*      */   
/*      */   protected boolean func_70041_e_() {
/* 1596 */     return !this.field_71075_bZ.field_75100_b;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_71016_p() {}
/*      */ 
/*      */   
/*      */   public void func_71033_a(WorldSettings.GameType p_71033_1_) {}
/*      */ 
/*      */   
/*      */   public String func_70005_c_() {
/* 1608 */     return this.field_146106_i.getName();
/*      */   }
/*      */ 
/*      */   
/*      */   public World func_130014_f_() {
/* 1613 */     return this.field_70170_p;
/*      */   }
/*      */   
/*      */   public InventoryEnderChest func_71005_bN() {
/* 1617 */     return this.field_71078_a;
/*      */   }
/*      */ 
/*      */   
/*      */   public ItemStack func_71124_b(int p_71124_1_) {
/* 1622 */     if (p_71124_1_ == 0) return this.field_71071_by.func_70448_g(); 
/* 1623 */     return this.field_71071_by.field_70460_b[p_71124_1_ - 1];
/*      */   }
/*      */ 
/*      */   
/*      */   public ItemStack func_70694_bm() {
/* 1628 */     return this.field_71071_by.func_70448_g();
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_70062_b(int p_70062_1_, ItemStack p_70062_2_) {
/* 1633 */     this.field_71071_by.field_70460_b[p_70062_1_] = p_70062_2_;
/*      */   }
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public boolean func_98034_c(EntityPlayer p_98034_1_) {
/* 1638 */     if (!func_82150_aj()) return false; 
/* 1639 */     Team team = func_96124_cp();
/*      */     
/* 1641 */     if (team != null && p_98034_1_ != null && p_98034_1_.func_96124_cp() == team && team.func_98297_h()) return false;
/*      */     
/* 1643 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public ItemStack[] func_70035_c() {
/* 1648 */     return this.field_71071_by.field_70460_b;
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public boolean func_82238_cc() {
/* 1652 */     return func_82241_s(1);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean func_96092_aw() {
/* 1657 */     return !this.field_71075_bZ.field_75100_b;
/*      */   }
/*      */ 
/*      */   
/*      */   public Scoreboard func_96123_co() {
/* 1662 */     return this.field_70170_p.func_96441_U();
/*      */   }
/*      */ 
/*      */   
/*      */   public Team func_96124_cp() {
/* 1667 */     return (Team)func_96123_co().func_96509_i(func_70005_c_());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public IChatComponent func_145748_c_() {
/* 1673 */     ChatComponentText chatComponentText = new ChatComponentText(ScorePlayerTeam.func_96667_a(func_96124_cp(), func_70005_c_()));
/* 1674 */     chatComponentText.func_150256_b().func_150241_a(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/msg " + func_70005_c_() + " "));
/* 1675 */     return (IChatComponent)chatComponentText;
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_110149_m(float p_110149_1_) {
/* 1680 */     if (p_110149_1_ < 0.0F) p_110149_1_ = 0.0F; 
/* 1681 */     func_70096_w().func_75692_b(17, Float.valueOf(p_110149_1_));
/*      */   }
/*      */ 
/*      */   
/*      */   public float func_110139_bj() {
/* 1686 */     return func_70096_w().func_111145_d(17);
/*      */   }
/*      */   
/*      */   public static UUID func_146094_a(GameProfile p_146094_0_) {
/* 1690 */     UUID uUID = p_146094_0_.getId();
/* 1691 */     if (uUID == null) {
/* 1692 */       uUID = UUID.nameUUIDFromBytes(("OfflinePlayer:" + p_146094_0_.getName()).getBytes(Charsets.UTF_8));
/*      */     }
/* 1694 */     return uUID;
/*      */   }
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\player\EntityPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */