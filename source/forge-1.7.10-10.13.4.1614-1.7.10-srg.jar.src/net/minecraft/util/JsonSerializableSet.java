/*    */ package net.minecraft.util;
/*    */ 
/*    */ import com.google.common.collect.ForwardingSet;
/*    */ import com.google.common.collect.Sets;
/*    */ import com.google.gson.JsonArray;
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonPrimitive;
/*    */ import java.util.Collection;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class JsonSerializableSet extends ForwardingSet implements IJsonSerializable {
/* 12 */   private final Set field_151004_a = Sets.newHashSet();
/*    */   private static final String __OBFID = "CL_00001482";
/*    */   
/*    */   public void func_152753_a(JsonElement p_152753_1_) {
/* 16 */     if (p_152753_1_.isJsonArray()) {
/* 17 */       for (JsonElement jsonElement : p_152753_1_.getAsJsonArray()) {
/* 18 */         add(jsonElement.getAsString());
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public JsonElement func_151003_a() {
/* 25 */     JsonArray jsonArray = new JsonArray();
/*    */     
/* 27 */     for (String str : this) {
/* 28 */       jsonArray.add((JsonElement)new JsonPrimitive(str));
/*    */     }
/*    */     
/* 31 */     return (JsonElement)jsonArray;
/*    */   }
/*    */ 
/*    */   
/*    */   protected Set delegate() {
/* 36 */     return this.field_151004_a;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\JsonSerializableSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */