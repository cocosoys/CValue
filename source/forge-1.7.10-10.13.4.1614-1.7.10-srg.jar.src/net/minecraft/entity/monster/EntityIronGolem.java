/*     */ package net.minecraft.entity.monster;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIAttackOnCollide;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAIDefendVillage;
/*     */ import net.minecraft.entity.ai.EntityAILookIdle;
/*     */ import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
/*     */ import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
/*     */ import net.minecraft.entity.ai.EntityAIWander;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.ChunkCoordinates;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.village.Village;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityIronGolem extends EntityGolem {
/*     */   private int field_70858_e;
/*     */   Village field_70857_d;
/*     */   
/*     */   public EntityIronGolem(World p_i1694_1_) {
/*  33 */     super(p_i1694_1_);
/*  34 */     func_70105_a(1.4F, 2.9F);
/*     */     
/*  36 */     func_70661_as().func_75491_a(true);
/*     */     
/*  38 */     this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIAttackOnCollide(this, 1.0D, true));
/*  39 */     this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIMoveTowardsTarget(this, 0.9D, 32.0F));
/*  40 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIMoveThroughVillage(this, 0.6D, true));
/*  41 */     this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIMoveTowardsRestriction(this, 1.0D));
/*  42 */     this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAILookAtVillager(this));
/*  43 */     this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWander(this, 0.6D));
/*  44 */     this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 6.0F));
/*  45 */     this.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*     */     
/*  47 */     this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIDefendVillage(this));
/*  48 */     this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAIHurtByTarget(this, false));
/*  49 */     this.field_70715_bh.func_75776_a(3, (EntityAIBase)new EntityAINearestAttackableTarget(this, EntityLiving.class, 0, false, true, IMob.field_82192_a));
/*     */   }
/*     */   private int field_70855_f; private int field_70856_g; private static final String __OBFID = "CL_00001652";
/*     */   
/*     */   protected void func_70088_a() {
/*  54 */     super.func_70088_a();
/*  55 */     this.field_70180_af.func_75682_a(16, Byte.valueOf((byte)0));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70650_aV() {
/*  60 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70629_bd() {
/*  65 */     if (--this.field_70858_e <= 0) {
/*  66 */       this.field_70858_e = 70 + this.field_70146_Z.nextInt(50);
/*  67 */       this.field_70857_d = this.field_70170_p.field_72982_D.func_75550_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v), 32);
/*  68 */       if (this.field_70857_d == null) { func_110177_bN(); }
/*     */       else
/*  70 */       { ChunkCoordinates chunkCoordinates = this.field_70857_d.func_75577_a();
/*  71 */         func_110171_b(chunkCoordinates.field_71574_a, chunkCoordinates.field_71572_b, chunkCoordinates.field_71573_c, (int)(this.field_70857_d.func_75568_b() * 0.6F)); }
/*     */     
/*     */     } 
/*     */     
/*  75 */     super.func_70629_bd();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  80 */     super.func_110147_ax();
/*     */     
/*  82 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(100.0D);
/*  83 */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.25D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected int func_70682_h(int p_70682_1_) {
/*  89 */     return p_70682_1_;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_82167_n(Entity p_82167_1_) {
/*  94 */     if (p_82167_1_ instanceof IMob && 
/*  95 */       func_70681_au().nextInt(20) == 0) {
/*  96 */       func_70624_b((EntityLivingBase)p_82167_1_);
/*     */     }
/*     */     
/*  99 */     super.func_82167_n(p_82167_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/* 104 */     super.func_70636_d();
/*     */     
/* 106 */     if (this.field_70855_f > 0) this.field_70855_f--; 
/* 107 */     if (this.field_70856_g > 0) this.field_70856_g--;
/*     */     
/* 109 */     if (this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y > 2.500000277905201E-7D && this.field_70146_Z.nextInt(5) == 0) {
/* 110 */       int i = MathHelper.func_76128_c(this.field_70165_t);
/* 111 */       int j = MathHelper.func_76128_c(this.field_70163_u - 0.20000000298023224D - this.field_70129_M);
/* 112 */       int k = MathHelper.func_76128_c(this.field_70161_v);
/* 113 */       Block block = this.field_70170_p.func_147439_a(i, j, k);
/* 114 */       if (block.func_149688_o() != Material.field_151579_a) {
/* 115 */         this.field_70170_p.func_72869_a("blockcrack_" + Block.func_149682_b(block) + "_" + this.field_70170_p.func_72805_g(i, j, k), this.field_70165_t + (this.field_70146_Z.nextFloat() - 0.5D) * this.field_70130_N, this.field_70121_D.field_72338_b + 0.1D, this.field_70161_v + (this.field_70146_Z.nextFloat() - 0.5D) * this.field_70130_N, 4.0D * (this.field_70146_Z.nextFloat() - 0.5D), 0.5D, (this.field_70146_Z.nextFloat() - 0.5D) * 4.0D);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70686_a(Class<?> p_70686_1_) {
/* 122 */     if (func_70850_q() && EntityPlayer.class.isAssignableFrom(p_70686_1_)) return false; 
/* 123 */     return super.func_70686_a(p_70686_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound p_70014_1_) {
/* 128 */     super.func_70014_b(p_70014_1_);
/* 129 */     p_70014_1_.func_74757_a("PlayerCreated", func_70850_q());
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound p_70037_1_) {
/* 134 */     super.func_70037_a(p_70037_1_);
/* 135 */     func_70849_f(p_70037_1_.func_74767_n("PlayerCreated"));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70652_k(Entity p_70652_1_) {
/* 140 */     this.field_70855_f = 10;
/* 141 */     this.field_70170_p.func_72960_a((Entity)this, (byte)4);
/* 142 */     boolean bool = p_70652_1_.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this), (7 + this.field_70146_Z.nextInt(15)));
/* 143 */     if (bool) p_70652_1_.field_70181_x += 0.4000000059604645D; 
/* 144 */     func_85030_a("mob.irongolem.throw", 1.0F, 1.0F);
/* 145 */     return bool;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70103_a(byte p_70103_1_) {
/* 150 */     if (p_70103_1_ == 4)
/* 151 */     { this.field_70855_f = 10;
/* 152 */       func_85030_a("mob.irongolem.throw", 1.0F, 1.0F); }
/* 153 */     else if (p_70103_1_ == 11)
/* 154 */     { this.field_70856_g = 400; }
/* 155 */     else { super.func_70103_a(p_70103_1_); }
/*     */   
/*     */   }
/*     */   public Village func_70852_n() {
/* 159 */     return this.field_70857_d;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_70854_o() {
/* 163 */     return this.field_70855_f;
/*     */   }
/*     */   
/*     */   public void func_70851_e(boolean p_70851_1_) {
/* 167 */     this.field_70856_g = p_70851_1_ ? 400 : 0;
/* 168 */     this.field_70170_p.func_72960_a((Entity)this, (byte)11);
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70621_aR() {
/* 173 */     return "mob.irongolem.hit";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70673_aS() {
/* 178 */     return "mob.irongolem.death";
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
/* 183 */     func_85030_a("mob.irongolem.walk", 1.0F, 1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
/* 188 */     int i = this.field_70146_Z.nextInt(3); int j;
/* 189 */     for (j = 0; j < i; j++) {
/* 190 */       func_145778_a(Item.func_150898_a((Block)Blocks.field_150328_O), 1, 0.0F);
/*     */     }
/* 192 */     j = 3 + this.field_70146_Z.nextInt(3);
/* 193 */     for (byte b = 0; b < j; b++) {
/* 194 */       func_145779_a(Items.field_151042_j, 1);
/*     */     }
/*     */   }
/*     */   
/*     */   public int func_70853_p() {
/* 199 */     return this.field_70856_g;
/*     */   }
/*     */   
/*     */   public boolean func_70850_q() {
/* 203 */     return ((this.field_70180_af.func_75683_a(16) & 0x1) != 0);
/*     */   }
/*     */   
/*     */   public void func_70849_f(boolean p_70849_1_) {
/* 207 */     byte b = this.field_70180_af.func_75683_a(16);
/* 208 */     if (p_70849_1_) {
/* 209 */       this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)(b | 0x1)));
/*     */     } else {
/* 211 */       this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)(b & 0xFFFFFFFE)));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70645_a(DamageSource p_70645_1_) {
/* 217 */     if (!func_70850_q() && this.field_70717_bb != null && this.field_70857_d != null) {
/* 218 */       this.field_70857_d.func_82688_a(this.field_70717_bb.func_70005_c_(), -5);
/*     */     }
/* 220 */     super.func_70645_a(p_70645_1_);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\monster\EntityIronGolem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */