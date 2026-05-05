/*    */ package net.minecraft.client.resources.data;
/*    */ import com.google.gson.JsonArray;
/*    */ import com.google.gson.JsonDeserializationContext;
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import com.google.gson.JsonParseException;
/*    */ import java.lang.reflect.Type;
/*    */ import java.util.ArrayList;
/*    */ import net.minecraft.util.JsonUtils;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class TextureMetadataSectionSerializer extends BaseMetadataSectionSerializer {
/*    */   public TextureMetadataSection deserialize(JsonElement p_deserialize_1_, Type p_deserialize_2_, JsonDeserializationContext p_deserialize_3_) {
/* 14 */     JsonObject jsonObject = p_deserialize_1_.getAsJsonObject();
/* 15 */     boolean bool1 = JsonUtils.func_151209_a(jsonObject, "blur", false);
/* 16 */     boolean bool2 = JsonUtils.func_151209_a(jsonObject, "clamp", false);
/*    */     
/* 18 */     ArrayList<Integer> arrayList = Lists.newArrayList();
/* 19 */     if (jsonObject.has("mipmaps")) {
/*    */       try {
/* 21 */         JsonArray jsonArray = jsonObject.getAsJsonArray("mipmaps");
/*    */         
/* 23 */         for (byte b = 0; b < jsonArray.size(); b++) {
/* 24 */           JsonElement jsonElement = jsonArray.get(b);
/*    */           
/* 26 */           if (jsonElement.isJsonPrimitive()) {
/*    */             try {
/* 28 */               arrayList.add(Integer.valueOf(jsonElement.getAsInt()));
/* 29 */             } catch (NumberFormatException numberFormatException) {
/* 30 */               throw new JsonParseException("Invalid texture->mipmap->" + b + ": expected number, was " + jsonElement, numberFormatException);
/*    */             } 
/* 32 */           } else if (jsonElement.isJsonObject()) {
/* 33 */             throw new JsonParseException("Invalid texture->mipmap->" + b + ": expected number, was " + jsonElement);
/*    */           }
/*    */         
/*    */         }
/*    */       
/* 38 */       } catch (ClassCastException classCastException) {
/* 39 */         throw new JsonParseException("Invalid texture->mipmaps: expected array, was " + jsonObject.get("mipmaps"), classCastException);
/*    */       } 
/*    */     }
/* 42 */     return new TextureMetadataSection(bool1, bool2, arrayList);
/*    */   }
/*    */   private static final String __OBFID = "CL_00001115";
/*    */   
/*    */   public String func_110483_a() {
/* 47 */     return "texture";
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\resources\data\TextureMetadataSectionSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */