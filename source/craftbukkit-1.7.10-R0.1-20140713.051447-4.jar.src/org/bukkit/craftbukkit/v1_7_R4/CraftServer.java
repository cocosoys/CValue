/*      */ package org.bukkit.craftbukkit.v1_7_R4;
/*      */ import com.avaje.ebean.config.DataSourceConfig;
/*      */ import com.avaje.ebean.config.ServerConfig;
/*      */ import com.avaje.ebeaninternal.server.lib.sql.TransactionIsolation;
/*      */ import com.google.common.collect.ImmutableList;
/*      */ import com.google.common.collect.MapMaker;
/*      */ import java.awt.image.BufferedImage;
/*      */ import java.io.File;
/*      */ import java.io.FileInputStream;
/*      */ import java.io.FileNotFoundException;
/*      */ import java.io.FilenameFilter;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStreamReader;
/*      */ import java.io.OutputStream;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedHashMap;
/*      */ import java.util.LinkedHashSet;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import java.util.UUID;
/*      */ import java.util.logging.Level;
/*      */ import java.util.logging.Logger;
/*      */ import java.util.regex.Pattern;
/*      */ import javax.imageio.ImageIO;
/*      */ import net.minecraft.server.v1_7_R4.ChunkCoordinates;
/*      */ import net.minecraft.server.v1_7_R4.CommandAbstract;
/*      */ import net.minecraft.server.v1_7_R4.CommandAchievement;
/*      */ import net.minecraft.server.v1_7_R4.CommandBan;
/*      */ import net.minecraft.server.v1_7_R4.CommandBanIp;
/*      */ import net.minecraft.server.v1_7_R4.CommandBanList;
/*      */ import net.minecraft.server.v1_7_R4.CommandClear;
/*      */ import net.minecraft.server.v1_7_R4.CommandDeop;
/*      */ import net.minecraft.server.v1_7_R4.CommandEffect;
/*      */ import net.minecraft.server.v1_7_R4.CommandGamemode;
/*      */ import net.minecraft.server.v1_7_R4.CommandGamemodeDefault;
/*      */ import net.minecraft.server.v1_7_R4.CommandGamerule;
/*      */ import net.minecraft.server.v1_7_R4.CommandGive;
/*      */ import net.minecraft.server.v1_7_R4.CommandHelp;
/*      */ import net.minecraft.server.v1_7_R4.CommandIdleTimeout;
/*      */ import net.minecraft.server.v1_7_R4.CommandKick;
/*      */ import net.minecraft.server.v1_7_R4.CommandKill;
/*      */ import net.minecraft.server.v1_7_R4.CommandMe;
/*      */ import net.minecraft.server.v1_7_R4.CommandNetstat;
/*      */ import net.minecraft.server.v1_7_R4.CommandOp;
/*      */ import net.minecraft.server.v1_7_R4.CommandPardon;
/*      */ import net.minecraft.server.v1_7_R4.CommandPardonIP;
/*      */ import net.minecraft.server.v1_7_R4.CommandPlaySound;
/*      */ import net.minecraft.server.v1_7_R4.CommandSay;
/*      */ import net.minecraft.server.v1_7_R4.CommandScoreboard;
/*      */ import net.minecraft.server.v1_7_R4.CommandSetBlock;
/*      */ import net.minecraft.server.v1_7_R4.CommandSetWorldSpawn;
/*      */ import net.minecraft.server.v1_7_R4.CommandSpawnpoint;
/*      */ import net.minecraft.server.v1_7_R4.CommandTell;
/*      */ import net.minecraft.server.v1_7_R4.CommandTellRaw;
/*      */ import net.minecraft.server.v1_7_R4.CommandTestFor;
/*      */ import net.minecraft.server.v1_7_R4.CommandToggleDownfall;
/*      */ import net.minecraft.server.v1_7_R4.CommandTp;
/*      */ import net.minecraft.server.v1_7_R4.CommandWeather;
/*      */ import net.minecraft.server.v1_7_R4.CommandWhitelist;
/*      */ import net.minecraft.server.v1_7_R4.CommandXp;
/*      */ import net.minecraft.server.v1_7_R4.ConvertProgressUpdater;
/*      */ import net.minecraft.server.v1_7_R4.CraftingManager;
/*      */ import net.minecraft.server.v1_7_R4.DedicatedPlayerList;
/*      */ import net.minecraft.server.v1_7_R4.DedicatedServer;
/*      */ import net.minecraft.server.v1_7_R4.Enchantment;
/*      */ import net.minecraft.server.v1_7_R4.EntityPlayer;
/*      */ import net.minecraft.server.v1_7_R4.EntityTracker;
/*      */ import net.minecraft.server.v1_7_R4.EnumDifficulty;
/*      */ import net.minecraft.server.v1_7_R4.EnumGamemode;
/*      */ import net.minecraft.server.v1_7_R4.ExceptionWorldConflict;
/*      */ import net.minecraft.server.v1_7_R4.ICommandListener;
/*      */ import net.minecraft.server.v1_7_R4.IProgressUpdate;
/*      */ import net.minecraft.server.v1_7_R4.IWorldAccess;
/*      */ import net.minecraft.server.v1_7_R4.Item;
/*      */ import net.minecraft.server.v1_7_R4.ItemStack;
/*      */ import net.minecraft.server.v1_7_R4.Items;
/*      */ import net.minecraft.server.v1_7_R4.JsonListEntry;
/*      */ import net.minecraft.server.v1_7_R4.MinecraftServer;
/*      */ import net.minecraft.server.v1_7_R4.MobEffectList;
/*      */ import net.minecraft.server.v1_7_R4.PersistentCollection;
/*      */ import net.minecraft.server.v1_7_R4.PlayerList;
/*      */ import net.minecraft.server.v1_7_R4.PropertyManager;
/*      */ import net.minecraft.server.v1_7_R4.RecipesFurnace;
/*      */ import net.minecraft.server.v1_7_R4.ServerCommand;
/*      */ import net.minecraft.server.v1_7_R4.ServerNBTManager;
/*      */ import net.minecraft.server.v1_7_R4.World;
/*      */ import net.minecraft.server.v1_7_R4.WorldLoaderServer;
/*      */ import net.minecraft.server.v1_7_R4.WorldManager;
/*      */ import net.minecraft.server.v1_7_R4.WorldMap;
/*      */ import net.minecraft.server.v1_7_R4.WorldNBTStorage;
/*      */ import net.minecraft.server.v1_7_R4.WorldServer;
/*      */ import net.minecraft.server.v1_7_R4.WorldSettings;
/*      */ import net.minecraft.server.v1_7_R4.WorldType;
/*      */ import net.minecraft.util.com.google.common.base.Charsets;
/*      */ import net.minecraft.util.com.google.common.base.Function;
/*      */ import net.minecraft.util.com.google.common.collect.Lists;
/*      */ import net.minecraft.util.com.mojang.authlib.GameProfile;
/*      */ import net.minecraft.util.io.netty.buffer.ByteBuf;
/*      */ import net.minecraft.util.io.netty.buffer.ByteBufOutputStream;
/*      */ import net.minecraft.util.io.netty.buffer.Unpooled;
/*      */ import net.minecraft.util.io.netty.handler.codec.base64.Base64;
/*      */ import org.apache.commons.lang.Validate;
/*      */ import org.bukkit.BanList;
/*      */ import org.bukkit.Bukkit;
/*      */ import org.bukkit.ChatColor;
/*      */ import org.bukkit.GameMode;
/*      */ import org.bukkit.OfflinePlayer;
/*      */ import org.bukkit.Server;
/*      */ import org.bukkit.UnsafeValues;
/*      */ import org.bukkit.Warning;
/*      */ import org.bukkit.World;
/*      */ import org.bukkit.WorldCreator;
/*      */ import org.bukkit.command.Command;
/*      */ import org.bukkit.command.CommandException;
/*      */ import org.bukkit.command.CommandSender;
/*      */ import org.bukkit.command.ConsoleCommandSender;
/*      */ import org.bukkit.command.PluginCommand;
/*      */ import org.bukkit.command.SimpleCommandMap;
/*      */ import org.bukkit.configuration.Configuration;
/*      */ import org.bukkit.configuration.ConfigurationSection;
/*      */ import org.bukkit.configuration.file.YamlConfiguration;
/*      */ import org.bukkit.configuration.serialization.ConfigurationSerialization;
/*      */ import org.bukkit.conversations.Conversable;
/*      */ import org.bukkit.craftbukkit.Main;
/*      */ import org.bukkit.craftbukkit.libs.jline.console.ConsoleReader;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.command.VanillaCommandWrapper;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.help.SimpleHelpMap;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.inventory.CraftFurnaceRecipe;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.inventory.CraftInventoryCustom;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.inventory.CraftItemFactory;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.inventory.CraftRecipe;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.inventory.CraftShapedRecipe;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.inventory.CraftShapelessRecipe;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.inventory.RecipeIterator;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.map.CraftMapView;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.metadata.EntityMetadataStore;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.metadata.PlayerMetadataStore;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.metadata.WorldMetadataStore;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.potion.CraftPotionBrewer;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.scheduler.CraftScheduler;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.scoreboard.CraftScoreboardManager;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.updater.AutoUpdater;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.util.CraftIconCache;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.util.DatFileFilter;
/*      */ import org.bukkit.enchantments.Enchantment;
/*      */ import org.bukkit.entity.Player;
/*      */ import org.bukkit.event.Event;
/*      */ import org.bukkit.event.inventory.InventoryType;
/*      */ import org.bukkit.event.player.PlayerChatTabCompleteEvent;
/*      */ import org.bukkit.event.world.WorldInitEvent;
/*      */ import org.bukkit.event.world.WorldLoadEvent;
/*      */ import org.bukkit.event.world.WorldSaveEvent;
/*      */ import org.bukkit.event.world.WorldUnloadEvent;
/*      */ import org.bukkit.generator.ChunkGenerator;
/*      */ import org.bukkit.help.HelpMap;
/*      */ import org.bukkit.inventory.FurnaceRecipe;
/*      */ import org.bukkit.inventory.Inventory;
/*      */ import org.bukkit.inventory.InventoryHolder;
/*      */ import org.bukkit.inventory.ItemFactory;
/*      */ import org.bukkit.inventory.ItemStack;
/*      */ import org.bukkit.inventory.Recipe;
/*      */ import org.bukkit.inventory.ShapedRecipe;
/*      */ import org.bukkit.inventory.ShapelessRecipe;
/*      */ import org.bukkit.map.MapView;
/*      */ import org.bukkit.permissions.Permissible;
/*      */ import org.bukkit.permissions.Permission;
/*      */ import org.bukkit.plugin.Plugin;
/*      */ import org.bukkit.plugin.PluginLoadOrder;
/*      */ import org.bukkit.plugin.PluginManager;
/*      */ import org.bukkit.plugin.ServicesManager;
/*      */ import org.bukkit.plugin.SimplePluginManager;
/*      */ import org.bukkit.plugin.messaging.Messenger;
/*      */ import org.bukkit.plugin.messaging.StandardMessenger;
/*      */ import org.bukkit.potion.Potion;
/*      */ import org.bukkit.potion.PotionBrewer;
/*      */ import org.bukkit.scheduler.BukkitScheduler;
/*      */ import org.bukkit.scheduler.BukkitWorker;
/*      */ import org.bukkit.scoreboard.ScoreboardManager;
/*      */ import org.bukkit.util.CachedServerIcon;
/*      */ import org.bukkit.util.StringUtil;
/*      */ import org.bukkit.util.permissions.DefaultPermissions;
/*      */ import org.yaml.snakeyaml.Yaml;
/*      */ import org.yaml.snakeyaml.constructor.BaseConstructor;
/*      */ import org.yaml.snakeyaml.constructor.SafeConstructor;
/*      */ import org.yaml.snakeyaml.error.MarkedYAMLException;
/*      */ 
/*      */ public final class CraftServer implements Server {
/*  195 */   private static final Player[] EMPTY_PLAYER_ARRAY = new Player[0];
/*  196 */   private final String serverName = "CraftBukkit";
/*      */   private final String serverVersion;
/*  198 */   private final String bukkitVersion = Versioning.getBukkitVersion();
/*  199 */   private final Logger logger = Logger.getLogger("Minecraft");
/*  200 */   private final ServicesManager servicesManager = (ServicesManager)new SimpleServicesManager();
/*  201 */   private final CraftScheduler scheduler = new CraftScheduler();
/*  202 */   private final SimpleCommandMap commandMap = new SimpleCommandMap(this);
/*  203 */   private final SimpleHelpMap helpMap = new SimpleHelpMap(this);
/*  204 */   private final StandardMessenger messenger = new StandardMessenger();
/*  205 */   private final PluginManager pluginManager = (PluginManager)new SimplePluginManager(this, this.commandMap);
/*      */   protected final MinecraftServer console;
/*      */   protected final DedicatedPlayerList playerList;
/*  208 */   private final Map<String, World> worlds = new LinkedHashMap<String, World>();
/*      */   private YamlConfiguration configuration;
/*      */   private YamlConfiguration commandsConfiguration;
/*  211 */   private final Yaml yaml = new Yaml((BaseConstructor)new SafeConstructor());
/*  212 */   private final Map<UUID, OfflinePlayer> offlinePlayers = (new MapMaker()).softValues().makeMap();
/*      */   private final AutoUpdater updater;
/*  214 */   private final EntityMetadataStore entityMetadata = new EntityMetadataStore();
/*  215 */   private final PlayerMetadataStore playerMetadata = new PlayerMetadataStore();
/*  216 */   private final WorldMetadataStore worldMetadata = new WorldMetadataStore();
/*  217 */   private int monsterSpawn = -1;
/*  218 */   private int animalSpawn = -1;
/*  219 */   private int waterAnimalSpawn = -1;
/*  220 */   private int ambientSpawn = -1;
/*  221 */   public int chunkGCPeriod = -1;
/*  222 */   public int chunkGCLoadThresh = 0;
/*      */   private File container;
/*  224 */   private Warning.WarningState warningState = Warning.WarningState.DEFAULT;
/*  225 */   private final BooleanWrapper online = new BooleanWrapper();
/*      */   public CraftScoreboardManager scoreboardManager;
/*      */   public boolean playerCommandState;
/*      */   private boolean printSaveWarning;
/*      */   private CraftIconCache icon;
/*      */   private boolean overrideAllCommandBlockCommands = false;
/*  231 */   private final Pattern validUserPattern = Pattern.compile("^[a-zA-Z0-9_]{2,16}$");
/*  232 */   private final UUID invalidUserUUID = UUID.nameUUIDFromBytes("InvalidUsername".getBytes(Charsets.UTF_8)); private final List<CraftPlayer> playerView;
/*      */   
/*      */   private final class BooleanWrapper {
/*      */     private BooleanWrapper() {}
/*      */     
/*      */     private boolean value = true; }
/*      */   
/*      */   static {
/*  240 */     ConfigurationSerialization.registerClass(CraftOfflinePlayer.class);
/*  241 */     CraftItemFactory.instance();
/*      */   }
/*      */   
/*      */   public CraftServer(MinecraftServer console, PlayerList playerList) {
/*  245 */     this.console = console;
/*  246 */     this.playerList = (DedicatedPlayerList)playerList;
/*  247 */     this.playerView = Collections.unmodifiableList(Lists.transform(playerList.players, new Function<EntityPlayer, CraftPlayer>()
/*      */           {
/*      */             public CraftPlayer apply(EntityPlayer player) {
/*  250 */               return player.getBukkitEntity();
/*      */             }
/*      */           }));
/*  253 */     this.serverVersion = CraftServer.class.getPackage().getImplementationVersion();
/*  254 */     this.online.value = console.getPropertyManager().getBoolean("online-mode", true);
/*      */     
/*  256 */     Bukkit.setServer(this);
/*      */ 
/*      */     
/*  259 */     Enchantment.DAMAGE_ALL.getClass();
/*  260 */     Enchantment.stopAcceptingRegistrations();
/*      */     
/*  262 */     Potion.setPotionBrewer((PotionBrewer)new CraftPotionBrewer());
/*  263 */     MobEffectList.BLINDNESS.getClass();
/*  264 */     PotionEffectType.stopAcceptingRegistrations();
/*      */ 
/*      */     
/*  267 */     if (!Main.useConsole) {
/*  268 */       getLogger().info("Console input is disabled due to --noconsole command argument");
/*      */     }
/*      */     
/*  271 */     this.configuration = YamlConfiguration.loadConfiguration(getConfigFile());
/*  272 */     this.configuration.options().copyDefaults(true);
/*  273 */     this.configuration.setDefaults((Configuration)YamlConfiguration.loadConfiguration(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("configurations/bukkit.yml"), Charsets.UTF_8)));
/*  274 */     ConfigurationSection legacyAlias = null;
/*  275 */     if (!this.configuration.isString("aliases")) {
/*  276 */       legacyAlias = this.configuration.getConfigurationSection("aliases");
/*  277 */       this.configuration.set("aliases", "now-in-commands.yml");
/*      */     } 
/*  279 */     saveConfig();
/*  280 */     if (getCommandsConfigFile().isFile()) {
/*  281 */       legacyAlias = null;
/*      */     }
/*  283 */     this.commandsConfiguration = YamlConfiguration.loadConfiguration(getCommandsConfigFile());
/*  284 */     this.commandsConfiguration.options().copyDefaults(true);
/*  285 */     this.commandsConfiguration.setDefaults((Configuration)YamlConfiguration.loadConfiguration(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("configurations/commands.yml"), Charsets.UTF_8)));
/*  286 */     saveCommandsConfig();
/*      */ 
/*      */     
/*  289 */     if (legacyAlias != null) {
/*  290 */       ConfigurationSection aliases = this.commandsConfiguration.createSection("aliases");
/*  291 */       for (String key : legacyAlias.getKeys(false)) {
/*  292 */         ArrayList<String> commands = new ArrayList<String>();
/*      */         
/*  294 */         if (legacyAlias.isList(key)) {
/*  295 */           for (String command : legacyAlias.getStringList(key)) {
/*  296 */             commands.add(command + " $1-");
/*      */           }
/*      */         } else {
/*  299 */           commands.add(legacyAlias.getString(key) + " $1-");
/*      */         } 
/*      */         
/*  302 */         aliases.set(key, commands);
/*      */       } 
/*      */     } 
/*      */     
/*  306 */     saveCommandsConfig();
/*  307 */     this.overrideAllCommandBlockCommands = this.commandsConfiguration.getStringList("command-block-overrides").contains("*");
/*  308 */     ((SimplePluginManager)this.pluginManager).useTimings(this.configuration.getBoolean("settings.plugin-profiling"));
/*  309 */     this.monsterSpawn = this.configuration.getInt("spawn-limits.monsters");
/*  310 */     this.animalSpawn = this.configuration.getInt("spawn-limits.animals");
/*  311 */     this.waterAnimalSpawn = this.configuration.getInt("spawn-limits.water-animals");
/*  312 */     this.ambientSpawn = this.configuration.getInt("spawn-limits.ambient");
/*  313 */     console.autosavePeriod = this.configuration.getInt("ticks-per.autosave");
/*  314 */     this.warningState = Warning.WarningState.value(this.configuration.getString("settings.deprecated-verbose"));
/*  315 */     this.chunkGCPeriod = this.configuration.getInt("chunk-gc.period-in-ticks");
/*  316 */     this.chunkGCLoadThresh = this.configuration.getInt("chunk-gc.load-threshold");
/*  317 */     loadIcon();
/*      */     
/*  319 */     this.updater = new AutoUpdater(new BukkitDLUpdaterService(this.configuration.getString("auto-updater.host")), getLogger(), this.configuration.getString("auto-updater.preferred-channel"));
/*  320 */     this.updater.setEnabled(this.configuration.getBoolean("auto-updater.enabled"));
/*  321 */     this.updater.setSuggestChannels(this.configuration.getBoolean("auto-updater.suggest-channels"));
/*  322 */     this.updater.getOnBroken().addAll(this.configuration.getStringList("auto-updater.on-broken"));
/*  323 */     this.updater.getOnUpdate().addAll(this.configuration.getStringList("auto-updater.on-update"));
/*  324 */     this.updater.check(this.serverVersion);
/*      */     
/*  326 */     loadPlugins();
/*  327 */     enablePlugins(PluginLoadOrder.STARTUP);
/*      */   }
/*      */   
/*      */   public boolean getCommandBlockOverride(String command) {
/*  331 */     return (this.overrideAllCommandBlockCommands || this.commandsConfiguration.getStringList("command-block-overrides").contains(command));
/*      */   }
/*      */   
/*      */   private File getConfigFile() {
/*  335 */     return (File)this.console.options.valueOf("bukkit-settings");
/*      */   }
/*      */   
/*      */   private File getCommandsConfigFile() {
/*  339 */     return (File)this.console.options.valueOf("commands-settings");
/*      */   }
/*      */   
/*      */   private void saveConfig() {
/*      */     try {
/*  344 */       this.configuration.save(getConfigFile());
/*  345 */     } catch (IOException ex) {
/*  346 */       Logger.getLogger(CraftServer.class.getName()).log(Level.SEVERE, "Could not save " + getConfigFile(), ex);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void saveCommandsConfig() {
/*      */     try {
/*  352 */       this.commandsConfiguration.save(getCommandsConfigFile());
/*  353 */     } catch (IOException ex) {
/*  354 */       Logger.getLogger(CraftServer.class.getName()).log(Level.SEVERE, "Could not save " + getCommandsConfigFile(), ex);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void loadPlugins() {
/*  359 */     this.pluginManager.registerInterface(JavaPluginLoader.class);
/*      */     
/*  361 */     File pluginFolder = (File)this.console.options.valueOf("plugins");
/*      */     
/*  363 */     if (pluginFolder.exists()) {
/*  364 */       Plugin[] plugins = this.pluginManager.loadPlugins(pluginFolder);
/*  365 */       for (Plugin plugin : plugins) {
/*      */         try {
/*  367 */           String message = String.format("Loading %s", new Object[] { plugin.getDescription().getFullName() });
/*  368 */           plugin.getLogger().info(message);
/*  369 */           plugin.onLoad();
/*  370 */         } catch (Throwable ex) {
/*  371 */           Logger.getLogger(CraftServer.class.getName()).log(Level.SEVERE, ex.getMessage() + " initializing " + plugin.getDescription().getFullName() + " (Is it up to date?)", ex);
/*      */         } 
/*      */       } 
/*      */     } else {
/*  375 */       pluginFolder.mkdir();
/*      */     } 
/*      */   }
/*      */   
/*      */   public void enablePlugins(PluginLoadOrder type) {
/*  380 */     if (type == PluginLoadOrder.STARTUP) {
/*  381 */       this.helpMap.clear();
/*  382 */       this.helpMap.initializeGeneralTopics();
/*      */     } 
/*      */     
/*  385 */     Plugin[] plugins = this.pluginManager.getPlugins();
/*      */     
/*  387 */     for (Plugin plugin : plugins) {
/*  388 */       if (!plugin.isEnabled() && plugin.getDescription().getLoad() == type) {
/*  389 */         loadPlugin(plugin);
/*      */       }
/*      */     } 
/*      */     
/*  393 */     if (type == PluginLoadOrder.POSTWORLD) {
/*  394 */       this.commandMap.setFallbackCommands();
/*  395 */       setVanillaCommands();
/*  396 */       this.commandMap.registerServerAliases();
/*  397 */       loadCustomPermissions();
/*  398 */       DefaultPermissions.registerCorePermissions();
/*  399 */       this.helpMap.initializeCommands();
/*      */     } 
/*      */   }
/*      */   
/*      */   public void disablePlugins() {
/*  404 */     this.pluginManager.disablePlugins();
/*      */   }
/*      */   
/*      */   private void setVanillaCommands() {
/*  408 */     this.commandMap.register("minecraft", (Command)new VanillaCommandWrapper((CommandAbstract)new CommandAchievement(), "/achievement give <stat_name> [player]"));
/*  409 */     this.commandMap.register("minecraft", (Command)new VanillaCommandWrapper((CommandAbstract)new CommandBan(), "/ban <playername> [reason]"));
/*  410 */     this.commandMap.register("minecraft", (Command)new VanillaCommandWrapper((CommandAbstract)new CommandBanIp(), "/ban-ip <ip-address|playername>"));
/*  411 */     this.commandMap.register("minecraft", (Command)new VanillaCommandWrapper((CommandAbstract)new CommandBanList(), "/banlist [ips]"));
/*  412 */     this.commandMap.register("minecraft", (Command)new VanillaCommandWrapper((CommandAbstract)new CommandClear(), "/clear <playername> [item] [metadata]"));
/*  413 */     this.commandMap.register("minecraft", (Command)new VanillaCommandWrapper((CommandAbstract)new CommandGamemodeDefault(), "/defaultgamemode <mode>"));
/*  414 */     this.commandMap.register("minecraft", (Command)new VanillaCommandWrapper((CommandAbstract)new CommandDeop(), "/deop <playername>"));
/*  415 */     this.commandMap.register("minecraft", (Command)new VanillaCommandWrapper((CommandAbstract)new CommandDifficulty(), "/difficulty <new difficulty>"));
/*  416 */     this.commandMap.register("minecraft", (Command)new VanillaCommandWrapper((CommandAbstract)new CommandEffect(), "/effect <player> <effect|clear> [seconds] [amplifier]"));
/*  417 */     this.commandMap.register("minecraft", (Command)new VanillaCommandWrapper((CommandAbstract)new CommandEnchant(), "/enchant <playername> <enchantment ID> [enchantment level]"));
/*  418 */     this.commandMap.register("minecraft", (Command)new VanillaCommandWrapper((CommandAbstract)new CommandGamemode(), "/gamemode <mode> [player]"));
/*  419 */     this.commandMap.register("minecraft", (Command)new VanillaCommandWrapper((CommandAbstract)new CommandGamerule(), "/gamerule <rulename> [true|false]"));
/*  420 */     this.commandMap.register("minecraft", (Command)new VanillaCommandWrapper((CommandAbstract)new CommandGive(), "/give <playername> <item> [amount] [metadata] [dataTag]"));
/*  421 */     this.commandMap.register("minecraft", (Command)new VanillaCommandWrapper((CommandAbstract)new CommandHelp(), "/help [page|commandname]"));
/*  422 */     this.commandMap.register("minecraft", (Command)new VanillaCommandWrapper((CommandAbstract)new CommandIdleTimeout(), "/setidletimeout <Minutes until kick>"));
/*  423 */     this.commandMap.register("minecraft", (Command)new VanillaCommandWrapper((CommandAbstract)new CommandKick(), "/kick <playername> [reason]"));
/*  424 */     this.commandMap.register("minecraft", (Command)new VanillaCommandWrapper((CommandAbstract)new CommandKill(), "/kill [playername]"));
/*  425 */     this.commandMap.register("minecraft", (Command)new VanillaCommandWrapper((CommandAbstract)new CommandList(), "/list"));
/*  426 */     this.commandMap.register("minecraft", (Command)new VanillaCommandWrapper((CommandAbstract)new CommandMe(), "/me <actiontext>"));
/*  427 */     this.commandMap.register("minecraft", (Command)new VanillaCommandWrapper((CommandAbstract)new CommandOp(), "/op <playername>"));
/*  428 */     this.commandMap.register("minecraft", (Command)new VanillaCommandWrapper((CommandAbstract)new CommandPardon(), "/pardon <playername>"));
/*  429 */     this.commandMap.register("minecraft", (Command)new VanillaCommandWrapper((CommandAbstract)new CommandPardonIP(), "/pardon-ip <ip-address>"));
/*  430 */     this.commandMap.register("minecraft", (Command)new VanillaCommandWrapper((CommandAbstract)new CommandPlaySound(), "/playsound <sound> <playername> [x] [y] [z] [volume] [pitch] [minimumVolume]"));
/*  431 */     this.commandMap.register("minecraft", (Command)new VanillaCommandWrapper((CommandAbstract)new CommandSay(), "/say <message>"));
/*  432 */     this.commandMap.register("minecraft", (Command)new VanillaCommandWrapper((CommandAbstract)new CommandScoreboard(), "/scoreboard"));
/*  433 */     this.commandMap.register("minecraft", (Command)new VanillaCommandWrapper((CommandAbstract)new CommandSeed(), "/seed"));
/*  434 */     this.commandMap.register("minecraft", (Command)new VanillaCommandWrapper((CommandAbstract)new CommandSetBlock(), "/setblock <x> <y> <z> <tilename> [datavalue] [oldblockHandling] [dataTag]"));
/*  435 */     this.commandMap.register("minecraft", (Command)new VanillaCommandWrapper((CommandAbstract)new CommandSetWorldSpawn(), "/setworldspawn [x] [y] [z]"));
/*  436 */     this.commandMap.register("minecraft", (Command)new VanillaCommandWrapper((CommandAbstract)new CommandSpawnpoint(), "/spawnpoint <playername> [x] [y] [z]"));
/*  437 */     this.commandMap.register("minecraft", (Command)new VanillaCommandWrapper((CommandAbstract)new CommandSpreadPlayers(), "/spreadplayers <x> <z> [spreadDistance] [maxRange] [respectTeams] <playernames>"));
/*  438 */     this.commandMap.register("minecraft", (Command)new VanillaCommandWrapper((CommandAbstract)new CommandSummon(), "/summon <EntityName> [x] [y] [z] [dataTag]"));
/*  439 */     this.commandMap.register("minecraft", (Command)new VanillaCommandWrapper((CommandAbstract)new CommandTp(), "/tp [player] <target>\n/tp [player] <x> <y> <z>"));
/*  440 */     this.commandMap.register("minecraft", (Command)new VanillaCommandWrapper((CommandAbstract)new CommandTell(), "/tell <playername> <message>"));
/*  441 */     this.commandMap.register("minecraft", (Command)new VanillaCommandWrapper((CommandAbstract)new CommandTellRaw(), "/tellraw <playername> <raw message>"));
/*  442 */     this.commandMap.register("minecraft", (Command)new VanillaCommandWrapper((CommandAbstract)new CommandTestFor(), "/testfor <playername | selector> [dataTag]"));
/*  443 */     this.commandMap.register("minecraft", (Command)new VanillaCommandWrapper((CommandAbstract)new CommandTestForBlock(), "/testforblock <x> <y> <z> <tilename> [datavalue] [dataTag]"));
/*  444 */     this.commandMap.register("minecraft", (Command)new VanillaCommandWrapper((CommandAbstract)new CommandTime(), "/time set <value>\n/time add <value>"));
/*  445 */     this.commandMap.register("minecraft", (Command)new VanillaCommandWrapper((CommandAbstract)new CommandToggleDownfall(), "/toggledownfall"));
/*  446 */     this.commandMap.register("minecraft", (Command)new VanillaCommandWrapper((CommandAbstract)new CommandWeather(), "/weather <clear/rain/thunder> [duration in seconds]"));
/*  447 */     this.commandMap.register("minecraft", (Command)new VanillaCommandWrapper((CommandAbstract)new CommandWhitelist(), "/whitelist (add|remove) <player>\n/whitelist (on|off|list|reload)"));
/*  448 */     this.commandMap.register("minecraft", (Command)new VanillaCommandWrapper((CommandAbstract)new CommandXp(), "/xp <amount> [player]\n/xp <amount>L [player]"));
/*      */     
/*  450 */     this.commandMap.register("minecraft", (Command)new VanillaCommandWrapper((CommandAbstract)new CommandNetstat(), "/list"));
/*      */   }
/*      */   
/*      */   private void loadPlugin(Plugin plugin) {
/*      */     try {
/*  455 */       this.pluginManager.enablePlugin(plugin);
/*      */       
/*  457 */       List<Permission> perms = plugin.getDescription().getPermissions();
/*      */       
/*  459 */       for (Permission perm : perms) {
/*      */         try {
/*  461 */           this.pluginManager.addPermission(perm);
/*  462 */         } catch (IllegalArgumentException ex) {
/*  463 */           getLogger().log(Level.WARNING, "Plugin " + plugin.getDescription().getFullName() + " tried to register permission '" + perm.getName() + "' but it's already registered", ex);
/*      */         } 
/*      */       } 
/*  466 */     } catch (Throwable ex) {
/*  467 */       Logger.getLogger(CraftServer.class.getName()).log(Level.SEVERE, ex.getMessage() + " loading " + plugin.getDescription().getFullName() + " (Is it up to date?)", ex);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public String getName() {
/*  473 */     return "CraftBukkit";
/*      */   }
/*      */ 
/*      */   
/*      */   public String getVersion() {
/*  478 */     return this.serverVersion + " (MC: " + this.console.getVersion() + ")";
/*      */   }
/*      */ 
/*      */   
/*      */   public String getBukkitVersion() {
/*  483 */     return this.bukkitVersion;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public Player[] getOnlinePlayers() {
/*  490 */     return getOnlinePlayers().<Player>toArray(EMPTY_PLAYER_ARRAY);
/*      */   }
/*      */ 
/*      */   
/*      */   public List<CraftPlayer> getOnlinePlayers() {
/*  495 */     return this.playerView;
/*      */   }
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public Player getPlayer(String name) {
/*  501 */     Validate.notNull(name, "Name cannot be null");
/*      */     
/*  503 */     Player found = null;
/*  504 */     String lowerName = name.toLowerCase();
/*  505 */     int delta = Integer.MAX_VALUE;
/*  506 */     for (Player player : getOnlinePlayers()) {
/*  507 */       if (player.getName().toLowerCase().startsWith(lowerName)) {
/*  508 */         int curDelta = player.getName().length() - lowerName.length();
/*  509 */         if (curDelta < delta) {
/*  510 */           found = player;
/*  511 */           delta = curDelta;
/*      */         } 
/*  513 */         if (curDelta == 0)
/*      */           break; 
/*      */       } 
/*  516 */     }  return found;
/*      */   }
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public Player getPlayerExact(String name) {
/*  522 */     Validate.notNull(name, "Name cannot be null");
/*      */     
/*  524 */     String lname = name.toLowerCase();
/*      */     
/*  526 */     for (Player player : getOnlinePlayers()) {
/*  527 */       if (player.getName().equalsIgnoreCase(lname)) {
/*  528 */         return player;
/*      */       }
/*      */     } 
/*      */     
/*  532 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Player getPlayer(UUID id) {
/*  538 */     for (Player player : getOnlinePlayers()) {
/*  539 */       if (player.getUniqueId().equals(id)) {
/*  540 */         return player;
/*      */       }
/*      */     } 
/*      */     
/*  544 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public int broadcastMessage(String message) {
/*  549 */     return broadcast(message, "bukkit.broadcast.user");
/*      */   }
/*      */   
/*      */   public Player getPlayer(EntityPlayer entity) {
/*  553 */     return (Player)entity.playerConnection.getPlayer();
/*      */   }
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public List<Player> matchPlayer(String partialName) {
/*  559 */     Validate.notNull(partialName, "PartialName cannot be null");
/*      */     
/*  561 */     List<Player> matchedPlayers = new ArrayList<Player>();
/*      */     
/*  563 */     for (Player iterPlayer : getOnlinePlayers()) {
/*  564 */       String iterPlayerName = iterPlayer.getName();
/*      */       
/*  566 */       if (partialName.equalsIgnoreCase(iterPlayerName)) {
/*      */         
/*  568 */         matchedPlayers.clear();
/*  569 */         matchedPlayers.add(iterPlayer);
/*      */         break;
/*      */       } 
/*  572 */       if (iterPlayerName.toLowerCase().contains(partialName.toLowerCase()))
/*      */       {
/*  574 */         matchedPlayers.add(iterPlayer);
/*      */       }
/*      */     } 
/*      */     
/*  578 */     return matchedPlayers;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getMaxPlayers() {
/*  583 */     return this.playerList.getMaxPlayers();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getPort() {
/*  590 */     return getConfigInt("server-port", 25565);
/*      */   }
/*      */ 
/*      */   
/*      */   public int getViewDistance() {
/*  595 */     return getConfigInt("view-distance", 10);
/*      */   }
/*      */ 
/*      */   
/*      */   public String getIp() {
/*  600 */     return getConfigString("server-ip", "");
/*      */   }
/*      */ 
/*      */   
/*      */   public String getServerName() {
/*  605 */     return getConfigString("server-name", "Unknown Server");
/*      */   }
/*      */ 
/*      */   
/*      */   public String getServerId() {
/*  610 */     return getConfigString("server-id", "unnamed");
/*      */   }
/*      */ 
/*      */   
/*      */   public String getWorldType() {
/*  615 */     return getConfigString("level-type", "DEFAULT");
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean getGenerateStructures() {
/*  620 */     return getConfigBoolean("generate-structures", true);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean getAllowEnd() {
/*  625 */     return this.configuration.getBoolean("settings.allow-end");
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean getAllowNether() {
/*  630 */     return getConfigBoolean("allow-nether", true);
/*      */   }
/*      */   
/*      */   public boolean getWarnOnOverload() {
/*  634 */     return this.configuration.getBoolean("settings.warn-on-overload");
/*      */   }
/*      */   
/*      */   public boolean getQueryPlugins() {
/*  638 */     return this.configuration.getBoolean("settings.query-plugins");
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean hasWhitelist() {
/*  643 */     return getConfigBoolean("white-list", false);
/*      */   }
/*      */ 
/*      */   
/*      */   private String getConfigString(String variable, String defaultValue) {
/*  648 */     return this.console.getPropertyManager().getString(variable, defaultValue);
/*      */   }
/*      */   
/*      */   private int getConfigInt(String variable, int defaultValue) {
/*  652 */     return this.console.getPropertyManager().getInt(variable, defaultValue);
/*      */   }
/*      */   
/*      */   private boolean getConfigBoolean(String variable, boolean defaultValue) {
/*  656 */     return this.console.getPropertyManager().getBoolean(variable, defaultValue);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateFolder() {
/*  663 */     return this.configuration.getString("settings.update-folder", "update");
/*      */   }
/*      */ 
/*      */   
/*      */   public File getUpdateFolderFile() {
/*  668 */     return new File((File)this.console.options.valueOf("plugins"), this.configuration.getString("settings.update-folder", "update"));
/*      */   }
/*      */   
/*      */   public int getPingPacketLimit() {
/*  672 */     return this.configuration.getInt("settings.ping-packet-limit", 100);
/*      */   }
/*      */ 
/*      */   
/*      */   public long getConnectionThrottle() {
/*  677 */     return this.configuration.getInt("settings.connection-throttle");
/*      */   }
/*      */ 
/*      */   
/*      */   public int getTicksPerAnimalSpawns() {
/*  682 */     return this.configuration.getInt("ticks-per.animal-spawns");
/*      */   }
/*      */ 
/*      */   
/*      */   public int getTicksPerMonsterSpawns() {
/*  687 */     return this.configuration.getInt("ticks-per.monster-spawns");
/*      */   }
/*      */ 
/*      */   
/*      */   public PluginManager getPluginManager() {
/*  692 */     return this.pluginManager;
/*      */   }
/*      */ 
/*      */   
/*      */   public CraftScheduler getScheduler() {
/*  697 */     return this.scheduler;
/*      */   }
/*      */ 
/*      */   
/*      */   public ServicesManager getServicesManager() {
/*  702 */     return this.servicesManager;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<World> getWorlds() {
/*  707 */     return new ArrayList<World>(this.worlds.values());
/*      */   }
/*      */   
/*      */   public DedicatedPlayerList getHandle() {
/*  711 */     return this.playerList;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean dispatchServerCommand(CommandSender sender, ServerCommand serverCommand) {
/*  716 */     if (sender instanceof Conversable) {
/*  717 */       Conversable conversable = (Conversable)sender;
/*      */       
/*  719 */       if (conversable.isConversing()) {
/*  720 */         conversable.acceptConversationInput(serverCommand.command);
/*  721 */         return true;
/*      */       } 
/*      */     } 
/*      */     try {
/*  725 */       this.playerCommandState = true;
/*  726 */       return dispatchCommand(sender, serverCommand.command);
/*  727 */     } catch (Exception ex) {
/*  728 */       getLogger().log(Level.WARNING, "Unexpected exception while parsing console command \"" + serverCommand.command + '"', ex);
/*  729 */       return false;
/*      */     } finally {
/*  731 */       this.playerCommandState = false;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean dispatchCommand(CommandSender sender, String commandLine) {
/*  737 */     Validate.notNull(sender, "Sender cannot be null");
/*  738 */     Validate.notNull(commandLine, "CommandLine cannot be null");
/*      */     
/*  740 */     if (this.commandMap.dispatch(sender, commandLine)) {
/*  741 */       return true;
/*      */     }
/*      */     
/*  744 */     if (sender instanceof Player) {
/*  745 */       sender.sendMessage("Unknown command. Type \"/help\" for help.");
/*      */     } else {
/*  747 */       sender.sendMessage("Unknown command. Type \"help\" for help.");
/*      */     } 
/*      */     
/*  750 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void reload() {
/*  755 */     this.configuration = YamlConfiguration.loadConfiguration(getConfigFile());
/*  756 */     this.commandsConfiguration = YamlConfiguration.loadConfiguration(getCommandsConfigFile());
/*  757 */     PropertyManager config = new PropertyManager(this.console.options);
/*      */     
/*  759 */     ((DedicatedServer)this.console).propertyManager = config;
/*      */     
/*  761 */     boolean animals = config.getBoolean("spawn-animals", this.console.getSpawnAnimals());
/*  762 */     boolean monsters = config.getBoolean("spawn-monsters", (((WorldServer)this.console.worlds.get(0)).difficulty != EnumDifficulty.PEACEFUL));
/*  763 */     EnumDifficulty difficulty = EnumDifficulty.getById(config.getInt("difficulty", ((WorldServer)this.console.worlds.get(0)).difficulty.ordinal()));
/*      */     
/*  765 */     this.online.value = config.getBoolean("online-mode", this.console.getOnlineMode());
/*  766 */     this.console.setSpawnAnimals(config.getBoolean("spawn-animals", this.console.getSpawnAnimals()));
/*  767 */     this.console.setPvP(config.getBoolean("pvp", this.console.getPvP()));
/*  768 */     this.console.setAllowFlight(config.getBoolean("allow-flight", this.console.getAllowFlight()));
/*  769 */     this.console.setMotd(config.getString("motd", this.console.getMotd()));
/*  770 */     this.monsterSpawn = this.configuration.getInt("spawn-limits.monsters");
/*  771 */     this.animalSpawn = this.configuration.getInt("spawn-limits.animals");
/*  772 */     this.waterAnimalSpawn = this.configuration.getInt("spawn-limits.water-animals");
/*  773 */     this.ambientSpawn = this.configuration.getInt("spawn-limits.ambient");
/*  774 */     this.warningState = Warning.WarningState.value(this.configuration.getString("settings.deprecated-verbose"));
/*  775 */     this.printSaveWarning = false;
/*  776 */     this.console.autosavePeriod = this.configuration.getInt("ticks-per.autosave");
/*  777 */     this.chunkGCPeriod = this.configuration.getInt("chunk-gc.period-in-ticks");
/*  778 */     this.chunkGCLoadThresh = this.configuration.getInt("chunk-gc.load-threshold");
/*  779 */     loadIcon();
/*      */     
/*      */     try {
/*  782 */       this.playerList.getIPBans().load();
/*  783 */     } catch (IOException ex) {
/*  784 */       this.logger.log(Level.WARNING, "Failed to load banned-ips.json, " + ex.getMessage());
/*      */     } 
/*      */     try {
/*  787 */       this.playerList.getProfileBans().load();
/*  788 */     } catch (IOException ex) {
/*  789 */       this.logger.log(Level.WARNING, "Failed to load banned-players.json, " + ex.getMessage());
/*      */     } 
/*      */     
/*  792 */     for (WorldServer world : this.console.worlds) {
/*  793 */       world.difficulty = difficulty;
/*  794 */       world.setSpawnFlags(monsters, animals);
/*  795 */       if (getTicksPerAnimalSpawns() < 0) {
/*  796 */         world.ticksPerAnimalSpawns = 400L;
/*      */       } else {
/*  798 */         world.ticksPerAnimalSpawns = getTicksPerAnimalSpawns();
/*      */       } 
/*      */       
/*  801 */       if (getTicksPerMonsterSpawns() < 0) {
/*  802 */         world.ticksPerMonsterSpawns = 1L; continue;
/*      */       } 
/*  804 */       world.ticksPerMonsterSpawns = getTicksPerMonsterSpawns();
/*      */     } 
/*      */ 
/*      */     
/*  808 */     this.pluginManager.clearPlugins();
/*  809 */     this.commandMap.clearCommands();
/*  810 */     resetRecipes();
/*  811 */     this.overrideAllCommandBlockCommands = this.commandsConfiguration.getStringList("command-block-overrides").contains("*");
/*      */     
/*  813 */     int pollCount = 0;
/*      */ 
/*      */     
/*  816 */     while (pollCount < 50 && getScheduler().getActiveWorkers().size() > 0) {
/*      */       try {
/*  818 */         Thread.sleep(50L);
/*  819 */       } catch (InterruptedException e) {}
/*  820 */       pollCount++;
/*      */     } 
/*      */     
/*  823 */     List<BukkitWorker> overdueWorkers = getScheduler().getActiveWorkers();
/*  824 */     for (BukkitWorker worker : overdueWorkers) {
/*  825 */       Plugin plugin = worker.getOwner();
/*  826 */       String author = "<NoAuthorGiven>";
/*  827 */       if (plugin.getDescription().getAuthors().size() > 0) {
/*  828 */         author = plugin.getDescription().getAuthors().get(0);
/*      */       }
/*  830 */       getLogger().log(Level.SEVERE, String.format("Nag author: '%s' of '%s' about the following: %s", new Object[] { author, plugin.getDescription().getName(), "This plugin is not properly shutting down its async tasks when it is being reloaded.  This may cause conflicts with the newly loaded version of the plugin" }));
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  837 */     loadPlugins();
/*  838 */     enablePlugins(PluginLoadOrder.STARTUP);
/*  839 */     enablePlugins(PluginLoadOrder.POSTWORLD);
/*      */   }
/*      */   
/*      */   private void loadIcon() {
/*  843 */     this.icon = new CraftIconCache(null);
/*      */     try {
/*  845 */       File file = new File(new File("."), "server-icon.png");
/*  846 */       if (file.isFile()) {
/*  847 */         this.icon = loadServerIcon0(file);
/*      */       }
/*  849 */     } catch (Exception ex) {
/*  850 */       getLogger().log(Level.WARNING, "Couldn't load server icon", ex);
/*      */     } 
/*      */   }
/*      */   private void loadCustomPermissions() {
/*      */     FileInputStream stream;
/*      */     Map<String, Map<String, Object>> perms;
/*  856 */     File file = new File(this.configuration.getString("settings.permissions-file"));
/*      */ 
/*      */     
/*      */     try {
/*  860 */       stream = new FileInputStream(file);
/*  861 */     } catch (FileNotFoundException ex) {
/*      */       try {
/*      */         return;
/*      */       } finally {
/*  865 */         Exception exception = null;
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*      */     try {
/*  872 */       perms = (Map<String, Map<String, Object>>)this.yaml.load(stream);
/*  873 */     } catch (MarkedYAMLException ex) {
/*  874 */       getLogger().log(Level.WARNING, "Server permissions file " + file + " is not valid YAML: " + ex.toString());
/*      */       return;
/*  876 */     } catch (Throwable ex) {
/*  877 */       getLogger().log(Level.WARNING, "Server permissions file " + file + " is not valid YAML.", ex);
/*      */       return;
/*      */     } finally {
/*      */       try {
/*  881 */         stream.close();
/*  882 */       } catch (IOException ex) {}
/*      */     } 
/*      */     
/*  885 */     if (perms == null) {
/*  886 */       getLogger().log(Level.INFO, "Server permissions file " + file + " is empty, ignoring it");
/*      */       
/*      */       return;
/*      */     } 
/*  890 */     List<Permission> permsList = Permission.loadPermissions(perms, "Permission node '%s' in " + file + " is invalid", Permission.DEFAULT_PERMISSION);
/*      */     
/*  892 */     for (Permission perm : permsList) {
/*      */       try {
/*  894 */         this.pluginManager.addPermission(perm);
/*  895 */       } catch (IllegalArgumentException ex) {
/*  896 */         getLogger().log(Level.SEVERE, "Permission in " + file + " was already defined", ex);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public String toString() {
/*  903 */     return "CraftServer{serverName=CraftBukkit,serverVersion=" + this.serverVersion + ",minecraftVersion=" + this.console.getVersion() + '}';
/*      */   }
/*      */   
/*      */   public World createWorld(String name, World.Environment environment) {
/*  907 */     return WorldCreator.name(name).environment(environment).createWorld();
/*      */   }
/*      */   
/*      */   public World createWorld(String name, World.Environment environment, long seed) {
/*  911 */     return WorldCreator.name(name).environment(environment).seed(seed).createWorld();
/*      */   }
/*      */   
/*      */   public World createWorld(String name, World.Environment environment, ChunkGenerator generator) {
/*  915 */     return WorldCreator.name(name).environment(environment).generator(generator).createWorld();
/*      */   }
/*      */   
/*      */   public World createWorld(String name, World.Environment environment, long seed, ChunkGenerator generator) {
/*  919 */     return WorldCreator.name(name).environment(environment).seed(seed).generator(generator).createWorld();
/*      */   }
/*      */ 
/*      */   
/*      */   public World createWorld(WorldCreator creator) {
/*  924 */     Validate.notNull(creator, "Creator may not be null");
/*      */     
/*  926 */     String name = creator.name();
/*  927 */     ChunkGenerator generator = creator.generator();
/*  928 */     File folder = new File(getWorldContainer(), name);
/*  929 */     World world = getWorld(name);
/*  930 */     WorldType type = WorldType.getType(creator.type().getName());
/*  931 */     boolean generateStructures = creator.generateStructures();
/*      */     
/*  933 */     if (world != null) {
/*  934 */       return world;
/*      */     }
/*      */     
/*  937 */     if (folder.exists() && !folder.isDirectory()) {
/*  938 */       throw new IllegalArgumentException("File exists with the name '" + name + "' and isn't a folder");
/*      */     }
/*      */     
/*  941 */     if (generator == null) {
/*  942 */       generator = getGenerator(name);
/*      */     }
/*      */     
/*  945 */     WorldLoaderServer worldLoaderServer = new WorldLoaderServer(getWorldContainer());
/*  946 */     if (worldLoaderServer.isConvertable(name)) {
/*  947 */       getLogger().info("Converting world '" + name + "'");
/*  948 */       worldLoaderServer.convert(name, (IProgressUpdate)new ConvertProgressUpdater(this.console));
/*      */     } 
/*      */     
/*  951 */     int dimension = 10 + this.console.worlds.size();
/*  952 */     boolean used = false;
/*      */     while (true) {
/*  954 */       for (WorldServer server : this.console.worlds) {
/*  955 */         used = (server.dimension == dimension);
/*  956 */         if (used) {
/*  957 */           dimension++;
/*      */           break;
/*      */         } 
/*      */       } 
/*  961 */       if (!used) {
/*  962 */         boolean hardcore = false;
/*      */         
/*  964 */         WorldServer internal = new WorldServer(this.console, (IDataManager)new ServerNBTManager(getWorldContainer(), name, true), name, dimension, new WorldSettings(creator.seed(), EnumGamemode.getById(getDefaultGameMode().getValue()), generateStructures, hardcore, type), this.console.methodProfiler, creator.environment(), generator);
/*      */         
/*  966 */         if (!this.worlds.containsKey(name.toLowerCase())) {
/*  967 */           return null;
/*      */         }
/*      */         
/*  970 */         internal.scoreboard = getScoreboardManager().getMainScoreboard().getHandle();
/*      */         
/*  972 */         internal.tracker = new EntityTracker(internal);
/*  973 */         internal.addIWorldAccess((IWorldAccess)new WorldManager(this.console, internal));
/*  974 */         internal.difficulty = EnumDifficulty.EASY;
/*  975 */         internal.setSpawnFlags(true, true);
/*  976 */         this.console.worlds.add(internal);
/*      */         
/*  978 */         if (generator != null) {
/*  979 */           internal.getWorld().getPopulators().addAll(generator.getDefaultPopulators(internal.getWorld()));
/*      */         }
/*      */         
/*  982 */         this.pluginManager.callEvent((Event)new WorldInitEvent(internal.getWorld()));
/*  983 */         System.out.print("Preparing start region for level " + (this.console.worlds.size() - 1) + " (Seed: " + internal.getSeed() + ")");
/*      */         
/*  985 */         if (internal.getWorld().getKeepSpawnInMemory()) {
/*  986 */           short short1 = 196;
/*  987 */           long i = System.currentTimeMillis();
/*  988 */           for (int j = -short1; j <= short1; j += 16) {
/*  989 */             for (int k = -short1; k <= short1; k += 16) {
/*  990 */               long l = System.currentTimeMillis();
/*      */               
/*  992 */               if (l < i) {
/*  993 */                 i = l;
/*      */               }
/*      */               
/*  996 */               if (l > i + 1000L) {
/*  997 */                 int i1 = (short1 * 2 + 1) * (short1 * 2 + 1);
/*  998 */                 int j1 = (j + short1) * (short1 * 2 + 1) + k + 1;
/*      */                 
/* 1000 */                 System.out.println("Preparing spawn area for " + name + ", " + (j1 * 100 / i1) + "%");
/* 1001 */                 i = l;
/*      */               } 
/*      */               
/* 1004 */               ChunkCoordinates chunkcoordinates = internal.getSpawn();
/* 1005 */               internal.chunkProviderServer.getChunkAt(chunkcoordinates.x + j >> 4, chunkcoordinates.z + k >> 4);
/*      */             } 
/*      */           } 
/*      */         } 
/* 1009 */         this.pluginManager.callEvent((Event)new WorldLoadEvent(internal.getWorld()));
/* 1010 */         return internal.getWorld();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   public boolean unloadWorld(String name, boolean save) {
/* 1015 */     return unloadWorld(getWorld(name), save);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean unloadWorld(World world, boolean save) {
/* 1020 */     if (world == null) {
/* 1021 */       return false;
/*      */     }
/*      */     
/* 1024 */     WorldServer handle = ((CraftWorld)world).getHandle();
/*      */     
/* 1026 */     if (!this.console.worlds.contains(handle)) {
/* 1027 */       return false;
/*      */     }
/*      */     
/* 1030 */     if (handle.dimension <= 1) {
/* 1031 */       return false;
/*      */     }
/*      */     
/* 1034 */     if (handle.players.size() > 0) {
/* 1035 */       return false;
/*      */     }
/*      */     
/* 1038 */     WorldUnloadEvent e = new WorldUnloadEvent(handle.getWorld());
/* 1039 */     this.pluginManager.callEvent((Event)e);
/*      */     
/* 1041 */     if (e.isCancelled()) {
/* 1042 */       return false;
/*      */     }
/*      */     
/* 1045 */     if (save) {
/*      */       try {
/* 1047 */         handle.save(true, null);
/* 1048 */         handle.saveLevel();
/* 1049 */         WorldSaveEvent event = new WorldSaveEvent(handle.getWorld());
/* 1050 */         getPluginManager().callEvent((Event)event);
/* 1051 */       } catch (ExceptionWorldConflict ex) {
/* 1052 */         getLogger().log(Level.SEVERE, (String)null, (Throwable)ex);
/*      */       } 
/*      */     }
/*      */     
/* 1056 */     this.worlds.remove(world.getName().toLowerCase());
/* 1057 */     this.console.worlds.remove(this.console.worlds.indexOf(handle));
/*      */     
/* 1059 */     return true;
/*      */   }
/*      */   
/*      */   public MinecraftServer getServer() {
/* 1063 */     return this.console;
/*      */   }
/*      */ 
/*      */   
/*      */   public World getWorld(String name) {
/* 1068 */     Validate.notNull(name, "Name cannot be null");
/*      */     
/* 1070 */     return this.worlds.get(name.toLowerCase());
/*      */   }
/*      */ 
/*      */   
/*      */   public World getWorld(UUID uid) {
/* 1075 */     for (World world : this.worlds.values()) {
/* 1076 */       if (world.getUID().equals(uid)) {
/* 1077 */         return world;
/*      */       }
/*      */     } 
/* 1080 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public void addWorld(World world) {
/* 1085 */     if (getWorld(world.getUID()) != null) {
/* 1086 */       System.out.println("World " + world.getName() + " is a duplicate of another world and has been prevented from loading. Please delete the uid.dat file from " + world.getName() + "'s world directory if you want to be able to load the duplicate world.");
/*      */       return;
/*      */     } 
/* 1089 */     this.worlds.put(world.getName().toLowerCase(), world);
/*      */   }
/*      */ 
/*      */   
/*      */   public Logger getLogger() {
/* 1094 */     return this.logger;
/*      */   }
/*      */   
/*      */   public ConsoleReader getReader() {
/* 1098 */     return this.console.reader;
/*      */   }
/*      */ 
/*      */   
/*      */   public PluginCommand getPluginCommand(String name) {
/* 1103 */     Command command = this.commandMap.getCommand(name);
/*      */     
/* 1105 */     if (command instanceof PluginCommand) {
/* 1106 */       return (PluginCommand)command;
/*      */     }
/* 1108 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void savePlayers() {
/* 1114 */     checkSaveState();
/* 1115 */     this.playerList.savePlayers();
/*      */   }
/*      */ 
/*      */   
/*      */   public void configureDbConfig(ServerConfig config) {
/* 1120 */     Validate.notNull(config, "Config cannot be null");
/*      */     
/* 1122 */     DataSourceConfig ds = new DataSourceConfig();
/* 1123 */     ds.setDriver(this.configuration.getString("database.driver"));
/* 1124 */     ds.setUrl(this.configuration.getString("database.url"));
/* 1125 */     ds.setUsername(this.configuration.getString("database.username"));
/* 1126 */     ds.setPassword(this.configuration.getString("database.password"));
/* 1127 */     ds.setIsolationLevel(TransactionIsolation.getLevel(this.configuration.getString("database.isolation")));
/*      */     
/* 1129 */     if (ds.getDriver().contains("sqlite")) {
/* 1130 */       config.setDatabasePlatform((DatabasePlatform)new SQLitePlatform());
/* 1131 */       config.getDatabasePlatform().getDbDdlSyntax().setIdentity("");
/*      */     } 
/*      */     
/* 1134 */     config.setDataSourceConfig(ds);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean addRecipe(Recipe recipe) {
/*      */     CraftFurnaceRecipe craftFurnaceRecipe;
/* 1140 */     if (recipe instanceof CraftRecipe) {
/* 1141 */       CraftRecipe toAdd = (CraftRecipe)recipe;
/*      */     }
/* 1143 */     else if (recipe instanceof ShapedRecipe) {
/* 1144 */       CraftShapedRecipe craftShapedRecipe = CraftShapedRecipe.fromBukkitRecipe((ShapedRecipe)recipe);
/* 1145 */     } else if (recipe instanceof ShapelessRecipe) {
/* 1146 */       CraftShapelessRecipe craftShapelessRecipe = CraftShapelessRecipe.fromBukkitRecipe((ShapelessRecipe)recipe);
/* 1147 */     } else if (recipe instanceof FurnaceRecipe) {
/* 1148 */       craftFurnaceRecipe = CraftFurnaceRecipe.fromBukkitRecipe((FurnaceRecipe)recipe);
/*      */     } else {
/* 1150 */       return false;
/*      */     } 
/*      */     
/* 1153 */     craftFurnaceRecipe.addToCraftingManager();
/* 1154 */     CraftingManager.getInstance().sort();
/* 1155 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<Recipe> getRecipesFor(ItemStack result) {
/* 1160 */     Validate.notNull(result, "Result cannot be null");
/*      */     
/* 1162 */     List<Recipe> results = new ArrayList<Recipe>();
/* 1163 */     Iterator<Recipe> iter = recipeIterator();
/* 1164 */     while (iter.hasNext()) {
/* 1165 */       Recipe recipe = iter.next();
/* 1166 */       ItemStack stack = recipe.getResult();
/* 1167 */       if (stack.getType() != result.getType()) {
/*      */         continue;
/*      */       }
/* 1170 */       if (result.getDurability() == -1 || result.getDurability() == stack.getDurability()) {
/* 1171 */         results.add(recipe);
/*      */       }
/*      */     } 
/* 1174 */     return results;
/*      */   }
/*      */ 
/*      */   
/*      */   public Iterator<Recipe> recipeIterator() {
/* 1179 */     return (Iterator<Recipe>)new RecipeIterator();
/*      */   }
/*      */ 
/*      */   
/*      */   public void clearRecipes() {
/* 1184 */     (CraftingManager.getInstance()).recipes.clear();
/* 1185 */     (RecipesFurnace.getInstance()).recipes.clear();
/* 1186 */     (RecipesFurnace.getInstance()).customRecipes.clear();
/*      */   }
/*      */ 
/*      */   
/*      */   public void resetRecipes() {
/* 1191 */     (CraftingManager.getInstance()).recipes = (new CraftingManager()).recipes;
/* 1192 */     (RecipesFurnace.getInstance()).recipes = (new RecipesFurnace()).recipes;
/* 1193 */     (RecipesFurnace.getInstance()).customRecipes.clear();
/*      */   }
/*      */ 
/*      */   
/*      */   public Map<String, String[]> getCommandAliases() {
/* 1198 */     ConfigurationSection section = this.commandsConfiguration.getConfigurationSection("aliases");
/* 1199 */     Map<String, String[]> result = (Map)new LinkedHashMap<String, String>();
/*      */     
/* 1201 */     if (section != null) {
/* 1202 */       for (String key : section.getKeys(false)) {
/*      */         ImmutableList immutableList;
/*      */         
/* 1205 */         if (section.isList(key)) {
/* 1206 */           List<String> commands = section.getStringList(key);
/*      */         } else {
/* 1208 */           immutableList = ImmutableList.of(section.getString(key));
/*      */         } 
/*      */         
/* 1211 */         result.put(key, (String[])immutableList.toArray((Object[])new String[immutableList.size()]));
/*      */       } 
/*      */     }
/*      */     
/* 1215 */     return result;
/*      */   }
/*      */   
/*      */   public void removeBukkitSpawnRadius() {
/* 1219 */     this.configuration.set("settings.spawn-radius", null);
/* 1220 */     saveConfig();
/*      */   }
/*      */   
/*      */   public int getBukkitSpawnRadius() {
/* 1224 */     return this.configuration.getInt("settings.spawn-radius", -1);
/*      */   }
/*      */ 
/*      */   
/*      */   public String getShutdownMessage() {
/* 1229 */     return this.configuration.getString("settings.shutdown-message");
/*      */   }
/*      */ 
/*      */   
/*      */   public int getSpawnRadius() {
/* 1234 */     return ((DedicatedServer)this.console).propertyManager.getInt("spawn-protection", 16);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setSpawnRadius(int value) {
/* 1239 */     this.configuration.set("settings.spawn-radius", Integer.valueOf(value));
/* 1240 */     saveConfig();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean getOnlineMode() {
/* 1245 */     return this.online.value;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean getAllowFlight() {
/* 1250 */     return this.console.getAllowFlight();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isHardcore() {
/* 1255 */     return this.console.isHardcore();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean useExactLoginLocation() {
/* 1260 */     return this.configuration.getBoolean("settings.use-exact-login-location");
/*      */   }
/*      */   
/*      */   public ChunkGenerator getGenerator(String world) {
/* 1264 */     ConfigurationSection section = this.configuration.getConfigurationSection("worlds");
/* 1265 */     ChunkGenerator result = null;
/*      */     
/* 1267 */     if (section != null) {
/* 1268 */       section = section.getConfigurationSection(world);
/*      */       
/* 1270 */       if (section != null) {
/* 1271 */         String name = section.getString("generator");
/*      */         
/* 1273 */         if (name != null && !name.equals("")) {
/* 1274 */           String[] split = name.split(":", 2);
/* 1275 */           String id = (split.length > 1) ? split[1] : null;
/* 1276 */           Plugin plugin = this.pluginManager.getPlugin(split[0]);
/*      */           
/* 1278 */           if (plugin == null) {
/* 1279 */             getLogger().severe("Could not set generator for default world '" + world + "': Plugin '" + split[0] + "' does not exist");
/* 1280 */           } else if (!plugin.isEnabled()) {
/* 1281 */             getLogger().severe("Could not set generator for default world '" + world + "': Plugin '" + plugin.getDescription().getFullName() + "' is not enabled yet (is it load:STARTUP?)");
/*      */           } else {
/*      */             try {
/* 1284 */               result = plugin.getDefaultWorldGenerator(world, id);
/* 1285 */               if (result == null) {
/* 1286 */                 getLogger().severe("Could not set generator for default world '" + world + "': Plugin '" + plugin.getDescription().getFullName() + "' lacks a default world generator");
/*      */               }
/* 1288 */             } catch (Throwable t) {
/* 1289 */               plugin.getLogger().log(Level.SEVERE, "Could not set generator for default world '" + world + "': Plugin '" + plugin.getDescription().getFullName(), t);
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 1296 */     return result;
/*      */   }
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public CraftMapView getMap(short id) {
/* 1302 */     PersistentCollection collection = ((WorldServer)this.console.worlds.get(0)).worldMaps;
/* 1303 */     WorldMap worldmap = (WorldMap)collection.get(WorldMap.class, "map_" + id);
/* 1304 */     if (worldmap == null) {
/* 1305 */       return null;
/*      */     }
/* 1307 */     return worldmap.mapView;
/*      */   }
/*      */ 
/*      */   
/*      */   public CraftMapView createMap(World world) {
/* 1312 */     Validate.notNull(world, "World cannot be null");
/*      */     
/* 1314 */     ItemStack stack = new ItemStack((Item)Items.MAP, 1, -1);
/* 1315 */     WorldMap worldmap = Items.MAP.getSavedMap(stack, (World)((CraftWorld)world).getHandle());
/* 1316 */     return worldmap.mapView;
/*      */   }
/*      */ 
/*      */   
/*      */   public void shutdown() {
/* 1321 */     this.console.safeShutdown();
/*      */   }
/*      */ 
/*      */   
/*      */   public int broadcast(String message, String permission) {
/* 1326 */     int count = 0;
/* 1327 */     Set<Permissible> permissibles = getPluginManager().getPermissionSubscriptions(permission);
/*      */     
/* 1329 */     for (Permissible permissible : permissibles) {
/* 1330 */       if (permissible instanceof CommandSender && permissible.hasPermission(permission)) {
/* 1331 */         CommandSender user = (CommandSender)permissible;
/* 1332 */         user.sendMessage(message);
/* 1333 */         count++;
/*      */       } 
/*      */     } 
/*      */     
/* 1337 */     return count;
/*      */   }
/*      */   
/*      */   @Deprecated
/*      */   public OfflinePlayer getOfflinePlayer(String name) {
/*      */     OfflinePlayer offlinePlayer;
/* 1343 */     Validate.notNull(name, "Name cannot be null");
/*      */ 
/*      */     
/* 1346 */     if (!this.validUserPattern.matcher(name).matches()) {
/* 1347 */       return new CraftOfflinePlayer(this, new GameProfile(this.invalidUserUUID, name));
/*      */     }
/*      */     
/* 1350 */     Player player = getPlayerExact(name);
/* 1351 */     if (player == null) {
/*      */       
/* 1353 */       GameProfile profile = MinecraftServer.getServer().getUserCache().getProfile(name);
/* 1354 */       if (profile == null) {
/*      */         
/* 1356 */         offlinePlayer = getOfflinePlayer(new GameProfile(UUID.nameUUIDFromBytes(("OfflinePlayer:" + name).getBytes(Charsets.UTF_8)), name));
/*      */       } else {
/*      */         
/* 1359 */         offlinePlayer = getOfflinePlayer(profile);
/*      */       } 
/*      */     } else {
/* 1362 */       this.offlinePlayers.remove(offlinePlayer.getUniqueId());
/*      */     } 
/*      */     
/* 1365 */     return offlinePlayer;
/*      */   }
/*      */   
/*      */   public OfflinePlayer getOfflinePlayer(UUID id) {
/*      */     OfflinePlayer offlinePlayer;
/* 1370 */     Validate.notNull(id, "UUID cannot be null");
/*      */     
/* 1372 */     Player player = getPlayer(id);
/* 1373 */     if (player == null) {
/* 1374 */       offlinePlayer = this.offlinePlayers.get(id);
/* 1375 */       if (offlinePlayer == null) {
/* 1376 */         offlinePlayer = new CraftOfflinePlayer(this, new GameProfile(id, null));
/* 1377 */         this.offlinePlayers.put(id, offlinePlayer);
/*      */       } 
/*      */     } else {
/* 1380 */       this.offlinePlayers.remove(id);
/*      */     } 
/*      */     
/* 1383 */     return offlinePlayer;
/*      */   }
/*      */   
/*      */   public OfflinePlayer getOfflinePlayer(GameProfile profile) {
/* 1387 */     OfflinePlayer player = new CraftOfflinePlayer(this, profile);
/* 1388 */     this.offlinePlayers.put(profile.getId(), player);
/* 1389 */     return player;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Set<String> getIPBans() {
/* 1395 */     return new HashSet<String>(Arrays.asList(this.playerList.getIPBans().getEntries()));
/*      */   }
/*      */ 
/*      */   
/*      */   public void banIP(String address) {
/* 1400 */     Validate.notNull(address, "Address cannot be null.");
/*      */     
/* 1402 */     getBanList(BanList.Type.IP).addBan(address, null, null, null);
/*      */   }
/*      */ 
/*      */   
/*      */   public void unbanIP(String address) {
/* 1407 */     Validate.notNull(address, "Address cannot be null.");
/*      */     
/* 1409 */     getBanList(BanList.Type.IP).pardon(address);
/*      */   }
/*      */ 
/*      */   
/*      */   public Set<OfflinePlayer> getBannedPlayers() {
/* 1414 */     Set<OfflinePlayer> result = new HashSet<OfflinePlayer>();
/*      */     
/* 1416 */     for (JsonListEntry entry : this.playerList.getProfileBans().getValues()) {
/* 1417 */       result.add(getOfflinePlayer((GameProfile)entry.getKey()));
/*      */     }
/*      */     
/* 1420 */     return result;
/*      */   }
/*      */ 
/*      */   
/*      */   public BanList getBanList(BanList.Type type) {
/* 1425 */     Validate.notNull(type, "Type cannot be null");
/*      */     
/* 1427 */     switch (type) {
/*      */       case IP:
/* 1429 */         return new CraftIpBanList(this.playerList.getIPBans());
/*      */     } 
/*      */     
/* 1432 */     return new CraftProfileBanList(this.playerList.getProfileBans());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWhitelist(boolean value) {
/* 1438 */     this.playerList.setHasWhitelist(value);
/* 1439 */     this.console.getPropertyManager().setProperty("white-list", Boolean.valueOf(value));
/*      */   }
/*      */ 
/*      */   
/*      */   public Set<OfflinePlayer> getWhitelistedPlayers() {
/* 1444 */     Set<OfflinePlayer> result = new LinkedHashSet<OfflinePlayer>();
/*      */     
/* 1446 */     for (JsonListEntry entry : this.playerList.getWhitelist().getValues()) {
/* 1447 */       result.add(getOfflinePlayer((GameProfile)entry.getKey()));
/*      */     }
/*      */     
/* 1450 */     return result;
/*      */   }
/*      */ 
/*      */   
/*      */   public Set<OfflinePlayer> getOperators() {
/* 1455 */     Set<OfflinePlayer> result = new HashSet<OfflinePlayer>();
/*      */     
/* 1457 */     for (JsonListEntry entry : this.playerList.getOPs().getValues()) {
/* 1458 */       result.add(getOfflinePlayer((GameProfile)entry.getKey()));
/*      */     }
/*      */     
/* 1461 */     return result;
/*      */   }
/*      */ 
/*      */   
/*      */   public void reloadWhitelist() {
/* 1466 */     this.playerList.reloadWhitelist();
/*      */   }
/*      */ 
/*      */   
/*      */   public GameMode getDefaultGameMode() {
/* 1471 */     return GameMode.getByValue(((WorldServer)this.console.worlds.get(0)).getWorldData().getGameType().getId());
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDefaultGameMode(GameMode mode) {
/* 1476 */     Validate.notNull(mode, "Mode cannot be null");
/*      */     
/* 1478 */     for (World world : getWorlds()) {
/* 1479 */       (((CraftWorld)world).getHandle()).worldData.setGameType(EnumGamemode.getById(mode.getValue()));
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public ConsoleCommandSender getConsoleSender() {
/* 1485 */     return this.console.console;
/*      */   }
/*      */   
/*      */   public EntityMetadataStore getEntityMetadata() {
/* 1489 */     return this.entityMetadata;
/*      */   }
/*      */   
/*      */   public PlayerMetadataStore getPlayerMetadata() {
/* 1493 */     return this.playerMetadata;
/*      */   }
/*      */   
/*      */   public WorldMetadataStore getWorldMetadata() {
/* 1497 */     return this.worldMetadata;
/*      */   }
/*      */ 
/*      */   
/*      */   public void detectListNameConflict(EntityPlayer entityPlayer) {
/* 1502 */     for (int i = 0; i < (getHandle()).players.size(); i++) {
/* 1503 */       EntityPlayer testEntityPlayer = (getHandle()).players.get(i);
/*      */ 
/*      */       
/* 1506 */       if (testEntityPlayer != entityPlayer && testEntityPlayer.listName.equals(entityPlayer.listName)) {
/* 1507 */         String oldName = entityPlayer.listName;
/* 1508 */         int spaceLeft = 16 - oldName.length();
/*      */         
/* 1510 */         if (spaceLeft <= 1) {
/* 1511 */           entityPlayer.listName = oldName.subSequence(0, oldName.length() - 2 - spaceLeft) + String.valueOf(System.currentTimeMillis() % 99L);
/*      */         } else {
/* 1513 */           entityPlayer.listName = oldName + String.valueOf(System.currentTimeMillis() % 99L);
/*      */         } 
/*      */         return;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public File getWorldContainer() {
/* 1523 */     if ((getServer()).universe != null) {
/* 1524 */       return (getServer()).universe;
/*      */     }
/*      */     
/* 1527 */     if (this.container == null) {
/* 1528 */       this.container = new File(this.configuration.getString("settings.world-container", "."));
/*      */     }
/*      */     
/* 1531 */     return this.container;
/*      */   }
/*      */ 
/*      */   
/*      */   public OfflinePlayer[] getOfflinePlayers() {
/* 1536 */     WorldNBTStorage storage = (WorldNBTStorage)((WorldServer)this.console.worlds.get(0)).getDataManager();
/* 1537 */     String[] files = storage.getPlayerDir().list((FilenameFilter)new DatFileFilter());
/* 1538 */     Set<OfflinePlayer> players = new HashSet<OfflinePlayer>();
/*      */     
/* 1540 */     for (String file : files) {
/*      */       try {
/* 1542 */         players.add(getOfflinePlayer(UUID.fromString(file.substring(0, file.length() - 4))));
/* 1543 */       } catch (IllegalArgumentException ex) {}
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1548 */     players.addAll(getOnlinePlayers());
/*      */     
/* 1550 */     return players.<OfflinePlayer>toArray(new OfflinePlayer[players.size()]);
/*      */   }
/*      */ 
/*      */   
/*      */   public Messenger getMessenger() {
/* 1555 */     return (Messenger)this.messenger;
/*      */   }
/*      */ 
/*      */   
/*      */   public void sendPluginMessage(Plugin source, String channel, byte[] message) {
/* 1560 */     StandardMessenger.validatePluginMessage(getMessenger(), source, channel, message);
/*      */     
/* 1562 */     for (Player player : getOnlinePlayers()) {
/* 1563 */       player.sendPluginMessage(source, channel, message);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public Set<String> getListeningPluginChannels() {
/* 1569 */     Set<String> result = new HashSet<String>();
/*      */     
/* 1571 */     for (Player player : getOnlinePlayers()) {
/* 1572 */       result.addAll(player.getListeningPluginChannels());
/*      */     }
/*      */     
/* 1575 */     return result;
/*      */   }
/*      */   
/*      */   public void onPlayerJoin(Player player) {
/* 1579 */     if (this.updater.isEnabled() && this.updater.getCurrent() != null && player.hasPermission("bukkit.broadcast.admin")) {
/* 1580 */       if (this.updater.getCurrent().isBroken() && this.updater.getOnBroken().contains("warn-ops")) {
/* 1581 */         player.sendMessage(ChatColor.DARK_RED + "The version of CraftBukkit that this server is running is known to be broken. Please consider updating to the latest version at dl.bukkit.org.");
/* 1582 */       } else if (this.updater.isUpdateAvailable() && this.updater.getOnUpdate().contains("warn-ops")) {
/* 1583 */         player.sendMessage(ChatColor.DARK_PURPLE + "The version of CraftBukkit that this server is running is out of date. Please consider updating to the latest version at dl.bukkit.org.");
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Inventory createInventory(InventoryHolder owner, InventoryType type) {
/* 1591 */     return (Inventory)new CraftInventoryCustom(owner, type);
/*      */   }
/*      */ 
/*      */   
/*      */   public Inventory createInventory(InventoryHolder owner, InventoryType type, String title) {
/* 1596 */     return (Inventory)new CraftInventoryCustom(owner, type, title);
/*      */   }
/*      */ 
/*      */   
/*      */   public Inventory createInventory(InventoryHolder owner, int size) throws IllegalArgumentException {
/* 1601 */     Validate.isTrue((size % 9 == 0), "Chests must have a size that is a multiple of 9!");
/* 1602 */     return (Inventory)new CraftInventoryCustom(owner, size);
/*      */   }
/*      */ 
/*      */   
/*      */   public Inventory createInventory(InventoryHolder owner, int size, String title) throws IllegalArgumentException {
/* 1607 */     Validate.isTrue((size % 9 == 0), "Chests must have a size that is a multiple of 9!");
/* 1608 */     return (Inventory)new CraftInventoryCustom(owner, size, title);
/*      */   }
/*      */ 
/*      */   
/*      */   public HelpMap getHelpMap() {
/* 1613 */     return (HelpMap)this.helpMap;
/*      */   }
/*      */   
/*      */   public SimpleCommandMap getCommandMap() {
/* 1617 */     return this.commandMap;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getMonsterSpawnLimit() {
/* 1622 */     return this.monsterSpawn;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getAnimalSpawnLimit() {
/* 1627 */     return this.animalSpawn;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getWaterAnimalSpawnLimit() {
/* 1632 */     return this.waterAnimalSpawn;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getAmbientSpawnLimit() {
/* 1637 */     return this.ambientSpawn;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isPrimaryThread() {
/* 1642 */     return Thread.currentThread().equals(this.console.primaryThread);
/*      */   }
/*      */ 
/*      */   
/*      */   public String getMotd() {
/* 1647 */     return this.console.getMotd();
/*      */   }
/*      */ 
/*      */   
/*      */   public Warning.WarningState getWarningState() {
/* 1652 */     return this.warningState;
/*      */   }
/*      */   
/*      */   public List<String> tabComplete(ICommandListener sender, String message) {
/* 1656 */     if (!(sender instanceof EntityPlayer)) {
/* 1657 */       return (List<String>)ImmutableList.of();
/*      */     }
/*      */     
/* 1660 */     CraftPlayer craftPlayer = ((EntityPlayer)sender).getBukkitEntity();
/* 1661 */     if (message.startsWith("/")) {
/* 1662 */       return tabCompleteCommand((Player)craftPlayer, message);
/*      */     }
/* 1664 */     return tabCompleteChat((Player)craftPlayer, message);
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> tabCompleteCommand(Player player, String message) {
/* 1669 */     List<String> completions = null;
/*      */     try {
/* 1671 */       completions = getCommandMap().tabComplete((CommandSender)player, message.substring(1));
/* 1672 */     } catch (CommandException ex) {
/* 1673 */       player.sendMessage(ChatColor.RED + "An internal error occurred while attempting to tab-complete this command");
/* 1674 */       getLogger().log(Level.SEVERE, "Exception when " + player.getName() + " attempted to tab complete " + message, (Throwable)ex);
/*      */     } 
/*      */     
/* 1677 */     return (completions == null) ? (List<String>)ImmutableList.of() : completions;
/*      */   }
/*      */   
/*      */   public List<String> tabCompleteChat(Player player, String message) {
/* 1681 */     List<String> completions = new ArrayList<String>();
/* 1682 */     PlayerChatTabCompleteEvent event = new PlayerChatTabCompleteEvent(player, message, completions);
/* 1683 */     String token = event.getLastToken();
/* 1684 */     for (Player p : getOnlinePlayers()) {
/* 1685 */       if (player.canSee(p) && StringUtil.startsWithIgnoreCase(p.getName(), token)) {
/* 1686 */         completions.add(p.getName());
/*      */       }
/*      */     } 
/* 1689 */     this.pluginManager.callEvent((Event)event);
/*      */     
/* 1691 */     Iterator<?> it = completions.iterator();
/* 1692 */     while (it.hasNext()) {
/* 1693 */       Object current = it.next();
/* 1694 */       if (!(current instanceof String))
/*      */       {
/* 1696 */         it.remove();
/*      */       }
/*      */     } 
/* 1699 */     Collections.sort(completions, String.CASE_INSENSITIVE_ORDER);
/* 1700 */     return completions;
/*      */   }
/*      */ 
/*      */   
/*      */   public CraftItemFactory getItemFactory() {
/* 1705 */     return CraftItemFactory.instance();
/*      */   }
/*      */ 
/*      */   
/*      */   public CraftScoreboardManager getScoreboardManager() {
/* 1710 */     return this.scoreboardManager;
/*      */   }
/*      */   
/*      */   public void checkSaveState() {
/* 1714 */     if (this.playerCommandState || this.printSaveWarning || this.console.autosavePeriod <= 0) {
/*      */       return;
/*      */     }
/* 1717 */     this.printSaveWarning = true;
/* 1718 */     getLogger().log(Level.WARNING, "A manual (plugin-induced) save has been detected while server is configured to auto-save. This may affect performance.", (this.warningState == Warning.WarningState.ON) ? new Throwable() : null);
/*      */   }
/*      */ 
/*      */   
/*      */   public CraftIconCache getServerIcon() {
/* 1723 */     return this.icon;
/*      */   }
/*      */ 
/*      */   
/*      */   public CraftIconCache loadServerIcon(File file) throws Exception {
/* 1728 */     Validate.notNull(file, "File cannot be null");
/* 1729 */     if (!file.isFile()) {
/* 1730 */       throw new IllegalArgumentException(file + " is not a file");
/*      */     }
/* 1732 */     return loadServerIcon0(file);
/*      */   }
/*      */   
/*      */   static CraftIconCache loadServerIcon0(File file) throws Exception {
/* 1736 */     return loadServerIcon0(ImageIO.read(file));
/*      */   }
/*      */ 
/*      */   
/*      */   public CraftIconCache loadServerIcon(BufferedImage image) throws Exception {
/* 1741 */     Validate.notNull(image, "Image cannot be null");
/* 1742 */     return loadServerIcon0(image);
/*      */   }
/*      */   
/*      */   static CraftIconCache loadServerIcon0(BufferedImage image) throws Exception {
/* 1746 */     ByteBuf bytebuf = Unpooled.buffer();
/*      */     
/* 1748 */     Validate.isTrue((image.getWidth() == 64), "Must be 64 pixels wide");
/* 1749 */     Validate.isTrue((image.getHeight() == 64), "Must be 64 pixels high");
/* 1750 */     ImageIO.write(image, "PNG", (OutputStream)new ByteBufOutputStream(bytebuf));
/* 1751 */     ByteBuf bytebuf1 = Base64.encode(bytebuf);
/*      */     
/* 1753 */     return new CraftIconCache("data:image/png;base64," + bytebuf1.toString(Charsets.UTF_8));
/*      */   }
/*      */ 
/*      */   
/*      */   public void setIdleTimeout(int threshold) {
/* 1758 */     this.console.setIdleTimeout(threshold);
/*      */   }
/*      */ 
/*      */   
/*      */   public int getIdleTimeout() {
/* 1763 */     return this.console.getIdleTimeout();
/*      */   }
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public UnsafeValues getUnsafe() {
/* 1769 */     return CraftMagicNumbers.INSTANCE;
/*      */   }
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\craftbukkit\v1_7_R4\CraftServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */