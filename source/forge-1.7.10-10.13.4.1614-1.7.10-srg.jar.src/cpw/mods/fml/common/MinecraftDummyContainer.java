/*    */ package cpw.mods.fml.common;
/*    */ 
/*    */ import cpw.mods.fml.common.versioning.VersionParser;
/*    */ import cpw.mods.fml.common.versioning.VersionRange;
/*    */ import cpw.mods.fml.relauncher.FMLLaunchHandler;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import java.security.cert.Certificate;
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
/*    */ public class MinecraftDummyContainer
/*    */   extends DummyModContainer
/*    */ {
/*    */   private VersionRange staticRange;
/*    */   
/*    */   public MinecraftDummyContainer(String actualMCVersion) {
/* 28 */     super(new ModMetadata());
/* 29 */     (getMetadata()).modId = "Minecraft";
/* 30 */     (getMetadata()).name = "Minecraft";
/* 31 */     (getMetadata()).version = actualMCVersion;
/* 32 */     this.staticRange = VersionParser.parseRange("[" + actualMCVersion + "]");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public VersionRange getStaticVersionRange() {
/* 38 */     return this.staticRange;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Certificate getSigningCertificate() {
/* 44 */     if (FMLLaunchHandler.side() != Side.CLIENT) {
/* 45 */       return null;
/*    */     }
/*    */     
/*    */     try {
/* 49 */       Class<?> cbr = Class.forName("net.minecraft.client.ClientBrandRetriever", false, getClass().getClassLoader());
/* 50 */       Certificate[] certificates = cbr.getProtectionDomain().getCodeSource().getCertificates();
/* 51 */       return (certificates != null) ? certificates[0] : null;
/*    */     }
/* 53 */     catch (Exception exception) {
/* 54 */       return null;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\MinecraftDummyContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */