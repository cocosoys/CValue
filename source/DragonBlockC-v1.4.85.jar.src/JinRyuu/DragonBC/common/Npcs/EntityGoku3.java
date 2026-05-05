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
/*     */ public class EntityGoku3
/*     */   extends EntityDBCEvil
/*     */ {
/*  15 */   public int randomSoundDelay = 0;
/*     */   public String tex;
/*  17 */   public final int AttPow = 16000;
/*  18 */   public final int HePo = 100000;
/*     */   private int target;
/*     */   
/*     */   public EntityGoku3(World par1World) {
/*  22 */     super(par1World);
/*  23 */     this.field_70728_aV = 200;
/*  24 */     this.tex = "goku_god";
/*  25 */     func_70105_a(0.6F, 2.0F);
/*  26 */     setData2(2);
/*  27 */     setHardDifficulty();
/*  28 */     addAAiTeleport();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  34 */     super.func_110147_ax();
/*  35 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(100000.0D);
/*  36 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(16000.0D);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*  40 */     return "jinryuudragonbc:npcs/" + this.tex + ".png";
/*     */   }
/*     */   public long BattlePowerOld() {
/*  43 */     int BP = -2122547200;
/*  44 */     int exp = this.field_70728_aV * 100;
/*  45 */     long BattlePower = (BP + this.field_70146_Z.nextInt((int)Math.pow(10.0D, ((BP + "").length() - 2))));
/*  46 */     return BattlePower;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/*  54 */     if (doBlst()) {
/*  55 */       int r = (int)(Math.random() * 3.0D);
/*  56 */       if (r == 0) {
/*  57 */         setData1(1);
/*  58 */         setData2(2);
/*     */       }
/*  60 */       else if (r == 1) {
/*  61 */         setData1(1);
/*  62 */         setData2(2);
/*     */       } else {
/*     */         
/*  65 */         setData1(6);
/*  66 */         setData2(7);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  71 */     if (this.field_70170_p.field_72995_K && JGConfigClientSettings.CLIENT_DA8) {
/*  72 */       float red = 215.0F, green = 107.0F, blue = 61.0F;
/*  73 */       float red2 = 218.0F, green2 = 209.0F, blue2 = 71.0F;
/*  74 */       float out = 1.6F, in = 1.5F;
/*  75 */       float life = 0.8F * this.field_70131_O;
/*  76 */       float extra_scale = 0.5F;
/*  77 */       int dea = 50;
/*     */       
/*  79 */       for (int k = 0; k < JGConfigClientSettings.get_da1(); k++) {
/*     */         int i;
/*  81 */         for (i = 0; i < 2; i++) {
/*  82 */           EntityGoku3 entityGoku31 = this;
/*     */           
/*  84 */           float spe2 = 1.3F;
/*  85 */           double d1 = Math.random() * spe2 - (spe2 / 2.0F);
/*  86 */           double d2 = -0.30000001192092896D;
/*  87 */           double d3 = Math.random() * spe2 - (spe2 / 2.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  95 */           EntityCusPar entityCusPar = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, ((Entity)entityGoku31).field_70165_t, ((Entity)entityGoku31).field_70163_u, ((Entity)entityGoku31).field_70161_v, d1, d2, d3, 0.0D, 0.05D + Math.random() * 0.10000000149011612D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 48, 48, 8, 32, false, 0.0F, false, 0.0F, 1, "", 25, 0, 0.003F + (float)(Math.random() * 0.006000000052154064D), 0.0F, 0.0F, 0, 255.0F, 220.0F, 200.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2, 0.8F, 0.0F, 0.9F, 0.95F, 0.02F, false, -1, false, (Entity)this);
/*     */ 
/*     */ 
/*     */           
/*  99 */           ((Entity)entityCusPar).field_70170_p.func_72838_d((Entity)entityCusPar);
/*     */         } 
/* 101 */         for (i = 0; i < 2; i++) {
/* 102 */           EntityGoku3 entityGoku31 = this;
/*     */           
/* 104 */           double d1 = Math.random() * 1.600000023841858D - 0.800000011920929D;
/* 105 */           double d2 = Math.random() * this.field_70131_O - 0.5D;
/* 106 */           double d3 = Math.random() * 1.600000023841858D - 0.800000011920929D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 114 */           EntityCusPar entityCusPar3 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, ((Entity)entityGoku31).field_70165_t, ((Entity)entityGoku31).field_70163_u, ((Entity)entityGoku31).field_70161_v, d1, d2, d3, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 215.0F, 107.0F, 61.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, false, (Entity)this);
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 119 */           d1 = Math.random() * 1.600000023841858D - 0.800000011920929D;
/* 120 */           d2 = Math.random() * this.field_70131_O - 0.5D;
/* 121 */           d3 = Math.random() * 1.600000023841858D - 0.800000011920929D;
/* 122 */           ((Entity)entityCusPar3).field_70170_p.func_72838_d((Entity)entityCusPar3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 131 */           EntityCusPar entityCusPar4 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, ((Entity)entityGoku31).field_70165_t, ((Entity)entityGoku31).field_70163_u, ((Entity)entityGoku31).field_70161_v, d1, d2, d3, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 215.0F, 107.0F, 61.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, false, (Entity)this);
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 136 */           ((Entity)entityCusPar3).field_70170_p.func_72838_d((Entity)entityCusPar4);
/*     */         } 
/*     */         
/* 139 */         EntityGoku3 entityGoku3 = this;
/*     */         
/* 141 */         double x = Math.random() * 1.5D - 0.75D;
/* 142 */         double y = (Math.random() * this.field_70131_O - 0.5D) * 0.800000011920929D;
/* 143 */         double z = Math.random() * 1.5D - 0.75D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 151 */         EntityCusPar entityCusPar1 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, ((Entity)entityGoku3).field_70165_t, ((Entity)entityGoku3).field_70163_u, ((Entity)entityGoku3).field_70161_v, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 218.0F, 209.0F, 71.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, false, (Entity)this);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 156 */         x = Math.random() * 1.5D - 0.75D;
/* 157 */         y = (Math.random() * this.field_70131_O - 0.5D) * 0.800000011920929D;
/* 158 */         z = Math.random() * 1.5D - 0.75D;
/* 159 */         ((Entity)entityCusPar1).field_70170_p.func_72838_d((Entity)entityCusPar1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 168 */         EntityCusPar entityCusPar2 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, ((Entity)entityGoku3).field_70165_t, ((Entity)entityGoku3).field_70163_u, ((Entity)entityGoku3).field_70161_v, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 218.0F, 209.0F, 71.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, false, (Entity)this);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 173 */         ((Entity)entityCusPar1).field_70170_p.func_72838_d((Entity)entityCusPar2);
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
/* 195 */     super.func_70636_d();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70645_a(DamageSource par1DamageSource) {
/* 200 */     Entity var3 = par1DamageSource.func_76346_g();
/* 201 */     if (var3 instanceof net.minecraft.entity.player.EntityPlayer)
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
/* 217 */       becomeAngryAt(var3);
/*     */     }
/*     */     
/* 220 */     super.func_70645_a(par1DamageSource);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void becomeAngryAt(Entity par1Entity) {
/* 228 */     this.field_70789_a = par1Entity;
/* 229 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/* 230 */     this.randomSoundDelay = this.field_70146_Z.nextInt(40);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityGoku3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */