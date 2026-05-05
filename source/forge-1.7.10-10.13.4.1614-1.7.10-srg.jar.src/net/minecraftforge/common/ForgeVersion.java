/*     */ package net.minecraftforge.common;
/*     */ 
/*     */ import com.google.common.io.ByteStreams;
/*     */ import com.google.gson.Gson;
/*     */ import cpw.mods.fml.common.versioning.DefaultArtifactVersion;
/*     */ import java.io.InputStream;
/*     */ import java.net.URL;
/*     */ import java.util.Map;
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
/*     */ public class ForgeVersion
/*     */ {
/*     */   public static final int majorVersion = 10;
/*     */   public static final int minorVersion = 13;
/*     */   public static final int revisionVersion = 4;
/*     */   public static final int buildVersion = 1614;
/*  30 */   private static Status status = Status.PENDING;
/*  31 */   private static String target = null;
/*     */ 
/*     */   
/*     */   public static int getMajorVersion() {
/*  35 */     return 10;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getMinorVersion() {
/*  40 */     return 13;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getRevisionVersion() {
/*  45 */     return 4;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getBuildVersion() {
/*  50 */     return 1614;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Status getStatus() {
/*  55 */     return status;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getTarget() {
/*  60 */     return target;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getVersion() {
/*  65 */     return String.format("%d.%d.%d.%d", new Object[] { Integer.valueOf(10), Integer.valueOf(13), Integer.valueOf(4), Integer.valueOf(1614) });
/*     */   }
/*     */   
/*     */   public enum Status
/*     */   {
/*  70 */     PENDING,
/*  71 */     FAILED,
/*  72 */     UP_TO_DATE,
/*  73 */     OUTDATED,
/*  74 */     AHEAD,
/*  75 */     BETA,
/*  76 */     BETA_OUTDATED;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void startVersionCheck() {
/*  81 */     (new Thread("Forge Version Check")
/*     */       {
/*     */ 
/*     */ 
/*     */         
/*     */         public void run()
/*     */         {
/*     */           try {
/*  89 */             URL url = new URL("http://files.minecraftforge.net/maven/net/minecraftforge/forge/promotions_slim.json");
/*  90 */             InputStream con = url.openStream();
/*  91 */             String data = new String(ByteStreams.toByteArray(con));
/*  92 */             con.close();
/*     */             
/*  94 */             Map<String, Object> json = (Map<String, Object>)(new Gson()).fromJson(data, Map.class);
/*     */             
/*  96 */             Map<String, String> promos = (Map<String, String>)json.get("promos");
/*     */             
/*  98 */             String rec = promos.get("1.7.10-recommended");
/*  99 */             String lat = promos.get("1.7.10-latest");
/* 100 */             DefaultArtifactVersion defaultArtifactVersion = new DefaultArtifactVersion(ForgeVersion.getVersion());
/*     */             
/* 102 */             if (rec != null) {
/*     */               
/* 104 */               DefaultArtifactVersion defaultArtifactVersion1 = new DefaultArtifactVersion(rec);
/* 105 */               int diff = defaultArtifactVersion1.compareTo(defaultArtifactVersion);
/*     */               
/* 107 */               if (diff == 0) {
/* 108 */                 ForgeVersion.status = ForgeVersion.Status.UP_TO_DATE;
/* 109 */               } else if (diff < 0) {
/*     */                 
/* 111 */                 ForgeVersion.status = ForgeVersion.Status.AHEAD;
/* 112 */                 if (lat != null)
/*     */                 {
/* 114 */                   if (defaultArtifactVersion.compareTo(new DefaultArtifactVersion(lat)) < 0)
/*     */                   {
/* 116 */                     ForgeVersion.status = ForgeVersion.Status.OUTDATED;
/* 117 */                     ForgeVersion.target = lat;
/*     */                   }
/*     */                 
/*     */                 }
/*     */               } else {
/*     */                 
/* 123 */                 ForgeVersion.status = ForgeVersion.Status.OUTDATED;
/* 124 */                 ForgeVersion.target = rec;
/*     */               }
/*     */             
/* 127 */             } else if (lat != null) {
/*     */               
/* 129 */               if (defaultArtifactVersion.compareTo(new DefaultArtifactVersion(lat)) < 0) {
/*     */                 
/* 131 */                 ForgeVersion.status = ForgeVersion.Status.BETA_OUTDATED;
/* 132 */                 ForgeVersion.target = lat;
/*     */               } else {
/*     */                 
/* 135 */                 ForgeVersion.status = ForgeVersion.Status.BETA;
/*     */               } 
/*     */             } else {
/* 138 */               ForgeVersion.status = ForgeVersion.Status.BETA;
/*     */             } 
/* 140 */           } catch (Exception e) {
/*     */             
/* 142 */             e.printStackTrace();
/* 143 */             ForgeVersion.status = ForgeVersion.Status.FAILED;
/*     */           } 
/*     */         }
/* 146 */       }).start();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\common\ForgeVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */