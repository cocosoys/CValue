/*     */ package net.minecraft.util;
/*     */ import com.google.common.base.Splitter;
/*     */ import com.google.common.collect.Iterables;
/*     */ import com.google.common.collect.Maps;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.IllegalFormatException;
/*     */ import java.util.Map;
/*     */ import java.util.regex.Pattern;
/*     */ import org.apache.commons.io.Charsets;
/*     */ import org.apache.commons.io.IOUtils;
/*     */ 
/*     */ public class StringTranslate {
/*  16 */   private static final Pattern field_111053_a = Pattern.compile("%(\\d+\\$)?[\\d\\.]*[df]");
/*  17 */   private static final Splitter field_135065_b = Splitter.on('=').limit(2);
/*     */   
/*  19 */   private static StringTranslate field_74817_a = new StringTranslate();
/*     */   
/*  21 */   private final Map field_74816_c = Maps.newHashMap(); private long field_150511_e;
/*     */   private static final String __OBFID = "CL_00001212";
/*     */   
/*     */   public StringTranslate() {
/*     */     try {
/*  26 */       InputStream inputStream = StringTranslate.class.getResourceAsStream("/assets/minecraft/lang/en_US.lang");
/*  27 */       for (String str1 : IOUtils.readLines(inputStream, Charsets.UTF_8)) {
/*     */         
/*  29 */         if (str1.isEmpty() || str1.charAt(0) == '#')
/*     */           continue; 
/*  31 */         String[] arrayOfString = (String[])Iterables.toArray(field_135065_b.split(str1), String.class);
/*     */ 
/*     */         
/*  34 */         if (arrayOfString == null || arrayOfString.length != 2) {
/*     */           continue;
/*     */         }
/*     */ 
/*     */         
/*  39 */         String str2 = arrayOfString[0];
/*  40 */         String str3 = field_111053_a.matcher(arrayOfString[1]).replaceAll("%$1s");
/*     */         
/*  42 */         this.field_74816_c.put(str2, str3);
/*     */       } 
/*  44 */       this.field_150511_e = System.currentTimeMillis();
/*  45 */     } catch (IOException iOException) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static StringTranslate func_74808_a() {
/*  52 */     return field_74817_a;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static synchronized void func_135063_a(Map p_135063_0_) {
/*  56 */     field_74817_a.field_74816_c.clear();
/*  57 */     field_74817_a.field_74816_c.putAll(p_135063_0_);
/*  58 */     field_74817_a.field_150511_e = System.currentTimeMillis();
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
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized String func_74805_b(String p_74805_1_) {
/*  88 */     return func_135064_c(p_74805_1_);
/*     */   }
/*     */   
/*     */   public synchronized String func_74803_a(String p_74803_1_, Object... p_74803_2_) {
/*  92 */     String str = func_135064_c(p_74803_1_);
/*     */     try {
/*  94 */       return String.format(str, p_74803_2_);
/*  95 */     } catch (IllegalFormatException illegalFormatException) {
/*  96 */       return "Format error: " + str;
/*     */     } 
/*     */   }
/*     */   
/*     */   private String func_135064_c(String p_135064_1_) {
/* 101 */     String str = (String)this.field_74816_c.get(p_135064_1_);
/* 102 */     return (str == null) ? p_135064_1_ : str;
/*     */   }
/*     */   
/*     */   public synchronized boolean func_94520_b(String p_94520_1_) {
/* 106 */     return this.field_74816_c.containsKey(p_94520_1_);
/*     */   }
/*     */   
/*     */   public long func_150510_c() {
/* 110 */     return this.field_150511_e;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\StringTranslate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */