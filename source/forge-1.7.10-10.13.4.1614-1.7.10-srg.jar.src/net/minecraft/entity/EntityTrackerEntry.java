/*     */ package net.minecraft.entity;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import net.minecraft.entity.ai.attributes.ServersideAttributeMap;
/*     */ import net.minecraft.entity.item.EntityFallingBlock;
/*     */ import net.minecraft.entity.item.EntityItemFrame;
/*     */ import net.minecraft.entity.item.EntityMinecart;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.entity.projectile.EntityFireball;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.server.S0EPacketSpawnObject;
/*     */ import net.minecraft.network.play.server.S12PacketEntityVelocity;
/*     */ import net.minecraft.network.play.server.S14PacketEntity;
/*     */ import net.minecraft.network.play.server.S18PacketEntityTeleport;
/*     */ import net.minecraft.network.play.server.S1BPacketEntityAttach;
/*     */ import net.minecraft.network.play.server.S20PacketEntityProperties;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.storage.MapData;
/*     */ 
/*     */ public class EntityTrackerEntry {
/*  25 */   private static final Logger field_151262_p = LogManager.getLogger(); public Entity field_73132_a; public int field_73130_b; public int field_73131_c; public int field_73128_d;
/*     */   public int field_73129_e;
/*     */   public int field_73126_f;
/*     */   public int field_73127_g;
/*     */   public int field_73139_h;
/*     */   public int field_73140_i;
/*     */   public double field_73137_j;
/*     */   public double field_73138_k;
/*     */   public double field_73135_l;
/*     */   public int field_73136_m;
/*     */   private double field_73147_p;
/*     */   private double field_73146_q;
/*     */   private double field_73145_r;
/*     */   private boolean field_73144_s;
/*     */   private boolean field_73143_t;
/*     */   private int field_73142_u;
/*     */   private Entity field_85178_v;
/*     */   private boolean field_73141_v;
/*     */   public boolean field_73133_n;
/*  44 */   public Set field_73134_o = new HashSet(); private static final String __OBFID = "CL_00001443";
/*     */   
/*     */   public EntityTrackerEntry(Entity p_i1525_1_, int p_i1525_2_, int p_i1525_3_, boolean p_i1525_4_) {
/*  47 */     this.field_73132_a = p_i1525_1_;
/*  48 */     this.field_73130_b = p_i1525_2_;
/*  49 */     this.field_73131_c = p_i1525_3_;
/*  50 */     this.field_73143_t = p_i1525_4_;
/*     */     
/*  52 */     this.field_73128_d = MathHelper.func_76128_c(p_i1525_1_.field_70165_t * 32.0D);
/*  53 */     this.field_73129_e = MathHelper.func_76128_c(p_i1525_1_.field_70163_u * 32.0D);
/*  54 */     this.field_73126_f = MathHelper.func_76128_c(p_i1525_1_.field_70161_v * 32.0D);
/*  55 */     this.field_73127_g = MathHelper.func_76141_d(p_i1525_1_.field_70177_z * 256.0F / 360.0F);
/*  56 */     this.field_73139_h = MathHelper.func_76141_d(p_i1525_1_.field_70125_A * 256.0F / 360.0F);
/*     */     
/*  58 */     this.field_73140_i = MathHelper.func_76141_d(p_i1525_1_.func_70079_am() * 256.0F / 360.0F);
/*     */   }
/*     */   
/*     */   public boolean equals(Object p_equals_1_) {
/*  62 */     if (p_equals_1_ instanceof EntityTrackerEntry) {
/*  63 */       return (((EntityTrackerEntry)p_equals_1_).field_73132_a.func_145782_y() == this.field_73132_a.func_145782_y());
/*     */     }
/*     */     
/*  66 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  70 */     return this.field_73132_a.func_145782_y();
/*     */   }
/*     */   
/*     */   public void func_73122_a(List p_73122_1_) {
/*  74 */     this.field_73133_n = false;
/*  75 */     if (!this.field_73144_s || this.field_73132_a.func_70092_e(this.field_73147_p, this.field_73146_q, this.field_73145_r) > 16.0D) {
/*  76 */       this.field_73147_p = this.field_73132_a.field_70165_t;
/*  77 */       this.field_73146_q = this.field_73132_a.field_70163_u;
/*  78 */       this.field_73145_r = this.field_73132_a.field_70161_v;
/*  79 */       this.field_73144_s = true;
/*  80 */       this.field_73133_n = true;
/*  81 */       func_73125_b(p_73122_1_);
/*     */     } 
/*     */     
/*  84 */     if (this.field_85178_v != this.field_73132_a.field_70154_o || (this.field_73132_a.field_70154_o != null && this.field_73136_m % 60 == 0)) {
/*  85 */       this.field_85178_v = this.field_73132_a.field_70154_o;
/*  86 */       func_151259_a((Packet)new S1BPacketEntityAttach(0, this.field_73132_a, this.field_73132_a.field_70154_o));
/*     */     } 
/*     */     
/*  89 */     if (this.field_73132_a instanceof EntityItemFrame && this.field_73136_m % 10 == 0) {
/*  90 */       EntityItemFrame entityItemFrame = (EntityItemFrame)this.field_73132_a;
/*  91 */       ItemStack itemStack = entityItemFrame.func_82335_i();
/*     */       
/*  93 */       if (itemStack != null && itemStack.func_77973_b() instanceof net.minecraft.item.ItemMap) {
/*  94 */         MapData mapData = Items.field_151098_aY.func_77873_a(itemStack, this.field_73132_a.field_70170_p);
/*  95 */         for (EntityPlayer entityPlayer : p_73122_1_) {
/*  96 */           EntityPlayerMP entityPlayerMP = (EntityPlayerMP)entityPlayer;
/*  97 */           mapData.func_76191_a((EntityPlayer)entityPlayerMP, itemStack);
/*     */           
/*  99 */           Packet packet = Items.field_151098_aY.func_150911_c(itemStack, this.field_73132_a.field_70170_p, (EntityPlayer)entityPlayerMP);
/* 100 */           if (packet != null) entityPlayerMP.field_71135_a.func_147359_a(packet);
/*     */         
/*     */         } 
/*     */       } 
/* 104 */       func_111190_b();
/* 105 */     } else if (this.field_73136_m % this.field_73131_c == 0 || this.field_73132_a.field_70160_al || this.field_73132_a.func_70096_w().func_75684_a()) {
/* 106 */       if (this.field_73132_a.field_70154_o == null) {
/* 107 */         S14PacketEntity.S16PacketEntityLook s16PacketEntityLook; this.field_73142_u++;
/* 108 */         int j = this.field_73132_a.field_70168_am.func_75630_a(this.field_73132_a.field_70165_t);
/* 109 */         int k = MathHelper.func_76128_c(this.field_73132_a.field_70163_u * 32.0D);
/* 110 */         int m = this.field_73132_a.field_70168_am.func_75630_a(this.field_73132_a.field_70161_v);
/* 111 */         int n = MathHelper.func_76141_d(this.field_73132_a.field_70177_z * 256.0F / 360.0F);
/* 112 */         int i1 = MathHelper.func_76141_d(this.field_73132_a.field_70125_A * 256.0F / 360.0F);
/*     */         
/* 114 */         int i2 = j - this.field_73128_d;
/* 115 */         int i3 = k - this.field_73129_e;
/* 116 */         int i4 = m - this.field_73126_f;
/*     */         
/* 118 */         S18PacketEntityTeleport s18PacketEntityTeleport = null;
/*     */         
/* 120 */         boolean bool1 = (Math.abs(i2) >= 4 || Math.abs(i3) >= 4 || Math.abs(i4) >= 4 || this.field_73136_m % 60 == 0) ? true : false;
/* 121 */         boolean bool2 = (Math.abs(n - this.field_73127_g) >= 4 || Math.abs(i1 - this.field_73139_h) >= 4) ? true : false;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 126 */         if (this.field_73136_m > 0 || this.field_73132_a instanceof EntityArrow) {
/* 127 */           if (i2 < -128 || i2 >= 128 || i3 < -128 || i3 >= 128 || i4 < -128 || i4 >= 128 || this.field_73142_u > 400 || this.field_73141_v) {
/* 128 */             this.field_73142_u = 0;
/* 129 */             s18PacketEntityTeleport = new S18PacketEntityTeleport(this.field_73132_a.func_145782_y(), j, k, m, (byte)n, (byte)i1);
/*     */           }
/* 131 */           else if (bool1 && bool2) {
/* 132 */             S14PacketEntity.S17PacketEntityLookMove s17PacketEntityLookMove = new S14PacketEntity.S17PacketEntityLookMove(this.field_73132_a.func_145782_y(), (byte)i2, (byte)i3, (byte)i4, (byte)n, (byte)i1);
/* 133 */           } else if (bool1) {
/* 134 */             S14PacketEntity.S15PacketEntityRelMove s15PacketEntityRelMove = new S14PacketEntity.S15PacketEntityRelMove(this.field_73132_a.func_145782_y(), (byte)i2, (byte)i3, (byte)i4);
/* 135 */           } else if (bool2) {
/* 136 */             s16PacketEntityLook = new S14PacketEntity.S16PacketEntityLook(this.field_73132_a.func_145782_y(), (byte)n, (byte)i1);
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/* 141 */         if (this.field_73143_t) {
/* 142 */           double d1 = this.field_73132_a.field_70159_w - this.field_73137_j;
/* 143 */           double d2 = this.field_73132_a.field_70181_x - this.field_73138_k;
/* 144 */           double d3 = this.field_73132_a.field_70179_y - this.field_73135_l;
/*     */           
/* 146 */           double d4 = 0.02D;
/*     */           
/* 148 */           double d5 = d1 * d1 + d2 * d2 + d3 * d3;
/*     */           
/* 150 */           if (d5 > d4 * d4 || (d5 > 0.0D && this.field_73132_a.field_70159_w == 0.0D && this.field_73132_a.field_70181_x == 0.0D && this.field_73132_a.field_70179_y == 0.0D)) {
/* 151 */             this.field_73137_j = this.field_73132_a.field_70159_w;
/* 152 */             this.field_73138_k = this.field_73132_a.field_70181_x;
/* 153 */             this.field_73135_l = this.field_73132_a.field_70179_y;
/* 154 */             func_151259_a((Packet)new S12PacketEntityVelocity(this.field_73132_a.func_145782_y(), this.field_73137_j, this.field_73138_k, this.field_73135_l));
/*     */           } 
/*     */         } 
/*     */         
/* 158 */         if (s16PacketEntityLook != null) {
/* 159 */           func_151259_a((Packet)s16PacketEntityLook);
/*     */         }
/*     */         
/* 162 */         func_111190_b();
/*     */         
/* 164 */         if (bool1) {
/* 165 */           this.field_73128_d = j;
/* 166 */           this.field_73129_e = k;
/* 167 */           this.field_73126_f = m;
/*     */         } 
/* 169 */         if (bool2) {
/* 170 */           this.field_73127_g = n;
/* 171 */           this.field_73139_h = i1;
/*     */         } 
/*     */         
/* 174 */         this.field_73141_v = false;
/*     */       } else {
/*     */         
/* 177 */         int j = MathHelper.func_76141_d(this.field_73132_a.field_70177_z * 256.0F / 360.0F);
/* 178 */         int k = MathHelper.func_76141_d(this.field_73132_a.field_70125_A * 256.0F / 360.0F);
/* 179 */         boolean bool = (Math.abs(j - this.field_73127_g) >= 4 || Math.abs(k - this.field_73139_h) >= 4) ? true : false;
/* 180 */         if (bool) {
/* 181 */           func_151259_a((Packet)new S14PacketEntity.S16PacketEntityLook(this.field_73132_a.func_145782_y(), (byte)j, (byte)k));
/* 182 */           this.field_73127_g = j;
/* 183 */           this.field_73139_h = k;
/*     */         } 
/*     */         
/* 186 */         this.field_73128_d = this.field_73132_a.field_70168_am.func_75630_a(this.field_73132_a.field_70165_t);
/* 187 */         this.field_73129_e = MathHelper.func_76128_c(this.field_73132_a.field_70163_u * 32.0D);
/* 188 */         this.field_73126_f = this.field_73132_a.field_70168_am.func_75630_a(this.field_73132_a.field_70161_v);
/*     */         
/* 190 */         func_111190_b();
/*     */         
/* 192 */         this.field_73141_v = true;
/*     */       } 
/*     */       
/* 195 */       int i = MathHelper.func_76141_d(this.field_73132_a.func_70079_am() * 256.0F / 360.0F);
/* 196 */       if (Math.abs(i - this.field_73140_i) >= 4) {
/* 197 */         func_151259_a((Packet)new S19PacketEntityHeadLook(this.field_73132_a, (byte)i));
/* 198 */         this.field_73140_i = i;
/*     */       } 
/* 200 */       this.field_73132_a.field_70160_al = false;
/*     */     } 
/*     */     
/* 203 */     this.field_73136_m++;
/*     */     
/* 205 */     if (this.field_73132_a.field_70133_I) {
/* 206 */       func_151261_b((Packet)new S12PacketEntityVelocity(this.field_73132_a));
/* 207 */       this.field_73132_a.field_70133_I = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_111190_b() {
/* 212 */     DataWatcher dataWatcher = this.field_73132_a.func_70096_w();
/* 213 */     if (dataWatcher.func_75684_a()) {
/* 214 */       func_151261_b((Packet)new S1CPacketEntityMetadata(this.field_73132_a.func_145782_y(), dataWatcher, false));
/*     */     }
/*     */     
/* 217 */     if (this.field_73132_a instanceof EntityLivingBase) {
/* 218 */       ServersideAttributeMap serversideAttributeMap = (ServersideAttributeMap)((EntityLivingBase)this.field_73132_a).func_110140_aT();
/* 219 */       Set set = serversideAttributeMap.func_111161_b();
/*     */       
/* 221 */       if (!set.isEmpty()) {
/* 222 */         func_151261_b((Packet)new S20PacketEntityProperties(this.field_73132_a.func_145782_y(), set));
/*     */       }
/*     */       
/* 225 */       set.clear();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_151259_a(Packet p_151259_1_) {
/* 230 */     for (EntityPlayerMP entityPlayerMP : this.field_73134_o) {
/* 231 */       entityPlayerMP.field_71135_a.func_147359_a(p_151259_1_);
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_151261_b(Packet p_151261_1_) {
/* 236 */     func_151259_a(p_151261_1_);
/* 237 */     if (this.field_73132_a instanceof EntityPlayerMP) {
/* 238 */       ((EntityPlayerMP)this.field_73132_a).field_71135_a.func_147359_a(p_151261_1_);
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_73119_a() {
/* 243 */     for (EntityPlayerMP entityPlayerMP : this.field_73134_o) {
/* 244 */       entityPlayerMP.func_152339_d(this.field_73132_a);
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_73118_a(EntityPlayerMP p_73118_1_) {
/* 249 */     if (this.field_73134_o.contains(p_73118_1_)) {
/* 250 */       p_73118_1_.func_152339_d(this.field_73132_a);
/* 251 */       this.field_73134_o.remove(p_73118_1_);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_73117_b(EntityPlayerMP p_73117_1_) {
/* 256 */     if (p_73117_1_ == this.field_73132_a)
/*     */       return; 
/* 258 */     double d1 = p_73117_1_.field_70165_t - (this.field_73128_d / 32);
/* 259 */     double d2 = p_73117_1_.field_70161_v - (this.field_73126_f / 32);
/* 260 */     if (d1 >= -this.field_73130_b && d1 <= this.field_73130_b && d2 >= -this.field_73130_b && d2 <= this.field_73130_b) {
/* 261 */       if (!this.field_73134_o.contains(p_73117_1_) && (func_73121_d(p_73117_1_) || this.field_73132_a.field_98038_p)) {
/* 262 */         this.field_73134_o.add(p_73117_1_);
/* 263 */         Packet packet = func_151260_c();
/* 264 */         p_73117_1_.field_71135_a.func_147359_a(packet);
/*     */         
/* 266 */         if (!this.field_73132_a.func_70096_w().func_92085_d()) {
/* 267 */           p_73117_1_.field_71135_a.func_147359_a((Packet)new S1CPacketEntityMetadata(this.field_73132_a.func_145782_y(), this.field_73132_a.func_70096_w(), true));
/*     */         }
/*     */         
/* 270 */         if (this.field_73132_a instanceof EntityLivingBase) {
/* 271 */           ServersideAttributeMap serversideAttributeMap = (ServersideAttributeMap)((EntityLivingBase)this.field_73132_a).func_110140_aT();
/* 272 */           Collection collection = serversideAttributeMap.func_111160_c();
/*     */           
/* 274 */           if (!collection.isEmpty()) {
/* 275 */             p_73117_1_.field_71135_a.func_147359_a((Packet)new S20PacketEntityProperties(this.field_73132_a.func_145782_y(), collection));
/*     */           }
/*     */         } 
/*     */         
/* 279 */         this.field_73137_j = this.field_73132_a.field_70159_w;
/* 280 */         this.field_73138_k = this.field_73132_a.field_70181_x;
/* 281 */         this.field_73135_l = this.field_73132_a.field_70179_y;
/*     */         
/* 283 */         if (this.field_73143_t && !(packet instanceof S0FPacketSpawnMob)) {
/* 284 */           p_73117_1_.field_71135_a.func_147359_a((Packet)new S12PacketEntityVelocity(this.field_73132_a.func_145782_y(), this.field_73132_a.field_70159_w, this.field_73132_a.field_70181_x, this.field_73132_a.field_70179_y));
/*     */         }
/*     */         
/* 287 */         if (this.field_73132_a.field_70154_o != null) {
/* 288 */           p_73117_1_.field_71135_a.func_147359_a((Packet)new S1BPacketEntityAttach(0, this.field_73132_a, this.field_73132_a.field_70154_o));
/*     */         }
/* 290 */         if (this.field_73132_a instanceof EntityLiving && ((EntityLiving)this.field_73132_a).func_110166_bE() != null) {
/* 291 */           p_73117_1_.field_71135_a.func_147359_a((Packet)new S1BPacketEntityAttach(1, this.field_73132_a, ((EntityLiving)this.field_73132_a).func_110166_bE()));
/*     */         }
/*     */         
/* 294 */         if (this.field_73132_a instanceof EntityLivingBase) {
/* 295 */           for (byte b = 0; b < 5; b++) {
/* 296 */             ItemStack itemStack = ((EntityLivingBase)this.field_73132_a).func_71124_b(b);
/* 297 */             if (itemStack != null) p_73117_1_.field_71135_a.func_147359_a((Packet)new S04PacketEntityEquipment(this.field_73132_a.func_145782_y(), b, itemStack));
/*     */           
/*     */           } 
/*     */         }
/* 301 */         if (this.field_73132_a instanceof EntityPlayer) {
/* 302 */           EntityPlayer entityPlayer = (EntityPlayer)this.field_73132_a;
/* 303 */           if (entityPlayer.func_70608_bn()) {
/* 304 */             p_73117_1_.field_71135_a.func_147359_a((Packet)new S0APacketUseBed(entityPlayer, MathHelper.func_76128_c(this.field_73132_a.field_70165_t), MathHelper.func_76128_c(this.field_73132_a.field_70163_u), MathHelper.func_76128_c(this.field_73132_a.field_70161_v)));
/*     */           }
/*     */         } 
/*     */         
/* 308 */         if (this.field_73132_a instanceof EntityLivingBase) {
/* 309 */           EntityLivingBase entityLivingBase = (EntityLivingBase)this.field_73132_a;
/* 310 */           for (PotionEffect potionEffect : entityLivingBase.func_70651_bq()) {
/* 311 */             p_73117_1_.field_71135_a.func_147359_a((Packet)new S1DPacketEntityEffect(this.field_73132_a.func_145782_y(), potionEffect));
/*     */           }
/*     */         }
/*     */       
/*     */       } 
/* 316 */     } else if (this.field_73134_o.contains(p_73117_1_)) {
/* 317 */       this.field_73134_o.remove(p_73117_1_);
/* 318 */       p_73117_1_.func_152339_d(this.field_73132_a);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean func_73121_d(EntityPlayerMP p_73121_1_) {
/* 324 */     return p_73121_1_.func_71121_q().func_73040_p().func_72694_a(p_73121_1_, this.field_73132_a.field_70176_ah, this.field_73132_a.field_70164_aj);
/*     */   }
/*     */   
/*     */   public void func_73125_b(List<EntityPlayerMP> p_73125_1_) {
/* 328 */     for (byte b = 0; b < p_73125_1_.size(); b++) {
/* 329 */       func_73117_b(p_73125_1_.get(b));
/*     */     }
/*     */   }
/*     */   
/*     */   private Packet func_151260_c() {
/* 334 */     if (this.field_73132_a.field_70128_L) {
/* 335 */       field_151262_p.warn("Fetching addPacket for removed entity");
/*     */     }
/*     */     
/* 338 */     if (this.field_73132_a instanceof net.minecraft.entity.item.EntityItem) {
/* 339 */       return (Packet)new S0EPacketSpawnObject(this.field_73132_a, 2, 1);
/*     */     }
/* 341 */     if (this.field_73132_a instanceof EntityPlayerMP) {
/* 342 */       return (Packet)new S0CPacketSpawnPlayer((EntityPlayer)this.field_73132_a);
/*     */     }
/* 344 */     if (this.field_73132_a instanceof EntityMinecart) {
/* 345 */       EntityMinecart entityMinecart = (EntityMinecart)this.field_73132_a;
/* 346 */       return (Packet)new S0EPacketSpawnObject(this.field_73132_a, 10, entityMinecart.func_94087_l());
/*     */     } 
/* 348 */     if (this.field_73132_a instanceof net.minecraft.entity.item.EntityBoat) {
/* 349 */       return (Packet)new S0EPacketSpawnObject(this.field_73132_a, 1);
/*     */     }
/* 351 */     if (this.field_73132_a instanceof net.minecraft.entity.passive.IAnimals || this.field_73132_a instanceof net.minecraft.entity.boss.EntityDragon) {
/* 352 */       this.field_73140_i = MathHelper.func_76141_d(this.field_73132_a.func_70079_am() * 256.0F / 360.0F);
/* 353 */       return (Packet)new S0FPacketSpawnMob((EntityLivingBase)this.field_73132_a);
/*     */     } 
/* 355 */     if (this.field_73132_a instanceof EntityFishHook) {
/* 356 */       EntityPlayer entityPlayer = ((EntityFishHook)this.field_73132_a).field_146042_b;
/* 357 */       return (Packet)new S0EPacketSpawnObject(this.field_73132_a, 90, (entityPlayer != null) ? entityPlayer.func_145782_y() : this.field_73132_a.func_145782_y());
/*     */     } 
/* 359 */     if (this.field_73132_a instanceof EntityArrow) {
/* 360 */       Entity entity = ((EntityArrow)this.field_73132_a).field_70250_c;
/* 361 */       return (Packet)new S0EPacketSpawnObject(this.field_73132_a, 60, (entity != null) ? entity.func_145782_y() : this.field_73132_a.func_145782_y());
/*     */     } 
/* 363 */     if (this.field_73132_a instanceof net.minecraft.entity.projectile.EntitySnowball) {
/* 364 */       return (Packet)new S0EPacketSpawnObject(this.field_73132_a, 61);
/*     */     }
/* 366 */     if (this.field_73132_a instanceof EntityPotion) {
/* 367 */       return (Packet)new S0EPacketSpawnObject(this.field_73132_a, 73, ((EntityPotion)this.field_73132_a).func_70196_i());
/*     */     }
/* 369 */     if (this.field_73132_a instanceof net.minecraft.entity.item.EntityExpBottle) {
/* 370 */       return (Packet)new S0EPacketSpawnObject(this.field_73132_a, 75);
/*     */     }
/* 372 */     if (this.field_73132_a instanceof net.minecraft.entity.item.EntityEnderPearl) {
/* 373 */       return (Packet)new S0EPacketSpawnObject(this.field_73132_a, 65);
/*     */     }
/* 375 */     if (this.field_73132_a instanceof net.minecraft.entity.item.EntityEnderEye) {
/* 376 */       return (Packet)new S0EPacketSpawnObject(this.field_73132_a, 72);
/*     */     }
/* 378 */     if (this.field_73132_a instanceof net.minecraft.entity.item.EntityFireworkRocket) {
/* 379 */       return (Packet)new S0EPacketSpawnObject(this.field_73132_a, 76);
/*     */     }
/* 381 */     if (this.field_73132_a instanceof EntityFireball) {
/* 382 */       EntityFireball entityFireball = (EntityFireball)this.field_73132_a;
/* 383 */       S0EPacketSpawnObject s0EPacketSpawnObject = null;
/* 384 */       byte b = 63;
/* 385 */       if (this.field_73132_a instanceof net.minecraft.entity.projectile.EntitySmallFireball) {
/* 386 */         b = 64;
/* 387 */       } else if (this.field_73132_a instanceof net.minecraft.entity.projectile.EntityWitherSkull) {
/* 388 */         b = 66;
/*     */       } 
/* 390 */       if (entityFireball.field_70235_a != null) {
/* 391 */         s0EPacketSpawnObject = new S0EPacketSpawnObject(this.field_73132_a, b, ((EntityFireball)this.field_73132_a).field_70235_a.func_145782_y());
/*     */       } else {
/* 393 */         s0EPacketSpawnObject = new S0EPacketSpawnObject(this.field_73132_a, b, 0);
/*     */       } 
/* 395 */       s0EPacketSpawnObject.func_149003_d((int)(entityFireball.field_70232_b * 8000.0D));
/* 396 */       s0EPacketSpawnObject.func_149000_e((int)(entityFireball.field_70233_c * 8000.0D));
/* 397 */       s0EPacketSpawnObject.func_149007_f((int)(entityFireball.field_70230_d * 8000.0D));
/* 398 */       return (Packet)s0EPacketSpawnObject;
/*     */     } 
/* 400 */     if (this.field_73132_a instanceof net.minecraft.entity.projectile.EntityEgg) {
/* 401 */       return (Packet)new S0EPacketSpawnObject(this.field_73132_a, 62);
/*     */     }
/* 403 */     if (this.field_73132_a instanceof net.minecraft.entity.item.EntityTNTPrimed) {
/* 404 */       return (Packet)new S0EPacketSpawnObject(this.field_73132_a, 50);
/*     */     }
/* 406 */     if (this.field_73132_a instanceof net.minecraft.entity.item.EntityEnderCrystal) {
/* 407 */       return (Packet)new S0EPacketSpawnObject(this.field_73132_a, 51);
/*     */     }
/* 409 */     if (this.field_73132_a instanceof EntityFallingBlock) {
/* 410 */       EntityFallingBlock entityFallingBlock = (EntityFallingBlock)this.field_73132_a;
/* 411 */       return (Packet)new S0EPacketSpawnObject(this.field_73132_a, 70, Block.func_149682_b(entityFallingBlock.func_145805_f()) | entityFallingBlock.field_145814_a << 16);
/*     */     } 
/* 413 */     if (this.field_73132_a instanceof EntityPainting) {
/* 414 */       return (Packet)new S10PacketSpawnPainting((EntityPainting)this.field_73132_a);
/*     */     }
/* 416 */     if (this.field_73132_a instanceof EntityItemFrame) {
/* 417 */       EntityItemFrame entityItemFrame = (EntityItemFrame)this.field_73132_a;
/* 418 */       S0EPacketSpawnObject s0EPacketSpawnObject = new S0EPacketSpawnObject(this.field_73132_a, 71, entityItemFrame.field_82332_a);
/* 419 */       s0EPacketSpawnObject.func_148996_a(MathHelper.func_76141_d((entityItemFrame.field_146063_b * 32)));
/* 420 */       s0EPacketSpawnObject.func_148995_b(MathHelper.func_76141_d((entityItemFrame.field_146064_c * 32)));
/* 421 */       s0EPacketSpawnObject.func_149005_c(MathHelper.func_76141_d((entityItemFrame.field_146062_d * 32)));
/* 422 */       return (Packet)s0EPacketSpawnObject;
/*     */     } 
/* 424 */     if (this.field_73132_a instanceof EntityLeashKnot) {
/* 425 */       EntityLeashKnot entityLeashKnot = (EntityLeashKnot)this.field_73132_a;
/* 426 */       S0EPacketSpawnObject s0EPacketSpawnObject = new S0EPacketSpawnObject(this.field_73132_a, 77);
/* 427 */       s0EPacketSpawnObject.func_148996_a(MathHelper.func_76141_d((entityLeashKnot.field_146063_b * 32)));
/* 428 */       s0EPacketSpawnObject.func_148995_b(MathHelper.func_76141_d((entityLeashKnot.field_146064_c * 32)));
/* 429 */       s0EPacketSpawnObject.func_149005_c(MathHelper.func_76141_d((entityLeashKnot.field_146062_d * 32)));
/* 430 */       return (Packet)s0EPacketSpawnObject;
/*     */     } 
/* 432 */     if (this.field_73132_a instanceof EntityXPOrb) {
/* 433 */       return (Packet)new S11PacketSpawnExperienceOrb((EntityXPOrb)this.field_73132_a);
/*     */     }
/* 435 */     throw new IllegalArgumentException("Don't know how to add " + this.field_73132_a.getClass() + "!");
/*     */   }
/*     */   
/*     */   public void func_73123_c(EntityPlayerMP p_73123_1_) {
/* 439 */     if (this.field_73134_o.contains(p_73123_1_)) {
/* 440 */       this.field_73134_o.remove(p_73123_1_);
/* 441 */       p_73123_1_.func_152339_d(this.field_73132_a);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\EntityTrackerEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */