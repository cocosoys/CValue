/*     */ package net.minecraft.server.v1_7_R4;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ public class PlayerSelector {
/*   9 */   private static final Pattern a = Pattern.compile("^@([parf])(?:\\[([\\w=,!-]*)\\])?$");
/*  10 */   private static final Pattern b = Pattern.compile("\\G([-!]?[\\w-]*)(?:$|,)");
/*  11 */   private static final Pattern c = Pattern.compile("\\G(\\w+)=([-!]?[\\w-]*)(?:$|,)");
/*     */   
/*     */   public static EntityPlayer getPlayer(ICommandListener icommandlistener, String s) {
/*  14 */     EntityPlayer[] aentityplayer = getPlayers(icommandlistener, s);
/*     */     
/*  16 */     return (aentityplayer != null && aentityplayer.length == 1) ? aentityplayer[0] : null;
/*     */   }
/*     */   
/*     */   public static IChatBaseComponent getPlayerNames(ICommandListener icommandlistener, String s) {
/*  20 */     EntityPlayer[] aentityplayer = getPlayers(icommandlistener, s);
/*     */     
/*  22 */     if (aentityplayer != null && aentityplayer.length != 0) {
/*  23 */       IChatBaseComponent[] aichatbasecomponent = new IChatBaseComponent[aentityplayer.length];
/*     */       
/*  25 */       for (int i = 0; i < aichatbasecomponent.length; i++) {
/*  26 */         aichatbasecomponent[i] = aentityplayer[i].getScoreboardDisplayName();
/*     */       }
/*     */       
/*  29 */       return CommandAbstract.a(aichatbasecomponent);
/*     */     } 
/*  31 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static EntityPlayer[] getPlayers(ICommandListener icommandlistener, String s) {
/*  37 */     if (!(icommandlistener instanceof CommandBlockListenerAbstract)) {
/*  38 */       return null;
/*     */     }
/*     */ 
/*     */     
/*  42 */     Matcher matcher = a.matcher(s);
/*     */     
/*  44 */     if (matcher.matches()) {
/*  45 */       Map map = h(matcher.group(2));
/*  46 */       String s1 = matcher.group(1);
/*  47 */       int i = c(s1);
/*  48 */       int j = d(s1);
/*  49 */       int k = f(s1);
/*  50 */       int l = e(s1);
/*  51 */       int i1 = g(s1);
/*  52 */       int j1 = EnumGamemode.NONE.getId();
/*  53 */       ChunkCoordinates chunkcoordinates = icommandlistener.getChunkCoordinates();
/*  54 */       Map map1 = a(map);
/*  55 */       String s2 = null;
/*  56 */       String s3 = null;
/*  57 */       boolean flag = false;
/*     */       
/*  59 */       if (map.containsKey("rm")) {
/*  60 */         i = MathHelper.a((String)map.get("rm"), i);
/*  61 */         flag = true;
/*     */       } 
/*     */       
/*  64 */       if (map.containsKey("r")) {
/*  65 */         j = MathHelper.a((String)map.get("r"), j);
/*  66 */         flag = true;
/*     */       } 
/*     */       
/*  69 */       if (map.containsKey("lm")) {
/*  70 */         k = MathHelper.a((String)map.get("lm"), k);
/*     */       }
/*     */       
/*  73 */       if (map.containsKey("l")) {
/*  74 */         l = MathHelper.a((String)map.get("l"), l);
/*     */       }
/*     */       
/*  77 */       if (map.containsKey("x")) {
/*  78 */         chunkcoordinates.x = MathHelper.a((String)map.get("x"), chunkcoordinates.x);
/*  79 */         flag = true;
/*     */       } 
/*     */       
/*  82 */       if (map.containsKey("y")) {
/*  83 */         chunkcoordinates.y = MathHelper.a((String)map.get("y"), chunkcoordinates.y);
/*  84 */         flag = true;
/*     */       } 
/*     */       
/*  87 */       if (map.containsKey("z")) {
/*  88 */         chunkcoordinates.z = MathHelper.a((String)map.get("z"), chunkcoordinates.z);
/*  89 */         flag = true;
/*     */       } 
/*     */       
/*  92 */       if (map.containsKey("m")) {
/*  93 */         j1 = MathHelper.a((String)map.get("m"), j1);
/*     */       }
/*     */       
/*  96 */       if (map.containsKey("c")) {
/*  97 */         i1 = MathHelper.a((String)map.get("c"), i1);
/*     */       }
/*     */       
/* 100 */       if (map.containsKey("team")) {
/* 101 */         s3 = (String)map.get("team");
/*     */       }
/*     */       
/* 104 */       if (map.containsKey("name")) {
/* 105 */         s2 = (String)map.get("name");
/*     */       }
/*     */       
/* 108 */       World world = flag ? icommandlistener.getWorld() : null;
/*     */ 
/*     */       
/* 111 */       if (!s1.equals("p") && !s1.equals("a")) {
/* 112 */         if (s1.equals("r")) {
/* 113 */           List<?> list1 = MinecraftServer.getServer().getPlayerList().a(chunkcoordinates, i, j, 0, j1, k, l, map1, s2, s3, world);
/* 114 */           Collections.shuffle(list1);
/* 115 */           list1 = list1.subList(0, Math.min(i1, list1.size()));
/* 116 */           return list1.isEmpty() ? new EntityPlayer[0] : list1.<EntityPlayer>toArray(new EntityPlayer[list1.size()]);
/*     */         } 
/* 118 */         return null;
/*     */       } 
/*     */       
/* 121 */       List list = MinecraftServer.getServer().getPlayerList().a(chunkcoordinates, i, j, i1, j1, k, l, map1, s2, s3, world);
/* 122 */       return list.isEmpty() ? new EntityPlayer[0] : (EntityPlayer[])list.toArray((Object[])new EntityPlayer[list.size()]);
/*     */     } 
/*     */     
/* 125 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Map a(Map map) {
/* 130 */     HashMap<Object, Object> hashmap = new HashMap<Object, Object>();
/* 131 */     Iterator<String> iterator = map.keySet().iterator();
/*     */     
/* 133 */     while (iterator.hasNext()) {
/* 134 */       String s = iterator.next();
/*     */       
/* 136 */       if (s.startsWith("score_") && s.length() > "score_".length()) {
/* 137 */         String s1 = s.substring("score_".length());
/*     */         
/* 139 */         hashmap.put(s1, Integer.valueOf(MathHelper.a((String)map.get(s), 1)));
/*     */       } 
/*     */     } 
/*     */     
/* 143 */     return hashmap;
/*     */   }
/*     */   
/*     */   public static boolean isList(String s) {
/* 147 */     Matcher matcher = a.matcher(s);
/*     */     
/* 149 */     if (matcher.matches()) {
/* 150 */       Map map = h(matcher.group(2));
/* 151 */       String s1 = matcher.group(1);
/* 152 */       int i = g(s1);
/*     */       
/* 154 */       if (map.containsKey("c")) {
/* 155 */         i = MathHelper.a((String)map.get("c"), i);
/*     */       }
/*     */       
/* 158 */       return (i != 1);
/*     */     } 
/* 160 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isPattern(String s, String s1) {
/* 165 */     Matcher matcher = a.matcher(s);
/*     */     
/* 167 */     if (matcher.matches()) {
/* 168 */       String s2 = matcher.group(1);
/*     */       
/* 170 */       return (s1 == null || s1.equals(s2));
/*     */     } 
/* 172 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isPattern(String s) {
/* 177 */     return isPattern(s, (String)null);
/*     */   }
/*     */   
/*     */   private static final int c(String s) {
/* 181 */     return 0;
/*     */   }
/*     */   
/*     */   private static final int d(String s) {
/* 185 */     return 0;
/*     */   }
/*     */   
/*     */   private static final int e(String s) {
/* 189 */     return Integer.MAX_VALUE;
/*     */   }
/*     */   
/*     */   private static final int f(String s) {
/* 193 */     return 0;
/*     */   }
/*     */   
/*     */   private static final int g(String s) {
/* 197 */     return s.equals("a") ? 0 : 1;
/*     */   }
/*     */   
/*     */   private static Map h(String s) {
/* 201 */     HashMap<Object, Object> hashmap = new HashMap<Object, Object>();
/*     */     
/* 203 */     if (s == null) {
/* 204 */       return hashmap;
/*     */     }
/* 206 */     Matcher matcher = b.matcher(s);
/* 207 */     int i = 0;
/*     */     
/*     */     int j;
/*     */     
/* 211 */     for (j = -1; matcher.find(); j = matcher.end()) {
/* 212 */       String s1 = null;
/*     */       
/* 214 */       switch (i++) {
/*     */         case 0:
/* 216 */           s1 = "x";
/*     */           break;
/*     */         
/*     */         case 1:
/* 220 */           s1 = "y";
/*     */           break;
/*     */         
/*     */         case 2:
/* 224 */           s1 = "z";
/*     */           break;
/*     */         
/*     */         case 3:
/* 228 */           s1 = "r";
/*     */           break;
/*     */       } 
/* 231 */       if (s1 != null && matcher.group(1).length() > 0) {
/* 232 */         hashmap.put(s1, matcher.group(1));
/*     */       }
/*     */     } 
/*     */     
/* 236 */     if (j < s.length()) {
/* 237 */       matcher = c.matcher((j == -1) ? s : s.substring(j));
/*     */       
/* 239 */       while (matcher.find()) {
/* 240 */         hashmap.put(matcher.group(1), matcher.group(2));
/*     */       }
/*     */     } 
/*     */     
/* 244 */     return hashmap;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PlayerSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */