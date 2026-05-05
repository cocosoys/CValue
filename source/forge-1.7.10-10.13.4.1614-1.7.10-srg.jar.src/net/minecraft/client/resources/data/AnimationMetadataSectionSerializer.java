/*    */ package net.minecraft.client.resources.data;
/*    */ import com.google.gson.JsonArray;
/*    */ import com.google.gson.JsonDeserializationContext;
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import com.google.gson.JsonSerializationContext;
/*    */ import java.lang.reflect.Type;
/*    */ import java.util.ArrayList;
/*    */ import net.minecraft.util.JsonUtils;
/*    */ import org.apache.commons.lang3.Validate;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class AnimationMetadataSectionSerializer extends BaseMetadataSectionSerializer implements JsonSerializer {
/*    */   public AnimationMetadataSection deserialize(JsonElement p_deserialize_1_, Type p_deserialize_2_, JsonDeserializationContext p_deserialize_3_) {
/* 15 */     ArrayList<AnimationFrame> arrayList = Lists.newArrayList();
/* 16 */     JsonObject jsonObject = JsonUtils.func_151210_l(p_deserialize_1_, "metadata section");
/* 17 */     int i = JsonUtils.func_151208_a(jsonObject, "frametime", 1);
/* 18 */     if (i != 1) {
/* 19 */       Validate.inclusiveBetween(Integer.valueOf(1), Integer.valueOf(2147483647), Integer.valueOf(i), "Invalid default frame time", new Object[0]);
/*    */     }
/*    */     
/* 22 */     if (jsonObject.has("frames")) {
/*    */       try {
/* 24 */         JsonArray jsonArray = JsonUtils.func_151214_t(jsonObject, "frames");
/*    */         
/* 26 */         for (byte b = 0; b < jsonArray.size(); b++) {
/* 27 */           JsonElement jsonElement = jsonArray.get(b);
/*    */           
/* 29 */           AnimationFrame animationFrame = func_110492_a(b, jsonElement);
/* 30 */           if (animationFrame != null) arrayList.add(animationFrame); 
/*    */         } 
/* 32 */       } catch (ClassCastException classCastException) {
/* 33 */         throw new JsonParseException("Invalid animation->frames: expected array, was " + jsonObject.get("frames"), classCastException);
/*    */       } 
/*    */     }
/*    */     
/* 37 */     int j = JsonUtils.func_151208_a(jsonObject, "width", -1);
/* 38 */     int k = JsonUtils.func_151208_a(jsonObject, "height", -1);
/*    */     
/* 40 */     if (j != -1) {
/* 41 */       Validate.inclusiveBetween(Integer.valueOf(1), Integer.valueOf(2147483647), Integer.valueOf(j), "Invalid width", new Object[0]);
/*    */     }
/* 43 */     if (k != -1) {
/* 44 */       Validate.inclusiveBetween(Integer.valueOf(1), Integer.valueOf(2147483647), Integer.valueOf(k), "Invalid height", new Object[0]);
/*    */     }
/*    */     
/* 47 */     return new AnimationMetadataSection(arrayList, j, k, i);
/*    */   }
/*    */   private static final String __OBFID = "CL_00001107";
/*    */   private AnimationFrame func_110492_a(int p_110492_1_, JsonElement p_110492_2_) {
/* 51 */     if (p_110492_2_.isJsonPrimitive())
/* 52 */       return new AnimationFrame(JsonUtils.func_151215_f(p_110492_2_, "frames[" + p_110492_1_ + "]")); 
/* 53 */     if (p_110492_2_.isJsonObject()) {
/* 54 */       JsonObject jsonObject = JsonUtils.func_151210_l(p_110492_2_, "frames[" + p_110492_1_ + "]");
/* 55 */       int i = JsonUtils.func_151208_a(jsonObject, "time", -1);
/* 56 */       if (jsonObject.has("time")) {
/* 57 */         Validate.inclusiveBetween(Integer.valueOf(1), Integer.valueOf(2147483647), Integer.valueOf(i), "Invalid frame time", new Object[0]);
/*    */       }
/* 59 */       int j = JsonUtils.func_151203_m(jsonObject, "index");
/* 60 */       Validate.inclusiveBetween(Integer.valueOf(0), Integer.valueOf(2147483647), Integer.valueOf(j), "Invalid frame index", new Object[0]);
/* 61 */       return new AnimationFrame(j, i);
/*    */     } 
/*    */     
/* 64 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public JsonElement serialize(AnimationMetadataSection p_serialize_1_, Type p_serialize_2_, JsonSerializationContext p_serialize_3_) {
/* 70 */     JsonObject jsonObject = new JsonObject();
/*    */     
/* 72 */     jsonObject.addProperty("frametime", Integer.valueOf(p_serialize_1_.func_110469_d()));
/* 73 */     if (p_serialize_1_.func_110474_b() != -1) jsonObject.addProperty("width", Integer.valueOf(p_serialize_1_.func_110474_b())); 
/* 74 */     if (p_serialize_1_.func_110471_a() != -1) jsonObject.addProperty("height", Integer.valueOf(p_serialize_1_.func_110471_a()));
/*    */     
/* 76 */     if (p_serialize_1_.func_110473_c() > 0) {
/* 77 */       JsonArray jsonArray = new JsonArray();
/* 78 */       for (byte b = 0; b < p_serialize_1_.func_110473_c(); b++) {
/* 79 */         if (p_serialize_1_.func_110470_b(b)) {
/* 80 */           JsonObject jsonObject1 = new JsonObject();
/*    */           
/* 82 */           jsonObject1.addProperty("index", Integer.valueOf(p_serialize_1_.func_110468_c(b)));
/* 83 */           jsonObject1.addProperty("time", Integer.valueOf(p_serialize_1_.func_110472_a(b)));
/*    */           
/* 85 */           jsonArray.add((JsonElement)jsonObject1);
/*    */         } else {
/* 87 */           jsonArray.add((JsonElement)new JsonPrimitive(Integer.valueOf(p_serialize_1_.func_110468_c(b))));
/*    */         } 
/*    */       } 
/* 90 */       jsonObject.add("frames", (JsonElement)jsonArray);
/*    */     } 
/*    */     
/* 93 */     return (JsonElement)jsonObject;
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_110483_a() {
/* 98 */     return "animation";
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\resources\data\AnimationMetadataSectionSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */