/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
/*     */ import JinRyuu.JRMCore.entity.EntityCusPar;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public class EntityJiren2
/*     */   extends EntityDBCEvil
/*     */ {
/*  16 */   public int randomSoundDelay = 0;
/*     */   public String tex;
/*  18 */   public final int AttPow = 40000;
/*  19 */   public final int HePo = 180000;
/*     */   private int target;
/*     */   
/*     */   public EntityJiren2(World par1World) {
/*  23 */     super(par1World);
/*  24 */     this.field_70728_aV = 200;
/*  25 */     this.tex = "jiren_full_power";
/*  26 */     func_70105_a(0.7F, 2.8F);
/*  27 */     setData1(1);
/*  28 */     setData2(8);
/*  29 */     setHardDifficulty();
/*  30 */     addAAiTeleport();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  36 */     super.func_110147_ax();
/*  37 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(180000.0D);
/*  38 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(40000.0D);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*  42 */     return "jinryuudragonbc:npcs/" + this.tex + ".png";
/*     */   }
/*     */   public long BattlePowerOld() {
/*  45 */     int BP = 1185955840;
/*  46 */     int exp = this.field_70728_aV * 100;
/*  47 */     long BattlePower = (BP + this.field_70146_Z.nextInt((int)Math.pow(10.0D, ((BP + "").length() - 2))));
/*  48 */     return BattlePower;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/*  57 */     if (doBlst()) {
/*  58 */       int r = (int)(Math.random() * 3.0D);
/*  59 */       if (r == 0) {
/*  60 */         setData1(1);
/*  61 */         setData2(8);
/*     */       }
/*  63 */       else if (r == 1) {
/*  64 */         setData1(1);
/*  65 */         setData2(4);
/*     */       } else {
/*     */         
/*  68 */         setData1(5);
/*  69 */         setData2(4);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  75 */     if (this.field_70170_p.field_72995_K && JGConfigClientSettings.CLIENT_DA8)
/*     */     {
/*  77 */       for (int k = 0; k < JGConfigClientSettings.get_da1(); k++) {
/*     */         float red, green, blue, red2, green2, blue2, red3, green3, blue3;
/*  79 */         boolean bol4a = true, bol4 = true;
/*  80 */         EntityJiren2 entityJiren2 = this;
/*     */         
/*  82 */         double posXOth = ((Entity)entityJiren2).field_70165_t;
/*  83 */         double posYOth = ((Entity)entityJiren2).field_70163_u + ((entityJiren2 instanceof net.minecraft.client.entity.EntityPlayerSP) ? -1.6F : 0.0F);
/*  84 */         double posZOth = ((Entity)entityJiren2).field_70161_v;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  90 */         if (bol4a) {
/*     */           
/*  92 */           red = 189.0F; green = 26.0F; blue = 47.0F;
/*  93 */           red2 = 189.0F; green2 = 26.0F; blue2 = 47.0F;
/*  94 */           red3 = 248.0F; green3 = 231.0F; blue3 = 236.0F;
/*     */ 
/*     */         
/*     */         }
/*     */         else {
/*     */ 
/*     */           
/* 101 */           red = 141.0F; green = 158.0F; blue = 210.0F;
/* 102 */           red2 = 215.0F; green2 = 152.0F; blue2 = 219.0F;
/* 103 */           red3 = 243.0F; green3 = 247.0F; blue3 = 250.0F;
/*     */         } 
/*     */         
/* 106 */         float out = 1.6F, in = 1.5F;
/* 107 */         float life = 0.8F * ((Entity)entityJiren2).field_70131_O;
/* 108 */         float extra_scale = 0.5F;
/* 109 */         int dea = 50;
/* 110 */         float outNew = 1.6F;
/* 111 */         float target_fullsize_one1 = 0.32F;
/* 112 */         float targetsizeMin = ((Entity)entityJiren2).field_70131_O * 8.0F / target_fullsize_one1 * 0.01F;
/*     */         
/* 114 */         float target_fullsize_one2 = 0.32F;
/* 115 */         float targetsizeMax = ((Entity)entityJiren2).field_70131_O * 26.0F / target_fullsize_one2 * 0.01F;
/*     */         
/* 117 */         float alpha = 0.6F;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         int repeat2;
/*     */ 
/*     */ 
/*     */         
/* 126 */         for (repeat2 = 0; repeat2 < 4; repeat2++) {
/*     */           
/* 128 */           outNew = 1.7600001F;
/* 129 */           double y = (Math.random() * ((Entity)entityJiren2).field_70131_O - 0.5D) * 0.800000011920929D;
/* 130 */           double x = Math.random() * outNew - (outNew / 2.0F);
/* 131 */           double z = Math.random() * outNew - (outNew / 2.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 139 */           EntityCusPar entityCusPar = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, red, green, blue, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.18F, 0.21000001F, 0.006F, false, -1, true, (Entity)entityJiren2);
/*     */ 
/*     */ 
/*     */           
/* 143 */           ((Entity)entityCusPar).field_70170_p.func_72838_d((Entity)entityCusPar);
/*     */         } 
/*     */         
/* 146 */         for (repeat2 = 0; repeat2 < 4; repeat2++) {
/*     */           
/* 148 */           outNew = 1.7600001F;
/* 149 */           double y = (Math.random() * ((Entity)entityJiren2).field_70131_O - 0.5D) * 0.800000011920929D;
/* 150 */           double x = Math.random() * outNew - (outNew / 2.0F);
/* 151 */           double z = Math.random() * outNew - (outNew / 2.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 159 */           EntityCusPar entityCusPar = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, red, green, blue, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.18F, 0.21000001F, 0.006F, false, -1, true, (Entity)entityJiren2);
/*     */ 
/*     */ 
/*     */           
/* 163 */           ((Entity)entityCusPar).field_70170_p.func_72838_d((Entity)entityCusPar);
/*     */         } 
/*     */         
/* 166 */         if (this.field_70173_aa % 4 == 0) {
/*     */           
/* 168 */           double x = Math.random() * outNew - (outNew / 2.0F);
/* 169 */           double y = Math.random() * ((Entity)entityJiren2).field_70131_O - 0.5D;
/* 170 */           double z = Math.random() * outNew - (outNew / 2.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 178 */           EntityCusPar entityCusPar = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F * 0.5F, 0.2F * life * 0.5F * 0.5F, 0, red, green, blue, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.24000001F, 0.27F, 0.009000001F, false, -1, true, (Entity)entityJiren2);
/*     */ 
/*     */ 
/*     */           
/* 182 */           ((Entity)entityCusPar).field_70170_p.func_72838_d((Entity)entityCusPar);
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 187 */         if (bol4) {
/*     */           
/* 189 */           if (bol4a) {
/*     */             
/* 191 */             outNew = 1.8000001F;
/* 192 */             double y = (Math.random() * ((Entity)entityJiren2).field_70131_O - 0.5D) * 0.800000011920929D;
/* 193 */             double x = Math.random() * outNew - (outNew / 2.0F);
/* 194 */             double z = Math.random() * outNew - (outNew / 2.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 202 */             EntityCusPar entityCusPar = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, red2, green2, blue2, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.24000001F, 0.27F, 0.009000001F, false, -1, true, (Entity)entityJiren2);
/*     */ 
/*     */ 
/*     */             
/* 206 */             ((Entity)entityCusPar).field_70170_p.func_72838_d((Entity)entityCusPar);
/*     */ 
/*     */ 
/*     */             
/* 210 */             for (int i = 0; i < 1 + (bol4a ? 1 : 0); i++) {
/*     */               
/* 212 */               y = Math.random() * (targetsizeMax - targetsizeMin) + targetsizeMin;
/* 213 */               y -= 0.30000001192092896D;
/* 214 */               outNew = 1.9499999F;
/* 215 */               x = Math.random() * outNew - (outNew / 2.0F);
/* 216 */               z = Math.random() * outNew - (outNew / 2.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 224 */               EntityCusPar entityCusPar1 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, red2, green2, blue2, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.24000001F, 0.27F, 0.009000001F, false, -1, true, (Entity)entityJiren2);
/*     */ 
/*     */ 
/*     */               
/* 228 */               ((Entity)entityCusPar1).field_70170_p.func_72838_d((Entity)entityCusPar1);
/*     */             } 
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/* 234 */           if (this.field_70173_aa % (bol4a ? 1 : 4) == 0) {
/*     */             
/* 236 */             double x = Math.random() * 1.5D - 0.75D;
/* 237 */             double y = (Math.random() * ((Entity)entityJiren2).field_70131_O - 0.5D) * 0.800000011920929D;
/* 238 */             double z = Math.random() * 1.5D - 0.75D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 246 */             EntityCusPar entityCusPar = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.019999999552965164D) + 0.02F) * life * 0.5F * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F * 0.5F, 0.2F * life * 0.5F * 0.5F, 0, red2, green2, blue2, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F * (bol4a ? 1.2F : 1.0F) * 0.6F, 0.45F * (bol4a ? 1.2F : 1.0F) * 0.6F, 0.015F * (bol4a ? 1.2F : 1.0F) * 0.6F, false, -1, true, (Entity)entityJiren2);
/*     */ 
/*     */ 
/*     */             
/* 250 */             ((Entity)entityCusPar).field_70170_p.func_72838_d((Entity)entityCusPar);
/*     */           } 
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 256 */         float in2 = 0.6F;
/*     */         
/* 258 */         for (int repeat = 0; repeat < 3; repeat++) {
/*     */           
/* 260 */           outNew = 0.6F;
/* 261 */           double x = Math.random() * outNew - (outNew / 2.0F);
/* 262 */           double y = (Math.random() * ((Entity)entityJiren2).field_70131_O - 0.5D) * 0.800000011920929D * 0.6000000238418579D - 0.30000001192092896D;
/* 263 */           double z = Math.random() * outNew - (outNew / 2.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 271 */           EntityCusPar entityCusPar = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.03999999910593033D + 0.01D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 243.0F, 247.0F, 250.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.120000005F, 0.15F, 0.003F, false, -1, true, (Entity)entityJiren2);
/*     */ 
/*     */ 
/*     */           
/* 275 */           ((Entity)entityCusPar).field_70170_p.func_72838_d((Entity)entityCusPar);
/*     */           
/* 277 */           for (int i = 0; i < 2; i++) {
/*     */             
/* 279 */             y = Math.random() * (targetsizeMax - targetsizeMin) + targetsizeMin;
/* 280 */             y -= 0.30000001192092896D;
/*     */             
/* 282 */             outNew = 1.26F;
/* 283 */             x = Math.random() * outNew - (outNew / 2.0F);
/* 284 */             z = Math.random() * outNew - (outNew / 2.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 293 */             EntityCusPar entityCusPar1 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.03999999910593033D + 0.01D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 32, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, red3, green3, blue3, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.18F, 0.21000001F, 0.012F, false, -1, true, (Entity)entityJiren2);
/*     */ 
/*     */ 
/*     */             
/* 297 */             ((Entity)entityCusPar1).field_70170_p.func_72838_d((Entity)entityCusPar1);
/*     */           } 
/*     */         } 
/*     */         
/* 301 */         if (this.field_70173_aa % 4 == 0) {
/*     */           
/* 303 */           double x = Math.random() * 0.6000000238418579D - 0.30000001192092896D;
/* 304 */           double y = (Math.random() * ((Entity)entityJiren2).field_70131_O - 0.5D) * 0.800000011920929D;
/* 305 */           double z = Math.random() * 0.6000000238418579D - 0.30000001192092896D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 313 */           EntityCusPar entityCusPar1 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.029999999329447746D + 0.01D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F * 0.5F, 0.2F * life * 0.5F * 0.5F, 0, red3, green3, blue3, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.24000001F, 0.27F, 0.009000001F, false, -1, true, (Entity)entityJiren2);
/*     */ 
/*     */ 
/*     */           
/* 317 */           ((Entity)entityCusPar1).field_70170_p.func_72838_d((Entity)entityCusPar1);
/*     */ 
/*     */ 
/*     */           
/* 321 */           y = Math.random() * (targetsizeMax - targetsizeMin) + targetsizeMin;
/* 322 */           y -= 0.30000001192092896D;
/*     */           
/* 324 */           outNew = 1.26F;
/* 325 */           x = Math.random() * outNew - (outNew / 2.0F);
/* 326 */           z = Math.random() * outNew - (outNew / 2.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 334 */           EntityCusPar entityCusPar2 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.029999999329447746D + 0.01D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.019999999552965164D) + 0.02F) * life * 0.5F * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F * 0.5F, 0.2F * life * 0.5F * 0.5F, 0, red3, green3, blue3, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.24000001F, 0.27F, 0.009000001F, false, -1, true, (Entity)entityJiren2);
/*     */ 
/*     */ 
/*     */           
/* 338 */           ((Entity)entityCusPar2).field_70170_p.func_72838_d((Entity)entityCusPar2);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 362 */     super.func_70636_d();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70645_a(DamageSource par1DamageSource) {
/* 367 */     Entity var3 = par1DamageSource.func_76346_g();
/* 368 */     if (var3 instanceof net.minecraft.entity.player.EntityPlayer)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 384 */       becomeAngryAt(var3);
/*     */     }
/*     */     
/* 387 */     super.func_70645_a(par1DamageSource);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void becomeAngryAt(Entity par1Entity) {
/* 395 */     this.field_70789_a = par1Entity;
/* 396 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/* 397 */     this.randomSoundDelay = this.field_70146_Z.nextInt(40);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityJiren2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */