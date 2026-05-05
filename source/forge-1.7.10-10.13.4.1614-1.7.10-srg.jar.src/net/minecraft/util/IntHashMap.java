/*     */ package net.minecraft.util;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IntHashMap
/*     */ {
/*     */   private transient Entry[] field_76055_a;
/*     */   private transient int field_76053_b;
/*     */   private int field_76054_c;
/*     */   private final float field_76051_d;
/*     */   private volatile transient int field_76052_e;
/*  17 */   private Set field_76050_f = new HashSet();
/*     */   private static final String __OBFID = "CL_00001490";
/*     */   
/*     */   public IntHashMap() {
/*  21 */     this.field_76051_d = 0.75F;
/*  22 */     this.field_76054_c = 12;
/*  23 */     this.field_76055_a = new Entry[16];
/*     */   }
/*     */   
/*     */   private static int func_76044_g(int p_76044_0_) {
/*  27 */     p_76044_0_ ^= p_76044_0_ >>> 20 ^ p_76044_0_ >>> 12;
/*  28 */     return p_76044_0_ ^ p_76044_0_ >>> 7 ^ p_76044_0_ >>> 4;
/*     */   }
/*     */   
/*     */   private static int func_76043_a(int p_76043_0_, int p_76043_1_) {
/*  32 */     return p_76043_0_ & p_76043_1_ - 1;
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
/*     */   public Object func_76041_a(int p_76041_1_) {
/*  44 */     int i = func_76044_g(p_76041_1_);
/*  45 */     for (Entry entry = this.field_76055_a[func_76043_a(i, this.field_76055_a.length)]; entry != null; entry = entry.field_76034_c) {
/*  46 */       if (entry.field_76035_a == p_76041_1_) return entry.field_76033_b; 
/*     */     } 
/*  48 */     return null;
/*     */   }
/*     */   
/*     */   public boolean func_76037_b(int p_76037_1_) {
/*  52 */     return (func_76045_c(p_76037_1_) != null);
/*     */   }
/*     */   
/*     */   final Entry func_76045_c(int p_76045_1_) {
/*  56 */     int i = func_76044_g(p_76045_1_);
/*  57 */     for (Entry entry = this.field_76055_a[func_76043_a(i, this.field_76055_a.length)]; entry != null; entry = entry.field_76034_c) {
/*  58 */       if (entry.field_76035_a == p_76045_1_) return entry; 
/*     */     } 
/*  60 */     return null;
/*     */   }
/*     */   
/*     */   public void func_76038_a(int p_76038_1_, Object p_76038_2_) {
/*  64 */     this.field_76050_f.add(Integer.valueOf(p_76038_1_));
/*  65 */     int i = func_76044_g(p_76038_1_);
/*  66 */     int j = func_76043_a(i, this.field_76055_a.length);
/*  67 */     for (Entry entry = this.field_76055_a[j]; entry != null; entry = entry.field_76034_c) {
/*  68 */       if (entry.field_76035_a == p_76038_1_) {
/*  69 */         entry.field_76033_b = p_76038_2_;
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*  74 */     this.field_76052_e++;
/*  75 */     func_76040_a(i, p_76038_1_, p_76038_2_, j);
/*     */   }
/*     */ 
/*     */   
/*     */   private void func_76047_h(int p_76047_1_) {
/*  80 */     Entry[] arrayOfEntry1 = this.field_76055_a;
/*  81 */     int i = arrayOfEntry1.length;
/*  82 */     if (i == 1073741824) {
/*  83 */       this.field_76054_c = Integer.MAX_VALUE;
/*     */       
/*     */       return;
/*     */     } 
/*  87 */     Entry[] arrayOfEntry2 = new Entry[p_76047_1_];
/*  88 */     func_76048_a(arrayOfEntry2);
/*  89 */     this.field_76055_a = arrayOfEntry2;
/*  90 */     this.field_76054_c = (int)(p_76047_1_ * this.field_76051_d);
/*     */   }
/*     */   
/*     */   private void func_76048_a(Entry[] p_76048_1_) {
/*  94 */     Entry[] arrayOfEntry = this.field_76055_a;
/*  95 */     int i = p_76048_1_.length;
/*  96 */     for (byte b = 0; b < arrayOfEntry.length; b++) {
/*  97 */       Entry entry = arrayOfEntry[b];
/*  98 */       if (entry != null) {
/*  99 */         arrayOfEntry[b] = null;
/*     */         do {
/* 101 */           Entry entry1 = entry.field_76034_c;
/* 102 */           int j = func_76043_a(entry.field_76032_d, i);
/* 103 */           entry.field_76034_c = p_76048_1_[j];
/* 104 */           p_76048_1_[j] = entry;
/* 105 */           entry = entry1;
/* 106 */         } while (entry != null);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public Object func_76049_d(int p_76049_1_) {
/* 112 */     this.field_76050_f.remove(Integer.valueOf(p_76049_1_));
/* 113 */     Entry entry = func_76036_e(p_76049_1_);
/* 114 */     return (entry == null) ? null : entry.field_76033_b;
/*     */   }
/*     */   
/*     */   final Entry func_76036_e(int p_76036_1_) {
/* 118 */     int i = func_76044_g(p_76036_1_);
/* 119 */     int j = func_76043_a(i, this.field_76055_a.length);
/* 120 */     Entry entry1 = this.field_76055_a[j];
/* 121 */     Entry entry2 = entry1;
/*     */     
/* 123 */     while (entry2 != null) {
/* 124 */       Entry entry = entry2.field_76034_c;
/* 125 */       if (entry2.field_76035_a == p_76036_1_) {
/* 126 */         this.field_76052_e++;
/* 127 */         this.field_76053_b--;
/* 128 */         if (entry1 == entry2) { this.field_76055_a[j] = entry; }
/* 129 */         else { entry1.field_76034_c = entry; }
/* 130 */          return entry2;
/*     */       } 
/* 132 */       entry1 = entry2;
/* 133 */       entry2 = entry;
/*     */     } 
/*     */     
/* 136 */     return entry2;
/*     */   }
/*     */   
/*     */   public void func_76046_c() {
/* 140 */     this.field_76052_e++;
/* 141 */     Entry[] arrayOfEntry = this.field_76055_a;
/* 142 */     for (byte b = 0; b < arrayOfEntry.length; b++)
/* 143 */       arrayOfEntry[b] = null; 
/* 144 */     this.field_76053_b = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class Entry
/*     */   {
/*     */     final int field_76035_a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Object field_76033_b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Entry field_76034_c;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     final int field_76032_d;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static final String __OBFID = "CL_00001491";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Entry(int p_i1552_1_, int p_i1552_2_, Object p_i1552_3_, Entry p_i1552_4_) {
/* 183 */       this.field_76033_b = p_i1552_3_;
/* 184 */       this.field_76034_c = p_i1552_4_;
/* 185 */       this.field_76035_a = p_i1552_2_;
/* 186 */       this.field_76032_d = p_i1552_1_;
/*     */     }
/*     */     
/*     */     public final int func_76031_a() {
/* 190 */       return this.field_76035_a;
/*     */     }
/*     */     
/*     */     public final Object func_76030_b() {
/* 194 */       return this.field_76033_b;
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean equals(Object p_equals_1_) {
/* 199 */       if (!(p_equals_1_ instanceof Entry)) return false; 
/* 200 */       Entry entry = (Entry)p_equals_1_;
/* 201 */       Integer integer1 = Integer.valueOf(func_76031_a());
/* 202 */       Integer integer2 = Integer.valueOf(entry.func_76031_a());
/* 203 */       if (integer1 == integer2 || (integer1 != null && integer1.equals(integer2))) {
/* 204 */         Object object1 = func_76030_b();
/* 205 */         Object object2 = entry.func_76030_b();
/* 206 */         if (object1 == object2 || (object1 != null && object1.equals(object2))) return true; 
/*     */       } 
/* 208 */       return false;
/*     */     }
/*     */     
/*     */     public final int hashCode() {
/* 212 */       return IntHashMap.func_76044_g(this.field_76035_a);
/*     */     }
/*     */     
/*     */     public final String toString() {
/* 216 */       return func_76031_a() + "=" + func_76030_b();
/*     */     }
/*     */   }
/*     */   
/*     */   private void func_76040_a(int p_76040_1_, int p_76040_2_, Object p_76040_3_, int p_76040_4_) {
/* 221 */     Entry entry = this.field_76055_a[p_76040_4_];
/* 222 */     this.field_76055_a[p_76040_4_] = new Entry(p_76040_1_, p_76040_2_, p_76040_3_, entry);
/* 223 */     if (this.field_76053_b++ >= this.field_76054_c) func_76047_h(2 * this.field_76055_a.length); 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\IntHashMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */