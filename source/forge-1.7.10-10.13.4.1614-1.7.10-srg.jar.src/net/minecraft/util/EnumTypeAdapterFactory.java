/*    */ package net.minecraft.util;
/*    */ 
/*    */ import com.google.gson.Gson;
/*    */ import com.google.gson.TypeAdapter;
/*    */ import com.google.gson.TypeAdapterFactory;
/*    */ import com.google.gson.reflect.TypeToken;
/*    */ import com.google.gson.stream.JsonReader;
/*    */ import com.google.gson.stream.JsonToken;
/*    */ import com.google.gson.stream.JsonWriter;
/*    */ import java.io.IOException;
/*    */ import java.util.HashMap;
/*    */ import java.util.Locale;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EnumTypeAdapterFactory
/*    */   implements TypeAdapterFactory
/*    */ {
/*    */   private static final String __OBFID = "CL_00001494";
/*    */   
/*    */   public TypeAdapter create(Gson p_create_1_, TypeToken p_create_2_) {
/* 23 */     Class<Object> clazz = p_create_2_.getRawType();
/* 24 */     if (!clazz.isEnum()) {
/* 25 */       return null;
/*    */     }
/*    */     
/* 28 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 29 */     for (Object object : clazz.getEnumConstants()) {
/* 30 */       hashMap.put(func_151232_a(object), object);
/*    */     }
/*    */     
/* 33 */     return new TypeAdapter(this, hashMap)
/*    */       {
/*    */         public void write(JsonWriter p_write_1_, Object p_write_2_) throws IOException {
/* 36 */           if (p_write_2_ == null) {
/* 37 */             p_write_1_.nullValue();
/*    */           } else {
/* 39 */             p_write_1_.value(this.field_151230_b.func_151232_a(p_write_2_));
/*    */           } 
/*    */         }
/*    */         private static final String __OBFID = "CL_00001495";
/*    */         
/*    */         public Object read(JsonReader p_read_1_) throws IOException {
/* 45 */           if (p_read_1_.peek() == JsonToken.NULL) {
/* 46 */             p_read_1_.nextNull();
/* 47 */             return null;
/*    */           } 
/* 49 */           return this.field_151231_a.get(p_read_1_.nextString());
/*    */         }
/*    */       };
/*    */   }
/*    */ 
/*    */   
/*    */   private String func_151232_a(Object p_151232_1_) {
/* 56 */     if (p_151232_1_ instanceof Enum) return ((Enum)p_151232_1_).name().toLowerCase(Locale.US); 
/* 57 */     return p_151232_1_.toString().toLowerCase(Locale.US);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\EnumTypeAdapterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */