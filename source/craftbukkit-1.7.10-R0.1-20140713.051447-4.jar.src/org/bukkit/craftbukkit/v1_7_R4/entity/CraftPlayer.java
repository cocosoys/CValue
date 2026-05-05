/*      */ package org.bukkit.craftbukkit.v1_7_R4.entity;
/*      */ import java.io.ByteArrayOutputStream;
/*      */ import java.net.InetSocketAddress;
/*      */ import java.net.SocketAddress;
/*      */ import java.util.Collection;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import java.util.UUID;
/*      */ import net.minecraft.server.v1_7_R4.AttributeMapServer;
/*      */ import net.minecraft.server.v1_7_R4.AttributeModifiable;
/*      */ import net.minecraft.server.v1_7_R4.ChunkCoordinates;
/*      */ import net.minecraft.server.v1_7_R4.Container;
/*      */ import net.minecraft.server.v1_7_R4.Entity;
/*      */ import net.minecraft.server.v1_7_R4.EntityHuman;
/*      */ import net.minecraft.server.v1_7_R4.EntityLiving;
/*      */ import net.minecraft.server.v1_7_R4.EntityPlayer;
/*      */ import net.minecraft.server.v1_7_R4.EntityTracker;
/*      */ import net.minecraft.server.v1_7_R4.EntityTrackerEntry;
/*      */ import net.minecraft.server.v1_7_R4.IAttribute;
/*      */ import net.minecraft.server.v1_7_R4.NBTTagCompound;
/*      */ import net.minecraft.server.v1_7_R4.Packet;
/*      */ import net.minecraft.server.v1_7_R4.PacketPlayOutBlockChange;
/*      */ import net.minecraft.server.v1_7_R4.PacketPlayOutCustomPayload;
/*      */ import net.minecraft.server.v1_7_R4.PacketPlayOutMap;
/*      */ import net.minecraft.server.v1_7_R4.PacketPlayOutNamedSoundEffect;
/*      */ import net.minecraft.server.v1_7_R4.PacketPlayOutPlayerInfo;
/*      */ import net.minecraft.server.v1_7_R4.PacketPlayOutWorldEvent;
/*      */ import net.minecraft.server.v1_7_R4.PlayerConnection;
/*      */ import net.minecraft.server.v1_7_R4.Statistic;
/*      */ import net.minecraft.server.v1_7_R4.World;
/*      */ import net.minecraft.server.v1_7_R4.WorldServer;
/*      */ import org.apache.commons.lang.Validate;
/*      */ import org.bukkit.Achievement;
/*      */ import org.bukkit.BanList;
/*      */ import org.bukkit.Effect;
/*      */ import org.bukkit.GameMode;
/*      */ import org.bukkit.Location;
/*      */ import org.bukkit.Material;
/*      */ import org.bukkit.OfflinePlayer;
/*      */ import org.bukkit.Sound;
/*      */ import org.bukkit.Statistic;
/*      */ import org.bukkit.WeatherType;
/*      */ import org.bukkit.World;
/*      */ import org.bukkit.conversations.Conversation;
/*      */ import org.bukkit.conversations.ConversationAbandonedEvent;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.CraftServer;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.CraftStatistic;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.CraftWorld;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.conversations.ConversationTracker;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.map.RenderData;
/*      */ import org.bukkit.entity.EntityType;
/*      */ import org.bukkit.entity.Player;
/*      */ import org.bukkit.event.Event;
/*      */ import org.bukkit.event.player.PlayerGameModeChangeEvent;
/*      */ import org.bukkit.event.player.PlayerTeleportEvent;
/*      */ import org.bukkit.inventory.InventoryView;
/*      */ import org.bukkit.map.MapView;
/*      */ import org.bukkit.metadata.MetadataValue;
/*      */ import org.bukkit.plugin.Plugin;
/*      */ import org.bukkit.scoreboard.Scoreboard;
/*      */ 
/*      */ @DelegateDeserialization(CraftOfflinePlayer.class)
/*      */ public class CraftPlayer extends CraftHumanEntity implements Player {
/*   64 */   private long firstPlayed = 0L;
/*   65 */   private long lastPlayed = 0L;
/*      */   private boolean hasPlayedBefore = false;
/*   67 */   private final ConversationTracker conversationTracker = new ConversationTracker();
/*   68 */   private final Set<String> channels = new HashSet<String>();
/*   69 */   private final Set<UUID> hiddenPlayers = new HashSet<UUID>();
/*   70 */   private int hash = 0;
/*   71 */   private double health = 20.0D;
/*      */   private boolean scaledHealth = false;
/*   73 */   private double healthScale = 20.0D;
/*      */   
/*      */   public CraftPlayer(CraftServer server, EntityPlayer entity) {
/*   76 */     super(server, (EntityHuman)entity);
/*      */     
/*   78 */     this.firstPlayed = System.currentTimeMillis();
/*      */   }
/*      */   
/*      */   public GameProfile getProfile() {
/*   82 */     return getHandle().getProfile();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isOp() {
/*   87 */     return this.server.getHandle().isOp(getProfile());
/*      */   }
/*      */ 
/*      */   
/*      */   public void setOp(boolean value) {
/*   92 */     if (value == isOp())
/*      */       return; 
/*   94 */     if (value) {
/*   95 */       this.server.getHandle().addOp(getProfile());
/*      */     } else {
/*   97 */       this.server.getHandle().removeOp(getProfile());
/*      */     } 
/*      */     
/*  100 */     this.perm.recalculatePermissions();
/*      */   }
/*      */   
/*      */   public boolean isOnline() {
/*  104 */     for (Object obj : (this.server.getHandle()).players) {
/*  105 */       EntityPlayer player = (EntityPlayer)obj;
/*  106 */       if (player.getName().equalsIgnoreCase(getName())) {
/*  107 */         return true;
/*      */       }
/*      */     } 
/*  110 */     return false;
/*      */   }
/*      */   
/*      */   public InetSocketAddress getAddress() {
/*  114 */     if ((getHandle()).playerConnection == null) return null;
/*      */     
/*  116 */     SocketAddress addr = (getHandle()).playerConnection.networkManager.getSocketAddress();
/*  117 */     if (addr instanceof InetSocketAddress) {
/*  118 */       return (InetSocketAddress)addr;
/*      */     }
/*  120 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public double getEyeHeight() {
/*  126 */     return getEyeHeight(false);
/*      */   }
/*      */ 
/*      */   
/*      */   public double getEyeHeight(boolean ignoreSneaking) {
/*  131 */     if (ignoreSneaking) {
/*  132 */       return 1.62D;
/*      */     }
/*  134 */     if (isSneaking()) {
/*  135 */       return 1.54D;
/*      */     }
/*  137 */     return 1.62D;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void sendRawMessage(String message) {
/*  144 */     if ((getHandle()).playerConnection == null)
/*      */       return; 
/*  146 */     for (IChatBaseComponent component : CraftChatMessage.fromString(message)) {
/*  147 */       (getHandle()).playerConnection.sendPacket((Packet)new PacketPlayOutChat(component));
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void sendMessage(String message) {
/*  153 */     if (!this.conversationTracker.isConversingModaly()) {
/*  154 */       sendRawMessage(message);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void sendMessage(String[] messages) {
/*  160 */     for (String message : messages) {
/*  161 */       sendMessage(message);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public String getDisplayName() {
/*  167 */     return (getHandle()).displayName;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDisplayName(String name) {
/*  172 */     (getHandle()).displayName = (name == null) ? getName() : name;
/*      */   }
/*      */ 
/*      */   
/*      */   public String getPlayerListName() {
/*  177 */     return (getHandle()).listName;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setPlayerListName(String name) {
/*  182 */     String oldName = (getHandle()).listName;
/*      */     
/*  184 */     if (name == null) {
/*  185 */       name = getName();
/*      */     }
/*      */     
/*  188 */     if (oldName.equals(name)) {
/*      */       return;
/*      */     }
/*      */     
/*  192 */     if (name.length() > 16) {
/*  193 */       throw new IllegalArgumentException("Player list names can only be a maximum of 16 characters long");
/*      */     }
/*      */ 
/*      */     
/*  197 */     for (int i = 0; i < (this.server.getHandle()).players.size(); i++) {
/*  198 */       if (((EntityPlayer)(this.server.getHandle()).players.get(i)).listName.equals(name)) {
/*  199 */         throw new IllegalArgumentException(name + " is already assigned as a player list name for someone");
/*      */       }
/*      */     } 
/*      */     
/*  203 */     (getHandle()).listName = name;
/*      */ 
/*      */     
/*  206 */     PacketPlayOutPlayerInfo oldpacket = new PacketPlayOutPlayerInfo(oldName, false, 9999);
/*  207 */     PacketPlayOutPlayerInfo packet = new PacketPlayOutPlayerInfo(name, true, (getHandle()).ping);
/*  208 */     for (int j = 0; j < (this.server.getHandle()).players.size(); j++) {
/*  209 */       EntityPlayer entityplayer = (this.server.getHandle()).players.get(j);
/*  210 */       if (entityplayer.playerConnection != null)
/*      */       {
/*  212 */         if (entityplayer.getBukkitEntity().canSee(this)) {
/*  213 */           entityplayer.playerConnection.sendPacket((Packet)oldpacket);
/*  214 */           entityplayer.playerConnection.sendPacket((Packet)packet);
/*      */         } 
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean equals(Object obj) {
/*  221 */     if (!(obj instanceof OfflinePlayer)) {
/*  222 */       return false;
/*      */     }
/*  224 */     OfflinePlayer other = (OfflinePlayer)obj;
/*  225 */     if (getUniqueId() == null || other.getUniqueId() == null) {
/*  226 */       return false;
/*      */     }
/*      */     
/*  229 */     boolean uuidEquals = getUniqueId().equals(other.getUniqueId());
/*  230 */     boolean idEquals = true;
/*      */     
/*  232 */     if (other instanceof CraftPlayer) {
/*  233 */       idEquals = (getEntityId() == ((CraftPlayer)other).getEntityId());
/*      */     }
/*      */     
/*  236 */     return (uuidEquals && idEquals);
/*      */   }
/*      */ 
/*      */   
/*      */   public void kickPlayer(String message) {
/*  241 */     if ((getHandle()).playerConnection == null)
/*      */       return; 
/*  243 */     (getHandle()).playerConnection.disconnect((message == null) ? "" : message);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setCompassTarget(Location loc) {
/*  248 */     if ((getHandle()).playerConnection == null) {
/*      */       return;
/*      */     }
/*  251 */     (getHandle()).playerConnection.sendPacket((Packet)new PacketPlayOutSpawnPosition(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ()));
/*      */   }
/*      */ 
/*      */   
/*      */   public Location getCompassTarget() {
/*  256 */     return (getHandle()).compassTarget;
/*      */   }
/*      */ 
/*      */   
/*      */   public void chat(String msg) {
/*  261 */     if ((getHandle()).playerConnection == null)
/*      */       return; 
/*  263 */     (getHandle()).playerConnection.chat(msg, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean performCommand(String command) {
/*  268 */     return this.server.dispatchCommand((CommandSender)this, command);
/*      */   }
/*      */ 
/*      */   
/*      */   public void playNote(Location loc, byte instrument, byte note) {
/*  273 */     if ((getHandle()).playerConnection == null)
/*      */       return; 
/*  275 */     String instrumentName = null;
/*  276 */     switch (instrument) {
/*      */       case 0:
/*  278 */         instrumentName = "harp";
/*      */         break;
/*      */       case 1:
/*  281 */         instrumentName = "bd";
/*      */         break;
/*      */       case 2:
/*  284 */         instrumentName = "snare";
/*      */         break;
/*      */       case 3:
/*  287 */         instrumentName = "hat";
/*      */         break;
/*      */       case 4:
/*  290 */         instrumentName = "bassattack";
/*      */         break;
/*      */     } 
/*  293 */     (getHandle()).playerConnection.sendPacket((Packet)new PacketPlayOutNamedSoundEffect("note." + instrumentName, loc.getBlockX(), loc.getBlockY(), loc.getBlockZ(), 3.0F, note));
/*      */   }
/*      */ 
/*      */   
/*      */   public void playNote(Location loc, Instrument instrument, Note note) {
/*  298 */     if ((getHandle()).playerConnection == null)
/*      */       return; 
/*  300 */     String instrumentName = null;
/*  301 */     switch (instrument.ordinal()) {
/*      */       case 0:
/*  303 */         instrumentName = "harp";
/*      */         break;
/*      */       case 1:
/*  306 */         instrumentName = "bd";
/*      */         break;
/*      */       case 2:
/*  309 */         instrumentName = "snare";
/*      */         break;
/*      */       case 3:
/*  312 */         instrumentName = "hat";
/*      */         break;
/*      */       case 4:
/*  315 */         instrumentName = "bassattack";
/*      */         break;
/*      */     } 
/*  318 */     (getHandle()).playerConnection.sendPacket((Packet)new PacketPlayOutNamedSoundEffect("note." + instrumentName, loc.getBlockX(), loc.getBlockY(), loc.getBlockZ(), 3.0F, note.getId()));
/*      */   }
/*      */ 
/*      */   
/*      */   public void playSound(Location loc, Sound sound, float volume, float pitch) {
/*  323 */     if (sound == null) {
/*      */       return;
/*      */     }
/*  326 */     playSound(loc, CraftSound.getSound(sound), volume, pitch);
/*      */   }
/*      */ 
/*      */   
/*      */   public void playSound(Location loc, String sound, float volume, float pitch) {
/*  331 */     if (loc == null || sound == null || (getHandle()).playerConnection == null)
/*      */       return; 
/*  333 */     double x = loc.getBlockX() + 0.5D;
/*  334 */     double y = loc.getBlockY() + 0.5D;
/*  335 */     double z = loc.getBlockZ() + 0.5D;
/*      */     
/*  337 */     PacketPlayOutNamedSoundEffect packet = new PacketPlayOutNamedSoundEffect(sound, x, y, z, volume, pitch);
/*  338 */     (getHandle()).playerConnection.sendPacket((Packet)packet);
/*      */   }
/*      */ 
/*      */   
/*      */   public void playEffect(Location loc, Effect effect, int data) {
/*  343 */     if ((getHandle()).playerConnection == null)
/*      */       return; 
/*  345 */     int packetData = effect.getId();
/*  346 */     PacketPlayOutWorldEvent packet = new PacketPlayOutWorldEvent(packetData, loc.getBlockX(), loc.getBlockY(), loc.getBlockZ(), data, false);
/*  347 */     (getHandle()).playerConnection.sendPacket((Packet)packet);
/*      */   }
/*      */ 
/*      */   
/*      */   public <T> void playEffect(Location loc, Effect effect, T data) {
/*  352 */     if (data != null) {
/*  353 */       Validate.isTrue(data.getClass().equals(effect.getData()), "Wrong kind of data for this effect!");
/*      */     } else {
/*  355 */       Validate.isTrue((effect.getData() == null), "Wrong kind of data for this effect!");
/*      */     } 
/*      */     
/*  358 */     int datavalue = (data == null) ? 0 : CraftEffect.getDataValue(effect, data);
/*  359 */     playEffect(loc, effect, datavalue);
/*      */   }
/*      */ 
/*      */   
/*      */   public void sendBlockChange(Location loc, Material material, byte data) {
/*  364 */     sendBlockChange(loc, material.getId(), data);
/*      */   }
/*      */ 
/*      */   
/*      */   public void sendBlockChange(Location loc, int material, byte data) {
/*  369 */     if ((getHandle()).playerConnection == null)
/*      */       return; 
/*  371 */     PacketPlayOutBlockChange packet = new PacketPlayOutBlockChange(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ(), (World)((CraftWorld)loc.getWorld()).getHandle());
/*      */     
/*  373 */     packet.block = CraftMagicNumbers.getBlock(material);
/*  374 */     packet.data = data;
/*  375 */     (getHandle()).playerConnection.sendPacket((Packet)packet);
/*      */   }
/*      */ 
/*      */   
/*      */   public void sendSignChange(Location loc, String[] lines) {
/*  380 */     if ((getHandle()).playerConnection == null) {
/*      */       return;
/*      */     }
/*      */     
/*  384 */     if (lines == null) {
/*  385 */       lines = new String[4];
/*      */     }
/*      */     
/*  388 */     Validate.notNull(loc, "Location can not be null");
/*  389 */     if (lines.length < 4) {
/*  390 */       throw new IllegalArgumentException("Must have at least 4 lines");
/*      */     }
/*      */ 
/*      */     
/*  394 */     String[] astring = CraftSign.sanitizeLines(lines);
/*      */     
/*  396 */     (getHandle()).playerConnection.sendPacket((Packet)new PacketPlayOutUpdateSign(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ(), astring));
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean sendChunkChange(Location loc, int sx, int sy, int sz, byte[] data) {
/*  401 */     if ((getHandle()).playerConnection == null) return false;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  430 */     throw new NotImplementedException("Chunk changes do not yet work");
/*      */   }
/*      */ 
/*      */   
/*      */   public void sendMap(MapView map) {
/*  435 */     if ((getHandle()).playerConnection == null)
/*      */       return; 
/*  437 */     RenderData data = ((CraftMapView)map).render(this);
/*  438 */     for (int x = 0; x < 128; x++) {
/*  439 */       byte[] bytes = new byte[131];
/*  440 */       bytes[1] = (byte)x;
/*  441 */       for (int y = 0; y < 128; y++) {
/*  442 */         bytes[y + 3] = data.buffer[y * 128 + x];
/*      */       }
/*  444 */       PacketPlayOutMap packet = new PacketPlayOutMap(map.getId(), bytes);
/*  445 */       (getHandle()).playerConnection.sendPacket((Packet)packet);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean teleport(Location location, PlayerTeleportEvent.TeleportCause cause) {
/*  451 */     EntityPlayer entity = getHandle();
/*      */     
/*  453 */     if (getHealth() == 0.0D || entity.dead) {
/*  454 */       return false;
/*      */     }
/*      */     
/*  457 */     if (entity.playerConnection == null || entity.playerConnection.isDisconnected()) {
/*  458 */       return false;
/*      */     }
/*      */     
/*  461 */     if (entity.vehicle != null || entity.passenger != null) {
/*  462 */       return false;
/*      */     }
/*      */ 
/*      */     
/*  466 */     Location from = getLocation();
/*      */     
/*  468 */     Location to = location;
/*      */     
/*  470 */     PlayerTeleportEvent event = new PlayerTeleportEvent(this, from, to, cause);
/*  471 */     this.server.getPluginManager().callEvent((Event)event);
/*      */ 
/*      */     
/*  474 */     if (event.isCancelled()) {
/*  475 */       return false;
/*      */     }
/*      */ 
/*      */     
/*  479 */     from = event.getFrom();
/*      */     
/*  481 */     to = event.getTo();
/*      */     
/*  483 */     WorldServer fromWorld = ((CraftWorld)from.getWorld()).getHandle();
/*  484 */     WorldServer toWorld = ((CraftWorld)to.getWorld()).getHandle();
/*      */ 
/*      */     
/*  487 */     if ((getHandle()).activeContainer != (getHandle()).defaultContainer) {
/*  488 */       getHandle().closeInventory();
/*      */     }
/*      */ 
/*      */     
/*  492 */     if (fromWorld == toWorld) {
/*  493 */       entity.playerConnection.teleport(to);
/*      */     } else {
/*  495 */       this.server.getHandle().moveToWorld(entity, toWorld.dimension, true, to, true);
/*      */     } 
/*  497 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setSneaking(boolean sneak) {
/*  502 */     getHandle().setSneaking(sneak);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isSneaking() {
/*  507 */     return getHandle().isSneaking();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isSprinting() {
/*  512 */     return getHandle().isSprinting();
/*      */   }
/*      */ 
/*      */   
/*      */   public void setSprinting(boolean sprinting) {
/*  517 */     getHandle().setSprinting(sprinting);
/*      */   }
/*      */ 
/*      */   
/*      */   public void loadData() {
/*  522 */     (this.server.getHandle()).playerFileData.load((EntityHuman)getHandle());
/*      */   }
/*      */ 
/*      */   
/*      */   public void saveData() {
/*  527 */     (this.server.getHandle()).playerFileData.save((EntityHuman)getHandle());
/*      */   }
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void updateInventory() {
/*  533 */     getHandle().updateInventory((getHandle()).activeContainer);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setSleepingIgnored(boolean isSleeping) {
/*  538 */     (getHandle()).fauxSleeping = isSleeping;
/*  539 */     ((CraftWorld)getWorld()).getHandle().checkSleepStatus();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isSleepingIgnored() {
/*  544 */     return (getHandle()).fauxSleeping;
/*      */   }
/*      */ 
/*      */   
/*      */   public void awardAchievement(Achievement achievement) {
/*  549 */     Validate.notNull(achievement, "Achievement cannot be null");
/*  550 */     if (achievement.hasParent() && !hasAchievement(achievement.getParent())) {
/*  551 */       awardAchievement(achievement.getParent());
/*      */     }
/*  553 */     getHandle().getStatisticManager().setStatistic((EntityHuman)getHandle(), (Statistic)CraftStatistic.getNMSAchievement(achievement), 1);
/*  554 */     getHandle().getStatisticManager().updateStatistics(getHandle());
/*      */   }
/*      */ 
/*      */   
/*      */   public void removeAchievement(Achievement achievement) {
/*  559 */     Validate.notNull(achievement, "Achievement cannot be null");
/*  560 */     for (Achievement achieve : Achievement.values()) {
/*  561 */       if (achieve.getParent() == achievement && hasAchievement(achieve)) {
/*  562 */         removeAchievement(achieve);
/*      */       }
/*      */     } 
/*  565 */     getHandle().getStatisticManager().setStatistic((EntityHuman)getHandle(), (Statistic)CraftStatistic.getNMSAchievement(achievement), 0);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean hasAchievement(Achievement achievement) {
/*  570 */     Validate.notNull(achievement, "Achievement cannot be null");
/*  571 */     return getHandle().getStatisticManager().hasAchievement(CraftStatistic.getNMSAchievement(achievement));
/*      */   }
/*      */ 
/*      */   
/*      */   public void incrementStatistic(Statistic statistic) {
/*  576 */     incrementStatistic(statistic, 1);
/*      */   }
/*      */ 
/*      */   
/*      */   public void decrementStatistic(Statistic statistic) {
/*  581 */     decrementStatistic(statistic, 1);
/*      */   }
/*      */ 
/*      */   
/*      */   public int getStatistic(Statistic statistic) {
/*  586 */     Validate.notNull(statistic, "Statistic cannot be null");
/*  587 */     Validate.isTrue((statistic.getType() == Statistic.Type.UNTYPED), "Must supply additional paramater for this statistic");
/*  588 */     return getHandle().getStatisticManager().getStatisticValue(CraftStatistic.getNMSStatistic(statistic));
/*      */   }
/*      */ 
/*      */   
/*      */   public void incrementStatistic(Statistic statistic, int amount) {
/*  593 */     Validate.isTrue((amount > 0), "Amount must be greater than 0");
/*  594 */     setStatistic(statistic, getStatistic(statistic) + amount);
/*      */   }
/*      */ 
/*      */   
/*      */   public void decrementStatistic(Statistic statistic, int amount) {
/*  599 */     Validate.isTrue((amount > 0), "Amount must be greater than 0");
/*  600 */     setStatistic(statistic, getStatistic(statistic) - amount);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setStatistic(Statistic statistic, int newValue) {
/*  605 */     Validate.notNull(statistic, "Statistic cannot be null");
/*  606 */     Validate.isTrue((statistic.getType() == Statistic.Type.UNTYPED), "Must supply additional paramater for this statistic");
/*  607 */     Validate.isTrue((newValue >= 0), "Value must be greater than or equal to 0");
/*  608 */     Statistic nmsStatistic = CraftStatistic.getNMSStatistic(statistic);
/*  609 */     getHandle().getStatisticManager().setStatistic((EntityHuman)getHandle(), nmsStatistic, newValue);
/*      */   }
/*      */ 
/*      */   
/*      */   public void incrementStatistic(Statistic statistic, Material material) {
/*  614 */     incrementStatistic(statistic, material, 1);
/*      */   }
/*      */ 
/*      */   
/*      */   public void decrementStatistic(Statistic statistic, Material material) {
/*  619 */     decrementStatistic(statistic, material, 1);
/*      */   }
/*      */ 
/*      */   
/*      */   public int getStatistic(Statistic statistic, Material material) {
/*  624 */     Validate.notNull(statistic, "Statistic cannot be null");
/*  625 */     Validate.notNull(material, "Material cannot be null");
/*  626 */     Validate.isTrue((statistic.getType() == Statistic.Type.BLOCK || statistic.getType() == Statistic.Type.ITEM), "This statistic does not take a Material parameter");
/*  627 */     Statistic nmsStatistic = CraftStatistic.getMaterialStatistic(statistic, material);
/*  628 */     Validate.notNull(nmsStatistic, "The supplied Material does not have a corresponding statistic");
/*  629 */     return getHandle().getStatisticManager().getStatisticValue(nmsStatistic);
/*      */   }
/*      */ 
/*      */   
/*      */   public void incrementStatistic(Statistic statistic, Material material, int amount) {
/*  634 */     Validate.isTrue((amount > 0), "Amount must be greater than 0");
/*  635 */     setStatistic(statistic, material, getStatistic(statistic, material) + amount);
/*      */   }
/*      */ 
/*      */   
/*      */   public void decrementStatistic(Statistic statistic, Material material, int amount) {
/*  640 */     Validate.isTrue((amount > 0), "Amount must be greater than 0");
/*  641 */     setStatistic(statistic, material, getStatistic(statistic, material) - amount);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setStatistic(Statistic statistic, Material material, int newValue) {
/*  646 */     Validate.notNull(statistic, "Statistic cannot be null");
/*  647 */     Validate.notNull(material, "Material cannot be null");
/*  648 */     Validate.isTrue((newValue >= 0), "Value must be greater than or equal to 0");
/*  649 */     Validate.isTrue((statistic.getType() == Statistic.Type.BLOCK || statistic.getType() == Statistic.Type.ITEM), "This statistic does not take a Material parameter");
/*  650 */     Statistic nmsStatistic = CraftStatistic.getMaterialStatistic(statistic, material);
/*  651 */     Validate.notNull(nmsStatistic, "The supplied Material does not have a corresponding statistic");
/*  652 */     getHandle().getStatisticManager().setStatistic((EntityHuman)getHandle(), nmsStatistic, newValue);
/*      */   }
/*      */ 
/*      */   
/*      */   public void incrementStatistic(Statistic statistic, EntityType entityType) {
/*  657 */     incrementStatistic(statistic, entityType, 1);
/*      */   }
/*      */ 
/*      */   
/*      */   public void decrementStatistic(Statistic statistic, EntityType entityType) {
/*  662 */     decrementStatistic(statistic, entityType, 1);
/*      */   }
/*      */ 
/*      */   
/*      */   public int getStatistic(Statistic statistic, EntityType entityType) {
/*  667 */     Validate.notNull(statistic, "Statistic cannot be null");
/*  668 */     Validate.notNull(entityType, "EntityType cannot be null");
/*  669 */     Validate.isTrue((statistic.getType() == Statistic.Type.ENTITY), "This statistic does not take an EntityType parameter");
/*  670 */     Statistic nmsStatistic = CraftStatistic.getEntityStatistic(statistic, entityType);
/*  671 */     Validate.notNull(nmsStatistic, "The supplied EntityType does not have a corresponding statistic");
/*  672 */     return getHandle().getStatisticManager().getStatisticValue(nmsStatistic);
/*      */   }
/*      */ 
/*      */   
/*      */   public void incrementStatistic(Statistic statistic, EntityType entityType, int amount) {
/*  677 */     Validate.isTrue((amount > 0), "Amount must be greater than 0");
/*  678 */     setStatistic(statistic, entityType, getStatistic(statistic, entityType) + amount);
/*      */   }
/*      */ 
/*      */   
/*      */   public void decrementStatistic(Statistic statistic, EntityType entityType, int amount) {
/*  683 */     Validate.isTrue((amount > 0), "Amount must be greater than 0");
/*  684 */     setStatistic(statistic, entityType, getStatistic(statistic, entityType) - amount);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setStatistic(Statistic statistic, EntityType entityType, int newValue) {
/*  689 */     Validate.notNull(statistic, "Statistic cannot be null");
/*  690 */     Validate.notNull(entityType, "EntityType cannot be null");
/*  691 */     Validate.isTrue((newValue >= 0), "Value must be greater than or equal to 0");
/*  692 */     Validate.isTrue((statistic.getType() == Statistic.Type.ENTITY), "This statistic does not take an EntityType parameter");
/*  693 */     Statistic nmsStatistic = CraftStatistic.getEntityStatistic(statistic, entityType);
/*  694 */     Validate.notNull(nmsStatistic, "The supplied EntityType does not have a corresponding statistic");
/*  695 */     getHandle().getStatisticManager().setStatistic((EntityHuman)getHandle(), nmsStatistic, newValue);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setPlayerTime(long time, boolean relative) {
/*  700 */     (getHandle()).timeOffset = time;
/*  701 */     (getHandle()).relativeTime = relative;
/*      */   }
/*      */ 
/*      */   
/*      */   public long getPlayerTimeOffset() {
/*  706 */     return (getHandle()).timeOffset;
/*      */   }
/*      */ 
/*      */   
/*      */   public long getPlayerTime() {
/*  711 */     return getHandle().getPlayerTime();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isPlayerTimeRelative() {
/*  716 */     return (getHandle()).relativeTime;
/*      */   }
/*      */ 
/*      */   
/*      */   public void resetPlayerTime() {
/*  721 */     setPlayerTime(0L, true);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setPlayerWeather(WeatherType type) {
/*  726 */     getHandle().setPlayerWeather(type, true);
/*      */   }
/*      */ 
/*      */   
/*      */   public WeatherType getPlayerWeather() {
/*  731 */     return getHandle().getPlayerWeather();
/*      */   }
/*      */ 
/*      */   
/*      */   public void resetPlayerWeather() {
/*  736 */     getHandle().resetPlayerWeather();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isBanned() {
/*  741 */     return this.server.getBanList(BanList.Type.NAME).isBanned(getName());
/*      */   }
/*      */ 
/*      */   
/*      */   public void setBanned(boolean value) {
/*  746 */     if (value) {
/*  747 */       this.server.getBanList(BanList.Type.NAME).addBan(getName(), null, null, null);
/*      */     } else {
/*  749 */       this.server.getBanList(BanList.Type.NAME).pardon(getName());
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isWhitelisted() {
/*  755 */     return this.server.getHandle().getWhitelist().isWhitelisted(getProfile());
/*      */   }
/*      */ 
/*      */   
/*      */   public void setWhitelisted(boolean value) {
/*  760 */     if (value) {
/*  761 */       this.server.getHandle().addWhitelist(getProfile());
/*      */     } else {
/*  763 */       this.server.getHandle().removeWhitelist(getProfile());
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setGameMode(GameMode mode) {
/*  769 */     if ((getHandle()).playerConnection == null)
/*      */       return; 
/*  771 */     if (mode == null) {
/*  772 */       throw new IllegalArgumentException("Mode cannot be null");
/*      */     }
/*      */     
/*  775 */     if (mode != getGameMode()) {
/*  776 */       PlayerGameModeChangeEvent event = new PlayerGameModeChangeEvent(this, mode);
/*  777 */       this.server.getPluginManager().callEvent((Event)event);
/*  778 */       if (event.isCancelled()) {
/*      */         return;
/*      */       }
/*      */       
/*  782 */       (getHandle()).playerInteractManager.setGameMode(EnumGamemode.getById(mode.getValue()));
/*  783 */       (getHandle()).fallDistance = 0.0F;
/*  784 */       (getHandle()).playerConnection.sendPacket((Packet)new PacketPlayOutGameStateChange(3, mode.getValue()));
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public GameMode getGameMode() {
/*  790 */     return GameMode.getByValue((getHandle()).playerInteractManager.getGameMode().getId());
/*      */   }
/*      */   
/*      */   public void giveExp(int exp) {
/*  794 */     getHandle().giveExp(exp);
/*      */   }
/*      */   
/*      */   public void giveExpLevels(int levels) {
/*  798 */     getHandle().levelDown(levels);
/*      */   }
/*      */   
/*      */   public float getExp() {
/*  802 */     return (getHandle()).exp;
/*      */   }
/*      */   
/*      */   public void setExp(float exp) {
/*  806 */     (getHandle()).exp = exp;
/*  807 */     (getHandle()).lastSentExp = -1;
/*      */   }
/*      */   
/*      */   public int getLevel() {
/*  811 */     return (getHandle()).expLevel;
/*      */   }
/*      */   
/*      */   public void setLevel(int level) {
/*  815 */     (getHandle()).expLevel = level;
/*  816 */     (getHandle()).lastSentExp = -1;
/*      */   }
/*      */   
/*      */   public int getTotalExperience() {
/*  820 */     return (getHandle()).expTotal;
/*      */   }
/*      */   
/*      */   public void setTotalExperience(int exp) {
/*  824 */     (getHandle()).expTotal = exp;
/*      */   }
/*      */   
/*      */   public float getExhaustion() {
/*  828 */     return (getHandle().getFoodData()).exhaustionLevel;
/*      */   }
/*      */   
/*      */   public void setExhaustion(float value) {
/*  832 */     (getHandle().getFoodData()).exhaustionLevel = value;
/*      */   }
/*      */   
/*      */   public float getSaturation() {
/*  836 */     return (getHandle().getFoodData()).saturationLevel;
/*      */   }
/*      */   
/*      */   public void setSaturation(float value) {
/*  840 */     (getHandle().getFoodData()).saturationLevel = value;
/*      */   }
/*      */   
/*      */   public int getFoodLevel() {
/*  844 */     return (getHandle().getFoodData()).foodLevel;
/*      */   }
/*      */   
/*      */   public void setFoodLevel(int value) {
/*  848 */     (getHandle().getFoodData()).foodLevel = value;
/*      */   }
/*      */   
/*      */   public Location getBedSpawnLocation() {
/*  852 */     World world = getServer().getWorld((getHandle()).spawnWorld);
/*  853 */     ChunkCoordinates bed = getHandle().getBed();
/*      */     
/*  855 */     if (world != null && bed != null) {
/*  856 */       bed = EntityHuman.getBed((World)((CraftWorld)world).getHandle(), bed, getHandle().isRespawnForced());
/*  857 */       if (bed != null) {
/*  858 */         return new Location(world, bed.x, bed.y, bed.z);
/*      */       }
/*      */     } 
/*  861 */     return null;
/*      */   }
/*      */   
/*      */   public void setBedSpawnLocation(Location location) {
/*  865 */     setBedSpawnLocation(location, false);
/*      */   }
/*      */   
/*      */   public void setBedSpawnLocation(Location location, boolean override) {
/*  869 */     if (location == null) {
/*  870 */       getHandle().setRespawnPosition(null, override);
/*      */     } else {
/*  872 */       getHandle().setRespawnPosition(new ChunkCoordinates(location.getBlockX(), location.getBlockY(), location.getBlockZ()), override);
/*  873 */       (getHandle()).spawnWorld = location.getWorld().getName();
/*      */     } 
/*      */   }
/*      */   
/*      */   public void hidePlayer(Player player) {
/*  878 */     Validate.notNull(player, "hidden player cannot be null");
/*  879 */     if ((getHandle()).playerConnection == null)
/*  880 */       return;  if (equals(player))
/*  881 */       return;  if (this.hiddenPlayers.contains(player.getUniqueId()))
/*  882 */       return;  this.hiddenPlayers.add(player.getUniqueId());
/*      */ 
/*      */     
/*  885 */     EntityTracker tracker = ((WorldServer)this.entity.world).tracker;
/*  886 */     EntityPlayer other = ((CraftPlayer)player).getHandle();
/*  887 */     EntityTrackerEntry entry = (EntityTrackerEntry)tracker.trackedEntities.get(other.getId());
/*  888 */     if (entry != null) {
/*  889 */       entry.clear(getHandle());
/*      */     }
/*      */ 
/*      */     
/*  893 */     (getHandle()).playerConnection.sendPacket((Packet)new PacketPlayOutPlayerInfo(player.getPlayerListName(), false, 9999));
/*      */   }
/*      */   
/*      */   public void showPlayer(Player player) {
/*  897 */     Validate.notNull(player, "shown player cannot be null");
/*  898 */     if ((getHandle()).playerConnection == null)
/*  899 */       return;  if (equals(player))
/*  900 */       return;  if (!this.hiddenPlayers.contains(player.getUniqueId()))
/*  901 */       return;  this.hiddenPlayers.remove(player.getUniqueId());
/*      */     
/*  903 */     EntityTracker tracker = ((WorldServer)this.entity.world).tracker;
/*  904 */     EntityPlayer other = ((CraftPlayer)player).getHandle();
/*  905 */     EntityTrackerEntry entry = (EntityTrackerEntry)tracker.trackedEntities.get(other.getId());
/*  906 */     if (entry != null && !entry.trackedPlayers.contains(getHandle())) {
/*  907 */       entry.updatePlayer(getHandle());
/*      */     }
/*      */     
/*  910 */     (getHandle()).playerConnection.sendPacket((Packet)new PacketPlayOutPlayerInfo(player.getPlayerListName(), true, (getHandle()).ping));
/*      */   }
/*      */   
/*      */   public void removeDisconnectingPlayer(Player player) {
/*  914 */     this.hiddenPlayers.remove(player.getUniqueId());
/*      */   }
/*      */   
/*      */   public boolean canSee(Player player) {
/*  918 */     return !this.hiddenPlayers.contains(player.getUniqueId());
/*      */   }
/*      */   
/*      */   public Map<String, Object> serialize() {
/*  922 */     Map<String, Object> result = new LinkedHashMap<String, Object>();
/*      */     
/*  924 */     result.put("name", getName());
/*      */     
/*  926 */     return result;
/*      */   }
/*      */   
/*      */   public Player getPlayer() {
/*  930 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public EntityPlayer getHandle() {
/*  935 */     return (EntityPlayer)this.entity;
/*      */   }
/*      */   
/*      */   public void setHandle(EntityPlayer entity) {
/*  939 */     setHandle((EntityHuman)entity);
/*      */   }
/*      */ 
/*      */   
/*      */   public String toString() {
/*  944 */     return "CraftPlayer{name=" + getName() + '}';
/*      */   }
/*      */ 
/*      */   
/*      */   public int hashCode() {
/*  949 */     if (this.hash == 0 || this.hash == 485) {
/*  950 */       this.hash = 485 + ((getUniqueId() != null) ? getUniqueId().hashCode() : 0);
/*      */     }
/*  952 */     return this.hash;
/*      */   }
/*      */   
/*      */   public long getFirstPlayed() {
/*  956 */     return this.firstPlayed;
/*      */   }
/*      */   
/*      */   public long getLastPlayed() {
/*  960 */     return this.lastPlayed;
/*      */   }
/*      */   
/*      */   public boolean hasPlayedBefore() {
/*  964 */     return this.hasPlayedBefore;
/*      */   }
/*      */   
/*      */   public void setFirstPlayed(long firstPlayed) {
/*  968 */     this.firstPlayed = firstPlayed;
/*      */   }
/*      */   
/*      */   public void readExtraData(NBTTagCompound nbttagcompound) {
/*  972 */     this.hasPlayedBefore = true;
/*  973 */     if (nbttagcompound.hasKey("bukkit")) {
/*  974 */       NBTTagCompound data = nbttagcompound.getCompound("bukkit");
/*      */       
/*  976 */       if (data.hasKey("firstPlayed")) {
/*  977 */         this.firstPlayed = data.getLong("firstPlayed");
/*  978 */         this.lastPlayed = data.getLong("lastPlayed");
/*      */       } 
/*      */       
/*  981 */       if (data.hasKey("newExp")) {
/*  982 */         EntityPlayer handle = getHandle();
/*  983 */         handle.newExp = data.getInt("newExp");
/*  984 */         handle.newTotalExp = data.getInt("newTotalExp");
/*  985 */         handle.newLevel = data.getInt("newLevel");
/*  986 */         handle.expToDrop = data.getInt("expToDrop");
/*  987 */         handle.keepLevel = data.getBoolean("keepLevel");
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void setExtraData(NBTTagCompound nbttagcompound) {
/*  993 */     if (!nbttagcompound.hasKey("bukkit")) {
/*  994 */       nbttagcompound.set("bukkit", (NBTBase)new NBTTagCompound());
/*      */     }
/*      */     
/*  997 */     NBTTagCompound data = nbttagcompound.getCompound("bukkit");
/*  998 */     EntityPlayer handle = getHandle();
/*  999 */     data.setInt("newExp", handle.newExp);
/* 1000 */     data.setInt("newTotalExp", handle.newTotalExp);
/* 1001 */     data.setInt("newLevel", handle.newLevel);
/* 1002 */     data.setInt("expToDrop", handle.expToDrop);
/* 1003 */     data.setBoolean("keepLevel", handle.keepLevel);
/* 1004 */     data.setLong("firstPlayed", getFirstPlayed());
/* 1005 */     data.setLong("lastPlayed", System.currentTimeMillis());
/* 1006 */     data.setString("lastKnownName", handle.getName());
/*      */   }
/*      */   
/*      */   public boolean beginConversation(Conversation conversation) {
/* 1010 */     return this.conversationTracker.beginConversation(conversation);
/*      */   }
/*      */   
/*      */   public void abandonConversation(Conversation conversation) {
/* 1014 */     this.conversationTracker.abandonConversation(conversation, new ConversationAbandonedEvent(conversation, (ConversationCanceller)new ManuallyAbandonedConversationCanceller()));
/*      */   }
/*      */   
/*      */   public void abandonConversation(Conversation conversation, ConversationAbandonedEvent details) {
/* 1018 */     this.conversationTracker.abandonConversation(conversation, details);
/*      */   }
/*      */   
/*      */   public void acceptConversationInput(String input) {
/* 1022 */     this.conversationTracker.acceptConversationInput(input);
/*      */   }
/*      */   
/*      */   public boolean isConversing() {
/* 1026 */     return this.conversationTracker.isConversing();
/*      */   }
/*      */   
/*      */   public void sendPluginMessage(Plugin source, String channel, byte[] message) {
/* 1030 */     StandardMessenger.validatePluginMessage(this.server.getMessenger(), source, channel, message);
/* 1031 */     if ((getHandle()).playerConnection == null)
/*      */       return; 
/* 1033 */     if (this.channels.contains(channel)) {
/* 1034 */       PacketPlayOutCustomPayload packet = new PacketPlayOutCustomPayload(channel, message);
/* 1035 */       (getHandle()).playerConnection.sendPacket((Packet)packet);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void setTexturePack(String url) {
/* 1040 */     setResourcePack(url);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setResourcePack(String url) {
/* 1045 */     Validate.notNull(url, "Resource pack URL cannot be null");
/*      */     
/* 1047 */     getHandle().setResourcePack(url);
/*      */   }
/*      */   
/*      */   public void addChannel(String channel) {
/* 1051 */     if (this.channels.add(channel)) {
/* 1052 */       this.server.getPluginManager().callEvent((Event)new PlayerRegisterChannelEvent(this, channel));
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeChannel(String channel) {
/* 1057 */     if (this.channels.remove(channel)) {
/* 1058 */       this.server.getPluginManager().callEvent((Event)new PlayerUnregisterChannelEvent(this, channel));
/*      */     }
/*      */   }
/*      */   
/*      */   public Set<String> getListeningPluginChannels() {
/* 1063 */     return (Set<String>)ImmutableSet.copyOf(this.channels);
/*      */   }
/*      */   
/*      */   public void sendSupportedChannels() {
/* 1067 */     if ((getHandle()).playerConnection == null)
/* 1068 */       return;  Set<String> listening = this.server.getMessenger().getIncomingChannels();
/*      */     
/* 1070 */     if (!listening.isEmpty()) {
/* 1071 */       ByteArrayOutputStream stream = new ByteArrayOutputStream();
/*      */       
/* 1073 */       for (String channel : listening) {
/*      */         try {
/* 1075 */           stream.write(channel.getBytes("UTF8"));
/* 1076 */           stream.write(0);
/* 1077 */         } catch (IOException ex) {
/* 1078 */           Logger.getLogger(CraftPlayer.class.getName()).log(Level.SEVERE, "Could not send Plugin Channel REGISTER to " + getName(), ex);
/*      */         } 
/*      */       } 
/*      */       
/* 1082 */       (getHandle()).playerConnection.sendPacket((Packet)new PacketPlayOutCustomPayload("REGISTER", stream.toByteArray()));
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public EntityType getType() {
/* 1088 */     return EntityType.PLAYER;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setMetadata(String metadataKey, MetadataValue newMetadataValue) {
/* 1093 */     this.server.getPlayerMetadata().setMetadata(this, metadataKey, newMetadataValue);
/*      */   }
/*      */ 
/*      */   
/*      */   public List<MetadataValue> getMetadata(String metadataKey) {
/* 1098 */     return this.server.getPlayerMetadata().getMetadata(this, metadataKey);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean hasMetadata(String metadataKey) {
/* 1103 */     return this.server.getPlayerMetadata().hasMetadata(this, metadataKey);
/*      */   }
/*      */ 
/*      */   
/*      */   public void removeMetadata(String metadataKey, Plugin owningPlugin) {
/* 1108 */     this.server.getPlayerMetadata().removeMetadata(this, metadataKey, owningPlugin);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean setWindowProperty(InventoryView.Property prop, int value) {
/* 1113 */     Container container = (getHandle()).activeContainer;
/* 1114 */     if (container.getBukkitView().getType() != prop.getType()) {
/* 1115 */       return false;
/*      */     }
/* 1117 */     getHandle().setContainerData(container, prop.getId(), value);
/* 1118 */     return true;
/*      */   }
/*      */   
/*      */   public void disconnect(String reason) {
/* 1122 */     this.conversationTracker.abandonAllConversations();
/* 1123 */     this.perm.clearPermissions();
/*      */   }
/*      */   
/*      */   public boolean isFlying() {
/* 1127 */     return (getHandle()).abilities.isFlying;
/*      */   }
/*      */   
/*      */   public void setFlying(boolean value) {
/* 1131 */     if (!getAllowFlight() && value) {
/* 1132 */       throw new IllegalArgumentException("Cannot make player fly if getAllowFlight() is false");
/*      */     }
/*      */     
/* 1135 */     (getHandle()).abilities.isFlying = value;
/* 1136 */     getHandle().updateAbilities();
/*      */   }
/*      */   
/*      */   public boolean getAllowFlight() {
/* 1140 */     return (getHandle()).abilities.canFly;
/*      */   }
/*      */   
/*      */   public void setAllowFlight(boolean value) {
/* 1144 */     if (isFlying() && !value) {
/* 1145 */       (getHandle()).abilities.isFlying = false;
/*      */     }
/*      */     
/* 1148 */     (getHandle()).abilities.canFly = value;
/* 1149 */     getHandle().updateAbilities();
/*      */   }
/*      */ 
/*      */   
/*      */   public int getNoDamageTicks() {
/* 1154 */     if ((getHandle()).invulnerableTicks > 0) {
/* 1155 */       return Math.max((getHandle()).invulnerableTicks, (getHandle()).noDamageTicks);
/*      */     }
/* 1157 */     return (getHandle()).noDamageTicks;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setFlySpeed(float value) {
/* 1162 */     validateSpeed(value);
/* 1163 */     EntityPlayer player = getHandle();
/* 1164 */     player.abilities.flySpeed = value / 2.0F;
/* 1165 */     player.updateAbilities();
/*      */   }
/*      */ 
/*      */   
/*      */   public void setWalkSpeed(float value) {
/* 1170 */     validateSpeed(value);
/* 1171 */     EntityPlayer player = getHandle();
/* 1172 */     player.abilities.walkSpeed = value / 2.0F;
/* 1173 */     player.updateAbilities();
/*      */   }
/*      */   
/*      */   public float getFlySpeed() {
/* 1177 */     return (getHandle()).abilities.flySpeed * 2.0F;
/*      */   }
/*      */   
/*      */   public float getWalkSpeed() {
/* 1181 */     return (getHandle()).abilities.walkSpeed * 2.0F;
/*      */   }
/*      */   
/*      */   private void validateSpeed(float value) {
/* 1185 */     if (value < 0.0F) {
/* 1186 */       if (value < -1.0F) {
/* 1187 */         throw new IllegalArgumentException(value + " is too low");
/*      */       }
/*      */     }
/* 1190 */     else if (value > 1.0F) {
/* 1191 */       throw new IllegalArgumentException(value + " is too high");
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMaxHealth(double amount) {
/* 1198 */     super.setMaxHealth(amount);
/* 1199 */     this.health = Math.min(this.health, this.health);
/* 1200 */     getHandle().triggerHealthUpdate();
/*      */   }
/*      */ 
/*      */   
/*      */   public void resetMaxHealth() {
/* 1205 */     super.resetMaxHealth();
/* 1206 */     getHandle().triggerHealthUpdate();
/*      */   }
/*      */   
/*      */   public CraftScoreboard getScoreboard() {
/* 1210 */     return this.server.getScoreboardManager().getPlayerBoard(this);
/*      */   }
/*      */   
/*      */   public void setScoreboard(Scoreboard scoreboard) {
/* 1214 */     Validate.notNull(scoreboard, "Scoreboard cannot be null");
/* 1215 */     PlayerConnection playerConnection = (getHandle()).playerConnection;
/* 1216 */     if (playerConnection == null) {
/* 1217 */       throw new IllegalStateException("Cannot set scoreboard yet");
/*      */     }
/* 1219 */     if (playerConnection.isDisconnected()) {
/* 1220 */       throw new IllegalStateException("Cannot set scoreboard for invalid CraftPlayer");
/*      */     }
/*      */     
/* 1223 */     this.server.getScoreboardManager().setPlayerBoard(this, scoreboard);
/*      */   }
/*      */   
/*      */   public void setHealthScale(double value) {
/* 1227 */     Validate.isTrue(((float)value > 0.0F), "Must be greater than 0");
/* 1228 */     this.healthScale = value;
/* 1229 */     this.scaledHealth = true;
/* 1230 */     updateScaledHealth();
/*      */   }
/*      */   
/*      */   public double getHealthScale() {
/* 1234 */     return this.healthScale;
/*      */   }
/*      */   
/*      */   public void setHealthScaled(boolean scale) {
/* 1238 */     if (this.scaledHealth != (this.scaledHealth = scale)) {
/* 1239 */       updateScaledHealth();
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean isHealthScaled() {
/* 1244 */     return this.scaledHealth;
/*      */   }
/*      */   
/*      */   public float getScaledHealth() {
/* 1248 */     return (float)(isHealthScaled() ? (getHealth() * getHealthScale() / getMaxHealth()) : getHealth());
/*      */   }
/*      */ 
/*      */   
/*      */   public double getHealth() {
/* 1253 */     return this.health;
/*      */   }
/*      */   
/*      */   public void setRealHealth(double health) {
/* 1257 */     this.health = health;
/*      */   }
/*      */   
/*      */   public void updateScaledHealth() {
/* 1261 */     AttributeMapServer attributemapserver = (AttributeMapServer)getHandle().getAttributeMap();
/* 1262 */     Set set = attributemapserver.getAttributes();
/*      */     
/* 1264 */     injectScaledMaxHealth(set, true);
/*      */     
/* 1266 */     getHandle().getDataWatcher().watch(6, Float.valueOf(getScaledHealth()));
/* 1267 */     (getHandle()).playerConnection.sendPacket((Packet)new PacketPlayOutUpdateHealth(getScaledHealth(), getHandle().getFoodData().getFoodLevel(), getHandle().getFoodData().getSaturationLevel()));
/* 1268 */     (getHandle()).playerConnection.sendPacket((Packet)new PacketPlayOutUpdateAttributes(getHandle().getId(), set));
/*      */     
/* 1270 */     set.clear();
/* 1271 */     (getHandle()).maxHealthCache = getMaxHealth();
/*      */   }
/*      */   
/*      */   public void injectScaledMaxHealth(Collection<AttributeModifiable> collection, boolean force) {
/* 1275 */     if (!this.scaledHealth && !force) {
/*      */       return;
/*      */     }
/* 1278 */     for (Object genericInstance : collection) {
/* 1279 */       IAttribute attribute = ((AttributeInstance)genericInstance).getAttribute();
/* 1280 */       if (attribute.getName().equals("generic.maxHealth")) {
/* 1281 */         collection.remove(genericInstance);
/*      */         break;
/*      */       } 
/*      */     } 
/* 1285 */     collection.add(new AttributeModifiable(getHandle().getAttributeMap(), (IAttribute)(new AttributeRanged("generic.maxHealth", this.scaledHealth ? this.healthScale : getMaxHealth(), 0.0D, 3.4028234663852886E38D)).a("Max Health").a(true)));
/*      */   }
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\craftbukkit\v1_7_R4\entity\CraftPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */