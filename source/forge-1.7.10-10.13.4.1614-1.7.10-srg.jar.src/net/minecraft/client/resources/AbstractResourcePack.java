/*    */ package net.minecraft.client.resources;
/*    */ import com.google.gson.JsonObject;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.io.BufferedReader;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import javax.imageio.ImageIO;
/*    */ import net.minecraft.client.resources.data.IMetadataSection;
/*    */ import net.minecraft.client.resources.data.IMetadataSerializer;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.apache.commons.io.IOUtils;
/*    */ import org.apache.logging.log4j.LogManager;
/*    */ import org.apache.logging.log4j.Logger;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public abstract class AbstractResourcePack implements IResourcePack {
/* 19 */   private static final Logger field_110598_a = LogManager.getLogger();
/*    */   protected final File field_110597_b;
/*    */   private static final String __OBFID = "CL_00001072";
/*    */   
/*    */   public AbstractResourcePack(File p_i1287_1_) {
/* 24 */     this.field_110597_b = p_i1287_1_;
/*    */   }
/*    */   
/*    */   private static String func_110592_c(ResourceLocation p_110592_0_) {
/* 28 */     return String.format("%s/%s/%s", new Object[] { "assets", p_110592_0_.func_110624_b(), p_110592_0_.func_110623_a() });
/*    */   }
/*    */   
/*    */   protected static String func_110595_a(File p_110595_0_, File p_110595_1_) {
/* 32 */     return p_110595_0_.toURI().relativize(p_110595_1_.toURI()).getPath();
/*    */   }
/*    */ 
/*    */   
/*    */   public InputStream func_110590_a(ResourceLocation p_110590_1_) throws IOException {
/* 37 */     return func_110591_a(func_110592_c(p_110590_1_));
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_110589_b(ResourceLocation p_110589_1_) {
/* 42 */     return func_110593_b(func_110592_c(p_110589_1_));
/*    */   }
/*    */   
/*    */   protected abstract InputStream func_110591_a(String paramString) throws IOException;
/*    */   
/*    */   protected abstract boolean func_110593_b(String paramString);
/*    */   
/*    */   protected void func_110594_c(String p_110594_1_) {
/* 50 */     field_110598_a.warn("ResourcePack: ignored non-lowercase namespace: %s in %s", new Object[] { p_110594_1_, this.field_110597_b });
/*    */   }
/*    */ 
/*    */   
/*    */   public IMetadataSection func_135058_a(IMetadataSerializer p_135058_1_, String p_135058_2_) throws IOException {
/* 55 */     return func_110596_a(p_135058_1_, func_110591_a("pack.mcmeta"), p_135058_2_);
/*    */   }
/*    */   
/*    */   static IMetadataSection func_110596_a(IMetadataSerializer p_110596_0_, InputStream p_110596_1_, String p_110596_2_) {
/* 59 */     JsonObject jsonObject = null;
/* 60 */     BufferedReader bufferedReader = null;
/*    */     try {
/* 62 */       bufferedReader = new BufferedReader(new InputStreamReader(p_110596_1_, Charsets.UTF_8));
/* 63 */       jsonObject = (new JsonParser()).parse(bufferedReader).getAsJsonObject();
/* 64 */     } catch (RuntimeException runtimeException) {
/* 65 */       throw new JsonParseException(runtimeException);
/*    */     } finally {
/* 67 */       IOUtils.closeQuietly(bufferedReader);
/*    */     } 
/*    */     
/* 70 */     return p_110596_0_.func_110503_a(p_110596_2_, jsonObject);
/*    */   }
/*    */ 
/*    */   
/*    */   public BufferedImage func_110586_a() throws IOException {
/* 75 */     return ImageIO.read(func_110591_a("pack.png"));
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_130077_b() {
/* 80 */     return this.field_110597_b.getName();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\resources\AbstractResourcePack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */