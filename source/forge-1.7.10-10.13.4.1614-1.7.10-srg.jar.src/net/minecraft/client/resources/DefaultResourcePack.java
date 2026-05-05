/*    */ package net.minecraft.client.resources;
/*    */ import com.google.common.collect.ImmutableSet;
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.FileNotFoundException;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import net.minecraft.client.resources.data.IMetadataSerializer;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class DefaultResourcePack implements IResourcePack {
/* 15 */   public static final Set field_110608_a = (Set)ImmutableSet.of("minecraft", "realms"); private final Map field_152781_b;
/*    */   private static final String __OBFID = "CL_00001073";
/*    */   
/*    */   public DefaultResourcePack(Map p_i1046_1_) {
/* 19 */     this.field_152781_b = p_i1046_1_;
/*    */   }
/*    */ 
/*    */   
/*    */   public InputStream func_110590_a(ResourceLocation p_110590_1_) throws IOException {
/* 24 */     InputStream inputStream1 = func_110605_c(p_110590_1_);
/* 25 */     if (inputStream1 != null) {
/* 26 */       return inputStream1;
/*    */     }
/*    */ 
/*    */     
/* 30 */     InputStream inputStream2 = func_152780_c(p_110590_1_);
/* 31 */     if (inputStream2 != null) {
/* 32 */       return inputStream2;
/*    */     }
/*    */     
/* 35 */     throw new FileNotFoundException(p_110590_1_.func_110623_a());
/*    */   }
/*    */   
/*    */   public InputStream func_152780_c(ResourceLocation p_152780_1_) throws IOException {
/* 39 */     File file = (File)this.field_152781_b.get(p_152780_1_.toString());
/*    */     
/* 41 */     return (file == null || !file.isFile()) ? null : new FileInputStream(file);
/*    */   }
/*    */   
/*    */   private InputStream func_110605_c(ResourceLocation p_110605_1_) {
/* 45 */     return DefaultResourcePack.class.getResourceAsStream("/assets/" + p_110605_1_.func_110624_b() + "/" + p_110605_1_.func_110623_a());
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_110589_b(ResourceLocation p_110589_1_) {
/* 50 */     return (func_110605_c(p_110589_1_) != null || this.field_152781_b.containsKey(p_110589_1_.toString()));
/*    */   }
/*    */ 
/*    */   
/*    */   public Set func_110587_b() {
/* 55 */     return field_110608_a;
/*    */   }
/*    */ 
/*    */   
/*    */   public IMetadataSection func_135058_a(IMetadataSerializer p_135058_1_, String p_135058_2_) throws IOException {
/*    */     try {
/* 61 */       FileInputStream fileInputStream = new FileInputStream((File)this.field_152781_b.get("pack.mcmeta"));
/* 62 */       return AbstractResourcePack.func_110596_a(p_135058_1_, fileInputStream, p_135058_2_);
/* 63 */     } catch (RuntimeException runtimeException) {
/* 64 */       return null;
/* 65 */     } catch (FileNotFoundException fileNotFoundException) {
/* 66 */       return null;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public BufferedImage func_110586_a() throws IOException {
/* 72 */     return ImageIO.read(DefaultResourcePack.class.getResourceAsStream("/" + (new ResourceLocation("pack.png")).func_110623_a()));
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_130077_b() {
/* 77 */     return "Default";
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\resources\DefaultResourcePack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */