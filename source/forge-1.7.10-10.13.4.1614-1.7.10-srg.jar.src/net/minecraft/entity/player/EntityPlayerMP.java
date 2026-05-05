/*     */ package net.minecraft.entity.player;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.crash.CrashReport;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityList;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityMinecartHopper;
/*     */ import net.minecraft.entity.projectile.EntityArrow;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.PacketBuffer;
/*     */ import net.minecraft.network.play.client.C15PacketClientSettings;
/*     */ import net.minecraft.network.play.server.S0APacketUseBed;
/*     */ import net.minecraft.network.play.server.S0BPacketAnimation;
/*     */ import net.minecraft.network.play.server.S2DPacketOpenWindow;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.scoreboard.ScoreObjective;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.server.management.ItemInWorldManager;
/*     */ import net.minecraft.server.management.UserListOpsEntry;
/*     */ import net.minecraft.stats.AchievementList;
/*     */ import net.minecraft.stats.StatBase;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.tileentity.TileEntityBeacon;
/*     */ import net.minecraft.tileentity.TileEntityBrewingStand;
/*     */ import net.minecraft.tileentity.TileEntityDispenser;
/*     */ import net.minecraft.tileentity.TileEntityFurnace;
/*     */ import net.minecraft.tileentity.TileEntityHopper;
/*     */ import net.minecraft.util.ChunkCoordinates;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.util.JsonSerializableSet;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.ChunkCoordIntPair;
/*     */ import net.minecraft.world.WorldServer;
/*     */ import net.minecraft.world.WorldSettings;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ import net.minecraft.world.chunk.Chunk;
/*     */ 
/*     */ public class EntityPlayerMP extends EntityPlayer implements ICrafting {
/*  47 */   private static final Logger field_147102_bM = LogManager.getLogger();
/*  48 */   private String field_71148_cg = "en_US"; public NetHandlerPlayServer field_71135_a;
/*     */   public final MinecraftServer field_71133_b;
/*     */   public final ItemInWorldManager field_71134_c;
/*     */   public double field_71131_d;
/*     */   public double field_71132_e;
/*  53 */   public final List field_71129_f = new LinkedList();
/*  54 */   private final List field_71130_g = new LinkedList();
/*     */   private final StatisticsFile field_147103_bO;
/*  56 */   private float field_130068_bO = Float.MIN_VALUE;
/*  57 */   private float field_71149_ch = -1.0E8F;
/*  58 */   private int field_71146_ci = -99999999;
/*     */   private boolean field_71147_cj = true;
/*  60 */   private int field_71144_ck = -99999999;
/*  61 */   private int field_147101_bU = 60;
/*     */   private EntityPlayer.EnumChatVisibility field_71143_cn;
/*     */   private boolean field_71140_co = true;
/*  64 */   private long field_143005_bX = System.currentTimeMillis(); public int field_71139_cq; public boolean field_71137_h; public int field_71138_i; public boolean field_71136_j; private static final String __OBFID = "CL_00001440";
/*     */   
/*     */   public EntityPlayerMP(MinecraftServer p_i45285_1_, WorldServer p_i45285_2_, GameProfile p_i45285_3_, ItemInWorldManager p_i45285_4_) {
/*  67 */     super((World)p_i45285_2_, p_i45285_3_);
/*  68 */     p_i45285_4_.field_73090_b = this;
/*  69 */     this.field_71134_c = p_i45285_4_;
/*     */     
/*  71 */     ChunkCoordinates chunkCoordinates = p_i45285_2_.func_72861_E();
/*  72 */     int i = chunkCoordinates.field_71574_a;
/*  73 */     int j = chunkCoordinates.field_71573_c;
/*  74 */     int k = chunkCoordinates.field_71572_b;
/*     */     
/*  76 */     if (!p_i45285_2_.field_73011_w.field_76576_e && p_i45285_2_.func_72912_H().func_76077_q() != WorldSettings.GameType.ADVENTURE) {
/*  77 */       int m = Math.max(5, p_i45285_1_.func_82357_ak() - 6);
/*  78 */       i += this.field_70146_Z.nextInt(m * 2) - m;
/*  79 */       j += this.field_70146_Z.nextInt(m * 2) - m;
/*  80 */       k = p_i45285_2_.func_72825_h(i, j);
/*     */     } 
/*     */     
/*  83 */     this.field_71133_b = p_i45285_1_;
/*  84 */     this.field_147103_bO = p_i45285_1_.func_71203_ab().func_152602_a(this);
/*  85 */     this.field_70138_W = 0.0F;
/*     */     
/*  87 */     this.field_70129_M = 0.0F;
/*     */     
/*  89 */     func_70012_b(i + 0.5D, k, j + 0.5D, 0.0F, 0.0F);
/*  90 */     while (!p_i45285_2_.func_72945_a((Entity)this, this.field_70121_D).isEmpty()) {
/*  91 */       func_70107_b(this.field_70165_t, this.field_70163_u + 1.0D, this.field_70161_v);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound p_70037_1_) {
/*  97 */     super.func_70037_a(p_70037_1_);
/*     */     
/*  99 */     if (p_70037_1_.func_150297_b("playerGameType", 99)) {
/* 100 */       if (MinecraftServer.func_71276_C().func_104056_am()) {
/* 101 */         this.field_71134_c.func_73076_a(MinecraftServer.func_71276_C().func_71265_f());
/*     */       } else {
/* 103 */         this.field_71134_c.func_73076_a(WorldSettings.GameType.func_77146_a(p_70037_1_.func_74762_e("playerGameType")));
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound p_70014_1_) {
/* 110 */     super.func_70014_b(p_70014_1_);
/*     */     
/* 112 */     p_70014_1_.func_74768_a("playerGameType", this.field_71134_c.func_73081_b().func_77148_a());
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_82242_a(int p_82242_1_) {
/* 117 */     super.func_82242_a(p_82242_1_);
/* 118 */     this.field_71144_ck = -1;
/*     */   }
/*     */   
/*     */   public void func_71116_b() {
/* 122 */     this.field_71070_bA.func_75132_a(this);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_71061_d_() {
/* 127 */     this.field_70129_M = 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public float func_70047_e() {
/* 132 */     return 1.62F;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/* 137 */     this.field_71134_c.func_73075_a();
/*     */     
/* 139 */     this.field_147101_bU--;
/* 140 */     if (this.field_70172_ad > 0) this.field_70172_ad--; 
/* 141 */     this.field_71070_bA.func_75142_b();
/*     */     
/* 143 */     if (!this.field_70170_p.field_72995_K && 
/* 144 */       !this.field_71070_bA.func_75145_c(this)) {
/* 145 */       func_71053_j();
/* 146 */       this.field_71070_bA = this.field_71069_bz;
/*     */     } 
/*     */ 
/*     */     
/* 150 */     while (!this.field_71130_g.isEmpty()) {
/* 151 */       int i = Math.min(this.field_71130_g.size(), 127);
/* 152 */       int[] arrayOfInt = new int[i];
/* 153 */       Iterator iterator = this.field_71130_g.iterator();
/* 154 */       byte b = 0;
/*     */       
/* 156 */       while (iterator.hasNext() && b < i) {
/* 157 */         arrayOfInt[b++] = ((Integer)iterator.next()).intValue();
/* 158 */         iterator.remove();
/*     */       } 
/*     */       
/* 161 */       this.field_71135_a.func_147359_a((Packet)new S13PacketDestroyEntities(arrayOfInt));
/*     */     } 
/*     */     
/* 164 */     if (!this.field_71129_f.isEmpty()) {
/* 165 */       ArrayList<Chunk> arrayList = new ArrayList();
/* 166 */       Iterator<ChunkCoordIntPair> iterator = this.field_71129_f.iterator();
/* 167 */       ArrayList arrayList1 = new ArrayList();
/*     */       
/* 169 */       while (iterator.hasNext() && arrayList.size() < S26PacketMapChunkBulk.func_149258_c()) {
/* 170 */         ChunkCoordIntPair chunkCoordIntPair = iterator.next();
/*     */         
/* 172 */         if (chunkCoordIntPair != null) {
/* 173 */           if (this.field_70170_p.func_72899_e(chunkCoordIntPair.field_77276_a << 4, 0, chunkCoordIntPair.field_77275_b << 4)) {
/* 174 */             Chunk chunk = this.field_70170_p.func_72964_e(chunkCoordIntPair.field_77276_a, chunkCoordIntPair.field_77275_b);
/* 175 */             if (chunk.func_150802_k()) {
/* 176 */               arrayList.add(chunk);
/* 177 */               arrayList1.addAll(((WorldServer)this.field_70170_p).func_147486_a(chunkCoordIntPair.field_77276_a * 16, 0, chunkCoordIntPair.field_77275_b * 16, chunkCoordIntPair.field_77276_a * 16 + 16, 256, chunkCoordIntPair.field_77275_b * 16 + 16));
/* 178 */               iterator.remove();
/*     */             } 
/*     */           }  continue;
/*     */         } 
/* 182 */         iterator.remove();
/*     */       } 
/*     */ 
/*     */       
/* 186 */       if (!arrayList.isEmpty()) {
/* 187 */         this.field_71135_a.func_147359_a((Packet)new S26PacketMapChunkBulk(arrayList));
/*     */         
/* 189 */         for (TileEntity tileEntity : arrayList1) {
/* 190 */           func_147097_b(tileEntity);
/*     */         }
/*     */         
/* 193 */         for (Chunk chunk : arrayList) {
/* 194 */           func_71121_q().func_73039_n().func_85172_a(this, chunk);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_71127_g() {
/*     */     try {
/* 202 */       super.func_70071_h_();
/*     */       
/* 204 */       for (byte b = 0; b < this.field_71071_by.func_70302_i_(); b++) {
/* 205 */         ItemStack itemStack = this.field_71071_by.func_70301_a(b);
/* 206 */         if (itemStack != null && 
/* 207 */           itemStack.func_77973_b().func_77643_m_()) {
/* 208 */           Packet packet = ((ItemMapBase)itemStack.func_77973_b()).func_150911_c(itemStack, this.field_70170_p, this);
/* 209 */           if (packet != null) {
/* 210 */             this.field_71135_a.func_147359_a(packet);
/*     */           }
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 216 */       if (func_110143_aJ() != this.field_71149_ch || this.field_71146_ci != this.field_71100_bB.func_75116_a() || ((this.field_71100_bB.func_75115_e() == 0.0F)) != this.field_71147_cj) {
/* 217 */         this.field_71135_a.func_147359_a((Packet)new S06PacketUpdateHealth(func_110143_aJ(), this.field_71100_bB.func_75116_a(), this.field_71100_bB.func_75115_e()));
/* 218 */         this.field_71149_ch = func_110143_aJ();
/* 219 */         this.field_71146_ci = this.field_71100_bB.func_75116_a();
/* 220 */         this.field_71147_cj = (this.field_71100_bB.func_75115_e() == 0.0F);
/*     */       } 
/*     */ 
/*     */       
/* 224 */       if (func_110143_aJ() + func_110139_bj() != this.field_130068_bO) {
/* 225 */         this.field_130068_bO = func_110143_aJ() + func_110139_bj();
/*     */         
/* 227 */         Collection collection = func_96123_co().func_96520_a(IScoreObjectiveCriteria.field_96638_f);
/* 228 */         for (ScoreObjective scoreObjective : collection) {
/* 229 */           func_96123_co().func_96529_a(func_70005_c_(), scoreObjective).func_96651_a(Arrays.asList(new EntityPlayer[] { this }));
/*     */         } 
/*     */       } 
/*     */       
/* 233 */       if (this.field_71067_cb != this.field_71144_ck) {
/* 234 */         this.field_71144_ck = this.field_71067_cb;
/* 235 */         this.field_71135_a.func_147359_a((Packet)new S1FPacketSetExperience(this.field_71106_cc, this.field_71067_cb, this.field_71068_ca));
/*     */       } 
/*     */       
/* 238 */       if (this.field_70173_aa % 20 * 5 == 0 && !func_147099_x().func_77443_a(AchievementList.field_150961_L)) {
/* 239 */         func_147098_j();
/*     */       }
/* 241 */     } catch (Throwable throwable) {
/* 242 */       CrashReport crashReport = CrashReport.func_85055_a(throwable, "Ticking player");
/* 243 */       CrashReportCategory crashReportCategory = crashReport.func_85058_a("Player being ticked");
/*     */       
/* 245 */       func_85029_a(crashReportCategory);
/*     */       
/* 247 */       throw new ReportedException(crashReport);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void func_147098_j() {
/* 252 */     BiomeGenBase biomeGenBase = this.field_70170_p.func_72807_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70161_v));
/*     */     
/* 254 */     if (biomeGenBase != null) {
/* 255 */       String str = biomeGenBase.field_76791_y;
/* 256 */       JsonSerializableSet jsonSerializableSet = (JsonSerializableSet)func_147099_x().func_150870_b((StatBase)AchievementList.field_150961_L);
/*     */       
/* 258 */       if (jsonSerializableSet == null) jsonSerializableSet = (JsonSerializableSet)func_147099_x().func_150872_a((StatBase)AchievementList.field_150961_L, (IJsonSerializable)new JsonSerializableSet()); 
/* 259 */       jsonSerializableSet.add(str);
/*     */       
/* 261 */       if (func_147099_x().func_77442_b(AchievementList.field_150961_L) && jsonSerializableSet.size() == BiomeGenBase.field_150597_n.size()) {
/* 262 */         HashSet hashSet = Sets.newHashSet(BiomeGenBase.field_150597_n);
/* 263 */         for (String str1 : jsonSerializableSet) {
/* 264 */           Iterator<BiomeGenBase> iterator = hashSet.iterator();
/*     */           
/* 266 */           while (iterator.hasNext()) {
/* 267 */             BiomeGenBase biomeGenBase1 = iterator.next();
/*     */             
/* 269 */             if (biomeGenBase1.field_76791_y.equals(str1)) {
/* 270 */               iterator.remove();
/*     */             }
/*     */           } 
/*     */           
/* 274 */           if (hashSet.isEmpty())
/*     */             break; 
/*     */         } 
/* 277 */         if (hashSet.isEmpty()) {
/* 278 */           func_71029_a((StatBase)AchievementList.field_150961_L);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70645_a(DamageSource p_70645_1_) {
/* 286 */     this.field_71133_b.func_71203_ab().func_148539_a(func_110142_aN().func_151521_b());
/* 287 */     if (!this.field_70170_p.func_82736_K().func_82766_b("keepInventory")) {
/* 288 */       this.field_71071_by.func_70436_m();
/*     */     }
/*     */     
/* 291 */     Collection collection = this.field_70170_p.func_96441_U().func_96520_a(IScoreObjectiveCriteria.field_96642_c);
/*     */     
/* 293 */     for (ScoreObjective scoreObjective : collection) {
/* 294 */       Score score = func_96123_co().func_96529_a(func_70005_c_(), scoreObjective);
/* 295 */       score.func_96648_a();
/*     */     } 
/*     */     
/* 298 */     EntityLivingBase entityLivingBase = func_94060_bK();
/* 299 */     if (entityLivingBase != null) {
/* 300 */       int i = EntityList.func_75619_a((Entity)entityLivingBase);
/* 301 */       EntityList.EntityEggInfo entityEggInfo = (EntityList.EntityEggInfo)EntityList.field_75627_a.get(Integer.valueOf(i));
/* 302 */       if (entityEggInfo != null) {
/* 303 */         func_71064_a(entityEggInfo.field_151513_e, 1);
/*     */       }
/* 305 */       entityLivingBase.func_70084_c((Entity)this, this.field_70744_aE);
/*     */     } 
/* 307 */     func_71064_a(StatList.field_75960_y, 1);
/*     */     
/* 309 */     func_110142_aN().func_94549_h();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource p_70097_1_, float p_70097_2_) {
/* 314 */     if (func_85032_ar()) return false;
/*     */     
/* 316 */     boolean bool = (this.field_71133_b.func_71262_S() && this.field_71133_b.func_71219_W() && "fall".equals(p_70097_1_.field_76373_n)) ? true : false;
/* 317 */     if (!bool && this.field_147101_bU > 0 && p_70097_1_ != DamageSource.field_76380_i) return false;
/*     */     
/* 319 */     if (p_70097_1_ instanceof net.minecraft.util.EntityDamageSource) {
/* 320 */       Entity entity = p_70097_1_.func_76346_g();
/*     */       
/* 322 */       if (entity instanceof EntityPlayer && !func_96122_a((EntityPlayer)entity)) return false; 
/* 323 */       if (entity instanceof EntityArrow) {
/* 324 */         EntityArrow entityArrow = (EntityArrow)entity;
/* 325 */         if (entityArrow.field_70250_c instanceof EntityPlayer && !func_96122_a((EntityPlayer)entityArrow.field_70250_c)) {
/* 326 */           return false;
/*     */         }
/*     */       } 
/*     */     } 
/* 330 */     return super.func_70097_a(p_70097_1_, p_70097_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_96122_a(EntityPlayer p_96122_1_) {
/* 335 */     if (!this.field_71133_b.func_71219_W()) return false; 
/* 336 */     return super.func_96122_a(p_96122_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71027_c(int p_71027_1_) {
/* 341 */     if (this.field_71093_bK == 1 && p_71027_1_ == 1) {
/* 342 */       func_71029_a((StatBase)AchievementList.field_76003_C);
/* 343 */       this.field_70170_p.func_72900_e((Entity)this);
/* 344 */       this.field_71136_j = true;
/* 345 */       this.field_71135_a.func_147359_a((Packet)new S2BPacketChangeGameState(4, 0.0F));
/*     */     } else {
/* 347 */       if (this.field_71093_bK == 0 && p_71027_1_ == 1) {
/* 348 */         func_71029_a((StatBase)AchievementList.field_76002_B);
/* 349 */         ChunkCoordinates chunkCoordinates = this.field_71133_b.func_71218_a(p_71027_1_).func_73054_j();
/* 350 */         if (chunkCoordinates != null) {
/* 351 */           this.field_71135_a.func_147364_a(chunkCoordinates.field_71574_a, chunkCoordinates.field_71572_b, chunkCoordinates.field_71573_c, 0.0F, 0.0F);
/*     */         }
/*     */         
/* 354 */         p_71027_1_ = 1;
/*     */       } else {
/* 356 */         func_71029_a((StatBase)AchievementList.field_76029_x);
/*     */       } 
/*     */       
/* 359 */       this.field_71133_b.func_71203_ab().func_72356_a(this, p_71027_1_);
/* 360 */       this.field_71144_ck = -1;
/* 361 */       this.field_71149_ch = -1.0F;
/* 362 */       this.field_71146_ci = -1;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_147097_b(TileEntity p_147097_1_) {
/* 367 */     if (p_147097_1_ != null) {
/* 368 */       Packet packet = p_147097_1_.func_145844_m();
/* 369 */       if (packet != null) {
/* 370 */         this.field_71135_a.func_147359_a(packet);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71001_a(Entity p_71001_1_, int p_71001_2_) {
/* 377 */     super.func_71001_a(p_71001_1_, p_71001_2_);
/* 378 */     this.field_71070_bA.func_75142_b();
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityPlayer.EnumStatus func_71018_a(int p_71018_1_, int p_71018_2_, int p_71018_3_) {
/* 383 */     EntityPlayer.EnumStatus enumStatus = super.func_71018_a(p_71018_1_, p_71018_2_, p_71018_3_);
/* 384 */     if (enumStatus == EntityPlayer.EnumStatus.OK) {
/* 385 */       S0APacketUseBed s0APacketUseBed = new S0APacketUseBed(this, p_71018_1_, p_71018_2_, p_71018_3_);
/* 386 */       func_71121_q().func_73039_n().func_151247_a((Entity)this, (Packet)s0APacketUseBed);
/* 387 */       this.field_71135_a.func_147364_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, this.field_70125_A);
/* 388 */       this.field_71135_a.func_147359_a((Packet)s0APacketUseBed);
/*     */     } 
/* 390 */     return enumStatus;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70999_a(boolean p_70999_1_, boolean p_70999_2_, boolean p_70999_3_) {
/* 395 */     if (func_70608_bn()) {
/* 396 */       func_71121_q().func_73039_n().func_151248_b((Entity)this, (Packet)new S0BPacketAnimation((Entity)this, 2));
/*     */     }
/* 398 */     super.func_70999_a(p_70999_1_, p_70999_2_, p_70999_3_);
/* 399 */     if (this.field_71135_a != null) this.field_71135_a.func_147364_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, this.field_70125_A);
/*     */   
/*     */   }
/*     */   
/*     */   public void func_70078_a(Entity p_70078_1_) {
/* 404 */     super.func_70078_a(p_70078_1_);
/* 405 */     this.field_71135_a.func_147359_a((Packet)new S1BPacketEntityAttach(0, (Entity)this, this.field_70154_o));
/* 406 */     this.field_71135_a.func_147364_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, this.field_70125_A);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70064_a(double p_70064_1_, boolean p_70064_3_) {}
/*     */ 
/*     */   
/*     */   public void func_71122_b(double p_71122_1_, boolean p_71122_3_) {
/* 414 */     super.func_70064_a(p_71122_1_, p_71122_3_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146100_a(TileEntity p_146100_1_) {
/* 419 */     if (p_146100_1_ instanceof TileEntitySign) {
/* 420 */       ((TileEntitySign)p_146100_1_).func_145912_a(this);
/* 421 */       this.field_71135_a.func_147359_a((Packet)new S36PacketSignEditorOpen(p_146100_1_.field_145851_c, p_146100_1_.field_145848_d, p_146100_1_.field_145849_e));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_71117_bO() {
/* 431 */     this.field_71139_cq = this.field_71139_cq % 100 + 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71058_b(int p_71058_1_, int p_71058_2_, int p_71058_3_) {
/* 436 */     func_71117_bO();
/* 437 */     this.field_71135_a.func_147359_a((Packet)new S2DPacketOpenWindow(this.field_71139_cq, 1, "Crafting", 9, true));
/* 438 */     this.field_71070_bA = (Container)new ContainerWorkbench(this.field_71071_by, this.field_70170_p, p_71058_1_, p_71058_2_, p_71058_3_);
/* 439 */     this.field_71070_bA.field_75152_c = this.field_71139_cq;
/* 440 */     this.field_71070_bA.func_75132_a(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71002_c(int p_71002_1_, int p_71002_2_, int p_71002_3_, String p_71002_4_) {
/* 445 */     func_71117_bO();
/* 446 */     this.field_71135_a.func_147359_a((Packet)new S2DPacketOpenWindow(this.field_71139_cq, 4, (p_71002_4_ == null) ? "" : p_71002_4_, 9, (p_71002_4_ != null)));
/* 447 */     this.field_71070_bA = (Container)new ContainerEnchantment(this.field_71071_by, this.field_70170_p, p_71002_1_, p_71002_2_, p_71002_3_);
/* 448 */     this.field_71070_bA.field_75152_c = this.field_71139_cq;
/* 449 */     this.field_71070_bA.func_75132_a(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_82244_d(int p_82244_1_, int p_82244_2_, int p_82244_3_) {
/* 454 */     func_71117_bO();
/* 455 */     this.field_71135_a.func_147359_a((Packet)new S2DPacketOpenWindow(this.field_71139_cq, 8, "Repairing", 9, true));
/* 456 */     this.field_71070_bA = (Container)new ContainerRepair(this.field_71071_by, this.field_70170_p, p_82244_1_, p_82244_2_, p_82244_3_, this);
/* 457 */     this.field_71070_bA.field_75152_c = this.field_71139_cq;
/* 458 */     this.field_71070_bA.func_75132_a(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71007_a(IInventory p_71007_1_) {
/* 463 */     if (this.field_71070_bA != this.field_71069_bz) {
/* 464 */       func_71053_j();
/*     */     }
/* 466 */     func_71117_bO();
/* 467 */     this.field_71135_a.func_147359_a((Packet)new S2DPacketOpenWindow(this.field_71139_cq, 0, p_71007_1_.func_145825_b(), p_71007_1_.func_70302_i_(), p_71007_1_.func_145818_k_()));
/* 468 */     this.field_71070_bA = (Container)new ContainerChest(this.field_71071_by, p_71007_1_);
/* 469 */     this.field_71070_bA.field_75152_c = this.field_71139_cq;
/* 470 */     this.field_71070_bA.func_75132_a(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146093_a(TileEntityHopper p_146093_1_) {
/* 475 */     func_71117_bO();
/* 476 */     this.field_71135_a.func_147359_a((Packet)new S2DPacketOpenWindow(this.field_71139_cq, 9, p_146093_1_.func_145825_b(), p_146093_1_.func_70302_i_(), p_146093_1_.func_145818_k_()));
/* 477 */     this.field_71070_bA = (Container)new ContainerHopper(this.field_71071_by, (IInventory)p_146093_1_);
/* 478 */     this.field_71070_bA.field_75152_c = this.field_71139_cq;
/* 479 */     this.field_71070_bA.func_75132_a(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_96125_a(EntityMinecartHopper p_96125_1_) {
/* 484 */     func_71117_bO();
/* 485 */     this.field_71135_a.func_147359_a((Packet)new S2DPacketOpenWindow(this.field_71139_cq, 9, p_96125_1_.func_145825_b(), p_96125_1_.func_70302_i_(), p_96125_1_.func_145818_k_()));
/* 486 */     this.field_71070_bA = (Container)new ContainerHopper(this.field_71071_by, (IInventory)p_96125_1_);
/* 487 */     this.field_71070_bA.field_75152_c = this.field_71139_cq;
/* 488 */     this.field_71070_bA.func_75132_a(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146101_a(TileEntityFurnace p_146101_1_) {
/* 493 */     func_71117_bO();
/* 494 */     this.field_71135_a.func_147359_a((Packet)new S2DPacketOpenWindow(this.field_71139_cq, 2, p_146101_1_.func_145825_b(), p_146101_1_.func_70302_i_(), p_146101_1_.func_145818_k_()));
/* 495 */     this.field_71070_bA = (Container)new ContainerFurnace(this.field_71071_by, p_146101_1_);
/* 496 */     this.field_71070_bA.field_75152_c = this.field_71139_cq;
/* 497 */     this.field_71070_bA.func_75132_a(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146102_a(TileEntityDispenser p_146102_1_) {
/* 502 */     func_71117_bO();
/* 503 */     this.field_71135_a.func_147359_a((Packet)new S2DPacketOpenWindow(this.field_71139_cq, (p_146102_1_ instanceof net.minecraft.tileentity.TileEntityDropper) ? 10 : 3, p_146102_1_.func_145825_b(), p_146102_1_.func_70302_i_(), p_146102_1_.func_145818_k_()));
/*     */     
/* 505 */     this.field_71070_bA = (Container)new ContainerDispenser(this.field_71071_by, p_146102_1_);
/* 506 */     this.field_71070_bA.field_75152_c = this.field_71139_cq;
/* 507 */     this.field_71070_bA.func_75132_a(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146098_a(TileEntityBrewingStand p_146098_1_) {
/* 512 */     func_71117_bO();
/* 513 */     this.field_71135_a.func_147359_a((Packet)new S2DPacketOpenWindow(this.field_71139_cq, 5, p_146098_1_.func_145825_b(), p_146098_1_.func_70302_i_(), p_146098_1_.func_145818_k_()));
/*     */     
/* 515 */     this.field_71070_bA = (Container)new ContainerBrewingStand(this.field_71071_by, p_146098_1_);
/* 516 */     this.field_71070_bA.field_75152_c = this.field_71139_cq;
/* 517 */     this.field_71070_bA.func_75132_a(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146104_a(TileEntityBeacon p_146104_1_) {
/* 522 */     func_71117_bO();
/* 523 */     this.field_71135_a.func_147359_a((Packet)new S2DPacketOpenWindow(this.field_71139_cq, 7, p_146104_1_.func_145825_b(), p_146104_1_.func_70302_i_(), p_146104_1_.func_145818_k_()));
/* 524 */     this.field_71070_bA = (Container)new ContainerBeacon(this.field_71071_by, p_146104_1_);
/* 525 */     this.field_71070_bA.field_75152_c = this.field_71139_cq;
/* 526 */     this.field_71070_bA.func_75132_a(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71030_a(IMerchant p_71030_1_, String p_71030_2_) {
/* 531 */     func_71117_bO();
/* 532 */     this.field_71070_bA = (Container)new ContainerMerchant(this.field_71071_by, p_71030_1_, this.field_70170_p);
/* 533 */     this.field_71070_bA.field_75152_c = this.field_71139_cq;
/* 534 */     this.field_71070_bA.func_75132_a(this);
/* 535 */     InventoryMerchant inventoryMerchant = ((ContainerMerchant)this.field_71070_bA).func_75174_d();
/*     */     
/* 537 */     this.field_71135_a.func_147359_a((Packet)new S2DPacketOpenWindow(this.field_71139_cq, 6, (p_71030_2_ == null) ? "" : p_71030_2_, inventoryMerchant.func_70302_i_(), (p_71030_2_ != null)));
/*     */     
/* 539 */     MerchantRecipeList merchantRecipeList = p_71030_1_.func_70934_b(this);
/* 540 */     if (merchantRecipeList != null) {
/* 541 */       PacketBuffer packetBuffer = new PacketBuffer(Unpooled.buffer());
/*     */ 
/*     */       
/*     */       try {
/* 545 */         packetBuffer.writeInt(this.field_71139_cq);
/* 546 */         merchantRecipeList.func_151391_a(packetBuffer);
/*     */         
/* 548 */         this.field_71135_a.func_147359_a((Packet)new S3FPacketCustomPayload("MC|TrList", (ByteBuf)packetBuffer));
/* 549 */       } catch (IOException iOException) {
/* 550 */         field_147102_bM.error("Couldn't send trade list", iOException);
/*     */       } finally {
/* 552 */         packetBuffer.release();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_110298_a(EntityHorse p_110298_1_, IInventory p_110298_2_) {
/* 559 */     if (this.field_71070_bA != this.field_71069_bz) {
/* 560 */       func_71053_j();
/*     */     }
/* 562 */     func_71117_bO();
/* 563 */     this.field_71135_a.func_147359_a((Packet)new S2DPacketOpenWindow(this.field_71139_cq, 11, p_110298_2_.func_145825_b(), p_110298_2_.func_70302_i_(), p_110298_2_.func_145818_k_(), p_110298_1_.func_145782_y()));
/*     */     
/* 565 */     this.field_71070_bA = (Container)new ContainerHorseInventory(this.field_71071_by, p_110298_2_, p_110298_1_);
/* 566 */     this.field_71070_bA.field_75152_c = this.field_71139_cq;
/* 567 */     this.field_71070_bA.func_75132_a(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71111_a(Container p_71111_1_, int p_71111_2_, ItemStack p_71111_3_) {
/* 572 */     if (p_71111_1_.func_75139_a(p_71111_2_) instanceof net.minecraft.inventory.SlotCrafting) {
/*     */       return;
/*     */     }
/*     */     
/* 576 */     if (this.field_71137_h) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 584 */     this.field_71135_a.func_147359_a((Packet)new S2FPacketSetSlot(p_71111_1_.field_75152_c, p_71111_2_, p_71111_3_));
/*     */   }
/*     */   
/*     */   public void func_71120_a(Container p_71120_1_) {
/* 588 */     func_71110_a(p_71120_1_, p_71120_1_.func_75138_a());
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71110_a(Container p_71110_1_, List p_71110_2_) {
/* 593 */     this.field_71135_a.func_147359_a((Packet)new S30PacketWindowItems(p_71110_1_.field_75152_c, p_71110_2_));
/* 594 */     this.field_71135_a.func_147359_a((Packet)new S2FPacketSetSlot(-1, -1, this.field_71071_by.func_70445_o()));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71112_a(Container p_71112_1_, int p_71112_2_, int p_71112_3_) {
/* 599 */     this.field_71135_a.func_147359_a((Packet)new S31PacketWindowProperty(p_71112_1_.field_75152_c, p_71112_2_, p_71112_3_));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71053_j() {
/* 604 */     this.field_71135_a.func_147359_a((Packet)new S2EPacketCloseWindow(this.field_71070_bA.field_75152_c));
/* 605 */     func_71128_l();
/*     */   }
/*     */   
/*     */   public void func_71113_k() {
/* 609 */     if (this.field_71137_h) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 616 */     this.field_71135_a.func_147359_a((Packet)new S2FPacketSetSlot(-1, -1, this.field_71071_by.func_70445_o()));
/*     */   }
/*     */   
/*     */   public void func_71128_l() {
/* 620 */     this.field_71070_bA.func_75134_a(this);
/* 621 */     this.field_71070_bA = this.field_71069_bz;
/*     */   }
/*     */   
/*     */   public void func_110430_a(float p_110430_1_, float p_110430_2_, boolean p_110430_3_, boolean p_110430_4_) {
/* 625 */     if (this.field_70154_o != null) {
/* 626 */       if (p_110430_1_ >= -1.0F && p_110430_1_ <= 1.0F) this.field_70702_br = p_110430_1_; 
/* 627 */       if (p_110430_2_ >= -1.0F && p_110430_2_ <= 1.0F) this.field_70701_bs = p_110430_2_; 
/* 628 */       this.field_70703_bu = p_110430_3_;
/* 629 */       func_70095_a(p_110430_4_);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71064_a(StatBase p_71064_1_, int p_71064_2_) {
/* 635 */     if (p_71064_1_ == null) {
/*     */       return;
/*     */     }
/*     */     
/* 639 */     this.field_147103_bO.func_150871_b(this, p_71064_1_, p_71064_2_);
/*     */     
/* 641 */     for (ScoreObjective scoreObjective : func_96123_co().func_96520_a(p_71064_1_.func_150952_k())) {
/* 642 */       func_96123_co().func_96529_a(func_70005_c_(), scoreObjective).func_96648_a();
/*     */     }
/*     */     
/* 645 */     if (this.field_147103_bO.func_150879_e()) {
/* 646 */       this.field_147103_bO.func_150876_a(this);
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_71123_m() {
/* 651 */     if (this.field_70153_n != null) this.field_70153_n.func_70078_a((Entity)this); 
/* 652 */     if (this.field_71083_bS) {
/* 653 */       func_70999_a(true, false, false);
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_71118_n() {
/* 658 */     this.field_71149_ch = -1.0E8F;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146105_b(IChatComponent p_146105_1_) {
/* 663 */     this.field_71135_a.func_147359_a((Packet)new S02PacketChat(p_146105_1_));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_71036_o() {
/* 668 */     this.field_71135_a.func_147359_a((Packet)new S19PacketEntityStatus((Entity)this, (byte)9));
/* 669 */     super.func_71036_o();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71008_a(ItemStack p_71008_1_, int p_71008_2_) {
/* 674 */     super.func_71008_a(p_71008_1_, p_71008_2_);
/*     */     
/* 676 */     if (p_71008_1_ != null && p_71008_1_.func_77973_b() != null && p_71008_1_.func_77973_b().func_77661_b(p_71008_1_) == EnumAction.eat) {
/* 677 */       func_71121_q().func_73039_n().func_151248_b((Entity)this, (Packet)new S0BPacketAnimation((Entity)this, 3));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71049_a(EntityPlayer p_71049_1_, boolean p_71049_2_) {
/* 683 */     super.func_71049_a(p_71049_1_, p_71049_2_);
/* 684 */     this.field_71144_ck = -1;
/* 685 */     this.field_71149_ch = -1.0F;
/* 686 */     this.field_71146_ci = -1;
/* 687 */     this.field_71130_g.addAll(((EntityPlayerMP)p_71049_1_).field_71130_g);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70670_a(PotionEffect p_70670_1_) {
/* 692 */     super.func_70670_a(p_70670_1_);
/* 693 */     this.field_71135_a.func_147359_a((Packet)new S1DPacketEntityEffect(func_145782_y(), p_70670_1_));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70695_b(PotionEffect p_70695_1_, boolean p_70695_2_) {
/* 698 */     super.func_70695_b(p_70695_1_, p_70695_2_);
/* 699 */     this.field_71135_a.func_147359_a((Packet)new S1DPacketEntityEffect(func_145782_y(), p_70695_1_));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70688_c(PotionEffect p_70688_1_) {
/* 704 */     super.func_70688_c(p_70688_1_);
/* 705 */     this.field_71135_a.func_147359_a((Packet)new S1EPacketRemoveEntityEffect(func_145782_y(), p_70688_1_));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70634_a(double p_70634_1_, double p_70634_3_, double p_70634_5_) {
/* 710 */     this.field_71135_a.func_147364_a(p_70634_1_, p_70634_3_, p_70634_5_, this.field_70177_z, this.field_70125_A);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71009_b(Entity p_71009_1_) {
/* 715 */     func_71121_q().func_73039_n().func_151248_b((Entity)this, (Packet)new S0BPacketAnimation(p_71009_1_, 4));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71047_c(Entity p_71047_1_) {
/* 720 */     func_71121_q().func_73039_n().func_151248_b((Entity)this, (Packet)new S0BPacketAnimation(p_71047_1_, 5));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71016_p() {
/* 725 */     if (this.field_71135_a == null)
/* 726 */       return;  this.field_71135_a.func_147359_a((Packet)new S39PacketPlayerAbilities(this.field_71075_bZ));
/*     */   }
/*     */   
/*     */   public WorldServer func_71121_q() {
/* 730 */     return (WorldServer)this.field_70170_p;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71033_a(WorldSettings.GameType p_71033_1_) {
/* 735 */     this.field_71134_c.func_73076_a(p_71033_1_);
/* 736 */     this.field_71135_a.func_147359_a((Packet)new S2BPacketChangeGameState(3, p_71033_1_.func_77148_a()));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_145747_a(IChatComponent p_145747_1_) {
/* 741 */     this.field_71135_a.func_147359_a((Packet)new S02PacketChat(p_145747_1_));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70003_b(int p_70003_1_, String p_70003_2_) {
/* 746 */     if ("seed".equals(p_70003_2_) && !this.field_71133_b.func_71262_S()) {
/* 747 */       return true;
/*     */     }
/* 749 */     if ("tell".equals(p_70003_2_) || "help".equals(p_70003_2_) || "me".equals(p_70003_2_)) return true; 
/* 750 */     if (this.field_71133_b.func_71203_ab().func_152596_g(func_146103_bH())) {
/* 751 */       UserListOpsEntry userListOpsEntry = (UserListOpsEntry)this.field_71133_b.func_71203_ab().func_152603_m().func_152683_b(func_146103_bH());
/* 752 */       if (userListOpsEntry != null) {
/* 753 */         return (userListOpsEntry.func_152644_a() >= p_70003_1_);
/*     */       }
/* 755 */       return (this.field_71133_b.func_110455_j() >= p_70003_1_);
/*     */     } 
/* 757 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_71114_r() {
/* 762 */     String str = this.field_71135_a.field_147371_a.func_74430_c().toString();
/* 763 */     str = str.substring(str.indexOf("/") + 1);
/* 764 */     str = str.substring(0, str.indexOf(":"));
/* 765 */     return str;
/*     */   }
/*     */   
/*     */   public void func_147100_a(C15PacketClientSettings p_147100_1_) {
/* 769 */     this.field_71148_cg = p_147100_1_.func_149524_c();
/*     */     
/* 771 */     int i = 256 >> p_147100_1_.func_149521_d();
/* 772 */     if (i <= 3 || i < 20);
/*     */ 
/*     */     
/* 775 */     this.field_71143_cn = p_147100_1_.func_149523_e();
/* 776 */     this.field_71140_co = p_147100_1_.func_149520_f();
/*     */     
/* 778 */     if (this.field_71133_b.func_71264_H() && this.field_71133_b.func_71214_G().equals(func_70005_c_())) {
/* 779 */       this.field_71133_b.func_147139_a(p_147100_1_.func_149518_g());
/*     */     }
/*     */     
/* 782 */     func_82239_b(1, !p_147100_1_.func_149519_h());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityPlayer.EnumChatVisibility func_147096_v() {
/* 790 */     return this.field_71143_cn;
/*     */   }
/*     */   
/*     */   public void func_147095_a(String p_147095_1_) {
/* 794 */     this.field_71135_a.func_147359_a((Packet)new S3FPacketCustomPayload("MC|RPack", p_147095_1_.getBytes(Charsets.UTF_8)));
/*     */   }
/*     */ 
/*     */   
/*     */   public ChunkCoordinates func_82114_b() {
/* 799 */     return new ChunkCoordinates(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u + 0.5D), MathHelper.func_76128_c(this.field_70161_v));
/*     */   }
/*     */   
/*     */   public void func_143004_u() {
/* 803 */     this.field_143005_bX = MinecraftServer.func_130071_aq();
/*     */   }
/*     */   
/*     */   public StatisticsFile func_147099_x() {
/* 807 */     return this.field_147103_bO;
/*     */   }
/*     */   
/*     */   public void func_152339_d(Entity p_152339_1_) {
/* 811 */     if (p_152339_1_ instanceof EntityPlayer) {
/* 812 */       this.field_71135_a.func_147359_a((Packet)new S13PacketDestroyEntities(new int[] { p_152339_1_.func_145782_y() }));
/*     */     } else {
/* 814 */       this.field_71130_g.add(Integer.valueOf(p_152339_1_.func_145782_y()));
/*     */     } 
/*     */   }
/*     */   
/*     */   public long func_154331_x() {
/* 819 */     return this.field_143005_bX;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\player\EntityPlayerMP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */