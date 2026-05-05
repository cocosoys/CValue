/*     */ package JinRyuu.JRMCore;
/*     */ 
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import net.minecraft.command.CommandBase;
/*     */ import net.minecraft.command.ICommand;
/*     */ import net.minecraft.command.ICommandSender;
/*     */ import net.minecraft.command.WrongUsageException;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ 
/*     */ public class ComJrmc extends CommandBase {
/*     */   public String func_71517_b() {
/*  17 */     return "jrmc";
/*     */   }
/*     */   
/*     */   public String func_71518_a(ICommandSender icommandsender) {
/*  21 */     return "Use '/jrmc startnew' to Start from the begining, resetting attributes and character look.and Use '/dbc accept' to accept offers like revive with teleport.";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_82362_a() {
/*  30 */     return 0;
/*     */   }
/*     */   
/*     */   public boolean func_71519_b(ICommandSender par1ICommandSender) {
/*  34 */     return true;
/*     */   }
/*     */   private NBTTagCompound nbt(EntityPlayer p, String s) {
/*  37 */     return JRMCoreH.nbt((Entity)p, s);
/*     */   }
/*     */   public void func_71515_b(ICommandSender commandSender, String[] stringArray) {
/*     */     EntityPlayerMP entityplayermp;
/*  41 */     if (stringArray.length <= 0)
/*     */     {
/*  43 */       throw new WrongUsageException(func_71518_a(commandSender), new Object[0]);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  48 */     if (stringArray.length > 1) {
/*     */       
/*  50 */       entityplayermp = func_82359_c(commandSender, stringArray[1]);
/*     */     }
/*     */     else {
/*     */       
/*  54 */       entityplayermp = func_71521_c(commandSender);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  59 */     int pwrtyp = JRMCoreH.getByte((EntityPlayer)entityplayermp, "jrmcPwrtyp");
/*  60 */     String s = stringArray[0];
/*  61 */     boolean startnew = s.toLowerCase().contains("startnew");
/*  62 */     boolean heal = false;
/*  63 */     boolean accept = s.toLowerCase().contains("accept");
/*  64 */     boolean decline = s.toLowerCase().contains("decline");
/*     */ 
/*     */     
/*  67 */     if (entityplayermp != null && JRMCoreConfig.osbic > 0 && ((Integer)JRMCoreH.osbic.get(entityplayermp.func_70005_c_())).intValue() < JRMCoreConfig.osbic * 20) {
/*  68 */       entityplayermp.func_145747_a((new ChatComponentTranslation("Offline Protection: " + ((int)((JRMCoreConfig.osbic * 20 - ((Integer)JRMCoreH.osbic.get(entityplayermp.func_70005_c_())).intValue()) * 0.05F) + 1) + "s left", new Object[0])).func_150255_a(JRMCoreH2.styl_ylw));
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*  73 */     if (startnew) {
/*     */       
/*  75 */       EntityPlayerMP Player = entityplayermp;
/*     */       
/*  77 */       if (JRMCoreH.DBC())
/*     */       {
/*  79 */         if (!JRMCoreH.isFused((Entity)Player)) {
/*  80 */           JRMCoreH.resetChar((EntityPlayer)Player);
/*  81 */           notifyAdmins(commandSender, "Resetting attributes and character look has been processed.", new Object[] { entityplayermp.func_70005_c_() });
/*     */         } else {
/*     */           
/*  84 */           notifyAdmins(commandSender, "Unable to reset attributes and character look while fused.", new Object[] { entityplayermp.func_70005_c_() });
/*     */         }
/*     */       
/*     */       }
/*  88 */     } else if (accept || decline) {
/*     */       
/*  90 */       MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
/*     */       
/*  92 */       EntityPlayerMP p = entityplayermp;
/*     */       
/*  94 */       String toteach1 = JRMCoreH.getString((EntityPlayer)p, "jrmcTechLearn");
/*     */       
/*  96 */       if (toteach1.contains(";:;")) {
/*  97 */         String[] toteach = toteach1.split(";:;");
/*  98 */         String[] tn = toteach[0].split(";");
/*     */         
/* 100 */         EntityPlayerMP entityPlayerMP = JRMCoreH.getPlayerForUsername(server, toteach[1]);
/* 101 */         if (entityPlayerMP != null && p.func_70032_d((Entity)entityPlayerMP) < 8.0F && accept) {
/* 102 */           if (pwrtyp == 1) {
/* 103 */             int b = 0;
/* 104 */             boolean may = false;
/* 105 */             for (int i = 0; i < 4; i++) {
/* 106 */               String s1 = JRMCoreH.getString((EntityPlayer)p, JRMCoreH.techNbt[i]);
/* 107 */               if (s1.contains(";")) {
/* 108 */                 may = false;
/*     */               } else {
/* 110 */                 b = i; may = true; break;
/*     */               } 
/*     */             } 
/* 113 */             if (may) {
/* 114 */               int costTp = JRMCoreH.techDBCtpc(tn, true) * 2;
/* 115 */               int tp = JRMCoreH.getInt((EntityPlayer)p, "jrmcTpint");
/* 116 */               if (tp - costTp >= 0) {
/* 117 */                 JRMCoreH.setInt(tp - costTp, (EntityPlayer)p, "jrmcTpint");
/* 118 */                 JRMCoreH.setString(toteach[0], (EntityPlayer)p, JRMCoreH.techNbt[b]);
/* 119 */                 entityPlayerMP.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("jrmc", "teachingOfferAccepted"), new Object[] { p.func_70005_c_(), tn[0] })).func_150255_a(JRMCoreH2.styl_ylw));
/* 120 */                 p.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("jrmc", "techadded"), new Object[] { tn[0] })).func_150255_a(JRMCoreH2.styl_ylw));
/*     */               } else {
/* 122 */                 p.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("jrmc", "notenoughtp"), new Object[0])).func_150255_a(JRMCoreH2.styl_ylw));
/*     */               } 
/*     */             } else {
/* 125 */               p.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("jrmc", "noslotleft"), new Object[0])).func_150255_a(JRMCoreH2.styl_ylw));
/*     */             }
/*     */           
/*     */           } 
/* 129 */         } else if (toteach1.contains(";:;") && decline) {
/* 130 */           JRMCoreH.setString(" ", (EntityPlayer)p, "jrmcTechLearn");
/* 131 */           p.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("jrmc", "teachingOfDeclByYou"), new Object[] { toteach[1], tn[0] })).func_150255_a(JRMCoreH2.styl_ylw));
/* 132 */           if (entityPlayerMP != null) entityPlayerMP.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("jrmc", "teachingOfDeclByPlayr"), new Object[] { p.func_70005_c_() })).func_150255_a(JRMCoreH2.styl_ylw));
/*     */         
/*     */         } else {
/* 135 */           JRMCoreH.setString(" ", (EntityPlayer)p, "jrmcTechLearn");
/* 136 */           p.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("jrmc", "teachingOfferDeclined"), new Object[] { toteach[1], tn[0] })).func_150255_a(JRMCoreH2.styl_ylw));
/*     */         } 
/*     */       } else {
/* 139 */         p.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("jrmc", "nothingtoaccept"), new Object[0])).func_150255_a(JRMCoreH2.styl_ylw));
/*     */       } 
/*     */     } else {
/* 142 */       EntityPlayerMP p = entityplayermp;
/* 143 */       p.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("jrmc", "typedWrong"), new Object[0])).func_150255_a(JRMCoreH2.styl_red));
/*     */     } 
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
/*     */   private void notifyAdmins(ICommandSender par1iCommandSender, String string, Object[] objects) {
/* 159 */     func_152373_a(par1iCommandSender, (ICommand)this, string, objects);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\ComJrmc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */