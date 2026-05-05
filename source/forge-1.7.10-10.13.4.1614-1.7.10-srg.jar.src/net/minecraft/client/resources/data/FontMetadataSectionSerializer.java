/*    */ package net.minecraft.client.resources.data;
/*    */ import com.google.gson.JsonDeserializationContext;
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import com.google.gson.JsonParseException;
/*    */ import java.lang.reflect.Type;
/*    */ import net.minecraft.util.JsonUtils;
/*    */ import org.apache.commons.lang3.Validate;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class FontMetadataSectionSerializer extends BaseMetadataSectionSerializer {
/*    */   public FontMetadataSection deserialize(JsonElement p_deserialize_1_, Type p_deserialize_2_, JsonDeserializationContext p_deserialize_3_) {
/* 13 */     JsonObject jsonObject = p_deserialize_1_.getAsJsonObject();
/* 14 */     float[] arrayOfFloat1 = new float[256];
/* 15 */     float[] arrayOfFloat2 = new float[256];
/* 16 */     float[] arrayOfFloat3 = new float[256];
/* 17 */     float f1 = 1.0F;
/* 18 */     float f2 = 0.0F;
/* 19 */     float f3 = 0.0F;
/*    */     
/* 21 */     if (jsonObject.has("characters")) {
/* 22 */       if (!jsonObject.get("characters").isJsonObject()) {
/* 23 */         throw new JsonParseException("Invalid font->characters: expected object, was " + jsonObject.get("characters"));
/*    */       }
/*    */       
/* 26 */       JsonObject jsonObject1 = jsonObject.getAsJsonObject("characters");
/*    */       
/* 28 */       if (jsonObject1.has("default")) {
/* 29 */         if (!jsonObject1.get("default").isJsonObject()) {
/* 30 */           throw new JsonParseException("Invalid font->characters->default: expected object, was " + jsonObject1.get("default"));
/*    */         }
/* 32 */         JsonObject jsonObject2 = jsonObject1.getAsJsonObject("default");
/*    */         
/* 34 */         f1 = JsonUtils.func_151221_a(jsonObject2, "width", f1);
/* 35 */         Validate.inclusiveBetween(Float.valueOf(0.0F), Float.valueOf(Float.MAX_VALUE), Float.valueOf(f1), "Invalid default width", new Object[0]);
/* 36 */         f2 = JsonUtils.func_151221_a(jsonObject2, "spacing", f2);
/* 37 */         Validate.inclusiveBetween(Float.valueOf(0.0F), Float.valueOf(Float.MAX_VALUE), Float.valueOf(f2), "Invalid default spacing", new Object[0]);
/* 38 */         f3 = JsonUtils.func_151221_a(jsonObject2, "left", f2);
/* 39 */         Validate.inclusiveBetween(Float.valueOf(0.0F), Float.valueOf(Float.MAX_VALUE), Float.valueOf(f3), "Invalid default left", new Object[0]);
/*    */       } 
/*    */       
/* 42 */       for (byte b = 0; b < 'Ā'; b++) {
/* 43 */         JsonElement jsonElement = jsonObject1.get(Integer.toString(b));
/* 44 */         float f4 = f1;
/* 45 */         float f5 = f2;
/* 46 */         float f6 = f3;
/*    */         
/* 48 */         if (jsonElement != null) {
/* 49 */           JsonObject jsonObject2 = JsonUtils.func_151210_l(jsonElement, "characters[" + b + "]");
/* 50 */           f4 = JsonUtils.func_151221_a(jsonObject2, "width", f1);
/* 51 */           Validate.inclusiveBetween(Float.valueOf(0.0F), Float.valueOf(Float.MAX_VALUE), Float.valueOf(f4), "Invalid width", new Object[0]);
/* 52 */           f5 = JsonUtils.func_151221_a(jsonObject2, "spacing", f2);
/* 53 */           Validate.inclusiveBetween(Float.valueOf(0.0F), Float.valueOf(Float.MAX_VALUE), Float.valueOf(f5), "Invalid spacing", new Object[0]);
/* 54 */           f6 = JsonUtils.func_151221_a(jsonObject2, "left", f3);
/* 55 */           Validate.inclusiveBetween(Float.valueOf(0.0F), Float.valueOf(Float.MAX_VALUE), Float.valueOf(f6), "Invalid left", new Object[0]);
/*    */         } 
/*    */         
/* 58 */         arrayOfFloat1[b] = f4;
/* 59 */         arrayOfFloat2[b] = f5;
/* 60 */         arrayOfFloat3[b] = f6;
/*    */       } 
/*    */     } 
/*    */     
/* 64 */     return new FontMetadataSection(arrayOfFloat1, arrayOfFloat3, arrayOfFloat2);
/*    */   }
/*    */   private static final String __OBFID = "CL_00001109";
/*    */   
/*    */   public String func_110483_a() {
/* 69 */     return "font";
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\resources\data\FontMetadataSectionSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */