/*     */ package net.minecraft.stats;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.text.DecimalFormat;
/*     */ import java.text.NumberFormat;
/*     */ import java.util.Locale;
/*     */ import net.minecraft.event.HoverEvent;
/*     */ import net.minecraft.scoreboard.IScoreObjectiveCriteria;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ 
/*     */ public class StatBase {
/*     */   public final String field_75975_e;
/*     */   private final IChatComponent field_75978_a;
/*     */   public boolean field_75972_f;
/*     */   private final IStatType field_75976_b;
/*     */   private final IScoreObjectiveCriteria field_150957_c;
/*     */   private Class field_150956_d;
/*     */   
/*     */   public StatBase(String p_i45307_1_, IChatComponent p_i45307_2_, IStatType p_i45307_3_) {
/*  23 */     this.field_75975_e = p_i45307_1_;
/*  24 */     this.field_75978_a = p_i45307_2_;
/*  25 */     this.field_75976_b = p_i45307_3_;
/*  26 */     this.field_150957_c = (IScoreObjectiveCriteria)new ObjectiveStat(this);
/*     */     
/*  28 */     IScoreObjectiveCriteria.field_96643_a.put(this.field_150957_c.func_96636_a(), this.field_150957_c);
/*     */   }
/*     */   
/*     */   public StatBase(String p_i45308_1_, IChatComponent p_i45308_2_) {
/*  32 */     this(p_i45308_1_, p_i45308_2_, field_75980_h);
/*     */   }
/*     */   
/*     */   public StatBase func_75966_h() {
/*  36 */     this.field_75972_f = true;
/*  37 */     return this;
/*     */   }
/*     */   
/*     */   public StatBase func_75971_g() {
/*  41 */     if (StatList.field_75942_a.containsKey(this.field_75975_e)) {
/*  42 */       throw new RuntimeException("Duplicate stat id: \"" + ((StatBase)StatList.field_75942_a.get(this.field_75975_e)).field_75978_a + "\" and \"" + this.field_75978_a + "\" at id " + this.field_75975_e);
/*     */     }
/*  44 */     StatList.field_75940_b.add(this);
/*  45 */     StatList.field_75942_a.put(this.field_75975_e, this);
/*     */     
/*  47 */     return this;
/*     */   }
/*     */   
/*     */   public boolean func_75967_d() {
/*  51 */     return false;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String func_75968_a(int p_75968_1_) {
/*  55 */     return this.field_75976_b.func_75843_a(p_75968_1_);
/*     */   }
/*     */   
/*  58 */   private static NumberFormat field_75977_c = NumberFormat.getIntegerInstance(Locale.US);
/*  59 */   public static IStatType field_75980_h = new IStatType() {
/*     */       @SideOnly(Side.CLIENT)
/*     */       public String func_75843_a(int p_75843_1_) {
/*  62 */         return StatBase.field_75977_c.format(p_75843_1_);
/*     */       }
/*     */       private static final String __OBFID = "CL_00001473";
/*     */     };
/*  66 */   private static DecimalFormat field_75974_d = new DecimalFormat("########0.00");
/*  67 */   public static IStatType field_75981_i = new IStatType() { private static final String __OBFID = "CL_00001474";
/*     */       
/*     */       @SideOnly(Side.CLIENT)
/*     */       public String func_75843_a(int p_75843_1_) {
/*  71 */         double d1 = p_75843_1_ / 20.0D;
/*  72 */         double d2 = d1 / 60.0D;
/*  73 */         double d3 = d2 / 60.0D;
/*  74 */         double d4 = d3 / 24.0D;
/*  75 */         double d5 = d4 / 365.0D;
/*     */         
/*  77 */         if (d5 > 0.5D)
/*  78 */           return StatBase.field_75974_d.format(d5) + " y"; 
/*  79 */         if (d4 > 0.5D)
/*  80 */           return StatBase.field_75974_d.format(d4) + " d"; 
/*  81 */         if (d3 > 0.5D)
/*  82 */           return StatBase.field_75974_d.format(d3) + " h"; 
/*  83 */         if (d2 > 0.5D) {
/*  84 */           return StatBase.field_75974_d.format(d2) + " m";
/*     */         }
/*  86 */         return d1 + " s";
/*     */       } }
/*     */   ;
/*     */   
/*  90 */   public static IStatType field_75979_j = new IStatType() { private static final String __OBFID = "CL_00001475";
/*     */       @SideOnly(Side.CLIENT)
/*     */       public String func_75843_a(int p_75843_1_) {
/*  93 */         double d1 = p_75843_1_ / 100.0D;
/*  94 */         double d2 = d1 / 1000.0D;
/*     */         
/*  96 */         if (d2 > 0.5D) {
/*  97 */           return StatBase.field_75974_d.format(d2) + " km";
/*     */         }
/*  99 */         if (d1 > 0.5D) {
/* 100 */           return StatBase.field_75974_d.format(d1) + " m";
/*     */         }
/* 102 */         return p_75843_1_ + " cm";
/*     */       } }
/*     */   ;
/*     */   
/* 106 */   public static IStatType field_111202_k = new IStatType() { private static final String __OBFID = "CL_00001476";
/*     */       @SideOnly(Side.CLIENT)
/*     */       public String func_75843_a(int p_75843_1_) {
/* 109 */         return StatBase.field_75974_d.format(p_75843_1_ * 0.1D);
/*     */       } }
/*     */   ; private static final String __OBFID = "CL_00001472";
/*     */   
/*     */   public IChatComponent func_150951_e() {
/* 114 */     IChatComponent iChatComponent = this.field_75978_a.func_150259_f();
/* 115 */     iChatComponent.func_150256_b().func_150238_a(EnumChatFormatting.GRAY);
/* 116 */     iChatComponent.func_150256_b().func_150209_a(new HoverEvent(HoverEvent.Action.SHOW_ACHIEVEMENT, (IChatComponent)new ChatComponentText(this.field_75975_e)));
/* 117 */     return iChatComponent;
/*     */   }
/*     */   
/*     */   public IChatComponent func_150955_j() {
/* 121 */     IChatComponent iChatComponent1 = func_150951_e();
/* 122 */     IChatComponent iChatComponent2 = (new ChatComponentText("[")).func_150257_a(iChatComponent1).func_150258_a("]");
/* 123 */     iChatComponent2.func_150255_a(iChatComponent1.func_150256_b());
/* 124 */     return iChatComponent2;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object p_equals_1_) {
/* 129 */     if (this == p_equals_1_) return true; 
/* 130 */     if (p_equals_1_ == null || getClass() != p_equals_1_.getClass()) return false;
/*     */     
/* 132 */     StatBase statBase = (StatBase)p_equals_1_;
/*     */     
/* 134 */     return this.field_75975_e.equals(statBase.field_75975_e);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 139 */     return this.field_75975_e.hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 144 */     return "Stat{id=" + this.field_75975_e + ", nameId=" + this.field_75978_a + ", awardLocallyOnly=" + this.field_75972_f + ", formatter=" + this.field_75976_b + ", objectiveCriteria=" + this.field_150957_c + '}';
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IScoreObjectiveCriteria func_150952_k() {
/* 154 */     return this.field_150957_c;
/*     */   }
/*     */   
/*     */   public Class func_150954_l() {
/* 158 */     return this.field_150956_d;
/*     */   }
/*     */   
/*     */   public StatBase func_150953_b(Class p_150953_1_) {
/* 162 */     this.field_150956_d = p_150953_1_;
/* 163 */     return this;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\stats\StatBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */