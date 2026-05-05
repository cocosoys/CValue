/*     */ package JinRyuu.JRMCore;
/*     */ 
/*     */ import com.google.common.collect.Lists;
/*     */ import java.util.ArrayList;
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
/*     */ public class JRMCoreMsnBundle
/*     */ {
/*  21 */   public ArrayList<JRMCoreMsn> missions = Lists.newArrayList();
/*  22 */   public Stngs settings = new Stngs();
/*     */   
/*     */   public String mods;
/*     */   
/*     */   public String version;
/*     */   public String authors;
/*     */   public String desc;
/*     */   public String name;
/*     */   
/*     */   public String getName() {
/*  32 */     return this.name;
/*     */   }
/*     */   public void setName(String name) {
/*  35 */     this.name = name;
/*     */   }
/*     */   public String getDesc() {
/*  38 */     return this.desc;
/*     */   }
/*     */   public void setDesc(String desc) {
/*  41 */     this.desc = desc;
/*     */   }
/*     */   public ArrayList<JRMCoreMsn> getMissions() {
/*  44 */     return this.missions;
/*     */   }
/*     */   public void setMissions(ArrayList<JRMCoreMsn> data) {
/*  47 */     this.missions = data;
/*     */   }
/*     */   public String getVersion() {
/*  50 */     return this.version;
/*     */   }
/*     */   
/*     */   public void setVersion(String version) {
/*  54 */     this.version = version;
/*     */   }
/*     */   public String getMods() {
/*  57 */     return this.mods;
/*     */   }
/*     */   public void setMods(String mods) {
/*  60 */     this.mods = mods;
/*     */   }
/*     */   
/*     */   public String getAuthor() {
/*  64 */     return this.authors;
/*     */   }
/*     */   
/*     */   public void setAuthor(String author) {
/*  68 */     this.authors = author;
/*     */   }
/*     */ 
/*     */   
/*     */   public Stngs getSettings() {
/*  73 */     return this.settings;
/*     */   }
/*     */   
/*     */   public void setSettings(Stngs settings) {
/*  77 */     this.settings = settings;
/*     */   }
/*     */ 
/*     */   
/*     */   public class Stngs
/*     */   {
/*     */     public String repeat;
/*     */     
/*     */     public String unlock;
/*     */     public String vars;
/*     */     
/*     */     public String getRepeat() {
/*  89 */       return this.repeat;
/*     */     }
/*     */     
/*     */     public void setRepeat(String repeat) {
/*  93 */       this.repeat = repeat;
/*     */     }
/*     */     
/*     */     public String getUnlock() {
/*  97 */       return this.unlock;
/*     */     }
/*     */     
/*     */     public void setUnlock(String unlock) {
/* 101 */       this.unlock = unlock;
/*     */     }
/*     */     
/*     */     public String getVars() {
/* 105 */       return this.vars;
/*     */     }
/*     */     
/*     */     public void setVars(String vars) {
/* 109 */       this.vars = vars;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCoreMsnBundle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */