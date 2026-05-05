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
/*     */ public class EntityGokuBlackRose
/*     */   extends EntityDBCEvil
/*     */ {
/*  15 */   public int randomSoundDelay = 0;
/*     */   public String tex;
/*  17 */   public final int AttPow = 20000;
/*  18 */   public final int HePo = 120000;
/*     */   private int target;
/*     */   
/*     */   public EntityGokuBlackRose(World par1World) {
/*  22 */     super(par1World);
/*  23 */     this.field_70728_aV = 200;
/*  24 */     this.tex = "gokublackrose";
/*  25 */     func_70105_a(0.6F, 2.0F);
/*  26 */     setHardDifficulty();
/*  27 */     addAAiTeleport("jinryuudragonbc:DBC4.blacktp");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  33 */     super.func_110147_ax();
/*  34 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(120000.0D);
/*  35 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(20000.0D);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*  39 */     return "jinryuudragonbc:npcs/" + this.tex + ".png";
/*     */   }
/*     */   public long BattlePowerOld() {
/*  42 */     int BP = -1036337152;
/*  43 */     int exp = this.field_70728_aV * 100;
/*  44 */     long BattlePower = (BP + this.field_70146_Z.nextInt((int)Math.pow(10.0D, ((BP + "").length() - 2))));
/*  45 */     return BattlePower;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/*  53 */     if (doBlst()) {
/*  54 */       int r = (int)(Math.random() * 3.0D);
/*  55 */       if (r == 0) {
/*  56 */         setData1(1);
/*  57 */         setData2(7);
/*     */       }
/*  59 */       else if (r == 1) {
/*  60 */         setData1(1);
/*  61 */         setData2(0);
/*     */       } else {
/*     */         
/*  64 */         setData1(5);
/*  65 */         setData2(1);
/*     */       } 
/*     */     } 
/*     */     
/*  69 */     if (this.field_70170_p.field_72995_K && JGConfigClientSettings.CLIENT_DA8) {
/*  70 */       for (int k = 0; k < JGConfigClientSettings.get_da1(); k++) {
/*     */         
/*  72 */         float red = 186.0F, green = 37.0F, blue = 197.0F;
/*  73 */         float red2 = 140.0F, green2 = 8.0F, blue2 = 62.0F;
/*  74 */         float out = 1.6F, in = 1.0F;
/*  75 */         float life = 0.8F * this.field_70131_O;
/*  76 */         float extra_scale = 0.5F;
/*  77 */         int dea = 50;
/*  78 */         EntityGokuBlackRose entityGokuBlackRose = this;
/*     */ 
/*     */         
/*  81 */         for (int gh = 0; gh < 2; gh++) {
/*  82 */           double d1 = Math.random() * out - (out / 2.0F);
/*  83 */           double d2 = Math.random() * this.field_70131_O - 0.5D;
/*  84 */           double d3 = Math.random() * out - (out / 2.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  92 */           EntityCusPar entityCusPar7 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, ((Entity)entityGokuBlackRose).field_70165_t, ((Entity)entityGokuBlackRose).field_70163_u, ((Entity)entityGokuBlackRose).field_70161_v, d1, d2, d3, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 186.0F, 37.0F, 197.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, false, (Entity)entityGokuBlackRose);
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  97 */           d1 = Math.random() * out - (out / 2.0F);
/*  98 */           d2 = Math.random() * this.field_70131_O - 0.5D;
/*  99 */           d3 = Math.random() * out - (out / 2.0F);
/* 100 */           ((Entity)entityCusPar7).field_70170_p.func_72838_d((Entity)entityCusPar7);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 109 */           EntityCusPar entityCusPar8 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, ((Entity)entityGokuBlackRose).field_70165_t, ((Entity)entityGokuBlackRose).field_70163_u, ((Entity)entityGokuBlackRose).field_70161_v, d1, d2, d3, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 186.0F, 37.0F, 197.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, false, (Entity)entityGokuBlackRose);
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 114 */           ((Entity)entityCusPar7).field_70170_p.func_72838_d((Entity)entityCusPar8);
/*     */         } 
/*     */         
/* 117 */         out *= 1.4F;
/* 118 */         double x = Math.random() * out - (out / 2.0F);
/* 119 */         double y = Math.random() * this.field_70131_O - 0.5D;
/* 120 */         double z = Math.random() * out - (out / 2.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 128 */         EntityCusPar entityCusPar3 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, ((Entity)entityGokuBlackRose).field_70165_t, ((Entity)entityGokuBlackRose).field_70163_u, ((Entity)entityGokuBlackRose).field_70161_v, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 140.0F, 8.0F, 62.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, false, (Entity)entityGokuBlackRose);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 133 */         x = Math.random() * out - (out / 2.0F);
/* 134 */         y = Math.random() * this.field_70131_O - 0.5D;
/* 135 */         z = Math.random() * out - (out / 2.0F);
/* 136 */         ((Entity)entityCusPar3).field_70170_p.func_72838_d((Entity)entityCusPar3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 145 */         EntityCusPar entityCusPar6 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, ((Entity)entityGokuBlackRose).field_70165_t, ((Entity)entityGokuBlackRose).field_70163_u, ((Entity)entityGokuBlackRose).field_70161_v, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 140.0F, 8.0F, 62.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, false, (Entity)entityGokuBlackRose);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 150 */         ((Entity)entityCusPar3).field_70170_p.func_72838_d((Entity)entityCusPar6);
/*     */ 
/*     */         
/* 153 */         x = Math.random() * in - (in / 2.0F);
/* 154 */         y = (Math.random() * this.field_70131_O - 0.5D) * 0.800000011920929D;
/* 155 */         z = Math.random() * in - (in / 2.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 163 */         EntityCusPar entityCusPar2 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, ((Entity)entityGokuBlackRose).field_70165_t, ((Entity)entityGokuBlackRose).field_70163_u, ((Entity)entityGokuBlackRose).field_70161_v, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 184.0F, 147.0F, 241.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, false, (Entity)entityGokuBlackRose);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 168 */         x = Math.random() * in - (in / 2.0F);
/* 169 */         y = (Math.random() * this.field_70131_O - 0.5D) * 0.800000011920929D;
/* 170 */         z = Math.random() * in - (in / 2.0F);
/* 171 */         ((Entity)entityCusPar2).field_70170_p.func_72838_d((Entity)entityCusPar2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 180 */         EntityCusPar entityCusPar5 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, ((Entity)entityGokuBlackRose).field_70165_t, ((Entity)entityGokuBlackRose).field_70163_u, ((Entity)entityGokuBlackRose).field_70161_v, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 184.0F, 147.0F, 241.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, false, (Entity)entityGokuBlackRose);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 185 */         ((Entity)entityCusPar2).field_70170_p.func_72838_d((Entity)entityCusPar5);
/*     */ 
/*     */         
/* 188 */         in *= 1.2F;
/* 189 */         x = Math.random() * in - (in / 2.0F);
/* 190 */         y = (Math.random() * this.field_70131_O - 0.5D) * 0.800000011920929D;
/* 191 */         z = Math.random() * in - (in / 2.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 199 */         EntityCusPar entityCusPar1 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, ((Entity)entityGokuBlackRose).field_70165_t, ((Entity)entityGokuBlackRose).field_70163_u, ((Entity)entityGokuBlackRose).field_70161_v, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 93.0F, 3.0F, 177.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, false, (Entity)entityGokuBlackRose);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 204 */         x = Math.random() * in - (in / 2.0F);
/* 205 */         y = (Math.random() * this.field_70131_O - 0.5D) * 0.800000011920929D;
/* 206 */         z = Math.random() * in - (in / 2.0F);
/* 207 */         ((Entity)entityCusPar1).field_70170_p.func_72838_d((Entity)entityCusPar1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 216 */         EntityCusPar entityCusPar4 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, ((Entity)entityGokuBlackRose).field_70165_t, ((Entity)entityGokuBlackRose).field_70163_u, ((Entity)entityGokuBlackRose).field_70161_v, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 93.0F, 3.0F, 177.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, false, (Entity)entityGokuBlackRose);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 221 */         ((Entity)entityCusPar1).field_70170_p.func_72838_d((Entity)entityCusPar4);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 375 */     super.func_70636_d();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70645_a(DamageSource par1DamageSource) {
/* 380 */     Entity var3 = par1DamageSource.func_76346_g();
/* 381 */     if (var3 instanceof net.minecraft.entity.player.EntityPlayer)
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
/* 397 */       becomeAngryAt(var3);
/*     */     }
/*     */     
/* 400 */     super.func_70645_a(par1DamageSource);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void becomeAngryAt(Entity par1Entity) {
/* 408 */     this.field_70789_a = par1Entity;
/* 409 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/* 410 */     this.randomSoundDelay = this.field_70146_Z.nextInt(40);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityGokuBlackRose.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */