/*     */ package JinRyuu.JRMCore;
/*     */ 
/*     */ import java.util.List;
/*     */ import net.minecraft.command.CommandBase;
/*     */ import net.minecraft.command.ICommand;
/*     */ import net.minecraft.command.ICommandSender;
/*     */ import net.minecraft.command.WrongUsageException;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ 
/*     */ public class ComJrmca
/*     */   extends CommandBase {
/*  16 */   private final String[] MODES = new String[] { "set", "add" };
/*     */ 
/*     */   
/*  19 */   private final String[] ATTRIBUTES_LONG = new String[] { "alignment", "strength", "dexterity", "constitution", "willpower", "mind", "spirit", "all" };
/*     */ 
/*     */   
/*  22 */   public static final String[] ATTRIBUTES_SHORT = new String[] { "alig", "str", "dex", "con", "wil", "mnd", "spi", "all" };
/*     */ 
/*     */   
/*  25 */   private final String[] VALUES = new String[] { "100", "max", "reset", "-100" };
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_71517_b() {
/*  30 */     return "jrmca";
/*     */   } public String func_71518_a(ICommandSender icommandsender) {
/*  32 */     return "/jrmca (Set or Add) (Attribute) (Amount) [playerName]   ,where Attribute can be Alignment, Strength, Dexterity, Constitution, Willpower, Mind, Spirit or use /dbca Set All Max or Reset .";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_82362_a() {
/*  38 */     return 2;
/*     */   }
/*     */   public void func_71515_b(ICommandSender commandSender, String[] stringArray) {
/*     */     EntityPlayerMP entityplayermp;
/*  42 */     if (stringArray.length <= 0)
/*     */     {
/*  44 */       throw new WrongUsageException(func_71518_a(commandSender), new Object[0]);
/*     */     }
/*     */ 
/*     */     
/*  48 */     String s0 = stringArray[0].toLowerCase();
/*  49 */     String s1 = stringArray[1];
/*  50 */     String s2 = stringArray[2];
/*  51 */     boolean set = s0.contains("set");
/*  52 */     boolean add = s0.contains("add");
/*     */     
/*  54 */     boolean alignment = (s1.toLowerCase().contains("alignment") || s1.equalsIgnoreCase("alig") || s1.equalsIgnoreCase("align"));
/*  55 */     boolean stre = (s1.toLowerCase().contains("strength") || s1.equalsIgnoreCase("str"));
/*  56 */     boolean dext = (s1.toLowerCase().contains("dexterity") || s1.equalsIgnoreCase("dex"));
/*  57 */     boolean cons = (s1.toLowerCase().contains("constitution") || s1.equalsIgnoreCase("con"));
/*  58 */     boolean will = (s1.toLowerCase().contains("willpower") || s1.equalsIgnoreCase("wil"));
/*  59 */     boolean mind = (s1.toLowerCase().contains("mind") || s1.equalsIgnoreCase("mnd"));
/*  60 */     boolean conc = (s1.toLowerCase().contains("spirit") || s1.equalsIgnoreCase("spi"));
/*     */     
/*  62 */     boolean all = s1.toLowerCase().contains("all");
/*  63 */     boolean max = s2.toLowerCase().contains("max");
/*  64 */     boolean reset = s2.toLowerCase().contains("reset");
/*     */     
/*  66 */     boolean num = false;
/*  67 */     if (!max && !reset) num = true;
/*     */     
/*  69 */     boolean amount = (s2.length() > 0);
/*     */     
/*  71 */     int i = 1;
/*     */     
/*     */     try {
/*  74 */       i = func_71526_a(commandSender, s2);
/*  75 */     } catch (Exception exception) {
/*  76 */       i = 1;
/*     */     } 
/*     */     
/*  79 */     int am = NKfw4V();
/*     */     
/*  81 */     if (set && i < 1) i = 1; 
/*  82 */     if (i > am) i = am;
/*     */ 
/*     */ 
/*     */     
/*  86 */     if (stringArray.length > 3) {
/*     */       
/*  88 */       entityplayermp = func_82359_c(commandSender, stringArray[3]);
/*     */     }
/*     */     else {
/*     */       
/*  92 */       entityplayermp = func_71521_c(commandSender);
/*     */     } 
/*  94 */     String entitycommansender = "Console";
/*     */     try {
/*  96 */       EntityPlayerMP commansender = func_71521_c(commandSender);
/*  97 */       entitycommansender = commansender.func_70005_c_();
/*  98 */     } catch (Exception exception) {}
/*     */ 
/*     */     
/* 101 */     boolean n = entitycommansender.equals("Console") ? JRMCoreConfig.ComANAC : (entitycommansender.equals(entityplayermp.func_70005_c_()) ? JRMCoreConfig.ComANAS : JRMCoreConfig.ComANAO);
/*     */     
/* 103 */     int str = JRMCoreH.getInt((EntityPlayer)entityplayermp, JRMCoreH.AttrbtNbtI[0]);
/* 104 */     int dex = JRMCoreH.getInt((EntityPlayer)entityplayermp, JRMCoreH.AttrbtNbtI[1]);
/* 105 */     int cns = JRMCoreH.getInt((EntityPlayer)entityplayermp, JRMCoreH.AttrbtNbtI[2]);
/* 106 */     int wil = JRMCoreH.getInt((EntityPlayer)entityplayermp, JRMCoreH.AttrbtNbtI[3]);
/* 107 */     int min = JRMCoreH.getInt((EntityPlayer)entityplayermp, JRMCoreH.AttrbtNbtI[4]);
/* 108 */     int cnc = JRMCoreH.getInt((EntityPlayer)entityplayermp, JRMCoreH.AttrbtNbtI[5]);
/*     */     
/* 110 */     String att = "";
/* 111 */     String attnam = "";
/* 112 */     if (stre) { att = JRMCoreH.AttrbtNbtI[0]; int cur = str; attnam = "Strength"; i = (set && i > am) ? am : ((add && cur + i > am) ? (am - cur) : i); }
/* 113 */      if (dext) { att = JRMCoreH.AttrbtNbtI[1]; int cur = dex; attnam = "Dexterity"; i = (set && i > am) ? am : ((add && cur + i > am) ? (am - cur) : i); }
/* 114 */      if (cons) { att = JRMCoreH.AttrbtNbtI[2]; int cur = cns; attnam = "Constitution"; i = (set && i > am) ? am : ((add && cur + i > am) ? (am - cur) : i); }
/* 115 */      if (will) { att = JRMCoreH.AttrbtNbtI[3]; int cur = wil; attnam = "Willpower"; i = (set && i > am) ? am : ((add && cur + i > am) ? (am - cur) : i); }
/* 116 */      if (mind) { att = JRMCoreH.AttrbtNbtI[4]; int cur = min; attnam = "Mind"; i = (set && i > am) ? am : ((add && cur + i > am) ? (am - cur) : i); }
/* 117 */      if (conc) { att = JRMCoreH.AttrbtNbtI[5]; int cur = cnc; attnam = "Spirit"; i = (set && i > am) ? am : ((add && cur + i > am) ? (am - cur) : i); }
/*     */     
/* 119 */     byte pwr = JRMCoreH.getByte((EntityPlayer)entityplayermp, "jrmcPwrtyp");
/* 120 */     byte rce = JRMCoreH.getByte((EntityPlayer)entityplayermp, "jrmcRace");
/* 121 */     byte cls = JRMCoreH.getByte((EntityPlayer)entityplayermp, "jrmcClass");
/* 122 */     if ((stre || dext || cons || will || mind || conc) && amount) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 133 */       int j = 0;
/* 134 */       if (dext) j = 1; 
/* 135 */       if (cons) j = 2; 
/* 136 */       if (will) j = 3; 
/* 137 */       if (mind) j = 4; 
/* 138 */       if (conc) j = 5; 
/* 139 */       int s = JRMCoreH.attributeStart(pwr, j, rce, cls);
/* 140 */       int i2 = (i > s) ? i : s;
/*     */       
/* 142 */       int cur = JRMCoreH.getInt((EntityPlayer)entityplayermp, att);
/* 143 */       JRMCoreH.setInt(max ? am : (add ? ((cur + i < 1) ? 1 : (cur + i)) : (set ? ((i2 < 1) ? 1 : i2) : 1)), (EntityPlayer)entityplayermp, att);
/* 144 */       if (n) notifyAdmins(commandSender, "Attribute " + ((add && cur + i >= 1) ? ("Adding " + i + " to " + attnam) : (set ? (attnam + " was set to " + i) : (attnam + " was set to " + (max ? am : 1)))) + " Successfully", new Object[] { Integer.valueOf(i), entityplayermp.func_70005_c_() });
/*     */     
/* 146 */     } else if (alignment && amount) {
/* 147 */       int cur = JRMCoreH.getByte((EntityPlayer)entityplayermp, "jrmcAlign");
/* 148 */       if (alignment) { att = "jrmcAlign"; attnam = "Alignment"; i = (set && i > 100) ? 100 : ((add && cur + i > 100) ? (100 - cur) : i); }
/* 149 */        JRMCoreH.setByte(max ? am : (add ? ((cur + i < 1) ? 1 : (cur + i)) : (set ? ((i < 1) ? 1 : i) : 1)), (EntityPlayer)entityplayermp, att);
/* 150 */       if (n) notifyAdmins(commandSender, "Attribute " + ((add && cur + i >= 1) ? ("Adding " + i + " to " + attnam) : (set ? (attnam + " was set to " + i) : (attnam + " was set to " + (max ? 100 : 1)))) + " Successfully", new Object[] { Integer.valueOf(i), entityplayermp.func_70005_c_() });
/*     */     
/* 152 */     } else if (add && all && num) {
/* 153 */       for (int i1 = 0; i1 < JRMCoreH.AttrbtNbtI.length; i1++) {
/* 154 */         int s = JRMCoreH.attributeStart(pwr, i1, rce, cls);
/* 155 */         int i2 = (i > s) ? i : s;
/* 156 */         int cur = JRMCoreH.getInt((EntityPlayer)entityplayermp, JRMCoreH.AttrbtNbtI[i1]);
/* 157 */         int newatt = (cur + i < 1) ? 1 : (cur + i);
/* 158 */         JRMCoreH.setInt((newatt > am) ? am : newatt, (EntityPlayer)entityplayermp, JRMCoreH.AttrbtNbtI[i1]);
/*     */       } 
/* 160 */       if (n) notifyAdmins(commandSender, "Attribute Everything for " + entityplayermp.func_70005_c_() + " has received " + i + " Successfully", new Object[] { Integer.valueOf(i), entityplayermp.func_70005_c_() });
/*     */     
/* 162 */     } else if (set && all && num) {
/* 163 */       for (int i1 = 0; i1 < JRMCoreH.AttrbtNbtI.length; i1++) {
/* 164 */         int s = JRMCoreH.attributeStart(pwr, i1, rce, cls);
/* 165 */         int i2 = (i > s) ? i : s;
/* 166 */         JRMCoreH.setInt(i2, (EntityPlayer)entityplayermp, JRMCoreH.AttrbtNbtI[i1]);
/*     */       } 
/* 168 */       if (n) notifyAdmins(commandSender, "Attribute Everything for " + entityplayermp.func_70005_c_() + " was set to " + i + " Successfully", new Object[] { Integer.valueOf(i), entityplayermp.func_70005_c_() });
/*     */     
/* 170 */     } else if (set && all && (max || reset)) {
/* 171 */       if (max) {
/* 172 */         JRMCoreH.setInt(NKfw4V(), (EntityPlayer)entityplayermp, JRMCoreH.AttrbtNbtI[0]);
/* 173 */         JRMCoreH.setInt(NKfw4V(), (EntityPlayer)entityplayermp, JRMCoreH.AttrbtNbtI[1]);
/* 174 */         JRMCoreH.setInt(NKfw4V(), (EntityPlayer)entityplayermp, JRMCoreH.AttrbtNbtI[2]);
/* 175 */         JRMCoreH.setInt(NKfw4V(), (EntityPlayer)entityplayermp, JRMCoreH.AttrbtNbtI[3]);
/* 176 */         JRMCoreH.setInt(NKfw4V(), (EntityPlayer)entityplayermp, JRMCoreH.AttrbtNbtI[4]);
/* 177 */         JRMCoreH.setInt(NKfw4V(), (EntityPlayer)entityplayermp, JRMCoreH.AttrbtNbtI[5]);
/*     */       } 
/* 179 */       if (reset) {
/* 180 */         int STR = JRMCoreH.attributeStart(pwr, 0, rce, cls);
/* 181 */         int DEX = JRMCoreH.attributeStart(pwr, 1, rce, cls);
/* 182 */         int CON = JRMCoreH.attributeStart(pwr, 2, rce, cls);
/* 183 */         int WIL = JRMCoreH.attributeStart(pwr, 3, rce, cls);
/* 184 */         int MND = JRMCoreH.attributeStart(pwr, 4, rce, cls);
/* 185 */         int SPI = JRMCoreH.attributeStart(pwr, 5, rce, cls);
/* 186 */         JRMCoreH.setInt(STR, (EntityPlayer)entityplayermp, JRMCoreH.AttrbtNbtI[0]);
/* 187 */         JRMCoreH.setInt(DEX, (EntityPlayer)entityplayermp, JRMCoreH.AttrbtNbtI[1]);
/* 188 */         JRMCoreH.setInt(CON, (EntityPlayer)entityplayermp, JRMCoreH.AttrbtNbtI[2]);
/* 189 */         JRMCoreH.setInt(WIL, (EntityPlayer)entityplayermp, JRMCoreH.AttrbtNbtI[3]);
/* 190 */         JRMCoreH.setInt(MND, (EntityPlayer)entityplayermp, JRMCoreH.AttrbtNbtI[4]);
/* 191 */         JRMCoreH.setInt(SPI, (EntityPlayer)entityplayermp, JRMCoreH.AttrbtNbtI[5]);
/*     */       } 
/* 193 */       if (n) notifyAdmins(commandSender, "Attribute Everything for " + entityplayermp.func_70005_c_() + " has been " + (max ? "Maxed" : (reset ? "Reset" : "failed")), new Object[] { Integer.valueOf(i), entityplayermp.func_70005_c_() });
/*     */     
/*     */     } else {
/*     */       
/* 197 */       throw new WrongUsageException("Attribute Change Failure", new Object[0]);
/*     */     } 
/* 199 */     EntityPlayerMP player = entityplayermp;
/* 200 */     int[] PlyrAttrbts = JRMCoreH.PlyrAttrbts((EntityPlayer)player);
/* 201 */     int maxBody = JRMCoreH.stat((Entity)player, 2, pwr, 2, PlyrAttrbts[2], rce, cls, 0.0F);
/* 202 */     int maxEnergy = JRMCoreH.stat((Entity)player, 5, pwr, 5, PlyrAttrbts[5], rce, cls, JRMCoreH.SklLvl_KiBs((EntityPlayer)player, pwr));
/* 203 */     int maxStam = JRMCoreH.stat((Entity)player, 2, pwr, 3, PlyrAttrbts[2], rce, cls, 0.0F);
/*     */     
/* 205 */     JRMCoreH.setInt(maxBody, (EntityPlayer)player, "jrmcBdy");
/* 206 */     JRMCoreH.setInt(maxEnergy, (EntityPlayer)player, "jrmcEnrgy");
/* 207 */     JRMCoreH.setInt(maxStam, (EntityPlayer)player, "jrmcStamina");
/*     */   }
/*     */   int calc1(int j, int l) { int i;
/*     */     int k;
/* 211 */     for (i = 0, k = 0; k < j; ) { i += i + l; k++; }  return i; } int calc2(int j, int l) { int i; int k;
/* 212 */     for (i = 0, k = 0; k < j / l; ) { int z = (k * l / 50 <= 0) ? 1 : (k * l / 50); i += z; k++; }  return i; }
/*     */   
/*     */   private NBTTagCompound nbt(EntityPlayer p, String s) {
/* 215 */     return JRMCoreH.nbt((Entity)p, s);
/*     */   } private void notifyAdmins(ICommandSender par1iCommandSender, String string, Object[] objects) {
/* 217 */     func_152373_a(par1iCommandSender, (ICommand)this, string, objects);
/*     */   } public static int MCajr(String l) {
/*     */     String w;
/*     */     int a;
/*     */     int i;
/* 222 */     for (w = "0123456789ABCDEF", l = l.toUpperCase(), a = 0, i = 0; i < l.length(); ) { char c = l.charAt(i); int d = w.indexOf(c); a = 16 * a + d; i++; }  return a;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int NKfw4V() {
/* 227 */     int b = JRMCoreConfig.tmx; String r = "64", k = "3B9ACA00"; return (b > MCajr(k)) ? MCajr(k) : ((b < MCajr(r)) ? 0 : b);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List func_71516_a(ICommandSender commandSender, String[] stringArray) {
/* 234 */     int length = stringArray.length;
/* 235 */     switch (length) { case 1:
/* 236 */         return func_71530_a(stringArray, this.MODES);
/* 237 */       case 2: return func_71530_a(stringArray, this.ATTRIBUTES_LONG);
/* 238 */       case 3: return func_71530_a(stringArray, this.VALUES);
/* 239 */       case 4: return func_71530_a(stringArray, getListOfPlayers()); }
/* 240 */      return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected String[] getListOfPlayers() {
/* 246 */     return MinecraftServer.func_71276_C().func_71213_z();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isUsernameIndex(int par1) {
/* 254 */     return (par1 == 3);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\ComJrmca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */