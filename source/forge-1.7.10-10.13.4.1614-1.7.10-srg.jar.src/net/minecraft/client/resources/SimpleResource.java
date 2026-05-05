/*    */ package net.minecraft.client.resources;
/*    */ import com.google.common.collect.Maps;
/*    */ import com.google.gson.JsonObject;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.io.BufferedReader;
/*    */ import java.io.InputStream;
/*    */ import java.util.Map;
/*    */ import net.minecraft.client.resources.data.IMetadataSection;
/*    */ import net.minecraft.client.resources.data.IMetadataSerializer;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.apache.commons.io.IOUtils;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class SimpleResource implements IResource {
/* 16 */   private final Map field_110535_a = Maps.newHashMap(); private final ResourceLocation field_110533_b;
/*    */   private final InputStream field_110534_c;
/*    */   private final InputStream field_110531_d;
/*    */   private final IMetadataSerializer field_110532_e;
/*    */   private boolean field_110529_f;
/*    */   private JsonObject field_110530_g;
/*    */   private static final String __OBFID = "CL_00001093";
/*    */   
/*    */   public SimpleResource(ResourceLocation p_i1300_1_, InputStream p_i1300_2_, InputStream p_i1300_3_, IMetadataSerializer p_i1300_4_) {
/* 25 */     this.field_110533_b = p_i1300_1_;
/* 26 */     this.field_110534_c = p_i1300_2_;
/* 27 */     this.field_110531_d = p_i1300_3_;
/* 28 */     this.field_110532_e = p_i1300_4_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public InputStream func_110527_b() {
/* 38 */     return this.field_110534_c;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_110528_c() {
/* 43 */     return (this.field_110531_d != null);
/*    */   }
/*    */ 
/*    */   
/*    */   public IMetadataSection func_110526_a(String p_110526_1_) {
/* 48 */     if (!func_110528_c()) {
/* 49 */       return null;
/*    */     }
/*    */     
/* 52 */     if (this.field_110530_g == null && !this.field_110529_f) {
/* 53 */       this.field_110529_f = true;
/*    */       
/* 55 */       BufferedReader bufferedReader = null;
/*    */       try {
/* 57 */         bufferedReader = new BufferedReader(new InputStreamReader(this.field_110531_d));
/* 58 */         this.field_110530_g = (new JsonParser()).parse(bufferedReader).getAsJsonObject();
/*    */       } finally {
/* 60 */         IOUtils.closeQuietly(bufferedReader);
/*    */       } 
/*    */     } 
/*    */ 
/*    */     
/* 65 */     IMetadataSection iMetadataSection = (IMetadataSection)this.field_110535_a.get(p_110526_1_);
/* 66 */     if (iMetadataSection == null) {
/* 67 */       iMetadataSection = this.field_110532_e.func_110503_a(p_110526_1_, this.field_110530_g);
/*    */     }
/* 69 */     return iMetadataSection;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object p_equals_1_) {
/* 74 */     if (this == p_equals_1_) return true;
/*    */     
/* 76 */     if (p_equals_1_ instanceof SimpleResource) {
/* 77 */       SimpleResource simpleResource = (SimpleResource)p_equals_1_;
/*    */       
/* 79 */       return (this.field_110533_b != null) ? this.field_110533_b.equals(simpleResource.field_110533_b) : ((simpleResource.field_110533_b == null));
/*    */     } 
/*    */     
/* 82 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 87 */     if (this.field_110533_b == null) return 0;
/*    */     
/* 89 */     return this.field_110533_b.hashCode();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\resources\SimpleResource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */