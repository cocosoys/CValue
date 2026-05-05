/*     */ package net.minecraft.scoreboard;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Collection;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ScorePlayerTeam
/*     */   extends Team
/*     */ {
/*     */   private final Scoreboard field_96677_a;
/*     */   private final String field_96675_b;
/*  16 */   private final Set field_96676_c = new HashSet();
/*     */   private String field_96673_d;
/*  18 */   private String field_96674_e = "";
/*  19 */   private String field_96671_f = "";
/*     */   
/*     */   private boolean field_96672_g = true;
/*     */   
/*     */   public ScorePlayerTeam(Scoreboard p_i2308_1_, String p_i2308_2_) {
/*  24 */     this.field_96677_a = p_i2308_1_;
/*  25 */     this.field_96675_b = p_i2308_2_;
/*  26 */     this.field_96673_d = p_i2308_2_;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean field_98301_h = true;
/*     */   
/*     */   private static final String __OBFID = "CL_00000616";
/*     */   
/*     */   public String func_96661_b() {
/*  35 */     return this.field_96675_b;
/*     */   }
/*     */   
/*     */   public String func_96669_c() {
/*  39 */     return this.field_96673_d;
/*     */   }
/*     */   
/*     */   public void func_96664_a(String p_96664_1_) {
/*  43 */     if (p_96664_1_ == null) throw new IllegalArgumentException("Name cannot be null"); 
/*  44 */     this.field_96673_d = p_96664_1_;
/*  45 */     this.field_96677_a.func_96538_b(this);
/*     */   }
/*     */   
/*     */   public Collection func_96670_d() {
/*  49 */     return this.field_96676_c;
/*     */   }
/*     */   
/*     */   public String func_96668_e() {
/*  53 */     return this.field_96674_e;
/*     */   }
/*     */   
/*     */   public void func_96666_b(String p_96666_1_) {
/*  57 */     if (p_96666_1_ == null) throw new IllegalArgumentException("Prefix cannot be null"); 
/*  58 */     this.field_96674_e = p_96666_1_;
/*  59 */     this.field_96677_a.func_96538_b(this);
/*     */   }
/*     */   
/*     */   public String func_96663_f() {
/*  63 */     return this.field_96671_f;
/*     */   }
/*     */   
/*     */   public void func_96662_c(String p_96662_1_) {
/*  67 */     if (p_96662_1_ == null) throw new IllegalArgumentException("Suffix cannot be null"); 
/*  68 */     this.field_96671_f = p_96662_1_;
/*  69 */     this.field_96677_a.func_96538_b(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_142053_d(String p_142053_1_) {
/*  74 */     return func_96668_e() + p_142053_1_ + func_96663_f();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String func_96667_a(Team p_96667_0_, String p_96667_1_) {
/*  82 */     if (p_96667_0_ == null) return p_96667_1_; 
/*  83 */     return p_96667_0_.func_142053_d(p_96667_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_96665_g() {
/*  88 */     return this.field_96672_g;
/*     */   }
/*     */   
/*     */   public void func_96660_a(boolean p_96660_1_) {
/*  92 */     this.field_96672_g = p_96660_1_;
/*  93 */     this.field_96677_a.func_96538_b(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_98297_h() {
/*  98 */     return this.field_98301_h;
/*     */   }
/*     */   
/*     */   public void func_98300_b(boolean p_98300_1_) {
/* 102 */     this.field_98301_h = p_98300_1_;
/* 103 */     this.field_96677_a.func_96538_b(this);
/*     */   }
/*     */   
/*     */   public int func_98299_i() {
/* 107 */     int i = 0;
/*     */     
/* 109 */     if (func_96665_g()) i |= 0x1; 
/* 110 */     if (func_98297_h()) i |= 0x2;
/*     */     
/* 112 */     return i;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_98298_a(int p_98298_1_) {
/* 116 */     func_96660_a(((p_98298_1_ & 0x1) > 0));
/* 117 */     func_98300_b(((p_98298_1_ & 0x2) > 0));
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\scoreboard\ScorePlayerTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */