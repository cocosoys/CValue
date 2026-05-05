/*    */ package net.minecraft.server.dedicated;
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.FileOutputStream;
/*    */ import java.io.IOException;
/*    */ import java.util.Properties;
/*    */ 
/*    */ @SideOnly(Side.SERVER)
/*    */ public class PropertyManager {
/* 10 */   private static final Logger field_164440_a = LogManager.getLogger();
/* 11 */   private final Properties field_73672_b = new Properties(); private final File field_73673_c;
/*    */   private static final String __OBFID = "CL_00001782";
/*    */   
/*    */   public PropertyManager(File p_i45278_1_) {
/* 15 */     this.field_73673_c = p_i45278_1_;
/*    */     
/* 17 */     if (p_i45278_1_.exists()) {
/* 18 */       FileInputStream fileInputStream = null;
/*    */       try {
/* 20 */         fileInputStream = new FileInputStream(p_i45278_1_);
/* 21 */         this.field_73672_b.load(fileInputStream);
/* 22 */       } catch (Exception exception) {
/* 23 */         field_164440_a.warn("Failed to load " + p_i45278_1_, exception);
/* 24 */         func_73666_a();
/*    */       } finally {
/* 26 */         if (fileInputStream != null) {
/*    */           try {
/* 28 */             fileInputStream.close();
/* 29 */           } catch (IOException iOException) {}
/*    */         }
/*    */       } 
/*    */     } else {
/*    */       
/* 34 */       field_164440_a.warn(p_i45278_1_ + " does not exist");
/* 35 */       func_73666_a();
/*    */     } 
/*    */   }
/*    */   
/*    */   public void func_73666_a() {
/* 40 */     field_164440_a.info("Generating new properties file");
/* 41 */     func_73668_b();
/*    */   }
/*    */   
/*    */   public void func_73668_b() {
/* 45 */     FileOutputStream fileOutputStream = null;
/*    */     try {
/* 47 */       fileOutputStream = new FileOutputStream(this.field_73673_c);
/* 48 */       this.field_73672_b.store(fileOutputStream, "Minecraft server properties");
/* 49 */     } catch (Exception exception) {
/* 50 */       field_164440_a.warn("Failed to save " + this.field_73673_c, exception);
/* 51 */       func_73666_a();
/*    */     } finally {
/* 53 */       if (fileOutputStream != null) {
/*    */         try {
/* 55 */           fileOutputStream.close();
/* 56 */         } catch (IOException iOException) {}
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public File func_73665_c() {
/* 63 */     return this.field_73673_c;
/*    */   }
/*    */   
/*    */   public String func_73671_a(String p_73671_1_, String p_73671_2_) {
/* 67 */     if (!this.field_73672_b.containsKey(p_73671_1_)) {
/* 68 */       this.field_73672_b.setProperty(p_73671_1_, p_73671_2_);
/* 69 */       func_73668_b();
/* 70 */       func_73668_b();
/*    */     } 
/* 72 */     return this.field_73672_b.getProperty(p_73671_1_, p_73671_2_);
/*    */   }
/*    */   
/*    */   public int func_73669_a(String p_73669_1_, int p_73669_2_) {
/*    */     try {
/* 77 */       return Integer.parseInt(func_73671_a(p_73669_1_, "" + p_73669_2_));
/* 78 */     } catch (Exception exception) {
/* 79 */       this.field_73672_b.setProperty(p_73669_1_, "" + p_73669_2_);
/* 80 */       func_73668_b();
/* 81 */       return p_73669_2_;
/*    */     } 
/*    */   }
/*    */   
/*    */   public boolean func_73670_a(String p_73670_1_, boolean p_73670_2_) {
/*    */     try {
/* 87 */       return Boolean.parseBoolean(func_73671_a(p_73670_1_, "" + p_73670_2_));
/* 88 */     } catch (Exception exception) {
/* 89 */       this.field_73672_b.setProperty(p_73670_1_, "" + p_73670_2_);
/* 90 */       func_73668_b();
/* 91 */       return p_73670_2_;
/*    */     } 
/*    */   }
/*    */   
/*    */   public void func_73667_a(String p_73667_1_, Object p_73667_2_) {
/* 96 */     this.field_73672_b.setProperty(p_73667_1_, "" + p_73667_2_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\server\dedicated\PropertyManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */