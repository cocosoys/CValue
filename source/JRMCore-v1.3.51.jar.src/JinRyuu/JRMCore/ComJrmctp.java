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
/*     */ public class ComJrmctp extends CommandBase {
/*  15 */   private final String usage = "Usage: '/jrmctp amount [playerName]' OR '/jrmctp amount [playerName] [(nbtdata)]' and the amount can be negative too. Maximum TP is 1 000 000 000";
/*     */   public String func_71517_b() {
/*  17 */     return "jrmctp";
/*     */   }
/*  19 */   public int func_82362_a() { return 2; } public String func_71518_a(ICommandSender par1ICommandSender) {
/*  20 */     return "Usage: '/jrmctp amount [playerName]' OR '/jrmctp amount [playerName] [(nbtdata)]' and the amount can be negative too. Maximum TP is 1 000 000 000";
/*     */   }
/*     */   public void func_71515_b(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
/*     */     EntityPlayerMP entityplayermp;
/*  24 */     if (par2ArrayOfStr.length <= 0) {
/*  25 */       throw new WrongUsageException("Usage: '/jrmctp amount [playerName]' OR '/jrmctp amount [playerName] [(nbtdata)]' and the amount can be negative too. Maximum TP is 1 000 000 000", new Object[0]);
/*     */     }
/*     */     
/*  28 */     boolean hasTag = false;
/*  29 */     String s = par2ArrayOfStr[0];
/*  30 */     String s2 = "";
/*     */     
/*  32 */     long i = Long.parseLong(s);
/*  33 */     if (i > JRMCoreH.getMaxTP()) i = JRMCoreH.getMaxTP(); 
/*  34 */     if (i < -JRMCoreH.getMaxTP()) i = -JRMCoreH.getMaxTP(); 
/*  35 */     boolean flag1 = (i < 0L);
/*     */ 
/*     */     
/*  38 */     if (par2ArrayOfStr.length > 2 && par2ArrayOfStr[2].contains("[") && par2ArrayOfStr[2].contains("]")) {
/*  39 */       s2 = par2ArrayOfStr[2];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  45 */       entityplayermp = func_82359_c(par1ICommandSender, par2ArrayOfStr[1]);
/*     */ 
/*     */       
/*  48 */       hasTag = true;
/*     */     
/*     */     }
/*  51 */     else if (par2ArrayOfStr.length > 1) {
/*  52 */       entityplayermp = func_82359_c(par1ICommandSender, par2ArrayOfStr[1]);
/*     */     } else {
/*     */       
/*  55 */       entityplayermp = func_71521_c(par1ICommandSender);
/*     */     } 
/*     */     
/*  58 */     if (flag1 && !hasTag)
/*     */     {
/*  60 */       i *= -1L;
/*     */     }
/*     */     
/*  63 */     String entitycommansender = "Console";
/*     */     try {
/*  65 */       EntityPlayerMP commansender = func_71521_c(par1ICommandSender);
/*  66 */       entitycommansender = commansender.func_70005_c_();
/*  67 */     } catch (Exception exception) {}
/*     */     
/*  69 */     boolean n = entitycommansender.equals("Console") ? JRMCoreConfig.ComTPNAC : (entitycommansender.equals(entityplayermp.func_70005_c_()) ? JRMCoreConfig.ComTPNAS : JRMCoreConfig.ComTPNAO);
/*     */ 
/*     */     
/*  72 */     NBTTagCompound nbt = JRMCoreH.nbt((Entity)entityplayermp, "pres");
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  77 */     if (hasTag) {
/*     */       
/*  79 */       String datas = s2.replace("[", "").replace(")]", "").replace("(", "|");
/*  80 */       String[] nbtArray = datas.split("\\)");
/*     */       
/*  82 */       for (int j = 0; j < nbtArray.length; j++) {
/*     */ 
/*     */         
/*  85 */         String[] datas3 = nbtArray[j].split("\\|");
/*     */         
/*  87 */         if (nbt.func_74764_b(datas3[1])) {
/*     */           
/*  89 */           byte methods = (byte)(datas3.length / 2);
/*     */           
/*  91 */           String NBTdataS = "";
/*     */           
/*  93 */           boolean doit = true;
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  98 */           String NBTdataSat = nbt.func_74779_i(datas3[1]);
/*     */           
/* 100 */           boolean numberFound = false;
/* 101 */           for (int k = 0; k < NBTdataSat.length(); k++) {
/*     */ 
/*     */             
/* 104 */             String value = NBTdataSat.substring(k, k + 1);
/*     */ 
/*     */ 
/*     */             
/*     */             try {
/* 109 */               int d = Integer.parseInt(value);
/* 110 */               doit = true;
/*     */               
/* 112 */               NBTdataS = NBTdataS + d;
/*     */             
/*     */             }
/* 115 */             catch (Exception e) {
/*     */               
/* 117 */               if (k != NBTdataSat.length() - 1)
/*     */               {
/* 119 */                 doit = false;
/*     */               }
/*     */             } 
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 127 */           if (NBTdataS.equals("")) doit = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 133 */           if (doit) {
/*     */             
/* 135 */             double NBTdata = Double.parseDouble(NBTdataS);
/*     */             
/* 137 */             i = returnMathL(i, NBTdata, methods, datas3[0], (methods > 1) ? datas3[3] : "", (methods > 1) ? 
/* 138 */                 Double.parseDouble(datas3[2]) : 0.0D, (methods > 2) ? datas3[4] : "", (methods > 2) ? 
/* 139 */                 Double.parseDouble(datas3[5]) : 0.0D);
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/* 144 */           if (i > JRMCoreH.getMaxTP()) i = JRMCoreH.getMaxTP(); 
/* 145 */           if (i < -JRMCoreH.getMaxTP()) i = -JRMCoreH.getMaxTP();
/*     */         
/*     */         } 
/*     */       } 
/* 149 */       if (flag1)
/*     */       {
/* 151 */         i *= -1L;
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 158 */     if (nbt.func_74771_c("jrmcPwrtyp") == 3) {
/*     */       
/* 160 */       JRMCoreH.sao_expgain((int)i, (EntityPlayer)entityplayermp);
/* 161 */       if (n) notifyAdmins(par1ICommandSender, "Exp given %s success %s", new Object[] { Integer.valueOf((int)i), entityplayermp.func_70005_c_() });
/*     */       
/*     */     
/*     */     }
/* 165 */     else if (flag1) {
/*     */       
/* 167 */       int tp = nbt.func_74762_e("jrmcTpint");
/* 168 */       int added = (int)(tp - i);
/* 169 */       boolean b = false;
/* 170 */       if (added < 0) { added = 0; b = true; }
/* 171 */        nbt.func_74768_a("jrmcTpint", added);
/*     */ 
/*     */       
/* 174 */       if (n) notifyAdmins(par1ICommandSender, "TP take away %s success %s", new Object[] { Integer.valueOf((int)(b ? (i + tp - i) : i)), entityplayermp.func_70005_c_() });
/*     */     
/*     */     } else {
/*     */       
/* 178 */       int tp = nbt.func_74762_e("jrmcTpint");
/* 179 */       long result = tp + i;
/*     */       
/* 181 */       if (result > JRMCoreH.getMaxTP()) {
/* 182 */         result = JRMCoreH.getMaxTP();
/*     */       }
/* 184 */       int added = (int)result;
/* 185 */       boolean b = false;
/* 186 */       if (added > JRMCoreH.getMaxTP()) { added = JRMCoreH.getMaxTP(); b = true; }
/* 187 */        nbt.func_74768_a("jrmcTpint", added);
/*     */ 
/*     */       
/* 190 */       if (n) notifyAdmins(par1ICommandSender, "TP adding %s success for %s", new Object[] { Integer.valueOf((int)(b ? (i - tp + i - JRMCoreH.getMaxTP()) : i)), entityplayermp.func_70005_c_() });
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   private void notifyAdmins(ICommandSender par1iCommandSender, String string, Object[] objects) {
/* 196 */     func_152373_a(par1iCommandSender, (ICommand)this, string, objects);
/*     */   }
/* 198 */   public List func_71516_a(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) { return (par2ArrayOfStr.length == 2) ? func_71530_a(par2ArrayOfStr, getListOfPlayers()) : null; } protected String[] getListOfPlayers() {
/* 199 */     return MinecraftServer.func_71276_C().func_71213_z();
/*     */   } public boolean isUsernameIndex(int par1) {
/* 201 */     return (par1 == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private long returnMathL(long tp, double NBT, byte methods, String methodMain, String method1, double n1, String method2, double n2) {
/* 209 */     switch (methods) {
/*     */       case 3:
/* 211 */         NBT = methodD(method2, NBT, n2);
/*     */       case 2:
/* 213 */         NBT = methodD(method1, n1, NBT);
/*     */         break;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 220 */     if (methodMain.equals("+")) {
/*     */       
/* 222 */       tp = (long)(tp + NBT);
/*     */     }
/* 224 */     else if (methodMain.equals("-")) {
/*     */       
/* 226 */       tp = (long)(tp - NBT);
/*     */     }
/* 228 */     else if (methodMain.equals("*")) {
/*     */       
/* 230 */       tp = (long)(tp * NBT);
/*     */     }
/* 232 */     else if (methodMain.equals("/")) {
/*     */       
/* 234 */       tp = (long)(tp / NBT);
/*     */     }
/* 236 */     else if (methodMain.equals("%")) {
/*     */       
/* 238 */       tp = (long)(tp % NBT);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 255 */     return tp;
/*     */   }
/*     */ 
/*     */   
/*     */   private double methodD(String method, double n1, double n2) {
/* 260 */     if (method.equals("+")) {
/*     */       
/* 262 */       n1 += n2;
/*     */     }
/* 264 */     else if (method.equals("-")) {
/*     */       
/* 266 */       n1 -= n2;
/*     */     }
/* 268 */     else if (method.equals("*")) {
/*     */       
/* 270 */       n1 *= n2;
/*     */     }
/* 272 */     else if (method.equals("/")) {
/*     */       
/* 274 */       n1 /= n2;
/*     */     }
/* 276 */     else if (method.equals("%")) {
/*     */       
/* 278 */       n1 %= n2;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 292 */     return n1;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\ComJrmctp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */