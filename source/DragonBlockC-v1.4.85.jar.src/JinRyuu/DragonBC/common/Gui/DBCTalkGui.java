/*      */ package JinRyuu.DragonBC.common.Gui;
/*      */ import JinRyuu.DragonBC.common.DBCConfig;
/*      */ import JinRyuu.DragonBC.common.DBCKiAttacks;
/*      */ import JinRyuu.DragonBC.common.Items.ItemsDBC;
/*      */ import JinRyuu.DragonBC.common.Npcs.EntityDBCKami;
/*      */ import JinRyuu.JRMCore.JRMCoreGuiButtons00MS;
/*      */ import JinRyuu.JRMCore.JRMCoreGuiButtons01;
/*      */ import JinRyuu.JRMCore.JRMCoreH;
/*      */ import JinRyuu.JRMCore.JRMCoreHDBC;
/*      */ import JinRyuu.JRMCore.p.DBC.DBCPwish;
/*      */ import JinRyuu.JRMCore.p.PD;
/*      */ import JinRyuu.JRMCore.server.config.dbc.JGConfigUltraInstinct;
/*      */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import net.minecraft.client.Minecraft;
/*      */ import net.minecraft.client.gui.FontRenderer;
/*      */ import net.minecraft.client.gui.GuiButton;
/*      */ import net.minecraft.client.gui.GuiTextField;
/*      */ import net.minecraft.client.gui.ScaledResolution;
/*      */ import net.minecraft.client.renderer.RenderHelper;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.util.AxisAlignedBB;
/*      */ import net.minecraft.util.ResourceLocation;
/*      */ import net.minecraft.util.StatCollector;
/*      */ import net.minecraft.world.World;
/*      */ import org.lwjgl.opengl.GL11;
/*      */ 
/*      */ public class DBCTalkGui extends GuiScreen {
/*      */   public static final int ENMA = 10;
/*      */   public static final int ENMA_REINCARNATE = 1001;
/*      */   public static final int KAMI = 11;
/*      */   public static final int KAMI_STARTANEW = 1101;
/*      */   public static final int KAMI_CUTTAIL = 1102;
/*      */   public static final int KAMI_REGROWTAIL = 1104;
/*      */   public static final int KAMI_WEIGHT = 1105;
/*      */   public static final int KAMI_SKILLS = 111;
/*      */   public static final int JIN = 9000;
/*      */   public static final int JIN_SKILLS = 9100;
/*      */   public static final int GURU = 9001;
/*      */   public static final int GURU_SKILLS = 9101;
/*      */   public static final int WHIS = 9002;
/*      */   public static final int WHIS_SKILLS = 9102;
/*      */   public static final int KAIO = 12;
/*      */   public static final int KAIO_SKILLS = 112;
/*      */   public static final int KAIO_ATTACKS = 1121;
/*      */   public static final int KAIO_DIFFICULTY = 221;
/*      */   public static final int KARIN = 13;
/*      */   public static final int KARIN_SKILLS = 113;
/*      */   public static final int ROSHI = 15;
/*      */   public static final int ROSHI_SKILLS = 115;
/*      */   public static final int ROSHI_ATTACKS = 1151;
/*   53 */   private Minecraft mc = JRMCoreClient.mc; public static final int CELL = 16; public static final int CELL_SKILLS = 116; public static final int CELL_ATTACKS = 1161; public static final int GOKU = 17; public static final int GOKU_SKILLS = 117; public static final int GOKU_ATTACKS = 1171; public static final int FRIEZA = 18; public static final int FRIEZA_SKILLS = 118; public static final int FRIEZA_ATTACKS = 1181; public static final int BABIDI = 19; public static final int BABIDI_SKILLS = 119; public static final int BABIDI_ATTACKS = 1191; public static final int PICCOLO = 20; public static final int PICCOLO_SKILLS = 120; public static final int PICCOLO_ATTACKS = 1201; public static final int VEGETA = 21; public static final int VEGETA_SKILLS = 121; public static final int VEGETA_ATTACKS = 1211; public static final int GOHAN = 22; public static final int GOHAN_SKILLS = 122; public static final int GOHAN_ATTACKS = 1221; public static final int TRUNKS = 23; public static final int TRUNKS_SKILLS = 123; public static final int TRUNKS_ATTACKS = 1231;
/*   54 */   private FontRenderer fontRenderer = this.mc.field_71466_p;
/*      */   
/*      */   private int tick;
/*      */   private GuiIngame Guiingame;
/*      */   
/*      */   public void renderSuperProtect(int ki) {
/*   60 */     this.field_146292_n.clear();
/*   61 */     int posX = this.field_146294_l / 2;
/*   62 */     int posY = this.field_146295_m / 2;
/*   63 */     this.field_146292_n.add(new DBCGuiButtons01(100, posX - 0, posY - 0, 20, 20, "TEST"));
/*      */   }
/*      */   
/*   66 */   private int wish = 0;
/*   67 */   private int ipg = 0;
/*   68 */   private int lp = 0;
/*   69 */   private int master = 0;
/*      */   private HashMap<String, String> MsnSysTalkTo;
/*   71 */   private String CurMaster = "";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String name;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int text;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected GuiTextField inputField;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String defaultInputFieldText;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int updateTimer;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int updateTime;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean updateTimerStopper;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_73866_w_() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_146284_a(GuiButton button) {
/*  124 */     if (button.field_146127_k == -1) {
/*  125 */       this.mc.field_71439_g.func_71053_j();
/*      */     }
/*  127 */     if (button.field_146127_k == 0) {
/*  128 */       dbcWish(button.field_146127_k);
/*  129 */       this.mc.field_71439_g.func_71053_j();
/*      */     } 
/*  131 */     if (button.field_146127_k == 1) {
/*  132 */       dbcWish(button.field_146127_k);
/*  133 */       this.mc.field_71439_g.func_71053_j();
/*      */     } 
/*  135 */     if (button.field_146127_k == 2) {
/*  136 */       dbcWish(button.field_146127_k);
/*  137 */       this.mc.field_71439_g.func_71053_j();
/*      */     } 
/*  139 */     if (button.field_146127_k == 3) {
/*  140 */       dbcWish(button.field_146127_k);
/*  141 */       this.mc.field_71439_g.func_71053_j();
/*      */     } 
/*  143 */     if (button.field_146127_k == 4) {
/*  144 */       dbcWish(button.field_146127_k);
/*  145 */       this.mc.field_71439_g.func_71053_j();
/*      */     } 
/*      */     
/*  148 */     if (button.field_146127_k == 10) {
/*  149 */       dbcWish(button.field_146127_k);
/*  150 */       this.mc.field_71439_g.func_71053_j();
/*      */     } 
/*  152 */     if (button.field_146127_k == 11) {
/*  153 */       dbcWish(button.field_146127_k);
/*  154 */       this.mc.field_71439_g.func_71053_j();
/*      */     } 
/*  156 */     if (button.field_146127_k == 12) {
/*  157 */       dbcWish(button.field_146127_k);
/*  158 */       this.mc.field_71439_g.func_71053_j();
/*      */     } 
/*  160 */     if (button.field_146127_k == 13) {
/*  161 */       dbcWish(button.field_146127_k);
/*  162 */       this.mc.field_71439_g.func_71053_j();
/*      */     } 
/*  164 */     if (button.field_146127_k == 14) {
/*  165 */       dbcWish(button.field_146127_k);
/*  166 */       this.mc.field_71439_g.func_71053_j();
/*      */     } 
/*      */ 
/*      */     
/*  170 */     if (button.field_146127_k == 99) {
/*  171 */       this.updateTime = 0;
/*  172 */       if (this.wish == 10) { this.wish = 1001; }
/*  173 */       else if (this.wish == 1001) { this.wish = 10; }
/*      */     
/*  175 */     }  if (button.field_146127_k == 100) {
/*  176 */       dbcTelep(button.field_146127_k);
/*  177 */       this.mc.field_71439_g.func_71053_j();
/*      */     } 
/*  179 */     if (button.field_146127_k == 101) {
/*  180 */       dbcTelep(button.field_146127_k);
/*  181 */       this.mc.field_71439_g.func_71053_j();
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  191 */     if (button.field_146127_k == 103) {
/*  192 */       this.wish = 221;
/*      */     }
/*  194 */     if (button.field_146127_k == 104) {
/*  195 */       this.wish = 12;
/*      */     }
/*  197 */     if (button.field_146127_k == 105) {
/*  198 */       this.mc.field_71439_g.func_71053_j();
/*  199 */       JRMCoreH.Char((byte)101, (byte)0);
/*      */     } 
/*  201 */     if (button.field_146127_k == 106) { JRMCoreH.Char((byte)104, (byte)0); this.mc.field_71439_g.func_71053_j(); }
/*  202 */      if (button.field_146127_k == 107) {
/*  203 */       this.wish = 1102;
/*      */     }
/*  205 */     if (button.field_146127_k == 108) {
/*  206 */       this.wish = 1104;
/*      */     }
/*  208 */     if (button.field_146127_k == 109) { JRMCoreH.Char((byte)105, (byte)0); this.mc.field_71439_g.func_71053_j(); }
/*  209 */      if (button.field_146127_k == 198)
/*      */     {
/*      */       
/*  212 */       this.wish = 113;
/*      */     }
/*  214 */     if (button.field_146127_k == 110)
/*  215 */       this.wish = 1105; 
/*  216 */     if (button.field_146127_k == 111)
/*  217 */       this.wish = 2005; 
/*      */     int j;
/*  219 */     for (j = 0; j < 15; j++) {
/*  220 */       if (button.field_146127_k == 10111 + j) this.wish = 111 + j; 
/*  221 */       if (button.field_146127_k == 101111 + j * 10) this.wish = 1111 + j * 10;
/*      */     
/*      */     } 
/*  224 */     if (button.field_146127_k == 9100) this.wish = 9100; 
/*  225 */     if (button.field_146127_k == 9101) this.wish = 9101; 
/*  226 */     if (button.field_146127_k == 9102) this.wish = 9102;
/*      */     
/*  228 */     if (button.field_146127_k == 199) {
/*  229 */       dbcWish(button.field_146127_k);
/*  230 */       this.mc.field_71439_g.func_71053_j();
/*      */     } 
/*  232 */     if (button.field_146127_k == 201) {
/*  233 */       this.mc.field_71439_g.func_71053_j();
/*  234 */       JRMCoreH.Char((byte)4, (byte)0);
/*  235 */       JRMCoreH.Char((byte)100, (byte)0);
/*      */ 
/*      */       
/*  238 */       boolean doit = true;
/*      */       
/*  240 */       if (JRMCoreH.DBC() && this.mc.field_71439_g != null)
/*      */       {
/*  242 */         doit = !JRMCoreH.isFused();
/*      */       }
/*  244 */       if (doit) {
/*      */         
/*  246 */         JRMCoreH.resetChar();
/*  247 */         DBCKiTech.turbo = false;
/*      */       } 
/*      */     } 
/*  250 */     if (button.field_146127_k == 2011) {
/*  251 */       this.wish = 1101;
/*      */     }
/*  253 */     if (button.field_146127_k == 2012) {
/*  254 */       this.wish = 11;
/*      */     }
/*  256 */     if (button.field_146127_k == 202) {
/*  257 */       if (JRMCoreH.align > 65) {
/*  258 */         dbcWish(button.field_146127_k);
/*      */       } else {
/*  260 */         dbcWish(button.field_146127_k + 1);
/*      */       } 
/*  262 */       this.mc.field_71439_g.func_71053_j();
/*      */     } 
/*      */     
/*  265 */     if (button instanceof JRMCoreGuiButtons00MS && button.field_146127_k == 6000) {
/*  266 */       JRMCoreGuiButtons00MS btn = (JRMCoreGuiButtons00MS)button;
/*  267 */       if (btn.d2.equals("-3")) {
/*  268 */         this.mc.field_71439_g.func_71053_j();
/*      */       }
/*  270 */       JRMCoreGuiScreen.dataSend(btn.d1, btn.d2);
/*      */     } 
/*      */ 
/*      */     
/*  274 */     for (j = 0; j < JRMCoreH.DBCSkillsIDs.length; j++) {
/*  275 */       if (button.field_146127_k == 1000 + j) JRMCoreH.Skll((byte)1, (byte)j);
/*      */     
/*      */     } 
/*  278 */     for (byte i = 0; i < ((JRMCoreH.Pwrtyp == 2) ? JRMCoreH.pmj : JRMCoreH.pmdbc).length; i = (byte)(i + 1)) {
/*  279 */       if (button.field_146127_k == 4200 + i) {
/*  280 */         JRMCoreH.Tech((byte)4, "" + i);
/*  281 */         this.wish = (this.wish - 1000) / 10; this.ipg = 0;
/*      */       } 
/*      */     } 
/*  284 */     if ((this.name.matches("[0-9].+") || this.name.matches("[0-9]+")) && this.name.length() > 0) {
/*      */ 
/*      */       
/*  287 */       try { this.name = ((Float.parseFloat(this.name) > 5000.0F) ? 5000.0F : ((Float.parseFloat(this.name) < 0.1F) ? 0.1F : Float.parseFloat(this.name))) + ""; }
/*  288 */       catch (Exception e) { this.name = "5"; }
/*      */       
/*  290 */       if (button.field_146127_k == 210) {
/*  291 */         PD.sendToServer((IMessage)new DBCPwish(2, "0;" + this.name));
/*  292 */         this.mc.field_71439_g.func_71053_j();
/*      */       } 
/*  294 */       if (button.field_146127_k == 211) {
/*  295 */         PD.sendToServer((IMessage)new DBCPwish(2, "1;" + this.name));
/*  296 */         this.mc.field_71439_g.func_71053_j();
/*      */       } 
/*  298 */       if (button.field_146127_k == 212) {
/*  299 */         PD.sendToServer((IMessage)new DBCPwish(2, "2;" + this.name));
/*  300 */         this.mc.field_71439_g.func_71053_j();
/*      */       } 
/*  302 */       if (button.field_146127_k == 213) {
/*  303 */         PD.sendToServer((IMessage)new DBCPwish(2, "3;" + this.name));
/*  304 */         this.mc.field_71439_g.func_71053_j();
/*      */       } 
/*  306 */       if (button.field_146127_k == 214) {
/*  307 */         PD.sendToServer((IMessage)new DBCPwish(2, "4;" + this.name));
/*  308 */         this.mc.field_71439_g.func_71053_j();
/*      */       } 
/*      */     } 
/*  311 */     if (button.field_146127_k == 50) {
/*  312 */       PD.sendToServer((IMessage)new DBCPwish(5, "0"));
/*  313 */       this.mc.field_71439_g.func_71053_j();
/*      */     } 
/*  315 */     if (button.field_146127_k == 51) {
/*  316 */       PD.sendToServer((IMessage)new DBCPwish(5, "1"));
/*  317 */       this.mc.field_71439_g.func_71053_j();
/*      */     } 
/*  319 */     if (button.field_146127_k == 52) {
/*  320 */       PD.sendToServer((IMessage)new DBCPwish(6, ""));
/*  321 */       this.mc.field_71439_g.func_71053_j();
/*      */     } 
/*      */   }
/*      */   
/*      */   public void dri(int id) {
/*  326 */     int dri = id;
/*  327 */     PD.sendToServer((IMessage)new DBCPdri(dri));
/*      */   }
/*      */   public void dbcWish(int id) {
/*  330 */     int dbcwish = id;
/*  331 */     PD.sendToServer((IMessage)new DBCPwish(1, dbcwish + ""));
/*      */   }
/*      */   
/*      */   public void dbcTelep(int id) {
/*  335 */     int dbcwish = id;
/*  336 */     PD.sendToServer((IMessage)new DBCPwish(1, dbcwish + ""));
/*      */   }
/*      */   public DBCTalkGui(int w, World wld, int x, int y, int z) {
/*  339 */     this.name = "";
/*  340 */     this.text = 0;
/*      */     
/*  342 */     this.defaultInputFieldText = "";
/*  343 */     this.updateTimer = 0;
/*  344 */     this.updateTime = 0;
/*  345 */     this.updateTimerStopper = false;
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
/* 2060 */     this.Process = "Something is Wrong";
/* 2061 */     this.wid = 0;
/* 2062 */     this.hei = 0;
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
/* 2103 */     this.textureFile = "jinryuudragonbc:sagas.png";
/*      */     double n = 0.1D;
/*      */     AxisAlignedBB aabb = AxisAlignedBB.func_72330_a(x - n, y + n, z - n, x + n, y + n, z + n);
/*      */     List l = wld.func_72872_a(EntityDBCKami.class, aabb);
/*      */     Iterator<EntityDBCKami> it = l.iterator();
/*      */     if (it.hasNext()) {
/*      */       EntityDBCKami k = it.next();
/*      */       this.CurMaster = k.func_70005_c_();
/*      */     } 
/*      */     this.wish = w;
/*      */     this.updateTime = 0;
/*      */     JRMCoreH.revTmr = -1;
/*      */     JRMCoreH.Master = 1;
/*      */     this.MsnSysTalkTo = JRMCoreM.getMda_Obj_TalkTo();
/*      */     if (this.wish == 13) {
/*      */       DBCKiAttacks.dbctick(-100);
/*      */     } else if (this.wish == 12) {
/*      */       DBCKiAttacks.dbctick(-101);
/*      */     } else if (this.wish == 15) {
/*      */       DBCKiAttacks.dbctick(-101);
/*      */     } else if (this.wish == 16) {
/*      */       DBCKiAttacks.dbctick(-101);
/*      */     } else if (this.wish == 17) {
/*      */       DBCKiAttacks.dbctick(-101);
/*      */     } else if (this.wish == 18) {
/*      */       DBCKiAttacks.dbctick(-101);
/*      */     } else if (this.wish == 19) {
/*      */       DBCKiAttacks.dbctick(-101);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void name(FontRenderer var8, int i, int j) {
/*      */     this.inputField = new GuiTextField(var8, i + 100, j + 15 + 0, 100, 12);
/*      */     this.inputField.func_146203_f(20);
/*      */     this.inputField.func_146185_a(true);
/*      */     this.inputField.func_146195_b(true);
/*      */     this.inputField.func_146180_a(this.defaultInputFieldText);
/*      */     this.inputField.func_146205_d(true);
/*      */   }
/*      */   
/*      */   public void func_73876_c() {
/*      */     if (this.inputField != null)
/*      */       this.inputField.func_146178_a(); 
/*      */   }
/*      */   
/*      */   protected void func_73869_a(char c, int i) {
/*      */     super.func_73869_a(c, i);
/*      */     if (this.inputField != null)
/*      */       this.inputField.func_146201_a(c, i); 
/*      */   }
/*      */   
/*      */   protected void func_73864_a(int i, int j, int k) {
/*      */     super.func_73864_a(i, j, k);
/*      */     if (this.inputField != null)
/*      */       this.inputField.func_146192_a(i, j, k); 
/*      */   }
/*      */   
/*      */   public void sklLrn(int i, int x, int y) {
/*      */     DBCGuiButtons01 btn = new DBCGuiButtons01((JRMCoreH.SklLvl(i, (byte)1) < 1) ? (1000 + i) : -1, x, y, 83, 20, JRMCoreH.trl("dbc", JRMCoreH.DBCSkillNames[i]));
/*      */     btn.field_146124_l = (JRMCoreH.getDBCSkillTPCost(i, 0) == -1) ? false : ((JRMCoreH.getDBCSkillTPCost(i, 0) <= JRMCoreH.curTP) ? ((JRMCoreH.SklLvl(i) < 1)) : false);
/*      */     this.field_146292_n.add(btn);
/*      */     this.mc.field_71466_p.func_78276_b((JRMCoreH.SklLvl(i, (byte)1) < 1) ? ((JRMCoreH.getDBCSkillTPCost(i, 0) == -1) ? JRMCoreH.trl("jrmc", "UpgradeLocked") : (JRMCoreH.trl("dbc.talkgui.cost") + ": " + JRMCoreH.getDBCSkillTPCost(i, 0) + " " + JRMCoreH.trl("dbc.talkgui.mind") + ": " + JRMCoreH.skillMindRequirement(JRMCoreH.DBCSkillsIDs[i], JRMCoreH.DBCSkillsIDs, JRMCoreH.DBCSkillMindCost))) : JRMCoreH.trl("dbc.talkgui.owned"), x + 120, y + 7, 0);
/*      */   }
/*      */   
/*      */   public void sklLrn(int i, int x, int y, boolean b) {
/*      */     DBCGuiButtons01 btn = new DBCGuiButtons01((JRMCoreH.SklLvl(i, (byte)1) < 1) ? (1000 + i) : -1, x, y, 83, 20, JRMCoreH.trl("dbc", JRMCoreH.DBCSkillNames[i]));
/*      */     btn.field_146124_l = (JRMCoreH.getDBCSkillTPCost(i, 0) == -1) ? false : ((JRMCoreH.getDBCSkillTPCost(i, 0) <= JRMCoreH.curTP && JRMCoreH.SklLvl(i) < 1) ? b : false);
/*      */     this.field_146292_n.add(btn);
/*      */     this.mc.field_71466_p.func_78276_b((JRMCoreH.SklLvl(i) < 1) ? ((JRMCoreH.getDBCSkillTPCost(i, 0) == -1) ? JRMCoreH.trl("jrmc", "UpgradeLocked") : (JRMCoreH.trl("dbc.talkgui.cost") + ": " + JRMCoreH.getDBCSkillTPCost(i, 0) + " " + JRMCoreH.trl("dbc.talkgui.mind") + ": " + JRMCoreH.skillMindRequirement(JRMCoreH.DBCSkillsIDs[i], JRMCoreH.DBCSkillsIDs, JRMCoreH.DBCSkillMindCost))) : JRMCoreH.trl("dbc.talkgui.owned"), x + 120, y + 7, 0);
/*      */   }
/*      */   
/*      */   public void func_73863_a(int x, int y, float f) {
/*      */     ScaledResolution var5 = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
/*      */     int var6 = var5.func_78326_a();
/*      */     int var7 = var5.func_78328_b();
/*      */     FontRenderer var8 = this.mc.field_71466_p;
/*      */     this.field_146292_n.clear();
/*      */     this.tick++;
/*      */     if (this.tick >= 20) {
/*      */       this.tick = 0;
/*      */       JRMCoreH.jrmct(1);
/*      */       JRMCoreH.jrmct(3);
/*      */     } 
/*      */     int posX = this.field_146294_l / 2;
/*      */     int posY = this.field_146295_m / 2;
/*      */     int xSize = 256;
/*      */     int ySize = 160;
/*      */     int guiLeft = (this.field_146294_l - xSize) / 2;
/*      */     int guiTop = (this.field_146295_m - ySize) / 2;
/*      */     boolean cont = true;
/*      */     if (this.MsnSysTalkTo != null) {
/*      */       String en = EntityList.func_75620_a(this.MsnSysTalkTo.get("N"), null).func_70005_c_();
/*      */       if (en.equalsIgnoreCase(this.CurMaster)) {
/*      */         cont = false;
/*      */         String wish = "jinryuudragonbc:saa.png";
/*      */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */         ResourceLocation tx = new ResourceLocation(wish);
/*      */         this.mc.field_71446_o.func_110577_a(tx);
/*      */         func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*      */         int nr = 0;
/*      */         this.Process = en;
/*      */         nr += JRMCoreH.txt(this.Process, "§8", 0, true, guiLeft + 6, guiTop + 5 + nr * 10, 0);
/*      */         boolean t = Boolean.parseBoolean(this.MsnSysTalkTo.get("translated"));
/*      */         this.Process = JRMCoreH.trl(this.MsnSysTalkTo.get("G"));
/*      */         nr += JRMCoreH.txt(this.Process, "§0", 5, true, guiLeft + 6, guiTop + 5 + nr * 10, 0);
/*      */         this.Process = JRMCoreH.trl(this.MsnSysTalkTo.get("B"));
/*      */         int pw = var8.func_78256_a(this.Process) + 8;
/*      */         this.field_146292_n.add(new JRMCoreGuiButtons00MS(6000, guiLeft + xSize - 6 - pw, guiTop + ySize - 5 - 20, pw, 20, this.Process, 0, this.MsnSysTalkTo.get("series"), "-3"));
/*      */         this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
/*      */       } 
/*      */     } 
/*      */     if (cont) {
/*      */       if (this.wish == 10) {
/*      */         xSize = 182;
/*      */         ySize = 191;
/*      */         guiLeft = (this.field_146294_l - xSize) / 2;
/*      */         guiTop = (this.field_146295_m - ySize) / 2;
/*      */         drawBg("enma", xSize, ySize);
/*      */         int time = (int)(System.currentTimeMillis() / 1000L);
/*      */         if (this.updateTime < time) {
/*      */           this.updateTime = time + 5;
/*      */           DBCH.packDuo(-1, 0);
/*      */         } 
/*      */         int i = 0;
/*      */         int i2 = 0;
/*      */         int a = JRMCoreH.Algnmnt(JRMCoreH.align);
/*      */         i2 = JRMCoreH.txt(JRMCoreH.trl("dbc.talkgui.enmawelcome" + ((a == 0) ? "G" : ((a == 1) ? "N" : "E"))), JRMCoreH.clb, 0, true, guiLeft + 5, guiTop + 5 + i * 10, 175);
/*      */         i += i2;
/*      */         if (DBCConfig.Reinc > 0.0F) {
/*      */           String str = JRMCoreH.trl("dbc.talkgui.reincarnate");
/*      */           int j = var8.func_78256_a(str);
/*      */           this.field_146292_n.add(new DBCGuiButtons01(99, guiLeft + xSize / 2 - j / 2 - 5, guiTop + 5 + i * 21 - i2 * 10, j + 10, 20, str));
/*      */           i++;
/*      */         } 
/*      */         if (JRMCoreH.revTmr > 0 && DBCConfig.FreeRev) {
/*      */           int rt = (int)JRMCoreH.gkap((JRMCoreH.revTmr - 5), "rt", 5, 0.025D);
/*      */           int rt1 = rt / 1 % 60;
/*      */           int rt2 = rt / 60 % 60;
/*      */           int rt3 = rt / 3600 % 24;
/*      */           int rt4 = rt / 86400;
/*      */           String str = JRMCoreH.trl("dbc.talkgui.revivetime", new Object[] { JRMCoreH.format_lz2(new Object[] { Integer.valueOf(rt1) }), JRMCoreH.format_lz2(new Object[] { Integer.valueOf(rt2) }), JRMCoreH.format_lz2(new Object[] { Integer.valueOf(rt3) }), JRMCoreH.format_lz2(new Object[] { Integer.valueOf(rt4) }) });
/*      */           int j = var8.func_78256_a(str);
/*      */           var8.func_78276_b(str, guiLeft + xSize / 2 - j / 2, guiTop + 12 + i * 21 - i2 * 10, 0);
/*      */           i++;
/*      */           str = JRMCoreH.trl("dbc.talkgui.revfree");
/*      */           j = var8.func_78256_a(str);
/*      */           DBCGuiButtons01 b = new DBCGuiButtons01(-1, posX - j / 2 - 5, guiTop + 5 + i * 21 - i2 * 10, j + 10, 20, str);
/*      */           b.field_146124_l = false;
/*      */           this.field_146292_n.add(b);
/*      */           i++;
/*      */         } else if (JRMCoreH.revTmr == 0) {
/*      */           String str = JRMCoreH.trl("dbc.talkgui.revfree");
/*      */           int j = var8.func_78256_a(str);
/*      */           this.field_146292_n.add(new DBCGuiButtons01(100, posX - j / 2 - 5, guiTop + 5 + i * 21 - i2 * 10, j + 10, 20, str));
/*      */           i++;
/*      */         } 
/*      */         String n = JRMCoreH.trl("dbc.talkgui.stay");
/*      */         int nw = var8.func_78256_a(n);
/*      */         this.field_146292_n.add(new DBCGuiButtons01(-1, posX - nw / 2 - 5, guiTop + 5 + i * 21 - i2 * 10, nw + 10, 20, n));
/*      */         i++;
/*      */       } else if (this.wish == 1001) {
/*      */         xSize = 182;
/*      */         ySize = 191;
/*      */         guiLeft = (this.field_146294_l - xSize) / 2;
/*      */         guiTop = (this.field_146295_m - ySize) / 2;
/*      */         drawBg("enma", xSize, ySize);
/*      */         int time = (int)(System.currentTimeMillis() / 1000L);
/*      */         if (this.updateTime < time && !this.updateTimerStopper)
/*      */           this.updateTime = time + 10; 
/*      */         this.updateTimer = this.updateTime - time;
/*      */         if (this.updateTimer <= 0 && !this.updateTimerStopper)
/*      */           this.updateTimerStopper = true; 
/*      */         int i = 0;
/*      */         int i2 = 0;
/*      */         i2 = JRMCoreH.txt(JRMCoreH.trl("dbc.talkgui.enmareincarnate", new Object[] { (int)(DBCConfig.Reinc * 100.0F) + "%" }), JRMCoreH.clb, 0, true, guiLeft + 5, guiTop + 5 + i * 10, 175);
/*      */         i += i2;
/*      */         this.field_146292_n.add(new DBCGuiButtons01(99, guiLeft + xSize / 2 - 40 - 5, guiTop + 10 + i * 21 - i2 * 10, 80, 20, JRMCoreH.trl("dbc.talkgui.no")));
/*      */         i++;
/*      */         if (this.updateTimer <= 0) {
/*      */           this.field_146292_n.add(new DBCGuiButtons01(101, guiLeft + xSize / 2 - 40 - 5, guiTop + 10 + i * 21 - i2 * 10, 80, 20, JRMCoreH.trl("dbc.talkgui.confirm")));
/*      */           i++;
/*      */         } else {
/*      */           String n = JRMCoreH.trl("dbc.talkgui.enmareincavilabl", new Object[] { JRMCoreH.format_lz2(new Object[] { Integer.valueOf(this.updateTimer % 60) }) });
/*      */           int nw = var8.func_78256_a(n);
/*      */           var8.func_78276_b(n, guiLeft + xSize / 2 - nw / 2, guiTop + 10 + i * 21 - i2 * 10 + 5, 0);
/*      */           i++;
/*      */         } 
/*      */       } else if (this.wish == 9000) {
/*      */         this.master = 16;
/*      */         this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
/*      */       } 
/*      */       if (this.wish == 9001) {
/*      */         this.master = 17;
/*      */         this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
/*      */       } 
/*      */       if (this.wish == 9002) {
/*      */         this.master = 18;
/*      */         this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
/*      */       } 
/*      */       if (this.wish == 11) {
/*      */         this.master = 5;
/*      */         int line = 0;
/*      */         if (JRMCoreH.SagaProg == 1700) {
/*      */           this.field_146292_n.add(new DBCGuiButtons01(203, posX - 35, posY - 5, 100, 20, StatCollector.func_74838_a("dbc.MainSaga.17.1")));
/*      */         } else if (JRMCoreH.SagaSideProg == 10100) {
/*      */           this.field_146292_n.add(new DBCGuiButtons01(204, posX - 35, posY - 5, 100, 20, StatCollector.func_74838_a("dbc.sidesagas.101.talkok")));
/*      */         } else {
/*      */           if ((JRMCoreH.Race == 1 || JRMCoreH.Race == 2) && (JRMCoreH.TlMd == 3 || JRMCoreH.TlMd == 4)) {
/*      */             String str = JRMCoreH.trl("dbc.talkgui.kami.forcetailregrow");
/*      */             int i = this.field_146289_q.func_78256_a(str) + 8;
/*      */             this.field_146292_n.add(new DBCGuiButtons01(108, posX + 115 - i, posY + 15 + line * 21, i, 20, str));
/*      */             line++;
/*      */           } 
/*      */           if ((JRMCoreH.Race == 1 || JRMCoreH.Race == 2) && (JRMCoreH.TlMd == -1 || JRMCoreH.TlMd == 0 || JRMCoreH.TlMd == 1)) {
/*      */             String str = JRMCoreH.trl("dbc.talkgui.kami.cutdowntail");
/*      */             int i = this.field_146289_q.func_78256_a(str) + 8;
/*      */             this.field_146292_n.add(new DBCGuiButtons01(107, posX + 115 - i, posY + 15 + line * 21, i, 20, str));
/*      */             line++;
/*      */           } 
/*      */           String n = JRMCoreH.trl("dbc.talkgui.anew");
/*      */           int nw = this.field_146289_q.func_78256_a(n) + 8;
/*      */           this.field_146292_n.add(new DBCGuiButtons01(2011, posX + 115 - nw, posY + 15 + line * 21, nw, 20, n));
/*      */           line++;
/*      */           n = JRMCoreH.trl("dbc.talkgui.skills");
/*      */           nw = this.field_146289_q.func_78256_a(n) + 8;
/*      */           this.field_146292_n.add(new DBCGuiButtons01(this.wish + 10100, posX + 115 - nw, posY + 15 + line * 21, nw, 20, n));
/*      */           line++;
/*      */           line = 0;
/*      */           n = JRMCoreH.trl("dbc.talkgui.giveweights");
/*      */           nw = this.field_146289_q.func_78256_a(n) + 8;
/*      */           this.field_146292_n.add(new DBCGuiButtons01(110, posX - 115 - 0, posY + 15 + line * 21, nw, 20, n));
/*      */           line++;
/*      */         } 
/*      */         this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
/*      */       } else if (this.wish == 1101) {
/*      */         this.field_146292_n.add(new DBCGuiButtons01(2012, posX - 35, posY + 55, 80, 20, JRMCoreH.trl("dbc.talkgui.no")));
/*      */         this.field_146292_n.add(new DBCGuiButtons01(201, posX - 120, posY + 55, 80, 20, JRMCoreH.trl("dbc.talkgui.confirm")));
/*      */       } else if (this.wish == 1102) {
/*      */         this.field_146292_n.add(new DBCGuiButtons01(2012, posX - 35, posY + 55, 80, 20, JRMCoreH.trl("dbc.talkgui.no")));
/*      */         this.field_146292_n.add(new DBCGuiButtons01(106, posX - 120, posY + 55, 80, 20, JRMCoreH.trl("dbc.talkgui.confirm")));
/*      */       } else if (this.wish == 1104) {
/*      */         this.field_146292_n.add(new DBCGuiButtons01(2012, posX - 35, posY + 55, 80, 20, JRMCoreH.trl("dbc.talkgui.no")));
/*      */         this.field_146292_n.add(new DBCGuiButtons01(109, posX - 120, posY + 55, 80, 20, JRMCoreH.trl("dbc.talkgui.confirm")));
/*      */       } else if (this.wish == 1105) {
/*      */         String im = "jinryuudragonbc:saa.png";
/*      */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */         ResourceLocation tx = new ResourceLocation(im);
/*      */         this.mc.field_71446_o.func_110577_a(tx);
/*      */         func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*      */         int nr = 0;
/*      */         this.Process = StatCollector.func_74838_a("dbc.talkgui.giveweightsdesc");
/*      */         nr += JRMCoreH.txt(this.Process, "§0", 5, true, guiLeft + 6, guiTop + 5 + nr * 10, 0);
/*      */         int line = 0;
/*      */         String n = JRMCoreH.trl("dbc.talkgui.weightamount");
/*      */         int nw = this.field_146289_q.func_78256_a(n) + 8;
/*      */         this.text++;
/*      */         if (this.text == 1) {
/*      */           name(var8, posX - 220 + nw, posY - 25 + line * 21);
/*      */           this.inputField.func_146180_a("5");
/*      */         } else {
/*      */           this.text = 2;
/*      */         } 
/*      */         if (this.inputField != null) {
/*      */           this.inputField.func_146194_f();
/*      */           this.name = this.inputField.func_146179_b();
/*      */           var8.func_78276_b(n, posX - 120, posY - 7 + line * 21, 0);
/*      */         } 
/*      */         line++;
/*      */         n = ItemsDBC.ItemWeightHandLeg.func_77653_i(new ItemStack(ItemsDBC.ItemWeightHandLeg));
/*      */         nw = this.field_146289_q.func_78256_a(n) + 8;
/*      */         if (this.master == 6) {
/*      */           this.field_146292_n.add(new DBCGuiButtons01(210, posX - 120, posY - 15 + line * 21, nw, 20, n));
/*      */           line++;
/*      */         } 
/*      */         n = ItemsDBC.ItemWeightShell.func_77653_i(new ItemStack(ItemsDBC.ItemWeightShell));
/*      */         nw = this.field_146289_q.func_78256_a(n) + 8;
/*      */         if (this.master == 2) {
/*      */           this.field_146292_n.add(new DBCGuiButtons01(211, posX - 120, posY - 15 + line * 21, nw, 20, n));
/*      */           line++;
/*      */         } 
/*      */         n = ItemsDBC.ItemWeightShirt.func_77653_i(new ItemStack(ItemsDBC.ItemWeightShirt));
/*      */         nw = this.field_146289_q.func_78256_a(n) + 8;
/*      */         if (this.master == 6 || this.master == 5) {
/*      */           this.field_146292_n.add(new DBCGuiButtons01(212, posX - 120, posY - 15 + line * 21, nw, 20, n));
/*      */           line++;
/*      */         } 
/*      */         n = ItemsDBC.ItemWeightCape.func_77653_i(new ItemStack(ItemsDBC.ItemWeightCape));
/*      */         nw = this.field_146289_q.func_78256_a(n) + 8;
/*      */         if (this.master == 8) {
/*      */           this.field_146292_n.add(new DBCGuiButtons01(213, posX - 120, posY - 15 + line * 21, nw, 20, n));
/*      */           line++;
/*      */         } 
/*      */         n = ItemsDBC.ItemWeightHeavySuit.func_77653_i(new ItemStack(ItemsDBC.ItemWeightHeavySuit));
/*      */         nw = this.field_146289_q.func_78256_a(n) + 8;
/*      */         if (this.master == 18) {
/*      */           this.field_146292_n.add(new DBCGuiButtons01(214, posX - 120, posY - 15 + line * 21, nw, 20, n));
/*      */           line++;
/*      */         } 
/*      */       } else if (this.wish == 111) {
/*      */         this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
/*      */         String wish = "jinryuudragonbc:saa.png";
/*      */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */         ResourceLocation tx = new ResourceLocation(wish);
/*      */         this.mc.field_71446_o.func_110577_a(tx);
/*      */         func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*      */         posX = this.field_146294_l / 2;
/*      */         posY = this.field_146295_m / 2;
/*      */         int m = JRMCoreH.skillSlot_SpentMindRequirement(JRMCoreH.PlyrSkills, JRMCoreH.DBCSkillsIDs, JRMCoreH.DBCSkillMindCost) + JRMCoreH.skillSlot_SpentMindRequirement_X(JRMCoreH.PlyrSkillX, JRMCoreH.Race, JRMCoreH.DBCRacialSkillMindCost);
/*      */         int ml = JRMCoreH.statMindC() - m;
/*      */         var8.func_78276_b(JRMCoreH.trl("jrmc", "AvailableMind") + ": " + JRMCoreH.numSep(ml), guiLeft + 5, guiTop + 15, 0);
/*      */         var8.func_78276_b("TP: " + JRMCoreH.numSep(JRMCoreH.curTP), guiLeft + 5, guiTop + 5, 0);
/*      */         int i = 0;
/*      */         sklLrn(1, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */         sklLrn(3, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */         sklLrn(5, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */         sklLrn(4, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */         sklLrn(7, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */         sklLrn(6, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */       } else if (this.wish == 9000) {
/*      */         drawBg("saa", xSize, ySize);
/*      */         this.master = 17;
/*      */         int line = 0;
/*      */         int line2 = 0;
/*      */         if (JRMCoreH.align > 33) {
/*      */           String n = JRMCoreH.trl("dbc.talkgui.skills");
/*      */           int nw = this.field_146289_q.func_78256_a(n) + 8;
/*      */           this.field_146292_n.add(new DBCGuiButtons01(this.wish + 100, posX + 115 - nw, posY + 15 + line2 * 21, nw, 20, n));
/*      */           line2++;
/*      */         } 
/*      */         this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
/*      */       } else if (this.wish == 9100) {
/*      */         this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
/*      */         String wish = "jinryuudragonbc:saa.png";
/*      */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */         ResourceLocation tx = new ResourceLocation(wish);
/*      */         this.mc.field_71446_o.func_110577_a(tx);
/*      */         func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*      */         posX = this.field_146294_l / 2;
/*      */         posY = this.field_146295_m / 2;
/*      */         int m = JRMCoreH.skillSlot_SpentMindRequirement(JRMCoreH.PlyrSkills, JRMCoreH.DBCSkillsIDs, JRMCoreH.DBCSkillMindCost) + JRMCoreH.skillSlot_SpentMindRequirement_X(JRMCoreH.PlyrSkillX, JRMCoreH.Race, JRMCoreH.DBCRacialSkillMindCost);
/*      */         int ml = JRMCoreH.statMindC() - m;
/*      */         var8.func_78276_b(JRMCoreH.trl("jrmc", "AvailableMind") + ": " + JRMCoreH.numSep(ml), guiLeft + 5, guiTop + 15, 0);
/*      */         var8.func_78276_b("TP: " + JRMCoreH.numSep(JRMCoreH.curTP), guiLeft + 5, guiTop + 5, 0);
/*      */         int i = 0;
/*      */         boolean gf = (DBCConfig.Godform && JRMCoreHDBC.godKiAble());
/*      */         sklLrn(9, guiLeft + 5, guiTop + 25 + i * 21, gf);
/*      */         i++;
/*      */         if (JGConfigUltraInstinct.CONFIG_UI_LEVELS > 0) {
/*      */           sklLrn(16, guiLeft + 5, guiTop + 25 + i * 21);
/*      */           i++;
/*      */         } 
/*      */       } else if (this.wish == 9001) {
/*      */         drawBg("saa", xSize, ySize);
/*      */         this.master = 17;
/*      */         int line = 0;
/*      */         int line2 = 0;
/*      */         if (JRMCoreH.align > 33) {
/*      */           String n = JRMCoreH.trl("dbc.talkgui.skills");
/*      */           int nw = this.field_146289_q.func_78256_a(n) + 8;
/*      */           this.field_146292_n.add(new DBCGuiButtons01(this.wish + 100, posX + 115 - nw, posY + 15 + line2 * 21, nw, 20, n));
/*      */           line2++;
/*      */         } 
/*      */         this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
/*      */       } else if (this.wish == 9101) {
/*      */         this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
/*      */         String wish = "jinryuudragonbc:saa.png";
/*      */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */         ResourceLocation tx = new ResourceLocation(wish);
/*      */         this.mc.field_71446_o.func_110577_a(tx);
/*      */         func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*      */         posX = this.field_146294_l / 2;
/*      */         posY = this.field_146295_m / 2;
/*      */         int m = JRMCoreH.skillSlot_SpentMindRequirement(JRMCoreH.PlyrSkills, JRMCoreH.DBCSkillsIDs, JRMCoreH.DBCSkillMindCost) + JRMCoreH.skillSlot_SpentMindRequirement_X(JRMCoreH.PlyrSkillX, JRMCoreH.Race, JRMCoreH.DBCRacialSkillMindCost);
/*      */         int ml = JRMCoreH.statMindC() - m;
/*      */         var8.func_78276_b(JRMCoreH.trl("jrmc", "AvailableMind") + ": " + JRMCoreH.numSep(ml), guiLeft + 5, guiTop + 15, 0);
/*      */         var8.func_78276_b("TP: " + JRMCoreH.numSep(JRMCoreH.curTP), guiLeft + 5, guiTop + 5, 0);
/*      */         int i = 0;
/*      */         sklLrn(5, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */       } else if (this.wish == 9002) {
/*      */         drawBg("saa", xSize, ySize);
/*      */         this.master = 18;
/*      */         int line = 0;
/*      */         int line2 = 0;
/*      */         if (JRMCoreH.align > 33) {
/*      */           String str = JRMCoreH.trl("dbc.talkgui.skills");
/*      */           int i = this.field_146289_q.func_78256_a(str) + 8;
/*      */           this.field_146292_n.add(new DBCGuiButtons01(this.wish + 100, posX + 115 - i, posY + 15 + line2 * 21, i, 20, str));
/*      */           line2++;
/*      */           if (JRMCoreH.align > 33) {
/*      */             str = JRMCoreH.trl("dbc.talkgui.giveweights");
/*      */             i = this.field_146289_q.func_78256_a(str) + 8;
/*      */             this.field_146292_n.add(new DBCGuiButtons01(110, posX - 115, posY + 15 + line * 21, i, 20, str));
/*      */             line++;
/*      */           } 
/*      */         } 
/*      */         this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
/*      */         int ln = 0;
/*      */         String n = JRMCoreH.trl("dbc", "whisteleport");
/*      */         int nw = this.field_146289_q.func_78256_a(n) + 8;
/*      */         ln++;
/*      */         this.field_146292_n.add(new DBCGuiButtons01(52, posX - nw / 2, posY + 20 + ln * 20, nw, 20, n));
/*      */         ln++;
/*      */       } else if (this.wish == 9102) {
/*      */         this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
/*      */         String wish = "jinryuudragonbc:saa.png";
/*      */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */         ResourceLocation tx = new ResourceLocation(wish);
/*      */         this.mc.field_71446_o.func_110577_a(tx);
/*      */         func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*      */         posX = this.field_146294_l / 2;
/*      */         posY = this.field_146295_m / 2;
/*      */         int m = JRMCoreH.skillSlot_SpentMindRequirement(JRMCoreH.PlyrSkills, JRMCoreH.DBCSkillsIDs, JRMCoreH.DBCSkillMindCost) + JRMCoreH.skillSlot_SpentMindRequirement_X(JRMCoreH.PlyrSkillX, JRMCoreH.Race, JRMCoreH.DBCRacialSkillMindCost);
/*      */         int ml = JRMCoreH.statMindC() - m;
/*      */         var8.func_78276_b(JRMCoreH.trl("jrmc", "AvailableMind") + ": " + JRMCoreH.numSep(ml), guiLeft + 5, guiTop + 15, 0);
/*      */         var8.func_78276_b("TP: " + JRMCoreH.numSep(JRMCoreH.curTP), guiLeft + 5, guiTop + 5, 0);
/*      */         int i = 0;
/*      */         boolean gf = (DBCConfig.Godform && JRMCoreHDBC.godKiAble());
/*      */         sklLrn(9, guiLeft + 5, guiTop + 25 + i * 21, gf);
/*      */         i++;
/*      */         if (JGConfigUltraInstinct.CONFIG_UI_LEVELS > 0) {
/*      */           sklLrn(16, guiLeft + 5, guiTop + 25 + i * 21);
/*      */           i++;
/*      */         } 
/*      */         sklLrn(18, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */       } else if (this.wish == 12) {
/*      */         drawBg("saa", xSize, ySize);
/*      */         this.master = 6;
/*      */         int line = 0;
/*      */         int line2 = 0;
/*      */         if (JRMCoreH.align > 33) {
/*      */           if (JRMCoreH.Master == 1) {
/*      */             String str1 = JRMCoreH.trl("dbc.talkgui.learntechs");
/*      */             int j = this.field_146289_q.func_78256_a(str1) + 8;
/*      */             this.field_146292_n.add(new DBCGuiButtons01((this.wish + 10100) * 10 + 1, posX + 115 - j, posY + 15 + line2 * 21, j, 20, str1));
/*      */             line2++;
/*      */           } 
/*      */           String str = JRMCoreH.trl("dbc.talkgui.skills");
/*      */           int i = this.field_146289_q.func_78256_a(str) + 8;
/*      */           this.field_146292_n.add(new DBCGuiButtons01(this.wish + 10100, posX + 115 - i, posY + 15 + line2 * 21, i, 20, str));
/*      */           line2++;
/*      */         } 
/*      */         String n = JRMCoreH.trl("dbc.talkgui.difftonormal");
/*      */         int nw = this.field_146289_q.func_78256_a(n) + 8;
/*      */         this.field_146292_n.add(new DBCGuiButtons01(103, posX + 115 - nw, posY + 15 + line2 * 21, nw, 20, n));
/*      */         line2++;
/*      */         if (JRMCoreH.align > 33) {
/*      */           n = JRMCoreH.trl("dbc.talkgui.giveweights");
/*      */           nw = this.field_146289_q.func_78256_a(n) + 8;
/*      */           this.field_146292_n.add(new DBCGuiButtons01(110, posX - 115 - 0, posY + 15 + line * 21, nw, 20, n));
/*      */           line++;
/*      */         } 
/*      */         if (JRMCoreH.StusEfctsMe(12)) {
/*      */           n = JRMCoreH.trl("dbc", "majinLoose");
/*      */           nw = this.field_146289_q.func_78256_a(n) + 8;
/*      */           this.field_146292_n.add(new DBCGuiButtons01(50, posX + 115 - nw, posY + 15 + line2 * 21, nw, 20, n));
/*      */           line2++;
/*      */         } 
/*      */         this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
/*      */       } else if (this.wish == 112) {
/*      */         this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
/*      */         String wish = "jinryuudragonbc:saa.png";
/*      */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */         ResourceLocation tx = new ResourceLocation(wish);
/*      */         this.mc.field_71446_o.func_110577_a(tx);
/*      */         func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*      */         posX = this.field_146294_l / 2;
/*      */         posY = this.field_146295_m / 2;
/*      */         int m = JRMCoreH.skillSlot_SpentMindRequirement(JRMCoreH.PlyrSkills, JRMCoreH.DBCSkillsIDs, JRMCoreH.DBCSkillMindCost) + JRMCoreH.skillSlot_SpentMindRequirement_X(JRMCoreH.PlyrSkillX, JRMCoreH.Race, JRMCoreH.DBCRacialSkillMindCost);
/*      */         int ml = JRMCoreH.statMindC() - m;
/*      */         var8.func_78276_b(JRMCoreH.trl("jrmc", "AvailableMind") + ": " + JRMCoreH.numSep(ml), guiLeft + 5, guiTop + 15, 0);
/*      */         var8.func_78276_b("TP: " + JRMCoreH.numSep(JRMCoreH.curTP), guiLeft + 5, guiTop + 5, 0);
/*      */         int i = 0;
/*      */         boolean gf = (DBCConfig.Godform && JRMCoreHDBC.godKiAble());
/*      */         String n = JRMCoreH.trl("dbc", "PURitual");
/*      */         int nw = this.field_146289_q.func_78256_a(n) + 8;
/*      */         DBCGuiButtons01 btn = new DBCGuiButtons01((JRMCoreH.SklLvl(10, (byte)1) < 1) ? 1010 : -1, guiLeft + 5, guiTop + 25 + i * 21, 83, 20, n);
/*      */         btn.field_146124_l = (JRMCoreH.align == 100 && JRMCoreH.SklLvl(10) == 0 && JRMCoreH.getDBCSkillTPCost(10, 0) != -1 && JRMCoreH.getDBCSkillTPCost(10, 0) <= JRMCoreH.curTP);
/*      */         this.field_146292_n.add(btn);
/*      */         this.mc.field_71466_p.func_78276_b((JRMCoreH.align < 100) ? JRMCoreH.trl("jrmc", "NeedToBeGood", new Object[] { Integer.valueOf(100) }) : ((JRMCoreH.SklLvl(10) < 1) ? ((JRMCoreH.getDBCSkillTPCost(10, 0) == -1) ? JRMCoreH.trl("jrmc", "UpgradeLocked") : (JRMCoreH.trl("dbc.talkgui.cost") + ": " + JRMCoreH.getDBCSkillTPCost(10, 0) + " " + JRMCoreH.trl("dbc.talkgui.mind") + ": " + JRMCoreH.skillMindRequirement(JRMCoreH.DBCSkillsIDs[i], JRMCoreH.DBCSkillsIDs, JRMCoreH.DBCSkillMindCost))) : JRMCoreH.trl("dbc.talkgui.owned")), guiLeft + 5 + 120, guiTop + 25 + 7 + i * 21, 0);
/*      */         i++;
/*      */         sklLrn(8, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */         sklLrn(3, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */         sklLrn(13, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */       } else if (this.wish == 1121) {
/*      */         this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
/*      */         String wish = "jinryuudragonbc:saa.png";
/*      */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */         ResourceLocation tx = new ResourceLocation(wish);
/*      */         this.mc.field_71446_o.func_110577_a(tx);
/*      */         func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*      */         posX = this.field_146294_l / 2;
/*      */         posY = this.field_146295_m / 2;
/*      */         String[][] PMA = JRMCoreH.pmdbc;
/*      */         var8.func_78276_b(JRMCoreH.numSep(JRMCoreH.curTP) + " " + "Training Points", guiLeft + 10, guiTop + 5, 0);
/*      */         int i2 = 0;
/*      */         int nms = PMA.length;
/*      */         byte i;
/*      */         for (i = 0; i < nms; i = (byte)(i + 1)) {
/*      */           int owner = Integer.parseInt(PMA[i][2]);
/*      */           if (owner == 1 || owner == 6) {
/*      */             if (i2 <= 13 + this.ipg * 13 && i2 >= 0 + this.ipg * 13) {
/*      */               String fn = JRMCoreH.trl("dbc", PMA[i][0]);
/*      */               int fnw = this.fontRenderer.func_78256_a(fn);
/*      */               var8.func_78276_b(fn, guiLeft + xSize / 2 - 122, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, 0);
/*      */               String on = JRMCoreH.techOwnd(i, (byte)1) ? " Owned" : "";
/*      */               int onw = this.fontRenderer.func_78256_a(on);
/*      */               var8.func_78276_b(on, guiLeft + xSize / 2 - 122 + fnw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[1]);
/*      */               if (!JRMCoreH.techOwnd(i, (byte)1)) {
/*      */                 int costTp = (int)(JRMCoreH.techDBCtpc(PMA[i]) * 0.9F);
/*      */                 int cost = costTp;
/*      */                 String n = " " + cost + " tp";
/*      */                 int nw = this.fontRenderer.func_78256_a(fn);
/*      */                 if (JRMCoreH.curTP >= cost) {
/*      */                   this.field_146292_n.add(new JRMCoreGuiButtons01(!JRMCoreH.techOwnd(i, (byte)1) ? (4200 + i) : -1, guiLeft + xSize / 2 - 122 + fnw + onw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, nw, n, JRMCoreH.techNCCol[1]));
/*      */                 } else {
/*      */                   var8.func_78276_b(n, guiLeft + xSize / 2 - 122 + fnw + onw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[0]);
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */             i2++;
/*      */           } 
/*      */         } 
/*      */       } else if (this.wish == 221) {
/*      */         String wish = "jinryuudragonbc:saa.png";
/*      */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */         ResourceLocation tx = new ResourceLocation(wish);
/*      */         this.mc.field_71446_o.func_110577_a(tx);
/*      */         func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*      */         Iterator<String> iterator = this.mc.field_71466_p.func_78271_c(JRMCoreH.trl("dbc", "KaioDiffRed"), 245).iterator();
/*      */         int i2 = 0;
/*      */         while (iterator.hasNext()) {
/*      */           i2++;
/*      */           String s1 = iterator.next();
/*      */           var8.func_78276_b("§0" + s1, guiLeft + 5, guiTop + 5 + i2 * 10, 0);
/*      */         } 
/*      */         this.field_146292_n.add(new DBCGuiButtons01(104, posX - 35, posY + 55, 80, 20, JRMCoreH.trl("dbc.talkgui.no")));
/*      */         this.field_146292_n.add(new DBCGuiButtons01(105, posX - 120, posY + 55, 80, 20, JRMCoreH.trl("dbc.talkgui.confirm")));
/*      */       } else if (this.wish == 13) {
/*      */         this.master = 4;
/*      */         if (JRMCoreH.align > 65) {
/*      */           if (JRMCoreH.Senzu == 0)
/*      */             this.field_146292_n.add(new DBCGuiButtons01(199, posX - 35, posY + 35, 100, 20, StatCollector.func_74838_a("dbc.talkgui.karin.senzu"))); 
/*      */           this.field_146292_n.add(new DBCGuiButtons01(198, posX - 35, posY + 55, 100, 20, StatCollector.func_74838_a("dbc.talkgui.skills")));
/*      */           if (!this.mc.field_71439_g.field_71071_by.func_146028_b(ItemsDBC.KintounItem))
/*      */             this.field_146292_n.add(new DBCGuiButtons01(202, posX - 35, posY + 15, 100, 20, StatCollector.func_74838_a("dbc.talkgui.kintoun"))); 
/*      */         } else if (!this.mc.field_71439_g.field_71071_by.func_146028_b(ItemsDBC.KintounBlackItem)) {
/*      */           this.field_146292_n.add(new DBCGuiButtons01(202, posX - 35, posY + 15, 140, 20, StatCollector.func_74838_a("dbc.talkgui.kintounblack")));
/*      */         } 
/*      */         this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
/*      */       } else if (this.wish == 113) {
/*      */         this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
/*      */         String wish = "jinryuudragonbc:saa.png";
/*      */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */         ResourceLocation tx = new ResourceLocation(wish);
/*      */         this.mc.field_71446_o.func_110577_a(tx);
/*      */         func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*      */         posX = this.field_146294_l / 2;
/*      */         posY = this.field_146295_m / 2;
/*      */         int m = JRMCoreH.skillSlot_SpentMindRequirement(JRMCoreH.PlyrSkills, JRMCoreH.DBCSkillsIDs, JRMCoreH.DBCSkillMindCost) + JRMCoreH.skillSlot_SpentMindRequirement_X(JRMCoreH.PlyrSkillX, JRMCoreH.Race, JRMCoreH.DBCRacialSkillMindCost);
/*      */         int ml = JRMCoreH.statMindC() - m;
/*      */         var8.func_78276_b(JRMCoreH.trl("jrmc", "AvailableMind") + ": " + JRMCoreH.numSep(ml), guiLeft + 5, guiTop + 15, 0);
/*      */         var8.func_78276_b("TP: " + JRMCoreH.numSep(JRMCoreH.curTP), guiLeft + 5, guiTop + 5, 0);
/*      */         int i = 0;
/*      */         sklLrn(1, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */         sklLrn(3, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */       } else if (this.wish == 15) {
/*      */         this.master = 2;
/*      */         String wish = "jinryuudragonbc:saa.png";
/*      */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */         ResourceLocation tx = new ResourceLocation(wish);
/*      */         this.mc.field_71446_o.func_110577_a(tx);
/*      */         func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*      */         int nr = 0;
/*      */         this.Process = StatCollector.func_74838_a(JRMCoreH.Masters[2]);
/*      */         nr += JRMCoreH.txt(this.Process, "§8", 0, true, guiLeft + 6, guiTop + 5 + nr * 10, 0);
/*      */         this.Process = StatCollector.func_74838_a("dbc.talkgui.roshi.goodneut");
/*      */         nr += JRMCoreH.txt(this.Process, "§0", 5, true, guiLeft + 6, guiTop + 5 + nr * 10, 0);
/*      */         int line = 0;
/*      */         if (JRMCoreH.align > 32) {
/*      */           if (JRMCoreH.Master == 1) {
/*      */             String str1 = JRMCoreH.trl("dbc.talkgui.learntechs");
/*      */             int j = this.field_146289_q.func_78256_a(str1) + 8;
/*      */             this.field_146292_n.add(new DBCGuiButtons01((this.wish + 10100) * 10 + 1, posX + 115 - j, posY + 15 + line * 21, j, 20, str1));
/*      */             line++;
/*      */           } 
/*      */           String str = JRMCoreH.trl("dbc.talkgui.skills");
/*      */           int i = this.field_146289_q.func_78256_a(str) + 8;
/*      */           this.field_146292_n.add(new DBCGuiButtons01(this.wish + 10100, posX + 115 - i, posY + 15 + line * 21, i, 20, str));
/*      */           line++;
/*      */         } 
/*      */         line = 0;
/*      */         String n = JRMCoreH.trl("dbc.talkgui.giveweights");
/*      */         int nw = this.field_146289_q.func_78256_a(n) + 8;
/*      */         this.field_146292_n.add(new DBCGuiButtons01(110, posX - 115 - 0, posY + 15 + line * 21, nw, 20, n));
/*      */         line++;
/*      */         this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
/*      */       } else if (this.wish == 115) {
/*      */         this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
/*      */         String wish = "jinryuudragonbc:saa.png";
/*      */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */         ResourceLocation tx = new ResourceLocation(wish);
/*      */         this.mc.field_71446_o.func_110577_a(tx);
/*      */         func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*      */         posX = this.field_146294_l / 2;
/*      */         posY = this.field_146295_m / 2;
/*      */         int m = JRMCoreH.skillSlot_SpentMindRequirement(JRMCoreH.PlyrSkills, JRMCoreH.DBCSkillsIDs, JRMCoreH.DBCSkillMindCost) + JRMCoreH.skillSlot_SpentMindRequirement_X(JRMCoreH.PlyrSkillX, JRMCoreH.Race, JRMCoreH.DBCRacialSkillMindCost);
/*      */         int ml = JRMCoreH.statMindC() - m;
/*      */         var8.func_78276_b(JRMCoreH.trl("jrmc", "AvailableMind") + ": " + JRMCoreH.numSep(ml), guiLeft + 5, guiTop + 15, 0);
/*      */         var8.func_78276_b("TP: " + JRMCoreH.numSep(JRMCoreH.curTP), guiLeft + 5, guiTop + 5, 0);
/*      */         int i = 0;
/*      */         sklLrn(1, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */         sklLrn(2, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */         sklLrn(3, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */       } else if (this.wish == 1151) {
/*      */         this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
/*      */         String wish = "jinryuudragonbc:saa.png";
/*      */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */         ResourceLocation tx = new ResourceLocation(wish);
/*      */         this.mc.field_71446_o.func_110577_a(tx);
/*      */         func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*      */         posX = this.field_146294_l / 2;
/*      */         posY = this.field_146295_m / 2;
/*      */         String[][] PMA = JRMCoreH.pmdbc;
/*      */         var8.func_78276_b(JRMCoreH.numSep(JRMCoreH.curTP) + " " + "Training Points", guiLeft + 10, guiTop + 5, 0);
/*      */         int i2 = 0;
/*      */         int nms = PMA.length;
/*      */         byte i;
/*      */         for (i = 0; i < nms; i = (byte)(i + 1)) {
/*      */           if (Integer.parseInt(PMA[i][2]) == 2 || Integer.parseInt(PMA[i][2]) == 1) {
/*      */             if (i2 <= 13 + this.ipg * 13 && i2 >= 0 + this.ipg * 13) {
/*      */               String fn = JRMCoreH.trl("dbc", PMA[i][0]);
/*      */               int fnw = this.fontRenderer.func_78256_a(fn);
/*      */               var8.func_78276_b(fn, guiLeft + xSize / 2 - 122, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, 0);
/*      */               String on = JRMCoreH.techOwnd(i, (byte)1) ? " Owned" : "";
/*      */               int onw = this.fontRenderer.func_78256_a(on);
/*      */               var8.func_78276_b(on, guiLeft + xSize / 2 - 122 + fnw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[1]);
/*      */               if (!JRMCoreH.techOwnd(i, (byte)1)) {
/*      */                 int costTp = (int)(JRMCoreH.techDBCtpc(PMA[i]) * 0.9F);
/*      */                 int cost = costTp;
/*      */                 String n = " " + cost + " tp";
/*      */                 int nw = this.fontRenderer.func_78256_a(fn);
/*      */                 if (JRMCoreH.curTP >= cost) {
/*      */                   this.field_146292_n.add(new JRMCoreGuiButtons01(!JRMCoreH.techOwnd(i, (byte)1) ? (4200 + i) : -1, guiLeft + xSize / 2 - 122 + fnw + onw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, nw, n, JRMCoreH.techNCCol[1]));
/*      */                 } else {
/*      */                   var8.func_78276_b(n, guiLeft + xSize / 2 - 122 + fnw + onw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[0]);
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */             i2++;
/*      */           } 
/*      */         } 
/*      */       } else if (this.wish == 16) {
/*      */         this.master = 12;
/*      */         String wish = "jinryuudragonbc:saa.png";
/*      */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */         ResourceLocation tx = new ResourceLocation(wish);
/*      */         this.mc.field_71446_o.func_110577_a(tx);
/*      */         func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*      */         int nr = 0;
/*      */         this.Process = StatCollector.func_74838_a(JRMCoreH.Masters[12]);
/*      */         nr += JRMCoreH.txt(this.Process, "§8", 0, true, guiLeft + 6, guiTop + 5 + nr * 10, 0);
/*      */         if (JRMCoreH.align <= 32) {
/*      */           this.Process = StatCollector.func_74838_a("dbc.talkgui.cell.evil");
/*      */           nr += JRMCoreH.txt(this.Process, "§0", 5, true, guiLeft + 6, guiTop + 5 + nr * 10, 0);
/*      */           if (JRMCoreH.Master == 1) {
/*      */             String str = JRMCoreH.trl("dbc.talkgui.learntechs");
/*      */             int i = this.field_146289_q.func_78256_a(str) + 8;
/*      */             this.field_146292_n.add(new DBCGuiButtons01((this.wish + 10100) * 10 + 1, posX + 15 - i / 2, posY + 35, i, 20, str));
/*      */           } 
/*      */           String n = JRMCoreH.trl("dbc.talkgui.skills");
/*      */           int nw = this.field_146289_q.func_78256_a(n) + 8;
/*      */           this.field_146292_n.add(new DBCGuiButtons01(this.wish + 10100, posX + 15 - nw / 2, posY + 55, nw, 20, n));
/*      */         } else {
/*      */           this.Process = StatCollector.func_74838_a("dbc.talkgui.cell.goodneut");
/*      */           nr += JRMCoreH.txt(this.Process, "§0", 5, true, guiLeft + 6, guiTop + 5 + nr * 10, 0);
/*      */         } 
/*      */         this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
/*      */       } else if (this.wish == 116) {
/*      */         this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
/*      */         String wish = "jinryuudragonbc:saa.png";
/*      */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */         ResourceLocation tx = new ResourceLocation(wish);
/*      */         this.mc.field_71446_o.func_110577_a(tx);
/*      */         func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*      */         posX = this.field_146294_l / 2;
/*      */         posY = this.field_146295_m / 2;
/*      */         int m = JRMCoreH.skillSlot_SpentMindRequirement(JRMCoreH.PlyrSkills, JRMCoreH.DBCSkillsIDs, JRMCoreH.DBCSkillMindCost) + JRMCoreH.skillSlot_SpentMindRequirement_X(JRMCoreH.PlyrSkillX, JRMCoreH.Race, JRMCoreH.DBCRacialSkillMindCost);
/*      */         int ml = JRMCoreH.statMindC() - m;
/*      */         var8.func_78276_b(JRMCoreH.trl("jrmc", "AvailableMind") + ": " + JRMCoreH.numSep(ml), guiLeft + 5, guiTop + 15, 0);
/*      */         var8.func_78276_b("TP: " + JRMCoreH.numSep(JRMCoreH.curTP), guiLeft + 5, guiTop + 5, 0);
/*      */         int i = 0;
/*      */         sklLrn(5, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */         sklLrn(4, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */         sklLrn(6, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */         sklLrn(11, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */         sklLrn(12, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */         sklLrn(17, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */       } else if (this.wish == 1161) {
/*      */         this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
/*      */         String wish = "jinryuudragonbc:saa.png";
/*      */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */         ResourceLocation tx = new ResourceLocation(wish);
/*      */         this.mc.field_71446_o.func_110577_a(tx);
/*      */         func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*      */         posX = this.field_146294_l / 2;
/*      */         posY = this.field_146295_m / 2;
/*      */         String[][] PMA = JRMCoreH.pmdbc;
/*      */         var8.func_78276_b(JRMCoreH.numSep(JRMCoreH.curTP) + " " + "Training Points", guiLeft + 10, guiTop + 5, 0);
/*      */         int i2 = 0;
/*      */         int nms = PMA.length;
/*      */         byte i;
/*      */         for (i = 0; i < nms; i = (byte)(i + 1)) {
/*      */           int owner = Integer.parseInt(PMA[i][2]);
/*      */           if (owner == 2 || owner == 1 || owner == 7 || owner == 8 || owner == 9 || owner == 11) {
/*      */             if (i2 <= 13 + this.ipg * 13 && i2 >= 0 + this.ipg * 13) {
/*      */               String fn = JRMCoreH.trl("dbc", PMA[i][0]);
/*      */               int fnw = this.fontRenderer.func_78256_a(fn);
/*      */               var8.func_78276_b(fn, guiLeft + xSize / 2 - 122, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, 0);
/*      */               String on = JRMCoreH.techOwnd(i, (byte)1) ? " Owned" : "";
/*      */               int onw = this.fontRenderer.func_78256_a(on);
/*      */               var8.func_78276_b(on, guiLeft + xSize / 2 - 122 + fnw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[1]);
/*      */               if (!JRMCoreH.techOwnd(i, (byte)1)) {
/*      */                 int costTp = (int)(JRMCoreH.techDBCtpc(PMA[i]) * 0.9F);
/*      */                 int cost = costTp;
/*      */                 String n = " " + cost + " tp";
/*      */                 int nw = this.fontRenderer.func_78256_a(fn);
/*      */                 if (JRMCoreH.curTP >= cost) {
/*      */                   this.field_146292_n.add(new JRMCoreGuiButtons01(!JRMCoreH.techOwnd(i, (byte)1) ? (4200 + i) : -1, guiLeft + xSize / 2 - 122 + fnw + onw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, nw, n, JRMCoreH.techNCCol[1]));
/*      */                 } else {
/*      */                   var8.func_78276_b(n, guiLeft + xSize / 2 - 122 + fnw + onw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[0]);
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */             i2++;
/*      */           } 
/*      */         } 
/*      */       } else if (this.wish == 17) {
/*      */         this.master = 13;
/*      */         String wish = "jinryuudragonbc:saa.png";
/*      */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */         ResourceLocation tx = new ResourceLocation(wish);
/*      */         this.mc.field_71446_o.func_110577_a(tx);
/*      */         func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*      */         int nr = 0;
/*      */         this.Process = StatCollector.func_74838_a(JRMCoreH.Masters[13]);
/*      */         nr += JRMCoreH.txt(this.Process, "§8", 0, true, guiLeft + 6, guiTop + 5 + nr * 10, 0);
/*      */         if (JRMCoreH.align > 32) {
/*      */           this.Process = StatCollector.func_74838_a("dbc.talkgui.songoku.goodneut");
/*      */           nr += JRMCoreH.txt(this.Process, "§0", 5, true, guiLeft + 6, guiTop + 5 + nr * 10, 0);
/*      */           if (JRMCoreH.Master == 1) {
/*      */             String str = JRMCoreH.trl("dbc.talkgui.learntechs");
/*      */             int i = this.field_146289_q.func_78256_a(str) + 8;
/*      */             this.field_146292_n.add(new DBCGuiButtons01((this.wish + 10100) * 10 + 1, posX + 15 - i / 2, posY + 35, i, 20, str));
/*      */           } 
/*      */           String n = JRMCoreH.trl("dbc.talkgui.skills");
/*      */           int nw = this.field_146289_q.func_78256_a(n) + 8;
/*      */           this.field_146292_n.add(new DBCGuiButtons01(this.wish + 10100, posX + 15 - nw / 2, posY + 55, nw, 20, n));
/*      */         } else {
/*      */           this.Process = StatCollector.func_74838_a("dbc.talkgui.songoku.evil");
/*      */           nr += JRMCoreH.txt(this.Process, "§0", 5, true, guiLeft + 6, guiTop + 5 + nr * 10, 0);
/*      */         } 
/*      */         this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
/*      */       } else if (this.wish == 117) {
/*      */         this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
/*      */         String wish = "jinryuudragonbc:saa.png";
/*      */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */         ResourceLocation tx = new ResourceLocation(wish);
/*      */         this.mc.field_71446_o.func_110577_a(tx);
/*      */         func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*      */         posX = this.field_146294_l / 2;
/*      */         posY = this.field_146295_m / 2;
/*      */         int ml = JRMCoreH.skillSlot_AvailableMindLeft();
/*      */         var8.func_78276_b(JRMCoreH.trl("jrmc", "AvailableMind") + ": " + JRMCoreH.numSep(ml), guiLeft + 5, guiTop + 15, 0);
/*      */         var8.func_78276_b("TP: " + JRMCoreH.numSep(JRMCoreH.curTP), guiLeft + 5, guiTop + 5, 0);
/*      */         int i = 0;
/*      */         sklLrn(5, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */         sklLrn(6, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */         sklLrn(0, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */         sklLrn(14, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */         sklLrn(12, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */         sklLrn(17, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */       } else if (this.wish == 1171) {
/*      */         this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
/*      */         String wish = "jinryuudragonbc:saa.png";
/*      */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */         ResourceLocation tx = new ResourceLocation(wish);
/*      */         this.mc.field_71446_o.func_110577_a(tx);
/*      */         func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*      */         posX = this.field_146294_l / 2;
/*      */         posY = this.field_146295_m / 2;
/*      */         String[][] PMA = JRMCoreH.pmdbc;
/*      */         var8.func_78276_b(JRMCoreH.numSep(JRMCoreH.curTP) + " " + "Training Points", guiLeft + 10, guiTop + 5, 0);
/*      */         int i2 = 0;
/*      */         int nms = PMA.length;
/*      */         byte i;
/*      */         for (i = 0; i < nms; i = (byte)(i + 1)) {
/*      */           int owner = Integer.parseInt(PMA[i][2]);
/*      */           if (owner == 2 || owner == 1 || owner == 6 || owner == 7) {
/*      */             if (i2 <= 13 + this.ipg * 13 && i2 >= 0 + this.ipg * 13) {
/*      */               String fn = JRMCoreH.trl("dbc", PMA[i][0]);
/*      */               int fnw = this.fontRenderer.func_78256_a(fn);
/*      */               var8.func_78276_b(fn, guiLeft + xSize / 2 - 122, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, 0);
/*      */               String on = JRMCoreH.techOwnd(i, (byte)1) ? " Owned" : "";
/*      */               int onw = this.fontRenderer.func_78256_a(on);
/*      */               var8.func_78276_b(on, guiLeft + xSize / 2 - 122 + fnw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[1]);
/*      */               if (!JRMCoreH.techOwnd(i, (byte)1)) {
/*      */                 int costTp = (int)(JRMCoreH.techDBCtpc(PMA[i]) * 0.9F);
/*      */                 int cost = costTp;
/*      */                 String n = " " + cost + " tp";
/*      */                 int nw = this.fontRenderer.func_78256_a(fn);
/*      */                 if (JRMCoreH.curTP >= cost) {
/*      */                   this.field_146292_n.add(new JRMCoreGuiButtons01(!JRMCoreH.techOwnd(i, (byte)1) ? (4200 + i) : -1, guiLeft + xSize / 2 - 122 + fnw + onw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, nw, n, JRMCoreH.techNCCol[1]));
/*      */                 } else {
/*      */                   var8.func_78276_b(n, guiLeft + xSize / 2 - 122 + fnw + onw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[0]);
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */             i2++;
/*      */           } 
/*      */         } 
/*      */       } else if (this.wish == 18) {
/*      */         this.master = 11;
/*      */         String wish = "jinryuudragonbc:saa.png";
/*      */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */         ResourceLocation tx = new ResourceLocation(wish);
/*      */         this.mc.field_71446_o.func_110577_a(tx);
/*      */         func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*      */         int nr = 0;
/*      */         this.Process = StatCollector.func_74838_a(JRMCoreH.Masters[11]);
/*      */         nr += JRMCoreH.txt(this.Process, "§8", 0, true, guiLeft + 6, guiTop + 5 + nr * 10, 0);
/*      */         if (JRMCoreH.align <= 32) {
/*      */           this.Process = StatCollector.func_74838_a("dbc.talkgui.freeza.evil");
/*      */           nr += JRMCoreH.txt(this.Process, "§0", 5, true, guiLeft + 6, guiTop + 5 + nr * 10, 0);
/*      */           if (JRMCoreH.Master == 1) {
/*      */             String str = JRMCoreH.trl("dbc.talkgui.learntechs");
/*      */             int i = this.field_146289_q.func_78256_a(str) + 8;
/*      */             this.field_146292_n.add(new DBCGuiButtons01((this.wish + 10100) * 10 + 1, posX + 15 - i / 2, posY + 35, i, 20, str));
/*      */           } 
/*      */           String n = JRMCoreH.trl("dbc.talkgui.skills");
/*      */           int nw = this.field_146289_q.func_78256_a(n) + 8;
/*      */           this.field_146292_n.add(new DBCGuiButtons01(this.wish + 10100, posX + 15 - nw / 2, posY + 55, nw, 20, n));
/*      */         } else {
/*      */           this.Process = StatCollector.func_74838_a("dbc.talkgui.freeza.else");
/*      */           nr += JRMCoreH.txt(this.Process, "§0", 5, true, guiLeft + 6, guiTop + 5 + nr * 10, 0);
/*      */         } 
/*      */         this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
/*      */       } else if (this.wish == 118) {
/*      */         this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
/*      */         String wish = "jinryuudragonbc:saa.png";
/*      */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */         ResourceLocation tx = new ResourceLocation(wish);
/*      */         this.mc.field_71446_o.func_110577_a(tx);
/*      */         func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*      */         posX = this.field_146294_l / 2;
/*      */         posY = this.field_146295_m / 2;
/*      */         int m = JRMCoreH.skillSlot_SpentMindRequirement(JRMCoreH.PlyrSkills, JRMCoreH.DBCSkillsIDs, JRMCoreH.DBCSkillMindCost) + JRMCoreH.skillSlot_SpentMindRequirement_X(JRMCoreH.PlyrSkillX, JRMCoreH.Race, JRMCoreH.DBCRacialSkillMindCost);
/*      */         int ml = JRMCoreH.statMindC() - m;
/*      */         var8.func_78276_b(JRMCoreH.trl("jrmc", "AvailableMind") + ": " + JRMCoreH.numSep(ml), guiLeft + 5, guiTop + 15, 0);
/*      */         var8.func_78276_b("TP: " + JRMCoreH.numSep(JRMCoreH.curTP), guiLeft + 5, guiTop + 5, 0);
/*      */         int i = 0;
/*      */         sklLrn(1, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */         sklLrn(2, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */         sklLrn(3, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */         sklLrn(5, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */         sklLrn(4, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */       } else if (this.wish == 1181) {
/*      */         this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
/*      */         String wish = "jinryuudragonbc:saa.png";
/*      */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */         ResourceLocation tx = new ResourceLocation(wish);
/*      */         this.mc.field_71446_o.func_110577_a(tx);
/*      */         func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*      */         posX = this.field_146294_l / 2;
/*      */         posY = this.field_146295_m / 2;
/*      */         String[][] PMA = JRMCoreH.pmdbc;
/*      */         var8.func_78276_b(JRMCoreH.numSep(JRMCoreH.curTP) + " " + "Training Points", guiLeft + 10, guiTop + 5, 0);
/*      */         int i2 = 0;
/*      */         int nms = PMA.length;
/*      */         byte i;
/*      */         for (i = 0; i < nms; i = (byte)(i + 1)) {
/*      */           int owner = Integer.parseInt(PMA[i][2]);
/*      */           if (owner == 1 || owner == 11) {
/*      */             if (i2 <= 13 + this.ipg * 13 && i2 >= 0 + this.ipg * 13) {
/*      */               String fn = JRMCoreH.trl("dbc", PMA[i][0]);
/*      */               int fnw = this.fontRenderer.func_78256_a(fn);
/*      */               var8.func_78276_b(fn, guiLeft + xSize / 2 - 122, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, 0);
/*      */               String on = JRMCoreH.techOwnd(i, (byte)1) ? " Owned" : "";
/*      */               int onw = this.fontRenderer.func_78256_a(on);
/*      */               var8.func_78276_b(on, guiLeft + xSize / 2 - 122 + fnw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[1]);
/*      */               if (!JRMCoreH.techOwnd(i, (byte)1)) {
/*      */                 int costTp = (int)(JRMCoreH.techDBCtpc(PMA[i]) * 0.9F);
/*      */                 int cost = costTp;
/*      */                 String n = " " + cost + " tp";
/*      */                 int nw = this.fontRenderer.func_78256_a(fn);
/*      */                 if (JRMCoreH.curTP >= cost) {
/*      */                   this.field_146292_n.add(new JRMCoreGuiButtons01(!JRMCoreH.techOwnd(i, (byte)1) ? (4200 + i) : -1, guiLeft + xSize / 2 - 122 + fnw + onw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, nw, n, JRMCoreH.techNCCol[1]));
/*      */                 } else {
/*      */                   var8.func_78276_b(n, guiLeft + xSize / 2 - 122 + fnw + onw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[0]);
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */             i2++;
/*      */           } 
/*      */         } 
/*      */       } else if (this.wish == 19) {
/*      */         this.master = 15;
/*      */         String wish = "jinryuudragonbc:saa.png";
/*      */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */         ResourceLocation tx = new ResourceLocation(wish);
/*      */         this.mc.field_71446_o.func_110577_a(tx);
/*      */         func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*      */         int nr = 0;
/*      */         this.Process = StatCollector.func_74838_a(JRMCoreH.Masters[15]);
/*      */         nr += JRMCoreH.txt(this.Process, "§8", 0, true, guiLeft + 6, guiTop + 5 + nr * 10, 0);
/*      */         int ln = 0;
/*      */         if (JRMCoreH.align <= 65) {
/*      */           this.Process = StatCollector.func_74838_a("dbc.talkgui.babidi.evilneut");
/*      */           nr += JRMCoreH.txt(this.Process, "§0", 5, true, guiLeft + 6, guiTop + 5 + nr * 10, 0);
/*      */           if (JRMCoreH.Master == 1) {
/*      */             String str = JRMCoreH.trl("dbc.talkgui.learntechs");
/*      */             int i = this.field_146289_q.func_78256_a(str) + 8;
/*      */             this.field_146292_n.add(new DBCGuiButtons01((this.wish + 10100) * 10 + 1, posX + 15 - i / 2, posY + 15 + ln * 20, i, 20, str));
/*      */             ln++;
/*      */           } 
/*      */           String n = JRMCoreH.trl("dbc.talkgui.skills");
/*      */           int nw = this.field_146289_q.func_78256_a(n) + 8;
/*      */           this.field_146292_n.add(new DBCGuiButtons01(this.wish + 10100, posX + 15 - nw / 2, posY + 15 + ln * 20, nw, 20, n));
/*      */           ln++;
/*      */           if (!JRMCoreH.StusEfctsMe(12)) {
/*      */             n = JRMCoreH.trl("dbc", "majinGet");
/*      */             nw = this.field_146289_q.func_78256_a(n) + 8;
/*      */             this.field_146292_n.add(new DBCGuiButtons01(51, posX + 15 - nw / 2, posY + 15 + ln * 20, nw, 20, n));
/*      */             ln++;
/*      */           } 
/*      */         } else if (JRMCoreH.align == 100) {
/*      */           this.Process = StatCollector.func_74838_a("dbc.talkgui.babidi.fullgood");
/*      */           nr += JRMCoreH.txt(this.Process, "§0", 5, true, guiLeft + 6, guiTop + 5 + nr * 10, 0);
/*      */         } else {
/*      */           this.Process = StatCollector.func_74838_a("dbc.talkgui.babidi.good");
/*      */           nr += JRMCoreH.txt(this.Process, "§0", 5, true, guiLeft + 6, guiTop + 5 + nr * 10, 0);
/*      */           if (!JRMCoreH.StusEfctsMe(12)) {
/*      */             String n = JRMCoreH.trl("dbc", "majinGet");
/*      */             int nw = this.field_146289_q.func_78256_a(n) + 8;
/*      */             this.field_146292_n.add(new DBCGuiButtons01(51, posX + 15 - nw / 2, posY + 15 + ln * 20, nw, 20, n));
/*      */             ln++;
/*      */           } 
/*      */         } 
/*      */         this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
/*      */       } else if (this.wish == 119) {
/*      */         this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
/*      */         String wish = "jinryuudragonbc:saa.png";
/*      */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */         ResourceLocation tx = new ResourceLocation(wish);
/*      */         this.mc.field_71446_o.func_110577_a(tx);
/*      */         func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*      */         posX = this.field_146294_l / 2;
/*      */         posY = this.field_146295_m / 2;
/*      */         int m = JRMCoreH.skillSlot_SpentMindRequirement(JRMCoreH.PlyrSkills, JRMCoreH.DBCSkillsIDs, JRMCoreH.DBCSkillMindCost) + JRMCoreH.skillSlot_SpentMindRequirement_X(JRMCoreH.PlyrSkillX, JRMCoreH.Race, JRMCoreH.DBCRacialSkillMindCost);
/*      */         int ml = JRMCoreH.statMindC() - m;
/*      */         var8.func_78276_b(JRMCoreH.trl("jrmc", "AvailableMind") + ": " + JRMCoreH.numSep(ml), guiLeft + 5, guiTop + 15, 0);
/*      */         var8.func_78276_b("TP: " + JRMCoreH.numSep(JRMCoreH.curTP), guiLeft + 5, guiTop + 5, 0);
/*      */         int i = 0;
/*      */         sklLrn(1, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */         sklLrn(2, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */         sklLrn(3, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */         sklLrn(5, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */         sklLrn(4, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */       } else if (this.wish == 1191) {
/*      */         this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
/*      */         String wish = "jinryuudragonbc:saa.png";
/*      */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */         ResourceLocation tx = new ResourceLocation(wish);
/*      */         this.mc.field_71446_o.func_110577_a(tx);
/*      */         func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*      */         posX = this.field_146294_l / 2;
/*      */         posY = this.field_146295_m / 2;
/*      */         String[][] PMA = JRMCoreH.pmdbc;
/*      */         var8.func_78276_b(JRMCoreH.numSep(JRMCoreH.curTP) + " " + "Training Points", guiLeft + 10, guiTop + 5, 0);
/*      */         int i2 = 0;
/*      */         int nms = PMA.length;
/*      */         byte i;
/*      */         for (i = 0; i < nms; i = (byte)(i + 1)) {
/*      */           int owner = Integer.parseInt(PMA[i][2]);
/*      */           if (owner == 1) {
/*      */             if (i2 <= 13 + this.ipg * 13 && i2 >= 0 + this.ipg * 13) {
/*      */               String fn = JRMCoreH.trl("dbc", PMA[i][0]);
/*      */               int fnw = this.fontRenderer.func_78256_a(fn);
/*      */               var8.func_78276_b(fn, guiLeft + xSize / 2 - 122, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, 0);
/*      */               String on = JRMCoreH.techOwnd(i, (byte)1) ? " Owned" : "";
/*      */               int onw = this.fontRenderer.func_78256_a(on);
/*      */               var8.func_78276_b(on, guiLeft + xSize / 2 - 122 + fnw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[1]);
/*      */               if (!JRMCoreH.techOwnd(i, (byte)1)) {
/*      */                 int costTp = (int)(JRMCoreH.techDBCtpc(PMA[i]) * 0.9F);
/*      */                 int cost = costTp;
/*      */                 String n = " " + cost + " tp";
/*      */                 int nw = this.fontRenderer.func_78256_a(fn);
/*      */                 if (JRMCoreH.curTP >= cost) {
/*      */                   this.field_146292_n.add(new JRMCoreGuiButtons01(!JRMCoreH.techOwnd(i, (byte)1) ? (4200 + i) : -1, guiLeft + xSize / 2 - 122 + fnw + onw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, nw, n, JRMCoreH.techNCCol[1]));
/*      */                 } else {
/*      */                   var8.func_78276_b(n, guiLeft + xSize / 2 - 122 + fnw + onw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[0]);
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */             i2++;
/*      */           } 
/*      */         } 
/*      */       } else if (this.wish == 20) {
/*      */         this.master = 8;
/*      */         String wish = "jinryuudragonbc:saa.png";
/*      */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */         ResourceLocation tx = new ResourceLocation(wish);
/*      */         this.mc.field_71446_o.func_110577_a(tx);
/*      */         func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*      */         int nr = 0;
/*      */         this.Process = StatCollector.func_74838_a(JRMCoreH.Masters[this.master]);
/*      */         nr += JRMCoreH.txt(this.Process, "§8", 0, true, guiLeft + 6, guiTop + 5 + nr * 10, 0);
/*      */         int line = 0;
/*      */         if (JRMCoreH.align > 32) {
/*      */           this.Process = StatCollector.func_74838_a("dbc.talkgui.piccolo.goodneut");
/*      */           nr += JRMCoreH.txt(this.Process, "§0", 5, true, guiLeft + 6, guiTop + 5 + nr * 10, 0);
/*      */           if (JRMCoreH.Master == 1) {
/*      */             String str = JRMCoreH.trl("dbc.talkgui.learntechs");
/*      */             int i = this.field_146289_q.func_78256_a(str) + 8;
/*      */             this.field_146292_n.add(new DBCGuiButtons01((this.wish + 10100) * 10 + 1, posX + 115 - i, posY + 15 + line * 21, i, 20, str));
/*      */             line++;
/*      */           } 
/*      */           String n = JRMCoreH.trl("dbc.talkgui.skills");
/*      */           int nw = this.field_146289_q.func_78256_a(n) + 8;
/*      */           this.field_146292_n.add(new DBCGuiButtons01(this.wish + 10100, posX + 115 - nw, posY + 15 + line * 21, nw, 20, n));
/*      */           line++;
/*      */           line = 0;
/*      */           n = JRMCoreH.trl("dbc.talkgui.giveweights");
/*      */           nw = this.field_146289_q.func_78256_a(n) + 8;
/*      */           this.field_146292_n.add(new DBCGuiButtons01(110, posX - 115 - 0, posY + 15 + line * 21, nw, 20, n));
/*      */           line++;
/*      */         } else {
/*      */           this.Process = StatCollector.func_74838_a("dbc.talkgui.piccolo.evil");
/*      */           nr += JRMCoreH.txt(this.Process, "§0", 5, true, guiLeft + 6, guiTop + 5 + nr * 10, 0);
/*      */         } 
/*      */         this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
/*      */       } else if (this.wish == 120) {
/*      */         this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
/*      */         String wish = "jinryuudragonbc:saa.png";
/*      */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */         ResourceLocation tx = new ResourceLocation(wish);
/*      */         this.mc.field_71446_o.func_110577_a(tx);
/*      */         func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*      */         posX = this.field_146294_l / 2;
/*      */         posY = this.field_146295_m / 2;
/*      */         int m = JRMCoreH.skillSlot_SpentMindRequirement(JRMCoreH.PlyrSkills, JRMCoreH.DBCSkillsIDs, JRMCoreH.DBCSkillMindCost) + JRMCoreH.skillSlot_SpentMindRequirement_X(JRMCoreH.PlyrSkillX, JRMCoreH.Race, JRMCoreH.DBCRacialSkillMindCost);
/*      */         int ml = JRMCoreH.statMindC() - m;
/*      */         var8.func_78276_b(JRMCoreH.trl("jrmc", "AvailableMind") + ": " + JRMCoreH.numSep(ml), guiLeft + 5, guiTop + 15, 0);
/*      */         var8.func_78276_b("TP: " + JRMCoreH.numSep(JRMCoreH.curTP), guiLeft + 5, guiTop + 5, 0);
/*      */         int i = 0;
/*      */         sklLrn(3, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */         sklLrn(5, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */         sklLrn(7, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */         sklLrn(6, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */         sklLrn(11, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */         sklLrn(12, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */       } else if (this.wish == 1201) {
/*      */         this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
/*      */         String wish = "jinryuudragonbc:saa.png";
/*      */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */         ResourceLocation tx = new ResourceLocation(wish);
/*      */         this.mc.field_71446_o.func_110577_a(tx);
/*      */         func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*      */         posX = this.field_146294_l / 2;
/*      */         posY = this.field_146295_m / 2;
/*      */         String[][] PMA = JRMCoreH.pmdbc;
/*      */         var8.func_78276_b(JRMCoreH.numSep(JRMCoreH.curTP) + " " + "Training Points", guiLeft + 10, guiTop + 5, 0);
/*      */         int i2 = 0;
/*      */         int nms = PMA.length;
/*      */         byte i;
/*      */         for (i = 0; i < nms; i = (byte)(i + 1)) {
/*      */           int owner = Integer.parseInt(PMA[i][2]);
/*      */           if (owner == 1 || owner == 7 || owner == 8) {
/*      */             if (i2 <= 13 + this.ipg * 13 && i2 >= 0 + this.ipg * 13) {
/*      */               String fn = JRMCoreH.trl("dbc", PMA[i][0]);
/*      */               int fnw = this.fontRenderer.func_78256_a(fn);
/*      */               var8.func_78276_b(fn, guiLeft + xSize / 2 - 122, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, 0);
/*      */               String on = JRMCoreH.techOwnd(i, (byte)1) ? " Owned" : "";
/*      */               int onw = this.fontRenderer.func_78256_a(on);
/*      */               var8.func_78276_b(on, guiLeft + xSize / 2 - 122 + fnw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[1]);
/*      */               if (!JRMCoreH.techOwnd(i, (byte)1)) {
/*      */                 int costTp = (int)(JRMCoreH.techDBCtpc(PMA[i]) * 0.9F);
/*      */                 int cost = costTp;
/*      */                 String n = " " + cost + " tp";
/*      */                 int nw = this.fontRenderer.func_78256_a(fn);
/*      */                 if (JRMCoreH.curTP >= cost) {
/*      */                   this.field_146292_n.add(new JRMCoreGuiButtons01(!JRMCoreH.techOwnd(i, (byte)1) ? (4200 + i) : -1, guiLeft + xSize / 2 - 122 + fnw + onw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, nw, n, JRMCoreH.techNCCol[1]));
/*      */                 } else {
/*      */                   var8.func_78276_b(n, guiLeft + xSize / 2 - 122 + fnw + onw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[0]);
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */             i2++;
/*      */           } 
/*      */         } 
/*      */       } else if (this.wish == 21) {
/*      */         this.master = 9;
/*      */         String wish = "jinryuudragonbc:saa.png";
/*      */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */         ResourceLocation tx = new ResourceLocation(wish);
/*      */         this.mc.field_71446_o.func_110577_a(tx);
/*      */         func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*      */         int nr = 0;
/*      */         this.Process = StatCollector.func_74838_a(JRMCoreH.Masters[this.master]);
/*      */         nr += JRMCoreH.txt(this.Process, "§8", 0, true, guiLeft + 6, guiTop + 5 + nr * 10, 0);
/*      */         if (JRMCoreH.align > 32) {
/*      */           this.Process = StatCollector.func_74838_a("dbc.talkgui.vegeta.goodneut");
/*      */           nr += JRMCoreH.txt(this.Process, "§0", 5, true, guiLeft + 6, guiTop + 5 + nr * 10, 0);
/*      */           if (JRMCoreH.Master == 1) {
/*      */             String str = JRMCoreH.trl("dbc.talkgui.learntechs");
/*      */             int i = this.field_146289_q.func_78256_a(str) + 8;
/*      */             this.field_146292_n.add(new DBCGuiButtons01((this.wish + 10100) * 10 + 1, posX + 15 - i / 2, posY + 35, i, 20, str));
/*      */           } 
/*      */           String n = JRMCoreH.trl("dbc.talkgui.skills");
/*      */           int nw = this.field_146289_q.func_78256_a(n) + 8;
/*      */           this.field_146292_n.add(new DBCGuiButtons01(this.wish + 10100, posX + 15 - nw / 2, posY + 55, nw, 20, n));
/*      */         } else {
/*      */           this.Process = StatCollector.func_74838_a("dbc.talkgui.vegeta.evil");
/*      */           nr += JRMCoreH.txt(this.Process, "§0", 5, true, guiLeft + 6, guiTop + 5 + nr * 10, 0);
/*      */         } 
/*      */         this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
/*      */       } else if (this.wish == 121) {
/*      */         this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
/*      */         String wish = "jinryuudragonbc:saa.png";
/*      */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */         ResourceLocation tx = new ResourceLocation(wish);
/*      */         this.mc.field_71446_o.func_110577_a(tx);
/*      */         func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*      */         posX = this.field_146294_l / 2;
/*      */         posY = this.field_146295_m / 2;
/*      */         int m = JRMCoreH.skillSlot_SpentMindRequirement(JRMCoreH.PlyrSkills, JRMCoreH.DBCSkillsIDs, JRMCoreH.DBCSkillMindCost) + JRMCoreH.skillSlot_SpentMindRequirement_X(JRMCoreH.PlyrSkillX, JRMCoreH.Race, JRMCoreH.DBCRacialSkillMindCost);
/*      */         int ml = JRMCoreH.statMindC() - m;
/*      */         var8.func_78276_b(JRMCoreH.trl("jrmc", "AvailableMind") + ": " + JRMCoreH.numSep(ml), guiLeft + 5, guiTop + 15, 0);
/*      */         var8.func_78276_b("TP: " + JRMCoreH.numSep(JRMCoreH.curTP), guiLeft + 5, guiTop + 5, 0);
/*      */         int i = 0;
/*      */         sklLrn(2, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */         sklLrn(5, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */         sklLrn(4, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */       } else if (this.wish == 1211) {
/*      */         this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
/*      */         String wish = "jinryuudragonbc:saa.png";
/*      */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */         ResourceLocation tx = new ResourceLocation(wish);
/*      */         this.mc.field_71446_o.func_110577_a(tx);
/*      */         func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*      */         posX = this.field_146294_l / 2;
/*      */         posY = this.field_146295_m / 2;
/*      */         String[][] PMA = JRMCoreH.pmdbc;
/*      */         var8.func_78276_b(JRMCoreH.numSep(JRMCoreH.curTP) + " " + "Training Points", guiLeft + 10, guiTop + 5, 0);
/*      */         int i2 = 0;
/*      */         int nms = PMA.length;
/*      */         byte i;
/*      */         for (i = 0; i < nms; i = (byte)(i + 1)) {
/*      */           int owner = Integer.parseInt(PMA[i][2]);
/*      */           if (owner == 1 || owner == 9) {
/*      */             if (i2 <= 13 + this.ipg * 13 && i2 >= 0 + this.ipg * 13) {
/*      */               String fn = JRMCoreH.trl("dbc", PMA[i][0]);
/*      */               int fnw = this.fontRenderer.func_78256_a(fn);
/*      */               var8.func_78276_b(fn, guiLeft + xSize / 2 - 122, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, 0);
/*      */               String on = JRMCoreH.techOwnd(i, (byte)1) ? " Owned" : "";
/*      */               int onw = this.fontRenderer.func_78256_a(on);
/*      */               var8.func_78276_b(on, guiLeft + xSize / 2 - 122 + fnw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[1]);
/*      */               if (!JRMCoreH.techOwnd(i, (byte)1)) {
/*      */                 int costTp = (int)(JRMCoreH.techDBCtpc(PMA[i]) * 0.9F);
/*      */                 int cost = costTp;
/*      */                 String n = " " + cost + " tp";
/*      */                 int nw = this.fontRenderer.func_78256_a(fn);
/*      */                 if (JRMCoreH.curTP >= cost) {
/*      */                   this.field_146292_n.add(new JRMCoreGuiButtons01(!JRMCoreH.techOwnd(i, (byte)1) ? (4200 + i) : -1, guiLeft + xSize / 2 - 122 + fnw + onw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, nw, n, JRMCoreH.techNCCol[1]));
/*      */                 } else {
/*      */                   var8.func_78276_b(n, guiLeft + xSize / 2 - 122 + fnw + onw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[0]);
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */             i2++;
/*      */           } 
/*      */         } 
/*      */       } else if (this.wish == 22) {
/*      */         this.master = 14;
/*      */         String wish = "jinryuudragonbc:saa.png";
/*      */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */         ResourceLocation tx = new ResourceLocation(wish);
/*      */         this.mc.field_71446_o.func_110577_a(tx);
/*      */         func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*      */         int nr = 0;
/*      */         this.Process = StatCollector.func_74838_a(JRMCoreH.Masters[14]);
/*      */         nr += JRMCoreH.txt(this.Process, "§8", 0, true, guiLeft + 6, guiTop + 5 + nr * 10, 0);
/*      */         if (JRMCoreH.align > 32) {
/*      */           this.Process = StatCollector.func_74838_a("dbc.talkgui.songohan.goodneut");
/*      */           nr += JRMCoreH.txt(this.Process, "§0", 5, true, guiLeft + 6, guiTop + 5 + nr * 10, 0);
/*      */           if (JRMCoreH.Master == 1) {
/*      */             String str = JRMCoreH.trl("dbc.talkgui.learntechs");
/*      */             int i = this.field_146289_q.func_78256_a(str) + 8;
/*      */             this.field_146292_n.add(new DBCGuiButtons01((this.wish + 10100) * 10 + 1, posX + 15 - i / 2, posY + 35, i, 20, str));
/*      */           } 
/*      */           String n = JRMCoreH.trl("dbc.talkgui.skills");
/*      */           int nw = this.field_146289_q.func_78256_a(n) + 8;
/*      */           this.field_146292_n.add(new DBCGuiButtons01(this.wish + 10100, posX + 15 - nw / 2, posY + 55, nw, 20, n));
/*      */         } else {
/*      */           this.Process = StatCollector.func_74838_a("dbc.talkgui.songohan.evil");
/*      */           nr += JRMCoreH.txt(this.Process, "§0", 5, true, guiLeft + 6, guiTop + 5 + nr * 10, 0);
/*      */         } 
/*      */         this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
/*      */       } else if (this.wish == 122) {
/*      */         this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
/*      */         String wish = "jinryuudragonbc:saa.png";
/*      */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */         ResourceLocation tx = new ResourceLocation(wish);
/*      */         this.mc.field_71446_o.func_110577_a(tx);
/*      */         func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*      */         posX = this.field_146294_l / 2;
/*      */         posY = this.field_146295_m / 2;
/*      */         int ml = JRMCoreH.skillSlot_AvailableMindLeft();
/*      */         var8.func_78276_b(JRMCoreH.trl("jrmc", "AvailableMind") + ": " + JRMCoreH.numSep(ml), guiLeft + 5, guiTop + 15, 0);
/*      */         var8.func_78276_b("TP: " + JRMCoreH.numSep(JRMCoreH.curTP), guiLeft + 5, guiTop + 5, 0);
/*      */         int i = 0;
/*      */         sklLrn(3, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */         sklLrn(6, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */         sklLrn(11, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */         sklLrn(15, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */       } else if (this.wish == 1221) {
/*      */         this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
/*      */         String wish = "jinryuudragonbc:saa.png";
/*      */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */         ResourceLocation tx = new ResourceLocation(wish);
/*      */         this.mc.field_71446_o.func_110577_a(tx);
/*      */         func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*      */         posX = this.field_146294_l / 2;
/*      */         posY = this.field_146295_m / 2;
/*      */         String[][] PMA = JRMCoreH.pmdbc;
/*      */         var8.func_78276_b(JRMCoreH.numSep(JRMCoreH.curTP) + " " + "Training Points", guiLeft + 10, guiTop + 5, 0);
/*      */         int i2 = 0;
/*      */         int nms = PMA.length;
/*      */         byte i;
/*      */         for (i = 0; i < nms; i = (byte)(i + 1)) {
/*      */           int owner = Integer.parseInt(PMA[i][2]);
/*      */           if (owner == 2 || owner == 1 || owner == 8 || owner == 14) {
/*      */             if (i2 <= 13 + this.ipg * 13 && i2 >= 0 + this.ipg * 13) {
/*      */               String fn = JRMCoreH.trl("dbc", PMA[i][0]);
/*      */               int fnw = this.fontRenderer.func_78256_a(fn);
/*      */               var8.func_78276_b(fn, guiLeft + xSize / 2 - 122, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, 0);
/*      */               String on = JRMCoreH.techOwnd(i, (byte)1) ? " Owned" : "";
/*      */               int onw = this.fontRenderer.func_78256_a(on);
/*      */               var8.func_78276_b(on, guiLeft + xSize / 2 - 122 + fnw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[1]);
/*      */               if (!JRMCoreH.techOwnd(i, (byte)1)) {
/*      */                 int costTp = (int)(JRMCoreH.techDBCtpc(PMA[i]) * 0.9F);
/*      */                 int cost = costTp;
/*      */                 String n = " " + cost + " tp";
/*      */                 int nw = this.fontRenderer.func_78256_a(fn);
/*      */                 if (JRMCoreH.curTP >= cost) {
/*      */                   this.field_146292_n.add(new JRMCoreGuiButtons01(!JRMCoreH.techOwnd(i, (byte)1) ? (4200 + i) : -1, guiLeft + xSize / 2 - 122 + fnw + onw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, nw, n, JRMCoreH.techNCCol[1]));
/*      */                 } else {
/*      */                   var8.func_78276_b(n, guiLeft + xSize / 2 - 122 + fnw + onw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[0]);
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */             i2++;
/*      */           } 
/*      */         } 
/*      */       } else if (this.wish == 23) {
/*      */         this.master = 10;
/*      */         String wish = "jinryuudragonbc:saa.png";
/*      */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */         ResourceLocation tx = new ResourceLocation(wish);
/*      */         this.mc.field_71446_o.func_110577_a(tx);
/*      */         func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*      */         int nr = 0;
/*      */         this.Process = StatCollector.func_74838_a(JRMCoreH.Masters[10]);
/*      */         nr += JRMCoreH.txt(this.Process, "§8", 0, true, guiLeft + 6, guiTop + 5 + nr * 10, 0);
/*      */         if (JRMCoreH.align > 32) {
/*      */           this.Process = StatCollector.func_74838_a("dbc.talkgui.songohan.goodneut");
/*      */           nr += JRMCoreH.txt(this.Process, "§0", 5, true, guiLeft + 6, guiTop + 5 + nr * 10, 0);
/*      */           if (JRMCoreH.Master == 1) {
/*      */             String str = JRMCoreH.trl("dbc.talkgui.learntechs");
/*      */             int i = this.field_146289_q.func_78256_a(str) + 8;
/*      */             this.field_146292_n.add(new DBCGuiButtons01((this.wish + 10100) * 10 + 1, posX + 15 - i / 2, posY + 35, i, 20, str));
/*      */           } 
/*      */           String n = JRMCoreH.trl("dbc.talkgui.skills");
/*      */           int nw = this.field_146289_q.func_78256_a(n) + 8;
/*      */           this.field_146292_n.add(new DBCGuiButtons01(this.wish + 10100, posX + 15 - nw / 2, posY + 55, nw, 20, n));
/*      */         } else {
/*      */           this.Process = StatCollector.func_74838_a("dbc.talkgui.songohan.evil");
/*      */           nr += JRMCoreH.txt(this.Process, "§0", 5, true, guiLeft + 6, guiTop + 5 + nr * 10, 0);
/*      */         } 
/*      */         this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
/*      */       } else if (this.wish == 123) {
/*      */         this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
/*      */         String wish = "jinryuudragonbc:saa.png";
/*      */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */         ResourceLocation tx = new ResourceLocation(wish);
/*      */         this.mc.field_71446_o.func_110577_a(tx);
/*      */         func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*      */         posX = this.field_146294_l / 2;
/*      */         posY = this.field_146295_m / 2;
/*      */         int ml = JRMCoreH.skillSlot_AvailableMindLeft();
/*      */         var8.func_78276_b(JRMCoreH.trl("jrmc", "AvailableMind") + ": " + JRMCoreH.numSep(ml), guiLeft + 5, guiTop + 15, 0);
/*      */         var8.func_78276_b("TP: " + JRMCoreH.numSep(JRMCoreH.curTP), guiLeft + 5, guiTop + 5, 0);
/*      */         int i = 0;
/*      */         sklLrn(3, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */         sklLrn(14, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */         sklLrn(12, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */         sklLrn(15, guiLeft + 5, guiTop + 25 + i * 21);
/*      */         i++;
/*      */       } else if (this.wish == 1231) {
/*      */         this.field_146292_n.add(new DBCGuiButtons01(-1, posX - 150, posY + 65, 20, 20, "X"));
/*      */         String wish = "jinryuudragonbc:saa.png";
/*      */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */         ResourceLocation tx = new ResourceLocation(wish);
/*      */         this.mc.field_71446_o.func_110577_a(tx);
/*      */         func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*      */         posX = this.field_146294_l / 2;
/*      */         posY = this.field_146295_m / 2;
/*      */         String[][] PMA = JRMCoreH.pmdbc;
/*      */         var8.func_78276_b(JRMCoreH.numSep(JRMCoreH.curTP) + " " + "Training Points", guiLeft + 10, guiTop + 5, 0);
/*      */         int i2 = 0;
/*      */         int nms = PMA.length;
/*      */         byte i;
/*      */         for (i = 0; i < nms; i = (byte)(i + 1)) {
/*      */           int owner = Integer.parseInt(PMA[i][2]);
/*      */           if (owner == 2 || owner == 1 || owner == 14 || owner == 10) {
/*      */             if (i2 <= 13 + this.ipg * 13 && i2 >= 0 + this.ipg * 13) {
/*      */               String fn = JRMCoreH.trl("dbc", PMA[i][0]);
/*      */               int fnw = this.fontRenderer.func_78256_a(fn);
/*      */               var8.func_78276_b(fn, guiLeft + xSize / 2 - 122, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, 0);
/*      */               String on = JRMCoreH.techOwnd(i, (byte)1) ? " Owned" : "";
/*      */               int onw = this.fontRenderer.func_78256_a(on);
/*      */               var8.func_78276_b(on, guiLeft + xSize / 2 - 122 + fnw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[1]);
/*      */               if (!JRMCoreH.techOwnd(i, (byte)1)) {
/*      */                 int costTp = (int)(JRMCoreH.techDBCtpc(PMA[i]) * 0.9F);
/*      */                 int cost = costTp;
/*      */                 String n = " " + cost + " tp";
/*      */                 int nw = this.fontRenderer.func_78256_a(fn);
/*      */                 if (JRMCoreH.curTP >= cost) {
/*      */                   this.field_146292_n.add(new JRMCoreGuiButtons01(!JRMCoreH.techOwnd(i, (byte)1) ? (4200 + i) : -1, guiLeft + xSize / 2 - 122 + fnw + onw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, nw, n, JRMCoreH.techNCCol[1]));
/*      */                 } else {
/*      */                   var8.func_78276_b(n, guiLeft + xSize / 2 - 122 + fnw + onw, guiTop + (ySize + 1) / 2 - 64 + i2 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[0]);
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */             i2++;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */       if (this.wish == 9000) {
/*      */         String im = "jinryuudragonbc:saa.png";
/*      */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */         ResourceLocation tx = new ResourceLocation(im);
/*      */         this.mc.field_71446_o.func_110577_a(tx);
/*      */         func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*      */         current(StatCollector.func_74838_a("dbc.talkgui.line1000"), 10, 10, var8, guiLeft, guiTop);
/*      */         String s = StatCollector.func_74838_a("dbc.talkgui.line1001");
/*      */         String s2 = StatCollector.func_74838_a("dbc.talkgui.line1002");
/*      */         String s3 = StatCollector.func_74838_a("dbc.talkgui.line1003");
/*      */         if (JRMCoreH.align > 66) {
/*      */           s = StatCollector.func_74838_a("dbc.talkgui.line1004");
/*      */           s2 = StatCollector.func_74838_a("dbc.talkgui.line1005");
/*      */           s3 = StatCollector.func_74838_a("dbc.talkgui.line1006");
/*      */         } 
/*      */         if (JRMCoreH.align < 33) {
/*      */           s = StatCollector.func_74838_a("dbc.talkgui.line1007");
/*      */           s2 = StatCollector.func_74838_a("dbc.talkgui.line1008");
/*      */           s3 = StatCollector.func_74838_a("dbc.talkgui.line1009");
/*      */         } 
/*      */         current(s, 15, 20, var8, guiLeft, guiTop);
/*      */         current(s2, 15, 30, var8, guiLeft, guiTop);
/*      */         current(s3, 15, 40, var8, guiLeft, guiTop);
/*      */       } else if (this.wish == 9001) {
/*      */         String im = "jinryuudragonbc:saa.png";
/*      */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */         ResourceLocation tx = new ResourceLocation(im);
/*      */         this.mc.field_71446_o.func_110577_a(tx);
/*      */         func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*      */         current(StatCollector.func_74838_a("dbc.talkgui.line1010"), 10, 10, var8, guiLeft, guiTop);
/*      */         String s = StatCollector.func_74838_a("dbc.talkgui.line1011");
/*      */         String s2 = StatCollector.func_74838_a("dbc.talkgui.line1012");
/*      */         if (JRMCoreH.align > 66) {
/*      */           s = StatCollector.func_74838_a("dbc.talkgui.line1013");
/*      */           s2 = StatCollector.func_74838_a("dbc.talkgui.line1014");
/*      */         } 
/*      */         if (JRMCoreH.align < 33) {
/*      */           s = StatCollector.func_74838_a("dbc.talkgui.line1015");
/*      */           s2 = StatCollector.func_74838_a("dbc.talkgui.line1016");
/*      */         } 
/*      */         current(s, 15, 20, var8, guiLeft, guiTop);
/*      */         current(s2, 15, 30, var8, guiLeft, guiTop);
/*      */       } else if (this.wish == 9002) {
/*      */         String im = "jinryuudragonbc:saa.png";
/*      */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */         ResourceLocation tx = new ResourceLocation(im);
/*      */         this.mc.field_71446_o.func_110577_a(tx);
/*      */         func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*      */         current(StatCollector.func_74838_a("dbc.talkgui.line1017"), 10, 10, var8, guiLeft, guiTop);
/*      */         String s = StatCollector.func_74838_a("dbc.talkgui.line1018");
/*      */         String s2 = StatCollector.func_74838_a("dbc.talkgui.line1019");
/*      */         if (JRMCoreH.align > 66) {
/*      */           s = StatCollector.func_74838_a("dbc.talkgui.line1020");
/*      */           s2 = StatCollector.func_74838_a("dbc.talkgui.line1021");
/*      */         } 
/*      */         if (JRMCoreH.align < 33) {
/*      */           s = StatCollector.func_74838_a("dbc.talkgui.line1022");
/*      */           s2 = StatCollector.func_74838_a("dbc.talkgui.line1023");
/*      */         } 
/*      */         current(s, 15, 20, var8, guiLeft, guiTop);
/*      */         current(s2, 15, 30, var8, guiLeft, guiTop);
/*      */       } else if (this.wish == 11) {
/*      */         String im = "jinryuudragonbc:saa.png";
/*      */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */         ResourceLocation tx = new ResourceLocation(im);
/*      */         this.mc.field_71446_o.func_110577_a(tx);
/*      */         func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*      */         current(StatCollector.func_74838_a("dbc.talkgui.line0000"), 10, 10, var8, guiLeft, guiTop);
/*      */         String s = StatCollector.func_74838_a("dbc.talkgui.line0001");
/*      */         String s2 = StatCollector.func_74838_a("dbc.talkgui.line0002");
/*      */         String s3 = StatCollector.func_74838_a("dbc.talkgui.line0003");
/*      */         if (JRMCoreH.align > 66) {
/*      */           s = StatCollector.func_74838_a("dbc.talkgui.line0004");
/*      */           s2 = StatCollector.func_74838_a("dbc.talkgui.line0005");
/*      */           s3 = StatCollector.func_74838_a("dbc.talkgui.line0006");
/*      */         } 
/*      */         if (JRMCoreH.align < 33) {
/*      */           s = StatCollector.func_74838_a("dbc.talkgui.line0007");
/*      */           s2 = StatCollector.func_74838_a("dbc.talkgui.line0008");
/*      */           s3 = StatCollector.func_74838_a("dbc.talkgui.line0009");
/*      */         } 
/*      */         if (JRMCoreH.SagaProg == 1700) {
/*      */           s = StatCollector.func_74838_a("dbc.MainSaga.17.2");
/*      */           s2 = StatCollector.func_74838_a("dbc.MainSaga.17.3");
/*      */           s3 = StatCollector.func_74838_a("dbc.MainSaga.17.4");
/*      */         } 
/*      */         if (JRMCoreH.SagaSideProg == 10100) {
/*      */           s = StatCollector.func_74838_a("dbc.sidesagas.101.talk");
/*      */           int i = JRMCoreH.txt(s, "§0", 5, true, guiLeft + 15, guiTop + 20, 0);
/*      */         } else {
/*      */           current(s, 15, 20, var8, guiLeft, guiTop);
/*      */           current(s2, 15, 30, var8, guiLeft, guiTop);
/*      */           current(s3, 15, 40, var8, guiLeft, guiTop);
/*      */         } 
/*      */       } else if (this.wish == 1101) {
/*      */         String im = "jinryuudragonbc:saa.png";
/*      */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */         ResourceLocation tx = new ResourceLocation(im);
/*      */         this.mc.field_71446_o.func_110577_a(tx);
/*      */         func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*      */         int nr = 0;
/*      */         this.Process = StatCollector.func_74838_a("dbc.talkgui.kami.startanew");
/*      */         nr += JRMCoreH.txt(this.Process, "§0", 5, true, guiLeft + 6, guiTop + 5 + nr * 10, 0);
/*      */       } else if (this.wish == 1102) {
/*      */         String im = "jinryuudragonbc:saa.png";
/*      */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */         ResourceLocation tx = new ResourceLocation(im);
/*      */         this.mc.field_71446_o.func_110577_a(tx);
/*      */         func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*      */         int nr = 0;
/*      */         this.Process = StatCollector.func_74838_a("dbc.talkgui.kami.confirmtailcut");
/*      */         nr += JRMCoreH.txt(this.Process, "§0", 5, true, guiLeft + 6, guiTop + 5 + nr * 10, 0);
/*      */       } else if (this.wish == 1104) {
/*      */         String im = "jinryuudragonbc:saa.png";
/*      */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */         ResourceLocation tx = new ResourceLocation(im);
/*      */         this.mc.field_71446_o.func_110577_a(tx);
/*      */         func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*      */         int nr = 0;
/*      */         this.Process = StatCollector.func_74838_a("dbc.talkgui.kami.tailregrow");
/*      */         nr += JRMCoreH.txt(this.Process, "§0", 5, true, guiLeft + 6, guiTop + 5 + nr * 10, 0);
/*      */       } else if (this.wish == 12) {
/*      */         current(StatCollector.func_74838_a("dbc.talkgui.line0010"), 10, 10, var8, guiLeft, guiTop);
/*      */         String s = StatCollector.func_74838_a("dbc.talkgui.line0011");
/*      */         String s2 = StatCollector.func_74838_a("dbc.talkgui.line0012");
/*      */         String s3 = StatCollector.func_74838_a("dbc.talkgui.line0013");
/*      */         if (JRMCoreH.align > 66) {
/*      */           s = StatCollector.func_74838_a("dbc.talkgui.line0014");
/*      */           s2 = StatCollector.func_74838_a("dbc.talkgui.line0015");
/*      */           s3 = StatCollector.func_74838_a("dbc.talkgui.line0016");
/*      */         } 
/*      */         if (JRMCoreH.align < 33) {
/*      */           s = StatCollector.func_74838_a("dbc.talkgui.line0017");
/*      */           s2 = StatCollector.func_74838_a("dbc.talkgui.line0018");
/*      */           s3 = StatCollector.func_74838_a("dbc.talkgui.line0019");
/*      */         } 
/*      */         current(s, 15, 20, var8, guiLeft, guiTop);
/*      */         current(s2, 15, 30, var8, guiLeft, guiTop);
/*      */         current(s3, 15, 40, var8, guiLeft, guiTop);
/*      */       } else if (this.wish == 13) {
/*      */         String wish = "jinryuudragonbc:saa.png";
/*      */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */         ResourceLocation tx = new ResourceLocation(wish);
/*      */         this.mc.field_71446_o.func_110577_a(tx);
/*      */         func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*      */         current(StatCollector.func_74838_a("dbc.talkgui.karin.00"), 10, 10, var8, guiLeft, guiTop);
/*      */         String s = StatCollector.func_74838_a("dbc.talkgui.karin.01");
/*      */         String s2 = StatCollector.func_74838_a("dbc.talkgui.karin.02");
/*      */         String s3 = StatCollector.func_74838_a("dbc.talkgui.karin.03");
/*      */         if (JRMCoreH.align < 66) {
/*      */           s = StatCollector.func_74838_a("dbc.talkgui.karin.04");
/*      */           s2 = StatCollector.func_74838_a("dbc.talkgui.karin.05");
/*      */           s3 = StatCollector.func_74838_a("dbc.talkgui.karin.06");
/*      */         } 
/*      */         if (JRMCoreH.align < 33) {
/*      */           s = StatCollector.func_74838_a("dbc.talkgui.karin.07");
/*      */           s2 = StatCollector.func_74838_a("dbc.talkgui.karin.08");
/*      */           s3 = StatCollector.func_74838_a("dbc.talkgui.karin.09");
/*      */         } 
/*      */         if (JRMCoreH.Senzu == 1)
/*      */           current(StatCollector.func_74838_a("dbc.talkgui.karin.nosenzu"), 25, 80, var8, guiLeft, guiTop); 
/*      */         current(s, 15, 20, var8, guiLeft, guiTop);
/*      */         current(s2, 15, 30, var8, guiLeft, guiTop);
/*      */         current(s3, 15, 40, var8, guiLeft, guiTop);
/*      */       } 
/*      */     } 
/*      */     super.func_73863_a(x, y, f);
/*      */   }
/*      */   
/*      */   private void drawBg(String name) {
/*      */     drawBg(name, 256, 160);
/*      */   }
/*      */   
/*      */   private void drawBg(String name, int xSize, int ySize) {
/*      */     String wish = "jinryuudragonbc:" + name + ".png";
/*      */     int guiLeft = (this.field_146294_l - xSize) / 2;
/*      */     int guiTop = (this.field_146295_m - ySize) / 2;
/*      */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */     ResourceLocation tx = new ResourceLocation(wish);
/*      */     this.mc.field_71446_o.func_110577_a(tx);
/*      */     func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*      */   }
/*      */   
/*      */   public void current(String var35, int posx, int posy, FontRenderer var8, int var6, int var7) {
/*      */     int wid = var8.func_78256_a(var35) / 2;
/*      */     int posX = var6 + posx;
/*      */     int posY = var7 + posy;
/*      */     var8.func_78276_b(var35, posX, posY, 0);
/*      */   }
/*      */   
/*      */   public boolean func_73868_f() {
/*      */     return false;
/*      */   }
/*      */   
/*      */   public static int count = 0;
/*      */   public static int warn = 0;
/*      */   public static int startcount = 0;
/*      */   private String Process;
/*      */   private int wid;
/*      */   private int hei;
/*      */   private String textureFile;
/*      */   
/*      */   public void SagasPrint() {
/*      */     func_73866_w_();
/*      */     Minecraft minecraft = this.mc;
/*      */     WorldClient worldClient = minecraft.field_71441_e;
/*      */     EntityClientPlayerMP entityClientPlayerMP = minecraft.field_71439_g;
/*      */     ScaledResolution scaledresolution = new ScaledResolution(minecraft, minecraft.field_71443_c, minecraft.field_71440_d);
/*      */     int width = scaledresolution.func_78326_a() / 2;
/*      */     int height = scaledresolution.func_78328_b() / 2;
/*      */     int widthplus = 8;
/*      */     minecraft.field_71460_t.func_78478_c();
/*      */     GL11.glEnable(3042);
/*      */     GL11.glEnable(32826);
/*      */     RenderHelper.func_74519_b();
/*      */     RenderHelper.func_74518_a();
/*      */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */     func_73732_a(this.fontRenderer, this.Process, width + this.wid, height + this.hei, 16768306);
/*      */     GL11.glDisable(32826);
/*      */     GL11.glDisable(3042);
/*      */   }
/*      */   
/*      */   public void SagasBack(int var6, int var7) {
/*      */     int width = var6;
/*      */     int height = var7;
/*      */     int xSize = 182;
/*      */     int ySize = 191;
/*      */     int guiLeft = (width - xSize) / 2;
/*      */     int guiTop = (height - ySize) / 2;
/*      */     String var4 = "jinryuudragonbc:sagas.png";
/*      */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */     ResourceLocation tx = new ResourceLocation(var4);
/*      */     this.mc.field_71446_o.func_110577_a(tx);
/*      */     func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*      */   }
/*      */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Gui\DBCTalkGui.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */