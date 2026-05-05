/*     */ package JinRyuu.JRMCore;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.command.CommandBase;
/*     */ import net.minecraft.command.ICommand;
/*     */ import net.minecraft.command.ICommandSender;
/*     */ import net.minecraft.command.WrongUsageException;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ 
/*     */ public class ComJrmcm
/*     */   extends CommandBase {
/*     */   public String func_71517_b() {
/*  19 */     return "jrmcm";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_82362_a() {
/*  27 */     return 2;
/*     */   }
/*     */   
/*     */   public void func_71515_b(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
/*     */     EntityPlayerMP entityplayermp;
/*  32 */     if (par2ArrayOfStr.length <= 0)
/*     */     {
/*  34 */       throw new WrongUsageException("/jrmcm (missionFileName or main) (missionID to jump to) [playerName]", new Object[0]);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  39 */     String s = par2ArrayOfStr[0];
/*     */ 
/*     */ 
/*     */     
/*  43 */     if (par2ArrayOfStr.length > 2) {
/*     */       
/*  45 */       entityplayermp = func_82359_c(par1ICommandSender, par2ArrayOfStr[2]);
/*     */     }
/*     */     else {
/*     */       
/*  49 */       entityplayermp = func_71521_c(par1ICommandSender);
/*     */     } 
/*  51 */     String entitycommansender = "Console";
/*     */     try {
/*  53 */       EntityPlayerMP commansender = func_71521_c(par1ICommandSender);
/*  54 */       entitycommansender = commansender.func_70005_c_();
/*  55 */     } catch (Exception exception) {}
/*     */ 
/*     */ 
/*     */     
/*  59 */     int a = 0;
/*     */     try {
/*  61 */       a = func_71526_a(par1ICommandSender, par2ArrayOfStr[1]);
/*  62 */     } catch (Exception exception) {
/*  63 */       a = 0;
/*     */     } 
/*  65 */     boolean matc = false;
/*     */     
/*  67 */     NBTTagCompound nbt = JRMCoreH.nbt((Entity)entityplayermp, "pres");
/*  68 */     String msd = nbt.func_74779_i("JRMCmissionSync");
/*  69 */     String msdV = nbt.func_74779_i("JRMCmissionSyncVers");
/*  70 */     String msdO = msd;
/*  71 */     String msdVO = msdV;
/*  72 */     HashMap<String, Integer> h = new HashMap<String, Integer>();
/*  73 */     if (msd.length() > 3) {
/*  74 */       for (int i = 0; i < JRMCoreM.getSydaAmount(msd); i++) {
/*  75 */         int mid = JRMCoreM.getMda_Mission(msd, i);
/*  76 */         String sid = JRMCoreM.getMda_Series(msd, i);
/*  77 */         h.put(sid, Integer.valueOf(mid));
/*     */       } 
/*     */     }
/*  80 */     int pw = nbt.func_74771_c("jrmcPwrtyp");
/*  81 */     int rc = nbt.func_74771_c("jrmcRace");
/*  82 */     int cl = nbt.func_74771_c("jrmcClass");
/*  83 */     if (s.equalsIgnoreCase("main")) {
/*  84 */       s = (pw == 1) ? "mainDBC" : ((pw == 2) ? "mainNC" : s);
/*     */     }
/*     */     
/*  87 */     for (Iterator<String> iterator = JRMCoreM.missions.keySet().iterator(); iterator.hasNext(); ) {
/*  88 */       String seriesID = iterator.next();
/*  89 */       if (s.equalsIgnoreCase(seriesID)) {
/*  90 */         matc = true;
/*  91 */         JRMCoreMsnBundle M = JRMCoreM.missions.get(seriesID);
/*  92 */         List<JRMCoreMsn> msnl = M.getMissions();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 100 */         int msnToSendID = a;
/* 101 */         boolean hasSyda = false;
/* 102 */         if (h.containsKey(seriesID)) {
/* 103 */           hasSyda = true;
/*     */         }
/* 105 */         for (int j = 0; j < msnl.size(); j++) {
/* 106 */           JRMCoreMsn msn = msnl.get(j);
/* 107 */           if (hasSyda) {
/* 108 */             if (msn.getId() == msnToSendID) {
/* 109 */               ArrayList<String> o = msn.getObjectives(pw, rc, cl);
/* 110 */               int size = o.size();
/*     */               
/* 112 */               String[] ar = { "0" };
/* 113 */               ar = new String[size];
/* 114 */               for (int i = 0; i < size; i++) {
/* 115 */                 ar[i] = "0";
/*     */               }
/*     */               
/* 118 */               msd = JRMCoreM.setSyda(msd, seriesID, msnToSendID, ar);
/*     */ 
/*     */               
/* 121 */               String[] sydaV = JRMCoreM.getMda(msdV, seriesID);
/* 122 */               String c = sydaV[3];
/* 123 */               String cv = sydaV[4];
/*     */               
/* 125 */               msdV = JRMCoreM.setSydaV(msdV, seriesID, M.getVersion(), "0", c, cv);
/*     */               
/* 127 */               if (!msd.equals(msdO))
/* 128 */                 nbt.func_74778_a("JRMCmissionSync", msd); 
/* 129 */               if (!msdV.equals(msdVO)) {
/* 130 */                 nbt.func_74778_a("JRMCmissionSyncVers", msdV);
/*     */               }
/*     */             }
/*     */           
/*     */           }
/* 135 */           else if (msn.getId() == msnToSendID) {
/* 136 */             ArrayList<String> o = msn.getObjectives(pw, rc, cl);
/* 137 */             int size = o.size();
/* 138 */             if (hasSyda) {
/* 139 */               if (JRMCoreM.getMda_Con(JRMCoreM.getMda(msd, seriesID), size - 1).equals("")) {
/* 140 */                 String[] arrayOfString1 = { "0" };
/* 141 */                 arrayOfString1 = new String[size];
/* 142 */                 for (int k = 0; k < size; k++) {
/* 143 */                   arrayOfString1[k] = "0";
/*     */                 }
/*     */                 
/* 146 */                 msd = JRMCoreM.setSyda(msd, seriesID, msnToSendID, arrayOfString1);
/*     */                 
/* 148 */                 String[] arrayOfString2 = JRMCoreM.getMda(msdV, seriesID);
/* 149 */                 String str1 = arrayOfString2[3];
/* 150 */                 String str2 = arrayOfString2[4];
/*     */                 
/* 152 */                 msdV = JRMCoreM.setSydaV(msdV, seriesID, M.getVersion(), "0", str1, str2);
/*     */                 
/* 154 */                 if (!msd.equalsIgnoreCase(msdO))
/* 155 */                   nbt.func_74778_a("JRMCmissionSync", msd); 
/* 156 */                 if (!msdV.equalsIgnoreCase(msdVO)) {
/* 157 */                   nbt.func_74778_a("JRMCmissionSyncVers", msdV);
/*     */                 }
/*     */               } 
/*     */               break;
/*     */             } 
/* 162 */             String[] ar = new String[size];
/* 163 */             for (int i = 0; i < ar.length; i++) {
/* 164 */               ar[i] = "0";
/*     */             }
/*     */             
/* 167 */             msd = JRMCoreM.setSyda(msd, seriesID, msnToSendID, ar);
/*     */             
/* 169 */             String[] sydaV = JRMCoreM.getMda(msdV, seriesID);
/* 170 */             String c = sydaV[3];
/* 171 */             String cv = sydaV[4];
/*     */             
/* 173 */             msdV = JRMCoreM.setSydaV(msdV, seriesID, M.getVersion(), "0", c, cv);
/*     */             
/* 175 */             if (!msd.equalsIgnoreCase(msdO))
/* 176 */               nbt.func_74778_a("JRMCmissionSync", msd); 
/* 177 */             if (!msdV.equalsIgnoreCase(msdVO)) {
/* 178 */               nbt.func_74778_a("JRMCmissionSyncVers", msdV);
/*     */             }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 202 */     boolean n = par1ICommandSender.equals("Console") ? JRMCoreConfig.ComANAC : (entitycommansender.equals(entityplayermp.func_70005_c_()) ? JRMCoreConfig.ComANAS : JRMCoreConfig.ComANAO);
/* 203 */     if (n) {
/* 204 */       if (matc) {
/* 205 */         notifyAdmins(par1ICommandSender, "Mission has changed for " + s + " to id " + a, new Object[] { entityplayermp.func_70005_c_() });
/*     */       } else {
/* 207 */         throw new WrongUsageException("Mission change failure", new Object[0]);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private void notifyAdmins(ICommandSender par1iCommandSender, String string, Object[] objects) {
/* 213 */     func_152373_a(par1iCommandSender, (ICommand)this, string, objects);
/*     */   }
/*     */   
/*     */   public String func_71518_a(ICommandSender icommandsender) {
/* 217 */     return "/jrmcm (missionFileName or main) (missionID to jump to) [playerName]";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List func_71516_a(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
/* 227 */     return (par2ArrayOfStr.length == 2) ? func_71530_a(par2ArrayOfStr, getListOfPlayers()) : null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String[] getListOfPlayers() {
/* 232 */     return MinecraftServer.func_71276_C().func_71213_z();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isUsernameIndex(int par1) {
/* 240 */     return (par1 == 2);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\ComJrmcm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */