/*    */ package cpw.mods.fml.client;
/*    */ 
/*    */ import com.google.common.base.Charsets;
/*    */ import cpw.mods.fml.common.FMLContainerHolder;
/*    */ import cpw.mods.fml.common.FMLLog;
/*    */ import cpw.mods.fml.common.ModContainer;
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.io.ByteArrayInputStream;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import javax.imageio.ImageIO;
/*    */ import net.minecraft.client.resources.FileResourcePack;
/*    */ import org.apache.logging.log4j.Level;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FMLFileResourcePack
/*    */   extends FileResourcePack
/*    */   implements FMLContainerHolder
/*    */ {
/*    */   private ModContainer container;
/*    */   
/*    */   public FMLFileResourcePack(ModContainer container) {
/* 27 */     super(container.getSource());
/* 28 */     this.container = container;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getPackName() {
/* 34 */     return "FMLFileResourcePack:" + this.container.getName();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected InputStream getInputStreamByName(String resourceName) throws IOException {
/*    */     try {
/* 41 */       return super.getInputStreamByName(resourceName);
/*    */     }
/* 43 */     catch (IOException ioe) {
/*    */       
/* 45 */       if ("pack.mcmeta".equals(resourceName)) {
/*    */         
/* 47 */         FMLLog.log(this.container.getName(), Level.DEBUG, "Mod %s is missing a pack.mcmeta file, substituting a dummy one", new Object[] { this.container.getName() });
/* 48 */         return new ByteArrayInputStream(("{\n \"pack\": {\n   \"description\": \"dummy FML pack for " + this.container
/*    */             
/* 50 */             .getName() + "\",\n" + "   \"pack_format\": 1\n" + "}\n" + "}")
/*    */ 
/*    */             
/* 53 */             .getBytes(Charsets.UTF_8));
/*    */       } 
/* 55 */       throw ioe;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public BufferedImage getPackImage() throws IOException {
/* 62 */     return ImageIO.read(getInputStreamByName((this.container.getMetadata()).logoFile));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ModContainer getFMLContainer() {
/* 68 */     return this.container;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\client\FMLFileResourcePack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */