/*     */ package JinRyuu.JRMCore.entity;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreConfig;
/*     */ import JinRyuu.JRMCore.JRMCoreEH;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.JRMCoreH2;
/*     */ import JinRyuu.JRMCore.server.JGMathHelper;
/*     */ import cpw.mods.fml.common.network.ByteBufUtils;
/*     */ import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntitySafeZone
/*     */   extends EntityJRMC implements IEntityAdditionalSpawnData {
/*  31 */   public static final HashMap<Class, Boolean> safezoneListResults = new HashMap<Class<?>, Boolean>();
/*     */   
/*  33 */   public final float var1 = 8.0F;
/*  34 */   public final float maxDistanceForPlayer = 4.0F;
/*     */   
/*     */   protected Entity closestEntity;
/*     */   
/*     */   private int lookTime;
/*     */   
/*     */   private Class watchedClass;
/*  41 */   public int holdRotation = -1;
/*     */   
/*  43 */   private List playerList = new ArrayList();
/*     */   
/*  45 */   private int jumpTicks = 0;
/*     */   
/*  47 */   public int duplicatesRadius = 2;
/*  48 */   public int safezoneRadiusXZ = 60;
/*  49 */   public int safezoneRadiusY = 60;
/*     */ 
/*     */   
/*  52 */   public String name = "";
/*     */ 
/*     */   
/*     */   public EntitySafeZone(World world) {
/*  56 */     super(world);
/*  57 */     this.field_70728_aV = 0;
/*  58 */     func_94058_c("");
/*  59 */     func_94061_f(false);
/*     */     
/*  61 */     int r2 = (this.field_71093_bK == 22) ? 20 : ((this.field_71093_bK == 24) ? -54 : 0);
/*  62 */     this.safezoneRadiusXZ += r2;
/*  63 */     this.safezoneRadiusY += r2;
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
/*     */   public EntitySafeZone(World world, String name) {
/*  79 */     this(world);
/*  80 */     this.name = name;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  85 */     super.func_110147_ax();
/*  86 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(10000.0D);
/*  87 */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.0D);
/*     */   }
/*     */   
/*     */   protected boolean func_70780_i()
/*     */   {
/*  92 */     return true; } protected boolean func_70692_ba() {
/*  93 */     return false;
/*     */   }
/*     */   protected void func_70619_bc() {}
/*  96 */   public void func_70024_g(double par1, double par3, double par5) { this.field_70160_al = false; } public void func_70108_f(Entity entity) {} protected void func_70018_K() {
/*  97 */     this.field_70133_I = false; } public boolean func_70104_M() {
/*  98 */     return false;
/*     */   } protected void func_82167_n(Entity entity) {}
/* 100 */   public boolean func_70097_a(DamageSource damageSource, float par2) { return false; }
/* 101 */   public boolean func_70652_k(Entity entity) { return false; } public int MaxHealth() {
/* 102 */     return 2000;
/*     */   } @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/* 105 */     return "jinryuumodscore:npcs/TrainingShadowDummy.png";
/*     */   }
/*     */   
/*     */   public boolean func_70085_c(EntityPlayer player) {
/* 109 */     return super.func_70085_c(player);
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
/*     */   public void shouldExecute() {
/* 122 */     if (this.holdRotation == -1) {
/*     */       
/* 124 */       getClass(); this.closestEntity = (Entity)this.field_70170_p.func_72890_a((Entity)this, 4.0D);
/*     */       
/* 126 */       if (this.closestEntity != null) {
/*     */         
/* 128 */         this.watchedClass = EntityPlayer.class;
/* 129 */         func_70671_ap().func_75650_a(this.closestEntity.field_70165_t, this.closestEntity.field_70163_u + 2.0D, this.closestEntity.field_70161_v, 10.0F, func_70646_bf());
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean addInstance(Class cl, boolean b) {
/* 135 */     safezoneListResults.put(cl, Boolean.valueOf(b));
/* 136 */     return b;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean instanceOf(Entity entity) {
/* 141 */     if (JRMCoreConfig.SafeZoneEntityBlacklist.size() == 0) return false;
/*     */     
/* 143 */     Class<?> entityClass = entity.getClass();
/* 144 */     if (safezoneListResults != null && safezoneListResults.size() > 0 && safezoneListResults.containsKey(entityClass)) {
/* 145 */       return ((Boolean)safezoneListResults.get(entityClass)).booleanValue();
/*     */     }
/*     */     
/* 148 */     String name = entityClass.toString();
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 153 */       if (JRMCoreConfig.SafeZoneEntityBlacklist.containsKey(name) && (JRMCoreConfig.SafeZoneEntityWhitelist
/* 154 */         .size() == 0 || !JRMCoreConfig.SafeZoneEntityWhitelist.containsKey(name)))
/*     */       {
/* 156 */         return addInstance(entityClass, true);
/*     */       }
/*     */ 
/*     */       
/* 160 */       for (String key : JRMCoreConfig.SafeZoneEntityWhitelist.keySet()) {
/*     */         
/* 162 */         if ((!JRMCoreH.DBC() && key.startsWith("JinRyuu.DragonBC")) || (!JRMCoreH.NC() && key.startsWith("JinRyuu.NarutoC")))
/*     */           continue; 
/* 164 */         Class<?> cl = Class.forName(key);
/*     */         
/* 166 */         if (cl.isAssignableFrom(entityClass))
/*     */         {
/* 168 */           return addInstance(entityClass, false);
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 173 */       for (String key : JRMCoreConfig.SafeZoneEntityBlacklist.keySet())
/*     */       {
/* 175 */         if ((!JRMCoreH.DBC() && key.startsWith("JinRyuu.DragonBC")) || (!JRMCoreH.NC() && key.startsWith("JinRyuu.NarutoC")))
/*     */           continue; 
/* 177 */         Class<?> cl = Class.forName(key);
/*     */         
/* 179 */         if (cl.isAssignableFrom(entityClass))
/*     */         {
/* 181 */           return addInstance(entityClass, true);
/*     */         }
/*     */       }
/*     */     
/* 185 */     } catch (Exception exception) {}
/*     */     
/* 187 */     return addInstance(entityClass, false);
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
/*     */   public boolean isEntityOnTheBlacklist(Entity entity) {
/* 201 */     return instanceOf(entity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isMostLikelyMe(Entity entity) {
/* 207 */     if (entity instanceof EntitySafeZone) {
/*     */       
/* 209 */       EntitySafeZone zone = (EntitySafeZone)entity;
/* 210 */       if (zone.getClass().toString().equals(getClass().toString()) && this.name
/* 211 */         .equals(zone.name) && this.duplicatesRadius == zone.duplicatesRadius && this.safezoneRadiusY == zone.safezoneRadiusY && this.safezoneRadiusXZ == zone.safezoneRadiusXZ && 
/*     */ 
/*     */ 
/*     */         
/* 215 */         JGMathHelper.doubleSmallerThan(this.field_70165_t - zone.field_70165_t, 1.0D) && 
/* 216 */         JGMathHelper.doubleSmallerThan(this.field_70163_u - zone.field_70163_u, 1.0D) && 
/* 217 */         JGMathHelper.doubleSmallerThan(this.field_70161_v - zone.field_70161_v, 1.0D))
/*     */       {
/*     */         
/* 220 */         return true;
/*     */       }
/*     */     } 
/* 223 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/* 228 */     if (!this.field_70170_p.field_72995_K && this.field_70128_L) {
/*     */       
/* 230 */       func_70106_y();
/*     */       
/*     */       return;
/*     */     } 
/* 234 */     if (this.field_70173_aa / 20 == 0) {
/*     */       
/* 236 */       boolean add = true;
/* 237 */       int length = JRMCoreEH.allSafeZones.size();
/* 238 */       for (int i = length - 1; i >= 0; i--) {
/* 239 */         EntitySafeZone safezone = JRMCoreEH.allSafeZones.get(i);
/* 240 */         if (safezone != null && isMostLikelyMe(JRMCoreEH.allSafeZones.get(i))) {
/* 241 */           add = false;
/*     */         }
/* 243 */         else if (safezone == null || safezone.field_70128_L) {
/*     */           
/* 245 */           JRMCoreEH.allSafeZones.remove(i);
/*     */         } 
/*     */       } 
/* 248 */       if (add) JRMCoreEH.allSafeZones.add(this);
/*     */     
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 259 */     if (!this.field_70170_p.field_72995_K) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 267 */       int r = this.duplicatesRadius;
/* 268 */       if (r > 0) {
/*     */         
/* 270 */         List<Entity> removeDuplicates = new ArrayList();
/*     */         
/* 272 */         AxisAlignedBB ab = AxisAlignedBB.func_72330_a(this.field_70165_t - r, this.field_70163_u - r, this.field_70161_v - r, this.field_70165_t + r, this.field_70163_u + r, this.field_70161_v + r);
/* 273 */         List<Entity> list = this.field_70170_p.func_72839_b((Entity)this.field_70717_bb, ab);
/*     */         int i;
/* 275 */         for (i = 0; list.size() > i; i++) {
/*     */           
/* 277 */           Entity entity = list.get(i);
/*     */           
/* 279 */           if (entity instanceof EntitySafeZone) {
/*     */             
/* 281 */             EntitySafeZone p = (EntitySafeZone)entity;
/* 282 */             if (!removeDuplicates.contains(p))
/*     */             {
/* 284 */               removeDuplicates.add(entity);
/*     */             }
/*     */           } 
/*     */         } 
/*     */         
/* 289 */         for (i = 0; removeDuplicates.size() > i; i++) {
/*     */           
/* 291 */           Entity entity = removeDuplicates.get(i);
/* 292 */           if (i > 0) {
/*     */             
/* 294 */             entity.func_70106_y();
/* 295 */             removeDuplicates.remove(entity);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 302 */       if (JRMCoreConfig.sfzns)
/*     */       
/*     */       { 
/* 305 */         List<Entity> list2 = createSafeZoneList();
/*     */         
/* 307 */         if (this.safezoneRadiusXZ != 0 && this.safezoneRadiusY != 0)
/*     */         {
/* 309 */           for (int j = 0; list2.size() > j; j++) {
/*     */             
/* 311 */             Entity entity = list2.get(j);
/*     */             
/* 313 */             if (isEntityOnTheBlacklist(entity))
/*     */             {
/* 315 */               entity.func_70106_y();
/*     */             }
/*     */             
/* 318 */             if (entity instanceof EntityEnAttacks) {
/*     */               
/* 320 */               if (((EntityEnAttacks)entity).shootingEntity instanceof EntityPlayer) {
/*     */                 
/* 322 */                 String t = JRMCoreH.trlai("jinryuujrmcore.entitymasters.nofightinsafe");
/* 323 */                 ((EntityPlayer)((EntityEnAttacks)entity).shootingEntity).func_145747_a((new ChatComponentTranslation(t, new Object[0])).func_150255_a(JRMCoreH2.styl_ylw));
/*     */               } 
/* 325 */               entity.func_70106_y();
/*     */             } 
/*     */             
/* 328 */             if (entity instanceof EntityPunch) {
/*     */               
/* 330 */               if (((EntityPunch)entity).shootingEntity instanceof EntityPlayer) {
/*     */                 
/* 332 */                 String t = JRMCoreH.trlai("jinryuujrmcore.entitymasters.nofightinsafe");
/* 333 */                 ((EntityPlayer)((EntityPunch)entity).shootingEntity).func_145747_a((new ChatComponentTranslation(t, new Object[0])).func_150255_a(JRMCoreH2.styl_ylw));
/*     */               } 
/* 335 */               entity.func_70106_y();
/*     */             } 
/*     */             
/* 338 */             if (entity instanceof EntityPlayer) {
/*     */               
/* 340 */               EntityPlayer p = (EntityPlayer)entity;
/* 341 */               if (!this.playerList.contains(p))
/*     */               {
/* 343 */                 if (this.name != null && this.name.length() > 0) {
/*     */                   
/* 345 */                   this.playerList.add(entity);
/*     */ 
/*     */                   
/* 348 */                   p.func_145747_a((IChatComponent)new ChatComponentText("jinryuujrmcore.entitymasters.insafezone:" + this.name));
/*     */                 
/*     */                 }
/*     */                 else {
/*     */                   
/* 353 */                   this.playerList.add(entity);
/*     */ 
/*     */                   
/* 356 */                   p.func_145747_a((IChatComponent)new ChatComponentText("jinryuujrmcore.entitymasters.insaafezone:" + this.name));
/*     */                 } 
/*     */               }
/*     */             } 
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 384 */         for (int i = 0; this.playerList.size() > i; i++) {
/*     */           
/* 386 */           Entity entity = this.playerList.get(i);
/* 387 */           boolean delete = true;
/*     */           
/* 389 */           if (list2.contains(entity)) delete = false;
/*     */           
/* 391 */           if (delete) {
/*     */             
/* 393 */             this.playerList.remove(entity);
/* 394 */             EntityPlayer player = (EntityPlayer)entity;
/* 395 */             if (this.name != null && this.name.length() > 0)
/*     */             {
/*     */ 
/*     */               
/* 399 */               player.func_145747_a((IChatComponent)new ChatComponentText("jinryuujrmcore.entitymasters.leftsafe:" + this.name));
/*     */             
/*     */             }
/*     */             else
/*     */             {
/*     */               
/* 405 */               player.func_145747_a((IChatComponent)new ChatComponentText("jinryuujrmcore.entitymasters.leftasafe:" + this.name));
/*     */             }
/*     */           
/*     */           } 
/*     */         }  }
/* 410 */       else if (this.playerList.size() > 0) { this.playerList.clear(); }
/*     */     
/*     */     } 
/* 413 */     super.func_70071_h_();
/* 414 */     shouldExecute();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70106_y() {
/* 421 */     int length = JRMCoreEH.allSafeZones.size();
/* 422 */     for (int i = length - 1; i >= 0; i--) {
/* 423 */       EntitySafeZone safezone = JRMCoreEH.allSafeZones.get(i);
/* 424 */       if (safezone != null && isMostLikelyMe(JRMCoreEH.allSafeZones.get(i))) {
/* 425 */         JRMCoreEH.allSafeZones.remove(i);
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 430 */     removeAllPlayers();
/* 431 */     super.func_70106_y();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/* 437 */     this.field_70181_x = 0.0D;
/*     */     
/* 439 */     if (this.jumpTicks > 0)
/*     */     {
/* 441 */       this.jumpTicks--;
/*     */     }
/*     */     
/* 444 */     if (this.field_70716_bi > 0) {
/*     */       
/* 446 */       double d0 = this.field_70165_t + (this.field_70709_bj - this.field_70165_t) / this.field_70716_bi;
/* 447 */       double d1 = this.field_70163_u + (this.field_70710_bk - this.field_70163_u) / this.field_70716_bi;
/* 448 */       double d2 = this.field_70161_v + (this.field_110152_bk - this.field_70161_v) / this.field_70716_bi;
/* 449 */       double d3 = MathHelper.func_76138_g(this.field_70712_bm - this.field_70177_z);
/* 450 */       this.field_70177_z = (float)(this.field_70177_z + d3 / this.field_70716_bi);
/* 451 */       this.field_70125_A = (float)(this.field_70125_A + (this.field_70705_bn - this.field_70125_A) / this.field_70716_bi);
/* 452 */       this.field_70716_bi--;
/* 453 */       func_70107_b(d0, d1, d2);
/* 454 */       func_70101_b(this.field_70177_z, this.field_70125_A);
/*     */     }
/* 456 */     else if (!func_70613_aW()) {
/*     */       
/* 458 */       this.field_70159_w = 0.0D;
/* 459 */       this.field_70181_x = 0.0D;
/* 460 */       this.field_70179_y = 0.0D;
/*     */     } 
/*     */     
/* 463 */     if (Math.abs(this.field_70159_w) < 0.005D)
/*     */     {
/* 465 */       this.field_70159_w = 0.0D;
/*     */     }
/*     */     
/* 468 */     if (Math.abs(this.field_70181_x) < 0.005D)
/*     */     {
/* 470 */       this.field_70181_x = 0.0D;
/*     */     }
/*     */     
/* 473 */     if (Math.abs(this.field_70179_y) < 0.005D)
/*     */     {
/* 475 */       this.field_70179_y = 0.0D;
/*     */     }
/*     */     
/* 478 */     this.field_70170_p.field_72984_F.func_76320_a("ai");
/*     */     
/* 480 */     if (func_70610_aX()) {
/*     */       
/* 482 */       this.field_70703_bu = false;
/* 483 */       this.field_70702_br = 0.0F;
/* 484 */       this.field_70701_bs = 0.0F;
/* 485 */       this.field_70704_bt = 0.0F;
/*     */     }
/* 487 */     else if (func_70613_aW()) {
/*     */       
/* 489 */       if (func_70650_aV()) {
/*     */         
/* 491 */         this.field_70170_p.field_72984_F.func_76320_a("newAi");
/* 492 */         func_70619_bc();
/* 493 */         this.field_70170_p.field_72984_F.func_76319_b();
/*     */       }
/*     */       else {
/*     */         
/* 497 */         this.field_70170_p.field_72984_F.func_76320_a("oldAi");
/* 498 */         this.field_70170_p.field_72984_F.func_76319_b();
/* 499 */         this.field_70759_as = this.field_70177_z;
/*     */       } 
/*     */     } 
/*     */     
/* 503 */     this.field_70170_p.field_72984_F.func_76319_b();
/* 504 */     this.field_70170_p.field_72984_F.func_76320_a("jump");
/*     */     
/* 506 */     if (this.field_70703_bu) {
/*     */       
/* 508 */       if (!func_70090_H() && !func_70058_J()) {
/*     */         
/* 510 */         if (this.field_70122_E && this.jumpTicks == 0)
/*     */         {
/* 512 */           func_70664_aZ();
/* 513 */           this.jumpTicks = 10;
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 518 */         this.field_70181_x += 0.03999999910593033D;
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 523 */       this.jumpTicks = 0;
/*     */     } 
/*     */     
/* 526 */     this.field_70170_p.field_72984_F.func_76319_b();
/* 527 */     this.field_70170_p.field_72984_F.func_76320_a("travel");
/* 528 */     this.field_70702_br *= 0.0F;
/* 529 */     this.field_70701_bs *= 0.0F;
/* 530 */     this.field_70704_bt *= 0.0F;
/*     */     
/* 532 */     this.field_70170_p.field_72984_F.func_76319_b();
/* 533 */     this.field_70170_p.field_72984_F.func_76320_a("push");
/*     */     
/* 535 */     if (!this.field_70170_p.field_72995_K)
/*     */     {
/* 537 */       func_85033_bc();
/*     */     }
/*     */     
/* 540 */     this.field_70170_p.field_72984_F.func_76319_b();
/*     */ 
/*     */     
/* 543 */     EntityPlayer var2 = this.field_70170_p.func_72890_a((Entity)this, 8.0D);
/*     */     
/* 545 */     if (var2 != null && this.holdRotation == -1) {
/*     */       
/* 547 */       this.closestEntity = (Entity)var2;
/* 548 */       this.field_70700_bx = 10 + this.field_70146_Z.nextInt(20);
/*     */     }
/*     */     else {
/*     */       
/* 552 */       this.field_70704_bt = (this.field_70146_Z.nextFloat() - 0.5F) * 20.0F;
/*     */     } 
/*     */ 
/*     */     
/* 556 */     if (this.closestEntity != null && this.holdRotation == -1) {
/*     */       
/* 558 */       func_70625_a(this.closestEntity, 10.0F, func_70646_bf());
/*     */       
/* 560 */       if (this.field_70700_bx-- <= 0 || this.closestEntity.field_70128_L || this.closestEntity.func_70068_e((Entity)this) > 64.0D)
/*     */       {
/* 562 */         this.closestEntity = null;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70601_bi() {
/* 569 */     return (this.field_70170_p.func_72855_b(this.field_70121_D) && this.field_70170_p.func_72945_a((Entity)this, this.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(this.field_70121_D));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70625_a(Entity p_70625_1_, float p_70625_2_, float p_70625_3_) {
/* 577 */     double d1, d0 = p_70625_1_.field_70165_t - this.field_70165_t;
/* 578 */     double d2 = p_70625_1_.field_70161_v - this.field_70161_v;
/*     */ 
/*     */     
/* 581 */     if (p_70625_1_ instanceof EntityLivingBase) {
/*     */       
/* 583 */       EntityLivingBase entitylivingbase = (EntityLivingBase)p_70625_1_;
/* 584 */       d1 = entitylivingbase.field_70163_u + (entitylivingbase.field_70131_O * 0.85F) - 1.600000023841858D - this.field_70163_u + func_70047_e();
/*     */     }
/*     */     else {
/*     */       
/* 588 */       d1 = (p_70625_1_.field_70121_D.field_72338_b + p_70625_1_.field_70121_D.field_72337_e) / 2.0D - this.field_70163_u + func_70047_e();
/*     */     } 
/*     */     
/* 591 */     double d3 = MathHelper.func_76133_a(d0 * d0 + d2 * d2);
/* 592 */     float f2 = (float)(Math.atan2(d2, d0) * 180.0D / Math.PI) - 90.0F;
/* 593 */     float f3 = (float)-(Math.atan2(d1, d3) * 180.0D / Math.PI);
/* 594 */     this.field_70125_A = updateRotation(this.field_70125_A, f3, p_70625_3_);
/* 595 */     this.field_70177_z = updateRotation(this.field_70177_z, f2, p_70625_2_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private float updateRotation(float currRot, float intendedRot, float maxIncrement) {
/* 603 */     float f3 = MathHelper.func_76142_g(intendedRot - currRot);
/* 604 */     if (f3 > maxIncrement) f3 = maxIncrement; 
/* 605 */     if (f3 < -maxIncrement) f3 = -maxIncrement; 
/* 606 */     return currRot + f3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeSpawnData(ByteBuf buffer) {
/* 613 */     buffer.writeInt(this.holdRotation);
/* 614 */     buffer.writeInt(this.duplicatesRadius);
/* 615 */     buffer.writeInt(this.safezoneRadiusXZ);
/* 616 */     buffer.writeInt(this.safezoneRadiusY);
/*     */     
/* 618 */     ByteBufUtils.writeUTF8String(buffer, this.name);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void readSpawnData(ByteBuf buffer) {
/* 624 */     this.holdRotation = buffer.readInt();
/* 625 */     this.duplicatesRadius = buffer.readInt();
/* 626 */     this.safezoneRadiusXZ = buffer.readInt();
/* 627 */     this.safezoneRadiusY = buffer.readInt();
/*     */     
/* 629 */     this.name = ByteBufUtils.readUTF8String(buffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound nbt) {
/* 634 */     super.func_70014_b(nbt);
/* 635 */     nbt.func_74768_a("holdRotation", this.holdRotation);
/* 636 */     nbt.func_74768_a("duplicatesRadius", this.duplicatesRadius);
/* 637 */     nbt.func_74768_a("safezoneRadiusXZ", this.safezoneRadiusXZ);
/* 638 */     nbt.func_74768_a("safezoneRadiusY", this.safezoneRadiusY);
/*     */     
/* 640 */     nbt.func_74778_a("safezonename", this.name);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound nbt) {
/* 645 */     super.func_70037_a(nbt);
/* 646 */     if (nbt.func_74764_b("holdRotation")) this.holdRotation = nbt.func_74762_e("holdRotation"); 
/* 647 */     if (nbt.func_74764_b("duplicatesRadius")) this.duplicatesRadius = nbt.func_74762_e("duplicatesRadius"); 
/* 648 */     if (nbt.func_74764_b("safezoneRadiusXZ")) this.safezoneRadiusXZ = nbt.func_74762_e("safezoneRadiusXZ"); 
/* 649 */     if (nbt.func_74764_b("safezoneRadiusY")) this.safezoneRadiusY = nbt.func_74762_e("safezoneRadiusY");
/*     */     
/* 651 */     if (nbt.func_74764_b("safezonename")) this.name = nbt.func_74779_i("safezonename");
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB createSafeZoneHitBox() {
/* 658 */     int r2XZ = this.safezoneRadiusXZ;
/* 659 */     int r2Y = this.safezoneRadiusY;
/* 660 */     AxisAlignedBB ab2 = AxisAlignedBB.func_72330_a(this.field_70165_t - r2XZ, this.field_70163_u - r2Y, this.field_70161_v - r2XZ, this.field_70165_t + r2XZ, this.field_70163_u + r2Y, this.field_70161_v + r2XZ);
/*     */ 
/*     */     
/* 663 */     return ab2;
/*     */   }
/*     */   
/*     */   public List createSafeZoneList() {
/* 667 */     AxisAlignedBB ab2 = createSafeZoneHitBox();
/* 668 */     List list = this.field_70170_p.func_72839_b((Entity)this, ab2);
/* 669 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeAllPlayers() {
/* 674 */     for (int i = 0; this.playerList.size() > i; i++) {
/*     */       
/* 676 */       Entity entity = this.playerList.get(i);
/* 677 */       EntityPlayer player = (EntityPlayer)entity;
/* 678 */       if (this.name != null && this.name.length() > 0) {
/*     */         
/* 680 */         player.func_145747_a((IChatComponent)new ChatComponentText("jinryuujrmcore.entitymasters.leftsafe:" + this.name));
/*     */       }
/*     */       else {
/*     */         
/* 684 */         player.func_145747_a((IChatComponent)new ChatComponentText("jinryuujrmcore.entitymasters.leftasafe:" + this.name));
/*     */       } 
/*     */     } 
/* 687 */     this.playerList.clear();
/*     */   }
/*     */   public Entity getClosestEntity() {
/* 690 */     return this.closestEntity;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\entity\EntitySafeZone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */