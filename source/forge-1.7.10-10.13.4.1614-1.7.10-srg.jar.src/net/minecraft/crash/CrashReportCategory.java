/*     */ package net.minecraft.crash;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.Callable;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class CrashReportCategory {
/*     */   private final CrashReport field_85078_a;
/*  13 */   private final List field_85077_c = new ArrayList(); private final String field_85076_b;
/*  14 */   private StackTraceElement[] field_85075_d = new StackTraceElement[0]; private static final String __OBFID = "CL_00001409";
/*     */   
/*     */   public CrashReportCategory(CrashReport p_i1353_1_, String p_i1353_2_) {
/*  17 */     this.field_85078_a = p_i1353_1_;
/*  18 */     this.field_85076_b = p_i1353_2_;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static String func_85074_a(double p_85074_0_, double p_85074_2_, double p_85074_4_) {
/*  22 */     return String.format("%.2f,%.2f,%.2f - %s", new Object[] { Double.valueOf(p_85074_0_), Double.valueOf(p_85074_2_), Double.valueOf(p_85074_4_), func_85071_a(MathHelper.func_76128_c(p_85074_0_), MathHelper.func_76128_c(p_85074_2_), MathHelper.func_76128_c(p_85074_4_)) });
/*     */   }
/*     */   
/*     */   public static String func_85071_a(int p_85071_0_, int p_85071_1_, int p_85071_2_) {
/*  26 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/*     */     try {
/*  29 */       stringBuilder.append(String.format("World: (%d,%d,%d)", new Object[] { Integer.valueOf(p_85071_0_), Integer.valueOf(p_85071_1_), Integer.valueOf(p_85071_2_) }));
/*  30 */     } catch (Throwable throwable) {
/*  31 */       stringBuilder.append("(Error finding world loc)");
/*     */     } 
/*     */     
/*  34 */     stringBuilder.append(", ");
/*     */     
/*     */     try {
/*  37 */       int i = p_85071_0_ >> 4;
/*  38 */       int j = p_85071_2_ >> 4;
/*  39 */       int k = p_85071_0_ & 0xF;
/*  40 */       int m = p_85071_1_ >> 4;
/*  41 */       int n = p_85071_2_ & 0xF;
/*  42 */       int i1 = i << 4;
/*  43 */       int i2 = j << 4;
/*  44 */       int i3 = (i + 1 << 4) - 1;
/*  45 */       int i4 = (j + 1 << 4) - 1;
/*  46 */       stringBuilder.append(String.format("Chunk: (at %d,%d,%d in %d,%d; contains blocks %d,0,%d to %d,255,%d)", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4) }));
/*  47 */     } catch (Throwable throwable) {
/*  48 */       stringBuilder.append("(Error finding chunk loc)");
/*     */     } 
/*     */     
/*  51 */     stringBuilder.append(", ");
/*     */     
/*     */     try {
/*  54 */       int i = p_85071_0_ >> 9;
/*  55 */       int j = p_85071_2_ >> 9;
/*  56 */       int k = i << 5;
/*  57 */       int m = j << 5;
/*  58 */       int n = (i + 1 << 5) - 1;
/*  59 */       int i1 = (j + 1 << 5) - 1;
/*  60 */       int i2 = i << 9;
/*  61 */       int i3 = j << 9;
/*  62 */       int i4 = (i + 1 << 9) - 1;
/*  63 */       int i5 = (j + 1 << 9) - 1;
/*  64 */       stringBuilder.append(String.format("Region: (%d,%d; contains chunks %d,%d to %d,%d, blocks %d,0,%d to %d,255,%d)", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5) }));
/*  65 */     } catch (Throwable throwable) {
/*  66 */       stringBuilder.append("(Error finding world loc)");
/*     */     } 
/*     */     
/*  69 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public void func_71500_a(String p_71500_1_, Callable p_71500_2_) {
/*     */     try {
/*  74 */       func_71507_a(p_71500_1_, p_71500_2_.call());
/*  75 */     } catch (Throwable throwable) {
/*  76 */       func_71499_a(p_71500_1_, throwable);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_71507_a(String p_71507_1_, Object p_71507_2_) {
/*  81 */     this.field_85077_c.add(new Entry(p_71507_1_, p_71507_2_));
/*     */   }
/*     */   
/*     */   public void func_71499_a(String p_71499_1_, Throwable p_71499_2_) {
/*  85 */     func_71507_a(p_71499_1_, p_71499_2_);
/*     */   }
/*     */   
/*     */   public int func_85073_a(int p_85073_1_) {
/*  89 */     StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
/*     */ 
/*     */     
/*  92 */     if (arrayOfStackTraceElement.length <= 0) {
/*  93 */       return 0;
/*     */     }
/*     */     
/*  96 */     this.field_85075_d = new StackTraceElement[arrayOfStackTraceElement.length - 3 - p_85073_1_];
/*  97 */     System.arraycopy(arrayOfStackTraceElement, 3 + p_85073_1_, this.field_85075_d, 0, this.field_85075_d.length);
/*  98 */     return this.field_85075_d.length;
/*     */   }
/*     */   
/*     */   public boolean func_85069_a(StackTraceElement p_85069_1_, StackTraceElement p_85069_2_) {
/* 102 */     if (this.field_85075_d.length == 0 || p_85069_1_ == null) return false;
/*     */     
/* 104 */     StackTraceElement stackTraceElement = this.field_85075_d[0];
/*     */ 
/*     */     
/* 107 */     if (stackTraceElement.isNativeMethod() != p_85069_1_.isNativeMethod() || !stackTraceElement.getClassName().equals(p_85069_1_.getClassName()) || !stackTraceElement.getFileName().equals(p_85069_1_.getFileName()) || !stackTraceElement.getMethodName().equals(p_85069_1_.getMethodName()))
/*     */     {
/*     */ 
/*     */       
/* 111 */       return false;
/*     */     }
/* 113 */     if (((p_85069_2_ != null) ? true : false) != ((this.field_85075_d.length > 1) ? true : false)) return false; 
/* 114 */     if (p_85069_2_ != null && !this.field_85075_d[1].equals(p_85069_2_)) return false;
/*     */     
/* 116 */     this.field_85075_d[0] = p_85069_1_;
/*     */     
/* 118 */     return true;
/*     */   }
/*     */   
/*     */   public void func_85070_b(int p_85070_1_) {
/* 122 */     StackTraceElement[] arrayOfStackTraceElement = new StackTraceElement[this.field_85075_d.length - p_85070_1_];
/* 123 */     System.arraycopy(this.field_85075_d, 0, arrayOfStackTraceElement, 0, arrayOfStackTraceElement.length);
/* 124 */     this.field_85075_d = arrayOfStackTraceElement;
/*     */   }
/*     */   
/*     */   public void func_85072_a(StringBuilder p_85072_1_) {
/* 128 */     p_85072_1_.append("-- ").append(this.field_85076_b).append(" --\n");
/* 129 */     p_85072_1_.append("Details:");
/*     */     
/* 131 */     for (Entry entry : this.field_85077_c) {
/* 132 */       p_85072_1_.append("\n\t");
/* 133 */       p_85072_1_.append(entry.func_85089_a());
/* 134 */       p_85072_1_.append(": ");
/* 135 */       p_85072_1_.append(entry.func_85090_b());
/*     */     } 
/*     */     
/* 138 */     if (this.field_85075_d != null && this.field_85075_d.length > 0) {
/* 139 */       p_85072_1_.append("\nStacktrace:");
/*     */       
/* 141 */       for (StackTraceElement stackTraceElement : this.field_85075_d) {
/* 142 */         p_85072_1_.append("\n\tat ");
/* 143 */         p_85072_1_.append(stackTraceElement.toString());
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public StackTraceElement[] func_147152_a() {
/* 149 */     return this.field_85075_d;
/*     */   }
/*     */   
/*     */   public static void func_147153_a(CrashReportCategory p_147153_0_, int p_147153_1_, int p_147153_2_, int p_147153_3_, Block p_147153_4_, int p_147153_5_) {
/* 153 */     int i = Block.func_149682_b(p_147153_4_);
/* 154 */     p_147153_0_.func_71500_a("Block type", new Callable(i, p_147153_4_) { private static final String __OBFID = "CL_00001426";
/*     */           
/*     */           public String call() {
/*     */             try {
/* 158 */               return String.format("ID #%d (%s // %s)", new Object[] { Integer.valueOf(this.field_85080_a), this.field_147151_b.func_149739_a(), this.field_147151_b.getClass().getCanonicalName() });
/* 159 */             } catch (Throwable throwable) {
/* 160 */               return "ID #" + this.field_85080_a;
/*     */             } 
/*     */           } }
/*     */       );
/*     */     
/* 165 */     p_147153_0_.func_71500_a("Block data value", new Callable(p_147153_5_) { private static final String __OBFID = "CL_00001441";
/*     */           
/*     */           public String call() {
/* 168 */             if (this.field_85063_a < 0) return "Unknown? (Got " + this.field_85063_a + ")"; 
/* 169 */             String str = String.format("%4s", new Object[] { Integer.toBinaryString(this.field_85063_a) }).replace(" ", "0");
/*     */ 
/*     */             
/* 172 */             return String.format("%1$d / 0x%1$X / 0b%2$s", new Object[] { Integer.valueOf(this.field_85063_a), str });
/*     */           } }
/*     */       );
/*     */     
/* 176 */     p_147153_0_.func_71500_a("Block location", new Callable(p_147153_1_, p_147153_2_, p_147153_3_) { private static final String __OBFID = "CL_00001465";
/*     */           
/*     */           public String call() {
/* 179 */             return CrashReportCategory.func_85071_a(this.field_85067_a, this.field_85065_b, this.field_85066_c);
/*     */           } }
/*     */       );
/*     */   }
/*     */   
/*     */   static class Entry { private final String field_85092_a;
/*     */     private final String field_85091_b;
/*     */     private static final String __OBFID = "CL_00001489";
/*     */     
/*     */     public Entry(String p_i1352_1_, Object p_i1352_2_) {
/* 189 */       this.field_85092_a = p_i1352_1_;
/*     */       
/* 191 */       if (p_i1352_2_ == null) {
/* 192 */         this.field_85091_b = "~~NULL~~";
/* 193 */       } else if (p_i1352_2_ instanceof Throwable) {
/* 194 */         Throwable throwable = (Throwable)p_i1352_2_;
/* 195 */         this.field_85091_b = "~~ERROR~~ " + throwable.getClass().getSimpleName() + ": " + throwable.getMessage();
/*     */       } else {
/* 197 */         this.field_85091_b = p_i1352_2_.toString();
/*     */       } 
/*     */     }
/*     */     
/*     */     public String func_85089_a() {
/* 202 */       return this.field_85092_a;
/*     */     }
/*     */     
/*     */     public String func_85090_b() {
/* 206 */       return this.field_85091_b;
/*     */     } }
/*     */ 
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\crash\CrashReportCategory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */