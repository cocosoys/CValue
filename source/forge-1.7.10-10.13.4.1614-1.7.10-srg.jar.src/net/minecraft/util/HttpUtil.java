/*     */ package net.minecraft.util;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.DataOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.net.HttpURLConnection;
/*     */ import java.net.Proxy;
/*     */ import java.net.ServerSocket;
/*     */ import java.net.URL;
/*     */ import java.net.URLConnection;
/*     */ import java.util.Map;
/*     */ 
/*     */ public class HttpUtil {
/*  16 */   private static final AtomicInteger field_151228_a = new AtomicInteger(0);
/*  17 */   private static final Logger field_151227_b = LogManager.getLogger();
/*     */   
/*     */   private static final String __OBFID = "CL_00001485";
/*     */   
/*     */   public static String func_76179_a(Map p_76179_0_) {
/*  22 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/*  24 */     for (Map.Entry entry : p_76179_0_.entrySet()) {
/*  25 */       if (stringBuilder.length() > 0) {
/*  26 */         stringBuilder.append('&');
/*     */       }
/*     */       
/*     */       try {
/*  30 */         stringBuilder.append(URLEncoder.encode((String)entry.getKey(), "UTF-8"));
/*  31 */       } catch (UnsupportedEncodingException unsupportedEncodingException) {
/*  32 */         unsupportedEncodingException.printStackTrace();
/*     */       } 
/*     */       
/*  35 */       if (entry.getValue() != null) {
/*  36 */         stringBuilder.append('=');
/*     */         try {
/*  38 */           stringBuilder.append(URLEncoder.encode(entry.getValue().toString(), "UTF-8"));
/*  39 */         } catch (UnsupportedEncodingException unsupportedEncodingException) {
/*  40 */           unsupportedEncodingException.printStackTrace();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  45 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public static String func_151226_a(URL p_151226_0_, Map p_151226_1_, boolean p_151226_2_) {
/*  49 */     return func_151225_a(p_151226_0_, func_76179_a(p_151226_1_), p_151226_2_);
/*     */   }
/*     */   
/*     */   private static String func_151225_a(URL p_151225_0_, String p_151225_1_, boolean p_151225_2_) {
/*     */     try {
/*  54 */       Proxy proxy = (MinecraftServer.func_71276_C() == null) ? null : MinecraftServer.func_71276_C().func_110454_ao();
/*  55 */       if (proxy == null) proxy = Proxy.NO_PROXY; 
/*  56 */       HttpURLConnection httpURLConnection = (HttpURLConnection)p_151225_0_.openConnection(proxy);
/*  57 */       httpURLConnection.setRequestMethod("POST");
/*  58 */       httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
/*     */       
/*  60 */       httpURLConnection.setRequestProperty("Content-Length", "" + (p_151225_1_.getBytes()).length);
/*  61 */       httpURLConnection.setRequestProperty("Content-Language", "en-US");
/*     */       
/*  63 */       httpURLConnection.setUseCaches(false);
/*  64 */       httpURLConnection.setDoInput(true);
/*  65 */       httpURLConnection.setDoOutput(true);
/*     */ 
/*     */       
/*  68 */       DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
/*  69 */       dataOutputStream.writeBytes(p_151225_1_);
/*  70 */       dataOutputStream.flush();
/*  71 */       dataOutputStream.close();
/*     */ 
/*     */       
/*  74 */       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
/*     */       
/*  76 */       StringBuffer stringBuffer = new StringBuffer();
/*     */       String str;
/*  78 */       while ((str = bufferedReader.readLine()) != null) {
/*  79 */         stringBuffer.append(str);
/*  80 */         stringBuffer.append('\r');
/*     */       } 
/*     */       
/*  83 */       bufferedReader.close();
/*  84 */       return stringBuffer.toString();
/*  85 */     } catch (Exception exception) {
/*  86 */       if (!p_151225_2_) {
/*  87 */         field_151227_b.error("Could not post to " + p_151225_0_, exception);
/*     */       }
/*  89 */       return "";
/*     */     } 
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static void func_151223_a(File p_151223_0_, String p_151223_1_, DownloadListener p_151223_2_, Map p_151223_3_, int p_151223_4_, IProgressUpdate p_151223_5_, Proxy p_151223_6_) {
/*  94 */     Thread thread = new Thread(new Runnable(p_151223_5_, p_151223_1_, p_151223_6_, p_151223_3_, p_151223_0_, p_151223_2_, p_151223_4_) { private static final String __OBFID = "CL_00001486";
/*     */           
/*     */           public void run() {
/*  97 */             URLConnection uRLConnection = null;
/*  98 */             InputStream inputStream = null;
/*  99 */             OutputStream outputStream = null;
/*     */             
/* 101 */             if (this.field_151199_a != null) {
/* 102 */               this.field_151199_a.func_73721_b("Downloading Texture Pack");
/* 103 */               this.field_151199_a.func_73719_c("Making Request...");
/*     */             } 
/*     */             
/*     */             try {
/* 107 */               byte[] arrayOfByte = new byte[4096];
/* 108 */               URL uRL = new URL(this.field_151197_b);
/* 109 */               uRLConnection = uRL.openConnection(this.field_151198_c);
/* 110 */               float f1 = 0.0F;
/* 111 */               float f2 = this.field_151195_d.entrySet().size();
/*     */               
/* 113 */               for (Map.Entry entry : this.field_151195_d.entrySet()) {
/* 114 */                 uRLConnection.setRequestProperty((String)entry.getKey(), (String)entry.getValue());
/* 115 */                 if (this.field_151199_a != null) this.field_151199_a.func_73718_a((int)(++f1 / f2 * 100.0F));
/*     */               
/*     */               } 
/* 118 */               inputStream = uRLConnection.getInputStream();
/* 119 */               f2 = uRLConnection.getContentLength();
/* 120 */               int i = uRLConnection.getContentLength();
/*     */               
/* 122 */               if (this.field_151199_a != null) {
/* 123 */                 this.field_151199_a.func_73719_c(String.format("Downloading file (%.2f MB)...", new Object[] { Float.valueOf(f2 / 1000.0F / 1000.0F) }));
/*     */               }
/*     */               
/* 126 */               if (this.field_151196_e.exists()) {
/* 127 */                 long l = this.field_151196_e.length();
/*     */                 
/* 129 */                 if (l == i) {
/* 130 */                   this.field_151193_f.func_148522_a(this.field_151196_e);
/* 131 */                   if (this.field_151199_a != null) this.field_151199_a.func_146586_a(); 
/*     */                   return;
/*     */                 } 
/* 134 */                 HttpUtil.field_151227_b.warn("Deleting " + this.field_151196_e + " as it does not match what we currently have (" + i + " vs our " + l + ").");
/* 135 */                 this.field_151196_e.delete();
/*     */               }
/* 137 */               else if (this.field_151196_e.getParentFile() != null) {
/* 138 */                 this.field_151196_e.getParentFile().mkdirs();
/*     */               } 
/*     */               
/* 141 */               outputStream = new DataOutputStream(new FileOutputStream(this.field_151196_e));
/*     */               
/* 143 */               if (this.field_151194_g > 0 && f2 > this.field_151194_g) {
/* 144 */                 if (this.field_151199_a != null) this.field_151199_a.func_146586_a(); 
/* 145 */                 throw new IOException("Filesize is bigger than maximum allowed (file is " + f1 + ", limit is " + this.field_151194_g + ")");
/*     */               } 
/*     */               
/* 148 */               int j = 0;
/* 149 */               while ((j = inputStream.read(arrayOfByte)) >= 0) {
/* 150 */                 f1 += j;
/* 151 */                 if (this.field_151199_a != null) this.field_151199_a.func_73718_a((int)(f1 / f2 * 100.0F));
/*     */                 
/* 153 */                 if (this.field_151194_g > 0 && f1 > this.field_151194_g) {
/* 154 */                   if (this.field_151199_a != null) this.field_151199_a.func_146586_a(); 
/* 155 */                   throw new IOException("Filesize was bigger than maximum allowed (got >= " + f1 + ", limit was " + this.field_151194_g + ")");
/*     */                 } 
/*     */                 
/* 158 */                 outputStream.write(arrayOfByte, 0, j);
/*     */               } 
/*     */               
/* 161 */               this.field_151193_f.func_148522_a(this.field_151196_e);
/* 162 */               if (this.field_151199_a != null) this.field_151199_a.func_146586_a(); 
/* 163 */             } catch (Throwable throwable) {
/* 164 */               throwable.printStackTrace();
/*     */             } finally {
/*     */               try {
/* 167 */                 if (inputStream != null) inputStream.close(); 
/* 168 */               } catch (IOException iOException) {}
/*     */               try {
/* 170 */                 if (outputStream != null) outputStream.close(); 
/* 171 */               } catch (IOException iOException) {}
/*     */             } 
/*     */           } }
/*     */         "File Downloader #" + field_151228_a.incrementAndGet());
/*     */     
/* 176 */     thread.setDaemon(true);
/* 177 */     thread.start();
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static int func_76181_a() throws IOException {
/* 181 */     ServerSocket serverSocket = null;
/* 182 */     int i = -1;
/*     */     
/*     */     try {
/* 185 */       serverSocket = new ServerSocket(0);
/* 186 */       i = serverSocket.getLocalPort();
/*     */     } finally {
/*     */       try {
/* 189 */         if (serverSocket != null) {
/* 190 */           serverSocket.close();
/*     */         }
/* 192 */       } catch (IOException iOException) {}
/*     */     } 
/*     */ 
/*     */     
/* 196 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static String func_152755_a(URL p_152755_0_) throws IOException {
/* 230 */     HttpURLConnection httpURLConnection = (HttpURLConnection)p_152755_0_.openConnection();
/* 231 */     httpURLConnection.setRequestMethod("GET");
/*     */ 
/*     */     
/* 234 */     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
/*     */     
/* 236 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     String str;
/* 238 */     while ((str = bufferedReader.readLine()) != null) {
/* 239 */       stringBuilder.append(str);
/* 240 */       stringBuilder.append('\r');
/*     */     } 
/*     */     
/* 243 */     bufferedReader.close();
/* 244 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static interface DownloadListener {
/*     */     void func_148522_a(File param1File);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\HttpUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */