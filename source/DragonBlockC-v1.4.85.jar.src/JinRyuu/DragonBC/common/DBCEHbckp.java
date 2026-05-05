/*     */ package JinRyuu.DragonBC.common;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreClient;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.mod_JRMCore;
/*     */ import com.jin_ryuu.SwordArtC.Main;
/*     */ import com.jin_ryuu.SwordArtC.proxy.Client;
/*     */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.entity.RenderManager;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraftforge.client.event.RenderLivingEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingDropsEvent;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DBCEHbckp
/*     */ {
/*     */   public long bpc(Entity e) {
/*  31 */     if (e instanceof EntityCreature) {
/*  32 */       int atr = (int)(((EntityCreature)e).func_110138_aP() / JRMCoreH.statInc(1, 2, 1, 0, 0, 0.0F) * 6.0F);
/*  33 */       long res = 1L;
/*  34 */       for (int t = 0; t <= atr; t++) {
/*  35 */         res += JRMCoreH.attrCst(t);
/*     */       }
/*  37 */       return res;
/*  38 */     }  if (e instanceof EntityPlayer) {
/*  39 */       return JRMCoreH.bpc((EntityPlayer)e, e.func_70005_c_());
/*     */     }
/*  41 */     return 1L;
/*     */   }
/*     */   public void renderSense(int hp, int maxhp, int ki, int maxki, RenderLivingEvent.Post event) {
/*  44 */     double X = event.x;
/*  45 */     double Y = event.y;
/*  46 */     double Z = event.z;
/*  47 */     EntityPlayer p = Main.proxy.getPlayerClient();
/*  48 */     double d3 = event.entity.func_70068_e((Entity)p);
/*  49 */     float f2 = p.func_70093_af() ? 40.0F : 20.0F;
/*     */     
/*  51 */     if (d3 < (f2 * f2)) {
/*     */ 
/*     */ 
/*     */       
/*  55 */       float width = 39.0F;
/*  56 */       float maxperc = width / maxki;
/*  57 */       float var20 = maxperc * ki;
/*  58 */       if (var20 > width) {
/*  59 */         var20 = width;
/*     */       }
/*  61 */       maxperc = width / maxhp;
/*  62 */       float var21 = maxperc * hp;
/*  63 */       if (var21 > width) {
/*  64 */         var21 = width;
/*     */       }
/*     */       
/*  67 */       long res = bpc((Entity)event.entity);
/*     */       
/*  69 */       long bps = JRMCoreH.bpc((EntityPlayer)JRMCoreClient.mc.field_71439_g, JRMCoreClient.mc.field_71439_g.func_70005_c_(), JRMCoreH.Pwrtyp);
/*     */       
/*  71 */       long pwr = (res > bps) ? (res / bps) : (bps / res);
/*  72 */       String disp = ((res > bps) ? "+" : "-") + ((pwr > 100L) ? "100^x" : (pwr + "x"));
/*     */       
/*  74 */       long bpsa = JRMCoreH.bpc((EntityPlayer)JRMCoreClient.mc.field_71439_g, JRMCoreClient.mc.field_71439_g.func_70005_c_(), JRMCoreH.Pwrtyp, 100);
/*     */       
/*  76 */       long pwra = (res > bpsa) ? (res / bps) : (bpsa / res);
/*  77 */       String dispa = ((res > bpsa) ? "+" : "-") + ((pwra > 100L) ? "100^x" : (pwra + "x"));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 103 */       FontRenderer fontrenderer = RenderManager.field_78727_a.func_78716_a();
/* 104 */       float f = 1.6F;
/* 105 */       float f1 = 0.016666668F * f;
/* 106 */       GL11.glPushMatrix();
/*     */       
/* 108 */       float angle = (float)Math.toDegrees(Math.atan2(0.0D - event.z, 0.0D - event.x));
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 113 */       double rtx = Math.sin((angle / 57.295776F));
/* 114 */       double rty = Math.cos((angle / 57.295776F));
/* 115 */       GL11.glTranslatef((float)(X + 1.5D * rtx), (float)Y + event.entity.field_70131_O + 1.75F - event.entity.field_70131_O * 0.75F + 0.5F, (float)(Z - 1.5D * rty));
/* 116 */       GL11.glNormal3f(0.0F, 1.0F, 0.0F);
/* 117 */       GL11.glRotatef(-RenderManager.field_78727_a.field_78735_i, 0.0F, 1.0F, 0.0F);
/* 118 */       GL11.glRotatef(RenderManager.field_78727_a.field_78732_j, 1.0F, 0.0F, 0.0F);
/*     */ 
/*     */       
/* 121 */       double ikr = (RenderManager.field_78727_a.field_78735_i % 180.0F / 57.295776F);
/*     */ 
/*     */ 
/*     */       
/* 125 */       GL11.glScalef(-f1, -f1, f1);
/* 126 */       d3 = event.entity.func_70032_d((Entity)p);
/* 127 */       if (d3 > 10.0D)
/* 128 */         GL11.glScaled(d3 / 10.0D, d3 / 10.0D, d3 / 10.0D); 
/* 129 */       GL11.glDisable(2896);
/* 130 */       OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, 240.0F, 240.0F);
/* 131 */       GL11.glDepthMask(false);
/* 132 */       GL11.glDisable(2929);
/* 133 */       GL11.glEnable(3042);
/* 134 */       OpenGlHelper.func_148821_a(770, 771, 1, 0);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 139 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.7F);
/* 140 */       ResourceLocation guiLocation = new ResourceLocation(JRMCoreH.tjdbcAssts + ":kisense.png");
/* 141 */       Client.mc.field_71446_o.func_110577_a(guiLocation);
/* 142 */       drawTexturedModalRect(0.0F, 0.0F, 0, 0, 21.0F, 41.0F, 0.0F);
/*     */       
/* 144 */       int bc1 = 654591;
/* 145 */       if (JRMCoreH.align > 66) { bc1 = 654591; }
/* 146 */       else if (JRMCoreH.align <= 66 && JRMCoreH.align >= 33) { bc1 = 13478142; }
/* 147 */       else if (JRMCoreH.align < 33) { bc1 = 16522030; }
/* 148 */        int s = ((JRMCoreH.Race == 1 || JRMCoreH.Race == 2) && JRMCoreH.State > 0) ? 16574610 : bc1;
/* 149 */       glColor4f(s, 1.0F);
/*     */       
/* 151 */       drawTexturedModalRect(1.0F, (39 - (int)var20 + 1), 24, 0, 10.0F, (int)var20, 0.0F);
/*     */       
/* 153 */       glColor4f(7208960, 1.0F);
/* 154 */       drawTexturedModalRect(11.0F, (39 - (int)var21 + 1), 34, 0, 9.0F, (int)var21, 0.0F);
/* 155 */       width = 41.0F;
/* 156 */       maxperc = width / 10.0F;
/* 157 */       float var22 = maxperc * (float)((pwr > 10L) ? 10L : pwr);
/* 158 */       if (var22 > width) {
/* 159 */         var22 = width;
/*     */       }
/*     */       
/* 162 */       glColor4f((res > bps) ? 16737280 : 654591, 1.0F);
/* 163 */       drawTexturedModalRect(-3.0F, (41 - (int)var22), 21, 0, 3.0F, (int)var22, 0.0F);
/*     */       
/* 165 */       var22 = maxperc * (float)((pwra > 10L) ? 10L : pwra);
/* 166 */       if (var22 > width) {
/* 167 */         var22 = width;
/*     */       }
/* 169 */       glColor4f((res > bpsa) ? 16737280 : 654591, 1.0F);
/* 170 */       drawTexturedModalRect(21.0F, (41 - (int)var22), 21, 0, 3.0F, (int)var22, 0.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 185 */       GL11.glEnable(2929);
/* 186 */       GL11.glDepthMask(true);
/*     */ 
/*     */       
/* 189 */       GL11.glEnable(2896);
/* 190 */       GL11.glDisable(3042);
/* 191 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 258 */       GL11.glEnable(2896);
/* 259 */       GL11.glDisable(3042);
/* 260 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 261 */       GL11.glPopMatrix();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void glColor4f(int c, float a) {
/* 266 */     float h2 = (c >> 16 & 0xFF) / 255.0F;
/* 267 */     float h3 = (c >> 8 & 0xFF) / 255.0F;
/* 268 */     float h4 = (c & 0xFF) / 255.0F;
/* 269 */     float h1 = 1.0F;
/* 270 */     GL11.glColor4f(h1 * h2, h1 * h3, h1 * h4, a);
/*     */   }
/*     */   
/*     */   public static void glColor4f(int c, int c2, float p, float a) {
/* 274 */     float h2 = (c >> 16 & 0xFF) / 255.0F;
/* 275 */     float h3 = (c >> 8 & 0xFF) / 255.0F;
/* 276 */     float h4 = (c & 0xFF) / 255.0F;
/* 277 */     float h22 = (c2 >> 16 & 0xFF) / 255.0F;
/* 278 */     float h32 = (c2 >> 8 & 0xFF) / 255.0F;
/* 279 */     float h42 = (c2 & 0xFF) / 255.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 284 */     float percentComplete = p;
/* 285 */     percentComplete = (percentComplete > 1.0F) ? 1.0F : percentComplete;
/* 286 */     float percentGone = 1.0F - percentComplete;
/* 287 */     float red = h2 * percentGone + h22 * percentComplete;
/* 288 */     float green = h3 * percentGone + h32 * percentComplete;
/* 289 */     float blue = h4 * percentGone + h42 * percentComplete;
/*     */     
/* 291 */     h2 = red;
/* 292 */     h3 = green;
/* 293 */     h4 = blue;
/*     */ 
/*     */     
/* 296 */     GL11.glColor4f(h2, h3, h4, a);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   @SubscribeEvent
/*     */   public void onRenderLivingEvent(RenderLivingEvent.Post event) {
/* 301 */     boolean plyr = event.entity instanceof EntityPlayer;
/* 302 */     if (JRMCoreH.Pwrtyp == 1 && (event.entity instanceof EntityCreature || plyr)) {
/* 303 */       renderSense((int)event.entity.func_110143_aJ(), (int)event.entity.func_110138_aP(), 100, 100, event);
/*     */     }
/*     */     
/* 306 */     if (event.entity instanceof EntityPlayer && JRMCoreH.Pwrtyp == 1) {
/* 307 */       int hp = Integer.parseInt(JRMCoreH.data(event.entity.func_70005_c_(), 8, "200"));
/* 308 */       int ki = Integer.parseInt(JRMCoreH.data(event.entity.func_70005_c_(), 9, "200"));
/* 309 */       int[] atr = JRMCoreH.PlyrAttrbtsC((EntityPlayer)event.entity);
/* 310 */       String[] s = JRMCoreH.data(event.entity.func_70005_c_(), 1, "0;0;0;0;0;0").split(";");
/* 311 */       int cls = Integer.parseInt(s[3]);
/* 312 */       int race = Integer.parseInt(s[0]);
/* 313 */       int maxhp = JRMCoreH.stat((Entity)event.entity, 2, 1, 2, atr[2], race, cls, 0.0F);
/* 314 */       int maxki = JRMCoreH.stat((Entity)event.entity, 5, 1, 5, atr[5], race, cls, 0.0F);
/* 315 */       renderSense(hp, maxhp, ki, maxki, event);
/*     */       
/* 317 */       EntityPlayer p = mod_JRMCore.proxy.getPlayerClient();
/* 318 */       double d3 = event.entity.func_70068_e((Entity)p);
/* 319 */       float f2 = p.func_70093_af() ? 4.0F : 8.0F;
/*     */ 
/*     */       
/* 322 */       if (d3 < (f2 * f2)) {
/* 323 */         double X = event.x;
/* 324 */         double Y = event.y;
/* 325 */         double Z = event.z;
/* 326 */         float width = 120.0F;
/* 327 */         float maxperc = width / maxhp;
/* 328 */         float var20 = maxperc * hp;
/* 329 */         if (var20 > width) {
/* 330 */           var20 = width;
/*     */         }
/* 332 */         float r = (var20 > 50.0F) ? 0.58F : ((var20 > 25.0F) ? 1.0F : 1.0F);
/* 333 */         float g = (var20 > 50.0F) ? 0.83F : ((var20 > 25.0F) ? 1.0F : 0.2F);
/* 334 */         float b = (var20 > 50.0F) ? 0.23F : ((var20 > 25.0F) ? 0.2F : 0.2F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 341 */         FontRenderer fontrenderer = JRMCoreClient.mc.field_71466_p;
/* 342 */         GL11.glPushMatrix();
/* 343 */         GL11.glTranslatef((float)X, (float)Y + event.entity.field_70131_O + 1.75F - event.entity.field_70131_O * 0.75F, (float)Z);
/* 344 */         GL11.glNormal3f(0.0F, 1.0F, 0.0F);
/* 345 */         GL11.glRotatef(-RenderManager.field_78727_a.field_78735_i, 0.0F, 1.0F, 0.0F);
/* 346 */         GL11.glRotatef(RenderManager.field_78727_a.field_78732_j, 1.0F, 0.0F, 0.0F);
/* 347 */         GL11.glRotatef(-30.0F, 0.0F, 0.0F, 1.0F);
/* 348 */         float f1 = 0.0116F;
/* 349 */         GL11.glScalef(-f1, -f1, f1);
/* 350 */         GL11.glDisable(2896);
/* 351 */         GL11.glTranslatef(-width / 2.0F - event.entity.field_70130_N * 40.0F, 1.0F / f1, 0.0F - event.entity.field_70130_N * 80.0F);
/*     */         
/* 353 */         GL11.glEnable(3042);
/* 354 */         OpenGlHelper.func_148821_a(770, 771, 1, 0);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 359 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 360 */         ResourceLocation guiLocation = new ResourceLocation(JRMCoreH.tjsaoc + ":gui2.png");
/* 361 */         JRMCoreClient.mc.field_71446_o.func_110577_a(guiLocation);
/* 362 */         drawTexturedModalRect(0.0F, -1.0F, 0, 43, 126.0F, 15.0F, 0.0F);
/* 363 */         GL11.glColor4f(r, g, b, 1.0F);
/* 364 */         drawTexturedModalRect(4.0F, 1.0F, 0, 58, var20, 11.0F, -0.01F);
/*     */         
/* 366 */         GL11.glTranslatef(width, 0.0F, 0.0F);
/* 367 */         GL11.glScalef(1.0F, 1.0F, 1.0F);
/* 368 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */         
/* 370 */         drawTexturedModalRect(0.0F, -1.0F, 126, 43, -126.0F, 15.0F, 0.0F);
/* 371 */         GL11.glColor4f(r, g, b, 1.0F);
/* 372 */         drawTexturedModalRect((int)var20 - width - 2.0F, 1.0F, (int)var20, 58, -var20, 11.0F, 0.01F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 386 */         GL11.glEnable(2896);
/* 387 */         GL11.glDisable(3042);
/* 388 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 389 */         GL11.glPopMatrix();
/*     */       } 
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
/*     */   public void drawTexturedModalRect(float x, float y, int u, int v, float width, float height, float z) {
/* 486 */     float f = 0.00390625F;
/* 487 */     float f1 = 0.00390625F;
/* 488 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 489 */     tessellator.func_78382_b();
/* 490 */     tessellator.func_78374_a(x, (y + 0.0F), z, ((u + 0) * f), ((v + 0) * f1));
/* 491 */     tessellator.func_78374_a(x, (y + height), z, ((u + 0) * f), ((v + height) * f1));
/* 492 */     tessellator.func_78374_a((x + width), (y + height), z, ((u + width) * f), ((v + height) * f1));
/* 493 */     tessellator.func_78374_a((x + width), (y + 0.0F), z, ((u + width) * f), ((v + 0) * f1));
/* 494 */     tessellator.func_78381_a();
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onLivingDropsEvent(LivingDropsEvent event) {}
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\DBCEHbckp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */