/*     */ package net.minecraft.command;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.util.ChunkCoordinates;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldSettings;
/*     */ 
/*     */ public class PlayerSelector
/*     */ {
/*  19 */   private static final Pattern field_82389_a = Pattern.compile("^@([parf])(?:\\[([\\w=,!-]*)\\])?$");
/*  20 */   private static final Pattern field_82387_b = Pattern.compile("\\G([-!]?[\\w-]*)(?:$|,)");
/*  21 */   private static final Pattern field_82388_c = Pattern.compile("\\G(\\w+)=([-!]?[\\w-]*)(?:$|,)");
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
/*     */   private static final String __OBFID = "CL_00000086";
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
/*     */   public static EntityPlayerMP func_82386_a(ICommandSender p_82386_0_, String p_82386_1_) {
/*  44 */     EntityPlayerMP[] arrayOfEntityPlayerMP = func_82380_c(p_82386_0_, p_82386_1_);
/*     */     
/*  46 */     if (arrayOfEntityPlayerMP == null || arrayOfEntityPlayerMP.length != 1) return null;
/*     */     
/*  48 */     return arrayOfEntityPlayerMP[0];
/*     */   }
/*     */   
/*     */   public static IChatComponent func_150869_b(ICommandSender p_150869_0_, String p_150869_1_) {
/*  52 */     EntityPlayerMP[] arrayOfEntityPlayerMP = func_82380_c(p_150869_0_, p_150869_1_);
/*  53 */     if (arrayOfEntityPlayerMP == null || arrayOfEntityPlayerMP.length == 0) return null; 
/*  54 */     IChatComponent[] arrayOfIChatComponent = new IChatComponent[arrayOfEntityPlayerMP.length];
/*     */     
/*  56 */     for (byte b = 0; b < arrayOfIChatComponent.length; b++) {
/*  57 */       arrayOfIChatComponent[b] = arrayOfEntityPlayerMP[b].func_145748_c_();
/*     */     }
/*     */     
/*  60 */     return CommandBase.func_147177_a(arrayOfIChatComponent);
/*     */   }
/*     */   
/*     */   public static EntityPlayerMP[] func_82380_c(ICommandSender p_82380_0_, String p_82380_1_) {
/*  64 */     Matcher matcher = field_82389_a.matcher(p_82380_1_);
/*     */     
/*  66 */     if (matcher.matches()) {
/*  67 */       Map map1 = func_82381_h(matcher.group(2));
/*  68 */       String str1 = matcher.group(1);
/*  69 */       int i = func_82384_c(str1);
/*  70 */       int j = func_82379_d(str1);
/*  71 */       int k = func_82375_f(str1);
/*  72 */       int m = func_82376_e(str1);
/*  73 */       int n = func_82382_g(str1);
/*  74 */       int i1 = WorldSettings.GameType.NOT_SET.func_77148_a();
/*  75 */       ChunkCoordinates chunkCoordinates = p_82380_0_.func_82114_b();
/*  76 */       Map map2 = func_96560_a(map1);
/*  77 */       String str2 = null;
/*  78 */       String str3 = null;
/*  79 */       boolean bool = false;
/*     */       
/*  81 */       if (map1.containsKey("rm")) {
/*  82 */         i = MathHelper.func_82715_a((String)map1.get("rm"), i);
/*  83 */         bool = true;
/*     */       } 
/*  85 */       if (map1.containsKey("r")) {
/*  86 */         j = MathHelper.func_82715_a((String)map1.get("r"), j);
/*  87 */         bool = true;
/*     */       } 
/*  89 */       if (map1.containsKey("lm")) {
/*  90 */         k = MathHelper.func_82715_a((String)map1.get("lm"), k);
/*     */       }
/*  92 */       if (map1.containsKey("l")) {
/*  93 */         m = MathHelper.func_82715_a((String)map1.get("l"), m);
/*     */       }
/*  95 */       if (map1.containsKey("x")) {
/*  96 */         chunkCoordinates.field_71574_a = MathHelper.func_82715_a((String)map1.get("x"), chunkCoordinates.field_71574_a);
/*  97 */         bool = true;
/*     */       } 
/*  99 */       if (map1.containsKey("y")) {
/* 100 */         chunkCoordinates.field_71572_b = MathHelper.func_82715_a((String)map1.get("y"), chunkCoordinates.field_71572_b);
/* 101 */         bool = true;
/*     */       } 
/* 103 */       if (map1.containsKey("z")) {
/* 104 */         chunkCoordinates.field_71573_c = MathHelper.func_82715_a((String)map1.get("z"), chunkCoordinates.field_71573_c);
/* 105 */         bool = true;
/*     */       } 
/* 107 */       if (map1.containsKey("m")) {
/* 108 */         i1 = MathHelper.func_82715_a((String)map1.get("m"), i1);
/*     */       }
/* 110 */       if (map1.containsKey("c")) {
/* 111 */         n = MathHelper.func_82715_a((String)map1.get("c"), n);
/*     */       }
/* 113 */       if (map1.containsKey("team")) {
/* 114 */         str3 = (String)map1.get("team");
/*     */       }
/* 116 */       if (map1.containsKey("name")) {
/* 117 */         str2 = (String)map1.get("name");
/*     */       }
/*     */       
/* 120 */       World world = bool ? p_82380_0_.func_130014_f_() : null;
/*     */       
/* 122 */       if (str1.equals("p") || str1.equals("a")) {
/* 123 */         List list = MinecraftServer.func_71276_C().func_71203_ab().func_82449_a(chunkCoordinates, i, j, n, i1, k, m, map2, str2, str3, world);
/* 124 */         return list.isEmpty() ? new EntityPlayerMP[0] : (EntityPlayerMP[])list.toArray((Object[])new EntityPlayerMP[list.size()]);
/* 125 */       }  if (str1.equals("r")) {
/* 126 */         List<?> list = MinecraftServer.func_71276_C().func_71203_ab().func_82449_a(chunkCoordinates, i, j, 0, i1, k, m, map2, str2, str3, world);
/* 127 */         Collections.shuffle(list);
/* 128 */         list = list.subList(0, Math.min(n, list.size()));
/* 129 */         return list.isEmpty() ? new EntityPlayerMP[0] : list.<EntityPlayerMP>toArray(new EntityPlayerMP[list.size()]);
/*     */       } 
/* 131 */       return null;
/*     */     } 
/*     */     
/* 134 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Map func_96560_a(Map p_96560_0_) {
/* 139 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/*     */     
/* 141 */     for (String str : p_96560_0_.keySet()) {
/* 142 */       if (str.startsWith("score_") && str.length() > "score_".length()) {
/* 143 */         String str1 = str.substring("score_".length());
/* 144 */         hashMap.put(str1, Integer.valueOf(MathHelper.func_82715_a((String)p_96560_0_.get(str), 1)));
/*     */       } 
/*     */     } 
/*     */     
/* 148 */     return hashMap;
/*     */   }
/*     */   
/*     */   public static boolean func_82377_a(String p_82377_0_) {
/* 152 */     Matcher matcher = field_82389_a.matcher(p_82377_0_);
/*     */     
/* 154 */     if (matcher.matches()) {
/* 155 */       Map map = func_82381_h(matcher.group(2));
/* 156 */       String str = matcher.group(1);
/* 157 */       int i = func_82382_g(str);
/* 158 */       if (map.containsKey("c")) i = MathHelper.func_82715_a((String)map.get("c"), i); 
/* 159 */       return (i != 1);
/*     */     } 
/*     */     
/* 162 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean func_82383_a(String p_82383_0_, String p_82383_1_) {
/* 166 */     Matcher matcher = field_82389_a.matcher(p_82383_0_);
/*     */     
/* 168 */     if (matcher.matches()) {
/* 169 */       String str = matcher.group(1);
/* 170 */       if (p_82383_1_ != null && !p_82383_1_.equals(str)) return false;
/*     */       
/* 172 */       return true;
/*     */     } 
/*     */     
/* 175 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean func_82378_b(String p_82378_0_) {
/* 179 */     return func_82383_a(p_82378_0_, null);
/*     */   }
/*     */   
/*     */   private static final int func_82384_c(String p_82384_0_) {
/* 183 */     return 0;
/*     */   }
/*     */   
/*     */   private static final int func_82379_d(String p_82379_0_) {
/* 187 */     return 0;
/*     */   }
/*     */   
/*     */   private static final int func_82376_e(String p_82376_0_) {
/* 191 */     return Integer.MAX_VALUE;
/*     */   }
/*     */   
/*     */   private static final int func_82375_f(String p_82375_0_) {
/* 195 */     return 0;
/*     */   }
/*     */   
/*     */   private static final int func_82382_g(String p_82382_0_) {
/* 199 */     if (p_82382_0_.equals("a")) {
/* 200 */       return 0;
/*     */     }
/* 202 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   private static Map func_82381_h(String p_82381_0_) {
/* 207 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 208 */     if (p_82381_0_ == null) return hashMap; 
/* 209 */     Matcher matcher = field_82387_b.matcher(p_82381_0_);
/* 210 */     byte b = 0;
/* 211 */     int i = -1;
/*     */     
/* 213 */     while (matcher.find()) {
/* 214 */       String str = null;
/*     */       
/* 216 */       switch (b++) {
/*     */         case 0:
/* 218 */           str = "x";
/*     */           break;
/*     */         case 1:
/* 221 */           str = "y";
/*     */           break;
/*     */         case 2:
/* 224 */           str = "z";
/*     */           break;
/*     */         case 3:
/* 227 */           str = "r";
/*     */           break;
/*     */       } 
/*     */       
/* 231 */       if (str != null && matcher.group(1).length() > 0) hashMap.put(str, matcher.group(1)); 
/* 232 */       i = matcher.end();
/*     */     } 
/*     */     
/* 235 */     if (i < p_82381_0_.length()) {
/* 236 */       matcher = field_82388_c.matcher((i == -1) ? p_82381_0_ : p_82381_0_.substring(i));
/*     */       
/* 238 */       while (matcher.find()) {
/* 239 */         hashMap.put(matcher.group(1), matcher.group(2));
/*     */       }
/*     */     } 
/*     */     
/* 243 */     return hashMap;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\PlayerSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */