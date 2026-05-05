/*     */ package JinRyuu.JRMCore;
/*     */ 
/*     */ import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
/*     */ import JinRyuu.JRMCore.client.helpmanager.HelpSystem;
/*     */ import JinRyuu.JRMCore.client.notification.JGNotification;
/*     */ import JinRyuu.JRMCore.client.notification.JGNotificationGUI;
/*     */ import JinRyuu.JRMCore.server.JGMathHelper;
/*     */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*     */ import cpw.mods.fml.common.gameevent.InputEvent;
/*     */ import cpw.mods.fml.common.gameevent.TickEvent;
/*     */ import java.time.Duration;
/*     */ import java.time.Instant;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.EntityClientPlayerMP;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.client.renderer.EntityRenderer;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.settings.KeyBinding;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
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
/*     */ public class JRMCoreCliTicH
/*     */ {
/*     */   public static final int ANIM_FLY = 1;
/*     */   public static final int ANIM_STAND = 2;
/*  50 */   public Minecraft mc = JRMCoreClient.mc;
/*  51 */   private int check = 0;
/*     */   
/*     */   private boolean stand = true;
/*  54 */   static int actionSelectID = 0;
/*  55 */   static int actionNPA = 0;
/*     */   static boolean actionNBO = false;
/*  57 */   boolean jfc = JRMCoreH.JFC();
/*  58 */   boolean dbc = JRMCoreH.DBC();
/*  59 */   boolean nc = JRMCoreH.NC();
/*     */   private boolean actionMenuOpen = false;
/*     */   public static EntityLivingBase lockOn;
/*  62 */   private static int dst = 50;
/*     */   
/*  64 */   private HashMap<Integer, KeyBinding> keys = new HashMap<Integer, KeyBinding>();
/*     */   
/*  66 */   public static HashMap<Integer, Integer> DoubleTapPressCounter = new HashMap<Integer, Integer>();
/*  67 */   public static HashMap<Integer, Long> Tapped = new HashMap<Integer, Long>();
/*     */   
/*     */   public boolean wig = true;
/*     */   
/*     */   private boolean viewChange = false;
/*  72 */   private int viewPrevious = 0;
/*     */   
/*     */   public static int currentTime;
/*     */   
/*     */   public static int previousTime;
/*     */   
/*     */   public static float countingValue;
/*     */   
/*     */   public static float counterValue;
/*  81 */   public static float smod = 1.0F;
/*  82 */   public static int smodr = 0;
/*     */   
/*  84 */   private static int gen = JRMCoreH.pg;
/*  85 */   public static String[] mp = JRMCoreH.p;
/*  86 */   public static int ts = 0;
/*  87 */   public static int ts2 = 0;
/*  88 */   public static int ts5 = 0;
/*     */ 
/*     */   
/*  91 */   static int fnPressed = 10;
/*  92 */   public static float offsetY = 0.0F;
/*  93 */   public static float clientHght = 1.8F;
/*     */   
/*  95 */   public static float yc = 1.0F;
/*  96 */   public static float clientHeight = JRMCoreComTickH.height - 1.5F;
/*  97 */   public static float clientEyHeigClc = 0.18F;
/*  98 */   public static float clientDefEyHeig = 0.12F;
/*  99 */   public static float clientyOffset = 1.62F;
/*     */   
/*     */   public static int mw;
/*     */   
/*     */   private EntityRenderer renderer;
/*     */   
/*     */   private EntityRenderer prevRenderer;
/*     */   
/*     */   public JRMCoreCliTicH(Minecraft mc) {
/* 108 */     this.mc = mc;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean onHotbar(Item item, EntityPlayer player) {
/* 113 */     for (int i = 0; i < 9; i++) {
/*     */       
/* 115 */       if (player.field_71071_by.func_70301_a(i) != null && player.field_71071_by.func_70301_a(i).func_77973_b() == item)
/*     */       {
/* 117 */         return true;
/*     */       }
/*     */     } 
/* 120 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void onRenderTick() {
/* 125 */     if (this.mc.field_71441_e != null && !this.mc.func_147113_T()) {
/*     */       
/* 127 */       HelpSystem.update();
/* 128 */       updateReleaseLevel();
/*     */     } 
/*     */     
/* 131 */     boolean ation = this.actionMenuOpen;
/*     */     
/* 133 */     if (JRMCoreA.pwr_usrs(JRMCoreH.Pwrtyp) && this.mc.field_71439_g != null && this.mc.field_71441_e != null && this.mc.field_71462_r == null && JRMCoreKeyHandler.actionMenu.func_151470_d()) {
/*     */       
/* 135 */       JRMCoreClient.JFCGui.renderActionMenu();
/* 136 */       this.actionMenuOpen = true;
/* 137 */       if (this.mc.field_71415_G)
/*     */       {
/* 139 */         this.mc.field_71415_G = false;
/* 140 */         this.mc.field_71417_B.func_74373_b();
/*     */       }
/*     */     
/* 143 */     } else if (this.actionMenuOpen && this.mc.field_71462_r != null) {
/*     */       
/* 145 */       KeyBinding.func_74506_a();
/* 146 */       this.actionMenuOpen = false;
/*     */     }
/* 148 */     else if (this.actionMenuOpen) {
/*     */       
/* 150 */       this.mc.field_71415_G = true;
/* 151 */       this.actionMenuOpen = false;
/* 152 */       this.mc.field_71417_B.func_74372_a();
/*     */     } 
/*     */ 
/*     */     
/* 156 */     if (JRMCoreH.Pwrtyp == 1) {
/* 157 */       JRMCoreA.actions = JRMCoreA.actionsDBC;
/* 158 */       if (ation && !this.actionMenuOpen && 
/* 159 */         JRMCoreA.actions.get(Integer.valueOf(actionSelectID)) != null) {
/* 160 */         JRMCoreHDBC.action(((Integer)JRMCoreA.actions.get(Integer.valueOf(actionSelectID))).intValue(), true, false);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 165 */     if (JRMCoreH.Pwrtyp == 2) {
/* 166 */       JRMCoreA.actions = JRMCoreA.actionsNC;
/* 167 */       if (ation && !this.actionMenuOpen && 
/* 168 */         JRMCoreA.actions.get(Integer.valueOf(actionSelectID)) != null) {
/* 169 */         JRMCoreHNC.action(((Integer)JRMCoreA.actions.get(Integer.valueOf(actionSelectID))).intValue(), true, false);
/*     */       }
/*     */     } 
/*     */     
/* 173 */     if (!actionNBO && ation && JRMCoreClient.mc.field_71474_y.field_74312_F.func_151470_d() && 
/* 174 */       actionSelectID % 9 == 4) {
/* 175 */       actionSelectID = -1;
/* 176 */       actionNBO = true;
/* 177 */       actionNPA = (actionNPA == 0) ? 1 : 0;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 182 */     EntityClientPlayerMP entityClientPlayerMP = (Minecraft.func_71410_x()).field_71439_g; dst = 35;
/* 183 */     if (lockOn != null && entityClientPlayerMP != null && JRMCoreConfig.lockon) {
/* 184 */       if (lockOn.field_70128_L || entityClientPlayerMP.func_70032_d((Entity)lockOn) > dst) {
/* 185 */         lockOn = null;
/*     */         return;
/*     */       } 
/* 188 */       EntityLivingBase target = lockOn;
/*     */       
/* 190 */       double dx = ((EntityPlayer)entityClientPlayerMP).field_70165_t - target.field_70165_t;
/* 191 */       double dz = ((EntityPlayer)entityClientPlayerMP).field_70161_v - target.field_70161_v;
/* 192 */       double dy = ((EntityPlayer)entityClientPlayerMP).field_70163_u - target.field_70163_u + (target.field_70131_O / 2.0F) - this.mc.field_71439_g.field_70131_O + 1.600000023841858D;
/* 193 */       double angle = Math.atan2(dz, dx) * 180.0D / Math.PI;
/* 194 */       double pitch = Math.atan2(dy, Math.sqrt(dx * dx + dz * dz)) * 180.0D / Math.PI;
/* 195 */       double distance = entityClientPlayerMP.func_70032_d((Entity)target);
/* 196 */       float rYaw = (float)(angle - ((EntityPlayer)entityClientPlayerMP).field_70177_z);
/* 197 */       while (rYaw > 180.0F) {
/* 198 */         rYaw -= 360.0F;
/*     */       }
/* 200 */       while (rYaw < -180.0F) {
/* 201 */         rYaw += 360.0F;
/*     */       }
/* 203 */       rYaw += 90.0F;
/* 204 */       float rPitch = (float)pitch - (float)(10.0D / Math.sqrt(distance)) + (float)(distance * Math.PI / 90.0D);
/* 205 */       entityClientPlayerMP.func_70082_c(rYaw, -(rPitch - ((EntityPlayer)entityClientPlayerMP).field_70125_A));
/*     */     } 
/*     */     
/* 208 */     if (this.mc.field_71439_g != null && this.mc.field_71415_G) if (Minecraft.func_71382_s()) {
/* 209 */         GL11.glPushMatrix();
/*     */         
/* 211 */         if (this.dbc && 
/* 212 */           JGConfigClientSettings.CLIENT_GR2 && JRMCoreH.StusEfctsMe(7)) {
/* 213 */           JRMCoreClient.bars.swoop();
/*     */         }
/* 215 */         if ((this.dbc || this.nc) && JRMCoreH.Accepted == 1 && !this.mc.field_71474_y.field_74321_H.func_151470_d() && (JRMCoreH.Pwrtyp == 1 || (JRMCoreH.Pwrtyp == 2 && JRMCoreH.inIll == null))) {
/* 216 */           if (JGConfigClientSettings.CLIENT_hud2) { JRMCoreClient.bars.renderCG(0); }
/* 217 */           else { JRMCoreClient.bars.renderBodyBar(); }
/*     */           
/* 219 */           if (JRMCoreH.Pwrtyp == 1 || (JRMCoreH.Pwrtyp == 2 && JRMCoreH.inIll == null))
/*     */           {
/* 221 */             if (!JGConfigClientSettings.CLIENT_hud2) JRMCoreClient.bars.renderKiBar(); 
/*     */           }
/* 223 */           if (JRMCoreH.Pwrtyp == 1) {
/*     */             
/* 225 */             if (!JGConfigClientSettings.CLIENT_hud2) JRMCoreClient.bars.renderRageBar(); 
/* 226 */             if (JRMCoreH.curRelease > 0) JRMCoreClient.bars.renderEnSideBar(); 
/* 227 */             if (JRMCoreH.isChrgng) JRMCoreClient.bars.renderEnChrgBar(); 
/* 228 */             if (JRMCoreH.curn > 0)
/* 229 */               JRMCoreClient.bars.rendern(); 
/* 230 */             if (JRMCoreH.cura > 0) {
/* 231 */               JRMCoreClient.bars.rendera();
/*     */             }
/*     */           } 
/* 234 */           if (JRMCoreH.Pwrtyp == 2)
/*     */           {
/* 236 */             if (JRMCoreH.curRelease > 0) JRMCoreClient.bars.renderEnSideBarNC(); 
/*     */           }
/*     */         } 
/* 239 */         if (JRMCoreH.Pwrtyp == 3 && JRMCoreH.SAOC() && JRMCoreH.Accepted == 1 && !this.mc.field_71474_y.field_74321_H.func_151470_d())
/*     */         {
/* 241 */           JRMCoreClient.bars.renderSAOHealthBar();
/*     */         }
/*     */         
/* 244 */         JRMCoreClient.bars.renderSafeZoneIndicator();
/*     */         
/* 246 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 247 */         GL11.glPopMatrix();
/*     */       } 
/*     */     
/* 250 */     NotificationHandler();
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void onInputEvent(InputEvent.KeyInputEvent event) {
/* 276 */     EntityClientPlayerMP entityClientPlayerMP = this.mc.field_71439_g;
/* 277 */     if (JRMCoreKeyHandler.lockOn.func_151470_d() && JRMCoreH.SklLvl(6) > 0 && JRMCoreConfig.lockon) {
/* 278 */       Entity rtr = JRMCoreH2.getTarget(1.0F, dst);
/* 279 */       if (lockOn == null && rtr != null) {
/* 280 */         double distanceSq = entityClientPlayerMP.func_70068_e(rtr);
/* 281 */         double reachSq = (dst * dst);
/* 282 */         if (reachSq >= distanceSq && 
/* 283 */           rtr instanceof EntityLivingBase) {
/* 284 */           lockOn = (EntityLivingBase)rtr;
/* 285 */           ((EntityPlayer)entityClientPlayerMP).field_70170_p.func_72980_b(((EntityPlayer)entityClientPlayerMP).field_70165_t, ((EntityPlayer)entityClientPlayerMP).field_70163_u, ((EntityPlayer)entityClientPlayerMP).field_70161_v, "jinryuudragonbc:DBC4.lockon", 1.0F, 1.0F, true);
/*     */         } 
/*     */       } else {
/*     */         
/* 289 */         lockOn = null;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 295 */     this.keys.put(Integer.valueOf(this.mc.field_71474_y.field_74351_w.func_151463_i()), this.mc.field_71474_y.field_74351_w);
/* 296 */     this.keys.put(Integer.valueOf(this.mc.field_71474_y.field_74368_y.func_151463_i()), this.mc.field_71474_y.field_74368_y);
/* 297 */     this.keys.put(Integer.valueOf(this.mc.field_71474_y.field_74370_x.func_151463_i()), this.mc.field_71474_y.field_74370_x);
/* 298 */     this.keys.put(Integer.valueOf(this.mc.field_71474_y.field_74366_z.func_151463_i()), this.mc.field_71474_y.field_74366_z);
/*     */     
/* 300 */     for (Map.Entry<Integer, KeyBinding> mapEntry : this.keys.entrySet()) {
/* 301 */       int k = ((Integer)mapEntry.getKey()).intValue();
/* 302 */       KeyBinding v = mapEntry.getValue();
/* 303 */       if (v.func_151470_d()) {
/* 304 */         Tapped.put(Integer.valueOf(k), Long.valueOf(dtap2()));
/* 305 */         if (((Long)Tapped.get(Integer.valueOf(k))).longValue() >= time()) {
/* 306 */           Integer c = DoubleTapPressCounter.get(Integer.valueOf(k));
/* 307 */           DoubleTapPressCounter.put(Integer.valueOf(k), Integer.valueOf((c == null) ? 1 : (c = Integer.valueOf(c.intValue() + 1)).intValue()));
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static long time() {
/* 315 */     return System.currentTimeMillis(); } public static long dtap2() {
/* 316 */     return System.currentTimeMillis() + 250L;
/*     */   }
/*     */   
/*     */   public static boolean getDT(KeyBinding k) {
/* 320 */     Integer c = DoubleTapPressCounter.get(Integer.valueOf(k.func_151463_i()));
/* 321 */     if (c != null && c.intValue() >= 2) {
/* 322 */       return true;
/*     */     }
/* 324 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void onTickInGUI() {
/* 329 */     GuiScreen guiscreen = this.mc.field_71462_r;
/* 330 */     EntityClientPlayerMP entityClientPlayerMP = this.mc.field_71439_g;
/*     */     
/* 332 */     if (guiscreen instanceof net.minecraft.client.gui.GuiMainMenu && !this.wig) {
/*     */       
/* 334 */       JRMCoreH.resetChar();
/* 335 */       JRMCoreH.resetDedSer();
/* 336 */       this.wig = true;
/*     */     } 
/*     */     
/* 339 */     if (entityClientPlayerMP != null && this.mc.field_71441_e != null && !(guiscreen instanceof JRMCoreGuiScreen)) {
/*     */       
/* 341 */       if (JRMCoreGuiScreen.hairPreview != 0)
/*     */       {
/* 343 */         JRMCoreGuiScreen.hairPreview = 0;
/*     */       }
/*     */       
/* 346 */       if (JRMCoreGuiScreen.ufc)
/*     */       {
/* 348 */         JRMCoreGuiScreen.ufc = false;
/*     */       }
/*     */     } 
/*     */     
/* 352 */     if (entityClientPlayerMP != null && !((EntityPlayer)entityClientPlayerMP).field_70128_L && this.mc.field_71441_e != null)
/*     */     {
/* 354 */       if (JRMCoreH.PlyrAttrbts[0] == 0 || this.wig) { this.wig = false; JRMCoreH.jrmct(1); JRMCoreH.jrmct(-1); JRMCoreH.jrmct(3); }
/*     */     
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
/*     */   public void onTickInGame() {
/*     */     // Byte code:
/*     */     //   0: invokestatic getDWheel : ()I
/*     */     //   3: putstatic JinRyuu/JRMCore/JRMCoreCliTicH.mw : I
/*     */     //   6: aload_0
/*     */     //   7: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   10: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*     */     //   13: astore_1
/*     */     //   14: getstatic JinRyuu/JRMCore/JRMCoreH.data1 : [Ljava/lang/String;
/*     */     //   17: ifnonnull -> 58
/*     */     //   20: aload_0
/*     */     //   21: iconst_0
/*     */     //   22: invokespecial b : (I)B
/*     */     //   25: putstatic JinRyuu/JRMCore/JRMCoreH.Race : B
/*     */     //   28: ldc_w '0'
/*     */     //   31: putstatic JinRyuu/JRMCore/JRMCoreH.dns : Ljava/lang/String;
/*     */     //   34: aload_0
/*     */     //   35: iconst_0
/*     */     //   36: invokespecial b : (I)B
/*     */     //   39: putstatic JinRyuu/JRMCore/JRMCoreH.Pwrtyp : B
/*     */     //   42: aload_0
/*     */     //   43: iconst_0
/*     */     //   44: invokespecial b : (I)B
/*     */     //   47: putstatic JinRyuu/JRMCore/JRMCoreH.Class : B
/*     */     //   50: aload_0
/*     */     //   51: iconst_2
/*     */     //   52: invokespecial b : (I)B
/*     */     //   55: putstatic JinRyuu/JRMCore/JRMCoreH.Accepted : B
/*     */     //   58: getstatic JinRyuu/JRMCore/JRMCoreCliTicH.ts : I
/*     */     //   61: ifgt -> 68
/*     */     //   64: iconst_1
/*     */     //   65: goto -> 69
/*     */     //   68: iconst_0
/*     */     //   69: putstatic JinRyuu/JRMCore/JRMCoreHC.t1s : Z
/*     */     //   72: getstatic JinRyuu/JRMCore/JRMCoreCliTicH.ts : I
/*     */     //   75: ifle -> 89
/*     */     //   78: getstatic JinRyuu/JRMCore/JRMCoreCliTicH.ts : I
/*     */     //   81: iconst_1
/*     */     //   82: isub
/*     */     //   83: putstatic JinRyuu/JRMCore/JRMCoreCliTicH.ts : I
/*     */     //   86: goto -> 94
/*     */     //   89: bipush #20
/*     */     //   91: putstatic JinRyuu/JRMCore/JRMCoreCliTicH.ts : I
/*     */     //   94: getstatic JinRyuu/JRMCore/JRMCoreCliTicH.ts2 : I
/*     */     //   97: ifgt -> 104
/*     */     //   100: iconst_1
/*     */     //   101: goto -> 105
/*     */     //   104: iconst_0
/*     */     //   105: putstatic JinRyuu/JRMCore/JRMCoreHC.t2s : Z
/*     */     //   108: getstatic JinRyuu/JRMCore/JRMCoreCliTicH.ts2 : I
/*     */     //   111: ifle -> 125
/*     */     //   114: getstatic JinRyuu/JRMCore/JRMCoreCliTicH.ts2 : I
/*     */     //   117: iconst_1
/*     */     //   118: isub
/*     */     //   119: putstatic JinRyuu/JRMCore/JRMCoreCliTicH.ts2 : I
/*     */     //   122: goto -> 130
/*     */     //   125: bipush #40
/*     */     //   127: putstatic JinRyuu/JRMCore/JRMCoreCliTicH.ts2 : I
/*     */     //   130: getstatic JinRyuu/JRMCore/JRMCoreCliTicH.ts5 : I
/*     */     //   133: ifgt -> 140
/*     */     //   136: iconst_1
/*     */     //   137: goto -> 141
/*     */     //   140: iconst_0
/*     */     //   141: putstatic JinRyuu/JRMCore/JRMCoreHC.t5s : Z
/*     */     //   144: getstatic JinRyuu/JRMCore/JRMCoreCliTicH.ts5 : I
/*     */     //   147: ifle -> 161
/*     */     //   150: getstatic JinRyuu/JRMCore/JRMCoreCliTicH.ts5 : I
/*     */     //   153: iconst_1
/*     */     //   154: isub
/*     */     //   155: putstatic JinRyuu/JRMCore/JRMCoreCliTicH.ts5 : I
/*     */     //   158: goto -> 166
/*     */     //   161: bipush #100
/*     */     //   163: putstatic JinRyuu/JRMCore/JRMCoreCliTicH.ts5 : I
/*     */     //   166: invokestatic currentTimeMillis : ()J
/*     */     //   169: ldc2_w 1000
/*     */     //   172: ldiv
/*     */     //   173: l2i
/*     */     //   174: putstatic JinRyuu/JRMCore/JRMCoreCliTicH.currentTime : I
/*     */     //   177: getstatic JinRyuu/JRMCore/JRMCoreCliTicH.currentTime : I
/*     */     //   180: getstatic JinRyuu/JRMCore/JRMCoreCliTicH.previousTime : I
/*     */     //   183: if_icmpeq -> 202
/*     */     //   186: getstatic JinRyuu/JRMCore/JRMCoreCliTicH.currentTime : I
/*     */     //   189: putstatic JinRyuu/JRMCore/JRMCoreCliTicH.previousTime : I
/*     */     //   192: getstatic JinRyuu/JRMCore/JRMCoreCliTicH.countingValue : F
/*     */     //   195: putstatic JinRyuu/JRMCore/JRMCoreCliTicH.counterValue : F
/*     */     //   198: fconst_0
/*     */     //   199: putstatic JinRyuu/JRMCore/JRMCoreCliTicH.countingValue : F
/*     */     //   202: getstatic JinRyuu/JRMCore/JRMCoreCliTicH.currentTime : I
/*     */     //   205: getstatic JinRyuu/JRMCore/JRMCoreCliTicH.previousTime : I
/*     */     //   208: if_icmpne -> 219
/*     */     //   211: getstatic JinRyuu/JRMCore/JRMCoreCliTicH.countingValue : F
/*     */     //   214: fconst_1
/*     */     //   215: fadd
/*     */     //   216: putstatic JinRyuu/JRMCore/JRMCoreCliTicH.countingValue : F
/*     */     //   219: getstatic JinRyuu/JRMCore/JRMCoreCliTicH.Tapped : Ljava/util/HashMap;
/*     */     //   222: invokevirtual clone : ()Ljava/lang/Object;
/*     */     //   225: checkcast java/util/HashMap
/*     */     //   228: astore_2
/*     */     //   229: aload_2
/*     */     //   230: invokevirtual entrySet : ()Ljava/util/Set;
/*     */     //   233: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   238: astore_3
/*     */     //   239: aload_3
/*     */     //   240: invokeinterface hasNext : ()Z
/*     */     //   245: ifeq -> 325
/*     */     //   248: aload_3
/*     */     //   249: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   254: checkcast java/util/Map$Entry
/*     */     //   257: astore #4
/*     */     //   259: aload #4
/*     */     //   261: invokeinterface getKey : ()Ljava/lang/Object;
/*     */     //   266: checkcast java/lang/Integer
/*     */     //   269: invokevirtual intValue : ()I
/*     */     //   272: istore #5
/*     */     //   274: aload #4
/*     */     //   276: invokeinterface getValue : ()Ljava/lang/Object;
/*     */     //   281: checkcast java/lang/Long
/*     */     //   284: invokevirtual longValue : ()J
/*     */     //   287: lstore #6
/*     */     //   289: lload #6
/*     */     //   291: invokestatic time : ()J
/*     */     //   294: lcmp
/*     */     //   295: ifge -> 322
/*     */     //   298: getstatic JinRyuu/JRMCore/JRMCoreCliTicH.Tapped : Ljava/util/HashMap;
/*     */     //   301: iload #5
/*     */     //   303: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   306: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   309: pop
/*     */     //   310: getstatic JinRyuu/JRMCore/JRMCoreCliTicH.DoubleTapPressCounter : Ljava/util/HashMap;
/*     */     //   313: iload #5
/*     */     //   315: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   318: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   321: pop
/*     */     //   322: goto -> 239
/*     */     //   325: aload_1
/*     */     //   326: ifnull -> 2930
/*     */     //   329: aload_1
/*     */     //   330: getfield field_70128_L : Z
/*     */     //   333: ifne -> 2930
/*     */     //   336: aload_0
/*     */     //   337: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   340: getfield field_71441_e : Lnet/minecraft/client/multiplayer/WorldClient;
/*     */     //   343: ifnull -> 2930
/*     */     //   346: aload_0
/*     */     //   347: getfield wig : Z
/*     */     //   350: ifeq -> 358
/*     */     //   353: aload_0
/*     */     //   354: iconst_0
/*     */     //   355: putfield wig : Z
/*     */     //   358: getstatic JinRyuu/JRMCore/JRMCoreCliTicH.smodr : I
/*     */     //   361: ifle -> 372
/*     */     //   364: getstatic JinRyuu/JRMCore/JRMCoreCliTicH.smodr : I
/*     */     //   367: iconst_1
/*     */     //   368: isub
/*     */     //   369: putstatic JinRyuu/JRMCore/JRMCoreCliTicH.smodr : I
/*     */     //   372: getstatic JinRyuu/JRMCore/JRMCoreCliTicH.smodr : I
/*     */     //   375: ifne -> 390
/*     */     //   378: getstatic JinRyuu/JRMCore/JRMCoreCliTicH.smod : F
/*     */     //   381: fconst_1
/*     */     //   382: fcmpl
/*     */     //   383: ifeq -> 390
/*     */     //   386: fconst_1
/*     */     //   387: putstatic JinRyuu/JRMCore/JRMCoreCliTicH.smod : F
/*     */     //   390: iconst_1
/*     */     //   391: invokestatic weightPerc : (I)F
/*     */     //   394: getstatic JinRyuu/JRMCore/JRMCoreCliTicH.smod : F
/*     */     //   397: fmul
/*     */     //   398: fstore_3
/*     */     //   399: getstatic JinRyuu/JRMCore/JRMCoreConfig.releaseStop : Z
/*     */     //   402: ifeq -> 417
/*     */     //   405: getstatic JinRyuu/JRMCore/JRMCoreKeyHandler.KiCharge : Lnet/minecraft/client/settings/KeyBinding;
/*     */     //   408: invokevirtual func_151470_d : ()Z
/*     */     //   411: ifeq -> 417
/*     */     //   414: goto -> 423
/*     */     //   417: getstatic JinRyuu/JRMCore/JRMCoreH.kob : Z
/*     */     //   420: ifeq -> 427
/*     */     //   423: iconst_1
/*     */     //   424: goto -> 428
/*     */     //   427: iconst_0
/*     */     //   428: istore #4
/*     */     //   430: bipush #18
/*     */     //   432: ldc_w '0;0;0;0;0;0;0;0;0'
/*     */     //   435: invokestatic data : (ILjava/lang/String;)Ljava/lang/String;
/*     */     //   438: ldc_w ';'
/*     */     //   441: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
/*     */     //   444: astore #5
/*     */     //   446: aload #5
/*     */     //   448: iconst_2
/*     */     //   449: aaload
/*     */     //   450: ldc_w ','
/*     */     //   453: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
/*     */     //   456: astore #6
/*     */     //   458: aload #6
/*     */     //   460: arraylength
/*     */     //   461: iconst_3
/*     */     //   462: if_icmpne -> 485
/*     */     //   465: aload #6
/*     */     //   467: iconst_1
/*     */     //   468: aaload
/*     */     //   469: aload_0
/*     */     //   470: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   473: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*     */     //   476: invokevirtual func_70005_c_ : ()Ljava/lang/String;
/*     */     //   479: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
/*     */     //   482: ifne -> 491
/*     */     //   485: getstatic JinRyuu/JRMCore/JRMCoreH.kob : Z
/*     */     //   488: ifeq -> 623
/*     */     //   491: iconst_1
/*     */     //   492: istore #4
/*     */     //   494: aload_0
/*     */     //   495: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   498: getfield field_71441_e : Lnet/minecraft/client/multiplayer/WorldClient;
/*     */     //   501: aload #6
/*     */     //   503: iconst_0
/*     */     //   504: aaload
/*     */     //   505: invokevirtual func_72924_a : (Ljava/lang/String;)Lnet/minecraft/entity/player/EntityPlayer;
/*     */     //   508: astore #7
/*     */     //   510: aload #7
/*     */     //   512: ifnull -> 623
/*     */     //   515: aload_0
/*     */     //   516: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   519: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*     */     //   522: aload #7
/*     */     //   524: invokevirtual func_70032_d : (Lnet/minecraft/entity/Entity;)F
/*     */     //   527: ldc_w 5.0
/*     */     //   530: fcmpl
/*     */     //   531: ifle -> 579
/*     */     //   534: aload_0
/*     */     //   535: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   538: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*     */     //   541: aload #7
/*     */     //   543: getfield field_70165_t : D
/*     */     //   546: aload #7
/*     */     //   548: getfield field_70163_u : D
/*     */     //   551: aload #7
/*     */     //   553: getfield field_70161_v : D
/*     */     //   556: aload_0
/*     */     //   557: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   560: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*     */     //   563: getfield field_70177_z : F
/*     */     //   566: aload_0
/*     */     //   567: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   570: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*     */     //   573: getfield field_70125_A : F
/*     */     //   576: invokevirtual func_70012_b : (DDDFF)V
/*     */     //   579: aload_0
/*     */     //   580: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   583: getfield field_71474_y : Lnet/minecraft/client/settings/GameSettings;
/*     */     //   586: iconst_1
/*     */     //   587: putfield field_74320_O : I
/*     */     //   590: aload_0
/*     */     //   591: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   594: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*     */     //   597: dconst_0
/*     */     //   598: putfield field_70159_w : D
/*     */     //   601: aload_0
/*     */     //   602: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   605: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*     */     //   608: dconst_0
/*     */     //   609: putfield field_70181_x : D
/*     */     //   612: aload_0
/*     */     //   613: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   616: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*     */     //   619: dconst_0
/*     */     //   620: putfield field_70179_y : D
/*     */     //   623: getstatic JinRyuu/JRMCore/JRMCoreH.kob : Z
/*     */     //   626: ifeq -> 669
/*     */     //   629: aload_0
/*     */     //   630: getfield viewChange : Z
/*     */     //   633: ifne -> 655
/*     */     //   636: aload_0
/*     */     //   637: iconst_1
/*     */     //   638: putfield viewChange : Z
/*     */     //   641: aload_0
/*     */     //   642: aload_0
/*     */     //   643: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   646: getfield field_71474_y : Lnet/minecraft/client/settings/GameSettings;
/*     */     //   649: getfield field_74320_O : I
/*     */     //   652: putfield viewPrevious : I
/*     */     //   655: aload_0
/*     */     //   656: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   659: getfield field_71474_y : Lnet/minecraft/client/settings/GameSettings;
/*     */     //   662: iconst_1
/*     */     //   663: putfield field_74320_O : I
/*     */     //   666: goto -> 695
/*     */     //   669: aload_0
/*     */     //   670: getfield viewChange : Z
/*     */     //   673: ifeq -> 695
/*     */     //   676: aload_0
/*     */     //   677: iconst_0
/*     */     //   678: putfield viewChange : Z
/*     */     //   681: aload_0
/*     */     //   682: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   685: getfield field_71474_y : Lnet/minecraft/client/settings/GameSettings;
/*     */     //   688: aload_0
/*     */     //   689: getfield viewPrevious : I
/*     */     //   692: putfield field_74320_O : I
/*     */     //   695: getstatic JinRyuu/JRMCore/JRMCoreH.WeightOn : F
/*     */     //   698: fconst_0
/*     */     //   699: fcmpl
/*     */     //   700: ifgt -> 722
/*     */     //   703: iload #4
/*     */     //   705: ifne -> 722
/*     */     //   708: getstatic JinRyuu/JRMCore/JRMCoreCliTicH.smod : F
/*     */     //   711: fconst_1
/*     */     //   712: fcmpl
/*     */     //   713: ifne -> 722
/*     */     //   716: getstatic JinRyuu/JRMCore/JRMCoreH.pnh : Z
/*     */     //   719: ifeq -> 970
/*     */     //   722: iload #4
/*     */     //   724: ifeq -> 729
/*     */     //   727: fconst_0
/*     */     //   728: fstore_3
/*     */     //   729: getstatic JinRyuu/JRMCore/JRMCoreH.pnh : Z
/*     */     //   732: ifeq -> 750
/*     */     //   735: aload_1
/*     */     //   736: getfield field_71093_bK : I
/*     */     //   739: bipush #22
/*     */     //   741: if_icmpeq -> 750
/*     */     //   744: fload_3
/*     */     //   745: ldc_w 0.5
/*     */     //   748: fmul
/*     */     //   749: fstore_3
/*     */     //   750: aload_0
/*     */     //   751: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   754: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*     */     //   757: getfield field_71158_b : Lnet/minecraft/util/MovementInput;
/*     */     //   760: instanceof JinRyuu/JRMCore/MoveInputJRMC
/*     */     //   763: ifeq -> 836
/*     */     //   766: aload_0
/*     */     //   767: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   770: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*     */     //   773: getfield field_70170_p : Lnet/minecraft/world/World;
/*     */     //   776: aload_0
/*     */     //   777: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   780: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*     */     //   783: getfield field_70165_t : D
/*     */     //   786: d2i
/*     */     //   787: aload_0
/*     */     //   788: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   791: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*     */     //   794: getfield field_70161_v : D
/*     */     //   797: d2i
/*     */     //   798: invokevirtual func_72976_f : (II)I
/*     */     //   801: ifle -> 836
/*     */     //   804: aload_0
/*     */     //   805: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   808: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*     */     //   811: getfield field_70181_x : D
/*     */     //   814: dconst_0
/*     */     //   815: dcmpl
/*     */     //   816: ifle -> 836
/*     */     //   819: aload_0
/*     */     //   820: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   823: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*     */     //   826: dup
/*     */     //   827: getfield field_70181_x : D
/*     */     //   830: fload_3
/*     */     //   831: f2d
/*     */     //   832: dmul
/*     */     //   833: putfield field_70181_x : D
/*     */     //   836: aload_0
/*     */     //   837: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   840: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*     */     //   843: getfield field_71158_b : Lnet/minecraft/util/MovementInput;
/*     */     //   846: instanceof JinRyuu/JRMCore/MoveInputJRMC
/*     */     //   849: ifne -> 913
/*     */     //   852: aload_0
/*     */     //   853: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   856: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*     */     //   859: getfield field_71158_b : Lnet/minecraft/util/MovementInput;
/*     */     //   862: getfield field_78900_b : F
/*     */     //   865: fconst_0
/*     */     //   866: fcmpl
/*     */     //   867: ifne -> 888
/*     */     //   870: aload_0
/*     */     //   871: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   874: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*     */     //   877: getfield field_71158_b : Lnet/minecraft/util/MovementInput;
/*     */     //   880: getfield field_78902_a : F
/*     */     //   883: fconst_0
/*     */     //   884: fcmpl
/*     */     //   885: ifeq -> 913
/*     */     //   888: aload_0
/*     */     //   889: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   892: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*     */     //   895: new JinRyuu/JRMCore/MoveInputJRMC
/*     */     //   898: dup
/*     */     //   899: aload_0
/*     */     //   900: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   903: getfield field_71474_y : Lnet/minecraft/client/settings/GameSettings;
/*     */     //   906: fload_3
/*     */     //   907: invokespecial <init> : (Lnet/minecraft/client/settings/GameSettings;F)V
/*     */     //   910: putfield field_71158_b : Lnet/minecraft/util/MovementInput;
/*     */     //   913: aload_0
/*     */     //   914: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   917: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*     */     //   920: getfield field_71158_b : Lnet/minecraft/util/MovementInput;
/*     */     //   923: instanceof JinRyuu/JRMCore/MoveInputJRMC
/*     */     //   926: ifeq -> 1010
/*     */     //   929: aload_0
/*     */     //   930: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   933: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*     */     //   936: getfield field_71158_b : Lnet/minecraft/util/MovementInput;
/*     */     //   939: checkcast JinRyuu/JRMCore/MoveInputJRMC
/*     */     //   942: getfield moveModifier : F
/*     */     //   945: fload_3
/*     */     //   946: fcmpl
/*     */     //   947: ifeq -> 1010
/*     */     //   950: aload_0
/*     */     //   951: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   954: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*     */     //   957: getfield field_71158_b : Lnet/minecraft/util/MovementInput;
/*     */     //   960: checkcast JinRyuu/JRMCore/MoveInputJRMC
/*     */     //   963: fload_3
/*     */     //   964: putfield moveModifier : F
/*     */     //   967: goto -> 1010
/*     */     //   970: aload_0
/*     */     //   971: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   974: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*     */     //   977: getfield field_71158_b : Lnet/minecraft/util/MovementInput;
/*     */     //   980: instanceof net/minecraft/util/MovementInputFromOptions
/*     */     //   983: ifne -> 1010
/*     */     //   986: aload_0
/*     */     //   987: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   990: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*     */     //   993: new net/minecraft/util/MovementInputFromOptions
/*     */     //   996: dup
/*     */     //   997: aload_0
/*     */     //   998: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   1001: getfield field_71474_y : Lnet/minecraft/client/settings/GameSettings;
/*     */     //   1004: invokespecial <init> : (Lnet/minecraft/client/settings/GameSettings;)V
/*     */     //   1007: putfield field_71158_b : Lnet/minecraft/util/MovementInput;
/*     */     //   1010: aload_0
/*     */     //   1011: dup
/*     */     //   1012: getfield check : I
/*     */     //   1015: iconst_1
/*     */     //   1016: iadd
/*     */     //   1017: putfield check : I
/*     */     //   1020: aload_0
/*     */     //   1021: getfield check : I
/*     */     //   1024: iconst_1
/*     */     //   1025: if_icmpne -> 1061
/*     */     //   1028: aload_1
/*     */     //   1029: getstatic JinRyuu/JRMCore/mod_JRMCore.instance : LJinRyuu/JRMCore/mod_JRMCore;
/*     */     //   1032: bipush #30
/*     */     //   1034: aload_1
/*     */     //   1035: getfield field_70170_p : Lnet/minecraft/world/World;
/*     */     //   1038: aload_1
/*     */     //   1039: getfield field_70165_t : D
/*     */     //   1042: d2i
/*     */     //   1043: aload_1
/*     */     //   1044: getfield field_70163_u : D
/*     */     //   1047: d2i
/*     */     //   1048: aload_1
/*     */     //   1049: getfield field_70161_v : D
/*     */     //   1052: d2i
/*     */     //   1053: invokevirtual openGui : (Ljava/lang/Object;ILnet/minecraft/world/World;III)V
/*     */     //   1056: aload_0
/*     */     //   1057: iconst_2
/*     */     //   1058: putfield check : I
/*     */     //   1061: getstatic JinRyuu/JRMCore/JRMCoreH.Pwrtyp : B
/*     */     //   1064: iconst_1
/*     */     //   1065: if_icmpeq -> 1075
/*     */     //   1068: getstatic JinRyuu/JRMCore/JRMCoreH.Pwrtyp : B
/*     */     //   1071: iconst_2
/*     */     //   1072: if_icmpne -> 1112
/*     */     //   1075: getstatic JinRyuu/JRMCore/JRMCoreKeyHandler.Sagasys : Lnet/minecraft/client/settings/KeyBinding;
/*     */     //   1078: invokevirtual func_151470_d : ()Z
/*     */     //   1081: ifeq -> 1112
/*     */     //   1084: aload_1
/*     */     //   1085: getstatic JinRyuu/JRMCore/mod_JRMCore.instance : LJinRyuu/JRMCore/mod_JRMCore;
/*     */     //   1088: bipush #60
/*     */     //   1090: aload_1
/*     */     //   1091: getfield field_70170_p : Lnet/minecraft/world/World;
/*     */     //   1094: aload_1
/*     */     //   1095: getfield field_70165_t : D
/*     */     //   1098: d2i
/*     */     //   1099: aload_1
/*     */     //   1100: getfield field_70163_u : D
/*     */     //   1103: d2i
/*     */     //   1104: aload_1
/*     */     //   1105: getfield field_70161_v : D
/*     */     //   1108: d2i
/*     */     //   1109: invokevirtual openGui : (Ljava/lang/Object;ILnet/minecraft/world/World;III)V
/*     */     //   1112: getstatic JinRyuu/JRMCore/JRMCoreKeyHandler.infopanel : Lnet/minecraft/client/settings/KeyBinding;
/*     */     //   1115: invokevirtual func_151470_d : ()Z
/*     */     //   1118: ifeq -> 1149
/*     */     //   1121: aload_1
/*     */     //   1122: getstatic JinRyuu/JRMCore/mod_JRMCore.instance : LJinRyuu/JRMCore/mod_JRMCore;
/*     */     //   1125: bipush #30
/*     */     //   1127: aload_1
/*     */     //   1128: getfield field_70170_p : Lnet/minecraft/world/World;
/*     */     //   1131: aload_1
/*     */     //   1132: getfield field_70165_t : D
/*     */     //   1135: d2i
/*     */     //   1136: aload_1
/*     */     //   1137: getfield field_70163_u : D
/*     */     //   1140: d2i
/*     */     //   1141: aload_1
/*     */     //   1142: getfield field_70161_v : D
/*     */     //   1145: d2i
/*     */     //   1146: invokevirtual openGui : (Ljava/lang/Object;ILnet/minecraft/world/World;III)V
/*     */     //   1149: getstatic JinRyuu/JRMCore/JRMCoreKeyHandler.DS : Lnet/minecraft/client/settings/KeyBinding;
/*     */     //   1152: invokevirtual func_151470_d : ()Z
/*     */     //   1155: ifeq -> 1185
/*     */     //   1158: aload_1
/*     */     //   1159: getstatic JinRyuu/JRMCore/mod_JRMCore.instance : LJinRyuu/JRMCore/mod_JRMCore;
/*     */     //   1162: iconst_0
/*     */     //   1163: aload_1
/*     */     //   1164: getfield field_70170_p : Lnet/minecraft/world/World;
/*     */     //   1167: aload_1
/*     */     //   1168: getfield field_70165_t : D
/*     */     //   1171: d2i
/*     */     //   1172: aload_1
/*     */     //   1173: getfield field_70163_u : D
/*     */     //   1176: d2i
/*     */     //   1177: aload_1
/*     */     //   1178: getfield field_70161_v : D
/*     */     //   1181: d2i
/*     */     //   1182: invokevirtual openGui : (Ljava/lang/Object;ILnet/minecraft/world/World;III)V
/*     */     //   1185: getstatic JinRyuu/JRMCore/JRMCoreH.PlyrAttrbts : [I
/*     */     //   1188: iconst_0
/*     */     //   1189: iaload
/*     */     //   1190: ifeq -> 1200
/*     */     //   1193: aload_0
/*     */     //   1194: getfield wig : Z
/*     */     //   1197: ifeq -> 1217
/*     */     //   1200: aload_0
/*     */     //   1201: iconst_0
/*     */     //   1202: putfield wig : Z
/*     */     //   1205: iconst_1
/*     */     //   1206: invokestatic jrmct : (I)V
/*     */     //   1209: iconst_m1
/*     */     //   1210: invokestatic jrmct : (I)V
/*     */     //   1213: iconst_3
/*     */     //   1214: invokestatic jrmct : (I)V
/*     */     //   1217: aload_0
/*     */     //   1218: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   1221: invokevirtual func_147113_T : ()Z
/*     */     //   1224: ifne -> 1279
/*     */     //   1227: iconst_0
/*     */     //   1228: istore #7
/*     */     //   1230: iload #7
/*     */     //   1232: getstatic JinRyuu/JRMCore/JRMCoreH.techniqueCooldowns : [F
/*     */     //   1235: arraylength
/*     */     //   1236: if_icmpge -> 1276
/*     */     //   1239: getstatic JinRyuu/JRMCore/JRMCoreH.techniqueCooldowns : [F
/*     */     //   1242: iload #7
/*     */     //   1244: getstatic JinRyuu/JRMCore/JRMCoreH.techniqueCooldowns : [F
/*     */     //   1247: iload #7
/*     */     //   1249: faload
/*     */     //   1250: fconst_0
/*     */     //   1251: fcmpl
/*     */     //   1252: ifle -> 1268
/*     */     //   1255: getstatic JinRyuu/JRMCore/JRMCoreH.techniqueCooldowns : [F
/*     */     //   1258: iload #7
/*     */     //   1260: faload
/*     */     //   1261: ldc_w 0.05
/*     */     //   1264: fsub
/*     */     //   1265: goto -> 1269
/*     */     //   1268: fconst_0
/*     */     //   1269: fastore
/*     */     //   1270: iinc #7, 1
/*     */     //   1273: goto -> 1230
/*     */     //   1276: invokestatic updateAllOldCooldownValues : ()V
/*     */     //   1279: getstatic JinRyuu/JRMCore/JRMCoreH.Accepted : B
/*     */     //   1282: iconst_2
/*     */     //   1283: if_icmpne -> 1308
/*     */     //   1286: iconst_0
/*     */     //   1287: putstatic JinRyuu/JRMCore/JRMCoreH.Race : B
/*     */     //   1290: ldc_w '0'
/*     */     //   1293: putstatic JinRyuu/JRMCore/JRMCoreH.dns : Ljava/lang/String;
/*     */     //   1296: iconst_0
/*     */     //   1297: putstatic JinRyuu/JRMCore/JRMCoreH.Pwrtyp : B
/*     */     //   1300: iconst_0
/*     */     //   1301: putstatic JinRyuu/JRMCore/JRMCoreH.Class : B
/*     */     //   1304: iconst_0
/*     */     //   1305: putstatic JinRyuu/JRMCore/JRMCoreH.State : B
/*     */     //   1308: fconst_1
/*     */     //   1309: fstore #7
/*     */     //   1311: fconst_1
/*     */     //   1312: fstore #8
/*     */     //   1314: fconst_1
/*     */     //   1315: fstore #9
/*     */     //   1317: invokestatic DBC : ()Z
/*     */     //   1320: ifne -> 1327
/*     */     //   1323: iconst_1
/*     */     //   1324: goto -> 1328
/*     */     //   1327: iconst_0
/*     */     //   1328: istore #10
/*     */     //   1330: getstatic JinRyuu/JRMCore/JRMCoreH.dns : Ljava/lang/String;
/*     */     //   1333: invokestatic dnsGender : (Ljava/lang/String;)I
/*     */     //   1336: iconst_1
/*     */     //   1337: if_icmpgt -> 1358
/*     */     //   1340: ldc_w 0.73
/*     */     //   1343: iload #10
/*     */     //   1345: ifeq -> 1354
/*     */     //   1348: ldc_w 0.27
/*     */     //   1351: goto -> 1355
/*     */     //   1354: fconst_0
/*     */     //   1355: fadd
/*     */     //   1356: fstore #7
/*     */     //   1358: getstatic JinRyuu/JRMCore/JRMCoreH.dns : Ljava/lang/String;
/*     */     //   1361: invokestatic dnsGender : (Ljava/lang/String;)I
/*     */     //   1364: iconst_2
/*     */     //   1365: if_icmplt -> 1386
/*     */     //   1368: ldc_w 0.7
/*     */     //   1371: iload #10
/*     */     //   1373: ifeq -> 1382
/*     */     //   1376: ldc_w 0.27
/*     */     //   1379: goto -> 1383
/*     */     //   1382: fconst_0
/*     */     //   1383: fadd
/*     */     //   1384: fstore #7
/*     */     //   1386: invokestatic JYC : ()Z
/*     */     //   1389: ifeq -> 1399
/*     */     //   1392: aload_1
/*     */     //   1393: invokestatic JYCsizeBasedOnAge : (Lnet/minecraft/entity/player/EntityPlayer;)F
/*     */     //   1396: putstatic JinRyuu/JRMCore/JRMCoreCliTicH.yc : F
/*     */     //   1399: invokestatic DBC : ()Z
/*     */     //   1402: ifeq -> 1658
/*     */     //   1405: getstatic JinRyuu/JRMCore/JRMCoreH.PlyrAttrbts : [I
/*     */     //   1408: iconst_0
/*     */     //   1409: iaload
/*     */     //   1410: ifeq -> 1658
/*     */     //   1413: getstatic JinRyuu/JRMCore/JRMCoreConfig.sizes : Z
/*     */     //   1416: ifeq -> 1658
/*     */     //   1419: fload #7
/*     */     //   1421: fstore #11
/*     */     //   1423: invokestatic DBCreleaseZeroTurnOffTurbo : ()V
/*     */     //   1426: fload #7
/*     */     //   1428: getstatic JinRyuu/JRMCore/JRMCoreH.PlyrAttrbts : [I
/*     */     //   1431: invokestatic DBCsizeBasedOnCns : ([I)F
/*     */     //   1434: fadd
/*     */     //   1435: fstore #7
/*     */     //   1437: invokestatic isPowerTypeChakra : ()Z
/*     */     //   1440: ifne -> 1487
/*     */     //   1443: getstatic JinRyuu/JRMCore/JRMCoreH.Race : B
/*     */     //   1446: iconst_3
/*     */     //   1447: if_icmpne -> 1458
/*     */     //   1450: bipush #17
/*     */     //   1452: invokestatic StusEfctsMe : (I)Z
/*     */     //   1455: goto -> 1459
/*     */     //   1458: iconst_0
/*     */     //   1459: istore #12
/*     */     //   1461: getstatic JinRyuu/JRMCore/JRMCoreH.Race : B
/*     */     //   1464: getstatic JinRyuu/JRMCore/JRMCoreH.State : B
/*     */     //   1467: iload #12
/*     */     //   1469: invokestatic DBCsizeBasedOnRace : (IIZ)F
/*     */     //   1472: fstore #8
/*     */     //   1474: getstatic JinRyuu/JRMCore/JRMCoreH.Race : B
/*     */     //   1477: getstatic JinRyuu/JRMCore/JRMCoreH.State : B
/*     */     //   1480: iload #12
/*     */     //   1482: invokestatic DBCsizeBasedOnRace2 : (IIZ)F
/*     */     //   1485: fstore #9
/*     */     //   1487: getstatic JinRyuu/JRMCore/JRMCoreH.curRelease : B
/*     */     //   1490: istore #12
/*     */     //   1492: getstatic JinRyuu/JRMCore/JRMCoreH.Race : B
/*     */     //   1495: invokestatic rSai : (I)Z
/*     */     //   1498: ifeq -> 1525
/*     */     //   1501: getstatic JinRyuu/JRMCore/JRMCoreH.State : B
/*     */     //   1504: bipush #7
/*     */     //   1506: if_icmpeq -> 1517
/*     */     //   1509: getstatic JinRyuu/JRMCore/JRMCoreH.State : B
/*     */     //   1512: bipush #8
/*     */     //   1514: if_icmpne -> 1525
/*     */     //   1517: bipush #50
/*     */     //   1519: istore #12
/*     */     //   1521: fload #11
/*     */     //   1523: fstore #7
/*     */     //   1525: fload #9
/*     */     //   1527: fconst_1
/*     */     //   1528: fsub
/*     */     //   1529: iload #12
/*     */     //   1531: i2f
/*     */     //   1532: fmul
/*     */     //   1533: ldc_w 0.02
/*     */     //   1536: fmul
/*     */     //   1537: fconst_1
/*     */     //   1538: fadd
/*     */     //   1539: fstore #13
/*     */     //   1541: fload #13
/*     */     //   1543: fload #9
/*     */     //   1545: fcmpl
/*     */     //   1546: ifle -> 1554
/*     */     //   1549: fload #9
/*     */     //   1551: goto -> 1568
/*     */     //   1554: fload #9
/*     */     //   1556: fconst_1
/*     */     //   1557: fcmpl
/*     */     //   1558: ifle -> 1566
/*     */     //   1561: fload #13
/*     */     //   1563: goto -> 1568
/*     */     //   1566: fload #9
/*     */     //   1568: fstore #9
/*     */     //   1570: fload #8
/*     */     //   1572: fconst_1
/*     */     //   1573: fsub
/*     */     //   1574: iload #12
/*     */     //   1576: i2f
/*     */     //   1577: fmul
/*     */     //   1578: ldc_w 0.02
/*     */     //   1581: fmul
/*     */     //   1582: fconst_1
/*     */     //   1583: fadd
/*     */     //   1584: fstore #14
/*     */     //   1586: fload #8
/*     */     //   1588: fconst_1
/*     */     //   1589: fcmpl
/*     */     //   1590: ifle -> 1598
/*     */     //   1593: fload #14
/*     */     //   1595: goto -> 1600
/*     */     //   1598: fload #8
/*     */     //   1600: fstore #8
/*     */     //   1602: fload #7
/*     */     //   1604: fload #11
/*     */     //   1606: fsub
/*     */     //   1607: iload #12
/*     */     //   1609: bipush #50
/*     */     //   1611: if_icmpgt -> 1620
/*     */     //   1614: ldc_w 0.25
/*     */     //   1617: goto -> 1623
/*     */     //   1620: ldc_w 0.5
/*     */     //   1623: fmul
/*     */     //   1624: fstore #15
/*     */     //   1626: fload #15
/*     */     //   1628: iload #12
/*     */     //   1630: i2f
/*     */     //   1631: fmul
/*     */     //   1632: ldc_w 0.02
/*     */     //   1635: fmul
/*     */     //   1636: fstore #16
/*     */     //   1638: fload #7
/*     */     //   1640: fload #11
/*     */     //   1642: fsub
/*     */     //   1643: fload #15
/*     */     //   1645: fsub
/*     */     //   1646: fload #16
/*     */     //   1648: fadd
/*     */     //   1649: fload #11
/*     */     //   1651: fadd
/*     */     //   1652: fstore #17
/*     */     //   1654: fload #17
/*     */     //   1656: fstore #7
/*     */     //   1658: getstatic JinRyuu/JRMCore/JRMCoreH.dns : Ljava/lang/String;
/*     */     //   1661: invokevirtual length : ()I
/*     */     //   1664: iconst_3
/*     */     //   1665: if_icmpge -> 1683
/*     */     //   1668: ldc_w 0.9375
/*     */     //   1671: fstore #7
/*     */     //   1673: fconst_1
/*     */     //   1674: fstore #8
/*     */     //   1676: fconst_1
/*     */     //   1677: fstore #9
/*     */     //   1679: fconst_1
/*     */     //   1680: putstatic JinRyuu/JRMCore/JRMCoreCliTicH.yc : F
/*     */     //   1683: aload_1
/*     */     //   1684: invokevirtual func_70608_bn : ()Z
/*     */     //   1687: ifne -> 1937
/*     */     //   1690: invokestatic JBRA : ()Z
/*     */     //   1693: ifeq -> 1937
/*     */     //   1696: aload_0
/*     */     //   1697: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   1700: getfield field_71474_y : Lnet/minecraft/client/settings/GameSettings;
/*     */     //   1703: getfield field_74314_A : Lnet/minecraft/client/settings/KeyBinding;
/*     */     //   1706: invokevirtual func_151468_f : ()Z
/*     */     //   1709: ifeq -> 1846
/*     */     //   1712: aload_0
/*     */     //   1713: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   1716: getfield field_71441_e : Lnet/minecraft/client/multiplayer/WorldClient;
/*     */     //   1719: aload_0
/*     */     //   1720: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   1723: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*     */     //   1726: getfield field_70165_t : D
/*     */     //   1729: d2i
/*     */     //   1730: aload_0
/*     */     //   1731: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   1734: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*     */     //   1737: getfield field_70163_u : D
/*     */     //   1740: d2i
/*     */     //   1741: iconst_1
/*     */     //   1742: isub
/*     */     //   1743: aload_0
/*     */     //   1744: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   1747: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*     */     //   1750: getfield field_70161_v : D
/*     */     //   1753: d2i
/*     */     //   1754: iconst_1
/*     */     //   1755: isub
/*     */     //   1756: invokevirtual func_147439_a : (III)Lnet/minecraft/block/Block;
/*     */     //   1759: invokevirtual func_149688_o : ()Lnet/minecraft/block/material/Material;
/*     */     //   1762: getstatic net/minecraft/block/material/Material.field_151586_h : Lnet/minecraft/block/material/Material;
/*     */     //   1765: if_acmpeq -> 1824
/*     */     //   1768: aload_0
/*     */     //   1769: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   1772: getfield field_71441_e : Lnet/minecraft/client/multiplayer/WorldClient;
/*     */     //   1775: aload_0
/*     */     //   1776: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   1779: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*     */     //   1782: getfield field_70165_t : D
/*     */     //   1785: d2i
/*     */     //   1786: aload_0
/*     */     //   1787: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   1790: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*     */     //   1793: getfield field_70163_u : D
/*     */     //   1796: d2i
/*     */     //   1797: iconst_1
/*     */     //   1798: isub
/*     */     //   1799: aload_0
/*     */     //   1800: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   1803: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*     */     //   1806: getfield field_70161_v : D
/*     */     //   1809: d2i
/*     */     //   1810: iconst_1
/*     */     //   1811: isub
/*     */     //   1812: invokevirtual func_147439_a : (III)Lnet/minecraft/block/Block;
/*     */     //   1815: invokevirtual func_149688_o : ()Lnet/minecraft/block/material/Material;
/*     */     //   1818: getstatic net/minecraft/block/material/Material.field_151587_i : Lnet/minecraft/block/material/Material;
/*     */     //   1821: if_acmpne -> 1846
/*     */     //   1824: ldc2_w 0.02
/*     */     //   1827: dstore #11
/*     */     //   1829: aload_0
/*     */     //   1830: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   1833: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*     */     //   1836: dup
/*     */     //   1837: getfield field_70181_x : D
/*     */     //   1840: dload #11
/*     */     //   1842: dadd
/*     */     //   1843: putfield field_70181_x : D
/*     */     //   1846: getstatic JinRyuu/JRMCore/JRMCoreComTickH.height : F
/*     */     //   1849: fload #7
/*     */     //   1851: fmul
/*     */     //   1852: fload #9
/*     */     //   1854: fmul
/*     */     //   1855: getstatic JinRyuu/JRMCore/JRMCoreCliTicH.yc : F
/*     */     //   1858: fmul
/*     */     //   1859: putstatic JinRyuu/JRMCore/JRMCoreCliTicH.clientHght : F
/*     */     //   1862: getstatic JinRyuu/JRMCore/JRMCoreCliTicH.clientHght : F
/*     */     //   1865: fstore #11
/*     */     //   1867: getstatic JinRyuu/JRMCore/JRMCoreComTickH.width : F
/*     */     //   1870: fload #7
/*     */     //   1872: fmul
/*     */     //   1873: fload #8
/*     */     //   1875: fmul
/*     */     //   1876: fload #9
/*     */     //   1878: fmul
/*     */     //   1879: getstatic JinRyuu/JRMCore/JRMCoreCliTicH.yc : F
/*     */     //   1882: fmul
/*     */     //   1883: fstore #12
/*     */     //   1885: aload_1
/*     */     //   1886: fload #12
/*     */     //   1888: fload #11
/*     */     //   1890: invokestatic sS : (Lnet/minecraft/entity/player/EntityPlayer;FF)V
/*     */     //   1893: ldc_w 0.5
/*     */     //   1896: getstatic JinRyuu/JRMCore/JRMCoreCliTicH.yc : F
/*     */     //   1899: ldc_w 0.5
/*     */     //   1902: fsub
/*     */     //   1903: fsub
/*     */     //   1904: fconst_2
/*     */     //   1905: fmul
/*     */     //   1906: fstore #13
/*     */     //   1908: getstatic JinRyuu/JRMCore/JRMCoreCliTicH.yc : F
/*     */     //   1911: fstore #14
/*     */     //   1913: ldc_w 3.0
/*     */     //   1916: fload #14
/*     */     //   1918: fconst_2
/*     */     //   1919: fmul
/*     */     //   1920: fsub
/*     */     //   1921: fstore #14
/*     */     //   1923: getstatic JinRyuu/JRMCore/JRMCoreCliTicH.clientHght : F
/*     */     //   1926: ldc_w 0.9
/*     */     //   1929: fmul
/*     */     //   1930: ldc_w 1.54
/*     */     //   1933: fsub
/*     */     //   1934: putstatic JinRyuu/JRMCore/JRMCoreCliTicH.offsetY : F
/*     */     //   1937: bipush #10
/*     */     //   1939: istore #7
/*     */     //   1941: aload_1
/*     */     //   1942: getfield field_70165_t : D
/*     */     //   1945: iload #7
/*     */     //   1947: i2d
/*     */     //   1948: dsub
/*     */     //   1949: aload_1
/*     */     //   1950: getfield field_70163_u : D
/*     */     //   1953: iload #7
/*     */     //   1955: i2d
/*     */     //   1956: dsub
/*     */     //   1957: aload_1
/*     */     //   1958: getfield field_70161_v : D
/*     */     //   1961: iload #7
/*     */     //   1963: i2d
/*     */     //   1964: dsub
/*     */     //   1965: aload_1
/*     */     //   1966: getfield field_70165_t : D
/*     */     //   1969: iload #7
/*     */     //   1971: i2d
/*     */     //   1972: dadd
/*     */     //   1973: aload_1
/*     */     //   1974: getfield field_70163_u : D
/*     */     //   1977: iload #7
/*     */     //   1979: i2d
/*     */     //   1980: dadd
/*     */     //   1981: aload_1
/*     */     //   1982: getfield field_70161_v : D
/*     */     //   1985: iload #7
/*     */     //   1987: i2d
/*     */     //   1988: dadd
/*     */     //   1989: invokestatic func_72330_a : (DDDDDD)Lnet/minecraft/util/AxisAlignedBB;
/*     */     //   1992: astore #8
/*     */     //   1994: aload_0
/*     */     //   1995: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   1998: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*     */     //   2001: getfield field_70170_p : Lnet/minecraft/world/World;
/*     */     //   2004: ldc net/minecraft/entity/player/EntityPlayer
/*     */     //   2006: aload #8
/*     */     //   2008: invokevirtual func_72872_a : (Ljava/lang/Class;Lnet/minecraft/util/AxisAlignedBB;)Ljava/util/List;
/*     */     //   2011: astore #9
/*     */     //   2013: iconst_0
/*     */     //   2014: istore #10
/*     */     //   2016: iload #10
/*     */     //   2018: aload #9
/*     */     //   2020: invokeinterface size : ()I
/*     */     //   2025: if_icmpge -> 2693
/*     */     //   2028: aload #9
/*     */     //   2030: iload #10
/*     */     //   2032: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   2037: checkcast net/minecraft/entity/player/EntityPlayer
/*     */     //   2040: astore #11
/*     */     //   2042: aload_1
/*     */     //   2043: invokevirtual func_70005_c_ : ()Ljava/lang/String;
/*     */     //   2046: aload #11
/*     */     //   2048: invokevirtual func_70005_c_ : ()Ljava/lang/String;
/*     */     //   2051: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   2054: ifne -> 2687
/*     */     //   2057: aload #11
/*     */     //   2059: invokevirtual func_70005_c_ : ()Ljava/lang/String;
/*     */     //   2062: iconst_1
/*     */     //   2063: ldc_w '0;0;0;0;0;0'
/*     */     //   2066: invokestatic data : (Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String;
/*     */     //   2069: ldc_w ';'
/*     */     //   2072: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
/*     */     //   2075: astore #12
/*     */     //   2077: aload #11
/*     */     //   2079: invokevirtual func_70005_c_ : ()Ljava/lang/String;
/*     */     //   2082: iconst_2
/*     */     //   2083: ldc_w '0;0'
/*     */     //   2086: invokestatic data : (Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String;
/*     */     //   2089: ldc_w ';'
/*     */     //   2092: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
/*     */     //   2095: astore #13
/*     */     //   2097: aload #13
/*     */     //   2099: iconst_0
/*     */     //   2100: aaload
/*     */     //   2101: invokestatic parseInt : (Ljava/lang/String;)I
/*     */     //   2104: istore #14
/*     */     //   2106: aload #11
/*     */     //   2108: invokevirtual func_70005_c_ : ()Ljava/lang/String;
/*     */     //   2111: bipush #14
/*     */     //   2113: ldc_w '0,0,0,0,0,0'
/*     */     //   2116: invokestatic data : (Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String;
/*     */     //   2119: ldc_w ','
/*     */     //   2122: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
/*     */     //   2125: astore #15
/*     */     //   2127: aload #11
/*     */     //   2129: invokevirtual func_70005_c_ : ()Ljava/lang/String;
/*     */     //   2132: bipush #10
/*     */     //   2134: ldc_w '0;0'
/*     */     //   2137: invokestatic data : (Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String;
/*     */     //   2140: ldc_w ';'
/*     */     //   2143: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
/*     */     //   2146: iconst_0
/*     */     //   2147: aaload
/*     */     //   2148: invokestatic parseInt : (Ljava/lang/String;)I
/*     */     //   2151: istore #16
/*     */     //   2153: aload #12
/*     */     //   2155: iconst_0
/*     */     //   2156: aaload
/*     */     //   2157: invokestatic parseInt : (Ljava/lang/String;)I
/*     */     //   2160: istore #17
/*     */     //   2162: aload #15
/*     */     //   2164: arraylength
/*     */     //   2165: newarray int
/*     */     //   2167: astore #18
/*     */     //   2169: iconst_0
/*     */     //   2170: istore #19
/*     */     //   2172: iload #19
/*     */     //   2174: aload #18
/*     */     //   2176: arraylength
/*     */     //   2177: if_icmpge -> 2199
/*     */     //   2180: aload #18
/*     */     //   2182: iload #19
/*     */     //   2184: aload #15
/*     */     //   2186: iload #19
/*     */     //   2188: aaload
/*     */     //   2189: invokestatic parseInt : (Ljava/lang/String;)I
/*     */     //   2192: iastore
/*     */     //   2193: iinc #19, 1
/*     */     //   2196: goto -> 2172
/*     */     //   2199: fconst_1
/*     */     //   2200: fstore #19
/*     */     //   2202: fconst_1
/*     */     //   2203: fstore #20
/*     */     //   2205: fconst_1
/*     */     //   2206: fstore #21
/*     */     //   2208: invokestatic DBC : ()Z
/*     */     //   2211: ifne -> 2218
/*     */     //   2214: iconst_1
/*     */     //   2215: goto -> 2219
/*     */     //   2218: iconst_0
/*     */     //   2219: istore #22
/*     */     //   2221: aload #12
/*     */     //   2223: iconst_1
/*     */     //   2224: aaload
/*     */     //   2225: invokestatic dnsGender : (Ljava/lang/String;)I
/*     */     //   2228: iconst_1
/*     */     //   2229: if_icmpgt -> 2250
/*     */     //   2232: ldc_w 0.73
/*     */     //   2235: iload #22
/*     */     //   2237: ifeq -> 2246
/*     */     //   2240: ldc_w 0.27
/*     */     //   2243: goto -> 2247
/*     */     //   2246: fconst_0
/*     */     //   2247: fadd
/*     */     //   2248: fstore #19
/*     */     //   2250: aload #12
/*     */     //   2252: iconst_1
/*     */     //   2253: aaload
/*     */     //   2254: invokestatic dnsGender : (Ljava/lang/String;)I
/*     */     //   2257: iconst_2
/*     */     //   2258: if_icmplt -> 2279
/*     */     //   2261: ldc_w 0.7
/*     */     //   2264: iload #22
/*     */     //   2266: ifeq -> 2275
/*     */     //   2269: ldc_w 0.27
/*     */     //   2272: goto -> 2276
/*     */     //   2275: fconst_0
/*     */     //   2276: fadd
/*     */     //   2277: fstore #19
/*     */     //   2279: fconst_1
/*     */     //   2280: fstore #23
/*     */     //   2282: invokestatic JYC : ()Z
/*     */     //   2285: ifeq -> 2295
/*     */     //   2288: aload #11
/*     */     //   2290: invokestatic JYCsizeBasedOnAge : (Lnet/minecraft/entity/player/EntityPlayer;)F
/*     */     //   2293: fstore #23
/*     */     //   2295: invokestatic DBC : ()Z
/*     */     //   2298: ifeq -> 2532
/*     */     //   2301: aload #18
/*     */     //   2303: iconst_0
/*     */     //   2304: iaload
/*     */     //   2305: ifeq -> 2532
/*     */     //   2308: getstatic JinRyuu/JRMCore/JRMCoreConfig.sizes : Z
/*     */     //   2311: ifeq -> 2532
/*     */     //   2314: fload #19
/*     */     //   2316: fstore #24
/*     */     //   2318: fload #19
/*     */     //   2320: aload #18
/*     */     //   2322: invokestatic DBCsizeBasedOnCns : ([I)F
/*     */     //   2325: fadd
/*     */     //   2326: fstore #19
/*     */     //   2328: iload #17
/*     */     //   2330: iconst_3
/*     */     //   2331: if_icmpne -> 2344
/*     */     //   2334: bipush #17
/*     */     //   2336: aload #11
/*     */     //   2338: invokestatic StusEfctsClient : (ILnet/minecraft/entity/player/EntityPlayer;)Z
/*     */     //   2341: goto -> 2345
/*     */     //   2344: iconst_0
/*     */     //   2345: istore #25
/*     */     //   2347: iload #17
/*     */     //   2349: iload #14
/*     */     //   2351: iload #25
/*     */     //   2353: invokestatic DBCsizeBasedOnRace : (IIZ)F
/*     */     //   2356: fstore #20
/*     */     //   2358: iload #17
/*     */     //   2360: iload #14
/*     */     //   2362: iload #25
/*     */     //   2364: invokestatic DBCsizeBasedOnRace2 : (IIZ)F
/*     */     //   2367: fstore #21
/*     */     //   2369: iload #17
/*     */     //   2371: invokestatic rSai : (I)Z
/*     */     //   2374: ifeq -> 2399
/*     */     //   2377: iload #14
/*     */     //   2379: bipush #7
/*     */     //   2381: if_icmpeq -> 2391
/*     */     //   2384: iload #14
/*     */     //   2386: bipush #8
/*     */     //   2388: if_icmpne -> 2399
/*     */     //   2391: bipush #50
/*     */     //   2393: istore #16
/*     */     //   2395: fload #24
/*     */     //   2397: fstore #19
/*     */     //   2399: fload #21
/*     */     //   2401: fconst_1
/*     */     //   2402: fsub
/*     */     //   2403: iload #16
/*     */     //   2405: i2f
/*     */     //   2406: fmul
/*     */     //   2407: ldc_w 0.02
/*     */     //   2410: fmul
/*     */     //   2411: fconst_1
/*     */     //   2412: fadd
/*     */     //   2413: fstore #26
/*     */     //   2415: fload #26
/*     */     //   2417: fload #21
/*     */     //   2419: fcmpl
/*     */     //   2420: ifle -> 2428
/*     */     //   2423: fload #21
/*     */     //   2425: goto -> 2442
/*     */     //   2428: fload #21
/*     */     //   2430: fconst_1
/*     */     //   2431: fcmpl
/*     */     //   2432: ifle -> 2440
/*     */     //   2435: fload #26
/*     */     //   2437: goto -> 2442
/*     */     //   2440: fload #21
/*     */     //   2442: fstore #21
/*     */     //   2444: fload #20
/*     */     //   2446: fconst_1
/*     */     //   2447: fsub
/*     */     //   2448: iload #16
/*     */     //   2450: i2f
/*     */     //   2451: fmul
/*     */     //   2452: ldc_w 0.02
/*     */     //   2455: fmul
/*     */     //   2456: fconst_1
/*     */     //   2457: fadd
/*     */     //   2458: fstore #27
/*     */     //   2460: fload #20
/*     */     //   2462: fconst_1
/*     */     //   2463: fcmpl
/*     */     //   2464: ifle -> 2472
/*     */     //   2467: fload #27
/*     */     //   2469: goto -> 2474
/*     */     //   2472: fload #20
/*     */     //   2474: fstore #20
/*     */     //   2476: fload #19
/*     */     //   2478: fload #24
/*     */     //   2480: fsub
/*     */     //   2481: iload #16
/*     */     //   2483: bipush #50
/*     */     //   2485: if_icmpgt -> 2494
/*     */     //   2488: ldc_w 0.25
/*     */     //   2491: goto -> 2497
/*     */     //   2494: ldc_w 0.5
/*     */     //   2497: fmul
/*     */     //   2498: fstore #28
/*     */     //   2500: fload #28
/*     */     //   2502: iload #16
/*     */     //   2504: i2f
/*     */     //   2505: fmul
/*     */     //   2506: ldc_w 0.02
/*     */     //   2509: fmul
/*     */     //   2510: fstore #29
/*     */     //   2512: fload #19
/*     */     //   2514: fload #24
/*     */     //   2516: fsub
/*     */     //   2517: fload #28
/*     */     //   2519: fsub
/*     */     //   2520: fload #29
/*     */     //   2522: fadd
/*     */     //   2523: fload #24
/*     */     //   2525: fadd
/*     */     //   2526: fstore #30
/*     */     //   2528: fload #30
/*     */     //   2530: fstore #19
/*     */     //   2532: aload #12
/*     */     //   2534: iconst_1
/*     */     //   2535: aaload
/*     */     //   2536: invokevirtual length : ()I
/*     */     //   2539: iconst_3
/*     */     //   2540: if_icmpge -> 2557
/*     */     //   2543: ldc_w 0.9375
/*     */     //   2546: fstore #19
/*     */     //   2548: fconst_1
/*     */     //   2549: fstore #20
/*     */     //   2551: fconst_1
/*     */     //   2552: fstore #21
/*     */     //   2554: fconst_1
/*     */     //   2555: fstore #23
/*     */     //   2557: aload #11
/*     */     //   2559: invokevirtual func_70608_bn : ()Z
/*     */     //   2562: ifne -> 2687
/*     */     //   2565: iconst_1
/*     */     //   2566: istore #24
/*     */     //   2568: invokestatic JBRA : ()Z
/*     */     //   2571: ifeq -> 2653
/*     */     //   2574: getstatic JinRyuu/JRMCore/JRMCoreComTickH.height : F
/*     */     //   2577: fload #19
/*     */     //   2579: fmul
/*     */     //   2580: fload #21
/*     */     //   2582: fmul
/*     */     //   2583: fload #23
/*     */     //   2585: fmul
/*     */     //   2586: fstore #25
/*     */     //   2588: fload #25
/*     */     //   2590: fstore #26
/*     */     //   2592: getstatic JinRyuu/JRMCore/JRMCoreComTickH.width : F
/*     */     //   2595: fload #19
/*     */     //   2597: fmul
/*     */     //   2598: fload #20
/*     */     //   2600: fmul
/*     */     //   2601: fload #21
/*     */     //   2603: fmul
/*     */     //   2604: fload #23
/*     */     //   2606: fmul
/*     */     //   2607: fstore #27
/*     */     //   2609: aload #6
/*     */     //   2611: arraylength
/*     */     //   2612: iconst_3
/*     */     //   2613: if_icmpne -> 2644
/*     */     //   2616: aload #6
/*     */     //   2618: iconst_1
/*     */     //   2619: aaload
/*     */     //   2620: aload #11
/*     */     //   2622: invokevirtual func_70005_c_ : ()Ljava/lang/String;
/*     */     //   2625: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
/*     */     //   2628: ifeq -> 2644
/*     */     //   2631: aload #11
/*     */     //   2633: fconst_0
/*     */     //   2634: fconst_0
/*     */     //   2635: invokestatic sS : (Lnet/minecraft/entity/player/EntityPlayer;FF)V
/*     */     //   2638: iconst_0
/*     */     //   2639: istore #24
/*     */     //   2641: goto -> 2653
/*     */     //   2644: aload #11
/*     */     //   2646: fload #27
/*     */     //   2648: fload #26
/*     */     //   2650: invokestatic sS : (Lnet/minecraft/entity/player/EntityPlayer;FF)V
/*     */     //   2653: iload #24
/*     */     //   2655: ifeq -> 2687
/*     */     //   2658: aload #6
/*     */     //   2660: arraylength
/*     */     //   2661: iconst_3
/*     */     //   2662: if_icmpne -> 2687
/*     */     //   2665: aload #6
/*     */     //   2667: iconst_1
/*     */     //   2668: aaload
/*     */     //   2669: aload #11
/*     */     //   2671: invokevirtual func_70005_c_ : ()Ljava/lang/String;
/*     */     //   2674: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
/*     */     //   2677: ifeq -> 2687
/*     */     //   2680: aload #11
/*     */     //   2682: fconst_0
/*     */     //   2683: fconst_0
/*     */     //   2684: invokestatic sS : (Lnet/minecraft/entity/player/EntityPlayer;FF)V
/*     */     //   2687: iinc #10, 1
/*     */     //   2690: goto -> 2016
/*     */     //   2693: bipush #9
/*     */     //   2695: invokestatic StusEfctsMe : (I)Z
/*     */     //   2698: ifeq -> 2708
/*     */     //   2701: iconst_4
/*     */     //   2702: invokestatic StusEfctsMe : (I)Z
/*     */     //   2705: ifeq -> 2720
/*     */     //   2708: invokestatic DBC : ()Z
/*     */     //   2711: ifeq -> 2724
/*     */     //   2714: invokestatic DBCKiTechFly : ()Z
/*     */     //   2717: ifeq -> 2724
/*     */     //   2720: iconst_1
/*     */     //   2721: goto -> 2725
/*     */     //   2724: iconst_0
/*     */     //   2725: istore #10
/*     */     //   2727: aload_1
/*     */     //   2728: getfield field_70159_w : D
/*     */     //   2731: dconst_0
/*     */     //   2732: dcmpg
/*     */     //   2733: ifge -> 2747
/*     */     //   2736: aload_1
/*     */     //   2737: getfield field_70159_w : D
/*     */     //   2740: ldc2_w -1.0
/*     */     //   2743: dmul
/*     */     //   2744: goto -> 2751
/*     */     //   2747: aload_1
/*     */     //   2748: getfield field_70159_w : D
/*     */     //   2751: ldc2_w 0.2
/*     */     //   2754: dcmpl
/*     */     //   2755: ifgt -> 2796
/*     */     //   2758: aload_1
/*     */     //   2759: getfield field_70179_y : D
/*     */     //   2762: dconst_0
/*     */     //   2763: dcmpg
/*     */     //   2764: ifge -> 2778
/*     */     //   2767: aload_1
/*     */     //   2768: getfield field_70179_y : D
/*     */     //   2771: ldc2_w -1.0
/*     */     //   2774: dmul
/*     */     //   2775: goto -> 2782
/*     */     //   2778: aload_1
/*     */     //   2779: getfield field_70179_y : D
/*     */     //   2782: ldc2_w 0.2
/*     */     //   2785: dcmpl
/*     */     //   2786: ifle -> 2820
/*     */     //   2789: aload_1
/*     */     //   2790: invokestatic inAir : (Lnet/minecraft/entity/player/EntityPlayer;)Z
/*     */     //   2793: ifeq -> 2820
/*     */     //   2796: iload #10
/*     */     //   2798: ifeq -> 2820
/*     */     //   2801: aload_0
/*     */     //   2802: getfield stand : Z
/*     */     //   2805: ifeq -> 2836
/*     */     //   2808: aload_0
/*     */     //   2809: iconst_0
/*     */     //   2810: putfield stand : Z
/*     */     //   2813: iconst_1
/*     */     //   2814: invokestatic Anim : (I)V
/*     */     //   2817: goto -> 2836
/*     */     //   2820: aload_0
/*     */     //   2821: getfield stand : Z
/*     */     //   2824: ifne -> 2836
/*     */     //   2827: aload_0
/*     */     //   2828: iconst_1
/*     */     //   2829: putfield stand : Z
/*     */     //   2832: iconst_2
/*     */     //   2833: invokestatic Anim : (I)V
/*     */     //   2836: aload_0
/*     */     //   2837: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   2840: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*     */     //   2843: ifnull -> 2930
/*     */     //   2846: aload_0
/*     */     //   2847: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   2850: getfield field_71441_e : Lnet/minecraft/client/multiplayer/WorldClient;
/*     */     //   2853: ifnull -> 2930
/*     */     //   2856: getstatic JinRyuu/JRMCore/JRMCoreCliTicH.fnPressed : I
/*     */     //   2859: ifle -> 2901
/*     */     //   2862: aload_0
/*     */     //   2863: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   2866: getfield field_71462_r : Lnet/minecraft/client/gui/GuiScreen;
/*     */     //   2869: instanceof net/minecraft/client/gui/inventory/GuiInventory
/*     */     //   2872: ifne -> 2888
/*     */     //   2875: aload_0
/*     */     //   2876: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   2879: getfield field_71462_r : Lnet/minecraft/client/gui/GuiScreen;
/*     */     //   2882: instanceof net/minecraft/client/gui/inventory/GuiContainerCreative
/*     */     //   2885: ifeq -> 2901
/*     */     //   2888: new JinRyuu/JRMCore/p/OpenGuiMessage
/*     */     //   2891: dup
/*     */     //   2892: getstatic JinRyuu/JRMCore/mod_JRMCore.GUI_CUSTOM_INV : I
/*     */     //   2895: invokespecial <init> : (I)V
/*     */     //   2898: invokestatic sendToServer : (Lcpw/mods/fml/common/network/simpleimpl/IMessage;)V
/*     */     //   2901: getstatic JinRyuu/JRMCore/JRMCoreKeyHandler.Fn : Lnet/minecraft/client/settings/KeyBinding;
/*     */     //   2904: invokevirtual func_151470_d : ()Z
/*     */     //   2907: ifeq -> 2918
/*     */     //   2910: bipush #10
/*     */     //   2912: putstatic JinRyuu/JRMCore/JRMCoreCliTicH.fnPressed : I
/*     */     //   2915: goto -> 2926
/*     */     //   2918: getstatic JinRyuu/JRMCore/JRMCoreCliTicH.fnPressed : I
/*     */     //   2921: iconst_1
/*     */     //   2922: isub
/*     */     //   2923: putstatic JinRyuu/JRMCore/JRMCoreCliTicH.fnPressed : I
/*     */     //   2926: aload_0
/*     */     //   2927: invokevirtual updateMaxStats : ()V
/*     */     //   2930: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #360	-> 0
/*     */     //   #362	-> 6
/*     */     //   #363	-> 14
/*     */     //   #364	-> 20
/*     */     //   #365	-> 28
/*     */     //   #370	-> 34
/*     */     //   #371	-> 42
/*     */     //   #372	-> 50
/*     */     //   #376	-> 58
/*     */     //   #377	-> 72
/*     */     //   #378	-> 94
/*     */     //   #379	-> 108
/*     */     //   #380	-> 130
/*     */     //   #381	-> 144
/*     */     //   #384	-> 166
/*     */     //   #385	-> 177
/*     */     //   #386	-> 186
/*     */     //   #387	-> 192
/*     */     //   #388	-> 198
/*     */     //   #390	-> 202
/*     */     //   #391	-> 211
/*     */     //   #393	-> 219
/*     */     //   #394	-> 229
/*     */     //   #395	-> 259
/*     */     //   #396	-> 274
/*     */     //   #397	-> 289
/*     */     //   #398	-> 298
/*     */     //   #399	-> 310
/*     */     //   #401	-> 322
/*     */     //   #403	-> 325
/*     */     //   #404	-> 346
/*     */     //   #405	-> 358
/*     */     //   #406	-> 372
/*     */     //   #409	-> 390
/*     */     //   #410	-> 399
/*     */     //   #411	-> 430
/*     */     //   #412	-> 446
/*     */     //   #413	-> 458
/*     */     //   #414	-> 491
/*     */     //   #415	-> 494
/*     */     //   #416	-> 510
/*     */     //   #417	-> 515
/*     */     //   #418	-> 534
/*     */     //   #420	-> 579
/*     */     //   #421	-> 590
/*     */     //   #422	-> 601
/*     */     //   #423	-> 612
/*     */     //   #427	-> 623
/*     */     //   #428	-> 629
/*     */     //   #429	-> 655
/*     */     //   #430	-> 669
/*     */     //   #431	-> 676
/*     */     //   #434	-> 695
/*     */     //   #436	-> 722
/*     */     //   #437	-> 729
/*     */     //   #438	-> 750
/*     */     //   #440	-> 804
/*     */     //   #441	-> 819
/*     */     //   #444	-> 836
/*     */     //   #445	-> 888
/*     */     //   #447	-> 913
/*     */     //   #448	-> 950
/*     */     //   #451	-> 970
/*     */     //   #452	-> 986
/*     */     //   #455	-> 1010
/*     */     //   #456	-> 1020
/*     */     //   #457	-> 1028
/*     */     //   #458	-> 1056
/*     */     //   #460	-> 1061
/*     */     //   #461	-> 1084
/*     */     //   #463	-> 1112
/*     */     //   #464	-> 1121
/*     */     //   #466	-> 1149
/*     */     //   #467	-> 1158
/*     */     //   #470	-> 1185
/*     */     //   #473	-> 1217
/*     */     //   #475	-> 1227
/*     */     //   #477	-> 1239
/*     */     //   #475	-> 1270
/*     */     //   #479	-> 1276
/*     */     //   #484	-> 1279
/*     */     //   #485	-> 1286
/*     */     //   #486	-> 1290
/*     */     //   #491	-> 1296
/*     */     //   #492	-> 1300
/*     */     //   #493	-> 1304
/*     */     //   #498	-> 1308
/*     */     //   #499	-> 1311
/*     */     //   #500	-> 1314
/*     */     //   #501	-> 1317
/*     */     //   #502	-> 1330
/*     */     //   #503	-> 1358
/*     */     //   #505	-> 1386
/*     */     //   #506	-> 1392
/*     */     //   #508	-> 1399
/*     */     //   #509	-> 1419
/*     */     //   #510	-> 1423
/*     */     //   #511	-> 1426
/*     */     //   #514	-> 1437
/*     */     //   #517	-> 1443
/*     */     //   #518	-> 1461
/*     */     //   #519	-> 1474
/*     */     //   #521	-> 1487
/*     */     //   #522	-> 1492
/*     */     //   #523	-> 1525
/*     */     //   #524	-> 1541
/*     */     //   #525	-> 1570
/*     */     //   #526	-> 1586
/*     */     //   #527	-> 1602
/*     */     //   #528	-> 1626
/*     */     //   #529	-> 1638
/*     */     //   #530	-> 1654
/*     */     //   #533	-> 1658
/*     */     //   #535	-> 1683
/*     */     //   #536	-> 1690
/*     */     //   #537	-> 1696
/*     */     //   #539	-> 1824
/*     */     //   #540	-> 1829
/*     */     //   #542	-> 1846
/*     */     //   #543	-> 1862
/*     */     //   #544	-> 1867
/*     */     //   #545	-> 1885
/*     */     //   #547	-> 1893
/*     */     //   #548	-> 1908
/*     */     //   #549	-> 1913
/*     */     //   #550	-> 1923
/*     */     //   #555	-> 1937
/*     */     //   #556	-> 1941
/*     */     //   #557	-> 1994
/*     */     //   #558	-> 2013
/*     */     //   #560	-> 2028
/*     */     //   #561	-> 2042
/*     */     //   #562	-> 2057
/*     */     //   #563	-> 2077
/*     */     //   #564	-> 2097
/*     */     //   #565	-> 2106
/*     */     //   #566	-> 2127
/*     */     //   #568	-> 2153
/*     */     //   #569	-> 2162
/*     */     //   #570	-> 2169
/*     */     //   #572	-> 2199
/*     */     //   #573	-> 2202
/*     */     //   #574	-> 2205
/*     */     //   #575	-> 2208
/*     */     //   #576	-> 2221
/*     */     //   #577	-> 2250
/*     */     //   #578	-> 2279
/*     */     //   #579	-> 2282
/*     */     //   #580	-> 2288
/*     */     //   #582	-> 2295
/*     */     //   #583	-> 2314
/*     */     //   #585	-> 2318
/*     */     //   #588	-> 2328
/*     */     //   #589	-> 2347
/*     */     //   #590	-> 2358
/*     */     //   #591	-> 2369
/*     */     //   #592	-> 2399
/*     */     //   #593	-> 2415
/*     */     //   #594	-> 2444
/*     */     //   #595	-> 2460
/*     */     //   #596	-> 2476
/*     */     //   #597	-> 2500
/*     */     //   #598	-> 2512
/*     */     //   #599	-> 2528
/*     */     //   #601	-> 2532
/*     */     //   #603	-> 2557
/*     */     //   #604	-> 2565
/*     */     //   #605	-> 2568
/*     */     //   #606	-> 2574
/*     */     //   #607	-> 2588
/*     */     //   #608	-> 2592
/*     */     //   #609	-> 2609
/*     */     //   #610	-> 2631
/*     */     //   #612	-> 2644
/*     */     //   #616	-> 2653
/*     */     //   #617	-> 2680
/*     */     //   #558	-> 2687
/*     */     //   #622	-> 2693
/*     */     //   #624	-> 2727
/*     */     //   #626	-> 2801
/*     */     //   #627	-> 2808
/*     */     //   #628	-> 2813
/*     */     //   #631	-> 2820
/*     */     //   #632	-> 2827
/*     */     //   #633	-> 2832
/*     */     //   #636	-> 2836
/*     */     //   #638	-> 2856
/*     */     //   #639	-> 2888
/*     */     //   #641	-> 2901
/*     */     //   #642	-> 2910
/*     */     //   #643	-> 2918
/*     */     //   #645	-> 2926
/*     */     //   #648	-> 2930
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   274	48	5	k	I
/*     */     //   289	33	6	v	J
/*     */     //   259	63	4	mapEntry	Ljava/util/Map$Entry;
/*     */     //   510	113	7	pl	Lnet/minecraft/entity/player/EntityPlayer;
/*     */     //   1230	46	7	i	I
/*     */     //   1461	26	12	divine	Z
/*     */     //   1423	235	11	f1r	F
/*     */     //   1492	166	12	rls	B
/*     */     //   1541	117	13	f3a	F
/*     */     //   1586	72	14	f2a	F
/*     */     //   1626	32	15	f1a1	F
/*     */     //   1638	20	16	f1ac	F
/*     */     //   1654	4	17	f1ao	F
/*     */     //   1829	17	11	d1	D
/*     */     //   1867	70	11	clientHght2	F
/*     */     //   1885	52	12	clientWdth2	F
/*     */     //   1908	29	13	transBody	F
/*     */     //   1913	24	14	f6	F
/*     */     //   1311	626	7	f1	F
/*     */     //   1314	623	8	f2	F
/*     */     //   1317	620	9	f3	F
/*     */     //   1330	607	10	noC	Z
/*     */     //   2172	27	19	i1	I
/*     */     //   2318	214	24	f1r	F
/*     */     //   2347	185	25	divine	Z
/*     */     //   2415	117	26	f3a	F
/*     */     //   2460	72	27	f2a	F
/*     */     //   2500	32	28	f1a1	F
/*     */     //   2512	20	29	f1ac	F
/*     */     //   2528	4	30	f1ao	F
/*     */     //   2588	65	25	clientHght	F
/*     */     //   2592	61	26	clientHght2	F
/*     */     //   2609	44	27	clientWdth2	F
/*     */     //   2568	119	24	DO	Z
/*     */     //   2077	610	12	s	[Ljava/lang/String;
/*     */     //   2097	590	13	s2	[Ljava/lang/String;
/*     */     //   2106	581	14	state	I
/*     */     //   2127	560	15	s14	[Ljava/lang/String;
/*     */     //   2153	534	16	rls	I
/*     */     //   2162	525	17	race	I
/*     */     //   2169	518	18	PlyrAttrbts	[I
/*     */     //   2202	485	19	f1	F
/*     */     //   2205	482	20	f2	F
/*     */     //   2208	479	21	f3	F
/*     */     //   2221	466	22	noC	Z
/*     */     //   2282	405	23	yc	F
/*     */     //   2042	645	11	plyr1	Lnet/minecraft/entity/player/EntityPlayer;
/*     */     //   2016	677	10	i	I
/*     */     //   399	2531	3	w	F
/*     */     //   430	2500	4	b	Z
/*     */     //   446	2484	5	d18	[Ljava/lang/String;
/*     */     //   458	2472	6	fuse	[Ljava/lang/String;
/*     */     //   1941	989	7	r	I
/*     */     //   1994	936	8	ab	Lnet/minecraft/util/AxisAlignedBB;
/*     */     //   2013	917	9	list	Ljava/util/List;
/*     */     //   2727	203	10	fly	Z
/*     */     //   0	2931	0	this	LJinRyuu/JRMCore/JRMCoreCliTicH;
/*     */     //   14	2917	1	plyr	Lnet/minecraft/entity/player/EntityPlayer;
/*     */     //   229	2702	2	tapped	Ljava/util/HashMap;
/*     */     // Local variable type table:
/*     */     //   start	length	slot	name	signature
/*     */     //   259	63	4	mapEntry	Ljava/util/Map$Entry<Ljava/lang/Integer;Ljava/lang/Long;>;
/*     */     //   229	2702	2	tapped	Ljava/util/HashMap<Ljava/lang/Integer;Ljava/lang/Long;>;
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
/*     */ 
/*     */   
/*     */   public void onPreRenderTick() {}
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
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onTick(TickEvent.ClientTickEvent event) {
/* 656 */     JRMCoreH.mld();
/*     */     
/* 658 */     if (event.phase.equals(TickEvent.Phase.START)) {
/*     */       
/* 660 */       JRMCoreH.paused = this.mc.func_147113_T();
/*     */       
/* 662 */       if (!JRMCoreH.paused) {
/*     */ 
/*     */         
/* 665 */         onTickInGUI();
/* 666 */         onTickInGame();
/*     */       } 
/*     */     } 
/*     */     
/* 670 */     if (event.phase.equals(TickEvent.Phase.END));
/*     */   }
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onRenderTick(TickEvent.RenderTickEvent event) {
/* 676 */     if (event.phase == TickEvent.Phase.END)
/* 677 */       onRenderTick(); 
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onKeyInputEvent(InputEvent.KeyInputEvent event) {
/* 682 */     onInputEvent(event);
/*     */   }
/* 684 */   private byte b(int n) { return (byte)n; }
/* 685 */   private byte b(String n) { return Byte.parseByte(n); } private int i(String n) {
/* 686 */     return Integer.parseInt(n);
/*     */   }
/*     */   
/* 689 */   public static ArrayList<JGNotification> notificationPings = new ArrayList<JGNotification>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Instant updateClient;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Instant updateTimer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void NotificationHandler() {
/* 710 */     int size = notificationPings.size();
/*     */     
/* 712 */     if (this.mc.field_71439_g != null && size > 0) {
/*     */       
/* 714 */       ResourceLocation txx = new ResourceLocation(JRMCoreH.tjjrmc + ":notification.png");
/* 715 */       ResourceLocation txx2 = new ResourceLocation(JRMCoreH.tjjrmc + ":note_category_icons.png");
/* 716 */       FontRenderer fontRenderer = this.mc.field_71466_p;
/*     */       
/* 718 */       int[] xx = { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, yy = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
/* 719 */       Instant now = Instant.now();
/*     */       
/* 721 */       for (int i = size - 1; i >= 0; i--) {
/*     */         
/* 723 */         JGNotification note = notificationPings.get(i);
/* 724 */         if (note == null) {
/*     */           
/* 726 */           notificationPings.remove(i);
/*     */         }
/*     */         else {
/*     */           
/* 730 */           Duration dur = Duration.between(note.received, now);
/* 731 */           int value = (int)((float)dur.toMillis() / 10.0F);
/* 732 */           float alpha = 1.0F;
/*     */           
/* 734 */           if (value >= 500) {
/*     */             
/* 736 */             notificationPings.remove(i);
/*     */           } else {
/*     */             
/* 739 */             if (value >= 490)
/*     */             {
/* 741 */               alpha = 1.0F - (value - 490.0F) / 10.0F;
/*     */             }
/*     */             
/* 744 */             int renderLocation = (note.renderLocation > xx.length - 1) ? (xx.length - 1) : note.renderLocation;
/*     */             
/* 746 */             yy[renderLocation] = yy[renderLocation] + ((value > 21) ? 21 : value);
/*     */             
/* 748 */             ScaledResolution scaledresolution = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
/* 749 */             int sw = scaledresolution.func_78326_a();
/* 750 */             int sh = scaledresolution.func_78328_b();
/* 751 */             int x = 0, y = 0;
/*     */ 
/*     */             
/* 754 */             if (renderLocation == 0) {
/*     */               
/* 756 */               x = sw - 116 + xx[renderLocation];
/* 757 */               y = yy[renderLocation] - 21;
/*     */             
/*     */             }
/* 760 */             else if (renderLocation == 1) {
/*     */               
/* 762 */               x = sw / 2 - 58 + xx[renderLocation];
/* 763 */               y = yy[renderLocation] - 21;
/*     */             
/*     */             }
/* 766 */             else if (renderLocation == 2) {
/*     */               
/* 768 */               x = xx[renderLocation];
/* 769 */               y = yy[renderLocation] - 21;
/*     */             
/*     */             }
/* 772 */             else if (renderLocation == 3) {
/*     */               
/* 774 */               x = sw - 116 + xx[renderLocation];
/* 775 */               y = sh / 2 + 21 + yy[renderLocation] - 21;
/*     */             
/*     */             }
/* 778 */             else if (renderLocation == 4) {
/*     */               
/* 780 */               x = sw / 2 - 58 + xx[renderLocation];
/* 781 */               y = sh / 2 + 21 + yy[renderLocation] - 21;
/*     */             
/*     */             }
/* 784 */             else if (renderLocation == 5) {
/*     */               
/* 786 */               x = xx[renderLocation];
/* 787 */               y = sh / 2 + 21 + yy[renderLocation] - 21;
/*     */             
/*     */             }
/* 790 */             else if (renderLocation == 6) {
/*     */               
/* 792 */               x = sw - 116 + xx[renderLocation];
/* 793 */               y = sh - yy[renderLocation];
/*     */             
/*     */             }
/* 796 */             else if (renderLocation == 7) {
/*     */               
/* 798 */               x = sw / 2 - 58 + xx[renderLocation];
/* 799 */               y = sh - yy[renderLocation];
/*     */             
/*     */             }
/* 802 */             else if (renderLocation == 8) {
/*     */               
/* 804 */               x = xx[renderLocation];
/* 805 */               y = sh - yy[renderLocation];
/*     */             } 
/*     */             
/* 808 */             this.mc.func_110434_K().func_110577_a(txx);
/* 809 */             int icon = note.icon;
/* 810 */             int idY = note.icon * 16 / 256;
/* 811 */             int idX = note.icon * 16 - idY * 256;
/* 812 */             idY *= 16;
/*     */             
/* 814 */             GL11.glPushMatrix();
/* 815 */             GL11.glEnable(3042);
/* 816 */             GL11.glBlendFunc(770, 771);
/* 817 */             GL11.glColor4f(1.0F, 1.0F, 1.0F, alpha);
/*     */ 
/*     */             
/* 820 */             drawTexturedModalRect(x, y, 0, 0, 116, 21);
/*     */             
/* 822 */             this.mc.func_110434_K().func_110577_a(txx2);
/*     */             
/* 824 */             JGNotificationGUI.color(note.iconColor, alpha);
/* 825 */             drawTexturedModalRect(x + 3, y + 2, idX, idY, 16, 16);
/*     */             
/* 827 */             GL11.glColor4f(1.0F, 1.0F, 1.0F, alpha);
/* 828 */             String text = JRMCoreGuiScreen.getStringShortened(fontRenderer, 94, note.title);
/* 829 */             JRMCoreGuiScreen.drawStringWithBorder(fontRenderer, text, x + 20, y + 5, 16777215);
/*     */             
/* 831 */             GL11.glDisable(3042);
/* 832 */             GL11.glPopMatrix();
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void drawTexturedModalRect(int x, int y, int u, int v, int w, int h) {
/* 840 */     float zLevel = 0.0F;
/* 841 */     float f = 0.00390625F;
/* 842 */     float f1 = 0.00390625F;
/* 843 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 844 */     tessellator.func_78382_b();
/* 845 */     tessellator.func_78374_a((x + 0), (y + h), zLevel, ((u + 0) * f), ((v + h) * f1));
/* 846 */     tessellator.func_78374_a((x + w), (y + h), zLevel, ((u + w) * f), ((v + h) * f1));
/* 847 */     tessellator.func_78374_a((x + w), (y + 0), zLevel, ((u + w) * f), ((v + 0) * f1));
/* 848 */     tessellator.func_78374_a((x + 0), (y + 0), zLevel, ((u + 0) * f), ((v + 0) * f1));
/* 849 */     tessellator.func_78381_a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateMaxStats() {
/* 857 */     if (this.updateClient == null || Duration.between(this.updateClient, Instant.now()).toMillis() >= 1000L) {
/*     */       
/* 859 */       this.updateClient = Instant.now();
/*     */       
/* 861 */       EntityClientPlayerMP entityClientPlayerMP = JRMCoreClient.mc.field_71439_g;
/*     */       
/* 863 */       byte pwr = JRMCoreH.Pwrtyp;
/* 864 */       byte rce = JRMCoreH.Race;
/* 865 */       byte cls = JRMCoreH.Class;
/*     */       
/* 867 */       JRMCoreH.maxBody = JRMCoreH.stat((Entity)entityClientPlayerMP, 2, pwr, 2, JRMCoreH.PlyrAttrbts[2], rce, cls, 0.0F);
/* 868 */       JRMCoreH.maxEnergy = JRMCoreH.stat((Entity)entityClientPlayerMP, 5, pwr, 5, JRMCoreH.PlyrAttrbts[5], rce, cls, JRMCoreH.SklLvl_KiBs(pwr));
/* 869 */       JRMCoreH.maxStamina = JRMCoreH.stat((Entity)entityClientPlayerMP, 2, pwr, 3, JRMCoreH.PlyrAttrbts[2], rce, cls, 0.0F);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateReleaseLevel() {
/* 877 */     if (JRMCoreH.Pwrtyp == 1 || JRMCoreH.Pwrtyp == 2) {
/*     */       
/* 879 */       if (JRMCoreHC.smoothReleaseLevel != JRMCoreH.curRelease) {
/*     */         
/* 881 */         float diff = 1.0F;
/* 882 */         if (this.updateTimer == null) { this.updateTimer = Instant.now(); }
/*     */         else
/*     */         
/* 885 */         { diff = (float)Duration.between(this.updateTimer, Instant.now()).toMillis() / 1000.0F;
/*     */           
/* 887 */           if (JGMathHelper.doubleSmallerThan((JRMCoreHC.smoothReleaseLevel - JRMCoreH.curRelease), 2.0D)) {
/*     */             
/* 889 */             JRMCoreHC.smoothReleaseLevel = JRMCoreH.curRelease;
/*     */           }
/*     */           else {
/*     */             
/* 893 */             boolean smaller = (JRMCoreHC.smoothReleaseLevel < JRMCoreH.curRelease);
/* 894 */             float add = (JRMCoreH.curRelease - JRMCoreHC.smoothReleaseLevel) / 20.0F * (diff + 1.0F);
/* 895 */             JRMCoreHC.smoothReleaseLevel += add;
/* 896 */             if (smaller)
/*     */             
/* 898 */             { if (JRMCoreHC.smoothReleaseLevel > JRMCoreH.curRelease) JRMCoreHC.smoothReleaseLevel = JRMCoreH.curRelease;
/*     */                }
/* 900 */             else if (JRMCoreHC.smoothReleaseLevel < JRMCoreH.curRelease) { JRMCoreHC.smoothReleaseLevel = JRMCoreH.curRelease; }
/*     */           
/* 902 */           }  this.updateTimer = Instant.now(); }
/*     */ 
/*     */       
/* 905 */       } else if (this.updateTimer != null) {
/*     */         
/* 907 */         this.updateTimer = null;
/*     */       }
/*     */     
/* 910 */     } else if (JRMCoreHC.smoothReleaseLevel != JRMCoreH.curRelease) {
/*     */       
/* 912 */       JRMCoreHC.smoothReleaseLevel = JRMCoreH.curRelease;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCoreCliTicH.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */