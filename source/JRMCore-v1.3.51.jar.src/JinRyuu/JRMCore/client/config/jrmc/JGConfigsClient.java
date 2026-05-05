/*    */ package JinRyuu.JRMCore.client.config.jrmc;
/*    */ 
/*    */ import JinRyuu.JRMCore.JRMCore;
/*    */ import cpw.mods.fml.common.event.FMLPreInitializationEvent;
/*    */ import java.io.File;
/*    */ import net.minecraftforge.common.config.Configuration;
/*    */ 
/*    */ public class JGConfigsClient
/*    */ {
/*    */   public static final String CONFIG_JRMC = "/jingames/jrmc/";
/*    */   public static Configuration clientSettings;
/*    */   public static Configuration clientNotifications;
/*    */   
/*    */   public static void preInitClient(FMLPreInitializationEvent event) {
/* 15 */     JRMCore.configDir_client = new File(event.getModConfigurationDirectory().getPath() + "/jingames/jrmc/" + "client_settings.cfg");
/* 16 */     clientSettings = new Configuration(JRMCore.configDir_client);
/* 17 */     JGConfigClientSettings.init(clientSettings);
/*    */     
/* 19 */     JRMCore.configDir_clientNotifications = new File(event.getModConfigurationDirectory().getPath() + "/jingames/jrmc/" + "client_notifications.cfg");
/* 20 */     clientNotifications = new Configuration(JRMCore.configDir_clientNotifications);
/* 21 */     JGConfigClientSettings.initNotifications(clientNotifications);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\client\config\jrmc\JGConfigsClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */