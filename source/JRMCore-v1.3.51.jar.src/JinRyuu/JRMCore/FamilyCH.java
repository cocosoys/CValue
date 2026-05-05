/*     */ package JinRyuu.JRMCore;
/*     */ 
/*     */ import JinRyuu.JRMCore.p.FamilyCP;
/*     */ import JinRyuu.JRMCore.p.PD;
/*     */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*     */ import java.util.Random;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ 
/*     */ public class FamilyCH {
/*  13 */   public static int lastUpdateTick = 0;
/*  14 */   public static NBTTagCompound familyCNBT = null;
/*  15 */   public static FamilyCDataThread familyCDataThread = null;
/*     */   
/*  17 */   static String fif = "JFamilyC_f.jfc";
/*  18 */   static String fmd = "JFamilyC_d.jfc";
/*  19 */   static String cfd = "JFamilyC_c.jfc";
/*  20 */   static String pfd = "JFamilyC_p.jfc";
/*  21 */   static String cpd = "JFamilyC_cp.jfc";
/*     */   
/*  23 */   public static void wfmd(MinecraftServer server, String d, String rid, boolean b) { String fd = "/data"; JRMCoreH.wd(server, d, rid + "", "/data", fmd, b); }
/*  24 */   public static String rfmd(MinecraftServer server, String id) { String fd = "/data"; return JRMCoreH.rd(server, id + "", "/data", fmd); } public static void wfi(MinecraftServer server, String d, String rid, boolean b) {
/*  25 */     String fd = "/data"; JRMCoreH.wd(server, d, rid + "", "/data", fif, b);
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
/*     */   public static String rfi(MinecraftServer server, String id) {
/*  37 */     String fd = "/data"; return JRMCoreH.rd(server, id + "", "/data", fif);
/*     */   } public static void wcfdD(MinecraftServer server) {
/*  39 */     String fd = "/data"; JRMCoreH.wd(server, "/data", cfd);
/*     */   } public static void wcfd(MinecraftServer server, String d, int id, boolean b) {
/*  41 */     String fd = "/data"; JRMCoreH.wd(server, d, id + "", "/data", cfd, b);
/*     */   } public static String rcfd(MinecraftServer server, String id) {
/*  43 */     String fd = "/data"; return JRMCoreH.rd(server, id, "/data", cfd);
/*     */   } public static void wpfdD(MinecraftServer server) {
/*  45 */     String fd = "/data"; JRMCoreH.wd(server, "/data", pfd);
/*     */   } public static void wpfd(MinecraftServer server, String d, String id, boolean b) {
/*  47 */     String fd = "/data"; JRMCoreH.wd(server, d, id, "/data", pfd, b);
/*     */   } public static String rpfd(MinecraftServer server, String id) {
/*  49 */     String fd = "/data"; return JRMCoreH.rd(server, id, "/data", pfd);
/*     */   }
/*     */   public static void wcpd(MinecraftServer server, String d, String id, boolean b) {
/*  52 */     String fd = "/data"; JRMCoreH.wd(server, d, id, "/data", cpd, b);
/*     */   } public static String rcpd(MinecraftServer server, String id) {
/*  54 */     String fd = "/data"; return JRMCoreH.rd(server, id, "/data", cpd);
/*     */   }
/*     */ 
/*     */   
/*     */   public static NBTTagCompound readFamilyInfoFromNBT(MinecraftServer server) {
/*  59 */     String fd = "/data";
/*  60 */     return JRMCoreH.readNBTFile(server, "/data", fif);
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
/* 169 */   public static String FID = "JRMCFID";
/* 170 */   public static String FIDo = "JRMCFIDo";
/*     */   
/* 172 */   public static String FIDi = "JRMCFIDi";
/* 173 */   public static String FIDa = "JRMCFIDa";
/* 174 */   public static String prID = "JRMCproc";
/*     */   public static String[] famNams;
/*     */   public static String[] famMem;
/*     */   public static String prop;
/*     */   public static String adop;
/*     */   public static int[] pregTime;
/* 180 */   public static int FamID = 0;
/*     */   
/*     */   public static String FamP;
/* 183 */   public static String[] jnam0 = new String[] { "a", "i", "u", "e", "o" };
/* 184 */   public static String[] jnam1 = new String[] { "ka", "ki", "ki", "ku", "ku", "ke", "ke", "ko", "ko", "sa", "sa", "sa", "shi", "shi", "shi", "su", "su", "se", "so", "ta", "ta", "chi", "chi", "tsu", "te", "to", "na", "ni", "ni", "nu", "nu", "ne", "no", "no", "ha", "hi", "fu", "fu", "he", "ho", "ma", "ma", "ma", "mi", "mi", "mi", "mu", "mu", "mu", "mu", "me", "mo", "mo", "mo", "ya", "yu", "yu", "yu", "yo", "ra", "ra", "ra", "ri", "ru", "ru", "ru", "re", "ro", "ro", "ro", "wa", "wa", "wa", "wa", "wo", "wo" };
/*     */ 
/*     */   
/* 187 */   public static String[] jnam2 = new String[] { "n" };
/* 188 */   public static String[] nam1 = new String[] { "Kami", "Kame", "Ko", "Leto", "Le", "La", "Lao", "Mu", "Mute", "Na", "Nap", "Ni", "Omeni", "Ome", "Oo", "Pic", "Pik", "Pi", "Pui", "Poi", "Po", "Pu", "Pa", "Pud", "Pu", "Para", "Puru", "Pora", "Poru", "Rai", "Rei", "Re", "Reno", "Ra", "Roshi", "Ro", "Sei", "Sa", "She", "Tru", "Turu", "Tu", "Tia", "Ti", "Tur", "Ve", "Vel", "Vege", "Veji", "Vi", "Vide", "Ya", "Yam", "Yamu", "Yako", "Zarbo", "Za", "Ze", "Bi", "Ba", "Be", "Buu", "Baba", "Bibi", "Beji", "Bu", "Bul", "Buru", "Ba", "Bardo", "Bro", "Broli", "Chi", "Chao", "Choa", "Ce", "Dodo", "Do", "Duru", "Dabu", "Da", "Du", "Furi", "Frei", "Free", "Frie", "Fu", "Fuze", "Gero", "Ge", "Giyu", "Gin", "Gi", "Gig", "Gaji", "Ga", "Gul", "Gu", "Ger", "Go", "Jei", "Jie", "Ji", "Je", "Jin", "Kai", "Ki", "Ka", "Kril", "Kri", "Kuru", "Kuri", "Ku", "Kururi", "Ka" };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 193 */   public static String[] nam2 = new String[] { "nku", "nkuu", "tai", "kai", "ken", "aio", "san", "drick", "nix", "golo", "gollo", "gelo", "galo", "gello", "ucha", "'ken", "'kan", "sen", "zar", "bon", "don", "kou", "han", "sin", "-Chi", "nate", "rne", "jitsu", "jiit", "jit", "u", "ut", "be", "long", "razu", "tle", "rin", "rrin", "tenks", "tunks", "zedd", "edd", "er", "bidi", "bi", "di", "dd", "d", "badi", "ba", "ta", "ter", "rter", "ma", "po", "bo", "ck", "tsu", "tzu", "ll", "ria", "ra", "ri", "za", "zer", "yu", "do", "o", "ku", "kuu", "ce", "ke", "lin", "rin", "me", "sennin", "shinhan", "ten", "en", "mat", "t", "tien", "pa", "colo", "kon", "kolo", "con", "-pui", "-poi", "ditz", "dditz", "dittz", "shi", "shu", "sho", "sha", "she", "les", "nks", "geta", "jita", "gita", "jeta", "tto", "to", "cha", "chi", "n" };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int d(String s, int i) {
/* 199 */     return (i == 3) ? ltn5(sa(s, 6), sa(s, 7), sa(s, 8), sa(s, 9), sa(s, 10)) : ltn(sa(s, (i == 0) ? 0 : ((i == 1) ? 2 : ((i == 2) ? 4 : 11))), sa(s, (i == 0) ? 1 : ((i == 1) ? 3 : ((i == 2) ? 5 : 12))));
/* 200 */   } public static String sa(String s1, int s2) { return s1.charAt(s2) + ""; }
/* 201 */   public static int ltn(String s1, String s2) { return JRMCoreH.letToNum(s1, s2); } public static int ltn5(String s1, String s2, String s3, String s4, String s5) {
/* 202 */     return JRMCoreH.letToNum5(s1, s2, s3, s4, s5);
/*     */   }
/*     */   public static String namGen() {
/* 205 */     Random r1 = new Random();
/* 206 */     int i0 = r1.nextInt(2);
/* 207 */     String s = "";
/* 208 */     if (i0 == 1) {
/* 209 */       r1 = new Random();
/* 210 */       int i1 = r1.nextInt(nam1.length - 1);
/* 211 */       r1 = new Random();
/* 212 */       int i2 = r1.nextInt(nam2.length - 1);
/* 213 */       s = nam1[i1] + nam2[i2];
/*     */     } else {
/* 215 */       r1 = new Random(); int i1 = r1.nextInt(10);
/* 216 */       String s1 = (i1 < jnam0.length) ? jnam0[i1] : "";
/* 217 */       r1 = new Random(); i1 = r1.nextInt(3);
/* 218 */       String s2 = "";
/* 219 */       for (int i = 0; i < i1 + 1; i++) {
/* 220 */         r1 = new Random(); int i2 = r1.nextInt(jnam1.length);
/* 221 */         s2 = s2 + jnam1[i2];
/*     */       } 
/* 223 */       r1 = new Random(); i1 = r1.nextInt(4);
/* 224 */       String s3 = (i1 < jnam2.length) ? jnam0[i1] : "";
/* 225 */       String n = s1 + s2 + s3;
/* 226 */       s = n.substring(0, 1).toUpperCase() + n.substring(1);
/*     */     } 
/* 228 */     return (s != null) ? s : "Null";
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
/*     */   public static void jfcd(int id, String txt) {
/* 390 */     PD.sendToServer((IMessage)new FamilyCP(id, txt));
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
/*     */   public static void jfcd(int id, String txt, EntityPlayer p) {
/* 409 */     PD.sendTo((IMessage)new FamilyCP(id, txt), (EntityPlayerMP)p);
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
/*     */   public static boolean procWith(int ar, int tr) {
/* 427 */     return (ar != tr) ? ((ar >= 0 && ar <= 2 && tr >= 0 && tr <= 2)) : true;
/*     */   }
/*     */   
/*     */   public static int procTR(int ar, int tr) {
/* 431 */     return (ar != tr) ? ((ar >= 0 && ar <= 2 && tr >= 0 && tr <= 2) ? 2 : 0) : ar;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\FamilyCH.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */