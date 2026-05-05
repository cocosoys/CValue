/*    */ package net.minecraft.client.audio;
/*    */ import com.google.gson.JsonArray;
/*    */ import com.google.gson.JsonDeserializationContext;
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import net.minecraft.util.JsonUtils;
/*    */ import org.apache.commons.lang3.Validate;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class SoundListSerializer implements JsonDeserializer {
/*    */   public SoundList deserialize(JsonElement p_deserialize_1_, Type p_deserialize_2_, JsonDeserializationContext p_deserialize_3_) {
/* 12 */     JsonObject jsonObject = JsonUtils.func_151210_l(p_deserialize_1_, "entry");
/* 13 */     SoundList soundList = new SoundList();
/*    */     
/* 15 */     soundList.func_148572_a(JsonUtils.func_151209_a(jsonObject, "replace", false));
/*    */     
/* 17 */     SoundCategory soundCategory = SoundCategory.func_147154_a(JsonUtils.func_151219_a(jsonObject, "category", SoundCategory.MASTER.func_147155_a()));
/* 18 */     soundList.func_148571_a(soundCategory);
/* 19 */     Validate.notNull(soundCategory, "Invalid category", new Object[0]);
/*    */     
/* 21 */     if (jsonObject.has("sounds")) {
/* 22 */       JsonArray jsonArray = JsonUtils.func_151214_t(jsonObject, "sounds");
/* 23 */       for (byte b = 0; b < jsonArray.size(); b++) {
/* 24 */         JsonElement jsonElement = jsonArray.get(b);
/* 25 */         SoundList.SoundEntry soundEntry = new SoundList.SoundEntry();
/*    */         
/* 27 */         if (JsonUtils.func_151211_a(jsonElement)) {
/* 28 */           soundEntry.func_148561_a(JsonUtils.func_151206_a(jsonElement, "sound"));
/*    */         } else {
/* 30 */           JsonObject jsonObject1 = JsonUtils.func_151210_l(jsonElement, "sound");
/* 31 */           soundEntry.func_148561_a(JsonUtils.func_151200_h(jsonObject1, "name"));
/*    */           
/* 33 */           if (jsonObject1.has("type")) {
/* 34 */             SoundList.SoundEntry.Type type = SoundList.SoundEntry.Type.func_148580_a(JsonUtils.func_151200_h(jsonObject1, "type"));
/* 35 */             Validate.notNull(type, "Invalid type", new Object[0]);
/* 36 */             soundEntry.func_148562_a(type);
/*    */           } 
/*    */           
/* 39 */           if (jsonObject1.has("volume")) {
/* 40 */             float f = JsonUtils.func_151217_k(jsonObject1, "volume");
/* 41 */             Validate.isTrue((f > 0.0F), "Invalid volume", new Object[0]);
/* 42 */             soundEntry.func_148553_a(f);
/*    */           } 
/*    */           
/* 45 */           if (jsonObject1.has("pitch")) {
/* 46 */             float f = JsonUtils.func_151217_k(jsonObject1, "pitch");
/* 47 */             Validate.isTrue((f > 0.0F), "Invalid pitch", new Object[0]);
/* 48 */             soundEntry.func_148559_b(f);
/*    */           } 
/*    */           
/* 51 */           if (jsonObject1.has("weight")) {
/* 52 */             int i = JsonUtils.func_151203_m(jsonObject1, "weight");
/* 53 */             Validate.isTrue((i > 0), "Invalid weight", new Object[0]);
/* 54 */             soundEntry.func_148554_a(i);
/*    */           } 
/*    */           
/* 57 */           if (jsonObject1.has("stream")) {
/* 58 */             soundEntry.func_148557_a(JsonUtils.func_151212_i(jsonObject1, "stream"));
/*    */           }
/*    */         } 
/*    */         
/* 62 */         soundList.func_148570_a().add(soundEntry);
/*    */       } 
/*    */     } 
/*    */     
/* 66 */     return soundList;
/*    */   }
/*    */   
/*    */   private static final String __OBFID = "CL_00001124";
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\audio\SoundListSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */