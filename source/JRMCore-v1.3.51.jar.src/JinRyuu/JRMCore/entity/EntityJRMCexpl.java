/*     */ package JinRyuu.JRMCore.entity;
/*     */ 
/*     */ import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
/*     */ import JinRyuu.JRMCore.mod_JRMCore;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class EntityJRMCexpl
/*     */   extends Entity {
/*  15 */   public int randomSoundDelay = 0;
/*     */   
/*  17 */   public int tex = 1; public float explsiz; public byte type;
/*     */   int Age;
/*     */   int MaxAge;
/*     */   
/*     */   public EntityJRMCexpl(World par1World, byte type) {
/*  22 */     super(par1World);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  27 */     this.MaxAge = 40;
/*     */     this.type = type;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/*  34 */     if (this.field_70170_p.field_72995_K && JGConfigClientSettings.CLIENT_GR4) {
/*  35 */       for (int k = 0; k < JGConfigClientSettings.get_da1(); k++) {
/*     */         
/*  37 */         if (this.type == 10) {
/*  38 */           if (this.field_70173_aa % 2 == 0 && this.field_70173_aa < 10) {
/*  39 */             Entity pl = this;
/*  40 */             float area = this.explsiz;
/*     */             
/*  42 */             for (int i = 0; i < (int)area + 5; i++) {
/*  43 */               float a = 1.0F, h1 = 1.0F;
/*  44 */               float scale = 1.0F + area;
/*  45 */               scale *= 0.01F;
/*     */ 
/*     */               
/*  48 */               double x = 0.0D;
/*  49 */               double y = 0.0D;
/*  50 */               double z = 0.0D;
/*  51 */               float size1 = 0.3F;
/*     */               
/*  53 */               float motx = ((float)(Math.random() * size1) - size1 / 2.0F) * area / 5.0F;
/*  54 */               float moty = (float)(Math.random() * size1 / 2.0D) * area / 5.0F;
/*  55 */               float motz = ((float)(Math.random() * size1) - size1 / 2.0F) * area / 5.0F;
/*  56 */               motx *= 0.1F;
/*  57 */               moty *= 0.8F;
/*  58 */               motz *= 0.1F;
/*  59 */               float size = area;
/*  60 */               x = ((float)(Math.random() * size) - size / 2.0F);
/*  61 */               y = ((float)(Math.random() * size) - size / 2.0F);
/*  62 */               z = ((float)(Math.random() * size) - size / 2.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/*  70 */               Entity entity7 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.4F, 0.4F, pl.field_70165_t, pl.field_70163_u, pl.field_70161_v, x, y, z, motx, moty, motz, 0.0F, 10, 12, 4, 32, true, (float)(Math.random() * 0.30000001192092896D) + 0.3F, false, 0.0F, 1, "", 50, 1, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * scale, ((float)(Math.random() * 0.019999999552965164D) + 0.09F) * scale, ((float)(Math.random() * 0.0020000000949949026D) + 0.003F) * scale, 1, 0.9647059F, 0.38431373F, 0.98039216F, -0.01F, -0.001F, -0.001F, 0.8392157F, 0.32941177F, 0.9137255F, 3, 1.0F, 0.0F, 0.0F, 0.0F, -0.05F, false, -1, false, null);
/*     */ 
/*     */ 
/*     */ 
/*     */               
/*  75 */               ((EntityCusPar)entity7).setdata39((int)(Math.random() * 360.0D));
/*     */               
/*  77 */               this.field_70170_p.func_72838_d(entity7);
/*     */             }
/*     */           
/*     */           }
/*     */         
/*  82 */         } else if (this.field_70173_aa == 1 && (this.type == 3 || this.type == 4)) {
/*     */           
/*  84 */           if (this.type == 3) this.field_70170_p.func_72838_d(new EntityEnergyAttJ4(this.field_70170_p, (byte)0, this.field_70165_t, this.field_70163_u + 1.0D, this.field_70161_v)); 
/*  85 */           if (this.type == 4) this.field_70170_p.func_72838_d(new EntityEnergyAttJ4(this.field_70170_p, (byte)1, this.field_70165_t, this.field_70163_u + 1.0D, this.field_70161_v));
/*     */         
/*     */         } else {
/*     */           
/*  89 */           if (this.field_70173_aa == 1)
/*     */           {
/*  91 */             if (this.type != 5) {
/*     */               
/*  93 */               if (this.type != 0)
/*     */               {
/*  95 */                 if (JGConfigClientSettings.CLIENT_DA6)
/*     */                 {
/*  97 */                   if (this.type != 3 && this.type != 4)
/*     */                   {
/*  99 */                     float a = 1.0F, h1 = 1.0F;
/* 100 */                     float scale = 1.0F + this.explsiz;
/* 101 */                     scale *= 1.2F;
/*     */ 
/*     */                     
/* 104 */                     Entity pl = this;
/*     */                     
/* 106 */                     double x = 0.0D;
/* 107 */                     double y = 0.0D;
/* 108 */                     double z = 0.0D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                     
/* 117 */                     Entity entity7 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.4F, 0.4F, pl.field_70165_t, pl.field_70163_u, pl.field_70161_v, x, y, z, 0.0D, 0.0D, 0.0D, 0.0F, (int)(Math.random() * 2.0D) + 12, 12, 4, 32, true, (float)(Math.random() * 0.30000001192092896D) + 0.3F, false, 0.0F, 1, "", 30, 1, ((float)(Math.random() * 0.019999999552965164D) + 0.02F) * scale, ((float)(Math.random() * 0.03999999910593033D) + 0.09F) * scale, ((float)(Math.random() * 0.003000000026077032D) + 0.005F) * scale, 0, 116.0F, 187.0F, 255.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 3, 1.0F, 0.0F, 0.0F, 0.0F, -0.05F, false, -1, false, null);
/*     */ 
/*     */ 
/*     */                     
/* 121 */                     ((EntityCusPar)entity7).setdata39((int)(Math.random() * 360.0D));
/* 122 */                     this.field_70170_p.func_72838_d(entity7);
/*     */                     
/* 124 */                     scale *= 0.65F;
/* 125 */                     int num = (int)(Math.random() * 4.0D) + 1;
/* 126 */                     for (int i = 0; i < num; i++)
/*     */                     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                       
/* 134 */                       Entity entity = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.4F, 0.4F, pl.field_70165_t, pl.field_70163_u, pl.field_70161_v, x, y, z, 0.0D, 0.0D, 0.0D, 0.0F, (int)(Math.random() * 2.0D) + 6, 4, 4, 64, true, (float)(Math.random() * 0.20000000298023224D) + 0.2F, false, 0.0F, 1, "", 15, 1, ((float)(Math.random() * 0.019999999552965164D) + 0.02F) * scale, ((float)(Math.random() * 0.03999999910593033D) + 0.09F) * scale, ((float)(Math.random() * 0.003000000026077032D) + 0.005F) * scale, 0, 116.0F, 187.0F, 255.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 3, 1.0F, 0.0F, 0.0F, 0.0F, -0.05F, false, -1, false, null);
/*     */ 
/*     */ 
/*     */                       
/* 138 */                       ((EntityCusPar)entity).setdata39((int)(Math.random() * 360.0D));
/* 139 */                       this.field_70170_p.func_72838_d(entity);
/*     */                     
/*     */                     }
/*     */                   
/*     */                   }
/*     */                 
/*     */                 }
/*     */                 else
/*     */                 {
/* 148 */                   if (this.type == 5) {
/* 149 */                     for (int j = 0; j < 5; j++) {
/* 150 */                       if (this.field_70173_aa % 2 == 0) {
/* 151 */                         func_exa();
/* 152 */                         func_ex3();
/*     */                       } 
/*     */                     } 
/*     */                   }
/*     */                   
/* 157 */                   for (int i = 0; i < 5; i++) {
/* 158 */                     if (this.type == 1) {
/* 159 */                       if (this.explsiz > 0.5F) {
/* 160 */                         func_exa();
/*     */                       }
/*     */                     }
/* 163 */                     else if (this.type == 2) {
/* 164 */                       for (int j = 0; j < 2; j++) {
/* 165 */                         func_ex3();
/*     */                       }
/*     */                     }
/*     */                   
/*     */                   }
/*     */                 
/*     */                 }
/*     */               
/*     */               }
/* 174 */             } else if (this.field_70173_aa < 15 && this.field_70173_aa % 2 == 0) {
/* 175 */               func_exa();
/*     */             } 
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 184 */           if (this.type != 5) {
/*     */ 
/*     */ 
/*     */             
/* 188 */             if (JGConfigClientSettings.CLIENT_DA6) {
/*     */               
/* 190 */               if (this.type != 3 && this.type != 4 && this.type != 0 && 
/* 191 */                 this.field_70173_aa < 10)
/*     */               {
/*     */                 
/* 194 */                 Entity pl = this; int i;
/* 195 */                 for (i = 0; i < (int)this.explsiz + 5; i++) {
/* 196 */                   float a = 1.0F, h1 = 1.0F;
/* 197 */                   float scale = 1.0F + this.explsiz;
/* 198 */                   scale *= 0.4F;
/*     */ 
/*     */                   
/* 201 */                   double x = 0.0D;
/* 202 */                   double y = 0.0D;
/* 203 */                   double z = 0.0D;
/* 204 */                   float size1 = 0.5F;
/*     */                   
/* 206 */                   float motx = ((float)(Math.random() * size1) - size1 / 2.0F) * this.explsiz / 5.0F;
/* 207 */                   float moty = ((float)(Math.random() * size1) - size1 / 2.0F) * this.explsiz / 5.0F;
/* 208 */                   float motz = ((float)(Math.random() * size1) - size1 / 2.0F) * this.explsiz / 5.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                   
/* 216 */                   Entity entity7 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.4F, 0.4F, pl.field_70165_t, pl.field_70163_u, pl.field_70161_v, x, y, z, motx, moty, motz, 0.0F, 10, 12, 4, 32, true, (float)(Math.random() * 0.30000001192092896D) + 0.3F, false, 0.0F, 1, "", 50, 1, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * scale, ((float)(Math.random() * 0.019999999552965164D) + 0.09F) * scale, ((float)(Math.random() * 0.0020000000949949026D) + 0.003F) * scale, 1, 116.0F, 187.0F, 255.0F, -0.02F, -0.02F, -0.03F, 56.0F, 67.0F, 100.0F, 3, 1.0F, 0.0F, 0.0F, 0.0F, -0.05F, false, -1, false, null);
/*     */ 
/*     */ 
/*     */ 
/*     */                   
/* 221 */                   ((EntityCusPar)entity7).setdata39((int)(Math.random() * 360.0D));
/* 222 */                   this.field_70170_p.func_72838_d(entity7);
/*     */                 } 
/*     */ 
/*     */                 
/* 226 */                 for (i = 0; i < (int)this.explsiz + 5; i++) {
/* 227 */                   float a = 1.0F, h1 = 1.0F;
/* 228 */                   float scale = 1.0F + this.explsiz;
/* 229 */                   scale *= 0.25F;
/*     */ 
/*     */                   
/* 232 */                   double x = 0.0D;
/* 233 */                   double y = 0.0D;
/* 234 */                   double z = 0.0D;
/* 235 */                   float size1 = 0.3F;
/*     */                   
/* 237 */                   float motx = ((float)(Math.random() * size1) - size1 / 2.0F) * this.explsiz / 5.0F;
/* 238 */                   float moty = ((float)(Math.random() * size1) - size1 / 2.0F) * this.explsiz / 5.0F;
/* 239 */                   float motz = ((float)(Math.random() * size1) - size1 / 2.0F) * this.explsiz / 5.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                   
/* 247 */                   Entity entity7 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.4F, 0.4F, pl.field_70165_t, pl.field_70163_u, pl.field_70161_v, x, y, z, motx, moty, motz, 0.0F, 10, 12, 4, 32, true, (float)(Math.random() * 0.30000001192092896D) + 0.3F, false, 0.0F, 1, "", 50, 1, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * scale, ((float)(Math.random() * 0.019999999552965164D) + 0.09F) * scale, ((float)(Math.random() * 0.0020000000949949026D) + 0.003F) * scale, 1, 1.0F, 1.0F, 1.0F, -0.01F, -0.005F, -0.005F, 216.0F, 244.0F, 245.0F, 3, 1.0F, 0.0F, 0.0F, 0.0F, -0.05F, false, -1, false, null);
/*     */ 
/*     */ 
/*     */                   
/* 251 */                   ((EntityCusPar)entity7).setdata39((int)(Math.random() * 360.0D));
/* 252 */                   this.field_70170_p.func_72838_d(entity7);
/*     */                 
/*     */                 }
/*     */               
/*     */               }
/*     */             
/*     */             }
/* 259 */             else if (this.type == 1) {
/*     */               
/* 261 */               if (this.explsiz > 0.5F && this.MaxAge * 0.8F >= this.Age) {
/* 262 */                 func_exa();
/*     */               }
/*     */             } 
/*     */ 
/*     */             
/* 267 */             if (this.type == 0)
/*     */             {
/* 269 */               func_ex1();
/* 270 */               mod_JRMCore.proxy.func_gcp(this, EntityCusPars.PART1, 
/* 271 */                   Math.random() * 4.0D - 2.0D, 0.0D + 
/* 272 */                   Math.random() * (this.field_70131_O * 0.25F) + (this.field_70131_O / 2.0F) - (this.field_70131_O * 0.25F), 
/* 273 */                   Math.random() * 4.0D - 2.0D, 
/* 274 */                   Math.random() * 0.05D - 0.025D, 
/* 275 */                   Math.random() * 0.1D + 0.05D, 
/* 276 */                   Math.random() * 0.05D - 0.025D, 0.5F, 0.5F, 0.5F);
/*     */ 
/*     */             
/*     */             }
/*     */ 
/*     */ 
/*     */           
/*     */           }
/* 284 */           else if (this.field_70173_aa < 15 && this.field_70173_aa % 2 == 0) {
/* 285 */             func_exa();
/*     */           } 
/*     */         } 
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
/* 301 */     this.field_70169_q = this.field_70165_t;
/* 302 */     this.field_70167_r = this.field_70163_u;
/* 303 */     this.field_70166_s = this.field_70161_v;
/* 304 */     if (this.Age++ >= this.MaxAge)
/*     */     {
/* 306 */       func_70106_y();
/*     */     }
/*     */     
/* 309 */     this.field_70181_x += 0.0D;
/* 310 */     func_70091_d(0.0D, 0.0D, 0.0D);
/* 311 */     if (this.field_70163_u == this.field_70167_r) {
/*     */       
/* 313 */       this.field_70159_w *= 1.0D;
/* 314 */       this.field_70179_y *= 1.0D;
/*     */     } 
/* 316 */     this.field_70159_w *= 0.0D;
/* 317 */     this.field_70181_x *= 0.0D;
/* 318 */     this.field_70179_y *= 0.0D;
/* 319 */     if (this.field_70122_E) {
/*     */       
/* 321 */       this.field_70159_w *= 0.0D;
/* 322 */       this.field_70179_y *= 0.0D;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void func_exa() {
/* 328 */     func_ex1();
/* 329 */     func_ex2();
/* 330 */     func_ex3();
/*     */   }
/*     */ 
/*     */   
/*     */   private void func_ex1() {
/* 335 */     mod_JRMCore.proxy.func_gcp(this, EntityCusPars.PART2, 
/* 336 */         Math.random() * 6.0D - 3.0D, 0.0D + (this.field_70131_O / 2.0F), 
/*     */         
/* 338 */         Math.random() * 6.0D - 3.0D, 
/* 339 */         Math.random() * 0.2D - 0.1D, 
/* 340 */         Math.random() * 0.2D + 0.1D, 
/* 341 */         Math.random() * 0.2D - 0.1D, 1.0F, 1.0F, 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void func_ex2() {
/* 348 */     mod_JRMCore.proxy.func_gcp(this, EntityCusPars.PART3, 
/* 349 */         Math.random() * 6.0D - 3.0D, 0.0D + (this.field_70131_O / 2.0F), 
/*     */         
/* 351 */         Math.random() * 6.0D - 3.0D, 
/* 352 */         Math.random() * 0.1D - 0.075D, 
/* 353 */         Math.random() * 0.2D + 0.1D, 
/* 354 */         Math.random() * 0.15D - 0.075D, 0.5F, 0.5F, 0.5F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void func_ex3() {
/* 361 */     mod_JRMCore.proxy.func_gcp(this, EntityCusPars.PART4, 
/* 362 */         Math.random() * 4.0D - 2.0D, 0.0D + (this.field_70131_O / 2.0F), 
/*     */         
/* 364 */         Math.random() * 4.0D - 2.0D, 
/* 365 */         Math.random() * 1.2D - 0.6D, 
/* 366 */         Math.random() * 0.2D + 0.1D, 
/* 367 */         Math.random() * 1.2D - 0.6D, 0.05F, 0.01F, 0.1F);
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
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/* 380 */     String textura = "";
/* 381 */     return textura;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 389 */     return !this.field_70170_p.func_72855_b(this.field_70121_D);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {}
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {}
/*     */ 
/*     */   
/*     */   protected void func_70037_a(NBTTagCompound var1) {}
/*     */   
/*     */   protected void func_70014_b(NBTTagCompound var1) {}
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean isInRangeToRenderVec3D(Vec3 par1Vec3) {
/* 405 */     return true;
/*     */   } @SideOnly(Side.CLIENT)
/* 407 */   public double getMaxRenderDistanceSquared() { return 65536.0D; } public boolean func_70112_a(double par1) {
/* 408 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\entity\EntityJRMCexpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */