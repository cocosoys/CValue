/*      */ package JinRyuu.FamilyC;
/*      */ 
/*      */ import JinRyuu.JRMCore.FamilyCH;
/*      */ import JinRyuu.JRMCore.JRMCoreH;
/*      */ import net.minecraft.client.gui.FontRenderer;
/*      */ import net.minecraft.client.gui.GuiButton;
/*      */ import net.minecraft.client.gui.GuiScreen;
/*      */ import net.minecraft.client.gui.GuiTextField;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class FamilyCCharGui
/*      */   extends GuiScreen
/*      */ {
/*   27 */   public int jfc = 0;
/*   28 */   private int fnba = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_73866_w_() {
/*   37 */     this.field_146292_n.clear();
/*      */     
/*   39 */     int posX = this.field_146294_l / 2;
/*   40 */     int posY = this.field_146295_m / 2;
/*   41 */     npcNuller(); children = "";
/*   42 */     if (inv == -1) inv = 0; 
/*   43 */     if (this.jfc == 1) {
/*   44 */       FamilyCH.jfcd(21, "");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*   50 */     if (!(JRMCoreH.targ instanceof EntityPlayer)) JRMCoreH.targ = null;
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object actionPerformed(int par1, int par2, int par3, int par4, int par5, String par6Str) {
/*      */     GuiButton ret;
/*  134 */     int selct = par1 - 20;
/*  135 */     int KA = 0;
/*      */     
/*  137 */     if (KA == 1) {
/*  138 */       ret = new FamilyCGuiButtons00(par1, par2, par3, par4, par5, par6Str);
/*      */     } else {
/*      */       
/*  141 */       ret = new FamilyCGuiButtons00(par1, par2, par3, par4, par5, par6Str);
/*      */     } 
/*  143 */     return ret;
/*      */   }
/*      */   
/*      */   public static int Slct(String dir, int Select, int l) {
/*  147 */     if (dir.contains("B")) {
/*  148 */       int selct = Select - 1;
/*  149 */       if (selct >= 0) { Select = selct; }
/*  150 */       else { Select = l - 1; }
/*      */     
/*      */     } else {
/*  153 */       int selct = Select + 1;
/*  154 */       if (selct < l) { Select = selct; }
/*  155 */       else { Select = 0; }
/*      */     
/*  157 */     }  return Select;
/*      */   }
/*      */   
/*  160 */   public static String dtcf = "0";
/*  161 */   public static String dtca = "0";
/*  162 */   public static String dtcft = "0";
/*  163 */   public static String dtcd = "0";
/*      */   
/*  165 */   public static String dtcdad = "";
/*  166 */   public static String dtcmom = ""; String reg;
/*      */   
/*      */   public void npcNuller() {
/*  169 */     dtcf = "0";
/*  170 */     dtca = "0";
/*  171 */     dtcft = "0";
/*  172 */     dtcd = "0";
/*  173 */     dtcdad = "";
/*  174 */     dtcmom = "";
/*  175 */     flwTrgtNm = "";
/*      */   }
/*      */   
/*  178 */   public FamilyCCharGui(int w) { this.reg = "[^'a-zA-Z0-9-]";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  364 */     this.defaultInputFieldText = "";
/*  365 */     this.ipg = 0;
/*      */     
/*  367 */     this.famMems = 0;
/*  368 */     this.dfu = ""; this.jfc = w; }
/*      */   public void func_146284_a(GuiButton button) { if (button.field_146127_k == 10) this.field_146297_k.field_71439_g.func_71053_j();  if (button.field_146127_k == 1) { Entity npc = JRMCoreH.targNPC; FamilyCH.jfcd(20, JRMCoreH.targNPC.func_145782_y() + ":" + dtcf + ":" + dtca + ":" + dtcft + ":" + dtcd); npcNuller(); this.field_146297_k.field_71439_g.func_71053_j(); }  if (button.field_146127_k == 2) dtcf = "" + Slct("F", Integer.parseInt(dtcf), 4);  if (button.field_146127_k == -2) dtcf = "" + Slct("B", Integer.parseInt(dtcf), 4);  if (button.field_146127_k == 3) dtca = "" + Slct("F", Integer.parseInt(dtca), 2);  if (button.field_146127_k == -3) dtca = "" + Slct("B", Integer.parseInt(dtca), 2);  if (button.field_146127_k == 4) dtcd = "" + Slct("F", Integer.parseInt(dtcd), 2);  if (button.field_146127_k == -4) dtcd = "" + Slct("B", Integer.parseInt(dtcd), 2);  if (button.field_146127_k == 5) inv = 21;  if (inv == 21) for (byte i = 0; i < ((JRMCoreH.plyrs != null) ? JRMCoreH.plyrs.length : 10); i = (byte)(i + 1)) { if (button.field_146127_k == 2000 + i && JRMCoreH.plyrs != null && JRMCoreH.plyrs.length > i) { EntityPlayer entityPlayer = this.field_146297_k.field_71441_e.func_72924_a(JRMCoreH.plyrs[i]); if (entityPlayer != null) { flwTrgtNm = entityPlayer.func_70005_c_(); dtcft = entityPlayer.func_145782_y() + ""; inv = 0; }  }  }   if (inv == -1 && button.field_146127_k == 6) { for (byte i = 0; i < 3; ) { chiNam = (chiNam.length() < 2) ? (chiNam + "_") : chiNam; i = (byte)(i + 1); }  chiNam = chiNam.replaceAll(this.reg, "_"); FamilyCH.jfcd(22, JRMCoreH.targNPC.func_145782_y() + ":" + chiNam); inv = 0; this.defaultInputFieldText = ""; }  if (button.field_146127_k == 60) this.jfc = 1;  if (button.field_146127_k == 61) this.jfc = 61;  if (button.field_146127_k == 62) this.jfc = 70;  if (button.field_146127_k == 77) this.fnba = (this.fnba == 0) ? 1 : 0;  if (button.field_146127_k == 78) inv = 1;  if (button.field_146127_k == 79) inv = 2;  if (button.field_146127_k == 80) { for (byte i = 0; i < 3; ) { famNam = (famNam.length() < 2) ? (famNam + "A") : famNam; i = (byte)(i + 1); }  famNam = famNam.replaceAll(this.reg, "_"); famNam += "," + this.fnba; FamilyCH.jfcd(0, famNam); inv = 0; }  if (button.field_146127_k == 81) { FamilyCH.jfcd(4, ""); inv = 0; }  if (button.field_146127_k == 82) { FamilyCH.jfcd(3, ""); inv = 0; }  if (button.field_146127_k == 83) { FamilyCH.jfcd(5, ""); inv = 0; }  if (button.field_146127_k == 85) { FamilyCH.jfcd(6, ""); inv = 0; }  if (button.field_146127_k == 86) { FamilyCH.jfcd(7, kick); inv = 0; }  if (button.field_146127_k == 88) this.ipg++;  if (button.field_146127_k == 89) this.ipg--;  if (button.field_146127_k == 90) inv = 0;  if (button.field_146127_k == 91) inv = 4;  if (button.field_146127_k == 92) inv = 5;  if (button.field_146127_k == 93) inv = 6;  if (button.field_146127_k == 94) { for (byte i = 0; i < 3; ) { chiNam = (chiNam.length() < 2) ? (chiNam + "A") : chiNam; i = (byte)(i + 1); }  chiNam = chiNam.replaceAll(this.reg, "_"); FamilyCH.jfcd(8, chiNam); inv = 0; }  if (button.field_146127_k == 95) { FamilyCH.jfcd(9, ""); inv = 0; }  if (button.field_146127_k == 96) { FamilyCH.jfcd(10, JRMCoreH.targ.func_70005_c_()); inv = 0; this.field_146297_k.field_71439_g.func_71053_j(); }  if (button.field_146127_k == 97)
/*      */       this.inputField.func_146180_a(FamilyCH.namGen());  if (inv == 1 || inv == 2)
/*  371 */       for (byte i = 0; i < ((JRMCoreH.plyrs != null) ? JRMCoreH.plyrs.length : 10); i = (byte)(i + 1)) { if (button.field_146127_k == 2000 + i && JRMCoreH.plyrs != null && JRMCoreH.plyrs.length > i) { EntityPlayer entityPlayer = this.field_146297_k.field_71441_e.func_72924_a(JRMCoreH.plyrs[i]); if (entityPlayer != null) { propInv = entityPlayer.func_70005_c_(); adopInv = entityPlayer.func_70005_c_(); FamilyCH.jfcd((inv == 1) ? 1 : ((inv == 2) ? 2 : 10), (inv == 1) ? propInv : ((inv == 2) ? adopInv : "0")); inv = 0; propInv = ""; adopInv = ""; }  }  }   if ((inv == 3 || inv == 4 || inv == 5 || inv == 6) && button.field_146127_k >= 2000 && button.field_146127_k < 2500) { int k = button.field_146127_k - 2000; String[] s = this.dfu.split(":"); kick = s[k]; FamilyCH.jfcd(7, kick); kick = ""; inv = 0; }  nuller(); } public static String famNam = ""; public static String chiNam = ""; public static String propInv = ""; public static String flwTrgtNm = ""; public static String adopInv = ""; public static String kick = ""; private void name(FontRenderer var8, int i, int j) { this.inputField = new GuiTextField(var8, i, j, 100, 12);
/*  372 */     this.inputField.func_146203_f(20);
/*  373 */     this.inputField.func_146185_a(true);
/*  374 */     this.inputField.func_146195_b(true);
/*  375 */     this.inputField.func_146180_a(this.defaultInputFieldText);
/*  376 */     this.inputField.func_146205_d(true); }
/*      */   
/*      */   public static String name = ""; public static String children = ""; protected GuiTextField inputField; private String defaultInputFieldText; private int ipg; public static int inv = 0; private int famMems; private String dfu;
/*      */   public void func_73876_c() {
/*  380 */     if (this.inputField != null)
/*  381 */       this.inputField.func_146178_a(); 
/*      */   }
/*      */   
/*      */   protected void func_73869_a(char c, int i) {
/*  385 */     super.func_73869_a(c, i);
/*  386 */     if (this.inputField != null)
/*  387 */       this.inputField.func_146201_a(c, i); 
/*      */   }
/*      */   
/*      */   protected void func_73864_a(int i, int j, int k) {
/*  391 */     super.func_73864_a(i, j, k);
/*  392 */     if (this.inputField != null) {
/*  393 */       this.inputField.func_146192_a(i, j, k);
/*      */     }
/*      */   }
/*      */   
/*      */   public void nuller() {
/*  398 */     JRMCoreH.ask = null;
/*  399 */     JRMCoreH.targ = null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void player() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_73863_a(int x, int y, float f) {
/*      */     // Byte code:
/*      */     //   0: new net/minecraft/client/gui/ScaledResolution
/*      */     //   3: dup
/*      */     //   4: aload_0
/*      */     //   5: getfield field_146297_k : Lnet/minecraft/client/Minecraft;
/*      */     //   8: aload_0
/*      */     //   9: getfield field_146297_k : Lnet/minecraft/client/Minecraft;
/*      */     //   12: getfield field_71443_c : I
/*      */     //   15: aload_0
/*      */     //   16: getfield field_146297_k : Lnet/minecraft/client/Minecraft;
/*      */     //   19: getfield field_71440_d : I
/*      */     //   22: invokespecial <init> : (Lnet/minecraft/client/Minecraft;II)V
/*      */     //   25: astore #4
/*      */     //   27: aload #4
/*      */     //   29: invokevirtual func_78326_a : ()I
/*      */     //   32: istore #5
/*      */     //   34: aload #4
/*      */     //   36: invokevirtual func_78328_b : ()I
/*      */     //   39: istore #6
/*      */     //   41: aload_0
/*      */     //   42: getfield field_146297_k : Lnet/minecraft/client/Minecraft;
/*      */     //   45: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   48: astore #7
/*      */     //   50: ldc_w 'jinryuufamilyc:gui.png'
/*      */     //   53: astore #8
/*      */     //   55: aload_0
/*      */     //   56: getfield field_146292_n : Ljava/util/List;
/*      */     //   59: invokeinterface clear : ()V
/*      */     //   64: iconst_1
/*      */     //   65: istore #9
/*      */     //   67: aload_0
/*      */     //   68: getfield jfc : I
/*      */     //   71: bipush #60
/*      */     //   73: if_icmplt -> 4333
/*      */     //   76: aload_0
/*      */     //   77: getfield jfc : I
/*      */     //   80: bipush #70
/*      */     //   82: if_icmpgt -> 4333
/*      */     //   85: sipush #256
/*      */     //   88: istore #10
/*      */     //   90: sipush #159
/*      */     //   93: istore #11
/*      */     //   95: aload_0
/*      */     //   96: getfield field_146294_l : I
/*      */     //   99: iload #10
/*      */     //   101: isub
/*      */     //   102: iconst_2
/*      */     //   103: idiv
/*      */     //   104: istore #12
/*      */     //   106: aload_0
/*      */     //   107: getfield field_146295_m : I
/*      */     //   110: iload #11
/*      */     //   112: isub
/*      */     //   113: iconst_2
/*      */     //   114: idiv
/*      */     //   115: istore #13
/*      */     //   117: fconst_1
/*      */     //   118: fconst_1
/*      */     //   119: fconst_1
/*      */     //   120: fconst_1
/*      */     //   121: invokestatic glColor4f : (FFFF)V
/*      */     //   124: new net/minecraft/util/ResourceLocation
/*      */     //   127: dup
/*      */     //   128: aload #8
/*      */     //   130: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   133: astore #14
/*      */     //   135: aload_0
/*      */     //   136: getfield field_146297_k : Lnet/minecraft/client/Minecraft;
/*      */     //   139: getfield field_71446_o : Lnet/minecraft/client/renderer/texture/TextureManager;
/*      */     //   142: aload #14
/*      */     //   144: invokevirtual func_110577_a : (Lnet/minecraft/util/ResourceLocation;)V
/*      */     //   147: aload_0
/*      */     //   148: iload #12
/*      */     //   150: iload #13
/*      */     //   152: iconst_0
/*      */     //   153: iconst_0
/*      */     //   154: iload #10
/*      */     //   156: iload #11
/*      */     //   158: invokevirtual func_73729_b : (IIIIII)V
/*      */     //   161: aload_0
/*      */     //   162: getfield field_146292_n : Ljava/util/List;
/*      */     //   165: new JinRyuu/JRMCore/JRMCoreGuiButtons00
/*      */     //   168: dup
/*      */     //   169: bipush #10
/*      */     //   171: iload #12
/*      */     //   173: iload #10
/*      */     //   175: iconst_2
/*      */     //   176: idiv
/*      */     //   177: iadd
/*      */     //   178: sipush #150
/*      */     //   181: isub
/*      */     //   182: iload #13
/*      */     //   184: iload #11
/*      */     //   186: iconst_2
/*      */     //   187: idiv
/*      */     //   188: iadd
/*      */     //   189: bipush #65
/*      */     //   191: iadd
/*      */     //   192: bipush #20
/*      */     //   194: bipush #20
/*      */     //   196: ldc_w 'X'
/*      */     //   199: iconst_0
/*      */     //   200: invokespecial <init> : (IIIIILjava/lang/String;I)V
/*      */     //   203: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   208: pop
/*      */     //   209: aload_0
/*      */     //   210: getfield jfc : I
/*      */     //   213: bipush #60
/*      */     //   215: if_icmpne -> 218
/*      */     //   218: aload_0
/*      */     //   219: getfield jfc : I
/*      */     //   222: bipush #61
/*      */     //   224: if_icmpne -> 227
/*      */     //   227: aload_0
/*      */     //   228: getfield jfc : I
/*      */     //   231: bipush #70
/*      */     //   233: if_icmpne -> 4333
/*      */     //   236: aload_0
/*      */     //   237: getfield field_146292_n : Ljava/util/List;
/*      */     //   240: new JinRyuu/JRMCore/JRMCoreGuiButtonsTab
/*      */     //   243: dup
/*      */     //   244: bipush #60
/*      */     //   246: iload #12
/*      */     //   248: iload #10
/*      */     //   250: iconst_2
/*      */     //   251: idiv
/*      */     //   252: iadd
/*      */     //   253: bipush #110
/*      */     //   255: isub
/*      */     //   256: iload #13
/*      */     //   258: iload #11
/*      */     //   260: iconst_1
/*      */     //   261: iadd
/*      */     //   262: iconst_2
/*      */     //   263: idiv
/*      */     //   264: iadd
/*      */     //   265: bipush #99
/*      */     //   267: isub
/*      */     //   268: bipush #60
/*      */     //   270: bipush #20
/*      */     //   272: ldc_w 'Status'
/*      */     //   275: iconst_0
/*      */     //   276: invokespecial <init> : (IIIIILjava/lang/String;I)V
/*      */     //   279: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   284: pop
/*      */     //   285: aload_0
/*      */     //   286: getfield field_146292_n : Ljava/util/List;
/*      */     //   289: new JinRyuu/JRMCore/JRMCoreGuiButtonsTab
/*      */     //   292: dup
/*      */     //   293: bipush #62
/*      */     //   295: iload #12
/*      */     //   297: iload #10
/*      */     //   299: iconst_2
/*      */     //   300: idiv
/*      */     //   301: iadd
/*      */     //   302: bipush #10
/*      */     //   304: isub
/*      */     //   305: iload #13
/*      */     //   307: iload #11
/*      */     //   309: iconst_1
/*      */     //   310: iadd
/*      */     //   311: iconst_2
/*      */     //   312: idiv
/*      */     //   313: iadd
/*      */     //   314: bipush #99
/*      */     //   316: isub
/*      */     //   317: bipush #60
/*      */     //   319: bipush #20
/*      */     //   321: ldc_w 'Family'
/*      */     //   324: iconst_1
/*      */     //   325: invokespecial <init> : (IIIIILjava/lang/String;I)V
/*      */     //   328: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   333: pop
/*      */     //   334: getstatic JinRyuu/JRMCore/FamilyCH.FamID : I
/*      */     //   337: ifne -> 1183
/*      */     //   340: getstatic JinRyuu/JRMCore/FamilyCH.prop : Ljava/lang/String;
/*      */     //   343: ifnull -> 530
/*      */     //   346: getstatic JinRyuu/JRMCore/FamilyCH.prop : Ljava/lang/String;
/*      */     //   349: invokevirtual length : ()I
/*      */     //   352: iconst_1
/*      */     //   353: if_icmple -> 530
/*      */     //   356: getstatic JinRyuu/JRMCore/FamilyCH.prop : Ljava/lang/String;
/*      */     //   359: astore #15
/*      */     //   361: new java/lang/StringBuilder
/*      */     //   364: dup
/*      */     //   365: invokespecial <init> : ()V
/*      */     //   368: ldc_w 'You recived a propose from '
/*      */     //   371: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   374: aload #15
/*      */     //   376: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   379: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   382: astore #16
/*      */     //   384: aload #7
/*      */     //   386: aload #16
/*      */     //   388: iload #12
/*      */     //   390: iconst_5
/*      */     //   391: iadd
/*      */     //   392: iload #13
/*      */     //   394: iconst_5
/*      */     //   395: iadd
/*      */     //   396: iconst_0
/*      */     //   397: invokevirtual func_78276_b : (Ljava/lang/String;III)I
/*      */     //   400: pop
/*      */     //   401: ldc_w 'Accept'
/*      */     //   404: astore #17
/*      */     //   406: aload_0
/*      */     //   407: getfield field_146292_n : Ljava/util/List;
/*      */     //   410: new JinRyuu/JRMCore/JRMCoreGuiButtons00
/*      */     //   413: dup
/*      */     //   414: bipush #82
/*      */     //   416: iload #12
/*      */     //   418: iload #10
/*      */     //   420: iconst_2
/*      */     //   421: idiv
/*      */     //   422: iadd
/*      */     //   423: bipush #10
/*      */     //   425: iadd
/*      */     //   426: iload #13
/*      */     //   428: iload #11
/*      */     //   430: iconst_1
/*      */     //   431: iadd
/*      */     //   432: iconst_2
/*      */     //   433: idiv
/*      */     //   434: iadd
/*      */     //   435: bipush #50
/*      */     //   437: isub
/*      */     //   438: aload_0
/*      */     //   439: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   442: aload #17
/*      */     //   444: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   447: bipush #8
/*      */     //   449: iadd
/*      */     //   450: bipush #20
/*      */     //   452: aload #17
/*      */     //   454: iconst_0
/*      */     //   455: invokespecial <init> : (IIIIILjava/lang/String;I)V
/*      */     //   458: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   463: pop
/*      */     //   464: ldc_w 'Decline'
/*      */     //   467: astore #18
/*      */     //   469: aload_0
/*      */     //   470: getfield field_146292_n : Ljava/util/List;
/*      */     //   473: new JinRyuu/JRMCore/JRMCoreGuiButtons00
/*      */     //   476: dup
/*      */     //   477: bipush #83
/*      */     //   479: iload #12
/*      */     //   481: iload #10
/*      */     //   483: iconst_2
/*      */     //   484: idiv
/*      */     //   485: iadd
/*      */     //   486: bipush #10
/*      */     //   488: iadd
/*      */     //   489: iload #13
/*      */     //   491: iload #11
/*      */     //   493: iconst_1
/*      */     //   494: iadd
/*      */     //   495: iconst_2
/*      */     //   496: idiv
/*      */     //   497: iadd
/*      */     //   498: bipush #30
/*      */     //   500: isub
/*      */     //   501: aload_0
/*      */     //   502: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   505: aload #18
/*      */     //   507: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   510: bipush #8
/*      */     //   512: iadd
/*      */     //   513: bipush #20
/*      */     //   515: aload #18
/*      */     //   517: iconst_0
/*      */     //   518: invokespecial <init> : (IIIIILjava/lang/String;I)V
/*      */     //   521: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   526: pop
/*      */     //   527: goto -> 1177
/*      */     //   530: getstatic JinRyuu/JRMCore/FamilyCH.adop : Ljava/lang/String;
/*      */     //   533: ifnull -> 720
/*      */     //   536: getstatic JinRyuu/JRMCore/FamilyCH.adop : Ljava/lang/String;
/*      */     //   539: invokevirtual length : ()I
/*      */     //   542: iconst_1
/*      */     //   543: if_icmple -> 720
/*      */     //   546: getstatic JinRyuu/JRMCore/FamilyCH.adop : Ljava/lang/String;
/*      */     //   549: astore #15
/*      */     //   551: new java/lang/StringBuilder
/*      */     //   554: dup
/*      */     //   555: invokespecial <init> : ()V
/*      */     //   558: ldc_w 'You received an adoption request '
/*      */     //   561: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   564: aload #15
/*      */     //   566: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   569: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   572: astore #16
/*      */     //   574: aload #7
/*      */     //   576: aload #16
/*      */     //   578: iload #12
/*      */     //   580: iconst_5
/*      */     //   581: iadd
/*      */     //   582: iload #13
/*      */     //   584: iconst_5
/*      */     //   585: iadd
/*      */     //   586: iconst_0
/*      */     //   587: invokevirtual func_78276_b : (Ljava/lang/String;III)I
/*      */     //   590: pop
/*      */     //   591: ldc_w 'Accept'
/*      */     //   594: astore #17
/*      */     //   596: aload_0
/*      */     //   597: getfield field_146292_n : Ljava/util/List;
/*      */     //   600: new JinRyuu/JRMCore/JRMCoreGuiButtons00
/*      */     //   603: dup
/*      */     //   604: bipush #81
/*      */     //   606: iload #12
/*      */     //   608: iload #10
/*      */     //   610: iconst_2
/*      */     //   611: idiv
/*      */     //   612: iadd
/*      */     //   613: bipush #10
/*      */     //   615: iadd
/*      */     //   616: iload #13
/*      */     //   618: iload #11
/*      */     //   620: iconst_1
/*      */     //   621: iadd
/*      */     //   622: iconst_2
/*      */     //   623: idiv
/*      */     //   624: iadd
/*      */     //   625: bipush #50
/*      */     //   627: isub
/*      */     //   628: aload_0
/*      */     //   629: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   632: aload #17
/*      */     //   634: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   637: bipush #8
/*      */     //   639: iadd
/*      */     //   640: bipush #20
/*      */     //   642: aload #17
/*      */     //   644: iconst_0
/*      */     //   645: invokespecial <init> : (IIIIILjava/lang/String;I)V
/*      */     //   648: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   653: pop
/*      */     //   654: ldc_w 'Decline'
/*      */     //   657: astore #18
/*      */     //   659: aload_0
/*      */     //   660: getfield field_146292_n : Ljava/util/List;
/*      */     //   663: new JinRyuu/JRMCore/JRMCoreGuiButtons00
/*      */     //   666: dup
/*      */     //   667: bipush #83
/*      */     //   669: iload #12
/*      */     //   671: iload #10
/*      */     //   673: iconst_2
/*      */     //   674: idiv
/*      */     //   675: iadd
/*      */     //   676: bipush #10
/*      */     //   678: iadd
/*      */     //   679: iload #13
/*      */     //   681: iload #11
/*      */     //   683: iconst_1
/*      */     //   684: iadd
/*      */     //   685: iconst_2
/*      */     //   686: idiv
/*      */     //   687: iadd
/*      */     //   688: bipush #30
/*      */     //   690: isub
/*      */     //   691: aload_0
/*      */     //   692: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   695: aload #18
/*      */     //   697: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   700: bipush #8
/*      */     //   702: iadd
/*      */     //   703: bipush #20
/*      */     //   705: aload #18
/*      */     //   707: iconst_0
/*      */     //   708: invokespecial <init> : (IIIIILjava/lang/String;I)V
/*      */     //   711: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   716: pop
/*      */     //   717: goto -> 1177
/*      */     //   720: ldc_w 'Family name: '
/*      */     //   723: astore #15
/*      */     //   725: aload_0
/*      */     //   726: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   729: aload #15
/*      */     //   731: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   734: istore #16
/*      */     //   736: aload #7
/*      */     //   738: aload #15
/*      */     //   740: iload #12
/*      */     //   742: iload #10
/*      */     //   744: iconst_2
/*      */     //   745: idiv
/*      */     //   746: iadd
/*      */     //   747: bipush #122
/*      */     //   749: isub
/*      */     //   750: iload #13
/*      */     //   752: iload #11
/*      */     //   754: iconst_1
/*      */     //   755: iadd
/*      */     //   756: iconst_2
/*      */     //   757: idiv
/*      */     //   758: iadd
/*      */     //   759: bipush #74
/*      */     //   761: isub
/*      */     //   762: bipush #10
/*      */     //   764: iadd
/*      */     //   765: iconst_2
/*      */     //   766: iadd
/*      */     //   767: iconst_0
/*      */     //   768: invokevirtual func_78276_b : (Ljava/lang/String;III)I
/*      */     //   771: pop
/*      */     //   772: aload_0
/*      */     //   773: getfield field_146292_n : Ljava/util/List;
/*      */     //   776: new JinRyuu/JRMCore/JRMCoreGuiButtons00
/*      */     //   779: dup
/*      */     //   780: bipush #80
/*      */     //   782: iload #12
/*      */     //   784: iload #10
/*      */     //   786: iconst_2
/*      */     //   787: idiv
/*      */     //   788: iadd
/*      */     //   789: bipush #85
/*      */     //   791: isub
/*      */     //   792: iload #13
/*      */     //   794: iload #11
/*      */     //   796: iconst_1
/*      */     //   797: iadd
/*      */     //   798: iconst_2
/*      */     //   799: idiv
/*      */     //   800: iadd
/*      */     //   801: bipush #35
/*      */     //   803: iadd
/*      */     //   804: sipush #170
/*      */     //   807: bipush #20
/*      */     //   809: ldc_w 'Create Family'
/*      */     //   812: iconst_0
/*      */     //   813: invokespecial <init> : (IIIIILjava/lang/String;I)V
/*      */     //   816: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   821: pop
/*      */     //   822: aload_0
/*      */     //   823: getfield fnba : I
/*      */     //   826: ifne -> 835
/*      */     //   829: ldc_w 'before'
/*      */     //   832: goto -> 838
/*      */     //   835: ldc_w 'after'
/*      */     //   838: astore #17
/*      */     //   840: aload_0
/*      */     //   841: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   844: aload #17
/*      */     //   846: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   849: istore #18
/*      */     //   851: ldc_w 'Family name will be '
/*      */     //   854: astore #19
/*      */     //   856: aload_0
/*      */     //   857: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   860: aload #19
/*      */     //   862: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   865: istore #20
/*      */     //   867: ldc_w ' player name'
/*      */     //   870: astore #21
/*      */     //   872: aload_0
/*      */     //   873: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   876: aload #19
/*      */     //   878: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   881: istore #22
/*      */     //   883: aload #7
/*      */     //   885: aload #19
/*      */     //   887: iload #12
/*      */     //   889: iload #10
/*      */     //   891: iconst_2
/*      */     //   892: idiv
/*      */     //   893: iadd
/*      */     //   894: bipush #122
/*      */     //   896: isub
/*      */     //   897: iload #13
/*      */     //   899: iload #11
/*      */     //   901: iconst_1
/*      */     //   902: iadd
/*      */     //   903: iconst_2
/*      */     //   904: idiv
/*      */     //   905: iadd
/*      */     //   906: bipush #74
/*      */     //   908: isub
/*      */     //   909: iconst_0
/*      */     //   910: invokevirtual func_78276_b : (Ljava/lang/String;III)I
/*      */     //   913: pop
/*      */     //   914: aload_0
/*      */     //   915: getfield field_146292_n : Ljava/util/List;
/*      */     //   918: new JinRyuu/JRMCore/JRMCoreGuiButtons01
/*      */     //   921: dup
/*      */     //   922: bipush #77
/*      */     //   924: iload #12
/*      */     //   926: iload #10
/*      */     //   928: iconst_2
/*      */     //   929: idiv
/*      */     //   930: iadd
/*      */     //   931: bipush #122
/*      */     //   933: isub
/*      */     //   934: iload #20
/*      */     //   936: iadd
/*      */     //   937: iload #13
/*      */     //   939: iload #11
/*      */     //   941: iconst_1
/*      */     //   942: iadd
/*      */     //   943: iconst_2
/*      */     //   944: idiv
/*      */     //   945: iadd
/*      */     //   946: bipush #74
/*      */     //   948: isub
/*      */     //   949: iconst_1
/*      */     //   950: isub
/*      */     //   951: iload #18
/*      */     //   953: aload #17
/*      */     //   955: iconst_0
/*      */     //   956: invokespecial <init> : (IIIILjava/lang/String;I)V
/*      */     //   959: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   964: pop
/*      */     //   965: aload #7
/*      */     //   967: new java/lang/StringBuilder
/*      */     //   970: dup
/*      */     //   971: invokespecial <init> : ()V
/*      */     //   974: aload #21
/*      */     //   976: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   979: ldc_w '.'
/*      */     //   982: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   985: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   988: iload #12
/*      */     //   990: iload #10
/*      */     //   992: iconst_2
/*      */     //   993: idiv
/*      */     //   994: iadd
/*      */     //   995: bipush #122
/*      */     //   997: isub
/*      */     //   998: iload #20
/*      */     //   1000: iload #18
/*      */     //   1002: iadd
/*      */     //   1003: iload #22
/*      */     //   1005: iadd
/*      */     //   1006: sipush #250
/*      */     //   1009: if_icmple -> 1016
/*      */     //   1012: iconst_0
/*      */     //   1013: goto -> 1023
/*      */     //   1016: iload #18
/*      */     //   1018: iload #20
/*      */     //   1020: iadd
/*      */     //   1021: iconst_1
/*      */     //   1022: iadd
/*      */     //   1023: iadd
/*      */     //   1024: iload #13
/*      */     //   1026: iload #11
/*      */     //   1028: iconst_1
/*      */     //   1029: iadd
/*      */     //   1030: iconst_2
/*      */     //   1031: idiv
/*      */     //   1032: iadd
/*      */     //   1033: bipush #74
/*      */     //   1035: isub
/*      */     //   1036: iload #20
/*      */     //   1038: iload #18
/*      */     //   1040: iadd
/*      */     //   1041: iload #22
/*      */     //   1043: iadd
/*      */     //   1044: sipush #250
/*      */     //   1047: if_icmple -> 1055
/*      */     //   1050: bipush #10
/*      */     //   1052: goto -> 1056
/*      */     //   1055: iconst_0
/*      */     //   1056: iadd
/*      */     //   1057: iconst_0
/*      */     //   1058: invokevirtual func_78276_b : (Ljava/lang/String;III)I
/*      */     //   1061: pop
/*      */     //   1062: aload_0
/*      */     //   1063: getfield inputField : Lnet/minecraft/client/gui/GuiTextField;
/*      */     //   1066: ifnonnull -> 1090
/*      */     //   1069: aload_0
/*      */     //   1070: aload #7
/*      */     //   1072: iload #12
/*      */     //   1074: iconst_5
/*      */     //   1075: iadd
/*      */     //   1076: iload #16
/*      */     //   1078: iadd
/*      */     //   1079: iload #13
/*      */     //   1081: bipush #16
/*      */     //   1083: iadd
/*      */     //   1084: invokespecial name : (Lnet/minecraft/client/gui/FontRenderer;II)V
/*      */     //   1087: goto -> 1153
/*      */     //   1090: ldc_w 'Random Name'
/*      */     //   1093: astore #23
/*      */     //   1095: aload_0
/*      */     //   1096: getfield field_146292_n : Ljava/util/List;
/*      */     //   1099: new JinRyuu/JRMCore/JRMCoreGuiButtons00
/*      */     //   1102: dup
/*      */     //   1103: bipush #97
/*      */     //   1105: iload #12
/*      */     //   1107: iload #10
/*      */     //   1109: iconst_2
/*      */     //   1110: idiv
/*      */     //   1111: iadd
/*      */     //   1112: bipush #10
/*      */     //   1114: iadd
/*      */     //   1115: iload #13
/*      */     //   1117: iload #11
/*      */     //   1119: iconst_1
/*      */     //   1120: iadd
/*      */     //   1121: iconst_2
/*      */     //   1122: idiv
/*      */     //   1123: iadd
/*      */     //   1124: bipush #50
/*      */     //   1126: isub
/*      */     //   1127: aload_0
/*      */     //   1128: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   1131: aload #23
/*      */     //   1133: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   1136: bipush #8
/*      */     //   1138: iadd
/*      */     //   1139: bipush #20
/*      */     //   1141: aload #23
/*      */     //   1143: iconst_0
/*      */     //   1144: invokespecial <init> : (IIIIILjava/lang/String;I)V
/*      */     //   1147: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   1152: pop
/*      */     //   1153: aload_0
/*      */     //   1154: getfield inputField : Lnet/minecraft/client/gui/GuiTextField;
/*      */     //   1157: ifnull -> 1177
/*      */     //   1160: aload_0
/*      */     //   1161: getfield inputField : Lnet/minecraft/client/gui/GuiTextField;
/*      */     //   1164: invokevirtual func_146194_f : ()V
/*      */     //   1167: aload_0
/*      */     //   1168: getfield inputField : Lnet/minecraft/client/gui/GuiTextField;
/*      */     //   1171: invokevirtual func_146179_b : ()Ljava/lang/String;
/*      */     //   1174: putstatic JinRyuu/FamilyC/FamilyCCharGui.famNam : Ljava/lang/String;
/*      */     //   1177: iconst_0
/*      */     //   1178: istore #9
/*      */     //   1180: goto -> 4333
/*      */     //   1183: getstatic JinRyuu/FamilyC/FamilyCCharGui.inv : I
/*      */     //   1186: iconst_4
/*      */     //   1187: if_icmpeq -> 1205
/*      */     //   1190: getstatic JinRyuu/FamilyC/FamilyCCharGui.inv : I
/*      */     //   1193: iconst_5
/*      */     //   1194: if_icmpeq -> 1205
/*      */     //   1197: getstatic JinRyuu/FamilyC/FamilyCCharGui.inv : I
/*      */     //   1200: bipush #6
/*      */     //   1202: if_icmpne -> 2180
/*      */     //   1205: ldc ''
/*      */     //   1207: astore #15
/*      */     //   1209: iconst_0
/*      */     //   1210: istore #16
/*      */     //   1212: getstatic JinRyuu/JRMCore/FamilyCH.famMem : [Ljava/lang/String;
/*      */     //   1215: ifnull -> 1389
/*      */     //   1218: getstatic JinRyuu/JRMCore/FamilyCH.famMem : [Ljava/lang/String;
/*      */     //   1221: arraylength
/*      */     //   1222: ifle -> 1389
/*      */     //   1225: iconst_0
/*      */     //   1226: istore #17
/*      */     //   1228: iload #17
/*      */     //   1230: getstatic JinRyuu/JRMCore/FamilyCH.famMem : [Ljava/lang/String;
/*      */     //   1233: arraylength
/*      */     //   1234: if_icmpge -> 1389
/*      */     //   1237: getstatic JinRyuu/JRMCore/FamilyCH.famMem : [Ljava/lang/String;
/*      */     //   1240: iload #17
/*      */     //   1242: aaload
/*      */     //   1243: astore #18
/*      */     //   1245: aload #18
/*      */     //   1247: ldc_w '!'
/*      */     //   1250: invokevirtual contains : (Ljava/lang/CharSequence;)Z
/*      */     //   1253: ifeq -> 1280
/*      */     //   1256: aload #18
/*      */     //   1258: ldc_w '!'
/*      */     //   1261: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
/*      */     //   1264: astore #20
/*      */     //   1266: aload #20
/*      */     //   1268: iconst_1
/*      */     //   1269: aaload
/*      */     //   1270: ldc ','
/*      */     //   1272: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
/*      */     //   1275: astore #19
/*      */     //   1277: goto -> 1289
/*      */     //   1280: aload #18
/*      */     //   1282: ldc ','
/*      */     //   1284: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
/*      */     //   1287: astore #19
/*      */     //   1289: iconst_0
/*      */     //   1290: istore #20
/*      */     //   1292: iconst_0
/*      */     //   1293: istore #21
/*      */     //   1295: iload #21
/*      */     //   1297: aload #19
/*      */     //   1299: arraylength
/*      */     //   1300: if_icmpge -> 1383
/*      */     //   1303: aload #19
/*      */     //   1305: iload #21
/*      */     //   1307: aaload
/*      */     //   1308: astore #22
/*      */     //   1310: aload #22
/*      */     //   1312: ldc ':'
/*      */     //   1314: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
/*      */     //   1317: astore #23
/*      */     //   1319: aload #23
/*      */     //   1321: iconst_0
/*      */     //   1322: aaload
/*      */     //   1323: invokevirtual length : ()I
/*      */     //   1326: iconst_2
/*      */     //   1327: if_icmple -> 1377
/*      */     //   1330: iload #21
/*      */     //   1332: iconst_2
/*      */     //   1333: if_icmpge -> 1377
/*      */     //   1336: iload #16
/*      */     //   1338: iconst_2
/*      */     //   1339: if_icmpge -> 1371
/*      */     //   1342: new java/lang/StringBuilder
/*      */     //   1345: dup
/*      */     //   1346: invokespecial <init> : ()V
/*      */     //   1349: aload #15
/*      */     //   1351: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   1354: ldc ','
/*      */     //   1356: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   1359: aload #23
/*      */     //   1361: iconst_0
/*      */     //   1362: aaload
/*      */     //   1363: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   1366: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   1369: astore #15
/*      */     //   1371: iload #16
/*      */     //   1373: iconst_1
/*      */     //   1374: iadd
/*      */     //   1375: istore #16
/*      */     //   1377: iinc #21, 1
/*      */     //   1380: goto -> 1295
/*      */     //   1383: iinc #17, 1
/*      */     //   1386: goto -> 1228
/*      */     //   1389: aload #15
/*      */     //   1391: invokevirtual length : ()I
/*      */     //   1394: ifle -> 1406
/*      */     //   1397: aload #15
/*      */     //   1399: iconst_1
/*      */     //   1400: invokevirtual substring : (I)Ljava/lang/String;
/*      */     //   1403: goto -> 1408
/*      */     //   1406: ldc ''
/*      */     //   1408: astore #15
/*      */     //   1410: aload #15
/*      */     //   1412: ldc ','
/*      */     //   1414: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
/*      */     //   1417: astore #17
/*      */     //   1419: iconst_0
/*      */     //   1420: istore #18
/*      */     //   1422: iconst_0
/*      */     //   1423: istore #19
/*      */     //   1425: ldc ''
/*      */     //   1427: astore #20
/*      */     //   1429: getstatic JinRyuu/JRMCore/FamilyCH.famMem : [Ljava/lang/String;
/*      */     //   1432: ifnull -> 1982
/*      */     //   1435: getstatic JinRyuu/JRMCore/FamilyCH.famMem : [Ljava/lang/String;
/*      */     //   1438: arraylength
/*      */     //   1439: ifle -> 1982
/*      */     //   1442: iconst_0
/*      */     //   1443: istore #21
/*      */     //   1445: iload #21
/*      */     //   1447: getstatic JinRyuu/JRMCore/FamilyCH.famMem : [Ljava/lang/String;
/*      */     //   1450: arraylength
/*      */     //   1451: if_icmpge -> 1982
/*      */     //   1454: getstatic JinRyuu/JRMCore/FamilyCH.famMem : [Ljava/lang/String;
/*      */     //   1457: iload #21
/*      */     //   1459: aaload
/*      */     //   1460: astore #22
/*      */     //   1462: aload #22
/*      */     //   1464: ldc_w '!'
/*      */     //   1467: invokevirtual contains : (Ljava/lang/CharSequence;)Z
/*      */     //   1470: ifeq -> 1497
/*      */     //   1473: aload #22
/*      */     //   1475: ldc_w '!'
/*      */     //   1478: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
/*      */     //   1481: astore #24
/*      */     //   1483: aload #24
/*      */     //   1485: iconst_1
/*      */     //   1486: aaload
/*      */     //   1487: ldc ','
/*      */     //   1489: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
/*      */     //   1492: astore #23
/*      */     //   1494: goto -> 1506
/*      */     //   1497: aload #22
/*      */     //   1499: ldc ','
/*      */     //   1501: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
/*      */     //   1504: astore #23
/*      */     //   1506: getstatic JinRyuu/JRMCore/FamilyCH.FamP : Ljava/lang/String;
/*      */     //   1509: invokevirtual length : ()I
/*      */     //   1512: ifle -> 1524
/*      */     //   1515: getstatic JinRyuu/JRMCore/FamilyCH.FamP : Ljava/lang/String;
/*      */     //   1518: invokestatic parseInt : (Ljava/lang/String;)I
/*      */     //   1521: goto -> 1525
/*      */     //   1524: iconst_m1
/*      */     //   1525: istore #24
/*      */     //   1527: aload #23
/*      */     //   1529: arraylength
/*      */     //   1530: iconst_1
/*      */     //   1531: if_icmple -> 1976
/*      */     //   1534: getstatic JinRyuu/FamilyC/FamilyCCharGui.inv : I
/*      */     //   1537: iconst_5
/*      */     //   1538: if_icmpeq -> 1549
/*      */     //   1541: getstatic JinRyuu/FamilyC/FamilyCCharGui.inv : I
/*      */     //   1544: bipush #6
/*      */     //   1546: if_icmpne -> 1589
/*      */     //   1549: aload #23
/*      */     //   1551: iconst_0
/*      */     //   1552: aaload
/*      */     //   1553: aload_0
/*      */     //   1554: getfield field_146297_k : Lnet/minecraft/client/Minecraft;
/*      */     //   1557: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*      */     //   1560: invokevirtual func_70005_c_ : ()Ljava/lang/String;
/*      */     //   1563: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   1566: ifne -> 1602
/*      */     //   1569: aload #23
/*      */     //   1571: iconst_1
/*      */     //   1572: aaload
/*      */     //   1573: aload_0
/*      */     //   1574: getfield field_146297_k : Lnet/minecraft/client/Minecraft;
/*      */     //   1577: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*      */     //   1580: invokevirtual func_70005_c_ : ()Ljava/lang/String;
/*      */     //   1583: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   1586: ifne -> 1602
/*      */     //   1589: getstatic JinRyuu/FamilyC/FamilyCCharGui.inv : I
/*      */     //   1592: iconst_4
/*      */     //   1593: if_icmpne -> 1976
/*      */     //   1596: iload #21
/*      */     //   1598: iconst_1
/*      */     //   1599: if_icmple -> 1976
/*      */     //   1602: iconst_0
/*      */     //   1603: istore #25
/*      */     //   1605: iload #25
/*      */     //   1607: aload #23
/*      */     //   1609: arraylength
/*      */     //   1610: if_icmpge -> 1976
/*      */     //   1613: iload #19
/*      */     //   1615: bipush #14
/*      */     //   1617: aload_0
/*      */     //   1618: getfield ipg : I
/*      */     //   1621: bipush #14
/*      */     //   1623: imul
/*      */     //   1624: iadd
/*      */     //   1625: if_icmpgt -> 1970
/*      */     //   1628: iload #19
/*      */     //   1630: iconst_0
/*      */     //   1631: aload_0
/*      */     //   1632: getfield ipg : I
/*      */     //   1635: bipush #14
/*      */     //   1637: imul
/*      */     //   1638: iadd
/*      */     //   1639: if_icmplt -> 1970
/*      */     //   1642: aload #23
/*      */     //   1644: iload #25
/*      */     //   1646: aaload
/*      */     //   1647: astore #26
/*      */     //   1649: aload #26
/*      */     //   1651: ldc ':'
/*      */     //   1653: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
/*      */     //   1656: astore #27
/*      */     //   1658: iconst_1
/*      */     //   1659: istore #28
/*      */     //   1661: iconst_0
/*      */     //   1662: istore #29
/*      */     //   1664: iload #29
/*      */     //   1666: aload #17
/*      */     //   1668: arraylength
/*      */     //   1669: if_icmpge -> 1696
/*      */     //   1672: aload #17
/*      */     //   1674: iload #29
/*      */     //   1676: aaload
/*      */     //   1677: aload #27
/*      */     //   1679: iconst_0
/*      */     //   1680: aaload
/*      */     //   1681: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   1684: ifeq -> 1690
/*      */     //   1687: iconst_0
/*      */     //   1688: istore #28
/*      */     //   1690: iinc #29, 1
/*      */     //   1693: goto -> 1664
/*      */     //   1696: getstatic JinRyuu/FamilyC/FamilyCCharGui.inv : I
/*      */     //   1699: iconst_4
/*      */     //   1700: if_icmpne -> 1751
/*      */     //   1703: iload #21
/*      */     //   1705: iconst_1
/*      */     //   1706: if_icmpgt -> 1720
/*      */     //   1709: iload #25
/*      */     //   1711: iconst_1
/*      */     //   1712: if_icmpgt -> 1720
/*      */     //   1715: iload #28
/*      */     //   1717: ifeq -> 1751
/*      */     //   1720: aload #27
/*      */     //   1722: iconst_0
/*      */     //   1723: aaload
/*      */     //   1724: invokevirtual length : ()I
/*      */     //   1727: iconst_1
/*      */     //   1728: if_icmple -> 1751
/*      */     //   1731: aload #27
/*      */     //   1733: iconst_0
/*      */     //   1734: aaload
/*      */     //   1735: aload_0
/*      */     //   1736: getfield field_146297_k : Lnet/minecraft/client/Minecraft;
/*      */     //   1739: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*      */     //   1742: invokevirtual func_70005_c_ : ()Ljava/lang/String;
/*      */     //   1745: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   1748: ifeq -> 1840
/*      */     //   1751: getstatic JinRyuu/FamilyC/FamilyCCharGui.inv : I
/*      */     //   1754: iconst_5
/*      */     //   1755: if_icmpne -> 1795
/*      */     //   1758: iload #25
/*      */     //   1760: iconst_1
/*      */     //   1761: if_icmpne -> 1795
/*      */     //   1764: aload #27
/*      */     //   1766: iconst_0
/*      */     //   1767: aaload
/*      */     //   1768: invokevirtual length : ()I
/*      */     //   1771: iconst_1
/*      */     //   1772: if_icmple -> 1795
/*      */     //   1775: aload #27
/*      */     //   1777: iconst_0
/*      */     //   1778: aaload
/*      */     //   1779: aload_0
/*      */     //   1780: getfield field_146297_k : Lnet/minecraft/client/Minecraft;
/*      */     //   1783: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*      */     //   1786: invokevirtual func_70005_c_ : ()Ljava/lang/String;
/*      */     //   1789: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   1792: ifeq -> 1840
/*      */     //   1795: getstatic JinRyuu/FamilyC/FamilyCCharGui.inv : I
/*      */     //   1798: bipush #6
/*      */     //   1800: if_icmpne -> 1967
/*      */     //   1803: iload #25
/*      */     //   1805: iconst_1
/*      */     //   1806: if_icmple -> 1967
/*      */     //   1809: aload #27
/*      */     //   1811: iconst_0
/*      */     //   1812: aaload
/*      */     //   1813: invokevirtual length : ()I
/*      */     //   1816: iconst_1
/*      */     //   1817: if_icmple -> 1967
/*      */     //   1820: aload #27
/*      */     //   1822: iconst_0
/*      */     //   1823: aaload
/*      */     //   1824: aload_0
/*      */     //   1825: getfield field_146297_k : Lnet/minecraft/client/Minecraft;
/*      */     //   1828: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*      */     //   1831: invokevirtual func_70005_c_ : ()Ljava/lang/String;
/*      */     //   1834: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   1837: ifne -> 1967
/*      */     //   1840: aload_0
/*      */     //   1841: getfield field_146292_n : Ljava/util/List;
/*      */     //   1844: new JinRyuu/JRMCore/JRMCoreGuiButtons01
/*      */     //   1847: dup
/*      */     //   1848: sipush #2000
/*      */     //   1851: iload #18
/*      */     //   1853: iadd
/*      */     //   1854: iload #12
/*      */     //   1856: iload #10
/*      */     //   1858: iconst_2
/*      */     //   1859: idiv
/*      */     //   1860: iadd
/*      */     //   1861: bipush #122
/*      */     //   1863: isub
/*      */     //   1864: iload #13
/*      */     //   1866: iload #11
/*      */     //   1868: iconst_1
/*      */     //   1869: iadd
/*      */     //   1870: iconst_2
/*      */     //   1871: idiv
/*      */     //   1872: iadd
/*      */     //   1873: bipush #74
/*      */     //   1875: isub
/*      */     //   1876: iload #18
/*      */     //   1878: bipush #10
/*      */     //   1880: imul
/*      */     //   1881: iadd
/*      */     //   1882: aload_0
/*      */     //   1883: getfield ipg : I
/*      */     //   1886: bipush #14
/*      */     //   1888: imul
/*      */     //   1889: bipush #10
/*      */     //   1891: imul
/*      */     //   1892: isub
/*      */     //   1893: aload_0
/*      */     //   1894: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   1897: aload #27
/*      */     //   1899: iconst_0
/*      */     //   1900: aaload
/*      */     //   1901: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   1904: aload #27
/*      */     //   1906: iconst_0
/*      */     //   1907: aaload
/*      */     //   1908: iload #25
/*      */     //   1910: ifeq -> 1919
/*      */     //   1913: iload #25
/*      */     //   1915: iconst_1
/*      */     //   1916: if_icmpne -> 1925
/*      */     //   1919: ldc_w 6579300
/*      */     //   1922: goto -> 1926
/*      */     //   1925: iconst_0
/*      */     //   1926: invokespecial <init> : (IIIILjava/lang/String;I)V
/*      */     //   1929: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   1934: pop
/*      */     //   1935: new java/lang/StringBuilder
/*      */     //   1938: dup
/*      */     //   1939: invokespecial <init> : ()V
/*      */     //   1942: aload #20
/*      */     //   1944: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   1947: ldc ':'
/*      */     //   1949: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   1952: aload #27
/*      */     //   1954: iconst_0
/*      */     //   1955: aaload
/*      */     //   1956: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   1959: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   1962: astore #20
/*      */     //   1964: iinc #18, 1
/*      */     //   1967: iinc #19, 1
/*      */     //   1970: iinc #25, 1
/*      */     //   1973: goto -> 1605
/*      */     //   1976: iinc #21, 1
/*      */     //   1979: goto -> 1445
/*      */     //   1982: aload #20
/*      */     //   1984: invokevirtual length : ()I
/*      */     //   1987: ifle -> 1999
/*      */     //   1990: aload #20
/*      */     //   1992: iconst_1
/*      */     //   1993: invokevirtual substring : (I)Ljava/lang/String;
/*      */     //   1996: goto -> 2001
/*      */     //   1999: aload #20
/*      */     //   2001: astore #20
/*      */     //   2003: aload_0
/*      */     //   2004: aload #20
/*      */     //   2006: putfield dfu : Ljava/lang/String;
/*      */     //   2009: getstatic JinRyuu/JRMCore/FamilyCH.famMem : [Ljava/lang/String;
/*      */     //   2012: arraylength
/*      */     //   2013: iconst_1
/*      */     //   2014: if_icmple -> 2096
/*      */     //   2017: iload #19
/*      */     //   2019: bipush #14
/*      */     //   2021: aload_0
/*      */     //   2022: getfield ipg : I
/*      */     //   2025: bipush #14
/*      */     //   2027: imul
/*      */     //   2028: iadd
/*      */     //   2029: if_icmple -> 2096
/*      */     //   2032: ldc_w 'Next'
/*      */     //   2035: astore #21
/*      */     //   2037: aload_0
/*      */     //   2038: getfield field_146292_n : Ljava/util/List;
/*      */     //   2041: new JinRyuu/JRMCore/JRMCoreGuiButtons00
/*      */     //   2044: dup
/*      */     //   2045: bipush #88
/*      */     //   2047: iload #12
/*      */     //   2049: iload #10
/*      */     //   2051: iconst_2
/*      */     //   2052: idiv
/*      */     //   2053: iadd
/*      */     //   2054: sipush #130
/*      */     //   2057: iadd
/*      */     //   2058: iload #13
/*      */     //   2060: iload #11
/*      */     //   2062: iconst_1
/*      */     //   2063: iadd
/*      */     //   2064: iconst_2
/*      */     //   2065: idiv
/*      */     //   2066: iadd
/*      */     //   2067: bipush #15
/*      */     //   2069: iadd
/*      */     //   2070: aload_0
/*      */     //   2071: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   2074: aload #21
/*      */     //   2076: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   2079: bipush #8
/*      */     //   2081: iadd
/*      */     //   2082: bipush #20
/*      */     //   2084: aload #21
/*      */     //   2086: iconst_0
/*      */     //   2087: invokespecial <init> : (IIIIILjava/lang/String;I)V
/*      */     //   2090: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   2095: pop
/*      */     //   2096: aload_0
/*      */     //   2097: getfield ipg : I
/*      */     //   2100: ifeq -> 2174
/*      */     //   2103: ldc_w 'Prev'
/*      */     //   2106: astore #21
/*      */     //   2108: aload_0
/*      */     //   2109: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   2112: aload #21
/*      */     //   2114: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   2117: bipush #8
/*      */     //   2119: iadd
/*      */     //   2120: istore #22
/*      */     //   2122: aload_0
/*      */     //   2123: getfield field_146292_n : Ljava/util/List;
/*      */     //   2126: new JinRyuu/JRMCore/JRMCoreGuiButtons00
/*      */     //   2129: dup
/*      */     //   2130: bipush #89
/*      */     //   2132: iload #12
/*      */     //   2134: iload #10
/*      */     //   2136: iconst_2
/*      */     //   2137: idiv
/*      */     //   2138: iadd
/*      */     //   2139: sipush #130
/*      */     //   2142: isub
/*      */     //   2143: iload #22
/*      */     //   2145: isub
/*      */     //   2146: iload #13
/*      */     //   2148: iload #11
/*      */     //   2150: iconst_1
/*      */     //   2151: iadd
/*      */     //   2152: iconst_2
/*      */     //   2153: idiv
/*      */     //   2154: iadd
/*      */     //   2155: bipush #15
/*      */     //   2157: iadd
/*      */     //   2158: iload #22
/*      */     //   2160: bipush #20
/*      */     //   2162: aload #21
/*      */     //   2164: iconst_0
/*      */     //   2165: invokespecial <init> : (IIIIILjava/lang/String;I)V
/*      */     //   2168: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   2173: pop
/*      */     //   2174: aload_0
/*      */     //   2175: iload #18
/*      */     //   2177: putfield famMems : I
/*      */     //   2180: getstatic JinRyuu/FamilyC/FamilyCCharGui.inv : I
/*      */     //   2183: iconst_1
/*      */     //   2184: if_icmpeq -> 2194
/*      */     //   2187: getstatic JinRyuu/FamilyC/FamilyCCharGui.inv : I
/*      */     //   2190: iconst_2
/*      */     //   2191: if_icmpne -> 2577
/*      */     //   2194: iconst_0
/*      */     //   2195: istore #15
/*      */     //   2197: iconst_0
/*      */     //   2198: istore #16
/*      */     //   2200: iconst_0
/*      */     //   2201: istore #17
/*      */     //   2203: getstatic JinRyuu/JRMCore/JRMCoreH.plyrs : [Ljava/lang/String;
/*      */     //   2206: ifnull -> 2418
/*      */     //   2209: getstatic JinRyuu/JRMCore/JRMCoreH.plyrs : [Ljava/lang/String;
/*      */     //   2212: arraylength
/*      */     //   2213: ifle -> 2418
/*      */     //   2216: getstatic JinRyuu/JRMCore/FamilyCH.famNams : [Ljava/lang/String;
/*      */     //   2219: ifnull -> 2418
/*      */     //   2222: getstatic JinRyuu/JRMCore/FamilyCH.famNams : [Ljava/lang/String;
/*      */     //   2225: arraylength
/*      */     //   2226: getstatic JinRyuu/JRMCore/JRMCoreH.plyrs : [Ljava/lang/String;
/*      */     //   2229: arraylength
/*      */     //   2230: if_icmplt -> 2418
/*      */     //   2233: iconst_0
/*      */     //   2234: istore #18
/*      */     //   2236: iload #18
/*      */     //   2238: getstatic JinRyuu/JRMCore/JRMCoreH.plyrs : [Ljava/lang/String;
/*      */     //   2241: arraylength
/*      */     //   2242: if_icmpge -> 2418
/*      */     //   2245: iload #15
/*      */     //   2247: bipush #14
/*      */     //   2249: aload_0
/*      */     //   2250: getfield ipg : I
/*      */     //   2253: bipush #14
/*      */     //   2255: imul
/*      */     //   2256: iadd
/*      */     //   2257: if_icmpgt -> 2412
/*      */     //   2260: iload #15
/*      */     //   2262: iconst_0
/*      */     //   2263: aload_0
/*      */     //   2264: getfield ipg : I
/*      */     //   2267: bipush #14
/*      */     //   2269: imul
/*      */     //   2270: iadd
/*      */     //   2271: if_icmplt -> 2412
/*      */     //   2274: getstatic JinRyuu/JRMCore/FamilyCH.famNams : [Ljava/lang/String;
/*      */     //   2277: iload #18
/*      */     //   2279: aaload
/*      */     //   2280: invokevirtual length : ()I
/*      */     //   2283: iconst_2
/*      */     //   2284: if_icmpge -> 2412
/*      */     //   2287: aload_0
/*      */     //   2288: getfield field_146297_k : Lnet/minecraft/client/Minecraft;
/*      */     //   2291: getfield field_71441_e : Lnet/minecraft/client/multiplayer/WorldClient;
/*      */     //   2294: getstatic JinRyuu/JRMCore/JRMCoreH.plyrs : [Ljava/lang/String;
/*      */     //   2297: iload #18
/*      */     //   2299: aaload
/*      */     //   2300: invokevirtual func_72924_a : (Ljava/lang/String;)Lnet/minecraft/entity/player/EntityPlayer;
/*      */     //   2303: astore #19
/*      */     //   2305: aload #19
/*      */     //   2307: ifnull -> 2412
/*      */     //   2310: aload #19
/*      */     //   2312: invokevirtual func_70005_c_ : ()Ljava/lang/String;
/*      */     //   2315: astore #20
/*      */     //   2317: aload #20
/*      */     //   2319: aload_0
/*      */     //   2320: getfield field_146297_k : Lnet/minecraft/client/Minecraft;
/*      */     //   2323: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*      */     //   2326: invokevirtual func_70005_c_ : ()Ljava/lang/String;
/*      */     //   2329: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   2332: ifne -> 2409
/*      */     //   2335: aload_0
/*      */     //   2336: getfield field_146292_n : Ljava/util/List;
/*      */     //   2339: new JinRyuu/JRMCore/JRMCoreGuiButtons01
/*      */     //   2342: dup
/*      */     //   2343: sipush #2000
/*      */     //   2346: iload #18
/*      */     //   2348: iadd
/*      */     //   2349: iload #12
/*      */     //   2351: iload #10
/*      */     //   2353: iconst_2
/*      */     //   2354: idiv
/*      */     //   2355: iadd
/*      */     //   2356: bipush #122
/*      */     //   2358: isub
/*      */     //   2359: iload #13
/*      */     //   2361: iload #11
/*      */     //   2363: iconst_1
/*      */     //   2364: iadd
/*      */     //   2365: iconst_2
/*      */     //   2366: idiv
/*      */     //   2367: iadd
/*      */     //   2368: bipush #74
/*      */     //   2370: isub
/*      */     //   2371: iload #15
/*      */     //   2373: bipush #10
/*      */     //   2375: imul
/*      */     //   2376: iadd
/*      */     //   2377: aload_0
/*      */     //   2378: getfield ipg : I
/*      */     //   2381: bipush #14
/*      */     //   2383: imul
/*      */     //   2384: bipush #10
/*      */     //   2386: imul
/*      */     //   2387: isub
/*      */     //   2388: aload_0
/*      */     //   2389: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   2392: aload #20
/*      */     //   2394: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   2397: aload #20
/*      */     //   2399: iconst_0
/*      */     //   2400: invokespecial <init> : (IIIILjava/lang/String;I)V
/*      */     //   2403: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   2408: pop
/*      */     //   2409: iinc #15, 1
/*      */     //   2412: iinc #18, 1
/*      */     //   2415: goto -> 2236
/*      */     //   2418: getstatic JinRyuu/JRMCore/JRMCoreH.plyrs : [Ljava/lang/String;
/*      */     //   2421: arraylength
/*      */     //   2422: bipush #14
/*      */     //   2424: aload_0
/*      */     //   2425: getfield ipg : I
/*      */     //   2428: bipush #14
/*      */     //   2430: imul
/*      */     //   2431: iadd
/*      */     //   2432: if_icmple -> 2499
/*      */     //   2435: ldc_w 'Next'
/*      */     //   2438: astore #18
/*      */     //   2440: aload_0
/*      */     //   2441: getfield field_146292_n : Ljava/util/List;
/*      */     //   2444: new JinRyuu/JRMCore/JRMCoreGuiButtons00
/*      */     //   2447: dup
/*      */     //   2448: bipush #88
/*      */     //   2450: iload #12
/*      */     //   2452: iload #10
/*      */     //   2454: iconst_2
/*      */     //   2455: idiv
/*      */     //   2456: iadd
/*      */     //   2457: sipush #130
/*      */     //   2460: iadd
/*      */     //   2461: iload #13
/*      */     //   2463: iload #11
/*      */     //   2465: iconst_1
/*      */     //   2466: iadd
/*      */     //   2467: iconst_2
/*      */     //   2468: idiv
/*      */     //   2469: iadd
/*      */     //   2470: bipush #15
/*      */     //   2472: iadd
/*      */     //   2473: aload_0
/*      */     //   2474: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   2477: aload #18
/*      */     //   2479: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   2482: bipush #8
/*      */     //   2484: iadd
/*      */     //   2485: bipush #20
/*      */     //   2487: aload #18
/*      */     //   2489: iconst_0
/*      */     //   2490: invokespecial <init> : (IIIIILjava/lang/String;I)V
/*      */     //   2493: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   2498: pop
/*      */     //   2499: aload_0
/*      */     //   2500: getfield ipg : I
/*      */     //   2503: ifeq -> 2577
/*      */     //   2506: ldc_w 'Prev'
/*      */     //   2509: astore #18
/*      */     //   2511: aload_0
/*      */     //   2512: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   2515: aload #18
/*      */     //   2517: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   2520: bipush #8
/*      */     //   2522: iadd
/*      */     //   2523: istore #19
/*      */     //   2525: aload_0
/*      */     //   2526: getfield field_146292_n : Ljava/util/List;
/*      */     //   2529: new JinRyuu/JRMCore/JRMCoreGuiButtons00
/*      */     //   2532: dup
/*      */     //   2533: bipush #89
/*      */     //   2535: iload #12
/*      */     //   2537: iload #10
/*      */     //   2539: iconst_2
/*      */     //   2540: idiv
/*      */     //   2541: iadd
/*      */     //   2542: sipush #130
/*      */     //   2545: isub
/*      */     //   2546: iload #19
/*      */     //   2548: isub
/*      */     //   2549: iload #13
/*      */     //   2551: iload #11
/*      */     //   2553: iconst_1
/*      */     //   2554: iadd
/*      */     //   2555: iconst_2
/*      */     //   2556: idiv
/*      */     //   2557: iadd
/*      */     //   2558: bipush #15
/*      */     //   2560: iadd
/*      */     //   2561: iload #19
/*      */     //   2563: bipush #20
/*      */     //   2565: aload #18
/*      */     //   2567: iconst_0
/*      */     //   2568: invokespecial <init> : (IIIIILjava/lang/String;I)V
/*      */     //   2571: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   2576: pop
/*      */     //   2577: getstatic JinRyuu/FamilyC/FamilyCCharGui.inv : I
/*      */     //   2580: ifne -> 4256
/*      */     //   2583: getstatic JinRyuu/JRMCore/JRMCoreH.plyrs : [Ljava/lang/String;
/*      */     //   2586: ifnull -> 2751
/*      */     //   2589: getstatic JinRyuu/JRMCore/JRMCoreH.plyrs : [Ljava/lang/String;
/*      */     //   2592: arraylength
/*      */     //   2593: ifle -> 2751
/*      */     //   2596: getstatic JinRyuu/JRMCore/FamilyCH.famNams : [Ljava/lang/String;
/*      */     //   2599: ifnull -> 2751
/*      */     //   2602: iconst_0
/*      */     //   2603: istore #15
/*      */     //   2605: iload #15
/*      */     //   2607: getstatic JinRyuu/JRMCore/JRMCoreH.plyrs : [Ljava/lang/String;
/*      */     //   2610: arraylength
/*      */     //   2611: getstatic JinRyuu/JRMCore/FamilyCH.famNams : [Ljava/lang/String;
/*      */     //   2614: arraylength
/*      */     //   2615: if_icmple -> 2625
/*      */     //   2618: getstatic JinRyuu/JRMCore/FamilyCH.famNams : [Ljava/lang/String;
/*      */     //   2621: arraylength
/*      */     //   2622: goto -> 2629
/*      */     //   2625: getstatic JinRyuu/JRMCore/JRMCoreH.plyrs : [Ljava/lang/String;
/*      */     //   2628: arraylength
/*      */     //   2629: if_icmpge -> 2751
/*      */     //   2632: getstatic JinRyuu/JRMCore/JRMCoreH.plyrs : [Ljava/lang/String;
/*      */     //   2635: iload #15
/*      */     //   2637: aaload
/*      */     //   2638: aload_0
/*      */     //   2639: getfield field_146297_k : Lnet/minecraft/client/Minecraft;
/*      */     //   2642: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*      */     //   2645: invokevirtual func_70005_c_ : ()Ljava/lang/String;
/*      */     //   2648: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   2651: ifeq -> 2745
/*      */     //   2654: getstatic JinRyuu/JRMCore/FamilyCH.famNams : [Ljava/lang/String;
/*      */     //   2657: iload #15
/*      */     //   2659: aaload
/*      */     //   2660: invokevirtual length : ()I
/*      */     //   2663: iconst_2
/*      */     //   2664: if_icmple -> 2745
/*      */     //   2667: getstatic JinRyuu/JRMCore/FamilyCH.famNams : [Ljava/lang/String;
/*      */     //   2670: iload #15
/*      */     //   2672: aaload
/*      */     //   2673: astore #16
/*      */     //   2675: aload #16
/*      */     //   2677: ldc ','
/*      */     //   2679: invokevirtual contains : (Ljava/lang/CharSequence;)Z
/*      */     //   2682: ifeq -> 2698
/*      */     //   2685: aload #16
/*      */     //   2687: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   2690: ldc ','
/*      */     //   2692: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
/*      */     //   2695: goto -> 2699
/*      */     //   2698: aconst_null
/*      */     //   2699: astore #17
/*      */     //   2701: aload #17
/*      */     //   2703: ifnull -> 2745
/*      */     //   2706: aload #7
/*      */     //   2708: new java/lang/StringBuilder
/*      */     //   2711: dup
/*      */     //   2712: invokespecial <init> : ()V
/*      */     //   2715: aload #17
/*      */     //   2717: iconst_0
/*      */     //   2718: aaload
/*      */     //   2719: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   2722: ldc_w ' Family'
/*      */     //   2725: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   2728: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   2731: iload #12
/*      */     //   2733: bipush #15
/*      */     //   2735: iadd
/*      */     //   2736: iload #13
/*      */     //   2738: iconst_5
/*      */     //   2739: iadd
/*      */     //   2740: iconst_0
/*      */     //   2741: invokevirtual func_78276_b : (Ljava/lang/String;III)I
/*      */     //   2744: pop
/*      */     //   2745: iinc #15, 1
/*      */     //   2748: goto -> 2605
/*      */     //   2751: iconst_0
/*      */     //   2752: istore #15
/*      */     //   2754: iconst_0
/*      */     //   2755: istore #16
/*      */     //   2757: iconst_0
/*      */     //   2758: istore #17
/*      */     //   2760: iconst_0
/*      */     //   2761: istore #18
/*      */     //   2763: iconst_0
/*      */     //   2764: istore #19
/*      */     //   2766: iconst_0
/*      */     //   2767: istore #20
/*      */     //   2769: iconst_0
/*      */     //   2770: istore #21
/*      */     //   2772: iconst_0
/*      */     //   2773: istore #22
/*      */     //   2775: iconst_0
/*      */     //   2776: istore #23
/*      */     //   2778: ldc ''
/*      */     //   2780: astore #24
/*      */     //   2782: iconst_0
/*      */     //   2783: istore #25
/*      */     //   2785: getstatic JinRyuu/JRMCore/FamilyCH.famMem : [Ljava/lang/String;
/*      */     //   2788: ifnull -> 3316
/*      */     //   2791: getstatic JinRyuu/JRMCore/FamilyCH.famMem : [Ljava/lang/String;
/*      */     //   2794: arraylength
/*      */     //   2795: ifle -> 3316
/*      */     //   2798: iconst_0
/*      */     //   2799: istore #26
/*      */     //   2801: iload #26
/*      */     //   2803: getstatic JinRyuu/JRMCore/FamilyCH.famMem : [Ljava/lang/String;
/*      */     //   2806: arraylength
/*      */     //   2807: if_icmpge -> 3316
/*      */     //   2810: getstatic JinRyuu/JRMCore/FamilyCH.famMem : [Ljava/lang/String;
/*      */     //   2813: iload #26
/*      */     //   2815: aaload
/*      */     //   2816: astore #27
/*      */     //   2818: aload #27
/*      */     //   2820: ldc_w '!'
/*      */     //   2823: invokevirtual contains : (Ljava/lang/CharSequence;)Z
/*      */     //   2826: ifeq -> 2853
/*      */     //   2829: aload #27
/*      */     //   2831: ldc_w '!'
/*      */     //   2834: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
/*      */     //   2837: astore #29
/*      */     //   2839: aload #29
/*      */     //   2841: iconst_1
/*      */     //   2842: aaload
/*      */     //   2843: ldc ','
/*      */     //   2845: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
/*      */     //   2848: astore #28
/*      */     //   2850: goto -> 2862
/*      */     //   2853: aload #27
/*      */     //   2855: ldc ','
/*      */     //   2857: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
/*      */     //   2860: astore #28
/*      */     //   2862: iconst_0
/*      */     //   2863: istore #29
/*      */     //   2865: iload #29
/*      */     //   2867: aload #28
/*      */     //   2869: arraylength
/*      */     //   2870: if_icmpge -> 3310
/*      */     //   2873: aload #28
/*      */     //   2875: iload #29
/*      */     //   2877: aaload
/*      */     //   2878: astore #30
/*      */     //   2880: aload #30
/*      */     //   2882: ldc ':'
/*      */     //   2884: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
/*      */     //   2887: astore #31
/*      */     //   2889: aload #31
/*      */     //   2891: iconst_0
/*      */     //   2892: aaload
/*      */     //   2893: invokevirtual length : ()I
/*      */     //   2896: iconst_2
/*      */     //   2897: if_icmple -> 3030
/*      */     //   2900: iload #16
/*      */     //   2902: bipush #13
/*      */     //   2904: aload_0
/*      */     //   2905: getfield ipg : I
/*      */     //   2908: bipush #13
/*      */     //   2910: imul
/*      */     //   2911: iadd
/*      */     //   2912: if_icmpgt -> 3030
/*      */     //   2915: iload #16
/*      */     //   2917: iconst_0
/*      */     //   2918: aload_0
/*      */     //   2919: getfield ipg : I
/*      */     //   2922: bipush #13
/*      */     //   2924: imul
/*      */     //   2925: iadd
/*      */     //   2926: if_icmplt -> 3030
/*      */     //   2929: aload #7
/*      */     //   2931: new java/lang/StringBuilder
/*      */     //   2934: dup
/*      */     //   2935: invokespecial <init> : ()V
/*      */     //   2938: aload #31
/*      */     //   2940: iconst_0
/*      */     //   2941: aaload
/*      */     //   2942: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   2945: aload #31
/*      */     //   2947: iconst_0
/*      */     //   2948: aaload
/*      */     //   2949: aload_0
/*      */     //   2950: getfield field_146297_k : Lnet/minecraft/client/Minecraft;
/*      */     //   2953: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*      */     //   2956: invokevirtual func_70005_c_ : ()Ljava/lang/String;
/*      */     //   2959: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   2962: ifeq -> 2971
/*      */     //   2965: ldc_w ' <'
/*      */     //   2968: goto -> 2973
/*      */     //   2971: ldc ''
/*      */     //   2973: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   2976: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   2979: iload #12
/*      */     //   2981: iconst_5
/*      */     //   2982: iadd
/*      */     //   2983: iload #13
/*      */     //   2985: bipush #16
/*      */     //   2987: iadd
/*      */     //   2988: iload #16
/*      */     //   2990: bipush #10
/*      */     //   2992: imul
/*      */     //   2993: iadd
/*      */     //   2994: aload_0
/*      */     //   2995: getfield ipg : I
/*      */     //   2998: bipush #13
/*      */     //   3000: imul
/*      */     //   3001: bipush #10
/*      */     //   3003: imul
/*      */     //   3004: isub
/*      */     //   3005: iload #29
/*      */     //   3007: ifeq -> 3016
/*      */     //   3010: iload #29
/*      */     //   3012: iconst_1
/*      */     //   3013: if_icmpne -> 3022
/*      */     //   3016: ldc_w 6579300
/*      */     //   3019: goto -> 3023
/*      */     //   3022: iconst_0
/*      */     //   3023: invokevirtual func_78276_b : (Ljava/lang/String;III)I
/*      */     //   3026: pop
/*      */     //   3027: iinc #16, 1
/*      */     //   3030: aload #31
/*      */     //   3032: iconst_0
/*      */     //   3033: aaload
/*      */     //   3034: invokevirtual length : ()I
/*      */     //   3037: iconst_2
/*      */     //   3038: if_icmple -> 3118
/*      */     //   3041: iload #29
/*      */     //   3043: iconst_2
/*      */     //   3044: if_icmpge -> 3118
/*      */     //   3047: iload #25
/*      */     //   3049: iconst_2
/*      */     //   3050: if_icmpge -> 3112
/*      */     //   3053: aload #24
/*      */     //   3055: new java/lang/StringBuilder
/*      */     //   3058: dup
/*      */     //   3059: invokespecial <init> : ()V
/*      */     //   3062: ldc ','
/*      */     //   3064: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   3067: aload #31
/*      */     //   3069: iconst_0
/*      */     //   3070: aaload
/*      */     //   3071: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   3074: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   3077: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
/*      */     //   3080: ifne -> 3112
/*      */     //   3083: new java/lang/StringBuilder
/*      */     //   3086: dup
/*      */     //   3087: invokespecial <init> : ()V
/*      */     //   3090: aload #24
/*      */     //   3092: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   3095: ldc ','
/*      */     //   3097: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   3100: aload #31
/*      */     //   3102: iconst_0
/*      */     //   3103: aaload
/*      */     //   3104: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   3107: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   3110: astore #24
/*      */     //   3112: iload #25
/*      */     //   3114: iconst_1
/*      */     //   3115: iadd
/*      */     //   3116: istore #25
/*      */     //   3118: iconst_0
/*      */     //   3119: istore #32
/*      */     //   3121: aload #31
/*      */     //   3123: iconst_0
/*      */     //   3124: aaload
/*      */     //   3125: aload_0
/*      */     //   3126: getfield field_146297_k : Lnet/minecraft/client/Minecraft;
/*      */     //   3129: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*      */     //   3132: invokevirtual func_70005_c_ : ()Ljava/lang/String;
/*      */     //   3135: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   3138: ifeq -> 3147
/*      */     //   3141: iconst_1
/*      */     //   3142: istore #32
/*      */     //   3144: iconst_1
/*      */     //   3145: istore #23
/*      */     //   3147: aload #31
/*      */     //   3149: iconst_0
/*      */     //   3150: aaload
/*      */     //   3151: ldc_w 'Player729'
/*      */     //   3154: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   3157: ifeq -> 3160
/*      */     //   3160: iload #17
/*      */     //   3162: ifne -> 3184
/*      */     //   3165: iload #26
/*      */     //   3167: ifne -> 3184
/*      */     //   3170: iload #29
/*      */     //   3172: iconst_2
/*      */     //   3173: if_icmpge -> 3184
/*      */     //   3176: iload #32
/*      */     //   3178: ifeq -> 3184
/*      */     //   3181: iconst_1
/*      */     //   3182: istore #17
/*      */     //   3184: iload #18
/*      */     //   3186: ifne -> 3213
/*      */     //   3189: iload #29
/*      */     //   3191: ifne -> 3213
/*      */     //   3194: iload #32
/*      */     //   3196: ifeq -> 3213
/*      */     //   3199: aload #28
/*      */     //   3201: iconst_1
/*      */     //   3202: aaload
/*      */     //   3203: invokevirtual length : ()I
/*      */     //   3206: iconst_2
/*      */     //   3207: if_icmple -> 3213
/*      */     //   3210: iconst_1
/*      */     //   3211: istore #18
/*      */     //   3213: iload #19
/*      */     //   3215: ifne -> 3226
/*      */     //   3218: iload #32
/*      */     //   3220: ifeq -> 3226
/*      */     //   3223: iconst_1
/*      */     //   3224: istore #19
/*      */     //   3226: iload #20
/*      */     //   3228: ifne -> 3252
/*      */     //   3231: aload #28
/*      */     //   3233: arraylength
/*      */     //   3234: iconst_2
/*      */     //   3235: if_icmple -> 3252
/*      */     //   3238: iload #29
/*      */     //   3240: iconst_2
/*      */     //   3241: if_icmpge -> 3252
/*      */     //   3244: iload #32
/*      */     //   3246: ifeq -> 3252
/*      */     //   3249: iconst_1
/*      */     //   3250: istore #20
/*      */     //   3252: iload #21
/*      */     //   3254: ifne -> 3301
/*      */     //   3257: iload #32
/*      */     //   3259: ifeq -> 3301
/*      */     //   3262: iload #29
/*      */     //   3264: ifne -> 3281
/*      */     //   3267: aload #28
/*      */     //   3269: iconst_1
/*      */     //   3270: aaload
/*      */     //   3271: invokevirtual length : ()I
/*      */     //   3274: iconst_2
/*      */     //   3275: if_icmpge -> 3301
/*      */     //   3278: goto -> 3298
/*      */     //   3281: iload #29
/*      */     //   3283: iconst_1
/*      */     //   3284: if_icmpne -> 3298
/*      */     //   3287: aload #28
/*      */     //   3289: iconst_0
/*      */     //   3290: aaload
/*      */     //   3291: invokevirtual length : ()I
/*      */     //   3294: iconst_2
/*      */     //   3295: if_icmpge -> 3301
/*      */     //   3298: iconst_1
/*      */     //   3299: istore #21
/*      */     //   3301: iconst_1
/*      */     //   3302: istore #22
/*      */     //   3304: iinc #29, 1
/*      */     //   3307: goto -> 2865
/*      */     //   3310: iinc #26, 1
/*      */     //   3313: goto -> 2801
/*      */     //   3316: aload #24
/*      */     //   3318: invokevirtual length : ()I
/*      */     //   3321: ifle -> 3333
/*      */     //   3324: aload #24
/*      */     //   3326: iconst_1
/*      */     //   3327: invokevirtual substring : (I)Ljava/lang/String;
/*      */     //   3330: goto -> 3335
/*      */     //   3333: ldc ''
/*      */     //   3335: astore #24
/*      */     //   3337: aload #24
/*      */     //   3339: ldc ','
/*      */     //   3341: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
/*      */     //   3344: astore #26
/*      */     //   3346: iconst_0
/*      */     //   3347: istore #27
/*      */     //   3349: iload #27
/*      */     //   3351: aload #26
/*      */     //   3353: arraylength
/*      */     //   3354: if_icmpge -> 3387
/*      */     //   3357: aload #26
/*      */     //   3359: iload #27
/*      */     //   3361: aaload
/*      */     //   3362: aload_0
/*      */     //   3363: getfield field_146297_k : Lnet/minecraft/client/Minecraft;
/*      */     //   3366: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*      */     //   3369: invokevirtual func_70005_c_ : ()Ljava/lang/String;
/*      */     //   3372: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   3375: ifeq -> 3381
/*      */     //   3378: iconst_1
/*      */     //   3379: istore #17
/*      */     //   3381: iinc #27, 1
/*      */     //   3384: goto -> 3349
/*      */     //   3387: iconst_m1
/*      */     //   3388: istore #15
/*      */     //   3390: iload #23
/*      */     //   3392: ifeq -> 4256
/*      */     //   3395: iload #21
/*      */     //   3397: ifeq -> 3494
/*      */     //   3400: iinc #15, 1
/*      */     //   3403: ldc_w 'Propose list'
/*      */     //   3406: astore #27
/*      */     //   3408: aload_0
/*      */     //   3409: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   3412: aload #27
/*      */     //   3414: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   3417: bipush #8
/*      */     //   3419: iadd
/*      */     //   3420: istore #28
/*      */     //   3422: aload_0
/*      */     //   3423: getfield field_146292_n : Ljava/util/List;
/*      */     //   3426: new JinRyuu/JRMCore/JRMCoreGuiButtons00
/*      */     //   3429: dup
/*      */     //   3430: bipush #78
/*      */     //   3432: iload #12
/*      */     //   3434: iload #10
/*      */     //   3436: iconst_2
/*      */     //   3437: idiv
/*      */     //   3438: iadd
/*      */     //   3439: bipush #10
/*      */     //   3441: iadd
/*      */     //   3442: bipush #60
/*      */     //   3444: iadd
/*      */     //   3445: iload #28
/*      */     //   3447: iconst_2
/*      */     //   3448: idiv
/*      */     //   3449: isub
/*      */     //   3450: iload #13
/*      */     //   3452: iload #11
/*      */     //   3454: iconst_1
/*      */     //   3455: iadd
/*      */     //   3456: iconst_2
/*      */     //   3457: idiv
/*      */     //   3458: iadd
/*      */     //   3459: bipush #70
/*      */     //   3461: isub
/*      */     //   3462: iload #15
/*      */     //   3464: bipush #21
/*      */     //   3466: imul
/*      */     //   3467: iadd
/*      */     //   3468: aload_0
/*      */     //   3469: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   3472: aload #27
/*      */     //   3474: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   3477: bipush #8
/*      */     //   3479: iadd
/*      */     //   3480: bipush #20
/*      */     //   3482: aload #27
/*      */     //   3484: iconst_0
/*      */     //   3485: invokespecial <init> : (IIIIILjava/lang/String;I)V
/*      */     //   3488: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   3493: pop
/*      */     //   3494: iload #18
/*      */     //   3496: ifeq -> 3593
/*      */     //   3499: iinc #15, 1
/*      */     //   3502: ldc_w 'Force Divorce'
/*      */     //   3505: astore #27
/*      */     //   3507: aload_0
/*      */     //   3508: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   3511: aload #27
/*      */     //   3513: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   3516: bipush #8
/*      */     //   3518: iadd
/*      */     //   3519: istore #28
/*      */     //   3521: aload_0
/*      */     //   3522: getfield field_146292_n : Ljava/util/List;
/*      */     //   3525: new JinRyuu/JRMCore/JRMCoreGuiButtons00
/*      */     //   3528: dup
/*      */     //   3529: bipush #92
/*      */     //   3531: iload #12
/*      */     //   3533: iload #10
/*      */     //   3535: iconst_2
/*      */     //   3536: idiv
/*      */     //   3537: iadd
/*      */     //   3538: bipush #10
/*      */     //   3540: iadd
/*      */     //   3541: bipush #60
/*      */     //   3543: iadd
/*      */     //   3544: iload #28
/*      */     //   3546: iconst_2
/*      */     //   3547: idiv
/*      */     //   3548: isub
/*      */     //   3549: iload #13
/*      */     //   3551: iload #11
/*      */     //   3553: iconst_1
/*      */     //   3554: iadd
/*      */     //   3555: iconst_2
/*      */     //   3556: idiv
/*      */     //   3557: iadd
/*      */     //   3558: bipush #70
/*      */     //   3560: isub
/*      */     //   3561: iload #15
/*      */     //   3563: bipush #21
/*      */     //   3565: imul
/*      */     //   3566: iadd
/*      */     //   3567: aload_0
/*      */     //   3568: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   3571: aload #27
/*      */     //   3573: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   3576: bipush #8
/*      */     //   3578: iadd
/*      */     //   3579: bipush #20
/*      */     //   3581: aload #27
/*      */     //   3583: iconst_0
/*      */     //   3584: invokespecial <init> : (IIIIILjava/lang/String;I)V
/*      */     //   3587: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   3592: pop
/*      */     //   3593: iload #19
/*      */     //   3595: ifeq -> 3791
/*      */     //   3598: iinc #15, 1
/*      */     //   3601: ldc_w 'Adopt list'
/*      */     //   3604: astore #27
/*      */     //   3606: aload_0
/*      */     //   3607: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   3610: aload #27
/*      */     //   3612: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   3615: bipush #8
/*      */     //   3617: iadd
/*      */     //   3618: istore #28
/*      */     //   3620: aload_0
/*      */     //   3621: getfield field_146292_n : Ljava/util/List;
/*      */     //   3624: new JinRyuu/JRMCore/JRMCoreGuiButtons00
/*      */     //   3627: dup
/*      */     //   3628: bipush #79
/*      */     //   3630: iload #12
/*      */     //   3632: iload #10
/*      */     //   3634: iconst_2
/*      */     //   3635: idiv
/*      */     //   3636: iadd
/*      */     //   3637: bipush #10
/*      */     //   3639: iadd
/*      */     //   3640: bipush #60
/*      */     //   3642: iadd
/*      */     //   3643: iload #28
/*      */     //   3645: iconst_2
/*      */     //   3646: idiv
/*      */     //   3647: isub
/*      */     //   3648: iload #13
/*      */     //   3650: iload #11
/*      */     //   3652: iconst_1
/*      */     //   3653: iadd
/*      */     //   3654: iconst_2
/*      */     //   3655: idiv
/*      */     //   3656: iadd
/*      */     //   3657: bipush #70
/*      */     //   3659: isub
/*      */     //   3660: iload #15
/*      */     //   3662: bipush #21
/*      */     //   3664: imul
/*      */     //   3665: iadd
/*      */     //   3666: aload_0
/*      */     //   3667: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   3670: aload #27
/*      */     //   3672: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   3675: bipush #8
/*      */     //   3677: iadd
/*      */     //   3678: bipush #20
/*      */     //   3680: aload #27
/*      */     //   3682: iconst_0
/*      */     //   3683: invokespecial <init> : (IIIIILjava/lang/String;I)V
/*      */     //   3686: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   3691: pop
/*      */     //   3692: iload #20
/*      */     //   3694: ifeq -> 3791
/*      */     //   3697: iinc #15, 1
/*      */     //   3700: ldc_w 'Unadopt child'
/*      */     //   3703: astore #29
/*      */     //   3705: aload_0
/*      */     //   3706: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   3709: aload #29
/*      */     //   3711: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   3714: bipush #8
/*      */     //   3716: iadd
/*      */     //   3717: istore #30
/*      */     //   3719: aload_0
/*      */     //   3720: getfield field_146292_n : Ljava/util/List;
/*      */     //   3723: new JinRyuu/JRMCore/JRMCoreGuiButtons00
/*      */     //   3726: dup
/*      */     //   3727: bipush #93
/*      */     //   3729: iload #12
/*      */     //   3731: iload #10
/*      */     //   3733: iconst_2
/*      */     //   3734: idiv
/*      */     //   3735: iadd
/*      */     //   3736: bipush #10
/*      */     //   3738: iadd
/*      */     //   3739: bipush #60
/*      */     //   3741: iadd
/*      */     //   3742: iload #30
/*      */     //   3744: iconst_2
/*      */     //   3745: idiv
/*      */     //   3746: isub
/*      */     //   3747: iload #13
/*      */     //   3749: iload #11
/*      */     //   3751: iconst_1
/*      */     //   3752: iadd
/*      */     //   3753: iconst_2
/*      */     //   3754: idiv
/*      */     //   3755: iadd
/*      */     //   3756: bipush #70
/*      */     //   3758: isub
/*      */     //   3759: iload #15
/*      */     //   3761: bipush #21
/*      */     //   3763: imul
/*      */     //   3764: iadd
/*      */     //   3765: aload_0
/*      */     //   3766: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   3769: aload #29
/*      */     //   3771: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   3774: bipush #8
/*      */     //   3776: iadd
/*      */     //   3777: bipush #20
/*      */     //   3779: aload #29
/*      */     //   3781: iconst_0
/*      */     //   3782: invokespecial <init> : (IIIIILjava/lang/String;I)V
/*      */     //   3785: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   3790: pop
/*      */     //   3791: iload #17
/*      */     //   3793: ifeq -> 3890
/*      */     //   3796: iinc #15, 1
/*      */     //   3799: ldc_w 'Disinherit'
/*      */     //   3802: astore #27
/*      */     //   3804: aload_0
/*      */     //   3805: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   3808: aload #27
/*      */     //   3810: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   3813: bipush #8
/*      */     //   3815: iadd
/*      */     //   3816: istore #28
/*      */     //   3818: aload_0
/*      */     //   3819: getfield field_146292_n : Ljava/util/List;
/*      */     //   3822: new JinRyuu/JRMCore/JRMCoreGuiButtons00
/*      */     //   3825: dup
/*      */     //   3826: bipush #91
/*      */     //   3828: iload #12
/*      */     //   3830: iload #10
/*      */     //   3832: iconst_2
/*      */     //   3833: idiv
/*      */     //   3834: iadd
/*      */     //   3835: bipush #10
/*      */     //   3837: iadd
/*      */     //   3838: bipush #60
/*      */     //   3840: iadd
/*      */     //   3841: iload #28
/*      */     //   3843: iconst_2
/*      */     //   3844: idiv
/*      */     //   3845: isub
/*      */     //   3846: iload #13
/*      */     //   3848: iload #11
/*      */     //   3850: iconst_1
/*      */     //   3851: iadd
/*      */     //   3852: iconst_2
/*      */     //   3853: idiv
/*      */     //   3854: iadd
/*      */     //   3855: bipush #70
/*      */     //   3857: isub
/*      */     //   3858: iload #15
/*      */     //   3860: bipush #21
/*      */     //   3862: imul
/*      */     //   3863: iadd
/*      */     //   3864: aload_0
/*      */     //   3865: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   3868: aload #27
/*      */     //   3870: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   3873: bipush #8
/*      */     //   3875: iadd
/*      */     //   3876: bipush #20
/*      */     //   3878: aload #27
/*      */     //   3880: iconst_0
/*      */     //   3881: invokespecial <init> : (IIIIILjava/lang/String;I)V
/*      */     //   3884: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   3889: pop
/*      */     //   3890: iload #21
/*      */     //   3892: ifne -> 3992
/*      */     //   3895: iinc #15, 1
/*      */     //   3898: ldc_w 'Divorce'
/*      */     //   3901: astore #27
/*      */     //   3903: aload_0
/*      */     //   3904: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   3907: aload #27
/*      */     //   3909: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   3912: bipush #8
/*      */     //   3914: iadd
/*      */     //   3915: istore #28
/*      */     //   3917: aload_0
/*      */     //   3918: getfield field_146292_n : Ljava/util/List;
/*      */     //   3921: new JinRyuu/JRMCore/JRMCoreGuiButtons00
/*      */     //   3924: dup
/*      */     //   3925: bipush #85
/*      */     //   3927: iload #12
/*      */     //   3929: iload #10
/*      */     //   3931: iconst_2
/*      */     //   3932: idiv
/*      */     //   3933: iadd
/*      */     //   3934: bipush #10
/*      */     //   3936: iadd
/*      */     //   3937: bipush #60
/*      */     //   3939: iadd
/*      */     //   3940: iload #28
/*      */     //   3942: iconst_2
/*      */     //   3943: idiv
/*      */     //   3944: isub
/*      */     //   3945: iload #13
/*      */     //   3947: iload #11
/*      */     //   3949: iconst_1
/*      */     //   3950: iadd
/*      */     //   3951: iconst_2
/*      */     //   3952: idiv
/*      */     //   3953: iadd
/*      */     //   3954: bipush #70
/*      */     //   3956: isub
/*      */     //   3957: iload #15
/*      */     //   3959: bipush #21
/*      */     //   3961: imul
/*      */     //   3962: iadd
/*      */     //   3963: aload_0
/*      */     //   3964: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   3967: aload #27
/*      */     //   3969: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   3972: bipush #8
/*      */     //   3974: iadd
/*      */     //   3975: bipush #20
/*      */     //   3977: aload #27
/*      */     //   3979: iconst_0
/*      */     //   3980: invokespecial <init> : (IIIIILjava/lang/String;I)V
/*      */     //   3983: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   3988: pop
/*      */     //   3989: goto -> 4086
/*      */     //   3992: iinc #15, 1
/*      */     //   3995: ldc_w 'Leave Family'
/*      */     //   3998: astore #27
/*      */     //   4000: aload_0
/*      */     //   4001: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   4004: aload #27
/*      */     //   4006: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   4009: bipush #8
/*      */     //   4011: iadd
/*      */     //   4012: istore #28
/*      */     //   4014: aload_0
/*      */     //   4015: getfield field_146292_n : Ljava/util/List;
/*      */     //   4018: new JinRyuu/JRMCore/JRMCoreGuiButtons00
/*      */     //   4021: dup
/*      */     //   4022: bipush #85
/*      */     //   4024: iload #12
/*      */     //   4026: iload #10
/*      */     //   4028: iconst_2
/*      */     //   4029: idiv
/*      */     //   4030: iadd
/*      */     //   4031: bipush #10
/*      */     //   4033: iadd
/*      */     //   4034: bipush #60
/*      */     //   4036: iadd
/*      */     //   4037: iload #28
/*      */     //   4039: iconst_2
/*      */     //   4040: idiv
/*      */     //   4041: isub
/*      */     //   4042: iload #13
/*      */     //   4044: iload #11
/*      */     //   4046: iconst_1
/*      */     //   4047: iadd
/*      */     //   4048: iconst_2
/*      */     //   4049: idiv
/*      */     //   4050: iadd
/*      */     //   4051: bipush #70
/*      */     //   4053: isub
/*      */     //   4054: iload #15
/*      */     //   4056: bipush #21
/*      */     //   4058: imul
/*      */     //   4059: iadd
/*      */     //   4060: aload_0
/*      */     //   4061: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   4064: aload #27
/*      */     //   4066: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   4069: bipush #8
/*      */     //   4071: iadd
/*      */     //   4072: bipush #20
/*      */     //   4074: aload #27
/*      */     //   4076: iconst_0
/*      */     //   4077: invokespecial <init> : (IIIIILjava/lang/String;I)V
/*      */     //   4080: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   4085: pop
/*      */     //   4086: getstatic JinRyuu/JRMCore/FamilyCH.famMem : [Ljava/lang/String;
/*      */     //   4089: arraylength
/*      */     //   4090: iconst_1
/*      */     //   4091: if_icmple -> 4173
/*      */     //   4094: iload #16
/*      */     //   4096: bipush #14
/*      */     //   4098: aload_0
/*      */     //   4099: getfield ipg : I
/*      */     //   4102: bipush #14
/*      */     //   4104: imul
/*      */     //   4105: iadd
/*      */     //   4106: if_icmple -> 4173
/*      */     //   4109: ldc_w 'Next'
/*      */     //   4112: astore #27
/*      */     //   4114: aload_0
/*      */     //   4115: getfield field_146292_n : Ljava/util/List;
/*      */     //   4118: new JinRyuu/JRMCore/JRMCoreGuiButtons00
/*      */     //   4121: dup
/*      */     //   4122: bipush #88
/*      */     //   4124: iload #12
/*      */     //   4126: iload #10
/*      */     //   4128: iconst_2
/*      */     //   4129: idiv
/*      */     //   4130: iadd
/*      */     //   4131: sipush #130
/*      */     //   4134: iadd
/*      */     //   4135: iload #13
/*      */     //   4137: iload #11
/*      */     //   4139: iconst_1
/*      */     //   4140: iadd
/*      */     //   4141: iconst_2
/*      */     //   4142: idiv
/*      */     //   4143: iadd
/*      */     //   4144: bipush #15
/*      */     //   4146: iadd
/*      */     //   4147: aload_0
/*      */     //   4148: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   4151: aload #27
/*      */     //   4153: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   4156: bipush #8
/*      */     //   4158: iadd
/*      */     //   4159: bipush #20
/*      */     //   4161: aload #27
/*      */     //   4163: iconst_0
/*      */     //   4164: invokespecial <init> : (IIIIILjava/lang/String;I)V
/*      */     //   4167: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   4172: pop
/*      */     //   4173: aload_0
/*      */     //   4174: getfield ipg : I
/*      */     //   4177: ifeq -> 4251
/*      */     //   4180: ldc_w 'Prev'
/*      */     //   4183: astore #27
/*      */     //   4185: aload_0
/*      */     //   4186: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   4189: aload #27
/*      */     //   4191: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   4194: bipush #8
/*      */     //   4196: iadd
/*      */     //   4197: istore #28
/*      */     //   4199: aload_0
/*      */     //   4200: getfield field_146292_n : Ljava/util/List;
/*      */     //   4203: new JinRyuu/JRMCore/JRMCoreGuiButtons00
/*      */     //   4206: dup
/*      */     //   4207: bipush #89
/*      */     //   4209: iload #12
/*      */     //   4211: iload #10
/*      */     //   4213: iconst_2
/*      */     //   4214: idiv
/*      */     //   4215: iadd
/*      */     //   4216: sipush #130
/*      */     //   4219: isub
/*      */     //   4220: iload #28
/*      */     //   4222: isub
/*      */     //   4223: iload #13
/*      */     //   4225: iload #11
/*      */     //   4227: iconst_1
/*      */     //   4228: iadd
/*      */     //   4229: iconst_2
/*      */     //   4230: idiv
/*      */     //   4231: iadd
/*      */     //   4232: bipush #15
/*      */     //   4234: iadd
/*      */     //   4235: iload #28
/*      */     //   4237: bipush #20
/*      */     //   4239: aload #27
/*      */     //   4241: iconst_0
/*      */     //   4242: invokespecial <init> : (IIIIILjava/lang/String;I)V
/*      */     //   4245: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   4250: pop
/*      */     //   4251: iload #18
/*      */     //   4253: ifeq -> 4256
/*      */     //   4256: getstatic JinRyuu/FamilyC/FamilyCCharGui.inv : I
/*      */     //   4259: ifeq -> 4333
/*      */     //   4262: ldc_w 'Back'
/*      */     //   4265: astore #15
/*      */     //   4267: aload_0
/*      */     //   4268: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   4271: aload #15
/*      */     //   4273: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   4276: bipush #8
/*      */     //   4278: iadd
/*      */     //   4279: istore #16
/*      */     //   4281: aload_0
/*      */     //   4282: getfield field_146292_n : Ljava/util/List;
/*      */     //   4285: new JinRyuu/JRMCore/JRMCoreGuiButtons00
/*      */     //   4288: dup
/*      */     //   4289: bipush #90
/*      */     //   4291: iload #12
/*      */     //   4293: iload #10
/*      */     //   4295: iconst_2
/*      */     //   4296: idiv
/*      */     //   4297: iadd
/*      */     //   4298: sipush #130
/*      */     //   4301: isub
/*      */     //   4302: iload #16
/*      */     //   4304: isub
/*      */     //   4305: iload #13
/*      */     //   4307: iload #11
/*      */     //   4309: iconst_1
/*      */     //   4310: iadd
/*      */     //   4311: iconst_2
/*      */     //   4312: idiv
/*      */     //   4313: iadd
/*      */     //   4314: bipush #40
/*      */     //   4316: iadd
/*      */     //   4317: iload #16
/*      */     //   4319: bipush #20
/*      */     //   4321: aload #15
/*      */     //   4323: iconst_0
/*      */     //   4324: invokespecial <init> : (IIIIILjava/lang/String;I)V
/*      */     //   4327: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   4332: pop
/*      */     //   4333: aload_0
/*      */     //   4334: getfield jfc : I
/*      */     //   4337: ifne -> 4340
/*      */     //   4340: aload_0
/*      */     //   4341: getfield jfc : I
/*      */     //   4344: iconst_1
/*      */     //   4345: if_icmpne -> 6300
/*      */     //   4348: sipush #256
/*      */     //   4351: istore #10
/*      */     //   4353: sipush #159
/*      */     //   4356: istore #11
/*      */     //   4358: aload_0
/*      */     //   4359: getfield field_146294_l : I
/*      */     //   4362: iload #10
/*      */     //   4364: isub
/*      */     //   4365: iconst_2
/*      */     //   4366: idiv
/*      */     //   4367: istore #12
/*      */     //   4369: aload_0
/*      */     //   4370: getfield field_146295_m : I
/*      */     //   4373: iload #11
/*      */     //   4375: isub
/*      */     //   4376: iconst_2
/*      */     //   4377: idiv
/*      */     //   4378: istore #13
/*      */     //   4380: fconst_1
/*      */     //   4381: fconst_1
/*      */     //   4382: fconst_1
/*      */     //   4383: fconst_1
/*      */     //   4384: invokestatic glColor4f : (FFFF)V
/*      */     //   4387: new net/minecraft/util/ResourceLocation
/*      */     //   4390: dup
/*      */     //   4391: aload #8
/*      */     //   4393: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   4396: astore #14
/*      */     //   4398: aload_0
/*      */     //   4399: getfield field_146297_k : Lnet/minecraft/client/Minecraft;
/*      */     //   4402: getfield field_71446_o : Lnet/minecraft/client/renderer/texture/TextureManager;
/*      */     //   4405: aload #14
/*      */     //   4407: invokevirtual func_110577_a : (Lnet/minecraft/util/ResourceLocation;)V
/*      */     //   4410: aload_0
/*      */     //   4411: iload #12
/*      */     //   4413: iload #13
/*      */     //   4415: iconst_0
/*      */     //   4416: iconst_0
/*      */     //   4417: iload #10
/*      */     //   4419: iload #11
/*      */     //   4421: invokevirtual func_73729_b : (IIIIII)V
/*      */     //   4424: aload_0
/*      */     //   4425: getfield field_146292_n : Ljava/util/List;
/*      */     //   4428: new JinRyuu/JRMCore/JRMCoreGuiButtonsTab
/*      */     //   4431: dup
/*      */     //   4432: bipush #62
/*      */     //   4434: iload #12
/*      */     //   4436: iload #10
/*      */     //   4438: iconst_2
/*      */     //   4439: idiv
/*      */     //   4440: iadd
/*      */     //   4441: bipush #10
/*      */     //   4443: isub
/*      */     //   4444: iload #13
/*      */     //   4446: iload #11
/*      */     //   4448: iconst_1
/*      */     //   4449: iadd
/*      */     //   4450: iconst_2
/*      */     //   4451: idiv
/*      */     //   4452: iadd
/*      */     //   4453: bipush #99
/*      */     //   4455: isub
/*      */     //   4456: bipush #60
/*      */     //   4458: bipush #20
/*      */     //   4460: ldc_w 'Family'
/*      */     //   4463: iconst_0
/*      */     //   4464: invokespecial <init> : (IIIIILjava/lang/String;I)V
/*      */     //   4467: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   4472: pop
/*      */     //   4473: aload_0
/*      */     //   4474: getfield field_146292_n : Ljava/util/List;
/*      */     //   4477: new JinRyuu/JRMCore/JRMCoreGuiButtonsTab
/*      */     //   4480: dup
/*      */     //   4481: bipush #60
/*      */     //   4483: iload #12
/*      */     //   4485: iload #10
/*      */     //   4487: iconst_2
/*      */     //   4488: idiv
/*      */     //   4489: iadd
/*      */     //   4490: bipush #110
/*      */     //   4492: isub
/*      */     //   4493: iload #13
/*      */     //   4495: iload #11
/*      */     //   4497: iconst_1
/*      */     //   4498: iadd
/*      */     //   4499: iconst_2
/*      */     //   4500: idiv
/*      */     //   4501: iadd
/*      */     //   4502: bipush #99
/*      */     //   4504: isub
/*      */     //   4505: bipush #60
/*      */     //   4507: bipush #20
/*      */     //   4509: ldc_w 'Status'
/*      */     //   4512: iconst_1
/*      */     //   4513: invokespecial <init> : (IIIIILjava/lang/String;I)V
/*      */     //   4516: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   4521: pop
/*      */     //   4522: aload_0
/*      */     //   4523: getfield field_146292_n : Ljava/util/List;
/*      */     //   4526: new JinRyuu/JRMCore/JRMCoreGuiButtons00
/*      */     //   4529: dup
/*      */     //   4530: bipush #10
/*      */     //   4532: iload #12
/*      */     //   4534: iload #10
/*      */     //   4536: iconst_2
/*      */     //   4537: idiv
/*      */     //   4538: iadd
/*      */     //   4539: sipush #150
/*      */     //   4542: isub
/*      */     //   4543: iload #13
/*      */     //   4545: iload #11
/*      */     //   4547: iconst_2
/*      */     //   4548: idiv
/*      */     //   4549: iadd
/*      */     //   4550: bipush #65
/*      */     //   4552: iadd
/*      */     //   4553: bipush #20
/*      */     //   4555: bipush #20
/*      */     //   4557: ldc_w 'X'
/*      */     //   4560: iconst_0
/*      */     //   4561: invokespecial <init> : (IIIIILjava/lang/String;I)V
/*      */     //   4564: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   4569: pop
/*      */     //   4570: getstatic JinRyuu/JRMCore/JRMCoreH.proc : Ljava/lang/String;
/*      */     //   4573: ifnull -> 4874
/*      */     //   4576: getstatic JinRyuu/JRMCore/JRMCoreH.proc : Ljava/lang/String;
/*      */     //   4579: ldc_w ';'
/*      */     //   4582: invokevirtual contains : (Ljava/lang/CharSequence;)Z
/*      */     //   4585: ifeq -> 4874
/*      */     //   4588: getstatic JinRyuu/JRMCore/JRMCoreH.proc : Ljava/lang/String;
/*      */     //   4591: ldc_w ';'
/*      */     //   4594: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
/*      */     //   4597: astore #15
/*      */     //   4599: aload #15
/*      */     //   4601: arraylength
/*      */     //   4602: iconst_3
/*      */     //   4603: if_icmple -> 4871
/*      */     //   4606: aload #15
/*      */     //   4608: iconst_4
/*      */     //   4609: aaload
/*      */     //   4610: invokestatic parseInt : (Ljava/lang/String;)I
/*      */     //   4613: istore #16
/*      */     //   4615: new java/lang/StringBuilder
/*      */     //   4618: dup
/*      */     //   4619: invokespecial <init> : ()V
/*      */     //   4622: ldc_w 'Pregnancy will be over in '
/*      */     //   4625: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   4628: iload #16
/*      */     //   4630: bipush #12
/*      */     //   4632: if_icmple -> 4664
/*      */     //   4635: new java/lang/StringBuilder
/*      */     //   4638: dup
/*      */     //   4639: invokespecial <init> : ()V
/*      */     //   4642: iload #16
/*      */     //   4644: bipush #12
/*      */     //   4646: idiv
/*      */     //   4647: iconst_1
/*      */     //   4648: iadd
/*      */     //   4649: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*      */     //   4652: ldc_w ' minutes'
/*      */     //   4655: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   4658: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   4661: goto -> 4687
/*      */     //   4664: new java/lang/StringBuilder
/*      */     //   4667: dup
/*      */     //   4668: invokespecial <init> : ()V
/*      */     //   4671: iload #16
/*      */     //   4673: iconst_5
/*      */     //   4674: imul
/*      */     //   4675: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*      */     //   4678: ldc_w ' seconds'
/*      */     //   4681: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   4684: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   4687: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   4690: ldc_w '.'
/*      */     //   4693: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   4696: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   4699: astore #17
/*      */     //   4701: aload #7
/*      */     //   4703: aload #17
/*      */     //   4705: iload #12
/*      */     //   4707: iload #10
/*      */     //   4709: iconst_2
/*      */     //   4710: idiv
/*      */     //   4711: iadd
/*      */     //   4712: bipush #122
/*      */     //   4714: isub
/*      */     //   4715: iload #13
/*      */     //   4717: iload #11
/*      */     //   4719: iconst_1
/*      */     //   4720: iadd
/*      */     //   4721: iconst_2
/*      */     //   4722: idiv
/*      */     //   4723: iadd
/*      */     //   4724: bipush #74
/*      */     //   4726: isub
/*      */     //   4727: bipush #60
/*      */     //   4729: iadd
/*      */     //   4730: iconst_0
/*      */     //   4731: invokevirtual func_78276_b : (Ljava/lang/String;III)I
/*      */     //   4734: pop
/*      */     //   4735: new java/lang/StringBuilder
/*      */     //   4738: dup
/*      */     //   4739: invokespecial <init> : ()V
/*      */     //   4742: ldc_w 'Child name will be: '
/*      */     //   4745: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   4748: aload #15
/*      */     //   4750: iconst_3
/*      */     //   4751: aaload
/*      */     //   4752: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   4755: ldc_w '.'
/*      */     //   4758: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   4761: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   4764: astore #17
/*      */     //   4766: aload #7
/*      */     //   4768: aload #17
/*      */     //   4770: iload #12
/*      */     //   4772: iload #10
/*      */     //   4774: iconst_2
/*      */     //   4775: idiv
/*      */     //   4776: iadd
/*      */     //   4777: bipush #122
/*      */     //   4779: isub
/*      */     //   4780: iload #13
/*      */     //   4782: iload #11
/*      */     //   4784: iconst_1
/*      */     //   4785: iadd
/*      */     //   4786: iconst_2
/*      */     //   4787: idiv
/*      */     //   4788: iadd
/*      */     //   4789: bipush #74
/*      */     //   4791: isub
/*      */     //   4792: bipush #60
/*      */     //   4794: iadd
/*      */     //   4795: bipush #10
/*      */     //   4797: iadd
/*      */     //   4798: iconst_0
/*      */     //   4799: invokevirtual func_78276_b : (Ljava/lang/String;III)I
/*      */     //   4802: pop
/*      */     //   4803: new java/lang/StringBuilder
/*      */     //   4806: dup
/*      */     //   4807: invokespecial <init> : ()V
/*      */     //   4810: ldc_w 'Childs father is: '
/*      */     //   4813: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   4816: aload #15
/*      */     //   4818: iconst_2
/*      */     //   4819: aaload
/*      */     //   4820: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   4823: ldc_w '.'
/*      */     //   4826: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   4829: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   4832: astore #17
/*      */     //   4834: aload #7
/*      */     //   4836: aload #17
/*      */     //   4838: iload #12
/*      */     //   4840: iload #10
/*      */     //   4842: iconst_2
/*      */     //   4843: idiv
/*      */     //   4844: iadd
/*      */     //   4845: bipush #122
/*      */     //   4847: isub
/*      */     //   4848: iload #13
/*      */     //   4850: iload #11
/*      */     //   4852: iconst_1
/*      */     //   4853: iadd
/*      */     //   4854: iconst_2
/*      */     //   4855: idiv
/*      */     //   4856: iadd
/*      */     //   4857: bipush #74
/*      */     //   4859: isub
/*      */     //   4860: bipush #60
/*      */     //   4862: iadd
/*      */     //   4863: bipush #20
/*      */     //   4865: iadd
/*      */     //   4866: iconst_0
/*      */     //   4867: invokevirtual func_78276_b : (Ljava/lang/String;III)I
/*      */     //   4870: pop
/*      */     //   4871: goto -> 5513
/*      */     //   4874: getstatic JinRyuu/JRMCore/JRMCoreH.proc : Ljava/lang/String;
/*      */     //   4877: ifnull -> 5285
/*      */     //   4880: getstatic JinRyuu/JRMCore/JRMCoreH.proc : Ljava/lang/String;
/*      */     //   4883: invokevirtual length : ()I
/*      */     //   4886: iconst_2
/*      */     //   4887: if_icmple -> 5285
/*      */     //   4890: getstatic JinRyuu/JRMCore/JRMCoreH.proc : Ljava/lang/String;
/*      */     //   4893: ldc_w ';'
/*      */     //   4896: invokevirtual contains : (Ljava/lang/CharSequence;)Z
/*      */     //   4899: ifne -> 5285
/*      */     //   4902: getstatic JinRyuu/JRMCore/JRMCoreH.proc : Ljava/lang/String;
/*      */     //   4905: astore #15
/*      */     //   4907: new java/lang/StringBuilder
/*      */     //   4910: dup
/*      */     //   4911: invokespecial <init> : ()V
/*      */     //   4914: ldc_w 'Procreation offer from '
/*      */     //   4917: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   4920: aload #15
/*      */     //   4922: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   4925: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   4928: astore #16
/*      */     //   4930: aload #7
/*      */     //   4932: aload #16
/*      */     //   4934: iload #12
/*      */     //   4936: iload #10
/*      */     //   4938: iconst_2
/*      */     //   4939: idiv
/*      */     //   4940: iadd
/*      */     //   4941: bipush #122
/*      */     //   4943: isub
/*      */     //   4944: iload #13
/*      */     //   4946: iload #11
/*      */     //   4948: iconst_1
/*      */     //   4949: iadd
/*      */     //   4950: iconst_2
/*      */     //   4951: idiv
/*      */     //   4952: iadd
/*      */     //   4953: bipush #74
/*      */     //   4955: isub
/*      */     //   4956: bipush #60
/*      */     //   4958: iadd
/*      */     //   4959: iconst_0
/*      */     //   4960: invokevirtual func_78276_b : (Ljava/lang/String;III)I
/*      */     //   4963: pop
/*      */     //   4964: ldc_w 'Accept'
/*      */     //   4967: astore #17
/*      */     //   4969: aload_0
/*      */     //   4970: getfield field_146292_n : Ljava/util/List;
/*      */     //   4973: new JinRyuu/JRMCore/JRMCoreGuiButtons00
/*      */     //   4976: dup
/*      */     //   4977: bipush #94
/*      */     //   4979: iload #12
/*      */     //   4981: iload #10
/*      */     //   4983: iconst_2
/*      */     //   4984: idiv
/*      */     //   4985: iadd
/*      */     //   4986: bipush #10
/*      */     //   4988: iadd
/*      */     //   4989: bipush #80
/*      */     //   4991: isub
/*      */     //   4992: iload #13
/*      */     //   4994: iload #11
/*      */     //   4996: iconst_1
/*      */     //   4997: iadd
/*      */     //   4998: iconst_2
/*      */     //   4999: idiv
/*      */     //   5000: iadd
/*      */     //   5001: bipush #50
/*      */     //   5003: isub
/*      */     //   5004: bipush #65
/*      */     //   5006: iadd
/*      */     //   5007: aload_0
/*      */     //   5008: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   5011: aload #17
/*      */     //   5013: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   5016: bipush #8
/*      */     //   5018: iadd
/*      */     //   5019: bipush #20
/*      */     //   5021: aload #17
/*      */     //   5023: iconst_0
/*      */     //   5024: invokespecial <init> : (IIIIILjava/lang/String;I)V
/*      */     //   5027: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   5032: pop
/*      */     //   5033: ldc_w 'Decline'
/*      */     //   5036: astore #18
/*      */     //   5038: aload_0
/*      */     //   5039: getfield field_146292_n : Ljava/util/List;
/*      */     //   5042: new JinRyuu/JRMCore/JRMCoreGuiButtons00
/*      */     //   5045: dup
/*      */     //   5046: bipush #95
/*      */     //   5048: iload #12
/*      */     //   5050: iload #10
/*      */     //   5052: iconst_2
/*      */     //   5053: idiv
/*      */     //   5054: iadd
/*      */     //   5055: bipush #10
/*      */     //   5057: iadd
/*      */     //   5058: bipush #20
/*      */     //   5060: isub
/*      */     //   5061: iload #13
/*      */     //   5063: iload #11
/*      */     //   5065: iconst_1
/*      */     //   5066: iadd
/*      */     //   5067: iconst_2
/*      */     //   5068: idiv
/*      */     //   5069: iadd
/*      */     //   5070: bipush #50
/*      */     //   5072: isub
/*      */     //   5073: bipush #65
/*      */     //   5075: iadd
/*      */     //   5076: aload_0
/*      */     //   5077: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   5080: aload #18
/*      */     //   5082: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   5085: bipush #8
/*      */     //   5087: iadd
/*      */     //   5088: bipush #20
/*      */     //   5090: aload #18
/*      */     //   5092: iconst_0
/*      */     //   5093: invokespecial <init> : (IIIIILjava/lang/String;I)V
/*      */     //   5096: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   5101: pop
/*      */     //   5102: ldc_w 'Child name: '
/*      */     //   5105: astore #19
/*      */     //   5107: aload_0
/*      */     //   5108: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   5111: aload #19
/*      */     //   5113: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   5116: istore #20
/*      */     //   5118: aload #7
/*      */     //   5120: aload #19
/*      */     //   5122: iload #12
/*      */     //   5124: iload #10
/*      */     //   5126: iconst_2
/*      */     //   5127: idiv
/*      */     //   5128: iadd
/*      */     //   5129: bipush #122
/*      */     //   5131: isub
/*      */     //   5132: iload #13
/*      */     //   5134: iload #11
/*      */     //   5136: iconst_1
/*      */     //   5137: iadd
/*      */     //   5138: iconst_2
/*      */     //   5139: idiv
/*      */     //   5140: iadd
/*      */     //   5141: bipush #74
/*      */     //   5143: isub
/*      */     //   5144: bipush #70
/*      */     //   5146: iadd
/*      */     //   5147: iconst_0
/*      */     //   5148: invokevirtual func_78276_b : (Ljava/lang/String;III)I
/*      */     //   5151: pop
/*      */     //   5152: aload_0
/*      */     //   5153: getfield inputField : Lnet/minecraft/client/gui/GuiTextField;
/*      */     //   5156: ifnonnull -> 5182
/*      */     //   5159: aload_0
/*      */     //   5160: aload #7
/*      */     //   5162: iload #12
/*      */     //   5164: iconst_5
/*      */     //   5165: iadd
/*      */     //   5166: iload #20
/*      */     //   5168: iadd
/*      */     //   5169: iload #13
/*      */     //   5171: bipush #75
/*      */     //   5173: iadd
/*      */     //   5174: iconst_1
/*      */     //   5175: iadd
/*      */     //   5176: invokespecial name : (Lnet/minecraft/client/gui/FontRenderer;II)V
/*      */     //   5179: goto -> 5255
/*      */     //   5182: ldc_w 'Random Name'
/*      */     //   5185: astore #21
/*      */     //   5187: aload_0
/*      */     //   5188: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   5191: aload #21
/*      */     //   5193: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   5196: bipush #8
/*      */     //   5198: iadd
/*      */     //   5199: istore #22
/*      */     //   5201: aload_0
/*      */     //   5202: getfield field_146292_n : Ljava/util/List;
/*      */     //   5205: new JinRyuu/JRMCore/JRMCoreGuiButtons00
/*      */     //   5208: dup
/*      */     //   5209: bipush #97
/*      */     //   5211: iload #12
/*      */     //   5213: iload #10
/*      */     //   5215: iconst_2
/*      */     //   5216: idiv
/*      */     //   5217: iadd
/*      */     //   5218: bipush #10
/*      */     //   5220: iadd
/*      */     //   5221: bipush #30
/*      */     //   5223: iadd
/*      */     //   5224: iload #13
/*      */     //   5226: iload #11
/*      */     //   5228: iconst_1
/*      */     //   5229: iadd
/*      */     //   5230: iconst_2
/*      */     //   5231: idiv
/*      */     //   5232: iadd
/*      */     //   5233: bipush #50
/*      */     //   5235: isub
/*      */     //   5236: bipush #45
/*      */     //   5238: iadd
/*      */     //   5239: iload #22
/*      */     //   5241: bipush #20
/*      */     //   5243: aload #21
/*      */     //   5245: iconst_0
/*      */     //   5246: invokespecial <init> : (IIIIILjava/lang/String;I)V
/*      */     //   5249: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   5254: pop
/*      */     //   5255: aload_0
/*      */     //   5256: getfield inputField : Lnet/minecraft/client/gui/GuiTextField;
/*      */     //   5259: ifnull -> 5279
/*      */     //   5262: aload_0
/*      */     //   5263: getfield inputField : Lnet/minecraft/client/gui/GuiTextField;
/*      */     //   5266: invokevirtual func_146194_f : ()V
/*      */     //   5269: aload_0
/*      */     //   5270: getfield inputField : Lnet/minecraft/client/gui/GuiTextField;
/*      */     //   5273: invokevirtual func_146179_b : ()Ljava/lang/String;
/*      */     //   5276: putstatic JinRyuu/FamilyC/FamilyCCharGui.chiNam : Ljava/lang/String;
/*      */     //   5279: iconst_0
/*      */     //   5280: istore #9
/*      */     //   5282: goto -> 5513
/*      */     //   5285: getstatic JinRyuu/JRMCore/JRMCoreH.targ : Lnet/minecraft/entity/Entity;
/*      */     //   5288: ifnull -> 5513
/*      */     //   5291: getstatic JinRyuu/JRMCore/JRMCoreH.proc : Ljava/lang/String;
/*      */     //   5294: ifnull -> 5513
/*      */     //   5297: getstatic JinRyuu/JRMCore/JRMCoreH.proc : Ljava/lang/String;
/*      */     //   5300: ldc_w ';'
/*      */     //   5303: invokevirtual contains : (Ljava/lang/CharSequence;)Z
/*      */     //   5306: ifne -> 5513
/*      */     //   5309: iconst_0
/*      */     //   5310: istore #15
/*      */     //   5312: iconst_0
/*      */     //   5313: istore #16
/*      */     //   5315: getstatic JinRyuu/JRMCore/JRMCoreH.plyrs : [Ljava/lang/String;
/*      */     //   5318: ifnull -> 5403
/*      */     //   5321: getstatic JinRyuu/JRMCore/JRMCoreH.plyrs : [Ljava/lang/String;
/*      */     //   5324: arraylength
/*      */     //   5325: ifle -> 5403
/*      */     //   5328: iconst_1
/*      */     //   5329: invokestatic dnn : (I)Z
/*      */     //   5332: ifeq -> 5403
/*      */     //   5335: iconst_0
/*      */     //   5336: istore #17
/*      */     //   5338: iload #17
/*      */     //   5340: getstatic JinRyuu/JRMCore/JRMCoreH.plyrs : [Ljava/lang/String;
/*      */     //   5343: arraylength
/*      */     //   5344: if_icmpge -> 5403
/*      */     //   5347: getstatic JinRyuu/JRMCore/JRMCoreH.plyrs : [Ljava/lang/String;
/*      */     //   5350: iload #17
/*      */     //   5352: aaload
/*      */     //   5353: getstatic JinRyuu/JRMCore/JRMCoreH.targ : Lnet/minecraft/entity/Entity;
/*      */     //   5356: invokevirtual func_70005_c_ : ()Ljava/lang/String;
/*      */     //   5359: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   5362: ifeq -> 5397
/*      */     //   5365: getstatic JinRyuu/JRMCore/JRMCoreH.data1 : [Ljava/lang/String;
/*      */     //   5368: iload #17
/*      */     //   5370: aaload
/*      */     //   5371: ldc_w ';'
/*      */     //   5374: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
/*      */     //   5377: astore #18
/*      */     //   5379: aload #18
/*      */     //   5381: iconst_1
/*      */     //   5382: aaload
/*      */     //   5383: invokestatic dnsGender : (Ljava/lang/String;)I
/*      */     //   5386: istore #15
/*      */     //   5388: aload #18
/*      */     //   5390: iconst_0
/*      */     //   5391: aaload
/*      */     //   5392: invokestatic parseInt : (Ljava/lang/String;)I
/*      */     //   5395: istore #16
/*      */     //   5397: iinc #17, 1
/*      */     //   5400: goto -> 5338
/*      */     //   5403: iload #15
/*      */     //   5405: getstatic JinRyuu/JRMCore/JRMCoreH.dns : Ljava/lang/String;
/*      */     //   5408: invokestatic dnsGender : (Ljava/lang/String;)I
/*      */     //   5411: if_icmpeq -> 5513
/*      */     //   5414: getstatic JinRyuu/JRMCore/JRMCoreH.Race : B
/*      */     //   5417: iload #16
/*      */     //   5419: invokestatic procWith : (II)Z
/*      */     //   5422: ifeq -> 5513
/*      */     //   5425: ldc_w 'Procreation'
/*      */     //   5428: astore #17
/*      */     //   5430: aload_0
/*      */     //   5431: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   5434: aload #17
/*      */     //   5436: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   5439: bipush #8
/*      */     //   5441: iadd
/*      */     //   5442: istore #18
/*      */     //   5444: aload_0
/*      */     //   5445: getfield field_146292_n : Ljava/util/List;
/*      */     //   5448: new JinRyuu/JRMCore/JRMCoreGuiButtons00
/*      */     //   5451: dup
/*      */     //   5452: bipush #96
/*      */     //   5454: iload #12
/*      */     //   5456: iload #10
/*      */     //   5458: iconst_2
/*      */     //   5459: idiv
/*      */     //   5460: iadd
/*      */     //   5461: bipush #10
/*      */     //   5463: iadd
/*      */     //   5464: bipush #60
/*      */     //   5466: iadd
/*      */     //   5467: iload #18
/*      */     //   5469: iconst_2
/*      */     //   5470: idiv
/*      */     //   5471: isub
/*      */     //   5472: iload #13
/*      */     //   5474: iload #11
/*      */     //   5476: iconst_1
/*      */     //   5477: iadd
/*      */     //   5478: iconst_2
/*      */     //   5479: idiv
/*      */     //   5480: iadd
/*      */     //   5481: bipush #50
/*      */     //   5483: isub
/*      */     //   5484: bipush #45
/*      */     //   5486: iadd
/*      */     //   5487: aload_0
/*      */     //   5488: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   5491: aload #17
/*      */     //   5493: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   5496: bipush #8
/*      */     //   5498: iadd
/*      */     //   5499: bipush #20
/*      */     //   5501: aload #17
/*      */     //   5503: iconst_0
/*      */     //   5504: invokespecial <init> : (IIIIILjava/lang/String;I)V
/*      */     //   5507: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   5512: pop
/*      */     //   5513: iconst_0
/*      */     //   5514: istore #15
/*      */     //   5516: iconst_0
/*      */     //   5517: istore #16
/*      */     //   5519: ldc ''
/*      */     //   5521: astore #17
/*      */     //   5523: ldc ''
/*      */     //   5525: astore #18
/*      */     //   5527: ldc ''
/*      */     //   5529: astore #19
/*      */     //   5531: ldc ''
/*      */     //   5533: astore #20
/*      */     //   5535: getstatic JinRyuu/JRMCore/JRMCoreH.targ : Lnet/minecraft/entity/Entity;
/*      */     //   5538: ifnonnull -> 5559
/*      */     //   5541: aload_0
/*      */     //   5542: getfield field_146297_k : Lnet/minecraft/client/Minecraft;
/*      */     //   5545: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*      */     //   5548: invokevirtual func_70005_c_ : ()Ljava/lang/String;
/*      */     //   5551: invokestatic jrmcPDtaDNS : (Ljava/lang/String;)Ljava/lang/String;
/*      */     //   5554: astore #20
/*      */     //   5556: goto -> 5576
/*      */     //   5559: getstatic JinRyuu/JRMCore/JRMCoreH.targ : Lnet/minecraft/entity/Entity;
/*      */     //   5562: ifnull -> 5576
/*      */     //   5565: getstatic JinRyuu/JRMCore/JRMCoreH.targ : Lnet/minecraft/entity/Entity;
/*      */     //   5568: invokevirtual func_70005_c_ : ()Ljava/lang/String;
/*      */     //   5571: invokestatic jrmcPDtaDNS : (Ljava/lang/String;)Ljava/lang/String;
/*      */     //   5574: astore #20
/*      */     //   5576: aload #20
/*      */     //   5578: invokestatic dnsGender : (Ljava/lang/String;)I
/*      */     //   5581: istore #15
/*      */     //   5583: getstatic JinRyuu/JRMCore/JRMCoreH.p : [Ljava/lang/String;
/*      */     //   5586: ifnull -> 5741
/*      */     //   5589: getstatic JinRyuu/JRMCore/JRMCoreH.p : [Ljava/lang/String;
/*      */     //   5592: arraylength
/*      */     //   5593: ifle -> 5741
/*      */     //   5596: getstatic JinRyuu/JRMCore/JRMCoreH.p : [Ljava/lang/String;
/*      */     //   5599: astore #21
/*      */     //   5601: aload #21
/*      */     //   5603: arraylength
/*      */     //   5604: istore #22
/*      */     //   5606: iconst_0
/*      */     //   5607: istore #23
/*      */     //   5609: iload #23
/*      */     //   5611: iload #22
/*      */     //   5613: if_icmpge -> 5741
/*      */     //   5616: aload #21
/*      */     //   5618: iload #23
/*      */     //   5620: aaload
/*      */     //   5621: astore #24
/*      */     //   5623: aload #24
/*      */     //   5625: ldc_w ';'
/*      */     //   5628: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
/*      */     //   5631: astore #25
/*      */     //   5633: getstatic JinRyuu/JRMCore/JRMCoreH.targ : Lnet/minecraft/entity/Entity;
/*      */     //   5636: ifnonnull -> 5686
/*      */     //   5639: aload_0
/*      */     //   5640: getfield field_146297_k : Lnet/minecraft/client/Minecraft;
/*      */     //   5643: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*      */     //   5646: invokevirtual func_70005_c_ : ()Ljava/lang/String;
/*      */     //   5649: aload #25
/*      */     //   5651: iconst_0
/*      */     //   5652: aaload
/*      */     //   5653: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   5656: ifeq -> 5686
/*      */     //   5659: aload #25
/*      */     //   5661: iconst_2
/*      */     //   5662: aaload
/*      */     //   5663: invokestatic parseInt : (Ljava/lang/String;)I
/*      */     //   5666: istore #16
/*      */     //   5668: aload #25
/*      */     //   5670: iconst_3
/*      */     //   5671: aaload
/*      */     //   5672: astore #17
/*      */     //   5674: aload #25
/*      */     //   5676: iconst_4
/*      */     //   5677: aaload
/*      */     //   5678: astore #18
/*      */     //   5680: aload #25
/*      */     //   5682: iconst_5
/*      */     //   5683: aaload
/*      */     //   5684: astore #19
/*      */     //   5686: getstatic JinRyuu/JRMCore/JRMCoreH.targ : Lnet/minecraft/entity/Entity;
/*      */     //   5689: ifnull -> 5735
/*      */     //   5692: getstatic JinRyuu/JRMCore/JRMCoreH.targ : Lnet/minecraft/entity/Entity;
/*      */     //   5695: invokevirtual func_70005_c_ : ()Ljava/lang/String;
/*      */     //   5698: aload #25
/*      */     //   5700: iconst_0
/*      */     //   5701: aaload
/*      */     //   5702: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   5705: ifeq -> 5735
/*      */     //   5708: aload #25
/*      */     //   5710: iconst_2
/*      */     //   5711: aaload
/*      */     //   5712: invokestatic parseInt : (Ljava/lang/String;)I
/*      */     //   5715: istore #16
/*      */     //   5717: aload #25
/*      */     //   5719: iconst_3
/*      */     //   5720: aaload
/*      */     //   5721: astore #17
/*      */     //   5723: aload #25
/*      */     //   5725: iconst_4
/*      */     //   5726: aaload
/*      */     //   5727: astore #18
/*      */     //   5729: aload #25
/*      */     //   5731: iconst_5
/*      */     //   5732: aaload
/*      */     //   5733: astore #19
/*      */     //   5735: iinc #23, 1
/*      */     //   5738: goto -> 5609
/*      */     //   5741: getstatic JinRyuu/FamilyC/FamilyCCharGui.children : Ljava/lang/String;
/*      */     //   5744: ldc_w ';'
/*      */     //   5747: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
/*      */     //   5750: astore #21
/*      */     //   5752: aload #21
/*      */     //   5754: astore #22
/*      */     //   5756: aload #22
/*      */     //   5758: arraylength
/*      */     //   5759: istore #23
/*      */     //   5761: iconst_0
/*      */     //   5762: istore #24
/*      */     //   5764: iload #24
/*      */     //   5766: iload #23
/*      */     //   5768: if_icmpge -> 5900
/*      */     //   5771: aload #22
/*      */     //   5773: iload #24
/*      */     //   5775: aaload
/*      */     //   5776: astore #25
/*      */     //   5778: aload #25
/*      */     //   5780: ldc ':'
/*      */     //   5782: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
/*      */     //   5785: astore #26
/*      */     //   5787: aload #26
/*      */     //   5789: arraylength
/*      */     //   5790: iconst_2
/*      */     //   5791: if_icmple -> 5894
/*      */     //   5794: new java/lang/StringBuilder
/*      */     //   5797: dup
/*      */     //   5798: invokespecial <init> : ()V
/*      */     //   5801: aload #18
/*      */     //   5803: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   5806: ldc_w ', '
/*      */     //   5809: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   5812: aload #26
/*      */     //   5814: iconst_2
/*      */     //   5815: aaload
/*      */     //   5816: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   5819: aload #26
/*      */     //   5821: arraylength
/*      */     //   5822: iconst_3
/*      */     //   5823: if_icmple -> 5884
/*      */     //   5826: new java/lang/StringBuilder
/*      */     //   5829: dup
/*      */     //   5830: invokespecial <init> : ()V
/*      */     //   5833: ldc_w ' '
/*      */     //   5836: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   5839: getstatic JinRyuu/JRMCore/JRMCoreH.clgy : Ljava/lang/String;
/*      */     //   5842: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   5845: ldc_w '('
/*      */     //   5848: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   5851: aload #26
/*      */     //   5853: iconst_3
/*      */     //   5854: aaload
/*      */     //   5855: ldc ','
/*      */     //   5857: ldc_w ', '
/*      */     //   5860: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
/*      */     //   5863: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   5866: ldc_w ')'
/*      */     //   5869: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   5872: getstatic JinRyuu/JRMCore/JRMCoreH.clb : Ljava/lang/String;
/*      */     //   5875: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   5878: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   5881: goto -> 5886
/*      */     //   5884: ldc ''
/*      */     //   5886: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   5889: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   5892: astore #18
/*      */     //   5894: iinc #24, 1
/*      */     //   5897: goto -> 5764
/*      */     //   5900: aload #18
/*      */     //   5902: invokevirtual length : ()I
/*      */     //   5905: iconst_2
/*      */     //   5906: if_icmple -> 5917
/*      */     //   5909: aload #18
/*      */     //   5911: iconst_2
/*      */     //   5912: invokevirtual substring : (I)Ljava/lang/String;
/*      */     //   5915: astore #18
/*      */     //   5917: getstatic JinRyuu/JRMCore/JRMCoreH.targ : Lnet/minecraft/entity/Entity;
/*      */     //   5920: ifnull -> 5927
/*      */     //   5923: iconst_1
/*      */     //   5924: goto -> 5928
/*      */     //   5927: iconst_0
/*      */     //   5928: istore #22
/*      */     //   5930: iload #22
/*      */     //   5932: ifeq -> 5944
/*      */     //   5935: getstatic JinRyuu/JRMCore/JRMCoreH.targ : Lnet/minecraft/entity/Entity;
/*      */     //   5938: invokevirtual func_70005_c_ : ()Ljava/lang/String;
/*      */     //   5941: goto -> 5954
/*      */     //   5944: aload_0
/*      */     //   5945: getfield field_146297_k : Lnet/minecraft/client/Minecraft;
/*      */     //   5948: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*      */     //   5951: invokevirtual func_70005_c_ : ()Ljava/lang/String;
/*      */     //   5954: astore #23
/*      */     //   5956: aload #7
/*      */     //   5958: new java/lang/StringBuilder
/*      */     //   5961: dup
/*      */     //   5962: invokespecial <init> : ()V
/*      */     //   5965: ldc_w 'Name: §8'
/*      */     //   5968: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   5971: aload #23
/*      */     //   5973: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   5976: ldc_w ' §0Gender: §8'
/*      */     //   5979: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   5982: iload #15
/*      */     //   5984: ifne -> 5993
/*      */     //   5987: ldc_w 'Male'
/*      */     //   5990: goto -> 5996
/*      */     //   5993: ldc_w 'Female'
/*      */     //   5996: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   5999: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   6002: iload #12
/*      */     //   6004: iconst_5
/*      */     //   6005: iadd
/*      */     //   6006: iload #13
/*      */     //   6008: iconst_5
/*      */     //   6009: iadd
/*      */     //   6010: iconst_0
/*      */     //   6011: invokevirtual func_78276_b : (Ljava/lang/String;III)I
/*      */     //   6014: pop
/*      */     //   6015: iconst_0
/*      */     //   6016: istore #24
/*      */     //   6018: invokestatic JYC : ()Z
/*      */     //   6021: ifeq -> 6233
/*      */     //   6024: fconst_0
/*      */     //   6025: fstore #25
/*      */     //   6027: getstatic JinRyuu/JRMCore/JYearsCH.p : [Ljava/lang/String;
/*      */     //   6030: ifnull -> 6104
/*      */     //   6033: getstatic JinRyuu/JRMCore/JYearsCH.p : [Ljava/lang/String;
/*      */     //   6036: arraylength
/*      */     //   6037: ifle -> 6104
/*      */     //   6040: getstatic JinRyuu/JRMCore/JYearsCH.p : [Ljava/lang/String;
/*      */     //   6043: astore #26
/*      */     //   6045: aload #26
/*      */     //   6047: arraylength
/*      */     //   6048: istore #27
/*      */     //   6050: iconst_0
/*      */     //   6051: istore #28
/*      */     //   6053: iload #28
/*      */     //   6055: iload #27
/*      */     //   6057: if_icmpge -> 6104
/*      */     //   6060: aload #26
/*      */     //   6062: iload #28
/*      */     //   6064: aaload
/*      */     //   6065: astore #29
/*      */     //   6067: aload #29
/*      */     //   6069: ldc_w ';'
/*      */     //   6072: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
/*      */     //   6075: astore #30
/*      */     //   6077: aload #23
/*      */     //   6079: aload #30
/*      */     //   6081: iconst_0
/*      */     //   6082: aaload
/*      */     //   6083: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   6086: ifeq -> 6098
/*      */     //   6089: aload #30
/*      */     //   6091: iconst_1
/*      */     //   6092: aaload
/*      */     //   6093: invokestatic parseFloat : (Ljava/lang/String;)F
/*      */     //   6096: fstore #25
/*      */     //   6098: iinc #28, 1
/*      */     //   6101: goto -> 6053
/*      */     //   6104: aload #7
/*      */     //   6106: new java/lang/StringBuilder
/*      */     //   6109: dup
/*      */     //   6110: invokespecial <init> : ()V
/*      */     //   6113: ldc_w 'Time Lived: §8'
/*      */     //   6116: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   6119: fload #25
/*      */     //   6121: ldc_w 46.0
/*      */     //   6124: fcmpg
/*      */     //   6125: ifgt -> 6133
/*      */     //   6128: fload #25
/*      */     //   6130: goto -> 6148
/*      */     //   6133: fload #25
/*      */     //   6135: fload #25
/*      */     //   6137: ldc_w 46.0
/*      */     //   6140: fdiv
/*      */     //   6141: f2i
/*      */     //   6142: i2f
/*      */     //   6143: ldc_w 46.0
/*      */     //   6146: fmul
/*      */     //   6147: fsub
/*      */     //   6148: f2i
/*      */     //   6149: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*      */     //   6152: ldc_w ' Days '
/*      */     //   6155: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   6158: fload #25
/*      */     //   6160: ldc_w 46.0
/*      */     //   6163: fcmpl
/*      */     //   6164: ifle -> 6202
/*      */     //   6167: new java/lang/StringBuilder
/*      */     //   6170: dup
/*      */     //   6171: invokespecial <init> : ()V
/*      */     //   6174: ldc_w 'and '
/*      */     //   6177: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   6180: fload #25
/*      */     //   6182: ldc_w 46.0
/*      */     //   6185: fdiv
/*      */     //   6186: f2i
/*      */     //   6187: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*      */     //   6190: ldc_w ' Minecraft Years'
/*      */     //   6193: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   6196: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   6199: goto -> 6204
/*      */     //   6202: ldc ''
/*      */     //   6204: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   6207: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   6210: iload #12
/*      */     //   6212: iconst_5
/*      */     //   6213: iadd
/*      */     //   6214: iload #13
/*      */     //   6216: bipush #15
/*      */     //   6218: iadd
/*      */     //   6219: iload #24
/*      */     //   6221: bipush #10
/*      */     //   6223: imul
/*      */     //   6224: iadd
/*      */     //   6225: iconst_0
/*      */     //   6226: invokevirtual func_78276_b : (Ljava/lang/String;III)I
/*      */     //   6229: pop
/*      */     //   6230: iinc #24, 1
/*      */     //   6233: iload #22
/*      */     //   6235: ifne -> 6300
/*      */     //   6238: aload #18
/*      */     //   6240: invokevirtual length : ()I
/*      */     //   6243: iconst_3
/*      */     //   6244: if_icmple -> 6300
/*      */     //   6247: new java/lang/StringBuilder
/*      */     //   6250: dup
/*      */     //   6251: invokespecial <init> : ()V
/*      */     //   6254: ldc_w 'Children: §8'
/*      */     //   6257: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   6260: aload #18
/*      */     //   6262: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   6265: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   6268: astore #25
/*      */     //   6270: iconst_1
/*      */     //   6271: anewarray java/lang/String
/*      */     //   6274: astore #26
/*      */     //   6276: aload #26
/*      */     //   6278: iconst_0
/*      */     //   6279: aload #25
/*      */     //   6281: aastore
/*      */     //   6282: iinc #24, 1
/*      */     //   6285: aload #26
/*      */     //   6287: iload #24
/*      */     //   6289: aload #7
/*      */     //   6291: iload #12
/*      */     //   6293: iload #13
/*      */     //   6295: invokestatic lbs : ([Ljava/lang/String;ILnet/minecraft/client/gui/FontRenderer;II)I
/*      */     //   6298: istore #24
/*      */     //   6300: aload_0
/*      */     //   6301: getfield jfc : I
/*      */     //   6304: iconst_2
/*      */     //   6305: if_icmpne -> 8947
/*      */     //   6308: sipush #256
/*      */     //   6311: istore #10
/*      */     //   6313: sipush #159
/*      */     //   6316: istore #11
/*      */     //   6318: aload_0
/*      */     //   6319: getfield field_146294_l : I
/*      */     //   6322: iload #10
/*      */     //   6324: isub
/*      */     //   6325: iconst_2
/*      */     //   6326: idiv
/*      */     //   6327: istore #12
/*      */     //   6329: aload_0
/*      */     //   6330: getfield field_146295_m : I
/*      */     //   6333: iload #11
/*      */     //   6335: isub
/*      */     //   6336: iconst_2
/*      */     //   6337: idiv
/*      */     //   6338: istore #13
/*      */     //   6340: fconst_1
/*      */     //   6341: fconst_1
/*      */     //   6342: fconst_1
/*      */     //   6343: fconst_1
/*      */     //   6344: invokestatic glColor4f : (FFFF)V
/*      */     //   6347: new net/minecraft/util/ResourceLocation
/*      */     //   6350: dup
/*      */     //   6351: aload #8
/*      */     //   6353: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   6356: astore #14
/*      */     //   6358: aload_0
/*      */     //   6359: getfield field_146297_k : Lnet/minecraft/client/Minecraft;
/*      */     //   6362: getfield field_71446_o : Lnet/minecraft/client/renderer/texture/TextureManager;
/*      */     //   6365: aload #14
/*      */     //   6367: invokevirtual func_110577_a : (Lnet/minecraft/util/ResourceLocation;)V
/*      */     //   6370: aload_0
/*      */     //   6371: iload #12
/*      */     //   6373: iload #13
/*      */     //   6375: iconst_0
/*      */     //   6376: iconst_0
/*      */     //   6377: iload #10
/*      */     //   6379: iload #11
/*      */     //   6381: invokevirtual func_73729_b : (IIIIII)V
/*      */     //   6384: aload_0
/*      */     //   6385: getfield field_146292_n : Ljava/util/List;
/*      */     //   6388: new JinRyuu/JRMCore/JRMCoreGuiButtons00
/*      */     //   6391: dup
/*      */     //   6392: bipush #10
/*      */     //   6394: iload #12
/*      */     //   6396: iload #10
/*      */     //   6398: iconst_2
/*      */     //   6399: idiv
/*      */     //   6400: iadd
/*      */     //   6401: sipush #150
/*      */     //   6404: isub
/*      */     //   6405: iload #13
/*      */     //   6407: iload #11
/*      */     //   6409: iconst_2
/*      */     //   6410: idiv
/*      */     //   6411: iadd
/*      */     //   6412: bipush #65
/*      */     //   6414: iadd
/*      */     //   6415: bipush #20
/*      */     //   6417: bipush #20
/*      */     //   6419: ldc_w 'X'
/*      */     //   6422: iconst_0
/*      */     //   6423: invokespecial <init> : (IIIIILjava/lang/String;I)V
/*      */     //   6426: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   6431: pop
/*      */     //   6432: getstatic JinRyuu/FamilyC/FamilyCCharGui.dtcdad : Ljava/lang/String;
/*      */     //   6435: invokevirtual length : ()I
/*      */     //   6438: iconst_2
/*      */     //   6439: if_icmple -> 6463
/*      */     //   6442: aload_0
/*      */     //   6443: pop
/*      */     //   6444: getstatic JinRyuu/FamilyC/FamilyCCharGui.dtcdad : Ljava/lang/String;
/*      */     //   6447: aload_0
/*      */     //   6448: getfield field_146297_k : Lnet/minecraft/client/Minecraft;
/*      */     //   6451: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*      */     //   6454: invokevirtual func_70005_c_ : ()Ljava/lang/String;
/*      */     //   6457: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
/*      */     //   6460: ifne -> 6494
/*      */     //   6463: getstatic JinRyuu/FamilyC/FamilyCCharGui.dtcmom : Ljava/lang/String;
/*      */     //   6466: invokevirtual length : ()I
/*      */     //   6469: iconst_2
/*      */     //   6470: if_icmple -> 6498
/*      */     //   6473: aload_0
/*      */     //   6474: pop
/*      */     //   6475: getstatic JinRyuu/FamilyC/FamilyCCharGui.dtcmom : Ljava/lang/String;
/*      */     //   6478: aload_0
/*      */     //   6479: getfield field_146297_k : Lnet/minecraft/client/Minecraft;
/*      */     //   6482: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*      */     //   6485: invokevirtual func_70005_c_ : ()Ljava/lang/String;
/*      */     //   6488: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
/*      */     //   6491: ifeq -> 6498
/*      */     //   6494: iconst_1
/*      */     //   6495: goto -> 6499
/*      */     //   6498: iconst_0
/*      */     //   6499: istore #15
/*      */     //   6501: getstatic JinRyuu/JRMCore/JRMCoreH.targNPC : Lnet/minecraft/entity/Entity;
/*      */     //   6504: ifnonnull -> 6524
/*      */     //   6507: aload_0
/*      */     //   6508: getfield field_146297_k : Lnet/minecraft/client/Minecraft;
/*      */     //   6511: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*      */     //   6514: invokevirtual func_71053_j : ()V
/*      */     //   6517: iconst_0
/*      */     //   6518: putstatic JinRyuu/FamilyC/FamilyCCharGui.inv : I
/*      */     //   6521: goto -> 8899
/*      */     //   6524: iload #15
/*      */     //   6526: ifne -> 6545
/*      */     //   6529: aload_0
/*      */     //   6530: getfield field_146297_k : Lnet/minecraft/client/Minecraft;
/*      */     //   6533: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*      */     //   6536: getfield field_71075_bZ : Lnet/minecraft/entity/player/PlayerCapabilities;
/*      */     //   6539: getfield field_75098_d : Z
/*      */     //   6542: ifeq -> 8899
/*      */     //   6545: getstatic JinRyuu/FamilyC/FamilyCCharGui.inv : I
/*      */     //   6548: iconst_m1
/*      */     //   6549: if_icmpne -> 6866
/*      */     //   6552: getstatic JinRyuu/JRMCore/JRMCoreH.targNPC : Lnet/minecraft/entity/Entity;
/*      */     //   6555: instanceof JinRyuu/FamilyC/EntityNPC
/*      */     //   6558: ifeq -> 6866
/*      */     //   6561: ldc_w 'Child name: '
/*      */     //   6564: astore #16
/*      */     //   6566: aload_0
/*      */     //   6567: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   6570: aload #16
/*      */     //   6572: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   6575: istore #17
/*      */     //   6577: aload #7
/*      */     //   6579: aload #16
/*      */     //   6581: iload #12
/*      */     //   6583: iload #10
/*      */     //   6585: iconst_2
/*      */     //   6586: idiv
/*      */     //   6587: iadd
/*      */     //   6588: bipush #122
/*      */     //   6590: isub
/*      */     //   6591: iload #13
/*      */     //   6593: iload #11
/*      */     //   6595: iconst_1
/*      */     //   6596: iadd
/*      */     //   6597: iconst_2
/*      */     //   6598: idiv
/*      */     //   6599: iadd
/*      */     //   6600: bipush #74
/*      */     //   6602: isub
/*      */     //   6603: bipush #70
/*      */     //   6605: iadd
/*      */     //   6606: iconst_0
/*      */     //   6607: invokevirtual func_78276_b : (Ljava/lang/String;III)I
/*      */     //   6610: pop
/*      */     //   6611: getstatic JinRyuu/JRMCore/JRMCoreH.targNPC : Lnet/minecraft/entity/Entity;
/*      */     //   6614: instanceof JinRyuu/FamilyC/EntityNPC
/*      */     //   6617: ifeq -> 6632
/*      */     //   6620: getstatic JinRyuu/JRMCore/JRMCoreH.targNPC : Lnet/minecraft/entity/Entity;
/*      */     //   6623: checkcast JinRyuu/FamilyC/EntityNPC
/*      */     //   6626: invokevirtual getNam : ()Ljava/lang/String;
/*      */     //   6629: goto -> 6634
/*      */     //   6632: ldc ''
/*      */     //   6634: astore #18
/*      */     //   6636: aload_0
/*      */     //   6637: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   6640: aload #18
/*      */     //   6642: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   6645: istore #19
/*      */     //   6647: aload_0
/*      */     //   6648: aload #18
/*      */     //   6650: putfield defaultInputFieldText : Ljava/lang/String;
/*      */     //   6653: ldc_w 'Name the child'
/*      */     //   6656: astore #20
/*      */     //   6658: aload_0
/*      */     //   6659: getfield field_146292_n : Ljava/util/List;
/*      */     //   6662: new JinRyuu/JRMCore/JRMCoreGuiButtons00
/*      */     //   6665: dup
/*      */     //   6666: bipush #6
/*      */     //   6668: iload #12
/*      */     //   6670: iload #10
/*      */     //   6672: iconst_2
/*      */     //   6673: idiv
/*      */     //   6674: iadd
/*      */     //   6675: bipush #10
/*      */     //   6677: iadd
/*      */     //   6678: bipush #80
/*      */     //   6680: isub
/*      */     //   6681: iload #13
/*      */     //   6683: iload #11
/*      */     //   6685: iconst_1
/*      */     //   6686: iadd
/*      */     //   6687: iconst_2
/*      */     //   6688: idiv
/*      */     //   6689: iadd
/*      */     //   6690: bipush #50
/*      */     //   6692: isub
/*      */     //   6693: bipush #65
/*      */     //   6695: iadd
/*      */     //   6696: aload_0
/*      */     //   6697: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   6700: aload #20
/*      */     //   6702: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   6705: bipush #8
/*      */     //   6707: iadd
/*      */     //   6708: bipush #20
/*      */     //   6710: aload #20
/*      */     //   6712: iconst_0
/*      */     //   6713: invokespecial <init> : (IIIIILjava/lang/String;I)V
/*      */     //   6716: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   6721: pop
/*      */     //   6722: aload_0
/*      */     //   6723: getfield defaultInputFieldText : Ljava/lang/String;
/*      */     //   6726: invokevirtual length : ()I
/*      */     //   6729: iconst_2
/*      */     //   6730: if_icmple -> 6860
/*      */     //   6733: aload_0
/*      */     //   6734: getfield inputField : Lnet/minecraft/client/gui/GuiTextField;
/*      */     //   6737: ifnonnull -> 6763
/*      */     //   6740: aload_0
/*      */     //   6741: aload #7
/*      */     //   6743: iload #12
/*      */     //   6745: iconst_5
/*      */     //   6746: iadd
/*      */     //   6747: iload #17
/*      */     //   6749: iadd
/*      */     //   6750: iload #13
/*      */     //   6752: bipush #75
/*      */     //   6754: iadd
/*      */     //   6755: iconst_1
/*      */     //   6756: iadd
/*      */     //   6757: invokespecial name : (Lnet/minecraft/client/gui/FontRenderer;II)V
/*      */     //   6760: goto -> 6836
/*      */     //   6763: ldc_w 'Random Name'
/*      */     //   6766: astore #21
/*      */     //   6768: aload_0
/*      */     //   6769: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   6772: aload #21
/*      */     //   6774: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   6777: bipush #8
/*      */     //   6779: iadd
/*      */     //   6780: istore #22
/*      */     //   6782: aload_0
/*      */     //   6783: getfield field_146292_n : Ljava/util/List;
/*      */     //   6786: new JinRyuu/JRMCore/JRMCoreGuiButtons00
/*      */     //   6789: dup
/*      */     //   6790: bipush #97
/*      */     //   6792: iload #12
/*      */     //   6794: iload #10
/*      */     //   6796: iconst_2
/*      */     //   6797: idiv
/*      */     //   6798: iadd
/*      */     //   6799: bipush #10
/*      */     //   6801: iadd
/*      */     //   6802: bipush #30
/*      */     //   6804: iadd
/*      */     //   6805: iload #13
/*      */     //   6807: iload #11
/*      */     //   6809: iconst_1
/*      */     //   6810: iadd
/*      */     //   6811: iconst_2
/*      */     //   6812: idiv
/*      */     //   6813: iadd
/*      */     //   6814: bipush #50
/*      */     //   6816: isub
/*      */     //   6817: bipush #45
/*      */     //   6819: iadd
/*      */     //   6820: iload #22
/*      */     //   6822: bipush #20
/*      */     //   6824: aload #21
/*      */     //   6826: iconst_0
/*      */     //   6827: invokespecial <init> : (IIIIILjava/lang/String;I)V
/*      */     //   6830: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   6835: pop
/*      */     //   6836: aload_0
/*      */     //   6837: getfield inputField : Lnet/minecraft/client/gui/GuiTextField;
/*      */     //   6840: ifnull -> 6860
/*      */     //   6843: aload_0
/*      */     //   6844: getfield inputField : Lnet/minecraft/client/gui/GuiTextField;
/*      */     //   6847: invokevirtual func_146194_f : ()V
/*      */     //   6850: aload_0
/*      */     //   6851: getfield inputField : Lnet/minecraft/client/gui/GuiTextField;
/*      */     //   6854: invokevirtual func_146179_b : ()Ljava/lang/String;
/*      */     //   6857: putstatic JinRyuu/FamilyC/FamilyCCharGui.chiNam : Ljava/lang/String;
/*      */     //   6860: iconst_0
/*      */     //   6861: istore #9
/*      */     //   6863: goto -> 8899
/*      */     //   6866: getstatic JinRyuu/FamilyC/FamilyCCharGui.inv : I
/*      */     //   6869: ifne -> 8481
/*      */     //   6872: getstatic JinRyuu/JRMCore/JRMCoreH.targNPC : Lnet/minecraft/entity/Entity;
/*      */     //   6875: instanceof JinRyuu/FamilyC/EntityNPC
/*      */     //   6878: ifeq -> 8481
/*      */     //   6881: iconst_0
/*      */     //   6882: istore #16
/*      */     //   6884: getstatic JinRyuu/JRMCore/JRMCoreH.targNPC : Lnet/minecraft/entity/Entity;
/*      */     //   6887: checkcast JinRyuu/FamilyC/EntityNPC
/*      */     //   6890: astore #17
/*      */     //   6892: getstatic JinRyuu/JRMCore/JRMCoreH.targNPC : Lnet/minecraft/entity/Entity;
/*      */     //   6895: instanceof JinRyuu/FamilyC/EntityNPC
/*      */     //   6898: ifeq -> 6913
/*      */     //   6901: getstatic JinRyuu/JRMCore/JRMCoreH.targNPC : Lnet/minecraft/entity/Entity;
/*      */     //   6904: checkcast JinRyuu/FamilyC/EntityNPC
/*      */     //   6907: invokevirtual getNam : ()Ljava/lang/String;
/*      */     //   6910: goto -> 6916
/*      */     //   6913: ldc_w 'Child'
/*      */     //   6916: astore #18
/*      */     //   6918: aload_0
/*      */     //   6919: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   6922: aload #18
/*      */     //   6924: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   6927: istore #19
/*      */     //   6929: aload #7
/*      */     //   6931: aload #18
/*      */     //   6933: iload #12
/*      */     //   6935: iload #10
/*      */     //   6937: iconst_2
/*      */     //   6938: idiv
/*      */     //   6939: iadd
/*      */     //   6940: bipush #125
/*      */     //   6942: isub
/*      */     //   6943: bipush #20
/*      */     //   6945: iadd
/*      */     //   6946: bipush #15
/*      */     //   6948: isub
/*      */     //   6949: iload #13
/*      */     //   6951: iload #11
/*      */     //   6953: iconst_1
/*      */     //   6954: iadd
/*      */     //   6955: iconst_2
/*      */     //   6956: idiv
/*      */     //   6957: iadd
/*      */     //   6958: bipush #70
/*      */     //   6960: isub
/*      */     //   6961: iload #16
/*      */     //   6963: bipush #15
/*      */     //   6965: imul
/*      */     //   6966: iadd
/*      */     //   6967: iconst_4
/*      */     //   6968: iadd
/*      */     //   6969: iconst_5
/*      */     //   6970: isub
/*      */     //   6971: iconst_0
/*      */     //   6972: invokevirtual func_78276_b : (Ljava/lang/String;III)I
/*      */     //   6975: pop
/*      */     //   6976: new java/lang/StringBuilder
/*      */     //   6979: dup
/*      */     //   6980: invokespecial <init> : ()V
/*      */     //   6983: ldc_w 'Hi '
/*      */     //   6986: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   6989: getstatic JinRyuu/FamilyC/FamilyCCharGui.dtcmom : Ljava/lang/String;
/*      */     //   6992: getstatic JinRyuu/FamilyC/FamilyCCharGui.dtcdad : Ljava/lang/String;
/*      */     //   6995: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
/*      */     //   6998: ifeq -> 7022
/*      */     //   7001: getstatic JinRyuu/JRMCore/JRMCoreH.dns : Ljava/lang/String;
/*      */     //   7004: invokestatic dnsGender : (Ljava/lang/String;)I
/*      */     //   7007: ifne -> 7016
/*      */     //   7010: ldc_w 'dad'
/*      */     //   7013: goto -> 7099
/*      */     //   7016: ldc_w 'mom'
/*      */     //   7019: goto -> 7099
/*      */     //   7022: getstatic JinRyuu/FamilyC/FamilyCCharGui.dtcmom : Ljava/lang/String;
/*      */     //   7025: invokevirtual length : ()I
/*      */     //   7028: iconst_2
/*      */     //   7029: if_icmple -> 7059
/*      */     //   7032: aload_0
/*      */     //   7033: pop
/*      */     //   7034: getstatic JinRyuu/FamilyC/FamilyCCharGui.dtcmom : Ljava/lang/String;
/*      */     //   7037: aload_0
/*      */     //   7038: getfield field_146297_k : Lnet/minecraft/client/Minecraft;
/*      */     //   7041: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*      */     //   7044: invokevirtual func_70005_c_ : ()Ljava/lang/String;
/*      */     //   7047: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
/*      */     //   7050: ifeq -> 7059
/*      */     //   7053: ldc_w 'mom'
/*      */     //   7056: goto -> 7099
/*      */     //   7059: getstatic JinRyuu/FamilyC/FamilyCCharGui.dtcdad : Ljava/lang/String;
/*      */     //   7062: invokevirtual length : ()I
/*      */     //   7065: iconst_2
/*      */     //   7066: if_icmple -> 7096
/*      */     //   7069: aload_0
/*      */     //   7070: pop
/*      */     //   7071: getstatic JinRyuu/FamilyC/FamilyCCharGui.dtcdad : Ljava/lang/String;
/*      */     //   7074: aload_0
/*      */     //   7075: getfield field_146297_k : Lnet/minecraft/client/Minecraft;
/*      */     //   7078: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*      */     //   7081: invokevirtual func_70005_c_ : ()Ljava/lang/String;
/*      */     //   7084: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
/*      */     //   7087: ifeq -> 7096
/*      */     //   7090: ldc_w 'dad'
/*      */     //   7093: goto -> 7099
/*      */     //   7096: ldc_w 'whoever you are'
/*      */     //   7099: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   7102: ldc_w ' what can I do for you.'
/*      */     //   7105: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   7108: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   7111: astore #18
/*      */     //   7113: aload_0
/*      */     //   7114: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   7117: aload #18
/*      */     //   7119: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   7122: istore #19
/*      */     //   7124: aload #7
/*      */     //   7126: aload #18
/*      */     //   7128: iload #12
/*      */     //   7130: iload #10
/*      */     //   7132: iconst_2
/*      */     //   7133: idiv
/*      */     //   7134: iadd
/*      */     //   7135: bipush #125
/*      */     //   7137: isub
/*      */     //   7138: bipush #20
/*      */     //   7140: iadd
/*      */     //   7141: bipush #15
/*      */     //   7143: isub
/*      */     //   7144: iload #13
/*      */     //   7146: iload #11
/*      */     //   7148: iconst_1
/*      */     //   7149: iadd
/*      */     //   7150: iconst_2
/*      */     //   7151: idiv
/*      */     //   7152: iadd
/*      */     //   7153: bipush #70
/*      */     //   7155: isub
/*      */     //   7156: iload #16
/*      */     //   7158: bipush #15
/*      */     //   7160: imul
/*      */     //   7161: iadd
/*      */     //   7162: iconst_4
/*      */     //   7163: iadd
/*      */     //   7164: iconst_5
/*      */     //   7165: isub
/*      */     //   7166: bipush #10
/*      */     //   7168: iadd
/*      */     //   7169: iconst_0
/*      */     //   7170: invokevirtual func_78276_b : (Ljava/lang/String;III)I
/*      */     //   7173: pop
/*      */     //   7174: iload #16
/*      */     //   7176: iconst_1
/*      */     //   7177: iadd
/*      */     //   7178: istore #16
/*      */     //   7180: getstatic JinRyuu/FamilyC/FamilyCCharGui.flwTrgtNm : Ljava/lang/String;
/*      */     //   7183: invokevirtual length : ()I
/*      */     //   7186: iconst_2
/*      */     //   7187: if_icmple -> 7196
/*      */     //   7190: getstatic JinRyuu/FamilyC/FamilyCCharGui.flwTrgtNm : Ljava/lang/String;
/*      */     //   7193: goto -> 7199
/*      */     //   7196: ldc_w 'a target'
/*      */     //   7199: astore #20
/*      */     //   7201: getstatic JinRyuu/FamilyC/FamilyCCharGui.dtcf : Ljava/lang/String;
/*      */     //   7204: ldc '0'
/*      */     //   7206: invokevirtual contains : (Ljava/lang/CharSequence;)Z
/*      */     //   7209: ifeq -> 7218
/*      */     //   7212: ldc_w 'Don't follow'
/*      */     //   7215: goto -> 7275
/*      */     //   7218: getstatic JinRyuu/FamilyC/FamilyCCharGui.dtcf : Ljava/lang/String;
/*      */     //   7221: ldc_w '1'
/*      */     //   7224: invokevirtual contains : (Ljava/lang/CharSequence;)Z
/*      */     //   7227: ifeq -> 7236
/*      */     //   7230: ldc_w 'Follow Dad'
/*      */     //   7233: goto -> 7275
/*      */     //   7236: getstatic JinRyuu/FamilyC/FamilyCCharGui.dtcf : Ljava/lang/String;
/*      */     //   7239: ldc_w '2'
/*      */     //   7242: invokevirtual contains : (Ljava/lang/CharSequence;)Z
/*      */     //   7245: ifeq -> 7254
/*      */     //   7248: ldc_w 'Follow Mom'
/*      */     //   7251: goto -> 7275
/*      */     //   7254: new java/lang/StringBuilder
/*      */     //   7257: dup
/*      */     //   7258: invokespecial <init> : ()V
/*      */     //   7261: ldc_w 'Follow '
/*      */     //   7264: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   7267: aload #20
/*      */     //   7269: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   7272: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   7275: astore #18
/*      */     //   7277: aload_0
/*      */     //   7278: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   7281: aload #18
/*      */     //   7283: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   7286: istore #21
/*      */     //   7288: iconst_1
/*      */     //   7289: istore #22
/*      */     //   7291: iload #22
/*      */     //   7293: ifeq -> 7545
/*      */     //   7296: aload_0
/*      */     //   7297: getfield field_146292_n : Ljava/util/List;
/*      */     //   7300: new JinRyuu/JRMCore/JRMCoreGuiButtonsA2
/*      */     //   7303: dup
/*      */     //   7304: bipush #-2
/*      */     //   7306: iload #12
/*      */     //   7308: iload #10
/*      */     //   7310: iconst_2
/*      */     //   7311: idiv
/*      */     //   7312: iadd
/*      */     //   7313: bipush #125
/*      */     //   7315: isub
/*      */     //   7316: iload #13
/*      */     //   7318: iload #11
/*      */     //   7320: iconst_1
/*      */     //   7321: iadd
/*      */     //   7322: iconst_2
/*      */     //   7323: idiv
/*      */     //   7324: iadd
/*      */     //   7325: bipush #65
/*      */     //   7327: isub
/*      */     //   7328: iload #16
/*      */     //   7330: bipush #15
/*      */     //   7332: imul
/*      */     //   7333: iadd
/*      */     //   7334: ldc_w '<'
/*      */     //   7337: invokespecial <init> : (IIILjava/lang/String;)V
/*      */     //   7340: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   7345: pop
/*      */     //   7346: aload_0
/*      */     //   7347: getfield field_146292_n : Ljava/util/List;
/*      */     //   7350: new JinRyuu/JRMCore/JRMCoreGuiButtonsA2
/*      */     //   7353: dup
/*      */     //   7354: iconst_2
/*      */     //   7355: iload #12
/*      */     //   7357: iload #10
/*      */     //   7359: iconst_2
/*      */     //   7360: idiv
/*      */     //   7361: iadd
/*      */     //   7362: bipush #125
/*      */     //   7364: isub
/*      */     //   7365: bipush #20
/*      */     //   7367: iadd
/*      */     //   7368: iload #21
/*      */     //   7370: iadd
/*      */     //   7371: iconst_4
/*      */     //   7372: iadd
/*      */     //   7373: iload #13
/*      */     //   7375: iload #11
/*      */     //   7377: iconst_1
/*      */     //   7378: iadd
/*      */     //   7379: iconst_2
/*      */     //   7380: idiv
/*      */     //   7381: iadd
/*      */     //   7382: bipush #65
/*      */     //   7384: isub
/*      */     //   7385: iload #16
/*      */     //   7387: bipush #15
/*      */     //   7389: imul
/*      */     //   7390: iadd
/*      */     //   7391: ldc_w '>'
/*      */     //   7394: invokespecial <init> : (IIILjava/lang/String;)V
/*      */     //   7397: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   7402: pop
/*      */     //   7403: aload #7
/*      */     //   7405: aload #18
/*      */     //   7407: iload #12
/*      */     //   7409: iload #10
/*      */     //   7411: iconst_2
/*      */     //   7412: idiv
/*      */     //   7413: iadd
/*      */     //   7414: bipush #125
/*      */     //   7416: isub
/*      */     //   7417: bipush #17
/*      */     //   7419: iadd
/*      */     //   7420: iload #13
/*      */     //   7422: iload #11
/*      */     //   7424: iconst_1
/*      */     //   7425: iadd
/*      */     //   7426: iconst_2
/*      */     //   7427: idiv
/*      */     //   7428: iadd
/*      */     //   7429: bipush #65
/*      */     //   7431: isub
/*      */     //   7432: iload #16
/*      */     //   7434: bipush #15
/*      */     //   7436: imul
/*      */     //   7437: iadd
/*      */     //   7438: iconst_1
/*      */     //   7439: iadd
/*      */     //   7440: iconst_0
/*      */     //   7441: invokevirtual func_78276_b : (Ljava/lang/String;III)I
/*      */     //   7444: pop
/*      */     //   7445: getstatic JinRyuu/FamilyC/FamilyCCharGui.dtcf : Ljava/lang/String;
/*      */     //   7448: ldc_w '3'
/*      */     //   7451: invokevirtual contains : (Ljava/lang/CharSequence;)Z
/*      */     //   7454: ifeq -> 7539
/*      */     //   7457: ldc_w 'Select Target'
/*      */     //   7460: astore #18
/*      */     //   7462: aload_0
/*      */     //   7463: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   7466: aload #18
/*      */     //   7468: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   7471: istore #19
/*      */     //   7473: aload_0
/*      */     //   7474: getfield field_146292_n : Ljava/util/List;
/*      */     //   7477: new JinRyuu/JRMCore/JRMCoreGuiButtons00
/*      */     //   7480: dup
/*      */     //   7481: iconst_5
/*      */     //   7482: iload #12
/*      */     //   7484: iload #10
/*      */     //   7486: iconst_2
/*      */     //   7487: idiv
/*      */     //   7488: iadd
/*      */     //   7489: bipush #70
/*      */     //   7491: iadd
/*      */     //   7492: iload #19
/*      */     //   7494: isub
/*      */     //   7495: iload #21
/*      */     //   7497: iadd
/*      */     //   7498: iconst_4
/*      */     //   7499: iadd
/*      */     //   7500: iload #13
/*      */     //   7502: iload #11
/*      */     //   7504: iconst_1
/*      */     //   7505: iadd
/*      */     //   7506: iconst_2
/*      */     //   7507: idiv
/*      */     //   7508: iadd
/*      */     //   7509: bipush #65
/*      */     //   7511: isub
/*      */     //   7512: iload #16
/*      */     //   7514: bipush #15
/*      */     //   7516: imul
/*      */     //   7517: iadd
/*      */     //   7518: iconst_2
/*      */     //   7519: isub
/*      */     //   7520: iload #19
/*      */     //   7522: bipush #8
/*      */     //   7524: iadd
/*      */     //   7525: bipush #20
/*      */     //   7527: aload #18
/*      */     //   7529: iconst_0
/*      */     //   7530: invokespecial <init> : (IIIIILjava/lang/String;I)V
/*      */     //   7533: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   7538: pop
/*      */     //   7539: iload #16
/*      */     //   7541: iconst_1
/*      */     //   7542: iadd
/*      */     //   7543: istore #16
/*      */     //   7545: getstatic JinRyuu/FamilyC/FamilyCCharGui.dtca : Ljava/lang/String;
/*      */     //   7548: ldc '0'
/*      */     //   7550: invokevirtual contains : (Ljava/lang/CharSequence;)Z
/*      */     //   7553: ifeq -> 7562
/*      */     //   7556: ldc_w 'Defensive'
/*      */     //   7559: goto -> 7565
/*      */     //   7562: ldc_w 'Aggressive'
/*      */     //   7565: astore #18
/*      */     //   7567: aload_0
/*      */     //   7568: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   7571: aload #18
/*      */     //   7573: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   7576: istore #19
/*      */     //   7578: iconst_1
/*      */     //   7579: istore #23
/*      */     //   7581: iload #23
/*      */     //   7583: ifeq -> 7741
/*      */     //   7586: aload_0
/*      */     //   7587: getfield field_146292_n : Ljava/util/List;
/*      */     //   7590: new JinRyuu/JRMCore/JRMCoreGuiButtonsA2
/*      */     //   7593: dup
/*      */     //   7594: bipush #-3
/*      */     //   7596: iload #12
/*      */     //   7598: iload #10
/*      */     //   7600: iconst_2
/*      */     //   7601: idiv
/*      */     //   7602: iadd
/*      */     //   7603: bipush #125
/*      */     //   7605: isub
/*      */     //   7606: iload #13
/*      */     //   7608: iload #11
/*      */     //   7610: iconst_1
/*      */     //   7611: iadd
/*      */     //   7612: iconst_2
/*      */     //   7613: idiv
/*      */     //   7614: iadd
/*      */     //   7615: bipush #65
/*      */     //   7617: isub
/*      */     //   7618: iload #16
/*      */     //   7620: bipush #15
/*      */     //   7622: imul
/*      */     //   7623: iadd
/*      */     //   7624: ldc_w '<'
/*      */     //   7627: invokespecial <init> : (IIILjava/lang/String;)V
/*      */     //   7630: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   7635: pop
/*      */     //   7636: aload_0
/*      */     //   7637: getfield field_146292_n : Ljava/util/List;
/*      */     //   7640: new JinRyuu/JRMCore/JRMCoreGuiButtonsA2
/*      */     //   7643: dup
/*      */     //   7644: iconst_3
/*      */     //   7645: iload #12
/*      */     //   7647: iload #10
/*      */     //   7649: iconst_2
/*      */     //   7650: idiv
/*      */     //   7651: iadd
/*      */     //   7652: bipush #125
/*      */     //   7654: isub
/*      */     //   7655: bipush #20
/*      */     //   7657: iadd
/*      */     //   7658: iload #19
/*      */     //   7660: iadd
/*      */     //   7661: iconst_4
/*      */     //   7662: iadd
/*      */     //   7663: iload #13
/*      */     //   7665: iload #11
/*      */     //   7667: iconst_1
/*      */     //   7668: iadd
/*      */     //   7669: iconst_2
/*      */     //   7670: idiv
/*      */     //   7671: iadd
/*      */     //   7672: bipush #65
/*      */     //   7674: isub
/*      */     //   7675: iload #16
/*      */     //   7677: bipush #15
/*      */     //   7679: imul
/*      */     //   7680: iadd
/*      */     //   7681: ldc_w '>'
/*      */     //   7684: invokespecial <init> : (IIILjava/lang/String;)V
/*      */     //   7687: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   7692: pop
/*      */     //   7693: aload #7
/*      */     //   7695: aload #18
/*      */     //   7697: iload #12
/*      */     //   7699: iload #10
/*      */     //   7701: iconst_2
/*      */     //   7702: idiv
/*      */     //   7703: iadd
/*      */     //   7704: bipush #125
/*      */     //   7706: isub
/*      */     //   7707: bipush #17
/*      */     //   7709: iadd
/*      */     //   7710: iload #13
/*      */     //   7712: iload #11
/*      */     //   7714: iconst_1
/*      */     //   7715: iadd
/*      */     //   7716: iconst_2
/*      */     //   7717: idiv
/*      */     //   7718: iadd
/*      */     //   7719: bipush #65
/*      */     //   7721: isub
/*      */     //   7722: iload #16
/*      */     //   7724: bipush #15
/*      */     //   7726: imul
/*      */     //   7727: iadd
/*      */     //   7728: iconst_1
/*      */     //   7729: iadd
/*      */     //   7730: iconst_0
/*      */     //   7731: invokevirtual func_78276_b : (Ljava/lang/String;III)I
/*      */     //   7734: pop
/*      */     //   7735: iload #16
/*      */     //   7737: iconst_1
/*      */     //   7738: iadd
/*      */     //   7739: istore #16
/*      */     //   7741: getstatic JinRyuu/FamilyC/FamilyCCharGui.dtcd : Ljava/lang/String;
/*      */     //   7744: ldc '0'
/*      */     //   7746: invokevirtual contains : (Ljava/lang/CharSequence;)Z
/*      */     //   7749: ifeq -> 7758
/*      */     //   7752: ldc_w 'Don't Drop Equipment'
/*      */     //   7755: goto -> 7761
/*      */     //   7758: ldc_w 'Drop Equipment'
/*      */     //   7761: astore #18
/*      */     //   7763: aload_0
/*      */     //   7764: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   7767: aload #18
/*      */     //   7769: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   7772: istore #19
/*      */     //   7774: iconst_1
/*      */     //   7775: istore #24
/*      */     //   7777: iload #24
/*      */     //   7779: ifeq -> 7937
/*      */     //   7782: aload_0
/*      */     //   7783: getfield field_146292_n : Ljava/util/List;
/*      */     //   7786: new JinRyuu/JRMCore/JRMCoreGuiButtonsA2
/*      */     //   7789: dup
/*      */     //   7790: bipush #-4
/*      */     //   7792: iload #12
/*      */     //   7794: iload #10
/*      */     //   7796: iconst_2
/*      */     //   7797: idiv
/*      */     //   7798: iadd
/*      */     //   7799: bipush #125
/*      */     //   7801: isub
/*      */     //   7802: iload #13
/*      */     //   7804: iload #11
/*      */     //   7806: iconst_1
/*      */     //   7807: iadd
/*      */     //   7808: iconst_2
/*      */     //   7809: idiv
/*      */     //   7810: iadd
/*      */     //   7811: bipush #65
/*      */     //   7813: isub
/*      */     //   7814: iload #16
/*      */     //   7816: bipush #15
/*      */     //   7818: imul
/*      */     //   7819: iadd
/*      */     //   7820: ldc_w '<'
/*      */     //   7823: invokespecial <init> : (IIILjava/lang/String;)V
/*      */     //   7826: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   7831: pop
/*      */     //   7832: aload_0
/*      */     //   7833: getfield field_146292_n : Ljava/util/List;
/*      */     //   7836: new JinRyuu/JRMCore/JRMCoreGuiButtonsA2
/*      */     //   7839: dup
/*      */     //   7840: iconst_4
/*      */     //   7841: iload #12
/*      */     //   7843: iload #10
/*      */     //   7845: iconst_2
/*      */     //   7846: idiv
/*      */     //   7847: iadd
/*      */     //   7848: bipush #125
/*      */     //   7850: isub
/*      */     //   7851: bipush #20
/*      */     //   7853: iadd
/*      */     //   7854: iload #19
/*      */     //   7856: iadd
/*      */     //   7857: iconst_4
/*      */     //   7858: iadd
/*      */     //   7859: iload #13
/*      */     //   7861: iload #11
/*      */     //   7863: iconst_1
/*      */     //   7864: iadd
/*      */     //   7865: iconst_2
/*      */     //   7866: idiv
/*      */     //   7867: iadd
/*      */     //   7868: bipush #65
/*      */     //   7870: isub
/*      */     //   7871: iload #16
/*      */     //   7873: bipush #15
/*      */     //   7875: imul
/*      */     //   7876: iadd
/*      */     //   7877: ldc_w '>'
/*      */     //   7880: invokespecial <init> : (IIILjava/lang/String;)V
/*      */     //   7883: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   7888: pop
/*      */     //   7889: aload #7
/*      */     //   7891: aload #18
/*      */     //   7893: iload #12
/*      */     //   7895: iload #10
/*      */     //   7897: iconst_2
/*      */     //   7898: idiv
/*      */     //   7899: iadd
/*      */     //   7900: bipush #125
/*      */     //   7902: isub
/*      */     //   7903: bipush #17
/*      */     //   7905: iadd
/*      */     //   7906: iload #13
/*      */     //   7908: iload #11
/*      */     //   7910: iconst_1
/*      */     //   7911: iadd
/*      */     //   7912: iconst_2
/*      */     //   7913: idiv
/*      */     //   7914: iadd
/*      */     //   7915: bipush #65
/*      */     //   7917: isub
/*      */     //   7918: iload #16
/*      */     //   7920: bipush #15
/*      */     //   7922: imul
/*      */     //   7923: iadd
/*      */     //   7924: iconst_1
/*      */     //   7925: iadd
/*      */     //   7926: iconst_0
/*      */     //   7927: invokevirtual func_78276_b : (Ljava/lang/String;III)I
/*      */     //   7930: pop
/*      */     //   7931: iload #16
/*      */     //   7933: iconst_1
/*      */     //   7934: iadd
/*      */     //   7935: istore #16
/*      */     //   7937: bipush #6
/*      */     //   7939: istore #25
/*      */     //   7941: bipush #6
/*      */     //   7943: newarray int
/*      */     //   7945: astore #26
/*      */     //   7947: aload #17
/*      */     //   7949: invokevirtual getAttrbts : ()Ljava/lang/String;
/*      */     //   7952: ldc ':'
/*      */     //   7954: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
/*      */     //   7957: astore #27
/*      */     //   7959: iconst_0
/*      */     //   7960: istore #28
/*      */     //   7962: iload #28
/*      */     //   7964: bipush #6
/*      */     //   7966: if_icmpge -> 7988
/*      */     //   7969: aload #26
/*      */     //   7971: iload #28
/*      */     //   7973: aload #27
/*      */     //   7975: iload #28
/*      */     //   7977: aaload
/*      */     //   7978: invokestatic parseInt : (Ljava/lang/String;)I
/*      */     //   7981: iastore
/*      */     //   7982: iinc #28, 1
/*      */     //   7985: goto -> 7962
/*      */     //   7988: iconst_0
/*      */     //   7989: istore #28
/*      */     //   7991: iload #28
/*      */     //   7993: getstatic JinRyuu/JRMCore/JRMCoreH.attrInit : [[Ljava/lang/String;
/*      */     //   7996: iconst_1
/*      */     //   7997: aaload
/*      */     //   7998: arraylength
/*      */     //   7999: if_icmpge -> 8097
/*      */     //   8002: new java/lang/StringBuilder
/*      */     //   8005: dup
/*      */     //   8006: invokespecial <init> : ()V
/*      */     //   8009: ldc_w 'jrmc'
/*      */     //   8012: getstatic JinRyuu/JRMCore/JRMCoreH.attrNms : [[Ljava/lang/String;
/*      */     //   8015: iconst_1
/*      */     //   8016: aaload
/*      */     //   8017: iload #28
/*      */     //   8019: aaload
/*      */     //   8020: invokestatic trl : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
/*      */     //   8023: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   8026: ldc_w ': '
/*      */     //   8029: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   8032: aload #26
/*      */     //   8034: iload #28
/*      */     //   8036: iaload
/*      */     //   8037: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*      */     //   8040: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   8043: astore #18
/*      */     //   8045: iload #25
/*      */     //   8047: aload #18
/*      */     //   8049: ldc ''
/*      */     //   8051: iconst_0
/*      */     //   8052: iconst_1
/*      */     //   8053: iload #12
/*      */     //   8055: iload #10
/*      */     //   8057: iconst_2
/*      */     //   8058: idiv
/*      */     //   8059: iadd
/*      */     //   8060: bipush #125
/*      */     //   8062: isub
/*      */     //   8063: bipush #10
/*      */     //   8065: iadd
/*      */     //   8066: iload #13
/*      */     //   8068: iload #11
/*      */     //   8070: iconst_1
/*      */     //   8071: iadd
/*      */     //   8072: iconst_2
/*      */     //   8073: idiv
/*      */     //   8074: iadd
/*      */     //   8075: bipush #65
/*      */     //   8077: isub
/*      */     //   8078: iload #25
/*      */     //   8080: bipush #10
/*      */     //   8082: imul
/*      */     //   8083: iadd
/*      */     //   8084: iconst_0
/*      */     //   8085: invokestatic txt : (Ljava/lang/String;Ljava/lang/String;IZIII)I
/*      */     //   8088: iadd
/*      */     //   8089: istore #25
/*      */     //   8091: iinc #28, 1
/*      */     //   8094: goto -> 7991
/*      */     //   8097: bipush #6
/*      */     //   8099: istore #25
/*      */     //   8101: aload #26
/*      */     //   8103: iconst_0
/*      */     //   8104: iaload
/*      */     //   8105: iconst_1
/*      */     //   8106: imul
/*      */     //   8107: i2f
/*      */     //   8108: aload #26
/*      */     //   8110: iconst_3
/*      */     //   8111: iaload
/*      */     //   8112: i2f
/*      */     //   8113: ldc_w 0.5
/*      */     //   8116: fmul
/*      */     //   8117: ldc_w 50.0
/*      */     //   8120: fmul
/*      */     //   8121: ldc_w 0.02
/*      */     //   8124: fmul
/*      */     //   8125: fadd
/*      */     //   8126: f2i
/*      */     //   8127: istore #28
/*      */     //   8129: aload #26
/*      */     //   8131: iconst_0
/*      */     //   8132: iaload
/*      */     //   8133: iconst_3
/*      */     //   8134: imul
/*      */     //   8135: i2f
/*      */     //   8136: aload #26
/*      */     //   8138: iconst_3
/*      */     //   8139: iaload
/*      */     //   8140: i2f
/*      */     //   8141: ldc_w 0.5
/*      */     //   8144: fmul
/*      */     //   8145: ldc_w 50.0
/*      */     //   8148: fmul
/*      */     //   8149: ldc_w 0.02
/*      */     //   8152: fmul
/*      */     //   8153: fadd
/*      */     //   8154: f2i
/*      */     //   8155: istore #29
/*      */     //   8157: new java/lang/StringBuilder
/*      */     //   8160: dup
/*      */     //   8161: invokespecial <init> : ()V
/*      */     //   8164: ldc_w 'Melee: '
/*      */     //   8167: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   8170: iload #28
/*      */     //   8172: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*      */     //   8175: ldc_w '-'
/*      */     //   8178: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   8181: iload #29
/*      */     //   8183: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*      */     //   8186: ldc_w ' dmg'
/*      */     //   8189: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   8192: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   8195: astore #18
/*      */     //   8197: iload #25
/*      */     //   8199: aload #18
/*      */     //   8201: ldc ''
/*      */     //   8203: iconst_0
/*      */     //   8204: iconst_1
/*      */     //   8205: iload #12
/*      */     //   8207: iload #10
/*      */     //   8209: iconst_2
/*      */     //   8210: idiv
/*      */     //   8211: iadd
/*      */     //   8212: iload #13
/*      */     //   8214: iload #11
/*      */     //   8216: iconst_1
/*      */     //   8217: iadd
/*      */     //   8218: iconst_2
/*      */     //   8219: idiv
/*      */     //   8220: iadd
/*      */     //   8221: bipush #65
/*      */     //   8223: isub
/*      */     //   8224: iload #25
/*      */     //   8226: bipush #10
/*      */     //   8228: imul
/*      */     //   8229: iadd
/*      */     //   8230: iconst_0
/*      */     //   8231: invokestatic txt : (Ljava/lang/String;Ljava/lang/String;IZIII)I
/*      */     //   8234: iadd
/*      */     //   8235: istore #25
/*      */     //   8237: iload #25
/*      */     //   8239: iconst_1
/*      */     //   8240: iadd
/*      */     //   8241: istore #25
/*      */     //   8243: aload #26
/*      */     //   8245: iconst_2
/*      */     //   8246: iaload
/*      */     //   8247: iconst_2
/*      */     //   8248: imul
/*      */     //   8249: istore #30
/*      */     //   8251: iload #30
/*      */     //   8253: i2f
/*      */     //   8254: getstatic JinRyuu/JRMCore/JRMCoreConfig.hRgnRt : I
/*      */     //   8257: i2f
/*      */     //   8258: ldc_w 0.5
/*      */     //   8261: fmul
/*      */     //   8262: fmul
/*      */     //   8263: fstore #31
/*      */     //   8265: fload #31
/*      */     //   8267: fconst_1
/*      */     //   8268: fcmpg
/*      */     //   8269: ifge -> 8276
/*      */     //   8272: fconst_1
/*      */     //   8273: goto -> 8278
/*      */     //   8276: fload #31
/*      */     //   8278: f2i
/*      */     //   8279: istore #32
/*      */     //   8281: new java/lang/StringBuilder
/*      */     //   8284: dup
/*      */     //   8285: invokespecial <init> : ()V
/*      */     //   8288: ldc_w 'Health: '
/*      */     //   8291: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   8294: aload #17
/*      */     //   8296: invokevirtual func_110143_aJ : ()F
/*      */     //   8299: f2i
/*      */     //   8300: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*      */     //   8303: ldc_w '/'
/*      */     //   8306: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   8309: aload #26
/*      */     //   8311: iconst_2
/*      */     //   8312: iaload
/*      */     //   8313: invokestatic DBC : ()Z
/*      */     //   8316: ifne -> 8325
/*      */     //   8319: invokestatic NC : ()Z
/*      */     //   8322: ifeq -> 8330
/*      */     //   8325: bipush #40
/*      */     //   8327: goto -> 8331
/*      */     //   8330: iconst_5
/*      */     //   8331: imul
/*      */     //   8332: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*      */     //   8335: ldc_w '+'
/*      */     //   8338: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   8341: getstatic JinRyuu/JRMCore/JRMCoreH.cldr : Ljava/lang/String;
/*      */     //   8344: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   8347: iload #32
/*      */     //   8349: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*      */     //   8352: ldc_w '/5s'
/*      */     //   8355: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   8358: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   8361: astore #18
/*      */     //   8363: iload #25
/*      */     //   8365: aload #18
/*      */     //   8367: ldc ''
/*      */     //   8369: iconst_0
/*      */     //   8370: iconst_1
/*      */     //   8371: iload #12
/*      */     //   8373: iload #10
/*      */     //   8375: iconst_2
/*      */     //   8376: idiv
/*      */     //   8377: iadd
/*      */     //   8378: iload #13
/*      */     //   8380: iload #11
/*      */     //   8382: iconst_1
/*      */     //   8383: iadd
/*      */     //   8384: iconst_2
/*      */     //   8385: idiv
/*      */     //   8386: iadd
/*      */     //   8387: bipush #65
/*      */     //   8389: isub
/*      */     //   8390: iload #25
/*      */     //   8392: bipush #10
/*      */     //   8394: imul
/*      */     //   8395: iadd
/*      */     //   8396: iconst_0
/*      */     //   8397: invokestatic txt : (Ljava/lang/String;Ljava/lang/String;IZIII)I
/*      */     //   8400: iadd
/*      */     //   8401: istore #25
/*      */     //   8403: ldc_w 'Tell'
/*      */     //   8406: astore #18
/*      */     //   8408: aload_0
/*      */     //   8409: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   8412: aload #18
/*      */     //   8414: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   8417: istore #19
/*      */     //   8419: iload #15
/*      */     //   8421: ifeq -> 8478
/*      */     //   8424: aload_0
/*      */     //   8425: getfield field_146292_n : Ljava/util/List;
/*      */     //   8428: new JinRyuu/JRMCore/JRMCoreGuiButtons00
/*      */     //   8431: dup
/*      */     //   8432: iconst_1
/*      */     //   8433: iload #12
/*      */     //   8435: iload #10
/*      */     //   8437: iconst_2
/*      */     //   8438: idiv
/*      */     //   8439: iadd
/*      */     //   8440: sipush #130
/*      */     //   8443: iadd
/*      */     //   8444: iload #13
/*      */     //   8446: iload #11
/*      */     //   8448: iconst_1
/*      */     //   8449: iadd
/*      */     //   8450: iconst_2
/*      */     //   8451: idiv
/*      */     //   8452: iadd
/*      */     //   8453: bipush #50
/*      */     //   8455: isub
/*      */     //   8456: bipush #115
/*      */     //   8458: iadd
/*      */     //   8459: iload #19
/*      */     //   8461: bipush #8
/*      */     //   8463: iadd
/*      */     //   8464: bipush #20
/*      */     //   8466: aload #18
/*      */     //   8468: iconst_0
/*      */     //   8469: invokespecial <init> : (IIIIILjava/lang/String;I)V
/*      */     //   8472: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   8477: pop
/*      */     //   8478: goto -> 8899
/*      */     //   8481: getstatic JinRyuu/FamilyC/FamilyCCharGui.inv : I
/*      */     //   8484: bipush #21
/*      */     //   8486: if_icmpne -> 8899
/*      */     //   8489: iconst_0
/*      */     //   8490: istore #16
/*      */     //   8492: iconst_0
/*      */     //   8493: istore #17
/*      */     //   8495: iconst_0
/*      */     //   8496: istore #18
/*      */     //   8498: getstatic JinRyuu/JRMCore/JRMCoreH.plyrs : [Ljava/lang/String;
/*      */     //   8501: ifnull -> 8683
/*      */     //   8504: getstatic JinRyuu/JRMCore/JRMCoreH.plyrs : [Ljava/lang/String;
/*      */     //   8507: arraylength
/*      */     //   8508: ifle -> 8683
/*      */     //   8511: iconst_0
/*      */     //   8512: istore #19
/*      */     //   8514: iload #19
/*      */     //   8516: getstatic JinRyuu/JRMCore/JRMCoreH.plyrs : [Ljava/lang/String;
/*      */     //   8519: arraylength
/*      */     //   8520: if_icmpge -> 8683
/*      */     //   8523: iload #16
/*      */     //   8525: bipush #14
/*      */     //   8527: aload_0
/*      */     //   8528: getfield ipg : I
/*      */     //   8531: bipush #14
/*      */     //   8533: imul
/*      */     //   8534: iadd
/*      */     //   8535: if_icmpgt -> 8677
/*      */     //   8538: iload #16
/*      */     //   8540: iconst_0
/*      */     //   8541: aload_0
/*      */     //   8542: getfield ipg : I
/*      */     //   8545: bipush #14
/*      */     //   8547: imul
/*      */     //   8548: iadd
/*      */     //   8549: if_icmplt -> 8677
/*      */     //   8552: aload_0
/*      */     //   8553: getfield field_146297_k : Lnet/minecraft/client/Minecraft;
/*      */     //   8556: getfield field_71441_e : Lnet/minecraft/client/multiplayer/WorldClient;
/*      */     //   8559: getstatic JinRyuu/JRMCore/JRMCoreH.plyrs : [Ljava/lang/String;
/*      */     //   8562: iload #19
/*      */     //   8564: aaload
/*      */     //   8565: invokevirtual func_72924_a : (Ljava/lang/String;)Lnet/minecraft/entity/player/EntityPlayer;
/*      */     //   8568: astore #20
/*      */     //   8570: aload #20
/*      */     //   8572: ifnull -> 8677
/*      */     //   8575: aload #20
/*      */     //   8577: invokevirtual func_70005_c_ : ()Ljava/lang/String;
/*      */     //   8580: astore #21
/*      */     //   8582: aload #21
/*      */     //   8584: aload_0
/*      */     //   8585: getfield field_146297_k : Lnet/minecraft/client/Minecraft;
/*      */     //   8588: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*      */     //   8591: invokevirtual func_70005_c_ : ()Ljava/lang/String;
/*      */     //   8594: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   8597: ifne -> 8677
/*      */     //   8600: aload_0
/*      */     //   8601: getfield field_146292_n : Ljava/util/List;
/*      */     //   8604: new JinRyuu/JRMCore/JRMCoreGuiButtons01
/*      */     //   8607: dup
/*      */     //   8608: sipush #2000
/*      */     //   8611: iload #19
/*      */     //   8613: iadd
/*      */     //   8614: iload #12
/*      */     //   8616: iload #10
/*      */     //   8618: iconst_2
/*      */     //   8619: idiv
/*      */     //   8620: iadd
/*      */     //   8621: bipush #122
/*      */     //   8623: isub
/*      */     //   8624: iload #13
/*      */     //   8626: iload #11
/*      */     //   8628: iconst_1
/*      */     //   8629: iadd
/*      */     //   8630: iconst_2
/*      */     //   8631: idiv
/*      */     //   8632: iadd
/*      */     //   8633: bipush #74
/*      */     //   8635: isub
/*      */     //   8636: iload #16
/*      */     //   8638: bipush #10
/*      */     //   8640: imul
/*      */     //   8641: iadd
/*      */     //   8642: aload_0
/*      */     //   8643: getfield ipg : I
/*      */     //   8646: bipush #14
/*      */     //   8648: imul
/*      */     //   8649: bipush #10
/*      */     //   8651: imul
/*      */     //   8652: isub
/*      */     //   8653: aload_0
/*      */     //   8654: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   8657: aload #21
/*      */     //   8659: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   8662: aload #21
/*      */     //   8664: iconst_0
/*      */     //   8665: invokespecial <init> : (IIIILjava/lang/String;I)V
/*      */     //   8668: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   8673: pop
/*      */     //   8674: iinc #16, 1
/*      */     //   8677: iinc #19, 1
/*      */     //   8680: goto -> 8514
/*      */     //   8683: iload #16
/*      */     //   8685: ifne -> 8740
/*      */     //   8688: ldc_w 'No other players found.'
/*      */     //   8691: astore #19
/*      */     //   8693: aload_0
/*      */     //   8694: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   8697: aload #19
/*      */     //   8699: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   8702: istore #20
/*      */     //   8704: aload #7
/*      */     //   8706: aload #19
/*      */     //   8708: iload #12
/*      */     //   8710: iload #10
/*      */     //   8712: iconst_2
/*      */     //   8713: idiv
/*      */     //   8714: iadd
/*      */     //   8715: bipush #125
/*      */     //   8717: isub
/*      */     //   8718: bipush #20
/*      */     //   8720: iadd
/*      */     //   8721: iload #13
/*      */     //   8723: iload #11
/*      */     //   8725: iconst_1
/*      */     //   8726: iadd
/*      */     //   8727: iconst_2
/*      */     //   8728: idiv
/*      */     //   8729: iadd
/*      */     //   8730: bipush #70
/*      */     //   8732: isub
/*      */     //   8733: iconst_4
/*      */     //   8734: iadd
/*      */     //   8735: iconst_0
/*      */     //   8736: invokevirtual func_78276_b : (Ljava/lang/String;III)I
/*      */     //   8739: pop
/*      */     //   8740: getstatic JinRyuu/JRMCore/JRMCoreH.plyrs : [Ljava/lang/String;
/*      */     //   8743: arraylength
/*      */     //   8744: bipush #14
/*      */     //   8746: aload_0
/*      */     //   8747: getfield ipg : I
/*      */     //   8750: bipush #14
/*      */     //   8752: imul
/*      */     //   8753: iadd
/*      */     //   8754: if_icmple -> 8821
/*      */     //   8757: ldc_w 'Next'
/*      */     //   8760: astore #19
/*      */     //   8762: aload_0
/*      */     //   8763: getfield field_146292_n : Ljava/util/List;
/*      */     //   8766: new JinRyuu/JRMCore/JRMCoreGuiButtons00
/*      */     //   8769: dup
/*      */     //   8770: bipush #88
/*      */     //   8772: iload #12
/*      */     //   8774: iload #10
/*      */     //   8776: iconst_2
/*      */     //   8777: idiv
/*      */     //   8778: iadd
/*      */     //   8779: sipush #130
/*      */     //   8782: iadd
/*      */     //   8783: iload #13
/*      */     //   8785: iload #11
/*      */     //   8787: iconst_1
/*      */     //   8788: iadd
/*      */     //   8789: iconst_2
/*      */     //   8790: idiv
/*      */     //   8791: iadd
/*      */     //   8792: bipush #15
/*      */     //   8794: iadd
/*      */     //   8795: aload_0
/*      */     //   8796: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   8799: aload #19
/*      */     //   8801: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   8804: bipush #8
/*      */     //   8806: iadd
/*      */     //   8807: bipush #20
/*      */     //   8809: aload #19
/*      */     //   8811: iconst_0
/*      */     //   8812: invokespecial <init> : (IIIIILjava/lang/String;I)V
/*      */     //   8815: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   8820: pop
/*      */     //   8821: aload_0
/*      */     //   8822: getfield ipg : I
/*      */     //   8825: ifeq -> 8899
/*      */     //   8828: ldc_w 'Prev'
/*      */     //   8831: astore #19
/*      */     //   8833: aload_0
/*      */     //   8834: getfield field_146289_q : Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   8837: aload #19
/*      */     //   8839: invokevirtual func_78256_a : (Ljava/lang/String;)I
/*      */     //   8842: bipush #8
/*      */     //   8844: iadd
/*      */     //   8845: istore #20
/*      */     //   8847: aload_0
/*      */     //   8848: getfield field_146292_n : Ljava/util/List;
/*      */     //   8851: new JinRyuu/JRMCore/JRMCoreGuiButtons00
/*      */     //   8854: dup
/*      */     //   8855: bipush #89
/*      */     //   8857: iload #12
/*      */     //   8859: iload #10
/*      */     //   8861: iconst_2
/*      */     //   8862: idiv
/*      */     //   8863: iadd
/*      */     //   8864: sipush #130
/*      */     //   8867: isub
/*      */     //   8868: iload #20
/*      */     //   8870: isub
/*      */     //   8871: iload #13
/*      */     //   8873: iload #11
/*      */     //   8875: iconst_1
/*      */     //   8876: iadd
/*      */     //   8877: iconst_2
/*      */     //   8878: idiv
/*      */     //   8879: iadd
/*      */     //   8880: bipush #15
/*      */     //   8882: iadd
/*      */     //   8883: iload #20
/*      */     //   8885: bipush #20
/*      */     //   8887: aload #19
/*      */     //   8889: iconst_0
/*      */     //   8890: invokespecial <init> : (IIIIILjava/lang/String;I)V
/*      */     //   8893: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   8898: pop
/*      */     //   8899: aload_0
/*      */     //   8900: getfield field_146292_n : Ljava/util/List;
/*      */     //   8903: new JinRyuu/JRMCore/JRMCoreGuiButtons00
/*      */     //   8906: dup
/*      */     //   8907: bipush #10
/*      */     //   8909: iload #12
/*      */     //   8911: iload #10
/*      */     //   8913: iconst_2
/*      */     //   8914: idiv
/*      */     //   8915: iadd
/*      */     //   8916: sipush #150
/*      */     //   8919: isub
/*      */     //   8920: iload #13
/*      */     //   8922: iload #11
/*      */     //   8924: iconst_2
/*      */     //   8925: idiv
/*      */     //   8926: iadd
/*      */     //   8927: bipush #65
/*      */     //   8929: iadd
/*      */     //   8930: bipush #20
/*      */     //   8932: bipush #20
/*      */     //   8934: ldc_w 'X'
/*      */     //   8937: iconst_0
/*      */     //   8938: invokespecial <init> : (IIIIILjava/lang/String;I)V
/*      */     //   8941: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   8946: pop
/*      */     //   8947: iload #9
/*      */     //   8949: ifeq -> 8957
/*      */     //   8952: aload_0
/*      */     //   8953: aconst_null
/*      */     //   8954: putfield inputField : Lnet/minecraft/client/gui/GuiTextField;
/*      */     //   8957: aload_0
/*      */     //   8958: iload_1
/*      */     //   8959: iload_2
/*      */     //   8960: fload_3
/*      */     //   8961: invokespecial func_73863_a : (IIF)V
/*      */     //   8964: return
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #433	-> 0
/*      */     //   #434	-> 27
/*      */     //   #435	-> 34
/*      */     //   #436	-> 41
/*      */     //   #437	-> 50
/*      */     //   #438	-> 55
/*      */     //   #439	-> 64
/*      */     //   #441	-> 67
/*      */     //   #443	-> 85
/*      */     //   #444	-> 90
/*      */     //   #445	-> 95
/*      */     //   #446	-> 106
/*      */     //   #447	-> 117
/*      */     //   #448	-> 124
/*      */     //   #449	-> 135
/*      */     //   #450	-> 147
/*      */     //   #451	-> 161
/*      */     //   #452	-> 209
/*      */     //   #453	-> 218
/*      */     //   #454	-> 227
/*      */     //   #455	-> 236
/*      */     //   #457	-> 285
/*      */     //   #468	-> 334
/*      */     //   #469	-> 340
/*      */     //   #470	-> 356
/*      */     //   #471	-> 361
/*      */     //   #472	-> 384
/*      */     //   #473	-> 401
/*      */     //   #474	-> 406
/*      */     //   #475	-> 464
/*      */     //   #476	-> 469
/*      */     //   #477	-> 527
/*      */     //   #478	-> 530
/*      */     //   #479	-> 546
/*      */     //   #480	-> 551
/*      */     //   #481	-> 574
/*      */     //   #482	-> 591
/*      */     //   #483	-> 596
/*      */     //   #484	-> 654
/*      */     //   #485	-> 659
/*      */     //   #486	-> 717
/*      */     //   #488	-> 720
/*      */     //   #489	-> 725
/*      */     //   #490	-> 736
/*      */     //   #491	-> 772
/*      */     //   #492	-> 822
/*      */     //   #493	-> 840
/*      */     //   #494	-> 851
/*      */     //   #495	-> 856
/*      */     //   #496	-> 867
/*      */     //   #497	-> 872
/*      */     //   #498	-> 883
/*      */     //   #499	-> 914
/*      */     //   #500	-> 965
/*      */     //   #502	-> 1062
/*      */     //   #504	-> 1090
/*      */     //   #505	-> 1095
/*      */     //   #507	-> 1153
/*      */     //   #509	-> 1177
/*      */     //   #514	-> 1183
/*      */     //   #517	-> 1205
/*      */     //   #518	-> 1212
/*      */     //   #519	-> 1225
/*      */     //   #520	-> 1237
/*      */     //   #522	-> 1245
/*      */     //   #523	-> 1256
/*      */     //   #524	-> 1266
/*      */     //   #525	-> 1277
/*      */     //   #526	-> 1280
/*      */     //   #528	-> 1289
/*      */     //   #529	-> 1292
/*      */     //   #530	-> 1303
/*      */     //   #531	-> 1310
/*      */     //   #532	-> 1319
/*      */     //   #529	-> 1377
/*      */     //   #519	-> 1383
/*      */     //   #536	-> 1389
/*      */     //   #537	-> 1410
/*      */     //   #540	-> 1419
/*      */     //   #541	-> 1422
/*      */     //   #542	-> 1429
/*      */     //   #543	-> 1442
/*      */     //   #544	-> 1454
/*      */     //   #546	-> 1462
/*      */     //   #547	-> 1473
/*      */     //   #548	-> 1483
/*      */     //   #549	-> 1494
/*      */     //   #550	-> 1497
/*      */     //   #554	-> 1506
/*      */     //   #556	-> 1527
/*      */     //   #557	-> 1602
/*      */     //   #558	-> 1613
/*      */     //   #559	-> 1642
/*      */     //   #560	-> 1649
/*      */     //   #563	-> 1658
/*      */     //   #564	-> 1661
/*      */     //   #565	-> 1672
/*      */     //   #566	-> 1687
/*      */     //   #564	-> 1690
/*      */     //   #569	-> 1696
/*      */     //   #570	-> 1768
/*      */     //   #571	-> 1813
/*      */     //   #572	-> 1840
/*      */     //   #573	-> 1935
/*      */     //   #574	-> 1964
/*      */     //   #577	-> 1967
/*      */     //   #557	-> 1970
/*      */     //   #543	-> 1976
/*      */     //   #584	-> 1982
/*      */     //   #585	-> 2003
/*      */     //   #586	-> 2009
/*      */     //   #587	-> 2032
/*      */     //   #588	-> 2037
/*      */     //   #589	-> 2096
/*      */     //   #590	-> 2103
/*      */     //   #591	-> 2122
/*      */     //   #592	-> 2174
/*      */     //   #600	-> 2180
/*      */     //   #601	-> 2194
/*      */     //   #602	-> 2197
/*      */     //   #603	-> 2200
/*      */     //   #604	-> 2203
/*      */     //   #605	-> 2233
/*      */     //   #606	-> 2245
/*      */     //   #607	-> 2274
/*      */     //   #608	-> 2287
/*      */     //   #609	-> 2305
/*      */     //   #610	-> 2310
/*      */     //   #611	-> 2317
/*      */     //   #612	-> 2335
/*      */     //   #614	-> 2409
/*      */     //   #605	-> 2412
/*      */     //   #620	-> 2418
/*      */     //   #621	-> 2435
/*      */     //   #622	-> 2440
/*      */     //   #623	-> 2499
/*      */     //   #624	-> 2506
/*      */     //   #625	-> 2525
/*      */     //   #627	-> 2577
/*      */     //   #628	-> 2583
/*      */     //   #629	-> 2602
/*      */     //   #630	-> 2632
/*      */     //   #631	-> 2667
/*      */     //   #633	-> 2675
/*      */     //   #634	-> 2701
/*      */     //   #635	-> 2706
/*      */     //   #629	-> 2745
/*      */     //   #638	-> 2751
/*      */     //   #639	-> 2754
/*      */     //   #640	-> 2757
/*      */     //   #641	-> 2760
/*      */     //   #642	-> 2763
/*      */     //   #643	-> 2766
/*      */     //   #644	-> 2769
/*      */     //   #645	-> 2772
/*      */     //   #647	-> 2775
/*      */     //   #648	-> 2778
/*      */     //   #649	-> 2785
/*      */     //   #650	-> 2798
/*      */     //   #651	-> 2810
/*      */     //   #653	-> 2818
/*      */     //   #654	-> 2829
/*      */     //   #655	-> 2839
/*      */     //   #657	-> 2850
/*      */     //   #658	-> 2853
/*      */     //   #663	-> 2862
/*      */     //   #664	-> 2873
/*      */     //   #665	-> 2880
/*      */     //   #667	-> 2889
/*      */     //   #669	-> 2929
/*      */     //   #670	-> 3027
/*      */     //   #672	-> 3030
/*      */     //   #674	-> 3118
/*      */     //   #675	-> 3121
/*      */     //   #678	-> 3147
/*      */     //   #686	-> 3160
/*      */     //   #687	-> 3184
/*      */     //   #688	-> 3213
/*      */     //   #689	-> 3226
/*      */     //   #690	-> 3252
/*      */     //   #693	-> 3298
/*      */     //   #695	-> 3301
/*      */     //   #663	-> 3304
/*      */     //   #650	-> 3310
/*      */     //   #703	-> 3316
/*      */     //   #704	-> 3337
/*      */     //   #705	-> 3346
/*      */     //   #706	-> 3357
/*      */     //   #707	-> 3378
/*      */     //   #705	-> 3381
/*      */     //   #710	-> 3387
/*      */     //   #711	-> 3390
/*      */     //   #712	-> 3395
/*      */     //   #713	-> 3403
/*      */     //   #714	-> 3422
/*      */     //   #716	-> 3494
/*      */     //   #717	-> 3502
/*      */     //   #718	-> 3521
/*      */     //   #720	-> 3593
/*      */     //   #721	-> 3601
/*      */     //   #722	-> 3620
/*      */     //   #723	-> 3692
/*      */     //   #724	-> 3700
/*      */     //   #725	-> 3719
/*      */     //   #728	-> 3791
/*      */     //   #729	-> 3799
/*      */     //   #730	-> 3818
/*      */     //   #732	-> 3890
/*      */     //   #733	-> 3898
/*      */     //   #734	-> 3917
/*      */     //   #735	-> 3989
/*      */     //   #736	-> 3995
/*      */     //   #737	-> 4014
/*      */     //   #740	-> 4086
/*      */     //   #741	-> 4109
/*      */     //   #742	-> 4114
/*      */     //   #743	-> 4173
/*      */     //   #744	-> 4180
/*      */     //   #745	-> 4199
/*      */     //   #747	-> 4251
/*      */     //   #756	-> 4256
/*      */     //   #757	-> 4262
/*      */     //   #758	-> 4281
/*      */     //   #768	-> 4333
/*      */     //   #780	-> 4340
/*      */     //   #781	-> 4348
/*      */     //   #782	-> 4353
/*      */     //   #783	-> 4358
/*      */     //   #784	-> 4369
/*      */     //   #785	-> 4380
/*      */     //   #786	-> 4387
/*      */     //   #787	-> 4398
/*      */     //   #788	-> 4410
/*      */     //   #790	-> 4424
/*      */     //   #792	-> 4473
/*      */     //   #793	-> 4522
/*      */     //   #796	-> 4570
/*      */     //   #797	-> 4588
/*      */     //   #798	-> 4599
/*      */     //   #799	-> 4606
/*      */     //   #800	-> 4615
/*      */     //   #801	-> 4701
/*      */     //   #802	-> 4735
/*      */     //   #803	-> 4766
/*      */     //   #804	-> 4803
/*      */     //   #805	-> 4834
/*      */     //   #807	-> 4871
/*      */     //   #809	-> 4874
/*      */     //   #810	-> 4902
/*      */     //   #811	-> 4907
/*      */     //   #812	-> 4930
/*      */     //   #813	-> 4964
/*      */     //   #814	-> 4969
/*      */     //   #815	-> 5033
/*      */     //   #816	-> 5038
/*      */     //   #818	-> 5102
/*      */     //   #819	-> 5107
/*      */     //   #820	-> 5118
/*      */     //   #822	-> 5152
/*      */     //   #824	-> 5182
/*      */     //   #825	-> 5201
/*      */     //   #827	-> 5255
/*      */     //   #828	-> 5279
/*      */     //   #829	-> 5282
/*      */     //   #830	-> 5285
/*      */     //   #831	-> 5309
/*      */     //   #832	-> 5312
/*      */     //   #833	-> 5315
/*      */     //   #834	-> 5335
/*      */     //   #835	-> 5347
/*      */     //   #836	-> 5365
/*      */     //   #837	-> 5379
/*      */     //   #838	-> 5388
/*      */     //   #834	-> 5397
/*      */     //   #841	-> 5403
/*      */     //   #842	-> 5425
/*      */     //   #843	-> 5444
/*      */     //   #848	-> 5513
/*      */     //   #849	-> 5516
/*      */     //   #850	-> 5519
/*      */     //   #851	-> 5523
/*      */     //   #852	-> 5527
/*      */     //   #853	-> 5531
/*      */     //   #854	-> 5535
/*      */     //   #855	-> 5541
/*      */     //   #857	-> 5559
/*      */     //   #858	-> 5565
/*      */     //   #860	-> 5576
/*      */     //   #862	-> 5583
/*      */     //   #863	-> 5589
/*      */     //   #864	-> 5596
/*      */     //   #865	-> 5623
/*      */     //   #866	-> 5633
/*      */     //   #868	-> 5659
/*      */     //   #869	-> 5668
/*      */     //   #870	-> 5674
/*      */     //   #871	-> 5680
/*      */     //   #873	-> 5686
/*      */     //   #875	-> 5708
/*      */     //   #876	-> 5717
/*      */     //   #877	-> 5723
/*      */     //   #878	-> 5729
/*      */     //   #864	-> 5735
/*      */     //   #881	-> 5741
/*      */     //   #882	-> 5752
/*      */     //   #883	-> 5778
/*      */     //   #884	-> 5787
/*      */     //   #885	-> 5794
/*      */     //   #882	-> 5894
/*      */     //   #888	-> 5900
/*      */     //   #889	-> 5917
/*      */     //   #890	-> 5930
/*      */     //   #891	-> 5956
/*      */     //   #893	-> 6015
/*      */     //   #894	-> 6018
/*      */     //   #895	-> 6024
/*      */     //   #896	-> 6027
/*      */     //   #897	-> 6033
/*      */     //   #898	-> 6040
/*      */     //   #899	-> 6067
/*      */     //   #900	-> 6077
/*      */     //   #901	-> 6089
/*      */     //   #898	-> 6098
/*      */     //   #903	-> 6104
/*      */     //   #908	-> 6233
/*      */     //   #909	-> 6247
/*      */     //   #910	-> 6270
/*      */     //   #911	-> 6276
/*      */     //   #912	-> 6282
/*      */     //   #913	-> 6285
/*      */     //   #921	-> 6300
/*      */     //   #922	-> 6308
/*      */     //   #923	-> 6313
/*      */     //   #924	-> 6318
/*      */     //   #925	-> 6329
/*      */     //   #926	-> 6340
/*      */     //   #927	-> 6347
/*      */     //   #928	-> 6358
/*      */     //   #929	-> 6370
/*      */     //   #930	-> 6384
/*      */     //   #932	-> 6432
/*      */     //   #933	-> 6501
/*      */     //   #934	-> 6507
/*      */     //   #935	-> 6524
/*      */     //   #936	-> 6545
/*      */     //   #937	-> 6561
/*      */     //   #938	-> 6566
/*      */     //   #939	-> 6577
/*      */     //   #940	-> 6611
/*      */     //   #941	-> 6636
/*      */     //   #942	-> 6647
/*      */     //   #943	-> 6653
/*      */     //   #944	-> 6658
/*      */     //   #945	-> 6722
/*      */     //   #947	-> 6733
/*      */     //   #949	-> 6763
/*      */     //   #950	-> 6782
/*      */     //   #952	-> 6836
/*      */     //   #954	-> 6860
/*      */     //   #955	-> 6863
/*      */     //   #956	-> 6866
/*      */     //   #957	-> 6881
/*      */     //   #958	-> 6884
/*      */     //   #959	-> 6892
/*      */     //   #960	-> 6918
/*      */     //   #961	-> 6929
/*      */     //   #962	-> 6976
/*      */     //   #963	-> 7113
/*      */     //   #964	-> 7124
/*      */     //   #965	-> 7174
/*      */     //   #966	-> 7180
/*      */     //   #967	-> 7201
/*      */     //   #968	-> 7277
/*      */     //   #969	-> 7288
/*      */     //   #970	-> 7291
/*      */     //   #971	-> 7296
/*      */     //   #972	-> 7346
/*      */     //   #973	-> 7403
/*      */     //   #974	-> 7445
/*      */     //   #975	-> 7457
/*      */     //   #976	-> 7473
/*      */     //   #977	-> 7539
/*      */     //   #979	-> 7545
/*      */     //   #980	-> 7578
/*      */     //   #981	-> 7581
/*      */     //   #982	-> 7586
/*      */     //   #983	-> 7636
/*      */     //   #984	-> 7693
/*      */     //   #986	-> 7741
/*      */     //   #987	-> 7774
/*      */     //   #988	-> 7777
/*      */     //   #989	-> 7782
/*      */     //   #990	-> 7832
/*      */     //   #991	-> 7889
/*      */     //   #993	-> 7937
/*      */     //   #995	-> 7941
/*      */     //   #996	-> 7959
/*      */     //   #998	-> 7988
/*      */     //   #999	-> 8002
/*      */     //   #1000	-> 8045
/*      */     //   #998	-> 8091
/*      */     //   #1002	-> 8097
/*      */     //   #1003	-> 8101
/*      */     //   #1004	-> 8129
/*      */     //   #1007	-> 8157
/*      */     //   #1008	-> 8197
/*      */     //   #1010	-> 8237
/*      */     //   #1012	-> 8243
/*      */     //   #1013	-> 8251
/*      */     //   #1014	-> 8265
/*      */     //   #1015	-> 8281
/*      */     //   #1016	-> 8363
/*      */     //   #1029	-> 8403
/*      */     //   #1030	-> 8419
/*      */     //   #1032	-> 8478
/*      */     //   #1033	-> 8489
/*      */     //   #1034	-> 8492
/*      */     //   #1035	-> 8495
/*      */     //   #1036	-> 8498
/*      */     //   #1037	-> 8511
/*      */     //   #1038	-> 8523
/*      */     //   #1039	-> 8552
/*      */     //   #1040	-> 8570
/*      */     //   #1041	-> 8575
/*      */     //   #1042	-> 8582
/*      */     //   #1043	-> 8600
/*      */     //   #1044	-> 8674
/*      */     //   #1037	-> 8677
/*      */     //   #1052	-> 8683
/*      */     //   #1053	-> 8688
/*      */     //   #1054	-> 8693
/*      */     //   #1055	-> 8704
/*      */     //   #1057	-> 8740
/*      */     //   #1058	-> 8757
/*      */     //   #1059	-> 8762
/*      */     //   #1060	-> 8821
/*      */     //   #1061	-> 8828
/*      */     //   #1062	-> 8847
/*      */     //   #1065	-> 8899
/*      */     //   #1118	-> 8947
/*      */     //   #1119	-> 8957
/*      */     //   #1120	-> 8964
/*      */     // Local variable table:
/*      */     //   start	length	slot	name	descriptor
/*      */     //   361	166	15	n	Ljava/lang/String;
/*      */     //   384	143	16	s	Ljava/lang/String;
/*      */     //   406	121	17	a	Ljava/lang/String;
/*      */     //   469	58	18	d	Ljava/lang/String;
/*      */     //   551	166	15	n	Ljava/lang/String;
/*      */     //   574	143	16	s	Ljava/lang/String;
/*      */     //   596	121	17	a	Ljava/lang/String;
/*      */     //   659	58	18	d	Ljava/lang/String;
/*      */     //   1095	58	23	gen	Ljava/lang/String;
/*      */     //   725	452	15	fnst	Ljava/lang/String;
/*      */     //   736	441	16	fnstw	I
/*      */     //   840	337	17	fn	Ljava/lang/String;
/*      */     //   851	326	18	fnw	I
/*      */     //   856	321	19	fns	Ljava/lang/String;
/*      */     //   867	310	20	fnsw	I
/*      */     //   872	305	21	fnf	Ljava/lang/String;
/*      */     //   883	294	22	fnfw	I
/*      */     //   1266	11	20	fm2	[Ljava/lang/String;
/*      */     //   1277	3	19	fm	[Ljava/lang/String;
/*      */     //   1310	67	22	n2	Ljava/lang/String;
/*      */     //   1319	58	23	n3	[Ljava/lang/String;
/*      */     //   1295	88	21	f1	I
/*      */     //   1245	138	18	n	Ljava/lang/String;
/*      */     //   1289	94	19	fm	[Ljava/lang/String;
/*      */     //   1292	91	20	b	Z
/*      */     //   1228	161	17	pl	I
/*      */     //   1483	11	24	fm2	[Ljava/lang/String;
/*      */     //   1494	3	23	fm	[Ljava/lang/String;
/*      */     //   1664	32	29	hi2	I
/*      */     //   1649	321	26	n2	Ljava/lang/String;
/*      */     //   1658	312	27	n3	[Ljava/lang/String;
/*      */     //   1661	309	28	nh	Z
/*      */     //   1605	371	25	f1	I
/*      */     //   1462	514	22	n	Ljava/lang/String;
/*      */     //   1506	470	23	fm	[Ljava/lang/String;
/*      */     //   1527	449	24	sfp	I
/*      */     //   1445	537	21	pl	I
/*      */     //   2037	59	21	n	Ljava/lang/String;
/*      */     //   2108	66	21	p	Ljava/lang/String;
/*      */     //   2122	52	22	pw	I
/*      */     //   1209	971	15	h	Ljava/lang/String;
/*      */     //   1212	968	16	hi	I
/*      */     //   1419	761	17	ha	[Ljava/lang/String;
/*      */     //   1422	758	18	i	I
/*      */     //   1425	755	19	i2	I
/*      */     //   1429	751	20	s	Ljava/lang/String;
/*      */     //   2317	95	20	n	Ljava/lang/String;
/*      */     //   2305	107	19	e	Lnet/minecraft/entity/Entity;
/*      */     //   2236	182	18	i	I
/*      */     //   2440	59	18	n	Ljava/lang/String;
/*      */     //   2511	66	18	p	Ljava/lang/String;
/*      */     //   2525	52	19	pw	I
/*      */     //   2197	380	15	i2	I
/*      */     //   2200	377	16	gn	I
/*      */     //   2203	374	17	gp	I
/*      */     //   2675	70	16	s1	Ljava/lang/String;
/*      */     //   2701	44	17	s2	[Ljava/lang/String;
/*      */     //   2605	146	15	pl	I
/*      */     //   2839	11	29	fm2	[Ljava/lang/String;
/*      */     //   2850	3	28	fm	[Ljava/lang/String;
/*      */     //   2880	424	30	n2	Ljava/lang/String;
/*      */     //   2889	415	31	n3	[Ljava/lang/String;
/*      */     //   3121	183	32	b	Z
/*      */     //   2865	445	29	f1	I
/*      */     //   2818	492	27	n	Ljava/lang/String;
/*      */     //   2862	448	28	fm	[Ljava/lang/String;
/*      */     //   2801	515	26	pl	I
/*      */     //   3349	38	27	hi2	I
/*      */     //   3408	86	27	in	Ljava/lang/String;
/*      */     //   3422	72	28	inw	I
/*      */     //   3507	86	27	k	Ljava/lang/String;
/*      */     //   3521	72	28	kw	I
/*      */     //   3705	86	29	k	Ljava/lang/String;
/*      */     //   3719	72	30	kw	I
/*      */     //   3606	185	27	s	Ljava/lang/String;
/*      */     //   3620	171	28	sw	I
/*      */     //   3804	86	27	k	Ljava/lang/String;
/*      */     //   3818	72	28	kw	I
/*      */     //   3903	86	27	l	Ljava/lang/String;
/*      */     //   3917	72	28	lw	I
/*      */     //   4000	86	27	l	Ljava/lang/String;
/*      */     //   4014	72	28	lw	I
/*      */     //   4114	59	27	n	Ljava/lang/String;
/*      */     //   4185	66	27	p	Ljava/lang/String;
/*      */     //   4199	52	28	pw	I
/*      */     //   2754	1502	15	i	I
/*      */     //   2757	1499	16	i2	I
/*      */     //   2760	1496	17	head	Z
/*      */     //   2763	1493	18	main	Z
/*      */     //   2766	1490	19	parent	Z
/*      */     //   2769	1487	20	havechild	Z
/*      */     //   2772	1484	21	single	Z
/*      */     //   2775	1481	22	anyone	Z
/*      */     //   2778	1478	23	infam	Z
/*      */     //   2782	1474	24	h	Ljava/lang/String;
/*      */     //   2785	1471	25	hi	I
/*      */     //   3346	910	26	ha	[Ljava/lang/String;
/*      */     //   4267	66	15	s	Ljava/lang/String;
/*      */     //   4281	52	16	sw	I
/*      */     //   90	4243	10	xSize	I
/*      */     //   95	4238	11	ySize	I
/*      */     //   106	4227	12	guiLeft	I
/*      */     //   117	4216	13	guiTop	I
/*      */     //   135	4198	14	guiLocation	Lnet/minecraft/util/ResourceLocation;
/*      */     //   4615	256	16	i	I
/*      */     //   4701	170	17	s	Ljava/lang/String;
/*      */     //   4599	272	15	pr	[Ljava/lang/String;
/*      */     //   5187	68	21	gen	Ljava/lang/String;
/*      */     //   5201	54	22	gw	I
/*      */     //   4907	375	15	n	Ljava/lang/String;
/*      */     //   4930	352	16	s	Ljava/lang/String;
/*      */     //   4969	313	17	a	Ljava/lang/String;
/*      */     //   5038	244	18	d	Ljava/lang/String;
/*      */     //   5107	175	19	fnst	Ljava/lang/String;
/*      */     //   5118	164	20	fnstw	I
/*      */     //   5379	18	18	s	[Ljava/lang/String;
/*      */     //   5338	65	17	pl	I
/*      */     //   5430	83	17	p	Ljava/lang/String;
/*      */     //   5444	69	18	pw	I
/*      */     //   5312	201	15	G	I
/*      */     //   5315	198	16	R	I
/*      */     //   5633	102	25	m	[Ljava/lang/String;
/*      */     //   5623	112	24	n	Ljava/lang/String;
/*      */     //   5787	107	26	c1	[Ljava/lang/String;
/*      */     //   5778	116	25	n	Ljava/lang/String;
/*      */     //   6077	21	30	m	[Ljava/lang/String;
/*      */     //   6067	31	29	n	Ljava/lang/String;
/*      */     //   6027	206	25	A	F
/*      */     //   6270	30	25	ch	Ljava/lang/String;
/*      */     //   6276	24	26	sa	[Ljava/lang/String;
/*      */     //   4353	1947	10	xSize	I
/*      */     //   4358	1942	11	ySize	I
/*      */     //   4369	1931	12	guiLeft	I
/*      */     //   4380	1920	13	guiTop	I
/*      */     //   4398	1902	14	guiLocation	Lnet/minecraft/util/ResourceLocation;
/*      */     //   5516	784	15	S	I
/*      */     //   5519	781	16	Stat	I
/*      */     //   5523	777	17	par	Ljava/lang/String;
/*      */     //   5527	773	18	chi	Ljava/lang/String;
/*      */     //   5531	769	19	mer	Ljava/lang/String;
/*      */     //   5535	765	20	id	Ljava/lang/String;
/*      */     //   5752	548	21	c	[Ljava/lang/String;
/*      */     //   5930	370	22	targ	Z
/*      */     //   5956	344	23	nam	Ljava/lang/String;
/*      */     //   6018	282	24	i	I
/*      */     //   6768	68	21	gen	Ljava/lang/String;
/*      */     //   6782	54	22	gw	I
/*      */     //   6566	297	16	fnst	Ljava/lang/String;
/*      */     //   6577	286	17	fnstw	I
/*      */     //   6636	227	18	s1	Ljava/lang/String;
/*      */     //   6647	216	19	s1w	I
/*      */     //   6658	205	20	a	Ljava/lang/String;
/*      */     //   7962	26	28	i1	I
/*      */     //   7991	106	28	i1	I
/*      */     //   6884	1594	16	i	I
/*      */     //   6892	1586	17	npc	LJinRyuu/FamilyC/EntityNPC;
/*      */     //   6918	1560	18	s1	Ljava/lang/String;
/*      */     //   6929	1549	19	s1w	I
/*      */     //   7201	1277	20	trgtnm	Ljava/lang/String;
/*      */     //   7288	1190	21	s2w	I
/*      */     //   7291	1187	22	CanFollow	Z
/*      */     //   7581	897	23	CanAggro	Z
/*      */     //   7777	701	24	CanDrop	Z
/*      */     //   7941	537	25	nr	I
/*      */     //   7947	531	26	attrbts	[I
/*      */     //   7959	519	27	attr	[Ljava/lang/String;
/*      */     //   8129	349	28	dmgmin	I
/*      */     //   8157	321	29	dmgmax	I
/*      */     //   8251	227	30	Stamina	I
/*      */     //   8265	213	31	add	F
/*      */     //   8281	197	32	rate	I
/*      */     //   8582	95	21	n	Ljava/lang/String;
/*      */     //   8570	107	20	e	Lnet/minecraft/entity/Entity;
/*      */     //   8514	169	19	i	I
/*      */     //   8693	47	19	s1	Ljava/lang/String;
/*      */     //   8704	36	20	s1w	I
/*      */     //   8762	59	19	n	Ljava/lang/String;
/*      */     //   8833	66	19	p	Ljava/lang/String;
/*      */     //   8847	52	20	pw	I
/*      */     //   8492	407	16	i2	I
/*      */     //   8495	404	17	gn	I
/*      */     //   8498	401	18	gp	I
/*      */     //   6313	2634	10	xSize	I
/*      */     //   6318	2629	11	ySize	I
/*      */     //   6329	2618	12	guiLeft	I
/*      */     //   6340	2607	13	guiTop	I
/*      */     //   6358	2589	14	guiLocation	Lnet/minecraft/util/ResourceLocation;
/*      */     //   6501	2446	15	parents	Z
/*      */     //   0	8965	0	this	LJinRyuu/FamilyC/FamilyCCharGui;
/*      */     //   0	8965	1	x	I
/*      */     //   0	8965	2	y	I
/*      */     //   0	8965	3	f	F
/*      */     //   27	8938	4	var5	Lnet/minecraft/client/gui/ScaledResolution;
/*      */     //   34	8931	5	var6	I
/*      */     //   41	8924	6	var7	I
/*      */     //   50	8915	7	var8	Lnet/minecraft/client/gui/FontRenderer;
/*      */     //   55	8910	8	wish	Ljava/lang/String;
/*      */     //   67	8898	9	txtng	Z
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean func_73868_f() {
/* 1124 */     return false;
/*      */   }
/*      */   
/*      */   public void current(String var35, int posx, int posy, FontRenderer var8, int var6, int var7) {
/* 1128 */     int wid = var8.func_78256_a(var35) / 2;
/* 1129 */     int posX = var6 / 2 + posx - wid;
/* 1130 */     int posY = var7 / 2 + posy;
/* 1131 */     var8.func_78276_b(var35, posX + 1, posY, 0);
/* 1132 */     var8.func_78276_b(var35, posX - 1, posY, 0);
/* 1133 */     var8.func_78276_b(var35, posX, posY + 1, 0);
/* 1134 */     var8.func_78276_b(var35, posX, posY - 1, 0);
/* 1135 */     var8.func_78276_b(var35, posX, posY, 8388564);
/*      */   }
/*      */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JFamilyC-v1.2.18.jar!\JinRyuu\FamilyC\FamilyCCharGui.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */