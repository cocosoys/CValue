/*     */ package JinRyuu.FamilyC;
/*     */ import JinRyuu.JRMCore.FamilyCH;
/*     */ import JinRyuu.JRMCore.JRMCoreConfig;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.entity.AIFollowOwner;
/*     */ import JinRyuu.JRMCore.entity.AINearestAttackableTarget;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import cpw.mods.fml.common.network.ByteBufUtils;
/*     */ import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIAttackOnCollide;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAIHurtByTarget;
/*     */ import net.minecraft.entity.ai.EntityAILeapAtTarget;
/*     */ import net.minecraft.entity.ai.EntityAILookIdle;
/*     */ import net.minecraft.entity.ai.EntityAISwimming;
/*     */ import net.minecraft.entity.ai.EntityAIWander;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.monster.EntityCreeper;
/*     */ import net.minecraft.entity.monster.EntityMob;
/*     */ import net.minecraft.entity.monster.EntitySlime;
/*     */ import net.minecraft.entity.monster.IMob;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.ItemArmor;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.ItemSword;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.stats.AchievementList;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldServer;
/*     */ 
/*     */ public class EntityNPC extends EntityCreature implements IMob, IEntityAdditionalSpawnData {
/*  49 */   public int randomSoundDelay = 0;
/*     */   private float age;
/*     */   private float grw;
/*     */   private boolean doNamUpdt;
/*  53 */   private int maxHealth; private int energy; private int maxEnergy; private byte cnam; private String dns; private String dnsH; private String nam; private String mom; private String dad; private int cid; private boolean aggr; private int follow; private int followTarget; private int equipmentDropped; private String attrbts; private String skills; private String techs; private String bonuses; private int npcExp; private int npcTp; private int npcSt; public String expValue; private int angerLevel; private Entity target; private int tick20; public void runTasks() { func_70661_as().func_75491_a(true); this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this)); this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAILeapAtTarget((EntityLiving)this, 0.4F)); this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIAttackOnCollide(this, 1.0D, true)); this.field_70714_bg.func_75776_a(3, (EntityAIBase)new AIFollowOwner(this, 1.0D, 10.0F, 2.0F)); this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIWander(this, 1.0D)); this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F)); this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAILookIdle((EntityLiving)this)); this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget(this, true)); this.field_70715_bh.func_75776_a(2, (EntityAIBase)new AINearestAttackableTarget(this, EntityMob.class, 0, false)); this.field_70715_bh.func_75776_a(3, (EntityAIBase)new AINearestAttackableTarget(this, EntitySlime.class, 0, false)); this.field_70715_bh.func_75776_a(4, (EntityAIBase)new AINearestAttackableTarget(this, EntityCreeper.class, 0, false)); } public void setNamUpdt(boolean b) { this.doNamUpdt = b; } public void setCnam(byte i) { this.cnam = i; } public void setDNS(String i) { this.dns = i; } public void setDNSH(String i) { this.dnsH = i; } public void setNam(String i) { this.nam = i; } public void setMom(String i) { this.mom = i; } public void setDad(String i) { this.dad = i; } public void setNPCAge(float i) { this.age = i; } public void setFollow(int i) { this.follow = i; } public void setAggr(boolean i) { this.aggr = i; } public void setFollowTarget(int i) { this.followTarget = i; } public int getCnam() { return this.cnam; } public String getDNS() { return this.dns; } public String getDNSH() { return this.dnsH; } public EntityNPC(World par1World) { super(par1World);
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
/*  73 */     this.age = 0.25F;
/*  74 */     this.grw = 2.0F;
/*     */     
/*  76 */     this.doNamUpdt = false;
/*     */ 
/*     */     
/*  79 */     this.maxHealth = 30;
/*  80 */     this.energy = 0;
/*  81 */     this.maxEnergy = 0;
/*     */     
/*  83 */     this.cnam = 0;
/*  84 */     this.dns = "0";
/*  85 */     this.dnsH = "0";
/*  86 */     this.nam = "Child";
/*  87 */     this.mom = "";
/*  88 */     this.dad = "";
/*  89 */     this.cid = 0;
/*  90 */     this.aggr = false;
/*  91 */     this.follow = 2;
/*  92 */     this.followTarget = 0;
/*     */     
/*  94 */     this.equipmentDropped = 0;
/*     */     
/*  96 */     this.attrbts = "1:1:1:1:1:1";
/*  97 */     this.skills = "";
/*  98 */     this.techs = "";
/*  99 */     this.bonuses = "";
/* 100 */     this.npcExp = 0;
/* 101 */     this.npcTp = 0;
/* 102 */     this.npcSt = 0;
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
/* 206 */     toString(); this.expValue = String.valueOf(BattlePower());
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
/* 277 */     this.tick20 = 200; runTasks(); this.field_70728_aV = 0; } public String getNam() { return this.nam; } public String getMom() { return this.mom; } public String getDad() { return this.dad; } public int getCid() { return this.cid; } public float getNPCAge() { return this.age; } public float getNPCgrw() { return this.grw; } public int getFollow() { return this.follow; } public boolean getAggr() { return this.aggr; } public int getFollowTarget() { return this.followTarget; } public String getAttrbts() { return this.attrbts; } public int getExp() { return this.npcExp; } public int getTp() { return this.npcTp; } public int getSt() { return this.npcSt; } public boolean stopMoving() { return (this.follow == 0); } public void newborn() { this.age = 0.25F; this.grw = 2.0F; this.doNamUpdt = false; this.maxHealth = 30; this.energy = 0; this.maxEnergy = 0; this.cnam = 0; this.dns = "0"; this.dnsH = "0"; this.nam = "Child"; this.mom = ""; this.dad = ""; this.cid = 0; this.aggr = false; this.follow = 2; this.followTarget = 0; this.equipmentDropped = 0; this.attrbts = "1:1:1:1:1:1"; this.skills = ""; this.techs = ""; this.bonuses = ""; this.npcExp = 0; this.npcTp = 0; this.npcSt = 0; } public EntityNPC(World worldObj, String dns, String mom, String dad, String nam, int id, String dnsH) { super(worldObj); this.age = 0.25F; this.grw = 2.0F; this.doNamUpdt = false; this.maxHealth = 30; this.energy = 0; this.maxEnergy = 0; this.cnam = 0; this.dns = "0"; this.dnsH = "0"; this.nam = "Child"; this.mom = ""; this.dad = ""; this.cid = 0; this.aggr = false; this.follow = 2; this.followTarget = 0; this.equipmentDropped = 0; this.attrbts = "1:1:1:1:1:1"; this.skills = ""; this.techs = ""; this.bonuses = ""; this.npcExp = 0; this.npcTp = 0; this.npcSt = 0; toString(); this.expValue = String.valueOf(BattlePower()); this.tick20 = 200; newborn(); if (nam.length() > 30) nam = nam.substring(0, 30);  func_98053_h(true); if (dns.length() > 2) { this.dns = dns; this.dnsH = dnsH; this.cid = id; this.nam = nam; this.dad = dad; this.mom = mom; } else { func_70106_y(); }  runTasks(); } protected boolean func_70650_aV() { return true; } protected boolean func_70692_ba() { return false; } protected void func_70619_bc() { super.func_70619_bc(); } protected void func_110147_ax() { super.func_110147_ax(); double d = ((this.maxHealth != 0) ? this.maxHealth : 30); func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(d); func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.23000000417232513D); } public long BattlePower() { int exp = this.field_70728_aV * 100; long BattlePower = (1200 + this.field_70146_Z.nextInt(100)); return BattlePower; } public void func_82160_b(boolean par1, int par2) { for (int j = 0; j < (func_70035_c()).length; j++) { ItemStack itemstack = func_71124_b(j); if (itemstack != null && par1) { func_70099_a(itemstack, 0.0F); func_70062_b(j, null); this.equipmentDropped = 100; func_98053_h(false); }  }  }
/*     */   public float updateData(int i) { return this.field_70180_af.func_111145_d(i); }
/*     */   public String updateDataString(int i) { return this.field_70180_af.func_75681_e(i); }
/*     */   public int updateDataInt(int i) { return this.field_70180_af.func_75679_c(i); }
/*     */   public void updateDataNam() { this.nam = this.field_70180_af.func_75681_e(21); }
/*     */   protected void func_70629_bd() { this.field_70180_af.func_75692_b(18, Float.valueOf(func_110143_aJ())); this.field_70180_af.func_75692_b(19, Float.valueOf(getNPCAge())); this.field_70180_af.func_75692_b(20, Float.valueOf(getNPCgrw())); this.field_70180_af.func_75692_b(21, String.valueOf(getNam())); this.field_70180_af.func_75692_b(22, String.valueOf(this.attrbts)); this.field_70180_af.func_75692_b(23, Integer.valueOf(this.npcExp)); this.field_70180_af.func_75692_b(24, Integer.valueOf(this.npcTp)); this.field_70180_af.func_75692_b(25, String.valueOf(this.dns)); this.field_70180_af.func_75692_b(26, String.valueOf(this.dnsH)); }
/*     */   protected void func_70088_a() { super.func_70088_a(); this.field_70180_af.func_75682_a(18, new Float(func_110143_aJ())); this.field_70180_af.func_75682_a(19, new Float(getNPCAge())); this.field_70180_af.func_75682_a(20, new Float(getNPCgrw())); this.field_70180_af.func_75682_a(21, String.valueOf(getNam())); this.field_70180_af.func_75682_a(22, String.valueOf(this.attrbts)); this.field_70180_af.func_75682_a(23, new Integer(this.npcExp)); this.field_70180_af.func_75682_a(24, new Integer(this.npcTp)); this.field_70180_af.func_75682_a(25, String.valueOf(this.dns)); this.field_70180_af.func_75682_a(26, String.valueOf(this.dnsH)); }
/* 284 */   private void update() { if (this.equipmentDropped > 0) {
/* 285 */       this.equipmentDropped--;
/*     */     }
/* 287 */     else if (this.equipmentDropped == 0 && !func_98052_bS()) {
/* 288 */       func_98053_h(true);
/*     */     } 
/*     */     
/* 291 */     if (!this.field_70170_p.field_72995_K) {
/* 292 */       if (FamilyCConfig.dcr) func_70106_y(); 
/* 293 */       this.field_70143_R = 0.0F;
/* 294 */       float gu = FamilyCConfig.gut;
/* 295 */       if (this.age <= 5.0F) this.grw = 2.0F; 
/* 296 */       if (this.age > 5.0F && this.age <= gu) this.grw = 1.0F + 1.0F - (this.age - 5.0F) / (gu - 5.0F); 
/* 297 */       if (this.age > gu + 1.0F) this.grw = 1.0F;
/*     */       
/* 299 */       if (this.tick20 == 200) {
/* 300 */         int[] attrbts = new int[6]; String[] s1 = this.attrbts.split(":");
/* 301 */         for (int i = 0; i < 6; ) { attrbts[i] = Integer.parseInt(s1[i]); i++; }
/* 302 */          this.maxHealth = attrbts[2] * ((JRMCoreH.DBC() || JRMCoreH.NC()) ? 40 : 5);
/* 303 */         if (this.maxHealth != 0 && (int)func_110148_a(SharedMonsterAttributes.field_111267_a).func_111126_e() != this.maxHealth)
/* 304 */           func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(this.maxHealth); 
/* 305 */         int a = attrbts[0] + attrbts[1] + attrbts[2] + attrbts[3] + attrbts[4] + attrbts[5];
/* 306 */         if (this.npcTp >= JRMCoreH.attrCst(attrbts, 0)) {
/* 307 */           this.npcTp -= JRMCoreH.attrCst(attrbts, 0);
/* 308 */           int r = this.field_70170_p.field_73012_v.nextInt(6);
/*     */           
/* 310 */           attrbts[r] = (byte)((attrbts[r] < 120) ? (attrbts[r] + 1) : 120);
/* 311 */           String s = "";
/* 312 */           for (int j = 0; j < 6; ) { s = s + ":" + attrbts[j]; j++; }
/* 313 */            this.attrbts = s.substring(1);
/*     */         } 
/*     */       } 
/*     */       
/* 317 */       if (this.tick20 == 150) {
/* 318 */         FamilyCH.wcpd(FMLCommonHandler.instance().getMinecraftServerInstance(), (int)this.field_70165_t + "," + (int)this.field_70163_u + "," + (int)this.field_70161_v, "" + this.cid, false);
/*     */       }
/*     */       
/* 321 */       if (this.tick20 == 200 || this.tick20 == 100) {
/* 322 */         int[] attrbts = new int[6]; String[] s1 = this.attrbts.split(":");
/* 323 */         for (int i = 0; i < 6; ) { attrbts[i] = Integer.parseInt(s1[i]); i++; }
/* 324 */          int Stamina = attrbts[2] * 2;
/* 325 */         float curBody = func_110143_aJ();
/* 326 */         if (curBody < this.maxHealth && this.npcSt == 0) {
/* 327 */           float add = Stamina * JRMCoreConfig.hRgnRt * 0.5F;
/* 328 */           float all = curBody + ((add < 1.0F) ? 1.0F : add);
/* 329 */           func_70691_i((all > this.maxHealth) ? this.maxHealth : all);
/*     */         } 
/*     */       } 
/*     */     } else {
/*     */       
/* 334 */       if (this.doNamUpdt) {
/* 335 */         String prev = this.nam;
/* 336 */         updateDataNam();
/* 337 */         if (this.nam.compareTo(prev) != 0) this.doNamUpdt = false; 
/*     */       } 
/* 339 */       if (this.tick20 == 200 || this.age == 0.0F) {
/* 340 */         this.age = updateData(19);
/* 341 */         this.grw = updateData(20);
/* 342 */         this.nam = updateDataString(21);
/* 343 */         this.attrbts = updateDataString(22);
/* 344 */         this.npcExp = updateDataInt(23);
/* 345 */         this.npcTp = updateDataInt(24);
/* 346 */         this.dns = updateDataString(25);
/* 347 */         this.dnsH = updateDataString(26);
/*     */       } 
/*     */     } 
/* 350 */     this.tick20--;
/* 351 */     if (this.tick20 <= 0) {
/* 352 */       this.tick20 = 200;
/*     */     }
/*     */     
/* 355 */     if (!this.field_70170_p.field_72995_K) {
/* 356 */       WorldServer dim0 = FMLCommonHandler.instance().getMinecraftServerInstance().func_71218_a(0);
/*     */       
/* 358 */       if (dim0.func_72820_D() % 24000L == 1L || dim0.func_72820_D() % 24000L == 6001L || dim0.func_72820_D() % 24000L == 12001L || dim0.func_72820_D() % 24000L == 18001L) {
/* 359 */         this.age += 0.25F;
/* 360 */         int mls = FamilyCConfig.cls;
/* 361 */         mls = (mls < 20) ? 20 : mls;
/*     */         
/* 363 */         if (dim0.func_72820_D() % 24000L == 6001L && this.age > mls) {
/* 364 */           if (this.field_70170_p.field_73012_v.nextInt(5) == 0) {
/* 365 */             func_70097_a(DamageSource.field_76377_j, 20000.0F);
/* 366 */             this.age = 0.0F;
/*     */           } else {
/* 368 */             func_70097_a(DamageSource.field_76377_j, 4.0F);
/* 369 */             EntityPlayerMP entityPlayerMP1 = JRMCoreH.getPlayerForUsername(FMLCommonHandler.instance().getMinecraftServerInstance(), this.dad);
/* 370 */             EntityPlayerMP entityPlayerMP2 = JRMCoreH.getPlayerForUsername(FMLCommonHandler.instance().getMinecraftServerInstance(), this.mom);
/* 371 */             String msg = "§eYour child is getting very Old. " + this.nam + " will die soon.";
/* 372 */             if (entityPlayerMP1 != null) {
/* 373 */               entityPlayerMP1.func_145747_a((IChatComponent)new ChatComponentText(msg));
/*     */             }
/* 375 */             if (entityPlayerMP2 != null && (entityPlayerMP1 == null || entityPlayerMP2 != entityPlayerMP1)) {
/* 376 */               entityPlayerMP2.func_145747_a((IChatComponent)new ChatComponentText(msg));
/*     */             }
/*     */           } 
/*     */         }
/*     */       } 
/* 381 */       if (JRMCoreH.DBC() && 
/* 382 */         this.field_71093_bK == 23) {
/* 383 */         for (int i = 0; i < 24; i++) {
/* 384 */           if (dim0.func_72820_D() % 24000L == (i * 1000)) {
/* 385 */             this.age += 4.0F;
/*     */           }
/*     */         } 
/*     */       }
/*     */     }  }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/* 395 */     update();
/* 396 */     if (this.randomSoundDelay <= 0 || --this.randomSoundDelay == 0);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 401 */     super.func_70071_h_();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70601_bi() {
/* 409 */     return (this.field_70170_p.func_72855_b(this.field_70121_D) && this.field_70170_p.func_72945_a((Entity)this, this.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(this.field_70121_D));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound par1NBTTagCompound)
/*     */   {
/* 417 */     super.func_70014_b(par1NBTTagCompound);
/* 418 */     par1NBTTagCompound.func_74768_a("maxHealth", this.maxHealth);
/* 419 */     par1NBTTagCompound.func_74774_a("cnam", this.cnam);
/* 420 */     par1NBTTagCompound.func_74777_a("Anger", (short)this.angerLevel);
/* 421 */     par1NBTTagCompound.func_74778_a("nam", this.nam);
/* 422 */     par1NBTTagCompound.func_74778_a("DNS", this.dns);
/* 423 */     par1NBTTagCompound.func_74778_a("DNSH", this.dnsH);
/* 424 */     par1NBTTagCompound.func_74778_a("mom", this.mom);
/* 425 */     par1NBTTagCompound.func_74778_a("dad", this.dad);
/* 426 */     par1NBTTagCompound.func_74768_a("cid", this.cid);
/* 427 */     par1NBTTagCompound.func_74776_a("age", this.age);
/* 428 */     par1NBTTagCompound.func_74776_a("grw", this.grw);
/* 429 */     par1NBTTagCompound.func_74757_a("aggr", this.aggr);
/* 430 */     par1NBTTagCompound.func_74768_a("follow", this.follow);
/* 431 */     par1NBTTagCompound.func_74768_a("followTarget", this.followTarget);
/* 432 */     par1NBTTagCompound.func_74778_a("attrbts", this.attrbts);
/* 433 */     par1NBTTagCompound.func_74778_a("skills", this.skills);
/* 434 */     par1NBTTagCompound.func_74778_a("techs", this.techs);
/* 435 */     par1NBTTagCompound.func_74778_a("bonuses", this.bonuses);
/* 436 */     par1NBTTagCompound.func_74768_a("npcExp", this.npcExp);
/* 437 */     par1NBTTagCompound.func_74768_a("npcTp", this.npcTp);
/* 438 */     par1NBTTagCompound.func_74768_a("npcSt", this.npcSt);
/* 439 */     par1NBTTagCompound.func_74768_a("energy", this.energy);
/* 440 */     par1NBTTagCompound.func_74768_a("maxEnergy", this.maxEnergy); } private String watt(byte[] b) {
/*     */     String s;
/*     */     int i;
/* 443 */     for (s = "", i = 0; i < 6; ) { s = s + ":" + b[i]; i++; }
/* 444 */      return s.substring(1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound par1NBTTagCompound) {
/* 452 */     super.func_70037_a(par1NBTTagCompound);
/* 453 */     this.maxHealth = par1NBTTagCompound.func_74762_e("maxHealth");
/* 454 */     this.cnam = par1NBTTagCompound.func_74771_c("cnam");
/* 455 */     this.angerLevel = par1NBTTagCompound.func_74765_d("Anger");
/* 456 */     this.nam = par1NBTTagCompound.func_74779_i("nam");
/* 457 */     this.dns = par1NBTTagCompound.func_74779_i("DNS");
/* 458 */     this.dnsH = par1NBTTagCompound.func_74779_i("DNSH");
/* 459 */     this.mom = par1NBTTagCompound.func_74779_i("mom");
/* 460 */     this.dad = par1NBTTagCompound.func_74779_i("dad");
/* 461 */     this.cid = par1NBTTagCompound.func_74762_e("cid");
/* 462 */     this.age = par1NBTTagCompound.func_74760_g("age");
/* 463 */     this.grw = par1NBTTagCompound.func_74760_g("grw");
/* 464 */     this.aggr = par1NBTTagCompound.func_74767_n("aggr");
/* 465 */     this.follow = par1NBTTagCompound.func_74762_e("follow");
/* 466 */     this.followTarget = par1NBTTagCompound.func_74762_e("followTarget");
/* 467 */     this.attrbts = par1NBTTagCompound.func_74779_i("attrbts");
/* 468 */     this.skills = par1NBTTagCompound.func_74779_i("skills");
/* 469 */     this.techs = par1NBTTagCompound.func_74779_i("techs");
/* 470 */     this.bonuses = par1NBTTagCompound.func_74779_i("bonuses");
/* 471 */     this.npcExp = par1NBTTagCompound.func_74762_e("npcExp");
/* 472 */     this.npcTp = par1NBTTagCompound.func_74762_e("npcTp");
/* 473 */     this.npcSt = par1NBTTagCompound.func_74762_e("npcSt");
/* 474 */     this.energy = par1NBTTagCompound.func_74762_e("energy");
/* 475 */     this.maxEnergy = par1NBTTagCompound.func_74762_e("maxEnergy");
/*     */   }
/*     */   private byte[] ratt(String s) {
/* 478 */     byte[] att = new byte[6]; String[] s1 = s.split(":");
/* 479 */     for (int i = 0; i < 6; ) { att[i] = Byte.parseByte(s1[i]); i++; }
/* 480 */      return att;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Entity func_70782_k() {
/* 489 */     return (this.target != null) ? this.target : ((this.angerLevel == 0) ? null : super.func_70782_k());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/* 499 */     if (!this.field_70170_p.field_72995_K && func_98052_bS() && !this.field_70729_aU && !this.field_70170_p.func_82736_K().func_82766_b("mobGriefing")) {
/*     */       
/* 501 */       List list = this.field_70170_p.func_72872_a(EntityItem.class, this.field_70121_D.func_72314_b(1.0D, 0.0D, 1.0D));
/* 502 */       Iterator<EntityItem> iterator = list.iterator();
/*     */       
/* 504 */       while (iterator.hasNext()) {
/*     */         
/* 506 */         EntityItem entityitem = iterator.next();
/*     */         
/* 508 */         if (!entityitem.field_70128_L && entityitem.func_92059_d() != null) {
/*     */           
/* 510 */           ItemStack itemstack = entityitem.func_92059_d();
/* 511 */           int i = func_82159_b(itemstack);
/*     */           
/* 513 */           if (i > -1) {
/*     */             
/* 515 */             boolean flag = true;
/* 516 */             ItemStack itemstack1 = func_71124_b(i);
/*     */             
/* 518 */             if (itemstack1 != null)
/*     */             {
/* 520 */               if (i == 0) {
/*     */                 
/* 522 */                 if (itemstack.func_77973_b() instanceof ItemSword && !(itemstack1.func_77973_b() instanceof ItemSword)) {
/*     */                   
/* 524 */                   flag = true;
/*     */                 }
/* 526 */                 else if (itemstack.func_77973_b() instanceof ItemSword && itemstack1.func_77973_b() instanceof ItemSword) {
/*     */                   
/* 528 */                   ItemSword itemsword = (ItemSword)itemstack.func_77973_b();
/* 529 */                   ItemSword itemsword1 = (ItemSword)itemstack1.func_77973_b();
/*     */                   
/* 531 */                   if (itemsword.func_150931_i() == itemsword1.func_150931_i())
/*     */                   {
/* 533 */                     flag = (itemstack.func_77960_j() > itemstack1.func_77960_j() || (itemstack.func_77942_o() && !itemstack1.func_77942_o()));
/*     */                   }
/*     */                   else
/*     */                   {
/* 537 */                     flag = (itemsword.func_150931_i() > itemsword1.func_150931_i());
/*     */                   }
/*     */                 
/*     */                 } else {
/*     */                   
/* 542 */                   flag = false;
/*     */                 }
/*     */               
/* 545 */               } else if (itemstack.func_77973_b() instanceof ItemArmor && !(itemstack1.func_77973_b() instanceof ItemArmor)) {
/*     */                 
/* 547 */                 flag = true;
/*     */               }
/* 549 */               else if (itemstack.func_77973_b() instanceof ItemArmor && itemstack1.func_77973_b() instanceof ItemArmor) {
/*     */                 
/* 551 */                 ItemArmor itemarmor = (ItemArmor)itemstack.func_77973_b();
/* 552 */                 ItemArmor itemarmor1 = (ItemArmor)itemstack1.func_77973_b();
/*     */                 
/* 554 */                 if (itemarmor.field_77879_b == itemarmor1.field_77879_b)
/*     */                 {
/* 556 */                   flag = (itemstack.func_77960_j() > itemstack1.func_77960_j() || (itemstack.func_77942_o() && !itemstack1.func_77942_o()));
/*     */                 }
/*     */                 else
/*     */                 {
/* 560 */                   flag = (itemarmor.field_77879_b > itemarmor1.field_77879_b);
/*     */                 }
/*     */               
/*     */               } else {
/*     */                 
/* 565 */                 flag = false;
/*     */               } 
/*     */             }
/*     */             
/* 569 */             if (flag) {
/*     */               
/* 571 */               if (itemstack1 != null && this.field_70146_Z.nextFloat() - 0.1F < this.field_82174_bp[i])
/*     */               {
/* 573 */                 func_70099_a(itemstack1, 0.0F);
/*     */               }
/*     */               
/* 576 */               if (itemstack.func_77973_b() == Items.field_151045_i && entityitem.func_145800_j() != null) {
/*     */                 
/* 578 */                 EntityPlayer entityplayer = this.field_70170_p.func_72924_a(entityitem.func_145800_j());
/*     */                 
/* 580 */                 if (entityplayer != null)
/*     */                 {
/* 582 */                   entityplayer.func_71029_a((StatBase)AchievementList.field_150966_x);
/*     */                 }
/*     */               } 
/*     */               
/* 586 */               func_70062_b(i, itemstack);
/* 587 */               this.field_82174_bp[i] = 2.0F;
/* 588 */               func_110163_bv();
/*     */               
/* 590 */               func_71001_a((Entity)entityitem, 1);
/* 591 */               entityitem.func_70106_y();
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 598 */     super.func_70636_d();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
/* 606 */     if (func_85032_ar())
/*     */     {
/* 608 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 612 */     Entity var3 = par1DamageSource.func_76346_g();
/*     */     
/* 614 */     if (var3 instanceof EntityPlayer) {
/*     */       
/* 616 */       List<Entity> var4 = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D));
/*     */       
/* 618 */       for (int var5 = 0; var5 < var4.size(); var5++) {
/*     */         
/* 620 */         Entity var6 = var4.get(var5);
/*     */         
/* 622 */         if (var6 instanceof EntityNPC) {
/*     */           
/* 624 */           EntityNPC var7 = (EntityNPC)var6;
/* 625 */           var7.becomeAngryAt(var3);
/*     */         } 
/*     */       } 
/*     */       
/* 629 */       becomeAngryAt(var3);
/*     */     } 
/* 631 */     return super.func_70097_a(par1DamageSource, par2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void becomeAngryAt(Entity par1Entity) {
/* 642 */     this.field_70789_a = par1Entity;
/* 643 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/* 644 */     this.randomSoundDelay = this.field_70146_Z.nextInt(40);
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
/*     */   protected void func_70628_a(boolean par1, int par2) {}
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
/* 674 */     ItemStack itemstack = par1EntityPlayer.field_71071_by.func_70448_g();
/* 675 */     boolean flag = (itemstack != null && itemstack.func_77973_b() == Items.field_151063_bx);
/*     */     
/* 677 */     if (!flag && func_70089_S() && !par1EntityPlayer.func_70093_af()) {
/*     */       
/* 679 */       if (this.field_70170_p.field_72995_K) {
/*     */         
/* 681 */         JRMCoreH.targNPC = (Entity)this;
/* 682 */         par1EntityPlayer.openGui(mod_FamilyC.instance, 2, par1EntityPlayer.field_70170_p, (int)par1EntityPlayer.field_70165_t, (int)par1EntityPlayer.field_70163_u, (int)par1EntityPlayer.field_70161_v);
/*     */       } else {
/* 684 */         FamilyCH.jfcd(20, func_145782_y() + ":" + getFollow() + ":" + (getAggr() ? "1" : "0") + ":" + getFollowTarget() + ":" + getDad() + ":" + getMom() + ":" + getCnam(), par1EntityPlayer);
/*     */       } 
/*     */       
/* 687 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 691 */     return super.func_70085_c(par1EntityPlayer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void expPls(int e) {
/* 696 */     int[] attrbts = new int[6]; String[] s1 = this.attrbts.split(":");
/* 697 */     for (int i1 = 0; i1 < 6; ) { attrbts[i1] = Integer.parseInt(s1[i1]); i1++; }
/* 698 */      int mnd = attrbts[4];
/*     */ 
/*     */     
/* 701 */     int xplmt = 5;
/* 702 */     int tpgn = 1;
/* 703 */     if (JRMCoreH.DBC()) {
/* 704 */       float p = 1.0F;
/*     */       
/* 706 */       xplmt = (int)(5.0F * p);
/* 707 */       tpgn = JRMCoreConfig.tpgn * ((int)(mnd / JRMCoreConfig.TpgnRt) + 1);
/*     */     } 
/* 709 */     int exp = this.npcExp;
/* 710 */     int tp = this.npcTp;
/* 711 */     int add = e;
/* 712 */     if (tp < JRMCoreH.getMaxTP()) {
/* 713 */       if (exp + e >= xplmt) {
/* 714 */         for (int i = 0; i < (exp + e) / xplmt; i++) {
/* 715 */           this.npcTp = tp + tpgn;
/*     */         }
/*     */       }
/*     */ 
/*     */       
/* 720 */       add = exp + e - (exp + e) / xplmt * xplmt;
/* 721 */       this.npcExp = add;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70652_k(Entity par1Entity) {
/* 731 */     float f = 0.0F;
/* 732 */     int i = 0;
/*     */     
/* 734 */     if (par1Entity instanceof EntityLivingBase) {
/*     */       
/* 736 */       f += EnchantmentHelper.func_77512_a((EntityLivingBase)this, (EntityLivingBase)par1Entity);
/* 737 */       i += EnchantmentHelper.func_77507_b((EntityLivingBase)this, (EntityLivingBase)par1Entity);
/*     */     } 
/*     */     
/* 740 */     expPls(1);
/*     */     
/* 742 */     int[] attrbts = new int[6]; String[] s1 = this.attrbts.split(":");
/* 743 */     for (int i1 = 0; i1 < 6; ) { attrbts[i1] = Integer.parseInt(s1[i1]); i1++; }
/* 744 */      float dam = (attrbts[0] * (this.field_70170_p.field_73012_v.nextInt(3) + 1)) + attrbts[3] * 0.5F * 50.0F * 0.02F;
/*     */     
/* 746 */     int dbcA = (int)(f + dam);
/*     */     
/* 748 */     f = dbcA;
/*     */ 
/*     */     
/* 751 */     boolean flag = par1Entity.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this), f);
/*     */     
/* 753 */     if (flag) {
/*     */       
/* 755 */       if (i > 0) {
/*     */         
/* 757 */         par1Entity.func_70024_g((-MathHelper.func_76126_a(this.field_70177_z * 3.1415927F / 180.0F) * i * 0.5F), 0.1D, (MathHelper.func_76134_b(this.field_70177_z * 3.1415927F / 180.0F) * i * 0.5F));
/* 758 */         this.field_70159_w *= 0.6D;
/* 759 */         this.field_70179_y *= 0.6D;
/*     */       } 
/*     */       
/* 762 */       int j = EnchantmentHelper.func_90036_a((EntityLivingBase)this);
/*     */       
/* 764 */       if (j > 0)
/*     */       {
/* 766 */         par1Entity.func_70015_d(j * 4);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 775 */     return flag;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70645_a(DamageSource par1DamageSource) {
/* 780 */     if (!this.field_70170_p.field_72995_K) {
/* 781 */       func_82160_b(true, 0);
/* 782 */       MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
/*     */       
/* 784 */       String cd = FamilyCH.rcfd(server, this.cid + "");
/* 785 */       FamilyCH.wcfd(server, "d", this.cid, true);
/*     */       
/* 787 */       String pm = FamilyCH.rpfd(server, this.mom);
/* 788 */       String[] pmd = pm.split(";");
/* 789 */       String pmdn = "d";
/* 790 */       for (int i = 0; i < pmd.length; i++) {
/* 791 */         if (!pmd[i].equalsIgnoreCase(this.cid + ":" + this.dad)) {
/* 792 */           pmdn = pmdn + ";" + pmd[i];
/*     */         }
/*     */       } 
/* 795 */       pmdn = (pmdn.length() > 1) ? pmdn.substring(2) : pmdn;
/* 796 */       FamilyCH.wpfd(server, pmdn, this.mom, (pmdn.length() < 2 && pmdn.startsWith("d")));
/* 797 */       EntityPlayer mom = this.field_70170_p.func_72924_a(this.mom);
/* 798 */       if (mom != null) {
/* 799 */         Entity var3 = par1DamageSource.func_76346_g();
/* 800 */         mom.func_145747_a((IChatComponent)new ChatComponentText("§eYour child " + this.nam + " has died" + ((var3 != null && var3.func_70005_c_() != null) ? (" because of " + var3.func_70005_c_()) : "") + "."));
/*     */       } 
/* 802 */       if (!this.mom.equalsIgnoreCase(this.dad)) {
/* 803 */         String pd = FamilyCH.rpfd(server, this.dad);
/* 804 */         String[] pdd = pm.split(";");
/* 805 */         String pddn = "d";
/* 806 */         for (int j = 0; j < pdd.length; j++) {
/* 807 */           if (!pdd[j].equalsIgnoreCase(this.cid + ":" + this.dad)) {
/* 808 */             pddn = pddn + ";" + pdd[j];
/*     */           }
/*     */         } 
/* 811 */         pddn = (pddn.length() > 1) ? pddn.substring(2) : pddn;
/* 812 */         FamilyCH.wpfd(server, pddn, this.dad, (pddn.length() < 2 && pddn.startsWith("d")));
/* 813 */         EntityPlayer dad = this.field_70170_p.func_72924_a(this.dad);
/* 814 */         if (dad != null) {
/* 815 */           Entity var3 = par1DamageSource.func_76346_g();
/* 816 */           dad.func_145747_a((IChatComponent)new ChatComponentText("§eYour child " + this.nam + " has died" + ((var3 != null && var3.func_70005_c_() != null) ? (" because of " + var3.func_70005_c_()) : "") + "."));
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 822 */     super.func_70645_a(par1DamageSource);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70785_a(Entity par1Entity, float par2) {
/* 830 */     if (this.field_70724_aR <= 0 && par2 < 2.0F && par1Entity.field_70121_D.field_72337_e > this.field_70121_D.field_72338_b && par1Entity.field_70121_D.field_72338_b < this.field_70121_D.field_72337_e) {
/*     */       
/* 832 */       this.field_70724_aR = 20;
/* 833 */       func_70652_k(par1Entity);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeSpawnData(ByteBuf data) {
/* 839 */     data.writeInt(this.maxHealth);
/* 840 */     data.writeByte(this.cnam);
/* 841 */     ByteBufUtils.writeUTF8String(data, this.dns);
/* 842 */     ByteBufUtils.writeUTF8String(data, this.dnsH);
/* 843 */     ByteBufUtils.writeUTF8String(data, this.nam);
/* 844 */     ByteBufUtils.writeUTF8String(data, this.mom);
/* 845 */     ByteBufUtils.writeUTF8String(data, this.dad);
/* 846 */     data.writeInt(this.cid);
/* 847 */     data.writeFloat(this.age);
/* 848 */     data.writeFloat(this.grw);
/* 849 */     data.writeBoolean(this.aggr);
/* 850 */     data.writeInt(this.follow);
/* 851 */     data.writeInt(this.followTarget);
/* 852 */     ByteBufUtils.writeUTF8String(data, this.attrbts);
/* 853 */     ByteBufUtils.writeUTF8String(data, this.skills);
/* 854 */     ByteBufUtils.writeUTF8String(data, this.techs);
/* 855 */     ByteBufUtils.writeUTF8String(data, this.bonuses);
/* 856 */     data.writeInt(this.npcExp);
/* 857 */     data.writeInt(this.npcTp);
/* 858 */     data.writeInt(this.npcSt);
/* 859 */     data.writeInt(this.energy);
/* 860 */     data.writeInt(this.maxEnergy);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void readSpawnData(ByteBuf data) {
/* 866 */     this.maxHealth = data.readInt();
/* 867 */     this.cnam = data.readByte();
/* 868 */     this.dns = ByteBufUtils.readUTF8String(data);
/* 869 */     this.dnsH = ByteBufUtils.readUTF8String(data);
/* 870 */     this.nam = ByteBufUtils.readUTF8String(data);
/* 871 */     this.mom = ByteBufUtils.readUTF8String(data);
/* 872 */     this.dad = ByteBufUtils.readUTF8String(data);
/* 873 */     this.cid = data.readInt();
/* 874 */     this.age = data.readFloat();
/* 875 */     this.grw = data.readFloat();
/* 876 */     this.aggr = data.readBoolean();
/* 877 */     this.follow = data.readInt();
/* 878 */     this.followTarget = data.readInt();
/* 879 */     this.attrbts = ByteBufUtils.readUTF8String(data);
/* 880 */     this.techs = ByteBufUtils.readUTF8String(data);
/* 881 */     this.bonuses = ByteBufUtils.readUTF8String(data);
/* 882 */     this.npcExp = data.readInt();
/* 883 */     this.npcTp = data.readInt();
/* 884 */     this.npcSt = data.readInt();
/* 885 */     this.energy = data.readInt();
/* 886 */     this.maxEnergy = data.readInt();
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JFamilyC-v1.2.18.jar!\JinRyuu\FamilyC\EntityNPC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */