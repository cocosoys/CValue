/*     */ package JinRyuu.JRMCore.p;
/*     */ 
/*     */ import JinRyuu.FamilyC.EntityNPC;
/*     */ import JinRyuu.FamilyC.FamilyCCharGui;
/*     */ import JinRyuu.FamilyC.FamilyCConfig;
/*     */ import JinRyuu.JRMCore.FamilyCH;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import cpw.mods.fml.common.network.ByteBufUtils;
/*     */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*     */ import cpw.mods.fml.common.network.simpleimpl.MessageContext;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import java.util.Random;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.ChatStyle;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ 
/*     */ public class FamilyCP
/*     */   implements IMessage {
/*     */   public static final int FORM_FAMILY = 0;
/*     */   public static final int PROPOSE_INVITE = 1;
/*     */   public static final int ADOPT_INVITE = 2;
/*     */   public static final int ACCEPT_PROPOSE = 3;
/*     */   public static final int ACCEPT_ADOPT = 4;
/*     */   public static final int DECLINE_BOTH_ADOPT_AND_PROPOSE = 5;
/*     */   public static final int LEAVE_DIVORCE = 6;
/*     */   public static final int DISINHERIT_FORCE_DIVORCE_UNADOPT_CHILD = 7;
/*     */   public static final int ACCEPT_PROCREATION = 8;
/*     */   
/*     */   public FamilyCP(int id, String txt) {
/*  35 */     this.id = id;
/*  36 */     this.txt = txt;
/*     */   }
/*     */   public static final int DECLINE_PROCREATION = 9; public static final int OFFER_PROCREATION = 10; public static final int NPC_CHANGE_DATA = 20; public static final int PLAYER_PARENT_AND_CHILD_DATA_WHEN_GUI_OPENED = 21; public static final int NPC_CHANGE_NAME = 22; public static final int NPC_CHANGE_DNS = 23; int id; String txt;
/*     */   public FamilyCP() {}
/*     */   public void toBytes(ByteBuf buffer) {
/*  41 */     buffer.writeInt(this.id);
/*  42 */     ByteBufUtils.writeUTF8String(buffer, this.txt);
/*     */   }
/*     */ 
/*     */   
/*     */   public void fromBytes(ByteBuf buffer) {
/*  47 */     this.id = buffer.readInt();
/*  48 */     this.txt = ByteBufUtils.readUTF8String(buffer);
/*     */   }
/*     */   
/*     */   public static class Handler
/*     */     extends BAmh<FamilyCP> {
/*     */     private static int dnsRaceSlcted;
/*     */     private static int dnsGenderSlcted;
/*     */     private static int dnsHairSlcted;
/*     */     private static int dnsHair2Slcted;
/*     */     private static int dnsColorSlcted;
/*     */     private static int dnsBreastSizeSlcted;
/*     */     private static int dnsBodyTypeSlcted;
/*     */     private static int dnsBodyColMainSlcted;
/*     */     private static int dnsBodyColSub1Slcted;
/*     */     private static int dnsBodyColSub2Slcted;
/*     */     private static int dnsBodyColSub3Slcted;
/*     */     private static int dnsFaceNoseSlcted;
/*     */     private static int dnsFaceMouthSlcted;
/*     */     private static int dnsEyesSlcted;
/*     */     private static int dnsEyeCol1Slcted;
/*     */     private static int dnsEyeCol2Slcted;
/*     */     private static String dns;
/*     */     
/*     */     public IMessage handleClientMessage(EntityPlayer p, FamilyCP msg, MessageContext ctx) {
/*  72 */       int id = msg.id;
/*  73 */       String txt = msg.txt;
/*     */ 
/*     */       
/*  76 */       if (id == 20) {
/*     */         
/*  78 */         String[] dat = txt.split(":");
/*  79 */         int eid = Integer.parseInt(dat[0]);
/*  80 */         String follow = dat[1];
/*  81 */         String aggro = dat[2];
/*  82 */         String fid = dat[3];
/*  83 */         String d = dat[4];
/*  84 */         String m = dat[5];
/*  85 */         int cn = Integer.parseInt(dat[6]);
/*  86 */         Entity pl = p.field_70170_p.func_73045_a(eid);
/*  87 */         if (pl instanceof EntityNPC && pl != null) {
/*     */           
/*  89 */           FamilyCCharGui.dtcf = follow;
/*  90 */           FamilyCCharGui.dtca = aggro;
/*  91 */           FamilyCCharGui.dtcft = fid;
/*  92 */           FamilyCCharGui.dtcdad = d;
/*  93 */           FamilyCCharGui.dtcmom = m;
/*  94 */           FamilyCCharGui.inv = (cn == 1) ? -1 : 0;
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/*  99 */       if (id == 21)
/*     */       {
/* 101 */         FamilyCCharGui.children = txt;
/*     */       }
/*     */ 
/*     */       
/* 105 */       if (id == 23) {
/*     */         
/* 107 */         int n = Integer.parseInt(txt);
/* 108 */         Entity pl = p.field_70170_p.func_73045_a(n);
/* 109 */         if (pl != null && pl instanceof EntityNPC) {
/*     */           
/* 111 */           EntityNPC npl = (EntityNPC)pl;
/* 112 */           npl.setNamUpdt(true);
/*     */         } 
/*     */       } 
/*     */       
/* 116 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public IMessage handleServerMessage(EntityPlayer p, FamilyCP m, MessageContext ctx) {
/* 121 */       ChatStyle color = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW);
/* 122 */       int id = m.id;
/* 123 */       String txt = m.txt;
/* 124 */       MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
/* 125 */       String y = JRMCoreH.cly;
/* 126 */       String g = JRMCoreH.clgd;
/* 127 */       String dns = JRMCoreH.getString(p, "jrmcDNS");
/*     */ 
/*     */       
/* 130 */       if (id == 0) {
/*     */         
/* 132 */         String[] s = txt.split(",");
/* 133 */         String rid = s[0] + ",0";
/* 134 */         String d = txt + "!" + p.func_70005_c_() + ",e!0";
/* 135 */         String fid = JRMCoreH.getString(p, FamilyCH.FID);
/*     */         
/* 137 */         if (FamilyCH.rfi(server, s[0] + ",0").equals("0") && fid.length() < 2) {
/*     */           
/* 139 */           FamilyCH.wfi(server, d, rid, false);
/* 140 */           JRMCoreH.setString(rid, p, FamilyCH.FID);
/* 141 */           p.func_145747_a((new ChatComponentText(y + g + s[0] + y + " Family has been created!")).func_150255_a(color));
/*     */         } else {
/* 143 */           p.func_145747_a((new ChatComponentText(y + "Family already exists, can't create another family!")).func_150255_a(color));
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 148 */       if (id == 1) {
/*     */         
/* 150 */         String fid = JRMCoreH.getString(p, FamilyCH.FID);
/* 151 */         String n = p.func_70005_c_();
/* 152 */         String[] s = fid.split(",");
/* 153 */         String fn = s[0];
/* 154 */         EntityPlayerMP pi = JRMCoreH.getPlayerForUsername(server, txt);
/* 155 */         if (pi != null) {
/*     */           
/* 157 */           String pfid = JRMCoreH.getString((EntityPlayer)pi, FamilyCH.FID);
/* 158 */           if (pfid.length() < 2) {
/*     */             
/* 160 */             JRMCoreH.setString("", (EntityPlayer)pi, FamilyCH.FIDa);
/* 161 */             JRMCoreH.setString(p.func_70005_c_(), (EntityPlayer)pi, FamilyCH.FIDi);
/* 162 */             pi.func_145747_a((new ChatComponentText(y + "" + g + n + y + " sent you a proposal" + ((fn.length() > 1) ? (" from the " + g + fn + y + " family") : "") + "!")).func_150255_a(color));
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 168 */       if (id == 2) {
/*     */         
/* 170 */         String fid = JRMCoreH.getString(p, FamilyCH.FID);
/* 171 */         String n = p.func_70005_c_();
/* 172 */         String[] s = fid.split(",");
/* 173 */         String fn = s[0];
/* 174 */         EntityPlayerMP pi = JRMCoreH.getPlayerForUsername(server, txt);
/* 175 */         if (pi != null) {
/*     */           
/* 177 */           String pfid = JRMCoreH.getString((EntityPlayer)pi, FamilyCH.FID);
/* 178 */           if (pfid.length() < 2) {
/*     */             
/* 180 */             JRMCoreH.setString("", (EntityPlayer)pi, FamilyCH.FIDi);
/* 181 */             JRMCoreH.setString(p.func_70005_c_(), (EntityPlayer)pi, FamilyCH.FIDa);
/* 182 */             String[] fns = fn.split(",");
/* 183 */             pi.func_145747_a((new ChatComponentText(y + "" + g + p.func_70005_c_() + y + " wants to adopt you" + ((fn.length() > 1) ? (". So you'd be apart of the " + g + fns[0] + y + " family") : "") + "!")).func_150255_a(color));
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 189 */       if (id == 3) {
/*     */         
/* 191 */         String prf = JRMCoreH.getString(p, FamilyCH.FIDi);
/* 192 */         EntityPlayerMP prfn = JRMCoreH.getPlayerForUsername(server, prf);
/* 193 */         String fidp = JRMCoreH.getString(p, FamilyCH.FID);
/* 194 */         if (prfn != null && fidp.length() < 2) {
/*     */           
/* 196 */           String fid = JRMCoreH.getString((EntityPlayer)prfn, FamilyCH.FID);
/* 197 */           String[] fida = fid.split(",");
/* 198 */           int ffd = Integer.parseInt(fida[1]);
/* 199 */           String fd = FamilyCH.rfi(server, fid);
/* 200 */           String[] famD = fd.split("!");
/* 201 */           String fn = (ffd == 0) ? famD[0] : "";
/* 202 */           String[] fm = (ffd == 0) ? famD[1].split(",") : famD[0].split(",");
/* 203 */           int fc = (ffd == 0) ? Integer.parseInt(famD[2]) : 0;
/* 204 */           String nf = "";
/* 205 */           boolean nnf = false;
/* 206 */           String cd = "";
/*     */           int i;
/* 208 */           for (i = 0; i < fm.length; i++) {
/*     */             
/* 210 */             String fh = fm[i];
/* 211 */             String[] fh2 = fh.split(":");
/* 212 */             if (i > 1 && fh2[0].equalsIgnoreCase(prf)) {
/*     */               
/* 214 */               nnf = true;
/* 215 */               cd = fh2[1];
/*     */             } 
/*     */           } 
/* 218 */           if (nnf) {
/*     */             
/* 220 */             String fD = prf + "," + p.func_70005_c_();
/* 221 */             String ff = fida[0] + "," + cd;
/* 222 */             JRMCoreH.setString(fid, (EntityPlayer)prfn, FamilyCH.FIDo);
/* 223 */             JRMCoreH.setString(ff, (EntityPlayer)prfn, FamilyCH.FID);
/* 224 */             JRMCoreH.setString(ff, p, FamilyCH.FID);
/* 225 */             FamilyCH.wfi(server, fD, ff, false);
/*     */           } else {
/* 227 */             for (i = 0; i < fm.length; i++) {
/* 228 */               String fh = fm[i];
/* 229 */               if (fh.length() < 2 && !fh.equalsIgnoreCase(prf) && i < 2) {
/* 230 */                 nf = nf + "," + p.func_70005_c_();
/* 231 */                 JRMCoreH.setString(fid, p, FamilyCH.FID);
/* 232 */                 JRMCoreH.setString("", p, FamilyCH.FIDi);
/* 233 */                 JRMCoreH.setString("", p, FamilyCH.FIDa);
/*     */               } else {
/* 235 */                 nf = nf + "," + fh;
/*     */               } 
/*     */             } 
/* 238 */             nf = nf.substring(1);
/* 239 */             String fD = (ffd == 0) ? (fn + "!" + nf + "!" + fc) : nf;
/* 240 */             FamilyCH.wfi(server, fD, fid, false);
/*     */           } 
/* 242 */           String[] fns = fn.split(",");
/* 243 */           prfn.func_145747_a((new ChatComponentText(y + "Proposal was accepted! You were married to " + g + p.func_70005_c_() + y + " and " + y + "joined the " + g + fns[0] + y + " family!")).func_150255_a(color));
/*     */           
/* 245 */           p.func_145747_a((new ChatComponentText(y + "You have married " + g + prfn.func_70005_c_() + y + " and so you joined the " + g + fns[0] + y + " family!")).func_150255_a(color));
/*     */         } else {
/* 247 */           p.func_145747_a((new ChatComponentText(y + "Marriage failed because " + g + prf + y + " was not found!")).func_150255_a(color));
/*     */         } 
/* 249 */         JRMCoreH.setString("", p, FamilyCH.FIDi);
/* 250 */         JRMCoreH.setString("", p, FamilyCH.FIDa);
/*     */       } 
/*     */ 
/*     */       
/* 254 */       if (id == 4) {
/*     */         
/* 256 */         String arf = JRMCoreH.getString(p, FamilyCH.FIDa);
/* 257 */         EntityPlayerMP arfn = JRMCoreH.getPlayerForUsername(server, arf);
/* 258 */         String fidp = JRMCoreH.getString(p, FamilyCH.FID);
/* 259 */         if (arfn != null && fidp.length() < 2) {
/* 260 */           String fid = JRMCoreH.getString((EntityPlayer)arfn, FamilyCH.FID);
/* 261 */           String[] fida = fid.split(",");
/* 262 */           int ffd = Integer.parseInt(fida[1]);
/* 263 */           String fd = FamilyCH.rfi(server, fid);
/* 264 */           String[] famD = fd.split("!");
/* 265 */           String fn = (ffd == 0) ? famD[0] : "";
/* 266 */           String[] fm = (ffd == 0) ? famD[1].split(",") : famD[0].split(",");
/* 267 */           int fc = (ffd == 0) ? Integer.parseInt(famD[2]) : 0;
/* 268 */           String nf = "";
/* 269 */           boolean nnf = false;
/* 270 */           String cd = "";
/* 271 */           for (int i = 0; i < fm.length; i++) {
/* 272 */             String fh = fm[i];
/* 273 */             String[] fh2 = fh.split(":");
/* 274 */             if (i > 1 && fh2[0].equalsIgnoreCase(arf)) {
/* 275 */               nnf = true;
/* 276 */               cd = fh2[1];
/*     */             } 
/*     */           } 
/*     */           
/* 280 */           String fid2 = fida[0] + ",0";
/* 281 */           String fd2 = FamilyCH.rfi(server, fid2);
/* 282 */           String[] famD2 = fd2.split("!");
/* 283 */           fc = Integer.parseInt(famD2[2]);
/*     */           
/* 285 */           fc++;
/* 286 */           if (nnf) {
/* 287 */             nf = arf + ",e," + p.func_70005_c_() + ":" + fc;
/* 288 */             String fnd = fida[0] + "," + cd;
/* 289 */             JRMCoreH.setString(fid, (EntityPlayer)arfn, FamilyCH.FIDo);
/* 290 */             JRMCoreH.setString(fnd, (EntityPlayer)arfn, FamilyCH.FID);
/* 291 */             JRMCoreH.setString(fnd, p, FamilyCH.FID);
/* 292 */             String fD = nf;
/* 293 */             FamilyCH.wfi(server, fD, fnd, false);
/*     */           } else {
/*     */             
/* 296 */             String fmwa = (ffd == 0) ? famD[1] : famD[0];
/* 297 */             nf = fmwa + "," + p.func_70005_c_() + ":" + fc;
/* 298 */             String fD = (ffd == 0) ? (fn + "!" + nf + "!" + fc) : nf;
/* 299 */             JRMCoreH.setString(fid, p, FamilyCH.FID);
/* 300 */             FamilyCH.wfi(server, fD, fid, false);
/*     */           } 
/* 302 */           if (ffd != 0) {
/* 303 */             fid = fida[0] + ",0";
/* 304 */             fd = FamilyCH.rfi(server, fid);
/* 305 */             famD = fd.split("!");
/* 306 */             fn = famD[0];
/* 307 */             String fms = famD[1];
/* 308 */             String fD = fn + "!" + fms + "!" + fc;
/* 309 */             FamilyCH.wfi(server, fD, fid, false);
/*     */           } 
/* 311 */           arfn.func_145747_a((new ChatComponentText(y + "Adoption offer was accepted! " + g + p.func_70005_c_() + y + " is now part of the " + g + fida[0] + y + " family!")).func_150255_a(color));
/* 312 */           p.func_145747_a((new ChatComponentText(y + "You have been adopted by " + g + arfn.func_70005_c_() + y + " and you are now part of the " + g + fida[0] + y + " family!")).func_150255_a(color));
/*     */         } else {
/* 314 */           p.func_145747_a((new ChatComponentText(y + "Adoption failed because " + g + arf + y + " was not found!")).func_150255_a(color));
/*     */         } 
/* 316 */         JRMCoreH.setString("", p, FamilyCH.FIDa);
/* 317 */         JRMCoreH.setString("", p, FamilyCH.FIDi);
/*     */       } 
/*     */ 
/*     */       
/* 321 */       if (id == 5) {
/*     */         
/* 323 */         JRMCoreH.setString("", p, FamilyCH.FIDi);
/* 324 */         JRMCoreH.setString("", p, FamilyCH.FIDa);
/*     */       } 
/*     */ 
/*     */       
/* 328 */       if (id == 6) {
/*     */         
/* 330 */         String fid = JRMCoreH.getString(p, FamilyCH.FID);
/* 331 */         String n = p.func_70005_c_();
/* 332 */         if (fid.length() > 2) {
/* 333 */           String[] fida = fid.split(",");
/* 334 */           int ffd = Integer.parseInt(fida[1]);
/* 335 */           String fd = FamilyCH.rfi(server, fid);
/* 336 */           String[] famD = fd.split("!");
/* 337 */           String fn = (ffd == 0) ? famD[0] : "";
/* 338 */           String[] fm = (ffd == 0) ? famD[1].split(",") : famD[0].split(",");
/*     */           
/* 340 */           int fc = (ffd == 0) ? Integer.parseInt(famD[2]) : 0;
/* 341 */           String nf = "";
/* 342 */           for (int i = 0; i < fm.length; i++) {
/* 343 */             String fh = fm[i];
/* 344 */             String[] fh2 = fh.split(":");
/* 345 */             if (fh2[0].equalsIgnoreCase(p.func_70005_c_())) {
/* 346 */               nf = nf + ((i < 2) ? ",l" : "");
/*     */             } else {
/* 348 */               nf = nf + "," + fh;
/*     */             } 
/*     */           } 
/* 351 */           nf = nf.substring(1);
/* 352 */           String fD = (ffd == 0) ? (fn + "!" + nf + "!" + fc) : nf;
/* 353 */           FamilyCH.wfi(server, fD, fid, false);
/*     */           
/* 355 */           String fido = JRMCoreH.getString(p, FamilyCH.FIDo);
/* 356 */           if (fido.length() > 2) {
/* 357 */             fida = fido.split(",");
/* 358 */             ffd = Integer.parseInt(fida[1]);
/* 359 */             String fdo = FamilyCH.rfi(server, fido);
/* 360 */             famD = fdo.split("!");
/* 361 */             fn = (ffd == 0) ? famD[0] : "";
/* 362 */             fm = (ffd == 0) ? famD[1].split(",") : famD[0].split(",");
/* 363 */             fc = (ffd == 0) ? Integer.parseInt(famD[2]) : 0;
/* 364 */             nf = "";
/* 365 */             for (int j = 0; j < fm.length; j++) {
/* 366 */               String fh = fm[j];
/* 367 */               String[] fh2 = fh.split(":");
/* 368 */               if (fh2[0].equalsIgnoreCase(p.func_70005_c_())) {
/* 369 */                 nf = nf + ((j < 2) ? ",l" : "");
/* 370 */                 JRMCoreH.setString("0", p, FamilyCH.FIDo);
/*     */               } else {
/* 372 */                 nf = nf + "," + fh;
/*     */               } 
/*     */             } 
/* 375 */             nf = nf.substring(1);
/* 376 */             fD = (ffd == 0) ? (fn + "!" + nf + "!" + fc) : nf;
/* 377 */             FamilyCH.wfi(server, fD, fido, false);
/*     */           } 
/* 379 */           String[] fns = fn.split(",");
/* 380 */           p.func_145747_a((new ChatComponentText(y + "You have left the " + g + fns[0] + y + " family!")).func_150255_a(color));
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 385 */       if (id == 7) {
/*     */         
/* 387 */         String fid = JRMCoreH.getString(p, FamilyCH.FID);
/* 388 */         String n = txt;
/* 389 */         EntityPlayerMP pud = JRMCoreH.getPlayerForUsername(server, n);
/* 390 */         if (fid.length() > 2 && n.length() > 1) {
/* 391 */           String[] fida = fid.split(",");
/* 392 */           String fnam = fida[0];
/* 393 */           int ffd = Integer.parseInt(fida[1]);
/*     */           
/* 395 */           String mfd = FamilyCH.rfi(server, fnam + ",0");
/* 396 */           if (mfd.contains("!")) {
/* 397 */             String[] mfD = mfd.split("!");
/* 398 */             int mfDi = Integer.parseInt(mfD[2]);
/* 399 */             for (int i = 0; i <= ffd; i++) {
/* 400 */               String fid2 = fnam + "," + i;
/* 401 */               String afm = FamilyCH.rfi(server, fid2);
/* 402 */               if (afm.length() > 3) {
/* 403 */                 String[] famDa = afm.split("!");
/* 404 */                 String fn = (i == 0) ? famDa[0] : "";
/* 405 */                 String[] fma = (i == 0) ? famDa[1].split(",") : famDa[0].split(",");
/* 406 */                 int fc = (i == 0) ? Integer.parseInt(famDa[2]) : 0;
/*     */                 
/* 408 */                 String nf = "";
/* 409 */                 for (int i2 = 0; i2 < fma.length; i2++) {
/* 410 */                   String fh = fma[i2];
/* 411 */                   String[] fh2 = fh.split(":");
/* 412 */                   if (fh2[0].equalsIgnoreCase(n)) {
/* 413 */                     nf = nf + ((i2 < 2) ? ",k" : "");
/* 414 */                     FamilyCH.wfmd(server, "1", n, false);
/*     */                   } else {
/* 416 */                     nf = nf + "," + fh;
/*     */                   } 
/*     */                 } 
/* 419 */                 nf = nf.substring(1);
/* 420 */                 String fD = (i == 0) ? (fn + "!" + nf + "!" + fc) : nf;
/* 421 */                 FamilyCH.wfi(server, fD, fid2, false);
/*     */               } 
/*     */             } 
/*     */           } 
/* 425 */           if (pud != null)
/*     */           {
/* 427 */             pud.func_145747_a((new ChatComponentText(y + "You have been removed from the " + g + fnam + y + " family by " + g + p.func_70005_c_() + y + "!")).func_150255_a(color));
/*     */           }
/* 429 */           p.func_145747_a((new ChatComponentText(y + "You have removed " + g + n + y + " from the " + g + fnam + y + " family!")).func_150255_a(color));
/*     */         } else {
/* 431 */           p.func_145747_a((new ChatComponentText(y + "Removing " + g + n + y + " failed!")).func_150255_a(color));
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 436 */       if (id == 8) {
/*     */         
/* 438 */         String prid = JRMCoreH.getString(p, FamilyCH.prID);
/* 439 */         EntityPlayerMP pt = JRMCoreH.getPlayerForUsername(server, (prid.length() > 2 && !prid.contains(";")) ? prid : "");
/* 440 */         if (pt != null && p != null) {
/* 441 */           String dnsTar = JRMCoreH.getString((EntityPlayer)pt, "jrmcDNS");
/* 442 */           int pa = gb(p, "jrmcAccept");
/* 443 */           int pta = gb((EntityPlayer)pt, "jrmcAccept");
/* 444 */           int pg = JRMCoreH.dnsGender(dns);
/* 445 */           int ptg = JRMCoreH.dnsGender(dnsTar);
/* 446 */           if (((pg == 0 && ptg == 1) || (pg == 1 && ptg == 0)) && pa == 1 && pta == 1) {
/* 447 */             byte R1 = gb(p, "jrmcRace");
/* 448 */             int G1 = pg;
/* 449 */             int H1B = JRMCoreH.dnsHairB(dns);
/* 450 */             int H1F = JRMCoreH.dnsHairF(dns);
/* 451 */             int H1C = JRMCoreH.dnsHairC(dns);
/* 452 */             int B1 = JRMCoreH.dnsBreast(dns);
/* 453 */             int S1T = JRMCoreH.dnsSkinT(dns);
/* 454 */             int B1T = JRMCoreH.dnsBodyT(dns);
/* 455 */             int B1CM = JRMCoreH.dnsBodyCM(dns);
/* 456 */             int B1C1 = JRMCoreH.dnsBodyC1(dns);
/* 457 */             int B1C2 = JRMCoreH.dnsBodyC2(dns);
/* 458 */             int B1C3 = JRMCoreH.dnsBodyC3(dns);
/* 459 */             int F1N = JRMCoreH.dnsFaceN(dns);
/* 460 */             int F1M = JRMCoreH.dnsFaceM(dns);
/* 461 */             int E1 = JRMCoreH.dnsEyes(dns);
/* 462 */             int E1C1 = JRMCoreH.dnsEyeC1(dns);
/* 463 */             int E1C2 = JRMCoreH.dnsEyeC2(dns);
/*     */             
/* 465 */             String dnsH = JRMCoreH.getString(p, "jrmcDNSH");
/*     */             
/* 467 */             byte R2 = gb((EntityPlayer)pt, "jrmcRace");
/* 468 */             int G2 = ptg;
/* 469 */             int H2B = JRMCoreH.dnsHairB(dnsTar);
/* 470 */             int H2F = JRMCoreH.dnsHairF(dnsTar);
/* 471 */             int H2C = JRMCoreH.dnsHairC(dnsTar);
/* 472 */             int B2 = JRMCoreH.dnsBreast(dnsTar);
/* 473 */             int S2T = JRMCoreH.dnsSkinT(dnsTar);
/* 474 */             int B2T = JRMCoreH.dnsBodyT(dnsTar);
/* 475 */             int B2CM = JRMCoreH.dnsBodyCM(dnsTar);
/* 476 */             int B2C1 = JRMCoreH.dnsBodyC1(dnsTar);
/* 477 */             int B2C2 = JRMCoreH.dnsBodyC2(dnsTar);
/* 478 */             int B2C3 = JRMCoreH.dnsBodyC3(dnsTar);
/* 479 */             int F2N = JRMCoreH.dnsFaceN(dnsTar);
/* 480 */             int F2M = JRMCoreH.dnsFaceM(dnsTar);
/* 481 */             int E2 = JRMCoreH.dnsEyes(dnsTar);
/* 482 */             int E2C1 = JRMCoreH.dnsEyeC1(dnsTar);
/* 483 */             int E2C2 = JRMCoreH.dnsEyeC2(dnsTar);
/*     */             
/* 485 */             String dnsH2 = JRMCoreH.getString((EntityPlayer)pt, "jrmcDNSH");
/*     */             
/* 487 */             if (FamilyCH.procWith(R1, R2)) {
/* 488 */               byte r = (byte)FamilyCH.procTR(R1, R2);
/* 489 */               Random ran = new Random();
/*     */               
/* 491 */               dnsRaceSlcted = r;
/*     */               
/* 493 */               dnsGenderSlcted = ran.nextInt(2);
/*     */               
/* 495 */               int rid = ran.nextInt(3);
/* 496 */               dnsHairSlcted = (rid == 0) ? H1B : ((rid == 1) ? H2B : ran.nextInt(JRMCoreH.Hairs.length));
/*     */               
/* 498 */               dnsHair2Slcted = H1F;
/*     */               
/* 500 */               rid = ran.nextInt(3);
/* 501 */               dnsColorSlcted = (rid == 0) ? H1C : ((rid == 1) ? H2C : ran.nextInt(16777000));
/*     */               
/* 503 */               dnsBreastSizeSlcted = ran.nextInt(9);
/*     */               
/* 505 */               boolean p1p2 = false;
/* 506 */               boolean p1 = false;
/* 507 */               boolean p2 = false;
/* 508 */               rid = ran.nextInt(3);
/* 509 */               if (S1T == 1 && S2T == 1) { p1p2 = true;
/* 510 */                 rid = (rid == 0) ? B1T : ((rid == 1) ? B2T : ran.nextInt(JRMCoreH.customSknLimits[r][0])); }
/* 511 */               else if (S1T == 1) { p1 = true;
/* 512 */                 rid = (rid == 0 || rid == 1) ? B1T : ran.nextInt(JRMCoreH.customSknLimits[r][0]); }
/* 513 */               else if (S2T == 1) { p2 = true;
/* 514 */                 rid = (rid == 0 || rid == 1) ? B2T : ran.nextInt(JRMCoreH.customSknLimits[r][0]); }
/*     */               else
/* 516 */               { rid = ran.nextInt(JRMCoreH.customSknLimits[r][0]); }
/*     */               
/* 518 */               dnsBodyTypeSlcted = rid;
/*     */               
/* 520 */               rid = ran.nextInt(JRMCoreH.customSknLimitsBCP[r]);
/* 521 */               int cls = (JRMCoreH.defbodycols[rid][r]).length;
/* 522 */               rid = ran.nextInt(4);
/* 523 */               dnsBodyColMainSlcted = (cls >= 1) ? ((rid == 0 && (p1p2 || p1)) ? B1CM : (((rid == 1 || (rid == 0 && !p1)) && (p1p2 || p2)) ? B2CM : ((rid == 2 || (rid < 2 && !p1p2 && !p1 && !p2)) ? JRMCoreH.defbodycols[ran.nextInt(JRMCoreH.customSknLimitsBCP[r])][r][0] : ran.nextInt(16777000)))) : 0;
/* 524 */               rid = ran.nextInt(4);
/* 525 */               dnsBodyColSub1Slcted = (cls >= 2) ? ((rid == 0 && (p1p2 || p1)) ? B1C1 : (((rid == 1 || (rid == 0 && !p1)) && (p1p2 || p2)) ? B2C1 : ((rid == 2 || (rid < 2 && !p1p2 && !p1 && !p2)) ? JRMCoreH.defbodycols[ran.nextInt(JRMCoreH.customSknLimitsBCP[r])][r][1] : ran.nextInt(16777000)))) : 0;
/* 526 */               rid = ran.nextInt(4);
/* 527 */               dnsBodyColSub2Slcted = (cls >= 3) ? ((rid == 0 && (p1p2 || p1)) ? B1C2 : (((rid == 1 || (rid == 0 && !p1)) && (p1p2 || p2)) ? B2C2 : ((rid == 2 || (rid < 2 && !p1p2 && !p1 && !p2)) ? JRMCoreH.defbodycols[ran.nextInt(JRMCoreH.customSknLimitsBCP[r])][r][2] : ran.nextInt(16777000)))) : 0;
/* 528 */               rid = ran.nextInt(4);
/* 529 */               dnsBodyColSub3Slcted = (cls >= 4) ? ((rid == 0 && (p1p2 || p1)) ? B1C3 : (((rid == 1 || (rid == 0 && !p1)) && (p1p2 || p2)) ? B2C3 : ((rid == 2 || (rid < 2 && !p1p2 && !p1 && !p2)) ? JRMCoreH.defbodycols[ran.nextInt(JRMCoreH.customSknLimitsBCP[r])][r][3] : ran.nextInt(16777000)))) : 0;
/*     */               
/* 531 */               rid = ran.nextInt(3);
/* 532 */               dnsFaceNoseSlcted = (rid == 0 && (p1p2 || p1)) ? F1N : (((rid == 1 || (rid == 0 && !p1)) && (p1p2 || p2)) ? F2N : ran.nextInt(JRMCoreH.customSknLimits[r][2]));
/* 533 */               rid = ran.nextInt(3);
/* 534 */               dnsFaceMouthSlcted = (rid == 0 && (p1p2 || p1)) ? F1M : (((rid == 1 || (rid == 0 && !p1)) && (p1p2 || p2)) ? F2M : ran.nextInt(JRMCoreH.customSknLimits[r][3]));
/*     */               
/* 536 */               rid = ran.nextInt(3);
/* 537 */               dnsEyesSlcted = (rid == 0 && (p1p2 || p1)) ? E1 : (((rid == 1 || (rid == 0 && !p1)) && (p1p2 || p2)) ? E2 : ran.nextInt(JRMCoreH.customSknLimits[r][4]));
/* 538 */               rid = ran.nextInt(4);
/* 539 */               int rid2 = ran.nextInt(5);
/* 540 */               dnsEyeCol1Slcted = (rid == 0 && (p1p2 || p1)) ? E1C1 : (((rid == 1 || (rid == 0 && !p1)) && (p1p2 || p2)) ? E2C1 : ((rid == 2 || (rid < 2 && !p1p2 && !p1 && !p2)) ? JRMCoreH.defeyecols[ran.nextInt(JRMCoreH.defeyecols.length)][r] : ran.nextInt(16777000)));
/* 541 */               rid = ran.nextInt(4);
/* 542 */               dnsEyeCol2Slcted = (rid2 != 0) ? dnsEyeCol1Slcted : ((rid == 0 && (p1p2 || p1)) ? E1C1 : (((rid == 1 || (rid == 0 && !p1)) && (p1p2 || p2)) ? E2C1 : ((rid == 2 || (rid < 2 && !p1p2 && !p1 && !p2)) ? JRMCoreH.defeyecols[ran.nextInt(JRMCoreH.defeyecols.length)][r] : ran.nextInt(16777000))));
/*     */               
/* 544 */               setdns();
/*     */               
/* 546 */               String dnsHdef = JRMCoreH.defHairPrsts[ran.nextInt(JRMCoreH.defHairPrsts.length)];
/* 547 */               rid = ran.nextInt(2);
/* 548 */               String dnsHc = (dnsHairSlcted != 12) ? "0" : ((H1B == 12 && H2B == 12) ? ((rid == 0) ? dnsH : dnsH2) : ((H1B == 12) ? dnsH : ((H2B == 12) ? dnsH2 : dnsHdef)));
/*     */               
/* 550 */               EntityPlayer e = (ptg == 1) ? (EntityPlayer)pt : ((pg == 1) ? p : p);
/* 551 */               EntityPlayer e2 = (ptg == 0) ? (EntityPlayer)pt : ((pg == 0) ? p : (EntityPlayer)pt);
/* 552 */               this; JRMCoreH.setString(Handler.dns + ";" + e.func_70005_c_() + ";" + e2.func_70005_c_() + ";" + txt + ";" + (FamilyCConfig.pt * 120) + ";" + dnsHc, e, FamilyCH.prID);
/* 553 */               JRMCoreH.setString("f", e2, FamilyCH.prID);
/* 554 */               e2.func_145747_a((new ChatComponentText(y + "" + g + e.func_70005_c_() + y + " is now pregnant, thanks to you!")).func_150255_a(color));
/* 555 */               e.func_145747_a((new ChatComponentText(y + "You've become pregnant! The father is " + g + e2.func_70005_c_() + y + ".")).func_150255_a(color));
/*     */             }
/*     */           
/*     */           } 
/*     */         } else {
/*     */           
/* 561 */           JRMCoreH.setString("n", p, FamilyCH.prID);
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 566 */       if (id == 9) {
/*     */         
/* 568 */         String prid = JRMCoreH.getString(p, FamilyCH.prID);
/* 569 */         EntityPlayerMP po = JRMCoreH.getPlayerForUsername(server, prid);
/* 570 */         if (po != null) po.func_145747_a((new ChatComponentText(y + "" + p.func_70005_c_() + " has declined your procreation offer!")).func_150255_a(color)); 
/* 571 */         JRMCoreH.setString("d", p, FamilyCH.prID);
/*     */       } 
/*     */ 
/*     */       
/* 575 */       if (id == 10) {
/*     */         
/* 577 */         EntityPlayerMP po = JRMCoreH.getPlayerForUsername(server, txt);
/* 578 */         String dnsTar = JRMCoreH.getString((EntityPlayer)po, "jrmcDNS");
/* 579 */         int pg = JRMCoreH.dnsGender(dns);
/* 580 */         int pog = JRMCoreH.dnsGender(dnsTar);
/* 581 */         byte R1 = gb(p, "jrmcRace");
/* 582 */         byte R2 = gb((EntityPlayer)po, "jrmcRace");
/* 583 */         if (FamilyCConfig.mc == 0 || FamilyCConfig.dcr) {
/* 584 */           p.func_145747_a((new ChatComponentText(y + "Procreation is disabled by the server!")).func_150255_a(color));
/*     */         }
/* 586 */         else if (FamilyCH.procWith(R1, R2) && 
/* 587 */           po != null && ((pg == 0 && pog == 1) || (pg == 1 && pog == 0))) {
/* 588 */           boolean allow = true;
/* 589 */           String p1 = FamilyCH.rpfd(server, txt);
/* 590 */           if (p1.contains(";")) {
/* 591 */             String[] p1d = p1.split(";");
/* 592 */             if (p1d.length >= FamilyCConfig.mc) {
/* 593 */               p.func_145747_a((new ChatComponentText(y + "" + g + txt + y + " has already " + FamilyCConfig.mc + " children!")).func_150255_a(color));
/* 594 */               allow = false;
/*     */             } else {
/* 596 */               String p2 = FamilyCH.rpfd(server, p.func_70005_c_());
/* 597 */               if (p2.contains(";")) {
/* 598 */                 String[] p2d = p2.split(";");
/* 599 */                 if (p2d.length >= FamilyCConfig.mc) {
/* 600 */                   p.func_145747_a((new ChatComponentText(y + "" + g + p.func_70005_c_() + y + " has already " + FamilyCConfig.mc + " children!")).func_150255_a(color));
/* 601 */                   allow = false;
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } 
/* 606 */           if (allow) {
/* 607 */             String prid = JRMCoreH.getString((pg == 1) ? p : (EntityPlayer)po, FamilyCH.prID);
/* 608 */             if (!prid.contains(";") || prid.equals("") || prid == "") {
/* 609 */               JRMCoreH.setString(p.func_70005_c_(), (EntityPlayer)po, FamilyCH.prID);
/* 610 */               p.func_145747_a((new ChatComponentText(y + "A procreation offer has been sent!")).func_150255_a(color));
/* 611 */               po.func_145747_a((new ChatComponentText(y + "You've recived a procreation offer from " + g + p.func_70005_c_() + y + "!")).func_150255_a(color));
/*     */             } else {
/*     */               
/* 614 */               p.func_145747_a((new ChatComponentText(y + ((pg == 1) ? "You are" : (g + txt + y + " is")) + " already pregnant!")).func_150255_a(color));
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 622 */       if (id == 20) {
/*     */         
/* 624 */         String[] dat = txt.split(":");
/* 625 */         int eid = Integer.parseInt(dat[0]);
/* 626 */         int follow = Integer.parseInt(dat[1]);
/* 627 */         boolean aggro = (Integer.parseInt(dat[2]) == 1);
/* 628 */         int fid = Integer.parseInt(dat[3]);
/* 629 */         int drp = Integer.parseInt(dat[4]);
/* 630 */         Entity pl = p.field_70170_p.func_73045_a(eid);
/* 631 */         if (pl != null && pl instanceof EntityNPC) {
/* 632 */           EntityNPC npl = (EntityNPC)pl;
/* 633 */           if (p.func_70005_c_().equalsIgnoreCase(npl.getDad()) || p.func_70005_c_().equalsIgnoreCase(npl.getMom())) {
/* 634 */             npl.setFollow(follow);
/* 635 */             npl.setAggr(aggro);
/* 636 */             npl.setFollowTarget(fid);
/* 637 */             if (drp == 1) ((EntityNPC)pl).func_82160_b(true, 0);
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 643 */       if (id == 21) {
/*     */         
/* 645 */         boolean allow = true;
/* 646 */         String p1 = FamilyCH.rpfd(server, p.func_70005_c_());
/* 647 */         String[] p1d = p1.split(";");
/* 648 */         String c = "";
/* 649 */         for (int i = 0; i < p1d.length; i++) {
/* 650 */           String[] d = p1d[i].split(":");
/* 651 */           c = c + ";" + FamilyCH.rcfd(server, d[0]) + ":" + FamilyCH.rcpd(server, d[0]);
/*     */         } 
/* 653 */         c = c.substring(1);
/* 654 */         if (c.length() > 2) {
/* 655 */           FamilyCH.jfcd(21, c, p);
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 660 */       if (id == 22) {
/*     */         
/* 662 */         String[] dat = txt.split(":");
/* 663 */         int eid = Integer.parseInt(dat[0]);
/* 664 */         String n = dat[1];
/* 665 */         Entity pl = p.field_70170_p.func_73045_a(eid);
/* 666 */         if (pl != null && pl instanceof EntityNPC) {
/*     */           
/* 668 */           EntityNPC entityNPC = (EntityNPC)pl;
/* 669 */           if (p.func_70005_c_().equalsIgnoreCase(entityNPC.getDad()) || p.func_70005_c_().equalsIgnoreCase(entityNPC.getMom())) {
/* 670 */             entityNPC.setCnam((byte)0);
/* 671 */             entityNPC.setNam(n);
/* 672 */             entityNPC.setNamUpdt(true);
/* 673 */             String d = FamilyCH.rcfd(server, entityNPC.getCid() + "");
/* 674 */             String[] prt = d.split(":");
/* 675 */             FamilyCH.wcfd(server, prt[1] + ":" + prt[2] + ":" + n, entityNPC.getCid(), false);
/* 676 */             FamilyCH.jfcd(23, entityNPC.func_145782_y() + "", p);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 682 */       if (id == 23) {
/*     */         
/* 684 */         String[] dat = txt.split(":");
/* 685 */         int eid = Integer.parseInt(dat[0]);
/* 686 */         String type = dat[1];
/* 687 */         String dnsNPC = dat[2];
/* 688 */         Entity entity = p.field_70170_p.func_73045_a(eid);
/* 689 */         if (entity != null && entity instanceof EntityNPC) {
/*     */           
/* 691 */           EntityNPC entityNPC = (EntityNPC)entity;
/* 692 */           if (p.func_70005_c_().equalsIgnoreCase(entityNPC.getDad()) || p.func_70005_c_().equalsIgnoreCase(entityNPC.getMom())) {
/*     */             
/* 694 */             if (type.equals("dns"))
/*     */             {
/* 696 */               entityNPC.setDNS(dnsNPC);
/*     */             }
/*     */             
/* 699 */             if (type.equals("dnsH"))
/*     */             {
/* 701 */               entityNPC.setDNSH(dnsNPC);
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 707 */       return null;
/*     */     }
/*     */     
/* 710 */     private static String ntl(int i) { return JRMCoreH.numToLet(i); }
/* 711 */     private static String ntl5(int i) { return JRMCoreH.numToLet5(i); }
/* 712 */     private static byte gb(EntityPlayer p, String s) { return JRMCoreH.getByte(p, s); } private static int gi(EntityPlayer p, String s) {
/* 713 */       return JRMCoreH.getInt(p, s);
/*     */     }
/*     */     public static void setdns() {
/* 716 */       String R = ntl(dnsRaceSlcted);
/* 717 */       String G = dnsGenderSlcted + "";
/* 718 */       String H1 = ntl(dnsHairSlcted);
/* 719 */       String H2 = ntl(dnsHair2Slcted);
/* 720 */       String HC = ntl5(dnsColorSlcted);
/* 721 */       String BS = dnsBreastSizeSlcted + "";
/* 722 */       String ST = "1";
/* 723 */       String BT = ntl(dnsBodyTypeSlcted);
/* 724 */       String BCM = ntl5(dnsBodyColMainSlcted);
/* 725 */       String BC1 = ntl5(dnsBodyColSub1Slcted);
/* 726 */       String BC2 = ntl5(dnsBodyColSub2Slcted);
/* 727 */       String BC3 = ntl5(dnsBodyColSub3Slcted);
/* 728 */       String FN = ntl(dnsFaceNoseSlcted);
/* 729 */       String FM = ntl(dnsFaceMouthSlcted);
/* 730 */       String ET = ntl(dnsEyesSlcted);
/* 731 */       String EC1 = ntl5(dnsEyeCol1Slcted);
/* 732 */       String EC2 = ntl5(dnsEyeCol2Slcted);
/*     */ 
/*     */       
/* 735 */       dns = R + G + H1 + H2 + HC + BS + ST + BT + BCM + BC1 + BC2 + BC3 + FN + FM + ET + EC1 + EC2;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\p\FamilyCP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */