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
/*     */ 
/*     */ public class JRMCoreMsn
/*     */ {
/*  22 */   private ArrayList<String> title = Lists.newArrayList();
/*  23 */   private ArrayList<String> subtitle = Lists.newArrayList();
/*  24 */   private ArrayList<String> description = Lists.newArrayList();
/*  25 */   private ArrayList<String> align = Lists.newArrayList();
/*  26 */   private ArrayList<String> props = Lists.newArrayList();
/*     */   
/*  28 */   private ArrayList<ArrayList<String>> objectives = Lists.newArrayList();
/*  29 */   private ArrayList<ArrayList<String>> rewards = Lists.newArrayList(); private int id;
/*     */   
/*     */   public int getProp(int p, int r, int c) {
/*     */     int i;
/*  33 */     switch (p) {
/*     */       case 1:
/*  35 */         r = (r == 2) ? 1 : r;
/*  36 */         for (i = 0; i < this.props.size(); i++) {
/*  37 */           if (((String)this.props.get(i)).equalsIgnoreCase(JRMCoreH.Races[r]) || ((String)this.props.get(i)).equalsIgnoreCase(JRMCoreH.ClassesDBC[c])) {
/*  38 */             return i;
/*     */           }
/*     */         } 
/*  41 */         return 0;
/*     */       case 2:
/*  43 */         for (i = 0; i < this.props.size(); i++) {
/*  44 */           if (((String)this.props.get(i)).equalsIgnoreCase(JRMCoreH.Races[r]) || ((String)this.props.get(i)).equalsIgnoreCase(JRMCoreH.ClassesDBC[c])) {
/*  45 */             return i;
/*     */           }
/*     */         } 
/*  48 */         return 0;
/*     */       case 3:
/*  50 */         return 0;
/*  51 */     }  return 0;
/*     */   }
/*     */   private boolean translated;
/*     */   
/*     */   public String getTitle(int p, int r, int c) {
/*  56 */     return this.title.get(getProp(p, r, c));
/*     */   }
/*     */   public String getSubtitle(int p, int r, int c) {
/*  59 */     return this.subtitle.get(getProp(p, r, c));
/*     */   }
/*     */   public String getDescription(int p, int r, int c) {
/*  62 */     return this.description.get(getProp(p, r, c));
/*     */   }
/*     */   public String getAlign(int p, int r, int c) {
/*  65 */     return this.align.get(getProp(p, r, c));
/*     */   }
/*     */   public ArrayList<String> getObjectives(int p, int r, int c) {
/*  68 */     return this.objectives.get(getProp(p, r, c));
/*     */   }
/*     */   public ArrayList<String> getRewards(int p, int r, int c) {
/*  71 */     return this.rewards.get(getProp(p, r, c));
/*     */   }
/*     */   
/*     */   public int getObjectivesSize(int p, int r, int c) {
/*  75 */     return ((ArrayList)this.objectives.get(getProp(p, r, c))).size();
/*     */   }
/*     */   public int getRewardsSize(int p, int r, int c) {
/*  78 */     return ((ArrayList)this.rewards.get(getProp(p, r, c))).size();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getId() {
/*  84 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(int id) {
/*  88 */     this.id = id;
/*     */   }
/*     */   
/*     */   public boolean isTranslated() {
/*  92 */     return this.translated;
/*     */   }
/*     */   
/*     */   public void setTranslated(boolean translated) {
/*  96 */     this.translated = translated;
/*     */   }
/*     */   
/*     */   public ArrayList<String> getTitle() {
/* 100 */     return this.title;
/*     */   }
/*     */   
/*     */   public void setTitle(ArrayList<String> title) {
/* 104 */     this.title = title;
/*     */   }
/*     */   
/*     */   public ArrayList<String> getSubtitle() {
/* 108 */     return this.subtitle;
/*     */   }
/*     */   
/*     */   public void setSubtitle(ArrayList<String> subtitle) {
/* 112 */     this.subtitle = subtitle;
/*     */   }
/*     */   
/*     */   public ArrayList<String> getDescription() {
/* 116 */     return this.description;
/*     */   }
/*     */   public void setDescription(ArrayList<String> description) {
/* 119 */     this.description = description;
/*     */   }
/*     */   
/*     */   public ArrayList<String> getAlign() {
/* 123 */     return this.align;
/*     */   }
/*     */   
/*     */   public void setAlign(ArrayList<String> align) {
/* 127 */     this.align = align;
/*     */   }
/*     */   
/*     */   public ArrayList<String> getProps() {
/* 131 */     return this.props;
/*     */   }
/*     */   
/*     */   public void setProps(ArrayList<String> props) {
/* 135 */     this.props = props;
/*     */   }
/*     */   
/*     */   public ArrayList<ArrayList<String>> getObjectives() {
/* 139 */     return this.objectives;
/*     */   }
/*     */   public void setObjectives(ArrayList<ArrayList<String>> objectives) {
/* 142 */     this.objectives = objectives;
/*     */   }
/*     */   
/*     */   public ArrayList<ArrayList<String>> getRewards() {
/* 146 */     return this.rewards;
/*     */   }
/*     */   
/*     */   public void setRewards(ArrayList<ArrayList<String>> rewards) {
/* 150 */     this.rewards = rewards;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCoreMsn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */