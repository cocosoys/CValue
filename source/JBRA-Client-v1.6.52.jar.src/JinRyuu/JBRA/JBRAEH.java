/*     */ package JinRyuu.JBRA;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreClient;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.JRMCoreHJBRA;
/*     */ import JinRyuu.JRMCore.JRMCoreHNC;
/*     */ import JinRyuu.JRMCore.entity.ModelBipedBody;
/*     */ import JinRyuu.JRMCore.i.ExtendedPlayer;
/*     */ import JinRyuu.JRMCore.items.ItemBodysuit;
/*     */ import JinRyuu.JRMCore.items.ItemHeadwear;
/*     */ import JinRyuu.JRMCore.items.ItemVanity;
/*     */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelBiped;
/*     */ import net.minecraft.client.renderer.entity.RenderBiped;
/*     */ import net.minecraft.client.renderer.entity.RenderPlayer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemArmor;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraftforge.client.ForgeHooksClient;
/*     */ import net.minecraftforge.client.event.RenderPlayerEvent;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class JBRAEH {
/*  31 */   public ModelBiped armrMdl = JRMCoreHJBRA.ModelBipedBody(1.0F);
/*  32 */   public ModelBiped armrMdl2 = JRMCoreHJBRA.ModelBipedBody(0.5F);
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*  35 */   public static final ModelBipedDBC body = new ModelBipedDBC(0.0F);
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onRenderLivingEvent(RenderPlayerEvent.Specials.Post event) {
/*  40 */     if (event.renderer instanceof RenderPlayerJBRA) {
/*     */       
/*  42 */       RenderPlayerJBRA r = (RenderPlayerJBRA)event.renderer;
/*  43 */       EntityPlayer pl = event.entityPlayer;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  48 */       ModelBipedDBC mdl = r.modelMain;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  59 */       if (JRMCoreH.NC()) {
/*  60 */         int idd = ExtendedPlayer.get(pl).getHandEffect();
/*  61 */         int idd2 = ExtendedPlayer.get(pl).getEffect_used();
/*     */         
/*  63 */         if (idd == 1) {
/*  64 */           GL11.glPushMatrix();
/*     */           
/*  66 */           float fm = 0.0F;
/*  67 */           float gen = RenderPlayerJBRA.genGet();
/*  68 */           float childScl = RenderPlayerJBRA.childSclGet();
/*  69 */           if (gen <= 1.0F) {
/*  70 */             GL11.glScalef(1.0F / childScl, 1.0F / childScl, 1.0F / childScl);
/*  71 */             GL11.glTranslatef(0.0F, (childScl - 1.0F) * 1.5F, 0.0F);
/*  72 */             mdl.RA.func_78794_c(0.0625F); fm = 0.0F;
/*  73 */           }  if (gen >= 2.0F) {
/*  74 */             GL11.glScalef(1.0F / childScl * ((gen <= 1.0F) ? 1.0F : 0.7F), 1.0F / childScl, 1.0F / childScl * ((gen <= 1.0F) ? 1.0F : 0.7F));
/*  75 */             GL11.glTranslatef(0.0F, (childScl - 1.0F) * 1.5F, 0.0F);
/*  76 */             mdl.RA.func_78794_c(0.0625F); fm = 0.1F;
/*  77 */           }  float f = childScl;
/*     */           
/*  79 */           GL11.glRotatef(6.0F, 0.0F, 0.0F, 1.0F);
/*  80 */           GL11.glTranslatef(-0.29F, 0.15F, 0.0F);
/*  81 */           r.chakra((Entity)pl, idd2);
/*  82 */           RenderPlayerJBRA.hndff((Entity)pl, false, idd, idd2);
/*  83 */           GL11.glPopMatrix();
/*     */         } 
/*  85 */         if (idd == 2) {
/*  86 */           GL11.glPushMatrix();
/*     */           
/*  88 */           float fm = 0.0F;
/*  89 */           float gen = RenderPlayerJBRA.genGet();
/*  90 */           float childScl = RenderPlayerJBRA.childSclGet();
/*  91 */           if (gen <= 1.0F) {
/*  92 */             GL11.glScalef(1.0F / childScl, 1.0F / childScl, 1.0F / childScl);
/*  93 */             GL11.glTranslatef(0.0F, (childScl - 1.0F) * 1.5F, 0.0F);
/*  94 */             mdl.RA.func_78794_c(0.0625F); fm = 0.0F;
/*  95 */           }  if (gen >= 2.0F) {
/*  96 */             GL11.glScalef(1.0F / childScl * ((gen <= 1.0F) ? 1.0F : 0.7F), 1.0F / childScl, 1.0F / childScl * ((gen <= 1.0F) ? 1.0F : 0.7F));
/*  97 */             GL11.glTranslatef(0.0F, (childScl - 1.0F) * 1.5F, 0.0F);
/*  98 */             mdl.RA.func_78794_c(0.0625F); fm = 0.1F;
/*  99 */           }  float f = childScl;
/*     */           
/* 101 */           GL11.glRotatef(6.0F, 0.0F, 0.0F, 1.0F);
/* 102 */           GL11.glTranslatef(-0.29F, 0.15F, 0.0F);
/* 103 */           r.lightning((Entity)pl, idd2);
/* 104 */           RenderPlayerJBRA.hndff((Entity)pl, false, idd, idd2);
/* 105 */           GL11.glPopMatrix();
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 112 */       if (JRMCoreH.DBC()) {
/* 113 */         String[] arrayOfString = JRMCoreH.data(event.entity.func_70005_c_(), 1, "0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0").split(";");
/* 114 */         int pwr = Integer.parseInt(arrayOfString[2]);
/* 115 */         if (pwr == 1) {
/*     */           
/* 117 */           String datas = JRMCoreH.data(event.entity.func_70005_c_(), 6, "0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 138 */           int sklkf = datas.contains("KF") ? 1 : 0;
/* 139 */           int skf = datas.contains("KI") ? 1 : 0;
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 144 */           if (sklkf > 0 && skf > 0) {
/* 145 */             String datas2 = datas.split(";")[0];
/* 146 */             int lngth = (datas2.split(",")).length;
/* 147 */             for (int j = 0; j < lngth; j++) {
/* 148 */               String datas3 = datas2.split(",")[j];
/* 149 */               if (datas3.contains("KF")) {
/* 150 */                 String dt = datas3.replace("KF", "");
/* 151 */                 sklkf = Integer.parseInt(dt);
/* 152 */                 sklkf++;
/*     */ 
/*     */               
/*     */               }
/* 156 */               else if (datas3.contains("KI")) {
/* 157 */                 String dt = datas3.replace("KI", "");
/* 158 */                 skf = Integer.parseInt(dt);
/* 159 */                 skf++;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 170 */           GL11.glPushMatrix();
/* 171 */           String ss = arrayOfString[17];
/*     */           
/* 173 */           boolean bool = (JRMCoreH.DBC() && !ss.equals("-1"));
/*     */           
/* 175 */           if (bool && sklkf > 0 && skf > 0) {
/*     */ 
/*     */ 
/*     */             
/* 179 */             float fm = 0.0F;
/* 180 */             float gen = RenderPlayerJBRA.genGet();
/* 181 */             float childScl = RenderPlayerJBRA.childSclGet();
/* 182 */             if (gen <= 1.0F) {
/* 183 */               GL11.glScalef(1.0F / childScl, 1.0F / childScl, 1.0F / childScl);
/* 184 */               GL11.glTranslatef(0.0F, (childScl - 1.0F) * 1.5F, 0.0F);
/* 185 */               mdl.RA.func_78794_c(0.0625F); fm = 0.0F;
/* 186 */             }  if (gen >= 2.0F) {
/* 187 */               GL11.glScalef(1.0F / childScl * ((gen <= 1.0F) ? 1.0F : 0.7F), 1.0F / childScl, 1.0F / childScl * ((gen <= 1.0F) ? 1.0F : 0.7F));
/* 188 */               GL11.glTranslatef(0.0F, (childScl - 1.0F) * 1.5F, 0.0F);
/* 189 */               mdl.RA.func_78794_c(0.0625F); fm = 0.1F;
/* 190 */             }  float f = childScl;
/*     */ 
/*     */             
/* 193 */             RenderPlayerJBRA.kss(event.entity, false, Integer.parseInt(ss), sklkf, skf);
/*     */           } 
/* 195 */           GL11.glPopMatrix();
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 235 */       GL11.glPushMatrix();
/* 236 */       String str = JRMCoreH.data(event.entity.func_70005_c_(), 1, "0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0").split(";")[16];
/* 237 */       boolean v = (JRMCoreH.JYC() && !str.equals("-1"));
/*     */       
/* 239 */       if (v) {
/*     */ 
/*     */ 
/*     */         
/* 243 */         float fm = 0.0F;
/* 244 */         float gen = RenderPlayerJBRA.genGet();
/* 245 */         float childScl = RenderPlayerJBRA.childSclGet();
/* 246 */         if (gen <= 1.0F) {
/* 247 */           GL11.glScalef(1.0F / childScl, 1.0F / childScl, 1.0F / childScl);
/* 248 */           GL11.glTranslatef(0.0F, (childScl - 1.0F) * 1.5F, 0.0F);
/* 249 */           mdl.RA.func_78794_c(0.0625F); fm = 0.0F;
/* 250 */         }  if (gen >= 2.0F) {
/* 251 */           GL11.glScalef(1.0F / childScl * ((gen <= 1.0F) ? 1.0F : 0.7F), 1.0F / childScl, 1.0F / childScl * ((gen <= 1.0F) ? 1.0F : 0.7F));
/* 252 */           GL11.glTranslatef(0.0F, (childScl - 1.0F) * 1.5F, 0.0F);
/* 253 */           mdl.RA.func_78794_c(0.0625F); fm = 0.1F;
/* 254 */         }  float f = childScl;
/*     */ 
/*     */         
/* 257 */         RenderPlayerJBRA.ow(false);
/*     */       } 
/* 259 */       GL11.glPopMatrix();
/*     */ 
/*     */ 
/*     */       
/* 263 */       String[] s = JRMCoreH.data(event.entity.func_70005_c_(), 1, "0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0").split(";");
/*     */       
/* 265 */       String[] sw = s[5].split(",");
/* 266 */       int weight = Integer.parseInt(sw[0]);
/* 267 */       String[] slotbody = s[6].split(",");
/* 268 */       int body = Integer.parseInt(slotbody[0]);
/* 269 */       int head = Integer.parseInt(s[7]);
/* 270 */       if (body > 0) {
/* 271 */         ItemStack stackbody = new ItemStack(Item.func_150899_d(body));
/* 272 */         int bodycol = Integer.parseInt(slotbody[1]);
/*     */         
/* 274 */         if (stackbody != null && stackbody.func_77973_b() instanceof ItemBodysuit) {
/* 275 */           ((ItemBodysuit)stackbody.func_77973_b()).setColor(stackbody, bodycol);
/*     */           
/* 277 */           int j = ((ItemBodysuit)stackbody.func_77973_b()).getColor(stackbody);
/* 278 */           if (j != -1) {
/*     */             
/* 280 */             float f1 = (j >> 16 & 0xFF) / 255.0F;
/* 281 */             float f2 = (j >> 8 & 0xFF) / 255.0F;
/* 282 */             float f3 = (j & 0xFF) / 255.0F;
/* 283 */             GL11.glColor3f(f1, f2, f3);
/*     */           } 
/*     */ 
/*     */           
/* 287 */           ResourceLocation rl = new ResourceLocation(((ItemBodysuit)stackbody.func_77973_b()).getArmorTexture(stackbody, (Entity)pl, 0, ""));
/* 288 */           JRMCoreClient.mc.func_110434_K().func_110577_a(rl);
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 293 */           GL11.glEnable(3042);
/* 294 */           GL11.glBlendFunc(770, 771);
/*     */ 
/*     */           
/* 297 */           ModelBipedBody m = (ModelBipedBody)JRMCoreHJBRA.GiTurtleMdl3;
/* 298 */           m = (ModelBipedBody)JRMCoreHJBRA.showModel((ModelBiped)m, (EntityLivingBase)pl, stackbody, 4);
/* 299 */           m.field_78095_p = pl.func_70678_g(event.partialRenderTick);
/* 300 */           m.field_78093_q = pl.func_70115_ae();
/* 301 */           m.field_78091_s = pl.func_70631_g_();
/* 302 */           m.field_78117_n = pl.func_70093_af();
/* 303 */           ModelBipedBody.y = ModelBipedDBC.y;
/* 304 */           m.func_78088_a((Entity)pl, mdl.rot1, mdl.rot2, mdl.rot3, mdl.rot4, mdl.rot5, mdl.rot6);
/* 305 */           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */         } 
/*     */       } 
/* 308 */       if (head > 0) {
/* 309 */         ItemStack stackhead = new ItemStack(Item.func_150899_d(head));
/* 310 */         if (stackhead != null && stackhead.func_77973_b() instanceof ItemHeadwear) {
/*     */           
/* 312 */           ResourceLocation rl = new ResourceLocation(((ItemHeadwear)stackhead.func_77973_b()).getArmorTexture(stackhead, (Entity)pl, 0, ""));
/*     */           
/* 314 */           JRMCoreClient.mc.func_110434_K().func_110577_a(rl);
/*     */ 
/*     */           
/* 317 */           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */           
/* 319 */           GL11.glEnable(3042);
/* 320 */           GL11.glBlendFunc(770, 771);
/*     */ 
/*     */           
/* 323 */           ModelBipedBody m = (ModelBipedBody)JRMCoreHJBRA.GiTurtleMdl2;
/* 324 */           m = (ModelBipedBody)JRMCoreHJBRA.showModel((ModelBiped)m, (EntityLivingBase)pl, stackhead, 0);
/* 325 */           m.field_78095_p = pl.func_70678_g(event.partialRenderTick);
/* 326 */           m.field_78093_q = pl.func_70115_ae();
/* 327 */           m.field_78091_s = pl.func_70631_g_();
/* 328 */           m.field_78117_n = pl.func_70093_af();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 340 */           m.func_78088_a((Entity)pl, mdl.rot1, mdl.rot2, mdl.rot3, mdl.rot4, mdl.rot5, mdl.rot6);
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 350 */       if (weight == 2) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 370 */         String armor = "";
/* 371 */         String d = "";
/* 372 */         int wd = Integer.parseInt(sw[1]);
/* 373 */         if (wd > 50) {
/* 374 */           d = "_d";
/*     */         }
/* 376 */         armor = "armor/weightshirt" + d + ".png";
/*     */         
/* 378 */         JRMCoreClient.mc.func_110434_K().func_110577_a(new ResourceLocation(JRMCoreH.tjdbcAssts, armor));
/* 379 */         GL11.glColor3f(1.0F, 1.0F, 1.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 384 */         GL11.glEnable(3042);
/* 385 */         GL11.glBlendFunc(770, 771);
/*     */ 
/*     */         
/* 388 */         ModelBipedBody m = (ModelBipedBody)JRMCoreHJBRA.GiTurtleMdl4;
/*     */         
/* 390 */         m = (ModelBipedBody)JRMCoreHJBRA.showModel((ModelBiped)m, (EntityLivingBase)pl, null, 4);
/* 391 */         m.field_78095_p = pl.func_70678_g(event.partialRenderTick);
/* 392 */         m.field_78093_q = pl.func_70115_ae();
/* 393 */         m.field_78091_s = pl.func_70631_g_();
/* 394 */         m.field_78117_n = pl.func_70093_af();
/* 395 */         ModelBipedBody.y = ModelBipedDBC.y;
/* 396 */         m.func_78088_a((Entity)pl, mdl.rot1, mdl.rot2, mdl.rot3, mdl.rot4, mdl.rot5, mdl.rot6);
/* 397 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */       } 
/* 399 */       if (weight == 3) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 420 */         String armor = "";
/* 421 */         String d = "";
/* 422 */         int wd = Integer.parseInt(sw[1]);
/* 423 */         if (wd > 50) {
/* 424 */           d = "_d";
/*     */         }
/* 426 */         armor = "armor/weightcape" + d + ".png";
/*     */         
/* 428 */         JRMCoreClient.mc.func_110434_K().func_110577_a(new ResourceLocation(JRMCoreH.tjdbcAssts, armor));
/* 429 */         GL11.glColor3f(1.0F, 1.0F, 1.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 434 */         GL11.glEnable(3042);
/* 435 */         GL11.glBlendFunc(770, 771);
/*     */ 
/*     */         
/* 438 */         ModelBipedBody m = (ModelBipedBody)JRMCoreHJBRA.GiTurtleMdl1;
/*     */         
/* 440 */         m = (ModelBipedBody)JRMCoreHJBRA.showModel((ModelBiped)m, (EntityLivingBase)pl, null, 4);
/* 441 */         m.field_78095_p = pl.func_70678_g(event.partialRenderTick);
/* 442 */         m.field_78093_q = pl.func_70115_ae();
/* 443 */         m.field_78091_s = pl.func_70631_g_();
/* 444 */         m.field_78117_n = pl.func_70093_af();
/* 445 */         ModelBipedBody.y = ModelBipedDBC.y;
/* 446 */         m.func_78088_a((Entity)pl, mdl.rot1, mdl.rot2, mdl.rot3, mdl.rot4, mdl.rot5, mdl.rot6);
/* 447 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */       } 
/*     */       
/* 450 */       if (weight == 4) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 471 */         String armor = "";
/* 472 */         String d = "";
/* 473 */         int wd = Integer.parseInt(sw[1]);
/* 474 */         if (wd > 50) {
/* 475 */           d = "_d";
/*     */         }
/* 477 */         armor = "armor/weightheavysuit" + d + ".png";
/*     */         
/* 479 */         JRMCoreClient.mc.func_110434_K().func_110577_a(new ResourceLocation(JRMCoreH.tjdbcAssts, armor));
/* 480 */         GL11.glColor3f(1.0F, 1.0F, 1.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 485 */         GL11.glEnable(3042);
/* 486 */         GL11.glBlendFunc(770, 771);
/*     */ 
/*     */         
/* 489 */         ModelBipedBody m = (ModelBipedBody)JRMCoreHJBRA.GiTurtleMdl1;
/*     */         
/* 491 */         m = (ModelBipedBody)JRMCoreHJBRA.showModel((ModelBiped)m, (EntityLivingBase)pl, null, 4);
/* 492 */         m.field_78095_p = pl.func_70678_g(event.partialRenderTick);
/* 493 */         m.field_78093_q = pl.func_70115_ae();
/* 494 */         m.field_78091_s = pl.func_70631_g_();
/* 495 */         m.field_78117_n = pl.func_70093_af();
/* 496 */         ModelBipedBody.y = ModelBipedDBC.y;
/* 497 */         m.func_78088_a((Entity)pl, mdl.rot1, mdl.rot2, mdl.rot3, mdl.rot4, mdl.rot5, mdl.rot6);
/* 498 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 505 */       s = JRMCoreH.data(event.entity.func_70005_c_(), 1, "0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0").split(";");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 524 */       String[][] slot_vanity_num = new String[8][];
/* 525 */       int[] slot_van = new int[8]; int i;
/* 526 */       for (i = 0; i < 8; i++) {
/* 527 */         slot_vanity_num[i] = s[8 + i].split(",");
/* 528 */         slot_van[i] = Integer.parseInt(slot_vanity_num[i][0]);
/*     */       } 
/*     */       
/* 531 */       for (i = 0; i < 8; i++) {
/* 532 */         if (slot_van[i] > 0) {
/* 533 */           ItemStack itemstack = new ItemStack(Item.func_150899_d(slot_van[i]));
/* 534 */           int bodycol = Integer.parseInt(slot_vanity_num[i][1]);
/*     */           
/* 536 */           if (itemstack != null && itemstack.func_77973_b() instanceof ItemVanity) {
/* 537 */             ((ItemVanity)itemstack.func_77973_b()).setColor(itemstack, bodycol);
/*     */             
/* 539 */             int j = ((ItemVanity)itemstack.func_77973_b()).getColor(itemstack);
/* 540 */             if (j != -1) {
/* 541 */               float f1 = (j >> 16 & 0xFF) / 255.0F;
/* 542 */               float f2 = (j >> 8 & 0xFF) / 255.0F;
/* 543 */               float f3 = (j & 0xFF) / 255.0F;
/* 544 */               GL11.glColor3f(f1, f2, f3);
/*     */             } 
/*     */             
/* 547 */             ResourceLocation rl = new ResourceLocation(((ItemVanity)itemstack.func_77973_b()).getArmorTexture(itemstack, (Entity)pl, 0, ""));
/* 548 */             JRMCoreClient.mc.func_110434_K().func_110577_a(rl);
/*     */ 
/*     */ 
/*     */             
/* 552 */             GL11.glEnable(3042);
/* 553 */             GL11.glBlendFunc(770, 771);
/*     */ 
/*     */ 
/*     */             
/* 557 */             ModelBipedBody m = (ModelBipedBody)((ItemVanity)itemstack.func_77973_b()).giMdl(((ItemVanity)itemstack.func_77973_b()).armorType, (EntityLivingBase)pl);
/*     */             
/* 559 */             if (m != null) {
/* 560 */               m = (ModelBipedBody)JRMCoreHJBRA.showModel((ModelBiped)m, (EntityLivingBase)pl, itemstack, ((ItemVanity)itemstack.func_77973_b()).armorType);
/* 561 */               m.field_78095_p = pl.func_70678_g(event.partialRenderTick);
/* 562 */               m.field_78093_q = pl.func_70115_ae();
/* 563 */               m.field_78091_s = pl.func_70631_g_();
/* 564 */               m.field_78117_n = pl.func_70093_af();
/* 565 */               ModelBipedBody.y = ModelBipedDBC.y;
/* 566 */               m.func_78088_a((Entity)pl, mdl.rot1, mdl.rot2, mdl.rot3, mdl.rot4, mdl.rot5, mdl.rot6);
/* 567 */               GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 573 */       int race = Integer.parseInt(s[0]);
/*     */       
/* 575 */       if (JRMCoreH.isRaceMajin(race)) {
/* 576 */         slot_vanity_num = new String[8][];
/* 577 */         slot_van = new int[8];
/*     */         
/* 579 */         String[] absorptionData = JRMCoreH.data(pl.func_70005_c_(), 13, "0;0;0;0,0,0+0").split(";")[3].split(",")[2].split("-");
/* 580 */         if (absorptionData.length > 0) {
/* 581 */           int j; for (j = 0; j < absorptionData.length; j++) {
/* 582 */             if (absorptionData[j].contains("+")) {
/* 583 */               slot_vanity_num[j] = absorptionData[j].split("\\+");
/* 584 */               slot_van[j] = Integer.parseInt(slot_vanity_num[j][0]);
/*     */             } 
/*     */           } 
/*     */           
/* 588 */           for (j = 0; j < absorptionData.length; j++) {
/* 589 */             if (slot_van[j] > 0) {
/* 590 */               ItemStack itemstack = new ItemStack(Item.func_150899_d(slot_van[j]));
/* 591 */               int bodycol = Integer.parseInt(slot_vanity_num[j][1]);
/*     */               
/* 593 */               if (itemstack != null && itemstack.func_77973_b() instanceof ItemVanity) {
/* 594 */                 ((ItemVanity)itemstack.func_77973_b()).setColor(itemstack, bodycol);
/*     */                 
/* 596 */                 int k = ((ItemVanity)itemstack.func_77973_b()).getColor(itemstack);
/* 597 */                 if (k != -1) {
/* 598 */                   float f1 = (k >> 16 & 0xFF) / 255.0F;
/* 599 */                   float f2 = (k >> 8 & 0xFF) / 255.0F;
/* 600 */                   float f3 = (k & 0xFF) / 255.0F;
/* 601 */                   GL11.glColor3f(f1, f2, f3);
/*     */                 } 
/*     */                 
/* 604 */                 ResourceLocation rl = new ResourceLocation(((ItemVanity)itemstack.func_77973_b()).getArmorTexture(itemstack, (Entity)pl, 0, ""));
/* 605 */                 JRMCoreClient.mc.func_110434_K().func_110577_a(rl);
/*     */ 
/*     */ 
/*     */                 
/* 609 */                 GL11.glEnable(3042);
/* 610 */                 GL11.glBlendFunc(770, 771);
/*     */ 
/*     */ 
/*     */                 
/* 614 */                 ModelBipedBody m = (ModelBipedBody)((ItemVanity)itemstack.func_77973_b()).giMdl(((ItemVanity)itemstack.func_77973_b()).armorType, (EntityLivingBase)pl);
/*     */                 
/* 616 */                 if (m != null) {
/* 617 */                   m = (ModelBipedBody)JRMCoreHJBRA.showModel((ModelBiped)m, (EntityLivingBase)pl, itemstack, ((ItemVanity)itemstack.func_77973_b()).armorType);
/* 618 */                   m.field_78095_p = pl.func_70678_g(event.partialRenderTick);
/* 619 */                   m.field_78093_q = pl.func_70115_ae();
/* 620 */                   m.field_78091_s = pl.func_70631_g_();
/* 621 */                   m.field_78117_n = pl.func_70093_af();
/* 622 */                   ModelBipedBody.y = ModelBipedDBC.y;
/* 623 */                   m.func_78088_a((Entity)pl, mdl.rot1, mdl.rot2, mdl.rot3, mdl.rot4, mdl.rot5, mdl.rot6);
/* 624 */                   GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 634 */       if (JRMCoreH.NC()) {
/*     */         
/* 636 */         byte clientState = JRMCoreH.State;
/* 637 */         if (clientState == 1 && JRMCoreH.isPowerTypeChakra() && JRMCoreH.Class == 1 && JRMCoreHNC.renderHyuuga && JRMCoreH.isPowerTypeChakra(JRMCoreH.PlyrPwr(pl)))
/*     */         {
/* 639 */           if (JRMCoreH.dnn(14) && JRMCoreH.dnn(8) && JRMCoreH.dnn(9) && JRMCoreH.dnn(1) && JRMCoreH.dnn(5)) {
/*     */             
/* 641 */             EntityPlayer player = (EntityPlayer)event.entity;
/* 642 */             int hp = Integer.parseInt(JRMCoreH.data(event.entity.func_70005_c_(), 8, "200"));
/* 643 */             int ki = Integer.parseInt(JRMCoreH.data(event.entity.func_70005_c_(), 9, "200"));
/* 644 */             int[] atr = JRMCoreH.PlyrAttrbtsC((EntityPlayer)event.entity);
/*     */             
/* 646 */             int pwr = Integer.parseInt(s[2]);
/* 647 */             int cls = Integer.parseInt(s[3]);
/* 648 */             int maxhp = JRMCoreH.stat((Entity)player, 2, pwr, 2, atr[2], race, cls, 0.0F);
/* 649 */             int maxki = JRMCoreH.stat((Entity)player, 5, pwr, 5, atr[5], race, cls, 0.0F);
/* 650 */             int align = JRMCoreH.Algnmnt(Integer.parseInt(JRMCoreH.data(event.entity.func_70005_c_(), 5, "50;0").split(";")[0]));
/* 651 */             float mC = maxki;
/* 652 */             float cC = ki;
/* 653 */             float c = cC / mC;
/*     */             
/* 655 */             JRMCoreClient.mc.func_110434_K().func_110577_a(new ResourceLocation(JRMCoreH.tjnc, "misc/cha.png"));
/*     */             
/* 657 */             GL11.glColor4f(1.0F, 1.0F, 1.0F, c);
/* 658 */             GL11.glEnable(3042);
/* 659 */             GL11.glBlendFunc(770, 1);
/* 660 */             GL11.glPushMatrix();
/*     */             
/* 662 */             ModelBipedBody ml = (ModelBipedBody)JRMCoreHJBRA.GiTurtleMdl5;
/*     */             
/* 664 */             ml = (ModelBipedBody)JRMCoreHJBRA.showModel((ModelBiped)ml, (EntityLivingBase)pl, null, 4);
/* 665 */             ml.field_78095_p = pl.func_70678_g(event.partialRenderTick);
/* 666 */             ml.field_78093_q = pl.func_70115_ae();
/* 667 */             ml.field_78091_s = pl.func_70631_g_();
/* 668 */             ml.field_78117_n = pl.func_70093_af();
/* 669 */             ModelBipedBody.y = ModelBipedDBC.y;
/* 670 */             ml.func_78088_a((Entity)pl, mdl.rot1, mdl.rot2, mdl.rot3, mdl.rot4, mdl.rot5, mdl.rot6);
/* 671 */             GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */             
/* 673 */             GL11.glPopMatrix();
/* 674 */             GL11.glDisable(3042);
/*     */           } 
/*     */         }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   @SubscribeEvent
/*     */   public void onEvent(RenderPlayerEvent.SetArmorModel event) {
/* 862 */     ItemStack itemstack = event.stack;
/* 863 */     EntityPlayer player = event.entityPlayer;
/* 864 */     int p_77032_2_ = 3 - event.slot;
/* 865 */     RenderPlayer rend = event.renderer;
/*     */     
/* 867 */     if (itemstack != null) {
/*     */       
/* 869 */       Item item = itemstack.func_77973_b();
/*     */       
/* 871 */       if (item instanceof ItemArmor) {
/*     */         
/* 873 */         ItemArmor itemarmor = (ItemArmor)item;
/*     */         
/* 875 */         JRMCoreClient.mc.func_110434_K().func_110577_a(RenderBiped.getArmorResource((Entity)player, itemstack, p_77032_2_, null));
/*     */ 
/*     */         
/* 878 */         rend.field_77111_i = this.armrMdl2;
/* 879 */         rend.field_77108_b = this.armrMdl;
/*     */         
/* 881 */         ModelBiped modelbiped = (p_77032_2_ == 2) ? rend.field_77111_i : rend.field_77108_b;
/* 882 */         modelbiped = JRMCoreHJBRA.showModel(modelbiped, (EntityLivingBase)player, itemstack, p_77032_2_);
/*     */         
/* 884 */         if (event.renderer instanceof RenderPlayerJBRA) {
/* 885 */           RenderPlayerJBRA r = (RenderPlayerJBRA)event.renderer;
/* 886 */           ModelBipedDBC mdl = r.modelMain;
/* 887 */           if (modelbiped instanceof ModelBipedBody) {
/* 888 */             (ModelBipedBody)modelbiped; ModelBipedBody.y = ModelBipedDBC.y;
/*     */           } 
/*     */         } 
/* 891 */         modelbiped = ForgeHooksClient.getArmorModel((EntityLivingBase)player, itemstack, p_77032_2_, modelbiped);
/* 892 */         rend.func_77042_a((ModelBase)modelbiped);
/* 893 */         modelbiped.field_78095_p = player.func_70678_g(event.partialRenderTick);
/* 894 */         modelbiped.field_78093_q = player.func_70115_ae();
/* 895 */         modelbiped.field_78091_s = player.func_70631_g_();
/* 896 */         modelbiped.field_78117_n = player.func_70093_af();
/*     */ 
/*     */         
/* 899 */         int j = itemarmor.func_82814_b(itemstack);
/* 900 */         if (j != -1) {
/*     */           
/* 902 */           float f1 = (j >> 16 & 0xFF) / 255.0F;
/* 903 */           float f2 = (j >> 8 & 0xFF) / 255.0F;
/* 904 */           float f3 = (j & 0xFF) / 255.0F;
/* 905 */           GL11.glColor3f(f1, f2, f3);
/*     */           
/* 907 */           if (itemstack.func_77948_v()) {
/*     */             
/* 909 */             event.result = 31;
/*     */             
/*     */             return;
/*     */           } 
/* 913 */           event.result = 16;
/*     */           
/*     */           return;
/*     */         } 
/* 917 */         GL11.glColor3f(1.0F, 1.0F, 1.0F);
/*     */         
/* 919 */         if (itemstack.func_77948_v()) {
/*     */           
/* 921 */           event.result = 15;
/*     */           
/*     */           return;
/*     */         } 
/* 925 */         event.result = 1;
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JBRA-Client-v1.6.52.jar!\JinRyuu\JBRA\JBRAEH.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */