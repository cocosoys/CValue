/*    */ package net.minecraft.server;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.FileOutputStream;
/*    */ import java.util.Properties;
/*    */ import org.apache.commons.io.IOUtils;
/*    */ 
/*    */ @SideOnly(Side.SERVER)
/*    */ public class ServerEula {
/* 11 */   private static final Logger field_154349_a = LogManager.getLogger(); private final File field_154350_b;
/*    */   private final boolean field_154351_c;
/*    */   private static final String __OBFID = "CL_00001911";
/*    */   
/*    */   public ServerEula(File p_i1227_1_) {
/* 16 */     this.field_154350_b = p_i1227_1_;
/* 17 */     this.field_154351_c = func_154347_a(p_i1227_1_);
/*    */   }
/*    */   
/*    */   private boolean func_154347_a(File p_154347_1_) {
/* 21 */     FileInputStream fileInputStream = null;
/* 22 */     boolean bool = false;
/*    */     try {
/* 24 */       Properties properties = new Properties();
/* 25 */       fileInputStream = new FileInputStream(p_154347_1_);
/* 26 */       properties.load(fileInputStream);
/* 27 */       bool = Boolean.parseBoolean(properties.getProperty("eula", "false"));
/* 28 */     } catch (Exception exception) {
/* 29 */       field_154349_a.warn("Failed to load " + p_154347_1_);
/* 30 */       func_154348_b();
/*    */     } finally {
/* 32 */       IOUtils.closeQuietly(fileInputStream);
/*    */     } 
/* 34 */     return bool;
/*    */   }
/*    */   
/*    */   public boolean func_154346_a() {
/* 38 */     return this.field_154351_c;
/*    */   }
/*    */   
/*    */   public void func_154348_b() {
/* 42 */     FileOutputStream fileOutputStream = null;
/*    */     try {
/* 44 */       Properties properties = new Properties();
/* 45 */       fileOutputStream = new FileOutputStream(this.field_154350_b);
/* 46 */       properties.setProperty("eula", "false");
/* 47 */       properties.store(fileOutputStream, "By changing the setting below to TRUE you are indicating your agreement to our EULA (https://account.mojang.com/documents/minecraft_eula).");
/* 48 */     } catch (Exception exception) {
/* 49 */       field_154349_a.warn("Failed to save " + this.field_154350_b, exception);
/*    */     } finally {
/* 51 */       IOUtils.closeQuietly(fileOutputStream);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\server\ServerEula.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */