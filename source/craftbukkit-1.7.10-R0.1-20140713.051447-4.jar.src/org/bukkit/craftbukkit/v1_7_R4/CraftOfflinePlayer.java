/*     */ package org.bukkit.craftbukkit.v1_7_R4;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.server.v1_7_R4.EntityPlayer;
/*     */ import net.minecraft.server.v1_7_R4.NBTBase;
/*     */ import net.minecraft.server.v1_7_R4.NBTTagCompound;
/*     */ import net.minecraft.server.v1_7_R4.WorldNBTStorage;
/*     */ import net.minecraft.server.v1_7_R4.WorldServer;
/*     */ import net.minecraft.util.com.mojang.authlib.GameProfile;
/*     */ import org.bukkit.BanList;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.OfflinePlayer;
/*     */ import org.bukkit.Server;
/*     */ import org.bukkit.World;
/*     */ import org.bukkit.configuration.serialization.ConfigurationSerializable;
/*     */ import org.bukkit.configuration.serialization.SerializableAs;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.metadata.MetadataValue;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ 
/*     */ @SerializableAs("Player")
/*     */ public class CraftOfflinePlayer
/*     */   implements OfflinePlayer, ConfigurationSerializable {
/*     */   private final GameProfile profile;
/*     */   
/*     */   protected CraftOfflinePlayer(CraftServer server, GameProfile profile) {
/*  32 */     this.server = server;
/*  33 */     this.profile = profile;
/*  34 */     this.storage = (WorldNBTStorage)((WorldServer)server.console.worlds.get(0)).getDataManager();
/*     */   }
/*     */   private final CraftServer server; private final WorldNBTStorage storage;
/*     */   
/*     */   public GameProfile getProfile() {
/*  39 */     return this.profile;
/*     */   }
/*     */   
/*     */   public boolean isOnline() {
/*  43 */     return (getPlayer() != null);
/*     */   }
/*     */   
/*     */   public String getName() {
/*  47 */     Player player = getPlayer();
/*  48 */     if (player != null) {
/*  49 */       return player.getName();
/*     */     }
/*     */ 
/*     */     
/*  53 */     if (this.profile.getName() != null) {
/*  54 */       return this.profile.getName();
/*     */     }
/*     */     
/*  57 */     NBTTagCompound data = getBukkitData();
/*     */     
/*  59 */     if (data != null && 
/*  60 */       data.hasKey("lastKnownName")) {
/*  61 */       return data.getString("lastKnownName");
/*     */     }
/*     */ 
/*     */     
/*  65 */     return null;
/*     */   }
/*     */   
/*     */   public UUID getUniqueId() {
/*  69 */     return this.profile.getId();
/*     */   }
/*     */   
/*     */   public Server getServer() {
/*  73 */     return this.server;
/*     */   }
/*     */   
/*     */   public boolean isOp() {
/*  77 */     return this.server.getHandle().isOp(this.profile);
/*     */   }
/*     */   
/*     */   public void setOp(boolean value) {
/*  81 */     if (value == isOp()) {
/*     */       return;
/*     */     }
/*     */     
/*  85 */     if (value) {
/*  86 */       this.server.getHandle().addOp(this.profile);
/*     */     } else {
/*  88 */       this.server.getHandle().removeOp(this.profile);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isBanned() {
/*  93 */     if (getName() == null) {
/*  94 */       return false;
/*     */     }
/*     */     
/*  97 */     return this.server.getBanList(BanList.Type.NAME).isBanned(getName());
/*     */   }
/*     */   
/*     */   public void setBanned(boolean value) {
/* 101 */     if (getName() == null) {
/*     */       return;
/*     */     }
/*     */     
/* 105 */     if (value) {
/* 106 */       this.server.getBanList(BanList.Type.NAME).addBan(getName(), null, null, null);
/*     */     } else {
/* 108 */       this.server.getBanList(BanList.Type.NAME).pardon(getName());
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isWhitelisted() {
/* 113 */     return this.server.getHandle().getWhitelist().isWhitelisted(this.profile);
/*     */   }
/*     */   
/*     */   public void setWhitelisted(boolean value) {
/* 117 */     if (value) {
/* 118 */       this.server.getHandle().addWhitelist(this.profile);
/*     */     } else {
/* 120 */       this.server.getHandle().removeWhitelist(this.profile);
/*     */     } 
/*     */   }
/*     */   
/*     */   public Map<String, Object> serialize() {
/* 125 */     Map<String, Object> result = new LinkedHashMap<String, Object>();
/*     */     
/* 127 */     result.put("UUID", this.profile.getId().toString());
/*     */     
/* 129 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   public static OfflinePlayer deserialize(Map<String, Object> args) {
/* 134 */     if (args.get("name") != null) {
/* 135 */       return Bukkit.getServer().getOfflinePlayer((String)args.get("name"));
/*     */     }
/*     */     
/* 138 */     return Bukkit.getServer().getOfflinePlayer(UUID.fromString((String)args.get("UUID")));
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 143 */     return getClass().getSimpleName() + "[UUID=" + this.profile.getId() + "]";
/*     */   }
/*     */   
/*     */   public Player getPlayer() {
/* 147 */     for (Object obj : (this.server.getHandle()).players) {
/* 148 */       EntityPlayer player = (EntityPlayer)obj;
/* 149 */       if (player.getUniqueID().equals(getUniqueId())) {
/* 150 */         return (player.playerConnection != null) ? (Player)player.playerConnection.getPlayer() : null;
/*     */       }
/*     */     } 
/*     */     
/* 154 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object obj) {
/* 159 */     if (obj == null || !(obj instanceof OfflinePlayer)) {
/* 160 */       return false;
/*     */     }
/*     */     
/* 163 */     OfflinePlayer other = (OfflinePlayer)obj;
/* 164 */     if (getUniqueId() == null || other.getUniqueId() == null) {
/* 165 */       return false;
/*     */     }
/*     */     
/* 168 */     return getUniqueId().equals(other.getUniqueId());
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 173 */     int hash = 5;
/* 174 */     hash = 97 * hash + ((getUniqueId() != null) ? getUniqueId().hashCode() : 0);
/* 175 */     return hash;
/*     */   }
/*     */   
/*     */   private NBTTagCompound getData() {
/* 179 */     return this.storage.getPlayerData(getUniqueId().toString());
/*     */   }
/*     */   
/*     */   private NBTTagCompound getBukkitData() {
/* 183 */     NBTTagCompound result = getData();
/*     */     
/* 185 */     if (result != null) {
/* 186 */       if (!result.hasKey("bukkit")) {
/* 187 */         result.set("bukkit", (NBTBase)new NBTTagCompound());
/*     */       }
/* 189 */       result = result.getCompound("bukkit");
/*     */     } 
/*     */     
/* 192 */     return result;
/*     */   }
/*     */   
/*     */   private File getDataFile() {
/* 196 */     return new File(this.storage.getPlayerDir(), getUniqueId() + ".dat");
/*     */   }
/*     */   
/*     */   public long getFirstPlayed() {
/* 200 */     Player player = getPlayer();
/* 201 */     if (player != null) return player.getFirstPlayed();
/*     */     
/* 203 */     NBTTagCompound data = getBukkitData();
/*     */     
/* 205 */     if (data != null) {
/* 206 */       if (data.hasKey("firstPlayed")) {
/* 207 */         return data.getLong("firstPlayed");
/*     */       }
/* 209 */       File file = getDataFile();
/* 210 */       return file.lastModified();
/*     */     } 
/*     */     
/* 213 */     return 0L;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getLastPlayed() {
/* 218 */     Player player = getPlayer();
/* 219 */     if (player != null) return player.getLastPlayed();
/*     */     
/* 221 */     NBTTagCompound data = getBukkitData();
/*     */     
/* 223 */     if (data != null) {
/* 224 */       if (data.hasKey("lastPlayed")) {
/* 225 */         return data.getLong("lastPlayed");
/*     */       }
/* 227 */       File file = getDataFile();
/* 228 */       return file.lastModified();
/*     */     } 
/*     */     
/* 231 */     return 0L;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasPlayedBefore() {
/* 236 */     return (getData() != null);
/*     */   }
/*     */   
/*     */   public Location getBedSpawnLocation() {
/* 240 */     NBTTagCompound data = getData();
/* 241 */     if (data == null) return null;
/*     */     
/* 243 */     if (data.hasKey("SpawnX") && data.hasKey("SpawnY") && data.hasKey("SpawnZ")) {
/* 244 */       String spawnWorld = data.getString("SpawnWorld");
/* 245 */       if (spawnWorld.equals("")) {
/* 246 */         spawnWorld = ((World)this.server.getWorlds().get(0)).getName();
/*     */       }
/* 248 */       return new Location(this.server.getWorld(spawnWorld), data.getInt("SpawnX"), data.getInt("SpawnY"), data.getInt("SpawnZ"));
/*     */     } 
/* 250 */     return null;
/*     */   }
/*     */   
/*     */   public void setMetadata(String metadataKey, MetadataValue metadataValue) {
/* 254 */     this.server.getPlayerMetadata().setMetadata(this, metadataKey, metadataValue);
/*     */   }
/*     */   
/*     */   public List<MetadataValue> getMetadata(String metadataKey) {
/* 258 */     return this.server.getPlayerMetadata().getMetadata(this, metadataKey);
/*     */   }
/*     */   
/*     */   public boolean hasMetadata(String metadataKey) {
/* 262 */     return this.server.getPlayerMetadata().hasMetadata(this, metadataKey);
/*     */   }
/*     */   
/*     */   public void removeMetadata(String metadataKey, Plugin plugin) {
/* 266 */     this.server.getPlayerMetadata().removeMetadata(this, metadataKey, plugin);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\craftbukkit\v1_7_R4\CraftOfflinePlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */