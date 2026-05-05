/*     */ package JinRyuu.FamilyC;
/*     */ 
/*     */ import JinRyuu.JRMCore.FamilyCH;
/*     */ import JinRyuu.JRMCore.JRMCoreConfig;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*     */ import cpw.mods.fml.common.gameevent.TickEvent;
/*     */ import java.util.Random;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ 
/*     */ 
/*     */ public class FamilyCComTickH
/*     */ {
/*  18 */   private int tick = 0;
/*     */   
/*     */   private boolean ro = true;
/*     */   
/*     */   public void serverTick(MinecraftServer server) {
/*  23 */     if (this.ro && FamilyCConfig.dcr) {
/*  24 */       FamilyCH.wpfdD(server);
/*  25 */       FamilyCH.wcfdD(server);
/*  26 */       this.ro = false;
/*     */     } 
/*  28 */     int cur = server.func_71233_x();
/*  29 */     for (int pl = 0; pl < cur; pl++) {
/*     */       try {
/*  31 */         EntityPlayerMP player = JRMCoreH.getPlayerForUsername(server, server.func_71213_z()[pl]);
/*     */         
/*  33 */         if (this.tick == ((cur > 100) ? (int)(pl - 100.0F * pl / 100.0F) : (int)(100.0F / cur * pl))) {
/*     */ 
/*     */           
/*  36 */           String fmd = FamilyCH.rfmd(server, player.func_70005_c_());
/*  37 */           if (fmd.contains("1")) {
/*  38 */             JRMCoreH.setString("0", (EntityPlayer)player, FamilyCH.FID);
/*  39 */             JRMCoreH.setString("0", (EntityPlayer)player, FamilyCH.FIDo);
/*  40 */             FamilyCH.wfmd(server, "0", player.func_70005_c_(), true);
/*     */           } 
/*     */ 
/*     */           
/*  44 */           String fid = JRMCoreH.getString((EntityPlayer)player, FamilyCH.FID);
/*  45 */           String fd = FamilyCH.rfi(server, fid);
/*  46 */           String[] famD = fd.split("!");
/*  47 */           int i2 = 0;
/*     */           
/*  49 */           boolean b = false;
/*  50 */           if (famD != null && famD.length > 0) {
/*  51 */             for (int i = 0; i < famD.length; i++) {
/*  52 */               String n = famD[i];
/*  53 */               String[] fm = n.split(",");
/*  54 */               for (int f1 = 0; f1 < fm.length; f1++) {
/*  55 */                 String n2 = fm[f1];
/*  56 */                 String[] n3 = n2.split(":");
/*     */ 
/*     */                 
/*  59 */                 if (n3[0].equals(player.func_70005_c_()))
/*     */                 {
/*  61 */                   b = true;
/*     */                 }
/*  63 */                 i2++;
/*     */               } 
/*     */             } 
/*     */           }
/*  67 */           if (!b && fid.length() > 1) {
/*  68 */             JRMCoreH.setString("0", (EntityPlayer)player, FamilyCH.FID);
/*  69 */             JRMCoreH.setString("0", (EntityPlayer)player, FamilyCH.FIDo);
/*     */           } 
/*     */           
/*  72 */           String prid = JRMCoreH.getString((EntityPlayer)player, FamilyCH.prID);
/*  73 */           int l = prid.length();
/*  74 */           if (l == 0) JRMCoreH.setString("v", (EntityPlayer)player, FamilyCH.prID); 
/*  75 */           if (l > 2 && prid.contains(";")) {
/*  76 */             String[] prt = prid.toString().split(";");
/*  77 */             if (prt.length > 3) {
/*  78 */               int i = Integer.parseInt(prt[4]) - 1;
/*  79 */               if (i <= 0) {
/*  80 */                 boolean bool = true;
/*  81 */                 while (bool) {
/*  82 */                   Random ran = new Random();
/*  83 */                   int r = ran.nextInt(1000000);
/*  84 */                   if (FamilyCH.rcfd(server, r + "").length() < 2) {
/*     */                     
/*  86 */                     FamilyCH.wcfd(server, prt[1] + ":" + prt[2] + ":" + prt[3], r, false);
/*  87 */                     String pm = FamilyCH.rpfd(server, prt[1]);
/*  88 */                     String pd = FamilyCH.rpfd(server, prt[2]);
/*     */ 
/*     */                     
/*  91 */                     pm = ((pm.contains(";") || pm.length() > 2) ? (pm + ";") : "") + r + ":" + prt[2];
/*  92 */                     FamilyCH.wpfd(server, pm, prt[1], false);
/*  93 */                     pd = ((pd.contains(";") || pd.length() > 2) ? (pd + ";") : "") + r + ":" + prt[1];
/*  94 */                     FamilyCH.wpfd(server, pd, prt[2], false);
/*     */ 
/*     */                     
/*  97 */                     EntityNPC c = new EntityNPC(player.field_70170_p, prt[0], prt[1], prt[2], prt[3], r, prt[5]);
/*  98 */                     c.func_70012_b(player.field_70165_t, player.field_70163_u, player.field_70161_v, 0.0F, 0.0F);
/*  99 */                     c.setCnam((byte)1);
/* 100 */                     c.setNPCAge(0.5F);
/* 101 */                     player.field_70170_p.func_72838_d((Entity)c);
/* 102 */                     JRMCoreH.setString("b", (EntityPlayer)player, FamilyCH.prID);
/*     */                     
/* 104 */                     if (JRMCoreConfig.DebugInfo) mod_FamilyC.logger.info("ChildData: DNS:" + prt[0] + " Hair:" + prt[5]);
/*     */                     
/* 106 */                     bool = false;
/*     */                   } 
/*     */                 } 
/*     */               } else {
/*     */                 
/* 111 */                 String s = prt[0] + ";" + prt[1] + ";" + prt[2] + ";" + prt[3] + ";" + i + ";" + prt[5];
/* 112 */                 JRMCoreH.setString(s, (EntityPlayer)player, FamilyCH.prID);
/*     */               }
/*     */             
/*     */             } 
/*     */           } 
/*     */         } 
/* 118 */       } catch (Exception exception) {}
/*     */     } 
/* 120 */     if (this.tick >= 100) {
/* 121 */       this.tick = -1;
/*     */     }
/* 123 */     this.tick++;
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
/*     */   private void onTickInGame() {
/* 145 */     MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
/* 146 */     serverTick(server);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onPlayerTick(EntityPlayer player) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onTick(TickEvent.ServerTickEvent event) {
/* 166 */     if (event.phase.equals(TickEvent.Phase.START))
/*     */     {
/* 168 */       onTickInGame();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JFamilyC-v1.2.18.jar!\JinRyuu\FamilyC\FamilyCComTickH.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */