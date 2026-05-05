/*    */ package net.minecraft.client.resources.data;
/*    */ 
/*    */ import com.google.common.collect.Sets;
/*    */ import com.google.gson.JsonDeserializationContext;
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import com.google.gson.JsonParseException;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.lang.reflect.Type;
/*    */ import java.util.HashSet;
/*    */ import java.util.Map;
/*    */ import net.minecraft.client.resources.Language;
/*    */ import net.minecraft.util.JsonUtils;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class LanguageMetadataSectionSerializer extends BaseMetadataSectionSerializer {
/*    */   public LanguageMetadataSection deserialize(JsonElement p_deserialize_1_, Type p_deserialize_2_, JsonDeserializationContext p_deserialize_3_) {
/* 19 */     JsonObject jsonObject = p_deserialize_1_.getAsJsonObject();
/* 20 */     HashSet<Language> hashSet = Sets.newHashSet();
/*    */     
/* 22 */     for (Map.Entry entry : jsonObject.entrySet()) {
/* 23 */       String str1 = (String)entry.getKey();
/* 24 */       JsonObject jsonObject1 = JsonUtils.func_151210_l((JsonElement)entry.getValue(), "language");
/* 25 */       String str2 = JsonUtils.func_151200_h(jsonObject1, "region");
/* 26 */       String str3 = JsonUtils.func_151200_h(jsonObject1, "name");
/* 27 */       boolean bool = JsonUtils.func_151209_a(jsonObject1, "bidirectional", false);
/*    */       
/* 29 */       if (str2.isEmpty()) {
/* 30 */         throw new JsonParseException("Invalid language->'" + str1 + "'->region: empty value");
/*    */       }
/*    */       
/* 33 */       if (str3.isEmpty()) {
/* 34 */         throw new JsonParseException("Invalid language->'" + str1 + "'->name: empty value");
/*    */       }
/*    */       
/* 37 */       if (!hashSet.add(new Language(str1, str2, str3, bool))) {
/* 38 */         throw new JsonParseException("Duplicate language->'" + str1 + "' defined");
/*    */       }
/*    */     } 
/*    */     
/* 42 */     return new LanguageMetadataSection(hashSet);
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_110483_a() {
/* 47 */     return "language";
/*    */   }
/*    */   
/*    */   private static final String __OBFID = "CL_00001111";
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\resources\data\LanguageMetadataSectionSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */