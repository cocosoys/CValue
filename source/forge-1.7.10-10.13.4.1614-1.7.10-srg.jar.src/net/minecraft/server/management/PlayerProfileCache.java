/*     */ package net.minecraft.server.management;
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.collect.Maps;
/*     */ import com.google.common.io.Files;
/*     */ import com.google.gson.GsonBuilder;
/*     */ import com.google.gson.JsonDeserializationContext;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import com.google.gson.JsonSerializationContext;
/*     */ import com.mojang.authlib.GameProfile;
/*     */ import com.mojang.authlib.ProfileLookupCallback;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.File;
/*     */ import java.lang.reflect.ParameterizedType;
/*     */ import java.lang.reflect.Type;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ 
/*     */ public class PlayerProfileCache {
/*  26 */   public static final SimpleDateFormat field_152659_a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
/*  27 */   private final Map field_152661_c = Maps.newHashMap();
/*  28 */   private final Map field_152662_d = Maps.newHashMap();
/*  29 */   private final LinkedList field_152663_e = Lists.newLinkedList();
/*     */   private final MinecraftServer field_152664_f;
/*     */   protected final Gson field_152660_b;
/*     */   private final File field_152665_g;
/*     */   
/*     */   public PlayerProfileCache(MinecraftServer p_i1171_1_, File p_i1171_2_) {
/*  35 */     this.field_152664_f = p_i1171_1_;
/*  36 */     this.field_152665_g = p_i1171_2_;
/*     */     
/*  38 */     GsonBuilder gsonBuilder = new GsonBuilder();
/*  39 */     gsonBuilder.registerTypeHierarchyAdapter(ProfileEntry.class, new Serializer());
/*  40 */     this.field_152660_b = gsonBuilder.create();
/*     */     
/*  42 */     func_152657_b();
/*     */   }
/*     */   
/*     */   private static GameProfile func_152650_a(MinecraftServer p_152650_0_, String p_152650_1_) {
/*  46 */     GameProfile[] arrayOfGameProfile = new GameProfile[1];
/*  47 */     ProfileLookupCallback profileLookupCallback = new ProfileLookupCallback(arrayOfGameProfile) { private static final String __OBFID = "CL_00001887";
/*     */         
/*     */         public void onProfileLookupSucceeded(GameProfile p_onProfileLookupSucceeded_1_) {
/*  50 */           this.field_152667_a[0] = p_onProfileLookupSucceeded_1_;
/*     */         }
/*     */ 
/*     */         
/*     */         public void onProfileLookupFailed(GameProfile p_onProfileLookupFailed_1_, Exception p_onProfileLookupFailed_2_) {
/*  55 */           this.field_152667_a[0] = null;
/*     */         } }
/*     */       ;
/*     */     
/*  59 */     p_152650_0_.func_152359_aw().findProfilesByNames(new String[] { p_152650_1_ }, Agent.MINECRAFT, profileLookupCallback);
/*  60 */     if (!p_152650_0_.func_71266_T() && arrayOfGameProfile[0] == null) {
/*  61 */       UUID uUID = EntityPlayer.func_146094_a(new GameProfile(null, p_152650_1_));
/*  62 */       GameProfile gameProfile = new GameProfile(uUID, p_152650_1_);
/*  63 */       profileLookupCallback.onProfileLookupSucceeded(gameProfile);
/*     */     } 
/*  65 */     return arrayOfGameProfile[0];
/*     */   }
/*     */   
/*     */   public void func_152649_a(GameProfile p_152649_1_) {
/*  69 */     func_152651_a(p_152649_1_, null);
/*     */   }
/*     */   
/*     */   private void func_152651_a(GameProfile p_152651_1_, Date p_152651_2_) {
/*  73 */     UUID uUID = p_152651_1_.getId();
/*  74 */     if (p_152651_2_ == null) {
/*  75 */       Calendar calendar = Calendar.getInstance();
/*  76 */       calendar.setTime(new Date());
/*  77 */       calendar.add(2, 1);
/*  78 */       p_152651_2_ = calendar.getTime();
/*     */     } 
/*  80 */     String str = p_152651_1_.getName().toLowerCase(Locale.ROOT);
/*  81 */     ProfileEntry profileEntry = new ProfileEntry(p_152651_1_, p_152651_2_);
/*  82 */     synchronized (this.field_152663_e) {
/*  83 */       if (this.field_152662_d.containsKey(uUID)) {
/*  84 */         ProfileEntry profileEntry1 = (ProfileEntry)this.field_152662_d.get(uUID);
/*  85 */         this.field_152661_c.remove(profileEntry1.func_152668_a().getName().toLowerCase(Locale.ROOT));
/*  86 */         this.field_152661_c.put(p_152651_1_.getName().toLowerCase(Locale.ROOT), profileEntry);
/*  87 */         this.field_152663_e.remove(p_152651_1_);
/*     */       } else {
/*  89 */         this.field_152662_d.put(uUID, profileEntry);
/*  90 */         this.field_152661_c.put(str, profileEntry);
/*     */       } 
/*  92 */       this.field_152663_e.addFirst(p_152651_1_);
/*     */     } 
/*     */   }
/*     */   
/*     */   public GameProfile func_152655_a(String p_152655_1_) {
/*  97 */     String str = p_152655_1_.toLowerCase(Locale.ROOT);
/*  98 */     ProfileEntry profileEntry = (ProfileEntry)this.field_152661_c.get(str);
/*     */ 
/*     */     
/* 101 */     if (profileEntry != null && (new Date()).getTime() >= profileEntry.field_152673_c.getTime()) {
/* 102 */       this.field_152662_d.remove(profileEntry.func_152668_a().getId());
/* 103 */       this.field_152661_c.remove(profileEntry.func_152668_a().getName().toLowerCase(Locale.ROOT));
/* 104 */       synchronized (this.field_152663_e) {
/* 105 */         this.field_152663_e.remove(profileEntry.func_152668_a());
/*     */       } 
/* 107 */       profileEntry = null;
/*     */     } 
/*     */     
/* 110 */     if (profileEntry != null) {
/*     */       
/* 112 */       GameProfile gameProfile = profileEntry.func_152668_a();
/* 113 */       synchronized (this.field_152663_e) {
/* 114 */         this.field_152663_e.remove(gameProfile);
/* 115 */         this.field_152663_e.addFirst(gameProfile);
/*     */       } 
/*     */     } else {
/* 118 */       GameProfile gameProfile = func_152650_a(this.field_152664_f, str);
/* 119 */       if (gameProfile != null) {
/* 120 */         func_152649_a(gameProfile);
/* 121 */         profileEntry = (ProfileEntry)this.field_152661_c.get(str);
/*     */       } 
/*     */     } 
/* 124 */     func_152658_c();
/* 125 */     return (profileEntry == null) ? null : profileEntry.func_152668_a();
/*     */   }
/*     */   
/*     */   public String[] func_152654_a() {
/* 129 */     ArrayList arrayList = Lists.newArrayList(this.field_152661_c.keySet());
/* 130 */     return (String[])arrayList.toArray((Object[])new String[arrayList.size()]);
/*     */   }
/*     */   
/*     */   public GameProfile func_152652_a(UUID p_152652_1_) {
/* 134 */     ProfileEntry profileEntry = (ProfileEntry)this.field_152662_d.get(p_152652_1_);
/* 135 */     return (profileEntry == null) ? null : profileEntry.func_152668_a();
/*     */   }
/*     */   
/*     */   private ProfileEntry func_152653_b(UUID p_152653_1_) {
/* 139 */     ProfileEntry profileEntry = (ProfileEntry)this.field_152662_d.get(p_152653_1_);
/* 140 */     if (profileEntry != null) {
/*     */       
/* 142 */       GameProfile gameProfile = profileEntry.func_152668_a();
/* 143 */       synchronized (this.field_152663_e) {
/* 144 */         this.field_152663_e.remove(gameProfile);
/* 145 */         this.field_152663_e.addFirst(gameProfile);
/*     */       } 
/*     */     } 
/* 148 */     return profileEntry;
/*     */   }
/*     */   
/*     */   public void func_152657_b() {
/* 152 */     List list = null;
/* 153 */     BufferedReader bufferedReader = null;
/*     */     try {
/* 155 */       bufferedReader = Files.newReader(this.field_152665_g, Charsets.UTF_8);
/* 156 */       list = (List)this.field_152660_b.fromJson(bufferedReader, field_152666_h);
/* 157 */     } catch (FileNotFoundException fileNotFoundException) {
/*     */       return;
/*     */     } finally {
/* 160 */       IOUtils.closeQuietly(bufferedReader);
/*     */     } 
/* 162 */     if (list != null) {
/* 163 */       this.field_152661_c.clear();
/* 164 */       this.field_152662_d.clear();
/* 165 */       synchronized (this.field_152663_e) {
/* 166 */         this.field_152663_e.clear();
/*     */       } 
/*     */ 
/*     */       
/* 170 */       list = Lists.reverse(list);
/* 171 */       for (ProfileEntry profileEntry : list) {
/* 172 */         if (profileEntry != null) {
/* 173 */           func_152651_a(profileEntry.func_152668_a(), profileEntry.func_152670_b());
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_152658_c() {
/* 180 */     String str = this.field_152660_b.toJson(func_152656_a(1000));
/* 181 */     BufferedWriter bufferedWriter = null;
/*     */     try {
/* 183 */       bufferedWriter = Files.newWriter(this.field_152665_g, Charsets.UTF_8);
/* 184 */       bufferedWriter.write(str);
/* 185 */     } catch (FileNotFoundException fileNotFoundException) {
/*     */       return;
/* 187 */     } catch (IOException iOException) {
/*     */       return;
/*     */     } finally {
/* 190 */       IOUtils.closeQuietly(bufferedWriter);
/*     */     } 
/*     */   }
/*     */   private List func_152656_a(int p_152656_1_) {
/*     */     ArrayList arrayList1;
/* 195 */     ArrayList<ProfileEntry> arrayList = Lists.newArrayList();
/*     */     
/* 197 */     synchronized (this.field_152663_e) {
/* 198 */       arrayList1 = Lists.newArrayList(Iterators.limit(this.field_152663_e.iterator(), p_152656_1_));
/*     */     } 
/* 200 */     for (GameProfile gameProfile : arrayList1) {
/* 201 */       ProfileEntry profileEntry = func_152653_b(gameProfile.getId());
/* 202 */       if (profileEntry == null) {
/*     */         continue;
/*     */       }
/* 205 */       arrayList.add(profileEntry);
/*     */     } 
/* 207 */     return arrayList;
/*     */   }
/*     */   class Serializer implements JsonDeserializer, JsonSerializer { private static final String __OBFID = "CL_00001884";
/*     */     private Serializer(PlayerProfileCache p_i1162_1_) {}
/*     */     
/*     */     public JsonElement func_152676_a(PlayerProfileCache.ProfileEntry p_152676_1_, Type p_152676_2_, JsonSerializationContext p_152676_3_) {
/* 213 */       JsonObject jsonObject = new JsonObject();
/* 214 */       jsonObject.addProperty("name", p_152676_1_.func_152668_a().getName());
/* 215 */       UUID uUID = p_152676_1_.func_152668_a().getId();
/* 216 */       jsonObject.addProperty("uuid", (uUID == null) ? "" : uUID.toString());
/* 217 */       jsonObject.addProperty("expiresOn", PlayerProfileCache.field_152659_a.format(p_152676_1_.func_152670_b()));
/* 218 */       return (JsonElement)jsonObject;
/*     */     }
/*     */ 
/*     */     
/*     */     public PlayerProfileCache.ProfileEntry func_152675_a(JsonElement p_152675_1_, Type p_152675_2_, JsonDeserializationContext p_152675_3_) {
/* 223 */       if (p_152675_1_.isJsonObject()) {
/* 224 */         UUID uUID; JsonObject jsonObject = p_152675_1_.getAsJsonObject();
/* 225 */         JsonElement jsonElement1 = jsonObject.get("name");
/* 226 */         JsonElement jsonElement2 = jsonObject.get("uuid");
/* 227 */         JsonElement jsonElement3 = jsonObject.get("expiresOn");
/* 228 */         if (jsonElement1 == null || jsonElement2 == null) {
/* 229 */           return null;
/*     */         }
/* 231 */         String str1 = jsonElement2.getAsString();
/* 232 */         String str2 = jsonElement1.getAsString();
/* 233 */         Date date = null;
/* 234 */         if (jsonElement3 != null) {
/*     */           try {
/* 236 */             date = PlayerProfileCache.field_152659_a.parse(jsonElement3.getAsString());
/* 237 */           } catch (ParseException parseException) {
/* 238 */             date = null;
/*     */           } 
/*     */         }
/* 241 */         if (str2 == null || str1 == null) {
/* 242 */           return null;
/*     */         }
/*     */         
/*     */         try {
/* 246 */           uUID = UUID.fromString(str1);
/* 247 */         } catch (Throwable throwable) {
/* 248 */           return null;
/*     */         } 
/* 250 */         return new PlayerProfileCache.ProfileEntry(new GameProfile(uUID, str2), date);
/*     */       } 
/*     */       
/* 253 */       return null;
/*     */     } }
/*     */   
/*     */   class ProfileEntry {
/*     */     private final GameProfile field_152672_b;
/*     */     private final Date field_152673_c;
/*     */     private static final String __OBFID = "CL_00001885";
/*     */     
/*     */     private ProfileEntry(PlayerProfileCache p_i1165_1_, GameProfile p_i1165_2_, Date p_i1165_3_) {
/* 262 */       this.field_152672_b = p_i1165_2_;
/* 263 */       this.field_152673_c = p_i1165_3_;
/*     */     }
/*     */     
/*     */     public GameProfile func_152668_a() {
/* 267 */       return this.field_152672_b;
/*     */     }
/*     */     
/*     */     public Date func_152670_b() {
/* 271 */       return this.field_152673_c;
/*     */     }
/*     */   }
/*     */   
/* 275 */   private static final ParameterizedType field_152666_h = new ParameterizedType() { private static final String __OBFID = "CL_00001886";
/*     */       
/*     */       public Type[] getActualTypeArguments() {
/* 278 */         return new Type[] { PlayerProfileCache.ProfileEntry.class };
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public Type getRawType() {
/* 285 */         return List.class;
/*     */       }
/*     */ 
/*     */       
/*     */       public Type getOwnerType() {
/* 290 */         return null;
/*     */       } }
/*     */   ;
/*     */   private static final String __OBFID = "CL_00001888";
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\server\management\PlayerProfileCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */