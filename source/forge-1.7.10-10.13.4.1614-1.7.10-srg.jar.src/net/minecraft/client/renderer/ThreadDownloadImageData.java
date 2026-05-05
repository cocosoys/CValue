/*     */ package net.minecraft.client.renderer;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.net.HttpURLConnection;
/*     */ import java.net.URL;
/*     */ import java.util.concurrent.atomic.AtomicInteger;
/*     */ import javax.imageio.ImageIO;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.texture.SimpleTexture;
/*     */ import net.minecraft.client.renderer.texture.TextureUtil;
/*     */ import net.minecraft.client.resources.IResourceManager;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.apache.commons.io.FileUtils;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class ThreadDownloadImageData
/*     */   extends SimpleTexture {
/*  24 */   private static final Logger field_147644_c = LogManager.getLogger();
/*  25 */   private static final AtomicInteger field_147643_d = new AtomicInteger(0);
/*     */   
/*     */   private final File field_152434_e;
/*     */   private final String field_110562_b;
/*     */   private final IImageBuffer field_110563_c;
/*     */   private BufferedImage field_110560_d;
/*     */   private Thread field_110561_e;
/*     */   private boolean field_110559_g;
/*     */   private static final String __OBFID = "CL_00001049";
/*     */   
/*     */   public ThreadDownloadImageData(File p_i1049_1_, String p_i1049_2_, ResourceLocation p_i1049_3_, IImageBuffer p_i1049_4_) {
/*  36 */     super(p_i1049_3_);
/*  37 */     this.field_152434_e = p_i1049_1_;
/*  38 */     this.field_110562_b = p_i1049_2_;
/*  39 */     this.field_110563_c = p_i1049_4_;
/*     */   }
/*     */   
/*     */   private void func_147640_e() {
/*  43 */     if (this.field_110559_g) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/*  48 */     if (this.field_110560_d != null) {
/*     */       
/*  50 */       if (this.field_110568_b != null) {
/*  51 */         func_147631_c();
/*     */       }
/*     */       
/*  54 */       TextureUtil.func_110987_a(super.func_110552_b(), this.field_110560_d);
/*  55 */       this.field_110559_g = true;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_110552_b() {
/*  61 */     func_147640_e();
/*     */     
/*  63 */     return super.func_110552_b();
/*     */   }
/*     */   
/*     */   public void func_147641_a(BufferedImage p_147641_1_) {
/*  67 */     this.field_110560_d = p_147641_1_;
/*  68 */     if (this.field_110563_c != null) {
/*  69 */       this.field_110563_c.func_152634_a();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_110551_a(IResourceManager p_110551_1_) throws IOException {
/*  76 */     if (this.field_110560_d == null && this.field_110568_b != null) {
/*  77 */       super.func_110551_a(p_110551_1_);
/*     */     }
/*     */ 
/*     */     
/*  81 */     if (this.field_110561_e == null) {
/*  82 */       if (this.field_152434_e != null && this.field_152434_e.isFile()) {
/*  83 */         field_147644_c.debug("Loading http texture from local cache ({})", new Object[] { this.field_152434_e });
/*     */         try {
/*  85 */           this.field_110560_d = ImageIO.read(this.field_152434_e);
/*  86 */           if (this.field_110563_c != null) {
/*  87 */             func_147641_a(this.field_110563_c.func_78432_a(this.field_110560_d));
/*     */           }
/*  89 */         } catch (IOException iOException) {
/*  90 */           field_147644_c.error("Couldn't load skin " + this.field_152434_e, iOException);
/*  91 */           func_152433_a();
/*     */         } 
/*     */       } else {
/*  94 */         func_152433_a();
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   protected void func_152433_a() {
/* 100 */     this.field_110561_e = new Thread(this, "Texture Downloader #" + field_147643_d.incrementAndGet())
/*     */       {
/*     */         public void run() {
/* 103 */           HttpURLConnection httpURLConnection = null;
/* 104 */           ThreadDownloadImageData.field_147644_c.debug("Downloading http texture from {} to {}", new Object[] { ThreadDownloadImageData.access$000(this.field_110932_a), ThreadDownloadImageData.access$100(this.field_110932_a) }); try {
/*     */             BufferedImage bufferedImage;
/* 106 */             httpURLConnection = (HttpURLConnection)(new URL(this.field_110932_a.field_110562_b)).openConnection(Minecraft.func_71410_x().func_110437_J());
/* 107 */             httpURLConnection.setDoInput(true);
/* 108 */             httpURLConnection.setDoOutput(false);
/* 109 */             httpURLConnection.connect();
/*     */             
/* 111 */             if (httpURLConnection.getResponseCode() / 100 != 2) {
/*     */               return;
/*     */             }
/*     */ 
/*     */ 
/*     */             
/* 117 */             if (this.field_110932_a.field_152434_e != null) {
/* 118 */               FileUtils.copyInputStreamToFile(httpURLConnection.getInputStream(), this.field_110932_a.field_152434_e);
/* 119 */               bufferedImage = ImageIO.read(this.field_110932_a.field_152434_e);
/*     */             } else {
/* 121 */               bufferedImage = ImageIO.read(httpURLConnection.getInputStream());
/*     */             } 
/*     */             
/* 124 */             if (this.field_110932_a.field_110563_c != null) {
/* 125 */               bufferedImage = this.field_110932_a.field_110563_c.func_78432_a(bufferedImage);
/*     */             }
/*     */             
/* 128 */             this.field_110932_a.func_147641_a(bufferedImage);
/* 129 */           } catch (Exception exception) {
/* 130 */             ThreadDownloadImageData.field_147644_c.error("Couldn't download http texture", exception);
/*     */           } finally {
/* 132 */             if (httpURLConnection != null)
/* 133 */               httpURLConnection.disconnect(); 
/*     */           } 
/*     */         }
/*     */         private static final String __OBFID = "CL_00001050";
/*     */       };
/* 138 */     this.field_110561_e.setDaemon(true);
/* 139 */     this.field_110561_e.start();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\ThreadDownloadImageData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */