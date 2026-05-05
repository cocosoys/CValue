/*     */ package JinRyuu.JRMCore;
/*     */ 
/*     */ import JinRyuu.JRMCore.i.ExtendedPlayer;
/*     */ import JinRyuu.JRMCore.p.DBC.DBCPacketHandlerClient;
/*     */ import JinRyuu.JRMCore.p.JRMCorePTri;
/*     */ import JinRyuu.JRMCore.p.PD;
/*     */ import com.google.common.collect.Maps;
/*     */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.net.URL;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.Callable;
/*     */ import java.util.regex.Pattern;
/*     */ import net.minecraft.client.entity.EntityClientPlayerMP;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.texture.DynamicTexture;
/*     */ import net.minecraft.client.renderer.texture.ITextureObject;
/*     */ import net.minecraft.client.renderer.texture.TextureUtil;
/*     */ import net.minecraft.crash.CrashReport;
/*     */ import net.minecraft.crash.CrashReportCategory;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.ReportedException;
/*     */ import org.lwjgl.input.Keyboard;
/*     */ import org.lwjgl.input.Mouse;
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
/*     */ public class JRMCoreHC
/*     */ {
/*     */   public static boolean t1s = false;
/*     */   public static boolean t2s = false;
/*     */   public static boolean t5s = false;
/*  48 */   public static long BPC_ME = 1L;
/*     */   
/*  50 */   public static long BPC_ME2 = 1L;
/*  51 */   public static float smoothReleaseLevel = 0.0F;
/*     */ 
/*     */ 
/*     */   
/*     */   public static void bt(String p_110577_1_) {
/*  56 */     Object object = mto.get(p_110577_1_);
/*     */     
/*  58 */     if (object == null) {
/*     */       
/*  60 */       object = new JRMCTexture(p_110577_1_);
/*  61 */       lt(p_110577_1_, (ITextureObject)object);
/*     */     } 
/*     */     
/*  64 */     bt(((ITextureObject)object).func_110552_b());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static void bt(int p_94277_0_) {
/*  70 */     GL11.glBindTexture(3553, p_94277_0_);
/*     */   }
/*     */ 
/*     */   
/*  74 */   private static Map mto = Maps.newHashMap();
/*     */ 
/*     */   
/*     */   public static boolean lt(String p_110579_1_, final ITextureObject p_110579_2_) {
/*     */     DynamicTexture dynamicTexture;
/*  79 */     boolean flag = true;
/*  80 */     ITextureObject p_110579_2_2 = p_110579_2_;
/*     */ 
/*     */     
/*     */     try {
/*  84 */       p_110579_2_.func_110551_a(JRMCoreClient.mc.func_110442_L());
/*     */     }
/*  86 */     catch (IOException ioexception) {
/*     */       
/*  88 */       mod_JRMCore.logger.error("Failed to load texture: " + p_110579_1_);
/*  89 */       dynamicTexture = TextureUtil.field_111001_a;
/*  90 */       mto.put(p_110579_1_, dynamicTexture);
/*  91 */       flag = false;
/*     */     }
/*  93 */     catch (Throwable throwable) {
/*     */       
/*  95 */       CrashReport crashreport = CrashReport.func_85055_a(throwable, "Registering texture");
/*  96 */       CrashReportCategory crashreportcategory = crashreport.func_85058_a("Resource location being registered");
/*  97 */       crashreportcategory.func_71507_a("Resource location", p_110579_1_);
/*  98 */       crashreportcategory.func_71500_a("Texture object class", new Callable()
/*     */           {
/*     */             private static final String __OBFID = "CL_00001065";
/*     */             
/*     */             public String call() {
/* 103 */               return p_110579_2_.getClass().getName();
/*     */             }
/*     */           });
/* 106 */       throw new ReportedException(crashreport);
/*     */     } 
/*     */     
/* 109 */     mto.put(p_110579_1_, dynamicTexture);
/* 110 */     return flag;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void dtm(float x, float y, int u, int v, float width, float height, float z) {
/* 118 */     float f = 0.00390625F;
/* 119 */     float f1 = 0.00390625F;
/* 120 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 121 */     tessellator.func_78382_b();
/* 122 */     tessellator.func_78374_a(x, (y + 0.0F), z, ((u + 0) * f), ((v + 0) * f1));
/* 123 */     tessellator.func_78374_a(x, (y + height), z, ((u + 0) * f), ((v + height) * f1));
/* 124 */     tessellator.func_78374_a((x + width), (y + height), z, ((u + width) * f), ((v + height) * f1));
/* 125 */     tessellator.func_78374_a((x + width), (y + 0.0F), z, ((u + width) * f), ((v + 0) * f1));
/* 126 */     tessellator.func_78381_a();
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
/*     */   public static void dtr(float x, float y, int u, int v, float width, float height, float z) {
/* 142 */     float f = 1.0F / width;
/* 143 */     float f1 = 1.0F / height;
/* 144 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 145 */     tessellator.func_78382_b();
/* 146 */     tessellator.func_78374_a(x, (y + 0.0F), z, ((u + 0) * f), ((v + 0) * f1));
/* 147 */     tessellator.func_78374_a(x, (y + height), z, ((u + 0) * f), ((v + height) * f1));
/* 148 */     tessellator.func_78374_a((x + width), (y + height), z, ((u + width) * f), ((v + height) * f1));
/* 149 */     tessellator.func_78374_a((x + width), (y + 0.0F), z, ((u + width) * f), ((v + 0) * f1));
/* 150 */     tessellator.func_78381_a();
/*     */   }
/*     */   
/* 153 */   public static Pattern paturl = Pattern.compile("(?:^|[\\W])((ht|f)tp(s?):\\/\\/|www\\.)(([\\w\\-]+\\.){1,}?([\\w\\-.~]+\\/?)*[\\p{Alnum}.,%_=?&#\\-+()\\[\\]\\*$~@!:/{};']*)", 42);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 159 */   static int atv = 16;
/* 160 */   static int attackTime = atv;
/*     */   public static void Blocking() {
/* 162 */     if (JRMCoreClient.mc.field_71474_y.field_74312_F.func_151470_d()) {
/* 163 */       attackTime = 0;
/* 164 */     } else if (attackTime < atv) {
/* 165 */       attackTime++;
/*     */     } 
/* 167 */     EntityClientPlayerMP entityClientPlayerMP = JRMCoreClient.mc.field_71439_g;
/* 168 */     ItemStack var11 = ((EntityPlayer)entityClientPlayerMP).field_71071_by.func_70448_g();
/* 169 */     ExtendedPlayer props = ExtendedPlayer.get((EntityPlayer)entityClientPlayerMP);
/*     */     
/* 171 */     int mode = JRMCoreH.DBC() ? DBCPacketHandlerClient.getDBCPlayerBlockMode() : 1;
/* 172 */     boolean b = ((!JRMCoreKeyHandler.Fn.func_151470_d() && JRMCoreClient.mc.field_71474_y.field_74313_G.func_151470_d()) || mode == 2);
/* 173 */     if (b && props.getBlocking() != mode && attackTime >= atv && var11 == null) {
/* 174 */       triForce(2, mode, 0);
/* 175 */       props.setBlocking(mode);
/*     */     }
/* 177 */     else if ((!b || attackTime < atv) && props.getBlocking() != 0) {
/* 178 */       triForce(2, 0, 0);
/* 179 */       props.setBlocking(0);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void triForce(int i, int j, int k) {
/* 184 */     PD.sendToServer((IMessage)new JRMCorePTri((byte)i, (byte)j, (byte)k));
/*     */   }
/*     */   
/*     */   public static String getKey(int i) {
/* 188 */     String k = "";
/* 189 */     if (i >= 0) {
/* 190 */       k = Keyboard.getKeyName(i);
/* 191 */       if (k != null) return k;
/*     */     
/* 193 */     } else if (i >= -100) {
/* 194 */       k = Mouse.getButtonName(100 + i);
/* 195 */       if (k != null) {
/* 196 */         return "BUTTON " + (Integer.parseInt(k.replaceFirst("BUTTON", "")) + 1);
/*     */       }
/*     */     } 
/* 199 */     return "keycode" + i;
/*     */   }
/* 201 */   public static HashMap<String, String> kbx97f = new HashMap<String, String>();
/*     */   
/*     */   public void ay2MmU(String c) {
/* 204 */     Thread one = new Thread() {
/*     */         public void run() {
/* 206 */           String rvf = "http://updateinfo.jingames.net/getLatestPost.php";
/* 207 */           String line = null;
/*     */           
/* 209 */           StringBuilder content = new StringBuilder();
/* 210 */           int empty = 0;
/* 211 */           int count = 0;
/*     */           try {
/* 213 */             URL url = new URL("http://updateinfo.jingames.net/getLatestPost.php");
/* 214 */             InputStreamReader isr = new InputStreamReader(url.openStream(), StandardCharsets.UTF_8);
/* 215 */             BufferedReader reader = new BufferedReader(isr);
/* 216 */             while ((line = reader.readLine()) != null) {
/*     */               
/* 218 */               if (line.length() > 3) {
/* 219 */                 content.append(line.replaceAll(" ", " ") + "/n");
/* 220 */                 count++;
/* 221 */                 empty = 0;
/*     */               } else {
/* 223 */                 if (empty < 1) {
/* 224 */                   content.append(line.replaceAll(" ", " ") + "/n");
/* 225 */                   count++;
/*     */                 } 
/* 227 */                 empty++;
/*     */               } 
/* 229 */               if (count > 18) {
/*     */                 break;
/*     */               }
/*     */             } 
/*     */ 
/*     */ 
/*     */             
/* 236 */             Version.news = content.toString();
/* 237 */             reader.close();
/* 238 */             isr.close();
/* 239 */           } catch (Exception e) {
/* 240 */             e.printStackTrace(System.err);
/*     */           } 
/* 242 */           interrupt();
/*     */         }
/*     */       };
/*     */     
/* 246 */     one.start();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void ri(Tessellator p_78439_0_, float p_78439_1_, float p_78439_2_, float p_78439_3_, float p_78439_4_, int p_78439_5_, int p_78439_6_, float p_78439_7_) {
/* 256 */     p_78439_0_.func_78382_b();
/* 257 */     p_78439_0_.func_78375_b(0.0F, 0.0F, 1.0F);
/* 258 */     p_78439_0_.func_78374_a(0.0D, 0.0D, 0.0D, p_78439_1_, p_78439_4_);
/* 259 */     p_78439_0_.func_78374_a(1.0D, 0.0D, 0.0D, p_78439_3_, p_78439_4_);
/* 260 */     p_78439_0_.func_78374_a(1.0D, 1.0D, 0.0D, p_78439_3_, p_78439_2_);
/* 261 */     p_78439_0_.func_78374_a(0.0D, 1.0D, 0.0D, p_78439_1_, p_78439_2_);
/* 262 */     p_78439_0_.func_78381_a();
/* 263 */     p_78439_0_.func_78382_b();
/* 264 */     p_78439_0_.func_78375_b(0.0F, 0.0F, -1.0F);
/* 265 */     p_78439_0_.func_78374_a(0.0D, 1.0D, (0.0F - p_78439_7_), p_78439_1_, p_78439_2_);
/* 266 */     p_78439_0_.func_78374_a(1.0D, 1.0D, (0.0F - p_78439_7_), p_78439_3_, p_78439_2_);
/* 267 */     p_78439_0_.func_78374_a(1.0D, 0.0D, (0.0F - p_78439_7_), p_78439_3_, p_78439_4_);
/* 268 */     p_78439_0_.func_78374_a(0.0D, 0.0D, (0.0F - p_78439_7_), p_78439_1_, p_78439_4_);
/* 269 */     p_78439_0_.func_78381_a();
/* 270 */     float f5 = 0.5F * (p_78439_1_ - p_78439_3_) / p_78439_5_;
/* 271 */     float f6 = 0.5F * (p_78439_4_ - p_78439_2_) / p_78439_6_;
/* 272 */     p_78439_0_.func_78382_b();
/* 273 */     p_78439_0_.func_78375_b(-1.0F, 0.0F, 0.0F);
/*     */ 
/*     */     
/*     */     int k;
/*     */     
/* 278 */     for (k = 0; k < p_78439_5_; k++) {
/*     */       
/* 280 */       float f7 = k / p_78439_5_;
/* 281 */       float f8 = p_78439_1_ + (p_78439_3_ - p_78439_1_) * f7 - f5;
/* 282 */       p_78439_0_.func_78374_a(f7, 0.0D, (0.0F - p_78439_7_), f8, p_78439_4_);
/* 283 */       p_78439_0_.func_78374_a(f7, 0.0D, 0.0D, f8, p_78439_4_);
/* 284 */       p_78439_0_.func_78374_a(f7, 1.0D, 0.0D, f8, p_78439_2_);
/* 285 */       p_78439_0_.func_78374_a(f7, 1.0D, (0.0F - p_78439_7_), f8, p_78439_2_);
/*     */     } 
/*     */     
/* 288 */     p_78439_0_.func_78381_a();
/* 289 */     p_78439_0_.func_78382_b();
/* 290 */     p_78439_0_.func_78375_b(1.0F, 0.0F, 0.0F);
/*     */ 
/*     */     
/* 293 */     for (k = 0; k < p_78439_5_; k++) {
/*     */       
/* 295 */       float f7 = k / p_78439_5_;
/* 296 */       float f8 = p_78439_1_ + (p_78439_3_ - p_78439_1_) * f7 - f5;
/* 297 */       float f9 = f7 + 1.0F / p_78439_5_;
/* 298 */       p_78439_0_.func_78374_a(f9, 1.0D, (0.0F - p_78439_7_), f8, p_78439_2_);
/* 299 */       p_78439_0_.func_78374_a(f9, 1.0D, 0.0D, f8, p_78439_2_);
/* 300 */       p_78439_0_.func_78374_a(f9, 0.0D, 0.0D, f8, p_78439_4_);
/* 301 */       p_78439_0_.func_78374_a(f9, 0.0D, (0.0F - p_78439_7_), f8, p_78439_4_);
/*     */     } 
/*     */     
/* 304 */     p_78439_0_.func_78381_a();
/* 305 */     p_78439_0_.func_78382_b();
/* 306 */     p_78439_0_.func_78375_b(0.0F, 1.0F, 0.0F);
/*     */     
/* 308 */     for (k = 0; k < p_78439_6_; k++) {
/*     */       
/* 310 */       float f7 = k / p_78439_6_;
/* 311 */       float f8 = p_78439_4_ + (p_78439_2_ - p_78439_4_) * f7 - f6;
/* 312 */       float f9 = f7 + 1.0F / p_78439_6_;
/* 313 */       p_78439_0_.func_78374_a(0.0D, f9, 0.0D, p_78439_1_, f8);
/* 314 */       p_78439_0_.func_78374_a(1.0D, f9, 0.0D, p_78439_3_, f8);
/* 315 */       p_78439_0_.func_78374_a(1.0D, f9, (0.0F - p_78439_7_), p_78439_3_, f8);
/* 316 */       p_78439_0_.func_78374_a(0.0D, f9, (0.0F - p_78439_7_), p_78439_1_, f8);
/*     */     } 
/*     */     
/* 319 */     p_78439_0_.func_78381_a();
/* 320 */     p_78439_0_.func_78382_b();
/* 321 */     p_78439_0_.func_78375_b(0.0F, -1.0F, 0.0F);
/*     */     
/* 323 */     for (k = 0; k < p_78439_6_; k++) {
/*     */       
/* 325 */       float f7 = k / p_78439_6_;
/* 326 */       float f8 = p_78439_4_ + (p_78439_2_ - p_78439_4_) * f7 - f6;
/* 327 */       p_78439_0_.func_78374_a(1.0D, f7, 0.0D, p_78439_3_, f8);
/* 328 */       p_78439_0_.func_78374_a(0.0D, f7, 0.0D, p_78439_1_, f8);
/* 329 */       p_78439_0_.func_78374_a(0.0D, f7, (0.0F - p_78439_7_), p_78439_1_, f8);
/* 330 */       p_78439_0_.func_78374_a(1.0D, f7, (0.0F - p_78439_7_), p_78439_3_, f8);
/*     */     } 
/*     */     
/* 333 */     p_78439_0_.func_78381_a();
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCoreHC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */