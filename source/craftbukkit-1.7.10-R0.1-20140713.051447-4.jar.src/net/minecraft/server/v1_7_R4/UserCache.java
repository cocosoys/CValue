/*     */ package net.minecraft.server.v1_7_R4;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.lang.reflect.ParameterizedType;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.util.com.google.common.base.Charsets;
/*     */ import net.minecraft.util.com.google.common.collect.Lists;
/*     */ import net.minecraft.util.com.google.common.collect.Maps;
/*     */ import net.minecraft.util.com.google.common.io.Files;
/*     */ import net.minecraft.util.com.google.gson.Gson;
/*     */ import net.minecraft.util.com.google.gson.GsonBuilder;
/*     */ import net.minecraft.util.com.mojang.authlib.Agent;
/*     */ import net.minecraft.util.com.mojang.authlib.GameProfile;
/*     */ import net.minecraft.util.org.apache.commons.io.IOUtils;
/*     */ 
/*     */ public class UserCache {
/*  26 */   public static final SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
/*  27 */   private final Map c = Maps.newHashMap();
/*  28 */   private final Map d = Maps.newHashMap();
/*  29 */   private final LinkedList e = Lists.newLinkedList();
/*     */   private final MinecraftServer f;
/*     */   protected final Gson b;
/*     */   private final File g;
/*     */   
/*     */   public UserCache(MinecraftServer paramMinecraftServer, File paramFile) {
/*  35 */     this.f = paramMinecraftServer;
/*  36 */     this.g = paramFile;
/*     */     
/*  38 */     GsonBuilder gsonBuilder = new GsonBuilder();
/*  39 */     gsonBuilder.registerTypeHierarchyAdapter(UserCacheEntry.class, new BanEntrySerializer(this, null));
/*  40 */     this.b = gsonBuilder.create();
/*     */     
/*  42 */     b();
/*     */   }
/*     */   
/*     */   private static GameProfile a(MinecraftServer paramMinecraftServer, String paramString) {
/*  46 */     GameProfile[] arrayOfGameProfile = new GameProfile[1];
/*  47 */     GameProfileLookup gameProfileLookup = new GameProfileLookup(arrayOfGameProfile);
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
/*  59 */     paramMinecraftServer.getGameProfileRepository().findProfilesByNames(new String[] { paramString }, Agent.MINECRAFT, gameProfileLookup);
/*  60 */     if (!paramMinecraftServer.getOnlineMode() && arrayOfGameProfile[0] == null) {
/*  61 */       UUID uUID = EntityHuman.a(new GameProfile(null, paramString));
/*  62 */       GameProfile gameProfile = new GameProfile(uUID, paramString);
/*  63 */       gameProfileLookup.onProfileLookupSucceeded(gameProfile);
/*     */     } 
/*  65 */     return arrayOfGameProfile[0];
/*     */   }
/*     */   
/*     */   public void a(GameProfile paramGameProfile) {
/*  69 */     a(paramGameProfile, (Date)null);
/*     */   }
/*     */   
/*     */   private void a(GameProfile paramGameProfile, Date paramDate) {
/*  73 */     UUID uUID = paramGameProfile.getId();
/*  74 */     if (paramDate == null) {
/*  75 */       Calendar calendar = Calendar.getInstance();
/*  76 */       calendar.setTime(new Date());
/*  77 */       calendar.add(2, 1);
/*  78 */       paramDate = calendar.getTime();
/*     */     } 
/*  80 */     String str = paramGameProfile.getName().toLowerCase(Locale.ROOT);
/*  81 */     UserCacheEntry userCacheEntry = new UserCacheEntry(this, paramGameProfile, paramDate, null);
/*  82 */     synchronized (this.e) {
/*  83 */       if (this.d.containsKey(uUID)) {
/*  84 */         UserCacheEntry userCacheEntry1 = (UserCacheEntry)this.d.get(uUID);
/*  85 */         this.c.remove(userCacheEntry1.a().getName().toLowerCase(Locale.ROOT));
/*  86 */         this.c.put(paramGameProfile.getName().toLowerCase(Locale.ROOT), userCacheEntry);
/*  87 */         this.e.remove(paramGameProfile);
/*     */       } else {
/*  89 */         this.d.put(uUID, userCacheEntry);
/*  90 */         this.c.put(str, userCacheEntry);
/*     */       } 
/*  92 */       this.e.addFirst(paramGameProfile);
/*     */     } 
/*     */   }
/*     */   
/*     */   public GameProfile getProfile(String paramString) {
/*  97 */     String str = paramString.toLowerCase(Locale.ROOT);
/*  98 */     UserCacheEntry userCacheEntry = (UserCacheEntry)this.c.get(str);
/*     */ 
/*     */     
/* 101 */     if (userCacheEntry != null && (new Date()).getTime() >= UserCacheEntry.a(userCacheEntry).getTime()) {
/* 102 */       this.d.remove(userCacheEntry.a().getId());
/* 103 */       this.c.remove(userCacheEntry.a().getName().toLowerCase(Locale.ROOT));
/* 104 */       synchronized (this.e) {
/* 105 */         this.e.remove(userCacheEntry.a());
/*     */       } 
/* 107 */       userCacheEntry = null;
/*     */     } 
/*     */     
/* 110 */     if (userCacheEntry != null) {
/*     */       
/* 112 */       GameProfile gameProfile = userCacheEntry.a();
/* 113 */       synchronized (this.e) {
/* 114 */         this.e.remove(gameProfile);
/* 115 */         this.e.addFirst(gameProfile);
/*     */       } 
/*     */     } else {
/* 118 */       GameProfile gameProfile = a(this.f, str);
/* 119 */       if (gameProfile != null) {
/* 120 */         a(gameProfile);
/* 121 */         userCacheEntry = (UserCacheEntry)this.c.get(str);
/*     */       } 
/*     */     } 
/* 124 */     c();
/* 125 */     return (userCacheEntry == null) ? null : userCacheEntry.a();
/*     */   }
/*     */   
/*     */   public String[] a() {
/* 129 */     ArrayList arrayList = Lists.newArrayList(this.c.keySet());
/* 130 */     return (String[])arrayList.toArray((Object[])new String[arrayList.size()]);
/*     */   }
/*     */   
/*     */   public GameProfile a(UUID paramUUID) {
/* 134 */     UserCacheEntry userCacheEntry = (UserCacheEntry)this.d.get(paramUUID);
/* 135 */     return (userCacheEntry == null) ? null : userCacheEntry.a();
/*     */   }
/*     */   
/*     */   private UserCacheEntry b(UUID paramUUID) {
/* 139 */     UserCacheEntry userCacheEntry = (UserCacheEntry)this.d.get(paramUUID);
/* 140 */     if (userCacheEntry != null) {
/*     */       
/* 142 */       GameProfile gameProfile = userCacheEntry.a();
/* 143 */       synchronized (this.e) {
/* 144 */         this.e.remove(gameProfile);
/* 145 */         this.e.addFirst(gameProfile);
/*     */       } 
/*     */     } 
/* 148 */     return userCacheEntry;
/*     */   }
/*     */   
/*     */   public void b() {
/* 152 */     List list = null;
/* 153 */     BufferedReader bufferedReader = null;
/*     */     try {
/* 155 */       bufferedReader = Files.newReader(this.g, Charsets.UTF_8);
/* 156 */       list = (List)this.b.fromJson(bufferedReader, h);
/* 157 */     } catch (FileNotFoundException fileNotFoundException) {
/*     */       return;
/*     */     } finally {
/* 160 */       IOUtils.closeQuietly(bufferedReader);
/*     */     } 
/* 162 */     if (list != null) {
/* 163 */       this.c.clear();
/* 164 */       this.d.clear();
/* 165 */       synchronized (this.e) {
/* 166 */         this.e.clear();
/*     */       } 
/*     */ 
/*     */       
/* 170 */       list = Lists.reverse(list);
/* 171 */       for (UserCacheEntry userCacheEntry : list) {
/* 172 */         if (userCacheEntry != null) {
/* 173 */           a(userCacheEntry.a(), userCacheEntry.b());
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void c() {
/* 180 */     String str = this.b.toJson(a(1000));
/* 181 */     BufferedWriter bufferedWriter = null;
/*     */     try {
/* 183 */       bufferedWriter = Files.newWriter(this.g, Charsets.UTF_8);
/* 184 */       bufferedWriter.write(str);
/* 185 */     } catch (FileNotFoundException fileNotFoundException) {
/*     */       return;
/* 187 */     } catch (IOException iOException) {
/*     */       return;
/*     */     } finally {
/* 190 */       IOUtils.closeQuietly(bufferedWriter);
/*     */     } 
/*     */   }
/*     */   private List a(int paramInt) {
/*     */     ArrayList arrayList1;
/* 195 */     ArrayList<UserCacheEntry> arrayList = Lists.newArrayList();
/*     */     
/* 197 */     synchronized (this.e) {
/* 198 */       arrayList1 = Lists.newArrayList(Iterators.limit(this.e.iterator(), paramInt));
/*     */     } 
/* 200 */     for (GameProfile gameProfile : arrayList1) {
/* 201 */       UserCacheEntry userCacheEntry = b(gameProfile.getId());
/* 202 */       if (userCacheEntry == null) {
/*     */         continue;
/*     */       }
/* 205 */       arrayList.add(userCacheEntry);
/*     */     } 
/* 207 */     return arrayList;
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
/* 275 */   private static final ParameterizedType h = new UserCacheEntryType();
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\UserCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */