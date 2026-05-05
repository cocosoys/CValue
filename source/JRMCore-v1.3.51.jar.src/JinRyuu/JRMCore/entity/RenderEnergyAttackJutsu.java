/*     */ package JinRyuu.JRMCore.entity;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreClient;
/*     */ import JinRyuu.JRMCore.client.JGRenderHelper;
/*     */ import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
/*     */ import JinRyuu.JRMCore.m.mEnergy;
/*     */ import cpw.mods.fml.client.FMLClientHandler;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RenderEnergyAttackJutsu
/*     */   extends RenderEnergyAttack<EntityEnergyAttJ>
/*     */ {
/*  38 */   private mEnergy ener = new mEnergy();
/*     */ 
/*     */   
/*     */   public void renderEnergy(EntityEnergyAttJ entity, double par2, double par4, double par6, float par8, float par9) {
/*  42 */     this.transparent = false;
/*  43 */     updateEffect(entity);
/*  44 */     int shrink = entity.getShrink();
/*  45 */     byte type = entity.getType();
/*  46 */     short effect = entity.getEff();
/*  47 */     float size = entity.getSizePerc();
/*  48 */     float rotation = handleRotationFloat(entity, par9);
/*  49 */     int color = entity.getCol();
/*     */     
/*  51 */     double sx = entity.strtX(), sy = entity.strtY(), sz = entity.strtZ();
/*  52 */     double x = sx - entity.field_70165_t, y = sy - entity.field_70163_u, z = sz - entity.field_70161_v;
/*     */     
/*  54 */     if (shrink > 0) {
/*     */       
/*  56 */       updateEffect2(entity);
/*     */     }
/*     */     else {
/*     */       
/*  60 */       entity.dist = MathHelper.func_76133_a(x * x + y * y + z * z);
/*  61 */       entity.finalDist = entity.dist;
/*     */     } 
/*     */     
/*  64 */     float scale = entity.getSize() * JGConfigClientSettings.CLIENT_Jutsu_Scale / 10.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  78 */     this.mode = 1;
/*  79 */     if (type < 3) {
/*     */       
/*  81 */       setVisuals(entity, type, effect, color, scale, this.mode);
/*  82 */       if (JGConfigClientSettings.CLIENT_Jutsu_3d[type]) {
/*     */         
/*  84 */         render_3d(entity, par2, par4, par6, par8, par9, scale, sx, sy, sz, color, rotation);
/*     */       }
/*     */       else {
/*     */         
/*  88 */         render_2d(entity, par2, par4, par6, par8, par9, scale, sx, sy, sz, color, rotation);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateEffect(EntityEnergyAttJ entity) {
/*  95 */     if (!JRMCoreClient.mc.func_147113_T()) {
/*     */       
/*  97 */       if (!entity.added) {
/*     */         
/*  99 */         entity.animation_id++;
/* 100 */         entity.animation_start = System.nanoTime() / 10000000L;
/* 101 */         entity.added = true;
/* 102 */         if (entity.render_scale < entity.render_scale_max) entity.render_scale += entity.render_scale_max / 10.0F; 
/* 103 */         if (entity.render_scale > entity.render_scale_max) entity.render_scale = entity.render_scale_max;
/*     */         
/* 105 */         if (this.random_texture && entity.animation_random != null) {
/*     */           
/* 107 */           int size = entity.animation_random.size();
/* 108 */           entity.animation_random.clear();
/* 109 */           for (int i = 0; i < size; i++)
/*     */           {
/* 111 */             entity.animation_random.add(Integer.valueOf((int)(Math.random() * entity.animation_random_Max)));
/*     */           }
/*     */         } 
/*     */       } 
/* 115 */       if (entity.animation_id >= entity.animation_id_Max) entity.animation_id = 0; 
/* 116 */       if (System.nanoTime() / 10000000L - entity.animation_start > entity.animation_speed) entity.added = false;
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateEffect2(EntityEnergyAttJ entity) {
/* 122 */     if (!JRMCoreClient.mc.func_147113_T()) {
/*     */       
/* 124 */       if (!entity.added2) {
/*     */         
/* 126 */         entity.animation_start2 = System.nanoTime() / 10000000L;
/* 127 */         entity.added2 = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 136 */         float shrinking = (float)entity.finalDist / 500.0F;
/*     */ 
/*     */ 
/*     */         
/* 140 */         if (entity.dist != 0.0D) {
/*     */           
/* 142 */           entity.dist -= ((1 + entity.getSpe() + 3) * shrinking);
/* 143 */           if (entity.dist < 0.0D) entity.dist = 0.0D;
/*     */         
/*     */         } 
/*     */         
/* 147 */         float egy = (float)entity.finalDist / 100.0F;
/* 148 */         float current = (float)entity.dist / egy / 100.0F;
/*     */         
/* 150 */         entity.waveScale = current;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 160 */       if (System.nanoTime() / 10000000L - entity.animation_start2 > 1L) entity.added2 = false;
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setVisuals(EntityEnergyAttJ entity, byte type, short effect, int color, float scale, byte mode) {
/* 166 */     float scale_all = entity.render_scale * scale / 2.0F / 1.8F;
/* 167 */     entity.animation_id_Max = 1;
/* 168 */     entity.animation_random_Max = 1;
/* 169 */     entity.animation_speed = 7;
/*     */ 
/*     */ 
/*     */     
/* 173 */     this.rendermode_tail = 0;
/* 174 */     this.render_head = true; this.render_head_connect = true;
/* 175 */     this.render_middle = true; this.render_noise = true;
/* 176 */     this.render_tail = true; this.render_tail_connect = true;
/*     */     
/* 178 */     this.rotate_head = true; this.rotate_head_connect = true;
/* 179 */     this.rotate_middle = true; this.rotate_noise = true;
/* 180 */     this.rotate_tail = true; this.rotate_tail_connect = true;
/*     */     
/* 182 */     this.scaling_head = true; this.scaling_tail = true;
/* 183 */     this.scale_head_more = 0.0F; this.scale_tail_more = 0.0F;
/*     */     
/* 185 */     this.head_follow = false; this.tail_follow = false;
/*     */     
/* 187 */     this.random_texture = false;
/*     */ 
/*     */     
/* 190 */     this.rotationSpeed = 40.0F;
/* 191 */     this.modifierTranslation = entity.dist / 2.0D + (scale_all * 1.0F / scale_all);
/* 192 */     this.detail = 4;
/* 193 */     this.brightness = 200;
/* 194 */     this.alpha = 1.0F * JGConfigClientSettings.CLIENT_Jutsu_Visibility / 10.0F;
/*     */ 
/*     */ 
/*     */     
/* 198 */     if (this.mode == 1) {
/*     */ 
/*     */       
/* 201 */       this.rotate_head = false; this.rotate_head_connect = false;
/* 202 */       this.rotate_middle = false; this.rotate_noise = false;
/* 203 */       this.rotate_tail = false; this.rotate_tail_connect = false;
/* 204 */       this.detail = 6;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 209 */       entity.animation_id_Max = 3;
/*     */       
/* 211 */       if (entity.isLightningElement()) {
/*     */         
/* 213 */         entity.animation_random_Max = 7;
/* 214 */         entity.animation_speed = 4;
/* 215 */         this.random_texture = true;
/*     */       } 
/* 217 */       if (entity.isWindElement())
/*     */       {
/* 219 */         this.alpha = 0.95F * JGConfigClientSettings.CLIENT_Jutsu_Visibility / 10.0F;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 226 */       setColors(16777215, this.alpha);
/* 227 */       setColors2(16777215);
/* 228 */       this.texture = "nc/" + this.texture_element[effect] + "/" + this.texture_type[type] + "/";
/*     */       
/* 230 */       if (entity.isWave()) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 241 */         this.render_middle = true;
/* 242 */         this.render_noise = false;
/* 243 */         this.scaling_head = true; this.scaling_tail = true;
/* 244 */         this.head_follow = true; this.tail_follow = true;
/* 245 */         this.scale_tail_more = 0.1F;
/*     */       }
/* 247 */       else if (entity.isBlast()) {
/*     */         
/* 249 */         scale_all *= 0.5F;
/* 250 */         this.render_head = false; this.render_head_connect = false;
/* 251 */         this.render_middle = false; this.render_noise = false;
/* 252 */         this.render_tail = true; this.render_tail_connect = true;
/* 253 */         this.scaling_head = false; this.scaling_tail = false;
/* 254 */         this.head_follow = false; this.tail_follow = true;
/*     */         
/* 256 */         this.rendermode_tail = 2;
/*     */       }
/* 258 */       else if (entity.isDisk()) {
/*     */ 
/*     */         
/* 261 */         this.rendermode_tail = 1;
/* 262 */         this.render_head = false; this.render_head_connect = false;
/* 263 */         this.render_middle = false; this.render_noise = false;
/* 264 */         this.render_tail = true; this.render_tail_connect = false;
/* 265 */         this.scaling_head = false; this.scaling_tail = false;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 272 */     this.scale_head = 1.0F * scale_all * (1.0F + this.scale_head_more) * entity.waveScale;
/* 273 */     this.scale_head_connect = 1.0F * scale_all * entity.waveScale;
/* 274 */     this.scale_middle = 1.0F * scale_all * entity.waveScale; this.scale_noise = 1.0F * scale_all * entity.waveScale;
/* 275 */     this.scale_tail = 1.0F * scale_all * (1.0F + scale_all * this.scale_tail_more);
/* 276 */     this.scale_tail_connect = 1.0F * scale_all * entity.waveScale;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render_2d(EntityEnergyAttJ entity, double par2, double par4, double par6, float par8, float par9, float scale, double sx, double sy, double sz, int color, float rotation) {
/* 284 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 285 */     long time = entity.field_70170_p.func_82737_E();
/* 286 */     float particleScale = 1.0F;
/*     */ 
/*     */     
/* 289 */     float middle_start = 0.4F, middle_max = 10.0F;
/*     */ 
/*     */ 
/*     */     
/* 293 */     glStart();
/*     */     
/* 295 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 296 */     GL11.glDepthMask(true);
/* 297 */     GL11.glDisable(2896);
/*     */     
/* 299 */     if (this.transparent) {
/*     */       
/* 301 */       GL11.glEnable(3042);
/* 302 */       GL11.glBlendFunc(770, 771);
/* 303 */       GL11.glAlphaFunc(516, 0.003921569F);
/* 304 */       GL11.glDepthMask(false);
/*     */     } 
/*     */     
/* 307 */     float X = 0.0F, Y = 0.0F, Z = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 319 */     float position = entity.waveScale;
/* 320 */     position *= position;
/*     */     
/* 322 */     X = (float)(-(entity.field_70165_t - sx) * 0.5D) * position;
/* 323 */     Y = (float)(-(entity.field_70163_u - sy) * 0.5D) * position;
/* 324 */     Z = (float)(-(entity.field_70161_v - sz) * 0.5D) * position;
/* 325 */     if (X == 0.0F) X = 0.0F;  if (Y == 0.0F) Y = 0.0F;  if (Z == 0.0F) Z = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 356 */     glRotate(entity, par2 + X, par4 + Y, par6 + Z, par9);
/*     */ 
/*     */     
/* 359 */     GL11.glRotated(90.0D, 1.0D, 0.0D, 0.0D);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 378 */     float particleMiddleWidth = 1.0F;
/* 379 */     float wave_start_size = 1.0F;
/* 380 */     float wave_end_size = 1.0F;
/* 381 */     int texture_id = 0;
/*     */ 
/*     */ 
/*     */     
/* 385 */     if (this.render_middle) {
/*     */       
/* 387 */       for (int i = 0; i < this.detail; i++)
/*     */       {
/* 389 */         float maxSize = 2.32F * particleScale;
/* 390 */         float correction = 0.86F;
/* 391 */         float scl = (float)entity.dist;
/* 392 */         int segments = (int)(scl / maxSize * 0.86F);
/*     */ 
/*     */         
/* 395 */         float div = segments / 10.0F;
/* 396 */         float size_divider = this.scaling_tail ? ((div < 5.0F) ? 5.0F : div) : 5.0F;
/* 397 */         float max_size = 10.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 404 */         GL11.glPushMatrix();
/* 405 */         GL11.glTranslatef(0.001F, 0.0F, 0.001F);
/* 406 */         apply_detail_rotation(i);
/*     */         
/* 408 */         float Translate_middle = -1.0F;
/* 409 */         GL11.glTranslatef(0.0F, -1.0F, 0.0F);
/*     */         
/* 411 */         if (this.rotate_middle)
/*     */         {
/* 413 */           GL11.glRotatef((float)time % 360.0F / this.rotationSpeed * this.rotationSpeed * 1.0F + this.rotationSpeed * par9, 0.0F, 1.0F, 0.0F);
/*     */         }
/*     */         
/* 416 */         for (int k = 0; k < segments + 1; k++) {
/*     */           
/* 418 */           float size = 1.0F;
/* 419 */           if (this.scaling_tail) {
/*     */             
/* 421 */             size = k / size_divider + 0.4F;
/* 422 */             if (size > 10.0F) size = 10.0F; 
/* 423 */             particleMiddleWidth = size;
/* 424 */             if (particleMiddleWidth > wave_end_size) wave_end_size = particleMiddleWidth; 
/* 425 */             if (k == 0) wave_start_size = size; 
/*     */           } 
/* 427 */           if (this.random_texture && entity.animation_random != null) {
/*     */             
/* 429 */             if (entity.animation_random.size() > k)
/*     */             {
/* 431 */               texture_id = ((Integer)entity.animation_random.get(k)).intValue();
/*     */             }
/*     */             else
/*     */             {
/* 435 */               entity.animation_random.add(Integer.valueOf((int)(Math.random() * entity.animation_random_Max)));
/*     */             }
/*     */           
/*     */           } else {
/*     */             
/* 440 */             texture_id = entity.animation_id % entity.animation_id_Max;
/*     */           } 
/* 442 */           (FMLClientHandler.instance().getClient()).field_71446_o.func_110577_a(set_resource("middle", texture_id));
/* 443 */           double length = entity.dist;
/* 444 */           if (length > maxSize) length = maxSize; 
/* 445 */           double minus = (-scl / 2.0F + (segments - k) * maxSize * 0.86F);
/*     */           
/* 447 */           float height = 1.0F;
/* 448 */           float height2 = 0.0F;
/* 449 */           if (k == 0) {
/*     */             
/* 451 */             float scale0 = (float)(segments - minus);
/* 452 */             if (scale0 < 0.0F) scale0 = 0.0F; 
/* 453 */             height = scale0;
/* 454 */             if (height > 1.0F) height = 1.0F; 
/* 455 */             height2 = height;
/* 456 */             minus += -(1.0F - height2);
/*     */           } 
/* 458 */           JGRenderHelper.draw_tessellator(tessellator, this.brightness, particleScale * particleMiddleWidth * this.scale_middle, 0.0F, particleScale * height, (float)-minus, this.red2, this.green2, this.blue2, this.alpha);
/*     */         } 
/*     */ 
/*     */         
/* 462 */         if (segments > entity.lastSegments) entity.lastSegments = segments; 
/* 463 */         if (segments < entity.lastSegments) {
/*     */           
/* 465 */           float size = 1.0F;
/* 466 */           if (this.scaling_tail) {
/*     */             
/* 468 */             size = entity.lastSegments / size_divider + 0.4F;
/* 469 */             if (size > 10.0F) size = 10.0F; 
/* 470 */             particleMiddleWidth = size;
/* 471 */             if (particleMiddleWidth > wave_end_size) wave_end_size = particleMiddleWidth;
/*     */           
/*     */           } 
/*     */         } 
/* 475 */         GL11.glPopMatrix();
/*     */       
/*     */       }
/*     */     
/*     */     }
/* 480 */     else if (this.scaling_tail) {
/*     */       
/* 482 */       float maxSize = 2.32F * particleScale;
/* 483 */       float correction = 0.86F;
/* 484 */       float scl = (float)entity.dist;
/* 485 */       int segments = (int)(scl / maxSize * 0.86F);
/*     */       
/* 487 */       float div = segments / 10.0F;
/* 488 */       float size_divider = this.scaling_tail ? ((div < 5.0F) ? 5.0F : div) : 5.0F;
/* 489 */       float max_size = 10.0F;
/*     */ 
/*     */       
/* 492 */       float size = 0.0F / size_divider + 0.4F;
/* 493 */       if (size > 10.0F) size = 10.0F; 
/* 494 */       particleMiddleWidth = size;
/* 495 */       wave_start_size = size;
/*     */ 
/*     */ 
/*     */       
/* 499 */       size = segments / size_divider + 0.4F;
/* 500 */       if (size > 10.0F) size = 10.0F; 
/* 501 */       particleMiddleWidth = size;
/* 502 */       if (particleMiddleWidth > wave_end_size) wave_end_size = particleMiddleWidth;
/*     */     
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 509 */     if (this.render_noise)
/*     */     {
/*     */ 
/*     */       
/* 513 */       for (int i = 0; i < this.detail; i++) {
/*     */         
/* 515 */         GL11.glPushMatrix();
/*     */         
/* 517 */         if (this.rotate_noise)
/*     */         {
/* 519 */           GL11.glRotatef((float)time % 360.0F / this.rotationSpeed * this.rotationSpeed * 1.0F + this.rotationSpeed * par9, 0.0F, 1.0F, 0.0F);
/*     */         }
/* 521 */         texture_id = entity.animation_id % entity.animation_id_Max;
/* 522 */         (FMLClientHandler.instance().getClient()).field_71446_o.func_110577_a(set_resource("noise", texture_id));
/* 523 */         apply_detail_rotation(i);
/* 524 */         JGRenderHelper.draw_tessellator2(tessellator, this.brightness, particleScale * this.scale_noise, 0.0F, (float)(entity.dist / 2.0D), 0.0F, this.red, this.green, this.blue, this.alpha);
/*     */         
/* 526 */         GL11.glPopMatrix();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 534 */     if (this.render_head)
/*     */     {
/* 536 */       if (!this.head_follow) {
/*     */         
/* 538 */         for (int i = 0; i < 2; i++)
/*     */         {
/* 540 */           GL11.glPushMatrix();
/*     */           
/* 542 */           if (this.rotate_head)
/*     */           {
/* 544 */             GL11.glRotatef((float)time % 360.0F / this.rotationSpeed * this.rotationSpeed * 1.0F + this.rotationSpeed * par9, 0.0F, 1.0F, 0.0F);
/*     */           }
/* 546 */           GL11.glTranslated(0.0D, -this.modifierTranslation, 0.0D);
/*     */           
/* 548 */           texture_id = entity.animation_id % entity.animation_id_Max;
/* 549 */           (FMLClientHandler.instance().getClient()).field_71446_o.func_110577_a(set_resource("head", texture_id));
/* 550 */           GL11.glRotated(-90.0D, 1.0D, 0.0D, 0.0D);
/* 551 */           GL11.glRotatef((i * 360 / 2), 0.0F, 1.0F, 0.0F);
/* 552 */           JGRenderHelper.draw_tessellator(tessellator, this.brightness, particleScale * (this.scaling_head ? wave_start_size : 1.0F) * this.scale_head, particleScale * (this.scaling_head ? wave_start_size : 1.0F) * this.scale_head, this.red, this.green, this.blue, this.alpha);
/*     */           
/* 554 */           GL11.glPopMatrix();
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 559 */         GL11.glPushMatrix();
/* 560 */         GL11.glTranslated(0.0D, -this.modifierTranslation, 0.0D);
/* 561 */         float rotationX = entity.field_70127_C + (entity.field_70125_A - entity.field_70127_C) * par9;
/* 562 */         GL11.glRotatef(rotationX, -1.0F, 0.0F, 0.0F);
/* 563 */         float rotationY = entity.field_70126_B + (entity.field_70177_z - entity.field_70126_B) * par9 - 180.0F;
/* 564 */         GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/* 565 */         GL11.glRotatef(rotationY, 0.0F, 0.0F, -1.0F);
/* 566 */         boolean view2 = (JRMCoreClient.mc.field_71474_y.field_74320_O == 2);
/* 567 */         GL11.glRotatef(-this.field_76990_c.field_78735_i, 0.0F, 0.0F, 1.0F);
/* 568 */         GL11.glRotatef(-this.field_76990_c.field_78732_j * (view2 ? -1 : true), 1.0F, 0.0F, 0.0F);
/* 569 */         texture_id = entity.animation_id % entity.animation_id_Max;
/* 570 */         (FMLClientHandler.instance().getClient()).field_71446_o.func_110577_a(set_resource("head", texture_id));
/*     */         
/* 572 */         GL11.glRotated(-90.0D, 1.0D, 0.0D, 0.0D);
/* 573 */         if (this.rotate_head)
/*     */         {
/* 575 */           GL11.glRotatef((float)time % 360.0F / this.rotationSpeed * this.rotationSpeed * 1.0F + this.rotationSpeed * par9, 0.0F, 0.0F, 1.0F);
/*     */         }
/* 577 */         JGRenderHelper.draw_tessellator(tessellator, this.brightness, particleScale * (this.scaling_head ? wave_start_size : 1.0F) * this.scale_head, particleScale * (this.scaling_head ? wave_start_size : 1.0F) * this.scale_head, this.red, this.green, this.blue, this.alpha);
/*     */         
/* 579 */         GL11.glPopMatrix();
/*     */       } 
/*     */     }
/* 582 */     if (this.render_head_connect)
/*     */     {
/* 584 */       for (int i = 0; i < this.detail; i++) {
/*     */         
/* 586 */         GL11.glPushMatrix();
/*     */         
/* 588 */         if (this.rotate_head_connect)
/*     */         {
/* 590 */           GL11.glRotatef((float)time % 360.0F / this.rotationSpeed * this.rotationSpeed * 1.0F + this.rotationSpeed * par9, 0.0F, 1.0F, 0.0F);
/*     */         }
/* 592 */         GL11.glTranslated(0.0D, -this.modifierTranslation, 0.0D);
/* 593 */         texture_id = entity.animation_id % entity.animation_id_Max;
/* 594 */         (FMLClientHandler.instance().getClient()).field_71446_o.func_110577_a(set_resource("head_connect", texture_id));
/* 595 */         apply_detail_rotation(i);
/* 596 */         JGRenderHelper.draw_tessellator(tessellator, this.brightness, particleScale * (this.scaling_head ? wave_start_size : 1.0F) * this.scale_head_connect, particleScale, this.red, this.green, this.blue, this.alpha);
/*     */         
/* 598 */         GL11.glPopMatrix();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 621 */     if (this.render_tail)
/*     */     {
/* 623 */       if ((this.rendermode_tail == 0 && !this.tail_follow) || (this.rendermode_tail == 2 && !this.tail_follow)) {
/*     */         
/* 625 */         for (int i = 0; i < 2; i++)
/*     */         {
/* 627 */           GL11.glPushMatrix();
/* 628 */           if (this.rendermode_tail == 2) {
/*     */             
/* 630 */             GL11.glTranslated(0.0D, -1.0D, 0.0D);
/* 631 */             GL11.glTranslated(0.0D, 0.0D, 0.25D);
/*     */           } 
/* 633 */           if (this.rotate_tail)
/*     */           {
/* 635 */             GL11.glRotatef((float)time % 360.0F / this.rotationSpeed * this.rotationSpeed * 1.0F + this.rotationSpeed * par9, 0.0F, 1.0F, 0.0F);
/*     */           }
/* 637 */           GL11.glTranslated(0.0D, this.modifierTranslation, 0.0D);
/* 638 */           texture_id = entity.animation_id % entity.animation_id_Max;
/* 639 */           (FMLClientHandler.instance().getClient()).field_71446_o.func_110577_a(set_resource("tail", texture_id));
/* 640 */           GL11.glRotated(-90.0D, 1.0D, 0.0D, 0.0D);
/* 641 */           GL11.glRotatef((i * 360 / 2), 0.0F, 1.0F, 0.0F);
/* 642 */           JGRenderHelper.draw_tessellator(tessellator, this.brightness, particleScale * wave_end_size * this.scale_tail, particleScale * wave_end_size * this.scale_tail, this.red, this.green, this.blue, this.alpha);
/*     */           
/* 644 */           GL11.glPopMatrix();
/*     */         }
/*     */       
/* 647 */       } else if ((this.rendermode_tail == 0 && this.tail_follow) || (this.rendermode_tail == 2 && this.tail_follow)) {
/*     */         
/* 649 */         GL11.glPushMatrix();
/* 650 */         GL11.glTranslated(0.0D, this.modifierTranslation, 0.0D);
/* 651 */         if (this.rendermode_tail == 2) {
/*     */           
/* 653 */           GL11.glTranslated(0.0D, -1.0D, 0.0D);
/* 654 */           GL11.glTranslated(0.0D, 0.0D, 0.25D);
/*     */         } 
/* 656 */         float rotationX = entity.field_70127_C + (entity.field_70125_A - entity.field_70127_C) * par9;
/* 657 */         GL11.glRotatef(rotationX, -1.0F, 0.0F, 0.0F);
/* 658 */         float rotationY = entity.field_70126_B + (entity.field_70177_z - entity.field_70126_B) * par9 - 180.0F;
/* 659 */         GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/* 660 */         GL11.glRotatef(rotationY, 0.0F, 0.0F, -1.0F);
/* 661 */         boolean view2 = (JRMCoreClient.mc.field_71474_y.field_74320_O == 2);
/* 662 */         GL11.glRotatef(-this.field_76990_c.field_78735_i, 0.0F, 0.0F, 1.0F);
/* 663 */         GL11.glRotatef(-this.field_76990_c.field_78732_j * (view2 ? -1 : true), 1.0F, 0.0F, 0.0F);
/* 664 */         texture_id = entity.animation_id % entity.animation_id_Max;
/* 665 */         (FMLClientHandler.instance().getClient()).field_71446_o.func_110577_a(set_resource("tail", texture_id));
/*     */         
/* 667 */         GL11.glRotated(-90.0D, 1.0D, 0.0D, 0.0D);
/* 668 */         if (this.rotate_tail)
/*     */         {
/* 670 */           GL11.glRotatef((float)time % 360.0F / this.rotationSpeed * this.rotationSpeed * 1.0F + this.rotationSpeed * par9, 0.0F, 0.0F, 1.0F);
/*     */         }
/* 672 */         JGRenderHelper.draw_tessellator(tessellator, this.brightness, particleScale * wave_end_size * this.scale_tail, particleScale * wave_end_size * this.scale_tail, this.red, this.green, this.blue, this.alpha);
/*     */         
/* 674 */         GL11.glPopMatrix();
/*     */       }
/* 676 */       else if (this.rendermode_tail == 1) {
/*     */         
/* 678 */         for (int j = 0; j < scale * 5.0F; j++) {
/*     */           
/* 680 */           for (int i = 0; i < 2; i++) {
/*     */             
/* 682 */             GL11.glPushMatrix();
/* 683 */             GL11.glTranslated(0.0D, -1.0D, 0.0D);
/* 684 */             GL11.glTranslated(0.0D, 0.0D, 0.25D);
/* 685 */             GL11.glTranslated(0.0D, 0.0D, j * 0.01D);
/* 686 */             GL11.glTranslated(0.0D, this.modifierTranslation, 0.0D);
/*     */             
/* 688 */             if (this.rotate_tail)
/*     */             {
/* 690 */               GL11.glRotatef((float)time % 360.0F / this.rotationSpeed * this.rotationSpeed * 1.0F + this.rotationSpeed * par9, 0.0F, 0.0F, 1.0F);
/*     */             }
/* 692 */             texture_id = entity.animation_id % entity.animation_id_Max;
/* 693 */             (FMLClientHandler.instance().getClient()).field_71446_o.func_110577_a(set_resource("tail", texture_id));
/*     */             
/* 695 */             GL11.glRotatef((i * 360 / 2), 0.0F, 1.0F, 0.0F);
/* 696 */             JGRenderHelper.draw_tessellator(tessellator, this.brightness, particleScale * wave_end_size * this.scale_tail, particleScale * wave_end_size * this.scale_tail, this.red, this.green, this.blue, this.alpha);
/*     */             
/* 698 */             GL11.glPopMatrix();
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/* 703 */     if (this.render_tail_connect)
/*     */     {
/* 705 */       for (int i = 0; i < this.detail; i++) {
/*     */         
/* 707 */         GL11.glPushMatrix();
/*     */         
/* 709 */         if (this.rendermode_tail == 2) {
/*     */           
/* 711 */           GL11.glTranslated(0.0D, -1.0D, 0.0D);
/* 712 */           GL11.glTranslated(0.0D, 0.0D, 0.25D);
/*     */         } 
/* 714 */         if (this.rotate_tail_connect)
/*     */         {
/* 716 */           GL11.glRotatef((float)time % 360.0F / this.rotationSpeed * this.rotationSpeed * 1.0F + this.rotationSpeed * par9, 0.0F, 1.0F, 0.0F);
/*     */         }
/* 718 */         GL11.glTranslated(0.0D, this.modifierTranslation, 0.0D);
/* 719 */         texture_id = entity.animation_id % entity.animation_id_Max;
/* 720 */         (FMLClientHandler.instance().getClient()).field_71446_o.func_110577_a(set_resource("tail_connect", texture_id));
/* 721 */         apply_detail_rotation(i);
/* 722 */         JGRenderHelper.draw_tessellator(tessellator, this.brightness, particleScale * wave_end_size * this.scale_tail_connect, particleScale * ((this.rendermode_tail == 2) ? this.scale_tail_connect : 1.0F), this.red, this.green, this.blue, this.alpha);
/*     */         
/* 724 */         GL11.glPopMatrix();
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 729 */     if (this.transparent) {
/*     */       
/* 731 */       GL11.glDisable(3042);
/* 732 */       GL11.glDepthMask(true);
/*     */     } 
/*     */     
/* 735 */     GL11.glEnable(2896);
/* 736 */     glEnd();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render_3d(EntityEnergyAttJ entity, double par2, double par4, double par6, float par8, float par9, float scale, double sx, double sy, double sz, int color, float rotation) {
/* 743 */     byte type = entity.getType();
/* 744 */     byte perc = entity.getPerc();
/* 745 */     int dam = entity.getDam();
/* 746 */     byte den = entity.getDen();
/* 747 */     int col = entity.getCol();
/* 748 */     short eff = entity.getEff();
/* 749 */     float size = entity.getSizePerc() * JGConfigClientSettings.CLIENT_Jutsu_Scale / 10.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 754 */     float var13 = handleRotationFloat(entity, par9);
/*     */ 
/*     */ 
/*     */     
/* 758 */     double x = sx - entity.field_70165_t;
/* 759 */     double y = sy - entity.field_70163_u;
/* 760 */     double z = sz - entity.field_70161_v;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 776 */     int shrink = entity.getShrink();
/* 777 */     if (shrink > 0) {
/*     */       
/* 779 */       updateEffect2(entity);
/*     */     }
/*     */     else {
/*     */       
/* 783 */       entity.dist = MathHelper.func_76133_a(x * x + y * y + z * z);
/* 784 */       entity.finalDist = entity.dist;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 791 */     if (type == 1) {
/*     */       
/* 793 */       glStart(entity, par2, par4, par6, par9);
/* 794 */       JGRenderHelper.tex(this.field_76990_c, col, this.alpha);
/* 795 */       GL11.glScalef(size, size, size);
/* 796 */       this.ener.renderModel((byte)1, entity, 0.0F, 0.0F, 0.0625F, var13, false);
/* 797 */       glEnd();
/*     */     }
/* 799 */     else if (type == 2) {
/*     */       
/* 801 */       glStart(entity, par2, par4, par6, par9);
/* 802 */       JGRenderHelper.tex(this.field_76990_c, col, this.alpha);
/* 803 */       GL11.glScalef(size, size, size);
/* 804 */       this.ener.renderModel(type, entity, 0.0F, 0.0F, 0.0625F, var13, false);
/* 805 */       glEnd();
/*     */     }
/* 807 */     else if (type == 0) {
/*     */ 
/*     */       
/* 810 */       glStart(entity, par2, par4, par6, par9);
/* 811 */       JGRenderHelper.tex(this.field_76990_c, col, this.alpha);
/* 812 */       GL11.glScalef(size, size, (float)(entity.dist * 2.0D));
/* 813 */       this.ener.renderModel(type, entity, 0.0F, 0.0F, 0.0625F, var13, false);
/* 814 */       glEnd();
/*     */ 
/*     */       
/* 817 */       glStart(entity, par2, par4, par6, par9);
/* 818 */       JGRenderHelper.tex(this.field_76990_c, col, this.alpha);
/* 819 */       GL11.glScalef(size, size, size);
/* 820 */       this.ener.renderModel((byte)1, entity, 0.0F, 0.0F, 0.0625F, var13, false);
/* 821 */       glEnd();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\entity\RenderEnergyAttackJutsu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */