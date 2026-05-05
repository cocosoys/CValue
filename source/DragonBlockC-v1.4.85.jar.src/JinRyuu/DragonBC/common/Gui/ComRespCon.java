/*     */ package JinRyuu.DragonBC.common.Gui;
/*     */ import JinRyuu.DragonBC.common.DBCH;
/*     */ import JinRyuu.DragonBC.common.Villages.builds;
/*     */ import JinRyuu.DragonBC.common.Worlds.WorldGeneratorDB;
/*     */ import JinRyuu.JRMCore.JRMCoreHDBC;
/*     */ import JinRyuu.JRMCore.JRMCoreSafe;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import net.minecraft.command.CommandBase;
/*     */ import net.minecraft.command.ICommand;
/*     */ import net.minecraft.command.ICommandSender;
/*     */ import net.minecraft.command.WrongUsageException;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.util.StatCollector;
/*     */ 
/*     */ public class ComRespCon extends CommandBase {
/*     */   public String func_71517_b() {
/*  17 */     return "dbcbuildings";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_82362_a() {
/*  25 */     return 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71515_b(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
/*  30 */     if (par2ArrayOfStr.length <= 0)
/*     */     {
/*  32 */       throw new WrongUsageException("/dbcbuildings (respawn)", new Object[0]);
/*     */     }
/*     */ 
/*     */     
/*  36 */     String s = par2ArrayOfStr[0];
/*  37 */     boolean respawn = s.toLowerCase().contentEquals("respawn");
/*  38 */     boolean reset = s.toLowerCase().contentEquals("reset");
/*  39 */     s = "";
/*  40 */     if (reset && par2ArrayOfStr.length > 1) {
/*     */       
/*  42 */       s = par2ArrayOfStr[1];
/*     */     } else {
/*  44 */       reset = false;
/*     */     } 
/*     */     
/*  47 */     EntityPlayerMP entityplayermp = func_71521_c(par1ICommandSender);
/*  48 */     JRMCoreSafe safe = new JRMCoreSafe(entityplayermp.field_70170_p);
/*  49 */     if (respawn || reset) {
/*     */       
/*  51 */       safe.saveSpawnList("false ", safe.OWDataDir, "edp.dbc");
/*  52 */       safe.saveSpawnList("false ", safe.OWDataDir, "swk.dbc");
/*  53 */       safe.saveSpawnList("false ", safe.dataDir, "kl.dbc");
/*     */       
/*  55 */       JRMCoreHDBC.WorldGenBuildingsSpawnCheck(FMLCommonHandler.instance().getMinecraftServerInstance());
/*     */       
/*  57 */       int[] ClAr = new int[3]; if (DBCH.genCA.contains(";")) for (int j = 0; j < 3; ) { ClAr[j] = Integer.parseInt(DBCH.genCA.split(";")[j]); j++; }
/*  58 */           int[] Gkhs = new int[3]; if (DBCH.genGH.contains(";")) for (int j = 0; j < 3; ) { Gkhs[j] = Integer.parseInt(DBCH.genGH.split(";")[j]); j++; }
/*  59 */           int[] FzSp = new int[3]; if (DBCH.genFS.contains(";")) for (int j = 0; j < 3; ) { FzSp[j] = Integer.parseInt(DBCH.genFS.split(";")[j]); j++; }
/*  60 */           int[] BS = new int[3]; if (DBCH.genBS.contains(";")) for (int j = 0; j < 3; ) { BS[j] = Integer.parseInt(DBCH.genBS.split(";")[j]); j++; }
/*  61 */           int[] GURU = new int[3]; if (DBCH.genGuru.contains(";")) for (int j = 0; j < 3; ) { GURU[j] = Integer.parseInt(DBCH.genGuru.split(";")[j]); j++; }
/*     */          
/*  63 */       int[][] ps = new int[5][];
/*  64 */       ps[0] = ClAr;
/*  65 */       ps[1] = Gkhs;
/*  66 */       ps[2] = FzSp;
/*  67 */       ps[3] = BS;
/*  68 */       ps[4] = GURU;
/*     */       
/*  70 */       for (int i = 0; i < ps.length; i++) {
/*  71 */         int[] npc = ps[i];
/*  72 */         if (WorldGeneratorDB.DBbuildsdim[i] == entityplayermp.field_71093_bK && 
/*  73 */           npc.length > 2) {
/*  74 */           builds v = WorldGeneratorDB.DBbuilds[i];
/*  75 */           v.setWorld(entityplayermp.field_70170_p);
/*  76 */           v.setRespawn(true);
/*  77 */           int buildingID = -1;
/*     */           
/*  79 */           if (!respawn && reset && s.equals("babidi") && i == 3) {
/*  80 */             buildingID = 3;
/*  81 */             int j2 = entityplayermp.field_70170_p.func_72976_f(npc[0] + builds.SizeX / 2, npc[2] + builds.SizeZ / 2);
/*  82 */             npc[1] = j2 - builds.SizeY;
/*     */           } 
/*     */ 
/*     */           
/*  86 */           if (npc[0] != 0 || npc[1] != 0 || npc[2] != 0) {
/*     */ 
/*     */             
/*  89 */             if (buildingID > -1) {
/*  90 */               WorldGeneratorDB.DBbuildsSpawn(buildingID, true);
/*  91 */               String d = npc[0] + ";" + npc[1] + ";" + npc[2];
/*  92 */               WorldGeneratorDB.DBbuildsGen(buildingID, d);
/*     */             } 
/*  94 */             v.func_76484_a(entityplayermp.field_70170_p, entityplayermp.field_70170_p.field_73012_v, npc[0], npc[1], npc[2]);
/*  95 */             notifyAdmins(par1ICommandSender, StatCollector.func_74838_a(WorldGeneratorDB.DBbuildsNams2(i)) + " has been respawned.", new Object[0]);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 105 */       JRMCoreHDBC.WorldGenBuildingsSpawnCheck(FMLCommonHandler.instance().getMinecraftServerInstance());
/* 106 */       JRMCoreHDBC.DBCCommonTickHandlerNPCSpawnCheck(entityplayermp);
/* 107 */       notifyAdmins(par1ICommandSender, "Buildings Respawn was Set. Now you must go close to a new chunk to activate it.", new Object[] { entityplayermp.func_70005_c_() });
/*     */     }
/*     */     else {
/*     */       
/* 111 */       throw new WrongUsageException("Buildings Respawn failure", new Object[0]);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void notifyAdmins(ICommandSender par1iCommandSender, String string, Object[] objects) {
/* 117 */     func_152373_a(par1iCommandSender, (ICommand)this, string, objects);
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_71518_a(ICommandSender icommandsender) {
/* 122 */     return "/dbcbuildings (respawn)";
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Gui\ComRespCon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */