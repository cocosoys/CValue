/*     */ package net.minecraft.client.resources;
/*     */ 
/*     */ import com.google.common.base.Splitter;
/*     */ import com.google.common.collect.Iterables;
/*     */ import com.google.common.collect.Maps;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.IllegalFormatException;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.regex.Pattern;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.apache.commons.io.Charsets;
/*     */ import org.apache.commons.io.IOUtils;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class Locale {
/*  20 */   private static final Splitter field_135030_b = Splitter.on('=').limit(2);
/*  21 */   private static final Pattern field_135031_c = Pattern.compile("%(\\d+\\$)?[\\d\\.]*[df]");
/*     */ 
/*     */   
/*  24 */   Map field_135032_a = Maps.newHashMap();
/*     */   private boolean field_135029_d;
/*     */   
/*     */   public synchronized void func_135022_a(IResourceManager p_135022_1_, List p_135022_2_) {
/*  28 */     this.field_135032_a.clear();
/*     */     
/*  30 */     for (String str1 : p_135022_2_) {
/*  31 */       String str2 = String.format("lang/%s.lang", new Object[] { str1 });
/*     */       
/*  33 */       for (String str : p_135022_1_.func_135055_a()) {
/*     */         try {
/*  35 */           func_135028_a(p_135022_1_.func_135056_b(new ResourceLocation(str, str2)));
/*  36 */         } catch (IOException iOException) {}
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  41 */     func_135024_b();
/*     */   }
/*     */   private static final String __OBFID = "CL_00001097";
/*     */   public boolean func_135025_a() {
/*  45 */     return this.field_135029_d;
/*     */   }
/*     */   
/*     */   private void func_135024_b() {
/*  49 */     this.field_135029_d = false;
/*     */     
/*  51 */     byte b = 0;
/*  52 */     int i = 0;
/*     */     
/*  54 */     for (String str : this.field_135032_a.values()) {
/*  55 */       int j = str.length();
/*  56 */       i += j;
/*     */       
/*  58 */       for (byte b1 = 0; b1 < j; b1++) {
/*  59 */         if (str.charAt(b1) >= 'Ā') {
/*  60 */           b++;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  65 */     float f = b / i;
/*  66 */     this.field_135029_d = (f > 0.1D);
/*     */   }
/*     */   
/*     */   private void func_135028_a(List p_135028_1_) throws IOException {
/*  70 */     for (IResource iResource : p_135028_1_) {
/*  71 */       func_135021_a(iResource.func_110527_b());
/*     */     }
/*     */   }
/*     */   
/*     */   private void func_135021_a(InputStream p_135021_1_) throws IOException {
/*  76 */     for (String str1 : IOUtils.readLines(p_135021_1_, Charsets.UTF_8)) {
/*     */       
/*  78 */       if (str1.isEmpty() || str1.charAt(0) == '#')
/*     */         continue; 
/*  80 */       String[] arrayOfString = (String[])Iterables.toArray(field_135030_b.split(str1), String.class);
/*     */ 
/*     */       
/*  83 */       if (arrayOfString == null || arrayOfString.length != 2) {
/*     */         continue;
/*     */       }
/*     */ 
/*     */       
/*  88 */       String str2 = arrayOfString[0];
/*  89 */       String str3 = field_135031_c.matcher(arrayOfString[1]).replaceAll("%$1s");
/*     */       
/*  91 */       this.field_135032_a.put(str2, str3);
/*     */     } 
/*     */   }
/*     */   
/*     */   private String func_135026_c(String p_135026_1_) {
/*  96 */     String str = (String)this.field_135032_a.get(p_135026_1_);
/*  97 */     return (str == null) ? p_135026_1_ : str;
/*     */   }
/*     */   
/*     */   public String func_135023_a(String p_135023_1_, Object[] p_135023_2_) {
/* 101 */     String str = func_135026_c(p_135023_1_);
/*     */     try {
/* 103 */       return String.format(str, p_135023_2_);
/* 104 */     } catch (IllegalFormatException illegalFormatException) {
/* 105 */       return "Format error: " + str;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\resources\Locale.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */