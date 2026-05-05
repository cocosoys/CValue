/*    */ package net.minecraft.client.resources.data;
/*    */ import com.google.gson.JsonDeserializationContext;
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import com.google.gson.JsonSerializationContext;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import java.lang.reflect.Type;
/*    */ import net.minecraft.util.IChatComponent;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class PackMetadataSectionSerializer extends BaseMetadataSectionSerializer implements JsonSerializer {
/*    */   public PackMetadataSection deserialize(JsonElement p_deserialize_1_, Type p_deserialize_2_, JsonDeserializationContext p_deserialize_3_) {
/* 13 */     JsonObject jsonObject = p_deserialize_1_.getAsJsonObject();
/* 14 */     IChatComponent iChatComponent = (IChatComponent)p_deserialize_3_.deserialize(jsonObject.get("description"), IChatComponent.class);
/* 15 */     int i = JsonUtils.func_151203_m(jsonObject, "pack_format");
/* 16 */     return new PackMetadataSection(iChatComponent, i);
/*    */   }
/*    */   private static final String __OBFID = "CL_00001113";
/*    */   
/*    */   public JsonElement serialize(PackMetadataSection p_serialize_1_, Type p_serialize_2_, JsonSerializationContext p_serialize_3_) {
/* 21 */     JsonObject jsonObject = new JsonObject();
/*    */     
/* 23 */     jsonObject.addProperty("pack_format", Integer.valueOf(p_serialize_1_.func_110462_b()));
/* 24 */     jsonObject.add("description", p_serialize_3_.serialize(p_serialize_1_.func_152805_a()));
/*    */     
/* 26 */     return (JsonElement)jsonObject;
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_110483_a() {
/* 31 */     return "pack";
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\resources\data\PackMetadataSectionSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */