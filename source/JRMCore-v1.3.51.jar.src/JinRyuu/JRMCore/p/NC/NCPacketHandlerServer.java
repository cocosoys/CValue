/*     */ package JinRyuu.JRMCore.p.NC;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.entity.EntityEnergyAttJ;
/*     */ import JinRyuu.JRMCore.entity.EntityEnergyAttJ2;
/*     */ import JinRyuu.JRMCore.entity.EntityEnergyAttJ3;
/*     */ import JinRyuu.JRMCore.i.ExtendedPlayer;
/*     */ import JinRyuu.JRMCore.p.PD;
/*     */ import JinRyuu.NarutoC.common.Entitys.hgTaiKaiEntity;
/*     */ import JinRyuu.NarutoC.common.NCJutsus;
/*     */ import JinRyuu.NarutoC.common.Npcs.EntityNCjutsuBunshin;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.util.Vec3;
/*     */ 
/*     */ 
/*     */ public class NCPacketHandlerServer
/*     */ {
/*     */   public void handleJRNC(int c, String d, EntityPlayer Player) {
/*  31 */     if (d.equalsIgnoreCase("copy")) {
/*  32 */       MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
/*  33 */       Entity tr = server.func_130014_f_().func_73045_a(c);
/*  34 */       EntityPlayerMP targ = (tr instanceof EntityPlayerMP) ? (EntityPlayerMP)tr : null;
/*  35 */       if (targ != null) {
/*  36 */         PD.sendTo(new NCPData2(Player.func_145782_y(), d), targ);
/*     */       }
/*     */     } else {
/*  39 */       MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
/*  40 */       EntityPlayerMP targ = (EntityPlayerMP)server.func_130014_f_().func_73045_a(c);
/*  41 */       String[] ds = d.split(";");
/*     */       
/*  43 */       int s = Integer.parseInt(ds[0]);
/*  44 */       if (s != 0 && s != 9) {
/*  45 */         d = JRMCoreH.getString(Player, JRMCoreH.techNbt[s - 1]);
/*  46 */         if (d.length() < 3) {
/*  47 */           s = Integer.parseInt(d);
/*  48 */           d = "";
/*  49 */           for (int i = 0; i < (JRMCoreH.pmj[s]).length; i++) {
/*  50 */             d = d + JRMCoreH.pmj[s][i] + ";";
/*     */           }
/*  52 */           d = d + s;
/*     */         } 
/*  54 */         JRMCoreH.setString(d, (EntityPlayer)targ, "jrmcTechC");
/*     */       } 
/*  56 */       if (targ != null) PD.sendTo(new NCPData2(Player.func_145782_y(), d), targ); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void handleJRNC(byte dt, byte d1, EntityPlayer Player) {
/*  61 */     if (dt == 0) {
/*  62 */       if (d1 == 10) {
/*  63 */         JRMCoreH.setByte(1, Player, "jrmcFrng");
/*     */       }
/*  65 */       else if (d1 == 11) {
/*  66 */         JRMCoreH.setByte(0, Player, "jrmcFrng");
/*     */       }
/*  68 */       else if (d1 == 12) {
/*  69 */         JRMCoreH.setByte(1, Player, "jrmcdj");
/*     */       }
/*  71 */       else if (d1 == 13) {
/*  72 */         JRMCoreH.setByte(2, Player, "jrmcdj");
/*     */       } else {
/*  74 */         NBTTagCompound nbt = JRMCoreH.nbt(Player);
/*  75 */         int[] PlyrAttrbts = JRMCoreH.PlyrAttrbts(Player);
/*     */         
/*  77 */         String PlyrSkillX = JRMCoreH.getString(Player, "jrmcSSltX");
/*  78 */         String PlyrSkillY = JRMCoreH.getString(Player, "jrmcSSltY");
/*  79 */         String[] PlyrSkills = JRMCoreH.getString(Player, "jrmcSSlts").split(",");
/*     */         
/*  81 */         byte rc = JRMCoreH.getByte(Player, "jrmcRace");
/*  82 */         byte pwr = JRMCoreH.getByte(Player, "jrmcPwrtyp");
/*  83 */         byte cls = JRMCoreH.getByte(Player, "jrmcClass");
/*     */         
/*  85 */         int maxEnergy = JRMCoreH.stat((Entity)Player, 5, pwr, 5, PlyrAttrbts[5], rc, cls, 0.0F);
/*     */         
/*  87 */         int curEn = JRMCoreH.getInt(Player, "jrmcEnrgy");
/*  88 */         int curBo = JRMCoreH.getInt(Player, "jrmcBdy");
/*  89 */         byte align = JRMCoreH.getByte(Player, "jrmcAlign");
/*  90 */         byte state = JRMCoreH.getByte(Player, "jrmcState");
/*  91 */         byte trans = (byte)(state + 1);
/*     */         
/*  93 */         int ma = JRMCoreH.SklLvlY(2, PlyrSkillY);
/*     */         
/*  95 */         int tj = JRMCoreH.SklLvl(0, 2, PlyrSkills);
/*  96 */         int ni = JRMCoreH.SklLvl(1, 2, PlyrSkills);
/*  97 */         int ge = JRMCoreH.SklLvl(2, 2, PlyrSkills);
/*  98 */         int md = JRMCoreH.SklLvl(9, 2, PlyrSkills);
/*  99 */         int cc = JRMCoreH.SklLvl(3, 2, PlyrSkills);
/* 100 */         int afi = JRMCoreH.SklLvl(4, 2, PlyrSkills);
/* 101 */         int awi = JRMCoreH.SklLvl(5, 2, PlyrSkills);
/* 102 */         int ali = JRMCoreH.SklLvl(6, 2, PlyrSkills);
/* 103 */         int aea = JRMCoreH.SklLvl(7, 2, PlyrSkills);
/* 104 */         int awa = JRMCoreH.SklLvl(8, 2, PlyrSkills);
/* 105 */         boolean may = false;
/*     */         
/* 107 */         Entity var8 = null;
/* 108 */         String s = (d1 == 100) ? JRMCoreH.getString(Player, "jrmcTechC") : JRMCoreH.getString(Player, JRMCoreH.techNbt[d1]);
/*     */         
/* 110 */         if ((d1 >= 0 && d1 < 4 && s != null && s.length() > 0) || (d1 == 100 && s != null && (s.split(";")).length == 15)) {
/* 111 */           byte curRel = JRMCoreH.getByte(Player, "jrmcRelease");
/* 112 */           if (curRel > 0) {
/* 113 */             String[] tech = ((d1 == 100) ? s : s).toString().split(";");
/* 114 */             if (tech != null && tech.length > 9) {
/* 115 */               String name = tech[0];
/* 116 */               byte type = Byte.parseByte(tech[3]);
/* 117 */               byte speed = Byte.parseByte(tech[4]);
/* 118 */               int dam = Integer.parseInt(tech[5]);
/* 119 */               byte effect = Byte.parseByte(tech[6]);
/* 120 */               int cost = Integer.parseInt(tech[7]);
/* 121 */               byte color = Byte.parseByte(tech[10]);
/* 122 */               byte density = Byte.parseByte(tech[11]);
/* 123 */               byte sincantation = 0;
/* 124 */               byte sfire = 0;
/* 125 */               byte smove = 0;
/* 126 */               if (tech.length > 12) {
/* 127 */                 sincantation = Byte.parseByte(tech[12]);
/* 128 */                 sfire = Byte.parseByte(tech[13]);
/* 129 */                 smove = Byte.parseByte(tech[14]);
/*     */               } 
/* 131 */               int typ = type;
/* 132 */               int sped = speed;
/* 133 */               int effe = effect;
/* 134 */               double costP = JRMCoreH.round(JRMCoreH.techNCCostP[cost] * curRel * 0.009999999776482582D, 1);
/* 135 */               int cst = (int)(costP * 0.009999999776482582D * maxEnergy);
/* 136 */               cst = (cst < 1) ? 1 : cst;
/* 137 */               int dmg1 = (int)(cst - cst * 0.25F * sped + ((typ == 0) ? (cst * 0.2F) : 0.0F));
/* 138 */               int dmg = dmg1;
/*     */               
/* 140 */               int af = 0;
/* 141 */               if (effe == 0 && afi > 0) { may = true; af = afi; }
/* 142 */               else if (effe == 1 && awi > 0) { may = true; af = awi; }
/* 143 */               else if (effe == 2 && ali > 0) { may = true; af = ali; }
/* 144 */               else if (effe == 3 && aea > 0) { may = true; af = aea; }
/* 145 */               else if (effe == 4 && awa > 0) { may = true; af = awa; }
/* 146 */               else if (effe > 4) { may = true; af = ni; }
/*     */               
/* 148 */               if (cst < curEn && may) {
/*     */                 
/* 150 */                 if (!JRMCoreH.isInCreativeMode((Entity)Player)) JRMCoreH.setInt(curEn - cst, Player, "jrmcEnrgy"); 
/* 151 */                 String snd = "";
/* 152 */                 String snd2 = "";
/* 153 */                 if (density == 1) {
/* 154 */                   if (JRMCoreH.techNCSndIncAff.length > effe) snd = JRMCoreH.techNCSndIncAff[effe]; 
/* 155 */                   if (JRMCoreH.techNCSndIncTyp.length > type) snd2 = JRMCoreH.techNCSndIncTyp[type]; 
/*     */                 } 
/* 157 */                 if (density == 2 && 
/* 158 */                   JRMCoreH.techNCSndIncCls.length > density) snd2 = JRMCoreH.techNCSndIncCls[density];
/*     */                 
/* 160 */                 if (density == 4) {
/* 161 */                   if (JRMCoreH.techNCSndIncAff.length > effe) snd = JRMCoreH.techNCSndIncAff[effe]; 
/* 162 */                   if (JRMCoreH.techNCSndIncCls.length > density) snd2 = JRMCoreH.techNCSndIncCls[density]; 
/*     */                 } 
/* 164 */                 byte P = JRMCoreH.getByte(Player, "jrmcPtch");
/* 165 */                 float ptch = (P == 0) ? 1.0F : (0.8F + P * 0.006F);
/* 166 */                 Player.field_70170_p.func_72956_a((Entity)Player, "jinryuunarutoc:NC2." + snd, 1.0F, ptch);
/* 167 */                 Player.field_70170_p.func_72956_a((Entity)Player, "jinryuunarutoc:NC2." + snd2, 1.0F, ptch);
/* 168 */                 if (density == 1) {
/* 169 */                   if (ni > 0) {
/* 170 */                     double d = dmg / 50.0D;
/* 171 */                     dmg = (int)(d * 20.0D + d * (ni * 2.0D + af));
/* 172 */                     dmg = (dmg < 1) ? 1 : dmg;
/* 173 */                     EntityEnergyAttJ entityEnergyAttJ = new EntityEnergyAttJ((EntityLivingBase)Player, type, speed, dmg, effect, color, density, sincantation, sfire, smove, (byte)-1, dmg1, cst, cost);
/*     */                     
/* 175 */                     entityEnergyAttJ.setJutsuName(name);
/* 176 */                     Player.field_70170_p.func_72838_d((Entity)entityEnergyAttJ);
/*     */                   } else {
/* 178 */                     Player.func_145747_a((IChatComponent)new ChatComponentText(JRMCoreH.cly + "You need to learn the " + JRMCoreH.clgd + JRMCoreH.trl("nc", JRMCoreH.NCSkillNames[1]) + JRMCoreH.cly + " Skill!"));
/*     */                   } 
/*     */                 }
/* 181 */               } else if (cst > curEn) {
/* 182 */                 Player.func_145747_a((IChatComponent)new ChatComponentText(JRMCoreH.cly + "Not Enough Chakra!"));
/* 183 */               } else if (!may) {
/* 184 */                 Player.func_145747_a((IChatComponent)new ChatComponentText(JRMCoreH.cly + "You need to learn the " + JRMCoreH.clgd + JRMCoreH.trl("nc", JRMCoreH.techNCEffects[effe]) + JRMCoreH.cly + " Affinity Skill!"));
/*     */               }
/*     */             
/*     */             }
/*     */           
/*     */           } 
/* 190 */         } else if ((d1 >= 4 && d1 < 8 && s != null && s.length() > 0) || (d1 == 100 && s != null && (s.split(";")).length == 16)) {
/*     */           
/* 192 */           if (d1 == 100) s = s.split(";")[15]; 
/* 193 */           int tn = Integer.parseInt(s);
/* 194 */           byte curRel = JRMCoreH.getByte(Player, "jrmcRelease");
/* 195 */           String[] tech = JRMCoreH.pmj[tn];
/* 196 */           if (tech != null && tech.length > 9) {
/* 197 */             byte type = Byte.parseByte(tech[3]);
/* 198 */             byte speed = Byte.parseByte(tech[4]);
/* 199 */             int dam = Integer.parseInt(tech[5]);
/* 200 */             byte effect = Byte.parseByte(tech[6]);
/* 201 */             int cost = Integer.parseInt(tech[7]);
/* 202 */             byte color = Byte.parseByte(tech[10]);
/* 203 */             byte density = Byte.parseByte(tech[11]);
/* 204 */             byte sincantation = 0;
/* 205 */             byte sfire = 0;
/* 206 */             byte smove = 0;
/* 207 */             if (tech.length > 12) {
/* 208 */               sincantation = Byte.parseByte(tech[12]);
/* 209 */               sfire = Byte.parseByte(tech[13]);
/* 210 */               smove = Byte.parseByte(tech[14]);
/*     */             } 
/*     */             
/* 213 */             int typ = type;
/* 214 */             int sped = speed;
/* 215 */             int effe = effect;
/* 216 */             double costP = JRMCoreH.round(JRMCoreH.techNCCostP[cost] * curRel * 0.01D, 1);
/*     */             
/* 218 */             int cst = (int)(costP * 0.01D * maxEnergy);
/* 219 */             cst = (cst < 1) ? 1 : cst;
/* 220 */             int dmg1 = (int)(cst - cst * 0.25D * sped + ((typ == 0) ? (cst * 0.2D) : 0.0D));
/* 221 */             int dmg = dmg1;
/*     */             
/* 223 */             int af = 0;
/* 224 */             if (effe == 0 && afi > 0) { may = true; af = afi; }
/* 225 */             else if (effe == 1 && awi > 0) { may = true; af = awi; }
/* 226 */             else if (effe == 2 && ali > 0) { may = true; af = ali; }
/* 227 */             else if (effe == 3 && aea > 0) { may = true; af = aea; }
/* 228 */             else if (effe == 4 && awa > 0) { may = true; af = awa; }
/* 229 */             else { may = true; af = ni; }
/*     */             
/* 231 */             String snd = "";
/* 232 */             String snd2 = "";
/* 233 */             if (density == 1) {
/* 234 */               snd = "NC1." + JRMCoreH.techNCSndIncPM[sincantation];
/*     */             }
/* 236 */             if (density == 2 && 
/* 237 */               JRMCoreH.techNCSndIncCls.length > density) snd2 = "NC2." + JRMCoreH.techNCSndIncCls[density];
/*     */             
/* 239 */             if (density == 4) {
/* 240 */               if (JRMCoreH.techNCSndIncAff.length > effe) snd = "NC2." + JRMCoreH.techNCSndIncAff[effe]; 
/* 241 */               if (sfire == 7) { snd2 = "NC2." + JRMCoreH.techNCSndIncSpec[sfire]; }
/* 242 */               else if (JRMCoreH.techNCSndIncCls.length > density) { snd2 = "NC2." + JRMCoreH.techNCSndIncCls[density]; }
/*     */             
/* 244 */             }  if (density == 5) {
/* 245 */               soundPowerUp(Player, "jinryuunarutoc:NC1.Chakra_Focus");
/*     */             }
/* 247 */             if (cst <= curEn && may) {
/*     */               hgTaiKaiEntity hgTaiKaiEntity;
/* 249 */               boolean wcbu = true;
/*     */               
/* 251 */               if (density == 1) {
/* 252 */                 if (ni > 0 && af > 0) {
/*     */                   
/* 254 */                   double d = (dmg / 50.0F);
/* 255 */                   dmg = (int)(d * 20.0D + d * (ni * 2.0D + af));
/*     */                   
/* 257 */                   byte dat = 0;
/* 258 */                   if (snd.contains("Rasengan")) { dat = 1; }
/* 259 */                   else if (snd.contains("Chidori")) { dat = 2; }
/* 260 */                   else if (snd.contains("Katon_Hous")) { dat = 3; }
/* 261 */                   else if (snd.contains("Earth_Wall")) { dat = 4; }
/* 262 */                   else if (snd.contains("Mud_Wall")) { dat = 5; }
/* 263 */                   else if (snd.contains("Water_Pistol")) { dat = 6; }
/*     */                   
/* 265 */                   if (dat == 4 || dat == 5) {
/* 266 */                     double d8 = (Player.field_70130_N + 1.0F);
/* 267 */                     double d9 = Player.field_70131_O;
/* 268 */                     Vec3 vec3 = Player.func_70676_i(1.0F);
/*     */                     
/* 270 */                     double x = Player.field_70165_t + vec3.field_72450_a * d8;
/* 271 */                     double y = Player.field_70163_u + vec3.field_72448_b * d8 + (Player.field_70131_O * 0.55F);
/* 272 */                     double z = Player.field_70161_v + vec3.field_72449_c * d8;
/*     */                     
/* 274 */                     int spot = -1;
/* 275 */                     int checked = 0;
/* 276 */                     for (int i = (int)y; spot == -1 && checked < 3; i--) {
/* 277 */                       if (!Player.field_70170_p.func_147439_a((int)x, i, (int)z).func_149739_a().toLowerCase().contains("air")) {
/* 278 */                         spot = i + 1;
/* 279 */                         y = spot;
/*     */                         break;
/*     */                       } 
/* 282 */                       checked++;
/*     */                     } 
/* 284 */                     if (spot != -1) {
/* 285 */                       EntityEnergyAttJ3 entityEnergyAttJ3 = new EntityEnergyAttJ3(dat, (EntityLivingBase)Player, type, dmg, (byte)tn, dmg1, cst, cost);
/*     */                     } else {
/* 287 */                       wcbu = false;
/* 288 */                       Player.func_145747_a((IChatComponent)new ChatComponentText(JRMCoreH.cly + "Failed to create Wall!" + JRMCoreH.cly));
/*     */                     }
/*     */                   
/* 291 */                   } else if (dat > 0) {
/* 292 */                     if (dat < 3) {
/* 293 */                       ExtendedPlayer.get(Player).setHandEffect(dat);
/* 294 */                       ExtendedPlayer.get(Player).setEffect_used(1);
/* 295 */                       ExtendedPlayer.get(Player).setEffect_used2(dmg);
/*     */                     } else {
/*     */                       
/* 298 */                       float spd = speed * (1.0F + af * 0.05F);
/* 299 */                       EntityEnergyAttJ2 entityEnergyAttJ2 = new EntityEnergyAttJ2(dat, (EntityLivingBase)Player, type, spd, dmg, effect, color, density, sincantation, sfire, smove, (byte)tn, dmg1, cst, cost);
/*     */                     } 
/*     */                   } else {
/* 302 */                     EntityEnergyAttJ entityEnergyAttJ = new EntityEnergyAttJ((EntityLivingBase)Player, type, speed, dmg, effect, color, density, sincantation, sfire, smove, (byte)tn, dmg1, cst, cost);
/*     */                   } 
/*     */                 } else {
/* 305 */                   Player.func_145747_a((IChatComponent)new ChatComponentText(JRMCoreH.cly + "You need to learn the " + JRMCoreH.clgd + JRMCoreH.trl("nc", JRMCoreH.NCSkillNames[1]) + JRMCoreH.cly + " Skill!"));
/*     */                 } 
/* 307 */               } else if (density == 2) {
/* 308 */                 if (ge > 0) {
/* 309 */                   byte cl = JRMCoreH.getByte(Player, "jrmcClass");
/* 310 */                   String doujutsu = JRMCoreH.ncCSkls[cl];
/* 311 */                   String s2 = JRMCoreH.getString(Player, "jrmcSSltY");
/* 312 */                   int t = 0;
/* 313 */                   if (s2 != null && s2.length() > 2 && cl != 0 && doujutsu.equals("SG")) {
/* 314 */                     t = Integer.parseInt(s2.replaceAll(doujutsu, "") + '\001');
/*     */                   }
/* 316 */                   double d = dmg / 15.0D;
/* 317 */                   dmg = (int)(d * 5.0D + d * ge); dmg = (dmg < 1) ? 1 : dmg;
/* 318 */                   dmg = (int)(dmg * (1.0D + t * 0.1D));
/* 319 */                   EntityEnergyAttJ entityEnergyAttJ = new EntityEnergyAttJ((EntityLivingBase)Player, type, speed, dmg, effect, color, density, sincantation, sfire, smove, (byte)tn, dmg1, cst, cost);
/*     */                 } else {
/*     */                   
/* 322 */                   Player.func_145747_a((IChatComponent)new ChatComponentText(JRMCoreH.cly + "You need to learn the " + JRMCoreH.clgd + JRMCoreH.trl("nc", JRMCoreH.NCSkillNames[2]) + JRMCoreH.cly + " Skill!"));
/*     */                 } 
/* 324 */               } else if (density == 4) {
/* 325 */                 if (ni > 0) {
/* 326 */                   Player.field_70170_p.func_72956_a((Entity)Player, "jinryuunarutoc:NC1." + JRMCoreH.techNCSndFirePM[sincantation], 0.25F, 1.0F);
/* 327 */                   double d = dmg / 50.0D;
/* 328 */                   dmg = (int)(d * 20.0D + d * (ni * 2.0D + af));
/* 329 */                   dmg = (int)(dmg * ((effe == 7) ? 1.0D : 0.5D));
/* 330 */                   dmg = (dmg < 1) ? 1 : dmg;
/* 331 */                   EntityNCjutsuBunshin entityNCjutsuBunshin = new EntityNCjutsuBunshin(Player.field_70170_p, Player, tn + "", dmg, null);
/* 332 */                   entityNCjutsuBunshin.func_70012_b(Player.field_70165_t - 0.0D, Player.field_70163_u + 1.5D, Player.field_70161_v - 0.0D, Player.field_70177_z, Player.field_70125_A);
/*     */                 } else {
/* 334 */                   Player.func_145747_a((IChatComponent)new ChatComponentText(JRMCoreH.cly + "You need to learn the " + JRMCoreH.clgd + JRMCoreH.trl("nc", JRMCoreH.NCSkillNames[1]) + JRMCoreH.cly + " Skill!"));
/*     */                 } 
/* 336 */               } else if (density == 5) {
/* 337 */                 if (cc > 0 && md > 0) {
/* 338 */                   Player.field_70170_p.func_72956_a((Entity)Player, "jinryuunarutoc:NC1." + JRMCoreH.techNCSndFirePM[sincantation], 0.25F, 1.0F);
/* 339 */                   double d = (dmg / 50.0F);
/* 340 */                   dmg = (int)(d * 20.0D + d * (md * 2.0D + cc));
/* 341 */                   dmg = (dmg < 1) ? 1 : dmg;
/*     */                   
/* 343 */                   int a = 2;
/* 344 */                   AxisAlignedBB ab = AxisAlignedBB.func_72330_a(Player.field_70165_t - a, Player.field_70163_u - a, Player.field_70161_v - a, Player.field_70165_t + a, Player.field_70163_u + a, Player.field_70161_v + a);
/* 345 */                   List<EntityPlayer> list = Player.field_70170_p.func_72872_a(EntityPlayer.class, ab);
/* 346 */                   if (list.size() == 1) {
/* 347 */                     int maxBody = JRMCoreH.stat((Entity)Player, 2, pwr, 2, PlyrAttrbts[2], rc, cls, 0.0F);
/* 348 */                     int curBody = JRMCoreH.getInt(Player, "jrmcBdy");
/* 349 */                     int all = curBody + dmg;
/* 350 */                     JRMCoreH.setInt((all > maxBody) ? maxBody : all, Player, "jrmcBdy");
/*     */                   } else {
/*     */                     
/* 353 */                     for (int i = 0; i < list.size(); i++) {
/*     */                       
/* 355 */                       EntityPlayer ent = list.get(i);
/* 356 */                       if (ent != Player) {
/* 357 */                         int[] entPlyrAttrbts = JRMCoreH.PlyrAttrbts(ent);
/* 358 */                         byte entrc = JRMCoreH.getByte(ent, "jrmcRace");
/* 359 */                         byte entpwr = JRMCoreH.getByte(ent, "jrmcPwrtyp");
/* 360 */                         byte entcls = JRMCoreH.getByte(ent, "jrmcClass");
/* 361 */                         int entmaxBody = JRMCoreH.stat((Entity)Player, 2, entpwr, 2, entPlyrAttrbts[2], entrc, entcls, 0.0F);
/* 362 */                         int entcurBody = JRMCoreH.getInt(ent, "jrmcBdy");
/* 363 */                         int all = entcurBody + dmg / (list.size() - 1);
/* 364 */                         JRMCoreH.setInt((all > entmaxBody) ? entmaxBody : all, ent, "jrmcBdy");
/*     */                       } 
/*     */                     } 
/*     */                   } 
/* 368 */                 } else if (cc == 0) {
/* 369 */                   Player.func_145747_a((IChatComponent)new ChatComponentText(JRMCoreH.cly + "You need to learn the " + JRMCoreH.clgd + JRMCoreH.trl("nc", JRMCoreH.NCSkillNames[3]) + JRMCoreH.cly + " Skill!"));
/*     */                 } else {
/* 371 */                   Player.func_145747_a((IChatComponent)new ChatComponentText(JRMCoreH.cly + "You need to learn the " + JRMCoreH.clgd + JRMCoreH.trl("nc", JRMCoreH.NCSkillNames[9]) + JRMCoreH.cly + " Skill!"));
/*     */                 } 
/* 373 */               } else if (density == 6) {
/* 374 */                 int tm = nbt.func_74762_e("nccdt") + 10;
/* 375 */                 int tc = (int)(System.currentTimeMillis() / 1000L);
/* 376 */                 if (tc > tm && ni > 0 && ma > 0 && cls == 2) {
/* 377 */                   nbt.func_74768_a("nccdt", (int)(System.currentTimeMillis() / 1000L));
/* 378 */                   String StE = nbt.func_74779_i("jrmcStatusEff");
/* 379 */                   StE = JRMCoreH.StusEfcts(16, StE, nbt, true);
/* 380 */                   Player.field_70170_p.func_72956_a((Entity)Player, "jinryuunarutoc:NC1." + JRMCoreH.techNCSndFirePM[sincantation], 0.25F, 1.0F);
/* 381 */                 } else if (cls != 2) {
/* 382 */                   Player.func_145747_a((new ChatComponentText("You need to be from Clan " + JRMCoreH.clgd + JRMCoreH.trl("jrmc", JRMCoreH.cl(pwr)[2]) + " to use this Jutsu!")).func_150255_a(JRMCoreH.CHAT_STYLE_YELLOW));
/* 383 */                 } else if (tj == 0) {
/* 384 */                   Player.func_145747_a((new ChatComponentText("You need to learn the Skill " + JRMCoreH.clgd + JRMCoreH.trl("nc", JRMCoreH.NCSkillNames[1]) + "!")).func_150255_a(JRMCoreH.CHAT_STYLE_YELLOW));
/* 385 */                 } else if (ma == 0) {
/* 386 */                   Player.func_145747_a((new ChatComponentText("You need to upgrade Main Skill " + JRMCoreH.clgd + JRMCoreH.trl("nc", JRMCoreH.NCRacialSkillAbilityNames[2]) + "!")).func_150255_a(JRMCoreH.CHAT_STYLE_YELLOW));
/* 387 */                 } else if (tm >= tc) {
/* 388 */                   Player.func_145747_a((new ChatComponentText("You need to wait " + (tm - tc + 1) + " seconds to use it again!")).func_150255_a(JRMCoreH.CHAT_STYLE_YELLOW));
/*     */                 } 
/* 390 */               } else if (density == 7) {
/* 391 */                 int tm = nbt.func_74762_e("nccdt") + 10;
/* 392 */                 int tc = (int)(System.currentTimeMillis() / 1000L);
/* 393 */                 if (tc > tm && tj > 0 && ma > 0 && cls == 1) {
/* 394 */                   nbt.func_74768_a("nccdt", (int)(System.currentTimeMillis() / 1000L));
/* 395 */                   double d = (dmg / 50.0F);
/* 396 */                   dmg = (int)(d * 20.0D + d * (ni * 2.0D + af));
/* 397 */                   hgTaiKaiEntity = new hgTaiKaiEntity(Player.field_70170_p, Player.func_70005_c_(), 56573, 0.0F, 0.0F, 100, false, 0.9F, dmg);
/*     */                 }
/* 399 */                 else if (cls != 1) {
/* 400 */                   Player.func_145747_a((new ChatComponentText("You need to be from Clan " + JRMCoreH.clgd + JRMCoreH.trl("jrmc", JRMCoreH.cl(pwr)[1]) + " to use this Jutsu!")).func_150255_a(JRMCoreH.CHAT_STYLE_YELLOW));
/* 401 */                 } else if (tj == 0) {
/* 402 */                   Player.func_145747_a((new ChatComponentText("You need to learn the Skill " + JRMCoreH.clgd + JRMCoreH.trl("nc", JRMCoreH.NCSkillNames[1]) + "!")).func_150255_a(JRMCoreH.CHAT_STYLE_YELLOW));
/* 403 */                 } else if (ma == 0) {
/* 404 */                   Player.func_145747_a((new ChatComponentText("You need to upgrade Main Skill " + JRMCoreH.clgd + JRMCoreH.trl("nc", JRMCoreH.NCRacialSkillAbilityNames[1]) + "!")).func_150255_a(JRMCoreH.CHAT_STYLE_YELLOW));
/* 405 */                 } else if (tm >= tc) {
/* 406 */                   Player.func_145747_a((new ChatComponentText("You need to wait " + (tm - tc + 1) + " seconds to use it again!")).func_150255_a(JRMCoreH.CHAT_STYLE_YELLOW));
/*     */                 } 
/*     */               } 
/*     */ 
/*     */               
/* 411 */               if (wcbu) {
/* 412 */                 byte P = JRMCoreH.getByte(Player, "jrmcPtch");
/* 413 */                 float ptch = (P == 0) ? 1.0F : (0.8F + P * 0.006F);
/* 414 */                 Player.field_70170_p.func_72956_a((Entity)Player, "jinryuunarutoc:" + snd, 1.0F, (density == 1) ? 1.0F : ptch);
/* 415 */                 Player.field_70170_p.func_72956_a((Entity)Player, "jinryuunarutoc:" + snd2, 1.0F, ptch);
/* 416 */                 if (!JRMCoreH.isInCreativeMode((Entity)Player)) JRMCoreH.setInt(curEn - cst, Player, "jrmcEnrgy");
/*     */               
/*     */               } 
/* 419 */               if (hgTaiKaiEntity != null) {
/* 420 */                 Player.field_70170_p.func_72838_d((Entity)hgTaiKaiEntity);
/*     */               
/*     */               }
/*     */             }
/* 424 */             else if (cst > curEn) {
/* 425 */               Player.func_145747_a((new ChatComponentText(" Not Enough Chakra!")).func_150255_a(JRMCoreH.CHAT_STYLE_YELLOW));
/* 426 */             } else if (!may) {
/* 427 */               Player.func_145747_a((new ChatComponentText("You need to learn the " + JRMCoreH.clgd + JRMCoreH.trl("nc", JRMCoreH.techNCEffects[effe]) + " Affinity!")).func_150255_a(JRMCoreH.CHAT_STYLE_YELLOW));
/*     */             }
/*     */           
/*     */           } 
/* 431 */         } else if (d1 == 8) {
/* 432 */           MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
/* 433 */           String gi = NCJutsus.rgi(server, Player.func_70005_c_());
/* 434 */           if (gi.contains(";")) {
/* 435 */             String[] a = gi.split(";");
/* 436 */             String m = a[0];
/* 437 */             String[] j = JRMCoreH.pmj[Integer.parseInt(a[1])];
/* 438 */             int dmg = Integer.parseInt(a[2]);
/* 439 */             int t = Integer.parseInt(a[3]);
/* 440 */             int l = Integer.parseInt(a[4]);
/* 441 */             int cst = dmg / t * l;
/* 442 */             cst = (cst < 1) ? 1 : cst;
/*     */             
/* 444 */             byte cl = JRMCoreH.getByte(Player, "jrmcClass");
/* 445 */             String doujutsu = JRMCoreH.ncCSkls[cl];
/* 446 */             String s2 = JRMCoreH.getString(Player, "jrmcSSltY");
/* 447 */             int lvl = 0;
/* 448 */             if (s2 != null && s2.length() > 2 && cl != 0 && doujutsu.equals("SG")) {
/* 449 */               lvl = Integer.parseInt(s2.replaceAll(doujutsu, "")) + 1;
/*     */             }
/*     */             
/* 452 */             cst = (int)(cst * (0.5F + 0.5F - 0.05F * lvl));
/* 453 */             if (curEn >= cst && ge > 0) {
/* 454 */               byte P = JRMCoreH.getByte(Player, "jrmcPtch");
/* 455 */               float ptch = (P == 0) ? 1.0F : (0.8F + P * 0.006F);
/* 456 */               Player.field_70170_p.func_72956_a((Entity)Player, "jinryuunarutoc:NC2." + JRMCoreH.techNCSndIncSpec[0], 1.0F, ptch);
/* 457 */               NCJutsus.wgi(server, " ", Player.func_70005_c_(), true);
/* 458 */               if (!JRMCoreH.isInCreativeMode((Entity)Player)) JRMCoreH.setInt(curEn - cst, Player, "jrmcEnrgy");
/*     */             
/* 460 */             } else if (cst > curEn) {
/* 461 */               Player.func_145747_a((IChatComponent)new ChatComponentText(JRMCoreH.cly + " Not Enough Chakra!"));
/* 462 */             } else if (ge == 0) {
/* 463 */               Player.func_145747_a((IChatComponent)new ChatComponentText(JRMCoreH.cly + "You need to learn the " + JRMCoreH.clgd + JRMCoreH.trl("nc", JRMCoreH.NCSkillNames[2]) + JRMCoreH.cly + " Skill!"));
/*     */             } 
/*     */           } 
/*     */           
/* 467 */           String StE = nbt.func_74779_i("jrmcStatusEff");
/* 468 */           StE = JRMCoreH.StusEfcts(16, StE, nbt, false);
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleNCdou(byte b, EntityPlayer p) {
/* 477 */     Side side = FMLCommonHandler.instance().getEffectiveSide();
/* 478 */     if (side == Side.SERVER) {
/*     */       
/* 480 */       byte cl = JRMCoreH.getByte(p, "jrmcClass");
/* 481 */       byte P = JRMCoreH.getByte(p, "jrmcPtch");
/* 482 */       float ptch = (P == 0) ? 1.0F : (0.8F + P * 0.006F);
/* 483 */       String doujutsu = JRMCoreH.ncCSkls[cl];
/* 484 */       NBTTagCompound nbt = nbt(p, "pres");
/* 485 */       String s2 = nbt.func_74779_i("jrmcSSltY");
/* 486 */       byte st = nbt.func_74771_c("jrmcState");
/* 487 */       int st2 = nbt.func_74771_c("jrmcState2");
/*     */       
/* 489 */       if (b == 0 && st2 > 0) {
/*     */         
/* 491 */         nbt.func_74774_a("jrmcState2", (byte)0);
/*     */       }
/* 493 */       else if (b == 2) {
/*     */         
/* 495 */         boolean psk = JRMCoreH.PlyrSettingsB(nbt, 7);
/* 496 */         int skk = JRMCoreH.SklLvl(12, p);
/* 497 */         if (psk && skk > 0 && skk > st2 && 
/* 498 */           JRMCoreH.TransGtsDmg.length - 1 > st2) {
/* 499 */           nbt.func_74774_a("jrmcState2", (byte)(st2 + 1));
/* 500 */           p.func_145747_a((IChatComponent)new ChatComponentText(JRMCoreH.clgd + JRMCoreH.trl("nc", JRMCoreH.NCSkillNames[12]) + ": " + JRMCoreH.trl("nc", JRMCoreH.TransGtsNms[st2 + 1])));
/*     */         }
/*     */       
/*     */       }
/* 504 */       else if (s2 != null && cl != 0 && !s2.equals("pty")) {
/*     */         
/* 506 */         int clanSkillLvl = Integer.parseInt(s2.replaceAll(doujutsu, ""));
/* 507 */         if (st == 0 && b == 1) {
/*     */           
/* 509 */           if (JRMCoreH.NCRacialSkillAbilityNames[cl].length() > 0) p.field_70170_p.func_72956_a((Entity)p, "jinryuunarutoc:NC2." + JRMCoreH.NCRacialSkillAbilityNames[cl].toLowerCase(), 0.5F, 1.0F);
/*     */ 
/*     */           
/* 512 */           nbt.func_74774_a("jrmcState", (byte)(clanSkillLvl + 1));
/*     */ 
/*     */         
/*     */         }
/* 516 */         else if (st > 0) {
/*     */           
/* 518 */           nbt.func_74774_a("jrmcState", (byte)0);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void send(EntityPlayerMP Player) {
/* 527 */     Player.func_145747_a((IChatComponent)new ChatComponentText("Not enough Training Points!"));
/*     */   }
/*     */ 
/*     */   
/*     */   public void handleNCchargesound(int ncchargesound, EntityPlayer Player) {
/* 532 */     Side side = FMLCommonHandler.instance().getEffectiveSide();
/* 533 */     if (side == Side.SERVER && ncchargesound == 1) {
/* 534 */       soundPowerUp(Player, "jinryuunarutoc:NC1.Chakra_Focus");
/*     */     }
/*     */   }
/*     */   
/*     */   public void handleNCjumpsound(int ncjumpsound, EntityPlayer Player) {
/* 539 */     Side side = FMLCommonHandler.instance().getEffectiveSide();
/* 540 */     if (side == Side.SERVER && ncjumpsound == 1) {
/* 541 */       soundPowerUp(Player, "jinryuunarutoc:NC1.Jump");
/*     */     }
/* 543 */     if (ncjumpsound == 2) {
/* 544 */       soundPowerUp(Player, "jinryuunarutoc:NC1.Rasengan_Ready");
/*     */     }
/* 546 */     if (ncjumpsound == 4) {
/* 547 */       soundPowerUp(Player, "jinryuunarutoc:NC1.Katon_Hous");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 552 */     if (ncjumpsound == 100) {
/* 553 */       soundPowerUp(Player, "jinryuunarutoc:NC1.Focus_Chakra");
/*     */     }
/* 555 */     if (ncjumpsound == 101) {
/* 556 */       soundPowerUp(Player, "jinryuunarutoc:NC1.Seal_a");
/*     */     }
/* 558 */     if (ncjumpsound == 102) {
/* 559 */       soundPowerUp(Player, "jinryuunarutoc:NC1.Seal_b");
/*     */     }
/* 561 */     if (ncjumpsound == 103) {
/* 562 */       soundPowerUp(Player, "jinryuunarutoc:NC1.Seal_c");
/*     */     }
/* 564 */     if (ncjumpsound == 104) {
/* 565 */       soundPowerUp(Player, "jinryuunarutoc:NC1.Jutsu_Enabled");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void soundPowerUp(EntityPlayer var4, String var2) {
/* 573 */     var4.field_70170_p.func_72956_a((Entity)var4, var2, 0.5F, 1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public NBTTagCompound nbt(EntityPlayer p, String s) {
/*     */     NBTTagCompound nbt;
/* 579 */     if (s.contains("pres"))
/* 580 */     { if (!p.getEntityData().func_74764_b("PlayerPersisted")) {
/* 581 */         nbt = new NBTTagCompound();
/* 582 */         p.getEntityData().func_74782_a("PlayerPersisted", (NBTBase)nbt);
/*     */       } else {
/* 584 */         nbt = p.getEntityData().func_74775_l("PlayerPersisted");
/*     */       }  }
/* 586 */     else { nbt = p.getEntityData(); }
/*     */     
/* 588 */     return nbt;
/*     */   }
/*     */   
/*     */   public void closeInventoryChange(EntityPlayerMP player) {
/* 592 */     player.field_71071_by.field_70459_e = false;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\p\NC\NCPacketHandlerServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */