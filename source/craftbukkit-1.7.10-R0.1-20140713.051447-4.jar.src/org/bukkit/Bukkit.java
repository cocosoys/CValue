/*     */ package org.bukkit;
/*     */ 
/*     */ import com.avaje.ebean.config.ServerConfig;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.File;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.UUID;
/*     */ import java.util.logging.Logger;
/*     */ import org.bukkit.command.CommandException;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.command.ConsoleCommandSender;
/*     */ import org.bukkit.command.PluginCommand;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.inventory.InventoryType;
/*     */ import org.bukkit.help.HelpMap;
/*     */ import org.bukkit.inventory.Inventory;
/*     */ import org.bukkit.inventory.InventoryHolder;
/*     */ import org.bukkit.inventory.ItemFactory;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.Recipe;
/*     */ import org.bukkit.map.MapView;
/*     */ import org.bukkit.plugin.PluginManager;
/*     */ import org.bukkit.plugin.ServicesManager;
/*     */ import org.bukkit.plugin.messaging.Messenger;
/*     */ import org.bukkit.scheduler.BukkitScheduler;
/*     */ import org.bukkit.scoreboard.ScoreboardManager;
/*     */ import org.bukkit.util.CachedServerIcon;
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
/*     */ public final class Bukkit
/*     */ {
/*     */   private static Server server;
/*     */   
/*     */   public static Server getServer() {
/*  53 */     return server;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setServer(Server server) {
/*  64 */     if (Bukkit.server != null) {
/*  65 */       throw new UnsupportedOperationException("Cannot redefine singleton Server");
/*     */     }
/*     */     
/*  68 */     Bukkit.server = server;
/*  69 */     server.getLogger().info("This server is running " + getName() + " version " + getVersion() + " (Implementing API version " + getBukkitVersion() + ")");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getName() {
/*  76 */     return server.getName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getVersion() {
/*  83 */     return server.getVersion();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getBukkitVersion() {
/*  90 */     return server.getBukkitVersion();
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
/*     */   @Deprecated
/*     */   public static Player[] getOnlinePlayers() {
/* 103 */     return server.getOnlinePlayers();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Collection<? extends Player> getOnlinePlayers() {
/* 110 */     return server.getOnlinePlayers();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getMaxPlayers() {
/* 117 */     return server.getMaxPlayers();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getPort() {
/* 124 */     return server.getPort();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getViewDistance() {
/* 131 */     return server.getViewDistance();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getIp() {
/* 138 */     return server.getIp();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getServerName() {
/* 145 */     return server.getServerName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getServerId() {
/* 152 */     return server.getServerId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getWorldType() {
/* 159 */     return server.getWorldType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean getGenerateStructures() {
/* 166 */     return server.getGenerateStructures();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean getAllowNether() {
/* 173 */     return server.getAllowNether();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean hasWhitelist() {
/* 180 */     return server.hasWhitelist();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int broadcastMessage(String message) {
/* 187 */     return server.broadcastMessage(message);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getUpdateFolder() {
/* 194 */     return server.getUpdateFolder();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static Player getPlayer(String name) {
/* 202 */     return server.getPlayer(name);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static List<Player> matchPlayer(String name) {
/* 210 */     return server.matchPlayer(name);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Player getPlayer(UUID id) {
/* 217 */     return server.getPlayer(id);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static PluginManager getPluginManager() {
/* 224 */     return server.getPluginManager();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static BukkitScheduler getScheduler() {
/* 231 */     return server.getScheduler();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ServicesManager getServicesManager() {
/* 238 */     return server.getServicesManager();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<World> getWorlds() {
/* 245 */     return server.getWorlds();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static World createWorld(WorldCreator options) {
/* 252 */     return server.createWorld(options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean unloadWorld(String name, boolean save) {
/* 259 */     return server.unloadWorld(name, save);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean unloadWorld(World world, boolean save) {
/* 266 */     return server.unloadWorld(world, save);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static World getWorld(String name) {
/* 273 */     return server.getWorld(name);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static World getWorld(UUID uid) {
/* 280 */     return server.getWorld(uid);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static MapView getMap(short id) {
/* 289 */     return server.getMap(id);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static MapView createMap(World world) {
/* 296 */     return server.createMap(world);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void reload() {
/* 303 */     server.reload();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Logger getLogger() {
/* 310 */     return server.getLogger();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static PluginCommand getPluginCommand(String name) {
/* 317 */     return server.getPluginCommand(name);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void savePlayers() {
/* 324 */     server.savePlayers();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean dispatchCommand(CommandSender sender, String commandLine) throws CommandException {
/* 331 */     return server.dispatchCommand(sender, commandLine);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void configureDbConfig(ServerConfig config) {
/* 338 */     server.configureDbConfig(config);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean addRecipe(Recipe recipe) {
/* 345 */     return server.addRecipe(recipe);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<Recipe> getRecipesFor(ItemStack result) {
/* 352 */     return server.getRecipesFor(result);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Iterator<Recipe> recipeIterator() {
/* 359 */     return server.recipeIterator();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void clearRecipes() {
/* 366 */     server.clearRecipes();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void resetRecipes() {
/* 373 */     server.resetRecipes();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Map<String, String[]> getCommandAliases() {
/* 380 */     return server.getCommandAliases();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getSpawnRadius() {
/* 387 */     return server.getSpawnRadius();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setSpawnRadius(int value) {
/* 394 */     server.setSpawnRadius(value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean getOnlineMode() {
/* 401 */     return server.getOnlineMode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean getAllowFlight() {
/* 408 */     return server.getAllowFlight();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isHardcore() {
/* 415 */     return server.isHardcore();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void shutdown() {
/* 422 */     server.shutdown();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int broadcast(String message, String permission) {
/* 429 */     return server.broadcast(message, permission);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static OfflinePlayer getOfflinePlayer(String name) {
/* 437 */     return server.getOfflinePlayer(name);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static OfflinePlayer getOfflinePlayer(UUID id) {
/* 444 */     return server.getOfflinePlayer(id);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static Player getPlayerExact(String name) {
/* 452 */     return server.getPlayerExact(name);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Set<String> getIPBans() {
/* 459 */     return server.getIPBans();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void banIP(String address) {
/* 466 */     server.banIP(address);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void unbanIP(String address) {
/* 473 */     server.unbanIP(address);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Set<OfflinePlayer> getBannedPlayers() {
/* 480 */     return server.getBannedPlayers();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static BanList getBanList(BanList.Type type) {
/* 487 */     return server.getBanList(type);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setWhitelist(boolean value) {
/* 494 */     server.setWhitelist(value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Set<OfflinePlayer> getWhitelistedPlayers() {
/* 501 */     return server.getWhitelistedPlayers();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void reloadWhitelist() {
/* 508 */     server.reloadWhitelist();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ConsoleCommandSender getConsoleSender() {
/* 515 */     return server.getConsoleSender();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Set<OfflinePlayer> getOperators() {
/* 522 */     return server.getOperators();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static File getWorldContainer() {
/* 529 */     return server.getWorldContainer();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Messenger getMessenger() {
/* 536 */     return server.getMessenger();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean getAllowEnd() {
/* 543 */     return server.getAllowEnd();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static File getUpdateFolderFile() {
/* 550 */     return server.getUpdateFolderFile();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long getConnectionThrottle() {
/* 557 */     return server.getConnectionThrottle();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getTicksPerAnimalSpawns() {
/* 564 */     return server.getTicksPerAnimalSpawns();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getTicksPerMonsterSpawns() {
/* 571 */     return server.getTicksPerMonsterSpawns();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean useExactLoginLocation() {
/* 578 */     return server.useExactLoginLocation();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GameMode getDefaultGameMode() {
/* 585 */     return server.getDefaultGameMode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setDefaultGameMode(GameMode mode) {
/* 592 */     server.setDefaultGameMode(mode);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static OfflinePlayer[] getOfflinePlayers() {
/* 599 */     return server.getOfflinePlayers();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Inventory createInventory(InventoryHolder owner, InventoryType type) {
/* 606 */     return server.createInventory(owner, type);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Inventory createInventory(InventoryHolder owner, InventoryType type, String title) {
/* 613 */     return server.createInventory(owner, type, title);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Inventory createInventory(InventoryHolder owner, int size) throws IllegalArgumentException {
/* 620 */     return server.createInventory(owner, size);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Inventory createInventory(InventoryHolder owner, int size, String title) throws IllegalArgumentException {
/* 628 */     return server.createInventory(owner, size, title);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static HelpMap getHelpMap() {
/* 635 */     return server.getHelpMap();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getMonsterSpawnLimit() {
/* 642 */     return server.getMonsterSpawnLimit();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getAnimalSpawnLimit() {
/* 649 */     return server.getAnimalSpawnLimit();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getWaterAnimalSpawnLimit() {
/* 656 */     return server.getWaterAnimalSpawnLimit();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getAmbientSpawnLimit() {
/* 663 */     return server.getAmbientSpawnLimit();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isPrimaryThread() {
/* 670 */     return server.isPrimaryThread();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getMotd() {
/* 677 */     return server.getMotd();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getShutdownMessage() {
/* 684 */     return server.getShutdownMessage();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Warning.WarningState getWarningState() {
/* 691 */     return server.getWarningState();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ItemFactory getItemFactory() {
/* 698 */     return server.getItemFactory();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ScoreboardManager getScoreboardManager() {
/* 705 */     return server.getScoreboardManager();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CachedServerIcon getServerIcon() {
/* 712 */     return server.getServerIcon();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CachedServerIcon loadServerIcon(File file) throws IllegalArgumentException, Exception {
/* 719 */     return server.loadServerIcon(file);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CachedServerIcon loadServerIcon(BufferedImage image) throws IllegalArgumentException, Exception {
/* 726 */     return server.loadServerIcon(image);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setIdleTimeout(int threshold) {
/* 733 */     server.setIdleTimeout(threshold);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getIdleTimeout() {
/* 740 */     return server.getIdleTimeout();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static UnsafeValues getUnsafe() {
/* 748 */     return server.getUnsafe();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\Bukkit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */