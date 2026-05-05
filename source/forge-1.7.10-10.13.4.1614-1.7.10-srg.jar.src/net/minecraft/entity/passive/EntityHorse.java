/*      */ package net.minecraft.entity.passive;
/*      */ import cpw.mods.fml.relauncher.Side;
/*      */ import cpw.mods.fml.relauncher.SideOnly;
/*      */ import java.util.List;
/*      */ import net.minecraft.block.Block;
/*      */ import net.minecraft.command.IEntitySelector;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.EntityAgeable;
/*      */ import net.minecraft.entity.EntityCreature;
/*      */ import net.minecraft.entity.EntityLiving;
/*      */ import net.minecraft.entity.EntityLivingBase;
/*      */ import net.minecraft.entity.IEntityLivingData;
/*      */ import net.minecraft.entity.SharedMonsterAttributes;
/*      */ import net.minecraft.entity.ai.EntityAIBase;
/*      */ import net.minecraft.entity.ai.attributes.IAttribute;
/*      */ import net.minecraft.entity.ai.attributes.IAttributeInstance;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.init.Blocks;
/*      */ import net.minecraft.init.Items;
/*      */ import net.minecraft.inventory.AnimalChest;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.nbt.NBTBase;
/*      */ import net.minecraft.nbt.NBTTagCompound;
/*      */ import net.minecraft.nbt.NBTTagList;
/*      */ import net.minecraft.pathfinding.PathEntity;
/*      */ import net.minecraft.util.DamageSource;
/*      */ import net.minecraft.util.MathHelper;
/*      */ import net.minecraft.util.StatCollector;
/*      */ import net.minecraft.world.World;
/*      */ 
/*      */ public class EntityHorse extends EntityAnimal implements IInvBasic {
/*   33 */   private static final IEntitySelector field_110276_bu = new IEntitySelector() { private static final String __OBFID = "CL_00001642";
/*      */       
/*      */       public boolean func_82704_a(Entity p_82704_1_) {
/*   36 */         return (p_82704_1_ instanceof EntityHorse && ((EntityHorse)p_82704_1_).func_110205_ce());
/*      */       } }
/*      */   ;
/*      */   
/*   40 */   private static final IAttribute field_110271_bv = (IAttribute)(new RangedAttribute("horse.jumpStrength", 0.7D, 0.0D, 2.0D)).func_111117_a("Jump Strength").func_111112_a(true);
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
/*   66 */   private static final String[] field_110270_bw = new String[] { null, "textures/entity/horse/armor/horse_armor_iron.png", "textures/entity/horse/armor/horse_armor_gold.png", "textures/entity/horse/armor/horse_armor_diamond.png" };
/*      */ 
/*      */   
/*   69 */   private static final String[] field_110273_bx = new String[] { "", "meo", "goo", "dio" };
/*      */ 
/*      */   
/*   72 */   private static final int[] field_110272_by = new int[] { 0, 5, 7, 11 };
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   90 */   private static final String[] field_110268_bz = new String[] { "textures/entity/horse/horse_white.png", "textures/entity/horse/horse_creamy.png", "textures/entity/horse/horse_chestnut.png", "textures/entity/horse/horse_brown.png", "textures/entity/horse/horse_black.png", "textures/entity/horse/horse_gray.png", "textures/entity/horse/horse_darkbrown.png" };
/*      */ 
/*      */ 
/*      */   
/*   94 */   private static final String[] field_110269_bA = new String[] { "hwh", "hcr", "hch", "hbr", "hbl", "hgr", "hdb" };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  104 */   private static final String[] field_110291_bB = new String[] { null, "textures/entity/horse/horse_markings_white.png", "textures/entity/horse/horse_markings_whitefield.png", "textures/entity/horse/horse_markings_whitedots.png", "textures/entity/horse/horse_markings_blackdots.png" };
/*      */ 
/*      */   
/*  107 */   private static final String[] field_110292_bC = new String[] { "", "wo_", "wmo", "wdo", "bdo" }; private int field_110289_bD;
/*      */   private int field_110290_bE;
/*      */   private int field_110295_bF;
/*      */   public int field_110278_bp;
/*      */   public int field_110279_bq;
/*      */   protected boolean field_110275_br;
/*      */   private AnimalChest field_110296_bG;
/*      */   private boolean field_110293_bH;
/*      */   protected int field_110274_bs;
/*      */   protected float field_110277_bt;
/*      */   private boolean field_110294_bI;
/*      */   private float field_110283_bJ;
/*      */   private float field_110284_bK;
/*      */   private float field_110281_bL;
/*      */   private float field_110282_bM;
/*      */   private float field_110287_bN;
/*      */   private float field_110288_bO;
/*      */   private int field_110285_bP;
/*      */   private String field_110286_bQ;
/*      */   private String[] field_110280_bR;
/*      */   private static final String __OBFID = "CL_00001641";
/*      */   
/*  129 */   public EntityHorse(World p_i1685_1_) { super(p_i1685_1_);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  669 */     this.field_110280_bR = new String[3]; func_70105_a(1.4F, 1.6F); this.field_70178_ae = false; func_110207_m(false); func_70661_as().func_75491_a(true); this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this)); this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.2D)); this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIRunAroundLikeCrazy(this, 1.2D)); this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIMate(this, 1.0D)); this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIFollowParent(this, 1.0D)); this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWander((EntityCreature)this, 0.7D)); this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 6.0F)); this.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAILookIdle((EntityLiving)this)); func_110226_cD(); }
/*      */   protected void func_70088_a() { super.func_70088_a(); this.field_70180_af.func_75682_a(16, Integer.valueOf(0)); this.field_70180_af.func_75682_a(19, Byte.valueOf((byte)0)); this.field_70180_af.func_75682_a(20, Integer.valueOf(0)); this.field_70180_af.func_75682_a(21, String.valueOf("")); this.field_70180_af.func_75682_a(22, Integer.valueOf(0)); }
/*      */   public void func_110214_p(int p_110214_1_) { this.field_70180_af.func_75692_b(19, Byte.valueOf((byte)p_110214_1_)); func_110230_cF(); }
/*  672 */   public int func_110265_bP() { return this.field_70180_af.func_75683_a(19); } public void func_110235_q(int p_110235_1_) { this.field_70180_af.func_75692_b(20, Integer.valueOf(p_110235_1_)); func_110230_cF(); } public int func_110202_bQ() { return this.field_70180_af.func_75679_c(20); } public String func_70005_c_() { if (func_94056_bM()) return func_94057_bL();  int i = func_110265_bP(); switch (i) { default: return StatCollector.func_74838_a("entity.horse.name");case 1: return StatCollector.func_74838_a("entity.donkey.name");case 2: return StatCollector.func_74838_a("entity.mule.name");case 4: return StatCollector.func_74838_a("entity.skeletonhorse.name");case 3: break; }  return StatCollector.func_74838_a("entity.zombiehorse.name"); } private boolean func_110233_w(int p_110233_1_) { return ((this.field_70180_af.func_75679_c(16) & p_110233_1_) != 0); } private void func_110208_b(int p_110208_1_, boolean p_110208_2_) { int i = this.field_70180_af.func_75679_c(16); if (p_110208_2_) { this.field_70180_af.func_75692_b(16, Integer.valueOf(i | p_110208_1_)); } else { this.field_70180_af.func_75692_b(16, Integer.valueOf(i & (p_110208_1_ ^ 0xFFFFFFFF))); }  } public boolean func_110228_bR() { return !func_70631_g_(); } public boolean func_110248_bS() { return func_110233_w(2); } public boolean func_110253_bW() { return func_110228_bR(); } public String func_152119_ch() { return this.field_70180_af.func_75681_e(21); } public void func_152120_b(String p_152120_1_) { this.field_70180_af.func_75692_b(21, p_152120_1_); } public float func_110254_bY() { int i = func_70874_b(); if (i >= 0) return 1.0F;  return 0.5F + (-24000 - i) / -24000.0F * 0.5F; } public void func_98054_a(boolean p_98054_1_) { if (p_98054_1_) { func_98055_j(func_110254_bY()); } else { func_98055_j(1.0F); }  } public boolean func_110246_bZ() { return this.field_110275_br; } public void func_110234_j(boolean p_110234_1_) { func_110208_b(2, p_110234_1_); } public void func_110255_k(boolean p_110255_1_) { this.field_110275_br = p_110255_1_; } public boolean func_110164_bC() { return (!func_110256_cu() && super.func_110164_bC()); } protected void func_142017_o(float p_142017_1_) { if (p_142017_1_ > 6.0F && func_110204_cc()) func_110227_p(false);  } public boolean func_110261_ca() { return func_110233_w(8); } public int func_110241_cb() { return this.field_70180_af.func_75679_c(22); } private int func_110260_d(ItemStack p_110260_1_) { if (p_110260_1_ == null) return 0;  Item item = p_110260_1_.func_77973_b(); if (item == Items.field_151138_bX) return 1;  if (item == Items.field_151136_bY) return 2;  if (item == Items.field_151125_bZ) return 3;  return 0; } public boolean func_110204_cc() { return func_110233_w(32); } public boolean func_110209_cd() { return func_110233_w(64); } public boolean func_110205_ce() { return func_110233_w(16); } public boolean func_110243_cf() { return this.field_110293_bH; } public void func_146086_d(ItemStack p_146086_1_) { this.field_70180_af.func_75692_b(22, Integer.valueOf(func_110260_d(p_146086_1_))); func_110230_cF(); } public void func_110242_l(boolean p_110242_1_) { func_110208_b(16, p_110242_1_); } public void func_110207_m(boolean p_110207_1_) { func_110208_b(8, p_110207_1_); } public void func_110221_n(boolean p_110221_1_) { this.field_110293_bH = p_110221_1_; } private void func_110230_cF() { this.field_110286_bQ = null; }
/*      */   public void func_110251_o(boolean p_110251_1_) { func_110208_b(4, p_110251_1_); }
/*      */   public int func_110252_cg() { return this.field_110274_bs; }
/*      */   public void func_110238_s(int p_110238_1_) { this.field_110274_bs = p_110238_1_; }
/*  676 */   public int func_110198_t(int p_110198_1_) { int i = MathHelper.func_76125_a(func_110252_cg() + p_110198_1_, 0, func_110218_cm()); func_110238_s(i); return i; } public boolean func_70097_a(DamageSource p_70097_1_, float p_70097_2_) { Entity entity = p_70097_1_.func_76346_g(); if (this.field_70153_n != null && this.field_70153_n.equals(entity)) return false;  return super.func_70097_a(p_70097_1_, p_70097_2_); } public int func_70658_aO() { return field_110272_by[func_110241_cb()]; } public boolean func_70104_M() { return (this.field_70153_n == null); } public boolean func_110262_ch() { int i = MathHelper.func_76128_c(this.field_70165_t); int j = MathHelper.func_76128_c(this.field_70161_v); this.field_70170_p.func_72807_a(i, j); return true; } public void func_110224_ci() { if (this.field_70170_p.field_72995_K || !func_110261_ca()) return;  func_145779_a(Item.func_150898_a((Block)Blocks.field_150486_ae), 1); func_110207_m(false); } private void func_110266_cB() { func_110249_cI(); this.field_70170_p.func_72956_a((Entity)this, "eating", 1.0F, 1.0F + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F); } protected void func_70069_a(float p_70069_1_) { if (p_70069_1_ > 1.0F) func_85030_a("mob.horse.land", 0.4F, 1.0F);  int i = MathHelper.func_76123_f(p_70069_1_ * 0.5F - 3.0F); if (i <= 0) return;  func_70097_a(DamageSource.field_76379_h, i); if (this.field_70153_n != null) this.field_70153_n.func_70097_a(DamageSource.field_76379_h, i);  Block block = this.field_70170_p.func_147439_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u - 0.2D - this.field_70126_B), MathHelper.func_76128_c(this.field_70161_v)); if (block.func_149688_o() != Material.field_151579_a) { Block.SoundType soundType = block.field_149762_H; this.field_70170_p.func_72956_a((Entity)this, soundType.func_150498_e(), soundType.func_150497_c() * 0.5F, soundType.func_150494_d() * 0.75F); }  } private int func_110225_cC() { int i = func_110265_bP(); if (func_110261_ca() && (i == 1 || i == 2)) return 17;  return 2; } private void func_110226_cD() { AnimalChest animalChest = this.field_110296_bG; this.field_110296_bG = new AnimalChest("HorseChest", func_110225_cC()); this.field_110296_bG.func_110133_a(func_70005_c_()); if (animalChest != null) { animalChest.func_110132_b(this); int i = Math.min(animalChest.func_70302_i_(), this.field_110296_bG.func_70302_i_()); for (byte b = 0; b < i; b++) { ItemStack itemStack = animalChest.func_70301_a(b); if (itemStack != null) this.field_110296_bG.func_70299_a(b, itemStack.func_77946_l());  }  animalChest = null; }  this.field_110296_bG.func_110134_a(this); func_110232_cE(); } private void func_110232_cE() { if (!this.field_70170_p.field_72995_K) { func_110251_o((this.field_110296_bG.func_70301_a(0) != null)); if (func_110259_cr()) func_146086_d(this.field_110296_bG.func_70301_a(1));  }  } public void func_76316_a(InventoryBasic p_76316_1_) { int i = func_110241_cb(); boolean bool = func_110257_ck(); func_110232_cE(); if (this.field_70173_aa > 20) { if (i == 0 && i != func_110241_cb()) { func_85030_a("mob.horse.armor", 0.5F, 1.0F); } else if (i != func_110241_cb()) { func_85030_a("mob.horse.armor", 0.5F, 1.0F); }  if (!bool && func_110257_ck()) func_85030_a("mob.horse.leather", 0.5F, 1.0F);  }  } public boolean func_70601_bi() { func_110262_ch(); return super.func_70601_bi(); } protected EntityHorse func_110250_a(Entity p_110250_1_, double p_110250_2_) { double d = Double.MAX_VALUE; Entity entity = null; List list = this.field_70170_p.func_94576_a(p_110250_1_, p_110250_1_.field_70121_D.func_72321_a(p_110250_2_, p_110250_2_, p_110250_2_), field_110276_bu); for (Entity entity1 : list) { double d1 = entity1.func_70092_e(p_110250_1_.field_70165_t, p_110250_1_.field_70163_u, p_110250_1_.field_70161_v); if (d1 < d) { entity = entity1; d = d1; }  }  return (EntityHorse)entity; } public double func_110215_cj() { return func_110148_a(field_110271_bv).func_111126_e(); } protected String func_70673_aS() { func_110249_cI(); int i = func_110265_bP(); if (i == 3) return "mob.horse.zombie.death";  if (i == 4) return "mob.horse.skeleton.death";  if (i == 1 || i == 2) return "mob.horse.donkey.death";  return "mob.horse.death"; } protected Item func_146068_u() { boolean bool = (this.field_70146_Z.nextInt(4) == 0) ? true : false; int i = func_110265_bP(); if (i == 4) return Items.field_151103_aS;  if (i == 3) { if (bool) return Item.func_150899_d(0);  return Items.field_151078_bh; }  return Items.field_151116_aA; } protected String func_70621_aR() { func_110249_cI(); if (this.field_70146_Z.nextInt(3) == 0) func_110220_cK();  int i = func_110265_bP(); if (i == 3) return "mob.horse.zombie.hit";  if (i == 4) return "mob.horse.skeleton.hit";  if (i == 1 || i == 2) return "mob.horse.donkey.hit";  return "mob.horse.hit"; } public boolean func_110257_ck() { return func_110233_w(4); } protected String func_70639_aQ() { func_110249_cI(); if (this.field_70146_Z.nextInt(10) == 0 && !func_70610_aX()) func_110220_cK();  int i = func_110265_bP(); if (i == 3) return "mob.horse.zombie.idle";  if (i == 4) return "mob.horse.skeleton.idle";  if (i == 1 || i == 2) return "mob.horse.donkey.idle";  return "mob.horse.idle"; } protected String func_110217_cl() { func_110249_cI(); func_110220_cK(); int i = func_110265_bP(); if (i == 3 || i == 4) return null;  if (i == 1 || i == 2) return "mob.horse.donkey.angry";  return "mob.horse.angry"; } protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) { Block.SoundType soundType = p_145780_4_.field_149762_H; if (this.field_70170_p.func_147439_a(p_145780_1_, p_145780_2_ + 1, p_145780_3_) == Blocks.field_150431_aC) soundType = Blocks.field_150431_aC.field_149762_H;  if (!p_145780_4_.func_149688_o().func_76224_d()) { int i = func_110265_bP(); if (this.field_70153_n != null && i != 1 && i != 2) { this.field_110285_bP++; if (this.field_110285_bP > 5 && this.field_110285_bP % 3 == 0) { func_85030_a("mob.horse.gallop", soundType.func_150497_c() * 0.15F, soundType.func_150494_d()); if (i == 0 && this.field_70146_Z.nextInt(10) == 0) func_85030_a("mob.horse.breathe", soundType.func_150497_c() * 0.6F, soundType.func_150494_d());  } else if (this.field_110285_bP <= 5) { func_85030_a("mob.horse.wood", soundType.func_150497_c() * 0.15F, soundType.func_150494_d()); }  } else if (soundType == Block.field_149766_f) { func_85030_a("mob.horse.wood", soundType.func_150497_c() * 0.15F, soundType.func_150494_d()); } else { func_85030_a("mob.horse.soft", soundType.func_150497_c() * 0.15F, soundType.func_150494_d()); }  }  } protected void func_110147_ax() { super.func_110147_ax(); func_110140_aT().func_111150_b(field_110271_bv); func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(53.0D); func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.22499999403953552D); } public int func_70641_bl() { return 6; } public int func_110218_cm() { return 100; } protected float func_70599_aP() { return 0.8F; } public int func_70627_aG() { return 400; } @SideOnly(Side.CLIENT) public boolean func_110239_cn() { return (func_110265_bP() == 0 || func_110241_cb() > 0); } @SideOnly(Side.CLIENT) private void func_110247_cG() { this.field_110286_bQ = "horse/";
/*  677 */     this.field_110280_bR[0] = null;
/*  678 */     this.field_110280_bR[1] = null;
/*  679 */     this.field_110280_bR[2] = null;
/*      */     
/*  681 */     int i = func_110265_bP();
/*  682 */     int j = func_110202_bQ();
/*      */     
/*  684 */     if (i == 0) {
/*  685 */       int m = j & 0xFF;
/*  686 */       int n = (j & 0xFF00) >> 8;
/*  687 */       this.field_110280_bR[0] = field_110268_bz[m];
/*  688 */       this.field_110286_bQ += field_110269_bA[m];
/*  689 */       this.field_110280_bR[1] = field_110291_bB[n];
/*  690 */       this.field_110286_bQ += field_110292_bC[n];
/*      */     } else {
/*  692 */       this.field_110280_bR[0] = "";
/*  693 */       this.field_110286_bQ += "_" + i + "_";
/*      */     } 
/*      */     
/*  696 */     int k = func_110241_cb();
/*  697 */     this.field_110280_bR[2] = field_110270_bw[k];
/*  698 */     this.field_110286_bQ += field_110273_bx[k]; }
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public String func_110264_co() {
/*  702 */     if (this.field_110286_bQ == null) {
/*  703 */       func_110247_cG();
/*      */     }
/*  705 */     return this.field_110286_bQ;
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public String[] func_110212_cp() {
/*  709 */     if (this.field_110286_bQ == null) {
/*  710 */       func_110247_cG();
/*      */     }
/*  712 */     return this.field_110280_bR;
/*      */   }
/*      */   
/*      */   public void func_110199_f(EntityPlayer p_110199_1_) {
/*  716 */     if (!this.field_70170_p.field_72995_K && (this.field_70153_n == null || this.field_70153_n == p_110199_1_) && func_110248_bS()) {
/*  717 */       this.field_110296_bG.func_110133_a(func_70005_c_());
/*  718 */       p_110199_1_.func_110298_a(this, (IInventory)this.field_110296_bG);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean func_70085_c(EntityPlayer p_70085_1_) {
/*  724 */     ItemStack itemStack = p_70085_1_.field_71071_by.func_70448_g();
/*      */     
/*  726 */     if (itemStack != null && itemStack.func_77973_b() == Items.field_151063_bx) {
/*  727 */       return super.func_70085_c(p_70085_1_);
/*      */     }
/*      */     
/*  730 */     if (!func_110248_bS() && 
/*  731 */       func_110256_cu()) {
/*  732 */       return false;
/*      */     }
/*      */ 
/*      */     
/*  736 */     if (func_110248_bS() && func_110228_bR() && p_70085_1_.func_70093_af()) {
/*  737 */       func_110199_f(p_70085_1_);
/*  738 */       return true;
/*      */     } 
/*      */     
/*  741 */     if (func_110253_bW() && this.field_70153_n != null) {
/*  742 */       return super.func_70085_c(p_70085_1_);
/*      */     }
/*      */ 
/*      */     
/*  746 */     if (itemStack != null) {
/*  747 */       boolean bool = false;
/*      */       
/*  749 */       if (func_110259_cr()) {
/*  750 */         byte b = -1;
/*      */         
/*  752 */         if (itemStack.func_77973_b() == Items.field_151138_bX) {
/*  753 */           b = 1;
/*  754 */         } else if (itemStack.func_77973_b() == Items.field_151136_bY) {
/*  755 */           b = 2;
/*  756 */         } else if (itemStack.func_77973_b() == Items.field_151125_bZ) {
/*  757 */           b = 3;
/*      */         } 
/*      */         
/*  760 */         if (b >= 0) {
/*  761 */           if (!func_110248_bS()) {
/*  762 */             func_110231_cz();
/*  763 */             return true;
/*      */           } 
/*  765 */           func_110199_f(p_70085_1_);
/*  766 */           return true;
/*      */         } 
/*      */       } 
/*      */       
/*  770 */       if (!bool && !func_110256_cu()) {
/*  771 */         float f = 0.0F;
/*  772 */         char c = Character.MIN_VALUE;
/*  773 */         byte b = 0;
/*      */         
/*  775 */         if (itemStack.func_77973_b() == Items.field_151015_O) {
/*  776 */           f = 2.0F;
/*  777 */           c = '<';
/*  778 */           b = 3;
/*  779 */         } else if (itemStack.func_77973_b() == Items.field_151102_aT) {
/*  780 */           f = 1.0F;
/*  781 */           c = '\036';
/*  782 */           b = 3;
/*  783 */         } else if (itemStack.func_77973_b() == Items.field_151025_P) {
/*  784 */           f = 7.0F;
/*  785 */           c = '´';
/*  786 */           b = 3;
/*  787 */         } else if (Block.func_149634_a(itemStack.func_77973_b()) == Blocks.field_150407_cf) {
/*  788 */           f = 20.0F;
/*  789 */           c = '´';
/*  790 */         } else if (itemStack.func_77973_b() == Items.field_151034_e) {
/*  791 */           f = 3.0F;
/*  792 */           c = '<';
/*  793 */           b = 3;
/*  794 */         } else if (itemStack.func_77973_b() == Items.field_151150_bK) {
/*  795 */           f = 4.0F;
/*  796 */           c = '<';
/*  797 */           b = 5;
/*  798 */           if (func_110248_bS() && func_70874_b() == 0) {
/*  799 */             bool = true;
/*  800 */             func_146082_f(p_70085_1_);
/*      */           } 
/*  802 */         } else if (itemStack.func_77973_b() == Items.field_151153_ao) {
/*  803 */           f = 10.0F;
/*  804 */           c = 'ð';
/*  805 */           b = 10;
/*  806 */           if (func_110248_bS() && func_70874_b() == 0) {
/*  807 */             bool = true;
/*  808 */             func_146082_f(p_70085_1_);
/*      */           } 
/*      */         } 
/*  811 */         if (func_110143_aJ() < func_110138_aP() && f > 0.0F) {
/*  812 */           func_70691_i(f);
/*  813 */           bool = true;
/*      */         } 
/*  815 */         if (!func_110228_bR() && c > '\000') {
/*  816 */           func_110195_a(c);
/*  817 */           bool = true;
/*      */         } 
/*  819 */         if (b > 0 && (bool || !func_110248_bS()) && b < func_110218_cm()) {
/*  820 */           bool = true;
/*  821 */           func_110198_t(b);
/*      */         } 
/*  823 */         if (bool) {
/*  824 */           func_110266_cB();
/*      */         }
/*      */       } 
/*      */       
/*  828 */       if (!func_110248_bS() && !bool) {
/*  829 */         if (itemStack != null && itemStack.func_111282_a(p_70085_1_, (EntityLivingBase)this)) {
/*  830 */           return true;
/*      */         }
/*  832 */         func_110231_cz();
/*  833 */         return true;
/*      */       } 
/*      */       
/*  836 */       if (!bool && func_110229_cs() && !func_110261_ca() && 
/*  837 */         itemStack.func_77973_b() == Item.func_150898_a((Block)Blocks.field_150486_ae)) {
/*  838 */         func_110207_m(true);
/*  839 */         func_85030_a("mob.chickenplop", 1.0F, (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F + 1.0F);
/*  840 */         bool = true;
/*  841 */         func_110226_cD();
/*      */       } 
/*      */ 
/*      */       
/*  845 */       if (!bool && func_110253_bW() && !func_110257_ck() && 
/*  846 */         itemStack.func_77973_b() == Items.field_151141_av) {
/*  847 */         func_110199_f(p_70085_1_);
/*  848 */         return true;
/*      */       } 
/*      */ 
/*      */       
/*  852 */       if (bool) {
/*  853 */         if (!p_70085_1_.field_71075_bZ.field_75098_d && 
/*  854 */           --itemStack.field_77994_a == 0) {
/*  855 */           p_70085_1_.field_71071_by.func_70299_a(p_70085_1_.field_71071_by.field_70461_c, null);
/*      */         }
/*      */         
/*  858 */         return true;
/*      */       } 
/*      */     } 
/*      */     
/*  862 */     if (func_110253_bW() && this.field_70153_n == null) {
/*      */ 
/*      */       
/*  865 */       if (itemStack != null && itemStack.func_111282_a(p_70085_1_, (EntityLivingBase)this)) {
/*  866 */         return true;
/*      */       }
/*  868 */       func_110237_h(p_70085_1_);
/*  869 */       return true;
/*      */     } 
/*  871 */     return super.func_70085_c(p_70085_1_);
/*      */   }
/*      */ 
/*      */   
/*      */   private void func_110237_h(EntityPlayer p_110237_1_) {
/*  876 */     p_110237_1_.field_70177_z = this.field_70177_z;
/*  877 */     p_110237_1_.field_70125_A = this.field_70125_A;
/*  878 */     func_110227_p(false);
/*  879 */     func_110219_q(false);
/*  880 */     if (!this.field_70170_p.field_72995_K) {
/*  881 */       p_110237_1_.func_70078_a((Entity)this);
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
/*      */   public boolean func_110259_cr() {
/*  896 */     return (func_110265_bP() == 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean func_110229_cs() {
/*  905 */     int i = func_110265_bP();
/*  906 */     return (i == 2 || i == 1);
/*      */   }
/*      */ 
/*      */   
/*      */   protected boolean func_70610_aX() {
/*  911 */     if (this.field_70153_n != null && func_110257_ck()) {
/*  912 */       return true;
/*      */     }
/*  914 */     return (func_110204_cc() || func_110209_cd());
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
/*      */   
/*      */   public boolean func_110256_cu() {
/*  931 */     int i = func_110265_bP();
/*  932 */     return (i == 3 || i == 4);
/*      */   }
/*      */   
/*      */   public boolean func_110222_cv() {
/*  936 */     return (func_110256_cu() || func_110265_bP() == 2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean func_70877_b(ItemStack p_70877_1_) {
/*  942 */     return false;
/*      */   }
/*      */   
/*      */   private void func_110210_cH() {
/*  946 */     this.field_110278_bp = 1;
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
/*      */   public void func_70645_a(DamageSource p_70645_1_) {
/*  959 */     super.func_70645_a(p_70645_1_);
/*  960 */     if (!this.field_70170_p.field_72995_K) {
/*  961 */       func_110244_cA();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_70636_d() {
/*  968 */     if (this.field_70146_Z.nextInt(200) == 0) {
/*  969 */       func_110210_cH();
/*      */     }
/*      */     
/*  972 */     super.func_70636_d();
/*      */     
/*  974 */     if (!this.field_70170_p.field_72995_K) {
/*  975 */       if (this.field_70146_Z.nextInt(900) == 0 && this.field_70725_aQ == 0) {
/*  976 */         func_70691_i(1.0F);
/*      */       }
/*      */       
/*  979 */       if (!func_110204_cc() && this.field_70153_n == null && this.field_70146_Z.nextInt(300) == 0 && 
/*  980 */         this.field_70170_p.func_147439_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u) - 1, MathHelper.func_76128_c(this.field_70161_v)) == Blocks.field_150349_c) {
/*  981 */         func_110227_p(true);
/*      */       }
/*      */ 
/*      */       
/*  985 */       if (func_110204_cc() && ++this.field_110289_bD > 50) {
/*  986 */         this.field_110289_bD = 0;
/*  987 */         func_110227_p(false);
/*      */       } 
/*      */       
/*  990 */       if (func_110205_ce() && !func_110228_bR() && !func_110204_cc()) {
/*  991 */         EntityHorse entityHorse = func_110250_a((Entity)this, 16.0D);
/*  992 */         if (entityHorse != null && func_70068_e((Entity)entityHorse) > 4.0D) {
/*  993 */           PathEntity pathEntity = this.field_70170_p.func_72865_a((Entity)this, (Entity)entityHorse, 16.0F, true, false, false, true);
/*  994 */           func_70778_a(pathEntity);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_70071_h_() {
/* 1003 */     super.func_70071_h_();
/*      */ 
/*      */     
/* 1006 */     if (this.field_70170_p.field_72995_K && this.field_70180_af.func_75684_a()) {
/* 1007 */       this.field_70180_af.func_111144_e();
/* 1008 */       func_110230_cF();
/*      */     } 
/*      */     
/* 1011 */     if (this.field_110290_bE > 0 && ++this.field_110290_bE > 30) {
/* 1012 */       this.field_110290_bE = 0;
/* 1013 */       func_110208_b(128, false);
/*      */     } 
/*      */     
/* 1016 */     if (!this.field_70170_p.field_72995_K && 
/* 1017 */       this.field_110295_bF > 0 && ++this.field_110295_bF > 20) {
/* 1018 */       this.field_110295_bF = 0;
/* 1019 */       func_110219_q(false);
/*      */     } 
/*      */ 
/*      */     
/* 1023 */     if (this.field_110278_bp > 0 && ++this.field_110278_bp > 8) {
/* 1024 */       this.field_110278_bp = 0;
/*      */     }
/*      */     
/* 1027 */     if (this.field_110279_bq > 0) {
/* 1028 */       this.field_110279_bq++;
/*      */       
/* 1030 */       if (this.field_110279_bq > 300) {
/* 1031 */         this.field_110279_bq = 0;
/*      */       }
/*      */     } 
/*      */     
/* 1035 */     this.field_110284_bK = this.field_110283_bJ;
/* 1036 */     if (func_110204_cc()) {
/* 1037 */       this.field_110283_bJ += (1.0F - this.field_110283_bJ) * 0.4F + 0.05F;
/* 1038 */       if (this.field_110283_bJ > 1.0F) {
/* 1039 */         this.field_110283_bJ = 1.0F;
/*      */       }
/*      */     } else {
/* 1042 */       this.field_110283_bJ += (0.0F - this.field_110283_bJ) * 0.4F - 0.05F;
/* 1043 */       if (this.field_110283_bJ < 0.0F) {
/* 1044 */         this.field_110283_bJ = 0.0F;
/*      */       }
/*      */     } 
/* 1047 */     this.field_110282_bM = this.field_110281_bL;
/* 1048 */     if (func_110209_cd()) {
/*      */       
/* 1050 */       this.field_110284_bK = this.field_110283_bJ = 0.0F;
/* 1051 */       this.field_110281_bL += (1.0F - this.field_110281_bL) * 0.4F + 0.05F;
/* 1052 */       if (this.field_110281_bL > 1.0F) {
/* 1053 */         this.field_110281_bL = 1.0F;
/*      */       }
/*      */     } else {
/* 1056 */       this.field_110294_bI = false;
/*      */       
/* 1058 */       this.field_110281_bL += (0.8F * this.field_110281_bL * this.field_110281_bL * this.field_110281_bL - this.field_110281_bL) * 0.6F - 0.05F;
/* 1059 */       if (this.field_110281_bL < 0.0F) {
/* 1060 */         this.field_110281_bL = 0.0F;
/*      */       }
/*      */     } 
/* 1063 */     this.field_110288_bO = this.field_110287_bN;
/* 1064 */     if (func_110233_w(128)) {
/* 1065 */       this.field_110287_bN += (1.0F - this.field_110287_bN) * 0.7F + 0.05F;
/* 1066 */       if (this.field_110287_bN > 1.0F) {
/* 1067 */         this.field_110287_bN = 1.0F;
/*      */       }
/*      */     } else {
/* 1070 */       this.field_110287_bN += (0.0F - this.field_110287_bN) * 0.7F - 0.05F;
/* 1071 */       if (this.field_110287_bN < 0.0F) {
/* 1072 */         this.field_110287_bN = 0.0F;
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   private void func_110249_cI() {
/* 1078 */     if (!this.field_70170_p.field_72995_K) {
/* 1079 */       this.field_110290_bE = 1;
/* 1080 */       func_110208_b(128, true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private boolean func_110200_cJ() {
/* 1085 */     return (this.field_70153_n == null && this.field_70154_o == null && func_110248_bS() && func_110228_bR() && !func_110222_cv() && func_110143_aJ() >= func_110138_aP());
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
/*      */   public void func_70019_c(boolean p_70019_1_) {
/* 1098 */     func_110208_b(32, p_70019_1_);
/*      */   }
/*      */   
/*      */   public void func_110227_p(boolean p_110227_1_) {
/* 1102 */     func_70019_c(p_110227_1_);
/*      */   }
/*      */   
/*      */   public void func_110219_q(boolean p_110219_1_) {
/* 1106 */     if (p_110219_1_) {
/* 1107 */       func_110227_p(false);
/*      */     }
/* 1109 */     func_110208_b(64, p_110219_1_);
/*      */   }
/*      */   
/*      */   private void func_110220_cK() {
/* 1113 */     if (!this.field_70170_p.field_72995_K) {
/* 1114 */       this.field_110295_bF = 1;
/* 1115 */       func_110219_q(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void func_110231_cz() {
/* 1120 */     func_110220_cK();
/* 1121 */     String str = func_110217_cl();
/* 1122 */     if (str != null) {
/* 1123 */       func_85030_a(str, func_70599_aP(), func_70647_i());
/*      */     }
/*      */   }
/*      */   
/*      */   public void func_110244_cA() {
/* 1128 */     func_110240_a((Entity)this, this.field_110296_bG);
/* 1129 */     func_110224_ci();
/*      */   }
/*      */   
/*      */   private void func_110240_a(Entity p_110240_1_, AnimalChest p_110240_2_) {
/* 1133 */     if (p_110240_2_ == null || this.field_70170_p.field_72995_K)
/*      */       return; 
/* 1135 */     for (byte b = 0; b < p_110240_2_.func_70302_i_(); b++) {
/* 1136 */       ItemStack itemStack = p_110240_2_.func_70301_a(b);
/* 1137 */       if (itemStack != null)
/*      */       {
/*      */         
/* 1140 */         func_70099_a(itemStack, 0.0F);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean func_110263_g(EntityPlayer p_110263_1_) {
/* 1146 */     func_152120_b(p_110263_1_.func_110124_au().toString());
/* 1147 */     func_110234_j(true);
/* 1148 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_70612_e(float p_70612_1_, float p_70612_2_) {
/* 1159 */     if (this.field_70153_n == null || !(this.field_70153_n instanceof EntityLivingBase) || !func_110257_ck()) {
/* 1160 */       this.field_70138_W = 0.5F;
/* 1161 */       this.field_70747_aH = 0.02F;
/* 1162 */       super.func_70612_e(p_70612_1_, p_70612_2_);
/*      */       
/*      */       return;
/*      */     } 
/* 1166 */     this.field_70126_B = this.field_70177_z = this.field_70153_n.field_70177_z;
/* 1167 */     this.field_70125_A = this.field_70153_n.field_70125_A * 0.5F;
/* 1168 */     func_70101_b(this.field_70177_z, this.field_70125_A);
/* 1169 */     this.field_70759_as = this.field_70761_aq = this.field_70177_z;
/*      */     
/* 1171 */     p_70612_1_ = ((EntityLivingBase)this.field_70153_n).field_70702_br * 0.5F;
/* 1172 */     p_70612_2_ = ((EntityLivingBase)this.field_70153_n).field_70701_bs;
/*      */ 
/*      */     
/* 1175 */     if (p_70612_2_ <= 0.0F) {
/* 1176 */       p_70612_2_ *= 0.25F;
/* 1177 */       this.field_110285_bP = 0;
/*      */     } 
/*      */     
/* 1180 */     if (this.field_70122_E && this.field_110277_bt == 0.0F && func_110209_cd() && !this.field_110294_bI) {
/* 1181 */       p_70612_1_ = 0.0F;
/* 1182 */       p_70612_2_ = 0.0F;
/*      */     } 
/*      */     
/* 1185 */     if (this.field_110277_bt > 0.0F && !func_110246_bZ() && this.field_70122_E) {
/* 1186 */       this.field_70181_x = func_110215_cj() * this.field_110277_bt;
/* 1187 */       if (func_70644_a(Potion.field_76430_j)) {
/* 1188 */         this.field_70181_x += ((func_70660_b(Potion.field_76430_j).func_76458_c() + 1) * 0.1F);
/*      */       }
/*      */       
/* 1191 */       func_110255_k(true);
/* 1192 */       this.field_70160_al = true;
/*      */       
/* 1194 */       if (p_70612_2_ > 0.0F) {
/* 1195 */         float f1 = MathHelper.func_76126_a(this.field_70177_z * 3.1415927F / 180.0F);
/* 1196 */         float f2 = MathHelper.func_76134_b(this.field_70177_z * 3.1415927F / 180.0F);
/*      */         
/* 1198 */         this.field_70159_w += (-0.4F * f1 * this.field_110277_bt);
/* 1199 */         this.field_70179_y += (0.4F * f2 * this.field_110277_bt);
/*      */         
/* 1201 */         func_85030_a("mob.horse.jump", 0.4F, 1.0F);
/*      */       } 
/* 1203 */       this.field_110277_bt = 0.0F;
/*      */     } 
/*      */     
/* 1206 */     this.field_70138_W = 1.0F;
/* 1207 */     this.field_70747_aH = func_70689_ay() * 0.1F;
/* 1208 */     if (!this.field_70170_p.field_72995_K) {
/* 1209 */       func_70659_e((float)func_110148_a(SharedMonsterAttributes.field_111263_d).func_111126_e());
/* 1210 */       super.func_70612_e(p_70612_1_, p_70612_2_);
/*      */     } 
/*      */ 
/*      */     
/* 1214 */     if (this.field_70122_E) {
/*      */       
/* 1216 */       this.field_110277_bt = 0.0F;
/* 1217 */       func_110255_k(false);
/*      */     } 
/* 1219 */     this.field_70722_aY = this.field_70721_aZ;
/* 1220 */     double d1 = this.field_70165_t - this.field_70169_q;
/* 1221 */     double d2 = this.field_70161_v - this.field_70166_s;
/* 1222 */     float f = MathHelper.func_76133_a(d1 * d1 + d2 * d2) * 4.0F;
/* 1223 */     if (f > 1.0F) {
/* 1224 */       f = 1.0F;
/*      */     }
/*      */     
/* 1227 */     this.field_70721_aZ += (f - this.field_70721_aZ) * 0.4F;
/* 1228 */     this.field_70754_ba += this.field_70721_aZ;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_70014_b(NBTTagCompound p_70014_1_) {
/* 1234 */     super.func_70014_b(p_70014_1_);
/*      */     
/* 1236 */     p_70014_1_.func_74757_a("EatingHaystack", func_110204_cc());
/* 1237 */     p_70014_1_.func_74757_a("ChestedHorse", func_110261_ca());
/* 1238 */     p_70014_1_.func_74757_a("HasReproduced", func_110243_cf());
/* 1239 */     p_70014_1_.func_74757_a("Bred", func_110205_ce());
/* 1240 */     p_70014_1_.func_74768_a("Type", func_110265_bP());
/* 1241 */     p_70014_1_.func_74768_a("Variant", func_110202_bQ());
/* 1242 */     p_70014_1_.func_74768_a("Temper", func_110252_cg());
/* 1243 */     p_70014_1_.func_74757_a("Tame", func_110248_bS());
/* 1244 */     p_70014_1_.func_74778_a("OwnerUUID", func_152119_ch());
/*      */     
/* 1246 */     if (func_110261_ca()) {
/* 1247 */       NBTTagList nBTTagList = new NBTTagList();
/*      */       
/* 1249 */       for (byte b = 2; b < this.field_110296_bG.func_70302_i_(); b++) {
/* 1250 */         ItemStack itemStack = this.field_110296_bG.func_70301_a(b);
/*      */         
/* 1252 */         if (itemStack != null) {
/* 1253 */           NBTTagCompound nBTTagCompound = new NBTTagCompound();
/*      */           
/* 1255 */           nBTTagCompound.func_74774_a("Slot", (byte)b);
/*      */           
/* 1257 */           itemStack.func_77955_b(nBTTagCompound);
/* 1258 */           nBTTagList.func_74742_a((NBTBase)nBTTagCompound);
/*      */         } 
/*      */       } 
/* 1261 */       p_70014_1_.func_74782_a("Items", (NBTBase)nBTTagList);
/*      */     } 
/*      */     
/* 1264 */     if (this.field_110296_bG.func_70301_a(1) != null) {
/* 1265 */       p_70014_1_.func_74782_a("ArmorItem", (NBTBase)this.field_110296_bG.func_70301_a(1).func_77955_b(new NBTTagCompound()));
/*      */     }
/* 1267 */     if (this.field_110296_bG.func_70301_a(0) != null) {
/* 1268 */       p_70014_1_.func_74782_a("SaddleItem", (NBTBase)this.field_110296_bG.func_70301_a(0).func_77955_b(new NBTTagCompound()));
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_70037_a(NBTTagCompound p_70037_1_) {
/* 1274 */     super.func_70037_a(p_70037_1_);
/* 1275 */     func_110227_p(p_70037_1_.func_74767_n("EatingHaystack"));
/* 1276 */     func_110242_l(p_70037_1_.func_74767_n("Bred"));
/* 1277 */     func_110207_m(p_70037_1_.func_74767_n("ChestedHorse"));
/* 1278 */     func_110221_n(p_70037_1_.func_74767_n("HasReproduced"));
/* 1279 */     func_110214_p(p_70037_1_.func_74762_e("Type"));
/* 1280 */     func_110235_q(p_70037_1_.func_74762_e("Variant"));
/* 1281 */     func_110238_s(p_70037_1_.func_74762_e("Temper"));
/* 1282 */     func_110234_j(p_70037_1_.func_74767_n("Tame"));
/* 1283 */     if (p_70037_1_.func_150297_b("OwnerUUID", 8)) {
/* 1284 */       func_152120_b(p_70037_1_.func_74779_i("OwnerUUID"));
/*      */     }
/*      */     
/* 1287 */     IAttributeInstance iAttributeInstance = func_110140_aT().func_111152_a("Speed");
/*      */     
/* 1289 */     if (iAttributeInstance != null) {
/* 1290 */       func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(iAttributeInstance.func_111125_b() * 0.25D);
/*      */     }
/*      */     
/* 1293 */     if (func_110261_ca()) {
/* 1294 */       NBTTagList nBTTagList = p_70037_1_.func_150295_c("Items", 10);
/* 1295 */       func_110226_cD();
/*      */       
/* 1297 */       for (byte b = 0; b < nBTTagList.func_74745_c(); b++) {
/* 1298 */         NBTTagCompound nBTTagCompound = nBTTagList.func_150305_b(b);
/* 1299 */         int i = nBTTagCompound.func_74771_c("Slot") & 0xFF;
/*      */         
/* 1301 */         if (i >= 2 && i < this.field_110296_bG.func_70302_i_()) {
/* 1302 */           this.field_110296_bG.func_70299_a(i, ItemStack.func_77949_a(nBTTagCompound));
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 1307 */     if (p_70037_1_.func_150297_b("ArmorItem", 10)) {
/* 1308 */       ItemStack itemStack = ItemStack.func_77949_a(p_70037_1_.func_74775_l("ArmorItem"));
/* 1309 */       if (itemStack != null && func_146085_a(itemStack.func_77973_b())) {
/* 1310 */         this.field_110296_bG.func_70299_a(1, itemStack);
/*      */       }
/*      */     } 
/*      */     
/* 1314 */     if (p_70037_1_.func_150297_b("SaddleItem", 10)) {
/* 1315 */       ItemStack itemStack = ItemStack.func_77949_a(p_70037_1_.func_74775_l("SaddleItem"));
/* 1316 */       if (itemStack != null && itemStack.func_77973_b() == Items.field_151141_av) {
/* 1317 */         this.field_110296_bG.func_70299_a(0, itemStack);
/*      */       }
/* 1319 */     } else if (p_70037_1_.func_74767_n("Saddle")) {
/* 1320 */       this.field_110296_bG.func_70299_a(0, new ItemStack(Items.field_151141_av));
/*      */     } 
/* 1322 */     func_110232_cE();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean func_70878_b(EntityAnimal p_70878_1_) {
/* 1327 */     if (p_70878_1_ == this) return false; 
/* 1328 */     if (p_70878_1_.getClass() != getClass()) return false;
/*      */     
/* 1330 */     EntityHorse entityHorse = (EntityHorse)p_70878_1_;
/*      */     
/* 1332 */     if (!func_110200_cJ() || !entityHorse.func_110200_cJ()) {
/* 1333 */       return false;
/*      */     }
/* 1335 */     int i = func_110265_bP();
/* 1336 */     int j = entityHorse.func_110265_bP();
/*      */     
/* 1338 */     return (i == j || (i == 0 && j == 1) || (i == 1 && j == 0));
/*      */   }
/*      */ 
/*      */   
/*      */   public EntityAgeable func_90011_a(EntityAgeable p_90011_1_) {
/* 1343 */     EntityHorse entityHorse1 = (EntityHorse)p_90011_1_;
/* 1344 */     EntityHorse entityHorse2 = new EntityHorse(this.field_70170_p);
/*      */     
/* 1346 */     int i = func_110265_bP();
/* 1347 */     int j = entityHorse1.func_110265_bP();
/* 1348 */     int k = 0;
/*      */     
/* 1350 */     if (i == j) {
/* 1351 */       k = i;
/* 1352 */     } else if ((i == 0 && j == 1) || (i == 1 && j == 0)) {
/* 1353 */       k = 2;
/*      */     } 
/*      */ 
/*      */     
/* 1357 */     if (k == 0) {
/*      */       
/* 1359 */       int m, n = this.field_70146_Z.nextInt(9);
/* 1360 */       if (n < 4) {
/* 1361 */         m = func_110202_bQ() & 0xFF;
/* 1362 */       } else if (n < 8) {
/* 1363 */         m = entityHorse1.func_110202_bQ() & 0xFF;
/*      */       } else {
/* 1365 */         m = this.field_70146_Z.nextInt(7);
/*      */       } 
/*      */       
/* 1368 */       int i1 = this.field_70146_Z.nextInt(5);
/* 1369 */       if (i1 < 2) {
/* 1370 */         m |= func_110202_bQ() & 0xFF00;
/* 1371 */       } else if (i1 < 4) {
/* 1372 */         m |= entityHorse1.func_110202_bQ() & 0xFF00;
/*      */       } else {
/* 1374 */         m |= this.field_70146_Z.nextInt(5) << 8 & 0xFF00;
/*      */       } 
/* 1376 */       entityHorse2.func_110235_q(m);
/*      */     } 
/*      */     
/* 1379 */     entityHorse2.func_110214_p(k);
/*      */ 
/*      */     
/* 1382 */     double d1 = func_110148_a(SharedMonsterAttributes.field_111267_a).func_111125_b() + p_90011_1_.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111125_b() + func_110267_cL();
/* 1383 */     entityHorse2.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(d1 / 3.0D);
/*      */     
/* 1385 */     double d2 = func_110148_a(field_110271_bv).func_111125_b() + p_90011_1_.func_110148_a(field_110271_bv).func_111125_b() + func_110245_cM();
/* 1386 */     entityHorse2.func_110148_a(field_110271_bv).func_111128_a(d2 / 3.0D);
/*      */     
/* 1388 */     double d3 = func_110148_a(SharedMonsterAttributes.field_111263_d).func_111125_b() + p_90011_1_.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111125_b() + func_110203_cN();
/* 1389 */     entityHorse2.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(d3 / 3.0D);
/*      */     
/* 1391 */     return entityHorse2;
/*      */   }
/*      */ 
/*      */   
/*      */   public IEntityLivingData func_110161_a(IEntityLivingData p_110161_1_) {
/* 1396 */     p_110161_1_ = super.func_110161_a(p_110161_1_);
/*      */     
/* 1398 */     int i = 0;
/* 1399 */     int j = 0;
/*      */     
/* 1401 */     if (p_110161_1_ instanceof GroupData) {
/* 1402 */       i = ((GroupData)p_110161_1_).field_111107_a;
/* 1403 */       j = ((GroupData)p_110161_1_).field_111106_b & 0xFF | this.field_70146_Z.nextInt(5) << 8;
/*      */     } else {
/* 1405 */       if (this.field_70146_Z.nextInt(10) == 0) {
/* 1406 */         i = 1;
/*      */       } else {
/* 1408 */         int k = this.field_70146_Z.nextInt(7);
/* 1409 */         int m = this.field_70146_Z.nextInt(5);
/* 1410 */         i = 0;
/* 1411 */         j = k | m << 8;
/*      */       } 
/* 1413 */       p_110161_1_ = new GroupData(i, j);
/*      */     } 
/*      */     
/* 1416 */     func_110214_p(i);
/* 1417 */     func_110235_q(j);
/*      */     
/* 1419 */     if (this.field_70146_Z.nextInt(5) == 0) {
/* 1420 */       func_70873_a(-24000);
/*      */     }
/*      */     
/* 1423 */     if (i == 4 || i == 3) {
/* 1424 */       func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(15.0D);
/* 1425 */       func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.20000000298023224D);
/*      */     } else {
/* 1427 */       func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(func_110267_cL());
/* 1428 */       if (i == 0) {
/* 1429 */         func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(func_110203_cN());
/*      */       } else {
/* 1431 */         func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.17499999701976776D);
/*      */       } 
/*      */     } 
/* 1434 */     if (i == 2 || i == 1) {
/* 1435 */       func_110148_a(field_110271_bv).func_111128_a(0.5D);
/*      */     } else {
/* 1437 */       func_110148_a(field_110271_bv).func_111128_a(func_110245_cM());
/*      */     } 
/* 1439 */     func_70606_j(func_110138_aP());
/*      */     
/* 1441 */     return p_110161_1_;
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public float func_110258_o(float p_110258_1_) {
/* 1445 */     return this.field_110284_bK + (this.field_110283_bJ - this.field_110284_bK) * p_110258_1_;
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public float func_110223_p(float p_110223_1_) {
/* 1449 */     return this.field_110282_bM + (this.field_110281_bL - this.field_110282_bM) * p_110223_1_;
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public float func_110201_q(float p_110201_1_) {
/* 1453 */     return this.field_110288_bO + (this.field_110287_bN - this.field_110288_bO) * p_110201_1_;
/*      */   }
/*      */ 
/*      */   
/*      */   protected boolean func_70650_aV() {
/* 1458 */     return true;
/*      */   }
/*      */   
/*      */   public void func_110206_u(int p_110206_1_) {
/* 1462 */     if (func_110257_ck()) {
/* 1463 */       if (p_110206_1_ < 0) {
/* 1464 */         p_110206_1_ = 0;
/*      */       } else {
/* 1466 */         this.field_110294_bI = true;
/* 1467 */         func_110220_cK();
/*      */       } 
/*      */       
/* 1470 */       if (p_110206_1_ >= 90) {
/* 1471 */         this.field_110277_bt = 1.0F;
/*      */       } else {
/* 1473 */         this.field_110277_bt = 0.4F + 0.4F * p_110206_1_ / 90.0F;
/*      */       } 
/*      */     } 
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   protected void func_110216_r(boolean p_110216_1_) {
/* 1479 */     String str = p_110216_1_ ? "heart" : "smoke";
/*      */     
/* 1481 */     for (byte b = 0; b < 7; b++) {
/* 1482 */       double d1 = this.field_70146_Z.nextGaussian() * 0.02D;
/* 1483 */       double d2 = this.field_70146_Z.nextGaussian() * 0.02D;
/* 1484 */       double d3 = this.field_70146_Z.nextGaussian() * 0.02D;
/* 1485 */       this.field_70170_p.func_72869_a(str, this.field_70165_t + (this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0F) - this.field_70130_N, this.field_70163_u + 0.5D + (this.field_70146_Z.nextFloat() * this.field_70131_O), this.field_70161_v + (this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0F) - this.field_70130_N, d1, d2, d3);
/*      */     } 
/*      */   }
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public void func_70103_a(byte p_70103_1_) {
/* 1491 */     if (p_70103_1_ == 7) {
/* 1492 */       func_110216_r(true);
/* 1493 */     } else if (p_70103_1_ == 6) {
/* 1494 */       func_110216_r(false);
/*      */     } else {
/* 1496 */       super.func_70103_a(p_70103_1_);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_70043_V() {
/* 1502 */     super.func_70043_V();
/*      */     
/* 1504 */     if (this.field_110282_bM > 0.0F) {
/* 1505 */       float f1 = MathHelper.func_76126_a(this.field_70761_aq * 3.1415927F / 180.0F);
/* 1506 */       float f2 = MathHelper.func_76134_b(this.field_70761_aq * 3.1415927F / 180.0F);
/* 1507 */       float f3 = 0.7F * this.field_110282_bM;
/* 1508 */       float f4 = 0.15F * this.field_110282_bM;
/*      */       
/* 1510 */       this.field_70153_n.func_70107_b(this.field_70165_t + (f3 * f1), this.field_70163_u + func_70042_X() + this.field_70153_n.func_70033_W() + f4, this.field_70161_v - (f3 * f2));
/* 1511 */       if (this.field_70153_n instanceof EntityLivingBase) {
/* 1512 */         ((EntityLivingBase)this.field_70153_n).field_70761_aq = this.field_70761_aq;
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private float func_110267_cL() {
/* 1519 */     return 15.0F + this.field_70146_Z.nextInt(8) + this.field_70146_Z.nextInt(9);
/*      */   }
/*      */   
/*      */   private double func_110245_cM() {
/* 1523 */     return 0.4000000059604645D + this.field_70146_Z.nextDouble() * 0.2D + this.field_70146_Z.nextDouble() * 0.2D + this.field_70146_Z.nextDouble() * 0.2D;
/*      */   }
/*      */   
/*      */   private double func_110203_cN() {
/* 1527 */     return (0.44999998807907104D + this.field_70146_Z.nextDouble() * 0.3D + this.field_70146_Z.nextDouble() * 0.3D + this.field_70146_Z.nextDouble() * 0.3D) * 0.25D;
/*      */   }
/*      */   
/*      */   public static class GroupData implements IEntityLivingData {
/*      */     public int field_111107_a;
/*      */     public int field_111106_b;
/*      */     private static final String __OBFID = "CL_00001643";
/*      */     
/*      */     public GroupData(int p_i1684_1_, int p_i1684_2_) {
/* 1536 */       this.field_111107_a = p_i1684_1_;
/* 1537 */       this.field_111106_b = p_i1684_2_;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean func_146085_a(Item p_146085_0_) {
/* 1543 */     return (p_146085_0_ == Items.field_151138_bX || p_146085_0_ == Items.field_151136_bY || p_146085_0_ == Items.field_151125_bZ);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean func_70617_f_() {
/* 1549 */     return false;
/*      */   }
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\passive\EntityHorse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */