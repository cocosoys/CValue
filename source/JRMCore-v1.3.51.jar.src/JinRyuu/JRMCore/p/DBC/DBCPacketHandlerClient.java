/*     */ package JinRyuu.JRMCore.p.DBC;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.DBCClientTickHandler;
/*     */ import JinRyuu.DragonBC.common.DBCKeyHandler;
/*     */ import JinRyuu.DragonBC.common.DBCKiTech;
/*     */ import JinRyuu.DragonBC.common.Gui.DBCWishGui;
/*     */ import JinRyuu.DragonBC.common.Npcs.EntityAura;
/*     */ import JinRyuu.DragonBC.common.Npcs.EntityAuraRing;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.server.config.dbc.JGConfigDBCInstantTransmission;
/*     */ import java.util.Random;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DBCPacketHandlerClient
/*     */ {
/*     */   public static int getDBCPlayerBlockMode() {
/*  24 */     boolean instantTransmissionON = (DBCClientTickHandler.instantTransmissionOn || DBCKeyHandler.thirdFn.func_151470_d());
/*  25 */     if (instantTransmissionON) {
/*  26 */       return (JRMCoreH.isPowerTypeKi() && JRMCoreH.curRelease != 0 && JRMCoreH.SklLvl(17, JRMCoreH.Pwrtyp) > 0) ? 2 : 0;
/*     */     }
/*  28 */     return 1;
/*     */   }
/*     */   
/*     */   public static void selectGroupTeleport(int id) {
/*  32 */     if (JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_ENABLED[1]) {
/*  33 */       DBCKiTech.EnAt(DBCPacketHandlerServer.INSTANT_TRANSMISSION_GROUP, (byte)id);
/*     */     }
/*     */   }
/*     */   
/*     */   public void handleDBCdri(int dri, EntityPlayer p) {
/*  38 */     JRMCoreH.DSpeed = dri;
/*  39 */     if (dri >= 99) {
/*  40 */       JRMCoreH.SagaProg = dri;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void handleDBCwish(int id, String s, EntityPlayer p) {
/*  46 */     if (id == 3) {
/*  47 */       DBCWishGui.playerlist = s.split(";");
/*     */     }
/*     */   }
/*     */   
/*     */   public void handleDBCtick(int c, EntityPlayer Player) {
/*  52 */     if (c >= 0 && c <= 3) {
/*  53 */       if (c == 0 || c == 1) {
/*  54 */         JRMCoreH.Senzu = c;
/*     */       }
/*  56 */       if (c == 2 || c == 3) {
/*  57 */         JRMCoreH.Master = c - 2;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void handleDBCspacepod1(int c, EntityPlayer p) {
/*  64 */     if (c >= 0 && c <= 3) {
/*  65 */       if (c == 0 || c == 1) {
/*  66 */         JRMCoreH.Senzu = c;
/*     */       }
/*  68 */       if (c == 2 || c == 3) {
/*  69 */         JRMCoreH.Master = c - 2;
/*     */       }
/*     */     } else {
/*     */       
/*  73 */       DBCClientTickHandler.mountHelper = c;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void handleDBCchargepart(byte dbcchargepart, String dbcCharger, EntityPlayer p) {
/*     */     EntityAura entityAura;
/*  80 */     EntityPlayer entityPlayer = p.field_70170_p.func_72924_a(dbcCharger);
/*  81 */     Random rand = new Random();
/*  82 */     Entity aura = null;
/*  83 */     float state = 0.0F;
/*  84 */     float state2 = 0.0F;
/*  85 */     int cr = 0;
/*  86 */     if (JRMCoreH.plyrs != null && JRMCoreH.plyrs.length > 0 && 
/*  87 */       JRMCoreH.dnn(2) && JRMCoreH.plyrs.length <= JRMCoreH.data2.length && 
/*  88 */       JRMCoreH.dnn(10) && JRMCoreH.plyrs.length <= JRMCoreH.dat10.length) {
/*  89 */       for (int pl = 0; pl < JRMCoreH.plyrs.length; pl++) {
/*  90 */         if (JRMCoreH.plyrs[pl].equals(dbcCharger)) {
/*     */           
/*  92 */           String[] states = JRMCoreH.data2[pl].split(";");
/*  93 */           state = Integer.parseInt(states[0]);
/*  94 */           state2 = Integer.parseInt(states[1]);
/*  95 */           cr = Integer.parseInt(JRMCoreH.dat10[pl].split(";")[0]);
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 100 */     if (dbcchargepart == 1) entityAura = new EntityAura(p.field_70170_p, dbcCharger, (state2 > 0.0F) ? 16646144 : 11075583, state, state2, cr); 
/* 101 */     if (dbcchargepart == 2) entityAura = new EntityAura(p.field_70170_p, dbcCharger, (state2 > 0.0F) ? 16646144 : 16701952, state, state2, cr); 
/* 102 */     if (dbcchargepart == 3) entityAura = new EntityAura(p.field_70170_p, dbcCharger, (state2 > 0.0F) ? 16646144 : 14526719, state, state2, cr); 
/* 103 */     if (dbcchargepart == 4) entityAura = new EntityAura(p.field_70170_p, dbcCharger, (state2 > 0.0F) ? 16646144 : 16646144, state, state2, cr); 
/* 104 */     if (dbcchargepart == 5) EntityAuraRing entityAuraRing = new EntityAuraRing(p.field_70170_p, dbcCharger, (state2 > 0.0F) ? 16646144 : 11075583, state, state2, cr); 
/* 105 */     if (dbcchargepart == 6) EntityAuraRing entityAuraRing = new EntityAuraRing(p.field_70170_p, dbcCharger, (state2 > 0.0F) ? 16646144 : 16701952, state, state2, cr); 
/* 106 */     if (dbcchargepart == 7) EntityAuraRing entityAuraRing = new EntityAuraRing(p.field_70170_p, dbcCharger, (state2 > 0.0F) ? 16646144 : 14526719, state, state2, cr); 
/* 107 */     if (dbcchargepart == 8) EntityAuraRing entityAuraRing = new EntityAuraRing(p.field_70170_p, dbcCharger, (state2 > 0.0F) ? 16646144 : 16646144, state, state2, cr); 
/* 108 */     if (dbcchargepart == 9) entityAura = new EntityAura(p.field_70170_p, dbcCharger, (state2 > 0.0F) ? 16646144 : 11075583, state, state2, cr); 
/* 109 */     if (entityAura != null && entityPlayer != null) {
/*     */       
/* 111 */       entityAura.func_70012_b(((Entity)entityPlayer).field_70165_t - 0.0D, ((Entity)entityPlayer).field_70163_u - 1.6D + rand.nextInt(5) * 0.03D, ((Entity)entityPlayer).field_70161_v - 0.0D, rand.nextFloat(), 0.0F);
/* 112 */       p.field_70170_p.func_72838_d((Entity)entityAura);
/*     */     } 
/*     */   }
/*     */   public void handleDBCascend(byte dbcascend, EntityPlayer p) {}
/*     */   public void handleDBCdescend(byte dbcdescend, EntityPlayer p) {}
/*     */   
/*     */   public void handleDBCchargesound(int c, String s, EntityPlayer p) {
/* 119 */     soundPowerUp((EntityPlayer)p.field_70170_p.func_73045_a(c), s);
/*     */   }
/*     */   public void handleDBCjumpsound(int dbcjumpsound, int dbcp, EntityPlayer p) {
/* 122 */     if (dbcjumpsound == -2) { JRMCoreH.wishes = dbcp; }
/* 123 */     else if (dbcjumpsound == -1) { JRMCoreH.revTmr = dbcp * 5; }
/*     */     
/* 125 */     if (p.field_70170_p.func_73045_a(dbcp) instanceof EntityPlayer)
/*     */     {
/* 127 */       switch (dbcjumpsound) {
/*     */         case 1:
/* 129 */           soundPowerUp((EntityPlayer)p.field_70170_p.func_73045_a(dbcp), "jinryuudragonbc:DBC.jump");
/*     */           break;
/*     */         case 2:
/* 132 */           soundPowerUp((EntityPlayer)p.field_70170_p.func_73045_a(dbcp), "jinryuudragonbc:DBC3.cbigbang");
/*     */           break;
/*     */         case 3:
/* 135 */           soundPowerUp((EntityPlayer)p.field_70170_p.func_73045_a(dbcp), "");
/*     */           break;
/*     */         case 4:
/* 138 */           soundPowerUp((EntityPlayer)p.field_70170_p.func_73045_a(dbcp), "jinryuudragonbc:DBC3.cburning");
/*     */           break;
/*     */         case 5:
/* 141 */           soundPowerUp((EntityPlayer)p.field_70170_p.func_73045_a(dbcp), "");
/*     */           break;
/*     */         case 6:
/* 144 */           soundPowerUp((EntityPlayer)p.field_70170_p.func_73045_a(dbcp), "");
/*     */           break;
/*     */         case 7:
/* 147 */           soundPowerUp((EntityPlayer)p.field_70170_p.func_73045_a(dbcp), "jinryuudragonbc:DBC3.ckidisc");
/*     */           break;
/*     */         case 8:
/* 150 */           soundPowerUp((EntityPlayer)p.field_70170_p.func_73045_a(dbcp), "jinryuudragonbc:DBC2.finalflash_charge");
/*     */           break;
/*     */         case 9:
/* 153 */           soundPowerUp((EntityPlayer)p.field_70170_p.func_73045_a(dbcp), "");
/*     */           break;
/*     */         case 10:
/* 156 */           soundPowerUp((EntityPlayer)p.field_70170_p.func_73045_a(dbcp), "jinryuudragonbc:DBC3.cgallitgun");
/*     */           break;
/*     */         case 11:
/* 159 */           soundPowerUp((EntityPlayer)p.field_70170_p.func_73045_a(dbcp), "jinryuudragonbc:DBC.hame");
/*     */           break;
/*     */         case 12:
/* 162 */           soundPowerUp((EntityPlayer)p.field_70170_p.func_73045_a(dbcp), "jinryuudragonbc:DBC.hame");
/*     */           break;
/*     */         case 13:
/* 165 */           soundPowerUp((EntityPlayer)p.field_70170_p.func_73045_a(dbcp), "jinryuudragonbc:DBC3.cspecialbeamcannon");
/*     */           break;
/*     */         case 14:
/* 168 */           soundPowerUp((EntityPlayer)p.field_70170_p.func_73045_a(dbcp), "jinryuudragonbc:DBC3.cmasenko");
/*     */           break;
/*     */         case 15:
/* 171 */           soundPowerUp((EntityPlayer)p.field_70170_p.func_73045_a(dbcp), "jinryuudragonbc:DBC2.deathball_charge");
/*     */           break;
/*     */         case 16:
/* 174 */           soundPowerUp((EntityPlayer)p.field_70170_p.func_73045_a(dbcp), "jinryuudragonbc:DBC3.cspiritbomb");
/*     */           break;
/*     */         
/*     */         case 102:
/* 178 */           soundPowerUp((EntityPlayer)p.field_70170_p.func_73045_a(dbcp), "jinryuudragonbc:DBC2.bigbang_fire");
/*     */           break;
/*     */         case 103:
/* 181 */           soundPowerUp((EntityPlayer)p.field_70170_p.func_73045_a(dbcp), "jinryuudragonbc:DBC2.blast");
/*     */           break;
/*     */         case 104:
/* 184 */           soundPowerUp((EntityPlayer)p.field_70170_p.func_73045_a(dbcp), "jinryuudragonbc:DBC3.fburning");
/*     */           break;
/*     */         case 105:
/* 187 */           soundPowerUp((EntityPlayer)p.field_70170_p.func_73045_a(dbcp), "jinryuudragonbc:DBC2.basicbeam_fire");
/*     */           break;
/*     */         case 106:
/* 190 */           soundPowerUp((EntityPlayer)p.field_70170_p.func_73045_a(dbcp), "jinryuudragonbc:DBC2.kiball_release");
/*     */           break;
/*     */         case 107:
/* 193 */           soundPowerUp((EntityPlayer)p.field_70170_p.func_73045_a(dbcp), "jinryuudragonbc:DBC2.disc_fire");
/*     */           break;
/*     */         case 108:
/* 196 */           soundPowerUp((EntityPlayer)p.field_70170_p.func_73045_a(dbcp), "jinryuudragonbc:DBC3.ffinalflash");
/*     */           break;
/*     */         case 109:
/* 199 */           soundPowerUp((EntityPlayer)p.field_70170_p.func_73045_a(dbcp), "jinryuudragonbc:DBC3.fingerleser");
/*     */           break;
/*     */         case 110:
/* 202 */           soundPowerUp((EntityPlayer)p.field_70170_p.func_73045_a(dbcp), "jinryuudragonbc:DBC3.fgallitgun");
/*     */           break;
/*     */         case 111:
/* 205 */           soundPowerUp((EntityPlayer)p.field_70170_p.func_73045_a(dbcp), "jinryuudragonbc:DBC.ha");
/*     */           break;
/*     */         case 112:
/* 208 */           soundPowerUp((EntityPlayer)p.field_70170_p.func_73045_a(dbcp), "jinryuudragonbc:DBC.ha10x");
/*     */           break;
/*     */         case 113:
/* 211 */           soundPowerUp((EntityPlayer)p.field_70170_p.func_73045_a(dbcp), "jinryuudragonbc:DBC3.fspecialbeamcannon");
/*     */           break;
/*     */         case 114:
/* 214 */           soundPowerUp((EntityPlayer)p.field_70170_p.func_73045_a(dbcp), "jinryuudragonbc:DBC3.fmasenko");
/*     */           break;
/*     */         case 115:
/* 217 */           soundPowerUp((EntityPlayer)p.field_70170_p.func_73045_a(dbcp), "jinryuudragonbc:DBC2.deathball_fire");
/*     */           break;
/*     */         case 116:
/* 220 */           soundPowerUp((EntityPlayer)p.field_70170_p.func_73045_a(dbcp), "jinryuudragonbc:DBC3.fspiritbomb");
/*     */           break;
/*     */         
/*     */         case 300:
/* 224 */           soundPowerUp((EntityPlayer)p.field_70170_p.func_73045_a(dbcp), "jinryuudragonbc:DBC3.force");
/*     */           break;
/*     */         
/*     */         case 1000:
/* 228 */           soundPowerUp((EntityPlayer)p.field_70170_p.func_73045_a(dbcp), "jinryuudragonbc:DBC2.tp");
/*     */           break;
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/* 234 */   public void handleDBCascendsound(int c, EntityPlayer p) { soundPowerUp((EntityPlayer)p.field_70170_p.func_73045_a(c), "jinryuudragonbc:DBC.ascend"); }
/* 235 */   public void handleDBCdescendsound(int c, EntityPlayer p) { soundPowerUp((EntityPlayer)p.field_70170_p.func_73045_a(c), "jinryuudragonbc:DBC.descend"); }
/* 236 */   public void handleDBCscouter1(int c, EntityPlayer p) { soundPowerUp((EntityPlayer)p.field_70170_p.func_73045_a(c), "jinryuudragonbc:scouter.scouteron"); }
/* 237 */   public void handleDBCscouter2(int c, EntityPlayer p) { soundPowerUp((EntityPlayer)p.field_70170_p.func_73045_a(c), "jinryuudragonbc:scouter.count"); }
/* 238 */   public void handleDBCscouter3(int c, EntityPlayer p) { soundPowerUp((EntityPlayer)p.field_70170_p.func_73045_a(c), "jinryuudragonbc:scouter.warn"); } public void handleDBCscouter4(int c, EntityPlayer p) {
/* 239 */     soundPowerUp((EntityPlayer)p.field_70170_p.func_73045_a(c), "jinryuudragonbc:scouter.startcount");
/*     */   }
/*     */ 
/*     */   
/*     */   public void soundPowerUp(EntityPlayer var4, String var2) {
/* 244 */     if (var4 != null)
/* 245 */       var4.func_85030_a(var2, 0.15F, 1.0F); 
/*     */   }
/*     */   
/* 248 */   public void closeInventoryChange(EntityPlayer p) { p.field_71071_by.field_70459_e = false; } public void closeInventoryChange(EntityPlayerMP player) {
/* 249 */     player.field_71071_by.field_70459_e = false;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\p\DBC\DBCPacketHandlerClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */