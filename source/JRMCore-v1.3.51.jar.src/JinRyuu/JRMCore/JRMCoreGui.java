/*     */ package JinRyuu.JRMCore;
/*     */ 
/*     */ import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.InputStreamReader;
/*     */ import java.net.URL;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.client.settings.KeyBinding;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.input.Keyboard;
/*     */ import org.lwjgl.input.Mouse;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JRMCoreGui
/*     */   extends Gui
/*     */ {
/*  22 */   protected FontRenderer fontRenderer = JRMCoreClient.mc.field_71466_p;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void checkVersion() {
/*  48 */     String rvf = "http://updateinfo.ryugujo.hu/info.txt";
/*  49 */     String line = null;
/*     */     try {
/*  51 */       URL url = new URL("http://updateinfo.ryugujo.hu/info.txt");
/*  52 */       InputStreamReader isr = new InputStreamReader(url.openStream());
/*  53 */       BufferedReader reader = new BufferedReader(isr);
/*  54 */       if ((line = reader.readLine()) != null) {
/*     */         
/*  56 */         Version.ammv = line;
/*     */         
/*  58 */         reader.close();
/*  59 */         isr.close();
/*     */         return;
/*     */       } 
/*  62 */       reader.close();
/*  63 */       isr.close();
/*  64 */     } catch (Exception e) {
/*  65 */       e.printStackTrace(System.err);
/*     */     } 
/*     */   }
/*     */   public void checkText() {
/*  69 */     Thread one = new Thread() {
/*     */         public void run() {
/*  71 */           String rvf = "http://updateinfo.jingames.net/getLatestPost.php";
/*  72 */           String line = null;
/*     */           
/*  74 */           StringBuilder content = new StringBuilder();
/*  75 */           int empty = 0;
/*  76 */           int count = 0;
/*     */           try {
/*  78 */             URL url = new URL("http://updateinfo.jingames.net/getLatestPost.php");
/*  79 */             InputStreamReader isr = new InputStreamReader(url.openStream(), StandardCharsets.UTF_8);
/*  80 */             BufferedReader reader = new BufferedReader(isr);
/*  81 */             while ((line = reader.readLine()) != null) {
/*     */               
/*  83 */               if (line.length() > 3) {
/*  84 */                 content.append(line.replaceAll(" ", " ") + "/n");
/*  85 */                 count++;
/*  86 */                 empty = 0;
/*     */               } else {
/*  88 */                 if (empty < 1) {
/*  89 */                   content.append(line.replaceAll(" ", " ") + "/n");
/*  90 */                   count++;
/*     */                 } 
/*  92 */                 empty++;
/*     */               } 
/*  94 */               if (count > 18) {
/*     */                 break;
/*     */               }
/*     */             } 
/*     */ 
/*     */ 
/*     */             
/* 101 */             Version.news = content.toString();
/* 102 */             reader.close();
/* 103 */             isr.close();
/* 104 */           } catch (Exception e) {
/* 105 */             e.printStackTrace(System.err);
/*     */           } 
/* 107 */           interrupt();
/*     */         }
/*     */       };
/*     */     
/* 111 */     one.start();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderActionMenu() {
/* 117 */     JRMCoreClient.mc.field_71417_B.func_74374_c();
/* 118 */     ScaledResolution var5 = new ScaledResolution(JRMCoreClient.mc, JRMCoreClient.mc.field_71443_c, JRMCoreClient.mc.field_71440_d);
/*     */     
/* 120 */     int var6 = var5.func_78326_a();
/* 121 */     int var7 = var5.func_78328_b();
/* 122 */     float posX = Mouse.getX() * 1.0F / JRMCoreClient.mc.field_71443_c * 1.0F;
/* 123 */     float posY = Mouse.getY() * 1.0F / JRMCoreClient.mc.field_71440_d * 1.0F;
/* 124 */     int mouseX = (int)(var6 * posX);
/* 125 */     int mouseY = var7 - (int)(var7 * posY);
/*     */ 
/*     */     
/* 128 */     FontRenderer var8 = JRMCoreClient.mc.field_71466_p;
/* 129 */     JRMCoreClient.mc.field_71460_t.func_78478_c();
/* 130 */     int var51 = var6 / 2;
/* 131 */     int var61 = var7 / 2;
/* 132 */     short var21 = 41;
/* 133 */     int height = 41;
/*     */     
/* 135 */     this.field_73735_i = -90.0F;
/* 136 */     ResourceLocation tx2 = new ResourceLocation("jinryuumodscore:allw.png");
/* 137 */     JRMCoreClient.mc.field_71446_o.func_110577_a(tx2);
/* 138 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 146 */     JRMCoreH.txt("Hover over and release " + Keyboard.getKeyName(JRMCoreKeyHandler.actionMenu.func_151463_i()), JRMCoreH.cldgy, 0, true, var51 - 50, var61 - 110, 180);
/* 147 */     boolean doAction = false;
/* 148 */     for (int i = 0; i < 3; i++) {
/* 149 */       for (int j = 0; j < 3; j++) {
/* 150 */         String var34 = "";
/* 151 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 152 */         int X = var51 - 135 + i * 90;
/* 153 */         int Y = var61 - 90 + j * 60;
/* 154 */         int id = i + j * 3;
/* 155 */         id += JRMCoreCliTicH.actionNPA * 9;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 162 */         boolean h = false;
/* 163 */         if (JRMCoreA.actions.get(Integer.valueOf(id)) != null) {
/* 164 */           h = hovered(mouseX, mouseY, X, Y, 90, 60);
/* 165 */           if (h) {
/* 166 */             GL11.glPushMatrix();
/* 167 */             GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.75F);
/* 168 */             GL11.glDisable(3553);
/* 169 */             JRMCoreHC.dtm(X, Y, 0, 0, 89.0F, 59.0F, -90.0F);
/* 170 */             GL11.glEnable(3553);
/* 171 */             GL11.glPopMatrix();
/*     */             
/* 173 */             JRMCoreCliTicH.actionSelectID = id;
/*     */ 
/*     */             
/* 176 */             String brd = "";
/*     */             
/* 178 */             if (JRMCoreH.Pwrtyp == 1) {
/* 179 */               brd = JRMCoreHDBC.action(((Integer)JRMCoreA.actions.get(Integer.valueOf(id))).intValue(), false, true);
/* 180 */               var34 = JRMCoreHDBC.action(((Integer)JRMCoreA.actions.get(Integer.valueOf(id))).intValue(), false, false);
/*     */             } 
/* 182 */             if (JRMCoreH.Pwrtyp == 2) {
/* 183 */               brd = JRMCoreHNC.action(((Integer)JRMCoreA.actions.get(Integer.valueOf(id))).intValue(), false, true);
/* 184 */               var34 = JRMCoreHNC.action(((Integer)JRMCoreA.actions.get(Integer.valueOf(id))).intValue(), false, false);
/*     */             } 
/*     */ 
/*     */ 
/*     */             
/* 189 */             String clr = JGConfigClientSettings.CLIENT_GR13 ? JRMCoreH.clgy : JRMCoreH.clgd;
/*     */             
/* 191 */             JRMCoreH.txt(brd, JRMCoreH.clb, 0, true, X + 5 + 1, Y + 5, 80);
/* 192 */             JRMCoreH.txt(brd, JRMCoreH.clb, 0, true, X + 5 - 1, Y + 5, 80);
/* 193 */             JRMCoreH.txt(brd, JRMCoreH.clb, 0, true, X + 5, Y + 5 + 1, 80);
/* 194 */             JRMCoreH.txt(brd, JRMCoreH.clb, 0, true, X + 5, Y + 5 - 1, 80);
/*     */ 
/*     */             
/* 197 */             int l = JRMCoreH.txt(var34, clr, 0, true, X + 5, Y + 5, 80);
/*     */             
/* 199 */             doAction = true;
/*     */           
/*     */           }
/* 202 */           else if (id % 9 != 4) {
/* 203 */             GL11.glPushMatrix();
/* 204 */             GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.5F);
/* 205 */             GL11.glDisable(3553);
/* 206 */             JRMCoreHC.dtm(X, Y, 0, 0, 89.0F, 59.0F, -90.0F);
/* 207 */             GL11.glEnable(3553);
/* 208 */             GL11.glPopMatrix();
/*     */ 
/*     */             
/* 211 */             String brd = "";
/*     */             
/* 213 */             if (JRMCoreH.Pwrtyp == 1) {
/* 214 */               brd = JRMCoreHDBC.action(((Integer)JRMCoreA.actions.get(Integer.valueOf(id))).intValue(), false, true);
/* 215 */               var34 = JRMCoreHDBC.action(((Integer)JRMCoreA.actions.get(Integer.valueOf(id))).intValue(), false, false);
/*     */             } 
/* 217 */             if (JRMCoreH.Pwrtyp == 2) {
/* 218 */               brd = JRMCoreHNC.action(((Integer)JRMCoreA.actions.get(Integer.valueOf(id))).intValue(), false, true);
/* 219 */               var34 = JRMCoreHNC.action(((Integer)JRMCoreA.actions.get(Integer.valueOf(id))).intValue(), false, false);
/*     */             } 
/*     */ 
/*     */             
/* 223 */             JRMCoreH.txt(brd, JRMCoreH.clb, 0, true, X + 5 + 1, Y + 5, 80);
/* 224 */             JRMCoreH.txt(brd, JRMCoreH.clb, 0, true, X + 5 - 1, Y + 5, 80);
/* 225 */             JRMCoreH.txt(brd, JRMCoreH.clb, 0, true, X + 5, Y + 5 + 1, 80);
/* 226 */             JRMCoreH.txt(brd, JRMCoreH.clb, 0, true, X + 5, Y + 5 - 1, 80);
/*     */             
/* 228 */             int k = JRMCoreH.txt(var34, JRMCoreH.clw, 0, true, X + 5, Y + 5, 80);
/*     */           
/*     */           }
/*     */         
/*     */         }
/* 233 */         else if (id % 9 != 4) {
/*     */           
/* 235 */           GL11.glPushMatrix();
/* 236 */           GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.25F);
/* 237 */           GL11.glDisable(3553);
/* 238 */           JRMCoreHC.dtm(X, Y, 0, 0, 89.0F, 59.0F, -90.0F);
/* 239 */           GL11.glEnable(3553);
/* 240 */           GL11.glPopMatrix();
/*     */ 
/*     */         
/*     */         }
/* 244 */         else if (id % 9 == 4) {
/* 245 */           h = hovered(mouseX, mouseY, X, Y, 90, 60);
/* 246 */           GL11.glPushMatrix();
/* 247 */           GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.5F + (h ? 0.25F : 0.0F));
/* 248 */           GL11.glDisable(3553);
/* 249 */           JRMCoreHC.dtm((X + 22), (Y + 15), 0, 0, 45.0F, 30.0F, -90.0F);
/* 250 */           GL11.glEnable(3553);
/* 251 */           GL11.glPopMatrix();
/* 252 */           var34 = "MORE";
/* 253 */           int l = JRMCoreH.txt(var34, h ? JRMCoreH.clgy : JRMCoreH.clb, 0, true, X + 5 + 22, Y + 5 + 15, 80);
/*     */ 
/*     */           
/* 256 */           if (h) {
/* 257 */             JRMCoreCliTicH.actionSelectID = id;
/* 258 */             doAction = true;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 263 */     if (!JRMCoreClient.mc.field_71474_y.field_74312_F.func_151470_d())
/* 264 */       JRMCoreCliTicH.actionNBO = false; 
/* 265 */     if (JRMCoreClient.mc.field_71474_y.field_74312_F.func_151470_d() && JRMCoreCliTicH.actionSelectID % 9 != 4) {
/* 266 */       KeyBinding.func_74510_a(JRMCoreKeyHandler.actionMenu.func_151463_i(), false);
/*     */     }
/* 268 */     if (!doAction) {
/* 269 */       JRMCoreCliTicH.actionSelectID = -1;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hovered(int mX, int mY, int px, int py, int w, int h) {
/* 276 */     return (mX > px && mX < px + w && mY > py && mY < py + h);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCoreGui.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */