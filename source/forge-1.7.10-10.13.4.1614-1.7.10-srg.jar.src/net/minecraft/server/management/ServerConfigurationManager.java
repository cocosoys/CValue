/*     */ package net.minecraft.server.management;
/*     */ import com.mojang.authlib.GameProfile;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.File;
/*     */ import java.net.SocketAddress;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.network.NetHandlerPlayServer;
/*     */ import net.minecraft.network.NetworkManager;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.server.S1DPacketEntityEffect;
/*     */ import net.minecraft.network.play.server.S2BPacketChangeGameState;
/*     */ import net.minecraft.network.play.server.S38PacketPlayerListItem;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.scoreboard.Score;
/*     */ import net.minecraft.scoreboard.ScoreObjective;
/*     */ import net.minecraft.scoreboard.ScorePlayerTeam;
/*     */ import net.minecraft.scoreboard.ServerScoreboard;
/*     */ import net.minecraft.scoreboard.Team;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.stats.StatisticsFile;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.util.ChunkCoordinates;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldServer;
/*     */ import net.minecraft.world.WorldSettings;
/*     */ import net.minecraft.world.demo.DemoWorldManager;
/*     */ 
/*     */ public abstract class ServerConfigurationManager {
/*  41 */   public static final File field_152613_a = new File("banned-players.json");
/*  42 */   public static final File field_152614_b = new File("banned-ips.json");
/*  43 */   public static final File field_152615_c = new File("ops.json");
/*  44 */   public static final File field_152616_d = new File("whitelist.json");
/*  45 */   private static final Logger field_148546_d = LogManager.getLogger();
/*     */   
/*  47 */   private static final SimpleDateFormat field_72403_e = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
/*     */   
/*     */   private final MinecraftServer field_72400_f;
/*  50 */   public final List field_72404_b = new ArrayList();
/*  51 */   private final UserListBans field_72401_g = new UserListBans(field_152613_a);
/*  52 */   private final BanList field_72413_h = new BanList(field_152614_b);
/*  53 */   private final UserListOps field_72414_i = new UserListOps(field_152615_c);
/*  54 */   private final UserListWhitelist field_72411_j = new UserListWhitelist(field_152616_d);
/*  55 */   private final Map field_148547_k = Maps.newHashMap(); private IPlayerFileData field_72412_k;
/*     */   private boolean field_72409_l;
/*     */   protected int field_72405_c;
/*     */   private int field_72402_d;
/*     */   private WorldSettings.GameType field_72410_m;
/*     */   private boolean field_72407_n;
/*     */   private int field_72408_o;
/*     */   private static final String __OBFID = "CL_00001423";
/*     */   
/*     */   public ServerConfigurationManager(MinecraftServer p_i1500_1_) {
/*  65 */     this.field_72400_f = p_i1500_1_;
/*     */     
/*  67 */     this.field_72401_g.func_152686_a(false);
/*  68 */     this.field_72413_h.func_152686_a(false);
/*     */     
/*  70 */     this.field_72405_c = 8;
/*     */   }
/*     */   public void func_72355_a(NetworkManager p_72355_1_, EntityPlayerMP p_72355_2_) {
/*     */     ChatComponentTranslation chatComponentTranslation;
/*  74 */     GameProfile gameProfile1 = p_72355_2_.func_146103_bH();
/*     */     
/*  76 */     PlayerProfileCache playerProfileCache = this.field_72400_f.func_152358_ax();
/*  77 */     GameProfile gameProfile2 = playerProfileCache.func_152652_a(gameProfile1.getId());
/*  78 */     String str1 = (gameProfile2 == null) ? gameProfile1.getName() : gameProfile2.getName();
/*  79 */     playerProfileCache.func_152649_a(gameProfile1);
/*     */     
/*  81 */     NBTTagCompound nBTTagCompound = func_72380_a(p_72355_2_);
/*  82 */     p_72355_2_.func_70029_a((World)this.field_72400_f.func_71218_a(p_72355_2_.field_71093_bK));
/*  83 */     p_72355_2_.field_71134_c.func_73080_a((WorldServer)p_72355_2_.field_70170_p);
/*     */     
/*  85 */     String str2 = "local";
/*     */     
/*  87 */     if (p_72355_1_.func_74430_c() != null) {
/*  88 */       str2 = p_72355_1_.func_74430_c().toString();
/*     */     }
/*     */     
/*  91 */     field_148546_d.info(p_72355_2_.func_70005_c_() + "[" + str2 + "] logged in with entity id " + p_72355_2_.func_145782_y() + " at (" + p_72355_2_.field_70165_t + ", " + p_72355_2_.field_70163_u + ", " + p_72355_2_.field_70161_v + ")");
/*     */     
/*  93 */     WorldServer worldServer = this.field_72400_f.func_71218_a(p_72355_2_.field_71093_bK);
/*     */     
/*  95 */     ChunkCoordinates chunkCoordinates = worldServer.func_72861_E();
/*     */     
/*  97 */     func_72381_a(p_72355_2_, null, (World)worldServer);
/*     */     
/*  99 */     NetHandlerPlayServer netHandlerPlayServer = new NetHandlerPlayServer(this.field_72400_f, p_72355_1_, p_72355_2_);
/* 100 */     netHandlerPlayServer.func_147359_a((Packet)new S01PacketJoinGame(p_72355_2_.func_145782_y(), p_72355_2_.field_71134_c.func_73081_b(), worldServer.func_72912_H().func_76093_s(), worldServer.field_73011_w.field_76574_g, worldServer.field_73013_u, func_72352_l(), worldServer.func_72912_H().func_76067_t()));
/* 101 */     netHandlerPlayServer.func_147359_a((Packet)new S3FPacketCustomPayload("MC|Brand", func_72365_p().getServerModName().getBytes(Charsets.UTF_8)));
/* 102 */     netHandlerPlayServer.func_147359_a((Packet)new S05PacketSpawnPosition(chunkCoordinates.field_71574_a, chunkCoordinates.field_71572_b, chunkCoordinates.field_71573_c));
/* 103 */     netHandlerPlayServer.func_147359_a((Packet)new S39PacketPlayerAbilities(p_72355_2_.field_71075_bZ));
/* 104 */     netHandlerPlayServer.func_147359_a((Packet)new S09PacketHeldItemChange(p_72355_2_.field_71071_by.field_70461_c));
/*     */     
/* 106 */     p_72355_2_.func_147099_x().func_150877_d();
/* 107 */     p_72355_2_.func_147099_x().func_150884_b(p_72355_2_);
/*     */     
/* 109 */     func_96456_a((ServerScoreboard)worldServer.func_96441_U(), p_72355_2_);
/*     */     
/* 111 */     this.field_72400_f.func_147132_au();
/*     */     
/* 113 */     if (!p_72355_2_.func_70005_c_().equalsIgnoreCase(str1)) {
/* 114 */       chatComponentTranslation = new ChatComponentTranslation("multiplayer.player.joined.renamed", new Object[] { p_72355_2_.func_145748_c_(), str1 });
/*     */     } else {
/* 116 */       chatComponentTranslation = new ChatComponentTranslation("multiplayer.player.joined", new Object[] { p_72355_2_.func_145748_c_() });
/*     */     } 
/* 118 */     chatComponentTranslation.func_150256_b().func_150238_a(EnumChatFormatting.YELLOW);
/* 119 */     func_148539_a((IChatComponent)chatComponentTranslation);
/* 120 */     func_72377_c(p_72355_2_);
/*     */     
/* 122 */     netHandlerPlayServer.func_147364_a(p_72355_2_.field_70165_t, p_72355_2_.field_70163_u, p_72355_2_.field_70161_v, p_72355_2_.field_70177_z, p_72355_2_.field_70125_A);
/* 123 */     func_72354_b(p_72355_2_, worldServer);
/*     */     
/* 125 */     if (this.field_72400_f.func_147133_T().length() > 0) p_72355_2_.func_147095_a(this.field_72400_f.func_147133_T());
/*     */     
/* 127 */     for (PotionEffect potionEffect : p_72355_2_.func_70651_bq()) {
/* 128 */       netHandlerPlayServer.func_147359_a((Packet)new S1DPacketEntityEffect(p_72355_2_.func_145782_y(), potionEffect));
/*     */     }
/*     */     
/* 131 */     p_72355_2_.func_71116_b();
/*     */     
/* 133 */     if (nBTTagCompound != null && nBTTagCompound.func_150297_b("Riding", 10)) {
/*     */       
/* 135 */       Entity entity = EntityList.func_75615_a(nBTTagCompound.func_74775_l("Riding"), (World)worldServer);
/* 136 */       if (entity != null) {
/* 137 */         entity.field_98038_p = true;
/* 138 */         worldServer.func_72838_d(entity);
/* 139 */         p_72355_2_.func_70078_a(entity);
/* 140 */         entity.field_98038_p = false;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void func_96456_a(ServerScoreboard p_96456_1_, EntityPlayerMP p_96456_2_) {
/* 146 */     HashSet<ScoreObjective> hashSet = new HashSet();
/*     */     
/* 148 */     for (ScorePlayerTeam scorePlayerTeam : p_96456_1_.func_96525_g()) {
/* 149 */       p_96456_2_.field_71135_a.func_147359_a((Packet)new S3EPacketTeams(scorePlayerTeam, 0));
/*     */     }
/*     */     
/* 152 */     for (byte b = 0; b < 3; b++) {
/* 153 */       ScoreObjective scoreObjective = p_96456_1_.func_96539_a(b);
/*     */       
/* 155 */       if (scoreObjective != null && !hashSet.contains(scoreObjective)) {
/* 156 */         List list = p_96456_1_.func_96550_d(scoreObjective);
/*     */         
/* 158 */         for (Packet packet : list) {
/* 159 */           p_96456_2_.field_71135_a.func_147359_a(packet);
/*     */         }
/*     */         
/* 162 */         hashSet.add(scoreObjective);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_72364_a(WorldServer[] p_72364_1_) {
/* 168 */     this.field_72412_k = p_72364_1_[0].func_72860_G().func_75756_e();
/*     */   }
/*     */   
/*     */   public void func_72375_a(EntityPlayerMP p_72375_1_, WorldServer p_72375_2_) {
/* 172 */     WorldServer worldServer = p_72375_1_.func_71121_q();
/*     */     
/* 174 */     if (p_72375_2_ != null) p_72375_2_.func_73040_p().func_72695_c(p_72375_1_); 
/* 175 */     worldServer.func_73040_p().func_72683_a(p_72375_1_);
/*     */     
/* 177 */     worldServer.field_73059_b.func_73158_c((int)p_72375_1_.field_70165_t >> 4, (int)p_72375_1_.field_70161_v >> 4);
/*     */   }
/*     */   
/*     */   public int func_72372_a() {
/* 181 */     return PlayerManager.func_72686_a(func_72395_o());
/*     */   }
/*     */   
/*     */   public NBTTagCompound func_72380_a(EntityPlayerMP p_72380_1_) {
/* 185 */     NBTTagCompound nBTTagCompound2, nBTTagCompound1 = this.field_72400_f.field_71305_c[0].func_72912_H().func_76072_h();
/*     */ 
/*     */     
/* 188 */     if (p_72380_1_.func_70005_c_().equals(this.field_72400_f.func_71214_G()) && nBTTagCompound1 != null) {
/* 189 */       p_72380_1_.func_70020_e(nBTTagCompound1);
/* 190 */       nBTTagCompound2 = nBTTagCompound1;
/* 191 */       field_148546_d.debug("loading single player");
/*     */     } else {
/* 193 */       nBTTagCompound2 = this.field_72412_k.func_75752_b((EntityPlayer)p_72380_1_);
/*     */     } 
/* 195 */     return nBTTagCompound2;
/*     */   }
/*     */   
/*     */   protected void func_72391_b(EntityPlayerMP p_72391_1_) {
/* 199 */     this.field_72412_k.func_75753_a((EntityPlayer)p_72391_1_);
/* 200 */     StatisticsFile statisticsFile = (StatisticsFile)this.field_148547_k.get(p_72391_1_.func_110124_au());
/* 201 */     if (statisticsFile != null) {
/* 202 */       statisticsFile.func_150883_b();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_72377_c(EntityPlayerMP p_72377_1_) {
/* 212 */     func_148540_a((Packet)new S38PacketPlayerListItem(p_72377_1_.func_70005_c_(), true, 1000));
/*     */     
/* 214 */     this.field_72404_b.add(p_72377_1_);
/*     */ 
/*     */     
/* 217 */     WorldServer worldServer = this.field_72400_f.func_71218_a(p_72377_1_.field_71093_bK);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 225 */     worldServer.func_72838_d((Entity)p_72377_1_);
/* 226 */     func_72375_a(p_72377_1_, null);
/*     */     
/* 228 */     for (byte b = 0; b < this.field_72404_b.size(); b++) {
/* 229 */       EntityPlayerMP entityPlayerMP = this.field_72404_b.get(b);
/* 230 */       p_72377_1_.field_71135_a.func_147359_a((Packet)new S38PacketPlayerListItem(entityPlayerMP.func_70005_c_(), true, entityPlayerMP.field_71138_i));
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_72358_d(EntityPlayerMP p_72358_1_) {
/* 235 */     p_72358_1_.func_71121_q().func_73040_p().func_72685_d(p_72358_1_);
/*     */   }
/*     */   
/*     */   public void func_72367_e(EntityPlayerMP p_72367_1_) {
/* 239 */     p_72367_1_.func_71029_a(StatList.field_75947_j);
/* 240 */     func_72391_b(p_72367_1_);
/* 241 */     WorldServer worldServer = p_72367_1_.func_71121_q();
/* 242 */     if (p_72367_1_.field_70154_o != null) {
/*     */ 
/*     */ 
/*     */       
/* 246 */       worldServer.func_72973_f(p_72367_1_.field_70154_o);
/* 247 */       field_148546_d.debug("removing player mount");
/*     */     } 
/* 249 */     worldServer.func_72900_e((Entity)p_72367_1_);
/* 250 */     worldServer.func_73040_p().func_72695_c(p_72367_1_);
/* 251 */     this.field_72404_b.remove(p_72367_1_);
/* 252 */     this.field_148547_k.remove(p_72367_1_.func_110124_au());
/* 253 */     func_148540_a((Packet)new S38PacketPlayerListItem(p_72367_1_.func_70005_c_(), false, 9999));
/*     */   }
/*     */   
/*     */   public String func_148542_a(SocketAddress p_148542_1_, GameProfile p_148542_2_) {
/* 257 */     if (this.field_72401_g.func_152702_a(p_148542_2_)) {
/* 258 */       UserListBansEntry userListBansEntry = (UserListBansEntry)this.field_72401_g.func_152683_b(p_148542_2_);
/* 259 */       String str = "You are banned from this server!\nReason: " + userListBansEntry.func_73686_f();
/*     */       
/* 261 */       if (userListBansEntry.func_73680_d() != null) {
/* 262 */         str = str + "\nYour ban will be removed on " + field_72403_e.format(userListBansEntry.func_73680_d());
/*     */       }
/*     */       
/* 265 */       return str;
/*     */     } 
/*     */     
/* 268 */     if (!func_152607_e(p_148542_2_)) {
/* 269 */       return "You are not white-listed on this server!";
/*     */     }
/*     */     
/* 272 */     if (this.field_72413_h.func_152708_a(p_148542_1_)) {
/* 273 */       IPBanEntry iPBanEntry = this.field_72413_h.func_152709_b(p_148542_1_);
/* 274 */       String str = "Your IP address is banned from this server!\nReason: " + iPBanEntry.func_73686_f();
/*     */       
/* 276 */       if (iPBanEntry.func_73680_d() != null) {
/* 277 */         str = str + "\nYour ban will be removed on " + field_72403_e.format(iPBanEntry.func_73680_d());
/*     */       }
/*     */       
/* 280 */       return str;
/*     */     } 
/*     */     
/* 283 */     if (this.field_72404_b.size() >= this.field_72405_c) {
/* 284 */       return "The server is full!";
/*     */     }
/*     */     
/* 287 */     return null;
/*     */   }
/*     */   
/*     */   public EntityPlayerMP func_148545_a(GameProfile p_148545_1_) {
/*     */     ItemInWorldManager itemInWorldManager;
/* 292 */     UUID uUID = EntityPlayer.func_146094_a(p_148545_1_);
/* 293 */     ArrayList<EntityPlayerMP> arrayList = Lists.newArrayList();
/* 294 */     for (byte b = 0; b < this.field_72404_b.size(); b++) {
/* 295 */       EntityPlayerMP entityPlayerMP = this.field_72404_b.get(b);
/* 296 */       if (entityPlayerMP.func_110124_au().equals(uUID)) {
/* 297 */         arrayList.add(entityPlayerMP);
/*     */       }
/*     */     } 
/* 300 */     for (EntityPlayerMP entityPlayerMP : arrayList) {
/* 301 */       entityPlayerMP.field_71135_a.func_147360_c("You logged in from another location");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 306 */     if (this.field_72400_f.func_71242_L()) {
/* 307 */       DemoWorldManager demoWorldManager = new DemoWorldManager((World)this.field_72400_f.func_71218_a(0));
/*     */     } else {
/* 309 */       itemInWorldManager = new ItemInWorldManager((World)this.field_72400_f.func_71218_a(0));
/*     */     } 
/*     */     
/* 312 */     return new EntityPlayerMP(this.field_72400_f, this.field_72400_f.func_71218_a(0), p_148545_1_, itemInWorldManager);
/*     */   }
/*     */   public EntityPlayerMP func_72368_a(EntityPlayerMP p_72368_1_, int p_72368_2_, boolean p_72368_3_) {
/*     */     ItemInWorldManager itemInWorldManager;
/* 316 */     p_72368_1_.func_71121_q().func_73039_n().func_72787_a(p_72368_1_);
/* 317 */     p_72368_1_.func_71121_q().func_73039_n().func_72790_b((Entity)p_72368_1_);
/* 318 */     p_72368_1_.func_71121_q().func_73040_p().func_72695_c(p_72368_1_);
/* 319 */     this.field_72404_b.remove(p_72368_1_);
/* 320 */     this.field_72400_f.func_71218_a(p_72368_1_.field_71093_bK).func_72973_f((Entity)p_72368_1_);
/*     */     
/* 322 */     ChunkCoordinates chunkCoordinates1 = p_72368_1_.func_70997_bJ();
/* 323 */     boolean bool = p_72368_1_.func_82245_bX();
/*     */     
/* 325 */     p_72368_1_.field_71093_bK = p_72368_2_;
/*     */ 
/*     */ 
/*     */     
/* 329 */     if (this.field_72400_f.func_71242_L()) {
/* 330 */       DemoWorldManager demoWorldManager = new DemoWorldManager((World)this.field_72400_f.func_71218_a(p_72368_1_.field_71093_bK));
/*     */     } else {
/* 332 */       itemInWorldManager = new ItemInWorldManager((World)this.field_72400_f.func_71218_a(p_72368_1_.field_71093_bK));
/*     */     } 
/*     */     
/* 335 */     EntityPlayerMP entityPlayerMP = new EntityPlayerMP(this.field_72400_f, this.field_72400_f.func_71218_a(p_72368_1_.field_71093_bK), p_72368_1_.func_146103_bH(), itemInWorldManager);
/* 336 */     entityPlayerMP.field_71135_a = p_72368_1_.field_71135_a;
/* 337 */     entityPlayerMP.func_71049_a((EntityPlayer)p_72368_1_, p_72368_3_);
/* 338 */     entityPlayerMP.func_145769_d(p_72368_1_.func_145782_y());
/*     */     
/* 340 */     WorldServer worldServer = this.field_72400_f.func_71218_a(p_72368_1_.field_71093_bK);
/* 341 */     func_72381_a(entityPlayerMP, p_72368_1_, (World)worldServer);
/*     */     
/* 343 */     if (chunkCoordinates1 != null) {
/* 344 */       ChunkCoordinates chunkCoordinates = EntityPlayer.func_71056_a((World)this.field_72400_f.func_71218_a(p_72368_1_.field_71093_bK), chunkCoordinates1, bool);
/* 345 */       if (chunkCoordinates != null) {
/* 346 */         entityPlayerMP.func_70012_b((chunkCoordinates.field_71574_a + 0.5F), (chunkCoordinates.field_71572_b + 0.1F), (chunkCoordinates.field_71573_c + 0.5F), 0.0F, 0.0F);
/* 347 */         entityPlayerMP.func_71063_a(chunkCoordinates1, bool);
/*     */       } else {
/* 349 */         entityPlayerMP.field_71135_a.func_147359_a((Packet)new S2BPacketChangeGameState(0, 0.0F));
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 354 */     worldServer.field_73059_b.func_73158_c((int)entityPlayerMP.field_70165_t >> 4, (int)entityPlayerMP.field_70161_v >> 4);
/*     */     
/* 356 */     while (!worldServer.func_72945_a((Entity)entityPlayerMP, entityPlayerMP.field_70121_D).isEmpty()) {
/* 357 */       entityPlayerMP.func_70107_b(entityPlayerMP.field_70165_t, entityPlayerMP.field_70163_u + 1.0D, entityPlayerMP.field_70161_v);
/*     */     }
/*     */     
/* 360 */     entityPlayerMP.field_71135_a.func_147359_a((Packet)new S07PacketRespawn(entityPlayerMP.field_71093_bK, entityPlayerMP.field_70170_p.field_73013_u, entityPlayerMP.field_70170_p.func_72912_H().func_76067_t(), entityPlayerMP.field_71134_c.func_73081_b()));
/* 361 */     ChunkCoordinates chunkCoordinates2 = worldServer.func_72861_E();
/* 362 */     entityPlayerMP.field_71135_a.func_147364_a(entityPlayerMP.field_70165_t, entityPlayerMP.field_70163_u, entityPlayerMP.field_70161_v, entityPlayerMP.field_70177_z, entityPlayerMP.field_70125_A);
/* 363 */     entityPlayerMP.field_71135_a.func_147359_a((Packet)new S05PacketSpawnPosition(chunkCoordinates2.field_71574_a, chunkCoordinates2.field_71572_b, chunkCoordinates2.field_71573_c));
/* 364 */     entityPlayerMP.field_71135_a.func_147359_a((Packet)new S1FPacketSetExperience(entityPlayerMP.field_71106_cc, entityPlayerMP.field_71067_cb, entityPlayerMP.field_71068_ca));
/* 365 */     func_72354_b(entityPlayerMP, worldServer);
/*     */     
/* 367 */     worldServer.func_73040_p().func_72683_a(entityPlayerMP);
/* 368 */     worldServer.func_72838_d((Entity)entityPlayerMP);
/* 369 */     this.field_72404_b.add(entityPlayerMP);
/*     */     
/* 371 */     entityPlayerMP.func_71116_b();
/* 372 */     entityPlayerMP.func_70606_j(entityPlayerMP.func_110143_aJ());
/* 373 */     return entityPlayerMP;
/*     */   }
/*     */   
/*     */   public void func_72356_a(EntityPlayerMP p_72356_1_, int p_72356_2_) {
/* 377 */     int i = p_72356_1_.field_71093_bK;
/* 378 */     WorldServer worldServer1 = this.field_72400_f.func_71218_a(p_72356_1_.field_71093_bK);
/* 379 */     p_72356_1_.field_71093_bK = p_72356_2_;
/*     */     
/* 381 */     WorldServer worldServer2 = this.field_72400_f.func_71218_a(p_72356_1_.field_71093_bK);
/*     */     
/* 383 */     p_72356_1_.field_71135_a.func_147359_a((Packet)new S07PacketRespawn(p_72356_1_.field_71093_bK, p_72356_1_.field_70170_p.field_73013_u, p_72356_1_.field_70170_p.func_72912_H().func_76067_t(), p_72356_1_.field_71134_c.func_73081_b()));
/*     */     
/* 385 */     worldServer1.func_72973_f((Entity)p_72356_1_);
/* 386 */     p_72356_1_.field_70128_L = false;
/*     */     
/* 388 */     func_82448_a((Entity)p_72356_1_, i, worldServer1, worldServer2);
/* 389 */     func_72375_a(p_72356_1_, worldServer1);
/*     */     
/* 391 */     p_72356_1_.field_71135_a.func_147364_a(p_72356_1_.field_70165_t, p_72356_1_.field_70163_u, p_72356_1_.field_70161_v, p_72356_1_.field_70177_z, p_72356_1_.field_70125_A);
/* 392 */     p_72356_1_.field_71134_c.func_73080_a(worldServer2);
/* 393 */     func_72354_b(p_72356_1_, worldServer2);
/* 394 */     func_72385_f(p_72356_1_);
/*     */     
/* 396 */     for (PotionEffect potionEffect : p_72356_1_.func_70651_bq()) {
/* 397 */       p_72356_1_.field_71135_a.func_147359_a((Packet)new S1DPacketEntityEffect(p_72356_1_.func_145782_y(), potionEffect));
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_82448_a(Entity p_82448_1_, int p_82448_2_, WorldServer p_82448_3_, WorldServer p_82448_4_) {
/* 402 */     double d1 = p_82448_1_.field_70165_t;
/* 403 */     double d2 = p_82448_1_.field_70161_v;
/* 404 */     double d3 = 8.0D;
/* 405 */     double d4 = p_82448_1_.field_70165_t;
/* 406 */     double d5 = p_82448_1_.field_70163_u;
/* 407 */     double d6 = p_82448_1_.field_70161_v;
/* 408 */     float f = p_82448_1_.field_70177_z;
/*     */     
/* 410 */     p_82448_3_.field_72984_F.func_76320_a("moving");
/* 411 */     if (p_82448_1_.field_71093_bK == -1) {
/*     */       
/* 413 */       d1 /= d3;
/* 414 */       d2 /= d3;
/* 415 */       p_82448_1_.func_70012_b(d1, p_82448_1_.field_70163_u, d2, p_82448_1_.field_70177_z, p_82448_1_.field_70125_A);
/* 416 */       if (p_82448_1_.func_70089_S()) {
/* 417 */         p_82448_3_.func_72866_a(p_82448_1_, false);
/*     */       }
/* 419 */     } else if (p_82448_1_.field_71093_bK == 0) {
/*     */       
/* 421 */       d1 *= d3;
/* 422 */       d2 *= d3;
/* 423 */       p_82448_1_.func_70012_b(d1, p_82448_1_.field_70163_u, d2, p_82448_1_.field_70177_z, p_82448_1_.field_70125_A);
/* 424 */       if (p_82448_1_.func_70089_S()) {
/* 425 */         p_82448_3_.func_72866_a(p_82448_1_, false);
/*     */       }
/*     */     } else {
/*     */       ChunkCoordinates chunkCoordinates;
/*     */       
/* 430 */       if (p_82448_2_ == 1) {
/*     */         
/* 432 */         chunkCoordinates = p_82448_4_.func_72861_E();
/*     */       } else {
/*     */         
/* 435 */         chunkCoordinates = p_82448_4_.func_73054_j();
/*     */       } 
/*     */       
/* 438 */       d1 = chunkCoordinates.field_71574_a;
/* 439 */       p_82448_1_.field_70163_u = chunkCoordinates.field_71572_b;
/* 440 */       d2 = chunkCoordinates.field_71573_c;
/*     */       
/* 442 */       p_82448_1_.func_70012_b(d1, p_82448_1_.field_70163_u, d2, 90.0F, 0.0F);
/* 443 */       if (p_82448_1_.func_70089_S()) {
/* 444 */         p_82448_3_.func_72866_a(p_82448_1_, false);
/*     */       }
/*     */     } 
/* 447 */     p_82448_3_.field_72984_F.func_76319_b();
/*     */     
/* 449 */     if (p_82448_2_ != 1) {
/* 450 */       p_82448_3_.field_72984_F.func_76320_a("placing");
/*     */       
/* 452 */       d1 = MathHelper.func_76125_a((int)d1, -29999872, 29999872);
/* 453 */       d2 = MathHelper.func_76125_a((int)d2, -29999872, 29999872);
/* 454 */       if (p_82448_1_.func_70089_S()) {
/* 455 */         p_82448_1_.func_70012_b(d1, p_82448_1_.field_70163_u, d2, p_82448_1_.field_70177_z, p_82448_1_.field_70125_A);
/* 456 */         p_82448_4_.func_85176_s().func_77185_a(p_82448_1_, d4, d5, d6, f);
/* 457 */         p_82448_4_.func_72838_d(p_82448_1_);
/* 458 */         p_82448_4_.func_72866_a(p_82448_1_, false);
/*     */       } 
/* 460 */       p_82448_3_.field_72984_F.func_76319_b();
/*     */     } 
/*     */     
/* 463 */     p_82448_1_.func_70029_a((World)p_82448_4_);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_72374_b() {
/* 469 */     if (++this.field_72408_o > 600) {
/* 470 */       this.field_72408_o = 0;
/*     */     }
/* 472 */     if (this.field_72408_o < this.field_72404_b.size()) {
/* 473 */       EntityPlayerMP entityPlayerMP = this.field_72404_b.get(this.field_72408_o);
/* 474 */       func_148540_a((Packet)new S38PacketPlayerListItem(entityPlayerMP.func_70005_c_(), true, entityPlayerMP.field_71138_i));
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_148540_a(Packet p_148540_1_) {
/* 479 */     for (byte b = 0; b < this.field_72404_b.size(); b++) {
/* 480 */       ((EntityPlayerMP)this.field_72404_b.get(b)).field_71135_a.func_147359_a(p_148540_1_);
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_148537_a(Packet p_148537_1_, int p_148537_2_) {
/* 485 */     for (byte b = 0; b < this.field_72404_b.size(); b++) {
/* 486 */       EntityPlayerMP entityPlayerMP = this.field_72404_b.get(b);
/* 487 */       if (entityPlayerMP.field_71093_bK == p_148537_2_) entityPlayerMP.field_71135_a.func_147359_a(p_148537_1_); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public String func_152609_b(boolean p_152609_1_) {
/* 492 */     String str = "";
/*     */     
/* 494 */     ArrayList<EntityPlayerMP> arrayList = Lists.newArrayList(this.field_72404_b);
/* 495 */     for (byte b = 0; b < arrayList.size(); b++) {
/* 496 */       if (b > 0) str = str + ", "; 
/* 497 */       str = str + ((EntityPlayerMP)arrayList.get(b)).func_70005_c_();
/* 498 */       if (p_152609_1_) {
/* 499 */         str = str + " (" + ((EntityPlayerMP)arrayList.get(b)).func_110124_au().toString() + ")";
/*     */       }
/*     */     } 
/* 502 */     return str;
/*     */   }
/*     */   
/*     */   public String[] func_72369_d() {
/* 506 */     String[] arrayOfString = new String[this.field_72404_b.size()];
/* 507 */     for (byte b = 0; b < this.field_72404_b.size(); b++) {
/* 508 */       arrayOfString[b] = ((EntityPlayerMP)this.field_72404_b.get(b)).func_70005_c_();
/*     */     }
/* 510 */     return arrayOfString;
/*     */   }
/*     */   
/*     */   public GameProfile[] func_152600_g() {
/* 514 */     GameProfile[] arrayOfGameProfile = new GameProfile[this.field_72404_b.size()];
/* 515 */     for (byte b = 0; b < this.field_72404_b.size(); b++) {
/* 516 */       arrayOfGameProfile[b] = ((EntityPlayerMP)this.field_72404_b.get(b)).func_146103_bH();
/*     */     }
/* 518 */     return arrayOfGameProfile;
/*     */   }
/*     */   
/*     */   public UserListBans func_152608_h() {
/* 522 */     return this.field_72401_g;
/*     */   }
/*     */   
/*     */   public BanList func_72363_f() {
/* 526 */     return this.field_72413_h;
/*     */   }
/*     */   
/*     */   public void func_152605_a(GameProfile p_152605_1_) {
/* 530 */     this.field_72414_i.func_152687_a(new UserListOpsEntry(p_152605_1_, this.field_72400_f.func_110455_j()));
/*     */   }
/*     */   
/*     */   public void func_152610_b(GameProfile p_152610_1_) {
/* 534 */     this.field_72414_i.func_152684_c(p_152610_1_);
/*     */   }
/*     */   
/*     */   public boolean func_152607_e(GameProfile p_152607_1_) {
/* 538 */     return (!this.field_72409_l || this.field_72414_i.func_152692_d(p_152607_1_) || this.field_72411_j.func_152692_d(p_152607_1_));
/*     */   }
/*     */   
/*     */   public boolean func_152596_g(GameProfile p_152596_1_) {
/* 542 */     return (this.field_72414_i.func_152692_d(p_152596_1_) || (this.field_72400_f.func_71264_H() && this.field_72400_f.field_71305_c[0].func_72912_H().func_76086_u() && this.field_72400_f.func_71214_G().equalsIgnoreCase(p_152596_1_.getName())) || this.field_72407_n);
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityPlayerMP func_152612_a(String p_152612_1_) {
/* 547 */     for (EntityPlayerMP entityPlayerMP : this.field_72404_b) {
/* 548 */       if (entityPlayerMP.func_70005_c_().equalsIgnoreCase(p_152612_1_)) {
/* 549 */         return entityPlayerMP;
/*     */       }
/*     */     } 
/* 552 */     return null;
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
/*     */   public List func_82449_a(ChunkCoordinates p_82449_1_, int p_82449_2_, int p_82449_3_, int p_82449_4_, int p_82449_5_, int p_82449_6_, int p_82449_7_, Map p_82449_8_, String p_82449_9_, String p_82449_10_, World p_82449_11_) {
/* 577 */     if (this.field_72404_b.isEmpty()) return Collections.emptyList();
/*     */     
/* 579 */     List<EntityPlayerMP> list = new ArrayList();
/* 580 */     boolean bool = (p_82449_4_ < 0) ? true : false;
/* 581 */     boolean bool1 = (p_82449_9_ != null && p_82449_9_.startsWith("!"));
/* 582 */     boolean bool2 = (p_82449_10_ != null && p_82449_10_.startsWith("!"));
/* 583 */     int i = p_82449_2_ * p_82449_2_;
/* 584 */     int j = p_82449_3_ * p_82449_3_;
/* 585 */     p_82449_4_ = MathHelper.func_76130_a(p_82449_4_);
/*     */     
/* 587 */     if (bool1) p_82449_9_ = p_82449_9_.substring(1); 
/* 588 */     if (bool2) p_82449_10_ = p_82449_10_.substring(1);
/*     */     
/* 590 */     for (byte b = 0; b < this.field_72404_b.size(); b++) {
/* 591 */       EntityPlayerMP entityPlayerMP = this.field_72404_b.get(b);
/*     */       
/* 593 */       if ((p_82449_11_ != null && entityPlayerMP.field_70170_p != p_82449_11_) || (
/* 594 */         p_82449_9_ != null && 
/* 595 */         bool1 == p_82449_9_.equalsIgnoreCase(entityPlayerMP.func_70005_c_())))
/*     */         continue; 
/* 597 */       if (p_82449_10_ != null) {
/* 598 */         Team team = entityPlayerMP.func_96124_cp();
/* 599 */         String str = (team == null) ? "" : team.func_96661_b();
/* 600 */         if (bool2 == p_82449_10_.equalsIgnoreCase(str))
/*     */           continue; 
/*     */       } 
/* 603 */       if (p_82449_1_ != null && (p_82449_2_ > 0 || p_82449_3_ > 0)) {
/* 604 */         float f = p_82449_1_.func_82371_e(entityPlayerMP.func_82114_b());
/* 605 */         if ((p_82449_2_ > 0 && f < i) || (
/* 606 */           p_82449_3_ > 0 && f > j))
/*     */           continue; 
/*     */       } 
/* 609 */       if (func_96457_a((EntityPlayer)entityPlayerMP, p_82449_8_))
/*     */       {
/* 611 */         if ((p_82449_5_ == WorldSettings.GameType.NOT_SET.func_77148_a() || p_82449_5_ == entityPlayerMP.field_71134_c.func_73081_b().func_77148_a()) && (
/* 612 */           p_82449_6_ <= 0 || entityPlayerMP.field_71068_ca >= p_82449_6_) && 
/* 613 */           entityPlayerMP.field_71068_ca <= p_82449_7_)
/*     */         {
/* 615 */           list.add(entityPlayerMP); }  } 
/*     */       continue;
/*     */     } 
/* 618 */     if (p_82449_1_ != null) Collections.sort(list, new PlayerPositionComparator(p_82449_1_)); 
/* 619 */     if (bool) Collections.reverse(list); 
/* 620 */     if (p_82449_4_ > 0) list = list.subList(0, Math.min(p_82449_4_, list.size()));
/*     */     
/* 622 */     return list;
/*     */   }
/*     */   
/*     */   private boolean func_96457_a(EntityPlayer p_96457_1_, Map p_96457_2_) {
/* 626 */     if (p_96457_2_ == null || p_96457_2_.size() == 0) return true;
/*     */     
/* 628 */     for (Map.Entry entry : p_96457_2_.entrySet()) {
/* 629 */       String str = (String)entry.getKey();
/* 630 */       boolean bool = false;
/*     */       
/* 632 */       if (str.endsWith("_min") && str.length() > 4) {
/* 633 */         bool = true;
/* 634 */         str = str.substring(0, str.length() - 4);
/*     */       } 
/*     */       
/* 637 */       Scoreboard scoreboard = p_96457_1_.func_96123_co();
/* 638 */       ScoreObjective scoreObjective = scoreboard.func_96518_b(str);
/* 639 */       if (scoreObjective == null) return false; 
/* 640 */       Score score = p_96457_1_.func_96123_co().func_96529_a(p_96457_1_.func_70005_c_(), scoreObjective);
/* 641 */       int i = score.func_96652_c();
/*     */       
/* 643 */       if (i < ((Integer)entry.getValue()).intValue() && bool)
/* 644 */         return false; 
/* 645 */       if (i > ((Integer)entry.getValue()).intValue() && !bool) {
/* 646 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 650 */     return true;
/*     */   }
/*     */   
/*     */   public void func_148541_a(double p_148541_1_, double p_148541_3_, double p_148541_5_, double p_148541_7_, int p_148541_9_, Packet p_148541_10_) {
/* 654 */     func_148543_a(null, p_148541_1_, p_148541_3_, p_148541_5_, p_148541_7_, p_148541_9_, p_148541_10_);
/*     */   }
/*     */   
/*     */   public void func_148543_a(EntityPlayer p_148543_1_, double p_148543_2_, double p_148543_4_, double p_148543_6_, double p_148543_8_, int p_148543_10_, Packet p_148543_11_) {
/* 658 */     for (byte b = 0; b < this.field_72404_b.size(); b++) {
/* 659 */       EntityPlayerMP entityPlayerMP = this.field_72404_b.get(b);
/* 660 */       if (entityPlayerMP != p_148543_1_ && 
/* 661 */         entityPlayerMP.field_71093_bK == p_148543_10_) {
/* 662 */         double d1 = p_148543_2_ - entityPlayerMP.field_70165_t;
/* 663 */         double d2 = p_148543_4_ - entityPlayerMP.field_70163_u;
/* 664 */         double d3 = p_148543_6_ - entityPlayerMP.field_70161_v;
/* 665 */         if (d1 * d1 + d2 * d2 + d3 * d3 < p_148543_8_ * p_148543_8_)
/* 666 */           entityPlayerMP.field_71135_a.func_147359_a(p_148543_11_); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_72389_g() {
/* 672 */     for (byte b = 0; b < this.field_72404_b.size(); b++) {
/* 673 */       func_72391_b(this.field_72404_b.get(b));
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_152601_d(GameProfile p_152601_1_) {
/* 678 */     this.field_72411_j.func_152687_a(new UserListWhitelistEntry(p_152601_1_));
/*     */   }
/*     */   
/*     */   public void func_152597_c(GameProfile p_152597_1_) {
/* 682 */     this.field_72411_j.func_152684_c(p_152597_1_);
/*     */   }
/*     */   
/*     */   public UserListWhitelist func_152599_k() {
/* 686 */     return this.field_72411_j;
/*     */   }
/*     */   
/*     */   public String[] func_152598_l() {
/* 690 */     return this.field_72411_j.func_152685_a();
/*     */   }
/*     */   
/*     */   public UserListOps func_152603_m() {
/* 694 */     return this.field_72414_i;
/*     */   }
/*     */   
/*     */   public String[] func_152606_n() {
/* 698 */     return this.field_72414_i.func_152685_a();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_72362_j() {}
/*     */   
/*     */   public void func_72354_b(EntityPlayerMP p_72354_1_, WorldServer p_72354_2_) {
/* 705 */     p_72354_1_.field_71135_a.func_147359_a((Packet)new S03PacketTimeUpdate(p_72354_2_.func_82737_E(), p_72354_2_.func_72820_D(), p_72354_2_.func_82736_K().func_82766_b("doDaylightCycle")));
/* 706 */     if (p_72354_2_.func_72896_J()) {
/* 707 */       p_72354_1_.field_71135_a.func_147359_a((Packet)new S2BPacketChangeGameState(1, 0.0F));
/* 708 */       p_72354_1_.field_71135_a.func_147359_a((Packet)new S2BPacketChangeGameState(7, p_72354_2_.func_72867_j(1.0F)));
/* 709 */       p_72354_1_.field_71135_a.func_147359_a((Packet)new S2BPacketChangeGameState(8, p_72354_2_.func_72819_i(1.0F)));
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_72385_f(EntityPlayerMP p_72385_1_) {
/* 714 */     p_72385_1_.func_71120_a(p_72385_1_.field_71069_bz);
/* 715 */     p_72385_1_.func_71118_n();
/* 716 */     p_72385_1_.field_71135_a.func_147359_a((Packet)new S09PacketHeldItemChange(p_72385_1_.field_71071_by.field_70461_c));
/*     */   }
/*     */   
/*     */   public int func_72394_k() {
/* 720 */     return this.field_72404_b.size();
/*     */   }
/*     */   
/*     */   public int func_72352_l() {
/* 724 */     return this.field_72405_c;
/*     */   }
/*     */   
/*     */   public String[] func_72373_m() {
/* 728 */     return this.field_72400_f.field_71305_c[0].func_72860_G().func_75756_e().func_75754_f();
/*     */   }
/*     */   @SideOnly(Side.SERVER)
/*     */   public boolean func_72383_n() {
/* 732 */     return this.field_72409_l;
/*     */   }
/*     */   
/*     */   public void func_72371_a(boolean p_72371_1_) {
/* 736 */     this.field_72409_l = p_72371_1_;
/*     */   }
/*     */   
/*     */   public List func_72382_j(String p_72382_1_) {
/* 740 */     ArrayList<EntityPlayerMP> arrayList = new ArrayList();
/*     */     
/* 742 */     for (EntityPlayerMP entityPlayerMP : this.field_72404_b) {
/* 743 */       if (entityPlayerMP.func_71114_r().equals(p_72382_1_)) {
/* 744 */         arrayList.add(entityPlayerMP);
/*     */       }
/*     */     } 
/*     */     
/* 748 */     return arrayList;
/*     */   }
/*     */   
/*     */   public int func_72395_o() {
/* 752 */     return this.field_72402_d;
/*     */   }
/*     */   
/*     */   public MinecraftServer func_72365_p() {
/* 756 */     return this.field_72400_f;
/*     */   }
/*     */   
/*     */   public NBTTagCompound func_72378_q() {
/* 760 */     return null;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_152604_a(WorldSettings.GameType p_152604_1_) {
/* 764 */     this.field_72410_m = p_152604_1_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void func_72381_a(EntityPlayerMP p_72381_1_, EntityPlayerMP p_72381_2_, World p_72381_3_) {
/* 771 */     if (p_72381_2_ != null) {
/* 772 */       p_72381_1_.field_71134_c.func_73076_a(p_72381_2_.field_71134_c.func_73081_b());
/* 773 */     } else if (this.field_72410_m != null) {
/* 774 */       p_72381_1_.field_71134_c.func_73076_a(this.field_72410_m);
/*     */     } 
/* 776 */     p_72381_1_.field_71134_c.func_73077_b(p_72381_3_.func_72912_H().func_76077_q());
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_72387_b(boolean p_72387_1_) {
/* 780 */     this.field_72407_n = p_72387_1_;
/*     */   }
/*     */   
/*     */   public void func_72392_r() {
/* 784 */     for (byte b = 0; b < this.field_72404_b.size(); b++) {
/* 785 */       ((EntityPlayerMP)this.field_72404_b.get(b)).field_71135_a.func_147360_c("Server closed");
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_148544_a(IChatComponent p_148544_1_, boolean p_148544_2_) {
/* 790 */     this.field_72400_f.func_145747_a(p_148544_1_);
/* 791 */     func_148540_a((Packet)new S02PacketChat(p_148544_1_, p_148544_2_));
/*     */   }
/*     */   
/*     */   public void func_148539_a(IChatComponent p_148539_1_) {
/* 795 */     func_148544_a(p_148539_1_, true);
/*     */   }
/*     */   
/*     */   public StatisticsFile func_152602_a(EntityPlayer p_152602_1_) {
/* 799 */     UUID uUID = p_152602_1_.func_110124_au();
/* 800 */     StatisticsFile statisticsFile = (uUID == null) ? null : (StatisticsFile)this.field_148547_k.get(uUID);
/*     */     
/* 802 */     if (statisticsFile == null) {
/* 803 */       File file1 = new File(this.field_72400_f.func_71218_a(0).func_72860_G().func_75765_b(), "stats");
/* 804 */       File file2 = new File(file1, uUID.toString() + ".json");
/*     */       
/* 806 */       if (!file2.exists()) {
/*     */         
/* 808 */         File file = new File(file1, p_152602_1_.func_70005_c_() + ".json");
/* 809 */         if (file.exists() && file.isFile()) {
/* 810 */           file.renameTo(file2);
/*     */         }
/*     */       } 
/*     */       
/* 814 */       statisticsFile = new StatisticsFile(this.field_72400_f, file2);
/* 815 */       statisticsFile.func_150882_a();
/* 816 */       this.field_148547_k.put(uUID, statisticsFile);
/*     */     } 
/*     */     
/* 819 */     return statisticsFile;
/*     */   }
/*     */   
/*     */   public void func_152611_a(int p_152611_1_) {
/* 823 */     this.field_72402_d = p_152611_1_;
/* 824 */     if (this.field_72400_f.field_71305_c == null)
/*     */       return; 
/* 826 */     for (WorldServer worldServer : this.field_72400_f.field_71305_c) {
/* 827 */       if (worldServer != null)
/* 828 */         worldServer.func_73040_p().func_152622_a(p_152611_1_); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\server\management\ServerConfigurationManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */