/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.JRMCoreH2;
/*     */ import cpw.mods.fml.common.registry.VillagerRegistry;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityAgeable;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.IMerchant;
/*     */ import net.minecraft.entity.INpc;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIAvoidEntity;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAIFollowGolem;
/*     */ import net.minecraft.entity.ai.EntityAILookAtTradePlayer;
/*     */ import net.minecraft.entity.ai.EntityAIMoveIndoors;
/*     */ import net.minecraft.entity.ai.EntityAIOpenDoor;
/*     */ import net.minecraft.entity.ai.EntityAIPlay;
/*     */ import net.minecraft.entity.ai.EntityAIRestrictOpenDoor;
/*     */ import net.minecraft.entity.ai.EntityAISwimming;
/*     */ import net.minecraft.entity.ai.EntityAITradePlayer;
/*     */ import net.minecraft.entity.ai.EntityAIVillagerMate;
/*     */ import net.minecraft.entity.ai.EntityAIWander;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest2;
/*     */ import net.minecraft.entity.monster.EntityZombie;
/*     */ import net.minecraft.entity.passive.EntityVillager;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.util.ChunkCoordinates;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.Tuple;
/*     */ import net.minecraft.village.MerchantRecipe;
/*     */ import net.minecraft.village.MerchantRecipeList;
/*     */ import net.minecraft.village.Village;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityNamekian03 extends EntityVillager implements INpc, IMerchant {
/*  53 */   public final int AttPow = 30;
/*  54 */   public final int HePo = 300;
/*     */ 
/*     */   
/*     */   private int randomTickDivider;
/*     */   
/*     */   private boolean isMating;
/*     */   
/*     */   private boolean isPlaying;
/*     */   
/*     */   Village field_70954_d;
/*     */   
/*     */   private EntityPlayer buyingPlayer;
/*     */   
/*     */   private MerchantRecipeList buyingList;
/*     */   
/*     */   private int timeUntilReset;
/*     */   
/*     */   private boolean needsInitilization;
/*     */   
/*     */   private int wealth;
/*     */   
/*     */   private String lastBuyingPlayer;
/*     */   
/*     */   private boolean field_82190_bM;
/*     */   
/*     */   private float field_82191_bN;
/*     */   
/*  81 */   public static final Map villagerStockList = new HashMap<Object, Object>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  87 */   public static final Map blacksmithSellingList = new HashMap<Object, Object>();
/*     */ 
/*     */   
/*     */   public EntityNamekian03(World par1World) {
/*  91 */     this(par1World, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityNamekian03(World par1World, int par2) {
/*  96 */     super(par1World);
/*  97 */     this.randomTickDivider = 0;
/*  98 */     this.isMating = false;
/*  99 */     this.isPlaying = false;
/* 100 */     this.field_70954_d = null;
/* 101 */     func_70938_b(par2);
/*     */ 
/*     */     
/* 104 */     func_70661_as().func_75498_b(true);
/* 105 */     func_70661_as().func_75491_a(true);
/* 106 */     this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/* 107 */     this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, EntityZombie.class, 8.0F, 0.30000001192092896D, 0.3499999940395355D));
/* 108 */     this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAITradePlayer(this));
/* 109 */     this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAILookAtTradePlayer(this));
/* 110 */     this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIMoveIndoors((EntityCreature)this));
/* 111 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIRestrictOpenDoor((EntityCreature)this));
/* 112 */     this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIOpenDoor((EntityLiving)this, true));
/*     */     
/* 114 */     this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIVillagerMate(this));
/* 115 */     this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIFollowGolem(this));
/* 116 */     this.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAIPlay(this, 0.3199999928474426D));
/* 117 */     this.field_70714_bg.func_75776_a(9, (EntityAIBase)new EntityAIWatchClosest2((EntityLiving)this, EntityPlayer.class, 3.0F, 1.0F));
/* 118 */     this.field_70714_bg.func_75776_a(9, (EntityAIBase)new EntityAIWatchClosest2((EntityLiving)this, EntityVillager.class, 5.0F, 0.02F));
/* 119 */     this.field_70714_bg.func_75776_a(9, (EntityAIBase)new EntityAIWander((EntityCreature)this, 0.30000001192092896D));
/* 120 */     this.field_70714_bg.func_75776_a(10, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityLiving.class, 8.0F));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
/* 128 */     if (func_85032_ar())
/*     */     {
/* 130 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 134 */     Entity var3 = par1DamageSource.func_76346_g();
/*     */     
/* 136 */     if (var3 instanceof EntityPlayer) {
/*     */       
/* 138 */       List<Entity> var4 = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D));
/*     */       
/* 140 */       for (int var5 = 0; var5 < var4.size(); var5++) {
/*     */         
/* 142 */         Entity var6 = var4.get(var5);
/*     */ 
/*     */         
/* 145 */         if (var6 instanceof EntityNamekian01) {
/*     */           
/* 147 */           EntityNamekian01 var7 = (EntityNamekian01)var6;
/* 148 */           var7.becomeAngryAt(var3);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 154 */     return super.func_70097_a(par1DamageSource, par2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70650_aV() {
/* 163 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70629_bd() {
/* 171 */     if (--this.randomTickDivider <= 0) {
/*     */       
/* 173 */       this.field_70170_p.field_72982_D.func_75551_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v));
/* 174 */       this.randomTickDivider = 70 + this.field_70146_Z.nextInt(50);
/* 175 */       this.field_70954_d = this.field_70170_p.field_72982_D.func_75550_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v), 32);
/*     */       
/* 177 */       if (this.field_70954_d != null) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 183 */         ChunkCoordinates var1 = this.field_70954_d.func_75577_a();
/*     */ 
/*     */         
/* 186 */         if (this.field_82190_bM)
/*     */         {
/* 188 */           this.field_82190_bM = false;
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 194 */     if (!func_70940_q() && this.timeUntilReset > 0) {
/*     */       
/* 196 */       this.timeUntilReset--;
/*     */       
/* 198 */       if (this.timeUntilReset <= 0) {
/*     */         
/* 200 */         if (this.needsInitilization) {
/*     */           
/* 202 */           if (this.buyingList.size() > 1) {
/*     */             
/* 204 */             Iterator<MerchantRecipe> var3 = this.buyingList.iterator();
/*     */             
/* 206 */             while (var3.hasNext())
/*     */             {
/* 208 */               MerchantRecipe merchantRecipe = var3.next();
/*     */             }
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 217 */           addDefaultEquipmentAndRecipies(1);
/* 218 */           this.needsInitilization = false;
/*     */           
/* 220 */           if (this.field_70954_d != null && this.lastBuyingPlayer != null) {
/*     */             
/* 222 */             this.field_70170_p.func_72960_a((Entity)this, (byte)14);
/* 223 */             this.field_70954_d.func_82688_a(this.lastBuyingPlayer, 1);
/*     */           } 
/*     */         } 
/*     */         
/* 227 */         func_70690_d(new PotionEffect(Potion.field_76428_l.field_76415_H, 200, 0));
/*     */       } 
/*     */     } 
/*     */     
/* 231 */     super.func_70629_bd();
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
/*     */   
/*     */   public boolean func_70085_c(EntityPlayer par1EntityPlayer) {
/* 256 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/* 261 */     super.func_70088_a();
/* 262 */     this.field_70180_af.func_75682_a(20, Integer.valueOf(0));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/* 268 */     super.func_110147_ax();
/* 269 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(300.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound par1NBTTagCompound) {
/* 277 */     super.func_70014_b(par1NBTTagCompound);
/* 278 */     par1NBTTagCompound.func_74768_a("Profession", func_70946_n());
/* 279 */     par1NBTTagCompound.func_74768_a("Riches", this.wealth);
/*     */     
/* 281 */     if (this.buyingList != null)
/*     */     {
/* 283 */       par1NBTTagCompound.func_74782_a("Offers", (NBTBase)this.buyingList.func_77202_a());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound par1NBTTagCompound) {
/* 292 */     super.func_70037_a(par1NBTTagCompound);
/* 293 */     func_70938_b(par1NBTTagCompound.func_74762_e("Profession"));
/* 294 */     this.wealth = par1NBTTagCompound.func_74762_e("Riches");
/*     */     
/* 296 */     if (par1NBTTagCompound.func_74764_b("Offers")) {
/*     */       
/* 298 */       NBTTagCompound var2 = par1NBTTagCompound.func_74775_l("Offers");
/* 299 */       this.buyingList = new MerchantRecipeList(var2);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/* 310 */     return "jinryuudragonbc:npcs/namek02.png";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean func_70692_ba() {
/* 318 */     return false;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70938_b(int par1) {
/* 347 */     this.field_70180_af.func_75692_b(16, Integer.valueOf(par1));
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_70946_n() {
/* 352 */     return this.field_70180_af.func_75679_c(16);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70941_o() {
/* 357 */     return this.isMating;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70947_e(boolean par1) {
/* 362 */     this.isMating = par1;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70939_f(boolean par1) {
/* 367 */     this.isPlaying = par1;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70945_p() {
/* 372 */     return this.isPlaying;
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
/*     */   public void func_70645_a(DamageSource par1DamageSource) {
/* 407 */     if (this.field_70954_d != null) {
/*     */       
/* 409 */       Entity var2 = par1DamageSource.func_76346_g();
/*     */       
/* 411 */       if (var2 != null) {
/*     */         
/* 413 */         if (var2 instanceof EntityPlayer)
/*     */         {
/*     */           
/* 416 */           int al = JRMCoreH.getByte((EntityPlayer)var2, "jrmcAlign");
/* 417 */           al -= 20;
/* 418 */           al = (al < 0) ? 0 : al;
/* 419 */           JRMCoreH.setByte(al, (EntityPlayer)var2, "jrmcAlign");
/*     */           
/* 421 */           int kr = JRMCoreH.getInt((EntityPlayer)var2, "jrmcKarma");
/* 422 */           JRMCoreH.setInt(kr + 1, (EntityPlayer)var2, "jrmcKarma");
/*     */           
/* 424 */           ((EntityPlayer)var2).func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("dbc.moreevil.line1"), new Object[0])).func_150255_a(JRMCoreH2.styl_wht));
/*     */           
/* 426 */           this.field_70954_d.func_82688_a(((EntityPlayer)var2).func_70005_c_(), -2);
/*     */         }
/* 428 */         else if (var2 instanceof net.minecraft.entity.monster.IMob)
/*     */         {
/* 430 */           this.field_70954_d.func_82692_h();
/*     */         }
/*     */       
/* 433 */       } else if (var2 == null) {
/*     */         
/* 435 */         EntityPlayer var3 = this.field_70170_p.func_72890_a((Entity)this, 16.0D);
/*     */         
/* 437 */         if (var3 != null)
/*     */         {
/* 439 */           this.field_70954_d.func_82692_h();
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 444 */     super.func_70645_a(par1DamageSource);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70932_a_(EntityPlayer par1EntityPlayer) {
/* 449 */     this.buyingPlayer = par1EntityPlayer;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityPlayer func_70931_l_() {
/* 454 */     return this.buyingPlayer;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70940_q() {
/* 459 */     return (this.buyingPlayer != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70933_a(MerchantRecipe par1MerchantRecipe) {
/* 464 */     par1MerchantRecipe.func_77399_f();
/*     */     
/* 466 */     if (par1MerchantRecipe.func_77393_a((MerchantRecipe)this.buyingList.get(this.buyingList.size() - 1))) {
/*     */       
/* 468 */       this.timeUntilReset = 40;
/* 469 */       this.needsInitilization = true;
/*     */       
/* 471 */       if (this.buyingPlayer != null) {
/*     */         
/* 473 */         this.lastBuyingPlayer = this.buyingPlayer.func_70005_c_();
/*     */       }
/*     */       else {
/*     */         
/* 477 */         this.lastBuyingPlayer = null;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MerchantRecipeList func_70934_b(EntityPlayer par1EntityPlayer) {
/* 489 */     if (this.buyingList == null)
/*     */     {
/* 491 */       addDefaultEquipmentAndRecipies(1);
/*     */     }
/*     */     
/* 494 */     return this.buyingList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private float adjustProbability(float par1) {
/* 502 */     float var2 = par1 + this.field_82191_bN;
/* 503 */     return (var2 > 0.9F) ? (0.9F - var2 - 0.9F) : var2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void addDefaultEquipmentAndRecipies(int par1) {
/* 513 */     if (this.buyingList != null) {
/*     */       
/* 515 */       this.field_82191_bN = MathHelper.func_76129_c(this.buyingList.size()) * 0.2F;
/*     */     }
/*     */     else {
/*     */       
/* 519 */       this.field_82191_bN = 0.0F;
/*     */     } 
/*     */ 
/*     */     
/* 523 */     MerchantRecipeList var2 = new MerchantRecipeList();
/* 524 */     VillagerRegistry.manageVillagerTrades(var2, this, func_70946_n(), this.field_70146_Z);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 611 */     if (var2.isEmpty());
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 616 */     Collections.shuffle((List<?>)var2);
/*     */     
/* 618 */     if (this.buyingList == null)
/*     */     {
/* 620 */       this.buyingList = new MerchantRecipeList();
/*     */     }
/*     */     
/* 623 */     for (int var9 = 0; var9 < par1 && var9 < var2.size(); var9++)
/*     */     {
/* 625 */       this.buyingList.func_77205_a((MerchantRecipe)var2.get(var9));
/*     */     }
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
/*     */ 
/*     */ 
/*     */   
/*     */   private static int getRandomCountForItem(int par0, Random par1Random) {
/* 653 */     Tuple var2 = (Tuple)villagerStockList.get(Integer.valueOf(par0));
/* 654 */     return (var2 == null) ? 1 : ((((Integer)var2.func_76341_a()).intValue() >= ((Integer)var2.func_76340_b()).intValue()) ? ((Integer)var2.func_76341_a()).intValue() : (((Integer)var2.func_76341_a()).intValue() + par1Random.nextInt(((Integer)var2.func_76340_b()).intValue() - ((Integer)var2.func_76341_a()).intValue())));
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int getRandomCountForBlacksmithItem(int par0, Random par1Random) {
/* 682 */     Tuple var2 = (Tuple)blacksmithSellingList.get(Integer.valueOf(par0));
/* 683 */     return (var2 == null) ? 1 : ((((Integer)var2.func_76341_a()).intValue() >= ((Integer)var2.func_76340_b()).intValue()) ? ((Integer)var2.func_76341_a()).intValue() : (((Integer)var2.func_76341_a()).intValue() + par1Random.nextInt(((Integer)var2.func_76340_b()).intValue() - ((Integer)var2.func_76341_a()).intValue())));
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70103_a(byte par1) {
/* 689 */     if (par1 == 12) {
/*     */       
/* 691 */       generateRandomParticles("heart");
/*     */     }
/* 693 */     else if (par1 == 13) {
/*     */       
/* 695 */       generateRandomParticles("angryVillager");
/*     */     }
/* 697 */     else if (par1 == 14) {
/*     */       
/* 699 */       generateRandomParticles("happyVillager");
/*     */     }
/*     */     else {
/*     */       
/* 703 */       super.func_70103_a(par1);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   private void generateRandomParticles(String par1Str) {
/* 714 */     for (int var2 = 0; var2 < 5; var2++) {
/*     */       
/* 716 */       double var3 = this.field_70146_Z.nextGaussian() * 0.02D;
/* 717 */       double var5 = this.field_70146_Z.nextGaussian() * 0.02D;
/* 718 */       double var7 = this.field_70146_Z.nextGaussian() * 0.02D;
/* 719 */       this.field_70170_p.func_72869_a(par1Str, this.field_70165_t + (this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0F) - this.field_70130_N, this.field_70163_u + 1.0D + (this.field_70146_Z.nextFloat() * this.field_70131_O), this.field_70161_v + (this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0F) - this.field_70130_N, var3, var5, var7);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initCreature() {
/* 728 */     VillagerRegistry.applyRandomTrade(this, this.field_70170_p.field_73012_v);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_82187_q() {
/* 733 */     this.field_82190_bM = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityVillager func_90012_b(EntityAgeable par1EntityAgeable) {
/* 738 */     EntityVillager var2 = new EntityVillager(this.field_70170_p);
/*     */     
/* 740 */     return var2;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityNamekian03.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */