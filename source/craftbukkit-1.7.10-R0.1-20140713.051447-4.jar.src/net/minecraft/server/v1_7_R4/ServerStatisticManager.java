/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import net.minecraft.util.com.google.common.collect.Maps;
/*     */ import net.minecraft.util.com.google.common.collect.Sets;
/*     */ import net.minecraft.util.com.google.gson.JsonElement;
/*     */ import net.minecraft.util.com.google.gson.JsonObject;
/*     */ import net.minecraft.util.com.google.gson.JsonParseException;
/*     */ import net.minecraft.util.com.google.gson.JsonParser;
/*     */ import net.minecraft.util.org.apache.commons.io.FileUtils;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ 
/*     */ public class ServerStatisticManager
/*     */   extends StatisticManager
/*     */ {
/*  23 */   private static final Logger b = LogManager.getLogger();
/*     */   
/*     */   private final MinecraftServer c;
/*     */   private final File d;
/*  27 */   private final Set e = Sets.newHashSet();
/*  28 */   private int f = -300;
/*     */   private boolean g = false;
/*     */   
/*     */   public ServerStatisticManager(MinecraftServer paramMinecraftServer, File paramFile) {
/*  32 */     this.c = paramMinecraftServer;
/*  33 */     this.d = paramFile;
/*     */   }
/*     */   
/*     */   public void a() {
/*  37 */     if (this.d.isFile()) {
/*     */       try {
/*  39 */         this.a.clear();
/*  40 */         this.a.putAll(a(FileUtils.readFileToString(this.d)));
/*  41 */       } catch (IOException iOException) {
/*  42 */         b.error("Couldn't read statistics file " + this.d, iOException);
/*  43 */       } catch (JsonParseException jsonParseException) {
/*  44 */         b.error("Couldn't parse statistics file " + this.d, (Throwable)jsonParseException);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public void b() {
/*     */     try {
/*  51 */       FileUtils.writeStringToFile(this.d, a(this.a));
/*  52 */     } catch (IOException iOException) {
/*  53 */       b.error("Couldn't save stats", iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setStatistic(EntityHuman paramEntityHuman, Statistic paramStatistic, int paramInt) {
/*  59 */     boolean bool = paramStatistic.d() ? getStatisticValue(paramStatistic) : false;
/*  60 */     super.setStatistic(paramEntityHuman, paramStatistic, paramInt);
/*  61 */     this.e.add(paramStatistic);
/*     */     
/*  63 */     if (paramStatistic.d() && !bool && paramInt > 0) {
/*  64 */       this.g = true;
/*  65 */       if (this.c.at()) {
/*  66 */         this.c.getPlayerList().sendMessage(new ChatMessage("chat.type.achievement", new Object[] { paramEntityHuman.getScoreboardDisplayName(), paramStatistic.j() }));
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public Set c() {
/*  72 */     HashSet hashSet = Sets.newHashSet(this.e);
/*  73 */     this.e.clear();
/*  74 */     this.g = false;
/*  75 */     return hashSet;
/*     */   }
/*     */   
/*     */   public Map a(String paramString) {
/*  79 */     JsonElement jsonElement = (new JsonParser()).parse(paramString);
/*  80 */     if (!jsonElement.isJsonObject()) return Maps.newHashMap(); 
/*  81 */     JsonObject jsonObject = jsonElement.getAsJsonObject();
/*  82 */     HashMap<Statistic, StatisticWrapper> hashMap = Maps.newHashMap();
/*     */     
/*  84 */     for (Map.Entry entry : jsonObject.entrySet()) {
/*  85 */       Statistic statistic = StatisticList.getStatistic((String)entry.getKey());
/*     */       
/*  87 */       if (statistic != null) {
/*  88 */         StatisticWrapper statisticWrapper = new StatisticWrapper();
/*     */         
/*  90 */         if (((JsonElement)entry.getValue()).isJsonPrimitive() && ((JsonElement)entry.getValue()).getAsJsonPrimitive().isNumber()) {
/*  91 */           statisticWrapper.a(((JsonElement)entry.getValue()).getAsInt());
/*  92 */         } else if (((JsonElement)entry.getValue()).isJsonObject()) {
/*  93 */           JsonObject jsonObject1 = ((JsonElement)entry.getValue()).getAsJsonObject();
/*     */           
/*  95 */           if (jsonObject1.has("value") && jsonObject1.get("value").isJsonPrimitive() && jsonObject1.get("value").getAsJsonPrimitive().isNumber()) {
/*  96 */             statisticWrapper.a(jsonObject1.getAsJsonPrimitive("value").getAsInt());
/*     */           }
/*     */           
/*  99 */           if (jsonObject1.has("progress") && statistic.l() != null) {
/*     */             try {
/* 101 */               Constructor<IJsonStatistic> constructor = statistic.l().getConstructor(new Class[0]);
/* 102 */               IJsonStatistic iJsonStatistic = constructor.newInstance(new Object[0]);
/* 103 */               iJsonStatistic.a(jsonObject1.get("progress"));
/* 104 */               statisticWrapper.a(iJsonStatistic);
/* 105 */             } catch (Throwable throwable) {
/* 106 */               b.warn("Invalid statistic progress in " + this.d, throwable);
/*     */             } 
/*     */           }
/*     */         } 
/*     */         
/* 111 */         hashMap.put(statistic, statisticWrapper); continue;
/*     */       } 
/* 113 */       b.warn("Invalid statistic in " + this.d + ": Don't know what " + (String)entry.getKey() + " is");
/*     */     } 
/*     */ 
/*     */     
/* 117 */     return hashMap;
/*     */   }
/*     */   
/*     */   public static String a(Map paramMap) {
/* 121 */     JsonObject jsonObject = new JsonObject();
/*     */     
/* 123 */     for (Map.Entry entry : paramMap.entrySet()) {
/* 124 */       if (((StatisticWrapper)entry.getValue()).b() != null) {
/* 125 */         JsonObject jsonObject1 = new JsonObject();
/*     */         
/* 127 */         jsonObject1.addProperty("value", Integer.valueOf(((StatisticWrapper)entry.getValue()).a()));
/*     */         
/*     */         try {
/* 130 */           jsonObject1.add("progress", ((StatisticWrapper)entry.getValue()).b().a());
/* 131 */         } catch (Throwable throwable) {
/* 132 */           b.warn("Couldn't save statistic " + ((Statistic)entry.getKey()).e() + ": error serializing progress", throwable);
/*     */         } 
/*     */         
/* 135 */         jsonObject.add(((Statistic)entry.getKey()).name, (JsonElement)jsonObject1); continue;
/*     */       } 
/* 137 */       jsonObject.addProperty(((Statistic)entry.getKey()).name, Integer.valueOf(((StatisticWrapper)entry.getValue()).a()));
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 142 */     return jsonObject.toString();
/*     */   }
/*     */   
/*     */   public void d() {
/* 146 */     for (Statistic statistic : this.a.keySet()) {
/* 147 */       this.e.add(statistic);
/*     */     }
/*     */   }
/*     */   
/*     */   public void a(EntityPlayer paramEntityPlayer) {
/* 152 */     int i = this.c.al();
/* 153 */     HashMap<Statistic, Integer> hashMap = Maps.newHashMap();
/*     */     
/* 155 */     if (this.g || i - this.f > 300) {
/* 156 */       this.f = i;
/*     */       
/* 158 */       for (Statistic statistic : c()) {
/* 159 */         hashMap.put(statistic, Integer.valueOf(getStatisticValue(statistic)));
/*     */       }
/*     */     } 
/*     */     
/* 163 */     paramEntityPlayer.playerConnection.sendPacket(new PacketPlayOutStatistic(hashMap));
/*     */   }
/*     */   
/*     */   public void updateStatistics(EntityPlayer paramEntityPlayer) {
/* 167 */     HashMap<Achievement, Integer> hashMap = Maps.newHashMap();
/*     */     
/* 169 */     for (Achievement achievement : AchievementList.e) {
/* 170 */       if (hasAchievement(achievement)) {
/* 171 */         hashMap.put(achievement, Integer.valueOf(getStatisticValue(achievement)));
/* 172 */         this.e.remove(achievement);
/*     */       } 
/*     */     } 
/*     */     
/* 176 */     paramEntityPlayer.playerConnection.sendPacket(new PacketPlayOutStatistic(hashMap));
/*     */   }
/*     */   
/*     */   public boolean e() {
/* 180 */     return this.g;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\ServerStatisticManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */