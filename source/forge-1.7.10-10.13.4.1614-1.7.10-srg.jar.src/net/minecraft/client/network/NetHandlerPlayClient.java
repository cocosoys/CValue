/*      */ package net.minecraft.client.network;
/*      */ import io.netty.buffer.ByteBuf;
/*      */ import java.io.DataInputStream;
/*      */ import java.util.List;
/*      */ import net.minecraft.client.Minecraft;
/*      */ import net.minecraft.client.entity.EntityClientPlayerMP;
/*      */ import net.minecraft.client.entity.EntityOtherPlayerMP;
/*      */ import net.minecraft.client.entity.EntityPlayerSP;
/*      */ import net.minecraft.client.gui.GuiPlayerInfo;
/*      */ import net.minecraft.client.gui.GuiScreen;
/*      */ import net.minecraft.client.multiplayer.ServerData;
/*      */ import net.minecraft.client.particle.EntityCrit2FX;
/*      */ import net.minecraft.client.settings.GameSettings;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.EntityLivingBase;
/*      */ import net.minecraft.entity.ai.attributes.IAttributeInstance;
/*      */ import net.minecraft.entity.effect.EntityLightningBolt;
/*      */ import net.minecraft.entity.item.EntityFallingBlock;
/*      */ import net.minecraft.entity.item.EntityXPOrb;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.entity.projectile.EntityArrow;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.network.Packet;
/*      */ import net.minecraft.network.play.server.S01PacketJoinGame;
/*      */ import net.minecraft.network.play.server.S04PacketEntityEquipment;
/*      */ import net.minecraft.network.play.server.S05PacketSpawnPosition;
/*      */ import net.minecraft.network.play.server.S07PacketRespawn;
/*      */ import net.minecraft.network.play.server.S08PacketPlayerPosLook;
/*      */ import net.minecraft.network.play.server.S0APacketUseBed;
/*      */ import net.minecraft.network.play.server.S0BPacketAnimation;
/*      */ import net.minecraft.network.play.server.S0CPacketSpawnPlayer;
/*      */ import net.minecraft.network.play.server.S0DPacketCollectItem;
/*      */ import net.minecraft.network.play.server.S0EPacketSpawnObject;
/*      */ import net.minecraft.network.play.server.S0FPacketSpawnMob;
/*      */ import net.minecraft.network.play.server.S10PacketSpawnPainting;
/*      */ import net.minecraft.network.play.server.S11PacketSpawnExperienceOrb;
/*      */ import net.minecraft.network.play.server.S12PacketEntityVelocity;
/*      */ import net.minecraft.network.play.server.S14PacketEntity;
/*      */ import net.minecraft.network.play.server.S18PacketEntityTeleport;
/*      */ import net.minecraft.network.play.server.S1BPacketEntityAttach;
/*      */ import net.minecraft.network.play.server.S1DPacketEntityEffect;
/*      */ import net.minecraft.network.play.server.S20PacketEntityProperties;
/*      */ import net.minecraft.network.play.server.S21PacketChunkData;
/*      */ import net.minecraft.network.play.server.S22PacketMultiBlockChange;
/*      */ import net.minecraft.network.play.server.S23PacketBlockChange;
/*      */ import net.minecraft.network.play.server.S24PacketBlockAction;
/*      */ import net.minecraft.network.play.server.S25PacketBlockBreakAnim;
/*      */ import net.minecraft.network.play.server.S26PacketMapChunkBulk;
/*      */ import net.minecraft.network.play.server.S27PacketExplosion;
/*      */ import net.minecraft.network.play.server.S28PacketEffect;
/*      */ import net.minecraft.network.play.server.S29PacketSoundEffect;
/*      */ import net.minecraft.network.play.server.S2APacketParticles;
/*      */ import net.minecraft.network.play.server.S2BPacketChangeGameState;
/*      */ import net.minecraft.network.play.server.S2CPacketSpawnGlobalEntity;
/*      */ import net.minecraft.network.play.server.S2DPacketOpenWindow;
/*      */ import net.minecraft.network.play.server.S2FPacketSetSlot;
/*      */ import net.minecraft.network.play.server.S30PacketWindowItems;
/*      */ import net.minecraft.network.play.server.S31PacketWindowProperty;
/*      */ import net.minecraft.network.play.server.S32PacketConfirmTransaction;
/*      */ import net.minecraft.network.play.server.S33PacketUpdateSign;
/*      */ import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
/*      */ import net.minecraft.network.play.server.S36PacketSignEditorOpen;
/*      */ import net.minecraft.network.play.server.S38PacketPlayerListItem;
/*      */ import net.minecraft.network.play.server.S39PacketPlayerAbilities;
/*      */ import net.minecraft.network.play.server.S3BPacketScoreboardObjective;
/*      */ import net.minecraft.network.play.server.S3CPacketUpdateScore;
/*      */ import net.minecraft.network.play.server.S3DPacketDisplayScoreboard;
/*      */ import net.minecraft.network.play.server.S3EPacketTeams;
/*      */ import net.minecraft.network.play.server.S3FPacketCustomPayload;
/*      */ import net.minecraft.scoreboard.ScoreObjective;
/*      */ import net.minecraft.scoreboard.ScorePlayerTeam;
/*      */ import net.minecraft.scoreboard.Scoreboard;
/*      */ import net.minecraft.stats.StatBase;
/*      */ import net.minecraft.tileentity.TileEntity;
/*      */ import net.minecraft.tileentity.TileEntityBeacon;
/*      */ import net.minecraft.tileentity.TileEntityBrewingStand;
/*      */ import net.minecraft.tileentity.TileEntityDispenser;
/*      */ import net.minecraft.tileentity.TileEntityDropper;
/*      */ import net.minecraft.tileentity.TileEntityFurnace;
/*      */ import net.minecraft.tileentity.TileEntityHopper;
/*      */ import net.minecraft.tileentity.TileEntitySign;
/*      */ import net.minecraft.util.IChatComponent;
/*      */ import net.minecraft.util.MathHelper;
/*      */ import net.minecraft.world.Explosion;
/*      */ import net.minecraft.world.World;
/*      */ import net.minecraft.world.chunk.Chunk;
/*      */ 
/*      */ @SideOnly(Side.CLIENT)
/*      */ public class NetHandlerPlayClient implements INetHandlerPlayClient {
/*   90 */   private static final Logger field_147301_d = LogManager.getLogger();
/*      */   
/*      */   private final NetworkManager field_147302_e;
/*      */   private Minecraft field_147299_f;
/*      */   private WorldClient field_147300_g;
/*      */   private boolean field_147309_h;
/*   96 */   public MapStorage field_147305_a = new MapStorage(null);
/*   97 */   private Map field_147310_i = new HashMap<Object, Object>();
/*   98 */   public List field_147303_b = new ArrayList();
/*   99 */   public int field_147304_c = 20;
/*      */   
/*      */   private GuiScreen field_147307_j;
/*      */   private boolean field_147308_k = false;
/*  103 */   private Random field_147306_l = new Random(); private static final String __OBFID = "CL_00000878";
/*      */   
/*      */   public NetHandlerPlayClient(Minecraft p_i45061_1_, GuiScreen p_i45061_2_, NetworkManager p_i45061_3_) {
/*  106 */     this.field_147299_f = p_i45061_1_;
/*  107 */     this.field_147307_j = p_i45061_2_;
/*  108 */     this.field_147302_e = p_i45061_3_;
/*      */   }
/*      */   
/*      */   public void func_147296_c() {
/*  112 */     this.field_147300_g = null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_147233_a() {}
/*      */ 
/*      */   
/*      */   public void func_147282_a(S01PacketJoinGame p_147282_1_) {
/*  121 */     this.field_147299_f.field_71442_b = new PlayerControllerMP(this.field_147299_f, this);
/*      */     
/*  123 */     this.field_147300_g = new WorldClient(this, new WorldSettings(0L, p_147282_1_.func_149198_e(), false, p_147282_1_.func_149195_d(), p_147282_1_.func_149196_i()), p_147282_1_.func_149194_f(), p_147282_1_.func_149192_g(), this.field_147299_f.field_71424_I);
/*  124 */     this.field_147300_g.field_72995_K = true;
/*  125 */     this.field_147299_f.func_71403_a(this.field_147300_g);
/*  126 */     this.field_147299_f.field_71439_g.field_71093_bK = p_147282_1_.func_149194_f();
/*  127 */     this.field_147299_f.func_147108_a((GuiScreen)new GuiDownloadTerrain(this));
/*  128 */     this.field_147299_f.field_71439_g.func_145769_d(p_147282_1_.func_149197_c());
/*  129 */     this.field_147304_c = p_147282_1_.func_149193_h();
/*      */     
/*  131 */     this.field_147299_f.field_71442_b.func_78746_a(p_147282_1_.func_149198_e());
/*  132 */     this.field_147299_f.field_71474_y.func_82879_c();
/*  133 */     this.field_147302_e.func_150725_a((Packet)new C17PacketCustomPayload("MC|Brand", ClientBrandRetriever.getClientModName().getBytes(Charsets.UTF_8)), new io.netty.util.concurrent.GenericFutureListener[0]);
/*      */   }
/*      */   
/*      */   public void func_147235_a(S0EPacketSpawnObject p_147235_1_) {
/*      */     EntityFallingBlock entityFallingBlock;
/*  138 */     double d1 = p_147235_1_.func_148997_d() / 32.0D;
/*  139 */     double d2 = p_147235_1_.func_148998_e() / 32.0D;
/*  140 */     double d3 = p_147235_1_.func_148994_f() / 32.0D;
/*  141 */     EntityMinecart entityMinecart = null;
/*  142 */     if (p_147235_1_.func_148993_l() == 10)
/*  143 */     { entityMinecart = EntityMinecart.func_94090_a((World)this.field_147300_g, d1, d2, d3, p_147235_1_.func_149009_m()); }
/*  144 */     else if (p_147235_1_.func_148993_l() == 90)
/*  145 */     { Entity entity = this.field_147300_g.func_73045_a(p_147235_1_.func_149009_m());
/*  146 */       if (entity instanceof EntityPlayer) {
/*  147 */         EntityFishHook entityFishHook = new EntityFishHook((World)this.field_147300_g, d1, d2, d3, (EntityPlayer)entity);
/*      */       }
/*  149 */       p_147235_1_.func_149002_g(0); }
/*  150 */     else if (p_147235_1_.func_148993_l() == 60) { EntityArrow entityArrow = new EntityArrow((World)this.field_147300_g, d1, d2, d3); }
/*  151 */     else if (p_147235_1_.func_148993_l() == 61) { EntitySnowball entitySnowball = new EntitySnowball((World)this.field_147300_g, d1, d2, d3); }
/*  152 */     else if (p_147235_1_.func_148993_l() == 71)
/*  153 */     { EntityItemFrame entityItemFrame = new EntityItemFrame((World)this.field_147300_g, (int)d1, (int)d2, (int)d3, p_147235_1_.func_149009_m());
/*  154 */       p_147235_1_.func_149002_g(0); }
/*  155 */     else if (p_147235_1_.func_148993_l() == 77)
/*  156 */     { EntityLeashKnot entityLeashKnot = new EntityLeashKnot((World)this.field_147300_g, (int)d1, (int)d2, (int)d3);
/*  157 */       p_147235_1_.func_149002_g(0); }
/*  158 */     else if (p_147235_1_.func_148993_l() == 65)
/*  159 */     { EntityEnderPearl entityEnderPearl = new EntityEnderPearl((World)this.field_147300_g, d1, d2, d3); }
/*  160 */     else if (p_147235_1_.func_148993_l() == 72) { EntityEnderEye entityEnderEye = new EntityEnderEye((World)this.field_147300_g, d1, d2, d3); }
/*  161 */     else if (p_147235_1_.func_148993_l() == 76)
/*  162 */     { EntityFireworkRocket entityFireworkRocket = new EntityFireworkRocket((World)this.field_147300_g, d1, d2, d3, null); }
/*  163 */     else if (p_147235_1_.func_148993_l() == 63)
/*  164 */     { EntityLargeFireball entityLargeFireball = new EntityLargeFireball((World)this.field_147300_g, d1, d2, d3, p_147235_1_.func_149010_g() / 8000.0D, p_147235_1_.func_149004_h() / 8000.0D, p_147235_1_.func_148999_i() / 8000.0D);
/*  165 */       p_147235_1_.func_149002_g(0); }
/*  166 */     else if (p_147235_1_.func_148993_l() == 64)
/*  167 */     { EntitySmallFireball entitySmallFireball = new EntitySmallFireball((World)this.field_147300_g, d1, d2, d3, p_147235_1_.func_149010_g() / 8000.0D, p_147235_1_.func_149004_h() / 8000.0D, p_147235_1_.func_148999_i() / 8000.0D);
/*  168 */       p_147235_1_.func_149002_g(0); }
/*  169 */     else if (p_147235_1_.func_148993_l() == 66)
/*  170 */     { EntityWitherSkull entityWitherSkull = new EntityWitherSkull((World)this.field_147300_g, d1, d2, d3, p_147235_1_.func_149010_g() / 8000.0D, p_147235_1_.func_149004_h() / 8000.0D, p_147235_1_.func_148999_i() / 8000.0D);
/*  171 */       p_147235_1_.func_149002_g(0); }
/*  172 */     else if (p_147235_1_.func_148993_l() == 62) { EntityEgg entityEgg = new EntityEgg((World)this.field_147300_g, d1, d2, d3); }
/*  173 */     else if (p_147235_1_.func_148993_l() == 73)
/*  174 */     { EntityPotion entityPotion = new EntityPotion((World)this.field_147300_g, d1, d2, d3, p_147235_1_.func_149009_m());
/*  175 */       p_147235_1_.func_149002_g(0); }
/*  176 */     else if (p_147235_1_.func_148993_l() == 75)
/*  177 */     { EntityExpBottle entityExpBottle = new EntityExpBottle((World)this.field_147300_g, d1, d2, d3);
/*  178 */       p_147235_1_.func_149002_g(0); }
/*  179 */     else if (p_147235_1_.func_148993_l() == 1) { EntityBoat entityBoat = new EntityBoat((World)this.field_147300_g, d1, d2, d3); }
/*  180 */     else if (p_147235_1_.func_148993_l() == 50) { EntityTNTPrimed entityTNTPrimed = new EntityTNTPrimed((World)this.field_147300_g, d1, d2, d3, null); }
/*  181 */     else if (p_147235_1_.func_148993_l() == 51) { EntityEnderCrystal entityEnderCrystal = new EntityEnderCrystal((World)this.field_147300_g, d1, d2, d3); }
/*  182 */     else if (p_147235_1_.func_148993_l() == 2) { EntityItem entityItem = new EntityItem((World)this.field_147300_g, d1, d2, d3); }
/*  183 */     else if (p_147235_1_.func_148993_l() == 70)
/*  184 */     { entityFallingBlock = new EntityFallingBlock((World)this.field_147300_g, d1, d2, d3, Block.func_149729_e(p_147235_1_.func_149009_m() & 0xFFFF), p_147235_1_.func_149009_m() >> 16);
/*  185 */       p_147235_1_.func_149002_g(0); }
/*      */ 
/*      */     
/*  188 */     if (entityFallingBlock != null) {
/*  189 */       ((Entity)entityFallingBlock).field_70118_ct = p_147235_1_.func_148997_d();
/*  190 */       ((Entity)entityFallingBlock).field_70117_cu = p_147235_1_.func_148998_e();
/*  191 */       ((Entity)entityFallingBlock).field_70116_cv = p_147235_1_.func_148994_f();
/*  192 */       ((Entity)entityFallingBlock).field_70125_A = (p_147235_1_.func_149008_j() * 360) / 256.0F;
/*  193 */       ((Entity)entityFallingBlock).field_70177_z = (p_147235_1_.func_149006_k() * 360) / 256.0F;
/*  194 */       Entity[] arrayOfEntity = entityFallingBlock.func_70021_al();
/*  195 */       if (arrayOfEntity != null) {
/*  196 */         int i = p_147235_1_.func_149001_c() - entityFallingBlock.func_145782_y();
/*  197 */         for (byte b = 0; b < arrayOfEntity.length; b++) {
/*  198 */           arrayOfEntity[b].func_145769_d(arrayOfEntity[b].func_145782_y() + i);
/*      */         }
/*      */       } 
/*  201 */       entityFallingBlock.func_145769_d(p_147235_1_.func_149001_c());
/*  202 */       this.field_147300_g.func_73027_a(p_147235_1_.func_149001_c(), (Entity)entityFallingBlock);
/*  203 */       if (p_147235_1_.func_149009_m() > 0) {
/*  204 */         if (p_147235_1_.func_148993_l() == 60) {
/*  205 */           Entity entity = this.field_147300_g.func_73045_a(p_147235_1_.func_149009_m());
/*  206 */           if (entity instanceof EntityLivingBase) {
/*  207 */             EntityArrow entityArrow = (EntityArrow)entityFallingBlock;
/*  208 */             entityArrow.field_70250_c = entity;
/*      */           } 
/*      */         } 
/*      */         
/*  212 */         entityFallingBlock.func_70016_h(p_147235_1_.func_149010_g() / 8000.0D, p_147235_1_.func_149004_h() / 8000.0D, p_147235_1_.func_148999_i() / 8000.0D);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147286_a(S11PacketSpawnExperienceOrb p_147286_1_) {
/*  219 */     EntityXPOrb entityXPOrb = new EntityXPOrb((World)this.field_147300_g, p_147286_1_.func_148984_d(), p_147286_1_.func_148983_e(), p_147286_1_.func_148982_f(), p_147286_1_.func_148986_g());
/*  220 */     ((Entity)entityXPOrb).field_70118_ct = p_147286_1_.func_148984_d();
/*  221 */     ((Entity)entityXPOrb).field_70117_cu = p_147286_1_.func_148983_e();
/*  222 */     ((Entity)entityXPOrb).field_70116_cv = p_147286_1_.func_148982_f();
/*  223 */     ((Entity)entityXPOrb).field_70177_z = 0.0F;
/*  224 */     ((Entity)entityXPOrb).field_70125_A = 0.0F;
/*  225 */     entityXPOrb.func_145769_d(p_147286_1_.func_148985_c());
/*  226 */     this.field_147300_g.func_73027_a(p_147286_1_.func_148985_c(), (Entity)entityXPOrb);
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147292_a(S2CPacketSpawnGlobalEntity p_147292_1_) {
/*  231 */     double d1 = p_147292_1_.func_149051_d() / 32.0D;
/*  232 */     double d2 = p_147292_1_.func_149050_e() / 32.0D;
/*  233 */     double d3 = p_147292_1_.func_149049_f() / 32.0D;
/*  234 */     EntityLightningBolt entityLightningBolt = null;
/*  235 */     if (p_147292_1_.func_149053_g() == 1) entityLightningBolt = new EntityLightningBolt((World)this.field_147300_g, d1, d2, d3); 
/*  236 */     if (entityLightningBolt != null) {
/*  237 */       ((Entity)entityLightningBolt).field_70118_ct = p_147292_1_.func_149051_d();
/*  238 */       ((Entity)entityLightningBolt).field_70117_cu = p_147292_1_.func_149050_e();
/*  239 */       ((Entity)entityLightningBolt).field_70116_cv = p_147292_1_.func_149049_f();
/*  240 */       ((Entity)entityLightningBolt).field_70177_z = 0.0F;
/*  241 */       ((Entity)entityLightningBolt).field_70125_A = 0.0F;
/*  242 */       entityLightningBolt.func_145769_d(p_147292_1_.func_149052_c());
/*  243 */       this.field_147300_g.func_72942_c((Entity)entityLightningBolt);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147288_a(S10PacketSpawnPainting p_147288_1_) {
/*  249 */     EntityPainting entityPainting = new EntityPainting((World)this.field_147300_g, p_147288_1_.func_148964_d(), p_147288_1_.func_148963_e(), p_147288_1_.func_148962_f(), p_147288_1_.func_148966_g(), p_147288_1_.func_148961_h());
/*  250 */     this.field_147300_g.func_73027_a(p_147288_1_.func_148965_c(), (Entity)entityPainting);
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147244_a(S12PacketEntityVelocity p_147244_1_) {
/*  255 */     Entity entity = this.field_147300_g.func_73045_a(p_147244_1_.func_149412_c());
/*  256 */     if (entity == null)
/*  257 */       return;  entity.func_70016_h(p_147244_1_.func_149411_d() / 8000.0D, p_147244_1_.func_149410_e() / 8000.0D, p_147244_1_.func_149409_f() / 8000.0D);
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147284_a(S1CPacketEntityMetadata p_147284_1_) {
/*  262 */     Entity entity = this.field_147300_g.func_73045_a(p_147284_1_.func_149375_d());
/*  263 */     if (entity != null && p_147284_1_.func_149376_c() != null) {
/*  264 */       entity.func_70096_w().func_75687_a(p_147284_1_.func_149376_c());
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147237_a(S0CPacketSpawnPlayer p_147237_1_) {
/*  270 */     double d1 = p_147237_1_.func_148942_f() / 32.0D;
/*  271 */     double d2 = p_147237_1_.func_148949_g() / 32.0D;
/*  272 */     double d3 = p_147237_1_.func_148946_h() / 32.0D;
/*  273 */     float f1 = (p_147237_1_.func_148941_i() * 360) / 256.0F;
/*  274 */     float f2 = (p_147237_1_.func_148945_j() * 360) / 256.0F;
/*  275 */     GameProfile gameProfile = p_147237_1_.func_148948_e();
/*      */     
/*  277 */     EntityOtherPlayerMP entityOtherPlayerMP = new EntityOtherPlayerMP((World)this.field_147299_f.field_71441_e, p_147237_1_.func_148948_e());
/*  278 */     entityOtherPlayerMP.field_70169_q = entityOtherPlayerMP.field_70142_S = (entityOtherPlayerMP.field_70118_ct = p_147237_1_.func_148942_f());
/*  279 */     entityOtherPlayerMP.field_70167_r = entityOtherPlayerMP.field_70137_T = (entityOtherPlayerMP.field_70117_cu = p_147237_1_.func_148949_g());
/*  280 */     entityOtherPlayerMP.field_70166_s = entityOtherPlayerMP.field_70136_U = (entityOtherPlayerMP.field_70116_cv = p_147237_1_.func_148946_h());
/*      */     
/*  282 */     int i = p_147237_1_.func_148947_k();
/*  283 */     if (i == 0) {
/*  284 */       entityOtherPlayerMP.field_71071_by.field_70462_a[entityOtherPlayerMP.field_71071_by.field_70461_c] = null;
/*      */     } else {
/*  286 */       entityOtherPlayerMP.field_71071_by.field_70462_a[entityOtherPlayerMP.field_71071_by.field_70461_c] = new ItemStack(Item.func_150899_d(i), 1, 0);
/*      */     } 
/*  288 */     entityOtherPlayerMP.func_70080_a(d1, d2, d3, f1, f2);
/*  289 */     this.field_147300_g.func_73027_a(p_147237_1_.func_148943_d(), (Entity)entityOtherPlayerMP);
/*      */     
/*  291 */     List list = p_147237_1_.func_148944_c();
/*  292 */     if (list != null) {
/*  293 */       entityOtherPlayerMP.func_70096_w().func_75687_a(list);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147275_a(S18PacketEntityTeleport p_147275_1_) {
/*  299 */     Entity entity = this.field_147300_g.func_73045_a(p_147275_1_.func_149451_c());
/*  300 */     if (entity == null)
/*  301 */       return;  entity.field_70118_ct = p_147275_1_.func_149449_d();
/*  302 */     entity.field_70117_cu = p_147275_1_.func_149448_e();
/*  303 */     entity.field_70116_cv = p_147275_1_.func_149446_f();
/*  304 */     double d1 = entity.field_70118_ct / 32.0D;
/*  305 */     double d2 = entity.field_70117_cu / 32.0D + 0.015625D;
/*  306 */     double d3 = entity.field_70116_cv / 32.0D;
/*  307 */     float f1 = (p_147275_1_.func_149450_g() * 360) / 256.0F;
/*  308 */     float f2 = (p_147275_1_.func_149447_h() * 360) / 256.0F;
/*  309 */     entity.func_70056_a(d1, d2, d3, f1, f2, 3);
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147257_a(S09PacketHeldItemChange p_147257_1_) {
/*  314 */     if (p_147257_1_.func_149385_c() >= 0 && p_147257_1_.func_149385_c() < InventoryPlayer.func_70451_h()) {
/*  315 */       this.field_147299_f.field_71439_g.field_71071_by.field_70461_c = p_147257_1_.func_149385_c();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147259_a(S14PacketEntity p_147259_1_) {
/*  321 */     Entity entity = p_147259_1_.func_149065_a((World)this.field_147300_g);
/*  322 */     if (entity == null)
/*  323 */       return;  entity.field_70118_ct += p_147259_1_.func_149062_c();
/*  324 */     entity.field_70117_cu += p_147259_1_.func_149061_d();
/*  325 */     entity.field_70116_cv += p_147259_1_.func_149064_e();
/*  326 */     double d1 = entity.field_70118_ct / 32.0D;
/*  327 */     double d2 = entity.field_70117_cu / 32.0D;
/*  328 */     double d3 = entity.field_70116_cv / 32.0D;
/*  329 */     float f1 = p_147259_1_.func_149060_h() ? ((p_147259_1_.func_149066_f() * 360) / 256.0F) : entity.field_70177_z;
/*  330 */     float f2 = p_147259_1_.func_149060_h() ? ((p_147259_1_.func_149063_g() * 360) / 256.0F) : entity.field_70125_A;
/*  331 */     entity.func_70056_a(d1, d2, d3, f1, f2, 3);
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147267_a(S19PacketEntityHeadLook p_147267_1_) {
/*  336 */     Entity entity = p_147267_1_.func_149381_a((World)this.field_147300_g);
/*  337 */     if (entity == null)
/*  338 */       return;  float f = (p_147267_1_.func_149380_c() * 360) / 256.0F;
/*  339 */     entity.func_70034_d(f);
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147238_a(S13PacketDestroyEntities p_147238_1_) {
/*  344 */     for (byte b = 0; b < (p_147238_1_.func_149098_c()).length; b++) {
/*  345 */       this.field_147300_g.func_73028_b(p_147238_1_.func_149098_c()[b]);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147258_a(S08PacketPlayerPosLook p_147258_1_) {
/*  351 */     EntityClientPlayerMP entityClientPlayerMP = this.field_147299_f.field_71439_g;
/*      */     
/*  353 */     double d1 = p_147258_1_.func_148932_c();
/*  354 */     double d2 = p_147258_1_.func_148928_d();
/*  355 */     double d3 = p_147258_1_.func_148933_e();
/*  356 */     float f1 = p_147258_1_.func_148931_f();
/*  357 */     float f2 = p_147258_1_.func_148930_g();
/*      */     
/*  359 */     ((EntityPlayer)entityClientPlayerMP).field_70139_V = 0.0F;
/*  360 */     ((EntityPlayer)entityClientPlayerMP).field_70159_w = ((EntityPlayer)entityClientPlayerMP).field_70181_x = ((EntityPlayer)entityClientPlayerMP).field_70179_y = 0.0D;
/*  361 */     entityClientPlayerMP.func_70080_a(d1, d2, d3, f1, f2);
/*      */     
/*  363 */     this.field_147302_e.func_150725_a((Packet)new C03PacketPlayer.C06PacketPlayerPosLook(((EntityPlayer)entityClientPlayerMP).field_70165_t, ((EntityPlayer)entityClientPlayerMP).field_70121_D.field_72338_b, ((EntityPlayer)entityClientPlayerMP).field_70163_u, ((EntityPlayer)entityClientPlayerMP).field_70161_v, p_147258_1_.func_148931_f(), p_147258_1_.func_148930_g(), p_147258_1_.func_148929_h()), new io.netty.util.concurrent.GenericFutureListener[0]);
/*      */     
/*  365 */     if (!this.field_147309_h) {
/*  366 */       this.field_147299_f.field_71439_g.field_70169_q = this.field_147299_f.field_71439_g.field_70165_t;
/*  367 */       this.field_147299_f.field_71439_g.field_70167_r = this.field_147299_f.field_71439_g.field_70163_u;
/*  368 */       this.field_147299_f.field_71439_g.field_70166_s = this.field_147299_f.field_71439_g.field_70161_v;
/*  369 */       this.field_147309_h = true;
/*  370 */       this.field_147299_f.func_147108_a(null);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147287_a(S22PacketMultiBlockChange p_147287_1_) {
/*  376 */     int i = (p_147287_1_.func_148920_c()).field_77276_a * 16;
/*  377 */     int j = (p_147287_1_.func_148920_c()).field_77275_b * 16;
/*  378 */     if (p_147287_1_.func_148921_d() == null) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/*  383 */     DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(p_147287_1_.func_148921_d()));
/*      */     
/*      */     try {
/*  386 */       for (byte b = 0; b < p_147287_1_.func_148922_e(); b++) {
/*  387 */         short s1 = dataInputStream.readShort();
/*  388 */         short s2 = dataInputStream.readShort();
/*  389 */         int k = s2 >> 4 & 0xFFF;
/*  390 */         int m = s2 & 0xF;
/*      */         
/*  392 */         int n = s1 >> 12 & 0xF;
/*  393 */         int i1 = s1 >> 8 & 0xF;
/*  394 */         int i2 = s1 & 0xFF;
/*      */         
/*  396 */         this.field_147300_g.func_147492_c(n + i, i2, i1 + j, Block.func_149729_e(k), m);
/*      */       } 
/*  398 */     } catch (IOException iOException) {}
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_147263_a(S21PacketChunkData p_147263_1_) {
/*  404 */     if (p_147263_1_.func_149274_i()) {
/*  405 */       if (p_147263_1_.func_149276_g() != 0) {
/*  406 */         this.field_147300_g.func_73025_a(p_147263_1_.func_149273_e(), p_147263_1_.func_149271_f(), true);
/*      */       } else {
/*  408 */         this.field_147300_g.func_73025_a(p_147263_1_.func_149273_e(), p_147263_1_.func_149271_f(), false);
/*      */         
/*      */         return;
/*      */       } 
/*      */     }
/*  413 */     this.field_147300_g.func_73031_a(p_147263_1_.func_149273_e() << 4, 0, p_147263_1_.func_149271_f() << 4, (p_147263_1_.func_149273_e() << 4) + 15, 256, (p_147263_1_.func_149271_f() << 4) + 15);
/*      */     
/*  415 */     Chunk chunk = this.field_147300_g.func_72964_e(p_147263_1_.func_149273_e(), p_147263_1_.func_149271_f());
/*      */     
/*  417 */     chunk.func_76607_a(p_147263_1_.func_149272_d(), p_147263_1_.func_149276_g(), p_147263_1_.func_149270_h(), p_147263_1_.func_149274_i());
/*  418 */     this.field_147300_g.func_147458_c(p_147263_1_.func_149273_e() << 4, 0, p_147263_1_.func_149271_f() << 4, (p_147263_1_.func_149273_e() << 4) + 15, 256, (p_147263_1_.func_149271_f() << 4) + 15);
/*      */     
/*  420 */     if (!p_147263_1_.func_149274_i() || !(this.field_147300_g.field_73011_w instanceof net.minecraft.world.WorldProviderSurface)) {
/*  421 */       chunk.func_76613_n();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147234_a(S23PacketBlockChange p_147234_1_) {
/*  427 */     this.field_147300_g.func_147492_c(p_147234_1_.func_148879_d(), p_147234_1_.func_148878_e(), p_147234_1_.func_148877_f(), p_147234_1_.func_148880_c(), p_147234_1_.func_148881_g());
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147253_a(S40PacketDisconnect p_147253_1_) {
/*  432 */     this.field_147302_e.func_150718_a(p_147253_1_.func_149165_c());
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147231_a(IChatComponent p_147231_1_) {
/*  437 */     this.field_147299_f.func_71403_a(null);
/*  438 */     if (this.field_147307_j != null) {
/*  439 */       if (this.field_147307_j instanceof GuiScreenRealmsProxy) {
/*  440 */         this.field_147299_f.func_147108_a((GuiScreen)(new DisconnectedOnlineScreen(((GuiScreenRealmsProxy)this.field_147307_j).func_154321_a(), "disconnect.lost", p_147231_1_)).getProxy());
/*      */       } else {
/*  442 */         this.field_147299_f.func_147108_a((GuiScreen)new GuiDisconnected(this.field_147307_j, "disconnect.lost", p_147231_1_));
/*      */       } 
/*      */     } else {
/*  445 */       this.field_147299_f.func_147108_a((GuiScreen)new GuiDisconnected((GuiScreen)new GuiMultiplayer((GuiScreen)new GuiMainMenu()), "disconnect.lost", p_147231_1_));
/*      */     } 
/*      */   }
/*      */   
/*      */   public void func_147297_a(Packet p_147297_1_) {
/*  450 */     this.field_147302_e.func_150725_a(p_147297_1_, new io.netty.util.concurrent.GenericFutureListener[0]);
/*      */   }
/*      */   
/*      */   public void func_147246_a(S0DPacketCollectItem p_147246_1_) {
/*      */     EntityClientPlayerMP entityClientPlayerMP;
/*  455 */     Entity entity = this.field_147300_g.func_73045_a(p_147246_1_.func_149354_c());
/*  456 */     EntityLivingBase entityLivingBase = (EntityLivingBase)this.field_147300_g.func_73045_a(p_147246_1_.func_149353_d());
/*  457 */     if (entityLivingBase == null) {
/*  458 */       entityClientPlayerMP = this.field_147299_f.field_71439_g;
/*      */     }
/*  460 */     if (entity != null) {
/*  461 */       if (entity instanceof EntityXPOrb) {
/*  462 */         this.field_147300_g.func_72956_a(entity, "random.orb", 0.2F, ((this.field_147306_l.nextFloat() - this.field_147306_l.nextFloat()) * 0.7F + 1.0F) * 2.0F);
/*      */       } else {
/*  464 */         this.field_147300_g.func_72956_a(entity, "random.pop", 0.2F, ((this.field_147306_l.nextFloat() - this.field_147306_l.nextFloat()) * 0.7F + 1.0F) * 2.0F);
/*      */       } 
/*      */       
/*  467 */       this.field_147299_f.field_71452_i.func_78873_a((EntityFX)new EntityPickupFX((World)this.field_147299_f.field_71441_e, entity, (Entity)entityClientPlayerMP, -0.5F));
/*  468 */       this.field_147300_g.func_73028_b(p_147246_1_.func_149354_c());
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147251_a(S02PacketChat p_147251_1_) {
/*  474 */     this.field_147299_f.field_71456_v.func_146158_b().func_146227_a(p_147251_1_.func_148915_c());
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147279_a(S0BPacketAnimation p_147279_1_) {
/*  479 */     Entity entity = this.field_147300_g.func_73045_a(p_147279_1_.func_148978_c());
/*  480 */     if (entity == null)
/*  481 */       return;  if (p_147279_1_.func_148977_d() == 0) {
/*  482 */       EntityLivingBase entityLivingBase = (EntityLivingBase)entity;
/*  483 */       entityLivingBase.func_71038_i();
/*  484 */     } else if (p_147279_1_.func_148977_d() == 1) {
/*  485 */       entity.func_70057_ab();
/*  486 */     } else if (p_147279_1_.func_148977_d() == 2) {
/*  487 */       EntityPlayer entityPlayer = (EntityPlayer)entity;
/*  488 */       entityPlayer.func_70999_a(false, false, false);
/*  489 */     } else if (p_147279_1_.func_148977_d() == 4) {
/*  490 */       this.field_147299_f.field_71452_i.func_78873_a((EntityFX)new EntityCrit2FX((World)this.field_147299_f.field_71441_e, entity));
/*  491 */     } else if (p_147279_1_.func_148977_d() == 5) {
/*  492 */       EntityCrit2FX entityCrit2FX = new EntityCrit2FX((World)this.field_147299_f.field_71441_e, entity, "magicCrit");
/*  493 */       this.field_147299_f.field_71452_i.func_78873_a((EntityFX)entityCrit2FX);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147278_a(S0APacketUseBed p_147278_1_) {
/*  499 */     p_147278_1_.func_149091_a((World)this.field_147300_g).func_71018_a(p_147278_1_.func_149092_c(), p_147278_1_.func_149090_d(), p_147278_1_.func_149089_e());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_147281_a(S0FPacketSpawnMob p_147281_1_) {
/*  508 */     double d1 = p_147281_1_.func_149023_f() / 32.0D;
/*  509 */     double d2 = p_147281_1_.func_149034_g() / 32.0D;
/*  510 */     double d3 = p_147281_1_.func_149029_h() / 32.0D;
/*  511 */     float f1 = (p_147281_1_.func_149028_l() * 360) / 256.0F;
/*  512 */     float f2 = (p_147281_1_.func_149030_m() * 360) / 256.0F;
/*  513 */     EntityLivingBase entityLivingBase = (EntityLivingBase)EntityList.func_75616_a(p_147281_1_.func_149025_e(), (World)this.field_147299_f.field_71441_e);
/*  514 */     entityLivingBase.field_70118_ct = p_147281_1_.func_149023_f();
/*  515 */     entityLivingBase.field_70117_cu = p_147281_1_.func_149034_g();
/*  516 */     entityLivingBase.field_70116_cv = p_147281_1_.func_149029_h();
/*  517 */     entityLivingBase.field_70759_as = (p_147281_1_.func_149032_n() * 360) / 256.0F;
/*  518 */     Entity[] arrayOfEntity = entityLivingBase.func_70021_al();
/*  519 */     if (arrayOfEntity != null) {
/*  520 */       int i = p_147281_1_.func_149024_d() - entityLivingBase.func_145782_y();
/*  521 */       for (byte b = 0; b < arrayOfEntity.length; b++) {
/*  522 */         arrayOfEntity[b].func_145769_d(arrayOfEntity[b].func_145782_y() + i);
/*      */       }
/*      */     } 
/*      */     
/*  526 */     entityLivingBase.func_145769_d(p_147281_1_.func_149024_d());
/*  527 */     entityLivingBase.func_70080_a(d1, d2, d3, f1, f2);
/*  528 */     entityLivingBase.field_70159_w = (p_147281_1_.func_149026_i() / 8000.0F);
/*  529 */     entityLivingBase.field_70181_x = (p_147281_1_.func_149033_j() / 8000.0F);
/*  530 */     entityLivingBase.field_70179_y = (p_147281_1_.func_149031_k() / 8000.0F);
/*  531 */     this.field_147300_g.func_73027_a(p_147281_1_.func_149024_d(), (Entity)entityLivingBase);
/*      */     
/*  533 */     List list = p_147281_1_.func_149027_c();
/*  534 */     if (list != null) {
/*  535 */       entityLivingBase.func_70096_w().func_75687_a(list);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147285_a(S03PacketTimeUpdate p_147285_1_) {
/*  541 */     this.field_147299_f.field_71441_e.func_82738_a(p_147285_1_.func_149366_c());
/*  542 */     this.field_147299_f.field_71441_e.func_72877_b(p_147285_1_.func_149365_d());
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147271_a(S05PacketSpawnPosition p_147271_1_) {
/*  547 */     this.field_147299_f.field_71439_g.func_71063_a(new ChunkCoordinates(p_147271_1_.func_149360_c(), p_147271_1_.func_149359_d(), p_147271_1_.func_149358_e()), true);
/*  548 */     this.field_147299_f.field_71441_e.func_72912_H().func_76081_a(p_147271_1_.func_149360_c(), p_147271_1_.func_149359_d(), p_147271_1_.func_149358_e());
/*      */   }
/*      */   
/*      */   public void func_147243_a(S1BPacketEntityAttach p_147243_1_) {
/*      */     EntityClientPlayerMP entityClientPlayerMP;
/*  553 */     Entity entity1 = this.field_147300_g.func_73045_a(p_147243_1_.func_149403_d());
/*  554 */     Entity entity2 = this.field_147300_g.func_73045_a(p_147243_1_.func_149402_e());
/*      */     
/*  556 */     if (p_147243_1_.func_149404_c() == 0) {
/*  557 */       boolean bool = false;
/*  558 */       if (p_147243_1_.func_149403_d() == this.field_147299_f.field_71439_g.func_145782_y()) {
/*  559 */         entityClientPlayerMP = this.field_147299_f.field_71439_g;
/*      */         
/*  561 */         if (entity2 instanceof EntityBoat) ((EntityBoat)entity2).func_70270_d(false);
/*      */         
/*  563 */         bool = (((Entity)entityClientPlayerMP).field_70154_o == null && entity2 != null) ? true : false;
/*  564 */       } else if (entity2 instanceof EntityBoat) {
/*  565 */         ((EntityBoat)entity2).func_70270_d(true);
/*      */       } 
/*      */       
/*  568 */       if (entityClientPlayerMP == null)
/*      */         return; 
/*  570 */       entityClientPlayerMP.func_70078_a(entity2);
/*      */       
/*  572 */       if (bool) {
/*  573 */         GameSettings gameSettings = this.field_147299_f.field_71474_y;
/*  574 */         this.field_147299_f.field_71456_v.func_110326_a(I18n.func_135052_a("mount.onboard", new Object[] { GameSettings.func_74298_c(gameSettings.field_74311_E.func_151463_i()) }), false);
/*      */       } 
/*  576 */     } else if (p_147243_1_.func_149404_c() == 1 && 
/*  577 */       entityClientPlayerMP != null && entityClientPlayerMP instanceof EntityLiving) {
/*  578 */       if (entity2 != null) {
/*  579 */         ((EntityLiving)entityClientPlayerMP).func_110162_b(entity2, false);
/*      */       } else {
/*  581 */         ((EntityLiving)entityClientPlayerMP).func_110160_i(false, false);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_147236_a(S19PacketEntityStatus p_147236_1_) {
/*  589 */     Entity entity = p_147236_1_.func_149161_a((World)this.field_147300_g);
/*  590 */     if (entity != null) entity.func_70103_a(p_147236_1_.func_149160_c());
/*      */   
/*      */   }
/*      */   
/*      */   public void func_147249_a(S06PacketUpdateHealth p_147249_1_) {
/*  595 */     this.field_147299_f.field_71439_g.func_71150_b(p_147249_1_.func_149332_c());
/*  596 */     this.field_147299_f.field_71439_g.func_71024_bL().func_75114_a(p_147249_1_.func_149330_d());
/*  597 */     this.field_147299_f.field_71439_g.func_71024_bL().func_75119_b(p_147249_1_.func_149331_e());
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147295_a(S1FPacketSetExperience p_147295_1_) {
/*  602 */     this.field_147299_f.field_71439_g.func_71152_a(p_147295_1_.func_149397_c(), p_147295_1_.func_149396_d(), p_147295_1_.func_149395_e());
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147280_a(S07PacketRespawn p_147280_1_) {
/*  607 */     if (p_147280_1_.func_149082_c() != this.field_147299_f.field_71439_g.field_71093_bK) {
/*  608 */       this.field_147309_h = false;
/*  609 */       Scoreboard scoreboard = this.field_147300_g.func_96441_U();
/*  610 */       this.field_147300_g = new WorldClient(this, new WorldSettings(0L, p_147280_1_.func_149083_e(), false, this.field_147299_f.field_71441_e.func_72912_H().func_76093_s(), p_147280_1_.func_149080_f()), p_147280_1_.func_149082_c(), p_147280_1_.func_149081_d(), this.field_147299_f.field_71424_I);
/*  611 */       this.field_147300_g.func_96443_a(scoreboard);
/*  612 */       this.field_147300_g.field_72995_K = true;
/*  613 */       this.field_147299_f.func_71403_a(this.field_147300_g);
/*  614 */       this.field_147299_f.field_71439_g.field_71093_bK = p_147280_1_.func_149082_c();
/*  615 */       this.field_147299_f.func_147108_a((GuiScreen)new GuiDownloadTerrain(this));
/*      */     } 
/*      */     
/*  618 */     this.field_147299_f.func_71354_a(p_147280_1_.func_149082_c());
/*  619 */     this.field_147299_f.field_71442_b.func_78746_a(p_147280_1_.func_149083_e());
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147283_a(S27PacketExplosion p_147283_1_) {
/*  624 */     Explosion explosion = new Explosion((World)this.field_147299_f.field_71441_e, null, p_147283_1_.func_149148_f(), p_147283_1_.func_149143_g(), p_147283_1_.func_149145_h(), p_147283_1_.func_149146_i());
/*  625 */     explosion.field_77281_g = p_147283_1_.func_149150_j();
/*  626 */     explosion.func_77279_a(true);
/*      */     
/*  628 */     this.field_147299_f.field_71439_g.field_70159_w += p_147283_1_.func_149149_c();
/*  629 */     this.field_147299_f.field_71439_g.field_70181_x += p_147283_1_.func_149144_d();
/*  630 */     this.field_147299_f.field_71439_g.field_70179_y += p_147283_1_.func_149147_e(); } public void func_147265_a(S2DPacketOpenWindow p_147265_1_) { TileEntityHopper tileEntityHopper; TileEntityFurnace tileEntityFurnace; TileEntityBrewingStand tileEntityBrewingStand;
/*      */     TileEntityDropper tileEntityDropper;
/*      */     TileEntityDispenser tileEntityDispenser;
/*      */     TileEntityBeacon tileEntityBeacon;
/*      */     Entity entity;
/*  635 */     EntityClientPlayerMP entityClientPlayerMP = this.field_147299_f.field_71439_g;
/*  636 */     switch (p_147265_1_.func_148899_d()) {
/*      */       case 0:
/*  638 */         entityClientPlayerMP.func_71007_a((IInventory)new InventoryBasic(p_147265_1_.func_148902_e(), p_147265_1_.func_148900_g(), p_147265_1_.func_148898_f()));
/*  639 */         ((EntityPlayerSP)entityClientPlayerMP).field_71070_bA.field_75152_c = p_147265_1_.func_148901_c();
/*      */         break;
/*      */       case 9:
/*  642 */         tileEntityHopper = new TileEntityHopper();
/*  643 */         if (p_147265_1_.func_148900_g()) tileEntityHopper.func_145886_a(p_147265_1_.func_148902_e()); 
/*  644 */         entityClientPlayerMP.func_146093_a(tileEntityHopper);
/*  645 */         ((EntityPlayerSP)entityClientPlayerMP).field_71070_bA.field_75152_c = p_147265_1_.func_148901_c();
/*      */         break;
/*      */       case 2:
/*  648 */         tileEntityFurnace = new TileEntityFurnace();
/*  649 */         if (p_147265_1_.func_148900_g()) tileEntityFurnace.func_145951_a(p_147265_1_.func_148902_e()); 
/*  650 */         entityClientPlayerMP.func_146101_a(tileEntityFurnace);
/*  651 */         ((EntityPlayerSP)entityClientPlayerMP).field_71070_bA.field_75152_c = p_147265_1_.func_148901_c();
/*      */         break;
/*      */       case 5:
/*  654 */         tileEntityBrewingStand = new TileEntityBrewingStand();
/*  655 */         if (p_147265_1_.func_148900_g()) tileEntityBrewingStand.func_145937_a(p_147265_1_.func_148902_e()); 
/*  656 */         entityClientPlayerMP.func_146098_a(tileEntityBrewingStand);
/*  657 */         ((EntityPlayerSP)entityClientPlayerMP).field_71070_bA.field_75152_c = p_147265_1_.func_148901_c();
/*      */         break;
/*      */       case 10:
/*  660 */         tileEntityDropper = new TileEntityDropper();
/*  661 */         if (p_147265_1_.func_148900_g()) tileEntityDropper.func_146018_a(p_147265_1_.func_148902_e()); 
/*  662 */         entityClientPlayerMP.func_146102_a((TileEntityDispenser)tileEntityDropper);
/*  663 */         ((EntityPlayerSP)entityClientPlayerMP).field_71070_bA.field_75152_c = p_147265_1_.func_148901_c();
/*      */         break;
/*      */       case 3:
/*  666 */         tileEntityDispenser = new TileEntityDispenser();
/*  667 */         if (p_147265_1_.func_148900_g()) tileEntityDispenser.func_146018_a(p_147265_1_.func_148902_e()); 
/*  668 */         entityClientPlayerMP.func_146102_a(tileEntityDispenser);
/*  669 */         ((EntityPlayerSP)entityClientPlayerMP).field_71070_bA.field_75152_c = p_147265_1_.func_148901_c();
/*      */         break;
/*      */       case 1:
/*  672 */         entityClientPlayerMP.func_71058_b(MathHelper.func_76128_c(((EntityPlayerSP)entityClientPlayerMP).field_70165_t), MathHelper.func_76128_c(((EntityPlayerSP)entityClientPlayerMP).field_70163_u), MathHelper.func_76128_c(((EntityPlayerSP)entityClientPlayerMP).field_70161_v));
/*  673 */         ((EntityPlayerSP)entityClientPlayerMP).field_71070_bA.field_75152_c = p_147265_1_.func_148901_c();
/*      */         break;
/*      */       case 4:
/*  676 */         entityClientPlayerMP.func_71002_c(MathHelper.func_76128_c(((EntityPlayerSP)entityClientPlayerMP).field_70165_t), MathHelper.func_76128_c(((EntityPlayerSP)entityClientPlayerMP).field_70163_u), MathHelper.func_76128_c(((EntityPlayerSP)entityClientPlayerMP).field_70161_v), p_147265_1_.func_148900_g() ? p_147265_1_.func_148902_e() : null);
/*  677 */         ((EntityPlayerSP)entityClientPlayerMP).field_71070_bA.field_75152_c = p_147265_1_.func_148901_c();
/*      */         break;
/*      */       case 6:
/*  680 */         entityClientPlayerMP.func_71030_a((IMerchant)new NpcMerchant((EntityPlayer)entityClientPlayerMP), p_147265_1_.func_148900_g() ? p_147265_1_.func_148902_e() : null);
/*  681 */         ((EntityPlayerSP)entityClientPlayerMP).field_71070_bA.field_75152_c = p_147265_1_.func_148901_c();
/*      */         break;
/*      */       case 7:
/*  684 */         tileEntityBeacon = new TileEntityBeacon();
/*  685 */         entityClientPlayerMP.func_146104_a(tileEntityBeacon);
/*  686 */         if (p_147265_1_.func_148900_g()) tileEntityBeacon.func_145999_a(p_147265_1_.func_148902_e()); 
/*  687 */         ((EntityPlayerSP)entityClientPlayerMP).field_71070_bA.field_75152_c = p_147265_1_.func_148901_c();
/*      */         break;
/*      */       case 8:
/*  690 */         entityClientPlayerMP.func_82244_d(MathHelper.func_76128_c(((EntityPlayerSP)entityClientPlayerMP).field_70165_t), MathHelper.func_76128_c(((EntityPlayerSP)entityClientPlayerMP).field_70163_u), MathHelper.func_76128_c(((EntityPlayerSP)entityClientPlayerMP).field_70161_v));
/*  691 */         ((EntityPlayerSP)entityClientPlayerMP).field_71070_bA.field_75152_c = p_147265_1_.func_148901_c();
/*      */         break;
/*      */       case 11:
/*  694 */         entity = this.field_147300_g.func_73045_a(p_147265_1_.func_148897_h());
/*  695 */         if (entity != null && entity instanceof EntityHorse) {
/*  696 */           entityClientPlayerMP.func_110298_a((EntityHorse)entity, (IInventory)new AnimalChest(p_147265_1_.func_148902_e(), p_147265_1_.func_148900_g(), p_147265_1_.func_148898_f()));
/*  697 */           ((EntityPlayerSP)entityClientPlayerMP).field_71070_bA.field_75152_c = p_147265_1_.func_148901_c();
/*      */         } 
/*      */         break;
/*      */     }  }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_147266_a(S2FPacketSetSlot p_147266_1_) {
/*  706 */     EntityClientPlayerMP entityClientPlayerMP = this.field_147299_f.field_71439_g;
/*  707 */     if (p_147266_1_.func_149175_c() == -1) {
/*  708 */       ((EntityPlayer)entityClientPlayerMP).field_71071_by.func_70437_b(p_147266_1_.func_149174_e());
/*      */     } else {
/*  710 */       boolean bool = false;
/*      */       
/*  712 */       if (this.field_147299_f.field_71462_r instanceof GuiContainerCreative) {
/*  713 */         GuiContainerCreative guiContainerCreative = (GuiContainerCreative)this.field_147299_f.field_71462_r;
/*      */         
/*  715 */         bool = (guiContainerCreative.func_147056_g() != CreativeTabs.field_78036_m.func_78021_a()) ? true : false;
/*      */       } 
/*      */       
/*  718 */       if (p_147266_1_.func_149175_c() == 0 && p_147266_1_.func_149173_d() >= 36 && p_147266_1_.func_149173_d() < 45) {
/*  719 */         ItemStack itemStack = ((EntityPlayer)entityClientPlayerMP).field_71069_bz.func_75139_a(p_147266_1_.func_149173_d()).func_75211_c();
/*  720 */         if (p_147266_1_.func_149174_e() != null && (
/*  721 */           itemStack == null || itemStack.field_77994_a < (p_147266_1_.func_149174_e()).field_77994_a)) {
/*  722 */           (p_147266_1_.func_149174_e()).field_77992_b = 5;
/*      */         }
/*      */         
/*  725 */         ((EntityPlayer)entityClientPlayerMP).field_71069_bz.func_75141_a(p_147266_1_.func_149173_d(), p_147266_1_.func_149174_e());
/*  726 */       } else if (p_147266_1_.func_149175_c() == ((EntityPlayer)entityClientPlayerMP).field_71070_bA.field_75152_c && (p_147266_1_.func_149175_c() != 0 || !bool)) {
/*  727 */         ((EntityPlayer)entityClientPlayerMP).field_71070_bA.func_75141_a(p_147266_1_.func_149173_d(), p_147266_1_.func_149174_e());
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147239_a(S32PacketConfirmTransaction p_147239_1_) {
/*  734 */     Container container = null;
/*  735 */     EntityClientPlayerMP entityClientPlayerMP = this.field_147299_f.field_71439_g;
/*  736 */     if (p_147239_1_.func_148889_c() == 0) {
/*  737 */       container = ((EntityPlayer)entityClientPlayerMP).field_71069_bz;
/*  738 */     } else if (p_147239_1_.func_148889_c() == ((EntityPlayer)entityClientPlayerMP).field_71070_bA.field_75152_c) {
/*  739 */       container = ((EntityPlayer)entityClientPlayerMP).field_71070_bA;
/*      */     } 
/*  741 */     if (container != null && 
/*  742 */       !p_147239_1_.func_148888_e()) {
/*  743 */       func_147297_a((Packet)new C0FPacketConfirmTransaction(p_147239_1_.func_148889_c(), p_147239_1_.func_148890_d(), true));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_147241_a(S30PacketWindowItems p_147241_1_) {
/*  750 */     EntityClientPlayerMP entityClientPlayerMP = this.field_147299_f.field_71439_g;
/*  751 */     if (p_147241_1_.func_148911_c() == 0) {
/*  752 */       ((EntityPlayer)entityClientPlayerMP).field_71069_bz.func_75131_a(p_147241_1_.func_148910_d());
/*  753 */     } else if (p_147241_1_.func_148911_c() == ((EntityPlayer)entityClientPlayerMP).field_71070_bA.field_75152_c) {
/*  754 */       ((EntityPlayer)entityClientPlayerMP).field_71070_bA.func_75131_a(p_147241_1_.func_148910_d());
/*      */     } 
/*      */   }
/*      */   
/*      */   public void func_147268_a(S36PacketSignEditorOpen p_147268_1_) {
/*      */     TileEntitySign tileEntitySign;
/*  760 */     TileEntity tileEntity = this.field_147300_g.func_147438_o(p_147268_1_.func_149129_c(), p_147268_1_.func_149128_d(), p_147268_1_.func_149127_e());
/*      */     
/*  762 */     if (tileEntity == null) {
/*  763 */       tileEntitySign = new TileEntitySign();
/*  764 */       tileEntitySign.func_145834_a((World)this.field_147300_g);
/*  765 */       ((TileEntity)tileEntitySign).field_145851_c = p_147268_1_.func_149129_c();
/*  766 */       ((TileEntity)tileEntitySign).field_145848_d = p_147268_1_.func_149128_d();
/*  767 */       ((TileEntity)tileEntitySign).field_145849_e = p_147268_1_.func_149127_e();
/*      */     } 
/*      */     
/*  770 */     this.field_147299_f.field_71439_g.func_146100_a((TileEntity)tileEntitySign);
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147248_a(S33PacketUpdateSign p_147248_1_) {
/*  775 */     boolean bool = false;
/*  776 */     if (this.field_147299_f.field_71441_e.func_72899_e(p_147248_1_.func_149346_c(), p_147248_1_.func_149345_d(), p_147248_1_.func_149344_e())) {
/*  777 */       TileEntity tileEntity = this.field_147299_f.field_71441_e.func_147438_o(p_147248_1_.func_149346_c(), p_147248_1_.func_149345_d(), p_147248_1_.func_149344_e());
/*  778 */       if (tileEntity instanceof TileEntitySign) {
/*  779 */         TileEntitySign tileEntitySign = (TileEntitySign)tileEntity;
/*  780 */         if (tileEntitySign.func_145914_a()) {
/*  781 */           for (byte b = 0; b < 4; b++) {
/*  782 */             tileEntitySign.field_145915_a[b] = p_147248_1_.func_149347_f()[b];
/*      */           }
/*  784 */           tileEntitySign.func_70296_d();
/*      */         } 
/*  786 */         bool = true;
/*      */       } 
/*      */     } 
/*  789 */     if (!bool && this.field_147299_f.field_71439_g != null) {
/*  790 */       this.field_147299_f.field_71439_g.func_145747_a((IChatComponent)new ChatComponentText("Unable to locate sign at " + p_147248_1_.func_149346_c() + ", " + p_147248_1_.func_149345_d() + ", " + p_147248_1_.func_149344_e()));
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147273_a(S35PacketUpdateTileEntity p_147273_1_) {
/*  796 */     if (this.field_147299_f.field_71441_e.func_72899_e(p_147273_1_.func_148856_c(), p_147273_1_.func_148855_d(), p_147273_1_.func_148854_e())) {
/*  797 */       TileEntity tileEntity = this.field_147299_f.field_71441_e.func_147438_o(p_147273_1_.func_148856_c(), p_147273_1_.func_148855_d(), p_147273_1_.func_148854_e());
/*      */       
/*  799 */       if (tileEntity != null) {
/*  800 */         if (p_147273_1_.func_148853_f() == 1 && tileEntity instanceof net.minecraft.tileentity.TileEntityMobSpawner) {
/*  801 */           tileEntity.func_145839_a(p_147273_1_.func_148857_g());
/*  802 */         } else if (p_147273_1_.func_148853_f() == 2 && tileEntity instanceof net.minecraft.tileentity.TileEntityCommandBlock) {
/*  803 */           tileEntity.func_145839_a(p_147273_1_.func_148857_g());
/*  804 */         } else if (p_147273_1_.func_148853_f() == 3 && tileEntity instanceof TileEntityBeacon) {
/*  805 */           tileEntity.func_145839_a(p_147273_1_.func_148857_g());
/*  806 */         } else if (p_147273_1_.func_148853_f() == 4 && tileEntity instanceof net.minecraft.tileentity.TileEntitySkull) {
/*  807 */           tileEntity.func_145839_a(p_147273_1_.func_148857_g());
/*  808 */         } else if (p_147273_1_.func_148853_f() == 5 && tileEntity instanceof net.minecraft.tileentity.TileEntityFlowerPot) {
/*  809 */           tileEntity.func_145839_a(p_147273_1_.func_148857_g());
/*      */         } 
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147245_a(S31PacketWindowProperty p_147245_1_) {
/*  817 */     EntityClientPlayerMP entityClientPlayerMP = this.field_147299_f.field_71439_g;
/*  818 */     if (((EntityPlayer)entityClientPlayerMP).field_71070_bA != null && ((EntityPlayer)entityClientPlayerMP).field_71070_bA.field_75152_c == p_147245_1_.func_149182_c()) {
/*  819 */       ((EntityPlayer)entityClientPlayerMP).field_71070_bA.func_75137_b(p_147245_1_.func_149181_d(), p_147245_1_.func_149180_e());
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147242_a(S04PacketEntityEquipment p_147242_1_) {
/*  825 */     Entity entity = this.field_147300_g.func_73045_a(p_147242_1_.func_149389_d());
/*  826 */     if (entity != null) {
/*  827 */       entity.func_70062_b(p_147242_1_.func_149388_e(), p_147242_1_.func_149390_c());
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147276_a(S2EPacketCloseWindow p_147276_1_) {
/*  833 */     this.field_147299_f.field_71439_g.func_92015_f();
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147261_a(S24PacketBlockAction p_147261_1_) {
/*  838 */     this.field_147299_f.field_71441_e.func_147452_c(p_147261_1_.func_148867_d(), p_147261_1_.func_148866_e(), p_147261_1_.func_148865_f(), p_147261_1_.func_148868_c(), p_147261_1_.func_148869_g(), p_147261_1_.func_148864_h());
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147294_a(S25PacketBlockBreakAnim p_147294_1_) {
/*  843 */     this.field_147299_f.field_71441_e.func_147443_d(p_147294_1_.func_148845_c(), p_147294_1_.func_148844_d(), p_147294_1_.func_148843_e(), p_147294_1_.func_148842_f(), p_147294_1_.func_148846_g());
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147269_a(S26PacketMapChunkBulk p_147269_1_) {
/*  848 */     for (byte b = 0; b < p_147269_1_.func_149254_d(); b++) {
/*  849 */       int i = p_147269_1_.func_149255_a(b);
/*  850 */       int j = p_147269_1_.func_149253_b(b);
/*      */       
/*  852 */       this.field_147300_g.func_73025_a(i, j, true);
/*      */       
/*  854 */       this.field_147300_g.func_73031_a(i << 4, 0, j << 4, (i << 4) + 15, 256, (j << 4) + 15);
/*      */       
/*  856 */       Chunk chunk = this.field_147300_g.func_72964_e(i, j);
/*      */       
/*  858 */       chunk.func_76607_a(p_147269_1_.func_149256_c(b), p_147269_1_.func_149252_e()[b], p_147269_1_.func_149257_f()[b], true);
/*  859 */       this.field_147300_g.func_147458_c(i << 4, 0, j << 4, (i << 4) + 15, 256, (j << 4) + 15);
/*      */       
/*  861 */       if (!(this.field_147300_g.field_73011_w instanceof net.minecraft.world.WorldProviderSurface)) {
/*  862 */         chunk.func_76613_n();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147252_a(S2BPacketChangeGameState p_147252_1_) {
/*  869 */     EntityClientPlayerMP entityClientPlayerMP = this.field_147299_f.field_71439_g;
/*  870 */     int i = p_147252_1_.func_149138_c();
/*  871 */     float f = p_147252_1_.func_149137_d();
/*  872 */     int j = MathHelper.func_76141_d(f + 0.5F);
/*  873 */     if (i >= 0 && i < S2BPacketChangeGameState.field_149142_a.length && 
/*  874 */       S2BPacketChangeGameState.field_149142_a[i] != null) {
/*  875 */       entityClientPlayerMP.func_146105_b((IChatComponent)new ChatComponentTranslation(S2BPacketChangeGameState.field_149142_a[i], new Object[0]));
/*      */     }
/*      */     
/*  878 */     if (i == 1) {
/*  879 */       this.field_147300_g.func_72912_H().func_76084_b(true);
/*  880 */       this.field_147300_g.func_72894_k(0.0F);
/*  881 */     } else if (i == 2) {
/*  882 */       this.field_147300_g.func_72912_H().func_76084_b(false);
/*  883 */       this.field_147300_g.func_72894_k(1.0F);
/*  884 */     } else if (i == 3) {
/*  885 */       this.field_147299_f.field_71442_b.func_78746_a(WorldSettings.GameType.func_77146_a(j));
/*  886 */     } else if (i == 4) {
/*  887 */       this.field_147299_f.func_147108_a((GuiScreen)new GuiWinGame());
/*  888 */     } else if (i == 5) {
/*  889 */       GameSettings gameSettings = this.field_147299_f.field_71474_y;
/*  890 */       if (f == 0.0F) {
/*  891 */         this.field_147299_f.func_147108_a((GuiScreen)new GuiScreenDemo());
/*  892 */       } else if (f == 101.0F) {
/*  893 */         this.field_147299_f.field_71456_v.func_146158_b().func_146227_a((IChatComponent)new ChatComponentTranslation("demo.help.movement", new Object[] { GameSettings.func_74298_c(gameSettings.field_74351_w.func_151463_i()), GameSettings.func_74298_c(gameSettings.field_74370_x.func_151463_i()), GameSettings.func_74298_c(gameSettings.field_74368_y.func_151463_i()), GameSettings.func_74298_c(gameSettings.field_74366_z.func_151463_i()) }));
/*      */       }
/*  895 */       else if (f == 102.0F) {
/*  896 */         this.field_147299_f.field_71456_v.func_146158_b().func_146227_a((IChatComponent)new ChatComponentTranslation("demo.help.jump", new Object[] { GameSettings.func_74298_c(gameSettings.field_74314_A.func_151463_i()) }));
/*  897 */       } else if (f == 103.0F) {
/*  898 */         this.field_147299_f.field_71456_v.func_146158_b().func_146227_a((IChatComponent)new ChatComponentTranslation("demo.help.inventory", new Object[] { GameSettings.func_74298_c(gameSettings.field_151445_Q.func_151463_i()) }));
/*      */       } 
/*  900 */     } else if (i == 6) {
/*  901 */       this.field_147300_g.func_72980_b(((EntityPlayer)entityClientPlayerMP).field_70165_t, ((EntityPlayer)entityClientPlayerMP).field_70163_u + entityClientPlayerMP.func_70047_e(), ((EntityPlayer)entityClientPlayerMP).field_70161_v, "random.successful_hit", 0.18F, 0.45F, false);
/*  902 */     } else if (i == 7) {
/*  903 */       this.field_147300_g.func_72894_k(f);
/*  904 */     } else if (i == 8) {
/*  905 */       this.field_147300_g.func_147442_i(f);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147264_a(S34PacketMaps p_147264_1_) {
/*  911 */     MapData mapData = ItemMap.func_150912_a(p_147264_1_.func_149188_c(), (World)this.field_147299_f.field_71441_e);
/*  912 */     mapData.func_76192_a(p_147264_1_.func_149187_d());
/*  913 */     this.field_147299_f.field_71460_t.func_147701_i().func_148246_a(mapData);
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147277_a(S28PacketEffect p_147277_1_) {
/*  918 */     if (p_147277_1_.func_149244_c()) {
/*  919 */       this.field_147299_f.field_71441_e.func_82739_e(p_147277_1_.func_149242_d(), p_147277_1_.func_149240_f(), p_147277_1_.func_149243_g(), p_147277_1_.func_149239_h(), p_147277_1_.func_149241_e());
/*      */     } else {
/*  921 */       this.field_147299_f.field_71441_e.func_72926_e(p_147277_1_.func_149242_d(), p_147277_1_.func_149240_f(), p_147277_1_.func_149243_g(), p_147277_1_.func_149239_h(), p_147277_1_.func_149241_e());
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147293_a(S37PacketStatistics p_147293_1_) {
/*  927 */     boolean bool = false;
/*      */     
/*  929 */     for (Map.Entry entry : p_147293_1_.func_148974_c().entrySet()) {
/*  930 */       StatBase statBase = (StatBase)entry.getKey();
/*  931 */       int i = ((Integer)entry.getValue()).intValue();
/*      */       
/*  933 */       if (statBase.func_75967_d() && i > 0) {
/*  934 */         if (this.field_147308_k && this.field_147299_f.field_71439_g.func_146107_m().func_77444_a(statBase) == 0) {
/*  935 */           Achievement achievement = (Achievement)statBase;
/*  936 */           this.field_147299_f.field_71458_u.func_146256_a(achievement);
/*  937 */           this.field_147299_f.func_152346_Z().func_152911_a((Metadata)new MetadataAchievement(achievement), 0L);
/*      */           
/*  939 */           if (statBase == AchievementList.field_76004_f) {
/*  940 */             this.field_147299_f.field_71474_y.field_151441_H = false;
/*  941 */             this.field_147299_f.field_71474_y.func_74303_b();
/*      */           } 
/*      */         } 
/*  944 */         bool = true;
/*      */       } 
/*      */       
/*  947 */       this.field_147299_f.field_71439_g.func_146107_m().func_150873_a((EntityPlayer)this.field_147299_f.field_71439_g, statBase, i);
/*      */     } 
/*      */     
/*  950 */     if (!this.field_147308_k && !bool && this.field_147299_f.field_71474_y.field_151441_H) {
/*  951 */       this.field_147299_f.field_71458_u.func_146255_b(AchievementList.field_76004_f);
/*      */     }
/*      */     
/*  954 */     this.field_147308_k = true;
/*      */     
/*  956 */     if (this.field_147299_f.field_71462_r instanceof IProgressMeter) {
/*  957 */       ((IProgressMeter)this.field_147299_f.field_71462_r).func_146509_g();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147260_a(S1DPacketEntityEffect p_147260_1_) {
/*  963 */     Entity entity = this.field_147300_g.func_73045_a(p_147260_1_.func_149426_d());
/*  964 */     if (!(entity instanceof EntityLivingBase))
/*      */       return; 
/*  966 */     PotionEffect potionEffect = new PotionEffect(p_147260_1_.func_149427_e(), p_147260_1_.func_149425_g(), p_147260_1_.func_149428_f());
/*  967 */     potionEffect.func_100012_b(p_147260_1_.func_149429_c());
/*  968 */     ((EntityLivingBase)entity).func_70690_d(potionEffect);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_147262_a(S1EPacketRemoveEntityEffect p_147262_1_) {
/*  992 */     Entity entity = this.field_147300_g.func_73045_a(p_147262_1_.func_149076_c());
/*  993 */     if (entity instanceof EntityLivingBase) {
/*  994 */       ((EntityLivingBase)entity).func_70618_n(p_147262_1_.func_149075_d());
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147256_a(S38PacketPlayerListItem p_147256_1_) {
/* 1000 */     GuiPlayerInfo guiPlayerInfo = (GuiPlayerInfo)this.field_147310_i.get(p_147256_1_.func_149122_c());
/* 1001 */     if (guiPlayerInfo == null && p_147256_1_.func_149121_d()) {
/* 1002 */       guiPlayerInfo = new GuiPlayerInfo(p_147256_1_.func_149122_c());
/* 1003 */       this.field_147310_i.put(p_147256_1_.func_149122_c(), guiPlayerInfo);
/* 1004 */       this.field_147303_b.add(guiPlayerInfo);
/*      */     } 
/* 1006 */     if (guiPlayerInfo != null && !p_147256_1_.func_149121_d()) {
/* 1007 */       this.field_147310_i.remove(p_147256_1_.func_149122_c());
/* 1008 */       this.field_147303_b.remove(guiPlayerInfo);
/*      */     } 
/* 1010 */     if (guiPlayerInfo != null && p_147256_1_.func_149121_d()) {
/* 1011 */       guiPlayerInfo.field_78829_b = p_147256_1_.func_149120_e();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147272_a(S00PacketKeepAlive p_147272_1_) {
/* 1017 */     func_147297_a((Packet)new C00PacketKeepAlive(p_147272_1_.func_149134_c()));
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147232_a(EnumConnectionState p_147232_1_, EnumConnectionState p_147232_2_) {
/* 1022 */     throw new IllegalStateException("Unexpected protocol change!");
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147270_a(S39PacketPlayerAbilities p_147270_1_) {
/* 1027 */     EntityClientPlayerMP entityClientPlayerMP = this.field_147299_f.field_71439_g;
/* 1028 */     ((EntityPlayer)entityClientPlayerMP).field_71075_bZ.field_75100_b = p_147270_1_.func_149106_d();
/* 1029 */     ((EntityPlayer)entityClientPlayerMP).field_71075_bZ.field_75098_d = p_147270_1_.func_149103_f();
/* 1030 */     ((EntityPlayer)entityClientPlayerMP).field_71075_bZ.field_75102_a = p_147270_1_.func_149112_c();
/* 1031 */     ((EntityPlayer)entityClientPlayerMP).field_71075_bZ.field_75101_c = p_147270_1_.func_149105_e();
/* 1032 */     ((EntityPlayer)entityClientPlayerMP).field_71075_bZ.func_75092_a(p_147270_1_.func_149101_g());
/* 1033 */     ((EntityPlayer)entityClientPlayerMP).field_71075_bZ.func_82877_b(p_147270_1_.func_149107_h());
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147274_a(S3APacketTabComplete p_147274_1_) {
/* 1038 */     String[] arrayOfString = p_147274_1_.func_149630_c();
/*      */     
/* 1040 */     if (this.field_147299_f.field_71462_r instanceof GuiChat) {
/* 1041 */       GuiChat guiChat = (GuiChat)this.field_147299_f.field_71462_r;
/*      */       
/* 1043 */       guiChat.func_146406_a(arrayOfString);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147255_a(S29PacketSoundEffect p_147255_1_) {
/* 1049 */     this.field_147299_f.field_71441_e.func_72980_b(p_147255_1_.func_149207_d(), p_147255_1_.func_149211_e(), p_147255_1_.func_149210_f(), p_147255_1_.func_149212_c(), p_147255_1_.func_149208_g(), p_147255_1_.func_149209_h(), false);
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147240_a(S3FPacketCustomPayload p_147240_1_) {
/* 1054 */     if ("MC|TrList".equals(p_147240_1_.func_149169_c())) {
/* 1055 */       ByteBuf byteBuf = Unpooled.wrappedBuffer(p_147240_1_.func_149168_d());
/*      */       try {
/* 1057 */         int i = byteBuf.readInt();
/* 1058 */         GuiScreen guiScreen = this.field_147299_f.field_71462_r;
/* 1059 */         if (guiScreen != null && guiScreen instanceof GuiMerchant && i == this.field_147299_f.field_71439_g.field_71070_bA.field_75152_c) {
/* 1060 */           IMerchant iMerchant = ((GuiMerchant)guiScreen).func_147035_g();
/* 1061 */           MerchantRecipeList merchantRecipeList = MerchantRecipeList.func_151390_b(new PacketBuffer(byteBuf));
/* 1062 */           iMerchant.func_70930_a(merchantRecipeList);
/*      */         } 
/* 1064 */       } catch (IOException iOException) {
/* 1065 */         field_147301_d.error("Couldn't load trade info", iOException);
/*      */       } finally {
/* 1067 */         byteBuf.release();
/*      */       } 
/* 1069 */     } else if ("MC|Brand".equals(p_147240_1_.func_149169_c())) {
/* 1070 */       this.field_147299_f.field_71439_g.func_142020_c(new String(p_147240_1_.func_149168_d(), Charsets.UTF_8));
/* 1071 */     } else if ("MC|RPack".equals(p_147240_1_.func_149169_c())) {
/* 1072 */       String str = new String(p_147240_1_.func_149168_d(), Charsets.UTF_8);
/*      */       
/* 1074 */       if (this.field_147299_f.func_147104_D() != null && this.field_147299_f.func_147104_D().func_152586_b() == ServerData.ServerResourceMode.ENABLED) {
/* 1075 */         this.field_147299_f.func_110438_M().func_148526_a(str);
/* 1076 */       } else if (this.field_147299_f.func_147104_D() == null || this.field_147299_f.func_147104_D().func_152586_b() == ServerData.ServerResourceMode.PROMPT) {
/* 1077 */         this.field_147299_f.func_147108_a((GuiScreen)new GuiYesNo(new GuiYesNoCallback(this, str) { private static final String __OBFID = "CL_00000879";
/*      */                 
/*      */                 public void func_73878_a(boolean p_73878_1_, int p_73878_2_) {
/* 1080 */                   this.field_146299_f.field_147299_f = Minecraft.func_71410_x();
/*      */                   
/* 1082 */                   if (this.field_146299_f.field_147299_f.func_147104_D() != null) {
/* 1083 */                     this.field_146299_f.field_147299_f.func_147104_D().func_152584_a(ServerData.ServerResourceMode.ENABLED);
/* 1084 */                     ServerList.func_147414_b(this.field_146299_f.field_147299_f.func_147104_D());
/*      */                   } 
/*      */                   
/* 1087 */                   if (p_73878_1_) {
/* 1088 */                     this.field_146299_f.field_147299_f.func_110438_M().func_148526_a(this.field_146300_a);
/*      */                   }
/*      */                   
/* 1091 */                   this.field_146299_f.field_147299_f.func_147108_a(null);
/*      */                 } }
/*      */               I18n.func_135052_a("multiplayer.texturePrompt.line1", new Object[0]), I18n.func_135052_a("multiplayer.texturePrompt.line2", new Object[0]), 0));
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147291_a(S3BPacketScoreboardObjective p_147291_1_) {
/* 1100 */     Scoreboard scoreboard = this.field_147300_g.func_96441_U();
/*      */     
/* 1102 */     if (p_147291_1_.func_149338_e() == 0) {
/* 1103 */       ScoreObjective scoreObjective = scoreboard.func_96535_a(p_147291_1_.func_149339_c(), IScoreObjectiveCriteria.field_96641_b);
/* 1104 */       scoreObjective.func_96681_a(p_147291_1_.func_149337_d());
/*      */     } else {
/* 1106 */       ScoreObjective scoreObjective = scoreboard.func_96518_b(p_147291_1_.func_149339_c());
/*      */       
/* 1108 */       if (p_147291_1_.func_149338_e() == 1) {
/* 1109 */         scoreboard.func_96519_k(scoreObjective);
/* 1110 */       } else if (p_147291_1_.func_149338_e() == 2) {
/* 1111 */         scoreObjective.func_96681_a(p_147291_1_.func_149337_d());
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147250_a(S3CPacketUpdateScore p_147250_1_) {
/* 1118 */     Scoreboard scoreboard = this.field_147300_g.func_96441_U();
/* 1119 */     ScoreObjective scoreObjective = scoreboard.func_96518_b(p_147250_1_.func_149321_d());
/*      */     
/* 1121 */     if (p_147250_1_.func_149322_f() == 0) {
/* 1122 */       Score score = scoreboard.func_96529_a(p_147250_1_.func_149324_c(), scoreObjective);
/*      */       
/* 1124 */       score.func_96647_c(p_147250_1_.func_149323_e());
/* 1125 */     } else if (p_147250_1_.func_149322_f() == 1) {
/* 1126 */       scoreboard.func_96515_c(p_147250_1_.func_149324_c());
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147254_a(S3DPacketDisplayScoreboard p_147254_1_) {
/* 1132 */     Scoreboard scoreboard = this.field_147300_g.func_96441_U();
/*      */     
/* 1134 */     if (p_147254_1_.func_149370_d().length() == 0) {
/* 1135 */       scoreboard.func_96530_a(p_147254_1_.func_149371_c(), null);
/*      */     } else {
/* 1137 */       ScoreObjective scoreObjective = scoreboard.func_96518_b(p_147254_1_.func_149370_d());
/* 1138 */       scoreboard.func_96530_a(p_147254_1_.func_149371_c(), scoreObjective);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void func_147247_a(S3EPacketTeams p_147247_1_) {
/*      */     ScorePlayerTeam scorePlayerTeam;
/* 1144 */     Scoreboard scoreboard = this.field_147300_g.func_96441_U();
/*      */ 
/*      */     
/* 1147 */     if (p_147247_1_.func_149307_h() == 0) {
/* 1148 */       scorePlayerTeam = scoreboard.func_96527_f(p_147247_1_.func_149312_c());
/*      */     } else {
/* 1150 */       scorePlayerTeam = scoreboard.func_96508_e(p_147247_1_.func_149312_c());
/*      */     } 
/*      */     
/* 1153 */     if (p_147247_1_.func_149307_h() == 0 || p_147247_1_.func_149307_h() == 2) {
/* 1154 */       scorePlayerTeam.func_96664_a(p_147247_1_.func_149306_d());
/* 1155 */       scorePlayerTeam.func_96666_b(p_147247_1_.func_149311_e());
/* 1156 */       scorePlayerTeam.func_96662_c(p_147247_1_.func_149309_f());
/* 1157 */       scorePlayerTeam.func_98298_a(p_147247_1_.func_149308_i());
/*      */     } 
/*      */     
/* 1160 */     if (p_147247_1_.func_149307_h() == 0 || p_147247_1_.func_149307_h() == 3) {
/* 1161 */       for (String str : p_147247_1_.func_149310_g()) {
/* 1162 */         scoreboard.func_151392_a(str, p_147247_1_.func_149312_c());
/*      */       }
/*      */     }
/*      */     
/* 1166 */     if (p_147247_1_.func_149307_h() == 4) {
/* 1167 */       for (String str : p_147247_1_.func_149310_g()) {
/* 1168 */         scoreboard.func_96512_b(str, scorePlayerTeam);
/*      */       }
/*      */     }
/*      */     
/* 1172 */     if (p_147247_1_.func_149307_h() == 1) {
/* 1173 */       scoreboard.func_96511_d(scorePlayerTeam);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147289_a(S2APacketParticles p_147289_1_) {
/* 1179 */     if (p_147289_1_.func_149222_k() == 0) {
/* 1180 */       double d1 = (p_147289_1_.func_149227_j() * p_147289_1_.func_149221_g());
/* 1181 */       double d2 = (p_147289_1_.func_149227_j() * p_147289_1_.func_149224_h());
/* 1182 */       double d3 = (p_147289_1_.func_149227_j() * p_147289_1_.func_149223_i());
/* 1183 */       this.field_147300_g.func_72869_a(p_147289_1_.func_149228_c(), p_147289_1_.func_149220_d(), p_147289_1_.func_149226_e(), p_147289_1_.func_149225_f(), d1, d2, d3);
/*      */     } else {
/* 1185 */       for (byte b = 0; b < p_147289_1_.func_149222_k(); b++) {
/* 1186 */         double d1 = this.field_147306_l.nextGaussian() * p_147289_1_.func_149221_g();
/* 1187 */         double d2 = this.field_147306_l.nextGaussian() * p_147289_1_.func_149224_h();
/* 1188 */         double d3 = this.field_147306_l.nextGaussian() * p_147289_1_.func_149223_i();
/* 1189 */         double d4 = this.field_147306_l.nextGaussian() * p_147289_1_.func_149227_j();
/* 1190 */         double d5 = this.field_147306_l.nextGaussian() * p_147289_1_.func_149227_j();
/* 1191 */         double d6 = this.field_147306_l.nextGaussian() * p_147289_1_.func_149227_j();
/* 1192 */         this.field_147300_g.func_72869_a(p_147289_1_.func_149228_c(), p_147289_1_.func_149220_d() + d1, p_147289_1_.func_149226_e() + d2, p_147289_1_.func_149225_f() + d3, d4, d5, d6);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147290_a(S20PacketEntityProperties p_147290_1_) {
/* 1199 */     Entity entity = this.field_147300_g.func_73045_a(p_147290_1_.func_149442_c());
/* 1200 */     if (entity == null)
/* 1201 */       return;  if (!(entity instanceof EntityLivingBase)) {
/* 1202 */       throw new IllegalStateException("Server tried to update attributes of a non-living entity (actually: " + entity + ")");
/*      */     }
/*      */     
/* 1205 */     BaseAttributeMap baseAttributeMap = ((EntityLivingBase)entity).func_110140_aT();
/* 1206 */     for (S20PacketEntityProperties.Snapshot snapshot : p_147290_1_.func_149441_d()) {
/* 1207 */       IAttributeInstance iAttributeInstance = baseAttributeMap.func_111152_a(snapshot.func_151409_a());
/*      */       
/* 1209 */       if (iAttributeInstance == null) {
/* 1210 */         iAttributeInstance = baseAttributeMap.func_111150_b((IAttribute)new RangedAttribute(snapshot.func_151409_a(), 0.0D, 2.2250738585072014E-308D, Double.MAX_VALUE));
/*      */       }
/*      */       
/* 1213 */       iAttributeInstance.func_111128_a(snapshot.func_151410_b());
/* 1214 */       iAttributeInstance.func_142049_d();
/*      */       
/* 1216 */       for (AttributeModifier attributeModifier : snapshot.func_151408_c()) {
/* 1217 */         iAttributeInstance.func_111121_a(attributeModifier);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public NetworkManager func_147298_b() {
/* 1223 */     return this.field_147302_e;
/*      */   }
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\network\NetHandlerPlayClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */