/*      */ package JinRyuu.DragonBC.common;
/*      */ 
/*      */ import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
/*      */ import JinRyuu.DragonBC.common.Gui.DBCGuiSpacePod01;
/*      */ import JinRyuu.DragonBC.common.Gui.ScouterGui;
/*      */ import JinRyuu.DragonBC.common.Npcs.EntityMasterEnma;
/*      */ import JinRyuu.DragonBC.common.Npcs.EntityMasterKaio;
/*      */ import JinRyuu.DragonBC.common.Render.SpacePod01Entity;
/*      */ import JinRyuu.JRMCore.JRMCoreCliTicH;
/*      */ import JinRyuu.JRMCore.JRMCoreClient;
/*      */ import JinRyuu.JRMCore.JRMCoreConfig;
/*      */ import JinRyuu.JRMCore.JRMCoreH;
/*      */ import JinRyuu.JRMCore.JRMCoreHC;
/*      */ import JinRyuu.JRMCore.JRMCoreHDBC;
/*      */ import JinRyuu.JRMCore.JRMCoreKeyHandler;
/*      */ import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
/*      */ import JinRyuu.JRMCore.i.ExtendedPlayer;
/*      */ import JinRyuu.JRMCore.mod_JRMCore;
/*      */ import JinRyuu.JRMCore.p.DBC.DBCPacketHandlerServer;
/*      */ import JinRyuu.JRMCore.p.DBC.DBCPdri;
/*      */ import JinRyuu.JRMCore.p.DBC.DBCPscouter1;
/*      */ import JinRyuu.JRMCore.p.DBC.DBCPscouter2;
/*      */ import JinRyuu.JRMCore.p.DBC.DBCPscouter3;
/*      */ import JinRyuu.JRMCore.p.DBC.DBCPscouter4;
/*      */ import JinRyuu.JRMCore.p.DBC.DBCPspacepod1;
/*      */ import JinRyuu.JRMCore.p.PD;
/*      */ import JinRyuu.JRMCore.server.config.dbc.JGConfigDBCGoD;
/*      */ import JinRyuu.JRMCore.server.config.dbc.JGConfigDBCInstantTransmission;
/*      */ import cpw.mods.fml.client.FMLClientHandler;
/*      */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*      */ import cpw.mods.fml.common.gameevent.TickEvent;
/*      */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*      */ import java.time.Duration;
/*      */ import java.time.Instant;
/*      */ import java.util.ArrayList;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import net.minecraft.block.Block;
/*      */ import net.minecraft.client.Minecraft;
/*      */ import net.minecraft.client.entity.EntityClientPlayerMP;
/*      */ import net.minecraft.client.gui.GuiScreen;
/*      */ import net.minecraft.client.multiplayer.WorldClient;
/*      */ import net.minecraft.client.settings.KeyBinding;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.util.AxisAlignedBB;
/*      */ import net.minecraft.util.ChatComponentText;
/*      */ import net.minecraft.util.ChatComponentTranslation;
/*      */ import net.minecraft.util.ChatStyle;
/*      */ import net.minecraft.util.EnumChatFormatting;
/*      */ import net.minecraft.util.IChatComponent;
/*      */ import net.minecraft.util.MathHelper;
/*      */ import net.minecraft.util.StatCollector;
/*      */ import net.minecraft.world.World;
/*      */ import org.lwjgl.input.Keyboard;
/*      */ 
/*      */ 
/*      */ public class DBCClientTickHandler
/*      */ {
/*      */   private int kibar;
/*   63 */   public static int countT = 0;
/*   64 */   public static int warnT = 0;
/*   65 */   public static int startcountT = 0;
/*   66 */   public static int ScFunc0 = 0;
/*   67 */   public static int ScFunc00 = 0;
/*   68 */   public static int ScFunc01 = 0;
/*   69 */   public static int ScFunc02 = 0;
/*   70 */   public static int ScFunc03 = 0;
/*   71 */   public static int ScFunc04 = 0;
/*   72 */   public static int ScFunc05 = 0;
/*   73 */   public static int ScFuncSB = 0;
/*   74 */   public static int heightplus = 0;
/*   75 */   public static int tick = 0;
/*   76 */   public static int runOutOfKi = 0;
/*   77 */   public static int c = 0;
/*      */   
/*      */   public static boolean selected = false;
/*      */   
/*   81 */   public static short csicsu = 0;
/*      */   
/*      */   public static boolean KAchrgOn = false;
/*      */   
/*   85 */   private int previousTime = 0;
/*   86 */   private int currentTime = 0;
/*   87 */   private int countingValue = 0;
/*   88 */   public static int counterValue = 0;
/*      */   
/*   90 */   ArrayList<double[]> dbs = (ArrayList)new ArrayList<double>();
/*   91 */   private static int gdb = 0;
/*      */   
/*      */   private static int ticking;
/*      */   
/*      */   private static int TiLess;
/*      */   private static int TiSen;
/*   97 */   private Minecraft mc = DBCClient.mc;
/*   98 */   public static int time = 0;
/*   99 */   public static int power = 0;
/*  100 */   public static int jump = 0;
/*  101 */   public static int ascend = 0;
/*  102 */   public static int pup = 0;
/*  103 */   public static int ptime = 0;
/*  104 */   public static int partnorm = 0;
/*  105 */   public static int inSuperTime = 0;
/*  106 */   public static int inSuperTime2 = 0;
/*  107 */   public static int inSuperTime3 = 0;
/*      */   
/*      */   public static float explevel;
/*      */   public static String textura;
/*      */   public static Item SuperHair;
/*      */   public static Item NormalHair;
/*      */   public static Block BlockHair01;
/*  114 */   private int check = 0;
/*  115 */   public int test = 0;
/*      */   private int timeincham;
/*      */   private boolean liedown;
/*      */   private int curHand;
/*      */   private static boolean inc;
/*      */   public static boolean charge = false;
/*  121 */   public static int charg = 0;
/*      */   
/*  123 */   public static int mountHelper = 0;
/*      */   public static boolean isPlayerInCreativeMode() {
/*  125 */     return JRMCoreH.isInCreativeMode((Entity)DBCClient.mc.field_71439_g);
/*      */   }
/*      */   
/*      */   public void onRenderTickInGUI(GuiScreen guiscreen) {
/*  129 */     if (this.mc.field_71439_g != null) {
/*      */       
/*  131 */       EntityClientPlayerMP entityClientPlayerMP = (Minecraft.func_71410_x()).field_71439_g;
/*  132 */       ItemStack hand = ((EntityPlayer)entityClientPlayerMP).field_71071_by.func_70448_g();
/*      */       
/*  134 */       ItemStack stackhead = (ExtendedPlayer.get((EntityPlayer)this.mc.field_71439_g)).inventory.func_70301_a(2);
/*      */       
/*  136 */       if (JRMCoreH.armTypScoutAllOn(stackhead))
/*      */       {
/*  138 */         if (DBCKeyHandler.ScFunc.func_151470_d()) {
/*      */           
/*  140 */           ScFuncSB++;
/*      */           
/*  142 */           if (ScFuncSB > 3 && ScFunc00 == 0) { this; if (ScFunc01 == 0 && ScFunc02 == 0 && ScFunc03 == 0 && ScFunc04 == 0) {
/*  143 */               ScFunc00 = 1; ScFuncSB = 0; KeyBinding.func_74506_a();
/*      */             }  }
/*  145 */            if (ScFuncSB > 3 && ScFunc00 == 1 && ScFunc01 == 0 && ScFunc02 == 0 && ScFunc03 == 0 && ScFunc04 == 0) {
/*  146 */             ScFuncSB = 0; KeyBinding.func_74506_a();
/*      */           } 
/*  148 */           if (ScFuncSB > 3 && ScFunc00 == 0) { this; if (ScFunc01 == 1 && ScFunc02 == 0 && ScFunc03 == 0 && ScFunc04 == 0)
/*  149 */             { ScFunc01 = 0; ScFunc02 = 1; ScFuncSB = 0; KeyBinding.func_74510_a(DBCKeyHandler.ScFunc.func_151463_i(), false); }  }
/*  150 */            if (ScFuncSB > 3 && ScFunc00 == 0 && ScFunc01 == 0 && ScFunc02 == 1 && ScFunc03 == 0 && ScFunc04 == 0) {
/*  151 */             ScFunc02 = 0; ScFunc03 = 1; ScFuncSB = 0; KeyBinding.func_74510_a(DBCKeyHandler.ScFunc.func_151463_i(), false);
/*  152 */           }  if (ScFuncSB > 3 && ScFunc00 == 0 && ScFunc01 == 0 && ScFunc02 == 0 && ScFunc03 == 1 && ScFunc04 == 0) {
/*  153 */             ScFunc03 = 0; ScFunc04 = 1; ScFuncSB = 0; KeyBinding.func_74510_a(DBCKeyHandler.ScFunc.func_151463_i(), false);
/*  154 */           }  if (ScFuncSB > 3 && ScFunc00 == 0 && ScFunc01 == 0 && ScFunc02 == 0 && ScFunc03 == 0 && ScFunc04 == 1) {
/*  155 */             ScFunc04 = 0; ScFuncSB = 0; ScFunc00 = 0; KeyBinding.func_74510_a(DBCKeyHandler.ScFunc.func_151463_i(), false);
/*      */           } 
/*      */         } 
/*      */       }
/*  159 */       DBCClient.scouterGui.renderScouter();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean onHotbar(Item item, EntityPlayer player) {
/*  165 */     for (int i = 0; i < 9; i++) {
/*      */       
/*  167 */       if (player.field_71071_by.func_70301_a(i) != null && player.field_71071_by.func_70301_a(i).func_77973_b() == item)
/*      */       {
/*  169 */         return true;
/*      */       }
/*      */     } 
/*  172 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void onRenderTick() {
/*  177 */     this.currentTime = (int)(System.currentTimeMillis() / 1000L);
/*  178 */     if (this.currentTime != this.previousTime) {
/*  179 */       this.previousTime = this.currentTime;
/*  180 */       counterValue = this.countingValue;
/*  181 */       this.countingValue = 0;
/*      */     } 
/*  183 */     if (this.currentTime == this.previousTime) {
/*  184 */       this.countingValue++;
/*      */     }
/*      */ 
/*      */     
/*  188 */     if (!this.mc.func_147113_T()) {
/*      */       
/*  190 */       for (int i = 0; i < JRMCoreH.techniqueCooldowns.length; i++) {
/*      */         
/*  192 */         if (JRMCoreH.techniqueCooldowns[i] >= 0.0F)
/*      */         {
/*  194 */           JRMCoreH.techniqueCooldowns[i] = JRMCoreH.techniqueCooldowns[i] - 10.0F / counterValue;
/*      */         }
/*      */         
/*  197 */         if (JRMCoreH.techniqueCooldowns[i] <= 0.0F)
/*      */         {
/*  199 */           JRMCoreH.techniqueCooldowns[i] = 0.0F;
/*      */         }
/*      */       } 
/*      */       
/*  203 */       JRMCoreH.updateAllOldCooldownValues();
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  208 */     if (this.mc.field_71415_G) if (Minecraft.func_71382_s()) {
/*      */         
/*  210 */         EntityClientPlayerMP entityClientPlayerMP = (Minecraft.func_71410_x()).field_71439_g;
/*      */         
/*  212 */         ItemStack hand = this.mc.field_71439_g.field_71071_by.func_70448_g();
/*      */         
/*  214 */         ItemStack stackhead = (ExtendedPlayer.get((EntityPlayer)this.mc.field_71439_g)).inventory.func_70301_a(2);
/*      */         
/*  216 */         if (stackhead != null && JRMCoreH.armTypScoutAllOn(stackhead)) {
/*      */           
/*  218 */           if (DBCKeyHandler.ScFunc.func_151470_d())
/*      */           {
/*  220 */             ScFuncSB++;
/*      */             
/*  222 */             if (ScFuncSB > 3 && ScFunc00 == 0) { this; if (ScFunc01 == 0 && ScFunc02 == 0 && ScFunc03 == 0 && ScFunc04 == 0 && ScFunc05 == 0) {
/*  223 */                 ScFunc00 = 1; ScFuncSB = 0; KeyBinding.func_74506_a();
/*      */               }  }
/*  225 */              if (ScFuncSB > 3 && ScFunc00 == 1 && ScFunc01 == 0 && ScFunc02 == 0 && ScFunc03 == 0 && ScFunc04 == 0 && ScFunc05 == 0) {
/*  226 */               ScFuncSB = 0; KeyBinding.func_74506_a();
/*      */             } 
/*  228 */             if (ScFuncSB > 3 && ScFunc00 == 0) { this; if (ScFunc01 == 1 && ScFunc02 == 0 && ScFunc03 == 0 && ScFunc04 == 0 && ScFunc05 == 0)
/*  229 */               { ScFunc01 = 0; ScFunc02 = 1; ScFuncSB = 0; KeyBinding.func_74510_a(DBCKeyHandler.ScFunc.func_151463_i(), false); }  }
/*  230 */              if (ScFuncSB > 3 && ScFunc00 == 0 && ScFunc01 == 0 && ScFunc02 == 1 && ScFunc03 == 0 && ScFunc04 == 0 && ScFunc05 == 0) {
/*  231 */               ScFunc02 = 0; ScFunc03 = 1; ScFuncSB = 0; KeyBinding.func_74510_a(DBCKeyHandler.ScFunc.func_151463_i(), false);
/*  232 */             }  if (ScFuncSB > 3 && ScFunc00 == 0 && ScFunc01 == 0 && ScFunc02 == 0 && ScFunc03 == 1 && ScFunc04 == 0 && ScFunc05 == 0) {
/*  233 */               ScFunc03 = 0; ScFunc04 = 1; ScFuncSB = 0; KeyBinding.func_74510_a(DBCKeyHandler.ScFunc.func_151463_i(), false);
/*  234 */             }  if (ScFuncSB > 3 && ScFunc00 == 0 && ScFunc01 == 0 && ScFunc02 == 0 && ScFunc03 == 0 && ScFunc04 == 1 && ScFunc05 == 0) {
/*  235 */               ScFunc04 = 0; ScFunc05 = 1; ScFuncSB = 0; KeyBinding.func_74510_a(DBCKeyHandler.ScFunc.func_151463_i(), false);
/*  236 */             }  if (ScFuncSB > 3 && ScFunc00 == 0 && ScFunc01 == 0 && ScFunc02 == 0 && ScFunc03 == 0 && ScFunc04 == 0 && ScFunc05 == 1) {
/*  237 */               ScFunc05 = 0; ScFuncSB = 0; ScFunc00 = 0; KeyBinding.func_74510_a(DBCKeyHandler.ScFunc.func_151463_i(), false);
/*      */             }
/*      */           
/*      */           }
/*      */         
/*  242 */         } else if (DBCKeyHandler.ScFunc.func_151468_f() && JRMCoreH.SklLvl(6) > 0) {
/*      */           
/*  244 */           DBCEH.kisnsMd++;
/*  245 */           if (DBCEH.kisnsMd > 4) DBCEH.kisnsMd = 0; 
/*  246 */           String t = JRMCoreH.trlai("dbc", "kisensemode" + DBCEH.kisnsMd);
/*  247 */           ChatStyle color = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW);
/*  248 */           JRMCoreClient.mc.field_71439_g.func_145747_a((new ChatComponentTranslation(t, new Object[0])).func_150255_a(color));
/*      */         } 
/*      */ 
/*      */         
/*  252 */         if (this.mc.field_71474_y.field_74320_O == 0) DBCClient.scouterGui.renderScouter();
/*      */       
/*      */       }  
/*      */   }
/*      */   
/*      */   public void upd(EntityPlayer p) {
/*  258 */     gdb++;
/*  259 */     if (gdb > 40) {
/*  260 */       gdb = 0;
/*  261 */       this.dbs.clear();
/*  262 */       Block blockID = null;
/*  263 */       if (p.field_70170_p.field_73011_w.field_76574_g == 20) {
/*  264 */         blockID = BlocksDBC.BlockNamekDragonBall;
/*      */       }
/*  266 */       if (p.field_70170_p.field_73011_w.field_76574_g == 0) {
/*  267 */         blockID = BlocksDBC.BlockDragonBall;
/*      */       }
/*  269 */       int m = 80;
/*  270 */       int l1 = MathHelper.func_76128_c(p.field_70165_t);
/*  271 */       int i11 = MathHelper.func_76128_c(p.field_70161_v);
/*  272 */       for (int j11 = l1 - m; j11 <= l1 + m; j11++) {
/*  273 */         for (int j2 = i11 - m; j2 <= i11 + m; j2++) {
/*  274 */           for (int k2 = 109; k2 >= 64; k2--) {
/*  275 */             if (p.field_70170_p.func_147439_a(j11, k2, j2) == blockID) {
/*  276 */               double[] d = { j11, j2 };
/*  277 */               this.dbs.add(d);
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void DragonRadar(EntityPlayer p) {
/*  287 */     upd(p);
/*  288 */     int pitch = (int)p.field_70125_A + 60;
/*  289 */     for (int i = 0; i < this.dbs.size(); i++) {
/*  290 */       DBCClient.SagaSys.DragonDetect(((double[])this.dbs.get(i))[0] - p.field_70165_t, ((double[])this.dbs.get(i))[1] - p.field_70161_v, ((pitch > 0) ? pitch : false));
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void onTickInGUI() {
/*  296 */     GuiScreen guiscreen = this.mc.field_71462_r;
/*      */ 
/*      */     
/*  299 */     if (DBCGuiSpacePod01.ToEarth == 1 || DBCGuiSpacePod01.ToVegeta == 1 || DBCGuiSpacePod01.ToNamek == 1) {
/*      */       
/*  301 */       int dbcspacepod1 = (DBCGuiSpacePod01.ToEarth == 1) ? 3 : ((DBCGuiSpacePod01.ToVegeta == 1) ? 2 : ((DBCGuiSpacePod01.ToNamek == 1) ? 1 : 0));
/*  302 */       PD.sendToServer((IMessage)new DBCPspacepod1(dbcspacepod1));
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static void dri(int a) {
/*  308 */     PD.sendToServer((IMessage)new DBCPdri(a));
/*      */   }
/*      */ 
/*      */   
/*      */   public void changeCurEnAtSlct(int par1) {
/*  313 */     int lmt = JRMCoreH.mrAtts ? 8 : 4;
/*  314 */     if (par1 > 0) par1 = 1; 
/*  315 */     if (par1 < 0) par1 = -1; 
/*  316 */     for (JRMCoreH.EnAtSlct = (byte)(JRMCoreH.EnAtSlct - par1); JRMCoreH.EnAtSlct < 0; JRMCoreH.EnAtSlct = (byte)(JRMCoreH.EnAtSlct + lmt));
/*  317 */     while (JRMCoreH.EnAtSlct >= lmt) {
/*  318 */       JRMCoreH.EnAtSlct = (byte)(JRMCoreH.EnAtSlct - lmt);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void onTickInGameEnd() {}
/*      */   
/*      */   public void onTickInGame() {
/*  326 */     EntityClientPlayerMP entityClientPlayerMP = (Minecraft.func_71410_x()).field_71439_g;
/*  327 */     WorldClient worldClient = (FMLClientHandler.instance().getClient()).field_71441_e;
/*      */     
/*  329 */     if (this.mc.field_71441_e != null && this.mc.field_71439_g != null && !this.mc.field_71439_g.field_70128_L) {
/*      */       
/*  331 */       if (this.mc.func_71387_A());
/*      */       
/*  333 */       if (mountHelper != 0) {
/*      */         
/*  335 */         entityClientPlayerMP.func_70078_a(((EntityPlayer)entityClientPlayerMP).field_70170_p.func_73045_a(mountHelper));
/*  336 */         if (entityClientPlayerMP.func_70115_ae())
/*      */         {
/*  338 */           mountHelper = 0;
/*      */         }
/*      */       } 
/*      */       
/*  342 */       boolean inAabb = false;
/*      */       
/*  344 */       if (((EntityPlayer)entityClientPlayerMP).field_71093_bK == DBCConfig.dimTimeChamber) {
/*      */         
/*  346 */         this.timeincham++;
/*  347 */         if (this.timeincham >= 24000) {
/*      */           
/*  349 */           DBCKiAttacks.dbctick(-6);
/*  350 */           this.timeincham = 0;
/*  351 */           entityClientPlayerMP.func_145747_a((IChatComponent)new ChatComponentText(StatCollector.func_74838_a("dbc.HTC.toolong")));
/*      */         } 
/*  353 */         inAabb = true;
/*      */       } 
/*      */ 
/*      */       
/*  357 */       if (((EntityPlayer)entityClientPlayerMP).field_71093_bK == DBCConfig.dimNullRealm)
/*      */       {
/*  359 */         if (this.mc.field_71439_g.field_70163_u <= DBCConfig.NullRealmMinimumHeight)
/*      */         {
/*  361 */           JRMCoreHDBC.requestNullRealmKnockout();
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*  367 */       if (!inAabb)
/*      */       {
/*  369 */         this.timeincham = 0;
/*      */       }
/*      */ 
/*      */       
/*  373 */       if (((EntityPlayer)entityClientPlayerMP).field_71093_bK == DBCConfig.otherWorld) {
/*      */         
/*  375 */         AxisAlignedBB par2AxisAlignedBB = AxisAlignedBB.func_72330_a(60.0D, 10.0D, 35.0D, 90.0D, 110.0D, 65.0D);
/*  376 */         List<Entity> enma = worldClient.func_72872_a(EntityMasterEnma.class, par2AxisAlignedBB);
/*      */         
/*  378 */         if (enma.size() > 1)
/*      */         {
/*  380 */           for (int i = 1; enma.size() > i; i++) {
/*  381 */             Entity m = enma.get(i);
/*  382 */             JRMCoreH.KAsounds(m, 999);
/*      */           } 
/*      */         }
/*      */         
/*  386 */         AxisAlignedBB aabbkaio = AxisAlignedBB.func_72330_a(87.0D, 1.0D, -3739.0D, 127.0D, 140.0D, -3699.0D);
/*  387 */         List<Entity> kaio = worldClient.func_72872_a(EntityMasterKaio.class, aabbkaio);
/*      */         
/*  389 */         if (kaio.size() > 1)
/*      */         {
/*  391 */           for (int i = 1; kaio.size() > i; i++) {
/*  392 */             Entity m = kaio.get(i);
/*  393 */             JRMCoreH.KAsounds(m, 999);
/*      */           } 
/*      */         }
/*      */       } 
/*      */       
/*  398 */       if (((EntityPlayer)entityClientPlayerMP).field_71093_bK == 0) {
/*      */         
/*  400 */         AxisAlignedBB kn = AxisAlignedBB.func_72330_a(76.0D, 64.0D, 41.0D, 79.0D, 129.0D, 44.0D);
/*  401 */         List<EntityPlayer> l3 = ((EntityPlayer)entityClientPlayerMP).field_70170_p.func_72872_a(EntityPlayer.class, kn);
/*  402 */         for (int i = 0; i < l3.size(); i++) {
/*      */           
/*  404 */           EntityPlayer e2 = l3.get(i);
/*  405 */           if (e2.func_70005_c_() == entityClientPlayerMP.func_70005_c_()) {
/*      */             
/*  407 */             float f5 = 0.15F;
/*      */             
/*  409 */             if (((EntityPlayer)entityClientPlayerMP).field_70159_w < -f5) {
/*  410 */               ((EntityPlayer)entityClientPlayerMP).field_70159_w = -f5;
/*      */             }
/*      */             
/*  413 */             if (((EntityPlayer)entityClientPlayerMP).field_70159_w > f5) {
/*  414 */               ((EntityPlayer)entityClientPlayerMP).field_70159_w = f5;
/*      */             }
/*      */             
/*  417 */             if (((EntityPlayer)entityClientPlayerMP).field_70179_y < -f5) {
/*  418 */               ((EntityPlayer)entityClientPlayerMP).field_70179_y = -f5;
/*      */             }
/*      */             
/*  421 */             if (((EntityPlayer)entityClientPlayerMP).field_70179_y > f5) {
/*  422 */               ((EntityPlayer)entityClientPlayerMP).field_70179_y = f5;
/*      */             }
/*      */             
/*  425 */             ((EntityPlayer)entityClientPlayerMP).field_70143_R = 0.0F;
/*      */             
/*  427 */             if (((EntityPlayer)entityClientPlayerMP).field_70181_x < -0.15D) {
/*  428 */               ((EntityPlayer)entityClientPlayerMP).field_70181_x = -0.15D;
/*      */             }
/*      */             
/*  431 */             boolean flag = (entityClientPlayerMP.func_70093_af() && entityClientPlayerMP instanceof EntityPlayer);
/*      */ 
/*      */             
/*  434 */             if (flag && ((EntityPlayer)entityClientPlayerMP).field_70181_x < 0.0D) {
/*  435 */               ((EntityPlayer)entityClientPlayerMP).field_70181_x = 0.0D;
/*      */             }
/*      */             
/*  438 */             if (((EntityPlayer)entityClientPlayerMP).field_70123_F) {
/*  439 */               ((EntityPlayer)entityClientPlayerMP).field_70181_x = 0.2D;
/*      */             }
/*      */           } 
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  449 */       ItemStack hand = this.mc.field_71439_g.field_71071_by.func_70448_g();
/*      */       
/*  451 */       if (hand != null || !DBCClient.mc.field_71474_y.field_74313_G.func_151470_d() || JRMCoreH.KASelected != 16 || JRMCoreKeyHandler.KiCharge.func_151470_d() || JRMCoreH.kiAmount > 0);
/*      */ 
/*      */       
/*  454 */       if (DBCGuiSpacePod01.ToEarth == 1 || DBCGuiSpacePod01.ToVegeta == 1 || DBCGuiSpacePod01.ToNamek == 1) {
/*      */         
/*  456 */         int dbcspacepod1 = (DBCGuiSpacePod01.ToEarth == 1) ? 3 : ((DBCGuiSpacePod01.ToVegeta == 1) ? 2 : ((DBCGuiSpacePod01.ToNamek == 1) ? 1 : 0));
/*  457 */         PD.sendToServer((IMessage)new DBCPspacepod1(dbcspacepod1));
/*      */       } 
/*      */ 
/*      */       
/*  461 */       if (ScFunc00 == 1) {
/*      */         
/*  463 */         ScFunc0++;
/*  464 */         if (ScFunc0 == 2) {
/*      */           
/*  466 */           ScFunc01 = 0; ScFunc00 = 1; ScFunc02 = 0; ScFunc03 = 0; ScFunc04 = 0; ScFunc05 = 0;
/*  467 */           int dbcscouter1 = entityClientPlayerMP.func_145782_y();
/*  468 */           PD.sendToServer((IMessage)new DBCPscouter1(dbcscouter1));
/*      */         } 
/*  470 */         if (ScFunc0 == 30) { ScFunc01 = 1; ScFunc00 = 0; ScFunc0 = 0; }
/*      */       
/*      */       } 
/*  473 */       if (ScouterGui.count == 1) {
/*      */         
/*  475 */         countT++;
/*  476 */         if (countT == 5) {
/*      */           
/*  478 */           int dbcscouter2 = entityClientPlayerMP.func_145782_y();
/*  479 */           PD.sendToServer((IMessage)new DBCPscouter2(dbcscouter2));
/*      */           
/*  481 */           countT = 0;
/*      */         } 
/*      */       } 
/*      */       
/*  485 */       if (ScouterGui.warn == 1) {
/*      */         
/*  487 */         warnT++;
/*  488 */         if (warnT == 10) {
/*      */           
/*  490 */           int dbcscouter3 = entityClientPlayerMP.func_145782_y();
/*  491 */           PD.sendToServer((IMessage)new DBCPscouter3(dbcscouter3));
/*  492 */           warnT = 10;
/*      */         } 
/*      */       } 
/*      */       
/*  496 */       if (ScouterGui.warn != 1)
/*      */       {
/*  498 */         warnT = 0;
/*      */       }
/*      */       
/*  501 */       if (ScouterGui.startcount == 1) {
/*      */         
/*  503 */         startcountT++;
/*  504 */         if (warnT == 10) {
/*  505 */           int dbcscouter4 = entityClientPlayerMP.func_145782_y();
/*  506 */           PD.sendToServer((IMessage)new DBCPscouter4(dbcscouter4));
/*  507 */           startcountT = 10;
/*      */         } 
/*      */       } 
/*  510 */       if (ScouterGui.startcount != 1)
/*      */       {
/*  512 */         startcountT = 0;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*  517 */       if (DBCClient.mc.field_71439_g.field_70154_o != null && DBCClient.mc.field_71439_g.field_70154_o
/*  518 */         .getClass() == SpacePod01Entity.class && DBCClient.mc.field_71474_y.field_74322_I
/*  519 */         .func_151470_d())
/*      */       {
/*  521 */         DBCClient.mc.field_71439_g.openGui(mod_DragonBC.instance, 0, (World)DBCClient.mc.field_71441_e, (int)DBCClient.mc.field_71439_g.field_70165_t, (int)DBCClient.mc.field_71439_g.field_70163_u, (int)DBCClient.mc.field_71439_g.field_70161_v);
/*      */       }
/*      */ 
/*      */       
/*  525 */       if (DBCClient.mc.field_71439_g.field_70154_o != null) {
/*      */         
/*  527 */         if (DBCClient.mc.field_71474_y.field_74351_w.func_151470_d()) { JRMCoreH.forw = 1.0D; dri(1); }
/*  528 */         else if (DBCClient.mc.field_71474_y.field_74368_y.func_151470_d()) { JRMCoreH.forw = 2.0D; dri(2); }
/*  529 */          if (DBCClient.mc.field_71474_y.field_74370_x.func_151470_d()) { JRMCoreH.forw = 1.0D; dri(5); }
/*  530 */         else if (DBCClient.mc.field_71474_y.field_74366_z.func_151470_d()) { JRMCoreH.forw = 2.0D; dri(6); }
/*  531 */          if (DBCClient.mc.field_71474_y.field_74314_A.func_151470_d() && DBCClient.mc.field_71439_g.field_70154_o != null) { JRMCoreH.forw = 3.0D; dri(3); }
/*  532 */         else if (JRMCoreKeyHandler.Fn.func_151470_d() && DBCClient.mc.field_71439_g.field_70154_o != null) { JRMCoreH.forw = 4.0D; dri(4); }
/*  533 */         else { JRMCoreH.forw = 0.0D; }
/*      */       
/*      */       } 
/*  536 */       if (JRMCoreH.PlyrPwr((EntityPlayer)entityClientPlayerMP) == 1) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  562 */         if (JRMCoreH.curRelease != 0 && !JRMCoreH.StusEfctsMe(11) && !JRMCoreH.kob) {
/*      */ 
/*      */           
/*  565 */           boolean key = DBCClient.mc.field_71474_y.field_74322_I.func_151470_d();
/*  566 */           if (hand == null && key && !DBCClient.mc.field_71474_y.field_74313_G.func_151470_d() && !JRMCoreH.isChrgng) {
/*      */             
/*  568 */             byte b = 0;
/*  569 */             if (JRMCoreKeyHandler.Fn.func_151470_d()) b = 1; 
/*  570 */             DBCKiTech.EnAtSlct(b);
/*      */             
/*  572 */             KeyBinding.func_74510_a(DBCClient.mc.field_71474_y.field_74322_I.func_151463_i(), false);
/*  573 */             nuller();
/*      */           }
/*  575 */           else if (JRMCoreKeyHandler.Fn.func_151470_d() && !DBCClient.mc.field_71474_y.field_74313_G.func_151470_d() && !JRMCoreH.isChrgng) {
/*      */             
/*  577 */             int k = JRMCoreCliTicH.mw;
/*  578 */             if (k != 0) {
/*  579 */               changeCurEnAtSlct(k);
/*  580 */               ((EntityPlayer)entityClientPlayerMP).field_71071_by.field_70461_c = this.curHand;
/*  581 */               if (DBCClient.mc.field_71474_y.field_74331_S) {
/*  582 */                 if (k > 0) k = 1;  if (k < 0) k = -1; 
/*  583 */                 DBCClient.mc.field_71474_y.field_74328_V += k * 0.25F;
/*      */               } 
/*      */             } 
/*  586 */             for (int i = 0; i < 8; i++) {
/*      */               
/*  588 */               if (Keyboard.getEventKey() == 2 + i) {
/*      */                 
/*  590 */                 JRMCoreH.EnAtSlct = (byte)(JRMCoreH.mrAtts ? i : ((i < 4) ? i : (i - 4)));
/*  591 */                 ((EntityPlayer)entityClientPlayerMP).field_71071_by.field_70461_c = this.curHand;
/*      */               } 
/*      */             } 
/*  594 */             ((EntityPlayer)entityClientPlayerMP).field_71071_by.field_70461_c = this.curHand;
/*  595 */             nuller();
/*      */           } 
/*  597 */           this.curHand = ((EntityPlayer)entityClientPlayerMP).field_71071_by.field_70461_c;
/*      */ 
/*      */ 
/*      */           
/*  601 */           float p = (DBCClient.mc.field_71439_g.field_70125_A < 0.0F) ? ((int)DBCClient.mc.field_71439_g.field_70125_A * -1) : (int)DBCClient.mc.field_71439_g.field_70125_A;
/*  602 */           float y = (DBCClient.mc.field_71439_g.field_70177_z < 0.0F) ? ((int)DBCClient.mc.field_71439_g.field_70177_z * -1) : (int)DBCClient.mc.field_71439_g.field_70177_z;
/*  603 */           boolean rotat = ((p > DBCH.RotPic && p > DBCH.RotPic + 0.1F) || (p < DBCH.RotPic && p < DBCH.RotPic - 0.1F) || (y > DBCH.RotYaw && y > DBCH.RotYaw + 0.1F) || (y < DBCH.RotYaw && y < DBCH.RotYaw - 0.1F));
/*      */           
/*  605 */           byte selectionID = JRMCoreH.EnAtSlct;
/*  606 */           float currentCooldown = JRMCoreH.techCD(selectionID);
/*  607 */           String[] tech = JRMCoreH.tech(selectionID);
/*      */ 
/*      */           
/*  610 */           if (hand == null && DBCClient.mc.field_71474_y.field_74313_G.func_151470_d() && JRMCoreKeyHandler.Fn.func_151470_d() && JRMCoreH.curEnergy > 0 && 
/*  611 */             !JRMCoreKeyHandler.KiCharge.func_151470_d() && tech != null && 
/*  612 */             DBCKiTech.KAkiEn(selectionID, JRMCoreH.curRelease, JRMCoreH.chrgPrc) && JRMCoreConfig.dat5695[JRMCoreH.techDBCty(tech)]) {
/*      */             
/*  614 */             byte[] sts = JRMCoreH.tech_statmods(tech[19]);
/*  615 */             int type = JRMCoreH.techDBCty(tech);
/*      */             
/*  617 */             if (!JRMCoreH.isShtng && currentCooldown == 0.0F) {
/*      */               
/*  619 */               JRMCoreH.isChrgng = (JRMCoreH.techDBCctWc(tech, sts) > 10.0F);
/*  620 */               int f = (int)(50.0F / JRMCoreH.techDBCctWc(tech, sts) * JRMCoreH.charged);
/*      */ 
/*      */               
/*  623 */               int WILo = JRMCoreH.PlyrAttrbts[3], WIL = WILo;
/*  624 */               boolean c = JRMCoreH.isFused();
/*  625 */               WIL = JRMCoreH.getPlayerAttribute((EntityPlayer)DBCClient.mc.field_71439_g, JRMCoreH.PlyrAttrbts, 3, JRMCoreH.State, JRMCoreH.State2, JRMCoreH.Race, JRMCoreH.PlyrSkillX, JRMCoreH.curRelease, JRMCoreH.getArcRsrv(), JRMCoreH.StusEfctsMe(14), JRMCoreH.StusEfctsMe(12), JRMCoreH.StusEfctsMe(5), JRMCoreH.StusEfctsMe(13), JRMCoreH.StusEfctsMe(19), JRMCoreH.StusEfctsMe(20), 1, JRMCoreH.PlyrSkills, c, JRMCoreH.getMajinAbsorption());
/*  626 */               int WIL2 = JRMCoreH.getPlayerAttribute((EntityPlayer)DBCClient.mc.field_71439_g, JRMCoreH.PlyrAttrbts, 3, 0, 0, JRMCoreH.Race, JRMCoreH.PlyrSkillX, JRMCoreH.curRelease, JRMCoreH.getArcRsrv(), JRMCoreH.StusEfctsMe(14), JRMCoreH.StusEfctsMe(12), false, false, false, false, 1, JRMCoreH.PlyrSkills, c, JRMCoreH.getMajinAbsorption());
/*  627 */               int stat = JRMCoreH.stat((Entity)DBCClient.mc.field_71439_g, 3, JRMCoreH.Pwrtyp, 4, WIL, JRMCoreH.Race, JRMCoreH.Class, 0.0F);
/*  628 */               int stat2 = JRMCoreH.stat((Entity)DBCClient.mc.field_71439_g, 3, JRMCoreH.Pwrtyp, 4, WIL2, JRMCoreH.Race, JRMCoreH.Class, 0.0F);
/*  629 */               float costKi = (JRMCoreH.techDBCkic(tech, stat2, sts) * JRMCoreH.chrgPrc) * 0.02F * JRMCoreH.curRelease * 0.01F;
/*      */ 
/*      */ 
/*      */               
/*  633 */               costKi = (float)(costKi * JRMCoreConfig.dat5696[type][2]);
/*      */               
/*  635 */               if (tech[0].equals("KAFakeMoon")) {
/*  636 */                 costKi = Integer.parseInt(tech[7]);
/*      */               }
/*      */               
/*  639 */               if (JRMCoreH.curEnergy > costKi)
/*  640 */                 if (f > 50 && csicsu == csicsu / 5 * 5) { csicsu = (short)(csicsu + 1); JRMCoreH.charged = (short)(JRMCoreH.charged + 1); }
/*  641 */                 else if (f > 50) { csicsu = (short)(csicsu + 1); }
/*  642 */                 else if (f <= 50) { JRMCoreH.charged = (short)(JRMCoreH.charged + 1); }
/*      */                  
/*  644 */               if (JRMCoreH.charged > 0 && JRMCoreH.curRelease > 0) {
/*  645 */                 JRMCoreH.cast = 50.0F / JRMCoreH.techDBCctWc(tech, sts) * JRMCoreH.charged;
/*  646 */                 JRMCoreH.chrgPrc = (byte)(int)((JRMCoreH.cast > 100.0F) ? 100.0F : JRMCoreH.cast);
/*      */               } 
/*      */             } 
/*      */ 
/*      */ 
/*      */             
/*  652 */             ExtendedPlayer props = ExtendedPlayer.get((EntityPlayer)entityClientPlayerMP);
/*  653 */             if (props.getAnimKiShoot() != type + 1) {
/*      */ 
/*      */               
/*  656 */               byte perc = 100;
/*  657 */               DBCKiTech.triForce(3, type + 1, selectionID);
/*  658 */               props.setAnimKiShoot(type + 1);
/*  659 */               props.setAnimKiShootOn(1);
/*      */ 
/*      */               
/*  662 */               int color = Integer.parseInt(JRMCoreH.tech(selectionID)[10]);
/*  663 */               int align = JRMCoreH.getByte((EntityPlayer)entityClientPlayerMP, "jrmcAlign");
/*  664 */               boolean setGoDOn = false;
/*  665 */               for (int pl = 0; pl < JRMCoreH.plyrs.length; pl++) {
/*      */                 
/*  667 */                 if (JRMCoreH.plyrs[pl] != null && JRMCoreH.plyrs[pl].equals(JRMCoreClient.mc.field_71439_g.func_70005_c_())) {
/*      */                   
/*  669 */                   String s = JRMCoreH.data5[pl].split(";")[0];
/*  670 */                   align = Byte.parseByte(s);
/*  671 */                   setGoDOn = JRMCoreH.StusEfctsClient(20, pl);
/*      */                   
/*      */                   break;
/*      */                 } 
/*      */               } 
/*  676 */               if (color == 0) {
/*      */                 
/*  678 */                 if (align > 66) color = 2; 
/*  679 */                 if (align <= 66 && align >= 33) color = 3; 
/*  680 */                 if (align < 33) color = 4;
/*      */               
/*      */               } 
/*  683 */               boolean isCustomAttack = (selectionID < 4);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*  693 */               props.setGoDOn((setGoDOn && isCustomAttack && JGConfigDBCGoD.CONFIG_GOD_ENERGY_ENABLED && JGConfigDBCGoD.CONFIG_GOD_ENABLED) ? 1 : 0);
/*  694 */               props.setKiShotCol(color);
/*  695 */               float density = Float.parseFloat(JRMCoreH.tech(selectionID)[11]);
/*      */               
/*  697 */               int dam1 = JRMCoreH.getEnegyDamageC(JRMCoreH.tech(selectionID), sts);
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*  702 */               float size = JRMCoreH.calculateEnergyScale(dam1, JRMCoreH.getMaxEnergyDamage(), perc, sts, (byte)(int)density, 0.01F, 0.1F);
/*  703 */               props.setKiShotSiz(size);
/*      */               
/*  705 */               int part = 0;
/*  706 */               String data = JRMCoreH.tech(selectionID)[0];
/*  707 */               if (data.toLowerCase().contains("spiritbomb") || data.toLowerCase().contains("spirit bomb")) { part = 1; }
/*  708 */               else if (data.toLowerCase().contains("kahame") || data.toLowerCase().contains("kamehame") || data.toLowerCase().contains("kame hame")) { part = 2; }
/*  709 */               else if (data.toLowerCase().contains("galic")) { part = 4; }
/*  710 */               else if (Integer.parseInt(JRMCoreH.tech(selectionID)[3]) == 8 && Integer.parseInt(JRMCoreH.tech(selectionID)[6]) == 1) { part = 3; }
/*  711 */                props.setKiShotPart(part);
/*      */             } 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*  717 */             if (JRMCoreH.charged >= JRMCoreH.techDBCctWc(tech, sts) / 2.0F && type == 6 && JRMCoreH.chrgPrc != 0) {
/*      */               
/*  719 */               if (JRMCoreH.cDEnAt(selectionID, JRMCoreH.techDBCcd(tech, sts)) && JRMCoreH.curEnergy > 0) { JRMCoreH.isShtng = true; DBCKiTech.EnAt(selectionID, JRMCoreH.chrgPrc); nuller(); }
/*  720 */                JRMCoreH.isShtng = false;
/*  721 */               if (tech.length > 12 && JRMCoreH.charged == 1 && !inc) { inc = true; JRMCoreH.quad(1, (selectionID > 3) ? 10 : Integer.parseInt(tech[3]), 0, Integer.parseInt(tech[12]) - ((selectionID > 3) ? 1 : 0)); }
/*      */             
/*  723 */             }  if (tech.length > 12 && JRMCoreH.charged == 3 && !inc) { inc = true; JRMCoreH.quad(1, (selectionID > 3) ? 10 : Integer.parseInt(tech[3]), 0, Integer.parseInt(tech[12]) - ((selectionID > 3) ? 1 : 0)); }
/*      */           
/*  725 */           } else if (tech != null) {
/*      */             
/*  727 */             byte[] sts = JRMCoreH.tech_statmods(tech[19]);
/*      */ 
/*      */             
/*  730 */             if (DBCKiTech.KAkiEn(selectionID, JRMCoreH.curRelease, JRMCoreH.chrgPrc)) {
/*      */               
/*  732 */               int type = JRMCoreH.techDBCty(tech);
/*  733 */               boolean isMoving = (DBCClient.mc.field_71439_g.field_70159_w < 0.05D && DBCClient.mc.field_71439_g.field_70179_y < 0.05D && DBCClient.mc.field_71439_g.field_70159_w > -0.05D && DBCClient.mc.field_71439_g.field_70179_y > -0.05D && DBCClient.mc.field_71439_g.field_70181_x < 0.05D);
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*  738 */               boolean doContinues = (type >= JRMCoreConfig.ContinuesKiAttacks.length) ? false : JRMCoreConfig.ContinuesKiAttacks[type];
/*      */ 
/*      */ 
/*      */               
/*  742 */               if (doContinues && JRMCoreH.charged > JRMCoreH.techDBCctWc(tech, sts) / 2.0F) {
/*      */                 
/*  744 */                 if (isMoving) {
/*      */                   
/*  746 */                   if (JRMCoreH.charged > JRMCoreH.techDBCctWc(tech, sts) / 2.0F && JRMCoreH.chrgPrc != 0 && !JRMCoreH.isShtng) {
/*      */                     
/*  748 */                     DBCClient.mc.field_71439_g.field_70181_x *= 0.0D;
/*      */                     
/*  750 */                     if (JRMCoreH.cDEnAt(selectionID, JRMCoreH.techDBCcd(tech, sts)) && JRMCoreH.curEnergy > 0) {
/*      */                       
/*  752 */                       DBCKiTech.EnAt(DBCPacketHandlerServer.WAVE_FIRING);
/*  753 */                       JRMCoreH.isShtng = true;
/*  754 */                       DBCKiTech.EnAt(selectionID, JRMCoreH.chrgPrc);
/*  755 */                       nuller();
/*      */                     } 
/*      */                   } 
/*      */                 } else {
/*  759 */                   nuller(); DBCKiTech.EnAt(DBCPacketHandlerServer.WAVE_STOP);
/*      */                 } 
/*  761 */               } else if (JRMCoreH.charged > JRMCoreH.techDBCctWc(tech, sts) / 2.0F && type != 6 && JRMCoreH.chrgPrc != 0) {
/*      */                 
/*  763 */                 if (JRMCoreH.cDEnAt(selectionID, JRMCoreH.techDBCcd(tech, sts)) && JRMCoreH.curEnergy > 0) {
/*      */                   
/*  765 */                   JRMCoreH.isShtng = true;
/*  766 */                   DBCKiTech.EnAt(selectionID, JRMCoreH.chrgPrc);
/*  767 */                   nuller();
/*      */                 } 
/*  769 */                 JRMCoreH.isShtng = false;
/*      */               }
/*  771 */               else if (JRMCoreH.curRelease != 0) {
/*  772 */                 nuller();
/*      */               } 
/*  774 */               if (!isMoving) JRMCoreH.isShtng = false;
/*      */             
/*      */             } 
/*      */           } else {
/*      */             
/*  779 */             nuller();
/*  780 */             JRMCoreH.isShtng = false;
/*      */           } 
/*      */           
/*  783 */           if (!JRMCoreH.isShtng && !JRMCoreH.isChrgng) {
/*      */             
/*  785 */             ExtendedPlayer props = ExtendedPlayer.get((EntityPlayer)entityClientPlayerMP);
/*  786 */             if (props.getAnimKiShoot() != 0) {
/*  787 */               DBCKiTech.triForce(3, 0, 0);
/*  788 */               props.setAnimKiShoot(0);
/*  789 */               props.setAnimKiShootOn(0);
/*      */             } 
/*      */           } 
/*  792 */           DBCH.RotPic = p;
/*  793 */           DBCH.RotYaw = y;
/*      */ 
/*      */           
/*  796 */           JRMCoreHC.Blocking();
/*  797 */           DBCKiTech.ChargeKi();
/*  798 */           DBCKiTech.JumpKi(DBCClient.mc.field_71474_y.field_74314_A);
/*  799 */           DBCKiTech.FloatKi(JRMCoreKeyHandler.KiFlight, DBCClient.mc.field_71474_y.field_74314_A, DBCClient.mc.field_71474_y.field_74311_E);
/*  800 */           DBCKiTech.TurboMode(JRMCoreKeyHandler.KiDash);
/*  801 */           DBCKiTech.DashKi((entityClientPlayerMP.func_70051_ag() || DBCKiTech.turbo));
/*      */           
/*  803 */           DBCKiTech.Ascend(JRMCoreKeyHandler.KiAscend);
/*  804 */           DBCKiTech.Descend(JRMCoreKeyHandler.KiDescend);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         }
/*      */         else {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  826 */           if (JGConfigClientSettings.dbcFastFusionSpectatorCameraFollowOn && JRMCoreH.curRelease != 0 && JRMCoreH.StusEfctsMe(11) && !JRMCoreH.kob && JRMCoreH.isFused() && JRMCoreH.plyrs != null && JRMCoreH.plyrs.length > 0 && JRMCoreH.dnn(18))
/*      */           {
/*  828 */             for (int pl = 0; pl < JRMCoreH.plyrs.length; pl++) {
/*      */               
/*  830 */               if (JRMCoreH.plyrs[pl].equals(entityClientPlayerMP.func_70005_c_())) {
/*      */                 
/*  832 */                 String[] fullFusionData = JRMCoreH.dat18[pl].split(";");
/*  833 */                 if (fullFusionData.length >= 3) {
/*      */                   
/*  835 */                   String[] fusionData = fullFusionData[2].split(",");
/*      */                   
/*  837 */                   if (fusionData.length == 3) {
/*      */                     
/*  839 */                     EntityPlayer player = ((EntityPlayer)entityClientPlayerMP).field_70170_p.func_72924_a(fusionData[0]);
/*  840 */                     if (player != null) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                       
/*  846 */                       ((EntityPlayer)entityClientPlayerMP).field_70159_w -= (((EntityPlayer)entityClientPlayerMP).field_70165_t - player.field_70165_t) / 3.0D;
/*  847 */                       ((EntityPlayer)entityClientPlayerMP).field_70181_x -= (((EntityPlayer)entityClientPlayerMP).field_70163_u - player.field_70163_u) / 3.0D;
/*  848 */                       ((EntityPlayer)entityClientPlayerMP).field_70179_y -= (((EntityPlayer)entityClientPlayerMP).field_70161_v - player.field_70161_v) / 3.0D;
/*      */                     } 
/*      */                   } 
/*      */                 } 
/*      */ 
/*      */                 
/*      */                 break;
/*      */               } 
/*      */             } 
/*      */           }
/*      */ 
/*      */           
/*  860 */           if (JRMCoreH.isPowerTypeKi() && DBCKiTech.floating && JRMCoreH.curRelease == 0)
/*      */           {
/*  862 */             DBCKiTech.floating = false;
/*      */           }
/*      */           
/*  865 */           if (!JRMCoreH.kob) {
/*      */             
/*  867 */             if (!JRMCoreH.StusEfctsMe(11)) {
/*      */               
/*  869 */               DBCKiTech.Descend(JRMCoreKeyHandler.KiDescend);
/*  870 */               DBCKiTech.DashKi(false);
/*      */             } 
/*  872 */             DBCKiTech.ChargeKi();
/*      */           } 
/*      */           
/*  875 */           if (JRMCoreKeyHandler.KiFlight.func_151470_d() || JRMCoreKeyHandler.KiDash.func_151470_d() || JRMCoreKeyHandler.KiAscend.func_151470_d()) {
/*      */             
/*  877 */             String t1 = JRMCoreH.StusEfctsMe(11) ? JRMCoreH.trl("dbc", "fusedspectator") : JRMCoreH.trl("dbc.clienttick.increltouseki");
/*  878 */             String t2 = JRMCoreKeyHandler.KiCharge.func_151464_g();
/*  879 */             String tf = String.format(t1, new Object[] { t2 });
/*  880 */             this.mc.field_71439_g.func_145747_a((IChatComponent)new ChatComponentText(tf));
/*  881 */             KeyBinding.func_74510_a(JRMCoreKeyHandler.KiFlight.func_151463_i(), false);
/*  882 */             KeyBinding.func_74510_a(JRMCoreKeyHandler.KiDash.func_151463_i(), false);
/*  883 */             KeyBinding.func_74510_a(JRMCoreKeyHandler.KiAscend.func_151463_i(), false);
/*      */           } 
/*      */         } 
/*      */ 
/*      */         
/*  888 */         if (JRMCoreH.isPowerTypeKi()) {
/*      */           
/*  890 */           JRMCoreHC.BPC_ME = JRMCoreH.gkap(JRMCoreH.bpc((EntityPlayer)JRMCoreClient.mc.field_71439_g, JRMCoreClient.mc.field_71439_g.func_70005_c_(), JRMCoreH.Pwrtyp), "BPC_ME");
/*      */           
/*  892 */           if (JRMCoreHC.t1s)
/*      */           {
/*  894 */             JRMCoreHC.BPC_ME2 = JRMCoreH.bpc((EntityPlayer)JRMCoreClient.mc.field_71439_g, JRMCoreClient.mc.field_71439_g.func_70005_c_(), JRMCoreH.Pwrtyp, 100);
/*      */           }
/*      */ 
/*      */           
/*  898 */           if (!JRMCoreH.damInd.isEmpty() && JRMCoreH.SklLvl(6) > 0) {
/*      */             
/*  900 */             ArrayList<String> remove = new ArrayList<String>();
/*  901 */             if (!JRMCoreH.damInd.isEmpty())
/*      */             {
/*  903 */               for (Map.Entry<String, String> mapEntry : (Iterable<Map.Entry<String, String>>)JRMCoreH.damInd.entrySet()) {
/*      */                 
/*  905 */                 String[] k = ((String)mapEntry.getKey()).split(":");
/*  906 */                 String[] v = ((String)mapEntry.getValue()).split(":");
/*  907 */                 double x = Double.parseDouble(k[0]);
/*  908 */                 double y = Double.parseDouble(k[1]);
/*  909 */                 double z = Double.parseDouble(k[2]);
/*  910 */                 double amount = Double.parseDouble(v[0]);
/*  911 */                 float timeleft = Float.parseFloat(v[1]) - 1.0F;
/*      */                 
/*  913 */                 remove.add(mapEntry.getKey());
/*      */ 
/*      */                 
/*  916 */                 double X = x;
/*  917 */                 double Y = y;
/*  918 */                 double Z = z;
/*      */                 
/*  920 */                 mod_JRMCore.proxy.generateDamIndParticles(x, y, z, amount, timeleft);
/*      */               } 
/*      */             }
/*  923 */             for (int i = 0; i < remove.size(); i++)
/*      */             {
/*  925 */               JRMCoreH.damInd.remove(remove.get(i));
/*      */             }
/*  927 */             remove.clear();
/*      */           } 
/*      */         } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  935 */         boolean itEnabledShort = JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_ENABLED[0];
/*  936 */         boolean itEnabledLong = JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_ENABLED[1];
/*  937 */         boolean itEnabled = (itEnabledShort || itEnabledLong);
/*      */         
/*  939 */         if (itEnabled) {
/*  940 */           boolean isUsed = this.mc.field_71474_y.field_74313_G.func_151470_d();
/*      */           
/*  942 */           if (JRMCoreH.isPowerTypeKi() && JRMCoreH.curRelease != 0)
/*  943 */           { int itLevel = JRMCoreH.SklLvl(17, JRMCoreH.Pwrtyp);
/*  944 */             if (itLevel > 0 && DBCKeyHandler.thirdFn.func_151470_d()) {
/*  945 */               boolean disabled = false;
/*  946 */               if (JRMCoreH.StusEfctsMe(11) && !JRMCoreH.kob && JRMCoreH.isFused() && JRMCoreH.plyrs != null && JRMCoreH.plyrs.length > 0 && JRMCoreH.dnn(18)) {
/*  947 */                 for (int pl = 0; pl < JRMCoreH.plyrs.length; pl++) {
/*      */                   
/*  949 */                   if (JRMCoreH.plyrs[pl].equals(entityClientPlayerMP.func_70005_c_())) {
/*      */                     
/*  951 */                     String[] fullFusionData = JRMCoreH.dat18[pl].split(";");
/*  952 */                     if (fullFusionData.length >= 3) {
/*      */                       
/*  954 */                       String[] fusionData = fullFusionData[2].split(",");
/*  955 */                       if (fusionData.length == 3) {
/*      */                         
/*  957 */                         EntityPlayer player = ((EntityPlayer)entityClientPlayerMP).field_70170_p.func_72924_a(fusionData[0]);
/*  958 */                         if (player != null)
/*      */                         {
/*  960 */                           disabled = true;
/*      */                         }
/*      */                       } 
/*      */                     } 
/*      */                     
/*      */                     break;
/*      */                   } 
/*      */                 } 
/*      */               }
/*  969 */               boolean cancelUse = (this.mc.field_71474_y.field_74312_F.func_151470_d() || this.mc.field_71439_g.field_71071_by.func_70448_g() != null || disabled);
/*  970 */               if (cancelUse) {
/*  971 */                 resetIT(isUsed);
/*      */                 
/*  973 */                 KeyBinding.func_74510_a(DBCKeyHandler.thirdFn.func_151463_i(), false);
/*      */               } else {
/*      */                 
/*  976 */                 instantTransmissionOn = true;
/*      */                 
/*  978 */                 if (isUsed)
/*  979 */                 { if (itEnabledShort) {
/*  980 */                     if (!instantTransmissionRequestSent) {
/*      */                       
/*  982 */                       DBCKiTech.EnAt(DBCPacketHandlerServer.INSTANT_TRANSMISSION, (byte)0);
/*  983 */                       instantTransmissionRequestSent = true;
/*  984 */                       instantTransmissionPress = null;
/*  985 */                       instantTransmissionPress = Instant.now();
/*      */                     } else {
/*      */                       
/*  988 */                       instantTransmissionPress = null;
/*  989 */                       instantTransmissionOn = false;
/*      */                     } 
/*      */                   } else {
/*      */                     
/*  993 */                     String message = "Instant Transmission Failed! Short teleportation is Disabled! ";
/*  994 */                     DBCClient.mc.field_71439_g.func_145747_a((new ChatComponentText(message)).func_150255_a(DBCPacketHandlerServer.styleRed));
/*      */                   }
/*      */                    }
/*      */                 
/*  998 */                 else if (instantTransmissionPress == null && !instantTransmissionRequestSent) { instantTransmissionPress = Instant.now(); }
/*  999 */                 else if (!instantTransmissionRequestSent)
/* 1000 */                 { long timer = Duration.between(instantTransmissionPress, Instant.now()).getSeconds();
/*      */                   
/* 1002 */                   if (timer >= 4L) {
/* 1003 */                     if (itEnabledLong) {
/*      */                       
/* 1005 */                       EntityClientPlayerMP entityClientPlayerMP1 = DBCClient.mc.field_71439_g;
/* 1006 */                       entityClientPlayerMP1.openGui(mod_JRMCore.instance, 10100, ((EntityPlayer)entityClientPlayerMP1).field_70170_p, (int)((EntityPlayer)entityClientPlayerMP1).field_70165_t, (int)((EntityPlayer)entityClientPlayerMP1).field_70163_u, (int)((EntityPlayer)entityClientPlayerMP1).field_70161_v);
/*      */                       
/* 1008 */                       instantTransmissionRequestSent = true;
/* 1009 */                       instantTransmissionPress = null;
/*      */                     } else {
/*      */                       
/* 1012 */                       String message = "Instant Transmission Failed! Long teleportation is Disabled! ";
/* 1013 */                       DBCClient.mc.field_71439_g.func_145747_a((new ChatComponentText(message)).func_150255_a(DBCPacketHandlerServer.styleRed));
/*      */                     } 
/*      */                   } }
/*      */                 else
/*      */                 
/* 1018 */                 { instantTransmissionPress = null;
/* 1019 */                   instantTransmissionOn = false; }
/*      */               
/*      */               } 
/*      */             } else {
/*      */               
/* 1024 */               resetIT(isUsed);
/*      */             }  }
/* 1026 */           else { resetIT(isUsed); }
/*      */         
/* 1028 */         } else if (JRMCoreH.isPowerTypeKi() && JRMCoreH.curRelease != 0) {
/* 1029 */           int itLevel = JRMCoreH.SklLvl(17, JRMCoreH.Pwrtyp);
/* 1030 */           if (itLevel > 0)
/* 1031 */             if (DBCKeyHandler.thirdFn.func_151470_d()) {
/* 1032 */               if (!instantTransmissionWarning) {
/* 1033 */                 String message = "Instant Transmission Failed! Teleportation is Disabled! ";
/* 1034 */                 DBCClient.mc.field_71439_g.func_145747_a((new ChatComponentText(message)).func_150255_a(DBCPacketHandlerServer.styleRed));
/* 1035 */                 instantTransmissionWarning = true;
/*      */               } 
/*      */             } else {
/*      */               
/* 1039 */               instantTransmissionWarning = false;
/*      */             }  
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public static boolean instantTransmissionOn = false;
/*      */   public static boolean instantTransmissionRequestSent = false;
/* 1048 */   public static Instant instantTransmissionPress = null;
/*      */   
/*      */   public static boolean instantTransmissionWarning = false;
/*      */   
/*      */   public static void resetIT(boolean isUsed) {
/* 1053 */     instantTransmissionOn = false;
/* 1054 */     if (!isUsed) instantTransmissionRequestSent = false; 
/* 1055 */     instantTransmissionPress = null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nuller() {
/* 1061 */     JRMCoreH.chrgPrc = 0; JRMCoreH.charged = 0; JRMCoreH.channel = 0; JRMCoreH.wave = 0; JRMCoreH.isChrgng = false; JRMCoreH.cast = 0.0F; csicsu = 0; inc = false;
/*      */   }
/*      */ 
/*      */   
/*      */   @SubscribeEvent
/*      */   public void onTick(TickEvent.ClientTickEvent event) {
/* 1067 */     if (!JRMCoreH.paused)
/*      */     {
/* 1069 */       if (event.phase.equals(TickEvent.Phase.START)) {
/*      */         
/* 1071 */         onTickInGame();
/*      */       }
/* 1073 */       else if (event.phase.equals(TickEvent.Phase.END)) {
/*      */         
/* 1075 */         onTickInGameEnd();
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   @SubscribeEvent
/*      */   public void onRenderTick(TickEvent.RenderTickEvent event) {
/* 1083 */     if (event.phase == TickEvent.Phase.END && !JRMCoreH.paused)
/*      */     {
/* 1085 */       onRenderTick();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\DBCClientTickHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */