/*    */ package net.minecraft.client.renderer.texture;
/*    */ import com.google.common.collect.Lists;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.util.List;
/*    */ import net.minecraft.client.resources.IResourceManager;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.apache.logging.log4j.LogManager;
/*    */ import org.apache.logging.log4j.Logger;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class LayeredTexture extends AbstractTexture {
/* 16 */   private static final Logger field_147638_c = LogManager.getLogger();
/*    */   public final List field_110567_b;
/*    */   private static final String __OBFID = "CL_00001051";
/*    */   
/*    */   public LayeredTexture(String... p_i1274_1_) {
/* 21 */     this.field_110567_b = Lists.newArrayList((Object[])p_i1274_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_110551_a(IResourceManager p_110551_1_) throws IOException {
/* 26 */     func_147631_c();
/*    */     
/* 28 */     BufferedImage bufferedImage = null;
/*    */     
/*    */     try {
/* 31 */       for (String str : this.field_110567_b) {
/* 32 */         if (str == null) {
/*    */           continue;
/*    */         }
/* 35 */         InputStream inputStream = p_110551_1_.func_110536_a(new ResourceLocation(str)).func_110527_b();
/* 36 */         BufferedImage bufferedImage1 = ImageIO.read(inputStream);
/*    */ 
/*    */         
/* 39 */         if (bufferedImage == null) {
/* 40 */           bufferedImage = new BufferedImage(bufferedImage1.getWidth(), bufferedImage1.getHeight(), 2);
/*    */         }
/* 42 */         bufferedImage.getGraphics().drawImage(bufferedImage1, 0, 0, null);
/*    */       } 
/* 44 */     } catch (IOException iOException) {
/* 45 */       field_147638_c.error("Couldn't load layered image", iOException);
/*    */       
/*    */       return;
/*    */     } 
/* 49 */     TextureUtil.func_110987_a(func_110552_b(), bufferedImage);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\texture\LayeredTexture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */