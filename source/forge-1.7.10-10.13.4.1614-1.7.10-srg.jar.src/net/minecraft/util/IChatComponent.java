/*     */ package net.minecraft.util;
/*     */ import com.google.gson.JsonArray;
/*     */ import com.google.gson.JsonDeserializationContext;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import com.google.gson.JsonSerializationContext;
/*     */ import java.lang.reflect.Type;
/*     */ 
/*     */ public interface IChatComponent extends Iterable {
/*     */   IChatComponent func_150255_a(ChatStyle paramChatStyle);
/*     */   
/*     */   ChatStyle func_150256_b();
/*     */   
/*     */   IChatComponent func_150258_a(String paramString);
/*     */   
/*     */   IChatComponent func_150257_a(IChatComponent paramIChatComponent);
/*     */   
/*     */   String func_150261_e();
/*     */   
/*     */   String func_150260_c();
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   String func_150254_d();
/*     */   
/*     */   List func_150253_a();
/*     */   
/*     */   IChatComponent func_150259_f();
/*     */   
/*     */   public static class Serializer implements JsonDeserializer, JsonSerializer {
/*     */     private static final Gson field_150700_a;
/*     */     
/*     */     static {
/*  33 */       GsonBuilder gsonBuilder = new GsonBuilder();
/*  34 */       gsonBuilder.registerTypeHierarchyAdapter(IChatComponent.class, new Serializer());
/*  35 */       gsonBuilder.registerTypeHierarchyAdapter(ChatStyle.class, new ChatStyle.Serializer());
/*  36 */       gsonBuilder.registerTypeAdapterFactory(new EnumTypeAdapterFactory());
/*  37 */       field_150700_a = gsonBuilder.create();
/*     */     }
/*     */     private static final String __OBFID = "CL_00001263";
/*     */     
/*     */     public IChatComponent deserialize(JsonElement p_deserialize_1_, Type p_deserialize_2_, JsonDeserializationContext p_deserialize_3_) {
/*  42 */       if (p_deserialize_1_.isJsonPrimitive())
/*     */       {
/*  44 */         return new ChatComponentText(p_deserialize_1_.getAsString()); } 
/*  45 */       if (p_deserialize_1_.isJsonObject()) {
/*  46 */         ChatComponentTranslation chatComponentTranslation; JsonObject jsonObject = p_deserialize_1_.getAsJsonObject();
/*     */ 
/*     */         
/*  49 */         if (jsonObject.has("text")) {
/*  50 */           ChatComponentText chatComponentText = new ChatComponentText(jsonObject.get("text").getAsString());
/*  51 */         } else if (jsonObject.has("translate")) {
/*  52 */           String str = jsonObject.get("translate").getAsString();
/*     */           
/*  54 */           if (jsonObject.has("with")) {
/*  55 */             JsonArray jsonArray = jsonObject.getAsJsonArray("with");
/*  56 */             Object[] arrayOfObject = new Object[jsonArray.size()];
/*     */             
/*  58 */             for (byte b = 0; b < arrayOfObject.length; b++) {
/*  59 */               arrayOfObject[b] = deserialize(jsonArray.get(b), p_deserialize_2_, p_deserialize_3_);
/*     */               
/*  61 */               if (arrayOfObject[b] instanceof ChatComponentText) {
/*  62 */                 ChatComponentText chatComponentText = (ChatComponentText)arrayOfObject[b];
/*  63 */                 if (chatComponentText.func_150256_b().func_150229_g() && chatComponentText.func_150253_a().isEmpty()) {
/*  64 */                   arrayOfObject[b] = chatComponentText.func_150265_g();
/*     */                 }
/*     */               } 
/*     */             } 
/*     */             
/*  69 */             chatComponentTranslation = new ChatComponentTranslation(str, arrayOfObject);
/*     */           } else {
/*  71 */             chatComponentTranslation = new ChatComponentTranslation(str, new Object[0]);
/*     */           } 
/*     */         } else {
/*  74 */           throw new JsonParseException("Don't know how to turn " + p_deserialize_1_.toString() + " into a Component");
/*     */         } 
/*     */         
/*  77 */         if (jsonObject.has("extra")) {
/*  78 */           JsonArray jsonArray = jsonObject.getAsJsonArray("extra");
/*     */           
/*  80 */           if (jsonArray.size() > 0) {
/*  81 */             for (byte b = 0; b < jsonArray.size(); b++) {
/*  82 */               chatComponentTranslation.func_150257_a(deserialize(jsonArray.get(b), p_deserialize_2_, p_deserialize_3_));
/*     */             }
/*     */           } else {
/*  85 */             throw new JsonParseException("Unexpected empty array of components");
/*     */           } 
/*     */         } 
/*     */         
/*  89 */         chatComponentTranslation.func_150255_a((ChatStyle)p_deserialize_3_.deserialize(p_deserialize_1_, ChatStyle.class));
/*     */         
/*  91 */         return chatComponentTranslation;
/*  92 */       }  if (p_deserialize_1_.isJsonArray()) {
/*     */         
/*  94 */         JsonArray jsonArray = p_deserialize_1_.getAsJsonArray();
/*  95 */         IChatComponent iChatComponent = null;
/*     */         
/*  97 */         for (JsonElement jsonElement : jsonArray) {
/*  98 */           IChatComponent iChatComponent1 = deserialize(jsonElement, jsonElement.getClass(), p_deserialize_3_);
/*  99 */           if (iChatComponent == null) {
/* 100 */             iChatComponent = iChatComponent1; continue;
/*     */           } 
/* 102 */           iChatComponent.func_150257_a(iChatComponent1);
/*     */         } 
/*     */ 
/*     */         
/* 106 */         return iChatComponent;
/*     */       } 
/* 108 */       throw new JsonParseException("Don't know how to turn " + p_deserialize_1_.toString() + " into a Component");
/*     */     }
/*     */ 
/*     */     
/*     */     private void func_150695_a(ChatStyle p_150695_1_, JsonObject p_150695_2_, JsonSerializationContext p_150695_3_) {
/* 113 */       JsonElement jsonElement = p_150695_3_.serialize(p_150695_1_);
/*     */       
/* 115 */       if (jsonElement.isJsonObject()) {
/* 116 */         JsonObject jsonObject = (JsonObject)jsonElement;
/* 117 */         for (Map.Entry entry : jsonObject.entrySet()) {
/* 118 */           p_150695_2_.add((String)entry.getKey(), (JsonElement)entry.getValue());
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public JsonElement serialize(IChatComponent p_serialize_1_, Type p_serialize_2_, JsonSerializationContext p_serialize_3_) {
/* 125 */       if (p_serialize_1_ instanceof ChatComponentText && p_serialize_1_.func_150256_b().func_150229_g() && p_serialize_1_.func_150253_a().isEmpty()) {
/* 126 */         return (JsonElement)new JsonPrimitive(((ChatComponentText)p_serialize_1_).func_150265_g());
/*     */       }
/*     */       
/* 129 */       JsonObject jsonObject = new JsonObject();
/*     */       
/* 131 */       if (!p_serialize_1_.func_150256_b().func_150229_g()) {
/* 132 */         func_150695_a(p_serialize_1_.func_150256_b(), jsonObject, p_serialize_3_);
/*     */       }
/*     */       
/* 135 */       if (!p_serialize_1_.func_150253_a().isEmpty()) {
/* 136 */         JsonArray jsonArray = new JsonArray();
/*     */         
/* 138 */         for (IChatComponent iChatComponent : p_serialize_1_.func_150253_a()) {
/* 139 */           jsonArray.add(serialize(iChatComponent, iChatComponent.getClass(), p_serialize_3_));
/*     */         }
/*     */         
/* 142 */         jsonObject.add("extra", (JsonElement)jsonArray);
/*     */       } 
/*     */       
/* 145 */       if (p_serialize_1_ instanceof ChatComponentText) {
/* 146 */         jsonObject.addProperty("text", ((ChatComponentText)p_serialize_1_).func_150265_g());
/* 147 */       } else if (p_serialize_1_ instanceof ChatComponentTranslation) {
/* 148 */         ChatComponentTranslation chatComponentTranslation = (ChatComponentTranslation)p_serialize_1_;
/* 149 */         jsonObject.addProperty("translate", chatComponentTranslation.func_150268_i());
/*     */         
/* 151 */         if (chatComponentTranslation.func_150271_j() != null && (chatComponentTranslation.func_150271_j()).length > 0) {
/* 152 */           JsonArray jsonArray = new JsonArray();
/*     */           
/* 154 */           for (Object object : chatComponentTranslation.func_150271_j()) {
/* 155 */             if (object instanceof IChatComponent) {
/* 156 */               jsonArray.add(serialize((IChatComponent)object, object.getClass(), p_serialize_3_));
/*     */             } else {
/* 158 */               jsonArray.add((JsonElement)new JsonPrimitive(String.valueOf(object)));
/*     */             } 
/*     */           } 
/*     */           
/* 162 */           jsonObject.add("with", (JsonElement)jsonArray);
/*     */         } 
/*     */       } else {
/* 165 */         throw new IllegalArgumentException("Don't know how to serialize " + p_serialize_1_ + " as a Component");
/*     */       } 
/*     */       
/* 168 */       return (JsonElement)jsonObject;
/*     */     }
/*     */     
/*     */     public static String func_150696_a(IChatComponent p_150696_0_) {
/* 172 */       return field_150700_a.toJson(p_150696_0_);
/*     */     }
/*     */     
/*     */     public static IChatComponent func_150699_a(String p_150699_0_) {
/* 176 */       return (IChatComponent)field_150700_a.fromJson(p_150699_0_, IChatComponent.class);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\IChatComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */