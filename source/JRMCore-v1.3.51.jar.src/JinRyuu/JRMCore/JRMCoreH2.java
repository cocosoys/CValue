/*     */ package JinRyuu.JRMCore;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.util.ChatStyle;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JRMCoreH2
/*     */ {
/*  18 */   public static ChatStyle styl_ylw = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW);
/*  19 */   public static ChatStyle styl_wht = (new ChatStyle()).func_150238_a(EnumChatFormatting.WHITE);
/*  20 */   public static ChatStyle styl_gld = (new ChatStyle()).func_150238_a(EnumChatFormatting.GOLD);
/*  21 */   public static ChatStyle styl_red = (new ChatStyle()).func_150238_a(EnumChatFormatting.RED);
/*     */ 
/*     */ 
/*     */   
/*     */   public static void chtmsg_ylw(EntityPlayer entityplayermp, String t) {
/*  26 */     entityplayermp.func_145747_a((new ChatComponentTranslation(t, new Object[0])).func_150255_a(styl_ylw));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Entity getTarget(float par1, double distance) {
/*  32 */     double d0 = distance;
/*  33 */     MovingObjectPosition omo = JRMCoreClient.mc.field_71451_h.func_70614_a(d0, par1);
/*  34 */     double d1 = d0;
/*  35 */     Vec3 vec3 = JRMCoreClient.mc.field_71451_h.func_70666_h(par1);
/*  36 */     Vec3 vec31 = JRMCoreClient.mc.field_71451_h.func_70676_i(par1);
/*  37 */     Vec3 vec32 = vec3.func_72441_c(vec31.field_72450_a * d0, vec31.field_72448_b * d0, vec31.field_72449_c * d0);
/*  38 */     Entity pointedEntity = null;
/*  39 */     Vec3 vec33 = null;
/*  40 */     float f1 = 1.0F;
/*  41 */     List<Entity> list = JRMCoreClient.mc.field_71441_e.func_72839_b((Entity)JRMCoreClient.mc.field_71451_h, JRMCoreClient.mc.field_71451_h.field_70121_D.func_72321_a(vec31.field_72450_a * d0, vec31.field_72448_b * d0, vec31.field_72449_c * d0).func_72314_b(f1, f1, f1));
/*  42 */     double d2 = d1;
/*     */     
/*  44 */     for (int i = 0; i < list.size(); i++) {
/*     */       
/*  46 */       Entity entity = list.get(i);
/*     */       
/*  48 */       if (entity.func_70067_L()) {
/*     */         
/*  50 */         float f2 = entity.func_70111_Y();
/*  51 */         AxisAlignedBB axisalignedbb = entity.field_70121_D.func_72314_b(f2, f2, f2);
/*  52 */         MovingObjectPosition movingobjectposition = axisalignedbb.func_72327_a(vec3, vec32);
/*     */         
/*  54 */         if (axisalignedbb.func_72318_a(vec3)) {
/*     */           
/*  56 */           if (0.0D < d2 || d2 == 0.0D)
/*     */           {
/*  58 */             pointedEntity = entity;
/*  59 */             vec33 = (movingobjectposition == null) ? vec3 : movingobjectposition.field_72307_f;
/*  60 */             d2 = 0.0D;
/*     */           }
/*     */         
/*  63 */         } else if (movingobjectposition != null) {
/*     */           
/*  65 */           double d3 = vec3.func_72438_d(movingobjectposition.field_72307_f);
/*     */           
/*  67 */           if (d3 < d2 || d2 == 0.0D)
/*     */           {
/*  69 */             if (entity == JRMCoreClient.mc.field_71451_h.field_70154_o && !entity.canRiderInteract()) {
/*     */               
/*  71 */               if (d2 == 0.0D)
/*     */               {
/*  73 */                 pointedEntity = entity;
/*  74 */                 vec33 = movingobjectposition.field_72307_f;
/*     */               }
/*     */             
/*     */             } else {
/*     */               
/*  79 */               pointedEntity = entity;
/*  80 */               vec33 = movingobjectposition.field_72307_f;
/*  81 */               d2 = d3;
/*     */             } 
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*  87 */     if (pointedEntity != null && (d2 < d1 || omo == null)) {
/*     */       
/*  89 */       omo = new MovingObjectPosition(pointedEntity, vec33);
/*     */       
/*  91 */       if (pointedEntity instanceof Entity || pointedEntity instanceof net.minecraft.entity.item.EntityItemFrame)
/*     */       {
/*  93 */         JRMCoreClient.mc.field_147125_j = pointedEntity;
/*     */       }
/*     */     } 
/*  96 */     if (omo != null)
/*     */     {
/*  98 */       if (omo.field_72313_a == MovingObjectPosition.MovingObjectType.ENTITY)
/*     */       {
/* 100 */         if (omo.field_72308_g instanceof Entity)
/*     */         {
/* 102 */           return omo.field_72308_g;
/*     */         }
/*     */       }
/*     */     }
/* 106 */     return null;
/*     */   }
/* 108 */   public static final String[] colNams = new String[] { "black", "red", "green", "brown", "blue", "purple", "cyan", "silver", "gray", "pink", "lime", "yellow", "lightBlue", "magenta", "orange", "white" };
/* 109 */   public static final int[] cols = new int[] { 1973019, 11743532, 3887386, 5320730, 2437522, 8073150, 2651799, 11250603, 4408131, 14188952, 4312372, 14602026, 6719955, 12801229, 15435844, 15790320 };
/*     */   
/*     */   public static final int col_black = 0;
/*     */   
/*     */   public static final int col_red = 1;
/*     */   public static final int col_green = 2;
/*     */   public static final int col_brown = 3;
/*     */   public static final int col_blue = 4;
/*     */   public static final int col_purple = 5;
/*     */   public static final int col_cyan = 6;
/*     */   public static final int col_silver = 7;
/*     */   public static final int col_gray = 8;
/*     */   public static final int col_pink = 9;
/*     */   public static final int col_lime = 10;
/*     */   public static final int col_yellow = 11;
/*     */   public static final int col_lightBlue = 12;
/*     */   public static final int col_magenta = 13;
/*     */   public static final int col_orange = 14;
/*     */   public static final int col_white = 15;
/* 128 */   public static String[] jnam0 = new String[] { "a", "i", "u", "e", "o" };
/* 129 */   public static String[] jnam1 = new String[] { "ka", "ki", "ki", "ku", "ku", "ke", "ke", "ko", "ko", "sa", "sa", "sa", "shi", "shi", "shi", "su", "su", "se", "so", "ta", "ta", "chi", "chi", "tsu", "te", "to", "na", "ni", "ni", "nu", "nu", "ne", "no", "no", "ha", "hi", "fu", "fu", "he", "ho", "ma", "ma", "ma", "mi", "mi", "mi", "mu", "mu", "mu", "mu", "me", "mo", "mo", "mo", "ya", "yu", "yu", "yu", "yo", "ra", "ra", "ra", "ri", "ru", "ru", "ru", "re", "ro", "ro", "ro", "wa", "wa", "wa", "wa", "wo", "wo" };
/*     */ 
/*     */   
/* 132 */   public static String[] jnam2 = new String[] { "n" };
/* 133 */   public static String[] nam1 = new String[] { "Kami", "Kame", "Ko", "Leto", "Le", "La", "Lao", "Mu", "Mute", "Na", "Nap", "Ni", "Omeni", "Ome", "Oo", "Pic", "Pik", "Pi", "Pui", "Poi", "Po", "Pu", "Pa", "Pud", "Pu", "Para", "Puru", "Pora", "Poru", "Rai", "Rei", "Re", "Reno", "Ra", "Roshi", "Ro", "Sei", "Sa", "She", "Tru", "Turu", "Tu", "Tia", "Ti", "Tur", "Ve", "Vel", "Vege", "Veji", "Vi", "Vide", "Ya", "Yam", "Yamu", "Yako", "Zarbo", "Za", "Ze", "Bi", "Ba", "Be", "Buu", "Baba", "Bibi", "Beji", "Bu", "Bul", "Buru", "Ba", "Bardo", "Bro", "Broli", "Chi", "Chao", "Choa", "Ce", "Dodo", "Do", "Duru", "Dabu", "Da", "Du", "Furi", "Frei", "Free", "Frie", "Fu", "Fuze", "Gero", "Ge", "Giyu", "Gin", "Gi", "Gig", "Gaji", "Ga", "Gul", "Gu", "Ger", "Go", "Jei", "Jie", "Ji", "Je", "Jin", "Kai", "Ki", "Ka", "Kril", "Kri", "Kuru", "Kuri", "Ku", "Kururi", "Ka" };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 138 */   public static String[] nam2 = new String[] { "nku", "nkuu", "tai", "kai", "ken", "aio", "san", "drick", "nix", "golo", "gollo", "gelo", "galo", "gello", "ucha", "'ken", "'kan", "sen", "zar", "bon", "don", "kou", "han", "sin", "-Chi", "nate", "rne", "jitsu", "jiit", "jit", "u", "ut", "be", "long", "razu", "tle", "rin", "rrin", "tenks", "tunks", "zedd", "edd", "er", "bidi", "bi", "di", "dd", "d", "badi", "ba", "ta", "ter", "rter", "ma", "po", "bo", "ck", "tsu", "tzu", "ll", "ria", "ra", "ri", "za", "zer", "yu", "do", "o", "ku", "kuu", "ce", "ke", "lin", "rin", "me", "sennin", "shinhan", "ten", "en", "mat", "t", "tien", "pa", "colo", "kon", "kolo", "con", "-pui", "-poi", "ditz", "dditz", "dittz", "shi", "shu", "sho", "sha", "she", "les", "nks", "geta", "jita", "gita", "jeta", "tto", "to", "cha", "chi", "n" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String kiAttNamGen() {
/* 145 */     Random r1 = new Random();
/* 146 */     int i0 = r1.nextInt(1);
/* 147 */     String s = "";
/* 148 */     if (i0 == 1) {
/* 149 */       r1 = new Random();
/* 150 */       int i1 = r1.nextInt(nam1.length - 1);
/* 151 */       r1 = new Random();
/* 152 */       int i2 = r1.nextInt(nam2.length - 1);
/* 153 */       s = nam1[i1] + nam2[i2];
/*     */     } else {
/* 155 */       r1 = new Random(); int i1 = r1.nextInt(10);
/* 156 */       String s1 = (i1 < jnam0.length) ? jnam0[i1] : "";
/* 157 */       r1 = new Random(); i1 = r1.nextInt(3);
/* 158 */       String s2 = "";
/* 159 */       for (int i = 0; i < i1 + 1; i++) {
/* 160 */         r1 = new Random(); int i2 = r1.nextInt(jnam1.length);
/* 161 */         s2 = s2 + jnam1[i2];
/*     */       } 
/* 163 */       r1 = new Random(); i1 = r1.nextInt(4);
/* 164 */       String s3 = (i1 < jnam2.length) ? jnam0[i1] : "";
/* 165 */       String n = s1 + s2 + s3;
/* 166 */       s = n.substring(0, 1).toUpperCase() + n.substring(1);
/*     */     } 
/* 168 */     return (s != null) ? s : "Null";
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCoreH2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */