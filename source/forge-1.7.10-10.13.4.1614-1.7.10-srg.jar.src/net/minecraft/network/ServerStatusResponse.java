/*     */ package net.minecraft.network;
/*     */ 
/*     */ import com.google.gson.JsonArray;
/*     */ import com.google.gson.JsonDeserializationContext;
/*     */ import com.google.gson.JsonDeserializer;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import com.google.gson.JsonSerializationContext;
/*     */ import com.google.gson.JsonSerializer;
/*     */ import com.mojang.authlib.GameProfile;
/*     */ import java.lang.reflect.Type;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.util.JsonUtils;
/*     */ 
/*     */ public class ServerStatusResponse {
/*     */   private IChatComponent field_151326_a;
/*     */   private PlayerCountData field_151324_b;
/*     */   
/*     */   public IChatComponent func_151317_a() {
/*  21 */     return this.field_151326_a;
/*     */   }
/*     */   private MinecraftProtocolVersionIdentifier field_151325_c; private String field_151323_d; private static final String __OBFID = "CL_00001385";
/*     */   public void func_151315_a(IChatComponent p_151315_1_) {
/*  25 */     this.field_151326_a = p_151315_1_;
/*     */   }
/*     */   
/*     */   public PlayerCountData func_151318_b() {
/*  29 */     return this.field_151324_b;
/*     */   }
/*     */   
/*     */   public void func_151319_a(PlayerCountData p_151319_1_) {
/*  33 */     this.field_151324_b = p_151319_1_;
/*     */   }
/*     */   
/*     */   public MinecraftProtocolVersionIdentifier func_151322_c() {
/*  37 */     return this.field_151325_c;
/*     */   }
/*     */   
/*     */   public void func_151321_a(MinecraftProtocolVersionIdentifier p_151321_1_) {
/*  41 */     this.field_151325_c = p_151321_1_;
/*     */   }
/*     */   
/*     */   public void func_151320_a(String p_151320_1_) {
/*  45 */     this.field_151323_d = p_151320_1_;
/*     */   }
/*     */   
/*     */   public String func_151316_d() {
/*  49 */     return this.field_151323_d;
/*     */   }
/*     */   
/*     */   public static class PlayerCountData { private final int field_151336_a;
/*     */     private final int field_151334_b;
/*     */     private GameProfile[] field_151335_c;
/*     */     private static final String __OBFID = "CL_00001386";
/*     */     
/*     */     public PlayerCountData(int p_i45274_1_, int p_i45274_2_) {
/*  58 */       this.field_151336_a = p_i45274_1_;
/*  59 */       this.field_151334_b = p_i45274_2_;
/*     */     }
/*     */     
/*     */     public int func_151332_a() {
/*  63 */       return this.field_151336_a;
/*     */     }
/*     */     
/*     */     public int func_151333_b() {
/*  67 */       return this.field_151334_b;
/*     */     }
/*     */     
/*     */     public GameProfile[] func_151331_c() {
/*  71 */       return this.field_151335_c;
/*     */     }
/*     */     
/*     */     public void func_151330_a(GameProfile[] p_151330_1_) {
/*  75 */       this.field_151335_c = p_151330_1_;
/*     */     }
/*     */     
/*     */     public static class Serializer implements JsonDeserializer, JsonSerializer { private static final String __OBFID = "CL_00001387";
/*     */       
/*     */       public ServerStatusResponse.PlayerCountData deserialize(JsonElement p_deserialize_1_, Type p_deserialize_2_, JsonDeserializationContext p_deserialize_3_) {
/*  81 */         JsonObject jsonObject = JsonUtils.func_151210_l(p_deserialize_1_, "players");
/*  82 */         ServerStatusResponse.PlayerCountData playerCountData = new ServerStatusResponse.PlayerCountData(JsonUtils.func_151203_m(jsonObject, "max"), JsonUtils.func_151203_m(jsonObject, "online"));
/*     */         
/*  84 */         if (JsonUtils.func_151202_d(jsonObject, "sample")) {
/*  85 */           JsonArray jsonArray = JsonUtils.func_151214_t(jsonObject, "sample");
/*  86 */           if (jsonArray.size() > 0) {
/*  87 */             GameProfile[] arrayOfGameProfile = new GameProfile[jsonArray.size()];
/*  88 */             for (byte b = 0; b < arrayOfGameProfile.length; b++) {
/*  89 */               JsonObject jsonObject1 = JsonUtils.func_151210_l(jsonArray.get(b), "player[" + b + "]");
/*  90 */               String str = JsonUtils.func_151200_h(jsonObject1, "id");
/*  91 */               arrayOfGameProfile[b] = new GameProfile(UUID.fromString(str), JsonUtils.func_151200_h(jsonObject1, "name"));
/*     */             } 
/*  93 */             playerCountData.func_151330_a(arrayOfGameProfile);
/*     */           } 
/*     */         } 
/*     */         
/*  97 */         return playerCountData;
/*     */       }
/*     */ 
/*     */       
/*     */       public JsonElement serialize(ServerStatusResponse.PlayerCountData p_serialize_1_, Type p_serialize_2_, JsonSerializationContext p_serialize_3_) {
/* 102 */         JsonObject jsonObject = new JsonObject();
/*     */         
/* 104 */         jsonObject.addProperty("max", Integer.valueOf(p_serialize_1_.func_151332_a()));
/* 105 */         jsonObject.addProperty("online", Integer.valueOf(p_serialize_1_.func_151333_b()));
/*     */         
/* 107 */         if (p_serialize_1_.func_151331_c() != null && (p_serialize_1_.func_151331_c()).length > 0) {
/* 108 */           JsonArray jsonArray = new JsonArray();
/*     */           
/* 110 */           for (byte b = 0; b < (p_serialize_1_.func_151331_c()).length; b++) {
/* 111 */             JsonObject jsonObject1 = new JsonObject();
/* 112 */             UUID uUID = p_serialize_1_.func_151331_c()[b].getId();
/* 113 */             jsonObject1.addProperty("id", (uUID == null) ? "" : uUID.toString());
/* 114 */             jsonObject1.addProperty("name", p_serialize_1_.func_151331_c()[b].getName());
/* 115 */             jsonArray.add((JsonElement)jsonObject1);
/*     */           } 
/*     */           
/* 118 */           jsonObject.add("sample", (JsonElement)jsonArray);
/*     */         } 
/*     */         
/* 121 */         return (JsonElement)jsonObject;
/*     */       } } }
/*     */ 
/*     */   
/*     */   public static class MinecraftProtocolVersionIdentifier {
/*     */     private final String field_151306_a;
/*     */     private final int field_151305_b;
/*     */     private static final String __OBFID = "CL_00001389";
/*     */     
/*     */     public MinecraftProtocolVersionIdentifier(String p_i45275_1_, int p_i45275_2_) {
/* 131 */       this.field_151306_a = p_i45275_1_;
/* 132 */       this.field_151305_b = p_i45275_2_;
/*     */     }
/*     */     
/*     */     public String func_151303_a() {
/* 136 */       return this.field_151306_a;
/*     */     }
/*     */     
/*     */     public int func_151304_b() {
/* 140 */       return this.field_151305_b;
/*     */     }
/*     */     
/*     */     public static class Serializer implements JsonDeserializer, JsonSerializer { private static final String __OBFID = "CL_00001390";
/*     */       
/*     */       public ServerStatusResponse.MinecraftProtocolVersionIdentifier deserialize(JsonElement p_deserialize_1_, Type p_deserialize_2_, JsonDeserializationContext p_deserialize_3_) {
/* 146 */         JsonObject jsonObject = JsonUtils.func_151210_l(p_deserialize_1_, "version");
/* 147 */         return new ServerStatusResponse.MinecraftProtocolVersionIdentifier(JsonUtils.func_151200_h(jsonObject, "name"), JsonUtils.func_151203_m(jsonObject, "protocol"));
/*     */       }
/*     */ 
/*     */       
/*     */       public JsonElement serialize(ServerStatusResponse.MinecraftProtocolVersionIdentifier p_serialize_1_, Type p_serialize_2_, JsonSerializationContext p_serialize_3_) {
/* 152 */         JsonObject jsonObject = new JsonObject();
/* 153 */         jsonObject.addProperty("name", p_serialize_1_.func_151303_a());
/* 154 */         jsonObject.addProperty("protocol", Integer.valueOf(p_serialize_1_.func_151304_b()));
/* 155 */         return (JsonElement)jsonObject;
/*     */       } }
/*     */   }
/*     */   
/*     */   public static class Serializer implements JsonDeserializer, JsonSerializer {
/*     */     private static final String __OBFID = "CL_00001388";
/*     */     
/*     */     public ServerStatusResponse deserialize(JsonElement p_deserialize_1_, Type p_deserialize_2_, JsonDeserializationContext p_deserialize_3_) {
/* 163 */       JsonObject jsonObject = JsonUtils.func_151210_l(p_deserialize_1_, "status");
/* 164 */       ServerStatusResponse serverStatusResponse = new ServerStatusResponse();
/*     */       
/* 166 */       if (jsonObject.has("description")) {
/* 167 */         serverStatusResponse.func_151315_a((IChatComponent)p_deserialize_3_.deserialize(jsonObject.get("description"), IChatComponent.class));
/*     */       }
/*     */       
/* 170 */       if (jsonObject.has("players")) {
/* 171 */         serverStatusResponse.func_151319_a((ServerStatusResponse.PlayerCountData)p_deserialize_3_.deserialize(jsonObject.get("players"), ServerStatusResponse.PlayerCountData.class));
/*     */       }
/*     */       
/* 174 */       if (jsonObject.has("version")) {
/* 175 */         serverStatusResponse.func_151321_a((ServerStatusResponse.MinecraftProtocolVersionIdentifier)p_deserialize_3_.deserialize(jsonObject.get("version"), ServerStatusResponse.MinecraftProtocolVersionIdentifier.class));
/*     */       }
/*     */       
/* 178 */       if (jsonObject.has("favicon")) {
/* 179 */         serverStatusResponse.func_151320_a(JsonUtils.func_151200_h(jsonObject, "favicon"));
/*     */       }
/*     */       
/* 182 */       return serverStatusResponse;
/*     */     }
/*     */ 
/*     */     
/*     */     public JsonElement serialize(ServerStatusResponse p_serialize_1_, Type p_serialize_2_, JsonSerializationContext p_serialize_3_) {
/* 187 */       JsonObject jsonObject = new JsonObject();
/*     */       
/* 189 */       if (p_serialize_1_.func_151317_a() != null) {
/* 190 */         jsonObject.add("description", p_serialize_3_.serialize(p_serialize_1_.func_151317_a()));
/*     */       }
/*     */       
/* 193 */       if (p_serialize_1_.func_151318_b() != null) {
/* 194 */         jsonObject.add("players", p_serialize_3_.serialize(p_serialize_1_.func_151318_b()));
/*     */       }
/*     */       
/* 197 */       if (p_serialize_1_.func_151322_c() != null) {
/* 198 */         jsonObject.add("version", p_serialize_3_.serialize(p_serialize_1_.func_151322_c()));
/*     */       }
/*     */       
/* 201 */       if (p_serialize_1_.func_151316_d() != null) {
/* 202 */         jsonObject.addProperty("favicon", p_serialize_1_.func_151316_d());
/*     */       }
/*     */       
/* 205 */       return (JsonElement)jsonObject;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\ServerStatusResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */