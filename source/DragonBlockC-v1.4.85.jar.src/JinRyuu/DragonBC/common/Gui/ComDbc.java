/*     */ package JinRyuu.DragonBC.common.Gui;
/*     */ import JinRyuu.DragonBC.common.DBCConfig;
/*     */ import JinRyuu.DragonBC.common.DBCH;
/*     */ import JinRyuu.DragonBC.common.Worlds.WorldTeleporterDBCTelep;
/*     */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.JRMCoreHDBC;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import net.minecraft.command.CommandBase;
/*     */ import net.minecraft.command.ICommandSender;
/*     */ import net.minecraft.command.WrongUsageException;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.util.ChatStyle;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.StatCollector;
/*     */ 
/*     */ public class ComDbc extends CommandBase {
/*     */   public String func_71517_b() {
/*  27 */     return "dbc";
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_71518_a(ICommandSender icommandsender) {
/*  32 */     return "Use '/dbc locations' or '/dbc loc' to receive the locations in DBC and Use '/dbc accept' to accept offers like revive with teleport.";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_82362_a() {
/*  41 */     return 0;
/*     */   }
/*     */   
/*     */   public boolean func_71519_b(ICommandSender par1ICommandSender) {
/*  45 */     return true;
/*     */   }
/*     */   private NBTTagCompound nbt(EntityPlayer p, String s) {
/*  48 */     return JRMCoreH.nbt((Entity)p, s);
/*     */   }
/*     */   
/*     */   public void func_71515_b(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
/*  52 */     if (par2ArrayOfStr.length <= 0)
/*     */     {
/*  54 */       throw new WrongUsageException("Use '/dbc locations' or '/dbc loc' to receive the locations in DBC and Use '/dbc accept' to accept offers like revive with teleport.", new Object[0]);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  62 */     EntityPlayerMP entityplayermp = func_71521_c(par1ICommandSender);
/*  63 */     String s = par2ArrayOfStr[0];
/*  64 */     boolean loc = (s.toLowerCase().contains("locations") || s.toLowerCase().contains("loc"));
/*  65 */     boolean accept = s.toLowerCase().contains("accept");
/*     */ 
/*     */ 
/*     */     
/*  69 */     boolean heal = false;
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
/*  82 */     if (loc) {
/*     */       
/*  84 */       ChatStyle color = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW);
/*  85 */       if (entityplayermp.field_71093_bK == 0) {
/*  86 */         String[] kamh = DBCH.genKH.split(";");
/*  87 */         String[] clar = DBCH.genCA.split(";");
/*  88 */         String[] gkhs = DBCH.genGH.split(";");
/*  89 */         String[] bs = DBCH.genBS.split(";");
/*     */         
/*  91 */         entityplayermp.func_145747_a((new ChatComponentText(StatCollector.func_74838_a("dbc.com.loc.coords"))).func_150255_a(color));
/*  92 */         entityplayermp.func_145747_a((new ChatComponentText(StatCollector.func_74838_a("dbc.com.loc.kami"))).func_150255_a(color));
/*     */         
/*  94 */         if (kamh.length > 2) { entityplayermp.func_145747_a((new ChatComponentText(StatCollector.func_74838_a("dbc.com.loc.kame") + ": " + (JRMCoreH.parseInt(kamh[0]) + DBCH.genKHnpc1[0]) + " " + (JRMCoreH.parseInt(kamh[1]) + DBCH.genKHnpc1[1]) + " " + (JRMCoreH.parseInt(kamh[2]) + DBCH.genKHnpc1[2]))).func_150255_a(color)); }
/*  95 */         else { entityplayermp.func_145747_a((new ChatComponentText(StatCollector.func_74838_a("dbc.com.loc.kamenotexp"))).func_150255_a(color)); }
/*     */         
/*  97 */         if (clar.length > 2) { entityplayermp.func_145747_a((new ChatComponentText(StatCollector.func_74838_a("dbc.com.loc.cell") + ": " + (JRMCoreH.parseInt(clar[0]) + DBCH.genCAnpc1[0]) + " " + (JRMCoreH.parseInt(clar[1]) + DBCH.genCAnpc1[1]) + " " + (JRMCoreH.parseInt(clar[2]) + DBCH.genCAnpc1[2]))).func_150255_a(color)); }
/*  98 */         else { entityplayermp.func_145747_a((new ChatComponentText(StatCollector.func_74838_a("dbc.com.loc.cellnotexp"))).func_150255_a(color)); }
/*     */         
/* 100 */         if (gkhs.length > 2) { entityplayermp.func_145747_a((new ChatComponentText(StatCollector.func_74838_a("dbc.com.loc.goku") + ": " + (JRMCoreH.parseInt(gkhs[0]) + DBCH.genGHnpc1[0]) + " " + (JRMCoreH.parseInt(gkhs[1]) + DBCH.genGHnpc1[1]) + " " + (JRMCoreH.parseInt(gkhs[2]) + DBCH.genGHnpc1[2]))).func_150255_a(color)); }
/* 101 */         else { entityplayermp.func_145747_a((new ChatComponentText(StatCollector.func_74838_a("dbc.com.loc.gokunotexp"))).func_150255_a(color)); }
/* 102 */          if (bs.length > 2) { entityplayermp.func_145747_a((new ChatComponentText(StatCollector.func_74838_a("dbc.com.loc.babidi") + ": " + (JRMCoreH.parseInt(bs[0]) + DBCH.genBSnpc1[0]) + " " + (JRMCoreH.parseInt(bs[1]) + DBCH.genBSnpc1[1]) + " " + (JRMCoreH.parseInt(bs[2]) + DBCH.genBSnpc1[2]))).func_150255_a(color)); }
/* 103 */         else { entityplayermp.func_145747_a((new ChatComponentText(StatCollector.func_74838_a("dbc.com.loc.babidinotexp"))).func_150255_a(color)); }
/*     */       
/* 105 */       }  if (entityplayermp.field_71093_bK == DBCConfig.planetNamek) {
/* 106 */         String fzsp = DBCH.genFS.replace(";", " ");
/* 107 */         String guru = DBCH.genGuru.replace(";", " ");
/*     */         
/* 109 */         entityplayermp.func_145747_a((new ChatComponentText(StatCollector.func_74838_a("dbc.com.loc.coords"))).func_150255_a(color));
/* 110 */         if (fzsp.length() > 3) { entityplayermp.func_145747_a((new ChatComponentText(StatCollector.func_74838_a("dbc.com.loc.freeza") + ": " + fzsp)).func_150255_a(color)); }
/* 111 */         else { entityplayermp.func_145747_a((new ChatComponentText(StatCollector.func_74838_a("dbc.com.loc.freezanotexp"))).func_150255_a(color)); }
/*     */         
/* 113 */         entityplayermp.func_145747_a((new ChatComponentText(StatCollector.func_74838_a("dbc.com.loc.coords"))).func_150255_a(color));
/* 114 */         if (guru.length() > 3) { entityplayermp.func_145747_a((new ChatComponentText(StatCollector.func_74838_a("dbc.com.loc.guruhouse") + ": " + guru)).func_150255_a(color)); }
/* 115 */         else { entityplayermp.func_145747_a((new ChatComponentText(StatCollector.func_74838_a("dbc.com.loc.guruhousenotexp"))).func_150255_a(color)); }
/*     */       
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 122 */     if (accept) {
/*     */       
/* 124 */       MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
/*     */       
/* 126 */       EntityPlayerMP p = entityplayermp;
/* 127 */       if (p.field_71093_bK == DBCConfig.otherWorld && 
/* 128 */         p != null && p.field_70154_o == null && p.field_70153_n == null) {
/* 129 */         String[] sa = JRMCoreH.getString((EntityPlayer)p, "jrmcRevtpInit").split(";");
/* 130 */         if (sa.length > 3) {
/* 131 */           String wisherNam = sa[0];
/* 132 */           int reviveDim = Integer.parseInt(sa[1]);
/* 133 */           int x = Integer.parseInt(sa[2]);
/* 134 */           int y = Integer.parseInt(sa[3]);
/* 135 */           int z = Integer.parseInt(sa[4]);
/* 136 */           JRMCoreH.setByte(0, (EntityPlayer)p, "jrmcAlv");
/* 137 */           server.func_71203_ab().transferPlayerToDimension(p, reviveDim, (Teleporter)new WorldTeleporterDBCTelep(server.func_71218_a(reviveDim)));
/* 138 */           p.func_71023_q(1);
/*     */           
/* 140 */           double[] d = { x, y, z };
/* 141 */           p.field_71135_a.func_147364_a(d[0], d[1], d[2], 0.0F, 0.0F);
/*     */           
/* 143 */           mod_DragonBC.logger.info(p.func_70005_c_() + " revived by " + wisherNam + "!");
/*     */ 
/*     */           
/* 146 */           if (JRMCoreHDBC.DBCgetConfigDeadInv() && p.field_70170_p.func_82736_K().func_82766_b("keepInventory") && !p.field_71075_bZ.field_75098_d && 
/* 147 */             JRMCoreH.getByte((EntityPlayer)p, "jrmcAlv") == 1) {
/* 148 */             JRMCoreH.nbt((EntityPlayer)p).func_74782_a("InventoryDead", (NBTBase)p.field_71071_by.func_70442_a(new NBTTagList()));
/*     */             
/* 150 */             p.field_71071_by.func_70443_b(JRMCoreH.nbt((EntityPlayer)p).func_150295_c("InventoryLiving", 10));
/* 151 */             p.getEntityData().func_74782_a("Inventory", (NBTBase)p.field_71071_by.func_70442_a(new NBTTagList()));
/*     */           } 
/*     */ 
/*     */           
/* 155 */           EntityPlayerMP entityPlayerMP = JRMCoreH.getPlayerForUsername(server, wisherNam);
/* 156 */           if (entityPlayerMP != null) {
/* 157 */             String t = JRMCoreH.trlai("dbc", "reviveaccepted");
/* 158 */             ChatStyle styl = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW);
/* 159 */             entityPlayerMP.func_145747_a((new ChatComponentTranslation(t, new Object[] { p.func_70005_c_(), JRMCoreH.trl("dbc", (String)DBCH.plntNms.get(Integer.valueOf(reviveDim))), x + ", " + y + ", " + z })).func_150255_a(styl));
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 164 */       JRMCoreH.setString("e", (EntityPlayer)p, "jrmcRevtpInit");
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
/* 180 */     func_152373_a(par1iCommandSender, (ICommand)this, string, objects);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Gui\ComDbc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */