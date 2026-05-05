/*     */ package net.minecraft.server.management;
/*     */ import com.google.common.base.Charsets;
/*     */ import com.google.common.base.Predicate;
/*     */ import com.google.common.collect.Iterators;
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.collect.Maps;
/*     */ import com.google.common.io.Files;
/*     */ import com.mojang.authlib.GameProfile;
/*     */ import com.mojang.authlib.ProfileLookupCallback;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.server.dedicated.DedicatedServer;
/*     */ import net.minecraft.server.dedicated.PropertyManager;
/*     */ import net.minecraft.util.StringUtils;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ 
/*     */ public class PreYggdrasilConverter {
/*  31 */   private static final Logger field_152732_e = LogManager.getLogger();
/*  32 */   public static final File field_152728_a = new File("banned-ips.txt");
/*  33 */   public static final File field_152729_b = new File("banned-players.txt");
/*  34 */   public static final File field_152730_c = new File("ops.txt");
/*  35 */   public static final File field_152731_d = new File("white-list.txt"); private static final String __OBFID = "CL_00001882";
/*     */   @SideOnly(Side.SERVER)
/*     */   static List func_152721_a(File p_152721_0_, Map<String, String[]> p_152721_1_) throws IOException {
/*  38 */     List list = Files.readLines(p_152721_0_, Charsets.UTF_8);
/*  39 */     for (String str : list) {
/*  40 */       str = str.trim();
/*  41 */       if (str.startsWith("#") || str.length() < 1) {
/*     */         continue;
/*     */       }
/*  44 */       String[] arrayOfString = str.split("\\|");
/*  45 */       p_152721_1_.put(arrayOfString[0].toLowerCase(Locale.ROOT), arrayOfString);
/*     */     } 
/*  47 */     return list;
/*     */   }
/*     */   
/*     */   private static void func_152717_a(MinecraftServer p_152717_0_, Collection p_152717_1_, ProfileLookupCallback p_152717_2_) {
/*  51 */     String[] arrayOfString = (String[])Iterators.toArray((Iterator)Iterators.filter(p_152717_1_.iterator(), new Predicate() { private static final String __OBFID = "CL_00001881";
/*     */             
/*     */             public boolean func_152733_a(String p_152733_1_) {
/*  54 */               return !StringUtils.func_151246_b(p_152733_1_);
/*     */             } }
/*     */         ), String.class);
/*  57 */     if (p_152717_0_.func_71266_T()) {
/*  58 */       p_152717_0_.func_152359_aw().findProfilesByNames(arrayOfString, Agent.MINECRAFT, p_152717_2_);
/*     */     } else {
/*  60 */       for (String str : arrayOfString) {
/*  61 */         UUID uUID = EntityPlayer.func_146094_a(new GameProfile(null, str));
/*  62 */         GameProfile gameProfile = new GameProfile(uUID, str);
/*  63 */         p_152717_2_.onProfileLookupSucceeded(gameProfile);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   @SideOnly(Side.SERVER)
/*     */   public static boolean func_152724_a(MinecraftServer p_152724_0_) throws IOException {
/*  69 */     UserListBans userListBans = new UserListBans(ServerConfigurationManager.field_152613_a);
/*  70 */     if (field_152729_b.exists() && field_152729_b.isFile()) {
/*  71 */       if (userListBans.func_152691_c().exists()) {
/*     */         try {
/*  73 */           userListBans.func_152679_g();
/*  74 */         } catch (FileNotFoundException fileNotFoundException) {
/*  75 */           field_152732_e.warn("Could not load existing file " + userListBans.func_152691_c().getName(), fileNotFoundException);
/*     */         } 
/*     */       }
/*     */       try {
/*  79 */         HashMap hashMap = Maps.newHashMap();
/*  80 */         func_152721_a(field_152729_b, hashMap);
/*     */         
/*  82 */         ProfileLookupCallback profileLookupCallback = new ProfileLookupCallback(p_152724_0_, hashMap, userListBans) { private static final String __OBFID = "CL_00001910";
/*     */             
/*     */             public void onProfileLookupSucceeded(GameProfile p_onProfileLookupSucceeded_1_) {
/*  85 */               this.field_152734_a.func_152358_ax().func_152649_a(p_onProfileLookupSucceeded_1_);
/*  86 */               String[] arrayOfString = (String[])this.field_152735_b.get(p_onProfileLookupSucceeded_1_.getName().toLowerCase(Locale.ROOT));
/*  87 */               if (arrayOfString == null) {
/*  88 */                 PreYggdrasilConverter.field_152732_e.warn("Could not convert user banlist entry for " + p_onProfileLookupSucceeded_1_.getName());
/*  89 */                 throw new PreYggdrasilConverter.ConversionError("Profile not in the conversionlist");
/*     */               } 
/*     */               
/*  92 */               Date date1 = (arrayOfString.length > 1) ? PreYggdrasilConverter.func_152713_b(arrayOfString[1], null) : null;
/*  93 */               String str1 = (arrayOfString.length > 2) ? arrayOfString[2] : null;
/*  94 */               Date date2 = (arrayOfString.length > 3) ? PreYggdrasilConverter.func_152713_b(arrayOfString[3], null) : null;
/*  95 */               String str2 = (arrayOfString.length > 4) ? arrayOfString[4] : null;
/*  96 */               this.field_152736_c.func_152687_a(new UserListBansEntry(p_onProfileLookupSucceeded_1_, date1, str1, date2, str2));
/*     */             }
/*     */ 
/*     */             
/*     */             public void onProfileLookupFailed(GameProfile p_onProfileLookupFailed_1_, Exception p_onProfileLookupFailed_2_) {
/* 101 */               PreYggdrasilConverter.field_152732_e.warn("Could not lookup user banlist entry for " + p_onProfileLookupFailed_1_.getName(), p_onProfileLookupFailed_2_);
/* 102 */               if (!(p_onProfileLookupFailed_2_ instanceof com.mojang.authlib.yggdrasil.ProfileNotFoundException)) {
/* 103 */                 throw new PreYggdrasilConverter.ConversionError("Could not request user " + p_onProfileLookupFailed_1_.getName() + " from backend systems", p_onProfileLookupFailed_2_);
/*     */               }
/*     */             } }
/*     */           ;
/* 107 */         func_152717_a(p_152724_0_, hashMap.keySet(), profileLookupCallback);
/* 108 */         userListBans.func_152678_f();
/* 109 */         func_152727_c(field_152729_b);
/* 110 */       } catch (IOException iOException) {
/* 111 */         field_152732_e.warn("Could not read old user banlist to convert it!", iOException);
/* 112 */         return false;
/* 113 */       } catch (ConversionError conversionError) {
/* 114 */         field_152732_e.error("Conversion failed, please try again later", conversionError);
/* 115 */         return false;
/*     */       } 
/* 117 */       return true;
/*     */     } 
/* 119 */     return true;
/*     */   }
/*     */   @SideOnly(Side.SERVER)
/*     */   public static boolean func_152722_b(MinecraftServer p_152722_0_) throws IOException {
/* 123 */     BanList banList = new BanList(ServerConfigurationManager.field_152614_b);
/* 124 */     if (field_152728_a.exists() && field_152728_a.isFile()) {
/* 125 */       if (banList.func_152691_c().exists()) {
/*     */         try {
/* 127 */           banList.func_152679_g();
/* 128 */         } catch (FileNotFoundException fileNotFoundException) {
/* 129 */           field_152732_e.warn("Could not load existing file " + banList.func_152691_c().getName(), fileNotFoundException);
/*     */         } 
/*     */       }
/*     */       try {
/* 133 */         HashMap hashMap = Maps.newHashMap();
/* 134 */         func_152721_a(field_152728_a, hashMap);
/*     */         
/* 136 */         for (String str1 : hashMap.keySet()) {
/* 137 */           String[] arrayOfString = (String[])hashMap.get(str1);
/* 138 */           Date date1 = (arrayOfString.length > 1) ? func_152713_b(arrayOfString[1], null) : null;
/* 139 */           String str2 = (arrayOfString.length > 2) ? arrayOfString[2] : null;
/* 140 */           Date date2 = (arrayOfString.length > 3) ? func_152713_b(arrayOfString[3], null) : null;
/* 141 */           String str3 = (arrayOfString.length > 4) ? arrayOfString[4] : null;
/* 142 */           banList.func_152687_a(new IPBanEntry(str1, date1, str2, date2, str3));
/*     */         } 
/* 144 */         banList.func_152678_f();
/* 145 */         func_152727_c(field_152728_a);
/* 146 */       } catch (IOException iOException) {
/* 147 */         field_152732_e.warn("Could not parse old ip banlist to convert it!", iOException);
/* 148 */         return false;
/*     */       } 
/* 150 */       return true;
/*     */     } 
/* 152 */     return true;
/*     */   }
/*     */   @SideOnly(Side.SERVER)
/*     */   public static boolean func_152718_c(MinecraftServer p_152718_0_) throws IOException {
/* 156 */     UserListOps userListOps = new UserListOps(ServerConfigurationManager.field_152615_c);
/* 157 */     if (field_152730_c.exists() && field_152730_c.isFile()) {
/* 158 */       if (userListOps.func_152691_c().exists()) {
/*     */         try {
/* 160 */           userListOps.func_152679_g();
/* 161 */         } catch (FileNotFoundException fileNotFoundException) {
/* 162 */           field_152732_e.warn("Could not load existing file " + userListOps.func_152691_c().getName(), fileNotFoundException);
/*     */         } 
/*     */       }
/*     */       try {
/* 166 */         List list = Files.readLines(field_152730_c, Charsets.UTF_8);
/* 167 */         ProfileLookupCallback profileLookupCallback = new ProfileLookupCallback(p_152718_0_, userListOps) { private static final String __OBFID = "CL_00001909";
/*     */             
/*     */             public void onProfileLookupSucceeded(GameProfile p_onProfileLookupSucceeded_1_) {
/* 170 */               this.field_152737_a.func_152358_ax().func_152649_a(p_onProfileLookupSucceeded_1_);
/* 171 */               this.field_152738_b.func_152687_a(new UserListOpsEntry(p_onProfileLookupSucceeded_1_, this.field_152737_a.func_110455_j()));
/*     */             }
/*     */ 
/*     */             
/*     */             public void onProfileLookupFailed(GameProfile p_onProfileLookupFailed_1_, Exception p_onProfileLookupFailed_2_) {
/* 176 */               PreYggdrasilConverter.field_152732_e.warn("Could not lookup oplist entry for " + p_onProfileLookupFailed_1_.getName(), p_onProfileLookupFailed_2_);
/* 177 */               if (!(p_onProfileLookupFailed_2_ instanceof com.mojang.authlib.yggdrasil.ProfileNotFoundException)) {
/* 178 */                 throw new PreYggdrasilConverter.ConversionError("Could not request user " + p_onProfileLookupFailed_1_.getName() + " from backend systems", p_onProfileLookupFailed_2_);
/*     */               }
/*     */             } }
/*     */           ;
/* 182 */         func_152717_a(p_152718_0_, list, profileLookupCallback);
/* 183 */         userListOps.func_152678_f();
/* 184 */         func_152727_c(field_152730_c);
/* 185 */       } catch (IOException iOException) {
/* 186 */         field_152732_e.warn("Could not read old oplist to convert it!", iOException);
/* 187 */         return false;
/* 188 */       } catch (ConversionError conversionError) {
/* 189 */         field_152732_e.error("Conversion failed, please try again later", conversionError);
/* 190 */         return false;
/*     */       } 
/* 192 */       return true;
/*     */     } 
/* 194 */     return true;
/*     */   }
/*     */   @SideOnly(Side.SERVER)
/*     */   public static boolean func_152710_d(MinecraftServer p_152710_0_) throws IOException {
/* 198 */     UserListWhitelist userListWhitelist = new UserListWhitelist(ServerConfigurationManager.field_152616_d);
/* 199 */     if (field_152731_d.exists() && field_152731_d.isFile()) {
/* 200 */       if (userListWhitelist.func_152691_c().exists()) {
/*     */         try {
/* 202 */           userListWhitelist.func_152679_g();
/* 203 */         } catch (FileNotFoundException fileNotFoundException) {
/* 204 */           field_152732_e.warn("Could not load existing file " + userListWhitelist.func_152691_c().getName(), fileNotFoundException);
/*     */         } 
/*     */       }
/*     */       try {
/* 208 */         List list = Files.readLines(field_152731_d, Charsets.UTF_8);
/* 209 */         ProfileLookupCallback profileLookupCallback = new ProfileLookupCallback(p_152710_0_, userListWhitelist) { private static final String __OBFID = "CL_00001908";
/*     */             
/*     */             public void onProfileLookupSucceeded(GameProfile p_onProfileLookupSucceeded_1_) {
/* 212 */               this.field_152739_a.func_152358_ax().func_152649_a(p_onProfileLookupSucceeded_1_);
/* 213 */               this.field_152740_b.func_152687_a(new UserListWhitelistEntry(p_onProfileLookupSucceeded_1_));
/*     */             }
/*     */ 
/*     */             
/*     */             public void onProfileLookupFailed(GameProfile p_onProfileLookupFailed_1_, Exception p_onProfileLookupFailed_2_) {
/* 218 */               PreYggdrasilConverter.field_152732_e.warn("Could not lookup user whitelist entry for " + p_onProfileLookupFailed_1_.getName(), p_onProfileLookupFailed_2_);
/* 219 */               if (!(p_onProfileLookupFailed_2_ instanceof com.mojang.authlib.yggdrasil.ProfileNotFoundException)) {
/* 220 */                 throw new PreYggdrasilConverter.ConversionError("Could not request user " + p_onProfileLookupFailed_1_.getName() + " from backend systems", p_onProfileLookupFailed_2_);
/*     */               }
/*     */             } }
/*     */           ;
/* 224 */         func_152717_a(p_152710_0_, list, profileLookupCallback);
/* 225 */         userListWhitelist.func_152678_f();
/* 226 */         func_152727_c(field_152731_d);
/* 227 */       } catch (IOException iOException) {
/* 228 */         field_152732_e.warn("Could not read old whitelist to convert it!", iOException);
/* 229 */         return false;
/* 230 */       } catch (ConversionError conversionError) {
/* 231 */         field_152732_e.error("Conversion failed, please try again later", conversionError);
/* 232 */         return false;
/*     */       } 
/* 234 */       return true;
/*     */     } 
/* 236 */     return true;
/*     */   }
/*     */   
/*     */   public static String func_152719_a(String p_152719_0_) {
/* 240 */     if (StringUtils.func_151246_b(p_152719_0_) || p_152719_0_.length() > 16) {
/* 241 */       return p_152719_0_;
/*     */     }
/* 243 */     MinecraftServer minecraftServer = MinecraftServer.func_71276_C();
/* 244 */     GameProfile gameProfile = minecraftServer.func_152358_ax().func_152655_a(p_152719_0_);
/* 245 */     if (gameProfile != null && gameProfile.getId() != null) {
/* 246 */       return gameProfile.getId().toString();
/*     */     }
/* 248 */     if (minecraftServer.func_71264_H() || !minecraftServer.func_71266_T()) {
/* 249 */       return EntityPlayer.func_146094_a(new GameProfile(null, p_152719_0_)).toString();
/*     */     }
/* 251 */     ArrayList<GameProfile> arrayList = Lists.newArrayList();
/* 252 */     ProfileLookupCallback profileLookupCallback = new ProfileLookupCallback(minecraftServer, arrayList) { private static final String __OBFID = "CL_00001880";
/*     */         
/*     */         public void onProfileLookupSucceeded(GameProfile p_onProfileLookupSucceeded_1_) {
/* 255 */           this.field_152741_a.func_152358_ax().func_152649_a(p_onProfileLookupSucceeded_1_);
/* 256 */           this.field_152742_b.add(p_onProfileLookupSucceeded_1_);
/*     */         }
/*     */ 
/*     */         
/*     */         public void onProfileLookupFailed(GameProfile p_onProfileLookupFailed_1_, Exception p_onProfileLookupFailed_2_) {
/* 261 */           PreYggdrasilConverter.field_152732_e.warn("Could not lookup user whitelist entry for " + p_onProfileLookupFailed_1_.getName(), p_onProfileLookupFailed_2_);
/*     */         } }
/*     */       ;
/* 264 */     func_152717_a(minecraftServer, Lists.newArrayList((Object[])new String[] { p_152719_0_ }, ), profileLookupCallback);
/* 265 */     if (arrayList.size() > 0 && ((GameProfile)arrayList.get(0)).getId() != null) {
/* 266 */       return ((GameProfile)arrayList.get(0)).getId().toString();
/*     */     }
/*     */     
/* 269 */     return "";
/*     */   }
/*     */   @SideOnly(Side.SERVER)
/*     */   static class ConversionError extends RuntimeException { private static final String __OBFID = "CL_00001905";
/*     */     private ConversionError(String p_i1206_1_, Throwable p_i1206_2_) {
/* 274 */       super(p_i1206_1_, p_i1206_2_);
/*     */     }
/*     */     
/*     */     private ConversionError(String p_i1207_1_) {
/* 278 */       super(p_i1207_1_);
/*     */     } }
/*     */   
/*     */   @SideOnly(Side.SERVER)
/*     */   public static boolean func_152723_a(DedicatedServer p_152723_0_, PropertyManager p_152723_1_) {
/* 283 */     File file1 = func_152725_d(p_152723_1_);
/* 284 */     File file2 = new File(file1.getParentFile(), "playerdata");
/* 285 */     File file3 = new File(file1.getParentFile(), "unknownplayers");
/* 286 */     if (!file1.exists() || !file1.isDirectory()) {
/* 287 */       return true;
/*     */     }
/* 289 */     File[] arrayOfFile = file1.listFiles();
/* 290 */     ArrayList<String> arrayList = Lists.newArrayList();
/* 291 */     for (File file : arrayOfFile) {
/* 292 */       String str = file.getName();
/* 293 */       if (str.toLowerCase(Locale.ROOT).endsWith(".dat")) {
/*     */ 
/*     */         
/* 296 */         String str1 = str.substring(0, str.length() - ".dat".length());
/* 297 */         if (str1.length() > 0) {
/* 298 */           arrayList.add(str1);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     try {
/* 303 */       String[] arrayOfString = arrayList.<String>toArray(new String[arrayList.size()]);
/* 304 */       ProfileLookupCallback profileLookupCallback = new ProfileLookupCallback(p_152723_0_, file2, file3, file1, arrayOfString) { private static final String __OBFID = "CL_00001907";
/*     */           
/*     */           public void onProfileLookupSucceeded(GameProfile p_onProfileLookupSucceeded_1_) {
/* 307 */             this.field_152745_a.func_152358_ax().func_152649_a(p_onProfileLookupSucceeded_1_);
/* 308 */             UUID uUID = p_onProfileLookupSucceeded_1_.getId();
/* 309 */             if (uUID == null) {
/* 310 */               throw new PreYggdrasilConverter.ConversionError("Missing UUID for user profile " + p_onProfileLookupSucceeded_1_.getName());
/*     */             }
/* 312 */             func_152743_a(this.field_152746_b, func_152744_a(p_onProfileLookupSucceeded_1_), uUID.toString());
/*     */           }
/*     */ 
/*     */           
/*     */           public void onProfileLookupFailed(GameProfile p_onProfileLookupFailed_1_, Exception p_onProfileLookupFailed_2_) {
/* 317 */             PreYggdrasilConverter.field_152732_e.warn("Could not lookup user uuid for " + p_onProfileLookupFailed_1_.getName(), p_onProfileLookupFailed_2_);
/* 318 */             if (p_onProfileLookupFailed_2_ instanceof com.mojang.authlib.yggdrasil.ProfileNotFoundException) {
/* 319 */               String str = func_152744_a(p_onProfileLookupFailed_1_);
/* 320 */               func_152743_a(this.field_152747_c, str, str);
/*     */             } else {
/* 322 */               throw new PreYggdrasilConverter.ConversionError("Could not request user " + p_onProfileLookupFailed_1_.getName() + " from backend systems", p_onProfileLookupFailed_2_);
/*     */             } 
/*     */           }
/*     */           
/*     */           private void func_152743_a(File p_152743_1_, String p_152743_2_, String p_152743_3_) {
/* 327 */             File file1 = new File(this.field_152748_d, p_152743_2_ + ".dat");
/* 328 */             File file2 = new File(p_152743_1_, p_152743_3_ + ".dat");
/* 329 */             PreYggdrasilConverter.func_152711_b(p_152743_1_);
/* 330 */             if (!file1.renameTo(file2)) {
/* 331 */               throw new PreYggdrasilConverter.ConversionError("Could not convert file for " + p_152743_2_);
/*     */             }
/*     */           }
/*     */           
/*     */           private String func_152744_a(GameProfile p_152744_1_) {
/* 336 */             String str = null;
/* 337 */             for (byte b = 0; b < this.field_152749_e.length; b++) {
/* 338 */               if (this.field_152749_e[b] != null && this.field_152749_e[b].equalsIgnoreCase(p_152744_1_.getName())) {
/* 339 */                 str = this.field_152749_e[b];
/*     */                 break;
/*     */               } 
/*     */             } 
/* 343 */             if (str == null) {
/* 344 */               throw new PreYggdrasilConverter.ConversionError("Could not find the filename for " + p_152744_1_.getName() + " anymore");
/*     */             }
/* 346 */             return str;
/*     */           } }
/*     */         ;
/* 349 */       func_152717_a((MinecraftServer)p_152723_0_, Lists.newArrayList((Object[])arrayOfString), profileLookupCallback);
/* 350 */     } catch (ConversionError conversionError) {
/* 351 */       field_152732_e.error("Conversion failed, please try again later", conversionError);
/* 352 */       return false;
/*     */     } 
/*     */     
/* 355 */     return true;
/*     */   }
/*     */   @SideOnly(Side.SERVER)
/*     */   private static void func_152711_b(File p_152711_0_) {
/* 359 */     if (p_152711_0_.exists()) {
/* 360 */       if (p_152711_0_.isDirectory()) {
/*     */         return;
/*     */       }
/* 363 */       throw new ConversionError("Can't create directory " + p_152711_0_.getName() + " in world save directory.");
/*     */     } 
/*     */     
/* 366 */     if (!p_152711_0_.mkdirs()) {
/* 367 */       throw new ConversionError("Can't create directory " + p_152711_0_.getName() + " in world save directory.");
/*     */     }
/*     */   }
/*     */   
/*     */   @SideOnly(Side.SERVER)
/*     */   public static boolean func_152714_a(PropertyManager p_152714_0_) {
/* 373 */     boolean bool = func_152712_b(p_152714_0_);
/* 374 */     bool = (bool && func_152715_c(p_152714_0_));
/* 375 */     return bool;
/*     */   }
/*     */   @SideOnly(Side.SERVER)
/*     */   private static boolean func_152712_b(PropertyManager p_152712_0_) {
/* 379 */     boolean bool1 = false;
/* 380 */     if (field_152729_b.exists() && field_152729_b.isFile()) {
/* 381 */       bool1 = true;
/*     */     }
/* 383 */     boolean bool2 = false;
/* 384 */     if (field_152728_a.exists() && field_152728_a.isFile()) {
/* 385 */       bool2 = true;
/*     */     }
/* 387 */     boolean bool3 = false;
/* 388 */     if (field_152730_c.exists() && field_152730_c.isFile()) {
/* 389 */       bool3 = true;
/*     */     }
/* 391 */     boolean bool4 = false;
/* 392 */     if (field_152731_d.exists() && field_152731_d.isFile()) {
/* 393 */       bool4 = true;
/*     */     }
/*     */     
/* 396 */     if (bool1 || bool2 || bool3 || bool4) {
/* 397 */       field_152732_e.warn("**** FAILED TO START THE SERVER AFTER ACCOUNT CONVERSION!");
/* 398 */       field_152732_e.warn("** please remove the following files and restart the server:");
/* 399 */       if (bool1) {
/* 400 */         field_152732_e.warn("* " + field_152729_b.getName());
/*     */       }
/* 402 */       if (bool2) {
/* 403 */         field_152732_e.warn("* " + field_152728_a.getName());
/*     */       }
/* 405 */       if (bool3) {
/* 406 */         field_152732_e.warn("* " + field_152730_c.getName());
/*     */       }
/* 408 */       if (bool4) {
/* 409 */         field_152732_e.warn("* " + field_152731_d.getName());
/*     */       }
/* 411 */       return false;
/*     */     } 
/* 413 */     return true;
/*     */   }
/*     */   @SideOnly(Side.SERVER)
/*     */   private static boolean func_152715_c(PropertyManager p_152715_0_) {
/* 417 */     File file = func_152725_d(p_152715_0_);
/* 418 */     if (file.exists() && file.isDirectory()) {
/* 419 */       String[] arrayOfString = file.list(new FilenameFilter() { private static final String __OBFID = "CL_00001906";
/*     */             
/*     */             public boolean accept(File p_accept_1_, String p_accept_2_) {
/* 422 */               return p_accept_2_.endsWith(".dat");
/*     */             } }
/*     */         );
/* 425 */       if (arrayOfString.length > 0) {
/* 426 */         field_152732_e.warn("**** DETECTED OLD PLAYER FILES IN THE WORLD SAVE");
/* 427 */         field_152732_e.warn("**** THIS USUALLY HAPPENS WHEN THE AUTOMATIC CONVERSION FAILED IN SOME WAY");
/* 428 */         field_152732_e.warn("** please restart the server and if the problem persists, remove the directory '{}'", new Object[] { file.getPath() });
/* 429 */         return false;
/*     */       } 
/*     */     } 
/* 432 */     return true;
/*     */   }
/*     */   @SideOnly(Side.SERVER)
/*     */   private static File func_152725_d(PropertyManager p_152725_0_) {
/* 436 */     String str = p_152725_0_.func_73671_a("level-name", "world");
/* 437 */     File file = new File(str);
/* 438 */     return new File(file, "players");
/*     */   }
/*     */   @SideOnly(Side.SERVER)
/*     */   private static void func_152727_c(File p_152727_0_) {
/* 442 */     File file = new File(p_152727_0_.getName() + ".converted");
/* 443 */     p_152727_0_.renameTo(file);
/*     */   }
/*     */   @SideOnly(Side.SERVER)
/*     */   private static Date func_152713_b(String p_152713_0_, Date p_152713_1_) {
/*     */     Date date;
/*     */     try {
/* 449 */       date = BanEntry.field_73698_a.parse(p_152713_0_);
/* 450 */     } catch (ParseException parseException) {
/* 451 */       date = p_152713_1_;
/*     */     } 
/* 453 */     return date;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\server\management\PreYggdrasilConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */