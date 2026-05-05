/*     */ package JinRyuu.DragonBC.common.Npcs.dbsbroly;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.Npcs.EntityDBCEvil;
/*     */ import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
/*     */ import JinRyuu.JRMCore.entity.EntityCusPar;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityDBSBrolyBuffSSJ
/*     */   extends EntityDBCEvil {
/*     */   public String tex;
/*  16 */   public final int AttPow = 40000;
/*  17 */   public final int HePo = 300000;
/*     */ 
/*     */   
/*     */   private int target;
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityDBSBrolyBuffSSJ(World par1World) {
/*  25 */     super(par1World);
/*  26 */     this.field_70728_aV = 200;
/*  27 */     this.tex = "dbsbrolybuffssj";
/*  28 */     func_70105_a(0.7F, 2.5F);
/*  29 */     setData1(1);
/*  30 */     setData2(6);
/*  31 */     this.kiAttackTimer = 70;
/*  32 */     setInsaneDifficulty();
/*  33 */     addAAiTeleport();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  39 */     super.func_110147_ax();
/*  40 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(300000.0D);
/*  41 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(40000.0D);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*  45 */     return "jinryuudragonbc:npcs/" + this.tex + ".png";
/*     */   }
/*     */   public long BattlePowerOld() {
/*  48 */     int BP = -886718464;
/*  49 */     int exp = this.field_70728_aV * 100;
/*  50 */     long BattlePower = (BP + this.field_70146_Z.nextInt((int)Math.pow(10.0D, ((BP + "").length() - 2))));
/*  51 */     return BattlePower;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/*  56 */     if (doBlst()) {
/*  57 */       int r = (int)(Math.random() * 3.0D);
/*  58 */       if (r == 0) {
/*  59 */         setData1(1);
/*  60 */         setData2(6);
/*     */       }
/*  62 */       else if (r == 1) {
/*  63 */         setData1(3);
/*  64 */         setData2(6);
/*     */       } else {
/*     */         
/*  67 */         setData1(6);
/*  68 */         setData2(6);
/*     */       } 
/*     */     } 
/*     */     
/*  72 */     if (this.field_70170_p.field_72995_K && JGConfigClientSettings.CLIENT_DA8) {
/*  73 */       for (int k = 0; k < JGConfigClientSettings.get_da1(); k++) {
/*  74 */         for (int i = 0; i < 5; i++) {
/*  75 */           EntityDBSBrolyBuffSSJ entityDBSBrolyBuffSSJ = this;
/*     */ 
/*     */           
/*  78 */           float a = 0.5F, h1 = 1.0F;
/*  79 */           float red = 183.0F, green = 205.0F, blue = 97.0F;
/*     */ 
/*     */ 
/*     */           
/*  83 */           float life = 0.8F * ((Entity)entityDBSBrolyBuffSSJ).field_70131_O;
/*  84 */           float extra_scale = 1.0F + ((((Entity)entityDBSBrolyBuffSSJ).field_70131_O > 2.1F) ? (((Entity)entityDBSBrolyBuffSSJ).field_70131_O / 2.0F) : 0.0F) / 5.0F;
/*  85 */           float width = ((Entity)entityDBSBrolyBuffSSJ).field_70130_N * 3.0F;
/*     */           
/*  87 */           double x = (Math.random() * 1.0D - 0.5D) * (width * 1.2F);
/*  88 */           double y = Math.random() * (this.field_70131_O * 1.4F) - (this.field_70131_O / 2.0F) - 0.30000001192092896D;
/*  89 */           double z = (Math.random() * 1.0D - 0.5D) * (width * 1.2F);
/*     */ 
/*     */ 
/*     */           
/*  93 */           double motx = Math.random() * 0.019999999552965164D - 0.009999999776482582D;
/*  94 */           double moty = (Math.random() * 0.8999999761581421D + 0.8999999761581421D) * (life * extra_scale) * 0.07D;
/*  95 */           double motz = Math.random() * 0.019999999552965164D - 0.009999999776482582D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 105 */           EntityCusPar entityCusPar2 = new EntityCusPar("jinryuumodscore:bens_particles.png", ((Entity)entityDBSBrolyBuffSSJ).field_70170_p, 0.2F, 0.2F, ((Entity)entityDBSBrolyBuffSSJ).field_70165_t, ((Entity)entityDBSBrolyBuffSSJ).field_70163_u + ((entityDBSBrolyBuffSSJ instanceof net.minecraft.client.entity.EntityPlayerSP) ? -1.6F : 0.0F), ((Entity)entityDBSBrolyBuffSSJ).field_70161_v, x, y, z, motx, moty, motz, 0.0F, (int)(Math.random() * 3.0D) + 32, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", (int)(30.0F * life * 0.5F), 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * extra_scale, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * extra_scale, 0.2F * life * extra_scale, 0, red, green, blue, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.08F, false, -1, true, (Entity)entityDBSBrolyBuffSSJ);
/*     */ 
/*     */ 
/*     */           
/* 109 */           ((Entity)entityDBSBrolyBuffSSJ).field_70170_p.func_72838_d((Entity)entityCusPar2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 119 */           EntityCusPar entityCusPar1 = new EntityCusPar("jinryuudragonbc:bens_particles.png", ((Entity)entityDBSBrolyBuffSSJ).field_70170_p, 0.2F, 0.2F, ((Entity)entityDBSBrolyBuffSSJ).field_70165_t, ((Entity)entityDBSBrolyBuffSSJ).field_70163_u + ((entityDBSBrolyBuffSSJ instanceof net.minecraft.client.entity.EntityPlayerSP) ? -1.6F : 0.0F), ((Entity)entityDBSBrolyBuffSSJ).field_70161_v, x, y, z, motx, moty, motz, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", (int)(30.0F * life * 0.5F), 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * extra_scale, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * extra_scale, 0.1F * life * extra_scale, 0, red, green, blue, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.08F, false, -1, true, (Entity)entityDBSBrolyBuffSSJ);
/*     */ 
/*     */ 
/*     */           
/* 123 */           ((Entity)entityDBSBrolyBuffSSJ).field_70170_p.func_72838_d((Entity)entityCusPar1);
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
/* 146 */     super.func_70636_d();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70645_a(DamageSource par1DamageSource) {
/* 151 */     Entity var3 = par1DamageSource.func_76346_g();
/* 152 */     if (var3 instanceof net.minecraft.entity.player.EntityPlayer)
/*     */     {
/* 154 */       becomeAngryAt(var3);
/*     */     }
/*     */     
/* 157 */     super.func_70645_a(par1DamageSource);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void becomeAngryAt(Entity par1Entity) {
/* 165 */     this.field_70789_a = par1Entity;
/* 166 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbsbroly\EntityDBSBrolyBuffSSJ.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */