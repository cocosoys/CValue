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
/*    */ import net.minecraft.client.resources.FolderResourcePack;
/*    */ import org.apache.logging.log4j.Level;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FMLFolderResourcePack
/*    */   extends FolderResourcePack
/*    */   implements FMLContainerHolder
/*    */ {
/*    */   private ModContainer container;
/*    */   
/*    */   public FMLFolderResourcePack(ModContainer container) {
/* 27 */     super(container.getSource());
/* 28 */     this.container = container;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean hasResourceName(String p_110593_1_) {
/* 34 */     return super.hasResourceName(p_110593_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getPackName() {
/* 39 */     return "FMLFileResourcePack:" + this.container.getName();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected InputStream getInputStreamByName(String resourceName) throws IOException {
/*    */     try {
/* 46 */       return super.getInputStreamByName(resourceName);
/*    */     }
/* 48 */     catch (IOException ioe) {
/*    */       
/* 50 */       if ("pack.mcmeta".equals(resourceName)) {
/*    */         
/* 52 */         FMLLog.log(this.container.getName(), Level.DEBUG, "Mod %s is missing a pack.mcmeta file, substituting a dummy one", new Object[] { this.container.getName() });
/* 53 */         return new ByteArrayInputStream(("{\n \"pack\": {\n   \"description\": \"dummy FML pack for " + this.container
/*    */             
/* 55 */             .getName() + "\",\n" + "   \"pack_format\": 1\n" + "}\n" + "}")
/*    */ 
/*    */             
/* 58 */             .getBytes(Charsets.UTF_8));
/*    */       } 
/* 60 */       throw ioe;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public BufferedImage getPackImage() throws IOException {
/* 67 */     return ImageIO.read(getInputStreamByName((this.container.getMetadata()).logoFile));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ModContainer getFMLContainer() {
/* 73 */     return this.container;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\client\FMLFolderResourcePack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */