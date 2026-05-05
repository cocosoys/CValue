/*     */ package net.minecraftforge.common;
/*     */ 
/*     */ import com.google.common.base.Charsets;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ import com.google.common.collect.Maps;
/*     */ import com.google.common.io.Files;
/*     */ import com.google.common.reflect.TypeToken;
/*     */ import com.google.gson.Gson;
/*     */ import com.google.gson.GsonBuilder;
/*     */ import com.google.gson.JsonSyntaxException;
/*     */ import cpw.mods.fml.relauncher.FMLInjectionData;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.lang.reflect.Type;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.Map;
/*     */ import java.util.UUID;
/*     */ import javax.annotation.Nullable;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
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
/*     */ public final class UsernameCache
/*     */ {
/*  38 */   private static Map<UUID, String> map = Maps.newHashMap();
/*     */   
/*  40 */   private static final Charset charset = Charsets.UTF_8;
/*     */   
/*  42 */   private static final File saveFile = new File((File)FMLInjectionData.data()[6], "usernamecache.json");
/*  43 */   private static final Gson gson = (new GsonBuilder()).setPrettyPrinting().create();
/*     */   
/*  45 */   private static final Logger log = LogManager.getLogger(UsernameCache.class);
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
/*     */   protected static void setUsername(UUID uuid, String username) {
/*  59 */     Preconditions.checkNotNull(uuid);
/*  60 */     Preconditions.checkNotNull(username);
/*     */     
/*  62 */     if (username.equals(map.get(uuid)))
/*     */       return; 
/*  64 */     map.put(uuid, username);
/*  65 */     save();
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
/*     */   protected static boolean removeUsername(UUID uuid) {
/*  77 */     Preconditions.checkNotNull(uuid);
/*     */     
/*  79 */     if (map.remove(uuid) != null) {
/*     */       
/*  81 */       save();
/*  82 */       return true;
/*     */     } 
/*     */     
/*  85 */     return false;
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
/*     */   @Nullable
/*     */   public static String getLastKnownUsername(UUID uuid) {
/* 101 */     Preconditions.checkNotNull(uuid);
/* 102 */     return map.get(uuid);
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
/*     */   public static boolean containsUUID(UUID uuid) {
/* 114 */     Preconditions.checkNotNull(uuid);
/* 115 */     return map.containsKey(uuid);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Map<UUID, String> getMap() {
/* 125 */     return (Map<UUID, String>)ImmutableMap.copyOf(map);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static void save() {
/* 133 */     (new SaveThread(gson.toJson(map))).start();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static void load() {
/* 141 */     if (!saveFile.exists()) {
/*     */       return;
/*     */     }
/*     */     
/*     */     try {
/* 146 */       String json = Files.toString(saveFile, charset);
/* 147 */       Type type = (new TypeToken<Map<UUID, String>>() {  }).getType();
/*     */       
/* 149 */       map = (Map<UUID, String>)gson.fromJson(json, type);
/*     */     }
/* 151 */     catch (JsonSyntaxException e) {
/*     */       
/* 153 */       log.error("Could not parse username cache file as valid json, deleting file", (Throwable)e);
/* 154 */       saveFile.delete();
/*     */     }
/* 156 */     catch (IOException e) {
/*     */       
/* 158 */       log.error("Failed to read username cache file from disk, deleting file", e);
/* 159 */       saveFile.delete();
/*     */     
/*     */     }
/*     */     finally {
/*     */       
/* 164 */       if (map == null)
/*     */       {
/* 166 */         map = Maps.newHashMap();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class SaveThread
/*     */     extends Thread
/*     */   {
/*     */     private final String data;
/*     */ 
/*     */ 
/*     */     
/*     */     public SaveThread(String data) {
/* 182 */       this.data = data;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void run() {
/*     */       try {
/* 191 */         synchronized (UsernameCache.saveFile)
/*     */         {
/* 193 */           Files.write(this.data, UsernameCache.saveFile, UsernameCache.charset);
/*     */         }
/*     */       
/* 196 */       } catch (IOException e) {
/*     */         
/* 198 */         UsernameCache.log.error("Failed to save username cache to file!", e);
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\common\UsernameCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */