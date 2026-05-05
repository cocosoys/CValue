/*     */ package JinRyuu.JRMCore.entity;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreClient;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.client.JGRenderHelper;
/*     */ import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
/*     */ import cpw.mods.fml.client.FMLClientHandler;
/*     */ import net.minecraft.client.entity.EntityClientPlayerMP;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RenderEnergyAttackKiCharge
/*     */   extends RenderEnergyAttack<EntityEng>
/*     */ {
/*     */   private boolean rotate_player_yaw;
/*     */   private boolean rotate_player_pitch;
/*  23 */   private ModelEnergy ener = new ModelEnergy();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_76986_a(Entity entity, double par2, double par4, double par6, float par8, float par9) {
/*  68 */     if (entity != null && entity instanceof EntityEng && ((EntityEng)entity).user != null) {
/*     */       
/*  70 */       GL11.glPushMatrix();
/*  71 */       GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/*  72 */       GL11.glTranslatef((float)-par2, (float)-par4, (float)par6);
/*     */       
/*  74 */       GL11.glPushMatrix();
/*  75 */       renderEnergy((EntityEng)entity, par2, par4, par6, par8, par9);
/*  76 */       GL11.glPopMatrix();
/*  77 */       GL11.glPopMatrix();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderEnergy(EntityEng entity, double par2, double par4, double par6, float par8, float par9) {
/*  84 */     this.transparent = false;
/*  85 */     updateEffect(entity);
/*  86 */     byte type = (byte)entity.getType();
/*  87 */     float rotation = handleRotationFloat(entity, par9);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  92 */     int color = entity.destroyer ? (JGConfigClientSettings.CLIENT_Ki_3d[type] ? JRMCoreH.techCol[5] : JRMCoreH.techCol4[entity.getColor()]) : JRMCoreH.techCol[entity.getColor()];
/*     */     
/*  94 */     int color2 = entity.destroyer ? (JGConfigClientSettings.CLIENT_Ki_3d[type] ? JRMCoreH.techCol4[entity.getColor()] : JRMCoreH.techCol[entity.getColor()]) : ((entity.getColor2() == -1) ? JRMCoreH.techCol2[entity.getColor()] : JRMCoreH.techCol3[entity.getColor2()]);
/*     */ 
/*     */     
/*  97 */     EntityPlayer user = entity.user;
/*  98 */     int ticksExisted = entity.field_70173_aa;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 113 */     float scale = ticksExisted * entity.getSize() / 100.0F;
/* 114 */     if (scale > entity.getSize()) scale = entity.getSize(); 
/* 115 */     scale *= JGConfigClientSettings.CLIENT_Ki_Charge_Scale / 10.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 122 */     float height = -user.field_70131_O;
/* 123 */     float height2 = height * 0.8F;
/* 124 */     float width = user.field_70130_N;
/* 125 */     float width2 = width * 0.8F;
/*     */     
/* 127 */     this.mode = 2;
/* 128 */     double x = 0.0D, y = 0.0D, z = 0.0D;
/* 129 */     x = 0.0D;
/* 130 */     y = 0.0D;
/* 131 */     z = 0.0D;
/*     */ 
/*     */     
/* 134 */     setVisuals(entity, type, color, color2, scale, this.mode);
/* 135 */     if (entity.isWave()) {
/*     */       
/* 137 */       x = 0.0D;
/* 138 */       y = height2;
/* 139 */       z = (width + 1.0F + scale / 20.0F);
/*     */     }
/* 141 */     else if (entity.isBlast()) {
/*     */       
/* 143 */       x = (width2 * 0.35F);
/* 144 */       y = height2;
/* 145 */       z = (width + 1.0F + scale / 20.0F);
/*     */     }
/* 147 */     else if (entity.isDisk()) {
/*     */       
/* 149 */       x = width2;
/* 150 */       y = (height * 1.1F - 0.3F - scale / 20.0F);
/* 151 */       z = 0.0D;
/*     */     }
/* 153 */     else if (entity.isLaser()) {
/*     */       
/* 155 */       x = (width2 * 0.35F);
/* 156 */       y = height2;
/* 157 */       z = (width + 1.0F + scale / 20.0F);
/*     */     }
/* 159 */     else if (entity.isLargeBlast()) {
/*     */       
/* 161 */       x = 0.0D;
/* 162 */       y = (height - 1.0F - scale / 2.0F);
/* 163 */       z = 0.0D;
/*     */     }
/* 165 */     else if (entity.isSpiral()) {
/*     */       
/* 167 */       x = (width2 * 0.35F);
/* 168 */       y = height2;
/* 169 */       z = (width + 1.0F + scale / 20.0F);
/*     */     }
/* 171 */     else if (entity.isBarrage()) {
/*     */       
/* 173 */       x = (width2 * 0.35F);
/* 174 */       y = height2;
/* 175 */       z = (width + 1.0F + scale / 20.0F);
/*     */     }
/* 177 */     else if (entity.isShield() || entity.isExplosion()) {
/*     */       
/* 179 */       x = 0.0D;
/* 180 */       y = (height / 2.0F);
/* 181 */       z = 0.0D;
/*     */     } 
/*     */ 
/*     */     
/* 185 */     if (JGConfigClientSettings.CLIENT_Ki_Charge_3d[type]) {
/*     */       
/* 187 */       render_3d(entity, x, y, z, par8, par9, scale, 0.0D, 0.0D, 0.0D, color, color2, rotation);
/*     */     }
/*     */     else {
/*     */       
/* 191 */       render_2d(entity, x, y, z, par8, par9, scale, 0.0D, 0.0D, 0.0D, color, color2, rotation);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateEffect(EntityEng entity) {
/* 197 */     if (!JRMCoreClient.mc.func_147113_T()) {
/*     */       
/* 199 */       if (!entity.added) {
/*     */         
/* 201 */         entity.animation_id++;
/* 202 */         entity.animation_start = System.nanoTime() / 10000000L;
/* 203 */         entity.added = true;
/* 204 */         if (entity.render_scale < entity.render_scale_max) entity.render_scale += entity.render_scale_max / 10.0F; 
/* 205 */         if (entity.render_scale > entity.render_scale_max) entity.render_scale = entity.render_scale_max;
/*     */         
/* 207 */         if (this.random_texture && entity.animation_random != null) {
/*     */           
/* 209 */           int size = entity.animation_random.size();
/* 210 */           entity.animation_random.clear();
/* 211 */           for (int i = 0; i < size; i++)
/*     */           {
/* 213 */             entity.animation_random.add(Integer.valueOf((int)(Math.random() * entity.animation_random_Max)));
/*     */           }
/*     */         } 
/*     */       } 
/* 217 */       if (entity.animation_id >= entity.animation_id_Max) entity.animation_id = 0; 
/* 218 */       if (System.nanoTime() / 10000000L - entity.animation_start > entity.animation_speed) entity.added = false;
/*     */     
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setVisuals(EntityEng entity, byte type, int color, int color2, float scale, byte mode) {
/* 225 */     float scale_all = entity.render_scale * scale;
/*     */     
/* 227 */     entity.animation_id_Max = 1;
/* 228 */     entity.animation_random_Max = 1;
/* 229 */     entity.animation_speed = 7;
/* 230 */     this.rotate_player_yaw = false; this.rotate_player_pitch = false;
/*     */ 
/*     */ 
/*     */     
/* 234 */     this.rendermode_tail = 0;
/*     */ 
/*     */     
/* 237 */     this.render_tail = true; this.render_tail_connect = true;
/*     */ 
/*     */ 
/*     */     
/* 241 */     this.rotate_tail = true; this.rotate_tail_connect = true;
/*     */     
/* 243 */     this.scaling_head = true; this.scaling_tail = true;
/* 244 */     this.scale_head_more = 0.0F; this.scale_tail_more = 0.0F;
/*     */     
/* 246 */     this.head_follow = false; this.tail_follow = false;
/*     */     
/* 248 */     this.random_texture = false;
/*     */ 
/*     */     
/* 251 */     this.rotationSpeed = 40.0F;
/* 252 */     this.modifierTranslation = (0.0F + scale_all * 1.0F / scale_all);
/* 253 */     this.detail = 4;
/* 254 */     this.brightness = 200;
/* 255 */     this.alpha = 1.0F * JGConfigClientSettings.CLIENT_Ki_Charge_Visibility / 10.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 260 */     if (this.mode == 2) {
/*     */ 
/*     */       
/* 263 */       setColors(color, this.alpha);
/* 264 */       setColors2(color2);
/* 265 */       this.texture = (entity.destroyer ? "dbc_god/" : "dbc/") + "charge/" + this.texture_type[type] + "/";
/*     */       
/* 267 */       scale_all *= 0.5F;
/*     */ 
/*     */       
/* 270 */       this.render_tail = true; this.render_tail_connect = true;
/* 271 */       this.scaling_head = false; this.scaling_tail = false;
/* 272 */       this.head_follow = false; this.tail_follow = true;
/*     */       
/* 274 */       this.rendermode_tail = 2;
/* 275 */       if (entity.isWave()) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 282 */         this.rotate_player_yaw = true; this.rotate_player_pitch = true;
/*     */         
/* 284 */         this.render_tail = true; this.render_tail_connect = true;
/* 285 */         this.scaling_head = false; this.scaling_tail = false;
/* 286 */         this.head_follow = false; this.tail_follow = true;
/*     */         
/* 288 */         this.rendermode_tail = 2;
/*     */       }
/* 290 */       else if (entity.isBlast()) {
/*     */         
/* 292 */         this.rotate_player_yaw = true; this.rotate_player_pitch = true;
/* 293 */         scale_all *= 0.5F;
/* 294 */         this.render_tail = true; this.render_tail_connect = true;
/* 295 */         this.scaling_head = false; this.scaling_tail = false;
/* 296 */         this.head_follow = false; this.tail_follow = true;
/*     */         
/* 298 */         this.rendermode_tail = 2;
/*     */       }
/* 300 */       else if (entity.isDisk()) {
/*     */         
/* 302 */         this.rotate_player_yaw = true; this.rotate_player_pitch = true;
/*     */         
/* 304 */         this.rendermode_tail = 1;
/*     */ 
/*     */         
/* 307 */         this.render_tail = true; this.render_tail_connect = false;
/* 308 */         this.scaling_head = false; this.scaling_tail = false;
/*     */       }
/* 310 */       else if (entity.isLaser()) {
/*     */         
/* 312 */         this.rotate_player_yaw = true; this.rotate_player_pitch = true;
/* 313 */         scale_all *= 0.5F;
/* 314 */         this.render_tail = true; this.render_tail_connect = true;
/* 315 */         this.scaling_head = false; this.scaling_tail = false;
/* 316 */         this.head_follow = false; this.tail_follow = true;
/*     */         
/* 318 */         this.rendermode_tail = 2;
/*     */       }
/* 320 */       else if (entity.isLargeBlast()) {
/*     */ 
/*     */ 
/*     */         
/* 324 */         this.render_tail = true; this.render_tail_connect = true;
/* 325 */         this.scaling_head = false; this.scaling_tail = false;
/* 326 */         this.head_follow = false; this.tail_follow = true;
/*     */         
/* 328 */         this.rendermode_tail = 2;
/*     */       }
/* 330 */       else if (entity.isSpiral()) {
/*     */         
/* 332 */         this.rotate_player_yaw = true; this.rotate_player_pitch = true;
/* 333 */         scale_all *= 0.5F;
/* 334 */         this.render_tail = true; this.render_tail_connect = true;
/* 335 */         this.scaling_head = false; this.scaling_tail = false;
/* 336 */         this.head_follow = false; this.tail_follow = true;
/*     */         
/* 338 */         this.rendermode_tail = 2;
/*     */       }
/* 340 */       else if (entity.isBarrage()) {
/*     */         
/* 342 */         this.rotate_player_yaw = true; this.rotate_player_pitch = true;
/* 343 */         scale_all *= 0.25F;
/* 344 */         this.render_tail = true; this.render_tail_connect = true;
/* 345 */         this.scaling_head = false; this.scaling_tail = false;
/* 346 */         this.head_follow = false; this.tail_follow = true;
/*     */         
/* 348 */         this.rendermode_tail = 2;
/*     */       }
/* 350 */       else if (entity.isShield()) {
/*     */ 
/*     */ 
/*     */         
/* 354 */         this.render_tail = true; this.render_tail_connect = false;
/* 355 */         this.scaling_head = false; this.scaling_tail = false;
/* 356 */         this.tail_follow = true;
/* 357 */         this.rendermode_tail = 2;
/* 358 */         this.transparent = true;
/*     */       }
/* 360 */       else if (entity.isExplosion()) {
/*     */ 
/*     */ 
/*     */         
/* 364 */         this.render_tail = true; this.render_tail_connect = false;
/* 365 */         this.scaling_head = false; this.scaling_tail = false;
/* 366 */         this.tail_follow = true;
/* 367 */         this.rendermode_tail = 2;
/* 368 */         this.transparent = true;
/*     */       } 
/* 370 */       this.render_tail_connect = false;
/*     */     } 
/*     */     
/* 373 */     this.scale_head = 1.0F * scale_all * (1.0F + this.scale_head_more); this.scale_head_connect = 1.0F * scale_all;
/* 374 */     this.scale_middle = 1.0F * scale_all; this.scale_noise = 1.0F * scale_all;
/* 375 */     this.scale_tail = 1.0F * scale_all * (1.0F + scale_all * this.scale_tail_more); this.scale_tail_connect = 1.0F * scale_all;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render_2d(EntityEng entity, double par2, double par4, double par6, float par8, float par9, float scale, double sx, double sy, double sz, int color, int color2, float rotation) {
/* 383 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 384 */     long time = entity.user.field_70170_p.func_82737_E();
/* 385 */     float particleScale = 1.0F;
/*     */ 
/*     */     
/* 388 */     float middle_start = 0.4F, middle_max = 10.0F;
/*     */ 
/*     */ 
/*     */     
/* 392 */     glStart();
/*     */     
/* 394 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 395 */     GL11.glDepthMask(true);
/* 396 */     GL11.glDisable(2896);
/*     */     
/* 398 */     if (this.transparent) {
/*     */       
/* 400 */       GL11.glEnable(3042);
/* 401 */       GL11.glBlendFunc(770, 771);
/* 402 */       GL11.glAlphaFunc(516, 0.003921569F);
/* 403 */       GL11.glDepthMask(false);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 410 */     GL11.glTranslatef(0.0F, (float)par4, 0.0F);
/* 411 */     if (this.rotate_player_yaw) GL11.glRotatef(entity.user.field_70177_z, 0.0F, 1.0F, 0.0F); 
/* 412 */     if (this.rotate_player_pitch) GL11.glRotatef(entity.user.field_70125_A, -1.0F, 0.0F, 0.0F); 
/* 413 */     GL11.glTranslatef((float)par2, 0.0F, (float)par6);
/* 414 */     if (this.rotate_player_pitch) GL11.glRotatef(entity.user.field_70125_A, 1.0F, 0.0F, 0.0F); 
/* 415 */     if (this.rotate_player_yaw) GL11.glRotatef(entity.user.field_70177_z, 0.0F, -1.0F, 0.0F);
/*     */ 
/*     */     
/* 418 */     GL11.glRotated(90.0D, 1.0D, 0.0D, 0.0D);
/*     */ 
/*     */     
/* 421 */     float particleMiddleWidth = 1.0F;
/* 422 */     float wave_start_size = 1.0F;
/* 423 */     float wave_end_size = 1.0F;
/* 424 */     int texture_id = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 429 */     if (this.render_tail)
/*     */     {
/* 431 */       if ((this.rendermode_tail == 0 && !this.tail_follow) || (this.rendermode_tail == 2 && !this.tail_follow)) {
/*     */         
/* 433 */         for (int i = 0; i < 2; i++)
/*     */         {
/* 435 */           GL11.glPushMatrix();
/* 436 */           if (this.rendermode_tail == 2);
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 441 */           if (this.rotate_tail)
/*     */           {
/* 443 */             GL11.glRotatef((float)time % 360.0F / this.rotationSpeed * this.rotationSpeed * 1.0F + this.rotationSpeed * par9, 0.0F, 1.0F, 0.0F);
/*     */           }
/*     */           
/* 446 */           texture_id = entity.animation_id % entity.animation_id_Max;
/* 447 */           (FMLClientHandler.instance().getClient()).field_71446_o.func_110577_a(set_resource("tail", texture_id));
/* 448 */           GL11.glRotated(-90.0D, 1.0D, 0.0D, 0.0D);
/* 449 */           GL11.glRotatef((i * 360 / 2), 0.0F, 1.0F, 0.0F);
/* 450 */           JGRenderHelper.draw_tessellator(tessellator, this.brightness, particleScale * wave_end_size * this.scale_tail, particleScale * wave_end_size * this.scale_tail, this.red, this.green, this.blue, this.alpha);
/*     */           
/* 452 */           GL11.glPopMatrix();
/*     */         }
/*     */       
/* 455 */       } else if ((this.rendermode_tail == 0 && this.tail_follow) || (this.rendermode_tail == 2 && this.tail_follow)) {
/*     */         
/* 457 */         GL11.glPushMatrix();
/*     */         
/* 459 */         if (this.rendermode_tail == 2);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 464 */         EntityClientPlayerMP client = JRMCoreClient.mc.field_71439_g;
/*     */         
/* 466 */         float rotationX = client.field_70127_C + (client.field_70125_A - client.field_70127_C) * par9;
/*     */         
/* 468 */         float rotationY = client.field_70126_B + (client.field_70177_z - client.field_70126_B) * par9 - 180.0F;
/*     */ 
/*     */         
/* 471 */         boolean view2 = (JRMCoreClient.mc.field_71474_y.field_74320_O == 2);
/* 472 */         GL11.glRotatef(-this.field_76990_c.field_78735_i, 0.0F, 0.0F, 1.0F);
/* 473 */         GL11.glRotatef(-this.field_76990_c.field_78732_j * (view2 ? -1 : true), 1.0F, 0.0F, 0.0F);
/* 474 */         texture_id = entity.animation_id % entity.animation_id_Max;
/* 475 */         (FMLClientHandler.instance().getClient()).field_71446_o.func_110577_a(set_resource("tail", texture_id));
/*     */         
/* 477 */         GL11.glRotated(-90.0D, 1.0D, 0.0D, 0.0D);
/* 478 */         if (this.rotate_tail)
/*     */         {
/* 480 */           GL11.glRotatef((float)time % 360.0F / this.rotationSpeed * this.rotationSpeed * 1.0F + this.rotationSpeed * par9, 0.0F, 0.0F, 1.0F);
/*     */         }
/* 482 */         JGRenderHelper.draw_tessellator(tessellator, this.brightness, particleScale * wave_end_size * this.scale_tail, particleScale * wave_end_size * this.scale_tail, this.red, this.green, this.blue, this.alpha);
/*     */         
/* 484 */         GL11.glPopMatrix();
/*     */       }
/* 486 */       else if (this.rendermode_tail == 1) {
/*     */         
/* 488 */         for (int j = 0; j < scale * 5.0F; j++) {
/*     */           
/* 490 */           for (int i = 0; i < 2; i++) {
/*     */             
/* 492 */             GL11.glPushMatrix();
/*     */ 
/*     */             
/* 495 */             GL11.glTranslated(0.0D, 0.0D, j * 0.01D);
/*     */ 
/*     */             
/* 498 */             if (this.rotate_tail)
/*     */             {
/* 500 */               GL11.glRotatef((float)time % 360.0F / this.rotationSpeed * this.rotationSpeed * 1.0F + this.rotationSpeed * par9, 0.0F, 0.0F, 1.0F);
/*     */             }
/* 502 */             texture_id = entity.animation_id % entity.animation_id_Max;
/* 503 */             (FMLClientHandler.instance().getClient()).field_71446_o.func_110577_a(set_resource("tail", texture_id));
/*     */             
/* 505 */             GL11.glRotatef((i * 360 / 2), 0.0F, 1.0F, 0.0F);
/* 506 */             JGRenderHelper.draw_tessellator(tessellator, this.brightness, particleScale * wave_end_size * this.scale_tail, particleScale * wave_end_size * this.scale_tail, this.red, this.green, this.blue, this.alpha);
/*     */             
/* 508 */             GL11.glPopMatrix();
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/* 513 */     if (this.render_tail_connect)
/*     */     {
/* 515 */       for (int i = 0; i < this.detail; i++) {
/*     */         
/* 517 */         GL11.glPushMatrix();
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 522 */         if (this.rendermode_tail == 2);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 527 */         if (this.rotate_tail_connect)
/*     */         {
/* 529 */           GL11.glRotatef((float)time % 360.0F / this.rotationSpeed * this.rotationSpeed * 1.0F + this.rotationSpeed * par9, 0.0F, 1.0F, 0.0F);
/*     */         }
/*     */         
/* 532 */         texture_id = entity.animation_id % entity.animation_id_Max;
/* 533 */         (FMLClientHandler.instance().getClient()).field_71446_o.func_110577_a(set_resource("tail_connect", texture_id));
/* 534 */         apply_detail_rotation(i);
/* 535 */         JGRenderHelper.draw_tessellator(tessellator, this.brightness, particleScale * wave_end_size * this.scale_tail_connect, particleScale * ((this.rendermode_tail == 2) ? this.scale_tail_connect : 1.0F), this.red, this.green, this.blue, this.alpha);
/*     */ 
/*     */         
/* 538 */         GL11.glPopMatrix();
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 543 */     if (this.transparent) {
/*     */       
/* 545 */       GL11.glDisable(3042);
/* 546 */       GL11.glDepthMask(true);
/*     */     } 
/*     */     
/* 549 */     GL11.glEnable(2896);
/* 550 */     glEnd();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render_3d(EntityEng entity, double par2, double par4, double par6, float par8, float par9, float scale, double sx, double sy, double sz, int color, int color2, float rotation) {
/* 558 */     EntityPlayer user = entity.user;
/* 559 */     int ticksExisted = entity.field_70173_aa;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 565 */     GL11.glPushMatrix();
/* 566 */     GL11.glEnable(3042);
/* 567 */     GL11.glDisable(2896);
/* 568 */     GL11.glBlendFunc(770, 771);
/* 569 */     GL11.glAlphaFunc(516, 0.003921569F);
/* 570 */     GL11.glDepthMask(false);
/*     */ 
/*     */ 
/*     */     
/* 574 */     if (entity.getColor() > JRMCoreH.techCol.length) color = 0;
/*     */ 
/*     */     
/* 577 */     if (entity.getColor() > JRMCoreH.techCol2.length) color2 = 0;
/*     */ 
/*     */     
/* 580 */     float u = -user.field_70131_O * 0.8F;
/* 581 */     int type = entity.getType();
/*     */     
/* 583 */     boolean dual_color = JGConfigClientSettings.CLIENT_DA9;
/*     */     
/* 585 */     if (entity.isBlast()) {
/*     */       
/* 587 */       scale /= 2.0F;
/* 588 */       if (scale > 0.5F) scale = 0.5F; 
/* 589 */       GL11.glTranslatef(0.0F, u, 0.0F);
/* 590 */       GL11.glRotatef(user.field_70177_z, 0.0F, 1.0F, 0.0F);
/* 591 */       GL11.glRotatef(user.field_70125_A, -1.0F, 0.0F, 0.0F);
/* 592 */       GL11.glTranslatef(0.0F, 0.0F, user.field_70130_N + 1.0F);
/* 593 */       GL11.glTranslatef(0.2F, 0.0F, 0.0F);
/* 594 */       GL11.glScalef(scale, scale, scale);
/* 595 */       JGRenderHelper.tex(this.field_76990_c, color, this.alpha);
/* 596 */       GL11.glRotatef(ticksExisted * 15.0F, 1.0F, 1.0F, 0.0F);
/* 597 */       this.ener.renderModel((byte)type, entity, 0.0F, 0.0F, 0.0625F, 0.0F, false);
/*     */       
/* 599 */       if (dual_color)
/*     */       {
/* 601 */         JGRenderHelper.tex(this.field_76990_c, color2, this.alpha);
/* 602 */         GL11.glScalef(0.8F, 0.8F, 0.8F);
/* 603 */         this.ener.renderModel((byte)type, entity, 0.0F, 0.0F, 0.0625F, 0.0F, false);
/*     */       }
/*     */     
/* 606 */     } else if (entity.isLargeBlast()) {
/*     */       
/* 608 */       GL11.glEnable(3042);
/* 609 */       GL11.glDisable(2896);
/* 610 */       GL11.glBlendFunc(770, 771);
/* 611 */       GL11.glAlphaFunc(516, 0.003921569F);
/* 612 */       GL11.glDepthMask(false);
/*     */       
/* 614 */       if (entity.getPartid() == 1) scale *= 6.0F; 
/* 615 */       GL11.glTranslatef(0.0F, u, 0.0F);
/* 616 */       GL11.glRotatef(user.field_70177_z, 0.0F, 1.0F, 0.0F);
/* 617 */       GL11.glTranslatef(0.0F, -user.field_70131_O - scale, 0.0F);
/* 618 */       GL11.glScalef(scale, scale, scale);
/* 619 */       JGRenderHelper.tex(this.field_76990_c, color, this.alpha);
/* 620 */       GL11.glRotatef(ticksExisted * 15.0F, 1.0F, 1.0F, 0.0F);
/* 621 */       this.ener.renderModel((byte)1, entity, 0.0F, 0.0F, 0.0625F, 0.0F, false);
/*     */       
/* 623 */       if (dual_color)
/*     */       {
/* 625 */         JGRenderHelper.tex(this.field_76990_c, color2, this.alpha);
/* 626 */         GL11.glScalef(0.8F, 0.8F, 0.8F);
/* 627 */         this.ener.renderModel((byte)1, entity, 0.0F, 0.0F, 0.0625F, 0.0F, false);
/*     */       }
/*     */     
/* 630 */     } else if (entity.isShield() || entity.isExplosion()) {
/*     */       
/* 632 */       scale += 0.5F;
/* 633 */       scale *= 4.0F;
/* 634 */       GL11.glTranslatef(0.0F, u, 0.0F);
/* 635 */       GL11.glRotatef(user.field_70177_z, 0.0F, 1.0F, 0.0F);
/* 636 */       GL11.glTranslatef(0.0F, 0.0F + user.field_70131_O / 4.0F, 0.0F);
/* 637 */       GL11.glScalef(scale * user.field_70131_O / 2.0F, scale * user.field_70131_O / 2.0F, scale * user.field_70131_O / 2.0F);
/*     */       
/* 639 */       float szaz = 20.0F;
/* 640 */       float egy = szaz / 100.0F;
/* 641 */       float offtr = ticksExisted / egy / 100.0F;
/* 642 */       offtr /= 40.0F;
/* 643 */       if (offtr > 0.1F) offtr = 0.1F;
/*     */ 
/*     */ 
/*     */       
/* 647 */       JGRenderHelper.tex(this.field_76990_c, color, offtr);
/* 648 */       GL11.glRotatef(ticksExisted * 15.0F, 1.0F, 1.0F, 0.0F);
/* 649 */       this.ener.renderModel((byte)1, entity, 0.0F, 0.0F, 0.0625F, 0.0F, false);
/*     */       
/* 651 */       if (dual_color) {
/*     */ 
/*     */         
/* 654 */         JGRenderHelper.tex(this.field_76990_c, color2, offtr);
/* 655 */         GL11.glScalef(0.8F, 0.8F, 0.8F);
/* 656 */         this.ener.renderModel((byte)1, entity, 0.0F, 0.0F, 0.0625F, 0.0F, false);
/*     */       } 
/*     */       
/* 659 */       GL11.glDisable(3042);
/* 660 */       GL11.glEnable(2896);
/* 661 */       GL11.glDepthMask(true);
/*     */     }
/* 663 */     else if (entity.isDisk()) {
/*     */       
/* 665 */       GL11.glTranslatef(0.0F, u, 0.0F);
/* 666 */       GL11.glRotatef(user.field_70177_z, 0.0F, 1.0F, 0.0F);
/* 667 */       GL11.glTranslatef(user.field_70130_N / 1.2F, -user.field_70131_O * 0.7F, 0.0F);
/* 668 */       GL11.glScalef(scale, scale, scale);
/* 669 */       GL11.glRotatef((ticksExisted * 30), 0.0F, 1.0F, 0.0F);
/* 670 */       JGRenderHelper.tex(this.field_76990_c, color, this.alpha);
/* 671 */       this.ener.renderModel((byte)type, entity, 0.0F, 0.0F, 0.0625F, 0.0F, false);
/*     */       
/* 673 */       if (dual_color)
/*     */       {
/* 675 */         JGRenderHelper.tex(this.field_76990_c, color2, this.alpha);
/* 676 */         GL11.glScalef(0.8F, 0.8F, 0.8F);
/* 677 */         this.ener.renderModel((byte)type, entity, 0.0F, 0.0F, 0.0625F, 0.0F, false);
/*     */       }
/*     */     
/* 680 */     } else if (entity.isLaser()) {
/*     */       
/* 682 */       scale /= 4.0F;
/* 683 */       GL11.glTranslatef(0.0F, u, 0.0F);
/* 684 */       GL11.glRotatef(user.field_70177_z, 0.0F, 1.0F, 0.0F);
/* 685 */       GL11.glRotatef(user.field_70125_A, -1.0F, 0.0F, 0.0F);
/* 686 */       GL11.glTranslatef(0.0F, 0.0F, user.field_70130_N + 1.0F);
/* 687 */       GL11.glTranslatef(0.2F, 0.0F, 0.0F);
/* 688 */       GL11.glScalef(scale, scale, scale);
/* 689 */       JGRenderHelper.tex(this.field_76990_c, color, this.alpha);
/* 690 */       GL11.glRotatef(ticksExisted * 15.0F, 1.0F, 1.0F, 0.0F);
/* 691 */       this.ener.renderModel((byte)1, entity, 0.0F, 0.0F, 0.0625F, 0.0F, false);
/*     */       
/* 693 */       if (dual_color)
/*     */       {
/* 695 */         JGRenderHelper.tex(this.field_76990_c, color2, this.alpha);
/* 696 */         GL11.glScalef(0.8F, 0.8F, 0.8F);
/* 697 */         this.ener.renderModel((byte)1, entity, 0.0F, 0.0F, 0.0625F, 0.0F, false);
/*     */       }
/*     */     
/* 700 */     } else if (entity.isSpiral()) {
/*     */       
/* 702 */       scale /= 4.0F;
/* 703 */       GL11.glTranslatef(0.0F, u, 0.0F);
/* 704 */       GL11.glRotatef(user.field_70177_z, 0.0F, 1.0F, 0.0F);
/* 705 */       GL11.glRotatef(user.field_70125_A, -1.0F, 0.0F, 0.0F);
/* 706 */       GL11.glTranslatef(0.0F, 0.0F, user.field_70130_N + 1.0F);
/* 707 */       GL11.glTranslatef(0.2F, 0.0F, 0.0F);
/* 708 */       GL11.glScalef(scale, scale, scale);
/* 709 */       JGRenderHelper.tex(this.field_76990_c, color, this.alpha);
/* 710 */       GL11.glRotatef(ticksExisted * 15.0F, 1.0F, 1.0F, 0.0F);
/* 711 */       this.ener.renderModel((byte)1, entity, 0.0F, 0.0F, 0.0625F, 0.0F, false);
/*     */       
/* 713 */       if (dual_color)
/*     */       {
/* 715 */         JGRenderHelper.tex(this.field_76990_c, color2, this.alpha);
/* 716 */         GL11.glScalef(0.8F, 0.8F, 0.8F);
/* 717 */         this.ener.renderModel((byte)1, entity, 0.0F, 0.0F, 0.0625F, 0.0F, false);
/*     */       }
/*     */     
/* 720 */     } else if (entity.isWave()) {
/*     */       
/* 722 */       scale /= 2.0F;
/* 723 */       GL11.glTranslatef(0.0F, u, 0.0F);
/* 724 */       GL11.glRotatef(user.field_70177_z, 0.0F, 1.0F, 0.0F);
/* 725 */       GL11.glRotatef(user.field_70125_A, -1.0F, 0.0F, 0.0F);
/* 726 */       GL11.glTranslatef(0.0F, 0.0F, user.field_70130_N + 1.0F);
/* 727 */       GL11.glScalef(scale, scale, scale);
/* 728 */       JGRenderHelper.tex(this.field_76990_c, color, this.alpha);
/* 729 */       GL11.glRotatef(ticksExisted * 15.0F, 1.0F, 1.0F, 0.0F);
/* 730 */       this.ener.renderModel((byte)1, entity, 0.0F, 0.0F, 0.0625F, 0.0F, false);
/*     */       
/* 732 */       if (dual_color) {
/*     */         
/* 734 */         JGRenderHelper.tex(this.field_76990_c, color2, this.alpha);
/* 735 */         GL11.glScalef(0.8F, 0.8F, 0.8F);
/* 736 */         this.ener.renderModel((byte)1, entity, 0.0F, 0.0F, 0.0625F, 0.0F, false);
/*     */       } 
/*     */     } 
/*     */     
/* 740 */     GL11.glEnable(2896);
/* 741 */     GL11.glDisable(3042);
/* 742 */     GL11.glPopMatrix();
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\entity\RenderEnergyAttackKiCharge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */