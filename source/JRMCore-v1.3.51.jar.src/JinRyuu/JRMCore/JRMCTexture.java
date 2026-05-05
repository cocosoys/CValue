/*    */ package JinRyuu.JRMCore;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.io.IOException;
/*    */ import java.net.URL;
/*    */ import javax.imageio.ImageIO;
/*    */ import net.minecraft.client.renderer.texture.AbstractTexture;
/*    */ import net.minecraft.client.renderer.texture.TextureUtil;
/*    */ import net.minecraft.client.resources.IResourceManager;
/*    */ import org.apache.logging.log4j.LogManager;
/*    */ import org.apache.logging.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class JRMCTexture
/*    */   extends AbstractTexture
/*    */ {
/* 22 */   private static final Logger logger = LogManager.getLogger();
/*    */   
/*    */   protected final String textureLocation;
/*    */   
/*    */   public JRMCTexture(String p_i1275_1_) {
/* 27 */     this.textureLocation = p_i1275_1_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_110551_a(IResourceManager p_110551_1_) throws IOException {
/* 32 */     func_147631_c();
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 37 */     BufferedImage bufferedimage = ImageIO.read(new URL(this.textureLocation));
/* 38 */     boolean flag = false;
/* 39 */     boolean flag1 = false;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 59 */     TextureUtil.func_110989_a(func_110552_b(), bufferedimage, flag, flag1);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCTexture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */