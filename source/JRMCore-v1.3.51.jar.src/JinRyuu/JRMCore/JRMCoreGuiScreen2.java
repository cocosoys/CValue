/*     */ package JinRyuu.JRMCore;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.datatransfer.Clipboard;
/*     */ import java.awt.datatransfer.ClipboardOwner;
/*     */ import java.awt.datatransfer.Transferable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.gui.GuiYesNoCallback;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class JRMCoreGuiScreen2
/*     */   extends GuiScreen
/*     */   implements ClipboardOwner, GuiYesNoCallback
/*     */ {
/*  24 */   private static final Logger logger = LogManager.getLogger();
/*  25 */   public static Minecraft mc = Minecraft.func_71410_x();
/*     */   public static JRMCoreGuiScreen2 instance;
/*  27 */   public int guiID = 0;
/*  28 */   public int guiIDprev = 0;
/*  29 */   public int guiIDprev2 = 0;
/*     */   public int guiLeft;
/*     */   public int guiTop;
/*  32 */   public int xSize = 256;
/*  33 */   public int ySize = 159;
/*     */ 
/*     */ 
/*     */   
/*     */   public float xSize_lo;
/*     */ 
/*     */   
/*     */   public float ySize_lo;
/*     */ 
/*     */   
/*  43 */   public static String button1 = JRMCoreH.tjjrmc + ":button1.png";
/*  44 */   public static String wish = JRMCoreH.tjjrmc + ":gui.png";
/*  45 */   public static String icons = JRMCoreH.tjjrmc + ":icons.png";
/*     */   public void func_73866_w_() {
/*  47 */     wish = JRMCoreH.tjjrmc + ":gui.png";
/*  48 */     button1 = JRMCoreH.tjjrmc + ":button1.png";
/*  49 */     icons = JRMCoreH.tjjrmc + ":icons.png";
/*  50 */     instance = this;
/*     */     
/*  52 */     this.field_146292_n.clear();
/*  53 */     this.guiLeft = (this.field_146294_l - this.xSize) / 2;
/*  54 */     this.guiTop = (this.field_146295_m - this.ySize) / 2;
/*     */     
/*  56 */     int posX = this.field_146294_l / 2;
/*  57 */     int posY = this.field_146295_m / 2;
/*     */ 
/*     */ 
/*     */     
/*  61 */     if (JRMCoreH.Accepted == 0) {
/*  62 */       this.guiID = 0;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146284_a(GuiButton button) {}
/*     */ 
/*     */   
/*     */   private int y;
/*     */   private int x;
/*     */   private byte pwr;
/*  73 */   protected static List detailList = new ArrayList(); public JRMCoreGuiScreen2(int w) {
/*  74 */     this.y = 0;
/*  75 */     this.x = 0;
/*  76 */     this.pwr = 0;
/*     */     this.guiID = w;
/*     */     this.guiIDprev = this.guiID; } public void func_73863_a(int x, int y, float f) {
/*  79 */     this.x = x;
/*  80 */     this.y = y;
/*     */     
/*  82 */     this.xSize_lo = x;
/*  83 */     this.ySize_lo = y;
/*  84 */     this; this; this; ScaledResolution var5 = new ScaledResolution(mc, mc.field_71443_c, mc.field_71440_d);
/*  85 */     int var6 = var5.func_78326_a();
/*  86 */     int var7 = var5.func_78328_b();
/*  87 */     this; FontRenderer var8 = mc.field_71466_p;
/*  88 */     this.field_146292_n.clear();
/*     */     
/*  90 */     this.guiLeft = (this.field_146294_l - this.xSize) / 2;
/*  91 */     this.guiTop = (this.field_146295_m - this.ySize) / 2;
/*     */ 
/*     */ 
/*     */     
/*  95 */     super.func_73863_a(x, y, f);
/*  96 */     drawDetails(x, y, var8);
/*     */   }
/*     */   
/*     */   public void menuButtons(String st) {
/* 100 */     menuButtons(st, this.field_146292_n, this.guiLeft, this.guiTop, this.ySize, this.x, this.y, this.field_146289_q);
/*     */   }
/*     */   public static void menuButtons(String st, List<JRMCoreGuiButtons00> buttonList, int guiLeft, int guiTop, int ySize, int x, int y, FontRenderer fontRendererObj) {
/* 103 */     int i = 0;
/* 104 */     buttonList.add(new JRMCoreGuiButtons00(10, guiLeft - 22, guiTop + 145, 20, 20, "X", 0));
/* 105 */     String name = "";
/* 106 */     if (!JRMCoreConfig.ssurl.contains("empty") && JRMCoreConfig.ssurl.contains("ttp")) {
/*     */ 
/*     */       
/* 109 */       name = "Server Shop";
/* 110 */       buttonList.add(new JRMCoreGuiButtons02(3099, guiLeft + i * 21, guiTop + ySize + 2, "$", st.equals("ST") ? 1 : 0, Color.GREEN.darker().darker().getRGB()));
/* 111 */       drawDetails(JRMCoreH.cct(name, new Object[0]), guiLeft + i * 21, guiTop + ySize + 2 + 1, 20, 20, x, y, fontRendererObj); i++;
/*     */     } 
/*     */     
/* 114 */     name = JRMCoreH.trl("jrmc", "News");
/* 115 */     buttonList.add(new JRMCoreGuiButtons02(31, guiLeft + i * 21, guiTop + ySize + 2, name.substring(0, 2).toUpperCase(), st.equals("News") ? 1 : 0, 8046079));
/* 116 */     drawDetails(JRMCoreH.cct(name, new Object[0]), guiLeft + i * 21, guiTop + ySize + 2 + 1, 20, 20, x, y, fontRendererObj); i++;
/*     */ 
/*     */     
/* 119 */     if (JRMCoreH.Accepted != 0 && JRMCoreH.Accepted != 2) {
/* 120 */       name = JRMCoreH.trl("jrmc", "CharSheet");
/* 121 */       buttonList.add(new JRMCoreGuiButtons02(100, guiLeft + i * 21, guiTop + ySize + 2, name.substring(0, 2).toUpperCase(), st.equals("CH") ? 1 : 0, 8046079));
/* 122 */       drawDetails(JRMCoreH.cct(name, new Object[0]), guiLeft + i * 21, guiTop + ySize + 2 + 1, 20, 20, x, y, fontRendererObj); i++;
/*     */     } 
/* 124 */     if (JRMCoreH.Pwrtyp != 0)
/*     */     {
/*     */       
/* 127 */       if (JRMCoreH.Pwrtyp == 1 || JRMCoreH.Pwrtyp == 2) {
/* 128 */         name = JRMCoreH.trl("jrmc", "Skills");
/* 129 */         buttonList.add(new JRMCoreGuiButtons02(101, guiLeft + i * 21, guiTop + ySize + 2, name.substring(0, 2).toUpperCase(), st.equals("SK") ? 1 : 0, 8046079));
/* 130 */         drawDetails(JRMCoreH.cct(name, new Object[0]), guiLeft + i * 21, guiTop + ySize + 2 + 1, 20, 20, x, y, fontRendererObj); i++;
/* 131 */         name = (JRMCoreH.Pwrtyp == 1) ? JRMCoreH.trl("jrmc", "KiTechniques") : JRMCoreH.trl("jrmc", "Jutsu");
/* 132 */         buttonList.add(new JRMCoreGuiButtons02(102, guiLeft + i * 21, guiTop + ySize + 2, name.substring(0, 2).toUpperCase(), st.equals("TE") ? 1 : 0, 8046079));
/* 133 */         drawDetails(JRMCoreH.cct(name, new Object[0]), guiLeft + i * 21, guiTop + ySize + 2 + 1, 20, 20, x, y, fontRendererObj); i++;
/*     */         
/* 135 */         name = (JRMCoreH.Pwrtyp == 1) ? JRMCoreH.trl("dbc", "SagaSystem") : ((JRMCoreH.Pwrtyp == 2) ? JRMCoreH.trl("nc", "StorySystem") : JRMCoreH.trl("jrmc", "Story"));
/* 136 */         buttonList.add(new JRMCoreGuiButtons02(60, guiLeft + i * 21, guiTop + ySize + 2, name.substring(0, 2).toUpperCase(), st.equals("Journal") ? 1 : 0, 8046079));
/* 137 */         drawDetails(JRMCoreH.cct(name, new Object[0]), guiLeft + i * 21, guiTop + ySize + 2 + 1, 20, 20, x, y, fontRendererObj); i++;
/*     */       } 
/*     */     }
/*     */     
/* 141 */     name = JRMCoreH.trl("jrmc", "GroupManager");
/* 142 */     buttonList.add(new JRMCoreGuiButtons02(62, guiLeft + i * 21, guiTop + ySize + 2, name.substring(0, 2).toUpperCase(), st.equals("Group") ? 1 : 0, 8046079));
/* 143 */     drawDetails(JRMCoreH.cct(name, new Object[0]), guiLeft + i * 21, guiTop + ySize + 2 + 1, 20, 20, x, y, fontRendererObj); i++;
/*     */     
/* 145 */     name = JRMCoreH.trl("jrmc", "ServerConfig");
/* 146 */     buttonList.add(new JRMCoreGuiButtons02(32, guiLeft + i * 21, guiTop + ySize + 2, name.substring(0, 2).toUpperCase(), st.equals("Server") ? 1 : 0, 8046079));
/* 147 */     drawDetails(JRMCoreH.cct(name, new Object[0]), guiLeft + i * 21, guiTop + ySize + 2 + 1, 20, 20, x, y, fontRendererObj); i++;
/*     */     
/* 149 */     if (JRMCoreH.JYC()) {
/* 150 */       name = JRMCoreH.trl("jrmc", "Calendar");
/* 151 */       buttonList.add(new JRMCoreGuiButtons02(4902, guiLeft + i * 21, guiTop + ySize + 2, name.substring(0, 2).toUpperCase(), st.equals("Calendar") ? 1 : 0, 8046079));
/* 152 */       drawDetails(JRMCoreH.cct(name, new Object[0]), guiLeft + i * 21, guiTop + ySize + 2 + 1, 20, 20, x, y, fontRendererObj); i++;
/*     */     } 
/* 154 */     if (JRMCoreH.JFC()) {
/* 155 */       name = JRMCoreH.trl("jrmc", "Family");
/* 156 */       buttonList.add(new JRMCoreGuiButtons02(4903, guiLeft + i * 21, guiTop + ySize + 2, name.substring(0, 2).toUpperCase(), st.equals("Family") ? 1 : 0, 8046079));
/* 157 */       drawDetails(JRMCoreH.cct(name, new Object[0]), guiLeft + i * 21, guiTop + ySize + 2 + 1, 20, 20, x, y, fontRendererObj); i++;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void drawDetails(String s1, String s2, int xpos, int ypos, int x, int y, FontRenderer var8) {
/* 162 */     int wpos = var8.func_78256_a(s1);
/* 163 */     var8.func_78276_b(s1, xpos, ypos, 0);
/* 164 */     if (xpos < x && xpos + wpos > x && ypos - 3 < y && ypos + 10 > y) {
/* 165 */       int ll = 200;
/* 166 */       Object[] txt = { s2, "§8", Integer.valueOf(0), Boolean.valueOf(true), Integer.valueOf(x + 5), Integer.valueOf(y + 5), Integer.valueOf(ll) };
/* 167 */       detailList.add(txt);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void drawDetails(String s1, int xpos, int ypos, int w, int h, int x, int y, FontRenderer var8) {
/* 172 */     if (xpos < x && xpos + w > x && ypos - 3 < y && ypos + h > y) {
/* 173 */       int ll = 200;
/* 174 */       Object[] txt = { s1, "§8", Integer.valueOf(0), Boolean.valueOf(true), Integer.valueOf(x + 5), Integer.valueOf(y + 5), Integer.valueOf(ll) };
/* 175 */       detailList.add(txt);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void drawDetails(int x, int y, FontRenderer var8) {
/* 180 */     if (!detailList.isEmpty()) {
/* 181 */       Object[] o = detailList.get(0);
/* 182 */       String desc = (String)o[0];
/* 183 */       int ll = Integer.parseInt("" + o[6]);
/* 184 */       int descw = var8.func_78256_a(desc);
/* 185 */       int desch = 1 + var8.func_78256_a(desc) / ll;
/* 186 */       this; mc.field_71446_o.func_110577_a(new ResourceLocation("jinryuumodscore:allw.png"));
/* 187 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.8F);
/* 188 */       desch = JRMCoreH.txt(desc, (String)o[1], Integer.parseInt("" + o[2]), false, 0, 0, ll);
/* 189 */       this; this; this; ScaledResolution var5 = new ScaledResolution(mc, mc.field_71443_c, mc.field_71440_d);
/* 190 */       int var6 = var5.func_78326_a();
/* 191 */       int var7 = var5.func_78328_b();
/* 192 */       int xp = 0;
/* 193 */       int yp = 0;
/* 194 */       if (var6 < x + ((descw < ll) ? descw : ll) + 10)
/*     */       {
/* 196 */         xp += var6 - x + ((descw < ll) ? descw : ll) - 10;
/*     */       }
/* 198 */       if (var7 < y + desch * 10 + 10) {
/* 199 */         yp = -(desch * 10 + 20);
/*     */       }
/*     */       
/* 202 */       func_73729_b(x + xp, y + 10 + yp, 5, 5, ((descw < ll) ? descw : ll) + 10, desch * 10 + 10);
/* 203 */       JRMCoreH.txt(desc, (String)o[1], Integer.parseInt("" + o[2]), Boolean.parseBoolean("" + o[3]), Integer.parseInt("" + o[4]) + xp, Integer.parseInt("" + o[5]) + 10 + yp, ll);
/* 204 */       detailList.clear();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void lostOwnership(Clipboard aClipboard, Transferable aContents) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_73868_f() {
/* 218 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCoreGuiScreen2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */