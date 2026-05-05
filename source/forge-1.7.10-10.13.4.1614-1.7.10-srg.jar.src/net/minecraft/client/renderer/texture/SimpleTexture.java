/*    */ package net.minecraft.client.renderer.texture;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import net.minecraft.client.resources.IResource;
/*    */ import net.minecraft.client.resources.IResourceManager;
/*    */ import net.minecraft.client.resources.data.TextureMetadataSection;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.apache.logging.log4j.LogManager;
/*    */ import org.apache.logging.log4j.Logger;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class SimpleTexture extends AbstractTexture {
/* 16 */   private static final Logger field_147639_c = LogManager.getLogger(); protected final ResourceLocation field_110568_b;
/*    */   private static final String __OBFID = "CL_00001052";
/*    */   
/*    */   public SimpleTexture(ResourceLocation p_i1275_1_) {
/* 20 */     this.field_110568_b = p_i1275_1_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_110551_a(IResourceManager p_110551_1_) throws IOException {
/* 25 */     func_147631_c();
/*    */     
/* 27 */     InputStream inputStream = null;
/*    */     try {
/* 29 */       IResource iResource = p_110551_1_.func_110536_a(this.field_110568_b);
/* 30 */       inputStream = iResource.func_110527_b();
/* 31 */       BufferedImage bufferedImage = ImageIO.read(inputStream);
/*    */       
/* 33 */       boolean bool1 = false;
/* 34 */       boolean bool2 = false;
/*    */       
/* 36 */       if (iResource.func_110528_c()) {
/*    */         try {
/* 38 */           TextureMetadataSection textureMetadataSection = (TextureMetadataSection)iResource.func_110526_a("texture");
/* 39 */           if (textureMetadataSection != null) {
/* 40 */             bool1 = textureMetadataSection.func_110479_a();
/* 41 */             bool2 = textureMetadataSection.func_110480_b();
/*    */           } 
/* 43 */         } catch (RuntimeException runtimeException) {
/* 44 */           field_147639_c.warn("Failed reading metadata of: " + this.field_110568_b, runtimeException);
/*    */         } 
/*    */       }
/*    */       
/* 48 */       TextureUtil.func_110989_a(func_110552_b(), bufferedImage, bool1, bool2);
/*    */     } finally {
/* 50 */       if (inputStream != null)
/* 51 */         inputStream.close(); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\texture\SimpleTexture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */