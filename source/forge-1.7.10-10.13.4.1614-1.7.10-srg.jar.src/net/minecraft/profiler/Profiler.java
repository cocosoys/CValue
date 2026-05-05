/*     */ package net.minecraft.profiler;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ 
/*     */ public class Profiler {
/*   9 */   private static final Logger field_151234_b = LogManager.getLogger();
/*  10 */   private final List field_76325_b = new ArrayList();
/*  11 */   private final List field_76326_c = new ArrayList();
/*     */   public boolean field_76327_a;
/*  13 */   private String field_76323_d = "";
/*  14 */   private final Map field_76324_e = new HashMap<Object, Object>(); private static final String __OBFID = "CL_00001497";
/*     */   
/*     */   public static final class Result implements Comparable { public double field_76332_a;
/*     */     public double field_76330_b;
/*     */     public String field_76331_c;
/*     */     private static final String __OBFID = "CL_00001498";
/*     */     
/*     */     public Result(String p_i1554_1_, double p_i1554_2_, double p_i1554_4_) {
/*  22 */       this.field_76331_c = p_i1554_1_;
/*  23 */       this.field_76332_a = p_i1554_2_;
/*  24 */       this.field_76330_b = p_i1554_4_;
/*     */     }
/*     */ 
/*     */     
/*     */     public int compareTo(Result p_compareTo_1_) {
/*  29 */       if (p_compareTo_1_.field_76332_a < this.field_76332_a) return -1; 
/*  30 */       if (p_compareTo_1_.field_76332_a > this.field_76332_a) return 1; 
/*  31 */       return p_compareTo_1_.field_76331_c.compareTo(this.field_76331_c);
/*     */     }
/*     */     @SideOnly(Side.CLIENT)
/*     */     public int func_76329_a() {
/*  35 */       return (this.field_76331_c.hashCode() & 0xAAAAAA) + 4473924;
/*     */     } }
/*     */ 
/*     */   
/*     */   public void func_76317_a() {
/*  40 */     this.field_76324_e.clear();
/*  41 */     this.field_76323_d = "";
/*  42 */     this.field_76325_b.clear();
/*     */   }
/*     */   
/*     */   public void func_76320_a(String p_76320_1_) {
/*  46 */     if (!this.field_76327_a)
/*  47 */       return;  if (this.field_76323_d.length() > 0) this.field_76323_d += "."; 
/*  48 */     this.field_76323_d += p_76320_1_;
/*  49 */     this.field_76325_b.add(this.field_76323_d);
/*  50 */     this.field_76326_c.add(Long.valueOf(System.nanoTime()));
/*     */   }
/*     */   
/*     */   public void func_76319_b() {
/*  54 */     if (!this.field_76327_a)
/*  55 */       return;  long l1 = System.nanoTime();
/*  56 */     long l2 = ((Long)this.field_76326_c.remove(this.field_76326_c.size() - 1)).longValue();
/*  57 */     this.field_76325_b.remove(this.field_76325_b.size() - 1);
/*  58 */     long l3 = l1 - l2;
/*     */     
/*  60 */     if (this.field_76324_e.containsKey(this.field_76323_d)) {
/*  61 */       this.field_76324_e.put(this.field_76323_d, Long.valueOf(((Long)this.field_76324_e.get(this.field_76323_d)).longValue() + l3));
/*     */     } else {
/*  63 */       this.field_76324_e.put(this.field_76323_d, Long.valueOf(l3));
/*     */     } 
/*     */     
/*  66 */     if (l3 > 100000000L) {
/*  67 */       field_151234_b.warn("Something's taking too long! '" + this.field_76323_d + "' took aprox " + (l3 / 1000000.0D) + " ms");
/*     */     }
/*     */     
/*  70 */     this.field_76323_d = !this.field_76325_b.isEmpty() ? this.field_76325_b.get(this.field_76325_b.size() - 1) : "";
/*     */   }
/*     */   
/*     */   public List func_76321_b(String p_76321_1_) {
/*  74 */     if (!this.field_76327_a) return null;
/*     */     
/*  76 */     String str = p_76321_1_;
/*  77 */     long l1 = this.field_76324_e.containsKey("root") ? ((Long)this.field_76324_e.get("root")).longValue() : 0L;
/*  78 */     long l2 = this.field_76324_e.containsKey(p_76321_1_) ? ((Long)this.field_76324_e.get(p_76321_1_)).longValue() : -1L;
/*     */     
/*  80 */     ArrayList<Result> arrayList = new ArrayList();
/*     */     
/*  82 */     if (p_76321_1_.length() > 0) p_76321_1_ = p_76321_1_ + "."; 
/*  83 */     long l3 = 0L;
/*     */     
/*  85 */     for (String str1 : this.field_76324_e.keySet()) {
/*  86 */       if (str1.length() > p_76321_1_.length() && str1.startsWith(p_76321_1_) && str1.indexOf(".", p_76321_1_.length() + 1) < 0) {
/*  87 */         l3 += ((Long)this.field_76324_e.get(str1)).longValue();
/*     */       }
/*     */     } 
/*     */     
/*  91 */     float f = (float)l3;
/*  92 */     if (l3 < l2) l3 = l2; 
/*  93 */     if (l1 < l3) l1 = l3;
/*     */     
/*  95 */     for (String str1 : this.field_76324_e.keySet()) {
/*  96 */       if (str1.length() > p_76321_1_.length() && str1.startsWith(p_76321_1_) && str1.indexOf(".", p_76321_1_.length() + 1) < 0) {
/*  97 */         long l = ((Long)this.field_76324_e.get(str1)).longValue();
/*  98 */         double d1 = l * 100.0D / l3;
/*  99 */         double d2 = l * 100.0D / l1;
/* 100 */         String str2 = str1.substring(p_76321_1_.length());
/* 101 */         arrayList.add(new Result(str2, d1, d2));
/*     */       } 
/*     */     } 
/*     */     
/* 105 */     for (String str1 : this.field_76324_e.keySet()) {
/* 106 */       this.field_76324_e.put(str1, Long.valueOf(((Long)this.field_76324_e.get(str1)).longValue() * 999L / 1000L));
/*     */     }
/*     */     
/* 109 */     if ((float)l3 > f) {
/* 110 */       arrayList.add(new Result("unspecified", ((float)l3 - f) * 100.0D / l3, ((float)l3 - f) * 100.0D / l1));
/*     */     }
/* 112 */     Collections.sort(arrayList);
/* 113 */     arrayList.add(0, new Result(str, 100.0D, l3 * 100.0D / l1));
/* 114 */     return arrayList;
/*     */   }
/*     */   
/*     */   public void func_76318_c(String p_76318_1_) {
/* 118 */     func_76319_b();
/* 119 */     func_76320_a(p_76318_1_);
/*     */   }
/*     */   
/*     */   public String func_76322_c() {
/* 123 */     return (this.field_76325_b.size() == 0) ? "[UNKNOWN]" : this.field_76325_b.get(this.field_76325_b.size() - 1);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\profiler\Profiler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */