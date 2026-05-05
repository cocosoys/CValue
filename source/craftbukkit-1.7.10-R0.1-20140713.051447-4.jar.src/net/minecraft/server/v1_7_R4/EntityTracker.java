/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Set;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntityTracker
/*     */ {
/*  14 */   private static final Logger a = LogManager.getLogger();
/*     */   private final WorldServer world;
/*  16 */   private Set c = new HashSet();
/*  17 */   public IntHashMap trackedEntities = new IntHashMap();
/*     */   private int e;
/*     */   
/*     */   public EntityTracker(WorldServer worldserver) {
/*  21 */     this.world = worldserver;
/*  22 */     this.e = worldserver.getMinecraftServer().getPlayerList().d();
/*     */   }
/*     */   
/*     */   public void track(Entity entity) {
/*  26 */     if (entity instanceof EntityPlayer) {
/*  27 */       addEntity(entity, 512, 2);
/*  28 */       EntityPlayer entityplayer = (EntityPlayer)entity;
/*  29 */       Iterator<EntityTrackerEntry> iterator = this.c.iterator();
/*     */       
/*  31 */       while (iterator.hasNext()) {
/*  32 */         EntityTrackerEntry entitytrackerentry = iterator.next();
/*     */         
/*  34 */         if (entitytrackerentry.tracker != entityplayer) {
/*  35 */           entitytrackerentry.updatePlayer(entityplayer);
/*     */         }
/*     */       } 
/*  38 */     } else if (entity instanceof EntityFishingHook) {
/*  39 */       addEntity(entity, 64, 5, true);
/*  40 */     } else if (entity instanceof EntityArrow) {
/*  41 */       addEntity(entity, 64, 20, false);
/*  42 */     } else if (entity instanceof EntitySmallFireball) {
/*  43 */       addEntity(entity, 64, 10, false);
/*  44 */     } else if (entity instanceof EntityFireball) {
/*  45 */       addEntity(entity, 64, 10, false);
/*  46 */     } else if (entity instanceof EntitySnowball) {
/*  47 */       addEntity(entity, 64, 10, true);
/*  48 */     } else if (entity instanceof EntityEnderPearl) {
/*  49 */       addEntity(entity, 64, 10, true);
/*  50 */     } else if (entity instanceof EntityEnderSignal) {
/*  51 */       addEntity(entity, 64, 4, true);
/*  52 */     } else if (entity instanceof EntityEgg) {
/*  53 */       addEntity(entity, 64, 10, true);
/*  54 */     } else if (entity instanceof EntityPotion) {
/*  55 */       addEntity(entity, 64, 10, true);
/*  56 */     } else if (entity instanceof EntityThrownExpBottle) {
/*  57 */       addEntity(entity, 64, 10, true);
/*  58 */     } else if (entity instanceof EntityFireworks) {
/*  59 */       addEntity(entity, 64, 10, true);
/*  60 */     } else if (entity instanceof EntityItem) {
/*  61 */       addEntity(entity, 64, 20, true);
/*  62 */     } else if (entity instanceof EntityMinecartAbstract) {
/*  63 */       addEntity(entity, 80, 3, true);
/*  64 */     } else if (entity instanceof EntityBoat) {
/*  65 */       addEntity(entity, 80, 3, true);
/*  66 */     } else if (entity instanceof EntitySquid) {
/*  67 */       addEntity(entity, 64, 3, true);
/*  68 */     } else if (entity instanceof EntityWither) {
/*  69 */       addEntity(entity, 80, 3, false);
/*  70 */     } else if (entity instanceof EntityBat) {
/*  71 */       addEntity(entity, 80, 3, false);
/*  72 */     } else if (entity instanceof IAnimal) {
/*  73 */       addEntity(entity, 80, 3, true);
/*  74 */     } else if (entity instanceof EntityEnderDragon) {
/*  75 */       addEntity(entity, 160, 3, true);
/*  76 */     } else if (entity instanceof EntityTNTPrimed) {
/*  77 */       addEntity(entity, 160, 10, true);
/*  78 */     } else if (entity instanceof EntityFallingBlock) {
/*  79 */       addEntity(entity, 160, 20, true);
/*  80 */     } else if (entity instanceof EntityHanging) {
/*  81 */       addEntity(entity, 160, 2147483647, false);
/*  82 */     } else if (entity instanceof EntityExperienceOrb) {
/*  83 */       addEntity(entity, 160, 20, true);
/*  84 */     } else if (entity instanceof EntityEnderCrystal) {
/*  85 */       addEntity(entity, 256, 2147483647, false);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addEntity(Entity entity, int i, int j) {
/*  90 */     addEntity(entity, i, j, false);
/*     */   }
/*     */   
/*     */   public void addEntity(Entity entity, int i, int j, boolean flag) {
/*  94 */     if (i > this.e) {
/*  95 */       i = this.e;
/*     */     }
/*     */     
/*     */     try {
/*  99 */       if (this.trackedEntities.b(entity.getId())) {
/* 100 */         throw new IllegalStateException("Entity is already tracked!");
/*     */       }
/*     */       
/* 103 */       EntityTrackerEntry entitytrackerentry = new EntityTrackerEntry(entity, i, j, flag);
/*     */       
/* 105 */       this.c.add(entitytrackerentry);
/* 106 */       this.trackedEntities.a(entity.getId(), entitytrackerentry);
/* 107 */       entitytrackerentry.scanPlayers(this.world.players);
/* 108 */     } catch (Throwable throwable) {
/* 109 */       CrashReport crashreport = CrashReport.a(throwable, "Adding entity to track");
/* 110 */       CrashReportSystemDetails crashreportsystemdetails = crashreport.a("Entity To Track");
/*     */       
/* 112 */       crashreportsystemdetails.a("Tracking range", i + " blocks");
/* 113 */       crashreportsystemdetails.a("Update interval", new CrashReportEntityTrackerUpdateInterval(this, j));
/* 114 */       entity.a(crashreportsystemdetails);
/* 115 */       CrashReportSystemDetails crashreportsystemdetails1 = crashreport.a("Entity That Is Already Tracked");
/*     */       
/* 117 */       ((EntityTrackerEntry)this.trackedEntities.get(entity.getId())).tracker.a(crashreportsystemdetails1);
/*     */       
/*     */       try {
/* 120 */         throw new ReportedException(crashreport);
/* 121 */       } catch (ReportedException reportedexception) {
/* 122 */         a.error("\"Silently\" catching entity tracking error.", reportedexception);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void untrackEntity(Entity entity) {
/* 128 */     if (entity instanceof EntityPlayer) {
/* 129 */       EntityPlayer entityplayer = (EntityPlayer)entity;
/* 130 */       Iterator<EntityTrackerEntry> iterator = this.c.iterator();
/*     */       
/* 132 */       while (iterator.hasNext()) {
/* 133 */         EntityTrackerEntry entitytrackerentry = iterator.next();
/*     */         
/* 135 */         entitytrackerentry.a(entityplayer);
/*     */       } 
/*     */     } 
/*     */     
/* 139 */     EntityTrackerEntry entitytrackerentry1 = (EntityTrackerEntry)this.trackedEntities.d(entity.getId());
/*     */     
/* 141 */     if (entitytrackerentry1 != null) {
/* 142 */       this.c.remove(entitytrackerentry1);
/* 143 */       entitytrackerentry1.a();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updatePlayers() {
/* 148 */     ArrayList<EntityPlayer> arraylist = new ArrayList();
/* 149 */     Iterator<EntityTrackerEntry> iterator = this.c.iterator();
/*     */     
/* 151 */     while (iterator.hasNext()) {
/* 152 */       EntityTrackerEntry entitytrackerentry = iterator.next();
/*     */       
/* 154 */       entitytrackerentry.track(this.world.players);
/* 155 */       if (entitytrackerentry.n && entitytrackerentry.tracker instanceof EntityPlayer) {
/* 156 */         arraylist.add((EntityPlayer)entitytrackerentry.tracker);
/*     */       }
/*     */     } 
/*     */     
/* 160 */     for (int i = 0; i < arraylist.size(); i++) {
/* 161 */       EntityPlayer entityplayer = arraylist.get(i);
/* 162 */       Iterator<EntityTrackerEntry> iterator1 = this.c.iterator();
/*     */       
/* 164 */       while (iterator1.hasNext()) {
/* 165 */         EntityTrackerEntry entitytrackerentry1 = iterator1.next();
/*     */         
/* 167 */         if (entitytrackerentry1.tracker != entityplayer) {
/* 168 */           entitytrackerentry1.updatePlayer(entityplayer);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void a(Entity entity, Packet packet) {
/* 175 */     EntityTrackerEntry entitytrackerentry = (EntityTrackerEntry)this.trackedEntities.get(entity.getId());
/*     */     
/* 177 */     if (entitytrackerentry != null) {
/* 178 */       entitytrackerentry.broadcast(packet);
/*     */     }
/*     */   }
/*     */   
/*     */   public void sendPacketToEntity(Entity entity, Packet packet) {
/* 183 */     EntityTrackerEntry entitytrackerentry = (EntityTrackerEntry)this.trackedEntities.get(entity.getId());
/*     */     
/* 185 */     if (entitytrackerentry != null) {
/* 186 */       entitytrackerentry.broadcastIncludingSelf(packet);
/*     */     }
/*     */   }
/*     */   
/*     */   public void untrackPlayer(EntityPlayer entityplayer) {
/* 191 */     Iterator<EntityTrackerEntry> iterator = this.c.iterator();
/*     */     
/* 193 */     while (iterator.hasNext()) {
/* 194 */       EntityTrackerEntry entitytrackerentry = iterator.next();
/*     */       
/* 196 */       entitytrackerentry.clear(entityplayer);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void a(EntityPlayer entityplayer, Chunk chunk) {
/* 201 */     Iterator<EntityTrackerEntry> iterator = this.c.iterator();
/*     */     
/* 203 */     while (iterator.hasNext()) {
/* 204 */       EntityTrackerEntry entitytrackerentry = iterator.next();
/*     */       
/* 206 */       if (entitytrackerentry.tracker != entityplayer && entitytrackerentry.tracker.ah == chunk.locX && entitytrackerentry.tracker.aj == chunk.locZ)
/* 207 */         entitytrackerentry.updatePlayer(entityplayer); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\EntityTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */