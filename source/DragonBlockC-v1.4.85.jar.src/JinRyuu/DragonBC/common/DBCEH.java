/*     */ package JinRyuu.DragonBC.common;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
/*     */ import JinRyuu.JRMCore.JRMCoreCliTicH;
/*     */ import JinRyuu.JRMCore.JRMCoreClient;
/*     */ import JinRyuu.JRMCore.JRMCoreConfig;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.JRMCoreHC;
/*     */ import JinRyuu.JRMCore.mod_JRMCore;
/*     */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.entity.RenderManager;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraftforge.client.event.RenderLivingEvent;
/*     */ import net.minecraftforge.event.world.BlockEvent;
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
/*     */ public class DBCEH
/*     */ {
/*     */   public static final int ksm_default = 0;
/*     */   public static final int ksm_onlyPly = 1;
/*     */   public static final int ksm_onlyMob = 2;
/*     */   public static final int ksm_showall = 3;
/*     */   public static final int ksm_off = 4;
/*  44 */   public static int kisnsMd = 0;
/*     */   
/*  46 */   public String lastRender = "";
/*     */   
/*     */   public void renderSense(int hp, int maxhp, int ki, int maxki, int align, RenderLivingEvent.Post event) {
/*  49 */     double X = event.x;
/*  50 */     double Y = event.y;
/*  51 */     double Z = event.z;
/*  52 */     EntityPlayer p = mod_JRMCore.proxy.getPlayerClient();
/*  53 */     EntityLivingBase entityLivingBase = event.entity;
/*     */ 
/*     */     
/*  56 */     if (entityLivingBase instanceof EntityPlayer && JRMCoreH.plyrs != null && JRMCoreH.plyrs.length > 0) {
/*     */       
/*  58 */       EntityPlayer player = (EntityPlayer)entityLivingBase;
/*     */       
/*  60 */       for (int pl = 0; pl < JRMCoreH.plyrs.length; pl++) {
/*     */         
/*  62 */         if (JRMCoreH.dat18 != null && JRMCoreH.dat18.length > pl && JRMCoreH.dat18[pl] != null) {
/*     */           
/*  64 */           String[] fullFusionData = JRMCoreH.dat18[pl].split(";");
/*  65 */           if (fullFusionData.length >= 3) {
/*     */             
/*  67 */             String[] fusionData = fullFusionData[2].split(",");
/*  68 */             if (fusionData.length == 3) {
/*     */               
/*  70 */               EntityPlayer fusionSpectator = player.field_70170_p.func_72924_a(fusionData[1]);
/*  71 */               if (fusionSpectator != null && fusionSpectator.func_70005_c_().equals(player.func_70005_c_())) {
/*     */                 return;
/*     */               }
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  81 */     int kiSenseLvl = JRMCoreH.SklLvl(6);
/*  82 */     double distance = entityLivingBase.func_70068_e((Entity)p);
/*  83 */     float f2 = (30 + kiSenseLvl * 10);
/*     */     
/*  85 */     if (distance < (f2 * f2) && (((Entity)entityLivingBase).field_70163_u >= 61.0D || Y > (-kiSenseLvl * 4))) {
/*     */       int bc1;
/*  87 */       float width = 39.0F;
/*  88 */       float maxperc = width / maxki;
/*  89 */       float var20 = maxperc * ki;
/*  90 */       if (var20 > width)
/*     */       {
/*  92 */         var20 = width;
/*     */       }
/*  94 */       maxperc = width / maxhp;
/*  95 */       float var21 = maxperc * hp;
/*  96 */       if (var21 > width)
/*     */       {
/*  98 */         var21 = width;
/*     */       }
/*     */       
/* 101 */       long res = JRMCoreH.gkap(JRMCoreH.bpc((Entity)entityLivingBase), "sns;" + entityLivingBase.func_70005_c_() + ";" + entityLivingBase.func_145782_y());
/*     */       
/* 103 */       long bps = JRMCoreHC.BPC_ME;
/* 104 */       long pwr = (res > bps) ? (res / bps) : (bps / res);
/*     */       
/* 106 */       long bpsa = JRMCoreHC.BPC_ME2;
/*     */       
/* 108 */       long pwra = (res > bpsa) ? (res / bpsa) : (bpsa / res);
/* 109 */       boolean loo = (JRMCoreCliTicH.lockOn != null && JRMCoreConfig.lockon);
/* 110 */       if (loo ? !loo : (res <= 5L || (res < bps && kisnsMd != 3 && bps / res > 100L)))
/*     */         return; 
/* 112 */       FontRenderer fontrenderer = RenderManager.field_78727_a.func_78716_a();
/* 113 */       float f = 1.6F;
/* 114 */       float f1 = 0.016666668F * f;
/* 115 */       GL11.glPushMatrix();
/* 116 */       float angle = (float)Math.toDegrees(Math.atan2(0.0D - event.z, 0.0D - event.x));
/*     */       
/* 118 */       double rtx = Math.sin((angle / 57.295776F));
/* 119 */       double rty = Math.cos((angle / 57.295776F));
/* 120 */       GL11.glTranslatef((float)(X + 0.0D * rtx), (float)Y + ((Entity)entityLivingBase).field_70131_O + 1.75F - ((Entity)entityLivingBase).field_70131_O * 0.75F + 0.5F, (float)(Z - 0.0D * rty));
/* 121 */       GL11.glNormal3f(0.0F, 1.0F, 0.0F);
/* 122 */       boolean t = (DBCClient.mc.field_71474_y.field_74320_O == 2);
/* 123 */       GL11.glRotatef(-RenderManager.field_78727_a.field_78735_i, 0.0F, 1.0F, 0.0F);
/* 124 */       GL11.glRotatef(t ? -RenderManager.field_78727_a.field_78732_j : RenderManager.field_78727_a.field_78732_j, 1.0F, 0.0F, 0.0F);
/*     */ 
/*     */       
/* 127 */       double ikr = (RenderManager.field_78727_a.field_78735_i % 180.0F / 57.295776F);
/*     */       
/* 129 */       GL11.glScalef(-f1, -f1, f1);
/* 130 */       distance = entityLivingBase.func_70032_d((Entity)p);
/*     */       
/* 132 */       if (distance > 10.0D)
/* 133 */         GL11.glScaled(distance / 10.0D, distance / 10.0D, distance / 10.0D); 
/* 134 */       GL11.glDisable(2896);
/* 135 */       OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, 240.0F, 240.0F);
/* 136 */       GL11.glDepthMask(false);
/* 137 */       GL11.glDisable(2929);
/* 138 */       GL11.glEnable(3042);
/* 139 */       OpenGlHelper.func_148821_a(770, 771, 1, 0);
/*     */       
/* 141 */       int Ypos = -40;
/* 142 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.7F);
/* 143 */       ResourceLocation guiLocation = new ResourceLocation(JRMCoreH.tjdbcAssts + ":kisense.png");
/* 144 */       JRMCoreClient.mc.field_71446_o.func_110577_a(guiLocation);
/* 145 */       drawTexturedModalRect(0.0F, (0 + Ypos), 0, 0, 21.0F, 41.0F, 0.0F);
/*     */       
/* 147 */       int red = 16522030;
/* 148 */       int blu = 654591;
/* 149 */       int pur = 13478142;
/* 150 */       int ora = 16737280;
/* 151 */       int darkred = 7208960;
/* 152 */       int yel = 16574610;
/*     */ 
/*     */       
/* 155 */       switch (align) { case 0:
/* 156 */           bc1 = blu; break;
/* 157 */         case 1: bc1 = pur; break;
/* 158 */         case 2: bc1 = red; break;
/* 159 */         default: bc1 = pur;
/*     */           break; }
/*     */       
/* 162 */       glColor4f(bc1, 1.0F);
/* 163 */       drawTexturedModalRect(1.0F, (39 - (int)var20 + 1 + Ypos), 25, 0, (10 + ((kiSenseLvl > 1) ? 0 : 9)), (int)var20, 0.0F);
/*     */       
/* 165 */       if (kiSenseLvl > 1) {
/*     */         
/* 167 */         glColor4f(7208960, 1.0F);
/* 168 */         drawTexturedModalRect(11.0F, (39 - (int)var21 + 1 + Ypos), 35, 0, 9.0F, (int)var21, 0.0F);
/*     */       } 
/*     */       
/* 171 */       if (kiSenseLvl > 3) {
/*     */         
/* 173 */         width = 41.0F;
/* 174 */         maxperc = width / 10.0F;
/* 175 */         float var22 = maxperc * (float)((pwr > 10L) ? 10L : pwr);
/* 176 */         if (var22 > width)
/*     */         {
/* 178 */           var22 = width;
/*     */         }
/*     */         
/* 181 */         glColor4f((res > bps) ? 16737280 : 654591, 1.0F);
/* 182 */         drawTexturedModalRect(-3.0F, (41 - (int)var22 + Ypos), 21, 0, 3.0F, (int)var22, 0.0F);
/* 183 */         if (pwr > 10L && kiSenseLvl > 6) {
/*     */           
/* 185 */           maxperc = width / 100.0F;
/* 186 */           var22 = maxperc * (float)((pwr > 100L) ? 100L : pwr);
/* 187 */           if (var22 > width)
/*     */           {
/* 189 */             var22 = width;
/*     */           }
/* 191 */           drawTexturedModalRect(-4.0F, (41 - (int)var22 + Ypos), 24, 0, 1.0F, (int)var22, 0.0F);
/*     */         } 
/*     */         
/* 194 */         maxperc = width / 10.0F;
/* 195 */         var22 = maxperc * (float)((pwra > 10L) ? 10L : pwra);
/* 196 */         if (var22 > width) {
/* 197 */           var22 = width;
/*     */         }
/* 199 */         glColor4f((res > bpsa) ? 16737280 : 654591, 1.0F);
/* 200 */         drawTexturedModalRect(21.0F, (41 - (int)var22 + Ypos), 21, 0, 3.0F, (int)var22, 0.0F);
/* 201 */         if (pwra > 10L && kiSenseLvl > 6) {
/*     */           
/* 203 */           maxperc = width / 100.0F;
/* 204 */           var22 = maxperc * (float)((pwra > 100L) ? 100L : pwra);
/* 205 */           if (var22 > width)
/*     */           {
/* 207 */             var22 = width;
/*     */           }
/* 209 */           drawTexturedModalRect(24.0F, (41 - (int)var22 + Ypos), 24, 0, 1.0F, (int)var22, 0.0F);
/*     */         } 
/*     */       } 
/*     */       
/* 213 */       if (kiSenseLvl > 9) {
/*     */         
/* 215 */         String n = entityLivingBase.func_70005_c_();
/* 216 */         String[] d10 = JRMCoreH.data(n, 10, "0;0").split(";");
/* 217 */         String[] d2 = JRMCoreH.data(n, 2, "0;0").split(";");
/* 218 */         String[] d1 = JRMCoreH.data(n, 1, "0;0").split(";");
/* 219 */         int inc = 0;
/* 220 */         String d = hp + "";
/* 221 */         int ho = Ypos - inc * 9;
/* 222 */         int hpw = fontrenderer.func_78256_a(d);
/* 223 */         fontrenderer.func_78276_b(d, (int)(13.0F - hpw / 2.0F), -8 + ho, 0);
/* 224 */         fontrenderer.func_78276_b(d, (int)(11.0F - hpw / 2.0F), -8 + ho, 0);
/* 225 */         fontrenderer.func_78276_b(d, (int)(12.0F - hpw / 2.0F), -7 + ho, 0);
/* 226 */         fontrenderer.func_78276_b(d, (int)(12.0F - hpw / 2.0F), -9 + ho, 0);
/* 227 */         fontrenderer.func_78276_b(d, 12 - hpw / 2, -8 + ho, 14812441);
/* 228 */         inc++;
/*     */       } 
/*     */       
/* 231 */       GL11.glEnable(2929);
/* 232 */       GL11.glDepthMask(true);
/* 233 */       GL11.glEnable(2896);
/* 234 */       GL11.glDisable(3042);
/* 235 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */       
/* 237 */       GL11.glPopMatrix();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glColor4f(int c, float a) {
/* 243 */     float h2 = (c >> 16 & 0xFF) / 255.0F;
/* 244 */     float h3 = (c >> 8 & 0xFF) / 255.0F;
/* 245 */     float h4 = (c & 0xFF) / 255.0F;
/* 246 */     float h1 = 1.0F;
/* 247 */     GL11.glColor4f(h1 * h2, h1 * h3, h1 * h4, a);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glColor4f(int c, int c2, float p, float a) {
/* 253 */     float h2 = (c >> 16 & 0xFF) / 255.0F;
/* 254 */     float h3 = (c >> 8 & 0xFF) / 255.0F;
/* 255 */     float h4 = (c & 0xFF) / 255.0F;
/* 256 */     float h22 = (c2 >> 16 & 0xFF) / 255.0F;
/* 257 */     float h32 = (c2 >> 8 & 0xFF) / 255.0F;
/* 258 */     float h42 = (c2 & 0xFF) / 255.0F;
/*     */     
/* 260 */     float percentComplete = p;
/* 261 */     percentComplete = (percentComplete > 1.0F) ? 1.0F : percentComplete;
/* 262 */     float percentGone = 1.0F - percentComplete;
/* 263 */     float red = h2 * percentGone + h22 * percentComplete;
/* 264 */     float green = h3 * percentGone + h32 * percentComplete;
/* 265 */     float blue = h4 * percentGone + h42 * percentComplete;
/*     */     
/* 267 */     h2 = red;
/* 268 */     h3 = green;
/* 269 */     h4 = blue;
/* 270 */     GL11.glColor4f(h2, h3, h4, a);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   @SubscribeEvent
/*     */   public void onRenderLivingEvent(RenderLivingEvent.Post event) {
/* 276 */     boolean plyr = event.entity instanceof EntityPlayer;
/* 277 */     boolean loo = (JRMCoreCliTicH.lockOn != null && JRMCoreConfig.lockon);
/* 278 */     boolean lo = (loo && event.entity.equals(JRMCoreCliTicH.lockOn));
/* 279 */     if (JRMCoreH.Pwrtyp == 1 && JRMCoreH.SklLvl(6) > 0 && kisnsMd != 4) {
/* 280 */       if (!(event.entity instanceof JinRyuu.JRMCore.entity.EntitySafeZone) && event.entity instanceof net.minecraft.entity.EntityCreature && (loo ? lo : (kisnsMd != 1))) {
/*     */ 
/*     */ 
/*     */         
/* 284 */         int align = 1;
/* 285 */         if (event.entity instanceof net.minecraft.entity.monster.EntityMob) { align = 2; }
/* 286 */         else if (event.entity instanceof JinRyuu.DragonBC.common.Npcs.EntityDBCEvil) { align = 2; }
/* 287 */         else if (event.entity instanceof JinRyuu.DragonBC.common.Npcs.EntityDBCNeut) { align = 1; }
/* 288 */         else if (event.entity instanceof JinRyuu.DragonBC.common.Npcs.EntityDBCGood) { align = 0; }
/* 289 */         else if (event.entity instanceof JinRyuu.DragonBC.common.Npcs.EntityDBC) { align = 1; }
/* 290 */         else if (event.entity instanceof JinRyuu.DragonBC.common.Npcs.EntityDBC) { align = 1; }
/* 291 */          renderSense((int)event.entity.func_110143_aJ(), (int)event.entity.func_110138_aP(), 100, 100, align, event);
/*     */       } 
/*     */       
/* 294 */       if (plyr && (loo ? lo : (kisnsMd != 2)) && 
/* 295 */         !JRMCoreClient.mc.field_71439_g.func_70005_c_().equals(event.entity.func_70005_c_()) && 
/* 296 */         JRMCoreH.dnn(14) && JRMCoreH.dnn(8) && JRMCoreH.dnn(9) && JRMCoreH.dnn(1) && JRMCoreH.dnn(5)) {
/*     */         
/* 298 */         EntityPlayer p = (EntityPlayer)event.entity;
/* 299 */         int hp = Integer.parseInt(JRMCoreH.data(event.entity.func_70005_c_(), 8, "200"));
/* 300 */         int ki = Integer.parseInt(JRMCoreH.data(event.entity.func_70005_c_(), 9, "200"));
/* 301 */         int[] atr = JRMCoreH.PlyrAttrbtsC((EntityPlayer)event.entity);
/* 302 */         String[] s = JRMCoreH.data(event.entity.func_70005_c_(), 1, "0;0;0;0;0;0").split(";");
/* 303 */         int race = Integer.parseInt(s[0]);
/* 304 */         int pwr = Integer.parseInt(s[2]);
/* 305 */         int cls = Integer.parseInt(s[3]);
/* 306 */         s = JRMCoreH.data(event.entity.func_70005_c_(), 6, "pty;pty;pty;pty").split(";");
/*     */ 
/*     */ 
/*     */         
/* 310 */         String[] PlyrSkills = s[0].split(",");
/* 311 */         int maxhp = JRMCoreH.stat((Entity)p, 2, pwr, 2, atr[2], race, cls, 0.0F);
/* 312 */         int maxki = JRMCoreH.stat((Entity)p, 5, pwr, 5, atr[5], race, cls, JRMCoreH.SklLvl_KiBs(PlyrSkills, pwr));
/* 313 */         int align = JRMCoreH.Algnmnt(Integer.parseInt(JRMCoreH.data(event.entity.func_70005_c_(), 5, "50;0").split(";")[0]));
/* 314 */         renderSense(hp, maxhp, ki, maxki, align, event);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawTexturedModalRect(float x, float y, int u, int v, float width, float height, float z) {
/* 324 */     float f = 0.00390625F;
/* 325 */     float f1 = 0.00390625F;
/* 326 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 327 */     tessellator.func_78382_b();
/* 328 */     tessellator.func_78374_a(x, (y + 0.0F), z, ((u + 0) * f), ((v + 0) * f1));
/* 329 */     tessellator.func_78374_a(x, (y + height), z, ((u + 0) * f), ((v + height) * f1));
/* 330 */     tessellator.func_78374_a((x + width), (y + height), z, ((u + width) * f), ((v + height) * f1));
/* 331 */     tessellator.func_78374_a((x + width), (y + 0.0F), z, ((u + width) * f), ((v + 0) * f1));
/* 332 */     tessellator.func_78381_a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void gldsog(BlockEvent.BreakEvent event) {
/* 341 */     if (event.block == BlocksDBC.ppBlock) event.setCanceled(true); 
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\DBCEH.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */