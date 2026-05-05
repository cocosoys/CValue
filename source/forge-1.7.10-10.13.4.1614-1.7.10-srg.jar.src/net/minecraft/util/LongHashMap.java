/*     */ package net.minecraft.util;
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
/*     */ public class LongHashMap
/*     */ {
/*     */   private static final String __OBFID = "CL_00001492";
/*     */   private volatile transient int field_76166_e;
/*  18 */   private final float field_76165_d = 0.75F;
/*  19 */   private int field_76168_c = 12;
/*  20 */   private transient Entry[] field_76169_a = new Entry[16];
/*     */   private transient int field_76167_b;
/*     */   
/*     */   private static int func_76155_g(long p_76155_0_) {
/*  24 */     return func_76157_a((int)(p_76155_0_ ^ p_76155_0_ >>> 32L));
/*     */   }
/*     */   
/*     */   private static int func_76157_a(int p_76157_0_) {
/*  28 */     p_76157_0_ ^= p_76157_0_ >>> 20 ^ p_76157_0_ >>> 12;
/*  29 */     return p_76157_0_ ^ p_76157_0_ >>> 7 ^ p_76157_0_ >>> 4;
/*     */   }
/*     */   
/*     */   private static int func_76158_a(int p_76158_0_, int p_76158_1_) {
/*  33 */     return p_76158_0_ & p_76158_1_ - 1;
/*     */   }
/*     */   
/*     */   public int func_76162_a() {
/*  37 */     return this.field_76167_b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object func_76164_a(long p_76164_1_) {
/*  45 */     int i = func_76155_g(p_76164_1_);
/*  46 */     for (Entry entry = this.field_76169_a[func_76158_a(i, this.field_76169_a.length)]; entry != null; entry = entry.field_76149_c) {
/*  47 */       if (entry.field_76150_a == p_76164_1_) return entry.field_76148_b; 
/*     */     } 
/*  49 */     return null;
/*     */   }
/*     */   
/*     */   public boolean func_76161_b(long p_76161_1_) {
/*  53 */     return (func_76160_c(p_76161_1_) != null);
/*     */   }
/*     */   
/*     */   final Entry func_76160_c(long p_76160_1_) {
/*  57 */     int i = func_76155_g(p_76160_1_);
/*  58 */     for (Entry entry = this.field_76169_a[func_76158_a(i, this.field_76169_a.length)]; entry != null; entry = entry.field_76149_c) {
/*  59 */       if (entry.field_76150_a == p_76160_1_) return entry; 
/*     */     } 
/*  61 */     return null;
/*     */   }
/*     */   
/*     */   public void func_76163_a(long p_76163_1_, Object p_76163_3_) {
/*  65 */     int i = func_76155_g(p_76163_1_);
/*  66 */     int j = func_76158_a(i, this.field_76169_a.length);
/*  67 */     for (Entry entry = this.field_76169_a[j]; entry != null; entry = entry.field_76149_c) {
/*  68 */       if (entry.field_76150_a == p_76163_1_) {
/*  69 */         entry.field_76148_b = p_76163_3_;
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*  74 */     this.field_76166_e++;
/*  75 */     func_76156_a(i, p_76163_1_, p_76163_3_, j);
/*     */   }
/*     */ 
/*     */   
/*     */   private void func_76153_b(int p_76153_1_) {
/*  80 */     Entry[] arrayOfEntry1 = this.field_76169_a;
/*  81 */     int i = arrayOfEntry1.length;
/*  82 */     if (i == 1073741824) {
/*  83 */       this.field_76168_c = Integer.MAX_VALUE;
/*     */       
/*     */       return;
/*     */     } 
/*  87 */     Entry[] arrayOfEntry2 = new Entry[p_76153_1_];
/*  88 */     func_76154_a(arrayOfEntry2);
/*  89 */     this.field_76169_a = arrayOfEntry2;
/*  90 */     this.field_76168_c = (int)(p_76153_1_ * this.field_76165_d);
/*     */   }
/*     */   
/*     */   private void func_76154_a(Entry[] p_76154_1_) {
/*  94 */     Entry[] arrayOfEntry = this.field_76169_a;
/*  95 */     int i = p_76154_1_.length;
/*  96 */     for (byte b = 0; b < arrayOfEntry.length; b++) {
/*  97 */       Entry entry = arrayOfEntry[b];
/*  98 */       if (entry != null) {
/*  99 */         arrayOfEntry[b] = null;
/*     */         do {
/* 101 */           Entry entry1 = entry.field_76149_c;
/* 102 */           int j = func_76158_a(entry.field_76147_d, i);
/* 103 */           entry.field_76149_c = p_76154_1_[j];
/* 104 */           p_76154_1_[j] = entry;
/* 105 */           entry = entry1;
/* 106 */         } while (entry != null);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public Object func_76159_d(long p_76159_1_) {
/* 112 */     Entry entry = func_76152_e(p_76159_1_);
/* 113 */     return (entry == null) ? null : entry.field_76148_b;
/*     */   }
/*     */   
/*     */   final Entry func_76152_e(long p_76152_1_) {
/* 117 */     int i = func_76155_g(p_76152_1_);
/* 118 */     int j = func_76158_a(i, this.field_76169_a.length);
/* 119 */     Entry entry1 = this.field_76169_a[j];
/* 120 */     Entry entry2 = entry1;
/*     */     
/* 122 */     while (entry2 != null) {
/* 123 */       Entry entry = entry2.field_76149_c;
/* 124 */       if (entry2.field_76150_a == p_76152_1_) {
/* 125 */         this.field_76166_e++;
/* 126 */         this.field_76167_b--;
/* 127 */         if (entry1 == entry2) { this.field_76169_a[j] = entry; }
/* 128 */         else { entry1.field_76149_c = entry; }
/* 129 */          return entry2;
/*     */       } 
/* 131 */       entry1 = entry2;
/* 132 */       entry2 = entry;
/*     */     } 
/*     */     
/* 135 */     return entry2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class Entry
/*     */   {
/*     */     final long field_76150_a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Object field_76148_b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Entry field_76149_c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     final int field_76147_d;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static final String __OBFID = "CL_00001493";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Entry(int p_i1553_1_, long p_i1553_2_, Object p_i1553_4_, Entry p_i1553_5_) {
/* 182 */       this.field_76148_b = p_i1553_4_;
/* 183 */       this.field_76149_c = p_i1553_5_;
/* 184 */       this.field_76150_a = p_i1553_2_;
/* 185 */       this.field_76147_d = p_i1553_1_;
/*     */     }
/*     */     
/*     */     public final long func_76146_a() {
/* 189 */       return this.field_76150_a;
/*     */     }
/*     */     
/*     */     public final Object func_76145_b() {
/* 193 */       return this.field_76148_b;
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean equals(Object p_equals_1_) {
/* 198 */       if (!(p_equals_1_ instanceof Entry)) return false; 
/* 199 */       Entry entry = (Entry)p_equals_1_;
/* 200 */       Long long_1 = Long.valueOf(func_76146_a());
/* 201 */       Long long_2 = Long.valueOf(entry.func_76146_a());
/* 202 */       if (long_1 == long_2 || (long_1 != null && long_1.equals(long_2))) {
/* 203 */         Object object1 = func_76145_b();
/* 204 */         Object object2 = entry.func_76145_b();
/* 205 */         if (object1 == object2 || (object1 != null && object1.equals(object2))) return true; 
/*     */       } 
/* 207 */       return false;
/*     */     }
/*     */     
/*     */     public final int hashCode() {
/* 211 */       return LongHashMap.func_76155_g(this.field_76150_a);
/*     */     }
/*     */     
/*     */     public final String toString() {
/* 215 */       return func_76146_a() + "=" + func_76145_b();
/*     */     }
/*     */   }
/*     */   
/*     */   private void func_76156_a(int p_76156_1_, long p_76156_2_, Object p_76156_4_, int p_76156_5_) {
/* 220 */     Entry entry = this.field_76169_a[p_76156_5_];
/* 221 */     this.field_76169_a[p_76156_5_] = new Entry(p_76156_1_, p_76156_2_, p_76156_4_, entry);
/* 222 */     if (this.field_76167_b++ >= this.field_76168_c) func_76153_b(2 * this.field_76169_a.length); 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\LongHashMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */