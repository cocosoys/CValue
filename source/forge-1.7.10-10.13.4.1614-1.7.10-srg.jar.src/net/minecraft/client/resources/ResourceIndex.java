/*    */ package net.minecraft.client.resources;
/*    */ import com.google.common.base.Charsets;
/*    */ import com.google.common.collect.Maps;
/*    */ import com.google.common.io.Files;
/*    */ import com.google.gson.JsonObject;
/*    */ import com.google.gson.JsonParseException;
/*    */ import com.google.gson.JsonParser;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.io.BufferedReader;
/*    */ import java.io.File;
/*    */ import java.io.FileNotFoundException;
/*    */ import java.util.Map;
/*    */ import net.minecraft.util.JsonUtils;
/*    */ import org.apache.commons.io.IOUtils;
/*    */ import org.apache.logging.log4j.LogManager;
/*    */ import org.apache.logging.log4j.Logger;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ResourceIndex {
/* 21 */   private static final Logger field_152783_a = LogManager.getLogger();
/*    */   
/* 23 */   private final Map field_152784_b = Maps.newHashMap(); private static final String __OBFID = "CL_00001831";
/*    */   
/*    */   public ResourceIndex(File p_i1047_1_, String p_i1047_2_) {
/* 26 */     if (p_i1047_2_ == null) {
/*    */       return;
/*    */     }
/*    */     
/* 30 */     File file1 = new File(p_i1047_1_, "objects");
/*    */     
/* 32 */     File file2 = new File(p_i1047_1_, "indexes/" + p_i1047_2_ + ".json");
/* 33 */     BufferedReader bufferedReader = null;
/*    */     try {
/* 35 */       bufferedReader = Files.newReader(file2, Charsets.UTF_8);
/* 36 */       JsonObject jsonObject1 = (new JsonParser()).parse(bufferedReader).getAsJsonObject();
/* 37 */       JsonObject jsonObject2 = JsonUtils.func_151218_a(jsonObject1, "objects", null);
/* 38 */       if (jsonObject2 != null) {
/* 39 */         for (Map.Entry entry : jsonObject2.entrySet()) {
/* 40 */           JsonObject jsonObject = (JsonObject)entry.getValue();
/*    */           
/* 42 */           String str1 = (String)entry.getKey();
/* 43 */           String[] arrayOfString = str1.split("/", 2);
/* 44 */           String str2 = (arrayOfString.length == 1) ? arrayOfString[0] : (arrayOfString[0] + ":" + arrayOfString[1]);
/*    */           
/* 46 */           String str3 = JsonUtils.func_151200_h(jsonObject, "hash");
/* 47 */           File file = new File(file1, str3.substring(0, 2) + "/" + str3);
/*    */           
/* 49 */           this.field_152784_b.put(str2, file);
/*    */         } 
/*    */       }
/* 52 */     } catch (JsonParseException jsonParseException) {
/* 53 */       field_152783_a.error("Unable to parse resource index file: " + file2);
/* 54 */     } catch (FileNotFoundException fileNotFoundException) {
/* 55 */       field_152783_a.error("Can't find the resource index file: " + file2);
/*    */     } finally {
/* 57 */       IOUtils.closeQuietly(bufferedReader);
/*    */     } 
/*    */   }
/*    */   
/*    */   public Map func_152782_a() {
/* 62 */     return this.field_152784_b;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\resources\ResourceIndex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */