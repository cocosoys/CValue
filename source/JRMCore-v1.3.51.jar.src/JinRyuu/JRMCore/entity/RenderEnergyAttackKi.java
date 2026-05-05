/*      */ package JinRyuu.JRMCore.entity;
/*      */ 
/*      */ import JinRyuu.JRMCore.JRMCoreClient;
/*      */ import JinRyuu.JRMCore.JRMCoreH;
/*      */ import JinRyuu.JRMCore.client.JGRenderHelper;
/*      */ import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
/*      */ import cpw.mods.fml.client.FMLClientHandler;
/*      */ import net.minecraft.client.renderer.Tessellator;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.util.MathHelper;
/*      */ import org.lwjgl.opengl.GL11;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class RenderEnergyAttackKi
/*      */   extends RenderEnergyAttack<EntityEnergyAtt>
/*      */ {
/*   21 */   private ModelEnergy ener = new ModelEnergy();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void renderEnergy(EntityEnergyAtt entity, double par2, double par4, double par6, float par8, float par9) {
/*   68 */     this.transparent = false;
/*   69 */     updateEffect(entity);
/*   70 */     byte type = entity.getType();
/*      */ 
/*      */     
/*   73 */     int shrink = entity.getShrink();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*   78 */     float rotation = handleRotationFloat(entity, par9);
/*      */ 
/*      */     
/*   81 */     int color = entity.destroyer ? (JGConfigClientSettings.CLIENT_Ki_3d[type] ? JRMCoreH.techCol[5] : JRMCoreH.techCol4[entity.getCol()]) : JRMCoreH.techCol[entity.getCol()];
/*      */     
/*   83 */     int color2 = entity.destroyer ? (JGConfigClientSettings.CLIENT_Ki_3d[type] ? JRMCoreH.techCol4[entity.getCol()] : JRMCoreH.techCol[entity.getCol()]) : ((entity.getCol2() == -1) ? JRMCoreH.techCol2[entity.getCol()] : JRMCoreH.techCol3[entity.getCol2()]);
/*      */ 
/*      */     
/*   86 */     double sx = entity.strtX(), sy = entity.strtY(), sz = entity.strtZ();
/*   87 */     double x = sx - entity.field_70165_t, y = sy - entity.field_70163_u, z = sz - entity.field_70161_v;
/*      */     
/*   89 */     if (shrink > 0) {
/*      */       
/*   91 */       updateEffect2(entity);
/*      */     }
/*      */     else {
/*      */       
/*   95 */       entity.dist = MathHelper.func_76133_a(x * x + y * y + z * z);
/*   96 */       entity.finalDist = entity.dist;
/*      */     } 
/*      */     
/*   99 */     float scale = entity.getSize() * JGConfigClientSettings.CLIENT_Ki_Scale / 10.0F;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  115 */     this.mode = 0;
/*  116 */     setVisuals(entity, type, (short)0, color, color2, scale, this.mode);
/*  117 */     if (JGConfigClientSettings.CLIENT_Ki_3d[type]) {
/*      */       
/*  119 */       render_3d(entity, par2, par4, par6, par8, par9, scale, sx, sy, sz, color, color2, rotation);
/*      */     }
/*      */     else {
/*      */       
/*  123 */       render_2d(entity, par2, par4, par6, par8, par9, scale, sx, sy, sz, color, color2, rotation);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateEffect(EntityEnergyAtt entity) {
/*  130 */     if (!JRMCoreClient.mc.func_147113_T()) {
/*      */       
/*  132 */       if (!entity.added) {
/*      */         
/*  134 */         entity.animation_id++;
/*  135 */         entity.animation_start = System.nanoTime() / 10000000L;
/*  136 */         entity.added = true;
/*  137 */         if (entity.render_scale < entity.render_scale_max) entity.render_scale += entity.render_scale_max / 10.0F; 
/*  138 */         if (entity.render_scale > entity.render_scale_max) entity.render_scale = entity.render_scale_max;
/*      */         
/*  140 */         if (this.random_texture && entity.animation_random != null) {
/*      */           
/*  142 */           int size = entity.animation_random.size();
/*  143 */           entity.animation_random.clear();
/*  144 */           for (int i = 0; i < size; i++)
/*      */           {
/*  146 */             entity.animation_random.add(Integer.valueOf((int)(Math.random() * entity.animation_random_Max)));
/*      */           }
/*      */         } 
/*      */       } 
/*  150 */       if (entity.animation_id >= entity.animation_id_Max) entity.animation_id = 0; 
/*  151 */       if (System.nanoTime() / 10000000L - entity.animation_start > entity.animation_speed) entity.added = false;
/*      */     
/*      */     } 
/*      */   }
/*      */   
/*      */   public void updateEffect2(EntityEnergyAtt entity) {
/*  157 */     if (!JRMCoreClient.mc.func_147113_T()) {
/*      */       
/*  159 */       if (!entity.added2) {
/*      */         
/*  161 */         entity.animation_start2 = System.nanoTime() / 10000000L;
/*  162 */         entity.added2 = true;
/*      */ 
/*      */         
/*  165 */         if (entity.isShield() || entity.isExplosion()) {
/*      */           
/*  167 */           entity.waveScale = 0.3F;
/*      */         }
/*      */         else {
/*      */           
/*  171 */           float shrinking = (float)entity.finalDist / 500.0F;
/*      */           
/*  173 */           double d = entity.dist - (entity.getSpe() * shrinking);
/*  174 */           entity.dist = (d < 0.0D) ? 0.0D : d;
/*  175 */           float egy = (float)entity.finalDist / 100.0F;
/*  176 */           float current = (float)entity.dist / egy / 100.0F;
/*      */           
/*  178 */           entity.waveScale = current;
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  185 */       if (System.nanoTime() / 10000000L - entity.animation_start2 > 1L) entity.added2 = false;
/*      */     
/*      */     } 
/*      */   }
/*      */   
/*      */   public void setVisuals(EntityEnergyAtt entity, byte type, short effect, int color, int color2, float scale, byte mode) {
/*  191 */     float scale_all = scale;
/*      */     
/*  193 */     entity.animation_id_Max = 1;
/*  194 */     entity.animation_random_Max = 1;
/*  195 */     entity.animation_speed = 7;
/*      */ 
/*      */ 
/*      */     
/*  199 */     this.rendermode_tail = 0;
/*  200 */     this.render_head = true; this.render_head_connect = true;
/*  201 */     this.render_middle = true; this.render_noise = true;
/*  202 */     this.render_tail = true; this.render_tail_connect = true;
/*      */     
/*  204 */     this.rotate_head = true; this.rotate_head_connect = true;
/*  205 */     this.rotate_middle = true; this.rotate_noise = true;
/*  206 */     this.rotate_tail = true; this.rotate_tail_connect = true;
/*      */     
/*  208 */     this.scaling_head = true; this.scaling_tail = true;
/*  209 */     this.scale_head_more = 0.0F; this.scale_tail_more = 0.0F;
/*      */     
/*  211 */     this.head_follow = false; this.tail_follow = false;
/*      */     
/*  213 */     this.random_texture = false;
/*      */ 
/*      */     
/*  216 */     this.rotationSpeed = 40.0F;
/*  217 */     this.modifierTranslation = entity.dist / 2.0D + (scale_all * 1.0F / scale_all);
/*  218 */     this.detail = 4;
/*  219 */     this.brightness = 200;
/*  220 */     this.alpha = 1.0F * JGConfigClientSettings.CLIENT_Ki_Visibility / 10.0F;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  225 */     if (this.mode == 0) {
/*      */ 
/*      */ 
/*      */       
/*  229 */       setColors(color, this.alpha);
/*  230 */       setColors2(color2);
/*  231 */       this.texture = (entity.destroyer ? "dbc_god/" : "dbc/") + this.texture_type[type] + "/";
/*      */       
/*  233 */       if (entity.isWave()) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  241 */         this.render_middle = false;
/*  242 */         this.scaling_head = false; this.scaling_tail = false;
/*  243 */         this.head_follow = true; this.tail_follow = true;
/*  244 */         this.scale_tail_more = 0.1F;
/*      */       }
/*  246 */       else if (entity.isBlast()) {
/*      */         
/*  248 */         scale_all *= 0.5F;
/*  249 */         this.render_head = false; this.render_head_connect = false;
/*  250 */         this.render_middle = false; this.render_noise = false;
/*  251 */         this.render_tail = true; this.render_tail_connect = true;
/*  252 */         this.scaling_head = false; this.scaling_tail = false;
/*  253 */         this.head_follow = false; this.tail_follow = true;
/*      */         
/*  255 */         this.rendermode_tail = 2;
/*      */       }
/*  257 */       else if (entity.isDisk()) {
/*      */ 
/*      */         
/*  260 */         this.rendermode_tail = 1;
/*  261 */         this.render_head = false; this.render_head_connect = false;
/*  262 */         this.render_middle = false; this.render_noise = false;
/*  263 */         this.render_tail = true; this.render_tail_connect = false;
/*  264 */         this.scaling_head = false; this.scaling_tail = false;
/*      */       }
/*  266 */       else if (entity.isLaser()) {
/*      */         
/*  268 */         scale_all *= 0.5F;
/*  269 */         this.render_middle = false;
/*  270 */         this.head_follow = true; this.tail_follow = true;
/*  271 */         this.scaling_head = false; this.scaling_tail = false;
/*  272 */         this.scale_tail_more = 0.15F;
/*      */       }
/*  274 */       else if (entity.isLargeBlast()) {
/*      */         
/*  276 */         this.render_head = false; this.render_head_connect = false;
/*  277 */         this.render_middle = false; this.render_noise = false;
/*  278 */         this.render_tail = true; this.render_tail_connect = true;
/*  279 */         this.scaling_head = false; this.scaling_tail = false;
/*  280 */         this.head_follow = false; this.tail_follow = true;
/*      */         
/*  282 */         this.rendermode_tail = 2;
/*      */       }
/*  284 */       else if (entity.isSpiral()) {
/*      */         
/*  286 */         this.head_follow = true; this.tail_follow = true;
/*  287 */         scale_all *= 0.5F;
/*  288 */         this.scaling_head = false; this.scaling_tail = false;
/*  289 */         this.scale_tail_more = 0.15F;
/*      */       }
/*  291 */       else if (entity.isBarrage()) {
/*      */         
/*  293 */         scale_all *= 0.25F;
/*  294 */         this.render_head = false; this.render_head_connect = false;
/*  295 */         this.render_middle = false; this.render_noise = false;
/*  296 */         this.render_tail = true; this.render_tail_connect = true;
/*  297 */         this.scaling_head = false; this.scaling_tail = false;
/*  298 */         this.head_follow = false; this.tail_follow = true;
/*      */         
/*  300 */         this.rendermode_tail = 2;
/*      */       }
/*  302 */       else if (entity.isShield()) {
/*      */         
/*  304 */         this.render_head = false; this.render_head_connect = false;
/*  305 */         this.render_middle = false; this.render_noise = false;
/*  306 */         this.render_tail = true; this.render_tail_connect = false;
/*  307 */         this.scaling_head = false; this.scaling_tail = false;
/*  308 */         this.tail_follow = true;
/*  309 */         this.rendermode_tail = 2;
/*  310 */         this.transparent = true;
/*      */       }
/*  312 */       else if (entity.isExplosion()) {
/*      */         
/*  314 */         this.render_head = false; this.render_head_connect = false;
/*  315 */         this.render_middle = false; this.render_noise = false;
/*  316 */         this.render_tail = true; this.render_tail_connect = false;
/*  317 */         this.scaling_head = false; this.scaling_tail = false;
/*  318 */         this.tail_follow = true;
/*  319 */         this.rendermode_tail = 2;
/*  320 */         this.transparent = true;
/*      */       } 
/*      */     } 
/*      */     
/*  324 */     this.scale_head = 1.0F * scale_all * (1.0F + this.scale_head_more) * entity.waveScale;
/*  325 */     this.scale_head_connect = 1.0F * scale_all * entity.waveScale;
/*  326 */     this.scale_middle = 1.0F * scale_all * entity.waveScale;
/*  327 */     this.scale_noise = 1.0F * scale_all * entity.waveScale;
/*  328 */     this.scale_tail = 1.0F * scale_all * (1.0F + scale_all * this.scale_tail_more);
/*  329 */     this.scale_tail_connect = 1.0F * scale_all * entity.waveScale;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void render_2d(EntityEnergyAtt entity, double par2, double par4, double par6, float par8, float par9, float scale, double sx, double sy, double sz, int color, int color2, float rotation) {
/*  338 */     Tessellator tessellator = Tessellator.field_78398_a;
/*  339 */     long time = entity.field_70170_p.func_82737_E();
/*  340 */     float particleScale = 1.0F;
/*      */ 
/*      */     
/*  343 */     float middle_start = 0.4F, middle_max = 10.0F;
/*      */ 
/*      */ 
/*      */     
/*  347 */     glStart();
/*      */     
/*  349 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  350 */     GL11.glDepthMask(true);
/*  351 */     GL11.glDisable(2896);
/*      */     
/*  353 */     if (this.transparent) {
/*      */       
/*  355 */       GL11.glEnable(3042);
/*  356 */       GL11.glBlendFunc(770, 771);
/*  357 */       GL11.glAlphaFunc(516, 0.003921569F);
/*  358 */       GL11.glDepthMask(false);
/*      */     } 
/*      */     
/*  361 */     float X = 0.0F, Y = 0.0F, Z = 0.0F;
/*      */     
/*  363 */     float position = entity.waveScale;
/*  364 */     position *= position;
/*  365 */     X = (float)(-(entity.field_70165_t - sx) * 0.5D) * position;
/*  366 */     Y = (float)(-(entity.field_70163_u - sy) * 0.5D) * position;
/*  367 */     Z = (float)(-(entity.field_70161_v - sz) * 0.5D) * position;
/*  368 */     if (X == 0.0F) X = 0.0F;  if (Y == 0.0F) Y = 0.0F;  if (Z == 0.0F) Z = 0.0F;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  393 */     glRotate(entity, par2 + X, par4 + Y, par6 + Z, par9);
/*      */     
/*  395 */     GL11.glRotated(90.0D, 1.0D, 0.0D, 0.0D);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  411 */     float particleMiddleWidth = 1.0F;
/*  412 */     float wave_start_size = 1.0F;
/*  413 */     float wave_end_size = 1.0F;
/*  414 */     int texture_id = 0;
/*      */ 
/*      */ 
/*      */     
/*  418 */     if (this.render_middle) {
/*      */       
/*  420 */       for (int i = 0; i < this.detail; i++)
/*      */       {
/*  422 */         float maxSize = 2.32F * particleScale;
/*  423 */         float correction = 0.86F;
/*  424 */         float scl = (float)entity.dist;
/*  425 */         int segments = (int)(scl / maxSize * 0.86F);
/*      */ 
/*      */         
/*  428 */         float div = segments / 10.0F;
/*  429 */         float size_divider = this.scaling_tail ? ((div < 5.0F) ? 5.0F : div) : 5.0F;
/*  430 */         float max_size = 10.0F;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  437 */         GL11.glPushMatrix();
/*  438 */         GL11.glTranslatef(0.001F, 0.0F, 0.001F);
/*  439 */         apply_detail_rotation(i);
/*      */         
/*  441 */         float Translate_middle = -1.0F;
/*  442 */         GL11.glTranslatef(0.0F, -1.0F, 0.0F);
/*      */         
/*  444 */         if (this.rotate_middle)
/*      */         {
/*  446 */           GL11.glRotatef((float)time % 360.0F / this.rotationSpeed * this.rotationSpeed * 1.0F + this.rotationSpeed * par9, 0.0F, 1.0F, 0.0F);
/*      */         }
/*      */         
/*  449 */         for (int k = 0; k < segments + 1; k++) {
/*      */           
/*  451 */           float size = 1.0F;
/*  452 */           if (this.scaling_tail) {
/*      */             
/*  454 */             size = k / size_divider + 0.4F;
/*  455 */             if (size > 10.0F) size = 10.0F; 
/*  456 */             particleMiddleWidth = size;
/*  457 */             if (particleMiddleWidth > wave_end_size) wave_end_size = particleMiddleWidth; 
/*  458 */             if (k == 0) wave_start_size = size; 
/*      */           } 
/*  460 */           if (this.random_texture && entity.animation_random != null) {
/*      */             
/*  462 */             if (entity.animation_random.size() > k)
/*      */             {
/*  464 */               texture_id = ((Integer)entity.animation_random.get(k)).intValue();
/*      */             }
/*      */             else
/*      */             {
/*  468 */               entity.animation_random.add(Integer.valueOf((int)(Math.random() * entity.animation_random_Max)));
/*      */             }
/*      */           
/*      */           } else {
/*      */             
/*  473 */             texture_id = entity.animation_id % entity.animation_id_Max;
/*      */           } 
/*  475 */           (FMLClientHandler.instance().getClient()).field_71446_o.func_110577_a(set_resource("middle", texture_id));
/*  476 */           double length = entity.dist;
/*  477 */           if (length > maxSize) length = maxSize; 
/*  478 */           double minus = (-scl / 2.0F + (segments - k) * maxSize * 0.86F);
/*      */           
/*  480 */           float height = 1.0F;
/*  481 */           float height2 = 0.0F;
/*  482 */           if (k == 0) {
/*      */             
/*  484 */             float scale0 = (float)(segments - minus);
/*  485 */             if (scale0 < 0.0F) scale0 = 0.0F; 
/*  486 */             height = scale0;
/*  487 */             if (height > 1.0F) height = 1.0F; 
/*  488 */             height2 = height;
/*  489 */             minus += -(1.0F - height2);
/*      */           } 
/*  491 */           JGRenderHelper.draw_tessellator(tessellator, this.brightness, particleScale * particleMiddleWidth * this.scale_middle, 0.0F, particleScale * height, (float)-minus, this.red2, this.green2, this.blue2, this.alpha);
/*      */         } 
/*      */ 
/*      */         
/*  495 */         if (segments > entity.lastSegments) entity.lastSegments = segments; 
/*  496 */         if (segments < entity.lastSegments) {
/*      */           
/*  498 */           float size = 1.0F;
/*  499 */           if (this.scaling_tail) {
/*      */             
/*  501 */             size = entity.lastSegments / size_divider + 0.4F;
/*  502 */             if (size > 10.0F) size = 10.0F; 
/*  503 */             particleMiddleWidth = size;
/*  504 */             if (particleMiddleWidth > wave_end_size) wave_end_size = particleMiddleWidth;
/*      */           
/*      */           } 
/*      */         } 
/*  508 */         GL11.glPopMatrix();
/*      */       
/*      */       }
/*      */     
/*      */     }
/*  513 */     else if (this.scaling_tail) {
/*      */       
/*  515 */       float maxSize = 2.32F * particleScale;
/*  516 */       float correction = 0.86F;
/*  517 */       float scl = (float)entity.dist;
/*  518 */       int segments = (int)(scl / maxSize * 0.86F);
/*      */       
/*  520 */       float div = segments / 10.0F;
/*  521 */       float size_divider = this.scaling_tail ? ((div < 5.0F) ? 5.0F : div) : 5.0F;
/*  522 */       float max_size = 10.0F;
/*      */ 
/*      */       
/*  525 */       float size = 0.0F / size_divider + 0.4F;
/*  526 */       if (size > 10.0F) size = 10.0F; 
/*  527 */       particleMiddleWidth = size;
/*  528 */       wave_start_size = size;
/*      */ 
/*      */ 
/*      */       
/*  532 */       size = segments / size_divider + 0.4F;
/*  533 */       if (size > 10.0F) size = 10.0F; 
/*  534 */       particleMiddleWidth = size;
/*  535 */       if (particleMiddleWidth > wave_end_size) wave_end_size = particleMiddleWidth;
/*      */     
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  542 */     if (this.render_noise)
/*      */     {
/*      */ 
/*      */       
/*  546 */       for (int i = 0; i < this.detail; i++) {
/*      */         
/*  548 */         GL11.glPushMatrix();
/*      */         
/*  550 */         if (this.rotate_noise)
/*      */         {
/*  552 */           GL11.glRotatef((float)time % 360.0F / this.rotationSpeed * this.rotationSpeed * 1.0F + this.rotationSpeed * par9, 0.0F, 1.0F, 0.0F);
/*      */         }
/*  554 */         texture_id = entity.animation_id % entity.animation_id_Max;
/*  555 */         (FMLClientHandler.instance().getClient()).field_71446_o.func_110577_a(set_resource("noise", texture_id));
/*  556 */         apply_detail_rotation(i);
/*  557 */         JGRenderHelper.draw_tessellator2(tessellator, this.brightness, particleScale * this.scale_noise, 0.0F, (float)(entity.dist / 2.0D), 0.0F, this.red, this.green, this.blue, this.alpha);
/*      */         
/*  559 */         GL11.glPopMatrix();
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  567 */     if (this.render_head)
/*      */     {
/*  569 */       if (!this.head_follow) {
/*      */         
/*  571 */         for (int i = 0; i < 2; i++)
/*      */         {
/*  573 */           GL11.glPushMatrix();
/*      */           
/*  575 */           if (this.rotate_head)
/*      */           {
/*  577 */             GL11.glRotatef((float)time % 360.0F / this.rotationSpeed * this.rotationSpeed * 1.0F + this.rotationSpeed * par9, 0.0F, 1.0F, 0.0F);
/*      */           }
/*  579 */           GL11.glTranslated(0.0D, -this.modifierTranslation, 0.0D);
/*      */           
/*  581 */           texture_id = entity.animation_id % entity.animation_id_Max;
/*  582 */           (FMLClientHandler.instance().getClient()).field_71446_o.func_110577_a(set_resource("head", texture_id));
/*  583 */           GL11.glRotated(-90.0D, 1.0D, 0.0D, 0.0D);
/*  584 */           GL11.glRotatef((i * 360 / 2), 0.0F, 1.0F, 0.0F);
/*  585 */           JGRenderHelper.draw_tessellator(tessellator, this.brightness, particleScale * (this.scaling_head ? wave_start_size : 1.0F) * this.scale_head, particleScale * (this.scaling_head ? wave_start_size : 1.0F) * this.scale_head, this.red, this.green, this.blue, this.alpha);
/*      */           
/*  587 */           GL11.glPopMatrix();
/*      */         }
/*      */       
/*      */       } else {
/*      */         
/*  592 */         GL11.glPushMatrix();
/*  593 */         GL11.glTranslated(0.0D, -this.modifierTranslation, 0.0D);
/*  594 */         float rotationX = entity.field_70127_C + (entity.field_70125_A - entity.field_70127_C) * par9;
/*  595 */         GL11.glRotatef(rotationX, -1.0F, 0.0F, 0.0F);
/*  596 */         float rotationY = entity.field_70126_B + (entity.field_70177_z - entity.field_70126_B) * par9 - 180.0F;
/*  597 */         GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/*  598 */         GL11.glRotatef(rotationY, 0.0F, 0.0F, -1.0F);
/*  599 */         boolean view2 = (JRMCoreClient.mc.field_71474_y.field_74320_O == 2);
/*  600 */         GL11.glRotatef(-this.field_76990_c.field_78735_i, 0.0F, 0.0F, 1.0F);
/*  601 */         GL11.glRotatef(-this.field_76990_c.field_78732_j * (view2 ? -1 : true), 1.0F, 0.0F, 0.0F);
/*  602 */         texture_id = entity.animation_id % entity.animation_id_Max;
/*  603 */         (FMLClientHandler.instance().getClient()).field_71446_o.func_110577_a(set_resource("head", texture_id));
/*      */         
/*  605 */         GL11.glRotated(-90.0D, 1.0D, 0.0D, 0.0D);
/*  606 */         if (this.rotate_head)
/*      */         {
/*  608 */           GL11.glRotatef((float)time % 360.0F / this.rotationSpeed * this.rotationSpeed * 1.0F + this.rotationSpeed * par9, 0.0F, 0.0F, 1.0F);
/*      */         }
/*  610 */         JGRenderHelper.draw_tessellator(tessellator, this.brightness, particleScale * (this.scaling_head ? wave_start_size : 1.0F) * this.scale_head, particleScale * (this.scaling_head ? wave_start_size : 1.0F) * this.scale_head, this.red, this.green, this.blue, this.alpha);
/*      */         
/*  612 */         GL11.glPopMatrix();
/*      */       } 
/*      */     }
/*  615 */     if (this.render_head_connect)
/*      */     {
/*  617 */       for (int i = 0; i < this.detail; i++) {
/*      */         
/*  619 */         GL11.glPushMatrix();
/*      */         
/*  621 */         if (this.rotate_head_connect)
/*      */         {
/*  623 */           GL11.glRotatef((float)time % 360.0F / this.rotationSpeed * this.rotationSpeed * 1.0F + this.rotationSpeed * par9, 0.0F, 1.0F, 0.0F);
/*      */         }
/*  625 */         GL11.glTranslated(0.0D, -this.modifierTranslation, 0.0D);
/*  626 */         texture_id = entity.animation_id % entity.animation_id_Max;
/*  627 */         (FMLClientHandler.instance().getClient()).field_71446_o.func_110577_a(set_resource("head_connect", texture_id));
/*  628 */         apply_detail_rotation(i);
/*  629 */         JGRenderHelper.draw_tessellator(tessellator, this.brightness, particleScale * (this.scaling_head ? wave_start_size : 1.0F) * this.scale_head_connect, particleScale, this.red, this.green, this.blue, this.alpha);
/*      */         
/*  631 */         GL11.glPopMatrix();
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  654 */     if (this.render_tail)
/*      */     {
/*  656 */       if ((this.rendermode_tail == 0 && !this.tail_follow) || (this.rendermode_tail == 2 && !this.tail_follow)) {
/*      */         
/*  658 */         for (int i = 0; i < 2; i++)
/*      */         {
/*  660 */           GL11.glPushMatrix();
/*  661 */           if (this.rendermode_tail == 2) {
/*      */             
/*  663 */             GL11.glTranslated(0.0D, -1.0D, 0.0D);
/*  664 */             GL11.glTranslated(0.0D, 0.0D, 0.25D);
/*      */           } 
/*  666 */           if (this.rotate_tail)
/*      */           {
/*  668 */             GL11.glRotatef((float)time % 360.0F / this.rotationSpeed * this.rotationSpeed * 1.0F + this.rotationSpeed * par9, 0.0F, 1.0F, 0.0F);
/*      */           }
/*  670 */           GL11.glTranslated(0.0D, this.modifierTranslation, 0.0D);
/*  671 */           texture_id = entity.animation_id % entity.animation_id_Max;
/*  672 */           (FMLClientHandler.instance().getClient()).field_71446_o.func_110577_a(set_resource("tail", texture_id));
/*  673 */           GL11.glRotated(-90.0D, 1.0D, 0.0D, 0.0D);
/*  674 */           GL11.glRotatef((i * 360 / 2), 0.0F, 1.0F, 0.0F);
/*  675 */           JGRenderHelper.draw_tessellator(tessellator, this.brightness, particleScale * wave_end_size * this.scale_tail, particleScale * wave_end_size * this.scale_tail, this.red, this.green, this.blue, this.alpha);
/*      */           
/*  677 */           GL11.glPopMatrix();
/*      */         }
/*      */       
/*  680 */       } else if ((this.rendermode_tail == 0 && this.tail_follow) || (this.rendermode_tail == 2 && this.tail_follow)) {
/*      */         
/*  682 */         GL11.glPushMatrix();
/*  683 */         GL11.glTranslated(0.0D, this.modifierTranslation, 0.0D);
/*  684 */         if (this.rendermode_tail == 2) {
/*      */           
/*  686 */           GL11.glTranslated(0.0D, -1.0D, 0.0D);
/*  687 */           GL11.glTranslated(0.0D, 0.0D, 0.25D);
/*      */         } 
/*  689 */         float rotationX = entity.field_70127_C + (entity.field_70125_A - entity.field_70127_C) * par9;
/*  690 */         GL11.glRotatef(rotationX, -1.0F, 0.0F, 0.0F);
/*  691 */         float rotationY = entity.field_70126_B + (entity.field_70177_z - entity.field_70126_B) * par9 - 180.0F;
/*  692 */         GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/*  693 */         GL11.glRotatef(rotationY, 0.0F, 0.0F, -1.0F);
/*  694 */         boolean view2 = (JRMCoreClient.mc.field_71474_y.field_74320_O == 2);
/*  695 */         GL11.glRotatef(-this.field_76990_c.field_78735_i, 0.0F, 0.0F, 1.0F);
/*  696 */         GL11.glRotatef(-this.field_76990_c.field_78732_j * (view2 ? -1 : true), 1.0F, 0.0F, 0.0F);
/*  697 */         texture_id = entity.animation_id % entity.animation_id_Max;
/*  698 */         (FMLClientHandler.instance().getClient()).field_71446_o.func_110577_a(set_resource("tail", texture_id));
/*      */         
/*  700 */         GL11.glRotated(-90.0D, 1.0D, 0.0D, 0.0D);
/*  701 */         if (this.rotate_tail)
/*      */         {
/*  703 */           GL11.glRotatef((float)time % 360.0F / this.rotationSpeed * this.rotationSpeed * 1.0F + this.rotationSpeed * par9, 0.0F, 0.0F, 1.0F);
/*      */         }
/*  705 */         JGRenderHelper.draw_tessellator(tessellator, this.brightness, particleScale * wave_end_size * this.scale_tail, particleScale * wave_end_size * this.scale_tail, this.red, this.green, this.blue, this.alpha);
/*      */         
/*  707 */         GL11.glPopMatrix();
/*      */       }
/*  709 */       else if (this.rendermode_tail == 1) {
/*      */         
/*  711 */         for (int j = 0; j < scale * 5.0F; j++) {
/*      */           
/*  713 */           for (int i = 0; i < 2; i++) {
/*      */             
/*  715 */             GL11.glPushMatrix();
/*  716 */             GL11.glTranslated(0.0D, -1.0D, 0.0D);
/*  717 */             GL11.glTranslated(0.0D, 0.0D, 0.25D);
/*  718 */             GL11.glTranslated(0.0D, 0.0D, j * 0.01D);
/*  719 */             GL11.glTranslated(0.0D, this.modifierTranslation, 0.0D);
/*      */             
/*  721 */             if (this.rotate_tail)
/*      */             {
/*  723 */               GL11.glRotatef((float)time % 360.0F / this.rotationSpeed * this.rotationSpeed * 1.0F + this.rotationSpeed * par9, 0.0F, 0.0F, 1.0F);
/*      */             }
/*  725 */             texture_id = entity.animation_id % entity.animation_id_Max;
/*  726 */             (FMLClientHandler.instance().getClient()).field_71446_o.func_110577_a(set_resource("tail", texture_id));
/*      */             
/*  728 */             GL11.glRotatef((i * 360 / 2), 0.0F, 1.0F, 0.0F);
/*  729 */             JGRenderHelper.draw_tessellator(tessellator, this.brightness, particleScale * wave_end_size * this.scale_tail, particleScale * wave_end_size * this.scale_tail, this.red, this.green, this.blue, this.alpha);
/*      */             
/*  731 */             GL11.glPopMatrix();
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     }
/*  736 */     if (this.render_tail_connect)
/*      */     {
/*  738 */       for (int i = 0; i < this.detail; i++) {
/*      */         
/*  740 */         GL11.glPushMatrix();
/*      */         
/*  742 */         if (this.rendermode_tail == 2) {
/*      */           
/*  744 */           GL11.glTranslated(0.0D, -1.0D, 0.0D);
/*  745 */           GL11.glTranslated(0.0D, 0.0D, 0.25D);
/*      */         } 
/*  747 */         if (this.rotate_tail_connect)
/*      */         {
/*  749 */           GL11.glRotatef((float)time % 360.0F / this.rotationSpeed * this.rotationSpeed * 1.0F + this.rotationSpeed * par9, 0.0F, 1.0F, 0.0F);
/*      */         }
/*  751 */         GL11.glTranslated(0.0D, this.modifierTranslation, 0.0D);
/*  752 */         texture_id = entity.animation_id % entity.animation_id_Max;
/*  753 */         (FMLClientHandler.instance().getClient()).field_71446_o.func_110577_a(set_resource("tail_connect", texture_id));
/*  754 */         apply_detail_rotation(i);
/*  755 */         JGRenderHelper.draw_tessellator(tessellator, this.brightness, particleScale * wave_end_size * this.scale_tail_connect, particleScale * ((this.rendermode_tail == 2) ? this.scale_tail_connect : 1.0F), this.red, this.green, this.blue, this.alpha);
/*      */         
/*  757 */         GL11.glPopMatrix();
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*  762 */     if (this.transparent) {
/*      */       
/*  764 */       GL11.glDisable(3042);
/*  765 */       GL11.glDepthMask(true);
/*      */     } 
/*      */     
/*  768 */     GL11.glEnable(2896);
/*  769 */     glEnd();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void render_3d(EntityEnergyAtt entity, double par2, double par4, double par6, float par8, float par9, float scale, double sx, double sy, double sz, int color, int color2, float rotation) {
/*  777 */     this.field_76989_e = 0.0F;
/*  778 */     int shrink = entity.getShrink();
/*  779 */     byte type = entity.getType();
/*  780 */     byte perc = entity.getPerc();
/*  781 */     int dam = entity.getDam();
/*  782 */     byte[] sts = entity.getSts();
/*  783 */     byte den = entity.getDen();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  789 */     float var13 = handleRotationFloat(entity, par9);
/*      */ 
/*      */ 
/*      */     
/*  793 */     double x = sx - entity.field_70165_t;
/*  794 */     double y = sy - entity.field_70163_u;
/*  795 */     double z = sz - entity.field_70161_v;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  800 */     if (shrink > 0) {
/*      */       
/*  802 */       updateEffect2(entity);
/*      */     }
/*      */     else {
/*      */       
/*  806 */       entity.dist = MathHelper.func_76133_a(x * x + y * y + z * z);
/*  807 */       entity.finalDist = entity.dist;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  821 */     float size = entity.getSize() * JGConfigClientSettings.CLIENT_Ki_Scale / 10.0F;
/*      */ 
/*      */ 
/*      */     
/*  825 */     boolean dual_color = JGConfigClientSettings.CLIENT_DA9;
/*  826 */     if (type == 1 || type == 5 || type == 6) {
/*      */       
/*  828 */       GL11.glPushMatrix();
/*      */       
/*  830 */       JRMCoreClient.mc.field_71460_t.func_78483_a(0.0D);
/*  831 */       GL11.glDisable(2896);
/*  832 */       GL11.glBlendFunc(770, 1);
/*      */ 
/*      */       
/*  835 */       GL11.glTranslatef((float)par2, (float)par4, (float)par6);
/*  836 */       GL11.glRotatef(entity.field_70126_B + (entity.field_70177_z - entity.field_70126_B) * par9 - 180.0F, 0.0F, 1.0F, 0.0F);
/*  837 */       GL11.glRotatef(entity.field_70127_C + (entity.field_70125_A - entity.field_70127_C) * par9, 1.0F, 0.0F, 0.0F);
/*  838 */       GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
/*  839 */       JGRenderHelper.tex(this.field_76990_c, color, this.alpha);
/*  840 */       GL11.glScalef(size, size, size);
/*  841 */       if (dual_color) GL11.glDepthMask(false); 
/*  842 */       this.ener.renderModel((byte)1, entity, 0.0F, 0.0F, 0.0625F, var13, false);
/*      */       
/*  844 */       if (dual_color) {
/*  845 */         JGRenderHelper.tex(this.field_76990_c, color2, this.alpha);
/*  846 */         GL11.glScalef(0.8F, 0.8F, 0.8F);
/*  847 */         this.ener.renderModel((byte)1, entity, 0.0F, 0.0F, 0.0625F, var13, false);
/*      */       } 
/*      */ 
/*      */       
/*  851 */       GL11.glEnable(2896);
/*  852 */       JRMCoreClient.mc.field_71460_t.func_78463_b(0.0D);
/*  853 */       if (dual_color) GL11.glDepthMask(true); 
/*  854 */       GL11.glPopMatrix();
/*      */     } 
/*      */     
/*  857 */     if (type == 7 || type == 8) {
/*      */       
/*  859 */       GL11.glPushMatrix();
/*      */       
/*  861 */       float szaz = 120.0F;
/*  862 */       float egy = szaz / 100.0F;
/*  863 */       float offtr = entity.field_70173_aa / egy / 100.0F;
/*  864 */       offtr = 1.0F - offtr;
/*  865 */       offtr /= 10.0F;
/*      */ 
/*      */       
/*  868 */       GL11.glEnable(3042);
/*  869 */       GL11.glDisable(2896);
/*  870 */       GL11.glBlendFunc(770, 771);
/*  871 */       GL11.glAlphaFunc(516, 0.003921569F);
/*  872 */       GL11.glDepthMask(false);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  877 */       GL11.glTranslatef((float)par2, (float)par4, (float)par6);
/*  878 */       GL11.glRotatef(entity.field_70126_B + (entity.field_70177_z - entity.field_70126_B) * par9 - 180.0F, 0.0F, 1.0F, 0.0F);
/*  879 */       GL11.glRotatef(entity.field_70127_C + (entity.field_70125_A - entity.field_70127_C) * par9, 1.0F, 0.0F, 0.0F);
/*  880 */       GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
/*      */       
/*  882 */       float alph = (type == 7) ? 0.05F : offtr;
/*      */       
/*  884 */       JGRenderHelper.tex(this.field_76990_c, color, alph);
/*      */ 
/*      */ 
/*      */       
/*  888 */       GL11.glScalef(size, size, size);
/*  889 */       if (dual_color) GL11.glDepthMask(false); 
/*  890 */       this.ener.renderModel((byte)1, entity, 0.0F, 0.0F, 0.0625F, var13 / 2.0F, false);
/*      */       
/*  892 */       if (dual_color) {
/*      */         
/*  894 */         JGRenderHelper.tex(this.field_76990_c, color, alph);
/*  895 */         GL11.glScalef(0.8F, 0.8F, 0.8F);
/*  896 */         this.ener.renderModel((byte)1, entity, 0.0F, 0.0F, 0.0625F, var13 / 2.0F, false);
/*      */       } 
/*  898 */       GL11.glDisable(3042);
/*  899 */       GL11.glEnable(2896);
/*  900 */       JRMCoreClient.mc.field_71460_t.func_78463_b(0.0D);
/*  901 */       if (dual_color) GL11.glDepthMask(true); 
/*  902 */       GL11.glPopMatrix();
/*      */     } 
/*      */     
/*  905 */     if (type == 2) {
/*      */       
/*  907 */       GL11.glPushMatrix();
/*  908 */       JRMCoreClient.mc.field_71460_t.func_78483_a(0.0D);
/*  909 */       GL11.glDisable(2896);
/*  910 */       GL11.glBlendFunc(770, 1);
/*      */ 
/*      */       
/*  913 */       GL11.glTranslatef((float)par2, (float)par4, (float)par6);
/*  914 */       GL11.glRotatef(entity.field_70126_B + (entity.field_70177_z - entity.field_70126_B) * par9 - 180.0F, 0.0F, 1.0F, 0.0F);
/*  915 */       GL11.glRotatef(entity.field_70127_C + (entity.field_70125_A - entity.field_70127_C) * par9, 1.0F, 0.0F, 0.0F);
/*  916 */       GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
/*  917 */       JGRenderHelper.tex(this.field_76990_c, color, this.alpha);
/*  918 */       GL11.glScalef(size, size, size);
/*  919 */       if (dual_color) GL11.glDepthMask(false); 
/*  920 */       this.ener.renderModel(type, entity, 0.0F, 0.0F, 0.0625F, var13, false);
/*  921 */       if (dual_color) {
/*  922 */         JGRenderHelper.tex(this.field_76990_c, color2, this.alpha);
/*  923 */         GL11.glScalef(0.8F, 0.8F, 0.8F);
/*  924 */         this.ener.renderModel(type, entity, 0.0F, 0.0F, 0.0625F, var13, false);
/*      */       } 
/*      */       
/*  927 */       GL11.glEnable(2896);
/*  928 */       JRMCoreClient.mc.field_71460_t.func_78463_b(0.0D);
/*  929 */       if (dual_color) GL11.glDepthMask(true); 
/*  930 */       GL11.glPopMatrix();
/*      */     } 
/*      */     
/*  933 */     if (type == 3) {
/*      */       
/*  935 */       GL11.glPushMatrix();
/*  936 */       JRMCoreClient.mc.field_71460_t.func_78483_a(0.0D);
/*  937 */       GL11.glDisable(2896);
/*  938 */       GL11.glBlendFunc(770, 1);
/*      */ 
/*      */       
/*  941 */       GL11.glTranslatef((float)par2, (float)par4, (float)par6);
/*  942 */       GL11.glRotatef(entity.field_70126_B + (entity.field_70177_z - entity.field_70126_B) * par9 - 180.0F, 0.0F, 1.0F, 0.0F);
/*  943 */       GL11.glRotatef(entity.field_70127_C + (entity.field_70125_A - entity.field_70127_C) * par9, 1.0F, 0.0F, 0.0F);
/*  944 */       GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
/*  945 */       JGRenderHelper.tex(this.field_76990_c, color, this.alpha);
/*      */       
/*  947 */       GL11.glScalef(1.0F, 1.0F, 1.0F);
/*  948 */       if (dual_color) GL11.glDepthMask(false); 
/*  949 */       this.ener.renderModel(type, entity, 0.0F, 0.0F, 0.0625F, var13, false);
/*  950 */       if (dual_color) {
/*  951 */         JGRenderHelper.tex(this.field_76990_c, color2, this.alpha);
/*  952 */         GL11.glScalef(0.8F, 0.8F, 0.8F);
/*  953 */         this.ener.renderModel(type, entity, 0.0F, 0.0F, 0.0625F, var13, false);
/*      */       } 
/*      */       
/*  956 */       GL11.glEnable(2896);
/*  957 */       JRMCoreClient.mc.field_71460_t.func_78463_b(0.0D);
/*  958 */       if (dual_color) GL11.glDepthMask(true); 
/*  959 */       GL11.glPopMatrix();
/*      */     } 
/*      */     
/*  962 */     if (type == 4) {
/*      */       
/*  964 */       GL11.glPushMatrix();
/*  965 */       JRMCoreClient.mc.field_71460_t.func_78483_a(0.0D);
/*  966 */       GL11.glDisable(2896);
/*  967 */       GL11.glBlendFunc(770, 1);
/*      */ 
/*      */       
/*  970 */       GL11.glTranslatef((float)par2, (float)par4, (float)par6);
/*  971 */       GL11.glRotatef(entity.field_70126_B + (entity.field_70177_z - entity.field_70126_B) * par9 - 180.0F, 0.0F, 1.0F, 0.0F);
/*  972 */       GL11.glRotatef(entity.field_70127_C + (entity.field_70125_A - entity.field_70127_C) * par9, 1.0F, 0.0F, 0.0F);
/*  973 */       GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
/*  974 */       JGRenderHelper.tex(this.field_76990_c, JRMCoreH.techCol[4], this.alpha);
/*  975 */       GL11.glScalef(size, size, (float)(entity.dist * 2.0D));
/*  976 */       if (dual_color) GL11.glDepthMask(false); 
/*  977 */       this.ener.renderModel(type, entity, 0.0F, 0.0F, 0.0625F, var13, false);
/*  978 */       if (dual_color) {
/*  979 */         JGRenderHelper.tex(this.field_76990_c, color2, this.alpha);
/*  980 */         GL11.glScalef(0.8F, 0.8F, 0.8F);
/*  981 */         this.ener.renderModel(type, entity, 0.0F, 0.0F, 0.0625F, var13, false);
/*      */       } 
/*      */       
/*  984 */       GL11.glEnable(2896);
/*  985 */       JRMCoreClient.mc.field_71460_t.func_78463_b(0.0D);
/*  986 */       if (dual_color) GL11.glDepthMask(true); 
/*  987 */       GL11.glPopMatrix();
/*      */       
/*  989 */       GL11.glPushMatrix();
/*  990 */       JRMCoreClient.mc.field_71460_t.func_78483_a(0.0D);
/*  991 */       GL11.glDisable(2896);
/*  992 */       GL11.glBlendFunc(770, 1);
/*      */       
/*  994 */       GL11.glTranslatef((float)par2, (float)par4, (float)par6);
/*  995 */       GL11.glRotatef(entity.field_70126_B + (entity.field_70177_z - entity.field_70126_B) * par9 - 180.0F, 0.0F, 1.0F, 0.0F);
/*  996 */       GL11.glRotatef(entity.field_70127_C + (entity.field_70125_A - entity.field_70127_C) * par9, 1.0F, 0.0F, 0.0F);
/*  997 */       GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
/*  998 */       JGRenderHelper.tex(this.field_76990_c, color, this.alpha);
/*  999 */       GL11.glScalef(size, size, (float)(entity.dist * 2.0D));
/* 1000 */       if (dual_color) GL11.glDepthMask(false); 
/* 1001 */       this.ener.renderModel((byte)0, entity, 0.0F, 0.0F, 0.0625F, var13, false);
/* 1002 */       if (dual_color) {
/* 1003 */         JGRenderHelper.tex(this.field_76990_c, color2, this.alpha);
/* 1004 */         GL11.glScalef(0.8F, 0.8F, 0.8F);
/* 1005 */         this.ener.renderModel((byte)0, entity, 0.0F, 0.0F, 0.0625F, var13, false);
/*      */       } 
/*      */       
/* 1008 */       GL11.glEnable(2896);
/* 1009 */       JRMCoreClient.mc.field_71460_t.func_78463_b(0.0D);
/* 1010 */       if (dual_color) GL11.glDepthMask(true); 
/* 1011 */       GL11.glPopMatrix();
/*      */     } 
/*      */     
/* 1014 */     if (type == 0) {
/*      */       
/* 1016 */       GL11.glPushMatrix();
/* 1017 */       JRMCoreClient.mc.field_71460_t.func_78483_a(0.0D);
/* 1018 */       GL11.glDisable(2896);
/* 1019 */       GL11.glBlendFunc(770, 1);
/*      */       
/* 1021 */       GL11.glTranslatef((float)par2, (float)par4, (float)par6);
/* 1022 */       GL11.glRotatef(entity.field_70126_B + (entity.field_70177_z - entity.field_70126_B) * par9 - 180.0F, 0.0F, 1.0F, 0.0F);
/* 1023 */       GL11.glRotatef(entity.field_70127_C + (entity.field_70125_A - entity.field_70127_C) * par9, 1.0F, 0.0F, 0.0F);
/* 1024 */       GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
/* 1025 */       JGRenderHelper.tex(this.field_76990_c, color, this.alpha);
/* 1026 */       GL11.glScalef(size, size, size);
/* 1027 */       if (dual_color) GL11.glDepthMask(false); 
/* 1028 */       this.ener.renderModel((byte)1, entity, 0.0F, 0.0F, 0.0625F, var13, false);
/* 1029 */       if (dual_color) {
/* 1030 */         JGRenderHelper.tex(this.field_76990_c, color2, this.alpha);
/* 1031 */         GL11.glScalef(0.8F, 0.8F, 0.8F);
/* 1032 */         this.ener.renderModel((byte)1, entity, 0.0F, 0.0F, 0.0625F, var13, false);
/*      */       } 
/*      */       
/* 1035 */       GL11.glEnable(2896);
/* 1036 */       JRMCoreClient.mc.field_71460_t.func_78463_b(0.0D);
/* 1037 */       if (dual_color) GL11.glDepthMask(true); 
/* 1038 */       GL11.glPopMatrix();
/*      */       
/* 1040 */       GL11.glPushMatrix();
/* 1041 */       JRMCoreClient.mc.field_71460_t.func_78483_a(0.0D);
/* 1042 */       GL11.glDisable(2896);
/* 1043 */       GL11.glBlendFunc(770, 1);
/*      */       
/* 1045 */       GL11.glTranslatef((float)par2, (float)par4, (float)par6);
/* 1046 */       GL11.glRotatef(entity.field_70126_B + (entity.field_70177_z - entity.field_70126_B) * par9 - 180.0F, 0.0F, 1.0F, 0.0F);
/* 1047 */       GL11.glRotatef(entity.field_70127_C + (entity.field_70125_A - entity.field_70127_C) * par9, 1.0F, 0.0F, 0.0F);
/* 1048 */       GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
/* 1049 */       JGRenderHelper.tex(this.field_76990_c, color, this.alpha);
/*      */       
/* 1051 */       GL11.glScalef(size, size, (float)(entity.dist * 2.0D));
/* 1052 */       if (dual_color) GL11.glDepthMask(false); 
/* 1053 */       this.ener.renderModel(type, entity, 0.0F, 0.0F, 0.0625F, var13, false);
/* 1054 */       if (dual_color) {
/* 1055 */         JGRenderHelper.tex(this.field_76990_c, color2, this.alpha);
/* 1056 */         GL11.glScalef(0.8F, 0.8F, 0.8F);
/* 1057 */         this.ener.renderModel(type, entity, 0.0F, 0.0F, 0.0625F, var13, false);
/*      */       } 
/*      */       
/* 1060 */       GL11.glEnable(2896);
/* 1061 */       JRMCoreClient.mc.field_71460_t.func_78463_b(0.0D);
/* 1062 */       if (dual_color) GL11.glDepthMask(true); 
/* 1063 */       GL11.glPopMatrix();
/*      */     } 
/*      */   }
/*      */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\entity\RenderEnergyAttackKi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */