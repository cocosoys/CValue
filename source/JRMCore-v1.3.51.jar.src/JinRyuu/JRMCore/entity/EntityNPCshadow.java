/*     */ package JinRyuu.JRMCore.entity;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreConfig;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import cpw.mods.fml.common.network.ByteBufUtils;
/*     */ import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.entity.AbstractClientPlayer;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityNPCshadow
/*     */   extends EntityNPC
/*     */   implements IEntityAdditionalSpawnData {
/*  30 */   public int randomSoundDelay = 0;
/*  31 */   public int angerLevel = 0;
/*     */   
/*  33 */   private EntityPlayer summoner = null;
/*  34 */   private EntityLivingBase target = null;
/*  35 */   private int maxHealth = 1;
/*  36 */   private int pmje = 0;
/*  37 */   private int wait = 0;
/*  38 */   private int m = 1; private String dnsSum; public String expValue; private int gen;
/*  39 */   private int age = 0; private int breast; private float f;
/*     */   public EntityPlayer getsummoner() {
/*  41 */     return this.summoner; }
/*  42 */   public int getSFire() { return this.pmje; } public int getDam() {
/*  43 */     return this.dam;
/*     */   }
/*     */   public String getdnsSum() {
/*  46 */     return this.dnsSum;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getGen()
/*     */   {
/*  52 */     return this.gen; } public float getF() {
/*  53 */     return this.f;
/*     */   }
/*     */   
/*     */   public EntityNPCshadow(World world) {
/*  57 */     super(world); toString(); this.expValue = String.valueOf(BattlePower()); this.gen = 1; this.breast = 0; this.f = 1.0F;
/*  58 */     this.field_70728_aV = 30;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityNPCshadow(World world, EntityPlayer summoner, int body, int dam, EntityLivingBase target) {
/*  63 */     super(world); toString(); this.expValue = String.valueOf(BattlePower()); this.gen = 1; this.breast = 0; this.f = 1.0F;
/*  64 */     this.field_70728_aV = 1;
/*  65 */     this.summoner = summoner;
/*  66 */     this.dam = dam;
/*  67 */     this.target = target;
/*  68 */     this.maxHealth = body * 2;
/*  69 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(this.maxHealth);
/*     */   }
/*     */ 
/*     */   
/*     */   public int BattlePower() {
/*  74 */     int exp = this.field_70728_aV * 100;
/*  75 */     int BattlePower = 1200 + this.field_70146_Z.nextInt(100);
/*     */     
/*  77 */     return BattlePower;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  82 */     super.func_110147_ax();
/*  83 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(10.0D);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*  87 */     return "jinryuunarutoc:npcs/ninja01.png";
/*     */   }
/*     */   
/*     */   public ResourceLocation getResource() {
/*  91 */     return (this.summoner != null && this.summoner instanceof AbstractClientPlayer) ? ((AbstractClientPlayer)this.summoner)
/*  92 */       .func_110306_p() : new ResourceLocation("jinryuunarutoc:npcs/ninja01.png");
/*     */   }
/*     */   
/*     */   public EntityPlayer getSummoner() {
/*  96 */     return this.summoner;
/*     */   }
/*     */   
/*     */   public boolean func_70601_bi() {
/* 100 */     return (this.field_70170_p.func_72855_b(this.field_70121_D) && this.field_70170_p.func_72945_a((Entity)this, this.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(this.field_70121_D));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Entity func_70782_k() {
/* 109 */     int n = 8;
/* 110 */     AxisAlignedBB aabb = AxisAlignedBB.func_72330_a(this.field_70165_t - n, this.field_70163_u - n, this.field_70161_v - n, this.field_70165_t + n, this.field_70163_u + n, this.field_70161_v + n);
/* 111 */     Entity entity = this.field_70170_p.func_72857_a(EntityCreature.class, aabb, (Entity)this);
/* 112 */     EntityPlayer entityplayer = this.field_70170_p.func_72856_b((Entity)this, 16.0D);
/* 113 */     EntityLivingBase entityLivingBase = this.target;
/* 114 */     return (entityLivingBase != null) ? (Entity)entityLivingBase : ((entityplayer != null && entityplayer != this.summoner) ? (Entity)entityplayer : ((entity != null && entity != this.summoner && entity != this) ? entity : null));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/* 120 */     String[] pmj = JRMCoreH.pmj[Integer.parseInt(this.type)];
/* 121 */     this.pmje = Integer.parseInt(pmj[13]);
/*     */     
/* 123 */     if (!this.field_70170_p.field_72995_K && (this.summoner == null || !(this.summoner instanceof EntityPlayer) || this.age > 6000)) {
/*     */       
/* 125 */       func_70106_y();
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 130 */     double r = 10.0D;
/* 131 */     AxisAlignedBB ab = AxisAlignedBB.func_72330_a(this.field_70165_t - r, this.field_70163_u - r, this.field_70161_v - r, this.field_70165_t + r, this.field_70163_u + r, this.field_70161_v + r);
/* 132 */     List entityList = this.field_70170_p.func_72872_a(getClass(), ab);
/* 133 */     if (entityList.size() > 5) {
/*     */       
/* 135 */       func_70106_y();
/*     */       
/*     */       return;
/*     */     } 
/* 139 */     this.age++;
/* 140 */     if (this.age == 1) {
/*     */       
/* 142 */       func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(this.maxHealth);
/* 143 */       func_70691_i(this.maxHealth);
/*     */     } 
/*     */     
/* 146 */     teleportAndUpdate();
/*     */     
/* 148 */     super.func_70636_d();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
/* 153 */     if (func_85032_ar())
/*     */     {
/* 155 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 159 */     Entity var3 = par1DamageSource.func_76346_g();
/*     */     
/* 161 */     if (var3 instanceof EntityPlayer) {
/*     */       
/* 163 */       List<Entity> var4 = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D));
/*     */       
/* 165 */       for (int var5 = 0; var5 < var4.size(); var5++) {
/*     */         
/* 167 */         Entity var6 = var4.get(var5);
/*     */         
/* 169 */         if (var6 instanceof EntityNPCshadow) {
/*     */           
/* 171 */           EntityNPCshadow var7 = (EntityNPCshadow)var6;
/* 172 */           var7.becomeAngryAt(var3);
/*     */         } 
/*     */       } 
/*     */       
/* 176 */       becomeAngryAt(var3);
/*     */     } 
/*     */     
/* 179 */     return super.func_70097_a(par1DamageSource, par2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void becomeAngryAt(Entity par1Entity) {
/* 188 */     this.field_70789_a = par1Entity;
/* 189 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/* 190 */     this.randomSoundDelay = this.field_70146_Z.nextInt(40);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70628_a(boolean par1, int par2) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70085_c(EntityPlayer par1EntityPlayer) {
/* 204 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getAttackStrength(Entity par1Entity) {
/* 209 */     int dbcA = this.dam;
/* 210 */     return dbcA;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70652_k(Entity par1Entity) {
/* 220 */     int var2 = getAttackStrength(par1Entity);
/*     */     
/* 222 */     if (func_70644_a(Potion.field_76420_g))
/*     */     {
/* 224 */       var2 += 3 << func_70660_b(Potion.field_76420_g).func_76458_c();
/*     */     }
/*     */     
/* 227 */     if (func_70644_a(Potion.field_76437_t))
/*     */     {
/* 229 */       var2 -= 2 << func_70660_b(Potion.field_76437_t).func_76458_c();
/*     */     }
/*     */     
/* 232 */     int var3 = 0;
/*     */     
/* 234 */     if (par1Entity instanceof net.minecraft.entity.EntityLiving) {
/*     */       
/* 236 */       var2 = (int)(var2 + EnchantmentHelper.func_77512_a((EntityLivingBase)this, (EntityLivingBase)par1Entity));
/* 237 */       var3 += EnchantmentHelper.func_77507_b((EntityLivingBase)this, (EntityLivingBase)par1Entity);
/*     */     } 
/*     */     
/* 240 */     boolean var4 = par1Entity.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this), var2);
/*     */     
/* 242 */     if (var4) {
/*     */       
/* 244 */       if (var3 > 0) {
/*     */         
/* 246 */         par1Entity.func_70024_g((-MathHelper.func_76126_a(this.field_70177_z * 3.1415927F / 180.0F) * var3 * 0.5F), 0.1D, (MathHelper.func_76134_b(this.field_70177_z * 3.1415927F / 180.0F) * var3 * 0.5F));
/* 247 */         this.field_70159_w *= 0.6D;
/* 248 */         this.field_70179_y *= 0.6D;
/*     */       } 
/*     */       
/* 251 */       int var5 = EnchantmentHelper.func_90036_a((EntityLivingBase)this);
/*     */       
/* 253 */       if (var5 > 0)
/*     */       {
/* 255 */         par1Entity.func_70015_d(var5 * 4);
/*     */       }
/*     */     } 
/*     */     
/* 259 */     return var4;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70645_a(DamageSource par1DamageSource) {
/* 264 */     Entity var3 = par1DamageSource.func_76346_g();
/* 265 */     this.field_70170_p.func_72956_a((Entity)this, "jinryuunarutoc:NC1." + JRMCoreH.techNCSndHitPM[0], 1.0F, 1.0F);
/* 266 */     super.func_70645_a(par1DamageSource);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70785_a(Entity par1Entity, float par2) {
/* 274 */     if (this.field_70724_aR <= 0 && par2 < 2.0F && par1Entity.field_70121_D.field_72337_e > this.field_70121_D.field_72338_b && par1Entity.field_70121_D.field_72338_b < this.field_70121_D.field_72337_e) {
/*     */       
/* 276 */       this.field_70724_aR = 20;
/* 277 */       func_70652_k(par1Entity);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeSpawnData(ByteBuf data) {
/* 285 */     data.writeInt(this.dam);
/* 286 */     data.writeInt(this.maxHealth);
/* 287 */     ByteBufUtils.writeUTF8String(data, (this.summoner != null) ? this.summoner.func_70005_c_() : "");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readSpawnData(ByteBuf data) {
/* 294 */     this.dam = data.readInt();
/* 295 */     this.maxHealth = data.readInt();
/* 296 */     this.summoner = this.field_70170_p.func_72924_a(ByteBufUtils.readUTF8String(data));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound nbtCompound) {
/* 305 */     super.func_70014_b(nbtCompound);
/* 306 */     nbtCompound.func_74768_a("NPCdam", this.dam);
/* 307 */     nbtCompound.func_74768_a("maxHealth", this.maxHealth);
/* 308 */     nbtCompound.func_74778_a("NPCsummoner", (this.summoner != null) ? this.summoner.func_70005_c_() : "");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound nbtCompound) {
/* 316 */     super.func_70037_a(nbtCompound);
/* 317 */     this.dam = nbtCompound.func_74762_e("NPCdam");
/* 318 */     this.maxHealth = nbtCompound.func_74762_e("maxHealth");
/* 319 */     this.summoner = this.field_70170_p.func_72924_a(nbtCompound.func_74779_i("NPCsummoner"));
/*     */   }
/*     */ 
/*     */   
/*     */   private NBTTagCompound nbt(EntityPlayer p, String s) {
/*     */     NBTTagCompound nbt;
/* 325 */     if (s.contains("pres")) {
/* 326 */       if (!p.getEntityData().func_74764_b("PlayerPersisted")) {
/* 327 */         nbt = new NBTTagCompound();
/* 328 */         p.getEntityData().func_74782_a("PlayerPersisted", (NBTBase)nbt);
/*     */       } else {
/* 330 */         nbt = p.getEntityData().func_74775_l("PlayerPersisted");
/*     */       } 
/*     */     } else {
/* 333 */       nbt = p.getEntityData();
/*     */     } 
/*     */     
/* 336 */     return nbt;
/*     */   }
/*     */ 
/*     */   
/*     */   private void teleportAndUpdate() {
/* 341 */     if (this.summoner != null) {
/*     */       
/* 343 */       int R = 32;
/* 344 */       this.wait++;
/* 345 */       List<EntityPlayer> entityList2 = this.field_70170_p.func_72872_a(EntityPlayer.class, this.field_70121_D.func_72314_b(R, R, R));
/* 346 */       if (!entityList2.isEmpty())
/*     */       {
/* 348 */         for (int var5 = 0; var5 < entityList2.size(); var5++) {
/*     */           
/* 350 */           EntityPlayer var6 = entityList2.get(var5);
/* 351 */           if (var6.func_70005_c_().equals(this.summoner.func_70005_c_())) {
/*     */             
/* 353 */             becomeAngryAt((Entity)var6);
/* 354 */             if (this.wait == 150 * this.m) {
/*     */               
/* 356 */               boolean calculateSize = JRMCoreConfig.ShadowDummyScaleToTarget;
/* 357 */               if (calculateSize) {
/*     */                 
/* 359 */                 float height = this.field_70131_O, width = this.field_70130_N;
/* 360 */                 float heightTarget = this.summoner.field_70131_O, widthTarget = this.summoner.field_70130_N;
/* 361 */                 if (height != heightTarget || width != widthTarget)
/*     */                 {
/* 363 */                   func_70105_a(widthTarget, heightTarget);
/*     */                 }
/*     */               } 
/*     */               
/* 367 */               this.m++;
/* 368 */               if (!this.field_70170_p.field_72995_K) {
/*     */                 
/* 370 */                 func_70634_a(var6.field_70165_t, var6.field_70163_u + 1.5D, var6.field_70161_v);
/* 371 */                 this.field_70170_p.func_72956_a((Entity)this, JRMCoreH.TeleportSound(JRMCoreH.getByte(var6, "jrmcPwrtyp")), 0.5F, this.field_70170_p.field_73012_v.nextFloat() * 0.1F + 0.9F);
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\entity\EntityNPCshadow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */