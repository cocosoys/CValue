/*     */ package org.bukkit.craftbukkit;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import net.minecraft.server.v1_7_R4.MinecraftServer;
/*     */ import org.bukkit.craftbukkit.libs.jline.UnsupportedTerminal;
/*     */ import org.bukkit.craftbukkit.libs.joptsimple.OptionException;
/*     */ import org.bukkit.craftbukkit.libs.joptsimple.OptionParser;
/*     */ import org.bukkit.craftbukkit.libs.joptsimple.OptionSet;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.CraftServer;
/*     */ 
/*     */ public class Main {
/*     */   public static boolean useJline = true;
/*     */   
/*     */   public static void main(String[] args) {
/*  20 */     OptionParser parser = new OptionParser()
/*     */       {
/*     */       
/*     */       };
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
/* 119 */     OptionSet options = null;
/*     */     
/*     */     try {
/* 122 */       options = parser.parse(args);
/* 123 */     } catch (OptionException ex) {
/* 124 */       Logger.getLogger(Main.class.getName()).log(Level.SEVERE, ex.getLocalizedMessage());
/*     */     } 
/*     */     
/* 127 */     if (options == null || options.has("?")) {
/*     */       try {
/* 129 */         parser.printHelpOn(System.out);
/* 130 */       } catch (IOException ex) {
/* 131 */         Logger.getLogger(Main.class.getName()).log(Level.SEVERE, (String)null, ex);
/*     */       } 
/* 133 */     } else if (options.has("v")) {
/* 134 */       System.out.println(CraftServer.class.getPackage().getImplementationVersion());
/*     */     } else {
/*     */       
/*     */       try {
/* 138 */         String jline_UnsupportedTerminal = new String(new char[] { 'j', 'l', 'i', 'n', 'e', '.', 'U', 'n', 's', 'u', 'p', 'p', 'o', 'r', 't', 'e', 'd', 'T', 'e', 'r', 'm', 'i', 'n', 'a', 'l' });
/* 139 */         String jline_terminal = new String(new char[] { 'j', 'l', 'i', 'n', 'e', '.', 't', 'e', 'r', 'm', 'i', 'n', 'a', 'l' });
/*     */         
/* 141 */         useJline = !jline_UnsupportedTerminal.equals(System.getProperty(jline_terminal));
/*     */         
/* 143 */         if (options.has("nojline")) {
/* 144 */           System.setProperty("user.language", "en");
/* 145 */           useJline = false;
/*     */         } 
/*     */         
/* 148 */         if (!useJline)
/*     */         {
/* 150 */           System.setProperty("org.bukkit.craftbukkit.libs.jline.terminal", UnsupportedTerminal.class.getName());
/*     */         }
/*     */ 
/*     */         
/* 154 */         if (options.has("noconsole")) {
/* 155 */           useConsole = false;
/*     */         }
/*     */         
/* 158 */         System.out.println("Loading libraries, please wait...");
/* 159 */         MinecraftServer.main(options);
/* 160 */       } catch (Throwable t) {
/* 161 */         t.printStackTrace();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   public static boolean useConsole = true;
/*     */   private static List<String> asList(String... params) {
/* 167 */     return Arrays.asList(params);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\craftbukkit\Main.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */