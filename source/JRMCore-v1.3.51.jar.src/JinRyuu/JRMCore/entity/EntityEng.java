/*     */ package JinRyuu.JRMCore.entity;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreClient;
/*     */ import JinRyuu.JRMCore.JRMCoreConfig;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
/*     */ import JinRyuu.JRMCore.i.ExtendedPlayer;
/*     */ import java.util.ArrayList;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityEng
/*     */   extends Entity {
/*     */   private String mot;
/*     */   private int type;
/*     */   private int color;
/*     */   private int color2;
/*     */   private float size;
/*     */   private byte partid;
/*     */   
/*     */   public String getmot() {
/*  25 */     return this.mot;
/*     */   } public int getType() {
/*  27 */     return this.type - 1;
/*     */   } public int getColor() {
/*  29 */     return this.color;
/*     */   } public int getColor2() {
/*  31 */     return this.color2;
/*     */   } public float getSize() {
/*  33 */     return this.size;
/*     */   }
/*     */   
/*     */   public byte getPartid() {
/*  37 */     return this.partid;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean destroyer = false;
/*     */   
/*     */   public float minScale;
/*     */   
/*     */   public float maxScale;
/*     */   
/*     */   public float maxDamage;
/*     */   
/*     */   public void setScales() {
/*  50 */     this.minScale = (float)JRMCoreConfig.KiSizeMin[getType()];
/*  51 */     this.maxScale = (float)JRMCoreConfig.KiSizeMax[getType()];
/*  52 */     this.maxDamage = JRMCoreH.getMaxEnergyDamage();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float setScalesPost() {
/*  58 */     if (isWave()) return 100.0F; 
/*  59 */     if (isBlast()) return 5.0F; 
/*  60 */     if (isDisk()) return 5.0F; 
/*  61 */     if (isLaser()) return 5.0F; 
/*  62 */     if (isLargeBlast()) return 10000.0F; 
/*  63 */     if (isSpiral()) return 5.0F; 
/*  64 */     if (isBarrage()) return 5.0F; 
/*  65 */     if (isShield()) return 5.0F; 
/*  66 */     if (isExplosion()) return 20.0F; 
/*  67 */     return 1.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean added = false;
/*  72 */   public int animation_speed = 0;
/*  73 */   public long animation_start = 0L;
/*  74 */   public int animation_id = 0;
/*  75 */   public int animation_id_Max = 0;
/*  76 */   public int animation_random_Max = 0;
/*  77 */   public ArrayList<Integer> animation_random = new ArrayList<Integer>();
/*  78 */   public float render_scale = 0.0F;
/*  79 */   public float render_scale_max = 2.0F;
/*     */ 
/*     */   
/*     */   public EntityPlayer user;
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityEng(World w, double poX, double poY, double poZ, String mot, int type, int color, float size, int partid) {
/*  87 */     super(w);
/*  88 */     func_70105_a(2.0F, 5.0F);
/*  89 */     this.field_70165_t = poX;
/*  90 */     this.field_70163_u = poY;
/*  91 */     this.field_70161_v = poZ;
/*  92 */     this.field_70159_w = 0.0D;
/*  93 */     this.field_70181_x = 0.0D;
/*  94 */     this.field_70179_y = 0.0D;
/*  95 */     this.type = type;
/*  96 */     this.color = color;
/*  97 */     this.color2 = -1;
/*  98 */     if (!isShield() && !isExplosion()) {
/*     */ 
/*     */       
/* 101 */       setScales();
/* 102 */       float size1 = size;
/*     */ 
/*     */       
/* 105 */       this.size = 0.5F + size1;
/*     */       
/* 107 */       if (JRMCoreConfig.eaesl > 0 && size > JRMCoreConfig.eaesl) this.size = JRMCoreConfig.eaesl; 
/* 108 */       if (isLargeBlast()) this.size *= JRMCoreConfig.ealbm;
/*     */     
/*     */     } 
/* 111 */     this.partid = (byte)partid;
/* 112 */     this.mot = mot;
/* 113 */     func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 114 */     moveToUser();
/*     */     
/* 116 */     if (JRMCoreConfig.KiAttackScalesWithUser)
/*     */     {
/* 118 */       this.size *= (this.user == null) ? 1.0F : (this.user.field_70131_O / 1.8F);
/*     */     }
/*     */     
/* 121 */     if (this.user != null && (isShield() || isExplosion()))
/*     */     {
/* 123 */       this.size = this.user.field_70131_O * 3.0F * (!isExplosion() ? 1.0F : 2.0F);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {}
/*     */   
/*     */   protected void func_70037_a(NBTTagCompound nbt) {}
/*     */   
/*     */   protected void func_70014_b(NBTTagCompound nbt) {}
/*     */   
/*     */   public boolean isWave() {
/* 135 */     return (getType() == 0); }
/* 136 */   public boolean isBlast() { return (getType() == 1); }
/* 137 */   public boolean isDisk() { return (getType() == 2); }
/* 138 */   public boolean isLaser() { return (getType() == 3); }
/* 139 */   public boolean isLargeBlast() { return (getType() == 5); }
/* 140 */   public boolean isSpiral() { return (getType() == 4); }
/* 141 */   public boolean isBarrage() { return (getType() == 6); }
/* 142 */   public boolean isShield() { return (getType() == 7); } public boolean isExplosion() {
/* 143 */     return (getType() == 8);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/* 148 */     if (this.field_70170_p.field_72995_K && !JRMCoreClient.mc.func_147113_T()) {
/*     */ 
/*     */       
/* 151 */       if (this.user == null)
/*     */       {
/* 153 */         moveToUser();
/*     */       }
/*     */       
/* 156 */       if (this.user != null)
/*     */       {
/* 158 */         createParticles();
/*     */       }
/*     */       
/* 161 */       if (this.user != null && !this.user.field_70128_L) {
/*     */         
/* 163 */         ExtendedPlayer props = ExtendedPlayer.get(this.user);
/* 164 */         if (props.getAnimKiShoot() == 0 || props.getAnimKiShootOn() == 0) {
/*     */ 
/*     */           
/* 167 */           func_70106_y();
/*     */         } else {
/* 169 */           func_70080_a(this.user.field_70165_t, this.user.field_70163_u + ((this.user instanceof net.minecraft.client.entity.EntityPlayerSP) ? -1.6F : 0.0F), this.user.field_70161_v, 0.0F, 0.0F);
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 174 */         func_70106_y();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void moveToUser() {
/* 181 */     if (this.mot.length() > 1) {
/*     */       
/* 183 */       this.user = this.field_70170_p.func_72924_a(this.mot);
/*     */       
/* 185 */       if (this.user != null)
/*     */       {
/* 187 */         func_70080_a(this.user.field_70165_t, this.user.field_70163_u + ((this.user instanceof net.minecraft.client.entity.EntityPlayerSP) ? -1.6F : 0.0F), this.user.field_70161_v, 0.0F, 0.0F);
/*     */       
/*     */       }
/*     */       else
/*     */       {
/* 192 */         func_70106_y();
/*     */       }
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 198 */       func_70106_y();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void createParticles() {
/* 205 */     if (this.user != null && this.user.field_70170_p.field_72995_K && (isWave() || isBlast() || 
/* 206 */       isLargeBlast() || isLaser() || isSpiral())) {
/*     */       
/* 208 */       int coloring = JRMCoreH.techCol[getColor()];
/* 209 */       int coloring2 = JRMCoreH.techCol2[getColor()];
/* 210 */       generateParticles(this, (Entity)this.user, coloring, coloring2);
/*     */     } 
/*     */     
/* 213 */     if (JGConfigClientSettings.CLIENT_DA16)
/*     */     {
/* 215 */       for (int k = 0; k < JGConfigClientSettings.get_da1(); k++) {
/*     */ 
/*     */         
/* 218 */         if (getPartid() == 1) {
/*     */ 
/*     */           
/* 221 */           float h1 = 1.0F;
/* 222 */           float pl_scale = 2.0F;
/* 223 */           pl_scale = this.user.field_70131_O;
/*     */           
/* 225 */           float scale = this.field_70173_aa * this.size / 100.0F;
/* 226 */           if (scale > this.size) scale = this.size;
/*     */           
/* 228 */           float spe2 = 4.0F * scale + 2.0F + pl_scale / 2.0F;
/*     */ 
/*     */           
/* 231 */           double x = Math.random() * spe2 - (spe2 / 2.0F);
/* 232 */           double y = -1.0499999523162842D;
/* 233 */           double z = Math.random() * spe2 - (spe2 / 2.0F);
/*     */ 
/*     */           
/* 236 */           double motx = -x / 50.0D / (pl_scale / 2.0F);
/* 237 */           double motz = -z / 50.0D / (pl_scale / 2.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 242 */           float h2 = (JRMCoreH.techCol[this.color] >> 16 & 0xFF) / 255.0F;
/* 243 */           float h3 = (JRMCoreH.techCol[this.color] >> 8 & 0xFF) / 255.0F;
/* 244 */           float h4 = (JRMCoreH.techCol[this.color] & 0xFF) / 255.0F;
/* 245 */           float red = h1 * h2, green = h1 * h3, blue = h1 * h4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 254 */           Entity entity7 = new EntityCusPar("jinryuudragonbc:bens_particles_attack.png", this.field_70170_p, 0.2F, 0.2F, this.user.field_70165_t, this.user.field_70163_u, this.user.field_70161_v, x, y, z, motx, 0.1D + Math.random() * 0.02500000037252903D, motz, 0.0F, (int)(Math.random() * 3.0D) + 56, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", (27 + (int)spe2) * ((int)(pl_scale / 3.0F) + 1), 0, 0.001F + (float)(Math.random() * 0.0020000000949949026D), 0.0F, 0.0F, 0, red, green, blue, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.05F, false, -1, true, (Entity)this.user);
/*     */ 
/*     */ 
/*     */           
/* 258 */           entity7.field_70170_p.func_72838_d(entity7);
/*     */         
/*     */         }
/* 261 */         else if (getPartid() == 4) {
/*     */           
/* 263 */           if (this.field_70173_aa % 2 == 0) {
/*     */             
/* 265 */             float a = 1.0F, h1 = 1.0F;
/* 266 */             float scale = this.field_70173_aa * this.field_70131_O / 100.0F;
/*     */             
/* 268 */             float pl_s = 1.0F;
/*     */             
/* 270 */             double x = 0.0D;
/* 271 */             double y = (this.user.field_70131_O * 0.7F - 1.0F);
/* 272 */             pl_s = this.user.field_70131_O / 2.0F;
/*     */             
/* 274 */             double z = 0.0D;
/*     */ 
/*     */             
/* 277 */             int num = (int)(Math.random() * 4.0D) + 1;
/* 278 */             for (int i = 0; i < num; i++) {
/*     */               
/* 280 */               int id = (int)(Math.random() * 3.0D) + 4;
/* 281 */               float rot = (float)(Math.random() * 0.019999999552965164D) + 0.01F;
/* 282 */               float scalem = ((float)(Math.random() * 0.15000000596046448D) + 0.155F) * pl_s;
/* 283 */               float scales = scalem * 0.01F;
/* 284 */               boolean forg = ((int)(Math.random() * 2.0D) == 0);
/*     */ 
/*     */ 
/*     */               
/* 288 */               float h2 = (JRMCoreH.techCol[this.color] >> 16 & 0xFF) / 255.0F;
/* 289 */               float h3 = (JRMCoreH.techCol[this.color] >> 8 & 0xFF) / 255.0F;
/* 290 */               float h4 = (JRMCoreH.techCol[this.color] & 0xFF) / 255.0F;
/* 291 */               float red = h1 * h2, green = h1 * h3, blue = h1 * h4;
/*     */               
/* 293 */               Entity entity = new EntityCusPar("jinryuudragonbc:bens_particles_attack.png", this.field_70170_p, 2.0F, 2.0F, this.user.field_70165_t, this.user.field_70163_u + ((this.user instanceof net.minecraft.client.entity.EntityPlayerSP) ? -1.6F : 0.0F), this.user.field_70161_v, x, y, z, 0.0D, 0.0D, 0.0D, 0.0F, id, 4, 4, 64, forg, rot, false, 0.0F, 1, "", 5, 1, 0.145F * pl_s, scalem, scales, 0, red, green, blue, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2, 0.0F, 0.0F, 0.75F, 0.78F, 0.3F, false, -1, true, (Entity)this.user);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 304 */               ((EntityCusPar)entity).setdata39((int)(Math.random() * 360.0D));
/*     */               
/* 306 */               entity.field_70170_p.func_72838_d(entity);
/*     */             } 
/*     */           } 
/*     */           
/* 310 */           if (this.field_70173_aa % 3 == 0)
/*     */           {
/* 312 */             float a = 1.0F, h1 = 1.0F;
/* 313 */             float scale = this.field_70173_aa * this.field_70131_O / 100.0F;
/*     */             
/* 315 */             float pl_s = 1.0F;
/*     */             
/* 317 */             double x = 0.0D;
/* 318 */             double y = (this.user.field_70131_O * 0.7F - 1.0F);
/* 319 */             pl_s = this.user.field_70131_O / 2.0F;
/* 320 */             double z = 0.0D;
/*     */             
/* 322 */             pl_s = this.user.field_70131_O / 2.0F;
/* 323 */             int num = 4;
/* 324 */             boolean forg = ((int)(Math.random() * 2.0D) == 0);
/* 325 */             float rot = (float)(Math.random() * 0.019999999552965164D) + 0.01F;
/* 326 */             for (int i = 0; i < num; i++)
/*     */             {
/* 328 */               int id = 7;
/* 329 */               float scalem = ((float)(Math.random() * 0.029999999329447746D) + 0.13F) * pl_s;
/* 330 */               float scales = scalem * 0.1F;
/* 331 */               float rota = 360.0F / num * i + (int)(Math.random() * (360 / num));
/*     */ 
/*     */ 
/*     */               
/* 335 */               float h2 = (JRMCoreH.techCol[this.color] >> 16 & 0xFF) / 255.0F;
/* 336 */               float h3 = (JRMCoreH.techCol[this.color] >> 8 & 0xFF) / 255.0F;
/* 337 */               float h4 = (JRMCoreH.techCol[this.color] & 0xFF) / 255.0F;
/* 338 */               float red = h1 * h2, green = h1 * h3, blue = h1 * h4;
/*     */               
/* 340 */               int life = 30;
/* 341 */               float transp_sp = 0.18F;
/* 342 */               float transp_min = 0.75F;
/* 343 */               float transp_max = 0.78F;
/*     */ 
/*     */               
/* 346 */               Entity entity = new EntityCusPar("jinryuudragonbc:bens_particles_attack.png", this.field_70170_p, 2.0F, 2.0F, this.user.field_70165_t, this.user.field_70163_u + ((this.user instanceof net.minecraft.client.entity.EntityPlayerSP) ? -1.6F : 0.0F), this.user.field_70161_v, x, y, z, 0.0D, 0.0D, 0.0D, 0.0F, id, 4, 4, 64, forg, rot, false, 0.0F, 1, "", 30, 1, 0.12F * pl_s, scalem, scales, 0, red, green, blue, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2, 0.0F, 0.0F, 0.75F, 0.78F, 0.18F, false, -1, true, (Entity)this.user);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 357 */               ((EntityCusPar)entity).setdata39(rota);
/* 358 */               entity.field_70170_p.func_72838_d(entity);
/*     */ 
/*     */               
/* 361 */               h2 = (JRMCoreH.techCol2[this.color] >> 16 & 0xFF) / 255.0F;
/* 362 */               h3 = (JRMCoreH.techCol2[this.color] >> 8 & 0xFF) / 255.0F;
/* 363 */               h4 = (JRMCoreH.techCol2[this.color] & 0xFF) / 255.0F;
/* 364 */               red = h1 * h2; green = h1 * h3; blue = h1 * h4;
/* 365 */               Entity entity2 = new EntityCusPar("jinryuudragonbc:bens_particles_attack.png", this.field_70170_p, 2.0F, 2.0F, this.user.field_70165_t, this.user.field_70163_u + ((this.user instanceof net.minecraft.client.entity.EntityPlayerSP) ? -1.6F : 0.0F), this.user.field_70161_v, x, y, z, 0.0D, 0.0D, 0.0D, 0.0F, id, 4, 4, 64, true, rot, false, 0.0F, 1, "", 30, 1, 0.096F * pl_s, scalem * 0.8F, scales * 0.8F, 0, red, green, blue, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2, 0.0F, 0.0F, 0.75F, 0.78F, 0.18F, false, -1, true, (Entity)this.user);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 376 */               ((EntityCusPar)entity2).setdata39(rota);
/* 377 */               entity2.field_70170_p.func_72838_d(entity2);
/*     */             }
/*     */           
/*     */           }
/*     */         
/* 382 */         } else if (getPartid() == 2) {
/*     */           
/* 384 */           if (this.field_70173_aa % 5 == 0)
/*     */           {
/* 386 */             float a = 1.0F, h1 = 1.0F;
/* 387 */             float scale = this.field_70173_aa * this.field_70131_O / 100.0F;
/*     */             
/* 389 */             float pl_s = 1.0F;
/*     */             
/* 391 */             double x = 0.0D;
/* 392 */             double y = (this.user.field_70131_O * 0.7F - 1.5F);
/* 393 */             y = (this.user.field_70131_O * 0.7F - 1.0F);
/* 394 */             pl_s = this.user.field_70131_O / 2.0F;
/*     */             
/* 396 */             double z = 0.0D;
/*     */             
/* 398 */             int num = (int)(Math.random() * 4.0D) + 1;
/* 399 */             for (int i = 0; i < num; i++)
/*     */             {
/* 401 */               int id = (int)(Math.random() * 4.0D);
/* 402 */               float rota = (float)(Math.random() * 0.4000000059604645D) + 0.4F;
/* 403 */               float rota4 = (float)(Math.random() * 0.4000000059604645D) + 0.4F;
/* 404 */               float scalem = ((float)(Math.random() * 0.019999999552965164D) + 0.04F) * pl_s;
/* 405 */               float scales = ((float)(Math.random() * 0.0020000000949949026D) + 0.001F) * pl_s;
/* 406 */               int rota1 = (int)(Math.random() * 360.0D);
/* 407 */               int rota2 = (int)(Math.random() * 360.0D);
/* 408 */               int rota3 = (int)(Math.random() * 360.0D);
/* 409 */               boolean rot = ((int)(Math.random() * 2.0D) == 0);
/* 410 */               float rotsp = (float)(Math.random() * rota) + 0.001F;
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 415 */               float h2 = (JRMCoreH.techCol2[this.color] >> 16 & 0xFF) / 255.0F;
/* 416 */               float h3 = (JRMCoreH.techCol2[this.color] >> 8 & 0xFF) / 255.0F;
/* 417 */               float h4 = (JRMCoreH.techCol2[this.color] & 0xFF) / 255.0F;
/* 418 */               float red = h1 * h2, green = h1 * h3, blue = h1 * h4;
/*     */ 
/*     */               
/* 421 */               Entity entity = new EntityCusPar("jinryuudragonbc:bens_particles_attack.png", this.field_70170_p, 2.0F, 2.0F, this.user.field_70165_t, this.user.field_70163_u + ((this.user instanceof net.minecraft.client.entity.EntityPlayerSP) ? -1.6F : 0.0F), this.user.field_70161_v, x, y, z, 0.0D, 0.0D, 0.0D, 0.0F, id, 4, 4, 64, true, 0.0F, true, 0.0F, 1, "", 25, 0, 0.1F, scalem, scales, 0, red, green, blue, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2, 0.0F, 0.0F, 0.95F, 0.98F, 0.2F, false, -1, true, (Entity)this.user);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 433 */               ((EntityCusPar)entity).setdata39(rota1);
/* 434 */               ((EntityCusPar)entity).setdata40(rota2);
/* 435 */               ((EntityCusPar)entity).setdata41(rota3);
/* 436 */               ((EntityCusPar)entity).setdata42(3);
/* 437 */               ((EntityCusPar)entity).setdata45(1.5F);
/* 438 */               ((EntityCusPar)entity).setRotate(rot);
/* 439 */               ((EntityCusPar)entity).setRotation_Sp(rotsp);
/* 440 */               entity.field_70170_p.func_72838_d(entity);
/*     */             }
/*     */           
/*     */           }
/*     */         
/* 445 */         } else if (getPartid() == 3) {
/*     */           
/* 447 */           if (this.field_70173_aa % 2 == 0) {
/*     */ 
/*     */             
/* 450 */             float life = 0.8F * this.user.field_70131_O;
/* 451 */             float extra_scale = 1.0F + ((this.user.field_70131_O > 2.1F) ? (this.user.field_70131_O / 2.0F) : 0.0F) / 5.0F;
/* 452 */             float width = this.user.field_70130_N * 3.0F;
/*     */             
/* 454 */             double x = (Math.random() * 1.0D - 0.5D) * (width * 0.8F);
/* 455 */             double y = Math.random() * (this.field_70131_O * 0.8F) - 0.6000000238418579D;
/* 456 */             double z = (Math.random() * 1.0D - 0.5D) * (width * 0.8F);
/*     */ 
/*     */ 
/*     */             
/* 460 */             double motx = Math.random() * 0.05000000074505806D - 0.029999999329447746D;
/* 461 */             double moty = (Math.random() * 0.10000000149011612D + 0.10000000149011612D) * (life * extra_scale) * 0.18D;
/* 462 */             double motz = Math.random() * 0.05000000074505806D - 0.029999999329447746D;
/*     */             
/* 464 */             float red = 255.0F, green = 217.0F, blue = 25.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 474 */             Entity entity = new EntityCusPar("jinryuudragonbc:bens_particles_attack.png", this.user.field_70170_p, 0.2F, 0.2F, this.user.field_70165_t, this.user.field_70163_u + ((this.user instanceof net.minecraft.client.entity.EntityPlayerSP) ? -1.6F : 0.0F), this.user.field_70161_v, x, y, z, motx, moty, motz, (float)(Math.random() * 0.009999999776482582D) - 0.005F, (int)(Math.random() * 3.0D) + 59, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", (int)(30.0F * life * 1.6F), 2, ((float)(Math.random() * 0.009999999776482582D) + 0.01F) * life * extra_scale, ((float)(Math.random() * 0.004999999888241291D) + 0.005F) * life * extra_scale, 0.03F * life * extra_scale, 0, red, green, blue, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2, 0.0F, 0.0F, 0.3F, 0.35F, 0.02F, false, -1, false, null);
/*     */ 
/*     */ 
/*     */             
/* 478 */             this.user.field_70170_p.func_72838_d(entity);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void generateParticles(EntityEng entityBlast, Entity entity, int color, int color2) {
/* 489 */     if (entityBlast != null && entity != null && entityBlast.field_70170_p.field_72995_K) {
/*     */       
/* 491 */       EntityPlayer user = entityBlast.user;
/* 492 */       int ticksExisted = entityBlast.field_70173_aa;
/* 493 */       float scale = ticksExisted * entityBlast.getSize() / 100.0F;
/* 494 */       if (scale > entityBlast.getSize()) scale = entityBlast.getSize();
/*     */ 
/*     */       
/* 497 */       for (int i = 0; i < 1.0F + scale; i++) {
/* 498 */         for (int k = 0; k < JGConfigClientSettings.get_da1(); k++) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 504 */           float colorFixer = 0.7F;
/*     */           
/* 506 */           float red = (color >> 16 & 0xFF) / 255.0F;
/* 507 */           float green = (color >> 8 & 0xFF) / 255.0F;
/* 508 */           float blue = (color & 0xFF) / 255.0F;
/* 509 */           red *= 0.7F; green *= 0.7F; blue *= 0.7F;
/*     */ 
/*     */ 
/*     */           
/* 513 */           float red2 = (color2 >> 16 & 0xFF) / 255.0F;
/* 514 */           float green2 = (color2 >> 8 & 0xFF) / 255.0F;
/* 515 */           float blue2 = (color2 & 0xFF) / 255.0F;
/*     */ 
/*     */           
/* 518 */           float alpha = (scale / 2.0F < 1.0F) ? (scale / 2.0F) : 1.0F;
/*     */ 
/*     */ 
/*     */           
/* 522 */           float out = 1.5F * scale, in = 1.5F;
/* 523 */           float life = 0.4F * entity.field_70131_O;
/* 524 */           float extra_scale = 0.2F;
/* 525 */           int dea = 30;
/* 526 */           float target_fullsize_one1 = 0.32F;
/* 527 */           float targetsizeMin = entity.field_70131_O * 8.0F / target_fullsize_one1 * 0.01F;
/*     */           
/* 529 */           float target_fullsize_one2 = 0.32F;
/* 530 */           float targetsizeMax = entity.field_70131_O * 26.0F / target_fullsize_one2 * 0.01F;
/*     */           
/* 532 */           double x = Math.random() * out - (out / 2.0F);
/* 533 */           double y = Math.random() * out - (out / 2.0F);
/* 534 */           double z = Math.random() * out - (out / 2.0F);
/*     */ 
/*     */           
/* 537 */           double x2 = 0.0D, y2 = 0.0D, z2 = 0.0D;
/* 538 */           x2 = entity.field_70165_t;
/* 539 */           y2 = entity.field_70163_u;
/* 540 */           z2 = entity.field_70161_v;
/*     */           
/* 542 */           y2 += ((entity instanceof net.minecraft.client.entity.EntityPlayerSP) ? -1.6F : 0.0F);
/*     */ 
/*     */           
/* 545 */           double motionX = 0.0D;
/* 546 */           double motionZ = 0.0D;
/* 547 */           double motionY = 0.0D;
/*     */ 
/*     */           
/* 550 */           float height = user.field_70131_O;
/* 551 */           float height2 = height * 0.8F;
/* 552 */           float width = user.field_70130_N;
/* 553 */           float width2 = width * 0.8F;
/*     */           
/* 555 */           if (entityBlast.isWave()) {
/*     */             
/* 557 */             Vec3 vec3 = entity.func_70040_Z();
/* 558 */             double kiX = 0.0D, kiY = 0.0D;
/* 559 */             kiX = 1.0D;
/* 560 */             kiY = -1.0D;
/*     */             
/* 562 */             double d8 = entity.field_70130_N + kiX;
/* 563 */             double d9 = entity.field_70131_O;
/*     */             
/* 565 */             x2 += vec3.field_72450_a * d8;
/* 566 */             y2 += vec3.field_72448_b * d8 + (height2 * 0.92F);
/* 567 */             z2 += vec3.field_72449_c * d8;
/*     */           }
/* 569 */           else if (entityBlast.isBlast() || entityBlast.isSpiral() || entityBlast.isLaser()) {
/*     */ 
/*     */             
/* 572 */             Vec3 vec3 = entity.func_70040_Z();
/* 573 */             double kiX = 0.0D, kiY = 0.0D;
/* 574 */             kiX = 1.0D;
/* 575 */             kiY = -1.0D;
/*     */             
/* 577 */             double d8 = entity.field_70130_N + kiX;
/* 578 */             double d9 = entity.field_70131_O;
/*     */             
/* 580 */             x2 += vec3.field_72450_a * d8;
/* 581 */             y2 += vec3.field_72448_b * d8 + (height2 * 0.92F);
/* 582 */             z2 += vec3.field_72449_c * d8;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           }
/* 592 */           else if (!entityBlast.isDisk()) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 612 */             if (entityBlast.isLargeBlast()) {
/*     */               
/* 614 */               double kiX = 0.0D, kiY = 0.0D;
/* 615 */               kiX = 1.0D;
/* 616 */               kiY = -1.0D;
/*     */ 
/*     */               
/* 619 */               y2 += (entity.field_70131_O + 1.0F + scale / 2.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             }
/* 626 */             else if (entityBlast.isShield() || entityBlast.isExplosion()) {
/*     */             
/*     */             } 
/* 629 */           }  x2 += x;
/* 630 */           y2 += y;
/* 631 */           z2 += z;
/*     */ 
/*     */           
/* 634 */           motionX = x * 0.02D;
/* 635 */           motionY = y * 0.02D;
/* 636 */           motionZ = z * 0.02D;
/*     */ 
/*     */           
/* 639 */           float scaleStart = ((float)(Math.random() * 0.019999999552965164D) + 0.02F) * life * 0.2F;
/* 640 */           float scaleEnd = ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.2F;
/* 641 */           float scaleSpeed = 0.2F * life * 0.2F;
/*     */           
/* 643 */           int textureID = (int)(Math.random() * 3.0D) + 8;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 653 */           Entity particle = new EntityCusPar("jinryuumodscore:bens_particles.png", entity.field_70170_p, 0.2F, 0.2F, x2, y2, z2, 0.0D, 0.0D, 0.0D, -motionX, -motionY, -motionZ, 0.0F, textureID, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 30, 2, scaleStart, scaleEnd, scaleStart, 0, red, green, blue, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.6F * alpha, 0.0F * alpha, 0.9F * alpha, 0.95F * alpha, 0.06F * alpha, false, -1, true, null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 665 */           entity.field_70170_p.func_72838_d(particle);
/*     */ 
/*     */ 
/*     */           
/* 669 */           Entity particle2 = new EntityCusPar("jinryuumodscore:bens_particles.png", entity.field_70170_p, 0.2F, 0.2F, x2, y2, z2, 0.0D, 0.0D, 0.0D, -motionX, -motionY, -motionZ, 0.0F, textureID, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 30, 2, scaleStart * 0.8F, scaleEnd * 0.8F, scaleStart * 0.8F, 0, red2, green2, blue2, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.6F * alpha, 0.0F * alpha, 0.9F * alpha, 0.95F * alpha, 0.06F * alpha, false, -1, true, null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 682 */           entity.field_70170_p.func_72838_d(particle2);
/*     */ 
/*     */ 
/*     */           
/* 686 */           if (!entityBlast.isWave())
/*     */           {
/* 688 */             if (!entityBlast.isBlast() && !entityBlast.isSpiral() && !entityBlast.isLaser())
/*     */             {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 700 */               if (!entityBlast.isDisk())
/*     */               {
/* 702 */                 if (!entityBlast.isLargeBlast())
/*     */                 {
/* 704 */                   if (entityBlast.isShield() || entityBlast.isExplosion()); }  }  }  } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public float rad(float angle) {
/* 711 */     return angle * 3.1415927F / 180.0F;
/*     */   }
/*     */   
/*     */   public boolean func_70112_a(double par1) {
/* 715 */     if (JGConfigClientSettings.renderdistanceMultiplierKiAttackCharge == 10000) return true; 
/* 716 */     double d1 = this.field_70121_D.func_72320_b();
/* 717 */     d1 *= 64.0D * this.field_70155_l;
/* 718 */     return (par1 < d1 * d1 * JGConfigClientSettings.renderdistanceMultiplierKiAttackCharge / 100.0D);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\entity\EntityEng.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */