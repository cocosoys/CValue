/*     */ package JinRyuu.JRMCore;
/*     */ 
/*     */ import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
/*     */ import JinRyuu.JRMCore.entity.EntitySafeZone;
/*     */ import JinRyuu.NarutoC.common.NCH;
/*     */ import JinRyuu.NarutoC.common.Npcs.EntityNCKami;
/*     */ import JinRyuu.NarutoC.common.Npcs.f.EntityKonohaFugaku;
/*     */ import JinRyuu.NarutoC.common.Npcs.f.EntityKonohaHiashi;
/*     */ import JinRyuu.NarutoC.common.Npcs.f.EntityKonohaSarutobi;
/*     */ import JinRyuu.NarutoC.common.Villages.Konoha;
/*     */ import JinRyuu.NarutoC.common.Villages.builds;
/*     */ import JinRyuu.NarutoC.common.mod_NarutoC;
/*     */ import com.google.common.collect.Lists;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldServer;
/*     */ import net.minecraftforge.event.entity.player.PlayerInteractEvent;
/*     */ 
/*     */ public class JRMCoreHNC {
/*     */   public static final int Action_EightGates = 1;
/*     */   
/*     */   public static int getSpecJutsu(int k) {
/*  30 */     for (byte i = 0; i < 4; i = (byte)(i + 1)) {
/*  31 */       if (JRMCoreH.techsPM(i) >= 0) {
/*     */         
/*  33 */         String[] j = JRMCoreH.pmj[JRMCoreH.techsPM(i)];
/*  34 */         int den = Integer.parseInt(j[11]);
/*  35 */         switch (den) { case 7:
/*  36 */             if (k == 4) return 4 + i + 1;  break;
/*  37 */           case 6: if (k == 3) return 4 + i + 1; 
/*     */             break; }
/*     */       
/*     */       } 
/*     */     } 
/*  42 */     return -1;
/*     */   }
/*     */   public static int iconInList() {
/*  45 */     ArrayList<Integer> a = iconList();
/*  46 */     return ((Integer)a.get((JRMCoreH.EnAtSlct < a.size()) ? JRMCoreH.EnAtSlct : (a.size() - 1))).intValue();
/*     */   }
/*     */   
/*     */   public static ArrayList<Integer> iconList() {
/*  50 */     ArrayList<Integer> al = Lists.newArrayList();
/*  51 */     if (JRMCoreH.PlyrSettingsB(7)) { al.add(Integer.valueOf(5)); return al; }
/*  52 */      switch (JRMCoreH.Class) { case 1:
/*  53 */         al.add(Integer.valueOf(1)); break;
/*  54 */       case 0: al.add(Integer.valueOf(0)); break;
/*  55 */       case 2: al.add(Integer.valueOf(2));
/*     */         break; }
/*     */     
/*  58 */     for (byte i = 0; i < 4; i = (byte)(i + 1)) {
/*  59 */       if (JRMCoreH.techsPM(i) >= 0 && JRMCoreH.pmj.length > JRMCoreH.techsPM(i)) {
/*     */         
/*  61 */         String[] j = JRMCoreH.pmj[JRMCoreH.techsPM(i)];
/*  62 */         int den = Integer.parseInt(j[11]);
/*  63 */         switch (den) { case 7:
/*  64 */             al.add(Integer.valueOf(4)); break;
/*  65 */           case 6: al.add(Integer.valueOf(3));
/*     */             break; }
/*     */       
/*     */       } 
/*     */     } 
/*  70 */     return al;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void actionInit() {
/*  75 */     JRMCoreA.actionsNC.put(Integer.valueOf(0), Integer.valueOf(1));
/*     */   }
/*     */   public static String action(int d, boolean action, boolean black) {
/*     */     String nm;
/*     */     int skl;
/*     */     boolean ps;
/*  81 */     String opt1 = JGConfigClientSettings.CLIENT_GR12 ? "Enable" : "Off";
/*  82 */     String opt2 = JGConfigClientSettings.CLIENT_GR12 ? "Disable" : "On";
/*     */     
/*  84 */     String clr1 = "§4";
/*  85 */     String clr2 = "§2";
/*  86 */     if (JGConfigClientSettings.CLIENT_GR13) black = true;
/*     */ 
/*     */     
/*  89 */     int race = JRMCoreH.Race;
/*  90 */     int pwr = JRMCoreH.Pwrtyp;
/*  91 */     int state = JRMCoreH.State;
/*  92 */     int align = JRMCoreH.align;
/*  93 */     boolean lf = JRMCoreH.StusEfctsMe(14);
/*  94 */     switch (d) {
/*     */       case 1:
/*  96 */         nm = JRMCoreH.trl("nc", JRMCoreH.SklName(JRMCoreH.NCSkillIDs[12], JRMCoreH.NCSkillIDs, JRMCoreH.NCSkillNames));
/*  97 */         skl = JRMCoreH.SklLvl(12, JRMCoreH.Pwrtyp);
/*  98 */         ps = JRMCoreH.PlyrSettingsB(7);
/*  99 */         if (!lf && skl > 0) {
/* 100 */           if (action) {
/* 101 */             if (ps) { JRMCoreH.Skll((byte)6, (byte)7, (byte)1); JRMCoreH.jrmct(3); break; }
/* 102 */              JRMCoreH.Skll((byte)6, (byte)7, (byte)0); JRMCoreH.jrmct(3); break;
/*     */           } 
/* 104 */           String enable = JRMCoreH.trl("jrmc", opt1);
/* 105 */           String disable = JRMCoreH.trl("jrmc", opt2);
/* 106 */           return nm + ": " + (ps ? ((black ? "" : "§2") + disable) : ((black ? "" : "§4") + enable));
/*     */         } 
/*     */         break;
/*     */     } 
/* 110 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void openGui(int id, EntityPlayer pl) {
/* 117 */     pl.openGui(mod_NarutoC.instance, id, pl.field_70170_p, (int)pl.field_70165_t, (int)pl.field_70163_u, (int)pl.field_70161_v);
/*     */   }
/*     */   
/*     */   public static boolean NCgetEntityNC(Entity shootingEntity) {
/* 121 */     return shootingEntity instanceof JinRyuu.NarutoC.common.Npcs.EntityNC;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void NCCommonTickHandlerNPCSpawnCheck(EntityPlayerMP player) {
/* 126 */     if (JRMCoreConfig.NPCSpawnCheck) {
/*     */ 
/*     */       
/* 129 */       int[] Khvln1 = new int[3]; if (NCH.genKnvl.contains(";")) for (int j = 0; j < 3; ) { Khvln1[j] = Integer.parseInt(NCH.genKnvl.split(";")[j]) + NCH.genKnvlN1[j]; j++; }
/* 130 */           int[] Khvln2 = new int[3]; if (NCH.genKnvl.contains(";")) for (int j = 0; j < 3; ) { Khvln2[j] = Integer.parseInt(NCH.genKnvl.split(";")[j]) + NCH.genKnvlN2[j]; j++; }
/* 131 */           int[] Khvln3 = new int[3]; if (NCH.genKnvl.contains(";")) for (int j = 0; j < 3; ) { Khvln3[j] = Integer.parseInt(NCH.genKnvl.split(";")[j]) + NCH.genKnvlN3[j]; j++; }
/*     */          
/* 133 */       int[][] ps = new int[3][];
/* 134 */       ps[0] = Khvln1;
/* 135 */       ps[1] = Khvln2;
/* 136 */       ps[2] = Khvln3;
/* 137 */       EntityNCKami[] ent = { (EntityNCKami)new EntityKonohaSarutobi(player.field_70170_p), (EntityNCKami)new EntityKonohaHiashi(player.field_70170_p), (EntityNCKami)new EntityKonohaFugaku(player.field_70170_p) };
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 142 */       Class[] entclss = { EntityKonohaSarutobi.class, EntityKonohaHiashi.class, EntityKonohaFugaku.class };
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 147 */       int[] dims = { 0, 0, 0 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 155 */       boolean[] spawn = { NCH.genKnvl.contains(";"), NCH.genKnvl.contains(";"), NCH.genKnvl.contains(";") };
/*     */       
/* 157 */       for (int i = 0; i < ps.length; i++) {
/* 158 */         int[] npc = ps[i];
/* 159 */         if (dims[i] == player.field_71093_bK && 
/* 160 */           npc.length > 2) {
/* 161 */           int a = 2;
/* 162 */           AxisAlignedBB ab = AxisAlignedBB.func_72330_a((npc[0] - a), (npc[1] - a), (npc[2] - a), (npc[0] + a), (npc[1] + a), (npc[2] + a));
/* 163 */           List enma = player.field_70170_p.func_72872_a(entclss[i], ab);
/* 164 */           if (enma.isEmpty() && spawn[i]) {
/* 165 */             EntityNCKami en = ent[i];
/* 166 */             en.func_70012_b(npc[0] + 0.5D, npc[1], npc[2] + 0.5D, 0.0F, 0.0F);
/*     */             
/* 168 */             player.field_70170_p.func_72838_d((Entity)en);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/* 176 */   public static builds[] NCbuilds = new builds[] { (builds)new Konoha() };
/* 177 */   public static int[] NCbuildsdim = new int[] { 0 };
/*     */   
/*     */   public static String NCbuildsNams(int i) {
/* 180 */     if (i == 0) return "nc.com.loc.Konoha"; 
/* 181 */     return "";
/*     */   }
/*     */ 
/*     */   
/*     */   public static void spawnBuilds(MinecraftServer server) {
/* 186 */     int[] Knvl = new int[3]; if (NCH.genKnvl.contains(";")) for (int j = 0; j < 3; ) { Knvl[j] = Integer.parseInt(NCH.genKnvl.split(";")[j]); j++; }
/*     */        
/* 188 */     int[][] ps = new int[1][];
/* 189 */     ps[0] = Knvl;
/*     */ 
/*     */     
/* 192 */     for (int i = 0; i < ps.length; i++) {
/* 193 */       int[] npc = ps[i];
/* 194 */       if (!(server.func_71218_a(0)).field_72995_K && 
/* 195 */         npc.length > 2) {
/* 196 */         builds v = NCbuilds[i];
/* 197 */         WorldServer worldServer = server.func_71218_a(NCbuildsdim[i]);
/* 198 */         v.setWorld((World)worldServer);
/*     */         
/* 200 */         if (npc[0] != 0 || npc[1] != 0 || npc[2] != 0)
/*     */         {
/* 202 */           if (!JRMCoreComTickH.bs.contains(NCbuildsNams(i)))
/*     */           {
/*     */ 
/*     */ 
/*     */             
/* 207 */             v.func_76484_a((World)worldServer, ((World)worldServer).field_73012_v, npc[0], npc[1], npc[2]);
/*     */           }
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void NCCommonTickHandlerWorldGenBuildingsResetted(MinecraftServer server) {
/* 219 */     if (JRMCoreH.NCresetted) { JRMCoreH.NCresetted = false;
/* 220 */       WorldGenBuildingsSpawnCheck(server); }
/*     */   
/*     */   }
/*     */   public static boolean checked = false;
/*     */   public static void WorldGenBuildingsSpawnCheck(MinecraftServer server) {
/* 225 */     NCH.genKnvl = NCH.kvrwi(server);
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean renderHyuuga;
/*     */ 
/*     */   
/*     */   public static void JRMCoreEHonPlayerInteract(PlayerInteractEvent event) {
/* 233 */     EntityPlayer p = event.entityPlayer;
/* 234 */     int x = event.x;
/* 235 */     int y = event.y;
/* 236 */     int z = event.z;
/*     */     
/* 238 */     int length = JRMCoreEH.allSafeZones.size();
/* 239 */     for (int i = length - 1; i >= 0; i--) {
/* 240 */       EntitySafeZone sz = JRMCoreEH.allSafeZones.get(i);
/* 241 */       if (sz == null || sz.field_70128_L) {
/*     */         
/* 243 */         JRMCoreEH.allSafeZones.remove(i);
/*     */       }
/* 245 */       else if (sz.field_71093_bK == p.field_71093_bK) {
/*     */         
/* 247 */         AxisAlignedBB ab = sz.createSafeZoneHitBox();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 258 */         if (ab.field_72340_a < x && x < ab.field_72336_d && ab.field_72338_b < y && y < ab.field_72337_e && ab.field_72339_c < z && z < ab.field_72334_f) {
/* 259 */           Block block = p.field_70170_p.func_147439_a(x, y, z);
/* 260 */           boolean door = false;
/*     */           
/* 262 */           if (JRMCoreConfig.sfzna != null) {
/* 263 */             for (int j = 0; j < JRMCoreConfig.sfzna.length; j++) {
/* 264 */               if (block == Block.func_149684_b(JRMCoreConfig.sfzna[j])) {
/* 265 */                 door = true;
/*     */                 
/*     */                 break;
/*     */               } 
/*     */             } 
/*     */           }
/* 271 */           if ((block != null && !door && event.isCancelable()) || (event.action == PlayerInteractEvent.Action.LEFT_CLICK_BLOCK && block != null && door)) {
/* 272 */             event.setCanceled(true);
/*     */             return;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCoreHNC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */