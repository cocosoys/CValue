/*     */ package net.minecraft.entity.passive;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.entity.EntityAgeable;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.IEntityLivingData;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAIEatGrass;
/*     */ import net.minecraft.entity.ai.EntityAIFollowParent;
/*     */ import net.minecraft.entity.ai.EntityAIMate;
/*     */ import net.minecraft.entity.ai.EntityAIWander;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.inventory.InventoryCrafting;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntitySheep extends EntityAnimal {
/*  28 */   private final InventoryCrafting field_90016_e = new InventoryCrafting(new Container(this) { private static final String __OBFID = "CL_00001649";
/*     */         
/*     */         public boolean func_75145_c(EntityPlayer p_75145_1_) {
/*  31 */           return false;
/*     */         }
/*     */       },  2, 1);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  38 */   public static final float[][] field_70898_d = new float[][] { { 1.0F, 1.0F, 1.0F }, { 0.85F, 0.5F, 0.2F }, { 0.7F, 0.3F, 0.85F }, { 0.4F, 0.6F, 0.85F }, { 0.9F, 0.9F, 0.2F }, { 0.5F, 0.8F, 0.1F }, { 0.95F, 0.5F, 0.65F }, { 0.3F, 0.3F, 0.3F }, { 0.6F, 0.6F, 0.6F }, { 0.3F, 0.5F, 0.6F }, { 0.5F, 0.25F, 0.7F }, { 0.2F, 0.3F, 0.7F }, { 0.4F, 0.3F, 0.2F }, { 0.4F, 0.5F, 0.2F }, { 0.6F, 0.2F, 0.2F }, { 0.1F, 0.1F, 0.1F } };
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
/*     */   
/*     */   private int field_70899_e;
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
/*  61 */   private EntityAIEatGrass field_146087_bs = new EntityAIEatGrass((EntityLiving)this); private static final String __OBFID = "CL_00001648";
/*     */   
/*     */   public EntitySheep(World p_i1691_1_) {
/*  64 */     super(p_i1691_1_);
/*  65 */     func_70105_a(0.9F, 1.3F);
/*     */     
/*  67 */     func_70661_as().func_75491_a(true);
/*  68 */     this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  69 */     this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.25D));
/*  70 */     this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIMate(this, 1.0D));
/*  71 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.1D, Items.field_151015_O, false));
/*  72 */     this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIFollowParent(this, 1.1D));
/*  73 */     this.field_70714_bg.func_75776_a(5, (EntityAIBase)this.field_146087_bs);
/*  74 */     this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0D));
/*  75 */     this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 6.0F));
/*  76 */     this.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*     */     
/*  78 */     this.field_90016_e.func_70299_a(0, new ItemStack(Items.field_151100_aR, 1, 0));
/*  79 */     this.field_90016_e.func_70299_a(1, new ItemStack(Items.field_151100_aR, 1, 0));
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean func_70650_aV() {
/*  84 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70619_bc() {
/*  89 */     this.field_70899_e = this.field_146087_bs.func_151499_f();
/*  90 */     super.func_70619_bc();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/*  95 */     if (this.field_70170_p.field_72995_K) this.field_70899_e = Math.max(0, this.field_70899_e - 1); 
/*  96 */     super.func_70636_d();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/* 101 */     super.func_110147_ax();
/*     */     
/* 103 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(8.0D);
/* 104 */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.23000000417232513D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/* 109 */     super.func_70088_a();
/*     */ 
/*     */     
/* 112 */     this.field_70180_af.func_75682_a(16, new Byte((byte)0));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
/* 117 */     if (!func_70892_o())
/*     */     {
/* 119 */       func_70099_a(new ItemStack(Item.func_150898_a(Blocks.field_150325_L), 1, func_70896_n()), 0.0F);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected Item func_146068_u() {
/* 125 */     return Item.func_150898_a(Blocks.field_150325_L);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70103_a(byte p_70103_1_) {
/* 130 */     if (p_70103_1_ == 10) {
/* 131 */       this.field_70899_e = 40;
/*     */     } else {
/* 133 */       super.func_70103_a(p_70103_1_);
/*     */     } 
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_70894_j(float p_70894_1_) {
/* 138 */     if (this.field_70899_e <= 0) {
/* 139 */       return 0.0F;
/*     */     }
/* 141 */     if (this.field_70899_e >= 4 && this.field_70899_e <= 36) {
/* 142 */       return 1.0F;
/*     */     }
/* 144 */     if (this.field_70899_e < 4) {
/* 145 */       return (this.field_70899_e - p_70894_1_) / 4.0F;
/*     */     }
/* 147 */     return -((this.field_70899_e - 40) - p_70894_1_) / 4.0F;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_70890_k(float p_70890_1_) {
/* 151 */     if (this.field_70899_e > 4 && this.field_70899_e <= 36) {
/* 152 */       float f = ((this.field_70899_e - 4) - p_70890_1_) / 32.0F;
/* 153 */       return 0.62831855F + 0.21991149F * MathHelper.func_76126_a(f * 28.7F);
/*     */     } 
/* 155 */     if (this.field_70899_e > 0) {
/* 156 */       return 0.62831855F;
/*     */     }
/* 158 */     return this.field_70125_A / 57.295776F;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70085_c(EntityPlayer p_70085_1_) {
/* 163 */     ItemStack itemStack = p_70085_1_.field_71071_by.func_70448_g();
/*     */     
/* 165 */     if (itemStack != null && itemStack.func_77973_b() == Items.field_151097_aZ && !func_70892_o() && !func_70631_g_()) {
/* 166 */       if (!this.field_70170_p.field_72995_K) {
/* 167 */         func_70893_e(true);
/* 168 */         int i = 1 + this.field_70146_Z.nextInt(3);
/* 169 */         for (byte b = 0; b < i; b++) {
/* 170 */           EntityItem entityItem = func_70099_a(new ItemStack(Item.func_150898_a(Blocks.field_150325_L), 1, func_70896_n()), 1.0F);
/* 171 */           entityItem.field_70181_x += (this.field_70146_Z.nextFloat() * 0.05F);
/* 172 */           entityItem.field_70159_w += ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.1F);
/* 173 */           entityItem.field_70179_y += ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.1F);
/*     */         } 
/*     */       } 
/* 176 */       itemStack.func_77972_a(1, (EntityLivingBase)p_70085_1_);
/* 177 */       func_85030_a("mob.sheep.shear", 1.0F, 1.0F);
/*     */     } 
/*     */     
/* 180 */     return super.func_70085_c(p_70085_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound p_70014_1_) {
/* 185 */     super.func_70014_b(p_70014_1_);
/* 186 */     p_70014_1_.func_74757_a("Sheared", func_70892_o());
/* 187 */     p_70014_1_.func_74774_a("Color", (byte)func_70896_n());
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound p_70037_1_) {
/* 192 */     super.func_70037_a(p_70037_1_);
/* 193 */     func_70893_e(p_70037_1_.func_74767_n("Sheared"));
/* 194 */     func_70891_b(p_70037_1_.func_74771_c("Color"));
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70639_aQ() {
/* 199 */     return "mob.sheep.say";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70621_aR() {
/* 204 */     return "mob.sheep.say";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70673_aS() {
/* 209 */     return "mob.sheep.say";
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
/* 214 */     func_85030_a("mob.sheep.step", 0.15F, 1.0F);
/*     */   }
/*     */   
/*     */   public int func_70896_n() {
/* 218 */     return this.field_70180_af.func_75683_a(16) & 0xF;
/*     */   }
/*     */   
/*     */   public void func_70891_b(int p_70891_1_) {
/* 222 */     byte b = this.field_70180_af.func_75683_a(16);
/* 223 */     this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)(b & 0xF0 | p_70891_1_ & 0xF)));
/*     */   }
/*     */   
/*     */   public boolean func_70892_o() {
/* 227 */     return ((this.field_70180_af.func_75683_a(16) & 0x10) != 0);
/*     */   }
/*     */   
/*     */   public void func_70893_e(boolean p_70893_1_) {
/* 231 */     byte b = this.field_70180_af.func_75683_a(16);
/* 232 */     if (p_70893_1_) {
/* 233 */       this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)(b | 0x10)));
/*     */     } else {
/* 235 */       this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)(b & 0xFFFFFFEF)));
/*     */     } 
/*     */   }
/*     */   
/*     */   public static int func_70895_a(Random p_70895_0_) {
/* 240 */     int i = p_70895_0_.nextInt(100);
/* 241 */     if (i < 5) {
/* 242 */       return 15;
/*     */     }
/* 244 */     if (i < 10) {
/* 245 */       return 7;
/*     */     }
/* 247 */     if (i < 15) {
/* 248 */       return 8;
/*     */     }
/* 250 */     if (i < 18) {
/* 251 */       return 12;
/*     */     }
/* 253 */     if (p_70895_0_.nextInt(500) == 0) return 6; 
/* 254 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntitySheep func_90011_a(EntityAgeable p_90011_1_) {
/* 259 */     EntitySheep entitySheep1 = (EntitySheep)p_90011_1_;
/* 260 */     EntitySheep entitySheep2 = new EntitySheep(this.field_70170_p);
/*     */     
/* 262 */     int i = func_90014_a(this, entitySheep1);
/* 263 */     entitySheep2.func_70891_b(15 - i);
/*     */     
/* 265 */     return entitySheep2;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70615_aA() {
/* 270 */     func_70893_e(false);
/* 271 */     if (func_70631_g_())
/*     */     {
/* 273 */       func_110195_a(60);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IEntityLivingData func_110161_a(IEntityLivingData p_110161_1_) {
/* 279 */     p_110161_1_ = super.func_110161_a(p_110161_1_);
/*     */     
/* 281 */     func_70891_b(func_70895_a(this.field_70170_p.field_73012_v));
/* 282 */     return p_110161_1_;
/*     */   }
/*     */   
/*     */   private int func_90014_a(EntityAnimal p_90014_1_, EntityAnimal p_90014_2_) {
/* 286 */     int k, i = func_90013_b(p_90014_1_);
/* 287 */     int j = func_90013_b(p_90014_2_);
/*     */     
/* 289 */     this.field_90016_e.func_70301_a(0).func_77964_b(i);
/* 290 */     this.field_90016_e.func_70301_a(1).func_77964_b(j);
/*     */     
/* 292 */     ItemStack itemStack = CraftingManager.func_77594_a().func_82787_a(this.field_90016_e, ((EntitySheep)p_90014_1_).field_70170_p);
/*     */ 
/*     */     
/* 295 */     if (itemStack != null && itemStack.func_77973_b() == Items.field_151100_aR) {
/* 296 */       k = itemStack.func_77960_j();
/*     */     } else {
/* 298 */       k = this.field_70170_p.field_73012_v.nextBoolean() ? i : j;
/*     */     } 
/* 300 */     return k;
/*     */   }
/*     */   
/*     */   private int func_90013_b(EntityAnimal p_90013_1_) {
/* 304 */     return 15 - ((EntitySheep)p_90013_1_).func_70896_n();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\passive\EntitySheep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */