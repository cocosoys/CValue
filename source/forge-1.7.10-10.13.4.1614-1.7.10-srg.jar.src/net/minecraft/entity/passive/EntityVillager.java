/*     */ package net.minecraft.entity.passive;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import net.minecraft.enchantment.Enchantment;
/*     */ import net.minecraft.enchantment.EnchantmentData;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityAgeable;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.IEntityLivingData;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIAvoidEntity;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAILookAtTradePlayer;
/*     */ import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
/*     */ import net.minecraft.entity.ai.EntityAIOpenDoor;
/*     */ import net.minecraft.entity.ai.EntityAIRestrictOpenDoor;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest2;
/*     */ import net.minecraft.entity.monster.EntityZombie;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.util.ChunkCoordinates;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.Tuple;
/*     */ import net.minecraft.village.MerchantRecipe;
/*     */ import net.minecraft.village.MerchantRecipeList;
/*     */ import net.minecraft.village.Village;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityVillager extends EntityAgeable implements IMerchant, INpc {
/*     */   private int field_70955_e;
/*     */   private boolean field_70952_f;
/*     */   private boolean field_70953_g;
/*     */   Village field_70954_d;
/*     */   private EntityPlayer field_70962_h;
/*     */   private MerchantRecipeList field_70963_i;
/*     */   
/*     */   public EntityVillager(World p_i1747_1_) {
/*  50 */     this(p_i1747_1_, 0);
/*     */   }
/*     */   private int field_70961_j; private boolean field_70959_by; private int field_70956_bz; private String field_82189_bL; private boolean field_82190_bM; private float field_82191_bN;
/*     */   public EntityVillager(World p_i1748_1_, int p_i1748_2_) {
/*  54 */     super(p_i1748_1_);
/*  55 */     func_70938_b(p_i1748_2_);
/*  56 */     func_70105_a(0.6F, 1.8F);
/*     */     
/*  58 */     func_70661_as().func_75498_b(true);
/*  59 */     func_70661_as().func_75491_a(true);
/*     */     
/*  61 */     this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  62 */     this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, EntityZombie.class, 8.0F, 0.6D, 0.6D));
/*  63 */     this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAITradePlayer(this));
/*  64 */     this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAILookAtTradePlayer(this));
/*  65 */     this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIMoveIndoors((EntityCreature)this));
/*  66 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIRestrictOpenDoor((EntityCreature)this));
/*  67 */     this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIOpenDoor((EntityLiving)this, true));
/*  68 */     this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIMoveTowardsRestriction((EntityCreature)this, 0.6D));
/*  69 */     this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIVillagerMate(this));
/*  70 */     this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIFollowGolem(this));
/*  71 */     this.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAIPlay(this, 0.32D));
/*  72 */     this.field_70714_bg.func_75776_a(9, (EntityAIBase)new EntityAIWatchClosest2((EntityLiving)this, EntityPlayer.class, 3.0F, 1.0F));
/*  73 */     this.field_70714_bg.func_75776_a(9, (EntityAIBase)new EntityAIWatchClosest2((EntityLiving)this, EntityVillager.class, 5.0F, 0.02F));
/*  74 */     this.field_70714_bg.func_75776_a(9, (EntityAIBase)new EntityAIWander((EntityCreature)this, 0.6D));
/*  75 */     this.field_70714_bg.func_75776_a(10, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityLiving.class, 8.0F));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  80 */     super.func_110147_ax();
/*     */     
/*  82 */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.5D);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70650_aV() {
/*  87 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70629_bd() {
/*  92 */     if (--this.field_70955_e <= 0) {
/*  93 */       this.field_70170_p.field_72982_D.func_75551_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v));
/*  94 */       this.field_70955_e = 70 + this.field_70146_Z.nextInt(50);
/*     */       
/*  96 */       this.field_70954_d = this.field_70170_p.field_72982_D.func_75550_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v), 32);
/*  97 */       if (this.field_70954_d == null) { func_110177_bN(); }
/*     */       else
/*  99 */       { ChunkCoordinates chunkCoordinates = this.field_70954_d.func_75577_a();
/* 100 */         func_110171_b(chunkCoordinates.field_71574_a, chunkCoordinates.field_71572_b, chunkCoordinates.field_71573_c, (int)(this.field_70954_d.func_75568_b() * 0.6F));
/*     */         
/* 102 */         if (this.field_82190_bM) {
/* 103 */           this.field_82190_bM = false;
/* 104 */           this.field_70954_d.func_82683_b(5);
/*     */         }  }
/*     */     
/*     */     } 
/* 108 */     if (!func_70940_q() && this.field_70961_j > 0) {
/* 109 */       this.field_70961_j--;
/* 110 */       if (this.field_70961_j <= 0) {
/* 111 */         if (this.field_70959_by) {
/*     */ 
/*     */           
/* 114 */           if (this.field_70963_i.size() > 1) {
/* 115 */             for (MerchantRecipe merchantRecipe : this.field_70963_i) {
/* 116 */               if (merchantRecipe.func_82784_g()) {
/* 117 */                 merchantRecipe.func_82783_a(this.field_70146_Z.nextInt(6) + this.field_70146_Z.nextInt(6) + 2);
/*     */               }
/*     */             } 
/*     */           }
/*     */           
/* 122 */           func_70950_c(1);
/* 123 */           this.field_70959_by = false;
/*     */           
/* 125 */           if (this.field_70954_d != null && this.field_82189_bL != null) {
/* 126 */             this.field_70170_p.func_72960_a((Entity)this, (byte)14);
/* 127 */             this.field_70954_d.func_82688_a(this.field_82189_bL, 1);
/*     */           } 
/*     */         } 
/* 130 */         func_70690_d(new PotionEffect(Potion.field_76428_l.field_76415_H, 200, 0));
/*     */       } 
/*     */     } 
/*     */     
/* 134 */     super.func_70629_bd();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70085_c(EntityPlayer p_70085_1_) {
/* 140 */     ItemStack itemStack = p_70085_1_.field_71071_by.func_70448_g();
/* 141 */     boolean bool = (itemStack != null && itemStack.func_77973_b() == Items.field_151063_bx) ? true : false;
/*     */     
/* 143 */     if (!bool && func_70089_S() && !func_70940_q() && !func_70631_g_()) {
/* 144 */       if (!this.field_70170_p.field_72995_K) {
/*     */         
/* 146 */         func_70932_a_(p_70085_1_);
/* 147 */         p_70085_1_.func_71030_a(this, func_94057_bL());
/*     */       } 
/* 149 */       return true;
/*     */     } 
/* 151 */     return super.func_70085_c(p_70085_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/* 156 */     super.func_70088_a();
/* 157 */     this.field_70180_af.func_75682_a(16, Integer.valueOf(0));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound p_70014_1_) {
/* 162 */     super.func_70014_b(p_70014_1_);
/* 163 */     p_70014_1_.func_74768_a("Profession", func_70946_n());
/* 164 */     p_70014_1_.func_74768_a("Riches", this.field_70956_bz);
/* 165 */     if (this.field_70963_i != null) {
/* 166 */       p_70014_1_.func_74782_a("Offers", (NBTBase)this.field_70963_i.func_77202_a());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound p_70037_1_) {
/* 172 */     super.func_70037_a(p_70037_1_);
/* 173 */     func_70938_b(p_70037_1_.func_74762_e("Profession"));
/* 174 */     this.field_70956_bz = p_70037_1_.func_74762_e("Riches");
/* 175 */     if (p_70037_1_.func_150297_b("Offers", 10)) {
/* 176 */       NBTTagCompound nBTTagCompound = p_70037_1_.func_74775_l("Offers");
/* 177 */       this.field_70963_i = new MerchantRecipeList(nBTTagCompound);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean func_70692_ba() {
/* 183 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70639_aQ() {
/* 188 */     if (func_70940_q()) {
/* 189 */       return "mob.villager.haggle";
/*     */     }
/* 191 */     return "mob.villager.idle";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70621_aR() {
/* 196 */     return "mob.villager.hit";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70673_aS() {
/* 201 */     return "mob.villager.death";
/*     */   }
/*     */   
/*     */   public void func_70938_b(int p_70938_1_) {
/* 205 */     this.field_70180_af.func_75692_b(16, Integer.valueOf(p_70938_1_));
/*     */   }
/*     */   
/*     */   public int func_70946_n() {
/* 209 */     return this.field_70180_af.func_75679_c(16);
/*     */   }
/*     */   
/*     */   public boolean func_70941_o() {
/* 213 */     return this.field_70952_f;
/*     */   }
/*     */   
/*     */   public void func_70947_e(boolean p_70947_1_) {
/* 217 */     this.field_70952_f = p_70947_1_;
/*     */   }
/*     */   
/*     */   public void func_70939_f(boolean p_70939_1_) {
/* 221 */     this.field_70953_g = p_70939_1_;
/*     */   }
/*     */   
/*     */   public boolean func_70945_p() {
/* 225 */     return this.field_70953_g;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70604_c(EntityLivingBase p_70604_1_) {
/* 230 */     super.func_70604_c(p_70604_1_);
/* 231 */     if (this.field_70954_d != null && p_70604_1_ != null) {
/* 232 */       this.field_70954_d.func_75575_a(p_70604_1_);
/*     */       
/* 234 */       if (p_70604_1_ instanceof EntityPlayer) {
/* 235 */         byte b = -1;
/* 236 */         if (func_70631_g_()) {
/* 237 */           b = -3;
/*     */         }
/* 239 */         this.field_70954_d.func_82688_a(p_70604_1_.func_70005_c_(), b);
/* 240 */         if (func_70089_S()) {
/* 241 */           this.field_70170_p.func_72960_a((Entity)this, (byte)13);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70645_a(DamageSource p_70645_1_) {
/* 250 */     if (this.field_70954_d != null) {
/* 251 */       Entity entity = p_70645_1_.func_76346_g();
/* 252 */       if (entity != null) {
/* 253 */         if (entity instanceof EntityPlayer) {
/* 254 */           this.field_70954_d.func_82688_a(entity.func_70005_c_(), -2);
/* 255 */         } else if (entity instanceof net.minecraft.entity.monster.IMob) {
/* 256 */           this.field_70954_d.func_82692_h();
/*     */         } 
/* 258 */       } else if (entity == null) {
/*     */ 
/*     */         
/* 261 */         EntityPlayer entityPlayer = this.field_70170_p.func_72890_a((Entity)this, 16.0D);
/* 262 */         if (entityPlayer != null) {
/* 263 */           this.field_70954_d.func_82692_h();
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 268 */     super.func_70645_a(p_70645_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70932_a_(EntityPlayer p_70932_1_) {
/* 273 */     this.field_70962_h = p_70932_1_;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityPlayer func_70931_l_() {
/* 278 */     return this.field_70962_h;
/*     */   }
/*     */   
/*     */   public boolean func_70940_q() {
/* 282 */     return (this.field_70962_h != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70933_a(MerchantRecipe p_70933_1_) {
/* 287 */     p_70933_1_.func_77399_f();
/* 288 */     this.field_70757_a = -func_70627_aG();
/* 289 */     func_85030_a("mob.villager.yes", func_70599_aP(), func_70647_i());
/*     */ 
/*     */     
/* 292 */     if (p_70933_1_.func_77393_a((MerchantRecipe)this.field_70963_i.get(this.field_70963_i.size() - 1))) {
/* 293 */       this.field_70961_j = 40;
/* 294 */       this.field_70959_by = true;
/* 295 */       if (this.field_70962_h != null) {
/* 296 */         this.field_82189_bL = this.field_70962_h.func_70005_c_();
/*     */       } else {
/* 298 */         this.field_82189_bL = null;
/*     */       } 
/*     */     } 
/* 301 */     if (p_70933_1_.func_77394_a().func_77973_b() == Items.field_151166_bC) {
/* 302 */       this.field_70956_bz += (p_70933_1_.func_77394_a()).field_77994_a;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_110297_a_(ItemStack p_110297_1_) {
/* 308 */     if (!this.field_70170_p.field_72995_K && this.field_70757_a > -func_70627_aG() + 20) {
/* 309 */       this.field_70757_a = -func_70627_aG();
/* 310 */       if (p_110297_1_ != null) {
/* 311 */         func_85030_a("mob.villager.yes", func_70599_aP(), func_70647_i());
/*     */       } else {
/* 313 */         func_85030_a("mob.villager.no", func_70599_aP(), func_70647_i());
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public MerchantRecipeList func_70934_b(EntityPlayer p_70934_1_) {
/* 320 */     if (this.field_70963_i == null) {
/* 321 */       func_70950_c(1);
/*     */     }
/* 323 */     return this.field_70963_i;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private float func_82188_j(float p_82188_1_) {
/* 329 */     float f = p_82188_1_ + this.field_82191_bN;
/* 330 */     if (f > 0.9F) {
/* 331 */       return 0.9F - f - 0.9F;
/*     */     }
/* 333 */     return f;
/*     */   }
/*     */   
/*     */   private void func_70950_c(int p_70950_1_) {
/*     */     Item[] arrayOfItem;
/* 338 */     if (this.field_70963_i != null) {
/* 339 */       this.field_82191_bN = MathHelper.func_76129_c(this.field_70963_i.size()) * 0.2F;
/*     */     } else {
/* 341 */       this.field_82191_bN = 0.0F;
/*     */     } 
/*     */     
/* 344 */     MerchantRecipeList merchantRecipeList = new MerchantRecipeList();
/* 345 */     switch (func_70946_n()) {
/*     */       case 0:
/* 347 */         func_146091_a(merchantRecipeList, Items.field_151015_O, this.field_70146_Z, func_82188_j(0.9F));
/* 348 */         func_146091_a(merchantRecipeList, Item.func_150898_a(Blocks.field_150325_L), this.field_70146_Z, func_82188_j(0.5F));
/* 349 */         func_146091_a(merchantRecipeList, Items.field_151076_bf, this.field_70146_Z, func_82188_j(0.5F));
/* 350 */         func_146091_a(merchantRecipeList, Items.field_151101_aQ, this.field_70146_Z, func_82188_j(0.4F));
/* 351 */         func_146089_b(merchantRecipeList, Items.field_151025_P, this.field_70146_Z, func_82188_j(0.9F));
/* 352 */         func_146089_b(merchantRecipeList, Items.field_151127_ba, this.field_70146_Z, func_82188_j(0.3F));
/* 353 */         func_146089_b(merchantRecipeList, Items.field_151034_e, this.field_70146_Z, func_82188_j(0.3F));
/* 354 */         func_146089_b(merchantRecipeList, Items.field_151106_aX, this.field_70146_Z, func_82188_j(0.3F));
/* 355 */         func_146089_b(merchantRecipeList, (Item)Items.field_151097_aZ, this.field_70146_Z, func_82188_j(0.3F));
/* 356 */         func_146089_b(merchantRecipeList, Items.field_151033_d, this.field_70146_Z, func_82188_j(0.3F));
/* 357 */         func_146089_b(merchantRecipeList, Items.field_151077_bg, this.field_70146_Z, func_82188_j(0.3F));
/* 358 */         func_146089_b(merchantRecipeList, Items.field_151032_g, this.field_70146_Z, func_82188_j(0.5F));
/* 359 */         if (this.field_70146_Z.nextFloat() < func_82188_j(0.5F)) {
/* 360 */           merchantRecipeList.add(new MerchantRecipe(new ItemStack(Blocks.field_150351_n, 10), new ItemStack(Items.field_151166_bC), new ItemStack(Items.field_151145_ak, 4 + this.field_70146_Z.nextInt(2), 0)));
/*     */         }
/*     */         break;
/*     */       case 4:
/* 364 */         func_146091_a(merchantRecipeList, Items.field_151044_h, this.field_70146_Z, func_82188_j(0.7F));
/* 365 */         func_146091_a(merchantRecipeList, Items.field_151147_al, this.field_70146_Z, func_82188_j(0.5F));
/* 366 */         func_146091_a(merchantRecipeList, Items.field_151082_bd, this.field_70146_Z, func_82188_j(0.5F));
/* 367 */         func_146089_b(merchantRecipeList, Items.field_151141_av, this.field_70146_Z, func_82188_j(0.1F));
/* 368 */         func_146089_b(merchantRecipeList, (Item)Items.field_151027_R, this.field_70146_Z, func_82188_j(0.3F));
/* 369 */         func_146089_b(merchantRecipeList, (Item)Items.field_151021_T, this.field_70146_Z, func_82188_j(0.3F));
/* 370 */         func_146089_b(merchantRecipeList, (Item)Items.field_151024_Q, this.field_70146_Z, func_82188_j(0.3F));
/* 371 */         func_146089_b(merchantRecipeList, (Item)Items.field_151026_S, this.field_70146_Z, func_82188_j(0.3F));
/* 372 */         func_146089_b(merchantRecipeList, Items.field_151157_am, this.field_70146_Z, func_82188_j(0.3F));
/* 373 */         func_146089_b(merchantRecipeList, Items.field_151083_be, this.field_70146_Z, func_82188_j(0.3F));
/*     */         break;
/*     */       case 3:
/* 376 */         func_146091_a(merchantRecipeList, Items.field_151044_h, this.field_70146_Z, func_82188_j(0.7F));
/* 377 */         func_146091_a(merchantRecipeList, Items.field_151042_j, this.field_70146_Z, func_82188_j(0.5F));
/* 378 */         func_146091_a(merchantRecipeList, Items.field_151043_k, this.field_70146_Z, func_82188_j(0.5F));
/* 379 */         func_146091_a(merchantRecipeList, Items.field_151045_i, this.field_70146_Z, func_82188_j(0.5F));
/*     */         
/* 381 */         func_146089_b(merchantRecipeList, Items.field_151040_l, this.field_70146_Z, func_82188_j(0.5F));
/* 382 */         func_146089_b(merchantRecipeList, Items.field_151048_u, this.field_70146_Z, func_82188_j(0.5F));
/* 383 */         func_146089_b(merchantRecipeList, Items.field_151036_c, this.field_70146_Z, func_82188_j(0.3F));
/* 384 */         func_146089_b(merchantRecipeList, Items.field_151056_x, this.field_70146_Z, func_82188_j(0.3F));
/* 385 */         func_146089_b(merchantRecipeList, Items.field_151035_b, this.field_70146_Z, func_82188_j(0.5F));
/* 386 */         func_146089_b(merchantRecipeList, Items.field_151046_w, this.field_70146_Z, func_82188_j(0.5F));
/* 387 */         func_146089_b(merchantRecipeList, Items.field_151037_a, this.field_70146_Z, func_82188_j(0.2F));
/* 388 */         func_146089_b(merchantRecipeList, Items.field_151047_v, this.field_70146_Z, func_82188_j(0.2F));
/* 389 */         func_146089_b(merchantRecipeList, Items.field_151019_K, this.field_70146_Z, func_82188_j(0.2F));
/* 390 */         func_146089_b(merchantRecipeList, Items.field_151012_L, this.field_70146_Z, func_82188_j(0.2F));
/* 391 */         func_146089_b(merchantRecipeList, (Item)Items.field_151167_ab, this.field_70146_Z, func_82188_j(0.2F));
/* 392 */         func_146089_b(merchantRecipeList, (Item)Items.field_151175_af, this.field_70146_Z, func_82188_j(0.2F));
/* 393 */         func_146089_b(merchantRecipeList, (Item)Items.field_151028_Y, this.field_70146_Z, func_82188_j(0.2F));
/* 394 */         func_146089_b(merchantRecipeList, (Item)Items.field_151161_ac, this.field_70146_Z, func_82188_j(0.2F));
/* 395 */         func_146089_b(merchantRecipeList, (Item)Items.field_151030_Z, this.field_70146_Z, func_82188_j(0.2F));
/* 396 */         func_146089_b(merchantRecipeList, (Item)Items.field_151163_ad, this.field_70146_Z, func_82188_j(0.2F));
/* 397 */         func_146089_b(merchantRecipeList, (Item)Items.field_151165_aa, this.field_70146_Z, func_82188_j(0.2F));
/* 398 */         func_146089_b(merchantRecipeList, (Item)Items.field_151173_ae, this.field_70146_Z, func_82188_j(0.2F));
/* 399 */         func_146089_b(merchantRecipeList, (Item)Items.field_151029_X, this.field_70146_Z, func_82188_j(0.1F));
/* 400 */         func_146089_b(merchantRecipeList, (Item)Items.field_151020_U, this.field_70146_Z, func_82188_j(0.1F));
/* 401 */         func_146089_b(merchantRecipeList, (Item)Items.field_151023_V, this.field_70146_Z, func_82188_j(0.1F));
/* 402 */         func_146089_b(merchantRecipeList, (Item)Items.field_151022_W, this.field_70146_Z, func_82188_j(0.1F));
/*     */         break;
/*     */       case 1:
/* 405 */         func_146091_a(merchantRecipeList, Items.field_151121_aF, this.field_70146_Z, func_82188_j(0.8F));
/* 406 */         func_146091_a(merchantRecipeList, Items.field_151122_aG, this.field_70146_Z, func_82188_j(0.8F));
/* 407 */         func_146091_a(merchantRecipeList, Items.field_151164_bB, this.field_70146_Z, func_82188_j(0.3F));
/* 408 */         func_146089_b(merchantRecipeList, Item.func_150898_a(Blocks.field_150342_X), this.field_70146_Z, func_82188_j(0.8F));
/* 409 */         func_146089_b(merchantRecipeList, Item.func_150898_a(Blocks.field_150359_w), this.field_70146_Z, func_82188_j(0.2F));
/* 410 */         func_146089_b(merchantRecipeList, Items.field_151111_aL, this.field_70146_Z, func_82188_j(0.2F));
/* 411 */         func_146089_b(merchantRecipeList, Items.field_151113_aN, this.field_70146_Z, func_82188_j(0.2F));
/*     */         
/* 413 */         if (this.field_70146_Z.nextFloat() < func_82188_j(0.07F)) {
/* 414 */           Enchantment enchantment = Enchantment.field_92090_c[this.field_70146_Z.nextInt(Enchantment.field_92090_c.length)];
/* 415 */           int i = MathHelper.func_76136_a(this.field_70146_Z, enchantment.func_77319_d(), enchantment.func_77325_b());
/* 416 */           ItemStack itemStack = Items.field_151134_bR.func_92111_a(new EnchantmentData(enchantment, i));
/* 417 */           int j = 2 + this.field_70146_Z.nextInt(5 + i * 10) + 3 * i;
/*     */           
/* 419 */           merchantRecipeList.add(new MerchantRecipe(new ItemStack(Items.field_151122_aG), new ItemStack(Items.field_151166_bC, j), itemStack));
/*     */         } 
/*     */         break;
/*     */       case 2:
/* 423 */         func_146089_b(merchantRecipeList, Items.field_151061_bv, this.field_70146_Z, func_82188_j(0.3F));
/* 424 */         func_146089_b(merchantRecipeList, Items.field_151062_by, this.field_70146_Z, func_82188_j(0.2F));
/* 425 */         func_146089_b(merchantRecipeList, Items.field_151137_ax, this.field_70146_Z, func_82188_j(0.4F));
/* 426 */         func_146089_b(merchantRecipeList, Item.func_150898_a(Blocks.field_150426_aN), this.field_70146_Z, func_82188_j(0.3F));
/*     */         
/* 428 */         arrayOfItem = new Item[] { Items.field_151040_l, Items.field_151048_u, (Item)Items.field_151030_Z, (Item)Items.field_151163_ad, Items.field_151036_c, Items.field_151056_x, Items.field_151035_b, Items.field_151046_w };
/*     */         
/* 430 */         for (Item item : arrayOfItem) {
/* 431 */           if (this.field_70146_Z.nextFloat() < func_82188_j(0.05F)) {
/* 432 */             merchantRecipeList.add(new MerchantRecipe(new ItemStack(item, 1, 0), new ItemStack(Items.field_151166_bC, 2 + this.field_70146_Z.nextInt(3), 0), EnchantmentHelper.func_77504_a(this.field_70146_Z, new ItemStack(item, 1, 0), 5 + this.field_70146_Z.nextInt(15))));
/*     */           }
/*     */         } 
/*     */         break;
/*     */     } 
/*     */ 
/*     */     
/* 439 */     if (merchantRecipeList.isEmpty()) {
/* 440 */       func_146091_a(merchantRecipeList, Items.field_151043_k, this.field_70146_Z, 1.0F);
/*     */     }
/*     */ 
/*     */     
/* 444 */     Collections.shuffle((List<?>)merchantRecipeList);
/*     */     
/* 446 */     if (this.field_70963_i == null) {
/* 447 */       this.field_70963_i = new MerchantRecipeList();
/*     */     }
/* 449 */     for (byte b = 0; b < p_70950_1_ && b < merchantRecipeList.size(); b++) {
/* 450 */       this.field_70963_i.func_77205_a((MerchantRecipe)merchantRecipeList.get(b));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70930_a(MerchantRecipeList p_70930_1_) {}
/*     */   
/* 458 */   public static final Map field_70958_bB = new HashMap<Object, Object>();
/* 459 */   public static final Map field_70960_bC = new HashMap<Object, Object>(); private static final String __OBFID = "CL_00001707";
/*     */   static {
/* 461 */     field_70958_bB.put(Items.field_151044_h, new Tuple(Integer.valueOf(16), Integer.valueOf(24)));
/* 462 */     field_70958_bB.put(Items.field_151042_j, new Tuple(Integer.valueOf(8), Integer.valueOf(10)));
/* 463 */     field_70958_bB.put(Items.field_151043_k, new Tuple(Integer.valueOf(8), Integer.valueOf(10)));
/* 464 */     field_70958_bB.put(Items.field_151045_i, new Tuple(Integer.valueOf(4), Integer.valueOf(6)));
/* 465 */     field_70958_bB.put(Items.field_151121_aF, new Tuple(Integer.valueOf(24), Integer.valueOf(36)));
/* 466 */     field_70958_bB.put(Items.field_151122_aG, new Tuple(Integer.valueOf(11), Integer.valueOf(13)));
/* 467 */     field_70958_bB.put(Items.field_151164_bB, new Tuple(Integer.valueOf(1), Integer.valueOf(1)));
/* 468 */     field_70958_bB.put(Items.field_151079_bi, new Tuple(Integer.valueOf(3), Integer.valueOf(4)));
/* 469 */     field_70958_bB.put(Items.field_151061_bv, new Tuple(Integer.valueOf(2), Integer.valueOf(3)));
/* 470 */     field_70958_bB.put(Items.field_151147_al, new Tuple(Integer.valueOf(14), Integer.valueOf(18)));
/* 471 */     field_70958_bB.put(Items.field_151082_bd, new Tuple(Integer.valueOf(14), Integer.valueOf(18)));
/* 472 */     field_70958_bB.put(Items.field_151076_bf, new Tuple(Integer.valueOf(14), Integer.valueOf(18)));
/* 473 */     field_70958_bB.put(Items.field_151101_aQ, new Tuple(Integer.valueOf(9), Integer.valueOf(13)));
/* 474 */     field_70958_bB.put(Items.field_151014_N, new Tuple(Integer.valueOf(34), Integer.valueOf(48)));
/* 475 */     field_70958_bB.put(Items.field_151081_bc, new Tuple(Integer.valueOf(30), Integer.valueOf(38)));
/* 476 */     field_70958_bB.put(Items.field_151080_bb, new Tuple(Integer.valueOf(30), Integer.valueOf(38)));
/* 477 */     field_70958_bB.put(Items.field_151015_O, new Tuple(Integer.valueOf(18), Integer.valueOf(22)));
/* 478 */     field_70958_bB.put(Item.func_150898_a(Blocks.field_150325_L), new Tuple(Integer.valueOf(14), Integer.valueOf(22)));
/* 479 */     field_70958_bB.put(Items.field_151078_bh, new Tuple(Integer.valueOf(36), Integer.valueOf(64)));
/*     */     
/* 481 */     field_70960_bC.put(Items.field_151033_d, new Tuple(Integer.valueOf(3), Integer.valueOf(4)));
/* 482 */     field_70960_bC.put(Items.field_151097_aZ, new Tuple(Integer.valueOf(3), Integer.valueOf(4)));
/* 483 */     field_70960_bC.put(Items.field_151040_l, new Tuple(Integer.valueOf(7), Integer.valueOf(11)));
/* 484 */     field_70960_bC.put(Items.field_151048_u, new Tuple(Integer.valueOf(12), Integer.valueOf(14)));
/* 485 */     field_70960_bC.put(Items.field_151036_c, new Tuple(Integer.valueOf(6), Integer.valueOf(8)));
/* 486 */     field_70960_bC.put(Items.field_151056_x, new Tuple(Integer.valueOf(9), Integer.valueOf(12)));
/* 487 */     field_70960_bC.put(Items.field_151035_b, new Tuple(Integer.valueOf(7), Integer.valueOf(9)));
/* 488 */     field_70960_bC.put(Items.field_151046_w, new Tuple(Integer.valueOf(10), Integer.valueOf(12)));
/* 489 */     field_70960_bC.put(Items.field_151037_a, new Tuple(Integer.valueOf(4), Integer.valueOf(6)));
/* 490 */     field_70960_bC.put(Items.field_151047_v, new Tuple(Integer.valueOf(7), Integer.valueOf(8)));
/* 491 */     field_70960_bC.put(Items.field_151019_K, new Tuple(Integer.valueOf(4), Integer.valueOf(6)));
/* 492 */     field_70960_bC.put(Items.field_151012_L, new Tuple(Integer.valueOf(7), Integer.valueOf(8)));
/* 493 */     field_70960_bC.put(Items.field_151167_ab, new Tuple(Integer.valueOf(4), Integer.valueOf(6)));
/* 494 */     field_70960_bC.put(Items.field_151175_af, new Tuple(Integer.valueOf(7), Integer.valueOf(8)));
/* 495 */     field_70960_bC.put(Items.field_151028_Y, new Tuple(Integer.valueOf(4), Integer.valueOf(6)));
/* 496 */     field_70960_bC.put(Items.field_151161_ac, new Tuple(Integer.valueOf(7), Integer.valueOf(8)));
/* 497 */     field_70960_bC.put(Items.field_151030_Z, new Tuple(Integer.valueOf(10), Integer.valueOf(14)));
/* 498 */     field_70960_bC.put(Items.field_151163_ad, new Tuple(Integer.valueOf(16), Integer.valueOf(19)));
/* 499 */     field_70960_bC.put(Items.field_151165_aa, new Tuple(Integer.valueOf(8), Integer.valueOf(10)));
/* 500 */     field_70960_bC.put(Items.field_151173_ae, new Tuple(Integer.valueOf(11), Integer.valueOf(14)));
/* 501 */     field_70960_bC.put(Items.field_151029_X, new Tuple(Integer.valueOf(5), Integer.valueOf(7)));
/* 502 */     field_70960_bC.put(Items.field_151020_U, new Tuple(Integer.valueOf(5), Integer.valueOf(7)));
/* 503 */     field_70960_bC.put(Items.field_151023_V, new Tuple(Integer.valueOf(11), Integer.valueOf(15)));
/* 504 */     field_70960_bC.put(Items.field_151022_W, new Tuple(Integer.valueOf(9), Integer.valueOf(11)));
/* 505 */     field_70960_bC.put(Items.field_151025_P, new Tuple(Integer.valueOf(-4), Integer.valueOf(-2)));
/* 506 */     field_70960_bC.put(Items.field_151127_ba, new Tuple(Integer.valueOf(-8), Integer.valueOf(-4)));
/* 507 */     field_70960_bC.put(Items.field_151034_e, new Tuple(Integer.valueOf(-8), Integer.valueOf(-4)));
/* 508 */     field_70960_bC.put(Items.field_151106_aX, new Tuple(Integer.valueOf(-10), Integer.valueOf(-7)));
/* 509 */     field_70960_bC.put(Item.func_150898_a(Blocks.field_150359_w), new Tuple(Integer.valueOf(-5), Integer.valueOf(-3)));
/* 510 */     field_70960_bC.put(Item.func_150898_a(Blocks.field_150342_X), new Tuple(Integer.valueOf(3), Integer.valueOf(4)));
/* 511 */     field_70960_bC.put(Items.field_151027_R, new Tuple(Integer.valueOf(4), Integer.valueOf(5)));
/* 512 */     field_70960_bC.put(Items.field_151021_T, new Tuple(Integer.valueOf(2), Integer.valueOf(4)));
/* 513 */     field_70960_bC.put(Items.field_151024_Q, new Tuple(Integer.valueOf(2), Integer.valueOf(4)));
/* 514 */     field_70960_bC.put(Items.field_151026_S, new Tuple(Integer.valueOf(2), Integer.valueOf(4)));
/* 515 */     field_70960_bC.put(Items.field_151141_av, new Tuple(Integer.valueOf(6), Integer.valueOf(8)));
/* 516 */     field_70960_bC.put(Items.field_151062_by, new Tuple(Integer.valueOf(-4), Integer.valueOf(-1)));
/* 517 */     field_70960_bC.put(Items.field_151137_ax, new Tuple(Integer.valueOf(-4), Integer.valueOf(-1)));
/* 518 */     field_70960_bC.put(Items.field_151111_aL, new Tuple(Integer.valueOf(10), Integer.valueOf(12)));
/* 519 */     field_70960_bC.put(Items.field_151113_aN, new Tuple(Integer.valueOf(10), Integer.valueOf(12)));
/* 520 */     field_70960_bC.put(Item.func_150898_a(Blocks.field_150426_aN), new Tuple(Integer.valueOf(-3), Integer.valueOf(-1)));
/* 521 */     field_70960_bC.put(Items.field_151157_am, new Tuple(Integer.valueOf(-7), Integer.valueOf(-5)));
/* 522 */     field_70960_bC.put(Items.field_151083_be, new Tuple(Integer.valueOf(-7), Integer.valueOf(-5)));
/* 523 */     field_70960_bC.put(Items.field_151077_bg, new Tuple(Integer.valueOf(-8), Integer.valueOf(-6)));
/* 524 */     field_70960_bC.put(Items.field_151061_bv, new Tuple(Integer.valueOf(7), Integer.valueOf(11)));
/* 525 */     field_70960_bC.put(Items.field_151032_g, new Tuple(Integer.valueOf(-12), Integer.valueOf(-8)));
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
/*     */   public static void func_146091_a(MerchantRecipeList p_146091_0_, Item p_146091_1_, Random p_146091_2_, float p_146091_3_) {
/* 537 */     if (p_146091_2_.nextFloat() < p_146091_3_) {
/* 538 */       p_146091_0_.add(new MerchantRecipe(func_146088_a(p_146091_1_, p_146091_2_), Items.field_151166_bC));
/*     */     }
/*     */   }
/*     */   
/*     */   private static ItemStack func_146088_a(Item p_146088_0_, Random p_146088_1_) {
/* 543 */     return new ItemStack(p_146088_0_, func_146092_b(p_146088_0_, p_146088_1_), 0);
/*     */   }
/*     */   
/*     */   private static int func_146092_b(Item p_146092_0_, Random p_146092_1_) {
/* 547 */     Tuple tuple = (Tuple)field_70958_bB.get(p_146092_0_);
/* 548 */     if (tuple == null) {
/* 549 */       return 1;
/*     */     }
/* 551 */     if (((Integer)tuple.func_76341_a()).intValue() >= ((Integer)tuple.func_76340_b()).intValue()) {
/* 552 */       return ((Integer)tuple.func_76341_a()).intValue();
/*     */     }
/* 554 */     return ((Integer)tuple.func_76341_a()).intValue() + p_146092_1_.nextInt(((Integer)tuple.func_76340_b()).intValue() - ((Integer)tuple.func_76341_a()).intValue());
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
/*     */   public static void func_146089_b(MerchantRecipeList p_146089_0_, Item p_146089_1_, Random p_146089_2_, float p_146089_3_) {
/* 567 */     if (p_146089_2_.nextFloat() < p_146089_3_) {
/* 568 */       ItemStack itemStack1, itemStack2; int i = func_146090_c(p_146089_1_, p_146089_2_);
/*     */ 
/*     */       
/* 571 */       if (i < 0) {
/* 572 */         itemStack1 = new ItemStack(Items.field_151166_bC, 1, 0);
/* 573 */         itemStack2 = new ItemStack(p_146089_1_, -i, 0);
/*     */       } else {
/* 575 */         itemStack1 = new ItemStack(Items.field_151166_bC, i, 0);
/* 576 */         itemStack2 = new ItemStack(p_146089_1_, 1, 0);
/*     */       } 
/* 578 */       p_146089_0_.add(new MerchantRecipe(itemStack1, itemStack2));
/*     */     } 
/*     */   }
/*     */   
/*     */   private static int func_146090_c(Item p_146090_0_, Random p_146090_1_) {
/* 583 */     Tuple tuple = (Tuple)field_70960_bC.get(p_146090_0_);
/* 584 */     if (tuple == null) {
/* 585 */       return 1;
/*     */     }
/* 587 */     if (((Integer)tuple.func_76341_a()).intValue() >= ((Integer)tuple.func_76340_b()).intValue()) {
/* 588 */       return ((Integer)tuple.func_76341_a()).intValue();
/*     */     }
/* 590 */     return ((Integer)tuple.func_76341_a()).intValue() + p_146090_1_.nextInt(((Integer)tuple.func_76340_b()).intValue() - ((Integer)tuple.func_76341_a()).intValue());
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70103_a(byte p_70103_1_) {
/* 595 */     if (p_70103_1_ == 12) {
/* 596 */       func_70942_a("heart");
/* 597 */     } else if (p_70103_1_ == 13) {
/* 598 */       func_70942_a("angryVillager");
/* 599 */     } else if (p_70103_1_ == 14) {
/* 600 */       func_70942_a("happyVillager");
/*     */     } else {
/* 602 */       super.func_70103_a(p_70103_1_);
/*     */     } 
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   private void func_70942_a(String p_70942_1_) {
/* 607 */     for (byte b = 0; b < 5; b++) {
/* 608 */       double d1 = this.field_70146_Z.nextGaussian() * 0.02D;
/* 609 */       double d2 = this.field_70146_Z.nextGaussian() * 0.02D;
/* 610 */       double d3 = this.field_70146_Z.nextGaussian() * 0.02D;
/* 611 */       this.field_70170_p.func_72869_a(p_70942_1_, this.field_70165_t + (this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0F) - this.field_70130_N, this.field_70163_u + 1.0D + (this.field_70146_Z.nextFloat() * this.field_70131_O), this.field_70161_v + (this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0F) - this.field_70130_N, d1, d2, d3);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public IEntityLivingData func_110161_a(IEntityLivingData p_110161_1_) {
/* 617 */     p_110161_1_ = super.func_110161_a(p_110161_1_);
/*     */     
/* 619 */     func_70938_b(this.field_70170_p.field_73012_v.nextInt(5));
/*     */     
/* 621 */     return p_110161_1_;
/*     */   }
/*     */   
/*     */   public void func_82187_q() {
/* 625 */     this.field_82190_bM = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityVillager func_90011_a(EntityAgeable p_90011_1_) {
/* 630 */     EntityVillager entityVillager = new EntityVillager(this.field_70170_p);
/* 631 */     entityVillager.func_110161_a((IEntityLivingData)null);
/* 632 */     return entityVillager;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_110164_bC() {
/* 637 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\passive\EntityVillager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */