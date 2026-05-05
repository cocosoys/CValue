/*     */ package net.minecraft.util;
/*     */ 
/*     */ import com.google.common.collect.Iterators;
/*     */ import com.google.common.collect.Lists;
/*     */ import java.util.Arrays;
/*     */ import java.util.IllegalFormatException;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ public class ChatComponentTranslation
/*     */   extends ChatComponentStyle
/*     */ {
/*     */   private final String field_150276_d;
/*     */   private final Object[] field_150277_e;
/*  17 */   private final Object field_150274_f = new Object();
/*  18 */   private long field_150275_g = -1L;
/*     */   
/*  20 */   List field_150278_b = Lists.newArrayList();
/*     */ 
/*     */   
/*  23 */   public static final Pattern field_150279_c = Pattern.compile("%(?:(\\d+)\\$)?([A-Za-z%]|$)");
/*     */   
/*     */   public ChatComponentTranslation(String p_i45160_1_, Object... p_i45160_2_) {
/*  26 */     this.field_150276_d = p_i45160_1_;
/*  27 */     this.field_150277_e = p_i45160_2_;
/*     */     
/*  29 */     for (Object object : p_i45160_2_) {
/*  30 */       if (object instanceof IChatComponent)
/*  31 */         ((IChatComponent)object).func_150256_b().func_150221_a(func_150256_b()); 
/*     */     } 
/*     */   }
/*     */   
/*     */   private static final String __OBFID = "CL_00001270";
/*     */   
/*     */   synchronized void func_150270_g() {
/*  38 */     synchronized (this.field_150274_f) {
/*  39 */       long l = StatCollector.func_150827_a();
/*  40 */       if (l == this.field_150275_g) {
/*     */         return;
/*     */       }
/*  43 */       this.field_150275_g = l;
/*  44 */       this.field_150278_b.clear();
/*     */     } 
/*     */     
/*     */     try {
/*  48 */       func_150269_b(StatCollector.func_74838_a(this.field_150276_d));
/*  49 */     } catch (ChatComponentTranslationFormatException chatComponentTranslationFormatException) {
/*  50 */       this.field_150278_b.clear();
/*     */       try {
/*  52 */         func_150269_b(StatCollector.func_150826_b(this.field_150276_d));
/*  53 */       } catch (ChatComponentTranslationFormatException chatComponentTranslationFormatException1) {
/*  54 */         throw chatComponentTranslationFormatException;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void func_150269_b(String p_150269_1_) {
/*  60 */     boolean bool = false;
/*  61 */     Matcher matcher = field_150279_c.matcher(p_150269_1_);
/*     */     
/*  63 */     byte b = 0;
/*  64 */     int i = 0;
/*     */     
/*     */     try {
/*  67 */       while (matcher.find(i)) {
/*  68 */         int j = matcher.start();
/*  69 */         int k = matcher.end();
/*     */ 
/*     */         
/*  72 */         if (j > i) {
/*  73 */           ChatComponentText chatComponentText = new ChatComponentText(String.format(p_150269_1_.substring(i, j), new Object[0]));
/*  74 */           chatComponentText.func_150256_b().func_150221_a(func_150256_b());
/*  75 */           this.field_150278_b.add(chatComponentText);
/*     */         } 
/*     */         
/*  78 */         String str1 = matcher.group(2);
/*  79 */         String str2 = p_150269_1_.substring(j, k);
/*     */ 
/*     */         
/*  82 */         if ("%".equals(str1) && "%%".equals(str2)) {
/*  83 */           ChatComponentText chatComponentText = new ChatComponentText("%");
/*  84 */           chatComponentText.func_150256_b().func_150221_a(func_150256_b());
/*  85 */           this.field_150278_b.add(chatComponentText);
/*  86 */         } else if ("s".equals(str1)) {
/*  87 */           String str = matcher.group(1);
/*  88 */           boolean bool1 = (str != null) ? (Integer.parseInt(str) - 1) : b++;
/*  89 */           this.field_150278_b.add(func_150272_a(bool1));
/*     */         } else {
/*  91 */           throw new ChatComponentTranslationFormatException(this, "Unsupported format: '" + str2 + "'");
/*     */         } 
/*     */         
/*  94 */         i = k;
/*     */       } 
/*     */ 
/*     */       
/*  98 */       if (i < p_150269_1_.length()) {
/*  99 */         ChatComponentText chatComponentText = new ChatComponentText(String.format(p_150269_1_.substring(i), new Object[0]));
/* 100 */         chatComponentText.func_150256_b().func_150221_a(func_150256_b());
/* 101 */         this.field_150278_b.add(chatComponentText);
/*     */       } 
/* 103 */     } catch (IllegalFormatException illegalFormatException) {
/* 104 */       throw new ChatComponentTranslationFormatException(this, illegalFormatException);
/*     */     } 
/*     */   }
/*     */   private IChatComponent func_150272_a(int p_150272_1_) {
/*     */     IChatComponent iChatComponent;
/* 109 */     if (p_150272_1_ >= this.field_150277_e.length) {
/* 110 */       throw new ChatComponentTranslationFormatException(this, p_150272_1_);
/*     */     }
/*     */     
/* 113 */     Object object = this.field_150277_e[p_150272_1_];
/*     */ 
/*     */     
/* 116 */     if (object instanceof IChatComponent) {
/* 117 */       iChatComponent = (IChatComponent)object;
/*     */     } else {
/* 119 */       iChatComponent = new ChatComponentText((object == null) ? "null" : object.toString());
/* 120 */       iChatComponent.func_150256_b().func_150221_a(func_150256_b());
/*     */     } 
/*     */     
/* 123 */     return iChatComponent;
/*     */   }
/*     */ 
/*     */   
/*     */   public IChatComponent func_150255_a(ChatStyle p_150255_1_) {
/* 128 */     super.func_150255_a(p_150255_1_);
/*     */     
/* 130 */     for (Object object : this.field_150277_e) {
/* 131 */       if (object instanceof IChatComponent) {
/* 132 */         ((IChatComponent)object).func_150256_b().func_150221_a(func_150256_b());
/*     */       }
/*     */     } 
/*     */     
/* 136 */     if (this.field_150275_g > -1L) {
/* 137 */       for (IChatComponent iChatComponent : this.field_150278_b) {
/* 138 */         iChatComponent.func_150256_b().func_150221_a(p_150255_1_);
/*     */       }
/*     */     }
/*     */     
/* 142 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Iterator iterator() {
/* 147 */     func_150270_g();
/*     */     
/* 149 */     return Iterators.concat(func_150262_a(this.field_150278_b), func_150262_a(this.field_150264_a));
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_150261_e() {
/* 154 */     func_150270_g();
/*     */     
/* 156 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/* 158 */     for (IChatComponent iChatComponent : this.field_150278_b) {
/* 159 */       stringBuilder.append(iChatComponent.func_150261_e());
/*     */     }
/*     */     
/* 162 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public ChatComponentTranslation func_150259_f() {
/* 167 */     Object[] arrayOfObject = new Object[this.field_150277_e.length];
/*     */     
/* 169 */     for (byte b = 0; b < this.field_150277_e.length; b++) {
/* 170 */       if (this.field_150277_e[b] instanceof IChatComponent) {
/* 171 */         arrayOfObject[b] = ((IChatComponent)this.field_150277_e[b]).func_150259_f();
/*     */       } else {
/* 173 */         arrayOfObject[b] = this.field_150277_e[b];
/*     */       } 
/*     */     } 
/*     */     
/* 177 */     ChatComponentTranslation chatComponentTranslation = new ChatComponentTranslation(this.field_150276_d, arrayOfObject);
/* 178 */     chatComponentTranslation.func_150255_a(func_150256_b().func_150232_l());
/* 179 */     for (IChatComponent iChatComponent : func_150253_a()) {
/* 180 */       chatComponentTranslation.func_150257_a(iChatComponent.func_150259_f());
/*     */     }
/* 182 */     return chatComponentTranslation;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object p_equals_1_) {
/* 187 */     if (this == p_equals_1_) return true;
/*     */     
/* 189 */     if (p_equals_1_ instanceof ChatComponentTranslation) {
/* 190 */       ChatComponentTranslation chatComponentTranslation = (ChatComponentTranslation)p_equals_1_;
/* 191 */       return (Arrays.equals(this.field_150277_e, chatComponentTranslation.field_150277_e) && this.field_150276_d.equals(chatComponentTranslation.field_150276_d) && super.equals(p_equals_1_));
/*     */     } 
/*     */     
/* 194 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 199 */     int i = super.hashCode();
/* 200 */     i = 31 * i + this.field_150276_d.hashCode();
/* 201 */     i = 31 * i + Arrays.hashCode(this.field_150277_e);
/* 202 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 207 */     return "TranslatableComponent{key='" + this.field_150276_d + '\'' + ", args=" + Arrays.toString(this.field_150277_e) + ", siblings=" + this.field_150264_a + ", style=" + func_150256_b() + '}';
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_150268_i() {
/* 216 */     return this.field_150276_d;
/*     */   }
/*     */   
/*     */   public Object[] func_150271_j() {
/* 220 */     return this.field_150277_e;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\ChatComponentTranslation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */