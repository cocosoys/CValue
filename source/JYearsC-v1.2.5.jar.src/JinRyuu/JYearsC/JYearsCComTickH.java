/*     */ package JinRyuu.JYearsC;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.JYearsCH;
/*     */ import JinRyuu.JRMCore.p.PD;
/*     */ import JinRyuu.JRMCore.p.YC.JYearsCP;
/*     */ import JinRyuu.JRMCore.p.YC.JYearsCPData;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*     */ import cpw.mods.fml.common.gameevent.TickEvent;
/*     */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.world.WorldServer;
/*     */ 
/*     */ public class JYearsCComTickH
/*     */ {
/*     */   boolean charge = false;
/*     */   EntityPlayer player;
/*  26 */   private int tick = 0;
/*  27 */   private String date = "";
/*  28 */   private int tccb = 0;
/*     */   
/*  30 */   private static int[] mid = JYearsCH.mID;
/*  31 */   public static String[] dm = JYearsCH.dayNames;
/*  32 */   public static String[] mn = JYearsCH.monthNames;
/*     */   
/*     */   private static int m(MinecraftServer server, int m, int y) {
/*  35 */     m = (m + 1 == 4) ? y(server, y) : (m + 1);
/*  36 */     JYearsCH.wcd(server, m + "", "m", false);
/*  37 */     return 0;
/*     */   }
/*     */   
/*     */   private static int y(MinecraftServer server, int y) {
/*  41 */     y = (y > 1000000) ? 0 : (y + 1);
/*  42 */     JYearsCH.wcd(server, y + "", "y", false);
/*  43 */     return 0;
/*     */   }
/*  45 */   public static String[] datnc0 = null;
/*     */   
/*     */   public void serverTick(MinecraftServer server) {
/*  48 */     WorldServer dim0 = server.func_71218_a(0);
/*  49 */     int cur = server.func_71233_x();
/*  50 */     if (datnc0 == null || datnc0.length != cur) datnc0 = new String[cur]; 
/*  51 */     if (cur == 0 && sentDatnc0 != null) {
/*  52 */       sentDatnc0 = null; datnc0 = null;
/*     */     } 
/*     */     
/*  55 */     for (int pl = 0; pl < cur; pl++) {
/*  56 */       EntityPlayerMP p = server.func_71203_ab().func_152612_a(server.func_71213_z()[pl]);
/*  57 */       if (this.tick == ((cur > 100) ? (int)(pl - 100.0F * pl / 100.0F) : (int)(100.0F / cur * pl))) {
/*     */ 
/*     */ 
/*     */         
/*  61 */         int y = 0;
/*  62 */         byte m = 0;
/*  63 */         byte d = 0;
/*     */         try {
/*  65 */           y = Integer.parseInt(JYearsCH.rcd(server, "y"));
/*  66 */           m = Byte.parseByte(JYearsCH.rcd(server, "m"));
/*  67 */           d = Byte.parseByte(JYearsCH.rcd(server, "d"));
/*  68 */         } catch (Exception e) {
/*  69 */           y = 1;
/*  70 */           m = 0;
/*  71 */           d = 1;
/*     */         } 
/*  73 */         String jycp = ":";
/*  74 */         int n = 32;
/*  75 */         AxisAlignedBB aabb = AxisAlignedBB.func_72330_a(p.field_70165_t - n, p.field_70163_u - n, p.field_70161_v - n, p.field_70165_t + n, p.field_70163_u + n, p.field_70161_v + n);
/*  76 */         List<EntityPlayer> l = p.field_70170_p.func_72872_a(EntityPlayer.class, aabb);
/*  77 */         for (int i = 0; i < l.size(); i++) {
/*  78 */           EntityPlayer p2 = l.get(i);
/*  79 */           jycp = jycp + ":" + p2.getDisplayName() + ";" + JRMCoreH.getFloat(p2, "JRYCAge");
/*     */         } 
/*  81 */         int jycdatey = y;
/*  82 */         byte jycdatem = m;
/*  83 */         byte jycdated = d;
/*  84 */         int jycpy = (int)p.field_70163_u;
/*  85 */         PD.sendTo((IMessage)new JYearsCP(jycdatey, jycdatem, jycdated, jycp, jycpy), p);
/*     */       } 
/*     */ 
/*     */       
/*  89 */       long t = dim0.func_72820_D() % 24000L;
/*  90 */       float a = JRMCoreH.getFloat((EntityPlayer)p, "JRYCAge");
/*  91 */       if (t == 1L || t == 6001L || t == 12001L || t == 18001L) {
/*  92 */         JRMCoreH.setFloat(a + 0.25F, (EntityPlayer)p, "JRYCAge");
/*  93 */         a = JRMCoreH.getFloat((EntityPlayer)p, "JRYCAge");
/*  94 */         int mls = JYearsCConfig.pls;
/*  95 */         mls = (mls < 20) ? 20 : mls;
/*  96 */         if (t == 6001L && a > (mls - 10)) {
/*  97 */           p.openGui(mod_JYearsC.instance, 0, p.field_70170_p, (int)p.field_70165_t, (int)p.field_70163_u, (int)p.field_70161_v);
/*     */         }
/*  99 */         if (t == 6001L && a > mls)
/* 100 */           if (p.field_70170_p.field_73012_v.nextInt(5) == 0) { p.func_70097_a(DamageSource.field_76377_j, 20000.0F);
/* 101 */             JRMCoreH.setFloat(0, (EntityPlayer)p, "JRYCAge"); }
/* 102 */           else { p.func_70097_a(DamageSource.field_76377_j, 4.0F); p.func_145747_a((IChatComponent)new ChatComponentText("You getting Old. If you don't Rebirth Then you will die.")); }
/*     */            
/*     */       } 
/* 105 */       if (JRMCoreH.DBC() && 
/* 106 */         p.field_71093_bK == 23) {
/* 107 */         for (int i = 0; i < 24; i++) {
/* 108 */           if (t == (i * 1000)) {
/* 109 */             JRMCoreH.setFloat(a + 4.0F, (EntityPlayer)p, "JRYCAge");
/*     */           }
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/* 115 */       if (this.date.length() > 3) {
/* 116 */         p.func_145747_a((IChatComponent)new ChatComponentText(JRMCoreH.cly + this.date));
/*     */       }
/*     */     } 
/* 119 */     if (this.date.length() > 3) {
/* 120 */       mod_JYearsC.logger.info(this.date);
/* 121 */       this.date = "0";
/*     */     } 
/*     */ 
/*     */     
/* 125 */     if (this.tccb > 0) {
/* 126 */       this.tccb--;
/*     */     } else {
/* 128 */       long tm = dim0.func_72820_D() % 24000L;
/* 129 */       if (tm >= 0L && tm <= 2L) {
/* 130 */         this.tccb = 20;
/* 131 */         String Y = JYearsCH.rcd(server, "y");
/* 132 */         String M = JYearsCH.rcd(server, "m");
/* 133 */         String D = JYearsCH.rcd(server, "d");
/* 134 */         int y = Integer.parseInt((Y != null && Y.length() > 0) ? Y : "0");
/* 135 */         int m = Integer.parseInt((M != null && M.length() > 0) ? M : "0");
/* 136 */         int d = Integer.parseInt((D != null && D.length() > 0) ? D : "0");
/*     */         
/* 138 */         int dy = (d + 1 >= mid[(m >= mid.length) ? 0 : m]) ? m(server, m, y) : (d + 1);
/* 139 */         JYearsCH.wcd(server, dy + "", "d", false);
/*     */ 
/*     */ 
/*     */         
/* 143 */         Y = JYearsCH.rcd(server, "y");
/* 144 */         M = JYearsCH.rcd(server, "m");
/* 145 */         D = JYearsCH.rcd(server, "d");
/* 146 */         y = Integer.parseInt((Y != null && Y.length() > 0) ? Y : "0");
/* 147 */         m = Integer.parseInt((M != null && M.length() > 0) ? M : "0");
/* 148 */         d = Integer.parseInt((D != null && D.length() > 0) ? D : "0");
/*     */         
/* 150 */         int days = 0;
/* 151 */         int z = 0;
/* 152 */         for (int k = 0; k < y % dm.length + 1; k++) {
/* 153 */           for (int i = 0; i < mid.length; i++) {
/* 154 */             for (int j = 0; j < mid[i]; j++) {
/* 155 */               if (days > 4) {
/* 156 */                 days = 0;
/*     */               }
/* 158 */               if (i == m && j == d && k == y % dm.length) {
/* 159 */                 z = days;
/*     */               }
/* 161 */               days++;
/*     */             } 
/*     */           } 
/*     */         } 
/* 165 */         this.date = dm[z] + " on " + (d + 1) + " of " + mn[m] + " in " + y;
/*     */       } 
/*     */     } 
/*     */     
/* 169 */     sendToP(datnc0, sentDatnc0, cur, 0, server);
/* 170 */     if (this.tick >= 100) {
/* 171 */       this.tick = -1;
/*     */     }
/* 173 */     this.tick++;
/*     */   }
/* 175 */   public static String sentDatnc0 = null;
/*     */   private void send(String[] temp, String send, int cur, int c) {
/* 177 */     if (temp != null) {
/* 178 */       String s = ":";
/* 179 */       for (int i = 0; i < cur; i++) {
/* 180 */         if (temp[i] != null) {
/* 181 */           s = s + ":" + temp[i];
/*     */         }
/*     */       } 
/* 184 */       s = s.replaceAll("::", "");
/* 185 */       if (!s.equals(send) && !s.equals(":")) {
/*     */         
/* 187 */         JYearsCPData(c, s);
/*     */         
/* 189 */         sdm(s, c);
/*     */       } 
/* 191 */       adn(c);
/*     */     } 
/*     */   } String[] cp;
/*     */   private void sendToP(String[] temp, String send, int cur, int c, MinecraftServer server) {
/* 195 */     if (temp != null) {
/* 196 */       String s = ":"; int i;
/* 197 */       for (i = 0; i < cur; i++) {
/* 198 */         if (temp[i] != null) {
/* 199 */           s = s + ":" + temp[i];
/*     */         }
/*     */       } 
/* 202 */       s = s.replaceAll("::", "");
/*     */       
/* 204 */       if (!s.equals(send) && !s.equals(":")) {
/*     */         
/* 206 */         for (i = 0; i < cur; i++) {
/* 207 */           EntityPlayerMP player = JRMCoreH.getPlayerForUsername(server, server.func_71213_z()[i]);
/* 208 */           String s1 = temp[i];
/* 209 */           String[] s2 = (send != null) ? send.split(":") : null;
/*     */           
/* 211 */           if (temp.length - 1 >= i && (
/* 212 */             s2 == null || s2.length <= i || !s1.equals(s2[i])))
/*     */           {
/* 214 */             JYearsCPDataToP(c, s1, (EntityPlayer)player);
/*     */           }
/*     */         } 
/*     */         
/* 218 */         sdm(s, c);
/*     */       } 
/* 220 */       adn(c);
/*     */     } 
/*     */   }
/*     */   public static void sdm(String d, int c) {
/* 224 */     if (c == 0) sentDatnc0 = d; 
/*     */   }
/*     */   public static void adn(int c) {
/* 227 */     if (c == 0) datnc0 = null; 
/*     */   }
/*     */   
/*     */   private static void JYearsCPData(int d, String s) {
/* 231 */     PD.sendToAll((IMessage)new JYearsCPData(d, s));
/*     */   }
/*     */   private static void JYearsCPDataToP(int d, String s, EntityPlayer p) {
/* 234 */     PD.sendTo((IMessage)new JYearsCPData(d, s), (EntityPlayerMP)p);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void onTickInGame() {
/* 241 */     MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
/* 242 */     serverTick(server);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onPlayerTick(EntityPlayer player) {}
/*     */ 
/*     */   
/*     */   public JYearsCComTickH() {
/* 251 */     this.cp = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onTick(TickEvent.ServerTickEvent event) {
/* 260 */     if (event.phase.equals(TickEvent.Phase.START))
/*     */     {
/* 262 */       onTickInGame();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JYearsC-v1.2.5.jar!\JinRyuu\JYearsC\JYearsCComTickH.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */